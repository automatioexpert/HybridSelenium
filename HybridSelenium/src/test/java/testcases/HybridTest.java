package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.ExcelDataProvider;
import lib.Utility;

public class HybridTest extends BaseClass{
	
	@Test(dataProvider="loginData")
	public void createAccount(String uname,String pass)
	{
		logger=report.createTest("createAccount");
		
		System.out.println("Running our test with these parameters "+uname + " " +pass);
		
		driver=BrowserFactory.startBrowser("Chrome","https://opensource-demo.orangehrmlive.com/");
				
		logger.info("Application loaded");
		
		Utility.waitForWebElement(driver,"//input[@id='txtUsername']", 30).sendKeys(uname);
		
		Utility.waitForWebElement(driver,"//input[@id='txtPassword']", 30).sendKeys(pass);

		Utility.waitForWebElement(driver,"//input[@id='btnLogin']", 30).click();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"user landed on different page");
	}
	
	
	@DataProvider(name="loginData")
	public Object[][] createData()
	{
		
		System.out.println("Test Data is getting Generated");
		
		ExcelDataProvider excel=new ExcelDataProvider();
		
		int row= excel.getNumberOfRows("data");
		int column=excel.getNumberOfColumn("data");
		
		Object [][]arr=new Object[row][column];
		
		for(int i=0;i<row;i++)
		{
			
			for(int j=0;j<column;j++)
			{
				arr[i][j]=excel.getCellData("data",i,j);
			}
			
			//arr[i][1]=excel.getCellData("data",i,1);				
		}
	
		System.out.println("Test Data is Generated and can be used in our test");

		return arr;
	}
	

}
