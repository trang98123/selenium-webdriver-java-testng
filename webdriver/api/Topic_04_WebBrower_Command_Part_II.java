package api;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_WebBrower_Command_Part_II {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http:/live.demoguru99.com/");
	}

	// brower
	@Test
	public void TC_01_Url() {
		// Step 02 click My account link tại footer
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		// Step 03 Verify url của Login page
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/login/");
		// Step 04 Click Created an account button
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		// Step 05 Verify url của Register page
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/create/");
	}

	@Test
	public void TC_02_Title() {
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		// Step 03 verify title của Login page= Customer login
		Assert.assertEquals(driver.getTitle(), "Customer Login");
		// Step 04 Click Created an account button
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		// Step 05 verify title của Register
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
	}

	@Test
	public void TC_03_Navigation() {
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		// Step 03 Click Created an account button
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		// Step 04 Verify url của Register page
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/create/");
		// Step 05 Back lại trang Login Page
		driver.navigate().back();
		// Step 06 Verify url của Login page
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/login/");
		// Step 07 Forward tới trang Register Page
		driver.navigate().forward();
		// Step 08 Verify title của Register Page
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
	}

	@Test
	public void TC_04_Page_Source() {
		// Step 02 click My account link tại footer
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		// Step 03 Verify Login Page chứa text: Login or created an account
		String loginPageSource= driver.getPageSource();
		Assert.assertTrue(loginPageSource.contains("Login or Create an Account"));
		// Step 04 Click Created an account button
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		// Step 05 Verify Login Page chứa text: Created an account
		String registerPageSource= driver.getPageSource();
		Assert.assertTrue(registerPageSource.contains("Create an Account"));
		driver.close();
	}
}
