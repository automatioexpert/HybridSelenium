package unitTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import factory.ConfigDataProvider;
import factory.ExcelDataProvider;

public class FileUnitTest {

	@Test
	public void testExcelData() 
	{
		ExcelDataProvider excel=new ExcelDataProvider();
		String data=excel.getCellData("data",0,0);
		Assert.assertTrue(!data.equals(null));
	}

	
	@Test
	public void testConfigData() 
	{
		ConfigDataProvider config=new ConfigDataProvider();
		Assert.assertTrue(!config.getStagingURL().equals(null));
	}
	
}
