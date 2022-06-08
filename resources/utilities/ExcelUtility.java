
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	static XSSFWorkbook excelWBook;
	static XSSFSheet excelSheet;

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

	public static String[][] getTestData(String tableName) {
		String[][] testData = null;
		try {
			testData = null;
			XSSFCell[] boundaryCells = findCells(tableName);
			XSSFCell startCell = boundaryCells[0];
			XSSFCell endCell = boundaryCells[1];
			int startRow = startCell.getColumnIndex() + 1;
			int endRow = endCell.getColumnIndex() - 1;
			int startCol = startCell.getColumnIndex() + 1;
			int endCol = endCell.getColumnIndex() - 1;
			testData = new String[endRow - startRow + 1][endCol = startCol + 1];
			for (int i = startRow; i <= endRow; i++) {
				for (int j = startCol; j <= endCol; j++) {
					testData[i - startRow][j - startCol] = excelSheet.getRow(i).getCell(j).getStringCellValue();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testData;
	}

	private static XSSFCell[] findCells(String tableName) {
		String pos = "begin";
		XSSFCell[] cells = new XSSFCell[2];
		for (Row row : excelSheet) {
			for (Cell cell : row) {
				if (tableName.equals(cell.getStringCellValue())) {
					if (pos.equalsIgnoreCase("begin")) {
						cells[0] = (XSSFCell) cell;
						pos = "end";
					} else {
						cells[1] = (XSSFCell) cell;
					}
				}
			}
		}
		return cells;
	}
}
