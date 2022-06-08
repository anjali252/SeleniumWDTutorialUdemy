package advancedinteractions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoCompleteDemo {

	WebDriver wd;
	String baseURL;

	@BeforeMethod
	public void setUp() throws Exception {

		wd = new ChromeDriver();
		baseURL = "https://www.goibibo.com/";

		wd.get(baseURL);
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void testAutoComplete() throws InterruptedException {
		String partialText = "Del";
		String textToSelect = "Delhi, India(DEL)";
		WebElement textField = wd.findElement(By.id("gosuggest_inputSrc"));
		textField.sendKeys(partialText);

		WebElement ul = wd.findElement(By.id("react-autosuggest-1"));
		// We were unable to inspect options
		// The list disappears if we try to inspect list options elements

		String innerHTML = ul.getAttribute("innerHTML");
		// both aren't same thing.
		// left= variable
		// right = attribute of element
		System.out.println(innerHTML);

		List<WebElement> li = ul.findElements(By.tagName("li"));
		Thread.sleep(3000);
		for (WebElement i : li) {
			// System.out.println("Selected " + i.getText());
			if (i.getText().contains(textToSelect)) {
				System.out.println("Selected " + i.getText());
				i.click();
				break;
			}
		}

	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		wd.quit();
	}

}
