package StepDefinition;

import org.junit.Assert;

import Driverfactory.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ElementUtils;


public class CommonSteps {

	private final AndroidDriver driver = DriverManager.getDriver();
	private final ElementUtils utils = new ElementUtils(driver);
	private final Pom.Navigation nav = new Pom.Navigation(driver);
	private final Pom.Messages msg = new Pom.Messages(driver);

	@Given("User is on the Dashboard screen")
	public void user_is_on_the_dashboard_screen() {
		utils.assertDisplayed("Dashboard", nav.dashboardWelcome);
	}

	@Given("User is on the Login screen")
	public void user_is_on_the_login_screen() {
		utils.assertDisplayed("Login screen", nav.loginHeading);
	}

	@When("User presses the device Back button")
	public void user_presses_the_device_back_button() {
		utils.pressBack();
	}

	@When("User closes and reopens the application")
	public void user_closes_and_reopens_the_application() {
		utils.closeAndReopenApp();
	}

	@When("User turns on flight mode")
	public void user_turns_on_flight_mode() {
		utils.setAirplaneMode(true);
	}

	@When("User turns off flight mode")
	public void user_turns_off_flight_mode() {
		utils.setAirplaneMode(false);
	}

	@When("User rotates the device to landscape")
	public void user_rotates_the_device_to_landscape() {
		utils.rotateLandscape();
	}

	@When("User rotates the device to portrait")
	public void user_rotates_the_device_to_portrait() {
		utils.rotatePortrait();
	}

	@Then("User should see a validation or error message")
	public void user_should_see_a_validation_or_error_message() {
		Assert.assertTrue("No validation or error message is displayed",
				utils.isDisplayed(msg.validationMessage, 15) || utils.isDisplayed(nav.errorToast, 3));
	}

	@Then("User should see the success message")
	public void user_should_see_the_success_message() {
		utils.assertDisplayed("Success message", nav.successToast);
	}

	@Then("User should see the no results message")
	public void user_should_see_the_no_results_message() {
		utils.assertDisplayed("No results message", msg.noResultsMessage);
	}

	@Then("User should see the no internet message")
	public void user_should_see_the_no_internet_message() {
		Assert.assertTrue("No internet message is not displayed",
				utils.isDisplayed(msg.noInternetMessage, 15) || utils.isDisplayed(nav.errorToast, 3));
	}

	@Then("The app should still respond")
	public void the_app_should_still_respond() {
		Assert.assertTrue("The CRM app is not in the foreground", utils.isAppInForeground());
	}

	@Then("The app should close or ask for exit confirmation")
	public void the_app_should_close_or_ask_for_exit_confirmation() {
		Assert.assertTrue("The app neither closed nor asked for exit confirmation",
				utils.isOtherAppInForeground() || utils.isDisplayed(msg.exitConfirmation, 3));
	}
}
