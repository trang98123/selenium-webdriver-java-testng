package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Topic_07_Default_Dropdown {
	WebDriver driver;
	Select select;
	String firstName, lastName, emailAddress, companyname, password;
	String date, month, year;
	WebDriverWait expliciWait;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		expliciWait = new WebDriverWait(driver, 30);
		firstName = "John";
		lastName = "Wick";

		companyname = "Hollyword";
		password = "123456";
		date = "17";
		month = "November";
		year = "1998";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// driver.get("https://demo.nopcommerce.com/");
	}

//	@Test (invocationCount=5)
	public void TC_01_Register() {
		// step 01: Mo trang Register
		driver.findElement(By.cssSelector(".ico-register")).click();
		// Step 02: Dien thong tin vao cac field required
		checkToCheckboxOradio(By.id("gender-male"));
		driver.findElement(By.id("FirstName")).sendKeys(firstName);
		driver.findElement(By.id("LastName")).sendKeys(lastName);

		/*
		 * Su dung index: chon ngay 31 select.selectByIndex(31); sleepInsecond(5); //Su
		 * dung value: chon ngay 15 select.selectByValue("15"); sleepInsecond(5);
		 */
		// Khoi tao bien Select de thao tac voi dropdow date
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
		// Su dung text: Chon ngay 30
		select.selectByVisibleText(date);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), date);
		Assert.assertEquals(select.getOptions().size(), 32);
		// Khoi tao bien Select de thao tac voi dropdow month
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
		// Su dung text: Chon ngay 30
		select.selectByVisibleText(month);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), month);
		Assert.assertEquals(select.getOptions().size(), 13);
		// Khoi tao bien Select de thao tac voi dropdow year
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
		// Su dung text: Chon ngay 30
		select.selectByVisibleText(year);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), year);
		Assert.assertEquals(select.getOptions().size(), 112);
		emailAddress = "johnwick" + getRandomNumber() + "@hotmail.com";
		driver.findElement(By.id("Email")).sendKeys("trang98123@gmail.com");
		driver.findElement(By.id("Company")).sendKeys(companyname);
		checkToCheckboxOradio(By.id("Newsletter"));
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(password);

		// Step 03: Dang ky
		driver.findElement(By.id("register-button")).click();
		// Step 04: Kiem tra xuat hien message Dang ki thanh cong
		Assert.assertEquals(driver.findElement(By.cssSelector(".result")).getText(), "Your registration completed");
		// Step 05: Vao trang My Account
		driver.findElement(By.cssSelector(".ico-account")).click();

		// Sau khi click xong nó đã chuyển qua 1 trang html khác rồi nên bắt buộc phải
		// tìm element lại >>lỗi >>ko tìm thấy element
		// refresh //load lại
		// Step 06: Kierm tra dung vs thong tin da dang ki
		Assert.assertTrue(driver.findElement(By.cssSelector("#gender-male")).isSelected());
		Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"), lastName);
		Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("value"), "trang98123@gmail.com");
		Assert.assertEquals(driver.findElement(By.id("Company")).getAttribute("value"), companyname);
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), date);
		Assert.assertEquals(select.getOptions().size(), 32);
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), month);
		Assert.assertEquals(select.getOptions().size(), 13);
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), year);
		Assert.assertEquals(select.getOptions().size(), 112);

		driver.findElement(By.cssSelector(".ico-logout")).click();
	}

	// @Test
	public void TC_02_Multiple() {
		// Step 01: Truy cap vao trang
		driver.get("https://automationfc.github.io/basic-form/index.html");

		// Step 03: Chọn giá trị Mobie testing trong dropdown bằng phương thức
		// selectByVisibleText
		select = new Select(driver.findElement(By.xpath("//select[@id='job1']")));
		select.selectByVisibleText("Mobile Testing");

		// Step 04: Kiểm tra giá trị được chọn thành công
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Mobile Testing");

		// Step 05: Chọn giá trị Manual testing trong dropdown bằng phương thức
		// selectByValue
		select.selectByValue("manual");
		// Step 06: Kiểm tra giá trị đã được chọn thành công
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Manual Testing");
		// Step 07: Chọn giá trị Functional UI Testing trong dropdown bằng phương thưc
		// selectByIndex
		select.selectByIndex(9);
		// Step 08: Kiểm tra giá trị đã được chọn thành công
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Functional UI Testing");
		// step 09: Kiểm tra dropdown có đủ 10 giá trị

		Assert.assertEquals(select.getOptions().size(), 10);

		select = new Select(driver.findElement(By.xpath("//select[@id='job2']")));
		// step 02: Kiem tra drop down khong ho tro thuoc tinh Multiple select
		// Assert.assertTrue(select.isMultiple());
		// Step 11: Chọn nhiều giá trị cùng lúc
		ArrayList<String> allItemText = new ArrayList<String>();
		allItemText.add("Automation");
		allItemText.add("Mobile");
		allItemText.add("Perfomance");
		allItemText.add("Functional UI");
		// chon 4 item
		for (String item : allItemText) {
			select.selectByVisibleText(item);
		}
		sleepInsecond(5);
		// Step 10: Kiểm tra dropdown Job Role 02- Multiple dropdown có hỗ trợ thuộc
		// tính mutiple select
		Assert.assertTrue(select.isMultiple());
		// trang98123
		// Automation
		// select.selectByVisibleText("Automation");
		// select.selectByVisibleText("Mobile");
		// select.selectByVisibleText("Perfomance");
		// select.selectByVisibleText("Functional UI");
		// Mobile
		// Desktop
		// Step 12: Kiểm tra 3 giá trị cùng lúc
		List<WebElement> allSelectedItems = select.getAllSelectedOptions();
		ArrayList<String> allSelectedText = new ArrayList<String>();
		for (WebElement item : allSelectedItems) {
			allSelectedText.add(item.getText());
		}
		// Step 13: De-select tất cả 3 giá trị cùng lúc
		Assert.assertEquals(allSelectedText.size(), 4);
		Assert.assertEquals(allSelectedText, allItemText);
		// Step 14: Kiểm tra không còn giá trị nào được chọn

	}

	// @Test
	public void TC_03_Dropdown_List() {
		// Step 01: Truy cập vào trang
		driver.get("https://demo.nopcommerce.com/register");
		// Step 02: Click Register link trên Header
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		// Step 03: Input các thông tin hợp lệ vào form
		checkToCheckboxOradio(By.xpath("//input[@id='gender-male']"));
		senkeyValue(By.xpath("//input[@id='FirstName']"), "FirstName");
		senkeyValue(By.xpath("//input[@id='LastName']"), "LastName");
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		select.selectByVisibleText(date);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), date);
		Assert.assertEquals(select.getOptions().size(), 32);
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		select.selectByVisibleText(month);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), month);
		Assert.assertEquals(select.getOptions().size(), 13);
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		select.selectByVisibleText(year);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), year);
		Assert.assertEquals(select.getOptions().size(), 112);
		senkeyValue(By.xpath("//input[@id='Email']"), "trang981233@gmail.com");
		senkeyValue(By.xpath("//input[@id='Company']"), "Company");
		senkeyValue(By.xpath("//input[@id='Password']"), password);
		senkeyValue(By.xpath("//input[@id='ConfirmPassword']"), password);

		// Step 04: Click Register button
		driver.findElement(By.xpath("//input[@id='register-button']")).click();
		// Step 05: Verify đã vào trang Home Page sau khi đăng kí thành công
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Your registration completed']")).getText(),
				"Your registration completed");
		// Step 06: Click vào trang My account và kiểm tra ngày/ tháng/ năm nhập vào là
		// đúng
		driver.findElement(By.xpath("//div[@class='header-links']//a[text()='My account']")).click();
		// Kiem tra ngay thang nam nhap vao la dung
		Assert.assertEquals(
				driver.findElement(By.xpath("//select[@name='DateOfBirthDay']//option[text()='17']")).getText(), date);
		Assert.assertEquals(
				driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']//option[text()='November']")).getText(),
				month);
		Assert.assertEquals(
				driver.findElement(By.xpath("//select[@name='DateOfBirthYear']//option[text()='1998']")).getText(),
				year);
	}

	// @Test
	public void TC_04_Custom_Dropdown_List_Jquery() {
		// Step 01: Truy cập vào trang
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		// Step 02: Chọn item cuối cùng: số 19
		selectItemInCustomDropdown("//span[@id='number-button']", "//ul[@id='number-menu']//div", "19");
		// Step 03: Kiểm tra item đã được chọn thành công
		Assert.assertEquals(
				driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text']")).getText(),
				"19");

	}

	@Test
	public void TC_05_Custom_Dropdown_List_Angular() {
		// Step 01: Truy cap vao trang
         driver.get("https://ej2.syncfusion.com/angular/demos/?_ga=2.262049992.437420821.1575083417-524628264.1575083417#/material/drop-down-list/data-binding");
		// Step 02: Chon Item Football
         selectItemInCustomDropdown("//ul[@id='games_options']","//ul[@id='games_options']/li","Cricket");
	}
	//@Test
	public void TC_06_Custom_Dropdown_List_ReactJS() {
		// Step 01: Truy cap vao trang
            driver.get("https://mikerodham.github.io/vue-dropdowns/");
		// Step 02: Chon Item Second Option
            selectItemInCustomDropdown("//li[@class='dropdown-toggle']","//ul[@class='dropdown-menu']//li","Second Option");
            
	}
   
	public void selectItemInCustomDropdown(String parentXpath, String allItemXpath, String expectText) {
		// click vao dropdown
		driver.findElement(By.xpath(parentXpath)).click();
		// chow cho cac item hien thi ra truoc khi chon

		expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));
		// Lay het tat ca item con dua vao 1 list de duyet qua
		List<WebElement> allItem = driver.findElements(By.xpath(allItemXpath));
		// Dung vong lap duyet qua tung item
		for (WebElement item : allItem) {
			if (item.getText().equals(expectText)) {
				item.click();
				break;
			}
		}

	}

	public void checkToCheckboxOradio(By by) {
		WebElement element = driver.findElement(by);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void UncheckCheckboxOradio(By by) {
		WebElement element = driver.findElement(by);
		if (element.isSelected()) {
			element.click();
		}
	}

	public void sleepInsecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void senkeyValue(By by, String value) {
		WebElement element = driver.findElement(by);
		if (element.isDisplayed()) {
			element.sendKeys(value);
		}
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);

	}

	@AfterClass
	public void afterClass() {

	}

}
