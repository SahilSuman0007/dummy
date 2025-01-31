package vTiger.ContactTests;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import vTiger.GenericUtility.BaseClass;
import vTiger.GenericUtility.ExcelFileUtiliy;
import vTiger.ObjectRepository.ContactsInformation;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateContactName;
import vTiger.ObjectRepository.HomePage;

public class toCreateContactTest extends BaseClass {

	@Test(groups = "Smoke")
	public void toCreateContactTest_001() throws Exception, IOException {
		
		HomePage hp = new HomePage(driver);
		
		hp.getContactslink().click();
		Reporter.log("Navigated to contacts page", true);
		
		
		ContactsPage cp = new ContactsPage(driver);
		
		
		cp.getContactLookupImage().click();
		Reporter.log("Naviaged to xreate contacts page", true);
		
		
		CreateContactName CCN = new CreateContactName(driver);
		
		// excell
		ExcelFileUtiliy eutil = new ExcelFileUtiliy();
		
		
		String LASTNAME = eutil.toReadDataFromExcel("Contacts", 1, 2);
		CCN.getCreateContactName().sendKeys(LASTNAME);
		CCN.getSaveButton().click();
		//Assert.fail();
		Reporter.log("Naviagteted to contacts information page", true);

		ContactsInformation ci = new ContactsInformation(driver);
		String name = ci.getContactinformation().getText();
		//if (name.contains(LASTNAME)) {
			Reporter.log(name + "create contacts succesfully", true);
    //		} else {
			Reporter.log(name + " failled to create contacts", true);
	//	}
			
			Assert.assertTrue(name.contains(LASTNAME));

	}
}
