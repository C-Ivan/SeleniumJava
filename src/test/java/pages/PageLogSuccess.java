package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageLogSuccess {
	private By productDrop;
	private By modelDrop;
	private WebDriver driver;
	private By titleText;
	public PageLogSuccess(WebDriver driver) {
		this.driver = driver;
		titleText = By.cssSelector("#menuUserLink > span");
		productDrop = By.name("categoryListboxContactUs");
		modelDrop= By.name("productListboxContactUs");
}
	
	public void assertLogSuccessPage() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement logSuccess = driver.findElement(titleText);
		Assert.assertTrue(wait.until(ExpectedConditions.textToBePresentInElement(logSuccess, "admin")));
	}
	
	public void selectProduct(int index) {
		Select selectProduct = new Select(driver.findElement(productDrop));
		selectProduct.selectByIndex(index);
	}
	
	public void selectModel(String model) {
		Select selectModel = new Select(driver.findElement(modelDrop));
		selectModel.selectByVisibleText(model);
	}
}
