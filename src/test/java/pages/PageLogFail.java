package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(titleText).getText().contains("Incorrect user name or password."));
	}
}
