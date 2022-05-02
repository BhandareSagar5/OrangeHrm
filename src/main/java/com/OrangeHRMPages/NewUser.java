package com.OrangeHRMPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CyberSuccess.com.org.BaseClass;

public class NewUser extends BaseClass {
	
	private By pim = By.id("menu_pim_viewPimModule");
	private By firstName = By.id("firstName");
	private By addBtn = By.name("btnAdd");
	private By lastName = By.id("lastName");
	private By checkboxLogin = By.id("chkLogin");
	private By username = By.id("user_name");
	private By password = By.id("user_password");
	private By re_password = By.id("re_password");
	private By saveBtn = By.id("btnSave");
	private By dashboard = By.id("menu_dashboard_index");
	
	public String addUser() {
		driver.findElement(pim).click();
	
		driver.findElement(addBtn).click();
		String firstName = generateRandomString(10);
		driver.findElement(this.firstName).sendKeys(firstName);
		
		String lastName = generateRandomString(12);
		driver.findElement(this.lastName).sendKeys(lastName);
		
		driver.findElement(checkboxLogin).click();
		
		String userName = generateRandomString(15);
		driver.findElement(username).sendKeys(userName);
		String password = "Password@123";
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(re_password).sendKeys(password);
		driver.findElement(saveBtn).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(dashboard)));
		driver.findElement(dashboard).click();
		
		
		return userName;
	}
}
