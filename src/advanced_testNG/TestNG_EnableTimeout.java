package advanced_testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_EnableTimeout {

	@BeforeClass
	public void beforeClass() {
		System.out.println("TestNG_Priority -> before class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("TestNG_Priority -> after class");
	}

	@Test(enabled = false) // This will tell TestNG that this method is disabled and do not run it.
	public void testMethod1() {
		System.out.println("TestNG_Priority -> TestMethod1");
	}

	@Test(timeOut = 100) // If there is a constraint we can apply a timeout to the test method and
	// if that test method runs for more time than what we have provided here then
	// testng will mark it
	// as fail.
	public void testMethod2() throws InterruptedException {
		System.out.println("TestNG_Priority -> TestMethod2");
		Thread.sleep(200);
	}


}
