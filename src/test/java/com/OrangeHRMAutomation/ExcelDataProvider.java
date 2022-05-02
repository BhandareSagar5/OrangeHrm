package com.OrangeHRMAutomation;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CyberSuccess.com.org.ExcelUtil;

public class ExcelDataProvider {
	
	
  @Test(dataProvider = "ExcelDataProvider")
  public void login(Object username, Object password) {
	  
	  System.out.println("username: "+ username + " password: " + password);
  }
  
  @DataProvider (name= "ExcelDataProvider")
  public Object[][] getData() throws IOException {
	  String filePath = "D:\\New folder\\OrangeHRMLogin.xlsx";
	  return ExcelUtil.getExcelData(filePath, "Sheet1");
  }
}
