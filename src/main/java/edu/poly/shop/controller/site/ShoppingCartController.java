package edu.poly.shop.controller.site;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.shop.domain.CartItem;
import edu.poly.shop.domain.Product;
import edu.poly.shop.service.ProductService;
import edu.poly.shop.service.ShopingCartService;

@Controller
@RequestMapping("site/shopping-cart")
public class ShoppingCartController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	ShopingCartService cartService;
	
	@GetMapping("views")
	public String viewCart(Model model) {
		
		String username = (String) session.getAttribute("username");
		model.addAttribute("username",username);
		model.addAttribute("CART_ITEMS", cartService.getAllItems());
		model.addAttribute("TOTAL", cartService.getAmount());
		return "site/products/cart-item";
	}
	
	@GetMapping("add/{productId}")
	public String addCart(@PathVariable("productId") Long id) {
		Optional<Product> product = productService.findById(id);
		if(product !=null) {
			CartItem item = new CartItem();
			item.setProductId(product.get().getProductId());
			item.setName(product.get().getName());
			item.setUnitPrice(product.get().getUnitPrice());
			item.setQuantity(1);
			
			cartService.add(item);
		}
		return "redirect:/site/shopping-cart/views";
	}
	
	@GetMapping("clear")
	public String clearCart() { 
		cartService.clear();
		return "redirect:/site/shopping-cart/views";
	}

	@GetMapping("del/{id}")
	public String removeCart(@PathVariable("productId") Long id) {
		cartService.remove(id);
		
		return "redirect:/site/shopping-cart/views";
	}
	
	@PostMapping("update")
	public String update(@RequestParam("productId") Long id,@RequestParam("quantity") Integer qty) {
		
		cartService.update(id, qty);
		return "redirect:/site/shopping-cart/views";
		
	}
}