package handlesynchronizeissue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {

	WebDriver wd;

	public WaitTypes(WebDriver wd) {
		this.wd = wd;
	}

	public WebElement waitForEle(By locator, int timeout) {
		WebElement we = null;
		try {

			System.out.println("Waiting for max:: " + timeout + " seconds for the ele to be available");
			WebDriverWait wait = new WebDriverWait(wd, timeout);
			we = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			System.out.println("Ele appeared on the web page");
		} catch (Exception e) {
			System.out.println("Ele not appeared on the web page");
		}
		return we;

	}

	public void clickWhenReady(By locator, int timeout) {

		try {

			WebElement we = null;
			System.out.println("Waiting for max:: " + timeout + " seconds for the ele to be clickable");
			WebDriverWait wait = new WebDriverWait(wd, timeout);
			we = wait.until(ExpectedConditions.elementToBeClickable(locator));
			we.click();
			System.out.println("Ele clicked on the web page");
		} catch (Exception e) {
			System.out.println("Ele not appeared on the web page");
		}
	}
}
