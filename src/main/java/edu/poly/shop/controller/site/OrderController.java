 package edu.poly.shop.controller.site;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.poly.shop.domain.CartItem;
import edu.poly.shop.domain.Customer;
import edu.poly.shop.domain.Order;
import edu.poly.shop.domain.OrderDetail;
import edu.poly.shop.domain.Product;
import edu.poly.shop.service.CustomerService;
import edu.poly.shop.service.OrderDetailService;
import edu.poly.shop.service.OrderService;
import edu.poly.shop.service.ProductService;
import edu.poly.shop.service.ShopingCartService;

@Controller

@RequestMapping("site")
public class OrderController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	ShopingCartService cartService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	OrderDetailService detailService;
	
	@GetMapping("order/{productId}")
	public String order(Model model, @PathVariable("productId") Long id) {
		
		String username = (String) session.getAttribute("username");
		model.addAttribute("username",username);
		System.out.println(id);
		CartItem cartItem = cartService.findCartById(id);
		double amount = cartItem.getUnitPrice()* cartItem.getQuantity();
		
		String customerId = (String) session.getAttribute("username");
		if(customerId == null) {
			return "redirect:/login";
		}
		Customer cus = customerService.findByUsername(customerId);
					
		Order order = new Order();
		order.setAmount(amount);
		order.setOrderDate(new Date());
		order.setStatus((short) 0);
		order.setCustomer(cus);
		orderService.save(order);
		
//		System.out.println(order.getOrderId());
		Integer orderId = order.getOrderId();
		model.addAttribute("orderId",orderId);
		Long productId = cartItem.getProductId();
//		System.out.println(productId);
		model.addAttribute("productId",productId);
		
		return "site/order/orderDetail";
		
	}
//	@GetMapping("viewOrder")
//	
//	public String viewOrderDatail() {
//		return "site/order/orderDetail";
//		
//	}
	
	@PostMapping("orderDetail")
	public ModelAndView orderDetail(ModelMap model, @RequestParam("orderId") Integer orderId,
			@RequestParam("productId") Long productId) {
		
		String username = (String) session.getAttribute("username");
		model.addAttribute("username",username);
		System.out.println("OrderId: "+orderId);
		Optional<Order> optOrder = orderService.findById(orderId);
		Order order = optOrder.get();
		double amount = order.getAmount();
		
		System.out.println("productId : "+productId);
		Optional<Product> optProduct = productService.findById(productId);
		Product product = optProduct.get();
		
		OrderDetail detail = new OrderDetail();
		detail.setOrder(order);
		detail.setProduct(product);
		detail.setUnitPrice(product.getUnitPrice());
		detail.setQuantity((int) (amount/detail.getUnitPrice()));
		
		detailService.save(detail);
		cartService.remove(productId);
		model.addAttribute("message","Product is not existed");
		
	
		return  new ModelAndView("redirect:/site/shopping-cart/views",model);
		
	}
	
	@GetMapping("yourOrder")
	public ModelAndView yourOrder(ModelMap model) {
		String customerId = (String) session.getAttribute("username");
		String username = (String) session.getAttribute("username");
		model.addAttribute("username",username);
		
		if(customerId == null) {
			return new ModelAndView("redirect:/login",model);
		}
		System.out.println(customerId);
//		Integer cusId =Integer.parseInt(customerId);
		Customer customer = customerService.findByUsername(customerId);
		System.out.println(customer.getCustomerId());
		
		List<Order> list = orderService.findByCustomerCustomerId(customer.getCustomerId());
		System.out.println(list.size());
		
		model.addAttribute("orderList",list);
		return new ModelAndView("site/order/list");
	}
	
}
