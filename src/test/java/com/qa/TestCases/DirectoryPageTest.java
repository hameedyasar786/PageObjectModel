package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Pages.DashBoardPage;
import com.qa.Pages.DirectoryPage;
import com.qa.Pages.LoginPage;
import com.qa.TestBase.TestBase;

public class DirectoryPageTest extends TestBase {
	LoginPage login;
	DashBoardPage dashBoard;
	DirectoryPage directory;
	
	public DirectoryPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
	    directory=new DirectoryPage();
		login=new LoginPage();
		dashBoard=login.EnterLoginDetails(prop.getProperty("un"),prop.getProperty("pwd"));
		directory=dashBoard.clickDirectoryLink();		
		}
	
	@Test(priority=1)
	public void validateDirectoryPageBySearchButton() {
		boolean flag=directory.verifyTheDirectoryPage();
		Assert.assertTrue(flag);
	}
	@Test(priority=2)
	public void enterEmployeeNameToSearch() {
		directory.enterEmpNameToSearch(prop.getProperty("FN"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
