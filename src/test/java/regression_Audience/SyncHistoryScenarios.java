package regression_Audience;

import java.text.ParseException;
import java.time.Instant;
import java.util.Date;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.AudiencePage_Upload;
import pages.PreferencesPage;
import pages.SyncHistoryPage;
import repository.AudienceRepository;
import repository.CommunicationRepository;
import utility.BaseTest;
import utility.PageBase;

public class SyncHistoryScenarios extends BaseTest
{
	@Test(description = "Sync history import date picker filtered list, updated date validation")
	public void audienceSynchistoryNavigation()
	{
		SyncHistoryPage sync = getPageFactory().syncHistoryPage();
		sync.login(sync.dPropertyLoginUserName(), sync.dPropertyLoginPswrd());
		sync.selectbusinessunit();
		sync.clickAudienceMasterdatafromMenu();
		sync.syncHistorymousehovervalidation();
		// sync.clickElement(AudienceRepository.audience_mdm_synchistory);
		sync.synchistorynavigation();
		sync.synchistoryColumnsValidation();
		sync.paginationandDateRange();
		sync.javaScriptScrollDown();

	}

//	  sync.explicitwaitforpresence(PageBase.autolocator(AudienceRepository.audience_impor8tcompare), 50); int customRangeFromDate = -10; int
//	  customRangeToDate = 0; String timeStamp = AudienceRepository.audience_synchistory_ListTimeStamp; String ListName =
//	  AudienceRepository.audience_synchistory_ListName; String nextPageButton = AudienceRepository.audience_pagination_nextpage;
//	 sync.dateRangeFilter(customRangeFromDate, customRangeToDate, timeStamp, ListName, nextPageButton

