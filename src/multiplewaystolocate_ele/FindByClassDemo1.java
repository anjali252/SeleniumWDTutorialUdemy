package multiplewaystolocate_ele;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByClassDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindByIdXPath.disableSeleniumLogs();
		WebDriver wd = new ChromeDriver();
		String baseURL = "https://learn.letskodeit.com/p/practice";
		wd.manage().window().maximize();
		wd.get(baseURL);

		wd.findElement(By.className("btn-style")).click(); // this thing would show up but it actually clicked open
															// window btn
		// reason is open window btn also shares same name obedient state
		// and since it's first btn on pg on DOM that's why it clicks this btn
		// it can find another elements if it matches
	}

}
