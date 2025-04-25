package regression_Communication;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.testng.annotations.Test;

import pages.AudiencePage_Dynamiclist;
import pages.CommunicationEmailChannelPage;
import pages.CommunicationSMSChannelPage;
import pages.PreCommunicationAnalyticsPage;
import pages.SyncHistoryPage;
import repository.CommunicationRepository;
import repository.ObjectRepository;
import utility.BaseTest;
import utility.PageBase;

public class CommunicationEmailScenarios extends BaseTest
{
	@Test(testName = "", description = "Email communication with Target list")
	public void emailCommunicationCreateValidateTargetList() throws IOException, Exception
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		int startDate = 0;
		int endDate = 3;

		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickNext();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();
		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		comm.selectZip(BaseTest.getData().ZipName);
		// comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		comm.javaScriptScrollDown();
		comm.clickNextemail();
		comm.reschedule(startDate);

		precomm.webAnalyticsDetails().preCommunicationPage();
		Thread.sleep(780000); // 780,000 milliseconds(13 minutes)
		comm.communicationlistingPageStatusCompare("In progress");
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch();
		comm.Communication_approver3_Webmail_login();
		comm.emailBlastSubjectLineValidate(comm.CommunicationNamE);
		comm.blastEmaillinksVerify();
	}

	@Test(testName = "", description = "Email communication with Adhoc list")
	public void emailCommunicationCreateValidateAdhocList() throws IOException
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickNext();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();

		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		comm.selectZip(BaseTest.getData().ZipName);
		// comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.javaScriptScrollDown();
		comm.clickNextemail();
		precomm.webAnalyticsDetails().preCommunicationPage();
		try
		{
			Thread.sleep(780000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 1,380,000 milliseconds (23 minutes)

		comm.communicationlistingPageStatusCompare("In progress");
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch();
		comm.Communication_approver3_Webmail_login();
		comm.emailBlastSubjectLineValidate(comm.CommunicationNamE);
		comm.blastEmaillinksVerify();
	}

	@Test(testName = "", description = "Email communication with Seed list")
	public void emailCommunicationCreateValidateSeedList() throws IOException
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickNext();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();

		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		comm.selectZip(BaseTest.getData().ZipName);
		// comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.javaScriptScrollDown();
		comm.clickNextemail();
		precomm.webAnalyticsDetails().preCommunicationPage();
		try
		{
			Thread.sleep(780000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comm.communicationlistingPageStatusCompare("In progress");
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch();
		comm.Communication_approver3_Webmail_login();
		comm.emailBlastSubjectLineValidate(comm.CommunicationNamE);
		comm.blastEmaillinksVerify();
	}

	@Test(testName = "", description = "Email communication with Suppression list")
	public void emailCommunicationCreateValidateSupList() throws IOException
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickNext();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();

		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		comm.selectZip(BaseTest.getData().ZipName);
		// comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.javaScriptScrollDown();
		comm.clickNextemail();
		precomm.webAnalyticsDetails().preCommunicationPage();
		try
		{
			Thread.sleep(780000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comm.communicationlistingPageStatusCompare("In progress");
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch();
		comm.Communication_approver3_Webmail_login();
		comm.emailBlastSubjectLineValidate(comm.CommunicationNamE);
		comm.blastEmaillinksVerify();
	}

	@Test(testName = "", description = "Email communication with Match list")
	public void emailCommunicationCreateValidateMatchList() throws IOException
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickNext();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();

		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		comm.selectZip(BaseTest.getData().ZipName);
		// comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.javaScriptScrollDown();
		comm.clickNextemail();
		precomm.webAnalyticsDetails().preCommunicationPage();
		try
		{
			Thread.sleep(780000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		comm.communicationlistingPageStatusCompare("In progress");
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch();
		comm.Communication_approver3_Webmail_login();
		comm.emailBlastSubjectLineValidate(comm.CommunicationNamE);
		comm.blastEmaillinksVerify();
	}

	@Test(testName = "", description = "Email preview with Target list")
	public void emailCommunicationTargetPreview() throws IOException
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickNext().smartUrlpopupCancel();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();

		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		comm.selectZip(BaseTest.getData().ZipName);
		// comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		String mail = System.getProperty("Communication_approver1_webmail_Uname");
		comm.testmail(mail);
		comm.communicationlistingPageStatusCompare("Draft");
		String pwind = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch().Communication_approver1_Webmail_login();
//resuluser15
		comm.emailBlastSubjectLineValidate(comm.communicationName);
		comm.blastEmaillinksVerify();
	}

	@Test(testName = "", description = "Email preview with Adhoc list")
	public void emailCommunicationAdhocPreview() throws IOException
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickNext().smartUrlpopupCancel();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();

		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		comm.selectZip(BaseTest.getData().ZipName);
		// comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		String mail = System.getProperty("Communication_approver1_webmail_Uname");
		comm.testmail(mail);
		comm.communicationlistingPageStatusCompare("Draft");
		String pwind = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch().Communication_approver1_Webmail_login();

		comm.emailBlastSubjectLineValidate(comm.communicationName);
		comm.blastEmaillinksVerify();
	}

	@Test(testName = "", description = "Email preview with Seed list")
	public void emailCommunicationSeedPreview() throws IOException
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickNext().smartUrlpopupCancel();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();

		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		comm.selectZip(BaseTest.getData().ZipName);
		// comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		String mail = System.getProperty("Communication_approver1_webmail_Uname");
		comm.testmail(mail);
		comm.communicationlistingPageStatusCompare("Draft");
		String pwind = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch().Communication_approver1_Webmail_login();

		comm.emailBlastSubjectLineValidate(comm.communicationName);
		comm.blastEmaillinksVerify();
	}

	@Test(testName = "", description = "Email preview with Match list")
	public void emailCommunicationMatchPreview() throws IOException
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickNext().smartUrlpopupCancel();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();

		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		comm.selectZip(BaseTest.getData().ZipName);
		// comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		String mail = System.getProperty("Communication_approver1_webmail_Uname");
		comm.testmail(mail);
		comm.communicationlistingPageStatusCompare("Draft");
		String pwind = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch().Communication_approver1_Webmail_login();

		comm.emailBlastSubjectLineValidate(comm.communicationName);
		comm.blastEmaillinksVerify();
	}

	@Test(testName = "", description = "Email preview with Suppression list")
	public void emailCommunicationSupPreview() throws IOException
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickNext().createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();

		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		comm.selectZip(BaseTest.getData().ZipName);
		// comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		String mail = System.getProperty("Communication_approver1_webmail_Uname");
		comm.testmail(mail);
		comm.communicationlistingPageStatusCompare("Draft");
		String pwind = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch().Communication_approver1_Webmail_login();

		comm.emailBlastSubjectLineValidate(comm.communicationName);
		comm.blastEmaillinksVerify();
	}

	@Test(testName = "Email text blast targetlist", description = "Text email communication blast targetlist")
	public void emailTextCommunicationBlast()
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickNext();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();

		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.commTextEmailPersona();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.enterEmailScheduleTime(startDate);
		comm.javaScriptScrollDown();
		comm.clickNextemail();
		comm.pageLoaderLogo();
		comm.reschedule(startDate);
		precomm.webAnalyticsDetails().preCommunicationPage();
		try
		{
			Thread.sleep(780000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		} // 1,380,000 milliseconds (23 minutes)

		comm.communicationlistingPageStatusCompare("In progress");
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch();
		comm.Communication_approver3_Webmail_login();
		comm.emailBlastSubjectLineValidate(comm.communicationName);
		comm.blastEmaillinksVerify();
	}

	@Test(testName = "Text communication Test Preview", description = "Text communication Test Preview ")
	public void emailTextCommunicationTest()
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickNext();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();

		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.commTextEmailPersona();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		String mail = System.getProperty("Communication_approver3_webmail_Uname");
		comm.testmail(mail);
		comm.communicationlistingPageStatusCompare("Draft");
		String pwind = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch().Communication_approver3_Webmail_login();

		comm.emailBlastSubjectLineValidate(comm.communicationName);
		comm.blastEmaillinksVerify();
	}

	@Test(testName = "", description = "Email duplicate communication blast and validate")
	public void emailDuplicateCommunictionValidate()
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCommunicationListpagefromMenu();
		String commName = System.getProperty("duplicatecommunication");
		comm.searchCommunication("communicationlisting", commName);
		String duplicatecomm = comm.duplicatecomm(commName);
		comm.searchCommunication("communicationlisting", duplicatecomm);
		comm.editcommWithName(duplicatecomm);
		comm.clearField(CommunicationRepository.Communicationcreate_entercommunicationname);
		comm.communicationName = BaseTest.getData().CommunicationName + " " + comm.addTimeToName();
		comm.enterValue(CommunicationRepository.Communicationcreate_entercommunicationname, comm.communicationName);
		comm.javaScriptScrollDown();
		comm.clickNext();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();

		comm.enterEmailsubwithPersonalization();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.enterEmailScheduleTime(startDate);
		comm.javaScriptScrollDown();
		comm.clickNextemail();
		comm.pageLoaderLogo();
		comm.reschedule(startDate);
		precomm.webAnalyticsDetails().preCommunicationPage();
		try
		{
			Thread.sleep(780000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 780,000 milliseconds(13 minutes)
		comm.communicationlistingPageStatusCompare("In progress");
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch();
		comm.Communication_approver3_Webmail_login();
		comm.emailBlastSubjectLineValidate(comm.communicationName);
		comm.blastEmaillinksVerify();

	}

	@Test(testName = "", description = "Event trigger communication Daily - Email")
	public void emailTriggerDailyComm()
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
		comm.channelType1().analyticOption2();
		comm.clickFrequency("Daily");
		comm.getTimeForDaily("1");
		comm.clickNext();
		BaseTest.takeScreenshot();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();

		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		comm.selectZip(BaseTest.getData().ZipName);
		// comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.clickNextemail();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Scheduled");
		comm.pauseEventTriggCommunicationinlistingpage();
		comm.playEventTriggCommunicationinlistingpage();
		comm.stopEventTriggCommunicationinlistingpage();
	}

	@Test(testName = "", description = "Event trigger communication Immediate - Email import ")
	public void emailTriggerComm() throws InterruptedException
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
		comm.channelType1().analyticOption2();
		comm.clickFrequency("Immediate");
		comm.clickNext();
		BaseTest.takeScreenshot();
