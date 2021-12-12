package exceptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoComplete {

	WebDriver wd;
	String baseURL;
	JavascriptExecutor jse;

	@Before
	public void setUp() throws Exception {
		wd = new ChromeDriver();
		baseURL = "https://www.goibibo.com/";

		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wd.get(baseURL);
	}

	@Test
	public void test1() throws InterruptedException {
		String srchingTxt = "New York, United States(NYC)";
		String partialTxt = "New York";

		WebElement txt = wd.findElement(By.id("gosuggest_inputSrc"));
		txt.sendKeys(partialTxt);

		WebElement ele = wd.findElement(By.id("react-autosuggest-1"));

		List<WebElement> results = ele.findElements(By.tagName("li"));
		int size = results.size();

		System.out.println("Size=" + size);

		for (int i = 0; i < size; i++) {
			System.out.println(results.get(i).getText());
		}

		Thread.sleep(3000);
		for (WebElement i : results) {
			if (i.getText().contains(srchingTxt)) {
				System.out.println("Selected =" + i.getText());
				i.click();
				break;
				// if we remove break from here, list disappears after click and then loop is
				// still going to trying to access next eele
				// ele we found previously doesn't exist and ele has become stale

				// if we switch line 53 with 54 then also same excpetion

				// if previously found ele don't exist on dom, don't try to use it
			}
		}

	}

	@After
	public void tearDown() throws Exception {

		Thread.sleep(2000);
		wd.quit();
	}
}
