package practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import vTiger.GenericUtility.ExcelFileUtiliy;
import vTiger.GenericUtility.PropertyFileutility;
import vTiger.GenericUtility.WebDriverUtility;
import vTiger.ObjectRepository.ContactsInformation;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateContactName;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

public class DemoScriptWithDDTandGUandPOPM {

	public static void main(String[] args) throws IOException {

		ExcelFileUtiliy eutil = new ExcelFileUtiliy();
		PropertyFileutility putil = new PropertyFileutility();
		WebDriverUtility wutil = new WebDriverUtility();

		// property file

		String URL = putil.toReadDataFromPropertyFile("url");
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");

		// excel file

		String LASTNAME = eutil.toReadDataFromExcel("Contacts", 1, 2);

		// Atomation script
		WebDriver driver = null;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("EDGE")) {
			driver = new EdgeDriver();

		}

		wutil.ToMaximize(driver);
		wutil.WaitForElement(driver);
		;
		driver.get(URL);

		LoginPage lp = new LoginPage(driver);
		lp.getUserTextfield().sendKeys(USERNAME);
		lp.getPasswordTextfield().sendKeys(PASSWORD);
		lp.getLoginButton().click();

		HomePage hp = new HomePage(driver);
		hp.getContactslink().click();

		// contact page

		ContactsPage cp = new ContactsPage(driver);
		cp.getContactLookupImage().click();

		// create contact

		CreateContactName CCN = new CreateContactName(driver);

		CCN.getCreateContactName().sendKeys(LASTNAME);
		CCN.getSaveButton().click();
		// information
		ContactsInformation ci = new ContactsInformation(driver);
		String name = ci.getContactinformation().getText();
		if (name.contains(LASTNAME)) {
			System.out.println(name + "contacts created succesfully");
		} else {
			System.out.println(name + "failled to create ");
		}
		wutil.ToMoveToElement(driver, CCN.getLogoutbutton());
		CCN.getLogoutbutton();
		driver.quit();

	}

}
