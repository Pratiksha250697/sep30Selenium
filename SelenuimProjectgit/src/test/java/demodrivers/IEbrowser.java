package demodrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEbrowser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        WebDriver driver;
        System.setProperty("webdriver.ie.driver", "resources\\IEDriverServer.exe");
		driver= new InternetExplorerDriver(); //open Firefox browser
		driver.get("http://www.google.com"); // open website
		driver.manage().window().maximize(); //maximizes window
		Thread.sleep(3000);
		driver.close(); //closes the browser

	}

}
