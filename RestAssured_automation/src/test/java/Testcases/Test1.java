// The objective of this test is to verify the status line and status code from the getweatherdetails GET request.

package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test1 {
	
	@Test
	public void getweatherdetails () {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		// Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		// Response object
		Response response = httpRequest.request(Method.GET,"/Delhi");
		
		// fetch the repsonse in string format
		String responseBody = response.getBody().asString();
		
		// print the response
		System.out.println("Response is: "+ responseBody);
		
		
		// validations ( status code, Header)
		int StatusCode = response.getStatusCode();
		System.out.println("Status code is: "+StatusCode);
		Assert.assertEquals(StatusCode, 200);
		
		String line=response.getStatusLine();
		System.out.println("Status line is: "+line);
		Assert.assertEquals(line, "HTTP/1.1 200 OK");
		
		String contentType=response.header("Content-Type");
		System.out.println("Content Type is: "+contentType);
		Assert.assertEquals(contentType, "application/json");
		
		String server=response.header("Server");
		System.out.println("Server is: "+server);
		Assert.assertEquals(server, "nginx");
		
	}

}
