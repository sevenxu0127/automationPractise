package automationpractice.com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Utils;

public class CreateAccountForm {
	
	private final WebDriver driver;
	
	public CreateAccountForm(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement successfullyCreatedAccount() {
		return Utils.waitForElementPresence(driver, By.xpath("//p[contains(text(), \"Welcome to your account.\")]"), 30);
	}
	
}
