package com.amazon;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import CyberSuccess.com.org.BaseClass;

public class JavaScriptExe extends BaseClass {

	public static void main(String[] args) {
		 
		getBrowserInstance("Chrome");
		
		driver.navigate().to("https://www.amazon.in/");
		
		//WebDriver driver = new ChromeDriver();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Click operation
		//js.executeScript("arguments[0].click();", driver.findElement(By.id("btnLogin")));
		
		//generate information alert (prompt alert)
		//js.executeScript("alert('This is sample alert in selenium!');");
		
		//generate confirmation alert
		//js.executeScript("confirm('This is sample alert in selenium !');");
		
		//Alert alert = driver.switchTo().alert();
		//alert.accept();
		//alert.dismiss();
		//alert.sendKeys("text");
		
		//Vertical scrolling
		//js.executeScript("window.scrollBy(0,1700);");
		
		//Horizontal scrolling
		//js.executeScript("window.scrollBy(1000,0);");
		
		//scroll vertically at the bottom
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
	}

}
