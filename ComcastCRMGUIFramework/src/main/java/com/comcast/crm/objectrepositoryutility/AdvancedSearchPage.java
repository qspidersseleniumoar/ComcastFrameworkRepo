package com.comcast.crm.objectrepositoryutility;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvancedSearchPage {
	
	public AdvancedSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@value='New Condition']")
	private WebElement newConditionButton;
	
	@FindBy(xpath = "(//input[@value=' Search Now '])[2]")
	private WebElement searchNowButton;
	
	@FindBy(xpath = "//select[@name='fcol0']/../../../tr/td/select")
	private List<WebElement> dropDown;
	
	@FindBy(xpath = "//td[@class='dvtCellLabel']/../td/input[1]")
	private List<WebElement> textBox;

	public WebElement getNewConditionButton() {
		return newConditionButton;
	}

	public WebElement getSearchNowButton() {
		return searchNowButton;
	}

	public List<WebElement> getDropDown() {
		return dropDown;
	}

	public List<WebElement> getTextBox() {
		return textBox;
	}
	
}
