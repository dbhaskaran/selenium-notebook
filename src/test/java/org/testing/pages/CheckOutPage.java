package org.testing.pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testing.commons.CommonTest;

public class CheckOutPage extends CommonTest {

	WebDriver driver;
	public static final Logger log = Logger.getLogger(CheckOutPage.class.getName());

	@FindBy(className = "span6")
	WebElement emailBox;
	@FindBy(id = "name")
	WebElement nameBox;
	@FindBy(id = "address")
	WebElement addrBox;
	@FindBy(id = "card_type")
	WebElement cardType;
	@FindBy(id = "card_number")
	WebElement cardNumber;
	@FindBy(id = "cardholder_name")
	WebElement cardName;
	@FindBy(id = "verification_code")
	WebElement verificationCode;
	@FindBy(className = "btn")
	WebElement orderBtn;

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyPageTitle() throws IOException {
		if (driver.getTitle().toString().contains(getObject().getProperty("checkOutPageTitle")))
			return true;
		return false;
	}

	public void enterCheckOutDetails() throws InterruptedException {
		log.info("Entering Checkout details..");
		log.info("Entering email address in email field..");
		emailBox.sendKeys("tester@teashop.com");
		log.info("Entering Name in Name field..");
		nameBox.sendKeys("Curious Tester");
		log.info("Entering address in address field..");
		addrBox.sendKeys("111 Ferry Plaza Circle");
		log.info("Entering card type in card type field..");
		cardType.sendKeys("Visa");
		log.info("Entering card number in card number field..");
		cardNumber.sendKeys("4111 1111 1111 1111");
		log.info("Entering Name in CardName field..");
		cardName.sendKeys("Curious Tester");
		log.info("Entering verification code in verification field..");
		verificationCode.sendKeys("407");
	}

	public MenuPage placeOrder() throws InterruptedException {
		log.info("Placing Order..");
		orderBtn.click();
		log.info("Clicking Place Order..");
		return new MenuPage(driver);
	}

}
