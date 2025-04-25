package utility;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.FileHeader;
import repository.AnalyticsRepository;
import repository.AudienceRepository;
import repository.CommunicationRepository;
import repository.DashboardRepository;
import repository.ObjectRepository;

public class PageBase
{
	protected WebDriver driver;
	protected Page page;
	protected PageFactory pageFactory;
	private int invalidLinksCount;
	private int validLinksCount;
	private int jobStatusId;
	public int commStatusCount, audienceNumber, halfAudience, listingPageEngagement, listingPageReach, listingPageTotalSent, listingPageConversion;
	public List<String> FilterlistValues = new ArrayList<String>();
	public List<String> commDetails = new ArrayList<String>();
	public List<Map<String, String>> rowList, paymentDetails;
	public Map<String, String> trgtListDetails = new LinkedHashMap<String, String>();
	public String communicationName, audienceList, edmLink, edmFileWeight, emailSubjectline, emailSubjectContains, captureEmailScheduleDate, captureSmsScheduleDate, VMSContentPersonalization, vmsSubjectline, captureVmsScheduleDate, campaignId,
			campGUID1, campBlastScheduleGUID, campaignJobMetaDataStatus, campaignJobDataStatus, myProfileName, AccStpEmailId, parentCompany, agencyCompany, agencyGroup, clientName, mobileNumber, uploadListName, loginOtp, ImportDescription,
			MDMTotalAudience, targetListName, EnterDynamiclistName, audienceCount, wordCount, ETdynamicList, ListName, createdby, status, subjectlineemoji, halfAudienceStr, ScrubbedStr, SplitscheduleStr, CommunicationNamE;

	public static String shortListName;
	public List<Map<String, String>> campDetails, usersList;
	public static RequestSpecification reqspec;
	public static Response response;
	public static Properties p;

	// ****************** 4.8.8 account setup ******************************
	public String businessMail, accountType, licenseType, salutation, firstName, lastName, jobFunction, password, mobileNumbercountry, company, brandType, website, address, city, zipcode, countryName, regionName, preferredRegion, industry,
			businessType, brandPositioning, dateFormat, timeformat, timeZone;

	// whatsapp mkstr
	public String WhatsAppTemplateName;

	public Map<String, Integer> consumptionReport = new LinkedHashMap<>();
	public Map<String, String> actStpDetails = new LinkedHashMap<>();
	public Map<String, String> overviewInfoChannelViseDetails = new LinkedHashMap<String, String>();

	// DOCKER Compose Property
	public static final String DOCKER_COMPOSE_PATH = System.getProperty("Docker_Compose_Path");
	public static final String DOCKER_COMPOSE_UP = System.getProperty("Docker_Compose_Up");
	public static final String DOCKER_COMPOSE_DOWN = System.getProperty("Docker_Compose_Down");

	public static final String companyName = System.getProperty("CompanyName");

	public static final String audience_approver1 = System.getProperty("Target_Dynamic_approver1_webmail_Uname");
	public static final String audience_approver2 = System.getProperty("Target_Dynamic_approver2_Uname");
	public static final String audience_approver3 = System.getProperty("Target_Dynamic_approver3_Uname");
	public static final String audience_ftp_sftp_friendlyname = System.getProperty("Audience_Upload_Ftp_Sftp_friendlyname");
	public static final String audience_ftp_ipaddress = System.getProperty("Audience_Upload_Ftp_ipaddress");
	public static final String audience_ftp_portnumber = System.getProperty("Audience_Upload_Ftp_portnumber");
	public static final String audience_ftp_username = System.getProperty("Audience_Upload_Ftp_username");
	public static final String audience_ftp_password = System.getProperty("Audience_Upload_Ftp_password");
	public static final String audience_ftp_filepath = System.getProperty("Audience_Upload_Ftp_filepath");
	public static final String audience_sftp_ipaddress = System.getProperty("Audience_Upload_Sftp_ipaddress");
	public static final String audience_sftp_portnumber = System.getProperty("Audience_Upload_Sftp_portnumber");
	public static final String audience_sftp_username = System.getProperty("Audience_Upload_Sftp_username");
	public static final String audience_sftp_filepath = System.getProperty("Audience_Upload_Sftp_filepath");
	public static final String aud_adhoc_ftp_ip = System.getProperty("Audience_Upload_Adhoc_Ftp_ipaddress");
	public static final String aud_adhoc_ftp_portumber = System.getProperty("Audience_Upload_Adhoc_Ftp_portnumber");
	public static final String aud_adhoc_ftp_username = System.getProperty("Audience_Upload_Adhoc_Ftp_username");
	public static final String aud_adhoc_ftp_password = System.getProperty("Audience_Upload_Adhoc_Ftp_password");
	public static final String aud_adhoc_ftp_filepath = System.getProperty("Audience_Upload_Adhoc_Ftp_filepath");
	public static final String aud_adhoc_sftp_ip = System.getProperty("Audience_Upload_Adhoc_Sftp_ipaddress");
	public static final String aud_adhoc_sftp_portnumber = System.getProperty("Audience_Upload_Adhoc_Sftp_portnumber");
	public static final String aud_adhoc_sftp_username = System.getProperty("Audience_Upload_Adhoc_Sftp_username");
	public static final String aud_adhoc_sftp_password = System.getProperty("Audience_Upload_Adhoc_Sftp_password");
	public static final String aud_adhoc_sftp_filepath = System.getProperty("Audience_Upload_Adhoc_Sftp_filepath");
	public static final String aud_Rds_MySql_ipaddress = System.getProperty("Audience_Upload_RDS_MySql_ipaddress");
	public static final String aud_Rds_MySql_username = System.getProperty("Audience_Upload_RDS_MySql_username");
	public static final String aud_Rds_MySql_password = System.getProperty("Audience_Upload_RDS_MySql_password");
	public static final String aud_Rds_MySql_database = System.getProperty("Audience_Upload_RDS_MySql_database");
	public static final String aud_Rds_MySql_portno = System.getProperty("Audience_Upload_RDS_MySql_portno");
	public static final String aud_Rds_MySql_instancename = System.getProperty("Audience_Upload_RDS_MySql_InstanceName");
	public static final String aud_Rds_MsSql_ipaddress = System.getProperty("Audience_Upload_RDS_MsSql_ipaddress");
	public static final String aud_Rds_MsSql_username = System.getProperty("Audience_Upload_RDS_MsSql_username");
	public static final String aud_Rds_MsSql_password = System.getProperty("Audience_Upload_RDS_MsSql_password");
	public static final String aud_Rds_MsSql_database = System.getProperty("Audience_Upload_RDS_MsSql_database");
	public static final String aud_Rds_MsSql_portno = System.getProperty("Audience_Upload_RDS_MsSql_portno");
	public static final String aud_Rds_MsSql_instancename = System.getProperty("Audience_Upload_RDS_MsSql_InstanceName");
	public static final String Persona_1 = System.getProperty("Persona_1");
	public static final String Persona_1_Value = System.getProperty("Persona_1_Value");
	public static final String Persona_2 = System.getProperty("Persona_2");
	public static final String Persona_2_Value = System.getProperty("Persona_2_Value");
	public static final String Persona_3 = System.getProperty("Persona_3");
	public static final String Persona_3_Value = System.getProperty("Persona_3_Value");
	public static final String Persona_4 = System.getProperty("Persona_4");
	public static final String Persona_4_Value = System.getProperty("Persona_4_Value");
	public static final String Persona_5 = System.getProperty("Persona_5");
	public static final String Persona_5_Value = System.getProperty("Persona_5_Value");
	public static final String Persona_6 = System.getProperty("Persona_6");
	public static final String Persona_6_Value = System.getProperty("Persona_6_Value");
	public static final String changePswd_user = System.getProperty("Change_Pswd");

	// SQL Details
	public static final String sqlconnectionTimeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public static final String dburl_master = System.getProperty("dburl_master");
	public static final String masterdb_userName = System.getProperty("masterdb_userName");
	public static final String masterdb_password = System.getProperty("masterdb_password");
	public static final String masterDBname = System.getProperty("masterdbname");

	public static final String dburl_campaign = System.getProperty("dburl_campaign");
	public static final String campaigndb_userName = System.getProperty("campaigndb_userName");
	public static final String campaigndb_password = System.getProperty("campaigndb_password");

	public static final String dburl_customer = System.getProperty("dburl_customer");
	public static final String customerdb_userName = System.getProperty("customerdb_userName");
	public static final String customerdb_password = System.getProperty("customerdb_password");

	public static final String dburl_audience = System.getProperty("dburl_audience");
	public static final String audiencedb_userName = System.getProperty("audiencedb_userName");
	public static final String audiencedb_password = System.getProperty("audiencedb_password");

	public static final String dburl_emailReport = System.getProperty("dburl_emailReport");
	public static final String emailReportdb_userName = System.getProperty("emailReportdb_userName");
	public static final String emailReportdb_password = System.getProperty("emailReportdb_password");

	public static final String dburl_smsReport = System.getProperty("dburl_smsReport");
	public static final String smsReportdb_userName = System.getProperty("smsReportdb_userName");
	public static final String smsReportdb_password = System.getProperty("smsReportdb_password");

	public static final String custdbname = System.getProperty("db_custdb");
	public static final String auddbname = System.getProperty("db_auddb");
	public static final String campdbname = System.getProperty("db_campdb");
	public static final String tenantId = System.getProperty("tenantId");
	public static final String jobdb = System.getProperty("db_job");
	public static final String reportType = System.getProperty("reportType");

	public static final String dburl_prod_job = System.getProperty("dburl_production_job");
	public static final String dbusername_prod_job = System.getProperty("dbusername_production_job");
	public static final String dbpassword_prod_job = System.getProperty("dbpassword_production_job");
	public static final String jobdbname = System.getProperty("jobdbname");

	public static final String dburl_prod_tenant = System.getProperty("dburl_production_tenant");
	public static final String dbusername_prod_tenant = System.getProperty("dbusername_production_tenant");
	public static final String dbpassword_prod_tenant = System.getProperty("dbpassword_production_tenant");
	public static final String aud_tenantdb = System.getProperty("db_auddb");
	private static final String ListTimeStamp = null;

	public static String emailSubjectLineBlastText;

	// ACCOUNT CREATION EMAIL THREAD
	public static Map<Long, String> acctStpEmailID = new HashMap<>();
	public static Map<Long, String> newUsers = new LinkedHashMap<>();

	Connection conn = null;
	private SoftAssert softAssert = new SoftAssert();

	public PageBase(WebDriver driver, Page page, PageFactory pageFactory) {
		this.driver = driver;
		this.page = page;
		this.pageFactory = pageFactory;
	}

	public PageFactory getPageFactory()
	{
		return pageFactory;
	}

	/**
	 * used for page load time calculate
	 * 
	 * @param pageName - Current page name
	 * @param time     - how much time it took to load a page
	 */
	public void pageloadTime(String pageName, long time)
	{
		long seconds = TimeUnit.MILLISECONDS.toSeconds(time);
		if (seconds > 7)
		{
			BaseTest.getTest().log(Status.INFO, pageName + " page load time in seconds : " + seconds);
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.INFO, pageName + " Page load time in seconds : " + seconds);
		}
	}

	/**
	 * Click element by using javaScript
	 * 
	 * @param pr - Element from object repository
	 */
	public void jscriptclick(String pr)
	{
		try
		{
			WebElement ele = driver.findElement(autolocator(pr));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", ele);
			BaseTest.getTest().log(Status.INFO, "Clicked ---> " + BaseTest.logName.get());
		} catch (Exception e)
		{
			assertCheck(BaseTest.logName.get(), "click action failed");
		}

	}

	/**
	 * Explicit wait for element to click
	 * 
	 * @param by  - By class need to call autolocator method and should pass object repository element
	 * @param sec - how many second we have to wait need to provide
	 */
	public void explicitwaitforclick(By by, int sec)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	/**
	 * Explicit wait for element to be present
	 * 
	 * @param by  - By class need to call autolocator method and should pass object repository element
	 * @param sec - how many second we have to wait need to provide
	 */
	public void explicitwaitforpresence(By by, int sec)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	/**
	 * Explicit wait for element to be visible in page
	 * 
	 * @param by  - By class need to call autolocator method and should pass object repository element
	 * @param sec - how many second we have to wait need to provide
	 * @return WebElement
	 */
	public WebElement explicitwaitforvisibility(By by, int sec)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	/**
	 * Explicit wait for element to be Invisible in page
	 * 
	 * @param locator - Element locator should pass object repository element
	 * @param sec     - how many second we have to wait need to provide
	 */

	public void explicitwaitforInvisibility(String locator, int sec)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.invisibilityOf(findElement(locator)));
	}

	/**
	 * Explicit wait for element to be selectable
	 * 
	 * @param by  - By class need to call autolocator method and should pass object repository element.
	 * @param sec - how many second we have to wait need to provide
	 */
	public void explicitwaitforelementselect(By by, int sec)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeSelected(by));
	}

	public void turnOnImplicityWait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void turnOffImplicityWait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
	}

	/**
	 * It used to verify for page loaded or not. If javascript ready state complete page loaded other wise returns false.
	 * 
	 * @return boolean - if page loaded true else false.
	 */
	public boolean javaScriptPageLoad()
	{
		boolean load = false;
		while (!load)
		{
			try
			{
				if (((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"))
				{
					load = true;
					break;
				}
			} catch (Exception e)
			{
				threadSleep(ObjectRepository.wait5sec);
				break;
			}
		}
		return load;
	}

	/**
	 * It used to verify for page loaded or not. If resulticks logo loader completes, page loaded. Otherwise not loaded and returns false.
	 * 
	 * @return boolean - if logo page loader loaded true else false.
	 */
	public void pageLoaderLogo()
	{

		turnOffImplicityWait();
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
		} catch (Exception e)
		{
		}
		turnOnImplicityWait();

//		turnOffImplicityWait();
//		try
//		{
//			explicitwaitforInvisibility("Page load,xpath,//div[@id='loading']", 2000);
//		} catch (Exception e)
//		{
//		}
//		turnOnImplicityWait();

//		boolean load = false;
//		By autolocator = autolocator("Page loader,xpath,//div[contains(@id,'loading')]");
//		try
//		{
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//			wait.until(ExpectedConditions.visibilityOfElementLocated(autolocator));
//			if (wait.until(ExpectedConditions.invisibilityOfElementLocated(autolocator)))
//			{
//				load = true;
//			}
//		} catch (TimeoutException exception)
//		{
//			exception.printStackTrace();
//		}

//		int count = 1;
//		while (!load)
//		{
//			String loadingattribute = getTextBoxVal("Page loader,xpath,//div[contains(@id,'loading')]", "style");
//			if (loadingattribute.toLowerCase().contains("none"))
//			{
//				load = true;
//				break;
//			}
//			count++;
//			if (count == 1000)
//			{
//				System.out.println("Page not loaded Sucessfully");
//				break;
//			}
//		}
	}

	public void pw_pageLoaderLogo()
	{
		try
		{
			page.locator("#loading").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN).setTimeout(60000));
		} catch (PlaywrightException e)
		{
			System.out.println("Loading element did not become hidden: " + e.getMessage());
		}
	}

	public void mksPageloader()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
	}

	public boolean pageBufferContainer()
	{
		boolean load = true;
		explicitwaitforpresence(autolocator(ObjectRepository.allpages_pageloader), 30);
		while (load)
		{
			if (!isElementPresent(ObjectRepository.allpages_pageloader))
			{
				load = false;
				break;
			}
		}
		if (!load)
		{
			System.out.println("Page still Loading...");
		}
		return load;
	}

	public WebElement findElement(String pr)
	{
		return driver.findElement(autolocator(pr));
	}

	/**
	 * Returns list of WebElements
	 * 
	 * @param pr - object repository element
	 * @return
	 */
	public List<WebElement> findElements(String pr)
	{
		return driver.findElements(autolocator(pr));
	}

	/**
	 * It used to navigate back in browser
	 */
	public void navigateBack()
	{
		driver.navigate().back();

	}

	// Retrying stale element exception
	public boolean retryingFindClick(By by)
	{
		boolean result = false;
		int attempts = 0;
		while (attempts < 12)
		{
			try
			{
				driver.findElement(by).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e)
			{
			}
			attempts++;
		}
		return result;
	}

	/**
	 * It used to get current URL from browser.
	 */
	public String getCurrentUrl()
	{
		String obj = driver.getCurrentUrl();
		return obj;
	}

	public PageBase refresh()
	{
		driver.navigate().refresh();
		pageLoaderLogo();
		return this;
	}

	/**
	 * This method used for element selected or not
	 * 
	 * @param pr - if element selected returns true.
	 * @return
	 */
	public boolean isSelected(String pr)
	{
		if (driver.findElement(autolocator(pr)).isSelected())
		{
			BaseTest.getTest().log(Status.INFO, "Selected element ---> <b>" + BaseTest.logName.get() + "</b>");
			return true;
		}
		return false;
	}

	public void javaScriptClick(String pr)
	{
		WebElement element = findElement(pr);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		BaseTest.getTest().log(Status.INFO, "Clicked ---> " + BaseTest.logName.get());
	}

	/**
	 * To enter url in current open window
	 * 
	 * @param url - URL parameter
	 */
	public void javaScriptEnterUrl(String url)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.location.href ='" + url + "';");

	}

	/**
	 * New window open using javaScript
	 */
	public void javaScriptopenNewWindow()
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
	}

	/**
	 * Javascript scroll down till end of the page
	 */
	public void javaScriptScrollDown()
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		threadSleep(ObjectRepository.wait3sec);
	}

	/**
	 * Javascript scroll down till some extend
	 */
	public void javaScriptScrollDownToSomeExtend()
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)");
		threadSleep(ObjectRepository.wait1sec);
	}

	public void javaScriptScrollDownToSomeExtend600()
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,600)");
		threadSleep(ObjectRepository.wait1sec);
	}

	public void javaScriptScrollDownToSomeExtend100()
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,100)");
		threadSleep(ObjectRepository.wait1sec);
	}

	public void javaScriptScrollToSomeExtend(String val)
	{
		threadSleep(ObjectRepository.wait1sec);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + val + ")");
	}

	// JavaScript Scroll up to particular axis
	public void javaScriptScrollUpToSomeExtend()
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-200)");
		threadSleep(ObjectRepository.wait1sec);
	}

