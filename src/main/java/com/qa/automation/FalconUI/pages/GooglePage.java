package com.qa.automation.FalconUI.pages;

import java.util.Properties;

import org.openqa.selenium.By;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.ui.seleniuminterfaces.IKeys.KeyType;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.qa.automation.FalconUI.config.GoogleFields;
import com.qa.automation.FalconUI.helper.ReadConfig;

public class GooglePage extends ReadConfig{
	Browser browser;
	private ReportLogService report=new ReportLogServiceImpl(GooglePage.class);
	
	static Properties page=loadProperties(GoogleFields.Googleelements);

	public GooglePage(Browser browser){
		this.browser=browser;
	}
	
	public void search()
	{	
		try {
			String text=page.getProperty("google_searchfield_name");
			report.info("Entering text in search text field box");
			browser.getTextField().enterTextField(LocatorType.NAME, text, "testing");
			browser.getWait().HardPause(3000);
			browser.getKey().pressKey(LocatorType.NAME, text, KeyType.ESCAPE);
			String clkBtn_googlesearch=page.getProperty("google_search_btn_xpath");
			browser.getClick().performClick(LocatorType.XPATH, clkBtn_googlesearch);
			browser.getWait().HardPause(2000);
			String title_text=browser.getCurrentPageTitle();
			Verify.verifyString(title_text, "testing - Google Search", "verifying testing text title");
			browser.getNavigate().back();
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	}
	
	public void click_on_ImfeelingLuckybtn()
	{
		
		try {
			String clkBtn_Imfeelinglucky=page.getProperty("google_im_feeling_lucky_btn_xpath");
			browser.getClick().performClick(LocatorType.XPATH, clkBtn_Imfeelinglucky);
			browser.getWait().HardPause(3000);
			String google_doodles=browser.getCurrentPageTitle();
			Verify.verifyString(google_doodles, "Google Doodles", "verifying google doodles title");
			browser.getNavigate().back();
			browser.getWait().HardPause(2000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void clickGmailLink()
	{
		try {
			String gmail_link=page.getProperty("gmail_link_xpath");
			browser.getClick().performClick(LocatorType.XPATH, gmail_link);
			browser.getWait().HardPause(2000);
			String gmail_title=browser.getCurrentPageTitle();
			Verify.verifyString(gmail_title, "Gmail - Email from Google","Verifying gmail title text");
			browser.getNavigate().back();
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}

	
	public void clickImagesLink()
	{
		try {
			String Image_link=page.getProperty("Images_link_xpath");
			browser.getClick().performClick(LocatorType.XPATH, Image_link);
			browser.getWait().HardPause(2000);
			String Images_title=browser.getCurrentPageTitle();
			Verify.verifyString(Images_title, "Google Images","Verifying Images title text");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
