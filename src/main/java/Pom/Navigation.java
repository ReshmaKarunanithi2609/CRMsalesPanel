package Pom;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class Navigation {

	public Navigation(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(3)), this);
	}

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@clickable='true'])[1]")
	public WebElement menuIcon;

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@clickable='true'])[2]")
	public WebElement bellIcon;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Dashboard'])[last()]")
	public WebElement tabDashboard;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Leads'])[last()]")
	public WebElement tabLeads;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Attendance'])[last()]")
	public WebElement tabAttendance;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Profile'])[last()]")
	public WebElement tabProfile;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='My Leads'])[last()]")
	public WebElement sideMyLeads;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Follow-Ups'])[last()]")
	public WebElement sideFollowUps;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Deals'])[last()]")
	public WebElement sideDeals;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Quotations'])[last()]")
	public WebElement sideQuotations;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Customers'])[last()]")
	public WebElement sideCustomers;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Orders'])[last()]")
	public WebElement sideOrders;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Payments'])[last()]")
	public WebElement sidePayments;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Supports'])[last()]")
	public WebElement sideSupports;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Reports'])[last()]")
	public WebElement sideReports;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Profile'])[last()]")
	public WebElement sideProfile;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Logout'])[last()]")
	public WebElement sideLogout;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Notifications']")
	public WebElement notificationsHeading;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Success']")
	public WebElement successToast;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Error']")
	public WebElement errorToast;

	@AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'Welcome')]")
	public WebElement dashboardWelcome;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Login Your Account']")
	public WebElement loginHeading;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Lead Managment']")
	public WebElement leadsTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Time Clock']")
	public WebElement timeClockTab;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Export Profile']")
	public WebElement exportProfileButton;

}