//javascript double scroll up 
	public void javascriptdoublescrollup()
	{
		javaScriptScrollUpToSomeExtend();
		javaScriptScrollUpToSomeExtend();

	}

	// javascript double scroll down
	public void javascriptdoublescrolldown()
	{
		javaScriptScrollDownToSomeExtend();
		javaScriptScrollDownToSomeExtend();

	}

	/**
	 * Scroll to the particular element
	 * 
	 * @param pr - By calling autolocator method and object repository.
	 */
	public void javaScriptScrollIntoView(String pr)
	{
		WebElement element = driver.findElement(autolocator(pr));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		threadSleep(ObjectRepository.wait1sec);
	}

	/**
	 * Scroll to the particular element for up
	 * 
	 * @param pr - By calling autolocator method and object repository.
	 */
	public void javaScriptScrollIntoViewUp(String pr)
	{
		try
		{
			WebElement element = driver.findElement(autolocator(pr));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			threadSleep(ObjectRepository.wait1sec);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void javaScriptScrollIntoViewExact(String pr)
	{
		WebElement element = driver.findElement(autolocator(pr));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		threadSleep(ObjectRepository.wait1sec);
		javaScriptScrollUpToSomeExtend();
		threadSleep(ObjectRepository.wait1sec);
	}

	/**
	 * Send value by using id, in javaScript If we are unable to pass parameter bt selenium we can use this method
	 * 
	 * @param idvalue  - element id value
	 * @param inputval - send value
	 */

	public void javaScriptSendkeysbyid(String idvalue, String inputval)
	{
		((JavascriptExecutor) driver).executeScript("document.getElementById('" + idvalue + "').setAttribute('value','" + inputval + "')");
	}

	/**
	 * Scroll to top using javaScript
	 */
	public PageBase javaScriptScrolltoTop()
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, 0)");
		threadSleep(ObjectRepository.wait2sec);
		return this;
	}

	public void javaScriptHighLightElement(Object obj)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = null;
		if (obj instanceof String)
		{
			element = findElement(obj.toString());
		} else if (obj instanceof WebElement)
		{
			element = (WebElement) obj;
		}
		String styleAttribute = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red;')", element);
		threadSleep(ObjectRepository.wait100ms);
		jsExecutor.executeScript("arguments[0].setAttribute('style','" + styleAttribute + "')", element);
	}

	public void javaScriptMouseOver(WebElement hoverElement)
	{
		String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		((JavascriptExecutor) driver).executeScript(mouseOverScript, hoverElement);
	}

	/**
	 * Select expected element form list.
	 * 
	 * @param elementspath - object repository element
	 * @param input        - expected value - contains. Ex: Actual value "Apple", we can pass parameter -"App" but not "APp" if found it clicks.
	 * @return if value found return true else fail.
	 */
	public boolean selectlistelements(String elementspath, String input)
	{

		threadSleep(ObjectRepository.wait3sec);
		List<WebElement> allele = findElements(elementspath);
		boolean elementis = false;
		if (!allele.isEmpty())
		{
			for (WebElement element : allele)
			{
				String ele = element.getText().trim().toLowerCase();
				String inputval = input.trim().toLowerCase();
				if (ele.contains(inputval))
				{
					element.click();
					pageLoaderLogo();
					elementis = true;
					break;
				} else
				{
					elementis = false;
				}
			}
			if (elementis)
			{
				BaseTest.getTest().log(Status.INFO, "Select list element ---> " + BaseTest.logName.get() + " ---> <b>" + input + "</b>");
				return true;
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Select list element failed ---> " + BaseTest.logName.get() + "--->" + input);
				BaseTest.takeScreenshot();
				return false;
			}
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Select list element size 0 ---> " + BaseTest.logName.get() + "--->" + input);
			return false;
		}

	}

	public boolean audienceSelectlistelements(String elementspath, String input)
	{
		threadSleep(400);
		List<WebElement> allele = findElements(elementspath);
		boolean elementis = false;
		if (!allele.isEmpty())
		{
			for (WebElement element : allele)
			{
				String ele = element.getText().trim().toLowerCase();
				String inputval = input.trim().toLowerCase();
				if (ele.contains(inputval))
				{
					element.click();
					pageLoaderLogo();
					elementis = true;
					break;
				} else
				{
					elementis = false;
				}
			}
			if (elementis)
			{
				BaseTest.getTest().log(Status.INFO, "Select list element ---> " + BaseTest.logName.get() + " ---> <b>" + input + "</b>");
				return true;
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Select list element failed ---> " + BaseTest.logName.get() + "--->" + input);
				BaseTest.takeScreenshot();
				return false;
			}
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Select list element size 0 ---> " + BaseTest.logName.get() + "--->" + input);
			return false;
		}

	}

	/**
	 * Select expected element form list.
	 * 
	 * @param elementspath   - object repository element
	 * @param attributeValue - form which user should get the value. Ex: in li tag- "value","class","href" etc..
	 * @param input          - - expected value - contains. Ex: Actual value "Apple", we can pass parameter -"App" or "APp" if found it clicks. not
	 *                       case sensitive.
	 * @return if value found return true else fail.
	 */
	public boolean selectlistelements(String elementspath, String attributeValue, String input)
	{
		threadSleep(ObjectRepository.wait3sec);
		List<WebElement> allele = driver.findElements(autolocator(elementspath));
		boolean elementis = false;
		if (!allele.isEmpty())
		{
			for (WebElement element : allele)
			{
				String ele = element.getAttribute(attributeValue).trim().toLowerCase();
				String inputval = input.trim().toLowerCase();
				if (ele.contains(inputval))
				{
					threadSleep(ObjectRepository.wait1sec);
					element.click();
					elementis = true;
					break;
				} else
				{
					elementis = false;
				}
			}
			if (elementis)
			{
				BaseTest.getTest().log(Status.INFO, "Select list element ---> " + BaseTest.logName.get() + " ---> <b>" + input + "</b>");
				return true;
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Select list element failed ---> " + BaseTest.logName.get() + "---> <b>" + input + "</b>");
				BaseTest.takeScreenshot();
				return false;
			}
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Select list element size 0 ---> " + BaseTest.logName.get() + "--->" + input);
			return false;
		}

	}

	/**
	 * Select expected element form list.
	 * 
	 * @param elementspath - object repository element
	 * @param input        - expected value - contains. Ex: Actual value "Apple", we can pass parameter -"App" or "APp" if found it clicks. not case
	 *                     sensitive.
	 * @return if value found return true else false and proceed.
	 */
	public boolean selectlistelementsAndProceed(String elementspath, String input)
	{
		threadSleep(ObjectRepository.wait5sec);
		List<WebElement> allele = driver.findElements(autolocator(elementspath));
		boolean elementis = false;
		if (!allele.isEmpty())
		{
			for (WebElement element : allele)
			{
				String ele = element.getText().trim().toLowerCase();
				String inputval = input.trim().toLowerCase();
				if (ele.contains(inputval))
				{
					element.click();
					elementis = true;
					break;
				} else
				{
					elementis = false;
				}
			}
			if (elementis)
			{
				BaseTest.getTest().log(Status.INFO, "Select list element ---> " + BaseTest.logName.get() + " ---> <b>" + input + "</b>");
				return true;
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Select list element Not available ---> " + BaseTest.logName.get() + " ---> <b>" + input + "</b>");
				BaseTest.takeScreenshot();
				return false;
			}
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Select list element size 0 ---> " + BaseTest.logName.get() + "--->" + input);
			return false;
		}
	}

	/**
	 * Select expected element form list.
	 * 
	 * @param elementspath - object repository element
	 * @param input        - expected value - contains. Ex: Actual value "Apple", we can pass parameter -"APPLE" if found it clicks. not case
	 *                     sensitive but we have to pass whole word.
	 * @return if value found return true else fail.
	 */
	public boolean selectexactlistelements(String elementspath, String input)
	{
		threadSleep(ObjectRepository.wait3sec);
		List<WebElement> allele = driver.findElements(autolocator(elementspath));
		boolean elementis = false;
		if (!allele.isEmpty())
		{
			for (WebElement element : allele)
			{
				String ele = element.getText().trim().toLowerCase();
				String inputval = input.trim().toLowerCase();
				if (ele.equals(inputval))
				{
					threadSleep(ObjectRepository.wait1sec);
					element.click();
					elementis = true;
					break;
				} else
				{
					elementis = false;
				}
			}
			if (elementis)
			{
				BaseTest.getTest().log(Status.INFO, "Select list element ---> " + BaseTest.logName.get() + " ---> <b>" + input + "</b>");
				return true;
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Select list element not available---> " + BaseTest.logName.get() + "--->" + input);
				return false;
			}
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Select list element size 0 ---> " + BaseTest.logName.get() + "--->" + input);
			return false;
		}
	}

	public boolean selectScrollToListelements(String elementspath, String input)
	{
		threadSleep(ObjectRepository.wait3sec);
		List<WebElement> allele = driver.findElements(autolocator(elementspath));
		boolean elementis = false;
		if (!allele.isEmpty())
		{
			for (WebElement element : allele)
			{
				String ele = element.getText().trim().toLowerCase();
				String inputval = input.trim().toLowerCase();
				if (ele.equals(inputval))
				{
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					threadSleep(ObjectRepository.wait1sec);
					element.click();
					elementis = true;
					break;
				} else
				{
					elementis = false;
				}
			}
			if (elementis)
			{
				BaseTest.getTest().log(Status.INFO, "Select list element ---> " + BaseTest.logName.get() + " ---> <b>" + input + "</b>");
				return true;
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Select list element not available---> " + BaseTest.logName.get() + "--->" + input);
				return false;
			}
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Select list element size 0 ---> " + BaseTest.logName.get() + "--->" + input);
			return false;
		}
	}

	/**
	 * Switch to frame by index
	 * 
	 * @param index - index value
	 */
	public void switchToFrame(int index)
	{
		driver.switchTo().frame(index);
	}

	/**
	 * Switch to frame by name
	 * 
	 * @param nameorxpath - name of frame
	 */
	public void switchToFrame(String nameorxpath)
	{
		try
		{
			driver.switchTo().frame(nameorxpath);
		} catch (Exception e)
		{
			// TODO: handle exception
			System.out.println();
		}
	}

	/**
	 * Switch to default content
	 */
	public void defaultContents()
	{
		driver.switchTo().defaultContent();
	}

	/**
	 * Validate page links from current page.
	 */
	public void validateInvalidLinks()
	{
		try
		{
			// Thread.sleep(3000);
			invalidLinksCount = 0;
			int totalLinks = 0;
			validLinksCount = 0;
			int Linkswithjavscriptnull = 0;
			List<WebElement> anchorTagsList = driver.findElements(By.tagName("a"));
			BaseTest.getTest().log(Status.INFO, "Total a tags :" + anchorTagsList.size());
			for (WebElement anchorTagElement : anchorTagsList)
			{
				if (anchorTagElement != null)
				{
					String url = anchorTagElement.getAttribute("href");
					if (url != null && !url.contains("javascript") && !url.equals("\"\"") && !url.isEmpty())
					{
						totalLinks++;
						verifyURLStatus(url);
					} else
					{
						Linkswithjavscriptnull++;
					}
				}
			}
			BaseTest.getTest().log(Status.INFO, "Total no. of  links with null and java script are " + Linkswithjavscriptnull);
			BaseTest.getTest().log(Status.INFO, "Total no. of valid links are " + validLinksCount);
			BaseTest.getTest().log(Status.INFO, "Total no. of invalid links are " + invalidLinksCount);
			BaseTest.getTest().log(Status.INFO, "Total no. of a tags are " + anchorTagsList.size());
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	private void verifyURLStatus(String URL)
	{
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(URL);
		try
		{
			HttpResponse response = client.execute(request);
			if (response.getStatusLine().getStatusCode() != 200)
			{
				invalidLinksCount++;
				BaseTest.getTest().log(Status.WARNING, "Link is not working / not getting response and dormant : " + URL);
				BaseTest.getTest().log(Status.INFO, "Request URL status is  :   " + request);
				BaseTest.getTest().log(Status.INFO, "Response URL status is  :  " + response);
			} else
			{
				validLinksCount++;
			}
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	/**
	 * It used to split object repository element- Log name,element type,element value.
	 * 
	 * @param key - Ex: "Plugin popup proceed,xpath,//div[contains(@class,'cnTBlock')]/input";
	 * @return
	 */
	public static By autolocator(String key)
	{
		String[] a = key.split(",", 3); // 2 -> for splitting first comma only
		try
		{
			BaseTest.logName.set(a[0]);
			switch (a[1])
			{
			case "xpath":
				return By.xpath(a[2]);
			case "id":
				return By.id(a[2]);
			case "name":
				return By.name(a[2]);
			case "css":
				return By.cssSelector(a[2]);
			case "link":
				return By.linkText(a[2]);
			case "class":
				return By.className(a[2]);
			case "parlink":
				return By.partialLinkText(a[2]);
			case "tag":
				return By.tagName(a[2]);
			}
		} catch (NoSuchElementException prin)
		{
			prin.printStackTrace();
		}
		return null;
	}

	// Url enter

	/**
	 * Used to pass the URL in current browser window.
	 * 
	 * @param surl - URL
	 * @return
	 */
	public WebDriver getWebURL(String surl)
	{
		driver.get(surl);

		return driver;
	}

	/**
	 * It used to click element - widely used method.
	 * 
	 * @param pr - object repository element
	 */
	public void clickElement(String pr)
	{
		try
		{
			fluentWait(20, pr);
			WebElement obj = driver.findElement(autolocator(pr));;
			javaScriptHighLightElement(obj);
			// explicitwaitforclick(autolocator(pr), 20);
			obj.click();
			BaseTest.getTest().log(Status.INFO, "Clicked ---> " + BaseTest.logName.get());
		} catch (Exception e)
		{
			// String name = new Object(){}.getClass().getEnclosingMethod().getName();
			assertCheck(BaseTest.logName.get(), " : click action failed");
		}

	}

	public void clickElement(WebElement element, String log)
	{
		try
		{
			element.click();
			BaseTest.getTest().log(Status.INFO, "Clicked ---> " + log);
		} catch (Exception e)
		{
			assertCheck(BaseTest.logName.get(), " : click action failed");
		}
	}

	public void assertCheck(String methodName, String errormsg, String objName, Exception e)
	{
		// BaseTest.getTest().fail("MethodName" + methodName + " , errorMsg" + errormsg
		// + " , Object:"
		// + objName + " , Exception:" + e);
		// Assert.assertEquals(1, 0, "MethodName" + methodName + " , errorMsg" +
		// errormsg + " , Object:" + objName + " , Exception:" + e);
		Assert.assertSame(1, 0, "MethodName" + methodName + " , errorMsg" + errormsg + " , Object:" + objName + " , Exception:" + e);
	}

	public void assertCheck(String elementName, String value)
	{
		// BaseTest.getTest().fail("MethodName" + methodName + " , errorMsg" +
		// efrrormsg);
		Assert.assertEquals(1, 0, "Element :" + elementName + "value : " + value);

	}

	public void assertCheck(String elementName, String value, String errormsg)
	{
		// BaseTest.getTest().fail("MethodName" + methodName + " , errorMsg" +
		// errormsg);
		Assert.assertEquals(1, 0, "Element :" + elementName + "value : " + value + ", errorMsg" + errormsg);

	}

	/**
	 * It used to clear field and Sendkeys
	 * 
	 * @param pr - object repository element
	 * @param dt - Sendkeys value
	 */
	public PageBase enterValue(String pr, String dt)
	{
		try
		{
			fluentWait(20, pr);
			WebElement obj = driver.findElement(autolocator(pr));
			javaScriptHighLightElement(obj);
			obj.clear();
			obj.sendKeys(dt);
			BaseTest.getTest().log(Status.INFO, "Enter value  --->  " + BaseTest.logName.get() + " ---> <b>" + dt + "</b>");
		} catch (Exception e)
		{
			assertCheck(BaseTest.logName.get(), dt, e.getMessage());
		}
		return this;
	}

	// Enter double value
	public void enterdoublValue(String pr, double dt)
	{
		WebElement obj = driver.findElement(autolocator(pr));
		String num = Double.toString(dt);
		String[] fnum1 = num.split("\\.");
		obj.sendKeys(fnum1[0]);
	}

	/**
	 * It used to sendkeys
	 * 
	 * @param pr - object repository element
	 * @param dt - Sendkeys value
	 */
	public void sendValue(String pr, String dt)
	{
		try
		{
			WebElement obj = findElement(pr);
			obj.clear();
			obj.sendKeys(dt);

		} catch (Exception e)
		{
			assertCheck(BaseTest.logName.get(), dt, e.getMessage());
		}
	}

	public void sendValueWithoutFluent(String pr, String dt)
	{
		try
		{
			WebElement obj = findElement(pr);
			obj.sendKeys(dt);

		} catch (Exception e)
		{
			assertCheck(BaseTest.logName.get(), dt, e.getMessage());
		}
	}

	public void sendValues(String pr, String dt)
	{
		try
		{
			WebElement obj = findElement(pr);
			obj.sendKeys(dt);

		} catch (Exception e)
		{
			assertCheck(BaseTest.logName.get(), dt, e.getMessage());
		}
	}

	// Get Text
	/**
	 * Used to get innerText of element
	 * 
	 * @param pr - object repository element
	 * @return string textContent
	 */
	public String getInnerText(String pr)
	{
		WebElement obj = driver.findElement(autolocator(pr));
		return obj.getAttribute("textContent");
	}

	/**
	 * Used to get text of element
	 * 
	 * @param pr - object repository element
	 * @return string getText
	 */
	public String getStrText(String pr)
	{
		WebElement obj = driver.findElement(autolocator(pr));
		return obj.getText().trim();
	}

	/**
	 * Used get attribute value
	 * 
	 * @param pr  - object repository element
	 * @param val - Pass required attribute value
	 * @return value
	 */
	public String getTextBoxVal(String pr, String val)
	{
		WebElement obj = driver.findElement(autolocator(pr));
		return obj.getAttribute(val).trim();
	}

	// Assert equals
	public void assertEqual(String log, String act, String exp)
	{
		Assert.assertEquals(act, exp);
		BaseTest.getTest().log(Status.INFO, log + " ---> Actual : " + act + " Equals with Expected : " + exp);
	}

	// Assert not same
	public void assertNotSame(String act, String exp)
	{
		Assert.assertNotSame(act, exp);
	}

	// Select by visible text
	public void selectByvisibleText(String pr, String dt)
	{
		WebElement obj = driver.findElement(autolocator(pr));
		Select se = new Select(obj);
		se.selectByVisibleText(dt);
		BaseTest.getTest().log(Status.INFO, "Selected drop-down --> <b>" + dt + "</b>");
	}

	// Select by index
	public void selectByIndex(String pr, int dt)
	{
		WebElement obj = driver.findElement(autolocator(pr));
		Select se = new Select(obj);
		se.selectByIndex(dt);
	}

	// Select by value
	public void selectByValue(String pr, String dt)
	{
		WebElement obj = driver.findElement(autolocator(pr));
		Select se = new Select(obj);
		se.selectByValue(dt);
	}

	// Get first select option
	public String getfirstselectedoption(String pr)
	{
		WebElement obj = driver.findElement(autolocator(pr));
		Select se = new Select(obj);
		WebElement option = se.getFirstSelectedOption();
		String zone = option.getText();
		return zone;
	}

	public void selectDate(String pr, String dt)
	{
		WebElement obj = driver.findElement(autolocator(pr));
		obj.click();
		BaseTest.getTest().log(Status.INFO, "Clicked element ---> " + BaseTest.logName.get());
		threadSleep(ObjectRepository.wait3sec);
		WebElement obj2 = driver.findElement(By.linkText(dt));
		obj2.click(); //
		BaseTest.getTest().log(Status.INFO, "Selected element ---> " + dt);
	}

	public void enterTabAction()
	{
		Actions action = new Actions(BaseTest.getWebDriver());
		action.sendKeys(Keys.TAB).build().perform();
	}

	public void getCaptchatxt(String pr, String pr2)
	{

		WebElement obj = driver.findElement(autolocator(pr));
		String num = obj.getText();
		String[] fnum = num.split("\\=");
		String[] ynum = fnum[0].split("\\+");
		String val1 = ynum[0].trim();
		String val2 = ynum[1].trim();
		// System.out.println(ynum[0] + ynum[1]);
		int foo = Integer.parseInt(val1);
		int foo1 = Integer.parseInt(val2);
		int sum = foo + foo1;
		String vlue = Integer.toString(sum);
		// System.out.println(vlue);

		// driver.findElement(By.id("VerificationCode")).sendKeys(vlue);
		WebElement obj2 = driver.findElement(autolocator(pr2));
		obj2.clear();
		obj2.sendKeys(vlue);
	}

	public boolean isDisplayedWar(String pr)
	{
		boolean displayed = false;
		try
		{
			WebElement obj = explicitwaitforvisibility(autolocator(pr), 30);
			displayed = obj.isDisplayed();
			if (displayed)
			{
				BaseTest.getTest().info("Element displayed : <b>" + BaseTest.logName.get() + "</b>, As Expected.");
			}
		} catch (Exception e)
		{
			BaseTest.getTest().warning("Element isn't displayed : <b>" + BaseTest.logName.get() + "</b>");
		}
		BaseTest.takeScreenshot();
		return displayed;
	}

	public boolean isDisplayed(String pr)
	{
		boolean displayed = false;
		try
		{
			WebElement obj = explicitwaitforvisibility(autolocator(pr), 30);
			displayed = obj.isDisplayed();
			if (displayed)
			{
				BaseTest.getTest().info("Element displayed : <b>" + BaseTest.logName.get() + "</b>, As Expected.");
			}
		} catch (Exception e)
		{
			BaseTest.getTest().fail("Element isn't displayed : <b>" + BaseTest.logName.get() + "</b>");
		}
		BaseTest.takeScreenshot();
		return displayed;
	}

	public void compareUiwithInputvalue(String uielement, String inputvalue)
	{
		if (uielement.equalsIgnoreCase(inputvalue))
		{
			BaseTest.getTest().log(Status.INFO, "The  \"<b>" + uielement + "</b>\" is displayed as expectedtext is displayed and equals to its input value as : " + inputvalue);
		} else if (uielement.contains(inputvalue))
		{
			BaseTest.getTest().log(Status.INFO, "The  \"<b>" + uielement + "</b>\" text is displayed and contains input value as : " + inputvalue);
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "The  " + uielement + " differs from its input value : " + inputvalue);
			BaseTest.takeScreenshot();
		}
	}

	public boolean checkInputBoxLength(String elements, String testData, int maxLength)
	{
		enterValue(elements, testData);
		int input = getTextBoxVal(elements, "value").length();
		if (maxLength == input)
		{
			BaseTest.getTest().info("The Max. Character limit is <b>" + input + "</b>, As Expected");
			return true;
		} else
		{
			BaseTest.getTest().fail("The Max. Character limit validation failed, Actual : " + input + ", Expected : " + maxLength);
			javaScriptHighLightwithScrnShot(elements);
		}
		return false;
	}

	// Check String contains any special characters
	public boolean hasContainsSpecialChar(String elements, String testData)
	{
		enterValue(elements, testData).tabAction();
		String inputBox = getTextBoxVal(elements, "value");
		if (inputBox == null || inputBox.isEmpty())
		{
			return false;
		}
		Pattern pattern = Pattern.compile("[^\\w]");

		return pattern.matcher(inputBox).find();
	}

	public boolean isEnabled(String pr)
	{
		WebElement obj = driver.findElement(autolocator(pr));
		if (obj.isEnabled())
		{
			BaseTest.getTest().info(BaseTest.logName.get() + " is Enabled, As Expected");
			return true;
		}
		return false;
	}

	public void licenceKey(String key, String pr1, String pr2, String pr3)
	{
		// String key = testKey();
		// System.out.println(key);
		String[] scol = key.split("\\:");
		String[] lkey = scol[1].split("\\-");
		String val1 = lkey[0].trim();
		String val2 = lkey[1].trim();
		String val3 = lkey[2].trim();
		enterValue(pr1, val1);
		enterValue(pr2, val2);
		enterValue(pr3, val3);
	}

	public static void setClipboardData(String ClipVal) throws InterruptedException, HeadlessException
	{
		Thread.sleep(3000);
		StringSelection StringVal = new StringSelection(ClipVal);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(StringVal, null);
		Thread.sleep(5000);

		// System.out.println(" the clipboard value has been copied");
	}

	public static void scrollUp()
	{
		try
		{
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_UP);
			robot.keyRelease(KeyEvent.VK_PAGE_UP);
			Thread.sleep(5000);
		} catch (InterruptedException | AWTException e)
		{
			// System.out.println("Scroll/Page Up - not working");
		}

	}

	public static void scrollDown() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

	}

	public static void enter() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	// New Method Escape
	public static void escape()
	{
		Robot robot;
		try
		{
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
		} catch (AWTException e)
		{
			System.out.println(e.getMessage());
		}

	}

	// New Method Tab
	public static void tab()
	{
		Robot robot;
		try
		{
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
		} catch (AWTException e)
		{
			System.err.println("Tab exception:" + e.getMessage());
		}

	}

	public static void saveEnter() throws AWTException, InterruptedException
	{
		Robot robot = new Robot();
		// press Ctrl+S the Robot's way
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_S);
		// press Enter
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void assertConditionCheck(String webval, String dbval, String title)
	{
		if (!webval.isEmpty() || !webval.equals("NA"))
		{
			try
			{
				Assert.assertEquals(webval, dbval);
				System.out.println("Pass - No of " + title + " in db is: " + dbval + "|| Web value is:" + webval);
			} catch (AssertionError e)
			{
				System.out.println("Miss Matched - No of " + title + " in db is: " + dbval + "|| Web value is: " + webval);
			}
		}

	}

	public static void dbFieldCheck(String table, String column_name_main, String column_name_dynamic, String DatabaseName)
	{
		try
		{
			Assert.assertEquals(column_name_main, column_name_dynamic);
			System.out.println();
			System.out.println("---------Table name--------");
			System.out.println(table);
			System.out.println("---------------------------");
			System.out.println("Column name in " + DatabaseName + " is: " + column_name_main + " || Column name in Client Cust db is: " + column_name_dynamic + "- PASS");
		} catch (AssertionError e)
		{
			System.out.println("Column name in " + DatabaseName + " is: " + column_name_main + " || Column name in Client Cust db is: " + column_name_dynamic + "- Miss matched - FAIL");
		}

	}

	public static void tablechkExcel(String exceltable, String metricsTable)
	{
		try
		{
			Assert.assertEquals(exceltable, metricsTable);
			System.out.println();
			System.out.println("---------Table name--------");
			System.out.println(metricsTable);
			System.out.println("---------------------------");
			System.out.println("Table name in Metrics db is: " + metricsTable + " || Table name in Excel is: " + exceltable + "- PASS");
		} catch (AssertionError e)
		{
			System.out.println("Table name in Metrics db is: " + metricsTable + " || Table name in Excel is: " + exceltable + "- Miss matched - FAIL");
		}

	}

	public static void clientdbtblchkExcel(String exceltable, String clientdbTable)
	{
		try
		{
			Assert.assertEquals(exceltable, clientdbTable);
			System.out.println();
			System.out.println("---------Table name--------");
			System.out.println(clientdbTable);
			System.out.println("---------------------------");
			System.out.println("Table name in Client db is: " + clientdbTable + " || Table name in Excel is: " + exceltable + "- PASS");
		} catch (AssertionError e)
		{
			System.out.println("Table name in Client db is: " + clientdbTable + " || Table name in Excel is: " + exceltable + "- Miss matched - FAIL");
		}

	}

	public static void editCheck(String webval, String excelval, String title)
	{
		try
		{
			Assert.assertEquals(webval, excelval);
			System.out.println(title + " in Excel is: " + excelval + "|| Web value is: " + webval + "- PASS");
		} catch (AssertionError e)
		{
			System.out.println(title + " in Excel is: " + excelval + "|| Web value is: " + webval + "- FAIL");
		}

	}

	public void actionsClickElement(String pr)
	{
		WebElement obj = driver.findElement(autolocator(pr));
		System.out.println("the xpath value is" + obj);
		Actions action = new Actions(driver);
		action.click(obj).build().perform();
		BaseTest.getTest().log(Status.INFO, "Clicked ---> " + BaseTest.logName.get());
	}

	public static void doubleClickElement(WebDriver driver, String pr)
	{
		WebElement obj = driver.findElement(autolocator(pr));
		// emailSubjectLineBlastText = obj.getText().toString();
		Actions action = new Actions(driver);
		action.click(obj).doubleClick(obj).build().perform();
	}

	public static void sendvalueAndTabAction(WebDriver driver, String pr, String val)
	{
		WebElement obj = driver.findElement(autolocator(pr));
		Actions action = new Actions(driver);
		action.sendKeys(obj, val).sendKeys(Keys.TAB).build().perform();
	}

	public void tabAction()
	{
		Actions action = new Actions(BaseTest.getWebDriver());
		action.sendKeys(Keys.TAB).build().perform();
		javaScriptPageLoad();
		threadSleep(500);
	}

	public void enterAction()
	{
		Actions action = new Actions(BaseTest.getWebDriver());
		action.sendKeys(Keys.ENTER).build().perform();
		javaScriptPageLoad();
		threadSleep(ObjectRepository.wait2sec);
	}

	public void clickTab()
	{
		Actions action = new Actions(BaseTest.getWebDriver());
		action.sendKeys(Keys.TAB).build().perform();
	}

	public static void draganddrop(WebDriver driver, String source, String dest)
	{
		WebElement obj = driver.findElement(autolocator(source));
		WebElement obj1 = driver.findElement(autolocator(dest));
		// System.out.println("the xpath value is" +obj);
		Actions action = new Actions(driver);
		int x = obj1.getLocation().getX();
		int y = obj1.getLocation().getY();
		System.out.println(x + "#" + y);
		int x1 = obj.getLocation().getX();
		int y1 = obj.getLocation().getY();

		System.out.println(x1 + "#" + y1);
		action.clickAndHold(obj).pause(2000).moveToElement(obj1).pause(4000).release().build().perform();

	}

	// Drag horizontal left
	public void dragAndDropLeft(WebDriver driver, String element, int moveto)
	{
		WebElement slider = driver.findElement(autolocator(element));
		int width = slider.getSize().getWidth();
		Actions move = new Actions(driver);
		move.moveToElement(slider, ((width * moveto) / 100), 0).click();
		move.build().perform();
	}

	public static void draganddrops(WebDriver driver, String source, String via, String Dest)
	{
		WebElement obj = driver.findElement(autolocator(source));
		WebElement obj1 = driver.findElement(autolocator(via));
		// WebElement obj2 = driver.findElement(autolocator(Dest));
		// System.out.println("the xpath value is" +obj);
		Actions action = new Actions(driver);
		action.clickAndHold(obj).pause(2000).moveToElement(obj1).pause(5000).moveToElement(driver.findElement(autolocator(Dest))).pause(5000).release().build().perform();
	}

	public static void draganddropBy(WebDriver driver, String source, int x, int y)
	{
		WebElement obj = driver.findElement(autolocator(source));
		Actions action = new Actions(driver);
		action.dragAndDropBy(obj, x, y).pause(2000).build().perform();
		// action.clickAndHold(obj).moveToElement(obj1).pause(2000).release().build().perform();
	}

	public String parentWinHandle()
	{
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		return parentHandle;
	}

	public void switchWindow()
	{
		for (String winHandle : driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
			// switch focus of WebDriver to the next found window handle (that's your newly
			// opened window)
		}
	}

	public void childWindowClose(String pwind)
	{
		for (String winHandle : driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle);
			if (!winHandle.equals(pwind))
			{
				driver.close();
			}
		}
		driver.switchTo().window(pwind);
	}

	public void childWindowCloseIndex(int index)
	{
		Set<String> windowHandles = driver.getWindowHandles();
//		List<String> listWindow = new LinkedList<>(windowHandles);
		for (int count = 0; count < windowHandles.size(); count++)
		{
			if (count == index)
			{
				driver.close();
			}
		}
	}

	public void switchWindowByIndex(int index)
	{
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listWindow = new LinkedList<>(windowHandles);
		String string = listWindow.get(index);
		driver.switchTo().window(string);
	}

	public void switchParentWin(String parentHandle)
	{
		driver.switchTo().window(parentHandle);
	}

	public void switchToSpecificWindow(int index)
	{
		List<String> multipleWindows = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(multipleWindows.get(index));
	}

	/**
	 * Switches to the newly opened window.
	 * 
	 * @param oldWindows the set of window handles before the new window was opened
	 * @return the handle of the newly opened window, or null if no new window was found
	 */
	public String switchToNewWindow(Set<String> oldWindows)
	{
		Set<String> allWindows = BaseTest.getWebDriver().getWindowHandles();

		for (String windowHandle : allWindows)
		{
			if (!oldWindows.contains(windowHandle))
			{
				BaseTest.getWebDriver().switchTo().window(windowHandle);
				return windowHandle;
			}
		}
		return null; // New window not found
	}

	public void switchDefault()
	{
		driver.switchTo().defaultContent();
	}

	public boolean isElementPresent(String element)
	{
		try
		{
			turnOffImplicityWait();
			driver.findElement(autolocator(element));
			turnOnImplicityWait();
			return true;
		} catch (Exception e)
		{
			turnOnImplicityWait();
			return false;
		}
	}

	// DB Connect
	// ##########################################################################
	public List<Map<String, String>> getdbQueryResults(String dburl, String dbUserName, String dbUserPswrd, String query)
	{
		rowList = new LinkedList<Map<String, String>>();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");// com.mysql.jdbc.Driver
			conn = DriverManager.getConnection(dburl + sqlconnectionTimeZone, dbUserName, dbUserPswrd);
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(query);
			final ResultSetMetaData meta = result.getMetaData();
			final int columnCount = meta.getColumnCount();
			while (result.next())
			{
				final Map<String, String> map = new HashMap<String, String>();
				rowList.add(map);
				for (int column = 1; column <= columnCount; ++column)
				{
					final Object value = result.getObject(column);
					map.put(meta.getColumnLabel(column), String.valueOf(value));
				}
			}
		} catch (Exception e)
		{
			System.out.println("First exception:" + e.getMessage());
			System.out.println(e);
		} finally
		{
			try
			{
				conn.close();
				if (rowList.isEmpty())
				{
					BaseTest.getTest().fail("Query returns null: " + query);
				}
			} catch (SQLException e)
			{
				System.out.println(e.getMessage());
			}
		}

		return rowList;

	}

	public String mapToString(Map<String, String> map)
	{
		StringBuilder stringBuilder = new StringBuilder();

		for (String key : map.keySet())
		{
			if (stringBuilder.length() > 0)
			{
				stringBuilder.append(" & ");
			}
			String value = map.get(key);
			try
			{
				stringBuilder.append((key != null ? key : ""));
				stringBuilder.append("=");
				stringBuilder.append(value != null ? value : "");
			} catch (Exception e)
			{
				throw new RuntimeException("This method requires UTF-8 encoding support", e);
			}
		}

		return stringBuilder.toString();
	}

	public String encodedName(String campName)
	{
		byte[] encodedBytes = Base64.getEncoder().encode(campName.getBytes());
		String campnameEncoded = new String(encodedBytes);
		return campnameEncoded;
	}

	public String decodedName(String campName)
	{
		byte[] decodedBytes = Base64.getDecoder().decode(campName.getBytes());
		String campnamedecoded = new String(decodedBytes);
		return campnamedecoded;
	}

	public String qEmailCampDetails(String campName)
	{
		String campnameEncoded = encodedName(campName);
		return "SELECT c.CampaignID,c.CampaignType,FROM_BASE64(c.CampaignName) CampaignName,cm.ChannelID,c.CampaignGUID,c.StartDate,c.EndDate, "
				+ "cs.BlastScheduleGuid,cs.BlastDateTime,cd.Subject,cd.SplitType,c.CampaignDocket,c.tags,c.CampaignGroupingID,c.IsSmartUrlEnabled, "
				+ "c.IsEmailSplitAB,c.IsCampaignGroup,c.IsTestCampaign FROM ccampaign c JOIN ccampaignchannelmapping cm ON c.CampaignID = cm.CampaignID "
				+ "JOIN cedmchanneldetail cd ON c.CampaignID = cd.CampaignID LEFT JOIN cedmschedule cs ON cd.EDMChannelID = cs.EDMChannelID " + " WHERE c.CampaignName = '" + campnameEncoded + "' AND cm.ChannelID = 1 GROUP BY cd.EDMChannelID;";
	}

	public String qSplitEmailCampDetails(String campName, String SplitType)
	{
		String campnameEncoded = encodedName(campName);
		return "SELECT c.CampaignID,c.CampaignType,FROM_BASE64(c.CampaignName) CampaignName,cm.ChannelID,c.CampaignGUID,c.StartDate,c.EndDate, "
				+ "cs.BlastScheduleGuid,cs.BlastDateTime,cd.Subject,cd.SplitType,c.CampaignDocket,c.tags,c.CampaignGroupingID,c.IsSmartUrlEnabled, "
				+ "c.IsEmailSplitAB,c.IsCampaignGroup,c.IsTestCampaign FROM ccampaign c JOIN ccampaignchannelmapping cm ON c.CampaignID = cm.CampaignID"
				+ " JOIN cedmchanneldetail cd ON c.CampaignID = cd.CampaignID LEFT JOIN cedmschedule cs ON cd.EDMChannelID = cs.EDMChannelID  " + "WHERE c.CampaignName = '" + campnameEncoded + "' AND cd.SplitType='" + SplitType
				+ "' AND cm.ChannelID = 1 GROUP BY cd.EDMChannelID;";

	}

	public String qEmailCampRFADetails(String campName, String rfaMail)
	{
		String campnameEncoded = encodedName(campName);
		return "SELECT tmp.CampaignID,tmp.CampaignType,tmp.CampaignName,tmp.ChannelID,tmp.CampaignGUID,tmp.StartDate,tmp.EndDate,tmp.BlastScheduleGuid,\r\n"
				+ "tmp.BlastDateTime,rfe.ApprovalEmailSentTo,rfe.IsApproved,rfe.Priority,rfe.MakeChangesComments FROM \r\n"
				+ "(SELECT c.CampaignID,c.CampaignType,FROM_BASE64(CampaignName) AS CampaignName,cm.ChannelID,c.CampaignGUID,c.StartDate,c.EndDate,cs.BlastScheduleGuid,cs.BlastDateTime,cs.EDMChannelID\r\n"
				+ "FROM ccampaign c,ccampaignchannelmapping cm,cedmchanneldetail cd,cedmschedule cs\r\n" + " WHERE c.CampaignID = cm.CampaignID AND cm.CampaignID = cd.CampaignID AND cd.EDMChannelID\r\n" + "  = cs.EDMChannelID  AND c.CampaignName = '"
				+ campnameEncoded + "' AND cm.ChannelID = 1 ) tmp LEFT OUTER JOIN cedmscheduleworkflow rfe ON rfe.EDMChannelID = tmp.EDMChannelID\r\n" + "  AND rfe.ApprovalEmailSentTo='" + rfaMail + "';";

	}

	public String qSMSCampRFADetails(String campName, String rfaMail)
	{
		String campnameEncoded = encodedName(campName);
		return "SELECT tmp.CampaignID,tmp.CampaignType,tmp.CampaignName,tmp.ChannelID,tmp.CampaignGUID,tmp.StartDate,tmp.EndDate,tmp.SMSScheduleGUID,\r\n"
				+ "tmp.BlastDateTime,rfs.ApprovalEmailSentTo,rfs.IsApproved,rfs.MakeChangesComments FROM (SELECT c.CampaignID,c.CampaignType,FROM_BASE64(CampaignName) AS CampaignName,\r\n"
				+ "cm.ChannelID,c.CampaignGUID,c.StartDate,c.EndDate,cs.SMSScheduleGUID,cs.BlastDateTime,cs.SMSChannelDetailID\r\n"
				+ "FROM ccampaign c,ccampaignchannelmapping cm,csmschanneldetail cd,csmsschedule cs WHERE c.CampaignID = cm.CampaignID AND \r\n"
				+ "cm.CampaignID = cd.CampaignID AND cd.SMSChannelDetailID = cs.SMSChannelDetailID AND c.CampaignName = '" + campnameEncoded + "' AND cm.ChannelID = 2)"
				+ " tmp LEFT OUTER JOIN `cworkflowschedule` rfs ON rfs.ChannelID = tmp.SMSChannelDetailID AND rfs.ApprovalEmailSentTo='" + rfaMail + "';";
	}

	public String qSMSCampDetails(String campName)
	{
		String campnameEncoded = encodedName(campName);
		return "SELECT c.CampaignID,c.CampaignType,FROM_BASE64(c.CampaignName) AS CampaignName,cm.ChannelID,c.CampaignGUID,c.StartDate,c.EndDate,\r\n"
				+ "cs.SMSScheduleGUID,cs.BlastDateTime,cd.SplitType,c.CampaignDocket,c.tags,c.CampaignGroupingID,c.IsSmartUrlEnabled,c.IsEmailSplitAB,\r\n"
				+ "c.IsCampaignGroup,c.IsTestCampaign FROM ccampaign c JOIN ccampaignchannelmapping cm ON c.CampaignID = cm.CampaignID JOIN \r\n"
				+ "csmschanneldetail cd ON  c.CampaignID = cd.CampaignID LEFT JOIN csmsschedule cs ON cd.SMSChannelDetailID = cs.SMSChannelDetailID\r\n" + "WHERE c.CampaignName = '" + campnameEncoded
				+ "' AND cm.ChannelID = 2 GROUP BY cd.SMSChannelDetailID;";
	}

	public String qMobilePushCampDetails(String campName)
	{
		String campnameEncoded = encodedName(campName);
		return "SELECT c.CampaignID,c.CampaignType,FROM_BASE64(c.CampaignName),cm.ChannelID,c.CampaignGUID,c.StartDate,c.EndDate,cs.PushNotifyScheduleGuid,cs.BlastDateTime,c.IsMobPushSplitAB,\r\n"
				+ "cm.CampaignChannelMappingID ,cd.PushTypeID,cd.NotificationType,cd.Layout,cd.Position,cd.IsMobCarouselON,cd.InboxclassificationID,cd.InboxclassificationType,cd.IsSecureMessageON,\r\n"
				+ "cs.PushNotifyScheduleID,cs.PushNotifyScheduleGuid FROM ccampaign c JOIN ccampaignchannelmapping cm ON c.CampaignID = cm.CampaignID JOIN cpushnotifychanneldetail cd ON \r\n"
				+ "c.CampaignID = cd.CampaignID LEFT JOIN  cpushnotifyschedule cs ON cd.PushNotifyChannelDetailID = cs.PushNotifyChannelDetailID  WHERE c.CampaignName = '" + campnameEncoded + "' \r\n"
				+ " AND cm.ChannelID = 14  GROUP BY cd.PushNotifyChannelDetailID;";

	}

	public String qWebNotificationCampDetails(String campName)
	{
		String campnameEncoded = encodedName(campName);
		return " SELECT *,FROM_BASE64(CampaignName) FROM ccampaign c JOIN ccampaignchannelmapping cm ON c.CampaignID = cm.CampaignID JOIN "
				+ "cwebnotifychanneldetail cd ON c.CampaignID = cd.CampaignID LEFT JOIN  cwebnotifyschedule cs ON cd.WebNotifyChannelID = " + "cs.WebNotifyChannelID  WHERE c.CampaignName" + " = '" + campnameEncoded
				+ "'  AND cm.ChannelID = 8  GROUP BY cd.WebNotifyChannelID;";

	}

	public String qJobStatus(int jobType)
	{
		return "SELECT j.JobID,j.JobType,j.StatusID,c.Status CampaignJobMetaDataStatus,s.Status CampaignJobDataStatus FROM jobmaster j LEFT OUTER JOIN CampaignJobMetaData c ON j.JobID = c.JobID"
				+ " LEFT OUTER JOIN CampaignJobData s ON c.JobID = s.JobID WHERE j.DataBaseName= '" + campdbname + "' AND j.campaignid=" + campaignId + " AND j.jobType=" + jobType + ";";

	}

	public String qBlastFileSync(int jobType)
	{
		return "SELECT * FROM CampaignBlastFileSync WHERE campaignid=" + campaignId + " AND JobType=" + jobType;
	}

	public String qCampaigndatasyncconfig()
	{
		return "SELECT * FROM resulticksjobdb.campaigndatasyncconfig WHERE CampaignGuid='" + campGUID1 + "' AND BlastscheduleGuid='" + campBlastScheduleGUID + "'";
	}

	public String qrptCampaignblastEmailTable()
	{

		String guid = campGUID1.replace("-", "_");
		return "SELECT C1,R1,B2,B1 FROM rptcampaignblast_" + guid;
	}

	public String qrptCampaignblastSMSTable()
	{

		String guid = campGUID1.replace("-", "_");
		return "SELECT C1,R1,B2,B1 FROM rptcampaignsms_" + guid;
	}

	public String dPropertyLoginUserName()
	{
		String pval = System.getProperty("TUsername");
		return pval;
	}

	public String dPropertyLoginUserNameUserManage()
	{
		String pval = System.getProperty("TUserManagename");
		return pval;
	}

	public String dPropertyLoginPswrdUserManage()
	{
		String pval = System.getProperty("TPasswordUserManage");
		return pval;
	}

	public String dPropertyLoginPswrd()
	{
		String pval = System.getProperty("TPassword");
		return pval;
	}

	public String dPropertyTeamLoginUserName()
	{
		String pval = System.getProperty("TeamUsername");
		return pval;
	}

	public String dPropertyTeamLoginPswrd()
	{
		String pval = System.getProperty("TeamPassword");
		return pval;
	}

	public String dPropertyChangePswrdUser()
	{
		String pval = System.getProperty("ChangePswd_User");
		return pval;
	}

	public String dPropertyForgetPswdUser()
	{
		String pval = System.getProperty("Target_Dynamic_approver1_Uname");
		return pval;
	}

	// ADMIN CONSOLE
	public String getAdminConsoleUserName()
	{
		return System.getProperty("AdminConsole_Username");
	}

	public String getAdminConsolePswd()
	{
		return System.getProperty("AdminConsole_Pswd");
	}

	public Long strToLong(String val)
	{
		long lval = Long.parseLong(val);
		return lval;

	}

	public String mySqlClassName()
	{
		String cls = System.getProperty("db_class");
		return cls;

	}

	public String qCampID(String custdb, String campname)
	{
		String cid = "SELECT * FROM " + custdb + ".campaign where CampaignName = " + campname;
		return cid;
	}

	public String qEmailSumMainPage(String custdb, String reptdb, String campname)
	{
		return "SELECT CES.* FROM " + custdb + ".campaign C " + "inner join resulticksjobdb.CampaignLookup CL ON CL.CampaignID = C.CampaignGUID " + "inner join " + reptdb + ".rptcampaignemailsummaryfact CES " + "ON CL.CampaignShortCode = CES.C1 "
				+ "Where C.CampaignName = " + campname + " Order by CES.CreatedDate Desc limit 1";
	}

	public String qSmsSumMainPage(String custdb, String reptdb, String campname)
	{
		String qsmssumm = "SELECT CSS.* FROM " + custdb + ".campaign C " + "inner join resulticksjobdb.CampaignLookup CL ON CL.CampaignID = C.CampaignGUID " + "inner join " + reptdb + ".rptcampaignsmssummaryfact CSS "
				+ "ON CL.CampaignShortCode = CSS.C1 " + "Where C.CampaignName = " + campname + " Order by CSS.CreatedDate Desc limit 1";
		return qsmssumm;
	}

	public String qQRSumMainPage(String custdb, String reptdb, String campname)
	{
		String qQrsumm = "SELECT CQRS.* FROM " + custdb + ".campaign C " + "inner join resulticksjobdb.CampaignLookup CL ON CL.CampaignID = C.CampaignGUID " + "inner join " + reptdb + ".rptcampaignqrsummaryfact CQRS "
				+ "ON CL.CampaignShortCode = CQRS.C1 " + "Where C.CampaignName = " + campname + " Order by CQRS.CreatedDate Desc limit 1";
		return qQrsumm;
	}

	public String qEmailSumDetailPage(String custdb, String reptdb, String campname)
	{
		String qemailgoal = "SELECT CGE.* FROM " + custdb + ".campaign C " + "inner join resulticksjobdb.CampaignLookup CL ON CL.CampaignID = C.CampaignGUID " + "inner join " + reptdb + ".rptcampaigngoalemail CGE"
				+ "	ON CL.CampaignShortCode = CGE.C1 " + "Where C.CampaignName = " + campname + " and CGE.EA = 'ALL' " + "Order by CGE.CreatedDate DESC limit 1";
		return qemailgoal;
	}

	public String qSmsSumDetailPage(String custdb, String reptdb, String campname)
	{
		String qsmsgoal = "SELECT CSG.* FROM " + custdb + ".campaign C " + "inner join resulticksjobdb.CampaignLookup CL ON CL.CampaignID = C.CampaignGUID " + "inner join " + reptdb + ".rptcampaigngoalsms CSG " + "ON CL.CampaignShortCode = CSG.C1 "
				+ "Where C.CampaignName = " + campname + " and CSG.EA = 'ALL' " + "Order by CSG.CreatedDate Desc limit 1";
		return qsmsgoal;
	}

	public String qQRSumDetailPage(String custdb, String reptdb, String campname)
	{
		String qQrGoal = "SELECT CGQ.* FROM " + custdb + ".campaign C " + "inner join resulticksjobdb.CampaignLookup CL ON CL.CampaignID = C.CampaignGUID " + "inner join " + reptdb + ".rptcampaigngoalqr CGQ " + "ON CL.CampaignShortCode = CGQ.C1 "
				+ "Where C.CampaignName = " + campname + " and CGQ.EA = 'ALL' " + "Order by CGQ.CreatedDate Desc limit 1";
		return qQrGoal;
	}

	public String qEmailLinkClicks(String custdb, String reptdb, String campname)
	{
		String qEmailLinkClicks = "SELECT COUNT(CLCTE.C1) as linkclicks FROM " + custdb + ".campaign C " + "inner join resulticksjobdb.CampaignLookup CL ON CL.CampaignID = C.CampaignGUID " + "inner join " + reptdb
				+ ".rptcampaignlinkclickstransaction CLCTE " + "ON CL.CampaignShortCode = CLCTE.C1 " + "Where C.CampaignName = " + campname;
		return qEmailLinkClicks;
	}

	public String qSmsLinkClicks(String custdb, String reptdb, String campname)
	{
		String qSmsLinkClicks = "SELECT Count(CLCTS.C1) as smslinkclicks FROM " + custdb + ".campaign C " + "inner join resulticksjobdb.CampaignLookup CL ON CL.CampaignID = C.CampaignGUID " + "inner join " + reptdb
				+ ".rptcampaignsmslinkclickstransaction CLCTS " + "ON CL.CampaignShortCode = CLCTS.C1 " + "Where C.CampaignName = " + campname;
		return qSmsLinkClicks;
	}

	public String qQRClicks(String custdb, String reptdb, String campname)
	{
		String qQRClicks = "SELECT Count(CLCTQR.C1) as qrclicks FROM " + custdb + ".campaign C " + "inner join resulticksjobdb.CampaignLookup CL ON CL.CampaignID = C.CampaignGUID " + "inner join " + reptdb + ".rptcampaignqrcodetransaction CLCTQR "
				+ "ON CL.CampaignShortCode = CLCTQR.C1 " + "Where C.CampaignName = " + campname;
		return qQRClicks;
	}

	public String qGetDBname(String clientname)
	{
		String qGetDB = "SELECT c.clientid, c.databaseid, d.instancename FROM resulticksmaster.mclient AS c " + "JOIN resulticksmaster.mdbinstance AS d ON d.databaseid = c.databaseid " + "WHERE c.clientname like " + clientname + " limit 1";
		return qGetDB;
	}

	public String qDBCreation(String dbname, String rptdb, String rpttables)
	{
		String maindb = "'" + dbname + "'";
		/*
		 * <<<<<<< HEAD String qRptDB =
		 * "SELECT C1.TABLE_SCHEMA SCHEMA_Metricsdb,C2.TABLE_SCHEMA SCHEMA_Dynamicdb, C1.TABLE_NAME TABLE_Metricsdb, C2.TABLE_NAME TABLE_Dynamicdb, "
		 * <<<<<<< HEAD + "C1.COLUMN_NAME COLUMN_Metricsdb, C2.COLUMN_NAME COLUMN_Dynamicdb " + "FROM INFORMATION_SCHEMA.COLUMNS C1 " +
		 * "LEFT JOIN INFORMATION_SCHEMA.COLUMNS C2 ON C1.TABLE_NAME = C2.TABLE_NAME AND C1.COLUMN_NAME = C2.COLUMN_NAME " +
		 * "WHERE C1.TABLE_SCHEMA = 'metricsdb' " + "AND C2.TABLE_SCHEMA = "+rptdb+ " AND  C1.TABLE_NAME = "+rpttables+" AND  C2.TABLE_NAME = "
		 * +rpttables; ======= + "C1.COLUMN_NAME COLUMN_Metricsdb, C2.COLUMN_NAME COLUMN_Dynamicdb " + "FROM INFORMATION_SCHEMA.COLUMNS C1 " +
		 * "LEFT JOIN INFORMATION_SCHEMA.COLUMNS C2 ON C1.TABLE_NAME = C2.TABLE_NAME AND C1.COLUMN_NAME = C2.COLUMN_NAME " +
		 * "WHERE C1.TABLE_SCHEMA = 'metricsdb' " + "AND C2.TABLE_SCHEMA = "+rptdb+ " AND  C1.TABLE_NAME = "+rpttables+" AND  C2.TABLE_NAME = "
		 * +rpttables; >>>>>>> refs/remotes/Resulticks_Automation/main ======= String qRptDB =
		 * "SELECT C1.TABLE_SCHEMA SCHEMA_Metricsdb,C2.TABLE_SCHEMA SCHEMA_Dynamicdb, C1.TABLE_NAME TABLE_Metricsdb, C2.TABLE_NAME TABLE_Dynamicdb, "
		 * <<<<<<< HEAD + "C1.COLUMN_NAME COLUMN_Metricsdb, C2.COLUMN_NAME COLUMN_Dynamicdb " + "FROM INFORMATION_SCHEMA.COLUMNS C1 " +
		 * "LEFT JOIN INFORMATION_SCHEMA.COLUMNS C2 ON C1.TABLE_NAME = C2.TABLE_NAME AND C1.COLUMN_NAME = C2.COLUMN_NAME " +
		 * "WHERE C1.TABLE_SCHEMA = 'metricsdb' " + "AND C2.TABLE_SCHEMA = "+rptdb+ " AND  C1.TABLE_NAME = "+rpttables+" AND  C2.TABLE_NAME = "
		 * +rpttables; ======= + "C1.COLUMN_NAME COLUMN_Metricsdb, C2.COLUMN_NAME COLUMN_Dynamicdb " + "FROM INFORMATION_SCHEMA.COLUMNS C1 " +
		 * "LEFT JOIN INFORMATION_SCHEMA.COLUMNS C2 ON C1.TABLE_NAME = C2.TABLE_NAME AND C1.COLUMN_NAME = C2.COLUMN_NAME " +
		 * "WHERE C1.TABLE_SCHEMA = 'metricsdb' " + "AND C2.TABLE_SCHEMA = "+rptdb+ " AND  C1.TABLE_NAME = "+rpttables+" AND  C2.TABLE_NAME = "
		 * +rpttables; >>>>>>> refs/remotes/Resulticks_Automation/main >>>>>>> refs/remotes/Resulticks_Automation/main
		 */
		String qRptDB = "SELECT C1.TABLE_SCHEMA SCHEMA_Metricsdb,C2.TABLE_SCHEMA SCHEMA_Dynamicdb, C1.TABLE_NAME TABLE_Metricsdb, C2.TABLE_NAME TABLE_Dynamicdb, " + "C1.COLUMN_NAME COLUMN_Metricsdb, C2.COLUMN_NAME COLUMN_Dynamicdb "
				+ "FROM INFORMATION_SCHEMA.COLUMNS C1 " + "Left JOIN INFORMATION_SCHEMA.COLUMNS C2 ON C1.TABLE_NAME = C2.TABLE_NAME AND C1.COLUMN_NAME = C2.COLUMN_NAME " + "WHERE C1.TABLE_SCHEMA = " + maindb + " AND C2.TABLE_SCHEMA = " + rptdb
				+ " AND  C1.TABLE_NAME = " + rpttables + " AND  C2.TABLE_NAME = " + rpttables + " "

				// + "AND C1.COLUMN_NAME "

				+ "UNION " + "SELECT C1.TABLE_SCHEMA SCHEMA_Metricsdb,C2.TABLE_SCHEMA SCHEMA_Dynamicdb, C1.TABLE_NAME TABLE_Metricsdb, C2.TABLE_NAME TABLE_Dynamicdb, " + "C1.COLUMN_NAME COLUMN_Metricsdb, C2.COLUMN_NAME COLUMN_Dynamicdb "
				+ "FROM INFORMATION_SCHEMA.COLUMNS C1 RIGHT JOIN INFORMATION_SCHEMA.COLUMNS C2 ON C1.TABLE_NAME = C2.TABLE_NAME " + "AND C1.COLUMN_NAME = C2.COLUMN_NAME " + "WHERE C1.TABLE_SCHEMA = " + maindb + " AND C2.TABLE_SCHEMA = " + rptdb
				+ " AND  C1.TABLE_NAME = " + rpttables + " AND  C2.TABLE_NAME = " + rpttables;
		// +" AND C2.COLUMN_NAME";
		return qRptDB;

	}

	public String qgetCampIDs()
	{ // ##1
		String campaignnameid = "SELECT T1.CampaignID,T1.CampaignName FROM campaign AS T1 order by campaignid desc limit 30;";
		return campaignnameid;
	}

	public String qgetCampaign(String cId)
	{ // ##2
		String campaignnameid = "select * from campaign where campaignid=" + cId + ";";
		return campaignnameid;
	}

	public String qgetChannels(String cId)
	{ // ##3
		String qchannelsget = "select A.*,B.ChannelName from campaignchannelmapping as A,campaignchannelmaster as B where A.campaignid =" + cId + " " + "and A.ChannelID=B.ChannelID;";
		return qchannelsget;
	}

	public String qgetEmailChannel(String cId)
	{ // ##4
		String qemailchanneldetails = "SELECT T1.CampaignID,T1.CampaignName,T1.StartDate, T1.EndDate,T2.SmartURL,T3.Status,T4.Subject,T5.LocalBlastDateTime," + "T7.RecipientsBunchName,T7.RecipientCountEmail,T8.TimeZoneName FROM" + " "
				+ "campaign AS T1" + " " + "LEFT JOIN smarturl AS T2 ON T1.CampaignID =" + "T2.CampaignID LEFT JOIN statusmaster AS T3 ON T3.StatusID =" + "T1.StatusID LEFT JOIN  edmchanneldetail AS T4 ON T4.CampaignID = "
				+ "T1.CampaignID LEFT JOIN  edmschedule AS T5 ON T5.EdmchannelID =" + "T4.EdmchannelID LEFT JOIN  edmrecipient AS T6 ON T6.EdmchannelID =" + "T4.EdmchannelID LEFT JOIN  segmentationlist AS T7 ON T6.SegmentationListID = "
				+ "T7.SegmentationListID LEFT JOIN resulticksmaster.mtimezonemaster AS T8 ON T8.TimeZoneID =T5.TimeZoneID where T1.CampaignID=" + cId + " " + " ORDER BY T1.CampaignID DESC ;";

		return qemailchanneldetails;
	}

	public String qgetSMSChannel(String cId)
	{ // ##5
		String smschanneldetails = "SELECT T1.CampaignID,T1.CampaignName,T1.StartDate, T1.EndDate,T2.SmartURL,T3.Status," + "T5.LocalBlastDateTime ,T7.RecipientsBunchName,T7.RecipientCountMobile,T8.TimeZoneName	FROM " + " " + "" + ""
				+ ".campaign AS T1	left JOIN " + " " + "" + ".smarturl AS T2 ON T1.CampaignID = T2." + "CampaignID left JOIN " + " " + "" + ".statusmaster AS T3 ON T3.StatusID = T1." + "StatusID	left JOIN " + " " + ""
				+ ".smschanneldetail AS T4 ON T4.CampaignID = T1." + "CampaignID left JOIN " + " " + "" + ".smsschedule AS T5 ON T5.SMSChannelDetailID = T4." + "SMSChannelDetailID left JOIN " + " " + ""
				+ ".smsrecipient AS T6 ON T6.SMSChannelDetailID = T4." + "SMSChannelDetailID	left JOIN " + " " + "" + ".segmentationlist AS T7 ON T6.SegmentationListID = T7."
				+ "SegmentationListID LEFT JOIN resulticksmaster.mtimezonemaster AS T8 ON T8.TimeZoneID =T5.TimeZoneID	 Where T1.CampaignID=" + cId + " " + "ORDER BY T1.CampaignID;";
		return smschanneldetails;
	}

	public String qgetQRChannel(String cId)
	{ // ##5
		String qrchanneldetails = "SELECT T1.CampaignID,T1.CampaignName,T1.StartDate, T1.EndDate,T2.QRShortLink,T3.Status FROM " + " " + "" + "." + "campaign AS T1 LEFT JOIN " + " " + "" + ".qrcodechanneldetail AS T4 ON T4.CampaignID = T1."
				+ "CampaignID LEFT JOIN " + " " + "" + ".qrcodeshortlink AS T2 ON T4.QRCodeChannelDetailID = T2." + "QRCodeChannelDetailID LEFT JOIN " + " " + "" + ".statusmaster AS T3 ON T3.StatusID = T1." + "StatusID Where T1.CampaignID=" + cId
				+ ";";
		return qrchanneldetails;
	}

	public String qgetSocialChannel(String cId)
	{ // ##6
		String qsocialchanneldetails = "SELECT T1.CampaignID,T1.CampaignName,T1.StartDate, T1.EndDate, T4.SocialMediaChannelID, T2.ChannelName,"

				+ " T1.CreatedDate As CampaignCreatedDate,T4.PostName,T4.PostText,T4.PostShortCode, T4.PostLink, T4.ScheduleDate," + " T3.Status,T8.TimeZoneName,T5.LocalBlastDateTime FROM " + " " + "" + ".campaign AS T1 LEFT JOIN " + " " + "" + ""
				+ ".socialmediapost AS T4 ON T4.CampaignID = " + "T1.CampaignID LEFT JOIN " + " " + "" + ".socialmediaschedule AS T5 ON T4.SocialMediaPostID = T5.SocialMediaPostID LEFT JOIN " + " " + ""
				+ ".socialmediachannelmaster AS T2 ON T4.SocialMediaChannelID = " + "T2.SocialMediaChannelID	LEFT JOIN " + " " + "" + ".statusmaster AS T3 ON T3.StatusID = "
				+ "T1.StatusID	LEFT JOIN resulticksmaster.mtimezonemaster AS T8 ON T8.TimeZoneID = T4.TimeZoneID where T1.CampaignID =" + cId + ";";
		return qsocialchanneldetails;
	}

	public String qgetJobDB(String cId, String custdbname, String jobtypes)
	{ // ##6
		String qjobDB = "SELECT T1.campaignid,T1.jobtype,T1.statusid,T1.localscheduletime FROM resulticksjobdb.jobmaster as T1 where T1.DatabaseName=" + "\"" + custdbname + "\"" + " and T1.Campaignid=" + cId + " " + " and T1.jobtype=" + jobtypes
				+ ";";
		return qjobDB;
	}

	public String qgetFooters()
	{
		String qgetFooter = "SELECT * FROM emailfooter;";
		return qgetFooter;
	}

	// **************************************************************************************************

	public void selectcompany(String name, String personal)// Goderj Agrovet
	{
		clickElement(",xpath,//*[@id='divdrp1']/a/i");
		selectlistelements(",xpath,//*[@id='divdrp1']/ul/li", name);
		clickElement(",xpath,//*[@id='pnlClientDropdownPanel']/li[2]/div/a/i");
		selectlistelements(",xpath,//*[@id='ulDepartment']/li", personal);

	}

	public void operatorCheck(int j, String andor)
	{
		// String or = "OR";
		String dcomponent = "filterBuildComp" + j;
		String path = "//*[@id='" + dcomponent + "']/div[2]/div/span[1]";
		System.out.println("Dynamic path value was" + path);
		System.out.println("Excel value was " + andor);
		if (andor.equalsIgnoreCase("OR"))
		{
			WebElement obj = driver.findElement(By.xpath(path));
			obj.click();
			System.out.println("OR operator value");
		} else if (andor.equalsIgnoreCase("AND"))
		{
			System.out.println("Default operator value AND");
		}
	}

	public void selectRecp(String pr, String dt)
	{
		WebElement obj = driver.findElement(autolocator(pr));
		obj.click();
		WebElement obj2 = driver.findElement(By.linkText(dt));
		obj2.click();

	}

	// Read Text file and CSV file and return content of the file
	public ArrayList<Object> filehandle()
	{
		ArrayList<Object> obj = new ArrayList<>();
		StringBuilder output = new StringBuilder();
		threadSleep(ObjectRepository.wait5sec);
		threadSleep(ObjectRepository.wait3sec);
		long lineCount = 0;
		File path = new File(System.getProperty("user.dir") + "/src\\main\\resources\\data\\downloadedFile\\");
		File[] files = path.listFiles();
		for (File file : files)
		{
			String str = file.getName();
			if (file.exists())
			{
				try
				{
					if (str.endsWith(".txt") || str.endsWith(".csv"))
					{
						FileReader fr = new FileReader(file);
						BufferedReader reader = new BufferedReader(fr);
						String line;

						while ((line = reader.readLine()) != null)
						{
							output.append(line);
							output.append(System.getProperty("line.separator"));
							lineCount++;
						}
						reader.close();
					}
				} catch (IOException e)
				{
					e.printStackTrace();
				} finally
				{
					threadSleep(ObjectRepository.wait5sec);
					file.delete();
					BaseTest.getTest().log(Status.INFO, "The downloaded file has been deleted :" + str);
				}
			} else
			{
				BaseTest.getTest().log(Status.INFO, "File not found");
			}
		}
		obj.add(lineCount);
		obj.add(output.toString());
		return obj;
	}

	public ArrayList<Object> consumptionFilehandles()
	{
		ArrayList<Object> obj = new ArrayList<>();
		StringBuilder output = new StringBuilder();
		threadSleep(ObjectRepository.wait5sec);
		threadSleep(ObjectRepository.wait3sec);
		long lineCount = 0;
		File path = new File(System.getProperty("user.dir") + "/src\\main\\resources\\data\\downloadedFile\\");
		File[] files = path.listFiles();
		for (File file : files)
		{
			String str = file.getName();
			if (file.exists())
			{
				try
				{
					if (str.endsWith(".txt") || str.endsWith(".csv"))
					{
						FileReader fr = new FileReader(file);
						BufferedReader reader = new BufferedReader(fr);
						String line;

						while ((line = reader.readLine()) != null)
						{
							output.append(line);
							output.append(System.getProperty("line.separator"));
							lineCount++;
						}
						reader.close();
					}
				} catch (IOException e)
				{
					e.printStackTrace();
				} finally
				{
					threadSleep(ObjectRepository.wait5sec);
					file.delete();
					BaseTest.getTest().log(Status.INFO, "The downloaded file has been deleted :" + str);
				}
			} else
			{
				BaseTest.getTest().log(Status.INFO, "File not found");
			}
		}
		obj.add(lineCount);
		obj.add(output.toString());
		return obj;
	}

	public ArrayList<Object> consumptionFilehandle()
	{
		ArrayList<Object> obj = new ArrayList<>();
		StringBuilder output = new StringBuilder();
		threadSleep(ObjectRepository.wait5sec);
		threadSleep(ObjectRepository.wait3sec);
		long lineCount = 0;
		File path = new File(System.getProperty("user.dir") + "/src\\main\\resources\\data\\downloadedFile\\");
		File[] files = path.listFiles();

		for (File file : files)
		{
			String str = file.getName();
			if (file.exists())
			{
				try
				{
					if (str.endsWith(".txt") || str.endsWith(".csv"))
					{
						FileReader fr = new FileReader(file);
						BufferedReader reader = new BufferedReader(fr);
						String line;

						while ((line = reader.readLine()) != null)
						{
							// Replace commas outside quotes with colons
							String modifiedLine = replaceCommasOutsideQuotes(line);
							output.append(modifiedLine);
							output.append(System.getProperty("line.separator"));
							lineCount++;
						}
						reader.close();
					}
				} catch (IOException e)
				{
					e.printStackTrace();
				} finally
				{
					threadSleep(ObjectRepository.wait5sec);
					file.delete();
					BaseTest.getTest().log(Status.INFO, "The downloaded file has been deleted :" + str);
				}
			} else
			{
				BaseTest.getTest().log(Status.INFO, "File not found");
			}
		}
		obj.add(lineCount);
		obj.add(output.toString());
		return obj;
	}

	private String replaceCommasOutsideQuotes(String line)
	{
		StringBuilder result = new StringBuilder();
		boolean insideQuotes = false;

		for (int i = 0; i < line.length(); i++)
		{
			char currentChar = line.charAt(i);

			if (currentChar == '"')
			{
				insideQuotes = !insideQuotes;
				result.append(currentChar);
			} else if (currentChar == ',' && !insideQuotes)
			{
				result.append(':');
			} else
			{
				result.append(currentChar);
			}
		}

		return result.toString();
	}

	// Zip file handle
	/**
	 * Used to Extract Zip file and Encrypted zip file
	 * 
	 * @param - Form name and Password (if file is Encrypted otherwise enter 'NULL' value )
	 * @return - Extracted File Name
	 */

	public String zipFileExtractor(String formname, String password)
	{
		threadSleep(ObjectRepository.wait5sec);
		String path = System.getProperty("user.dir") + "\\src\\main\\resources\\data\\downloadedFile\\";
		String filename = null;
		File[] files = new File(path).listFiles();
		for (File file : files)
		{
			String str = file.getName();
			if (file.exists() && str.endsWith(".zip"))
			{
				try
				{
					ZipFile zipFile = new ZipFile(file);
					if (zipFile.isEncrypted())
					{
						zipFile.setPassword(password.toCharArray());
						BaseTest.getTest().log(Status.INFO, "The Encrypted Zip File : " + str + " Password is entered");
					}
					List<FileHeader> fileHeaderList = zipFile.getFileHeaders();
					for (FileHeader header : fileHeaderList)
					{
						filename = header.getFileName();
						if (filename.contains(formname))
						{
							zipFile.extractFile(header, path);
							BaseTest.getTest().log(Status.INFO, "The downloaded Zip File has been Extracted : " + str);
							break;
						}
					}
				} catch (Exception e)
				{
					e.printStackTrace();
				} finally
				{
					threadSleep(ObjectRepository.wait3sec);
					file.delete();
					threadSleep(ObjectRepository.wait2sec);
					BaseTest.getTest().log(Status.INFO, "The downloaded file has been deleted : " + str);
				}
			} else
			{
				BaseTest.getTest().log(Status.INFO, "The Zip file not found");
			}
		}
		return filename;
	}

	public String isFileDownloaded(String downloadPath, String fileName)
	{
		String downloadedfilename = "";
		File folder = new File(downloadPath);
		File[] foldercontents = folder.listFiles();

		for (int i = 0; i < foldercontents.length; i++)
		{
			if (foldercontents[i].getName().equals(fileName))
			{
				return downloadedfilename = fileName;
			}
		}
		return downloadedfilename;
	}

	// PDF File Handle

	public void pdffilehandle()
	{
		File path = new File(System.getProperty("user.dir") + "/src\\main\\resources" + "\\data\\downloadedFile\\");
		File[] files = path.listFiles();
		for (File file : files)
		{
			String str = file.getName();
			BaseTest.getTest().log(Status.INFO, "The downloaded file name is: " + "-" + str);
			if (file.exists())
			{
				try
				{
					Desktop.getDesktop().open(file);
					// BaseTest.getTest().log(Status.INFO, str + "File Opened");
					threadSleep(ObjectRepository.wait3sec);
					BaseTest.takeScreenshot();
					Robot robot;
					try
					{
						robot = new Robot();
						robot.keyPress(KeyEvent.VK_ALT);
						robot.keyPress(KeyEvent.VK_F4);
						robot.keyRelease(KeyEvent.VK_F4);
						robot.keyRelease(KeyEvent.VK_ALT);
					} catch (AWTException e)
					{
						System.out.println("Key close method exception" + e.getMessage());
					}
					file.delete();
					BaseTest.getTest().log(Status.INFO, "The downloaded file has been deleted :" + str);
				} catch (IOException ex)
				{
					BaseTest.getTest().log(Status.INFO, "The downloaded file unable to open or having issue:" + str);
				}

			} else
			{

				BaseTest.getTest().log(Status.INFO, "File not found");
			}
		}
	}

	public String[] getCsvfile(String filePath, String excelName)
	{
		String[] columns = null;
		File path = new File(System.getProperty("user.dir") + filePath);
		File[] files = path.listFiles();
		for (File file : files)
		{
			if (file.getName().equalsIgnoreCase(excelName))
			{
				try
				{
					BufferedReader brd = new BufferedReader(new FileReader(file));
					String line = brd.readLine();
					columns = line.split(",");
					brd.close();
					break;
				} catch (Exception e)
				{
					System.out.println(e);
				}
			}
		}
		return columns;
	}

	public int csvfilehandle(String columnname)
	{
		int totalcount = 0;
		int columnIndex = -1;
		File path = new File(System.getProperty("user.dir") + "/src\\main\\resources" + "\\data\\downloadedFile\\");
		File[] files = path.listFiles();
		for (File file : files)
		{
			if (file.exists())
			{
				try
				{
					BufferedReader brd = new BufferedReader(new FileReader(file));
					String line = brd.readLine();
					String[] columns = line.split(",");
					for (int i = 0; i < columns.length; i++)
					{
						if (columnname.equals(columns[i]))
						{
							columnIndex = i;
							break;
						}
					}
					if (columnIndex >= 0)
					{
						while ((line = brd.readLine()) != null)
						{
							String[] values = line.split(",");
							totalcount = totalcount + Integer.parseInt(values[columnIndex]);
						}
					}
					brd.close();
				} catch (Exception e)
				{
					System.out.println(e);
				}
			}
		}
		return totalcount;
	}

	// Get Date for picking start, end and scheduled date
	public static String calendarSchedduleDate(int addDays)
	{
		SimpleDateFormat sd = new SimpleDateFormat("d MMM,yyyy");
		sd.setTimeZone(TimeZone.getTimeZone("IST"));// 2020-08-23
		String dt = sd.format(new Date());
		Calendar c = Calendar.getInstance();
		try
		{
			c.setTime(sd.parse(dt));
		} catch (ParseException e)
		{
			System.out.println(e.getMessage());
		}
		c.add(Calendar.DATE, addDays);
		sd.format(c.getTime());
		int a = c.getTime().getDate();
		dt = String.valueOf(a);
		return dt;
	}

	public String calendarDate(int addDays)
	{
		SimpleDateFormat simpleDate = new SimpleDateFormat("d MMM,yyyy");
		simpleDate.setTimeZone(TimeZone.getTimeZone("IST"));
		String currentDate = simpleDate.format(new Date());
		Calendar c1 = Calendar.getInstance();
		try
		{
			c1.setTime(simpleDate.parse(currentDate));
		} catch (ParseException e)
		{
			System.out.println(e.getMessage());
		}
		c1.add(Calendar.DATE, addDays);
		return simpleDate.format(c1.getTime());
	}

	public String calendarDateTargetList(String inputdate) throws ParseException
	{
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MMM-yyyy");
		java.util.Date date1 = simpleDate.parse(inputdate);
		String newDate = new SimpleDateFormat("dd MMM yyyy").format(date1);
		return newDate;
	}

	public String addTimeToName()
	{
		SimpleDateFormat sd = new SimpleDateFormat("M_d_HHmm_SS");
		Date date = new Date();
		sd.setTimeZone(TimeZone.getTimeZone("IST"));
		String dt = sd.format(date);
		return "_" + dt;
	}

	public String addTimeToNameShrt()
	{
		SimpleDateFormat sd = new SimpleDateFormat("HHmmSS");
		Date date = new Date();
		sd.setTimeZone(TimeZone.getTimeZone("IST"));
		String dt = sd.format(date);
		return "_" + dt;
	}

	public static String addTimeToAlpha()
	{
		SimpleDateFormat sd = new SimpleDateFormat("M_d");
		Date date = new Date();
		sd.setTimeZone(TimeZone.getTimeZone("IST"));
		String dt = sd.format(date);

		return "_" + convertToAlphabetic(dt);
	}

	public static String convertToAlphabetic(String input)
	{
		StringBuilder result = new StringBuilder();
		for (char ch : input.toCharArray())
		{
			if (Character.isDigit(ch))
			{
				result.append((char) ('A' + (ch - '0')));
			} else
			{
				result.append(ch);
			}
		}
		return result.toString();
	}

	public String addTimeToValue()
	{
		SimpleDateFormat sd = new SimpleDateFormat("M-d-HHmmSS");
		Date date = new Date();
		sd.setTimeZone(TimeZone.getTimeZone("IST"));
		String dt = sd.format(date);
		return "" + dt;
	}

	public static void threadSleep(long val)
	{
		try
		{
			Thread.sleep(val);
		} catch (InterruptedException e)
		{
			Thread.currentThread().interrupt();
		}
	}

	public String isFileNameExist(String fileNameContains)
	{
		File folder = new File(System.getProperty("user.dir") + "/src\\main\\resources" + "/data/downloadedFile/");
		File[] listOfFiles = folder.listFiles();
		String filePath = null;
		for (int i = 0; i < listOfFiles.length; i++)
		{
			if (listOfFiles[i].isFile())
			{

				if (listOfFiles[i].getName().contains(fileNameContains))
				{
					System.out.println("File conatains " + listOfFiles[i].getName());
					filePath = "./data/downloadedFile/" + listOfFiles[i].getName();
					break;
				}
			} else if (listOfFiles[i].isDirectory())
			{
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}
		return filePath;
	}

	// Jobservices

	private boolean jobStatusCheck(int jobType)
	{
		boolean isJobStatusCompleted = false;
		for (int jobStatusiteration = 0; jobStatusiteration < 10; jobStatusiteration++)
		{
			threadSleep(ObjectRepository.wait20sec);
			List<Map<String, String>> jobStatus = getdbQueryResults(dburl_master + jobdb, masterdb_userName, masterdb_password, qJobStatus(jobType));
			if (jobStatus.isEmpty())
			{
				BaseTest.getTest().fail("JobStatus check query returns null");
				break;
			}
			Map<String, String> jobStatusRow = jobStatus.get(0);
			jobStatusId = Integer.parseInt(jobStatusRow.get("StatusID"));
			jobStatusUpdateCheck();
			if (jobStatusId == 3)
			{
				campaignJobMetaDataStatus = jobStatusRow.get("CampaignJobMetaDataStatus");
				campaignJobDataStatus = jobStatusRow.get("CampaignJobDataStatus");
				if (jobStatusiteration < 7)
				{
					BaseTest.getTest().log(Status.INFO, "campaignJobMetaDataStatus :" + campaignJobMetaDataStatus + " AND campaignJobDataStatus :" + campaignJobDataStatus);
				}
				if (campJobAndJobMetaDataStatus(campaignJobMetaDataStatus).equalsIgnoreCase("error") || campJobAndJobMetaDataStatus(campaignJobDataStatus).equalsIgnoreCase("error"))
				{
					BaseTest.getTest().fail("JobStatus id =3 and campaignJobMetaDataStatus :" + campaignJobMetaDataStatus + "and campaignJobDataStatus :" + campaignJobDataStatus);
					break;
				}
			} else if (jobStatusId == 2)
			{
				BaseTest.getTest().fail("JobStatus id =2 Campaign marked as ERROR");
				break;
			} else if (jobStatusId == 4)
			{
				campaignJobMetaDataStatus = jobStatusRow.get("CampaignJobMetaDataStatus");
				campJobAndJobMetaDataStatus(campaignJobMetaDataStatus);
				campaignJobDataStatus = jobStatusRow.get("CampaignJobDataStatus");
				campJobAndJobMetaDataStatus(campaignJobDataStatus);
				BaseTest.getTest().log(Status.INFO, "campaignJobMetaDataStatus :" + campaignJobMetaDataStatus + " AND campaignJobDataStatus :" + campaignJobDataStatus);
				isJobStatusCompleted = true;
				break;
			} else if (jobStatusId == 1)
			{
				BaseTest.getTest().log(Status.INFO, "JobStatus id =1 Campaign marked as QUEUE");
			} else if (jobStatusId == 5)
			{
				campaignJobMetaDataStatus = jobStatusRow.get("CampaignJobMetaDataStatus");
				campJobAndJobMetaDataStatus(campaignJobMetaDataStatus);
				campaignJobDataStatus = jobStatusRow.get("CampaignJobDataStatus");
				campJobAndJobMetaDataStatus(campaignJobDataStatus);
				BaseTest.getTest().log(Status.INFO, "campaignJobMetaDataStatus :" + campaignJobMetaDataStatus + " AND campaignJobDataStatus :" + campaignJobDataStatus);
				break;
			}
			if (jobStatusiteration == 7)
			{
				BaseTest.getTest().log(Status.WARNING, "campaignJobMetaDataStatus :" + campaignJobMetaDataStatus + " AND campaignJobDataStatus :" + campaignJobDataStatus);
			}
			threadSleep(ObjectRepository.wait20sec);

		}
		return isJobStatusCompleted;

	}

	private void jobStatusUpdateCheck()
	{
		// boolean currentStatus = false;
		BaseTest.getTest().log(Status.INFO, "**************Jobmaster status check**************");
		switch (jobStatusId)
		{
		case 1:
			BaseTest.getTest().log(Status.INFO, "Jobmaster StatusId is in Queue: " + jobStatusId);
			break;
		case 2:
			BaseTest.getTest().log(Status.FAIL, "Jobmaster StatusId is ERROR: " + jobStatusId);
			break;
		case 3:
			BaseTest.getTest().log(Status.INFO, "Jobmaster StatusId is in IN PROGRESS: " + jobStatusId);
			break;
		case 4:
			BaseTest.getTest().log(Status.INFO, "Jobmaster StatusId is in COMPLETED: " + jobStatusId);
			// currentStatus = true;
			break;
		case 5:
			BaseTest.getTest().log(Status.INFO, "Jobmaster StatusId is in PENDING FOR APPROVAL Status: " + jobStatusId);
			break;
		case 9:
			BaseTest.getTest().log(Status.INFO, "Jobmaster StatusId is in Queue: " + jobStatusId);
			break;
		case 16:
			BaseTest.getTest().log(Status.INFO, "Jobmaster StatusId is in Queue: " + jobStatusId);
			break;
		case 20:
			BaseTest.getTest().log(Status.INFO, "Jobmaster StatusId is in Queue: " + jobStatusId);
			break;
		case 40:
			BaseTest.getTest().log(Status.INFO, "Jobmaster StatusId is in DELETED: " + jobStatusId);
			break;
		case 41:
			BaseTest.getTest().log(Status.INFO, "Jobmaster StatusId is in Queue: " + jobStatusId);
			break;
		case 102:
			BaseTest.getTest().log(Status.INFO, "Jobmaster StatusId is in Queue: " + jobStatusId);
			break;
		case 106:
			BaseTest.getTest().log(Status.INFO, "Jobmaster StatusId is in Queue: " + jobStatusId);
			break;
		default:

			break;
		}
		// return currentStatus;
	}

	private String campJobAndJobMetaDataStatus(String status)
	{
		if (status.equalsIgnoreCase("Pending"))
		{
			return "Pending";
		} else if (status.equalsIgnoreCase("DataExtractionInprogress"))
		{
			return "DataExtractionInprogress";
		} else if (status.equalsIgnoreCase("Ready"))
		{
			return "Ready";
		} else if (status.contains("BlastInprogress"))
		{

		} else if (status.contains("Blasted"))
		{
			// Verify campaignJobData table entry based on jobid

			return "Blasted";
		} else if (status.equalsIgnoreCase("Error"))
		{
			return "Error";
		} else if (status.equalsIgnoreCase("Completed"))
		{
			return "Completed";
		} else if (status.isEmpty())
		{
			return "Table not updated yet";
		} else
		{
			return "Might be Campaign not blasted or Status Of jobmaster still 1";
		}
		return "nothandled";

	}

	public boolean jobAndBlastTablesValidate(int jobType)
	{
		boolean jobmasterstatus = jobStatusCheck(jobType);
		if (jobmasterstatus && jobType == 1)
		{
			blastFileSyncValidate(jobType);
			campaignDataSyncConfig(jobType);
			// rptCampBlastTable("e");

		} else if (jobmasterstatus && jobType == 2)
		{
			blastFileSyncValidate(jobType);
			campaignDataSyncConfig(jobType);
			// rptCampBlastTable("s");
		}
		return jobmasterstatus;
	}

	private String getJobMasterTableStatus(int jobType)
	{
		threadSleep(ObjectRepository.wait20sec);
		List<Map<String, String>> jobStatus = getdbQueryResults(dburl_master + jobdb, masterdb_userName, masterdb_password, qJobStatus(jobType));
		if (jobStatus.isEmpty())
		{
			BaseTest.getTest().fail("JobStatus query returns null");
		}
		Map<String, String> jobStatusRow = jobStatus.get(0);
		jobStatusId = Integer.parseInt(jobStatusRow.get("StatusID"));
		jobStatusUpdateCheck();
		switch (jobStatusId)
		{
		case 1:
			return "Queue";
		case 2:
			return "Error";
		case 3:
			return "InProgress";
		case 4:
			return "Completed";
		case 5:
			return "Pending for Approval";
		case 40:
			return "Delete";
		default:
			return "Status not Handled";
		}
	}

	public void validateJobMasterStatus(String status, int jobType)
	{
		String JobStatus = getJobMasterTableStatus(jobType);
		threadSleep(ObjectRepository.wait30sec);
		if (JobStatus.equalsIgnoreCase(status) || JobStatus.toLowerCase().contains(status.toLowerCase()))
		{
			BaseTest.getTest().log(Status.INFO, "Job Master Table Status is as Expected : " + JobStatus);
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Job Master Table Status is not as Expected : " + JobStatus);
		}
	}

	private void blastFileSyncValidate(int jobType)
	{
		threadSleep(ObjectRepository.wait20sec);
		List<Map<String, String>> jobStatus = getdbQueryResults(dburl_campaign + campdbname, campaigndb_userName, campaigndb_password, qBlastFileSync(jobType));
		for (Map<String, String> blastStatus : jobStatus)
		{
			String blastState = blastStatus.get("JobStatus");
			String transferStatus = blastStatus.get("TransferStatus");
			String audienceCount = blastStatus.get("AudienceCount");
			String audienceSentCount = blastStatus.get("AudienceSentCount");
			if (blastState.equalsIgnoreCase("Completed"))
			{
				BaseTest.getTest().log(Status.INFO, "BlastFileSync JobStatus :" + blastState + " ,TransferStatus :" + transferStatus + ",AudienceCount : " + audienceCount + ", and AudienceSentCount :" + audienceSentCount);
			}
		}
	}

	private void campaignDataSyncConfig(int jobType)
	{
		threadSleep(ObjectRepository.wait20sec);
		List<Map<String, String>> datasync = getdbQueryResults(dburl_master + jobdb, masterdb_userName, masterdb_password, qCampaigndatasyncconfig());
		for (Map<String, String> blastStatus : datasync)
		{
			String tableName = blastStatus.get("TableName");
			String B1 = blastStatus.get("B1");
			String C1 = blastStatus.get("C1");
			String B2 = blastStatus.get("B2");
			BaseTest.getTest().log(Status.INFO, "Table Name :" + tableName + " ,B1 :" + B1 + ",C1 : " + C1 + ", and B2 :" + B2);

		}
	}

	@SuppressWarnings("unused")
	private void rptCampBlastTable(String channel)
	{

		threadSleep(ObjectRepository.wait20sec);
		List<Map<String, String>> rptBlast = null;

		if (channel.equalsIgnoreCase("e"))
		{
			rptBlast = getdbQueryResults(dburl_emailReport + "rpt_e" + tenantId, emailReportdb_userName, emailReportdb_password, qrptCampaignblastEmailTable());
		} else if (channel.equalsIgnoreCase("s"))
		{
			rptBlast = getdbQueryResults(dburl_smsReport + "rpt_s" + tenantId, smsReportdb_userName, smsReportdb_password, qrptCampaignblastSMSTable());
		}
		if (!rptBlast.isEmpty() || rptBlast != null)
		{
			int rptBlastSize = rptBlast.size();
			Map<String, String> rptBlastData = rptBlast.get(0);
			String B1 = rptBlastData.get("B1");
			String C1 = rptBlastData.get("C1");
			String B2 = rptBlastData.get("B2");
			BaseTest.getTest().log(Status.INFO, "rptcampaignblast table blasted Audience count :" + rptBlastSize + " ,B1 :" + B1 + ",C1 : " + C1 + ", and B2 :" + B2);
		} else
		{
			BaseTest.getTest().fail("rptBlast returns null");
		}
	}

	// Search all lists in targetlist and dynamic list
	public Map<String, String> searchTargetList(String val)
	{
		String listName = null;
		Map<String, String> listDetails = null;
		explicitwaitforclick(autolocator(AudienceRepository.audience_target_searchIcon), 30);
		threadSleep(200);
		pageLoaderLogo();
		clickElement(AudienceRepository.audience_target_searchIcon);
		threadSleep(200);
		pageLoaderLogo();
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_FilterlistTypeBy), 10);
		clickElement(AudienceRepository.audience_FilterlistTypeBy);
		selectlistelementsAndProceed(AudienceRepository.audience_FilterlistTypeByList, "List name");
		clickElement(AudienceRepository.audience_target_entersearchvalue);
		threadSleep(200);
		pageLoaderLogo();
		enterValue(AudienceRepository.audience_target_entersearchvalue, val);
		threadSleep(ObjectRepository.wait1sec);
		pageLoaderLogo();
		BaseTest.takeScreenshot();
		threadSleep(300);
		List<WebElement> createddynamiclist = findElements(AudienceRepository.audience_target_entersearchResult);
		boolean searchResult = false;
		int count = 0;
		if (!createddynamiclist.isEmpty())
		{
			for (int j = 0; j < createddynamiclist.size(); j++)
			{
				createddynamiclist = findElements(AudienceRepository.audience_target_entersearchResult);
				WebElement dlsearchlist = createddynamiclist.get(j);
				String searchedResult = dlsearchlist.getText().toLowerCase();
				String inputVal = val.toLowerCase();
				if (searchedResult.equals(inputVal))
				{
					threadSleep(200);
					pageLoaderLogo();
					dlsearchlist.click();
					threadSleep(200);
					pageLoaderLogo();
					BaseTest.getTest().log(Status.INFO, "Search suggesion list shows expected result");
					count = j;
					searchResult = true;
					break;
				} else
				{
					if (createddynamiclist.size() - 1 == j)
					{
						BaseTest.getTest().log(Status.WARNING, inputVal + " : List not shown");
					}
				}
			}
		}
		if (searchResult)
		{
			explicitwaitforclick(autolocator(AudienceRepository.audience_target_searchIcon2), 30);
			clickElement(AudienceRepository.audience_target_searchIcon2);
			threadSleep(200);
			pageLoaderLogo();
			String segmentNamexpath = AudienceRepository.audience_compvalue;
			try
			{
				pageLoaderLogo();
				threadSleep(600);
				try
				{
					mouseHover(segmentNamexpath + "[" + (count + 1) + "]");
//					listName = getStrText(DashboardRepository.allpage_tooltip);
					threadSleep(600);
					listName = driver.findElement(autolocator(DashboardRepository.allpage_tooltip)).getText();
					shortListName = getStrText(AudienceRepository.audience_target_shortlistname);
				} catch (Exception e)
				{
					listName = getStrText(segmentNamexpath + "[" + (count + 1) + "]");
				}

				if (listName.equals(val))
				{
					BaseTest.getTest().log(Status.INFO, "Search results shown expected result");
					javaScriptHighLightwithScrnShot(segmentNamexpath + "[" + (count + 1) + "]");
				} else
				{
					BaseTest.getTest().log(Status.WARNING, "List not shown.");
					BaseTest.takeScreenshot();
				}
				int size = findElements(AudienceRepository.audience_target_SegmentationGridRows).size();
				if (findElements(AudienceRepository.audience_target_SegmentationGridRows).size() > 2)
				{
					BaseTest.takeScreenshot();
					BaseTest.getTest().log(Status.WARNING, "page shown more results/ search not working");
				}
			} catch (Exception e)
			{
				BaseTest.getTest().log(Status.FAIL, "page shown empty list or page not loaded or search not worked");
				BaseTest.takeScreenshot();
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Expected search value not shown in dropdown");
			BaseTest.takeScreenshot();
		}
		if (val.length() > 15)
		{
			listDetails = getSegmentationCountInTargetListingPage(shortListName);
		} else
		{
			listDetails = getSegmentationCountInTargetListingPage(listName);
		}
		return listDetails;
	}

	public boolean waitForListExtraction()
	{
		boolean flag = false;
		for (int i = 0; i < 5; i++)
		{
			try
			{
				turnOffImplicityWait();
				String commuExecuted = getStrText(replacePlaceHolder(AudienceRepository.audience_target_targetlistsegcount, targetListName));
				turnOffImplicityWait();
				commuExecuted = commuExecuted.replaceAll("Seg. audience: ", "").trim();
				int count = Integer.parseInt(commuExecuted);
				if (count > 0)
				{
					flag = true;
					break;
				}
			} catch (Exception e)
			{
			}
			refresh();
			searchTargetList(targetListName);
		}
		return flag;
	}

	public Map<String, String> searchTargetList1(String inputListName)
	{
		String listName = null;
		Map<String, String> listDetails = null;
		explicitwaitforclick(autolocator(AudienceRepository.audience_target_searchIcon), 90);
		clickElement(AudienceRepository.audience_target_searchIcon);
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_FilterlistTypeBy), 90);
		clickElement(AudienceRepository.audience_FilterlistTypeBy);
		selectlistelementsAndProceed(AudienceRepository.audience_FilterlistTypeByList, "List name");
		clickElement(AudienceRepository.audience_target_entersearchvalue);
		threadSleep(ObjectRepository.wait1sec);
		enterValue(AudienceRepository.audience_target_entersearchvalue, inputListName);
		threadSleep(ObjectRepository.wait1sec);
		pageLoaderLogo();
		BaseTest.takeScreenshot();
		List<WebElement> createddynamiclist = findElements(AudienceRepository.audience_target_entersearchResult);
		boolean searchResult = false;
		int listPlace = 1;
		if (!createddynamiclist.isEmpty())
		{
			for (int i = 0; i < createddynamiclist.size(); i++)
			{
				createddynamiclist = findElements(AudienceRepository.audience_target_entersearchResult);
				listName = createddynamiclist.get(i).getText().toLowerCase();
				if (inputListName.toLowerCase().equals(listName))
				{
					searchResult = true;
					break;
				} else
				{
					if (createddynamiclist.size() - 1 == i)
					{
						BaseTest.getTest().log(Status.WARNING, inputListName + " : List not shown");
					}
				}
			}
			if (searchResult)
			{
				explicitwaitforclick(autolocator(AudienceRepository.audience_target_searchIcon2), 30);
				clickElement(AudienceRepository.audience_target_searchIcon2);
				pageLoaderLogo();
				List<WebElement> listsName = findElements(AudienceRepository.audience_compvalue);
				for (int i = 0; i < listsName.size(); i++)
				{
					try
					{
						mouseHover(listsName.get(i));
						listName = driver.findElement(autolocator(DashboardRepository.allpage_tooltip)).getText();
						shortListName = getStrText(AudienceRepository.audience_target_shortlistname);
						listDetails = getSegmentationCountInTargetListingPage(shortListName);
					} catch (Exception e)
					{
						listName = listsName.get(i).getText();
						listDetails = getSegmentationCountInTargetListingPage(listName);
					}
					if (listName.equals(inputListName))
					{
						BaseTest.getTest().log(Status.INFO, "Search results shown expected result");
						javaScriptHighLightwithScrnShot(listsName.get(i));
					} else
					{
						BaseTest.getTest().log(Status.WARNING, "List not shown.");
						BaseTest.takeScreenshot();
					}
				}
				if (findElements(AudienceRepository.audience_target_SegmentationGridRows).size() > 1)
				{
					BaseTest.takeScreenshot();
					BaseTest.getTest().log(Status.FAIL, "page shown more results/ search not working");
				}
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Expected search value not shown in dropdown");
				BaseTest.takeScreenshot();
			}
		}
		return listDetails;
	}

	public Map<String, String> getSegmentationCountInTargetListingPage(String trgtListName)
	{
		String SegmentationCount;
		if (isElementPresent("List Name,xpath,//span[.='" + trgtListName + "']//ancestor::div[contains(@class,'card-bottom')]"))
		{
			try
			{
				SegmentationCount = getStrText("Segmentation Count,xpath,//span[.='" + trgtListName + "']//ancestor::div[contains(@class,'card-bottom')]//span[contains(.,'Seg. audience')]");
			} catch (Exception e)
			{
				try
				{
					SegmentationCount = getStrText("Segmentation Count,xpath,//span[.='" + trgtListName + "']//ancestor::div[contains(@class,'card-bottom')]//span[contains(.,'Tot. audience')]");
				} catch (Exception e2)
				{
					SegmentationCount = getStrText("Segmentation Count,xpath,//span[.='" + trgtListName + "']//ancestor::div[contains(@class,'card-bottom')]//span[contains(.,'extraction')]");
				}
			}

			String linkedComm = getStrText("linked Communication,xpath,//span[.='" + trgtListName + "']//ancestor::div[contains(@class,'card-bottom')]//span[contains(.,'Comm')]");
			String projectedReachRate = getStrText("Projected Reach Rate,xpath,//span[.='" + trgtListName + "']//ancestor::div[contains(@class,'card-bottom')]//span[contains(@class,'rcitn-number')]");
			String createdBy = getStrText("Created By,xpath,//span[.='" + trgtListName + "']//ancestor::div[contains(@class,'card-bottom')]//span[contains(@class,'rctcb-by-name')]").replace(",", "");
			String CreatedDateAndTime = getStrText("Date,xpath,//span[.='" + trgtListName + "']//ancestor::div[contains(@class,'card-bottom')]//span[contains(@class,'rctcb-by-date')]");
			trgtListDetails.put("SegmentationCount", SegmentationCount);
			trgtListDetails.put("LinkedCommunication", linkedComm);
			trgtListDetails.put("ProjectedReachRate", projectedReachRate + "%");
			trgtListDetails.put("Created by", createdBy);
			trgtListDetails.put("Created Date&Time", CreatedDateAndTime);
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "List Name not shown.");
			BaseTest.takeScreenshot();
		}
		return trgtListDetails;
	}

	public void breadCrumbsValidation()
	{
		if (isElementAvailable(AudienceRepository.breadcrumbs))
		{
			List<WebElement> breadcrumbs = findElements(AudienceRepository.breadcrumbs_list);
			String URL = getCurrentUrl();
			for (int i = 0; i < breadcrumbs.size() - 1; i++)
			{
				breadcrumbs = findElements(AudienceRepository.breadcrumbs_list);
				String breadcrumb = breadcrumbs.get(i).getText().toUpperCase();
				javaScriptHighLightwithScrnShot(breadcrumbs.get(i));
				breadcrumbs.get(i).click();
				BaseTest.getTest().log(Status.INFO, "Clicked Breadcrumb -->  " + breadcrumb);
				pageLoaderLogo();
				isDisplayed(AudienceRepository.pageheader);
				String pageHeader = getStrText(AudienceRepository.pageheader).toUpperCase();
				if (pageHeader.contains(breadcrumb))
				{
					javaScriptHighLightElement(AudienceRepository.pageheader);
					BaseTest.getTest().log(Status.INFO, "Page header text contains breadcrumbs <b>" + breadcrumb + "</b> text as Expected");
					if (!breadcrumb.equalsIgnoreCase("Dashboard"))
					{
						String currentUrl = getCurrentUrl().split(".us/")[1].split("/")[i].replaceAll("[^a-zA-Z]", " ");
						if (currentUrl.contains(breadcrumb))
						{
							BaseTest.getTest().log(Status.INFO, "Navigated " + breadcrumb + " URL contains " + breadcrumb + " breadcrumb text as Expected");
						} else
						{
							BaseTest.getTest().log(Status.FAIL, "Navigated " + breadcrumb + " URL doesn't contains " + breadcrumb + " breadcrumb text as Expected");
						}
					}
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Page header text doesn't contains breadcrumbs <b>" + breadcrumb + "</b> text as Expected");
					BaseTest.takeScreenshot();
				}
				getWebURL(URL);
				pageLoaderLogo();
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, " Breadcrumbs are not available in that page");
		}
	}

	// Validate Items Per page common method to all pages
	// Vijay
	public void validateItemPerPages()
	{
		BaseTest.getData().ListType = "Analytics";
		javaScriptScrollIntoView(CommunicationRepository.CommunicationListing_itemperpageheader);
		clickElement(CommunicationRepository.CommunicationListing_itemperpageheader);
		List<WebElement> pages = findElements(CommunicationRepository.CommunicationListing_itemperpagepagestotaldisplay);
		for (int index = 0; index < pages.size(); index++)
		{
			pages = findElements(CommunicationRepository.CommunicationListing_itemperpagepagestotaldisplay);
			threadSleep(ObjectRepository.wait1sec);
			int ItemPerPage = Integer.parseInt(pages.get(index).getText());
			javaScriptHighLightwithScrnShot(pages.get(index));
			pages.get(index).click();
			pageLoaderLogo();
			threadSleep(500);
			int noOfList = findElements(CommunicationRepository.CommunicationListing_pagetableitemview).size();
			BaseTest.getTest().log(Status.INFO, "<b>Toltal No. of list :</b> " + noOfList + ", <b>Item per pages Count : </b> " + noOfList);

			if (ItemPerPage == noOfList)
			{
				BaseTest.getTest().log(Status.INFO, "Item per pages --->  Count of <b> " + ItemPerPage + " </b> validation Completed");
				javaScriptScrollIntoView(CommunicationRepository.CommunicationListing_itemperpageheader);
				clickElement(CommunicationRepository.CommunicationListing_itemperpageheader);
			}
			// If the page has to be contains less than of item per page count
			else if (ItemPerPage > noOfList && !isElementPresent(AnalyticsRepository.analytics_listing_pagination))
			{
				BaseTest.getTest().log(Status.INFO, "Listing page total list count is less than of Item per page");
				javaScriptScrollIntoView(CommunicationRepository.CommunicationListing_itemperpageheader);
				clickElement(CommunicationRepository.CommunicationListing_itemperpageheader);
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Selected Item per page :" + ItemPerPage + ", No.of rows :" + noOfList + " are not As Expected.");
				BaseTest.takeScreenshot();
				break;
			}
		}

		if (BaseTest.getData().ListType.equalsIgnoreCase("Audience list"))
		{
			int audienceList = 0;
			audienceList = audienceList + findElements(",xpath,//table//tr[@class]").size();
			for (int i = 1; i < 10; i++)
			{
				clickElement(CommunicationRepository.CommunicationListing_paginationgotonextpage);
				audienceList = audienceList + findElements("Audience list,xpath,//table//tr[@class]").size();
			}
			boolean nextPageDisable = isElementPresent("Next page disable,xpath,//a[@title='Go to the next page'][@class='k-link k-pager-nav k-disabled']");
			boolean lastPageDisable = isElementPresent("Last page disable,xpath,//a[@title='Go to the last page'][@class='k-link k-pager-nav k-pager-last k-disabled']");
			writeLog(audienceList == 200 && nextPageDisable && lastPageDisable, "Audience grid is contains 200 values as expected.", "Audience grid is not contains 200 values.");
		}
	}

	public void validateItemPerPagesGalleryPage()
	{
		javaScriptScrollIntoView(CommunicationRepository.CommunicationListing_itemperpageheader);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(CommunicationRepository.CommunicationListing_itemperpageheader);
		List<WebElement> pages = findElements(CommunicationRepository.CommunicationListing_itemperpagepagestotaldisplay);
		for (int index = 0; index < pages.size(); index++)
		{
			pages = findElements(CommunicationRepository.CommunicationListing_itemperpagepagestotaldisplay);
			threadSleep(ObjectRepository.wait1sec);
			int ItemPerPage = Integer.parseInt(pages.get(index).getText());
			javaScriptHighLightwithScrnShot(pages.get(index));
			pages.get(index).click();
			pageLoaderLogo();
			int noOfList = findElements("Gallery page,xpath,//div[@class='col-sm-3']").size();
			BaseTest.getTest().log(Status.INFO, "<b>Toltal No. of list :</b> " + noOfList + ", <b>Item per pages Count : </b> " + noOfList);

			if (ItemPerPage == noOfList)
			{
				BaseTest.getTest().log(Status.INFO, "Item per pages --->  Count of <b> " + ItemPerPage + " </b> validation Completed");
				javaScriptScrollIntoView(CommunicationRepository.CommunicationListing_itemperpageheader);
				threadSleep(ObjectRepository.wait3sec);
				clickElement(CommunicationRepository.CommunicationListing_itemperpageheader);
			}
			// If the page has to be contains less than of item per page count
			else if (ItemPerPage > noOfList && !isElementPresent(AnalyticsRepository.analytics_listing_pagination))
			{
				BaseTest.getTest().log(Status.INFO, "Listing page total list count is less than of Item per page");
				javaScriptScrollIntoView(CommunicationRepository.CommunicationListing_itemperpageheader);
				clickElement(CommunicationRepository.CommunicationListing_itemperpageheader);
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Selected Item per page :" + ItemPerPage + ", No.of rows :" + noOfList + " are not As Expected.");
				BaseTest.takeScreenshot();
				break;
			}
		}
	}

	public void validateDisableAndEnableArrow()
	{
		String firstpagevalue = getTextBoxVal(CommunicationRepository.CommunicationListing_paginationgotofirstpage, "class");
		String previouspagevalue = getTextBoxVal(CommunicationRepository.CommunicationListing_paginationgotopreviouspage, "class");
		String lastpagevalue = getTextBoxVal(CommunicationRepository.CommunicationListing_paginationgotolastpage, "class");
		String nextpagevalue = getTextBoxVal(CommunicationRepository.CommunicationListing_paginationgotonextpage, "class");
		if (firstpagevalue.contains("disable") && (previouspagevalue.contains("disable")))
		{
			if (lastpagevalue.contains("disable") && nextpagevalue.contains("disable"))
			{
				BaseTest.getTest().log(Status.INFO, "This is a single page");
				BaseTest.takeScreenshot();
			} else
			{
				javaScriptScrollDown();
				BaseTest.takeScreenshot();
				BaseTest.getTest().log(Status.INFO, "On the first page, the left side and previous arrow are in a disabled state, As expected");
				clickElement(CommunicationRepository.CommunicationListing_paginationgotolastpage);
				pageLoaderLogo();
				String lastattribute1 = getTextBoxVal("Last page link,xpath,//a[@title='Go to the last page']", "class");
				String nextattribute1 = getTextBoxVal("Next page link,xpath,//a[@title='Go to the next page']", "class");

				if (lastattribute1.contains("disable") && nextattribute1.contains("disable"))
				{
					javaScriptScrollDown();
					BaseTest.takeScreenshot();
					BaseTest.getTest().log(Status.INFO, "On the Last page, the right side and next arrow are in a disabled state, As expected");
					clickElement(CommunicationRepository.CommunicationListing_paginationgotofirstpage);
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "On the Last page, the right side and next arrow are in a disabled state, As expected");
				}
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "On the first page, the left side and previous arrow are in a disabled state, As expected");
		}

		int selectedPageNumber = Integer.parseInt(getStrText("Selected page,xpath,//ul[@class='k-pager-numbers']//li//a[@class='k-link k-selected']"));
		int nextPageVal = selectedPageNumber + 1;
		String lastattribute2 = getTextBoxVal("next page link,xpath,//a[@title='Go to the last page']", "class");
		if (!lastattribute2.contains("disable"))
		{
			javaScriptScrollDown();
			clickElement("Next page link,xpath,//a[@title='Go to the next page']");
			pageLoaderLogo();
			int nextPage = Integer.parseInt(getStrText("Selected page,xpath,//ul[@class='k-pager-numbers']//li//a[@class='k-link k-selected']"));
			if (nextPage == nextPageVal)
			{
				BaseTest.getTest().log(Status.INFO, "Next page button - Validation successfull");
				BaseTest.takeScreenshot();
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Page is not go to next page");
				BaseTest.takeScreenshot();
			}
			pageLoaderLogo();
			javaScriptScrollDown();
			clickElement(CommunicationRepository.CommunicationListing_paginationgotopreviouspage);
			int currentPageNumber = Integer.parseInt(getStrText("Selected page,xpath,//ul[@class='k-pager-numbers']//li//a[@class='k-link k-selected']"));
			if (currentPageNumber == selectedPageNumber)
			{
				BaseTest.getTest().log(Status.INFO, "Previous page button - Validation successfull");
				BaseTest.takeScreenshot();
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Page is not go to previous page");
				BaseTest.takeScreenshot();
			}
		}
	}

	public void validatePagniationInputbox()
	{
		javaScriptScrollDown();
		threadSleep(ObjectRepository.wait2sec);
		String firstpagevalue = getTextBoxVal(CommunicationRepository.CommunicationListing_paginationgotofirstpage, "class");
		String previouspagevalue = getTextBoxVal(CommunicationRepository.CommunicationListing_paginationgotopreviouspage, "class");
		String lastpagevalue = getTextBoxVal(CommunicationRepository.CommunicationListing_paginationgotolastpage, "class");
		String nextpagevalue = getTextBoxVal(CommunicationRepository.CommunicationListing_paginationgotonextpage, "class");
		if (firstpagevalue.contains("disable") && (previouspagevalue.contains("disable")))
		{
			BaseTest.getTest().log(Status.INFO, "Page No. 1 ---> First and Previous pagination button has disabled as Expected");
			javaScriptHighLightwithScrnShot(CommunicationRepository.CommunicationListing_paginationgotofirstpage);
			if (lastpagevalue.contains("disable") && nextpagevalue.contains("disable"))
			{
				BaseTest.getTest().log(Status.INFO, "This is a single page");
				BaseTest.takeScreenshot();
			} else
			{
				clickElement(CommunicationRepository.CommunicationListing_paginationgotolastpage);
				threadSleep(ObjectRepository.wait3sec);
				String lastattribute1 = getTextBoxVal(CommunicationRepository.CommunicationListing_paginationgotolastpage, "class");
				String nextattribute1 = getTextBoxVal(CommunicationRepository.CommunicationListing_paginationgotonextpage, "class");
				if (lastattribute1.contains("disable") && nextattribute1.contains("disable"))
				{
					javaScriptScrollDown();
					BaseTest.getTest().log(Status.INFO, "Last Page  ---> Last and Next pagination button has disabled as Expected");
					javaScriptHighLightwithScrnShot(CommunicationRepository.CommunicationListing_paginationgotolastpage);
					clickElement(CommunicationRepository.CommunicationListing_paginationgotofirstpage);
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Last Page  ---> Last and Next pagination button has enabled");
				}
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Page No. 1 ---> First and Previous pagination button has enabled");
		}
	}

//
//	public String getUiBackgroundColour(String type, String pr)
//	{
//		String cssValue = driver.findElement(autolocator(pr)).getCssValue(type);
//		String[] RGBcolor = StringUtils.substringBetween(cssValue, "(", ")").replaceAll("\\s+", "").split(",");
//		int redColorValue = Integer.parseInt(RGBcolor[0]);
//		int greenColorValue = Integer.parseInt(RGBcolor[1]);
//		int blueColorValue = Integer.parseInt(RGBcolor[2]);
//		Color color = new Color(redColorValue, greenColorValue, blueColorValue);
//		String hexcolour = "#" + Integer.toHexString(color.getRGB()).substring(2);
//		return hexcolour;
//	}
	public String getUiBackgroundColour(String type, String pr)
	{
		String cssValue = driver.findElement(autolocator(pr)).getCssValue(type);
		String[] RGBcolor = StringUtils.substringBetween(cssValue, "(", ")").replaceAll("\\s+", "").split(",");
		int redColorValue = Integer.parseInt(RGBcolor[0]);
		int greenColorValue = Integer.parseInt(RGBcolor[1]);
		int blueColorValue = Integer.parseInt(RGBcolor[2]);

		// Create a Color object
		Color color = new Color(redColorValue, greenColorValue, blueColorValue);

		// Convert to hex, ensuring no alpha value is included
		String hexColour = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());

		return hexColour;
	}

	public String rgbToHexColor(String cssValue)
	{
		String[] RGBcolor = cssValue.replace("rgb(", "").replace(" ", "").replace(")", "").split(",");
		int redColorValue = Integer.parseInt(RGBcolor[0]);
		int greenColorValue = Integer.parseInt(RGBcolor[1]);
		int blueColorValue = Integer.parseInt(RGBcolor[2]);
		Color color = new Color(redColorValue, greenColorValue, blueColorValue);
		String hexcolour = "#" + Integer.toHexString(color.getRGB()).substring(2);
		return hexcolour;
	}

