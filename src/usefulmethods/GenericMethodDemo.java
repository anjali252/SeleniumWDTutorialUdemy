package usefulmethods;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenericMethodDemo {

	WebDriver wd;
	String baseURL;
	GenericMethodsOld gm;

	@BeforeMethod
	public void setUp() throws Exception {
		wd = new ChromeDriver();
		baseURL = "https://learn.letskodeit.com/p/practice";
		gm = new GenericMethodsOld(wd);

		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		wd.get(baseURL);
	}

	@Test
	public void test() {
		WebElement we = gm.getEle("name", "id");
		// we.sendKeys("Test");
		// WebElement we = wd.findElement(By.id("name"));
		we.sendKeys("Test");
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
	}

}
