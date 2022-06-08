/**
 * 
 */
package switchwinandiframes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Anji
 *
 */
public class SwitchAlert {

	/**
	 * @throws java.lang.Exception
	 */
	WebDriver wd;
	String baseURL;

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

		Thread.sleep(1000);

		wd.findElement(By.id("name")).sendKeys("Anjali");

		wd.findElement(By.id("alertbtn")).click();

		Thread.sleep(3000);

		Alert a = wd.switchTo().alert(); // used for js pop ups
		a.accept();

	}

	@Test
	public void test2() throws InterruptedException {

		Thread.sleep(1000);

		wd.findElement(By.id("name")).sendKeys("Anjali");

		wd.findElement(By.id("confirmbtn")).click();

		Thread.sleep(3000);

		Alert a = wd.switchTo().alert();
		a.dismiss();
	}

	@AfterMethod
	public void tearDown() throws Exception {

		Thread.sleep(2000);
		wd.quit();
	}
}
