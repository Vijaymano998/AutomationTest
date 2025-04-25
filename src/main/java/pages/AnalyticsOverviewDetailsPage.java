package pages;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import repository.AnalyticsRepository;
import repository.AudienceRepository;
import repository.CommunicationRepository;
import repository.DashboardRepository;
import repository.ObjectRepository;
import utility.BaseTest;
import utility.ExtentManager;
import utility.PageFactory;

/**
 * @author S K Mastan
 *
 */
public class AnalyticsOverviewDetailsPage extends HomePage
{
	public String analyticsListingPageStatus;
	Map<String, String> analyticsListingChannelResults = null;
	Map<String, String> analiticsListingPageItems = new HashMap<String, String>();
	Map<String, String> commDeliverability = new HashMap<String, String>();
	List<Map<String, String>> communicationAnalyticsListingCount = new ArrayList<Map<String, String>>();
	public Map<String, String> keyMetrics = new LinkedHashMap<>();
	public Map<String, String> emailChannelCommunicationAnalyticsListingPageCount = new LinkedHashMap<>();
	public Map<String, String> smsChannelCommunicationAnalyticsListingPageCount = new LinkedHashMap<>();
	public Map<String, String> qrAnalityicsListingPageCount = new LinkedHashMap<>();
	public Map<String, String> whatsAppAnalityicsListingPageCount = new LinkedHashMap<>();

	public Map<String, String> qrChannelCommunicationAnalyticsListingPageCount = new HashMap<String, String>();
	public Map<String, String> webChannelCommunicationAnalyticsListingPageCount = new HashMap<String, String>();
	public Map<String, String> mobileChannelCommunicationAnalyticsListingPageCount = new HashMap<String, String>();
	public Map<String, String> whatsappChannelCommunicationAnalyticsListingPageCount = new HashMap<String, String>();
	public Map<String, String> vmsChannelCommunicationAnalyticsListingPageCount = new HashMap<String, String>();

	// OverView page
	List<Map<String, String>> analyticsOverviewChannelsCount = new ArrayList<Map<String, String>>();
	Map<String, String> getReachOverviewSummary = new HashMap<String, String>();
	Map<String, String> getEngagementOverviewSummary = new HashMap<String, String>();
	Map<String, String> getConversionOverviewSummary = new HashMap<String, String>();
	Map<String, String> emailChannelCommunicationAnalyticsOverviewPageCount = new HashMap<String, String>();
	Map<String, String> smsChannelCommunicationAnalyticsOverviewPageCount = new HashMap<String, String>();
	Map<String, String> qrChannelCommunicationAnalyticsOverviewPageCount = new HashMap<String, String>();
	Map<String, String> webChannelCommunicationAnalyticsOverviewPageCount = new HashMap<String, String>();
	Map<String, String> mobileChannelCommunicationAnalyticsOverviewPageCount = new HashMap<String, String>();
	Map<String, String> whatsappChannelCommunicationAnalyticsOverviewPageCount = new HashMap<String, String>();
	// Details
	Map<String, String> emailAnalyticsDetailsPageCount = new HashMap<String, String>();
	Map<String, String> smsChannelCommunicationAnalyticsDetailsPageCount = new HashMap<String, String>();
	Map<String, String> qrChannelCommunicationAnalyticsDetailsPageCount = new HashMap<String, String>();
	Map<String, String> webChannelCommunicationAnalyticsDetailsPageCount = new HashMap<String, String>();
	Map<String, String> mobileChannelCommunicationAnalyticsDetailsPageCount = new HashMap<String, String>();
	Map<String, String> whatsappChannelCommunicationAnalyticsDetailsPageCount = new HashMap<String, String>();

	// Mkstr
	Map<String, String> detailsOverview = new LinkedHashMap<String, String>();
	Map<String, Integer> detailsKeymetrics = new LinkedHashMap<String, Integer>();
	List<Map<String, String>> totalLinkClick = new ArrayList<Map<String, String>>();
	List<Map<String, String>> commStatus = new ArrayList<Map<String, String>>();
	private List<Map<String, String>> listingPageChannelDetails;

	public AnalyticsOverviewDetailsPage(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	public void selectAllCommValidation()
	{
		clickElement(AnalyticsRepository.listing_filter_communication);
		threadSleep(ObjectRepository.wait1sec);
		clickElement(AnalyticsRepository.listing_filter_selectAllcommunication);
	}

	public final AnalyticsOverviewDetailsPage analyticsAdvancedSearchBy(String searchBy)
	{
		explicitwaitforclick(autolocator(CommunicationRepository.CommunicationListing_SearchIconClick), 30);
		clickElement(CommunicationRepository.CommunicationListing_SearchIconClick);
		explicitwaitforclick(autolocator(AnalyticsRepository.analytics_listing_advanceSearch), 10);
		clickElement(AnalyticsRepository.analytics_listing_advanceSearch);
		selectlistelements(AnalyticsRepository.analytics_listing_advanceSearchList, searchBy);
		return this;
	}

	public AnalyticsOverviewDetailsPage listingPageAdvancedSearchBy(String searchBy, String testData, String locator)
	{
		explicitwaitforclick(autolocator(CommunicationRepository.CommunicationListing_SearchIconClick), 30);
		clickElement(CommunicationRepository.CommunicationListing_SearchIconClick);
		explicitwaitforclick(autolocator(AnalyticsRepository.analytics_listing_advanceSearch), 10);
		clickElement(AnalyticsRepository.analytics_listing_advanceSearch);
		selectlistelements(AnalyticsRepository.analytics_listing_advanceSearchList, searchBy);
		boolean var = true;
		boolean productTypeRetainText = false;
		explicitwaitforclick(autolocator(CommunicationRepository.CommunicationListing_SearchCommunication), 50);
		if (searchBy.equals("Product type"))
		{
			for (int i = 1; i < 3; i++)
			{
				sendValue(CommunicationRepository.CommunicationListing_SearchCommunication, testData);
				if (isElementPresent(AudienceRepository.audience_target_entersearchResult))
				{
					clickElement(AudienceRepository.audience_target_entersearchResult);
				}
				explicitwaitforclick(autolocator(CommunicationRepository.CommunicationListing_SearchIconClickAfterenterValue), 50);
				clickElement(CommunicationRepository.CommunicationListing_SearchIconClickAfterenterValue);
				clickElement("Edit button,xpath,(//i[contains(@class,'icon-sd-pencil-edit-medium icons')])[" + i + "]");
				String productTypeText = getStrText(locator);
				if (productTypeText.equals(testData))
				{
					BaseTest.takeScreenshot();
					productTypeRetainText = true;
				} else
				{
					BaseTest.takeScreenshot();
				}
				clickCommunicationTab();
				explicitwaitforclick(autolocator(CommunicationRepository.CommunicationListing_SearchIconClick), 30);
				clickElement(CommunicationRepository.CommunicationListing_SearchIconClick);
				explicitwaitforclick(autolocator(AnalyticsRepository.analytics_listing_advanceSearch), 10);
				clickElement(AnalyticsRepository.analytics_listing_advanceSearch);
				selectlistelements(AnalyticsRepository.analytics_listing_advanceSearchList, searchBy);
				pageLoaderLogo();
			}
			if (productTypeRetainText)
			{
				BaseTest.getTest().log(Status.INFO, "Able to search communication by product type.");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Unble to search communication by product type.");
			}
		}
		if (!searchBy.equals("Product type"))
		{
			if (!searchBy.equalsIgnoreCase("All communication") && !searchBy.equalsIgnoreCase("My communication") && !searchBy.equalsIgnoreCase("Product type"))
			{
				sendValue(CommunicationRepository.CommunicationListing_SearchCommunication, testData);
				threadSleep(ObjectRepository.wait2sec);
				if (isElementPresent(AudienceRepository.audience_target_entersearchResult))
				{
					clickElement(AudienceRepository.audience_target_entersearchResult);
				}
				explicitwaitforclick(autolocator(CommunicationRepository.CommunicationListing_SearchIconClickAfterenterValue), 50);
				clickElement(CommunicationRepository.CommunicationListing_SearchIconClickAfterenterValue);
			}
			if (!isElementPresent(AnalyticsRepository.analytics_listing_nodata))
			{
				explicitwaitforvisibility(autolocator(AnalyticsRepository.analytics_listing_gridlist), 30);
				List<WebElement> results = findElements(AnalyticsRepository.analytics_listing_gridlist);
				if (testData.equals("S"))
				{
					testData = "Single dimension";
				} else if (testData.equals("M"))
				{
					testData = "Multi dimension";
				}
				for (int i = 0; i < results.size(); i++)
				{
					WebElement grid = results.get(i).findElement(autolocator(locator + "[" + (i + 1) + "]"));
					String result = grid.getText().trim();
					javaScriptHighLightElement(grid);
					if (!searchBy.equalsIgnoreCase("All communication"))
					{
						if (!result.equals(testData))
						{
							BaseTest.getTest().log(Status.FAIL, testData + " doesn't filtered as Expected");
							javaScriptHighLightwithScrnShot(grid);
							var = false;
						}
					} else
					{
						List<String> output = Arrays.asList(testData.split(","));
						if (!output.contains(result))
						{
							BaseTest.getTest().log(Status.FAIL, output + " doesn't filtered as Expected");
							javaScriptHighLightwithScrnShot(grid);
							var = false;
						}
					}
				}
				if (var)
				{
					BaseTest.getTest().log(Status.INFO, "The testData <b>" + testData + "</b> ---> Sucessfully verified for displaying list of grid");
					BaseTest.takeScreenshot();
				}
			} else
			{
				BaseTest.getTest().log(Status.WARNING, "No Data Found");
				BaseTest.takeScreenshot();
			}
		}
		clickElement(AnalyticsRepository.analytics_listing_advanceSearchCancel);
		threadSleep(ObjectRepository.wait1sec);
		return this;
	}

	public AnalyticsOverviewDetailsPage analyticSearchcommunication(String communicationName)
	{
		String commSearchResults = "Communication Name,xpath,//div[text()='" + communicationName + "']";
		threadSleep(ObjectRepository.wait5sec);
		clickElement(CommunicationRepository.CommunicationListing_SearchIconClick);
		enterValue(CommunicationRepository.CommunicationListing_SearchCommunication, communicationName);
		threadSleep(ObjectRepository.wait2sec);
		pageLoaderLogo();
		selectexactlistelements(CommunicationRepository.CommunicationListing_selectListedCommunication, communicationName);
		clickElement(CommunicationRepository.CommunicationListing_SearchIconClickAfterenterValue);
		pageLoaderLogo();
		try
		{
			Map<String, String> reports = new LinkedHashMap<String, String>();
			explicitwaitforvisibility(autolocator(commSearchResults), 30);
			String status = getStrText(CommunicationRepository.CommunicationListing_CommunicationStatus);
			reports.put("Communication Name", communicationName);
			reports.put("Main Status", status);
			reports.put("Deliverability", getStrText(AnalyticsRepository.analytics_listing_deliverability));
			if (!status.toLowerCase().contains("completed") && !status.toLowerCase().contains("in progress"))
			{
				BaseTest.getTest().log(Status.WARNING, communicationName + " Status: " + status + ", in analytics listing page");
			}
			BaseTest.takeScreenshot();
			ExtentManager.customReport(reports);
		} catch (Exception e)
		{
			e.printStackTrace();
			if (isElementPresent(AnalyticsRepository.analytics_listing_nodata))
			{
				BaseTest.getTest().log(Status.INFO, "No Data Found");
				BaseTest.takeScreenshot();
			}
		}
		return this;
	}

	public AnalyticsOverviewDetailsPage pw_analyticSearchcommunication(String communicationName)
	{
		String commSearchResults = "Communication Name,pw,//div[text()='" + communicationName + "']";
		threadSleep(ObjectRepository.wait5sec);
		pw_clickElement(AnalyticsRepository.pw_analyticsListingsearchIconClick);
		pw_enterValue(AnalyticsRepository.pw_analyticsListing_SearchCommunication, communicationName);
		threadSleep(ObjectRepository.wait2sec);
		pw_pageLoaderLogo();
		pw_selectExactlistelements(AnalyticsRepository.pw_analyticsListing_selectListedCommunication, communicationName);
		pw_clickElement(AnalyticsRepository.pw_analyticsListing_SearchIconClickAfterenterValue);
		pw_pageLoaderLogo();
		try
		{
			Map<String, String> reports = new LinkedHashMap<String, String>();
			String status = pw_getStrText(AnalyticsRepository.pw_analyticsListing_CommunicationStatus);
			reports.put("Communication Name", communicationName);
			reports.put("Main Status", status);
			reports.put("Deliverability", pw_getStrText(AnalyticsRepository.pw_analyticsListing_deliverability));
			if (!status.toLowerCase().contains("completed") && !status.toLowerCase().contains("in progress"))
			{
				BaseTest.getTest().log(Status.WARNING, communicationName + " Status: " + status + ", in analytics listing page");
			}
			BaseTest.pw_takesScreenshot();
			ExtentManager.customReport(reports);
		} catch (Exception e)
		{
			e.printStackTrace();
			if (pw_isElementPresent(AnalyticsRepository.pw_analyticsListing_nodata))
			{
				BaseTest.getTest().log(Status.INFO, "No Data Found");
				BaseTest.pw_takesScreenshot();
			}
		}
		return this;
	}

	public List<Map<String, String>> getListingPageChannelDetails(String nameOfListingPage, String CommunicationName)
	{
		String analyticsListingHeaders = "//div[contains(@class,'detail-view')]/table/thead/tr/th";
		String analyticsListingRows = "//div[contains(@class,'detail-view')]//tbody//tr";
		threadSleep(ObjectRepository.wait2sec);
		explicitwaitforclick(autolocator(replacePlaceHolder(CommunicationRepository.CommunicationListing_plusIconForDetails, CommunicationName)), 50);
		actionsClickElement(replacePlaceHolder(CommunicationRepository.CommunicationListing_plusIconForDetails, CommunicationName));
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait3sec);
		List<WebElement> trows, theads, tdata;
		pageLoaderLogo();
		theads = driver.findElements(By.xpath(analyticsListingHeaders));
		trows = driver.findElements(By.xpath(analyticsListingRows));
		System.out.println("Heads:" + theads.size());
		System.out.println("trows:" + trows.size());
		commDeliverability.put("MainStatus", getStrText(CommunicationRepository.CommunicationListing_CommunicationStatus));
		commDeliverability.put("Deliverability", getStrText(AnalyticsRepository.analytics_listing_deliverability));
		for (int rowSize = 0; rowSize < trows.size(); rowSize++)
		{
			analyticsListingChannelResults = new LinkedHashMap<String, String>();
			WebElement row = trows.get(rowSize);
			tdata = row.findElements(By.tagName("td"));
			System.out.println("current row data size:" + tdata.size());
			for (int dataValue = 0; dataValue < tdata.size(); dataValue++)
			{
				WebElement value = tdata.get(dataValue);
				WebElement headerName = theads.get(dataValue);
				if (headerName.getText().toLowerCase().contains("status"))
				{
					WebElement element = value.findElement(By.tagName("i"));
					mouseHover(element);
					String status = getStrText(",xpath,//div[@class='tooltip-inner']");
					analyticsListingChannelResults.put(headerName.getText(), status);
					if (status.toLowerCase().contains("scheduled") && !nameOfListingPage.toLowerCase().contains("analytics"))
					{
						analyticsListingChannelResults.put("ScheduledTime", value.getText().trim());
					}
				} else if (headerName.getText().toLowerCase().contains("channel"))
				{
					WebElement element = value.findElement(By.tagName("i"));
					mouseHover(element);
					analyticsListingChannelResults.put(headerName.getText(), getStrText(",xpath,//div[@class='tooltip-inner']"));
				} else
				{
					analyticsListingChannelResults.put(headerName.getText(), value.getText().trim());
				}
			}
			communicationAnalyticsListingCount.add(rowSize, analyticsListingChannelResults);

			// Verify the preview icon
			int count = rowSize + 1;
			analyticsListingPreviewpopup(analyticsListingRows + "[" + count + "]", communicationAnalyticsListingCount.get(rowSize).get("Channel"));
		}
		System.out.println(communicationAnalyticsListingCount);
		for (int i = 0; i < communicationAnalyticsListingCount.size(); i++)
		{
			Map<String, String> channelwise = new LinkedHashMap<>();
			for (Map.Entry<String, String> entry : communicationAnalyticsListingCount.get(i).entrySet())
			{
				channelwise.put(entry.getKey(), entry.getValue());
			}
			String Channel = channelwise.get("Channel");
			switch (Channel)
			{
			case "Email":

				emailChannelCommunicationAnalyticsListingPageCount.putAll(channelwise);
				ExtentManager.customReport(emailChannelCommunicationAnalyticsListingPageCount);
				break;

			case "SMS":
				smsChannelCommunicationAnalyticsListingPageCount.putAll(channelwise);
				ExtentManager.customReport(smsChannelCommunicationAnalyticsListingPageCount);
				break;

			case "WhatsApp":

				whatsAppAnalityicsListingPageCount.putAll(channelwise);
				ExtentManager.customReport(whatsAppAnalityicsListingPageCount);
				break;

			case "QR":

				qrAnalityicsListingPageCount.putAll(channelwise);
				ExtentManager.customReport(qrAnalityicsListingPageCount);
				break;

			default:
				break;
			}
		}
		driver.findElement(By.xpath("//a[contains(@class,'minus')]")).click();
		return communicationAnalyticsListingCount;
	}

	public List<Map<String, String>> pw_getListingPageChannelDetails(String nameOfListingPage, String CommunicationName)
	{
		String analyticsListingRows = "//div[contains(@class,'detail-view')]//tbody//tr";
		threadSleep(ObjectRepository.wait2sec);
		pw_clickElement(replacePlaceHolder(AnalyticsRepository.analyticsListing_plusIconForDetails, CommunicationName));
		pw_pageLoaderLogo();
		threadSleep(ObjectRepository.wait3sec);
		Locator trows, theads, tdata;
		pw_pageLoaderLogo();
		theads = pw_findelements(AnalyticsRepository.analyticsListingHeaders);
		trows = pw_findelements(AnalyticsRepository.analyticsListingRows);
		System.out.println("Heads:" + theads.count());
		System.out.println("trows:" + trows.count());
		commDeliverability.put("MainStatus", pw_getStrText(AnalyticsRepository.analyticsListing_CommunicationStatus));
		commDeliverability.put("Deliverability", pw_getStrText(AnalyticsRepository.pw_analytics_listing_deliverability));
		for (int rowSize = 0; rowSize < trows.count(); rowSize++)
		{
			analyticsListingChannelResults = new LinkedHashMap<String, String>();
			Locator row = trows.nth(rowSize);
			tdata = row.locator("td");
			System.out.println("current row data size:" + tdata.count());
			for (int dataValue = 0; dataValue < tdata.count(); dataValue++)
			{
				Locator value = tdata.nth(dataValue);
				Locator headerName = theads.nth(dataValue);
				if (headerName.textContent().toLowerCase().contains("status"))
				{
					Locator element = value.locator(("i"));
					element.hover();
					String status = pw_getStrText(AnalyticsRepository.pw_analyticsListingtooltip);
					analyticsListingChannelResults.put(headerName.textContent(), status);
					if (status.toLowerCase().contains("scheduled") && !nameOfListingPage.toLowerCase().contains("analytics"))
					{
						analyticsListingChannelResults.put("ScheduledTime", value.textContent().trim());
					}
				} else if (headerName.textContent().toLowerCase().contains("channel"))
				{
					Locator element = value.locator("i");
					element.hover();
					analyticsListingChannelResults.put(headerName.textContent(), pw_getStrText(AnalyticsRepository.pw_analyticsListingtooltip));
				} else
				{
					analyticsListingChannelResults.put(headerName.textContent(), value.textContent().trim());
				}
			}
			communicationAnalyticsListingCount.add(rowSize, analyticsListingChannelResults);

			// Verify the preview icon
			int count = rowSize + 1;
			pw_analyticsListingPreviewpopup(analyticsListingRows + "[" + count + "]", communicationAnalyticsListingCount.get(rowSize).get("Channel"));
		}
		System.out.println(communicationAnalyticsListingCount);
		for (int i = 0; i < communicationAnalyticsListingCount.size(); i++)
		{
			Map<String, String> channelwise = new LinkedHashMap<>();
			for (Map.Entry<String, String> entry : communicationAnalyticsListingCount.get(i).entrySet())
			{
				channelwise.put(entry.getKey(), entry.getValue());
			}
			String Channel = channelwise.get("Channel");
			switch (Channel)
			{
			case "Email":

				emailChannelCommunicationAnalyticsListingPageCount.putAll(channelwise);
				ExtentManager.customReport(emailChannelCommunicationAnalyticsListingPageCount);
				break;

			case "SMS":
				smsChannelCommunicationAnalyticsListingPageCount.putAll(channelwise);
				ExtentManager.customReport(smsChannelCommunicationAnalyticsListingPageCount);
				break;

			case "WhatsApp":

				whatsAppAnalityicsListingPageCount.putAll(channelwise);
				ExtentManager.customReport(whatsAppAnalityicsListingPageCount);
				break;

			case "QR":

				qrAnalityicsListingPageCount.putAll(channelwise);
				ExtentManager.customReport(qrAnalityicsListingPageCount);
				break;

			default:
				break;
			}
		}
		pw_clickElement("Minus Icon,pw,//a[contains(@class,'minus')]");
		return communicationAnalyticsListingCount;
	}

	// Campaign Analytics Preview
	public AnalyticsOverviewDetailsPage analyticsListingPreviewpopupDownloadPDF()
	{
		threadSleep(ObjectRepository.wait5sec);
		explicitwaitforpresence(autolocator(CommunicationRepository.CommunicationListing_plusIconForDetails), 50);
		clickElement(CommunicationRepository.CommunicationListing_plusIconForDetails);
		explicitwaitforpresence(autolocator(CommunicationRepository.CommunicationListing_PreviewIcon), 50);
		clickElement(CommunicationRepository.CommunicationListing_PreviewIcon);
		BaseTest.takeScreenshot();
		threadSleep(ObjectRepository.wait3sec);
		if (!isDisplayed(CommunicationRepository.CommunicationListing_PreviewIconContent))
		{
			BaseTest.getTest().log(Status.FAIL, "Preview Pop up Failed to Appear");
		}
		threadSleep(ObjectRepository.wait3sec);
		clickElement(CommunicationRepository.CommunicationListing_minusicon);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(AnalyticsRepository.analytics_comm_analyticsdownload);
		threadSleep(ObjectRepository.wait5sec);
		return this;
	}

	// Campaign Analytics Preview
	public AnalyticsOverviewDetailsPage analyticsListingPreviewpopup(String locator, String channelName)
	{
		if (isElementPresent(replacePlaceHolder(AnalyticsRepository.analyticspreviewicon, locator)))
		{
			explicitwaitforclick(autolocator(replacePlaceHolder(AnalyticsRepository.analyticspreviewicon, locator)), 30);
			clickElement(replacePlaceHolder(AnalyticsRepository.analyticspreviewicon, locator));
			threadSleep(ObjectRepository.wait3sec);
			if (channelName.toLowerCase().contains("email"))
			{
				String image = getTextBoxVal(CommunicationRepository.CommunicationListing_PreviewIconContent + "//img", "src");
				if (!isDisplayed(CommunicationRepository.CommunicationListing_PreviewIconContent) && image.contains("no_media.png"))
				{
					BaseTest.getTest().log(Status.FAIL, "Preview Pop up show as <b> 'No Media Available' </b>");
				}
			} else if (channelName.toLowerCase().contains("whatsapp"))
			{
				String contentText = getStrText(AnalyticsRepository.analyticswhatsappcontent);
				writeLog(contentText.isEmpty(), channelName + " content is displayed as expected.", channelName + " content is not displayed as expected.");
			}
			clickElement(replacePlaceHolder(AnalyticsRepository.analyticspreviewicon, locator));
			threadSleep(ObjectRepository.wait3sec);
		}
		return this;
	}

	// Campaign Analytics Preview
	public AnalyticsOverviewDetailsPage pw_analyticsListingPreviewpopup(String locator, String channelName)
	{
		if (pw_isElementPresent(replacePlaceHolder(AnalyticsRepository.pw_analyticspreviewicon, locator)))
		{
			pw_clickElement(replacePlaceHolder(AnalyticsRepository.pw_analyticspreviewicon, locator));
			threadSleep(ObjectRepository.wait3sec);
			if (channelName.toLowerCase().contains("email"))
			{
				String image = pw_getTextBoxVal(AnalyticsRepository.pw_analyticspreviewcontent + "//img", "src");
				if (!pw_isElementPresent(AnalyticsRepository.pw_analyticspreviewcontent) && image.contains("no_media.png"))
				{
					BaseTest.getTest().log(Status.FAIL, "Preview Pop up show as <b> 'No Media Available' </b>");
				}
			} else if (channelName.toLowerCase().contains("whatsapp"))
			{
				String contentText = pw_getStrText(AnalyticsRepository.pw_analyticswhatsappcontent);
				pw_writeLog(!contentText.isEmpty(), channelName + " content is displayed as expected.", channelName + " content is not displayed as expected.");
			}
			pw_clickElement(replacePlaceHolder(AnalyticsRepository.pw_analyticspreviewicon, locator));
			threadSleep(ObjectRepository.wait3sec);
		}
		return this;
	}

	public AnalyticsOverviewDetailsPage clickReports(String communicationName)
	{
		explicitwaitforclick(autolocator(replacePlaceHolder(CommunicationRepository.CommunicationListing_comm_viewanalytics, communicationName)), 20);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(replacePlaceHolder(CommunicationRepository.CommunicationListing_comm_viewanalytics, communicationName));
		pageLoaderLogo();
		return this;
	}

