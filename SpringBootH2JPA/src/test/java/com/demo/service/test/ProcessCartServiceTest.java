package com.demo.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.demo.dao.ProcessCartImpl;
import com.demo.model.CartDetails;
import com.demo.model.ProductDetails;
import com.demo.model.Products;
import com.demo.service.ProcessCartService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProcessCartServiceTest.class)
@WebAppConfiguration
@ContextConfiguration(classes = { ProcessCartService.class })

@ComponentScan({ "com.demo.repository", "com.demo.application", "com.demo.configuration", "com.demo.controllers",
		"com.demo.dao", "com.demo.entity", "com.demo.service", "com.demo.model" })
public class ProcessCartServiceTest {
	@Mock
	ProcessCartService processCartService;

	@Mock
	ProcessCartImpl processCart;

	@Test
	public void testAddProductsSuccess() {

		ProductDetails addProductDetails = new ProductDetails();
		Map<String, Integer> productDetailsMap = new HashMap<>();
		productDetailsMap.put("AXP", 5);
		productDetailsMap.put("RMP", 8);
		productDetailsMap.put("ZPQ", 4);
		productDetailsMap.put("OMN", 2);
		productDetailsMap.put("LMP", 1);

		addProductDetails.setProductDetailsMap(productDetailsMap);

		CartDetails cartDetails = new CartDetails();
		cartDetails.setaddProductDetails(addProductDetails);
		cartDetails.setCartID("800");
		cartDetails.setCustomerID("999");
		String cartID = processCartService.addProducts(cartDetails);
		assertEquals(cartID, 800);
	}

	@Test
	public void testAddProductsFailure() {

		ProductDetails addProductDetails = new ProductDetails();
		Map<String, Integer> productDetailsMap = new HashMap<>();
		productDetailsMap.put("AXP", 5);
		productDetailsMap.put("RMP", 8);
		productDetailsMap.put("ZPQ", 4);
		productDetailsMap.put("OMN", 2);
		productDetailsMap.put("LMP", 1);

		addProductDetails.setProductDetailsMap(productDetailsMap);

		CartDetails cartDetails = new CartDetails();
		cartDetails.setaddProductDetails(addProductDetails);
		cartDetails.setCartID("800");
		cartDetails.setCustomerID("999");
		String cartID = processCartService.addProducts(cartDetails);
		assertNull(cartID);
	}

	@Test
	public void testUpdateProductsSuccess() {

		ProductDetails updateProductDetails = new ProductDetails();
		Map<String, Integer> productDetailsMap = new HashMap<>();
		productDetailsMap.put("AXP", 1);
		productDetailsMap.put("RMP", 4);
		productDetailsMap.put("ZPQ", 9);
		productDetailsMap.put("OMN", 8);
		productDetailsMap.put("LMP", 4);

		updateProductDetails.setProductDetailsMap(productDetailsMap);

		CartDetails cartDetails = new CartDetails();
		cartDetails.setaddProductDetails(updateProductDetails);
		cartDetails.setCartID("800");
		cartDetails.setCustomerID("999");
		String cartID = processCartService.updateProducts(cartDetails);
		assertEquals(cartID, "800");
	}

	@Test
	public void testUpdateProductsFailure() {

		ProductDetails updateProductDetails = new ProductDetails();
		Map<String, Integer> productDetailsMap = new HashMap<>();
		productDetailsMap.put("AXP", 1);
		productDetailsMap.put("RMP", 4);
		productDetailsMap.put("ZPQ", 9);
		productDetailsMap.put("OMN", 8);
		productDetailsMap.put("LMP", 4);

		updateProductDetails.setProductDetailsMap(productDetailsMap);

		CartDetails cartDetails = new CartDetails();
		cartDetails.setaddProductDetails(updateProductDetails);
		cartDetails.setCartID("800");
		cartDetails.setCustomerID("999");
		String cartID = processCartService.updateProducts(cartDetails);
		assertNull(cartID);
	}

	@Test
	public void testDeleteProductsSuccess() throws Exception {

		List<Products> productList = new ArrayList<>();
		productList.add(new Products("AXP", "Soap"));

		List<Products> list = processCartService.deleteProducts("1", productList);
		assertFalse(list.isEmpty());
	}

	@Test
	public void testDeleteProductsFailure() throws Exception {

		List<Products> productList = new ArrayList<>();
		productList.add(new Products("AXP", "Soap"));

		List<Products> list = processCartService.deleteProducts("1", productList);
		assertTrue(list.isEmpty());
	}
}
