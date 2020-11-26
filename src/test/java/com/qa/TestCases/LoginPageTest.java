package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Pages.DashBoardPage;
import com.qa.Pages.LoginPage;
import com.qa.TestBase.TestBase;

public class LoginPageTest extends TestBase{
	LoginPage login;
	DashBoardPage dashBoard;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		login=new LoginPage();
		}
	
	@Test(priority=1)
	public void LoginPageTitleTest() {
		String title=login.ValidateLoginPageTitle();
		Assert.assertEquals(title,"OrangeHRM");
	}
	@Test(priority=2)
	public void OrangeHrmLogoTest() {
		boolean flag=login.ValidateOrangeHrmLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void LoginTest() {
		dashBoard=login.EnterLoginDetails(prop.getProperty("un"),prop.getProperty("pwd"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
