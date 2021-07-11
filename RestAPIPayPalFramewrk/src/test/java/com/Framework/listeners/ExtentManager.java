package com.Framework.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {

	private static ExtentReports extent;
	
	
	

	    public static ExtentReports createInstance(String fileName) {
	
	        //ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
	    	  
	    	ExtentSparkReporter sparkReporter=new ExtentSparkReporter(fileName);
	        
	    	sparkReporter.config().setTheme(Theme.STANDARD);
	    	sparkReporter.config().setDocumentTitle(fileName);
	    	sparkReporter.config().setEncoding("utf-8");
	    	sparkReporter.config().setReportName(fileName);
	        
	        extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);
	        extent.setSystemInfo("Automation Tester", "Ritwik Chakraborty");
	        extent.setSystemInfo("Organization", "API.COM");
	        extent.setSystemInfo("Build no", "R2A-1234");
	        
	        
	        return extent;
	    }

	
	

	}
