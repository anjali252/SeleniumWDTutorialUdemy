package usefulmethods;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsElePresent {

	WebDriver wd;
	String baseURL;
	GenericMethodsNew gm;

	@Before
	public void setUp() throws Exception {
		wd = new ChromeDriver();
		baseURL = "https://learn.letskodeit.com/p/practice";
		gm = new GenericMethodsNew(wd);

		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		wd.get(baseURL);
	}

	@Test
	public void test() {
		boolean result1 = gm.isPresent("name", "id");
		System.out.println("Is ELe present?  " + result1);
		boolean result2 = gm.isPresent("name_1q_m0", "id");
		System.out.println("Is ELe present?  " + result2);
		System.out.println(wd.findElement(By.id("name")).getAttribute("innerHTML"));
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		wd.quit();
	}


}
