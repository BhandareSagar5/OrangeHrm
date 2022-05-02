package com.OrangeHRMPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CyberSuccess.com.org.BaseClass;

public class LoginPage extends BaseClass {
	
	private By username = By.id("txtUsername");
	private By password = By.id("txtPassword");
	private By loginBtn = By.id("btnLogin");
	private By welcome = By.id("welcome");
	private By logoutBtn = By.xpath("//div[@id='welcome-menu']/ul/li[3]/a");
	
	public void login(String username, String password) {
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(loginBtn).submit();
	}
	
	public void logout() {
		driver.findElement(welcome).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(logoutBtn)));
		driver.findElement(logoutBtn).click();
	}

}
