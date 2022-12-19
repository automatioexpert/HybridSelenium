package testcases;

import org.openqa.selenium.WebDriver;

import factory.BrowserFactory;
import lib.Utility;

public class DummyTest {

	public static void main(String[] args) {

		WebDriver driver=BrowserFactory.startBrowser("Chrome","https://opensource-demo.orangehrmlive.com/");
	
		Utility.waitForWebElement(driver,"//input[@id='txtUsername']", 30).sendKeys("admin");
		
		Utility.waitForWebElement(driver,"//input[@id='txtPassword']", 30).sendKeys("admin123");

		Utility.waitForWebElement(driver,"//input[@id='btnLogin']", 30).click();
		
	}
}
