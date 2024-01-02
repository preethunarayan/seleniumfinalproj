package GenericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MsExcelAutomation {
	
	public static String getExcelData(String sheetName,int rowNum,int CellNum) throws Exception{
		
		//step2:create an object of the test data sheet	
		FileInputStream fis=new FileInputStream(Constants.filepath);
		
		//step3:Taking the control of the workbook	
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		//step4:Take the control of the sheet
		XSSFSheet sheet=workbook.getSheet("Book1");
		

		//step4:Take the control of the row
		XSSFRow row=sheet.getRow(rowNum);
		
		//step5:get the data from cells from the above row	
		String data=row.getCell(CellNum).getStringCellValue();
		System.out.println("data=" + data);
		
		String username=row.getCell(3).getStringCellValue();
		String password=row.getCell(4).getStringCellValue();
		return data;
		
	}
	public static void setExcelData(String sheetName,int rowNum,int CellNum,String data) throws Exception{
		
	    //step2:create an object of the test data sheet	
		FileInputStream fis=new FileInputStream(Constants.filepath);
	
	    //step3:Taking the control of the workbook	
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		//step4:Take the control of the sheet
		XSSFSheet sheet=workbook.getSheet("Book1");
		

		//step4:Take the control of the row
		XSSFRow row=sheet.getRow(rowNum);
		
		//create a cell inside spreadsheet object		
		XSSFCell  cell=row.createCell(CellNum);
		
		//create an output stream to put data in object of spreadsheet
		FileOutputStream fos=new FileOutputStream(Constants.filepath);
		
		//set value in cell
		cell.setCellValue(data);
		
		//writes output this  to output stream
		workbook.write(fos);
		
		//close the workbook-mandatory step
		workbook.close();
		
	
	
	
}
}
