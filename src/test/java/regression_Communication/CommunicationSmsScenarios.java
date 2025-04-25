package regression_Communication;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.AudiencePage_Dynamiclist;
import pages.CommunicationEmailChannelPage;
import pages.CommunicationPlannerPage;
import pages.CommunicationSMSChannelPage;
import pages.PreCommunicationAnalyticsPage;
import pages.SyncHistoryPage;
import repository.CommunicationRepository;
import repository.ObjectRepository;
import utility.BaseTest;
import utility.PageBase;

public class CommunicationSmsScenarios extends BaseTest
{

	@Test(testName = "", description = "SMS communication with Target list")
	public void smsCommunicationCreateValidateTargetList()
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
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
		sms.enterSmsProviderid();
		comm.enternewRecipient();
		sms.enterSmsLanguage();
		sms.enterSmsTemplateID();
		sms.enterSMSContentwithPersonalization();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		comm.clickNextemail();
		comm.pageLoaderLogo();
		comm.reschedule(startDate);

		comm.explicitwaitforclick(comm.autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 20);
		comm.javaScriptScrollDown();
		comm.clickElement(CommunicationRepository.authoringpage_webanalytics);
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("In progress");
	}

	@Test(testName = "", description = "SMS communication with Adhoc list")
	public void smsCommunicationCreateValidateAdhocList()
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
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
		sms.enterSmsProviderid();
		comm.enternewRecipient();
		sms.enterSmsLanguage();
		sms.enterSmsTemplateID();
		sms.enterSMSContentwithPersonalization();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		comm.clickNextemail();
		comm.pageLoaderLogo();
		comm.reschedule(startDate);
		comm.explicitwaitforclick(comm.autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 20);
		comm.javaScriptScrollDown();
		comm.clickElement(CommunicationRepository.authoringpage_webanalytics);
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("In progress");
	}

	@Test(testName = "", description = "Event trigger communication Immediate - SMS")
	public void smsTriggerComm()
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
		comm.channelType2().analyticOption2();
		comm.clickFrequency("Immediate");
		comm.clickNext();
		BaseTest.takeScreenshot();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		sms.enterSmsProviderid();
		sms.enterSmsLanguage();
		sms.enterSmsTemplateID();
		sms.enterSMSContentwithPersonalization();
		comm.javaScriptScrollDown();
		comm.clickNextemail();
		comm.pageLoaderLogo();
		comm.explicitwaitforclick(comm.autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 20);
		comm.javaScriptScrollDown();
		comm.clickElement(CommunicationRepository.authoringpage_webanalytics);
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Scheduled");
	}

	@Test(testName = "", description = "Event trigger communication Daily - SMS")
	public void smsEventTriggerDaily()
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
		comm.channelType2().analyticOption2();
		comm.clickFrequency("Daily");
		comm.getTimeForDaily("1");
		comm.clickNext();
		BaseTest.takeScreenshot();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		sms.enterSmsProviderid();
		sms.enterSmsLanguage();
		sms.enterSmsTemplateID();
		sms.enterSMSContentwithPersonalization();
		comm.javaScriptScrollDown();
		comm.clickNextemail();
		comm.pageLoaderLogo();
		comm.explicitwaitforclick(comm.autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 20);
		comm.javaScriptScrollDown();
		comm.clickElement(CommunicationRepository.communication_Webannalytics);
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Inprogress");
		comm.pauseEventTriggCommunicationinlistingpage();
		comm.playEventTriggCommunicationinlistingpage();
		comm.stopEventTriggCommunicationinlistingpage();
	}

	@Test(description = "Event trigger communication Daily Test perview - SMS channel")
	public void eventTriggerSmsDailyTestPreview()
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
		comm.channelType2().analyticOption2();
		comm.clickFrequency("Daily");
		comm.getTimeForDaily("1");
		comm.clickNext();
		BaseTest.takeScreenshot();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		sms.enterSmsProviderid();
		sms.enterSmsLanguage();
		sms.enterSmsTemplateID();
		sms.enterSMSContentwithPersonalization();
		comm.javaScriptScrollDown();
		sms.sendTestSms();
		comm.clickSaveEmail();
		comm.explicitwaitforclick(comm.autolocator("Confirm preview,xpath,//div[contains(@class,'modal-content')]"), 20);
		comm.threadSleep(ObjectRepository.wait5sec);
		getWebDriver().findElement(By.xpath("(//button[.='Save'])[2]")).click();
		comm.pageLoaderLogo();
		comm.communicationlistingPageStatusCompare("Draft");
	}

	@Test(testName = "", description = "Event trigger preview communication Daily - SMS")
	public void smsTestpreviewET() throws InterruptedException
	{

		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();

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
		comm.clickCreateCommunicationfromMenu();
		comm.eventTriggComm(startDate, endDate);
		comm.channelType2().analyticOption2();
		comm.clickFrequency("Daily");
		comm.getTimeForDaily("1");
		comm.clickNext();
		BaseTest.takeScreenshot();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();

		sms.enterSmsProviderid();
		sms.enterSmsLanguage();
		sms.enterSmsTemplateID();
		sms.enterSMSContentwithPersonalization();
		comm.javaScriptScrollDown();
		sms.sendTestSms();
		comm.clickSaveEmail();
		comm.pageLoaderLogo();
		comm.communicationlistingPageStatusCompare("Scheduled");
	}

	@Test(testName = "", description = "Event trigger SMS communication with RFA Reject")
	public void smsEventTriggerRFAReject()
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();

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
		comm.clickCreateCommunicationfromMenu();
		comm.eventTriggComm(startDate, endDate);
		comm.channelType2().analyticOption2();
		comm.clickFrequency("Daily");
		comm.getTimeForDaily("1");
		comm.clickNext();

		BaseTest.takeScreenshot();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		sms.enterSmsProviderid();
		sms.enterSmsLanguage();
		sms.enterSmsTemplateID();
		sms.enterSMSContentwithPersonalization();
		comm.javaScriptScrollDown();
		PageBase.threadSleep(ObjectRepository.wait10sec);

		comm.requestforApprovalEmail1(System.getProperty("Communication_approver2_webmail_Uname"));
