package com.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.application.constants.StringConstants;
import com.demo.model.CartDetails;
import com.demo.model.Products;
import com.demo.model.ResponseBodyTemplate;
import com.demo.service.ProcessCartService;

@RestController
@RequestMapping("cart/controller")
public class CartControllers {
	@Autowired
	ProcessCartService processCart;

	@RequestMapping(value = "/addProducts", method = RequestMethod.POST)
	ResponseBodyTemplate addProducts(@RequestBody CartDetails cartDetails) {

		String result = processCart.addProducts(cartDetails);

		if (result == null)
			return new ResponseBodyTemplate(result, cartDetails.getCustomerID(), StringConstants.ADDFAILURE);

		return new ResponseBodyTemplate(result, cartDetails.getCustomerID(), StringConstants.ADDSUCCESS);
	}

	@RequestMapping(value = "/updateProducts", method = RequestMethod.PUT)
	ResponseBodyTemplate updateProducts(@RequestBody CartDetails cartDetails) {

		String result = processCart.updateProducts(cartDetails);
		if (result == null)
			return new ResponseBodyTemplate(result, cartDetails.getCustomerID(), StringConstants.UPADTEFAILURE);

		return new ResponseBodyTemplate(result, cartDetails.getCustomerID(), StringConstants.UPADTESUCCESS);
	}

	@RequestMapping(value = "/removeProducts/{cartID}", method = RequestMethod.POST)
	ResponseBodyTemplate updateProducts(@RequestBody List<Products> productList,
			@PathVariable("cartID") String cartID) {

		List<Products> result = processCart.deleteProducts(cartID, productList);

		if (result == null)
			return new ResponseBodyTemplate(cartID, new ArrayList<Products>(), StringConstants.DELETEFAILURE);

		return new ResponseBodyTemplate(cartID, productList, StringConstants.DELETESUCCESS);
	}

}
