package utility;

import org.openqa.selenium.WebDriver;

import com.microsoft.playwright.Page;

import pages.AccountSetupCreation;
import pages.AnalyticsListingPage;
import pages.AnalyticsOverviewDetailsPage;
import pages.AudienceDatabase;
import pages.AudienceNegativeScenarios;
import pages.AudiencePage_Dynamiclist;
import pages.AudiencePage_Targetlist;
import pages.AudiencePage_Upload;
import pages.CommunicationCreatePage;
import pages.CommunicationEmailChannelPage;
import pages.CommunicationListingPage;
import pages.CommunicationMobilePushPage;
import pages.CommunicationNegativeScenarioPage;
import pages.CommunicationNotificationPage;
import pages.CommunicationPlannerPage;
import pages.CommunicationQRChannelPage;
import pages.CommunicationSMSChannelPage;
import pages.CommunicationWhatsAppPage;
import pages.Communicationdashboardpage;
import pages.DynamiclistCreatePage;
import pages.HomePage;
import pages.LoginPage;
import pages.OtpPage;
import pages.PreCommunicationAnalyticsPage;
import pages.PreCommunicationSummaryPage;
import pages.PreferencesPage;
import pages.SyncHistoryPage;

public class PageFactory
{
	private WebDriver driver;
	private Page page;
	private LoginPage loginPage = null;

	public PageFactory(WebDriver driver, Page page) {
		this.driver = driver;
		this.page = page;
	}

	public LoginPage loginPage()
	{
		return new LoginPage(driver, page, this);
	}

	public HomePage homePage()
	{
		return new HomePage(driver, page, this);
	}

	public CommunicationCreatePage communicationcreatepage()
	{
		return new CommunicationCreatePage(driver, page, this);
	}

	public OtpPage otpPage()
	{
		return new OtpPage(driver, page, this);
	}

	public AccountSetupCreation acctSetupPage()
	{
		return new AccountSetupCreation(driver, page, this);
	}

	public PreferencesPage preferencesPage()
	{
		return new PreferencesPage(driver, page, this);
	}

	public AudiencePage_Upload audiencepage_Upload()
	{
		return new AudiencePage_Upload(driver, page, this);
	}

	public SyncHistoryPage syncHistoryPage()
	{
		return new SyncHistoryPage(driver, page, this);
	}

	public AudiencePage_Targetlist audiencepage_Targetlist()
	{
		return new AudiencePage_Targetlist(driver, page, this);
	}

	public CommunicationEmailChannelPage communicationEmailChannelPage()
	{
		return new CommunicationEmailChannelPage(driver, page, this);
	}

	public CommunicationListingPage communicationListingPage()
	{
		return new CommunicationListingPage(driver, page, this);
	}

	public CommunicationSMSChannelPage communicationsmschannelpage()
	{
		return new CommunicationSMSChannelPage(driver, page, this);
	}

	public AudienceDatabase audienceDatabase()
	{
		return new AudienceDatabase(driver, page, this);
	}

	public AnalyticsOverviewDetailsPage analyticsOverviewDetailsPage()
	{
		return new AnalyticsOverviewDetailsPage(driver, page, this);
	}

	public PreCommunicationSummaryPage preCommunicationSummaryPage()
	{
		return new PreCommunicationSummaryPage(driver, page, this);
	}

	public PreCommunicationAnalyticsPage preCommunicationAnalyticsPage()
	{
		return new PreCommunicationAnalyticsPage(driver, page, this);
	}

	public CommunicationWhatsAppPage communicationWhatsAppPage()
	{
		return new CommunicationWhatsAppPage(driver, page, this);
	}

	public CommunicationQRChannelPage communicationqrchannelpage()
	{
		return new CommunicationQRChannelPage(driver, page, this);
	}

	public DynamiclistCreatePage DynamiclistCreatePage()
	{
		return new DynamiclistCreatePage(driver, page, this);
	}

	public AudiencePage_Dynamiclist Audiencepagedynamiclist()
	{
		return new AudiencePage_Dynamiclist(driver, page, this);
	}

	public CommunicationNotificationPage communication_Notification()
	{
		return new CommunicationNotificationPage(driver, page, this);
	}

	public PreferencesPage PreferencesPage()
	{
		return new PreferencesPage(driver, page, this);
	}

	public CommunicationMobilePushPage communicationMobilePushPage()
	{
		return new CommunicationMobilePushPage(driver, page, this);

	}

	public CommunicationPlannerPage CommunicationPlannerPage()
	{
		return new CommunicationPlannerPage(driver, page, this);
	}

	public SyncHistoryPage SyncHistoryPage()
	{
		return new SyncHistoryPage(driver, page, this);
	}

	public Communicationdashboardpage communicationdashboardpage()
	{
		return new Communicationdashboardpage(driver, page, this);
	}

	public AnalyticsListingPage analyticsListingPage()
	{
		return new AnalyticsListingPage(driver, page, this);
	}

	public CommunicationNegativeScenarioPage CommunicationNegativeScenarioPage()
	{
		return new CommunicationNegativeScenarioPage(driver, page, this);
	}

	public AudienceNegativeScenarios AudienceNegativeScenarios()
	{
		return new AudienceNegativeScenarios(driver, page, this);

	}
}
