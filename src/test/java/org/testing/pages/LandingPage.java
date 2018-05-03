package org.testing.pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testing.commons.CommonTest;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends CommonTest {

	WebDriver driver;
	public static final Logger log = Logger.getLogger(LandingPage.class.getName());

	@FindBy(id = "wsb-button-00000000-0000-0000-0000-000450914890")
	WebElement herbalTea;
	@FindBy(id = "wsb-button-00000000-0000-0000-0000-000450914897")
	WebElement looseTea;
	@FindBy(id = "wsb-button-00000000-0000-0000-0000-000450914899")
	WebElement flavoredTea;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle() throws IOException {
		return driver.getTitle().toString();
	}

	public MenuPage selectHerbalTea() throws InterruptedException {
		log.info("Selecting Herbal Tea menu..");
		herbalTea.click();
		log.info("Clicking Herbal Tea menu..");
		return new MenuPage(driver);
	}

	public MenuPage selectLooseTea() throws InterruptedException {
		log.info("Selecting Loose Tea menu..");
		looseTea.click();
		log.info("Clicking Loose Tea menu..");
		return new MenuPage(driver);
	}

	public MenuPage selectFlavoredTea() throws InterruptedException {
		log.info("Selecting Flavored Tea menu..");
		flavoredTea.click();
		log.info("Clicking Flavored Tea menu..");
		return new MenuPage(driver);
	}

}
