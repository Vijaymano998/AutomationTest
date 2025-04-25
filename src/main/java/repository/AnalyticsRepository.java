package repository;

public class AnalyticsRepository
{

	public static final String goldenCommunication = "Golden Communication,css,#rs_HeaderIcons_starfill";
	public static final String alertMessage = "Alert text,xpath,//div[contains(@class,'alert-success')]//span";
	public static final String csrPageDownloadIcon = "Download Icon,css,#rs_data_download";
	public static final String csrPageDownloadDropdown = "Download dropdown,xpath,//i[@id='rs_data_download']//..//span";
	public static final String csrPageBenchmarkIcon = "Benchmark icon,css,#rs_HeaderIcons_goals_benchmark";
	public static final String csrPageOverview_I_icon = "Overview I-icon,xpath,//div[contains(@class,'summary-card')]//div[contains(@class,'card-header')]//i[@id='rs_data_circle_info']";
	public static final String csrPageOverview_Info_channelDropdown = "Info channel dropdown,xpath,//div[@class='d-header-right']//div[contains(@class,'arrowdropdown')]";
	public static final String csrPageOverview_Info_dropdownValue = "Dropdown value,xpath,//div[@class='d-header-right']//div[contains(@class,'arrowdropdown')]//a";
	public static final String csrPageOverview_Info_detailsCounts = "Info channel counts,xpath,//div[@class='detail-body detail-list']//li//div//p";
	public static final String csrPageOverview_Info_closeicon = "Close icon,xpath,//i[@id='rs_circle_close_edge']";

	// Analytics Listing Page

	public static final String analyticspreviewicon = "Preview Icon,xpath,PLACE_HOLDER//li[not(contains(@class,'click-off'))]//i[contains(@id,'rs_data_eye')]";
	public static final String analyticswhatsappcontent = "Analytics preview whatsapp content,css,div[class='wbrw-content'] p";

	// Playwright Analytics Listing page
	public static final String analyticsListingHeaders = "Listing Headers,pw,//div[contains(@class,'detail-view')]/table/thead/tr/th";
	public static final String analyticsListingRows = "Listing Rows,pw,//div[contains(@class,'detail-view')]//tbody//tr";
	public static final String analyticsListing_plusIconForDetails = "Plus Icon (+) ,pw,//div[text()='PLACE_HOLDER']//ancestor::tr//a[contains(@class,'k-icon k-i-plus')]/..";
	public static final String analyticsListing_CommunicationStatus = "Campaign Status,pw,//div[contains(@class,'communication-status')]//small";
	public static final String pw_analytics_listing_deliverability = "Deliverablity,pw,(//div[contains(@class,'rs-communication-list')]//small)[2]";
	public static final String pw_analyticsListingtooltip = "Tooltip,pw,//div[@class='tooltip-inner']";
	public static final String pw_analyticspreviewicon = "Preview Icon,pw,PLACE_HOLDER//li[not(contains(@class,'click-off'))]//i[contains(@id,'rs_data_eye')]";
	public static final String pw_analyticspreviewcontent = "Preview icon content,pw,//div[contains(@class,'popover-body')]";
	public static final String pw_analyticswhatsappcontent = "Preview Whatsapp Content,pw,div[class='wbrw-content'] p";
	public static final String pw_analyticspreviewimage = "Preview Image,xpath,PLACE_HOLDER//li[not(contains(@class,'click-off'))]//i[contains(@id,'rs_data_eye')]";
	public static final String pw_analyticsListingsearchIconClick = "Search icon,pw,//div[@class='search-icon']";
	public static final String pw_analyticsListing_SearchCommunication = "Search field,pw,//input[@id='search']";
	public static final String pw_analyticsListing_selectListedCommunication = "Select listed communication,pw,//div[@class='box-design']//ul//li";
	public static final String pw_analyticsListing_SearchIconClickAfterenterValue = "Seacrh icon after value,pw,//i[@id='rs_data_zoom']";
	public static final String pw_analyticsListing_CommunicationStatus = "Campaign Status,pw,//div[contains(@class,'communication-status')]//small";
	public static final String pw_analyticsListing_deliverability = "Deliverablity,pw,(//div[contains(@class,'rs-communication-list')]//small)[2]";
	public static final String pw_analyticsListing_nodata = "No Data Available,pw,//*[@class='nodata-bar']";
	public static final String pw_anayticsListing_viewanalytics = "View analytics,pw,//div[text()='PLACE_HOLDER']//ancestor::div[contains(@class,'rs-communication-list')]//i[@id='rs_AnalyticsList_Viewanalytics']";
	public static final String pw_analytics_goldencommunication = "Golden Communication,pw,#rs_HeaderIcons_starfill";
	public static final String pw_analytics_alertMessage = "Alert text,pw,//div[contains(@class,'alert-success')]//span";
	public static final String pw_analytics_benchmarkicon = "Benchmark icon,pw,#rs_HeaderIcons_goals_benchmark";
	public static final String pw_analytics_csrPageOverview_I_icon = "Overview I-icon,pw,//div[contains(@class,'summary-card')]//div[contains(@class,'card-header')]//i[@id='rs_data_circle_info']";
	public static final String pw_analytics_csrPageOverview_Info_channelDropdown = "Info channel dropdown,pw,//div[@class='d-header-right']//div[contains(@class,'arrowdropdown')]";
	public static final String pw_analytics_csrOverviewtotalsent = "Analytics overview total sent,pw,//div[contains(@class,'analytic-summary-card')]//div[@class='a-card-label']//p";
	public static final String pw_analytics_summaryReport = "Communication summary report,pw,//li[contains(@class,'tabDefault')]";
	public static final String pw_csrPageOverview_Info_detailsCounts = "Info channel counts,pw,//div[@class='detail-body detail-list']//li//div//p";

