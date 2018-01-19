/***********************************************************************
 * @author 			:		Yashi Priya
 * @description		: 		Page objects and re-usbale methods for Home Module
 * @module			:		Home
 * @reusable methods : 		
 * 														
 */
package com.arbohub.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.arbohub.library.BaseLibrary;
import com.arbohub.library.GenericLibrary;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class HomePage {
	
	AppiumDriver driver;
	
	public HomePage(AppiumDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/iv_arbo")
	private WebElement eleArboIcn;
	
	public WebElement getEleArboIcn()
	{
		return eleArboIcn;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/iv_search")
	private WebElement eleSearchIcn;
	
	public WebElement getEleSearchIcn()
	{
		return eleSearchIcn;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_search")
	private WebElement eleSearchBar;
	
	public WebElement getEleSearchBar()
	{
		return eleSearchBar;
	}
	
	@FindBy(className = "android.widget.ImageButton")
	private WebElement eleBackArrowIcn;
	
	public WebElement getEleBackArrowIcn()
	{
		return eleBackArrowIcn;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/user_name")
	private WebElement eleHiUserTxt;
	
	public WebElement getEleHiUserTxt()
	{
		return eleHiUserTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/user_name")
	private WebElement eleTemperatureTxt;
	
	public WebElement getEleTemperatureTxt()
	{
		return eleTemperatureTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/rl_header")
	private List<WebElement> eleCricketCard;
	
	public List<WebElement> getEleCricketCard()
	{
		return eleCricketCard;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_footer_two")
	private WebElement eleViewAllLnk;
	
	public WebElement getEleViewAllLnk()
	{
		return eleViewAllLnk;
	}
	
	@FindBy(xpath = "//*[@text='News You May Be Interested In']")
	private WebElement eleNewsInterestedInTxt;
	
	public WebElement getEleNewsInterestedInTxt()
	{
		return eleNewsInterestedInTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/heading")
	private WebElement eleNewsLink;
	
	public WebElement getEleNewsLink()
	{
		return eleNewsLink;
	}
	
	//Web_View element
	@FindBy(xpath = "//app-title[@text='NewsPoint']")
	private WebElement eleNewsSourceHeadingTxt;
	
	public WebElement getEleNewsSourceHeadingTxt()
	{
		return eleNewsSourceHeadingTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/iv_news_bookmark")
	private WebElement eleBookMarkIcn;
	
	public WebElement getEleBookMarkIcn()
	{
		return eleBookMarkIcn;
	}
	
	@FindBy(xpath = "//*[@text='Astro Predictions']")
	private WebElement eleAstroPredictionTxt;
	
	public WebElement getEleAstroPredictionTxt()
	{
		return eleAstroPredictionTxt;
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Its Mandatory to login to navigate to Arbo. Thank you.']")
	private WebElement eleLoginMandatoryErrorPopup;
	
	public WebElement getEleLoginMandatoryErrorPopup()
	{
		return eleLoginMandatoryErrorPopup;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/select_sign_tv")
	private WebElement eleAstroPredictionDetailsCard;
	
	public WebElement getEleAstroPredictionDetailsCard()
	{
		return eleAstroPredictionDetailsCard;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_start_now_tag")
	private WebElement eleStartNowLnk;
	
	public WebElement getEleStartNowLnk()
	{
		return eleStartNowLnk;
	}
	
	@FindBy(id = "com.android.chrome:id/title_bar")
	private WebElement eleNewsTitle;
	
	public WebElement getEleNewsTitle()
	{
		return eleNewsTitle;
	}
	
	@FindBy(id = "com.android.chrome:id/close_button")
	private WebElement eleCloseNewsBtn;
	
	public WebElement getEleCloseNewsBtn()
	{
		return eleCloseNewsBtn;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_weather")
	private WebElement eleWeatherTxt;
	
	public WebElement getEleWeatherTxt()
	{
		return eleWeatherTxt;
	}
	
	public void switchToContactsApp(AndroidDriver driver) throws InterruptedException
	{
		driver.startActivity(GenericLibrary.getConfigValue(BaseLibrary.sConfigPath, "ThirdPartyAppPackage"), GenericLibrary.getConfigValue(BaseLibrary.sConfigPath, "ThirdPartyAppActivity"));
		Thread.sleep(5000);
	}
	
	public void switchToArboHubApp(AndroidDriver driver)
	{
		driver.startActivity(GenericLibrary.getConfigValue(BaseLibrary.sConfigPath, "AppPackage"), GenericLibrary.getConfigValue(BaseLibrary.sConfigPath, "AppActivity"));
	}

}
