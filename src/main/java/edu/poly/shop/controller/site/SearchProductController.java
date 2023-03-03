package edu.poly.shop.controller.site;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.shop.domain.Category;
import edu.poly.shop.domain.Product;
import edu.poly.shop.service.CategoryService;
import edu.poly.shop.service.ProductService;

@Controller
public class SearchProductController {
	
	@Autowired
	private HttpSession session;
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	
	@GetMapping("productUs")
	public String view(Model model) {
		String username = (String) session.getAttribute("username");
		model.addAttribute("username",username);

		List<Product> list = productService.findAll();
		model.addAttribute("products",list);
	
		return "site/home/usProducts";
	}
	
	@PostMapping("searchUsProducts")
	public String searchProduct(Model model,@RequestParam("name") String name) {
		List<Product> list = productService.findByNameContaining(name);
		model.addAttribute("products",list);
	
		return "site/home/usProducts";
	}
	
	
	@GetMapping("searchByCategory/{categoryId}")
	public String searchByCategory(Model model,@PathVariable("categoryId") Long categoryId) {
		System.out.println(categoryId);
		List<Product> list = productService.findByCategoryCategoryId(categoryId);
		model.addAttribute("products",list);
		
		//đổ list Category
		List<Category> listCategory = categoryService.findAll();
		model.addAttribute("listCategory",listCategory);
		
		return "site/home/usProducts"; 
		
	}
}
