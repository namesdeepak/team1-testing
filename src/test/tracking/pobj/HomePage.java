package test.tracking.pobj;
import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;  
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
	WebDriver driver;
	
	By dropdown = By.xpath("//*[@id=\"interact-navbar-user-dropdown\"]");
	By homesiteaction = By.xpath("//*[@id=\"interact-home-site-action-image\"]");
	By homesiteactionedit = By.xpath("//*[@id=\"interact-home-site-action-edit\"]");
	
	By devicescolor = By.xpath("//*[@id=\"interact-sidebar-color\"]/img[1]");
		
	public HomePage(WebDriver input)
	{
		driver = input;
	}
	
	/** 
	 * todevicescolor navigates to the color range section of the page
	 */
	public void todevicescolor()
	{
		driver.findElement(devicescolor).click();
	}
	
}
