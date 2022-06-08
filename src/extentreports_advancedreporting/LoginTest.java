package extentreports_advancedreporting;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.Screenshots;

public class LoginTest {
	WebDriver driver;
	String url;
	ExtentReports report;
	ExtentTest test;
	HomePage hp;

	@Test
	public void testValidLogin() throws InterruptedException {
//		hp.clickLoginLink();
//		hp.enterEmailPassword("agrawal@gmail.com", "agrawal");
//		hp.clickLoginButton();

		hp.login("agrawal@gmail.com", "agrawal");

		Thread.sleep(3000);
		boolean result = hp.isAccountNamePresent();
		AssertJUnit.assertTrue(result);
		test.log(LogStatus.PASS, "Login Successful");
	}

	@BeforeClass
	public void beforeClass() {
		report = ExtentFactory.getInstance();
		test = report.startTest("Verify Account Test");
		url = "http://automationpractice.com/index.php";
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		hp = new HomePage(driver, test);
		test.log(LogStatus.INFO, "Chrome Browser Opening..");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		test.log(LogStatus.INFO, "Landed on Web Application..");
	}

	@AfterMethod
	public void tearDown(ITestResult testResult) throws IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			String path = Screenshots.takeScreenshot(driver, testResult.getName());
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, "Verify Account Text Failed", imagePath);
		}

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
		test.log(LogStatus.INFO, "Closing Browser..");
		report.endTest(test);
		report.flush(); // This is what actually flushes the report object. Things might not work as
						// expected without using it.
	}

}
