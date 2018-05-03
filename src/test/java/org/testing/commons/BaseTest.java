package org.testing.commons;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseTest {

	protected WebDriver driver;
	public static final Logger log = Logger.getLogger(BaseTest.class.getName());

	private void setDriver(String browserType, String baseURL) {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(baseURL);
			break;
		}
	}

	private WebDriver initChromeDriver(String baseURL) {
		log.info("Launching google chrome browser..");
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/test/resources/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
	}

	private static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	@BeforeClass(alwaysRun = true)
	public void initializeBaseTest() {
		try {
			log.info("Initiate browser..");
			setDriver("chrome", "http://www.practiceselenium.com/");
			String baseDirectory = System.getProperty("user.dir");
			String log4jConfPath = baseDirectory + "/src/test/resources/config/log4j.properties";
			PropertyConfigurator.configure(log4jConfPath);
		} catch (Exception e) {
			System.out.println("Error:" + e.getStackTrace());
		}
	}

	@AfterMethod
	public void takeScreenshotIfFailed(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				log.info("Taking failed test screenshot..");
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File("./FailScreenShots/" + "failed_" + result.getName().toLowerCase()
						+ "_" + timestamp() + ".png"));
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}
		}
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.close();
		driver.quit();
		log.info("Clean up activity: Closed all browser instances..");
	}

}