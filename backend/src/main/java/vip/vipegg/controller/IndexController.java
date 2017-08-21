package vip.vipegg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping("/")
	public ModelAndView indexForward() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/index");
		return modelAndView;
	}
}
