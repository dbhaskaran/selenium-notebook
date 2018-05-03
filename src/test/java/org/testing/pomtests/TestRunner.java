package org.testing.pomtests;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testing.commons.CommonTest;
import org.testing.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRunner extends CommonTest{
	public static final Logger log = Logger.getLogger(TestRunner.class.getName());
	LandingPage landingpage;
	MenuPage menupage;
	CheckOutPage checkoutpage;

	@Test
	public void clickOnSeeHerbalTea() throws IOException, InterruptedException {
		log.info("Starting LandingPageTest..");
		landingpage = new LandingPage(driver);
		Assert.assertEquals(getPageTitle(getObject().getProperty("landingPageTitle")), true);
		menupage = landingpage.selectHerbalTea();
		Assert.assertEquals(getPageTitle(getObject().getProperty("menuPageTitle")), true);
		log.info("Completed LandingPageTest");
	}

	@Test(dependsOnMethods = { "clickOnSeeHerbalTea" })
	public void clickOnCheckOutRedTea() throws InterruptedException, IOException {
		log.info("CheckOut Red Tea");
		Assert.assertEquals(getPageTitle(getObject().getProperty("menuPageTitle")), true);
		checkoutpage = menupage.checkOutRedTea();
		Assert.assertEquals(getPageTitle(getObject().getProperty("checkOutPageTitle")), true);
	}

	@Test(dependsOnMethods = { "clickOnCheckOutRedTea" })
	public void clickOnPlaceOrderRedTea() throws IOException, InterruptedException {
		log.info("Entering Check Out Details");
		checkoutpage.enterCheckOutDetails();
		log.info("Placing Order");
		menupage = checkoutpage.placeOrder();
		log.info("Order Completed");
		Assert.assertEquals(getPageTitle(getObject().getProperty("menuPageTitle")), true);
		log.info("Back on Menu Page");
	}


}
