package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import lib.Utility;

public class Logout {

	WebDriver driver;
	
	public Logout(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//a[text()='Welcome Admin']") 
	WebElement welcomeText;
	
	@FindBy(xpath="//a[text()='Logout']") WebElement logout;
	
	
	public void verifyDashboard()
	{	
		WebDriverWait wait=new WebDriverWait(driver, 30);
		boolean status=wait.until(ExpectedConditions.urlContains("dashboard"));	
		Assert.assertTrue(status);
		
	}
	
	
	public void clickOnWelcomeText()
	{
		Utility.waitForWebElement(driver, welcomeText, 20).click();
	}
	
	public void clickOnLogOutButton()
	{
		Utility.waitForWebElement(driver, logout, 20).click();
	}
	
	
}
