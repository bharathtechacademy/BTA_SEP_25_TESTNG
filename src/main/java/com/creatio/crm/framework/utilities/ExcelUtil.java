package com.creatio.crm.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	
	//Common method to read the data from the Excel sheet and convert it into a 2D array.
	public static String [][] readData(String fileName, String sheetName){
		
		//Initialize the 2D array with empty values.
		String [][] data = null;
		
		try {
			//Read the Excel file in Java.
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\"+fileName);
			
			//Share the file details with Excel class and read the Excel
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			//Get into the sheet to read the data from specific Excel sheet.
			XSSFSheet sheet = wb.getSheet(sheetName);
			
			//Read the data from Excel sheet.
			int totalRows = sheet.getPhysicalNumberOfRows(); //rows with data.
			int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells(); //get total columns having data within the first row.
			
			//Create the array based on the total number of rows and columns having data.
			data = new String [totalRows][totalColumns];
			
			//Iterate over each and every row and column and store the data within the array.
			for(int r=0;r<totalRows;r++) {
				
				for(int c=0;c<totalColumns;c++) {
					
					//sheet.getRow(r).getCell(c).getCellType(); //get the type of data from cell
					
					data[r][c] =sheet.getRow(r).getCell(c).getStringCellValue(); //copy data from specific row and column in the form of string.
					
					System.out.println("Row "+(r+1)+" Column "+(c+1)+" Value is :"+data[r][c]);
				}
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		//Return the data
		return data;
	}
	
	//Common method to read the data from the Excel sheet and convert it List<Map<>>
	public static List<Map<String,String>> readExcelData(String fileName, String sheetName){
		List<Map<String,String>> data = new ArrayList<Map<String,String>>();
		
		try {
			//Read the Excel file in Java.
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\"+fileName);
			
			//Share the file details with Excel class and read the Excel
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			//Get into the sheet to read the data from specific Excel sheet.
			XSSFSheet sheet = wb.getSheet(sheetName);
			
			//Read the data from Excel sheet.
			int totalRows = sheet.getPhysicalNumberOfRows(); //rows with data.
			int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells(); //get total columns having data within the first row.
			
			//Iterate over each and every row and column and store the data within the List<Map>
			for(int r=1;r<totalRows; r++) {
				
				Map<String,String> rowData = new HashMap<String,String>();
				
				for(int c=0; c<totalColumns;c++) {
					String columnName = sheet.getRow(0).getCell(c).getStringCellValue();
					String columnValue = sheet.getRow(r).getCell(c).getStringCellValue();
					rowData.put(columnName,columnValue);
				}
				
				data.add(rowData);
				
			}
				
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return data;	
	}
	
	
	

	public static void main(String[] args) {
		
		//run the common method to read data from excel
		readData ("TestData.xlsx","Sheet1");
		
		//run the common method to read data from excel
		List<Map<String,String>> data = readExcelData ("TestData.xlsx","Sheet1");
		System.out.println(data.get(0).get("Otp"));
	}

}
