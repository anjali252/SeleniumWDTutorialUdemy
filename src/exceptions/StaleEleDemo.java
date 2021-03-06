package exceptions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleEleDemo {

	WebDriver wd;
	String baseURL;
	JavascriptExecutor jse;

	@BeforeMethod
	public void setUp() throws Exception {
		wd = new ChromeDriver();
		baseURL = "https://learn.letskodeit.com/p/practice";

		wd.manage().window().maximize();
		// wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wd.get(baseURL);
	}

	@Test
	public void test1() throws InterruptedException {

		WebElement bmwChk = wd.findElement(By.id("bmwcheck"));// always find ele when you need it
		// wd.get(wd.getCurrentUrl()); its refreshing page
		bmwChk.click();
	}

	@AfterMethod
	public void tearDown() throws Exception {

		Thread.sleep(2000);
		wd.quit();
	}
}
