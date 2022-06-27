package com.iNetBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (name="uid")
	private WebElement uip;
	public WebElement getUip() {
		return uip;
	}
	public void enteruid(String name)
	{
		uip.sendKeys(name);
	}
	
	@FindBy (name="password")
	private WebElement pwd;
	public WebElement getpwd() {
		return pwd;
	}
	public void enterpwd(String password) 
	{
		pwd.sendKeys(password);
	}
	
	@FindBy (name="btnLogin")
	private WebElement btn;
	public WebElement getbtn() {
		return btn;
	}
	public void clickbtn() 
	{
		btn.click();
	}
	
	
}