//		comm.createSmarturl();
//		comm.javaScriptScrolltoTop();
//		comm.enternewsenderid();
//
//		// comm.enterFname();
//		comm.enterEmailsubwithPersonalization();
//		comm.CommunicationType("Text");
//
//		comm.emailunsubscribeselect();
//		comm.emailFooter();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();

		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		comm.selectZip(BaseTest.getData().ZipName);
		// comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.clickNextemail();
		precomm.webAnalyticsDetails().preCommunicationPage();
		Thread.sleep(780000); // 1,380,000 milliseconds (23 minutes)

		comm.communicationlistingPageStatusCompare("Scheduled");
		String pwind = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch().Communication_approver3_Webmail_login();

		comm.emailBlastSubjectLineValidate(comm.communicationName);
		comm.blastEmaillinksVerify();

	}

	@Test(testName = "", description = "Event trigger communication Daily - Email")
	public void emailEventTriggerDaily()
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
		comm.channelType1().analyticOption2();
		comm.clickFrequency("Daily");
		comm.getTimeForDaily("1");
		comm.clickNext();
		BaseTest.takeScreenshot();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();

		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		comm.selectZip(BaseTest.getData().ZipName);
		// comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.clickNextemail();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Scheduled");
		comm.pauseEventTriggCommunicationinlistingpage();
		comm.playEventTriggCommunicationinlistingpage();
		comm.stopEventTriggCommunicationinlistingpage();
	}

	@Test(description = "Event trigger communication Daily Test perview - Email channel")
	public void eventTriggerEmailDailyTestPreview()
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
		comm.channelType1().analyticOption2();
		comm.clickFrequency("Daily");
		comm.getTimeForDaily("1");
		comm.clickNext();
		BaseTest.takeScreenshot();
		comm.createSmarturl();

		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();

		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		comm.selectZip(BaseTest.getData().ZipName);
		// comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		String mail = System.getProperty("Communication_approver3_webmail_Uname");
		comm.testmailEventTrigger(mail);
		comm.communicationlistingPageStatusCompare("Scheduled");
		String pwind = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch().Communication_approver3_Webmail_login();

		comm.emailBlastSubjectLineValidate(comm.communicationName);
		comm.blastEmaillinksVerify();
	}

	@Test(testName = "", description = "Subject line analysis validation")
	public void subjectLineAnalysis()
	{

		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickNext();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();

		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.subjectLineValidation();
		comm.clickImport();
		comm.selectZip(BaseTest.getData().ZipName);
		// comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		comm.threadSleep(ObjectRepository.wait10sec);
		comm.javaScriptScrollDown();
		comm.clickNextemail();

		precomm.webAnalyticsDetailsWithOfflineConversion().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("In progress");
	}

	// need to add make changes scripts once make changes issue resolved.
	@Test(testName = "", description = "SDC Email communication with RFA")
	public void EmailSdcRfa()
	{

		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		int startDate = 0;
		int endDate = 3;

		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();

		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickNext();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();
		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		comm.selectZip(BaseTest.getData().ZipName);
		// comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.requestforApprovalEmail1(System.getProperty("Communication_approver2_webmail_Uname"));
		comm.reschedule(startDate);
		PageBase.threadSleep(ObjectRepository.wait10sec);
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Alert");
		comm.emailChannelRFAPageCompareAttributeValuesInEditMode("pending for approval");
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
		// comm.blastEmaillinksVerify();
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

	@Test(description = "Email communication with RFA 1 reject and database validate")
	public void emailCommunicationCreateRejectRFA() throws IOException
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		int startDate = 0;
		int endDate = 3;

		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();

		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickNext();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();

		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		comm.selectZip(BaseTest.getData().ZipName);
		// comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.requestforApprovalEmail1(System.getProperty("Communication_approver2_webmail_Uname"));
		comm.reschedule(startDate);
		PageBase.threadSleep(ObjectRepository.wait10sec);
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Alert"); /////////////////////////////////////////////////
		comm.emailChannelRFAPageCompareAttributeValuesInEditMode("pending for approval");
		comm.logout();
		String pwind = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch();
		comm.Communication_approver2_Webmail_login();
		comm.clickCommunicationRFAMail(comm.CommunicationNamE);
		comm.rfaWebMailSubject("Email");
		comm.blastEmaillinksVerify();
		comm.clickMakeChangesBtn();
		comm.approvalMakeChangespage("Communication sent for make changes");
		comm.switchParentWin(pwind);
		comm.openLoginPage();
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCommunicationListpagefromMenu();
		if (comm.searchCommunication("communicationlisting", comm.CommunicationNamE))
		{
			comm.communicationlistingPageStatusCompare("Alert");
			comm.emailChannelRFAPageCompareAttributeValuesInEditMode("on hold");
		}
	}

	@Test(testName = "", description = "Event trigger Email communication with RFA")
	public void emailEventTriggerDailyRfa()
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
		comm.channelType1().analyticOption2();
		comm.clickFrequency("Daily");
		comm.getTimeForDaily("1");
		comm.clickNext();
		BaseTest.takeScreenshot();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();

		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		comm.selectZip(BaseTest.getData().ZipName);
		// comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.requestforApprovalEmail1(System.getProperty("Communication_approver2_webmail_Uname"));
		// WebElement element = getWebDriver().findElement(By.xpath("(//button[normalize-space()='Next'])[1]"));
		// element.click();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Alert");
		/////////////////////////////////////////////////
		comm.ETemailChannelRFAPageCompareAttributeValuesInEditMode("pending for approval");
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

	@Test(testName = "", description = "Advance analytics verify for Email ")
	public void advanceAnalytics()
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
		comm.channelType1();
		comm.analyticOption2();
		comm.clickNext();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		// comm.enterFname();
		comm.enternewsenderid();
		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		comm.selectZip(BaseTest.getData().ZipName);
		// comm.selectZipUsingKeys();
		String spamScoreAuthoringPage = comm.spamScoreCheck();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.javaScriptScrollDown();
		comm.clickNextemail();
		comm.reschedule(startDate);
		comm.pageLoaderLogo();
		comm.javaScriptScrolltoTop();
		comm.clickElement(CommunicationRepository.communication_Webannalytics);
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails();
		String spamScorePrecComm = comm.getStrText("Spam score precomm,xpath,//h5[contains(.,'spam score')]/..//div//h1");
		comm.writeLog(spamScoreAuthoringPage.equals(spamScorePrecComm), "Spam score in authoring page is equals with spam score from precommunication page", "Spam score in authoring page is not equals with spam score from precommunication page");
		precomm.advAnalyticsEmailSms("email");
	}

	@Test(testName = "Email text blast regression", description = "Text email communication regression")
	public void emailTextCommunicationregression() throws AWTException
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.singleDimensionregression("ROI");
		comm.clickNext();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.emailsendername();
		comm.enternewsenderid();

		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.commTextEmailPersona();
		comm.commTextEmailinboxpreview();
		comm.emailFooter();
		comm.emailunsubscribeselect();
