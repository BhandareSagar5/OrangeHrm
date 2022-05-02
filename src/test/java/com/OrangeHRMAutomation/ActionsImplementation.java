package com.OrangeHRMAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import CyberSuccess.com.org.BaseClass;

public class ActionsImplementation extends BaseClass {

	public static void main(String[] args) {
		
		getBrowserInstance("Chrome");
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		
		Actions act = new Actions(driver);	
		
		// Click operation
		//act.click(driver.findElement(By.linkText("Forgot your password?"))).build().perform();
		
		// Mouse hover operation
		//act.moveToElement(driver.findElement(By.id("btnLogin"))).click().build().perform();
		
		//Right click operation using contextClick()
		//act.contextClick().build().perform();
		
		//Right click using contextClick(WebElement)
		act.contextClick(driver.findElement(By.id("btnLogin"))).build().perform();
		
		
		
		
		

  }
}
