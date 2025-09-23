import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadAndWriteDataFromExcelSheet {

    public static void  readSingleDataFromExcel(FileInputStream fileInputStream) throws IOException {
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("Sheet1");
        Row row = sheet.getRow(2);
        Cell cell = row.getCell(0);
        System.out.println(cell.getStringCellValue());
        workbook.close();
    }

    public static void  readMultipleDataFromExcel(FileInputStream fileInputStream) throws IOException {
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("Sheet1");

        for( int i = 0 ; i<= sheet.getLastRowNum(); i++){
            Row row = sheet.getRow(i);
            for (int j=0; j<=sheet.getLastRowNum();j++)
            {
                Cell cell = row.getCell(j);
                System.out.println(cell.getStringCellValue());
            }
        }
        workbook.close();
    }

    public static void writeDataIntoCell(FileInputStream fileInputStream) throws IOException {
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("Sheet1");
        Row row = sheet.createRow(2);
        Cell cell = row.createCell(0);
        cell.setCellValue("Sanjay");

        FileOutputStream fileOutputStream = new FileOutputStream(System.getProperty("user.dir") + "\\src\\main\\testData\\creds.xlsx");
        workbook.write(fileOutputStream);
        workbook.close();

    }

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\testData\\creds.xlsx");
//        readSingleDataFromExcel(fileInputStream);
//        readMultipleDataFromExcel(fileInputStream);
        writeDataIntoCell(fileInputStream);

        fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\testData\\creds.xlsx");
        readSingleDataFromExcel(fileInputStream);
    }
}
