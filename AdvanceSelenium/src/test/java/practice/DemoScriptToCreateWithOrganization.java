package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import vTiger.GenericUtility.ExcelFileUtiliy;
import vTiger.GenericUtility.PropertyFileutility;
import vTiger.GenericUtility.WebDriverUtility;

public class DemoScriptToCreateWithOrganization {

	public static void main(String[] args) throws IOException {
		
		PropertyFileutility putil=new PropertyFileutility();
		ExcelFileUtiliy eutil=new ExcelFileUtiliy();
		WebDriverUtility wutil=new WebDriverUtility();
		
		//To read the data from propert file
		String URL = putil.toReadDataFromPropertyFile("url");
        String BROWSER = putil.toReadDataFromPropertyFile("browser");
        String USERNAME = putil.toReadDataFromPropertyFile("username");
      String PASSWORD = putil.toReadDataFromPropertyFile("password");
     String LASTNAME = eutil.toReadDataFromExcel("Contacts",1, 2);
     
     //TEST SCRIPT
     WebDriver driver=null;
    		 if(BROWSER.equalsIgnoreCase("chrome")) {
    			 driver=new ChromeDriver();
    			 
    		 }else if(BROWSER.equalsIgnoreCase("edge")) {
    			 driver=new EdgeDriver();
    		 }
    		 wutil.ToMaximize(driver);
    		 wutil.WaitForElement(driver);
    		 driver.get(URL);
    		 
    		// To login into application
    			driver.get(URL);
    			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
    			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
    			driver.findElement(By.id("submitButton")).click();

    			// Navigate to contact link
    			driver.findElement(By.linkText("Contacts")).click();

    			// click on create contact look up image
    			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
    			
    			// create contact with mandotory fields
    			driver.findElement(By.name("lastname")).sendKeys("Villain");
    			driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
    			wutil.ToSwitchWindow(driver,"Accounts");
    			driver.findElement(By.linkText("Qspiders")).click();
    			wutil.ToSwitchWindow(driver, "Contacts");

    			// Save and verify
    			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    			String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
    			if (name.contains(LASTNAME)) {
    				System.out.println(name + "contact create succesfully");
    			} else {
    				System.out.println(name + "faild to create contact");
    			}
    			// logout application
    			 WebElement logoutlink = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
    			wutil.ToMoveToElement(driver, logoutlink);
    			driver.findElement(By.linkText("Sign Out")).click();

    			// To close
    			driver.quit();

	}

}
