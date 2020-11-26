package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Pages.DashBoardPage;
import com.qa.Pages.LoginPage;
import com.qa.Pages.MyInfoPage;
import com.qa.TestBase.TestBase;

public class MyInfoPageTest extends TestBase{
	LoginPage login;
	DashBoardPage dashBoard;
	MyInfoPage myInfo;
	
	public MyInfoPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		myInfo=new MyInfoPage();
		login=new LoginPage();
		dashBoard=login.EnterLoginDetails(prop.getProperty("un"),prop.getProperty("pwd"));
		myInfo=dashBoard.clickMyInfoLink();
		
		}

	@Test(priority=1)
	public void validateInfoPage() {
		String actual=myInfo.validateMyInfoPage();
		Assert.assertEquals(actual,"Personal Details","Assertion Personal Details failed" );
	}
	@Test(priority=2)
	public void enterMyInfoPageDetails() {
		myInfo.enterMyInfoPageDetails(prop.getProperty("FN"),
				prop.getProperty("MN"),prop.getProperty("LN"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
