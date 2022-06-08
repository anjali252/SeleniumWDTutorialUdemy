/**
 * 
 */
package switchwinandiframes;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Anji
 *
 */
public class SwitchWindow {

	/**
	 * @throws java.lang.Exception
	 */
	WebDriver wd;
	String baseURL;

	@BeforeMethod
	public void setUp() throws Exception {

		wd = new ChromeDriver();
		baseURL = "https://learn.letskodeit.com/p/practice";

		wd.manage().window().maximize();
		wd.get(baseURL);
		wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@Test
	public void test2() throws InterruptedException {

		// Get Window Handle
		String parentHandle = wd.getWindowHandle();
		System.out.println("Parent Handle = " + parentHandle);

		// Find open window button
		WebElement openWin = wd.findElement(By.id("openwindow"));
		openWin.click();

		// Get all handles
		Set<String> handles = wd.getWindowHandles();

		// switching b/w handles
		for (String i : handles) {
			System.out.println(i);
			if (!i.equals(parentHandle)) {
				wd.switchTo().window(i);
				WebElement srchBox = wd.findElement(By.id("search-courses"));
				srchBox.sendKeys("python");
				Thread.sleep(2000);
				wd.close();
				break;
			}
		}

		// switching back to parent window
		wd.switchTo().window(parentHandle);
		wd.findElement(By.id("name")).sendKeys("Test Successful");

	}

	@AfterMethod
	public void tearDown() throws Exception {

		Thread.sleep(3000);
		wd.quit();
	}
}