	// csr - communication analysis
	public static final String pw_analytics_nodataavailable = "Communication analysis,pw,//h3[text()='Communication analysis']//parent::div//parent::div//p[text()='No data available']";
	public static final String pw_analytics_communicationanalysisgetdynamicId = "Communication analysis,pw,//h3[text()='Communication analysis']//..//..//div[contains(@class,'highcharts-container areachart')]";
	public static final String pw_analytics_communicationanalysisyaxis = "y axis,pw,div[id*='PLACE_HOLDER'] g[class*='highcharts-axis-labels highcharts-yaxis-labels']>text";
	public static final String pw_analytics_topheadtime = "HeadTime,pw,//span[contains(@class,'head-time')]";
	public static final String pw_analytics_communicationanalysischartvalue = "Chart value,css,g[class='highcharts-series-group'] g[class='highcharts-markers highcharts-series-0 highcharts-areaspline-series highcharts-tracker']>path:not([visibility='hidden'])";
	public static final String pw_analytics_communicationanalysischarttooltip = "TooltipText,css,div[class*='highcharts-tooltip'] span[class='font-xs']";

	// ===========================================================================================

	public static final String analytics_listing_previewicon = "Preview icon,xpath, //i[@class='icon-rs-eye-medium icon-md color-primary-blue']";
	public static final String analytics_comm_analyticsdownload = "PDF download,xpath, //i[@class='icon-download-small icon-sm blue']";
	public static final String analytics_listing_deliverability = "Deliverablity,xpath,(//div[contains(@class,'rs-communication-list')]//small)[2]";

	// V-ANALYTICS OVERVIEW
	public static final String analytics_CSR_Overviewtotalsent = "Analytics overview total sent,xpath,//div[contains(@class,'analytic-summary-card')]//div[@class='a-card-label']//p";
	public static final String analytics_CSR_OverviewheaderName = "Overview headername,xpath,//div[contains(@class,'analytic-summary-card')]//p[contains(@class,'position-relative lh-sm')]";
	public static final String analytics_CSR_Overviewcount = "Overview count,xpath,//div[contains(@class,'analytic-summary-card')]//h1";
	public static final String analytics_CSR_Overviewpercentage = "Overview percentage,xpath,//p[.='PLACE_HOLDER']//..//span";
	public static final String analytics_CSR_Overviewdetailarrow = "Overview details arrow,xpath,//p[.='PLACE_HOLDER']//..//i[@id='rs_OverviewCard_arrow_right']";
	public static final String analytics_CSR_Overviewdetailsheader = "Overview Details header,xpath,//div[contains(@class,'a-card-list active')]//p[contains(@class,'position-relative lh-sm')]";
	public static final String analytics_CSR_Overviewdetailscount = "Overview Details count,xpath,//div[contains(@class,'a-card-list active')]//h1";
	public static final String analytics_CSR_Overviewdetailspercentage = "Overview details percentage,xpath,//div[contains(@class,'a-card-list active')]//span";
	public static final String analytics_CSR_Overviewdetailscloseicon = "Close icon,xpath,//div[contains(@class,'a-card-list active')]//i[@id='rs_circle_close_edge']";
	public static final String analytics_CSR_OverviewdetailschannelTab = "Active Tab,xpath,//li[contains(@class,'tabDefault active')]//span";

	// Communication analysis
	public static final String analytics_CSR_communicationanalysisdatepicker = "Communication analysis date picker,xpath,//h3[.='Communication analysis']//..//div[contains(@class,'rs-daterange-picker')]";
	public static final String analytics_CSR_communicationanalysisgoaldropdown = "Goal dropdown,xpath,(//h3[.='Communication analysis']//..//button[contains(@class,'dropdown-toggle')])[2]";
	public static final String analytics_CSR_communicationanalysisgoaldropdownValue = "Goal dropdown value,xpath,//div[@class='dropdown-menu show']//a";

