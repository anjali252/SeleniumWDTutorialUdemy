package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	public static WebElement we = null;

	public static void navigateFlight_Tab(WebDriver wd) {
		we = wd.findElement(By.cssSelector("nav.hasProductIcons a[href='/flights']"));
		we.click();
	}

	public static WebElement from(WebDriver wd) {
		we = wd.findElement(By.id("FromTag"));
		return we;
	}

	public static void fillFrom(WebDriver wd, String src) {
		we = from(wd);
		we.sendKeys(src);
	}

	public static WebElement to(WebDriver wd) {
		we = wd.findElement(By.id("ToTag"));
		return we;
	}

	public static void fillTo(WebDriver wd, String dest) {
		we = to(wd);
		we.sendKeys(dest);
	}

	public static WebElement departDate(WebDriver wd) {
		we = wd.findElement(By.id("DepartDate"));
		return we;
	}

	public static void fillDepartDate(WebDriver wd, String deptDate) {
		we = departDate(wd);
		we.sendKeys(deptDate);
	}

	public static WebElement searchBtn(WebDriver wd) {
		we = wd.findElement(By.id("SearchBtn"));

		return we;
	}

	public static void clickSearchBtn(WebDriver wd) {
		JavascriptExecutor js = (JavascriptExecutor) wd;
		we = searchBtn(wd);
		js.executeScript("arguments[0].click()", we);
	}

}
