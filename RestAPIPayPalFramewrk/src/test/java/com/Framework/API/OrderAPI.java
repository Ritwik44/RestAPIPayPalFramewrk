package com.Framework.API;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import com.Frameworksetup.BaseClassTest;

import com.Framework.Pojo.Orders;
import com.Framework.Pojo.Purchase_units;
import com.Framework.Pojo.Amount;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class OrderAPI extends BaseClassTest {

	
	public static String clientId=config.getProperty("paypal_clientId");
	public static String Secret_key=config.getProperty("paypal_Secret_key");
	public static String access_token;
	public static String order_id;
	
    
	
	public static String getAccessToken() {
		
	    Response response=given().formParams("grant_type","client_credentials").auth().preemptive().
		basic(clientId,Secret_key).post("v1/oauth2/token");
		
	
		access_token=response.jsonPath().get("access_token").toString();
		
		return access_token;
	}
	
	
	

	public static Response CreateOrder(String access_token) {
	
		ArrayList<Purchase_units> list=new ArrayList<Purchase_units>();	
		list.add(new Purchase_units("USD", 100.12));
		Orders orders=new Orders("CAPTURE",list );
		
		Response response=given().contentType(ContentType.JSON).auth().oauth2(access_token).
				body(orders).post("v2/checkout/orders");
	
		order_id=response.jsonPath().get("id").toString();
		return response;
	}
	
	
	
	public static Response getOrder(String access_token) {
		
		Response response=given().contentType(ContentType.JSON).auth().oauth2(access_token).
				get("v2/checkout/orders/"+order_id);
		
		return response;
		
	}
}
