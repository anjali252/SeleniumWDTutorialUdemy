package handlesynchronizeissue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {

	WebDriver wd;
	String baseURL;
	@Before
	public void setUp() throws Exception {

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

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		wd.quit();
	}

}
