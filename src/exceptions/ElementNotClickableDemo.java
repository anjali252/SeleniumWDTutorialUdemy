package exceptions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementNotClickableDemo {

	WebDriver wd;
	String baseURL;
	JavascriptExecutor jse;

	@BeforeMethod
	public void setUp() throws Exception {

		wd = new ChromeDriver();
		baseURL = "https://classic.freecrm.com/index.html?e=1";

		wd.manage().window().maximize();
		// wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wd.get(baseURL);
	}

	@Test
	public void test1() throws InterruptedException {

		// we should use explicit wait firstly
		// WebDriverWait wait = new WebDriverWait(wd, 3);
		// WebElement login =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login")));
		// login.click();

		// if not then (this way preferred)
		// boolean invisible=
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("whatever
		// locator mentioned in stack trcae saying ele would receive click")));
		// if(invisible){
		// find login btn locator and click it
		// }

		// this one also prefereed- using jse
		// js.executeScript("arguments[0].click();",login);

	}

	@AfterMethod
	public void tearDown() throws Exception {

		Thread.sleep(2000);
		wd.quit();
	}
}