	// ANALYTIC OVERVIEW
	public static final String analytics_summaryReport = "Communication summary report,xpath,//li[contains(@class,'tabDefault')]";
	public static final String analytics_summaryReportCurrentChannelDetails = "Communication summary report channel details,xpath,//div[@class='clear resCSRTabStyle']//div[@class='tab-content']/div";
	public static final String analytics_detailsLink = "Details link,xpath,//a[contains(@href,'/CampaignSummaryDetail/Report')]";
	public static final String analytics_communicationName = "Communication name ,xpath,//h1[contains(@class,'detail-title')]";
	public static final String analytics_csr_Overview = "CSR page overview ,xpath,//h3[contains(.,'Overview')]";
	public static final String analytics_listingcommunicationlist = "Communication list,xpath,//div[contains(@class,'rs-communication-list')]";
	public static final String analytics_listview = "Analytics list view,xpath,//i[@id='rs_CommunicationAnalytics_edge']";

	// ANALYTICS DETAILS
	public static final String analytics_ChannelDetailsreachcount = "Channel details reach,xpath,//h3[.='Reach']//..//..//h1";
	public static final String analytics_ChannelDetailsengaementcount = "Channel details Engagement,xpath,//h3[.='Engagement']//..//..//h1";
	public static final String analytics_ChannelDetailsconversioncount = "Channel details conversion,xpath,//h3[.='Conversion']//..//..//h1";

	public static final String analytics_comm_statusdownload = "Communication Status Download,xpath,//*[@id='dropdown-basic-buttons']/..//following::i[contains(@class,'icon-sd-csv')]";
	public static final String analytics_ChannelDetailsTab = "Channel details tab,xpath,//p[.='Details']";
	public static final String analytics_requestDownloadCSV = "Request to download CSV,xpath,//div[@class='modal-header']//h2";
	public static final String analytics_requestDownloadCSV_ok = "OK button,xpath,//div[@class='modal-footer']//button";
	public static final String analytics_mail_DownloadCSV = "CommunicationStatusDownload mail,xpath,//*[text()='URL : ']//a";
	public static final String analytics_overviewDashboard = "Details Report Overview ,xpath,//div[@class='details-box']";
	public static final String analytics_report = "Details Report,xpath,//i[contains(@class,'icon-report')]";
	public static final String analytics_channelTabs = "No of Channels,xpath,//div[@class='RRT__tabs']//div[contains(@id,'tab')]";
	public static final String analytics_channelSelected = "Enabled Channel,xpath,//div[contains(@id,'tab')][contains(@class,'selected')]";
	public static final String analytics_report_UnderProcessPopup = "Report generation underProcess Popup,xpath,//div[@class='modal-content']";
	public static final String analytics_report_UnderProcessPopup_backbtn = "Back button,xpath,//div[@class='modal-footer']//button";

	// Email=====
	public static final String analytics_DetailPage_Overview_Reach = "analytics_DetailPage_Overview_Reach,xpath,//span[text()='Reach']/following-sibling::h3";
	public static final String analytics_DetailPage_Overview_ReachOpenPercent = "analytics_DetailPage_Overview_ReachOpenPercent,xpath,//li[contains(text(),'Opens')]/span";
	public static final String analytics_DetailPage_Overview_ReachForwards = "analytics_DetailPage_Overview_ReachForwards,xpath,//li[contains(text(),'Forwards')]/span";
	public static final String analytics_DetailPage_Overview_ReachPerDay = "analytics_DetailPage_Overview_ReachPerDay,xpath,(//p[contains(text(),'Previous day comparison')]/span)[1]";

	public static final String analytics_DetailPage_Overview_Engagement = "analytics_DetailPage_Overview_Engagement,xpath,//span[text()='Engagement']/following-sibling::h3";
	public static final String analytics_DetailPage_Overview_EngagementUniqueClick = "analytics_DetailPage_Overview_EngagementUniqueClick,xpath,//li[contains(text(),'Unique clicks')]/span";
	public static final String analytics_DetailPage_Overview_EngagementForwards = "analytics_DetailPage_Overview_EngagementForwards,xpath,//li[contains(text(),'Fwd mail clicks')]/span";
	public static final String analytics_DetailPage_Overview_EngagementPerDay = "analytics_DetailPage_Overview_EngagementPerDay,xpath,(//p[contains(text(),'Previous day comparison')]/span)[2]";

	public static final String analytics_DetailPage_Overview_Conversion = "analytics_DetailPage_Overview_Conversion,xpath,// span[text()='Conversion']/following-sibling::h3";
	public static final String analytics_DetailPage_Overview_ConversionRegistration = "analytics_DetailPage_Overview_ConversionRegistration,xpath,//label[contains(text(),'Registration')]/following-sibling::span";
	public static final String analytics_DetailPage_Overview_ConversionPerDay = "analytics_DetailPage_Overview_ConversionPerDay,xpath,(//p[contains(text(),'Previous day comparison')]/span)[3]";

