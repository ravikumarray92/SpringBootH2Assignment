package com.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Products {

	String productId;
	String productName;

	public Products(String productId, String productName) {
		super();
		this.productId = productId;
		this.productName = productName;
	}

	public Products() {
		super();

	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
