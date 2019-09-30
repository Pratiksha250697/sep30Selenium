package demoWebDriverMethods;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DemoAlerts 
{
	WebDriver driver;
	
  @Test
  public void f() throws InterruptedException 
  {
	  driver.get("http://demo.automationtesting.in/Alerts.html");
	  
	  driver.findElement(By.xpath("//a[@href='#Textbox']")).click();
	  WebDriverWait wait= new WebDriverWait(driver, 30);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-info']")));
	  
	  driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
	  
	  Alert alrtbx=driver.switchTo().alert();
	  String msg=alrtbx.getText();
	  System.out.println("alert msg is: "+msg);
	  alrtbx.sendKeys("Pratiksha");
	  Thread.sleep(3000); 
	  alrtbx.accept();
	  
	  
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
