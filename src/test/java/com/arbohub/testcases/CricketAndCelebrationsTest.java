package com.arbohub.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arbohub.library.BaseLibrary;
import com.arbohub.library.BaseLibrary2;
import com.arbohub.library.GenericLibrary;
import com.arbohub.library.HtmlReportListener;
import com.arbohub.pages.CricketCelebrationsPage;
import com.arbohub.pages.HomePage;
import com.arbohub.pages.LoginPage;
import com.arbohub.pages.NewsHoroscopePage;

import io.appium.java_client.android.AndroidDriver;

public class CricketAndCelebrationsTest extends BaseLibrary2 {
	
	LoginPage loginPage;
	HomePage homePage;
	NewsHoroscopePage newsHoroscopePage;
	CricketCelebrationsPage cricketCelebrationsPage;
	String[] sData = null;
	
	
	@Parameters("device")
	@Test(enabled = false, priority = 1, description ="To verify Cricket screen elements")
	public void testCricketScreen(String device) throws Exception
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		newsHoroscopePage = new NewsHoroscopePage(driver);
		cricketCelebrationsPage = new CricketCelebrationsPage(driver);
		sData = HtmlReportListener.sDataGuest;
		HtmlReportListener.test = HtmlReportListener.extent.createTest("testCricketScreen","To verify Cricket screen elements");
		
		try
		{
			//loginPage.navigateBack(homePage, sData[2]);
			GenericLibrary.elementStatus(loginPage.getEleCricketHeadrTxt(), loginPage.getEleCricketHeadrTxt().getText()+" card heading", "displayed");
			GenericLibrary.elementStatus(homePage.getEleCricketCard().get(0), sData[3], "displayed");
			homePage.getEleCricketCard().get(0).click();
			GenericLibrary.elementTextCompare(homePage.getEleCricketCard().get(0).getText(), cricketCelebrationsPage.getEleCricketCardDetailHeaderTxt(), sData[4]);
			GenericLibrary.elementStatus(cricketCelebrationsPage.getEleTournamentNameTxt(), sData[5]+" as "+cricketCelebrationsPage.getEleTournamentNameTxt().getText(), "displayed");
			GenericLibrary.elementStatus(cricketCelebrationsPage.getEleMatchNameTxt(), sData[6]+" as "+cricketCelebrationsPage.getEleMatchNameTxt().getText(), "displayed");
			GenericLibrary.elementStatus(cricketCelebrationsPage.getEleTeamOneTxt(), sData[7], "displayed");
			GenericLibrary.elementStatus(cricketCelebrationsPage.getEleTeamTwoTxt(), sData[8], "displayed");
			GenericLibrary.elementStatus(cricketCelebrationsPage.getEleTeamOneScoreTxt(), sData[9]+" as "+cricketCelebrationsPage.getEleTeamOneScoreTxt().getText(), "displayed");
			GenericLibrary.elementStatus(cricketCelebrationsPage.getEleTeamTwoScoreTxt(), sData[10]+" as "+cricketCelebrationsPage.getEleTeamTwoScoreTxt(), "displayed");
			GenericLibrary.elementStatus(cricketCelebrationsPage.getEleCountryOneTxt(), cricketCelebrationsPage.getEleCountryOneTxt()+" as "+sData[11], "displayed");
			GenericLibrary.elementStatus(cricketCelebrationsPage.getEleCountryTwoTxt(), cricketCelebrationsPage.getEleCountryTwoTxt()+" as "+sData[12], "displayed");
			GenericLibrary.elementStatus(cricketCelebrationsPage.getEleInningsTxt(), cricketCelebrationsPage.getEleInningsTxt().getText()+" as "+sData[13], "displayed");
			for(int i =0; i<=cricketCelebrationsPage.getElePlayerNameTxt().size()-1;i++)
			{
				if(cricketCelebrationsPage.getElePlayerNameTxt().size()!=0)
				{
					GenericLibrary.elementStatus(cricketCelebrationsPage.getElePlayerNameTxt().get(i), sData[14]+" as "+cricketCelebrationsPage.getElePlayerNameTxt().get(i).getText(), "displayed");
					GenericLibrary.elementStatus(cricketCelebrationsPage.getElePlayerDetail().get(i), sData[15]+" as "+cricketCelebrationsPage.getElePlayerDetail().get(i).getText(), "displayed");
					GenericLibrary.elementStatus(cricketCelebrationsPage.getEleScoreTxt().get(i), sData[16]+" as "+cricketCelebrationsPage.getEleScoreTxt().get(i).getText(), "displayed");
				}
				else
				{
					GenericLibrary.swipeTopToBottom(0.98, 0.28, driver);
					System.out.println(cricketCelebrationsPage.getElePlayerNameTxt().size());
					GenericLibrary.elementStatus(cricketCelebrationsPage.getElePlayerNameTxt().get(i), sData[14]+" as "+cricketCelebrationsPage.getElePlayerNameTxt().get(i).getText(), "displayed");
					GenericLibrary.elementStatus(cricketCelebrationsPage.getElePlayerDetail().get(i), sData[15]+" as "+cricketCelebrationsPage.getElePlayerDetail().get(i).getText(), "displayed");
					GenericLibrary.elementStatus(cricketCelebrationsPage.getEleScoreTxt().get(i), sData[16]+" as "+cricketCelebrationsPage.getEleScoreTxt().get(i).getText(), "displayed");
				}
				
			}
			GenericLibrary.elementStatus(cricketCelebrationsPage.getEleTotalRunsTxt(), cricketCelebrationsPage.getEleTotalRunsTxt().getText(), "displayed");
			GenericLibrary.elementStatus(cricketCelebrationsPage.getEleBOWLINGTxt(), cricketCelebrationsPage.getEleBOWLINGTxt().getText(), "displayed");
			driver.navigate().back();
			loginPage.navigateBack(loginPage, sData[2]);
		}
		
