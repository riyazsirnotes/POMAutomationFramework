package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilKit {

	static FileInputStream fis;
	
	public static HashMap<String,String> getTestData( String testcase) {
		
		
		
		try {
			fis = new FileInputStream("src\\test\\resources\\testdata\\excels\\Adactin Master Test Data.xlsx");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFSheet ws=wb.getSheet("com.adactin");
		
		ArrayList<Row> testCaseRows=getTestCaseRows(ws,testcase);
		
		System.out.println("Size of testCaseRows "+testCaseRows.size());
		
		HashMap<String,String> testDataMap=new HashMap<String,String>();
		
		for(int i=1;i<testCaseRows.size();i++)
		{
			
			int noOfCells=testCaseRows.get(0).getLastCellNum();
			
			for(int j=1;j<noOfCells;j++)
			{
				
				testDataMap.put(testCaseRows.get(0).getCell(j).getStringCellValue(), testCaseRows.get(i).getCell(j).getStringCellValue());
			}
			
			
		}
		
		return testDataMap;
		
	}
	private static  ArrayList<Row> getTestCaseRows(XSSFSheet ws, String testcase) {
		
		
		ArrayList<Row> allRows=new ArrayList<Row>();
		
		for(int i=0;i<=ws.getLastRowNum();i++)
		{
			
			if(!(ws.getRow(i)==null))
			{
				
				allRows.add(ws.getRow(i));
				
				
			}
			
		}
		
		
		System.out.println("Size of allRows "+allRows.size());
		ArrayList<Row> testcaseRows=new ArrayList<Row>();
		
		for(int i=0;i<allRows.size();i++)
		{
			if(allRows.get(i).getCell(0).getStringCellValue().equalsIgnoreCase(testcase))
			{
				testcaseRows.add(allRows.get(i));
			}
			
		}
		
		System.out.println("Size of testcaseRows "+testcaseRows.size());
		return testcaseRows;
		
		
	}
	
	

}
