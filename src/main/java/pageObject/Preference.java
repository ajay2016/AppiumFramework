package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Preference {

	public Preference(AndroidDriver <AndroidElement>driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// locator
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = '3. Preference dependencies']")
	// return type
	public WebElement dependencies;

}
