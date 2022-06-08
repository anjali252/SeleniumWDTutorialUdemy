package datadriventesting;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.Constants;
import utilities.ExcelUtility;

public class UsingExcel {
	private WebDriver driver;

	@Test(dataProvider = "loginData")
	public void testUsingExcel(String email, String password) throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys(email); // incorrect email
		driver.findElement(By.id("passwd")).sendKeys(password); // incorrect password
		driver.findElement(By.id("SubmitLogin")).click();
		Thread.sleep(2000);
		// find if error message exists
		boolean result = driver.findElements(By.xpath("//div[@class='alert alert-danger']//p")).size() != 0;
		AssertJUnit.assertTrue(result);
	}

	@DataProvider(name = "loginData")
	public Object[][] dataProvider() {
		Object testData[][] = ExcelUtility.getTestData("Invalid_Login"); // Invalid_Login is table name
		return testData;
	}

	@BeforeClass
	public void beforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Constants.URL);
		driver.findElement(By.className("login")).click();
		// Tell driver about location of excel file
		ExcelUtility.setExcelFile(Constants.File_Path + Constants.File_Name, "LoginTest"); // LoginTest is sheet name
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
