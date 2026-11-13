package Pom;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class SupportTickets {

	public SupportTickets(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(3)), this);
	}

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Support Tickets'])[1]")
	public WebElement heading;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Manage Customer Support Requests']")
	public WebElement subHeading;

	@AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
	public WebElement searchBox; 

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Open'])[1]")
	public WebElement openCard;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='In Progress'])[1]")
	public WebElement inProgressCard;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Resolved'])[1]")
	public WebElement resolvedCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='High Priority']")
	public WebElement highPriorityCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Ticket List']")
	public WebElement ticketListLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'All (')]")
	public WebElement chipAll;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Open'])[last()]")
	public WebElement chipOpen;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='In Progress'])[last()]")
	public WebElement chipInProgress;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='On Hold']")
	public WebElement chipOnHold;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Closed']")
	public WebElement chipClosed;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Create Ticket'])[last()]")
	public WebElement createTicketButton;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Create Ticket'])[1]")
	public WebElement createTicketTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Raise a support request')]")
	public WebElement raiseText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Customer Account']")
	public WebElement customerAccountLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Select Customer']")
	public WebElement selectCustomerValue;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Subject']")
	public WebElement subjectLabel;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Subject']/following::android.widget.EditText)[1]")
	public WebElement subjectField; 
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Category']")
	public WebElement categoryLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Technical']")
	public WebElement categoryValue;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Priority SLA']")
	public WebElement prioritySlaLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Medium']")
	public WebElement priorityValue;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Description')]")
	public WebElement descriptionLabel;

	@AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text,'Description')]/following::android.widget.EditText)[1]")
	public WebElement descriptionField; 

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Maximum 1800')]")
	public WebElement maxCharactersText;

}
