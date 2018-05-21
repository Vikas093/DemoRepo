package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

	
}
