/**
 * 
 */
package page.classes;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author Anji
 *
 */
public class FindLinks {
	public static WebDriver wd;
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
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testFindLinks() {
		SearchPage.navigateFlight_Tab(wd);

		List<WebElement> linksList = clickableLinks(wd);

		for (WebElement i : linksList) {
			String href = i.getAttribute("href");
			try {
				System.out.println("URL " + href + " returned " + linkStatus(new URL(href)));
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public static List<WebElement> clickableLinks(WebDriver wd2) {
		List<WebElement> linksToClick = new ArrayList<WebElement>();
		List<WebElement> ele = wd.findElements(By.tagName("a"));
		ele.addAll(wd.findElements(By.tagName("img")));

		for (WebElement i : ele) {
			if (i.getAttribute("href") != null) {
				linksToClick.add(i);
			}
		}

		return linksToClick;
	}

	public static String linkStatus(URL url) {
		try {
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.connect();
			String responseMsg = http.getResponseMessage();
			http.disconnect();
			return responseMsg;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@After
	public void tearDown() throws Exception {
		// Thread.sleep(3000);
		// wd.quit();
	}

}
