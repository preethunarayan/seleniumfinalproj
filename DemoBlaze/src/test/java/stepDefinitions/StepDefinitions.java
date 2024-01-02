package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GenericLib.Constants;
import GenericLib.Drivers;
import GenericLib.MsExcelAutomation;
import GenericLib.WebDriverCommonLib;
import PageObjectRepoLib.DBHomePage;
import PageObjectRepoLib.FBLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	 private WebDriver driver;
	  private DBHomePage dbHomePage;	
	  
	// code for demoblaze application
	  
	  //Scenario1: Verify the URL for DemoBlaze on google browser
	  @Given("the user navigates to the DemoBlaze application")
	  public void the_user_navigates_to_the_demo_blaze_application() {
		  System.out.println("launch the  browser and navigate");
		  // step1:setup the driver path
		  System.setProperty("webdriver.chrome.driver",
				  "C:\\Users\\Preethu N\\eclipse-workspace\\DemoBlaze\\Drivers\\chromedriver.exe");


		  // step2:launch the browser (light browser-without cookies,plugins and history)
		  driver = new ChromeDriver();

		  // implicit wait statement
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		  // step3:open demoblaze application
		  driver.get("https://www.demoblaze.com/");

		  // step4:maximize the browser
		  driver.manage().window().maximize();


	  }
	  @When("the user opens the application on google browser")
	  public void the_user_opens_the_application_on_google_browser() {
		  //  the actual path of your ChromeDriver executable
		  System.setProperty("webdriver.chrome.driver",
				  "C:\\Users\\Preethu N\\eclipse-workspace\\DemoBlaze\\Drivers\\chromedriver.exe");

		  // Navigate to the DemoBlaze application
		  driver.get(Constants.baseUrl);

	  }
	  @Then("the URL should be {string} on the google browser")
	  public void the_url_should_be_on_the_google_browser(String expectedUrl) {
		  // Modify this method to assert the actual URL with expectedUrl
		  String actualUrl = driver.getCurrentUrl();
		  System.out.println("Actual URL: " + actualUrl);
		  System.out.println("Expected URL: " + expectedUrl);
		  if (actualUrl.equals(expectedUrl)) {
			  System.out.println("URL is on the browser");
		  } else {
			  System.out.println("URL does not match");
		  }
		  // Close the browser
		  driver.quit();

	  }
	
	//Scenario2: Verify that the user redirects to the sign-up page
		@Given("the user is on the Demoblaze application home page")
		public void the_user_is_on_the_demoblaze_application_home_page() {
			
			 // Initialize WebDriver (you may have this in a setup method or hook)
	        driver = new ChromeDriver();
	        
	        // Navigate to Demoblaze home page
	        driver.get("https://www.demoblaze.com");
	        
	     // step4:maximize the browser
			driver.manage().window().maximize();
			
			// Verify page title
	        String expectedTitle = "STORE";
	        String actualTitle = driver.getTitle();
	        System.out.println("Actual title: " + actualTitle);

	        if (actualTitle.equals(expectedTitle)) {
	            System.out.println("User is on the Demoblaze home page.");
	        } else {
	            System.out.println("User is NOT on the Demoblaze home page. Actual title: " + actualTitle);
	        }
	        // Verify presence of a specific element on the home page (e.g., logo)
	        WebElement logoElement = driver.findElement(By.className("navbar-brand"));
	        
	        if (logoElement.isDisplayed()) {
	            System.out.println("Logo is present on the Demoblaze home page.");
	        } else {
	            System.out.println("Logo is NOT present on the Demoblaze home page.");
	        }
	        driver.quit();

	       	    }
		@When("the user clicks on the sign-up link")
		public void user_clicks_on_signup() {
			 // Initialize WebDriver (you may have this in a setup method or hook)
	        driver = new ChromeDriver();
	        
	        // Navigate to Demoblaze home page
	        driver.get("https://www.demoblaze.com");
	        
	     // step4:maximize the browser
			driver.manage().window().maximize();
			
			// Assuming the signup link has an ID attribute
	        By signupLinkLocator = By.id("signin2");
	        WebElement signupLink = driver.findElement(signupLinkLocator);
	        
	        if (signupLink.isDisplayed()) {
	        System.out.println("signup link is displayed");
	        }else {
	        	System.out.println("signup link not displayed");
	        	
	        }
	        // Click on the signup link
	        signupLink.click();

	        // Perform other actions on the signup page as needed

	        // Close the browser
	        driver.quit();


		}

		@Then ("the user should be redirected to the sign-up page")
		public void signupPage_appears() {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Preethu N\\eclipse-workspace\\Sept18Automation\\Drivers\\chromedriver.exe");

			// step2:launch the browser (light browser-without cookies,plugins and history)
			WebDriver driver = new ChromeDriver();

			// implicit wait statement
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			// step3:open demoblaze  application
			driver.get("https://www.demoblaze.com");

			// step4:maximize the browser
			driver.manage().window().maximize();



			// Assuming the signup link has an ID attribute
			By signupLinkLocator = By.id("signin2");
			WebElement signupLink = driver.findElement(signupLinkLocator);	        
			signupLink.click();

			//step6:get current window ID where selenium is focussing
			String parentId=driver.getWindowHandle();
			System.out.println("parent Id=" +parentId);

			//step 7:get the window IDs for all windows opened by selenium
			Set<String> ref=driver.getWindowHandles();
			System.out.println("All window ids --->" +ref);


			//step8:iterator
			Iterator<String> it=ref.iterator();

			String parentWindowId=it.next();
			System.out.println("The parent window id from set object = " +parentWindowId);

			//step9: do we have next window ID
			boolean isnextWindowAvailable=it.hasNext();
			System.out.println("isnextWindowAvailable=" +isnextWindowAvailable);

			//step 10:switch to flight window

			String signUpWindow=it.next();
			System.out.println(" the sign up  window-" +signUpWindow);


			driver.switchTo().window(signUpWindow);

			//step11: check if user on current window
			String currentWindowTitle=driver.getTitle();


			System.out.println("The current Window Title is =" +currentWindowTitle);


		}

		//Scenario3: Verify that the user enters the valid user name
		@Given("the user is on the Demoblaze sign-up page")
		public void the_user_is_on_the_demoblaze_sign_up_page() {
			// Initialize WebDriver (you may have this in a setup method or hook)
			driver = new ChromeDriver();

			// Navigate to Demoblaze home page
			driver.get("https://www.demoblaze.com");
			//driver = Drivers.getBrowser();
			dbHomePage = new DBHomePage(driver);
			// step4:maximize the browser
			driver.manage().window().maximize();


			// Assuming the signup link has an ID attribute
			By signupLinkLocator = By.id("signin2");

			WebElement signupLink = driver.findElement(signupLinkLocator);

			// Click on the signup link
			signupLink.click();
			// Verify if the user is on the Demoblaze sign-up page
			String expectedTitle = "Sign up";
			String actualTitle = driver.getTitle();

			if (actualTitle.equals(expectedTitle)) {
				System.out.println("User is on the Demoblaze sign-up page.");
			} else {
				System.out.println("User is NOT on the Demoblaze sign-up page. Actual title: " + actualTitle);
			}
			// Close the browser
			driver.quit();

		}
		@When("the user enters a valid username")
		public void the_user_enters_a_valid_username()throws Exception {
			driver = new ChromeDriver();

			//driver = Drivers.getBrowser();
			dbHomePage = new DBHomePage(driver);
			// Navigate to Demoblaze home page
			driver.get("https://www.demoblaze.com");

			// step4:maximize the browser
			driver.manage().window().maximize();
			// Assuming the signup link has an ID attribute
			By signupLinkLocator = By.id("signin2");

			WebElement signupLink = driver.findElement(signupLinkLocator);

			signupLink.click();
			System.out.println("sign up details are as below:");
			String userValue = MsExcelAutomation.getExcelData("Book1", 1, 3);
			String passValue = MsExcelAutomation.getExcelData("Book1", 1, 4);
			System.out.println("the username is :"+ userValue);

			dbHomePage.DBlazeLogin(userValue,passValue);
			
			
		}
		
		/*
		 * @Then("the user should be successfully registered") public void
		 * the_user_should_be_successfully_registered() { }
		 */
}