	// Email Key metrics
	public static final String analytics_DetailPage_keymetrics = "Analytics keymetrics,xpath,//div[@class='portlet-container keymetrics-portlet keymetrics-md']";
	public static final String analytics_DetailPage_CommunicationOverview = "analytics_DetailPage_CommunicationPerformance,xpath,//ul[contains(@class,'resDetailTabStyle')]";
	public static final String analytics_DetailPage_KeyMetrics_TotalAudience = "analytics_DetailPage_KeyMetrics_TotalAudience,xpath,//*[@class='keymetrics-list key-border']//li[1]//h3";
	public static final String analytics_DetailPage_KeyMetrics_Delivered = "analytics_DetailPage_KeyMetrics_Delivered,xpath,//h4[text()='Key metrics']/..//div/p[text()='Delivered']/../h3/span[1]";
	public static final String analytics_DetailPage_KeyMetrics_DeliveredDataIcon = "analytics_DetailPage_KeyMetrics_DeliveredDataIcon,xpath,//h4[text()='Key metrics']/..//div/p[text()='Delivered']/../h3/span[1]//following-sibling::a";
	public static final String analytics_DetailPage_KeyMetrics_DeliveredDatapopuplist = "analytics_DetailPage_KeyMetrics_DeliveredDatapopup,xpath,//div[contains(@class,'popup serOn')]//ul/li/ul/li";
	public static final String analytics_DetailPage_KeyMetrics_DeliveredDatapopupClose = "analytics_DetailPage_KeyMetrics_DeliveredDatapopupClose,xpath,// div[contains(@class,'popup serOn')]//a[contains(@class,'Hide')]";
	public static final String analytics_DetailPage_UserEngagementList = "analytics_DetailPage_UserEngagementList,xpath,//h5[text()='User engagement']/following-sibling::ul/li";
	public static final String analytics_DetailPage_Negativefeedback = "analytics_DetailPage_Negativefeedback,xpath,//h5[text()='Negative feedback']/following-sibling::ul/li";
	public static final String analytics_DetailPage_getCommunicationName = "analytics_DetailPage_getCommunicationName,xpath,//*[@class='camp_report']/span[1]";
	public static final String analytics_DetailPage_getCommunicationDates = "analytics_DetailPage_getCommunicationDates,xpath,//*[@class='camp_report']/small";
	public static final String analytics_DetailPage_DownloadLink = "analytics_DetailPage_DownloadLink,xpath,//a[@data-original-title='Downloads']";
	public static final String analytics_DetailPage_DownloadListPDFselect = "analytics_DetailPage_DownloadListPDFselect,xpath,//a[@data-original-title='Downloads']//following-sibling::ul//a[contains(@id,'DetailReportPdf')]";

	public static final String analytics_reporticon = "Channel reportsbtn,xpath,//i[@title = 'Report']";
	public static final String analytics_reportspage_headertext = "communication header,xpath,//span[@class='header_Campaign']";
	public static final String analytics_reportspage_commperformance = ",xpath,//h3[contains(.,'Communication performance')]";
	public static final String analytics_reportspage_keymetricsicon = "keymetrics 'i' icon,xpath,//a[@data-original-title='Delivered details']//i[@class='icon-info-small icon-xs']";
	public static final String analytics_reportspage_keymetricssoftboubd = "keymetrics soft bound,xpath,//span[contains(.,'Soft bounced')]";

	// Retargeting scenario
	public static final String analytics_listing_mobilechannel = "mobile channel,xpath,//div[@class='clear resCSRTabStyle']/ul/li[.='SMS']";
	public static final String analytics_listing_emailchannel = "Email Channel,xpath,//div[@class='clear resCSRTabStyle']/ul/li[.='Email']";
	public static final String analytics_listing_scrollview = "scrolldown,xpath,//a[@id='LineChartLink']";
	public static final String analytics_listing_retargetname = "retargetname,xpath,//input[@id='txtNewTargetListName']";
	public static final String analytics_listing_retargetsavebutton = "Retarget save,xpath,//input[@id='res-tgListName-Btn-JS']";
	public static String dynamicanalyticxpath = "--dynamicanalyticxpath--";
	public static String dynamicanalyticxpath1 = "--dynamicanalyticxpath1--";
	public static final String analytics_listing_tablerow = "Table Row,xpath,//div[@id='" + dynamicanalyticxpath1 + "']/div/table/tbody/tr/td";
	public static final String analytics_listing_tabledata = "Table data,xpath,//div[@id='" + dynamicanalyticxpath1 + "']//tbody/tr/td//span[contains(.,'" + dynamicanalyticxpath + "')]";
	public static final String analytics_listing_retargeticon = "Retarget icon,xpath,//div[@id='" + dynamicanalyticxpath1 + "']//tbody/tr/td//span[contains(.,'" + dynamicanalyticxpath
			+ "')]/..//div/a//i[@class='icon-retarget-list-small icon-xs blue']";
	public static final String analytics_listing_retargetbutton = "Retarget button,xpath,//div[@id='" + dynamicanalyticxpath1 + "']//tbody/tr/td//span[contains(.,'" + dynamicanalyticxpath + "')]/..//div/ul/li/a//span[.='Retarget list']";

	// Analytics Filter
	public static final String listing_filter_communication = "Communication filter,xpath,//span[contains(text(),'communications')]//following-sibling::i";
	public static final String listing_filter_selectAllcommunication = "All Commnunication filter dropdown,xpath,//a[normalize-space()='All communications']";

