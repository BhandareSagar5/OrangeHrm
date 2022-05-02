package com.amazon;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserProfiling {

	public static void main(String[] args) {
		WebDriver driver;
		
		//for Chrome browser
		driver = new ChromeDriver();
		ChromeOptions option = new ChromeOptions();
		
		//for Edge browser
		//driver = new EdgeDriver();
		//EdgeOptions option = new EdgeOptions();
		
		//for Firefox browser
		//driver = new FirefoxDriver();
		//FirefoxOptions option = new FirefoxOptions();
		
		Map<String, Object> map = new HashMap<>();
		
		//open headless browser using addArguments( use headless for headless and --headless for with head)
		option.addArguments("headless");
		
		//open headless browser using setHeadless( use true for headless and false for with head)
		option.setHeadless(true);
		
		//Apply implicit wait
		option.setImplicitWaitTimeout(Duration.ofSeconds(10));
		
		//Open browser in incognito mode
		option.addArguments("incognito");
		
		//Accept insecure certificate (use true for accept and false for reject)
		option.setAcceptInsecureCerts(true);
		
		//Change download directory path
		map.put("download.default_directory", "C://");
		option.setExperimentalOption("prefs", map);
		
		//Handle password manager 
		map.put("profile.password_manager_enabled", true);
		option.setExperimentalOption("prefs", map);
		
		driver = new ChromeDriver(option);
		
		
	
	
	
	}

}
