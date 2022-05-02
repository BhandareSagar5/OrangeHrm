package com.OrangeHRMAutomation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.OrangeHRMPages.LoginPage;

import CyberSuccess.com.org.BaseClass;
import CyberSuccess.com.org.PropertyHandling;

public class VerifyLogInFeatureTest extends BaseClass{
	PropertyHandling prop;
	LoginPage log;
	
	
	@BeforeClass
	public void beforeClass() throws IOException {
		 prop = new PropertyHandling();
		getBrowserInstance(prop.getProperty("browser"));
		
		 driver.navigate().to(prop.getProperty("url"));
		
	}
	
 
  @Test
  public void verifyLoginValCredTest() throws IOException {
		  prop = new PropertyHandling();
		  String[] user =  prop.getProperty("username").split(" ");
		  String[] pass = prop.getProperty("password").split(" ");
		  log= new LoginPage(); 
		  log.login(user[0],pass[0]);
		  log.logout();
	 
  }
  
	
	 
	  @Test 
	  public void verifyLoginInvalidUn() throws IOException {
		  prop = new PropertyHandling();
		  String[] user =  prop.getProperty("username").split(" ");
		  String[] pass = prop.getProperty("password").split(" ");
		  System.out.println(user[1]);
		  System.out.println(pass[1]);
		  log= new LoginPage();
			  log.login(user[1],pass[1]);
			  log.logout();
			 
	  }
	 
}













