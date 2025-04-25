package newaccount_Checklist;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.google.protobuf.TextFormat.ParseException;

import pages.AnalyticsOverviewDetailsPage;
import pages.AudiencePage_Dynamiclist;
import pages.AudiencePage_Targetlist;
import pages.AudiencePage_Upload;
import pages.CommunicationCreatePage;
import pages.CommunicationEmailChannelPage;
import pages.CommunicationMobilePushPage;
import pages.CommunicationNotificationPage;
import pages.CommunicationSMSChannelPage;
import pages.CommunicationWhatsAppPage;
import pages.HomePage;
import pages.PreCommunicationAnalyticsPage;
import pages.PreferencesPage;
import pages.SyncHistoryPage;
import repository.CommunicationRepository;
import repository.DashboardRepository;
import repository.ObjectRepository;
import repository.PreferencesRepository;
import utility.BaseTest;
import utility.DataInputProvider;
import utility.PageBase;

public class NewAccountCreationChecklist extends BaseTest
{

	@Test(testName = "login With Valid Credentials", description = "Login with valid username and password")
	public void loginWithValidCredentials()
	{
		HomePage login = getPageFactory().homePage();

		login.clickAdBlocker();
		login.loginPageContentValidation();
		login.login(login.dPropertyLoginUserName(), login.dPropertyLoginPswrd());
		login.selectbusinessunit();
	}

	@Test(testName = "accessAllMainMenu", description = "Access All Main Menu")
	public void accessAllMainMenu() throws InterruptedException
	{
		AnalyticsOverviewDetailsPage page = getPageFactory().analyticsOverviewDetailsPage();
		CommunicationCreatePage comm = getPageFactory().communicationcreatepage();
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		page.login(page.dPropertyLoginUserName(), page.dPropertyLoginPswrd());
		page.pageLoaderLogo();
		page.explicitwaitforclick(PageBase.autolocator(DashboardRepository.homepage_dashboard_Dashboardlink), 90);
		page.selectbusinessunit();
		page.validateInvalidLinks();

		page.clickAudienceMasterdatafromMenu();
		page.pageLoaderLogo();
		page.validateInvalidLinks();

		page.clickTargetlistfromMenu();
		page.pageLoaderLogo();
		page.validateInvalidLinks();

		dynamic.clickDynamiclistlinkfromMenu();
		page.pageLoaderLogo();
		page.validateInvalidLinks();

		comm.clickCreateCommunicationfromMenu();
		page.pageLoaderLogo();
		page.validateInvalidLinks();

		page.clickCommunicationListpagefromMenu();
		page.pageLoaderLogo();
		page.validateInvalidLinks();

		page.clickCommunicationGallerypagefromMenu();
		page.pageLoaderLogo();
		page.validateInvalidLinks();

		page.clickCommunicationPlannerpagefromMenu();
		page.pageLoaderLogo();
		page.validateInvalidLinks();

		page.clickCommAnalyticsListingPagefromMenu();
		page.pageLoaderLogo();
		page.validateInvalidLinks();

		page.clickCommAnalytics360fromMenu();
		page.pageLoaderLogo();
		page.validateInvalidLinks();

		page.clickLogReportfromMenu();
		page.pageLoaderLogo();
		page.validateInvalidLinks();

		page.clickPreferencePagefromMenu();
		page.pageLoaderLogo();
		page.validateInvalidLinks();
	}

	@Test(testName = "accessAllMenuPreferences", description = "Access All Menu Preferences")
	public void accessAllMenuPreferences()
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.clickPreferencePagefromMenu();

		pref.clickPreferencesMyProfile();
		pref.validateInvalidLinks();
		pref.backbutton();

		pref.clickPreferencesAccountSettingslink();
		pref.validateInvalidLinks();
		pref.backbutton();

		pref.clickPreferencesUserManagementlink();
		pref.validateInvalidLinks();
		pref.backbutton();

