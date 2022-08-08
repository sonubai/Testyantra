import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Brokenclass {

URL url;
HttpsURLConnection responce;
int statuscode;

@Test
	public void brokenlink()  {
	WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.olacabs.com");
		List<WebElement> element = driver.findElements(By.xpath("//a"));
		 List<String> list = new ArrayList<>();
		 for( WebElement link: element) {
			String linkstring = link.getAttribute("href");
			list.add(linkstring);
			list.remove(null);
			list.size();
		 }
		 for(String links:list) {
			 System.out.println(links);
			
			try {
				url = new URL(links);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			try {
				responce = (HttpsURLConnection)url.openConnection();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				responce.getResponseCode();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(statuscode!=200) {
				try {
					System.out.println(links+"====>"+statuscode+"===>"+responce.getResponseMessage());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 
			 
		 }
		 System.out.println(list.size());
	}
}
