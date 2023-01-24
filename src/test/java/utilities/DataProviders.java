package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	
	
	@DataProvider(name="SigninData")//here name is every DataProvider must hav some unique name
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\Magento_SigninData.xlsx"; //taking xl file freom testData
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for ExcelUtility
	
		int totalrows=xlutil.getRowCount("Sheet1"); //get the row frm sheet
		int totalcols=xlutil.getCellCount("Sheet1",1);//get the cell frm sheet v need to mention row num
		
		String signindata[][]=new String[totalrows][totalcols];//created for two dimension array 
												//which can store the data user and password
		for(int i=1;i<=totalrows;i++)//1  //read the data from xl storing in 2 dimensional array
		{
			for(int j=0;j<totalcols;j++)// 0       i is rows j is col
			{
				signindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);  //1  0
			}
		}
	return signindata; //returning 2 dimensional array
	}
	
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvidr 4
}
