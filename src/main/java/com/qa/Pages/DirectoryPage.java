package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;

public class DirectoryPage extends TestBase {
	
	@FindBy(xpath="//input[@id='searchBtn']")
	@CacheLookup
	WebElement searchBtn;
	
	@FindBy(xpath="//input[@name='searchDirectory[emp_name][empName]']")
	@CacheLookup
	WebElement enterTheEmpName;
		
	public DirectoryPage(){
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyTheDirectoryPage() {
		return searchBtn.isDisplayed();
	}
	public void enterEmpNameToSearch(String FN) {
		enterTheEmpName.sendKeys(FN);
		searchBtn.click();
	}

}
