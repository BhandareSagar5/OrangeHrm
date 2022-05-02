package com.OrangeHRMAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Sample {
  @Test
  public void assert1() {
	  
	  String actual = "Mumbai";
	  String expected = "Pune";
	  
	  SoftAssert assertion = new SoftAssert();
	  //assertion.assertEquals(actual, expected);
	  //assertion.assertTrue(1==0);
	  //assertion.assertFalse(1==0);
	 
	  //Assert.assertEquals(actual, expected);
	  //Assert.assertTrue(actual.equals(expected));
	 //Assert.assertFalse(1==1, "Hello");
	  
	  System.out.println("Finish");
	 
  }
}
