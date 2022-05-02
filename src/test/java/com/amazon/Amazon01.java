package com.amazon;

 import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import CyberSuccess.com.org.BaseClass;

public class Amazon01 extends BaseClass {

	public static void main(String[] args) throws Exception {
		
		getBrowserInstance("Chrome");
		
		driver.navigate().to("https://www.amazon.in/");
	    Select select = new Select(driver.findElement(By.id("searchDropdownBox")));
		
		driver.findElement(By.id("searchDropdownBox")).click();
		select.selectByVisibleText("Electronics");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Television");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		List<WebElement> tvNameElements = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		
		List<WebElement> priceElements = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		
		ArrayList<String> tvName = new ArrayList<String>();
		ArrayList<Integer> tvPrice = new ArrayList<Integer>();
		
		tvNameElements.forEach((element)->{
			String tv = element.getText(); 
			tvName.add(tv);
			
		});
	
		priceElements.forEach((element)->{
			String price = element.getText();
			int commaIndex = price.indexOf(",");
			String tvPrice1 = (price.substring(0, commaIndex)+ price.substring(commaIndex+1));
			Integer tvPrice5 = new Integer(tvPrice1);
			tvPrice.add(tvPrice5);
			     
		});
		 System.out.println(tvNameElements.stream().count());
		 int tvCount = (int) tvNameElements.stream().count();
		 validate(tvCount,30);
		
		Iterator i = tvName.iterator();
		Iterator j = tvPrice.iterator();
		
	
		 while (i.hasNext() && j.hasNext()) {
			 String tvName2 = (String)i.next();
		   	Integer tvPrice2 = (Integer)j.next();
			 
			 System.out.println(tvName2+" -  Price: "+tvPrice2);
			 
		  }
		 
		 
		 Collections.sort(tvPrice);
	
		 System.out.println("Maximum Price " + tvPrice.get(29) );
		 
		 System.out.println("Minimum Price " + tvPrice.get(0));
		
		
		

	}
	
	

}
