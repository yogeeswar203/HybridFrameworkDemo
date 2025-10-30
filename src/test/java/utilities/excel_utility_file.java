package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel_utility_file {
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public XSSFCellStyle style;
	String filepath;
	
	public excel_utility_file(String path) {
		this.filepath = path;
	}
	
	public int get_Row_Count(String sheetName) throws IOException
	{
		fi = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		int row_count = sheet.getLastRowNum();
		
		workbook.close();
		fi.close();
		
		return row_count;
	}
	
	public int get_col_count(String sheetname, int row_num) throws IOException
	{
		fi = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(row_num);
		int col_count = row.getLastCellNum();
		
		workbook.close();
		fi.close();
		return col_count;
	}
	
	
	public String get_data_excel(String SheetName, int rownum, int colnum) throws IOException
	{
		fi = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(SheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);
		}catch(Exception e) {
			data = "Data is not Present";
		}
		workbook.close();
		fi.close();
		return data;
	}
	
	
	public void writeDataExcel(String sheetName, int rownum, int colnum, String data) throws IOException {
		
		fi = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		
		fo = new FileOutputStream(filepath);
		workbook.write(fo);
		
		fo.close();
		workbook.close();
		fi.close();
		
		
		
	}

}
