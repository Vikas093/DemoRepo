package com.crm.qa.util;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class TestNgXmlUsingCode 
{
	
	public void testNgXmlSuite()
	{
	List<XmlSuite> suites=new ArrayList<XmlSuite>();
	List<XmlClass> classes=new ArrayList<XmlClass>();
	
	XmlSuite suite=new XmlSuite();
	suite.setName("ProgramSuite");
	
	XmlTest test= new XmlTest();
	test.setName("ProgramTest");
	
	XmlClass class1=new XmlClass("com.crm.qa.testCases.DealsPageTest");
	classes.add(class1);
	
	test.setXmlClasses(classes);

	suites.add(suite);
	
	TestNG tng= new TestNG();
	tng.setXmlSuites(suites);
	tng.run();

}
	
	public static void main(String[] args)
	{
		TestNgXmlUsingCode tnxuc=new TestNgXmlUsingCode();
		tnxuc.testNgXmlSuite();
	}
}
