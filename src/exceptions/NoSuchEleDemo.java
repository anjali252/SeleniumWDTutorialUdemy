/**
 * 
 */
package exceptions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Anji
 *
 */
public class NoSuchEleDemo {

	WebDriver wd;
	String baseURL;
	JavascriptExecutor jse;

	@Before
	public void setUp() throws Exception {

		wd = new ChromeDriver();
		baseURL = "https://learn.letskodeit.com/p/practice";

		wd.manage().window().maximize();
		// wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wd.get(baseURL);
	}

	@Test
	public void test1() throws InterruptedException {

		// timing issue= implicit wait or explicit wait
		wd.findElement(By.xpath("//a[@href='/sign_in']")).click();
		WebDriverWait wait = new WebDriverWait(wd, 3);
		WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
		email.sendKeys("test@gmail.com");

		// incorrect locator or type of locator

		// ele is in iframe
		wd.get("https://letskodeit.teachable.com/p/practice");
		wd.switchTo().frame("courses-iframe");
		wd.findElement(By.id("search-courses")).sendKeys("python");
		wd.switchTo().defaultContent();
	}

	@After
	public void tearDown() throws Exception {

		Thread.sleep(2000);
		wd.quit();
	}
}
