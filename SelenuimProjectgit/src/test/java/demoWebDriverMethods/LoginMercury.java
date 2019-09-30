package demoWebDriverMethods;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginMercury 
{
	WebDriver driver; 
  @Test
  public void f() throws InterruptedException
  {
	  driver.get("http://newtours.demoaut.com/"); // open website
	  
	  Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");
	  driver.findElement(By.name("userName")).sendKeys("mercury");
	  driver.findElement(By.name("password")).sendKeys("mercury");
	  driver.findElement(By.name("login")).click();
	  Assert.assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
	  Thread.sleep(3000); 
	  driver.findElement(By.linkText("SIGN-OFF"));
	  
  }
  
  
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
	  driver= new ChromeDriver(); //open chrome browser
      driver.manage().window().maximize(); //maximizes window
     //waits for 3 seconds
     
	  
  }
  

  @AfterTest
  public void afterTest() throws InterruptedException 
  {
	  Thread.sleep(3000); 
	  driver.close();
  }

}
