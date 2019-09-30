package testngFeatures;



import org.testng.annotations.Test;

public class MercuryApplication
{
	@Test(priority=1)
	public void openBrowser()
	{
     System.out.println("openBrowser");
	}
	
	@Test(priority=2)
	public void openUrl()
	{
		   System.out.println("openUrl");
	}
	
	@Test(priority=3)
	public void Login()
	{
		   System.out.println("Login");
	}
	
	@Test(priority=4)
	public void searchFlight()
	{
		   System.out.println("Searchflight");
	}
	
	@Test(priority=5, enabled=false)
	public void bookflight()
	{
		   System.out.println("bookFlight");
	}
	
	@Test(priority=6)
	public void logout()
	{
		   System.out.println("Logout");
	}
	
	@Test(priority=7)
	public void closeBrowser()
	{
		   System.out.println("closeBrowser");
	}
}
