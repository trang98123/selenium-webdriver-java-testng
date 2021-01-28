package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class Topic_05_Web_Element_comment_Part_III {

	WebDriver driver;
	By emailTextbox = By.cssSelector("#mail");
	By under_18 = By.xpath("//input[@id='under_18']");
	By education = By.xpath("//textarea[@id='edu']");
    By Job_01=By.xpath("//select[@id='job1']");
    By webelementJob_02=By.xpath("//select[@id='job2']");
    By webelementInterests=By.xpath("//input[@id='development']");
    By webelementSlider_01=By.xpath(" //input[@name='slider-1']");
    By webelementpassword=By.xpath("//input[@id='password']");
    By webelementAge_radio=By.xpath("//input[@id='radio-disabled']");
    By webelementBiography=By.xpath("//textarea[@id='bio']");
    By  webelementJobRole_03=By.xpath("//select[@id='job3']");
    By webelementInterest_checkboxdisabled=By.xpath("//input[@id='check-disbaled']");
    By webelementSlider_02=By.xpath("//input[@id='slider-2']");
    
   
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	public boolean isElementDisplayed(By by) {
		WebElement element = driver.findElement(by);
		if (element.isDisplayed()) {
			System.out.println("Element is displayed");
			return true;
		} else {
			System.out.println("Element is not displayed");
			return false;
		}
	}

	public void senkeyToElement(By by, String value) {
		WebElement element = driver.findElement(by);
		element.clear();
		element.sendKeys("Automation testing");
	}

	public void checkboxToElement(By by) {
		WebElement element = driver.findElement(by);
		element.click();
	}

	// Test element
	//@Test
	public void TC_01_Is_Displayed() throws Exception {
		// step1: truy cập vào trang web
		driver.get("https://automationfc.github.io/basic-form/index.html");
		// step 2:
		if (isElementDisplayed(emailTextbox)) {
			senkeyToElement(emailTextbox, "Automation testing");
		}

		if (isElementDisplayed(education)) {
			senkeyToElement(education, "Automation testing");
		}

		if (isElementDisplayed(education)) {
			checkboxToElement(under_18);
		}
	}

	// step 3:
	public boolean isElementEnable(By by)
	{ WebElement element= driver.findElement(by);
		if(element.isEnabled())
				{
			System.out.println("Element is enabled");
			return true;
				}
		else
		{
			System.out.println("Element is disabled");
			return false;
		}
	}
	 @Test
	public void TC_02_Is_Enabled() {
		// step1: truy cập vào trang web
			driver.get("https://automationfc.github.io/basic-form/index.html");
		 //Enable
		Assert.assertTrue(isElementEnable(emailTextbox));
		Assert.assertTrue(isElementEnable(under_18));
		Assert.assertTrue(isElementEnable(Job_01));
		Assert.assertTrue(isElementEnable(webelementJob_02));
		Assert.assertTrue(isElementEnable(webelementInterests));
		Assert.assertTrue(isElementEnable(webelementSlider_01));
		//Disabled
		Assert.assertFalse(isElementEnable(webelementpassword));
		Assert.assertFalse(isElementEnable(webelementAge_radio));
		Assert.assertFalse(isElementEnable(webelementBiography));
		Assert.assertFalse(isElementEnable(webelementJobRole_03));
		Assert.assertFalse(isElementEnable(webelementInterest_checkboxdisabled));
		Assert.assertFalse(isElementEnable(webelementSlider_02));
	}

	// @Test
	public void TC_03_Is_Select() {
		// click to age under 18/ Language Java
		driver.findElement(By.xpath("//input[@id='under_18']")).click();
		driver.findElement(By.xpath("//input[@id='java']")).click();

		// Verify element select
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='under_18']")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='java']")).isSelected());

		// click to age under 18/ Language Java
		driver.findElement(By.xpath("//input[@id='under_18']")).click();
		driver.findElement(By.xpath("//input[@id='java']")).click();

		// verify element is not select
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='under_18']")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='java']")).isSelected());
	}

	public void TC_04_Is_Displayed_Enabled_Selected() {
		// Step 01: Truy cap trang web
		driver.get("https://login.mailchimp.com/signup/");
		// step 02: Nhap du lieu hop le vao 2 truong: Email/ Username
		driver.findElement(By.xpath("//input[@id='new_username']")).sendKeys("");

	}

	@AfterTest
	public void afterTest() {
	}

}
