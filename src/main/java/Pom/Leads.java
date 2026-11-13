package Pom;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class Leads {

	public Leads(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(3)), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Lead Managment']")
	public WebElement heading; 
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Manage and Track')]")
	public WebElement subHeading;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='New Lead']")
	public WebElement newLeadButton;

	@AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
	public WebElement searchBox; 

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='New Leads']")
	public WebElement newLeadsCard;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Interested'])[1]")
	public WebElement interestedCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Converted Leads']")
	public WebElement convertedLeadsCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Total Leads']")
	public WebElement totalLeadsCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'All')]")
	public WebElement chipAll;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Appointment']")
	public WebElement chipAppointment;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Followups')]")
	public WebElement chipFollowups;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Converted']")
	public WebElement chipConverted;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Closed']")
	public WebElement chipClosed;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Add New Lead']")
	public WebElement addLeadHeading;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Lead Status']")
	public WebElement leadStatusLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='New']")
	public WebElement statusNew;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Interested']")
	public WebElement statusInterested;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Converted']")
	public WebElement statusConverted;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Followup']")
	public WebElement statusFollowup;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Customer Information']")
	public WebElement customerInformation;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Customer Name']/following::android.widget.EditText)[1]")
	public WebElement customerNameField; 

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Product Interest']")
	public WebElement productInterestLabel;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Phone Number']/following::android.widget.EditText)[1]")
	public WebElement phoneNumberField; 

	@AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text,'Email')]/following::android.widget.EditText)[1]")
	public WebElement emailField; 

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Location']/following::android.widget.EditText)[1]")
	public WebElement locationField; 

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Lead Details']")
	public WebElement leadDetails;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Follow-up Date']/following::android.widget.EditText)[1]")
	public WebElement followUpDateField; 

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Follow-up Time']/following::android.widget.EditText)[1]")
	public WebElement followUpTimeField; 

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Manager Notes']")
	public WebElement managerNotesLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Telecaller Notes']")
	public WebElement telecallerNotesLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Sales Team Notes']")
	public WebElement salesTeamNotesLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Save']")
	public WebElement saveButton;

}
