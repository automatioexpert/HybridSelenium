package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.HomePage;
import pages.Logout;

public class HandleAuthe {

	
	@Test
	public void loginSucess() throws IOException
	{
		
		//WebDriver driver=BrowserFactory.startBrowser("Chrome", "http://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		Runtime.getRuntime().exec("C:\\Users\\Chandani_50\\Desktop\\AutoIT SCripts\\HandleAuthentication1.exe");
		
		
		WebDriver driver=BrowserFactory.startBrowser("Chrome", "http://the-internet.herokuapp.com/basic_auth");

		
		
		
	}
	
	
	
	
	
}
