package page.classes;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPageFactory {

	WebDriver wd;

	@FindBy(xpath = "//h4[contains(text(),'From')]//parent::div//input")
	WebElement fromBox;

	@FindBy(xpath = "//h4[contains(text(),'To')]//parent::div//input")
	WebElement toBox;

	@FindBy(xpath = "(//h4[contains(text(),'Depart')]//ancestor::div//button)[4]")
	WebElement departDateBox;

	@FindBy(xpath = "(//div[contains(@class,'td-none')]//ancestor::div)[8]//following-sibling::div//button")
	WebElement searchBtn;

	@FindBy(xpath = "(//div[@class='DayPicker-Caption'])[1]")
	WebElement monthOnLeftSide;

	@FindBy(xpath = "(//div[@class='DayPicker-Caption'])[2]")
	WebElement monthOnRightSide;

	@FindBy(xpath = "//div[contains(@class,'right')]//*[@fill='currentColor']")
	WebElement nextArrow;

	@FindBy(xpath = "((//div[@class='DayPicker-Body'])[2]//div[@class='DayPicker-Day'])")
	List<WebElement> date;

	@FindBy(xpath = "//div[contains(text(),'Suggestions')]//parent::ul//p")
	WebElement citySuggestion;

	@FindBy(xpath = "//div[contains(@class,'bg-white br-4 br-4')]")
	WebElement loginBox;

	@FindBy(xpath = "(//div[contains(@class,'bg-white br-4 br-4')]//div)[5]")
	WebElement closeLoginBox;

	public void setSrcTextBox(String from) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(wd, 10);
		wait.until(ExpectedConditions.elementToBeClickable(fromBox));
		fromBox.sendKeys(from);
	}

	public void setDestTextBox(String to) throws InterruptedException {
		toBox.sendKeys(to);
	}

	public void setDepartureCalender(String departDate) {
		departDateBox.click();
		String[] splited = departDate.split("\\s+");
		if (!monthOnLeftSide.getText().contains(splited[1])) {
			while (!monthOnRightSide.getText().contains(splited[1])) {
				System.out.println(monthOnRightSide.getText() + " isn't desired month");
				nextArrow.click();
				System.out.println("Next arrow clicked to search for desired month");
			}

			if (monthOnRightSide.getText().contains(splited[1])) {
				System.out.println(monthOnRightSide.getText() + " is desired month");
				for (WebElement ele : date) {
					if (ele.getText().equals(splited[2])) {
						System.out.println(ele.getText() + " is desired date");
						ele.click();
					}
				}
			}
		}
	}

	public void clickSearchBtn() {
		WebDriverWait wait = new WebDriverWait(wd, 30);
		wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
		searchBtn.click();
	}

	public SearchPageFactory(WebDriver wd) {
		this.wd = wd;
		PageFactory.initElements(wd, this);
	}

	public void clickCitySuggestion() {
		citySuggestion.click();
	}

	public boolean checkLoginBoxPresence() {
		boolean isAlertBoxPresent = false;
		try {
			if (loginBox.isDisplayed()) {
				isAlertBoxPresent = true;
			}
		} catch (Exception e) {
			System.out.println("No Login Box Displayed");
		}
		return isAlertBoxPresent;
	}

	public void closeLoginBox() {
		closeLoginBox.click();
	}

}
