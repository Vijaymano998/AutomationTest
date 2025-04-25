package repository;

public class DashboardRepository
{
	public static final String breadcrumbs = "Breadcrumb check,xpath,//ul[@class='breadcrumb']//li";

	public static final String allpage_tooltip = "Tooltip,xpath,//div[contains(@class,'tooltip-inner')]";
	public static final String pw_allpage_tooltip = "Tooltip,pw,//div[contains(@class,'tooltip-inner')]";
	public static final String save_button = "Save button,xpath,//button[.='Save']";
	public static final String homepage_audiencelinkclick = "Audience link,xpath,(//div[contains(@class,'navbar-header')]//span)[1]";
	public static final String homepage_businessUnit_click = "Bussiness unit,xpath,//div[contains(@class,'heading-dd-bu')]//button";

	public static final String hompage_companyname_click = "Company Name,xpath,(//div[contains(@class,'agency')])[2]//button";
	public static final String homepage_companyname_select = "Company list,xpath,//div[@class='dropdown-menu show dropdown-menu-end']//a";
	public static final String validation_message = "Validation message,xpath,//div[@class='validation-message']";
	public static final String ok_button = "Click OK,xpath,//button[.='OK']";
	public static final String homepage_audience_Targetlist = "TargetList link ,xpath,//a[@class='view dropdown-item'][.='Target lists']";
	public static final String homepage_audience_Dynamiclist = "Dynamic list link,xpath,//i[contains(@class,'dynamic-list')]/..";
	public static final String businessunit_popup = "Business unit popup,xpath,//p[contains(.,'Select the appropriate business unit and proceed.')]";
	// p[contains(.,'Business unit')]";
	public static final String businessunit_popup_okbutton = "select BU popup ok button,xpath,//button[(text()='OK')]";

	public static final String datefilter = "Date Filter,xpath,//span[@class='rs-dt-calendar-text']";
	public static final String dateFilterlist = "Date filter list,xpath,//ul[@class='rs-daterangepicker-list-view']//li";
	public static final String datefilter_customrange = "Custom Range,xpath,//li[.='Custom range']";
	public static final String customRange_StartmonthAndYear = " Start Month ,xpath, //button[contains(@class,'k-calendar-title')]";
	public static final String customRange_monthAndYearList = "Start Month,xpath, (//tbody[@class='k-calendar-tbody'])[1]//span";
	public static final String apply_button = "Apply button,xpath,//button[.='Apply']";

	// DASHBOARD PAGE

	public static final String allpage_common_selectdropdownlist = "Dropdown list,xpath, //div[@class='k-list-content']//li";
	public static final String commonPopupMessage = "Common Popup Message,xpath,//div[contains(@class,'modal show')]//p";

	public static final String homepage_allmenu_analyticslink = "Analytics menu,xpath,(//span[@id='rs_RSHeader_hicon'])[3]";
	public static final String pw_homepage_allmenu_analyticslink = "Analytics menu,pw,(//span[@id='rs_RSHeader_hicon'])[3]";

	// ############################################### //
	public static final String pwallpage_common_selectdropdownlist = "Dropdown list,pw, //div[@class='k-list-content']//li";

