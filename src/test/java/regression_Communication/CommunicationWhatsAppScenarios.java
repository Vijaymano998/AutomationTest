package regression_Communication;

import java.awt.AWTException;

import org.testng.annotations.Test;

import pages.AudiencePage_Dynamiclist;
import pages.CommunicationEmailChannelPage;
import pages.CommunicationSMSChannelPage;
import pages.CommunicationWhatsAppPage;
import pages.PreCommunicationAnalyticsPage;
import pages.SyncHistoryPage;
import repository.CommunicationRepository;
import repository.ObjectRepository;
import utility.BaseTest;
import utility.PageBase;

public class CommunicationWhatsAppScenarios extends BaseTest
{
	@Test(testName = "", description = "Event trigger communication Daily - whatsapp")
	public void TriggerCommWhatsappDaily()
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
		comm.loginwithoutplugin(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.eventTriggComm(startDate, endDate);
		comm.channelType2().analyticOption2();
		comm.clickFrequency("Daily");
		comm.getTimeForDaily("1");
		comm.clickNext();
		BaseTest.takeScreenshot();

	}

	@Test(testName = "", description = "Whatsapp communication without image")
	public void whatsAppWithoutImageBlast()
	{

		CommunicationWhatsAppPage whatsApp = getPageFactory().communicationWhatsAppPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();

		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType2().analyticOption2();
		comm.clickNext().createSmarturl();
		comm.javaScriptScrolltoTop();
		whatsApp.whatsAppSenderName();
		comm.enternewRecipient();
		whatsApp.whatsAppTemplate(BaseTest.getData().ZipNameB);
		whatsApp.enterWhatsAppContentwithPersonalization();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		comm.clickNextemail();
		comm.pageLoaderLogo();
		PageBase.threadSleep(ObjectRepository.wait5sec);
		comm.reschedule(startDate);
		comm.explicitwaitforvisibility(comm.autolocator(CommunicationRepository.authoringpage_provider), 20);
		comm.javaScriptScrollDown();
		comm.clickElement(CommunicationRepository.authoringpage_webanalytics);
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Scheduled");
	}

	@Test(testName = "", description = "Whatsapp communication preview without image")
	public void whatsAppPreviewWithouImage()
	{

		CommunicationWhatsAppPage whatsApp = getPageFactory().communicationWhatsAppPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();

		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType2().analyticOption2();
		comm.clickNext().createSmarturl();
		comm.javaScriptScrolltoTop();
		whatsApp.whatsAppSenderName();
		comm.enternewRecipient();
		whatsApp.whatsAppTemplate(BaseTest.getData().ZipNameB);
		whatsApp.enterWhatsAppContentwithPersonalization();
		// whatsApp.whatsAppImage();
		comm.javaScriptScrollDown();
		whatsApp.whatsAppPreview();
		comm.javaScriptScrollDown();
		comm.clickSaveEmail();
		comm.explicitwaitforclick(comm.autolocator(CommunicationRepository.authoringpage_whatsappconfirmpreview), 20);
		comm.clickElement(CommunicationRepository.authoringpage_whatsappconfirmpreview);
		comm.pageLoaderLogo();
		comm.communicationlistingPageStatusCompare("Draft");
	}

	@Test(testName = "", description = "Event trigger communication Immediate - Whatsapp")
	public void TriggerCommWhatsappImmediate()
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
		// dynamic.selectTriggerValues();
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
		comm.loginwithoutplugin(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.eventTriggComm(startDate, endDate);
		comm.channelType2().analyticOption2();
		comm.clickFrequency("Immediate");
		comm.clickNext();
		BaseTest.takeScreenshot();
	}

	@Test(testName = "", description = "Event trigger communication Daily regression - Whatsapp")
	public void WhatsappDailyBlastregression()
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
		CommunicationWhatsAppPage whatsApp = getPageFactory().communicationWhatsAppPage();

		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();

		//////////////////////////////////////////////////////
		comm.clickCreateCommunicationfromMenu();
		comm.eventTriggComm(startDate, endDate);
		comm.channelType2().analyticOption2();
		comm.clickFrequency("Daily");
		comm.getTimeForDaily("1");
		comm.clickNext();
		BaseTest.takeScreenshot();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		whatsApp.whatsAppSenderName();

