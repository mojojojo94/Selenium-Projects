package com.catalog.pageobjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
  private WebDriver driver;
  //private Logger logger= Logger.getLogger(HomePage.class);
  
	public  HomePage(WebDriver driver){
		this.driver=driver;
		String ExpectedText="Welcome to iBusiness";
	    String ActualText=driver.findElement(By.cssSelector("h1")).getText();
	    System.out.println("ExpectedText is="+ExpectedText+"\n"+"ActualText is="+ActualText);
	    Assert.assertEquals(ExpectedText,ActualText);
	}
	
	public void clickLogyourselfLink(){
		driver.findElement(By.xpath("//*[@id='bodyContent']/div/div[1]/a[1]/u")).click();
		//clickByXpath("//*[@id='bodyContent']/div/div[1]/a[1]/u");
	//	logger.info("click link");
		
	}
	
	   public void clickLogOff(){
		   driver.findElement(By.xpath("//*[@id='tdb4']/span")).click();
			//logger.info("click the log off ");
		   
	   }
  
}
