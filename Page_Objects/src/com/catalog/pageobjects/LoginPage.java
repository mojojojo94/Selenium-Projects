package com.catalog.pageobjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



public class LoginPage  {
	private WebDriver driver;
//	private Logger logger= Logger.getLogger(LoginPage.class);
	
	public  LoginPage(WebDriver driver){
		this.driver=driver;
	    Assert.assertEquals("Welcome, Please Sign In", driver.findElement(By.cssSelector("h1")).getText());
	}

	

	
   public void clickSignIn(){
		driver.findElement(By.xpath("//*[@id='tdb5']/span[2]")).click();
	//	logger.info("click the sign in ");
		
	}
	
	public void enterEmailID(String stext ){
		driver.findElement(By.name("email_address")).sendKeys(stext);
		//logger.info("entering the username ");
	}
	
   public void enterPWD(String stext ){
	   driver.findElement(By.name("password")).sendKeys(stext);
	  // logger.info("entering the pwd ");
	}
   
   public HomePage Login(String Username, String PWD){
	   enterEmailID(Username);
	   enterPWD(PWD);
	   clickSignIn();
	   return new HomePage(driver);
   }
   
   public void LoginWithValidUserName(){
	   enterEmailID("ecalix@test.com");
	   enterPWD("test123");
	   clickSignIn();
   }

}
