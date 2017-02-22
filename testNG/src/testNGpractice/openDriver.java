package testNGpractice;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class openDriver {
	String sUrl = "http://107.170.213.234/catalog/index.php";
	public WebDriver driver;
	
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Opening Chrom Browser");
		driver.get(sUrl);
		System.out.println("Opening URL = " + sUrl);
	}
	
	@After
	public void tearDown(){
		driver.quit();
		System.out.println("Close Chrome Browser");
	}
	
	@Test
	public void testCase1(){
		System.out.println("Start Test Case 1");
		driver.findElement(By.xpath("//*[@id='bodyContent']/div/div[1]/a[1]/u")).click();
		System.out.println("Clicked 'log yourself in' link");
		assertEquals("iBusiness", driver.getTitle());
		System.out.println("verified iBusiness Title");
		System.out.println("Test complete");
	}
	
	@Test
	public void testCase2(){
		System.out.println("Start test case 2");
		driver.findElement(By.xpath("//*[@id='bodyContent']/div/div[1]/a[1]/u")).click();
		System.out.println("Clicked 'log yourself in' link");
		driver.findElement(By.name("email_address")).sendKeys("ecalix@test.com");
		System.out.println("entered email address: ecalix@test.com");
		driver.findElement(By.name("password")).sendKeys("test123");
		System.out.println("entered password: test123");
		driver.findElement(By.xpath("//*[@id='tdb5']")).click();
		System.out.println("Clicked log in button");
		driver.findElement(By.xpath("//*[@id='bodyContent']/div/div[2]/table/tbody/tr[1]/td[1]/a[1]/img")).click();
		System.out.println("Clicked Samsung Galaxy Tab image link");
		String expectedText = "$749.99";
		String actualText = driver.findElement(By.xpath("//*[@id='bodyContent']/form/div[1]/h1[1]")).getText();
		System.out.println("This is the actual test: " + actualText);
		assertEquals(expectedText, actualText);
		System.out.println("Verified text '$749.99'");
		driver.findElement(By.xpath("//*[@id='tdb4']/span")).click();
		System.out.println("Clicked log off button");
		
		

		


		
	}

}
