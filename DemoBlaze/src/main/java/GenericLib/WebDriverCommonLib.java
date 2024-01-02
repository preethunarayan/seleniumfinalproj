package GenericLib;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLib {

	public static WebDriver driver = Drivers.driver;
	static Alert alert;

	/**
	 * This method is used for wait to page to load, it is internally implicit
	 * webDriver wait statement
	 */
	public void waitForPageToLoad() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.globalWait));
	}

	/**
	 * This method is used to maximize the window
	 */
	public void maximize() {
		driver.manage().window().maximize();
	}

	public static void waitForElementTobePresent(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.globalWait));

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void switchWindow(String windowId) {
		driver.switchTo().window(windowId);
	}

	public Alert switchToAlert() {
		alert = driver.switchTo().alert();

		return alert;
	}

	public void dismissAlert() {
		alert = switchToAlert();
		alert.dismiss();
	}

	public void openURL(String url) {
		driver.get(url);
	}

	public static WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	}

	public void clickElement(WebElement element) {
		element.click();
	}

	public void enterText(By locator, String expectedText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.globalWait));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		WebElement element = getElement(locator);
		element.sendKeys(expectedText);
	}

	public static void verifyStringValues(By locator, String expectedText) {

		String actualText = getElement(locator).getText();

		if (actualText.equalsIgnoreCase(expectedText)) {
			System.out.println("Both the texts are equal");
		} else {
			System.out.println("Both the texts are not equal");

		}
	}
}
