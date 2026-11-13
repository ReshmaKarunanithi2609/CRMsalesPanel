package Pom;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class Login {

	public Login(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(3)), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Login Your Account']")
	public WebElement heading;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CRM Sales']")
	public WebElement subHeading;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Email or Mobile Number']")
	public WebElement emailLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Password']")
	public WebElement passwordLabel;

	@AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
	public WebElement emailField; // VERIFY

	@AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
	public WebElement passwordField; // VERIFY

	@AndroidFindBy(xpath = "(//android.widget.EditText)[2]/following::android.view.ViewGroup[@clickable='true'][1]")
	public WebElement eyeIcon; // VERIFY

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Remember me']")
	public WebElement rememberMe;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Forgot Password?']")
	public WebElement forgotPassword;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Log In']")
	public WebElement loginButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'have an account')]")
	public WebElement noAccountText;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Sign up')]")
	public WebElement signUpLink; // VERIFY

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Enter your email')]")
	public WebElement emailRequiredMessage;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Enter your password')]")
	public WebElement passwordRequiredMessage;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Create your account')]")
	public WebElement signUpTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Full Name']")
	public WebElement fullNameLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Sign In Instead')]")
	public WebElement signInInstead;

}
