package com.demo.constants.test;

public interface StringConstantsTest {

	static String ADDSUCCESS = "{\r\n" + "    \"cartID\": \"800\",\r\n" + "    \"customerID\": \"999\",\r\n"
			+ "    \"statusMessage\": \"Products added successfully!!\"\r\n" + "}";
	static String UPADTESUCCESS = "{\r\n" + "    \"cartID\": \"800\",\r\n" + "    \"customerID\": \"999\",\r\n"
			+ "    \"statusMessage\": \"Products updated successfully!!\"\r\n" + "}";
	static String DELETESUCCESS = "{\r\n" + "    \"cartID\": \"1\",\r\n"
			+ "    \"statusMessage\": \"Products deleted successfully!!\",\r\n" + "    \"productsList\": [\r\n"
			+ "        {\r\n" + "            \"productId\": \"AXP\",\r\n" + "            \"productName\": \"Soap\"\r\n"
			+ "        }\r\n" + "    ]\r\n" + "}";

	static String ADDFAILURE = "{\r\n" + "    \"cartID\": \"800\",\r\n" + "    \"customerID\": \"999\",\r\n"
			+ "    \"statusMessage\": \"Some error occurred. Failed to add products...\"\r\n" + "}";
	static String UPADTEFAILURE = "{\r\n" + "    \"cartID\": \"800\",\r\n" + "    \"customerID\": \"999\",\r\n"
			+ "    \"statusMessage\": \"Some error occurred. Failed to update products...\"\r\n" + "}";
	static String DELETEFAILURE = "{\r\n" + "    \"cartID\": \"1\",\r\n"
			+ "    \"statusMessage\": \"Some error occurred. Failed to delete products...\",\r\n"
			+ "    \"productsList\": []\r\n" + "}";

}
