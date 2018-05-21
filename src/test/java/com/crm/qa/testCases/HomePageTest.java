package com.crm.qa.testCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase 
{
	public LoginPage loginpage;
	public HomePage homePage;
	public TestUtil testUtil;
	public ContactsPage contactsPage;
	private static Logger logger=Logger.getLogger("HomePageTest");

	//------------------Launching browser Hitting URL and Login iN CRM Website-------------------
	//-----------------Create Page Object--------------------------------------------------------
	@BeforeMethod
	public void setUp()
	{

		initialization();
		loginpage=new  LoginPage();
		testUtil=new TestUtil();
		contactsPage=new ContactsPage();
		homePage=loginpage.valiateloginInCrmWebsite(prop.getProperty("username"), prop.getProperty("password"));

	}


	// ----------------------Test Method for testing home page title-------------------------

	@Test(priority=1)
	public void homePageTitleTest()
	{
		String homePagetitle=homePage.validateHomePageTitle();
		Assert.assertEquals(homePagetitle, "CRMPRO","Home page title not matched");
	}	


	// ----------------------Test Method for testing user name-------------------------
	@Test(priority=2)
	public void correctUserNameTest()
	{
		testUtil.switchToFrame(prop.getProperty("frame"));
		boolean userName=homePage.validateCorrectUserName();
		Assert.assertTrue(userName,"user name is not displayed in the application");
	}

	// ----------------------Test Method for testing contacts link by click-------------------------

	@Test(priority=3)
	public void clickOnContactsLinkTest()
	{
		testUtil.switchToFrame(prop.getProperty("frame"));
		contactsPage=homePage.validateClickOnContactsLink();
	}

	//----------------------- Quiting Browser------------------------------------------------------

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
