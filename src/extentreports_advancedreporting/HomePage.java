package extentreports_advancedreporting;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage {
	WebDriver driver;
	ExtentTest test;

	public HomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	void clickLoginLink() {
		driver.findElement(By.className("login")).click();
		test.log(LogStatus.INFO, "Clicked on Login Link");
	}

	void enterEmailPassword(String email, String passwd) {
		driver.findElement(By.id("email")).sendKeys(email); // correct email
		test.log(LogStatus.INFO, "Entered email");
		driver.findElement(By.id("passwd")).sendKeys(passwd);
		test.log(LogStatus.INFO, "Entered password");
	}

	void clickLoginButton() {
		driver.findElement(By.id("SubmitLogin")).click();
		test.log(LogStatus.INFO, "Submitted Login Credentials..");
	}

	boolean isAccountNamePresent() {
		String account;
		try {
			account = driver.findElement(By.xpath("//a[@class='account']//span")).getText();
			if (account != null) {
				return true;
			}
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			return false;
		}

		return false;
	}

	public void login(String email, String passwd) {
		clickLoginLink();
		enterEmailPassword(email, passwd);
		clickLoginButton();
	}

}
