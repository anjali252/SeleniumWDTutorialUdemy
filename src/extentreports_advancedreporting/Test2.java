package extentreports_advancedreporting;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test2 {
	ExtentReports report;
	ExtentTest test;

	@Test
	public void f() {
		test.log(LogStatus.INFO, "Test Method of Test2 Started");
		test.log(LogStatus.INFO, "Test Method of Test2 Continuing");
		test.log(LogStatus.INFO, "Test Method of Test2 Ended");
	}

	@BeforeClass
	public void beforeClass() {
		report = ExtentFactory.getInstance();
		test = report.startTest("Before Class of Test 2");
	}

	@AfterClass
	public void afterClass() {
		report.endTest(test);
		report.flush(); // This is what actually flushes the report object. Things might not work as
						// expected without using it.
	}

}
