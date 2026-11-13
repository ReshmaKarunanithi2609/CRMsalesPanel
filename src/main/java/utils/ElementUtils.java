package utils;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class ElementUtils {

	private final AndroidDriver driver;
	private final int explicitWait;

	public ElementUtils(AndroidDriver driver) {
		this.driver = driver;
		this.explicitWait = Integer.parseInt(ConfigReader.get("explicitwait"));
	}

	// ---------------------------------------------------------------- waits / checks
	public WebElement waitForVisible(WebElement element) {
		return new WebDriverWait(driver, Duration.ofSeconds(explicitWait)).until(ExpectedConditions.visibilityOf(element));
	}

	public boolean isDisplayed(WebElement element, int seconds) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isDisplayed(WebElement element) {
		return isDisplayed(element, 10);
	}

	public boolean isNotDisplayed(WebElement element, int seconds) {
		long end = System.currentTimeMillis() + seconds * 1000L;
		do {
			try {
				if (!element.isDisplayed()) {
					return true;
				}
			} catch (NoSuchElementException | StaleElementReferenceException e) {
				return true;
			}
			pause(500);
		} while (System.currentTimeMillis() < end);
		return false;
	}

	public void assertDisplayed(String name, WebElement element) {
		if (!isDisplayed(element)) {
			throw new AssertionError(name + " is not displayed");
		}
	}

	public void assertNotDisplayed(String name, WebElement element) {
		if (!isNotDisplayed(element, 5)) {
			throw new AssertionError(name + " is still displayed");
		}
	}

	public void pause(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	// ---------------------------------------------------------------- element actions
	public void click(WebElement element) {
		ensureAppInForeground();
		hideKeyboardIfShown(); // a button hidden under the keyboard would otherwise hit the keyboard toolbar (Themes icon)
		new WebDriverWait(driver, Duration.ofSeconds(explicitWait)).until(ExpectedConditions.elementToBeClickable(element))
				.click();
	}

	public void sendKeys(WebElement element, String text) {
		ensureAppInForeground();
		WebElement field = waitForVisible(element);
		field.clear();
		if (text != null && !text.isEmpty()) {
			field.sendKeys(text);
		}
		hideKeyboardIfShown();
	}

	
	private void ensureAppInForeground() {
		try {
			if (!isAppInForeground()) {
				activateApp();
				pause(1000);
			}
		} catch (Exception ignored) {
			
		}
	}

	public String getText(WebElement element) {
		return waitForVisible(element).getText();
	}

	public String getAttribute(WebElement element, String attribute) {
		return waitForVisible(element).getAttribute(attribute);
	}

	public int count(List<WebElement> elements) {
		return elements.size();
	}

	// ---------------------------------------------------------------- gestures
	public void tapAt(int x, int y) {
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence tap = new Sequence(finger, 1);
		tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
		tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(java.util.Collections.singletonList(tap));
	}

	public void tapFraction(WebElement element, double xFraction, double yFraction) {
		Rectangle r = waitForVisible(element).getRect();
		tapAt(r.x + (int) (r.width * xFraction), r.y + (int) (r.height * yFraction));
	}

	public void scrollToText(String text) {
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"" + text
						+ "\"))"));
	}

	public void scrollDown() {
		Dimension s = driver.manage().window().getSize();
		Map<String, Object> params = new HashMap<>();
		params.put("left", s.width / 10);
		params.put("top", s.height / 4);
		params.put("width", s.width * 8 / 10);
		params.put("height", s.height / 2);
		params.put("direction", "up");
		params.put("percent", 0.75);
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", params);
	}

	/** Swipes a horizontal chip/tab row to the left, starting from an element that is inside the row. */
	public void swipeRowLeft(WebElement rowItem) {
		Rectangle r = waitForVisible(rowItem).getRect();
		Dimension s = driver.manage().window().getSize();
		Map<String, Object> params = new HashMap<>();
		params.put("left", 10);
		params.put("top", r.y);
		params.put("width", s.width - 20);
		params.put("height", Math.max(r.height, 10));
		params.put("direction", "left");
		params.put("percent", 0.9);
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", params);
	}

	// ---------------------------------------------------------------- keyboard / device
	/** Closes the on-screen keyboard: Done key first, then Back, then hideKeyboard. Does nothing if no keyboard is open. */
	public void hideKeyboardIfShown() {
		for (int attempt = 0; attempt < 3; attempt++) {
			try {
				if (!driver.isKeyboardShown()) {
					return;
				}
			} catch (Exception e) {
				return;
			}
			try {
				if (attempt == 0) {
					performEditorAction("done");
				} else if (attempt == 1) {
					pressBack();
				} else {
					driver.hideKeyboard();
				}
			} catch (Exception ignored) {
				// try the next way of closing the keyboard
			}
			pause(500);
		}
	}

	// action: next, done, go, search, send, previous
	public void performEditorAction(String action) {
		Map<String, Object> params = new HashMap<>();
		params.put("action", action);
		((JavascriptExecutor) driver).executeScript("mobile: performEditorAction", params);
	}

	public void pressBack() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

	public void closeAndReopenApp() {
		String pkg = ConfigReader.get("appPackage");
		driver.terminateApp(pkg);
		driver.activateApp(pkg);
	}

	public byte[] screenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	// ---------------------------------------------------------------- session / device helpers
	public boolean isAppInForeground() {
		return ConfigReader.get("appPackage").equals(driver.getCurrentPackage());
	}

	public void activateApp() {
		driver.activateApp(ConfigReader.get("appPackage"));
	}

	/** Clears the app data so the app starts logged out (used for the Login module). */
	public void clearAppData() {
		String pkg = ConfigReader.get("appPackage");
		driver.terminateApp(pkg);
		Map<String, Object> params = new HashMap<>();
		params.put("appId", pkg);
		((JavascriptExecutor) driver).executeScript("mobile: clearApp", params);
		driver.activateApp(pkg);
	}

	public void setAirplaneMode(boolean on) {
		Map<String, Object> params = new HashMap<>();
		params.put("airplaneMode", on);
		((JavascriptExecutor) driver).executeScript("mobile: setConnectivity", params);
	}

	public void rotateLandscape() {
		driver.rotate(ScreenOrientation.LANDSCAPE);
	}

	public void rotatePortrait() {
		driver.rotate(ScreenOrientation.PORTRAIT);
	}

	public boolean isOtherAppInForeground() {
		pause(1000);
		return !isAppInForeground();
	}

	/** Taps the centre of an element several times in a row (rapid tap tests). */
	public void tapRepeatedly(WebElement element, int times) {
		Rectangle r = waitForVisible(element).getRect();
		int x = r.x + r.width / 2;
		int y = r.y + r.height / 2;
		for (int i = 0; i < times; i++) {
			tapAt(x, y);
		}
	}

	/** Opens the side menu and taps an item. Falls back to a tap on the header icon position if the icon locator misses. */
	public void openSideMenu(WebElement menuIcon, WebElement menuItem) {
		try {
			click(menuIcon);
		} catch (Exception ignored) {
			// icon locator not found, fallback below
		}
		if (!isDisplayed(menuItem, 3)) {
			Dimension s = driver.manage().window().getSize();
			tapAt((int) (s.width * 0.10), (int) (s.height * 0.09)); // VERIFY header position of the menu icon
		}
		click(menuItem);
	}

	public String configEmail() {
		return ConfigReader.get("validEmail");
	}

	public String configPassword() {
		return ConfigReader.get("validPassword");
	}
}
