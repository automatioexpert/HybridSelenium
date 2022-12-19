package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

public class BrowserFactory {

	
	static WebDriver driver;
	
	public static  WebDriver startBrowser(String browserName,String appURL)
	{
		
		Reporter.log("LOG :Info- Creating Browser Instance",true);
			
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			
			ChromeOptions opt=new ChromeOptions();
			opt.setAcceptInsecureCerts(true);
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			

		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			//FirefoxOptions opt=new FirefoxOptions();
			//opt.setAcceptInsecureCerts(true);
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			//driver=new Firef
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{
			InternetExplorerOptions opt=new InternetExplorerOptions();

			DesiredCapabilities cap=new DesiredCapabilities();
			
			cap.acceptInsecureCerts();
			
			opt.merge(cap);
			
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe");
			
			driver=new InternetExplorerDriver(opt);	
		}
		else
		{
			System.out.println("Sorry we dont support this browser as of now");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(appURL);
		
		System.out.println("LOG :Info- Browser Session Created");

		
		return driver;
	}
	
	
	public static void closeBrowser(WebDriver driver)
	{
		
		System.out.println("LOG :Info- Browser Session getting terminated");

		driver.quit();
		
		System.out.println("LOG :Info- Browser Session terminated");

	}
	
	
}
