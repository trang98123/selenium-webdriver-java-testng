package api;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_10_Alert {
	WebDriver driver;
	Alert alert;
	WebDriverWait expliciWait;
	String username = "admin";
	String password = "admin";
	By resultText = By.xpath("//p[@id='result']");

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		expliciWait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// @Test
	public void TC_01_Accept_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");

		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

		// chờ cho alert xuất hiện
		expliciWait.until(ExpectedConditions.alertIsPresent());
		// Switch vào Alert
		alert = driver.switchTo().alert();
		// Cancel: alert.dismiss();
		sleepInsecond(3);
		Assert.assertEquals(alert.getText(), "I am a JS Alert");
		alert.accept();
		Assert.assertEquals(driver.findElement(resultText).getText(), "You clicked an alert successfully");
		// System.out.println();
	}

	// @Test
	public void TC_02_Confirm_Alert() {
		// step 01: Truy cap trang
		driver.get("https://automationfc.github.io/basic-form/index.html");
		// step 02: click button
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		// step 03: cho cho alert xuat hien
		expliciWait.until(ExpectedConditions.alertIsPresent());
		// step 04: switch vao alert
		alert = driver.switchTo().alert();
		sleepInsecond(3);
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		alert.accept();
		Assert.assertEquals(driver.findElement(resultText).getText(), "You clicked: Ok");

	}

	// @Test
	public void TC_03_Prompt_Alert() {
		String loginValue = "Automation testing";
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		// cho cho alert xuat hien
		expliciWait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		alert.sendKeys(loginValue);
		sleepInsecond(3);
		Assert.assertEquals(alert.getText(), "I am a JS prompt");
		alert.accept();
		Assert.assertEquals(driver.findElement(resultText).getText(), "You entered: " + loginValue);
	}

	// @Test
	public void TC_04_Click_And_Hold_Element_Select_Multiple_Item() {
		// step 01: truy cap vao link
																		
		// driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
																	
		// step 02: handle authentication alert vs
																		
		// user/pass
		driver.get("http://" + username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth");
		// step 03: Verify message hien thi sau khi login thanh con
		Assert.assertTrue(driver
				.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]"))
				.isDisplayed());
	}

	@Test
	public void TC_05_Click_And_Hold_Element_Select_Random_Item() {
		driver.get("http://the-internet.herokuapp.com/");
		String basicAuthenLink = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
		//// a[text()='Basic Auth']
		System.out.println(basicAuthenLink);
		// input: http://the-internet.herokuapp.com/basic_auth
		// output: http://admin:admin@the-internet.herokuapp.com/basic_auth
		driver.get(getAuthenticationUrl(basicAuthenLink, username, password));
		Assert.assertTrue(driver
				.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]"))
				.isDisplayed());
	}

	public String getAuthenticationUrl(String Url, String username, String password) {
		String urlValue[] = Url.split("//");

		Url = urlValue[0] + "//" + username + ":" + password + "@" + urlValue[1];
		return Url;
	}

	public void sleepInsecond(long timeInsecond) {
		try {
			Thread.sleep(timeInsecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void TC_01_Accep_Alert()
	{
		driver.get("https://automationfc");
	}

	@AfterClass
	public void afterClass() {
	}

}
