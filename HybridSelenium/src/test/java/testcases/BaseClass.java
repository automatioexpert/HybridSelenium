package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import factory.BrowserFactory;
import lib.Utility;

public class BaseClass {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	Utility util;
	
	@BeforeSuite
	public void setup()
	{
		System.out.println("Extent report is getting started");
		
		//report=new ExtentReports();
		
		//ExtentHtmlReporter html=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\LearnAutomation+"+Utility.getCurrentDateTime()+".html");
		
		//report.attachReporter(html);
	
		System.out.println("Extent report is ready to use ");
		
	}
	
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void setupBrowser(String browser, String url)
	{
		
		Reporter.log("LOG: INFO : Creating browser instances", true);
			
		//driver=BrowserFactory.startBrowser(DataProviderFactory.getConfig().getValue("browser"),DataProviderFactory.getConfig().getStagingURL());
		
		driver=new BrowserFactory().startBrowser(browser,url);
		
		util=new Utility(driver, 30);
		
		Reporter.log("LOG: INFO : Browser instance is ready ", true);

	}
	
	@AfterClass
	public void closeBrowser()
	{
		
		Reporter.log("LOG: INFO : Closing browser instances", true);

		BrowserFactory.closeBrowser(driver);
		
		Reporter.log("LOG: INFO : Browser instances closed", true);

	}
	
	

	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		
		System.out.println("Driver value in after method is "+driver);
		
		System.out.println("Running After method Test executed with below status");

		System.out.println("Status value "+result.getStatus());
		
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			System.out.println("LOG : PASS User is able to login");
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			
			

		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			System.out.println("LOG : SKIP Test did not executed");
		}
		
		//report.flush();
	
	}
}
