package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;

public class DashBoardPage extends TestBase {
	
	@FindBy(xpath="//div[@class='head']")
	@CacheLookup
	WebElement Dboard;
	
	@FindBy(xpath="//b[contains(text(),'My Info')]")
	@CacheLookup
	WebElement myInfo;
	
	@FindBy(xpath="//b[contains(text(),'Admin')]")
	@CacheLookup
	WebElement admin;
	
	@FindBy(xpath="//b[contains(text(),'Directory')]")
	@CacheLookup
	WebElement directory;
	
	@FindBy(xpath="//b[contains(text(),'Buzz')]")
	@CacheLookup
	WebElement buzz;
	
	public DashBoardPage(){
		PageFactory.initElements(driver,this);
	}

	public String ValidateDashBoardPage() {
		return Dboard.getText();
		}
	
	public MyInfoPage clickMyInfoLink() {
		myInfo.click();
		return new MyInfoPage();
	}
	
	public AdminPage clickAdminLink() {
	    admin.click();
		return new AdminPage();
	}
	
	public DirectoryPage clickDirectoryLink() {
		directory.click();
		return new DirectoryPage();
	}
	
	public BuzzPage clickBuzzLink() {
		buzz.click();
		return new BuzzPage();
	}
}
