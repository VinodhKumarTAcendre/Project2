package com.arbohub.testcases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.arbohub.library.BaseLibrary;
import com.arbohub.library.BaseLibrary2;
import com.arbohub.library.GenericLibrary;
import com.arbohub.library.HtmlReportListener;
import com.arbohub.pages.HomePage;
import com.arbohub.pages.LoginPage;


public class MenuTest extends BaseLibrary2{
	
	LoginPage loginPage;
	HomePage homePage;
	String[] sData = null;
		
	@Parameters("device")
	@Test(enabled = true, priority = 1, description ="To verify all menu options and their respective screens")
	public void testMenu(String device)
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver); 
		sData = HtmlReportListener.sDataGuest;
		HtmlReportListener.test = HtmlReportListener.extent.createTest("testMenu","To verify all menu options and their respective screens");
		
		try
		{
			loginPage.getEleHamburgerMenu().click();
			GenericLibrary.elementStatus(loginPage.getEleDefaultProfilePicImg(),sData[1], "displayed");
			GenericLibrary.elementTextCompare(sData[2], loginPage.getEleUserNameTxt(), loginPage.getEleUserNameTxt().getText());
			GenericLibrary.elementStatus(loginPage.getEleDropDwnIcn(),sData[3], "displayed");
			loginPage.getEleDropDwnIcn().click();
			GenericLibrary.elementStatus(loginPage.getEleSignInLnk(),sData[4], "displayed");
			loginPage.getEleSignInLnk().click();
			GenericLibrary.elementStatus(loginPage.getEleGetStartedTxt(),sData[5], "displayed");
			loginPage.getEleSkipBtn().click();
			GenericLibrary.elementStatus(homePage.getEleArboIcn(),sData[9] , "displayed");
			homePage.getEleArboIcn().click();
			loginPage.getEleHamburgerMenu().click();
			GenericLibrary.elementStatus(loginPage.getEleHomeLnk(), loginPage.getEleHomeLnk().getText()+" menu option", "displayed");
			loginPage.getEleHomeLnk().click();
			GenericLibrary.elementStatus(homePage.getEleHiUserTxt(),sData[6], "displayed");
			loginPage.navigateToMenuOptions(homePage ,sData[6],loginPage.getEleNewsUpdateLnk(), loginPage.getEleNewsHeaderTxt(), driver);
			loginPage.navigateToMenuOptions(homePage ,sData[6],loginPage.getEleHoroscopeLnk(), loginPage.getEleHoroscopeHeaderTxt(),driver);
			loginPage.navigateToMenuOptions(homePage ,sData[6],loginPage.getEleCricketLnk(), loginPage.getEleCricketHeadrTxt(),driver);
			loginPage.navigateToMenuOptions(homePage ,sData[6],loginPage.getEleCelebrationsLnk(), loginPage.getEleCelebrationsHeaderTxt(),driver);
			loginPage.navigateToMenuOptions(homePage ,sData[6],loginPage.getEleBookmarksLnk(), loginPage.getEleBookmarksHeaderTxt(),driver);
			loginPage.navigateToMenuOptions(homePage ,sData[6],loginPage.getEleSettingsLnk(), loginPage.getEleSettingsHeaderTxt(),driver);
		}
		catch(Exception e)
		{
			throw e;
		}
		
		
	}

}
