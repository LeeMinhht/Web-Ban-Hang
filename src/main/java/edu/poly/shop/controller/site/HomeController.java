package edu.poly.shop.controller.site;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.poly.shop.domain.Category;
import edu.poly.shop.domain.Product;
import edu.poly.shop.model.AccountDto;
import edu.poly.shop.model.ProductDto;
import edu.poly.shop.service.CategoryService;
import edu.poly.shop.service.ProductService;
import edu.poly.shop.service.StorageService;

@Controller
//@RequestMapping("site")
public class HomeController {
	@Autowired
	StorageService storageService;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	
//	public String add(Model model) {
//		List<Product> list = productService.findAll();
//		model.addAttribute("products",list);
//		return "site/home/listProduct"; 
//	}
	
	@GetMapping("home")
	public String search(ModelMap model,
			@RequestParam("page")Optional<Integer> page,
			@RequestParam("size")Optional<Integer> size
			
			) {
		String username = (String) session.getAttribute("username");
		model.addAttribute("username",username);
		
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(6);
		
		
		
		
		Pageable pageable = PageRequest.of(currentPage -1,pageSize);
		Page<Product> resultPage = null;
		
		
			resultPage = productService.findAll(pageable);
		
		
		int totalPages = resultPage.getTotalPages();
		if(totalPages > 0) {
			int start = Math.max(1, totalPages-2);
			int end = Math.min(currentPage + 2, totalPages);
			
			if(totalPages > 5) {
				if(end == totalPages) start = end -6;
				else if(start == 1) end = start +6;
				
			}
			List<Integer> pageNumbers = IntStream.rangeClosed(start, end)
					.boxed()
					.collect(Collectors.toList());
			model.addAttribute("pageNumbers",pageNumbers);
		}
		
		//đổ list category
		List<Category> listCategory = categoryService.findAll();
		model.addAttribute("listCategory",listCategory);
		
		model.addAttribute("products",resultPage);
		return "site/home/listProduct"; 
	}

	
}