	// analytics 360 page
	public static final String analytics_360_overview = "Analytics 360 Overview,xpath,//div[@id='u360OverView']";
	public static final String analytics_audiencebehaviorchart = "Audience behavior,xpath,//div[@class='bdlPercentage']";
	public static final String analytics_moredetailsbtndown = "More-info btn down,xpath,//a[@id='btndown']";
	public static final String analytics_demographic_agetext = "Demographic Age text,xpath,//div[@class='progress-bar bgGreen-medium']";
	public static final String analytics_demographic_highestreachtext = "Highest reach text,xpath,//div[@class='list-detailbox-body margin-T50-del']//small";
	public static final String analytics_detailspage = "Analytics details page,xpath,//a[@class='btn-text no-hover orange-medium']";
	public static final String analytics_csvdownloadpage = "Analytics CSV Download,xpath,//a[@data-original-title='Click map']//..//..//ul/li";
	public static final String analytics_totallinktabledata = "Total link table data,xpath,//div[@id='LinkClickListGrid']//tbody//td";
	public static final String analytisc_360overview_searchicon = "Analytics 360 search icon,xpath,//div[@class='searchSlide']";
	public static final String analytics_360overview_entervalue = "Enter value,xpath,//input[@id='searchName']";
	public static final String analytics_360overview_searchaftervalue = "search after value,xpath,//i[@class='icon-search-small icon-xs white']";
	public static final String analytics_360overview_username = "Username,xpath,//div[@class='infobox-user-data']";
	public static final String analytics_360overview_validation = "Analytics 360 validation,xpath,//ul[@class='user-detail even padding-T10']";
	public static final String analytics_page_edm_image = "Analytics page EDM Image,xpath,(//div[@class='col-sm-3 col-xs-12'])[1]//a//img";

	// analytics listing
	public static final String analytics_listing_substatus_plusicon = "Substatus plus icon,xpath,//a[@class='k-icon k-plus']";
	public static final String analytics_listing_substatus1_detailsicon = "Substatus 1 details icon,xpath,(//i[@class='icon-report-small icon-sm blue'])[2]";
	public static final String analytics_listing_detailspage_validation = "Analytics details page validation,xpath,//h3[.='Communication performance']";
	public static final String analytics_listing_advanceSearch = "Advance Search,id,dropdown-basic";
	public static final String analytics_listing_advanceSearchCancel = "Search Cancel button,xpath,//div[@class='search-icon']";
	public static final String analytics_listing_advanceSearchList = "Advanced Search dropdown,xpath,//div[@class='dropdown-menu show']//a";
	public static final String analytics_listing_gridlist = "Grid list,xpath,//*[contains(@class,'k-master-row')]";

	public static final String analytics_listing_created = "Created name,xpath,(//span[contains(@class,'created-name')])";
	public static final String analytics_listing_Commtype = "Communication type,xpath,(//div[@class='cellPannelInner'][2]//p)";
	public static final String analytics_listing_nodata = "No Data Available,xpath,//*[@class='nodata-bar']";
	public static final String analytics_listing_pagination = "Next page button,xpath,//a[@title='Go to the next page' and not (contains(@class,'state-disabled'))]";
	public static final String analytics_listing_lastPage = "Last page button,xpath,//a[@title='Go to the last page' and not (contains(@class,'state-disabled'))]";
	public static final String analytics_listing_lastPageCount = "Last page,xpath,//div[contains(@class,'k-widget k-grid-pager')]//input";
	public static final String analytics_listingpage_comm_list = "Analytics listing page,xpath,//div[@class='panelbar-wrapper campaign-analytics-list']";
	public static final String analytics_listingpage_search_icon = "search icon,xpath,//div[@class='search-icon']";

	// ANALYTICS DETAILS REACH PORTLET
	public static final String analytics_DetailPage_reachPortlet = "Reach Portlet,xpath,//div[@class='portlet-header']//h4[text()='Reach']";
	public static final String analytics_DetailPage_reachOptions = "Reach Portlet Options,xpath,//div[@class='portlet-header']//h4[text()='Reach']/..//ul//li";
	public static final String analytics_DetailPage_reachchartExpand = "Expand button,xpath,//i[@class='icon-rs-arrow-right-mini white icon-xs']";
	public static final String analytics_DetailPage_reachChart = "Reach Portlet Chart,xpath,//h4[text()='Reach']/..//following-sibling::div//div[contains(@id,'highchart')]";
	public static final String analytics_DetailPage_reachTracepoint = "Trace point,css,div[id*='PLACE_HOLDER']>svg>g>g[class*='series-0']>path[class*='highcharts-point']";
	public static final String analytics_DetailPage_reach_OrangeTracepoint = "Trace point,css,div[id*='ReachPerform_StackedArea']>div>svg>g>g[class*='series-1']>path[class*='highcharts-point']";
	public static final String analytics_DetailPage_reach_Yaxis = "Reach chart Y axis,xpath,//div[contains(@id,'ReachPerform_StackedArea')]//*[contains(@class,'highcharts-yaxis-labels')]//*[@style]";
	public static final String analytics_DetailPage_reachChart_Tooltip = "Tooltip,xpath,//div[contains(@id,'ReachPerform_StackedArea')]//div[@class='highcharts-label highcharts-tooltip']";
	public static final String analytics_DetailPage_reachChart_titleLegend = "Title legend,css,div[id*='highcharts-56hm9mj-183']>svg>g>g[class*='series-0']>path[class*='highcharts-point']";
	public static final String analytics_DetailPage_reachgraph = "graph,xpath,//small[.='Day-wise unique audience']";
	public static final String analytics_DetailPage_engementgraph = "graph,xpath,//li[.='engagement rate occurred during this period']";
	public static final String analytics_DetailPage_reachgraphid = "Trace point,xpath,//h4[.='Reach']//..//..//..//div[contains(@class,'highcharts-container')]";
	public static final String analytics_DetailPage_engaementgraphid = "Trace point,xpath,//h4[.='Engagement']//..//..//..//div[contains(@class,'highcharts-container')]";

