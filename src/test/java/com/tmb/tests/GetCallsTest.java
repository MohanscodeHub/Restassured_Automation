package com.tmb.tests;

import org.testng.annotations.Test;

import com.tmb.constants.FrameworkConstants;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import static org.assertj.core.api.Assertions.*;

//Run All

// never hard code
// readble tests
// keep the right thing at right place
public class GetCallsTest {
	
	@Test
	
	//Run | Debug
	
	public void getEmployeesTest() {
		
		Response response= given()
				.baseUri(FrameworkConstants.getBaseuri())
				.get(FrameworkConstants.getEmployeesendpoiunt());
		
		
		assertThat(response.getStatusCode())
		.isEqualTo(200);
		             
		
		
	}
	
public void getEmployeeDetail() {
		
	Response response=	given()
		.pathParam("id", 2)
		.baseUri(FrameworkConstants.getBaseuri())
		.get(FrameworkConstants.getEmployeesendpoiunt());
		
		
		assertThat(response.getStatusCode()).isEqualTo(200);
		assertThat(response.jsonPath().get("email")).isEqualTo("sjdfcv");
		             
		
		
	}

}
