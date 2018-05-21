package com.crm.qa.util;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.crm.qa.base.TestBase;

public class ITestListn extends TestBase implements ITestListener {
	
	//-------------------On test start---------------------------------------------------

	public void onTestStart(ITestResult result) 
	{
	System.out.println("TestMethod Started  : " +result.getName());	
		
	}
	
	//-------------------On test success---------------------------------------------------


	public void onTestSuccess(ITestResult result) 
	{
		
		System.out.println("TestMethod Success  : " +result.getName());	
	}
	
	//-------------------On test failure---------------------------------------------------


	public void onTestFailure(ITestResult result) 
	{
		System.out.println("TestMethod Faliure  : " +result.getName());	
		//TestUtil.takeScreenShot(driver, "pic");
		
	}
	
	//-------------------On test skipped---------------------------------------------------


	public void onTestSkipped(ITestResult result) 
	{
		
		System.out.println("TestMethod Skipped  : " +result.getName());	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}
	
	//-------------------On suite start---------------------------------------------------


	public void onStart(ITestContext context) 
	{
		System.out.println("TestSuite Started  : " +context.getName());			
	}
	
	//-------------------On suite finish---------------------------------------------------


	public void onFinish(ITestContext context) 
	{
		
		System.out.println("TestSuite Started  : " +context.getName());	
	}

}
