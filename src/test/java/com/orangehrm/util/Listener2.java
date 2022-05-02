package com.orangehrm.util;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import CyberSuccess.com.org.BaseClass;

public class Listener2 extends BaseClass implements ISuiteListener, ITestListener {

	public void onStart(ISuite suite) {
		System.out.println("Inside onStart method");
	}
	
	public void onFinish(ISuite suite) {
		System.out.println("Inside onFinish method");
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure method");
		String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yy-hh-mm-ss"));
        String filePath = ".//Screenshots//"+result.getMethod().getMethodName()+time+".png";
        System.out.println(filePath);
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        
        try {
        	File dstFile = new File(filePath);
        	dstFile.mkdir();
        	FileUtils.copyFile(srcFile, dstFile);
        }
        catch (IOException e) {
        	e.printStackTrace();
        }
	}
	
	public static void main(String[]args) {
		System.out.println(System.getProperty("user.dir"));
	}
}
