package com.PayPal.APITest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Framework.API.OrderAPI;

import io.restassured.response.Response;

public class GetOrderTest {
	
	
	@Test
	public void getOrderTest() {
		
		/*Please make sure first CreateOrderTest is run which will generate Order_id and same order_id will be used to retrieve the
		order details  */
		
		String access_token=OrderAPI.getAccessToken();
		Response response=OrderAPI.getOrder(access_token);
		Assert.assertEquals(response.getStatusCode(),200);
		
	}

}
