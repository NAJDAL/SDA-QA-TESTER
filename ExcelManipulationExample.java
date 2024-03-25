import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//Assignment 6
//Store the path of the file as string and open the file.
//Open the workbook.
//Open the first worksheet.
//Go to the first row.
//Create a cell on the 3rd column (2nd index) on the first row.
//Write “POPULATION” on that cell.
//Create a cell on the 2nd row 3rd cell(index2), and write data.
//Create a cell on the 3rd row 3rd cell(index2), and write data.
//Create a cell on the 4th row 3rd cell(index2), and write data.
//Write and save the workbook.
//Close the file.
//Close the workbook.

//The 3rd column on excel file must be empty before running.
// Otherwise, new data will be written on the old data 


public class ExcelManipulation {
    public static void main(String[] args) {
        try {
            // Store the path of the file as a string
            String filePath = "excel/file.xlsx";

            // Open the file
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));

            // Open the workbook
            Workbook workbook = WorkbookFactory.create(fileInputStream);

            // Open the first worksheet
            Sheet sheet = workbook.getSheetAt(0);

            // Go to the first row
            Row firstRow = sheet.getRow(0);

            // Create a cell on the 3rd column (2nd index) on the first row and write "POPULATION" on that cell
            Cell cell = firstRow.createCell(2);
            cell.setCellValue("POPULATION");

            // Create cells on the 2nd, 3rd, and 4th rows on the 3rd column and write data
            for (int i = 1; i <= 3; i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    row = sheet.createRow(i);
                }
                Cell dataCell = row.createCell(2);
                dataCell.setCellValue("Data " + i);
            }

            // Write and save the workbook
            FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
            workbook.write(fileOutputStream);

            // Close the output stream
            fileOutputStream.close();

            // Close the file input stream
            fileInputStream.close();

            // Close the workbook
            workbook.close();
        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }
    }
}
