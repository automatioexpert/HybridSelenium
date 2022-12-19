package unitTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class UnitTest1 {

	
	@Test
	public void test1()
	{
		
		Assert.assertEquals(true, true,"");
		
		Reporter.log("My Test",true);
		
	}
	
}
