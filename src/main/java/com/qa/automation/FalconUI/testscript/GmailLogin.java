package com.qa.automation.FalconUI.testscript;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.qa.automation.FalconUI.testsuite.SampleTestSuiteBase;
import com.qa.automation.FalconUI.pages.GmailLoginPage;


public class GmailLogin extends SampleTestSuiteBase {
	private ReportLogService report = new ReportLogServiceImpl(GmailLogin.class);
	GmailLoginPage gmailpage;
	
	@Test
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void gmailLogin(String os, String osVersion, String br, String browserVersion) {
		// Login to the Gmail and log out

		report.info("Opening browser: "+ br);
		browser.openURL("https://www.gmail.com", os, osVersion, br, browserVersion);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
		
		gmailpage=new GmailLoginPage(browser);
		
		report.info("calling the page objects method for gmail login");
		gmailpage.enterUsername();
		gmailpage.enterPassword();
		gmailpage.verifyAccount();
		gmailpage.signOut();
		

}
	
}
