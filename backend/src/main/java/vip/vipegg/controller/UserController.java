package vip.vipegg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import vip.vipegg.common.Constants;
import vip.vipegg.controller.common.BaseController;
import vip.vipegg.model.Admin;
import vip.vipegg.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController extends BaseController{
	@Autowired
	private AdminService adminService;

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/login");
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/loginAjax")
	public Object loginAjax(HttpServletRequest request, @RequestParam Integer telephone, @RequestParam String password) {
		Map map = new HashMap();
		Admin admin = adminService.login(telephone, password);
		if(admin == null){
			map.put("code", 0);
			return  map;
		}
		request.getSession().setAttribute(Constants.Admin_SESSION, admin);
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
