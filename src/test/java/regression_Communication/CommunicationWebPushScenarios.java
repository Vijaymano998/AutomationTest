package regression_Communication;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.AudiencePage_Dynamiclist;
import pages.CommunicationEmailChannelPage;
import pages.CommunicationMobilePushPage;
import pages.CommunicationNotificationPage;
import pages.CommunicationSMSChannelPage;
import pages.PreCommunicationAnalyticsPage;
import pages.SyncHistoryPage;
import repository.CommunicationRepository;
import repository.ObjectRepository;
import utility.BaseTest;
import utility.PageBase;

public class CommunicationWebPushScenarios extends BaseTest
{
	@Test(testName = "", description = "Event trigger communication Daily - Webpush plan Sceanrios")
	public void TriggerCommwebpushDaily()
	{

		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();

		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		SyncHistoryPage sync = getPageFactory().syncHistoryPage();
		sync.login(sync.dPropertyLoginUserName(), sync.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		comm.ETdynamicList = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.firstDynamicApprover(PageBase.audience_approver1).clickCreateAndSaveTrigger(comm.ETdynamicList);
		dynamic.logout();
		String pwind1 = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		dynamic.webURLlaunch();
		dynamic.teamWebmailLogin(System.getProperty("Target_Dynamic_approver1_webmail_Uname"), System.getProperty("Target_Dynamic_approver1_webmail_pswrd"));
		String rfalink = dynamic.getDynamicListRFAApprovalMailLink(comm.ETdynamicList);
		dynamic.teamWebmailLogout();
		dynamic.openLoginPage().target_Dynamic_approver1_login();
		dynamic.selectbusinessunit();
		BaseTest.getWebDriver().get(rfalink);
		dynamic.clickTargetDynamicRFAApproveBtn();
		dynamic.logout();

		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.eventTriggComm(startDate, endDate);
		comm.channelType3().analyticOption2();
		comm.clickFrequency("Daily");
		comm.getTimeForDaily("1");
		comm.clickNext();
		BaseTest.takeScreenshot();

	}

	@Test(description = "Webpush communication without image")
	public void webpushCommunicationWithoutImage()
	{
		CommunicationNotificationPage web = getPageFactory().communication_Notification();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();

		web.communicationName = BaseTest.getData().CommunicationName;
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		// comm.login("resuluser66@resul.team", "Resul@123");
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType3().analyticOption2();
		comm.clickNext().createSmarturl();
		web.selectUrltosendWebPush();
		comm.enternewRecipient();
		web.selectWebPushDeliveryType();
		web.webpushTextTitle();
		web.commWebPushpersona();
		web.javaScriptScrollDownToSomeExtend();
		web.clickElement(CommunicationRepository.webpush_interactivitydropdown);
		web.clickElement(CommunicationRepository.webpush_interactivitybutton);
		web.selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Dismiss");
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		comm.clickNextemail();
		comm.pageLoaderLogo();
		comm.reschedule(startDate);
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Scheduled");
	}

	@Test(testName = "", description = "Advance analytics verify for  Webpush")
	public void advanceAnalyticsWebpush()
	{
		CommunicationNotificationPage web = getPageFactory().communication_Notification();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();

		web.communicationName = BaseTest.getData().CommunicationName;
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType3().analyticOption2();
		comm.clickNext().createSmarturl();
		web.selectUrltosendWebPush();
		comm.enternewRecipient();
		web.selectWebPushDeliveryType();
		web.webpushTextTitle();
		web.commWebPushpersona();

		web.clickElement(CommunicationRepository.webpush_interactivitydropdown);
		web.clickElement(CommunicationRepository.webpush_interactivitybutton);
		web.selectScrollToListelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Dismiss");
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		comm.clickNextemail();
		comm.pageLoaderLogo();
		if (comm.isElementPresent(CommunicationRepository.communicationpage_validation_time))
		{
			comm.enterEmailScheduleTime(startDate);
			comm.clickNextemail();
			comm.pageLoaderLogo();
		}
		precomm.webAnalyticsDetails();
		precomm.validateAdvanceAnalytics();
	}

	@Test(testName = "", description = "Event trigger communication Daily - Webpush")
	public void webpushDailyBlastregression() throws InterruptedException
	{

		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		CommunicationNotificationPage web = getPageFactory().communication_Notification();
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		SyncHistoryPage sync = getPageFactory().syncHistoryPage();
		sync.login(sync.dPropertyLoginUserName(), sync.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		comm.ETdynamicList = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.firstDynamicApprover(PageBase.audience_approver1).clickCreateAndSaveTrigger(comm.ETdynamicList);
		dynamic.logout();
		String pwind1 = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		dynamic.webURLlaunch();
		dynamic.teamWebmailLogin(System.getProperty("Target_Dynamic_approver1_webmail_Uname"), System.getProperty("Target_Dynamic_approver1_webmail_pswrd"));
		String rfalink = dynamic.getDynamicListRFAApprovalMailLink(comm.ETdynamicList);
		dynamic.teamWebmailLogout();
		dynamic.openLoginPage().target_Dynamic_approver1_login();
		dynamic.selectbusinessunit();
		BaseTest.getWebDriver().get(rfalink);
		dynamic.clickTargetDynamicRFAApproveBtn();
		dynamic.logout();

		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.eventTriggComm(startDate, endDate);
		comm.channelType3().analyticOption2();
		comm.clickFrequency("Daily");
		comm.getTimeForDaily("1");
		comm.clickNext();
		BaseTest.takeScreenshot();
		comm.createSmarturl();
		web.selectUrltosendWebPush();
		web.selectWebPushDeliveryType();
		web.webpushTextTitle();
		web.commWebPushpersona();
		web.wpBrowseImage();
		// web.wpImageURL();
		web.javaScriptScrollDownToSomeExtend();
		web.clickElement(CommunicationRepository.webpush_interactivitydropdown);
		web.clickElement(CommunicationRepository.webpush_interactivitybutton);
		web.selectScrollToListelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Dismiss");
		comm.javaScriptScrollDown();
		comm.clickNextemail();
		comm.pageLoaderLogo();
		if (comm.isElementPresent("Validation message,xpath,//div[@class='validation-message'][contains(.,'later than 15')]"))
		{
			comm.enterEmailScheduleTime(startDate);
			comm.clickNextemail();
			comm.pageLoaderLogo();
		}
		precomm.webAnalyticsDetails();
		precomm.preCommunicationPage();
		comm.communicationlistingPageStatusCompare("In progress");
		comm.gallerycommunicationtype("Web notificatio");
		comm.gallerycommunicationSearch(comm.communicationName, "edit");
		comm.gallerycommunicationtype("Web notificatio");
		comm.gallerycommunicationSearch(comm.communicationName, "duplicate");

	}

	@Test(description = "Webpush Test communication with Rich psuh ")
	public void webpushTestCommunicationAlertRichpsuh()
	{
		CommunicationNotificationPage web = getPageFactory().communication_Notification();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();

		web.communicationName = BaseTest.getData().CommunicationName;
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType3().analyticOption2();
		comm.clickNext().createSmarturl();
		web.selectUrltosendWebPush();
		comm.enternewRecipient();
		web.selectWebPushDeliveryType();
		web.webpushTextTitle();
		web.commWebPushpersona();
		web.wpBrowseImage();
		// web.wpImageURL();
		web.javaScriptScrollDownToSomeExtend();
		web.clickElement(CommunicationRepository.webpush_interactivitydropdown);
		web.clickElement(CommunicationRepository.webpush_interactivitybutton);
		web.selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Dismiss");
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		comm.clickNextemail();
		comm.pageLoaderLogo();
		if (comm.isElementPresent(CommunicationRepository.communicationpage_validation_time))
		{
			comm.enterEmailScheduleTime(startDate);
			comm.clickNextemail();
			comm.pageLoaderLogo();
		}
		precomm.webAnalyticsDetails();
		precomm.preCommunicationPage();
		comm.communicationlistingPageStatusCompare("In progress");
	}

	@Test(description = "Webpush Test communication with image url")
	public void webpushTestCommunicationWithImage()
	{
		CommunicationNotificationPage web = getPageFactory().communication_Notification();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();

		web.communicationName = BaseTest.getData().CommunicationName;
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType3().analyticOption2();
		comm.clickNext().createSmarturl();
		web.selectUrltosendWebPush();
		comm.enternewRecipient();
		web.selectWebPushDeliveryType();
		web.webpushTextTitle();
		web.commWebPushpersona();
		web.wpImageURL();
		web.javaScriptScrollDownToSomeExtend();
		web.clickElement(CommunicationRepository.webpush_interactivitydropdown);
		web.clickElement(CommunicationRepository.webpush_interactivitybutton);
		web.selectScrollToListelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Dismiss");
		comm.javaScriptScrollDown();
		web.webpushSendTestPreview(System.getProperty("webMobilePushTestCommunication"));
		comm.javaScriptScrollDown();
		comm.clickSaveEmail();
		comm.explicitwaitforclick(comm.autolocator(CommunicationRepository.communicationpage_webpush_confirmation), 20);
		comm.threadSleep(ObjectRepository.wait5sec);
		getWebDriver().findElement(By.xpath(CommunicationRepository.communicationpage_webpush_savebutton)).click();
		comm.pageLoaderLogo();
		comm.communicationlistingPageStatusCompare("Draft");
	}

	@Test(description = "Webpush Test communication without image")
	public void webpushTestCommunicationWithoutImage()
	{
		CommunicationNotificationPage web = getPageFactory().communication_Notification();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();

		web.communicationName = BaseTest.getData().CommunicationName;
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType3().analyticOption2();
		comm.clickNext().createSmarturl();
		web.selectUrltosendWebPush();
		comm.enternewRecipient();
		web.selectWebPushDeliveryType();
		web.webpushTextTitle();
		web.commWebPushpersona();
		web.javaScriptScrollDownToSomeExtend();
		web.clickElement(CommunicationRepository.webpush_interactivitydropdown);
		web.clickElement(CommunicationRepository.webpush_interactivitybutton);
		web.selectScrollToListelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Dismiss");
		web.webpushSendTestPreview(System.getProperty("webMobilePushTestCommunication"));
		comm.javaScriptScrollDown();
		comm.clickSaveEmail();
		comm.explicitwaitforclick(comm.autolocator(CommunicationRepository.communicationpage_webpush_confirmation), 20);
		comm.threadSleep(ObjectRepository.wait5sec);
		getWebDriver().findElement(By.xpath(CommunicationRepository.communicationpage_webpush_savebutton)).click();
		comm.pageLoaderLogo();
		comm.communicationlistingPageStatusCompare("Draft");

	}

	@Test(description = "Webpush communication with image url")
	public void webpushCommunicationWithImage()
	{
		CommunicationNotificationPage web = getPageFactory().communication_Notification();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();

		web.communicationName = BaseTest.getData().CommunicationName;
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType3().analyticOption2();
		comm.clickNext().createSmarturl();
		web.selectUrltosendWebPush();
		comm.enternewRecipient();
		web.selectWebPushDeliveryType();
		web.webpushTextTitle();
		web.commWebPushpersona();
		web.wpImageURL();
		web.javaScriptScrollDownToSomeExtend();
		web.clickElement(CommunicationRepository.webpush_interactivitydropdown);
		web.clickElement(CommunicationRepository.webpush_interactivitybutton);
		web.selectScrollToListelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Dismiss");
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		comm.clickNextemail();
		comm.pageLoaderLogo();
		if (comm.isElementPresent(CommunicationRepository.communicationpage_validation_time))
		{
			comm.enterEmailScheduleTime(startDate);
			comm.clickNextemail();
			comm.pageLoaderLogo();
		}
		precomm.webAnalyticsDetails();
		precomm.preCommunicationPage();
		comm.communicationlistingPageStatusCompare("In progress");
	}

	@Test(description = "Webpush communication Regression")
	public void webpushCommunicationRegression() throws AWTException
	{
		CommunicationNotificationPage web = getPageFactory().communication_Notification();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationMobilePushPage webM = getPageFactory().communicationMobilePushPage();

		web.communicationName = BaseTest.getData().CommunicationName;
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType3().analyticOption2();
		comm.singleDimensionregression("ROI");

		comm.clickNext().createSmarturl();
		web.selectUrltosendWebPush();

		comm.enternewRecipient();
		web.selectWebPushDeliveryType();
		web.webpushTextTitle();
		web.commWebPushpersona();
		web.wpImageURL();
		web.javascriptdoublescrolldown();
		web.clickElement(CommunicationRepository.webpush_interactivitydropdown);
		web.clickElement(CommunicationRepository.webpush_interactivitybutton);
		web.selectScrollToListelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Dismiss");
		comm.javaScriptScrollDown();
//		webM.mobilepushmakealert();
//		webM.mobilepushSetInteractivity();
//		webM.mobilepushSetExpiry();
//		webM.mobilepushAlert();
//		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		comm.clickNextemail();
		comm.pageLoaderLogo();
		if (comm.isElementPresent(CommunicationRepository.communicationpage_validation_time))
		{
			comm.enterEmailScheduleTime(startDate);
			comm.clickNextemail();
			comm.pageLoaderLogo();
		}
		precomm.webAnalyticsDetails();
		// precomm.frequencycap().contentbox();
		precomm.preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Scheduled");
	}

	@Test(description = "Webpush Test communication with import url test preview")
	public void webpushTestCommunicationWithImportZip()
	{
		CommunicationNotificationPage web = getPageFactory().communication_Notification();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		web.communicationName = BaseTest.getData().CommunicationName;

		int startDate = 0;
		int endDate = 3;

		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());

		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType3().analyticOption2();
		comm.clickNext().createSmarturl();
		web.selectUrltosendWebPush();
		comm.enternewRecipient();
		web.selectWebPushDeliveryType();
		comm.clickImport();
		comm.selectZipUsingKeys();
		web.webpushImportUrlScrollToInteractivityButton();
		web.clickElement(CommunicationRepository.webpush_interactivitydropdown);
		web.clickElement(CommunicationRepository.webpush_interactivitybutton);
		web.selectScrollToListelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Dismiss");
		comm.javaScriptScrollDown();
		web.webpushSendTestPreview(System.getProperty("webMobilePushTestCommunication"));
		comm.javaScriptScrollDown();
		comm.clickSaveEmail();
		comm.explicitwaitforclick(comm.autolocator("Confirm preview,xpath,//div[contains(@class,'modal-content')]"), 20);
		comm.threadSleep(ObjectRepository.wait5sec);
		getWebDriver().findElement(By.xpath("(//button[.='Save'])[2]")).click();
		comm.pageLoaderLogo();
		comm.communicationlistingPageStatusCompare("Draft");
	}

	@Test(testName = "", description = "Webpush Test communication with import url schedule")
	public void webpushTestCommunicationScheduleWithImportZip()
	{
		CommunicationNotificationPage web = getPageFactory().communication_Notification();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		web.communicationName = BaseTest.getData().CommunicationName;

		int startDate = 0;
		int endDate = 3;

		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());

		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType3().analyticOption2();
		comm.clickNext().createSmarturl();
		web.selectUrltosendWebPush();
		comm.enternewRecipient();
		web.selectWebPushDeliveryType();
		comm.clickImport();
		// comm.selectZip("Mobile");
		comm.selectZipUsingKeys();
		web.webpushImportUrlScrollToInteractivityButton();
		web.clickElement(CommunicationRepository.webpush_interactivitydropdown);
		web.clickElement(CommunicationRepository.webpush_interactivitybutton);
		web.selectScrollToListelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Dismiss");
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		comm.clickNextemail();
		comm.pageLoaderLogo();
		if (comm.isElementPresent("Validation message,xpath,//div[@class='validation-message'][contains(.,'later than 15')]"))
		{
			comm.enterEmailScheduleTime(startDate);
			comm.clickNextemail();
			comm.pageLoaderLogo();
		}
		precomm.webAnalyticsDetails();
		precomm.preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Scheduled");
	}

