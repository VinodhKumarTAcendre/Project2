package com.arbohub.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arbohub.library.BaseLibrary;
import com.arbohub.library.GenericLibrary;
import com.arbohub.library.HtmlReportListener;
import com.arbohub.pages.HomePage;
import com.arbohub.pages.LoginPage;
import com.arbohub.pages.PermissionsPage;

public class WelcomeOnboardingTest extends BaseLibrary {
	PermissionsPage permissionPage;
	LoginPage loginPage;
	HomePage homePage;
	String[] sData = null;
	
	/*
	 * @Description:To initialize page classes and their objects and Test data cells 
	 * @Author:Yashi Priya
	 */
	
	@BeforeClass
	public void inititialize() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		permissionPage = new PermissionsPage(driver);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}
	
	
	
	@Parameters("device")
	@Test(enabled = true, priority = 1, description ="To verify Welcome screen senarios")
	public void testWelcomeScreen(String device)
	{
		sData = HtmlReportListener.sDataGuest;
		HtmlReportListener.test = HtmlReportListener.extent.createTest("testWelcomeScreen","To verify Welcome screen senarios");
		
		try
		{
			GenericLibrary.elementStatus(permissionPage.getEleChooseLanguageTxt(),permissionPage.getEleChooseLanguageTxt().getText()+" text" , "displayed");
			GenericLibrary.elementStatus(permissionPage.getEleLanguageDrpDwn(),sData[1] , "displayed");
			GenericLibrary.elementStatus(permissionPage.getEleNextBtn(), permissionPage.getEleNextBtn().getText()+" button", "displayed");
			permissionPage.getEleNextBtn().click();
		}
		catch(Exception e)
		{
			throw(e);
		}
	}
	
	@Parameters("device")
	@Test(enabled = true, priority = 2, description ="To verify Onboarding screen senarios")
	public void testOnboardingScreen(String device) throws Exception
	{
		sData = HtmlReportListener.sDataGuest;
		HtmlReportListener.test = HtmlReportListener.extent.createTest("testOnboardingScreen","To verify Onboarding screen senarios");
		
		try
		{
			GenericLibrary.elementTextCompare(sData[1], permissionPage.getEleSmartSuggestionWorldInAppTxt(), permissionPage.getEleSmartSuggestionWorldInAppTxt().getText()+" text");
			GenericLibrary.swipeRightToLeft(0.98, 0.28, driver);
			GenericLibrary.elementTextCompare(sData[2], permissionPage.getEleSmartSuggestionWorldInAppTxt(), permissionPage.getEleSmartSuggestionWorldInAppTxt().getText()+" text");
			GenericLibrary.elementStatus(permissionPage.getEleGetStartedBtn(), permissionPage.getEleGetStartedBtn().getText()+" button", "displayed");
			GenericLibrary.elementStatus(permissionPage.getEleTermsConditionsChkBox(), permissionPage.getEleTermsConditionsLnk().getText()+" checkbox", "displayed");
			GenericLibrary.elementStatus(permissionPage.getEleTermsConditionsChkBox(), permissionPage.getEleTermsConditionsLnk().getText()+" checkbox", "selected");
			permissionPage.getEleTermsConditionsChkBox().click();
			GenericLibrary.elementNegativeStatus(permissionPage.getEleTermsConditionsChkBox(), permissionPage.getEleTermsConditionsLnk().getText()+" checkbox", "selected");
			GenericLibrary.elementNegativeStatus(permissionPage.getEleGetStartedBtn(), permissionPage.getEleGetStartedBtn().getText()+" button", "enabled");
			permissionPage.getEleTermsConditionsChkBox().click();
			GenericLibrary.elementStatus(permissionPage.getEleGetStartedBtn(), permissionPage.getEleGetStartedBtn().getText()+" button", "enabled");
			GenericLibrary.elementStatus(permissionPage.getEleTermsConditionsChkBox(), permissionPage.getEleTermsConditionsLnk().getText()+" checkbox", "selected");
			GenericLibrary.elementStatus(permissionPage.getEleTermsConditionsLnk(), permissionPage.getEleTermsConditionsLnk().getText()+" link", "displayed");
			permissionPage.getEleTermsConditionsLnk().click();
			driver.navigate().back();
			GenericLibrary.elementStatus(permissionPage.getEleGetStartedBtn(), sData[3], "displayed");
			
		}
		catch(Exception e)
		{
			throw(e);
		}
	}
	

}
