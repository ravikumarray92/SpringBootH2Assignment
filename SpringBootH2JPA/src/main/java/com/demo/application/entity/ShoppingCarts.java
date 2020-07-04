package com.demo.application.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "Shopping_Carts")
public class ShoppingCarts {
	public ShoppingCarts(CompositePrimaryKey compositePrimaryKey, String customerID, int quantity) {
		super();
      this.compositePrimaryKey = compositePrimaryKey;
		this.customerID = customerID;

		this.quantity = quantity;

	}

	public ShoppingCarts() {
		super();
		
	}

	@EmbeddedId
	CompositePrimaryKey compositePrimaryKey;

	@Column
	private String customerID;

	@Column
	private int quantity;

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public int getItemQuantity() {
		return quantity;
	}

	public void setItemQuantity(int itemQuantities) {
		this.quantity = itemQuantities;
	}

}
