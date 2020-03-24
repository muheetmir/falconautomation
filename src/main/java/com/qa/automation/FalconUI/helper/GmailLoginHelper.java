package com.qa.automation.FalconUI.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;

public class GmailLoginHelper {
	Browser browser;
	Properties prop = new Properties();
	String propertyFilePath = "src" + File.separator + "main" + File.separator + "resources" + File.separator
			+"pages"+File.separator+ "gmailloginpage.properties";

	 public static Properties loadProperties(String propertyFilePath ) { 
		 File file=new File(propertyFilePath);
		 FileInputStream fileInput=null; 
		 try {
			 fileInput=new FileInputStream(file);
		 }catch(FileNotFoundException e) { 
		e.printStackTrace(); } 
		Properties prop=new 
		Properties(); 
		try { 
			prop.load(fileInput); 
		}catch(IOException e) {
			e.printStackTrace();
			}
		return prop; 
	  }
	 
}
