package regression_Preferences;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;

import org.testng.annotations.Test;

import pages.AudiencePage_Upload;
import pages.CommunicationEmailChannelPage;
import pages.PreferencesPage;
import repository.ObjectRepository;
import repository.PreferencesRepository;
import utility.BaseTest;
import utility.PageBase;

public class PreferencesRegression extends BaseTest
{
	@Test(description = "Preferences Users Roles ")

	public void preferencesUserroles() throws AWTException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		String domainName = "UserRoletest" + pref.addTimeToName().replaceAll("_", "");
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.clickPreferencePagefromMenu().clickUserroles();
		pref.userrolesvaldiation();
		pref.createNewRole(domainName);
//		pref.deleteuserrole(role);
		pref.exisitinguservalidation(domainName);
		pref.Readprivilegevalidation("User");
		pref.Readprivilegevalidation("Superuser");
		pref.Readprivilegevalidation("Admin");
		pref.updateprivilegevalidation("User");
		pref.updateprivilegevalidation("Superuser");
		pref.updateprivilegevalidation("Admin");
		pref.createprivilegevalidation("User");
		pref.createprivilegevalidation("Superuser");
		pref.createprivilegevalidation("Admin");
	}

	@Test(description = "Preferences Users Management ")

	public void userManagement()
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserNameUserManage(), pref.dPropertyLoginPswrdUserManage());
		pref.selectbusinessunit();
		pref.clickPreferencePagefromMenu();
		pref.clickusermanagement();
		pref.usermanagementValidation(BaseTest.getData().MobileNo, BaseTest.getData().enterEmail, BaseTest.getData().userJobFunction);

	}

	@Test(description = "Preferences Communication Email Setting")

	public void communicationSmtpSetting()
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.clickPreferencePagefromMenu();
		pref.clickCommunicationSettings();
		pref.communicationEmailvalidation();

	}

	@Test(description = "Preferences Communication SMPP Setting")

	public void communicationSmppSetting()
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.clickPreferencePagefromMenu();
		pref.clickCommunicationSettings();
		pref.communicationSmppvalidation();

	}

	@Test(description = "Preferences Communication Whatsapp validation")
	public void communicationWhatsappsetting()
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.clickPreferencePagefromMenu();
		pref.clickCommunicationSettings();
		pref.commSettingswhatsappValidation("Gupshup");
	}

	@Test(description = "Preferences My Profile validation ")
	public void preferencesMyprofile() throws InterruptedException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.clicMyProfile();
		pref.personaldetailsValidations();
//1
		String newPassword = "QA" + pref.dPropertyLoginPswrd();
		pref.changepasswrd(pref.dPropertyLoginPswrd(), newPassword);
		String pwind = pref.parentWinHandle();
		pref.javaScriptopenNewWindow();
		pref.switchWindow();
		String OTP = pref.webURLlaunch().accountMyProfileWebmailLogin().getChangePswdOTP();
		pref.switchParentWin(pwind);
		pref.changePasswordOTP1(OTP).logout();
