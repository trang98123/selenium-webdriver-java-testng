package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Topic_02_Xpath_Css_Part_II {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		// Mở trình duyệt
		driver = new FirefoxDriver();
		// driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// Mở app
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
	}

	@Test
	public void TC_01_Validate() throws InterruptedException {
		// Hiểu được html của 1 element
		// Thao tác vs đang ký button
		// TẠi sao lại phải bắt element
		// Bắt xong rồi thì làm gì//ntn?
		// Login page url matching
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		driver.findElement(By.id("txtFirstname")).sendKeys("hoang thi huyen trang");
		driver.findElement(By.id("txtPassword")).sendKeys("trang");

		// driver: đại diện cho selenium webdriver- gọi thư viện ra để sử dụng
		// findElement: tìm element
		// By.id/xpath/name/...: loại locator gì
		// click: hành động click vào button"

		Thread.sleep(5000);
	}

	@AfterClass
	public void afterClass() {
		// Đóng trình duyệt
		driver.close();
	}

}
