package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import repository.ObjectRepository;

// Resul5.0
public class BaseTest
{
	public static ThreadLocal<ExcelUtil> excelutil = new ThreadLocal<ExcelUtil>();
	protected static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
	protected static ThreadLocal<Browser> browser = new ThreadLocal<>();
	protected static ThreadLocal<BrowserContext> browserContext = new ThreadLocal<>();
	protected static ThreadLocal<Page> playwrightPage = new ThreadLocal<>();
	public static ThreadLocal<String> appName = new ThreadLocal<String>();
	public static ThreadLocal<String> method_name = new ThreadLocal<String>();
	public static ThreadLocal<String> browserName = new ThreadLocal<String>();
	public static ThreadLocal<String> sheet_name = new ThreadLocal<String>();
	public static ThreadLocal<Integer> currentRow = new ThreadLocal<Integer>();
	public static ThreadLocal<XLSReader> datatable = new ThreadLocal<XLSReader>();
	public static ThreadLocal<XLSReader> credentialSheet = new ThreadLocal<XLSReader>();
	public static ThreadLocal<String> logName;
	public static String data_file = "";
	public static String curr_Dir = System.getProperty("user.dir");
	private static ExtentReports extent;
	private static Map<Long, ExtentTest> extentTestMap = new TreeMap<>();
	private static Map<Long, ExcelUtil> exceldata = new HashMap<>();
	public static String xmlFileName;
	public static String xmlEnvironment;
	public static boolean isGrid;
	private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();
	private static ThreadLocal<ExtentTest> nodeTest = new ThreadLocal<>();
	private static ThreadLocal<Boolean> wasRetried = new ThreadLocal<>();
	public static final String GREEN_COLOR = "\u001B[32;1m";
	public static final String BLUE_COLOR = "\033[1;34m";
	public static final String RESET_COLOR = "\u001B[0m";
	public static List<Map<String, String>> devList = new LinkedList<>();

	public static synchronized ExtentTest getParentTest()
	{
		return parentTest.get();
	}

	public static synchronized ExtentTest getNodeTest()
	{
		return nodeTest.get();
	}

	public static synchronized ExtentTest getTest()
	{
		return extentTestMap.get(Thread.currentThread().getId());
	}

	public static synchronized ExtentTest createNode(String name)
	{
		ExtentTest node = getParentTest().createNode(name);
		nodeTest.set(node);
		return node;
	}

	public static synchronized ExtentTest createTestID(String testID)
	{
		ExtentTest node = getNodeTest().createNode(testID);
		extentTestMap.put(Thread.currentThread().getId(), node);
		return node;
	}

	public static boolean wasRetried()
	{
		if (wasRetried.get() != null)
		{
			return wasRetried.get();
		}
		return false;
	}

	// This method is to get the current driver
	public static synchronized WebDriver getWebDriver()
	{
		return driverThread.get();
	}

	public synchronized ExtentTest startTest(String method, String testName, String browser)
	{
		Random r = new Random();
		int randInt = r.nextInt(15 - 3) + 3;
		int a = randInt * 1000;
		ExtentTest test = null;
		try
		{
			Thread.sleep(Long.valueOf(a));
		} catch (InterruptedException e)
		{
			System.out.println(e.getMessage());
		}
		if (isGrid)
		{
			method = method + " - " + browser;
		}
		test = extent.createTest(method, "<font color=#0000C0><b>SCENARIO ID : </font></b>" + "<i><u><b><font color=black>" + testName + "</i></u></b></font>");
		extentTestMap.put(Thread.currentThread().getId(), test);
		parentTest.set(test);
		return test;
	}

	public synchronized ExtentTest createChildNode(ExtentTest parent, String methodName)
	{
		ExtentTest test = parent.createNode("<b>" + methodName.toUpperCase() + "</b>");
		extentTestMap.put(Thread.currentThread().getId(), test);
		return test;
	}

