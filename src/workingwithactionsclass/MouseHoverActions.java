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
public class MouseHoverActions {

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
		wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wd.get(baseURL);
	}

	@Test
	public void test1() throws InterruptedException {

		jse.executeScript("window.scrollBy(0,900);");

		Thread.sleep(1000);

		WebElement mainEle = wd.findElement(By.id("mousehover"));

		Actions a = new Actions(wd);
		a.moveToElement(mainEle).perform();

		Thread.sleep(2000);

		WebElement subEle = wd.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']"));
		// subEle.click();
		a.moveToElement(subEle).click().perform();

	}

	@After
	public void tearDown() throws Exception {

		Thread.sleep(2000);
		wd.quit();
	}
}
