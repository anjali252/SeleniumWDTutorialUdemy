package advanced_testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_Grouping {
	@Test(groups = { "cars", "suv" })
	public void testTataNexon() {
		System.out.println("TestNG_Priority -> testTataNexon");
	}

	@Test(groups = { "cars", "sedan" })
	public void testMarutiSuzukiCiaz() {
		System.out.println("TestNG_Priority -> testMarutiSuzukiCiaz");
	}

	@Test(groups = { "bikes" })
	public void testHondaCD110Dream() {
		System.out.println("TestNG_Priority -> testHondaCD110Dream");
	}

	@Test(groups = { "bikes" })
	public void testBajajCT100() {
		System.out.println("TestNG_Priority -> testBajajCT100");
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("TestNG_Priority -> before class");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		System.out.println("TestNG_Priority -> after class");
	}

}
