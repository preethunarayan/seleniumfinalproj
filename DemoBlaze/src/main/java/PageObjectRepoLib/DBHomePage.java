package PageObjectRepoLib;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GenericLib.Constants;
import GenericLib.MsExcelAutomation;
import GenericLib.WebDriverCommonLib;


public class DBHomePage {
	private WebDriver driver;
	static WebDriverCommonLib obj = new WebDriverCommonLib();
	
	@FindBy(id = "sign-username")
	private WebElement usernameBox;

	@FindBy(id = "sign-password")
	private WebElement passwordBox;

	@FindBy(xpath = "//button[text()='Sign up']")
	private WebElement signUpBtn;
	private WebDriverWait wait;


 // Constructor to initialize the driver and elements
    public DBHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

	    // Constructor to initialize the driver and elements
	    //public void DBlazeLogin(WebDriver driver) throws Exception{
	    	//String userValue = MsExcelAutomation.getExcelData("Book1", 1, 3);
			//String passValue = MsExcelAutomation.getExcelData("Book1", 1, 4);
    public void DBlazeLogin(String userValue, String passValue) throws Exception{
			//obj.openURL(Constants.baseUrl);
			//obj.waitForPageToLoad();
			//obj.maximize();
			usernameBox.sendKeys(userValue);
			passwordBox.sendKeys(passValue);
			signUpBtn.click();	
			// Wait for the new window to open (you may need to adjust the timeout)
		   // WebDriverWait wait = new WebDriverWait(driver, 10);
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    // Get handles of all windows
		    Set<String> windowHandles = driver.getWindowHandles();
		    
		    // Switch to the new window
		    for (String windowHandle : windowHandles) {
		        if (!windowHandle.equals(driver.getWindowHandle())) {
		            driver.switchTo().window(windowHandle);
		            break;
		        }
		    }

		    // Now you are in the new window
		    String currentWindowTitle = driver.getTitle();
		    System.out.println("The current Window Title is =" + currentWindowTitle);
		 // Capture the text of the new window
		    try {
	            // Wait for the alert to appear
	            wait.until(ExpectedConditions.alertIsPresent());
	        } catch (NoAlertPresentException e) {
	            System.out.println("No alert present.");
	            return;
	        }

	        // Switch to the alert
	        Alert alert = driver.switchTo().alert();

	        // Get the text of the alert
	        String alertMessage = alert.getText();
	        System.out.println("Alert Message: " + alertMessage);

	        // Accept the alert (dismiss if needed)
	        alert.accept();
		    
		}
    }

	  /*  
	    @FindBy(id = "greetings")
	    private WebElement greetingsMessage;

	    // Method to click on the Sign Up link
	    public void clickSignUpLink() {
	    	signUpBtn.click();
	    }

	    // Method to get the greetings message
	    public String getGreetingsMessage() {
	        return greetingsMessage.getText();
	    }
*/