	@Test(description = "Webpush Test communication with Rich psuh Test Notification ")
	public void webpushTestCommunicationAlertRichpsuhTest()
	{
		CommunicationNotificationPage web = getPageFactory().communication_Notification();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();

		web.communicationName = BaseTest.getData().CommunicationName;
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType3().analyticOption2();
		comm.clickNext().createSmarturl();
		web.selectUrltosendWebPush();
		comm.enternewRecipient();
		web.selectWebPushDeliveryType();
		web.webpushTextTitle();
		web.commWebPushpersona();
		web.wpBrowseImage();
		// web.wpImageURL();
		web.javaScriptScrollDownToSomeExtend();
		web.clickElement(CommunicationRepository.webpush_interactivitydropdown);
		web.clickElement(CommunicationRepository.webpush_interactivitybutton);
		web.selectScrollToListelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Dismiss");
		comm.javaScriptScrollDown();
		web.webpushSendTestPreview(System.getProperty("webMobilePushTestCommunication"));
		comm.javaScriptScrollDown();
		comm.clickSaveEmail();
		comm.explicitwaitforclick(comm.autolocator(CommunicationRepository.communicationpage_webpush_confirmation), 20);
		comm.threadSleep(ObjectRepository.wait5sec);
		getWebDriver().findElement(By.xpath(CommunicationRepository.communicationpage_webpush_savebutton)).click();
		comm.pageLoaderLogo();
		comm.communicationlistingPageStatusCompare("Draft");
	}

