 package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeTest;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase 

{

	//-----------------------------------@Beforetest to register log4j configuration file--------------------------

	@BeforeTest
	public void registerLogFile(){
		PropertyConfigurator.configure("C:\\clonecode\\DemoRepo\\src\\main\\resources\\log4j.properties");
	}


	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	//  -------Properties File Reading by the help of Constructor----------
	//  -------Configuration file present in this Maven project  -----------
	public TestBase()
	{
		prop=new Properties();
		try
		{
			FileInputStream ip=new FileInputStream("C:\\clonecode\\DemoRepo\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			try 
			{
				prop.load(ip);
			} 
			catch (IOException e) 
			{

				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e)
		{

			e.printStackTrace();
		}
	}


	//  1--------------- Browser Initialization------------------------
	//  2---------------- Maximize Windows-----------------------------
	//  3 ---------------DeleteAll The Cookies-------------------------
	//  4 ---------------set  PageLoadTIMEOUT--------------------------
	//  5 ---------------set ImplicitWait------------------------------ 
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\clonecode\\DemoRepo\\driver\\chromedriver.exe" );
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("gecko"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\clonecode\\DemoRepo\\driver\\geckodriver.exe" );
			driver=new FirefoxDriver();
		}
		
		
		/*e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		*/
		
		//	driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
