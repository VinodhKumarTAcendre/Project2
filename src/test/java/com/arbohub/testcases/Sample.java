package com.arbohub.testcases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.print.attribute.standard.MediaSize.Other;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.arbohub.library.BaseLibrary;
import com.arbohub.library.GenericLibrary;
import com.arbohub.pages.HomePage;
import com.arbohub.pages.LoginPage;
import com.arbohub.pages.NewsHoroscopePage;

import io.appium.java_client.android.AndroidDriver;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Sample extends BaseLibrary {
	
	@Test(enabled = true, priority = 1, description = "Login as ABOF user, add to cart and Check the contents of Payment screen")
	@Parameters("device")
	public void testCaseOne(String device) throws TesseractException, InterruptedException, IOException
	{ System.out.println("Hello");
	HomePage h = new HomePage(driver);
	
		Thread.sleep(30000);
		h.getEleBookMarkIcn().click();
		File src = driver.getScreenshotAs(OutputType.FILE);
		String des = new File(System.getProperty("user.dir"))+"\\test-output";
		File fil = new File(des);
		FileUtils.copyFile(src, fil);
		ITesseract tess = new Tesseract();
		String txt = tess.doOCR(src);
		System.out.println(txt);
	}

}
