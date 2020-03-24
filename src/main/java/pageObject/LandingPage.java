package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LandingPage {
	
	//Constructor
	 public LandingPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	//locator
	@AndroidFindBy(xpath="//android.widget.TextView[@text = 'Preference']")
	//return type
	public WebElement preference;

}
