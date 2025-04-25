package utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import java.awt.Color;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExcelReportGenerator {

    private static final String FILE_BASE_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\data\\" + BaseTest.xmlEnvironment + "\\";

    public static void writeToExcel(String sheetNames, String flags,
                                    String testCaseIds, String releases,
                                    String results, String accountHeader,
                                    String moduleName) {

        try {
            String[] sheetArr = sheetNames.split(",");
            String[] flagArr = flags.split(",");
            String[] tcIdArr = testCaseIds.split(",");
            String[] releaseArr = releases.split(",");
            String[] resultArr = results.split(",");

            String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

            for (int s = 0; s < sheetArr.length; s++) {
                if (!flagArr[s].equalsIgnoreCase("yes")) continue;

                String sheetName = sheetArr[s];
                String filePath = FILE_BASE_PATH + sheetName + ".xlsx";
                Workbook workbook;
                File file = new File(filePath);

                if (file.exists()) {
                    FileInputStream fis = new FileInputStream(file);
                    workbook = new XSSFWorkbook(fis);
                    fis.close();
                } else {
                    workbook = new XSSFWorkbook();
                    workbook.createSheet(sheetName);
                }

                Sheet sheet = workbook.getSheet(sheetName);
                if (sheet == null) sheet = workbook.createSheet(sheetName);

                Row headerRow = sheet.getRow(0);
                if (headerRow == null) headerRow = sheet.createRow(0);

                CellStyle headerStyle = createHeaderCellStyle(workbook);

                // Set headers
                if (headerRow.getCell(0) == null) {
                    Cell cell = headerRow.createCell(0);
                    cell.setCellValue("Module Name");
                    cell.setCellStyle(headerStyle);
                }
                if (headerRow.getCell(1) == null) {
                    Cell cell = headerRow.createCell(1);
                    cell.setCellValue("Test Case ID");
                    cell.setCellStyle(headerStyle);
                }

                int resultColIndex = 2;
                String dynamicHeader = sheetName.equalsIgnoreCase("daily") ? today :
                                       sheetName.equalsIgnoreCase("release") ? "Release - " + releaseArr[0] :
                                       accountHeader;

                boolean headerExists = false;
                for (int i = 2; i < headerRow.getLastCellNum(); i++) {
                    Cell cell = headerRow.getCell(i);
                    if (cell != null && cell.getStringCellValue().equals(dynamicHeader)) {
                        resultColIndex = i;
                        headerExists = true;
                        break;
                    }
                }

                if (!headerExists) {
                    resultColIndex = headerRow.getLastCellNum() == -1 ? 2 : headerRow.getLastCellNum();
                    Cell newHeaderCell = headerRow.createCell(resultColIndex);
                    newHeaderCell.setCellValue(dynamicHeader);
                    newHeaderCell.setCellStyle(headerStyle);
                }

                CellStyle passStyle = createCellStyle(workbook, new XSSFColor(new Color(0, 97, 0), null), IndexedColors.WHITE.getIndex());
                CellStyle failStyle = createCellStyle(workbook, new XSSFColor(new Color(156, 0, 6), null), IndexedColors.WHITE.getIndex());

                for (int i = 0; i < tcIdArr.length; i++) {
                    String tcId = tcIdArr[i];
                    String res = resultArr[i];
                    boolean found = false;

                    for (int r = 1; r <= sheet.getLastRowNum(); r++) {
                        Row row = sheet.getRow(r);
                        if (row != null &&
                            row.getCell(0) != null &&
                            row.getCell(1) != null &&
                            row.getCell(0).getStringCellValue().equals(moduleName) &&
                            row.getCell(1).getStringCellValue().equals(tcId)) {

                            Cell resultCell = row.createCell(resultColIndex);
                            resultCell.setCellValue(res);
                            resultCell.setCellStyle(res.contains("PASS") ? passStyle : failStyle);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        Row newRow = sheet.createRow(sheet.getLastRowNum() + 1);
                        newRow.createCell(0).setCellValue(moduleName);
                        newRow.createCell(1).setCellValue(tcId);
                        Cell resultCell = newRow.createCell(resultColIndex);
                        resultCell.setCellValue(res);
                        resultCell.setCellStyle(res.contains("PASS") ? passStyle : failStyle);
                    }
                }

                FileOutputStream fos = new FileOutputStream(filePath);
                workbook.write(fos);
                fos.close();
                workbook.close();

                System.out.println("Workbook for " + sheetName + " updated successfully.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static CellStyle createCellStyle(Workbook workbook, XSSFColor bgColor, short fontColor) {
        XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setColor(fontColor);
        style.setFont(font);
        style.setFillForegroundColor(bgColor);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        return style;
    }

    private static CellStyle createHeaderCellStyle(Workbook workbook) {
        XSSFCellStyle headerStyle = (XSSFCellStyle) workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setColor(IndexedColors.BLACK.getIndex());
        headerStyle.setFont(font);
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        return headerStyle;
    }
}