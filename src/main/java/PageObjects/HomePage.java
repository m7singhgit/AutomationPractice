package PageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.CoreFunctions;

public class HomePage extends CoreFunctions {
	
	private final By Obj_Women_Link = new By.ByXPath("//a[@title='Women']");
	private final By Obj_Dresses_Link = new By.ByXPath("//a[@title='Dresses']");
	private final By Obj_Menu_Links = new By.ByXPath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a");
	private final By Obj_Signin_Link = new By.ByXPath("//a[@class='login']");

	
	
	public WebDriver openBrowser(String MyBrowser) throws Exception {
		WebDriver driverThread = initializeWebDriver(MyBrowser);
		navigateToURL("http://automationpractice.com", driverThread);
		waitForPageTitle("My Store", driverThread);
		return driverThread;		
	}
	
	public void navigatetoTabHomePage(String TabName, WebDriver driverThread) {
		navigatetoTab(TabName, Obj_Menu_Links, driverThread);		
		}
	
	public void navigatetoSignin(WebDriver driverThread) {
		Click(Obj_Signin_Link, driverThread);		
		}
		
	
	
}
