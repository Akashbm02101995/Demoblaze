package com.demoblaze.testscripts;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.demoblaze.genericlib.Base;
import com.demoblaze.objectrepository.Cart;
import com.demoblaze.objectrepository.Homepage;

public class Addtocart extends Base {
@Test
public void addtocartTest() throws IOException {
	Homepage hp=PageFactory.initElements(driver, Homepage.class);
	Cart cart=PageFactory.initElements(driver, Cart.class);
	String pn=cu.addPerticularproduct(fl.getDatafromProperties("product"), driver).getText();
	cu.addPerticularproduct(fl.getDatafromProperties("product"), driver).click();
	cart.getAddtocart().click();
	cu.waitAlerttobedisplayed(driver);
	cu.acceptAlert(driver);
	hp.getCart().click();
	Assert.assertTrue(cu.verifyProductincart(driver, pn).isDisplayed());
	Reporter.log("Successfully Added the product to cart");
}
}
