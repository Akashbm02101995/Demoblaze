package com.demoblaze.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {

	@FindBy(xpath="//a[text()='Log in']")
	private WebElement login;
	
	@FindBy(id="loginusername")
	private WebElement username;
	
	@FindBy(id="loginpassword")
	private WebElement password;
	
	@FindBy(xpath="//button[text()='Log in']")
	private WebElement loginLoginbutton;
	
	@FindBy(id="nameofuser")
	private WebElement nameofuser;
	
	@FindBy(xpath="//a[text()='Log out']")
	private WebElement logout;
	
	@FindBy(xpath="//a[text()='Cart']")
	private WebElement cart;
	
	
	
	
	public WebElement getCart() {
		return cart;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginLoginbutton() {
		return loginLoginbutton;
	}

	public WebElement getNameofuser() {
		return nameofuser;
	}

	public WebElement getLogout() {
		return logout;
	}
	
	
}
