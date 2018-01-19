package com.arbohub.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arbohub.library.BaseLibrary2;
import com.arbohub.library.GenericLibrary;
import com.arbohub.library.HtmlReportListener;
import com.arbohub.pages.BookmarkPage;
import com.arbohub.pages.CricketCelebrationsPage;
import com.arbohub.pages.HomePage;
import com.arbohub.pages.LoginPage;
import com.arbohub.pages.NewsHoroscopePage;
		
public class SettingsBookmarkTest extends BaseLibrary2
{
	LoginPage loginPage;
	HomePage homePage;
	NewsHoroscopePage newsHoroscopePage;
	CricketCelebrationsPage cricketCelebrationsPage;
	BookmarkPage bookmarkPage;
	String[] sData = null;
	
	@Parameters("device")
	@Test(enabled = true, priority = 1, description ="To verify Bookmark screen elements")
	public void testBookmarkScreen(String device) throws Exception
	{
		sData = HtmlReportListener.sDataGuest;
		HtmlReportListener.test = HtmlReportListener.extent.createTest("testBookmarkScreen","To verify Bookmark screen elements");
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		newsHoroscopePage = new NewsHoroscopePage(driver);
		cricketCelebrationsPage = new CricketCelebrationsPage(driver);
		bookmarkPage = new BookmarkPage(driver);
		try
		{
			loginPage.getEleHamburgerMenu().click();
			loginPage.getEleBookmarksLnk().click();
			GenericLibrary.elementStatus(loginPage.getEleBookmarksHeaderTxt(), loginPage.getEleBookmarksHeaderTxt().getText()+" screen heading", "displayed");
			GenericLibrary.elementStatus(bookmarkPage.getEleNoBookmarksTxt(), bookmarkPage.getEleNoBookmarksTxt().getText()+" text", "displayed");
			loginPage.navigateBack(loginPage, sData[1]);
			GenericLibrary.swipeTopToBottom(0.98, 0.28, driver);
			String news = homePage.getEleNewsLink().getText();
			bookmarkPage.bookmarkNews(homePage, loginPage, news);
			bookmarkPage.verifyBookmarkedNews(homePage, loginPage, sData[2]);
			GenericLibrary.elementStatus(homePage.getEleNewsLink(), news+" link", "displayed");
			homePage.getEleBookMarkIcn().click();
			GenericLibrary.elementStatus(bookmarkPage.getEleNoBookmarksTxt(), bookmarkPage.getEleNoBookmarksTxt().getText()+" text", "displayed");
			loginPage.navigateBack(loginPage, sData[1]);
		}
		catch(Exception e)
		{
			throw e;
		}
	
	}
	
	@Parameters("device")
	@Test(enabled = true, priority = 2, description ="To verify Settings screen elements")
	public void testSettingsScreen(String device) throws Exception
	{
		sData = HtmlReportListener.sDataGuest;
		HtmlReportListener.test = HtmlReportListener.extent.createTest("testSettingsScreen","To verify Settings screen elements");
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		newsHoroscopePage = new NewsHoroscopePage(driver);
		cricketCelebrationsPage = new CricketCelebrationsPage(driver);
		bookmarkPage = new BookmarkPage(driver);
		try
		{
			loginPage.getEleHamburgerMenu().click();
			loginPage.getEleSettingsLnk().click();
			GenericLibrary.elementStatus(loginPage.getEleSettingsHeaderTxt(), loginPage.getEleSettingsHeaderTxt().getText()+" as header text ", "displayed");
			GenericLibrary.elementStatus(bookmarkPage.getEleLanguageLnk(), bookmarkPage.getEleLanguageLnk().getText()+" link ", "displayed");
			bookmarkPage.setLanguage(loginPage, sData[1]);
			bookmarkPage.setLanguage(loginPage, sData[1]);
			loginPage.navigateBack(loginPage, sData[1]);
		}
		catch(Exception e)
		{
			throw e;
		}
	
	}
	
	

}