package datadriventesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.Constants;
import utilities.SingleDataSet_ExcelUtility;

public class SingleDataSetUsingExcel extends SingleDataSet_ExcelUtility {
	private WebDriver driver;

	@Test
	public void testUsingExcel() throws Exception {
		String email = SingleDataSet_ExcelUtility.getTestData(1, 0);
		String password = SingleDataSet_ExcelUtility.getTestData(1, 1);
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys(email); // incorrect email
		driver.findElement(By.id("passwd")).sendKeys(password); // incorrect password
		driver.findElement(By.id("SubmitLogin")).click();
		Thread.sleep(2000);
		// find if error message exists
		boolean result = driver.findElements(By.xpath("//div[@class='alert alert-danger']//p")).size() != 0;
		AssertJUnit.assertTrue(result);

		SingleDataSet_ExcelUtility.setTestData("Pass", 1, 2);
	}

	@BeforeClass
	public void beforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(utilities.Constants.URL);

		// Tell driver about location of excel file
		SingleDataSet_ExcelUtility.setExcelFile(Constants.File_Path + Constants.File_Name, "Sheet1"); // Sheet1 is sheet
																										// name
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
