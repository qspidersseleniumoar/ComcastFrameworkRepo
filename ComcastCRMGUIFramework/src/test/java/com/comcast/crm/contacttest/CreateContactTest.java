package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ConatctPage;
import com.comcast.crm.objectrepositoryutility.ContactsInfoPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
/**
 * 
 * @author Deepak
 *
 */
public class CreateContactTest extends BaseClass {

	@Test(groups = {"smokeTest"})
	public void createConTactTest() throws Throwable {
		/* read testScritp data from Excel file*/
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		// step 2 : navigate to Contact module
		HomePage hp = new HomePage(driver);
		hp.getContactlnk().click();

		// step 3 : click on "create Contact" Button
		ConatctPage cp = new ConatctPage(driver);
		cp.getCreateNewOrgBtn().click();

		// step 4 : enter all the details & create new Contact
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContact(lastName);

		// verify Header phone Number info Expected Result
		
		String actHearder = cp.getHeaderMsg().getText();
		boolean status = actHearder.contains(lastName);
	     Assert.assertEquals(status, true);

	  
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actLastName, lastName);
		soft.assertAll();
	
	}

	@Test(groups = "regressionTest")
	public void createContactWithsupportDateTest() throws Throwable {

		// read testScritp data from Excel file
		String lastName = eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandomNumber();

		// step 2 : navigate to Contact module
		HomePage hp = new HomePage(driver);
		hp.getContactlnk().click();

		// step 3 : click on "create Contact" Button
		ConatctPage cp = new ConatctPage(driver);
		cp.getCreateNewOrgBtn().click();

		// step 4 : enter all the details & create new Contact
		String endDate = jLib.getSystemDateYYYYDDMM();
		String startDate = jLib.getRequriedDateYYYYDDMM(30);
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContactWithSupportDate(lastName, startDate, endDate);

		// verify Header phone Number info Expected Result
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String actStartDate = cip.getSuppoortStartDateInfo().getText();
		Assert.assertEquals(actStartDate.trim(), startDate);
		
		String actendDate = cip.getSupportEndDateInfo().getText();
		Assert.assertEquals(actendDate.trim(), endDate);
	
	}

	@Test(groups = "regressionTest")
	public void createContactWithOrgTest() throws Throwable {

		// read testScritp data from Excel file
		String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String conatctLastName = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandomNumber();

		// step 2 : navigate to Organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step 3 : click on "create Organization" Button

		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// step 4 : enter all the details & create new Organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);

		// verify Header orgName info Expected Result
	    OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getOrgNameInfo().getText();
        Assert.assertEquals(actOrgName.trim(), orgName);

		// step 5: navigate to Contact module
		hp.getContactlnk().click();

		// step 6 : click on "create Contact" Button
		ConatctPage cp = new ConatctPage(driver);
		cp.getCreateNewOrgBtn().click();

		// step 7 : enter all the details & create new Contact
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContactwithOrg(conatctLastName.trim(), orgName);

		// verify Header orgName info Expected Result
		actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		actOrgName = oip.getOrgNameInfo().getText();
		Assert.assertEquals(actOrgName.trim(), orgName);
	}

}