	public static final String homepage_dashboard_Dashboardlink = "Dashboard Header,xpath,//span[contains(text(),'Dashboard')]";
	public static final String breadcrumblistitem = "breadcrumb list item,xpath,//ul[@class='breadcrumb']//li";
	public static final String homepage_dashboard_commdisplay = "Communication page display,xpath,//div[@class='portlet-chart gauge-chart']";
	// public static final String homepage_businessUnit_click = "Bussiness unit,xpath,//div[@id='divdepartmnetuniquehide']//i";
	// public static final String homepage_businessUnit_select = "Bussiness unit list,xpath,//*[@id='ulDepartment']/li";
//	public static final String homepage_audience_Masterdatamanagement = "Audience Dashboard ,xpath,//li[@id='menu_recipients']//a[@href='/Audience/AudienceDashboard']";
	public static final String homepage_audience_DynamicList = "Dynamic list link,xpath, //a[contains(.,'Dynamic lists')]";
	public static final String homepage_dashboard_CommunicationCreate = "Communication create link,xpath, //a[contains(text(),' Create communication')]";
	public static final String homepage_dashboard_Communicationlist = "Communication listing,xpath,//a[@class='view dropdown-item'][text()='Communication listing']";
	public static final String homepage_dashboard_CommunicationGallery = "Communication gallery,xpath,//a[contains(.,'Gallery')]";
	public static final String homepage_dashboard_CommunicationPlanner = "Communication Planner,xpath, //a[contains(.,'Planner')]";
	public static final String homepage_allmenu_communicationanalytics = "Communication Analytics,xpath,//h1[contains(text(),'Communication analytics')]";
	public static final String homepage_allmenu_communicationanalytics360 = "Analytics 360,xpath,//a[normalize-space()='Audience analytics 360']";
	public static final String homepage_allmenu_auditLog = "Audit log,xpath,//a[normalize-space()='Audit log report']";
	public static final String homepage_allmenu_preferencespage = "Preferences,xpath, //*[@id='menu_prefence']//a/i";
	public static final String homepage_allmenu_pref_formgenerator = "Form,xpath, //a[contains(.,'Form generator')]";

	// All page validation
	public static final String allpage_copyright = "copyright text,xpath,//*[@class='wrapper copyright']//following::span[contains(.,'Copyright')]";
	public static final String allpage_privacy_policy = "privacy policy link,xpath,//*[@class='wrapper copyright']//following::a[contains(.,'policy')]";
	public static final String allpage_TermsConditions = "terms&condition link,xpath,//*[@class='wrapper copyright']//following::a[contains(.,'Terms')]";
	public static final String allpage_help = "help link,xpath,//a[@id='ataghelp']";
	public static final String allpage_footervalidationtext = "footer text,xpath,//*[@id='footer']/..//div[@class='col text-center']/h1";
	public static final String allpage_footervalidationhelptext = "footer help text,xpath,//*[@id='home_text']";
	public static final String allpage_privacypolicylinktext = "privacy policy link,link,Privacy policy";
	public static final String allpage_termsandconditionslinktext = "terms and conditions link,link,Terms & Conditions";
	public static final String allpage_helplinktext = "help link,link,Help";
	public static final String allpage_brandpoweredbylogo = "powered by logo,xpath,//*[@class='icon-poweredby-sign-medium icon-md fti footerIcon1']";
	public static final String allpage_brandcloudlogo = "brand cloud logo,xpath,//*[@class='icon-resulticks-cloud-new-large icon-lg fti footerIcon2']";

	// EXTRA ADDED

	public static final String preferences_targetlist_datacatalogue_click = "Confirm,xpath,  //*[(@id='btnschedule')][@onclick='scheduleforRecipientsDownload();']";
	public static final String preferences_formsubmit_click = "Confirm,xpath,//*[@id='btnconfirm']";
	public static final String analytics_comm_otpmsg = "OTP sent successfully,xpath,//div[contains(@class,'validation-message w-max-content success_msg')]";
	public static final String preferences_dataattribute_selectok = "Confirm,xpath,//input[@name='confirm']";
	public static final String homepage_resulticksLogo = "Resulticks logo,xpath,//i[@class='icon-poweredby-sign-medium icons-md']";

