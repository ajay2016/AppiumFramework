package com.appiumframework.testcases;

import java.io.IOException;
import org.testng.annotations.Test;

import com.appiumframework.Base;
import com.appiumframework.testdata.TestData;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObject.LandingPage;
import pageObject.Preference;
import pageObject.PreferencesDepedencies;

public class ApiDemoTestPageObject extends Base {
	
	
	@Test(dataProvider = "InputData",dataProviderClass = TestData.class)
	public void ApiDemoTest(String value) throws IOException {
		
		startAppiumServer();
		
		//get driver object from base class .return driver
		AndroidDriver<AndroidElement> driver = desiredcapability("ApiDemoApp");
		
		 // creates a toggle for the given test, adds all log events under it
		 // ExtentTest test = extent.createTest("API Demo",
		//  "Demo API testing");
		  
		  // log(Status, details) 
		 // test.log(Status.INFO, "Selecting Country");
		
		LandingPage homepage = new LandingPage(driver);
		homepage.preference.click();
		
		Preference pref = new Preference(driver);
		pref.dependencies.click();
		
		
		PreferencesDepedencies pd = new PreferencesDepedencies(driver);
		pd.checkbox.click();
		pd.wifisetting.click();
		pd.editbox.sendKeys(value);
		pd.button.get(1).click();
		
		service.stop();
		
		
		
		


	}

}
