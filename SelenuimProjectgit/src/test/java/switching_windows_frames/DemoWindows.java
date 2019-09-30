package switching_windows_frames;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class DemoWindows 
{
	WebDriver driver;
	 @BeforeTest
	  public void beforeTest() 
	 {
		 System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
         driver= new ChromeDriver(); //open chrome browser
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
  
	 @Test
  public void f()
	 {
		 driver.get("http://10.232.237.143:443/TestMeApp/");
		 Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/a/span"))).pause(2000).
		moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/ul/li/a/span"))).
		moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/ul/li/ul/li[1]/a/span"))).click().build().perform();
        
		Set<String> set=driver.getWindowHandles();
		for (String string:set)
		{
			driver.switchTo().window(string);
		}
		
	    driver.switchTo().frame(driver.findElement(By.xpath("/html/frameset/frame[2]")));
	    String address=driver.findElement(By.tagName("address")).getText();
	    System.out.println(address);
	    //Assert.assertEquals("Chennai, India",address);
  }
 

  @AfterTest
  public void afterTest() throws InterruptedException
  {
	  Thread.sleep(3000); 
		driver.close();
  }

}
