//mvn serenity:aggregate
package com.api.junit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;

@RunWith(SerenityRunner.class)
public class SerenityApiTest01 {

	@BeforeClass
	public static void init() {
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	}
	
	@Test
	public void GetApi_Response() {
		System.out.println("API Test Started");
		RestAssured.given()
			.when()
			.get("/Hyderabad")
			.then()
			.log()
			.all()
			.statusCode(200);
	}
}