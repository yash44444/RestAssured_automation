package com.employeeapi.testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_Authentication extends TestBase{
		
	@BeforeClass
	void getAllEmployees() throws InterruptedException 
	{
	
	logger.info("********* Started TC001_Get_All_Employees **********");
		
	// Specify base URI
	RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication"; 
	
	// Basic Auth
		
		
		/*
		 * PreemptiveBasicAuthScheme auth= new PreemptiveBasicAuthScheme();
		 * auth.setUserName("ToolsQA"); auth.setPassword("TestPassword");
		 * RestAssured.authentication=auth;
		 */
		 
		 
	
	// Request object
	httpRequest = RestAssured.given(); // With this particular object we are going to send the reqst to the server.
	
	// Response object. This will send the request to the server and get the response.
	response = httpRequest.request(Method.GET,"/"); 
	
	Thread.sleep(5);
	}
			
	@Test
	void checkResponseBody()
	{
		logger.info("***********  Checking Response Body **********");
		
		// Printing response in the console window
		String responseBody = response.getBody().asString();  // json -> string 
		logger.info("Response Body==>"+responseBody);
		
		int statusCode=response.getStatusCode();
		System.out.println("status code is "+statusCode);
		Assert.assertEquals(statusCode,200);
		
	}
		
	
				 	
}
