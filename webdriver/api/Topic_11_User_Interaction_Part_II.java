package api;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class Topic_11_User_Interaction_Part_II {
	WebDriver driver;
	Actions action;
	JavascriptExecutor jsExecutor;
  String project_location= System.getProperty("user.dir");
  String jsHelperPath= project_location + "\\dragAndDrop\\drag_and_drop_helper.js";
  @BeforeClass
  public void beforeClass() {
	  driver =new FirefoxDriver();
	  action =new Actions(driver);
	  jsExecutor = (JavascriptExecutor) driver;
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
 // @Test
  public void TC_07_Right_Click() {
	  //step 01
	  driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
	  action.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
	  //Verify Quit not contain (visible/ hover status)
	  Assert.assertTrue(driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit') "
	  + "and not(contains(@class,'context-menu-visible')) and not(contains(@class,'context-menu-hover'))]")).isDisplayed());
	  //Hover to quit
	  action.moveToElement(driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit')"
		 		+ "and not(contains(@class,'context-menu-visible')) and not(contains(@class,'context-menu-hover'))]"))).perform();
	  //Verify quit contain (visiable/ hover status)
	  Assert.assertTrue(driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit') "
			  + "and contains(@class,'context-menu-visible') and contains(@class,'context-menu-hover')]")).isDisplayed());
	  //click t quit
	 driver.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit')"
	 		+ "and contains(@class,'context-menu-visible') and contains(@class,'context-menu-hover')]")).click();;
	//Verify alert displayed
	 Assert.assertEquals(driver.switchTo().alert().getText(), "clicked: quit");
	 driver.switchTo().alert().accept();
  }
  
   // @Test
    public void TC_02_Drag_Drop_HTML4()
{
    	driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
    	WebElement sourceCircle=  driver.findElement(By.xpath("//div[@id='draggable']"));
    	WebElement targeCircle= driver.findElement(By.xpath("//div[@id='droptarget']"));
    	action.dragAndDrop(sourceCircle, targeCircle).perform();
    	Assert.assertEquals(targeCircle.getText(), "You did great!");
    
}
   // @Test
    public void TC_03_Drag_Drop_HTML5_Jquery() throws IOException
    {
    	driver.get("https://automationfc.github.io/drag-drop-html5/");
    	String sourceRectangleCss= "#column-a";
    	String targetRectangleCss= "#column-b";
    	String jsHelperContent = getJSFileContent(jsHelperPath);
    	//Drag A to B
    	jsHelperContent = jsHelperContent + "$(\"" + sourceRectangleCss + "\").simulateDragDrop({ dropTarget: \"" + targetRectangleCss + "\"});";
    	jsExecutor.executeScript(jsHelperContent);
    	Assert.assertTrue(driver.findElement(By.xpath("//div[@id='column-a']/header[text()='B'")).isDisplayed());
    	//Drag B to A
    //	jsExecutor.executeScript(jsHelperContent);
    	//Assert.assertTrue(driver.findElement(By.xpath("//div[@id='column-a']/header[text()='A'")).isDisplayed());
    }
    @Test
    public void TC_04_Drag_Drop_HTML5_Position() throws AWTException
    {
    	driver.get("https://automationfc.github.io/drag-drop-html5/");
    	//A to B
    	drag_the_and_drop_html5_by_offset("//div[@id='column-a']","//div[@id='column-b']");
    	Assert.assertTrue(driver.findElement(By.xpath("//div[@id='column-a']/header[text()='B']")).isDisplayed());
    	//B to A
    	drag_the_and_drop_html5_by_offset("//div[@id='column-a']","//div[@id='column-b']");
    	Assert.assertTrue(driver.findElement(By.xpath("//div[@id='column-a']/header[text()='A']")).isDisplayed());
    }
    public String getJSFileContent(String file) throws IOException {
		Charset cs = Charset.forName("UTF-8");
		FileInputStream stream = new FileInputStream(file);
		try {
			Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
			StringBuilder builder = new StringBuilder();
			char[] buffer = new char[8192];
			int read;
			while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
				builder.append(buffer, 0, read);
			}
			return builder.toString();
		} finally {
			stream.close();
		}
	}
    @SuppressWarnings("deprecation")
	public void drag_the_and_drop_html5_by_offset(String sourceLocator, String targetLocator) throws  AWTException {
       //Khai bao element
		WebElement source = driver.findElement(By.xpath(sourceLocator));
		WebElement target = driver.findElement(By.xpath(targetLocator));

		// Setup robot
		Robot robot = new Robot();
		robot.setAutoDelay(500);

		// Get size of elements chiều rộng chiều cao
		Dimension sourceSize = source.getSize();
		Dimension targetSize = target.getSize();

		// Get center distance, tính toán ra vị trí ở giữa của element
		int xCentreSource = sourceSize.width / 2;
		int yCentreSource = sourceSize.height / 2;
		int xCentreTarget = targetSize.width / 2;
		int yCentreTarget = targetSize.height / 2;
           //lấy ra vị trí ở trên màn hình
		Point sourceLocation = source.getLocation();
		Point targetLocation = target.getLocation();
		System.out.println(sourceLocation.toString());
		System.out.println(targetLocation.toString());

		// Make Mouse coordinate center of element
		sourceLocation.x += 20 + xCentreSource;
		sourceLocation.y += 110 + yCentreSource;
		targetLocation.x += 20 + xCentreTarget;
		targetLocation.y += 110 + yCentreTarget;

		System.out.println(sourceLocation.toString());
		System.out.println(targetLocation.toString());

		// Move mouse to drag from location
		robot.mouseMove(sourceLocation.x, sourceLocation.y);

		// Click and drag
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseMove(((sourceLocation.x - targetLocation.x) / 2) + targetLocation.x, ((sourceLocation.y - targetLocation.y) / 2) + targetLocation.y);

		// Move to final position
		robot.mouseMove(targetLocation.x, targetLocation.y);

		// Drop
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
  @AfterClass
  public void afterClass() {
  }

}
