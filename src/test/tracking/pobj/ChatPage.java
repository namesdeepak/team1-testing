package test.tracking.pobj;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import test.tracking.cases.AutomationUtil;
import test.tracking.constants.ObjectLibrary;  

public class ChatPage extends BaseObject {

	
	public ChatPage(WebDriver input)
	{
		driver = input;
	}
	
	public int filterChatByProject(String projectName)
	{
		try {
			AutomationUtil.waitPlease();
			selectProject(projectName);
			Reporter.log("Selected Project and Stage for the report");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.findElements(ObjectLibrary.reports_page_cards_div_list).size();
	}

	public void sendMessage(String messageText)
	{
		try {
			driver.findElement(ObjectLibrary.chat_message_text).sendKeys(messageText);
			AutomationUtil.waitPlease();
			driver.findElement(ObjectLibrary.chat_send).click();
			Reporter.log("Message Sent");
			Assert.assertTrue(true);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void selectProject(String projectName) {
		
		Assert.assertEquals(true, driver.findElement(ObjectLibrary.reports_page_project_filter).isEnabled(), "Project selection dropdown is not enabled");
		selectOption(ObjectLibrary.project_select_lov_all_page, projectName);
	}
}
