package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.UtilTestBaseFramework.utils;

public class CommonFunctions {
	private static utils Utils;
	private WebDriver driver;
	//Find by locators
	
	@FindBy(xpath = "//input[@id='MainContent_txtPIN']")
	WebElement pintextField;
	
	@FindBy(xpath = "//input[@id='MainContent_txtPassword']")
	WebElement passwordTextField;
	
	@FindBy(xpath = "//input[@id='//a[@id='MainContent_btnLogin']")
	WebElement loginButton;
	
	// constructor of the page class
	public CommonFunctions() {
		PageFactory.initElements(driver, this);
		this.Utils = new utils();
	}
	
	// Page Actions scripts 
	
	public void loginInTotheApplication(String pinid, String password ) throws Throwable {
		utils.BrowserTest.sleep(3000);
		pintextField.sendKeys(pinid);
		utils.BrowserTest.sleep(3000);
		passwordTextField.sendKeys(password);
		utils.BrowserTest.sleep(3000);
		utils.clickFunction(loginButton);
		
		
		
		 
	}

}
