package regression_Communication;

import java.awt.AWTException;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
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

public class CommunicationMobilePushScenario extends BaseTest
{
	@Test(description = "Create Mobile push communication Image  ")
	public void MobileinAppmessage() throws AWTException
	{
		CommunicationMobilePushPage web = getPageFactory().communicationMobilePushPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();

		int startDate = 0;
		int endDate = 3;

		web.login(web.dPropertyLoginUserName(), web.dPropertyLoginPswrd());

		web.selectbusinessunit();
		web.clickCreateCommunicationfromMenu();
		web.singleDimensionComm(startDate, endDate);

		web.channelType3().analyticOption2().analyticOption5().clickNext();

		web.mobilepushSmartLinkCreate();
		web.mobilepushAudienceSelect();
		web.mobilePushTypeAndLayout("In-app messaging");
		web.mobilepushcontent("Create");

		web.mobilepushTitleAndContentEnter();
		web.mobilepushSetInteractivity();
		web.mobilepushSetExpiry();
		web.mobilepushAlert();
		comm.emailtimezone();

		comm.enterEmailScheduleTime(startDate);
		comm.clickNextemail();
		comm.pageLoaderLogo();
		PageBase.threadSleep(ObjectRepository.wait5sec);
		comm.javaScriptScrollDown();
		comm.clickElement(CommunicationRepository.authoringpage_webanalytics);
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails().mobileAppAnalyticsDetails().preCommunicationPage();
		web.communicationlistingPageStatusCompare("Scheduled");
	}

	@Test(description = "Create Mobile push communication with image url test preview")
	public void mobileRichPushImageUrlPreview() throws AWTException
	{
		CommunicationMobilePushPage web = getPageFactory().communicationMobilePushPage();
		int startDate = 0;
		int endDate = 3;
		web.login(web.dPropertyLoginUserName(), web.dPropertyLoginPswrd());

		web.selectbusinessunit();
		web.clickCreateCommunicationfromMenu();
		web.singleDimensionComm(startDate, endDate);
		web.channelType3().analyticOption2().analyticOption5().clickNext();
		web.mobilepushSmartLinkCreate();
		web.mobilepushAudienceSelect();
		web.mobilePushTypeAndLayout("Alert / Rich push");
		web.mobilepushcontent("Create");

		web.mobilepushTitleAndContentEnter();
		web.MpBrowseImage();
		// web.mpImageURL();
		web.mobilepushSetInteractivity();
		web.mobilepushSetExpiry();
		web.mobilepushSendTestPreview(System.getProperty("webMobilePushTestCommunication"));
	}

	@Test(description = "Create Mobile push communication without image ")
	public void mobileRichPushWithoutImage() throws Exception
	{
		CommunicationEmailChannelPage com = getPageFactory().communicationEmailChannelPage();

		CommunicationMobilePushPage web = getPageFactory().communicationMobilePushPage();
		int startDate = 0;
		int endDate = 3;
		web.login(web.dPropertyLoginUserName(), web.dPropertyLoginPswrd());

		web.selectbusinessunit();
		web.clickCreateCommunicationfromMenu();
		web.singleDimensionComm(startDate, endDate);

		web.channelType3().analyticOption2().analyticOption5().clickNext();
		web.mobilepushSmartLinkCreate();
		web.mobilepushAudienceSelect();
		web.mobilePushTypeAndLayout("Alert / Rich push");
		web.mobilepushcontent("Create");

		web.mobilepushTitleAndContentEnter();
		web.mobilepushSetInteractivity();
		web.mobilepushSetExpiry();
		com.emailtimezone();
		com.enterEmailScheduleTime(startDate);
		web.mobilepushCommunicationSave();
		web.searchCommunication("communicationlisting", web.communicationName);
		web.communicationlistingPageStatusCompare("Scheduled");

	}

	@Test(description = "Create Mobile push communication without image test preview ")
	public void mobileRichPushWithoutImagePreview() throws AWTException
	{
		CommunicationMobilePushPage web = getPageFactory().communicationMobilePushPage();
		int startDate = 0;
		int endDate = 3;
		web.login(web.dPropertyLoginUserName(), web.dPropertyLoginPswrd());

		web.selectbusinessunit();
		web.clickCreateCommunicationfromMenu();
		web.singleDimensionComm(startDate, endDate);

		web.channelType3().analyticOption2().analyticOption5().clickNext();
		web.mobilepushSmartLinkCreate();
		web.mobilepushAudienceSelect();
		web.mobilePushTypeAndLayout("Alert / Rich push");
		web.mobilepushcontent("Create");

		web.mobilepushTitleAndContentEnter();
		web.mobilepushSetInteractivity();
		web.mobilepushSetExpiry();
		web.mobilepushSendTestPreview(System.getProperty("webMobilePushTestCommunication"));
	}

