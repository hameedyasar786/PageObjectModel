package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;

public class BuzzPage extends TestBase{
	
	@FindBy(xpath="//img[@id='status_icon']")
	@CacheLookup
	WebElement buzzStatusIcon;
	
	@FindBy(xpath="//textarea[@id='createPost_content']")
	@CacheLookup
	WebElement clickCreatePost;
	
	@FindBy(xpath="//input[@id='postSubmitBtn']")
	@CacheLookup
	WebElement clickPostButton;
	
	public BuzzPage(){
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyBuzzPage() {
		return buzzStatusIcon.isDisplayed();
	}
	public void PostMessage(String Message) {
		clickCreatePost.sendKeys(Message);
		clickPostButton.click();
	}

}
