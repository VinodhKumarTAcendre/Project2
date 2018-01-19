/***********************************************************************

* @author 			:		Yashi Priya
* @description		: 		TestNG annotated methods with launching app and closing app.
*/

package com.arbohub.library;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.kirwa.nxgreport.NXGReports;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;

public class BaseLibrary {
	public DesiredCapabilities capabilities = null;
	public static AppiumDriver driver = null;
	public static String sDirPath = System.getProperty("user.dir");
	public static String sConfigPath = sDirPath+"\\config.properties";
	public String sApp =  GenericLibrary.getConfigValue(sConfigPath,"TestApp");
	public AppiumDriverLocalService appiumService;
	public String appium_node_path = "C:/Program Files (x86)/Appium/node.exe";
	public String appium_JS_path = "C:/Program Files (x86)/Appium/node_modules/appium/bin/appium.js";
	
	/*@Parameters({"port"})*/
	/*@BeforeSuite
	public void startServer(String port)
	{
		appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingPort(Integer.parseInt(port)4723).usingDriverExecutable(new File(appium_node_path)).withAppiumJS(new File(appium_JS_path)));
		appiumService.start();
	}
	*/
	/*
	 * @author: Yashi Priya
	 * Description:Desired capabilities to launch app
	 */
	
	@BeforeTest
	public void launchApp() throws MalformedURLException
	{
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName", GenericLibrary.getConfigValue(sConfigPath, "AutomationName"));
		capabilities.setCapability("deviceName", GenericLibrary.getConfigValue(sConfigPath, "DeviceName"));
		capabilities.setCapability("platformName", GenericLibrary.getConfigValue(sConfigPath, "PlatformName"));
		capabilities.setCapability("platformVersion", GenericLibrary.getConfigValue(sConfigPath, "PlatformVersion"));
		capabilities.setCapability("app", sDirPath+"\\"+sApp+".apk");
		capabilities.setCapability("noReset", GenericLibrary.getConfigValue(sConfigPath, "UnclearCache"));
		capabilities.setCapability("newCommandTimeOut",GenericLibrary.getConfigValue(sConfigPath, "TimeOut") );
		driver = new AndroidDriver(new URL(GenericLibrary.getConfigValue(sConfigPath, "AppiumServer_Url")),capabilities);
		NXGReports.setWebDriver(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	/*
	 * @author: Yashi Priya
	 * Description: Method for quiting the entire session
	 */
	@AfterTest
	public void tearDown()
	{
		driver.closeApp();
	}
	
	/*public void stopServer()
	{
		appiumService.stop();
	}
*/
}