	// Dashboard latest
	public static final String dashboard_total_sortitems = "Dashboard Sort Items,xpath,//div[@class='dashboard-sort-item']";
	public static final String dashboard = "Dashboard,xpath,//*[@id='menu_Dashboard']";
	public static final String dashboard_earning_comm_dropdown = "Earning communication dropdown,xpath,//h4[@id='lblTopRevCamp']//..//ul//li//div[@class='dropdown pull-right default-dropdown']";
	public static final String dashboard_earning_comm_dropdown_select = "Earning Dropdown select,xpath,//div[@class='dropdown pull-right default-dropdown open']//ul//li//a[not(contains(@style,'none'))]";
	public static final String dashboard_earning_comm_details = "Earning comm details,xpath,//ul[@id='Revenue']";
	public static final String homepage_logout_link = "Logout,xpath,//i[@class='icon-rs-logout-medium icon-md white cursor-pointer']";
	public static final String homepage_logout_accept = "Confirm logout,xpath,//button[normalize-space()='OK']";
	public static final String homepage_logout_cancel = "Cancel log	out,xpath,//button[@class='sc-gsnTZi sc-dkzDqf drrCpN hdqomv']";

	public static final String homepage_preferencespage_home = "Preferences link,xpath,//a[contains(@href,'preferences')]";
//	public static final String homepage_audiencelinkclick = "Audience link,xpath,//a[contains(@href,'audience')]";
	/// ----------- //a[contains(@href,'communication')]
	public static final String homepage_communication_link = "Communication menu,xpath,(//a[@href])[2]";
	public static final String homepage_dashboard_link = "Dashboard menu,xpath,//a[contains(@href,'dashboard')]";
	public static final String homepage_dashboard_carousel = "Dashboard carousel,xpath,//div[@class='active carousel-item']";
	public static final String homepage_analytics_options = "Analytics drop-down,xpath,//div[@class='dropdown-menu show']//a";
	public static final String pw_analyticsListingoptions = "Analytics drop-down,pw,//div[@class='dropdown-menu show']//a";
	public static final String homepage_recentcommunication_hearder = "Recent communication header,xpath,//div[@class='portlet-header'][contains(.,'Recent communication')]";
	public static final String homepage_recentcommunication_portlet = "Recent communication portlet,xpath,//div[@class='portlet-container sp-slider']";
	public static final String homepage_myprofile = "My profile avatar,xpath,//div[@class='h-profile cursor-pointer']";
	public static final String dashboard_tooltip = "Tooltip,xpath,//div[contains(@style,'visible')]//span";

	public static final String pw_homepage_communication_link = "Communication menu,pw,(//a[@href])[2]";

	// Jasmine

	public static final String homepage_audience_Masterdatamanagement = "Audience Dashboard ,xpath,//a[contains(.,'Master data management')]";
	public static final String homepage_businessUnit_select = "Bussiness unit list,xpath,//div[@class='dropdown-menu show dropdown-menu-end']//a";
	public static final String homepage_audience_uploadsourceselect = "Audience upload source select dropdown,xpath,//div[@class='k-list-content']//li";
	/**
	 * Please write the Playwright locators below
	 */

	public static final String pw_businessunit_popup_okbutton = "select BU popup ok button,pw,//p[contains(text(),'usiness unit')]//..//..//button[text()='OK']";
	public static final String pw_homepage_businessUnit_click = "Bussiness unit,pw,#rs_RSPageHeader_departmentlist button";
	public static final String pw_homepage_businessUnit_select = "Bussiness unit list,pw,#rs_RSPageHeader_departmentlist a";
	public static final String pw_allpage_common_selectdropdownlist = "Dropdown list,pw,//div[@class='k-list-content']//li";

//Jasmine - Mobile live dashboard

	public static final String dashboard_dotmenuicon_click = "dashboard dot menu,xpath, //i[@id='rs_RSPageHeader_dot_menu']";
	public static final String dashboard_dropdown_optionsselect = "dashboard dropdown selct,xpath, //div[@x-placement='bottom-start']//a";
	public static final String dashboard_dropdown_click = "dashboard dropdown select,xpath, //div[@x-placement='bottom-start']";

