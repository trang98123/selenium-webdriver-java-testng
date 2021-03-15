package api;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeClass;


import java.util.ArrayList;


import java.util.List;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.jetty.html.Include;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class Topic_12_Iframe_Frame {
	WebDriver driver;
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",".\\browserDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	//@Test
	public void TC_01_Iframe() {
		//Step 01: Truy cap trang
		driver.get("https://automationfc.com/2020/02/18/training-online-automation-testing/");
		 //Step 02: Verify iframe hien thi
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='fb-page fb_iframe_widget']//iframe")));
		//Assert.assertEquals(driver.findElement(By.xpath("//a[text='Automation FC']")).getText(), "Automation FC");
		//Assert.assertTrue(driver.findElement(By.xpath("//iframe[contains(@title,'Facebook Social Plugin')]")).isDisplayed());
		//Step 03: Verify so luong like cua page facebook
		String likeText=driver.findElement(By.xpath("//a[@title='Automation FC']/parent::div/following-sibling::div")).getText();	
		//System.out.println(likeNumber);
		int likeNumber= Integer.parseInt(likeText.split(" ")[0].replace(",",""));
	  System.out.println(likeNumber);
		//Step 04: Click vao chat iframe
		assertThat(likeNumber, greaterThan(1900));	
		//Switch to Top window
	//	driver.switchTo().defaultContent();
	//	Assert.assertEquals(driver.findElement(By.className("post-title")).getText(), "[Training Online] – Fullstack Selenium WebDriver Framework in Java (Livestream)");
	    //Switch to Google doc
	//	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'docs.google.com')]")));
	//	Assert.assertEquals(driver.findElement(By.cssSelector(".exportFormTitle")).getText(), "KHÓA HỌC SELENIUM AUTOMATION TESTING");
	}
	@Test
	public void TC_03_Verify_TC_01_Iframe()
	{
		//step 01: truy cap trang
		driver.get("https://automationfc.com/2020/02/18/training-online-automation-testing/");
        //switch to ifame facebook
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'Facebook Social Plugin')]")));
		String likeText= driver.findElement(By.xpath("//a[text()='Automation FC']/parent::div/following-sibling::div")).getText();
		System.out.println(likeText);
		int likeNumber= Integer.parseInt(likeText.split(" ")[0].replace(",", ""));
		System.out.println(likeNumber);
		//Ve ifame ban dau
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'docs.google.com')]")));
		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='KHÓA HỌC SELENIUM AUTOMATION TESTING']")).getText(), "KHÓA HỌC SELENIUM AUTOMATION TESTING");
	}
    // @Test
     public void TC_02_Iframe_1()
     {//Step 01: truy cap trang web
    	 driver.get("https://kyna.vn/");
    	//Step 02: Verify facebook iframe hien thi
    	 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'www.facebook.com')]")));
    //	 Assert.assertEquals(driver.findElement(By.xpath("//a[@title='Kyna.vn']")).getText(), "Kyna.vn");
    	 //Verify so luong like cua facebook
    	 String likeText= driver.findElement(By.xpath("//a[@title='Kyna.vn']/parent::div/following-sibling::div")).getText();
    	
    	  int like= Integer.parseInt(likeText.split(" ")[0].replace("K", "000"));
    	 System.out.println(like);
    	 driver.switchTo().defaultContent();
    	 //Switch chat ifame
    	 driver.switchTo().frame("cs_chat_iframe");
    	 
    	 driver.findElement(By.xpath("//textarea[@ng-model='chatMessage.content']")).sendKeys("Automation Testing");
    	/* driver.findElement(By.xpath("//textarea[@ng-model='chatMessage.content']")).sendKeys(Keys.ENTER);
    	 sleepInSecond(5);
    	 Assert.assertTrue(driver.findElement(By.xpath("//input[@ng-model='userInfo.username']")).isDisplayed());
    	 //Switch to Top Window (Home page)
    	 driver.switchTo().defaultContent();
    	 driver.findElement(By.id("live-search-bar")).sendKeys("Excel");
    	 driver.findElement(By.cssSelector(".search-button")).click();
    	 
    	 List<WebElement> courseNameHeader= driver.findElements(By.cssSelector("div.content h4"));
    	 // khai bao 1 String chua het all
    	 List<String> courseNameText= new ArrayList<String>();
    	 
    	 //Dùng vòng for để duyệt qua course
    	for (WebElement courseElement : courseNameHeader) {
			System.out.println(courseElement.getText());
			courseNameText.add(courseElement.getText());
		}
    	 for ( String courseName: courseNameText) {
			Assert.assertTrue(courseName.contains("Excel"));
		}
    	*/
     }

      public void sleepInSecond(long timeInsecond ){
		try {
		Thread.sleep(timeInsecond *1000);	
	}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
      }
	@AfterClass
	public void afterClass() {
}

}
