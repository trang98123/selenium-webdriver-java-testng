package api;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_03_Run_On_Chrome_Firefox {
    String project_location= System.getProperty("user.dir");
    WebDriver driver;
  @Test
  public void TC_01_Run_On_Firefox() {
	        //Selenium 2.53.1
			//Firefox 47.0.2
			//No need geckodriver
			// Mở trình duyệt
			driver = new FirefoxDriver();
			System.out.println(driver.toString());
			// driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Mở app
			driver.get("https://facebook.com");
			driver.close();
  }
  @Test
  public void TC_02_Run_On_Chome() {
	        //Selenium 2.53.1
			//Chome latest
			//Chome driver latest
	  System.setProperty("webdriver.chrome.driver", project_location + "\\browserDriver\\chromedriver.exe");
			// Mở trình duyệt
		driver=new ChromeDriver();
		System.out.println(driver.toString());
			// driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Mở app
			driver.get("https://facebook.com");
			driver.close();
  }
  
}
