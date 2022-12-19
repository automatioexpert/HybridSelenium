package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import factory.BrowserFactory;
import lib.Utility;

public class DDT2 {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	
	@BeforeClass
	public void setup()
	{
		System.out.println("Extent report is getting started");
		
		report=new ExtentReports();
		
		System.out.println("Extent report is ready to use ");

	}
	
	
	@Test(dataProvider="loginData")
	public void createAccount(String uname,String pass)
	{

		ExtentHtmlReporter html=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\LearnAutomation+"+Utility.getCurrentDateTime()+".html");
			
		report.attachReporter(html);
		
		logger=report.createTest("createAccount");
		
		System.out.println("Running our test with these parameters "+uname + " " +pass);
		
		driver=BrowserFactory.startBrowser("Chrome","https://opensource-demo.orangehrmlive.com/");
				
		logger.info("Application loaded");
		
		Utility.waitForWebElement(driver,"//input[@id='txtUsername']", 30).sendKeys(uname);
		
		Utility.waitForWebElement(driver,"//input[@id='txtPassword']", 30).sendKeys(pass);

		Utility.waitForWebElement(driver,"//input[@id='btnLogin']", 30).click();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"user landed on different page");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		System.out.println("Running After method Test executed with below status");

		System.out.println("Status value "+result.getStatus());
		
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			System.out.println("LOG : PASS User is able to login");
			try {
				logger.pass("Test Passed ", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
			} catch (IOException e) {
				
			}
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			
			try {
				logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
			} catch (IOException e) {
				
			}
			

		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			System.out.println("LOG : SKIP Test did not executed");
		}
		
		report.flush();
		
		BrowserFactory.closeBrowser(driver);
		
	}
	
	
	@DataProvider(name="loginData")
	public Object[][] createData()
	{
		
		System.out.println("Test Data is getting Generated");
		
		Object [][]arr=new Object[3][2];
		arr[0][0]="admin";
		arr[0][1]="admin123";
		arr[1][0]="selenium";
		arr[1][1]="welcome";
		arr[2][0]="Jenkins";
		arr[2][1]="Maven";
		System.out.println("Test Data is Generated and can be used in our test");

		return arr;
	}
	

}