// Manimaran
	public boolean uiPageEqualswithInputValue(String txt, String actualText)
	{
		if (txt.equals(actualText))
		{
			BaseTest.getTest().log(Status.INFO, "UI text <b>'" + txt + "'</b> is displayed, As expected.");
			return true;
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "UI text <b>" + txt + "</b> is not displayed, As expected text <b>" + actualText + "</b>");
			BaseTest.takeScreenshot();
		}
		return false;
	}

	public void uiPageEqualswithInputValueNumber(int txt, int actualText)
	{
		if (txt == actualText)
		{
			BaseTest.getTest().log(Status.INFO, "UI Text \"" + txt + "\" is displayed as expected text \"" + actualText + "\"");

		} else
		{
			BaseTest.getTest().log(Status.FAIL, "UI Text \"" + txt + "\" is not displayed as expected text \"" + actualText + "\"");
			BaseTest.takeScreenshot();
		}
	}

	public void elementHighlighter(Object element)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		if (element instanceof String)
		{
			String obj = element.toString();
			element = driver.findElement(autolocator(obj));
		}
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:3px solid red')", element);
		BaseTest.takeScreenshot();
		jsExecutor.executeScript("arguments[0].setAttribute('style','background: 0; display: block;')", element);
	}

	public void javaScriptHighLightwithScrnShot(Object obj)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = null;
		if (obj instanceof String)
		{
			element = findElement(obj.toString());
		} else if (obj instanceof WebElement)
		{
			element = (WebElement) obj;
		}
		String styleAttribute = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red;')", element);
		BaseTest.takeScreenshot();
		jsExecutor.executeScript("arguments[0].setAttribute('style','" + styleAttribute + "')", element);
	}

	public void pw_javaScriptHighLightwithScrnShot(Object obj)
	{
		Locator element = null;
		if (obj instanceof String)
		{
			element = page.locator((String) obj);
		} else if (obj instanceof Locator)
		{
			element = (Locator) obj;
		}
		if (element == null)
		{
			throw new IllegalArgumentException("Invalid element provided for highlighting");
		}
		String styleAttribute = (String) element.evaluate("el => el.getAttribute('style')");
		element.evaluate("el => el.setAttribute('style', 'border: 2px solid red;')");
		BaseTest.pw_takesScreenshot();
		element.evaluate("el => el.setAttribute('style', arguments[0])", styleAttribute);
	}

	public void uiPageEqualswithMultipleInputValue(String pr, String testDatas)
	{
		threadSleep(ObjectRepository.wait2sec);
		List<WebElement> erroemessage = findElements(pr);
		String[] dataSet = testDatas.split(",");
		if (!erroemessage.isEmpty())
		{
			try
			{
				for (int i = 0; i < erroemessage.size(); i++)
				{
					String attribute = erroemessage.get(i).getText().trim();
					String inputValue = dataSet[i].trim();
					if (inputValue.isEmpty() || attribute.isEmpty())
					{
						BaseTest.getTest().log(Status.WARNING, "The UI text or given input value is empty");
					} else if (attribute.equals(inputValue))
					{
						BaseTest.getTest().log(Status.INFO, "The UI text of <b>'" + inputValue + "'</b> has displayed, As Expected.");
					} else
					{
						Actions actions = new Actions(driver);
						actions.scrollToElement(erroemessage.get(i)).perform();
						elementHighlighter(erroemessage.get(i));
						BaseTest.getTest().log(Status.FAIL, "The UI text of <b>" + attribute + "</b> is not equal to its input " + inputValue);
					}
				}
			} catch (Exception e)
			{
				BaseTest.getTest().log(Status.FAIL, "Dropdown field count is mismatched compared to input.");
			}

		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Unable to find the validation message.");
			BaseTest.takeScreenshot();
		}

	}

	public void uiPageEqualsWithMultipleInputValue(String pr, String testDatas)
	{
		threadSleep(ObjectRepository.wait2sec);
		List<WebElement> erroemessage = findElements(pr);
		String[] dataSet = testDatas.split(";");
		if (!erroemessage.isEmpty())
		{
			for (int i = 0; i < erroemessage.size(); i++)
			{
				String attribute = erroemessage.get(i).getText().trim();
				String inputValue = dataSet[i].trim();
				if (inputValue.isEmpty() || attribute.isEmpty())
				{
					BaseTest.getTest().log(Status.WARNING, "The UI text or given input value is empty");
				} else if (attribute.equals(inputValue))
				{
					BaseTest.getTest().log(Status.INFO, "The UI text of <b>'" + inputValue + "'</b> has displayed, As Expected.");
				} else
				{
					Actions actions = new Actions(driver);
					actions.scrollToElement(erroemessage.get(i)).perform();
					elementHighlighter(erroemessage.get(i));
					BaseTest.getTest().log(Status.FAIL, "The UI text of <b>" + attribute + "</b> is not equal to its input " + inputValue);
				}
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Unable to find the validation message.");
			BaseTest.takeScreenshot();
		}

	}

	public List<Map<String, String>> csvFileReader(String CSV_Name)
	{
		List<Map<String, String>> data = new ArrayList<Map<String, String>>();
		threadSleep(ObjectRepository.wait5sec);
		File path = new File(System.getProperty("user.dir") + "/src\\main\\resources\\data\\downloadedFile\\");
		File[] files = path.listFiles();
		for (File file : files)
		{
			String str = file.getName();
			if (file.exists() && str.contains(CSV_Name))
			{
				BaseTest.getTest().log(Status.INFO, "Opened CSV  ---> " + CSV_Name);
				int rowCount = 0;
				try
				{
					BufferedReader reader = new BufferedReader(new FileReader(file));
					String line;

					String[] headers = reader.readLine().split(",");
					while ((line = reader.readLine()) != null)
					{
						Map<String, String> map = new LinkedHashMap<String, String>();
						String[] cell = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
						for (int i = 0; i < headers.length; i++)
						{
							map.put(headers[i], cell[i]);
						}
						data.add(rowCount, map);
						rowCount++;
					}
					reader.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				} finally
				{
					threadSleep(ObjectRepository.wait5sec);
					file.delete();
					BaseTest.getTest().log(Status.INFO, "The downloaded file has been deleted : " + str);
					BaseTest.getTest().log(Status.INFO, "Downloaded CSV File  --->  Total Communications Found in CSV : " + (data.size() + 1));
				}
			} else
			{
				BaseTest.getTest().log(Status.INFO, "File not found :" + CSV_Name);
			}
			System.out.println("********************** CSV FILE - OutPut ********************");
			System.out.println(data);
		}
		return data;
	}

	public boolean getAttributeNameAndValue(String Webelement, String Attribute)
	{
		boolean status = false;
		WebElement domAttribute = driver.findElement(autolocator(Webelement));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		String allAttribute = executor
				.executeScript("var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;", domAttribute).toString();
		String[] splitedAttribute = allAttribute.split(",");
		String[] trim = null;
		Map<String, String> nameAndValue = new HashMap<>();

		for (String attribute : splitedAttribute)
		{
			String name = attribute;
			trim = name.replace("{", "").replace("}", "").trim().split("=");
			if (trim.length == 1)
			{
				nameAndValue.put(trim[0].toString(), null);
			} else
			{
				nameAndValue.put(trim[0].toString(), trim[1].toString());
			}
		}
		if (nameAndValue.containsKey(Attribute))
		{
			status = true;
		}
		return status;
	}

	public PageBase selectDateRange(String testData)
	{
		explicitwaitforclick(autolocator(AudienceRepository.audience_Filter_Menu), 30);
		clickElement(AudienceRepository.audience_Filter_Menu);
		explicitwaitforclick(autolocator(AudienceRepository.audience_FilterMenu_List), 30);
		selectlistelements(AudienceRepository.audience_FilterMenu_List, testData);
		javaScriptPageLoad();
		explicitwaitforclick(autolocator(AudienceRepository.audience_Filter_Menu), 20);
		return this;
	}

	public void mouseHover(Object pr)
	{
		Actions actions = new Actions(driver);
		if (pr instanceof String)
		{
			WebElement obj = driver.findElement(autolocator(pr.toString()));
			actions.moveToElement(obj).build().perform();
		} else
		{
			actions.moveToElement((WebElement) pr).build().perform();
		}
		threadSleep(ObjectRepository.wait1sec);
	}

	// WithoutThread
	public void mouseHoverWT(Object pr)
	{
		Actions actions = new Actions(driver);
		if (pr instanceof String)
		{
			WebElement obj = driver.findElement(autolocator(pr.toString()));
			actions.moveToElement(obj).build().perform();
		} else
		{
			actions.moveToElement((WebElement) pr).build().perform();
		}
	}

	public void mousehoverJavaScript(Object HoverElement)
	{
		WebElement ele;
		String mouseOverScript = "";
		if (HoverElement instanceof WebElement)
		{
			mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
			((JavascriptExecutor) driver).executeScript(mouseOverScript, HoverElement);
		} else if (HoverElement instanceof String)
		{
			String stringEle = HoverElement.toString();
			if (stringEle.contains("$"))
			{
				String[] hover = HoverElement.toString().split("\\$");
				ele = driver.findElement(By.xpath(hover[2]));
			} else
			{
				String[] hover = HoverElement.toString().split(",");
				if (hover.length >= 4)
				{
					String hoverr = hover[2].concat("," + hover[3]);
					ele = driver.findElement(By.xpath(hoverr));
				} else
				{
					ele = driver.findElement(By.xpath(hover[2]));
				}
			}
			mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
			((JavascriptExecutor) driver).executeScript(mouseOverScript, ele);
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Mouse hover action not as expected String or Webelement.Kindly change Mousehover input");
		}
	}

	public PageBase actionScrollToElement(Object pr)
	{
		Actions actions = new Actions(driver);
		if (pr instanceof String)
		{
			WebElement obj = driver.findElement(autolocator(pr.toString()));
			actions.moveToElement(obj).scrollToElement(obj).build().perform();
		} else
		{
			actions.moveToElement((WebElement) pr).scrollToElement((WebElement) pr).build().perform();
		}
		return this;
	}

	public boolean isElementExist(String element)
	{
		try
		{
			driver.findElement(autolocator(element));
			return true;
		} catch (Exception e)
		{
			return false;
		}
	}

	public List<Map<String, String>> getWebTableData(String headers, String rows, String pagination)
	{
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		List<WebElement> Row, Header, tdata;
		int pageCount = 1;
		int rowCount = 0;
		boolean flag = true;
		while (flag)
		{
			Header = findElements(headers);
			Row = findElements(rows);
			if (!Row.isEmpty())
			{
				for (int index = 0; index < Row.size(); index++)
				{
					Row = findElements(rows);
					Map<String, String> map = new LinkedHashMap<>();
					threadSleep(ObjectRepository.wait1sec);
					tdata = Row.get(index).findElements(By.tagName("td"));
					for (int cell = 0; cell < tdata.size(); cell++)
					{
						threadSleep(100);
						tdata = Row.get(index).findElements(By.tagName("td"));
						String headerName = Header.get(cell).getText().trim();
						threadSleep(100);
						String data = tdata.get(cell).getText().trim();
						map.put(headerName, data);
						if (cell != tdata.size() - 1)
						{
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tdata.get(cell + 1));
							threadSleep(100);
						} else
						{
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Header.get(0));
						}
					}
					result.add(rowCount, map);
					rowCount++;
				}
				BaseTest.getTest().log(Status.INFO, "Page No. ---> " + pageCount + ", No. of list found : " + Row.size());
				flag = pageNavigation(pagination);
				pageCount++;
			} else
			{
				BaseTest.getTest().log(Status.WARNING, "No data found");
				BaseTest.takeScreenshot();
				flag = false;
			}
		}
		return result;
	}

	public List<Map<String, String>> conGetWebTableData(String headers, String rows, String pagination)
	{
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		List<WebElement> Row, Header, tdata;
		int pageCount = 1;
		int rowCount = 0;
		boolean flag = true;
		while (flag)
		{
			Header = findElements(headers);
			Row = findElements(rows);
			if (!Row.isEmpty())
			{
				for (int index = 0; index < Row.size(); index++)
				{
					Row = findElements(rows);
					Map<String, String> map = new TreeMap<>();
					threadSleep(ObjectRepository.wait1sec);
					tdata = Row.get(index).findElements(By.tagName("td"));
					for (int cell = 0; cell < tdata.size(); cell++)
					{
						tdata = Row.get(index).findElements(By.tagName("td"));
						if (!Header.get(cell).getText().trim().contains("Group ID"))
						{
							String headerName = Header.get(cell).getText().trim();
							if (headerName.equals("Communication name") || headerName.equals("Subject line"))
							{
								mouseHover(tdata.get(cell));
								threadSleep(50);
								if (isElementPresent(DashboardRepository.allpage_tooltip))
								{
									String data = getStrText(DashboardRepository.allpage_tooltip);
									map.put(headerName.replaceAll("\r", ""), data.replaceAll("\"", "").replaceAll("\r", ""));
								} else
								{
									String data = tdata.get(cell).getText().trim();
									map.put(headerName, data.replaceAll("\"", "").replaceAll("\r", ""));
								}
							} else if (headerName.equals("Communication Docket"))
							{
								String data = tdata.get(cell).getText().trim();
								data = data.equals("No") ? "" : data;
								map.put(headerName, data);
							} else
							{
								String data = tdata.get(cell).getText().trim();
								map.put(headerName, data);
							}
						}
						if (cell != tdata.size() - 1)
						{
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tdata.get(cell + 1));
							threadSleep(100);
						} else
						{
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Header.get(0));
						}
					}
					result.add(rowCount, map);
					rowCount++;
				}
				BaseTest.getTest().log(Status.INFO, "Page No. ---> " + pageCount + ", No. of list found : " + Row.size());
				flag = pageNavigation(pagination);
				pageCount++;
			} else
			{
				BaseTest.getTest().log(Status.WARNING, "No data found");
				BaseTest.takeScreenshot();
				flag = false;
			}
		}
		return result;
	}

	public void clearField(Object pr)
	{
		List<WebElement> li_ele = null;
		if (pr instanceof String)
		{
			String element = String.valueOf(pr);
			li_ele = driver.findElements(autolocator(element));
		} else if (pr instanceof WebElement)
		{
			WebElement eles = (WebElement) pr;
			li_ele = Collections.singletonList(eles);
		} else
		{
			li_ele = (List<WebElement>) pr;
		}
		for (WebElement ele : li_ele)
		{
			if (ele != null)
			{
				while (true)
				{
					String field = ele.getAttribute("value");
					if (!field.isEmpty())
					{
						try
						{
							ele.click();
							ele.sendKeys(Keys.BACK_SPACE);
						} catch (Exception e)
						{
							BaseTest.getTest().log(Status.INFO, "Unable to clear text");
							break;
						}
					} else
					{
						break;
					}
				}
				String placeholder = ele.getAttribute("placeholder");
				BaseTest.getTest().log(Status.INFO, placeholder + " Field text has been cleared");

			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Uanble to locate Webelement");
			}
		}
	}

	public void removeText(String pr)
	{
		WebElement obj = findElement(pr);
		Actions action = new Actions(driver);
		action.click(obj).doubleClick(obj).sendKeys(Keys.BACK_SPACE).build().perform();
	}

	public static String calendarSchedduleDate(int addDays, String format)
	{
		SimpleDateFormat sd = new SimpleDateFormat(format);
		sd.setTimeZone(TimeZone.getTimeZone("IST"));// 2020-08-23
		String dt = sd.format(new Date());
		Calendar c = Calendar.getInstance();
		try
		{
			c.setTime(sd.parse(dt));
		} catch (ParseException e)
		{
			System.out.println(e.getMessage());
		}
		c.add(Calendar.DATE, addDays);
		dt = sd.format(c.getTime());
		return dt;
	}

	public boolean pageNavigation(String str)
	{
		boolean flag = true;
		while (flag)
		{
			List<WebElement> nextPageButton = findElements(str);
			if (!nextPageButton.isEmpty())
			{
				explicitwaitforclick(autolocator(str), 20);
				nextPageButton.get(0).click();
				pageLoaderLogo();
				threadSleep(ObjectRepository.wait3sec);
				if (isElementPresent("No records available,xpath,//td[text()='No records available']"))
				{
					flag = false;
					BaseTest.getTest().log(Status.FAIL, "Page shown 'No records available'");
				}
				break;
			} else
			{
				BaseTest.getTest().log(Status.INFO, "There is no pagination available");
				BaseTest.takeScreenshot();
				flag = false;
			}
			pageLoaderLogo();
		}
		return flag;
	}

	public boolean urlCheck(String URL)
	{
		threadSleep(ObjectRepository.wait5sec);
		boolean status = false;
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.equals(URL))
		{
			BaseTest.getTest().log(Status.INFO, "Page URL is displaying as expected.");
			BaseTest.takeScreenshot();
			status = true;
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Page URL is not displaying as expected.");
			BaseTest.takeScreenshot();
		}
		return status;
	}

	public boolean isElementAvailable(String element)
	{
		try
		{
			driver.findElement(autolocator(element)).isDisplayed();
			BaseTest.getTest().info("Element displayed : <b>" + BaseTest.logName.get() + "</b>, As Expected.");
			return true;
		} catch (Exception e)
		{
			BaseTest.getTest().fail("Element isn't displayed : <b>" + BaseTest.logName.get() + "</b>");
			BaseTest.takeScreenshot();
			return false;
		}
	}

	public PageBase dateRangeFilter(String ListTimeStamp)
	{
		pageLoaderLogo();
		String[] input = BaseTest.getData().DateRangeFilter.split(",");
		for (String testdata : input)
		{
			javaScriptScrolltoTop();
			explicitwaitforclick(autolocator(AudienceRepository.audience_Filter_Menu), 30);
			clickElement(AudienceRepository.audience_Filter_Menu);
			explicitwaitforclick(autolocator(AudienceRepository.audience_FilterMenu_List), 30);
			if (selectlistelementsAndProceed(AudienceRepository.audience_FilterMenu_List, testdata))
			{
				if (testdata.contains("Custom range"))
				{
					customRangeCalender(BaseTest.getData().EndDate);
					customRangeCalender(BaseTest.getData().StartDate);
					threadSleep(ObjectRepository.wait1sec);
					clickElement(AudienceRepository.audience_target_customfilterclickapply);
				}
				pageLoaderLogo();
				String filterdate = getStrText(AudienceRepository.audience_Filter_Menu);
				String[] splitfilterdate = filterdate.split(" - ");
				BaseTest.getTest().log(Status.INFO, "Filtered Date Between  ---> " + filterdate);
				try
				{
					explicitwaitforvisibility(autolocator(ListTimeStamp), 30);
					javaScriptHighLightwithScrnShot(AudienceRepository.audience_Filter_Menu);
					String start = splitfilterdate[0].trim();
					String end = splitfilterdate[1].trim();

					int page = 1;
					int validatedList = 0;
					int pageCount = Integer.parseInt(BaseTest.getData().PaginationCount);
					List<WebElement> timeStamp = findElements(ListTimeStamp);
					boolean flag = true;
					if (!timeStamp.isEmpty())
					{
						while (flag)
						{
							boolean var = true;
							try
							{
								timeStamp = findElements(ListTimeStamp);
								for (int i = 0; i < timeStamp.size(); i++)
								{
									timeStamp = findElements(ListTimeStamp);
									if (timeStamp.get(i).isDisplayed())
									{
										Date startDate = convertCalendarToDate(start, "MMM dd,yyyy");
										Date endDate = convertCalendarToDate(end, "MMM dd,yyyy");
										Date listDate = dateFormat(timeStamp.get(i).getText().trim());

										if ((listDate.equals(startDate) || listDate.after(startDate)) && (listDate.equals(endDate)) || listDate.before(endDate))
										{
											javaScriptHighLightElement(timeStamp.get(i));
											validatedList++;
										} else
										{
											BaseTest.getTest().log(Status.FAIL, "List does not fall under given input date Range");
											javaScriptHighLightElement(timeStamp.get(i));
											var = false;
										}
									}
								}
								if (var)
								{
									BaseTest.getTest().log(Status.INFO, "<b>" + testdata + "</b> Created date --->  Verified for filtered lists as expected in Page no: " + page);
									BaseTest.getTest().log(Status.INFO, "Total validated list : " + validatedList);
								}
								if (page <= pageCount)
								{
									javaScriptScrollDown();
									flag = pageNavigation(AnalyticsRepository.analytics_listing_pagination);
									javaScriptScrolltoTop();
									page++;
								} else
								{
									javaScriptScrollDown();
									clickElement(AnalyticsRepository.analytics_listing_lastPage);
									timeStamp = findElements(ListTimeStamp);
									for (int i = 0; i < timeStamp.size(); i++)
									{
										timeStamp = findElements(ListTimeStamp);
										if (timeStamp.get(i).isDisplayed())
										{
											Date startDate = convertCalendarToDate(start, "MMM dd,yyyy");
											Date endDate = convertCalendarToDate(end, "MMM dd,yyyy");
											Date listDate = dateFormat(timeStamp.get(i).getText().trim());

											if ((listDate.equals(startDate) || listDate.after(startDate)) && (listDate.equals(endDate)) || listDate.before(endDate))
											{
												javaScriptHighLightElement(timeStamp.get(i));
											} else
											{
												BaseTest.getTest().log(Status.FAIL, "List does not fall under given input date Range");
												javaScriptHighLightElement(timeStamp.get(i));
												var = false;
											}
										}
									}
									BaseTest.takeScreenshot();
									break;
								}
							} catch (Exception e)
							{
								e.printStackTrace();
								if (isElementPresent(AnalyticsRepository.analytics_listing_nodata))
								{
									BaseTest.getTest().log(Status.WARNING, "No Data Found");
									BaseTest.takeScreenshot();
								}
								break;
							}
						}
					} else
					{
						BaseTest.getTest().log(Status.INFO, "No records to display");
						BaseTest.takeScreenshot();
					}
				} catch (Exception e)
				{
					e.printStackTrace();
					if (isElementPresent(AnalyticsRepository.analytics_listing_nodata))
					{
						BaseTest.getTest().log(Status.WARNING, "No Data Found");

						BaseTest.takeScreenshot();
					}
				}
			} else
			{
				BaseTest.getTest().log(Status.FAIL, testdata + " ---> option is not available");
			}

		}
		return this;
	}

	private static Date dateFormat(String value) throws ParseException
	{
		String data = null;
		switch (BaseTest.getData().ListType)
		{
		case "List view":
			data = value.split("On:")[1].split("\\R")[0].trim();
			return convertCalendarToDate(data, "EEE, MMM dd, yyyy");
		case "Grid view":
			data = value.split("On:")[1].trim();
			return convertCalendarToDate(data, "dd, MMM yyyy");
		case "Dynamic list":
			data = value.split("On:")[1].split("\\R")[0].trim().substring(0, 17);
			return convertCalendarToDate(data, "EEE, dd MMM, yyyy");
		case "Notification details":
			String[] data1 = value.split(",");
			data = data1[0] + "," + data1[1] + data1[2].substring(0, 5);
			return convertCalendarToDate(value, "EEE, dd MMM, yyyy");
		case "communicationListing":
			data = value.split("on:")[1].trim();
			return convertCalendarToDate(data, "EEE, MMM dd, yyyy");
		default:
			return convertCalendarToDate(value, "EEE, MMM dd, yyyy");
		}
	}

	// @param dateFormat --> Enter required format of String date
	public static Date convertCalendarToDate(String txt, String dateFormat)
	{
		try
		{
			DateFormat sourceFormat = new SimpleDateFormat(dateFormat, Locale.US);
			DateFormat targetFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date date = sourceFormat.parse(txt);
			String formattedDate = targetFormat.format(date);
			return targetFormat.parse(formattedDate);
		} catch (ParseException e)
		{
			e.printStackTrace();;
		}
		return null;
	}

	public void customRangeCalender(int testData, String table)
	{
		String uiDate;
		String[] a = calendarDate(testData).replaceAll(" ", ",").split(",");
		String Day = a[0].toString().trim();
		String month = a[1].toString().substring(0, 3).trim();
		String year = a[2].toString().trim();

		clickElement(DashboardRepository.customRange_StartmonthAndYear);
		clickElement(DashboardRepository.customRange_StartmonthAndYear);
		selectlistelementsAndProceed(DashboardRepository.customRange_monthAndYearList, year);
		selectlistelementsAndProceed(DashboardRepository.customRange_monthAndYearList, month);
		selectlistelementsAndProceed(DashboardRepository.customRange_monthAndYearList, Day);
		if (table.toLowerCase().contains("lefttable"))
		{
			uiDate = getTextBoxVal("Ui Date,xpath,(//input[@role='textbox'])[1]", "value");
		} else
		{
			uiDate = getTextBoxVal("Ui Date,xpath,(//input[@role='textbox'])[2]", "value");
		}
	}

	public void selectCustomRange(int startDate, int endDate)
	{
		clickElement(DashboardRepository.datefilter);
		clickElement(DashboardRepository.datefilter_customrange);
		customRangeCalender(startDate, "lefttable");
		customRangeCalender(endDate, "righttable");
		clickElement(DashboardRepository.apply_button);
		pageLoaderLogo();
	}

	public boolean customRangeCalender(String pickDate)
	{
		String[] a = calendarDate(0).replaceAll(" ", ",").split(",");
		String Day = a[0].toString().trim();
		String month = a[1].toString().substring(0, 3).trim();
		String year = a[2].toString().trim();
		String yearLocator = "Year,xpath,//td[@title='" + year + "']";
		String monthLocator = "Month,xpath,//td[@title='" + year + " " + month + "']";
		clickElement("Calendar title,xpath,//span[@class='k-button-text']");
		clickElement("Calendar Year title,xpath,//span[@class='k-button-text']");
		boolean val = false;
		if (!getTextBoxVal(yearLocator, "class").contains("disable") && selectlistelementsAndProceed(yearLocator, year) && !getTextBoxVal(monthLocator, "class").contains("disable") && selectlistelementsAndProceed(monthLocator, month))
		{
			WebElement table = driver.findElement(autolocator("calendar table,xpath,(//*[@class='k-calendar-tbody'])[1]"));
			List<WebElement> tableRow = table.findElements(By.tagName("tr"));
			for (WebElement ele : tableRow)
			{
				List<WebElement> tableColumn = ele.findElements(By.tagName("td"));
				for (WebElement cell : tableColumn)
				{
					String Uidate = cell.getText().trim();
					if (Uidate.equals(Day))
					{
						String value = cell.getAttribute("class").trim();
						if (!value.contains("disabled"))
						{
							cell.click();
							val = true;
							break;
						} else
						{
							BaseTest.getTest().log(Status.INFO, "Selected day has disabled mode");
							BaseTest.takeScreenshot();
							return false;
						}
					}
				}
				if (val)
				{
					BaseTest.getTest().log(Status.INFO, "clicked date is ---> " + calendarDate(Integer.parseInt(pickDate)));
					break;
				}
			}
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Selected date has disabled mode");
			BaseTest.takeScreenshot();
		}
		return val;
	}

	public void toolTipValidationKnownText(String element, String text)
	{
		mouseHover(element);
		String toolTipText = getStrText(DashboardRepository.allpage_tooltip);
		if (toolTipText.equals(text))
		{
			BaseTest.getTest().log(Status.INFO, text + " tool tip is validated successfully");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, text + " tool tip is not shown as expected.");
			BaseTest.takeScreenshot();
		}
	}

	public void toolTipValidationprefernces(String element, String text)
	{
		mouseHover(element);
		String toolTipText = getStrText(DashboardRepository.allpage_tooltip);
		if (toolTipText.equals(text))
		{
			BaseTest.getTest().log(Status.INFO, text + " tool tip is validated successfully");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.WARNING, text + " tool tip is not shown as expected.");
			BaseTest.takeScreenshot();
		}
	}

	public void tooltipTextWithInput(String pr, String text)
	{
		mouseHover(pr);
		String tooltipText = getStrText(DashboardRepository.allpage_tooltip);
		if (tooltipText.equals(text))
		{
			BaseTest.getTest().log(Status.INFO, "'<b> " + text + " </b>' tooltip text is equal to expected tooltip text '<b> " + tooltipText + "</b> '");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "'<b> " + text + " </b>' tooltip text is not equal to expected tooltip text '<b> " + tooltipText + "</b> '");
			BaseTest.takeScreenshot();
		}
	}

	public void toolTipValidationRandomText(String element, String functionName)
	{
		mouseHover(element);
		if (isDisplayed(DashboardRepository.allpage_tooltip))
		{
			BaseTest.getTest().log(Status.INFO, functionName + " tool tip is validated successfully");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, functionName + " tool tip is not shown as expected.");
			BaseTest.takeScreenshot();
		}
	}

	public boolean multifieldisEmpty(String pr)
	{
		boolean val = false;
		List<WebElement> findElements = findElements(pr);
		for (WebElement webElement : findElements)
		{
			String text = null;

			try
			{
				text = webElement.getText();
			} catch (Exception e)
			{
				text = webElement.getAttribute("value");
			}

			if (text != null && text.isBlank() && text.isEmpty())
			{
				val = true;
				BaseTest.getTest().log(Status.INFO, "All Fields are empty");
			} else
			{
				val = false;
				BaseTest.getTest().log(Status.FAIL, "Some Field are not empty");
				BaseTest.takeScreenshot();
			}

		}
		return val;
	}

	public void verifyBrokenImage(String pr)
	{
		WebElement imageElement = driver.findElement(By.xpath(pr));
		long naturalWidth = (long) ((JavascriptExecutor) driver).executeScript("return arguments[0].naturalWidth;", imageElement);
		long naturalHeight = (long) ((JavascriptExecutor) driver).executeScript("return arguments[0].naturalHeight;", imageElement);

		if (naturalWidth == 0 || naturalHeight == 0)
		{
			BaseTest.getTest().log(Status.FAIL, "The image is broken or not loaded.");
		} else
		{
			BaseTest.getTest().log(Status.INFO, "The image is loading correctly.");
		}
	}

	/**
	 * @author Ajithkumar S
	 * @param qrCodePath
	 * @return String decoded QR Code
	 */
	public String scanQRCode(String qrCodePath)
	{
		String qrCode = "";
		try
		{
			BufferedImage image = ImageIO.read(new URL(qrCodePath));
			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
			Result result = new MultiFormatReader().decode(binaryBitmap);
			qrCode = result.getText();
		} catch (Exception exception)
		{
			exception.printStackTrace();
			BaseTest.getTest().log(Status.WARNING, " While Scanning the QR Code Exception occured. " + exception.getMessage());
		}
		return qrCode;
	}

	public List<Map<String, String>> dataFileReader(String path)
	{
		List<Map<String, String>> data = new ArrayList<>();
		File csvFile = new File(path);
		if (csvFile.exists())
		{
			int rowCount = 0;
			try
			{
				BufferedReader reader = new BufferedReader(new FileReader(csvFile));
				String line;

				String[] headers = reader.readLine().split(",");
				while ((line = reader.readLine()) != null)
				{
					Map<String, String> map = new LinkedHashMap<>();
					String[] cell = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
					for (int i = 0; i < headers.length; i++)
					{
						map.put(headers[i], cell[i]);
					}
					data.add(rowCount, map);
					rowCount++;
				}
				reader.close();
			} catch (IOException e)
			{
				e.printStackTrace();
				BaseTest.getTest().log(Status.WARNING, "Exception Occured while reading File " + e);
			}
		} else
		{
			BaseTest.getTest().log(Status.INFO, "File not found");
		}
		System.out.println(data);
		return data;
	}

	// Delete All Cache and Cookies
	public void deleteAllCookies()
	{
		driver.manage().deleteAllCookies();
	}

	public void robotClassScrenShot(String path)
	{

		String timeStamp = new SimpleDateFormat("yyMMdd_HHmmssSSS").format(new Date());
		String imgpath = BaseTest.curr_Dir + "/src/test/resources/ExtentReports/ScreenShots/" + timeStamp + ".png";
		try
		{
			Desktop.getDesktop().browse(new File(path).toURI());
			threadSleep(ObjectRepository.wait5sec);

			Robot robot = new Robot();
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage image = robot.createScreenCapture(screenRect);
			ImageIO.write(image, "PNG", new File(imgpath));
			BaseTest.getTest().log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(imgpath).build());

			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_ALT);
			robot.keyRelease(KeyEvent.VK_F4);
			threadSleep(ObjectRepository.wait5sec);

		} catch (Exception e)
		{
			BaseTest.getTest().log(Status.WARNING, "While take screenShot Exception Occured, " + e);
		}
	}

	public static String replacePlaceHolder(String locator, String placeHolder)
	{
		return locator.replace("PLACE_HOLDER", placeHolder);
	}

	public static String replacePlaceHolder(String locator, String placeHolder, String placeHolder1)
	{
		return locator.replace("PLACE_HOLDER", placeHolder).replace("TEMP", placeHolder1);
	}

	public static String getLoginURL()
	{
		String web_url = System.getProperty("Environment").toUpperCase() + "_" + System.getProperty("ReleaseVersion");
		return System.getProperty(web_url);
	}

	// Get Platform Environment
	public static String getEnvironment()
	{
		String environment = BaseTest.xmlEnvironment.toUpperCase();
		String loginURL = getLoginURL().substring(8).toUpperCase();
		if (loginURL.startsWith(environment))
		{
			return environment;
		}
		return environment;
	}

	// get System and Browser Info
	public static Capabilities getCapabilities()
	{
		Capabilities capabilities = ((RemoteWebDriver) BaseTest.getWebDriver()).getCapabilities();
		String platform = capabilities.getPlatformName().name().toUpperCase();
		String browser = capabilities.getBrowserName().toUpperCase();
		return ((RemoteWebDriver) BaseTest.getWebDriver()).getCapabilities();
	}

	public static void getDeviceSpecs()
	{
		Map<String, String> deviceInfo = new LinkedHashMap<>();

		String platform = getCapabilities().getPlatformName().name().toUpperCase();
		String browser = getCapabilities().getBrowserName().toUpperCase();
		BaseTest.getTest().info(MarkupHelper.createLabel("<b> DEVICE SPECIFICATIONS </b>", ExtentColor.INDIGO));
		BaseTest.getTest().assignDevice(platform).assignCategory(browser);
		BaseTest.getTest().log(Status.INFO, "The Device Specifications are listed below,");
		deviceInfo.put("Platform / OS", platform);
		deviceInfo.put("Browser", browser);
		deviceInfo.put("Browser version", getCapabilities().getBrowserVersion());
		deviceInfo.put("Environment", getEnvironment());
		ExtentManager.customReport(deviceInfo);
	}

	/**
	 * This method used for upload files in Remote Machine, LocalFileDetector is set and file send it to the remote machine
	 * 
	 * @param path of file
	 * @return path
	 */

	public static String detectFilePath(String path)
	{
		path = getNormalizedPath(path);
		if (BaseTest.isGrid)
		{
			((RemoteWebDriver) BaseTest.getWebDriver()).setFileDetector(new LocalFileDetector());
			return path;
		}
		return path;
	}

	public ExtentTest createTestScenario(String scenario)
	{
		return BaseTest.createNode("<b>" + scenario.toUpperCase() + "</b>");
	}

	public ExtentTest createTestID(String scenarioID)
	{
		return BaseTest.createTestID("<b>" + scenarioID.toUpperCase() + "</b>");
	}

	public void fluentWait(long maxDurations, String locator)
	{
		FluentWait<WebDriver> wait = null;
		try
		{
			wait = new FluentWait<>(BaseTest.getWebDriver());
			wait.withTimeout(Duration.ofSeconds(maxDurations)).pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.presenceOfElementLocated(autolocator(locator)));

		} catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Fluent Wait Execption handled by catch block " + e);
		}

	}

	public void breadcrumbTextCheck(String breadcrumbinputs)
	{
		String[] breadcrumbTextinput = breadcrumbinputs.split(",");
		int activeBreadcrumb = breadcrumbTextinput.length - 1;
		explicitwaitforvisibility(autolocator(DashboardRepository.breadcrumbs), 30);
		List<WebElement> breadcrumbs = findElements(DashboardRepository.breadcrumbs);
		for (int breadcrumbText = 1; breadcrumbText < breadcrumbs.size(); breadcrumbText++)
		{
			String uiBreadcrumbText = breadcrumbs.get(breadcrumbText).getText();
			uiPageEqualswithInputValue(uiBreadcrumbText, breadcrumbTextinput[breadcrumbText - 1]);
		}
		String status = getTextBoxVal("ActiveBreadcrumb,xpath,//ul[@class='breadcrumb']//li[.='" + breadcrumbTextinput[activeBreadcrumb] + "']", "class");
		uiPageEqualswithInputValue(status, "active");
	}

	public void placeholderValueCheck(String locator, String placeHolderText)
	{
		String uiPlaceholderText = getStrText(locator);
		if (uiPlaceholderText.equals(placeHolderText))
		{
			BaseTest.getTest().log(Status.INFO, "UI Placeholder Text \"<b>" + uiPlaceholderText + "</b>\" is displayed as expected Input Placeholder text \"<b>" + placeHolderText + "</b>\"");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "UI Placeholder Text \"<b>" + uiPlaceholderText + "</b>\" is displayed not as expected Input Placeholder text \"<b>" + placeHolderText + "</b>\"");
		}
	}

	public void clickOk()
	{
		explicitwaitforclick(autolocator(DashboardRepository.ok_button), 30);
		clickElement(DashboardRepository.ok_button);
	}

	public static RequestSpecification initializeApi()
	{
		reqspec = RestAssured.given().relaxedHTTPSValidation().log().everything();
		BaseTest.getTest().log(Status.INFO, "API Initialized");
		return reqspec;
	}

	public static void addheader(String key, String value)
	{
		reqspec.header(key, value);
		BaseTest.getTest().log(Status.INFO, "Header added -> " + "( " + key + " , " + value + " )");
	}

	public void queryparam(String key, String value)
	{
		reqspec = reqspec.queryParam(key, value);
	}

	public void pathparam(String key, String value)
	{
		reqspec = reqspec.pathParam(key, value);
	}

	public static void addBody(String body)
	{
		reqspec = reqspec.body(body);
	}

	public void addbodyfile(String file) throws IOException
	{
		String filePath = BaseTest.curr_Dir + "\\src\\main\\resources\\data\\Json\\" + file + ".json";
		String jsonContent = new String(Files.readAllBytes(Paths.get(filePath)));
		reqspec.body(jsonContent);
	}

	public static Response requesttype(String reqType, String endpoint)
	{
		BaseTest.getTest().log(Status.INFO, "Endpoint Url is -> " + endpoint);
		BaseTest.getTest().log(Status.INFO, "Request Type is -> " + reqType);
		switch (reqType)
		{
		case "GET":
			response = reqspec.get(endpoint);
			break;
		case "POST":
			response = reqspec.post(endpoint);
			break;
		case "PUT":
			response = reqspec.put(endpoint);
			break;
		case "DELETE":
			response = reqspec.delete(endpoint);
			break;
		default:
			break;
		}

		return response;
	}

	public static String getstatuscode(Response response)
	{
		String statusCode = response.getStatusLine();
		BaseTest.getTest().log(Status.INFO, "Status code -> " + statusCode);
		return statusCode;
	}

	public void getResponseTime(Response response)
	{
		long time = response.getTime();
		BaseTest.getTest().log(Status.INFO, "Response Time -> " + time);
	}

	public ResponseBody getbody(Response response)
	{
		ResponseBody body = response.getBody();
		return body;
	}

	public String getbodyAsString(Response response)
	{
		String asString = getbody(response).asString();
		return asString;
	}

	public String getBodyAsprettyString(Response response)
	{
		String asPrettyString = getbody(response).asPrettyString();
		BaseTest.getTest().log(Status.INFO, MarkupHelper.createCodeBlock(asPrettyString, CodeLanguage.JSON));
		return asPrettyString;
	}

	public void setStringJsonValue(String jsonPath, String key, String value) throws org.json.simple.parser.ParseException, ParseException
	{
		String filePath = BaseTest.curr_Dir + ("/src/main/resources/data/Json/" + jsonPath + ".json");
		try
		{
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(filePath));
			JSONObject jsonObject = (JSONObject) obj;
			jsonObject.put(key, value);
			try (FileWriter fileWriter = new FileWriter(filePath))
			{
				fileWriter.write(jsonObject.toJSONString());
			}
			BaseTest.getTest().log(Status.INFO, key + " value is replaced to " + value + ".");
		} catch (IOException e)
		{
			BaseTest.getTest().log(Status.FAIL, "key is not replace in json.");
		}
	}

	public static String getSpecificStringOutput(String response, String key)
	{
		JsonPath js = new JsonPath(response);
		Object object = js.get(key);
		String value = (String) object;
		return value;
	}

	public static List<Object> getJsonArrayList(String response, String key)
	{
		return new JsonPath(response).getList(key);
	}

	public static RequestSpecification addbody(Object body)
	{
		reqspec = reqspec.body(body);
		BaseTest.getTest().log(Status.INFO, "Request Body added.");
		return reqspec;
	}

	/**
	 * Replaces both forward slashes and backslashes in the given path replace with the platform-specific file separator.
	 *
	 * @param pathString Input path
	 * @return Normalized path string with platform-specific file separator.
	 */
	public static String getNormalizedPath(String pathString)
	{
		return pathString.replace("/", File.separator).replace("\\", File.separator);
	}

	public void enterMultipleValues(String pr, String[] values)
	{
		for (int i = 0; i < values.length; i++)
		{
			enterValue(pr, values[i]);
			Actions action = new Actions(BaseTest.getWebDriver());
			action.sendKeys(Keys.TAB).build().perform();
		}
	}

	public void writeLog(boolean expression, String passLog, String failLog)
	{
		if (expression)
		{
			BaseTest.getTest().log(Status.INFO, passLog);
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, failLog);
			BaseTest.takeScreenshot();
		}
	}

	public void pw_writeLog(boolean expression, String passLog, String failLog)
	{
		if (expression)
		{
			BaseTest.getTest().log(Status.INFO, passLog);
			BaseTest.pw_takesScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, failLog);
			BaseTest.pw_takesScreenshot();
		}
	}

	public void hoverOne(WebElement element)
	{
//		WebElement element = driver.findElement(By.cssSelector("your_css_selector_here"));
		((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('mouseover'))", element);
	}

	public void waitForElementVisible(String locator)
	{
		boolean flag = false;
		for (int j = 0; j <= 12; j++)
		{
			try
			{
				driver.navigate().refresh();
				explicitwaitforvisibility(autolocator(locator), 1);
				flag = true;
				break;
			} catch (Exception e)
			{
				System.out.println("Page is waiting for element to be reflect.");
			}
		}
		if (!flag)
		{
			BaseTest.getTest().log(Status.FAIL, "element is not available.");
			BaseTest.takeScreenshot();
		}
	}

	public void brokenLinks() throws MalformedURLException, IOException
	{
		List<WebElement> aTag = driver.findElements(By.tagName("a"));
		for (WebElement a : aTag)
		{
			String url = a.getAttribute("href");
			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			con.connect();
			int responseCode = con.getResponseCode();
			if (responseCode >= 400)
			{
				System.out.println("Broken link " + url + " -> " + responseCode);
			} else
			{
				System.out.println("Valid link " + url + " -> " + responseCode);
			}
		}
	}

	public List<Map<String, String>> getWebTable()
	{
		List<Map<String, String>> list = new LinkedList<>();
		WebElement table = findElement("Table Loc,tag,table");
		List<WebElement> headers = table.findElements(By.tagName("th"));
		List<WebElement> rows = table.findElements(By.xpath("//tbody//tr"));

		for (WebElement row : rows)
		{
			Map<String, String> map = new LinkedHashMap<>();
			List<WebElement> datas = row.findElements(By.tagName("td"));

			int headerSize = headers.size();
			int dataSize = datas.size();
			int missingDataCount = headerSize - dataSize;

			for (int i = 0; i < headerSize; i++)
			{
				String head = headers.get(i).getText();
				if (i < missingDataCount)
				{
					map.put(head, "");
				} else
				{
					String dataValue = datas.get(i - missingDataCount).getText();
					map.put(head, dataValue);
				}
			}
			list.add(map);
		}
		BaseTest.getTest().log(Status.INFO, list.toString());
		ExtentManager.customReport(list);
		return list;
	}

	public List<Map<String, String>> invalidAudienceTable()
	{
		List<Map<String, String>> list = new LinkedList<>();
		WebElement table = driver.findElement(autolocator(AudienceRepository.audience_invalidAudience_table));
		List<WebElement> headers = table.findElements(By.tagName("th"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for (int j = 1; j < rows.size(); j++)
		{
			Map<String, String> map = new LinkedHashMap<>();
			List<WebElement> datas = rows.get(j).findElements(By.tagName("td"));
			int headerSize = headers.size();
			int dataSize = datas.size();
			int missingDataCount = headerSize - dataSize;

			for (int i = 0; i < headerSize; i++)
			{
				String head = headers.get(i).getText();
				if (i < missingDataCount)
				{
					map.put(head, "");
				} else
				{
					String dataValue = datas.get(i - missingDataCount).getText();
					map.put(head, dataValue);
				}
			}
			list.add(map);
		}
		BaseTest.getTest().log(Status.INFO, list.toString());
		ExtentManager.customReport(list);
		return list;
	}

	public void searchBoxFunctionScenarios()
	{
		threadSleep(ObjectRepository.wait10sec);
		explicitwaitforclick(autolocator(AudienceRepository.audience_target_searchIcon), 30);
		clickElement(AudienceRepository.audience_target_searchIcon);
		threadSleep(ObjectRepository.wait2sec);
		String searchButtonBeforeEnterName = getTextBoxVal(AudienceRepository.audience_serachbox_searchbutton, "class");
		if (searchButtonBeforeEnterName.contains("click-off"))
		{
			BaseTest.getTest().log(Status.INFO, "Search button is in disabled state before entered the list name");
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Search button is in enabled state before entered the list name");
			BaseTest.takeScreenshot();
		}
		String moreThan50Characters = "testestsesttestestestestestesttestestsesttestestestestestest";
		enterValue(AudienceRepository.audience_target_entersearchvalue, moreThan50Characters);
		threadSleep(ObjectRepository.wait10sec);
		boolean noDataFound = isElementPresent("No data found,xpath,//li[@class='no_data_found']");
		writeLog(noDataFound, "No data found message is thrown when entered wrong list", "No data found message is not thrown when entered wrong list");
		String searchBoxCharacters = getTextBoxVal(AudienceRepository.audience_target_entersearchvalue, "value");
		if (searchBoxCharacters.length() == 50)
		{
			BaseTest.getTest().log(Status.INFO, "Search box is not accepts more than 50 character as expected");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Search box is accepts more than 50 character");
			BaseTest.takeScreenshot();
		}
		clearField(AudienceRepository.audience_target_entersearchvalue);
		String specialCharaters = "!@#$%^&*()+={}[]\\;:?/><,.|";
		enterValue(AudienceRepository.audience_target_entersearchvalue, specialCharaters);
		String getSpecialchar = getTextBoxVal(AudienceRepository.audience_target_entersearchvalue, "value");
		if (getSpecialchar.isEmpty())
		{
			BaseTest.getTest().log(Status.INFO, "Search box is not accepts special characters as expected");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Search box is accepts special characters");
			BaseTest.takeScreenshot();
		}
		clearField(AudienceRepository.audience_target_entersearchvalue);
		// mouseHover(",xpath,//div[@class='rs-tooltip-wrapper d-inline-block']");
		String firstListName = getStrText(AudienceRepository.audience_target_FirstName_search);

		enterValue(AudienceRepository.audience_target_entersearchvalue, firstListName);
//		for (int i = 0; i < firstListName.length(); i++)
//		{
//			findElement(AudienceRepository.audience_target_entersearchvalue).sendKeys(String.valueOf(firstListName.charAt(i)));
//		}
//		tabAction();
		threadSleep(ObjectRepository.wait10sec);
		toolTipValidationKnownText(",xpath,//i[contains(@id,'data_delete')]", "Remove");
		toolTipValidationKnownText(",xpath,//i[contains(@id,'data_zoom')]", "Search");
		String searchButtonAfterEnterName = getTextBoxVal(AudienceRepository.audience_serachbox_searchbutton, "class");
		if (!searchButtonAfterEnterName.contains("click-off"))
		{
			BaseTest.getTest().log(Status.INFO, "Search button is in enabled state after entered the list name");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Search button is in disabled state after entered the list name");
			BaseTest.takeScreenshot();
		}
		boolean autoSugg = isElementPresent("Auto suggestion,xpath,//div[@class='box-design']//ul[contains(.,'" + firstListName + "')]");
		writeLog(autoSugg, "Auto suggestion is available as expected", "Auto suggestion is not available");
		clearField(AudienceRepository.audience_target_entersearchvalue);
		String listNamePlaceholder = getTextBoxVal(AudienceRepository.audience_target_entersearchvalue, "placeholder");
		threadSleep(ObjectRepository.wait5sec);
		if (listNamePlaceholder.equals("By communication name"))
		{
			BaseTest.getTest().log(Status.INFO, "Search box Communication name placeholder validated successfully");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Search box Communication name placeholder not shown as properly");
			BaseTest.takeScreenshot();
		}
		threadSleep(ObjectRepository.wait5sec);
		tabAction();
		clickElement(AudienceRepository.audience_FilterlistTypeBy);
		selectlistelementsAndProceed(AudienceRepository.audience_FilterlistTypeByList, "Communication type");
		String createdPlaceholder = getTextBoxVal(AudienceRepository.audience_target_entersearchvalue, "placeholder");
		if (createdPlaceholder.equals("By communication type"))
		{
			BaseTest.getTest().log(Status.INFO, "Search box Communication type placeholder is validated successfully");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Search box Communication type placeholder is not shown as properly");
			BaseTest.takeScreenshot();
		}
		threadSleep(ObjectRepository.wait5sec);
		clickElement(AudienceRepository.audience_FilterlistTypeBy);
		threadSleep(ObjectRepository.wait3sec);
		selectlistelementsAndProceed(AudienceRepository.audience_FilterlistTypeByList, "Delivery type");
		String modifiedPlaceholder = getTextBoxVal(AudienceRepository.audience_target_entersearchvalue, "placeholder");
		if (modifiedPlaceholder.equals("By delivery type"))
		{
			BaseTest.getTest().log(Status.INFO, "Search box By Delivery type placeholder is validated successfully");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Search box By Delivery type placeholder is not shown as properly");
			BaseTest.takeScreenshot();
		}
	}

	public void dropDoWnMandateCheck(String arialabel)
	{
		boolean flag;
		try
		{
			WebElement element = driver.findElement(By.xpath("//span[@aria-label='" + arialabel + "']"));
			String attribute = element.getAttribute("class");
			if (attribute.contains("required"))
			{
				flag = true;
			} else
			{
				flag = false;
			}
		} catch (Exception e)
		{
			BaseTest.getTest().log(Status.FAIL, "Given locator is wrong in mandate field check method");
		}
	}

	public String prefaddTimeToName()
	{
		SimpleDateFormat sd = new SimpleDateFormat("MdHmm");
		Date date = new Date();
		sd.setTimeZone(TimeZone.getTimeZone("IST"));
		String dt = sd.format(date);
		return dt;
	}

	public Date convertStringToDate(String date, String pattern)
	{
		SimpleDateFormat datePattern = new SimpleDateFormat(pattern);
		Date convertedDate = null;
		try
		{
			convertedDate = datePattern.parse(date);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return convertedDate;
	}

	public void javaScriptScrollActionExact(String pr)
	{
		WebElement element = driver.findElement(autolocator(pr));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	public void keytabclick()
	{
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
	}

	public static String replacePlaceHolder2(String locator, String placeHolder)
	{
		return locator.replace("PLACE_HOLDER", placeHolder);
	}

	public List<Map<String, String>> getwebTable(String table, String headers, String rows, String datas)
	{

		List<Map<String, String>> list = new LinkedList<>();
		WebElement webtable = driver.findElement(autolocator(table));

		// Fetch headers and rows only once
		List<WebElement> tableHeaders = webtable.findElements(autolocator(headers));
		List<WebElement> tableRows = webtable.findElements(autolocator(rows));
		System.out.println("Total rows found: " + tableRows.size());
		int rowIndex = 0;
		for (WebElement row : tableRows)
		{
			System.out.println("Processing row: " + rowIndex++);
			List<WebElement> tableData = row.findElements(autolocator(datas));
			for (WebElement cell : tableData)
			{
				System.out.print(cell.getText() + " | ");
			}
			System.out.println();
		}

		for (WebElement row : tableRows)
		{
			Map<String, String> map = new LinkedHashMap<>();
			List<WebElement> tableData = row.findElements(autolocator(datas));

			for (int i = 0; i < Math.min(tableHeaders.size(), tableData.size()); i++)
			{
				String tableHeader = tableHeaders.get(i).getText().trim();
				String tableDataValue = tableData.get(i).getText().trim();
				map.put(tableHeader, tableDataValue);
			}

			list.add(map);
		}

		ExtentManager.customReport(list);
		return list;
	}

	public List<Map<String, String>> csvFileReader()
	{
		List<Map<String, String>> data = new ArrayList<Map<String, String>>();
		threadSleep(ObjectRepository.wait5sec);
		File path = new File(System.getProperty("user.dir") + "/src\\main\\resources\\data\\downloadedFile\\");
		File[] files = path.listFiles();
		for (File file : files)
		{
			String str = file.getName();
			if (file.exists())
			{
				int rowCount = 0;
				try
				{
					BufferedReader reader = new BufferedReader(new FileReader(file));
					String line;

					String[] headers = reader.readLine().split(",");
					while ((line = reader.readLine()) != null)
					{
						Map<String, String> map = new LinkedHashMap<String, String>();
						String[] cell = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
						for (int i = 0; i < headers.length; i++)
						{
							map.put(headers[i], cell[i]);
						}
						data.add(rowCount, map);
						rowCount++;
					}
					reader.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				} finally
				{
					threadSleep(ObjectRepository.wait5sec);
					file.delete();
					BaseTest.getTest().log(Status.INFO, "The downloaded file has been deleted : " + str);
					BaseTest.getTest().log(Status.INFO, "Downloaded CSV File  --->  Total Rows Count in CSV : " + (data.size() + 1));
				}
			} else
			{
				BaseTest.getTest().log(Status.INFO, "File not found");
			}
			System.out.println("**** CSV FILE - OutPut ****");
			System.out.println(data);
		}
		return data;
	}

	public Map<String, String> getSegmentationCountInDynamicListingPage(String trgtListName)
	{
		String SegmentationCount = "";
		if (isElementPresent("List Name,xpath,//span[.='" + trgtListName + "']//ancestor::div[contains(@class,'card-bottom')]"))
		{
			try
			{
				SegmentationCount = getStrText("Segmentation Count,xpath,//span[.='" + trgtListName + "']//ancestor::div[contains(@class,'card-bottom')]//span[contains(.,'Avg. audience')]");
			} catch (Exception e)
			{
				BaseTest.getTest().log(Status.FAIL, "Average Audience text is not displayed");
			}

			String linkedComm = getStrText("linked Communication,xpath,//span[.='" + trgtListName + "']//ancestor::div[contains(@class,'card-bottom')]//span[contains(.,'Comm')]");
			String projectedReachRate = getStrText("Projected Reach Rate,xpath,//span[.='" + trgtListName + "']//ancestor::div[contains(@class,'card-bottom')]//span[contains(@class,'rcit-avg')]");
			String createdBy = getStrText("Created By,xpath,//span[.='" + trgtListName + "']//ancestor::div[contains(@class,'card-bottom')]//span[contains(@class,'rctcb-by-name')]").replace(",", "");
			String CreatedDateAndTime = getStrText("Date,xpath,//span[.='" + trgtListName + "']//ancestor::div[contains(@class,'card-bottom')]//span[contains(@class,'rctcb-by-date')]");
			trgtListDetails.put("SegmentationCount", SegmentationCount);
			trgtListDetails.put("LinkedCommunication", linkedComm);
			trgtListDetails.put("ProjectedReachRate", projectedReachRate + "%");
			trgtListDetails.put("Created by", createdBy);
			trgtListDetails.put("Created Date&Time", CreatedDateAndTime);
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "List Name not shown.");
			BaseTest.takeScreenshot();
		}
		return trgtListDetails;
	}

	/**
	 * It used to click element - with Explicit Wait.
	 * 
	 * @author Gokul S
	 * @param pr - object repository element
	 */
	public void click(String pr)
	{

		try
		{
			By locator = autolocator(pr);
			explicitwaitforclick(locator, 60);
			WebElement obj = driver.findElement(locator);
			javaScriptHighLightElement(obj);
			obj.click();
			BaseTest.getTest().log(Status.INFO, "Clicked ---> " + BaseTest.logName.get());

		} catch (Exception e)
		{
			// String name = new Object(){}.getClass().getEnclosingMethod().getName();
			assertCheck(BaseTest.logName.get(), " : click action failed");
		}

	}

}