package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) {
		XSSFWorkbook excelWBook;
		XSSFSheet excelSheet;
		XSSFCell cell;

		String path = System.getProperty("user.dir") + "\\resources\\utilities\\ExcelRead.xlsx";
		String sheet = "Sheet1";

		try {
			FileInputStream fis = new FileInputStream(path);
			excelWBook = new XSSFWorkbook(fis);
			excelSheet = excelWBook.getSheet(sheet);
			cell = excelSheet.getRow(0).getCell(0);
			String cellData = cell.getStringCellValue();
			System.out.println(cellData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
