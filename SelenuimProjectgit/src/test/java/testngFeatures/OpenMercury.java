package testngFeatures;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class OpenMercury {
	WebDriver Driver;
  @Test
  
  public void f() {
	    Driver.get("http://newtours.demoaut.com/"); // open website
  }
  
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
      Driver= new ChromeDriver(); //open chrome browser
      Driver.manage().window().maximize(); //maximizes window
	  
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(3000);
      Driver.close(); //closes the browser
  }

}
