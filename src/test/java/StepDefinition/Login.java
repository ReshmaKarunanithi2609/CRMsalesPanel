package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import Driverfactory.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ElementUtils;
import utils.PageElements;


public class Login {

	private final AndroidDriver driver = DriverManager.getDriver();
	private final ElementUtils utils = new ElementUtils(driver);
	private final Pom.Navigation nav = new Pom.Navigation(driver);
	private final Pom.Messages msg = new Pom.Messages(driver);
	private final Pom.Login page = new Pom.Login(driver);

	private WebElement el(String name) {
		return PageElements.find(name, page, nav, msg);
	}

	@When("User opens the Login screen")
	public void user_opens_the_screen() {
		utils.assertDisplayed("Login screen", page.heading);
	}

	@When("User taps {string} on the Login screen")
	public void user_taps(String name) {
		utils.click(el(name));
	}

	@When("User taps {string} {int} times quickly on the Login screen")
	public void user_taps_times_quickly(String name, Integer times) {
		utils.tapRepeatedly(el(name), times);
	}

	@When("User enters {string} in {string} on the Login screen")
	public void user_enters(String value, String name) {
		utils.sendKeys(el(name), value);
		utils.hideKeyboardIfShown();
	}

	@When("User enters {int} characters in {string} on the Login screen")
	public void user_enters_characters(Integer count, String name) {
		utils.sendKeys(el(name), "a".repeat(count));
		utils.hideKeyboardIfShown();
	}

	@When("User scrolls to the text {string} on the Login screen")
	public void user_scrolls_to_the_text(String text) {
		utils.scrollToText(text);
	}

	@When("User swipes the filter row from {string} on the Login screen")
	public void user_swipes_the_filter_row(String name) {
		utils.swipeRowLeft(el(name));
	}

	@Then("User should see {string} on the Login screen")
	public void user_should_see(String name) {
		utils.assertDisplayed(name, el(name));
	}

	@Then("User should not see {string} on the Login screen")
	public void user_should_not_see(String name) {
		utils.assertNotDisplayed(name, el(name));
	}

	@Then("{string} should contain {string} on the Login screen")
	public void should_contain(String name, String value) {
		String actual = utils.getText(el(name));
		Assert.assertTrue(name + " contains '" + actual + "' but expected '" + value + "'", actual.contains(value));
	}

	@Then("{string} should be empty on the Login screen")
	public void should_be_empty(String name) {
		Assert.assertTrue(name + " is not empty", utils.getText(el(name)).trim().isEmpty());
	}

	private final Pom.Dashboard dash = new Pom.Dashboard(driver);

	@When("User enters the registered email on the Login screen")
	public void user_enters_the_registered_email() {
		utils.sendKeys(page.emailField, utils.configEmail());
	}

	@When("User enters the registered password on the Login screen")
	public void user_enters_the_registered_password() {
		utils.sendKeys(page.passwordField, utils.configPassword());
	}

	@When("User enters the registered email in upper case on the Login screen")
	public void user_enters_the_registered_email_in_upper_case() {
		utils.sendKeys(page.emailField, utils.configEmail().toUpperCase());
	}

	@When("User enters the registered password in a different letter case on the Login screen")
	public void user_enters_the_registered_password_in_a_different_case() {
		StringBuilder sb = new StringBuilder();
		for (char c : utils.configPassword().toCharArray()) {
			sb.append(Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
		}
		utils.sendKeys(page.passwordField, sb.toString());
	}

	@When("User taps the Sign up link on the Login screen")
	public void user_taps_the_sign_up_link() {
		utils.tapFraction(page.signUpLink, 0.80, 0.5); // VERIFY: the link is nested text inside the sentence
	}

	@Then("User should be navigated to the Dashboard")
	public void user_should_be_navigated_to_the_dashboard() {
		utils.assertDisplayed("Dashboard welcome header", dash.welcomeHeader);
	}
}
