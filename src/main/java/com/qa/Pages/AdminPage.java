package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.TestBase.TestBase;

public class AdminPage extends TestBase{
	
	@FindBy(xpath="//input[@id='btnAdd']")
	@CacheLookup
	WebElement addBtn;
	
	@FindBy(xpath="//a[@id='menu_admin_UserManagement']")
	@CacheLookup
	WebElement usrMngmntBtn;
	
	@FindBy(xpath="//a[@id='menu_admin_viewSystemUsers']")
	@CacheLookup
	WebElement userClick;
	
	@FindBy(xpath="//select[@id='searchSystemUser_userType']")
	@CacheLookup
	WebElement userRole;
	
	@FindBy(xpath="//input[@id='searchSystemUser_userName']")
	@CacheLookup
	WebElement userName;
	
	@FindBy(xpath="//input[@id='searchSystemUser_employeeName_empName']")
	@CacheLookup
	WebElement employeeName;
	
	@FindBy(xpath="//select[@id='searchSystemUser_status']")
	@CacheLookup
	WebElement status;
	
	@FindBy(xpath="//input[@id='searchBtn']")
	@CacheLookup
	WebElement clickSearchButton;
		
	public AdminPage(){
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyAdminPage() {
		return addBtn.isDisplayed();
	}
	
	public void EnterSystemUserDetails(String Admin, String FN) {
		
		Actions builder=new Actions(driver);
		builder.moveToElement(usrMngmntBtn).build().perform();
		userClick.click();
		
		userName.sendKeys(Admin);
		
		Select s=new Select(userRole);
		s.selectByValue("1");
		
		employeeName.sendKeys(FN);
		
		Select s1=new Select(status);
		s1.selectByValue("0");
		
		clickSearchButton.click();
		
	}

}
