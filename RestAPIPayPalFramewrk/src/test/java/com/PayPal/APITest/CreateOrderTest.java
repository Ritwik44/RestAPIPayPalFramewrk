package com.PayPal.APITest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Framework.API.OrderAPI;
import com.Frameworksetup.BaseClassTest;

import io.restassured.response.Response;

public class CreateOrderTest extends BaseClassTest {
	
	
	//Sample Test
	
	@Test
	public void createorder() {
		
		String access_token=OrderAPI.getAccessToken();
		Response response=OrderAPI.CreateOrder(access_token);
		
		String Order_Status=response.jsonPath().get("status").toString();
		Assert.assertEquals(Order_Status, "CREATED");
		response.prettyPrint();
	}

}
