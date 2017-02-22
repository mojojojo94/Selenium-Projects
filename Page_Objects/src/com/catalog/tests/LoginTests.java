package com.catalog.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.catalog.pageobjects.*;
import com.catalog.common.*;


public class LoginTests  {
		
	private WebDriver driver;
	public String getURL="http://107.170.213.234/catalog/index.php";
	public LoginPage LoginPage;
	public HomePage HomePage;
	public CommonMethods CM;
	
	@BeforeMethod
	public void setUp()throws IOException{
		Properties prop = new Properties();
		FileInputStream i = new
				FileInputStream("/Page_Objects/config.properties");
		prop.load(i);
		CM=new CommonMethods(driver);
		driver=CM.openBrowser(prop.getProperty("BrowserType"));
		CM.goToURL(prop.getProperty("URL"));
	
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown(){
		CM.closeBrowser();
		
	}
	

	@Test(dataProvider = "test1")
	public void testLogin(String emailid, String pwd){
	HomePage = new HomePage(driver);
	HomePage.clickLogyourselfLink();
    LoginPage=new LoginPage(driver);
	LoginPage.Login(emailid,pwd);
	CM.verifyText("Welcome to iBusiness");
	HomePage.clickLogOff();		
	}
	
	
	@Test
	public void testLoginError(){
		HomePage = new HomePage(driver);
		HomePage.clickLogyourselfLink();
		LoginPage=new LoginPage(driver);
		LoginPage.clickSignIn();
		String ExpectedText="Error: No match for E-Mail Address and/or Password.";
		CM.verifyText(ExpectedText);
		
		
	}
	
	@DataProvider(name = "test1")
	public Object[][] createData1() {
	 return new Object[][] {
	   { "ecalix@test.com", "test123" },
	 };
	}

	
	
}
