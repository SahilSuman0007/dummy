package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	//Constructor
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	WebElement organizatininfo;
	public WebElement getOrganizatininfo() {
		return organizatininfo;
	}
	
	
}
