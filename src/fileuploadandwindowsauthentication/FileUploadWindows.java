package fileuploadandwindowsauthentication;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUploadWindows {
	String url;
	WebDriver driver;

	@Test
	public void f() throws AWTException, InterruptedException {
		// file path passed as parameter to StringSelection
		StringSelection s = new StringSelection("E:\\Eclipse-Workspace\\SeleniumWDTutorialUdemy\\StudentFile.txt");
		// Clipboard copy
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);

		// identify element and click
		WebElement uploadButton = driver.findElement(By.className("browse-text"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", uploadButton);

		// Robot object creation
		Robot r = new Robot();
		// pressing enter
		r.keyPress(KeyEvent.VK_ENTER);
		// releasing enter
		r.keyRelease(KeyEvent.VK_ENTER);
		// pressing ctrl+v
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		// releasing ctrl+v
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		Thread.sleep(2000);
		// pressing enter
		r.keyPress(KeyEvent.VK_ENTER);
		// releasing enter
		r.keyRelease(KeyEvent.VK_ENTER);
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
//		driver.quit();
	}

}
