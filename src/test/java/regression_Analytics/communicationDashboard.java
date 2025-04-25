package regression_Analytics;

import org.testng.annotations.Test;

import pages.Communicationdashboardpage;
import utility.BaseTest;

public class communicationDashboard extends BaseTest
{

	@Test(testName = "Channel performance", description = "Dashboard channel performance")
	public void mobileLive_VisitorStatus() throws InterruptedException
	{
		Communicationdashboardpage dashboard = getPageFactory().communicationdashboardpage();
		dashboard.login(dashboard.dPropertyLoginUserName(), dashboard.dPropertyLoginPswrd());
		dashboard.selectbusinessunit();
		dashboard.MobileliveDashboardVisitorStatus();
	}

	@Test(testName = "Active visitor traffic", description = "Active Visitors traffic")
	public void mobileLive_ActiveVisitorstraffic() throws InterruptedException
	{
		Communicationdashboardpage dashboard = getPageFactory().communicationdashboardpage();
		dashboard.login(dashboard.dPropertyLoginUserName(), dashboard.dPropertyLoginPswrd());
		dashboard.selectbusinessunit();
		dashboard.MobileliveDashboardVisitorStatus();
	}

	@Test(testName = "Key metrics", description = "Communication dashboard Key metrics")
	public void mobileLive_KeyMetrics()
	{
		Communicationdashboardpage dashboard = getPageFactory().communicationdashboardpage();
		dashboard.login(dashboard.dPropertyLoginUserName(), dashboard.dPropertyLoginPswrd());
		dashboard.selectbusinessunit();

	}

	@Test(testName = "Active users", description = "Active users")

	public void mobileLive_ActiveUser()
	{

		Communicationdashboardpage dashboard = getPageFactory().communicationdashboardpage();
		dashboard.login(dashboard.dPropertyLoginUserName(), dashboard.dPropertyLoginPswrd());
		dashboard.selectbusinessunit();

	}

	@Test(testName = "Mobile live Channel performance", description = "Dashboard channel performance")
	public void mobileLive_ChannelPerformance() throws InterruptedException
	{
		Communicationdashboardpage dashboard = getPageFactory().communicationdashboardpage();
		dashboard.login(dashboard.dPropertyLoginUserName(), dashboard.dPropertyLoginPswrd());
		dashboard.selectbusinessunit();
		dashboard.CommunicationDashboard_ChannelPerformance();

	}

	@Test(testName = "Mobile live Audience type", description = "Dashboard channel performance")
	public void mobileLive_Audiencetype() throws InterruptedException

	{
		Communicationdashboardpage dashboard = getPageFactory().communicationdashboardpage();
		dashboard.login(dashboard.dPropertyLoginUserName(), dashboard.dPropertyLoginPswrd());
		dashboard.selectbusinessunit();
		dashboard.CommunicationDashboard_Audiencetypes();

	}

	// DashboardTopPerformingCommunications DashboardAudienceBehaviourNodata dashboardTopEarningCommunication

	@Test(testName = "Channel performance", description = "Dashboard channel performance")

	public void dashboard_channelPerformance()
	{
		// TODO Auto-generated method stub
		Communicationdashboardpage dashboard = getPageFactory().communicationdashboardpage();
		dashboard.login(dashboard.dPropertyLoginUserName(), dashboard.dPropertyLoginPswrd());
		dashboard.selectbusinessunit();
		dashboard.CommunicationDashboard_ChannelPerformance();
	}

	@Test(testName = "Top performing communication", description = "Dashboard - Top performing communication")
	public void dashboard_topPerformingCommunication()
	{
		Communicationdashboardpage dashboard = getPageFactory().communicationdashboardpage();
		dashboard.login(dashboard.dPropertyLoginUserName(), dashboard.dPropertyLoginPswrd());
		dashboard.selectbusinessunit();
		dashboard.DashboardTopPerformingCommunications();
	}

	@Test(testName = "Top earning communication", description = "Dahboard - Top earning communication")
	public void dashboard_Audiencebehaviour()
	{
		Communicationdashboardpage dashboard = getPageFactory().communicationdashboardpage();
		dashboard.login(dashboard.dPropertyLoginUserName(), dashboard.dPropertyLoginPswrd());
		dashboard.selectbusinessunit();
		dashboard.DashboardAudienceBehaviourNodata();
	}

	@Test(testName = "Segments", description = "Dashboard - Segements")
	public void dashboard_Segments()
	{
		Communicationdashboardpage dashboard = getPageFactory().communicationdashboardpage();
		dashboard.login(dashboard.dPropertyLoginUserName(), dashboard.dPropertyLoginPswrd());
		dashboard.selectbusinessunit();
		dashboard.dashboardSegements();
	}

	@Test(testName = "ROI trends", description = "Dashboard - ROI trends")
	public void dashboard_ROItrends()
	{
		Communicationdashboardpage dashboard = getPageFactory().communicationdashboardpage();
		dashboard.login(dashboard.dPropertyLoginUserName(), dashboard.dPropertyLoginPswrd());
		dashboard.selectbusinessunit();
		dashboard.dashboardROItrend();
	}

	@Test(testName = "Lead generated", description = "Dashboard - Lead generated")
	public void dashboard_LeadGenerated()
	{
		Communicationdashboardpage dashboard = getPageFactory().communicationdashboardpage();
		dashboard.login(dashboard.dPropertyLoginUserName(), dashboard.dPropertyLoginPswrd());
		dashboard.selectbusinessunit();
		dashboard.leadGenerated();
	}

	@Test(testName = "Average Conversion time", description = "Dashboard - Average conversion time")
	public void dashboard_AverageConversionTime()
	{
		Communicationdashboardpage dashboard = getPageFactory().communicationdashboardpage();
		dashboard.login(dashboard.dPropertyLoginUserName(), dashboard.dPropertyLoginPswrd());
		dashboard.selectbusinessunit();
		dashboard.dashboard_averageconversiontime();
	}

}