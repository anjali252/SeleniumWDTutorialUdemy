package fileuploadandwindowsauthentication;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUploadWindowsAutoIT {
	String url;
	WebDriver driver;

	@Test
	public void f() throws AWTException, InterruptedException, IOException {

		// identify element and click
		WebElement uploadButton = driver.findElement(By.className("browse-text"));
		uploadButton.click();

		Thread.sleep(2000);

		// below line execute the AutoIT script .
		Runtime.getRuntime().exec("E:\\Eclipse-Workspace\\SeleniumWDTutorialUdemy\\scripts\\fileupload.exe");

		Thread.sleep(2000);
	}

	@BeforeClass
	public void beforeClass() {
		url = "https://www.monsterindia.com/seeker/registration?";
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
