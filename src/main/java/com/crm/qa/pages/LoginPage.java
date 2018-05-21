package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase 
{

	//---------------  Page Object/Element Repository-------------------

	@FindBy(name="username")
	WebElement username;

	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath=".//*[@id='loginForm']/div/div/input")
	WebElement loginBtn;

	@FindBy(xpath="//button[@type='button'][@class='btn']")
	WebElement signUpBtn;

	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//  ---------------- Initialize PageFactory Class on constructor-------------------------
	
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	//------------------- Actions on Login Page methods--------------------------------------

	
	// -----------------  Validate LoginPage Title-------------------------------------------
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	//-------------------  Validate CRM Image -------------------------------------------------
    
	public boolean validateCRMImage()
	{
		return crmLogo.isDisplayed();
	}
	
	// ------------------   Login in CRM Application ----------------------------------------
	 public HomePage valiateloginInCrmWebsite(String un,String pwd)
	 {
		 username.sendKeys(un);
		 password.sendKeys(pwd);
		 try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 loginBtn.click();
		 return new HomePage();
	 }
}
