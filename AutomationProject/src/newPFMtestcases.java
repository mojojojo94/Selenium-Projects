
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class newPFMtestcases {
	
	String sURL="http://107.170.213.234/catalog/index.php";
	public WebDriver driver;
	////////////////////////////////////////////////////////
	//webelements for creating an account
	@FindBy(how = How.XPATH, using = "//*[@id='bodyContent']/div/div[1]/a[2]/u")
	private WebElement createanaccount;
	
	@FindBy(how = How.XPATH, using = "//*[@id='bodyContent']/form/div/div[2]/table/tbody/tr[1]/td[2]/input[1]")
	private WebElement maleRadioButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id='bodyContent']/form/div/div[2]/table/tbody/tr[1]/td[2]/input[2]")
	private WebElement femaleRadioButton;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='bodyContent']/form/div/div[2]/table/tbody/tr[2]/td[2]/input")
	private WebElement fName;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='bodyContent']/form/div/div[2]/table/tbody/tr[3]/td[2]/input")
	private WebElement lName;
	
	@FindBy(how = How.XPATH, using = "//*[@id='dob']")
	private WebElement dob;
	
	/*@FindBy(how = How.XPATH, using = "//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[5]/a")
	private WebElement sampleDate;*/
	
	@FindBy(how = How.XPATH, using = "//*[@id='bodyContent']/form/div/div[2]/table/tbody/tr[5]/td[2]/input")
	private WebElement emailAddress;
	
	@FindBy(how = How.XPATH, using = "//*[@id='bodyContent']/form/div/div[4]/table/tbody/tr[1]/td[2]/input")
	private WebElement streetAddress;
	
	@FindBy(how = How.XPATH, using = "//*[@id='bodyContent']/form/div/div[4]/table/tbody/tr[3]/td[2]/input")
	private WebElement postCode;
	
	@FindBy(how = How.XPATH, using = "//*[@id='bodyContent']/form/div/div[4]/table/tbody/tr[4]/td[2]/input")
	private WebElement city;
	
	@FindBy(how = How.XPATH, using = "//*[@id='bodyContent']/form/div/div[4]/table/tbody/tr[5]/td[2]/input")
	private WebElement selectState;
	
	@FindBy(how = How.XPATH, using = "//*[@id='bodyContent']/form/div/div[4]/table/tbody/tr[6]/td[2]/select")
	private WebElement selectCountry;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='bodyContent']/form/div/div[4]/table/tbody/tr[6]/td[2]/select/option[224]")
	private WebElement country;
	
	@FindBy(how = How.XPATH, using = "//*[@id='bodyContent']/form/div/div[5]/table/tbody/tr[1]/td[2]/input")
	private WebElement telephoneNumber;

	@FindBy(how = How.XPATH, using = "//*[@id='bodyContent']/form/div/div[6]/table/tbody/tr[1]/td[2]/input")
	private WebElement password;
	
	@FindBy(how = How.XPATH, using = "//*[@id='bodyContent']/form/div/div[6]/table/tbody/tr[2]/td[2]/input")
	private WebElement passwordConfirmation;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tdb4']")
	private WebElement continueButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tdb5']/span[2]")
	private WebElement secondContinueButton;
	
	////////////////////////////////////////////////////
	//Welcome to iBusiness Page
	
	@FindBy(how = How.LINK_TEXT, using = "log yourself in")
	private WebElement logyourselfin;
	
	
	//log in Page
	@FindBy(how = How.NAME, using = "email_address")
	private WebElement EmailAddress;
	
	@FindBy(how = How.NAME, using = "password")
	private WebElement pwd;
	
	@FindBy (how = How.XPATH, using = "//*[@id='tdb5']/span[2]")
	private WebElement signin;
	
	@FindBy (how = How.CSS, using = "#bodyContent > h1")
	private WebElement Header;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tdb4']/span")
    private WebElement logoff;
	
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    System.out.println("Opening Chrome Browser");
		driver.get(sURL);
		System.out.println("Opening URL=" + sURL);
	}
	
	@AfterMethod
	public void tearDown(){
		 driver.quit();
		 System.out.println("Close Browser");
//		 WebElement element = driver.findElement(By.xpath("//*[@id='columnLeft']/div[2]/div[2]/form/select"));
//         Select select=new Select(element);
//         select.selectByIndex(2);
	}
	
	@Test(dataProvider = "testdata1")
	public void testcase01(String firstName, String lastName, String DOB, String email, String strtAdd, String pstCd, String cty, String teleNum, String pwd, String pwdCONF){
		System.out.println("TestCase01 started");
		PageFactory.initElements(this.driver, this);
		createanaccount.click();
		System.out.println("clicked create an account link");
		maleRadioButton.click();
		System.out.println("selected male button");
		fName.sendKeys(firstName);
		System.out.println("entered first name");
		lName.sendKeys(lastName);
		System.out.println("entered last name");
		dob.sendKeys(DOB);
		System.out.println("clicked date of birth");
		/*sampleDate.click();
		System.out.println("clicked selected date");*/
		emailAddress.sendKeys(email);
		System.out.println("entered email");
		streetAddress.sendKeys(strtAdd);
		System.out.println("entered street address");
		postCode.sendKeys(pstCd);
		System.out.println("entered postcode");
		city.sendKeys(cty);
		System.out.println("entered city");
		selectState.sendKeys("California");
		System.out.println("selected state");
		selectCountry.click();
		System.out.println("clicked select country");
		country.click();
		System.out.println("selected country");
		telephoneNumber.sendKeys(teleNum);
		System.out.println("entered telephone number");
		password.sendKeys(pwd);
		System.out.println("entered password");
		passwordConfirmation.sendKeys(pwdCONF);
		System.out.println("entered password confirmation");
		/*continueButton.click();
		System.out.println("clicked continue");
		secondContinueButton.click();
		System.out.println("clicked continue");
		logoff.click();
		System.out.println("click log off button");
		System.out.println("End of Test Case");*/
	}
	
	@Test
	public void testcase02(){
	// driver = new FirefoxDriver();
	PageFactory.initElements(this.driver, this);
	logyourselfin.click();
	 System.out.println("CLick Log Yourself link");
	 assertEquals("iBusiness",driver.getTitle());
	 System.out.println("Verify the title");
	}
	
	@Test(dataProvider = "testdata3")
	public void testcase03(String UserName,String PWD){
		System.out.println("TestCase02 started");
		PageFactory.initElements(this.driver, this);
		 logyourselfin.click();
		 System.out.println("CLick Log Yourself link");
		 assertEquals("iBusiness",driver.getTitle());
		 System.out.println("Verify the title");
		 EmailAddress.sendKeys(UserName);
		 System.out.println("Entered the username");
		 pwd.sendKeys(PWD);
		 System.out.println("Entered the pwd");
		 signin.click();
		 System.out.println("click sign in button");
		 String ExpectedText="Welcome to iBusiness";
		 String ActualText=Header.getText();
		 assertEquals(ExpectedText,ActualText);
		 System.out.println("ExpectedText="+ ExpectedText+" Found");
		 logoff.click();
		 System.out.println("clicked log off button");
	}
	
	/*@Test
	public void testcase04(){
		System.out.println("TestCase04 started");
		PageFactory.initElements(this.driver, this);
	}*/
	
	@DataProvider(name = "testdata1")
	public Object [][] createData1(){
		return new Object[][]{
			{"Monty", "Python", "10/04/1990", "fake1@mail.com", "123 fake drive", "12345", "Halloween Town", "1234567890", "password", "password"},
		};
			
	}
	
	@DataProvider(name = "testdata3")
	public Object[][] createData3() {
	 return new Object[][] {
	   {"ecalix@test.com", "test123"},
	   {"ecalix@test.com", "test123"},
	 };
	}
	 


}
