
package Selenium;

import org.AttendanceSystem.genericutility.JavaUtility;
import org.AttendanceSystem.genericutility.UtilityObjectClass;
import org.AttendanceSystem.genericutility.WebdriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Listeners(org.AttendanceSystem.genericutility.AllureImplementation.class)
@Epic("Epic 1")
@Story("Story 1")
public class Allurepractice {
	//@Attachment(value="abc" , type="image/png")
	@Description("Description")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void AllureTest()
	{
		WebdriverUtility webdriverUtility= new WebdriverUtility();
		UtilityObjectClass.setWebdriverutility(webdriverUtility);
		UtilityObjectClass.setJavautility(new JavaUtility());
		WebDriverManager.edgedriver().setup();
		Allure.step("Browser executable files initialized");
		WebDriver driver=new EdgeDriver();
		UtilityObjectClass.setDriver(driver);
		Allure.step("Browser Launched successfully");
		driver.manage().window().maximize();
		Allure.step("Browser maximised successfully");
		driver.get("https://google.com");
		Allure.step("Application launched successfully");
		driver.findElement(By.name("q")).sendKeys("flipkart",Keys.ENTER);
		Allure.step("Product searched successfully");
		Assert.fail();
		Allure.step("Application wait for 3 sec");
		driver.quit();
		//Allure.step("Browser closed successfully");
	}

}
