package multiplewaystolocate_ele;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicActions {

	WebDriver wd;
	String baseURL;

	@BeforeMethod
	public void setUp() throws Exception {
		FindByIdXPath.disableSeleniumLogs();
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Driver\\chromedriver.exe");
		wd = new ChromeDriver();
		baseURL = "https://learn.letskodeit.com/";
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		wd.get(baseURL);

		wd.findElement(By.xpath("//a[@href='/sign_in']")).click();
		System.out.println("Clicked LOGIN");

		wd.findElement(By.xpath("//input[@id='user_email']")).sendKeys("test@gmail.com");
		System.out.println("Sent keys to User email");

		wd.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Test");
		System.out.println("Sent keys to User password");

		wd.findElement(By.xpath("//input[@id='user_email']")).clear();
		System.out.println("Cleared User email");
	}

	@AfterMethod
	public void tearDown() throws Exception {
	}

}
