package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import lib.Utility;

public class FirstDDT {

	WebDriver driver;
	
	@Test(dataProvider="loginData")
	public void createAccount(String uname,String pass)
	{
	

		System.out.println("Running our test with these parameters "+uname + " " +pass);
		
		driver=BrowserFactory.startBrowser("Chrome","https://opensource-demo.orangehrmlive.com/");
			
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
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			System.out.println("LOG : FAIL User is not able to login");
			
			System.out.println("Path of screenshot " +Utility.captureScreenshot(driver));

		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			System.out.println("LOG : SKIP Test did not executed");
		}
		
		
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
