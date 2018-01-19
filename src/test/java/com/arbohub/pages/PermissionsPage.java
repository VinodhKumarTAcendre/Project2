/***********************************************************************
 * @author 			:		Yashi Priya
 * @description		: 		Page objects and re-usbale methods for Permissions,Welcome,Onboarding Screen and Terms & Conditions Modules
 * @module			:		Permissions, Welcome , Onboarding Screen , Terms and Conditions
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

public class PermissionsPage {
	
	AppiumDriver driver;
	
	public PermissionsPage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[contains(@text,'Allow following permission to proceed further')]")
	private WebElement elePermissionPopUp;

	public WebElement getElePermissionPopUp() {
		return elePermissionPopUp;
	}
	
	@FindBy(xpath = "//*[@text='dev-media.projectpnow.com']")
	private WebElement eleTermsConditionUrl;

	public WebElement getEleTermsConditionUrl() {
		return eleTermsConditionUrl;
	}
	
	//Allow AH Dev to make and manage phone calls? and Allow AH Dev to access this device's location? popups
	@FindBy(id ="com.android.packageinstaller:id/permission_message" )
	private WebElement eleLocationCallsPermissionPopups;
	
	public WebElement getEleLocationCallsPermissionPopups()
	{
		return eleLocationCallsPermissionPopups;
	}

	@FindBy(id ="com.panasonic.arbohub:id/tv_welcome")
	private WebElement eleWelcomeTxt;
	
	public WebElement getEleWelcomeTxt()
	{
		return eleWelcomeTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_choose_lang")
	private WebElement eleChooseLanguageTxt;
	
	public WebElement getEleChooseLanguageTxt()
	{
		return eleChooseLanguageTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/selectedLanguage")
	private WebElement eleLanguageDrpDwn;
	
	public WebElement getEleLanguageDrpDwn()
	{
		return eleLanguageDrpDwn;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/btn_next")
	private WebElement eleNextBtn;
	
	public WebElement getEleNextBtn()
	{
		return eleNextBtn;
	}
	
	//Smart Suggestion and World app text elements
	@FindBy(id = "com.panasonic.arbohub:id/tv_primary")
	private WebElement eleSmartSuggestionWorldInAppTxt;
	
	public WebElement getEleSmartSuggestionWorldInAppTxt()
	{
		return eleSmartSuggestionWorldInAppTxt;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/btn_getstarted")
	private WebElement eleGetStartedBtn;
	
	public WebElement getEleGetStartedBtn()
	{
		return eleGetStartedBtn;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/agree_checkbox")
	private WebElement eleTermsConditionsChkBox;
	
	public WebElement getEleTermsConditionsChkBox()
	{
		return eleTermsConditionsChkBox;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/terms_conditions")
	private WebElement eleTermsConditionsLnk;
	
	public WebElement getEleTermsConditionsLnk()
	{
		return eleTermsConditionsLnk;
	}
	
	@FindBy(id = "com.panasonic.arbohub:id/tv_okay")
	private WebElement eleOKBtn;
	
	public WebElement getEleOKBtn()
	{
		return eleOKBtn;
	}
	
	@FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	private WebElement eleAllowBtn;
	
	public WebElement getEleAllowBtn()
	{
		return eleAllowBtn;
	}
	
	@FindBy(id = "com.android.packageinstaller:id/permission_deny_button")
	private WebElement eleDenyBtn;
	
	public WebElement getEleDenyBtn()
	{
		return eleDenyBtn;
	}
	
	@FindBy(id = "com.android.packageinstaller:id/permission_deny_button")
	private List<WebElement> eleLanguageOptnList;
	
	public List<WebElement> getEleLanguageOptnList()
	{
		return eleLanguageOptnList;
	}
	
	public void verifyAllowDenyBtns(PermissionsPage permissionPage)
	{
		GenericLibrary.elementStatus(permissionPage.getEleAllowBtn(), permissionPage.getEleLocationCallsPermissionPopups().getText()+" popup with "+permissionPage.getEleAllowBtn().getText()+" button", "displayed");
		GenericLibrary.elementStatus(permissionPage.getEleDenyBtn(), permissionPage.getEleLocationCallsPermissionPopups().getText()+" popup with "+permissionPage.getEleDenyBtn().getText()+" button", "displayed");
	}
	
	public void toHandlePermissionPopups()
	{
		getEleOKBtn().click();
		getEleAllowBtn().click();
		getEleAllowBtn().click();
		getEleNextBtn().click();
		eleGetStartedBtn.click();
		
	}
}
