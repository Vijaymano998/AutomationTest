package regression_Analytics;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import pages.AnalyticsOverviewDetailsPage;
import repository.AnalyticsRepository;
import utility.BaseTest;

public class AnalyticsEmailScenarios extends BaseTest
{

	@Test(testName = "", description = "Pw Analytics Email Scenarios")
	public void pw_analyticsEmailScenarios()
	{
		AnalyticsOverviewDetailsPage analytics = getPageFactory().analyticsOverviewDetailsPage();

		analytics.pw_login(analytics.dPropertyLoginUserName(), analytics.dPropertyLoginPswrd());
		analytics.pw_selectbusinessunit();

		String communicationName = "MDC Attribute Test Feb 19 2025";
		analytics.pw_clickCommAnalyticsListingPagefromMenu();
		analytics.pw_analyticSearchcommunication(communicationName);
		List<Map<String, String>> analyticsPageValue = analytics.pw_getListingPageChannelDetails("analytics", communicationName);
		analytics.pw_clickReports(communicationName);
//		analytics.pw_setGoldenCommunication(communicationName);
		analytics.pw_headerBenchmarkIcon();
//		analytics.csrPageDownloadIcon();
		analytics.pw_overviewPortletChannelViseCount();
		analytics.pw_getOverviewPageChannelDetails();
		analytics.pw_compareAnalyticsListingAndCSRPageValidate(analyticsPageValue);
		analytics.pw_communicationAnalysisCSRPage();
	}

	@Test(testName = "", description = "Analytics Email Scenarios")
	public void analyticsEmailScenarios()
	{
		AnalyticsOverviewDetailsPage analytics = getPageFactory().analyticsOverviewDetailsPage();

		analytics.login(analytics.dPropertyLoginUserName(), analytics.dPropertyLoginPswrd());
		analytics.selectbusinessunit();

		String communicationName = "TestSMSPreview-Mar05";
		analytics.clickCommAnalyticsListingPagefromMenu();
		analytics.analyticSearchcommunication(communicationName);
		List<Map<String, String>> analyticsPageValue = analytics.getListingPageChannelDetails("analytics", communicationName);
		analytics.clickReports(communicationName);
		analytics.setGoldenCommunication(communicationName);
		analytics.headerBenchmarkIcon();
		analytics.csrPageDownloadIcon();
		analytics.overviewPortletChannelViseCount();
		analytics.getOverviewPageChannelDetails();
		analytics.compareAnalyticsListingAndCSRPageValidate(analyticsPageValue);
		analytics.communicationAnalysisCSRPage();
	}

	@Test(description = "Analytics Details - Email with EDM upload Communication Reports validation for Single Dimension")
	public void pwanalyticsDetailsSDCEmailEdmCommunication()
	{
		AnalyticsOverviewDetailsPage analytics = getPageFactory().analyticsOverviewDetailsPage();

		analytics.pw_login(analytics.dPropertyLoginUserName(), analytics.dPropertyLoginPswrd());
		analytics.pw_selectbusinessunit();

		String communicationName = "EamilBlast150325";
		analytics.pw_clickCommAnalyticsListingPagefromMenu();
		analytics.pw_analyticSearchcommunication(communicationName);
		List<Map<String, String>> analyticsPageValue = analytics.pw_getListingPageChannelDetails("analytics", communicationName);
		analytics.pw_clickReports(communicationName);

		analytics.pw_getOverviewPageChannelDetails();
		analytics.pw_compareAnalyticsListingAndCSRPageValidate(analyticsPageValue);
		analytics.pw_validateEmailAnalyticsSentCount();
		analytics.pw_getDetailsPageEmailChannelDetails();

		analytics.pw_reachPortlet("Email");
		int uniqueClicks = analytics.pw_engagementPortlet("Email");
		analytics.pw_userEngagementPortlet("Opens by browser", AnalyticsRepository.analytics_details_opensByBrowser);
		analytics.pw_userEngagementPortlet("Opens by devices", AnalyticsRepository.analytics_details_opensByDevices);
		if (analytics.pw_totalLinkClickActivity(analytics.listingPageEngagement))
		{
			analytics.pw_verifyDownloadedCSV("Email");
			analytics.uniqueClicksCount("Email", analytics.listingPageEngagement);
		}
		analytics.pw_communicationStatus("Email");
	}

	@Test(description = "Analytics Details - Email with EDM upload Communication Reports validation for Single Dimension")
	public void analyticsDetailsSDCEmailEdmCommunication()
	{
		AnalyticsOverviewDetailsPage analytics = getPageFactory().analyticsOverviewDetailsPage();

		analytics.login(analytics.dPropertyLoginUserName(), analytics.dPropertyLoginPswrd());
		analytics.selectbusinessunit();

		String communicationName = "EamilBlast150325";
		analytics.clickCommAnalyticsListingPagefromMenu();
		analytics.analyticSearchcommunication(communicationName);
		List<Map<String, String>> analyticsPageValue = analytics.getListingPageChannelDetails("analytics", communicationName);
		analytics.clickReports(communicationName);

		analytics.getOverviewPageChannelDetails();
		analytics.compareAnalyticsListingAndCSRPageValidate(analyticsPageValue);
		analytics.validateEmailAnalyticsSentCount();
		analytics.getDetailsPageEmailChannelDetails();

		analytics.reachPortlet("Email");
		int uniqueClicks = analytics.engagementPortlet("Email");
		analytics.userEngagementPortlet("Opens by browser", AnalyticsRepository.analytics_details_opensByBrowser);
		analytics.userEngagementPortlet("Opens by devices", AnalyticsRepository.analytics_details_opensByDevices);
		if (analytics.totalLinkClickActivity(analytics.listingPageEngagement))
		{
			analytics.verifyDownloadedCSV("Email");
			analytics.uniqueClicksCount("Email", analytics.listingPageEngagement);
		}
		analytics.communicationStatus("Email");
	}
}
