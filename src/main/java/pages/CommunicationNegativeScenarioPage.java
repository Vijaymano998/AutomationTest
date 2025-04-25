package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;

import repository.CommunicationRepository;
import repository.DashboardRepository;
import repository.ObjectRepository;
import utility.BaseTest;
import utility.PageFactory;

public class CommunicationNegativeScenarioPage extends CommunicationCreatePage
{
	public String aaaa, Content, zip1, mobilepushtype;
	int splitSize, splitTotalCount, splitGroupACount, splitGroupBCount, splitGroupCCount, splitGroupDCount;
	int splitGroupAPercent, splitGroupBPercent, splitGroupCPercent, splitGroupDPercent;

	public CommunicationNegativeScenarioPage(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);

	}

	public CommunicationNegativeScenarioPage plannepage()
	{
		int startDate = 0;
		int endDate = 3;
		long start = System.currentTimeMillis();
		long totalTime = System.currentTimeMillis() - start;
		//////////////////////////////////////////////////////////////////////////////////////////////////////
		pw_clickElement(DashboardRepository.pw_homepage_communication_link);
		pw_clickElement(CommunicationRepository.pw_communicationpage_communicationcreate);
		pw_clickElement(CommunicationRepository.Pwcommunicationpage_singledimen_link);

		communicationName = BaseTest.getData().CommunicationName + addTimeToName();
		pw_enterValue(CommunicationRepository.pwcommunicationpage_communicationname_textbox, "test");
		pw_clickTab();
		String error = pw_getStrText(CommunicationRepository.pwcommunicationpage_communicationname_errormsg);
		pw_writeLog(error.contains("Communication name already exists"), "error validation is as expected : " + error, "error validation is not as expected : " + error);
		pw_enterValue(CommunicationRepository.pwcommunicationpage_communicationname_textbox, "communicationName");

		pw_clickElement(CommunicationRepository.pwcommunication_Testcommunication);

		pw_clickElement(CommunicationRepository.pwcommunicationpage_communicationtype_select);
		clickTab();
		boolean pw_selectAttributelements = pw_selectAttributelements(CommunicationRepository.pwcommunication_CommunicationType, "aria-label", "Select communication type");
		pw_writeLog(pw_selectAttributelements, "error validation is as expected : ", "error validation is not as expected : ");

		pw_selectlistelements(CommunicationRepository.pwcommunicationpage_communicationtype_listbox, BaseTest.getData().CommunicationType);
		///////////////
		pw_clickElement(CommunicationRepository.pwcommunicationpage_producttype_select);
		clickTab();
		boolean productAttributelements = pw_selectAttributelements(CommunicationRepository.pwcommunication_ProductType, "aria-label", "Select product type");
		pw_writeLog(productAttributelements, "error validation is as expected : ", "error validation is not as expected : ");
		pw_selectlistelements(CommunicationRepository.pwcommunicationpage_communicationtype_listbox, BaseTest.getData().ProductType);
		////////////
		pw_clickElement(CommunicationRepository.pwcommunicationpage_primarygoal_select);
		clickTab();
		boolean GoalAttributelements = pw_selectAttributelements(CommunicationRepository.pwcommunication_PrimaryGoal, "aria-label", "Select primary goal");
		pw_writeLog(GoalAttributelements, "error validation is as expected : ", "error validation is not as expected : ");
		pw_selectlistelements(CommunicationRepository.pwcommunicationpage_communicationtype_listbox, BaseTest.getData().PrimaryGoal);
		pw_enterValue(CommunicationRepository.pwcommunicationpage_goalpercentage_textbox, "12.6");
		clickTab();
		pw_clickElement(CommunicationRepository.pwcommunicationstartdate);
		clickTab();
		String startdateAttributelements = pw_getStrText(CommunicationRepository.pwcommunication_StartDate);
		pw_writeLog(startdateAttributelements.contentEquals("Select start date"), "error validation is as expected : ", "error validation is not as expected : ");

		pw_enterDate(startDate, "startdate");
		pw_enterDate(endDate, "enddate");
		pw_clickElement(CommunicationRepository.pwcommunicationpage_click_next);
		String Selectchannel = pw_getStrText(CommunicationRepository.pwcommunication_SelectChannel);
		pw_writeLog(Selectchannel.contains("Select atleast one channel"), "error validation is as expected : " + Selectchannel, "error validation is not as expected : " + Selectchannel);
		pw_clickElement(CommunicationRepository.pwcommunicationpage_channel_type1);
		pw_clickElement(CommunicationRepository.pwcommunication_DeliveryMethod_Save);

		return this;
	}

	public CommunicationNegativeScenarioPage AuthoringpageEmail()
	{
		int startDate = 0;
		int endDate = 3;
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		Map<String, String> splitA = new HashedMap();
		Map<String, String> splitB = new HashedMap();
		Map<String, String> splitC = new HashedMap();

		pw_clickElement(DashboardRepository.pw_homepage_communication_link);
		pw_clickElement(CommunicationRepository.pw_communicationpage_communicationcreate);
		pw_clickElement(CommunicationRepository.Pwcommunicationpage_singledimen_link);
		communicationName = BaseTest.getData().CommunicationName + addTimeToName();
		pw_enterValue(CommunicationRepository.pwcommunicationpage_communicationname_textbox, communicationName);
		pw_clickElement(CommunicationRepository.pwcommunication_TestCommunication);
		pw_clickElement(CommunicationRepository.pwcommunicationpage_communicationtype_select);
		pw_selectlistelements(CommunicationRepository.pwcommunicationpage_communicationtype_listbox, BaseTest.getData().CommunicationType);
		pw_clickElement(CommunicationRepository.pwcommunicationpage_producttype_select);
		pw_selectlistelements(CommunicationRepository.pwcommunicationpage_communicationtype_listbox, BaseTest.getData().ProductType);
		pw_clickElement(CommunicationRepository.pwcommunicationpage_primarygoal_select);
		pw_selectlistelements(CommunicationRepository.pwcommunicationpage_communicationtype_listbox, BaseTest.getData().PrimaryGoal);
		pw_enterValue(CommunicationRepository.pwcommunicationpage_goalpercentage_textbox, "12.6");
		pw_enterDate(startDate, "startdate");
		pw_enterDate(endDate, "enddate");
		pw_clickElement(CommunicationRepository.pwcommunicationpage_channel_type1);
		pw_clickElement(CommunicationRepository.pwcommunicationpage_click_next);

		pw_clickElement(CommunicationRepository.pwcommunicationpage_smarturl_yes);
		comm.threadSleep(ObjectRepository.wait5sec);
		pw_enterValue(CommunicationRepository.pwcommunicationpage_smarturl_web, BaseTest.getData().SmartLink);

		pw_clickElement(CommunicationRepository.pwcommunicationpage_smarturl_generatesmarturl);
		pw_clickElement(CommunicationRepository.pwcommunicationpage_smarturl_save);
		pw_clickElement(CommunicationRepository.pwcommunicationpage_select_emailcommunicationnext);

		String ignorechannel = pw_getStrText(CommunicationRepository.pwcommunicationpage_ignorechannel);
		pw_writeLog(ignorechannel.contains("Are you sure you want to ignore this channel"), "Error validation is as expected: " + ignorechannel, "Error validation is not as expected: " + ignorechannel);

		pw_clickElement(CommunicationRepository.pwcommunicationpage_cancelbutton);
		pw_clickElement(CommunicationRepository.pwcommunicationpage_sendername);
		pw_enterValue(CommunicationRepository.pwcommunicationpage_sendername, "");
		pw_clickTab();

		String Errorval2 = pw_getStrText(CommunicationRepository.pwcommunicationpage_emailerror);
		pw_writeLog(Errorval2.contains("Enter sender name"), "Error validation is as expected: " + Errorval2, "Error validation is not as expected: " + Errorval2);

		pw_enterValue(CommunicationRepository.pwcommunicationpage_sendername, "test");
		pw_enterValue(CommunicationRepository.pwcommunicationpage_senderemail, System.getProperty("moreThan1000Char") + "57@resul.team");
		pw_clickTab();

		String Errorval1 = pw_getStrText(CommunicationRepository.pwcommunicationpage_emailerror);
		pw_writeLog(Errorval1.contains("Please enter characters below 100 characters"), "Error validation is as expected: " + Errorval1, "Error validation is not as expected: " + Errorval1);

		pw_enterValue(CommunicationRepository.pwcommunicationpage_senderemail, "resuluser57@resul.team");
		pw_clickElement(CommunicationRepository.pwcommunicationpage_email_receip_click);
		pw_clickTab();

		String error2 = pw_getStrText(CommunicationRepository.pwcommunicationpage_select_audience);
		pw_writeLog(error2.contains("Select audience"), "Error validation is as expected: " + error2, "Error validation is not as expected: " + error2);

		pw_enterValue(CommunicationRepository.pwcommunicationpage_targetlist, BaseTest.getData().TargetListNew);
		pw_selectlistelements(CommunicationRepository.pwcommunicationpage_targetlist_selection, BaseTest.getData().TargetListNew);

		audienceList = pw_getStrText(CommunicationRepository.pwcommunicationpage_AudienceList);
		audienceCount = null;
		String[] audience = pw_getStrText(CommunicationRepository.pwcommunicationpage_audiencecount).split(":");
		audienceCount = audience[1].trim();

		List<String> objStringPersona = new ArrayList<>();
		objStringPersona.add(System.getProperty("Persona_3"));
		objStringPersona.add(System.getProperty("Persona_2"));

		wordCount = null;
		pw_enterValue(CommunicationRepository.pwcommunicationpage_select_emailsub, System.getProperty("moreThan1000Char"));

		String[] Count = pw_getStrText(CommunicationRepository.pwcommunicationpage_wordcount).split("/");
		wordCount = Count[0].trim();

		pw_writeLog(wordCount.contains("150"), " : " + wordCount, "Error validation is not as expected: " + wordCount);

		pw_enterValue(CommunicationRepository.pwcommunicationpage_select_emailsub, BaseTest.getData().EmailSubjectLine + communicationName);

		// pw_clickElement("Subject line analysis,pw,#rs_SplitABTab_spamassassign");
//		pw_clickElement(CommunicationRepository.pwcommunicationpage_tooltip);
//
//		String error3 = pw_getStrText(CommunicationRepository.pwcommunicationpage_helptext);
//		pw_writeLog(error3.contains("A sufficient number of email communications need to be executed for the activation of the subject line analysis feature."), "Help Text validation is as expected : " + error3,
//				"Help Text validation is not as expected : " + error3);

		pw_clickElement(CommunicationRepository.pwcommunicationpage_textemail);
		pw_enterValue(CommunicationRepository.pwcommunicationpage_inbox_firstline, System.getProperty("300char"));

		String inbox = pw_getTextBoxVal(CommunicationRepository.pwcommunicationpage_inbox_firstline, "value");
		int length = inbox.length();
		pw_writeLog(length == 150, "max length allowed by inbox first line is :" + length, "max length allowed is :" + length);

		List<Frame> pw_getAllFrames = pw_getAllFrames();
		Content = "Email text communication blast" + addTimeToName();

		FrameLocator frame = pw_switchToFrameByLocator(",pw,//iframe[@class='k-iframe']");

		frame.locator(pw_autolocator(CommunicationRepository.pwcommunicationpage_emailtextbox)).fill(Content);

		pw_clickElement(CommunicationRepository.pwcommunicationpage_textbox_persona);
		pw_selectlistelements(CommunicationRepository.pwnotification_webpush_selecttitletextpersonalizationlist, "[[EmailID]]");

		pw_clickElement(CommunicationRepository.pwcommunicationpage_textbox_smartlink);
		pw_clickElement(CommunicationRepository.pwcommunicationpage_smartlink1);

		pw_clickElement(CommunicationRepository.pwcommunicationpage_refresh);
		pw_clickElement(CommunicationRepository.pwcommunicationpage_okbutton);

		pw_clickElement(CommunicationRepository.pwcommunicationpage_select_emailcommunicationnext);

		String error4 = pw_getStrText(CommunicationRepository.pwcommunicationpage_error_validation);
		pw_writeLog(error4.contains("Select content type to proceed"), "error validation is as expected : " + error4, "error validation is not as expected : " + error4);

		pw_clickElement(CommunicationRepository.pwemail_clickimport);
		pw_enterValue(CommunicationRepository.pwcommunicationpage_import_url, " ");
		pw_clickTab();

		String error5 = pw_getStrText(CommunicationRepository.pwcommunicationpage_error_url);
		pw_writeLog(error5.contains("Enter a URL"), "error validation is as expected : " + error5, "error validation is not as expected : " + error5);

		pw_enterValue(CommunicationRepository.pwcommunicationpage_import_url, System.getProperty("300char"));

		boolean IsDisable = pw_IsDisable(CommunicationRepository.pwcommunicationpage_gobutton);
		pw_writeLog(!IsDisable, "Go Button is disabled as expected", "Go Button is not disabled as expected");

		zip1 = detectFilePath(BaseTest.curr_Dir + "/src\\main\\resources" + "\\Zip\\" + BaseTest.getData().ZipName + ".zip");
		pw_uploadFile(CommunicationRepository.pwemail_clickimportzip, zip1);

		pw_clickElement(CommunicationRepository.pwcommunicationpage_refresh);
		pw_clickElement(CommunicationRepository.pwcommunicationpage_okbutton);

		String splitAsub = "Split type: A, " + communicationName + BaseTest.getData().EmailSubjectLine;
		String splitBsub = "Split type: B, " + communicationName + BaseTest.getData().EmailSubjectLine;
		String splitAsubEdit = "Edit Split type: A, " + communicationName + BaseTest.getData().EmailSubjectLine;
		String splitBsubEdit = "Edit Split type: B, " + communicationName + BaseTest.getData().EmailSubjectLine;

		splitEmailON("AB");

		splitDetails("A", splitAsub, BaseTest.getData().ZipName);
		splitA.put("Subject", comm.emailSubjectline);
		splitA.put("SplitType", "A");
		enterSplitScheduleDate("A");

		splitDetails("B", splitBsub, BaseTest.getData().ZipName);
		splitB.put("Subject", comm.emailSubjectline);
		splitB.put("SplitType", "B");
		enterSplitScheduleDate("B");

		pw_clickElement(CommunicationRepository.pwcommunicationpage_email_settings);

		try
		{
			pw_clickElement(CommunicationRepository.pwcommunicationpage_auto_on);
			BaseTest.getTest().log(Status.INFO, "Auto schedule default ON, user selected Option OFF");
		} catch (Exception e)
		{
			BaseTest.getTest().log(Status.INFO, "Auto schedule default OFF, user selected Option OFF");
		}

		pw_clickElement(CommunicationRepository.pwcommunicationpage_content_tab);
		pw_enterValue(CommunicationRepository.pwSplitABScheduleModal_Duration, "1");
		pw_clickElement(CommunicationRepository.pwSplitABScheduleModal_Hour);
		pw_clickElement(CommunicationRepository.pwSplitABScheduleModal_Day);

		pw_clickElement(CommunicationRepository.pwSplitABAutoshduleSavebutton);

		return this;

	}

	public CommunicationNegativeScenarioPage splitEmailON(String splitType)
	{

		pw_clickElement(CommunicationRepository.pwcommunicationpage_EmailSplitON);

		for (int count = 2; count < splitType.length(); count++)
		{
			pw_clickElement(CommunicationRepository.pwcommunicationpage_Email_split_addBtn);
		}
		pw_clickElement(CommunicationRepository.pwcommunicationpage_EmailsplitABDownarrow);
		String splitTotalCounts = pw_getStrText(CommunicationRepository.pwSplitTotalCounts).replaceAll("[^A-Za-z0-9]", "");
		System.out.println(splitTotalCounts);

		if (!splitTotalCounts.isEmpty())
		{
			splitTotalCount = Integer.parseInt(splitTotalCounts);
		}

		for (int count = 0; count < splitType.length(); count++)
		{
			int li = count + 1;

			// Fetch split group count
			String splitGroupCount1 = pw_getStrText(CommunicationRepository.pwSplitGroupCount + "[" + li + "]").replaceAll("\\(.*?\\)", "");
			System.out.println(splitGroupCount1);

			int splitGroupCount = Integer.parseInt(splitGroupCount1);

			// Fetch split group percentage
			String splitGroupPercents = pw_getStrText(CommunicationRepository.pwSplitGroupPercents + "[" + li + "]");
			String splitGroupPercent2 = splitGroupPercents.substring(splitGroupPercents.indexOf("(") + 1, splitGroupPercents.indexOf(")")).replaceAll("[^A-Za-z0-9]", "");

			int splitGroupPercent = Integer.parseInt(splitGroupPercent2);

			switch (count)
			{
			case 0:
				splitGroupACount = splitGroupCount;
				splitGroupAPercent = splitGroupPercent;
				break;
			case 1:
				splitGroupBCount = splitGroupCount;
				splitGroupBPercent = splitGroupPercent;
				break;
			case 2:
				splitGroupCCount = splitGroupCount;
				splitGroupCPercent = splitGroupPercent;
				break;
			case 3:
				splitGroupDCount = splitGroupCount;
				splitGroupDPercent = splitGroupPercent;
				break;

			default:
				break;
			}
		}

		pw_clickElement(CommunicationRepository.pwcommunicationpage_EmailsplitABDrag_save);

		return this;

	}

	public CommunicationNegativeScenarioPage splitDetails(String selectedSplitCaps, String subject, String zip)
	{// Click on the selected Split
		pw_clickElement(CommunicationRepository.pwSplitSelection + selectedSplitCaps + "']");

		// Store personas
		List<String> objStringPersona = new ArrayList<>();
		objStringPersona.add(System.getProperty("Persona_3"));
		objStringPersona.add(System.getProperty("Persona_2"));

		// Enter Subject Line
		pw_enterValue(CommunicationRepository.pwSplitSubjectLineInput + selectedSplitCaps + ".subjectLine']", communicationName + addTimeToName());

		// Click Personalize Icon
		pw_clickElement(CommunicationRepository.pwcommunicationpage_emailsubject_personalize_icon);

		// Select persona from the list
		pw_selectlistelements(CommunicationRepository.pwSplitPersonaList, System.getProperty("Persona_3"));

		// Detect and upload zip file
		zip1 = detectFilePath(BaseTest.curr_Dir + "/src\\main\\resources" + "\\Zip\\" + BaseTest.getData().ZipName + ".zip");

		// Click import zip icon
		pw_clickElement(CommunicationRepository.pwemailImportZip);

		BaseTest.takeScreenshot();

		// Upload the zip file
		pw_uploadFile(CommunicationRepository.pwemail_clickimportzip, zip1);

		return this;
	}

	public CommunicationNegativeScenarioPage enterSplitScheduleDate(String splitType)
	{
		int startDate = 0;
		int endDate = 3;

		// Determine minute selection based on split type
		String min = splitType.equals("A") ? "2" : splitType.equals("B") ? "3" : splitType.equals("C") ? "4" : splitType.equals("D") ? "5" : "";

		// Set timezone
		emailtimezone();

		// Click on email schedule time
		pw_clickElement(CommunicationRepository.pwcommunicationpage_emailschedule_time);

		// Format and select the schedule date
		String scheduleformat = calendarSchedduleDate(startDate, "MMMM d, yyy");
		pw_clickElement(CommunicationRepository.pwEmailScheduleTime + scheduleformat + "')]//span");

		// Select schedule time hours
		pw_clickElement(CommunicationRepository.pwEmailScheduleHours);

		// Select schedule minutes based on split type
		pw_clickElement(CommunicationRepository.pwEmailScheduleMinutes + min + "]");

		// Set the schedule time
		pw_clickElement(CommunicationRepository.pwEmailScheduleSetTime);

		return this;
	}

	// Select Time zone
	public CommunicationNegativeScenarioPage emailtimezone()
	{

		pw_clickElement(CommunicationRepository.pwcommunicationpage_emailtimezoneicon);
		pw_clickElement(CommunicationRepository.pwcommunicationpage_emailschedule_emailtimezonelist);
		pw_selectlistelements(CommunicationRepository.pwcommunicationpage_communicationtype_listbox, BaseTest.getData().TimeZone);
		return this;
	}

	public void pw_enterDate(int val, String date)
	{
		if (date.equals("startdate"))
		{
			pw_clickElement(CommunicationRepository.pwcommunicationstartdate);
		} else
		{
			pw_clickElement(CommunicationRepository.pwcommunicationsendDate);
		}

		pw_clickElement(CommunicationRepository.pwcommunicationpage_calendaryear_click);
		pw_customRangeCalender(val, CommunicationRepository.pwcalenderyearslist, CommunicationRepository.pwcalenderstartdatetable);
	}

	public CommunicationNegativeScenarioPage Authoringpagemessage()
	{
		int startDate = 0;
		int endDate = 3;
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		Map<String, String> splitA = new HashedMap();
		Map<String, String> splitB = new HashedMap();
		Map<String, String> splitC = new HashedMap();
		pw_clickElement(DashboardRepository.pw_homepage_communication_link);
		pw_clickElement(CommunicationRepository.pw_communicationpage_communicationcreate);
		pw_clickElement(CommunicationRepository.Pwcommunicationpage_singledimen_link);
		communicationName = BaseTest.getData().CommunicationName + addTimeToName();
		pw_enterValue(CommunicationRepository.pwcommunicationpage_communicationname_textbox, communicationName);
		pw_clickElement(CommunicationRepository.pwcommunication_Testcommunication);
		pw_clickElement(CommunicationRepository.pwcommunicationpage_communicationtype_select);
		pw_selectlistelements(CommunicationRepository.pwcommunicationpage_communicationtype_listbox, BaseTest.getData().CommunicationType);
		pw_clickElement(CommunicationRepository.pwcommunicationpage_producttype_select);
		pw_selectlistelements(CommunicationRepository.pwcommunicationpage_communicationtype_listbox, BaseTest.getData().ProductType);
		pw_clickElement(CommunicationRepository.pwcommunicationpage_primarygoal_select);
		pw_selectlistelements(CommunicationRepository.pwcommunicationpage_communicationtype_listbox, BaseTest.getData().PrimaryGoal);
		pw_enterValue(CommunicationRepository.pwcommunicationpage_goalpercentage_textbox, "12.6");
		pw_enterDate(startDate, "startdate");
		pw_enterDate(endDate, "enddate");
		pw_clickElement(CommunicationRepository.pwcommunicationpage_channel_type2);
		pw_clickElement(CommunicationRepository.pwcommunicationpage_click_next);

		pw_clickElement(CommunicationRepository.pwcommunicationpage_smarturl_yes);
		pw_enterValue(CommunicationRepository.pwcommunicationpage_smarturl_web, BaseTest.getData().SmartLink);

		pw_clickElement(CommunicationRepository.pwcommunicationpage_smarturl_generatesmarturl);
		pw_clickElement(CommunicationRepository.pwcommunicationpage_smarturl_save);

		BaseTest.getTest().info(MarkupHelper.createLabel("SMS CHANNEL", ExtentColor.BLUE));
		pw_clickElement(CommunicationRepository.pwcommunicationsms_selectproviderid);
		clickTab();
		// Validate sender ID error
		String Errorval1 = pw_getTextBoxVal(CommunicationRepository.pwMessagingSenderId, "aria-label");
		pw_writeLog(Errorval1.contains("Select sender ID"), "Error validation is as expected: " + Errorval1, "Error validation is not as expected: " + Errorval1);

		// Select SMS Sender ID
		pw_selectlistelements(CommunicationRepository.pwCommunicationTypeListbox, System.getProperty("smsSenderId"));

		// Click Email Recipient
		pw_clickElement(CommunicationRepository.pwEmailReceiptClick);
		clickTab();

		// Validate audience selection error
		String Errorval2 = pw_getStrText(CommunicationRepository.pwErrorContainer);
		pw_writeLog(Errorval2.contains("Select audience"), "Error validation is as expected: " + Errorval2, "Error validation is not as expected: " + Errorval2);

		// Enter new target list
		pw_enterValue(",pw,//input[@aria-haspopup]", BaseTest.getData().TargetListNew);

		// Select old target list
		pw_selectlistelements(CommunicationRepository.pwCommunicationTypeListbox, BaseTest.getData().TargetListOld);

		// Take screenshot
		BaseTest.takeScreenshot();

		// Get audience count
		audienceList = pw_getStrText(CommunicationRepository.pwAudienceList);
		String[] audience = pw_getStrText(CommunicationRepository.pwAudienceCount).split(":");
		audienceCount = audience.length > 1 ? audience[1].trim() : null;

		// Validate language selection
		pw_clickElement(CommunicationRepository.pwLanguageDropdown);
		clickTab();
		String Errorval3 = pw_getTextBoxVal(CommunicationRepository.pwErrorContainer, "aria-label");
		pw_writeLog(Errorval3.contains("Select language"), "Error validation is as expected: " + Errorval3, "Error validation is not as expected: " + Errorval3);

		// Select language and enter SMS template ID
		pw_selectlistelements(CommunicationRepository.pwCommunicationTypeListbox, "English (UK)");
		pw_enterValue(CommunicationRepository.pwSmsTemplateId, "");
		clickTab();

		// Validate template ID error
		String Errorval4 = pw_getStrText(CommunicationRepository.pwErrorContainer);
		pw_writeLog(Errorval4.contains("Enter template ID"), "Error validation is as expected: " + Errorval4, "Error validation is not as expected: " + Errorval4);

		// Enter SMS template ID
		pw_enterValue(CommunicationRepository.pwSmsTemplateId, System.getProperty("smsTempId"));

		// Validate template ID max length
		pw_enterValue(CommunicationRepository.pwSmsTemplateId, System.getProperty("300char"));
		String inbox = pw_getTextBoxVal(CommunicationRepository.pwSmsTemplateId, "value");
		int length = inbox.length();
		pw_writeLog(length == 50, "Max length allowed by template ID is: " + length, "Max length allowed is: " + length);

		// Enter SMS content and validate
		String smsContent = System.getProperty("smsContent");
		pw_clickElement(CommunicationRepository.pwSmsSelectPersonalization);
		clickTab();
		String Errorval5 = pw_getStrText(CommunicationRepository.pwErrorContainer);
		pw_writeLog(Errorval5.contains("Enter template ID"), "Error validation is as expected: " + Errorval5, "Error validation is not as expected: " + Errorval5);

		// Enter SMS content
		pw_enterValue(CommunicationRepository.pwEnterSmsContent, smsContent);

		// Enter split schedule date
		enterSplitScheduleDate("A");

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Click on WhatsApp tab
		pw_clickElement(CommunicationRepository.pwCommunication_Whatsapp_Tab);

		// Validate WhatsApp tab switch alert message
		String[] alertMessage = pw_getStrText(CommunicationRepository.pwCommunication_Whatsapp_AlertMessage).split("\\.");
		pw_writeLog(alertMessage[0].equalsIgnoreCase("Switching tabs will discard the data in the current screen."), "Validation is as expected: " + alertMessage[0], "Validation is NOT as expected: " + alertMessage[0]);

		// Click OK button on WhatsApp tab switch alert
		pw_clickElement(CommunicationRepository.pwCommunication_Whatsapp_OKButton);

		// Validate WhatsApp sender name error
		pw_clickElement(CommunicationRepository.pwCommunication_Whatsapp_SenderDomain);
		clickTab();
		String Errorval6 = pw_getTextBoxVal(CommunicationRepository.pwCommunication_Error_SenderName, "aria-label");
		pw_writeLog(Errorval6.contains("Select sender name"), "Error validation is present as expected: " + Errorval6, "Error validation is NOT present as expected: " + Errorval6);

		// Select WhatsApp provider
		pw_selectlistelements(CommunicationRepository.pwCommunication_TypeListbox, "Gupshup");

		// Validate audience selection error
		pw_clickElement(CommunicationRepository.pwCommunication_Whatsapp_AudienceList);
		clickTab();
		String Errorval7 = pw_getStrText(CommunicationRepository.pwCommunication_Error_Audience);
		pw_writeLog(Errorval7.contains("Select audience"), "Error validation is as expected: " + Errorval7, "Error validation is NOT as expected: " + Errorval7);

		// Enter new target list
		pw_enterValue(",pw,//input[@aria-haspopup]", BaseTest.getData().TargetListNew);

		// Select old target list
		pw_selectlistelements(CommunicationRepository.pwCommunication_TypeListbox, "trgt12181735958");

		// Take screenshot
		BaseTest.takeScreenshot();

		// Get audience count
		audienceList = pw_getStrText(CommunicationRepository.pwCommunication_Whatsapp_AudienceList);
		String[] audienceWhatsapp = pw_getStrText(CommunicationRepository.pwCommunication_Whatsapp_AudienceCount).split(":");
		audienceCount = audienceWhatsapp.length > 1 ? audienceWhatsapp[1].trim() : null;
		BaseTest.getTest().log(Status.INFO, "The Audience count is: " + audienceCount);

		// Validate template language selection
		pw_clickElement(CommunicationRepository.pwCommunication_Whatsapp_LanguageDropdown);
		clickTab();
		String Errorval8 = pw_getStrText(CommunicationRepository.pwCommunication_Error_Language);
		pw_writeLog(Errorval8.contains("Select template language"), "Error validation is as expected: " + Errorval8, "Error validation is NOT as expected: " + Errorval8);

		// Select template language
		pw_selectlistelements(CommunicationRepository.pwCommunication_TypeListbox, "en");

		// Validate template name selection
		pw_clickElement(CommunicationRepository.pwCommunication_Whatsapp_TemplateName);
		String Errorval10 = pw_getTextBoxVal(CommunicationRepository.pwCommunication_Error_TemplateName, "aria-label");
		pw_writeLog(Errorval10.contains("Select template name"), "Error validation is as expected: " + Errorval10, "Error validation is NOT as expected: " + Errorval10);

		// Select WhatsApp template name
		pw_selectlistelements(CommunicationRepository.pwCommunication_TypeListbox, WhatsAppTemplateName);
		BaseTest.takeScreenshot();

		// Validate WhatsApp message field
		String template = pw_getStrText(CommunicationRepository.pwCommunication_Whatsapp_ContentField);
		clearField(CommunicationRepository.pwCommunication_Whatsapp_ContentField);
		clickTab();
		String Errorval9 = pw_getStrText(CommunicationRepository.pwCommunication_Error_Message);
		pw_writeLog(Errorval9.contains("Enter message"), "Error validation is present as expected: " + Errorval9, "Error validation is NOT present as expected: " + Errorval9);

		// Validate character limit for WhatsApp message
		pw_enterValue(CommunicationRepository.pwCommunication_Whatsapp_ContentField, System.getProperty("moreThan1000Char"));
		int charLength = pw_getStrText(CommunicationRepository.pwCommunication_Whatsapp_ContentField).length();
		int charSubtotal = Integer.parseInt(pw_getStrText(CommunicationRepository.pwCommunication_Whatsapp_CharCounter).split("/ ")[0]);
		pw_writeLog(charLength == 1000 && charLength == charSubtotal, "Character limit is as expected: " + charSubtotal, "Character limit is above limit: " + charSubtotal);

		// Final WhatsApp template selection
		pw_clickElement(CommunicationRepository.pwCommunication_Whatsapp_TemplateName);
		pw_selectlistelements(CommunicationRepository.pwCommunication_TypeListbox, WhatsAppTemplateName);

		emailtimezone();
		pw_clickElement(CommunicationRepository.pwcommunicationpage_emailschedule_time);
		pw_clickElement(CommunicationRepository.pwcommunicationpage_select_emailcommunicationnext);

		String Errorval11 = pw_getStrText("Language error,pw,//p[.='The communication is not scheduled. Do you want to continue?']");
		pw_writeLog(Errorval11.contains("The communication is not scheduled. Do you want to continue?"), "error validation is present as expected : " + Errorval11, "error validation is not present as expected : " + Errorval11);
		pw_clickElement(",pw,//div[@class='rsmdc-footer w-100 modal-footer']//button[.='Save']");

		String errorVal11 = pw_getStrText(CommunicationRepository.pwCommunication_Error_Message);
		pw_writeLog(errorVal11.contains("The communication is not scheduled. Do you want to continue?"), "Error validation is present as expected: " + errorVal11, "Error validation is NOT present as expected: " + errorVal11);

		// Click Save button
		pw_clickElement(CommunicationRepository.pwCommunication_Save_Button);

		// Select schedule date
		pw_clickElement(CommunicationRepository.pwCommunication_Schedule_Time);

		// Select time (Hardcoded values)
		pw_clickElement(CommunicationRepository.pwCommunication_Schedule_Hours); // Select 10 AM
		pw_clickElement(CommunicationRepository.pwCommunication_Schedule_Minutes); // Select 2nd minute option

		pw_clickElement(CommunicationRepository.pwcommunicationpage_emailschedule_calendar_Timeset);
		return this;
	}

	public CommunicationNegativeScenarioPage AuthoringpageNotification()
	{
		int startDate = 0;
		int endDate = 3;
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		Map<String, String> splitA = new HashedMap();
		Map<String, String> splitB = new HashedMap();
		Map<String, String> splitC = new HashedMap();
		pw_clickElement(DashboardRepository.pw_homepage_communication_link);
		pw_clickElement(CommunicationRepository.pw_communicationpage_communicationcreate);
		pw_clickElement(CommunicationRepository.Pwcommunicationpage_singledimen_link);
		communicationName = BaseTest.getData().CommunicationName + addTimeToName();
		pw_enterValue(CommunicationRepository.pwcommunicationpage_communicationname_textbox, communicationName);
		pw_clickElement(CommunicationRepository.pwcommunication_Testcommunication);
		pw_clickElement(CommunicationRepository.pwcommunicationpage_communicationtype_select);
		pw_selectlistelements(CommunicationRepository.pwcommunicationpage_communicationtype_listbox, BaseTest.getData().CommunicationType);
		pw_clickElement(CommunicationRepository.pwcommunicationpage_producttype_select);
		pw_selectlistelements(CommunicationRepository.pwcommunicationpage_communicationtype_listbox, BaseTest.getData().ProductType);
		pw_clickElement(CommunicationRepository.pwcommunicationpage_primarygoal_select);
		pw_selectlistelements(CommunicationRepository.pwcommunicationpage_communicationtype_listbox, BaseTest.getData().PrimaryGoal);
		pw_enterValue(CommunicationRepository.pwcommunicationpage_goalpercentage_textbox, "12.6");
		pw_enterDate(startDate, "startdate");
		pw_enterDate(endDate, "enddate");
		pw_clickElement(CommunicationRepository.pwcommunicationpage_channel_type5);
		pw_clickElement(CommunicationRepository.pwcommunicationpage_click_next);

		pw_clickElement(CommunicationRepository.pwcommunicationpage_smarturl_yes);
		pw_enterValue(CommunicationRepository.pwcommunicationpage_smarturl_web, "https://www.google.co.in");
		page.waitForTimeout(5000); // waits for 5 seconds

		////// mobile push smart link
		pw_clickElement(CommunicationRepository.pwnotification_mobpush_addmobileapp);
		pw_clickElement(CommunicationRepository.pwnotificaiton_mobpush_selectmobileplatform);
		pw_selectlistelements(DashboardRepository.pwallpage_common_selectdropdownlist, BaseTest.getData().MobilePlatform);
		pw_clickElement(CommunicationRepository.pwnotification_mobpush_selectmobileapptype);
		pw_selectlistelements(DashboardRepository.pwallpage_common_selectdropdownlist, BaseTest.getData().MobileApp);

		pw_clickElement(CommunicationRepository.pwnotification_mobpush_selectdeferdeeplink);
		pw_selectlistelements(DashboardRepository.pwallpage_common_selectdropdownlist, "Enter new app screen");
		// Enter smart link value
		pw_enterValue(CommunicationRepository.pwCommunication_SmartLink_Input, "LauncherActivity");

		// Click Generate Smart URL
		pw_clickElement(CommunicationRepository.pwCommunication_Generate_SmartURL);

		// Click Save Smart URL
		pw_clickElement(CommunicationRepository.pwCommunication_Save_SmartURL);

		// Log Web Push Channel Page
		BaseTest.getTest().info(MarkupHelper.createLabel("COMMUNICATION WEBPUSH CHANNEL PAGE", ExtentColor.BLUE));

		// Click Web Push "Send To" dropdown
		pw_clickElement(CommunicationRepository.pwCommunication_WebPush_SendTo);
		clickTab();

		// Validate Web Push provider error message
		String errorVal1 = pw_getTextBoxVal(CommunicationRepository.pwCommunication_WebPush_Provider_Error, "aria-label");
		pw_writeLog(errorVal1.contains("Select domain name"), "Error validation is present as expected: " + errorVal1, "Error validation is NOT present as expected: " + errorVal1);

		// Select Web Push provider
		pw_selectlistelements(CommunicationRepository.pwCommunication_CommunicationType_Listbox, "https://conversion25.resulticks.net/");
		pw_clickElement(CommunicationRepository.pwcommunicationpage_email_receip_click);
		clickTab();

		// Validate Web Push audience error message
		String errorVal2 = pw_getStrText(CommunicationRepository.pwCommunication_WebPush_Audience_Error);
		pw_writeLog(errorVal2.contains("Select audience"), "Error validation is as expected: " + errorVal2, "Error validation is NOT as expected: " + errorVal2);

		// Enter audience
		pw_enterValue(CommunicationRepository.pwCommunication_Audience_Input, "All audience (Known & Identified)");
		pw_selectlistelements(CommunicationRepository.pwCommunication_CommunicationType_Listbox, BaseTest.getData().TargetListNew);

		// Get audience count
		audienceList = getStrText(CommunicationRepository.pwCommunication_Audience_List);
		audienceCount = null;
		String[] audienceWhatsapp = pw_getStrText(CommunicationRepository.pwCommunication_Audience_Count).split(":");
		audienceCount = audienceWhatsapp[1].trim();
		BaseTest.getTest().log(Status.INFO, "The Audience count is: " + audienceCount);

		// Select Web Push Delivery Type
		String webPushType = "Alert / Rich push";
		pw_clickElement(CommunicationRepository.pwCommunication_WebPush_DeliveryType);
		clickTab();

		// Validate Web Push Delivery Type error message
		String errorVal3 = pw_getTextBoxVal(CommunicationRepository.pwCommunication_WebPush_DeliveryType_Error, "aria-label");
		pw_writeLog(errorVal3.contains("Select delivery type"), "Error validation is present as expected: " + errorVal3, "Error validation is NOT present as expected: " + errorVal3);

		// Select delivery type from dropdown
		pw_selectlistelements(CommunicationRepository.pwCommunication_Common_Select_Dropdown, webPushType);
		BaseTest.takeScreenshot();

//		In-page overlay
		// Click Data Refresh
		pw_clickElement(CommunicationRepository.pwCommunication_Data_Refresh);

		// Click Yes to confirm refresh
		pw_clickElement(CommunicationRepository.pwCommunication_Confirm_Yes);

		// Select Web Push Delivery Type
		pw_clickElement(CommunicationRepository.pwCommunication_WebPush_DeliveryType);
		pw_selectlistelements(CommunicationRepository.pwCommunication_Common_Select_Dropdown, "In-page overlay");
		BaseTest.takeScreenshot();

		// Select Mobile Push Layout
		pw_clickElement(CommunicationRepository.pwCommunication_MobilePush_Layout);
		clickTab();

		// Validate Layout Position Error
		String errorVal4 = pw_getTextBoxVal(CommunicationRepository.pwCommunication_WebPush_Error_Container, "aria-label");
		pw_writeLog(errorVal4.contains("Select layout position"), "Error validation is present as expected: " + errorVal4, "Error validation is NOT present as expected: " + errorVal4);

		// Select Layout Options
		pw_selectlistelements(CommunicationRepository.pwCommunication_Common_Select_Dropdown, "FullScreen");
		pw_clickElement(CommunicationRepository.pwCommunication_MobilePush_Layout);
		pw_selectlistelements(CommunicationRepository.pwCommunication_Common_Select_Dropdown, "Modal");

		// Select Position
		pw_clickElement(CommunicationRepository.pwCommunication_Position_Dropdown);
		clickTab();

		// Validate Position Error
		String errorVal5 = pw_getTextBoxVal(CommunicationRepository.pwCommunication_WebPush_Error_Container, "aria-label");
		pw_writeLog(errorVal5.contains("Select position"), "Error validation is present as expected: " + errorVal5, "Error validation is NOT present as expected: " + errorVal5);

		pw_selectlistelements(CommunicationRepository.pwCommunication_Common_Select_Dropdown, "Center");

		// Select Web Push Content
		pw_clickElement(CommunicationRepository.pwCommunication_WebPush_Select_Content);

		// Enter Web Push Title
		String webTitleText = communicationName + ", ";
		pw_clickElement(CommunicationRepository.pwCommunication_WebPush_Title_Input);
		clickTab();

		// Validate Title Error
		String errorVal6 = pw_getStrText(CommunicationRepository.pwCommunication_WebPush_Title_Error);
		pw_writeLog(errorVal6.contains("Enter title text"), "Error validation is present as expected: " + errorVal6, "Error validation is NOT present as expected: " + errorVal6);

		// Check Title Character Limit
		pw_enterValue(CommunicationRepository.pwCommunication_WebPush_Title_Input, System.getProperty("moreThan1000Char"));
		String errorVal7 = pw_getTextBoxVal(CommunicationRepository.pwCommunication_WebPush_Title_Input, "value");
		pw_writeLog(errorVal7.length() == 60, "Max length allowed to input as expected: " + errorVal7, "Max length allowed to input is NOT as expected: " + errorVal7);

		// Enter Valid Title
		pw_enterValue(CommunicationRepository.pwCommunication_WebPush_Title_Input, webTitleText);

		// Enter Web Push Content
		pw_clickElement(CommunicationRepository.pwCommunication_WebPush_Content);
		pw_enterValue(CommunicationRepository.pwCommunication_WebPush_Content, System.getProperty("moreThan1000Char"));

		// Check Web Push Content Character Limit
		String errorVal8 = pw_getStrText(CommunicationRepository.pwCommunication_WebPush_Content);
		pw_writeLog(errorVal8.length() == 350, "Max length allowed to input as expected: " + errorVal8, "Max length allowed to input is NOT as expected: " + errorVal8);

		pw_enterValue(CommunicationRepository.pwnotification_webpush_webcontent, "");
		pw_clickElement(CommunicationRepository.pwnotification_webpush_webcontent);
		pw_clickTab();

		String Errorval9 = pw_getStrText(CommunicationRepository.pwCommunication_webpushprovider);
		pw_writeLog(Errorval9.contains("Enter body text"), "error validation is present as expected : " + Errorval9, "error validation is not present as expected : " + Errorval9);

		pw_enterValue(CommunicationRepository.pwnotification_webpush_webcontent, webTitleText);

		String url = System.getProperty("webMobilePushImageUrl");
		pw_clickElement(CommunicationRepository.pwnotification_webpush_imgcontenticon);
		pw_clickElement(CommunicationRepository.pwnotification_webpush_selectimgurl);
		pw_clickElement(CommunicationRepository.pwnotification_webpush_imgurlpopup);
		pw_clickTab();
		String Errorval10 = pw_getStrText(CommunicationRepository.pwCommunication_webpushprovider);
		pw_writeLog(Errorval10.contains("Enter image URL"), "error validation is present as expected : " + Errorval10, "error validation is not present as expected : " + Errorval10);

		pw_enterValue(CommunicationRepository.pwnotification_webpush_imgurlpopup, url);
		pw_clickElement(CommunicationRepository.pwnotification_webpush_imgurlsave);
		pw_clickElement(CommunicationRepository.pwCommunication_Hashtag_Input);
		pw_enterValue(CommunicationRepository.pwCommunication_Hashtag_Input, "test");
		page.keyboard().press("Enter");
		pw_enterValue(CommunicationRepository.pwCommunication_Hashtag_Input, "test01");
		page.keyboard().press("Enter");
		enterSplitScheduleDate("A");
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		pw_clickElement(CommunicationRepository.pwnotification_mobpush_TabSelect);
		String pw_getStrText[] = pw_getStrText(CommunicationRepository.pwcommunicationpage_modal_validation_message).split(".");
		pw_writeLog(pw_getStrText[0].equalsIgnoreCase("Switching tabs will discard the data in the current screen."), "Validation is present as expected: " + pw_getStrText[0], "Validation is not present as expected: " + pw_getStrText[0]);

		pw_clickElement(CommunicationRepository.pwcommunicationpage_whatsapp_tab_ok_button);

		pw_clickElement(CommunicationRepository.pwcommunicationpage_email_receip_click);
		pw_clickTab();

		String Errorval11 = pw_getStrText(CommunicationRepository.pwmobilepush_audience_error);
		pw_writeLog(Errorval11.contains("Select audience"), "Error validation is as expected: " + Errorval11, "Error validation is not as expected: " + Errorval11);

		pw_selectlistelements(DashboardRepository.pwallpage_common_selectdropdownlist, "All audience (Known & Identified)");

		pw_clickElement(CommunicationRepository.pwnotification_mobpush_pushtype);
		pw_clickTab();

		String Errorval12 = pw_getTextBoxVal(CommunicationRepository.pwnotification_mobpush_pushtype_error, "aria-label");
		pw_writeLog(Errorval12.contains("Select push type"), "Error validation is present as expected: " + Errorval12, "Error validation is not present as expected: " + Errorval12);

		mobilepushtype = "Alert / Rich push";
		pw_selectlistelements(DashboardRepository.pwallpage_common_selectdropdownlist, mobilepushtype);

		pw_clickElement(CommunicationRepository.pwnotification_mobpush_inboxClassification);
		pw_selectlistelements(DashboardRepository.pwallpage_common_selectdropdownlist, "Cards");

		pw_clickElement(CommunicationRepository.pwnotification_mobpush_layout);
		pw_clickTab();

		String Errorval13 = pw_getTextBoxVal(CommunicationRepository.pwnotification_mobpush_layout_error, "aria-label");
		pw_writeLog(Errorval13.contains("Select layout position"), "Error validation is present as expected: " + Errorval13, "Error validation is not present as expected: " + Errorval13);

		pw_selectlistelements(DashboardRepository.pwallpage_common_selectdropdownlist, "Carousel");
		pw_clickElement(CommunicationRepository.pwnotification_mobpush_layoutposition);
		pw_selectlistelements(CommunicationRepository.pwnotification_mobpush_layoutpositionlist, "Top");
		pw_clickElement(CommunicationRepository.pwnotification_mobpush_layout);
		pw_selectlistelements(DashboardRepository.pwallpage_common_selectdropdownlist, "Default");

		startDate = 0;
		pw_clickElement(CommunicationRepository.pwnotification_webpush_selectcontent);

		pw_enterValue(CommunicationRepository.pwnotification_mobpush_entertitletext, System.getProperty("moreThan1000Char"));

		String Errorval14 = pw_getTextBoxVal(CommunicationRepository.pwnotification_webpush_entertitle, "value");
		pw_writeLog(Errorval14.length() == 60, "Max length allowed to input as expected: " + Errorval14, "Max length allowed to input is not as expected: " + Errorval14);

		String titleContent = communicationName;
		pw_enterValue(CommunicationRepository.pwnotification_mobpush_entertitletext, titleContent);

		String content = "Hey " + communicationName;
		FrameLocator frame = pw_switchToFrameByLocator(CommunicationRepository.pwmobilepush_iframe);

		frame.locator(pw_autolocator(CommunicationRepository.pwmobilepush_bodytext)).fill(content);

		pw_enterValue(CommunicationRepository.pwmobilepush_bodytext, System.getProperty("moreThan1000Char"));

		String Errorval15 = pw_getStrText(CommunicationRepository.pwmobilepush_bodytext);
		pw_writeLog(Errorval15.length() == 350, "Max length allowed to input as expected: " + Errorval15, "Max length allowed to input is not as expected: " + Errorval15);

		enterSplitScheduleDate("A");
		pw_clickElement(CommunicationRepository.pwnotification_next_button);

		BaseTest.getTest().info(MarkupHelper.createLabel("WEB ANALYTICS PAGE", ExtentColor.BLUE));

		pw_clickElement(CommunicationRepository.pwnotification_webpush_analyticsplatform);
		pw_selectlistelements(CommunicationRepository.pwcommunicationpage_communicationtype_listbox, "Resulticks Mobile App Analytics");

		pw_clickElement(CommunicationRepository.pwnotification_next_button);
		pw_clickElement(CommunicationRepository.pwnotification_next_button);

		return this;

	}

}
