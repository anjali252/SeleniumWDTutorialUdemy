package extentreports_advancedreporting;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {

	public static ExtentReports getInstance() {
		ExtentReports extent;
		String path = System.getProperty("user.dir") + "\\extentReport\\report-demo.html";
		extent = new ExtentReports(path, false);
		return extent;

	}
}
