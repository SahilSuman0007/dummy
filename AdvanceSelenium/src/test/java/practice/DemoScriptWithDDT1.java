package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DemoScriptWithDDT1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		
		FileInputStream pfis=new FileInputStream(".\\src\\test\\resources\\testData.properties");
		Properties prop=new Properties();
		prop.load(pfis);
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
		
		//EXCEL FILE
		FileInputStream efis=new FileInputStream(".\\src\\test\\resources\\testDataA1.xlsx");
		Workbook wb=WorkbookFactory.create(efis);
		String LASTNAME = wb.getSheet("Contacts").getRow(1).getCell(2).toString();
		
		
		//AUTOMATION script
		
		WebDriver driver=null;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("EDGE")) {
				driver=new EdgeDriver();
				
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);

		// Login to application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		// Navigate to Organization
		driver.findElement(By.linkText("Organizations")).click();
		// click on create organization look up image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();


		// create organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("Qspider22");
		// select chemical in the industry dropdown
		
		
		WebElement industry = driver.findElement(By.name("industry"));
		Select industrydropdown = new Select(industry);
		industrydropdown.selectByVisibleText("Energy");
        //to select customer in type dropdown
		WebElement typedrop = driver.findElement(By.name("accounttype"));
		Select typedropdown = new Select(typedrop);
		typedropdown.selectByVisibleText("Customer");

		// save and varify

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String Oragnization = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		if (Oragnization.contains("Qspiderss")) {
			System.out.println(Oragnization = "Organization created sucsessfully");
		} else {
			System.out.println(Oragnization + "failed");
		}

		// logout of application
		WebElement logoutLink = driver.findElement(By.xpath("//img[@src='themesF/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(logoutLink).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		// close
		driver.quit();
		
		}
	}


