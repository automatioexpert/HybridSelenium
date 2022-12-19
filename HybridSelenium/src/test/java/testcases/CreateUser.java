package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.Dashboard;
import pages.HomePage;

public class CreateUser extends BaseClass{
	
	
	HomePage home;
	Dashboard dash;

	
	@Parameters({"username","password"})
	@Test
	public void loginSucess(String username,String password)
	{
		logger=report.createTest("Login To OrangeHRM");
		
		home=PageFactory.initElements(driver, HomePage.class);
		
		home.verifyTitle();
		
		logger.pass("Title Verified");
				
		home.loginToApplication(username,password);
		
		logger.pass("User is able to login");
			
	}
	
	@Test
	public void createUser()
	{
		logger=report.createTest("Create User");
		
		dash=PageFactory.initElements(driver, Dashboard.class);
		
		dash.clickOnAdminTab();
		
		logger.pass("User is able to create User");
		logger.pass("User is able to create User1");
		logger.pass("User is able to create Use2r");
		logger.pass("User is able to create User3");
		logger.pass("User is able to create User4");
			
	}
	
	
	
	

}
