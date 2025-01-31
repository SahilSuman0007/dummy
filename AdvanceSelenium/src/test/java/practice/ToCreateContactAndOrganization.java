package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToCreateContactAndOrganization {

	public static void main(String[] args) {
		// Launch the Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888/index.php?action=index&module=Home");

		// Login to application with valid crendentials
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();
		
		// Navigate to contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		// click on create contact look up image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		// create contact with mandotory fields
		driver.findElement(By.name("lastname")).sendKeys("Villain");
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();

		String parentId = driver.getWindowHandle();
		Set<String> allwindowIds = driver.getWindowHandles();

		for (String id : allwindowIds) {
			// switch to child
			driver.switchTo().window(parentId);
			driver.findElement(By.linkText("Qspider74")).click();
			break;

		}
		// switch back to parent
		driver.switchTo().window(parentId);

		// save and varify
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (name.contains("Villain")) {
			System.out.println(name = "contact created sucsessfully");
		} else {
			System.out.println(name + "failed");
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