	public AnalyticsOverviewDetailsPage pw_clickReports(String communicationName)
	{
		threadSleep(ObjectRepository.wait3sec);
		pw_clickElement(replacePlaceHolder(AnalyticsRepository.pw_anayticsListing_viewanalytics, communicationName));
		pw_pageLoaderLogo();
		return this;
	}

	public AnalyticsOverviewDetailsPage analyticsListingDetailsReport()
	{
		explicitwaitforvisibility(autolocator(AnalyticsRepository.analytics_overviewDashboard), 60);
		List<WebElement> tabs = findElements(AnalyticsRepository.analytics_channelTabs);
		for (int i = 0; i < tabs.size(); i++)
		{
			tabs.get(i).click();
			BaseTest.getTest().log(Status.INFO, "Clicked ---> " + tabs.get(i).getText() + " Channel tab");
			explicitwaitforvisibility(autolocator(AnalyticsRepository.analytics_overviewDashboard), 60);
			isDisplayed(AnalyticsRepository.analytics_overviewDashboard);
			javaScriptScrollDownToSomeExtend();
			isDisplayed(AnalyticsRepository.analytics_DetailPage_keymetrics);
			javaScriptScrolltoTop();
		}
		return this;
	}

	public boolean analyticsStatusdownload(String downloadChannel, String downloadType)
	{
		boolean countStatus = false;
		clickElement(CommunicationRepository.CommunicationListing_comm_viewanalytics);
		javaScriptPageLoad();
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait3sec);
		javaScriptScrollIntoView(AnalyticsRepository.analytics_summaryReport);
		javaScriptScrollUpToSomeExtend();
		threadSleep(ObjectRepository.wait5sec);
		List<WebElement> channelsTable = findElements(AnalyticsRepository.analytics_summaryReport);
		for (int overviewHead = 0; overviewHead < channelsTable.size(); overviewHead++)
		{
			WebElement curntHead = channelsTable.get(overviewHead);

			String channelName = curntHead.getText();
			if (channelName.equalsIgnoreCase(downloadChannel))
			{
				Actions ac = new Actions(driver);
				ac.moveToElement(curntHead).click().build().perform();
				break;

			}
		}
		String text = getTextBoxVal("details link,xpath,//div[contains(@class,'active')]//a[contains(@href,'/CampaignSummaryDetail/Report')]//parent::div", "class");
		if (!text.contains("click-off"))
		{
			clickElement("Details,xpath,//div[contains(@class,'active')]//a[contains(@href,'/CampaignSummaryDetail/Report')]");
		} else
		{
			System.out.println("Details link disabled");
		}
		javaScriptScrollIntoView("Campaign status type,xpath,//div[@id='campStatusDivShow']//div[contains(@class,'dropdown')]");
		clickElement("Campaign status type,xpath,//div[@id='campStatusDivShow']//div[contains(@class,'dropdown')]");
		List<WebElement> statusList = findElements(",xpath,//div[@id='campStatusDivShow']//div[contains(@class,'dropdown')]/ul/li");
		for (int status = 0; status < statusList.size(); status++)
		{
			WebElement ele = statusList.get(status);
			String textval = ele.getAttribute("onclick");
			if (textval.toLowerCase().contains(downloadType.toLowerCase()))
			{
				ele.click();
				pageLoaderLogo();
				String count = getStrText(",xpath,//div[@id='campStatusDivShow']//h3[@id='spnShowCount']");
				int counts = Integer.parseInt(count.replaceAll("[^0-9]", ""));
				if (counts > 0)
				{
					if (driver.findElements(By.xpath("//div[@id='campStatusDivShow']//div[@id='updatepanelActivityGrid']//tr")).size() > 1)
					{
						BaseTest.takeScreenshot();
						countStatus = true;
					} else
					{
						BaseTest.getTest().warning("Campaign Status table data count : 0");
						BaseTest.takeScreenshot();
					}
					break;
				} else
				{
					BaseTest.getTest().warning("Campaign Status count : " + counts);
					break;
				}
			}
		}
		return countStatus;
	}

	public void clicklinkVerification()
	{
		int pageCount = 1;
		while (true)
		{
			if (driver.findElements(By.xpath("//div[@id='campStatusDivShow']//a[text()='Show link']")).size() > 0)
			{
				clickElement("Show link,xpath,//div[@id='campStatusDivShow']//a[text()='Show link']");
				BaseTest.takeScreenshot();
				break;
			} else if (driver.findElements(By.xpath("//div[@id='campStatusDivShow']//span[text()='arrow-e']")).size() > 0)
			{
				String text = getTextBoxVal("next page link,xpath,//div[@id='campStatusDivShow']//span[text()='arrow-e']/..", "class");
				if (text.contains("disabled"))
				{
					System.out.println("No next page available");
					break;
				} else
				{
					clickElement("next page arrow,xpath,//div[@id='campStatusDivShow']//span[text()='arrow-e']");
				}
				pageCount++;
			} else
			{
				System.out.println("Total pages:" + pageCount + ",No next page");
			}
		}
	}

	public AnalyticsOverviewDetailsPage communicationStatusDownloadConfirmationPopup()
	{
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforclick(autolocator(AnalyticsRepository.analytics_requestDownloadCSV_ok), 50);
		isDisplayed(AnalyticsRepository.analytics_requestDownloadCSV);
		clickElement(AnalyticsRepository.analytics_requestDownloadCSV_ok);
		return this;

	}

	// *************Listing page count get channel wise *******
	// *********Campaign and Analytics listing page channels after click on +

	// *******Overview page details get

	public AnalyticsOverviewDetailsPage getOverviewPageChannelDetails()
	{
		pageLoaderLogo();
		getReachOverviewSummary = getOverviewPageSummaryCount("summary of reach,xpath,(//div[contains(@class,'a-card-list ')])[1]");
		getEngagementOverviewSummary = getOverviewPageSummaryCount("summary of engagement,xpath,(//div[contains(@class,'a-card-list ')])[2]");
		getConversionOverviewSummary = getOverviewPageSummaryCount("summary of conversion,xpath,(//div[contains(@class,'a-card-list ')])[3]");
		javaScriptScrollIntoView(AnalyticsRepository.analytics_summaryReport);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-150)");
		threadSleep(ObjectRepository.wait3sec);
		int channelsHeadCount1 = 0;
		List<WebElement> theadsOverview, currentRow_tdata, channelsTable, currentChannel_trows;
		HashMap<String, String> channelMap = null;
		theadsOverview = findElements(AnalyticsRepository.analytics_summaryReport);
		for (int channelsHeadCount = 0; channelsHeadCount < theadsOverview.size(); channelsHeadCount++)
		{
			if (theadsOverview.get(channelsHeadCount).isEnabled())
			{
				theadsOverview.get(channelsHeadCount).click();
				threadSleep(ObjectRepository.wait5sec);
				channelMap = new HashMap<String, String>();
				String currentCh = theadsOverview.get(channelsHeadCount).getText();
				channelMap.put("Channel", currentCh);
				channelsHeadCount1 += 1;
				channelsTable = driver.findElements(By.xpath("((//div[@class='container']//div[@class='row'])[2])[" + channelsHeadCount1 + "]"));
				for (int channelsCount = 0; channelsCount < channelsTable.size(); channelsCount++)
				{
					boolean addMap = false;
					WebElement currentChannel = channelsTable.get(channelsCount);
					currentChannel_trows = currentChannel.findElements(By.tagName("tr"));
					for (int tr_rowSize = 0; tr_rowSize < currentChannel_trows.size(); tr_rowSize++)
					{
						String name = null, value = null;
						WebElement currentChannel_trow = currentChannel_trows.get(tr_rowSize);
						currentRow_tdata = currentChannel_trow.findElements(By.tagName("td"));
						for (int dataValue = 0; dataValue < currentRow_tdata.size(); dataValue += 2)
						{
							name = currentRow_tdata.get(dataValue).getText();
							value = currentRow_tdata.get(dataValue + 1).getText();
							channelMap.put(name, value);
							addMap = true;
						}
					}
					if (addMap)
					{
						analyticsOverviewChannelsCount.add(channelsHeadCount, channelMap);
					}

				}
			}
		}

