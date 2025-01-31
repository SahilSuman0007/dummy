package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
		@FindBy(linkText = "Contacts")
		private WebElement contactslink;

		@FindBy(linkText = "Organizations")
		private WebElement Organizationslink;
		
		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private	WebElement logoutlink;
		
		@FindBy(linkText = "Sign Out")
	private	WebElement logoutbutton;

		public WebElement getLogoutlink() {
			return logoutlink;
		}

		public WebElement getLogoutbutton() {
			return logoutbutton;
		}

		public WebElement getContactslink() {
			return contactslink;
		}

		public WebElement getOrganizations() {
			return Organizationslink;
		}
		
	

}
