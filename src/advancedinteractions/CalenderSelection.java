package advancedinteractions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderSelection {

	WebDriver wd;
	String baseURL;

	@Before
	public void setUp() throws Exception {

		wd = new ChromeDriver();
		baseURL = "https://www.cheapoair.com/";

		wd.get(baseURL);
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	// public void test1() {
	// // Find Departing Field
	// WebElement depart =
	// wd.findElement(By.xpath("//div[contains(@class,'calendarDepart')]//input"));
	// // Click Departing Field
	// depart.click();
	// WebElement date = wd.findElement(
	// By.xpath("//div[contains(@class,'calendar__single-month')][2]//a[@aria-label='9
	// June 2020']"));
	// date.click();
	// }

	@Test
	public void test2() throws InterruptedException {
		// Find Departing Field
		WebElement depart = wd.findElement(By.xpath("//div[contains(@class,'calendarDepart')]//input"));
		// Click Departing Field
		depart.click();
		WebElement month = wd.findElement(By.xpath("//div[contains(@class,'calendar__single-month')][2]"));
		List<WebElement> validDates = month.findElements(By.tagName("a"));
		Thread.sleep(2000);
		for (WebElement i : validDates) {
			if (i.getText().contains("9")) {
				i.click();
				break;
			}
		}

	}

	@After
	public void tearDown() throws Exception {
		// Thread.sleep(3000);
		// wd.quit();
	}


}
