package test.tracking.cases;
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.ArrayList;
import java.net.URL;

//MAKE JAVADOC

public class AutomationUtil //ANY HELPER METHODS YOU CAN ADD HERE - Make this a general file 
//Eg - writer methods, sleep methods 
{
	/**
	 * this method reads from a file using a scanner.
	 * it returns each line in a String[] where each element is one line.
	 * @param filename takes in a filepath for a txt file 
	 * @return returns a String[]
	 */
	public static String[] read(String filename) // Write only a method that returns a string[] from CSV file
	{
		
		Scanner s = null;
		try {
			s = new Scanner(new File(filename));
		} catch (java.io.FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> lines = new ArrayList<String>(); 
		
		while(s.hasNext())
		{
			lines.add(s.nextLine());
		}
		String[] arr = new String[lines.size()];
		arr = lines.toArray(arr);
		return arr;
	}
	
	public static void toAccessController(WebDriver driver, int LSM)
	{
		By menu = By.xpath("//*[@id=\"interact-device-map-dev-list\"]/li[2]/img[1]"); 
		
		driver.findElement(menu).click();
		driver.findElement(By.linkText("Access controller")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.id("user_login")).sendKeys("color");
		driver.findElement(By.id("user_password")).sendKeys("kinetics1");
		driver.findElement(By.id("user_submit_action")).click();
	}
	
	/**
	 * Wait method 
	 * @throws InterruptedException
	 */
	public static void waitPlease() throws InterruptedException {
		Thread.sleep(3000);
	}
}
