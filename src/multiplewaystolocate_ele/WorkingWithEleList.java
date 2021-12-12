package multiplewaystolocate_ele;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithEleList {
	WebDriver wd;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		FindByIdXPath.disableSeleniumLogs();
		wd = new ChromeDriver();
		baseURL = "https://learn.letskodeit.com/p/practice";
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.get(baseURL);
	}

	@Test
	public void test() throws InterruptedException {
		boolean isChkd = false;
		List<WebElement> radiobtn = wd
//				.findElements(By.xpath("//input[contains(@type,'radio' ) and contains(@name,'cars')]"));

				.findElements(By.xpath("//input[@name='cars']"));
		// it's selecting radio btns first and then it went to drop down as well then
		// selecting chk box
		int size = radiobtn.size();
		System.out.println("Size of List of RadioBtn = " + size);

		for (int i = 0; i < size; i++) {
			isChkd = radiobtn.get(i).isSelected();

			if (!isChkd) {
				radiobtn.get(i).click();
				Thread.sleep(2000);
			}
		}
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		wd.quit();
	}


}
