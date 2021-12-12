package keypressevents;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyPressDemo1 {

	WebDriver wd;
	String baseURL;
	JavascriptExecutor jse;

	@Before
	public void setUp() throws Exception {

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

	@After
	public void tearDown() throws Exception {

		Thread.sleep(2000);
		wd.quit();
	}
}