	public synchronized ExcelUtil createDataRef()
	{
		ExcelUtil obj = new ExcelUtil();
		exceldata.put(Thread.currentThread().getId(), obj);
		return obj;
	}

	public static synchronized ExcelUtil getData()
	{
		return exceldata.get(Thread.currentThread().getId());
	}

	public WebDriver getBrowser(String browser)
	{
		String browserName = browser.toLowerCase();
		if (browserName.equals("chrome"))
		{
			createChromeDriver();
		} else if (browserName.equals("firefox"))
		{
			createFirefoxDriver();
		} else if (browserName.equals("chromeheadless"))
		{
			createChromeDriverHeadless();
		} else if (browserName.equals("edge"))
		{
			createMicrosoftEdgeDriver();
		}
		driverThread.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		return driverThread.get();
	}

	private synchronized ThreadLocal<WebDriver> createFirefoxDriver()
	{
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		options.addArguments("--window-size=1920x1080");
		options.addArguments("--no-sandbox");
		// options.addArguments("--display=0");
		options.setLogLevel(FirefoxDriverLogLevel.CONFIG);
		options.addArguments("--incognito");//
		options.addArguments("--disable-gpu");
		// options.addArguments("--headless");
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		DesiredCapabilities dc = new DesiredCapabilities();
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
		dc.setCapability("marionatte", false);
		options.merge(dc);

		// Check Execution type is Grid OR Web driver
		if (!isSeleniumGrid(options))
		{
			driverThread.set(new FirefoxDriver(options));
		}
		return driverThread;
	}

	private synchronized ThreadLocal<WebDriver> createChromeDriver()
	{

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		options.addArguments("test-type");
		options.addArguments("--window-size=1920x1080");
		options.addArguments("--no-sandbox");
//		options.addArguments("--incognito");
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-geolocation");
		Map<String, Object> chromefeatures = new HashMap<>();
		chromefeatures.put("credentials_enable_service", false);
		chromefeatures.put("profile.password_manager_enabled", false);
		chromefeatures.put("profile.default_content_settings.popups", 0);
		chromefeatures.put("download.prompt_for_download", false);
		chromefeatures.put("download.directory_upgrade", true);
		chromefeatures.put("download.extensions_to_open", "");
		chromefeatures.put("safebrowsing.enabled", true);
		chromefeatures.put("plugins.always_open_pdf_externally", true);
		String fileDownloadPath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "data", "downloadedFile").toAbsolutePath().toString();
		chromefeatures.put("download.default_directory", fileDownloadPath);
		options.setExperimentalOption("prefs", chromefeatures);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

