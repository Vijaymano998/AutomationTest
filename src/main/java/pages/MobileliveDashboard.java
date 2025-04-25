package pages;

import org.openqa.selenium.WebDriver;

import com.microsoft.playwright.Page;

import repository.DashboardRepository;
import repository.ObjectRepository;
import utility.PageFactory;

public class MobileliveDashboard extends HomePage
{
	public MobileliveDashboard(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	public MobileliveDashboard MobileliveDashboard() throws InterruptedException
	{
		clickElement(DashboardRepository.dashboard_dotmenuicon_click);
		Thread.sleep(ObjectRepository.wait3sec);
		selectlistelements(DashboardRepository.dashboard_dropdown_optionsselect, "");
		Thread.sleep(ObjectRepository.wait10sec);
		// String liveVisitors = getStrText(dashboadashboard_mobilelive_visitorstatus_livevisitors);
		// String totalInstallations = getStrText(dashboard_mobilelive_visitorstatus_totalinstallation);
		/*
		 * BaseTest.getTest().log(Status.INFO, "Live visitors  " + liveVisitors); BaseTest.getTest().log(Status.INFO, "totalInstallations  " +
		 * totalInstallations); System.out.println(liveVisitors + totalInstallations);
		 */
		return this;
	}

	/*
	 * public String activeVisitorsTraffic() { if (isDisplayed(DashboardRepository.dashboard_mobileLivedashboard_activevisitorstraffic_nodata)) {
	 * BaseTest.getTest().log(Status.INFO, "Shows No data available in Active visitors traffic"); } else { BaseTest.getTest().log(Status.INFO,
	 * "Data available in Active visitors traffic"); } return this; } public String keymetrics() { Map<String, Integer> key = new HashMap<>(); Map
	 * keyMetrics = new HashMap<String, Integer>(); key.get(DashboardRepository.dashboard_mobilelive_keymetrcis_sessions);
	 * key.get(DashboardRepository.dashboard_mobilelive_keymetrcis_screenviews);
	 * key.get(DashboardRepository.dashboard_mobilelive_keymetrcis_avgtimespent);
	 * key.get(DashboardRepository.dashboard_mobilelive_keymetrics_avgscreen);
	 * key.get(DashboardRepository.dashboard_mobilelive_activeusers_inapperrors);
	 * key.get(DashboardRepository.dashboard_mobilelive_activeusers_crashes);
	 * key.get(DashboardRepository.dashboard_mobilelive_activeusers_uninstalls); return this; }
	 */

}
