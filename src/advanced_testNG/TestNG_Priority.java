package advanced_testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_Priority {
	@Test(priority = 2)
	public void testMethod1() {
		System.out.println("TestNG_Priority -> TestMethod1");
	}

	@Test(priority = 1)
	public void testMethod2() {
		System.out.println("TestNG_Priority -> TestMethod2");
	}

	@Test(priority = 0)
	public void testMethod3() {
		System.out.println("TestNG_Priority -> TestMethod3");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("TestNG_Priority -> before class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("TestNG_Priority -> after class");
	}

}
