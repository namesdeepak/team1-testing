package test.tracking.pobj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import test.tracking.cases.AutomationUtil;
import test.tracking.constants.ObjectLibrary;  

public class SprintPage extends BaseObject {

	
	public SprintPage(WebDriver input)
	{
		driver = input;
	}
	

	public void createCard(String title, String description, String priority, String type, String load, String stage, String projectName)
	{
		try {

//			clickElement(ObjectLibrary.sprint_page_link);
			clickElement(ObjectLibrary.sprint_addCard);
			AutomationUtil.waitPlease();
			writeTextBox(ObjectLibrary.card_title, title);
			writeTextBox(ObjectLibrary.card_desc, description);
			writeTextBox(ObjectLibrary.card_effort, load);

			selectOption(ObjectLibrary.card_priority_lov, priority);
//			selectOption(ObjectLibrary.card_type_lov, type);
			selectOption(ObjectLibrary.card_stage_lov, stage);
			selectOption(ObjectLibrary.card_project_lov, projectName);
			
			Reporter.log("Entered the values for the Card Creation");
			Assert.assertEquals(true, driver.findElement(ObjectLibrary.card_save_btn).isEnabled(), "Save Button is not enabled");
			clickElement(ObjectLibrary.card_save_btn);
			Reporter.log("Completed Card creation");
			AutomationUtil.waitPlease();
			Reporter.log("Changing project selection due to current issue with auto page refresh - THIS SHOULD BE FIXED");
			//Hack due to the current page refresh problem
//			refreshHackProjectSelection(projectName);
			AutomationUtil.waitPlease();
			Assert.assertEquals(true, driver.findElement(By.xpath("//div[contains(text(), '"+ title +"')]")).isDisplayed(), "Card is not visible after creation");
			Reporter.log("Can see the Card created in the Cards list");

//			AutomationUtil.waitPlease();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addComments(String storyTitle, String comments, String projectName)
	{
		try {

//			clickElement(ObjectLibrary.sprint_page_link);
			selectOption(ObjectLibrary.project_select_lov_all_page, projectName);
			AutomationUtil.waitPlease();
			Assert.assertEquals(true, driver.findElement(By.xpath("//div[contains(text(), '"+ storyTitle +"')]")).isDisplayed(), "Card is not visible ");
			Reporter.log("Can see the Card in the Cards list");
			clickElement(By.xpath("//div[contains(text(), '" + storyTitle+ "')]/following-sibling::div/button"));
			writeTextBox(ObjectLibrary.card_comments_textarea, comments);
			AutomationUtil.waitPlease();
			clickElement(ObjectLibrary.card_save_btn);

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
	
	public void changeCardStage(String projectName, String fromStageName, String toStageName) throws InterruptedException {

		Assert.assertEquals(true, driver.findElement(ObjectLibrary.project_select_lov_all_page).isEnabled(), "Project selection dropdown is not enabled");
		selectOption(ObjectLibrary.project_select_lov_all_page, projectName);
		Select select = new Select(driver.findElements(By.xpath(ObjectLibrary.sprint_page_stories_stagelov_by_stage_list.replace("STORY-STAGE", fromStageName))).get(0));
//		Assert.assertEquals(true, select != null, "No Card is not visible in the stage " + fromStageName);
		select.selectByVisibleText(toStageName);
		AutomationUtil.waitPlease();
		refreshHackProjectSelection(projectName);
//		Assert.assertEquals(true, driver.findElement(By.xpath(xpathExpression)).isEnabled(), "Project selection dropdown is not enabled");
	}
	
	public void verifyStoriesGroupingByStages()
	{
		Assert.assertTrue(driver.findElements(ObjectLibrary.sprint_columns).size() > 3, "Stories not grouped by stages");
	}
	
	public void refreshHackProjectSelection(String projectName) throws InterruptedException {
		//Hack due to the current page refresh problem
		AutomationUtil.waitPlease();
		selectOption(ObjectLibrary.project_select_lov_all_page, "Select");
		selectOption(ObjectLibrary.project_select_lov_all_page, projectName);
	}
	
}
