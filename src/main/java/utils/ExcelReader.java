package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelReader {

    public static FileInputStream inputStream;
    public static XSSFWorkbook workBook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    String path = null;

    public ExcelReader(String path) {
        this.path = path;
    }

    public int getRowCount(String sheetName) throws IOException {
        inputStream = new FileInputStream(path);
        workBook = new XSSFWorkbook(inputStream);
        sheet = workBook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        workBook.close();
        inputStream.close();
        return rowCount;
    }

    public int getCellCount(String sheetName, int rownum) throws IOException {
        inputStream = new FileInputStream(path);
        workBook = new XSSFWorkbook(inputStream);
        sheet = workBook.getSheet(sheetName);
        row = sheet.getRow(rownum);
        int cellCount = row.getLastCellNum();
        workBook.close();
        inputStream.close();
        return cellCount;
    }

    public String getData(String sheetName, int rowNum, int colum) throws IOException {

        inputStream = new FileInputStream(path);
        workBook = new XSSFWorkbook(inputStream);
        sheet = workBook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colum);

        DataFormatter dataFormatter = new DataFormatter();
        String data;
        try {
            data = dataFormatter.formatCellValue(cell);
        } catch (Exception e) {
            data = "";
        }
        workBook.close();
        inputStream.close();

        return data;

    }

       /*Iterator iterator = sheet.iterator();
       while (iterator.hasNext()) {
           row = (XSSFRow)  iterator.next();
           Iterator cellIterator = row.cellIterator();

           while (cellIterator.hasNext()) {
               cell = (XSSFCell)  cellIterator.next();
               switch (cell.getCellType()) {
                   case STRING: System.out.println(cell.getStringCellValue()); break;
                   case NUMERIC: System.out.println(cell.getNumericCellValue()); break;
                   case BOOLEAN: System.out.println(cell.getBooleanCellValue()); break;
               }
           }
           System.out.println();
       }*/

}
