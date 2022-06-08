package multiplewaystolocate_ele;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementState {

	WebDriver wd;
	String baseURL;

	@BeforeMethod
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

	@AfterMethod
	public void tearDown() throws Exception {
	}

}
