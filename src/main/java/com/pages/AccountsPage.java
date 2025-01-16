package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;
	
	private By accountsList = By.cssSelector("div#center_column span");
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getAccountPageTitle() {
		return driver.getTitle();
	}
	
	public int getAccountsListCount() {
		return driver.findElements(accountsList).size();
	}
	
	public List<String> getAccountSectionList() {
		List<String> accountList = new ArrayList<String>();
		List<WebElement> accountHeaderList = driver.findElements(accountsList);
		
		for(WebElement e: accountHeaderList) {
			String text = e.getText();
			System.out.println(text);
			accountList.add(text);
		}
		
		return accountList;
	}
}
