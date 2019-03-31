package Automation.Auto;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.Dresses;
import PageObjects.HomePage;
import PageObjects.SigninPage;
import Utilities.baseClass;

public class TestLoginError extends baseClass {
  @Parameters({"MyBrowser"})
  @Test
  public void f(String MyBrowser) throws Exception {
	  
	  
	  try {
		  HomePage home = new HomePage();
		  SigninPage sign = new SigninPage();
		  
		  WebDriver driverThread = home.openBrowser(MyBrowser);	  
		 home.navigatetoSignin(driverThread);
		 sign.CreateAnAccount("aaa", driverThread);
		 sign.VerifyErrorMsg("Invalid email address", driverThread);
		  driverThread.quit();
	  }
	  catch (Exception e) {
		  throw e;
	}
	  
  }
}
