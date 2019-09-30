package testngFeatures;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DemoDataProvider {
  @Test(dataProvider = "credentials")
  public void login(String username, String password) {
	  System.out.println("Username is: "+username);
	  System.out.println("Username is: "+password);
  }

  @DataProvider(name="credentials")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] {"Pratiksha", "Kale" },
      new Object[] {"Sushma","Jadhav" },
      new Object[] {"Selenium","Testing" },
    };
  }
}
