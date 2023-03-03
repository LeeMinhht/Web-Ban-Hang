package edu.poly.shop.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import edu.poly.shop.domain.Order;
import edu.poly.shop.service.OrderService;


@RequestMapping("admin")

@Controller
public class AdminOrderController {
	
	@Autowired
	OrderService orderService;
	
	
	@GetMapping("order")
	public String view(Model model) {
		List<Order> list = orderService.findAll();
		model.addAttribute("orderList",list);
		return "admin/order/list";
		
	}
}
