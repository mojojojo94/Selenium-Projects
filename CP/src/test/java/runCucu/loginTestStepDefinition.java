package runCucu;

import static org.junit.Assert.*;

import static org.testng.AssertJUnit.assertEquals;
//import java.io.File;
//import java.util.Arrays;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class loginTestStepDefinition {
	
	
	String sURL="http://107.170.213.234/catalog/index.php";
	public WebDriver driver;
	
	 @Before
	    public void setup() {
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    System.out.println("Opening Chrome Browser");
			driver.get(sURL);
			System.out.println("Opening URL=" + sURL);
	}
		
	@Given("^I open Catalog$")
	public void I_open_google() {
		//Set implicit wait of 10 seconds and launch google
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://107.170.213.234/catalog/");
		System.out.println("Catalog page is opened");
	}
	
	@When("^I click log yourself in and enter username as \"([^\"]*)\" and enter password as \"([^\"]*)\"$")
	public void I_click_on_login_link(String email, String PWD) {	
	
		WebElement loginButton = driver.findElement(By.xpath("//*[@id='bodyContent']/div/div[1]/a[1]/u"));
		loginButton.click();
		System.out.println("clicked on log yourself in");
		
		WebElement userName = driver.findElement(By.xpath("//*[@id='bodyContent']/div[2]/div/form/table/tbody/tr[1]/td[2]/input"));
		userName.sendKeys(email);
		System.out.println("entered username");
		WebElement pWD = driver.findElement(By.xpath("//*[@id='bodyContent']/div[2]/div/form/table/tbody/tr[2]/td[2]/input"));
		pWD.sendKeys(PWD);
		System.out.println("entered password");
		WebElement signIn = driver.findElement(By.xpath("//*[@id='tdb5']"));
		signIn.click();
		System.out.println("clicked sign in");
		
	}
	
	@Then("^I should get result as \"([^\"]*)\"$")
	public void I_should_get_correct_result(String expectedText) {
		
		String actualText = driver.findElement(By.xpath("//*[@id='bodyContent']/h1")).getText();
				
		assertEquals(expectedText, actualText);
		
		driver.close();
	}
	
	 @After
	    public void closeBrowser() {
	        driver.quit();
	 }

}