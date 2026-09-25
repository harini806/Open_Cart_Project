package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path="C:\\Users\\Harini\\eclipse-workspace\\Java_practice\\Open_Cart_Project\\TestData\\Opencart_LoginData_xlsx.xlsx";
		//Taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);//creatiing an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);
		
		String [][] logindata=new String[totalrows][totalcols];//created for two dimension array which we can store
		
		for(int i=1;i<=totalrows;i++)//1 //read data from xl file storing in two dimensional array
		{
			for(int j=0;j<totalcols;j++)//0  i is row j is col
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
		}
		return logindata;//returning two dimension array
	}
	//DataProvidder2
	//DataProvider3
}
