package test.tracking.pojo;

import java.util.ArrayList;

public class TestData {

	ArrayList<Card> cards = new ArrayList<Card>();
	private static TestData td = null;
	
	String userName = "Automation Script";
	String email = "script@work.com";
	String password = "LifeIsBeautiful";
	String admin = "htdeepak@bu1.edu";
	String admin_pass = "deepak";
	
	String project_name = "Automation-Project-2";
	String project_shortCode = "AUTO";
	String project_desc = "This is a Project for Selenium automation tests";
	String[] project_epics_arr = {"Dashboard", "Users"};
	
	String epic = "Project Management";
	String message = "Sending the text message in chat for the Testing";
	String comment = "Need more information on the Acceptance Criteria";
	
	private TestData() {
		init();
	}
	
	public static TestData getTestData() {
		if(td == null)
			td = new TestData();
		
		return td;
	}
	
	public Card getNextCard() {
		Card card = cards.iterator().next();
		cards.remove(card);
		return card;
	}
	
	private void init() {
		
		Card card1 = new Card("AUTOMATION 1 - As a User I want to Login to the application",
				"Any user with a valid credentials should be able to login",
				"High", "Requirement", "Backlog","2" );
		
		Card card2 = new Card("AUTOMATION 2 - Create slides for Demo",
				"No Slides No Demo, Know Slides Know Demo",
				"High", "Requirement", "Work in Progress","2" );
		
		Card card3 = new Card("AUTOMATION 3 - Logged in user not redirected to Sprint page",
				"Logged in user should be redirected to current active sprint",
				"High", "Requirement", "Work in Progress","2" );
		
		cards.add(card1);
		cards.add(card2);
		cards.add(card3);
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getAdmin_pass() {
		return admin_pass;
	}

	public void setAdmin_pass(String admin_pass) {
		this.admin_pass = admin_pass;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getProject_shortCode() {
		return project_shortCode;
	}

	public void setProject_shortCode(String project_shortCode) {
		this.project_shortCode = project_shortCode;
	}

	public String getProject_desc() {
		return project_desc;
	}

	public void setProject_desc(String project_desc) {
		this.project_desc = project_desc;
	}

	public String[] getProject_epics_arr() {
		return project_epics_arr;
	}

	public void setProject_epics_arr(String[] project_epics_arr) {
		this.project_epics_arr = project_epics_arr;
	}

	public String getEpic() {
		return epic;
	}

	public void setEpic(String epic) {
		this.epic = epic;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(TestData.getTestData().getNextCard().title);
		System.out.println(TestData.getTestData().getNextCard().title);
		System.out.println(TestData.getTestData().getNextCard().title);
	}

}
