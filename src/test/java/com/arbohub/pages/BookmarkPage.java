package com.arbohub.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.arbohub.library.GenericLibrary;

import io.appium.java_client.AppiumDriver;

public class BookmarkPage {
	
AppiumDriver driver;
	
	public BookmarkPage(AppiumDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@text='No Bookmarks found.']")
	private WebElement eleNoBookmarksTxt;
	public WebElement getEleNoBookmarksTxt()
	{
		return eleNoBookmarksTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/iv_language")
	private WebElement eleLanguageLnk;
	public WebElement getEleLanguageLnk()
	{
		return eleLanguageLnk;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/iv_language_value")
	private WebElement eleLanguageValueTxt;
	public WebElement getEleLanguageValueTxt()
	{
		return eleLanguageValueTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/iv_preferences")
	private WebElement elePreferencesLnk;
	public WebElement getElePreferencesLnk()
	{
		return elePreferencesLnk;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/iv_notification_settings")
	private WebElement eleNotiSettingsLnk;
	public WebElement getEleNotiSettingsLnk()
	{
		return eleNotiSettingsLnk;
	}
	
	@FindBy(xpath = "//*[@text='Preferred Language']")
	private WebElement elePrefrdLanguagePopup;
	public WebElement getElePrefrdLanguagePopup()
	{
		return elePrefrdLanguagePopup;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/rb_english")
	private WebElement eleEngRadioBtn;
	public WebElement getEleEngRadioBtn()
	{
		return eleEngRadioBtn;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/rb_hindi")
	private WebElement eleHindiRadioBtn;
	public WebElement getEleHindiRadioBtn()
	{
		return eleHindiRadioBtn;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_cancel")
	private WebElement eleCANCELBtn;
	public WebElement getEleCANCELBtn()
	{
		return eleCANCELBtn;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_confirm")
	private WebElement eleCONFIRMBtn;
	public WebElement getEleCONFIRMBtn()
	{
		return eleCONFIRMBtn;
	}
	
	public void bookmarkNews(HomePage homePage , LoginPage loginPage, String news)
	{
		homePage.getEleBookMarkIcn().click();
		loginPage.getEleHamburgerMenu().click();
		loginPage.getEleBookmarksLnk().click();
		GenericLibrary.elementTextCompare(news, homePage.getEleNewsLink(), homePage.getEleNewsLink().getText());

	}
	
	public void verifyBookmarkedNews(HomePage homePage , LoginPage loginPage ,String sBackArrow)
	{
		homePage.getEleNewsLink().click();
		GenericLibrary.elementStatus(homePage.getEleNewsSourceHeadingTxt(), homePage.getEleNewsSourceHeadingTxt()+" news source screen", "displayed");
		GenericLibrary.elementStatus(homePage.getEleNewsTitle(), homePage.getEleNewsTitle().getText()+" title", "displayed");
		GenericLibrary.elementStatus(homePage.getEleBackArrowIcn(), sBackArrow, "displayed");
		homePage.getEleBackArrowIcn().click();
		GenericLibrary.elementStatus(loginPage.getEleBookmarksHeaderTxt(), loginPage.getEleBookmarksHeaderTxt().getText()+" screen heading", "displayed");
		
	}
	
	public void setLanguage(LoginPage loginPage , String sHomeScreen)
	{
		getEleLanguageLnk().click();
		GenericLibrary.elementStatus(getElePrefrdLanguagePopup(), getElePrefrdLanguagePopup().getText()+" popup ", "displayed");
		GenericLibrary.elementStatus(getEleEngRadioBtn(), getEleEngRadioBtn().getText()+" radio button ", "displayed");
		GenericLibrary.elementStatus(getEleHindiRadioBtn(), getEleHindiRadioBtn().getText()+" radio button ", "displayed");
		GenericLibrary.elementStatus(getEleCANCELBtn(), getEleCANCELBtn().getText()+" button ", "displayed");
		GenericLibrary.elementStatus(getEleCONFIRMBtn(), getEleCONFIRMBtn()+" button ", "displayed");
		getEleHindiRadioBtn().click();
		getEleCONFIRMBtn().click();
		GenericLibrary.elementStatus(loginPage.getEleHamburgerMenu(), sHomeScreen, "displayed");
		loginPage.getEleHamburgerMenu().click();
		loginPage.getEleSettingsLnk().click();
		GenericLibrary.elementTextCompare("Hindi", getEleLanguageValueTxt(), getEleLanguageValueTxt().getText()+" as preferred language");
		
	}
	

}
