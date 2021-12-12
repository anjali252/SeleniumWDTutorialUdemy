package page.classes;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PageObjModel {

	public WebDriver wd;
	public String baseURL;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver",
				"E:\\Selenium_Webdriver_Environment_Setup\\Browser_Driver\\chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		wd = new ChromeDriver(options);

		baseURL = "https://www.cleartrip.com/";

		wd.get(baseURL);
		wd.manage().deleteAllCookies();
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() {

		SearchPage.navigateFlight_Tab(wd);

		SearchPage.fillFrom(wd, "New Delhi");

		SearchPage.fillTo(wd, "New York");

		SearchPage.fillDepartDate(wd, "Wed, 30 Sep, 2020");

		SearchPage.clickSearchBtn(wd);

	}

	@After
	public void tearDown() throws Exception {
		// Thread.sleep(3000);
		// wd.quit();
	}
}

