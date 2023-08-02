package com.comcast.crm.orgtest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.listenerutility.ListImpClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createOrgTest() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		
		// read testScritp data from Excel file
		String orgName = eLib.getDataFromExcel("org", 1, 2);

		// step 2 : navigate to Organization module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Org Page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step 3 : click on "create Organization" Button
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create Org Page");
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// step 4 : enter all the details & create new Organization
		UtilityClassObject.getTest().log(Status.INFO, "Create a new Org");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		
		cnop.createOrg(orgName);
		UtilityClassObject.getTest().log(Status.INFO, orgName + "===>Create a new Org");

		// verify Header msg Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
	    Assert.assertEquals(true, actOrgName.contains(orgName));

	}

	@Test(groups = "regressionTest")
	public void createOrgwithPhoneNumberTest() throws Throwable {
		// read testScritp data from Excel file
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String orgName = eLib.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
		String phoneNumber = eLib.getDataFromExcel("org", 7, 3);

       //step 2 : navigate to Organization module
		UtilityClassObject.getTest().log(Status.INFO, "Create a new Org");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

       //step 3 : click on "create Organization" Button

		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

       //step 4 : enter all the details & create new Organization
		UtilityClassObject.getTest().log(Status.INFO, "Create a new Org with phone num");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrgPhoneNumber(orgName, phoneNumber);

        //verify Header phone Number info Expected Result 
		UtilityClassObject.getTest().log(Status.INFO, "verify the phone number");
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
	    Assert.assertEquals(true, actOrgName.contains(orgName));
		String actPhoneNumber = oip.getPhoneNumInfo().getText();
	    Assert.assertEquals(actPhoneNumber, phoneNumber);
		UtilityClassObject.getTest().log(Status.PASS, actPhoneNumber + "==>verify the phone number");

	}

	@Test(groups = "regressionTest")
	public void createOrgWithIndustriesTest() throws Throwable {
		// read testScritp data from Excel file
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String orgName = eLib.getDataFromExcel("org", 4, 2) + jLib.getRandomNumber();
		String induestry = eLib.getDataFromExcel("org", 4, 3);
		String type = eLib.getDataFromExcel("org", 4, 4);

        //step 2 : navigate to Organization module
		UtilityClassObject.getTest().log(Status.INFO, "Create a new Org");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

        //step 3 : click on "create Organization" Button
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

        //step 4 : enter all the details & create new Organization
		UtilityClassObject.getTest().log(Status.INFO, "Create a new Org with industry & type");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName, induestry, type);

        //verify the industries and type info
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		UtilityClassObject.getTest().log(Status.INFO, "verify the indutries & type info");
		String actOrgName = oip.getHeaderMsg().getText();
	    Assert.assertEquals(true, actOrgName.contains(orgName));
		String actIndutries = oip.getIndustryInfo().getText();
		Assert.assertEquals(actIndutries.trim(), induestry);
		UtilityClassObject.getTest().log(Status.PASS, actIndutries + "==> industry is verified");
		String actType = oip.getTypeInfo().getText();
		Assert.assertEquals(actType.trim(), type);
		UtilityClassObject.getTest().log(Status.PASS, actIndutries + "==> type is verified");


	}

}
