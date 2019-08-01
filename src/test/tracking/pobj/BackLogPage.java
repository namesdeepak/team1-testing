package test.tracking.pobj;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import test.tracking.cases.AutomationUtil;
import test.tracking.constants.ObjectLibrary;  

public class BackLogPage extends BaseObject {

	
	public BackLogPage(WebDriver input)
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
	public void createCard(String title, String description, String priority, String type, String load, String stage, String projectName)
	{
		try {

			clickElement(ObjectLibrary.backlog_page_link);
			clickElement(ObjectLibrary.backlog_page_addCard);
			AutomationUtil.waitPlease();
			writeTextBox(ObjectLibrary.card_title, title);
			writeTextBox(ObjectLibrary.card_desc, description);
			writeTextBox(ObjectLibrary.card_effort, load);

			selectOption(ObjectLibrary.card_priority_lov, priority);
			selectOption(ObjectLibrary.card_type_lov, type);
			selectOption(ObjectLibrary.card_stage_lov, stage);
			selectOption(ObjectLibrary.card_project_lov, projectName);
			
			Reporter.log("Entered the values for the Card Creation");
			Assert.assertEquals(true, driver.findElement(ObjectLibrary.card_save_btn).isEnabled(), "Save Button is not enabled");
			clickElement(ObjectLibrary.card_save_btn);
			Reporter.log("Completed Card creation");
			AutomationUtil.waitPlease();
			Reporter.log("Changing project selection due to current issue with auto page refresh - THIS SHOULD BE FIXED");
			//Hack due to the current page refresh problem
			refreshHackProjectSelection(projectName);
			AutomationUtil.waitPlease();
			Assert.assertEquals(true, driver.findElement(By.xpath("//div[contains(text(), '"+ title +"')]")).isDisplayed(), "Card is not visible after creation");
			Reporter.log("Can see the Card created in the Cards list");

//			AutomationUtil.waitPlease();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectProject(String projectName) {
		
		Assert.assertEquals(true, driver.findElement(ObjectLibrary.project_select_lov_all_page).isEnabled(), "Project selection dropdown is not enabled");
		selectOption(ObjectLibrary.project_select_lov_all_page, projectName);
		
	}
	
	public void changeCardStage(int cardIndexNum, String stageName, String projectName) throws InterruptedException {
		//First list box is for project, so add 1 to get the right card index
		++cardIndexNum;
		Assert.assertEquals(true, driver.findElement(ObjectLibrary.project_select_lov_all_page).isEnabled(), "Project selection dropdown is not enabled");
		selectOption(ObjectLibrary.project_select_lov_all_page, projectName);
		Assert.assertEquals(true, driver.findElement(By.xpath("(//select)[" + cardIndexNum +"]")).isDisplayed(), "Card is not visible with index -" + cardIndexNum);
		selectOption(By.xpath("(//select)[" + cardIndexNum +"]"), stageName);
		refreshHackProjectSelection(projectName);
//		Assert.assertEquals(true, driver.findElement(By.xpath(xpathExpression)).isEnabled(), "Project selection dropdown is not enabled");
	}
	
	
	public void refreshHackProjectSelection(String projectName) throws InterruptedException {
		//Hack due to the current page refresh problem
		AutomationUtil.waitPlease();
		selectOption(ObjectLibrary.project_select_lov_all_page, "Select");
		selectOption(ObjectLibrary.project_select_lov_all_page, projectName);
	}
	
}
