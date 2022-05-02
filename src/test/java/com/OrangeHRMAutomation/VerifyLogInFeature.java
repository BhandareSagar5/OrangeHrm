package com.OrangeHRMAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CyberSuccess.com.org.BaseClass;
import CyberSuccess.com.org.PropertyHandling;

public class VerifyLogInFeature extends BaseClass {
	
		public static void main (String[]args) throws Exception 
	{
		
		
		String pageTitle = driver.getTitle();
		
		validate(pageTitle,"OrangeHRM");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.className("button")).click();
		driver.findElement(By.id("welcome")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='welcome-menu']/ul/li[3]/a"))));
		driver.findElement(By.xpath("//div[@id='welcome-menu']/ul/li[3]/a")).click();
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin123");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.className("button")).click();
		
		String incorrectCredUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials";
		
		if(driver.getCurrentUrl().equals(incorrectCredUrl)) {
			String errorMessage = driver.findElement(By.id("spanMessage")).getText();
			validate(errorMessage, "Invalid Credentials");
		} else {
			String currentUrl = driver.getCurrentUrl();
			System.out.println(currentUrl);
			validate(currentUrl,"https://opensource-demo.orangehrmlive.com/index.php/dashboard");
			
			if(driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']")).isDisplayed()) {
			System.out.println("Successfully validiated the admin module visibility after login");
			} else {
				throw new Exception("Failed to validiate Admin module");
			}
		}
			
	}
}
		
		

