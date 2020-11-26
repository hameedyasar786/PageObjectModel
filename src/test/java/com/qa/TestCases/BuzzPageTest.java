package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Pages.BuzzPage;
import com.qa.Pages.DashBoardPage;
import com.qa.Pages.LoginPage;
import com.qa.TestBase.TestBase;

public class BuzzPageTest extends TestBase{
	LoginPage login;
	DashBoardPage dashBoard;
	BuzzPage buzz;
	
	public BuzzPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
	    buzz=new BuzzPage();
		login=new LoginPage();
		dashBoard=login.EnterLoginDetails(prop.getProperty("un"),prop.getProperty("pwd"));
		buzz=dashBoard.clickBuzzLink();		
		}
	
	@Test(priority=1)
	public void validateBuzzPage() {
		boolean flag=buzz.verifyBuzzPage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void enterTheStatus() {
		buzz.PostMessage(prop.getProperty("Message"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
