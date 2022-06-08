/**
 * 
 */
package jsexecution;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Anji
 *
 */
public class JSExecution {

	/**
	 * @throws java.lang.Exception
	 */
	WebDriver wd;
	String baseURL;
	JavascriptExecutor jse;

	@BeforeMethod
	public void setUp() throws Exception {

		wd = new ChromeDriver();
		baseURL = "https://learn.letskodeit.com/p/practice";
		jse = (JavascriptExecutor) wd;
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() {

		// wd.get(baseURL);
		jse.executeScript("window.location='https://learn.letskodeit.com/p/practice';");
		// WebElement email = wd.findElement(By.id("name"));
		WebElement text = (WebElement) jse.executeScript("return document.getElementById('name');");
		text.sendKeys("letskodeit@gmail.com");

	}

	@AfterMethod
	public void tearDown() throws Exception {

		// Thread.sleep(3000);
		// wd.quit();
	}
}
