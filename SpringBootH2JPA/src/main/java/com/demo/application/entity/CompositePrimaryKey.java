package com.demo.application.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CompositePrimaryKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cartID;

	private String productID;

	public String getCartID() {
		return cartID;
	}

	public void setCartID(String cartID) {
		this.cartID = cartID;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public CompositePrimaryKey() {
      super();
	}

	public CompositePrimaryKey(String cartID, String productID) {
		this.cartID = cartID;
		this.productID = productID;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		CompositePrimaryKey that = (CompositePrimaryKey) o;

		if (!cartID.equals(that.cartID))
			return false;
		return productID.equals(that.productID);
	}

	@Override
	public int hashCode() {
		int result = cartID.hashCode();
		result = 31 * result + productID.hashCode();
		return result;
	}
}
