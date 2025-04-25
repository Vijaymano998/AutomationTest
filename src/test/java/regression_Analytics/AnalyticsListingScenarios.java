package regression_Analytics;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import pages.AnalyticsOverviewDetailsPage;
import utility.BaseTest;

public class AnalyticsListingScenarios extends BaseTest
{

	@Test(testName = "", description = "Analytics Listing Item Per page")
	public void analyticsListingItemperPage()
	{
		AnalyticsOverviewDetailsPage analytics = getPageFactory().analyticsOverviewDetailsPage();

		analytics.login(analytics.dPropertyLoginUserName(), analytics.dPropertyLoginPswrd());
		analytics.selectbusinessunit();
		analytics.clickCommAnalyticsListingPagefromMenu();
		analytics.validateItemPerPages();
		analytics.validateDisableAndEnableArrow();
	}

	@Test(testName = "SDX-TS-ANL-008", description = "Analytics listing page substatus count validate")
	public void analyticsListingPageSubstatusCountValidate()
	{
		AnalyticsOverviewDetailsPage analytics = getPageFactory().analyticsOverviewDetailsPage();

		analytics.login(analytics.dPropertyLoginUserName(), analytics.dPropertyLoginPswrd());
		analytics.selectbusinessunit();

		String communicationName = "Split AB Winner Communication Check Dec17";
		analytics.clickCommAnalyticsListingPagefromMenu();
		analytics.selectAllTimeDateRangeFilter();
		analytics.analyticSearchcommunication(communicationName);
		List<Map<String, String>> analyticsPageValue = analytics.getListingPageChannelDetails("analytics", communicationName);
		System.out.println(analyticsPageValue);
	}

	// Need to ask the requirement
	@Test(testName = "", description = "Analytics list and grid view validation")
	public void analyticsListAndGridViewValidation()
	{
		AnalyticsOverviewDetailsPage analytics = getPageFactory().analyticsOverviewDetailsPage();

		analytics.login(analytics.dPropertyLoginUserName(), analytics.dPropertyLoginPswrd());
		analytics.selectbusinessunit();

		analytics.clickCommAnalyticsListingPagefromMenu();
		List<Map<String, String>> gridView = analytics.validateAnalyticsGridView();
		List<Map<String, String>> listView = analytics.validateAnalyticsListView();
		analytics.writeLog(gridView.equals(listView), "Grid view and List view data is same as expected.", "Grid view and List view data is not same as expected.");
	}

}
