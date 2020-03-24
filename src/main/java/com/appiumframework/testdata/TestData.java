package com.appiumframework.testdata;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name="InputData")
	public static Object[][] getDataForEditField() {
		
		Object[][] data = new Object[][]
				
				{
			//Initialize on the fly
			{"Ajay"},{"!@#$%"}
				};
		return data;
	}
	
	@DataProvider(name="InputData1")
	public static Object[][] getDataForCountryAndName() {
		
		Object[][] data = new Object[][]
				
				{
			//Initialize on the fly
			{"Argentina","Ajay"},{"Australia","John"}
				};
		return data;
	}

}
