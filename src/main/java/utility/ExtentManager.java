package utility;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.PropertyConfigurator;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager
{
	private static ExtentReports extent;
	public static String curr_Dir = System.getProperty("user.dir");
	public static String Reportpath;
	private static String reportType;

	public static ExtentReports createInstance()
	{
//		getProperties(curr_Dir + "/src/main/java/repository/object.properties");
//		setProperties();
//		getProperties(System.getProperty("credentialsFile"));
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyMMdd_HHmmss");
		String timeStamp = df.format(date);
		extent = new ExtentReports();
		reportType = System.getProperty("reportType");
		String klovFile = System.getProperty("klovpropertyFile");
		if (reportType.equalsIgnoreCase("klov"))
		{
			ExtentKlovReporter klovReports = new ExtentKlovReporter();
			try
			{
				klovReports.loadInitializationParams(new FileInputStream(klovFile));

			} catch (FileNotFoundException e)
			{
				System.out.println("No klov preperties file");
			}
			extent.attachReporter(klovReports);
		} else
		{
			Reportpath = curr_Dir + "/src/test/resources/ExtentReports/Resul_Test_Suite" + timeStamp + ".html";
			final File CONF = new File("./src/main/java/utility/spark.json");
			ExtentSparkReporter spark = new ExtentSparkReporter(Reportpath);
			try
			{
				spark.loadJSONConfig(CONF);
			} catch (IOException e)
			{
				System.out.println("Load Json issue");
			}
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setReportName("<img src='" + curr_Dir + "/src/main/resources/data/uploadfiles/RESUL_5.0_logo.png'");
			extent.attachReporter(spark);
		}
		extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
		return extent;
	}

	public static void getProperties(String propertyFile)
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

	public static void openExtentReport()
	{
		if (reportType.trim().equalsIgnoreCase("html"))
		{
			try
			{
				Desktop.getDesktop().browse(new File(Reportpath).toURI());
			} catch (Exception e)
			{
				System.out.println("Exception occured -> " + e.getMessage());
			}
		}
	}

	public static void setProperties()
	{
		Map<String, String> cred = new LinkedHashMap<>();

		cred.put("klovpropertyFile", "C:\\AQAcred\\Resul\\Properties\\klov.Properties");

		for (Map.Entry<String, String> entry : cred.entrySet())
		{
			String key = entry.getKey();
			String value = entry.getValue();
			System.setProperty(key, value);
		}
	}

	public static Map<String, String> customReport(Map<String, String> object)
	{
		String fontColorStart = "<font color=#0000C0><b>";
		String fontColorEnd = "</font></b>";

		int row = object.size() + 1;
		String[][] builder = new String[row][3];
		builder[0][0] = fontColorStart + "S.No" + fontColorEnd;
		builder[0][1] = fontColorStart + "Items" + fontColorEnd;
		builder[0][2] = fontColorStart + "Description" + fontColorEnd;

		int count = 1;
		for (Map.Entry<String, String> entry : object.entrySet())
		{
			builder[count][0] = String.valueOf(count);
			builder[count][1] = entry.getKey().toString();
			builder[count][2] = entry.getValue().toString();
			count++;
		}
		BaseTest.getTest().info(MarkupHelper.createTable(builder, "text-center table-striped table-bordered table-condensed").getMarkup().replace("<td", "<td style='border: 1px solid #D3D3D3;'"));
		return object;
	}

	public static String[][] customReport(List<Map<String, String>> webtable)
	{
		Set<String> headers = webtable.get(0).keySet();
		int rows = webtable.size() + 1;
		int column = headers.size();
		String[][] object = new String[rows][column];

		int headerIndex = 0;
		for (String header : headers)
		{
			object[0][headerIndex++] = "<b>" + header + "</b>";
		}

		int rowIndex = 1;
		for (Map<String, String> row : webtable)
		{
			int cellIndex = 0;
			for (String header : headers)
			{
				object[rowIndex][cellIndex++] = row.get(header);
			}
			rowIndex++;
		}
		BaseTest.getTest().info(MarkupHelper.createTable(object, "text-center table-striped table-bordered table-condensed"));
		return object;
	}

	public static String getPropFileRoot()
	{
		System.out.println("In getPropFile");
		String path = null;
		String operSys = System.getProperty("os.name").toLowerCase();
		if (operSys.contains("win"))
		{
			System.out.println("In Windows");
			path = System.getProperty("Root_Windows");

		} else if (operSys.contains("nix") || operSys.contains("nux"))
		{
			System.out.println("In Linux");
			path = System.getProperty("Root_Linux");
		}
		return path;
	}

	public static void readAllProperties(String folderPath)
	{
		File folder = new File(folderPath);
		File[] files = folder.listFiles((dir, name) -> name.endsWith(".properties"));
		if (files == null || files.length == 0)
		{
			System.out.println("No property files found in: " + folderPath);
			return;
		}
		for (File file : files)
		{
			try (InputStream input = new FileInputStream(file))
			{
				Properties obj = new Properties();
				obj.load(input);
				PropertyConfigurator.configure(obj);
				for (String name : obj.stringPropertyNames())
				{
					String value = obj.getProperty(name);
					System.setProperty(name, value);
				}
				System.out.println("Loaded properties from: " + file.getName());
			} catch (IOException e)
			{
				System.err.println("Failed to load file: " + file.getName());
				e.printStackTrace();
			}
		}
	}

	public static void updateKlovReportName(String newReportName)
	{
		try
		{
			String klovPropertiesPath = "C:\\AQAcred\\Resul\\Properties\\klov.properties";
			FileInputStream inputStream = new FileInputStream(new File(klovPropertiesPath));
			Properties properties = new Properties();
			properties.load(inputStream);
			inputStream.close();
			properties.setProperty("klov.report.name", newReportName);
			FileOutputStream outputStream = new FileOutputStream(new File(klovPropertiesPath));
			properties.store(outputStream, "Updated klov.report.name dynamically");
			outputStream.close();
			System.out.println("klov.report.name updated to: " + newReportName);
		} catch (Exception e)
		{
		}
	}
}
