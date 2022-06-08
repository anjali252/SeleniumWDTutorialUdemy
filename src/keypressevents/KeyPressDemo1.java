package keypressevents;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KeyPressDemo1 {

	WebDriver wd;
	String baseURL;
	JavascriptExecutor jse;

	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Driver\\chromedriver.exe");
		wd = new ChromeDriver();
		baseURL = "https://learn.letskodeit.com/p/practice";

		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wd.get(baseURL);
	}

	@Test
	public void test1() throws InterruptedException {

		wd.findElement(By.xpath("//a[@href='/sign_in'][1]")).click();
		Thread.sleep(2000);
		wd.findElement(By.id("user_email")).sendKeys("test@gmail.com");
		Thread.sleep(2000);
		wd.findElement(By.id("user_email")).sendKeys(Keys.TAB);
		// wd.findElement(By.id("user_password")).sendKeys("test@gmail");
		// Thread.sleep(2000);
		// wd.findElement(By.name("commit")).sendKeys(Keys.ENTER);

	}

	@AfterMethod
	public void tearDown() throws Exception {

		Thread.sleep(2000);
		wd.quit();
	}
}
