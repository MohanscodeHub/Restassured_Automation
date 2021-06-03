package com.tmb.constants;

import lombok.Getter;

@Getter 
public final class FrameworkConstants {

	private FrameworkConstants() {



	}

	private static final String BASEURI = "http://locahost:3000";
	private static  final String EMPLOYEESENDPOIUNT = "/employees";
	private static  final String  REQBODYFOLDERPATH ="/src/test/resources/requestbody/test.json/";

	public static String getBaseuri() {
		return BASEURI;

	}

	public static String getEmployeesendpoiunt() {
		return EMPLOYEESENDPOIUNT;
	}

	public static String getReqbodyfolderpath() {
		return REQBODYFOLDERPATH;
	}


}
