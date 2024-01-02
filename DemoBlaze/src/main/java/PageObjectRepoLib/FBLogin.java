package PageObjectRepoLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import GenericLib.Constants;
import GenericLib.Drivers;
import GenericLib.MsExcelAutomation;
import GenericLib.WebDriverCommonLib;

public class FBLogin {

	static WebDriverCommonLib obj = new WebDriverCommonLib();

	@FindBy(id = "email")
	private WebElement usernameBox;

	@FindBy(name = "pass")
	private WebElement passwordBox;

	@FindBy(xpath = "//button[@data-testid='royal_login_button']")
	private WebElement loginBtn;

	public void logInToApp(WebDriver driver) throws Exception {

		String userValue = MsExcelAutomation.getExcelData("Book1", 1, 3);
		String passValue = MsExcelAutomation.getExcelData("Book1", 1, 4);

		obj.openURL(Constants.baseUrl);
		obj.waitForPageToLoad();
		obj.maximize();
		usernameBox.sendKeys(userValue);
		passwordBox.sendKeys(passValue);
		obj.clickElement(loginBtn);

	}

	public void forgottenPAssword() {

	}

	public void createAPage() {

	}

	public void newRegistration() {

	}

}
