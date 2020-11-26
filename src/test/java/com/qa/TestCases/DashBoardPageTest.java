package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Pages.DashBoardPage;
import com.qa.Pages.LoginPage;
import com.qa.Pages.MyInfoPage;
import com.qa.TestBase.TestBase;

public class DashBoardPageTest extends TestBase {
	
	LoginPage login;
	DashBoardPage dashBoard;
	MyInfoPage myInfo;
	
	public DashBoardPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		myInfo=new MyInfoPage();
		login=new LoginPage();
		dashBoard=login.EnterLoginDetails(prop.getProperty("un"),prop.getProperty("pwd"));
	
		}
	
	@Test(priority=1)
	public void validateDashBoard() {
	    String actual=dashBoard.ValidateDashBoardPage();
	    Assert.assertEquals(actual, "Dashboard","Assertion of Dashboard failed");;
	}
	@Test(priority=2)
	public void verifyMyInfoPage() {
		myInfo=dashBoard.clickMyInfoLink();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
