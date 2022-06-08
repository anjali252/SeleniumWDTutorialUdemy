// It's suggested not using this as it has limitations to work only on Windows.
// we should try to use Robot Class 

package fileuploadandwindowsauthentication;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsAuthentication {
	private String url;
	private WebDriver driver;

	@Test
	public void f() throws IOException, InterruptedException {
		driver.get(url);
//		Thread.sleep(2000);
		Runtime.getRuntime().exec("E:\\Eclipse-Workspace\\SeleniumWDTutorialUdemy\\scripts\\WindowAuthentication2.exe");
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}

	@BeforeMethod
	public void beforeMethod() {
		url = "http://the-internet.herokuapp.com/basic_auth";
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
	}

}
