package edu.poly.shop.controller.site;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.shop.domain.Product;
import edu.poly.shop.service.ProductService;

@Controller

@RequestMapping("site")
public class ProductDetailController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("productDetail/{productId}")
	public ModelAndView productDetail(ModelMap model,@PathVariable("productId") Long productId) {
		Optional<Product> optExits = productService.findById(productId);
		
		if(optExits.isPresent()) {
			Product product = optExits.get();
			model.addAttribute("productDetail",product);
			return new ModelAndView("site/products/productDetail",model);
		}
		return new ModelAndView("forward:/site/home");
		
		
	}

}
