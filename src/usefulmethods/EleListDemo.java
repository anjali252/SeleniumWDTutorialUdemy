package usefulmethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EleListDemo {

	WebDriver wd;
	String baseURL;
	GenericMethodsOld gm;

	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Driver\\chromedriver.exe");
		wd = new ChromeDriver();
		baseURL = "https://learn.letskodeit.com/p/practice";
		gm = new GenericMethodsOld(wd);

		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		wd.get(baseURL);
	}

	@Test
	public void test() {
		List<WebElement> list = gm.getEleList("//input[@type='text']", "xpath");
		int size = list.size();
		System.out.println("Size of Ele List = " + size);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
	}

}
