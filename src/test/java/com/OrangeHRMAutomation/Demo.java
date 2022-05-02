package com.OrangeHRMAutomation;

import java.util.Set;

import org.openqa.selenium.By;

import CyberSuccess.com.org.BaseClass;

public class Demo extends BaseClass {

	public static void main(String[] args) {
		
		getBrowserInstance("Chrome");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.xpath("//div[@id='forgotPasswordLink']/a")).click();
		String parentWindowId = driver.getWindowHandle();
		driver.findElement(By.id("securityAuthentication_userName")).sendKeys("Admin");
		driver.findElement(By.id("btnSearchValues")).click();
		
		/*
		Set<String> totalWindows = driver.getWindowHandles();
		for(String windowId: totalWindows) {
			if(!windowId.equals(parentWindowId)) {
				driver.switchTo().window(windowId);
				System.out.println(windowId);
				
				
			}
		}
		*/
		
		
		driver.findElement(By.id("btnCancel")).click();

	}

}
