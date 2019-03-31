package Utilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public class CoreFunctions extends baseClass{
	
	//Navigate to any given url
	public void navigateToURL(String url, WebDriver driverThread) {
		driverThread.navigate().to(url);
		driverThread.manage().window().maximize();
	}
	

	//wait for page title
	public void waitForPageTitle(String PageTitle, WebDriver driverThread) {
		WebDriverWait wait = new WebDriverWait(driverThread,10);
		try {
		wait.until(ExpectedConditions.titleContains(PageTitle));
		String ActualPageTitle = driverThread.getTitle();
		if (ActualPageTitle.contains(PageTitle)) {
			System.out.println(ActualPageTitle+" Opened successfully");
		}
		else {
			throw new TestException("Page title: " + ActualPageTitle+" do not match expected title : "+PageTitle);
			}
		
		}catch (Exception e) {
			throw e;
		}
	}
	
	//Fluentwait
	public void fluentWait(WebElement element, WebDriver driverThread) {
		WebDriverWait wait = new WebDriverWait(driverThread,10);
		wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));

	}
	
	//Fluentwait
		public void fluentWait(By by, WebDriver driverThread) {
			WebDriverWait wait = new WebDriverWait(driverThread,10);
			wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(by));

		}
		
	//click
		public void Click(WebElement element, WebDriver driverThread) {
			fluentWait(element, driverThread);
			element.click();
		}
		
		//click
				public void Click(By by, WebDriver driverThread) {
					fluentWait(by, driverThread);
					WebElement element = driverThread.findElement(by);
					element.click();
				}
				
				//Enter text
				public void Enter(String text, By by, WebDriver driverThread) {
					fluentWait(by, driverThread);
					WebElement element = driverThread.findElement(by);
					element.sendKeys(text);
				}
		
	//Mouse over
		public void mouseHover(WebElement element, WebDriver driverThread) {
			Actions action = new Actions(driverThread);
			action.moveToElement(element).perform();
			
		}
		
		public void navigatetoTab(String TabName, By by, WebDriver driverThread) {
			Boolean flag = false;
			List <WebElement> element = driverThread.findElements(by);
			for(WebElement web:element) {
				String text = web.getText();
				if(web.getText().toUpperCase().contains(TabName.toUpperCase())) {
					Click(web,driverThread);
					waitForPageTitle(TabName, driverThread);
					flag = true;
					break;
				}
				
				}
			
			
			}
		
}
