package testclasses_testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BeforeClassAnnotations {

	@BeforeMethod
	@BeforeClass
	public void setUp() {
		System.out.println("\nThis method runs before class");
	}

	@AfterClass
	public void cleanUp() {
		System.out.println("\nThis method runs after class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\nThis method runs before each methods");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("\nThis method runs after each methods");
	}

	@Test
	public void testMethod1() {
		System.out.println("\nRunning test -> testMethod1");
	}

	@Test
	public void testMethod2() {
		System.out.println("\nRunning test -> testMethod2");
	}
}
