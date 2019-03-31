package Automation.Auto;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.Dresses;
import PageObjects.HomePage;
import Utilities.baseClass;

public class TestMegaMenu_SummerDresses extends baseClass {
  @Parameters({"MyBrowser"})
  @Test
  public void f(String MyBrowser) throws Exception {
	  
	  
	  try {
		  HomePage home = new HomePage();
		  Dresses dress = new Dresses();
		  WebDriver driverThread = home.openBrowser(MyBrowser);	  
		  home.navigatetoTabHomePage("Dresses", driverThread);
		  dress.navigatetoTabDressesPage("Summer Dresses", driverThread);
		  driverThread.quit();
	  }
	  catch (Exception e) {
		  throw e;
	}
	  
  }
}
