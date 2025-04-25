package pages;

import java.awt.AWTException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.microsoft.playwright.Page;

import repository.AnalyticsRepository;
import repository.CommunicationRepository;
import repository.DashboardRepository;
import repository.ObjectRepository;
import utility.BaseTest;
import utility.PageFactory;

public class CommunicationCreatePage extends CommunicationListingPage
{

	public static String smartUrlGet;
	static String communicationSDateGet;
	static String communicationEDateGet;
	public static String EmailScheduleDateGet;
	public static String smsScheduleDateGet;
	public static String twitterscheduleDateget;
	public static String fbScheduleDateGet;
	public static String linkedInScheduleDateGet;
	static String notificationScheduleDateGet;
	public static String smsShortURL;
	public static boolean reqapproveemail;
	String ctype, pgoal, gper, ptype;

	public CommunicationCreatePage(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	// Create communication link click from dashboard menu - MKSTR Jasmine
	public CommunicationCreatePage clickCreateCommTab()
	{
		threadSleep(ObjectRepository.wait5sec);
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_create_link), 60);
		clickElement(CommunicationRepository.communicationpage_create_link);
		return this;
	}

	// Create Communication click from Communication tab menu list
	public CommunicationCreatePage clickCreateCommunicationfromMenu()
	{
		threadSleep(ObjectRepository.wait3sec);
		clickCommunicationTab();
		clickElement(CommunicationRepository.communicationpage_communicationcreate);
		pageLoaderLogo();
		BaseTest.getTest().info(MarkupHelper.createLabel("COMMUNICATION PLAN PAGE", ExtentColor.BLUE));
		return getPageFactory().communicationcreatepage();
	}

	// Select single dimension
	public CommunicationCreatePage selectSingleDimension()
	{
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_singledimen_link), 60);
		clickElement(CommunicationRepository.communicationpage_singledimen_link);
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_communicationname_textbox), 30);
		pageLoaderLogo();
		return this;
	}

	// Enter communication name
	public CommunicationCreatePage enterCommunicationName()
	{
		if (communicationName != null)
		{
			communicationName = "Update_" + communicationName;
			explicitwaitforvisibility(autolocator(CommunicationRepository.communicationpage_communicationname_textbox), 10);
			enterValue(CommunicationRepository.communicationpage_communicationname_textbox, communicationName);
		} else if (BaseTest.getData().CommunicationName.contains("Email Limit"))
		{
			Calendar calendar = Calendar.getInstance();

			// Extract required date and time components
			String monthDay = new SimpleDateFormat("M_d").format(calendar.getTime()); // e.g., "3_6"
			String hourMinute24 = new SimpleDateFormat("HHmm").format(calendar.getTime()); // e.g., "1645"
			String milliseconds = String.valueOf(calendar.get(Calendar.MILLISECOND)); // e.g., "9245"
			String hourMinute12 = new SimpleDateFormat("hh_mm a").format(calendar.getTime()); // e.g., "04_45 PM"

			// Construct the final string
			String fileName = "Email Limit_" + monthDay + "_" + hourMinute24 + "_" + milliseconds + "_" + hourMinute12;

			communicationName = "Email Limit_" + monthDay + "_" + hourMinute24 + "_" + milliseconds + "_" + hourMinute12;
			explicitwaitforvisibility(autolocator(CommunicationRepository.communicationpage_communicationname_textbox), 10);
			enterValue(CommunicationRepository.communicationpage_communicationname_textbox, communicationName);
		} else
		{

			communicationName = BaseTest.getData().CommunicationName + addTimeToName();
			explicitwaitforvisibility(autolocator(CommunicationRepository.communicationpage_communicationname_textbox), 10);
			enterValue(CommunicationRepository.communicationpage_communicationname_textbox, communicationName);
		}
		CommunicationNamE = communicationName.trim();

		tabAction();
		return this;
	}

	public CommunicationCreatePage clickTestCommunication()
	{
		clickElement("Test communication,xpath,//input[@name='testCommunication']");
		threadSleep(ObjectRepository.wait1sec);
		return this;
	}

	// Select communication type
	public CommunicationCreatePage selectCtype()
	{
		threadSleep(ObjectRepository.wait1sec);
		clickElement(CommunicationRepository.communicationpage_communicationtype_select);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, BaseTest.getData().CommunicationType);
		this.ctype = ctype;
		return this;
	}

	// Select product type
	public CommunicationCreatePage selectPtype()
	{
		javaScriptScrollDownToSomeExtend();
		clickElement(CommunicationRepository.communicationpage_producttype_select);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, BaseTest.getData().ProductType);
		this.ptype = ptype;
		return this;
	}

	// Select primary goal
	public CommunicationCreatePage selectPgoal()
	{
		threadSleep(ObjectRepository.wait2sec);
		pageLoaderLogo();
		javaScriptScrollDownToSomeExtend();
		threadSleep(ObjectRepository.wait1sec);

		clickElement(CommunicationRepository.communicationpage_primarygoal_select);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, BaseTest.getData().PrimaryGoal);
		threadSleep(300);
		pageLoaderLogo();
		if (BaseTest.getData().PrimaryGoal.toLowerCase().contains("conversion"))
		{
			clickElement(CommunicationRepository.communicationpage_primarygoal_Conversion);
			selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Offline store purchase");
		}
		tabAction();
		this.pgoal = pgoal;
		return this;
	}

	// Select primary goal
	public CommunicationCreatePage selectconversiongoal()
	{
		threadSleep(ObjectRepository.wait1sec);
		pageLoaderLogo();
		javaScriptScrollUpToSomeExtend();
		threadSleep(ObjectRepository.wait2sec);
		clickElement(CommunicationRepository.communicationpage_primarygoal_select);
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "conversion");
		threadSleep(ObjectRepository.wait5sec);
		pageLoaderLogo();

		clickElement(CommunicationRepository.communicationpage_primarygoal_Conversion);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Offline store purchase");

		tabAction();
		this.pgoal = pgoal;
		return this;

	}

	// Enter Goal percentage
	public CommunicationCreatePage enterGoalPercentage()
	{
		// new Actions(driver).sendKeys(findElement(CommunicationRepository.communicationpage_goalpercentage_textbox),
		// BaseTest.getData().GoalPercentage).build().perform();
		clearField(CommunicationRepository.communicationpage_goalpercentage_textbox);
		explicitwaitforvisibility(autolocator(CommunicationRepository.communicationpage_goalpercentage_textbox), 10);
		enterValue(CommunicationRepository.communicationpage_goalpercentage_textbox, "12.6");
		tabAction();
		javaScriptScrollDown();
		return this;
	}

	// Select email channel checkbox
	public CommunicationCreatePage channelType1()
	{
		clickElement(CommunicationRepository.communicationpage_channel_type1);
		BaseTest.takeScreenshot();
		return this;
	}

	// Select SMS channel checkbox
	public CommunicationCreatePage channelType2()
	{
		clickElement(CommunicationRepository.communicationpage_channel_type2);
		BaseTest.takeScreenshot();
		return this;
	}

	// Select Notification channel checkbox
	public CommunicationCreatePage channelType3()
	{
		clickElement(CommunicationRepository.communicationplan_notificationchannel);
		return this;
	}

	// Select QR Channel checkbox
	public CommunicationCreatePage selectQRChannel()
	{
		if (!isSelected(CommunicationRepository.communicationpage_channel_QR))
		{
			clickElement(CommunicationRepository.communicationpage_channel_QR);

		}
		return this;
	}

	// Select Social post channel checkbox
	public CommunicationCreatePage channelType5()
	{
		clickElement(CommunicationRepository.communicationpage_channel_type5);
		return this;
	}

	// Select paid Ads channel checkbox
	public CommunicationCreatePage channelType6()
	{
		clickElement(CommunicationRepository.communicationpage_channel_type6);
		return this;
	}

	// Select QR channel checkbox
	public CommunicationCreatePage channelType7()
	{
		clickElement(CommunicationRepository.communicationpage_channel_type7);
		return this;
	}

	// Select social post
	public CommunicationCreatePage analyticOption1()
	{
		clickElement(CommunicationRepository.communicationpage_analytics_option1);
		return this;
	}

	// Select web analytics checkbox
	public CommunicationCreatePage analyticOption2()
	{
		if (!isSelected(CommunicationRepository.communicationpage_analytics_option2))
		{
			clickElement(CommunicationRepository.communicationpage_analytics_option2);
		}
		return this;
	}

	// select paid ads
	public CommunicationCreatePage analyticOption3()
	{
		clickElement(CommunicationRepository.communicationpage_analytics_option3);
		return this;
	}

	// Select video analytics
	public CommunicationCreatePage analyticOption4()
	{
		clickElement(CommunicationRepository.communicationpage_analytics_option4);
		return this;
	}

	// Select app analytics checkbox
	public CommunicationCreatePage analyticOption5()
	{
		if (!isSelected(CommunicationRepository.communicationpage_analytics_option5))
		{
			clickElement(CommunicationRepository.communicationpage_analytics_option5);
		}
		return this;
	}

	// Communication create page Next button click
	public CommunicationCreatePage clickNext()
	{
		javaScriptScrollDown();
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_click_next), 30);
		clickElement(CommunicationRepository.communicationpage_click_next);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait10sec);
		return this;
	}

	public CommunicationCreatePage singleDimensionComm(int sdate, int edate)
	{
		long start = System.currentTimeMillis();
		selectSingleDimension();
		long totalTime = System.currentTimeMillis() - start;
		pageloadTime("Communication plan page - ", totalTime);
		enterCommunicationName().clickTestCommunication().selectCtype().selectPtype().selectPgoal();
		enterGoalPercentage();
		enterStartDate(sdate);
		threadSleep(300);
		enterEndDate(edate);
		BaseTest.takeScreenshot();
		return this;
	}

	public CommunicationCreatePage singleDimensionregression(String ROI) throws AWTException
	{
		String uploadData = detectFilePath(BaseTest.curr_Dir + "\\src\\main\\resources\\data\\uploadfiles\\BaseAudienceUpload1.csv");
		javaScriptScrolltoTop();
		clickElement(CommunicationRepository.Communication_Tag);
		String[] text = { "Congratulatory", "Individualistic", "Unquestionably", "Discombobulated", "Incomprehensible" };
		for (int i = 0; i <= 4; i++)
		{
			enterValue(CommunicationRepository.Communication_Tag_value, text[i]);
			enterAction();
		}
		clickElement(CommunicationRepository.Communication_Tagsavebutton);
		threadSleep(ObjectRepository.wait3sec);

		clickElement(CommunicationRepository.Communication_serfviceand_commuincation);
		javaScriptScrollDownToSomeExtend();
		threadSleep(ObjectRepository.wait3sec);
		if (ROI == "ROI")
		{
			clickElement(CommunicationRepository.Communication_roi);

		}
		javaScriptScrolltoTop();
		threadSleep(ObjectRepository.wait3sec);

		clickElement(CommunicationRepository.Communication_roi_edit);
		pageLoaderLogo();
		javaScriptScrollDown();
		threadSleep(ObjectRepository.wait3sec);

		clickElement(",id,rs_CommuncationReferenceModal_Save");
		String[] name = { "Upload your Communication Docket", "Enter your Country", "Enter your Offer Type", "Enter your Manager ID", "Enter your Branch Name", "Enter your Communication Ref ID", "Enter your CAF NO", "Enter your Cost Code",
				"Enter your Product Manager", "Enter your Communication Manager" };
		List<WebElement> elements = findElements(",xpath,//div[contains(@class,'rsmdc-body')]//.//.//label");
		for (int i = 0; i < elements.size(); i++)
		{

			String Refname = elements.get(i).getText();
			System.out.println(Refname);
			writeLog(Refname.equalsIgnoreCase(name[i]), "Error validation is present as exepected :" + Refname, "Error validation is not present as exepected :" + Refname);

		}
		String groupingid = getStrText(",xpath,//select[@name='CommunicationGrouping ID']//..//..//span[contains(.,'Enter your Communication Grouping ID')]");
		writeLog(groupingid.equalsIgnoreCase("Enter your Communication Grouping ID"), "Error validation is present as exepected :" + groupingid, "Error validation is not present as exepected :" + groupingid);

		clickElement(CommunicationRepository.Communication_roi_refresh);
		List<WebElement> elements1 = findElements(",xpath,//div[@class='modal-content rsmd-content']//input[@type='text']");
		String[] name1 = { "", "india", "off", "in99", "test", "xyz", "64666", "9876890", "testautomation", "testautomation" };
		for (int i = 1; i <= elements1.size(); i++)
		{
			enterValue(",xpath,(//div[@class='modal-content rsmd-content']//input[@type='text'])[" + i + "]", name1[i]);
		}
		javaScriptScrollIntoView(CommunicationRepository.Communication_roi_Grouping_id);
		clickElement(CommunicationRepository.Communication_roi_Grouping_id);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().GroupingIDdropdown);
		enterValue(CommunicationRepository.Communication_roi_Grouping_id_manually, BaseTest.getData().GroupingID);
		tabAction();
		threadSleep(ObjectRepository.wait1sec);

		clickElement(CommunicationRepository.Communication_roi_Grouping_id_priority);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "2");
		sendValues(",name,Communication Docket", uploadData);
		threadSleep(700);
		pageLoaderLogo();

		javaScriptScrollIntoView(CommunicationRepository.Communication_roi_Grouping_id_Savebutton);
		clickElement(CommunicationRepository.Communication_roi_Grouping_id_Savebutton);
		clickElement(CommunicationRepository.Communication_roi_Grouping_okbutton);

		pageLoaderLogo();

		return this;

	}

	public CommunicationCreatePage eventTriggComm(int sdate, int edate)
	{
		long start = System.currentTimeMillis();
		selectEventTrigger();
		long totalTime = System.currentTimeMillis() - start;
		pageloadTime("Communication plan page - ", totalTime);
		enterCommunicationName().clickTestCommunication().selectCtype().selectPtype().selectPgoal();
		enterGoalPercentage();
		selectDynamicList();
		enterStartDate(sdate);
		threadSleep(ObjectRepository.wait3sec);
		enterEndDate(edate);
		return this;
	}

	public void clickFrequency(String frequency)
	{
		javaScriptScrollDown();
		explicitwaitforclick(autolocator("Frequency,xpath,//li[contains(@class,'tabDefault')][.='" + frequency + "']"), 20);
		String classVal = getTextBoxVal("Frequency,xpath,//li[contains(@class,'tabDefault')][.='" + frequency + "']", "class");
		if (!classVal.contains("active"))
		{
			clickElement("Frequency,xpath,//li[contains(@class,'tabDefault')][.='" + frequency + "']");
		}
	}

	public void getTimeForDaily(String days)
	{

		long timeInMillis = System.currentTimeMillis();
		Calendar cal1 = Calendar.getInstance();
		cal1.setTimeInMillis(timeInMillis);
		SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a");
		String dateforrow = dateFormat.format(cal1.getTime());
		String[] currTime = dateforrow.split(":");
		String hour = currTime[0];
		String[] split2 = currTime[1].split(" ");
		int secs = Integer.parseInt(split2[0]);
		String amPm = split2[1].toUpperCase();
		String time;
		if (secs >= 30)
		{
			time = (Integer.parseInt(hour) + 1) + ":00 " + amPm;
		} else
		{
			time = hour + ":30 " + amPm;
		}
		enterValue("Every days,xpath,//input[@name='daily.days']", days);
		clickElement("Time,xpath,//span[@aria-label = 'Time']");
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, time);
		threadSleep(ObjectRepository.wait3sec);
	}

	// Create Smart Url
	public CommunicationCreatePage createSmarturl()
	{
		pageLoaderLogo();
		javascriptdoublescrolldown();
		try
		{
			explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_smarturl_yes), 100);
		} catch (Exception e)
		{
			threadSleep(ObjectRepository.wait1sec);
		}

		clickElement(CommunicationRepository.communicationpage_smarturl_yes);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_smarturl_web), 20);
		sendValue(CommunicationRepository.communicationpage_smarturl_web, BaseTest.getData().SmartLink);
		tabAction();
		javaScriptScrollIntoView(CommunicationRepository.communicationpage_smarturl_generatesmarturl);
		clickElement(CommunicationRepository.communicationpage_smarturl_generatesmarturl);
		pageLoaderLogo();
		BaseTest.takeScreenshot();
		try
		{
			explicitwaitforvisibility(autolocator(CommunicationRepository.communicationpage_smarturl_verifyA), 50);
			BaseTest.getTest().log(Status.INFO, "Smart link generated successfully for Smart Link 1");
			BaseTest.takeScreenshot();
		} catch (Exception e)
		{
			BaseTest.takeScreenshot();
			BaseTest.getTest().log(Status.FAIL, "Smart link not visible after generate");
		}
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait2sec);
		clickElement(CommunicationRepository.communicationpage_smarturl_save);
		threadSleep(ObjectRepository.wait2sec);
		return this;
	}

	public CommunicationCreatePage deferredDeeplink()
	{
		pageLoaderLogo();
		javaScriptScrollIntoView("Smart link popup,xpath,//div[contains(@class,'overlay-page-modal')]");
		try
		{
			explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_smarturl_yes), 100);
		} catch (Exception e)
		{
			threadSleep(ObjectRepository.wait2sec);
			pageLoaderLogo();
			explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_smarturl_yes), 100);
		}
		clickElement(CommunicationRepository.communicationpage_smarturl_yes);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_smarturl_web), 20);
		sendValue(CommunicationRepository.communicationpage_smarturl_web, BaseTest.getData().SmartLink);
		tabAction();
		javaScriptScrollIntoView(CommunicationRepository.communicationpage_smarturl_generatesmarturl);
		clickElement(CommunicationRepository.communicationpage_smarturl_generatesmarturl);
		pageLoaderLogo();
		BaseTest.takeScreenshot();
		try
		{
			explicitwaitforvisibility(autolocator(CommunicationRepository.communicationpage_smarturl_verifyA), 50);
			BaseTest.getTest().log(Status.INFO, "Smart link generated successfully");
			BaseTest.takeScreenshot();
		} catch (Exception e)
		{
			BaseTest.takeScreenshot();
			BaseTest.getTest().log(Status.FAIL, "Smart link not visible after generate");
		}
		clickElement("Plus icon,xpath,//i[contains(@id,'rs_data_circle_plus_fill_edge')]");
		clickElement("Mobile platform,xpath,//span[@aria-label='Device type']");
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Android phone");
		clickElement("Mobile app,xpath,//span[@aria-label='Mobile app']");
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Vision Bank App");
		pageLoaderLogo();
		clickElement("App screen,xpath,//span[@aria-label='App screen']");
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Enter new app screen");
		enterValue("App screen,xpath,//input[@name='smartLink1[1].appScreenNew']", "TestAppScreen");
		enterValue("New sub screen,xpath,//input[@name='smartLink1[1].subappScreenNew']", "TestSubScreen");
		javaScriptScrollIntoView(CommunicationRepository.communicationpage_smarturl_generatesmarturl);
		clickElement(CommunicationRepository.communicationpage_smarturl_generatesmarturl);
		pageLoaderLogo();
		BaseTest.takeScreenshot();
		clickElement("Plus icon,xpath,//i[contains(@id,'rs_data_circle_plus_fill_edge')]");
		javaScriptScrolltoTop();
		clickElement("Mobile platform,xpath,(//span[@aria-label='Device type'])[2]");
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "iPhone");
		clickElement("App screen,xpath,//span[@aria-label='App screen']");
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Enter new app screen");
		enterValue("App screen,xpath,//input[@name='smartLink1[2].appScreenNew']", "TestAppScreen");
		javaScriptScrollIntoView(CommunicationRepository.communicationpage_smarturl_generatesmarturl);
		clickElement(CommunicationRepository.communicationpage_smarturl_generatesmarturl);
		pageLoaderLogo();
		BaseTest.takeScreenshot();
		clickElement(CommunicationRepository.communicationpage_smarturl_save);
		threadSleep(ObjectRepository.wait10sec);
		BaseTest.takeScreenshot();
		return this;
	}

	public void smartUrlpopupCancel()
	{
		try
		{
			pageLoaderLogo();
			javaScriptScrollIntoView("Smart link popup,xpath,//div[contains(@class,'overlay-page-modal')]");
			explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_smarturl_nothanks), 60);
			clickElement(CommunicationRepository.communicationpage_smarturl_nothanks);
		} catch (Exception e)
		{
			BaseTest.getTest().log(Status.INFO, "Smart URL popup not present");
		}
	}

	public static String getValueinbetween(String value)
	{
		Pattern p = Pattern.compile("\\(([^)]+)\\)");
		Matcher m = p.matcher(value);
		String uicount = null;
		while (m.find())
		{
			String uicount1 = m.group(1);
			uicount = uicount1.replaceAll("\\s", "");
		}
		return uicount;
	}

	public CommunicationListingPage communicationPlanPageCompareAttributeValues()
	{
		if (!getStrText(CommunicationRepository.communicationemail_comm_commtype).equalsIgnoreCase(BaseTest.getData().CommunicationType))
		{
			BaseTest.getTest().log(Status.FAIL, "The Duplicated Communication Type '" + BaseTest.getData().CommunicationType + "' Differs from its input");
			BaseTest.takeScreenshot();
		}
		if (!getStrText(CommunicationRepository.communicationemail_comm_prodtype).equalsIgnoreCase(BaseTest.getData().ProductType))
		{
			BaseTest.getTest().log(Status.FAIL, "The Duplicated Product Type  '" + BaseTest.getData().ProductType + "' Differs from its input");
			BaseTest.takeScreenshot();
		}
		if (!getStrText(CommunicationRepository.communicationemail_comm_primarygoal).equalsIgnoreCase(BaseTest.getData().PrimaryGoal))
		{
			BaseTest.getTest().log(Status.FAIL, "The Duplicated Primary Goal  '" + BaseTest.getData().PrimaryGoal + "' Differs from its input");
			BaseTest.takeScreenshot();
		}
		javaScriptScrollDown();

		if (isSelected(CommunicationRepository.communicationpage_channel_type1))
		{
			BaseTest.getTest().log(Status.INFO, "The selected channel type is Email");
		}
		if (isSelected(CommunicationRepository.communicationpage_channel_type2))
		{
			BaseTest.getTest().log(Status.INFO, "The selected channel type is Messaging");
		}
		if (isSelected(CommunicationRepository.communicationpage_channel_type3))
		{
			BaseTest.getTest().log(Status.INFO, "The selected channel type is Social Post");
		}
		if (isSelected(CommunicationRepository.communicationpage_channel_QR))
		{
			BaseTest.getTest().log(Status.INFO, "The selected channel type is QR");
		}
		if (isSelected(CommunicationRepository.communicationpage_channel_type5))
		{
			BaseTest.getTest().log(Status.INFO, "The selected channel type is Notification");
		}
		if (isSelected(CommunicationRepository.communicationpage_channel_type6))
		{
			BaseTest.getTest().log(Status.INFO, "The selected channel type is Paid Ads");
		}
		if (isSelected(CommunicationRepository.communicationpage_channel_type7))
		{
			BaseTest.getTest().log(Status.INFO, "The selected channel type is Voice");

		}

		if (isSelected(CommunicationRepository.communicationpage_analytics_option1))
		{
			BaseTest.getTest().log(Status.INFO, "The selected Analytic type is Web");
		}

		if (isSelected(CommunicationRepository.communicationpage_analytics_option3))
		{
			BaseTest.getTest().log(Status.INFO, "The selected Analytic type is APP");
		}
		if (isSelected(CommunicationRepository.communicationpage_analytics_option4))
		{
			BaseTest.getTest().log(Status.INFO, "The selected Analytic type is Sentiment");
		}

		return this;

	}

	// Select Event Trigger
	public CommunicationCreatePage selectEventTrigger()
	{
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_evnttrigger_link), 60);
		clickElement(CommunicationRepository.communicationpage_evnttrigger_link);
		pageLoaderLogo();
		return this;
	}

	public CommunicationCreatePage triggercommunicationPlanPageDetails()
	{
		if (communicationName != null)
		{
			communicationName = "Update_" + communicationName;
			explicitwaitforvisibility(autolocator(CommunicationRepository.Communication_EventTrigger_communicationname), 10);
			enterValue(CommunicationRepository.Communication_EventTrigger_communicationname, communicationName);
		} else
		{
			communicationName = BaseTest.getData().CommunicationName + addTimeToName();
			explicitwaitforvisibility(autolocator(CommunicationRepository.Communication_EventTrigger_communicationname), 10);
			enterValue(CommunicationRepository.Communication_EventTrigger_communicationname, communicationName);
		}

		clickElement(CommunicationRepository.Communication_EventTrigger_commtype);
		selectlistelements(CommunicationRepository.Communication_EventTrigger_entercommtype, BaseTest.getData().CommunicationType);
		clickElement(CommunicationRepository.Communication_EventTrigger_producttype);
		selectlistelements(CommunicationRepository.Communication_EventTrigger_enterproducttype, BaseTest.getData().ProductType);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(CommunicationRepository.Communication_EventTrigger_primarygoal);
		selectlistelements(CommunicationRepository.Communication_EventTrigger_enterprimarygoal, BaseTest.getData().PrimaryGoal);
		explicitwaitforclick(autolocator(CommunicationRepository.Communication_EventTrigger_goalpercentage), 10);
		enterValue(CommunicationRepository.Communication_EventTrigger_goalpercentage, BaseTest.getData().GoalPercentage);
		javaScriptScrollDown();
		return this;
	}

	// new DL
	public CommunicationCreatePage selectDynamicList()
	{
		tabAction();

		threadSleep(ObjectRepository.wait1sec);
		javaScriptScrollUpToSomeExtend();

		clickElement(CommunicationRepository.Communication_EventTrigger_selectdynamiclist);

		explicitwaitforpresence(autolocator(CommunicationRepository.communicationpage_communicationtype_listbox), 30);
		String f = BaseTest.getData().TargetListNew;
//		if (!selectlistelements(CommunicationRepository.Communication_EventTrigger_enterdynamiclist, BaseTest.getData().TargetListNew))
//		{
//			selectlistelements(CommunicationRepository.Communication_EventTrigger_enterdynamiclist, BaseTest.getData().TargetListOld);
//		}

		// threadSleep(ObjectRepository.wait3sec);

		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, ETdynamicList);

		return this;
	}

	// Select Communication Frequency
	public CommunicationCreatePage selectFrequencyImmediate()
	{
		explicitwaitforclick(autolocator(CommunicationRepository.Communication_EventTrigger_selectfrequency), 30);
		selectlistelements(CommunicationRepository.Communication_EventTrigger_selectfrequency, "Immediate");
		return this;
	}

	// Select Communication Frequency
	public CommunicationCreatePage selectFrequencyDaily()
	{
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(CommunicationRepository.Communication_EventTrigger_selectfrequency, "Daily");
		explicitwaitforvisibility(autolocator(CommunicationRepository.Communication_EventTrigger_enterdailydayvalue), 30);
		enterValue(CommunicationRepository.Communication_EventTrigger_enterdailydayvalue, BaseTest.getData().EveryDayWeek);
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforclick(autolocator(CommunicationRepository.Communication_EventTrigger_selectdailyhoursvalue), 30);
		clickElement(CommunicationRepository.Communication_EventTrigger_selectdailyhoursvalue);
		explicitwaitforvisibility(autolocator(CommunicationRepository.Communication_EventTrigger_enterdailyhoursvalue), 30);
		selectlistelements(CommunicationRepository.Communication_EventTrigger_enterdailyhoursvalue, BaseTest.getData().Hours);
		return this;
	}

	// Select Communication Frequency
	public CommunicationCreatePage selectFrequencyWeekly()
	{
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(CommunicationRepository.Communication_EventTrigger_selectfrequency, "Weekly");
		explicitwaitforvisibility(autolocator(CommunicationRepository.Communication_EventTrigger_enterweeklydayvalue), 30);
		enterValue(CommunicationRepository.Communication_EventTrigger_enterweeklydayvalue, BaseTest.getData().EveryDayWeek);
		threadSleep(ObjectRepository.wait1sec);
		clickElement(CommunicationRepository.Communication_EventTrigger_selectweeklyhoursvalue);
		threadSleep(ObjectRepository.wait1sec);
		explicitwaitforvisibility(autolocator(CommunicationRepository.Communication_EventTrigger_enterweeklyhoursvalue), 30);
		selectlistelements(CommunicationRepository.Communication_EventTrigger_enterweeklyhoursvalue, BaseTest.getData().Hours);
		String[] splitdays = BaseTest.getData().WeekDays.split(",");
		for (String result : splitdays)
		{
			List<WebElement> weekselection = driver.findElements(By.xpath("//ul[@class='list-block block margin-T20']/li"));
			for (WebElement allele : weekselection)
			{
				String inputtext = allele.getText();
				if (result.toLowerCase().contains(inputtext.toLowerCase()))
				{
					selectlistelements(",xpath, //ul[@class='list-block block margin-T20']/li", inputtext);
				}
			}
		}
		return this;
	}

	// Select Communication Frequency exact day
	public CommunicationCreatePage selectFrequencyMonthlyExactDay()
	{
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(CommunicationRepository.Communication_EventTrigger_selectfrequency, "Monthly");
		threadSleep(ObjectRepository.wait1sec);
		clickElement(CommunicationRepository.Communication_EventTrigger_selectmonthlyexactdayradiobtn);
		enterValue(CommunicationRepository.Communication_EventTrigger_entermonthlyexactdayvalue, BaseTest.getData().EveryDayWeek);
		threadSleep(ObjectRepository.wait1sec);
		enterValue(CommunicationRepository.Communication_EventTrigger_entermonthlyexactmonthvalue, BaseTest.getData().EveryDayWeekMonth);
		clickElement(CommunicationRepository.Communication_EventTrigger_selectmonthlyexacthoursvalue);
		explicitwaitforvisibility(autolocator(CommunicationRepository.Communication_EventTrigger_entermonthlyexacthoursvalue), 30);
		selectlistelements(CommunicationRepository.Communication_EventTrigger_entermonthlyexacthoursvalue, BaseTest.getData().Hours);
		return this;
	}

	// Select Communication Frequency any day
	public CommunicationCreatePage selectFrequencyMonthlyAnyDay()
	{
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(CommunicationRepository.Communication_EventTrigger_selectfrequency, "Monthly");
		threadSleep(ObjectRepository.wait1sec);
		clickElement(CommunicationRepository.Communication_EventTrigger_selectmonthlyanydayradiobtn);
		clickElement(CommunicationRepository.Communication_EventTrigger_selectmonthlyanydaytimevalue);
		explicitwaitforclick(autolocator(CommunicationRepository.Communication_EventTrigger_entermonthlyanydaytimevalue), 30);
		selectlistelements(CommunicationRepository.Communication_EventTrigger_entermonthlyanydaytimevalue, BaseTest.getData().EveryDayWeek);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(CommunicationRepository.Communication_EventTrigger_selectmonthlyanydaydayvalue);
		threadSleep(ObjectRepository.wait1sec);
		explicitwaitforvisibility(autolocator(CommunicationRepository.Communication_EventTrigger_entermonthlyanydaydayvalue), 30);
		selectlistelements(CommunicationRepository.Communication_EventTrigger_entermonthlyanydaydayvalue, BaseTest.getData().EveryDayWeekMonth);
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforvisibility(autolocator(CommunicationRepository.Communication_EventTrigger_entermonthlyanydaymonthvalue), 30);
		enterValue(CommunicationRepository.Communication_EventTrigger_entermonthlyanydaymonthvalue, BaseTest.getData().EveryMonth);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(CommunicationRepository.Communication_EventTrigger_selectmonthlyanydayhoursvalue);
		explicitwaitforvisibility(autolocator(CommunicationRepository.Communication_EventTrigger_entermonthlyanydayhoursvalue), 30);
		selectlistelements(CommunicationRepository.Communication_EventTrigger_entermonthlyanydayhoursvalue, BaseTest.getData().Hours);
		return this;
	}

	// Select email channel checkbox
	public CommunicationCreatePage selectTriggerChannelType(String ChannelName)
	{
		threadSleep(ObjectRepository.wait3sec);
		String[] obtName = ChannelName.split(",");
		if (isDynammicListSelectedAlready(ChannelName))
		{
			for (String channel : obtName)
			{
				threadSleep(ObjectRepository.wait1sec);
				clickElement("Channel is" + channel + ",xpath, //ul[@id='TriggerchannelsList']//input[contains(@id,'TransactionTriggerCampaign_TransactionTriggerCampaign_Is" + channel + "')]");
				BaseTest.takeScreenshot();
			}
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Unable to select check box since all selected dynamic lists are already in use");
			BaseTest.takeScreenshot();
		}
		return this;
	}

	// Select web analytics checkbox
	public CommunicationCreatePage analyticOptionWeb()
	{
		if (!isSelected(CommunicationRepository.Communication_EventTrigger_analytictypeweb))
		{
			clickElement(CommunicationRepository.Communication_EventTrigger_analytictypeweb);
		}
		return this;
	}

	// Select app analytics checkbox
	public CommunicationCreatePage analyticOptionApp()
	{
		if (!isSelected(CommunicationRepository.Communication_EventTrigger_analytictypeapp))
		{
			clickElement(CommunicationRepository.Communication_EventTrigger_analytictypeapp);
		}
		return this;
	}

	// Select video analytics
	public CommunicationCreatePage analyticOptionVideos()
	{
		if (!isSelected(CommunicationRepository.Communication_EventTrigger_analytictypevideos))
		{
			clickElement(CommunicationRepository.Communication_EventTrigger_analytictypevideos);
		}
		return this;
	}

	// Select event trigger schedule date
	public CommunicationCreatePage enterScheduleDate(String val)
	{
		javaScriptScrollDown();
		threadSleep(ObjectRepository.wait5sec);
		selectDate(CommunicationRepository.communicationpage_emailschedule_date, val);
		System.out.println("Email scheduled date=======================> " + getStrText(CommunicationRepository.communicationpage_emailschedule_date));
		return this;
	}

	// Web push Pre Communication Summary Page
	public CommunicationCreatePage webpushprecommunicationpage()
	{

		threadSleep(ObjectRepository.wait10sec);
		javaScriptScrollIntoView(CommunicationRepository.precomm_content);
		if (isDisplayed(CommunicationRepository.precomm_content))
		{
			BaseTest.getTest().log(Status.INFO, "Analytics Created Successfully");
			BaseTest.getTest().log(Status.INFO, "Navigated to Pre Communication Summary Page");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Pre Communication Summary Page Not Loaded");
			BaseTest.takeScreenshot();
		}
		threadSleep(ObjectRepository.wait1sec);
		explicitwaitforclick(autolocator(CommunicationRepository.notification_webpush_wpnexttosave), 50);
		clickElement(CommunicationRepository.notification_webpush_wpnexttosave);
		BaseTest.getTest().log(Status.INFO, "Clicked Next icon to handle pop up ");
		threadSleep(ObjectRepository.wait1sec);
		clickElement(CommunicationRepository.notification_webpush_wpconfirmpopup);
		BaseTest.getTest().log(Status.INFO, "Pre Communication summary page pop up handled and communication saved");
		return this;
	}

	// Event Trigger Time Zone
	public CommunicationCreatePage triggerTimeZoneSelection()
	{
		threadSleep(ObjectRepository.wait3sec);
		clickElement(CommunicationRepository.Communication_EventTrigger_selecttriggertimezoneicon);
		BaseTest.getTest().log(Status.INFO, "Clicked on Trigger time zone Icon");
		explicitwaitforclick(autolocator(CommunicationRepository.Communication_EventTrigger_selecttriggertimezonelist), 30);
		clickElement(CommunicationRepository.Communication_EventTrigger_selecttriggertimezonelist);
		BaseTest.getTest().log(Status.INFO, "Clicked on Trigger time zone list");
		explicitwaitforclick(autolocator(CommunicationRepository.Communication_EventTrigger_entertriggertimezonelist), 30);
		selectlistelements(CommunicationRepository.Communication_EventTrigger_entertriggertimezonelist, BaseTest.getData().TimeZone);
		return this;
	}

	private HashMap<String, Integer> getSplitValues(String objRepo)
	{
		HashMap<String, Integer> splitProgressValues = new HashMap<String, Integer>();
		List<WebElement> splitValues = findElements(objRepo);
		for (WebElement splitvalues : splitValues)
		{
			String key = splitvalues.findElement(By.tagName("h3")).getText();
			String splitNumbervalue = splitvalues.findElement(By.xpath("//div[@class='pie_progress__number']")).getText().trim().replace("%", "");
			int value = Integer.parseInt(splitNumbervalue);
			splitProgressValues.put(key, value);
		}
		return splitProgressValues;
	}

	public CommunicationCreatePage savePlanPage()
	{
		javaScriptScrollDown();
		threadSleep(ObjectRepository.wait1sec);
		clickElement(CommunicationRepository.communication_EventTrigger_saveplanpage);
		return this;
	}

	private boolean isDynammicListSelectedAlready(String channelName)
	{
		boolean errMessage = false;
		for (int i = 1; i <= 5; i++)
		{
			WebElement errMsgBlocked = driver.findElement(By.xpath("//ul[@id='TriggerchannelsList']//input[contains(@id,'TransactionTriggerCampaign_TransactionTriggerCampaign_Is" + channelName + "')]"));
			String blockMsg = errMsgBlocked.getAttribute("class");
			if (blockMsg.contains("Blocked"))
			{
				clickElement(CommunicationRepository.Communication_EventTrigger_selectdynamiclist);
				clickElement("Trigger Dynamic list,xpath,(//ul[@id='TriggerDynamiclistId_listbox']/li[contains(@title,'Dymctrgt')])[" + i + "]");
			} else
			{
				errMessage = true;
				break;
			}
		}
		return errMessage;

	}

	public CommunicationCreatePage communicationEventTriggerCompareAttributeValues()
	{
		pageLoaderLogo();
		if (!getTextBoxVal(CommunicationRepository.Communication_EventTrigger_communicationname, "value").equalsIgnoreCase(communicationName))
		{
			BaseTest.getTest().log(Status.FAIL, "Comparing the EventTrigger Communication Name in UI '" + "' Differs from its input : " + communicationName);
			BaseTest.takeScreenshot();
		}
		if (!getStrText(CommunicationRepository.Communication_EventTrigger_comparecommtype).equalsIgnoreCase(BaseTest.getData().CommunicationType))
		{
			BaseTest.getTest().log(Status.FAIL, "Comparing the EventTrigger Communication Type in UI '" + "' Differs from its input : " + BaseTest.getData().CommunicationType);
			BaseTest.takeScreenshot();
		}
		if (!getStrText(CommunicationRepository.Communication_EventTrigger_compareproducttype).equalsIgnoreCase(BaseTest.getData().ProductType))
		{
			BaseTest.getTest().log(Status.FAIL, "Comparing the EventTrigger Product Type in UI '" + "' Differs from its input : " + BaseTest.getData().ProductType);
			BaseTest.takeScreenshot();
		}
		if (!getStrText(CommunicationRepository.Communication_EventTrigger_compareprimarygoal).equalsIgnoreCase(BaseTest.getData().PrimaryGoal))
		{

			BaseTest.getTest().log(Status.FAIL, "Comparing the EventTrigger Primary Goal in UI '" + "' Differs from its input : " + BaseTest.getData().PrimaryGoal);
			BaseTest.takeScreenshot();
		}
		javaScriptScrollDownToSomeExtend();
		String enteredDynamicList = getTextBoxVal("Selected DynamicList,xpath, //*[@id='TriggerDynamiclistId_listbox']/li", "title");
		if (enteredDynamicList.equalsIgnoreCase(BaseTest.getData().TargetListNew) || enteredDynamicList.equalsIgnoreCase(BaseTest.getData().TargetListNew))
		{
			BaseTest.getTest().log(Status.FAIL, "Comparing the EventTrigger Dynamic list in UI '" + "' Differs from its input : " + BaseTest.getData().TargetListNew);
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public CommunicationCreatePage chkboxvalidation(String channel, String analytics)
	{
		List<WebElement> channeltypechkbox = driver.findElements(By.xpath("//*[@id='TriggerchannelsList']//li//label/input[1]"));
		List<WebElement> channeltypelabel = driver.findElements(By.xpath("//*[@id='TriggerchannelsList']//span"));
		for (int i = 0; i < channeltypechkbox.size(); i++)
		{
			if (channeltypechkbox.get(i).getAttribute("checked") != null && channeltypelabel.get(i).getText().equalsIgnoreCase(channel))
			{
				System.out.println(channeltypelabel.get(i).getText());
				BaseTest.getTest().log(Status.INFO, "The selected channel type is equal : " + channel);
			}
		}

		List<WebElement> analytictypechkbox = driver.findElements(By.xpath("//*[@id='TriggeranalyticsList']//li//label/input[1]"));
		List<WebElement> analytictypelabel = driver.findElements(By.xpath("//*[@id='TriggeranalyticsList']//span"));
		for (int i = 0; i < analytictypechkbox.size(); i++)
		{
			if (analytictypechkbox.get(i).getAttribute("checked") != null && analytictypelabel.get(i).getText().equalsIgnoreCase(analytics))
			{
				System.out.println(analytictypelabel.get(i).getText());
				BaseTest.getTest().log(Status.INFO, "The selected analytic type is equal : " + analytics);
				System.out.println("");
			}
		}
		BaseTest.takeScreenshot();
		return this;
	}

	public void customRangeCalender(int testData, String selectYear, String element)
	{
		String[] a = calendarDate(testData).replaceAll(" ", ",").split(",");
		String Day = a[0].toString().trim();
		String month = a[1].toString().trim();
		String year = a[2].toString().trim();

		selectlistelementsAndProceed(selectYear, year);
		month = month.equals("Sept") ? "Sep" : month;
		selectlistelementsAndProceed("Month,xpath,//td[contains(@title, " + year + ")]", month);

		boolean val = false;
		List<WebElement> tableRow = findElements(element);
		for (WebElement ele : tableRow)
		{
			List<WebElement> tableColumn = ele.findElements(By.tagName("td"));
			for (WebElement cell : tableColumn)
			{
				String value = cell.getAttribute("class").trim();
				if (!value.contains("disabled"))
				{
					String Uidate = cell.getText().trim();
					if (Uidate.equals(Day))
					{
						cell.click();
						val = true;
						break;
					}
				}
			}
			if (val)
			{
				BaseTest.getTest().log(Status.INFO, "clicked date is ---> " + calendarDate(testData));
				break;
			}
		}
	}

	public CommunicationCreatePage paymentSummaryPage()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("PAYMENT SUMMARY PAGE", ExtentColor.BROWN));
		explicitwaitforvisibility(autolocator(CommunicationRepository.communicationpage_paymentsummarytext), 30);
		threadSleep(ObjectRepository.wait3sec);
		if (isDisplayed(CommunicationRepository.communicationpage_paymentsummarytext))
		{
			paymentDetails = getWebTableData(CommunicationRepository.communicationpage_payment_gridheader, CommunicationRepository.communicationpage_payment_gridrows, AnalyticsRepository.analytics_listing_pagination);

			int units = Integer.parseInt(getStrText("Units,xpath,//*[@class='camp-icon']/..//td[2]"));
			double unitsCharge = Double.parseDouble(getStrText("units Charge,xpath,//*[@class='camp-icon']/..//td[3]").replaceAll("[^0.0-9]", ""));
			double amount = Double.parseDouble(getStrText("Amount,xpath,//*[@class='camp-icon']/..//td[4]").replaceAll("[^0.0-9]", ""));
			double taxPercent = Double.parseDouble(getStrText("Tax percentage,xpath,//*[@class='bgWhite even']//td[1]").replaceAll("[^0.0-9]", ""));
			double taxAmount = Double.parseDouble(getStrText("Tax amount,xpath,//*[@class='bgWhite even']//td[2]").replaceAll("[^0.0-9]", ""));
			double payableAmount = Double.parseDouble(getStrText("Payable amount,xpath,//*[@class='text-end blue']").replaceAll("[^0.0-9]", ""));

			audienceList = paymentDetails.get(0).get("Channel").contains("QR") ? "(1)" : audienceList;

			String audience = StringUtils.substringBetween(audienceList, "(", ")");
			if (audience.equals(getStrText("Units,xpath,//*[@class='camp-icon']/..//td[2]")))
			{
				BaseTest.getTest().log(Status.INFO, "Potential Audience count as Expected : " + audience);
				DecimalFormat decimal = new DecimalFormat("#.####");
				double cal_Amount = Double.parseDouble(decimal.format(units * unitsCharge));
				double cal_Tax = Double.parseDouble(decimal.format(amount * taxPercent / 100));
				if (cal_Amount == amount && cal_Tax == taxAmount)
				{
					BaseTest.getTest().log(Status.INFO, "Calculated Amount value as Expected : " + cal_Amount);
					BaseTest.getTest().log(Status.INFO, "Calculated Tax value as Expected : " + taxAmount);
					double cal_PayableAmount = cal_Amount + cal_Tax;
					if (cal_PayableAmount == payableAmount)
					{
						BaseTest.getTest().log(Status.INFO, "Calculated total Payable Amount as Expected : " + payableAmount);
					} else
					{
						BaseTest.getTest().log(Status.FAIL, "Total payable Amount as not Expected , Actual :" + payableAmount + ", Caluclated :" + cal_PayableAmount);
						BaseTest.takeScreenshot();
					}
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Amount value as not Expected , Actual :" + amount + ", Caluclated :" + cal_Amount);
				}
			}
		}
		clickElement(CommunicationRepository.communicationpage_select_emailcommunicationconfirm);
		return this;
	}

	public CommunicationCreatePage paymentPage()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("PAYMENT PAGE", ExtentColor.BROWN));
		explicitwaitforvisibility(autolocator(CommunicationRepository.communication_payment_Text), 30);
		isDisplayed(CommunicationRepository.communication_payment_Text);
		enterValue(CommunicationRepository.communicationpage_payment_cardnumber, "4111111111111111");
		tabAction();
		pageLoaderLogo();
		enterValue(CommunicationRepository.communication_payment_cardname, "QA Automation");
		enterValue(CommunicationRepository.communication_payment_month, "06");
		enterValue(CommunicationRepository.communication_payment_year, "2025");
		enterValue(CommunicationRepository.communication_payment_cvv, "123");
		clickElement(CommunicationRepository.communication_payment_submit);
		return this;
	}

	public CommunicationCreatePage verifyPlanPageFields(String commStatus)
	{
		explicitwaitforvisibility(autolocator(CommunicationRepository.communicationpage_communicationname_textbox), 10);
		if (commStatus.equalsIgnoreCase("In progress") || commStatus.equalsIgnoreCase("Completed"))
		{
			uiPageEqualswithInputValue(communicationName, getTextBoxVal(CommunicationRepository.communicationpage_commcreation_edit_commName, "value"));
			uiPageEqualswithInputValue(BaseTest.getData().CommunicationType, getStrText(CommunicationRepository.communicationpage_commcreation_edit_commtype));
			uiPageEqualswithInputValue(BaseTest.getData().ProductType, getStrText(CommunicationRepository.communicationpage_commcreation_edit_prodtype));
			uiPageEqualswithInputValue(BaseTest.getData().PrimaryGoal, getStrText(CommunicationRepository.communicationpage_commcreation_edit_primarygoal));
			uiPageEqualswithInputValue(BaseTest.getData().GoalPercentage, getTextBoxVal(CommunicationRepository.communicationpage_commcreation_edit_primargoalPercent, "value"));
			String stDate = getTextBoxVal(CommunicationRepository.communicationpage_commcreation_edit_stDate, "value").trim();
			String endDate = getTextBoxVal(CommunicationRepository.communicationpage_commcreation_edit_endDate, "value").trim();
			if (stDate.equals(calendarSchedduleDate(0, "MMM dd, yyyy")) && endDate.equals(calendarSchedduleDate(3, "MMM dd, yyyy")))
			{
				BaseTest.getTest().log(Status.INFO, "Start Date -->" + stDate + " , End Date -->" + endDate + " as Expected");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "St Date --> Actual :" + stDate + ", Expected:" + calendarDate(0) + "End Date --> Actual :" + endDate + ", Expected:" + calendarDate(3));
				BaseTest.takeScreenshot();
			}
			List<WebElement> calender = findElements(CommunicationRepository.communicationpage_commcreation_edit_calender);
			String stDate1 = calender.get(0).getAttribute("class");
			String endDate1 = calender.get(1).getAttribute("class");
			if (commStatus.equalsIgnoreCase("In progress"))
			{
				if (endDate1.contains("click-off"))
				{
					BaseTest.getTest().log(Status.FAIL, "End Date Calender dropdown has disable mode");
					BaseTest.takeScreenshot();
				}
			} else if (commStatus.equalsIgnoreCase("Completed"))
			{
				if (!stDate1.contains("click-off") || !endDate1.contains("click-off"))
				{
					BaseTest.getTest().log(Status.FAIL, "Calander dropdown has Enable mode");
					BaseTest.takeScreenshot();
				}
			}
			if (communicationName.toUpperCase().contains("EMAIL") && !isElementPresent(CommunicationRepository.communicationpage_commcreation_edit_emailChannel))
			{
				BaseTest.getTest().log(Status.FAIL, "Check box doesn't selected for an EMAIL channel");
				BaseTest.takeScreenshot();
			}
			if (communicationName.toUpperCase().contains("SMS") && !isElementPresent(CommunicationRepository.communicationpage_commcreation_edit_smsChannel))
			{
				BaseTest.getTest().log(Status.FAIL, "Check box doesn't selected  for SMS channel");
				BaseTest.takeScreenshot();
			}
			javaScriptScrollDown();
		}
		return this;
	}

	public CommunicationCreatePage selectMultiDimension()
	{
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_multidimen_link), 60);
		clickElement(CommunicationRepository.communicationpage_multidimen_link);
		javaScriptScrollDown();
		return this;
	}

	public CommunicationCreatePage selectOffer(String OfferType)
	{
		pageLoaderLogo();
		clickElement(CommunicationRepository.Communicationcreation_offer);
		pageLoaderLogo();
		if (isElementPresent(CommunicationRepository.Communicationcreation_offerpage))
		{
			if (OfferType == "common")
			{
				clickElement(replacePlaceHolder(CommunicationRepository.Communicationcreation_offertype, "Common"));
				threadSleep(ObjectRepository.wait1sec);
				clickElement(CommunicationRepository.Communicationcreation_offer_select);
				selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "EMI");
				clickElement(CommunicationRepository.Communicationcreation_offerpage_selectList);
				selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Automation");

			} else if (OfferType == "unique")
			{
				clickElement(replacePlaceHolder(CommunicationRepository.Communicationcreation_offertype, "Unique"));
				threadSleep(ObjectRepository.wait1sec);
				clickElement(CommunicationRepository.Communicationcreation_offer_select);
				selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "EMI");
				clickElement(CommunicationRepository.Communicationcreation_offerpage_selectList);
				selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().SmartLink);
			}
			clickElement(CommunicationRepository.Communicationcreation_offer_save);
			pageLoaderLogo();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Offer code Page is not Displayed");
			BaseTest.takeScreenshot();
		}

		return this;
	}

	public CommunicationCreatePage enterStartDate(int val)
	{
		clickElement(CommunicationRepository.communicationstartdate);
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_calendaryear_click), 30);
		threadSleep(ObjectRepository.wait1sec);
		javaScriptScrollUpToSomeExtend();
		clickElement(CommunicationRepository.communicationpage_calendaryear_click);
		customRangeCalender(val, CommunicationRepository.calenderyearslist, CommunicationRepository.calenderstartdatetable);
		return this;
	}

	// Select communication end date
	public CommunicationCreatePage enterEndDate(int val)
	{
		clickElement(CommunicationRepository.communicationsendDate);
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_calendaryear_click), 30);
		threadSleep(ObjectRepository.wait1sec);
		clickElement(CommunicationRepository.communicationpage_calendaryear_click);
		customRangeCalender(val, CommunicationRepository.calenderyearslist, CommunicationRepository.calenderstartdatetable);

		return this;
	}

	public void commNameScenarios()
	{
		clickElement(CommunicationRepository.communication_TestCommQuestionMark);
		threadSleep(ObjectRepository.wait2sec);
		uiPageEqualswithMultipleInputValue(CommunicationRepository.communication_AnalyticsMessage, "This communication will proceed to execute without any approval. Analytics will not show accurate data.");
		clickElement(CommunicationRepository.communication_TestCommQuestionMark);
		boolean commNameMandate = isElementPresent(CommunicationRepository.communication_CommNameMandate);
		writeLog(commNameMandate, "Communication name set to mandatory", "Communication name is not set to mandatory");
		enterValue(CommunicationRepository.communicationpage_communicationname_textbox, System.getProperty("300char"));
		int commNamelength = getTextBoxVal(CommunicationRepository.communicationpage_communicationname_textbox, "value").length();
		writeLog(commNamelength == 75, "Communication name accepts only 75 characters", "Communication name is accepts more than 75 characters");
		clearField(CommunicationRepository.communicationpage_communicationname_textbox);
		tabAction();
		String commNameErrMsg = getTextBoxVal(CommunicationRepository.communication_CommNameErrorMessage, "class");
		writeLog(commNameErrMsg.contains("errorContainer"), "Validation message is available when proceed without communication", "Validation message is not available when proceed without communication");
		enterValue(CommunicationRepository.communicationpage_communicationname_textbox, "!@#$%^&*()+=}{][//><?");
		String splChaCheck = getTextBoxVal(CommunicationRepository.communicationpage_communicationname_textbox, "value");
		writeLog(splChaCheck.isEmpty(), "Communication name field does not accept the special characters", "Communication name field accepts the special characters");
		enterValue(CommunicationRepository.communicationpage_communicationname_textbox, System.getProperty("CommnameScenarios"));

		tabAction();
		threadSleep(ObjectRepository.wait5sec);
		boolean existingComm = isElementPresent(CommunicationRepository.communication_ExistingCommError);
		writeLog(existingComm, "Validation message is displayed when entered the existing communication", "Validation message is not displayed when entered the existing communication");
		String testcomm = getTextBoxVal(CommunicationRepository.communication_TestCommunication, "value");
		writeLog(testcomm.contains("false") || testcomm.isEmpty(), "Test communication is unchecked by default", "Test communication is not unchecked by default");
		clearField(CommunicationRepository.communicationpage_communicationname_textbox);
		enterValue(CommunicationRepository.communicationpage_communicationname_textbox, "AA");
		boolean min3Char = isElementPresent(CommunicationRepository.communication_Min3CharValidation);
		writeLog(min3Char, "Validation message shown when entered only two characters", "Validation message is not shown when entered only two characters");
		toolTipValidationKnownText(CommunicationRepository.communication_TagsIcon, "Tags");
		clickElement(CommunicationRepository.communication_TagsIcon);
//		explicitwaitforvisibility(autolocator(CommunicationRepository.communication_TagsKeywords), 20);
//		enterValue(CommunicationRepository.communication_TagsKeywords, System.getProperty("300char"));
//		int tagsLength = getTextBoxVal(CommunicationRepository.communication_TagsKeywords, "value").length();
//		writeLog(tagsLength == 75, "Tags keyword accepts only 75 characters", "Tags keyword accepts more than 75 characters");
		clearField(CommunicationRepository.communication_TagsKeywords);
		enterValue(CommunicationRepository.communication_TagsKeywords, "q,w,e,r,t,y,");
		boolean tagLimitErr = isElementPresent(CommunicationRepository.communication_TagLimitValidation);
		writeLog(tagLimitErr, "Only 5 tags can be added as expected", "More than 5 tags can be able to add");
		clickElement(CommunicationRepository.communication_CloseIcon);
		clearField(CommunicationRepository.communicationpage_communicationname_textbox);
		communicationName = "_comm-" + addTimeToName();
		enterValue(CommunicationRepository.communicationpage_communicationname_textbox, communicationName);
		tabAction();
		explicitwaitforvisibility(autolocator(CommunicationRepository.communication_SuccessValidationIcon), 15);
		boolean validationSuccessMessage = driver.findElement(By.xpath("//div[contains(@class,'validate-success')]")).isDisplayed();
		writeLog(validationSuccessMessage, "Validation tick icon displayed after entered valid communication name", "Validation tick icon is not displayed after entered valid communication name");
	}

	public void commTypeScenarios()
	{
		String commTypeMandate = getTextBoxVal(CommunicationRepository.communication_CommTypeMandate, "class");
		writeLog(commTypeMandate.contains("required"), "Communication type dropdown is set as mandatory as expected", "Communication type dropdown is not set as mandatory as expected");

		String productTypeMandate = getTextBoxVal(CommunicationRepository.communication_ProductTypeMandate, "class");
		writeLog(productTypeMandate.contains("required"), "Product type dropdown is set as mandatory as expected", "Product type dropdown is not set as mandatory as expected");

		String primaryGoalMandate = getTextBoxVal(CommunicationRepository.communication_PrimaryGoalMandate, "class");
		writeLog(primaryGoalMandate.contains("required"), "Primary goal dropdown is set as mandatory as expected", "Primary goal dropdown is not set as mandatory as expected");

		selectCtype().selectPtype();
	}

	public void goalPercentageScenarios()
	{
		selectPgoal();
		boolean goalPerMandate = isElementPresent(CommunicationRepository.communication_GoalPercentageMandate);
		writeLog(goalPerMandate, "Goal percentage field is set as mandatory as expected", "Goal percentage field is not set as mandatory as expected");

		clickElement(CommunicationRepository.communication_PrimaryGoalAdd);
		explicitwaitforvisibility(autolocator(CommunicationRepository.communication_CommunicationGoalInfoHeader), 20);
		uiPageEqualswithMultipleInputValue(CommunicationRepository.communication_SecondaryGoalMessage, "Secondary goal will not be considered as the communication target.");
		clickElement(CommunicationRepository.communication_CloseIcon);
		threadSleep(ObjectRepository.wait2sec);

		clearField(CommunicationRepository.communicationpage_goalpercentage_textbox);
		enterValue(CommunicationRepository.communicationpage_goalpercentage_textbox, "101.5");
		tabAction();

		boolean goalPerErr = isElementPresent(CommunicationRepository.communication_GoalPercentageError);
		writeLog(goalPerErr, "Validation message is displayed when entered value more than 100", "Validation message is not displayed when entered value more than 100");

		clickElement(CommunicationRepository.communicationpage_primarygoal_select);
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Engagement");
		pageLoaderLogo();

		clearField(CommunicationRepository.communicationpage_goalpercentage_textbox);
		enterValue(CommunicationRepository.communicationpage_goalpercentage_textbox, "0");
		tabAction();

		boolean goalPerErr1 = isElementPresent(CommunicationRepository.communication_GoalPercentageError);
		writeLog(goalPerErr1, "Validation message is displayed when entered value more than 100 for engagement", "Validation message is not displayed when entered value more than 100 for engagement");

		String engagementType = getTextBoxVal(CommunicationRepository.communication_EngagementType, "class");
		writeLog(engagementType.contains("required"), "Engagement type dropdown is set as mandatory field", "Engagement type dropdown is not set as mandatory field");

		clickElement(CommunicationRepository.communication_EngagementType);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Contact us");

		clickElement(CommunicationRepository.communicationpage_primarygoal_select);
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Conversion");
		pageLoaderLogo();

		clearField(CommunicationRepository.communicationpage_goalpercentage_textbox);
		enterValue(CommunicationRepository.communicationpage_goalpercentage_textbox, "101.5");
		tabAction();

		boolean goalPerErr2 = isElementPresent(CommunicationRepository.communication_GoalPercentageError);
		writeLog(goalPerErr2, "Validation message is displayed when entered value more than 100 for Conversion", "Validation message is not displayed when entered value more than 100 for Conversion");

		clickElement(CommunicationRepository.communication_ConversionType);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Video views");

		selectPgoal();
		enterGoalPercentage();
	}

	public void sdcCommPlanPageScenarios()
	{
		int startDate = 0;
		int endDate = 3;
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		clickCreateCommunicationfromMenu();

		uiPageEqualswithMultipleInputValue(CommunicationRepository.communication_CreationText, "Communication creation");
		uiPageEqualswithMultipleInputValue(CommunicationRepository.communication_DeliveryMethodText, "Choose delivery method");

		boolean singleDimensionIcon = isElementPresent(CommunicationRepository.communication_SingleDimensionIcon);
		writeLog(singleDimensionIcon, "Single dimension icon is available after clicking create communication", "Single dimension icon is not available after clicking create communication");

		boolean multiDimensionIcon = isElementPresent(CommunicationRepository.communication_MultiDimensionIcon);
		writeLog(multiDimensionIcon, "Multi dimension icon is available after clicking create communication", "Multi dimension icon is not available after clicking create communication");

		boolean eventTriggerIcon = isElementPresent(CommunicationRepository.communication_EventTriggerIcon);
		writeLog(eventTriggerIcon, "Event trigger icon is available after clicking create communication", "Event trigger icon is not available after clicking create communication");
//UI Changed
//		String companyNameDropdown = getTextBoxVal(CommunicationRepository.communication_CompanyNameDropdown, "class");
//		writeLog(!companyNameDropdown.contains("none"), "Company name dropdown is available before selecting a delivery method", "Company name dropdown is not available before selecting a delivery method");
//
//		String buDropdown = getTextBoxVal(CommunicationRepository.communication_BUDropdown, "class");
//		writeLog(!buDropdown.contains("none"), "BU dropdown is available before selecting a delivery method", "BU dropdown is not available before selecting a delivery method");

		clickElement(CommunicationRepository.communication_SingleDimensionIcon);

		boolean multiDimensionDisable = isElementPresent(",xpath,(//li[@class='tabDefault   click-off  '])[1]");
		boolean eventTriggerDisable = isElementPresent(",xpath,(//li[@class='tabDefault   click-off  '])[2]");
		writeLog(eventTriggerDisable && multiDimensionDisable, "Multi-dimension and event trigger icons get disabled after clicking single dimension", "Multi-dimension and event trigger icons did not get disabled after clicking single dimension");

		toolTipValidationKnownText(CommunicationRepository.communication_RefreshIcon, "Refresh");
		clickElement(CommunicationRepository.communication_RefreshIcon);
		explicitwaitforvisibility(autolocator(CommunicationRepository.communication_RefreshModal), 20);
		clickElement(CommunicationRepository.communication_RefreshOKButton);

		clickElement(CommunicationRepository.communication_SingleDimensionIcon);
		pageLoaderLogo();

		commNameScenarios();
		commTypeScenarios();
		goalPercentageScenarios();

		String roiToggleState = getTextBoxVal(CommunicationRepository.communication_ROIToggle, "class");
		writeLog(roiToggleState.contains("switch-off"), "ROI toggle button is off by default", "ROI toggle button is not off by default");

		javaScriptScrollDown();
		enterStartDate(startDate);
		threadSleep(ObjectRepository.wait3sec);
		enterEndDate(endDate);
		BaseTest.takeScreenshot();

		String[] channelType = { "Email", "Messaging", "Notifications", "Social post", "Voice", "Paid ads", "QR" };
		for (String type : channelType)
		{
			if (isElementPresent(",xpath,//span[contains(.,'" + type + "')]/..//input"))
			{
				driver.findElement(By.xpath("//span[contains(.,'" + type + "')]/..//input")).click();
				String valueChecked = getTextBoxVal(",xpath,//span[contains(.,'" + type + "')]/..//input", "value");
				if (valueChecked.equals("true"))
				{
					BaseTest.getTest().log(Status.INFO, type + " channel type is available as expected");
				} else
				{
					BaseTest.getTest().log(Status.FAIL, type + " channel type is unable to be selected");
					BaseTest.takeScreenshot();
				}
			} else
			{
				BaseTest.getTest().log(Status.FAIL, type + " channel type is not available.");
			}
		}
//Sentiment checkbox is under development
		// String[] analyticsType = { "Web", "App", "Sentiment" };
		String[] analyticsType = { "Web", "App" };
		driver.findElement(By.xpath("//span[contains(.,'" + analyticsType[0] + "')]/..//input")).click();

		for (String type : analyticsType)
		{
			if (isElementPresent(",xpath,//span[contains(.,'" + type + "')]/..//input"))
			{
				driver.findElement(By.xpath("//span[contains(.,'" + type + "')]/..//input")).click();
				String valueChecked = getTextBoxVal(",xpath,//span[contains(.,'" + type + "')]/..//input", "value");
				if (valueChecked.equals("true"))
				{
					BaseTest.getTest().log(Status.INFO, type + " Analytics type is available as expected");
				} else
				{
					BaseTest.getTest().log(Status.FAIL, type + " Analytics type is unable to be selected");
					BaseTest.takeScreenshot();
				}
			} else
			{
				BaseTest.getTest().log(Status.FAIL, type + " Analytics type is not available.");
			}
		}

		BaseTest.takeScreenshot();
		javaScriptScrollDown();
		clickElement(CommunicationRepository.communication_CancelButton);
		pageLoaderLogo();

		boolean flag = true;
		List<WebElement> communications = driver.findElements(By.xpath("(//div[contains(@class,'inline-block')])"));
		for (WebElement communication : communications)
		{
			if (communication.getText().equals(communicationName))
			{
				flag = false;
			}
		}

		writeLog(flag, "Communication details were not saved after clicking the Cancel button", "Communication details were saved after clicking the Cancel button");
	}

	public void mdcCommPlanPageScenarios()
	{
		int startDate = 0;
		int endDate = 3;
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		clickCreateCommunicationfromMenu();

		clickElement(CommunicationRepository.communication_MultiDimensionIcon);
		pageLoaderLogo();

		boolean singleDimensionDisable = isElementPresent(CommunicationRepository.communication_SingleDimensionDisable);
		boolean eventTriggerDisable = isElementPresent(CommunicationRepository.communication_EventTriggerDisable);

		writeLog(eventTriggerDisable && singleDimensionDisable, "Single dimension and event trigger icons get disabled after clicking Multi dimension", "Single dimension and event trigger icons did not get disabled after clicking Multi dimension");

		toolTipValidationKnownText(CommunicationRepository.communication_RefreshIcon, "Refresh");
		clickElement(CommunicationRepository.communication_RefreshIcon);
		explicitwaitforvisibility(autolocator(CommunicationRepository.communication_RefreshModal), 20);
		clickElement(CommunicationRepository.communication_RefreshOKButton);

		clickElement(CommunicationRepository.communication_MultiDimensionIcon);
		pageLoaderLogo();

		commNameScenarios();
		commTypeScenarios();
		goalPercentageScenarios();

		javaScriptScrollDown();
		enterStartDate(startDate);
		threadSleep(ObjectRepository.wait3sec);
		enterEndDate(endDate);
		BaseTest.takeScreenshot();

		javaScriptScrollDown();
		clickElement(CommunicationRepository.communication_CancelButton);
		pageLoaderLogo();

		threadSleep(ObjectRepository.wait5sec);

		boolean flag = true;
		List<WebElement> communications = driver.findElements(By.xpath(CommunicationRepository.communication_CommunicationsList));

		for (WebElement communication : communications)
		{
			if (communication.getText().equals(communicationName))
			{
				flag = false;
			}
		}

		writeLog(flag, "Communication details were not saved after clicking the Cancel button", "Communication details were saved after clicking the Cancel button");
	}

	public void socialPostCreation(String Channel)
	{
		int startDate = 0;
		int endDate = 3;
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		javaScriptScrolltoTop();
		threadSleep(ObjectRepository.wait5sec);
		if (Channel.equalsIgnoreCase("facebook"))
		{
			clickElement(CommunicationRepository.socialpost_facebookchannel);
			pageLoaderLogo();
			threadSleep(ObjectRepository.wait2sec);
			enterValue(CommunicationRepository.socialpost_postname, BaseTest.getData().CommunicationName);
			threadSleep(ObjectRepository.wait3sec);
			clickElement(CommunicationRepository.socialpost_poston);
			selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Shine_Star");
		} else if (Channel.equalsIgnoreCase("twitter"))
		{
			clickElement(CommunicationRepository.socialpost_twitterchannel);
			pageLoaderLogo();
			threadSleep(ObjectRepository.wait2sec);
			enterValue(CommunicationRepository.socialpost_postname, BaseTest.getData().CommunicationName);
			threadSleep(ObjectRepository.wait2sec);
			clickElement(CommunicationRepository.socialpost_poston);
			selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Team Resulticks");
		} else if (Channel.equalsIgnoreCase("instagram"))
		{
			clickElement(CommunicationRepository.socialpost_instagramchannel);
			pageLoaderLogo();
			threadSleep(ObjectRepository.wait2sec);
			enterValue(CommunicationRepository.socialpost_postname, BaseTest.getData().CommunicationName);
			threadSleep(ObjectRepository.wait2sec);
			clickElement(CommunicationRepository.socialpost_poston);
			selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Team Resulticks");
		} else
		{
			clickElement(CommunicationRepository.socialpost_linkedinchannel);
			pageLoaderLogo();
			threadSleep(ObjectRepository.wait2sec);
			enterValue(CommunicationRepository.socialpost_postname, BaseTest.getData().CommunicationName);
			threadSleep(ObjectRepository.wait2sec);
			clickElement(CommunicationRepository.socialpost_poston);
			threadSleep(ObjectRepository.wait2sec);
			selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "res-positive-vibes");
		}
		threadSleep(ObjectRepository.wait2sec);
		javaScriptScrollIntoViewExact(CommunicationRepository.socialpost_textbox);
		enterValue(CommunicationRepository.socialpost_textbox, BaseTest.getData().EmailSubjectLine);
		BaseTest.takeScreenshot();
		javaScriptScrollDownToSomeExtend();
		if (!Channel.equalsIgnoreCase("twitter"))
		{
			enterValue(CommunicationRepository.socialpost_postlink, BaseTest.getData().TargetListNew);
		}
		String tag1 = "Omnichannel";
		String tag2 = "Resulticks";
		enterValue(CommunicationRepository.socialpost_trendingtopis, tag1);
		enterAction();
		enterValue(CommunicationRepository.socialpost_trendingtopis, tag2);
		enterAction();
		boolean tagPresent1 = isElementPresent(",xpath,//li[@class='rs-tag'][.='#" + tag1 + "']");
		boolean tagPresent2 = isElementPresent(",xpath,//li[@class='rs-tag'][.='#" + tag2 + "']");
		writeLog(tagPresent1 && tagPresent2, "Trending topics are added successfully", "Trending topics are not added");
		javaScriptScrollDown();
		// comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		comm.clickNextemail();
		comm.pageLoaderLogo();
		if (comm.isElementPresent("Validation message,xpath,//div[@class='validation-message'][contains(.,'later than 15')]"))
		{
			comm.enterEmailScheduleTime(startDate);
			comm.clickNextemail();
			comm.pageLoaderLogo();
		}
		comm.javaScriptScrollDown();
		comm.clickElement("Web analytics,xpath,//i[contains(@class,'icon-rs-web-analytics-large icon-lg')]");
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails();
		threadSleep(ObjectRepository.wait10sec);
	}

	public void socialPostFBRegression()
	{
		int startDate = 0;
		int endDate = 3;
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		javaScriptScrollDown();
		threadSleep(ObjectRepository.wait5sec);
		clickElement(CommunicationRepository.communication_CancelButton);
		pageLoaderLogo();
		boolean cancelBtnNavigation = isElementPresent(CommunicationRepository.communication_CreationHeader);
		writeLog(cancelBtnNavigation, "Page is navigated to listing page after clicking cancel button in authoring page", "Page is not navigated to listing page after clicking cancel button in authoring page");
		String commName = communicationName;
		communicationlistingPageStatusCompare("Draft");
		editcommWithName(commName);
		javaScriptScrollDown();
		clickNext();
		pageLoaderLogo();
		boolean fbActive = isElementPresent(CommunicationRepository.communication_FacebookActiveTab);
		writeLog(fbActive, "Facebook channel is highlighted in default", "Facebook channel is not highlighted in default");
		javaScriptScrollDown();
		clickElement(CommunicationRepository.communication_SaveButton);
		boolean validationmsg = isElementPresent(CommunicationRepository.communication_ValidationMessage);
		writeLog(validationmsg, "System throws validation message when clicking save button without filling any values", "System does not throw validation message when clicking save button without filling any values");
		// clickNext();
//		boolean elementPresent = isElementPresent(CommunicationRepository.communication_IgnoreChannelWarning);
//		writeLog(elementPresent, "Text is displayed: Are you sure you want to ignore this channel", "Text is not displayed: Are you sure you want to ignore this channel");
		// clickElement(CommunicationRepository.communication_CancelButton);
		refresh();
		javaScriptScrolltoTop();
		String characters = "@#$%^--123abcd";
		enterValue(CommunicationRepository.communication_SocialPost_PostName, characters);
		String postNameChar = getTextBoxVal(CommunicationRepository.communication_SocialPost_PostName, "value");
		writeLog(postNameChar.equals(characters), "Post name field is accepting alphanumeric and special characters", "Post name field is not accepting alphanumeric or special characters");
		enterValue(CommunicationRepository.communication_SocialPost_PostName, System.getProperty("300char"));
		String postNameCharlen = getTextBoxVal(CommunicationRepository.communication_SocialPost_PostName, "value");
		writeLog(postNameCharlen.length() == 50, "Post name field is accepting only 50 characters", "Post name field is accepting more than 50 characters");
		threadSleep(ObjectRepository.wait3sec);
		clickElement(CommunicationRepository.communication_SocialPost_Poston);
		selectlistelements(CommunicationRepository.communication_ListingPage_CreateCommunication, "Shine_Star");
		javaScriptScrollIntoViewExact(CommunicationRepository.communication_SocialPost_BoostButton);
		String boostOnbtnStatus = getTextBoxVal(CommunicationRepository.communication_SocialPost_BoostButton, "aria-checked");
		writeLog(boostOnbtnStatus.contains("false"), "The boost post toggle button is disabled by default.", "The boost post toggle button is not disabled by default.");
		clickElement(CommunicationRepository.communication_SocialPost_BoostButton);
		threadSleep(ObjectRepository.wait5sec);
		javaScriptScrollIntoViewExact(CommunicationRepository.communication_SocialPost_Target);
		clickElement(CommunicationRepository.communication_SocialPost_Target);

		//////
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait10sec);
		javaScriptScrollIntoViewExact(CommunicationRepository.communication_CancelButton);
		clickElement(CommunicationRepository.socialpost_country);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "India");
		javaScriptScrollDownToSomeExtend();
		clickElement(CommunicationRepository.communication_CancelButton);
		clickElement(CommunicationRepository.socialpost_target);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait10sec);
		boolean targetretain = isElementPresent(CommunicationRepository.communication_TargetCountry);
		writeLog(!targetretain, "Value not retained after clicking the cancel button", "Value is retained after clicking the cancel button");
		dropDoWnMandateCheck("Country");
		dropDoWnMandateCheck("Age from");
		dropDoWnMandateCheck("Age to");
		clickElement(CommunicationRepository.socialpost_country);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "India");
		clickElement(CommunicationRepository.socialpost_agefrom);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "15");
		clickElement(CommunicationRepository.socialpost_ageto);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "17");
		uiPageEqualswithMultipleInputValue(CommunicationRepository.communication_GenderSelection, "All,Male,Female");
		clickElement(CommunicationRepository.communication_SaveButton);
		clickElement(CommunicationRepository.socialpost_target);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait10sec);
		boolean targetretain1 = isElementPresent(CommunicationRepository.communication_TargetCountry);
		writeLog(targetretain1, "Value retained after saving", "Value is not retained after clicking the save button");
		clickElement(CommunicationRepository.communication_SaveButton);
		pageLoaderLogo();
		javaScriptScrollDownToSomeExtend();
		boolean isEmojiAvailable = isElementPresent(CommunicationRepository.socialpost_textfield_emoji);
		boolean isVideoUploadAvailable = isElementPresent(CommunicationRepository.socialpost_textfield_videoupload);
		writeLog(isEmojiAvailable, "Emoji option is available in the text field", "Emoji option is not available in the text field");
		writeLog(isVideoUploadAvailable, "Video upload option is available in the text field", "Video upload option is not available in the text field");
		findElement(CommunicationRepository.socialpost_textfield).sendKeys(System.getProperty("moreThan1000Char"));
		String is1000charAvail = getStrText(CommunicationRepository.socialpost_textfield);
		writeLog(is1000charAvail.length() == 1000, "Text field accepts only 1000 characters", "Text field accepts more than 1000 characters");
		String validCharacters = "1@@#%$$***&&&_+=12345678Abcd@1234";
		enterValue(CommunicationRepository.socialpost_textfield, validCharacters);
		String textFieldCharacters = getStrText(CommunicationRepository.socialpost_textfield);
		writeLog(textFieldCharacters.equals(validCharacters), "Textfield accepts alphanumerical and special characters", "Textfield does not accept alphanumerical and special characters");
		clickElement(CommunicationRepository.socialpost_textfield_smartlink);

		threadSleep(ObjectRepository.wait2sec);
		clickElement(CommunicationRepository.communication_SmartLink1);
		threadSleep(ObjectRepository.wait3sec);
		String textFieldChar = getStrText(CommunicationRepository.socialpost_textfield);
		writeLog(textFieldChar.contains("https://"), "Smart link is generated and inserted successfully", "Smart link is not generated and inserted successfully");
		String preview = getStrText(CommunicationRepository.socialpost_preview);
		writeLog(preview.equals(textFieldChar), "Text field content matches preview content", "Text field content does not match preview content");
		clickElement(CommunicationRepository.socialpost_textfield_preview);
		threadSleep(ObjectRepository.wait3sec);
		String previewText = getStrText(CommunicationRepository.socialpost_textfield_preview_text);
		writeLog(previewText.equals(textFieldChar), "Text field content matches the eye icon preview content", "Text field content does not match the eye icon preview content");
		clickElement(CommunicationRepository.socialpost_textfield_preview_close);
		String isPostLinkMandate = getTextBoxVal(CommunicationRepository.communication_PostLinkMandate, "class");
		writeLog(isPostLinkMandate.contains("required"), "Post link text field is set as a mandatory field", "Post link text field is not set as a mandatory field");
		enterValue(CommunicationRepository.socialpost_postlink, "Test");
		tabAction();
		boolean invalidWebsite = isElementPresent(CommunicationRepository.communication_InvalidWebsiteError);
		writeLog(invalidWebsite, "System throws an error message when an invalid website is entered in the post link field", "System does not throw an error message when an invalid website is entered in the post link field");
		clearField(CommunicationRepository.socialpost_postlink);
		enterValue(CommunicationRepository.socialpost_postlink, "https://www.resulticks.com");
		javaScriptScrollDownToSomeExtend();
		isDisplayed(CommunicationRepository.communication_TrendingTopicsLabel);
		clickElement(CommunicationRepository.communication_TopicsQuestionMark);
		threadSleep(ObjectRepository.wait2sec);
		clickElement(CommunicationRepository.communication_TopicsQuestionMark);
		threadSleep(ObjectRepository.wait2sec);
		uiPageEqualswithMultipleInputValue(CommunicationRepository.communication_PopoverBody, "View analytics for trending topics");
		clickElement(CommunicationRepository.communication_TopicsQuestionMark);
		String tag1 = "Omnichannel";
		String tag2 = "Resulticks";
		enterValue(CommunicationRepository.communication_TrendingTopicsInput, tag1);
		enterAction();
		enterValue(CommunicationRepository.communication_TrendingTopicsInput, tag2);
		enterAction();
		boolean tagPresent1 = isElementPresent(CommunicationRepository.communication_TagOmnichannel);
		boolean tagPresent2 = isElementPresent(CommunicationRepository.communication_TagResulticks);
		writeLog(tagPresent1 && tagPresent2, "Trending topics are added successfully", "Trending topics are not added");
		javaScriptScrollDown();
		// comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		clickElement(CommunicationRepository.communication_SaveButton);

		comm.pageLoaderLogo();
		if (comm.isElementPresent(CommunicationRepository.communication_ValidationMessage_))
		{
			comm.enterEmailScheduleTime(startDate);
			clickElement(CommunicationRepository.communication_SaveButton);
			comm.pageLoaderLogo();
		}
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait10sec);
		communicationlistingPageStatusCompare("Scheduled");

	}

	public void paidMediaCommunicationCreation()
	{
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		javaScriptScrolltoTop();
		isDisplayed("Google paid media default,xpath,//li[contains(@class,'tabDefault active')][.='Google']");
		WebElement adTypeElements = findElement(CommunicationRepository.paidads_adtype);
		List<WebElement> channels = driver.findElements(By.xpath("//ul[contains(@class,'sub-tabs')]//li"));
		for (int i = 0; i < channels.size() - 2; i++)
		{
			javaScriptScrolltoTop();
			threadSleep(ObjectRepository.wait3sec);
			adTypeElements.click();
			String activeChannel = getStrText(CommunicationRepository.communication_ActiveChannel);

			if (activeChannel.equalsIgnoreCase("Google"))
			{
				selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Display ad only");
				threadSleep(ObjectRepository.wait2sec);
				findElement(CommunicationRepository.paidads_adname1).sendKeys("Gl" + addTimeToName());
			} else if (activeChannel.equalsIgnoreCase("Facebook"))
			{
				selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Send people to your website");
				threadSleep(ObjectRepository.wait2sec);
				findElement(CommunicationRepository.paidads_adname1).sendKeys("FB" + addTimeToName());
			} else if (activeChannel.equalsIgnoreCase("Twitter"))
			{
				selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Website clicks or conversions");
				threadSleep(ObjectRepository.wait2sec);
				findElement(CommunicationRepository.paidads_adname1).sendKeys("TW" + addTimeToName());
			} else if (activeChannel.equalsIgnoreCase("Linkedin"))
			{
				selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Text ads");
				threadSleep(ObjectRepository.wait2sec);
				findElement(CommunicationRepository.paidads_adname1).sendKeys("LN" + addTimeToName());
			}

			tabAction();
			threadSleep(ObjectRepository.wait10sec);
			javaScriptScrollIntoViewExact(CommunicationRepository.communication_CopyButton);
			String copiedLink = getStrText(CommunicationRepository.communication_SmartLink_2);
			threadSleep(ObjectRepository.wait2sec);
			clickElement(CommunicationRepository.communication_CopyButton);
			threadSleep(ObjectRepository.wait1sec);

			boolean elementPresent = driver.findElement(By.xpath("//small[.='Copied']")).isDisplayed();
			if (elementPresent)
			{
				BaseTest.takeScreenshot();
				threadSleep(ObjectRepository.wait5sec);
				javaScriptopenNewWindow();
				String parentWinHandle = parentWinHandle();
				switchWindow();
				driver.get(copiedLink);
				threadSleep(ObjectRepository.wait5sec);

				if (isElementPresent(CommunicationRepository.communication_AllowButton))
				{
					clickElement(CommunicationRepository.communication_AllowButton);
				}

				if (isDisplayed(CommunicationRepository.communication_RenewButton))
				{
					BaseTest.getTest().info("Page is successfully navigated to given smart link");
					BaseTest.takeScreenshot();
				} else
				{
					BaseTest.getTest().fail("Page is not navigated to given smart link");
					BaseTest.takeScreenshot();
				}

				switchWindow();
				childWindowClose(parentWinHandle);
			} else
			{
				BaseTest.getTest().fail("Success alert message is not present (or) text is not copied to clipboard");
				BaseTest.takeScreenshot();
			}

			// javascriptdoublescrolldown();
			explicitwaitforvisibility(autolocator(CommunicationRepository.communication_NextButton), 30);
			// javaScriptScrollIntoView(CommunicationRepository.communication_NextButton);
			clickElement(CommunicationRepository.communication_NextButton);
			pageLoaderLogo();
		}

		pageLoaderLogo();
		javaScriptScrollDown();
		clickElement(CommunicationRepository.communication_WebAnalytics);
		pageLoaderLogo();

		precomm.webAnalyticsDetails();
		searchCommunication("communicationlisting", communicationName);
	}

	public void accessCommunicationListingpage()
	{
		explicitwaitforvisibility(autolocator(CommunicationRepository.COMMUNICATION_CREATION_HEADER), 5);
		uiPageEqualswithInputValue(getStrText(CommunicationRepository.COMMUNICATION_CREATION_HEADER), "Communication");

		clickElement(CommunicationRepository.COMMUNICATION_DATE_FILTER);
		selectlistelements(CommunicationRepository.COMMUNICATION_FILTER_DROPDOWN, "All time");
		pageLoaderLogo();

		clickElement(CommunicationRepository.COMMUNICATION_FILTER);
		clickElement(CommunicationRepository.ALL_COMMUNICATIONS);
		pageLoaderLogo();

		String communicationName = BaseTest.getData().CommunicationName;
		searchCommunication("communicationlisting", communicationName);

		String listExpansionLocator = CommunicationRepository.LIST_EXPANSION.replace("{COMMUNICATION_NAME}", communicationName);
		clickElement(listExpansionLocator);

		explicitwaitforclick(autolocator(CommunicationRepository.CommunicationListing_PreviewIcon), 5);
		clickElement(CommunicationRepository.CommunicationListing_PreviewIcon);
		threadSleep(ObjectRepository.wait2sec);

		if (isDisplayed(CommunicationRepository.COMMUNICATION_PREVIEW))
		{
			BaseTest.getTest().info("Communication Preview is displayed and it is verified");
			BaseTest.takeScreenshot();
		}

		clickElement(CommunicationRepository.CommunicationListing_PreviewIcon);
		clickElement(CommunicationRepository.CommunicationListing_CSRanalyticsicon);
		pageLoaderLogo();
		isDisplayed(CommunicationRepository.ANALYTICS_HEADER);

		if (uiPageEqualswithInputValue(getStrText(CommunicationRepository.ANALYTICS_HEADER), communicationName))
		{
			BaseTest.getTest().info("Analytics page is displayed and it is verified");
			BaseTest.takeScreenshot();
		}

		clickCommunicationListpagefromMenu();
		clickElement(CommunicationRepository.COMMUNICATION_DATE_FILTER);
		selectlistelements(CommunicationRepository.COMMUNICATION_FILTER_DROPDOWN, "All time");
		pageLoaderLogo();

		clickElement(CommunicationRepository.COMMUNICATION_FILTER);
		clickElement(CommunicationRepository.ALL_COMMUNICATIONS);
		pageLoaderLogo();

		searchCommunication("communicationlisting", communicationName);
		duplicatecomm();
		threadSleep(ObjectRepository.wait5sec);

		String duplicatedCommName = communicationName + "_copy1";
		searchCommunication("communicationlisting", duplicatedCommName);
	}
}
