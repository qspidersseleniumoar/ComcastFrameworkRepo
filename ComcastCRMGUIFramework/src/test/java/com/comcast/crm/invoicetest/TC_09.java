package com.comcast.crm.invoicetest;

import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class TC_09 extends BaseClass{
	
	@Test
	public void createInvoiceWith_Price_List() throws InterruptedException {
		HomePage home=new HomePage(driver);
		WebDriverUtility web=new WebDriverUtility();
		web.mousemoveOnElement(driver, home.getMoreLink());
		home.getInvoicelink().click();
		
		Thread.sleep(3000);
	}

}
