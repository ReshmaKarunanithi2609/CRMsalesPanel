package Pom;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class Dashboard {

	public Dashboard(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(3)), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'Welcome')]")
	public WebElement welcomeHeader;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Start Working']")
	public WebElement startWorking;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Clock In']")
	public WebElement clockInButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Performance')]")
	public WebElement performanceOverview;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'From Last Month')]")
	public WebElement growthText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Total Sales']")
	public WebElement totalSales;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Win Rate']")
	public WebElement winRate;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Your Sales']")
	public WebElement yourSales;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='My Leads']")
	public WebElement myLeadsCard;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Active Deals'])[1]")
	public WebElement activeDealsCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Revenue Closed']")
	public WebElement revenueClosedCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Pipeline Value']")
	public WebElement pipelineValueCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Conversion Rate']")
	public WebElement conversionRateLabel; 

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Recent Leads']")
	public WebElement recentLeadsTab;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Active Deals'])[last()]")
	public WebElement activeDealsTab;

	@AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text,'@')])[1]")
	public WebElement firstLeadEmail;

	@AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text,'₹')])[1]")
	public WebElement firstDealAmount;

}
