package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	// Global Variables
	public String path;
	public FileInputStream fis = null;
	private XSSFWorkbook workbook = null; //
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	// Constructor to initialize variables
	public ExcelReader(String path) {
	this.path = path;
		try 
		{
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} 
			catch (Exception e) 
		{
				e.printStackTrace();
		}
	
	}

	// Method to call the value
	public String getCellData(String sheetName, String colName, int rowNum) 
	{
		// For Sheet
		int index = workbook.getSheetIndex(sheetName);
		int col_Num = 0;
		sheet = workbook.getSheetAt(index);
	
		// For Row
		row = sheet.getRow(0);
		for (int i = 0; i < row.getLastCellNum(); i++) 
		{
			if (row.getCell(i).getStringCellValue().trim().equals(colName.trim())) 
			{
				col_Num = i;
			}
		}

		// For Column
		row = sheet.getRow(rowNum - 1);
		cell = row.getCell(col_Num);
		return cell.getStringCellValue();
	}
	
			
	public List<Map<String,String>> getSheetData(String sheetName) throws IOException
	{
		List<Map<String,String>> listOfMaps= new ArrayList<Map<String,String>>(); // This is the return data
		
		ArrayList<String> headers = new ArrayList<String>();  //This is used to keep my headers frm each sheet
		
		
		// For Sheet
		int index = workbook.getSheetIndex(sheetName); //LoginPage (0)
		sheet = workbook.getSheetAt(index); // You got the index now load that sheet
	
		//Row 0 is the first row - which has all the heading/titles - 
		//put it in a arraylist
		row=sheet.getRow(0);
		                   
		for(int i=0;i<row.getLastCellNum();i++)
		{                                                                 
			headers.add(i,row.getCell(i).getStringCellValue().trim());
		}
		System.out.println("Headers:"+headers);
		
		row=sheet.getRow(1); // First data row
		int maxRow = sheet.getLastRowNum();//Till last row of data we need
		for(int rowCount=1;rowCount<=maxRow;rowCount++)
		{
			Map<String,String> map = new HashMap<String,String>(); // Actual Data is here {"username":.. ,"passowrd:"bkj"}
			int col=0;
			while(col<row.getLastCellNum())
			{
				Cell cell1 = sheet.getRow(rowCount).getCell(col);   
                switch (cell1.getCellType()) 
                {
                	case Cell.CELL_TYPE_STRING: //demo@techfios.com
                		map.put(headers.get(col),cell1.getRichStringCellValue().getString());
                		System.out.println(cell1.getRichStringCellValue().getString());
                		break;
                    
                	case Cell.CELL_TYPE_NUMERIC:
	                    if (DateUtil.isCellDateFormatted(cell1)) 
	                    {
	                    	map.put(headers.get(col),cell1.getDateCellValue().toString());
	                        System.out.println(cell1.getDateCellValue());
	                    } 
	                    else 
	                    {
	                    	map.put(headers.get(col),String.valueOf(Math.round(cell1.getNumericCellValue())));
	                        System.out.println(cell1.getNumericCellValue());
	                    }
	                    break;
                
                	case Cell.CELL_TYPE_BOOLEAN:
                    	map.put(headers.get(col),String.valueOf(cell1.getBooleanCellValue()));
	                    System.out.println(cell1.getBooleanCellValue());
	                    break;
                    
                	case Cell.CELL_TYPE_FORMULA:
	                	map.put(headers.get(col),String.valueOf(cell1.getCellFormula()));
	                	
	                    System.out.println(cell1.getCellFormula());
	                    break;
                    
                	default:
                		System.out.println();
               }// end of switch  
               col++;   
            } // end of while
			listOfMaps.add(map);
			System.out.println("Map:"+map);	
			
		}
		
		System.out.println("List Of Map:"+listOfMaps);
		this.workbook.close();
		return listOfMaps;	
	}
	
	/*
	public static void main(String[] args) throws IOException
	{
		ExcelReader exRd=new ExcelReader("//Users//rashmikanduluvavikraman//selenium-workspace//TestNGProject//src//main//java//testdata//TestNGProject1.xlsx");
		exRd.getSheetData("LoginPage");
	}
	*/
}
