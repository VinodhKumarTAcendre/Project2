/***********************************************************************
* @author 			:		Yashi Priya
* @description		: 		Application Indepent Methods
* @methods 			: 		getConfigValue(),toReadExcelData(),TouchAction methods, To check element status 
*/

package com.arbohub.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;

import io.appium.java_client.AppiumDriver;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class GenericLibrary {
	
	public static Dimension screenSize; 
	public static int screenHeight;
	public static int screenWidth;
	
	public static String sTestDataFile = BaseLibrary.sDirPath+"\\arbohub.xlsx";
	
	/*
	 * @author:Yashi Priya 
	 * Description: To read the basic environment settings data from config file based on Property file value
	 */
	public static String getConfigValue(String sFile, String sKey) {
		Properties prop = new Properties();
		String sValue = null;
		try {
			InputStream input = new FileInputStream(sFile);
			prop.load(input);
			sValue = prop.getProperty(sKey);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sValue;
	}
	
	 /*
	 * @author: Yashi Priya
	 * Description: To get visible page area screenshot
	 */
 public static String getVisibleAreaScreenshot(WebDriver driver,String screenshotName)
 {
	 TakesScreenshot ts=(TakesScreenshot)driver;
	 File source = ts.getScreenshotAs(OutputType.FILE);
	 String dest = System.getProperty("user.dir")+"//VisibleViewScreenshots//"+screenshotName+".png";
	 File destination =new File(dest);
	 try {
		FileUtils.copyFile(source, destination);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return dest;
 }
 
	
	
	/*
	 * @author:Yashi Priya 
	 * Description:To read test data from excel sheet based on TestcaseID
	 */
	public static String[] toReadExcelData(String sSheet , String sTestCaseID) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		String[] sData = null;
		FileInputStream fis = new FileInputStream(sTestDataFile);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sht = wb.getSheet(sSheet);
		int rowNum = sht.getLastRowNum();
		
		for (int i = 1; i<=rowNum ; i++)
		{
			if(sht.getRow(i).getCell(0).toString().equals(sTestCaseID))
			{
				int cellNum = sht.getRow(i).getLastCellNum();
				sData = new String[cellNum];
				
				for(int j = 0; j<cellNum ; j++)
				{
					sData[j] = sht.getRow(i).getCell(j).getStringCellValue();
				}
				
				break;
			}
		}
		return sData;
	}
	
	/*
	 * @author:Yashi Priya
	 * Description:Swipe Right to left based on device screen size
	 */
	public static void swipeRightToLeft(double startX , double endX, AppiumDriver driver)
	{
		driver = BaseLibrary.driver;
		screenSize = driver.manage().window().getSize();
		screenHeight = screenSize.height;
		screenWidth = screenSize.width;
		int starty = screenHeight/2;
		int startx = (int) (screenWidth*startX);
		int endx = (int) (screenWidth*endX);
		BaseLibrary.driver.swipe(startx, starty, endx, starty, 2000);
	}
	
	/*
	 * @author:Yashi Priya
	 * Description:Swipe Left to Right based on device size 
	 */
	public static void swipeLeftToRight(double startX , double endX , AppiumDriver driver)
	{
		driver = BaseLibrary.driver;
		screenSize = driver.manage().window().getSize();
		screenHeight = screenSize.height;
		screenWidth = screenSize.width;
		
		int starty = screenHeight/2;
		int startx = (int) (screenWidth*startX);
		int endx = (int) (screenWidth*endX);
		BaseLibrary.driver.swipe(endx, starty, startx, starty, 3000); 
	}
	
	
	/*
	 * @author:Yashi Priya
	 * Description:Swipe Bottom to Top based on device size 
	 */
	public static void swipeBottomToTop(double startY , double endY , AppiumDriver driver)
	{
		driver = BaseLibrary.driver;
		screenSize = driver.manage().window().getSize();
		screenHeight = screenSize.height;
		screenWidth = screenSize.width;
		
		int startx = screenWidth/2;
		int starty = (int) (screenHeight*startY);
		int endy = (int) (screenHeight*endY);
		BaseLibrary.driver.swipe(startx, starty, startx, endy, 3000);
	}
	
	/*
	 * @author:Yashi Priya
	 * Description:Swipe Top to Bottom based on device size 
	 */
	public static void swipeTopToBottom(double startY , double endY, AppiumDriver driver)
	{
		driver = BaseLibrary.driver;
		screenSize = driver.manage().window().getSize();
		screenHeight = screenSize.height;
		screenWidth = screenSize.width;
		
		int startx = screenWidth/2;
		int starty = (int) (screenHeight*startY);
		int endy = (int) (screenWidth*endY);
		BaseLibrary.driver.swipe(startx, endy, startx, starty, 3000);
	}
	
	
	/*
	 * @author:Yashi Priya
	 * Description: Method for Scrolling to particular element based on direction and device size
	 */
	public static void scrollToElement(int maxScroll , double start , double end , String scrollType , WebElement element , AppiumDriver driver)
	{
		while(maxScroll!=0)
		{
			try
			{
				if(element.isDisplayed())
				{
					maxScroll++;
					break;
				}
			}
			catch(Exception e)
			{
				switch(scrollType.toUpperCase()){
				case("DOWN"):
					swipeBottomToTop(start, end, driver);
					break;
				
				case("UP"):
					swipeTopToBottom(start, end, driver);
					break;
				
				case("LEFT"):
					swipeRightToLeft(start, end , driver);
					break;
				
				case("RIGHT"):
					swipeLeftToRight(start, end , driver);
					break;
				
				default:
					NXGReports.addStep("Scroll to element", LogAs.INFO, null);
					break;
				
				}
				
			}
			maxScroll--;
		}
	}
	
	/*
	 * @author:Yashi Priya
	 * Description: Tap on particular element based size co-orinates
	 */
	public static void tapOnElement(double x , double y)
	{
		int elementX = (int) (screenWidth*x);
		int elementY = (int) (screenHeight*y);
		BaseLibrary.driver.tap(1, elementX, elementY,1);
	}
	
	
	/*
	 * @author:Yashi Priya
	 * Description: handles webwiew and native_app mode
	 */
	public static void switchToView()
	{
		Set<String> contextNames = BaseLibrary.driver.getContextHandles();
		for(String contextName:contextNames)
		{
			if(contextName.contains("WEB_VIEW"))
			{
				BaseLibrary.driver.context(contextName);
			}
			else
			{
				BaseLibrary.driver.context(contextName);
			}
		}
	}
	
	/*
	 * @author:Yashi Priya
	 * Description: Validaing the Toast message based the value displayed
	 */
	public static String getToastMsgText() throws TesseractException
	{
		File srcFile = BaseLibrary.driver.getScreenshotAs(OutputType.FILE);
		ITesseract instance = new Tesseract();
		String toastMsgTxt = instance.doOCR(srcFile);
		System.out.println(toastMsgTxt);
		return toastMsgTxt;
	}
	
	/*
	 * @author:Yashi Priya 
	 * Description:Check the element status whether it is displayed, enabled or selected
	 */
	public static void elementStatus(WebElement element , String elementName , String checkType)
	{
		switch(checkType)
		{
		case("displayed"):
			try
			{
				element.isDisplayed();
				HtmlReportListener.test.pass(MarkupHelper.createLabel(elementName+" is successfully displayed", ExtentColor.BLUE));
				NXGReports.addStep(elementName +" is successfully displayed", LogAs.PASSED,null);
			}
			catch (Exception e) {
				HtmlReportListener.test.fail(MarkupHelper.createLabel(elementName+" is not displayed", ExtentColor.RED));
				HtmlReportListener.test.fail(elementName+ "Element not displayed failure screenshot is below: ");
				try {
					HtmlReportListener.test.addScreenCaptureFromPath(GenericLibrary.getVisibleAreaScreenshot(BaseLibrary.driver, elementName+" failure"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				NXGReports.addStep(elementName+" is not displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				// TODO: handle exception
			}
			break;
		
		case("enabled"):
			try
			{
				element.isEnabled();
				HtmlReportListener.test.pass(MarkupHelper.createLabel(elementName+" is successfully enabled", ExtentColor.BLUE));
				NXGReports.addStep(elementName+" is successfully enabled", LogAs.PASSED,null);
				}
			catch (Exception e) {
				HtmlReportListener.test.fail(MarkupHelper.createLabel(elementName+" is disabled", ExtentColor.RED));
				HtmlReportListener.test.fail(elementName+" not enabled failure screenshot is below: ");
				try {
					HtmlReportListener.test.addScreenCaptureFromPath(GenericLibrary.getVisibleAreaScreenshot(BaseLibrary.driver, elementName+" failure"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				NXGReports.addStep(elementName+" is not enabled", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			// TODO: handle exception
			}
			break;
			
		case("selected"):
			try
			{
				element.isSelected();
				HtmlReportListener.test.pass(MarkupHelper.createLabel(elementName+" is successfully selected", ExtentColor.BLUE));
				NXGReports.addStep(elementName+" is successfully selected", LogAs.PASSED,null);
				}
			catch (Exception e) {
				HtmlReportListener.test.fail(MarkupHelper.createLabel(elementName+" is not selected", ExtentColor.RED));
				HtmlReportListener.test.fail(elementName+" not selected failure screenshot is below: ");
				try {
					HtmlReportListener.test.addScreenCaptureFromPath(GenericLibrary.getVisibleAreaScreenshot(BaseLibrary.driver, elementName+" failure"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				NXGReports.addStep(elementName+" is not selected", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			// TODO: handle exception
			}
			break;
		}
	}
	
	/*
	 * @author:Yashi Priya 
	 * Description:Check the element text status whether it is equal to the expected text
	 */
	public static void elementTextCompare(String expectedText, WebElement element, String elementName)
	{
		try
		{
			element.getText().contains(expectedText);
			HtmlReportListener.test.pass(MarkupHelper.createLabel(elementName+" is successfully displayed", ExtentColor.BLUE));
			NXGReports.addStep(elementName+" is successfully displayed", LogAs.PASSED,null);
			}
		catch (Exception e) {
			HtmlReportListener.test.fail(MarkupHelper.createLabel(elementName+" is not enabled", ExtentColor.RED));
			HtmlReportListener.test.fail(elementName+" not displayed failure screenshot is below: ");
			try {
				HtmlReportListener.test.addScreenCaptureFromPath(GenericLibrary.getVisibleAreaScreenshot(BaseLibrary.driver, elementName+" failure"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			NXGReports.addStep(elementName+" is not displayed", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		// TODO: handle exception
		}
	}
	
	
	
	/*
	 * @author:Yashi Priya 
	 * Description:Check the element status whether it is not displayed, disabled or not selected.
	 */
	public static void elementNegativeStatus(WebElement element , String elementName , String checkType)
	{
		switch(checkType)
		{
		case("displayed"):
			try
			{
				element.isDisplayed();
				HtmlReportListener.test.fail(MarkupHelper.createLabel(elementName+" is displayed", ExtentColor.RED));
				HtmlReportListener.test.fail(elementName+" displayed against expectation failure screenshot is below: ");
				try {
					HtmlReportListener.test.addScreenCaptureFromPath(GenericLibrary.getVisibleAreaScreenshot(BaseLibrary.driver, elementName+" failure"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				NXGReports.addStep(elementName +" is displayed", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
			catch (Exception e) {
				HtmlReportListener.test.pass(MarkupHelper.createLabel(elementName+" is not displayed as expected", ExtentColor.BLUE));
				NXGReports.addStep(elementName+" is not displayed as expected", LogAs.PASSED,null);
				// TODO: handle exception
			}
			break;
		
		case("enabled"):
			try
		{
			element.isEnabled();
			HtmlReportListener.test.fail(MarkupHelper.createLabel(elementName+" is enabled", ExtentColor.RED));
			HtmlReportListener.test.fail(elementName+" enabled against expectation failure screenshot is below: ");
			try {
				HtmlReportListener.test.addScreenCaptureFromPath(GenericLibrary.getVisibleAreaScreenshot(BaseLibrary.driver, elementName+" failure"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			NXGReports.addStep(elementName+" is enabled", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			}
		catch (Exception e) {
			HtmlReportListener.test.pass(MarkupHelper.createLabel(elementName+" is successfully disabled", ExtentColor.BLUE));
			NXGReports.addStep(elementName+" is successfully disabled", LogAs.PASSED,null );
		// TODO: handle exception
		}
			break;
			
		case("selected"):
			try
			{
				element.isSelected();
				HtmlReportListener.test.fail(MarkupHelper.createLabel(elementName+" is selected", ExtentColor.RED));
				HtmlReportListener.test.fail(elementName+" selected against expectation failure screenshot is below: ");
				try {
					HtmlReportListener.test.addScreenCaptureFromPath(GenericLibrary.getVisibleAreaScreenshot(BaseLibrary.driver, elementName+" failure"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				NXGReports.addStep(elementName+" is selected", LogAs.FAILED,new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				}
			catch (Exception e) {
				HtmlReportListener.test.pass(MarkupHelper.createLabel(elementName+" is not selected as expected", ExtentColor.BLUE));
				NXGReports.addStep(elementName+" is not selected as expected", LogAs.PASSED, null);
			// TODO: handle exception
			}
			break;
		}
	}
	
}
