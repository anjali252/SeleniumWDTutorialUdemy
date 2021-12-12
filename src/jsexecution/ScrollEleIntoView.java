/**
 * 
 */
package jsexecution;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Anji
 *
 */
public class ScrollEleIntoView {

	/**
	 * @throws java.lang.Exception
	 */
	WebDriver wd;
	String baseURL;
	JavascriptExecutor jse;

	@Before
	public void setUp() throws Exception {

		wd = new ChromeDriver();
		baseURL = "https://learn.letskodeit.com/p/practice";
		jse = (JavascriptExecutor) wd;
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {

		jse.executeScript("window.location='https://learn.letskodeit.com/p/practice';");

		// scroll down
		jse.executeScript("window.scrollTo(0,1900);"); // document.body.scrollHeight
		Thread.sleep(3000);

		// scroll up
		jse.executeScript("window.scrollBy(0,-1900);");
		Thread.sleep(3000);

		// scroll ele into view
		WebElement mousehover = (WebElement) jse.executeScript("return document.getElementById('mousehover');");
		jse.executeScript("arguments[0].scrollIntoView(true);", mousehover);
		Thread.sleep(3000);

		// scroll up a bit
		jse.executeScript("window.scrollBy(0,-190);");
		Thread.sleep(3000);

	}

	@After
	public void tearDown() throws Exception {

		Thread.sleep(3000);
		wd.quit();
	}
}
