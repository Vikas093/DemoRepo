package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends TestBase 
{

	//------------------Page objects/Element Repository--------------------------------------------------

	@FindBy(xpath=".//*[@id='vContactsForm']/table/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//select[@name='title']")
	WebElement newConatctsTitle;
	
	@FindBy(xpath=".//*[@id='first_name']")
	WebElement firstName;
	
	@FindBy(xpath=".//*[@id='surname']")
	WebElement lastName;
	
	@FindBy(xpath=".//*[@id='contactForm']/table/tbody/tr[2]/td[1]/table/tbody/tr[8]/td[2]/input[3]")
	WebElement company;
	
	@FindBy(xpath=".//*[@id='contactForm']/table/tbody/tr[1]/td/input[2]")
	WebElement saveBtn;

	//  ---------------- Initialize PageFactory Class on constructor-------------------------

	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}

	//---------------------------Validate the label of contacts page-------------------------------

	public boolean validatecontactsLabel()
	{
		return contactsLabel.isDisplayed();
	}

	//-------------------------Validate Contacts page Checkbox click by name-----------------------

	public void validateselectContactsByName(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']/..//preceding-sibling::td/input")).click();
	}
	
	//-------------------------Validate create new contacts list-------------------------------------
	
	public void validateCreateNewContacts(String Title,String ftName,String ltName,String com)
	{
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestUtil.selectByVisibleTxt(newConatctsTitle,Title);
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(com);
		saveBtn.click();
		
	}

}
