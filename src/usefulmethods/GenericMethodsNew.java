package usefulmethods;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericMethodsNew {
	WebDriver wd;

	public GenericMethodsNew(WebDriver wd) {
		this.wd = wd;
	}

	public List<WebElement> getEleList(String locator, String type) {
		type = type.toLowerCase();
		List <WebElement> list = new ArrayList<WebElement>();
		if (type.equals("id")) {
			list= wd.findElements(By.id(locator));
		}
		else if (type.equals("xpath")) {
			list= wd.findElements(By.xpath(locator));
		}
		else if (type.equals("css")) {
			list= wd.findElements(By.cssSelector(locator));
		}
		else if (type.equals("linktext")) {
			list= wd.findElements(By.linkText(locator));
		} 
		else if (type.equals("xpath")) {
			list= wd.findElements(By.partialLinkText(locator));
		}
		else {
			System.out.println("Locator type not supported");
		}
		if(list.isEmpty())
			System.out.println("Ele not found with "+type+" = "+locator);
		else 
			System.out.println("Ele found with "+type+" = "+locator);
		return list;
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
