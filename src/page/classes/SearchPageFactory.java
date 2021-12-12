package page.classes;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageFactory {

	WebDriver wd;

	@FindBy(id = "FromTag")
	WebElement fromBox;

	@FindBy(id = "ToTag")
	WebElement toBox;

	@FindBy(id = "DepartDate")
	WebElement departDateBox;

	@FindBy(id = "SearchBtn")
	WebElement searchBtn;

	public void setSrcTextBox(String from) {
		fromBox.sendKeys(from);
		;
	}

	public void setDestTextBox(String to) {
		toBox.sendKeys(to);
	}

	public void setDepartureCalender(String departDate) {
		departDateBox.sendKeys(departDate);
	}

	public void clickSearchBtn() {
		JavascriptExecutor js = (JavascriptExecutor) wd;
		js.executeScript("arguments[0].click()", searchBtn);

	}

	public SearchPageFactory(WebDriver wd) {
		this.wd = wd;
		PageFactory.initElements(wd, this);
	}
	
}
