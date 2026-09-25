package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	public static String path;
	
	public ExcelUtility(String path)
	{
		this.path=path;
	}
	
	// reading the total row count
	public static int getRowCount(String sheetName) throws IOException
	{
		fi= new FileInputStream(path); 
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
	    int rowcount = sheet.getLastRowNum();// total row count
	    workbook.close();
	    fi.close();
	    return rowcount;
		
	}
	
	//reading the total cell count
	public static int getCellCount(String sheetName, int rownum) throws IOException 
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum(); // total cell count
		workbook.close();
		fi.close();
		return cellcount;
		
	}
    // Reading the data
	public static String getCellData(String sheetName, int rownum , int cellnum) throws IOException
	{
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);// give row number
		
		cell=row.getCell(cellnum);
		
		DataFormatter formatter = new DataFormatter();
		// handling exception
		String data;
		try {
			
			data = formatter.formatCellValue(cell); //returns the formatted value of a cell as a String regardless
		}
		catch(Exception e)
		{
			data=""; // locate the cell value and returns empty if the cell doesnt have any value
		}
		
		workbook.close();
		fi.close();
	    return data;
		
		
	}
	
	// writing the data
	public static void setCellData(String sheetName,int rownum , int colnum, String data) throws IOException
	
	
	{
		File xlfile = new File(path);
		if(!xlfile.exists())  //If file not fount create a new file
		{
			
		
			workbook = new XSSFWorkbook();
			fo= new FileOutputStream(path);
			workbook.write(fo);
		}
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		
		if(workbook.getSheetIndex(sheetName)==-1) //if sheet not exist create a new sheet
			workbook.createSheet(sheetName);
		sheet=workbook.getSheet(sheetName);
		
		if(sheet.getRow(rownum)==null) //if row not exist create a new one
			sheet.createRow(rownum);
			row=sheet.getRow(rownum);
			
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}
			
			
			public static void fillgreencolor(String xlfile,String xlsheet, int rownum , int cellnum) throws IOException
	{
		fi = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		cell=row.getCell(cellnum);
		
		style = workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());// This method chooses the color
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND); // this method adds the color to the cell
		
		cell.setCellStyle(style);
		fo = new FileOutputStream(xlfile);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
	}
	
	public static void fillredcolor(String xlfile,String xlsheet, int rownum , int cellnum) throws IOException
	{
		fi = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rownum);
		cell=row.getCell(cellnum);
		
		style = workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());// This method chooses the color
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND); // this method adds the color to the cell
		
		cell.setCellStyle(style);
		fo = new FileOutputStream(xlfile);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
		
	}
}