//		comm.clickNextemail();
//		comm.pageLoaderLogo();
//		comm.explicitwaitforclick(comm.autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 20);
		comm.javaScriptScrollDown();
		comm.clickElement(CommunicationRepository.communication_Webannalytics);
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Alert");
		////////////////////////////////////////////////////////////////
		// comm.emailChannelRFAPageCompareAttributeValuesInEditMode("pending for approval");

		String pwind = comm.parentWinHandle();
		comm.logout();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch();
		comm.Communication_approver2_Webmail_login();
		comm.clickCommunicationRFAMail(comm.communicationName);
		comm.clickMakeChangesBtn();
		comm.approvalMakeChangespage("RFA SMS make change communication:" + comm.communicationName);
		comm.switchParentWin(pwind);
		comm.openLoginPage();
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCommunicationListpagefromMenu();
		if (comm.searchCommunication("communicationlisting", comm.communicationName))
		{
			comm.communicationlistingPageStatusCompare("Alert");
			comm.emailChannelRFAPageCompareAttributeValuesInEditMode("on hold");

		}
	}

	@Test(testName = "", description = "SMS communication with Limit list")
	public void smsCommunicationLimitList()
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
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
		sms.enterSmsProviderid();
		comm.enternewRecipient();
		sms.enterSmsLanguage();
		sms.enterSmsTemplateID();
		sms.enterSMSContentwithPersonalization();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		comm.clickNextemail();
		comm.pageLoaderLogo();
		comm.reschedule(startDate);

		comm.explicitwaitforclick(comm.autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 20);
		comm.javaScriptScrollDown();
		comm.clickElement(CommunicationRepository.authoringpage_webanalytics);
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails();
		precomm.preCommunicationPageLimitList("One time", "null", "sms");
		// precomm.preCommunicationPageLimitList("By day", "Equal");
		precomm.preCommunicationPage();
		comm.communicationlistingPageStatusCompare("In progress");
	}

	@Test(testName = "", description = "SDC SMS communication with RFA")
	public void smsSDCRfa()
	{

		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
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
		sms.enterSmsProviderid();
		comm.enternewRecipient();
		sms.enterSmsLanguage();
		sms.enterSmsTemplateID();
		sms.enterSMSContentwithPersonalization();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		comm.requestforApprovalEmail1(System.getProperty("Communication_approver2_webmail_Uname"));
		// comm.clickNextemail();
		comm.pageLoaderLogo();
		if (comm.isElementPresent("Validation message,xpath,//div[@class='validation-message'][contains(.,'later than 15')]"))
		{
			comm.enterEmailScheduleTime(startDate);
			comm.clickNextemail();
			comm.pageLoaderLogo();
		}
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.explicitwaitforclick(comm.autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 20);
		comm.javaScriptScrollDown();
		comm.clickElement(CommunicationRepository.communication_Webannalytics);
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Alert");
		//////////////////////////////////
		String pwind = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch();
		//
		comm.Communication_approver2_Webmail_login();
		comm.clickCommunicationRFAMail(comm.communicationName);
		comm.rfaWebMailSubject("SMS");
		comm.clickCommunicationRFAMailApproveBtn();
		comm.RFAApprovalComments();
		comm.checkCommApprovedMsg();
		comm.switchParentWin(pwind);
		comm.openLoginPage();
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCommunicationListpagefromMenu();
		if (comm.searchCommunication("communicationlisting", comm.communicationName))
		{
			comm.communicationlistingPageStatusCompare("Scheduled");
		}
	}

	@Test(description = "SMS communication with rfa 1 reject and database validate")
	public void smsCommunicationCreateRejectRFA() throws IOException
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
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
		sms.enterSmsProviderid();
		comm.enternewRecipient();
		sms.enterSmsLanguage();
		sms.enterSmsTemplateID();
		sms.enterSMSContentwithPersonalization();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		comm.requestforApprovalEmail1(System.getProperty("Communication_approver2_webmail_Uname"));
		// comm.clickNextemail();
		comm.pageLoaderLogo();
		if (comm.isElementPresent("Validation message,xpath,//div[@class='validation-message'][contains(.,'later than 15')]"))
		{
			comm.enterEmailScheduleTime(startDate);
			comm.clickNextemail();
			comm.pageLoaderLogo();
		}
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.explicitwaitforclick(comm.autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 20);
		comm.javaScriptScrollDown();
		comm.clickElement(CommunicationRepository.communication_Webannalytics);
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Alert");
		String pwind = sms.parentWinHandle();
		sms.logout();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch();
		comm.Communication_approver2_Webmail_login();
		comm.clickCommunicationRFAMail(comm.communicationName);
		comm.clickMakeChangesBtn();
		comm.approvalMakeChangespage("RFA SMS make change communication:" + comm.communicationName);
		comm.switchParentWin(pwind);
		comm.openLoginPage();
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCommunicationListpagefromMenu();
		if (comm.searchCommunication("communicationlisting", comm.communicationName))
		{
			comm.communicationlistingPageStatusCompare("Alert");
		}
	}

	@Test(testName = "", description = "Event trigger SMS communication with RFA")
	public void smsEventTriggerDailyRfa()
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();

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
		comm.clickCreateCommunicationfromMenu();
		comm.eventTriggComm(startDate, endDate);
		comm.channelType2().analyticOption2();
		comm.clickFrequency("Daily");
		comm.getTimeForDaily("1");
		comm.clickNext();

		BaseTest.takeScreenshot();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		sms.enterSmsProviderid();
		sms.enterSmsLanguage();
		sms.enterSmsTemplateID();
		sms.enterSMSContentwithPersonalization();
		comm.javaScriptScrollDown();
		PageBase.threadSleep(ObjectRepository.wait10sec);

		comm.requestforApprovalEmail1(System.getProperty("Communication_approver2_webmail_Uname"));
