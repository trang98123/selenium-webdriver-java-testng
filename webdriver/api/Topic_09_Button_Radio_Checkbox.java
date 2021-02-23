package api;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Topic_09_Button_Radio_Checkbox {
	WebDriver driver;
	JavascriptExecutor jsExcutor;
	By loginButton = By.xpath("//button[@class='fhs-btn-login']");
	By loginUsername = By.xpath("//input[@id='login_username']");
	By loginPassword = By.xpath("//input[@id='login_password']");

	By check_Dual = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::input");
	By Radio_2 = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::input");

	By summer= By.xpath("//input[@id='mat-radio-4-input']");
	By summer_radio=By.xpath("//input[@value='Summer']");
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		jsExcutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	// @Test
	public void TC_01_Button() {
		// Step 01: truy cap trang web
		driver.get("https://www.fahasa.com/customer/account/create?attempt=1");
		// step 02: navigate qua tab dang nhap
		driver.findElement(By.cssSelector(".popup-login-tab-login")).click();
		// step 03: Verify "Dang nhap" button la disable
		Assert.assertFalse(isElementEnable(loginButton));
		// step 04: Input dữ liệu hợp lệ vào Email/ mật khẩu textbox
	//	Senkey(loginUsername, "trang@gmail.com");
	//	Senkey(loginPassword, "123456");
		SleepInsecond(2);
		// step 05: Verify đăng nhập button là enable
		Assert.assertTrue(isElementEnable(loginButton));
		// step 06: Tai lại trang sau đó navigate qua tab đăng nhập
		driver.navigate().refresh();
		driver.findElement(By.cssSelector(".popup-login-tab-login")).click();
		// step 07: Remove thuộc tính disable của button đăng nhập
		removeDisableAttributeByJS(loginButton);
		SleepInsecond(5);
		Assert.assertTrue(isElementEnable(loginButton));
		// step 08: click vào button đăng nhập
		driver.findElement(loginButton).click();
		// step 09: Kiểu tra error message xuất hiện tại Email/ Mật khẩu
		Assert.assertEquals(driver
				.findElement(By.xpath(
						"//label[text()='Số điện thoại/Email']/following-sibling::div[@class='fhs-input-alert']"))
				.getText(), "Thông tin này không thể để trống");
		Assert.assertEquals(driver
				.findElement(By.xpath("//label[text()='Mật khẩu']/following-sibling::div[@class='fhs-input-alert']"))
				.getText(), "Thông tin này không thể để trống");

	}

	//@Test
	public void TC_02_DefaultCheckbox_RadioButton() {
		// step 01: Truy cap vao trang
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		// step 02: Click vao checkbox
		ChecktocheckboxRadio(driver.findElement(check_Dual));
		// step 03: Kiem tra checkbox đó đã chọn
		Assert.assertTrue(isElemenSelected(driver.findElement(check_Dual)));

		// step 04: Sau khi checkbox đã được chọn>> bỏ chọn nó và kiểm tra nó chưa đc
		// chọn
		UnchecktocheckboxRadio(driver.findElement(check_Dual));
		Assert.assertFalse(isElemenSelected(driver.findElement(check_Dual)));
		// step 05: Truy cập vào trang
		driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
		// step 06: Click vào radiobutton
		ChecktocheckboxRadio(driver.findElement(Radio_2));
		Assert.assertTrue(isElemenSelected(driver.findElement(Radio_2)));
		// step 07: Kiểm tra radio button đó đã chọn hay chưa/ nếu chưa thì chọn lại
		UnchecktocheckboxRadio(driver.findElement(Radio_2));
		Assert.assertTrue(isElemenSelected(driver.findElement(Radio_2)));
	}
	@Test
	public void TC_03_CustomCheckbox_RadioButton()
	{
		//Step 01: Truy cap trang web
		driver.get("https://material.angular.io/components/radio/examples");
		//Step 02: Click vao radio button: Summer
		clickToElementByJS(driver.findElement(summer));
		//Step 03: Kiểm tra radio button đã đc chọn hay chưa, nếu trưa thì chọn lại
		Assert.assertTrue(isElemenSelected(driver.findElement(summer)));
	}
	@Test
	public void TC_04_Checkbox_radio_Custom()
	{
		//Step 01: Truy cap trang web
				driver.get("https://material.angular.io/components/radio/examples");
				//case 04
				//click- Input -> Hidden -> Javascript click
				clickToElementByJS(driver.findElement(summer_radio));
				Assert.assertTrue(isElemenSelected(driver.findElement(summer_radio)));
				//Verify -input ->pass
				
	}
	public void ChecktocheckboxRadio(WebElement element) {
		if (!element.isSelected()) {
			System.out.println("CheckboxRadio is displayed");
			element.click();
		} 

	}
	public boolean isElemenSelected(WebElement element) {
		if (element.isSelected()) { // driver.findElement(by).click();
			System.out.println("Element is select");
			return true;
		} else {
			System.out.println("Element is not select");
			return false;
		}
	}
	public void UnchecktocheckboxRadio(WebElement element) {
		if (element.isSelected()) {
			System.out.println("Radio is displayed");
			element.click();
		} 
	}

	public void removeDisableAttributeByJS(By by) {
		WebElement element = driver.findElement(by);
		jsExcutor.executeScript("arguments[0].removeAttribute('disabled')", element);
	}
	public void clickToElementByJS(WebElement element)
	{
		jsExcutor.executeScript("arguments[0].click()", element);
	}

	//public void Senkey(By by, String value) {
	//	driver.findElement(by).sendKeys(value);
	//}
	public boolean isElementEnable(By by) {
		if (driver.findElement(by).isEnabled()) { // driver.findElement(by).click();
			System.out.println("Element is enable");
			return true;
		} else {
			System.out.println("Element is disable");
			return false;
		}

	}
	public void SleepInsecond(long timeInsecond) {
		try {
			Thread.sleep(timeInsecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterClass
	public void afterClass() {
	}
}
