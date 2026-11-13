package utils;

import Driverfactory.DriverManager;
import io.appium.java_client.android.AndroidDriver;


public class SessionManager {

	public static void prepare(boolean freshApp) {
		AndroidDriver driver = DriverManager.getDriver();
		ElementUtils utils = new ElementUtils(driver);
		Pom.Login login = new Pom.Login(driver);

		if (!utils.isAppInForeground()) {
			utils.activateApp();
		}
		if (freshApp) {
			utils.clearAppData();
			if (!utils.isDisplayed(login.heading, 20)) {
				throw new AssertionError("Login screen is not displayed after clearing the app data");
			}
			return;
		}
		if (utils.isDisplayed(login.heading, 4)) {
			login(driver, utils);
		}
		goHome(driver, utils);
	}

	private static void login(AndroidDriver driver, ElementUtils utils) {
		Pom.Login login = new Pom.Login(driver);
		Pom.Dashboard dash = new Pom.Dashboard(driver);
		utils.sendKeys(login.emailField, ConfigReader.get("validEmail"));
		utils.sendKeys(login.passwordField, ConfigReader.get("validPassword"));
		utils.hideKeyboardIfShown();
		utils.click(login.loginButton);
		if (!utils.isDisplayed(dash.welcomeHeader, 25)) {
			throw new AssertionError("Login with the registered credentials failed: Dashboard is not displayed");
		}
	}

	
	private static void goHome(AndroidDriver driver, ElementUtils utils) {
		Pom.Navigation nav = new Pom.Navigation(driver);
		Pom.Login login = new Pom.Login(driver);
		for (int attempt = 0; attempt < 5; attempt++) {
			if (utils.isDisplayed(nav.tabDashboard, 2)) {
				utils.click(nav.tabDashboard);
				if (utils.isDisplayed(nav.dashboardWelcome, 3)) {
					return;
				}
			}
			utils.pressBack();
			if (!utils.isAppInForeground()) {
				utils.activateApp();
			}
			if (utils.isDisplayed(login.heading, 3)) {
				login(driver, utils);
				return;
			}
		}
		
		driver.terminateApp(ConfigReader.get("appPackage"));
		utils.activateApp();
		if (utils.isDisplayed(login.heading, 10)) {
			login(driver, utils);
		}
	}
}
