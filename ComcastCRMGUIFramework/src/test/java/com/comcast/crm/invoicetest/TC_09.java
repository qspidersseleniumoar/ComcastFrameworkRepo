package com.comcast.crm.invoicetest;

import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewInvoice;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.InvoicePage;

public class TC_09 extends BaseClass{
	
	@Test
	public void createInvoiceWith_Price_List() throws InterruptedException {
		HomePage home=new HomePage(driver);
		WebDriverUtility web=new WebDriverUtility();
		web.mousemoveOnElement(driver, home.getMoreLink());
		home.getInvoiceLink().click();
		
		InvoicePage invoice=new InvoicePage(driver);
		invoice.getCreateInvoice().click();
		
		CreatingNewInvoice createInvoice=new CreatingNewInvoice(driver);
		
		Thread.sleep(3000);
	}

}
