/*import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;*/

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FirstPageFactory {
	
	private Logger log = Logger.getLogger(FirstPageFactory.class);
	String sUrl = "http://107.170.213.234/catalog/index.php";
	public WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//*[@id='bodyContent']/div/div[1]/a[1]/u")
	private WebElement logYourselfIn;
	
	@FindBy(how = How.XPATH, using = "//*[@id='bodyContent']/div[2]/div/form/table/tbody/tr[1]/td[2]/input")
	private WebElement emailAddress;
	
	@FindBy(how = How.XPATH, using = "//*[@id='bodyContent']/div[2]/div/form/table/tbody/tr[2]/td[2]/input")
	private WebElement pwd;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tdb5']")
	private WebElement signIn;
	
	@FindBy(how = How.XPATH, using = "//*[@id='bodyContent']/div/div[2]/table/tbody/tr[1]/td[1]/a[1]/img")
	private WebElement samsungGalaxyTabLink;
	
	@FindBy(how = How.XPATH, using = "//*[@id='bodyContent']/form/div[1]/h1[1]")
	private WebElement galaxyTabPriceText;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tdb4']/span")
	private WebElement logOff;
	

	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		log.info("Opening Chrome Browser");
		driver.get(sUrl);
		System.out.println("Opening URL = " + sUrl);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		System.out.println("Close Chrome Browser");
	}
	
	@Test
	public void testCase1(){
		System.out.println("Start Test Case 1");
		PageFactory.initElements(this.driver, this);
		logYourselfIn.click();
		//driver.findElement(By.xpath("//*[@id='bodyContent']/div/div[1]/a[1]/u")).click();
		System.out.println("Clicked 'log yourself in' link");
		assertEquals("iBusiness", driver.getTitle());
		System.out.println("verified iBusiness Title");
		System.out.println("Test complete");
	}
	
	@Test (dataProvider = "testdata")
	public void testCase2(String userName, String PWD){
		System.out.println("Start test case 2");
		PageFactory.initElements(this.driver, this);
		logYourselfIn.click();
		//driver.findElement(By.xpath("//*[@id='bodyContent']/div/div[1]/a[1]/u")).click();
		System.out.println("Clicked 'log yourself in' link");
		//driver.findElement(By.name("email_address")).sendKeys("ecalix@test.com");
		emailAddress.sendKeys(userName);
		System.out.println("entered email address: ecalix@test.com");
		//driver.findElement(By.name("password")).sendKeys("test123");
		pwd.sendKeys(PWD);
		System.out.println("entered password: test123");
		//driver.findElement(By.xpath("//*[@id='tdb5']")).click();
		signIn.click();
		System.out.println("Clicked 'sign in' button");
		//driver.findElement(By.xpath("//*[@id='bodyContent']/div/div[2]/table/tbody/tr[1]/td[1]/a[1]/img")).click();
		samsungGalaxyTabLink.click();
		System.out.println("Clicked Samsung Galaxy Tab image link");
		String expectedText = "$749.99";
		String actualText = galaxyTabPriceText.getText();  /*driver.findElement(By.xpath("//*[@id='bodyContent']/form/div[1]/h1[1]")).getText();*/
		assertEquals(expectedText, actualText);
		System.out.println("Expected Text =" + expectedText + " found");
		System.out.println("This is the actual text: " + actualText);
		System.out.println("Verified text '$749.99'");
		//driver.findElement(By.xpath("//*[@id='tdb4']/span")).click();
		logOff.click();
		System.out.println("Clicked log off button");		
	}
	
	@DataProvider(name = "testdata")
	public Object[][] createData1(){
		
		return new Object[][]{
				{"ecalix@test.com", "test123"},
				{"ecalix@test.com", "test123"},
		};
		}
	}
