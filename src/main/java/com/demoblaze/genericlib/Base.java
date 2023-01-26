package com.demoblaze.genericlib;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.demoblaze.objectrepository.Homepage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
public WebDriver driver;
public FileLibrary fl=new FileLibrary();
public CommonUtil cu=new CommonUtil();
Homepage hp;

@BeforeSuite
public void configBS() throws IOException {
	WebDriverManager.chromedriver().setup();
	WebDriverManager.firefoxdriver().setup();
	if(fl.getDatafromProperties("browser").equals("chrome")){
		driver=new ChromeDriver();
		hp=PageFactory.initElements(driver, Homepage.class);
	}
	if(fl.getDatafromProperties("browser").equals("firefox")){
		driver=new FirefoxDriver();
		hp=PageFactory.initElements(driver, Homepage.class);
	}
	Reporter.log("Successfully Launched the browser");
	driver.get(fl.getDatafromProperties("URL"));
	Reporter.log("Successfully passed the URL");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
@BeforeTest
public void configBT() throws IOException{
	hp.getLogin().click();
	hp.getUsername().sendKeys(fl.getDatafromProperties("username"));
	hp.getPassword().sendKeys(fl.getDatafromProperties("password"));
	hp.getLoginLoginbutton().click();
	Reporter.log("Successfully Logged into the Application");
	cu.waitElementtobeClickable(driver, hp.getNameofuser());
	System.out.println(hp.getNameofuser().getText());
	Assert.assertTrue(hp.getNameofuser().getText().contains(fl.getDatafromProperties("username")));
}
@AfterTest
public void configAT() {
	hp.getLogout().click();
	Assert.assertTrue(hp.getLogin().isDisplayed());
	Reporter.log("Successfully logged out from the Application");
}
@AfterSuite
public void configAS() {
	driver.quit();
	Reporter.log("Successfully Closed the browser");
}

}
