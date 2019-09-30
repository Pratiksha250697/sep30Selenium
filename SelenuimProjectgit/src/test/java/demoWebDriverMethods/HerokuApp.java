package demoWebDriverMethods;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class HerokuApp
{
	WebDriver driver;
  @Test
  public void f() throws InterruptedException
  {

	  driver.get("http://the-internet.herokuapp.com/login"); // open website
	  
	  Assert.assertEquals(driver.getTitle(), "The Internet");
	  driver.findElement(By.name("username")).sendKeys("tomsmith");
	  driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
	  driver.findElement(By.className("radius")).click();
	  Assert.assertEquals(driver.getTitle(), "The Internet");
	  Thread.sleep(3000); 
	  driver.findElement(By.linkText("Logout")).click();
	  Thread.sleep(3000); 
	  
  }
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
	  driver= new ChromeDriver(); //open chrome browser
      driver.manage().window().maximize(); //maximizes window
    
  }

  @AfterTest
  public void afterTest() throws InterruptedException
  {

	  Thread.sleep(3000); 
	  driver.close();
  }

}
