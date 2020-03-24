package com.appiumframework.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities {
	
	AndroidDriver<AndroidElement>driver;
	
	//driver comes from testcase
	public Utilities(AndroidDriver<AndroidElement>driver) {
		
		//gives life to local driver
		this.driver =driver;
	}
	
	// wait for element
		public void waitForElement(int time, String id) {

			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));

		}

	
	
	// scroll " + containedText + "
		public void scroll(String TextValue) {
			driver.findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + TextValue + "\"))");
		}
		
		public void scrollandClick(String TextValue) {
			driver.findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + TextValue + "\"))");
			driver.findElementByAndroidUIAutomator("text(\"" + TextValue + "\")").click();
		}
		
		public void selectProductAndAddToCart(String id, String product, String TextValue) {

			int count = driver.findElementsById(id).size();

			for (int i = 0; i < count; i++) {

				String productName = driver.findElementsById(id).get(i).getText();

				if (productName.equalsIgnoreCase(product)) {
					driver.findElementsById(id).get(i).click();
					// ADD TO CART
					driver.findElementByAndroidUIAutomator("text(\"" + TextValue + "\")").click();
					break;

				}

			}

		}

		public double getAmount(String value) {

			double amountValue = Double.parseDouble(value);
			return amountValue;

		}

		public void wait(int time) {
			try {
				Thread.sleep(time * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
