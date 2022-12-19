package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import factory.BrowserFactory;
import lib.Utility;

public class CreateExtentReport {
	
	@Test
	public void test1() throws IOException
	{

		
		WebDriver driver=BrowserFactory.startBrowser("Chrome","https://opensource-demo.orangehrmlive.com/");
		
		ExtentHtmlReporter html=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\Report.html");
		
		ExtentReports report=new ExtentReports();
		
		report.attachReporter(html);
		
		ExtentTest test1=report.createTest("Login Test");
		test1.pass("Login Passed");
		test1.pass("Current status ",MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());

		report.flush();
		
		ExtentTest test2=report.createTest("Logout Test");
		test2.fail("Logout Failed");
	
		test2.fail("Current status ",MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
		report.flush();
		
		ExtentTest test3=report.createTest("Payment Test");
		test3.pass("payment done");
		report.flush();
		
		ExtentTest test4=report.createTest("Account Test");
		test4.skip("Account test skipped");
		report.flush();
	}

}
