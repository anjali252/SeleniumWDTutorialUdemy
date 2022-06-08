package multiplewaystolocate_ele;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;

public class JUnitIntro {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		FindByIdXPath.disableSeleniumLogs();
		System.out.println("Before Class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Class");
	}

	@BeforeMethod
	public void setUp() throws Exception {
		System.out.println("Before Every Test");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		System.out.println("After Every Test");
	}

	@Test
	public void test1() {
		System.out.println("Test1");
	}

	@Test
	public void test2() {
		System.out.println("Test2");
	}

}
