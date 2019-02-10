package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageClass {
	WebDriver driver;
	
	public PageClass(WebDriver driver) {
		this.driver = driver;		
	}
	
	By tatalBalance = By.id("txt_ttl_val");
	
	private By getTitleBy(int titleNo) {
		return By.id("lbl_val_"+titleNo);
	}
	
	private By getValueBy(int valueNo) {
		return By.id("txt_val_"+valueNo);
	}
	
	public WebElement getTitle(int titleNo) {
		return driver.findElement(getTitleBy(titleNo));
	}
	
	public WebElement getValue(int valueNo) {
		return driver.findElement(getValueBy(valueNo));
	}
	
	public WebElement getTotalBalance() {
		return driver.findElement(tatalBalance);
	}
	
	public String getValueOf(int valueNo) {
		return getValue(valueNo).getText();
	}
	
}
