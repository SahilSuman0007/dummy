package practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ToCreateOrganizationWithIndustry {

	public static void main(String[] args) {

		// launch Browser
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

		Random r = new Random();
		int val = r.nextInt(100);

		// create organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("Qspider" + val);
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

		if (Oragnization.contains("Qspiderss"+val)) {
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
