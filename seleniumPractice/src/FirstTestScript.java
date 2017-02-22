
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstTestScript {
  private WebDriver driver;
  private String baseUrl;


  @Before
  public void setUp() throws Exception {
	  System.out.println("Started");
	  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    //driver = new FirefoxDriver();
	  	driver = new ChromeDriver();
    baseUrl = "http://107.170.213.234/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testFirstTestScript() throws Exception {
    driver.get(baseUrl + "/catalog/index.php");
    driver.findElement(By.cssSelector("u")).click();
    driver.findElement(By.name("email_address")).clear();
    driver.findElement(By.name("email_address")).sendKeys("ecalix@test.com");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("test123");
    driver.findElement(By.id("tdb5")).click();
    assertEquals("Welcome to iBusiness", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.id("tdb4")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
   
  }



}
