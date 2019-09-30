package demoActions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Drag_n_Drop 
{
	WebDriver driver;
	@Test
	public void f()
	{
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");

		WebElement dragElement = driver.findElement(By.id("draggable"));
		WebElement dropElement = driver.findElement(By.id("droppable"));

		Actions act = new Actions(driver);
		act.dragAndDrop(dragElement, dropElement).build().perform();

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
