package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;

public class MyInfoPage extends TestBase {
	
	@FindBy(xpath="//h1[contains(text(),'Personal Details')]")
	@CacheLookup
	WebElement personalDetails;
	
	@FindBy(xpath="//*[@id='btnSave']")
	@CacheLookup
	WebElement clickEditOrSaveBtn;
	
	@FindBy(xpath="//*[@id='personal_txtEmpFirstName']")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(xpath="//*[@id='personal_txtEmpMiddleName']")
	@CacheLookup
	WebElement middleName;
	
	@FindBy(xpath="//*[@id='personal_txtEmpLastName']")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(xpath="//*[@id='personal_chkSmokeFlag']")
	@CacheLookup
	WebElement checkBoxSmoker;
	
	public MyInfoPage(){
		PageFactory.initElements(driver,this);
	}
	
	public String validateMyInfoPage() {
		return personalDetails.getText();
	}
	
	public void enterMyInfoPageDetails(String FN,String MN,String LN) {
		clickEditOrSaveBtn.click();
		firstName.clear();
		firstName.sendKeys(FN);
		middleName.clear();
		middleName.sendKeys(MN);
		lastName.clear();
		lastName.sendKeys(LN);
		checkBoxSmoker.click();
		clickEditOrSaveBtn.click();		
	}
	

}
