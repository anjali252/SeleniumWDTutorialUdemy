package page.classes;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameWorkTC {

	public WebDriver wd;
	public String baseURL;
	SearchPageFactory spf;

	@Before
	public void setUp() throws Exception {
		wd = new ChromeDriver();

		baseURL = "https://www.cleartrip.com/";

		spf = new SearchPageFactory(wd);

		wd.get(baseURL);
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		spf.setSrcTextBox("New Delhi");
		spf.setDestTextBox("New York");
		spf.setDepartureCalender("Wed, 30 Sep, 2020");
		spf.clickSearchBtn();
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		wd.quit();
	}

}