	@Test(testName = "", description = "Custom range - Date Range filter validations")
	public void dateRangeFilterScenarios()
	{

		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();
		SyncHistoryPage sync = getPageFactory().syncHistoryPage();
		String timeStamp = CommunicationRepository.communication_ListTimeStamp;
		sync.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());
		sync.selectbusinessunit();
		sync.clickAudienceMasterdatafromMenu();
		sync.synchistoryColumnsValidation();
		sync.selectSegmentationList("All segment list");
		audi.dateRangeFilter(timeStamp);
	}

	@Test(testName = "", description = "Custom range date filter scenarios")
	public void customRangeFilterScenarios() throws ParseException
	{
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();
		PreferencesPage pre = getPageFactory().preferencesPage();
		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());
		audi.selectbusinessunit();
		audi.pageLoaderLogo();
		// audi.clickAudiencelink();
		audi.clickAudienceMasterdatafromMenu();
		audi.synchHistoryFilter(RESET_COLOR, GREEN_COLOR, BLUE_COLOR);
		audi.selectSegmentationList("All segment list");
		String calenderDate = audi.getStrText(AudienceRepository.audience_calenderdate);
		String[] split = calenderDate.split("-");
		String startDate = split[0].trim();
		String endDate = split[1].trim();
		String currentdate = Instant.now().toString().substring(0, 10);
		Date parsecurrentDate = PageBase.convertCalendarToDate(currentdate, "yyyy-MM-dd");
		Date parseStartDate = PageBase.convertCalendarToDate(startDate, "MMM dd, yyyy");
		Date parseEnddate = PageBase.convertCalendarToDate(endDate, "MMM dd, yyyy");
		/*
		 * if (parseInvoiceDate.equals(parseStartDate)) { BaseTest.getTest().log(Status.INFO,
		 * "Date filter is starts with account created date as expected"); } else { BaseTest.getTest().log(Status.FAIL,
		 * "Date filter is not starts with account created date"); BaseTest.takeScreenshot(); }
		 */
		if (parsecurrentDate.equals(parseEnddate))
		{
			BaseTest.getTest().log(Status.INFO, "Date filter is ends with current date as expected");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Date filter is not ends with current date");
			BaseTest.takeScreenshot();
		}
		String startdateMonth = startDate.replaceAll("[^A-Za-z]", " ").trim();
		String[] split2 = startDate.split(",");
		String startedDay = split2[0].replaceAll("[^\\d]", "");
		String startdateYear = split2[split2.length - 1].trim();

		String enddateMonth = endDate.replaceAll("[^A-Za-z]", " ").trim();
		String[] split4 = endDate.split(",");
		String endDay = split4[0].replaceAll("[^\\d]", "");
		String endYear = split4[split2.length - 1].trim();
		audi.javaScriptScrolltoTop();
		audi.explicitwaitforclick(PageBase.autolocator(AudienceRepository.audience_Filter_Menu), 30);
		audi.clickElement(AudienceRepository.audience_Filter_Menu);
		audi.explicitwaitforclick(PageBase.autolocator(AudienceRepository.audience_FilterMenu_List), 30);
		audi.selectlistelementsAndProceed(AudienceRepository.audience_FilterMenu_List, "Custom range");
		String fullDate = audi.getStrText(AudienceRepository.audience_fulldate);
		String[] split3 = fullDate.split("-");

		String accountCreatedMonthAndYear = split3[0].trim();
		String accountCreatedDay = audi.getStrText(AudienceRepository.audience_customrangestartdate);

		if (accountCreatedMonthAndYear.contains(startdateMonth) && accountCreatedMonthAndYear.contains(startdateYear) && accountCreatedDay.contains(startedDay))
		{
			BaseTest.getTest().log(Status.INFO, "Custom range filter is starts with account created date as expected");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Custom range filter is not starts with account created date");
			BaseTest.takeScreenshot();
		}
		String previousButtonState = audi.getTextBoxVal(AudienceRepository.audience_customrangepreviousicon, "class");
		if (previousButtonState.contains("disable"))
		{
			BaseTest.getTest().log(Status.INFO, "Previous arrow is in disable state in default as expected");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Previous arrow is not in disable state in default");
		}
		while (audi.isElementPresent(AudienceRepository.audience_customrangenextarrow))
		{
			audi.clickElement(AudienceRepository.audience_customrangenextarrow);
		}
		String nextButtonState = audi.getTextBoxVal("previous icon,xpath,//span[contains(@class,'k-calendar-nav k-hstack')]//button[contains(@class,'next')]", "class");
		if (nextButtonState.contains("disable"))
		{
			BaseTest.getTest().log(Status.INFO, "Next arrow is in disable state after navigating to current date");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Next arrow is not in disable state after navigating to current date");
		}

		String curruntMonthandYear = audi.getStrText(",xpath,//button[contains(@class,'k-button k-flat k-calendar-title')]");
		String customDateEndDay = audi.getStrText("custom range start day,xpath,//tr[@class='k-calendar-tr']//td[contains(@class,'range-end')]");

		if (curruntMonthandYear.contains(enddateMonth) && curruntMonthandYear.contains(endYear) && endDay.contains(customDateEndDay))
		{
			BaseTest.getTest().log(Status.INFO, "Custom range filter is starts with account created date as expected");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Custom range filter is not starts with account created date");
			BaseTest.takeScreenshot();
		}
	}

	@Test(testName = "Invalid Audience Upload ", description = "Invalid Audience Upload Alert")
	public void invalidAudienceAlert()
	{
		SyncHistoryPage sync = getPageFactory().syncHistoryPage();
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();
		PreferencesPage pre = getPageFactory().preferencesPage();
		sync.login(sync.dPropertyLoginUserName(), sync.dPropertyLoginPswrd());
		sync.selectbusinessunit();
		audi.pageLoaderLogo();
		audi.clickAudienceMasterdatafromMenu();
		audi.clickAddaudience();
		audi.selectImportsource();
		audi.selectListtype();
		audi.attributeMapping();
		String ImportDescription = audi.enterImportdesc();
		audi.getTextBoxVal(AudienceRepository.audience_browsebutton, "class");
		audi.audience_upload_File(BaseTest.getData().Chooseyourfile1);
		audi.clickUpload();
		// audi.segmentationPageValidate();
		audi.selectDoubleOptchkbox();
		audi.clicksave();
		audi.returntomasterlist();
		// audi.selectAdhocAgreementProceed();
		sync.synchistorynavigation();
		audi.threadSleep(600000);
		audi.refresh();
		sync.invalidAuidence(ImportDescription);

	}

}
