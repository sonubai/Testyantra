package NewseleniumGrkid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Grid {

	public static void main(String[] args) throws MalformedURLException {
		//load the url
		URL url=new URL("http://54.67.56.35:4444/wd/hub");
		//set desired capability
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		//use remote webdriver
		RemoteWebDriver driver=new RemoteWebDriver(url,cap);
		driver.get("https://gmail.com");
		
		URL url1=new URL("http://54.67.56.35:555/wd/hub");
		DesiredCapabilities  cap1=new DesiredCapabilities();
		cap1.setBrowserName("firefox");
		cap1.setPlatform(Platform.WINDOWS);
		//use remote webdriver
		RemoteWebDriver driver1=new RemoteWebDriver(url1,cap1);
		driver.get("https://gmail.com");

	}

}


