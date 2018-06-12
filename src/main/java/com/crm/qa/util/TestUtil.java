package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	public static Actions action;
	public static Select select;
	public static String TESTDATA_SHEET_PATH="C:\\FrameWork Design\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testData\\CRMTestData.xlsx";
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	public static FileInputStream file;


	//-------------Use frame id or frame name to switch to that particular frame------------------
	//-------------Utility for switching to particular frame--------------------------------------

	public static void switchToFrame(String frameIdOrName)
	{
		driver.switchTo().frame(frameIdOrName);
	}

	//-------------Creating Action class object----------------------------------------------------

	public static void createActionClassObject()
	{
		action=new Actions(driver);
	}

	//----------------Move to webelement by using Actions class object reference--------------------

	public static void moveToWebElementByActionsClass(WebElement web)
	{
		createActionClassObject();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		action.moveToElement(web).build().perform();
	}

	//----------------Click on web element by using Actions class object reference-------------------

	public static void clickOnElementByActionClass(WebElement web)
	{
		createActionClassObject();
		try 
		{
			Thread.sleep(4000);
		} 
		catch (InterruptedException e) 
		{

			e.printStackTrace();
		}
		action.click(web).build().perform();
	}

	//----------------Create Select class object-----------------------------------------------------

	public static void createSelectclassObject(WebElement web)
	{
		try 
		{
			Thread.sleep(4000);
		} 
		catch (InterruptedException e) 
		{

			e.printStackTrace();
		}
		select=new Select(web);
	}

	//----------------Select element by visible txt--------------------------------------------------

	public static void selectByVisibleTxt(WebElement web,String TxtName)
	{
		try 
		{
			Thread.sleep(4000);
		} 
		catch (InterruptedException e) 
		{

			e.printStackTrace();
		}
		createSelectclassObject(web);
		select.selectByVisibleText(TxtName);
	}

	//---------------Utility for taking screen shot-------------------------------------------------

	/*public static void takeScreenShot(WebDriver driver,String filename)
	{
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File source=screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source,new File(".\\ScreenShot//"+filename+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("ScreenShot Taken");

	}*/

	//---------------Logic for reading test data from excel file--------------------------------------

	public static Object[][] getTestData(String sheetName)
	{
		File fileName=new File(TESTDATA_SHEET_PATH);
		try 
		{
			file=new FileInputStream(fileName);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			book=new XSSFWorkbook(file);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetName);	
		int totalRowInSheet=sheet.getLastRowNum();
		int totalNoOfColumnInSheet=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[totalRowInSheet][totalNoOfColumnInSheet];
		for(int i=0;i<totalRowInSheet;i++)
		{
			for(int k=0;k<totalNoOfColumnInSheet;k++)
			{
				data[i][k]=sheet.getRow(i+1).getCell(k).getStringCellValue();
			}
		}
		return data;
	}

	// Highlighting web element by using javascript executer

	public static void flash(WebElement element,WebDriver driver)
	{
		String bgColor=	element.getCssValue("backgroung color");
		for(int i=0;i<100;i++)
		{
			changeColor(bgColor,element,driver);
		}
	}
	// Highlighting web element by using javascript executer

	public static void changeColor(String color, WebElement element, WebDriver driver) 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
	}

	//Drawing border in the element

	public static void drawBorder(WebElement element, WebDriver driver) 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	//Generate java script alert in any element if error is there
	public static void generateAlert(WebDriver driver,String message) 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert('"+message+"'");
	}

	//Clicking on the web element by using java script executor
	public static void ClickElementByJavaScript(WebDriver driver,WebElement element) 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arugement[0].click",element);
	}

	//Refreshing a page by java Script
	public static void refreshBrowserByJs(WebDriver driver) 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}

	//get title of the webpage by javascript executor
	public static String getTitleByJs(WebDriver driver) 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String title=js.executeScript("return document.title").toString();
		return title;
	}

	//Get all the page text of 
	public static String getPageInnerTextByJs(WebDriver driver) 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String pageText=js.executeScript("return document.documentElement.innerText").toString();
		return pageText;
	}
	
	//Get the text of a particular web element
	public static String getTxtOfElementByJs(WebDriver driver) 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String elementText=js.executeScript("return document.getElementById('email').innerHTML;").toString();
		return elementText;
	}
	
	//To scroll the window upto a limit by using javascript executor
	public static void scrollPageDownUptoALimitByJs(WebDriver driver) 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
	
	}
	//To scroll the window upto bottom of page by using javascript executor
	public static void scrollPageDownUptoBottomByJs(WebDriver driver) 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	
	}
	




}
