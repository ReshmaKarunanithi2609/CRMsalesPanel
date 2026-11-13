package Pom;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class Reports {

	public Reports(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(3)), this);
	}

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Reports'])[1]")
	public WebElement heading;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Reports & Analytics']")
	public WebElement reportsAnalyticsTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Business insights')]")
	public WebElement subHeading;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Overview']")
	public WebElement tabOverview;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Leads'])[1]")
	public WebElement tabLeads;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Sales']")
	public WebElement tabSales;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Support']")
	public WebElement tabSupport;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Teams']")
	public WebElement tabTeams;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Total Revenue']")
	public WebElement totalRevenueCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Total Customer']")
	public WebElement totalCustomerCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Conversation Rate']")
	public WebElement conversationRateCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Active task']")
	public WebElement activeTaskCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Sales Pipeline']")
	public WebElement salesPipelineLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Total Pipeline']")
	public WebElement totalPipelineLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Won Deals']")
	public WebElement wonDealsLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Order Completion']")
	public WebElement orderCompletionLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Financial Summary']")
	public WebElement financialSummaryLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Total Tickets']")
	public WebElement totalTicketsCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Open Tickets']")
	public WebElement openTicketsCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Resolution Rate']")
	public WebElement resolutionRateCard;

	@AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text,'Won')])[1]")
	public WebElement teamWonBadge;

}
