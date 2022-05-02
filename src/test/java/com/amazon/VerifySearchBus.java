package com.amazon;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.OrangeHRMPages.RedBusPage;

import CyberSuccess.com.org.BaseClass;
import CyberSuccess.com.org.PropertyHandling;

public class VerifySearchBus extends BaseClass {
	
	PropertyHandling prop;
	RedBusPage redbus;
	
	@BeforeClass
	public void beforeClass() throws IOException {
		prop = new PropertyHandling();
		redbus = new RedBusPage();
		getBrowserInstance(prop.getProperty("browser"));
		driver.navigate().to("https://www.redbus.in/");
		
	}
  @Test
  public void searchBuses() {
	  
	  driver.findElement(redbus.fromLoc)
	  .sendKeys(prop.getProperty("redbusFromLocation"));
		
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  wait.until(ExpectedConditions.visibilityOf(driver.findElement(redbus.
		  searchResult)));
		 
		 
	  driver.findElement(redbus.searchResult).click();
	  
	  driver.findElement(redbus.toLoc)
	  .sendKeys(prop.getProperty("redbusToLocation"));
	  
	  driver.findElement(redbus.searchResult).click();
	  
	  driver.findElement(redbus.date).click();
	  
	  int currentDay = LocalDateTime.now().getDayOfMonth();
	  
	  driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//tr/td"))
	  .forEach(element -> {
		 String attributeVal = element.getAttribute("class");
		 
		 if (attributeVal.equals("we day") || attributeVal.equals("wd day")) {
			 if (!element.getText().isEmpty() && 
					 (currentDay +1) == Integer.parseInt(element.getText())) {
				 element.click();
			 }
				 
		 }
	  });
	  
	  driver.findElement(redbus.searchButton).click();
  }
}
