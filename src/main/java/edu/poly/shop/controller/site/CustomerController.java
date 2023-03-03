package edu.poly.shop.controller.site;

import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.shop.domain.Customer;
import edu.poly.shop.model.CustomerRegister;
import edu.poly.shop.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("register")
	public ModelAndView register(ModelMap model) {
		model.addAttribute("customer",new CustomerRegister());
		return new ModelAndView("site/customer/register",model);
	}
	
	@PostMapping("register")
	public ModelAndView register(ModelMap model,@Valid @ModelAttribute("customer") CustomerRegister dto,
			BindingResult result) {
		Customer customer = customerService.findByUsername(dto.getName());
		
		if(customer != null) {
			model.addAttribute("message","User already exists");
			return new ModelAndView("/site/customer/register",model);
		}
		Customer customernew = new Customer();
		BeanUtils.copyProperties( dto,customernew);
		customernew.setRegisteredDate(new Date());
		customernew.setRole(false);
		customernew.setStatus((short) 1);
		
		
		customerService.save(customernew);
		model.addAttribute("message","Register successfully");
		return new ModelAndView("forward:/login",model);
	}
}
