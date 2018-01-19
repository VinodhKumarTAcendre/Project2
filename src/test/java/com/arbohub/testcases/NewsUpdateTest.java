
package com.arbohub.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
import com.arbohub.pages.NewsHoroscopePage;
import com.arbohub.pages.PermissionsPage;

public class NewsUpdateTest extends BaseLibrary2 {
	
	PermissionsPage permissionPage;
	LoginPage loginPage;
	HomePage homePage;
	NewsHoroscopePage newsHoroscopePage;
	String[] sData = null;
	
		
	@Parameters("device")
	@Test(enabled = true, priority = 1, description ="To verify News screen elements")
	public void testNewsScreen(String device) throws Exception
	{
		permissionPage = new PermissionsPage(driver);
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		newsHoroscopePage = new NewsHoroscopePage(driver);
		sData = HtmlReportListener.sDataGuest;
		HtmlReportListener.test = HtmlReportListener.extent.createTest("testNewsScreen","To verify News screen elements");
		try 
		{
			loginPage.getEleHamburgerMenu().click();
			loginPage.getEleNewsUpdateLnk().click();
			GenericLibrary.elementStatus(loginPage.getEleBackArrowBtn(), sData[1], "displayed");
			newsHoroscopePage.verifyNewsTabs(newsHoroscopePage.getEleCURRENTAFFAIRStab(), sData[2]);
			newsHoroscopePage.verifyNewsTabs(newsHoroscopePage.getEleENTERTAINMENTtab(), sData[3]);
			newsHoroscopePage.verifyNewsTabs(newsHoroscopePage.getEleTECHNOLOGYtab(),sData[4]);
			newsHoroscopePage.verifyNewsTabs(newsHoroscopePage.getEleSPORTStab(), sData[5]);
			newsHoroscopePage.verifyNewsTabs(newsHoroscopePage.getEleLOCALtab(), sData[6]);
			newsHoroscopePage.verifyNewsTabs(newsHoroscopePage.getEleBUSINESStab(), sData[7]);
			newsHoroscopePage.verifyNewsTabs(newsHoroscopePage.getEleWORLDtab(), sData[8]);
			newsHoroscopePage.verifyNewsTabs(newsHoroscopePage.getEleLIFESTYLEtab(), sData[9]);
			newsHoroscopePage.verifyNewsTabs(newsHoroscopePage.getEleLIFEtab(), sData[10]);
			String news = homePage.getEleNewsLink().getText();
			homePage.getEleBookMarkIcn().click();
			newsHoroscopePage.toVerifytoastMsg(sData[11]);
			homePage.getEleBookMarkIcn().click();
			newsHoroscopePage.toVerifytoastMsg(sData[12]);
			homePage.getEleNewsLink().click();
			GenericLibrary.elementStatus(homePage.getEleNewsSourceHeadingTxt(), sData[12], "displayed");
			GenericLibrary.elementTextCompare(news, homePage.getEleNewsTitle(), sData[13]);
			loginPage.navigateBack(loginPage, sData[15]);
		} 
		catch (Exception e) 
		{
			throw(e);
		}
	}

}
