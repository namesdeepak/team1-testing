package test.tracking.pobj;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import test.tracking.cases.AutomationUtil;
import test.tracking.constants.ObjectLibrary;

public class LoginPage extends BaseObject {
	
	public LoginPage(WebDriver input)
	{
		driver = input;
	}
	
	/**
	 * The login method takes in parameters for username and password and inputs them in their
	 * respective fields and clicks the login button.
	 * 
	 * @param user	the username as a string
	 * @param pass	the password as a string
	 * @throws InterruptedException 
	 */
	public void login(String user, String pass) throws InterruptedException
	{
		clickElement(ObjectLibrary.login_loginMain);
		AutomationUtil.waitPlease();
		
		Assert.assertEquals(true, isElementEnabled(ObjectLibrary.login_username), "Login popup is not Enabled");
		writeTextBox(ObjectLibrary.login_username, user);
		writeTextBox(ObjectLibrary.login_password, pass);
		AutomationUtil.waitPlease();
		
		Assert.assertEquals(true, isElementEnabled(ObjectLibrary.login_loginbtn), "Login button is not Enabled");
		clickElement(ObjectLibrary.login_loginbtn);
		AutomationUtil.waitPlease();

//		Assert.assertEquals(true, driver.findElement(ObjectLibrary.sprint_page).isDisplayed(), "Sprint page not visible");
	}
	
	public void logout() {
		clickElement(ObjectLibrary.logout);
		try {
			AutomationUtil.waitPlease();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void gotoHomePage() {
		clickElement(ObjectLibrary.logo);
		try {
			AutomationUtil.waitPlease();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
