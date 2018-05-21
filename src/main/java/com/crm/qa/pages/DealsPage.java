package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class DealsPage extends TestBase  {
	
	//------------------Page objects/Element Repository--------------------------------------------------

	@FindBy(xpath="html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/form/table[2]/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement dealsLabel;
	
	@FindBy(xpath=".//*[@id='title']")
	WebElement title;
	
	@FindBy(xpath=".//*[@id='prospectForm']/table/tbody/tr[2]/td[1]/table/tbody/tr[3]/td[2]/input[3]")
	WebElement company;
	
	
	@FindBy(xpath=".//*[@id='prospectForm']/table/tbody/tr[1]/td/input[1]")
	WebElement saveBtn;
			
	
//  --------------------------Initialize PageFactory Class on constructor-------------------------

	
	public DealsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//------------------------Validate the label of deals page-------------------------------------------
	
	public boolean validateDealsLabel()
	{
		return dealsLabel.isDisplayed();
	}

	//------------------------- validate create new deals list------------------------------------------

	public void validateCreateNewDeals(String til,String com)
	{
		title.sendKeys(til);
		company.sendKeys(com);
		saveBtn.click();
	}
}
