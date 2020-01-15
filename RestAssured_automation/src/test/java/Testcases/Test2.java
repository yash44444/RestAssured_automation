package Testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class Test2 {
	
	public void Registration() {
	
	RestAssured.baseURI = "http://restapi.demoqa.com/customer";
	RequestSpecification httpRequest = RestAssured.given();
	
	// Request body
	JSONObject requestParams = new JSONObject();
	
	requestParams.put("FirstName","JohnXYZ");
	requestParams.put("LastName","XYZJohn");
	requestParams.put("UserName","JohnXYZ");
	requestParams.put("Password","JohnXYZxyz");
	requestParams.put("Email","JohnXYZ@gmail.com");
	
	httpRequest.header("Content-Type","application/json");	
	httpRequest.body(requestParams.toJSONString());
	
	Response resp = httpRequest.request(Method.POST,"/register");
	
	String responseBody = resp.getBody().asString();
	System.out.println("Response is: "+ responseBody);
	
	int StatusCode = resp.getStatusCode();
	System.out.println("Status code is: "+StatusCode);
	Assert.assertEquals(StatusCode, 201);
	
	String success=resp.jsonPath().get("SuccessCode");
	Assert.assertEquals(success, "OPERATION_SUCCESS");
	
}
	
}
