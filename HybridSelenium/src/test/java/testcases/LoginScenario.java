package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.Logout;

public class LoginScenario extends BaseClass{

	HomePage home;
	Logout logOut;

	@Parameters({"username","password"})
	@Test
	public void loginSucess(String username,String password)
	{
		//logger=report.createTest("Login To OrangeHRM");
		
		home=PageFactory.initElements(driver, HomePage.class);
		
		logOut=PageFactory.initElements(driver, Logout.class);
		
		home.verifyTitle();
		
		//logger.pass("Title Verified");
		
		/*home.loginToApplication(DataProviderFactory.getExcel().getCellData("data", 0, 0),
				DataProviderFactory.getExcel().getCellData("data", 0, 1));*/
		
		home.loginToApplication(username,password);
		
		//logger.pass("User is able to login");
		
		logOut.verifyDashboard();
		
		logOut.clickOnWelcomeText();
		
		logOut.clickOnLogOutButton();
		
		//util.acceptAlert();
		
		
		
	}
	
	
	
	
	
}
