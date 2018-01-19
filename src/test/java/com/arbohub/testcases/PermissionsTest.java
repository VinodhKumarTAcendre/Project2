package com.arbohub.testcases;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arbohub.library.BaseLibrary;
import com.arbohub.library.GenericLibrary;
import com.arbohub.library.HtmlReportListener;

import com.arbohub.pages.HomePage;
import com.arbohub.pages.LoginPage;
import com.arbohub.pages.PermissionsPage;

public class PermissionsTest extends BaseLibrary {
	
	PermissionsPage permissionPage;
	LoginPage loginPage;
	HomePage homePage;
	String[] sData = null;
	
	/*
	 * @Description:To initialize page classes and their objects and Test data cells 
	 * @Author:Yashi Priya
	 */
	
	@BeforeMethod
	public void inititialize() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		permissionPage = new PermissionsPage(driver);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}
	
	
	/* @Module:Permissions
	 * @Description:To verify Permission Popups 
	 * @Author:Yashi Priya
	 */
	
	@Parameters("device")
	@Test(enabled = true, priority = 2, description ="To verify Permission Popups")
	public void testAllowPermissionPopUps(String device) throws Exception
	{
		sData = HtmlReportListener.sDataGuest;
		HtmlReportListener.test = HtmlReportListener.extent.createTest("testAllowPermissionPopUps","To verify Permission Popups");
		try
		{
			GenericLibrary.elementStatus(permissionPage.getElePermissionPopUp(), permissionPage.getElePermissionPopUp().getText()+" popup", "displayed");
			GenericLibrary.elementStatus(permissionPage.getEleOKBtn(), permissionPage.getElePermissionPopUp().getText()+" popup with "+permissionPage.getEleOKBtn().getText()+" button", "displayed");
			permissionPage.getEleOKBtn().click();
			GenericLibrary.elementTextCompare(sData[1], permissionPage.getEleLocationCallsPermissionPopups(), permissionPage.getEleLocationCallsPermissionPopups().getText()+" popup");
			permissionPage.verifyAllowDenyBtns(permissionPage);
			permissionPage.getEleAllowBtn().click();
			GenericLibrary.elementTextCompare(sData[2], permissionPage.getEleLocationCallsPermissionPopups(), permissionPage.getEleLocationCallsPermissionPopups().getText()+" popup");
			permissionPage.verifyAllowDenyBtns(permissionPage);
			permissionPage.getEleAllowBtn().click();
			GenericLibrary.elementStatus(permissionPage.getEleWelcomeTxt(), sData[3], "displayed");
		}
		catch(Exception e)
		{
			throw(e);
		}
	}
	
	@Parameters("device")
	@Test(enabled = true, priority = 1, description ="To verify Deny button in Permission Popups")
	public void testDenyPermissionPopUps(String device) throws Exception
	{
		sData = HtmlReportListener.sDataGuest;
		HtmlReportListener.test = HtmlReportListener.extent.createTest("testDenyPermissionPopUps","To verify Permission Popups");
		try
		{
			GenericLibrary.elementStatus(permissionPage.getElePermissionPopUp(), permissionPage.getElePermissionPopUp().getText()+" popup", "displayed");
			GenericLibrary.elementStatus(permissionPage.getEleOKBtn(), permissionPage.getElePermissionPopUp().getText()+" popup with "+permissionPage.getEleOKBtn().getText()+" button", "displayed");
			permissionPage.getEleOKBtn().click();
			GenericLibrary.elementTextCompare(sData[1], permissionPage.getEleLocationCallsPermissionPopups(), permissionPage.getEleLocationCallsPermissionPopups().getText()+" popup");
			permissionPage.verifyAllowDenyBtns(permissionPage);
			permissionPage.getEleDenyBtn().click();
			GenericLibrary.elementTextCompare(sData[2], permissionPage.getEleLocationCallsPermissionPopups(), permissionPage.getEleLocationCallsPermissionPopups().getText()+" popup");
			permissionPage.verifyAllowDenyBtns(permissionPage);
			permissionPage.getEleDenyBtn().click();
			GenericLibrary.elementStatus(permissionPage.getElePermissionPopUp(), permissionPage.getElePermissionPopUp().getText()+" popup", "displayed");
			GenericLibrary.elementStatus(permissionPage.getEleOKBtn(), permissionPage.getElePermissionPopUp().getText()+" popup with "+permissionPage.getEleOKBtn().getText()+" button", "displayed");
		}
		catch(Exception e)
		{
			throw(e);
		}
	}
	
}
