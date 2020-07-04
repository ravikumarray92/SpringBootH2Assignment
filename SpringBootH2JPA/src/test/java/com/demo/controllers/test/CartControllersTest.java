package com.demo.controllers.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.demo.application.AbstractTest;
import com.demo.constants.test.StringConstantsTest;
import com.demo.dao.ProcessCartImpl;
import com.demo.model.CartDetails;
import com.demo.model.ProductDetails;
import com.demo.model.Products;
import com.demo.service.ProcessCartService;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc 
@SpringBootTest(classes = CartControllersTest.class)
@WebAppConfiguration
@ComponentScan({ "com.demo.repository", "com.demo.application", "com.demo.configuration", "com.demo.controllers",
		"com.demo.dao", "com.demo.entity", "com.demo.service", "com.demo.model" })
public class CartControllersTest extends AbstractTest {
    @Autowired
	protected MockMvc mvc;
	@Autowired
	WebApplicationContext webApplicationContext;
    @Before(value = "")
	protected void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Mock
	ProcessCartImpl processCartImpl;
	@Mock
	ProcessCartService processCartService;

	@Mock
	ProcessCartImpl processCart;

	@Test
	public void addProductsSuccessTest() throws Exception {
		String uri = "/addProducts";
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

		String inputJson = super.mapToJson(cartDetails);
		MvcResult mvcResult = super.mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, StringConstantsTest.ADDSUCCESS);
	}

	@Test
	public void updateProductsSuccessTest() throws Exception {
		String uri = "/updateProducts";
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

		String inputJson = super.mapToJson(cartDetails);
		MvcResult mvcResult = super.mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();

		assertEquals(content, StringConstantsTest.UPADTESUCCESS);
	}

	@Test
	public void deleteProductsSuccessTest() throws Exception {
		String uri = "/removeProducts/1";
		List<Products> productList = new ArrayList<>();
		productList.add(new Products("AXP", "Soap"));

		String inputJson = super.mapToJson(productList);
		MvcResult mvcResult = super.mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();

		assertEquals(content, StringConstantsTest.UPADTESUCCESS);
	}

}
