package vip.vipegg.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import vip.vipegg.common.Constants;
import vip.vipegg.controller.common.BaseController;
import vip.vipegg.model.Admin;
import vip.vipegg.service.AdminService;
import vip.vipegg.service.ValidateService;
import vip.vipegg.util.StringUtils;
import vip.vipegg.util.Utils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController extends BaseController{
	@Autowired
	private ValidateService validateService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/login");
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping(value = "/loginAjax")
	public Object loginAjax(HttpServletRequest request, @RequestParam String telephone, @RequestParam String password){
		Map map = new HashMap();
		String ip = Utils.getIpAddr(request);
		int admin_limit = this.validateService.getLimitCount(ip);
		if (admin_limit <= 0) {
			map.put("error", "连续登陆错误"+Constants.ADMIN_LOGIN_ERROR_COUNT+"次，为安全起见，禁止登陆2小时！");
			return map;
		}

		Subject admin = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(telephone, Utils.MD5(password));
		token.setRememberMe(true);

		try {
			admin.login(token);
		} catch (Exception e) {
			token.clear();
			this.validateService.updateLimitCount(ip);
			map.put("error", e.getMessage());
			return map;
		}
		map.put("code", 200);
		return map;
	}

	@RequestMapping("/loginOut")
	public Object loginOut(HttpServletRequest request) {
		Admin admin = getSessionAdmin(request);
		if (admin != null) {
			request.getSession().removeAttribute(Constants.Admin_SESSION);
		}
		return "admin/login";
	}
}
