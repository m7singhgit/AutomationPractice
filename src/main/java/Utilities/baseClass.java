package Utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class baseClass {
	
	//Initialize browser
	public WebDriver initializeWebDriver(String MyBrowser) throws Exception {
		WebDriver driverThread = null;
		
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
		Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");

		//MyBrowser = System.getProperty("Testbrowser");
		
		try {
			switch (MyBrowser.toUpperCase()) {
			case "CHROME":
			case "C":
				System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("chrome.switches","--disable-extensions --disable-extensions-file-access-check --disable-extensions-http-throttling --disable-infobars --enable-automation");
				Map<String, Object> prefs = new HashMap<>();
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.passsword_manager_enabled", false);
				prefs.put("useAutomationExtension", false);
				options.setExperimentalOption("prefs", prefs);
				driverThread = new ChromeDriver(options);
				driverThread.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				break;
				
			
			}
			return driverThread;

		} catch (WebDriverException e) {
			e.printStackTrace();
			return null;
		}			
	}
	


}
