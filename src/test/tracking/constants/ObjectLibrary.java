package test.tracking.constants;

import org.openqa.selenium.By;

public interface ObjectLibrary {

	int _WAIT_TIMEOUT = 60;
	int _WAIT_ = 35;
	int _TEST_INTERVAL_MILLIS = 50000;
	
	//Registration Page
	By reg_name = By.xpath("//input[@id='name']");
	By reg_email = By.xpath("//input[@id='email']");
	By reg_password = By.xpath("//input[@id='password']");
	By reg_registerMain = By.xpath("//a[contains(text(), 'Register')]");
	By reg_registerbtn = By.xpath("//button[contains(text(), 'Register')]");

	
	By logout = By.xpath("//a[contains(text(), 'Logout')]");
	By logo = By.xpath("//logo-box");
	By landing_page = By.xpath("//h1[text()='Agile Project Management Development Tools']");
	By project_select_lov_all_page = By.xpath("//select[@id='projectDropdown']");

	
	//Login Page		
	By login_username = By.xpath("//input[@id='email']");
	By login_password = By.xpath("//input[@id='password']");
	By login_loginMain = By.xpath("//a[contains(text(), 'Login')]");
	By login_loginbtn = By.xpath("//button[contains(text(), 'Login')]");
	By login_closebtn = By.xpath("//button[@class='close']/span[1]");

	//Admin Page
	By admin_pageMain = By.xpath("//a[contains(text(), 'Admin')]");
	By admin_roleUpdate_lov = By.xpath("(//select[@id='userRole'])[2]");
	By admin_updateUser_btn = By.xpath("(//button[contains(text(),'Update')])[2]");
	By admin_deleteUser_btn = By.xpath("(//button[contains(text(),'Delete')])[2]");
	By admin_userRole_bubble = By.xpath("(//span[contains(text(), 'project')])[1]");
	By admin_deleteUsers_btn = By.xpath("//button[contains(text(),'Delete')]");
	
	
	//Sprint Page
	By sprint_page_link = By.xpath("//a[contains(text(), 'Sprint')]");
	By sprint_page = By.xpath("//h1[text()='Sprint']");
	By sprint_columns = By.xpath("//div/div[@class='app__allSprintColumns___1azpn' and 2]/div[@class='app__columnContainer___38iJ_']");
	By sprint_addCard = By.xpath("//button[contains(text(), 'Add Story')]");
	//Replace asas with story name
	String sprint_page_stage_by_title_lov = "//div[contains(text(), 'STORY-TEXT')]/following-sibling::div/*/select";
	//By stage To Do and story title asas
	String sprint_page_story_by_stage_title_lov = "//div[contains(text(), 'STORY-STAGE')]/..//div[contains(text(),'STORY-TEXT')]/following-sibling::div/*/select";
	String sprint_page_stories_stagelov_by_stage_list = "//div[contains(text(), 'STORY-STAGE')]/..//div/following-sibling::div/*/select";
	
	//Backlog page
	By backlog_page_link = By.xpath("//a[contains(text(), 'Backlog')]");
	By backlog_page_addCard = By.xpath("//button[contains(text(), 'Add Story')]");
	
	//Reports page
	By reports_page_link = By.xpath("//a[contains(text(), 'Reports')]");
	By reports_page = By.xpath("//h1[text()='Reports']");
	By reports_page_stage_filter = By.xpath("//select[@id='stage']");
	By reports_page_project_filter = By.xpath("//select[@id='projectDropdown']");
	By reports_page_cards_div_list = By.xpath("//div[@class='app__cardDescription___1f0iv']");
	
	//Card PopUp
	By card_title = By.xpath("//input[@name='title']");
	By card_desc = By.xpath("//textarea[@name='description']");
	By card_priority_lov = By.xpath("//select[@name='priority']");
	By card_type_lov = By.xpath("//select[@name='type']");
	By card_effort = By.xpath("//input[@name='load']");
	By card_stage_lov = By.xpath("//select[@name='stage']");
	By card_project_lov = By.xpath("//select[@id='projectDropdown']");
	By card_close_btn = By.xpath("//button[contains(text(), 'Close')]");
	By card_save_btn = By.xpath("//button[contains(text(), 'Save changes')]");
	By card_comments_textarea = By.xpath("//textarea[@name='comment']");
	
	String card_priority_str_low = "Low";
	String card_priority_str_med = "Medium";
	String card_priority_str_high = "High";
	String card_type_str_issue = "Issue";
	String card_type_str_req = "Requirement";
	String card_type_str_task = "Task";
	String card_stage_str_backlog = "Backlog";
	String card_stage_str_todo = "To Do";
	String card_stage_str_wip = "Work in Progress";
	String card_stage_str_veri = "Verification";
	String card_stage_str_done = "Complete";
	String card_stage_str_accepted = "Accepted";
	
	String admin_user_role_project = "Project";
	String admin_user_role_admin = "Admin";
	String admin_user_role_user = "User";
	//li[@class='app__listGroupItem___YRRDR list-group-item']
	
	
	//Project Page
	By project_page_link = By.xpath("//a[contains(text(), 'Project')]");
	By project_page = By.xpath("//h1[text()='Project']");
	By project_newproject_btn = By.xpath("//button[contains(text(), 'New Project')]");
	By project_projectitem1 = By.xpath("//div[@class='project-list']/li[1]");
	
	By project_create_name = By.xpath("//input[@id='name']");
	By project_create_shortCode = By.xpath("//input[@id='shortCode']");
	By project_create_desc = By.xpath("//textarea[@id='description']");
	By project_createbtn = By.xpath("//button[@class='app__customButtonDark___3iEgP btn btn-dark btn-block']");

	
	By project_addmembers_select = By.xpath("//select[@id='userID']");
	By project_addmembers_select_first = By.xpath("//option[2]");
	By project_addmembers_addbutn = By.xpath("//button[contains(text(), 'Add Members')]");
	
	By project_addepics_name = By.xpath("//input[@id='epicName']");
	By project_addepics_save = By.xpath("//button[contains(text(), 'Add Epic')]");
	
	//Chat page
	By chat_page_link = By.xpath("//a[contains(text(), 'Chat')]");
	By chat_page = By.xpath("//h1[text()='Chat']");
	By chat_message_text = By.xpath("//input[1]");
	By chat_send = By.xpath("//button[contains(text(), 'S')]");

}
