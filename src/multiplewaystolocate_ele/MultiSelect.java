package multiplewaystolocate_ele;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelect {

	WebDriver wd;
	String baseURL;

	@BeforeMethod
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
		WebElement we = wd.findElement(By.id("multiple-select-example"));
		Select sel = new Select(we);

		Thread.sleep(2000);

		sel.selectByValue("apple");
		System.out.println("Selected apple by Value");

		Thread.sleep(2000);

		sel.deselectByValue("apple");
		System.out.println("DESelected apple by Value");

		Thread.sleep(2000);

		sel.selectByIndex(1);
		System.out.println("Selected Orange by Index");

		Thread.sleep(2000);

		sel.selectByVisibleText("Peach");
		System.out.println("Selected Peach by Visible Text");

		Thread.sleep(2000);

		System.out.println("Printing the list of all selected options");

		List<WebElement> seloption = sel.getAllSelectedOptions();

		for (int i = 0; i < seloption.size(); i++) {
			WebElement ele = seloption.get(i);
			System.out.println(ele.getText());
		}

		System.out.println("Deselect all the options");

		sel.deselectAll();

	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		wd.quit();
	}

}