	// ANALYTICS DETAILS ENGAGEMENT PORTLET
	public static final String analytics_details_EngagementPortlet = "Engagement Portlet,xpath,//div[@class='portlet-header']//h4[text()='Engagement']";
	public static final String analytics_details_Engagement_BluetracePoint = "Engagement Chart trace point,css,div[id*='highcharts-56hm9mj-183']>svg>g>g[class*='series-0']>path[class*='highcharts-point']";
	public static final String analytics_details_Engagement_OrangetracePoint = "Engagement Chart trace point,css,div[id*='EngagementPerform_StackedArea']>div>svg>g>g[class*='series-0']>path[class*='highcharts-point']";
	public static final String analytics_details_Engagement_chart = "Engagement Chart,css,div[id*='highcharts-56hm9mj-183']>svg>g>g[class*='series-0']>path[class*='highcharts-point']";
	public static final String analytics_details_Engagement_Options = "Engagement options,xpath,//div[@class='portlet-header']//h4[text()='Engagement']/..//li";
	public static final String analytics_details_Engagement_tooltip = "Chart Tooltip,xpath,//div[contains(@id,'EngagementPerform_StackedArea')]//div[@class='highcharts-label highcharts-tooltip']";
	public static final String analytics_details_Engagement_info = "Info panel,xpath,//h4[text()='Engagement']/../following-sibling::ul";

	// ANALYTICS DETAILS OPENS BY BROWSER PORTLET
	public static final String analytics_details_userEngagement = "User Engagement,xpath,//h3[text()='User engagement']";
	public static final String analytics_details_opensByBrowserPortlet = "Opens by browser,xpath,//h4[text()='Opens by browser']";
	public static final String analytics_details_opensByBrowser = "Opens by browser,xpath,//div[.='Opens by browser']";
	public static final String analytics_details_opensByDevices = "Chart data list,xpath,//div[.='Opens by devices']";
	public static final String analytics_details_userEngagement_Email_chartList = "Chart data list,xpath,//*[contains(@class,'highcharts-data-label-color-')]";
	public static final String analytics_details_userEngagement_Email_toolTip = "Chart Tooltip,xpath,//div[@class='highcharts-label highcharts-tooltip']";
	public static final String analytics_details_userEngagement_Email_titleLegend = "Title Legend,xpath,(//div[@id='email_Clients_Segment']//span[@class='titlelegend'])";
	public static final String analytics_details_userEngagement_Email_info = "Info panel,xpath,//following::ul[@class='widget-info panel-list'][1]";
	public static final String analytics_details_opensByDevicesPortlet = "Opens by Devices,xpath,//h4[text()='Opens by devices']";
	public static final String analytics_details_opensByDevices_chartList = "Chart data list,xpath,//div[@id='twitter-byage']//*[contains(@class,'highcharts-data-label-color-')]";
	public static final String analytics_details_opensByDevices_toolTip = "Chart Tooltip,xpath,//div[@id='twitter-byage']//div[@class='highcharts-label highcharts-tooltip']";
	public static final String analytics_details_opensByDevices_titleLegend = "Title Legend,xpath,//div[@id='twitter-byage']//span[@class='titlelegend']";
	public static final String analytics_details_opensByDevices_info = "Info panel,xpath,//div[@id='twitter-byage']//ul[@class='widget-info panel-list']";
	public static final String analytics_details_SMS_commStatus = "Communication status,xpath,//div[@id='mobile_devices_PieChartLegend']";
	public static final String analytics_details_SMS_mobileInfo = "Mobile OS info,xpath,//div[@id='mobile_Clients_Segment']";
	public static final String analytics_details_WP_commStatus = "Communication status,xpath,//div[@id='wpush_devices_PieChartLegend']";
	public static final String analytics_details_Wp_interActivity = "Interactive button,xpath,//div[@id='wpush_Interactive_Clients_Segment']";
	public static final String analytics_details_WP_browser = "Browser,xpath,//div[@id='wpush_Clients_Segment']";
	public static final String analytics_details_WP_opratingSys = "Operating System,xpath,//div[@id='wpush_devices_Segment']";
	public static final String analytics_details_MP_commStatus = "Communication status,xpath,//div[@id='StatusInfo_PieChartLegend']";
	public static final String analytics_details_MP_Interactivity = "Interactivity,xpath,//div[@id='mobilePush_Interactive_Segment']";
	public static final String analytics_details_MP_opratingSys = "Operating System,xpath,//div[@id='mobilepush_MobileOsInfo_PieChartLegend']";
	public static final String analytics_details_MP_devices = "Devices,xpath,//div[@id='mobilePush_DeviceInfo_Segment']";
	public static final String analytics_details_whatsApp_commStatus = "Communication Status,xpath,//div[@id='whatsapp_devices_PieChartLegend']";
	public static final String analytics_details_whatsApp_mobileInfo = "Mobile OS info,xpath,//div[@id='whatsapp_Clients_Segment']";

