package test.tracking.pobj;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import test.tracking.cases.AutomationUtil;
import test.tracking.constants.ObjectLibrary;  

public class RegisterPage extends BaseObject {

	
	public RegisterPage(WebDriver input)
	{
		driver = input;
	}
	
	/**
	 * The createacc method takes in a name, email, and password and creates a new account. 
	 * It finds the name, email, password, and confirm password boxes and inputs the parameters.
	 * It then checks the checkbox and clicks the register button. 
	 * 
	 * @param name	full name of the user as a string
	 * @param email	email of the user as a string
	 * @param pass	password of the user as a string
	 */
	public void registerUser(String name, String email, String pass)
	{
		try {
			clickElement(ObjectLibrary.logo);
			clickElement(ObjectLibrary.reg_registerMain);
			Assert.assertEquals(true, driver.findElement(ObjectLibrary.reg_name).isEnabled(), "User name not available. Popup not visible?");
			writeTextBox(ObjectLibrary.reg_name, name);
			writeTextBox(ObjectLibrary.reg_email, email);
			writeTextBox(ObjectLibrary.reg_password, pass);
			Reporter.log("Entered the values for the User registration");
			AutomationUtil.waitPlease();
			
			Assert.assertEquals(true, driver.findElement(ObjectLibrary.reg_registerbtn).isEnabled(), "Register Button is not enabled");
			clickElement(ObjectLibrary.reg_registerbtn);
			Reporter.log("Completed User registration");
			AutomationUtil.waitPlease();
			
			Assert.assertEquals(true, driver.findElement(ObjectLibrary.logout).isEnabled(), "Logout Link not found. Did not login automatically after registration");
			clickElement(ObjectLibrary.logout);
			Reporter.log("Logged out");
			AutomationUtil.waitPlease();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void isApplicationAvailable() {
		Assert.assertTrue(isElementEnabled(ObjectLibrary.login_loginMain), "Application is not availabel at - " + driver.getCurrentUrl());
	}
}
