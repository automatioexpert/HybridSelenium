package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import factory.BrowserFactory;

public class UploadFileScenario {

	
	@Test
	public void loginSucess()
	{
		
		WebDriver driver=BrowserFactory.startBrowser("Chrome", "file:///C:/Users/Chandani_50/Desktop/Demo.html");
		
		driver.findElement(By.xpath("//input")).click();
		
		try {
			Runtime.getRuntime().exec("C:\\Users\\Chandani_50\\Desktop\\AutoIT SCripts\\ChromeFileUpload.exe");
		} catch (IOException e) {
			
		}
		
		
		
		
		
	}
	
	
	
	
	
}
