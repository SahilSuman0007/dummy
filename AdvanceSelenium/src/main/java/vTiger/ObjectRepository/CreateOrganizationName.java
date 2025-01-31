package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationName {
	public CreateOrganizationName(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "accountname")
	private WebElement CreateOrganizationName1;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveButton;

	@FindBy(name = "industry")
	private WebElement industrydropdown;

	@FindBy(name = "industrytype")
	private WebElement typedropdown;

	public WebElement getCreateOrganizationName1() {
		return CreateOrganizationName1;
	}

	public WebElement getCreateOrganizationName() {
		return SaveButton;

	}

	public WebElement getSaveButton() {
		return SaveButton;
	}

	public WebElement getIndustrydropdown() {
		return industrydropdown;
	}

	public WebElement getTypedropdown() {
		return typedropdown;
	}

}
