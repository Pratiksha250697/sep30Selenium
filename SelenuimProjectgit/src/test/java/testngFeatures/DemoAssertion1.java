package testngFeatures;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoAssertion1 {
  
	@Test
  public void test1()
	{
		System.out.println("test 1 started");
		Assert.assertEquals("Hello","Hi","Does not match");
		System.out.println("test 1 completed");
    }
	
	@Test
	  public void test2()
		{
		System.out.println("test 2 started");
		Assert.assertNotEquals("hii","hello","");
		System.out.println("test 2 completed");
	    }
	
	@Test
	  public void test3()
		{
		System.out.println("test 3 started");
		Assert.assertTrue("selenium".contains("len"),"does not contain");
		System.out.println("test 3 completed");
	    }
	
	@Test
	  public void test4()
		{
		System.out.println("test 4 started");
		Assert.assertFalse("selenium".contains("p"),"Contains");
		System.out.println("test 4 completed");
	    }
	

	@Test
	  public void test5()
		{
		Object test=null;
		System.out.println("test 5 started");
		Assert.assertNull(test, "its null");
		System.out.println("test 5 completed");
	    }
	
	@Test
	  public void test6()
		{
		
		System.out.println("test 6 started");
		Assert.fail("intentionally failing the test");
		System.out.println("test 6 completed");
	    }
	

	@Test
	  public void test7()
		{
		
		System.out.println("test 7 started");
		Assert.fail("intentionally failing the test");
		System.out.println("test 7 completed");
	    }
	
}
