package multiplewaystolocate_ele;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigatingBwPages {

	WebDriver wd;
	String baseURL;

	@BeforeMethod
	public void setUp() throws Exception {
		FindByIdXPath.disableSeleniumLogs();
		wd = new ChromeDriver();
		baseURL = "https://learn.letskodeit.com/";
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void test() throws InterruptedException {
		wd.get(baseURL);

		String title = wd.getTitle();
		System.out.println("Title= " + title);

		String currentURL = wd.getCurrentUrl();
		System.out.println("Current URL = " + currentURL);

		String urlToNavigate = "https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1";
		wd.navigate().to(urlToNavigate);

		currentURL = wd.getCurrentUrl();
		System.out.println("Current URL = " + currentURL);

		Thread.sleep(2000);

		wd.navigate().back();
		currentURL = wd.getCurrentUrl();
		System.out.println("Current URL = " + currentURL);

		Thread.sleep(2000);

		wd.navigate().forward();
		currentURL = wd.getCurrentUrl();
		System.out.println("Current URL = " + currentURL);

		wd.navigate().refresh();
		currentURL = wd.getCurrentUrl();
		System.out.println("Current URL = " + currentURL);

		String pgSrc = wd.getPageSource();
		System.out.println("Pg SRc=" + pgSrc);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		wd.quit();
	}
}