//		comm.commTextEmaillivePreview();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.enterEmailScheduleTime(startDate);
		comm.javaScriptScrollDown();
		comm.clickNextemail();
		comm.pageLoaderLogo();
		comm.reschedule(startDate);

		precomm.webAnalyticsDetails();
		comm.EamilROI();
		precomm.preCommunicationPage();
		comm.communicationlistingPageStatusCompare("In progress");
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch();
		comm.Communication_approver3_Webmail_login();
		comm.emailBlastSubjectLineValidate(comm.communicationName);
		comm.blastEmaillinksVerify();
	}

	@Test(testName = "", description = "ET Email communication Test Preview  ")
	public void emailEventTriggertestPreview() throws InterruptedException
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		////////////////////////////////////////////////////////////////////////

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

		///////////////////////////////////////////////////////////
		int startDate = 0;
		int endDate = 3;
		comm.accountsetuplogin(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.eventTriggComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickFrequency("Daily");
		comm.getTimeForDaily("1");
		comm.clickNext();
		BaseTest.takeScreenshot();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();

		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		comm.selectZip(BaseTest.getData().ZipName);
		// comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.javaScriptScrollDown();
		String mail = System.getProperty("Communication_approver3_webmail_Uname");
		comm.testmailEventTrigger(mail);
		comm.communicationlistingPageStatusCompare("Scheduled");
		String pwind = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch().Communication_approver3_Webmail_login();

		comm.emailBlastSubjectLineValidate(comm.communicationName);
		comm.blastEmaillinksVerify();
	}

	@Test(description = "Split ABC email communication schedule Creation and Edit Regression")
	public void emailCommunicationSplitABCScheduleandEdit() throws AWTException
	{

		Map<String, String> splitA = new HashedMap();
		Map<String, String> splitB = new HashedMap();
		Map<String, String> splitC = new HashedMap();

		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.singleDimensionregression("not ROI");
		comm.clickNext();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();

		comm.emailsendername();
		String splitAsub = "Split type: A, " + comm.communicationName + BaseTest.getData().EmailSubjectLine;
		String splitBsub = "Split type: B, " + comm.communicationName + BaseTest.getData().EmailSubjectLine;
		String splitCsub = "Split type: C, " + comm.communicationName + BaseTest.getData().EmailSubjectLine;
		String splitAsubEdit = "Edit Split type: A, " + comm.communicationName + BaseTest.getData().EmailSubjectLine;
		String splitBsubEdit = "Edit Split type: B, " + comm.communicationName + BaseTest.getData().EmailSubjectLine;
		String splitCsubEdit = "Edit Split type: C, " + comm.communicationName + BaseTest.getData().EmailSubjectLine;
		comm.enternewRecipient();
		comm.splitEmailON("ABC");
		comm.splitDetails("A", splitAsub, BaseTest.getData().ZipName);
		splitA.put("Subject", comm.emailSubjectline);
		splitA.put("SplitType", "A");
		comm.enterSplitScheduleDate("A");
		comm.splitDetails("B", splitBsub, BaseTest.getData().ZipName);
		splitB.put("Subject", comm.emailSubjectline);
		splitB.put("SplitType", "B");
		comm.enterSplitScheduleDate("B");
		comm.splitDetails("C", splitCsub, BaseTest.getData().ZipNameC);
		splitC.put("Subject", comm.emailSubjectline);
		splitC.put("SplitType", "C");
		comm.enterSplitScheduleDate("C");
		comm.splitAutoScheduleOffValidate();
		comm.javaScriptScrollDown();
		comm.clickNextemail();
		comm.pageLoaderLogo();
		if (comm.isElementPresent("Validation message,xpath,//div[@class='validation-message'][contains(.,'later than 15')]"))
		{
			comm.enterEmailScheduleTime(startDate);
			comm.clickNextemail();
			comm.pageLoaderLogo();
		}
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails();
		// precomm.frequencycap().contentbox();
		precomm.preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Scheduled");
	}

	@Test(testName = "", description = "ET Text communication Test Preview")
	public void emailTextEventTriggertestPreview() throws InterruptedException
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		////////////////////////////////////////////////////////////////////////

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

		///////////////////////////////////////////////////////////
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.eventTriggComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickFrequency("Daily");
		comm.getTimeForDaily("1");
		comm.clickNext();
		BaseTest.takeScreenshot();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();

		comm.enterEmailsubwithPersonalization();
		comm.commTextEmailPersona();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.javaScriptScrollDown();
		String mail = System.getProperty("Communication_approver2_webmail_Uname");
		comm.testmailEventTrigger(mail);
		comm.communicationlistingPageStatusCompare("Scheduled");
		String pwind = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch().Communication_approver2_Webmail_login();

		comm.emailBlastSubjectLineValidate(comm.communicationName);
		comm.blastEmaillinksVerify();
	}

	@Test(testName = "", description = "Event trigger Email communication with RFA")
	public void emailEventTriggerRejectRfa() throws InterruptedException
	{
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
		comm.accountsetuplogin(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.eventTriggComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickFrequency("Daily");
		comm.getTimeForDaily("1");
		comm.clickNext();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();

		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		comm.selectZip(BaseTest.getData().ZipName);
		// comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.requestforApprovalEmail1(System.getProperty("Communication_approver2_webmail_Uname"));
		// WebElement element = getWebDriver().findElement(By.xpath("(//button[normalize-space()='Next'])[1]"));
		// element.click();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Alert");
		/////////////////////////////////////////////////
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

	@Test(testName = "", description = "Email communication with Template")
	public void emailCommunicationTemplate() throws IOException, Exception
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickNext();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();
		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clicktemplate();
		comm.selectTemplate("Auto_TempleteBuilder_3_24_1100_910");
//		comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.javaScriptScrollDown();
		comm.clickNextemail();
		comm.reschedule(startDate);
		// WebElement element = getWebDriver().findElement(By.xpath("(//button[normalize-space()='Next'])[1]"));
		// element.click();
		precomm.webAnalyticsDetails().preCommunicationPage();
		Thread.sleep(780000);// 1,380,000 milliseconds (23 minutes)
		comm.communicationlistingPageStatusCompare("In progress");
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch();
		comm.Communication_approver3_Webmail_login();
		comm.emailBlastCheck(comm.communicationName);
		comm.blastEmailVerifyTemplate();
	}

	@Test(testName = "", description = "Email communication with Template TEST PREVIEW")
	public void emailCommunicationTemplateTestPreview() throws IOException, Exception
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickNext();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();
		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clicktemplate();
		comm.selectTemplate("Auto_TempleteBuilder_3_24_1100_910");
//		comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		String mail = System.getProperty("Communication_approver3_webmail_Uname");
		comm.testmail(mail);
		comm.communicationlistingPageStatusCompare("Draft");
		String pwind = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch().Communication_approver3_Webmail_login();

		comm.emailBlastCheck(comm.communicationName);
		comm.blastEmailVerifyTemplate();
	}

	@Test(testName = "", description = "ET Template communication Test Preview")
	public void emailTemplateEventTriggertestPreview() throws InterruptedException
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

		///////////////////////////////////////////////////////////
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.eventTriggComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickFrequency("Daily");
		comm.getTimeForDaily("1");
		comm.clickNext();
		BaseTest.takeScreenshot();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();
		comm.enterEmailsubwithPersonalization();
		comm.clicktemplate();
		comm.selectTemplate("Auto_TempleteBuilder_3_24_1100_910");
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		String mail = System.getProperty("Communication_approver3_webmail_Uname");
		comm.testmailEventTrigger(mail);
		comm.communicationlistingPageStatusCompare("Scheduled");
		String pwind = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch().Communication_approver3_Webmail_login();
		comm.emailBlastCheck(comm.communicationName);
		comm.blastEmailVerifyTemplate();
	}

	@Test(testName = "", description = "Email communication with Limit list")
	public void emailCommunicationLimitList() throws IOException, Exception
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickNext();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();
		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		comm.selectZip(BaseTest.getData().ZipName);
		// comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.javaScriptScrollDown();
		comm.clickNextemail();
		comm.reschedule(startDate);

		precomm.webAnalyticsDetails();
		// precomm.preCommunicationPageLimitList("One time", "null");
		precomm.preCommunicationPageLimitList("By day", "Equal", "email");

		precomm.preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Scheduled");

	}

	@Test(testName = "", description = "Split ABC email communication ")
	public void emailCommunicationSplitABC() throws AWTException
	{

		Map<String, String> splitA = new HashedMap();
		Map<String, String> splitB = new HashedMap();
		Map<String, String> splitC = new HashedMap();

		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickNext();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewsenderid();

		String splitAsub = "Split type: A, " + comm.communicationName + BaseTest.getData().EmailSubjectLine;
		String splitBsub = "Split type: B, " + comm.communicationName + BaseTest.getData().EmailSubjectLine;
		String splitCsub = "Split type: C, " + comm.communicationName + BaseTest.getData().EmailSubjectLine;
		String splitAsubEdit = "Edit Split type: A, " + comm.communicationName + BaseTest.getData().EmailSubjectLine;
		String splitBsubEdit = "Edit Split type: B, " + comm.communicationName + BaseTest.getData().EmailSubjectLine;
		String splitCsubEdit = "Edit Split type: C, " + comm.communicationName + BaseTest.getData().EmailSubjectLine;
		comm.enternewRecipient();
		comm.splitEmailON("ABC");
		comm.splitDetails("A", splitAsub, BaseTest.getData().ZipName);
		splitA.put("Subject", comm.emailSubjectline);
		splitA.put("SplitType", "A");
		comm.enterSplitScheduleDate("A");
		comm.splitDetails("B", splitBsub, BaseTest.getData().ZipName);
		splitB.put("Subject", comm.emailSubjectline);
		splitB.put("SplitType", "B");
		comm.enterSplitScheduleDate("B");
		comm.splitDetails("C", splitCsub, BaseTest.getData().ZipNameC);
		splitC.put("Subject", comm.emailSubjectline);
		splitC.put("SplitType", "C");
		comm.enterSplitScheduleDate("C");

		comm.splitAutoScheduleOffValidate();
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
		// precomm.frequencycap().contentbox();
		precomm.preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Scheduled");
	}

}
