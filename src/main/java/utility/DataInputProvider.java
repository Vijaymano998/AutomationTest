package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * To write the data into excel we use this class
 *
 */
public class DataInputProvider
{
	// static Properties obj = new Properties();
	static String env = System.getProperty("Environment");

	public static ArrayList<ArrayList<String>> getSheet(String dataExcelFileName, String sheetName)
	{
		ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		boolean sheetexist = false;
		try
		{
			fis = new FileInputStream(new File(System.getProperty("user.dir") + "\\data\\" + env + "\\" + dataExcelFileName + ".xlsx"));
			if (fis != null)
			{
				workbook = new XSSFWorkbook(fis);
				if (workbook.getNumberOfSheets() != 0)
				{
					for (int numsheets = 0; numsheets < workbook.getNumberOfSheets(); numsheets++)
					{
						if (workbook.getSheetName(numsheets).equals(sheetName))
						{
							sheetexist = true;
						}
					}
				}
				if (sheetexist)
				{
					// workbook.setForceFormulaRecalculation(true);
					XSSFSheet sheet = workbook.getSheet(sheetName);
					// get the number of rows
					int rowCount = sheet.getLastRowNum();
					// System.out.println("row count: "+rowCount);
					// get the number of columns
					int columnCount = sheet.getRow(0).getLastCellNum();
					// System.out.println("col count: "+columnCount);
					// loop through the rows
					for (int i = 1; i < rowCount + 1; i++)
					{
						XSSFRow row = sheet.getRow(i);
						ArrayList<String> record = new ArrayList<String>();
						for (int j = 0; j < columnCount; j++)// loop through the columns
						{
							Cell cell = row.getCell(j); // get all cell values
							// if(cell==null||cell.getCellType()==cell. CELL_TYPE_BLANK) { String nullString = null; cell.setCellType(); } else {
							// cell.setCellType(Cell.CELL_TYPE_STRING);

							cell.setCellType(CellType.STRING);
							// System.out.println(row.getCell(j).getStringCellValue());
							if (cell != null)
							{
								record.add(row.getCell(j).getStringCellValue()); // add
							} else
							{
								record.add(""); // add
							}
						}
						data.add(record);
					}

				} else
				{
					System.out.println("Sheet Name not exist");
				}

			}
		} catch (FileNotFoundException e)
		{
			System.out.println("Path or mention file name wrong");
		} catch (IOException e)
		{
			System.out.println("DataInputProvider.getSheet() xssfsheet exception:" + e.getMessage());
		} finally
		{
			try
			{
				if (workbook != null)
				{
					workbook.close();
				}
				if (fis != null)
				{
					fis.close();
				}
			} catch (IOException e)
			{
				System.out.println("DataInputProvider.getSheet() :" + e.getMessage());
			}
		}
		return data;
	}

	public static void createSheet(String datafileName, String sheetname, String clientid) throws IOException
	{

		FileOutputStream fos = new FileOutputStream(new File(System.getProperty("user.dir") + "\\data\\" + env + "\\" + datafileName + ".xlsx"));
		XSSFWorkbook xwb = new XSSFWorkbook();
		XSSFSheet xsh = xwb.createSheet(sheetname);
		for (int i = 0; i < 1; i++)
		{
			Row row = xsh.createRow(i);
			row.createCell(0).setCellValue(clientid);
		}
		xwb.write(fos);
		fos.flush();
		fos.close();
	}

	/**
	 * to update data into sheet and cell
	 *
	 */
	public static void writeUpdatedValueInSheet(int row, int col, String datafileName, String sheetName, String updatedValue)
	{
		try
		{
			FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir") + "/src\\main\\resources" + "\\data\\" + "Team" + "\\" + datafileName + ".xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Cell cell = null;
			// Retrieve the row and check for null
			XSSFRow sheetrow = sheet.getRow(row);
			if (sheetrow == null)
			{
				sheetrow = sheet.createRow(row);
			}
			// Update the value of cell
			cell = sheetrow.getCell(col);
			if (cell == null)
			{
				cell = sheetrow.createCell(col);
			}
			cell.setCellValue(updatedValue);
			sheet.getWorkbook().getCreationHelper().createFormulaEvaluator().evaluateAll();// Refresh all formulas in workbook and save
			// sheet.getWorkbook().getCreationHelper().createFormulaEvaluator().clearAllCachedResultValues();
			// workbook.setForceFormulaRecalculation(true);
			file.close();
			for (int wait = 0; wait < 4; wait++)
			{
				try
				{
					FileOutputStream outFile = new FileOutputStream(new File(System.getProperty("user.dir") + "/src/main/resources" + "/data\\" + env + "\\" + datafileName + ".xlsx"));
					workbook.write(outFile);
					workbook.close();
					outFile.close();
					break;
				} catch (IOException e)
				{
					System.out.println(" Excel file opened or having issue, waiting for some time");
					try
					{
						Thread.sleep(5000);
					} catch (InterruptedException e1)
					{
						e1.printStackTrace();
					}
				}
			}
			/*
			 * FileOutputStream outFile = new FileOutputStream(new File(System.getProperty("user.dir") +
			 * "\\data\\" + env + "\\" + datafileName + ".xlsx")); // XSSFFormulaEvaluator.evaluateAllFormulaCells(workbook); // Refresh all formulas
			 * in workbook and save workbook.write(outFile); workbook.close(); outFile.close();
			 */

		} catch (FileNotFoundException e)
		{
			System.out.println("File path does not exist, file having issue");
			e.printStackTrace();
		} catch (IOException e2)
		{
			e2.printStackTrace();
		}
	}

	public static Object[][] getTestData(String datafile, String sheetName)
	{
		String filePath = System.getProperty("user.dir") + "/src/main/resources/data/" + env + "/" + datafile;
		FileInputStream fis;
		Object[][] objectData = null;
		try
		{
			fis = new FileInputStream(new File(filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int rowCount = sheet.getLastRowNum() + 1;
			int colCount = sheet.getRow(0).getLastCellNum();

			objectData = new Object[rowCount - 1][colCount];

			for (int i = 1; i < rowCount; i++)
			{
				Row row = sheet.getRow(i);
				for (int j = 0; j < colCount; j++)
				{
					if (row != null)
					{
						Cell cell = row.getCell(j);
						if (cell != null)
						{
							if (cell.getCellType() == CellType.NUMERIC)
							{
								objectData[i - 1][j] = cell.getNumericCellValue();
							} else if (cell.getCellType() == CellType.STRING)
							{
								objectData[i - 1][j] = cell.getStringCellValue();
							}
						}
					}
				}
			}
			workbook.close();
			fis.close();
			return objectData;

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return objectData;
	}
}
