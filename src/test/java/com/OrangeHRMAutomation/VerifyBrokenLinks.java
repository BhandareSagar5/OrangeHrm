package com.OrangeHRMAutomation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import CyberSuccess.com.org.BaseClass;

public class VerifyBrokenLinks extends BaseClass {

	public static void main(String[] args) {
		
		getBrowserInstance("Chrome");
		driver.navigate().to("https://www.amazon.in/");
		List<WebElement> linkElements = driver.findElements(By.tagName("a"));
		
		linkElements.forEach((element)->{
			String link = element.getAttribute("href");
			if (Objects.nonNull(link) && link.startsWith("http")) {
				
			//System.out.println(link);
				
				try {
					URL url = new URL(link);
					
					URLConnection connection = url.openConnection();
					
					HttpURLConnection httpConnect = (HttpURLConnection)connection;
					
					httpConnect.connect();
					int statusCode =httpConnect.getResponseCode();
					
					if (statusCode !=200) {
						System.out.println("Broken Url: "+ statusCode + " " + link);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		driver.quit();

	}

}
