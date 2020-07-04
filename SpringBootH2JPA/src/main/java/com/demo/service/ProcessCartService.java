package com.demo.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.application.entity.CompositePrimaryKey;
import com.demo.application.entity.ShoppingCarts;
import com.demo.dao.ProcessCartImpl;
import com.demo.model.CartDetails;
import com.demo.model.Products;

@Service
public class ProcessCartService {
	@Autowired
	ProcessCartImpl processCartImpl;

	public List<Products> deleteProducts(String cartID, List<Products> productsList) {
		try {
			for (Products product : productsList) {
				processCartImpl.removeCartProducts(cartID, product.getProductId());
			}
		} catch (Exception ce) {
			System.out.println(ce.getMessage());
			return null;
		}
		
		return productsList;
	}

	public String updateProducts(CartDetails cartDetails) {
		Map<String, Integer> updateProductsMap = cartDetails.getupdateProductDetails().getProductDetailsMap();
		String cartID = cartDetails.getCartID();
		String customerId = cartDetails.getCustomerID();
		Iterator<Map.Entry<String, Integer>> iterator = updateProductsMap.entrySet().iterator();

		try {
			while (iterator.hasNext()) {
				Map.Entry<String, Integer> entry = iterator.next();
				String productID = entry.getKey();
				Integer quantity = entry.getValue();
				processCartImpl.updateCartProducts(
						new ShoppingCarts(new CompositePrimaryKey(cartID, productID), customerId, quantity));
			}
		} catch (Exception ce) {
			System.out.println(ce.getMessage());
			return null;
		}
		return cartDetails.getCartID();
	}

	public String addProducts(CartDetails cartDetails) {
		Map<String, Integer> addProductsMap = cartDetails.getaddProductDetails().getProductDetailsMap();
		String cartID = cartDetails.getCartID();
		String customerId = cartDetails.getCustomerID();
		Iterator<Map.Entry<String, Integer>> iterator = addProductsMap.entrySet().iterator();
		try {
			while (iterator.hasNext()) {
				Map.Entry<String, Integer> entry = iterator.next();
				String productID = entry.getKey();
				Integer quantity = entry.getValue();

				processCartImpl.addCartProducts(
						new ShoppingCarts(new CompositePrimaryKey(cartID, productID), customerId, quantity));
			}

		} catch (Exception ce) {
			System.out.println("Exception while adding products : " + ce.getMessage());
			return null;
		}
		return cartDetails.getCartID();

	}

}
