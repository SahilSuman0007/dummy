
package vTiger.GenericUtility;






import java.awt.Desktop.Action;
import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consist of method related to webdriver
 */

public class WebDriverUtility {
	/**
	 * this method is used to maxmize the window
	 * 
	 * @param driver
	 */
	public void ToMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

/**
 * 
 * @param driver
 */
	public void ToMinimize(WebDriver driver) {
		driver.manage().window().minimize();

	}

	/**
	 * This method will wait untill webelement are loaded in webpage(Implicit wait)
	 * 
	 * @param driver
	 */
	public void WaitForElement(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	/**
	 * This method will wait untill the element is clickable.
	 * 
	 * @param driver
	 * @param element
	 */
	public void ElementToClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method will wait untill the element is visible
	 * @param driver
	 * @param element
	 */
	public void VisibilityOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method will  handle the dropdown by using index
	 * @param element
	 * @param index
	 */
	public void ToHandleDropdown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * This method will handle dropdown using String value
	 * @param element
	 * @param value
	 */
	public void ToHandleDropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);

	}

	/**
	 *  this method will handle the dropdown using visible text
	 * @param text
	 * @param element
	 */
	public void ToHandleDropdown(String text, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	/**
	 *  This method is used to handle the frame using Index
	 * @param driver
	 * @param index
	 */
	public void ToHandleFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to handle the frame using String id or name
	 * @param driver
	 * @param id_name
	 */
	public void TohandlleFrame(WebDriver driver,String id_name) {
		driver.switchTo().frame(id_name);
		
	}
	/**
	 * This method is used to handle the frame ussing web element
	 * @param driver
	 * @param element
	 */
	public void ToHandleFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 *  This method is used to switch back from to main webpage
	 * @param driver
	 */
	 
	 
	public void ToSwitchframe(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to perform double click on web element
	 * @param driver
	 * @param element
	 */
	public void ToDoubleClick(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	/**
	 * This method is used to perform right click on webelememt
	 * @param driver
	 * @param element
	 */
	public void ToRightClick(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	/**
	 * This method is used to move cursor to an element
	 * @param driver
	 * @param element
	 */
	public void ToMoveToElement(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
		
	}
	/**
	 * This method is used to perform drag and drop
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void ToDragAndDrop(WebDriver driver,WebElement src,WebElement target) {
		Actions action=new Actions(driver);
		action.dragAndDrop(src, target).perform();
	}
	/**
	 * This method is used to perform click and hold  on webelement
	 * @param driver
	 * @param element
	 */
	public void ToClickAndHold(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.clickAndHold(element).perform();
	}
	/**
	 * This meyhod is used to switch driver control to alert and accept it
	 * @param driver
	 */
	public void ToHandleAlertPopUpAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is used to switch the driver control to alert and dismiss it
	 * @param driver
	 */
	public void ToHandleAlertPopUpAndDismis(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method is used to switch the driver control to alert and capture text
	 * @param driver
	 * @return
	 */
	public String ToHandleAlertPopUpAndCaptureText(WebDriver driver) {
		Alert alertpopup = driver.switchTo().alert();
		String alertmsg = alertpopup.getText();
		alertpopup.accept();
		return alertmsg;
		
	}
	/**
	 * This method is used to take a screenshot provided screenshot 
	 * @param driver
	 * @param screenshotname
	 * @return 
	 * @throws IOException
	 */
	public String ToTakeScreenShot(WebDriver driver,String screenshotname) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File src=new File("./errorshots/"+screenshotname+".jpeg");
		FileHandler.copy(temp, src);
		 return src.getAbsolutePath();
	}
	/**
	 * This method is used to switch driver control to window provided title
	 * @param driver
	 * @param partialWindowTilte
	 */
	public void ToSwitchWindow(WebDriver driver,String partialWindowTilte) {
		Set<String> allIds = driver.getWindowHandles();
		for(String id:allIds) {
			String windowTitle = driver.switchTo().window(id).getTitle();
			if(windowTitle.contains(partialWindowTilte)) {
				break;
			}
		}
		
	}
}
