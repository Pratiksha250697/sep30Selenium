package ExtentApi;

import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import junit.framework.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class DemoTestMe
{
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	
  @Test
  public void failTestDemoWebShop() 
  {
	  logger= extent.createTest("failTest");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://10.232.237.143:443/TestMeApp/login.htm");
	  driver.findElement(By.id("userName")).sendKeys("Lalitha");
	  driver.findElement(By.id("password")).sendKeys("Password12");
	  driver.findElement(By.name("Login")).click();
	  Assert.assertTrue(driver.findElement(By.partialLinkText("SignOut")).isDisplayed());
	  driver.findElement(By.partialLinkText("SignOut")).click();
  }
  
  
  @AfterMethod
  public void getResult(ITestResult result) throws IOException
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
  public void beforeTest()
  {
	  System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
	  htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/extent-reports"+new SimpleDateFormat("hh-mm-ss-ms-dd-MM-yyyy").format(new Date())+".html");
      extent=new ExtentReports();
      extent.attachReporter(htmlReporter);
      extent.setSystemInfo("Host Name", "GFT NexGen Testing Stream");
      extent.setSystemInfo("Environment","Automation testing-Selenium");
      extent.setSystemInfo("User name","Pratiksha Kale");
      
      htmlReporter.config().setDocumentTitle("HTML_Report");
      htmlReporter.config().setReportName("Report2");
      htmlReporter.config().setTheme(Theme.STANDARD);
  }

  
  @AfterTest
  public void afterTest() throws InterruptedException 
  {
	
	  Thread.sleep(3000);
	  driver.close();
	  extent.flush();
  }

}
