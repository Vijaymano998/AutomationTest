package utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReporter
{

	private static XSSFWorkbook workbook = null;
	private static XSSFSheet sheet = null;
	private static XSSFRow row = null;

	/*
	 * this method creates the header for reporter
	 */
	static void createReportHeader(String testcaseSheetName)
	{

		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet(testcaseSheetName);
		row = sheet.createRow(0);

		// row.createCell(0).setCellValue("SNo");
		row.createCell(0).setCellValue("Step No");
		row.createCell(1).setCellValue("Description");
		row.createCell(2).setCellValue("Status");
	}

	public static void flushWorkbook(String testCaseName) throws IOException
	{
		FileOutputStream fos = new FileOutputStream(new File(System.getProperty("user.dir") + "\\report\\" + testCaseName + ".xlsx"));
		workbook.write(fos);
	}

	static void reportStep(String desc, String status)
	{
		row = sheet.createRow(sheet.getLastRowNum() + 1);
		row.createCell(0).setCellValue(sheet.getLastRowNum());
		row.createCell(1).setCellValue(desc);
		row.createCell(2).setCellValue(status);

		/*
		 * if(status.toUpperCase().equals("SUCCESS")) ATUReports.add(desc, LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP)); else
		 * ATUReports.add(desc, LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		 */
	}

}
