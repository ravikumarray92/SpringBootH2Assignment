package com.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartDetails {
	@Autowired
	private ProductDetails addProductDetails;

	@Autowired
	private ProductDetails updateProductDetails;

	private String cartID;

	private String customerID;

	public ProductDetails getaddProductDetails() {
		return addProductDetails;
	}

	public void setaddProductDetails(ProductDetails addProductDetails) {
		this.addProductDetails = addProductDetails;
	}

	public String getCartID() {
		return cartID;
	}

	public void setCartID(String cartID) {
		this.cartID = cartID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public ProductDetails getupdateProductDetails() {
		return updateProductDetails;
	}

	public void setupdateProductDetails(ProductDetails updateProductDetails) {
		this.updateProductDetails = updateProductDetails;
	}

}
