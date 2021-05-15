package Training.CalculatorAPI;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
public class TestDivisionFunctionality {
	
	Calculator Cal;
	int Res;
	
	@BeforeClass
	public void CreateObj()
	{
		System.out.println(" I am in before class");
		Cal=new Calculator();
	
	}
	@BeforeMethod
	public void InitialiseRes()
	{
		System.out.println(" I am in   before method class");
		Res=0;
	}
	@Test(priority=1,groups= {"RegressionTesting"})
	public void TestDivisionWithPositiveValues()
	{
		System.out.println(" i am in test case 1 of division functionality");
		Res=Cal.Division(100,2);
		Assert.assertEquals(Res,50,"Division is not working with Positive Values");
	}
	@AfterMethod
	public void AfterMethod()
	{
		System.out.println("Im in After Method class");
	}
	
	@Test(priority=2,groups= {"RegressionTesting"})
	public void TestDivisionWithNegativeValues()
	{
		System.out.println("I am in test case 2 of Division functionality");
		Res=Cal.Division(-100,-2);
		Assert.assertEquals(Res,50,"Division is not working with Positive Values");
		
	}
	@AfterClass
     public void ReleaseObj()
{
	Cal=null;
}
	
}
