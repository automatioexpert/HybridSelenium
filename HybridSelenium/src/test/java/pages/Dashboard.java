package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard {

	WebDriver driver;

	public Dashboard(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	@FindBy(xpath="//b[text()='Admin']") WebElement adminTab;
	
	public void clickOnAdminTab()
	{
		adminTab.click();
	}
}