	// ANALYTICS DETAILS - Total link click activity
	public static final String analytics_details_totallinkClick = "Total link click activity,xpath,//h4[contains(.,'Total link click activity')]";
	public static final String analytics_details_heapmap = "Heapmap,xpath,//h3[contains(text(),'Total link click activity')]//a";
	public static final String analytics_details_totallinkClick_rows = "No of Rows,xpath,//h4[contains(text(),'Total link click activity')]//following::thead//tr";
	public static final String analytics_details_totallinkClick_headers = "No of headers,xpath,//h4[contains(text(),'Total link click activity')]/..//following::thead//.//th";
	public static final String analytics_details_totallinkClick_CSV = "Download CSV file,xpath,//h3[contains(text(),'Total link click activity')]/..//ul//a";
	public static final String analytics_details_totallinkClick_pagination = "Next page button,xpath,//div[contains(@id,'LinkClickListGrid')]//a[@title='Go to the next page' and not (contains(@class,'state-disabled'))]";
	public static final String analytics_details_totallinkClick_heapmapIcon = "Heap map eye Icon,xpath,//h3[contains(text(),'Total link click activity')]/..//i[contains(@class,'icon-sd-eye')]";
	public static final String analytics_details_totallinkClick_heapmapPopup = "Heap map popup,xpath,//div[contains(@class,'modal-content')]";
	public static final String analytics_details_totallinkClick_heapmapPopupClose = "Close button,xpath,//button[@class='btn-close']";

	// ANALYTICS DETAILS - Overview Dashboard
	public static final String analytics_details_overview = "Overview dashboard,xpath,//h3[contains(text(),'Overview')]";
	public static final String analytics_details_overview_previewIcon = "Overview preview eye icon,xpath,//h3[contains(text(),'Overview')]/..//i";
	public static final String analytics_details_overview_popup = "Preview Popup,xpath,//div[contains(@class,'popover-body')]";
	public static final String analytics_details_overview_primaryGoal = "Primary goals,xpath,//div[@class='details-box']//h4";
	public static final String analytics_details_overview_primaryGoalCount = "Primary goals count,xpath,//div[@class='details-box']//h3";
	public static final String analytics_details_overview_percentages = "Percentage,xpath,//div[@class='detail-center']";
	public static final String analytics_details_overview_prevdayComp = "Previous Day Comparison,xpath,//div[@class='well well-sm detail-statbox']//li";
	public static final String analytics_details_overview_Stdate = "Campaign Start date,xpath,//div[contains(@class,'page-header box')]//time[position()=1]";
	public static final String analytics_details_overview_enddate = "Campaign End date,xpath,//div[contains(@class,'page-header box')]//time[position()=2]";

	// ANALYTICS DETAILS - Key metrics Portlet
	public static final String analytics_details_keymetrics = "Key metrics,xpath,//h4[text()='Key metrics']";
	public static final String analytics_details_keymetricsCount = "Key list,xpath,//h4[text()='Key metrics']/..//h3//span[1]";
	public static final String analytics_details_keymetricsAudience = "Key list name,xpath,//*[contains(@class,'keymetrics-list')]//li";
	public static final String analytics_details_keymetics_userengementList = "User Engagement list,xpath,//div[@class='clearfix key-list']//ul//li//h3/following::span[1]";
	public static final String analytics_details_keymetics_userengementCount = "User Engagement Count,xpath,//div[@class='clearfix key-list']//ul//li//h3";
	public static final String analytics_details_keymetics_tooltip = "Tooltip,xpath,//div[@class='tooltip fade top in']";
	public static final String analytics_details_keymetics_scrubbedDetails_icon = "Scrubbed details,xpath,//div[@class='clearfix text-center key-list-post']//a";
	public static final String analytics_details_keymetics_scrubbedDetails = "Scrubbed details,xpath,//div[contains(@class,'PotentialCountView info-popup serOn')]//ul[@class='list-clear']//li";

