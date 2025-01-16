package com.pages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver ;
	
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signBtn = By.id("SubmitLogin");
	private By forgotPass = By.xpath("//a[text()='Forgot your password?']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean forgotPassLinkDisplayed() {
		return driver.findElement(forgotPass).isDisplayed();
	}
	
	public void enterUsername(String un) {
		driver.findElement(emailId).sendKeys(un);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickLogin() {
		driver.findElement(signBtn).click();
	}
	
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signBtn).click();
		return new AccountsPage(driver);
	}

}
