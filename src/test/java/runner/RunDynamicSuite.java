package runner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import utility.BaseTest;
import utility.ExtentManager;

public class RunDynamicSuite
{
	public static void createXml()
	{
		if (System.getProperty("Customizedxml").toLowerCase().contains("yes"))
		{
			// Step 1: Create Suite
			XmlSuite suite = new XmlSuite();
			suite.setName(getXmlSuiteName());
			suite.setParallel(XmlSuite.ParallelMode.METHODS);
			suite.setThreadCount(4);

			// Add listener
			List<String> listeners = new ArrayList<>();
			if (System.getProperty("isRetry").toLowerCase().contains("yes"))
			{
				listeners.add("utility.RetryAnalyzer");
			}

			listeners.add("utility.TestListener");
			listeners.add("org.utility.CutsomHTMLReport");
			suite.setListeners(listeners);

			// Set suite parameter
			Map<String, String> parameters = new LinkedHashMap<>();
			parameters.put("applicationName", getApplicationName());
			parameters.put("runner", "SELENIUM WEBDRIVER");
			suite.setParameters(parameters);

			// Step 2: Create Test
			XmlTest test = readRunnerExcel(suite);

			// Step 4: Create TestNG and run
			TestNG testng = new TestNG();
			testng.setXmlSuites(List.of(suite));
			testng.setVerbose(10);
			testng.run();
			String filePath = "testng-dynamic.xml";
			try
			{
				Files.write(Paths.get(filePath), suite.toXml().getBytes());
				System.out.println("TestNG XML saved to: " + filePath);
				System.out.println("TestNG XML saved to: " + suite.toXml());
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		} else
		{
			TestNG testng = new TestNG();
			String xmlPath = getXml();
			if (!xmlPath.isEmpty())
			{
				testng.setTestSuites(List.of(xmlPath));
			}
			testng.run();
		}
	}

	private static String getXmlSuiteName()
	{
		String xmlSuiteName = "";
		String moduleName = System.getProperty("Module");
		if (moduleName.toLowerCase().contains("audience"))
		{
			xmlSuiteName = "AudienceRegression";
		} else if (moduleName.toLowerCase().contains("communication"))
		{
			xmlSuiteName = "CommunicationRegression";
		} else if (moduleName.toLowerCase().contains("analytics"))
		{
			xmlSuiteName = "AnalyticsRegression";
		} else if (moduleName.toLowerCase().contains("preferences"))
		{
			xmlSuiteName = "PreferencesRegression";
		} else if (moduleName.toLowerCase().contains("accountsetup"))
		{
			xmlSuiteName = "AccountSetupRegression";
		}
		return xmlSuiteName;
	}

	private static String getApplicationName()
	{
		String xmlApplicationName = "";
		String moduleName = System.getProperty("Module");
		if (moduleName.toLowerCase().contains("audience"))
		{
			xmlApplicationName = "RegressionAudience";
		} else if (moduleName.toLowerCase().contains("communication"))
		{
			xmlApplicationName = "RegressionCommunication";
		} else if (moduleName.toLowerCase().contains("analytics"))
		{
			xmlApplicationName = "RegressionAnalytics";
		} else if (moduleName.toLowerCase().contains("preferences"))
		{
			xmlApplicationName = "RegressionPreferences";
		} else if (moduleName.toLowerCase().contains("accountsetup"))
		{
			xmlApplicationName = "RegressionAccountSetup";
		}
		return xmlApplicationName;
	}

	public static XmlTest readRunnerExcel(XmlSuite suite)
	{
		int moduleNameColumnLoc = 0;
		int packageNameColumnLoc = 0;
		int classNameColumnLoc = 0;
		int sheetNameColumnLoc = 0;
		int methodNameColumnLoc = 0;
		int typeColumnLoc = 0;
		int runColumnLoc = 0;
		int MultipleTestDataColumnLoc = 0;
		int testCaseIdColumnLoc = 0;

		XmlTest test = null;

		Set<String> packageAndClassName = new TreeSet<>();
		try
		{
			FileInputStream file = new FileInputStream("C:\\AQAcred\\Resul\\ScriptDetails.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			for (int i = 0; i < workbook.getNumberOfSheets(); i++)
			{
				String sheetName = workbook.getSheetName(i);
				if (sheetName.toLowerCase().contains(System.getProperty("Module").toLowerCase()))
				{
					XSSFSheet sheet = workbook.getSheet(sheetName);
					XSSFRow row = sheet.getRow(1);
					for (int k = 0; k < row.getLastCellNum(); k++)
					{
						String cellHeaderName = row.getCell(k).getStringCellValue();
						if (cellHeaderName.equalsIgnoreCase("module name"))
						{
							moduleNameColumnLoc = k;
						} else if (cellHeaderName.equalsIgnoreCase("package name"))
						{
							packageNameColumnLoc = k;
						} else if (cellHeaderName.equalsIgnoreCase("class name"))
						{
							classNameColumnLoc = k;
						} else if (cellHeaderName.equalsIgnoreCase("method name"))
						{
							methodNameColumnLoc = k;
						} else if (cellHeaderName.equalsIgnoreCase("sheet name"))
						{
							sheetNameColumnLoc = k;
						} else if (cellHeaderName.equalsIgnoreCase("type"))
						{
							typeColumnLoc = k;
						} else if (cellHeaderName.equalsIgnoreCase("run"))
						{
							runColumnLoc = k;
						} else if (cellHeaderName.equalsIgnoreCase("multiple test data"))
						{
							MultipleTestDataColumnLoc = k;
						} else if (cellHeaderName.equalsIgnoreCase("test case id"))
						{
							testCaseIdColumnLoc = k;
						}
					}
					for (int j = 2; j < sheet.getLastRowNum(); j++)
					{
						packageAndClassName.add(sheet.getRow(j).getCell(packageNameColumnLoc).getStringCellValue().trim() + "." + sheet.getRow(j).getCell(classNameColumnLoc).getStringCellValue().trim());
					}
					for (String name : packageAndClassName)
					{
						List<XmlInclude> methods = new ArrayList<>();

						for (int k = 2; k < sheet.getLastRowNum(); k++)
						{
							String isExecute = sheet.getRow(k).getCell(runColumnLoc).getStringCellValue();
							String classFullName = sheet.getRow(k).getCell(packageNameColumnLoc).getStringCellValue().trim() + "." + sheet.getRow(k).getCell(classNameColumnLoc).getStringCellValue().trim();

							if (isExecute.equalsIgnoreCase("yes") && classFullName.equals(name))
							{
								String methodName = sheet.getRow(k).getCell(methodNameColumnLoc).getStringCellValue();
								methods.add(new XmlInclude(methodName));
							}
						}
						if (!methods.isEmpty())
						{
							test = new XmlTest(suite);
							test.setName(name.split("\\.")[1]);
							XmlClass cls = new XmlClass(name);
							cls.setIncludedMethods(methods);
							test.setXmlClasses(List.of(cls));
							Map<String, String> testParams = new HashMap<>();
							testParams.put("browser", System.getProperty("Browser"));
							for (int k = 2; k < sheet.getLastRowNum(); k++)
							{
								String classFullName = sheet.getRow(k).getCell(packageNameColumnLoc).getStringCellValue().trim() + "." + sheet.getRow(k).getCell(classNameColumnLoc).getStringCellValue().trim();
								if (classFullName.equals(name))
								{
									testParams.put("sheetname", sheet.getRow(k).getCell(sheetNameColumnLoc).getStringCellValue());
									break;
								}
							}
							test.setParameters(testParams);
						}
					}
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return test;
	}

	private static void getProperties(String propertyFile)
	{
		Properties obj = new Properties();
		try
		{
			obj.load(new FileInputStream(propertyFile));
		} catch (FileNotFoundException e)
		{
			System.err.println("getProperties file not found" + e.getMessage());
		} catch (IOException e)
		{
			System.err.println("getProperties file load" + e.getMessage());
		}
		PropertyConfigurator.configure(obj);
		for (String name : obj.stringPropertyNames())
		{
			String value = obj.getProperty(name);
			System.setProperty(name, value);
		}
	}

	public static String getXml()
	{
		String moduleName = System.getProperty("Module");
		if (moduleName.toLowerCase().contains("audience"))
		{
			return System.getProperty("user.dir") + "\\runner\\AudienceRegression.xml";
		} else if (moduleName.toLowerCase().contains("communication"))
		{
			return System.getProperty("user.dir") + "\\runner\\CommunicationRegression.xml";
		} else if (moduleName.toLowerCase().contains("analytics"))
		{
			return System.getProperty("user.dir") + "\\runner\\AnalyticsRegression.xml";
		} else if (moduleName.toLowerCase().contains("preferences"))
		{
			return System.getProperty("user.dir") + "\\runner\\PreferencesRegression.xml";
		} else if (moduleName.toLowerCase().contains("featurewise"))
		{
			return System.getProperty("user.dir") + "\\runner\\FeaturewiseChecklist.xml";
		} else if (moduleName.toLowerCase().contains("newaccount"))
		{
			return System.getProperty("user.dir") + "\\runner\\NewAccountCreationChecklist.xml";
		} else
		{
			return "";
		}
	}

	public static void main(String[] args)
	{
		ExtentManager.readAllProperties("C:\\AQAcred\\Resul\\Properties");
		String objectPropsPath = BaseTest.extractResourceToTempFile("repository/object.properties", ".properties");
		ExtentManager.getProperties(objectPropsPath);
		ExtentManager.updateKlovReportName(System.getProperty("Environment") + "_" + System.getProperty("Module"));
		BaseTest.xmlFileName = getXmlSuiteName();
		ExtentManager.setProperties();
		createXml();
	}

}