	// ANALYTICS DETAILS - Communication Status
	public static final String analytics_details_commStatus = "Communication Status,xpath,//h3[text()='Communication status (']";
	public static final String analytics_details_commStatusCount = "Communication Status Count,xpath,//h3[text()='Communication status (']";
	public static final String analytics_details_commStatusCSV = "Communication Status CSV,xpath,//h3[@id='lblActivityTitle']/..//a[@data-original-title='Download CSV']";
	public static final String analytics_details_commStatus_dropdown = "Drop-down,id,dropdown-basic-buttons";
	public static final String analytics_details_commStatus_dropdownlist = "Drop-down list,xpath,//div[@class='dropdown-menu show']//a";
	public static final String analytics_details_commStatus_pagination = "Next page button,xpath,//h3[contains(text(),'Communication status')]//following::a[@title='Go to the next page' and not (contains(@class,'state-disabled'))]";
	public static final String analytics_details_commStatus_table = "Communication Status table,xpath,//*[@id='dropdown-basic-buttons']//following::th//ancestor::table";
	public static final String analytics_details_commStatus_rows = "No of Rows,xpath,//*[@id='dropdown-basic-buttons']//following::tbody//tr";
	public static final String analytics_details_commStatus_headers = "No of headers,xpath,//*[@id='dropdown-basic-buttons']//following::th";
	public static final String analytics_details_porltet = "Porltet,xpath,//h4[text()='PLACE_HOLDER']/ancestor::div[contains(@class,'portlet-container portlet')]/descendant::*[@class='nodata-bar']";
	public static final String analytics_details_portletInfo = "Info panel,xpath,//h4[text()='PLACE_HOLDER']/..//following-sibling::div[@class='portlet-two-label']";;
	public static final String analytics_details_porltet_tooltip = "Chart Tooltip,xpath,//div[@id='PLACE_HOLDER']//div[contains(@class,'highcharts-label highcharts-tooltip')]/span";
	public static final String analytics_details_porltet_tiltleLegend = "Title Legends,xpath,//div[@id='PLACE_HOLDER']//*[contains(@class,'highcharts-legend-item highcharts')]";
	public static final String analytics_details_porltet_charts = "Chart data list,css,div[id='PLACE_HOLDER']>svg>g>g[class*='highcharts-data-label-color-']>text";
	public static final String analytics_details_porltet_container = "OverAll Pie-Chart,css,div[id='PLACE_HOLDER']";
	public static final String analytics_details_porltet_Id = "chart element,xpath,//h4[text()='PLACE_HOLDER']/..//following-sibling::div//div[contains(@id,'highcharts')]";
	public static final String analytics_details_porltet_header = "Portlet,xpath,//h4[text()='PLACE_HOLDER']";
	public static final String analytics_details_porltet_piecharts = "Pie Chart pieces,css,div[id='PLACE_HOLDER']>svg>g>g[class*='highcharts-tracker']>path";

	// DASHBOARD

	public static final String dashboard_leftarrow = "Left arrow,xpath,//span[@class='carousel-control-prev-icon']";
	public static final String dashboard_rightarrow = "Right arrow,xpath,//span[@class='carousel-control-next-icon']";
	public static final String dashboard_slide2 = "slide 2,xpath,//button[@aria-label= 'Slide 2']";
	public static final String dashboard_slide1 = "slide 1,xpath,//button[@aria-label= 'Slide 1']";
	public static final String dashboard_recentcommheader = "Recent communication head,xpath,//h4[contains(.,'Recent')]";
	public static final String dashboard_topperformingCommunicatiosheader = "Recent communication header,xpath,//h4[contains(.,'Recent')]";
	public static final String dashboard_communicationname = "Communication name,xpath,//p[contains(@class,'text-wrap')]";
	public static final String dashboard_recentcomm_iicon = "Recent communication i icon,xpath,//i[contains(@class,'icon-info-small icons-sm')]";
	public static final String dashboard_recentcomm_targetreach = "Target reach,xpath,//div[@class='multi-column popover-body']//small[contains(.,'Target')]";
	public static final String dashboard_recentcomm_currentreach = "current reach,xpath,//div[@class='multi-column popover-body']//small[contains(.,'Current')]";
	public static final String dashboard_topperforming_threedot = "Low perform communication three dot,xpath,//span[contains(@class,'k-icon k-i- icon-align-vertical-small')]";
	public static final String dashboard_topperforming_lowperformingcommunication = "low performing communication,xpath,//div[contains(@class,'k-popup k-list-container k-reset k-group')]";
	public static final String dashboard_topperforming_lowperformingcommunicationhead = "low performing communication header,xpath,//h4[contains(.,'Low performing communications')]";
	public static final String dashboard_topperforming_audiencebehaviorhead = "Audience header,xpath,//h4[contains(.,'Audience behavior')]";
	public static final String dashboard_channelperformance_head = "Channel performance header,xpath,//h4[contains(.,'Channel performance')]";
	public static final String dashboard_topperformingcommunication_head = "Channel performance header,xpath,//h4[contains(.,'Channel performance')]";

	public static final String dashboard_speedometer_dial = "Meter dial,xpath,//*[@class='highcharts-dial']";

}
