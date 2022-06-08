/**
 * 
 */
package workingwithactionsclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Anji
 *
 */
public class DragAndDropActions {

	WebDriver wd;
	String baseURL;
	JavascriptExecutor jse;

	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Driver\\chromedriver.exe");
		wd = new ChromeDriver();
		baseURL = "https://jqueryui.com/droppable/";

		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wd.get(baseURL);
	}

	@Test
	public void test1() throws InterruptedException {

		Thread.sleep(2000);

		wd.switchTo().frame(0);

		WebElement from = wd.findElement(By.id("draggable"));
		WebElement to = wd.findElement(By.id("droppable"));

		// Drag and drop action
		Actions a = new Actions(wd);
		// a.dragAndDrop(from, to);

		// Click and hold, move to ele, release , build and perform
		a.clickAndHold(from).moveToElement(to).release().build().perform();

	}

	@AfterMethod
	public void tearDown() throws Exception {

		Thread.sleep(2000);
		wd.quit();
	}
}