//2
		pref.loginwithoutplugin(pref.dPropertyLoginUserName(), newPassword);
		pref.selectbusinessunit();
		pref.clicMyProfile();//pageloader
		pref.pageLoaderLogo();
		pref.changepasswrd(newPassword, pref.dPropertyLoginPswrd());
		pref.switchToSpecificWindow(1);
		String otp1 = pref.getChangePswdOTP();
		pref.switchParentWin(pwind);
		pref.changePasswordOTP1(otp1).updateButton();
	}

	@Test(description = "Preferences Communication settings webpush validation")
	public void communicationSettingsWeb() throws InterruptedException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.clickCommunicationSettings();
		pref.webNotificationAnalyticsAdd();
		pref.webNotidropdwnValues();
		pref.goalWebpushComm();

	}

	@Test(description = "Preferences Communication settings mobilepush validation")
	public void communicationSettingsMobile() throws InterruptedException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.clickCommunicationSettings();
		pref.CommsettNotificationMobile("Native");
		pref.mobileSettings();
		pref.notificationGoalMobile();
	}

	//////////////////// RESUL 5.0/////////////////////////////////////////////
	@Test(description = "Preferences Data catalogue")
	public void DataCatalogue() throws InterruptedException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.dataCatalogueClick();
		pref.attricolorvalidation();
		pref.datacatalogueAttributeSelection1("Filter groups");
		//pref.dataCatalogueClick();
		pref.datacatalogueAttributeSelection1("Classification");

	}

	@Test(description = "Data catalogue CSV Download")
	public void DataCatalogueCsvDownload() throws InterruptedException, IOException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();

		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.dataCatalogueClick();
		pref.DatacatalogueCsvdownload();

	}

	// protected WebDriver driver;

	@Test(description = "Data catalogue CSV grid validation and Download")
	public void GridviewTableValidation() throws InterruptedException, IOException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.dataCatalogueClick();
		Thread.sleep(5000);
		pref.PageWebtableValidation("");
		// List<Map<String, String>> datacatalogueGridData =
		// pref.datacatalogueGridData();
	}

	///////////////// alerts and notifications starts////////////////////

	@Test(description = "Alerts and Notifications toggle button ON&OFF Validation")

	public void alertAndnotifications() throws InterruptedException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.alertandnotificationClick();
		pref.alertandnotificationOnOfftogglebutton();

	}

	@Test(description = "Validate alerts and notification - Profile and account settings notifications")
	public void profileAndAccountSettingsNotificationVerify() throws InterruptedException, ParseException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.alertandnotificationClick();
		pref.clickAlertsandNotificationToggleButton("Profile and account settings notifications");
		pref.preferenceModuleClick();
		pref.myprofileValidate();
		pref.notificationsPageChangesUpdateVerify("Test Profile has been Updated");
	}

	@Test(description = "Validate alerts and notification - audience segmentation notifications")
	public void audienceImportAndSegmentationNotificationVerify() throws InterruptedException, ParseException, java.text.ParseException
	{
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.alertandnotificationClick();
		pref.clickAlertsandNotificationToggleButton("Audience import and segmentation");
		audi.clickAudienceMasterdatafromMenu().clickAddaudience();
		String uploadformat = pref.selectImportsourceTrgt();
		String importType = audi.selectListtype();
		audi.attributeMapping();
		String enterImportdesc = audi.enterImportdesc();
		audi.audience_upload_File(BaseTest.getData().Chooseyourfile1);
		audi.clickUpload();
		audi.segmentationPageValidate();
		audi.selectDoubleOptchkbox();
		audi.clicksave().returntomasterlist();
		pref.notificationsPageChangesUpdateVerify("Audience Import : "+audi.ImportDescription+" - Import process has been co...");	}


	@Test(description = "Validate alerts and notification - Configuration Settings notifications")

	public void configurationSettingsNotificationVerify() throws InterruptedException, ParseException
	{
      
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.alertandnotificationClick();
		pref.clickElement(PreferencesRepository.preferences_alertandnotification_paginationSize);
		pref.threadSleep(ObjectRepository.wait3sec);
		pref.selectlistelements(PreferencesRepository._preferences_alertandnotification_pagination, "10");
		if(!pref.isElementPresent(PreferencesRepository.preferences_alertandnotification_tooglebutton)) {

			pref.clickElement(PreferencesRepository.preferences_alertandnotification_nextbutton);
			pref.pageLoaderLogo();
		}
		if (!pref.toggleButtonState("Configuration settings"))
		{
			pref.clickAlertsandNotificationToggleButton("Configuration settings");
		}
		pref.clickPreferencePagefromMenu();
		pref.clickCommunicationSettings();
		pref.clickElement("sub/unsub,xpath,//i[@class='icon-rs-email-sub-unsub-large icon-lg color-primary-blue']//..//span[.='Sub / Unsub']");
		pref.pageLoaderLogo();
		pref.clickElement("edit sub,xpath,(//i[@id='rs_data_pencil_edit'])[1]");
		pref.pageLoaderLogo();
		PageBase.threadSleep(ObjectRepository.wait3sec);
		pref.javaScriptScrollDown();
		pref.clickElement("Update sub,xpath,//button[@id='rs_SubscriptionCreate_Submit']");
		pref.clickElement("subpopup click,xpath,//div[@class='buttons-holder']//button[.='Save']");	
		pref.pageLoaderLogo();
		pref.explicitwaitforvisibility(PageBase.autolocator("edit unsub,xpath,//i[@class='icon-rs-email-sub-unsub-large icon-lg color-primary-blue']//..//span[.='Sub / Unsub']"), 20);
		pref.notificationsPageChangesUpdateVerify("Subscribe settings has been added.");

	}

	@Test(description = "FrequencyCap add attribute validation")
	public void frequencyCapValidate() throws InterruptedException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.clickCommunicationSettings();
		pref.frequencyValidation();
	}

	@Test(description = "Account settings business unit selection")
	public void accountsettings() throws InterruptedException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserNameUserManage(), pref.dPropertyLoginPswrdUserManage());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.accountSettingsclick();
		pref.profilepictureValidation();
		pref.accountSettingsfield();
		pref.accountSettingsdropdwn();
		//pref.accountLocalizationSettings();

