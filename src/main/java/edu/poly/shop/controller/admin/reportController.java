package edu.poly.shop.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.shop.model.ReportDto;
import edu.poly.shop.service.OrderService;


@Controller
@RequestMapping("admin")
public class reportController {
	@Autowired
	OrderService orderService;
	
	@GetMapping("report")
	public String viewReports(Model model) {
		List<ReportDto> listReport = orderService.listReport(1);
		model.addAttribute("listReport",listReport);
		return"admin/reports/list";
	}
	
	@PostMapping("reports")
	public String view(Model model,@RequestParam("month") int month) {
		
		List<ReportDto> listReport = orderService.listReport(month);
		model.addAttribute("listReport",listReport);
		
		return"admin/reports/list";
		
}
}