	public static final String dashboard_mobileLivedashboard_activevisitorstraffic_nodata = "mobileLivedashboard active visitors traffic nodata,xpath, //*[text()='Active visitors traffic ']//parent::h4//parent::div/following-sibling::div//p";
	public static final String dashboard_mobilelive_visitorstatus_livevisitors = "mobile live visitor status_live visitor,xpath,//div[@class='row']//div[@class='col-md-4']//h4[text()='Visitor status ']//..//..//p[.='Live visitors']";
	public static final String dashboard_mobilelive_visitorstatus_totalinstallation = "mobile live visitor status total installation, xpath, //div[@class='row']//div[@class='col-md-4']//h4[text()='Visitor status ']//..//..//p[.='Total installations']";
	public static final String dashboard_mobilelive_keymetrcis_sessions = "mobile live sessions,xpath, //small[(text()='Sessions')]/preceding-sibling::h1";
	public static final String dashboard_mobilelive_keymetrcis_screenviews = "mobile live screen views,xpath, //small[text()='Screen views']/preceding-sibling::h1";
	public static final String dashboard_mobilelive_keymetrcis_avgtimespent = "mobile live keymetrics avg time spent,xpath, //small[text()='Avg. time spent']/preceding-sibling::h3";
	public static final String dashboard_mobilelive_keymetrics_avgscreen = "mobile live keymetrics avg screen,xpath, //small[text()='Avg. screen/session']/preceding-sibling::h3";
	public static final String dashboard_mobilelive_activeusers_inapperrors = "mobile active users inapp errors,xpath, //small[text()='In-app errors']/preceding-sibling::h3";
	public static final String dashboard_mobilelive_activeusers_crashes = "mobile live dashboard active users crashes,xpath,//small[text()='Crashes']/preceding-sibling::h3";
	public static final String dashboard_mobilelive_activeusers_uninstalls = "mobile live dashboard active users uninstalls,xpath,//small[text()='Uninstalls']/preceding-sibling::h3";
	public static final String dashboard_mobilelive_Audiencetypes_nodatavailable = "mobile live dashboard audience types no data available, xpath, //h4[text()='Audience types']/parent::div//following-sibling::div//p";
	public static final String dashboard_channelperformance_nodata = "dashboard channel performace no data,xpath, //h4[text()='Channel performance']/parent::div[@class='portlet-header']//following-sibling::div[@class='portlet-body']//p";
	public static final String dashboard_topperformingcommunications = "dashboard top performing communication, xpath, //h4[text()='Top performing communications']/parent::div[@class='portlet-header']//following-sibling::div[@class='portlet-body']//p";
	public static final String dashboard_audiencebehaviour_nodata = "dashboard audience behaviour nodata,xpath, //h4[text()='Audience behavior']/parent::div[@class='portlet-header position-relative']//following-sibling::div[@class='portlet-body']//p";
	public static final String dashboard_topearningcommunications_nodata = "dashboard top earning communication,xpath, //h4[text()='Top earning communications']/parent::div[@class='portlet-header']//following-sibling::div[@class='portlet-body']//p";
	public static final String dashboard_segments_nodata = "dashboard segments,xpath, //h4[text()='Segments']/parent::div[@class='portlet-header']//following-sibling::div[@class='portlet-body']//p";
	public static final String dashboard_roitreand_nodata = "dashboard roi trend,xpath, //h4[text()='ROI trend']/parent::div[@class='portlet-header']//following-sibling::div[@class='portlet-body']//p";
	public static final String dashboard_leadgenerated_nodata = "dashboard lead generated,xpath, //h4[text()='Leads generated']/parent::div[@class='portlet-header']//following-sibling::div[@class='portlet-body']//p";
	public static final String dashboard_averageconversiontime = "dashboard average conversion time,xpath, //h4[text()='Average conversion time']/parent::div[@class='portlet-header']//following-sibling::div[@class='portlet-body']//p";
	public static final String dashboard_topperformingCommunication = "dashboard topperforming communication,xpath, //h4[text()='Top performing communications']/ancestor::div[@class='portlet-container portlet-md']//ul/li//p";
	public static final String dashboard_topcommunicationPercentage = "dashboard top communciation percentage,xpath, //h4[text()='Top performing communications']/ancestor::div[@class='portlet-container portlet-md']//ul/li//p/parent::div/following-sibling::div";

}
