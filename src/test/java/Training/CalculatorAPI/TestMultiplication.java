package Training.CalculatorAPI;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestMultiplication {

	private static final String RequestID = null;
	Calculator Cal;
	int Result;
	@BeforeClass
	public void Init()
	{
		Cal=new Calculator();
	
	}
	@BeforeMethod
	public void ReinitialisingResult()
	{
		Result=0;
	}
	
	@Test(priority=1,dataProvider="ProvidePositiveIntegerValues")

	public void TestMultiplicationWithPositiveValues(int Number1,int Number2,int ExpectedResult)
	{
	  Result = Cal.Multiplication(Number1,Number2);
	Assert.assertEquals(Result,ExpectedResult,"Multiplication does not work with positive numbers");
	}
	@DataProvider
	public Object[][] ProvidePositiveIntegerValues()
	{
		Object [][] SetOfValues=new Object[4][3];
		SetOfValues[0][0]=1;
		SetOfValues[0][1]=2;
		SetOfValues[0][2]=2;
		
		SetOfValues[1][0]=10;
		SetOfValues[1][1]=20;
		SetOfValues[1][2]=200;
		
		SetOfValues[2][0]=1000;
		SetOfValues[2][1]=2000;
		SetOfValues[2][2]=2000000;
		
		SetOfValues[3][0]=100;
		SetOfValues[3][1]=200;
	    SetOfValues[3][2]=20000;
	    
		return SetOfValues;
		
		
	}
	@BeforeSuite
	@Parameters({"RequestID"})
	public void CreateResultFolder(String RequestID)
	{
		System.out.println(" I am in Before Suite");
		try
		{
		
		Files.createDirectories(Paths.get("./"+RequestID));
	}
		catch(IOException e)
		{
			System.out.println("Problem in creating a Result Directory");
		}
}
	@Parameters({"RequestID"})
	@AfterSuite
	public void CopyResultFile(String ResultFolderName) throws Exception
	{
		System.out.println("I am in After suite");
		Files.copy(Paths.get("C:\\Users\\lenovo\\Training\\CalculatorAPI\\target\\surefire-reports\\emailable-report.html"), Paths.get("./"+ResultFolderName+"/Result.html"), StandardCopyOption.REPLACE_EXISTING);
	}

}

