package utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SingleDataSet_ExcelUtility {

	static XSSFWorkbook excelWBook;
	static XSSFSheet excelSheet;
	static XSSFCell cell;
	static XSSFRow row;

	// Set file path,open excel file
	// @params-Excel Path and Sheet Name
	public static void setExcelFile(String path, String sheet) throws Exception {

		try {
			FileInputStream fis = new FileInputStream(path); // open excel file
			excelWBook = new XSSFWorkbook(fis); // access excel data sheet
			excelSheet = excelWBook.getSheet(sheet);
		} catch (Exception e) {
			throw e;
		}
	}

	public static String getTestData(int rowNum, int colNum) {
		try {
			Cell cell = excelSheet.getRow(rowNum).getCell(colNum);
			String cellData = cell.getStringCellValue();
			return cellData;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "";
		}

	}

	public static String getDateTestData(int rowNum, int colNum) { // if excel contains date format value
		try {
			Cell cell = excelSheet.getRow(rowNum).getCell(colNum);
			DateFormat df = new SimpleDateFormat();
			Date dateValue = cell.getDateCellValue();
			String dateStringFormat = df.format(dateValue);
			return dateStringFormat;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "";
		}

	}

	public static void setTestData(String result, int rowNum, int colNum) throws Exception {
		try {
			row = excelSheet.getRow(rowNum);
			cell = row.getCell(colNum);
			if (cell == null) {
				cell = row.createCell(colNum);
				cell.setCellValue(result);
			} else {
				cell.setCellValue(result);
			}
			FileOutputStream fos = new FileOutputStream(Constants.File_Path + Constants.File_Name);
			excelWBook.write(fos);
			fos.flush();
			fos.close();
		} catch (Exception e) {
			throw e;
		}
	}

	public static void setTestData(double result, int rowNum, int colNum) throws Exception { // can be used to write
																								// double value
		try {
			row = excelSheet.getRow(rowNum);
			cell = row.getCell(colNum);
			if (cell == null) {
				cell = row.createCell(colNum);
				cell.setCellValue(result);
			} else {
				cell.setCellValue(result);
			}
			FileOutputStream fos = new FileOutputStream(Constants.File_Path + Constants.File_Name);
			excelWBook.write(fos);
			fos.flush();
			fos.close();
		} catch (Exception e) {
			throw e;
		}
	}
}
