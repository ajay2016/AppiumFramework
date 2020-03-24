package com.appiumframework.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	
	//screenshot
	
	public static String captureScreenshot(WebDriver driver) {
		
		
	String screenshotpath = System.getProperty("user.dir") + "\\Screenshots\\"+getCurrentDateTime()+".png";	
	File srecFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File DestFile = new File(screenshotpath);
	try {
		FileHandler.copy(srecFile, DestFile);
	} catch (IOException e) {
		System.out.println("Unable to capture screenshot"+e.getMessage());
		e.printStackTrace();
	}
	return screenshotpath;
		
	}
	
	public static String getCurrentDateTime() {
		
		DateFormat customFormat = new SimpleDateFormat("yyyy_MM_dd_HHmmss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
		
	}

}
