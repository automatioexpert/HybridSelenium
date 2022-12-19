package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import lib.Utility;


// In Page Object in each page we only write locators and methods to access them

public class HomePage {
	
	
	WebDriver driver;
	
	public HomePage(WebDriver ldriver) 
	{
		this.driver=ldriver;
	}
	

	@FindBy(how = How.ID_OR_NAME, using = "txtUsername") WebElement username;
	
	@FindBy(name="txtPassword") WebElement password;
	
	@FindBy(xpath="//input[@value='LOGIN']") WebElement loginButton;
	

	public void setUserName1()
	{
		driver.findElement(By.id("")).sendKeys("");
	}
	
	public void loginToApplication(String user,String pass)
	{
		Utility.waitForWebElement(driver, username, 20).sendKeys(user);
		Utility.waitForWebElement(driver, password, 20).sendKeys(pass);
		Utility.waitForWebElement(driver, loginButton, 20).click();
	}
	
	
	public void setUserName()
	{
		username.sendKeys("admin");
	}
	public void setPassword()
	{
		password.sendKeys("admin123");
	}
	
	public void clickOnLogin()
	{
		loginButton.click();
	}
	
	public void verifyTitle()
	{
		String title=driver.getTitle();
		
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	
}
