package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToCreateOrganization {

	public static void main(String[] args) {

		// Launch Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");

		// Login to application with valid credentials
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		// Navigate to Organization
		driver.findElement(By.linkText("Organizations")).click();

		// click on create organization look up image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		// create organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("Qspiderssss");
		
		// save and verify

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String Oragnization = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		if (Oragnization.contains("Qspiderssss")) {
			System.out.println(Oragnization = "Organization created sucsessfully");
		} else {
			System.out.println(Oragnization + "failed");
		}
		// logout of application
		WebElement logoutLink = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(logoutLink).perform();
		driver.findElement(By.linkText("Sign Out")).click();

		// close
		driver.quit();

	}

}
