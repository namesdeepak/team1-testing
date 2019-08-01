/**
 * 
 */
package test.tracking.cases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import test.tracking.constants.ObjectLibrary;
import test.tracking.pobj.AdminPage;
import test.tracking.pobj.BackLogPage;
import test.tracking.pobj.ChatPage;
import test.tracking.pobj.LoginPage;
import test.tracking.pobj.ProjectPage;
import test.tracking.pobj.RegisterPage;
import test.tracking.pobj.ReportPage;
import test.tracking.pobj.SprintPage;
import test.tracking.pojo.Card;
import test.tracking.pojo.TestData;

/**
 * @author 310104215
 *
 */
public class AcceptanceTests extends BaseTestCase {
	
	TestData testData = null;
	LoginPage login = null;
	RegisterPage registerPage = null;
	ProjectPage project = null;
	BackLogPage backlog = null; 
	AdminPage admin = null;
	SprintPage sprint = null;
	ReportPage report = null;
	ChatPage chat = null;
	
	String storyTitleGlobal = null;
	
	@BeforeClass
	private void loadTestData() throws InterruptedException {
		testData = TestData.getTestData();
		registerPage = new RegisterPage(driver);
		login = new LoginPage(driver);
    	project = new ProjectPage(driver);
    	backlog = new BackLogPage(driver);
    	admin = new AdminPage(driver);
    	sprint = new SprintPage(driver);
    	report = new ReportPage(driver);
    	chat = new ChatPage(driver);
    	
    	cleanTestData();
	}
	
	@AfterClass
	private void cleanUp() throws InterruptedException {
		login.logout();
		driver.close();
//		cleanTestData();
	}
	
	private void cleanTestData() throws InterruptedException {
//		driver = new ChromeDriver();
//		driver.get(baseUrl);
		login.login(testData.getEmail(), testData.getPassword());
		project.deleteProject(testData.getProject_name());
		login.logout();
		login.login(testData.getAdmin(), testData.getAdmin_pass());
		admin.deleteAllUsersExceptAdmin();
		login.logout();
		
	}
	
	@Test (priority=1, description="Verify that the application is available on the cloud server")
	public void testApplicationAvailability() 
	{

		registerPage.isApplicationAvailable();
		Reporter.log("Application is available @ " + driver.getCurrentUrl());
	}
	
	
	
