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

public class Topic_05_Web_Element_comment_Part_II {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// step1: truy cập vào trang web
		// driver.get("http:/live.demoguru99.com/");

		// element
		driver.get("https://automationfc.github.io/basic-form/index.html");
	}

// Kiểm tra Brower
	// @Test
	public void TC_01_Url() {
		// step 2: click myaccount tại footer
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();

		// step 3: verify url của Login page

		Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/login/");

		// step 4: click Created an account button

		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		;

		// step 5 verify url của Register Page

		Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/create/");
	}

	// @Test
	public void TC_02_Title() {
		// step 2: click myaccount tại footer
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		// step 3: verify title của Login page
		Assert.assertEquals(driver.getTitle(), "Customer Login");
		// step 4: click Created an account button
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		;
		// step 5: verify title của Register Page
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");

	}

	// @Test
	public void TC_03_Navigation() {
		// step 2: click myaccount tại footer
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		// step 3: click Created an account button
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		;
		// step 4 verify url của Register Page
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/create/");
		// step 5: Back lại trang login page
		driver.navigate().back();

		// step 6: verify url của Login page
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.demoguru99.com/index.php/customer/account/login/");
		// step 7: Forward tới trang Register Page
		driver.navigate().forward();
		// step 8: Verify title của Register Page
		Assert.assertEquals(driver.getTitle(), "Create New Customer Account");
	}

	// @Test
	public void TC_04_Page_Source() {
		// step 2: click myaccount tại footer
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		// step 3: verify Login Page chứa text: Login or created an account
		String Pagesource = driver.getPageSource();
		Assert.assertTrue(Pagesource.contains("Login or Create an Account"));
		// step 4: click Created an account button
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		;
		// step 5: verify Register chứa text: Create an account
		String Registersource = driver.getPageSource();
		Assert.assertTrue(Registersource.contains("Create an Account"));
		driver.close();
	}

	// Test element
	 @Test
	public void TC_01_Is_Displayed() {
		// step 2:
		boolean elementEmail = driver.findElement(By.xpath("//input[@id='mail']")).isDisplayed();

		if (elementEmail == true) {
			driver.findElement(By.xpath("//input[@id='mail']")).sendKeys("Automation testting");
			System.out.println("Email textbox is displayed");
		} else {
			System.out.println("Email textbox is not displayed");

		}

		boolean elementAge = driver.findElement(By.xpath("//input[@id='under_18']")).isDisplayed();

		if (elementAge == true) {
			driver.findElement(By.xpath("//input[@id='under_18']")).click();
			System.out.println("Age is displayed");

		} else {
			System.out.println("Age checkbox is not displayed");

		}

		boolean elementEducation = driver.findElement(By.xpath("//textarea[@id='edu']")).isDisplayed();
		if (elementEducation == true) {
			driver.findElement(By.xpath("//textarea[@id='edu']")).sendKeys("Automation test cucumber");
			System.out.println("Edu is displayed");

		} else {
			System.out.println("Education is not displayed");

		}
	}

	// step 3:
	 @Test
	public void TC_02_Is_Enabled() {
		boolean webelementEmail = driver.findElement(By.xpath("//input[@id='mail']")).isEnabled();
		if (webelementEmail == true) {
			System.out.println("Email- Element is enabled");
		} else {
			System.out.println("Email- Element is disabled");
		}

		boolean webelementAge = driver.findElement(By.xpath("//input[@id='under_18']")).isEnabled();
		if (webelementAge == true) {
			System.out.println("Age- Element is enabled");
		} else {
			System.out.println("Age- Element is disabled");
		}

		boolean webelementEducation = driver.findElement(By.xpath("//textarea[@id='edu']")).isEnabled();

		if (webelementEducation == true) {
			System.out.println("Education- Element is enabled");
		} else {
			System.out.println("Education- Element is disabled");
		}

		boolean webelementJob_01 = driver.findElement(By.xpath("//select[@id='job1']")).isEnabled();
		if (webelementJob_01 == true) {
			System.out.println("Job_01- Element is enabled");
		} else {
			System.out.println("Job_01- Element is disabled");
		}
		boolean webelementJob_02 = driver.findElement(By.xpath("//select[@id='job2']")).isEnabled();
		if (webelementJob_02 == true) {
			System.out.println("Job_02- Element is enabled");
		} else {
			System.out.println("Job_02- Element is disabled");
		}
		boolean webelementInterests = driver.findElement(By.xpath("//input[@id='development']")).isEnabled();
		if (webelementInterests == true) {
			System.out.println("Interests- Element is enabled");
		} else {
			System.out.println("Interests- Element is disabled");
		}
		boolean webelementSlider_01 = driver.findElement(By.xpath("//input[@name='slider-1']")).isEnabled();
		if (webelementSlider_01 == true) {
			System.out.println("Slider_01- Element is enabled");
		} else {
			System.out.println("Slider_01- Element is disabled");
		}
		// kiem tra cac phan tu disabled tren trang
		boolean webelementpassword = driver.findElement(By.xpath("//input[@id='password']")).isEnabled();
		if (webelementSlider_01 == false) {
			System.out.println("password- Element is disabled");
		} else {
			System.out.println("password- Element is enabled");
		}
		boolean webelementAge_radio = driver.findElement(By.xpath("//input[@id='radio-disabled']")).isEnabled();
		if (webelementAge_radio == false) {
			System.out.println("Age_radio- Element is disabled");
		} else {
			System.out.println("Age_radio- Element is enabled");
		}
		boolean webelementBiography = driver.findElement(By.xpath("//textarea[@id='bio']")).isEnabled();
		if (webelementBiography == false) {
			System.out.println("Biography- Element is disabled");
		} else {
			System.out.println("Biography- Element is enabled");
		}
		boolean webelementJobRole_03 = driver.findElement(By.xpath("//select[@id='job3']")).isEnabled();
		if (webelementJobRole_03 == false) {
			System.out.println("JobRole_03- Element is disabled");
		} else {
			System.out.println("JobRole_03- Element is enabled");
		}
		boolean webelementInterest_checkboxdisabled = driver.findElement(By.xpath("//input[@id='check-disbaled']"))
				.isEnabled();
		if (webelementInterest_checkboxdisabled == false) {
			System.out.println("checkboxdisabled- Element is disabled");
		} else {
			System.out.println("checkboxdisabled- Element is enabled");
		}
		boolean webelementSlider_02 = driver.findElement(By.xpath("//input[@id='slider-2']")).isEnabled();
		if (webelementSlider_02 == false) {
			System.out.println("Slider_02- Element is disabled");
		} else {
			System.out.println("Slider_02- Element is enabled");
		}
	}

	@Test
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

	}

	@AfterTest
	public void afterTest() {
	}

}
