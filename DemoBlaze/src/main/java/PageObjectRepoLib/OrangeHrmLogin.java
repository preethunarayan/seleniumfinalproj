package PageObjectRepoLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import GenericLib.MsExcelAutomation;
import GenericLib.WebDriverCommonLib;

public class OrangeHrmLogin {

	static WebDriverCommonLib ref = new WebDriverCommonLib();

	@FindBy(name = "username")
	private WebElement usernameBox;

	@FindBy(name = "password")
	private WebElement passwordBox;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginBtn;

	public void loginToOrangeHrmApp() throws Exception {
		ref.openURL(MsExcelAutomation.getExcelData("Book1", 1, 2));
		ref.waitForPageToLoad();
		ref.maximize();
		usernameBox.sendKeys(MsExcelAutomation.getExcelData("Sheet1", 1, 3));
		passwordBox.sendKeys(MsExcelAutomation.getExcelData("Sheet1", 1, 4));
		ref.clickElement(loginBtn); 
		

	}

}
