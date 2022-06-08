package reporterlogs_htmlreports_testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReportsAndLogs {
	@Test
	public void testMethod1() {
		Reporter.log("testMethod1", true);
	}

	@Test
	public void testMethod2() {
		AssertJUnit.assertTrue(false);
		Reporter.log("testMethod2", true);
	}

	@Test(dependsOnMethods = { "testMethod2" })
	public void testMethod3() {
		Reporter.log("testMethod3", true);
	}

	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("Before Method", true);
	}

	@AfterMethod
	public void afterMethod() {
		Reporter.log("After Method", true);
	}

	@BeforeClass
	public void beforeClass() {
		Reporter.log("Before Class", true);
	}

	@AfterClass
	public void afterClass() {
		Reporter.log("After Class", true);
	}

	@BeforeTest
	public void beforeTest() {
		Reporter.log("Before Test", true);
	}

	@AfterTest
	public void afterTest() {
		Reporter.log("After Test", true);
	}

}
