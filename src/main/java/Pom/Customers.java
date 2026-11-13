package Pom;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class Customers {

	public Customers(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(3)), this);
	}

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Customers'])[1]")
	public WebElement heading;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Customer Management']")
	public WebElement customerManagementTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Manage customer information')]")
	public WebElement subHeading;

	@AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
	public WebElement searchBox; // VERIFY

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Customer List')]")
	public WebElement customerListLabel;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='View'])[1]")
	public WebElement firstViewButton;

}
