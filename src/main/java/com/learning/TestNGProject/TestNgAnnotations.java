package com.learning.TestNGProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;


// BeforeSuite -> BeforeTest -> BeforeClass
//						->BeforeMethod->Test->AfterMethod
//						->BeforeMethod->Test->AfterMethod
// AfterClass -> AfterTest -> AfterSuite



public class TestNgAnnotations {
  
  @Test(priority=1)
  public void f1() {
	  System.out.println("Test1");
  }
  
  @Test
  public void f2() {
	  System.out.println("Test2");
  }
	  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("");
	  System.out.println("Before Method..");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method..");
	  System.out.println("");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("");
	  System.out.println("Before Class..");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After Class..");
	  System.out.println("");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("");
	  System.out.println("Before Test..");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test..");
	  System.out.println("");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before Suite..");
	  System.out.println("");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("");
	  System.out.println("After Suite..");
  }
  

}
