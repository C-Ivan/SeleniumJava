package pages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PageLogin {
	private WebDriver driver;
	private By userField;
	private By passField;
	private By loginButton;
	private By fields;
	
	public PageLogin(WebDriver driver) {
		this.driver = driver;
		userField = By.name("username");
		passField = By.name("password");
		loginButton = By.id("sign_in_btnundefined");
		fields = By.tagName("input");
	}
	
	public void login(String user, String pass) {
		driver.findElement(By.id("hrefUserIcon")).click();
		//Helpers helpera = new Helpers();
		//helpera.sleepSeconds(1);
		driver.findElement(userField).sendKeys(user);
		driver.findElement(passField).sendKeys(pass);
		driver.findElement(loginButton).click();
		/*File myScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(myScreenshot, new File("LOGIN "+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Helpers helper = new Helpers();
		//helper.sleepSeconds(1);
	}
	
	public void verifyFields() {
		List<WebElement> loginFields = driver.findElements(fields);
		System.out.println(loginFields.size());
		Assert.assertTrue(loginFields.size() == 5);
		
	}
	
	
}
