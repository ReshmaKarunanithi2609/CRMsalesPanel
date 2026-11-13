package Driverfactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utils.ConfigReader;

public class DriverFactory {

	public static AndroidDriver createDriver() {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName(ConfigReader.get("platformName"));
		options.setAutomationName(ConfigReader.get("automationName"));
		options.setDeviceName(ConfigReader.get("deviceName"));
		options.setUdid(ConfigReader.get("udid"));
		String appPath = ConfigReader.get("appPath");
		if (!appPath.isEmpty()) {
			options.setApp(appPath);
		}
		options.setAppPackage(ConfigReader.get("appPackage"));
		options.setAppActivity(ConfigReader.get("appActivity"));
		options.setAppWaitActivity("*");
		options.setNoReset(Boolean.parseBoolean(ConfigReader.get("noReset")));
		options.setAutoGrantPermissions(true);
		options.setNewCommandTimeout(Duration.ofSeconds(300));
		try {
			return new AndroidDriver(new URL(ConfigReader.get("appiumServerUrl")), options);
		} catch (MalformedURLException e) {
			throw new RuntimeException("Invalid appiumServerUrl in config.properties", e);
		}
	}
}
