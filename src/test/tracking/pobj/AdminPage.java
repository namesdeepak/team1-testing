package test.tracking.pobj;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import test.tracking.cases.AutomationUtil;
import test.tracking.constants.ObjectLibrary;  

public class AdminPage extends BaseObject {

	
	public AdminPage(WebDriver input)
	{
		driver = input;
	}
	
	
	public void promoteUser(String useName, String promoteToRole)
	{
		try {
			clickElement(ObjectLibrary.logo);
	    	clickElement(ObjectLibrary.admin_pageMain);
	    	Reporter.log("Current User role is " + readSelectedOption(ObjectLibrary.admin_roleUpdate_lov));
	    	//Update the role to Admin
	    	selectOption(ObjectLibrary.admin_roleUpdate_lov, promoteToRole);
	    	AutomationUtil.waitPlease();
	    	clickElement(ObjectLibrary.admin_updateUser_btn);
	    	Reporter.log("After promotion, User role is " + readSelectedOption(ObjectLibrary.admin_roleUpdate_lov));
	    	Assert.assertEquals(readSelectedOption(ObjectLibrary.admin_roleUpdate_lov), promoteToRole);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteUser() throws InterruptedException {
		clickElement(ObjectLibrary.logo);
		clickElement(ObjectLibrary.admin_pageMain);
		AutomationUtil.waitPlease();
		clickElement(ObjectLibrary.admin_deleteUser_btn);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		AutomationUtil.waitPlease();
		Assert.assertTrue(true, "User deletion failed");
	}

	public void deleteAllUsersExceptAdmin() throws InterruptedException {
		clickElement(ObjectLibrary.logo);
		clickElement(ObjectLibrary.admin_pageMain);
		AutomationUtil.waitPlease();
		//Get all delete buttons
		List<WebElement> userDeleteBtns = driver.findElements(ObjectLibrary.admin_deleteUsers_btn);
		for(int i = 1 ; i < userDeleteBtns.size(); i++) {
			userDeleteBtns.get(i).click();
			Alert alert = driver.switchTo().alert();
			alert.accept();
			AutomationUtil.waitPlease();
			Assert.assertTrue(true, "User deletion failed");
		}

	}

}
