package com.crm.qa.testCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase{
	public LoginPage loginpage;
	public HomePage homePage;
	public TestUtil testUtil;
	public ContactsPage contactsPage;
	public String sheetName="deals";
	public DealsPage dealsPage;

	private static Logger logger=Logger.getLogger("DealsPageTest");

	//------------------Launching browser Hitting URL and Login iN CRM Website-------------------
	//-----------------Create Page Object--------------------------------------------------------
	//-----------------Switch To ContactsLink Frame----------------------------------------------
	@BeforeMethod
	public void setUp()
	{

		
		initialization();
		loginpage=new  LoginPage();
		testUtil=new TestUtil();
		contactsPage=new ContactsPage();
		homePage=loginpage.valiateloginInCrmWebsite(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame(prop.getProperty("frame"));
		dealsPage=homePage.validateClickOnDealsLink();

	}
	
	// ----------------------Test Method for testing deals page label -------------------------
	
	@Test(priority=1)
	public void dealsLabelTest()
	{
		logger.fatal("I think if label is not appread i will kill you");
		boolean dealslabel=dealsPage.validateDealsLabel();
		Assert.assertTrue(dealslabel,"Deals label is not appread in deals page");
	}
	
	//-------------------data provider for reading excel data---------------------------------
	@DataProvider(name="data")
	public Object[][] getCRMTestData()
	{
		Object[][] data=TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=2,dataProvider="data")
	public void createNewDealsTest(String title,String company)
	{
			
		homePage.validateclickOnNewDealsLink();
		dealsPage.validateCreateNewDeals(title, company);
		
	}
	
	
	//-----------------------Quiting Browser-----------------------------------------------------------------
	@AfterMethod
	public void tearDown()
	{
		
		driver.quit();
	}


}
