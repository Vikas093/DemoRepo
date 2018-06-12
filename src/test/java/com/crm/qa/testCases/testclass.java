package com.crm.qa.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class testclass extends TestBase {
	
	
	public testclass()
	{
		super();
	}

	public static void main(String[] args)
	
	{
		testclass s=new testclass();
	       
		TestBase.initialization();
		TestUtil.scrollPageDownUptoBottomByJs(driver);

	}

}
