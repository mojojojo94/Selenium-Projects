package com.catalog.common;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class CommonMethods {
	private  WebDriver driver;
	public DesiredCapabilities Capabilities;
	public CommonMethods(WebDriver driver){
		this.driver = driver;
	}
	
	public void setDriver(WebDriver driver){
		this.driver = driver;
	}
	
	public WebDriver openBrowser(String browserType){
		if (browserType.contentEquals("Firefox")){
			driver=new FirefoxDriver();
			System.out.println("opening browser");
		}else if (browserType.contentEquals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	
		     Capabilities = DesiredCapabilities.chrome();
	   		Capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
	   		driver = new ChromeDriver(Capabilities); 
	   		System.out.println("opening browser");
		}else if (browserType.contentEquals("Remote")){
//			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
//			driver=new RemoteWebDriver(Capabilities.chrome());
			driver=new RemoteWebDriver(Capabilities.firefox());
			
		}
		else{
			System.out.println("Please select the Firefox or Chome Browser");
			Assert.fail("Browser not selected");
		}
			
		driver.manage().window().maximize();
		System.out.println(" Browser is mazimized");
		driver.manage().deleteAllCookies();
		System.out.println("deleted all cookies");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	public void goToURL(String sURL){
		driver.get(sURL);
		System.out.println("opening url="+sURL);
	}

	public void closeBrowser(){
		driver.quit();
		System.out.println("close the browser ");
	}
	
	public void verifyText(String expected){
		 try{
			 driver.findElement(By.xpath("//*[contains(text(),'"+ expected.trim() +"')]"));
			 System.out.println("On page " + driver.getTitle() + ". Expected Text \""+ expected +"\" verified");
			// return true;
		 }
		 catch(NoSuchElementException e){
			 System.out.println("On page " + driver.getTitle() + ". Expected Text \""+ expected +"\" not found");
			 Assert.fail("On page " + driver.getTitle() + ". Expected Text \""+ expected +"\" not found");
		 }
		 
	}
	
	public void clickByXpath(String stext){
		driver.findElement(By.xpath(stext)).click();
		System.out.println("click the link ");
	}
	
//	public void Click(WebElement slocator){
//		try{
//			slocator.click();
//			System.out.println(slocator+"=clicked");
//		}catch(Exception e){
//	        System.out.println(slocator+"=not available");
//	        Assert.fail("test failed");
//	        
//	    }
//	}
	
	public void Click(WebElement slocator){
		try {
			
			String Element=slocator.getText();
			if ((Element.isEmpty()) || (Element==null)){
				Element=slocator.getAttribute("value");
			}
			System.out.println(Element + " trying to click");

			slocator.click();
			System.out.println(Element + " clicked ");
			acceptPopup();
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(slocator + " not clicked ");
		}
	}
	
	public void acceptPopup() {
		try {
			Alert alert = driver.switchTo().alert();
			//Thread.sleep(10000);
			alert.accept();
			driver.switchTo().defaultContent();
			System.out.println("Alert Accepted");
		} catch (Exception e) {
			// Sometimes the text exist, but not the accept button.
			System.out.println("Alert not found");
			//		
		}
	
		}
	
	
	public void setValue(WebElement slocator,String sValue){
		String Element=slocator.getText();
		try {	
			System.out.println(Element + "trying to set the value");
			slocator.clear();
			slocator.sendKeys(sValue);
			System.out.println(sValue + " entered");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(Element + "field not found");
		}
	}
	
	
}

