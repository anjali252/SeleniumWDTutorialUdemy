/**
 * 
 */
package switchwinandiframes;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Anji
 *
 */
public class SwitchFrame {

	/**
	 * @throws java.lang.Exception
	 */
	WebDriver wd;
	String baseURL;

	@Before
	public void setUp() throws Exception {

		wd = new ChromeDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";

		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wd.get(baseURL);
	}

	@Test
	public void test2() throws InterruptedException {

		Thread.sleep(3000);

		// switch to frame by id
		wd.switchTo().frame("courses-iframe");
		// switch to frame by id
		// wd.switchTo().frame("iframe-name");
		// switch to frame by number
		// wd.switchTo().frame(0);

		wd.findElement(By.id("search-courses")).sendKeys("python");

		wd.switchTo().defaultContent();

		Thread.sleep(2000);

		wd.switchTo().defaultContent();

		Thread.sleep(1000);

		wd.findElement(By.id("displayed-text")).sendKeys("Test Successful");

		System.out.println("Hi I am not getting response : " + wd.findElement(By.id("displayed-text")));

		Thread.sleep(2000);

	}

	@After
	public void tearDown() throws Exception {

		Thread.sleep(10000);
		wd.quit();
	}
}