	@Test(description = "Create Mobile push communication with image URL")
	public void mobileRichPushImageUrl() throws AWTException
	{
		CommunicationMobilePushPage comm = getPageFactory().communicationMobilePushPage();
		CommunicationEmailChannelPage email = getPageFactory().communicationEmailChannelPage();

		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());

		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);

		comm.channelType3().analyticOption2().analyticOption5().clickNext();
		comm.mobilepushSmartLinkCreate();
		comm.mobilepushAudienceSelect();
		comm.mobilePushTypeAndLayout("Alert / Rich push");
		comm.mobilepushcontent("Create");
		comm.mobilepushTitleAndContentEnter();
		comm.MpBrowseImage();
		// comm.mpImageURL();
		comm.mobilepushSetInteractivity();
		comm.mobilepushSetExpiry();
		email.emailtimezone();
		email.enterEmailScheduleTime(startDate);
		comm.mobilepushCommunicationSave();
		comm.searchCommunication("communicationlisting", comm.communicationName);
		comm.communicationlistingPageStatusCompare("Scheduled");

	}

	@Test(description = "Create Mobile push communication with All type OFF ")
	public void mobileInAppInboxAllOFF() throws AWTException
	{
		CommunicationMobilePushPage web = getPageFactory().communicationMobilePushPage();
		int startDate = 0;
		int endDate = 3;
		web.login(web.dPropertyLoginUserName(), web.dPropertyLoginPswrd());

		web.selectbusinessunit();
		web.clickCreateCommunicationfromMenu();
		web.singleDimensionComm(startDate, endDate);
		web.channelType3().analyticOption2().analyticOption5().clickNext();

		web.mobilepushSmartLinkCreate();
		web.mobilepushAudienceSelect();
		web.mobilePushTypeAndLayout("In-app inbox");
		web.mobilepushcontent("Create");
		web.mobilepushTitleAndContentEnter();
		web.mobilepushSetInteractivity();
		web.mobilepushSetExpiry();
		web.enterMobilepushScheduleTime(startDate);

		web.mobilepushCommunicationSave();
		web.searchCommunication("communicationlisting", web.communicationName);
		web.communicationlistingPageStatusCompare("Scheduled");
	}

	@Test(description = "Create Mobile push communication Split ABCD Create and Delete")
	public void mpSplitABCDCreateandDelete() throws AWTException
	{
		CommunicationMobilePushPage mobile = getPageFactory().communicationMobilePushPage();
		int startDate = 0;
		int endDate = 3;
		mobile.login(mobile.dPropertyLoginUserName(), mobile.dPropertyLoginPswrd());

		mobile.selectbusinessunit();
		mobile.clickCreateCommunicationfromMenu();
		mobile.singleDimensionComm(startDate, endDate);
		mobile.channelType3().analyticOption2().analyticOption5().clickNext();
		mobile.mobilepushSmartLinkCreate();
		mobile.mobilepushAudienceSelect();
		mobile.mobilePushTypeAndLayout("In-app inbox");
		mobile.splitMobilePushON("ABCD");
		mobile.mobilepushcontent("Create");
		mobile.mobilepushTitleAndContentEnterSplit("A");
		mobile.mobilepushSetInteractivitySplit("A");
		mobile.mobilepushSetExpirySplit("A");
		mobile.mobilepushTitleAndContentEnterSplit("B");
		mobile.mobilepushSetInteractivitySplit("B");
		mobile.mobilepushSetExpirySplit("B");
		mobile.mobilepushTitleAndContentEnterSplit("C");
		mobile.mobilepushSetInteractivitySplit("C");
		mobile.mobilepushSetExpirySplit("C");
		mobile.mobilepushTitleAndContentEnterSplit("D");
		mobile.mobilepushSetInteractivitySplit("D");
		mobile.mobilepushSetExpirySplit("D");

		mobile.mobilepushSetTimeZoneScheduleDateCarouselSplit(mobile.calendarSchedduleDate(1));
		mobile.splitAutoScheduleOffValidate();
		mobile.mobilepushCommunicationSave();
		mobile.searchCommunication("communicationlisting", mobile.communicationName);
		mobile.communicationlistingPageStatusCompare("Scheduled");
		mobile.deleteCommunicationAndValidate(mobile.communicationName);
	}

	@Test(description = "Create Mobile push communication Import regression")

	public void mpimportregression()
	{
		CommunicationMobilePushPage web = getPageFactory().communicationMobilePushPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();

		int startDate = 0;
		int endDate = 3;
		web.login(web.dPropertyLoginUserName(), web.dPropertyLoginPswrd());

		web.selectbusinessunit();
		web.clickCreateCommunicationfromMenu();
		web.singleDimensionComm(startDate, endDate);

		web.channelType3().analyticOption2().analyticOption5().clickNext();
		web.mobilepushSmartLinkCreate();
		web.mobilepushAudienceSelect();
		web.mobilePushTypeAndLayout("In-app messaging");
		// web.mobilePushDeliveryTypeAndLayout("Full screen");
		web.mobilepushcontent("Import");
		// comm.selectZipUsingKeys();
		comm.selectZip(BaseTest.getData().ZipName);
		comm.javaScriptScrollDown();

		web.mobilepushmakealert();
		web.mobilepushSetInteractivity();
		web.mobilepushSetExpiry();
		web.mobilepushHashtag();
		web.mobilepushAlert();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		comm.clickNextemail();
		web.pageLoaderLogo();
		web.pageLoaderLogo();
		PageBase.threadSleep(ObjectRepository.wait5sec);
		web.javaScriptScrollDown();
		web.clickElement(CommunicationRepository.authoringpage_webanalytics);
		web.pageLoaderLogo();
		precomm.webAnalyticsDetails().mobileAppAnalyticsDetails();
		// precomm.frequencycap();
		precomm.contentbox();
		// precomm.advAnalyticsEmailSms("Mobile push");
		precomm.preCommunicationPage();
		web.communicationlistingPageStatusCompare("Scheduled");

	}

	@Test(description = "Create Mobile push communication event trigger regression")

	public void mpEventregression() throws AWTException, InterruptedException
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		CommunicationMobilePushPage web = getPageFactory().communicationMobilePushPage();

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
		comm.javaScriptScrollDown();
		comm.channelType3().analyticOption2().analyticOption5();
		comm.clickFrequency("Daily");
		comm.getTimeForDaily("1");
		comm.singleDimensionregression("not roi");

		comm.clickNext();
		BaseTest.takeScreenshot();
		web.mobilepushSmartLinkCreate();
		web.mobilePushDeliveryTypeAndLayout("Alert / Rich push");
		web.mobilepushcontent("Create");
		web.communicationName = comm.communicationName;
		web.mobilepushTitleAndContentEnter();
		web.MpBrowseImage();
		// comm.mpImageURL();

		web.mobilepushSetInteractivity();
		web.mobilepushSetExpiry();
		web.mobilepushAlert();
		comm.pageLoaderLogo();
		comm.javaScriptScrollDown();
		comm.clickNextemail();
		comm.pageLoaderLogo();
		comm.javaScriptScrollDown();
		comm.clickElement(CommunicationRepository.authoringpage_webanalytics);
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails().mobileAppAnalyticsDetails();
		// precomm.frequencycap();
		precomm.contentbox();
		// precomm.advAnalyticsEmailSms("Mobile push");
		precomm.preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Inprogress");
		comm.pauseEventTriggCommunicationinlistingpage();
		comm.playEventTriggCommunicationinlistingpage();
		comm.stopEventTriggCommunicationinlistingpage();
	}

	@Test(description = "Create Mobile push split communication ")
	public void mobilePushSplit() throws AWTException
	{
		CommunicationMobilePushPage comm = getPageFactory().communicationMobilePushPage();
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationNotificationPage web = getPageFactory().communication_Notification();
		CommunicationEmailChannelPage emm = getPageFactory().communicationEmailChannelPage();

		Map<String, String> splitA = new HashedMap();
		Map<String, String> splitB = new HashedMap();
		Map<String, String> splitC = new HashedMap();

		String splitAsub = "Split type: A, " + comm.communicationName + BaseTest.getData().EmailSubjectLine;
		String splitBsub = "Split type: B, " + comm.communicationName + BaseTest.getData().EmailSubjectLine;
		String splitCsub = "Split type: C, " + comm.communicationName + BaseTest.getData().EmailSubjectLine;

		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType3().analyticOption2().analyticOption5().clickNext();
		comm.mobilepushSmartLinkCreate();
		comm.mobilepushAudienceSelect();
		comm.mobilePushDeliveryTypeAndLayout("Alert / Rich push");
		sms.splitSMSON("ABC");
		comm.splitMobileDetails("A", splitAsub, BaseTest.getData().ZipName);
		splitA.put("SplitType", "A");
		emm.enterSplitScheduleDate("A");
		comm.splitMobileDetails("B", splitAsub, BaseTest.getData().ZipName);
		splitA.put("SplitType", "B");
		emm.enterSplitScheduleDate("B");
		comm.splitMobileDetails("C", splitAsub, BaseTest.getData().ZipName);
		splitA.put("SplitType", "C");
		emm.enterSplitScheduleDate("C");
		sms.splitSMSAutoScheduleOffValidate();
		comm.mobilepushCommunicationSave();
		comm.searchCommunication("communicationlisting", comm.communicationName);
		comm.communicationlistingPageStatusCompare("Scheduled");
	}
}
