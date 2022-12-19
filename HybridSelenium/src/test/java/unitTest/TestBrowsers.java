package unitTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import factory.BrowserFactory;

public class TestBrowsers {

	
	@Test
	public void testChrome()
	{
		WebDriver driver=BrowserFactory.startBrowser("Chrome","https://opensource-demo.orangehrmlive.com/");
		Assert.assertTrue(!driver.equals(null));
		BrowserFactory.closeBrowser(driver);
	}
	
	@Test
	public void testFirefox()
	{
		WebDriver driver=BrowserFactory.startBrowser("Firefox","https://opensource-demo.orangehrmlive.com/");
		Assert.assertTrue(!driver.equals(null));
		BrowserFactory.closeBrowser(driver);

	}
	
	@Test
	public void testIE()
	{
		WebDriver driver=BrowserFactory.startBrowser("IE","https://opensource-demo.orangehrmlive.com/");
		Assert.assertTrue(!driver.equals(null));
		BrowserFactory.closeBrowser(driver);

	}
	
}
