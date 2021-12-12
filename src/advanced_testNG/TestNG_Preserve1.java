package advanced_testNG;

import org.testng.annotations.Test;

public class TestNG_Preserve1 {

	@Test
	public void testMethod1() {
		System.out.println("TestNG_Preserve1 -> TestMethod1");
	}

	@Test
	public void testMethod2() throws InterruptedException {
		System.out.println("TestNG_Preserve1 -> TestMethod2");
		Thread.sleep(200);
	}

}
