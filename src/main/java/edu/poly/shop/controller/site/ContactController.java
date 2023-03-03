package edu.poly.shop.controller.site;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {
	
	@GetMapping("about")
	public ModelAndView contact(ModelMap model) {
		return new ModelAndView("site/other/about",model) ;
		
	}
}
