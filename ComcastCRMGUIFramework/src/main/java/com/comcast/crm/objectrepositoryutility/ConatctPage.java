package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Deepak
 *
 */
public class ConatctPage {
	  
	WebDriver driver;
	 public ConatctPage(WebDriver driver) {           
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	
	 
	 @FindBy(className = "dvHeaderText")
	 private WebElement headerMsg;

	 

	public WebElement getHeaderMsg() {
		return headerMsg;
	}


	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createNewOrgBtn;

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	
	
	

}
