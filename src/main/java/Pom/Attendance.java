package Pom;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class Attendance {

	public Attendance(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(3)), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Time Clock']")
	public WebElement timeClockTab;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Stats']")
	public WebElement statsTab;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Still You not Check In']")
	public WebElement stillNotCheckIn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Ready to Leave ?']")
	public WebElement readyToLeave;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Still You not Check In']/preceding::android.view.ViewGroup[@clickable='true'][1]")
	public WebElement checkInButton; // VERIFY

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Request Leave']")
	public WebElement requestLeaveLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Apply Leave']")
	public WebElement applyLeaveLabel;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Apply']")
	public WebElement applyButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Leave Date']")
	public WebElement leaveDateHeader;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='STATUS']")
	public WebElement leaveStatusHeader;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Approved'])[1]")
	public WebElement approvedStatus;

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Rejected'])[1]")
	public WebElement rejectedStatus;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Working Days']")
	public WebElement workingDays;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Present Day']")
	public WebElement presentDay;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Absent']")
	public WebElement absent;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Workdays stats']")
	public WebElement workdaysStats;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Working Hours']")
	public WebElement workingHours;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Apply Leave Form']")
	public WebElement applyLeaveForm;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Write a Reason')]")
	public WebElement writeReasonLabel;

	@AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
	public WebElement reasonField; // VERIFY

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'character left')]")
	public WebElement charactersLeftText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Request']")
	public WebElement requestButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Close']")
	public WebElement closeButton;

}
