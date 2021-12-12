package multiplewaystolocate_ele;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementState {

	WebDriver wd;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		FindByIdXPath.disableSeleniumLogs();
		wd = new ChromeDriver();
		baseURL = "https:www.google.com/";
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.get(baseURL);
	}

	@Test
	public void test() {
		WebElement we = wd.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
		// we.sendKeys("letskodeit");
		System.out.println(we.isEnabled());

	}

	@After
	public void tearDown() throws Exception {
	}

}
