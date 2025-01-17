package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {
	private WebDriver driver;

	private By subjectHeading = By.id("id_contact");
	private By email = By.id("email");
	private By orderRef = By.id("id_order");
	private By sendBtn = By.id("submitMessage");
	private By succMsg = By.cssSelector("div#center_column p");
	private By message = By.id("message");

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getContactusPageTitle() {
		return driver.getTitle();
	}

	public void clickOnSendButton() {
		driver.findElement(sendBtn).click();
	}

	public String successfulMessage() {
		return driver.findElement(succMsg).getText();
	}

	public void fillcontactForm(String emailid, String orderref, String messageText, String heading) {
		Select select = new Select(driver.findElement(subjectHeading));
		select.selectByVisibleText(heading);
		driver.findElement(email).sendKeys(emailid);
		driver.findElement(orderRef).sendKeys(orderref);
		driver.findElement(message).sendKeys(messageText);

	}

}
