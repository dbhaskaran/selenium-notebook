package org.testing.simpleselenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderRedTea {
	public static void main(String[] args) {
		
		// Create a new instance of the Chrome driver
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/src/test/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		// Wait For Page To Load
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.practiceselenium.com/");
		
		WebElement teaBtn = driver.findElement(By.id("wsb-button-00000000-0000-0000-0000-000450914890"));
		teaBtn.click();
		
		WebElement checkoutBtn = driver.findElement(By.id("wsb-button-00000000-0000-0000-0000-000451959280"));
		checkoutBtn.click();
		
		WebElement emailBox = driver.findElement(By.className("span6"));
		emailBox.sendKeys("testing@teashop.com");
		
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
		verificationCode.sendKeys("278");
		
		WebElement orderBtn = driver.findElement(By.className("btn"));
		orderBtn.click();
		
		// Close the browser.
		driver.close();
	}
}