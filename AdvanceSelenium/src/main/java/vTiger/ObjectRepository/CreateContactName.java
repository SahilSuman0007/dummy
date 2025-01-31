package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactName {

	public CreateContactName(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(name = "lastname")
	private WebElement CreatelastName;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;
	
	@FindBy(linkText = "Sign Out")
	private WebElement Logoutbutton;

	
	public WebElement getCreateContactName() {
		return CreatelastName;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}

	public WebElement getLogoutbutton() {
		return Logoutbutton;
	}

	
		
	}

	
	
	
	



	


