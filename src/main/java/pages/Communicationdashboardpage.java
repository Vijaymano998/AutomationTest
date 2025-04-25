package pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Page;

import repository.DashboardRepository;
import repository.ObjectRepository;
import utility.BaseTest;
import utility.PageFactory;

public class Communicationdashboardpage extends HomePage
{
	public Communicationdashboardpage(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	public Communicationdashboardpage MobileliveDashboardVisitorStatus() throws InterruptedException
	{
		clickElement(DashboardRepository.dashboard_dotmenuicon_click);
		Thread.sleep(ObjectRepository.wait3sec);
		selectlistelements(DashboardRepository.dashboard_dropdown_optionsselect, "");
		Thread.sleep(ObjectRepository.wait10sec);
		String liveVisitors = getStrText(DashboardRepository.dashboard_mobilelive_visitorstatus_livevisitors);
		String totalInstallations = getStrText(DashboardRepository.dashboard_mobilelive_visitorstatus_totalinstallation);
		BaseTest.getTest().log(Status.INFO, "Live visitors  " + liveVisitors);
		BaseTest.getTest().log(Status.INFO, "totalInstallations  " + totalInstallations);
		System.out.println(liveVisitors + totalInstallations);
		return this;
	}

//communication - 	//h4[text()='Top performing communications']/ancestor::div[@class='portlet-container portlet-md']//ul/li//p

//percentage - 	//h4[text()='Top performing communications']/ancestor::div[@class='portlet-container portlet-md']//ul/li//p/parent::div/following-sibling::div

	public Map<String, Integer> topPerformingChannels()
	{
		// List<WebElement> topComm = new LinkedList<WebElement>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<WebElement> topcommunications = findElements(DashboardRepository.dashboard_topperformingCommunication);
		List<WebElement> topCommunicationPercetage = findElements(DashboardRepository.dashboard_topcommunicationPercentage);
		for (int i = 0; i < topcommunications.size(); i++)
		{
			String topComm = topcommunications.get(i).getText();
			int topchannel = Integer.parseInt(topCommunicationPercetage.get(i).getText().replaceAll("%", "").trim());
			map.put(topComm, topchannel);
		}
		return map;
	}

	// Communication dashboard 06/02/25

	public Communicationdashboardpage CommunicationDashboard_ChannelPerformance()
	{
		if (isDisplayed(DashboardRepository.dashboard_channelperformance_nodata))
		{
			BaseTest.getTest().log(Status.WARNING, "Communication dashboard channel performace portlet shows no data avaiables");

		} else
		{
			BaseTest.getTest().log(Status.INFO, "Communication dashbard details shows properly");

		}
		return this;
	}

	public Communicationdashboardpage CommunicationDashboard_Audiencetypes()
	{
		if (isDisplayed(DashboardRepository.dashboard_topperformingcommunications))
		{
			BaseTest.getTest().log(Status.WARNING, "Communication dashboard channel performace portlest shows no data avaiables");
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Communication dashbard details shows properly");
		}
		return this;
	}

	public Communicationdashboardpage DashboardTopPerformingCommunications()
	{

		if (isDisplayed(DashboardRepository.dashboard_topperformingcommunications))
		{
			BaseTest.getTest().log(Status.WARNING, "Communication dashboard top performing communication shows no data available");
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Dashboard top performing communications detais shows properly");
		}
		return this;
	}

	public Communicationdashboardpage DashboardAudienceBehaviourNodata()
	{

		if (isDisplayed(DashboardRepository.dashboard_audiencebehaviour_nodata))
		{

			BaseTest.getTest().log(Status.WARNING, "Communication dashboard audience behaviour shows no data available");
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Communication dashboard audience behaviour details shows propelry");
		}
		return this;
	}

	public Communicationdashboardpage dashboardTopEarningCommunication()
	{
		if (isDisplayed(DashboardRepository.dashboard_segments_nodata))
		{
			BaseTest.getTest().log(Status.WARNING, "Dashboard - top earning communications portlet shows no data available");
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Dashboard - top earning communication details shows properly");
		}
		return this;
	}

	public Communicationdashboardpage dashboardSegements()
	{
		if (isDisplayed(DashboardRepository.dashboard_audiencebehaviour_nodata))
		{
			BaseTest.getTest().log(Status.WARNING, "Dashboard - Segments portlet shows no data available");
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Dashboard - Segments portlet details shows properly");
		}
		return this;
	}

	public Communicationdashboardpage dashboardROItrend()
	{
		if (isDisplayed(DashboardRepository.dashboard_roitreand_nodata))
		{
			BaseTest.getTest().log(Status.WARNING, "Dashboard - ROI trend portlet shows no data available");
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Dashboard - ROI trend portlet details shows properly");
		}
		return this;
	}

	public Communicationdashboardpage leadGenerated()
	{
		if (isDisplayed(DashboardRepository.dashboard_leadgenerated_nodata))
		{
			BaseTest.getTest().log(Status.WARNING, "Dashboard - Lead generated portlet shows no data available");
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Dashboard - Lead generated portlet details shows properly");
		}
		return this;
	}

	public Communicationdashboardpage dashboard_averageconversiontime()
	{
		if (isDisplayed(DashboardRepository.dashboard_averageconversiontime))
		{
			BaseTest.getTest().log(Status.WARNING, "Dashboard - Average conversion time portet shows no data available");
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Dashboard - Average conversion time portlet details shows properly");
		}
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