//		comm.clickNextemail();
//		comm.pageLoaderLogo();
//		comm.explicitwaitforclick(comm.autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 20);
		comm.javaScriptScrollDown();
		comm.clickElement(CommunicationRepository.communication_Webannalytics);
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Alert");
		////////////////////////////////////////////////////////////////
		// comm.emailChannelRFAPageCompareAttributeValuesInEditMode("pending for approval");
		comm.logout();

		String pwind = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch().Communication_approver2_Webmail_login();
		/*
		 * comm.webURLlaunch(); // comm.target_Dynamic_approver1_Webmail_login();
		 */
		comm.clickCommunicationRFAMail(comm.communicationName);
		comm.rfaWebMailSubject("Email");
		comm.blastEmaillinksVerify();
		comm.clickCommunicationRFAMailApproveBtn();
		comm.RFAApprovalComments();
		comm.checkCommApprovedMsg();
		comm.switchParentWin(pwind);
		comm.openLoginPage();
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCommunicationListpagefromMenu();
		if (comm.searchCommunication("communicationlisting", comm.communicationName))
		{
			comm.communicationlistingPageStatusCompare("Scheduled");
		}
	}

	@Test(testName = "", description = "Advance analytics verify for  SMS")
	public void advanceAnalyticssms()
	{

		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();

		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType2();
		comm.analyticOption2();
		comm.clickNext();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		sms.enterSmsProviderid();
		comm.enternewRecipient();
		sms.enterSmsLanguage();
		sms.enterSmsTemplateID();
		sms.enterSMSContentwithPersonalization();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		comm.clickNextemail();
		comm.reschedule(startDate);
		comm.explicitwaitforclick(comm.autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 20);
		comm.javaScriptScrollDown();
		comm.clickElement(CommunicationRepository.communication_Webannalytics);
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails();
		precomm.advAnalyticsEmailSms("sms");

	}

	@Test(testName = "", description = "SMS communication Regression")
	public void smsCommunicationRegression() throws AWTException
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();

		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType2().analyticOption2();
		comm.singleDimensionregression("ROI");
		comm.Goaltype();
		comm.enterGoalPercentage();
		comm.analyticOption2();
		comm.clickNext().createSmarturl();
		comm.javaScriptScrolltoTop();
		sms.enterSmsProviderid();
		comm.enternewRecipient();
		sms.enterSmsLanguage();
		sms.enterSmsTemplateID();
		sms.enterSMSContentwithPersonalization();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		comm.clickNextemail();
		comm.pageLoaderLogo();
		comm.reschedule(startDate);

		comm.javaScriptScrollDown();
		comm.clickElement(CommunicationRepository.authoringpage_webanalytics);
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails();
		comm.EamilROI();
		precomm.frequencycap().contentbox().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("In progress");
	}

	@Test(testName = "", description = "SMS communication with Seed list")
	public void smsCommunicationCreateValidateSeedList()
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
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
		sms.enterSmsProviderid();
		comm.enternewRecipient();
		sms.enterSmsLanguage();
		sms.enterSmsTemplateID();
		sms.enterSMSContentwithPersonalization();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		comm.clickNextemail();
		comm.pageLoaderLogo();
		comm.reschedule(startDate);
		comm.explicitwaitforclick(comm.autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 20);
		comm.javaScriptScrollDown();
		comm.clickElement(CommunicationRepository.communication_Webannalytics);
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Scheduled");
	}

	@Test(testName = "", description = "SMS communication with Match list")
	public void smsCommunicationCreateValidateMatchList()
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
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
		sms.enterSmsProviderid();
		comm.enternewRecipient();
		sms.enterSmsLanguage();
		sms.enterSmsTemplateID();
		sms.enterSMSContentwithPersonalization();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		comm.clickNextemail();
		comm.pageLoaderLogo();
		comm.reschedule(startDate);
		comm.explicitwaitforclick(comm.autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 20);
		comm.javaScriptScrollDown();
		comm.clickElement(CommunicationRepository.communication_Webannalytics);
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Scheduled");
	}

	@Test(testName = "", description = "SMS communication with Suppression list")
	public void smsCommunicationCreateValidateSupList()
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
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
		sms.enterSmsProviderid();
		comm.enternewRecipient();
		sms.enterSmsLanguage();
		sms.enterSmsTemplateID();
		sms.enterSMSContentwithPersonalization();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		comm.clickNextemail();
		comm.pageLoaderLogo();
		comm.reschedule(startDate);
		comm.explicitwaitforclick(comm.autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 20);
		comm.javaScriptScrollDown();
		comm.clickElement(CommunicationRepository.communication_Webannalytics);
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Scheduled");
	}

	@Test(testName = "", description = "SMS preview with Target list")
	public void smsCommunicationTargetPreview()
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
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
		sms.enterSmsProviderid();
		comm.enternewRecipient();
		sms.enterSmsLanguage();
		sms.enterSmsTemplateID();
		sms.enterSMSContentwithPersonalization();
		comm.javaScriptScrollDown();
		sms.sendTestSms();
		comm.clickSaveEmail();
		comm.explicitwaitforclick(comm.autolocator("Confirm preview,xpath,//div[contains(@class,'modal-content')]"), 20);
		comm.threadSleep(ObjectRepository.wait5sec);
		getWebDriver().findElement(By.xpath("(//button[.='Save'])[2]")).click();
		comm.pageLoaderLogo();
		comm.communicationlistingPageStatusCompare("Draft");
	}

	@Test(testName = "", description = "SMS preview with Adhoc list")
	public void smsCommunicationAdhocPreview()
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
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
		sms.enterSmsProviderid();
		comm.enternewRecipient();
		sms.enterSmsLanguage();
		sms.enterSmsTemplateID();
		sms.enterSMSContentwithPersonalization();
		comm.javaScriptScrollDown();
		sms.sendTestSms();
		comm.clickSaveEmail();
		comm.explicitwaitforclick(comm.autolocator("Confirm preview,xpath,//div[contains(@class,'modal-content')]"), 20);
		comm.threadSleep(ObjectRepository.wait5sec);
		getWebDriver().findElement(By.xpath("(//button[.='Save'])[2]")).click();
		comm.pageLoaderLogo();
		comm.communicationlistingPageStatusCompare("Draft");
	}

	@Test(testName = "", description = "SMS preview with Seed list")
	public void smsCommunicationSeedPreview()
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
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
		sms.enterSmsProviderid();
		comm.enternewRecipient();
		sms.enterSmsLanguage();
		sms.enterSmsTemplateID();
		sms.enterSMSContentwithPersonalization();
		comm.javaScriptScrollDown();
		sms.sendTestSms();
		comm.clickSaveEmail();
		comm.explicitwaitforclick(comm.autolocator("Confirm preview,xpath,//div[contains(@class,'modal-content')]"), 20);
		comm.threadSleep(ObjectRepository.wait5sec);
		getWebDriver().findElement(By.xpath("(//button[.='Save'])[2]")).click();
		comm.pageLoaderLogo();
		comm.communicationlistingPageStatusCompare("Draft");
	}

	@Test(testName = "", description = "SMS preview with Match list")
	public void smsCommunicationMatchPreview()
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
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
		sms.enterSmsProviderid();
		comm.enternewRecipient();
		sms.enterSmsLanguage();
		sms.enterSmsTemplateID();
		sms.enterSMSContentwithPersonalization();
		comm.javaScriptScrollDown();
		sms.sendTestSms();
		comm.clickSaveEmail();
		comm.explicitwaitforclick(comm.autolocator("Confirm preview,xpath,//div[contains(@class,'modal-content')]"), 20);
		comm.threadSleep(ObjectRepository.wait5sec);
		getWebDriver().findElement(By.xpath("(//button[.='Save'])[2]")).click();
		comm.pageLoaderLogo();
		comm.communicationlistingPageStatusCompare("Draft");
	}

	@Test(testName = "", description = "SMS preview with suppression list")
	public void smsCommunicationSupPreview()
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
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
		sms.enterSmsProviderid();
		comm.enternewRecipient();
		sms.enterSmsLanguage();
		sms.enterSmsTemplateID();
		sms.enterSMSContentwithPersonalization();
		comm.javaScriptScrollDown();
		sms.sendTestSms();
		comm.clickSaveEmail();
		comm.explicitwaitforclick(comm.autolocator("Confirm preview,xpath,//div[contains(@class,'modal-content')]"), 20);
		comm.threadSleep(ObjectRepository.wait5sec);
		getWebDriver().findElement(By.xpath("(//button[.='Save'])[2]")).click();
		comm.pageLoaderLogo();
		comm.communicationlistingPageStatusCompare("Draft");
	}

	@Test(description = "Create sms splitAB draft communication")
	public void smsCommunicationSplitABDraftCreate()
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();

		Map<String, String> splitA = new HashedMap();
		Map<String, String> splitB = new HashedMap();
		Map<String, String> splitC = new HashedMap();

		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType2().analyticOption2();
		comm.clickNext().createSmarturl();
		comm.javaScriptScrolltoTop();
		sms.enterSmsProviderid();
		comm.enternewRecipient();
		sms.enterSmsLanguage();
		String splitAsub = "Split type: A, " + comm.communicationName + BaseTest.getData().EmailSubjectLine;
		String splitBsub = "Split type: B, " + comm.communicationName + BaseTest.getData().EmailSubjectLine;
		String splitCsub = "Split type: C, " + comm.communicationName + BaseTest.getData().EmailSubjectLine;

		sms.splitSMSON("ABC");
		sms.splitSMSDetails("A", splitAsub, BaseTest.getData().ZipName);
		splitA.put("SplitType", "A");
		comm.enterSplitScheduleDate("A");
		sms.splitSMSDetails("B", splitBsub, BaseTest.getData().ZipName);
		splitB.put("SplitType", "B");
		comm.enterSplitScheduleDate("B");
		sms.splitSMSDetails("C", splitCsub, BaseTest.getData().ZipNameC);
		splitC.put("SplitType", "C");
		comm.enterSplitScheduleDate("C");
		sms.splitSMSAutoScheduleOffValidate();
		sms.clickSmssave();
		comm.communicationlistingPageStatusCompare("Draft");
	}

	@Test(testName = "", description = "Communication Scrubbed communication")
	public void CommunicationSMSScrubbed() throws InterruptedException
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		CommunicationPlannerPage Com = getPageFactory().CommunicationPlannerPage();

		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType2().analyticOption2();
		comm.clickNext().createSmarturl();
		comm.javaScriptScrolltoTop();
		sms.enterSmsProviderid();
		comm.enternewRecipient();
		sms.enterSmsLanguage();
		sms.enterSmsTemplateID();
		sms.enterSMSContentwithPersonalization();
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
		comm.explicitwaitforclick(comm.autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 20);
		comm.javaScriptScrollDown();
		comm.clickElement(CommunicationRepository.communication_Webannalytics);
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails();
		Com.SMSscrubbedScenario();
		Com.SMSvalidateCGTGSlider("false");
		Com.SMSvalidateCGTGSlider("true");
	}
}
