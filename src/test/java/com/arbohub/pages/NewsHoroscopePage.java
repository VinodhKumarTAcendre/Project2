/***********************************************************************
 * @author 			:		Yashi Priya
 * @description		: 		Page objects and re-usbale methods for NewsUpdate and Horoscope Modules
 * @module			:		NewsUpdate and Horoscope
 * @reusable methods : 		
 * 														
 */

package com.arbohub.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.arbohub.library.GenericLibrary;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;

import io.appium.java_client.AppiumDriver;
import net.sourceforge.tess4j.TesseractException;

public class NewsHoroscopePage {
	
	AppiumDriver driver;
	
	public NewsHoroscopePage(AppiumDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[contains(@class,'android.support.v7.app.ActionBar$Tab']")
	private List<WebElement> eleNewsCategoryTabsLst;
	
	public List<WebElement> getEleNewsCategoryTabsLst()
	{
		return eleNewsCategoryTabsLst;
	}
	
	@FindBy(xpath = "//*[@text='ON']")
	private WebElement eleToggleSwitch;
	
	public WebElement getEleToggleSwitch()
	{
		return eleToggleSwitch;
	}
	
	@FindBy(xpath = "//*[@text='OFF']")
	private WebElement eleToggleOFFSwitch;
	
	public WebElement getEleToggleOFFSwitch()
	{
		return eleToggleOFFSwitch;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_horoscope_updates_tag")
	private WebElement eleHoroscopeUpdatesTagTxt;
	
	public WebElement getEleHoroscopeUpdatesTagTxt()
	{
		return eleHoroscopeUpdatesTagTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/zoadic_sign_iv")
	private List<WebElement> eleZodiacSignImgList;
	
	public List<WebElement> getEleZodiacSignImgList()
	{
		return eleZodiacSignImgList;
	}
	
	@FindBy(className = "android.support.v7.app.ActionBar$Tab")
	private List<WebElement> eleHoroscopeDaysBtnList;
	
	public List<WebElement> getEleHoroscopeDaysBtnList()
	{
		return eleHoroscopeDaysBtnList;
	}
	
	@FindBy(xpath = "//*[@text='CURRENT AFFAIRS']")
	private WebElement eleCURRENTAFFAIRStab;
	
	public WebElement getEleCURRENTAFFAIRStab()
	{
		return eleCURRENTAFFAIRStab;
	}
	
	@FindBy(xpath = "//*[@text='ENTERTAINMENT']")
	private WebElement eleENTERTAINMENTtab;
	
	public WebElement getEleENTERTAINMENTtab()
	{
		return eleENTERTAINMENTtab;
	}
	
	@FindBy(xpath = "//*[@text='TECHNOLOGY']")
	private WebElement eleTECHNOLOGYtab;
	
	public WebElement getEleTECHNOLOGYtab()
	{
		return eleTECHNOLOGYtab;
	}
	
	@FindBy(xpath = "//*[@text='SPORTS']")
	private WebElement eleSPORTStab;
	
	public WebElement getEleSPORTStab()
	{
		return eleSPORTStab;
	}
	
	@FindBy(xpath = "//*[@text='LOCAL']")
	private WebElement eleLOCALtab;
	
	public WebElement getEleLOCALtab()
	{
		return eleLOCALtab;
	}
	
	@FindBy(xpath = "//*[@text='BUSINESS']")
	private WebElement eleBUSINESStab;
	
	public WebElement getEleBUSINESStab()
	{
		return eleBUSINESStab;
	}
	
	@FindBy(xpath = "//*[@text='WORLD']")
	private WebElement eleWORLDtab;
	
	public WebElement getEleWORLDtab()
	{
		return eleWORLDtab;
	}
	
	@FindBy(xpath = "//*[@text='LIFESTYLE']")
	private WebElement eleLIFESTYLEtab;
	
	public WebElement getEleLIFESTYLEtab()
	{
		return eleLIFESTYLEtab;
	}
	
	@FindBy(xpath = "//*[@text='LIFE']")
	private WebElement eleLIFEtab;
	
	public WebElement getEleLIFEtab()
	{
		return eleLIFEtab;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_data")
	private WebElement eleHoroscopeDetailTxt;
	
	public WebElement getEleHoroscopeDetailTxt()
	{
		return eleHoroscopeDetailTxt;
	}
	
	public void verifyNewsTabs(WebElement element , String expectedValue)
	{
		GenericLibrary.elementStatus(element, expectedValue, "displayed");
		element.click();
	}
	
	public void toVerifytoastMsg(String expectedMsg) throws TesseractException
	{
		String actualMsg = GenericLibrary.getToastMsgText();
		if(actualMsg.contains(expectedMsg))
		{
			NXGReports.addStep(expectedMsg +" toast message is successfully displayed", LogAs.PASSED,null);
		}
		else
		{
			NXGReports.addStep(expectedMsg+" toast message is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
	}
}
