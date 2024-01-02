package GenericLib;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Drivers {
	public static WebDriver driver;
	
	
	public static WebDriver getBrowser() {
		// equalsIgnoreCase converts value from "Constants.browser.and " to lowercase  and from ("chrome")to lowercase and compares
		if (Constants.browser.equalsIgnoreCase("chrome")) {
			
			
			//System.setProperty("webdriver.chrome.driver",
					// "C:\\Users\\Preethu N\\eclipse-workspace\\Sept18Automation\\Drivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			
			 driver = new ChromeDriver();

			
		}else if (Constants.browser.equalsIgnoreCase("firefox")) {
			
						
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\Preethu N\\eclipse-workspace\\Drivers\\geckodriver.exe");
				
				
				 driver=new FirefoxDriver();
			}
			else if (Constants.browser.equalsIgnoreCase("safari")) {
				System.setProperty("webdriver.safari.driver", "C:\\Users\\Preethu N\\eclipse-workspace\\Drivers\\safaridriver.exe");
				
				
				 driver=new SafariDriver();
				
			}
		
	
		return driver;

}
	}
