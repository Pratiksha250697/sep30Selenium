package demoWebDriverMethods;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class DemoRegistration 
{
	WebDriver driver;
  @Test
  public void f() throws InterruptedException
  {
	  driver.get("http://newtours.demoaut.com/"); // open website
	  driver.findElement(By.linkText("REGISTER")).click();
	  Assert.assertEquals(driver.getTitle(), "Register: Mercury Tours");
	  System.out.println(driver.getTitle());
	  driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Pratiksha");
	  driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Kale");
	  driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("8600056699");
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("pkale992@gmail.com");
	  driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("Ghodegaon");
	  driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("Panmala");
	  driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Pune");
	  driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Maharashtra");
	  driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("412408");
	  Select country=new Select(driver.findElement(By.name("country")));
	  country.selectByIndex(4);
	  Thread.sleep(3000);
	  country.selectByValue("8");
	  Thread.sleep(3000);
	  country.selectByVisibleText("INDIA");
	  Thread.sleep(3000);
	
	  driver.findElement(By.xpath("//input[@name='email']")).sendKeys("mercury");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("mercury");
	  driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("mercury");
	  driver.findElement(By.xpath("//input[@name='register']")).submit();
	  Thread.sleep(3000);
  }
  
  @BeforeClass
  public void beforeClass() 
  {

	  System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
	  driver= new ChromeDriver(); //open chrome browser
      driver.manage().window().maximize(); //maximizes window
  }

  @AfterClass
  public void afterClass() throws InterruptedException 
  {
	  Thread.sleep(3000); 
	  driver.close();
  }

}
