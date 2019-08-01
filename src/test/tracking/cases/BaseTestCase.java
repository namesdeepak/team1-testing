package test.tracking.cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import test.tracking.pobj.HomePage;
import test.tracking.pobj.LoginPage;


public class BaseTestCase {

	String baseUrl = "http://localhost:3000";
	WebDriver driver;
	LoginPage loginPage;
	HomePage home;

	
	@BeforeTest
	public void launch()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\sel-chrome-driver\\chromedriver.exe");
		System.setProperty("webdriver.baseurl", "http://localhost:3000");
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}
	
//	@AfterClass
//	public void close()
//	{
//		driver.close();
//	}
}
