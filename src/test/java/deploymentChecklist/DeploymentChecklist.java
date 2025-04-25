package deploymentChecklist;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import pages.AnalyticsOverviewDetailsPage;
import pages.AudienceDatabase;
import pages.AudiencePage_Dynamiclist;
import pages.AudiencePage_Targetlist;
import pages.AudiencePage_Upload;
import pages.CommunicationCreatePage;
import pages.CommunicationEmailChannelPage;
import pages.CommunicationMobilePushPage;
import pages.CommunicationNotificationPage;
import pages.CommunicationQRChannelPage;
import pages.CommunicationSMSChannelPage;
import pages.CommunicationWhatsAppPage;
import pages.HomePage;
import pages.PreCommunicationAnalyticsPage;
import pages.PreferencesPage;
import repository.AudienceRepository;
import repository.CommunicationRepository;
import repository.DashboardRepository;
import repository.ObjectRepository;
import utility.BaseTest;
import utility.DataInputProvider;
import utility.PageBase;

public class DeploymentChecklist extends BaseTest
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

	@Test(description = "Access All Menu in Communication Listing Page")
	public void allmenuincommunication()
	{
		CommunicationCreatePage comm = getPageFactory().communicationcreatepage();
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCommunicationListpagefromMenu();
		comm.accessCommunicationListingpage();
	}

	@Test(description = "Access Analytics Listing Page")
	public void accessAnalyticsListingPage()
	{
		AnalyticsOverviewDetailsPage analytics = getPageFactory().analyticsOverviewDetailsPage();
		analytics.login(analytics.dPropertyLoginUserName(), analytics.dPropertyLoginPswrd());
		analytics.selectbusinessunit();
		analytics.clickCommAnalyticsListingPagefromMenu();
		analytics.accessAnalyticsListingPage();

	}

	/**
	 * @author Vijay m & Jasmine Shanthiya
	 * @uses Audience module - Deployment checklist points
	 */

	@Test(testName = "", description = "InvalidAudienceDownload")
	public void invalidAudienceDownload()
	{
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu();
		audi.pageLoaderLogo();
		audi.clickImportHistory();
		List<String> invalidImportDesc = audi.getAlertImportDescName();
		audi.clickAlert(invalidImportDesc.get(0));
		audi.selectAudienceDownloadMail(invalidImportDesc.get(1));
	}

	@Test(testName = "RESUL-AUD-ADDAUD-TS-001,RESUL-AUD-ADDAUD-SRC-CSV-TL-TS-001-014", description = "Audience upload by selecting Target list with 1 CSV file")
	public void audienceUploadTargetListSingleCSV() throws IOException, InterruptedException, AWTException
	{
		Map<String, String> importtypes = new HashedMap<String, String>();
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();
		AudienceDatabase db = getPageFactory().audienceDatabase();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu().clickAddaudience();
		String uploadformat = audi.selectImportsource();
		String importType = audi.selectListtype();
		audi.attributeMapping();
		audi.ImportDescription = audi.enterImportdesc();
		audi.audience_upload_File(BaseTest.getData().Chooseyourfile1);
		audi.clickUpload();
		audi.segmentationPageValidate();
		audi.selectDoubleOptchkbox();
		audi.clicksave().returntomasterlist();
		importtypes.put(importType, audi.ImportDescription);
//		db.validateAudienceUpload(importtypes, uploadformat);
		audi.importHistory(audi.ImportDescription);
		DataInputProvider.writeUpdatedValueInSheet(1, 1, "Deploymentchecklist", "BaseData", audi.ImportDescription);
	}

	@Test(testName = "RESUL-ACTSTP-BRD-ENT-TS-001", description = "Audience upload by selecting Adhoc list with 1 CSV file ")
	public void audienceUploadAdhocListSingleCSV()
	{
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu().clickAddaudience();
		audi.selectImportsource();
		audi.selectListtype();
		String ImportDescription = audi.enterImportdesc();
		audi.audience_upload_File(BaseTest.getData().Chooseyourfile1);
		audi.clickUpload();
		audi.importHistory(ImportDescription);
		DataInputProvider.writeUpdatedValueInSheet(2, 1, "Deploymentchecklist", "BaseData", ImportDescription);
		audi.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList("AL_" + ImportDescription);
		getPageFactory().audiencepage_Targetlist().targetListSearchResult("AL_" + ImportDescription);
	}

	@Test(testName = "RESUL-ACTSTP-BRD-ENT-TS-001", description = "Audience upload by selecting Seed list with 1 CSV file ")
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
		DataInputProvider.writeUpdatedValueInSheet(5, 1, "Deploymentchecklist", "BaseData", "SL_" + ImportDescription);
		getPageFactory().audiencepage_Targetlist().targetListSearchResult("SL_" + ImportDescription);
	}

	@Test(testName = "RESUL-ACTSTP-BRD-ENT-TS-001", description = "Audience upload by selecting Match Input list with 1 CSV file ")
	public void audienceUploadMatchInputListSingleCSV()
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
		DataInputProvider.writeUpdatedValueInSheet(3, 1, "Deploymentchecklist", "ML_" + "BaseData", ImportDescription);
		getPageFactory().audiencepage_Targetlist().targetListSearchResult("ML_" + ImportDescription);
	}

	@Test(testName = "RESUL-ACTSTP-BRD-ENT-TS-001", description = "Audience upload by selecting Suppression Input list with 1 CSV file ")
	public void audienceUploadSuppressionInputListSingleCSV()
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
		DataInputProvider.writeUpdatedValueInSheet(4, 1, "Deploymentchecklist", "SUP_" + "BaseData", ImportDescription);
		getPageFactory().audiencepage_Targetlist().targetListSearchResult("SUP_" + ImportDescription);
	}

	@Test(testName = "04", description = "New Attribute Creation In Column Mapping Page")
	public void newAttributeCreationInColumnMappingPage()
	{
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();
		PreferencesPage pref = getPageFactory().preferencesPage();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		String attributeName = "Newattribute" + audi.addTimeToName().replaceAll("_", "");
		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu().clickAddaudience();
		audi.selectImportsource();
		audi.selectListtype();
		audi.attributeMapping();
		audi.enterImportdesc();
		audi.audience_upload_File(BaseTest.getData().Chooseyourfile1);
		audi.clickUploadAndValidate();
		audi.pageLoaderLogo();
		audi.selectNewAttributeInColumnMappingPage();
//		audi.selectScrollToListelements(DashboardRepository.allpage_common_selectdropdownlist, "New attribute");
		audi.createAttribute(attributeName);
		audi.selectDoubleOptchkbox();
		audi.clicksave().returntomasterlist();
		audi.clickPreferencePagefromMenu();
		audi.clickDataCatalogue();
		pref.validateAttribute(attributeName);
	}

	@Test(testName = "", description = "master Data Overview Portlets And Chart Validate")
	public void masterDataOverviewPortletsAndChartValidate()
	{
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu();
		audi.pageLoaderLogo();
		audi.audienceMasterDataProfileCompleteness();
		audi.clickAudienceMasterdatafromMenu();
		if (audi.isDisplayed(AudienceRepository.audience_Masterdata_portletheader))
		{
			audi.audienceMasterDataOverviewHighCharts();
		}
		audi.clickAudienceMasterdatafromMenu();
		audi.pageLoaderLogo();
		audi.audienceMasterDataEmailSmsDataValidation();
		audi.clickAudienceMasterdatafromMenu();
		audi.pageLoaderLogo();
		audi.audienceMasterDataNotificationDataValidation();
		audi.overviewPieChartLegendValidate1();
		audi.clickAudienceMasterdatafromMenu();
		audi.audienceOverviewcChannelPercentageAndTextValidation();
		audi.audienceOverviewChannelsTotalCountValidation();
	}

	@Test(testName = "", description = "validate List acquisition table in Master data management")
	public void audienceMasterDataListAcquisitionTableValidation()
	{
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu();
		audi.pageLoaderLogo();
		audi.listAcquisitionChart();
		audi.listAcquisitionLegendValidate();
		audi.listAcquistionNotes();
		audi.selectListAcquisitionCalender("All time");
		audi.selectListAcquisitionSource("All sources");
		audi.listAcquisitionChartValidate("email");
		audi.listAcquisitionChartValidate("mobile");
	}

	@Test(testName = "", description = "Create persona from Master data management")
	public void createPersona_From_MDM()
	{
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();
		PreferencesPage pref = getPageFactory().preferencesPage();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu();
		audi.pageLoaderLogo();
		audi.clickOverviewPortlet_Info_Icon("Total");
		audi.click_CreatePersona_From_MDM();
		pref.createPersona_From_AudienceScore();
	}

	@Test(testName = "", description = "Target list creation")
	public void targetListCreateAndValidate()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
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
		DataInputProvider.writeUpdatedValueInSheet(7, 1, "Deploymentchecklist", "BaseData", trgt.targetListName);
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList(trgt.targetListName);
	}

	@Test(testName = "", description = "Target list control and target group")
	public void targetListControlAndTargetGroup()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();

		String targetListNew = BaseTest.getData().TargetListNew;

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList(targetListNew);
		String listName = (PageBase.shortListName != null) ? PageBase.shortListName : targetListNew;
		Map<String, String> moreInfoDetails = trgt.getMoreInfoDetails(listName);
		trgt.clickCgTgIcon(listName);
		trgt.validateCGTGSlider("off");
		trgt.verifyCGTGValue(moreInfoDetails);
		trgt.slideCGTGValue();
		Map<String, String> moreInfoDetailsAfterSlide = trgt.getMoreInfoDetails(listName);
		trgt.clickCgTgIcon(listName);
		trgt.validateCGTGSlider("on");
		trgt.verifyCGTGValue(moreInfoDetailsAfterSlide);
		trgt.clickCgTgToogleButton();
	}

	@Test(testName = "", description = "Child Attribute Group Two Inclusion And Exclusion")
	public void pw_TL_childAttribute_InclusionTwoAndExclusion()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();

		trgt.pw_login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.pw_selectbusinessunit();
		Page page = getPlayWright();
		trgt.pw_clickElement(AudienceRepository.pw_audiencelinkclick);
		trgt.pw_clickElement(AudienceRepository.pw_audience_Masterdatamanagement);
		trgt.pw_clickElement(AudienceRepository.pw_audience_Targetlist_Tab);
		String trgtlistname = trgt.pw_enterTargetListName();
		trgt.pw_targetListAttributeSearch("CreditLimit");
		trgt.pw_selectAttributeConditionAndValue("CreditLimit", "Is greater than", "21");
		trgt.pw_addInclusionGroupTwo();
		trgt.pw_targetListAttributeSearch("CreditType");
		trgt.pw_selectAttributeConditionAndValue("CreditType", "​Is equal to", "Master,Rupay,Visa");
		trgt.pw_addExclusionGroup();
		trgt.pw_targetListAttributeSearch("LoanType");
		trgt.pw_selectAttributeConditionAndValue("LoanType", "​Is equal to", "Personal");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create")).click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
		page.locator("#rs_RSAdvanceSearch_zoom").click();
		page.getByPlaceholder("By list name").click();
		page.getByPlaceholder("By list name").fill(trgtlistname);
		page.locator("li").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^" + trgtlistname + "$"))).click();
		page.locator("#rs_data_zoom").click();
		String listname = page.textContent("(//div[@class='rci-list-name']//span)[2]");
		trgt.uiPageEqualswithInputValue(trgtlistname, listname);
	}

	@Test(testName = "", description = "Target list recalculate now/later validate")
	public void targetListRecalculateLater_Now_later()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
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
		int totalCount = trgt.clickHereToGetCount(SelectAttribute);
		trgt.removeFilterAttributes(SelectAttribute, AttributeValueNew);
		if (!trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueNew))
		{
			trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueOld);
		}
		trgt.createTargetList();
		trgt.recalculateNow();
		int recalculateNowCount = Integer.parseInt(trgt.getStrText(AudienceRepository.audience_target_potentialaudienceInclusiongroup1).replace(",", ""));
		trgt.writeLog(totalCount == recalculateNowCount, "Recalculate count is present as expected -> '<b>" + recalculateNowCount + "</b>'", "Recalculate count is not-present as expected '<b>" + recalculateNowCount + "</b>'");
		trgt.removeFilterAttributes(SelectAttribute, AttributeValueNew);
		if (!trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueNew))
		{
			trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueOld);
		}
		trgt.createTargetList();
		trgt.recalculateLater();
		trgt.saveTargetList();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod();
		Map<String, String> trgtListDetails = trgt.searchTargetList(trgt.targetListName);
		String SegmentationCount = trgtListDetails.get("SegmentationCount");
		if (!SegmentationCount.equals("List extraction is in progress"))
		{
			trgt.writeLog(SegmentationCount == String.valueOf(totalCount), "Segmentation Count is present as expected count <b>" + totalCount + "</b>", "Segmentation Count is not present as expected count <b>" + totalCount + "</b>");
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "List extraction is in progress.");
			BaseTest.takeScreenshot();
		}
	}

	@Test(testName = "", description = "Target List Duplicate")
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
	}

	@Test(testName = "", description = "Edit and verify targetList")
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

	@Test(testName = "", description = "target List Download")
	public void targetListDownload()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();

		String targetListNew = BaseTest.getData().TargetListNew;
		targetListNew = "TrgtRfaApprove9110142729";
		String[] attributes = "Name,Email,MobileNo,City".split(",");

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod();
		Map<String, String> trgtListDetails = trgt.searchTargetList(targetListNew);
		String listName = (PageBase.shortListName != null) ? PageBase.shortListName : targetListNew;
		trgt.clickTargetListDownload(listName, "sample list");
		trgt.selectDownloadAttributes(attributes);
		trgt.targetListDownloadCsvPopup("Email Id");
		int audienceCount = Integer.parseInt(trgtListDetails.get("SegmentationCount").replaceAll("[^0-9]", ""));
		trgt.downloadAndValidateTargetListFromWebmail(audienceCount, targetListNew);
	}

	@Test(testName = "", description = "Target list One Approve RFA All")
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

	/**
	 * @author Avinash J
	 * @uses Communication module - Deployment checklist points
	 */

	@Test(testName = "Target list email communication", description = "Blast email communication with Target list")
	public void emailCommunicationCreateValidateTargetList() throws IOException
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
		// comm.enterFname();
		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport().selectZip(BaseTest.getData().ZipName);
		comm.clickElement(",xpath,(//i[@id='rs_data_refresh'])[1]");
		PageBase.threadSleep(ObjectRepository.wait3sec);
		comm.clickElement(",xpath,//button[.='OK']");
		comm.javaScriptScrollIntoView(",xpath,(//i[@class='icon-rs-user-question-mark-medium icon-md'])[2]");
		PageBase.threadSleep(ObjectRepository.wait3sec);
		comm.clickElement(CommunicationRepository.email_clickimport);
		comm.selectZip(BaseTest.getData().ZipName);
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.javaScriptScrollDown();
		WebElement element = getWebDriver().findElement(By.xpath("(//button[normalize-space()='Next'])[1]"));
		element.click();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("In progress");
