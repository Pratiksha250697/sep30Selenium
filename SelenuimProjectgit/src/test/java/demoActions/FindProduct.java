package demoActions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class FindProduct
{
	WebDriver driver;
  @Test
  public void f() 
  {
	  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm"); 
	  WebElement searchBX = driver.findElement(By.xpath("//input[@id='myInput']"));
	  Actions act=new Actions(driver);
	  act.keyDown(searchBX, Keys.SHIFT);
	  act.sendKeys("b").pause(300).sendKeys("a").pause(300).sendKeys("g").build().perform();
	  WebElement webx=driver.findElement(By.xpath("//input[contains(@name,'products')]"));
	  act.moveToElement(webx).click();
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  String text = driver.findElement(By.xpath("//h4[contains(.,'Hand bag')]")).getText();
	  Assert.assertTrue(text.contains("Hand"));

	 
  }
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.gecko.driver", "resources\\geckodriver.exe");
		driver= new FirefoxDriver(); //open Firefox browser
	 driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() throws InterruptedException
  {

	  Thread.sleep(3000); 
	  driver.close();
  }

}
