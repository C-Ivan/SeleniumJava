package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageLogFail {
	private WebDriver driver;
	private By titleText;
	public PageLogFail(WebDriver driver) {
		this.driver = driver;
		titleText = By.id("signInResultMessage");
	}
	
	
	public void assertLogFailPage() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement logFail = driver.findElement(titleText);		
		Assert.assertTrue(wait.until(ExpectedConditions.textToBePresentInElement(logFail, "Incorrect user name or password.")));
				
}
}