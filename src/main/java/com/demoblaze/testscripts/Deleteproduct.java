package com.demoblaze.testscripts;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import com.demoblaze.genericlib.Base;
import com.demoblaze.objectrepository.Cart;
import com.demoblaze.objectrepository.Homepage;

public class Deleteproduct extends Base {
public void deleteProductfromcart() throws IOException {
	Homepage hp=PageFactory.initElements(driver, Homepage.class);
	Cart cart=PageFactory.initElements(driver,Cart.class);
	hp.getCart().click();
	cu.deleteProduct(driver, fl.getDatafromProperties("product"));
}
}
