package page.classes;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameWorkTC {

	public WebDriver wd;
	public String baseURL;
	SearchPageFactory spf;

	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Driver\\chromedriver.exe");
		wd = new ChromeDriver();

		baseURL = "https://www.cleartrip.com/";

		spf = new SearchPageFactory(wd);

		wd.get(baseURL);
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		if (spf.checkLoginBoxPresence()) {
			spf.closeLoginBox();
		}
		spf.setSrcTextBox("New Delhi");
		Thread.sleep(3000);
		spf.clickCitySuggestion();
		spf.setDestTextBox("New York");
		Thread.sleep(3000);
		spf.clickCitySuggestion();
		spf.setDepartureCalender("Fri, Sep 30");
		spf.clickSearchBtn();
	}

	@AfterMethod
	public void tearDown() throws Exception {
//		Thread.sleep(3000);
//		wd.quit();
	}

}
