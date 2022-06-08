package listeners_TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener2.class)
public class TestNGListenersTest2 {
	@Test
	public void testMethod1() {
		AssertJUnit.assertTrue(true);
		System.out.println("Executing Test Method 1");
	}

	@Test
	public void testMethod2() {
		AssertJUnit.assertTrue(false);
		System.out.println("Executing Test Method 2");
	}

	@BeforeClass
	public void beforeTest() {
		System.out.println("Executing Before Class");
	}

	@AfterClass
	public void afterTest() {
		System.out.println("Executing After Class");
	}

}