	@Test(testName = "", description = "Event trigger communication Immediate - Webpush")
	public void TriggerCommwebpushImmediate()
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();

		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		SyncHistoryPage sync = getPageFactory().syncHistoryPage();
		sync.login(sync.dPropertyLoginUserName(), sync.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		comm.ETdynamicList = dynamic.addNewDynamicListNameandTriggerType();
		try
		{
			dynamic.triggerFormRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dynamic.firstDynamicApprover(PageBase.audience_approver1).clickCreateAndSaveTrigger(comm.ETdynamicList);
		dynamic.logout();
		String pwind1 = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		dynamic.webURLlaunch();
		dynamic.teamWebmailLogin(System.getProperty("Target_Dynamic_approver1_webmail_Uname"), System.getProperty("Target_Dynamic_approver1_webmail_pswrd"));
		String rfalink = dynamic.getDynamicListRFAApprovalMailLink(comm.ETdynamicList);
		dynamic.teamWebmailLogout();
		dynamic.openLoginPage().target_Dynamic_approver1_login();
		dynamic.selectbusinessunit();
		BaseTest.getWebDriver().get(rfalink);
		dynamic.clickTargetDynamicRFAApproveBtn();
		dynamic.logout();

		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.eventTriggComm(startDate, endDate);
		comm.channelType3().analyticOption2();
		comm.clickFrequency("Immediate");
		comm.clickNext();
		BaseTest.takeScreenshot();
	}

}
