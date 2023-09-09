package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewProductPage {
	
	public CreatingNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "productname")
	private WebElement productNameTextField;
	
	@FindBy(name = "productcategory")
	private WebElement productCategoryDropDown;
	
	@FindBy(name = "unit_price")
	private WebElement unitPriceTextField;
	
	@FindBy(xpath = "(//input[@value=\"  Save  \"])[2]")
	private WebElement saveButton;

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getProductCategoryDropDown() {
		return productCategoryDropDown;
	}

	public WebElement getUnitPriceTextField() {
		return unitPriceTextField;
	}
	
	
	
}
