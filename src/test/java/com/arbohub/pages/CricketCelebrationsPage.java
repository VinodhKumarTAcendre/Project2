package com.arbohub.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

import com.arbohub.library.GenericLibrary;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class CricketCelebrationsPage {
	
	AppiumDriver driver;
	
	public CricketCelebrationsPage(AppiumDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/country_1")
	private WebElement eleCountryOneTxt;
	public WebElement getEleCountryOneTxt()
	{
		return eleCountryOneTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/country_2")
	private WebElement eleCountryTwoTxt;
	public WebElement getEleCountryTwoTxt()
	{
		return eleCountryTwoTxt;
	}
	
	@FindBy(id = "android.support.v7.app.ActionBar$Tab")
	private WebElement eleInningsTxt;
	public WebElement getEleInningsTxt()
	{
		return eleInningsTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_player_name")
	private List<WebElement> elePlayerNameTxt;
	public List<WebElement> getElePlayerNameTxt()
	{
		return elePlayerNameTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_details")
	private List<WebElement> elePlayerDetail;
	public List<WebElement> getElePlayerDetail()
	{
		return elePlayerDetail;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_score")
	private List<WebElement> eleScoreTxt;
	public List<WebElement> getEleScoreTxt()
	{
		return eleScoreTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_tournament_name")
	private WebElement eleTournamentNameTxt;
	public WebElement getEleTournamentNameTxt()
	{
		return eleTournamentNameTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_matchname")
	private WebElement eleMatchNameTxt;
	public WebElement getEleMatchNameTxt()
	{
		return eleMatchNameTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/iv_team_one")
	private WebElement eleTeamOneTxt;
	public WebElement getEleTeamOneTxt()
	{
		return eleTeamOneTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/iv_team_two")
	private WebElement eleTeamTwoTxt;
	public WebElement getEleTeamTwoTxt()
	{
		return eleTeamTwoTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/ll_second_team_score_layout")
	private WebElement eleTeamTwoScoreTxt;
	public WebElement getEleTeamTwoScoreTxt()
	{
		return eleTeamTwoScoreTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/ll_first_team_score_layout")
	private WebElement eleTeamOneScoreTxt;
	public WebElement getEleTeamOneScoreTxt()
	{
		return eleTeamOneScoreTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_header")
	private WebElement eleCricketCardDetailHeaderTxt;
	public WebElement getEleCricketCardDetailHeaderTxt()
	{
		return eleCricketCardDetailHeaderTxt;
	}
	
	@FindBy(xpath = "//*[@text='Extras']")
	private WebElement eleExtrasTxt;
	public WebElement getEleExtrasTxt()
	{
		return eleExtrasTxt;
	}
	
	@FindBy(xpath = "//*[@text='Total Runs']")
	private WebElement eleTotalRunsTxt;
	public WebElement getEleTotalRunsTxt()
	{
		return eleTotalRunsTxt;
	}
	
	@FindBy(xpath = "//*[@text='BOWLING']")
	private WebElement eleBOWLINGTxt;
	public WebElement getEleBOWLINGTxt()
	{
		return eleBOWLINGTxt;
	}
	
	@FindBy(id = "com.android.contacts:id/menu_search")
	private WebElement eleContactSrchBtn;
	public WebElement getEleContactSrchBtn()
	{
		return eleContactSrchBtn;
	}
	
	@FindBy(id = "com.android.contacts:id/cliv_name_textview")
	private WebElement eleContactNameTxt;
	public WebElement getEleContactNameTxt()
	{
		return eleContactNameTxt;
	}
	
	@FindBy(id = "com.android.contacts:id/menu_edit")
	private WebElement eleContactEditIcn;
	public WebElement getEleContactEditIcn()
	{
		return eleContactEditIcn;
	}
	
	@FindBy(xpath = "//*[@text='More fields']")
	private WebElement eleContactMorefieldsLnk;
	public WebElement getEleContactMorefieldsLnk()
	{
		return eleContactMorefieldsLnk;
	}
	
	@FindBy(id = "com.android.contacts:id/date_view")
	private WebElement eleContactDateDrpdwn;
	public WebElement getEleContactDateDrpdwn()
	{
		return eleContactDateDrpdwn;
	}
	
	
	@FindBy(id = "android:id/button1")
	private WebElement eleContactSetBtn;
	public WebElement getEleContactSetBtn()
	{
		return eleContactSetBtn;
	}
	
	@FindBy(id = "com.android.contacts:id/search_view")
	private WebElement eleContactSrchTxtFld;
	public WebElement getEleContactSrchTxtFld()
	{
		return eleContactSrchTxtFld;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_birthday_day")
	private WebElement eleCelebrationTodayTxt;
	public WebElement getEleCelebrationTodayTxt()
	{
		return eleCelebrationTodayTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/iv_call")
	private WebElement eleCelebrationCallIcn;
	public WebElement getEleCelebrationCallIcn()
	{
		return eleCelebrationCallIcn;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/iv_message")
	private WebElement eleCelebrationMsgIcn;
	public WebElement getEleCelebrationMsgIcn()
	{
		return eleCelebrationMsgIcn;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/iv_whatsapp")
	private WebElement eleCelebrationWatsAppIcn;
	public WebElement getEleCelebrationWatsAppIcn()
	{
		return eleCelebrationWatsAppIcn;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/iv_photo")
	private WebElement eleCelebrationContactImg;
	public WebElement getEleCelebrationContactImg()
	{
		return eleCelebrationContactImg;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/iv_celebrations")
	private WebElement eleCelebrationsImg;
	public WebElement getEleCelebrationsImg()
	{
		return eleCelebrationsImg;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/iv_celebrations")
	private WebElement eleDialPadCallBtn;
	public WebElement getEleDialPadCallBtn()
	{
		return eleDialPadCallBtn;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/iv_celebrations")
	private WebElement eleMsgApp;
	public WebElement getEleMsgApp()
	{
		return eleMsgApp;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/iv_celebrations")
	private WebElement eleCelebrationNameTxt;
	public WebElement getEleCelebrationNameTxt()
	{
		return eleCelebrationNameTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/iv_celebrations")
	private List<WebElement> eleCelebrationTabLst;
	public List<WebElement> getEleCelebrationTabLst()
	{
		return eleCelebrationTabLst;
	}
	
	@FindBy(xpath = "//*[@text='More options']")
	private WebElement eleContactMoreOptionsBtn;
	public WebElement getEleContactMoreOptionsBtn()
	{
		return eleContactMoreOptionsBtn;
	}
	
	@FindBy(xpath = "//*[@text='Delete']")
	private WebElement eleContactDeleteOptn;
	public WebElement getEleContactDeleteOptn()
	{
		return eleContactDeleteOptn;
	}
	
	@FindBy(xpath = "//*[@text='DELETE']")
	private WebElement eleContactDeleteBtn;
	public WebElement getEleContactDeleteBtn()
	{
		return eleContactDeleteBtn;
	}
	
	@FindBy(id = "com.android.contacts:id/floating_action_button")
	private WebElement eleAddContactBtn;
	public WebElement getEleAddContactBtn()
	{
		return eleAddContactBtn;
	}
	
	@FindBy(xpath = "//*[@text='Name']")
	private WebElement eleContactNameTxtFld;
	public WebElement getEleContactNameTxtFld()
	{
		return eleContactNameTxtFld;
	}
	
	@FindBy(xpath = "//*[@text='Phone']")
	private WebElement eleContactPhoneNumTxtFld;
	public WebElement getEleContactPhoneNumTxtFld()
	{
		return eleContactPhoneNumTxtFld;
	}
	
	@FindBy(id = "com.android.contacts:id/menu_save")
	private WebElement eleSaveContactBtn;
	public WebElement getEleSaveContactBtn()
	{
		return eleSaveContactBtn;
	}
	
	@FindBy(xpath = "//*[@text='BIRTHDAYS']")
	private WebElement eleBIRTHDAYSTab;
	public WebElement getEleBIRTHDAYSTab()
	{
		return eleBIRTHDAYSTab;
	}
	
	@FindBy(xpath = "//*[@text='ANNIVERSARIES']")
	private WebElement eleANNIVERSARIESTab;
	public WebElement getEleANNIVERSARIESTab()
	{
		return eleANNIVERSARIESTab;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_date")
	private WebElement eleCelebrationsDateTxt;
	public WebElement getEleCelebrationsDateTxt()
	{
		return eleCelebrationsDateTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_details_view")
	private WebElement eleNoCelebrationsTxt;
	public WebElement getEleNoCelebrationsTxt()
	{
		return eleNoCelebrationsTxt;
	}
	
	@FindBy(xpath = "//*[@text='Anniversary']")
	private WebElement eleAnniversaryOptn;
	public WebElement getEleAnniversaryOptn()
	{
		return eleAnniversaryOptn;
	}
	
	@FindBy(xpath = "//*[@text='Birthday']")
	private WebElement eleBirthdayOptn;
	public WebElement getEleBirthdayOptn()
	{
		return eleBirthdayOptn;
	}
	
	public void addContact(HomePage homePage, String sContactName , String sPhoneNumber, String sCelebrationName) throws InterruptedException
	{
		homePage.switchToContactsApp((AndroidDriver) driver);
		getEleContactSrchBtn().click();
		getEleContactSrchTxtFld().sendKeys(sContactName);
		if(eleContactNameTxt.isDisplayed())
		{
			getEleContactNameTxt().click();
			getEleContactMoreOptionsBtn().click();
			getEleContactDeleteOptn().click();
			getEleContactDeleteBtn().click();
			driver.navigate().back();
			getEleAddContactBtn().click();
			getEleContactNameTxtFld().sendKeys(sContactName);
			driver.hideKeyboard();
			GenericLibrary.scrollToElement(2, 0.98, 0.28, "down", getEleContactPhoneNumTxtFld(), driver);
			getEleContactPhoneNumTxtFld().sendKeys(sPhoneNumber);
			GenericLibrary.scrollToElement(2, 0.98, 0.28, "down", getEleContactDateDrpdwn(), driver);
			getEleContactDateDrpdwn().click();
			getEleContactSetBtn().click();
			if(sCelebrationName.equals("birthday"))
			{
				getEleBirthdayOptn().click();
				getEleBirthdayOptn().click();
			}
			else
			{
				getEleBirthdayOptn().click();
				getEleAnniversaryOptn().click();
			}
			getEleSaveContactBtn().click();
		}
		
		else
		{
			getEleAddContactBtn().click();
			getEleContactNameTxtFld().sendKeys(sContactName);
			driver.hideKeyboard();
			GenericLibrary.scrollToElement(2, 0.98, 0.28, "down", getEleContactPhoneNumTxtFld(), driver);
			getEleContactPhoneNumTxtFld().sendKeys(sPhoneNumber);
			GenericLibrary.scrollToElement(2, 0.98, 0.28, "down", getEleContactDateDrpdwn(), driver);
			getEleContactDateDrpdwn().click();
			getEleBirthdayOptn().click();
			getEleContactSetBtn().click();
			getEleSaveContactBtn().click();
		}
		
		homePage.switchToArboHubApp((AndroidDriver) driver);
	}
	
	public void verifyCelebrationsIcons(String sCallIcn , String sCallApp ,String sCelebrationsCard , String sMsgIcn ,String sMsgApp , String sWatsAppIcn)
	{
		GenericLibrary.elementStatus(getEleCelebrationCallIcn(), sCallIcn+" "+sCelebrationsCard, "displayed");
		getEleCelebrationCallIcn().click();
		GenericLibrary.elementStatus(getEleDialPadCallBtn(), sCallApp+" "+sCelebrationsCard, "displayed");
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		GenericLibrary.elementStatus(getEleCelebrationMsgIcn(), sMsgIcn+" "+sCelebrationsCard, "displayed");
		getEleCelebrationMsgIcn().click();
		GenericLibrary.elementStatus(getEleMsgApp(), sMsgApp+" "+sCelebrationsCard, "displayed");
		driver.navigate().back();
		GenericLibrary.elementStatus(getEleCelebrationWatsAppIcn(), sWatsAppIcn, "displayed");
		getEleCelebrationWatsAppIcn().click();
		
	}
	
	public void verifyCelebrationsCard(LoginPage loginPage , String sCelebrationsImg , String sContactName , String sContactImg , String sCelebrationsCard)
	{
		GenericLibrary.scrollToElement(5, 0.98, 0.28, "down", loginPage.getEleCelebrationsHeaderTxt(), driver);
		GenericLibrary.elementStatus(getEleCelebrationsImg(), sCelebrationsImg, "displayed");
		GenericLibrary.elementTextCompare(sContactName, getEleCelebrationNameTxt(), sContactName+" "+sCelebrationsCard);
		GenericLibrary.elementStatus(getEleCelebrationTodayTxt(), getEleCelebrationTodayTxt().getText()+" "+sCelebrationsCard,"dispalyed");
		GenericLibrary.elementStatus(getEleCelebrationContactImg(), sContactImg+" "+sCelebrationsCard, "displayed");
		
	}
	
	public void verifyContactNameAndCelebrationDate(String sContactName , String text)
	{
		GenericLibrary.elementTextCompare(sContactName, getEleContactNameTxt(), text);
		GenericLibrary.elementStatus(getEleCelebrationsDateTxt(), getEleCelebrationsDateTxt()+" as birhday date ", "displayed");
		
	}


}
