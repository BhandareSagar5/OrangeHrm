package CyberSuccess.com.org;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	private static Workbook wb;
	private static Row row;
	private static Sheet sheet;
	
	private static void getWorkbookInstance(String filePath, FileInputStream input) throws IOException {
		String extension = filePath.substring(filePath.indexOf("."));
		if (extension.equals(".xlsx")) {
			wb = new XSSFWorkbook(input);
		} else if (extension.equals(".xlx")) {
			wb = new HSSFWorkbook(input);
		}
	}
	
	public static Object[][] getExcelData(String filePath, String sheetName) throws IOException  {
		
		FileInputStream input = new FileInputStream(filePath);
		getWorkbookInstance(filePath, input);
		sheet = wb.getSheet(sheetName);
		
		int totalRows = sheet.getLastRowNum();
		row =sheet.getRow(0);
		int totalColumns = row.getPhysicalNumberOfCells();
		
		System.out.println("Total Columns: "+ totalColumns);
		System.out.println("Total Rows: "+ totalRows);
		
		Object [][] excelObject = new Object[totalRows+1][totalColumns];
		
		for (int i =1; i<= totalRows; i++) {
			
			for (int j=0; j< totalColumns; j++) {
				
				Cell cell = sheet.getRow(i).getCell(j);
			    excelObject[i][j] =Objects.isNull(cell)?null:getCellData(cell);
				}	
			}
		wb.close();
		return excelObject;
	}
	
	public static Object getCellData(Cell cell) {
		switch (cell.getCellType()) {
		
		case NUMERIC:
			return cell.getNumericCellValue();
		case STRING:
			return cell.getStringCellValue();
		case BOOLEAN:
			return cell.getBooleanCellValue();
		default:
			return "";
		}
	}
	
	public static void setExceldata(String filePath, String sheetName, int rowNum, int colNum, String value) throws IOException
	{
		FileInputStream input = new FileInputStream(filePath);
		getWorkbookInstance(filePath, input);
		
		if (Objects.isNull(wb.getSheet(sheetName))) {
			sheet = wb.createSheet(sheetName);
		} else {
			sheet = wb.getSheet(sheetName);
		}
		
		Row row = sheet.createRow(rowNum);
		row.createCell(colNum).setCellValue(value);
		
		FileOutputStream output = new FileOutputStream(filePath);
		wb.write(output);
		wb.close();
	}

}
