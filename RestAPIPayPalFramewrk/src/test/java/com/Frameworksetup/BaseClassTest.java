package com.Frameworksetup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class BaseClassTest {

	
	public static Properties config=new Properties();
	private FileInputStream fis;
	
	@BeforeSuite
	public void setup() {
		
		try {
			fis=new FileInputStream("./src/test/resources/Properties/config.properties");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			
			config.load(fis);	
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		RestAssured.baseURI=config.getProperty("baseURI");
	//	RestAssured.basePath=config.getProperty("basePath"); not required as basePath is variable for POST(), GET() 
	}
	
	
	@AfterSuite
	public void teardown()
	{
		
	}
	
	
	
	
	
}
