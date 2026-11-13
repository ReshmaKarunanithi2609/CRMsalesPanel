package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import Driverfactory.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ElementUtils;
import utils.PageElements;


public class Attendance {

	private final AndroidDriver driver = DriverManager.getDriver();
	private final ElementUtils utils = new ElementUtils(driver);
	private final Pom.Navigation nav = new Pom.Navigation(driver);
	private final Pom.Messages msg = new Pom.Messages(driver);
	private final Pom.Attendance page = new Pom.Attendance(driver);

	private WebElement el(String name) {
		return PageElements.find(name, page, nav, msg);
	}

	@When("User opens the Attendance screen")
	public void user_opens_the_screen() {
		utils.click(nav.tabAttendance);
	}

	@When("User taps {string} on the Attendance screen")
	public void user_taps(String name) {
		utils.click(el(name));
	}

	@When("User taps {string} {int} times quickly on the Attendance screen")
	public void user_taps_times_quickly(String name, Integer times) {
		utils.tapRepeatedly(el(name), times);
	}

	@When("User enters {string} in {string} on the Attendance screen")
	public void user_enters(String value, String name) {
		utils.sendKeys(el(name), value);
		utils.hideKeyboardIfShown();
	}

	@When("User enters {int} characters in {string} on the Attendance screen")
	public void user_enters_characters(Integer count, String name) {
		utils.sendKeys(el(name), "a".repeat(count));
		utils.hideKeyboardIfShown();
	}

	@When("User scrolls to the text {string} on the Attendance screen")
	public void user_scrolls_to_the_text(String text) {
		utils.scrollToText(text);
	}

	@When("User swipes the filter row from {string} on the Attendance screen")
	public void user_swipes_the_filter_row(String name) {
		utils.swipeRowLeft(el(name));
	}

	@Then("User should see {string} on the Attendance screen")
	public void user_should_see(String name) {
		utils.assertDisplayed(name, el(name));
	}

	@Then("User should not see {string} on the Attendance screen")
	public void user_should_not_see(String name) {
		utils.assertNotDisplayed(name, el(name));
	}

	@Then("{string} should contain {string} on the Attendance screen")
	public void should_contain(String name, String value) {
		String actual = utils.getText(el(name));
		Assert.assertTrue(name + " contains '" + actual + "' but expected '" + value + "'", actual.contains(value));
	}

	@Then("{string} should be empty on the Attendance screen")
	public void should_be_empty(String name) {
		Assert.assertTrue(name + " is not empty", utils.getText(el(name)).trim().isEmpty());
	}
}
