package vip.vipegg.controller;

import org.aspectj.apache.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
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
	public ModelAndView index(@RequestParam(defaultValue = "1") Integer pageNum) {
		int pageSize = Constants.PAGE_ITEM_COUNT_5;
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		Map map = new HashMap();
		map.put("statusEnum", ProductStatusEnum.ON);
		List<Product> products = productService.findByProperties(map, (pageNum - 1) * pageSize, pageSize);
		modelAndView.addObject("list", products);
		return modelAndView;
	}
}
