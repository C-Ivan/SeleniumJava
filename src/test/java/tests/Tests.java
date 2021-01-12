package tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.Helpers;
import helpers.Screenshooter;
import helpers.WebDriverManager;
import pages.PageLogin;
import pages.PageLogFail;
import pages.PageLogSuccess;

public class Tests {
	private WebDriver driver;
	//ArrayList<String> tabs;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().window().fullscreen();
		//driver.manage().window().setSize(new Dimension(200, 200));
		//for(int i=0;i<=800;i++)
		//driver.manage().window().setPosition(new Point(i, i));
		driver.navigate().to("http://advantageonlineshopping.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//JavascriptExecutor javaScriptExecutor = (JavascriptExecutor)driver; 
		//String googleWindow = "window.open('http://www.google.com')";
		//javaScriptExecutor.executeScript(googleWindow);
		//tabs = new ArrayList<String> (driver.getWindowHandles());
	}
	@Test
	public void pruebaUno() {
		//WebDriverManager.setWindowSize(driver, "maximized");
		//driver.switchTo().window(tabs.get(1)).navigate().to("http://www.youtube.com/user/Draculinio");
		//driver.switchTo().window(tabs.get(0));
		PageLogin pageLogin = new PageLogin(driver);
		PageLogFail pageLogFail = new PageLogFail(driver);
		pageLogin.login("user", "user");
		Helpers helper = new Helpers();
		helper.sleepSeconds(3);
		pageLogFail.assertLogFailPage();
		
	}
	
	@Test
	public void pruebaDos() {
		//WebDriverManager.setWindowSize(driver, "maximized");
		PageLogin pageLogin = new PageLogin(driver);
		PageLogSuccess pageLogSuccess = new PageLogSuccess(driver);
		pageLogin.login("admin", "adm1n");
		Helpers helper = new Helpers();
		helper.sleepSeconds(1);
		pageLogSuccess.assertLogSuccessPage();
		
	}
	
	@Test
	public void pruebaTres() {
		//WebDriverManager.setWindowSize(driver, "maximized");
		PageLogin pageLogin = new PageLogin(driver);
		PageLogSuccess pageLogSuccess = new PageLogSuccess(driver);
		pageLogin.login("admin", "adm1n");
		pageLogSuccess.selectProduct(3);
		pageLogSuccess.selectModel("HP Elite x2 1011 G1 Tablet");
		
	}
	
	@Test
	public void pruebaCantidadDeCampos() {
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.verifyFields();		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(!result.isSuccess()) {
			Screenshooter.takeScreenshot("Error", driver);
		}
		driver.close();
		//driver.switchTo().window(tabs.get(1)).close();
		//driver.switchTo().window(tabs.get(0)).close();
	}
}