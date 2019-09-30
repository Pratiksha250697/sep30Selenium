package caseStudyWeek3;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class OnlineShoppingTest {
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	

	@Test (priority=3)
	public void testCart()
	{
		 Actions act = new Actions(driver);
		 act.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/a/span"))).click().pause(2000).perform();
		 act.moveToElement(driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/ul/li[1]/a/span"))).click().pause(2000).perform();
		 act.moveToElement(driver.findElement(By.xpath("//*[@id=\"submenuul11290\"]/li[1]/a/span"))).click().build().perform();
		 driver.findElement(By.xpath("//a[contains(.,'Add to cart')]")).click();
		 driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
		 driver.findElement(By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[5]/a")).click();
		
	}
	
	@Test (priority=2)
	public void testLogin()
	{   
		//driver=new ChromeDriver();
		//driver.manage().window().maximize();
	    //driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
		 driver.findElement(By.id("userName")).sendKeys("Lalitha");
		 driver.findElement(By.id("password")).sendKeys("Password123");
		 driver.findElement(By.name("Login")).click();
		 String text=driver.findElement(By.xpath("//ul[@class='nav navbar-nav']")).getText();
		 //System.out.println(text);
		 
		 Assert.assertEquals("Hi, Lalitha SignOut", text);
		logger.log(Status.PASS, MarkupHelper.createLabel("Test case passed is passTest", ExtentColor.GREEN));
	}

	@Test (priority=4)
	public void testPayment() throws InterruptedException 
	{
		 driver.findElement(By.xpath("/html/body/b/div/div/div[1]/div/div[2]/div[3]/div/form[2]/input")).click();
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//label[contains(.,'HDFC Bank')]")).click();
	     driver.findElement(By.xpath("//a[contains(.,'Continue')]")).click();
	     driver.findElement(By.xpath("//input[@name='username']")).sendKeys("123457");
	     driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Pass@457");
	     driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	     driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Trans@457");
	     driver.findElement(By.xpath("//input[@type='submit']")).click();
	     Thread.sleep(3000);
	     String text=driver.findElement(By.xpath("//td[@class='hidden-sm'][contains(.,'Headphone')]")).getText();
	     Assert.assertEquals("Headphone", text);
	     driver.findElement(By.xpath("/html/body/header/div/div/ul/b/a[1]")).click();
	     Thread.sleep(3000);
	     
	   
	   
	     
	}

	@Test (priority=1)
	public void testRegistraion() throws Exception
	{    logger=extent.createTest("PassTest");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://10.232.237.143:443/TestMeApp/RegisterUser.htm");
		 driver.findElement(By.id("userName")).sendKeys("Sushma");
		 driver.findElement(By.id("firstName")).sendKeys("Sushma");
		 WebDriverWait wait1=new WebDriverWait(driver, 10);
		 boolean flag1=wait1.until(ExpectedConditions.textToBe(By.id("err"), "Available"));
		 System.out.println(flag1);
		 Assert.assertTrue(flag1);
		 String flag2= driver.findElement(By.id("firstName")).getText();
		 System.out.println(flag2);
		 driver.findElement(By.id("lastName")).sendKeys("Jadhav");
		 driver.findElement(By.id("password")).sendKeys("sush123");
		 driver.findElement(By.id("pass_confirmation")).sendKeys("sush123");
		 driver.findElement(By.xpath("//input[contains(@value,'Male')]")).click();
		 driver.findElement(By.id("emailAddress")).sendKeys("sush123@gmail.com");
		 driver.findElement(By.id("mobileNumber")).sendKeys("8600056692");
		 driver.findElement(By.id("dob")).sendKeys("25/06/1997");
		 driver.findElement(By.id("address")).sendKeys("Pune,Maharashtra");
		 Select s1=new Select(driver.findElement(By.xpath("//select[contains(@id,'securityQuestion')]")));
		 s1.selectByIndex(1);
		 Thread.sleep(3000);
		 driver.findElement(By.id("answer")).sendKeys("BabyPink");
		 driver.findElement(By.name("Submit")).click();
		 
		
	}

	@AfterMethod
	public void getRestAfterMethod(ITestResult result) throws IOException 
	{

		  if(result.getStatus()== ITestResult.FAILURE)
		  {
			 logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"- Test case Failed", ExtentColor.RED));
			 TakesScreenshot snapshot=(TakesScreenshot)driver;
			 File src=snapshot.getScreenshotAs(OutputType.FILE);
			 String path=System.getProperty("user.dir")+""+result.getName()+"";
	         FileUtils.copyFile(src, new File(path));
			logger.addScreenCaptureFromPath(path,result.getName());
			 
			 logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+"- Test case Failed", ExtentColor.RED));
		   }
		  else if(result.getStatus()==ITestResult.SKIP)
		  {
			  logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"- Test case skipped", ExtentColor.BLUE));
		  }
		  
	}

	@BeforeTest
	public void startReportBeforeTest() 
	{
		 System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		  htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/extent-reports"+new SimpleDateFormat("hh-mm-ss-ms-dd-MM-yyyy").format(new Date())+".html");
	      extent=new ExtentReports();
	      extent.attachReporter(htmlReporter);
	      extent.setSystemInfo("Host Name", "GFT NexGen Testing Stream");
	      extent.setSystemInfo("Environment","Automation testing-Selenium");
	      extent.setSystemInfo("User name","Pratiksha Kale");
	      
	      htmlReporter.config().setDocumentTitle("HTML_Report");
	      htmlReporter.config().setReportName("Report_of_caseStudy");
	      htmlReporter.config().setTheme(Theme.STANDARD);
	}

	@AfterTest
	public void EndReportAfterTest() throws InterruptedException 
	{
		
		  Thread.sleep(3000);
		  driver.close();
		  extent.flush();
	}

}
