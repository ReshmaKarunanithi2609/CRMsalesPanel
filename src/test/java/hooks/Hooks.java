package hooks;

import Driverfactory.DriverFactory;
import Driverfactory.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import utils.ElementUtils;
import utils.SessionManager;

public class Hooks {

	//One Appium session for the whole run: end to end, no new session and no new login per scenario. 
	@BeforeAll
	public static void startSession() {
		DriverManager.setDriver(DriverFactory.createDriver());
	}

	@AfterAll
	public static void endSession() {
		DriverManager.quitDriver();
	}

	@Before
	public void prepareScenario(Scenario scenario) {
		boolean loginModule = scenario.getSourceTagNames().contains("@Login");
		SessionManager.prepare(loginModule);
	}

	// Set screenshotEveryStep=true in config.properties to attach a screenshot after every step (bigger reports). 
	@AfterStep
	public void afterStep(Scenario scenario) {
		if (!Boolean.parseBoolean(ConfigReader.get("screenshotEveryStep"))) {
			return;
		}
		try {
			scenario.attach(new ElementUtils(DriverManager.getDriver()).screenshot(), "image/png", "Step screenshot");
		} catch (Exception e) {
			System.err.println("Could not attach step screenshot: " + e.getMessage());
		}
	}

	@After
	public void afterScenario(Scenario scenario) {
		ElementUtils utils = new ElementUtils(DriverManager.getDriver());
		try {
			if (scenario.isFailed()) {
				scenario.attach(utils.screenshot(), "image/png", "Failure screenshot");
			}
		} catch (Exception e) {
			System.err.println("Could not attach screenshot: " + e.getMessage());
		}
		try {
			utils.setAirplaneMode(false);
		} catch (Exception ignored) {
			// flight mode helper not supported
		}
		try {
			utils.rotatePortrait();
		} catch (Exception ignored) {
			// already portrait
		}
	}
}
