package demoModule7_exel;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class WritetoTestme {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
  @Test(dataProvider = "credentials")
  public void TestMeAppLogin(String username, String password) throws InterruptedException
  {
	  System.out.println(username);
	  driver.findElement(By.xpath("//a[@href='login.htm']")).click();
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(username);
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  driver.findElement(By.xpath("//a[contains(.,'SignOut')]")).click();
	  //WebElement signout=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(.,'SignOut')]")));
      //Assert.assertNotNull(signout);
  }

  @DataProvider(name="credentials")
  public Object[][] getData() throws IOException {
    return MyExelReader.readData();
  }
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
      driver= new ChromeDriver(); //open chrome browser
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      driver.get("http://10.232.237.143:443/TestMeApp/"); // open website
  }

  @AfterTest
  public void afterTest() throws InterruptedException
  {
	  Thread.sleep(3000);
	  driver.close();
  }

}
