package com.arbohub.testcases;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arbohub.library.BaseLibrary;
import com.arbohub.library.GenericLibrary;
import com.arbohub.library.HtmlReportListener;
import com.arbohub.pages.HomePage;
import com.arbohub.pages.LoginPage;
import com.arbohub.pages.PermissionsPage;

public class LoginTest extends BaseLibrary {
	
	PermissionsPage permissionPage;
	LoginPage loginPage;
	HomePage homePage;
	String[] sData = null;
	String[] sFBData = null;
	String[] sGoogleData = null;
	String[] sPhoneData = null;
	
	
	/*
	 * @Description:To initialize page classes and their objects and Test data cells 
	 * @Author:Yashi Priya
	 */
	
	@BeforeClass
	public void inititialize()
	{
		permissionPage = new PermissionsPage(driver);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver); 
	}
	
	
	
	@Parameters("device")
	@Test(enabled = true, priority = 1, description ="To verify Login screen senarios")
	public void testLoginScreen(String device) throws Exception
	{
		sData = HtmlReportListener.sDataGuest;
		HtmlReportListener.test = HtmlReportListener.extent.createTest("testLoginScreen","To verify Login screen senarios");
		
		try
		{
			permissionPage.getEleGetStartedBtn().click();
			GenericLibrary.elementStatus(loginPage.getEleGetStartedTxt(),sData[1]+loginPage.getEleGetStartedTxt().getText()+" text", "displayed" );
			GenericLibrary.elementStatus(loginPage.getEleLoginTxt(), sData[2], "displayed");
			GenericLibrary.elementStatus(loginPage.getEleFacebookLoginBtn(), loginPage.getEleFacebookLoginBtn().getText()+" login button", "displayed");
			GenericLibrary.elementStatus(loginPage.getEleGoogleLoginBtn(), loginPage.getEleGoogleLoginBtn().getText()+" login button", "displayed");
			GenericLibrary.elementStatus(loginPage.getElePhnNumLoginBtn(), loginPage.getElePhnNumLoginBtn().getText()+" login button", "displayed");
			GenericLibrary.elementStatus(loginPage.getEleSkipBtn(), loginPage.getEleSkipBtn().getText()+" login button", "displayed");
			loginPage.getEleFacebookLoginBtn().click();
			GenericLibrary.elementStatus(loginPage.getEleFacebookLogo(), sData[3], "displayed");
			driver.navigate().back();
			Thread.sleep(5000);
			loginPage.getEleGoogleLoginBtn().click();
			GenericLibrary.elementStatus(loginPage.getEleChooseAcntPopup(), loginPage.getEleChooseAcntPopup().getText()+" popup", "displayed");
			driver.navigate().back();
			Thread.sleep(5000);
			loginPage.getElePhnNumLoginBtn().click();
			GenericLibrary.elementTextCompare(sData[4], permissionPage.getEleLocationCallsPermissionPopups(), permissionPage.getEleLocationCallsPermissionPopups().getText()+" popup");
			permissionPage.verifyAllowDenyBtns(permissionPage);
			permissionPage.getEleAllowBtn().click();
			GenericLibrary.elementTextCompare(sData[5], loginPage.getEleEnterMobNumTxt(), loginPage.getEleEnterMobNumTxt().getText()+" text and mobile number login page.");
			driver.navigate().back();
			driver.navigate().back();
		}
		catch(Exception e)
		{
			throw(e);
		}
		
	}
	
	/*@Parameters("device")*/
	@Test(dataProvider= "getUsers" ,enabled = true, priority = 2, description ="To verify all logins")
	public void testLogin(String sUsers, String device)
	{
		sData = HtmlReportListener.sDataGuest;
		HtmlReportListener.test = HtmlReportListener.extent.createTest("testLogin","To verify all logins");
		
		try
		{
			if(sUsers.equalsIgnoreCase("Guest"))
			{
				System.out.println(sUsers);
				permissionPage.toHandlePermissionPopups();
				loginPage.getEleSkipBtn().click();
				GenericLibrary.elementTextCompare(sData[1], permissionPage.getEleLocationCallsPermissionPopups(), permissionPage.getEleLocationCallsPermissionPopups().getText()+" popup");
				permissionPage.verifyAllowDenyBtns(permissionPage);
				permissionPage.getEleAllowBtn().click();
				try
				{
					homePage.getEleArboIcn().click();
					GenericLibrary.elementTextCompare(sData[2], homePage.getEleHiUserTxt(), homePage.getEleHiUserTxt().getText()+" text and guest login is successful");
				}
				catch(Exception e)
				{
					GenericLibrary.tapOnElement(0.18, 0.40);
					GenericLibrary.elementTextCompare(sData[2], homePage.getEleHiUserTxt(), homePage.getEleHiUserTxt().getText()+" text and guest login is successful");
				}
				
			}
			else if(sUsers.equalsIgnoreCase("Facebook"))
			{
				try
				{
					System.out.println(sUsers);
					
					loginPage.getEleFacebookLoginBtn().click();
					loginPage.getEleFBUserNameTxtFld().sendKeys(sData[3]);
					loginPage.getEleFBLoginBtn().click();
					loginPage.getEleFBPassWordTxtFld().sendKeys(sData[4]);
					loginPage.getEleFBLoginBtn().click();
					GenericLibrary.elementTextCompare(sData[1], permissionPage.getEleLocationCallsPermissionPopups(), permissionPage.getEleLocationCallsPermissionPopups().getText()+" popup");
					permissionPage.verifyAllowDenyBtns(permissionPage);
					permissionPage.getEleAllowBtn().click();
					GenericLibrary.elementTextCompare(sData[5], homePage.getEleHiUserTxt(), homePage.getEleHiUserTxt().getText()+" text and Facebook login is successful");
					driver.resetApp();
				}
				catch(Exception e)
				{
					//Cleanup code
					driver.resetApp();
					throw e;
				}
				
				
			}
			else if(sUsers.equalsIgnoreCase("Google"))
			{
				try
				{
					System.out.println(sUsers);
					permissionPage.toHandlePermissionPopups();
					
					loginPage.getEleGoogleLoginBtn().click();
					GenericLibrary.elementStatus(loginPage.getEleChooseAcntPopup(), loginPage.getEleChooseAcntPopup().getText()+" popup", "displayed");
					loginPage.getEleGoogleLoginUserLnk().click();
					GenericLibrary.elementTextCompare(sData[1], permissionPage.getEleLocationCallsPermissionPopups(), permissionPage.getEleLocationCallsPermissionPopups().getText()+" popup");
					permissionPage.verifyAllowDenyBtns(permissionPage);
					permissionPage.getEleAllowBtn().click();
					GenericLibrary.elementTextCompare(sData[6], homePage.getEleHiUserTxt(), homePage.getEleHiUserTxt().getText()+" text and Google login is successful");
					driver.resetApp();
				}
				catch(Exception e)
				{
					//Cleanup code
					driver.resetApp();
					throw e;
				}
				
			}
			else if(sUsers.equalsIgnoreCase("Phone"))
			{
				try
				{
					System.out.println(sUsers);
					permissionPage.toHandlePermissionPopups();
				
					loginPage.getElePhnNumLoginBtn().click();
					GenericLibrary.elementTextCompare(sData[1], permissionPage.getEleLocationCallsPermissionPopups(), permissionPage.getEleLocationCallsPermissionPopups().getText()+" popup");
					permissionPage.verifyAllowDenyBtns(permissionPage);
					permissionPage.getEleAllowBtn().click();
					GenericLibrary.elementTextCompare(sData[7], loginPage.getEleEnterMobNumTxt(), loginPage.getEleEnterMobNumTxt().getText()+" text and mobile number login page.");
					loginPage.getEleMobileTxtFld().sendKeys(sData[8]);
					driver.hideKeyboard();
					loginPage.getElePhnNextBtn().click();
					GenericLibrary.elementTextCompare(sData[9], homePage.getEleHiUserTxt(), homePage.getEleHiUserTxt().getText()+" text and Mobile login is successful");
					driver.resetApp();
				}
				catch(Exception e)
				{
					//Cleanup code
					driver.resetApp();
					throw e;
				}
				
			}
			
		}
		catch(Exception e)
		{
			throw(e);
		}
		
	}
	
	@DataProvider
	public Object[][] getUsers(ITestContext context)
	{
		
		Object[][] data = new Object[4][2];
		data[0][0] = "Facebook";
		data[0][1] = context.getCurrentXmlTest().getParameter("device");
		
		data[1][0] = "Phone";
		data[1][1] = context.getCurrentXmlTest().getParameter("device");
		
		data[2][0] = "Google";
		data[2][1] = context.getCurrentXmlTest().getParameter("device");
		
		data[3][0] = "Guest";
		data[3][1] = context.getCurrentXmlTest().getParameter("device");
		
		return data;
	}
}
