package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Topic_08_Custom_Dropdown_Part_I {
	// 1.khai bao
	WebDriver driver;
	WebDriverWait expliciWait;

	@BeforeTest
	public void beforeTest() {
		// 2.khoi tao
		driver = new FirefoxDriver();
		expliciWait = new WebDriverWait(driver, 30);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_JQuery() {
		driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
		selectItemInCustomDropdown("//span[@id='number-button']", "//ul[@id='number-menu']//div", "13");
		Assert.assertEquals(
				driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text']")).getText(),
				"13");
		selectItemInCustomDropdown("//span[@id='number-button']", "//ul[@id='number-menu']//div", "1");
		Assert.assertEquals(
				driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text']")).getText(),
				"1");
		selectItemInCustomDropdown("//span[@id='number-button']", "//ul[@id='number-menu']//div", "19");
		Assert.assertEquals(
				driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text']")).getText(),
				"19");
		selectItemInCustomDropdown("//span[@id='number-button']", "//ul[@id='number-menu']//div", "5");
		Assert.assertEquals(
				driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text']")).getText(),
				"5");
	}

	/*
	 * Hành vi của 1 dropdown: - Click vào dropdown - Chờ cho các item được hiển thị
	 * ra - Tìm cái item cần chọn >>lay text cua item minh mình mong muốn>so sánh vs
	 * cái mình đang đợi> bằng nhau + Item mình cần nó nằm trong tầm nhìn thấy của
	 * User -> Click luôn + Ko nằm trong tầm nhìn thấy (viewport) -> Scroll xuống ->
	 * Click - Bấm vào - Kiểm tra xem chọn đúng chưa
	 */
	public void selectItemInCustomDropdown(String parentXpath, String allItemXpath, String expectedText) {
		// click vao dropdown
		driver.findElement(By.xpath(parentXpath)).click();
		sleepInSecond(1);
		// Cho cho cac item hien thi thanh cong truoc khi chon
		expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));
		// Lấy hết tất cả item con đưa vào 1 cái list để duyệt qua
		List<WebElement> allItem = driver.findElements(By.xpath(allItemXpath));
		// Đung vòng lặp duyệt qua từng item
		for (WebElement item : allItem) {
			// Duyệt qua từng cái và getText ra
			// Nếu như text get ra bằng vs text mong muốn thì dừng lại và click vào item đó
			// luôn
			// Thoát khỏi vòng lặp
			if (item.getText().equals(expectedText)) {
				item.click();
				break;
			}
		}
	}

	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
