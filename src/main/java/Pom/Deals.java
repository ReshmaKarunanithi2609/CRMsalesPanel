package Pom;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class Deals {

	public Deals(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(3)), this);
	}

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Deals'])[1]")
	public WebElement heading;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Deal Pipeline']")
	public WebElement dealPipelineTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Track and Manage')]")
	public WebElement subHeading;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Total Pipeline']")
	public WebElement totalPipelineCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Won Deals']")
	public WebElement wonDealsCard;

	@AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
	public WebElement searchBox; // VERIFY

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='All']")
	public WebElement chipAll;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'new leads')]")
	public WebElement chipNewLeads;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'contacted')]")
	public WebElement chipContacted;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'proposal sent')]")
	public WebElement chipProposalSent;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'negotiation')]")
	public WebElement chipNegotiation;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'closed won')]")
	public WebElement chipClosedWon;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CONTACTED']")
	public WebElement contactedHeader;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CLOSED WON']")
	public WebElement closedWonHeader;

	@AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text,'Probability')])[1]")
	public WebElement firstDealProbability;

	@AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text,'₹')])[1]")
	public WebElement firstDealAmount;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Create new deal']")
	public WebElement createDealButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Deal Name')]")
	public WebElement dealNameLabel; // label taken from the Excel test cases

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Customer']")
	public WebElement customerLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Stage']")
	public WebElement stageLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Deal Value')]")
	public WebElement dealValueLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Probability')]")
	public WebElement probabilityLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Expected')]")
	public WebElement expectedDateLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Description']")
	public WebElement descriptionLabel;

	@AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text,'Deal Name')]/following::android.widget.EditText)[1]")
	public WebElement dealNameField; // VERIFY

	@AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text,'Deal Value')]/following::android.widget.EditText)[1]")
	public WebElement dealValueField; // VERIFY

	@AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text,'Probability')]/following::android.widget.EditText)[1]")
	public WebElement probabilityField; // VERIFY

	@AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text,'Description')]/following::android.widget.EditText)[1]")
	public WebElement descriptionField; // VERIFY

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Save']")
	public WebElement saveButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Cancel']")
	public WebElement cancelButton;

}