		// Check Execution type is Grid OR WebDriver
		if (!isSeleniumGrid(options))
		{
			driverThread.set(new ChromeDriver(options));
		}
		return driverThread;
	}

	private synchronized ThreadLocal<WebDriver> createChromeDriverHeadless()
	{

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.addArguments("--disable-notifications");
		options.addArguments("test-type");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--headless");
		options.addArguments("--start-maximized");
		options.addArguments("--no-sandbox");
//		options.addArguments("--incognito");
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-geolocation");
		Map<String, Object> chromefeatures = new HashMap<String, Object>();
		chromefeatures.put("credentials_enable_service", false);
		chromefeatures.put("profile.password_manager_enabled", false);
		String fileDownloadPath = System.getProperty("user.dir") + "\\src\\main\\resources" + "\\data\\downloadedFile\\";
		chromefeatures.put("profile.default_content_settings.popups", 0);
		chromefeatures.put("download.prompt_for_download", "false");
		chromefeatures.put("download.default_directory", fileDownloadPath);
		options.setExperimentalOption("prefs", chromefeatures);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

		// Check Execution type is Grid OR WebDriver
		if (!isSeleniumGrid(options))
		{
			driverThread.set(new ChromeDriver(options));
		}
		return driverThread;
	}

	private synchronized ThreadLocal<WebDriver> createMicrosoftEdgeDriver()
	{
		EdgeOptions options = new EdgeOptions();
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);
		options.addArguments("--disable-notifications");
		options.addArguments("test-type");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--no-sandbox");
		options.addArguments("inprivate");;
		options.addArguments("--disable-gpu");
		Map<String, Object> chromefeatures = new HashMap<String, Object>();
		chromefeatures.put("credentials_enable_service", false);
		chromefeatures.put("profile.password_manager_enabled", false);
		String fileDownloadPath = PageBase.getNormalizedPath(System.getProperty("user.dir") + "/src/main/resources/data/downloadedFile/");
		chromefeatures.put("profile.default_content_settings.popups", 0);
		chromefeatures.put("download.prompt_for_download", "false");
		chromefeatures.put("download.default_directory", fileDownloadPath);
		options.setExperimentalOption("prefs", chromefeatures);

		// Check Execution type is Grid OR WebDriver
		if (!isSeleniumGrid(options))
		{
			driverThread.set(new EdgeDriver(options));
		}
		return driverThread;
	}

	public static boolean isSeleniumGrid(Capabilities capabilities)
	{
		try
		{
			if (isGrid)
			{
				driverThread.set(new RemoteWebDriver(new URL(getRemoteWebDriverURL()), capabilities));
				return true;
			}
		} catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Before suite created Extent object ref by calling createInstance method from ExtentManager class and kills task of browser current session
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@BeforeSuite
	@Parameters({ "runner" })
	public void before(ITestContext context, String runner) throws IOException, InterruptedException
	{
		try
		{
			xmlFileName = context.getCurrentXmlTest().getSuite().getName();
			extent = ExtentManager.createInstance();
			xmlEnvironment = System.getProperty("Environment");
			BaseTest.credentialSheet.set(new XLSReader(PageBase.getNormalizedPath("C:\\AQAcred\\Credential.xlsx")));
			boolean credentialAndValidate = getCredentialAndValidate();
			if (credentialAndValidate)
			{
				System.out.println("Credential is matched successfully.");
			} else
			{
				throw new SkipException("Aborting suite: Credential values are not match.");
			}
			if (isGrid(runner))
			{
				DockerManager.dockerContainterUp();
			}
		} catch (Exception e)
		{
			throw new SkipException("Aborting suite: Credential values are not match.");
		}
	}

	/**
	 * After suite will flush the extent report and kills tasks of browser current session
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@AfterSuite
	public void aftersuite() throws IOException, InterruptedException
	{
		try
		{
//			System.out.println(devList);
			extent.flush();
//			Runtime.getRuntime().exec("pkill -f geckodriver && pkill -f chromedriver && pkill -f IEDriverServer");
			ExtentManager.openExtentReport();
			if (isGrid)
			{
				// dockerContainterDown();
			}
//			taskKill();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
//		Runtime.getRuntime().exec("TaskKill /T /F /IM geckodriver.exe /IM chromedriver.exe /IM IEDriverServer.exe ");
	}

	/**
	 * 
	 * @return true if ExecutionType is 'SELEINUM GRID' Otherwise false.
	 */
	public static boolean isGrid(String runner)
	{
//		System.out.println(BLUE_COLOR + "******************** " + runner + " EXECUTION *********************" + RESET_COLOR);
		if (runner.equalsIgnoreCase("SELENIUM GRID"))
		{
			isGrid = true;
			System.out.println("");
		}
		return isGrid;
	}

	/**
	 * This method is used to take screenshots either it is klov or html report
	 * 
	 * @throws Exception
	 */
	public static synchronized void takeScreenshot()
	{
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyMMdd_HHmmssSSS");
		String timeStamp = df.format(date);
		String imgpath = PageBase.detectFilePath(curr_Dir + "/src/test/resources/ExtentReports/ScreenShots/" + timeStamp + ".jpg");
		File destpath = new File(imgpath);
		try
		{
			FileUtils.copyFile(((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.FILE), destpath);
			Thread.sleep(1000);
			getTest().log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(imgpath).build());
		} catch (Exception e)
		{
			getTest().log(Status.WARNING, "Unexpected throw, unable to take screenshot :" + e.getMessage());
		}
	}

	public void attachVideoContext(String videoPath)
	{
		if (getPlayWright() != null)
		{
			try
			{
				String base64EncodedVideo = encodeFileToBase64(videoPath);
				String encodeUrl = "data:video/webm;base64," + base64EncodedVideo;
				String videoHtml = "<video width='400' controls>\n" + "  <source src='" + encodeUrl + "' type='video/webm'>\n" + "  Your browser does not support the video tag.\n" + "</video>";
				getTest().log(Status.INFO, videoHtml);
			} catch (Exception e)
			{
				getTest().log(Status.WARNING, "Unexpected throw, unable to take screenshot :" + e.getMessage());
			}
		}
	}

	@BeforeMethod
	// @Parameters({"browser"})
	@Parameters({ "applicationName", "sheetname" })
	public void beforemethod(String applicationName, String sheetname, Method method) throws MalformedURLException
	{
		// , String applicationName, String sheetName,
		BaseTest.appName.set(applicationName);
		BaseTest.sheet_name.set(sheetname);
		BaseTest.method_name.set(method.getName());
		BaseTest.browserName.set(System.getProperty("Browser"));
		logName = new ThreadLocal<String>();
		if (BaseTest.appName.get().equals("RegressionAccountSetup"))
		{
			data_file = System.getProperty("RegressionAccountSetup");
		} else if (BaseTest.appName.get().equals("RegressionAudience"))
		{
			data_file = System.getProperty("RegressionAudience");
		} else if (BaseTest.appName.get().equals("RegressionCommunication"))
		{
			data_file = System.getProperty("RegressionCommunication");
		} else if (BaseTest.appName.get().equals("DataFileDailyCheck"))
		{
			data_file = System.getProperty("DataFileDailyCheck");
		} else if (BaseTest.appName.get().equals("RegressionPreferences"))
		{
			data_file = System.getProperty("RegressionPreferences");
		} else if (BaseTest.appName.get().equals("RegressionAnalytics"))
		{
			data_file = System.getProperty("RegressionAnalytics");
		} else if (BaseTest.appName.get().equals("Deploymentchecklist"))
		{
			data_file = System.getProperty("Deploymentchecklist");
		} else if (BaseTest.appName.get().equals("NewAccountCreationChecklist"))
		{
			data_file = System.getProperty("NewAccountCreationChecklist");
		} else if (BaseTest.appName.get().equals("FeaturewiseChecklist"))
		{
			data_file = System.getProperty("FeaturewiseChecklist");
		}
		String resourceToTempFile = extractResourceToTempFile("resources/data/Team/" + data_file, ".xlsx");
		if (resourceToTempFile != null)
		{
			BaseTest.datatable.set(new XLSReader(resourceToTempFile));
		} else
		{
			resourceToTempFile = extractResourceToTempFile("data/Team/" + data_file, ".xlsx");
			BaseTest.datatable.set(new XLSReader(resourceToTempFile));
		}

		if (isTCIDFound())
		{
			createDataRef();
			if (BaseTest.method_name.get().toLowerCase().startsWith("pw"))
			{
				System.out.println(BLUE_COLOR + "******************** " + "PLAYWRIGHT" + " EXECUTION *********************" + RESET_COLOR);
				pw_getBrowser(browserName.get());
			} else
			{
				System.out.println(BLUE_COLOR + "******************** " + "SELENIUM WEBDRIVER" + " EXECUTION *********************" + RESET_COLOR);
				getBrowser(browserName.get());
			}
			String testName = method.getAnnotation(Test.class).testName();
			startTest(method.getAnnotation(Test.class).description(), testName, browserName.get());
			BaseTest.getTest().log(Status.INFO, browserName.get() + " is launched successfully");
		}
		LoginPage login = getPageFactory().loginPage();
		if (!browserName.get().toLowerCase().contains("pw"))
		{
			PageBase.getDeviceSpecs(); // Capture Device & Browser Information
			login.openLoginPage();
		} else
		{
			login.pw_openLoginPage();
		}
		setCustomReportProperties();
	}

	/**
	 * It verifies the sheet test case row having test case name or not. if found it will read the row data and store.
	 */
	public boolean isTCIDFound()
	{
		String sheetname = sheet_name.get();
		for (int i = 2; i <= datatable.get().getRowCount(sheetname); i++)
		{
			if (datatable.get().getCellData(sheetname, "TestMethodName", i).equals(method_name.get()))
			{
				System.out.println("TCID match found for : " + " ---> " + method_name.get());
				currentRow.set(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * After every test method if pass- comment, fail - takes screenshot
	 * 
	 * @throws IOException
	 */

	@AfterMethod
	protected void afterMethod(ITestResult result)
	{
		if (getWebDriver() != null)
		{
			takeScreenshot();
			getWebDriver().quit();
			System.out.println("selenium Browser Closed");
		} else
		{
			pw_takesScreenshot();
//			closeTraceViewer();
			Path videoPath = getPlayWright().video().path();
			getPlayWright().close();
			browserContext.get().close();
			browser.get().close();
			System.out.println("playwright Browser Closed");
			pw_attachVideoContext(videoPath);
		}
		if (result.getStatus() == ITestResult.FAILURE)
		{
			String name = result.getMethod().getDescription();
			getTest().fail(MarkupHelper.createLabel(name, ExtentColor.RED));
			getTest().info(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP)
		{
			String name = result.getMethod().getDescription();
			getTest().log(Status.SKIP, name + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS)
		{
			String name = result.getMethod().getDescription().toUpperCase();
			getTest().pass(MarkupHelper.createLabel(name, ExtentColor.GREEN));
		}
	}

	/**
	 * Returns page object reference
	 */
	public static PageFactory getPageFactory()
	{
		return new PageFactory(getWebDriver(), getPlayWright());
	}

	// DOCKER IMPLEMENTATION
	private static void executeCommand(String command, String msg)
	{
		int exitCode = 0;
		try
		{
			Process processBuilder = Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + command);
			PageBase.threadSleep(ObjectRepository.wait30sec);
			exitCode = processBuilder.waitFor();
			System.out.println(GREEN_COLOR + "*****************************************************************************");
			System.out.println("                      DOCKER CONTAINER " + msg + " SUCCESSFULLY                          ");
			System.out.println("*****************************************************************************" + RESET_COLOR);

			// Kill the opended cmd prompt line
			if (command.endsWith("down"))
			{
				processBuilder = Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
				processBuilder.waitFor();
				Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
			}
		} catch (IOException | InterruptedException e)
		{
			e.printStackTrace();
			if (exitCode != 0)
			{
				throw new RuntimeException("Failed to " + msg + " Docker containers");
			}
		}
	}

	private static String getRemoteWebDriverURL()
	{
		String remoteURL = null;
		try (DatagramSocket socket = new DatagramSocket())
		{
			socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
			String ipAddress = socket.getLocalAddress().getHostAddress();
			remoteURL = "http://" + ipAddress.concat(":") + System.getProperty("Grid_PORT");

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return remoteURL;
	}

	/**
	 * Below methods is playWright methods
	 */

	/**
	 * @param Initialize Playwright browser
	 */
	public void pw_getBrowser(String browser)
	{
		Browser pwbrowser = null;
		String browserName = browser.toLowerCase();
		Playwright pw = Playwright.create();
		if (browserName.equals("pwchrome"))
		{
			pwbrowser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		} else if (browserName.equals("pwchromeheadless"))
		{
			pwbrowser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(true));
		} else if (browserName.equals("pwsafari"))
		{
			pwbrowser = pw.webkit().launch(new BrowserType.LaunchOptions().setHeadless(true));
		} else if (browserName.equals("pwfirefox"))
		{
			pwbrowser = pw.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		} else if (browserName.equals("pwedge"))
		{
			pwbrowser = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
		} else if (browserName.equals("pwchromium"))
		{
			pwbrowser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Please enter the valid browser name for PlayWright");
		}
		if (pwbrowser != null)
		{
			setPlayWright(pwbrowser);
		}
	}

	/**
	 * @param Playwright video context
	 */
	public static BrowserContext createVideoContext()
	{
		String videopath = PageBase.detectFilePath(curr_Dir + "/src/test/resources/ExtentReports/Videos/");
		browserContext.set(browser.get().newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get(videopath)).setRecordVideoSize(640, 360).setViewportSize(1366, 630)));
		browserContext.get().setDefaultTimeout(90000);
//		traceViewer();
		return browserContext.get();
	}

	public void brosertet()
	{
		Playwright play = Playwright.create();
		Browser browser = play.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(true));
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setAcceptDownloads(isGrid));
		Page page = browserContext.newPage();
	}

	public static void traceViewer()
	{
		browserContext.get().tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));
	}

	public static void closeTraceViewer()
	{
		String timeStamp = new SimpleDateFormat("yyMMdd_HHmmssSSS").format(new Date());
		String path = curr_Dir + "\\src\\test\\resources\\ExtentReports\\Trace\\" + timeStamp + ".zip";
		browserContext.get().tracing().stop(new Tracing.StopOptions().setPath(Paths.get(path)));
		BaseTest.getTest().log(Status.INFO, "Trace Viewer : " + "<a href=" + encodeFileToBase64(path) + ">Click here</a>");
	}

	/**
	 * @param set playwright page
	 */

	public static void setPlayWright(Browser browsers)
	{
		browser.set(browsers);
		Page page = createVideoContext().newPage();
		Path fileDownloadPath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "data", "downloadedFile");
		page.onDownload(download -> {
			System.out.println("Downloading file: " + download.suggestedFilename());
			download.saveAs(fileDownloadPath.resolve(download.suggestedFilename()));
		});
		setPlaywright(page);
	}

	public static synchronized void setPlaywright(Page page)
	{
		playwrightPage.set(page);
	}

	public static synchronized Page getPlayWright()
	{
		return playwrightPage.get();
	}

	/**
	 * @param playwright screenshot
	 */

	public static synchronized void pw_takesScreenshot()
	{
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyMMdd_HHmmssSSS");
		String timeStamp = df.format(date);
		String imgpath = PageBase.detectFilePath(curr_Dir + "/src/test/resources/ExtentReports/ScreenShots/" + timeStamp + ".jpg");
		try
		{
			getPlayWright().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(imgpath)).setFullPage(true));
			Thread.sleep(1000);
			getTest().log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(imgpath).build());
		} catch (Exception e)
		{
			getTest().log(Status.WARNING, "Unexpected throw, unable to take screenshot :" + e.getMessage());
		}
	}

	public void pw_attachVideoContext(Path path)
	{
		if (getPlayWright() != null)
		{
			try
			{
				String base64EncodedVideo = encodeFileToBase64(path.toString());
				String encodeUrl = "data:video/webm;base64," + base64EncodedVideo;
				String videoHtml = "<video width='400' controls>\n" + "  <source src='" + encodeUrl + "' type='video/webm'>\n" + "  Your browser does not support the video tag.\n" + "</video>";
				getTest().log(Status.INFO, videoHtml);
			} catch (Exception e)
			{
				getTest().log(Status.WARNING, "Unexpected throw, unable to take screenshot :" + e.getMessage());
			}
		}
	}

	public static String encodeFileToBase64(String filePath)
	{
		try
		{
			Path path = Paths.get(filePath);
			byte[] fileBytes = Files.readAllBytes(path);
			return Base64.getEncoder().encodeToString(fileBytes);

		} catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public void updatePdf(String path, String type)
	{
		if (type.equalsIgnoreCase("klov"))
		{
			String base64EncodedPdf = encodeFileToBase64(path);
			if (base64EncodedPdf != null)
			{
				String encodeUrl = "data:application/pdf;base64," + base64EncodedPdf;
				String pdfEmbed = "<embed src=\"" + encodeUrl + "\" type=\"application/pdf\" width=\"100%\" height=\"600px\" />";
				getTest().log(Status.INFO, "<a href=\"" + pdfEmbed + "\" target=\"_blank\">Download PDF</a>");
				getTest().log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(pdfEmbed).build());
			} else
			{
				getTest().log(Status.FAIL, "Failed to encode PDF to Base64.");
			}
		} else
		{
			File destFile = new File("path/to/destination.pdf"); // Specify a different destination path
			try
			{
				Files.copy(Paths.get(path), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
				String pdfLink = "<a href=\"" + destFile.getPath() + "\" target=\"_blank\">Download PDF</a>";
				getTest().log(Status.INFO, "Attached PDF Report: " + pdfLink);
			} catch (IOException e)
			{
				getTest().log(Status.FAIL, "Error copying PDF: " + e.getMessage());
			}
		}
	}

	public static String readPDF(String filePath)
	{
		String textPdf = null;
		File file = new File(filePath);
		try (PDDocument document = PDDocument.load(file))
		{
			PDFTextStripper pdfStripper = new PDFTextStripper();
			textPdf = pdfStripper.getText(document);
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}
		return textPdf;
	}

	public void setCustomReportProperties()
	{
		System.setProperty("SuiteName", xmlFileName);
		if (browserName.get().toLowerCase().contains("chrome"))
		{
			System.setProperty("browser", "chrome");
		} else
		{
			System.setProperty("browser", browserName.get());
		}
		System.setProperty("environment", xmlEnvironment);
	}

	public boolean getCredentialAndValidate()
	{
		String sheetName = System.getProperty("ProductName");
		String userName = System.getProperty("UserName");
		String environment = System.getProperty("Environment");
		String accountType = System.getProperty("Account");
		String role = System.getProperty("Role");
		String version = System.getProperty("ReleaseVersion");
		for (int i = 1; i <= credentialSheet.get().getRowCount(sheetName); i++)
		{
			if (credentialSheet.get().getCellData(sheetName, "UserName", i).equalsIgnoreCase(userName.toLowerCase()))
			{
				if (credentialSheet.get().getCellData(sheetName, "Environment", i).equalsIgnoreCase(environment.toLowerCase()))
				{
					if (credentialSheet.get().getCellData(sheetName, "Version", i).equalsIgnoreCase(version.toLowerCase()))
					{
						if (credentialSheet.get().getCellData(sheetName, "Account", i).equalsIgnoreCase(accountType.toLowerCase()))
						{
							if (credentialSheet.get().getCellData(sheetName, "Role", i).equalsIgnoreCase(role.toLowerCase()))
							{
								String password = credentialSheet.get().getCellData(sheetName, "Password", i);
								System.setProperty("Password", password);
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}

	public static String extractResourceToTempFile(String resourcePath, String suffix)
	{
		File tempFile = null;
		try
		{
			InputStream is = XLSReader.class.getClassLoader().getResourceAsStream(resourcePath);
			if (is == null)
			{
				throw new FileNotFoundException("Resource not found: " + resourcePath);
			}

			tempFile = File.createTempFile("xls_temp_", suffix);
			tempFile.deleteOnExit();

			try (FileOutputStream os = new FileOutputStream(tempFile))
			{
				byte[] buffer = new byte[1024];
				int length;
				while ((length = is.read(buffer)) != -1)
				{
					os.write(buffer, 0, length);
				}
			}
		} catch (Exception e)
		{
		}
		if (tempFile == null)
		{
			return null;
		} else
		{
			return tempFile.getAbsolutePath();
		}
	}
}
