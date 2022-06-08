/**
 * 
 */
package advanced_testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import appcode_testNG.SomeClass2Test;

/**
 * @author Anji
 *
 */
public class TestNG_DependentTestCases {

	SomeClass2Test obj;

	@BeforeClass
	public void beforeClass() {
		System.out.println("TestNG_Priority -> before class");
		obj = new SomeClass2Test();
	}

	@AfterClass
	public void afterClass() {
		System.out.println("TestNG_Priority -> after class");
	}

	@Test(dependsOnMethods = { "testMethod2" }, alwaysRun = true)
	public void testMethod1() {
		System.out.println("TestNG_Priority -> TestMethod1");
	}

	@Test
	public void testMethod2() {
		System.out.println("TestNG_Priority -> TestMethod2");
		int result = obj.sumNo(1, 2);
		AssertJUnit.assertEquals(result, 3);

	}

	@Test(dependsOnMethods = { "testMethod1" })
	public void testMethod3() {
		System.out.println("TestNG_Priority -> TestMethod3");
	}

	@Test(dependsOnMethods = { "testMethod3" })
	public void testMethod4() {
		System.out.println("TestNG_Priority -> TestMethod4");
	}
}
