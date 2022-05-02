package com.OrangeHRMAutomation;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CyberSuccess.com.org.BaseClass;

public class windowsHandling extends BaseClass {
	public static void main (String[]args) throws Exception {
		
		getBrowserInstance("Chrome");
		driver.navigate().to("https://www.irctc.co.in/nget/profile/user-registration");
		WebElement okButton = driver.findElement(By.xpath("//div[@class=\"text-center\"]/following-sibling::from//button"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(okButton));
		okButton.click();
		driver.findElement(By.linkText("HOTELS")).click();
		String parentWindowId = driver.getWindowHandle();
		System.out.println("parent window id: "+ parentWindowId);
		Set<String> totalWindows = driver.getWindowHandles();
		for(String windowId: totalWindows) {
			if(!windowId.equals(parentWindowId)) {
				driver.switchTo().window(windowId);
				if(driver.getTitle().equals("IRCTC Hotels")) {
					System.out.println("Successfully able to land on child window...");
					System.out.println("Title of child window is : " + driver.getTitle());
					driver.close();
				} else {
					throw new Exception("Unable to take control on child window...");
				}
			}
		}
		
	driver.switchTo().window(parentWindowId);
	System.out.println("Title of parent window is :"+ driver.getTitle());
	
	driver.quit();
		
		
	}

}
