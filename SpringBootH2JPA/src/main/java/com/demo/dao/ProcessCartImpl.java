package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.application.entity.CompositePrimaryKey;
import com.demo.application.entity.ShoppingCarts;
import com.demo.application.repository.ProcessCartRepository;

@Repository
public class ProcessCartImpl {
	@Autowired
	ProcessCartRepository processCartRepo;

	public ShoppingCarts updateCartProducts(ShoppingCarts shoppingCart) {
		return addCartProducts(shoppingCart);
	}

	public ShoppingCarts addCartProducts(ShoppingCarts shoppingCart) {

		return processCartRepo.save(shoppingCart);
	}

	public void removeCartProducts(String cartID, String productID) {

		processCartRepo.deleteById(new CompositePrimaryKey(cartID, productID));

	}

}
