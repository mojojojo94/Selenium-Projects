
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SecondTestScript {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    //driver = new FirefoxDriver();
	  System.out.println("Started");
	  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	  	driver = new ChromeDriver();
    baseUrl = "http://107.170.213.234/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSecondTestScript() throws Exception {
    driver.get(baseUrl + "/catalog/index.php?osCsid=6e7kg77cu3brn117j99iuria97");
    driver.findElement(By.cssSelector("u")).click();
    driver.findElement(By.name("email_address")).clear();
    driver.findElement(By.name("email_address")).sendKeys("ecalix@test.com");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("test123");
    driver.findElement(By.id("tdb5")).click();
    driver.findElement(By.cssSelector("img[alt=\"Samsung Galaxy Tab\"]")).click();
    new Select(driver.findElement(By.name("manufacturers_id"))).selectByVisibleText("Hewlett Packard");
    new Select(driver.findElement(By.name("manufacturers_id"))).selectByVisibleText("Microsoft");
    new Select(driver.findElement(By.cssSelector("select[name=\"manufacturers_id\"]"))).selectByVisibleText("Samsung");
    driver.findElement(By.linkText("Gadgets")).click();
    driver.findElement(By.linkText("Hardware->")).click();
    driver.findElement(By.cssSelector("img[alt=\"iBusiness\"]")).click();
    assertEquals("New Products For September", driver.findElement(By.cssSelector("h2")).getText());
    driver.findElement(By.cssSelector("#tdb4 > span.ui-button-text")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
