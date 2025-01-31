package vTiger.organisationTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import vTiger.GenericUtility.BaseClass;
import vTiger.GenericUtility.ExcelFileUtiliy;
import vTiger.GenericUtility.JavaFileUtility;
import vTiger.ObjectRepository.CreateOrganizationName;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInformationPage;
import vTiger.ObjectRepository.OrganizationPage;

public class toCreateOrganizationTest extends BaseClass {
	
	@Test(groups = "Regerassion")
	public void toCreateOrganizationTest_002() throws EncryptedDocumentException, IOException {
		
		
		HomePage hp=new HomePage(driver);
		hp.getOrganizations().click();
		
		Reporter.log("navigated to org page", true);
		
		OrganizationPage op = new OrganizationPage(driver);
		op.getOrganizationlookupPage().click();
		Reporter.log("navigated to create org  page", true);
		
		
		
		CreateOrganizationName CON=new CreateOrganizationName(driver);
		
		
		//excell
		ExcelFileUtiliy eutil =new ExcelFileUtiliy();
		JavaFileUtility jutil=new JavaFileUtility();
		
		String orgname = eutil.toReadDataFromExcel("Organization", 1, 2)+jutil.toGetRandomNumber();
		CON.getCreateOrganizationName1().sendKeys(orgname);
		CON.getSaveButton().click();
		
		
		Reporter.log("navigated to org inf page", true);
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String name = oip.getOrganizatininfo().getText();
		Assert.assertTrue(name.contains(orgname));
		
		
		
		
	}

}
