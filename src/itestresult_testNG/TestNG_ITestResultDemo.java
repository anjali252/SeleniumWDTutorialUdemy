package itestresult_testNG;

import static org.testng.Assert.assertTrue;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestNG_ITestResultDemo {
	@Test
	public void testMethod1() {
		System.out.println("Running Test Method 1");
		assertTrue(false);
	}

	@Test
	public void testMethod2() {
		System.out.println("Running Test Method 2");
		assertTrue(true);
	}

	@AfterMethod
	public void afterMethod(ITestResult testResult) {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed : " + testResult.getMethod().getMethodName());
		}
		if (testResult.getStatus() == ITestResult.SUCCESS) {
			System.out.println("Successful : " + testResult.getName());
		}
	}
}
