package ExtentApi;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class DemoExtentReport
{
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	
	 @BeforeTest
	  public void startReport() 
	  {
		  htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/extent-reports"+new SimpleDateFormat("hh-mm-ss-ms-dd-MM-yyyy").format(new Date())+".html");
	      extent=new ExtentReports();
	      extent.attachReporter(htmlReporter);
	      extent.setSystemInfo("Host Name", "GFT NexGen Testing Stream");
	      extent.setSystemInfo("Environment","Automation testing-Selenium");
	      extent.setSystemInfo("User name","Pratiksha Kale");
	      
	      htmlReporter.config().setDocumentTitle("HTML_Report");
	      htmlReporter.config().setReportName("Report1");
	      htmlReporter.config().setTheme(Theme.STANDARD);
	  }
	
  @Test
  public void passTest() 
  {
	  logger=extent.createTest("PassTest");
	  Assert.assertTrue(true);
	  logger.log(Status.PASS, MarkupHelper.createLabel("Test case passed is passTest", ExtentColor.GREEN));
	
  }
  
  @Test
  public void failTest() 
  {
	  logger=extent.createTest("FailTest");
	  Assert.assertTrue(false);
  }
  
  @Test
  public void skipTest() 
  {
	  logger=extent.createTest("SkipTest");
	  throw new SkipException("Skipping-This is not ready for testing ");
  }
  
  @AfterMethod
  public void getResult(ITestResult result)
  {
	  if(result.getStatus()== ITestResult.FAILURE)
	  {
		 logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"- Test case Failed", ExtentColor.RED));
		 logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+"- Test case Failed", ExtentColor.RED));
	   }
	  else if(result.getStatus()==ITestResult.SKIP)
	  {
		  logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"- Test case skipped", ExtentColor.BLUE));
	  }
  }

 

  @AfterTest
  public void endReport()
  {
	  extent.flush();
  }

}
