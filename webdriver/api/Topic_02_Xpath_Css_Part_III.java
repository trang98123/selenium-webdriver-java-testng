package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Topic_02_Xpath_Css_Part_III {
	WebDriver driver;
	Random rand;
	String emailAddress, firstName, lastName;

	@BeforeClass
	public void beforeClass() {
		// Mở trình duyệt
		driver = new FirefoxDriver();
		rand = new Random();
		// driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// Mở app
		driver.get("http://live.demoguru99.com/index.php");
		// Random email
		emailAddress = "autotesting" + rand.nextInt(99999) + "@automation.vn";
		//Ramdom firstname, lastname
		firstName= "Automation";
		lastName="Testing";	
	}

	 @Test
	public void TC_01_Login_Empty_Email_And_Password() {
		// b1

		// b2
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		// b3
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		// b4 verify error message
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText(),
				"This is a required field.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText(),
				"This is a required field.");
	}

	 @Test
	public void TC_02_Login_Invalid_Email() {
		
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		driver.findElement(By.id("email")).sendKeys("1234@123.123");
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText(),
				"Please enter a valid email address. For example johndoe@domain.com.");
	}

	 @Test
	public void TC_03_Login_Invalid_Password() {
	
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		driver.findElement(By.id("email")).sendKeys("automationtest@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123");
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText(),
				"Please enter 6 or more characters without leading or trailing spaces.");
	}

	 @Test
	public void TC_04_Login_Incorrect_Password() {
		
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		driver.findElement(By.id("email")).sendKeys("automationtest@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123123123");
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Invalid login or password.']")).getText(),
				"Invalid login or password.");
	}

	@Test
	public void TC_05_Created_a_new_account() {
		// b1 truy cập vào trang web

		// b2 click vào "My account" để tới trang đăng nhập
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		// b3 click Created an account button để tới trang đăng ký tài khoản
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		// b4 nhập thông tin hợp lệ vào các field
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("123456");
		// b5 click Register button
		driver.findElement(By.xpath("//span[text()='Register']")).click();
		// b6 Verify mesage xuất hiện khi đăng kí thành công
		Assert.assertEquals(driver
				.findElement(By.xpath("//span[text()='Thank you for registering with Main Website Store.']")).getText(),
				"Thank you for registering with Main Website Store.");
		// b7 Verify tạo mới thông tin firstname/last name/email
		String contactInformation = driver.findElement(By
				.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']/p"))
				.getText();
		Assert.assertTrue(contactInformation.contains(firstName));
		Assert.assertTrue(contactInformation.contains(lastName));
		Assert.assertTrue(contactInformation.contains(emailAddress));
		// b8 Logout khỏi hệ thống
		driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		// b9 kiểm tra hệ thống navigate về Homepage sau khi logout thành công
		Assert.assertTrue(driver.findElement(By.cssSelector("img[src$='logo.png']")).isDisplayed());
	}

	@Test
	public void TC_06_Login_valid_email_password() {
		// b1 click vào "My account" để tới trang đăng nhập
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		//b2 valid email và password
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//div[@class='input-box']//input[@name='login[password]']")).sendKeys("123456");
		// b3 click vào button login
		driver.findElement(By.xpath("//button[@name='send']")).click();
		// b4 Verify mesage xuất hiện khi đăng kí thành công
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='welcome-msg']//strong")).getText(), "Hello, " + firstName + " " + lastName + "!");
		String contactInformation = driver.findElement(By
				.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']/p"))
				.getText();
		Assert.assertTrue(contactInformation.contains(firstName));
		Assert.assertTrue(contactInformation.contains(lastName));
		Assert.assertTrue(contactInformation.contains(emailAddress));
		// b8 Logout khỏi hệ thống
		driver.findElement(By.xpath("//div[@class='account-cart-wrapper']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		// b9 kiểm tra hệ thống navigate về Homepage sau khi logout thành công
		driver.navigate();
	}

	@AfterClass
	public void afterClass() {
		// Đóng trình duyệt
		driver.close();
	}
}
