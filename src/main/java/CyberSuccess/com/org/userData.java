package CyberSuccess.com.org;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.OrangeHRMPages.LoginPage;

public class userData extends BaseClass {
	
	private static By table = By.id("resultTable");
	private static By checkBox = By.xpath("//th[@class='checkbox-col']");
	private static By headerRow = By.xpath("//table[@id='resultTable']/thead/tr/th");
	private static By bodyRow = By.xpath("//table[@id='resultTable']/tbody/tr");
	private static By tbCell = By.xpath("//table[@id='resultTable']/tbody/tr/td");
	private static By chkBox = By.xpath("//table[@id='resultTable']/tbody/tr/td[1]");
	
	static String filePath = "D:\\New folder\\UserData.xlsx";
	
	private static Workbook wb;
	private static Row row;
	private static Sheet sheet;
	
	@SuppressWarnings("unlikely-arg-type")
	public static void main (String[] args) throws Exception {
		getBrowserInstance("Chrome");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		
		LoginPage log = new LoginPage();
		log.login("Admin", "admin123");
		  
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		Robot robot = new Robot();
		robot.mouseWheel(5);
		
		List<WebElement> headRowData = new ArrayList<>();
		for (int i=2; i<9; i++) {
			String str = "//table[@id='resultTable']/thead/tr/th["+i+"]";
			headRowData.add(driver.findElement(By.xpath(str)));
		}
		
		
		headRowData.forEach((element)->{
			
			if (element.equals(checkBox)) {
				
			}else {
				String rowValue = element.getText();
				try {
					setExceldata(filePath, "userdata", 50, 7, rowValue);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		List<WebElement> bodyData = driver.findElements(tbCell);
		
		for (int i=0; i<bodyData.size()/8; i++) {
			bodyData.remove(i*8);
		}
		
		bodyData.forEach((element)->{
			
			/*if (!element.equals(chkBox)) {
				String bdValue = element.getText();
				System.out.println(bdValue);
				cellData.add(bdValue);
			}*/
	
		});
		
		
		
		System.out.println("cell size: "+bodyData.size());
		/*
		 * String filePath = "D:\\New folder\\UserData.xlsx"; FileOutputStream output =
		 * new FileOutputStream(filePath);
		 */
		
		
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
	
	private static void getWorkbookInstance(String filePath, FileInputStream input) throws IOException {
		String extension = filePath.substring(filePath.indexOf("."));
		if (extension.equals(".xlsx")) {
			wb = new XSSFWorkbook(input);
		} else if (extension.equals(".xlx")) {
			wb = new HSSFWorkbook(input);
		}
	}
	
	


}
