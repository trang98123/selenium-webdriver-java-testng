package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Topic_05_Web_Element_Part_IV {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://login.mailchimp.com/signup/");
	}

	@Test
	public void TC01_valid_mailchimp() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("tranghth2@smartosc.com");
		driver.findElement(By.id("new_username")).sendKeys("tranghth2");

		/* Lowercase */
		driver.findElement(By.id("new_password")).sendKeys("auto");
		Thread.sleep(1000);
		Assert.assertTrue(driver
				.findElement(By.xpath("//li[@class='lowercase-char completed'and text()='One lowercase character']"))
				.isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//button[@id='create-account']")).isEnabled());

		/* Uppercase */
		driver.findElement(By.id("new_password")).clear();
		driver.findElement(By.id("new_password")).sendKeys("Auto");
		Thread.sleep(1000);
		Assert.assertTrue(driver
				.findElement(By.xpath("//li[@class='uppercase-char completed' and text()='One uppercase character']"))
				.isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//button[@id='create-account']")).isEnabled());

		/* Number */

		driver.findElement(By.id("new_password")).clear();
		driver.findElement(By.id("new_password")).sendKeys("12345");
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed' and text()='One number']"))
				.isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//button[@id='create-account']")).isEnabled());

		/* Special */
		driver.findElement(By.id("new_password")).clear();
		driver.findElement(By.id("new_password")).sendKeys("!!");
		Thread.sleep(1000);
		Assert.assertTrue(
				driver.findElement(By.xpath("//li[@class='special-char completed' and text()='One special character']"))
						.isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//button[@id='create-account']")).isEnabled());

		/* Max-leng */
		driver.findElement(By.id("new_password")).clear();
		driver.findElement(By.id("new_password")).sendKeys("Automation");
		Thread.sleep(1000);
		Assert.assertTrue(
				driver.findElement(By.xpath("//li[@class='8-char completed' and text()='8 characters minimum']"))
						.isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//button[@id='create-account']")).isEnabled());

		/* Valid */
		driver.findElement(By.id("new_password")).clear();
		driver.findElement(By.id("new_password")).sendKeys("Auto123!!!");
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElement(By.xpath("//button[@id='create-account']")).isEnabled());

	}

	@AfterTest
	public void afterTest() {
	}

}