//		pref.addUser(BaseTest.getData().enterEmail, BaseTest.getData().userJobFunction, "Mr.");
	}

	@Test(description = "Goals and benchmark field validation and check")

	public void goalsandBenchmark() throws InterruptedException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.clickCommunicationSettings();
		pref.clickGoalsandBenchmark();
		pref.createBenchmark();
	}

	@Test(description = "Email footer addfoot validation and check")
	public void emailFooter() throws InterruptedException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();

		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.clickCommunicationSettings();
		pref.emailFooter();

//		comm.clickElement(CommunicationRepository.communicationpage_email_eventfooteraddress);
//		comm.selectlistelements(CommunicationRepository.communication_EventTrigger_footermsg, passvalue);
	}

	@Test(description = "CommunicationSettings unsub validation and check")
	public void communicationsettngsunsub() throws InterruptedException
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreferencesPage pref = getPageFactory().preferencesPage();
		String entervalue = "Test" + pref.addTimeToValue();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.clickCommunicationSettings();
		pref.commSettingsUnsub(entervalue);
		comm.clickCreateCommunicationfromMenu();

//		comm.clickElement(CommunicationRepository.communicationpage_email_footer);
//		pref.clickElement(CommunicationRepository.communication_email_unsubchkbox);
//		pref.clickElement(CommunicationRepository.communication_email_unsubselect);
//		pref.explicitwaitforclick(PageBase.autolocator(CommunicationRepository.communicationpage_communicationtype_listbox), 30);
//		pref.selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, entervalue);

	}

	@Test(description = "Landing page template builder validation and check")
	public void landingPageTemplateBuilder() throws InterruptedException
	{

		PreferencesPage pref = getPageFactory().preferencesPage();
		String entervalue = "Test" + pref.addTimeToName();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.landingBuilder(entervalue);
	}

	@Test(description = "Forms generator, subscription, Tell a friend, Surveyform field validation and check")

	public void pw_formsGenerator() throws InterruptedException
	{

		PreferencesPage pref = getPageFactory().preferencesPage();
		String formName = "Test" + pref.addTimeToName();
		pref.pw_login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		// getPlayWright().pause();
		pref.pw_selectbusinessunit();
		pref.pw_preferenceModuleClick();
		pref.pw_templateBuilderClickAction();
		pref.pw_formsclick("Resul form");
		pref.addFormBuilder();
		pref.surveyForm();
		pref.subscriptionForm();
		pref.FieldValidation(formName);
		pref.formEditiconCheck(formName);
		pref.formDuplicate(formName);

	}

	@Test(description = "Forms generator csv download check")

	public void formCsvDownload() throws InterruptedException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		String formName = "Test" + pref.addTimeToName();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.templateBuilderClick();
		pref.formCSVdownload(formName);

	}

	@Test(description = "Offer management validation and check")
	public void pw_offermanagement() throws InterruptedException
	{
		int startDate = 0;
		int endDate = 3;
		PreferencesPage pref = getPageFactory().preferencesPage();
		String offerName = "Test" + pref.addTimeToValue();
		String offerValue = "Test" + pref.addTimeToName();
		String offerCode = "Auto" + pref.addTimeToValue();
		pref.pw_login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.pw_selectbusinessunit();
		pref.pw_preferenceModuleClick();
		pref.pw_offerManagement();
		pref.addIcon();
		pref.addOfferValidationCommon(startDate, endDate, offerName);
		pref.addIcon();
		pref.addOfferUniqueGneratenewOffer(startDate, endDate, offerValue);
		pref.addIcon();
		pref.addOfferUniqueCsv(startDate, endDate, offerCode);

	}

	////////////////////////////////////////// CONSUMPTIONS
