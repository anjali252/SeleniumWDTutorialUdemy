package handlesynchronizeissue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitDemp {
	WebDriver wd;
	String baseURL;
	@Before
	public void setUp() throws Exception {
		wd = new ChromeDriver();
		baseURL = "https://learn.letskodeit.com/";

		wd.get(baseURL);
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		wd.findElement(By.xpath("//a[@href='/sign_in']")).click();
		wd.findElement(By.xpath("//input[@id='user_email']")).sendKeys("letskodeit@gmail.com");
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		wd.quit();
	}


}