//		comm.javaScriptopenNewWindow();
//		comm.switchWindow();
//		comm.webURLlaunch();
//		comm.emailBlastCheckWebmailLogin();
//		comm.emailBlastSubjectLineValidate(comm.emailSubjectContains);
//		comm.blastEmaillinksVerify();
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
		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport().selectZip(BaseTest.getData().ZipName);
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.javaScriptScrollDown();
		WebElement element = getWebDriver().findElement(By.xpath("(//button[normalize-space()='Next'])[1]"));
		element.click();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("In progress");
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch();
		comm.target_Dynamic_approver1_Webmail_login();
		comm.emailBlastSubjectLineValidate(comm.communicationName);
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
		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport().selectZip(BaseTest.getData().ZipName);
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.javaScriptScrollDown();
		WebElement element = getWebDriver().findElement(By.xpath("(//button[normalize-space()='Next'])[1]"));
		element.click();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("In progress");
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch();
		comm.target_Dynamic_approver1_Webmail_login();
		comm.emailBlastSubjectLineValidate(comm.communicationName);
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
		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport().selectZip(BaseTest.getData().ZipName);
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.javaScriptScrollDown();
		WebElement element = getWebDriver().findElement(By.xpath("(//button[normalize-space()='Next'])[1]"));
		element.click();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("In progress");
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch();
		comm.target_Dynamic_approver1_Webmail_login();
		comm.emailBlastSubjectLineValidate(comm.communicationName);
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
		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport().selectZip(BaseTest.getData().ZipName);
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.javaScriptScrollDown();
		WebElement element = getWebDriver().findElement(By.xpath("(//button[normalize-space()='Next'])[1]"));
		element.click();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("In progress");
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch();
		comm.target_Dynamic_approver1_Webmail_login();
		comm.emailBlastSubjectLineValidate(comm.communicationName);
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
		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		// comm.selectZip(BaseTest.getData().ZipName);
		comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		String mail = System.getProperty("Target_Dynamic_approver1_webmail_Uname");
		comm.testmail(mail);
		comm.communicationlistingPageStatusCompare("Draft");
		String pwind = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch().target_Dynamic_approver1_Webmail_login();

		comm.emailBlastSubjectLineValidate(comm.communicationName);
		comm.blastEmaillinksVerify();

	}

	@Test(testName = "", description = "Email preview with Adhoc list")
	public void emailCommunicationAdhocPreview() throws IOException
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickNext().smartUrlpopupCancel();
		comm.javaScriptScrolltoTop();
		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport().selectZip(BaseTest.getData().ZipName);
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		String mail = System.getProperty("Target_Dynamic_approver1_webmail_Uname");
		comm.testmail(mail);
		comm.communicationlistingPageStatusCompare("Draft");
		String pwind = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch().target_Dynamic_approver1_Webmail_login();

		comm.emailBlastSubjectLineValidate(comm.communicationName);
		comm.blastEmaillinksVerify();
	}

	@Test(testName = "", description = "Email preview with Seed list")
	public void emailCommunicationSeedPreview() throws IOException
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickNext().smartUrlpopupCancel();
		comm.javaScriptScrolltoTop();
		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport().selectZip(BaseTest.getData().ZipName);
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		String mail = System.getProperty("Target_Dynamic_approver1_webmail_Uname");
		comm.testmail(mail);
		comm.communicationlistingPageStatusCompare("Draft");
		String pwind = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch().target_Dynamic_approver1_Webmail_login();

		comm.emailBlastSubjectLineValidate(comm.communicationName);
		comm.blastEmaillinksVerify();
	}

	@Test(testName = "", description = "Email preview with Match list")
	public void emailCommunicationMatchPreview() throws IOException
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickNext().smartUrlpopupCancel();
		comm.javaScriptScrolltoTop();
		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport().selectZip(BaseTest.getData().ZipName);
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		String mail = System.getProperty("Target_Dynamic_approver1_webmail_Uname");
		comm.testmail(mail);
		comm.communicationlistingPageStatusCompare("Draft");
		String pwind = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch().target_Dynamic_approver1_Webmail_login();

		comm.emailBlastSubjectLineValidate(comm.communicationName);
		comm.blastEmaillinksVerify();
	}

	@Test(testName = "", description = "Email preview with Suppression list")
	public void emailCommunicationSupPreview() throws IOException
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickNext().smartUrlpopupCancel();
		comm.javaScriptScrolltoTop();
		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport().selectZip(BaseTest.getData().ZipName);
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		String mail = System.getProperty("Target_Dynamic_approver1_webmail_Uname");
		comm.testmail(mail);
		comm.communicationlistingPageStatusCompare("Draft");
		String pwind = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch().target_Dynamic_approver1_Webmail_login();

		comm.emailBlastSubjectLineValidate(comm.communicationName);
		comm.blastEmaillinksVerify();
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
		comm.explicitwaitforvisibility(PageBase.autolocator(CommunicationRepository.authoringpage_provider), 20);
		comm.javaScriptScrollDown();
		comm.clickElement(CommunicationRepository.authoringpage_webanalytics);
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("In progress");
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
		comm.explicitwaitforclick(PageBase.autolocator(CommunicationRepository.authoringpage_whatsappconfirmpreview), 20);
		comm.clickElement(CommunicationRepository.authoringpage_whatsappconfirmpreview);
		comm.pageLoaderLogo();
		comm.communicationlistingPageStatusCompare("Draft");
	}

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
		// if (comm.isElementPresent("Validation message,xpath,//div[@class='validation-message'][contains(.,'later than 15')]"))
		// {
		// comm.enterEmailScheduleTime(startDate);
		// comm.clickNextemail();
		// comm.pageLoaderLogo();
		// }
		comm.explicitwaitforclick(PageBase.autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 20);
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
		comm.explicitwaitforclick(PageBase.autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 20);
		comm.javaScriptScrollDown();
		comm.clickElement(CommunicationRepository.authoringpage_webanalytics);
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails().preCommunicationPage();
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
		comm.explicitwaitforclick(PageBase.autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 20);
		comm.javaScriptScrollDown();
		comm.clickElement("Web analytics,xpath,//i[contains(@class,'icon-rs-web-analytics-large icon-lg')]");
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("In progress");
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
		comm.explicitwaitforclick(PageBase.autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 20);
		comm.javaScriptScrollDown();
		comm.clickElement("Web analytics,xpath,//i[contains(@class,'icon-rs-web-analytics-large icon-lg')]");
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("In progress");
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
		comm.explicitwaitforclick(PageBase.autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 20);
		comm.javaScriptScrollDown();
		comm.clickElement("Web analytics,xpath,//i[contains(@class,'icon-rs-web-analytics-large icon-lg')]");
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("In progress");
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
		comm.explicitwaitforclick(PageBase.autolocator("Confirm preview,xpath,//div[contains(@class,'modal-content')]"), 20);
		PageBase.threadSleep(ObjectRepository.wait5sec);
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
		comm.explicitwaitforclick(PageBase.autolocator("Confirm preview,xpath,//div[contains(@class,'modal-content')]"), 20);
		PageBase.threadSleep(ObjectRepository.wait5sec);
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
		comm.explicitwaitforclick(PageBase.autolocator("Confirm preview,xpath,//div[contains(@class,'modal-content')]"), 20);
		PageBase.threadSleep(ObjectRepository.wait5sec);
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
		comm.explicitwaitforclick(PageBase.autolocator("Confirm preview,xpath,//div[contains(@class,'modal-content')]"), 20);
		PageBase.threadSleep(ObjectRepository.wait5sec);
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
		comm.explicitwaitforclick(PageBase.autolocator("Confirm preview,xpath,//div[contains(@class,'modal-content')]"), 20);
		PageBase.threadSleep(ObjectRepository.wait5sec);
		getWebDriver().findElement(By.xpath("(//button[.='Save'])[2]")).click();
		comm.pageLoaderLogo();
		comm.communicationlistingPageStatusCompare("Draft");
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
		web.selectScrollToListelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Dismiss");
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		comm.clickNextemail();
		comm.pageLoaderLogo();
		comm.reschedule(startDate);
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("In progress");
	}

	@Test(description = "Webpush Test communication without image")
	public void webpushTestCommunicationWithoutImage()
	{
		CommunicationNotificationPage web = getPageFactory().communication_Notification();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();

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
		comm.explicitwaitforclick(PageBase.autolocator("Confirm preview,xpath,//div[contains(@class,'modal-content')]"), 20);
		PageBase.threadSleep(ObjectRepository.wait5sec);
		getWebDriver().findElement(By.xpath("(//button[.='Save'])[2]")).click();
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
		if (comm.isElementPresent("Validation message,xpath,//div[@class='validation-message'][contains(.,'later than 15')]"))
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
		comm.explicitwaitforclick(PageBase.autolocator("Confirm preview,xpath,//div[contains(@class,'modal-content')]"), 20);
		PageBase.threadSleep(ObjectRepository.wait5sec);
		getWebDriver().findElement(By.xpath("(//button[.='Save'])[2]")).click();
		comm.pageLoaderLogo();
		comm.communicationlistingPageStatusCompare("Draft");
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
		comm.communicationlistingPageStatusCompare("In progress");
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch();
		comm.target_Dynamic_approver1_Webmail_login();
		comm.emailBlastSubjectLineValidate(comm.communicationName);
		comm.blastEmaillinksVerify();
	}

	@Test(description = "Create Mobile push communication with image URL")
	public void mobileRichPushImageUrl() throws AWTException
	{
		CommunicationMobilePushPage comm = getPageFactory().communicationMobilePushPage();
		CommunicationNotificationPage web = getPageFactory().communication_Notification();

		int startDate = 0;
		int endDate = 3;
		web.login(web.dPropertyLoginUserName(), web.dPropertyLoginPswrd());

		web.selectbusinessunit();
		web.clickCreateCommunicationfromMenu();
		web.singleDimensionComm(startDate, endDate);

		web.channelType5().analyticOption2().analyticOption5().clickNext();
		comm.mobilepushSmartLinkCreate();
		comm.mobilepushAudienceSelect();
		comm.mobilePushTypeAndLayout("Alert / Rich push");
		comm.mobilepushTitleAndContentEnter();
		comm.mpImageURL();
		comm.mobilepushSetInteractivity();
		comm.mobilepushSetExpiry();
		comm.mobilepushSetTimeZoneScheduleDate();
		comm.enterMobilepushScheduleTime(startDate);
		comm.mobilepushCommunicationSave();
		comm.searchCommunication("communicationlisting", comm.communicationName);
		comm.communicationlistingPageStatusCompare("Scheduled");
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
		web.channelType5().analyticOption2().analyticOption5().clickNext();
		web.mobilepushSmartLinkCreate();
		web.mobilepushAudienceSelect();
		web.mobilePushTypeAndLayout("Alert / Rich push");
		web.mobilepushTitleAndContentEnter();
		web.mpImageURL();
		web.mobilepushSetInteractivity();
		web.mobilepushSetExpiry();
		web.mobilepushSendTestPreview(System.getProperty("webMobilePushTestCommunication"));
	}

	@Test(description = "Create Mobile push communication without image ")
	public void mobileRichPushWithoutImage() throws Exception
	{
		CommunicationMobilePushPage web = getPageFactory().communicationMobilePushPage();
		int startDate = 0;
		int endDate = 3;
		web.login(web.dPropertyLoginUserName(), web.dPropertyLoginPswrd());

		web.selectbusinessunit();
		web.clickCreateCommunicationfromMenu();
		web.singleDimensionComm(startDate, endDate);

		web.channelType5().analyticOption2().analyticOption5().clickNext();
		web.mobilepushSmartLinkCreate();
		web.mobilepushAudienceSelect();
		web.mobilePushTypeAndLayout("Alert / Rich push");
		web.mobilepushTitleAndContentEnter();
		web.mobilepushSetInteractivity();
		web.mobilepushSetExpiry();
		web.enterMobilepushScheduleTime(startDate);

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

		web.channelType5().analyticOption2().analyticOption5().clickNext();
		web.mobilepushSmartLinkCreate();
		web.mobilepushAudienceSelect();
		web.mobilePushTypeAndLayout("Alert / Rich push");
		web.mobilepushTitleAndContentEnter();
		web.mobilepushSetInteractivity();
		web.mobilepushSetExpiry();
		web.mobilepushSendTestPreview(System.getProperty("webMobilePushTestCommunication"));
	}

	@Test(description = "QR communication create without SmartUrl")
	public void QRCommwithoutSmartUrl() throws IOException, AWTException
	{
		CommunicationQRChannelPage qr = getPageFactory().communicationqrchannelpage();
		int startDate = 0;
		int endDate = 3;
		qr.login(qr.dPropertyLoginUserName(), qr.dPropertyLoginPswrd());
		qr.selectbusinessunit();
		qr.clickCreateCommunicationfromMenu();
		qr.singleDimensionComm(startDate, endDate);
		qr.selectQRChannel().analyticOption2().clickNext();
		// qr.createSmarturl();
		qr.smartUrlpopupCancel();
		qr.qrDetails();
		qr.clickSaveqrPage();
		qr.communicationlistingPageStatusCompare("In progress");
	}

	@Test(testName = "", description = "Social post communication setup - Facebook")
	public void socialPostFB()
	{

		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();

		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.analyticOption1().analyticOption2();
		comm.clickNext().createSmarturl();
		comm.socialPostCreation("Facebook");
		comm.communicationlistingPageStatusCompare("Scheduled");

	}

	@Test(testName = "", description = "Social post communication setup - Twitter")
	public void socialPostTwitter()
	{

		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();

		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.analyticOption1().analyticOption2();
		comm.clickNext().createSmarturl();
		comm.socialPostCreation("Twitter");
		comm.communicationlistingPageStatusCompare("Scheduled");
	}

	@Test(testName = "", description = "Social post communication setup - Instagram")
	public void socialPostInstagram()
	{

		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();

		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.analyticOption1().analyticOption2();
		comm.clickNext().createSmarturl();
		comm.socialPostCreation("Instagram");
		comm.communicationlistingPageStatusCompare("Scheduled");
	}

	@Test(testName = "", description = "Social post communication setup - LinkedIn")
	public void socialPostLinkedin()
	{

		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();

		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.analyticOption1().analyticOption2();
		comm.clickNext().createSmarturl();
		comm.socialPostCreation("Linkedin");
		comm.communicationlistingPageStatusCompare("Scheduled");
	}

	@Test(testName = "", description = "Generating smartlink by using paid media channels")
	public void paidMediaSetupAndBlast()
	{

		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();

		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType6().analyticOption2();
		BaseTest.takeScreenshot();
		comm.clickNext().createSmarturl();
		comm.paidMediaCommunicationCreation();
	}

	@Test(testName = "", description = "Event trigger communication Daily - SMS")
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
		comm.pageLoaderLogo();
		comm.explicitwaitforclick(PageBase.autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 20);
		comm.javaScriptScrollDown();
		comm.clickElement("Web analytics,xpath,//i[contains(@class,'icon-rs-web-analytics-large icon-lg')]");
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Scheduled");
	}

	@Test(testName = "", description = "Event trigger communication Daily - Email")
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
		comm.clickImport().selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		WebElement element = getWebDriver().findElement(By.xpath("(//button[normalize-space()='Next'])[1]"));
		element.click();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Scheduled");
	}

	@Test(description = "Event trigger communication Daily Test perview - Email channel")
	public void eventTriggerEmailDailyTestPreview()
	{
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
		comm.clickImport().selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		String mail = PageBase.audience_approver3;
		comm.testmail(mail);
		comm.communicationlistingPageStatusCompare("Draft");

	}

	@Test(description = "Event trigger communication Daily Test perview - SMS channel")
	public void eventTriggerSmsDailyTestPreview()
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
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
		sms.sendTestSms();
		comm.clickSaveEmail();
		comm.explicitwaitforclick(PageBase.autolocator("Confirm preview,xpath,//div[contains(@class,'modal-content')]"), 20);
		PageBase.threadSleep(ObjectRepository.wait5sec);
		getWebDriver().findElement(By.xpath("(//button[.='Save'])[2]")).click();
		comm.pageLoaderLogo();
		comm.communicationlistingPageStatusCompare("Draft");
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
		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.subjectLineValidation();
		comm.clickImport().selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.javaScriptScrollDown();
		WebElement element = getWebDriver().findElement(By.xpath("(//button[normalize-space()='Next'])[1]"));
		element.click();
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
		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		// comm.selectZip(BaseTest.getData().ZipName);
		comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.requestforApprovalEmail1(System.getProperty("Target_Dynamic_approver1_webmail_Uname"));
		comm.reschedule(startDate);
		PageBase.threadSleep(ObjectRepository.wait10sec);
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Alert");
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
		comm.requestforApprovalEmail1(System.getProperty("Target_Dynamic_approver1_webmail_Uname"));
		// comm.clickNextemail();
		comm.pageLoaderLogo();
		if (comm.isElementPresent("Validation message,xpath,//div[@class='validation-message'][contains(.,'later than 15')]"))
		{
			comm.enterEmailScheduleTime(startDate);
			comm.clickNextemail();
			comm.pageLoaderLogo();
		}
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.explicitwaitforclick(PageBase.autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 20);
		comm.javaScriptScrollDown();
		comm.clickElement("Web analytics,xpath,//i[contains(@class,'icon-rs-web-analytics-large icon-lg')]");
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Alert");
	}

	@Test(testName = "", description = "Advance analytics verify for Email ")
	public void advanceAnalytics()
	{

		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();

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
		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		// comm.selectZip(BaseTest.getData().ZipName);
		comm.selectZipUsingKeys();
		String spamScoreAuthoringPage = comm.spamScoreCheck();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.javaScriptScrollDown();
		WebElement element = getWebDriver().findElement(By.xpath("(//button[normalize-space()='Next'])[1]"));
		element.click();
		comm.reschedule(startDate);
		comm.pageLoaderLogo();
		comm.javaScriptScrolltoTop();

		comm.javaScriptScrollDown();
		comm.clickElement("Web analytics,xpath,//i[contains(@class,'icon-rs-web-analytics-large icon-lg')]");
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails();
		String spamScorePrecComm = comm.getStrText("Spam score precomm,xpath,//h5[contains(.,'spam score')]/..//div//h1");
		comm.writeLog(spamScoreAuthoringPage.equals(spamScorePrecComm), "Spam score in authoring page is equals with spam score from precommunication page", "Spam score in authoring page is not equals with spam score from precommunication page");
		precomm.advAnalyticsEmailSms("email");
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
		comm.explicitwaitforclick(PageBase.autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 20);
		comm.javaScriptScrollDown();
		comm.clickElement("Web analytics,xpath,//i[contains(@class,'icon-rs-web-analytics-large icon-lg')]");
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails();
		precomm.advAnalyticsEmailSms("sms");

	}

	@Test(description = "Email communication with RFA 1 reject and database validate")
	public void emailCommunicationCreateRejectRFA() throws IOException
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		int startDate = 0;
		int endDate = 3;
		// comm.login("agencyr5@resul.team", "Ge3!ICh6U");

		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();

		comm.clickCreateCommunicationfromMenu();
		comm.singleDimensionComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickNext();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		// comm.selectZip(BaseTest.getData().ZipName);
		comm.selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.requestforApprovalEmail1(System.getProperty("Target_Dynamic_approver1_webmail_Uname"));
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
		comm.target_Dynamic_approver1_Webmail_login();
		comm.clickCommunicationRFAMail(comm.communicationName);
		comm.rfaWebMailSubject("Email");
		comm.blastEmaillinksVerify();
		comm.clickMakeChangesBtn();
		comm.approvalMakeChangespage("Communication sent for make changes");
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
		comm.requestforApprovalEmail1(System.getProperty("Target_Dynamic_approver1_webmail_Uname"));
		// comm.clickNextemail();
		comm.pageLoaderLogo();
		if (comm.isElementPresent("Validation message,xpath,//div[@class='validation-message'][contains(.,'later than 15')]"))
		{
			comm.enterEmailScheduleTime(startDate);
			comm.clickNextemail();
			comm.pageLoaderLogo();
		}
		PageBase.threadSleep(ObjectRepository.wait10sec);
		comm.explicitwaitforclick(PageBase.autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 20);
		comm.javaScriptScrollDown();
		comm.clickElement("Web analytics,xpath,//i[contains(@class,'icon-rs-web-analytics-large icon-lg')]");
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Alert");
		String pwind = sms.parentWinHandle();
		sms.logout();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		sms.webURLlaunch();
		sms.target_Dynamic_approver1_Webmail_login();
		sms.clickCommunicationRFAMail(sms.communicationName);
		sms.clickMakeChangesBtn();
		sms.approvalMakeChangespage("RFA SMS make change communication:" + sms.communicationName);
		sms.switchParentWin(pwind);
		sms.openLoginPage();
		sms.login(sms.dPropertyLoginUserName(), sms.dPropertyLoginPswrd());
		sms.selectbusinessunit();
		sms.clickCommunicationListpagefromMenu();
		if (sms.searchCommunication("communicationlisting", sms.communicationName))
		{
			sms.communicationlistingPageStatusCompare("Alert");
		}
	}

	@Test(description = "Forms generator csv download check")
	public void formCsvDownload() throws InterruptedException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		String formName = "Test" + pref.addTimeToName();
		Page page = getPlayWright();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.templateBuilderClick();
		pref.formCSVdownload(formName);
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

	@Test(description = "Consumptions email analytics verify")
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

	@Test(testName = "EDM Upload email communication", description = "Upload EDM in email communication ")
	public void eDMUploadEmail() throws IOException
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
		// comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		comm.selectZipUsingKeys();

	}

	@Test(testName = "EDM Upload Webpush communication", description = "Upload EDM in Webpush communication ")
	public void eDMUploadWebPush() throws IOException
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
		// comm.enternewRecipient();
		web.selectWebPushDeliveryType();
		web.clickImportWebpush();
		comm.selectZipUsingKeys();
	}

	@Test(testName = "EDM Upload Mobilepush communication", description = "Upload EDM in Mobilepush communication ")
	public void eDMUploadMobilePush() throws IOException
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationMobilePushPage mobile = getPageFactory().communicationMobilePushPage();
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
		// comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		mobile.clickImportMobilepush();
		comm.selectZipUsingKeys();
	}

	@Test(testName = "AMPEDM Upload email communication", description = "Upload EDM in email communication ")
	public void aMPEDMUploadEmail() throws IOException
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
		comm.enternewRecipient();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport();
		comm.selectAMPEDMZipUsingKeys();
		takeScreenshot();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		String scheduleDate = comm.calendarSchedduleDate(0);
		comm.enterScheduleDate(scheduleDate);
		int scheduleDate1 = Integer.parseInt(scheduleDate);
		comm.enterEmailScheduleTime(scheduleDate1);

		comm.clickNextemail();
		if (comm.checkEmailScheduleTimeError(scheduleDate))
		{
			comm.clickNextemail();
		}
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("In progress");
		comm.emailCommDBValidation();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		comm.webURLlaunch().emailBlastCheckWebmailLogin();
		comm.emailBlastSubjectLineValidate(comm.emailSubjectContains);
		comm.fallBackAMPEdm();
		comm.blastEmaillinksVerify();

//		comm.savePlanPage();
//		comm.savePlanPageWithoutCommSchedule();
		// comm.communicationlistingPageStatusCompare("Draft");

	}
}
