package com.qa.Pages;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import com.qa.TestBase.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//*[@id='divLogo']/img")
	@CacheLookup
	WebElement orangeHrmLogo;
	
	@FindBy(xpath="//input[@id='txtUsername']")
	@CacheLookup
	WebElement username;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//input[@id='btnLogin']")
	@CacheLookup
	WebElement clickLoginButton;
	
	public LoginPage(){
		PageFactory.initElements(driver,this);
	}
	
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean ValidateOrangeHrmLogo() {
		return orangeHrmLogo.isDisplayed();
	}
	
	public DashBoardPage EnterLoginDetails(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		clickLoginButton.click();
		return new DashBoardPage();
		
	}
	

}
