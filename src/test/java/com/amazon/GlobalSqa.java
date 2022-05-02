package com.amazon;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import CyberSuccess.com.org.BaseClass;

public class GlobalSqa extends BaseClass{

	public static void main(String[] args) {
		getBrowserInstance("Chrome");
		driver.navigate().to("https://www.globalsqa.com/demo-site/draganddrop/");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@data-src = '../../demoSite/practice/droppable/photo-manager.html']")));
		
		WebElement source = driver.findElement(By.xpath("//img[@alt='The peaks of High Tatras']"));
		WebElement destination = driver.findElement(By.id("trash"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(source, destination).build().perform();
	}

}
