package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    static FileInputStream FIS = null;

    public FileInputStream getFileInputStream() throws FileNotFoundException {
        String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\data\\CustomerLoginData.xlsx";
        File srcFile = new File(filePath);

        try {
            FIS = new FileInputStream(srcFile);
        } catch (FileNotFoundException e) {
            System.out.println("Error in the file with message: " + e.getMessage());
            System.exit(0);
        }
        return FIS;
    }

    public Object[][] getDataFromExcel() throws IOException {
        FIS = getFileInputStream();
        XSSFWorkbook wb = new XSSFWorkbook(FIS);
        XSSFSheet sheet = wb.getSheetAt(0);

        int TotalNumberOfRows = (sheet.getLastRowNum() + 1);
        int TotalNumberOfCols = 2;

        String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols];

        for (int i = 0; i < TotalNumberOfRows; i++) {
            for (int j = 0; j < TotalNumberOfCols; j++) {
                XSSFRow row = sheet.getRow(i);
                arrayExcelData[i][j] = row.getCell(j).toString();
            }
        }

        wb.close();
        return arrayExcelData;
    }
}