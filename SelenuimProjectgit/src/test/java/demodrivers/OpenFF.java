package demodrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenFF {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "resources\\geckodriver.exe");
		driver= new FirefoxDriver(); //open Firefox browser
		driver.get("http://www.google.com"); // open website
		driver.manage().window().maximize(); //maximizes window
		Thread.sleep(3000);
		driver.close(); //closes the browser
	}

}
