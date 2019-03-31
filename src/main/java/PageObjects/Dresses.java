package PageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.CoreFunctions;

public class Dresses extends CoreFunctions {
	
	private final By Obj_Menu_Links = new By.ByXPath("//div[@class='block_content']/ul[@class='tree dynamized']/li");

			
		
	public void navigatetoTabDressesPage(String TabName, WebDriver driverThread) {
		navigatetoTab(TabName, Obj_Menu_Links, driverThread);		
		}
		
	
	
}
