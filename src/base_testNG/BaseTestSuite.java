package base_testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTestSuite {
	@BeforeClass
	public void beforeClass() {
		System.out.println("BaseTestSuite -> This method runs before class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("BaseTestSuite -> This method runs after class");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("BaseTestSuite -> This method runs before test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("BaseTestSuite -> This method runs after test");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BaseTestSuite -> This method runs before suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("BaseTestSuite -> This method runs after suite");
	}

}
