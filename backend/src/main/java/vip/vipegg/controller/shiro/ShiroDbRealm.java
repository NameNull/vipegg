package vip.vipegg.controller.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.util.CollectionUtils;
import vip.vipegg.Enum.AdminStatusEnum;
import vip.vipegg.common.Constants;
import vip.vipegg.model.Admin;
import vip.vipegg.model.RoleSecurity;
import vip.vipegg.service.AdminService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ShiroDbRealm extends AuthorizingRealm{

    @Resource(name="adminService")
    private AdminService adminService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    	if(SecurityUtils.getSubject().getSession().getAttribute(Constants.PERMISSIONS) != null){
    		info = (SimpleAuthorizationInfo)SecurityUtils.getSubject().getSession().getAttribute(Constants.PERMISSIONS);
    	}else{
    		 //获取当前登录的用户名
            String name = (String) super.getAvailablePrincipal(principals);
            List<String> permissions = new ArrayList<String>();
            List<Admin> all = adminService.findByProperty("name", name);
            if(all != null && all.size() >0){
            	Admin admin = all.get(0);
            	if(admin.getRole() != null){
            		String roleName = admin.getRole().getName();
                    //给当前用户设置角色
                    info.addRole(roleName);
                    Set<RoleSecurity> set = admin.getRole().getRoleSecurities();
                    for (RoleSecurity roleSecurity : set) {
                    	permissions.add(roleSecurity.getSecurity().getUrl());
    				}
            	}
            }else{
                throw new AuthorizationException();
            }
            //给当前用户设置权限
            info.addStringPermissions(permissions); 
            SecurityUtils.getSubject().getSession().setTimeout(3600000);
            SecurityUtils.getSubject().getSession().setAttribute(Constants.PERMISSIONS, info);
    	}
        return info;
    }

    /**
     *  认证回调函数,登录时调用.
     */
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        Admin admin = new Admin();
		admin.setName(token.getUsername());
		admin.setPassword(new String(token.getPassword()));

        // 短信验证码登录
        List<Admin> all = adminService.findByProperty("mobile", token.getUsername());
        if(CollectionUtils.isEmpty(all) || !String.valueOf(token.getPassword()).equals(all.get(0).getPassword())){
            throw new AuthenticationException("用户名或密码错误！");
        }

        if (all != null && all.size() >0) {
            admin = all.get(0);
            if(admin.getStatusEnum() == AdminStatusEnum.FORBID){
            	throw new AuthenticationException("管理员已禁用！");
            }
		    SecurityUtils.getSubject().getSession().setTimeout(3600000);
		    SecurityUtils.getSubject().getSession().setAttribute(Constants.Admin_SESSION, admin);
            return new SimpleAuthenticationInfo(admin.getName(),admin.getPassword(), admin.getName());
        } else {
        	throw new AuthenticationException("错误的用户名或密码！");
        }
    }
    
}