package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase  {
	
	//------------------Page objects/Element Repository--------------------------------------------------

	@FindBy(xpath="//td[@align='left']")
	WebElement userNameLabel;

	@FindBy(linkText="Contacts")
	WebElement contactsLinks;
	
	@FindBy(linkText="New Contact")
	WebElement newcontactsLinks;


	@FindBy(linkText="Deals")
	WebElement dealsLinks;
	

	@FindBy(linkText="New Deal")
	WebElement newDealsLinks;


	@FindBy(linkText="Tasks")
	WebElement tasksLinks;

	//  ---------------- Initialize PageFactory Class on constructor-------------------------
	

	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	//-----------------Validate HomePage Title---------------------------------------------

	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	//------------------ Validate whether the user anme is correct or not---------------------

	public boolean validateCorrectUserName()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return userNameLabel.isDisplayed();
	}
	
	//---------------- Validate whether it is clicking on contacts page or not--------------------

	public ContactsPage validateClickOnContactsLink()
	{
		contactsLinks.click();
		return new ContactsPage();
	}
	
	//---------------- Validate whether it is clicking on deals page or not--------------------


	public DealsPage validateClickOnDealsLink()
	{
		dealsLinks.click();
		return new DealsPage();
	}
	
	//---------------- Validate whether it is clicking on tasks page or not--------------------


	public TaskPage validateClickOnTasksLink()
	{
		tasksLinks.click();
		return new TaskPage();
	}
	
	//----------------- Validate whether it is cliking on new conatcts link or not--------------
	
	public void validateclickOnNewContactsLink()
	{
		TestUtil.moveToWebElementByActionsClass(contactsLinks);
		TestUtil.clickOnElementByActionClass(newcontactsLinks);
	}
	
	////----------------- Validate whether it is clcking on new deals link or not--------------
	public void validateclickOnNewDealsLink()
	{
		TestUtil.moveToWebElementByActionsClass(dealsLinks);
		TestUtil.clickOnElementByActionClass(newDealsLinks);
	}


}





