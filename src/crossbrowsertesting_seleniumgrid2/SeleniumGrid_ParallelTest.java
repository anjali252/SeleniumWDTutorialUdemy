package crossbrowsertesting_seleniumgrid2;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.classes.SearchPageFactory;

public class SeleniumGrid_ParallelTest {

	public WebDriver wd;
	public String baseURL, nodeURL;
	SearchPageFactory spf;

	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Driver\\chromedriver.exe");

		baseURL = "https://www.cleartrip.com/";
		nodeURL = "http://192.168.43.53:4444/wd/hub";

		System.out.println("Chrome Browser Initiated");
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		options.addArguments("disable-infobars");
		caps.setBrowserName("chrome");
		caps.setPlatform(Platform.WINDOWS);

		wd = new RemoteWebDriver(new URL(nodeURL), caps);
		spf = new SearchPageFactory(wd);

		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.get(baseURL);

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
		Thread.sleep(3000);
		wd.quit();
	}
}
