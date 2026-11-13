package Driverfactory;

import io.appium.java_client.android.AndroidDriver;

// One driver for the whole run (end to end): the session starts once and every scenario reuses it. 
public class DriverManager {

	private static volatile AndroidDriver driver;

	public static void setDriver(AndroidDriver androidDriver) {
		driver = androidDriver;
	}

	public static AndroidDriver getDriver() {
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
