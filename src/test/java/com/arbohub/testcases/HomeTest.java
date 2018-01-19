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
import com.arbohub.pages.BookmarkPage;
import com.arbohub.pages.HomePage;
import com.arbohub.pages.LoginPage;
import com.arbohub.pages.PermissionsPage;

import io.appium.java_client.android.AndroidDriver;

public class HomeTest extends BaseLibrary2{
	
	LoginPage loginPage;
	HomePage homePage;
	PermissionsPage permissionPage;
	BookmarkPage bookmarkPage;
	String[] sData = null;
	
	
	@Parameters("device")
	@Test(enabled = true, priority = 1, description ="To verify all the elements in home screens")
	public void testHome(String device)
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver); 
		permissionPage = new PermissionsPage(driver);
		bookmarkPage = new BookmarkPage(driver);
		sData = HtmlReportListener.sDataGuest;
		HtmlReportListener.test = HtmlReportListener.extent.createTest("testHome","To verify all the elements in home screens");
		
		try
		{
			GenericLibrary.elementStatus(homePage.getEleArboIcn(), sData[1], "displayed");
			homePage.getEleArboIcn().click();
			try
			{
				//facebook, google or phone number login
			}
			catch(Exception e)
			{
				GenericLibrary.elementStatus(homePage.getEleLoginMandatoryErrorPopup(), homePage.getEleLoginMandatoryErrorPopup().getText()+" popup", "displayed");
				permissionPage.getEleOKBtn().click();
				GenericLibrary.elementStatus(loginPage.getEleGetStartedTxt(), loginPage.getEleGetStartedTxt().getText()+" screen", "displayed");
				loginPage.getEleSkipBtn().click();
				homePage.getEleArboIcn().click();
			}
			GenericLibrary.elementStatus(loginPage.getEleDropDwnIcn(), sData[6], "displayed");
			GenericLibrary.elementStatus(homePage.getEleWeatherTxt(),homePage.getEleWeatherTxt().getText()+ sData[7], "displayed");
			GenericLibrary.elementStatus(homePage.getEleHiUserTxt(), sData[2], "displayed");
			loginPage.getEleHamburgerMenu().click();
			GenericLibrary.elementStatus(loginPage.getEleUserNameTxt(), sData[3], "displayed");
			GenericLibrary.elementStatus(homePage.getEleSearchIcn(), sData[4], "displayed");
			homePage.getEleSearchIcn().click();
			homePage.getEleSearchIcn().click();
			GenericLibrary.elementStatus(homePage.getEleSearchBar(), sData[5], "displayed");
			driver.navigate().back();
			driver.navigate().back();
			GenericLibrary.elementStatus(homePage.getEleHiUserTxt(), homePage.getEleHiUserTxt().getText()+" text", "displayed");
			GenericLibrary.elementStatus(homePage.getEleTemperatureTxt(), homePage.getEleTemperatureTxt()+" temperature text", "displayed");
			
		}
		catch(Exception e){
			throw e;
		}

	}
	
	@Parameters("device")
	@Test(enabled = true, priority = 2, description ="To verify cricket section in home screen")
	public void testCricketSection(String device)
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver); 
		permissionPage = new PermissionsPage(driver);
		sData = HtmlReportListener.sDataGuest;
		HtmlReportListener.test = HtmlReportListener.extent.createTest("testCricketSection","To verify cricket section in home screen");
		
		try {
			GenericLibrary.elementStatus(loginPage.getEleCricketHeadrTxt(), loginPage.getEleCricketHeadrTxt().getText()+" text header", "displayed");
			GenericLibrary.elementStatus(homePage.getEleCricketCard().get(0), homePage.getEleCricketCard().get(0).getText()+" cricket card", "displayed");
			GenericLibrary.swipeRightToLeft(0.98, 0.28, driver);
			GenericLibrary.elementStatus(homePage.getEleCricketCard().get(0), homePage.getEleCricketCard().get(0).getText()+" cricket card", "displayed");
			int cricketCards = 5;
			while(cricketCards> 0)
			{
				GenericLibrary.swipeRightToLeft(0.98, 0.28, driver);
				GenericLibrary.elementStatus(homePage.getEleCricketCard().get(0), homePage.getEleCricketCard().get(0).getText()+" cricket card", "displayed");
				cricketCards--;
			}
			homePage.getEleViewAllLnk().click();
			GenericLibrary.elementStatus(loginPage.getEleCricketHeadrTxt(), sData[1], "displayed");
			loginPage.navigateBack(loginPage, sData[2]);
			
	} 
		catch (Exception e) {
			throw e;
		}
	}
	
	@Parameters("device")
	@Test(enabled = true, priority = 3, description ="To verify News and Astro section in home screen")
	public void testNewsAndAstroSection(String device)
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver); 
		permissionPage = new PermissionsPage(driver);
		sData = HtmlReportListener.sDataGuest;
		HtmlReportListener.test = HtmlReportListener.extent.createTest("testNewsAndAstroSection","To verify News and Astro section in home screen");
		
		try {
			GenericLibrary.scrollToElement(1, 0.98, 0.28, "DOWN", homePage.getEleNewsInterestedInTxt(), driver);
			GenericLibrary.elementStatus(homePage.getEleNewsInterestedInTxt(), homePage.getEleNewsInterestedInTxt().getText()+" section", "displayed");
			GenericLibrary.elementStatus(homePage.getEleNewsLink(), homePage.getEleNewsLink().getText()+" news card", "displayed");
			String news = homePage.getEleNewsLink().getText();
			bookmarkPage.verifyBookmarkedNews(homePage, loginPage, sData[4]);
			loginPage.navigateBack(loginPage, sData[3]);
			GenericLibrary.elementStatus(homePage.getEleBookMarkIcn(),sData[1], "displayed");
			bookmarkPage.bookmarkNews(homePage, loginPage, news);
			//cleanup code
			loginPage.getEleBookmarksHeaderTxt().click();
			driver.navigate().back();
			
			GenericLibrary.scrollToElement(5, 0.98, 0.28, "DOWN", homePage.getEleAstroPredictionTxt(), driver);
			homePage.getEleViewAllLnk().click();
			GenericLibrary.elementStatus(loginPage.getEleNewsHeaderTxt(), loginPage.getEleNewsHeaderTxt().getText()+" screen", "displayed");
			loginPage.navigateBack(loginPage, sData[3]);
			GenericLibrary.elementStatus(homePage.getEleAstroPredictionTxt(), homePage.getEleAstroPredictionTxt().getText()+" section", "displayed");
			GenericLibrary.elementStatus(homePage.getEleAstroPredictionDetailsCard(), sData[2], "displayed");
			GenericLibrary.elementStatus(homePage.getEleViewAllLnk(), homePage.getEleViewAllLnk().getText()+" link", "displayed");
			homePage.getEleViewAllLnk().click();
			GenericLibrary.elementStatus(loginPage.getEleHoroscopeHeaderTxt(), loginPage.getEleHoroscopeHeaderTxt().getText()+" screen", "displayed");
			loginPage.navigateBack(loginPage, sData[3]);
			
		} 
		catch (Exception e) {
			throw e;
		}
	}
}
