package regression_Communication;

import org.testng.annotations.Test;

import pages.CommunicationEmailChannelPage;
import pages.CommunicationSMSChannelPage;
import pages.PreCommunicationAnalyticsPage;
import utility.BaseTest;

public class CommunicationSoicalPostScenarios extends BaseTest
{
	@Test(testName = "", description = "Social post communication setup - Facebook")
	public void socialPostFB()
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
		comm.channelType5().analyticOption2();
		comm.clickNext().createSmarturl();
		comm.socialPostCreation("Facebook");
		comm.communicationlistingPageStatusCompare("Scheduled");

	}

	@Test(testName = "", description = "Social post communication setup - Twitter")
	public void socialPostTwitter()
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
//		comm.analyticOption1().analyticOption2();
		comm.channelType5().analyticOption2();
		comm.clickNext().createSmarturl();
		comm.socialPostCreation("Twitter");
		comm.communicationlistingPageStatusCompare("Scheduled");
	}

	@Test(testName = "", description = "Social post communication setup - Instagram")
	public void socialPostInstagram()
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
		comm.channelType5().analyticOption2();
//		comm.analyticOption1().analyticOption2();
		comm.clickNext().createSmarturl();
		comm.socialPostCreation("Instagram");
		comm.communicationlistingPageStatusCompare("Scheduled");
	}

	@Test(testName = "", description = "Social post communication setup - LinkedIn")
	public void socialPostLinkedin()
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
		// comm.analyticOption1().analyticOption2();
		comm.channelType5().analyticOption2();
		comm.clickNext().createSmarturl();
		comm.socialPostCreation("Linkedin");
		comm.communicationlistingPageStatusCompare("Scheduled");
	}

	@Test(testName = "", description = "Generating smartlink by using paid media channels")
	public void paidMediaSetupAndBlast()
	{

		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();

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

	@Test(testName = "", description = "Social post Facebook regression test cases")
	public void socialPostFacebookRegression()
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
		// comm.analyticOption1().analyticOption2();
		comm.channelType5().analyticOption2();
		comm.clickNext().createSmarturl();
		comm.socialPostFBRegression();
	}
}
