package edu.poly.shop.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.shop.domain.Account;
import edu.poly.shop.domain.Customer;
import edu.poly.shop.model.AdminLoginDto;
import edu.poly.shop.model.CustomerDto;
import edu.poly.shop.service.CustomerService;

@Controller
public class SiteLoginCotroller {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("login")
	public String login(ModelMap model) {
		model.addAttribute("customer",new CustomerDto());
		return "site/customer/login";
		
	}
	@PostMapping("login")
	public ModelAndView login(ModelMap model,
			@Valid @ModelAttribute("customer") CustomerDto dto,
			BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("/site/customer/login",model);
		}
		
		Customer customer = customerService.login(dto.getUsername(), dto.getPassword());
		
		if(customer == null) {
			model.addAttribute("message","Invalid username or password");
			return new ModelAndView("/site/customer/login",model);
		}
		
		session.setAttribute("username", customer.getName());
		System.out.println("haha");
		
		Object ruri = session.getAttribute("redirect-uri");
		if(ruri != null) {
			session.removeAttribute("redirect-uri");
			return new ModelAndView("redirect:"+ ruri);
		}
		System.out.println("hihi");
		
		if(customer.getRole() == true) {
			return new ModelAndView("forward:/admin/products");
		}
		CustomerDto customerDto = new CustomerDto();
		customerDto.setLogin(true);
		session.setAttribute("login", customerDto);
		return new ModelAndView("redirect:/home",model);
	}
	
	
}
