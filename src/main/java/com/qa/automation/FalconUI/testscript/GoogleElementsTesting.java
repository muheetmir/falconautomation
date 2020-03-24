package com.qa.automation.FalconUI.testscript;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.qa.automation.FalconUI.testsuite.SampleTestSuiteBase;
import com.qa.automation.FalconUI.pages.GooglePage;

public class GoogleElementsTesting extends SampleTestSuiteBase {
	private ReportLogService report = new ReportLogServiceImpl(GoogleElementsTesting.class);
	GooglePage gpage;
	
	@Test
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void sampleTest3(String os, String osVersion, String br, String browserVersion) {
		// write your first test script here
		// sample

		report.info("Opening browser: "+ br);
		browser.openURL("http://www.google.com", os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
		gpage=new GooglePage(browser);
		report.info("executing the test cases using page object");
		report.info("Verifying search with google search button");
		gpage.search();
		report.info("Clikcing on I am feeling lucky button");
		gpage.click_on_ImfeelingLuckybtn();
		
		report.info("click on gmail link");
		gpage.clickGmailLink();
		
		report.info("click on images link");
		gpage.clickImagesLink();
		

}
	
}
