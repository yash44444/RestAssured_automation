// The objective of this test is to verify the status line and status code from the getweatherdetails GET request.

package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test5 {
	
	@Test
	public void getweatherdetails () {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		PreemptiveBasicAuthScheme auth=new PreemptiveBasicAuthScheme();
		auth.setUserName("ToolsQA");
		auth.setPassword("TestPassword");
		RestAssured.authentication=auth;   
	
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,"/");
		String responseBody = response.getBody().asString();
		System.out.println("Response is: "+ responseBody);
		
		int StatusCode = response.getStatusCode();
		System.out.println("Status code is: "+StatusCode);
		Assert.assertEquals(StatusCode, 200);
		
		String line=response.getStatusLine();
		System.out.println("Status line is: "+line);
		Assert.assertEquals(line, "HTTP/1.1 200 OK");
		
		
	}

}
