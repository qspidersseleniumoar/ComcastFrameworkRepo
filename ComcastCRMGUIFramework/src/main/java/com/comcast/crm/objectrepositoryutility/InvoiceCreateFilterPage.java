package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoiceCreateFilterPage {
	
	public InvoiceCreateFilterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "viewName")
	private WebElement viewNameTextField;
	
	@FindBy(xpath = "(//input[@value='Save'])[2]")
	private WebElement saveButton;

	public WebElement getViewNameTextField() {
		return viewNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	
}
