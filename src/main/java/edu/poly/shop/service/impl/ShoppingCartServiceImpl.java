package edu.poly.shop.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import edu.poly.shop.domain.CartItem;
import edu.poly.shop.service.ShopingCartService;

@SessionScope
@Service
public class ShoppingCartServiceImpl implements ShopingCartService{
	
	Map<Long, CartItem> maps = new HashMap<>(); // giỏ hàng
	
	@Override
	public void add(CartItem item) {
		//Kiểm tra sản phẩm đã tồn tại trong giỏ hàng hay chưa
		CartItem cartItem = maps.get(item.getProductId());
		if(cartItem == null) {
			maps.put(item.getProductId(), item);
		}else {
			cartItem.setQuantity(cartItem.getQuantity() + 1);
		}
		
	}
	
	@Override
	public void remove(Long id) {
		maps.remove(id);
	}
	
	@Override
	public CartItem update(Long proID,int qty) {
		CartItem cartItem = maps.get(proID);
		cartItem.setQuantity(qty);
		return cartItem;
	}
	
	@Override
	public void clear() {
		maps.clear();
	}
	
	@Override
	public CartItem findCartById(Long id) {
		for (CartItem cartService : maps.values()) {
			if(cartService.getProductId()==id) {
				return cartService;
			}
		}
		return null;
	}
	
	@Override
	public Collection<CartItem> getAllItems(){
		return maps.values();
	}
	
	@Override
	public int getCount() {
		return maps.values().size();
	}
	
	@Override
	public double getAmount() {
		return maps.values().stream().mapToDouble(item ->item.getQuantity() * item.getUnitPrice()).sum();
	}

}
