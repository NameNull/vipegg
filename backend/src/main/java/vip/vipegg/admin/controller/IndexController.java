package vip.vipegg.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vip.vipegg.Enum.ProductStatusEnum;
import vip.vipegg.common.Constants;
import vip.vipegg.model.Product;
import vip.vipegg.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
	@Autowired
	private ProductService productService;

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
}
