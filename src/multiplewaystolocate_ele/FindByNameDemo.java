package multiplewaystolocate_ele;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByNameDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindByIdXPath.disableSeleniumLogs();
		WebDriver wd = new ChromeDriver();
		String baseURL = "https://learn.letskodeit.com/p/practice";
		wd.manage().window().maximize();
		wd.get(baseURL);

		wd.findElement(By.name("enter-name")).sendKeys("Automation");
	}

}
