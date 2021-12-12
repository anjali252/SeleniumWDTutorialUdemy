package multiplewaystolocate_ele;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class FindByIdXPath {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		disableSeleniumLogs();
		WebDriver wd= new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String baseURL="https://learn.letskodeit.com/";
		wd.manage().window().maximize();
		wd.get(baseURL);

		// Passing locator so that webdriver will be able to locate web element
		// WebElement login
		wd.findElement(By.xpath("//a[@href='/sign_in']")).click();
				
		//IdXPATHDemo
		wd.findElement(By.xpath("//input[@id='user_email']")).sendKeys("letskodeit@gmail.com");
	}
	// this method is to avoid Timed out receiving message from renderer - disable Selenium logs
	public static void disableSeleniumLogs() {    
	    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
	    Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
	}

}
