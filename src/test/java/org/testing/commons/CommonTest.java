package org.testing.commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.asserts.SoftAssert;

public class CommonTest extends BaseTest{
	
	/*
	 * The following methods are common methods
	 */
	public SoftAssert softAssert() {
		SoftAssert soft_assert = new SoftAssert();
		return soft_assert;
	}
	
	public Properties getObject() throws IOException{
		String workingDirectory = System.getProperty("user.dir");
		FileInputStream objfile = new FileInputStream(new File(workingDirectory+"/src/test/resources/config/object.properties"));
		Properties obj = new Properties();
		obj.load(objfile);
		return obj;
	}
	
	public boolean getPageTitle(String title) throws IOException{
		if (driver.getPageSource().contains(title)) return true;			
		return false;		
	}	
		
}