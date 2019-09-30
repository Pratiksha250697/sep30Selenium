package demoActions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class FindProduct2 
{
	WebDriver driver;

	@Test
	public void f() 
	{
		driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm"); 
		WebElement searchBX = driver.findElement(By.xpath("//input[@id='myInput']"));
		Actions act=new Actions(driver);
		act.keyDown(searchBX, Keys.SHIFT);
		act.sendKeys("w").pause(300).sendKeys("e").pause(300).sendKeys("a").pause(300).sendKeys("r").build().perform();
	
	}
	@BeforeTest
	public void beforeTest() 
	{

		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterTest
	public void afterTest() throws InterruptedException
	{
		Thread.sleep(3000); 
		driver.close();
	}

}
