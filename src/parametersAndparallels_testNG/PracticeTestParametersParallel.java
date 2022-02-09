package parametersAndparallels_testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PracticeTestParametersParallel {

	WebDriver wd;
	String baseURL;

	@BeforeClass
	@Parameters({ "browser" })
	public void setUp(String browser) throws Exception {
//		FindByIdXPath.disableSeleniumLogs();
		if (browser.equalsIgnoreCase("chrome")) {
			wd = new ChromeDriver();
		} else {
			wd = new FirefoxDriver();
		}
		baseURL = "https://letskodeit.teachable.com/";
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wd.get(baseURL);
	}

	@Test
	public void testLogin() throws InterruptedException {
// LOgin link = //a[@class='navbar-link fedora-navbar-link']
		// email / password
		// login btn name=commit
		wd.findElement(By.xpath("//a[@href='/sign_in']")).click();
		wd.findElement(By.id("email")).sendKeys("test@gmail.com");
		wd.findElement(By.id("password")).sendKeys("Test");
		wd.findElement(By.name("commit")).click();

	}
}
