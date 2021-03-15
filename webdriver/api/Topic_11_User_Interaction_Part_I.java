package api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.awt.Desktop.Action;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class Topic_11_User_Interaction_Part_I {
	WebDriver driver;
 Actions action;
	@BeforeClass
	public void beforeClass() {

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		action=new Actions(driver);
	}
	//@Test
	public void TC_01_Hover_Mouse() {
     driver.get("https://tiki.vn/");
     //Verify login button Undisplayed
     Assert.assertFalse(driver.findElement(By.xpath("//button[text()='Đăng nhập']")).isDisplayed());
     WebElement shortCutAccount = driver.findElement(By.xpath("//div[@data-view-id='header_user_shortcut']"));
     action.moveToElement(shortCutAccount).perform();
     //Verify login button displayed
     Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Đăng nhập']")).isDisplayed());
	}

	//@Test
	public void TC_02_Click_And_Hold() {
       driver.get("https://jqueryui.com/resources/demos/tooltip/default.html");
       action.moveToElement(driver.findElement(By.id("age"))).perform();
       Assert.assertEquals(driver.findElement(By.xpath("//div[@class='ui-tooltip-content']")).getText(), "We ask for your age only for statistical purposes.");
	}
	//@Test
	public void TC_03_Hover_To_Element() {
		driver.get("https://hn.telio.vn/");
		action.moveToElement(driver.findElement(By.xpath("//nav[@class='navigation cdz-fix-left']//span[text()='Đồ uống']"))).perform();;
        action.click(driver.findElement(By.xpath("//nav[@class='navigation cdz-fix-left']//a[text()='Bia']"))).perform();
       //DOM
      Assert.assertTrue(driver.findElement(By.xpath("//h1[@id='page-title-heading']//span[text()='Bia']")).isDisplayed());
        //UI
       Assert.assertEquals(driver.findElement(By.xpath("//h1[@id='page-title-heading']/span")).getText(), "BIA");
	}
	//@Test
	public void TC_04_Hover_To_Element() {
           driver.get("https://hn.telio.vn/");
           action.moveToElement(driver.findElement(By.xpath("//nav[@class='navigation cdz-fix-left']//span[text()='Bánh kẹo']"))).perform();
           action.click(driver.findElement(By.xpath("//nav[@class='navigation cdz-fix-left']//a[text()='Bánh gạo']"))).perform();
           //DOM
           Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page-title-wrapper']//span[text()='Bánh gạo']")).isDisplayed());
           //UI
           Assert.assertEquals(driver.findElement(By.xpath("//div[@class='page-title-wrapper']//span")).getText(), "BÁNH GẠO");
	}

//	@Test
	public void TC_05_Click_And_Hold_Element_Select_Multiple_Item()
	{
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
		// Tạo ra 1 list chứa hết tất cả 12 number
		List<WebElement> allNumber= driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		// Lệnh in ra bao nhiêu số trong List
		System.out.println("allNumber= " + allNumber.size());
		// index từ 0-11: indev
		// 1-2-..12: element value
		// Muốn lấy giá trị thì thông qua index
		action.clickAndHold(allNumber.get(0)).moveToElement(allNumber.get(10)).release().perform();
		//Verify
		List<WebElement> allnumberSlected=driver.findElements(By.xpath("//ol[@id='selectable']/li[contains(@class,'ui-selected')]"));
		System.out.println("allnumberSlected= " + allnumberSlected.size());
		 Assert.assertEquals(allnumberSlected.size(),9);
	}
	//@Test
	public void TC_06_Click_And_Hold_Element_Select_Multiple_Item_Ramdom()
	{
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
		// Tạo ra 1 list chứa hết tất cả 12 số
		List<WebElement> allNumber= driver.findElements(By.xpath("//ol[@id='selectable']//li"));
		System.out.println("allNumber= " + allNumber.size());
		//Nhấn phím control xuống
		action.keyDown(Keys.CONTROL).perform();
		//Click vào các số 3,6,12
		action.click(allNumber.get(2)).click(allNumber.get(5)).click(allNumber.get(11)).perform();;
		//Nhấn phím control ra
		action.keyUp(Keys.CONTROL).perform();
		//Verify
		List<WebElement> allnumberSelect= driver.findElements(By.xpath("//ol[@id='selectable']/li[contains(@class,'ui-selected')]"));
		System.out.println("allnumberSelect= " + allnumberSelect.size());
		Assert.assertEquals(allnumberSelect.size(), 3);
	}
	@Test
	public void TC_07_Double_Click()
	{
		driver.get("https://automationfc.github.io/basic-form/index.html");
		action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
		//Assert.assertEquals(driver.findElement(By.xpath("//p[@id='demo']")).getText(), "Hello Automation Guys!");
		Assert.assertTrue(driver.findElement(By.xpath("//p[@id='demo']")).isDisplayed());
	}
	
	
	
	
	@AfterClass
	public void afterClass() {
	}

}
