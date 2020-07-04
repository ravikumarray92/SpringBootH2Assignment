package com.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class ResponseBodyTemplate {

	private String cartID;

	private String customerID;

	private String statusMessage;

	private List<Products> productsList;

	public ResponseBodyTemplate() {
		super();
	}

	public ResponseBodyTemplate(String cartID, String customerID, String statusMessage) {
		super();
		this.cartID = cartID;
		this.customerID = customerID;
		this.statusMessage = statusMessage;
	}

	public List<Products> getProductsList() {
		return productsList;
	}

	public void setProductsList(List<Products> productsList) {
		this.productsList = productsList;
	}

	public ResponseBodyTemplate(String cartID, List<Products> productsList, String statusMessage) {
		super();
		this.cartID = cartID;
		this.productsList = productsList;
		this.statusMessage = statusMessage;
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

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
}
