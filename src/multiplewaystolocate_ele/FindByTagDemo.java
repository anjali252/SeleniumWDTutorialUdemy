package multiplewaystolocate_ele;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByTagDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindByIdXPath.disableSeleniumLogs();
		WebDriver wd = new ChromeDriver();
		String baseURL = "https://demostore.x-cart.com/";
		wd.manage().window().maximize();
		wd.get(baseURL);

//		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wd.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		// new WebDriverWait(wd,
		// 20).until(ExpectedConditions.elementToBeClickable(By.tagName("a"))).click();
		wd.findElement(By.tagName("a")).click(); // unpredictable to use tag name


	}

}
