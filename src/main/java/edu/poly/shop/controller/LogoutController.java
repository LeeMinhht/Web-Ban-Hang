package edu.poly.shop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import groovyjarjarpicocli.CommandLine.Model;

@Controller
@RequestMapping("admin")
public class LogoutController {
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("logout")
	public String logOut(Model model) {
		session.removeAttribute("username");
		return "redirect:/login";
	}
	
}