//		clickElement("Details link,xpath,(//p[.='Details'])[" + channelsHeadCount1 + "]");

		for (int i = 0; i < analyticsOverviewChannelsCount.size(); i++)
		{
			Map<String, String> channelwise = analyticsOverviewChannelsCount.get(i);
			String currentChannel = channelwise.get("Channel").toLowerCase();
			if (currentChannel.contains("email"))
			{
				for (Map.Entry<String, String> entry : channelwise.entrySet())
				{
					emailChannelCommunicationAnalyticsOverviewPageCount.put(entry.getKey(), entry.getValue());
				}
			} else if (currentChannel.equalsIgnoreCase("mobile"))
			{
				for (Map.Entry<String, String> entry : channelwise.entrySet())
				{
					smsChannelCommunicationAnalyticsOverviewPageCount.put(entry.getKey(), entry.getValue());
				}
			} else if (currentChannel.contains("qr"))
			{
				for (Map.Entry<String, String> entry : channelwise.entrySet())
				{
					qrChannelCommunicationAnalyticsOverviewPageCount.put(entry.getKey(), entry.getValue());
				}
			} else if (currentChannel.contains("web"))
			{
				for (Map.Entry<String, String> entry : channelwise.entrySet())
				{
					webChannelCommunicationAnalyticsOverviewPageCount.put(entry.getKey(), entry.getValue());
				}
			} else if (currentChannel.contains("mobile push"))
			{
				for (Map.Entry<String, String> entry : channelwise.entrySet())
				{
					mobileChannelCommunicationAnalyticsOverviewPageCount.put(entry.getKey(), entry.getValue());
				}
			}
		}
		System.out.println(emailChannelCommunicationAnalyticsOverviewPageCount);
		System.out.println(smsChannelCommunicationAnalyticsOverviewPageCount);
		System.out.println(qrChannelCommunicationAnalyticsOverviewPageCount);
		System.out.println(webChannelCommunicationAnalyticsOverviewPageCount);
		System.out.println(mobileChannelCommunicationAnalyticsOverviewPageCount);

		return this;
	}

	public AnalyticsOverviewDetailsPage pw_getOverviewPageChannelDetails()
	{
		pw_pageLoaderLogo();
		getReachOverviewSummary = pw_getOverviewPageSummaryCount("summary of reach,pw,(//div[contains(@class,'a-card-list ')])[1]");
		getEngagementOverviewSummary = pw_getOverviewPageSummaryCount("summary of engagement,pw,(//div[contains(@class,'a-card-list ')])[2]");
		getConversionOverviewSummary = pw_getOverviewPageSummaryCount("summary of conversion,pw,(//div[contains(@class,'a-card-list ')])[3]");
		page.evaluate("window.scrollBy(0, -150)");
		threadSleep(ObjectRepository.wait3sec);
		int channelsHeadCount1 = 0;
		Locator theadsOverview, channelsTable, currentChannel_trows, currentRow_tdata;
		HashMap<String, String> channelMap = null;
		theadsOverview = pw_findelements(AnalyticsRepository.pw_analytics_summaryReport);
		for (int channelsHeadCount = 0; channelsHeadCount < theadsOverview.count(); channelsHeadCount++)
		{
			if (theadsOverview.nth(channelsHeadCount).isEnabled())
			{
				theadsOverview.nth(channelsHeadCount).click();
				threadSleep(ObjectRepository.wait5sec);
				channelMap = new HashMap<String, String>();
				String currentCh = theadsOverview.nth(channelsHeadCount).textContent();
				channelMap.put("Channel", currentCh);
				channelsHeadCount1 += 1;
				channelsTable = pw_findelements("ChannelsTable,pw,((//div[@class='container']//div[@class='row'])[2])[" + channelsHeadCount1 + "]");
				for (int channelsCount = 0; channelsCount < channelsTable.count(); channelsCount++)
				{
					boolean addMap = false;
					Locator currentChannel = channelsTable.nth(channelsCount);
					currentChannel_trows = currentChannel.locator("tr");
					for (int tr_rowSize = 0; tr_rowSize < currentChannel_trows.count(); tr_rowSize++)
					{
						String name = null, value = null;
						Locator currentChannel_trow = currentChannel_trows.nth(tr_rowSize);
						currentRow_tdata = currentChannel_trow.locator("td");
						for (int dataValue = 0; dataValue < currentRow_tdata.count(); dataValue += 2)
						{
							name = currentRow_tdata.nth(dataValue).textContent();
							value = currentRow_tdata.nth(dataValue + 1).textContent();
							channelMap.put(name, value);
							addMap = true;
						}
					}
					if (addMap)
					{
						analyticsOverviewChannelsCount.add(channelsHeadCount, channelMap);
					}

				}
			}
		}

//		clickElement("Details link,xpath,(//p[.='Details'])[" + channelsHeadCount1 + "]");

		for (int i = 0; i < analyticsOverviewChannelsCount.size(); i++)
		{
			Map<String, String> channelwise = analyticsOverviewChannelsCount.get(i);
			String currentChannel = channelwise.get("Channel").toLowerCase();
			if (currentChannel.contains("email"))
			{
				for (Map.Entry<String, String> entry : channelwise.entrySet())
				{
					emailChannelCommunicationAnalyticsOverviewPageCount.put(entry.getKey(), entry.getValue());
				}
			} else if (currentChannel.equalsIgnoreCase("mobile"))
			{
				for (Map.Entry<String, String> entry : channelwise.entrySet())
				{
					smsChannelCommunicationAnalyticsOverviewPageCount.put(entry.getKey(), entry.getValue());
				}
			} else if (currentChannel.contains("qr"))
			{
				for (Map.Entry<String, String> entry : channelwise.entrySet())
				{
					qrChannelCommunicationAnalyticsOverviewPageCount.put(entry.getKey(), entry.getValue());
				}
			} else if (currentChannel.contains("web"))
			{
				for (Map.Entry<String, String> entry : channelwise.entrySet())
				{
					webChannelCommunicationAnalyticsOverviewPageCount.put(entry.getKey(), entry.getValue());
				}
			} else if (currentChannel.contains("mobile push"))
			{
				for (Map.Entry<String, String> entry : channelwise.entrySet())
				{
					mobileChannelCommunicationAnalyticsOverviewPageCount.put(entry.getKey(), entry.getValue());
				}
			} else if (currentChannel.contains("whatsapp"))
			{
				for (Map.Entry<String, String> entry : channelwise.entrySet())
				{
					whatsappChannelCommunicationAnalyticsOverviewPageCount.put(entry.getKey(), entry.getValue());
				}
			}
		}
		System.out.println(emailChannelCommunicationAnalyticsOverviewPageCount);
		System.out.println(smsChannelCommunicationAnalyticsOverviewPageCount);
		System.out.println(qrChannelCommunicationAnalyticsOverviewPageCount);
		System.out.println(webChannelCommunicationAnalyticsOverviewPageCount);
		System.out.println(mobileChannelCommunicationAnalyticsOverviewPageCount);
		System.out.println(whatsappChannelCommunicationAnalyticsOverviewPageCount);

		return this;
	}

	public AnalyticsOverviewDetailsPage getDetailsPageEmailChannelDetails()
	{
		pageLoaderLogo();
		explicitwaitforvisibility(autolocator(AnalyticsRepository.analytics_ChannelDetailsTab), 30);
		clickElement(AnalyticsRepository.analytics_ChannelDetailsTab);
		pageLoaderLogo();

		threadSleep(ObjectRepository.wait3sec);
		// List<WebElement> channelDataTable;

		String Reachcount = getStrText(AnalyticsRepository.analytics_ChannelDetailsreachcount);
		int reachInt = Integer.parseInt(Reachcount);
		String Engagementcount = getStrText(AnalyticsRepository.analytics_ChannelDetailsengaementcount);
		int EngagementInt = Integer.parseInt(Engagementcount);

		String Conversioncount = getStrText(AnalyticsRepository.analytics_ChannelDetailsconversioncount);
		int ConversionInt = Integer.parseInt(Conversioncount);

		writeLog(reachInt == listingPageReach, "the reach count is same as csr page", "the reach count is not same as csr page");
		writeLog(EngagementInt == listingPageEngagement, "the Engagement count is same as csr page", "the reach count is not same as csr page");
		writeLog(ConversionInt == listingPageConversion, "the Conversion count is same as csr page", "the reach count is not same as csr page");

		System.out.println(emailAnalyticsDetailsPageCount);
		return this;
	}

	public AnalyticsOverviewDetailsPage pw_getDetailsPageEmailChannelDetails()
	{
		pw_pageLoaderLogo();
		pw_clickElement(AnalyticsRepository.analytics_ChannelDetailsTab);
		pw_pageLoaderLogo();

		String Reachcount = pw_getStrText(AnalyticsRepository.analytics_ChannelDetailsreachcount);
		int reachInt = Integer.parseInt(Reachcount);
		String Engagementcount = pw_getStrText(AnalyticsRepository.analytics_ChannelDetailsengaementcount);
		int EngagementInt = Integer.parseInt(Engagementcount);

		String Conversioncount = pw_getStrText(AnalyticsRepository.analytics_ChannelDetailsconversioncount);
		int ConversionInt = Integer.parseInt(Conversioncount);

		pw_writeLog(reachInt == listingPageReach, "the reach count is same as csr page", "the reach count is not same as csr page");
		pw_writeLog(EngagementInt == listingPageEngagement, "the Engagement count is same as csr page", "the reach count is not same as csr page");
		pw_writeLog(ConversionInt == listingPageConversion, "the Conversion count is same as csr page", "the reach count is not same as csr page");

		System.out.println(emailAnalyticsDetailsPageCount);
		return this;
	}

	public AnalyticsOverviewDetailsPage getDetailsPageSMSChannelDetails()
	{
		pageLoaderLogo();
		explicitwaitforvisibility(autolocator(AnalyticsRepository.analytics_ChannelDetailsTab), 30);
		threadSleep(ObjectRepository.wait3sec);
		List<WebElement> channelDataTable;
		String detailChannelxpath = "Detail SMS Channel,xpath,//ul[contains(@class,'resDetailTabStyle')]/li/a[contains(text(),'SMS')]";
		if (isEnabled(detailChannelxpath))
		{
			clickElement(detailChannelxpath);
			channelDataTable = findElements("Details page channel tab,xpath,//div[@id='Mobile' and @class='tab-pane active']/div");
			smsChannelCommunicationAnalyticsDetailsPageCount.put("Channel", "Mobile");
			// smsChannelCampaignAnalyticsDetailsPageCount.putAll(getEmailOverviewValuesFromDetailsPage(channelDataTable));
			// smsChannelCampaignAnalyticsDetailsPageCount.putAll(getEmailKeyMetricsValuesFromDetailsPage(channelDataTable));
		}
		// System.out.println(smsChannelCommunicationAnalyticsDetailsPageCount);
		return this;
	}

	public AnalyticsOverviewDetailsPage getDetailsPageWebChannelDetails()
	{
		pageLoaderLogo();
		explicitwaitforvisibility(autolocator(AnalyticsRepository.analytics_ChannelDetailsTab), 30);
		threadSleep(ObjectRepository.wait3sec);
		List<WebElement> channelDataTable;
		String detailChannelxpath = "Details Channel,xpath,//ul[contains(@class,'resDetailTabStyle')]/li/a[contains(text(),'Web')]";
		if (isEnabled(detailChannelxpath))
		{
			clickElement(detailChannelxpath);
			channelDataTable = findElements("Details page channel tab,xpath,//div[@id='Web' and @class='tab-pane active']/div");
			webChannelCommunicationAnalyticsDetailsPageCount.put("Channel", "Web");
			// webChannelCampaignAnalyticsDetailsPageCount.putAll(getEmailOverviewValuesFromDetailsPage(channelDataTable));
			// webChannelCampaignAnalyticsDetailsPageCount.putAll(getEmailKeyMetricsValuesFromDetailsPage(channelDataTable));
		}
		return this;
	}

	public AnalyticsOverviewDetailsPage getDetailsPageMobilepushChannelDetails()
	{
		pageLoaderLogo();
		explicitwaitforvisibility(autolocator(AnalyticsRepository.analytics_ChannelDetailsTab), 30);
		threadSleep(ObjectRepository.wait3sec);
		List<WebElement> channelDataTable;
		String detailChannelxpath = "Details Channel,xpath,//ul[contains(@class,'resDetailTabStyle')]/li/a[contains(text(),'Mobilepush')]";
		if (isEnabled(detailChannelxpath))
		{
			clickElement(detailChannelxpath);
			channelDataTable = findElements("Details page channel tab,xpath,//div[@id='Mobilepush' and @class='tab-pane active']/div");
			mobileChannelCommunicationAnalyticsDetailsPageCount.put("Channel", "Email");
			// mobileChannelCampaignAnalyticsDetailsPageCount.putAll(getEmailOverviewValuesFromDetailsPage(channelDataTable));
			// mobileChannelCampaignAnalyticsDetailsPageCount.putAll(getEmailKeyMetricsValuesFromDetailsPage(channelDataTable));

		}
		return this;
	}

	public AnalyticsOverviewDetailsPage getDetailsPageqrChannelDetails()
	{
		pageLoaderLogo();
		explicitwaitforvisibility(autolocator(AnalyticsRepository.analytics_ChannelDetailsTab), 30);
		threadSleep(ObjectRepository.wait3sec);
		List<WebElement> channelDataTable;
		String detailChannelxpath = "Details Channel,xpath,//ul[contains(@class,'resDetailTabStyle')]/li/a[contains(text(),'Mobilepush')]";
		if (isEnabled(detailChannelxpath))
		{
			clickElement(detailChannelxpath);
			channelDataTable = findElements("Details page channel tab,xpath,//div[@id='QR' and @class='tab-pane active']/div");
			qrChannelCommunicationAnalyticsDetailsPageCount.put("Channel", "Email");
			// qrChannelCampaignAnalyticsDetailsPageCount.putAll(getEmailOverviewValuesFromDetailsPage(channelDataTable));
			// qrChannelCampaignAnalyticsDetailsPageCount.putAll(getEmailKeyMetricsValuesFromDetailsPage(channelDataTable));
		}
		return this;
	}

	private Map<String, String> getEmailOverviewValuesFromDetailsPage()
	{
		Map<String, String> AnalyticsDetailsPageCount = new HashMap<String, String>();
		// WebElement overViewData = channelDataTable.get(3);
		// overViewData.findElement(By.xpath(xpathExpression)).click();
		AnalyticsDetailsPageCount.put("Reach", getStrText(AnalyticsRepository.analytics_DetailPage_Overview_Reach));
		AnalyticsDetailsPageCount.put("OpenPercent", getStrText(AnalyticsRepository.analytics_DetailPage_Overview_ReachOpenPercent));
		AnalyticsDetailsPageCount.put("ReachForwards", getStrText(AnalyticsRepository.analytics_DetailPage_Overview_ReachForwards));
		AnalyticsDetailsPageCount.put("ReachPerDay", getStrText(AnalyticsRepository.analytics_DetailPage_Overview_ReachPerDay));
		AnalyticsDetailsPageCount.put("Engagement", getStrText(AnalyticsRepository.analytics_DetailPage_Overview_Engagement));
		AnalyticsDetailsPageCount.put("UniqueClickPercent", getStrText(AnalyticsRepository.analytics_DetailPage_Overview_EngagementUniqueClick));
		AnalyticsDetailsPageCount.put("EngagementForwards", getStrText(AnalyticsRepository.analytics_DetailPage_Overview_EngagementForwards));
		AnalyticsDetailsPageCount.put("EngagementPerDay", getStrText(AnalyticsRepository.analytics_DetailPage_Overview_EngagementPerDay));
		AnalyticsDetailsPageCount.put("Conversion", getStrText(AnalyticsRepository.analytics_DetailPage_Overview_Conversion));
		AnalyticsDetailsPageCount.put("ConversionRegistration", getStrText(AnalyticsRepository.analytics_DetailPage_Overview_ConversionRegistration));
		AnalyticsDetailsPageCount.put("ConversionPerDay", getStrText(AnalyticsRepository.analytics_DetailPage_Overview_ConversionPerDay));
		return AnalyticsDetailsPageCount;
	}

	private Map<String, String> getSMSOverviewValuesFromDetailsPage(List<WebElement> channelDataTable)
	{
		Map<String, String> AnalyticsDetailsPageCount = new HashMap<String, String>();
		WebElement overViewData = channelDataTable.get(3);
		// overViewData.findElement(By.xpath(xpathExpression)).click();
		AnalyticsDetailsPageCount.put("Reach", getStrText(AnalyticsRepository.analytics_DetailPage_Overview_Reach));
		AnalyticsDetailsPageCount.put("Delivered", getStrText(",xpath,//li[contains(text(),'Delivered')]/span"));
		AnalyticsDetailsPageCount.put("ReachPerDay", getStrText(AnalyticsRepository.analytics_DetailPage_Overview_ReachPerDay));
		AnalyticsDetailsPageCount.put("Engagement", getStrText(AnalyticsRepository.analytics_DetailPage_Overview_Engagement));
		AnalyticsDetailsPageCount.put("LinkClickPercent", getStrText(",xpath,//li[contains(text(),'Link clicks')]/span"));
		AnalyticsDetailsPageCount.put("EngagementPerDay", getStrText(AnalyticsRepository.analytics_DetailPage_Overview_EngagementPerDay));
		AnalyticsDetailsPageCount.put("Conversion", getStrText(AnalyticsRepository.analytics_DetailPage_Overview_Conversion));
		AnalyticsDetailsPageCount.put("ConversionRegistration", getStrText(AnalyticsRepository.analytics_DetailPage_Overview_ConversionRegistration));
		AnalyticsDetailsPageCount.put("ConversionPerDay", getStrText(AnalyticsRepository.analytics_DetailPage_Overview_ConversionPerDay));
		return AnalyticsDetailsPageCount;
	}

	private Map<String, String> getEmailKeyMetricsValuesFromDetailsPage()
	{
		Map<String, String> AnalyticsDetailsPageCount = new HashMap<String, String>();
		javaScriptScrollIntoView(AnalyticsRepository.analytics_DetailPage_CommunicationOverview);
		// WebElement overViewData = channelDataTable.get(5);
		explicitwaitforvisibility(autolocator(",xpath,//h4[text()='Key metrics']/..//div[1]/p[text()='Total sent']/../h3/span[1]"), 30);
		AnalyticsDetailsPageCount.put("KeyMetricsTotalAudience", getStrText(AnalyticsRepository.analytics_DetailPage_KeyMetrics_TotalAudience));
		AnalyticsDetailsPageCount.put("KeyMetricsDelivered", getStrText(AnalyticsRepository.analytics_DetailPage_KeyMetrics_Delivered));
		List<WebElement> userEngagementlist = findElements(AnalyticsRepository.analytics_DetailPage_UserEngagementList);
		for (WebElement currentkeyvalue : userEngagementlist)
		{
			String key = currentkeyvalue.findElement(By.tagName("span")).getText();
			String value = currentkeyvalue.findElement(By.tagName("h3")).getText();
			AnalyticsDetailsPageCount.put(key, value);
		}
		List<WebElement> negativefeedback = findElements(AnalyticsRepository.analytics_DetailPage_Negativefeedback);
		for (WebElement currentkeyvalue : negativefeedback)
		{
			String key = currentkeyvalue.findElement(By.tagName("span")).getText();
			String value = currentkeyvalue.findElement(By.tagName("h3")).getText();
			AnalyticsDetailsPageCount.put(key, value);
		}

		clickElement(AnalyticsRepository.analytics_DetailPage_KeyMetrics_DeliveredDataIcon);
		List<WebElement> keymetricpopup = findElements(AnalyticsRepository.analytics_DetailPage_KeyMetrics_DeliveredDatapopuplist);
		for (WebElement currentkeyvalue : keymetricpopup)
		{
			String key = currentkeyvalue.findElement(By.xpath("span[1]")).getText();
			String value = currentkeyvalue.findElement(By.xpath("span[2]")).getText().replaceAll("[^A-Za-z0-9]", "");
			AnalyticsDetailsPageCount.put(key, value);
		}
		clickElement(AnalyticsRepository.analytics_DetailPage_KeyMetrics_DeliveredDatapopupClose);

		clickElement("KeyMatrix Total send Icon,xpath,//*[text()='Total sent']/..//following-sibling::a");
		List<WebElement> totalSendpopup = findElements("pre-comm ,xpath,//*[text()='Pre-communication scrubbed before publish']/..//ul[@class='list-clear']//li");
		for (WebElement currentkeyvalue : totalSendpopup)
		{
			String key = currentkeyvalue.findElement(By.xpath("span[1]")).getText();
			String value = currentkeyvalue.findElement(By.xpath("span[2]")).getText().replaceAll("[^A-Za-z0-9]", "");
			AnalyticsDetailsPageCount.put(key, value);
		}
		clickElement("Cancel,xpath,//div[contains(@class,'AudiencePotentialCountView info-popup serOn')]/a");

		return AnalyticsDetailsPageCount;
	}

	private void detailsPagePDFDownload()
	{
		explicitwaitforvisibility(autolocator(AnalyticsRepository.analytics_DetailPage_DownloadLink), 30);
		clickElement(AnalyticsRepository.analytics_DetailPage_DownloadLink);
		explicitwaitforvisibility(autolocator(AnalyticsRepository.analytics_DetailPage_DownloadListPDFselect), 10);
		clickElement(AnalyticsRepository.analytics_DetailPage_DownloadListPDFselect);
	}

	private void getDatesFromDetailsPage(String commName) throws ParseException
	{
		String getCommunicationName = getStrText(AnalyticsRepository.analytics_DetailPage_getCommunicationName);
		if (getCommunicationName.equalsIgnoreCase(commName))
		{
			BaseTest.getTest().info("Details page communication name matched with user communication");
		} else
		{
			BaseTest.getTest().fail("Details page communication name not matched with user communication");
			BaseTest.getTest().info("User communication:" + commName);
			BaseTest.getTest().info("Result communication:" + getCommunicationName);
		}
		String getCommDates = getStrText(AnalyticsRepository.analytics_DetailPage_getCommunicationDates);
		String[] splitDates = getCommDates.split("-");

		Date date1 = new SimpleDateFormat("dd-MMM-yyyy").parse(splitDates[0]);
	}

	// Overview Page
	private Map<String, String> getOverviewPageSummaryCount(String xpathReachInOverview)
	{
		Map<String, String> getOverviewSummary = new HashMap<String, String>();
		WebElement currentElement = BaseTest.getWebDriver().findElement(autolocator(xpathReachInOverview));
		currentElement.findElement(By.xpath(".//i[@id='rs_OverviewCard_arrow_right']")).click();
		String csrTotalSent = getStrText(AnalyticsRepository.analytics_CSR_Overviewtotalsent).replaceAll("[^0-9]", "");
		getOverviewSummary.put("Total sent", csrTotalSent);
		getOverviewSummary.put(currentElement.findElement(By.xpath(".//p[contains(@class,'position-relative lh-sm')]")).getText(), currentElement.findElement(By.xpath(".//h1")).getText());
		getOverviewSummary.put("Percentage", StringUtils.substringBetween(currentElement.findElement(By.xpath(".//span")).getText(), "(", ")"));
		List<WebElement> summaryList = currentElement.findElements(By.xpath(".//li//div[contains(@class,'rs-tooltip-wrapper')]"));
		for (WebElement presentList : summaryList)
		{
			try
			{
				String channel = "";
				mouseHover(presentList.findElement(By.xpath(".//i[@id='rs_icon']")));
				channel = getStrText(DashboardRepository.allpage_tooltip);
				if (getOverviewSummary.containsKey(channel))
				{
					channel += " ratio";
				}
				String channelValue = presentList.findElement(By.xpath(".//ancestor::li//p")).getText();
				getOverviewSummary.put(channel, channelValue);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		currentElement.findElement(By.xpath(".//i[@id='rs_circle_close_edge']")).click();
		return getOverviewSummary;
	}

	public Map<String, String> pw_getOverviewPageSummaryCount(String xpathReachInOverview)
	{
		Map<String, String> getOverviewSummary = new HashMap<String, String>();
		Locator currentElement = pw_findelements(xpathReachInOverview);
		currentElement.locator("//i[@id='rs_OverviewCard_arrow_right']").click();
		String csrTotalSent = pw_getStrText(AnalyticsRepository.pw_analytics_csrOverviewtotalsent).replaceAll("[^0-9]", "");
		getOverviewSummary.put("Total sent", csrTotalSent);
		getOverviewSummary.put(currentElement.locator("//p[contains(@class,'position-relative lh-sm')]").textContent(), currentElement.locator("//h1").textContent());
		getOverviewSummary.put("Percentage", StringUtils.substringBetween(currentElement.locator("//span").textContent(), "(", ")"));
		Locator summaryList = currentElement.locator("//li//div[contains(@class,'rs-tooltip-wrapper')]");
		if (!getOverviewSummary.get("Percentage").equals("0%"))
		{
			for (int i = 0; i < summaryList.count(); i++)
			{
				try
				{
					String channel = "";
					summaryList.nth(i).locator("//i[@id='rs_icon']").hover();
					channel = pw_getStrText(DashboardRepository.pw_allpage_tooltip);
					if (getOverviewSummary.containsKey(channel))
					{
						channel += " ratio";
					}
					String channelValue = summaryList.nth(i).locator("//ancestor::li//p").textContent();
					getOverviewSummary.put(channel, channelValue);
				} catch (Exception e)
				{
				}
			}
		}
		currentElement.locator("//i[@id='rs_circle_close_edge']").click();
		return getOverviewSummary;
	}

	public Map<String, String> overviewPortletChannelViseCount()
	{
		String value;
		toolTipValidationKnownText(AnalyticsRepository.csrPageOverview_I_icon, "Info");
		clickElement(AnalyticsRepository.csrPageOverview_I_icon);
		threadSleep(ObjectRepository.wait1sec);
		pageLoaderLogo();
		clickElement(AnalyticsRepository.csrPageOverview_Info_channelDropdown);
		List<WebElement> dropdownValues = findElements(AnalyticsRepository.csrPageOverview_Info_dropdownValue);
		for (WebElement dropdownValue : dropdownValues)
		{
			String ChannelName = dropdownValue.getText();
			dropdownValue.click();
			overviewInfoChannelViseDetails.put("ChannelName", ChannelName);
			List<WebElement> detailsCounts = findElements(AnalyticsRepository.csrPageOverview_Info_detailsCounts);
			for (int i = 0; i < detailsCounts.size(); i += 2)
			{
				String key = detailsCounts.get(i).getText();
				value = detailsCounts.get(i + 1).getText();
				if (value.contains("("))
				{
					value = StringUtils.substringBetween(detailsCounts.get(i + 1).getText(), "(", ")");
				}
				overviewInfoChannelViseDetails.put(key, value);
			}
			clickElement(AnalyticsRepository.csrPageOverview_Info_channelDropdown);
		}
		clickElement(AnalyticsRepository.csrPageOverview_I_icon);
		threadSleep(ObjectRepository.wait1sec);
//		clickElement(AnalyticsRepository.csrPageOverview_Info_closeicon);
		return overviewInfoChannelViseDetails;
	}

	public Map<String, String> pw_overviewPortletChannelViseCount()
	{
		String value;
		pw_scrollIfNeeded(AnalyticsRepository.pw_analytics_csrPageOverview_I_icon);
		threadSleep(ObjectRepository.wait1sec);
		pw_toolTipValidationKnownText(AnalyticsRepository.pw_analytics_csrPageOverview_I_icon, "Info");
		pw_clickElement(AnalyticsRepository.pw_analytics_csrPageOverview_I_icon);
		threadSleep(ObjectRepository.wait1sec);
		pw_pageLoaderLogo();
		pw_clickElement(AnalyticsRepository.pw_analytics_csrPageOverview_Info_channelDropdown);
		Locator dropdownValues = pw_findelements(AnalyticsRepository.pw_analytics_csrPageOverview_Info_channelDropdown);
		for (int i = 0; i < dropdownValues.count(); i++)
		{
			String ChannelName = dropdownValues.nth(i).textContent();
			dropdownValues.nth(i).click();
			overviewInfoChannelViseDetails.put("ChannelName", ChannelName);
			Locator detailsCounts = pw_findelements(AnalyticsRepository.pw_csrPageOverview_Info_detailsCounts);
			for (int j = 0; j < detailsCounts.count(); j += 2)
			{
				String key = detailsCounts.nth(j).textContent();
				value = detailsCounts.nth(j + 1).textContent();
				if (value.contains("("))
				{
					value = StringUtils.substringBetween(detailsCounts.nth(j + 1).textContent(), "(", ")");
				}
				overviewInfoChannelViseDetails.put(key, value);
			}
			pw_clickElement(AnalyticsRepository.pw_analytics_csrPageOverview_Info_channelDropdown);
		}
		pw_clickElement(AnalyticsRepository.pw_analytics_csrPageOverview_I_icon);
		threadSleep(ObjectRepository.wait1sec);
		return overviewInfoChannelViseDetails;
	}

	public void validateEmailAnalyticsSentCount()
	{
		if (!emailChannelCommunicationAnalyticsListingPageCount.isEmpty() && !emailChannelCommunicationAnalyticsOverviewPageCount.isEmpty() && !emailAnalyticsDetailsPageCount.isEmpty())
		{
			String totalSentList = emailChannelCommunicationAnalyticsListingPageCount.get("Total sent").toString();
			String totalSentOverview = emailChannelCommunicationAnalyticsOverviewPageCount.get("Sent count");
			String totalAudienceDetails = emailAnalyticsDetailsPageCount.get("KeyMetricsTotalAudience");
			if (!totalSentList.isEmpty() && !totalSentList.equalsIgnoreCase("NA") && !totalSentOverview.isEmpty() && !totalSentOverview.equalsIgnoreCase("NA") && !totalAudienceDetails.isEmpty() && !totalAudienceDetails.equalsIgnoreCase("NA"))
			{
				int totalSentList1 = Integer.parseInt(totalSentList);
				int totalSentOverview1 = Integer.parseInt(totalSentOverview);
				int totalAudienceDetails1 = Integer.parseInt(totalAudienceDetails);
				if (totalSentList1 == totalSentOverview1 && totalSentList1 == totalAudienceDetails1)
				{
					BaseTest.getTest().info("Total sent values are equal for listing,overview and details page. Sent count:" + totalSentList1);
				} else
				{
					BaseTest.getTest().fail("Total sent values are not equal for listing,overview and details page. Sent count:" + totalSentList1 + ":" + totalSentOverview1 + ":" + totalAudienceDetails1);
				}

			}
		} else if (!emailChannelCommunicationAnalyticsListingPageCount.isEmpty() && !emailChannelCommunicationAnalyticsOverviewPageCount.isEmpty() || !emailAnalyticsDetailsPageCount.isEmpty())
		{
			String totalSentList = emailChannelCommunicationAnalyticsListingPageCount.get("Total sent").toString();
			String totalSentOverview = emailChannelCommunicationAnalyticsOverviewPageCount.get("Sent count");

			if (!totalSentList.isEmpty() && !totalSentList.equalsIgnoreCase("NA") && !totalSentOverview.isEmpty() && !totalSentOverview.equalsIgnoreCase("NA"))
			{
				int totalSentList1 = Integer.parseInt(totalSentList);
				int totalSentOverview1 = Integer.parseInt(totalSentOverview);
				if (totalSentList1 == totalSentOverview1)
				{
					BaseTest.getTest().info("Total sent values are equal for listing,overview and details page. Sent count:" + totalSentList1);
				} else
				{
					BaseTest.getTest().fail("Total sent values are not equal for listing,overview and details page. Sent count:" + totalSentList1 + ":" + totalSentOverview1);
				}
			}
		}
	}

	public void pw_validateEmailAnalyticsSentCount()
	{
		if (!emailChannelCommunicationAnalyticsListingPageCount.isEmpty() && !emailChannelCommunicationAnalyticsOverviewPageCount.isEmpty() && !emailAnalyticsDetailsPageCount.isEmpty())
		{
			String totalSentList = emailChannelCommunicationAnalyticsListingPageCount.get("Total sent").toString();
			String totalSentOverview = emailChannelCommunicationAnalyticsOverviewPageCount.get("Sent count");
			String totalAudienceDetails = emailAnalyticsDetailsPageCount.get("KeyMetricsTotalAudience");
			if (!totalSentList.isEmpty() && !totalSentList.equalsIgnoreCase("NA") && !totalSentOverview.isEmpty() && !totalSentOverview.equalsIgnoreCase("NA") && !totalAudienceDetails.isEmpty() && !totalAudienceDetails.equalsIgnoreCase("NA"))
			{
				int totalSentList1 = Integer.parseInt(totalSentList);
				int totalSentOverview1 = Integer.parseInt(totalSentOverview);
				int totalAudienceDetails1 = Integer.parseInt(totalAudienceDetails);
				if (totalSentList1 == totalSentOverview1 && totalSentList1 == totalAudienceDetails1)
				{
					BaseTest.getTest().info("Total sent values are equal for listing,overview and details page. Sent count:" + totalSentList1);
				} else
				{
					BaseTest.getTest().fail("Total sent values are not equal for listing,overview and details page. Sent count:" + totalSentList1 + ":" + totalSentOverview1 + ":" + totalAudienceDetails1);
				}

			}
		} else if (!emailChannelCommunicationAnalyticsListingPageCount.isEmpty() && !emailChannelCommunicationAnalyticsOverviewPageCount.isEmpty() || !emailAnalyticsDetailsPageCount.isEmpty())
		{
			String totalSentList = emailChannelCommunicationAnalyticsListingPageCount.get("Total sent").toString();
			String totalSentOverview = emailChannelCommunicationAnalyticsOverviewPageCount.get("Sent count");

			if (!totalSentList.isEmpty() && !totalSentList.equalsIgnoreCase("NA") && !totalSentOverview.isEmpty() && !totalSentOverview.equalsIgnoreCase("NA"))
			{
				int totalSentList1 = Integer.parseInt(totalSentList);
				int totalSentOverview1 = Integer.parseInt(totalSentOverview);
				if (totalSentList1 == totalSentOverview1)
				{
					BaseTest.getTest().info("Total sent values are equal for listing,overview and details page. Sent count:" + totalSentList1);
				} else
				{
					BaseTest.getTest().fail("Total sent values are not equal for listing,overview and details page. Sent count:" + totalSentList1 + ":" + totalSentOverview1);
				}
			}
		}
	}

	public void moveToElement(String pr)
	{
		Actions action = new Actions(BaseTest.getWebDriver());
		action.moveToElement(driver.findElement(autolocator(pr))).build().perform();
		BaseTest.getTest().log(Status.INFO, BaseTest.logName.get());
	}

	public void analyticsCSRPageNavigation(String commname)
	{
		clickElement(",xpath,//h4[starts-with(.,'" + commname + "')]//..//..//following::td[@role='gridcell'][5]//ul//i[@title='View analytics']//..");
	}

	public void analyticsCSRPageValidation()
	{
		if (isDisplayed(AnalyticsRepository.analytics_demographic_agetext))
		{
			String agevalue = getStrText(AnalyticsRepository.analytics_demographic_agetext);
			if (agevalue.contains("under"))
			{
				BaseTest.getTest().log(Status.FAIL, "By age text present in 'UNDER' text");
			} else
			{
				BaseTest.getTest().log(Status.INFO, "By age text is not-present in 'UNDER' text");
			}
			String highestreachgender = getStrText(AnalyticsRepository.analytics_demographic_highestreachtext);
			if (agevalue.contains("Highest reach by Female") || agevalue.contains("Highest reach by Male"))
			{
				BaseTest.getTest().log(Status.INFO, "Actual text present--->" + agevalue);
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Actual text is not-present--->" + agevalue);
			}
			compareUiwithInputvalue(highestreachgender, "Highest reach by Female");
		}
		List<WebElement> element = findElements(",xpath,//div[@class='no-data-overlay']//..");
		for (WebElement ment : element)
		{
			String text = ment.getText();
			if (text.contains("No data available"))
			{
				System.out.println("pass");
			}
		}
		if (isDisplayed(AnalyticsRepository.analytics_page_edm_image))
		{
			String textValue = getTextBoxVal(AnalyticsRepository.analytics_page_edm_image, "src");
			if (textValue.equals(
					"data:image/jpeg;base64,/9j/4QAYRXhpZgAASUkqAAgAAAAAAAAAAAAAAP/sABFEdWNreQABAAQAAABkAAD/4QMxaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLwA8P3hwYWNrZXQgYmVnaW49Iu+7vyIgaWQ9Ilc1TTBNcENlaGlIenJlU3pOVGN6a2M5ZCI/PiA8eDp4bXBtZXRhIHhtbG5zOng9ImFkb2JlOm5zOm1ldGEvIiB4OnhtcHRrPSJBZG9iZSBYTVAgQ29yZSA1LjYtYzE0NSA3OS4xNjM0OTksIDIwMTgvMDgvMTMtMTY6NDA6MjIgICAgICAgICI+IDxyZGY6UkRGIHhtbG5zOnJkZj0iaHR0cDovL3d3dy53My5vcmcvMTk5OS8wMi8yMi1yZGYtc3ludGF4LW5zIyI+IDxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSIiIHhtbG5zOnhtcD0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLyIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bXA6Q3JlYXRvclRvb2w9IkFkb2JlIFBob3Rvc2hvcCBDQyAyMDE5IChNYWNpbnRvc2gpIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOjc3MkNEMTgzNEQyNzExRTk4NzAyRjg1NEY2MEY3MEQ0IiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOjc3MkNEMTg0NEQyNzExRTk4NzAyRjg1NEY2MEY3MEQ0Ij4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6NzcyQ0QxODE0RDI3MTFFOTg3MDJGODU0RjYwRjcwRDQiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6NzcyQ0QxODI0RDI3MTFFOTg3MDJGODU0RjYwRjcwRDQiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz7/7gAOQWRvYmUAZMAAAAAB/9sAhAABAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAgICAgICAgICAgIDAwMDAwMDAwMDAQEBAQEBAQIBAQICAgECAgMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwP/wAARCAD6AOYDAREAAhEBAxEB/8QAoAABAAIDAQEBAQAAAAAAAAAAAAYHBAUIAgMBCgEBAAMBAQAAAAAAAAAAAAAAAAECAwQFEAABBQABAwICBwUHBQEAAAAAAQIDBAUGERIHIRMxFEEi5BVmlhfUlRZWR1EzxLU2d4eBMkIjQ8YRAQABAgMEBwYGAgMAAAAAAAABEQIxEgMhYZETQVGBsSJiBPCh4TJCUsFygjNDc3HRI4NE/9oADAMBAAIRAxEAPwD+7c1ZAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQ7b5nUxNWPG+5+Q696TPZp+3iZ8d/sqPsy1e+RvzUUze2aLoq9vanc316r0NrNGb7c9bYtrTbNETdSabWv/AFA/BPkH8t/bS3I8+nxRm3SfqB+CfIP5b+2jkefT4mbdJ+oH4J8g/lv7aOR59PiZt0n6gfgnyD+W/to5Hn0+Jm3SfqB+CfIP5b+2jkefT4mbdJ+oH4J8g/lv7aOR59PiZt0n6gfgnyD+W/to5Hn0+Jm3SyM7ndS9r5+NNgcpybWn838nJs5UdCvJ8lWfasdrnXHyP7I2Ii9rXdHOb16IvUi7Qm2yb4utmI6pqmLttKSnJgkAAAAAAAAAAAAAAAAAAAAAAqHk80tfmHIZ4JZIJ4PEWtNDNC90csMsepYfHLFIxWvjkje1Fa5FRUVOqHXpxE6VsThzY7lJ+afyuef4t5V/M3If31pftJ38rS+23hDOs9cn8W8q/mbkP760v2kcrS+23hBWeuT+LeVfzNyH99aX7SOVpfbbwgrPXJ/FvKv5m5D++tL9pHK0vtt4QVnrk/i3lX8zch/fWl+0jlaX228IKz1yfxbyr+ZuQ/vrS/aRytL7beEFZ65P4t5V/M3If31pftI5Wl9tvCCs9crq4zbt3rHh+1etWLlqX9QPds2ppLFiTsZYjZ7k0znyP7I2I1Oqr0aiJ8EOPUiLY1YtikeFePp7V9HC0AAAAAAAAAAAAAAAAAAAAAAKd5b/AKq5N/s7tf5lZOvS/at/ujuUnGfyuXT02QAAAfatGyaxXhlkSGOWeKOSVfhEx8jWvkXr6dGNXr/0InZFYxHZ7OB8RbmJlph57oPZ9tZ3V41vOXt6e+t/t+a99fj3o5On0enoeRz9XNmzTX3cG+W2lHGuhBFVv3a0EvvwV7dmCGZOipNFDM+OOVFT0/8AYxqL6f2nrWzM2xM40YL34d/Rv/kP/FHFrfzfoaW/T2ugjgaAAAAAAAAAAAAAAAAAAAAAAFO8t/1Vyb/Z3a/zKydel+1b/dHcpOM/lcunpsls+OvHUvI5Y9fXjfDhRP6xxr3Mk1JGO9Y41To5lNrk6Penq5fqt9eqt5PUeo5fgs+fu+K9ttds4Nx5H8Z/d/vb3HYFWgndLfzYmqq0fpdZqMTqq0/pexP7r4p9T0ZX0/qc3g1Pm6J603WU2xgo47WYBKW825WzN+6W7l1KHtewkXdH7iQ9vZ7LbXt/NtiRn1e1H9O30+BlydLNnyxmTmmlOhFjVDoLh39G/wDkP/FHBrfzfoaW/T2ugjgaAAAAAAAAAAAAAAAAAAAAAAFO8t/1Vyb/AGd2v8ysnXpftW/3R3KTjP5VbeOvHUvIpY9fXjfDhRP6xxr3Mk1JGO9Y41To5lNrk6Penq5fqt9eqt6PUeo5cZLPn7virbbXbODqeKKKCKOGGNkUMTGxxRRtayOONjUaxjGNRGsYxqdERPREPNx2zi1e1Tr6L6ovoqKQOdfJHjP5b3+Qccg61/rTaOXC31r/APk+3SY34wfS+NP7v4t+r1Rvoen9RX/j1MeiWd1nTDU+OfGz9x0O3uRPjxmuR9Wq7qyTUc1fRzvg5lFFT1X4yfBPT1L+o9Rk8Fnz93xRbbXbOCYeRPGMd5km1xusyK9GzuuZcDGxxXGMb/e1ImIjY7bWp6sRESX6Pr/9+Pp/U5fBqT4eta6zphza5qtVWuRWuaqtc1yKitVF6Kiovqiop6LJ0Dw7+jf/ACH/AIo4Nb+b9DS36e10EcDQAAAAAAAAAAAAAAAAAAAAAAra1Vgu+S7NK1Gkta342mq2IlVzUkgsb7opY1c1WuRHxvVOqKinTEzb6eJjGNT8Ffq7FixRRQRRwwxsihiY2OKKNrWRxxsajWMYxqI1rGtToiJ6IhzzMzNZxWfQgAAHlrUaiNaiNa1Ea1rUREaiJ0RERPRERAPQFL+RvGrNhs25gwtj1mo6S5SYiNZponq6WJPRrLyJ8fol+n63q7s9P6jJ4L/l6N3wUusrtjFpuIsfG/w7HI1zHsd5EY9j2q17HtW0jmuaqIrXNVOiovqil9X+X9CLfp7XQJwNAAAAAAAAAAAAAAAAAAAAAACvv6q/8ff/AKM6P/L/ANn4K/X2LBOdYAAAAAABXnIGMZzvxyjGtYiu5k9Ua1Gor5MmKSRyoiInc97lcq/FVVVOjT/Y1P096s/NHasM51gAAAAAAAAAAAAAAAAAAAAACHbfDKm3qx7P3xyHIvR57Mz3MTQjod9RlmW12SO+Vlmd3TS9VTu7V7W+nVOptZrTZbkpbNta7YqibazXa1/6f/jbyD+ZPsRbn+TT4Iy75P0//G3kH8yfYhz/ACafAy75P0//ABt5B/Mn2Ic/yafAy75P0/8Axt5B/Mn2Ic/yafAy75P0/wDxt5B/Mn2Ic/yafAy75P0//G3kH8yfYhz/ACafAy75P0//ABt5B/Mn2Ic/yafAy75ZGdwSpR18/Zm3+U61rM+b+Tj2dWO/Xj+drPq2O1rqbJGd8b0Ve1zermt69UToRdrzdZNkW2xE9UUTFu2tZTkwSAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAMLRsPqZ963GjXSVadqxG16KrFfDA+RiPRrmuVqub69FRen0kxFZiBXGJ5SxX8f4/c5DPJBtanFaPKbtHGwuQakdehYSRk11sedT1ZIKMM8L0c6R6+2iIr1RFRV1u0rs0xb8sTTbMIzRTbikebz/iWvZjq0dVznT0rOjVsWc7UoZ96jS7PnLedqX6VbN0oKqPRZHQSyIxOqr06L0pOnfbjBWH7l884psSTRU9N7VhzJdruv5urkwz40L0jm1qNjVo0oNDMjc5O6eB0kSI5F7uip1Tp3xjHTTr2prDHoeR+HaM6V4NSeGR2Ta3mO0cfcyIJcWn7fzGtDa1c2lWmz2pKnbMx6senXtVe13SZ074itOmmMYorDZYfL8DkU0tbKt2H2Iqte+te7l62RPNQtK5tbQqRa9GjJdz5nMVGzwpJEq9PreqEXWXW7ZwTExLX3vInEM3Qv5l3Tnis5VqlT1Xpj7c1DLn0Y60tFNLVgzZMuhFbbcj7JJZmRuVVTu6tciTGnfMViNk74RWH2vc84rm6M+Xc03x2ak9OrelZnatjNzbOgjHUoNTYr0ZcjLmstkarG2J4lVHJ/ahEad8xWI2e3QVh8OPc2q8h5Fynj8OdpVX8as1IEtWs7XrRXWWKFO3K963cqnBSljmt9kUTpXvswtSePrE5FJusm22LqxtIms0ZFvnfFaOo7Hs6b2W4rtTNsSMztSbNp6N9GOpUL+1BSkxqFyykjeyKaeN69zfT1TrEad8xWI2e3QVhkR8x43NDRmj0u5uju2uNVGfKXm2H7lKW5DcoS1XVUs1nVnUJVe+VjImsZ3q7sVrlZLurCK9iaw10HkPit5LDM7S9+Vmbo6lN9mhs0c7TqZjVW3YzNSbLdV1q0DunuPpfNK1q9Ua74E8u+MY6d3txRWEYz/IHfyK1c09SpU4onjbi3LGJGjpakNra0NGN1ivbsZmfsWm2YWwxxRyQxPevb0hZI5Wlp0/DSI8eaY9uhETt3PXMfIlSHimnq8d0rFO7jbfFauoy9jXaOhRqam5mQzpYyN3NguMju5k0ntv9j6ydVjXuTqizT8cRdhMT07txM7NhyryDDJkQzcW0bFbQq8v4fka1a9j287QrU9vUrRvisZfIc6tbgiv0nu9uX2k7kRVY7q1VRZp+LxxspPT1f4TM9SYu5xxhmt9yu0n/O/eMeOsiZ+m7MbsSsSSLIfuNpLis1XtVOlZbCTKq9O3r6FMl1M1NlPd/jErGCWFEgAAAAAAAAAAAAAMLRrvt596pGrWyWqdqvG56qjEfNA+NivVrXORqOd69EVen0ExNJiRVXGPH21itopatZcny3i2hwiT5ea2/rq1bd2xJYZ7lKLrnqyy1EevSTqi9Y0+K7Xalt2FfnqiIpwfkXj7fip+NYYdDMrWuGcS3cK7ab79lqaOlx2lk07dCvNUYy5Wr3Kyve2b2Vczp6KqqiRzLa3bJpdMT76oiJ2IwvjDkll9izyO/E2s7gXJONadyPlXL+Yadm7qw0nSbFOjrZ0EFKKR9RyrRqManwaiy9Woy/NtjZbjmicIjs+JSenqaCKte8lbFXCdf49JVr+MNzEsa/E7t3VrUrenYxo6rtWO3mZSZVuytFVXNXvniZG9HPTqnbasaVtdtc0TSfb3oxmm5bPDeHaWRr/fGvUoRW4cNcWOzBzDm/LLE7ZbVW1YWJOUzsrY9B8lNjkrsZYkR3/36IqPxvvibcsYVrhEd3tuWiOmWDt8A2NKh5SqwWcxknN72TayllmtNZXjoZePRmTQVlOR0T3S571b7aSorVb1VFVUSbdS2Jsx8NSmO9i63AuTz1ebccz58BePc52J9W1p3ZrrNrHbpw04daCDNizpqWq/pU61pH2qyxd3RyO7WkxqW1tumua2OySk4dEphhcf1MflnLdFVoz4vI/ue5DMtyz97Vb2Vj5+ItWam6itaetPDTWX30tI9r/qrEqL3pS66JsiPqiv+yI2oFyrx9zLeva/boUrNG3v4upmSWuV8nzq2dm5tzMvS5LuIZtCTj1yeSzUlelyd80jnvR3a16NczSzUstiNm2k9Ed+PYiYmUjr8BuQc70uRJerNw5Yb+llZvY+WajyvZo0snW03wyRJA6u/Pz+rGpJ1dJan6oiKnWk6kTpxb9X4Qmm2vQh1bxpzWW5k2tbQoW7Gfj8pzr2hZ5fyvZfqWt3GsZ9e/Xx9HOjyOPRNne33K9VvRsa+j39jWrpzbIiYtjZMx0RGE+9FJZkfjbl1Okjc3YzKGjF414Rw+K1BZusemnxq8+zprHY+7nS06d6s9YobTGOsROd7ntIrURY5lkztiaZpniUn3MKXxhyyeHmD2y49Szv2fH9jOhu8p5XypKi8Q27GlbZe19ygmnYZYimT2msRrUd1Z0Yn11c2yJtx2V6IjGOqDLLabHj7lHItC9u6MmBn6VrT4KsOdRv6FyjXyOJ7E2rafNoS49Ce5pXX2npGi1o2Rta1qvVFVyLdS22MsVmKT7+0pOLxB4u0a2tYY9lLTxbHMH8rZbvcu5vXlrOm0/vh8LuH0LEPG7t+rc9IbTpo0Xo10kT3IqOc2Jjquy0wjvxMq8znWAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAP/Z"))
			{
				BaseTest.getTest().log(Status.FAIL, "EDM Image preview is not shown");
				BaseTest.takeScreenshot();
			} else
			{
				BaseTest.getTest().log(Status.INFO, "EDM Image preview is shown");
				BaseTest.takeScreenshot();
			}

		}
	}

	public void analyticsDetailsPageNavigateValidation(String channelname)
	{
		clickElement(AnalyticsRepository.analytics_listing_substatus_plusicon);
		threadSleep(ObjectRepository.wait2sec);
		clickElement(AnalyticsRepository.analytics_listing_substatus1_detailsicon);
		clickElement(",xpath,//i[contains(translate(@title,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'), '" + channelname + "') and (not(contains(@title,'nalytics')))]//..//..//following-sibling::td//ul//li//i[@title='Report']");
	}

	public void analyticsDetailPageValidation()
	{
		clickElement(AnalyticsRepository.analytics_moredetailsbtndown);
		threadSleep(ObjectRepository.wait1sec);
		javaScriptScrollIntoView(",xpath,//div[@class='clear resCSRTabStyle']");
		clickElement(AnalyticsRepository.analytics_detailspage);
		List l = new ArrayList<>();
		List<WebElement> totallinkdata = findElements(AnalyticsRepository.analytics_totallinktabledata);
		for (WebElement element : totallinkdata)
		{
			String data = element.getText();
			l.add(data);
		}
		clickElement(AnalyticsRepository.analytics_csvdownloadpage);
		ArrayList<Object> filehandle = filehandle();
		String[] split = filehandle.get(1).toString().split("\\R");
		String[] exactdata = split[1].split(",");
		for (int i = 0; i < exactdata.length; i++)
		{
			String exceldata = exactdata[i];
			for (int j = 0; j < l.size(); j++)
			{
				Object object = l.get(j);
				String uidata = object.toString();
				if (exceldata.equals(uidata))
				{
					BaseTest.getTest().log(Status.INFO, "Exceldata is ---> " + exceldata + " equal to the UIdata " + uidata);
				}
			}
		}

		List<WebElement> activityLinks = findElements(",xpath,//div[@id='LinkClickListGrid']//tbody//tr//td[2]");
		for (WebElement element : activityLinks)
		{
			String links = element.getText();
			if (links.contains(";"))
			{
				BaseTest.getTest().log(Status.FAIL, "Semicolon(;) is presented in the text ---> " + links);
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Semicolon(;) is not-presented in the text ---> " + links);
			}
		}
		clickElement(",xpath,//a[@data-original-title='Click map']//i[@class='icon-view-small icon-sm blue']");
		String text = getStrText(",xpath,//div[@class='resTotalClicksDiv resTotalClicksDiv-1'][@id='heatMapMark-0']");
		if (!text.isEmpty())
		{
			BaseTest.getTest().log(Status.INFO, "Heatmap is present ---> " + text);
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Heatmap is not-present");
		}
	}

	// Analytics Regression - Mkstr

	public AnalyticsOverviewDetailsPage overViewDashboard()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("ANALYTICS DETAILS - Overview Dashboard", ExtentColor.BROWN));
		List<WebElement> primaryGoal, goalCount, percentages;
		pageLoaderLogo();
		explicitwaitforvisibility(autolocator(AnalyticsRepository.analytics_overviewDashboard), 60);
		clickElement(AnalyticsRepository.analytics_details_overview_previewIcon);
		if (isDisplayed(AnalyticsRepository.analytics_details_overview_popup))
		{
			clickElement(AnalyticsRepository.analytics_details_overview_previewIcon);
		}

		primaryGoal = findElements(AnalyticsRepository.analytics_details_overview_primaryGoal);
		goalCount = findElements(AnalyticsRepository.analytics_details_overview_primaryGoalCount);
		for (int i = 0; i < primaryGoal.size(); i++)
		{
			javaScriptHighLightElement(primaryGoal.get(i));
			String goal = primaryGoal.get(i).getText().trim();
			String count = goalCount.get(i).getText().trim();
			detailsOverview.put(goal, count);

			percentages = findElements(AnalyticsRepository.analytics_details_overview_percentages).get(i).findElements(By.tagName("li"));
			for (int j = 0; j < percentages.size(); j++)
			{
				String Actions = percentages.get(j).findElement(By.tagName("small")).getText().trim();
				String Count = percentages.get(j).findElement(By.tagName("span")).getText().trim();
				detailsOverview.put(Actions, Count);
			}
		}
		ExtentManager.customReport(detailsOverview);
		return this;
	}

	public AnalyticsOverviewDetailsPage verifyOverViewDashboard(String channel, Map<String, String> listingPage)
	{
		String action = null;
		boolean var = true;
		if (!detailsOverview.isEmpty())
		{
			String listPageCount, Percentage = null;
			String[] primaryGoal = { "Reach", "Engagement", "Conversion" };

			for (int i = 0; i < primaryGoal.length - 1; i++)
			{
				if (channel.equalsIgnoreCase("Email"))
				{
					action = Arrays.asList("Unique opens", "Unique clicks", "Registration").get(i);

				} else if (channel.equalsIgnoreCase("SMS") || channel.equalsIgnoreCase("WhatsApp"))
				{
					action = Arrays.asList("Delivered", "Link clicks", "Registration").get(i);
				} else if (channel.equalsIgnoreCase("QR"))
				{
					action = Arrays.asList("Unique scans", "Link clicks", "Registration").get(i);
				}

				listPageCount = listingPage.get(primaryGoal[i]);
				Percentage = detailsOverview.get(action);

				String detailsCount = detailsOverview.get(primaryGoal[i]);
				percentCalculation(primaryGoal[i], Percentage);

				if (!detailsCount.equals(listPageCount) && !primaryGoal[i].equalsIgnoreCase("Conversion"))
				{
					BaseTest.getTest().log(Status.FAIL, primaryGoal[i] + " ---> Analytics Listing Page : " + listPageCount + "Details : " + detailsCount);
					var = false;
				}
			}
			if (var)
			{
				BaseTest.getTest().log(Status.INFO, "Overview dashboard values are equals to Analytics Listing Page");
			}
		}
		return this;
	}

	public AnalyticsOverviewDetailsPage percentCalculation(String goal, String Percentage)
	{
		double totalSend, count;
		totalSend = Integer.parseInt(getStrText(AnalyticsRepository.analytics_DetailPage_KeyMetrics_TotalAudience));
		count = Integer.parseInt(detailsOverview.get(goal));

		if (!Percentage.isEmpty() && !Percentage.equals("NA"))
		{
			double Percent = Double.parseDouble(Percentage);
			if (!qrAnalityicsListingPageCount.isEmpty())
			{
				if (goal.equalsIgnoreCase("Reach") && qrAnalityicsListingPageCount.get("Channel").equals("QR"))
				{
					totalSend = Integer.parseInt("50");
				}
			} else if (goal.equalsIgnoreCase("Engagement"))
			{
				totalSend = Integer.parseInt(detailsOverview.get("Reach"));
			} else if (goal.equalsIgnoreCase("Conversion"))
			{
				totalSend = Integer.parseInt(detailsOverview.get("Engagement"));
			}
			if (totalSend != 0)
			{
				double calculated = Double.parseDouble(new DecimalFormat("#.##").format(count / totalSend * 100));
				if (Percent != calculated)
				{
					BaseTest.getTest().log(Status.FAIL, goal + " Pecentage ---> Actual : " + Percent + " Calculated : " + calculated);
				}
			}
		}
		return this;
	}

	public AnalyticsOverviewDetailsPage keyMetricsPortlet()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("ANALYTICS DETAILS - Key metrics Portlet", ExtentColor.BROWN));
		List<WebElement> audience;
		javaScriptScrollDownToSomeExtend();
		if (isDisplayed(AnalyticsRepository.analytics_details_keymetrics))
		{
			audience = findElements(AnalyticsRepository.analytics_details_keymetricsAudience);
			for (WebElement keymetrics : audience)
			{
				javaScriptHighLightElement(keymetrics.findElement(By.tagName("h3")));
				String value = keymetrics.getText().trim();
				String name = value.replaceAll("[^a-zA-Z ]", "");
				int count = Integer.parseInt(value.replaceAll("[^0-9]", ""));
				detailsKeymetrics.put(name, count);
				keyMetrics.put(name, value.replaceAll("[^0.0-9]", ""));
			}
		}
		ExtentManager.customReport(keyMetrics);
		return this;
	}

	public AnalyticsOverviewDetailsPage verifyKeymetricsPortlet(String Channel, Map<String, String> listingPage)
	{
		String sendCount = "", delivered = "";
		String[] negativeFeedBack = null;
		if (!detailsKeymetrics.isEmpty())
		{
			if (Channel.equalsIgnoreCase("Email"))
			{
				sendCount = listingPage.get("Total sent").trim();
				delivered = listingPage.get("Delivered").trim();
				negativeFeedBack = "Bounced,Spammed,Unsubscribed".split(",");

			} else if (Channel.equalsIgnoreCase("SMS"))
			{
				sendCount = listingPage.get("Total sent").trim();
				delivered = listingPage.get("Delivered").trim();
				negativeFeedBack = "Rejected,DND,Expired,Undelivered".split(",");

			} else if (Channel.equalsIgnoreCase("WhatsApp"))
			{
				sendCount = listingPage.get("Total sent").trim();
				delivered = listingPage.get("Delivered").trim();
				negativeFeedBack = "Reported,Blocked,Rejected,Undelivered".split(",");

			} else if (Channel.equalsIgnoreCase("QR"))
			{
				// Average scans / day
				qrAvgScan();
			}

			if ((!sendCount.equals("NA") || !sendCount.isEmpty()) && !Channel.equalsIgnoreCase("QR"))
			{
				String audience = Channel.equals("WhatsApp") ? "Total audience" : "Total sent";
				int totalSend = detailsKeymetrics.get(audience);
				int Delivered = detailsKeymetrics.get("Delivered");

				int csrSendCount = Integer.parseInt(sendCount);
				int csrdelivered = Integer.parseInt(delivered.split(" ")[0]);
				if (totalSend != csrSendCount || Delivered != csrdelivered)
				{
					BaseTest.getTest().log(Status.FAIL, "Total Send ---> Analytics Listing Page : " + csrSendCount + "Key metrics : " + totalSend + ", Delivered  ---> Analytics Listing Page : " + csrdelivered + "Key metrics : " + Delivered);
					BaseTest.takeScreenshot();
				} else
				{
					int Sum = 0;
					BaseTest.getTest().log(Status.PASS, "Key metrics and Analytics Listing Page page values are verified Sucessfully");
					for (int index = 0; index < negativeFeedBack.length; index++)
					{
						int count = detailsKeymetrics.get(negativeFeedBack[index]);
						Sum = Sum + count;
					}
					int Result = totalSend - Sum;
					if (Result == Delivered)
					{
						BaseTest.getTest().log(Status.INFO, "Negative feedBack values are as Expected");
					} else
					{
						BaseTest.getTest().log(Status.FAIL, "Negative feedBack values aren't as Expected :" + Result + ", Actual :" + Delivered);
					}
				}
			}
		}
		return this;
	}

	// Communication Performance

	public int analyticsDetailsPortlet(String portlet, String channel)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("ANALYTICS DETAILS - " + portlet + " Portlet", ExtentColor.BROWN));
		String portletHeader = "Portlet,xpath,//div[@class='portlet-header']//h4[text()='" + portlet + "']";
		actionScrollToElement(portletHeader).javaScriptScrollDownToSomeExtend();
		String chart = "Chart,xpath,//h4[text()='" + portlet + "']/..//following-sibling::div//div[contains(@id,'highchart')]";
		javaScriptHighLightwithScrnShot(portletHeader);

		int graph_uniqueCount = 0;
		if (!detailsOverview.get(portlet).equals("0") && !detailsOverview.get(portlet).equals("NA"))
		{
			String[] options = { "First 24 hr", "Overall" };

			for (int i = 0; i < options.length; i++)
			{
				selectlistelements(portletHeader + "/..//li", options[i]);
				explicitwaitforvisibility(autolocator(chart), 10);
				isDisplayed(chart);
				String[] percent = null;
				int overviewCount = Integer.parseInt(detailsOverview.get(portlet));
				if (channel.equalsIgnoreCase("Email"))
				{
					if (portlet.equals("Reach"))
					{
						actionsClickElement(AnalyticsRepository.analytics_DetailPage_reachchartExpand);
						percent = "Unique opens,Forwards".split(",");

					} else if (portlet.equals("Engagement"))
					{
						percent = "Unique clicks,Fwd mail clicks".split(",");
					}
					String id = getTextBoxVal(chart, "id");
					mouseHover(" portlet,css,div[id*='" + id + "']");
					String uniqueLocator = "Trace point,css,div[id*='" + id + "']>svg>g>g[class*='series-0']>path[class*='highcharts-point']";
					String forwardLocator = "Trace point,css,div[id*='" + id + "']>svg>g>g[class*='series-1']>path[class*='highcharts-point']";
					graph_uniqueCount = analyticsGraph(uniqueLocator, id, 1);
					int graph_forward = analyticsGraph(forwardLocator, id, 2);
					String[] arr = getStrText("Tooltip,xpath,//div[contains(@id,'" + id + "')]//div[contains(@class,'highcharts-tooltip')]").split("\\R");
					BaseTest.getTest().log(Status.INFO, "Total " + arr[1].replaceAll("[^A-za-z]", "") + " ----> " + graph_uniqueCount);
					BaseTest.getTest().log(Status.INFO, "Total " + arr[2].replaceAll("[^A-za-z]", "") + " ----> " + graph_forward);

					if (overviewCount == graph_uniqueCount || (overviewCount > graph_uniqueCount && !portlet.equalsIgnoreCase("Reach")))
					{
						BaseTest.getTest().log(Status.INFO, portlet + " ---> portlet values are same compare to " + portlet + " Overview");
					} else
					{
						BaseTest.getTest().log(Status.FAIL, portlet + " --->  Portlet values are differ compare to " + portlet + " Overview dashboard Actual : " + overviewCount + "Expected :" + graph_uniqueCount);
						BaseTest.takeScreenshot();
					}

				} else if (channel.equalsIgnoreCase("SMS") || channel.equalsIgnoreCase("QR"))
				{
					if (portlet.equals("Reach"))
					{
						String param = channel.equalsIgnoreCase("QR") ? "Total unique scans" : "Delivered";
						actionsClickElement(AnalyticsRepository.analytics_DetailPage_reachchartExpand);
						percent = param.split(",");

					} else if (portlet.equals("Engagement"))
					{
						percent = "Link clicks".split(",");
					}
					String id = getTextBoxVal(chart, "id");
					mouseHover(" portlet,css,div[id*='" + id + "']");
					String uniqueLocator = "Trace point,css,div[id*='" + id + "']>svg>g>g[class*='series-0']>path[class*='highcharts-point']";
					graph_uniqueCount = analyticsGraph(uniqueLocator, id, 1);
					String[] arr = getStrText("Tooltip,xpath,//div[contains(@id,'" + id + "')]//div[contains(@class,'highcharts-tooltip')]").split("\\R");
					BaseTest.getTest().log(Status.INFO, "Total " + arr[1].replaceAll("[^A-za-z]", "") + " ----> " + graph_uniqueCount);

					if (overviewCount == graph_uniqueCount || (overviewCount > graph_uniqueCount && !portlet.equalsIgnoreCase("Reach")))
					{
						BaseTest.getTest().log(Status.PASS, portlet + " ---> Portlet values are same compare to " + portlet + " Overview dashboard");
					} else
					{
						BaseTest.getTest().log(Status.FAIL, portlet + " --->  Portlet values are differ compare to " + portlet + " Overview dashboard Actual : " + overviewCount + "Expected :" + graph_uniqueCount);
						BaseTest.takeScreenshot();
					}
				}
				if (portlet.equals("Reach"))
				{
					actionsClickElement(AnalyticsRepository.analytics_DetailPage_reachchartExpand);
				}
			}
		} else if (detailsOverview.get(portlet).equals("0") && isElementPresent(chart))
		{
			BaseTest.getTest().log(Status.FAIL, "<b>" + portlet + "</b> Portlet  ---> Overview Count is Zero, but Graph datas are available");

		} else
		{
			BaseTest.getTest().log(Status.INFO, "<b>" + portlet + "</b> Portlet  --->  No Data Available");
		}
		return graph_uniqueCount;
	}

	public int analyticsGraph(String locator, String id, int data)
	{
		int Sum = 0;
		List<WebElement> tracePoints, yaxis;
		Map<Double, Double> graph = new TreeMap<>();
		tracePoints = findElements(locator);
		if (!tracePoints.isEmpty())
		{
			yaxis = findElements("Reach chart Y axis,xpath,//div[contains(@id,'" + id + "')]//*[contains(@class,'highcharts-yaxis-labels')]//*[@style]");
			for (WebElement axis : yaxis)
			{
				double cooridinate = Double.parseDouble(axis.getText().trim().replaceAll("[^0.0-9]", ""));
				double y = axis.getLocation().getY();
				graph.put(cooridinate, y);
			}
			for (WebElement trace : tracePoints)
			{
				mouseHover(trace);
				int graphLocation = trace.getLocation().getY();
				threadSleep(ObjectRepository.wait1sec);
				String[] arr = getStrText("Tooltip,xpath,//div[contains(@id,'" + id + "')]//div[contains(@class,'highcharts-tooltip')]").split("\\R");
				int graphPoint = Integer.parseInt(arr[data].replaceAll("[^0-9]", ""));
				int index = 1;
				List<Double> list = new ArrayList<>(graph.keySet());
				for (int j = 0; j < list.size(); j++)
				{
					double yCount = list.get(j);
					double yLocation = graph.get(yCount);
					if (graphPoint == yCount)
					{
						if (graphLocation == yLocation || graphLocation < yLocation + 15)
						{
							BaseTest.getTest().log(Status.INFO, "Day on <b>" + arr[0] + "</b> " + arr[data].replaceAll("[^A-za-z]", "") + " ---> Graph trace point : " + graphPoint + ", Exactly plotted on Y-Axis line --> " + yCount);
							break;
						} else
						{
							javaScriptHighLightwithScrnShot(trace);
							BaseTest.getTest().log(Status.FAIL, "The Graph trace point plotted not as Expected");
						}
					} else if (graphPoint < yCount && j != 0)
					{
						double prevCount = list.get(j - 1);
						if (graphLocation > yLocation && graphLocation < graph.get(prevCount))
						{
							BaseTest.getTest().log(Status.INFO,
									"Day on <b>" + arr[0] + "</b> " + arr[data].replaceAll("[^A-za-z]", "") + " ---> Graph trace point: " + graphPoint + ", Falls between -->  " + yCount + " & " + prevCount + " on Y-Axis line");
							break;
						}
					} else if (index == list.size())
					{
						BaseTest.getTest().log(Status.FAIL, "The Graph trace point plotted not as Expected");
						BaseTest.takeScreenshot();
					}
					index++;
				}
				Sum += graphPoint;
			}
		}
		return Sum;
	}

	public int pw_analyticsGraph(String locator, String id, int data)
	{
		int Sum = 0;
		List<WebElement> tracePoints, yaxis;
		Map<Double, Double> graph = new TreeMap<>();
		tracePoints = findElements(locator);
		if (!tracePoints.isEmpty())
		{
			yaxis = findElements("Reach chart Y axis,xpath,//div[contains(@id,'" + id + "')]//*[contains(@class,'highcharts-yaxis-labels')]//*[@style]");
			for (WebElement axis : yaxis)
			{
				double cooridinate = Double.parseDouble(axis.getText().trim().replaceAll("[^0.0-9]", ""));
				double y = axis.getLocation().getY();
				graph.put(cooridinate, y);
			}
			for (WebElement trace : tracePoints)
			{
				mouseHover(trace);
				int graphLocation = trace.getLocation().getY();
				threadSleep(ObjectRepository.wait1sec);
				String[] arr = getStrText("Tooltip,xpath,//div[contains(@id,'" + id + "')]//div[contains(@class,'highcharts-tooltip')]").split("\\R");
				int graphPoint = Integer.parseInt(arr[data].replaceAll("[^0-9]", ""));
				int index = 1;
				List<Double> list = new ArrayList<>(graph.keySet());
				for (int j = 0; j < list.size(); j++)
				{
					double yCount = list.get(j);
					double yLocation = graph.get(yCount);
					if (graphPoint == yCount)
					{
						if (graphLocation == yLocation || graphLocation < yLocation + 15)
						{
							BaseTest.getTest().log(Status.INFO, "Day on <b>" + arr[0] + "</b> " + arr[data].replaceAll("[^A-za-z]", "") + " ---> Graph trace point : " + graphPoint + ", Exactly plotted on Y-Axis line --> " + yCount);
							break;
						} else
						{
							javaScriptHighLightwithScrnShot(trace);
							BaseTest.getTest().log(Status.FAIL, "The Graph trace point plotted not as Expected");
						}
					} else if (graphPoint < yCount && j != 0)
					{
						double prevCount = list.get(j - 1);
						if (graphLocation > yLocation && graphLocation < graph.get(prevCount))
						{
							BaseTest.getTest().log(Status.INFO,
									"Day on <b>" + arr[0] + "</b> " + arr[data].replaceAll("[^A-za-z]", "") + " ---> Graph trace point: " + graphPoint + ", Falls between -->  " + yCount + " & " + prevCount + " on Y-Axis line");
							break;
						}
					} else if (index == list.size())
					{
						BaseTest.getTest().log(Status.FAIL, "The Graph trace point plotted not as Expected");
						BaseTest.takeScreenshot();
					}
					index++;
				}
				Sum += graphPoint;
			}
		}
		return Sum;
	}

	public AnalyticsOverviewDetailsPage userEngagementPortlet(String portlet)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("User engagement - " + portlet + " portlet", ExtentColor.BROWN));
		actionScrollToElement(replacePlaceHolder(AnalyticsRepository.analytics_details_porltet_header, portlet)).javaScriptScrollDownToSomeExtend();
		javaScriptHighLightwithScrnShot(replacePlaceHolder(AnalyticsRepository.analytics_details_porltet_header, portlet));
		Map<String, String> pieChart = new LinkedHashMap<>();
		try
		{
			String id = getTextBoxVal(replacePlaceHolder(AnalyticsRepository.analytics_details_porltet_Id, portlet), "id");
			mouseHover(replacePlaceHolder(AnalyticsRepository.analytics_details_porltet_container, id));
			List<WebElement> lablels = findElements(replacePlaceHolder(AnalyticsRepository.analytics_details_porltet_charts, id));
			List<WebElement> titleLegends = findElements(replacePlaceHolder(AnalyticsRepository.analytics_details_porltet_tiltleLegend, id));

			double[] array = new double[lablels.size()];
			for (int count = 0; count < lablels.size(); count++)
			{
				javaScriptMouseOver(lablels.get(count));
				String titleLegend = titleLegends.get(count).getText().trim();
				String chartPercent = lablels.get(count).getText().trim();
				String tooltip = getStrText(replacePlaceHolder(AnalyticsRepository.analytics_details_porltet_tooltip, id));

				String browser = tooltip.split("\\R")[0].trim();
				String percentage = tooltip.replaceAll("[^0-9]", "");
				if (!browser.equalsIgnoreCase(titleLegend) && !percentage.equals(chartPercent.replaceAll("[^0-9]", "")))
				{
					BaseTest.getTest().log(Status.FAIL, browser + " ---> " + chartPercent + " values are not as Expected");
					javaScriptHighLightwithScrnShot(lablels.get(count));
				}
				pieChart.put(browser, chartPercent);

				// SMS & WhatsApp Communication Status
				if (portlet.equalsIgnoreCase("Communication status"))
				{
					long percent = Integer.parseInt(chartPercent.replaceAll("[^0-9]", ""));
					double value = (double) detailsKeymetrics.get(browser) / detailsKeymetrics.get("Total sent") * 100;
					long calPercent = Math.round(value);
					if (percent != calPercent)
					{
						BaseTest.getTest().log(Status.FAIL, browser + " ---> " + percent + " pecentage are not as Expected, Compare to Keymetrics calculated :" + calPercent);
						BaseTest.takeScreenshot();
					}
					String description = "Actual : " + chartPercent + ", Calculated : " + value;
					pieChart.put(browser, description);
				}
				array[count] = Double.parseDouble(percentage.split("%")[0]);
			}
			BaseTest.getTest().log(Status.INFO, "Chart values are matched with tooltip values");
			Arrays.sort(array);

			double max = array[array.length - 1];
			String element = replacePlaceHolder(AnalyticsRepository.analytics_details_portletInfo, portlet);
			String infoPanel = getStrText(element);
			pieChart.put("Info - Panel", infoPanel);
			double info = Double.parseDouble(infoPanel.split("%")[0]);
			if (max != info && detailsKeymetrics.get("Delivered") != 0)
			{
				if (max > (info + 0.99))
				{
					BaseTest.getTest().log(Status.FAIL, portlet + " Info-Panel --> " + infoPanel + ", Actual :" + max + " Expected :" + info);
					BaseTest.takeScreenshot();
				}
			}
			ExtentManager.customReport(pieChart);
			javaScriptHighLightwithScrnShot(element);

		} catch (Exception e)
		{
			if (isElementPresent(replacePlaceHolder(AnalyticsRepository.analytics_details_porltet, portlet)))
			{
				BaseTest.getTest().log(Status.INFO, "<b>" + portlet + "</b> Portlet  --->  No Data Available");
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Exception Occured --> " + e);
			}
		}
		return this;
	}

	public AnalyticsOverviewDetailsPage pieChartLegend(String portlet)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("User engagement - " + portlet + " portlet", ExtentColor.BROWN));
		javaScriptScrollIntoView(portlet + ",xpath,//h4[text()='" + portlet + "']");
		javaScriptScrollUpToSomeExtend();
		javaScriptHighLightwithScrnShot(portlet + ",xpath,//h4[text()='" + portlet + "']");

		if (!isElementPresent("No Data Chart,xpath,//h4[text()='" + portlet + "']/..//following-sibling::div[@class='portlet-body']//*[@class='nodata-bar']"))
		{
			List<WebElement> chart, titleLegends;
			String id = getTextBoxVal("chart element,xpath,//h4[text()='" + portlet + "']/..//following-sibling::div//div[contains(@id,'highcharts')]", "id");
			String locator = "//div[@id='" + id + "']";
			mouseHover("OverAll Pie-Chart,css,div[id='" + id + "']");
			chart = findElements("Chart data list,css,div[id='" + id + "']>svg>g>g[class*='highcharts-data-label-color-']>text");
			titleLegends = findElements("Title Legends,xpath," + locator.concat("//*[contains(@class,'highcharts-legend-item highcharts')]"));

			int index = 0;
			for (int i = 0; i < titleLegends.size() * 2; i++)
			{
				WebElement legend = titleLegends.get(index);
				clickElement(legend, legend.getText());
				elementHighlighter(legend);

				titleLegends = findElements("Title Legends,xpath," + locator.concat("//*[contains(@class,'highcharts-legend-item highcharts')][not (contains(@class,'item-hidden'))]"));
				if (legend.getAttribute("class").contains("item-hidden"))
				{
					for (int count = 0; count < titleLegends.size(); count++)
					{
						mouseHover(chart.get(count));
						String pieChart = getStrText("Chart Tooltip,xpath," + locator + "//div[contains(@class,'highcharts-label highcharts-tooltip')]/span").split("\\R")[0].trim();
						String titleLegend = titleLegends.get(count).getText().trim();
						uiPageEqualswithInputValue(titleLegend, pieChart);
					}
				}
				if (titleLegends.size() < i)
				{
					index--;
				}
			}
		}

		return this;
	}

	public boolean totalLinkClickActivity(int uniqueClicks)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("ANALYTICS DETAILS - Total Link Clicks Activity", ExtentColor.BROWN));
		javaScriptScrollIntoView(AnalyticsRepository.analytics_details_totallinkClick);
		javaScriptHighLightwithScrnShot(AnalyticsRepository.analytics_details_totallinkClick);
		int Engagement = Integer.parseInt(detailsOverview.get("Engagement"));

		if (uniqueClicks != 0 || Engagement != 0)
		{
			String Row = AnalyticsRepository.analytics_details_totallinkClick_rows;
			String Header = AnalyticsRepository.analytics_details_totallinkClick_headers;
			if (!findElements(Row).isEmpty())
			{
				totalLinkClick = getWebTableData(Header, Row, AnalyticsRepository.analytics_details_totallinkClick_pagination);
				ExtentManager.customReport(totalLinkClick);
				return true;
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Headers present, but No Data available");
			}
		} else
		{
			BaseTest.getTest().log(Status.INFO, "No Data available");
		}
		return false;
	}

	public boolean pw_totalLinkClickActivity(int uniqueClicks)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("ANALYTICS DETAILS - Total Link Clicks Activity", ExtentColor.BROWN));
		pw_javaScriptHighLightwithScrnShot(AnalyticsRepository.analytics_details_totallinkClick);
		int Engagement = Integer.parseInt(detailsOverview.get("Engagement"));

		if (uniqueClicks != 0 || Engagement != 0)
		{
			String Row = AnalyticsRepository.analytics_details_totallinkClick_rows;
			String Header = AnalyticsRepository.analytics_details_totallinkClick_headers;
			if (!findElements(Row).isEmpty())
			{
				totalLinkClick = getWebTableData(Header, Row, AnalyticsRepository.analytics_details_totallinkClick_pagination);
				ExtentManager.customReport(totalLinkClick);
				return true;
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Headers present, but No Data available");
			}
		} else
		{
			BaseTest.getTest().log(Status.INFO, "No Data available");
		}
		return false;
	}

	public AnalyticsOverviewDetailsPage analyticsHeapMap()
	{
		actionScrollToElement(AnalyticsRepository.analytics_details_totallinkClick_heapmapIcon).javaScriptScrollUpToSomeExtend();;
		explicitwaitforclick(autolocator(AnalyticsRepository.analytics_details_totallinkClick_heapmapIcon), 20);
		clickElement(AnalyticsRepository.analytics_details_totallinkClick_heapmapIcon);
		if (isDisplayed(AnalyticsRepository.analytics_details_totallinkClick_heapmapPopup))
		{
			clickElement(AnalyticsRepository.analytics_details_totallinkClick_heapmapPopupClose);
		}
		explicitwaitforvisibility(autolocator(AnalyticsRepository.analytics_details_totallinkClick_headers), 20);
		return this;
	}

	public AnalyticsOverviewDetailsPage verifyDownloadedCSV()
	{
		boolean var = true;
		actionScrollToElement(AnalyticsRepository.analytics_details_totallinkClick_CSV);
		clickElement(AnalyticsRepository.analytics_details_totallinkClick_CSV);
		List<Map<String, String>> file = csvFileReader("");
		if (!totalLinkClick.isEmpty() || !file.isEmpty())
		{
			for (int index = 0; index < totalLinkClick.size(); index++)
			{
				Map<String, String> grid = totalLinkClick.get(index);
				Map<String, String> csv = file.get(index);
				if (!grid.equals(csv))
				{
					BaseTest.getTest().log(Status.FAIL, "Grid --> " + grid + " and CSV -->" + csv + " values are Mismatched");
					BaseTest.takeScreenshot();
					var = false;
				}
			}
			if (var)
			{
				BaseTest.getTest().log(Status.INFO, "Downloaded CSV  ---> " + file);
				BaseTest.getTest().log(Status.INFO, "Grid values and download CSV values are same");
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "No Data available");
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public AnalyticsOverviewDetailsPage uniqueClicksCount(String channel, int Count)
	{
		int uniqueClicks = 0, totalClicksCount = 0;
		if (!totalLinkClick.isEmpty() && !detailsKeymetrics.isEmpty())
		{
			for (int i = 0; i < totalLinkClick.size(); i++)
			{
				int unique = Integer.parseInt(totalLinkClick.get(i).get("Unique clicks"));
				int total = Integer.parseInt(totalLinkClick.get(i).get("Total clicks"));
				uniqueClicks = uniqueClicks + unique;
				totalClicksCount = totalClicksCount + total;
			}
			if (channel.equalsIgnoreCase("Email"))
			{
				int totalClick = detailsKeymetrics.get("Total clicked");
				if (totalClick == totalClicksCount)
				{
					BaseTest.getTest().log(Status.INFO, "Total Clicks  ----> " + totalClicksCount + ", verified as expected");
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Total Clicks  ----> " + "Keymetrics Portlet :" + totalClick + " and TotalClickActivity :" + totalClicksCount + " values are Mismatched");
					BaseTest.takeScreenshot();
				}
			}
			if (uniqueClicks == Count)
			{
				BaseTest.getTest().log(Status.INFO, "Unique Clicks  ----> " + uniqueClicks + ", verified as expected");

			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Unique Clicks --> " + "Engagement Portlet :" + Count + " and TotalClickActivity :" + uniqueClicks + " values are Mismatched");
				BaseTest.takeScreenshot();
			}

		}
		return this;
	}

	public AnalyticsOverviewDetailsPage pw_uniqueClicksCount(String channel, int Count)
	{
		int uniqueClicks = 0, totalClicksCount = 0;
		if (!totalLinkClick.isEmpty() && !detailsKeymetrics.isEmpty())
		{
			for (int i = 0; i < totalLinkClick.size(); i++)
			{
				int unique = Integer.parseInt(totalLinkClick.get(i).get("Unique clicks"));
				int total = Integer.parseInt(totalLinkClick.get(i).get("Total clicks"));
				uniqueClicks = uniqueClicks + unique;
				totalClicksCount = totalClicksCount + total;
			}
			if (channel.equalsIgnoreCase("Email"))
			{
				int totalClick = detailsKeymetrics.get("Total clicked");
				if (totalClick == totalClicksCount)
				{
					BaseTest.getTest().log(Status.INFO, "Total Clicks  ----> " + totalClicksCount + ", verified as expected");
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Total Clicks  ----> " + "Keymetrics Portlet :" + totalClick + " and TotalClickActivity :" + totalClicksCount + " values are Mismatched");
					BaseTest.takeScreenshot();
				}
			}
			if (uniqueClicks == Count)
			{
				BaseTest.getTest().log(Status.INFO, "Unique Clicks  ----> " + uniqueClicks + ", verified as expected");

			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Unique Clicks --> " + "Engagement Portlet :" + Count + " and TotalClickActivity :" + uniqueClicks + " values are Mismatched");
				BaseTest.takeScreenshot();
			}

		}
		return this;
	}

	public AnalyticsOverviewDetailsPage communicationStatus(String channel, String dataSet)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("  ANALYTICS DETAILS - Communication Status - " + channel, ExtentColor.BROWN));
		javaScriptScrollDown();

		String[] testData = dataSet.split(",");
		for (int index = 0; index < testData.length; index++)
		{
			clickElement("Communication Stauts " + AnalyticsRepository.analytics_details_commStatus_dropdown);
			if (selectlistelements(AnalyticsRepository.analytics_details_commStatus_dropdownlist, testData[index]))
			{
				pageLoaderLogo();
				int statusCount = 0;
				if (isElementPresent(AnalyticsRepository.analytics_details_commStatus_table))
				{
					javaScriptHighLightwithScrnShot(AnalyticsRepository.analytics_details_commStatus);
					statusCount = Integer.parseInt(getStrText(AnalyticsRepository.analytics_details_commStatusCount).replaceAll("[^0-9]", ""));
					javaScriptScrollDown();
					String headers = AnalyticsRepository.analytics_details_commStatus_headers;
					String rows = AnalyticsRepository.analytics_details_commStatus_rows;
					String pagination = AnalyticsRepository.analytics_details_commStatus_pagination;

					commStatus = getWebTableData(headers, rows, pagination);
					if (commStatus.isEmpty() || commStatus == null)
					{
						// commStatusCSVDownload();
						BaseTest.getTest().log(Status.FAIL, testData[index] + "  ---> No data found");
						BaseTest.takeScreenshot();
					}
				} else
				{
					BaseTest.getTest().log(Status.INFO, testData[index] + "  ---> Communication Status Count is : " + statusCount);
				}
				// commStatusCount = verifyCommStatusCount(channel, index);

				String params = BaseTest.getData().KeyMetrics.split(",")[index];
				commStatusCount = getKeymetricsCount(params);

				String log = (BaseTest.getData().ListType.equalsIgnoreCase("Total opened")) ? "Email Overview Reach Count" : "Key metrics " + testData[index];
				if (statusCount == commStatusCount)
				{
					BaseTest.getTest().log(Status.PASS, "<b>CommStatus Count </b> ---> " + statusCount + ", <b>" + log + "</b> -->  " + commStatusCount + " are exactly matched");
					BaseTest.takeScreenshot();
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "CommStatus Count ---> " + statusCount + ", " + log + " --> " + commStatusCount + " aren't exactly matched");
					javaScriptHighLightwithScrnShot(AnalyticsRepository.analytics_details_commStatus);
				}
			}
		}
		return this;
	}

	public AnalyticsOverviewDetailsPage commStatusCSVDownload()
	{
		actionScrollToElement(AnalyticsRepository.analytics_comm_statusdownload);
		clickElement(AnalyticsRepository.analytics_comm_statusdownload);
		sendOTPtoEmailId();
		String pwind = parentWinHandle();
		javaScriptopenNewWindow();
		switchWindow();
		webURLlaunch();
		accountUserWebmailLogin();
		String otp = getWebmailOTPforDetailedAnalytics();
		switchParentWin(pwind);
		enterOTPAndSubmit(otp, "communication");
		communicationStatusDownloadConfirmationPopup();
		switchWindow();
		clickWebmailCommunicationStatusDownloadLink();
		childWindowClose(pwind);
		return this;
	}

	public int verifyCommStatusCount(String Channel, int index)
	{
		int count = 0;
		if (Channel.equalsIgnoreCase("Email"))
		{
			String[] data = { "Total opened", "Bounced", "Forwarded", "Total sent", "Spammed", "Unsubscribed" };
			count = detailsKeymetrics.get(data[index]);
			if (index == 0)
			{
				return count = Integer.parseInt(detailsOverview.get("Reach"));
			}
		} else if (Channel.equalsIgnoreCase("SMS"))
		{
			String[] data = { "Delivered", "Expired", "Message in queue", "Submitted to carrier", "Rejected", "Undelivered" };
			count = detailsKeymetrics.get(data[index]);
		}
		return count;
	}

	public int getKeymetricsCount(String testData)
	{
		int count = 0;
		if (!detailsKeymetrics.isEmpty())
		{
			if (testData.equalsIgnoreCase("Total opened"))
			{
				return count = Integer.parseInt(detailsOverview.get("Reach"));
			}
			count = detailsKeymetrics.get(testData);
		}
		return count;

	}

	public AnalyticsOverviewDetailsPage verifyCommStatusDownloadedCSV(String action)
	{
		if (csvFileReader(action).isEmpty())
		{
			BaseTest.getTest().log(Status.FAIL, "Downloaded CSV File has Empty records.");
		}
		return this;
	}

	public AnalyticsOverviewDetailsPage verifyChannelTitle(String[] Channels)
	{
		pageLoaderLogo();
		if (!isElementPresent(AnalyticsRepository.analytics_report_UnderProcessPopup))
		{
			int count = 0;
			for (WebElement tabs : findElements(AnalyticsRepository.analytics_channelTabs))
			{
				String detailsPageChannel = tabs.getText().trim();
				uiPageEqualswithInputValue(Channels[count], detailsPageChannel);
			}
		}
		return this;
	}

	public AnalyticsOverviewDetailsPage analyticsReports()
	{
		pageLoaderLogo();
		try
		{
			List<WebElement> channels = findElements(AnalyticsRepository.analytics_channelTabs);
			for (int count = 0; count < communicationAnalyticsListingCount.size(); count++)
			{
				Map<String, String> listingPage = communicationAnalyticsListingCount.get(count);
				String Channel = listingPage.get("Channel");
				if (commDeliverability.get("Deliverability").equalsIgnoreCase("Multi dimension"))
				{
					BaseTest.getTest().info(MarkupHelper.createLabel("MDC " + Channel + " LEVEL - " + (count + 1), ExtentColor.ORANGE));
					BaseTest.takeScreenshot();
				}
				explicitwaitforvisibility(autolocator(AnalyticsRepository.analytics_overviewDashboard), 60);
				clickElement(channels.get(count), Channel);

				overViewDashboard().verifyOverViewDashboard(Channel, listingPage);
				keyMetricsPortlet().verifyKeymetricsPortlet(Channel, listingPage);
				analyticsDetailsPortlet("Reach", Channel);
				int uniqueClicks = analyticsDetailsPortlet("Engagement", Channel);
				analyticsDetailsPortlet("Conversion", Channel);
				if (Channel.equals("QR"))
				{
					geographyDashboard();
					userEngagementPortlet(BaseTest.getData().Portlet2);
				} else
				{
					userEngagementPortlet(BaseTest.getData().Portlet1);
					userEngagementPortlet(BaseTest.getData().Portlet2);
				}
				if (totalLinkClickActivity(uniqueClicks))
				{
					uniqueClicksCount(Channel, uniqueClicks);
					if (Channel.equalsIgnoreCase("Email"))
					{
						analyticsHeapMap();
					}
				}
				if (!Channel.equals("QR"))
				{
					communicationStatus(Channel, BaseTest.getData().CommStatus);
					javaScriptScrolltoTop();
				}
			}
		} catch (Exception e)
		{
			if (isElementPresent(AnalyticsRepository.analytics_report_UnderProcessPopup))
			{
				BaseTest.getTest().log(Status.WARNING, "Reports Generation is under process...");
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Exception Occured --> " + e);
			}
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public AnalyticsOverviewDetailsPage commStatusVerify()
	{
		if (listingPageChannelDetails != null)
		{
			String mainStatus = commDeliverability.get("MainStatus");
			BaseTest.getTest().log(Status.INFO, "Communication Main Status --> <b>" + mainStatus + "</b>");

			for (Map<String, String> details : listingPageChannelDetails)
			{
				String channel = details.get("Channel");
				String subStatus = details.get("Status");

				if (!mainStatusCheck(mainStatus).contains(subStatus))
				{
					BaseTest.getTest().log(Status.FAIL, "Main Status --> <b>" + mainStatus + "</b>, Sub Status --> " + channel + " : " + subStatus + " Not as Expected.");
					BaseTest.takeScreenshot();
				} else
				{
					BaseTest.getTest().log(Status.INFO, "Sub Status --> " + channel + ": " + subStatus + " as Expected.");
				}
			}
			listingPageChannelDetails.clear();
		}
		return this;
	}

	public static List<String> mainStatusCheck(String CommStatus)
	{
		switch (CommStatus)
		{
		case "Schedule":
			return Arrays.asList("Schedule");

		case "In progress":
			return Arrays.asList("In progress");

		case "Alert":
			return Arrays.asList("Pending for approval");

		case "Multi status":
			return Arrays.asList("Schedule", "In progress", "Completed", "Alert");

		case "Completed":
			return Arrays.asList("Completed");

		default:
			break;
		}
		return Collections.emptyList();
	}

	public void recentCommunicationScenarios()
	{

		if (!isElementPresent(AnalyticsRepository.dashboard_leftarrow))
		{
			BaseTest.getTest().log(Status.INFO, "Left arrow is not displayed in first slide as expected");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Left arrow is displayed in the fist slide");
			BaseTest.takeScreenshot();
		}
		clickElement(AnalyticsRepository.dashboard_rightarrow);
		threadSleep(ObjectRepository.wait2sec);
		if (!isElementPresent(AnalyticsRepository.dashboard_rightarrow))
		{
			BaseTest.getTest().log(Status.INFO, "Right arrow is not displayed in first slide as expected");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Right arrow is displayed in the fist slide");
			BaseTest.takeScreenshot();
		}
		refresh();
		clickElement(AnalyticsRepository.dashboard_slide2);
		threadSleep(ObjectRepository.wait3sec);
		boolean flag = true;
		List<Integer> mousrHoverreachPercentage = new ArrayList<>();
		List<Integer> targetReach = new ArrayList<>();
		List<Integer> currentReach = new ArrayList<>();
		List<Character> firstLetter = new ArrayList<>();
		for (int i = 1; i <= 6; i++)
		{
			String commName = getStrText("Communication name,xpath,(//p[contains(@class,'text-wrap-1 marginB0')])[" + i + "]");
			toolTipValidationKnownText("Communication name,xpath,(//p[contains(@class,'text-wrap-1 marginB0')])[\"+i+\"]", commName);
			mouseHover(",xpath,(//*[@class='highcharts-dial'])[" + i + "]");
			threadSleep(ObjectRepository.wait1sec);
			BaseTest.takeScreenshot();
			String tooltipText = getStrText(DashboardRepository.dashboard_tooltip);
			String toolTip = tooltipText.replaceAll("[^A-Za-z]", " ").trim();
			String tooltipReachPercentage = tooltipText.replaceAll("[^\\d]", "");
			int parseInt = Integer.parseInt(tooltipReachPercentage);
			mousrHoverreachPercentage.add(parseInt);
			uiPageEqualswithInputValue(",xpath,(//span[@class='rpGaugeLabel']//span)[" + i + "]", toolTip);
			String[] split = tooltipText.split(" ");
			char secondWordFistLetter = split[1].charAt(0);
			firstLetter.add(secondWordFistLetter);
			clickElement("I icon,xpath,(//i[contains(@class,'icon-info-small icons-sm')])[" + i + "]");
			threadSleep(ObjectRepository.wait2sec);
			BaseTest.takeScreenshot();
			String targetReachPercentageString1 = getStrText(AnalyticsRepository.dashboard_recentcomm_targetreach).replaceAll("[^\\d]", "").substring(0, 2);
			String currentReachPercentageString1 = getStrText(AnalyticsRepository.dashboard_recentcomm_currentreach).replaceAll("[^\\d]", "");
			int targetReachPercentageint1 = Integer.parseInt(targetReachPercentageString1);
			int currentReachPercentageint1 = Integer.parseInt(currentReachPercentageString1);
			targetReach.add(targetReachPercentageint1);
			currentReach.add(currentReachPercentageint1);
			clickElement("I icon,xpath,(//i[contains(@class,'icon-info-small icons-sm')])[" + i + "]");
			threadSleep(ObjectRepository.wait2sec);
			if (i == 3)
			{
				clickElement(AnalyticsRepository.dashboard_slide2);
				threadSleep(ObjectRepository.wait3sec);
			}
		}
		clickElement(AnalyticsRepository.dashboard_slide1);
		threadSleep(ObjectRepository.wait3sec);
		for (int i = 0; i < currentReach.size(); i++)
		{
			if (currentReach.get(i) == mousrHoverreachPercentage.get(i) && currentReach.get(i) <= 100 && mousrHoverreachPercentage.get(i) <= 100)
			{
				BaseTest.getTest().log(Status.INFO, "Speedometer " + (i + 1) + " tooltip reach percentage: (" + mousrHoverreachPercentage.get(i) + ") and i icon reach percentage( " + currentReach.get(i) + ") is equal as expected");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Speedometer " + (i + 1) + " tooltip reach percentage: (" + mousrHoverreachPercentage.get(i) + ") and i icon reach percentage( " + currentReach.get(i) + ") is not same");
			}
		}

		for (int i = 0; i < targetReach.size(); i++)
		{
			if (targetReach.get(i) <= 100)
			{
				BaseTest.getTest().log(Status.INFO, "I icon target reach percentage is (" + targetReach.get(i) + ") is not more than 100 percentage as expected");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "I icon target reach percentage is (" + targetReach.get(i) + ") is not more than 100 percentage");
			}
		}
		for (int i = 0; i < firstLetter.size(); i++)
		{
			if (Character.isLowerCase(firstLetter.get(i)))
			{
				BaseTest.getTest().log(Status.INFO, "Speedometer " + (i + 1) + " Label second word is starts with small letter as expected");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Speedometer " + (i + 1) + " Label second word is not starts with small letter as expected");
			}
		}

	}

	public void topPerformingCommunicationScenarios()
	{

		javaScriptScrollIntoView(AnalyticsRepository.dashboard_topperformingcommunication_head);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-100)");
		List<WebElement> upArrows = findElements("Up arrow,xpath,//i[contains(@class,'posr top-2 icon-arrow-up-small icons-md green-medium')]");
		boolean flagUpArrow = true;
		for (int i = 0; i < upArrows.size(); i++)
		{
			String classAttribute = upArrows.get(i).getAttribute("class");
			if (!classAttribute.contains("green"))
			{
				elementHighlighter(upArrows.get(i));
				flagUpArrow = false;
				BaseTest.getTest().log(Status.FAIL, "Top performance communication up arrow is not shown in green colour.");
				break;
			}
		}

		javaScriptScrollIntoView(AnalyticsRepository.dashboard_slide2);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-100)");
		if (flagUpArrow)
		{
			BaseTest.getTest().log(Status.PASS, "Top performance communication up arrow is shown in green colour as expected.");
			BaseTest.takeScreenshot();
		}
		clickElement(AnalyticsRepository.dashboard_topperforming_threedot);
		threadSleep(ObjectRepository.wait2sec);
		List<WebElement> commPerformList = findElements("communication perfom list,xpath,//div[contains(@class,'k-popup k-list-container k-reset k-group')]//li");
		if (commPerformList.size() == 1)
		{
			if (commPerformList.get(0).getText().equals("Low performing communications"))
			{
				BaseTest.getTest().log(Status.INFO, "communication perform dropdown options appers only once as expected");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "communication perform dropdown option text is mismatched");
			}
		} else
		{
			BaseTest.getTest().log(Status.INFO, "communication perform dropdown options appers more than once.");
		}
		clickElement(AnalyticsRepository.dashboard_topperforming_lowperformingcommunication);
		isDisplayed(AnalyticsRepository.dashboard_topperforming_lowperformingcommunicationhead);
		List<WebElement> downArrows1 = findElements("Up arrow,xpath,//i[contains(@class,'posr top-2 icon-arrow-down-small icons-md maroon-medium')]");
		boolean flagUpArrow1 = true;
		for (int i = 0; i < downArrows1.size(); i++)
		{
			String classAttribute = downArrows1.get(i).getAttribute("class");
			if (!classAttribute.contains("maroon"))
			{
				elementHighlighter(downArrows1.get(i));
				flagUpArrow1 = false;
				BaseTest.getTest().log(Status.FAIL, "Low performance communication up arrow is not shown in marron colour.");
				break;
			}
		}
		javaScriptScrollIntoView(AnalyticsRepository.dashboard_slide2);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-100)");
		if (flagUpArrow1)
		{
			BaseTest.getTest().log(Status.INFO, "Low performance communication up arrow is shown in marron colour as expected.");
			BaseTest.takeScreenshot();
		}
	}

	public void audienceBehaviorScenarios()
	{
		clickAudiencelink();
		clickElement("Marketing star logo,xpath,//img[contains(@alt,'marketing-star-logo')]");
		if (!isElementPresent(AnalyticsRepository.dashboard_communicationname))
		{
			BaseTest.getTest().log(Status.INFO, "Screen is not navigates to dashboard page after clicked marketing star logo.");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Screen is navigates to dashboard page after clicked marketing star logo.");
		}
		clickDashboardTab();
		javaScriptScrollIntoView(AnalyticsRepository.dashboard_slide2);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-100)");
		isDisplayed(AnalyticsRepository.dashboard_topperforming_audiencebehaviorhead);
		uiPageEqualswithInputValue("Bubble chart days,xpath,//span[@class='bubbleChartName']", "Wednesday,Tuesday,Monday,Saturday,Sunday,Friday,Thursday");
		String[] hexaValues = { "#46c029", "#ff0005", "#0048ff", "#5b5b5b", "#ff7800", "#a9bde4", "#f5ec00" };
		String[] days = { "Wednesday", "Tuesday", "Monday", "Saturday", "Sunday", "Friday", "Thursday" };

		for (int i = 0; i < hexaValues.length; i++)
		{
			String uiColorCode = findElements("bubblechart days,xpath,//*[contains(@class,'packedbubble-series')]//*[@fill][@d]").get(i).getAttribute("fill");
			if (uiColorCode.equalsIgnoreCase(hexaValues[i]))
			{
				BaseTest.getTest().log(Status.INFO, days[i] + " bubble chart color is validated successfully. Displayed as expected in the UI");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, days[i] + " bubble chart color is differs from its Hexa decimal value");
			}
		}

	}

	public void channelPerformenceScenarios()
	{

		javaScriptScrollIntoView(AnalyticsRepository.dashboard_channelperformance_head);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-100)");
		threadSleep(ObjectRepository.wait2sec);
		BaseTest.takeScreenshot();
		uiPageEqualswithInputValue("Count text,xpath,//*[@text-anchor='middle'][@class='highcharts-axis-title']", "Count");
		List<WebElement> channels2 = findElements("Channels,xpath,//*[@class='highcharts-point']/..//*[@text-anchor='start']");
		for (int i = 0; i < channels2.size(); i++)
		{
			String HoweredChannel = channels2.get(i).getText();
			mouseHover(channels2.get(i));
			String textBoxVal = getTextBoxVal(",xpath,(//*[@opacity='1'][contains(@class,'highcharts-series-hover')])[1]//*", "fill");
			if (HoweredChannel.equals("Email"))
			{
				if (textBoxVal.equalsIgnoreCase("#fc6100"))
				{
					BaseTest.getTest().log(Status.INFO, "Email channel bar color is validated successfully. Displayed as expected");
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Email channel bar color is not displayed with expected hexa color value");
				}
			} else if (HoweredChannel.equals("SMS"))
			{
				if (textBoxVal.equalsIgnoreCase("#dfb82b"))
				{
					BaseTest.getTest().log(Status.INFO, "Email channel bar color is validated successfully. Displayed as expected");
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Email channel bar color is not displayed with expected hexa color value");
				}
			} else if (HoweredChannel.equals("WhatsApp"))
			{
				if (textBoxVal.equalsIgnoreCase("#00d954"))
				{
					BaseTest.getTest().log(Status.INFO, "Whatsapp channel bar color is validated successfully. Displayed as expected");
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Whatsapp channel bar color is not displayed with expected hexa color value");
				}
			} else if (HoweredChannel.equals("QR"))
			{
				if (textBoxVal.equalsIgnoreCase("#585858"))
				{
					BaseTest.getTest().log(Status.INFO, "QR channel bar color is validated successfully. Displayed as expected");
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "QR channel bar color is not displayed with expected hexa color value");
				}
			} else
			{
				BaseTest.getTest().log(Status.FAIL, HoweredChannel + " Channel Text value is differs to its input value");
			}
		}
	}

	// Reports - QR Communication
	public AnalyticsOverviewDetailsPage qrAvgScan()
	{
		BaseTest.getTest().log(Status.INFO, MarkupHelper.createLabel("Avg.Scans/per day Calculation", ExtentColor.ORANGE));

		long campStartDate = Long.parseLong(getTextBoxVal(AnalyticsRepository.analytics_details_overview_Stdate, "datetime"));
		long campEndDate = Long.parseLong(getTextBoxVal(AnalyticsRepository.analytics_details_overview_enddate, "datetime"));
		long currentDate = new Date().getTime();

		// If Campaign End date is less than current date, then it return current date
		campEndDate = campEndDate < currentDate ? currentDate : campEndDate;

		long msecToDay = 1000 * 60 * 60 * 24;
		long duration = (campEndDate - campStartDate) / msecToDay;

		// Avg scan per day
		int totalScans = detailsKeymetrics.get("Total scans");
		long calAvgScans = totalScans / duration;
		long avgScans = detailsKeymetrics.get("Average scans per day");
		BaseTest.getTest().log(Status.INFO, "</b> Actual </b> : " + avgScans + ", <b> Calculated </b> : " + calAvgScans);

		if (avgScans != calAvgScans)
		{
			BaseTest.getTest().log(Status.FAIL, "Avg.Scans/per day verification failed");
		}
		return this;
	}

	public AnalyticsOverviewDetailsPage geographyDashboard()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel(" Geography Dashboard ", ExtentColor.BROWN));
		actionScrollToElement("Geography,xpath,//h4[text()='Geography']").javaScriptScrollDownToSomeExtend();
		javaScriptHighLightwithScrnShot("Geography,xpath,//h4[text()='Geography']");

		if (!isElementPresent(AnalyticsRepository.analytics_listing_nodata.concat("//preceding::h4[text()='Geography']")))
		{
			String id = getTextBoxVal("chart element,xpath,//h4[text()='Geography']/..//following-sibling::div//div[contains(@id,'highcharts')]", "id");
			mouseHover("OverAll Pie-Chart,css,div[id='" + id + "']");
			isElementAvailable("Chart data list,css,div[id='" + id + "']>svg>g>g[class*='highcharts-data-label-color-']>text");

			String element = "Info panel,xpath,//h4[text()='Geography']/..//following-sibling::div[@class='portlet-two-label']";
			String infoPanel = getStrText(element);
			javaScriptHighLightwithScrnShot(element);
			BaseTest.getTest().log(Status.INFO, "Geography Info-Panel  ----> " + infoPanel);
		}
		return this;
	}

	public List<Map<String, String>> validateAnalyticsGridView1()
	{
		selectCustomRange(-10, 0);
		int page = 1;
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		while (true)
		{
			List<WebElement> lists = findElements(AnalyticsRepository.analytics_listingcommunicationlist);
			for (int count = 0; count < lists.size(); count++)
			{
				Map<String, String> map = new LinkedHashMap<>();
				lists = findElements(AnalyticsRepository.analytics_listingcommunicationlist);
				String CommunicationName = lists.get(count).findElement(By.cssSelector("div[class='pt5']")).getText();
				map.put("Communication name", CommunicationName);
				map.put("Created on", lists.get(count).findElements(By.tagName("small")).get(0).getText());
				map.put("Deliverability", lists.get(count).findElements(By.tagName("small")).get(1).getText());
				map.put("Status", lists.get(count).findElements(By.tagName("small")).get(3).getText());
				map.put("Delivery type", lists.get(count).findElements(By.tagName("p")).get(0).getText());
				map.put("Send on", lists.get(count).findElements(By.tagName("p")).get(1).getText());
				list.add(map);
			}
			threadSleep(ObjectRepository.wait1sec);
			javaScriptScrollDown();
			if (!isElementPresent(AudienceRepository.audience_synchist_lastButton) && page == 1)
			{
				BaseTest.getTest().log(Status.INFO, "This is first page, Pagination is not present as expected.");
				BaseTest.takeScreenshot();
				break;
			} else if (!isElementPresent(AudienceRepository.audience_synchist_lastButton) && page != 1)
			{
				BaseTest.getTest().log(Status.INFO, "This is not a first page,but pagination is not present");
				BaseTest.takeScreenshot();
				break;
			} else
			{
				if (findElement(AudienceRepository.audience_synchist_lastButton).getAttribute("class").contains("disabled"))
				{
					break;
				} else
				{
					javaScriptScrollDown();
					BaseTest.getTest().log(Status.INFO, "Page No : " + page);
					driver.findElement(autolocator(AudienceRepository.audience_synchist_nextButton)).click();
					pageLoaderLogo();
					page++;
				}
			}
		}
		ExtentManager.customReport(list);
		System.out.println(list);
		return list;
	}

	public List<Map<String, String>> validateAnalyticsGridView()
	{
		String uiData = "";
		selectCustomRange(-1, 0);
		int page = 1;
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		while (true)
		{
			List<WebElement> lists = findElements(AnalyticsRepository.analytics_listingcommunicationlist);
			for (int count = 0; count < lists.size(); count++)
			{
				Map<String, String> map = new LinkedHashMap<>();
				lists = findElements(AnalyticsRepository.analytics_listingcommunicationlist);
				String CommunicationName = lists.get(count).findElement(By.cssSelector("div[class='pt5']")).getText();
				map.put("Communication name", CommunicationName);
				map.put("Delivery method", lists.get(count).findElements(By.tagName("small")).get(1).getText());
				threadSleep(ObjectRepository.wait1sec);
				javaScriptScrollIntoView("Plus Icon,xpath,(//a[contains(@class,'plus')]/..)[" + (count + 1) + "]");
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,-130)");
				threadSleep(ObjectRepository.wait1sec);
				driver.findElement(By.xpath("(//a[contains(@class,'plus')]/..)[" + (count + 1) + "]")).click();
				pageLoaderLogo();
				List<WebElement> headers = driver.findElements(By.xpath("//tbody//th"));
				List<WebElement> rows = driver.findElements(By.xpath("//tbody//tbody//tr"));
				for (int row = 0; row < rows.size() - 1; row++)
				{
					List<WebElement> datas = rows.get(row).findElements(By.tagName("td"));
					for (int header = 0; header < headers.size(); header++)
					{
						String uiHeader = headers.get(header).getText();
						if (!uiHeader.equals("Undelivered") && !uiHeader.equals("Status") && !uiHeader.equals("Action"))
						{
							if (uiHeader.equals("Channel"))
							{
								threadSleep(ObjectRepository.wait1sec);
								mouseHover(datas.get(header).findElement(By.xpath("//div[contains(@class,'social-icon')]//i")));
								uiData = getStrText(DashboardRepository.allpage_tooltip);
							} else
							{
								uiData = datas.get(header).findElement(By.tagName("span")).getText();
							}
							map.put(uiHeader, uiData);
						}
					}
				}
				list.add(map);
				driver.findElement(By.xpath("//a[contains(@class,'minus')]")).click();
				pageLoaderLogo();
			}
			threadSleep(ObjectRepository.wait1sec);
			javaScriptScrollDown();
			if (!isElementPresent(AudienceRepository.audience_synchist_lastButton) && page == 1)
			{
				BaseTest.getTest().log(Status.INFO, "This is first page, Pagination is not present as expected.");
				BaseTest.takeScreenshot();
				break;
			} else if (!isElementPresent(AudienceRepository.audience_synchist_lastButton) && page != 1)
			{
				BaseTest.getTest().log(Status.INFO, "This is not a first page,but pagination is not present");
				BaseTest.takeScreenshot();
				break;
			} else
			{
				if (findElement(AudienceRepository.audience_synchist_lastButton).getAttribute("class").contains("disabled"))
				{
					break;
				} else
				{
					javaScriptScrollDown();
					BaseTest.getTest().log(Status.INFO, "Page No : " + page);
					driver.findElement(autolocator(AudienceRepository.audience_synchist_nextButton)).click();
					threadSleep(ObjectRepository.wait1sec);
					pageLoaderLogo();
					page++;
				}
			}
		}
		ExtentManager.customReport(list);
		System.out.println(list);
		return list;
	}

	public void clickAnalyticsListingListView()
	{
		clickElement(AnalyticsRepository.analytics_listview);
	}

	public List<Map<String, String>> validateAnalyticsListView()
	{
		clickAnalyticsListingListView();
		selectCustomRange(-1, 0);
		int page = 1;
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		while (true)
		{
			List<Map<String, String>> tableData = analyticsListingTable();
			list.addAll(tableData);
			threadSleep(ObjectRepository.wait1sec);
			javaScriptScrollDown();
			if (!isElementPresent(AudienceRepository.audience_synchist_lastButton) && page == 1)
			{
				BaseTest.getTest().log(Status.INFO, "This is first page, Pagination is not present as expected.");
				BaseTest.takeScreenshot();
				break;
			} else if (!isElementPresent(AudienceRepository.audience_synchist_lastButton) && page != 1)
			{
				BaseTest.getTest().log(Status.INFO, "This is not a first page,but pagination is not present");
				BaseTest.takeScreenshot();
				break;
			} else
			{
				if (findElement(AudienceRepository.audience_synchist_lastButton).getAttribute("class").contains("disabled"))
				{
					break;
				} else
				{
					javaScriptScrollDown();
					BaseTest.getTest().log(Status.INFO, "Page No : " + page);
					driver.findElement(autolocator(AudienceRepository.audience_synchist_nextButton)).click();
					pageLoaderLogo();
					page++;
				}
			}
		}
		ExtentManager.customReport(list);
		System.out.println(list);
		return list;
	}

	public List<Map<String, String>> analyticsListingTable()
	{
		List<Map<String, String>> list = new LinkedList<>();
		WebElement table = findElement("Table Loc,tag,table");
		List<WebElement> headers = table.findElements(By.tagName("th"));
		List<WebElement> rows = table.findElements(By.xpath("//tbody//tr"));

		for (int j = 0; j < rows.size(); j++)
		{
			headers = table.findElements(By.tagName("th"));
			rows = table.findElements(By.xpath("//tbody//tr"));
			Map<String, String> map = new LinkedHashMap<>();
			List<WebElement> datas = rows.get(j).findElements(By.tagName("td"));

			int headerSize = headers.size();
			int dataSize = datas.size();
			int missingDataCount = headerSize - dataSize;

			for (int i = 0; i < headerSize; i++)
			{
				datas = rows.get(j).findElements(By.tagName("td"));
				String head = headers.get(i).getText();
				if (i < missingDataCount)
				{
					map.put(head, "");
				} else
				{
					String dataValue = datas.get(i - missingDataCount).getText();
					if (dataValue.contains("...") && head.equals("Communication name"))
					{
						mouseHover(datas.get(i - missingDataCount));
						dataValue = getStrText(DashboardRepository.allpage_tooltip);
					} else if (head.equals("Channel"))
					{
						WebElement ele = datas.get(i - missingDataCount).findElement(By.tagName("i"));
						mouseHover(ele);
						map.put(head, getStrText(DashboardRepository.allpage_tooltip));
					} else
					{
						map.put(head, dataValue);
					}
				}
			}
			list.add(map);
		}
//		BaseTest.getTest().log(Status.INFO, list.toString());
//		ExtentManager.customReport(list);
		return list;
	}

	// VJ
	public void OverviewCountValidate(List<Map<String, String>> analyticsPageValue)
	{
		int totalSent = getListingTotalCount(analyticsPageValue, "Total sent");
		int[] listingAnalyticsCount = { getListingTotalCount(analyticsPageValue, "Reach"), getListingTotalCount(analyticsPageValue, "Engagement"), getListingTotalCount(analyticsPageValue, "Conversion") };
		String csrTotalSent = getStrText(AnalyticsRepository.analytics_CSR_Overviewtotalsent).replaceAll("[^0-9]", "");

		List<WebElement> headerName = findElements(AnalyticsRepository.analytics_CSR_OverviewheaderName);
		List<WebElement> count = findElements(AnalyticsRepository.analytics_CSR_Overviewcount);
		for (int i = 0; i < headerName.size(); i++)
		{
			String overviewHeaderName = headerName.get(i).getText();
			String overviewCount = count.get(i).getText();

		}

	}

	public int getListingTotalCount(List<Map<String, String>> analyticsPageValue, String header)
	{
		int count = 0;
		for (int i = 0; i < analyticsPageValue.size(); i++)
		{
			for (Map.Entry<String, String> map : analyticsPageValue.get(i).entrySet())
			{
				String key = map.getKey();
				if (key.equals(header))
				{
					if (!map.getValue().isEmpty())
					{
						count += Integer.parseInt(map.getValue());
						break;
					}
				}
			}
		}
		return count;
	}

	public void compareAnalyticsListingAndCSRPageValidate(List<Map<String, String>> analyticsPageValue)
	{
		listingPageTotalSent = getListingTotalCount(analyticsPageValue, "Total sent");
		listingPageReach = getListingTotalCount(analyticsPageValue, "Reach");
		listingPageEngagement = getListingTotalCount(analyticsPageValue, "Engagement");
		listingPageConversion = getListingTotalCount(analyticsPageValue, "Conversion");
		writeLog(listingPageTotalSent == Integer.parseInt(getReachOverviewSummary.get("Total sent")), "Listing page total sent count is " + listingPageTotalSent + " present as expected csr page count is " + getReachOverviewSummary.get("Total sent"),
				"Listing page total sent count is " + listingPageTotalSent + " not-present as expected csr page count is " + getReachOverviewSummary.get("Total sent"));
		writeLog(listingPageReach == Integer.parseInt(getReachOverviewSummary.get("Reach")), "Listing page Reach count is " + listingPageReach + " present as expected csr page count is " + getReachOverviewSummary.get("Reach"),
				"Listing page Reach count is " + listingPageReach + " not-present as expected csr page count is " + getReachOverviewSummary.get("Reach"));
		writeLog(listingPageEngagement == Integer.parseInt(getEngagementOverviewSummary.get("Engagement")),
				"Listing page Engagement count is " + listingPageEngagement + " present as expected csr page count is " + getEngagementOverviewSummary.get("Engagement"),
				"Listing page Engagement count is " + listingPageEngagement + " not-present as expected csr page count is " + getEngagementOverviewSummary.get("Engagement"));
		writeLog(listingPageConversion == Integer.parseInt(getConversionOverviewSummary.get("Conversion")),
				"Listing page Conversion count is " + listingPageEngagement + " present as expected csr page count is " + getConversionOverviewSummary.get("Conversion"),
				"Listing page Conversion count is " + listingPageEngagement + " not-present as expected csr page count is " + getConversionOverviewSummary.get("Conversion"));
		int reachInt = Integer.parseInt(getReachOverviewSummary.get("Percentage").replaceAll("%", ""));
		int reachpercentage = (int) (((double) listingPageReach / listingPageTotalSent) * 100);
		int engaementInt = Integer.parseInt(getEngagementOverviewSummary.get("Percentage").replaceAll("%", ""));
		int engaementpercentage = (int) (((double) listingPageEngagement / listingPageTotalSent) * 100);
		int conversionInt = Integer.parseInt(getConversionOverviewSummary.get("Percentage").replaceAll("%", ""));
		int conversionpercentage = (int) (((double) listingPageConversion / listingPageTotalSent) * 100);
		writeLog(reachpercentage == reachInt, "Listing page Reach percentage is present as expected.", "Listing page Reach percentage is not present as expected.");
		writeLog(engaementInt == engaementpercentage, "Listing page Engagement percentage is present as expected.", "Listing page Engagement percentage is not present as expected.");
		writeLog(conversionInt == conversionpercentage, "Listing page Conversion percentage is present as expected.", "Listing page Conversion percentage is not present as expected.");

		int gcd = findGCD(listingPageTotalSent, listingPageReach);
		String expectedRatio = listingPageTotalSent / gcd + ":" + listingPageReach / gcd;
		System.out.println(expectedRatio);
	}

	public void pw_compareAnalyticsListingAndCSRPageValidate(List<Map<String, String>> analyticsPageValue)
	{
		int listingPageTotalSent = getListingTotalCount(analyticsPageValue, "Total sent");
		int listingPageReach = getListingTotalCount(analyticsPageValue, "Reach");
		int listingPageEngagement = getListingTotalCount(analyticsPageValue, "Engagement");
		int listingPageConversion = getListingTotalCount(analyticsPageValue, "Conversion");
		writeLog(listingPageTotalSent == Integer.parseInt(getReachOverviewSummary.get("Total sent")), "Listing page total sent count is " + listingPageTotalSent + " present as expected csr page count is " + getReachOverviewSummary.get("Total sent"),
				"Listing page total sent count is " + listingPageTotalSent + " not-present as expected csr page count is " + getReachOverviewSummary.get("Total sent"));
		writeLog(listingPageReach == Integer.parseInt(getReachOverviewSummary.get("Reach")), "Listing page Reach count is " + listingPageReach + " present as expected csr page count is " + getReachOverviewSummary.get("Reach"),
				"Listing page Reach count is " + listingPageReach + " not-present as expected csr page count is " + getReachOverviewSummary.get("Reach"));
		writeLog(listingPageEngagement == Integer.parseInt(getEngagementOverviewSummary.get("Engagement")),
				"Listing page Engagement count is " + listingPageEngagement + " present as expected csr page count is " + getEngagementOverviewSummary.get("Engagement"),
				"Listing page Engagement count is " + listingPageEngagement + " not-present as expected csr page count is " + getEngagementOverviewSummary.get("Engagement"));
		writeLog(listingPageConversion == Integer.parseInt(getConversionOverviewSummary.get("Conversion")),
				"Listing page Conversion count is " + listingPageEngagement + " present as expected csr page count is " + getConversionOverviewSummary.get("Conversion"),
				"Listing page Conversion count is " + listingPageEngagement + " not-present as expected csr page count is " + getConversionOverviewSummary.get("Conversion"));

		writeLog((listingPageReach / listingPageTotalSent) * 100 == Integer.parseInt(getReachOverviewSummary.get("Percentage").replaceAll("%", "")), "Listing page Reach percentage is present as expected.",
				"Listing page Reach percentage is not present as expected.");
		writeLog((listingPageEngagement / listingPageTotalSent) * 100 == Integer.parseInt(getEngagementOverviewSummary.get("Percentage").replaceAll("%", "")), "Listing page Engagement percentage is present as expected.",
				"Listing page Engagement percentage is not present as expected.");
		writeLog((listingPageConversion / listingPageTotalSent) * 100 == Integer.parseInt(getConversionOverviewSummary.get("Percentage").replaceAll("%", "")), "Listing page Conversion percentage is present as expected.",
				"Listing page Conversion percentage is not present as expected.");

		int gcd = findGCD(listingPageTotalSent, listingPageReach);
		String expectedRatio = listingPageTotalSent / gcd + ":" + listingPageReach / gcd;
		System.out.println(expectedRatio);
	}

	public void compareChannelViseOverviewAndDetailsCount()
	{

	}

	public void CSROverviewPortletAndTableCountValidate()
	{
		List<WebElement> activeTab = findElements(AnalyticsRepository.analytics_CSR_OverviewdetailschannelTab);
		for (int i = 0; i < activeTab.size(); i++)
		{
			String channelName = activeTab.get(i).getText().toLowerCase();
			switch (channelName)
			{
			case "email" ->
			{
				emailChannelCSROverviewAndDetailsCountValidate();
			}
			case "sms" ->
			{
				smsChannelCSROverviewAndDetailsCountValidate();
			}
			case "web push" ->
					{

					}
			case "mobile push" ->
					{

					}
			case "qr" ->
					{

					}
			}
		}

		for (int i = 0; i < analyticsOverviewChannelsCount.size(); i++)
		{
			Map<String, String> analyticsOverview = analyticsOverviewChannelsCount.get(i);
			for (Map.Entry<String, String> map : analyticsOverview.entrySet())
			{
				String key = map.getKey();

			}

		}

	}

	public void emailChannelCSROverviewAndDetailsCountValidate()
	{
		writeLog(
				getReachOverviewSummary.get("Total sent").equals(emailChannelCommunicationAnalyticsOverviewPageCount.get("Target audience"))
						&& emailChannelCommunicationAnalyticsOverviewPageCount.get("Sent count").equals(emailChannelCommunicationAnalyticsOverviewPageCount.get("Delivered count")),
				"Email channel overview total sent,Target audience,Delivered count is present as expected.", "Email channel overview total sent,Target audience,Delivered count is not-present as expected.");
		writeLog(getReachOverviewSummary.get("Reach").equals(emailChannelCommunicationAnalyticsOverviewPageCount.get("Unique opens").split("(")[0]), "Overview unique open count is present as expected.",
				"Overview unique open count is not-present as expected.");
		writeLog(getReachOverviewSummary.get("Percentage").equals(StringUtils.substringBetween(getEngagementOverviewSummary.get("Unique opens"), "(", ")")), "Overview unique open percentage count is present as expected.",
				"Overview unique open count is present as expected.");
		writeLog(getEngagementOverviewSummary.get("Engagement").equals(emailChannelCommunicationAnalyticsOverviewPageCount.get("Unique clicks")), "Overview unique click count is present as expected.",
				"Overview unique click count is present as expected.");
		writeLog(getEngagementOverviewSummary.get("Percentage").equals(StringUtils.substringBetween(getEngagementOverviewSummary.get("Unique clicks"), "(", ")")), "Overview unique click percentage count is present as expected.",
				"Overview unique click count is present as expected.");
	}

	public void smsChannelCSROverviewAndDetailsCountValidate()
	{
		writeLog(getReachOverviewSummary.get("Total sent").equals(smsChannelCommunicationAnalyticsOverviewPageCount.get("Audience")), "Sms channel overview total sent,Target audience count is present as expected.",
				"Sms channel overview total sent,Target audience count is not-present as expected.");
		int totalAudience = Integer.parseInt(smsChannelCommunicationAnalyticsOverviewPageCount.get("Audience"));
		int totalCount = Integer.parseInt(smsChannelCommunicationAnalyticsOverviewPageCount.get("Delivered").split("(")[0]) + Integer.parseInt(smsChannelCommunicationAnalyticsOverviewPageCount.get("Expired").split("(")[0])
				+ Integer.parseInt(smsChannelCommunicationAnalyticsOverviewPageCount.get("Rejected").split("(")[0]) + Integer.parseInt(smsChannelCommunicationAnalyticsOverviewPageCount.get("DND").split("(")[0])
				+ Integer.parseInt(smsChannelCommunicationAnalyticsOverviewPageCount.get("Replied/Participated").split("(")[0]) + Integer.parseInt(smsChannelCommunicationAnalyticsOverviewPageCount.get("Undelivered").split("(")[0]);
		writeLog(totalAudience == totalCount, "Total audience count is present as expected.", "Total audience count is not present as expected.");
	}

	public void wpChannelCSROverviewAndDetailsCountValidate()
	{

	}

	public void mpChannelCSROverviewAndDetailsCountValidate()
	{

	}

	public void qrChannelCSROverviewAndDetailsCountValidate()
	{

	}

	public void analyticsCSRGridValidate()
	{
		List<WebElement> gridLists = findElements(",xpath,//div[contains(@class,'grid-lists')]//h3");
		for (int i = 0; i < gridLists.size(); i++)
		{
			String headerName = gridLists.get(i).getText();
			switch (headerName)
			{
			case "Device" ->
			{
				boolean val = false;
				if (isElementPresent("Nodata,xpath,//h3[.='" + headerName + "']//..//p[.='No data available']"))
				{
					BaseTest.getTest().log(Status.INFO, headerName + " portlet is displayed 'No data available'.");
					val = true;
				} else
				{
					String src = getTextBoxVal("Device image,xpath,//h3[text()='Device']//..//img", "src");
					String deviceName = getStrText("Device Id,xpath,//h3[.='Device']//..//small");
					writeLog(src.contains(deviceName), "Device grid portlet devicename is present as expected.", "Device grid portlet devicename is not-present as expected.");
					val = true;
				}
				writeLog(!val, headerName + " data is not displayed.", headerName + " data is not displayed.");
			}
			case "Brand perceptions" ->
			{
				boolean val = false;
				if (isElementPresent("Nodata,xpath,//h3[.='" + headerName + "']//..//p[.='No data available']"))
				{
					BaseTest.getTest().log(Status.INFO, headerName + " portlet is displayed 'No data available'.");
					val = true;
				} else
				{
					val = true;
				}
			}
			case "Demography" ->
			{
				boolean val = false;
				Map<String, Integer> map = new LinkedHashMap<String, Integer>();
				if (isElementPresent("Nodata,xpath,//h3[.='" + headerName + "']//..//p[.='No data available']"))
				{
					BaseTest.getTest().log(Status.INFO, headerName + " portlet is displayed 'No data available'.");
					val = true;
				} else
				{
					String highestReach = getStrText("highest reach,xpath,//h3[.='Demography']//..//small");
					map.put("Male", Integer.parseInt(getStrText("Male,xpath,(//h3[.='Demography']//..//li)[1]//h1").trim()));
					map.put("Female", Integer.parseInt(getStrText("Female,xpath,(//h3[.='Demography']//..//li)[2]//h1").trim()));
					String peakGender = map.get("Male") > map.get("Female") ? "Male" : "Female";
					writeLog(highestReach.contains(peakGender), "Dempgraphy value is present as expected.", "Demography value is not present as expected.");
					val = true;
				}
			}
			case "New contacts" ->
			{
				boolean val = false;
				if (isElementPresent("Nodata,xpath,//h3[.='" + headerName + "']//..//p[.='No data available']"))
				{
					BaseTest.getTest().log(Status.INFO, headerName + " portlet is displayed 'No data available'.");
					val = true;
				} else
				{
					val = true;
				}
			}
			}
		}

	}

	public static int findGCD(int a, int b)
	{
		while (b != 0)
		{
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	public void communicationAnalysisCSRPage()
	{
		int overAllCount = 0;
		Map<Double, Integer> yaxisMap = new LinkedHashMap<Double, Integer>();
		// Getting the dynamic Id for graph
		String dynamicId = getTextBoxVal("Communication analysis,xpath,//h3[text()='Communication analysis']//..//..//div[contains(@class,'highcharts-container areachart')]", "id");
		// Getting the yaxis value and location
		List<WebElement> yaxis = findElements(",css,div[id*='" + dynamicId + "'] g[class*='highcharts-axis-labels highcharts-yaxis-labels']>text");
		for (WebElement axis : yaxis)
		{
			double yaxisValue = Double.parseDouble(axis.getText().trim());
			int yaxiscoordinates = axis.getLocation().getY();
			yaxisMap.put(yaxisValue, yaxiscoordinates);
		}
		// Getting the top header time
		String[] headTime = getStrText("HeadTime,xpath,//span[contains(@class,'head-time')]").split("-");
		String startDate = headTime[0].trim();
		String endDate = headTime[1].trim();
		String startEndDateFormatter = "EEE, MMM dd, YYYY";
		String actualFormatter = "EEE, dd MMM, YYYY hh:mm a";

		Date startDateFormat = convertStringToDate(startDate, startEndDateFormatter);
		Date endDateFormat = convertStringToDate(endDate, startEndDateFormatter);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-400)");
		threadSleep(ObjectRepository.wait1sec);
		List<WebElement> chartValues = findElements("Chart value,css,g[class='highcharts-series-group'] g[class='highcharts-markers highcharts-series-0 highcharts-areaspline-series highcharts-tracker']>path:not([visibility='hidden'])");
		for (WebElement chartValue : chartValues)
		{
			threadSleep(ObjectRepository.wait2sec);
			Actions actions = new Actions(driver);
			actions.moveToElement(chartValue).build();
			actions.perform();

			int graphLocation = chartValue.getLocation().getY();

			List<WebElement> tooltipText = findElements("TooltipText,css,div[class*='highcharts-tooltip'] span[class='font-xs']");
			Date actualDateFormat = convertStringToDate(tooltipText.get(0).getText(), actualFormatter);
			if ((startDateFormat.equals(actualDateFormat) || startDateFormat.before(actualDateFormat)) && (endDateFormat.equals(actualDateFormat) || endDateFormat.after(actualDateFormat)))
			{
				BaseTest.getTest().log(Status.INFO, actualDateFormat.toString() + " actual date is within the start and end date range.");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, actualDateFormat.toString() + " actual date doesn't fall within the start and end date range.");
			}
			int graphPoint = Integer.parseInt(tooltipText.get(2).getText().trim());
			overAllCount += graphPoint;
			int index = 1;
			List<Double> list = new ArrayList<>(yaxisMap.keySet());
			for (int j = 0; j < list.size(); j++)
			{
				double yCount = list.get(j);
				double yLocation = yaxisMap.get(yCount);
				if (graphPoint == yCount)
				{
					if (graphLocation == yLocation || graphLocation < yLocation + 15)
					{
						BaseTest.getTest().log(Status.INFO, "The Graph trace point --> " + graphPoint + ", Exactly plotted on Y-Axis line --> " + yCount);
						break;
					} else
					{
						javaScriptHighLightwithScrnShot(chartValue);
						BaseTest.getTest().log(Status.FAIL, "The Graph trace point plotted not as Expected");
					}

				} else if (graphPoint < yCount && j != 0)
				{
					double prevCount = list.get(j - 1);
					if (graphLocation > yLocation && graphLocation < yaxisMap.get(prevCount))
					{
						BaseTest.getTest().log(Status.INFO, "The Graph trace point --> " + graphPoint + ", Falls between -->  " + yCount + " & " + prevCount + " on Y-Axis line");
						break;
					}
				} else if (index == list.size())
				{
					BaseTest.getTest().log(Status.FAIL, "The Graph trace point plotted not as Expected");
					BaseTest.takeScreenshot();
				}
				index++;
			}
		}
	}

	public void pw_communicationAnalysisCSRPage()
	{
		int overAllCount = 0;
		Map<Double, Integer> yaxisMap = new LinkedHashMap<Double, Integer>();
		if (!pw_isElementPresent(AnalyticsRepository.pw_analytics_nodataavailable))
		{
			// Getting the dynamic Id for graph
			String dynamicId = pw_getTextBoxVal(AnalyticsRepository.pw_analytics_communicationanalysisgetdynamicId, "id");
			// Getting the yaxis value and location
			Locator yaxis = pw_findelements(replacePlaceHolder(AnalyticsRepository.pw_analytics_communicationanalysisyaxis, dynamicId));
			for (int i = 0; i < yaxis.count(); i++)
			{
				double yaxisValue = Double.parseDouble(yaxis.nth(i).textContent().trim());
				int yaxiscoordinates = (int) yaxis.nth(i).boundingBox().y;
				yaxisMap.put(yaxisValue, yaxiscoordinates);
			}
			// Getting the top header time
			String[] headTime = pw_getStrText(AnalyticsRepository.pw_analytics_topheadtime).split("-");
			String startDate = headTime[0].trim();
			String endDate = headTime[1].trim();
			String startEndDateFormatter = "EEE, MMM dd, YYYY";
			String actualFormatter = "EEE, dd MMM, YYYY hh:mm a";

			Date startDateFormat = convertStringToDate(startDate, startEndDateFormatter);
			Date endDateFormat = convertStringToDate(endDate, startEndDateFormatter);

			page.evaluate("window.scrollBy(0,-400)");
			threadSleep(ObjectRepository.wait1sec);
			Locator chartValues = pw_findelements(AnalyticsRepository.pw_analytics_communicationanalysischartvalue);
			for (int i = 0; i < chartValues.count(); i++)
			{
				threadSleep(ObjectRepository.wait2sec);
				chartValues.nth(i).hover();

				int graphLocation = (int) chartValues.nth(i).boundingBox().y;
				Locator tooltipText = pw_findelements(AnalyticsRepository.pw_analytics_communicationanalysischarttooltip);
				Date actualDateFormat = convertStringToDate(tooltipText.nth(0).textContent(), actualFormatter);
				if ((startDateFormat.equals(actualDateFormat) || startDateFormat.before(actualDateFormat)) && (endDateFormat.equals(actualDateFormat) || endDateFormat.after(actualDateFormat)))
				{
					BaseTest.getTest().log(Status.INFO, actualDateFormat.toString() + " actual date is within the start and end date range.");
				} else
				{
					BaseTest.getTest().log(Status.FAIL, actualDateFormat.toString() + " actual date doesn't fall within the start and end date range.");
				}
				int graphPoint = Integer.parseInt(tooltipText.nth(2).textContent().trim());
				overAllCount += graphPoint;
				int index = 1;
				List<Double> list = new ArrayList<>(yaxisMap.keySet());
				for (int j = 0; j < list.size(); j++)
				{
					double yCount = list.get(j);
					double yLocation = yaxisMap.get(yCount);
					if (graphPoint == yCount)
					{
						if (graphLocation == yLocation || graphLocation < yLocation + 15)
						{
							BaseTest.getTest().log(Status.INFO, "The Graph trace point --> " + graphPoint + ", Exactly plotted on Y-Axis line --> " + yCount);
							break;
						} else
						{
							pw_javaScriptHighLightwithScrnShot(chartValues.nth(i));
							BaseTest.getTest().log(Status.FAIL, "The Graph trace point plotted not as Expected");
						}

					} else if (graphPoint < yCount && j != 0)
					{
						double prevCount = list.get(j - 1);
						if (graphLocation > yLocation && graphLocation < yaxisMap.get(prevCount))
						{
							BaseTest.getTest().log(Status.INFO, "The Graph trace point --> " + graphPoint + ", Falls between -->  " + yCount + " & " + prevCount + " on Y-Axis line");
							break;
						}
					} else if (index == list.size())
					{
						BaseTest.getTest().log(Status.FAIL, "The Graph trace point plotted not as Expected");
						BaseTest.pw_takesScreenshot();
					}
					index++;
				}
			}
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Communication analysis displayed 'No data available.'");
			BaseTest.pw_takesScreenshot();
		}

	}

	public void setGoldenCommunication(String communicationName)
	{
		if (getTextBoxVal(AnalyticsRepository.goldenCommunication, "class").contains("yellow"))
		{
			toolTipValidationKnownText(AnalyticsRepository.goldenCommunication, "Set as Golden Communication");
			clickElement(AnalyticsRepository.goldenCommunication);
			String starIcon = getTextBoxVal(AnalyticsRepository.goldenCommunication, "class");
			writeLog(!starIcon.contains("yellow"), "Unmark the golden communication present as expected.", "Unmark the golden communication not-present as expected.");
		} else
		{
			toolTipValidationKnownText(AnalyticsRepository.goldenCommunication, "Golden Communication");
			clickElement(AnalyticsRepository.goldenCommunication);
			String alertMessage = getStrText(AnalyticsRepository.alertMessage);
			writeLog(alertMessage.equals(communicationName + "  is marked as Golden communication!"), alertMessage + " is displayed as expected.", alertMessage + " is not-displayed as expected.");
		}
	}

	public void pw_setGoldenCommunication(String communicationName)
	{
		pw_pageLoaderLogo();
		threadSleep(ObjectRepository.wait1sec);
		if (pw_getTextBoxVal(AnalyticsRepository.pw_analytics_goldencommunication, "class").contains("yellow"))
		{
			pw_toolTipValidationKnownText(AnalyticsRepository.pw_analytics_goldencommunication, "Set as Golden Communication");
//			clickElement(AnalyticsRepository.pw_analytics_goldencommunication);
//			pw_pageLoaderLogo();
//			threadSleep(ObjectRepository.wait1sec);
//			String starIcon = pw_getTextBoxVal(AnalyticsRepository.pw_analytics_goldencommunication, "class");
//			writeLog(!starIcon.contains("yellow"), "Unmark the golden communication present as expected.", "Unmark the golden communication not-present as expected.");
		} else
		{
			pw_pageLoaderLogo();
			pw_toolTipValidationKnownText(AnalyticsRepository.pw_analytics_goldencommunication, "Set as Golden Communication");
			pw_clickElement(AnalyticsRepository.pw_analytics_goldencommunication);
			pw_pageLoaderLogo();
			threadSleep(ObjectRepository.wait1sec);
			String alertMessage = pw_getStrText(AnalyticsRepository.pw_analytics_alertMessage);
			writeLog(alertMessage.equals(communicationName + "  is marked as Golden communication!"), alertMessage + " is displayed as expected.", alertMessage + " is not-displayed as expected.");
		}
	}

	public void csrPageDownloadIcon()
	{
		toolTipValidationKnownText("Download Icon,css,#rs_data_download", "Download");
		clickElement("Download Icon,css,#rs_data_download");
		clickElement("Download dropdown,xpath,//i[@id='rs_data_download']//..//span");
		threadSleep(ObjectRepository.wait3sec);
		pageLoaderLogo();
	}

	public void headerBenchmarkIcon()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Long initialScrollPosition = (Long) js.executeScript("return window.scrollY;");
		toolTipValidationKnownText(AnalyticsRepository.csrPageBenchmarkIcon, "Benchmark");
		clickElement(AnalyticsRepository.csrPageBenchmarkIcon);
		threadSleep(ObjectRepository.wait1sec);
		Long finalScrollPosition = (Long) js.executeScript("return window.scrollY;");
		writeLog(finalScrollPosition > initialScrollPosition, "Page scrolled after clicked the benchmark icon.", "Page not scrolled after clicked the benchmark icon.");
	}

	public void pw_headerBenchmarkIcon()
	{
		Object scrollPosition = null;
		scrollPosition = page.evaluate("() => window.scrollY");
		Double initialScrollPosition = ((Number) scrollPosition).doubleValue();
		pw_toolTipValidationKnownText(AnalyticsRepository.csrPageBenchmarkIcon, "Benchmark");
		pw_clickElement(AnalyticsRepository.pw_analytics_benchmarkicon);
		threadSleep(ObjectRepository.wait1sec);
		scrollPosition = page.evaluate("() => window.scrollY");
		Double finalScrollPosition = ((Number) scrollPosition).doubleValue();
		pw_writeLog(finalScrollPosition > initialScrollPosition, "Page scrolled after clicked the benchmark icon.", "Page not scrolled after clicked the benchmark icon.");
	}

	public void accessAnalyticsListingPage()
	{
		String Communication = "SDC Email feb 10_copy1";
		analyticSearchcommunication(Communication);
		clickElement("List Expansion,xpath,//div[text()='" + Communication + "']//ancestor::td//preceding-sibling::td//a[@aria-label='Expand detail row']");
		explicitwaitforclick(autolocator(AnalyticsRepository.analytics_listing_previewicon), 5);
		clickElement(AnalyticsRepository.analytics_listing_previewicon);
		threadSleep(ObjectRepository.wait2sec);
		if (isDisplayed("preview,xpath,//div[contains(@class,'analyticslistpreview')]"))
		{
			BaseTest.getTest().info("Communication Preview is displayed and it is verified");
			BaseTest.takeScreenshot();
		}
	}

	public List<Map<String, String>> getListingPageChannelDetails(String nameOfListingPage)
	{
		List<Object> l = new ArrayList<>();
		String analyticsListingHeaders = "//div[@class='k-widget k-grid']/table/thead/tr/th";
		String analyticsListingRows = "//div[@class='k-widget k-grid']/table/tbody/tr";
		threadSleep(ObjectRepository.wait3sec);
		pageLoaderLogo();
		explicitwaitforvisibility(autolocator(replacePlaceHolder(CommunicationRepository.CommunicationListing_plusIconForDetails, communicationName)), 50);
		clickElement(replacePlaceHolder(CommunicationRepository.CommunicationListing_plusIconForDetails, communicationName));
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait20sec);
		List<WebElement> trows, theads, tdata;
		theads = driver.findElements(By.xpath(analyticsListingHeaders));
		trows = driver.findElements(By.xpath(analyticsListingRows));

		System.out.println("Heads:" + theads.size());
		System.out.println("trows:" + trows.size());

		for (int rowSize = 0; rowSize < trows.size(); rowSize++)
		{
			analyticsListingChannelResults = new HashMap<String, String>();
			WebElement row = trows.get(rowSize);
			tdata = row.findElements(By.tagName("td"));
			System.out.println("current row data size:" + tdata.size());
			for (int dataValue = 0; dataValue < tdata.size(); dataValue++)
			{
				WebElement value = tdata.get(dataValue);
				WebElement headerName = theads.get(dataValue);
				if (headerName.getText().toLowerCase().contains("status"))
				{
					String status = value.findElement(By.tagName("i")).getAttribute("title");

					analyticsListingChannelResults.put(headerName.getText(), status);
					// Campaign listing page Schedule time get

					if (status.toLowerCase().contains("scheduled") && !nameOfListingPage.toLowerCase().contains("analytics"))
					{
						analyticsListingChannelResults.put("ScheduledTime", value.getText().trim());
					}
				} else if (headerName.getText().toLowerCase().contains("channel"))
				{
					String channel = value.findElement(By.tagName("i")).getAttribute("title");
					analyticsListingChannelResults.put(headerName.getText(), channel);
				} else
				{
					analyticsListingChannelResults.put(headerName.getText(), value.getText().trim());
				}
			}
			communicationAnalyticsListingCount.add(rowSize, analyticsListingChannelResults);

		}
		for (int i = 0; i < communicationAnalyticsListingCount.size(); i++)
		{
			String channelName = "Channel";
			Map<String, String> channelwise = communicationAnalyticsListingCount.get(i);
			if (channelwise.get(channelName).toLowerCase().contains("email"))
			{
				for (Map.Entry<String, String> entry : channelwise.entrySet())
				{
					emailChannelCommunicationAnalyticsListingPageCount.put(entry.getKey(), entry.getValue());
				}
			} else if (channelwise.get(channelName).toLowerCase().contains("sms"))
			{
				for (Map.Entry<String, String> entry : channelwise.entrySet())
				{
					smsChannelCommunicationAnalyticsListingPageCount.put(entry.getKey(), entry.getValue());
				}
			} else if (channelwise.get(channelName).toLowerCase().contains("web notification"))
			{
				for (Map.Entry<String, String> entry : channelwise.entrySet())
				{
					webChannelCommunicationAnalyticsListingPageCount.put(entry.getKey(), entry.getValue());
				}
			} else if (channelwise.get(channelName).toLowerCase().contains("mobile"))
			{
				for (Map.Entry<String, String> entry : channelwise.entrySet())
				{
					mobileChannelCommunicationAnalyticsListingPageCount.put(entry.getKey(), entry.getValue());
				}
			} else if (channelwise.get(channelName).toLowerCase().contains("qr"))
			{
				for (Map.Entry<String, String> entry : channelwise.entrySet())
				{
					qrChannelCommunicationAnalyticsListingPageCount.put(entry.getKey(), entry.getValue());
				}

			} else if (channelwise.get(channelName).toLowerCase().contains("whatsapp"))
			{
				for (Map.Entry<String, String> entry : channelwise.entrySet())
				{
					whatsappChannelCommunicationAnalyticsListingPageCount.put(entry.getKey(), entry.getValue());
				}
			} else if (channelwise.get(channelName).toLowerCase().contains("vms"))
			{
				for (Map.Entry<String, String> entry : channelwise.entrySet())
				{
					vmsChannelCommunicationAnalyticsListingPageCount.put(entry.getKey(), entry.getValue());
				}
			}
		}
		threadSleep(ObjectRepository.wait3sec);
		BaseTest.getTest().log(Status.INFO, "Analytics Listing Details of : " + emailChannelCommunicationAnalyticsListingPageCount);
		BaseTest.getTest().log(Status.INFO, "Analytics Listing Details of : " + smsChannelCommunicationAnalyticsListingPageCount);
		BaseTest.getTest().log(Status.INFO, "Analytics Listing Details of : " + webChannelCommunicationAnalyticsListingPageCount);
		BaseTest.getTest().log(Status.INFO, "Analytics Listing Details of : " + mobileChannelCommunicationAnalyticsListingPageCount);
		BaseTest.getTest().log(Status.INFO, "Analytics Listing Details of : " + qrChannelCommunicationAnalyticsListingPageCount);
		System.out.println("==================");
		clickElement(CommunicationRepository.CommunicationListing_minusicon);
		return communicationAnalyticsListingCount;
	}

	public AnalyticsOverviewDetailsPage analyticsDetailedPageVerification(String channel)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("ANALYTICS DETAILS - Reach Portlet", ExtentColor.BLUE));
		javaScriptHighLightwithScrnShot(AnalyticsRepository.analytics_DetailPage_reachPortlet);
		selectexactlistelements(AnalyticsRepository.analytics_DetailPage_reachOptions, "Overall");
		explicitwaitforvisibility(autolocator(AnalyticsRepository.analytics_DetailPage_reachChart), 10);
		javascriptdoublescrolldown();
		threadSleep(ObjectRepository.wait3sec);
		clickElement(AnalyticsRepository.analytics_DetailPage_reachchartExpand);
		isDisplayed(AnalyticsRepository.analytics_DetailPage_reachgraph);
		BaseTest.takeScreenshot();
		BaseTest.getTest().info(MarkupHelper.createLabel("ANALYTICS DETAILS - Engagement Portlet", ExtentColor.BLUE));
		javascriptdoublescrolldown();
		isDisplayed(AnalyticsRepository.analytics_DetailPage_engementgraph);
		BaseTest.takeScreenshot();
		BaseTest.getTest().info(MarkupHelper.createLabel("ANALYTICS DETAILS - Total Link Clicks Activity", ExtentColor.BROWN));
		javaScriptScrollDown();
		isDisplayed(AnalyticsRepository.analytics_details_totallinkClick);
		javaScriptHighLightwithScrnShot(AnalyticsRepository.analytics_details_totallinkClick);

		String Row = AnalyticsRepository.analytics_details_totallinkClick_rows;
		String Header = AnalyticsRepository.analytics_details_totallinkClick_headers;
		if (!findElements(Row).isEmpty())
		{
			totalLinkClick = getWebTableData(Header, Row, AnalyticsRepository.analytics_details_totallinkClick_pagination);
			ExtentManager.customReport(totalLinkClick);

		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Headers present, but No Data available");
		}

		return this;

	}

	public AnalyticsOverviewDetailsPage reachPortlet(String channel)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("ANALYTICS DETAILS - Reach Portlet", ExtentColor.BLUE));
		javaScriptHighLightwithScrnShot(AnalyticsRepository.analytics_DetailPage_reachPortlet);
		selectexactlistelements(AnalyticsRepository.analytics_DetailPage_reachOptions, "Overall");
		explicitwaitforvisibility(autolocator(AnalyticsRepository.analytics_DetailPage_reachChart), 10);
		javascriptdoublescrolldown();
		threadSleep(ObjectRepository.wait3sec);
		clickElement(AnalyticsRepository.analytics_DetailPage_reachchartExpand);
		String idvalue = getTextBoxVal(AnalyticsRepository.analytics_DetailPage_reachgraphid, "id");
		if (isDisplayed(replacePlaceHolder(AnalyticsRepository.analytics_DetailPage_reachTracepoint, idvalue)))
		{
			DecimalFormat df = new DecimalFormat("#.##");
			if (channel.equalsIgnoreCase("Email"))
			{
				int totalOpens = analyticsGraph("Reach", replacePlaceHolder(AnalyticsRepository.analytics_DetailPage_reachTracepoint, idvalue), 1);
				double totalAudience = Double.parseDouble(emailAnalyticsDetailsPageCount.get("Total sent"));

				double graphOpenPercent = Double.parseDouble(df.format(totalOpens / totalAudience * 100));

				BaseTest.getTest().log(Status.INFO, "Unique opens Percentage: " + graphOpenPercent);

			} else
			{
				int totalDelivered = analyticsGraph("Reach", replacePlaceHolder(AnalyticsRepository.analytics_DetailPage_reachTracepoint, idvalue), 1);
				BaseTest.getTest().log(Status.INFO, "Delivered : " + totalDelivered);
				int overviewReach = Integer.parseInt(detailsOverview.get("Reach"));
				if (overviewReach == totalDelivered)
				{
					BaseTest.getTest().log(Status.INFO, "Reach portlet values are same compare to Reach Overview Dashboard");
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Reach portlet values are differ compare to Reach Overview Dashboard");
					BaseTest.takeScreenshot();
				}
			}
			clickElement(AnalyticsRepository.analytics_DetailPage_reachchartExpand);
			threadSleep(ObjectRepository.wait2sec);
		}
		return this;
	}

	public AnalyticsOverviewDetailsPage pw_reachPortlet(String channel)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("ANALYTICS DETAILS - Reach Portlet", ExtentColor.BLUE));
		pw_javaScriptHighLightwithScrnShot(AnalyticsRepository.analytics_DetailPage_reachPortlet);
		pw_selectlistelements(AnalyticsRepository.analytics_DetailPage_reachOptions, "Overall");
		pw_clickElement(AnalyticsRepository.analytics_DetailPage_reachchartExpand);
		String idvalue = pw_getTextBoxVal(AnalyticsRepository.analytics_DetailPage_reachgraphid, "id");
		if (isDisplayed(replacePlaceHolder(AnalyticsRepository.analytics_DetailPage_reachTracepoint, idvalue)))
		{
			DecimalFormat df = new DecimalFormat("#.##");
			if (channel.equalsIgnoreCase("Email"))
			{
				int totalOpens = pw_analyticsGraph("Reach", replacePlaceHolder(AnalyticsRepository.analytics_DetailPage_reachTracepoint, idvalue), 1);
				double totalAudience = Double.parseDouble(emailAnalyticsDetailsPageCount.get("Total sent"));

				double graphOpenPercent = Double.parseDouble(df.format(totalOpens / totalAudience * 100));

				BaseTest.getTest().log(Status.INFO, "Unique opens Percentage: " + graphOpenPercent);

			} else
			{
				int totalDelivered = pw_analyticsGraph("Reach", replacePlaceHolder(AnalyticsRepository.analytics_DetailPage_reachTracepoint, idvalue), 1);
				BaseTest.getTest().log(Status.INFO, "Delivered : " + totalDelivered);
				int overviewReach = Integer.parseInt(detailsOverview.get("Reach"));
				if (overviewReach == totalDelivered)
				{
					BaseTest.getTest().log(Status.INFO, "Reach portlet values are same compare to Reach Overview Dashboard");
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Reach portlet values are differ compare to Reach Overview Dashboard");
					BaseTest.takeScreenshot();
				}
			}
			pw_clickElement(AnalyticsRepository.analytics_DetailPage_reachchartExpand);
		}
		return this;
	}

	public AnalyticsOverviewDetailsPage userEngagementPortlet(String portlet, String locator)
	{
		locator = locator.split(",")[2];
		BaseTest.getTest().info(MarkupHelper.createLabel("User engagement - " + portlet + " portlet", ExtentColor.BLUE));
		List<WebElement> chart, titleLegends;
		actionScrollToElement(portlet + ",xpath,//h4[text()='" + portlet + "']").javaScriptScrollDownToSomeExtend();
		javaScriptHighLightwithScrnShot(portlet + ",xpath,//h4[text()='" + portlet + "']");
		javascriptdoublescrolldown();
		chart = findElements("Chart data list,xpath," + locator.concat("//..//*[contains(@class,'highcharts-container piechart-default-render')]"));
		titleLegends = findElements("TitleLegends,xpath," + locator.concat("//..//span[@title]"));
		if (portlet.equals("Communication status"))
		{
			titleLegends = findElements("TitleLegends,xpath," + locator.concat("//*[contains(@class,'highcharts-legend-item highcharts')]"));
		}
		if (chart.size() != 0)
		{
			double[] array = new double[chart.size()];

			for (int count = 0; count < chart.size(); count++)
			{
				mouseHover(chart.get(count));
				String titleLegend = titleLegends.get(count).getText().trim();
				String chartPercent = chart.get(count).getText().trim();
				String tooltip[] = getStrText("Chart Tooltip,xpath," + locator + "//..//..//div[contains(@class,'highcharts-tooltip')]").split("\\R");
				String browser = tooltip[0].trim();
				String percentage = tooltip[1].split(":")[1].trim();
				if (browser.equalsIgnoreCase(titleLegend) && percentage.equals(chartPercent))
				{
					BaseTest.getTest().log(Status.INFO, browser + " ---> " + percentage);
				} else
				{
					BaseTest.getTest().log(Status.FAIL, browser + " ---> " + percentage + " values are not as Expected");
					javaScriptHighLightwithScrnShot(chart.get(count));
				}
				array[count] = Double.parseDouble(percentage.split("%")[0]);
			}
			BaseTest.getTest().log(Status.INFO, "Chart values are matched with tooltip values");

		} else
		{
			BaseTest.getTest().log(Status.FAIL, "No Data available");
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public AnalyticsOverviewDetailsPage pw_userEngagementPortlet(String portlet, String locator)
	{
		locator = locator.split(",")[2];
		BaseTest.getTest().info(MarkupHelper.createLabel("User engagement - " + portlet + " portlet", ExtentColor.BLUE));
		List<WebElement> chart, titleLegends;
		// actionScrollToElement(portlet + ",xpath,//h4[text()='" + portlet + "']").javaScriptScrollDownToSomeExtend();
		pw_javaScriptHighLightwithScrnShot(portlet + ",xpath,//h4[text()='" + portlet + "']");
		chart = findElements("Chart data list,xpath," + locator.concat("//..//*[contains(@class,'highcharts-container piechart-default-render')]"));
		titleLegends = findElements("TitleLegends,xpath," + locator.concat("//..//span[@title]"));
		if (portlet.equals("Communication status"))
		{
			titleLegends = findElements("TitleLegends,xpath," + locator.concat("//*[contains(@class,'highcharts-legend-item highcharts')]"));
		}
		if (chart.size() != 0)
		{
			double[] array = new double[chart.size()];

			for (int count = 0; count < chart.size(); count++)
			{
				mouseHover(chart.get(count));
				String titleLegend = titleLegends.get(count).getText().trim();
				String chartPercent = chart.get(count).getText().trim();
				String tooltip[] = pw_getStrText("Chart Tooltip,xpath," + locator + "//..//..//div[contains(@class,'highcharts-tooltip')]").split("\\R");
				String browser = tooltip[0].trim();
				String percentage = tooltip[1].split(":")[1].trim();
				if (browser.equalsIgnoreCase(titleLegend) && percentage.equals(chartPercent))
				{
					BaseTest.getTest().log(Status.INFO, browser + " ---> " + percentage);
				} else
				{
					BaseTest.getTest().log(Status.FAIL, browser + " ---> " + percentage + " values are not as Expected");
					pw_javaScriptHighLightwithScrnShot(chart.get(count));
				}
				array[count] = Double.parseDouble(percentage.split("%")[0]);
			}
			BaseTest.getTest().log(Status.INFO, "Chart values are matched with tooltip values");

		} else
		{
			BaseTest.getTest().log(Status.FAIL, "No Data available");
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public int engagementPortlet(String channel)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("ANALYTICS DETAILS - Engagement Portlet", ExtentColor.BLUE));
		javascriptdoublescrolldown();

		int uniqueClicks = 0;
		String idvalue = getTextBoxVal(AnalyticsRepository.analytics_DetailPage_engaementgraphid, "id");

		if (isDisplayed(replacePlaceHolder(AnalyticsRepository.analytics_DetailPage_reachTracepoint, idvalue)))
		{
			if (channel.equalsIgnoreCase("Email"))
			{
				uniqueClicks = analyticsGraph("Engagement", replacePlaceHolder(AnalyticsRepository.analytics_DetailPage_reachTracepoint, idvalue), 1);

				BaseTest.getTest().log(Status.INFO, "uniqueClicks : " + uniqueClicks);

				if (uniqueClicks == listingPageEngagement)
				{
					BaseTest.getTest().log(Status.INFO, "Engagement portlet values are same compare to Engagement Overview");
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Engagement portlet values are differ compare to Reach Overview");
					BaseTest.takeScreenshot();
				}
			} else
			{
				uniqueClicks = analyticsGraph("Engagement", AnalyticsRepository.analytics_details_Engagement_OrangetracePoint, 1);
				BaseTest.getTest().log(Status.INFO, "uniqueClicks : " + uniqueClicks);
				int overviewEngagement = Integer.parseInt(detailsOverview.get("Engagement"));
				if (overviewEngagement == uniqueClicks || overviewEngagement > uniqueClicks)
				{
					BaseTest.getTest().log(Status.INFO, "Engagement Portlet values are same compare to Engagement Overview dashboard");
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Engagement Portlet values are differ compare to Engagement Overview dashboard");
					BaseTest.takeScreenshot();
				}
			}
		}
		return uniqueClicks;
	}

	public int pw_engagementPortlet(String channel)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("ANALYTICS DETAILS - Engagement Portlet", ExtentColor.BLUE));

		int uniqueClicks = 0;
		String idvalue = pw_getTextBoxVal(AnalyticsRepository.analytics_DetailPage_engaementgraphid, "id");

		if (isDisplayed(replacePlaceHolder(AnalyticsRepository.analytics_DetailPage_reachTracepoint, idvalue)))
		{
			if (channel.equalsIgnoreCase("Email"))
			{
				uniqueClicks = pw_analyticsGraph("Engagement", replacePlaceHolder(AnalyticsRepository.analytics_DetailPage_reachTracepoint, idvalue), 1);

				BaseTest.getTest().log(Status.INFO, "uniqueClicks : " + uniqueClicks);

				if (uniqueClicks == listingPageEngagement)
				{
					BaseTest.getTest().log(Status.INFO, "Engagement portlet values are same compare to Engagement Overview");
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Engagement portlet values are differ compare to Reach Overview");
					BaseTest.takeScreenshot();
				}
			} else
			{
				uniqueClicks = pw_analyticsGraph("Engagement", AnalyticsRepository.analytics_details_Engagement_OrangetracePoint, 1);
				BaseTest.getTest().log(Status.INFO, "uniqueClicks : " + uniqueClicks);
				int overviewEngagement = Integer.parseInt(detailsOverview.get("Engagement"));
				if (overviewEngagement == uniqueClicks || overviewEngagement > uniqueClicks)
				{
					BaseTest.getTest().log(Status.INFO, "Engagement Portlet values are same compare to Engagement Overview dashboard");
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Engagement Portlet values are differ compare to Engagement Overview dashboard");
					BaseTest.takeScreenshot();
				}
			}
		}
		return uniqueClicks;
	}

	public AnalyticsOverviewDetailsPage verifyDownloadedCSV(String Channel)
	{
		boolean var = true;
		actionScrollToElement(AnalyticsRepository.analytics_details_totallinkClick_CSV).javaScriptScrollUpToSomeExtend();
		clickElement(AnalyticsRepository.analytics_details_totallinkClick_CSV);
		List<Map<String, String>> file = csvFileReader();
		if (!totalLinkClick.isEmpty() || !file.isEmpty())
		{
			for (int index = 0; index < totalLinkClick.size(); index++)
			{
				Map<String, String> grid = totalLinkClick.get(index);
				Map<String, String> csv = file.get(index);
				if (!grid.equals(csv))
				{
					BaseTest.getTest().log(Status.FAIL, "Grid --> " + grid + " and CSV -->" + csv + " values are Mismatched");
					BaseTest.takeScreenshot();
					var = false;
				}
			}
			if (var)
			{
				BaseTest.getTest().log(Status.INFO, "Downloaded CSV  ---> " + file);
				BaseTest.getTest().log(Status.INFO, "Grid values and download CSV values are same");
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "No Data available");
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public AnalyticsOverviewDetailsPage pw_verifyDownloadedCSV(String Channel)
	{
		boolean var = true;
		actionScrollToElement(AnalyticsRepository.analytics_details_totallinkClick_CSV).javaScriptScrollUpToSomeExtend();
		pw_clickElement(AnalyticsRepository.analytics_details_totallinkClick_CSV);
		List<Map<String, String>> file = csvFileReader();
		if (!totalLinkClick.isEmpty() || !file.isEmpty())
		{
			for (int index = 0; index < totalLinkClick.size(); index++)
			{
				Map<String, String> grid = totalLinkClick.get(index);
				Map<String, String> csv = file.get(index);
				if (!grid.equals(csv))
				{
					BaseTest.getTest().log(Status.FAIL, "Grid --> " + grid + " and CSV -->" + csv + " values are Mismatched");
					BaseTest.takeScreenshot();
					var = false;
				}
			}
			if (var)
			{
				BaseTest.getTest().log(Status.INFO, "Downloaded CSV  ---> " + file);
				BaseTest.getTest().log(Status.INFO, "Grid values and download CSV values are same");
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "No Data available");
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public AnalyticsOverviewDetailsPage communicationStatus(String channel)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("ANALYTICS DETAILS - Communication Status", ExtentColor.BLUE));
		javaScriptScrollDown();
		javaScriptHighLightwithScrnShot(AnalyticsRepository.analytics_details_commStatus);
		String[] testData = BaseTest.getData().ListType.split(",");
		for (int index = 0; index < testData.length; index++)
		{
			clickElement(AnalyticsRepository.analytics_details_commStatus_dropdown);
			if (selectlistelements(AnalyticsRepository.analytics_details_commStatus_dropdownlist, testData[index]))
			{
				pageLoaderLogo();
				threadSleep(ObjectRepository.wait3sec);
				int statusCount = Integer.parseInt(getStrText(AnalyticsRepository.analytics_details_commStatusCount).replaceAll("[^0-9]", ""));
				if (statusCount != 0)
				{
					String headers = AnalyticsRepository.analytics_details_commStatus_headers;
					String rows = AnalyticsRepository.analytics_details_commStatus_rows;
					String pagination = AnalyticsRepository.analytics_details_commStatus_pagination;

					commStatus = getWebTableData(headers, rows, pagination);
					if (!commStatus.isEmpty() || commStatus != null)
					{
						commStatusCSVDownload();
					} else
					{
						BaseTest.getTest().log(Status.FAIL, testData[index] + "  ---> No data found");
						BaseTest.takeScreenshot();
					}
				} else
				{
					BaseTest.getTest().log(Status.INFO, testData[index] + "  ---> Communication Status Count is : " + statusCount);
				}

				int Count = verifyCommStatusCount(channel, statusCount, index);
				if (statusCount == Count)
				{
					BaseTest.getTest().log(Status.PASS, "CommStatus Count ---> " + statusCount + ", Keymetrics Count -->  " + Count + " are exactly matched");
					BaseTest.takeScreenshot();
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "CommStatus Count ---> " + statusCount + ", Keymetrics Count --> " + Count + " aren't exactly matched");
					javaScriptHighLightwithScrnShot(AnalyticsRepository.analytics_details_commStatus);
				}
			}
		}
		return this;
	}

	public AnalyticsOverviewDetailsPage pw_communicationStatus(String channel)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("ANALYTICS DETAILS - Communication Status", ExtentColor.BLUE));
		pw_javaScriptHighLightwithScrnShot(AnalyticsRepository.analytics_details_commStatus);
		String[] testData = BaseTest.getData().ListType.split(",");
		for (int index = 0; index < testData.length; index++)
		{
			pw_clickElement(AnalyticsRepository.analytics_details_commStatus_dropdown);
			if (pw_selectlistelements(AnalyticsRepository.analytics_details_commStatus_dropdownlist, testData[index]))
			{
				pw_pageLoaderLogo();
				int statusCount = Integer.parseInt(getStrText(AnalyticsRepository.analytics_details_commStatusCount).replaceAll("[^0-9]", ""));
				if (statusCount != 0)
				{
					String headers = AnalyticsRepository.analytics_details_commStatus_headers;
					String rows = AnalyticsRepository.analytics_details_commStatus_rows;
					String pagination = AnalyticsRepository.analytics_details_commStatus_pagination;

					commStatus = getWebTableData(headers, rows, pagination);
					if (!commStatus.isEmpty() || commStatus != null)
					{
						commStatusCSVDownload();
					} else
					{
						BaseTest.getTest().log(Status.FAIL, testData[index] + "  ---> No data found");
						BaseTest.takeScreenshot();
					}
				} else
				{
					BaseTest.getTest().log(Status.INFO, testData[index] + "  ---> Communication Status Count is : " + statusCount);
				}

				int Count = verifyCommStatusCount(channel, statusCount, index);
				if (statusCount == Count)
				{
					BaseTest.getTest().log(Status.PASS, "CommStatus Count ---> " + statusCount + ", Keymetrics Count -->  " + Count + " are exactly matched");
					BaseTest.takeScreenshot();
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "CommStatus Count ---> " + statusCount + ", Keymetrics Count --> " + Count + " aren't exactly matched");
					javaScriptHighLightwithScrnShot(AnalyticsRepository.analytics_details_commStatus);
				}
			}
		}
		return this;
	}

	public int verifyCommStatusCount(String Channel, int statusCount, int index)
	{
		int count = 0;
		if (Channel.equalsIgnoreCase("Email"))
		{
			String[] data = { "Total opened", "Hard bounced", "Marked as spam", "Unsubscribed" };
			count = Integer.parseInt(emailAnalyticsDetailsPageCount.get(data[index]));

		} else if (Channel.equalsIgnoreCase("SMS"))
		{
			String[] data = { "Delivered", "Expired", "Message in queue", "Rejected", "Undelivered" };
			count = detailsKeymetrics.get(data[index]);

		} else if (Channel.equalsIgnoreCase("MobilePush"))
		{
			String[] data = { "Delivered" };
			count = detailsKeymetrics.get(data[index]);

		} else if (Channel.equalsIgnoreCase("WhatsApp"))
		{
			String[] data = { "Delivered", "Seen", "Total Clicks", "Undelivered" };
			count = detailsKeymetrics.get(data[index]);
		}
		return count;
	}

}