package PageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.testng.TestException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.CoreFunctions;

public class SigninPage extends CoreFunctions {
	
	private final By Obj_Create_Account = new By.ById("email_create");
	private final By Obj_Alert_Msg = new By.ByXPath("//div[@class='alert alert-danger']/ol/li");
	private final By Obj_Create_Button = new By.ByName("SubmitCreate");


			
		
	public void CreateAnAccount(String Email, WebDriver driverThread) {
		Enter(Email, Obj_Create_Account, driverThread);		
		Click(Obj_Create_Button,driverThread);
		}
		
	public void VerifyErrorMsg(String errorMsg, WebDriver driverThread) {
		fluentWait(Obj_Alert_Msg, driverThread);
		WebElement element = driverThread.findElement(Obj_Alert_Msg);
		if(element.getText().toUpperCase().contains(errorMsg.toUpperCase())) {
			System.out.println("Error Message verified");
		}
		else {
			throw new TestException("Error Message: " + element.getText()+" do not match expected message : "+errorMsg);

		}
		}
		
	
}
