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

public class GetValDemo {

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
		WebElement we = wd.findElement(By.id("name"));
		String attriVal = we.getAttribute("class");
		System.out.println("Value of the attribute is " + attriVal);

	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		wd.quit();

	}

}
