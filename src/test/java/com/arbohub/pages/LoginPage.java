/***********************************************************************
 * @author 			:		Yashi Priya
 * @description		: 		Page objects and re-usbale methods for Login,GuestLogin and Menu Modules
 * @module			:		Login,GuestLogin and Menu 
 * @reusable methods : 		
 * 														
 */
package com.arbohub.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.arbohub.library.GenericLibrary;

import io.appium.java_client.AppiumDriver;

public class LoginPage {
	
	AppiumDriver driver;
	
	public LoginPage (AppiumDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_getStarted")
	private WebElement eleGetStartedTxt;
	
	public WebElement getEleGetStartedTxt()
	{
		return eleGetStartedTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/sign")
	private WebElement eleLoginTxt;
	
	public WebElement getEleLoginTxt()
	{
		return eleLoginTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/btn_facebook_login")
	private WebElement eleFacebookLoginBtn;
	
	public WebElement getEleFacebookLoginBtn()
	{
		return eleFacebookLoginBtn;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/btn_google_login")
	private WebElement eleGoogleLoginBtn;
	
	public WebElement getEleGoogleLoginBtn()
	{
		return eleGoogleLoginBtn;
	}
	
	@FindBy(className = "android.webkit.WebView")
	private WebElement eleFacebookLogo;
	
	public WebElement getEleFacebookLogo()
	{
		return eleFacebookLogo;
	}
	
	@FindBy(id = "com.google.android.gms:id/title")
	private WebElement eleChooseAcntPopup;
	
	public WebElement getEleChooseAcntPopup()
	{
		return eleChooseAcntPopup;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/btn_phone_login")
	private WebElement elePhnNumLoginBtn;
	
	public WebElement getElePhnNumLoginBtn()
	{
		return elePhnNumLoginBtn;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/skip_button")
	private WebElement eleSkipBtn;
	
	public WebElement getEleSkipBtn()
	{
		return eleSkipBtn;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/iv_profileImage")
	private WebElement eleDefaultProfilePicImg;
	
	public WebElement getEleDefaultProfilePicImg()
	{
		return eleDefaultProfilePicImg;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_profile")
	private WebElement eleUserNameTxt;
	
	public WebElement getEleUserNameTxt()
	{
		return eleUserNameTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/iv_menu")
	private WebElement eleHamburgerMenu;
	
	public WebElement getEleHamburgerMenu()
	{
		return eleHamburgerMenu;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/iv_triangle")
	private WebElement eleDropDwnIcn;
	
	public WebElement getEleDropDwnIcn()
	{
		return eleDropDwnIcn;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/iv_login")
	private WebElement eleSignInLnk;
	
	public WebElement getEleSignInLnk()
	{
		return eleSignInLnk;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_logout")
	private WebElement eleSignOutLnk;
	
	public WebElement getEleSignOutLnk()
	{
		return eleSignOutLnk;
	}
	
	//Not working
	//List of Hamburger Menu Options
	/*@FindBy(className= "android.widget.ImageView")
	private List<WebElement> eleMenuList;
	
	public List<WebElement> getEleMenuList()
	{
		return eleMenuList;
	}
	*/
	@FindBy(xpath = "//*[@text='News']")
	private WebElement eleNewsHeaderTxt;
	
	public WebElement getEleNewsHeaderTxt()
	{
		return eleNewsHeaderTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_horoscope_updates_tag")
	private WebElement eleHoroscopeHeaderTxt;
	
	public WebElement getEleHoroscopeHeaderTxt()
	{
		return eleHoroscopeHeaderTxt;
	}
	
	@FindBy(xpath = "//*[@text='Celebrations']")
	private WebElement eleCelebrationsHeaderTxt;
	
	public WebElement getEleCelebrationsHeaderTxt()
	{
		return eleCelebrationsHeaderTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/iv_news_bookmark")
	private WebElement eleBookmarksHeaderTxt;
	
	public WebElement getEleBookmarksHeaderTxt()
	{
		return eleBookmarksHeaderTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_settings_header")
	private WebElement eleSettingsHeaderTxt;
	
	public WebElement getEleSettingsHeaderTxt()
	{
		return eleSettingsHeaderTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/com_accountkit_title")
	private WebElement eleEnterMobNumTxt;
	
	public WebElement getEleEnterMobNumTxt()
	{
		return eleEnterMobNumTxt;
	}
	
	//Not working
	/*@FindBy(xpath = "//com.panasonic.arbohub:id/toolbar/android.widget.TextView")
	private WebElement eleMenuOptionScreenHeadr;
	
	public WebElement getEleMenuOptionScreenHeadr()
	{
		return eleMenuOptionScreenHeadr;
	}*/
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_home")
	private WebElement eleHomeLnk;
	
	public WebElement getEleHomeLnk()
	{
		return eleHomeLnk;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_news_update")
	private WebElement eleNewsUpdateLnk;
	
	public WebElement getEleNewsUpdateLnk()
	{
		return eleNewsUpdateLnk;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_horoscope")
	private WebElement eleHoroscopeLnk;
	
	public WebElement getEleHoroscopeLnk()
	{
		return eleHoroscopeLnk;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_cricket")
	private WebElement eleCricketLnk;
	
	public WebElement getEleCricketLnk()
	{
		return eleCricketLnk;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_birthday")
	private WebElement eleCelebrationsLnk;
	
	public WebElement getEleCelebrationsLnk()
	{
		return eleCelebrationsLnk;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_bookmarks")
	private WebElement eleBookmarksLnk;
	
	public WebElement getEleBookmarksLnk()
	{
		return eleBookmarksLnk;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_settings")
	private WebElement eleSettingsLnk;
	
	public WebElement getEleSettingsLnk()
	{
		return eleSettingsLnk;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/iv_back")
	private WebElement eleBackArrowBtn;
	
	public WebElement getEleBackArrowBtn()
	{
		return eleBackArrowBtn;
	}
	
	@FindBy(xpath = "//*[@text='Cricket']")
	private WebElement eleCricketHeadrTxt;
	
	public WebElement getEleCricketHeadrTxt()
	{
		return eleCricketHeadrTxt;
	}
	
	@FindBy(xpath = "//*[@text='Automation Cbt']")
	private WebElement eleGoogleLoginUserLnk;
	
	public WebElement getEleGoogleLoginUserLnk()
	{
		return eleGoogleLoginUserLnk;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/com_accountkit_phone_number")
	private WebElement eleMobileTxtFld;
	
	public WebElement getEleMobileTxtFld()
	{
		return eleMobileTxtFld;
	}
	
	@FindBy(id = "m_login_email")
	private WebElement eleFBUserNameTxtFld;
	
	public WebElement getEleFBUserNameTxtFld()
	{
		return eleFBUserNameTxtFld;
	}
	
	@FindBy(id = "m_login_password")
	private WebElement eleFBPassWordTxtFld;
	
	public WebElement getEleFBPassWordTxtFld()
	{
		return eleFBPassWordTxtFld;
	}
	
	@FindBy(xpath = "//*[@text='Log In ']")
	private WebElement eleFBLoginBtn;
	
	public WebElement getEleFBLoginBtn()
	{
		return eleFBLoginBtn;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/com_accountkit_next_button")
	private WebElement elePhnNextBtn;
	
	public WebElement getElePhnNextBtn()
	{
		return elePhnNextBtn;
	}
	
		
	public void navigateToMenuOptions(HomePage homepage , String sHomeScreen, WebElement menuOption , WebElement screenHeader , AppiumDriver driver)
	{
		getEleHamburgerMenu().click();
		GenericLibrary.elementStatus(menuOption, menuOption.getText()+" menu option", "displayed");
		menuOption.click();
		GenericLibrary.elementStatus(screenHeader, screenHeader.getText()+" screen", "displayed");
		driver.navigate().back();
		GenericLibrary.elementStatus(homepage.getEleHiUserTxt(), sHomeScreen, "dispalyed");
		eleHamburgerMenu.click();
	}
	
	public void navigateBack(LoginPage loginPage ,String sHomeScreen)
	{
		driver.navigate().back();
		GenericLibrary.elementStatus(loginPage.eleHamburgerMenu, sHomeScreen, "dispalyed");
	}
	
	
	
}
