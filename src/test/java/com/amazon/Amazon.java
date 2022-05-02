package com.amazon;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import CyberSuccess.com.org.BaseClass;

public class Amazon extends BaseClass {

	public static void main(String[] args) {
		
		
		  getBrowserInstance("Chrome");
		  
		  driver.navigate().to("https://www.amazon.in/"); Select select = new
		  Select(driver.findElement(By.id("searchDropdownBox")));
		  
		  driver.findElement(By.id("searchDropdownBox")).click();
		  select.selectByVisibleText("Electronics");
		  
		  driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobiles");
		  driver.findElement(By.id("nav-search-submit-button")).click(); WebElement
		  mobileButton = driver.findElement(By.xpath("//img[@data-image-index='1']"));
		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  wait.until(ExpectedConditions.visibilityOf(mobileButton));
		  mobileButton.click();
		 
		
		String parentWindow = driver.getWindowHandle();
		Set <String> allWindows = driver.getWindowHandles();
		for (String windowId : allWindows) {
			if(!windowId.equals(parentWindow)) {
				driver.switchTo().window(parentWindow);
			}
		}
		
	}

}
