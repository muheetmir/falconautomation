package com.qa.automation.FalconUI.testscript;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.ui.seleniuminterfaces.IKeys.KeyType;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.qa.automation.FalconUI.testsuite.SampleTestSuiteBase;
import com.qa.automation.FalconUI.pages.GooglePage;


public class SampleTestScript extends SampleTestSuiteBase{

	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	
	@Test(priority=1)
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void sampleTest(String os, String osVersion, String br, String browserVersion) {
		// write your first test script here
		// sample

		report.info("Opening browser: "+ br);
		browser.openURL("http://www.google.com", os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
		report.info("entering text: "+"Selenium");
		browser.getTextField().enterTextField(LocatorType.NAME, "q", "Selenium");
		//report.info("pressing enter key");
		report.info("Clicking on google search button");
		browser.getWait().HardPause(3000);
		browser.getKey().pressKey(LocatorType.NAME, "q", KeyType.ESCAPE);
		browser.getClick().performClick(LocatorType.XPATH, "//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']");
		//browser.getKey().pressKey(LocatorType.NAME, "q", KeyType.ENTER);
		report.info("waiting for 2 second");
		browser.getWait().HardPause(2000);
		String text = browser.getCurrentPageTitle();
		report.info("verifying page title");
		Verify.verifyString(text, "Selenium - Google Search", "Verifying String Message ");
		report.info("Navigating back");
		browser.getNavigate().back();
		browser.getWait().implicitWait(3000);


	}

	@Test(priority=2)
	public void sampleTest2()
	{
		report.info("cliking on link"+" gmail");
		browser.getClick().performClick(LocatorType.XPATH, "//a[contains(text(),'Gmail')]");
		browser.getWait().HardPause(3000);
		
		report.info("Verifying the gmail page title");
		String title=browser.getCurrentPageTitle();
		Verify.verifyString(title, "Gmail - Email from Google", " Verifying the gmail title text");
		browser.getNavigate().back();
		
	}
}
	

