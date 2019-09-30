package testngFeatures;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoSoftAssert
{
  @Test
  public void f()
  {
	  SoftAssert sa= new SoftAssert();
	  System.out.println("Test 1- checking the first test");
	  sa.assertEquals(10, 12);
	  System.out.println("Test 2- checking the second test");
	  sa.assertTrue("selenium".contains("basic"),"eroor MSG");
	  sa.assertAll();  
  }
}
