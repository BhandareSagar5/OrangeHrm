package com.OrangeHRMAutomation;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.OrangeHRMPages.LoginPage;
import com.OrangeHRMPages.NewUser;

import CyberSuccess.com.org.BaseClass;

public class OrangeHRM extends BaseClass{

	public static void main(String[] args) {
		
		LoginPage loginPage= new LoginPage();
		getBrowserInstance("Chrome");
		
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		
        loginPage.login("Admin", "admin123");
        
        ArrayList<String> userList = new ArrayList<String> ();
        
        for (int i =1; i<=10; i++) {
		
        NewUser user = new NewUser();
		String userName = user.addUser();
		userList.add(userName);
		
        }
        System.out.println("User Name");
        
       for (String user : userList) {
    	   System.out.println(user);
    	   driver.findElement(By.id("menu_admin_viewAdminModule")).click();
    	   
    	   driver.findElement(By.id("searchSystemUser_userName")).sendKeys(user);
           driver.findElement(By.id("searchBtn")).click();
           driver.findElement(By.id("menu_dashboard_index")).click();
           
          
       }
	}

}
