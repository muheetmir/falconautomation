package com.qa.automation.FalconUI.pages;


import java.util.Properties;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.ui.seleniuminterfaces.IKeys.KeyType;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.falcon.automation.verifyresult.VerificationManager;
import com.qa.automation.FalconUI.config.GmailLogin;

import com.qa.automation.FalconUI.helper.GmailLoginHelper;


public class GmailLoginPage extends GmailLoginHelper{
	Browser browser;
	private ReportLogService report=new ReportLogServiceImpl(GmailLoginPage.class);
	
	static Properties page=loadProperties(GmailLogin.gmail_login_locators);

	public GmailLoginPage(Browser browser){
		this.browser=browser;
	}
	
	public void enterUsername() 
	{
		
			String username_id=page.getProperty("gmail_username_id");
			browser.getWait().HardPause(2000);
			String uname=page.getProperty("username");
			report.info("Entering the username");
			browser.getTextField().enterTextField(LocatorType.ID, username_id, uname);
			browser.getKey().pressKey(LocatorType.ID,username_id , KeyType.ENTER);
			browser.getWait().HardPause(5000);
	}
	
	public void enterPassword()
	{
		report.info("Entering the password and pressing enter");
		String password=page.getProperty("gmail_password_name");
		String pwd=page.getProperty("pwd");
		browser.getTextField().enterTextField(LocatorType.NAME, password, pwd);
		browser.getKey().pressKey(LocatorType.NAME, password, KeyType.ENTER);
		browser.getWait().HardPause(4000);
	}
	
	public void verifyAccount()
	{
		report.info("clikcing on google account icon");
		String gmail_acc_btn=page.getProperty("gmail_acccount_icon_xpath");
		browser.getClick().performClick(LocatorType.XPATH,gmail_acc_btn);
		browser.getWait().HardPause(3000);
		String mail_id_element=page.getProperty("gmail_username_verify_xpath");
		
		report.info("Verifying the username details");
		String mail_id=browser.getFindFromBrowser().findElementByXpath(mail_id_element).getText();
		VerificationManager.verifyString(mail_id, "testapple063@gmail.com", "Verifying the username");	
	}
	
	public void signOut()
	{
		
		String signout_btn=page.getProperty("gmail_signout_xpath");
		report.info("Signing out the gmail account");
		browser.getClick().performClick(LocatorType.XPATH, signout_btn);
	}
	
	
}
	
