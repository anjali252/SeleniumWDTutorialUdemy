package multiplewaystolocate_ele;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioBtnCheckBox {
	WebDriver wd;
	String baseURL;

	@BeforeMethod
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
		WebElement bmwradio = wd.findElement(By.id("bmwradio"));
		bmwradio.click();

		Thread.sleep(2000);

		WebElement benzradio = wd.findElement(By.id("benzradio"));
		benzradio.click();

		WebElement bmwchk = wd.findElement(By.id("bmwcheck"));
		bmwchk.click();

		Thread.sleep(2000);

		WebElement benzchk = wd.findElement(By.id("benzcheck"));
		benzchk.click();

		System.out.println("BMW Radio Btn is selected? " + bmwradio.isSelected());
		System.out.println("Benz Radio Btn is selected? " + benzradio.isSelected());
		System.out.println("BMW Check Box is selected? " + bmwchk.isSelected());
		System.out.println("Benz Check Box is selected? " + benzchk.isSelected());

	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		wd.quit();
	}


}
