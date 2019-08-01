package test.tracking.pobj;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.tracking.constants.ObjectLibrary;

public class BaseObject {
	WebDriver driver;
	
	
	
	public void writeTextBox(By locator, String value){
		oneMoreWait(locator);
		WebElement textBox = driver.findElement(locator);
		textBox.clear();
		textBox.sendKeys(value);
	}

	
	public String readTextBox(By locator){
		oneMoreWait(locator);
		return driver.findElement(locator).getAttribute("value");
	}
	

	public String readSelectedOption(By locator){
		oneMoreWait(locator);
		Select drop = new Select(driver.findElement(locator) );
		return drop.getFirstSelectedOption().getText(); //getAttribute("value");
	}
	
	public void clickElement(By locator){
		oneMoreWait(locator);
		driver.findElement(locator).click();
	}
	
	public void selectOption( By locator, String value){
		oneMoreWait(locator);
		Select drop = new Select(driver.findElement(locator) );
		drop.selectByVisibleText(value);
	}
	
	public boolean isElementEnabled(By locator) {
	
		return driver.findElement(locator).isEnabled();
	}

	public boolean isElementDisplayed(By locator) {
		boolean found = false;
		try {
			found = driver.findElement(locator).isDisplayed();
		}catch(org.openqa.selenium.NoSuchElementException nel) {
			found = false;
		}
		return found;
	}
	
	public void waitForPageLoad() {

	    Wait<WebDriver> wait = new WebDriverWait(driver, 30);
	    wait.until(new Function<WebDriver, Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            return String
	                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
	                .equals("complete");
	        }
	    });
	}
	
	public void oneMoreWait(By locator){
	    Wait<WebDriver> wait = new WebDriverWait(driver, ObjectLibrary._WAIT_);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
}
