package workingwithactionsclass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderActions {

	WebDriver wd;
	String baseURL;
	JavascriptExecutor jse;

	@BeforeMethod
	public void setUp() throws Exception {

		wd = new ChromeDriver();
		baseURL = "https://jqueryui.com/slider/";

		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wd.get(baseURL);
	}

	@Test
	public void test1() throws InterruptedException {

		wd.switchTo().frame(0);

		Thread.sleep(2000);

		WebElement ele = wd.findElement(By.xpath("//div[@id='slider']/span"));

		Actions a = new Actions(wd);
		a.dragAndDropBy(ele, 100, 0).perform();

	}

	@AfterMethod
	public void tearDown() throws Exception {

		Thread.sleep(2000);
		wd.quit();
	}
}
