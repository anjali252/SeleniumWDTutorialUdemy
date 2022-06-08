package handlesynchronizeissue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitDemo {

	WebDriver wd;
	String baseURL;

	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Driver\\chromedriver.exe");
		wd = new ChromeDriver();
		baseURL = "https://learn.letskodeit.com/";

		wd.manage().window().maximize();
		wd.get(baseURL);

	}

	@Test
	public void test() {

		wd.findElement(By.xpath("//a[@href='/sign_in']")).click();
		WebDriverWait wait = new WebDriverWait(wd, 3);
		WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
		email.sendKeys("letskodeit@gmail.com");

	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		wd.quit();
	}

}
