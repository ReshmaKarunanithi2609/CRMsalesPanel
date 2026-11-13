package Pom;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class Profile {

	public Profile(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(3)), this);
	}

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Profile'])[1]")
	public WebElement heading;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Export Profile']")
	public WebElement exportProfileButton;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Edit Profile'])[1]")
	public WebElement editProfileButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Account Created on')]")
	public WebElement accountCreatedText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
	public WebElement tabSettings;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Help']")
	public WebElement tabHelp;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='About']")
	public WebElement tabAbout;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Notification Setting']")
	public WebElement notificationSettingLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Bio metric']")
	public WebElement bioMetricLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Email']")
	public WebElement emailLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SMS']")
	public WebElement smsLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Push Notification']")
	public WebElement pushNotificationLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Security Setting']")
	public WebElement securitySettingLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='2FA Authentication']")
	public WebElement twoFaLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Change Password']")
	public WebElement changePasswordLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Other Settings']")
	public WebElement otherSettingsLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Language Preference']")
	public WebElement languagePreferenceLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Account Status']")
	public WebElement accountStatusLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Logout']")
	public WebElement logoutButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Help & Support']")
	public WebElement helpAndSupportLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Help Center']")
	public WebElement helpCenterLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='FAQ']")
	public WebElement faqLabel;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Contact Support'])[1]")
	public WebElement contactSupportLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='About & Policy']")
	public WebElement aboutAndPolicyLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Terms')]")
	public WebElement termsLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy Policy']")
	public WebElement privacyPolicyLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Cookies Policy']")
	public WebElement cookiesPolicyLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Licenses']")
	public WebElement licensesLabel;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Name']/following::android.widget.EditText)[1]")
	public WebElement nameField; 

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Email']/following::android.widget.EditText)[1]")
	public WebElement emailField;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Phone Number']/following::android.widget.EditText)[1]")
	public WebElement phoneNumberField;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='User Name']/following::android.widget.EditText)[1]")
	public WebElement userNameField; 

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Update Profile']")
	public WebElement updateProfileButton;

}
