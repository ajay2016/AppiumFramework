package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PreferencesDepedencies {

	public PreferencesDepedencies(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	// locator
	@AndroidFindBy(id = "android:id/checkbox")
	// return type
	public WebElement checkbox;

	// locator
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'WiFi settings']")
	// return type
	public WebElement wifisetting;

	// locator
	@AndroidFindBy(className = "android.widget.EditText")
	// return type
	public WebElement editbox;

	// locator
	@AndroidFindBy(className = "android.widget.Button")
	// return type
	public List<WebElement> button;

}
