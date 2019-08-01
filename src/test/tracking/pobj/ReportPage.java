package test.tracking.pobj;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import test.tracking.cases.AutomationUtil;
import test.tracking.constants.ObjectLibrary;  

public class ReportPage extends BaseObject {

	
	public ReportPage(WebDriver input)
	{
		driver = input;
	}
	
	public int filterCardsByProjectAndStage(String projectName, String stageName)
	{
		try {

			clickElement(ObjectLibrary.reports_page_link);
			AutomationUtil.waitPlease();
			selectProject(projectName);
			selectStage(stageName);
			Reporter.log("Selected Project and Stage for the report");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.findElements(ObjectLibrary.reports_page_cards_div_list).size();
	}
	
	public void selectProject(String projectName) {
		
		Assert.assertEquals(true, driver.findElement(ObjectLibrary.reports_page_project_filter).isEnabled(), "Project selection dropdown is not enabled");
		selectOption(ObjectLibrary.project_select_lov_all_page, projectName);
	}
	
	public void selectStage(String stageName) {
		
		Assert.assertEquals(true, driver.findElement(ObjectLibrary.reports_page_stage_filter).isEnabled(), "Stage selection dropdown is not enabled");
		selectOption(ObjectLibrary.reports_page_stage_filter, stageName);
	}
	
	
	
}
