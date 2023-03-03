package edu.poly.shop.controller.site;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutUsController {
	
	@Autowired
	private HttpSession session;
	@GetMapping("contact")
	public ModelAndView contact(ModelMap model) {
		String username = (String) session.getAttribute("username");
		model.addAttribute("username",username);
		return new ModelAndView("site/other/contact",model) ;
		
	}
}