	@Test (priority=2, description="Verify that a User with incorrect Credentials cannot login")
	public void testInvalidCredentials() 
	{

		try {
			login.login("userdoes@not.exist", "kaboom");
			Assert.assertFalse(login.isElementDisplayed(ObjectLibrary.sprint_page), "Sprint page is displayed for the Invalid user");
			login.clickElement(ObjectLibrary.login_closebtn);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	 
	@Test (priority=3, description="Verify that a User can register to the Tracking application")
	public void testUserRegistration() throws InterruptedException 
	{
    	AutomationUtil.waitPlease();


    	registerPage.registerUser(testData.getUserName(), testData.getEmail(), testData.getPassword());
    	login.login(testData.getEmail(), testData.getPassword());
    	login.clickElement(ObjectLibrary.logout);
    	
	}
	
	
	
	 
	@Test (priority=4, description="Verify that the Registered User is not a Project Manager by default")
	public void testUserDefaultRole() throws InterruptedException 
	{

    	login.login(testData.getEmail(), testData.getPassword());
    	Assert.assertFalse(login.isElementDisplayed(ObjectLibrary.project_page_link), "Project Page is displayed for the default User!");
    	login.clickElement(ObjectLibrary.logout);
	}
	
	
	
	 
	@Test (priority=5, description="Verify that Admin can promote a registered User to Project Manager")
	public void testUserPromotion() throws InterruptedException 
	{
//		LoginPage login = new LoginPage(driver);
    	login.login(testData.getAdmin(), testData.getAdmin_pass());
    	Assert.assertTrue(login.isElementEnabled(ObjectLibrary.admin_pageMain), "Admin Page link is not available to the ADMIN");
    	admin.promoteUser(testData.getEmail(), ObjectLibrary.admin_user_role_project);
    	login.logout();
    	AutomationUtil.waitPlease();
    	//Login as the user
    	login.login(testData.getEmail(), testData.getPassword());
    	Assert.assertTrue(login.isElementEnabled(ObjectLibrary.project_page_link), "Project Page link is not available to the Promoted User");
	}
	
	
	
	 
	@Test (priority=6, description="Verify that Project Manager can create a Project")
	public void testProjectCreation() throws InterruptedException 
	{
//		LoginPage login = new LoginPage(driver);
//		login.login(testData.getEmail(), testData.getPassword());
    	AutomationUtil.waitPlease();
    	Assert.assertTrue(login.isElementEnabled(ObjectLibrary.project_page_link), "Project Page link is not available to the Promoted User");
    	project.createProject(testData.getProject_name(), testData.getProject_shortCode(), testData.getProject_desc());
    	
	}
	
	
	
	 
	@Test (priority=7, description="Verify that Project Manager can add Epics to the created Project")
	public void testAddingEpicsToProject() throws InterruptedException 
	{
		project.addEpicToProject(testData.getProject_name(), testData.getEpic());
		AutomationUtil.waitPlease();
	}
	
	
	
	 
	@Test (priority=8, description="Verify that Project manager can add Users to the created Project")
	public void testAddingUsersToProject() throws InterruptedException 
	{
		project.addUserToProject(testData.getProject_name(), testData.getEmail());
		AutomationUtil.waitPlease();
	}
	
	
	
	 
	@Test (priority=9, description="Verify that User can select the project in the Backlog page")
	public void testProjectSelectionInBacklog() throws InterruptedException 
	{
		backlog.clickElement(ObjectLibrary.backlog_page_link);
		backlog.selectProject(testData.getProject_name());
		AutomationUtil.waitPlease();
	}
	
	
	
	 
	@Test (priority=10, description="Verify that the User can create a Card in the Backlog page")
	public void testCreateCardInBacklog() throws InterruptedException 
	{
		Card card = testData.getNextCard();
		storyTitleGlobal = card.getTitle();
		backlog.createCard(card.getTitle(), card.getDesc(), card.getPriority(), card.getType(), card.getLoad(), card.getStage(), testData.getProject_name());
		AutomationUtil.waitPlease();
	}
	
	
	
	 
	@Test (priority=11, description="Verify that the User can move the first card in the backlog to the active Sprint")
	public void testAddCardToCurrentSprint() throws InterruptedException 
	{
		backlog.changeCardStage(1, ObjectLibrary.card_stage_str_todo, testData.getProject_name());

	}
	
	
	
	 
	@Test (priority=12, description="Verify that User can Navigate to Sprint page")
	public void testNavigateToSprintPage() 
	{
		sprint.clickElement(ObjectLibrary.sprint_page_link);
		Assert.assertTrue(driver.findElement(ObjectLibrary.sprint_page).isDisplayed(), "Sprint page navigation failed");
	}
	
	
	
	 
	@Test (priority=13, description="Verify that User can select the project in the Sprint page")
	public void testProjectSelectionInSprint() throws InterruptedException 
	{
//		login.gotoHomePage();
//		sprint.clickElement(ObjectLibrary.sprint_page_link);
		AutomationUtil.waitPlease();
		sprint.selectProject(testData.getProject_name());
		AutomationUtil.waitPlease();
	}
	
	
	
	 
	@Test (priority=14, description="Verify that User can create a Card in the Sprint Page")
	public void testCreateCardInSprintPage() throws InterruptedException 
	{
		Card card = testData.getNextCard();
//		storyTitleGlobal = card.getTitle();
		sprint.createCard(card.getTitle(), card.getDesc(), card.getPriority(), card.getType(), card.getLoad(), card.getStage(), testData.getProject_name());
		AutomationUtil.waitPlease();
	}
	
	
	
	 
	@Test (priority=15, description="Verify that User can Move the Card from To-Do to Work in Progress stage")
	public void testCardMoveFromToDo2WIP() throws InterruptedException 
	{
		sprint.changeCardStage(testData.getProject_name(), ObjectLibrary.card_stage_str_todo, ObjectLibrary.card_stage_str_wip);
		AutomationUtil.waitPlease();
	}
	
	@Test (priority=16, description="Verify that User can Add comments to a Card")
	public void testAddCommentsToCard() 
	{
		sprint.addComments(storyTitleGlobal, testData.getComment(), testData.getProject_name());
	}
	 
	@Test (priority=17, description="Verify that User can Move the Card from Work in Progress to Verification stage")
	public void testCardMoveFromWIP2Verification() throws InterruptedException 
	{
		sprint.changeCardStage(testData.getProject_name(), ObjectLibrary.card_stage_str_wip, ObjectLibrary.card_stage_str_veri);
		AutomationUtil.waitPlease();
	}
	
	 
	@Test (priority=18, description="Verify that User can Move the Card from Verification to Complete stage")
	public void testCardMoveFromVerification2Complete() throws InterruptedException 
	{
		sprint.changeCardStage(testData.getProject_name(), ObjectLibrary.card_stage_str_veri, ObjectLibrary.card_stage_str_done);
		AutomationUtil.waitPlease();
	}
	
	 
	@Test (priority=19, description="Verify that User can Move the Card from To-Do to Backlog stage")
	public void testCardMoveFromComplete2Accepted() throws InterruptedException 
	{
		sprint.changeCardStage(testData.getProject_name(), ObjectLibrary.card_stage_str_done, ObjectLibrary.card_stage_str_accepted);
		AutomationUtil.waitPlease();
	}
	 
	
		 
	@Test (priority=20, description="Verify that the Cards in the Sprint Page are grouped by their stage")
	public void testCardsGroupingInSprintPage() 
	{
		sprint.verifyStoriesGroupingByStages();
	}
	
	 
	@Test (priority=21, description="Verify that User can navigate to Reports page ")
	public void testNavigateToReportPage()
	{
		Assert.assertTrue(driver.findElement(ObjectLibrary.reports_page_link).isDisplayed(), "Report page link is not displayed");
		report.clickElement(ObjectLibrary.reports_page_link);
		Assert.assertTrue(driver.findElement(ObjectLibrary.reports_page).isDisplayed(), "Reports page navigation failed");
		
	}
	 
	@Test (priority=22, description="Verify that User can navigate to Reports page ")
	public void testFilterByProjectAndStageReportPage()
	{
		Assert.assertTrue(report.filterCardsByProjectAndStage(testData.getProject_name(), ObjectLibrary.card_stage_str_accepted) > 0, "No cards in Reports Accepted");
	}
	 
	
	@Test (priority=23, description="Verify that User can Navigate to Chat page")
	public void testNavigateToChatPage() 
	{
		Assert.assertTrue(driver.findElement(ObjectLibrary.chat_page_link).isDisplayed(), "Chat page link is not displayed");
		report.clickElement(ObjectLibrary.chat_page_link);
		Assert.assertTrue(driver.findElement(ObjectLibrary.chat_page).isDisplayed(), "Chat page navigation failed");

	}
	
	@Test (priority=24, description="Verify that User can select the project in the Chat page")
	public void testProjectSelectionInChat() throws InterruptedException 
	{
		AutomationUtil.waitPlease();
		chat.selectProject(testData.getProject_name());
		
	}
	
	@Test (priority=25, description="Verify that User can View the chat messages along with time stamp")
	public void testSendMessage() throws InterruptedException 
	{
		AutomationUtil.waitPlease();
		chat.sendMessage(testData.getMessage());
	}
	 
	@Test (priority=26, description="Verify that User can logout")
	public void testUserLogout() throws InterruptedException 
	{
		AutomationUtil.waitPlease();
//		login.logout();
	}
	
	
	
	 


}
