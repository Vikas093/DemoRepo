package com.crm.qa.testCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;




@Listeners(com.crm.qa.util.ITestListn.class)
public class ContactsPageTest extends TestBase
{
	
	public LoginPage loginpage;
	public HomePage homePage;
	public TestUtil testUtil;
	public ContactsPage contactsPage;
	public String sheetName="contacts";
	private static Logger logger=Logger.getLogger("ContactsPageTest");


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
		contactsPage=homePage.validateClickOnContactsLink();

	}
	

	// ----------------------Test Method for testing contacts page label -------------------------
	
	@Test(priority=1)
	public void contactsLabelTest()
	{
		boolean contactLabelTitle= contactsPage.validatecontactsLabel();
		Assert.assertTrue(contactLabelTitle,"Contacts Label is not appeared in contacts page");
	}
	

	// ----------------------Test Method for testing contacts page checkbox by name-------------------------
	
	@Test(priority=2)
	public void selectContactsByNameTest()
	{
		contactsPage.validateselectContactsByName(prop.getProperty("CheckBoxName"));
	}
	
	//-------------------data provider for reading excel data---------------------------------
	@DataProvider(name="data")
	public Object[][] getCRMTestData()
	{
		Object[][] data=TestUtil.getTestData(sheetName);
		return data;
	}
	
	//--------------------Test method for creating new contacts -------------------------------
	
	@Test(priority=3,dataProvider="data")
	public void createNewContactTest(String title,String firstname,String lastname,String company)
	{
		
		homePage.validateclickOnNewContactsLink();
		contactsPage.validateCreateNewContacts(title,firstname,lastname,company);
	}
	
	//-----------------------Quiting Browser-----------------------------------------------------------------
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
