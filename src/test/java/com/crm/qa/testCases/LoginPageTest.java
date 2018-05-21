package com.crm.qa.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	public  LoginPage loginPage;
	public HomePage homePage;
	private static Logger logger=Logger.getLogger("LoginPageTest");
	
	

	//------------------Launching browser Hitting URL and Login in CRM Website-------------------
	//-----------------Create Page Object--------------------------------------------------------

	@BeforeMethod
	public void setUp()
	{
		//logger.info("calling intitilization method to laucnch browser and hit url");
		initialization();
		loginPage=new LoginPage();

	}

	// ----------------------Test Method for testing login page title-------------------------
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		//logger.info("Checking the title of login page");
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,"Free CRM software in the cloud powers sales and customer service" ,"The Title appread is incorrect");
	}

	//-----------------------Test Method for testing CRM application Logo--------------------- 
	@Test(priority=2)
	public void crmLogoImageTest()
	{
		//logger.info("Checking the CRM Logo");
		boolean flag=loginPage.validateCRMImage();
		Assert.assertTrue(flag,"Incorect CRM Logo is appreaed");
	}

	//-----------------------Test Method for testing login in CRM Weebsite--------------------

	@Test(priority=3)
	public void loginTest()
	{
		//logger.info("Verifying login in CRM Website");
		homePage=loginPage.valiateloginInCrmWebsite(prop.getProperty("username"),prop.getProperty("password"));
        Assert.assertNotNull(homePage, "homepage object is null");
	}

	//-----------------------Quiting Browser--------------------------------------------------
	@AfterMethod
	public void tearDown()
	{
		logger.info("Closing the Browser");
		driver.quit();
	}


}
