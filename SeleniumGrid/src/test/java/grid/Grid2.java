package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Grid2 {
	
	@Test
	public void HomePageCheck() throws MalformedURLException {
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setBrowserName("firefox");
		//caps.setPlatform(Platform.);
		
		WebDriver driver = new RemoteWebDriver(new URL("http://10.3.15.128:4444"),caps);
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("selenium grid",Keys.ENTER);
	
		
	}
}