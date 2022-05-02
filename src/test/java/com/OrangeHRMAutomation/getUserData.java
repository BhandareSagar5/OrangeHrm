package com.OrangeHRMAutomation;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.OrangeHRMPages.LoginPage;

import CyberSuccess.com.org.BaseClass;

public class getUserData extends BaseClass {
	
	private By table = By.id("resultTable");
	private By checkBox = By.className("checkbox-col");
	private By headerRow = By.xpath("//table[@id='resultTable']/thead/tr/th");
	private By bodyRow = By.xpath("//table[@id='resultTable']/tbody/tr");
	private By tbCell = By.xpath("//table[@id='resultTable']/tbody/tr[1]/td[1]");
	
	@BeforeClass
	public void beforeClass() {
		getBrowserInstance("Chrome");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
	}
	
  @Test
  public void getUsersData() throws Exception {
	  
	  LoginPage log = new LoginPage();
	  log.login("Admin", "admin123");
	  
	  driver.findElement(By.id("menu_pim_viewPimModule")).click();
	  Robot robot = new Robot();
	  robot.mouseWheel(5);
	  
	  
  }
	  
  }

