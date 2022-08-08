package Selenium;
import java.time.Duration;

import org.AttendanceSystem.genericutility.ExcelUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeywordDrivenexample {
	@Test
	public void luanchApp() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
	  ExcelUtility utility=new ExcelUtility();
	  utility.initializeexcelfile("./src/test/resources/excel.xlsx");
	  String[][] alldata = utility.getMultipleDatafromexcel("Sheet1");
	  
	  for(int i=0;i<alldata.length;i++) {
		  String locatorname = alldata[i][2].split("###")[0];
		  System.out.println(locatorname);
		  String locatorvalue = alldata[i][2].split("###")[1];
		  System.out.println(locatorvalue);
		  if(alldata[i][1].equals("send")) {
			  driver.findElement(locatorselection(locatorname, locatorvalue)).sendKeys(alldata[i][3]);
		  }
		  else  if(alldata[i][1].equals("click")) {
			  driver.findElement(locatorselection(locatorname, locatorvalue)).click();
		  }
		  
	  }
	  driver.quit();
	}

	public By locatorselection(String locatorname,String locatorvalue) {
		By locator=null;
		if(locatorname.equalsIgnoreCase("id")) {
			locator=By.id(locatorvalue);
		}
		else if(locatorname.equalsIgnoreCase("name")) {
			locator=By.name(locatorvalue);
		}
		else if(locatorname.equalsIgnoreCase("xpath")) {
			locator=By.xpath(locatorvalue);
		}
		else if(locatorname.equalsIgnoreCase("linktext")) {
			locator=By.linkText(locatorvalue);
		}
		if(locator==null) {
			System.out.println("specify proper locator namein excel file");
			
		}
		return locator;
	
	}
}

