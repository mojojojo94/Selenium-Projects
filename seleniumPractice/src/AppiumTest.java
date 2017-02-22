import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;


public class AppiumTest {
	
	AndroidDriver driver;
	
	@Test
	public void Call() throws MalformedURLException{
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Samsung G 7 Edge");
		capabilities.setCapability("platformVersion", "6.0.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "");
		capabilities.setCapability("appActivity", "");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.findElementById("com.sec.android.app.launcher:id/app_icon").click();
		
		//driver.findElementById("com.sec.android.app.launcher:id/app_icon").click();
		//driver.findElementById("com.android.chrome:id/url_bar").sendKeys("google.com");
		//driver.findElementByClassName("android.widget.TextView").click();
	}
	
}
