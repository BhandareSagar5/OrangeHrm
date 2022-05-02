package com.OrangeHRMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CyberSuccess.com.org.BaseClass;

public class RedBusPage extends BaseClass {
	
	/*
	 * public RedBusPage() { PageFactory.initElements(driver, this); }
	 * 
	 * @FindBy(id="src") public WebElement fromLoc;
	 * 
	 * @FindBy(xpath="//ul[@class='autoFill homeSearch']/li[1]") public WebElement
	 * searchResult;
	 * 
	 * @FindBy(id="dest") public WebElement toLoc;
	 */
	
	public By fromLoc = By.id("src");
	public By toLoc = By.id("dest");
	public By searchResult = By.className("selected");
	public By searchButton = By.id("search_btn");
	public By date = By.id("onward_cal");
}
