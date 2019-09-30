package demoWebDriverMethods;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DemoNavigate 
{
	WebDriver driver;
	
  @Test
  public void f() throws InterruptedException
  {
	  driver.get("http://www.google.com");
	  Assert.assertEquals(driver.getTitle(), "Google");
	  Thread.sleep(3000);
	  driver.navigate().to("https://www.seleniumhq.org/");
	  Assert.assertEquals(driver.getTitle(), "Selenium - Web Browser Automation");
	  Thread.sleep(3000);
	  driver.navigate().back();
	  Thread.sleep(3000);
	  driver.navigate().forward();
	  Thread.sleep(3000);
	  driver.navigate().refresh();
	  Thread.sleep(3000);
	  System.out.println("Page refreshed");
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
