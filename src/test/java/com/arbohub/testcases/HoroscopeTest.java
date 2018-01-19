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

import com.arbohub.pages.PermissionsPage;

public class HoroscopeTest extends BaseLibrary2{
	
	LoginPage loginPage;
	HomePage homePage;
	NewsHoroscopePage newsHoroscopePage;
	CricketCelebrationsPage cricketCelebrationsPage;
	String[] sData = null;
		
	@Parameters("device")
	@Test(enabled = true, priority = 1, description ="To verify Horoscope screen elements")
	public void testHoroscopeScreen(String device) throws Exception
	{
		sData = HtmlReportListener.sDataGuest;
		HtmlReportListener.test = HtmlReportListener.extent.createTest("testHoroscopeScreen","To verify Horoscope screen elements");
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		newsHoroscopePage = new NewsHoroscopePage(driver);
		cricketCelebrationsPage = new CricketCelebrationsPage(driver);
		try
		{
			loginPage.getEleHamburgerMenu().click();
			loginPage.getEleHoroscopeLnk().click();
			GenericLibrary.elementStatus(loginPage.getEleHoroscopeHeaderTxt(), loginPage.getEleHoroscopeHeaderTxt().getText()+" text", "displayed");
			GenericLibrary.elementStatus(newsHoroscopePage.getEleHoroscopeUpdatesTagTxt(), newsHoroscopePage.getEleHoroscopeUpdatesTagTxt().getText(), "displayed");
			GenericLibrary.elementStatus(newsHoroscopePage.getEleToggleSwitch(), sData[1], "displayed");
			newsHoroscopePage.getEleToggleSwitch().click();
			GenericLibrary.elementStatus(newsHoroscopePage.getEleToggleOFFSwitch(), sData[2], "displayed");
			newsHoroscopePage.getEleToggleOFFSwitch().click();
			GenericLibrary.elementStatus(newsHoroscopePage.getEleToggleSwitch(), sData[3], "displayed");
			for(WebElement eleZodiacSignImg:newsHoroscopePage.getEleZodiacSignImgList())
			{
				int i=4;
				GenericLibrary.elementStatus(eleZodiacSignImg, sData[i], "displayed");
				eleZodiacSignImg.click();
				for(int j=0 ; j<newsHoroscopePage.getEleHoroscopeDaysBtnList().size() ; j++)
				{
					GenericLibrary.elementStatus(newsHoroscopePage.getEleHoroscopeDaysBtnList().get(j), sData[i]+" "+newsHoroscopePage.getEleHoroscopeDaysBtnList().get(0).getText()+" "+sData[16], "displayed");
					newsHoroscopePage.getEleHoroscopeDaysBtnList().get(j).click();
					GenericLibrary.elementStatus(cricketCelebrationsPage.getEleCelebrationsDateTxt(), cricketCelebrationsPage.getEleCelebrationsDateTxt().getText()+" "+sData[18], "displayed");
					GenericLibrary.elementStatus(newsHoroscopePage.getEleHoroscopeDetailTxt(), sData[16]+" of "+newsHoroscopePage.getEleHoroscopeDaysBtnList().get(j).getText(), "displayed");
				}
				i++;
				loginPage.navigateBack(loginPage, sData[17]);
				loginPage.getEleHamburgerMenu().click();
				loginPage.getEleHoroscopeLnk().click();
			}
			
		}
		catch(Exception e)
		{
			throw(e);
		}
	}
}
