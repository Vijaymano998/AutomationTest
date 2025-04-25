package featurewise_Checklist;

import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;

import pages.AudiencePage_Dynamiclist;
import pages.AudiencePage_Targetlist;
import pages.CommunicationEmailChannelPage;
import pages.CommunicationQRChannelPage;
import pages.CommunicationSMSChannelPage;
import pages.PreCommunicationAnalyticsPage;
import pages.PreferencesPage;
import repository.AudienceRepository;
import repository.CommunicationRepository;
import repository.ObjectRepository;
import utility.BaseTest;
import utility.DataInputProvider;
import utility.PageBase;

public class FeaturewiseChecklist extends BaseTest
{

	@Test(testName = "Target List Reach Rate Validation", description = "Target List Reach Rate Validation")
	public void targetListReachRateValidation()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		String AttributeType = BaseTest.getData().AttributeType;
		String SelectAttribute = BaseTest.getData().SelectAttribute;
		String FilterListBox = BaseTest.getData().FilterListBox;
		String AttributeValueNew = BaseTest.getData().AttributeValueNew;
		String AttributeValueOld = BaseTest.getData().AttributeValueOld;

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());

		trgt.selectbusinessunit();
		trgt.getTotalAudienceCountFromMDM();
		trgt.clickTargetlistfromMenu().clickNewListSegment();
		trgt.enterTargetListName();
		trgt.searchAndSelectAttribute(SelectAttribute);
		if (!trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueNew))
		{
			trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueOld);
		}
		trgt.clickHereToGetCount(SelectAttribute);
		trgt.targetSegmentationCountCheck();
		trgt.createTargetList();
		trgt.saveTargetList();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList(trgt.targetListName);
		DataInputProvider.writeUpdatedValueInSheet(1, 1, "NewAccountCreationChecklist", "BaseData", trgt.targetListName);
		String targetList = (PageBase.shortListName == null) ? trgt.targetListName : PageBase.shortListName;
		if (trgt.isDisplayed("List extraction,xpath,(//span[.='" + targetList + "']//ancestor::div[contains(@class,'rs-card-bottom')]//div[@class='rci-content-block']//span)[1]"))
		{
			trgt.refresh();
			trgt.searchTargetList(trgt.targetListName);
		}
		int communicationexecuted = trgt.getcommunicationcount(targetList);
		if (communicationexecuted == 0)
		{
			trgt.inforeach(communicationexecuted, targetList);
			String reacgrateststus = trgt.getStrText("Reach Rate Status,xpath,(//span[.='" + targetList + "']//ancestor::div[contains(@class,'rs-card-bottom')]//span[@class='rcit-avg']//span)[1]");
			if (reacgrateststus.contains("Projected"))
			{
				BaseTest.getTest().info("Reach Rate status is displayed as expexted " + reacgrateststus);
				String reachratepercentage = trgt.getStrText("Reach Rate percentage,xpath,//span[.='" + targetList + "']//ancestor::div[contains(@class,'rs-card-bottom')]//div[@class='rstr-cell rstrc-right']//div[@class='rcit-number']/span[1]");
				if (reachratepercentage.contains("NA"))
				{
					BaseTest.getTest().info("Reach Rate is displayed as expexted " + reachratepercentage);
					BaseTest.takeScreenshot();
				} else
				{
					BaseTest.getTest().fail("Reach Rate is not displayed as expexted " + "Actuall " + reachratepercentage + "Expected" + "NA");
					BaseTest.takeScreenshot();
				}
			} else
			{
				BaseTest.getTest().fail("Reach Rate status is not displayed as expexted " + reacgrateststus);
				BaseTest.takeScreenshot();
			}
		}
		for (int i = 0; i <= 5; i++)
		{
			int startDate = 0;
			int endDate = 3;
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
			comm.explicitwaitforclick(PageBase.autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 20);
			comm.javaScriptScrollDown();
			comm.clickElement(CommunicationRepository.authoringpage_webanalytics);
			comm.pageLoaderLogo();
			precomm.webAnalyticsDetails().preCommunicationPage();
			comm.communicationlistingPageStatusCompare("Scheduled");
			PageBase.threadSleep(ObjectRepository.wait20sec);
			trgt.refresh();
			trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList(trgt.targetListName);
			communicationexecuted = trgt.getcommunicationcount(targetList);
			trgt.getcommunicationreahrate(communicationexecuted, i, targetList);
		}
	}

	@Test(description = "QR communication Image Upload ,image size and short url Verification")
	public void QRimageuploadSize()
	{
		CommunicationQRChannelPage qr = getPageFactory().communicationqrchannelpage();
		int startDate = 0;
		int endDate = 3;
		qr.login(qr.dPropertyLoginUserName(), qr.dPropertyLoginPswrd());
		qr.selectbusinessunit();
		qr.clickCreateCommunicationfromMenu();
		qr.singleDimensionComm(startDate, endDate);
		qr.selectQRChannel().analyticOption2().clickNext();
		qr.createSmarturl();
		qr.imageuploadvalidation();
		qr.imagesizeslide();
		qr.shorturl();
		// qr.javaScriptScrollDownToSomeExtend();
		qr.javaScriptScrollDown();
		qr.clickSaveqrPage();
	}

	@Test(description = "QR Redirectional url verification")
	public void QRredirectionalurl()
	{
		CommunicationQRChannelPage qr = getPageFactory().communicationqrchannelpage();

		qr.login(qr.dPropertyLoginUserName(), qr.dPropertyLoginPswrd());
		qr.selectbusinessunit();
		qr.clickCommunicationListpagefromMenu();
		qr.searchCommunication("communicationlisting", "QRCodeTesting-Feb20");
		qr.communicationName = "QRCodeTesting-Feb20";
		qr.editcomm();
		qr.javaScriptScrollDown();
		qr.clickNext();
		qr.smartUrlpopupCancel();
		qr.redirectionalqrscan();
	}

	@Test(testName = "Dynamic list Edit", description = "Dynamic list edit")

	public void dynamicListEdit() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		// dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.ruleType();
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		// dynamic.searchDynamicValue(EnterDynamiclistName);
		dynamic.logout();
		dynamic.webURLlaunch();
		dynamic.target_Dynamic_approver1_Webmail_login();
		String rfalink = dynamic.getDynamicListRFAApprovalMailLink(EnterDynamiclistName);
		dynamic.webMailDelete();
		dynamic.openLoginPage().target_Dynamic_approver1_login();
		// dynamic.selectbusinessunit();
		BaseTest.getWebDriver().get(rfalink);
		Thread.sleep(5000);
		dynamic.clickTargetDynamicRFAApproveBtn();
		dynamic.searchDynamicListUsingListName(EnterDynamiclistName);

		/*
		 * dynamic.ruleType(); dynamic.firstDynamicApprover("resuluser50@resul.team"); dynamic.clickCreateAndSaveTrigger();
		 */

		dynamic.editDynamicist();

	}

	@Test(testName = "Dynamic List duplicate", description = "Dynamic duplicate")
	public void dynamicListDuplicate() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		String DuplicateDynamicName = BaseTest.getData().DuplicatedDynamiclist + dynamic.addTimeToName().replaceAll("_", "");
		dynamic.selectTriggerValues();
		dynamic.ruleType();
		dynamic.firstDynamicApprover("resuluser50@resul.team");
		dynamic.clickCreateAndSaveTrigger();
		dynamic.searchDynamicListUsingListName(EnterDynamiclistName);
		dynamic.duplicateDynamic(EnterDynamiclistName);
		// dynamic.duplicateDynamicList(EnterDynamiclistName, DuplicateDynamicName);
		dynamic.searchDynamicListUsingListName(DuplicateDynamicName);

	}

	@Test(testName = "Advance Search", description = "Advance Search")
	public void advanceSearch() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.ruleType();
		dynamic.firstDynamicApprover("resuluser50@resul.team");
		dynamic.clickCreateAndSaveTrigger();
		dynamic.searchDynamicListUsingListName(EnterDynamiclistName);

	}

	@Test(testName = "Dynamic list - Grid view", description = "Grid view - Dynamic list")

	public void dynamicGridView()
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.pw_login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.pw_selectbusinessunit();
		Page page = getPlayWright();
		// page.pause();
		dynamic.pw_clickElement(AudienceRepository.pw_audiencelinkclick);
		page.waitForLoadState(LoadState.LOAD);
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Dynamic lists")).click();
		page.waitForLoadState(LoadState.LOAD);
		dynamic.pw_validateGridView();
		dynamic.pw_validateListView();

	}

	@Test(testName = "Dynamic list using Subscription form", description = "Subscription form")

	public void dynamicSubscriptonForm() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.pw_login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.pw_selectbusinessunit();
		Page page = getPlayWright();
		// page.pause();

		dynamic.pw_clickElement(AudienceRepository.pw_audiencelinkclick);
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Dynamic lists")).click();
		page.locator("#rs_data_circle_plus_fill_edge").click();
		page.getByPlaceholder(" ").click();
		dynamic.pw_enterListName();
		page.getByText("List nameEnter the list name *Rule GroupMatch typeAllAnyTrigger sourceTrigger").click();
		page.getByText("List nameEnter the list name *Rule GroupMatch typeAllAnyTrigger sourceTrigger").click();
		page.getByLabel("Trigger source").locator("span").nth(1).click();
		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​Subscription Form")).click();
		page.getByLabel("Rule type").locator("span").nth(1).click();
		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​Forms")).click();
		page.getByLabel("Form name").locator("span").nth(1).click();
		page.getByText("AutoTest123455").click();
		page.getByLabel("Form status").locator("span").nth(1).click();
		page.getByText("Submitted", new Page.GetByTextOptions().setExact(true)).click();
		page.getByLabel("Request for approval").check();
		page.getByLabel("Approver").locator("span").nth(1).click();
		page.getByText("testing new (resuluser5744@").click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create rule")).click();
		dynamic.pw_clickElement(AudienceRepository.pw_audiencelinkclick);
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Dynamic lists")).click();
		page.locator(".icon-rs-circle-list-edge-large").click();
		page.waitForLoadState(LoadState.LOAD);
		dynamic.pw_CreatedList(BaseTest.getData().EnterDynamiclistName);

	}

	@Test(testName = "DynamicList Using Website Device ", description = "Dynamic - Website Device")
	public void DynamicListUsingWebsiteDevice() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.ruleType();
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();

	}

	@Test(testName = "Executed comunication", description = "Executed communication")
	public void CommunicationExecuted() throws InterruptedException
	{

		int startDate = 0;
		int endDate = 3;
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		String DuplicateDynamicName = BaseTest.getData().DuplicatedDynamiclist + dynamic.addTimeToName().replaceAll("_", "");
		dynamic.selectTriggerValues();
		dynamic.ruleType();
		dynamic.firstDynamicApprover("resuluser50@resul.team");
		dynamic.clickCreateAndSaveTrigger();
		comm.clickCreateCommunicationfromMenu();
		comm.eventTriggComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickFrequency("Daily");
		comm.getTimeForDaily("1");
		comm.clickNext();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		dynamic.enternewsenderid();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport().selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.saveAuthoringPage();
		dynamic.clickDynamiclistlinkfromMenu();
		dynamic.searchDynamicListUsingListName(EnterDynamiclistName);
		dynamic.executedCommunication(DuplicateDynamicName);
	}

	@Test(testName = "Dynamic Mobile app", description = "Dynamic list mobile app")
	public void DynamicMobileApp() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.triggerMobApp(BaseTest.getData().TriggerTypeNew);
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
	}

	@Test(testName = "Dynamic target list", description = "Dynamic - target list")
	public void DynamicUsingTargetList() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
	}

	@Test(testName = "Dynamic - Audience base", description = "Dynamic - Audience base")
	public void DynamicUsingAudienceBase() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
	}

	@Test(testName = "Dynamic - Date filter", description = "Dynamic - Date filter")
	public void DynamicDateFilter() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		dynamic.filterDynamicListTimePeriod();

	}

	@Test(testName = "Dynamic - Grid view", description = "Dynamic -Grid view")

	public void DynamicGridViewValidation() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		dynamic.validateGridView();
	}

	@Test(description = "Preferences Users Management ")

	public void userManagement()
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.clickPreferencePagefromMenu();
		pref.clickusermanagement();
		pref.usermanagementValidation(BaseTest.getData().MobileNo, BaseTest.getData().enterEmail, BaseTest.getData().userJobFunction);

	}

}
