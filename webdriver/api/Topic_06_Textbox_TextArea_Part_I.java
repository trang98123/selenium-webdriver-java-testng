package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Topic_06_Textbox_TextArea_Part_I {
	WebDriver driver;
	String customerID;
	String username = "mngr303960";
	String password = "YqyqYvu";

	// Input in New customer (user)/ Ouput (sever data)
	String name = "Donald duck";
	String inputdob = "04/05/1958";
	String outputdob = "1958-04-05";
	String address = "912 Village Centre";
	String state = "Missouri";
	String city = "Smart osc";
	String pin = "654345";
	String mobile_number = "0443434343";
	String email = "trang" + generateEmail() + "@gmail.com";
	String passwordtextbox, loginUrl;

	// Input in Edit workflow

	String editAddress = "2555";
	String editCity = "New Jesey";
	String editState = "Stock";
	String editPin = "666888";
	String editPhone = "0445444555";
	String editEmail = "trang" + generateEmail() + "@smartosc.com";

	@BeforeTest
	// Precondition
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// Step 01: Truy cap link
		driver.get("http://demo.guru99.com/v4/");
		name = "Donald duck";
		inputdob = "04/05/1958";
		outputdob = "1958-04-05";
		address = "912 Village Centre";
		city = "Smart osc";
		state = "Missouri";
		pin = "654345";
		mobile_number = "0443434343";
		email = "trang" + generateEmail() + "@gmail.com";
	}

	@Test
	public void TC01_Register() {
		loginUrl = driver.getCurrentUrl();
		driver.findElement(By.xpath("//a[text()='here']")).click();
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("automationtest@gmail.com");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		// step 02: Dang nhap thong tin
		username = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
	}

	@Test
	public void TC02_Login() {
		// Step 03:
		driver.get(loginUrl);
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		// Step 04:
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		// step 05: Nhap du lieu
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(inputdob);
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(address);
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
		driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(pin);
		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(mobile_number);
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@name='sub']")).click();
		// Assert.assertTrue( driver.findElement(By.xpath("//p[@class='heading3'and
		// text()='Customer Registered Successfully!!!']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(),name);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(),outputdob);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(),address);
		Assert.assertEquals( driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(),city);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(),state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(),pin );
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(),mobile_number);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(),email);
		customerID = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
		System.out.println("Customer ID new= " + customerID);
	}

	@Test
	public void TC03_EditCustomer() {
		// Step 01: click button Edit customer
		driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
		// Step 02: nhap customer_id
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(customerID);
		System.out.println("Customer ID edit= " + customerID);
		// step 03: click submit
		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
		// Step 04: Verified 3 filed disabled
		Assert.assertFalse(isElementEnabled(By.name("name")));
		Assert.assertFalse(isElementEnabled(By.name("gender")));
		Assert.assertFalse(isElementEnabled(By.name("dob")));
        Assert.assertEquals(driver.findElement(By.name("name")).getAttribute("value"), name);
	    Assert.assertEquals(driver.findElement(By.name("addr")).getAttribute("value"),address);

		// Step 05: Nhsp gia tri moi cho cac filed enabled
	    driver.findElement(By.name("addr")).clear();	
		driver.findElement(By.name("addr")).sendKeys(editAddress);	
		driver.findElement(By.name("city")).clear();
		driver.findElement(By.name("city")).sendKeys(editCity);	
		driver.findElement(By.name("state")).clear();	
		driver.findElement(By.name("state")).sendKeys(editState);	
		driver.findElement(By.name("pinno")).clear();	
		driver.findElement(By.name("pinno")).sendKeys(editPin);	
		driver.findElement(By.name("telephoneno")).clear();	
		driver.findElement(By.name("telephoneno")).sendKeys(editPhone);		
		driver.findElement(By.name("emailid")).clear();
		driver.findElement(By.name("emailid")).sendKeys(editEmail);
		driver.findElement(By.xpath("//input[@name='sub']")).click();

		// Step 06: Verify cac filed sau khi Edit suscess

		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(),editAddress);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(),editCity);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(),editState);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(),editPin);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(),editPhone);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), editEmail);

	}

	public int generateEmail() {
		Random rand = new Random();
		return rand.nextInt(9999);
		// return "donald" + rand.nextInt(9999) + "@gmail.com";
	}

	public boolean isElementEnabled(By by) {
		WebElement element = driver.findElement(by);
		if (element.isEnabled()) {
			System.out.println("Element is enabled");
			return true;
		} else {
			System.out.println("Element is not enabled");
			return false;
		}

	}

	@AfterTest
	public void afterTest() {
	}

}
