package parametersAndparallels_testNG;

import org.testng.annotations.Test;

public class TestParallel1 {
	@Test
	public void testMethod1() throws InterruptedException {
		System.out.println("Test Parallel 1 -> Test Method 1 ");
		Thread.sleep(6000);
		System.out.println("One more time, Test Parallel 1 -> Test Method 1 ");
	}

	@Test
	public void testMethod2() throws InterruptedException {
		System.out.println("Test Parallel 1 -> Test Method 2 ");
		Thread.sleep(6000);
		System.out.println("One more time, Test Parallel 1 -> Test Method 2 ");
	}
}
