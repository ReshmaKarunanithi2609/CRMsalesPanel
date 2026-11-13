package Pom;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class Quotations {

	public Quotations(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(3)), this);
	}

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Quotations'])[1]")
	public WebElement heading;

	@AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
	public WebElement searchBox; 

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='All'])[1]")
	public WebElement chipAll;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Approved')]")
	public WebElement chipApproved;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Sent')]")
	public WebElement chipSent;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Rejected')]")
	public WebElement chipRejected;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='QUOTATION ID']")
	public WebElement quotationIdHeader;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='STATUS']")
	public WebElement statusHeader;

	@AndroidFindBy(xpath = "(//android.widget.TextView[starts-with(@text,'#QUO')])[1]")
	public WebElement firstQuotation;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Customer']")
	public WebElement customerLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Date Issued']")
	public WebElement dateIssuedLabel;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Valid Until'])[1]")
	public WebElement validUntilLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Total']")
	public WebElement totalLabel;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Create Quotation'])[last()]")
	public WebElement createQuotationButton; 

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Customer Information']")
	public WebElement customerInformationLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Quotation Details']")
	public WebElement quotationDetailsLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Select Customer']")
	public WebElement selectCustomerDropdown;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Discount (%)')]")
	public WebElement discountLabel;

	@AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text,'Discount')]/following::android.widget.EditText)[1]")
	public WebElement discountField; 

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Tax (%)')]")
	public WebElement taxLabel;

	@AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text,'Tax')]/following::android.widget.EditText)[1]")
	public WebElement taxField;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Line Items']")
	public WebElement lineItemsLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Add Item']")
	public WebElement addItemButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Notes']")
	public WebElement notesLabel;

	@AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text,'Notes')]/following::android.widget.EditText)[1]")
	public WebElement notesField;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Terms')]")
	public WebElement termsLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Summary']")
	public WebElement summaryLabel;

}
