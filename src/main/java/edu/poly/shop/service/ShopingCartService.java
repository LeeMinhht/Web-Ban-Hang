package edu.poly.shop.service;

import java.util.Collection;

import edu.poly.shop.domain.CartItem;

public interface ShopingCartService {

	double getAmount();

	int getCount();

	Collection<CartItem> getAllItems();

	void clear();

	CartItem update(Long proID, int qty);

	void remove(Long id);

	void add(CartItem item);

	CartItem findCartById(Long id);

}
