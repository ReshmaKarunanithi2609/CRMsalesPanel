package Pom;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class Orders {

	public Orders(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(3)), this);
	}

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Orders'])[1]")
	public WebElement heading;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Order Management']")
	public WebElement orderManagementTitle;

	@AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
	public WebElement searchBox; // VERIFY

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Order List')]")
	public WebElement orderListLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='All']")
	public WebElement chipAll;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Completed']")
	public WebElement chipCompleted;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Processing']")
	public WebElement chipProcessing;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Cancelled']")
	public WebElement chipCancelled;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ORDER ID']")
	public WebElement orderIdHeader;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='STATUS']")
	public WebElement statusHeader;

	@AndroidFindBy(xpath = "(//android.widget.TextView[starts-with(@text,'#ORDER')])[1]")
	public WebElement firstOrder;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Customer']")
	public WebElement customerLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Order Date']")
	public WebElement orderDateLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Total']")
	public WebElement totalLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='View Details']")
	public WebElement viewDetailsButton;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='PROCESSING'])[1]")
	public WebElement processingBadge;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Create New Order'])[last()]")
	public WebElement createNewOrderButton;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Create New Order'])[1]")
	public WebElement createOrderTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Customer Information']")
	public WebElement customerInformationTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Select Quotation']")
	public WebElement selectQuotationLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Customer Name']")
	public WebElement customerNameLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Email']")
	public WebElement emailLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Phone Number']")
	public WebElement phoneNumberLabel;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Customer Name']/following::android.widget.EditText)[1]")
	public WebElement customerNameField; // VERIFY

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Email']/following::android.widget.EditText)[1]")
	public WebElement emailField; // VERIFY

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Phone Number']/following::android.widget.EditText)[1]")
	public WebElement phoneField; // VERIFY

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Shipping Address']")
	public WebElement shippingAddressLabel;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Shipping Address']/following::android.widget.EditText)[1]")
	public WebElement shippingAddressField; // VERIFY

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Billing Address']/following::android.widget.EditText)[1]")
	public WebElement billingAddressField; // VERIFY

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue']")
	public WebElement continueButton;

}
