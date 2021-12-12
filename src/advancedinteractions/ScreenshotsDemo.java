package advancedinteractions;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotsDemo {

	WebDriver wd;
	String baseURL;

	@Before
	public void setUp() throws Exception {

		wd = new ChromeDriver();
		baseURL = "https://www.facebook.com/";

		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testSS() throws InterruptedException {
		wd.get(baseURL);
		WebElement login = wd.findElement(By.xpath("//input[@data-testid='royal_login_button']"));
		// input[@data-testid='royal_login_button']
		login.click();
	}

	@After
	public void tearDown() throws Exception {
		String file = getRandomString(10) + ".png";
		String dir = System.getProperty("user.dir") + "//screenshots//";// gets project dir loc
		File src = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE); // takes ss
		FileUtils.copyFile(src, new File(dir + file)); // Apache Common IO jars is needed for this line

		// Thread.sleep(3000);
		// wd.quit();
	}

	public static String getRandomString(int len) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for (int i = 0; i < len; i++) {
			int index = (int) (Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}


}
