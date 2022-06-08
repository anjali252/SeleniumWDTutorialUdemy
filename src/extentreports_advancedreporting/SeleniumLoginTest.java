package extentreports_advancedreporting;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.Screenshots;

public class SeleniumLoginTest {
	WebDriver driver;
	String url;
	ExtentReports report;
	ExtentTest test;

	@Test
	public void testValidLogin() {
		driver.findElement(By.className("login")).click();
		test.log(LogStatus.INFO, "Clicked on Login Button.");
//		driver.findElement(By.id("email")).sendKeys("agrawal@gmail.com"); //correct email
		driver.findElement(By.id("email")).sendKeys("agrawal12345@gmail.com"); // incorrect email
		driver.findElement(By.id("passwd")).sendKeys("agrawal");
		driver.findElement(By.id("SubmitLogin")).click();
		test.log(LogStatus.INFO, "Submitted Login Credentials..");
		String account = driver.findElement(By.xpath("//a[@class='account']//span")).getText();
		test.log(LogStatus.PASS, account.equals("Anjali Agrawal") ? "Login Successful" : "Not Logged In");
	}

	@BeforeClass
	public void beforeClass() {
		report = new ExtentReports("E:\\Eclipse-Workspace\\SeleniumWDTutorialUdemy\\extentReport\\extentReport.html");
		test = report.startTest("Verify Account Test");
		url = "http://automationpractice.com/index.php";
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
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
