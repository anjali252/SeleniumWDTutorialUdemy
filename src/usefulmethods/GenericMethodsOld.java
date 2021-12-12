package usefulmethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericMethodsOld {

	WebDriver wd;

	public GenericMethodsOld(WebDriver wd) {
		this.wd = wd;
	}

	public WebElement getEle(String locator, String type) {
		type = type.toLowerCase();
		if (type.equals("id")) {
			System.out.println("Element found with id = " + locator);
			return wd.findElement(By.id(locator));
		} else if (type.equals("xpath")) {
			System.out.println("Element found with xpath = " + locator);
			return wd.findElement(By.xpath(locator));
		} else if (type.equals("css")) {
			System.out.println("Element found with css = " + locator);
			return wd.findElement(By.cssSelector(locator));
		} else if (type.equals("linktext")) {
			System.out.println("Element found with link text = " + locator);
			return wd.findElement(By.linkText(locator));
		} else if (type.equals("xpath")) {
			System.out.println("Element found with xpath = " + locator);
			return wd.findElement(By.partialLinkText(locator));
		} else {
			System.out.println("Locator type not supported");
			return null;
		}
		}

	public List<WebElement> getEleList(String locator, String type) {
		type = type.toLowerCase();
		if (type.equals("id")) {
			System.out.println("Element found with id = " + locator);
			return wd.findElements(By.id(locator));
		} else if (type.equals("xpath")) {
			System.out.println("Element found with xpath = " + locator);
			return wd.findElements(By.xpath(locator));
		} else if (type.equals("css")) {
			System.out.println("Element found with css = " + locator);
			return wd.findElements(By.cssSelector(locator));
		} else if (type.equals("linktext")) {
			System.out.println("Element found with link text = " + locator);
			return wd.findElements(By.linkText(locator));
		} else if (type.equals("xpath")) {
			System.out.println("Element found with xpath = " + locator);
			return wd.findElements(By.partialLinkText(locator));
		} else {
			System.out.println("Locator type not supported");
			return null;
		}
		}

	public boolean isPresent(String locator, String type) {
		List<WebElement> list = getEleList(locator, type);
		int size = list.size();
		if (size > 0)
			return true;
		else
			return false;
	}
}
