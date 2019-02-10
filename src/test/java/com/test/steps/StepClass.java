package com.test.steps;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.page.PageClass;
import com.util.Conversion;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepClass{
	
	WebDriver driver;

	
	@Before
	public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
	}

	@After
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
	
	
	@Given("User can go to values page")
	public void gotoValuesURL() {
        driver.get("https://www.excercise1.com/values");
	}
	
	@And("User can see all the values")
	public void canSeeAllValues() {
		PageClass page = new PageClass(driver);
		for (int i=1 ; i<=5 ; i++) {
			Assert.assertTrue(page.getTitle(i).isDisplayed());
			Assert.assertTrue(page.getValue(i).isDisplayed());
		}
	}
	
	@Then("verify the value of entry {int} is {string}")
	public void validateValue(Integer no, String value) {
		PageClass page = new PageClass(driver);
	    Assert.assertEquals(page.getValue(no).getText(), value);
	}
	
	@Then ("verify all values are greater then zero")
	public void validateValueGreaterThenZero() {
		PageClass page = new PageClass(driver);
		for(int i=1; i<=5; i++) {
			Assert.assertTrue(Conversion.currencyToDouble(page.getValue(i).getText())>0);
		}
		
	}
	
	@Then ("Sum of all value should match the total value") 
	public void addToGetTotalBalance() {
		PageClass page = new PageClass(driver);
		double totalBalance = 0;
		for(int i=1; i<=5; i++) {
			totalBalance = totalBalance + Conversion.currencyToDouble(page.getValueOf(i));
		}
		Assert.assertEquals(Conversion.currencyToDouble(page.getTotalBalance().getText()), 
				totalBalance);
	}
	
	
	@Then ("All values should be in currency format")
	public void validateCurrencyFormate() {
		PageClass page = new PageClass(driver);
		for (int i = 1; i<=5 ; i++) {
			Assert.assertTrue(Conversion.isCurrency(page.getValueOf(i)));
		}
		Conversion.isCurrency(page.getTotalBalance().getText());
	}

}
