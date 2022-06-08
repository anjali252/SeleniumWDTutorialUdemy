package testclasses_testNG;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import appcode_testNG.SomeClass2Test;

public class TestAsserts {
	@Test
	public void testSumNo() {
		System.out.println("\nRunning test -> testSumNo");// default order of test are alphabetically
		SomeClass2Test obj = new SomeClass2Test();
		int result = obj.sumNo(2, 3);
		AssertJUnit.assertEquals(result, 5);
	}

	@Test
	public void testAddString() {
		System.out.println("\nRunning test -> testAddString");
		SomeClass2Test obj = new SomeClass2Test();
		String result = obj.addString("Hello", "World");
		String expected = "Hello World";
		AssertJUnit.assertEquals(result, expected);

	}

	@Test
	public void testGetArray() {
		System.out.println("\nRunning test -> testGetArray");
		SomeClass2Test obj = new SomeClass2Test();
		int[] result = obj.getArray();
		int[] expected = { 1, 2, 3 };
		AssertJUnit.assertEquals(result, expected);
		System.out.println("\nEnd test -> testGetArray");
	}

}
