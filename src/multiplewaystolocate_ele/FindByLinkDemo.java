package multiplewaystolocate_ele;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByLinkDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		FindByIdXPath.disableSeleniumLogs();
		WebDriver wd = new ChromeDriver();
		String baseURL = "https://learn.letskodeit.com/";
		wd.manage().window().maximize();
		wd.get(baseURL);

		wd.findElement(By.linkText("Practice")).click();
		Thread.sleep(3000);
		wd.findElement(By.partialLinkText("Log")).click();
	}

}
