package testclasses_testNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import appcode_testNG.SomeClass2Test;

public class TestNGSoftAsserts {
	@Test
	public void testSumNo() {
		SoftAssert sa = new SoftAssert();
		System.out.println("\nRunning test -> testSumNo");// default order of test are alphabetically
		SomeClass2Test obj = new SomeClass2Test();
		int result = obj.sumNo(2, 3);
		sa.assertEquals(result, 23);
		System.out.println("\nLine after assert 1");
		sa.assertEquals(result, 5);
		System.out.println("\nLine after assert 2");
		sa.assertAll();
	}

}
