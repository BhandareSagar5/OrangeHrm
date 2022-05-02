package com.OrangeHRMAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import CyberSuccess.com.org.BaseClass;

public class LaunchBrowserTC extends BaseClass {

	public static void main(String[] args) {
		
		getBrowserInstance("Firefox");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		driver.close();
	}

}
