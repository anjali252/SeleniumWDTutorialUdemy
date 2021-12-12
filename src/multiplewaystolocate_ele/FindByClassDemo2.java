package multiplewaystolocate_ele;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByClassDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindByIdXPath.disableSeleniumLogs();
		WebDriver wd = new ChromeDriver();
		String baseURL = "https://www.facebook.com";
		wd.manage().window().maximize();
		wd.get(baseURL);

		wd.findElement(By.className("inputtext")).sendKeys("Automation");
		wd.findElement(By.className("uiButtonConfirm")).click();
		// It typed Automation in email and clicked on Login btn
		// since there's no pwd and Automation isn't a valid email
		// it brought us to new page means Login clicked successfully
	}


}
