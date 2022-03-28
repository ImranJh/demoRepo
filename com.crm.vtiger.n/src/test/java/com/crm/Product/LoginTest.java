package com.crm.Product;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginTest {
	@Test
	public void login()
	{
		String browser = System.getProperty("browser");
		String link = System.getProperty("url");
		String id = System.getProperty("username");
		String pas = System.getProperty("password");
		
	WebDriver driver = null;
	if(browser.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}
	else if(browser.equals("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
	}
	else if(browser.equals("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get(link);
	driver.findElement(By.name("user_name")).sendKeys(id);
	driver.findElement(By.name("user_password")).sendKeys(pas);
	driver.findElement(By.id("submitButton")).click();
	
	WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act = new Actions(driver);
	act.moveToElement(logout).perform();
	driver.findElement(By.linkText("Sign Out")).click();
	
	driver.close();

		
	}

}
