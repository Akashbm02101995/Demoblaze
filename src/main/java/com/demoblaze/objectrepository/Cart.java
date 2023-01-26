package com.demoblaze.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart {
  @FindBy(xpath="//a[text()='Add to cart']")
  private WebElement addtocart;
  
 
public WebElement getAddtocart() {
	return addtocart;
	
	
}
}
