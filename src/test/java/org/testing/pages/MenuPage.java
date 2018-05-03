package org.testing.pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testing.commons.CommonTest;

public class MenuPage extends CommonTest{
	
	WebDriver driver;
	public static final Logger log = Logger.getLogger(MenuPage.class.getName());

	@FindBy(id = "wsb-button-00000000-0000-0000-0000-000451955160")
	WebElement greenTeaCheckout;
	@FindBy(id = "wsb-button-00000000-0000-0000-0000-000451959280")
	WebElement redTeaCheckout;
	@FindBy(id = "wsb-button-00000000-0000-0000-0000-000451961556")
	WebElement oolongTeaCheckout;

	public MenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyPageTitle() throws IOException {
		if (driver.getTitle().toString().contains(getObject().getProperty("menuPageTitle")))
			return true;
		return false;
	}
	
	public CheckOutPage checkOutGreenTea() throws InterruptedException {
		log.info("Checkout Green Tea..");
		greenTeaCheckout.click();
		log.info("Clicking Green Tea CheckOut..");
		return new CheckOutPage(driver);
	}
	
	public CheckOutPage checkOutRedTea() throws InterruptedException {
		log.info("Checkout Red Tea..");
		redTeaCheckout.click();
		log.info("Clicking Red Tea CheckOut..");
		return new CheckOutPage(driver);
	}
	
	public CheckOutPage checkOutOolongTea() throws InterruptedException {
		log.info("Checkout Oolong Tea..");
		oolongTeaCheckout.click();
		log.info("Clicking Oolong Tea CheckOut..");
		return new CheckOutPage(driver);
	}

}
