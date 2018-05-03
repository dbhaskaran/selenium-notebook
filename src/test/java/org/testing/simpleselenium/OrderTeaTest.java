package org.testing.simpleselenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderTeaTest {
	private String baseUrl;
	private WebDriver driver;

	@Before
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/test/resources/chromedriver");
		baseUrl = "http://www.practiceselenium.com/";
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@After
	public void closeBrowser() throws IOException {
		driver.quit();
	}

	@Test
	public void orderRedTea() throws IOException {
		assertEquals("Welcome", driver.getTitle());

		WebElement teaBtn = driver.findElement(By.id("wsb-button-00000000-0000-0000-0000-000450914890"));
		teaBtn.click();

		assertEquals("Menu", driver.getTitle());

		WebElement checkoutBtn = driver.findElement(By.id("wsb-button-00000000-0000-0000-0000-000451959280"));
		checkoutBtn.click();

		assertEquals("Check Out", driver.getTitle());

		WebElement emailBox = driver.findElement(By.className("span6"));
		emailBox.sendKeys("tester@teashop.com");

		WebElement nameBox = driver.findElement(By.id("name"));
		nameBox.sendKeys("Curious Tester");

		WebElement addrBox = driver.findElement(By.id("address"));
		addrBox.sendKeys("111 Ferry Plaza Circle");

		WebElement cardType = driver.findElement(By.id("card_type"));
		cardType.sendKeys("Visa");

		WebElement cardNumber = driver.findElement(By.id("card_number"));
		cardNumber.sendKeys("4111 1111 1111 1111");

		WebElement cardName = driver.findElement(By.id("cardholder_name"));
		cardName.sendKeys("Curious Tester");

		WebElement verificationCode = driver.findElement(By.id("verification_code"));
		verificationCode.sendKeys("407");

		WebElement orderBtn = driver.findElement(By.className("btn"));
		orderBtn.click();

		assertEquals("Menu", driver.getTitle());

	}
	
	@Test
	public void testPassionLink() throws IOException {
		assertEquals("Welcome", driver.getTitle());

		WebElement element = driver.findElement(By.linkText("Our Passion"));
		element.click();
		assertEquals("Our Passion", driver.getTitle());
	}
	
	@Test
	public void testMenuLink() throws IOException {
		assertEquals("Welcome", driver.getTitle());

		WebElement element = driver.findElement(By.linkText("Menu"));
		element.click();
		assertEquals("Menu", driver.getTitle());
	}
	
	@Test
	public void testTalkLink() throws IOException {
		assertEquals("Welcome", driver.getTitle());

		WebElement element = driver.findElement(By.linkText("Let's Talk Tea"));
		element.click();
		assertEquals("Let's Talk Tea", driver.getTitle());
	}
	
	@Test
	public void testCheckOutLink() throws IOException {
		assertEquals("Welcome", driver.getTitle());

		WebElement element = driver.findElement(By.linkText("Check Out"));
		element.click();
		assertEquals("Check Out", driver.getTitle());
	}

}
