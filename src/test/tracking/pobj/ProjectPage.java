package test.tracking.pobj;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import test.tracking.cases.AutomationUtil;
import test.tracking.constants.ObjectLibrary;  

public class ProjectPage extends BaseObject {

	
	public ProjectPage(WebDriver input)
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
	public void createProject(String name, String shortCode, String description)
	{
		try {
			clickElement(ObjectLibrary.logo);
			clickElement(ObjectLibrary.project_page_link);
			clickElement(ObjectLibrary.project_newproject_btn);
			AutomationUtil.waitPlease();
			writeTextBox(ObjectLibrary.project_create_name, name);
			writeTextBox(ObjectLibrary.project_create_shortCode, shortCode);
			writeTextBox(ObjectLibrary.project_create_desc, description);
			Reporter.log("Entered the values for the Project Creation");
			Assert.assertEquals(true, driver.findElement(ObjectLibrary.project_createbtn).isEnabled(), "Create Button is not enabled");
			clickElement(ObjectLibrary.project_createbtn);
			Reporter.log("Completed Project creation");
			AutomationUtil.waitPlease();
			
			Assert.assertEquals(true, driver.findElement(By.xpath("//li[contains(text(), '"+ name +"')]")).isDisplayed(), "Project item is not visible after creation");
			Reporter.log("Can see the project created in the Project list");

//			AutomationUtil.waitPlease();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteProject(String name) throws InterruptedException {
		clickElement(ObjectLibrary.logo);
		clickElement(ObjectLibrary.project_page_link);
		Assert.assertEquals(true, driver.findElement(By.xpath("//li[contains(text(), '"+ name +"')]")).isDisplayed(), "Project item is not visible");
		AutomationUtil.waitPlease();
		clickElement(By.xpath("//li[contains(text(), '"+ name +"')]/button[1]"));
		Alert alert = driver.switchTo().alert();
		alert.accept();
		AutomationUtil.waitPlease();
	}
	
	public void addEpicToProject(String projectName, String epic) throws InterruptedException {
		clickElement(ObjectLibrary.logo);
		clickElement(ObjectLibrary.project_page_link);
		Assert.assertEquals(true, driver.findElement(By.xpath("//li[contains(text(), '"+ projectName +"')]")).isDisplayed(), "Project item is not visible");
		AutomationUtil.waitPlease();
		clickElement(By.xpath("//li[contains(text(), '"+ projectName +"')]/button[2]"));
		writeTextBox(ObjectLibrary.project_addepics_name, epic);
		Assert.assertEquals(true, driver.findElement(ObjectLibrary.project_addepics_save).isEnabled(), "Epic Add button not enabled");
		clickElement(ObjectLibrary.project_addepics_save);
		
	}
	
	public void addUserToProject(String projectName, String userEmail) throws InterruptedException {
		
		clickElement(ObjectLibrary.logo);
		clickElement(ObjectLibrary.project_page_link);
		Assert.assertEquals(true, driver.findElement(By.xpath("//li[contains(text(), '"+ projectName +"')]")).isDisplayed(), "Project item is not visible");
		AutomationUtil.waitPlease();
		clickElement(By.xpath("//li[contains(text(), '"+ projectName +"')]/button[3]"));
		AutomationUtil.waitPlease();
		clickElement(By.xpath("//option[contains(text(), '"+ userEmail +"')]"));
		AutomationUtil.waitPlease();
		Assert.assertEquals(true, driver.findElement(ObjectLibrary.project_addmembers_addbutn).isEnabled(), "Users Add button not enabled");
		clickElement(ObjectLibrary.project_addmembers_addbutn);
		
	}
	
		
}
