/**
 * 
 */
package jsexecution;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Anji
 *
 */
public class JSClick {

	/**
	 * @throws java.lang.Exception
	 */
	WebDriver wd;
	String baseURL;
	JavascriptExecutor jse;

	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Driver\\chromedriver.exe");
		wd = new ChromeDriver();
		baseURL = "https://learn.letskodeit.com/p/practice";
		jse = (JavascriptExecutor) wd;
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// @Test
	// public void test1() throws InterruptedException {
	//
	// jse.executeScript("window.location='https://learn.letskodeit.com/p/practice';");
	//
	// Thread.sleep(3000);
	//
	// WebElement chkbox = (WebElement) jse.executeScript("return
	// document.getElementById('bmwcheck');");
	// jse.executeScript("arguments[0].click();", chkbox);
	// }

	@Test
	public void test2() throws InterruptedException {

		jse.executeScript("window.location='https://zoom.us/';");

		Thread.sleep(3000);

		WebElement signup = wd.findElement(By.xpath("//li[@class='signin']/a"));
		jse.executeScript("arguments[0].click();", signup);

		WebElement cont = (WebElement) jse.executeScript("return document.getElementById('keep_me_signin');");
		System.out.println(cont.isDisplayed());
		System.out.println(cont.isSelected());
		cont.click();
		// jse.executeScript("arguments[0].click();", cont);
	}

	@AfterMethod
	public void tearDown() throws Exception {

		Thread.sleep(3000);
		wd.quit();
	}
}
