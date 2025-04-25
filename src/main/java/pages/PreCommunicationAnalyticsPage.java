package pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.microsoft.playwright.Page;

import repository.CommunicationRepository;
import repository.DashboardRepository;
import repository.ObjectRepository;
import utility.BaseTest;
import utility.PageFactory;

public class PreCommunicationAnalyticsPage extends CommunicationCreatePage
{
	Map<String, String> preCommunicationChannelResults = null;

	public PreCommunicationAnalyticsPage(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	// Web analytics page
	public PreCommunicationAnalyticsPage webAnalyticsDetails()
	{
		explicitwaitforvisibility(autolocator(CommunicationRepository.notification_webpush_wpnexttoprecommunication), 60);
		javaScriptScrolltoTop();
		if (isDisplayed(CommunicationRepository.notification_webpush_analyticsplatform))
		{
			BaseTest.getTest().info(MarkupHelper.createLabel("WEB ANALYTICS PAGE", ExtentColor.BLUE));
			pageLoaderLogo();
			explicitwaitforclick(autolocator(CommunicationRepository.notification_webpush_analyticsplatform), 40);
			clickElement(CommunicationRepository.notification_webpush_analyticsplatform);
			selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, BaseTest.getData().AnalyticsPlatform);
			pageLoaderLogo();
			clickElement(CommunicationRepository.notification_webpush_selectdomain);
			selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, BaseTest.getData().DomainUrl);
			threadSleep(ObjectRepository.wait1sec);
			BaseTest.takeScreenshot();

			if (BaseTest.getData().ConversionCategory.length() > 0)
			{
				webAnalyticsConversionCategory();
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Communication web analytics details conversion category is not opted");
			}
			javaScriptScrollIntoView(",xpath,//div[contains(@class,'fg-icons')]");
			explicitwaitforclick(autolocator(CommunicationRepository.notification_webpush_wpnexttoprecommunication), 30);
			clickElement(CommunicationRepository.notification_webpush_wpnexttoprecommunication);
			threadSleep(ObjectRepository.wait3sec);
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Communication created but did not navigated to Analytics Page"); // doubtful clearance need
			BaseTest.takeScreenshot();
		}
		pageLoaderLogo();
		return this;
	}

	public PreCommunicationAnalyticsPage webAnalyticsDetailsWithOfflineConversion()
	{
		explicitwaitforvisibility(autolocator(CommunicationRepository.notification_webpush_wpnexttoprecommunication), 60);
		javaScriptScrolltoTop();
		if (isDisplayed(CommunicationRepository.notification_webpush_analyticsplatform))
		{
			BaseTest.getTest().info(MarkupHelper.createLabel("WEB ANALYTICS PAGE", ExtentColor.BLUE));
			pageLoaderLogo();
			explicitwaitforclick(autolocator(CommunicationRepository.notification_webpush_analyticsplatform), 40);
			clickElement(CommunicationRepository.notification_webpush_analyticsplatform);
			selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, BaseTest.getData().AnalyticsPlatform);
			pageLoaderLogo();
			clickElement(CommunicationRepository.notification_webpush_selectdomain);
			selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, BaseTest.getData().DomainUrl);
			threadSleep(ObjectRepository.wait1sec);
			BaseTest.takeScreenshot();

			webAnalyticsConversionCategory();

			clickElement("Offline conversion,xpath,//i[contains(@class,'icon-rs-offline-conversion')]");
			pageLoaderLogo();
			clickElement("Conversion attribute,xpath,//span[@aria-label='Attribute']");
			selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Age");
			enterValue("Attribute value,xpath,//input[@name='attributes.0.attributeValue']", "24");
			enterValue("Grace period,xpath,//input[@name='gracePeriod']", "10");
			clickElement("Conversion value,xpath,//input[@placeholder='Conversion value']/../..");
			selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Subscription forms");
			javaScriptScrollDownToSomeExtend();
			threadSleep(ObjectRepository.wait1sec);

			explicitwaitforclick(autolocator(CommunicationRepository.notification_webpush_wpnexttoprecommunication), 30);
			clickElement(CommunicationRepository.notification_webpush_wpnexttoprecommunication);
			threadSleep(ObjectRepository.wait3sec);
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Communication created but did not navigated to Analytics Page"); // doubtful clearance need
			BaseTest.takeScreenshot();
		}
		pageLoaderLogo();
		return this;
	}

	private PreCommunicationAnalyticsPage webAnalyticsConversionCategory()
	{
		BaseTest.getTest().log(Status.INFO, "Communication web analytics details conversion category is opted ");
		if (isDisplayed(CommunicationRepository.notification_webpush_analyticsplatform))
		{
			javaScriptScrollDownToSomeExtend();
			javaScriptScrollDownToSomeExtend();

			explicitwaitforclick(autolocator(CommunicationRepository.precomm_Analytics_clickconversioncategory), 40);
			clickElement(CommunicationRepository.precomm_Analytics_clickconversioncategory);
			selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Enter value manually");
			threadSleep(ObjectRepository.wait1sec);
			enterValue(CommunicationRepository.precomm_Analytics_conversionvalue, "77");

			clickElement(CommunicationRepository.precomm_Analytics_clickcurrency);
			selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Canadian dollar");
			threadSleep(ObjectRepository.wait1sec);
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Communication created but did not navigated to Analytics Page"); // doubtful clearance need
			BaseTest.takeScreenshot();
		}
		pageLoaderLogo();
		return this;
	}

	public PreCommunicationAnalyticsPage mobileAppAnalyticsDetails()
	{
		pageLoaderLogo();
		explicitwaitforvisibility(autolocator(CommunicationRepository.notification_webpush_wpnexttoprecommunication), 60);
		javaScriptScrolltoTop();
		if (isDisplayed(CommunicationRepository.notification_webpush_analyticsplatform))
		{
			BaseTest.getTest().info(MarkupHelper.createLabel("MOBILE ANALYTICS PAGE", ExtentColor.BLUE));
			explicitwaitforclick(autolocator(CommunicationRepository.notification_webpush_analyticsplatform), 40);
			clickElement(CommunicationRepository.notification_webpush_analyticsplatform);
			selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Resulticks Mobile App Analytics");
			threadSleep(ObjectRepository.wait1sec);
//			
			javaScriptScrollDownToSomeExtend();
			threadSleep(ObjectRepository.wait1sec);
			explicitwaitforclick(autolocator(CommunicationRepository.notification_webpush_wpnexttoprecommunication), 30);
			clickElement(CommunicationRepository.notification_webpush_wpnexttoprecommunication);
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Communication created but did not navigated to Analytics Page"); // doubtful clearance need
		}

		return this;
	}

	public List<Map<String, String>> emaillimitCsvDownload()
	{
		List<Map<String, String>> csvFileOutPut = new ArrayList<>();

		pageLoaderLogo();
		if (isEnabled(CommunicationRepository.precomm_Analytics_clickdownloadTable))
		{
			explicitwaitforvisibility(autolocator(CommunicationRepository.precomm_Analytics_clickdownloadTable), 20);
			clickElement(CommunicationRepository.precomm_Analytics_clickdownloadTable);
			Calendar calendar = Calendar.getInstance();

			// Extract required date and time components
			String monthDay = new SimpleDateFormat("M_d").format(calendar.getTime()); // e.g., "3_6"
			String hourMinute24 = new SimpleDateFormat("HHmm").format(calendar.getTime()); // e.g., "1645"
			String milliseconds = String.valueOf(calendar.get(Calendar.MILLISECOND)); // e.g., "9245"
			String hourMinute12 = new SimpleDateFormat("hh_mm a").format(calendar.getTime()); // e.g., "04_45 PM"

			// Construct the final string
			String file = "Email Limit_" + monthDay + "_" + hourMinute24 + "_" + milliseconds + "_" + hourMinute12;

			// Print result
			System.out.println(communicationName);
			threadSleep(ObjectRepository.wait5sec);
			robotClassScrenShot(BaseTest.curr_Dir + "\\src\\main\\resources\\data\\downloadedFile\\" + communicationName);
			String[] filehandle = filehandle().get(1).toString().split("\n");
			for (int i = 1; i < filehandle.length; i++)
			{
				Map<String, String> map = new LinkedHashMap<>();
				String[] headers = filehandle[0].split(",");
				String[] values = filehandle[i].split(",");
				for (int j = 0; j < headers.length; j++)
				{
					if (!headers[j].contains("Day") && !headers[j].contains("Date") && !headers[j].contains("Audience count"))
					{
						try
						{
							map.put(headers[j], values[j]);
						} catch (Exception e)
						{
							map.put(headers[j], "");

						}
					}
				}
				csvFileOutPut.add(map);
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Download option not available or page not loaded");
		}
		threadSleep(ObjectRepository.wait3sec);
		return csvFileOutPut;
	}

	// Pre Communication Page Limit List
	public PreCommunicationAnalyticsPage preCommunicationPageLimitList(String LimitType, String OndayType, String channel)
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();

		BaseTest.getTest().info(MarkupHelper.createLabel("Limit List Verification", ExtentColor.BLUE));
		pageLoaderLogo();
		javascriptdoublescrolldown();
		threadSleep(ObjectRepository.wait2sec);
		tooltipTextWithInput(CommunicationRepository.Precommuniationpage_Limit, "Limit list/Split schedule");
		clickElement(CommunicationRepository.Precommuniationpage_Limit);

		if (LimitType.equalsIgnoreCase("One time"))
		{
			clickElement(CommunicationRepository.Precommuniationpage_Limit_One_time);
			String AudienceCount = getStrText(CommunicationRepository.Precommuniationpage_Limit_One_time_Audience);
			try
			{
				audienceNumber = Integer.parseInt(AudienceCount);
				halfAudience = audienceNumber / 2;
				// Convert back to a string
				halfAudienceStr = String.valueOf(halfAudience);
				System.out.println("Half Audience Count: " + halfAudienceStr);
			} catch (NumberFormatException e)
			{
				BaseTest.takeScreenshot();

				System.out.println("Invalid number format: " + AudienceCount);
			}
			if (channel.contains("sms"))
			{

				enterValue(CommunicationRepository.Precommuniationpage_SMSLimit_One_time_AudienceInput, halfAudienceStr);
				clickElement(CommunicationRepository.Precommuniationpage_smsLimit_One_time_Agree);

			} else
			{
				enterValue(CommunicationRepository.Precommuniationpage_Limit_One_time_AudienceInput, halfAudienceStr);
				clickElement(CommunicationRepository.Precommuniationpage_Limit_One_time_Agree);

			}
			explicitwaitforclick(autolocator(CommunicationRepository.Precommuniationpage_Limit_One_time_Sumbit), 30);
			clickElement(CommunicationRepository.Precommuniationpage_Limit_One_time_Sumbit);
			pageLoaderLogo();
			javascriptdoublescrolldown();
			BaseTest.takeScreenshot();
			String potentialaudience = getStrText(CommunicationRepository.Precommuniationpage_Limit_One_PotentialAudience);
			if (potentialaudience.equals(halfAudienceStr))
			{
				BaseTest.getTest().log(Status.PASS, "Potential target audience is Equal to input audience in Limit list");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Potential target audience is not  Equal to input audience in Limit list");
				BaseTest.takeScreenshot();

			}
			String Scrubbed_by_limit_cap = getStrText(CommunicationRepository.Precommuniationpage_Limit_One_Scrubbed);
			int Scrubbedcount = audienceNumber - halfAudience;
			ScrubbedStr = String.valueOf(Scrubbedcount);

			if (Scrubbed_by_limit_cap.equals(ScrubbedStr))
			{
				BaseTest.getTest().log(Status.PASS, "Scrubbed audience is Equal to Potential audience in Limit list");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Scrubbed  audience is not  Equal to Potential audience in Limit list");
				BaseTest.takeScreenshot();

			}
			// Incremental
		} else if (LimitType.equalsIgnoreCase("By day"))
		{
			clickElement(CommunicationRepository.Precommuniationpage_Limit_by_day);
			clickElement(CommunicationRepository.Precommuniationpage_Limit_by_day_Type);
			if (OndayType.equalsIgnoreCase("Equal"))
			{
				selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, OndayType);
				String AudienceCount = getStrText(CommunicationRepository.Precommuniationpage_Limit_One_time_Audience);
				try
				{
					audienceNumber = Integer.parseInt(AudienceCount);
					halfAudience = audienceNumber / 3;
					// Convert back to a string
					halfAudienceStr = String.valueOf(halfAudience);
					System.out.println("Half Audience Count: " + halfAudienceStr);
				} catch (NumberFormatException e)
				{
					BaseTest.takeScreenshot();

					System.out.println("Invalid number format: " + AudienceCount);
				}
				enterValue(CommunicationRepository.Precommuniationpage_Limit_by_day_AudienceInput, halfAudienceStr);
				enterTabAction();
				clickElement(CommunicationRepository.Precommuniationpage_Limit_by_day_Arrow);
				String volumetext = getStrText(CommunicationRepository.Precommuniationpage_Limit_by_day_volumeperday);
				writeLog(volumetext.contains(halfAudienceStr), "Volume per day is Correct as expected", "Volume per day is not Correct as expected");
				clickElement(CommunicationRepository.Precommuniationpage_Limit_One_time_Agree);
				explicitwaitforclick(autolocator(CommunicationRepository.Precommuniationpage_Limit_One_time_Sumbit), 30);
				clickElement(CommunicationRepository.Precommuniationpage_Limit_One_time_Sumbit);
				pageLoaderLogo();
				String Split_schedule = getStrText(CommunicationRepository.Precommuniationpage_Limit_by_day_Split_schedule);

				SplitscheduleStr = String.valueOf(Split_schedule);

				if (SplitscheduleStr.equals(halfAudienceStr))
				{
					BaseTest.getTest().log(Status.PASS, "Split_schedule audience is Equal to Potential audience in Limit list");
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Split_schedule  audience is not  Equal to Potential audience in Limit list");
					BaseTest.takeScreenshot();

				}
				String potentialaudience = getStrText(CommunicationRepository.Precommuniationpage_Limit_One_PotentialAudience);
				if (potentialaudience.equals(AudienceCount))
				{
					BaseTest.getTest().log(Status.PASS, "Potential target audience is Equal to input audience in Limit list");
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Potential target audience is not  Equal to input audience in Limit list");
					BaseTest.takeScreenshot();

				}
				clickElement(CommunicationRepository.Precommuniationpage_Limit_One_Info);

				List<Map<String, String>> PrecommunicationTable = getwebTable(CommunicationRepository.Precommuniationpage_Limit_One_Info_Table, CommunicationRepository.Precommuniationpage_Limit_One_Info_header,
						CommunicationRepository.Precommuniationpage_Limit_One_Info_row, CommunicationRepository.Precommuniationpage_Limit_One_Info_data);
				List<Map<String, String>> emaillimitCsvDownload = emaillimitCsvDownload();
			}

		}
		return this;

	}

	// Pre Communication Page
	public PreCommunicationAnalyticsPage preCommunicationPage()
	{
		List<WebElement> ele;
		BaseTest.getTest().info(MarkupHelper.createLabel("PRE COMMUNICATION ANALYTICS PAGE", ExtentColor.BLUE));
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait2sec);
		pageLoaderLogo();

		if (isDisplayed(CommunicationRepository.precomm_content))
		{
			// javaScriptScrollIntoView("List quality head,xpath,//h4[.='List quality']");
			boolean scrubbed = isElementPresent("Scrubbed status,xpath,//h5[text()='Scrubbed']");
			if (scrubbed)
			{
				BaseTest.getTest().log(Status.INFO, "Communication get scrubbed successfully");
				BaseTest.takeScreenshot();

			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Fail - Communication scrubbed status");
				BaseTest.takeScreenshot();
			}

			javaScriptScrollDown();
			BaseTest.takeScreenshot();
			pageLoaderLogo();
			threadSleep(ObjectRepository.wait2sec);
			explicitwaitforclick(autolocator(CommunicationRepository.notification_webpush_wpnexttosave), 20);
			clickElement(CommunicationRepository.notification_webpush_wpnexttosave);
			try
			{
				explicitwaitforvisibility(autolocator(CommunicationRepository.notification_webpush_wpconfirmpopup), 10);
				clickElement(CommunicationRepository.notification_webpush_wpconfirmpopup);
				BaseTest.takeScreenshot();
			} catch (Exception e)
			{
				BaseTest.getTest().log(Status.INFO, "Pre communication analytics popup not shown");
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Pre communication analytics page not loaded");
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public PreCommunicationAnalyticsPage frequencycap()
	{
		javaScriptScrollIntoView("Advance analytics email,xpath,//i[contains(@class,'channel-action')]");
		javaScriptScrollUpToSomeExtend();
		explicitwaitforvisibility(autolocator("Adv analytics grey,xpath,//i[contains(@class,'icon-rs-channel-action-large icon-lg color-secondary-grey')]"), 20);
		pageLoaderLogo();
		List<WebElement> ele;
		clickElement(CommunicationRepository.Communication_Frequency_cap);
		isElementPresent(CommunicationRepository.Communication_Frequency_cap_onoffbutton);
		clickElement(CommunicationRepository.Communication_Frequency_cap_onoffbutton);
		pageLoaderLogo();
		clickElement("select list element,xpath,//div[contains(@class,' rs-kendo-multi-dropdown ')]");
		ele = findElements(DashboardRepository.allpage_common_selectdropdownlist);
		for (int i = 0; i < 4; i++)
		{
			ele = findElements(DashboardRepository.allpage_common_selectdropdownlist);
			ele.get(i).click();
			enterTabAction();
			clickElement("select list element,xpath,//div[contains(@class,' rs-kendo-multi-dropdown ')]//input");
		}
		enterTabAction();

		// clickElement(CommunicationRepository.Communication_frequency_cap_okbutton);
		threadSleep(ObjectRepository.wait2sec);
		String Errormsg = getStrText(CommunicationRepository.Communication_frequency_cap_errormsg);
		writeLog(Errormsg.equalsIgnoreCase("Max. of 3 frequency cap list"), "Error message is shown correctly", "Error message is not as espected");
		clickElement("remove,xpath,(//span[@title='Remove'])[4]");
		threadSleep(ObjectRepository.wait1sec);
		pageLoaderLogo();

		clickElement(CommunicationRepository.Communication_frequency_cap_okbutton);
		threadSleep(ObjectRepository.wait2sec);
		toolTipValidationKnownText(CommunicationRepository.Communication_Frequency_cap, "Frequency cap");
		clickElement(CommunicationRepository.Communication_Frequency_cap);
		isElementPresent(CommunicationRepository.Communication_Frequency_cap_onoffbutton);
		clickElement(CommunicationRepository.Communication_Frequency_cap_onoffbutton);
		clickElement("close,id,rs_circle_close_edge");
		return this;
	}

	public PreCommunicationAnalyticsPage contentbox()
	{
		isElementPresent(CommunicationRepository.Communication_Content_Header);
		List<WebElement> ele;
		List<WebElement> value;
		ele = findElements(CommunicationRepository.Communication_Content_Headings);

		for (int i = 0; i < ele.size(); i++)
		{
			ele = findElements(CommunicationRepository.Communication_Content_Headings);
			String Headers = ele.get(i).getText();
			value = findElements(CommunicationRepository.Communication_Content_Headings_value);
			String Headersvalue = ele.get(i).getText();
			try
			{
				BaseTest.getTest().log(Status.INFO, " " + Headers + "  value :- " + Headersvalue);

			} catch (Exception e)
			{
				BaseTest.getTest().log(Status.FAIL, " " + Headers + "  value :- " + Headersvalue);

			}
		}
		boolean elementExist = isElementExist(CommunicationRepository.Communication_Content_SDK);
		if (elementExist)
		{
			BaseTest.getTest().log(Status.INFO, "SDk Status is available for the Communication");
			String SDK = getStrText(CommunicationRepository.Communication_Content_SDK_link);
			BaseTest.getTest().log(Status.INFO, "SDk Link is " + SDK);

		} else
		{
			BaseTest.getTest().log(Status.INFO, "SDk Status is not  available for the Communication. ");

		}
		String Link = getStrText(CommunicationRepository.Communication_Content_Linkverification);
		String LinkTest = getStrText(CommunicationRepository.Communication_Content_Linkverification_link);

		BaseTest.getTest().log(Status.INFO, " " + Link + " :- " + LinkTest);
		listQualityPortletValidation();
		// advAnalyticsEmailSms("Mobile push");

		return this;
	}

	public void listQualityPortletValidation()
	{
		String audienceCounts = "";
		String uniqueAudience = "";
		String unsubscribeCount = "";
		String potentialAudienceCount = "";
		BaseTest.getTest().info(MarkupHelper.createLabel("COMMUNICATION PRECOMMUNICATION PAGE", ExtentColor.GREEN));
		javaScriptScrollUpToSomeExtend();
		threadSleep(ObjectRepository.wait3sec);
		audienceCounts = getStrText("audienceCounts,xpath,(//ul[@class='d-flex campaign-lists']//h1)[1]").trim();
		uniqueAudience = getStrText("uniqueAudience,xpath,(//ul[@class='d-flex campaign-lists']//h1)[2]").trim();
		unsubscribeCount = getStrText("Scrubed,xpath,(//ul[@class='d-flex campaign-lists']//h1)[3]").trim();
		potentialAudienceCount = getStrText("potentialAudienceCount,xpath,(//ul[@class='d-flex campaign-lists']//h1)[4]").trim();
		if (audienceCount != null)
		{
			uiPageEqualswithInputValue(audienceCount, audienceCounts);
			int uniqueaudience = Integer.parseInt(uniqueAudience);
			int unsubscribecount = Integer.parseInt(unsubscribeCount);
			int potentialAudiencecount = Integer.parseInt(potentialAudienceCount);
			int total = uniqueaudience - unsubscribecount;
			if (potentialAudiencecount == total)
			{
				BaseTest.getTest().log(Status.INFO, "Potential Audience count " + potentialAudiencecount + " is equal to expected audience count " + total);
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Potential Audience count " + potentialAudiencecount + " is not equal to expected audience count " + total);
			}
			BaseTest.getTest().log(Status.INFO, "Unique Audience count --> " + uniqueAudience);
			BaseTest.getTest().log(Status.INFO, "Sucrubed count --> " + unsubscribeCount);
			BaseTest.getTest().log(Status.INFO, "Audience count --> " + audienceCounts);
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Potential Audience count --> " + potentialAudienceCount);
			BaseTest.getTest().log(Status.INFO, "Unique Audience count --> " + uniqueAudience);
			BaseTest.getTest().log(Status.INFO, "Scrubed count --> " + unsubscribeCount);
			BaseTest.getTest().log(Status.INFO, "Audience count --> " + audienceCounts);
		}
	}

	public void advAnalyticsEmailSms(String Channel)
	{
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait5sec);

		javaScriptScrollIntoView("Advance analytics email,xpath,//i[contains(@class,'channel-action')]");
		javaScriptScrollUpToSomeExtend();
		explicitwaitforvisibility(autolocator("Adv analytics grey,xpath,//i[contains(@class,'icon-rs-channel-action-large icon-lg color-secondary-grey')]"), 20);
		pageLoaderLogo();
		clickElement("Advance analytics ,xpath,//i[contains(@class,'channel-action')]");
		javaScriptScrollUpToSomeExtend();
//		String attribute1 = "Gender";
//		String attribute2 = "Age";
//		String attribute3 = "City";
//		String attribute4 = "Color";
//		String attribute5 = "Back end";
//		String attribute6 = "Active period";
		String[] attributes = { "Gender", "Age", "City", "Color", "Back end", "Active period" };

		if (Channel == "email")
		{

			String emailToggleButtonState = getTextBoxVal("Email toggle button,xpath,//span[contains(@class,'switch k-switch')]", "class");
			if (emailToggleButtonState.contains("switch-off"))
			{
				pageLoaderLogo();
				clickElement("Email toggle on,xpath,//span[@class='k-switch-track k-rounded-full']");
				threadSleep(ObjectRepository.wait5sec);

//				clickElement("Adv analytics dropdown,xpath,//div[@role='listbox']");
//				selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, attribute1);
//				threadSleep(ObjectRepository.wait3sec);
//				clickElement("Adv analytics dropdown,xpath,//div[@role='listbox']");
//				selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, attribute2);
//				threadSleep(ObjectRepository.wait3sec);
//				clickElement("Adv analytics dropdown,xpath,//div[@role='listbox']");
//				selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, attribute3);
//				threadSleep(ObjectRepository.wait3sec);
//				clickElement("Adv analytics dropdown,xpath,//div[@role='listbox']");
//				selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, attribute4);
//				threadSleep(ObjectRepository.wait3sec);
//				clickElement("Adv analytics dropdown,xpath,//div[@role='listbox']");
//				selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, attribute5);
//				threadSleep(ObjectRepository.wait3sec);
//				clickTab();
//
//				clickElement("Adv analytics dropdown,xpath,//div[@role='listbox']//input");
//				selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, attribute6);
//				threadSleep(ObjectRepository.wait3sec);
//				clickTab();
				// clickElement("Email ok
				// button,xpath,//button[contains(@id,'AdvanceAnalyticSModal_Ok')]");
				for (int i = 0; i < attributes.length - 1; i++)
				{
					clickElement("Adv analytics dropdown,xpath,//div[@role='listbox']");
					selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, attributes[i]);
					threadSleep(ObjectRepository.wait3sec);
				}
				clickTab();
				clickElement("Adv analytics dropdown,xpath,//div[@role='listbox']//input");

				selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, attributes[5]);
				threadSleep(ObjectRepository.wait3sec);
				pageLoaderLogo();
				threadSleep(ObjectRepository.wait10sec);

				boolean validationMsg = isElementPresent("Err message,xpath,//label[text()='Max. of 5 from the list']");
				writeLog(validationMsg, "Unable to add more than 5 attributes as expected.", "Able to add more than 5 attributes.");
				if (isElementPresent("Err message,xpath,//label[text()='Max. of 5 from the list']"))
				{
					writeLog(validationMsg, "Unable to add more than 5 attributes as expected.", "Able to add more than 5 attributes.");
					threadSleep(ObjectRepository.wait3sec);
					tabAction();
					clickElement("Remove button,xpath,(//span[@title='Remove'])[6]");
				}
				threadSleep(ObjectRepository.wait3sec);
				clickElement("Email ok button,xpath,//button[contains(@id,'AdvanceAnalyticSModal_Ok')]");
				pageLoaderLogo();
			} else
			{
				BaseTest.getTest().fail("Advance analytics list toggle button is on by default for email channel");
				BaseTest.takeScreenshot();
			}
		} else
		{
			javaScriptScrolltoTop();

			String smsToggleButtonState = getTextBoxVal(" toggle button,xpath,//span[contains(@class,'switch k-switch')]", "class");
			if (smsToggleButtonState.contains("switch-off"))
			{
				clickElement(" toggle on,xpath,//span[@class='k-switch-track k-rounded-full']");
				threadSleep(ObjectRepository.wait5sec);
//				clickElement("Adv analytics dropdown,xpath,//div[@role='listbox']");
//				selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, attribute1);
//				threadSleep(ObjectRepository.wait3sec);
//				clickElement("Adv analytics dropdown,xpath,//div[@role='listbox']");
//				selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, attribute2);
//				threadSleep(ObjectRepository.wait3sec);
//				clickElement("Adv analytics dropdown,xpath,//div[@role='listbox']");
//				selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, attribute3);
//				threadSleep(ObjectRepository.wait3sec);
//				clickElement("Adv analytics dropdown,xpath,//div[@role='listbox']");
//				selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, attribute4);
//				threadSleep(ObjectRepository.wait3sec);
//				clickElement("Adv analytics dropdown,xpath,//div[@role='listbox']");
//				selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, attribute5);
//				threadSleep(ObjectRepository.wait3sec);
//				clickTab();
//
//				clickElement("Adv analytics dropdown,xpath,//div[@role='listbox']//input");
//				selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, attribute6);
//				threadSleep(ObjectRepository.wait3sec);
//				clickTab();

				for (int i = 0; i < attributes.length - 1; i++)
				{
					clickElement("Adv analytics dropdown,xpath,//div[@role='listbox']");
					selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, attributes[i]);
					threadSleep(ObjectRepository.wait3sec);
				}
				clickTab();
				clickElement("Adv analytics dropdown,xpath,//div[@role='listbox']//input");

				selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, attributes[5]);
				threadSleep(ObjectRepository.wait3sec);

				// clickElement("Email ok
				// button,xpath,//button[contains(@id,'AdvanceAnalyticSModal_Ok')]");
				pageLoaderLogo();
				threadSleep(ObjectRepository.wait10sec);

				boolean validationMsg = isElementPresent("Err message,xpath,//label[text()='Max. of 5 from the list']");
				writeLog(validationMsg, "Unable to add more than 5 attributes as expected.", "Able to add more than 5 attributes.");

				if (isElementPresent("Err message,xpath,//label[text()='Max. of 5 from the list']"))
				{
					writeLog(validationMsg, "Unable to add more than 5 attributes as expected.", "Able to add more than 5 attributes.");
					threadSleep(ObjectRepository.wait3sec);
					tabAction();
					clickElement("Remove button,xpath,(//span[@title='Remove'])[6]");
				}
				threadSleep(ObjectRepository.wait3sec);
				clickElement("" + Channel + " ok button,xpath,//button[contains(@id,'AdvanceAnalyticSModal_Ok')]");
				pageLoaderLogo();
			} else
			{
				BaseTest.getTest().fail("Advance analytics list toggle button is on by default for email channel");
				BaseTest.takeScreenshot();
			}
			javaScriptScrolltoTop();

			javaScriptScrollDownToSomeExtend();
			threadSleep(ObjectRepository.wait3sec);
			javaScriptScrollDownToSomeExtend();

			clickElement("Advance analytics " + Channel + ",xpath,//i[contains(@class,'channel-action')]");

			String emailToggleButtonStateEdit = getTextBoxVal("Email toggle button,xpath,//span[contains(@class,'switch k-switch')]", "class");
			if (!emailToggleButtonStateEdit.contains("switch-off"))
			{
				if (isDisplayed(",xpath,//span[contains(@aria-label,'" + attributes[0] + "')]") && isDisplayed(",xpath,//span[contains(@aria-label,'" + attributes[1] + "')]")
						&& isDisplayed(",xpath,//span[contains(@aria-label,'" + attributes[2] + "')]") && isDisplayed(",xpath,//span[contains(@aria-label,'" + attributes[3] + "')]")
						&& isDisplayed(",xpath,//span[contains(@aria-label,'" + attributes[4] + "')]"))
				{
					BaseTest.getTest().info("Advance analytics list is retained its attribute in edit mode for Email channel");
					BaseTest.takeScreenshot();
				} else
				{
					BaseTest.getTest().fail("Advance analytics list is not retained its attribute in edit mode for Email channel");
					BaseTest.takeScreenshot();
				}
			} else
			{
				BaseTest.getTest().fail("Advanced anlytics list toggle button is off in edit mode for Email channel");
				BaseTest.takeScreenshot();
			}
			clickElement("Close,xpath,//i[@id='rs_circle_close_edge']");
			threadSleep(ObjectRepository.wait2sec);
		}
		if (Channel == "email")
		{

			javaScriptScrollIntoView("Advance analytics email,xpath,//i[contains(@class,'channel-action')]");
			javaScriptScrollUpToSomeExtend();
			explicitwaitforvisibility(autolocator("Adv analytics grey,xpath,//i[contains(@class,'icon-rs-channel-action-large icon-lg color-primary-blue')]"), 20);
			clickElement("Advance analytics email,xpath,//i[contains(@class,'channel-action')]");

			String emailToggleButtonStateEdit = getTextBoxVal("Email toggle button,xpath,//span[contains(@class,'switch k-switch')]", "class");
			if (!emailToggleButtonStateEdit.contains("switch-off"))
			{
				if (isDisplayed(",xpath,//span[contains(@aria-label,'" + attributes[0] + "')]") && isDisplayed(",xpath,//span[contains(@aria-label,'" + attributes[1] + "')]")
						&& isDisplayed(",xpath,//span[contains(@aria-label,'" + attributes[2] + "')]") && isDisplayed(",xpath,//span[contains(@aria-label,'" + attributes[3] + "')]")
						&& isDisplayed(",xpath,//span[contains(@aria-label,'" + attributes[4] + "')]"))
				{
					BaseTest.getTest().info("Advance analytics list is retained its attribute in edit mode for Email channel");
					BaseTest.takeScreenshot();
				} else
				{
					BaseTest.getTest().fail("Advance analytics list is not retained its attribute in edit mode for Email channel");
					BaseTest.takeScreenshot();
				}
			} else
			{
				BaseTest.getTest().fail("Advanced anlytics list toggle button is off in edit mode for Email channel");
				BaseTest.takeScreenshot();
			}
			clickElement("Close,xpath,//i[@id='rs_circle_close_edge']");
			threadSleep(ObjectRepository.wait2sec);
		}
	}

	public void validateAdvanceAnalytics()
	{
		String emailToggleButtonState = "";
		javaScriptScrollIntoView("Advance analytics email,xpath,(//*[.='Potential target audience'])[1]");
		javaScriptScrollUpToSomeExtend();
		explicitwaitforvisibility(autolocator("Adv analytics grey,xpath,//i[@class='icon-rs-channel-action-large icon-lg color-secondary-grey']"), 20);
		pageLoaderLogo();
		clickElement("Advance analytics ,xpath,//i[contains(@class,'channel-action')]");
		emailToggleButtonState = getTextBoxVal("Email toggle button,xpath,//span[contains(@class,'switch k-switch')]", "class");
		if (emailToggleButtonState.contains("switch-off"))
		{
			clickElement("Email toggle on,xpath,//span[@class='k-switch-track k-rounded-full']");
			threadSleep(ObjectRepository.wait5sec);
			clickElement("Adv analytics dropdown,xpath,//div[@role='listbox']//input");
			List<WebElement> attributes = findElements(DashboardRepository.allpage_common_selectdropdownlist);
			List<String> analyticsAttributes = new LinkedList<>();
			for (int count = 0; count < attributes.size(); count++)
			{
				attributes = findElements(DashboardRepository.allpage_common_selectdropdownlist);
				threadSleep(ObjectRepository.wait1sec);
				analyticsAttributes.add(attributes.get(count).getText());
				attributes.get(count).click();
				clickElement("Adv analytics dropdown,xpath,//div[@role='listbox']//input");
				if (count == 5)
				{
					tabAction();
					clickElement("Email ok button,xpath,//button[contains(@id,'AdvanceAnalyticSModal_Ok')]");
					pageLoaderLogo();
					threadSleep(ObjectRepository.wait1sec);
					boolean validationMsg = isElementPresent("Err message,xpath,//label[text()='Maximum of 5 from the list']");
					writeLog(validationMsg, "Unable to add more than 5 attributes as expected.", "Able to add more than 5 attributes.");
					if (validationMsg)
					{
						writeLog(validationMsg, "Unable to add more than 5 attributes as expected.", "Able to add more than 5 attributes.");
						threadSleep(ObjectRepository.wait3sec);
						clickElement("Remove button,xpath,(//span[@title='Remove'])[6]");
					}
					threadSleep(ObjectRepository.wait3sec);
					clickElement("Email ok button,xpath,//button[contains(@id,'AdvanceAnalyticSModal_Ok')]");
					pageLoaderLogo();
					break;
				}
			}
			List<String> retainableAttributes = new LinkedList<>();
			clickElement("Advance analytics ,xpath,//i[contains(@class,'channel-action')]");
			emailToggleButtonState = getTextBoxVal("Email toggle button,xpath,//span[contains(@class,'switch k-switch')]", "class");
			if (!emailToggleButtonState.contains("switch-off"))
			{
				List<WebElement> retainAttributes = findElements("attribute name,xpath,//span[@class='k-chip-content']//span");
				for (int count = 0; count < retainAttributes.size(); count++)
				{
					retainableAttributes.add(retainAttributes.get(count).getText());
				}
				writeLog(analyticsAttributes.equals(retainableAttributes), "Attributes is present as expected", "Attributes is not present as expected.");
				BaseTest.takeScreenshot();
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Toggle button status is off after selecting all the attributes.");
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Toggle button status is on without selecting any attributes.");
		}
	}
}
