/******************************************************
Test Name:Get a single employee data
URI: http://dummy.restapiexample.com/api/v1/employee/{id}
Request Type: GET
Request Payload(Body): NA

********* Validations **********
Status Code : 200
Status Line : HTTP/1.1 200 OK
Content Type : text/html; charset=UTF-8
Server Type :  nginx/1.14.1
Content Encoding : gzip
Content Length <800
 *********************************************************/

package com.employeeapi.testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_Get_Weather extends TestBase{

	RequestSpecification httpRequest;
	Response response;
		
	@BeforeClass
	void getEmployeeData() throws InterruptedException
	{
		logger.info("*********Started TC002_Get_Single_Employee_Record **********");
		
		//RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/Delhi");
		
		Thread.sleep(5000);
	}
	
	
	@Test(priority=1)
	void checkResponseBody()
	{
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		Assert.assertEquals(responseBody.contains("Delhi"),true);
		
		
		// Get all the header at once
		Headers allheaders=response.getHeaders();
		for(Header header:allheaders) {
			System.out.println(header.getName()+" : "+header.getValue());
		}
	}
		
	@Test(priority=2)
	void checkStatusCode()
	{
		int statusCode = response.getStatusCode(); // Gettng status code
		Assert.assertEquals(statusCode, 200);
	}
	
	@AfterClass
	void tearDown()
	{
		logger.info("*********  Finished TC002_Get_Single_Employee_Record **********");
	}
	
}
