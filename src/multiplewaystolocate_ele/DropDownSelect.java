package multiplewaystolocate_ele;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownSelect {

	WebDriver wd;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		FindByIdXPath.disableSeleniumLogs();
		wd = new ChromeDriver();
		baseURL = "https://learn.letskodeit.com/p/practice";
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.get(baseURL);
	}

	@Test
	public void test() throws InterruptedException {
		WebElement we = wd.findElement(By.id("carselect"));
		Select sel = new Select(we);

		Thread.sleep(2000);

		sel.selectByValue("benz");
		System.out.println("Selected Benz by Value");

		Thread.sleep(2000);

		sel.selectByIndex(2);
		System.out.println("Selected Honda by Index");

		Thread.sleep(2000);

		sel.selectByVisibleText("BMW");
		System.out.println("Selected BMW by Visible Text");

		Thread.sleep(2000);

		System.out.println("Printing the list of all options");

		List<WebElement> option = sel.getOptions();
		int size = option.size();

		for (int i = 0; i < size; i++) {
			String optionName = option.get(i).getText();
			System.out.println(optionName);
		}

	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		wd.quit();
	}
}
