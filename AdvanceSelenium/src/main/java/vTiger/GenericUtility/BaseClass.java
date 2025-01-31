package vTiger.GenericUtility;

import java.io.IOException;

import org.apache.commons.collections4.Put;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v114.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

public class BaseClass {
	public static WebDriver sdriver;
	PropertyFileutility putil = new PropertyFileutility();
	ExcelFileUtiliy eutil = new ExcelFileUtiliy();
	WebDriverUtility wutil = new WebDriverUtility();
	public WebDriver driver = null;

	@BeforeSuite(groups = {"smoke","Regerassion"})
	public void beforeSuiteConfig() {
		Reporter.log("---Data base connection Estabilishes---", true);
	}
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups = {"smoke","Regerassion"})
	public void beforeClassConfig(/*String BROWSER*/) throws IOException {
		String BROWSER = putil.toReadDataFromPropertyFile("browser");
		String URL = putil.toReadDataFromPropertyFile("url");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		sdriver = driver;
		Reporter.log("Browser got launch", true);

		wutil.ToMaximize(driver);
		wutil.WaitForElement(driver);
		driver.get(URL);
	Reporter.log("navigated to login page", true);

	}

	@BeforeMethod(groups = {"smoke","Regerassion"})
	public void beforeMethodConfig() throws IOException {
		LoginPage lp = new LoginPage(driver);
		String USERNAME = putil.toReadDataFromPropertyFile("username");
		String PASSWORD = putil.toReadDataFromPropertyFile("password");

		lp.getUserTextfield().sendKeys(USERNAME);
		lp.getPasswordTextfield().sendKeys(PASSWORD);
		lp.getLoginButton().click();
		Reporter.log("login sucessfullt", true);

	}

	@AfterMethod(groups = {"smoke","Regerassion"})
	public void afterMethodConfig() {
		HomePage hp = new HomePage(driver);
		wutil.ToMoveToElement(driver, hp.getLogoutlink());
		hp.getLogoutbutton().click();
		Reporter.log("logout sucsessfully",true);
	}

	@AfterClass(groups = {"smoke","Regerassion"})
	public void afterClass() {
		Reporter.log("Browser closed secssesfully", true);
		driver.quit();
		Reporter.log("browser close sucsessfully", true);

	}

	@AfterSuite(groups = {"smoke","Regerassion"})
	public void afterSuitConfig() {
		Reporter.log("---database connection disconnected--", true);
	}
}