		whatsApp.whatsAppTemplate(BaseTest.getData().ZipNameB);
		whatsApp.enterWhatsAppContentwithPersonalization();
		comm.javaScriptScrollDown();
		whatsApp.whatsAppPreview();
		comm.javaScriptScrollDown();
		comm.clickNextemail();
		comm.pageLoaderLogo();
		PageBase.threadSleep(ObjectRepository.wait5sec);
		comm.explicitwaitforvisibility(comm.autolocator(CommunicationRepository.authoringpage_provider), 20);
		comm.javaScriptScrollDown();
		comm.clickElement(CommunicationRepository.authoringpage_webanalytics);
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Scheduled");
	}

	@Test(testName = "", description = "Event trigger communication Regression - Whatsapp BLAST")
	public void WhatsappDailyBlast()
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		CommunicationWhatsAppPage whatsApp = getPageFactory().communicationWhatsAppPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();

		// pages.DynamiclistCreatePage dynamic =
		// getPageFactory().DynamiclistCreatePage();
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		SyncHistoryPage sync = getPageFactory().syncHistoryPage();
		sync.login(sync.dPropertyLoginUserName(), sync.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		comm.ETdynamicList = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		// dynamic.ruleType();
		dynamic.firstDynamicApprover(PageBase.audience_approver1).clickCreateAndSaveTrigger(comm.ETdynamicList);
		// dynamic.searchDynamicValue(EnterDynamiclistName);
		dynamic.logout();
		String pwind1 = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		dynamic.webURLlaunch();
		// dynamic.teamWebUrlLaunch();
		dynamic.teamWebmailLogin(System.getProperty("Target_Dynamic_approver1_webmail_Uname"), System.getProperty("Target_Dynamic_approver1_webmail_pswrd"));
		// dynamic.target_Dynamic_approver1_Webmail_login();
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

		//////////////////////////////////////////////////////
		comm.clickCreateCommunicationfromMenu();
		comm.eventTriggComm(startDate, endDate);
		comm.channelType2().analyticOption2();
		comm.clickFrequency("Daily");
		comm.getTimeForDaily("1");
		// comm.clickFrequency("Immediate");
		// comm.singleDimensionregression("not roi");
		comm.clickNext();
		BaseTest.takeScreenshot();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		whatsApp.whatsAppSenderName();

		whatsApp.whatsAppTemplate(BaseTest.getData().ZipNameB);
		whatsApp.enterWhatsAppContentwithPersonalization();
		comm.javaScriptScrollDown();
		whatsApp.whatsAppPreview();
		comm.javaScriptScrollDown();
		comm.clickNextemail();
		comm.pageLoaderLogo();
		PageBase.threadSleep(ObjectRepository.wait5sec);
		comm.explicitwaitforvisibility(comm.autolocator(CommunicationRepository.authoringpage_provider), 20);
		comm.javaScriptScrollDown();
		comm.clickElement(CommunicationRepository.authoringpage_webanalytics);
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails();
		precomm.preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Scheduled");
//		comm.pauseEventTriggCommunicationinlistingpage();
//		comm.playEventTriggCommunicationinlistingpage();
//		comm.stopEventTriggCommunicationinlistingpage();
	}

	@Test(testName = "", description = "Event trigger preview communication Daily - Whatsapp BLAST")
	public void WhatsappDailyBlastTestPrevieew() throws AWTException
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		CommunicationWhatsAppPage whatsApp = getPageFactory().communicationWhatsAppPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();

		// pages.DynamiclistCreatePage dynamic =
		// getPageFactory().DynamiclistCreatePage();
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		SyncHistoryPage sync = getPageFactory().syncHistoryPage();
		sync.login(sync.dPropertyLoginUserName(), sync.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		comm.ETdynamicList = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		// dynamic.ruleType();
		dynamic.firstDynamicApprover(PageBase.audience_approver1).clickCreateAndSaveTrigger(comm.ETdynamicList);
		// dynamic.searchDynamicValue(EnterDynamiclistName);
		dynamic.logout();
		String pwind1 = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		dynamic.webURLlaunch();
		// dynamic.teamWebUrlLaunch();
		dynamic.teamWebmailLogin(System.getProperty("Target_Dynamic_approver1_webmail_Uname"), System.getProperty("Target_Dynamic_approver1_webmail_pswrd"));
		// dynamic.target_Dynamic_approver1_Webmail_login();
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

		//////////////////////////////////////////////////////
		comm.clickCreateCommunicationfromMenu();
		comm.eventTriggComm(startDate, endDate);
		comm.channelType2().analyticOption2();
		comm.clickFrequency("Daily");
		comm.getTimeForDaily("1");
		// comm.clickFrequency("Immediate");
		// comm.singleDimensionregression("not roi");
		comm.clickNext();
		BaseTest.takeScreenshot();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		whatsApp.whatsAppSenderName();

		whatsApp.whatsAppTemplate(BaseTest.getData().ZipNameB);
		whatsApp.enterWhatsAppContentwithPersonalization();
		comm.javaScriptScrollDown();
		whatsApp.whatsAppPreview();
		comm.javaScriptScrollDown();
		comm.clickSaveEmail();
		comm.pageLoaderLogo();
		comm.communicationlistingPageStatusCompare("Scheduled");
//		comm.pauseEventTriggCommunicationinlistingpage();
//		comm.playEventTriggCommunicationinlistingpage();
//		comm.stopEventTriggCommunicationinlistingpage();
	}

	@Test(description = "Whatsapp channel regression test cases")
	public void whatsAppRegressionTests() throws AWTException
	{
		CommunicationWhatsAppPage whatsApp = getPageFactory().communicationWhatsAppPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();

		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType2().analyticOption2();
		comm.clickNext().createSmarturl();
		comm.javaScriptScrolltoTop();
		whatsApp.whatsappRegressionTests();
	}

}
