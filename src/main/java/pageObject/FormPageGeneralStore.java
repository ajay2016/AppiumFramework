package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPageGeneralStore {
	
	//Constructor
		 public FormPageGeneralStore(AndroidDriver<AndroidElement> driver) {
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
		
		
		//locator
		@AndroidFindBy(className ="android.widget.Spinner")
		//return type
		public WebElement selectCountry;
		
		@AndroidFindBy(uiAutomator = "text(\"Enter name here\")")
		public WebElement textbox;

		@AndroidFindBy(uiAutomator = "text(\"Female\")")
		public WebElement checkbox;
		
		@AndroidFindBy(uiAutomator = "text(\"Let's  Shop\")")
		public WebElement shopButton;
		
		
		//method to log information on locator
		//calling page object as a method
		public WebElement getSelectCountry() {
			System.out.println("Selecting Country");
			return selectCountry;
		}
}
