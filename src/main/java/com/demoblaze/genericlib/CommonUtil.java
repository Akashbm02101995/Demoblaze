package com.demoblaze.genericlib;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtil {

	public WebElement addPerticularproduct(String product,WebDriver driver) {
		return driver.findElement(By.xpath("//a[text()='"+product+"']"));	
	}
	public void waitAlerttobedisplayed(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void acceptAlert(WebDriver driver) {
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	public void dismissAlert(WebDriver driver) {
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	public void waitElementtobeClickable(WebDriver driver,WebElement e) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	public WebElement verifyProductincart(WebDriver driver,String pn) {
		return driver.findElement(By.xpath("//td[text()='"+pn+"']"));
	}
	
	public void  deleteProduct(WebDriver driver,String product) {
		driver.findElement(By.xpath("//td[text()='"+product+"']/following-sibling::td[2]/a")).click();
	}
}

