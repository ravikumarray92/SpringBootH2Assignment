package com.demo.model;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDetails {
	@JsonProperty("productDetailsMap")
	private Map<String, Integer> productDetailsMap;

	@JsonProperty("productDetailsMap")
	public Map<String, Integer> getProductDetailsMap() {
		return productDetailsMap;
	}

	@JsonProperty("productDetailsMap")
	public void setProductDetailsMap(Map<String, Integer> addProductDetails) {
		this.productDetailsMap = addProductDetails;
	}

}
