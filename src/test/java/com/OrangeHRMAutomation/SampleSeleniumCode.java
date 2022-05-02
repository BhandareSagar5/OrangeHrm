package com.OrangeHRMAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.OrangeHRMPages.LoginPage;
import com.OrangeHRMPages.NewUser;

import CyberSuccess.com.org.BaseClass;

public class SampleSeleniumCode extends BaseClass {

	public static void main(String[] args) {
		LoginPage loginPage= new LoginPage();
		getBrowserInstance("Chrome");
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		loginPage.login("Admin", "admin123");
		
		NewUser user= new NewUser();
	    String firstName = user.addUser();
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.name("empsearch[employee_name][empName]")).sendKeys(firstName);
		driver.findElement(By.id("searchBtn")).click();
	}

}