		pref.clickPreferencesUserRolelink();
		pref.validateInvalidLinks();
		pref.backbutton();

		pref.clickPreferencesCompanieslink();
		pref.validateInvalidLinks();
		pref.backbutton();

		pref.alertAndNotification();
		pref.validateInvalidLinks();
		pref.backbutton();

		pref.CommSettinglink();
		pref.validateInvalidLinks();
		pref.backbutton();

		pref.offerManagementlink();
		pref.validateInvalidLinks();
		pref.backbutton();

		pref.templateBuilder();
		pref.validateInvalidLinks();
		pref.backbutton();

		pref.clickAudienceScore();
		pref.validateInvalidLinks();
		pref.backbutton();

		pref.accessdataCatalogue();
		pref.validateInvalidLinks();
		pref.backbutton();

		pref.accessdataExchange();
		pref.validateInvalidLinks();
		pref.backbutton();

		pref.accessConsumption();
		pref.validateInvalidLinks();
		pref.backbutton();

		pref.accessInvoices();
		pref.validateInvalidLinks();
		pref.backbutton();

		pref.accessLicenseinfo();
		pref.validateInvalidLinks();
		pref.backbutton();
	}

	@Test(testName = "UserRoles", description = "Users Roles ")
	public void UserRoles() throws AWTException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();

		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.clickPreferencePagefromMenu().clickUserroles();
		pref.userrolesvaldiation();
		String UserRole = pref.getStrText(PreferencesRepository.Preferences_Userroles1);
		switch (UserRole)
		{
		case "User" -> {
			pref.Readprivilegevalidation("User");
			pref.updateprivilegevalidation("User");
			pref.createprivilegevalidation("User");
		}
		case "Superuser" -> {
			pref.Readprivilegevalidation("Superuser");
			pref.updateprivilegevalidation("Superuser");
			pref.createprivilegevalidation("Superuser");
		}
		case "Admin" -> {
			pref.Readprivilegevalidation("Admin");
			pref.updateprivilegevalidation("Admin");
			pref.createprivilegevalidation("Admin");
		}
		default -> {
			BaseTest.getTest().log(Status.FAIL, "User role not Present");
		}
		}
	}

	@Test(testName = "audienceUploadTargetListSingleCSV", description = "Target list Upload")
	public void audienceUploadTargetListSingleCSV() throws IOException, InterruptedException, AWTException
	{
		Map<String, String> importtypes = new HashedMap<String, String>();
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();
//		AudienceDatabase db = getPageFactory().audienceDatabase();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu().clickAddaudience();
		audi.selectImportsource();
		String importType = audi.selectListtype();
		audi.attributeMapping();
		audi.ImportDescription = audi.enterImportdesc();
		audi.audience_upload_File(BaseTest.getData().Chooseyourfile1);
		audi.clickUpload();
		audi.segmentationPageValidate();
		audi.selectDoubleOptchkbox();
		audi.clicksave().returntomasterlist();
		importtypes.put(importType, audi.ImportDescription);
		audi.importHistory(audi.ImportDescription);
		DataInputProvider.writeUpdatedValueInSheet(1, 0, "NewAccountCreationChecklist", "BaseData", audi.ImportDescription);
	}

	@Test(testName = "audienceUploadSeedListSingleCSV", description = "Seed List Upload")
	public void audienceUploadSeedListSingleCSV()
	{
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu().clickAddaudience();
		audi.selectImportsource();
		audi.selectListtype();
		String ImportDescription = audi.enterImportdesc();
		audi.audience_upload_File(BaseTest.getData().Chooseyourfile1);
		audi.clickUploadAndValidate();
		audi.segmentationPageValidate();
		audi.selectDoubleOptchkbox();
		audi.clicksave().returntomasterlist();
		PageBase.threadSleep(ObjectRepository.wait5sec);
		audi.importHistory(ImportDescription);
		DataInputProvider.writeUpdatedValueInSheet(1, 4, "NewAccountCreationChecklist", "BaseData", "SL_" + ImportDescription);
		getPageFactory().audiencepage_Targetlist().targetListSearchResult("SL_" + ImportDescription);

	}

	@Test(testName = "targetListCreateAndValidate", description = "Target list creation")
	public void targetListCreateAndValidate()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());

		trgt.selectbusinessunit();
		trgt.getTotalAudienceCountFromMDM();
		trgt.clickTargetlistfromMenu().clickNewListSegment();
		trgt.enterTargetListName();
		String AttributeType = BaseTest.getData().AttributeType;
		String SelectAttribute = BaseTest.getData().SelectAttribute;
		String FilterListBox = BaseTest.getData().FilterListBox;
		String AttributeValueNew = BaseTest.getData().AttributeValueNew;
		String AttributeValueOld = BaseTest.getData().AttributeValueOld;
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
	}

	@Test(testName = "duplicateTargetList", description = "Duplicate TargetList")
	public void duplicateTargetList()
	{

		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
		String targetListNew = BaseTest.getData().TargetListNew, dupTargetListName = "Dup_" + targetListNew;

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());

		trgt.selectbusinessunit();
		trgt.getTotalAudienceCountFromMDM();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList(targetListNew);

		trgt.duplicateTargetlist(targetListNew, dupTargetListName);
		trgt.searchTargetList(dupTargetListName);
		DataInputProvider.writeUpdatedValueInSheet(1, 2, "NewAccountCreationChecklist", "BaseData", dupTargetListName);

	}

	@Test(testName = "editAndVerifyTargetList", description = "Edit and verify targetList")
	public void editAndVerifyTargetList()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();

		String targetListNew = BaseTest.getData().TargetListNew;

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList(targetListNew);
		trgt.editTargetListName(targetListNew);
		trgt.createTargetList().saveTargetList();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList("edit_" + targetListNew);
	}

	@Test(testName = "targetListOneApproveRfaAll", description = "Target list RFA Approve")
	public void targetListOneApproveRfaAll()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
		String AttributeType = BaseTest.getData().AttributeType;
		String SelectAttribute = BaseTest.getData().SelectAttribute;
		String FilterListBox = BaseTest.getData().FilterListBox;
		String AttributeValueNew = BaseTest.getData().AttributeValueNew;
		AttributeValueNew = "TrgtNewAttribute951044505";
		String AttributeValueOld = BaseTest.getData().AttributeValueOld;
		String approver = System.getProperty("Target_Dynamic_approver1_webmail_Uname");

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
		trgt.clickRfaCheckbox();
		trgt.selectTargetListRfa(1, approver);
		trgt.createTargetList().saveTargetList();
		trgt.logout();
		trgt.openLoginPage().login(approver, "Resul@123");
		trgt.selectbusinessunit();
		String link = trgt.getRfaTargetListLink(approver);
		trgt.approveRfa(link);
		trgt.logout();
		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList(trgt.targetListName);
	}

	@Test(testName = "DynamiclistCreation", description = "Create new dynamicList using Target list")
	public void DynamiclistCreation() throws InterruptedException
	{
		// pages.DynamiclistCreatePage dynamic =
		// getPageFactory().DynamiclistCreatePage();
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		SyncHistoryPage sync = getPageFactory().syncHistoryPage();
		sync.login(sync.dPropertyLoginUserName(), sync.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.ruleType();
		dynamic.firstDynamicApprover(PageBase.audience_approver1).clickCreateAndSaveTrigger(EnterDynamiclistName);
		// dynamic.searchDynamicValue(EnterDynamiclistName);
		dynamic.logout();
		// dynamic.webURLlaunch();
		dynamic.teamWebUrlLaunch();
		dynamic.teamWebmailLogin(System.getProperty("Target_Dynamic_approver1_webmail_Uname"), System.getProperty("Target_Dynamic_approver1_webmail_pswrd"));
		// dynamic.target_Dynamic_approver1_Webmail_login();
		String rfalink = dynamic.getDynamicListRFAApprovalMailLink(EnterDynamiclistName);
		dynamic.teamWebmailLogout();
		dynamic.openLoginPage().target_Dynamic_approver1_login();
		dynamic.selectbusinessunit();
		BaseTest.getWebDriver().get(rfalink);
		dynamic.clickTargetDynamicRFAApproveBtn();
//			dynamic.targetlistUsingdynamicListRetainValidate(EnterDynamiclistName);
		// dynamic.searchDynamicValue(EnterDynamiclistName);
		getPageFactory().audienceDatabase().rfaApproverStatus("dynamic", EnterDynamiclistName, PageBase.audience_approver1, 1, false, false, true);
		getPageFactory().audienceDatabase().targetDynamicRFAStatus("dynamic", EnterDynamiclistName, true);
		getPageFactory().audienceDatabase().dynamicListDBVerification(EnterDynamiclistName);
		DataInputProvider.writeUpdatedValueInSheet(1, 3, "NewAccountCreationChecklist2", "BaseData", EnterDynamiclistName);

	}

	@Test(testName = "DynamicList Using Web Based ", description = "Website Device")
	public void DynamicListUsingWebsiteDevice() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.ruleType();
		dynamic.firstDynamicApprover(PageBase.audience_approver1).clickCreateAndSaveTrigger(EnterDynamiclistName);
	}

	@Test(testName = "DynamicList Using Mobile Based ", description = "Mobile Device")
	public void DynamicListUsingMobileDevice() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.ruleTypeMobile();
		dynamic.firstDynamicApprover(PageBase.audience_approver1).clickCreateAndSaveTrigger(EnterDynamiclistName);
	}

	@Test(testName = "DynamicListDuplicateEdit", description = "DynamicList Duplicate and Edit")
	public void DynamicListDuplicateEdit() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		System.out.println(EnterDynamiclistName);

		String duplicatename = "Dup" + EnterDynamiclistName;
		// dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.ruleType();

		dynamic.firstDynamicApprover(PageBase.audience_approver1).clickCreateAndSaveTrigger(EnterDynamiclistName);
		dynamic.duplicateDynamicList(EnterDynamiclistName, duplicatename);
		dynamic.editDynamicList(EnterDynamiclistName);
		// DataInputProvider.writeUpdatedValueInSheet(1, 3, "NewAccountCreationChecklist2", "BaseData", EnterDynamiclistName);

	}

	@Test(testName = "configurationSettingsNotificationVerify", description = "Validate alerts and notification - Configuration Settings notifications")
	public void configurationSettingsNotificationVerify() throws InterruptedException, ParseException, java.text.ParseException
	{

		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.alertandnotificationClick();
		if (!pref.toggleButtonState("Configuration settings"))
		{
			pref.clickAlertsandNotificationToggleButton("Configuration settings");
		}
		pref.clickPreferencePagefromMenu();
		pref.clickCommunicationSettings();
		PageBase.threadSleep(ObjectRepository.wait5sec);
		pref.clickElement("sub/unsub,xpath,//i[@class='icon-rs-email-sub-unsub-large icon-lg color-primary-blue']//..//span[.='Sub / Unsub']");
		// pref.threadSleep(5000);
		pref.pageLoaderLogo();
		pref.clickElement("edit sub,xpath,(//i[@id='rs_data_pencil_edit'])[1]");
		pref.pageLoaderLogo();
		PageBase.threadSleep(ObjectRepository.wait3sec);
		pref.javaScriptScrollDown();
		pref.clickElement("Update sub,xpath,//button[@id='rs_SubscriptionCreate_Submit']");
		pref.clickElement("subpopup click,xpath,//div[@class='buttons-holder']//button[.='Save']");
		pref.pageLoaderLogo();
		pref.explicitwaitforvisibility(PageBase.autolocator("edit unsub,xpath,//i[@class='icon-rs-email-sub-unsub-large icon-lg color-primary-blue']//..//span[.='Sub / Unsub']"), 20);
		pref.notificationsPageChangesUpdateVerify("Subscription details has been modified");
	}

	@Test(testName = "alertsandnotification", description = "Validate alerts and notification ")
	public void alertsandnotification() throws InterruptedException, ParseException, java.text.ParseException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.alertandnotificationClick();
		if (!pref.toggleButtonState("Profile and account settings notifications"))
		{
			pref.clickAlertsandNotificationToggleButton("Profile and account settings notifications");
		}
		pref.preferenceModuleClick();
		pref.myprofileValidate();
		pref.notificationsPageChangesUpdateVerify("profile has been updated");
	}

	@Test(testName = "emailEventTriggerDaily", description = "Event trigger communication Daily - Email")
	public void emailEventTriggerDaily()
	{
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();

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
		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		WebElement element = getWebDriver().findElement(By.xpath("(//button[normalize-space()='Next'])[1]"));
		element.click();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Scheduled");
		comm.pauseEventTriggCommunicationinlistingpage();
		comm.playEventTriggCommunicationinlistingpage();
		comm.stopEventTriggCommunicationinlistingpage();

	}

	@Test(testName = "smsEventTriggerDaily", description = "Event trigger communication Daily - SMS")
	public void smsEventTriggerDaily()
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();

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
		comm.explicitwaitforclick(PageBase.autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 20);
		comm.javaScriptScrollDown();
		comm.clickElement("Web analytics,xpath,//i[contains(@class,'icon-rs-web-analytics-large icon-lg')]");
		PageBase.threadSleep(ObjectRepository.wait2sec);
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Scheduled");
		comm.pauseEventTriggCommunicationinlistingpage();
		comm.playEventTriggCommunicationinlistingpage();
		comm.stopEventTriggCommunicationinlistingpage();
	}

	@Test(testName = "WhatsappEventTriggerDaily", description = "Event trigger communication Daily - Whatsapp")
	public void WhatsappEventTriggerDaily() throws AWTException
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		CommunicationWhatsAppPage whatsApp = getPageFactory().communicationWhatsAppPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();

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
		comm.singleDimensionregression("not roi");
		comm.clickNext();
		BaseTest.takeScreenshot();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		// comm.whats
		// comm.clickNext();
		whatsApp.whatsAppSenderName();

		whatsApp.whatsAppTemplate(BaseTest.getData().ZipNameB);
		whatsApp.enterWhatsAppContentwithPersonalization();
		comm.javaScriptScrollDown();
		whatsApp.whatsAppPreview();
		comm.javaScriptScrollDown();
		comm.clickNextemail();
		comm.pageLoaderLogo();
		comm.javaScriptScrollDownToSomeExtend();
		comm.clickNextemail();
		comm.pageLoaderLogo();
		PageBase.threadSleep(ObjectRepository.wait5sec);
		comm.explicitwaitforvisibility(PageBase.autolocator(CommunicationRepository.authoringpage_provider), 20);
		// comm.clickNextemail();
		PageBase.threadSleep(ObjectRepository.wait2sec);
		// comm.clickElement(",xpath,//button[.='Ok']");
		comm.javaScriptScrollDown();
		comm.clickElement(CommunicationRepository.authoringpage_webanalytics);
		PageBase.threadSleep(ObjectRepository.wait2sec);
		comm.clickOk();
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Scheduled");
		comm.pauseEventTriggCommunicationinlistingpage();
		comm.playEventTriggCommunicationinlistingpage();
		comm.stopEventTriggCommunicationinlistingpage();
	}

	@Test(testName = "webpushEventTriggerDaily", description = "Event trigger communication Daily - Webpush")
	public void webpushEventTriggerDaily() throws AWTException, InterruptedException
	{
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		CommunicationNotificationPage web = getPageFactory().communication_Notification();

		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.eventTriggComm(startDate, endDate);
		comm.channelType3().analyticOption2();
		comm.clickFrequency("Daily");
		comm.getTimeForDaily("1");
		comm.singleDimensionregression("not roi");
		comm.clickNext();
		BaseTest.takeScreenshot();
		comm.createSmarturl();
		web.selectUrltosendWebPush();
		web.selectWebPushDeliveryType();
		web.webpushTextTitle();
		web.commWebPushpersona();
		web.wpImageURL();
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
		comm.communicationlistingPageStatusCompare("Scheduled");
		comm.pauseEventTriggCommunicationinlistingpage();
		comm.playEventTriggCommunicationinlistingpage();
		comm.stopEventTriggCommunicationinlistingpage();
		comm.gallerycommunicationtype("Web notificatio");
		comm.gallerycommunicationSearch(comm.communicationName, "edit");
		comm.gallerycommunicationSearch(comm.communicationName, "duplicate");

	}

	@Test(testName = "mobilePushEventTriggerDaily", description = "Event trigger communication Daily - MobilePush")

	public void mobilePushEventTriggerDaily() throws AWTException
	{
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		CommunicationMobilePushPage web = getPageFactory().communicationMobilePushPage();

		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.eventTriggComm(startDate, endDate);
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
		web.mpImageURL();
		web.mobilepushSetInteractivity();
		web.mobilepushSetExpiry();
		web.mobilepushAlert();
		PageBase.scrollDown();
		comm.clickNextemail();
		comm.pageLoaderLogo();

		precomm.webAnalyticsDetails().mobileAppAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Scheduled");
		comm.pauseEventTriggCommunicationinlistingpage();
		comm.playEventTriggCommunicationinlistingpage();
		comm.stopEventTriggCommunicationinlistingpage();
	}

	@Test(testName = "formsGenerator", description = "Form Generator")
	public void formsGenerator() throws InterruptedException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.pw_login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.pw_selectbusinessunit();
		pref.pw_preferenceModuleClick();
		pref.pw_templateBuilderClick();
		pref.pw_formsclick("Resul form");
		pref.addFormBuilder();
		pref.surveyForm();
		pref.subscriptionForm();
		pref.FieldValidation();
	}

	@Test(description = "Forms generator csv download check")
	public void formCsvDownload() throws InterruptedException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		String formName = "Test" + pref.addTimeToName();
		// Page page = getPlayWright();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.templateBuilderClick();
		pref.formCSVdownload(formName);

	}

	@Test(description = "Consumptions Email validation and check")
	public void consumptionsEmail() throws InterruptedException, AWTException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.consumptionsClick();
		pref.consumptionSmsCheck("Email");
	}

	@Test(description = "Consumptions Sms validation and check")
	public void consumptionsSms() throws InterruptedException, AWTException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.consumptionsClick();
		pref.consumptionSmsCheck("SMS");

	}

	@Test(description = "Consumptions Web push notification validation and check")
	public void consumptionsWebpush() throws InterruptedException, AWTException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.consumptionsClick();
		pref.consumptionSmsCheck("Web push");

	}

	@Test(description = "Consumptions Mobile push notification validation and check")
	public void consumptionsMobilepush() throws InterruptedException, AWTException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.consumptionsClick();
		pref.consumptionSmsCheck("Mobile push");

	}

	@Test(description = "Consumptions QR validation and check")
	public void consumptionsQR() throws InterruptedException, AWTException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.consumptionsClick();
		pref.consumptionSmsCheck("QR");
	}

	@Test(description = "Consumptions WhatsApp validation and check")
	public void consumptionsWhatsApp() throws InterruptedException, AWTException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.consumptionsClick();
		pref.consumptionSmsCheck("WhatsApp");
	}

	@Test(description = "Access All Menu in Communication Listing Page")
	public void allmenuincommunication()
	{
		CommunicationCreatePage comm = getPageFactory().communicationcreatepage();
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCommunicationListpagefromMenu();
		comm.accessCommunicationListingpage();
	}
}
