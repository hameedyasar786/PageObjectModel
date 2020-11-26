package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.Pages.AdminPage;
import com.qa.Pages.DashBoardPage;
import com.qa.Pages.LoginPage;
import com.qa.TestBase.TestBase;

public class AdminPageTest extends TestBase{
	LoginPage login;
	DashBoardPage dashBoard;
	AdminPage admin;
	
	public AdminPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
	    admin=new AdminPage();
		login=new LoginPage();
		dashBoard=login.EnterLoginDetails(prop.getProperty("un"),prop.getProperty("pwd"));
		admin=dashBoard.clickAdminLink();		
		}
	
	@Test(priority=1)
	public void validateAdminPage() {
		boolean flag=admin.verifyAdminPage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void enterSystemUsersDetails() {
		admin.EnterSystemUserDetails(prop.getProperty("Admin"),prop.getProperty("FN"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
