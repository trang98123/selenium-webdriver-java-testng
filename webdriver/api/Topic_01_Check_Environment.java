package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Topic_01_Check_Environment {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		// Mở trình duyệt
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// Mở app
		driver.get("http://demo.guru99.com/v4");
	}

	@Test
	public void TC_01_ValidateCurrentUrl() {
		// Login page url matching
		String loginPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(loginPageUrl, "http://demo.guru99.com/v4");
	}

	@Test
	public void TC_02_ValidatePageTitle() {
		// Login page title
		String loginPageTitle = driver.getTitle();
		Assert.assertEquals(loginPageTitle, "Guru99 Bank Home Page");

	}

	@Test
	public void TC_03_LoginFormDisplayed() {
		// Login form displayed
		Assert.assertTrue(driver.findElement(By.xpath("//form[@name='frmLogin']")).isDisplayed());
		;

	}

	@AfterClass
	public void afterClass() {
		// Đóng trình duyệt
		driver.close();
	}

}
