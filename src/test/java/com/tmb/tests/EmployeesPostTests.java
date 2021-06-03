package com.tmb.tests;

import com.tmb.requestbuilder.*;


import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.RequestBuilder;
import org.testng.annotations.Test;

import com.tmb.constants.FrameworkConstants;
import com.tmb.utils.RandomUtils;
import com.tmb.utils.TestUtils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EmployeesPostTests {

	@Test
	public void postRequestAsString() {
		Response response = 
				com.tmb.requestbuilder.RequestBuilder.getBuilder()
				.body("{\r\n"
						+ "    \"id\": 14,\r\n"
						+ "    \"first_name\": \"testing\",\r\n"
						+ "    \"last_name\": \"Sakthivel1\",\r\n"
						+ "    \"email\": \"checking@gmail.com\",\r\n"
						+ "    \"job\":[\"tester\",\"trainer\"],\r\n"
						+ "	\"empid\":14,\r\n"
						+ "    \"favfood\":{\r\n"
						+ "        \"breakfast\":\"dosa\",\r\n"
						+ "        \"lunch\":\"rice\",\r\n"
						+ "		\"dinner\":[\"chapathi\",\"chicken\"]\r\n"
						+ "    }\r\n"
						+ "}\r\n"
						+ "}")
				.post(FrameworkConstants.getEmployeesendpoiunt()); 
		assertThat(response.getStatusCode())
		.isEqualTo(201);


	}


	@Test
	public void postRequestUsingMap() {

		Map<String,Object> map = new HashMap<>();



		map.put("id", RandomUtils.generateRandomNumericString(3));
		map.put("first_name", RandomUtils.generateRandomString(6));

		Response response  = com.tmb.requestbuilder.RequestBuilder.getBuilder()
				.body(map)
				.post(FrameworkConstants.getEmployeesendpoiunt());

		response.prettyPrint();


		assertThat(response.getStatusCode()).isEqualTo(201);


	}


	public void postRequestBYReadingJsonfile() throws IOException {


		String reqbody = TestUtils.getJsonFileAsString(FrameworkConstants.getReqbodyfolderpath()+"test.json");
		String reqbodyNew = reqbody.replace("999", RandomUtils.generateRandomNumericString(3));
		Response response  = given()
				.baseUri(FrameworkConstants.getBaseuri())
				.contentType(ContentType.JSON)
				.body(reqbodyNew)
				.post(FrameworkConstants.getEmployeesendpoiunt());

		response.prettyPrint();


		assertThat(response.getStatusCode()).isEqualTo(201);




	}

}
