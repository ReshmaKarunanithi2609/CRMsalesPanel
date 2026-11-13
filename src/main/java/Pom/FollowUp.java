package Pom;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class FollowUp {

	public FollowUp(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(3)), this);
	}

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Follow-Up Management'])[1]")
	public WebElement heading;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'New Schedule')]")
	public WebElement newScheduleButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Total no of')]")
	public WebElement totalFollowUpCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Completed this')]")
	public WebElement completedThisWeekCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Success Rate']")
	public WebElement successRateCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Follow-Up schedules')]")
	public WebElement schedulesHeading;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'pending')]")
	public WebElement pendingBadge;

	@AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text,'@')])[1]")
	public WebElement firstScheduleEmail;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Notes'])[1]")
	public WebElement notesLabel;

	@AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
	public WebElement searchBox; // VERIFY

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Schedule Lead Follow-Up')]")
	public WebElement popupTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Schedule Lead Follow-Up')]/following::android.view.ViewGroup[@clickable='true'][1]")
	public WebElement popupCloseIcon; // VERIFY

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Contact Name']")
	public WebElement contactNameLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Company']")
	public WebElement companyLabel;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Email Address']/following::android.widget.EditText)[1]")
	public WebElement emailField; // VERIFY

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Phone Number']/following::android.widget.EditText)[1]")
	public WebElement phoneField; // VERIFY

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Type']")
	public WebElement typeLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Phone Call']")
	public WebElement typeValue;

	@AndroidFindBy(xpath = "((//android.widget.TextView[@text='Date'])[last()]/following::android.widget.EditText)[1]")
	public WebElement dateField; // VERIFY

	@AndroidFindBy(xpath = "((//android.widget.TextView[@text='Time'])[last()]/following::android.widget.EditText)[1]")
	public WebElement timeField; // VERIFY

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Priority']")
	public WebElement priorityLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='High']")
	public WebElement priorityValue;

	@AndroidFindBy(xpath = "((//android.widget.TextView[@text='Notes'])[last()]/following::android.widget.EditText)[1]")
	public WebElement notesField; // VERIFY

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Cancel']")
	public WebElement cancelButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Schedule FollowUp']")
	public WebElement scheduleButton;

}
