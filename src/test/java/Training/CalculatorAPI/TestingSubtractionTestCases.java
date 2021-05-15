package Training.CalculatorAPI;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestingSubtractionTestCases {
	
	
	Calculator Cal;
	@BeforeClass
	public void Init()
	{
		Cal=new Calculator();
	}
	
	@Test(priority=1)
	public void TestSubtractionWithPositiveNumbers()
	{
		int Result=Cal.Subtraction(50,40);
		Assert.assertEquals(Result, 10,"Subtraction does not work with Positiv Numbers");
	}

}