		catch(Exception e)
		{
			throw e;
		}
	}
	
	@Parameters("device")
	@Test(enabled = true, priority = 2, description ="To verify Celebrations card and celebrations screen elements under birthdays tab")
	public void testBirthdayScreen(String device) throws Exception
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		newsHoroscopePage = new NewsHoroscopePage(driver);
		cricketCelebrationsPage = new CricketCelebrationsPage(driver);
		sData = HtmlReportListener.sDataGuest;
		HtmlReportListener.test = HtmlReportListener.extent.createTest("testBirthdayScreen","To verify Celebrations card and celebrations screen elements under birthdays tab");
		
		try
		{
			cricketCelebrationsPage.addContact(homePage, sData[1], sData[10], sData[13]);
			cricketCelebrationsPage.verifyCelebrationsCard(loginPage, sData[2], sData[1], sData[4], sData[3]);cricketCelebrationsPage.verifyCelebrationsIcons(sData[5] , sData[3] ,sData[6] ,sData[7], sData[8] ,sData[9]);
			GenericLibrary.elementStatus(homePage.getEleViewAllLnk(), homePage.getEleViewAllLnk().getText()+" "+sData[3], "displayed");
			homePage.getEleViewAllLnk().click();
			GenericLibrary.elementStatus(loginPage.getEleCelebrationsHeaderTxt(), loginPage.getEleCelebrationsHeaderTxt()+" "+"screen", "displayed");
			GenericLibrary.elementStatus(cricketCelebrationsPage.getEleBIRTHDAYSTab(), cricketCelebrationsPage.getEleBIRTHDAYSTab().getText()+" tab", "displayed");
			cricketCelebrationsPage.verifyContactNameAndCelebrationDate(sData[1], sData[11]);
			cricketCelebrationsPage.verifyCelebrationsIcons(sData[5] , sData[12] ,sData[6] ,sData[7], sData[8] ,sData[9]);
			GenericLibrary.elementStatus(cricketCelebrationsPage.getEleANNIVERSARIESTab(), cricketCelebrationsPage.getEleANNIVERSARIESTab().getText()+" tab", "displayed");
			cricketCelebrationsPage.getEleANNIVERSARIESTab().click();
			GenericLibrary.elementStatus(cricketCelebrationsPage.getEleNoCelebrationsTxt(), cricketCelebrationsPage.getEleNoCelebrationsTxt().getText()+" message", "displayed");
			loginPage.navigateBack(loginPage, sData[14]);
			
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	@Parameters("device")
	@Test(enabled = true, priority = 3, description ="To verify Celebrations card and celebrations screen elements under anniversary tab")
	public void testAnniversaryScreen(String device) throws Exception
	{
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		newsHoroscopePage = new NewsHoroscopePage(driver);
		cricketCelebrationsPage = new CricketCelebrationsPage(driver);
		sData = HtmlReportListener.sDataGuest;
		HtmlReportListener.test = HtmlReportListener.extent.createTest("testAnniversaryScreen","To verify Celebrations card and celebrations screen elements under anniversary tab");
		
		try
		{
			//cricketCelebrationsPage.addContact(homePage, sData[1], sData[10] ,sData[13]);
			cricketCelebrationsPage.verifyCelebrationsCard(loginPage, sData[2], sData[1], sData[4], sData[3]);
			cricketCelebrationsPage.verifyCelebrationsIcons(sData[5] , sData[3] ,sData[6] ,sData[7], sData[8] ,sData[9]);
			GenericLibrary.elementStatus(homePage.getEleViewAllLnk(), homePage.getEleViewAllLnk().getText()+" "+sData[3], "displayed");
			homePage.getEleViewAllLnk().click();
			GenericLibrary.elementStatus(loginPage.getEleCelebrationsHeaderTxt(), loginPage.getEleCelebrationsHeaderTxt()+" "+"screen", "displayed");
			GenericLibrary.elementStatus(cricketCelebrationsPage.getEleBIRTHDAYSTab(), cricketCelebrationsPage.getEleBIRTHDAYSTab().getText()+" tab", "displayed");
			GenericLibrary.elementStatus(cricketCelebrationsPage.getEleNoCelebrationsTxt(), cricketCelebrationsPage.getEleNoCelebrationsTxt().getText()+" message", "displayed");
			GenericLibrary.elementStatus(cricketCelebrationsPage.getEleANNIVERSARIESTab(), cricketCelebrationsPage.getEleANNIVERSARIESTab().getText()+" tab", "displayed");
			cricketCelebrationsPage.getEleANNIVERSARIESTab().click();
			cricketCelebrationsPage.verifyContactNameAndCelebrationDate(sData[1],sData[11]);
			cricketCelebrationsPage.verifyCelebrationsIcons(sData[5] , sData[12] ,sData[6] ,sData[7], sData[8] ,sData[9]);
			loginPage.navigateBack(loginPage, sData[14]);
			
		}
		catch(Exception e)
		{
			throw e;
		}
	}


}