////////////////////////////////////////// ///////////////////////////////////////////////////////////////////////////////////////////////

//consumptions

	@Test(description = "Consumptions email download verify")
	public void consumptionEmailDownload() throws InterruptedException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.consumptionsClick();
		pref.consumptionAllDashboard("Email");
		pref.validateConsumptionListAndCsvData("Email");
	}

	@Test(description = "Consumption analytics email validation and check")

	public void conusmptionAnalyticsEmailCountVerify() throws InterruptedException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.consumptionsClick();
		pref.consumptionAllDashboard("Email");
		pref.consumptionAnalyticsSmsVerify("Email");
	}

	@Test(description = "Consumptions Sms download validation and check")
	public void consumptionSmsDownload() throws InterruptedException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.consumptionsClick();
		pref.consumptionAllDashboard("SMS");
		pref.validateConsumptionListAndCsvData("SMS");
	}

	@Test(description = "Consumptions Sms analytics verify")
	public void conusmptionAnalyticsSmsCountVerify() throws InterruptedException
	{

		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.consumptionsClick();
		pref.consumptionAllDashboard("SMS");
		pref.consumptionAnalyticsSmsVerify("SMS");
	}

	@Test(description = "Consumptions QR download verify")
	public void consumptionQrDownload() throws InterruptedException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.consumptionsClick();
		pref.consumptionAllDashboard("QR");
		pref.validateConsumptionListAndCsvData("QR");
	}

	@Test(description = "Consumption analytics QR validation and check")

	public void conusmptionAnalyticsQrCountVerify() throws InterruptedException
	{

		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.consumptionsClick();
		pref.consumptionAllDashboard("QR");
		pref.consumptionAnalyticsSmsVerify("QR");
	}

	@Test(description = "Consumptions whatsapp download verify")
	public void consumptionWhatsAppDownload() throws InterruptedException
	{

		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.consumptionsClick();
		pref.consumptionAllDashboard("WhatsApp");
		pref.validateConsumptionListAndCsvData("WhatsApp");
	}

	@Test(description = "Consumption analytics whatsapp validation and check")

	public void conusmptionAnalyticsWhatsAppCountVerify() throws InterruptedException
	{

		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.consumptionsClick();
		pref.consumptionAllDashboard("WhatsApp");
		pref.consumptionAnalyticsSmsVerify("WhatsApp");
	}

	////////////////////////////////////////////// CONSUMPTION OVER ///////////////////////////////////////////////////////////////////

	@Test(description = "Webhook field validation and check")
	public void dataExchange() throws InterruptedException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.dataExchangeClick();
		pref.dataExchangewebhookValidation();
	}

	@Test(testName = "Preferences builder", description = "New form templete email page builder")
	public void pw_newFormEmailTempleteBuilder()
	{
		PreferencesPage pref = getPageFactory().preferencesPage();

		pref.pw_login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.pw_selectbusinessunit();
		pref.pw_preferenceModuleClick();
		String templetName = pref.pw_templateBuilderClick();
		pref.DragAndDropPushBuilder("Text");
		pref.builderTextProperties();
		pref.DragAndDropPushBuilder("Image");
		pref.builderImageProperties();
		pref.DragAndDropPushBuilder("Video");
		pref.builderVideoProperties();
		pref.DragAndDropPushBuilder("Button");
		pref.builderButtonProperties();
		pref.DragAndDropPushBuilder("Offer");
		pref.SaveTemplete();
		pref.searchTemplete(templetName);

	}

	@Test(description = "AudienceScore add persona field validation and check")
	public void audienceScoreValidation() throws InterruptedException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.audienceScoreAddpersona();
	}

	@Test(description = "InVoices webtable and download validation and check")
	public void inVoices() throws InterruptedException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.preferencesInvoices();
		pref.inVoiceList();
	}

	@Test(description = "LicenseInfo webtable validation and check")

	public void licenseInfo() throws InterruptedException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.licenseinfo();
	}

	@Test(description = "Preferences Data catalogue parent and child attribute creation")
	public void DataCatalogueAddAttribute()
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		String attributeName = "Newattribute" + pref.addTimeToName().replaceAll("_", "");

		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.dataCatalogueClick();
		pref.addAttribute();
		pref.createNewAttribute(attributeName, "Regular Data");
		pref.allAttributeCheck(attributeName);
	}
}