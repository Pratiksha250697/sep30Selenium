package demodrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenChromeBrowser 
{

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		 WebDriver driver;
         System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
         driver= new ChromeDriver(); //open chrome browser
         driver.get("http://www.google.com"); // open website
         driver.manage().window().maximize(); //maximizes window
         Thread.sleep(3000); //waits for 3 seconds
         driver.close(); //closes the browser
      }
}
