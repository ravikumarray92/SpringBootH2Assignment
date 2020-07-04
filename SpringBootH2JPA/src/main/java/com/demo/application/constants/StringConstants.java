package com.demo.application.constants;

import org.springframework.stereotype.Component;

@Component

public interface StringConstants {

	static String ADDSUCCESS = "Products added successfully!!";
	static String UPADTESUCCESS = "Products updated successfully!!";
	static String DELETESUCCESS = "Products deleted successfully!!";

	static String ADDFAILURE = "Some error occurred. Failed to add products...";
	static String UPADTEFAILURE = "Some error occurred. Failed to update products...";
	static String DELETEFAILURE = "Some error occurred. Failed to delete products...";

}
