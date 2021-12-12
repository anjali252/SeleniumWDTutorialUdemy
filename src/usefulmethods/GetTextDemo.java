package usefulmethods;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import multiplewaystolocate_ele.FindByIdXPath;

public class GetTextDemo {

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
		WebElement btn = wd.findElement(By.id("opentab"));
		String btnText = btn.getText();
		System.out.println("Text on the element is " + btnText);

	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		wd.quit();
	}

}
