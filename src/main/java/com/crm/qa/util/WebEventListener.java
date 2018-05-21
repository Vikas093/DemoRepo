package com.crm.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener {
	
	//-------------------Before Navigate to url----------------------------------------------

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");
	}
	//-------------------After Navigate to url------------------------------------------------

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to:'" + url + "'");
	}
	
	//-------------------Before cahnge value of the element----------------------------------

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of the:" + element.toString() + " before any changes made");
	}
	//-------------------After cahnge value of the element----------------------------------


	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Element value changed to: " + element.toString());
	}
	
	//-------------------Before click on thee element---------------------------------------

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on: " + element.toString());
	}
	
	//-------------------After click on the element---------------------------------------


	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: " + element.toString());
	}
	
	//------------------Before navigate back to any page----------------------------------

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
	}
	
	//------------------After navigate back to any page----------------------------------

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
	}
	
	//------------------Before navigate forward to any page-------------------------------

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
	}
	
	//------------------After navigate back to any page-----------------------------------

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page");
	}
	
	//------------------If any error or exception arries so take screen shot--------------

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured: " + error);
		
			//TestUtil.takeScreenShot(driver, "Error Pic");
	
	}
	//-------------------Before find any web element---------------------------------------

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find Element By : " + by.toString());
	}
	
	//-------------------After find any web element----------------------------------------

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element By : " + by.toString());
	}
	
	

	/*
	 * non overridden methods of WebListener class
	 */
	public void beforeScript(String script, WebDriver driver) {
	}

	public void afterScript(String script, WebDriver driver) {
	}

	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}
	
}
