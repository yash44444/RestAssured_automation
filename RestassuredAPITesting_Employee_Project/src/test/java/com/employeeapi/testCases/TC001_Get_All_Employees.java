package com.employeeapi.testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC001_Get_All_Employees extends TestBase{

		
	@BeforeClass
	void getAllEmployees() throws InterruptedException 
	{
	
	logger.info("*********Started TC001_Get_All_Employees **********");
		
	// Specify base URI
	RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1"; 
	
	// Request object
	httpRequest = RestAssured.given(); // With this particular object we are going to send the reqst to the server.
	
	// Response object. This will send the request to the server and get the response.
	response = httpRequest.request(Method.GET,"/employees"); 
	
	Thread.sleep(5);
	}
			
	@Test(priority=1)
	void checkResponseBody()
	{
		logger.info("***********  Checking Response Body **********");
		
		// Printing response in the console window
		String responseBody = response.getBody().asString();  // json -> string 
		logger.info("Response Body==>"+responseBody);
		Assert.assertTrue(responseBody!=null);
		
	}
		
	@Test(priority=2)
	void checkStatusCode()
	{
		logger.info("***********  Checking Status Code **********");
		
		int statusCode = response.getStatusCode(); // Gettng status code
		logger.info("Status Code is ==>" + statusCode); //200
		Assert.assertEquals(statusCode, 200);
		
	}
		
	@Test(priority=3)
	void checkResponseTime()
	{
		logger.info("***********  Checking Response Time **********");
		
		long responseTime = response.getTime(); // Getting status Line
		logger.info("Response Time is ==>" + responseTime);
		
		if(responseTime>2000)
			logger.warn("Response Time is greater than 2000");
		
		Assert.assertTrue(responseTime<10000);		
	}
	
	
	@Test(priority=4)
 	{
		logger.info("***********  Checking Status Line **********");
		
		String statusLine = response.getStatusLine(); // Getting status Line
		logger.info("Status Line is ==>" + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");	
	}
		
	@Test(priority=5)
	void checkContentType()
	{
		logger.info("***********  Checking Content Type **********");
		
		String contentType = response.header("Content-Type");
		logger.info("Content type is ==>" + contentType);
		Assert.assertEquals(contentType, "application/json;charset=utf-8");
	}

	@Test(priority=6)
	void checkserverType()
	{
		logger.info("***********  Checking Server Type **********");
		
		String serverType = response.header("Server");
		logger.info("Server Type is =>" +serverType); 
		Assert.assertEquals(serverType, "nginx/1.16.0");
	
	}

	@Test(priority=7)
	void checkcontentEncoding()
	{
		logger.info("***********  Checking Content Encoding**********");
		
		String contentEncoding = response.header("Content-Encoding");
		logger.info("Content Encoding is==>" +contentEncoding); 
		Assert.assertEquals(contentEncoding, "gzip");		
	}

	
	@AfterClass
	void tearDown()
	{
		logger.info("*********  Finished TC001_Get_All_Employees **********");
	}
				 	
}
