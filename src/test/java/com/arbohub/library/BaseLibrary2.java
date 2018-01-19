package com.arbohub.library;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.kirwa.nxgreport.NXGReports;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseLibrary2 extends BaseLibrary{
	
	public DesiredCapabilities capabilities = null;
	//public static AppiumDriver driver = null;
	public static String sDirPath = System.getProperty("user.dir");
	public static String sConfigPath = sDirPath+"\\config.properties";
	public String sApp =  GenericLibrary.getConfigValue(sConfigPath,"TestApp");
	
	
	/*
	 * @author: Yashi Priya
	 * Description:Desired capabilities to launch app
	 */
	
	@BeforeMethod
	public void launchApp() throws MalformedURLException
	{
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", GenericLibrary.getConfigValue(sConfigPath, "AutomationName"));
		capabilities.setCapability("deviceName", GenericLibrary.getConfigValue(sConfigPath, "DeviceName"));
		capabilities.setCapability("platformName", GenericLibrary.getConfigValue(sConfigPath, "PlatformName"));
		capabilities.setCapability("platformVersion", GenericLibrary.getConfigValue(sConfigPath, "PlatformVersion"));
		capabilities.setCapability("app", sDirPath+"\\"+sApp+".apk");
		capabilities.setCapability("noReset", GenericLibrary.getConfigValue(sConfigPath, "clearCache"));
		capabilities.setCapability("newCommandTimeOut",GenericLibrary.getConfigValue(sConfigPath, "TimeOut") );
		driver = new AndroidDriver(new URL(GenericLibrary.getConfigValue(sConfigPath, "AppiumServer_Url")),capabilities);
		NXGReports.setWebDriver(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	/*
	 * @author: Yashi Priya
	 * Description: Method for quiting the entire session
	 */
	@AfterMethod
	public void tearDown()
	{
		driver.closeApp();
	}
	

}
