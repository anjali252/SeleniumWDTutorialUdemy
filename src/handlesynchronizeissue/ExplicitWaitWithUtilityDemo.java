package handlesynchronizeissue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExplicitWaitWithUtilityDemo {

	WebDriver wd;
	String baseURL;
	WaitTypes wt;

	@BeforeMethod
	public void setUp() throws Exception {

		wd = new ChromeDriver();
		baseURL = "https://learn.letskodeit.com/";
		wt = new WaitTypes(wd);

		wd.manage().window().maximize();

	}

	@Test
	public void test() {

		wd.get(baseURL);
		WebElement login = wd.findElement(By.xpath("//a[@href='/sign_in']"));
		login.click();
		WebElement email = wt.waitForEle(By.id("user_email"), 3);
		email.sendKeys("letskodeit@gmail.com");
		wt.clickWhenReady(By.name("commit"), 3);
	}

	@AfterMethod
	public void tearDown() throws Exception {

		// Thread.sleep(3000);
		// wd.quit();
	}
}

