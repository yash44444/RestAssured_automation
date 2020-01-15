// The objective of this test is to verify the status line and status code from the getweatherdetails GET request.

package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test4 {
	
	@Test
	public void getweatherdetails () {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,"/Delhi");
		String responseBody = response.getBody().asString();
		System.out.println("Response is: "+ responseBody);
		
		// 1
		Assert.assertEquals(responseBody.contains("Delhi"),true);
		
		// comparing from json path
		JsonPath jp= response.jsonPath();
		System.out.println(jp.get("WeatherDescription"));
		Assert.assertEquals(jp.get("WeatherDescription"),"smoke");
		Assert.assertEquals(jp.get("Humidity"),"63 Percent");
		Assert.assertEquals(jp.get("WindDirectionDegree"),"320 Degree");
		
	}

}
