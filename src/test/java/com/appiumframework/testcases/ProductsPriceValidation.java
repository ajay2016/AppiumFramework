package com.appiumframework.testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.appiumframework.Base;
import com.appiumframework.testdata.TestData;
import com.appiumframework.utilities.Utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObject.CartPage;
import pageObject.FormPageGeneralStore;
import pageObject.ProductPage;

public class ProductsPriceValidation extends Base {
	
	@Test(dataProvider = "InputData1",dataProviderClass = TestData.class)
	public void priceValidationTest(String country, String name) throws IOException {	
        
		
		startAppiumServer();
		
		AndroidDriver<AndroidElement> driver = desiredcapability("GeneralStoreApp");
		
		
		  // creates a toggle for the given test, adds all log events under it
		 // ExtentTest test = extent.createTest("Price Validation Test",
		 // "Validates the price");
		  
		  // log(Status, details) 
		 // test.log(Status.INFO, "Selecting Country");
		 
		
		FormPageGeneralStore form = new FormPageGeneralStore(driver);
		
		form.getSelectCountry().click();
		//form.selectCountry.click();
		
		Utilities util = new Utilities(driver);
		util.scrollandClick(country);
		
		//driver.findElementByClassName("android.widget.Spinner").click();
		// scrolling until you find the object
		//scrollandClick("Argentina");
		
		form.textbox.sendKeys(name);
		// Enter name here
		//driver.findElementByAndroidUIAutomator("text(\"Enter name here\")").sendKeys("Ajay");
		// hide active keyboard
		driver.hideKeyboard();
		
		// Female
		form.checkbox.click();
		//driver.findElementByAndroidUIAutomator("text(\"Female\")").click();
		form.shopButton.click();
		//driver.findElementByAndroidUIAutomator("text(\"Let's  Shop\")").click();
		ProductPage product = new ProductPage(driver);
		product.addtocart.get(0).click();
		//		driver.findElementsByAndroidUIAutomator("text(\"ADD TO CART\")").get(0).click();
		// once you click on add to cart it changes to added to cart
		// use get(0) both time
		product.addtocart.get(0).click();
		//driver.findElementsByAndroidUIAutomator("text(\"ADD TO CART\")").get(0).click();
		// Add to cart
		product.cartbutton.click();
		//driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		// wait for element
		util.waitForElement(5, "com.androidsample.generalstore:id/productName");
		//waitForElement(5, "com.androidsample.generalstore:id/productName");
		
		CartPage cart = new CartPage(driver);
		
		int count = cart.price.size();
		
		//int count = driver.findElementsById("com.androidsample.generalstore:id/productPrice").size();
		Double Sum = 0.0;
		for(int i = 0; i<count; i++) {
			String amount = cart.price.get(i).getText().substring(1);
			//String amount = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText().substring(1);
			Double amount1 = util.getAmount(amount);
			//Double amount1 = getAmount(amount);
			Sum=Sum + amount1;			
			
		}
		System.out.println("Total price after adding items  $"+Sum);
		/*
		 * //com.androidsample.generalstore:id/productPrice String Price1 =
		 * driver.findElementsById("com.androidsample.generalstore:id/productPrice").get
		 * (0).getText().substring(1);;
		 * 
		 * String Price2 =
		 * driver.findElementsById("com.androidsample.generalstore:id/productPrice").get
		 * (1).getText().replaceAll("\\$", "");;
		 * //System.out.println(Price1+"  "+Price2); //String P1 =Price1.substring(1);
		 * //String P2 =Price2.replaceAll("\\$", ""); Double P1
		 * =Double.parseDouble(Price1); Double P2 =Double.parseDouble(Price2);
		 * //System.out.println(P1 +"  "+ P2);
		 * 
		 * Double Sum=P1+P2;
		 * System.out.println("Total price after adding items  $"+Sum);
		 */
		String TotalAmount = cart.totalAmount.getText().replaceAll("\\$", "");
		//String TotalAmount = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText().replaceAll("\\$", "");
		Double amount = Double.parseDouble(TotalAmount);
		System.out.println("Total Purchased Amount  $"+amount);
		Assert.assertEquals(amount, Sum);
		service.stop();
		
		

	}

}
