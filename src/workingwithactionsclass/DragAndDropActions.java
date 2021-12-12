/**
 * 
 */
package workingwithactionsclass;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Anji
 *
 */
public class DragAndDropActions {

	WebDriver wd;
	String baseURL;
	JavascriptExecutor jse;

	@Before
	public void setUp() throws Exception {

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

	@After
	public void tearDown() throws Exception {

		Thread.sleep(2000);
		wd.quit();
	}
}
