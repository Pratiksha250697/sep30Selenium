package demoWebDriverMethods;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DemWikipedia
{
	WebDriver driver;
  @Test
  public void f()
  {
	  driver.get("https://en.wikipedia.org/wiki/Main_Page"); 
	  driver.findElement(By.linkText("History")).click();
	  
	  Assert.assertEquals(driver.getTitle(), "Portal:History - Wikipedia");
	  
	  String url=driver.getCurrentUrl();
	  System.out.println("Current page url is: "+url);
	  
	  System.out.println(driver.getPageSource());
	  
  }
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
	  driver= new ChromeDriver(); //open chrome browser
      driver.manage().window().maximize(); //maximizes window
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() throws InterruptedException
  {
	  Thread.sleep(3000); 
	  driver.close();
  }

}
