package utilities;

import java.io.IOException;
import java.io.Serial;

import org.openqa.selenium.SearchContext;
import org.testng.annotations.DataProvider;

public class DataProviders {
	
	public String mainpath ="D:\\mainProject\\HybridFrameworkDemo\\testData\\testData.xlsx";
	
	@DataProvider(name="loginData")
	public String [][] getData() throws IOException{
		String path = "D:\\mainProject\\HybridFrameworkDemo\\testData\\testData.xlsx";
		excel_utility_file util = new excel_utility_file(path);
		
		int row_count = util.get_Row_Count("Sheet1");
		int col_count = util.get_col_count("Sheet1", 1);
		
		String loginData[][] = new String [row_count][col_count];
		
		for(int i=1; i<=row_count; i++)
		{
			for(int j=0; j<col_count; j++)
			{
				loginData[i-1][j] = util.get_data_excel("Sheet1", i, j);
			}
		}
		
		return loginData;
		

		
	}
	
	
	@DataProvider(name="addEmpData")
	public String [][] getAddEmpData() throws IOException{
		String path = "D:\\mainProject\\HybridFrameworkDemo\\testData\\testData.xlsx";
		excel_utility_file util = new excel_utility_file(path);
		
		int row_count = util.get_Row_Count("Sheet2");
		int col_count = util.get_col_count("Sheet2", 1);
		
		String loginData[][] = new String [row_count][col_count];
		
		for(int i=1; i<=row_count; i++)
		{
			for(int j=0; j<col_count; j++)
			{
				loginData[i-1][j] = util.get_data_excel("Sheet2", i, j);
			}
		}
		
		return loginData;
	
	}
	
	@DataProvider(name="AdminSearchData")
	public String[][] getSearchAdminData() throws IOException{
		
		excel_utility_file util = new excel_utility_file(mainpath);
		
		int row_count = util.get_Row_Count("Sheet3");
		int col_count = util.get_col_count("Sheet3", 1);
		
		String searchData[][] = new String[row_count][col_count];
		
		for(int i=1; i<=row_count; i++)
		{
			for(int j=0; j<col_count; j++)
			{
				searchData[i-1][j] = util.get_data_excel("Sheet3", i, j);
			}
		}
		
		
		
		
		
		return searchData;
	}
	
	
	
	

}
