package regression_Communication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.AudiencePage_Dynamiclist;
import pages.CommunicationEmailChannelPage;
import pages.CommunicationPlannerPage;
import pages.CommunicationSMSChannelPage;
import pages.PreCommunicationAnalyticsPage;
import repository.ObjectRepository;
import utility.BaseTest;
import utility.PageBase;

public class CommunicationListingpageScenario extends BaseTest
{

	@Test(description = "Communication edit and verify")
	public void communicationEditAndVerify()
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();

		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.commEditAndVerify("Email", System.getProperty("editverifyemail"));
		comm.commEditAndVerify("SMS", System.getProperty("editverifysms"));
		comm.commEditAndVerify("Whatsapp", System.getProperty("editverifywhatsapp"));
		comm.commEditAndVerify("Webpush", System.getProperty("editverifywebpush"));
		comm.commEditAndVerify("Mobilepush", System.getProperty("editverifymobilepush"));
	}

	@Test(testName = "", description = "Communication listing page - All Time - Date Range filter validation")
	public void listingPage_AllTimeDateFilter()
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickCommunicationListpagefromMenu();
		String timeStamp = ",xpath,//div[@class='communication-content']//small[contains(.,'Cre')]";
		dynamic.dateRangeFilter(timeStamp);
	}

	@Test(testName = "", description = "Communication listing page - Last 7 days - Date Range filter validation")
	public void listingPage_Last7DaysDateFilter()
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickCommunicationListpagefromMenu();
		String timeStamp = ",xpath,//div[@class='communication-content']//small[contains(.,'Cre')]";
		dynamic.dateRangeFilter(timeStamp);
		System.out.println();
	}

	@Test(testName = "", description = "Communication listing page - Last 30 days - Date Range filter validation")
	public void listingPage_Last30DaysDateFilter()
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickCommunicationListpagefromMenu();
		String timeStamp = ",xpath,//div[@class='communication-content']//small[contains(.,'Cre')]";
		dynamic.dateRangeFilter(timeStamp);
	}

	@Test(testName = "", description = "Communication listing page - Custom range - Date Range filter validation")
	public void listingPage_CustomRangeDateFilter()
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickCommunicationListpagefromMenu();
		String timeStamp = ",xpath,//div[@class='communication-content']//small[contains(.,'Cre')]";
		dynamic.dateRangeFilter(timeStamp);
	}

	@Test(testName = "", description = "Communication sub status check (Preview, Edit, Analytics)")
	public void communicationSubStatusCheck()
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCommunicationListpagefromMenu();
		comm.expandcommunication("EmailSeedcomm_3_24_1733_110");
	}

	@Test(testName = "", description = "Communication listing page items per page and page navigation")
	public void communicationItemsPerPage()
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCommunicationListpagefromMenu();
		comm.validateDisableAndEnableArrow();
		comm.validateItemPerPages();
	}

	@Test(testName = "", description = "Communication Gallery page positve flow")
	public void communicationGalleryPage()
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.galleryPagePositiveScenarios();
	}

	@Test(testName = "", description = "Communication Planner page positve flow")
	public void communicationPlannerPage()
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.plannerPagePositiveScenarios();
	}

	@Test(testName = "", description = "Deferred deep link Android/ios")
	public void deferredDeepLinkAndroidAndIos()
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
		comm.deferredDeeplink();
	}

	@Test(testName = "", description = "Communication Planner")
	public void CommunicationPlanner()
	{

		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();

		int startDate = 0;
		int endDate = 3;
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.plannerPagePositiveScenarios();

	}

	@Test(testName = "", description = "Communication Listing page -All communication validation")
	public void allCommunicationValidation()
	{

		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();

		int startDate = 0;
		int endDate = 3;
		comm.login(System.getProperty("ChlidAccount"), comm.dPropertyLoginPswrd());
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
		comm.javaScriptScrollDown();
		WebElement element = getWebDriver().findElement(By.xpath("(//button[normalize-space()='Next'])[1]"));
		element.click();
		comm.reschedule(startDate);
		comm.pageLoaderLogo();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("Scheduled");
		comm.logout();
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.clickCommunicationListpagefromMenu();
		comm.clickAllCommunication("All communications");
		boolean searchResult = comm.searchCommunication("communicationlisting", comm.communicationName);
		comm.writeLog(searchResult, "Communication created in child account reflect in parent account as expected", "Communication created in child account is not reflect in parent account");
	}

	@Test(description = "SDC Communication plan page test cases")
	public void sdcPlanPageScenarios()
	{

		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();

		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.sdcCommPlanPageScenarios();
	}

	@Test(description = "MDC Communication plan page test cases")
	public void mdcPlanPageScenarios()
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();

		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.mdcCommPlanPageScenarios();
	}

	@Test(description = "Communication listing page Test scenarios")
	public void listingPageScenarios()
	{
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.commListingPageScenarios();
	}

	@Test(testName = "", description = "Communication listing page searchbox scenarios")
	public void listingPageSearchBoxScenarios()
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickCommunicationListpagefromMenu();
		dynamic.searchBoxFunctionScenarios();

	}

	@Test(testName = "", description = "Communication Planner New Communication")
	public void CommunicationPlannerNewcommunication()
	{

		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationPlannerPage sms = getPageFactory().CommunicationPlannerPage();

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
		comm.commTextEmailPersona();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.emailtimezone();
		comm.enterEmailScheduleTime(startDate);
		comm.threadSleep(ObjectRepository.wait10sec);
		comm.javaScriptScrollDown();
		WebElement element = getWebDriver().findElement(By.xpath("(//button[normalize-space()='Next'])[1]"));
		element.click();
		precomm.webAnalyticsDetails().preCommunicationPage();
		comm.communicationlistingPageStatusCompare("In progress");
		sms.PlannerpagescenarioNewcommunication();

	}

	@Test(description = "Scheduled Communication edit and verify")
	public void communicationScheduledEditAndVerify()
	{
		CommunicationSMSChannelPage sms = getPageFactory().communicationsmschannelpage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();

		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.commScheduledEditAndVerify("Email", "Email retain check Mar03");
		comm.commEditAndVerify("SMS", "smsTL_2_27_1646_455");
		comm.commEditAndVerify("Whatsapp", "Whatsapp_6_20_0131_975");
		comm.commEditAndVerify("Webpush", "Test Web Push Blast Check");
		comm.commEditAndVerify("Mobilepush", "MobilePushCommunicationTestingCarousel-Feb27");
	}
}
