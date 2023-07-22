package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;
 

public class dataProviders {
	
	@DataProvider(name="data")
	public String[][] getAllData() throws IOException
	{
		String path=System.getProperty("user.dir")+"//TestData//Copy Userdata.xlsx";
		utilities ut=new utilities(path);
		
		int rownum=ut.getRowCount("Sheet1");
		int colnum=ut.getCellCount("Sheet1",1);
		String apidata[][]=new String[rownum][colnum];
		for(int i=1;i<=rownum;i++)
		{		
			for(int j=0;j<colnum;j++)
			{
				apidata[i-1][j]= ut.getCellData("Sheet1",i, j);
				 
			}
		}
		return apidata;
	
	}
	
	@DataProvider(name="UserNames")  
	public String[]  getUserNames() throws Exception
	{
		String path=System.getProperty("user.dir")+"//TestData//Copy Userdata.xlsx";
		utilities ut=new utilities(path);
		
		int rownum=ut.getRowCount("Sheet1");
		String apidata[]=new String[rownum];
		
		for(int i=1;i<=rownum;i++)
			{
				 apidata[i-1]=ut.getCellData("Sheet1", i, 1);
				
					 
			}
		return apidata;
	}
	

}
