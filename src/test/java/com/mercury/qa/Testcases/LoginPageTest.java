package com.mercury.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mercury.qa.Base.TestBase;
import com.mercury.qa.Util.TestUtil;
import com.mercury.qa.pages.HomePage;
import com.mercury.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homePage;
	String sheetName = "TestData";
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage=new LoginPage();
		
	}
	@Test(priority=1)
	public void loginpagetitleTest() {
		String Title=loginpage.LoginPageTitle();
		Assert.assertEquals(Title, "Welcome: Mercury Tours");
	}
	@Test(priority=2)
	public void MercuryLogotitleTest() {
		boolean flag=loginpage.validateMercuryLogo();
		Assert.assertTrue(flag);
		}
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(dataProvider="getCRMTestData")
	public void loginTest(String username,String password) {
		//homePage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		homePage=loginpage.Login(username, password);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
