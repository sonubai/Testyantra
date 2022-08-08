package org.AttendanceSystem.genericutility;

import java.io.ByteArrayInputStream;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Allure;

public class AllureImplementation implements ITestListener {


	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Allure.addAttachment("def", new ByteArrayInputStream(UtilityObjectClass.getWebdriverutility().
				takesScreenShotElementBytes(UtilityObjectClass.getDriver())));
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	Allure.addAttachment("abc", new ByteArrayInputStream(UtilityObjectClass.getWebdriverutility().
			takesScreenShotElementBytes(UtilityObjectClass.getDriver())));
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
