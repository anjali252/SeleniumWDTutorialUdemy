package testclasses_testNG;

import org.testng.annotations.Test;

import appcode_testNG.SomeClass2Test;

public class TestAnnotation {
	@Test
	public void testMethod1() {
		SomeClass2Test obj = new SomeClass2Test();
		int result = obj.sumNo(2, 3);
		System.out.println("Running test -> testMethod1");
	}

	@Test
	public void testMethod2() {
		System.out.println("Running test -> testMethod2");
	}

	@Test
	public void testMethod3() {
		System.out.println("Running test -> testMethod3");
	}

}
