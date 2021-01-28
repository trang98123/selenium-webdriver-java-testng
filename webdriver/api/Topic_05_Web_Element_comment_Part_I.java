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
import org.testng.annotations.AfterTest;

public class Topic_05_Web_Element_comment_Part_I {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {

		driver = new FirefoxDriver();
		// driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://automationfc.github.io/multiple-fields/");

	}

	@Test
	public void TC_01_Web_Element_Command() {
		// Email textbox
		// khai báo và thao tác trực tiếp lên element+ ko cần khai báo biến
		WebElement element= driver.findElement(By.xpath("//input[@type='checkbox'"));
        driver.findElement(By.xpath("//input[@type='checkbox'")).sendKeys("selenium_19@gmail.com");
		// Khai báo biến rồi mới thao tác (acton: click/ senkey/ getTet/ select..)
        element.sendKeys("123456");
        
        //Xoa di
        element.clear();//**
        //Nhap lai gia tri moi
        element.sendKeys("456789");//**
      
        element.sendKeys("trang hoang");//**
        
        //Lấy giá trị nằm trong 1 Attribute
        element.getAttribute("placehoder");//**
        // Search entire store here...
        
        //Lấy ra stype của 1 element( font/ size/color-GUI)
        element.getCssValue("background");
        // #3399cc
        
        //GUI
        element.getLocation();
        element.getSize();
        element.getRect();
        
        //chụp hình lỗi đưa vào Report >>  Framwork
        //element.getScreenshotAs(target);
        
        //Đầu ra của hàm này >> đầu vào của 1 element khác (tagname tong xpath)
        //input/ div/ span
        String emailTextboxTagname= element.getTagName();
        driver.findElement(By.xpath("//"+emailTextboxTagname+ "[@id='email']" ));
      
        
        //Lấy ra text của 1 element bất kỳ (lable/ header/ span/ div..) --ko nằm trong attribute
        element.getText();
        
        
        //Kiểm tra mong muốn element đang hiển thị 
        Assert.assertTrue( element.isDisplayed());//**
        
        //Có thể thao tác đc
        Assert.assertTrue(element.isEnabled());//**
        
        //Đã duoc chon thanh cong (radio/ checkbox)
        Assert.assertTrue(element.isSelected());//**
        
        //Kiểm tra ko mong muốn element hiển thi
        Assert.assertFalse( element.isDisplayed());
        
        
        // ENTER vào trong 1 form (chỉ dùng đc trong form)
        element.submit();
		// Muon thao tac voi nhieu elemnt( 2 tro len) List <WebElement>

		//driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		// List <WebElement> checkboxes=
		// driver.findElements(By.xpath("//input[@type='checkbox']"));
		// System.out.println("Tong so checkbox tai page nay= "+ checkboxes.size());
		// for(WebElement checkbox : checkboxes)
		// {
		// checkbox.click();
		// }
	}

	@Test
	public void TC_02_Web_Element_Command() {

	}

	@Test
	public void TC_03_Web_Element_Command() {

	}

	@Test
	public void TC_04_Web_Element_Command() {

	}

	@AfterTest
	public void afterTest() {
	}

}
