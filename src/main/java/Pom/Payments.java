package Pom;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class Payments {

	public Payments(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(3)), this);
	}

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Payment Tracking'])[1]")
	public WebElement heading;

	@AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
	public WebElement searchBox; 

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Total invoiced']")
	public WebElement totalInvoicedCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Collected']")
	public WebElement collectedCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Pending']")
	public WebElement pendingCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Collected Rate']")
	public WebElement collectedRateCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Invoices and Payments']")
	public WebElement invoicesAndPaymentsLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='QUOTATION ID']")
	public WebElement quotationIdHeader;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='STATUS']")
	public WebElement statusHeader;

	@AndroidFindBy(xpath = "(//android.widget.TextView[starts-with(@text,'#INV')])[1]")
	public WebElement firstInvoice;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Follow-Up'])[1]")
	public WebElement followUpBadge;

	@AndroidFindBy(xpath = "(//android.widget.TextView[starts-with(@text,'#INV')])[1]/following::*[@clickable='true'][1]")
	public WebElement eyeIcon; 

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Customer']")
	public WebElement customerLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Date']")
	public WebElement dateLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Amount']")
	public WebElement amountLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Paid']")
	public WebElement paidLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Balance']")
	public WebElement balanceLabel;

}
