package repository;

public class CommunicationRepository
{

	public static final String CommunicationListing_SearchIconClick = "Search icon,id,rs_RSAdvanceSearch_zoom";
	public static final String CommunicationListing_Searchbox = "Search box,xpath,//div[contains(@class,'search-container search-advanced')]";
	public static final String CommunicationListing_SearchCommunication = "Search field,xpath,//input[@id='search']";
	public static final String CommunicationListing_selectListedCommunication = "Select listed communication,xpath,//div[@class='box-design']//ul//li";
	public static final String CommunicationListing_SearchIconClickAfterenterValue = "Seacrh icon after value,xpath,//i[@id='rs_data_zoom']";
	public static final String CommunicationListing_CommunicationStatus = "Campaign Status,xpath,//div[contains(@class,'communication-status')]//small";
	public static final String communication_Webannalytics = "Web analytics,xpath,//i[contains(@class,'web-analytics-large icon-lg')]";
	// **********************************************************************************************************
	// COMMUNICATION LISTING PAGE AND ANALYTICS LISTING PAGE
	public static final String authoringpage_webanalytics = "Web analytics,xpath,//i[contains(@class,'web-analytics-large icon-lg')]";
	public static final String Communicationauthoringpage_SearchIconClick = "Search icon,id,rs_data_zoom";
	public static final String Communicationauthoringpage_SearchCommunication = "Search field,xpath,//input[@name='search']";
	public static final String Communicationauthoringpage_TemplateMouseover = "Search field,xpath,//div[@class='gallery-list p10 email-template-grid no-box-shadow communication']";
	public static final String Communicationauthoringpage_template_Select = "Search icon,xpath,//div[@class='template-buttons-section']";
	public static final String Communicationauthoringpage_Email_templateBuilderSaveTemplete = "Save templete,xpath,//button[@aria-label='Save']";
	public static final String Communicationcreate_entercommunicationname = "Commnication name,xpath,//input[@name='communicationName']";
	public static final String CommunicationListing_comm_viewanalytics = "View analytics,xpath,//div[text()='PLACE_HOLDER']//ancestor::div[contains(@class,'rs-communication-list')]//i[@id='rs_AnalyticsList_Viewanalytics']";
	public static final String CommunicationListing_CommunicationTotalAudience = "Tatal audience,xpath,//small[normalize-space()='Total audience']/../child::p//div";
	public static final String CommunicationListing_plusIconForDetails = "Plus Icon (+) ,xpath,//div[text()='PLACE_HOLDER']//ancestor::tr//a[contains(@class,'k-icon k-i-plus')]/..";
	public static final String CommunicationListing_PreviewIcon = "Preview Icon,xpath,//i[@class='icon-view-small icons-md blue']";
	public static final String CommunicationListing_PreviewIconContent = "Preview icon content,xpath,//div[contains(@class,'popover-body')]";
	public static final String CommunicationListing_minusicon = "Minus Icon,xpath,//a[@class='k-icon k-i-minus']";
	public static final String CommunicationListing_deletecomm = "Communication delete icon,xpath, //i[contains(@title,'Archive')]";
	public static final String CommunicationListing_confirmcommdelete = "Delete confirm,xpath, //input[@onclick='confirmCampaignDelete();']";
	public static final String CommunicationListing_detailslistingplusicon = "listing plus icon,xpath,//p[.='PLACE_HOLDER']//ancestor::td//preceding-sibling::td//a[@aria-label='Expand detail row']";
	public static final String CommunicationListing_ScheduleDate = "Schedule date,xpath,//li[contains(@class,'campaign-status-datetime')]";
	public static final String CommunicationListing_detailslistingminusicon = "minus icon,xpath,//p[.='PLACE_HOLDER']//ancestor::td//preceding-sibling::td//a[@aria-label='Collapse detail row']";
	public static final String CommunicationListing_detailslistingstatus = "detail status,xpath,//div[contains(@class,'status-icons')]//p";
	public static final String CommunicationListing_detailslistingcommentbox = "comment box,id,rs_data_comment";
	public static final String CommunicationListing_detailslistingmakechangestext = "makechanges text,xpath, //td[normalize-space()='Make changes']//following-sibling::td";
	public static final String CommunicationListing_detailsmakechangesclose = "makechanges close,id,rs_circle_close_edge";
	public static final String CommunicationListing_splitlistingprogressicon = "split progress popup link,xpath, //img[contains(@src,'split-ab.png')]/following-sibling::a";
	public static final String CommunicationListing_splitcommunicationname = "communication name,xpath, //*[@id='campaignGrid']//h4[contains(@class,'campaign-name')]";
	public static final String CommunicationListing_splitcommunicationstatus = "split channel details,xpath, //*[@id='campaignListGrid']//tbody//small[contains(@class,'small-block white')]";
	public static final String CommunicationListing_splitchanneltype = "split status,xpath, //*[@id='campaignGrid']//tbody//tr/td/i";
	public static final String CommunicationListing_splitchannelstatus = "split status,xpath, //*[@id='campaignGrid']//ul[contains(@class,'campaign-split')]//a";
	public static final String CommunicationListing_splittitle = "split title,xpath, //*[@id='campslpitAB']//h2";
	public static final String CommunicationListing_splittype = "split type,xpath, //*[@id='divanyonecontent']//ul[1]//li//h3";
	public static final String CommunicationListing_splitvalue = "split value,xpath, //*[contains(@id,'aAnalyticsSubject')]//div[@class='pie_progress__number']";
	public static final String CommunicationListing_splitprogressvalues = "split progress value,xpath,//*[@id='divanyonecontent']//ul[contains(@class,'Subjectline')]//li[not(@style!='none')]";
	public static final String CommunicationListing_Deliverymethods = "delivery methods,xpath,(//*[@id='hdnDepartmentId']//following-sibling::ul//i[@class='icon-dropdown-small'])[4]";
	public static final String CommunicationListing_Deliverymethodslist = "delivery method list value,xpath, (//*[@id='campaign-list']//following-sibling::ul)[4]//li";
	public static final String CommunicationListing_Communicationtype = "communication type,xpath,(//*[@id='hdnDepartmentId']//following-sibling::ul//i[@class='icon-dropdown-small'])[3]";
	public static final String CommunicationListing_communicationslistdropdown = "My/All Communication list,xpath, (//*[@id='hdnDepartmentId']//following-sibling::ul//i[@class='icon-dropdown-small'])[2]";
	public static final String CommunicationListing_nextpagearrowclick = "next page arrow,xpath,//div[@id='campaignGrid']//span[text()='arrow-e']";
	public static final String CommunicationListing_paginationseekarrow = "seekarrow,xpath,//div[@id='campaignGrid']//span[text()='seek-e']";
	public static final String CommunicationListing_clickheader = " item per page,xpath,//*[@id='campaignGrid']//span[@class='k-widget k-dropdown k-header']";
	public static final String CommunicationListing_iteration = "pages,xpath,//div[@class='k-animation-container']//ul//li";
	public static final String CommunicationListing_pages = "total pages,xpath,//*[@id='campaignGrid']//tbody//tr";
	public static final String CommunicationListing_paginationgotonextpagearrow = "Go to Next page arrow,xpath,//div[@id='campaignGrid']//span[text()='arrow-e']/..";
	public static final String CommunicationListing_paginationgotofirstpage = "First page pagination link,xpath,//a[@title='Go to the first page']";
	public static final String CommunicationListing_paginationgotopreviouspage = "Previous page pagination link,xpath,//a[@title='Go to the previous page']";
	public static final String CommunicationListing_paginationgotolastpage = "Last page pagination link,xpath,//a[@title='Go to the last page']";
	public static final String CommunicationListing_paginationgotonextpage = "Next page pagination link,xpath,//a[@title='Go to the next page']";
	public static final String CommunicationListing_itemperpageheader = "Item per page,xpath,//span[contains(@class,'k-pager-size')]//span//button";
	public static final String CommunicationListing_itemperpagepagestotaldisplay = "Item per page dropdown,xpath,//*[contains(@class,'k-list-content')]//li";
	public static final String CommunicationListing_pagetableitemview = "page item view,xpath,//*[contains(@class,'k-master-row')]";
	public static final String communicationListing_plusicon = "Communication plus icon,xpath,//*[@class='k-icon k-plus']";
	public static final String communicationListing_channelicon = "Communication channel icon,xpath,(//*[@role='rowgroup']//tr[@class='k-detail-row']//tr//td//i)[1]";
	public static final String CommunicationListing_webAnalytics_Edit = "Web analytics edit button,xpath,//div[contains(@id,'grid_')]//tr[last()]//i[@title='Edit']";
	public static final String communicationpage_cancelbutton = "Cancel button,xpath,//button[contains(.,'Cancel')]";
	public static final String communicationpageListing_confirmdelete_Popup = "Confirm delete,xpath,(//div[@class='modal-footer']//button[contains(@class,'rsp-primary-button')][contains(.,'OK')])";

	// COMMUNICATION CREATE PAGE Marketing star
	public static final String homepage_communication_link = "Communication menu,xpath, //a[@href='/communication']";
	public static final String communicationpage_create_link = "Communication create link,xpath,//a[contains(text(),'Create campaign')]";
	public static final String communication_planpage_producttype = "Product type,xpath,//label[@class='label-row label-dark'][contains(.,'Product type')]/../..//div[@class='col-md-6'][2]";
	public static final String communicationpage_commcreation_title = "communication plan page title,xpath,//h1[contains(.,'Communication creation')]";

	public static final String communicationpage_multidimen_link = "Multi dimension,xpath,//*[contains(@class,'icon-multi-dimension-large icons')]";
	public static final String communicationpage_communicationtype_select = "Communication type,xpath,//span[contains(@aria-label,'Communication type')]";
	// span[@class='k-dropdown-wrap k-state-focused']
	public static final String communicationpage_producttype_select = "Product type,xpath,//span[contains(@aria-label,'Product type')]//span[contains(@class,'k-input-value-text')]";
	public static final String communicationpage_producttype_listbox = "Product type listbox,xpath, //ul[@class='k-list k-reset']/li";
	public static final String communicationpage_primarygoal_select = "Primary goal,xpath,//span[contains(@aria-label,'Primary goal')]//span[contains(@class,'k-input-value-text')]";
	public static final String communicationpage_primarygoal_listbox = "Primary goal listbox,xpath, //ul[@class='k-list k-reset']/li";
	public static final String communicationpage_goalpercentage_textbox = "Goal percentage,xpath,//input[@name='primaryGoalPercentage']";
	public static final String pwcommunicationpage_goalpercentage_textbox = "Goal percentage,pw,//input[@name='primaryGoalPercentage']";

	public static final String communicationpage_calendaryear_click = "communication calendar year,xpath,//div[contains(@class,'k-calendar-header')]//span[@class='k-button-text']";
	public static final String communicationpage_calendarmonths_select = "communication calendar months,xpath, //ul[@class='k-reset']/li";
	public static final String communicationpage_calendardates_select = "communication calendar dates,xpath, //table[@class='k-calendar-table']/tbody";
//	public static final String communicationpage_goalpercentage_textbox = //table[@class='k-calendar-table']/tbody/tr
	public static final String pwcommunicationpage_communicationtype_select = "Communication type,pw,//span[contains(@aria-label,'Communication type')]";
	public static final String pwcommunicationpage_producttype_select = "Product type,pw,//span[contains(@aria-label,'Product type')]//span[contains(@class,'k-input-value-text')]";
	public static final String pwcommunicationpage_primarygoal_select = "Primary goal,pw,//span[contains(@aria-label,'Primary goal')]//span[contains(@class,'k-input-value-text')]";
	public static final String pwcommunicationpage_calendaryear_click = "communication calendar year,pw,//div[contains(@class,'k-calendar-header')]//span[@class='k-button-text']";

	// commu - startdate

	public static final String communicationstartdate = "communication start date,xpath,//input[@name='startdate']";
	public static final String communicationsendDate = "communication End date,xpath,//input[@title='End date']";
	public static final String calenderyearslist = "communication year list,xpath,//ul[@class='k-reset']//li";
	public static final String calendermonths = "communication month select,xpath, //ul[@class='k-reset'][@style='transform: translateY(128px);']";
	public static final String calendermonthlist = "Start Month,xpath, //ul[@class='k-reset']/li";
	public static final String calenderstartdatetable = "startdate table,xpath,//table[@class='k-calendar-table']//tbody[1]//tr[position()>1]";
	public static final String pwcommunicationstartdate = "communication start date,pw,//input[@name='startdate']";
	public static final String pwcommunicationsendDate = "communication End date,pw,//input[@title='End date']";
	public static final String pwcalenderyearslist = "communication year list,pw,//ul[@class='k-reset']//li";
	public static final String pwcalenderstartdatetable = "startdate table,pw,//table[@class='k-calendar-table']//tbody[1]//tr[position()>1]";

	public static final String calender_Startmonth = " Start Month ,xpath, //div[@class='calendar left']//select[@class='monthselect']";

	public static final String calender_Startyear = " Start year ,xpath, //div[@class='calendar left']//select[@class='yearselect']";
	public static final String calender_StartyearList = "Start year year ,xpath, //div[@class='calendar left']//select[@class='yearselect']/option";
	public static final String calender_EndMonth = " End Month ,xpath, //div[@class='calendar right']//select[@class='monthselect']";
	public static final String calender_EndMonthList = "End Month ,xpath, //div[@class='calendar right']//select[@class='monthselect']/option";

	public static final String communicationpage_primarygoal_Conversion = "Conversion dropdown,xpath,//div[@role='listbox']//input";
	public static final String communicationpage_primarygoal_Conversionlistbox = "Conversion listbox,xpath, //*[@id='CampaignConversitionList_listbox']/li";
	public static final String communicationpage_click_next = "Next button,xpath,//button[normalize-space()='Next']";
	public static final String pwcommunicationpage_click_next = "Next button,pw,//button[normalize-space()='Next']";

//	public static final String calender_LeftTable = "Custom Range calender Left table ,xpath, //button[@class='k-button k-flat k-calendar-title'];//div[@class='calendar left']//tbody";
//	public static final String calender_Startmonth = " Start Month ,xpath, //div[@class='calendar left']//select[@class='monthselect']";
//	public static final String calender_StartmonthList = "Start Month,xpath, //div[@class='calendar left']//select[@class='monthselect']/option";
//	public static final String calender_Startyear = " Start year ,xpath, //div[@class='calendar left']//select[@class='yearselect']";
//	public static final String calender_StartyearList = "Start year year ,xpath, //div[@class='calendar left']//select[@class='yearselect']/option";
//	public static final String calender_EndMonth = " End Month ,xpath, //div[@class='calendar right']//select[@class='monthselect']";
//	public static final String calender_EndMonthList = "End Month ,xpath, //div[@class='calendar right']//select[@class='monthselect']/option";

	// public static final String communicationpage_click_next = "Communication create next button,id,btnCreateCampaign";
	public static final String communicationpage_channel_type2 = "Channel SMS ,xpath,//input[@id='channelTypes[1].selected']";
	public static final String communicationpage_channel_type3 = "Channel Social media ,id,channelTypes[3].selected";
	public static final String communicationpage_channel_QR = "QR Channel,xpath,//input[@id='channelTypes[6].selected']";
	public static final String communicationpage_channel_type5 = "Channel Notification ,xpath,//input[@id='channelTypes[3].selected']";
	public static final String communicationpage_channel_type6 = "Channel Paidadds ,xpath,//input[@id='channelTypes[5].selected']";
	public static final String communicationpage_channel_type7 = "Channel Voice ,id,channelTypes[4].selected";
	public static final String communicationpage_analytics_option1 = "web,id,analyticsTypes[0].selected";
	public static final String communicationpage_analytics_option2 = "Analytic web,xpath,//input[@id='analyticsTypes[0].selected']";
	public static final String communicationpage_analytics_option3 = "Analytic APP,id,analyticsTypes[1].selected";
	public static final String communicationpage_analytics_option4 = "Analytic Video,id,analyticsTypes[2].selected";
	public static final String communicationpage_analytics_option5 = "Analytic App,xpath,//input[@id='analyticsTypes[1].selected']";
	public static final String communicationRefereceIcon = "Communication reference icon,xpath, //*[@id='aCampaignDocket']";
	public static final String communicationRefereceSelectdrpdown = "Communication groupid,xpath, //div[@id='divTestCampaignDocket']";
	public static final String communicationRefereceNewGroupingIDselect = "Communication groupid listbox,xpath, //*[@id='campDocketGroup_listbox']/li";
	public static final String communicationRefereceNewGroupingIDEnter = "Communication groupid value,xpath, //*[@id='newCampaignGroup']";
	public static final String communicationRefereceSelectprioritydrpdown = "Commgroup priority,xpath, (//span[contains(.,'-- Select priority --select')])[2]";
	public static final String communicationRefereceSelectprioritySelect = "Commgroup priority listbox,xpath, //*[@id='CampaignGroupidPriority_listbox']/li";
	public static final String communicationRefereceCommRefname = "Comm ref name,xpath, //input[contains(@placeholder,'Enter Campaign Ref Name')]";
	public static final String communicationRefereceCommRefNo = "Comm ref no,xpath, //input[contains(@placeholder,'Enter Ref No')]";
	public static final String communicationRefereceCommRefVal = "Comm ref value,xpath, //input[contains(@placeholder,'Enter Ref Val')]";
	public static final String communicationRefereceCommRefSAVEbtn = "Comm ref save button,xpath, //*[@id='campaignDocketSaveBtn']";
	public static final String communicationRefereceCommRefSAVEbtncnfm2 = "Ref save confirm button,xpath, //*[@id='confirm-grouping-IsNotStarted']/div//input";
	public static final String communicationReferencgroupingBlastPopup = "Grouping popup,xpath, //*[@id='confirm-grouping-IsNotStarted']/div/div/div[2]/input";
	public static final String communicationpage_startdate_webtab = "Start date,id,StartDate";
	public static final String communicationpage_enddate_webtab = "End date,id,EndDate";
	public static final String communicationemail_comm_commtype = "Communication type,xpath,//span[contains(@aria-label,'Communication type')]//.//span//span";
	public static final String communicationemail_comm_prodtype = "Product type,xpath, //span[contains(@aria-label,'Product type')]//span[contains(@class,'k-input-value-text')]";
	public static final String communicationemail_comm_primarygoal = "Primary goal,xpath, //span[contains(@aria-label,'Primary goal')]//span[contains(@class,'k-input-value-text')]";
	public static final String communicationemail_comm_goalpercent = "Goalpercentage,xpath, //input[@onblur='Goalpercentage()']";

	// COMMUNICATION SMART URL / UTM PARAMETER
	public static final String communicationpage_smarturl_yes = "Smarturl yes,xpath,//button[.='Yes']";
	public static final String communicationpage_smarturl_web = "Smarturl link,xpath,//input[contains(@name,'smartLink')][@type='text']";
	public static final String communicationpage_smarturl_generatesmarturl = "Smarturl generate button,xpath,//div[@class='rs-accordion-wrapper mt20']//button[.='Generate']";
	public static final String communicationpage_smarturl_generatedsmarturl = "Generated URL,xpath,//input[@id='spnSmartUrl']";
	public static final String communicationpage_smarturl_verifyA = "Smart Url,xpath,//span[contains(.,'http')]";
	public static final String communicationpage_smarturl_nothanks = "Smarturl no thanks,xpath,//button[normalize-space()='No thanks']";
	public static final String UTMcheckboxClick = "Utm chk box,xpath, //*[@id='addPersonalizationTagJs']";
	public static final String UTMAttributesDrpdownClick1 = "Utm attribute dropdown,xpath,//*[@id='advSettpersonalizaValueContainer1']";
	public static final String UTMAttributesDrpdownSelect1 = "Utm attribute listbox,xpath,//*[@id='advSettpersonalizaValueDivTagSelect1_listbox']/li";
	public static final String UTMAttributesDrpdownClick2 = "Utm attribute2 dropdown,xpath,//*[@id='advSettpersonalizaValueContainer2']";
	public static final String UTMAttributesDrpdownSelect2 = "Utm attribute2 listbox,xpath,//*[@id='advSettpersonalizaValueDivTagSelect2_listbox']/li";
	public static final String SmartlinkPersonaClick = "Smartlink personaliztion icon,xpath,//*[@id='SLPersonalize']/a/i";
	public static final String SmartlinkPersonaSelect = "Smartlink persona listbox,xpath,//*[@id='SLPersonalize']/ul/li";
	public static final String SmartlinkCustomTagEnter = "Utm parameter tag,xpath,//*[@placeholder='Enter custom tag']";
	public static final String SmartlinkEnterTag = "Utm custom tag,xpath,//*[@placeholder='Enter tag']";
	public static final String UTMcheckboxAddicon = "Utm checkbox add icon,xpath,//a[@class='inline-topleft no-hover advSettpersonalizaValueTagAdd']//i[@class='icon-plus-fill-small icon-sm blue']";
	public static final String pwcommunicationpage_smarturl_yes = "Smarturl yes,pw,//button[.='Yes']";
	public static final String pwcommunicationpage_smarturl_web = "Smarturl link,pw,#rs_GenerateSmartLink_DomainURL";
	public static final String pwcommunicationpage_smarturl_generatesmarturl = "Smarturl generate button,pw,//button[.='Generate']";

	// COMMUNICATION EMAIL CHANNEL PAGE
	public static final String communicationpage_channel_options = "Channel options,xpath,//*[contains(@class,'tabs-vertical')]//li";
	public static final String communicationpage_emailtextcontent_enterpersonalizetext = "Personalize Text,xpath, //iframe[@class='k-content']";
	public static final String communicationpage_emailtextcontent_clickshorturlicon = "Shorturl icon,xpath, //i[contains(@title,'Smart link')]";
	public static final String communicationpage_emailtextcontent_selectshourturl = "Generated shorturl,xpath, //ul[@class='dropdown-menu dropdown-input']/li";
	public static final String communicationpage_emailtextcontent_clicktextcontent = "Email content text icon,xpath,//*[@id='acnRichText']/i";
	public static final String communicationpage_emailtextcontent_continuewithurlconfirmation = "Shorturl confirm button ,xpath, //*[@id='email-smartlink-Conformation']//../input[2]";
	public static final String communicationpage_email_sender_username = "Sender User name,xpath,//*[@placeholder='Username']";
	public static final String communicationpage_email_sender_domain = "Email domain dropDown,xpath,//*[@placeholder='Username']/../..//following-sibling::div//span[@class='k-input']";
	public static final String communicationpage_email_sender_domainlist = "Email domain Option,xpath,//*[@class='k-list k-reset']//li";
	public static final String communicationpage_email_femail = "Sender email,xpath,//*[@placeholder='{info@domain.com}']";
	public static final String communicationpage_email_receip_click = "Recepient,xpath,//label[@class='control-label-left'][text()='Audience']/../..//ancestor::span[contains(@class,'floating-label-container')]";
	public static final String communicationpage_communication_selectedrecipient = "Selected Recipient,xpath, //*[@id='recipientPanel']//div[@id='divSelectedRecipients']";
	public static final String communicationpage_email_receip_list = "Recepient list,xpath,//*[@class='k-list k-reset']//li";
	public static final String communicationemail_comm_subjectline = "Subject line,xpath, (//div[@data-type='input'])[1]";
	public static final String communicationemail_comm_subjectlineselected = "Subjectline selected,xpath,//div[@id='rs_SplitABTab_subjectLine']";
	public static final String email_clickimportzip = "Import zip,xpath,//input[@type='file']";
	public static final String communicationpage_emailschedule_date = "EmailScheduleDate,xpath,//span[@aria-controls='EmailScheduleDate_dateview']/i";
	public static final String communicationpage_temptemp = ",xpath,//*[@id='EmailScheduleDate']";
	////
	public static final String email_clickimportzip_button = "Import zip,id,rs_Import_zipfile";

	public static final String communicationemail_comm_subject = "Subjectline selected,xpath,//div[@id='rs_SplitABTab_subjectLine']";

	public static final String communicationpage_communication_recipient = "Selected Recipient,xpath, //div[@id='rs_Email_audienceemail']";

	public static final String pwemail_clickimportzip = "Import zip,pw,//input[@type='file']";
	public static final String pwcommunicationpage_email_receip_click = "Recepient,pw,//label[@class='control-label-left'][text()='Audience']/../..//ancestor::span[contains(@class,'floating-label-container')]";

	public static final String communication_commoncoupencode = "Coupen code,xpath,//div[@class='email_richTextContent']//i[@title='Coupon code']";
	public static final String communication_selectoffertype = "Select Offer Type,xpath,//div[@id='offerTypeContainer']//span[@class='k-input'][.='-- Select Offer type --']";
	public static final String communication_offertypedropdown = "Offer Type dropdown,xpath,//div[contains(@id,'offerType')]//ul//li";
	public static final String communication_selectofferlist = "Select Offer List,xpath,//div[@id='offerTypeContainer']//span[@class='k-input'][.='-- Select Offer list --']";
	public static final String communication_offerlistdropdown = "Offerlist dropdown,xpath,//div[contains(@id,'offerList')]//ul//li";
	public static final String communication_offer_savebutton = "Save Button,xpath,//input[@onclick='SaveCampaignOffer();']";
	public static final String communication_offer_emailcontent = "Offer Email Content,xpath,(//div[@id='messagebody']//tr)[3]//td";

	public static final String communication_uniquecoupencode = "Unique code,xpath,//input[@id='dynamicOffer']";
	public static final String pwcommunicationpage_select_emailsub = "Mail subject line,pw,//input[@name='subjectLine']";
	public static final String pwcommunicationpage_emailsubject_personalize_icon = "SubjectPersonalize icon,pw,(//i[contains(@class,'user-question')])[2]";

	public static final String communicationpage_select_emailsub = "Mail subject line,xpath,//input[@name='subjectLine']";
	public static final String communicationpage_emailsubject_personalize_icon = "SubjectPersonalize icon,xpath,(//i[contains(@class,'user-question')])[2]";
	public static final String communicationpage_emailsubject_personalize_list = "SubjectPersonalize list,xpath,//*[@id='SubjectPersonalize']/ul/li";
	public static final String communicationpage_emailtextcontent_personalize_icon = "EmailContentPersonalize,xpath,//*[@id='ShowAvailableFieldsContent']/i";
	public static final String communicationpage_emailtextcontent_personalizelist = "EmailContentPersonalize,xpath, //a[@id='ShowAvailableFieldsContent']/..//ul/li";
	public static final String communicationpage_emailtextcontent_clickhyperlinkicon = "EmailContent hyper link,xpath, //span[contains(.,'Create Link')]";
	public static final String communicationpage_emailtextcontent_enterhyperlinkwebaddress = "EmailContent hyper link address,xpath, //*[@id='k-editor-link-url']";
	public static final String communicationpage_emailtextcontent_enterhyperlinktext = "EmailContent hyper link,xpath, //*[@id='k-editor-link-text']";
	public static final String communicationpage_emailtextcontent_enterhyperlinktooltip = "EmailContent hyper link tooltip,xpath, //*[@id='k-editor-link-title']";
	public static final String communicationpage_emailtextcontent_clickopenlinkcheckbox = "EmailContent hyper link checkbox,xpath, //*[@id='k-editor-link-target']";
	public static final String communicationpage_emailtextcontent_clickinsertbutton = "EmailContent hyper link insert,xpath, //*[@id='kvinoth']";
	public static final String communicationpage_emailtextcontent_clickinsertimageicon = "Insertimageicon,xpath, //span[contains(.,'Insert Image')]";
	public static final String communicationpage_emailtextcontent_clickinsertimagewebaddress = "Image webaddress,xpath, //*[@id='k-editor-image-url']";
	public static final String communicationpage_emailtextcontent_clickinsertimagetext = "Image text,xpath, //*[@id='k-editor-image-title']";
	public static final String communicationpage_emailtextcontent_clickinsertimageheight = "Image width,xpath, //*[@id='k-editor-image-width']";
	public static final String communicationpage_emailtextcontent_clickinsertimagewidth = "Image geight,xpath, //*[@id='k-editor-image-height']";
	public static final String communicationpage_email_senderName_personalizeicon = "Sendername Personalize icon,xpath, //*[@id='divSenderNamesPersonalize']//a/i";
	public static final String communicationpage_email_senderName_personalizelist = "Sendername persona listbox,xpath, //*[@id='divSenderNamesPersonalize']//div//ul/li";
	public static final String email_clickimport = "Import,xpath,//span[text()='Import']//parent::li";
	public static final String communicationemail_commrefresh = "Refresh,xpath,//i[contains(@class,'refresh-medium')]";
	public static final String communicationemail_refresh_ok = "Refresh ok,xpath,//button[text()='OK']";
	public static final String communicationpage_select_emailcommunicationnext = "Next button,xpath,//button[text()='Next']";
	public static final String pwemail_clickimport = "Import,pw,//i[contains(@class,'import-file')]";
	public static final String email_clicktemplate = "Import,xpath,//i[contains(@class,'template')]";

	public static final String communicationpage_email_dateTimeErr = "Date time error,id,errmsgEmailValidPastDateTime";
	public static final String communication_email_inboxfirstlinemessage = "InboxFirstLineMessage,xpath, //*[@id='InboxFirstLineMessage']";
	public static final String communication_email_unsubchkbox = "chkUnsubscribeSetting,xpath,//span[@id='rs_SplitABTab_Unsubscriptionmessage']";
	public static final String communication_email_scheduleddate = "scheduledate selected,xpath, //*[@id='EmailSchedulePanel']";
	public static final String communication_email_scheduleddateedit = "scheduledate selected,xpath,//label[.='Schedule']//ancestor::div[contains(@class,'form-group pe-none')]";

	public static final String communication_email_selectedrfa = "rfa selected,xpath,//div[@class='requestApprovalBlock row']//ancestor::div//div[contains(@class,'form-group  rfa pe-none')]";
	public static final String communication_email_unsubselect = "UnsubscribeSettingID,xpath,(//span[contains(text(),'Message')]/..//ancestor::span[contains(@class,'dropdownlist')])[2]";
	public static final String communication_email_unsubmsg = "UnsubscribeSettingID listbox,xpath, //*[@id='UnsubscribeSettingID_listbox']//li[2]";
	public static final String communicationpage_email_footer = "Footer checkbox,xpath,(//input[@id='emailFooter'])[1]";
	public static final String communicationpage_email_eventfooteraddress = "Footer,xpath,(//i[contains(@class,'template-medium')])[1]";
	public static final String communication_EventTrigger_footermsg = "Footer list,xpath,//div[@class='css-scrollbar']//div";
	public static final String pwcommunicationpage_select_emailcommunicationnext = "Next button,pw,//button[text()='Next']";

	public static final String communicationpage_emailschedule_timezoneselect = "Timezone select,xpath,//div[@class='k-list-scroller']//li";
	public static final String communicationpage_email_sendTestEmailSend = "Preview send button,xpath,//button[.='Send']";
	public static final String communicationpage_email_sendTestEmailSendBtn = "Preview send button,xpath,//button[.='Send']";
	public static final String email_testmailerrmsg = "Test mail error msg,id,errmsgTestCampaignEmailAddress";
	public static final String communicationpage_email_sendTestEmailTo = "Test mail to,xpath,//span[@aria-label='Select/Enter email address']";
	public static final String communicationpage_email_sendTestEmailTolist = "Test mail list,xpath,//*[@class='k-list k-reset']//li";
	public static final String communicationpage_email_sendnewmailid = "Test email,xpath,//input[contains(@name,'approvalList.testEmail')]";

	public static final String communicationpage_email_approver_sendnewmailid = "Test email,xpath,//input[contains(@name,'.approverName')]";
	public static final String email_testmail_msg = "Test mail message,xpath,//i[contains(@class,'circle-thumbs')]/..//div";
	public static final String communicationpage_emailschedule_timelistFirstValue = "Schedule time list value,xpath,//ul[@id='EmailScheduleDate_timeview']/li[1]";
	public static final String communicationpage_email_save = "Save button,xpath,//button[contains(@class,'rsp-default-button rsp-secondary-button')][.='Save']";
	public static final String communicationpage_email_draftsave_ok = "Draft save,xpath, (//input[@value='OK'])[3]";
	public static final String communicationpage_email_requestapprovecheckbox = "RFA checkbox,xpath,//input[@id='approvalList.requestApproval']";
	public static final String communicationemail_editedm = "Edm edit refresh,xpath, //*[@id='aImportTypeRefresh']/i";
	public static final String communicationemail_subjectline_thumbsupicon = "SubjectLine Thumbsup Icon,xpath, //a[@id='SubjectLineSpamCheckScore']";// a[@id='importSpamCheckScore']/i";
	public static final String communicationemail_subjectline_headertext = "subjectline score header text,xpath, //h4[@id='subjectLineHeading']";
	public static final String communicationemail_subjectline_projectedreachrate = "Subjecline projected rate heading,xpath, (//span[@class='icon-holder pie'])[1]";
	public static final String communicationemail_subjectline_projectedreachratevalue = "Subjectline projected rate value,xpath, (//div[@class='pie_progress__number'])[1]";
	public static final String communicationemail_subjectline_subjectlinelength = "Subject line subject header,xpath, //span[contains(.,'Subject line length')]";
	public static final String communicationemail_subjectline_subjectlinelengthvalue = "Subject line subject value,xpath, //div[@class='pie_progress1 pie_progress']//div[@class='pie_progress__number']";
	public static final String communicationpage_subjectline_thumbpopupclose = ",xpath,//button[@class='blue close icon-close-small modalCloseIcon'][1]";
	public static final String communicationpage_email_replycheckbox = "Reply email checkbox,id,receiveReplies";
	public static final String communicationpage_email_replyemail = "AlternateReplyEmailAddressValue,id,AlternateReplyEmailAddressValue";
	public static final String communicationpage_email_selectreplymail = "AlternateReplyEmailAddress list,xpath, //*[@id='AlternateReplyEmailAddress_listbox']/li";
	public static final String communicationpage_email_enterreplymail = "AlternateReplyEmail,id,newAlternateReplyEmail";
	public static final String communicationpage_email_rfamaillistbox1 = "Rfa mail listbox2,xpath,//span[@aria-owns='TestCampaignEmailAddress_listbox']";
	public static final String communicationpage_email_selectrfamaillist1 = "Rfa mail2,xpath,//ul[@id='TestCampaignEmailAddress_listbox']/li";
	public static final String communicationpage_email_rfamaillistbox2 = "Rfa mail listbox3,xpath,//span[@aria-owns='selectMailID2_listbox']";
	public static final String communicationpage_email_selectrfamaillist2 = "Rfa mail3,xpath,//ul[@id='selectMailID2_listbox']/li";
	public static final String communicationpage_email_rfamaillistbox3 = "Rfa mail listbox,xpath,//span[@aria-owns='selectMailID3_listbox']";
	public static final String communicationpage_email_selectrfamaillist3 = "Rfa mail,xpath,//ul[@id='selectMailID3_listbox']/li";
	public static final String communicationpage_rfa_addrfamailsicon = "Rfa Add Icon,id,addSendapproveMail";
	public static final String communicationpage_rfa_settingsicon = "Rfa settings Icon,id,Approvalsettingsid";
	public static final String communicationpage_rfa_allconditionbutton = "Rfa settings All,id,emailapprovalFromAll";
	public static final String communicationpage_rfa_anyconditionbutton = "Rfa settings Any,id,emailapprovalFromAny";
	public static final String communicationpage_rfa_clickanyconddropdown = "Rfa Anycondtion dropdown,xpath,//span[@aria-owns='emailRequestApprivalcount_listbox']";
	public static final String communicationpage_rfa_selectanycondvalue = "Rfa Anycondtion listbox,xpath,(//*[@id='emailRequestApprivalcount_listbox'])[4]//li";// *[@id='emailRequestApprivalcount_listbox']/li";
	public static final String communicationpage_rfa_hierarchyoff = "Rfa hierarchy off,xpath,//span[@class='bootstrap-switch-handle-off bootstrap-switch-default']";
	public static final String communicationpage_rfa_hierarchyon = "Rfa hierarchy on,xpath,//span[@class='bootstrap-switch-handle-on bootstrap-switch-primary']";
	public static final String communicationpage_rfa_clickhierarchyswitch = "Rfa hierarchy button,xpath,//label[@for='checkemailFollowhierarchy']";
	public static final String communicationpage_rfa_settingssave = "Rfa settings save icon,id,btnEmailRequestForApproval";
	public static final String communicationpage_recipientaddicon = "recipient add icon,xpath, (//*[@id='spnNewEmailSegment'])[1]/a/i";
	public static final String communicationpage_recipientpage = "recipient page,xpath, //h1[contains(.,'New target list')]";
	public static final String communicationpage_footerlinkicon = "footerlink icon,xpath, //*[@id='spnNewEmailSegment1']/a/i";
	public static final String communicationpage_settingslinkpage = "comm settings page,xpath, //*[@id='wrapper']//h1[contains(.,'Communication settings')]";
	// SPLIT AB
	public static final String communicationpage_EmailSplitON = "Split AB ON,xpath,//span[contains(@class,'k-switch k-swit')]";
	public static final String pwcommunicationpage_EmailSplitON = "Split AB ON,pw,#rs_Email_splitTest";

	public static final String communicationpage_SMSSplitON = "Split AB ON,xpath,//div//span[contains(@class,'switch-off')]";
	public static final String pwcommunicationpage_Email_split_addBtn = "Split Add (+),pw,//i[@class='icon-rs-circle-plus-edge-medium icon-md color-primary-blue']";

	public static final String communicationpage_Email_split_addBtn = "Split Add (+),xpath,//i[@class='icon-rs-circle-plus-edge-medium icon-md color-primary-blue']";
	public static final String email_split_autoschedulesettingsIcon = "Split auto setting,id,rs_Email_settings";
	public static final String SMS_split_autoschedulesettingsIcon = "Split auto setting,xpath,//i[contains(@class,'icon-rs-settings-medium icon-md  ')]";

	public static final String communicationpage_EmailsplitABDownarrow = "splitABDownarrow,id,rs_Email_caret";
	public static final String pwcommunicationpage_EmailsplitABDownarrow = "splitABDownarrow,pw,#rs_Email_caret";

	public static final String communicationpage_SMSsplitABDownarrow = "splitABDownarrow,xpath,//i[@class='icon-rs-caret-mini icon-sm']";

	public static final String communicationpage_EmailsplitABDrag_btn = "SplitemailDrag,xpath,//*[@id='emailDrag']/div[3]/img";
	public static final String communicationpage_EmailsplitABDrag_save = "SplitemailDrag save,id,rs_splitslider_Save";
	public static final String pwcommunicationpage_EmailsplitABDrag_save = "SplitemailDrag save,pw,#rs_splitslider_Save";
	public static final String pwSplitABAutoshduleSavebutton = "Auto schedule popup save,pw, //div[@class='modal-content rsmd-content']//button[.='Save']";

	public static final String communicationpage_EmailsplitABDrag_cancel = "SplitemailDrag cancel,xpath,//*[@id='divEmailSplitAbcd']/div[2]/div/div[2]/input";
	public static final String SplitABAutoshduleSavebutton = "Auto schedule popup save,xpath, //div[@class='modal-content rsmd-content']//button[.='Save']";
	public static final String SplitABAutoshduleCancelbutton = "Auto schedule popup cancel,xpath, //*[@id='DivedmScheduleValidation']/input[1]";
	public static final String SplitABAutoshduleClosebutton = "Auto schedule popup close,xpath, //*[@id='scheduleModal']/div/div/div[1]/button";
	public static final String communicationpage_WebSplitON = "SplitABCD ON,xpath,//label[@for='chkWebPushSplitAB']";
	public static final String communicationpage_Websplit_addBtn = "Split/Carousel Add (+),xpath,//*[@id='liWebsplitE']/a/i";
	public static final String communicationpage_WebsplitABDownarrow = "splitABDownarrow,xpath,//a[@id='splitABWebPushDownarrow']/i";
	public static final String communicationpage_WebsplitABDrag_save = "SplitwebDrag save,xpath,//button[contains(@class,'saveSplitWebPushBtn')]";
	public static final String communicationpage_WebsplitABDrag_btn = "SplitemailDrag,xpath,//div[@class='row'][contains(.,'Split')]";
	public static final String communicationpage_WebsplitABDrag_cancel = "SplitemailDrag cancel,xpath,//*[@id='divwebPushSplitAB']/div[2]/div/div[2]/input";
	public static final String communication_split_autoschedulewebsettingsIcon = "Split auto setting,xpath,//*[@id='WebPushscheduleModal']//i[contains(@class,'settings')]";
	public static final String SplitABAutoshduleWebSavebutton = "Auto schedule popup save,xpath, //*[@id='btnWebSplitABAutoSchedule']";
	public static final String communicationpage_MobileSplitON = "SplitABCD ON,xpath,//label[@for='chkMobilePushSplitAB']";
	public static final String communicationpage_Mobilesplit_addBtn = "Split Add (+),xpath,//*[@id='liMobilesplitE']/a/i";
	public static final String communicationpage_MobilesplitABDownarrow = "splitABDownarrow,xpath,//a[@id='splitABMobilePushDownarrow']/i";
	public static final String communicationpage_MobilesplitABDrag_save = "SplitMobileDrag save,xpath,//button[contains(@class,'saveSplitMobilePushBtn')]";
	public static final String communication_split_autoschedulemobilesettingsIcon = "Split auto setting,xpath,//*[@id='MobilePushscheduleModal']//i[contains(@class,'settings')]";
	public static final String SplitABAutoshdulemobileSavebutton = "Auto schedule popup save,xpath, //*[@id='btnMobSplitABAutoSchedule']";
	public static final String communicationpage_AudienceList = "list name,xpath,//span[@class='k-chip-content']";
	public static final String communicationpage_subline_top3 = "Top 3 subjectline,xpath,//div[normalize-space()='Top 3 subject lines']";
	public static final String communicationpage_EDM_link = "EDm link,xpath,//a[@target='blank']";
	public static final String communicationpage_EDM_FileWieght = "EDM File Weight,xpath,//input[@id='hdnEDMFileWeight']";
	public static final String pwcommunicationpage_AudienceList = "list name,pw,//span[@class='k-chip-content']";

	// Template Builder
	public static final String communicationpage_email_templatebuildericon = "Template builder icon,xpath, //*[@id='acnTemplate']/i";
	public static final String communicationpage_email_createnewtemplate = "Create new Template,xpath, //*[@id='divtemplateEmail']/li/a[contains(.,'Create new template')]";
	public static final String communicationpage_email_templatename = "Template builder icon,xpath, //*[@id='templateName']";
	public static final String communicationpage_email_templatecategory = "Template builder icon,xpath, //*[@id='ddlSaveTemplate']";
	public static final String communicationpage_email_selecttemplatecategory = "Template builder icon,xpath, //*[@id='acnTemplate']/i";
	// public static final String communicationpage_email_templatebuildericon = "Template builder icon,xpath, //*[@id='acnTemplate']/i";

	// COMMUNICATION SMS PAGE
	public static final String pwcommunicationsms_selectproviderid = "Sms provider id dropdown,pw,//span[contains(@aria-label,'Sender ID')]//span[contains(@class,'k-input-value-text')]";
	public static final String pwcommunicationsms_tempID = "Template Id,pw,//input[@name='templateId']";

	public static final String communicationsms_selectproviderid = "Sms provider id dropdown,xpath,//span[contains(@aria-label,'Sender ID')]//span[contains(@class,'k-input-value-text')]";
	public static final String communicationsms_enterproviderid = "Provider id,xpath,//*[@class='k-list k-reset']//li";
	public static final String communicationsms_tempID = "Template ID,xpath,//input[@name='templateId']";
	public static final String communicationpage_select_smsreceip_click = "Sms recipient,xpath,//*[text()='Audience']/ancestor::div[contains(@class,'custom-column')]//input[@class='k-input']";
	public static final String communicationpage_select_smsreceip_list = "Recipient listbox,xpath,//*[@class='k-list k-reset']//li";
	public static final String communicationpage_select_smsscheduledate = "Schedule date,xpath, //span[@aria-controls='MoblieScheduleDate_dateview']/i";
	public static final String communicationpage_smsSchedule_timelistFirstValue = "Schedule date,xpath,//ul[@id='MoblieScheduleDate_timeview']/li[1]";
	public static final String communicationpage_sms_dateTimeErr = "Date time error,id,errmsgMobileValidPastDateTime";
	public static final String communicationpage_select_smscommunicationnext = "Sms comm next button,id,smsCampaignNext";
	public static final String communicationpage_select_smscommunicationsave = "Sms comm save button,id,rs_Messaging_Save";
	public static final String communicationpage_select_smsdraftsave = "Sms draft OK button,xpath, //input[@onclick='SMSCampaignContinue()']";
	public static final String allmenu_ifcommunicationlistingappears = ",xpath, //h1[contains(.,'Campaign')]";
	public static final String communicationpage_sms_approvalchk = "Approval checkbox,id,mobilerequestApproved";
	public static final String communicationpage_sms_aprovemailto = "Approval mail dropdown,xpath,//*[@id='reqApprovalPanel']//span[@role='listbox']/span";
	public static final String communicationpage_sms_aprovemailtolist = "Appr mail listbox,xpath,//*[@id='ApprovalEmailAddress_listbox']/li";
	public static final String communicationpage_sms_mail_enter = "Mail id,id,newEmailAddressApprovalforSMS";
	public static final String communicationpage_sms_aproveSend = ",xpath,//*[@id='mobileRequestSendButtonPanel']/input";
	public static final String communicationpage_sms_selectanalytics = "Analytics,xpath, //*[@id='divSmartPanel']//..//ul//small[contains(text(),'Analytics')]";
	public static final String communicationpage_select_smstimezoneicon = "Timezone icon,xpath, //a[@class='no-hover SMSedit-timezone'][1]";
	public static final String communicationpage_select_smstimezonelist = "Timezone list,xpath, //span[@aria-owns='mobileTimeZone_listbox']";
	public static final String communicationpage_select_selectsmstimezone = "Timezone listbox,xpath, //*[@id='mobileTimeZone_listbox']/li";
	public static final String sms_testnumber = "Phone no,xpath,//input[@type='tel']";
	public static final String sms_testSend = "Send button,xpath,//*[@id='sendButtonPanel']/input";
	public static final String pwcommunicationsms_selectpersonalization = "Persona icon,pw,//i[@class='icon-rs-user-question-mark-medium icon-md']";

	public static final String sms_testSMS_msg = "Test message,id,campaign-test-mail-sent-msg";
	public static final String communicationsms_selectpersonalization = "Persona icon,xpath,//i[contains(@class,'icon-rs-editor-personal')]";
	public static final String communicationsms_personalizationlist = "drop-down list,xpath,//div[@class='css-scrollbar']//div";
	public static final String communicationsms_clicksmartlinkurl = "Smarturl icon,xpath, (//*[@id='ulSMSElements']/li[3]/div/a)[1]";
	public static final String communicationsms_selectsmartlinkurl = "Smart Link,xpath,//i[@title='Smart link']";
	public static final String communicationsms_smsContentPrev = "SMS Content Preview,xpath,//div[contains(@class,'rsm-content-wrapper')]";
	public static final String communicationsms_Entersmscontent = "Sms content,xpath,//textarea[@id='editorText']";
	public static final String pwcommunicationsms_Entersmscontent = "Sms content,pw,//textarea[@id='editorText']";

	public static final String communicationsms_selectedproviderid = ",xpath, //span[@aria-activedescendant='ClientSmsSettingId_option_selected']/span/span[1]";
	public static final String communicationsms_selectedrecipientlist = ",xpath, //*[@id='SelectedMobileRecipients_taglist']/li/span";
	public static final String communicationsms_senderidicon = "senderid add icon,xpath, //i[@data-original-title='Add sender ID']";
	public static final String communicationsms_recipientaddicon = "recipient add icon,xpath, //*[@id='spnNewSMSSegment']/a/i";

	public static final String communicationsms_couponcode = "SMS Offer Code,xpath,//div[@id='DivSMSSubject']//*[@class='icon-coupon-small blue icon-sm']";
	public static final String pwnotification_webpush_analyticsplatform = "Analytic platform,pw,//span[@aria-label='Analytics platform']//span[@class='k-input-value-text']";

	// PRE COMMUNICATION ANALYTICS
	public static final String notification_webpush_wpnexttoprecommunication = "Analytic next button,xpath,//button[.='Next']";
	public static final String notification_webpush_analyticsplatform = "Analytic platform,xpath,//span[@aria-label='Analytics platform']//span[@class='k-input-value-text']";
	public static final String notification_webpush_selectplatform = "Analytic platform list,xpath, //*[@id='ddlDomainType1_listbox']/li";
	public static final String notification_mobilepush_clickplatform = "Mobile App Analytic platform,xpath, //span[@aria-owns='ddlAppDomainType_listbox']";
	public static final String notification_mobilepush_selectplatform = "Mobile App Analytic platform dropdown,xpath, //*[@id='ddlAppDomainType_listbox']//li";
	public static final String notification_webpush_selectdomain = "AnalyticDomain,xpath,//span[@aria-label='Domain']//span[@class='k-input-value-text']";
	public static final String notification_webpush_enterdomain = "AnalyticDomain list,xpath, //*[@id='AnalyticsSettingID_listbox']/li";
	public static final String precomm_content = ",xpath,//div[@class='page-content']";
	public static final String notification_webpush_wpnexttosave = "Precomm save button,xpath,//button[.='Next']";
	public static final String notification_webpush_wpconfirmpopup = "Precomm confirm popup button,xpath, //a[@class='btn btn-link cpNextScreenPayment']";
	public static final String notificaiton_mobilepush_getanalyticdomainurl = "Analytic domain url,xpath, (//*[@ID='tabDomain']//span[@aria-owns='AnalyticsSettingID_listbox']//span/span)[1]";
	public static final String precomm_Analytics_clickconversioncategory = "Conversion Category,xpath,//span[@aria-label='Select the attributes']";
	public static final String precomm_Analytics_selectconversioncategory = "Select Conversion Category,xpath, (//ul[@id='ddlConversionCategory_listbox'])[2]/li";
	public static final String precomm_Analytics_clicksubscriptionform = "Subscription form,xpath, //span[@aria-owns='FormId_listbox']";
	public static final String precomm_Analytics_selectsubscriptionform = "Select Subscription form,xpath, //ul[@id='FormId_listbox']//li";
	public static final String precomm_Analytics_conversionurl = "Conversion URL,xpath, //*[@id='txtUrl1']";
	public static final String pwnotification_webpush_selectdomain = "AnalyticDomain,pw,//span[@aria-label='Domain']//span[@class='k-input-value-text']";
	public static final String precomm_Analytics_conversionvalue = "Conversion value,xpath,//input[@name='conversionManualValue']";
	public static final String precomm_Analytics_clickcurrency = "currency,xpath,//span[@aria-label='Select currency type']";
	public static final String precomm_Analytics_clickdownloadTable = "Table,xpath,//i[contains(@class,'icon-rs-csv')]";

	// Pre Communication Page
	public static final String precommunicationpage = "Pre Communication Summary Page,xpath,//h1[text()='Communication analysis']";
	public static final String precommunicationpage_allaudiencevalue = "Pre Communication Summary Page,xpath,//h1[text()='Communication analyze']";
	public static final String precommunicationpage_channels = "Channel list,xpath,//ul[contains(@class,'rs-chart-tab')]//li";
	public static final String precommunicationpage_scrub_EditIcon = "Scrubbed Edit icon,xpath,//div[@class='tab-pane active']//h1[contains(@id,'fCapScrub')]//a";
	public static final String precommunicationpage_scrub = "Scrubbed,xpath,//*[text()='Scrubbed']";
	public static final String precommunicationpage_scrubbedCount = "Scrubbed Count,xpath,//*[text()='Scrubbed']/following-sibling::h1";
	public static final String precommunicationpage_scrub_popup = "Scrubbed Edit Popup,xpath,//div[contains(@id,'scrubbedDataONOFF')][@style='display: block;']//h2";
	public static final String precommunicationpage_scrub_popupClose = "Close icon icon,xpath,//div[contains(@id,'scrubbedDataONOFF')][@style='display: block;']//button";
	public static final String precommunicationpage_linkVerification_icon = "Link verification i icon,xpath,//div[@class='info-popup']";
	public static final String precommunicationpage_linkVerification = "Link verification,xpath,//span[contains(@class,'text-underline')]";
	public static final String precommunicationpage_linkInfopupop = "Info-popup,xpath,//div[contains(@class,'show-mini-chart')]";
	public static final String precommunicationpage_Smartlink = "Link,xpath,//div[contains(@class,'show-mini-chart')]//a";
	public static final String precommunicationpage_infopopup_close = "Close icon,xpath,//div[contains(@class,'show-mini-chart')]//i[@class='icon-sd-close-mini icon-sm cp close-btn']";
	public static final String precommunicationpage_approverStatus = "Approval status List,xpath,//h3[text()='Approval status']";
	public static final String precommunicationpage_approverStatus_header = " Approval header,xpath,//h3[text()='Approval status']/..//li";
	public static final String precommunicationpage_approverStatus_name = "Approver name,xpath,//h3[text()='Approval status']/..//li//following::div[@class='tab-pane active']//h5";
	public static final String precommunicationpage_approverStatus_status = "approval status,xpath,//h3[text()='Approval status']/..//li//following::div[@class='tab-pane active']//div[contains(@class,'col-sm-4')]";
	public static final String precommunicationpage_approverStatus_listname = "List approval status,xpath,//h3[text()='Approval status']/..//li//following::div[@class='tab-pane active']//h3";

	// Sms
	public static final String precommunicationpage_uniquesmsaudience = "SMS Precommunication Unique Audience,xpath,//*[@id='SMSfCapUniAudVal']";
	public static final String precommunicationpage_smsscrubinprogress = "SMS Scrubbing inprogress,xpath, //*[@id='SMSfCapScrubVal']";
	public static final String precommunicationpage_smsfrequencycap = "Precommunication Sms FrequencyCap,xpath, //*[@id='SMSfCapVal']";
	public static final String precommunicationpage_smsscrubbylimitcap = "SMS Precommunication Scrubbed by limitcap,xpath,//*[@id='SMSMiniListVal']";
	public static final String precommunicationpage_smspotentialtargetaudience = "Sms Precommunication Potential audience count,xpath, //*[@id='SMSh1PotenRecipients']";
	public static final String precommunicationpage_numberofsms = "No. of SMS,xpath, //h4[contains(.,'No. of SMS')]//../h1";
	public static final String precommunicationpage_smsispersonaenabled = "Personasation Enabled,xpath, //h4[contains(.,'Personalization')]//../h1";
	public static final String precommunicationpage_smsunicode = "uniCode,xpath, //h4[contains(.,'Unicode')]//../h1";

	// Email
	public static final String precommunicationpage_uniqueemailaudience = "Email Precommunication Unique Audience,xpath,//*[@id='EmailfCapUniAudVal']";
	public static final String precommunicationpage_emailscrubinprogress = "Email Scrubbing inprogress,xpath, //*[@id='EmailfCapScrubVal']";
	public static final String precommunicationpage_emailfrequencycap = "Precommunication Email FrequencyCap,xpath, //*[@id='EmailfCapVal']";
	public static final String precommunicationpage_emailscrubbylimitcap = "Email Precommunication Scrubbed by limitcap,xpath,//*[@id='//*[@id='EmailMiniListVal']";
	public static final String precommunicationpage_emailpotentialtargetaudience = "Email Precommunication Potential audience count,xpath, //*[@id='Emailh1PotenRecipients']";
	public static final String precommunicationpage_emailsublinespamscore = "Precommunication Email subLine,xpath, //h4[contains(.,'Subject line spam score')]//../h1";
	public static final String precommunicationpage_emailimagetotetratio = "Precommunication Email imagetTextRatio,xpath, //h4[contains(.,'Image to text ratio')]//../h1";
	public static final String precommunicationpage_emailfilesize = "Precommunication Email file Weight,xpath, //h4[contains(.,'File weight')]//../h1";

	// Web
	public static final String precommunicationpage_uniquewebaudience = "Webpush Precommunication Unique Audience,xpath,//*[@id='WebNotificationfCapUniAudVal']";
	public static final String precommunicationpage_webscrubinprogress = "Webpush Scrubbing inprogress,xpath, //*[@id='WebNotificationfCapScrubVal']";
	public static final String precommunicationpage_webfrequencycap = "Webpush Precommunication FrequencyCap,xpath, //*[@id='WebNotificationfCapVal']";
	public static final String precommunicationpage_webscrubbylimitcap = "Webpush Precommunication Scrubbed by limitcap,xpath,//*[@id='WebNotificationMiniListVal']";
	public static final String precommunicationpage_webpotentialtargetaudience = "Webpush Precommunication Potential targetaudience,xpath, //*[@id='WebNotificationh1PotenRecipients']";
	public static final String precommunicationpage_webpushcontentlength = "Precommunication webpush Content length,xpath, //h4[contains(.,'Content Length')]//../h1";
	public static final String precommunicationpage_webpushpersona = "Precommunication webpush Presonalization Enabled,xpath, //h4[contains(.,'Personalization')]//../h1";
	public static final String precommunicationpage_webpushtriggertype = "Precommunication Webpush Trigger type,xpath, //h4[contains(.,'Trigger Type')]//../h1";

	// Mobile
	public static final String precommunicationpage_uniquemobileaudience = "Mobilepush Precommunication Unique Audience,xpath,//*[@id='MobilePushNotificationfCapUniAudVal']";
	public static final String precommunicationpage_mobilescrubinprogress = "Mobilepush Scrubbing inprogress,xpath, //*[@id='MobilePushNotificationfCapScrubVal']";
	public static final String precommunicationpage_mobilefrequencycap = "Mobilepush Precommunication FrequencyCap,xpath, //*[@id='MobilePushNotificationfCapVal']";
	public static final String precommunicationpage_mobilescrubbylimitcap = "Mobilepush Precommunication Scrubbed by limitcap,xpath,//*[@id='MobilePushNotificationMiniListVal']";
	public static final String precommunicationpage_mobilepotentialtargetaudience = "Mobilepush Precommunication Potential targetaudience,xpath, //*[@id='MobilePushNotificationh1PotenRecipients']";
	public static final String precommunicationpage_mobilepushcontentlength = "Precommunication mobilepush Content length,xpath, //h4[contains(.,'Content Length')]//../h1";
	public static final String precommunicationpage_mobilepushpersona = "Precommunication mobilepush Presonalization Enabled,xpath, //h4[contains(.,'Personalization')]//../h1";
	public static final String precommunicationpage_mobilepushimageattached = "Precommunication mobilepush Image attached,xpath, //h4[contains(.,'Image Attached')]//../h1";

	// Vms
	public static final String vmspage_vmsicon = "vms icon,xpath, //*[@id='liVMSChannel']/a/i";
	public static final String vmspage_vmsproviderlistbox = "vms provider listbox,xpath, //*[@aria-activedescendant='ClientVMSSMSSettingId_option_selected']";
	public static final String vmspage_selectvmsprovider = "vms provider list,xpath, //*[@id='ClientVMSSMSSettingId_listbox']/li";
	public static final String vmspage_vmsrecipientlistbox = "vms recipient listbox,xpath, //*[@aria-owns='VMSCampaignModel_SelectedMobileRecipients_taglist VMSCampaignModel_SelectedMobileRecipients_listbox']";
	public static final String vmspage_selectvmsrecipient = "vms recipient list,xpath, //*[@id='VMSCampaignModel_SelectedMobileRecipients_listbox']/li";
	public static final String vmspage_texttospeechicon = "vms texttospeech icon,xpath, //*[@class='vms-text']";
	public static final String vmspage_vmsaudioicon = "vms audio icon,xpath, //a[@class='vms-audio']";
	public static final String vmspage_vmsaudiofileupload = "vms audio file,xpath, //*[@id='vmsfileuploadHTML']";
	public static final String vmspage_vmsaudiodeleteicon = "vms audio delete icon,xpath, //*[@id='avmsaudio']/i";
	public static final String vmspage_vmstemplatename = "vms template listbox,xpath, //*[@aria-owns='VMSTemplateList_listbox']";
	public static final String vmspage_vmstemplatenamelist = "vms template list,xpath, //*[@id='VMSTemplateList_listbox']/li";
	public static final String vmspage_vmstemplatelanguage = "vms template language,xpath, //*[@aria-owns='VMSLanguageID_listbox']";
	public static final String vmspage_vmstemplatelanguagelist = "vms template language,xpath,//*[@id='VMSLanguageID_listbox']/li";
	public static final String vmspage_vmssubject_personalizationeditor = "vms personalization editor,xpath, //*[@id='ulVMSElements']";
	public static final String vmspage_vmssubject_personalizeicon = "vms personalize icon,xpath, //*[@id='ulVMSElements']//li[1]//a/i";
	public static final String vmspage_vmssubject_personalizelist = "vms personalize list,xpath,//*[@id='ulVMSElements']//li[@data-original-title='Personalize']//li";
	public static final String vmspage_select_vmssubject = "vms subject,xpath, //*[@id='VMSContent']";
	public static final String vmspage_numberofrepeattexttospeech = "vms no of repeat text to speech,xpath, //*[@id='lblretry']//following::div//span[@aria-owns='selecVoiceRepeatCount_listbox']";
	public static final String vmspage_select_numberoftexttospeechrepeatlist = "vms no of repeat,xpath, //*[@id='selecVoiceRepeatCount_listbox']//li";
	public static final String vmspage_numberofrepeataudio = "vms no of repeat audio,xpath, //*[@id='lblretry']//following::div//span[@aria-owns='selectRetryValue_listbox']";
	public static final String vmspage_select_numberofrepeataudio = "vms no of repeat,xpath, //*[@id='selectRetryValue_listbox']//li";
	public static final String vmspage_select_vmsscheduledate = "vms schedule date,xpath, //span[@aria-controls='VMSMoblieScheduleDate_dateview']/i";
	public static final String vmspage_select_vmsscheduletime = "vms schedule time,xpath, (//span[contains(@class,'k-i-clock')])[position()>=7 and position()<8]";
	public static final String vmspage_vmsscheduletime_timelistfirstvalue = "vms time first value,xpath, //*[@id='VMSMoblieScheduleDate_timeview']/li[1]";
	public static final String vmspage_vmstestmessage = "Test message,id,campaign-test-mail-sent-msg";
	public static final String vmspage_select_vmstimezoneicon = "vms timezone icon,xpath, //a[@class='no-hover VMSedit-timezone']/i";
	public static final String vmspage_selectlist_vmstimezonelist = "vms timezone list,xpath, //span[@aria-owns='vmsmobileTimeZone_listbox']";
	public static final String vmspage_selectvmstimezone = "vms timezone listbox,xpath, //*[@id='vmsmobileTimeZone_listbox']/li";
	public static final String vmspage_savevmscommunication = "save vms comm,id,smsCampaignSave";
	public static final String vmspage_testvmstextbox = "Test vms text box,id,smsVMSTestMobileNumber";
	public static final String vmspage_clicktestvmssendbutton = "Test vms send button,xpath, //*[@id='VMSsettingValid']";
	public static final String vmspage_sendtestpopup = "Test vms popup,id,campaign-test-mail-sent-msg";

	public static final String precommunicationpage_uniquevmsaudience = "VMS TextSpeech Precommunication Unique Audience,xpath,//*[@id='VMSfCapUniAudVal']";
	public static final String precommunicationpage_vmsscrubinprogress = "VMS TextSpeech Scrubbing inprogress,xpath, //*[@id='VMSfCapScrubVal']";
	public static final String precommunicationpage_vmsfrequencycap = "VMS TextSpeech Precommunication FrequencyCap,xpath, //*[@id='VMSfCapVal']";
	public static final String precommunicationpage_vmsscrubbylimitcap = "VMS TextSpeech Precommunication Scrubbed by limitcap,xpath,//*[@id='VMSMiniListVal']";
	public static final String precommunicationpage_vmspotentialtargetaudience = "VMS TextSpeech Precommunication Potential targetaudience,xpath, //*[@id='VMSh1PotenRecipients']";
	public static final String precommunicationpage_vmsfilesize = "Precommunication VMS File weight,xpath, //h4[contains(.,'File weight')]//../h1";
	public static final String precommunicationpage_vmsfiletype = "Precommunication VMS File Type,xpath, //h4[contains(.,'File type')]//../h1";
	public static final String precommunicationpage_vmsretrycount = "Precommunication VMS Retry Count,xpath, //h4[contains(.,'Retry count')]//../h1";

	// WhatsApp
	public static final String precommunicationpage_uniquewhatsappaudience = "WhatsApp Precommunication Unique Audience,xpath,//*[@id='WhatsAppfCapUniAudVal']";
	public static final String precommunicationpage_whatsappscrubinprogress = "WhatsApp Scrubbing inprogress,xpath, //*[@id='WhatsAppfCapScrubVal']";
	public static final String precommunicationpage_whatsappfrequencycap = "WhatsApp Precommunication FrequencyCap,xpath, //*[@id='WhatsAppfCapVal']";
	public static final String precommunicationpage_whatsappscrubbylimitcap = "WhatsApp Precommunication Scrubbed by limitcap,xpath,//*[@id='WhatsAppMiniListVal']";
	public static final String precommunicationpage_whatsapppotentialtargetaudience = "WhatsApp Precommunication Potential targetaudience,xpath, //*[@id='WhatsApph1PotenRecipients']";
	public static final String precommunicationpage_whatsappcontentlength = "Precommunication WhatsApp Content length,xpath, //h4[contains(.,'Content Length')]//../h1";
	public static final String precommunicationpage_whatsapppersonalization = "Precommunication WhatsApp Presonalization Enabled,xpath, //h4[contains(.,'Personalization')]//../h1";
	public static final String precommunicationpage_whatsapplanguage = "Precommunication WhatsApp Language,xpath, //h4[contains(.,'Language')]//../h1";

	// COMMUNICATION WEB PUSH
	public static final String pwnotification_webpush_sendwebpushto = "Web push domain,pw,//span[@aria-label='Domain']//span[@class='k-input-value-text']";

	public static final String notification_webpush_sendwebpushto = "Web push domain,xpath,//span[@aria-label='Domain']//span[@class='k-input-value-text']";
	public static final String notification_webpush_selectwebpush = "Web domain listbox,xpath, //*[@id='selectSPT-list']/ul/li";
	public static final String notification_webpush_selectdomainurl = "Web domain url,xpath, //span[@aria-owns='webPushInput_listbox']";
	public static final String notification_webpush_tempclick = "Web domain url listbox,xpath, //*[@id='webPushInput_listbox']/li";
	public static final String notificaiton_webpush_enterdomainurl = "Domain url value,xpath, //*[@id='newWebDomailurl']";
	public static final String notification_webpush_webpushAlltargetlist = "Audience all radio button,xpath,//input[@id='Webroi']";
	public static final String notification_webpush_selectwebpushtargetlist = "Web Audience,xpath, //*[@id='WebNotificationRecipientsList']/..//div/input";
	public static final String notification_webpush_enterrecipientlist = "Audience list,xpath, //*[@id='WebNotificationRecipientsList_listbox']/li";
	public static final String notification_webpush_deliverytype = "Web delivery type,xpath,//span[@aria-label='Delivery type']//span[@class='k-input-value-text']";
	public static final String notification_webpush_enterdeliverytype = "Web delivery type,xpath, //*[@id='WebDeliveryTypeID-list']/ul/li";
	public static final String notification_webpush_clickinboxclassification = "Web inbox classification,xpath,//span[@aria-label='Inbox classification']//span[@class='k-input-value-text']";
	public static final String notification_webpush_selectinboxclassificationtype = "Web inbox classification listbox,xpath, //*[@id='WebInboxClassificationID_listbox']/li";
	public static final String notification_webpush_securemessageonoff = "Secure msg icon,xpath, //a[@id='btnSecureWeb']/i";
	public static final String notification_webpush_selectlayoutposition = "layout position,xpath, //span[@aria-owns='web-select-layout_listbox']";
	public static final String notification_webpush_selectlayoutvalues = "layout listbox,xpath, //ul[@id='web-select-layout_listbox']//li";
	public static final String notification_webpush_layoutnotificationposition = "notification position,xpath, //span[@aria-owns='web-select-position_listbox']";
	public static final String notification_webpush_layoutnotificationpositionvalues = "position listbox,xpath, //*[@id='web-select-position_listbox']/li";
	public static final String notification_webpush_selectinteractivityswitch = "Web interactivity switch,xpath, //label[@for='chkWebHourspush']";
	public static final String notification_webpush_selectinteractivitybutton = "Web interactivity,xpath, //span[@aria-activedescendant='webinteractiveBtnOn_option_selected']";
	public static final String notification_webpush_selectinteractivitybuttonlist = "Web interactivity listbox,xpath, //*[@id='webinteractiveBtnOn_listbox']/li";
	public static final String notification_webpush_selectinteractivityaction = "Web interactivity action,xpath, //span[@aria-activedescendant='webinteractiveBtnSelect_option_selected']";
	public static final String notification_webpush_selectinteractivityactionlist = "Web interactivity action listbox,xpath, //*[@id='webinteractiveBtnSelect_listbox']/li";
	public static final String notification_webpush_expiryswitch = "Web expiry switch,xpath, //label[@for='chkExpiryWebpush']";
	public static final String notificaiton_webpush_selectexpirybutton = "Web expiry,xpath, //span[@aria-activedescendant='expiryWebSchedule_option_selected']";
	public static final String notification_webpush_selectexpirybuttonlist = "Web expiry listbox,xpath, //*[@id='expiryWebSchedule_listbox']/li";
	public static final String notification_webpush_enterexpiretime = "Web expiry time,xpath, //input[@id='txtWebExpiryhours']";
	public static final String notification_webpush_selectcontent = "Web push content,xpath,//li[.='Create']";
	public static final String notification_webpush_selecttitletextpersonalization = "Web push title persona,xpath,(//i[contains(@class,'user-question-mark')])[1]";
	public static final String notification_webpush_selecttitletextpersonalizationlist = ",xpath,//div[@class='css-scrollbar']//div";
	public static final String pwnotification_webpush_selecttitletextpersonalizationlist = ",pw,//div[@class='css-scrollbar']//div";
	public static final String pwnotification_webpush_deliverytype = "Web delivery type,pw,//span[@aria-label='Delivery type']//span[@class='k-input-value-text']";
	public static final String pwnotification_webpush_selectcontent = "Web push content,pw,//li[.='Create']";
	public static final String notification_webpush_Preview = "Browser preview,xpath,//div[contains(@class,'content-section')]";

	public static final String pwnotification_webpush_entertitle = "Web title text,pw,//input[@name='title.text']";
	public static final String pwnotification_webpush_webcontent = "Web content,pw,//textarea[@id='editorText']";

	public static final String notification_webpush_entertitle = "Web title text,xpath,//input[@name='title.text']";
	public static final String notification_webpush_selectpersonalization = "Web body text persona,xpath,//i[contains(@class,'icon-rs-editor-personalize')]";
	public static final String notification_webpush_personalizationlist = ",xpath, //div[@id='webrichTextcontentPanel']//*[@id='ulWebElements']/li[1]/div/ul/li";
	public static final String notification_webpush_webcontent = "Web content,xpath,//textarea[@id='editorText']";
	public static final String notification_webpush_Enterwebpushcontent = "Web body text content,xpath, //*[@id='divTitletext']//div[@placeholder='Enter title']";
	public static final String notification_webpush_alerttitletextpersonalization = "Web alert title persona,xpath, (//div[@id='DescriptionPersonalize']/a)[3]/i";// div[@id='DescriptionPersonalize']/a/i";
	public static final String notification_webpush_alerttitletextpersonalizationlist = ",xpath, //*[@id='DescriptionPersonalize']/ul/li";
	public static final String notification_webpush_enteralerttitle = "Web alert title text,xpath, //*[@id='divDescriptionPersonalizeWP']/..//div[@placeholder='Enter title']";
	public static final String notification_webpush_enteralertshortdescription = "Web alert short description,xpath, // *[@id='divDescriptionPersonalizeWP']/..//div[@placeholder='Enter description']";
	public static final String notification_webpush_enterscheduledate = "Web scheduledate,xpath, //*[@aria-controls='WebScheduleDate_dateview']/i";
	public static final String notification_webpush_entercarouselscheduledate = "Carousel WebScheduleDate,xpath,//span[@aria-controls='WebScheduleDateCRSL_dateview']/i";
	public static final String notification_push_webtimezoneicon = "Web timezone icon,xpath, //*[@id='idselectedWebTimeZoneName']/..//i";
	public static final String notification_webpush_webtimezonelist = "Web timezone dropdown,xpath, //span[@aria-owns='WebNotifyTimeZone_listbox']";
	public static final String notification_webpush_selectwebtimezonelist = "Web timezone listbox,xpath, //*[@id='WebNotifyTimeZone_listbox']/li";
	public static final String notification_push_webcarouseltimezoneicon = "Web timezone icon,xpath, //*[@id='idselectedWebTimeZoneNameCRSL']/..//i";
	public static final String notification_webpush_webcarouseltimezonelist = "Web timezone dropdown,xpath, //span[@aria-owns='WebNotifyTimeZoneCRSL_listbox']";
	public static final String notification_webpush_selectwebcarouseltimezonelist = "Web timezone listbox,xpath, //*[@id='WebNotifyTimeZoneCRSL_listbox']/li";
	// time zone error web
	public static final String notification_webpush_dateTimeErr = "Date time error,id, errmsgWebValidPastDateTime";
	public static final String notification_webpush_selectinteractivityONOFF = "Web interactivity switch,xpath, //label[@for='chkWebHourspush']/../..";
	public static final String notificaiton_webpush_customactionIcon = "Custom action setting icon,xpath,//div[@id='webinteractiveBtn']/..//a[contains(@onclick,'LoadWebIntCustParameter')]";
	public static final String notificaiton_webpush_customButtonText = "Custom button text field,xpath,//div[@id='resmodal-createWebCustomButton']//input[@id='wptext']";
	public static final String notificaiton_webpush_customBehaviour = "Custom button behaviour,xpath,//div[@id='resmodal-createWebCustomButton']//span[@aria-owns='wpvalueAction_listbox']";
	public static final String notificaiton_webpush_customBehaviourList = "Custom button on click behaviour list,xpath,//ul[@id='wpvalueAction_listbox']/li";
	public static final String notificaiton_webpush_customactionBehaviourLink = "Custom action behaviour link,xpath,//*[@id='newWebCustomLink']";
	public static final String notificaiton_webpush_customactionBehaviourType = "Custom action behaviour type,xpath,//div[@id='resmodal-createWebCustomButton']//span[@aria-owns='wpActionType_listbox']";
	public static final String notificaiton_webpush_customactionBehaviourTypeList = "Custom action behaviour type list,xpath,//*[@id='wpActionType_listbox']/li";
	public static final String notification_webpush_custombuttonpopupsave = "Create custom button save,xpath,//input[@onclick='SaveWebIntCustAction()']";
	public static final String notification_webpush_expiryswitchONOFF = "Web expiry switch,xpath,//label[@for='chkExpiryWebpush']/../..";
	public static final String notification_webpush_carouselexpiryswitch = "carousel expiry switch,xpath, //label[@for='chkExpiryWebpushCRSL']";
	public static final String notification_webpush_carouselexpiryswitchOnOff = "carousel expiry switch OnOff,xpath, //label[@for='chkExpiryWebpushCRSL']/../..";
	public static final String notification_webpush_carouselexpiry = "Web carousel expiry,xpath, //span[@aria-activedescendant='expiryWebScheduleCRSL_option_selected']";
	public static final String notification_webpush_carouselexpirylist = "Carousel expiry list,xpath, //*[@id='expiryWebScheduleCRSL_listbox']/li";
	public static final String notification_webpush_carouselexpirytime = "carousel expiry time,xpath, //input[@id='txtWebExpiryhoursCRSL']";

	public static final String notification_webpush_recipientaddicon = "recipient add icon,xpath, //*[@id='spnNewNotifySegment1']/a/i";
	public static final String notification_webmobile_notificationcommunicationnext = "notification next page,id,NotificationCampaignNext";
	public static final String notification_webmobile_domainurlconfirmimg = "domainurl confirm,xpath,//*[@id='otpCheckTrue1']";
	public static final String notification_webmobile_contentpreview = "content title preview,xpath, //*[@id='divWebnotifyImage']//div[@class='richCnt']";
	public static final String notification_webmobile_contenttitletextpreview = "content title preview,xpath, //*[@id='divWebnotifyImage']//div[@class='richCnt']/h4";
	public static final String notification_webmobile_contentbodytextpreview = "content title body preview,xpath, //*[@id='divWebnotifyImage']//div[@class='richCnt']/p";
	public static final String notification_webpush_webclickimport = "web click import,xpath, //a[@id='WebacnImportUrl']";
	public static final String notification_webpush_webcontentrefresh = "content refresh,xpath, //*[@id='WebaContentTypeRefresh']";
	public static final String notification_webpush_webcontentrefreshok = "refresh ok,xpath, //*[@id='campaign-refresh-webtype-Confirmation']//input[@value='OK']";
	public static final String notification_webpush_webimportzip = "web import zip,xpath, //*[@id='webfileuploadHTML']";
	public static final String notification_webpush_alertswitch = "Web expiry switch,xpath, //label[@for='chkWebAlert']";
	public static final String notification_webpush_alertswitchONOFF = "Web expiry,xpath, //label[@for='chkWebAlert']/../..";
	public static final String notification_webpush_testmailto = "test cmmunication dropdown,xpath,//span[@aria-label='Select/Enter email address']//span[contains(@class,'k-input-inner')]";
	public static final String notification_webpush_testmailselectDropdown = "test communication dropdown list,xpath,//ul[@id='TestWebCampaignEmailAddres_listbox']/li";
	public static final String notification_webpush_testmailenter = "communication email,xpath,//input[@name='approvalList.testEmail']";
	public static final String notification_webpush_testcommSent = "communication email sent,xpath,//button[normalize-space()='Send']";
	public static final String notification_webpush_imgcontenticon = "Image content icon,xpath,//i[@class='icon-rs-editor-image-medium icon-md']";
	public static final String notification_webpush_selectimgurl = "Image URL tab,xpath,//a[normalize-space()='Image URL']";
	public static final String notification_webpush_imgurlpopup = "Image url popup,xpath,//input[contains(@name,'previewImage')]";
	public static final String notification_webpush_imgurlsave = "Image url save,xpath,//button[normalize-space()='Upload']";
	public static final String notification_webpush_imgurl_ErrMSg = "Max file size error msg,id,errWebimageSize";
	public static final String notification_webpush_imgurl_Cancel = "Cancel button,xpath,//div[contains(@id,'WebCustomImageURL')]//input[@name='cancel']";
	public static final String pwnotification_webpush_imgcontenticon = "Image content icon,pw,//i[@class='icon-rs-image-medium icon-md']";
	public static final String pwnotification_webpush_selectimgurl = "Image URL tab,pw,//a[normalize-space()='Image URL']";
	public static final String pwnotification_webpush_imgurlpopup = "Image url popup,pw,//input[contains(@name,'previewImage')]";
	public static final String pwnotification_webpush_imgurlsave = "Image url save,pw,//button[normalize-space()='Upload']";

	// COMMUNICATION MOBILE PUSH
	public static final String notification_mobpush_TabSelect = "Mobilepush tab,xpath,//i[@class='icon-rs-mobile-notification-large icon-lg color-primary-blue']";
	public static final String pwnotification_mobpush_TabSelect = "Mobilepush tab,pw,//i[@class='icon-rs-mobile-notification-large icon-lg color-primary-blue']";

	public static final String notification_mobpush_selectinteractivity = "Mobile interactivity switch,xpath, //label[@for='chkHourspush']";
	public static final String notification_mobpush_selectinteractivityONOFF = "Mobile interactivity switch,xpath, //div[@class='row'][contains(.,'Interactivity')]//span[contains(@class,'k-switch k-switch-md')]";
	public static final String notificaiton_mobpush_selectinteractivitybutton = "Mobile interactivity,xpath, //span[@aria-label='Button type']";
	// div[@class='row'][contains(.,'Interactivity')]//div[@class='rs-builder-colorpicker-container undefined']//i if needed to check font icons
	// validation
	public static final String notificaiton_mobpush_selectinteractivitybuttonlist = "Mobile interactivity listbox,xpath, //*[@id='interactiveBtnOn_listbox']/li";
	public static final String notificaiton_mobpush_selectinteractivityaction = "Mobile interactivity action,xpath, //span[@aria-owns='interactiveBtnSelect_listbox']";
	public static final String notification_mobpush_selectinteractivityactionlist = "Mobile interactivity action listbox,xpath, //*[@id='interactiveBtnSelect_listbox']/li";
	public static final String notification_mobpush_selectinteractivityactionlist1 = "Mobile interactivity action listbox,xpath, (//*[@id='interactiveBtnSelect_listbox'])[2]/li";

	public static final String notificaiton_mobpush_setFrequency = "Mobile may be later set frequency,xpath,//span[@aria-label='Select frequency time']";
	public static final String notificaiton_mobpush_setFrequencyList = "Set frequency list,xpath,//ul[@id='PushReschedule_listbox']/li";
	public static final String notificaiton_mobpush_setFrequencyHours = "Set frequency hours,xpath,//input[@name='rating']";
	public static final String notificaiton_mobpush_customactionIcon = "Custom action setting icon,xpath,//input[@name='buttonText.0.customText']";

	public static final String notificaiton_mobpush_customButtonText = "Custom button text field,xpath,//div[@id='resmodal-createCustomButton']//input[@id='mptext']";
	public static final String notificaiton_mobpush_customBehaviour = "Custom button behaviour,xpath,//textarea[@id='buttonText.0.link']";
	public static final String notificaiton_mobpush_customBehaviourList = "Custom button on click behaviour list,xpath,//ul[@id='mpvalueAction_listbox']/li";
	public static final String notificaiton_mobpush_customactionBehaviourLink = "Custom action behaviour link,xpath,//*[@id='newCustomLink']";
	public static final String notificaiton_mobpush_customactionBehaviourType = "Custom action behaviour type,xpath,//div[@id='resmodal-createCustomButton']//span[@aria-owns='mpActionType_listbox']";
	public static final String notificaiton_mobpush_customactionBehaviourTypeList = "Custom action behaviour type list,xpath,//*[@id='mpActionType_listbox']/li";
	public static final String notification_mobpush_custombuttonpopupsave = "Create custom button save,xpath,//input[@onclick='SaveIntCustAction()']";
	public static final String notification_mobpush_hashtag = "Mobile hashtag,xpath,//input[@placeholder='Enter Hashtag']";

	public static final String notification_mobpush_expiryswitch = "Mobile expiry switch,xpath,//label[@for='chkExpirypush']";
	public static final String notification_mobpush_expiryswitchcrsl = "Mobile expiry switch,xpath,//label[@for='chkExpirypushCRSL']";
	public static final String notification_mobpush_expiryswitchONOFF = "Mobile expiry switch,xpath,//div[@class='row'][contains(.,'Expiry')]//span[contains(@class,'k-switch k-switch-md')]";
	public static final String notification_mobpush_expiryswitchcrslONOFF = "Mobile expiry switch crsl,xpath,//label[@for='chkExpirypushCRSL']/../..";
	public static final String notification_mobpush_selectexpirybutton = "Mobile expiry,xpath, //span[@aria-label='Expires in']";
	public static final String notification_mobpush_selectexpirycrslbutton = "Mobile expiry,xpath, //span[@aria-owns='expiryScheduleCRSL_listbox']";
	public static final String notification_mobpush_selectexpirybuttonlist = "Mobile expiry listbox,xpath, //*[@id='expirySchedule_listbox']/li";
	public static final String notification_mobpush_selectexpirybuttonlistcrsl = "Mobile expiry listbox,xpath, //*[@id='expiryScheduleCRSL_listbox']/li";
	public static final String notification_mobpush_enterexpiretime = "Mobile expiry time,xpath, //input[@name='expiryValue']";
	public static final String notification_mobpush_enterexpiretimecrsl = "Mobile expiry time,xpath, //input[@id='txtExpiryhoursCRSL']";
	public static final String notification_push_mobiletimezoneicon = "Mobile timezone icon,xpath, //div[@class='mobileselectTimeZone']//i";
	public static final String notification_push_mobiletimezoneiconCarousel = "Mobile timezone icon,xpath, //span[@id='idselectedPushTimeZoneNameCRSL']/../a";
	public static final String notification_push_mobiletimezonelist = "Mobile timezone dropdown,xpath, //span[@aria-owns='PushTimeZone_listbox']";
	public static final String notification_push_mobiletimezoneCarousel = "Mobile timezone dropdown,xpath, //span[@aria-owns='PushTimeZoneCRSL_listbox']";
	public static final String notification_push_selectmobiletimezonelist = "Mobile timezone listbox,xpath, //*[@id='PushTimeZone_listbox']/li";
	public static final String notification_mobpush_addmobileapp = "MobileApp add button,id,rs_data_circle_plus_fill_edge";
	public static final String notificaiton_mobpush_selectmobileplatform = "Mobile platform dropdown,xpath,//label[.=' Mobile platform']//following::span[@class='k-input-value-text']";
	public static final String notificaiton_mobpush_entermobileplatform = "Mobile platform listbox,xpath, //*[@id='mobilePlatform2_listbox']/li";
	public static final String notification_mobpush_selectmobileapptype = "Mobile app type,xpath,//label[.='Mobile app']//following::span[@class='k-input-value-text']";
	public static final String notification_mobpush_entermobileapptype = "Mobile app type listbox,xpath, //*[@id='selectMobileApp2_listbox']/li";
	public static final String notification_mobpush_deferdeeplinkswitch = "Mobile deeplink switch,xpath, //label[@for='deferdeeplinking2']";
	public static final String notification_mobpush_deferdeeplinkswitchONOFF = "Mobile deeplink switch status,xpath,//span[@class='k-switch k-switch-md k-rounded-full k-switch-on']";
	public static final String notification_mobpush_dateTimeErr = "Date time error,id, errmsgPushValidPastDateTimeCRSL";
	public static final String notification_mobpush_selectdeferdeeplink = "app screen,xpath, //span[@aria-label='App screen']";
	public static final String notification_mobpush_enterdeferdeeplink = "app screen list,xpath, //ul[@id='deferdeeplinkingValue2_listbox' and @aria-hidden='false']/li";
	public static final String notification_mobpush_enterdeferdeeplink1 = "app screen list,xpath, (//ul[@id='deferdeeplinkingValue2_listbox'])[6]/li";
	public static final String notification_mobpush_selectdeeplinkoption = "Mobile Activity 2,xpath, //span[@aria-owns='subScreenOptionDiv2_listbox']";
	public static final String notification_mobpush_enterdeeplinkoption = "Mobile Activity 2 listbox,xpath, //*[@id='subScreenOptionDiv2_listbox']/li";
	public static final String notification_mobpush_selecttargetlistAll = "Mobile recipient all,xpath, //input[@class='radio calculate-roiPush']";
	public static final String notification_mobpush_pushtype = "Mobile push type,xpath,//span[@aria-label='Push type']";
	public static final String pwnotification_mobpush_enterdeeplinkoption = "Mobile Activity 2 listbox,pw, //*[@id='subScreenOptionDiv2_listbox']/li";
	public static final String pwnotification_mobpush_addmobileapp = "MobileApp add button,pw,#rs_data_circle_plus_fill_edge";
	public static final String pwnotificaiton_mobpush_selectmobileplatform = "Mobile platform dropdown,pw,//label[.=' Mobile platform']//following::span[@class='k-input-value-text']";
	public static final String pwnotification_mobpush_selectmobileapptype = "Mobile app type,pw,//label[.='Mobile app']//following::span[@class='k-input-value-text']";
	public static final String pwnotification_mobpush_dateTimeErr = "Date time error,pw,#errmsgPushValidPastDateTimeCRSL";
	public static final String pwnotification_mobpush_deferdeeplinkswitchONOFF = "Mobile deeplink switch status,pw,//span[@class='k-switch k-switch-md k-rounded-full k-switch-on']";
	public static final String pwnotification_mobpush_deferdeeplinkswitch = "Mobile deeplink switch,pw, //label[@for='deferdeeplinking2']";
	public static final String pwnotification_mobpush_selectdeferdeeplink = "app screen,pw,//span[@aria-label='App screen']";
	public static final String pwnotification_mobpush_enterdeferdeeplink1 = "app screen list,pw, (//ul[@id='deferdeeplinkingValue2_listbox'])[6]/li";
	public static final String pwnotification_mobpush_selectdeeplinkoption = "Mobile Activity 2,pw, //span[@aria-owns='subScreenOptionDiv2_listbox']";

	public static final String pwnotification_mobpush_pushtype = "Mobile push type,pw,//span[@aria-label='Push type']";
	public static final String pwnotification_mobpush_inboxClassification = "Inbox classification,pw,//span[@aria-label='Inbox classification']";
	public static final String pwnotification_mobpush_layoutposition = "Mobilepush layoutposition,pw,//span[@aria-owns='select-position_listbox']";
	public static final String pwnotification_mobpush_layoutpositionlist = "Mobilepush layoutposition list,pw,//ul[@id='select-position_listbox']/li";

	public static final String notification_mobpush_pushtypelist = "Mobile push type listbox,xpath, //*[@id='select-pageMobleapp_listbox']/li";
	public static final String notification_mobpush_inboxClassification = "Inbox classification,xpath,//span[@aria-label='Inbox classification']";
	public static final String notification_mobpush_inboxClassificationlist = "Inbox classification list,xpath,//ul[@id='MobInboxClassificationID_listbox']/li";
	public static final String notification_mobpush_inboxClassificationlist1 = "Inbox classification list,xpath,(//ul[@id='MobInboxClassificationID_listbox'])[1]/li";
	public static final String notification_mobpush_secureMSGONOFF = "Secure message ON/OFF,xpath,(//a[@id='btnSecureMob'])[1]";
	public static final String notification_mobpush_layout = "Mobilepush layout,xpath,//span[@aria-label='Layout']";
	public static final String notification_mobpush_layoutlist = "Mobilepush layout list,xpath,(//ul[@id='select-layout_listbox'])[1]/li";
	public static final String notification_mobpush_layoutposition = "Mobilepush layoutposition,xpath,//span[@aria-owns='select-position_listbox']";
	public static final String notification_mobpush_layoutpositionlist = "Mobilepush layoutposition list,xpath,//ul[@id='select-position_listbox']/li";
	public static final String notification_mobpush_AlertpushTypeText = "Mobile push text type icon,xpath, //li//span[.='PLACE_HOLDER']";
	public static final String notification_mobpush_entertitletext = "Mobile title text,xpath,  //input[@name='title.text']";
	public static final String notification_mobpush_entertitlePersonliseIcon = "Mobile title personalize icon,xpath,//div[@id='SubjectPersonalize']";
	public static final String notification_mobpush_entertitlePersonliseList = "Mobile title personalize list,xpath, //*[@id='divSubjectPersonalizeMP']//ul[contains(@class,'subjectpersonalFieldsMP')]/li";
	public static final String notification_mobpush_enterContentPersonliseIcon = "Mobile content personalize icon,xpath,(//div[contains(@class,'mpdivEditorText')])[1]//ul[contains(@id,'ulPushElements')]//a[@data-original-title='Personalize']";
	public static final String notification_mobpush_enterContentPersonliseList = "Mobile content personalize list,xpath,(//div[contains(@class,'mpdivEditorText')])[1]//ul[contains(@class,'personalFieldsPush')]/li";
	public static final String notification_mobpush_entersubtitle = "Mobile subtitle text,xpath, //div[@placeholder='Enter subtitle text']";
	public static final String notification_mobpush_bodyMessage = "Mobile bodytext,xpath,//div[@class='k-content ProseMirror']";
	public static final String notification_mobpush_smartlinkIcon = "Mobile smartlink icon,xpath,(//*[@id='ulPushElements']//a[contains(@data-original-title,'Smart link')])[1]";
	public static final String notification_mobpush_smartlinkList = "Mobile smart link list,xpath, (//*[@id='ulPushElements']//a[contains(@data-original-title,'Smart link')])[1]/../ul/li";
	public static final String notification_mobpush_selectscheduledate = "ScheduleDate,xpath, //span[@aria-controls='PushScheduleDate_dateview']";
	public static final String notification_mobpush_selectscheduledateCarousel = "ScheduleDate,xpath, //span[@aria-controls='PushScheduleDateCRSL_dateview']/i";
	public static final String notification_push_clickNotificationCommSave = "Communication save button,xpath, //*[.='Save']";
	public static final String notification_mobpush_testmailselectDropdown = "test communication dropdown list,xpath,//ul[@id='TestPushCampaignEmailAddres_listbox']/li";
	public static final String notification_mobpush_alertSoundOnOff = "AlertSound On Off,xpath,//label[@for='chkAudio']/../..";
	public static final String notification_mobpush_alertsoundswitch = "Alert sound Switch,xpath,//label[@for='chkAudio']";
	public static final String notification_mobpush_selectalertsounddropdown = "Alert Sound Dropdown,xpath,//span[@aria-owns='MobAudioID_listbox']";
	public static final String notification_mobpush_selectalertsoundlist = "Select Alert Sound,xpath,//*[@id='MobAudioID_listbox']/li";
	public static final String pwnotification_mobpush_layout = "Mobilepush layout,pw,//span[@aria-label='Layout']";

	public static final String pwnotification_mobpush_entertitletext = "Mobile title text,pw,//input[@name='title.text']";
	public static final String pwnotification_mobpush_bodyMessage = "Mobile bodytext,pw,//div[@class='k-content ProseMirror']";

	// time zone error web
	// public static final String notification_mobpush_dateTimeErr = "Date time error,id,";
	public static final String notification_WebMobile_clickDraftConfirm = "Draft confirm button,xpath, //*[@id='campaign-PushScheduleNext-confirmation']//input[@value='OK']";
	public static final String notification_mobpush_mobileappaddicon = "mobileapp add icon,xpath, //*[@id='mobile-push-notify']//a[@data-original-title='Add mobile app']/i";
	public static final String notification_mobpush_dataexchangepage = "data exchange page,xpath, //*[@id='wrapper']//h1[contains(.,'Data exchange')]";
	public static final String notification_mobpush_recipientpageicon = "recipient add icon,xpath, //*[@id='spnNewEmailSegment']/a[2]//i";
	public static final String notification_mobpush_selectmobilepushtargetlist = "Mobile Audience,xpath, //*[@id='PushNotificationRecipientsList_taglist']/..//input";
	public static final String notification_mobpush_enterrecipientlist = "Audience list,xpath, //*[@id='PushNotificationRecipientsList_listbox']/li";
	public static final String notification_mobpush_clickImport = "Select import content,xpath,//a[@id='PushImportUrl']";
	public static final String notification_mobpush_importEDMZip = "Upload zip,id,fileuploadHTMLPush";
	public static final String notification_mobpush_imgContent = "Image content click,xpath,//div[@class='rs-dropdown no_caret  2 dropdown']";
	public static final String notification_mobpush_imgURL = "Image Url select,xpath,//a[contains(text(),'Image URL')]";
	public static final String notification_mobpush_imgBrowse = "Image browse select,xpath,//li[@id='imgContent']//span[contains(text(),'Browse')]";
	public static final String notification_mobpush_imgURLpopup = "Image Url Popup,xpath,//div[@id='resmodal-createCustomImageURL']//h2[contains(text(),'Enter media URL')]";
	public static final String notification_mobpush_imgURLEnter = "Enter URL,xpath,//input[@name='previewImage']";
	public static final String notification_mobpush_imgURLSave = "Save Image URL,xpath,//button[text()='Upload']";
	// COMMUNICATION QR
	public static final String communicationpage_qrChannel = "QR Channel,xpath,//*[contains(@class,'icon-sd-qrcode')]";
	public static final String communicationpage_qrChannel_campaignType = "Campaign type,xpath,//div[contains(@class,'campaign-tab')]//li";
	public static final String communicationpage_qrChannel_recipientreach = "Audience Reach value,xpath,//input[@placeholder='Max. upto 25,000'][@required]";
	public static final String communicationpage_qrChannel_recipientreach_help = "Help link for Audience Reach,xpath,//input[@placeholder='Max. upto 25,000'][@required]/..//following-sibling::div//*[contains(@class,'icon-question-mark-small')]";
	public static final String communicationpage_qrChannel_helptooltip = "Help link tooltip,xpath,//div[@class='tooltip-inner']";
	public static final String communicationpage_qrChannel_commURL = "Communication URL,xpath,//input[@placeholder='Enter communication URL'][@required]";
	public static final String communicationpage_qrChannel_commURL_validationIcon = "Communication URL Validation tickMark,xpath,//*[contains(@class,'icon-sd-circle-tick-mini icons-md green text-end input-icon')]";
	public static final String communicationpage_qrChannel_shortenURL = "Shorten URL link,xpath,//*[contains(@class,'icon-sd-link-medium icons-md blue float-end')]/..";
	public static final String communicationpage_qrChannel_QRCode = "QR Code,xpath,//*[@id='myQR']/..";
	public static final String communicationpage_qrChannel_shorturlCheckbox = "Short URL checkBox,id,Short URL :";
	public static final String communicationpage_qrChannel_redirectionURL = "Redirection URL,xpath,//input[@placeholder='Enter redirection URL'][@required]";
	public static final String communicationpage_qrChannel_redirectionURL_help = "Help link for Redirection URL,xpath,//*[text()='Redirection URL']/../following-sibling::div//*[contains(@class,'icon-sd-question-mark')]";
	public static final String communicationpage_qrChannel_redirURL_validation = "Redirection URL Validation tickMark,xpath,//input[@placeholder='Enter redirection URL']/..//i";
	public static final String communicationpage_qrChannel_kyc_toggleBtn = "KYC toggle Button,xpath,//span[@class='k-switch-container']/..";
	public static final String communicationpage_qrChannel_kyc_formsdropDown = "KYC Form dropdown,xpath,//span[@class='k-dropdown-wrap']";
	public static final String communicationpage_qrChannel_kyc_formsdropDownlist = "Drop-down,xpath,//div[contains(@class,'k-reset k-animation-container-shown')]//li";
	public static final String communicationpage_qrChannel_kyc_previewicon = "Form Preview icon,xpath,//*[contains(@class,'icon-sd-eye-medium icons')][not (contains(@class,'click-off'))]";
	public static final String communicationpage_qrChannel_kyc_prepiewPopup = "Form Preview Popup,xpath,//div[@class='modal-body']";
	public static final String communicationpage_qrChannel_kyc_prepiewPopup_header = "Popup Header,xpath,//div[@class='modal-header']//h2";
	public static final String communicationpage_qrChannel_kyc_prepiewPopup_close = "Popup Close,xpath,//*[@class='btn-close']";
	public static final String communicationpage_qrChannel_generateQR = "Generate QR btn,xpath,//*[contains(@class,'rsp-primary-button')][.='Generate']";
	public static final String communicationpage_qrChannel_downloadQR = "Download QR btn,xpath,//*[contains(@class,'rsp-primary-button')][.='Download']";
	public static final String communicationpage_qrChannel_dwndFormat_dropDownlist = "Download Format,xpath,//*[contains(@class,'k-list k-reset')]//li";
	public static final String communicationpage_qrChannel_dwndlink = "Download link,tag,img";

	// COMMUNICATION EVENTTRIGGER
	public static final String communicationpage_evnttrigger_link = "EventTrigger,xpath,//i[contains(@class,'trigger')]";
	public static final String Communication_EventTrigger_communicationname = "Comm name,id,TransactionTriggerCampaign_TransactionTriggerCampaign_CampaignName";
	public static final String Communication_EventTrigger_commtype = "Comm type,xpath, //*[@id='TriggerCampaignAttributeId']/../span/span[contains(.,'-- Select communication type --')]";
	public static final String Communication_EventTrigger_entercommtype = "Comm type listbox,xpath, //*[@id='TriggerCampaignAttributeId_listbox']/li";
	public static final String Communication_EventTrigger_producttype = "Comm prod type,xpath,//*[@id='TriggerProductCategoryID']/../span/span[contains(.,'-- Select product type --')]";
	public static final String Communication_EventTrigger_enterproducttype = "Prod type listbox,xpath, //*[@id='TriggerProductCategoryID_listbox']/li";
	public static final String Communication_EventTrigger_primarygoal = "Primary goal dropdown,xpath, //*[@id='ddlTriggerPrimaryTargetCode']/../span/span[contains(.,'-- Goal --')]";
	public static final String Communication_EventTrigger_enterprimarygoal = "Primary goal listbox,xpath, //*[@id='ddlTriggerPrimaryTargetCode_listbox']/li";
	public static final String Communication_EventTrigger_goalpercentage = "Goal percent,id,TransactionTriggerCampaign_CampaignRoi_PrimaryTargetValue";
	public static final String Communication_EventTrigger_selectdynamiclist = "Dynamiclist dropdown,xpath,//span[@aria-label='Select dynamic list']";
	public static final String Communication_EventTrigger_enterdynamiclist = "Dynamiclist listbox,xpath,//ul[@role='listbox']";
	public static final String Communication_EventTrigger_selectfrequency = "Trigger frequency,xpath,//*[@class = 'nav nav-tabs tabs-group no-margin']/li";
	public static final String Communication_EventTrigger_enterdailydayvalue = "Trigger daily value,xpath, //input[@id='TransactionTriggerCampaign_TransactionTriggerCampaign_RecurrenceInfo_ReccursEveryDaily']";
	public static final String Communication_EventTrigger_selectdailyhoursvalue = "Trigger hours icon,xpath, //*[@id='daily']//input[contains(@id,'RecurrenceTimeDaily')]/../span/span/i";
	public static final String Communication_EventTrigger_enterdailyhoursvalue = "Hours value listbox,xpath, //*[@id='TransactionTriggerCampaign_TransactionTriggerCampaign_RecurrenceInfo_RecurrenceTimeDaily_timeview']/li";
	public static final String Communication_EventTrigger_enterweeklydayvalue = "Weekly day(s) value,xpath, //input[@id='TransactionTriggerCampaign_TransactionTriggerCampaign_RecurrenceInfo_ReccursEveryWeekly']";
	public static final String Communication_EventTrigger_selectweeklyhoursvalue = "Weekly hour(s),xpath,//*[@id='TransactionTriggerCampaign_TransactionTriggerCampaign_RecurrenceInfo_RecurrenceTimeWeekly']/../span/span/i";
	public static final String Communication_EventTrigger_enterweeklyhoursvalue = "Weekly hours(s) listbox,xpath, //*[@id='TransactionTriggerCampaign_TransactionTriggerCampaign_RecurrenceInfo_RecurrenceTimeWeekly_timeview']/li";
	public static final String Communication_EventTrigger_selectmonthlyexactdayradiobtn = "Monthly exactday radiobtn,xpath, //*[@id='TimeSubsetByExcatDay']";
	public static final String Communication_EventTrigger_entermonthlyexactdayvalue = "Monthly exactday,xpath, //input[@data-val-required='The ReccursEveryMonthly field is required.']";
	public static final String Communication_EventTrigger_entermonthlyexactmonthvalue = "Monthly exactday month,xpath, //input[@data-val-required='The ReccursOn field is required.']";
	public static final String Communication_EventTrigger_selectmonthlyexacthoursvalue = "Monthly exactday hour(s) icon,xpath, //*[@id='TransactionTriggerCampaign_TransactionTriggerCampaign_RecurrenceInfo_RecurrenceTimeMonthly']/../span/span/i";
	public static final String Communication_EventTrigger_entermonthlyexacthoursvalue = "Monthly exactday hour(s) listbox,xpath, //*[@id='TransactionTriggerCampaign_TransactionTriggerCampaign_RecurrenceInfo_RecurrenceTimeMonthly_timeview']/li";
	public static final String Communication_EventTrigger_selectmonthlyanydayradiobtn = "Monthly anyday radiobtn,xpath, // input[@id='TimeSubsetByDay']";
	public static final String Communication_EventTrigger_selectmonthlyanydaytimevalue = "Monthly day order,xpath, //span[@aria-owns='selByWeek_listbox']";
	public static final String Communication_EventTrigger_entermonthlyanydaytimevalue = "Monthly day order listbox,xpath, //*[@id='selByWeek_listbox']/li";
	public static final String Communication_EventTrigger_selectmonthlyanydaydayvalue = "Monthly weekday,xpath, //span[@aria-owns='selByDay_listbox']";
	public static final String Communication_EventTrigger_entermonthlyanydaydayvalue = "Monthly weekday listbox,xpath, //*[@id='selByDay_listbox']/li";
	public static final String Communication_EventTrigger_entermonthlyanydaymonthvalue = "Month count,xpath, //input[@id='TransactionTriggerCampaign_TransactionTriggerCampaign_RecurrenceInfo_ReccursDayMonthly']";
	public static final String Communication_EventTrigger_selectmonthlyanydayhoursvalue = "Monthly hour(s) icon,xpath, //*[@id='TransactionTriggerCampaign_TransactionTriggerCampaign_RecurrenceInfo_ReccursDayMonthlytimePicker']/../span/span/i";
	public static final String Communication_EventTrigger_entermonthlyanydayhoursvalue = "Monthly hour(s) value,xpath, //*[@id='TransactionTriggerCampaign_TransactionTriggerCampaign_RecurrenceInfo_ReccursDayMonthlytimePicker_timeview']/li";
	public static final String Communication_EventTrigger_channeltypeemail = "Trigger type email,xpath, //input[contains(@id,'TransactionTriggerCampaign_TransactionTriggerCampaign_IsEmailChannelSelected')]";
	public static final String Communication_EventTrigger_channeltypesms = "Trigger type sms,xpath, //input[contains(@id,'TransactionTriggerCampaign_TransactionTriggerCampaign_IsMobileChannelSelected')]";
	public static final String Communication_EventTrigger_channeltypenotifications = "Trigger type notifications,xpath, //input[@id='TransactionTriggerCampaign_TransactionTriggerCampaign_IsNotificationSelected']";
	public static final String Communication_EventTrigger_analytictypeweb = "Trigger type web,xpath, //input[contains(@id,'TransactionTriggerCampaign_TransactionTriggerCampaign_IsWebAnalyticsSelected')]";
	public static final String Communication_EventTrigger_analytictypeapp = "Trigger type app,xpath, //input[contains(@id,'TransactionTriggerCampaign_TransactionTriggerCampaign_IsAppSelected')]";
	public static final String Communication_EventTrigger_analytictypevideos = "Trigger type video,xpath, //input[contains(@id,'TransactionTriggerCampaign_TransactionTriggerCampaign_IsVideosAnalyticsSelected')]";
	public static final String notification_webpush_verifyeventcomm = "xpath, //label[contains(.,'Analytics platform')]";
	public static final String Communication_EventTrigger_triggertimezone = ",xpath,//div[@class='col-sm-push-1 col-sm-7 col-xs-12 inline-top']/a/i";
	public static final String Communication_EventTrigger_selecttriggertimezoneicon = "Timezone icon,xpath, //i[@class='icon-edit-pencil-mini icon-xmini blue']";
	public static final String Communication_EventTrigger_selecttriggertimezonelist = "Timezone dropdown,xpath, //span[@aria-owns='TriggerTimeZone_listbox']//span/span";
	public static final String Communication_EventTrigger_entertriggertimezonelist = "Timezone listbox,xpath, //*[@id='TriggerTimeZone_listbox']/li";
	public static final String communication_EventTrigger_saveplanpage = "save plan page,id,btnCreatePlanSave";
	public static final String Communication_EventTrigger_comparecommtype = "Comm type,xpath, (//*[@aria-owns='TriggerCampaignAttributeId_listbox']//span)[2]";
	public static final String Communication_EventTrigger_compareproducttype = "Comm prod type,xpath, (//*[@aria-owns='TriggerProductCategoryID_listbox']//span)[2]";
	public static final String Communication_EventTrigger_compareprimarygoal = "Primary goal dropdown,xpath, (//*[@aria-owns='ddlTriggerPrimaryTargetCode_listbox']//span)[2]";

	// Communication Voice
	public static final String communication_voice_clickcallcentertargetlist = "Recipient select,xpath, //*[@id='divCallcenterRecipientSelection']//input";
	public static final String communication_voice_selectcallcentertargetlist = "callcenter recipient listbox,xpath, //*[@id='SelectedCallCenterRecipients_listbox']/li";
	public static final String communication_voice_entercontent = "Call Center Content,xpath, //*[@id='CallCenterContent']";
	public static final String communication_voice_enterscheduledate = "Schedule Date,xpath, //*[@id='CallCenterSchedulePanel']//span[contains(@aria-controls,'dateview')]/i";
	public static final String communication_voice_clickscheduletime = "Schedule Time,xpath, //*[@id='CallCenterSchedulePanel']//span[contains(@aria-controls,'timeview')]/i";
	public static final String communication_voice_enterscheduletime = "Schedule Time,xpath, //*[@id='CallCenterScheduleDate_timeview']/li[1]";
	public static final String communication_voice_clicktimezoneicon = "Timezone icon,xpath, //*[@id='spnMobileDateView']/..//a/i";
	public static final String communication_voice_clicktimezonedropdown = "Timezone dropdown,xpath, //*[@id='CallCenterTimeZone']/../span/span";
	public static final String communication_voice_selecttimezonelist = "Timezone listbox,xpath, //*[@id='CallCenterTimeZone_listbox']/li";
	public static final String communication_voice_savevoicecommunication = "Callcenter Save,xpath, //*[@id='callcenterCampaignSave']";

	// Communication WhatsApp Page
	public static final String communication_whatsapp_whatsappiconclick = "WhatsApp Page Icon,xpath, //*[@id='liWhatsappChannel']/a";
	public static final String communication_whatsapp_sendernameclick = "WhatsApp sender id,xpath, //*[@id='ClientWASettingId']/../../span[@aria-owns='ClientWASettingId_listbox']";
	public static final String communication_whatsapp_selectsendername = "WhatsApp sender dropdown,xpath, //*[@id='ClientWASettingId_listbox']//li"; // *[@id='ClientWASettingId']//option";
	public static final String communication_whatsapp_recipientclick = "Recipient,xpath, //*[@id='wACampaignModel_SelectedWhatsappMobileRecipients_taglist']/../input";
	public static final String communication_whatsapp_selectrecipientlist = "Recipient listbox,xpath, //*[@id='wACampaignModel_SelectedWhatsappMobileRecipients_listbox']/li";
	public static final String communication_whatsapp_selecttemplatelanguage = "Template language,xpath, //*[@id='wATempLanguage']/../span/span";
	public static final String communication_whatsapp_selecttemplatelanguagedropdown = "Template language dropdown,xpath, //*[@id='wATempLanguage_listbox']/li";
	public static final String communication_whatsapp_selecttemplatename = "Template name,xpath, (//*[@id='wATemplateId']/../span/span)[1]";
	public static final String communication_whatsapp_selecttemplatenamedropdown = "Template name list,xpath, //*[@id='wATemplateId_listbox']/li";
	public static final String communication_whatsapp_selectpersonalization = "Persona Icon,xpath,//i[contains(@class,'icon-rs-editor-person')]";
	public static final String communication_whatsapp_personalizationlist = ",xpath,//div[@class='css-scrollbar']//div";
	public static final String communication_whatsapp_enterwhatsappcontent = "WhatsApp content,xpath,//textarea[@id='editorText']";
	public static final String pwcommunication_whatsapp_enterwhatsappcontent = "WhatsApp content,pw,//textarea[@id='editorText']";

	public static final String communicationpage_select_whatsappscheduledate = "Schedule date,xpath, //span[@aria-controls='wACampaignModel_WaMoblieScheduleDate_dateview']/i";
	public static final String communicationpage_select_whatsappselecttime = "Select Time,xpath, //span[@aria-controls='wACampaignModel_WaMoblieScheduleDate_timeview']";
	public static final String communicationpage_select_whatsappscheduletime = "Schedule Time,xpath, //*[@id='wACampaignModel_WaMoblieScheduleDate_timeview']/li[1]";
	public static final String communicationpage_select_whatsapptimezoneicon = "Timezone icon,xpath, (//a[@class='no-hover SMSedit-timezone'])[6]";
	public static final String communicationpage_select_whatsapptimezonedropdown = "Timezone dropdown,xpath, //span[@aria-owns='wamobileTimeZone_listbox']";
	public static final String communicationpage_select_whatsappselecttimezone = "Timezone list,xpath, //*[@id='wamobileTimeZone_listbox']/li";
	public static final String communication_whatsapp_testnumber = "whatsapp test number,xpath, //*[@id='whatsappTestMobileNumber']";
	public static final String communication_whatsapp_testsendbutton = "whatsapp send button,xpath, //*[@id='sendWhatsappButtonPanel']//input";
	public static final String communication_whatsapp_testmessage = "whatsapp test message,xpath, //*[@id='campaign-test-mail-sent-msg']";
	public static final String communication_whatsapp_pdfdocupload = "pdf document upload,xpath, //a[@data-original-title='Document upload']/i";
	public static final String communication_whatsapp_pdfdocurl = "pdf doc url,xpath, //a[@id='PdfBrowse2']";
	public static final String communication_whatsapp_enterpdfdocurl = "enter pdf doc url,xpath, //*[@id='wapdfURL']";
	public static final String communication_whatsapp_clickpdfdoctype = "pdf doc url type,xpath, //*[@id='waPdfType']/..//span[contains(text(),'-- Select document Type --')]";
	public static final String communication_whatsapp_selectpdfdoctype = "pdf doc url list,xpath, //*[@id='waPdfType_listbox']/li";
	public static final String communication_whatsapp_savepdfdoctype = "save pdf doc type,xpath, //*[@class='modal-footer']//input[@onclick='SaveWACustomPdfURL()']";
	public static final String communication_whatsapp_errormessage = "Error msg,xpath, //*[@id='errmsgValidWappContent']";
	public static final String communication_whatsapp_videoupload = "video upload,xpath, //a[@data-original-title='Video upload']/i";
	public static final String communication_whatsapp_videouploadurl = "select video upload url,xpath, //a[@id='VideoBrowse2']";
	public static final String communication_whatsapp_entervideourl = "video upload url,xpath, //*[@id='wavideoURL']";
	public static final String communication_whatsapp_clickvideotype = "select video type,xpath, //*[@id='waVideoType']/..//span[contains(text(),'-- Select Video Type --')]";
	public static final String communication_whatsapp_selectvideotype = "video type listbox,xpath, //*[@id='waVideoType_listbox']/li";
	public static final String communication_whatsapp_savevideotype = "save video type,xpath, //*[@class='modal-footer']//input[@onclick='SaveWACustomVideoURL()']";
	public static final String communication_whatsapp_imageuploadicon = "Image upload icon,xpath, //a[@data-original-title='Image upload']/i";
	public static final String communication_whatsapp_imageuploadbrowse = "Image upload using browse,xpath, //a[@data-original-title='Image upload']/i";
	public static final String communication_whatsapp_imageupload = "Image upload,xpath, //*[@id='WhatsAppImage']";// following-sibling::span[contains(text(),'Browse')]";

	public static final String communication_whatsapp_couponcode = "Whatsapp coupon code,xpath,//ul[@id='ulWAElements']//i[@class='icon-coupon-small blue icon-sm']";
	public static final String communication_whatsapp_okbutton = "ok Button,xpath,//div[@id='WATemplate-Conformation']//input[@onclick='WATemplateContinue()']";

	public static final String communicationListing_deliverymethod = "Delivery methods,xpath,(//div[@class='k-grid-content']//tbody//tr//td)[4]//h4";
	public static final String communicationListing_communicationtype = "Communication type,xpath,(//div[@class='k-grid-content']//tbody//tr//td)[4]//small";
	public static final String comuunicationListing_totalAudience = "Total Audience,xpath,(//div[@id='campaignListGrid']//tbody//tr//td)[5]";
	// Gallery Page
	public static final String communciation_galleryicon = "Gallery Icon,xpath,//div[@class='content campaign']//a[.='Gallery']";
	public static final String communication_gallery_searchicon = "Gallery Search Icon,xpath,//div[@class='search searchEffect cl-search-new']";
	public static final String communication_gallery_textboxvalue = "Gallery Textbox value,xpath,//*[@id='searchQuery']";
	public static final String communication_gallery_enteredvalueaftersearch = "Search icon,xpath,//div[@class='searchSlide on']";
	public static final String communication_gallery_communicationtitle = "Gallery Communication Title,xpath,//div[@class='galleryArrow']//span[@class='campaign-title']";
	public static final String communication_gallery_communicationstatus = "communication status,xpath,//div[@class='clear emptycampaignListGrid hide']//h4";
	public static final String communicationListing_playicon = "Play-Icon,xpath,//i[@class='icon-play-small play']";
	public static final String communicationListing_pauseicon = "Pause-Icon,xpath,//i[@class='icon-pause-small pause']";
	public static final String communicationListing_stopicon = "Pause-Icon,xpath,//i[@class='icon-stop-small stop']";
	public static final String communicationListing_pause_confirm = "Play&Pause,xpath,//input[@onclick='OnPauseContinue();']";
	public static final String communicationListing_play_confirm = "Play&Pause,xpath,//input[@onclick='OnResumeForSplitCamp();']";
	public static final String communicationListing_notification_msg = "Notification Message,xpath,//div[@id='notification-message']";
	public static final String communicationListing_dropdownvalue = "Drop-down value,xpath,//li[@class='dropdownValueSelect']";
	public static final String communicationListing_commmainstatus = "communication main status,xpath,(//table[@role='treegrid']//tr//td)[6]//small";
	public static final String communication_gallery_i_icon = "I-icon,xpath,//*[@id='GalleryGrid']//a[contains(@class,'galleryInfo')]";
	public static final String communication_gallery_deliverymethodname = "Delivery method type name,xpath,//div[@class='pfCampLabel CampaignType padding-B10']";
	public static final String communication_gallery_commtypename = "Communication type name,xpath,//div[@class='pfCampLabel CampaignAttributeType']";
	public static final String communication_gallery_deliverymethod = "Delivery method type,xpath,//div[@class='inline-block ']";
	public static final String communication_gallery_commtype = "Communication type,xpath,//div[@class='pfCampContainer no-margin-bottom']//div[@class='inline-block']";
	public static final String communication_gallery_commstatus = "communication status,xpath,//div[@class='pfCampContainer no-margin-bottom']";
	public static final String communication_gallery_commstatus1 = "communication status1,xpath,//div[@class='pfCampContainer2']//div[@class='pfcc-row']";

	// public static final String communication_ListTimeStamp = "List Date,xpath,//span[@class='created-name']/..";
	public static final String communication_ListTimeStamp = "List Date,xpath,//tr[contains(@class,'k-master-row')]//td[2]";
	public static final String communication_ListTimeStamp_Notification = "List Date,xpath,//tr[contains(@class,'k-master-row')]//td[1]";
	public static final String communication_ListName = "List name ,xpath, //h4[@class='campaign-title init-campaign-name-common']";
	public static final String communication_clickpagination_NextPage = "Next Page button ,xpath, //a[@class='k-link']//span[@class='k-icon k-i-arrow-e']";
	public static final String communication_dsrpagereporticon = "Report icon,xpath,(//*[@class='list-inline pull-right d-flex']//i[@title='Report'])[1]";

	// Planner Page
	public static final String communication_planner_communicationlist = "Gallery Page New Communication List,xpath, (//*[@id='ui-accordion-accordion_dayclick-panel-0'])[2]//ul/li//a/div";

	// Comm plan page negative scenario
	public static final String communication_goal_addiconinitial = "Initial Goal Add icon,xpath,//a[contains(@class,'no-hover addConversion addSecGoal')]";
	public static final String communicationpage_goal_addicon = "Goal Add Icon,xpath,//a[contains(@class,'no-hover addSecGoal')]";
	public static final String communication_secondarygoal_popup = "Secondary goal popup,xpath,//h2[.='Communication goal info']//..//..//input[@type='button']";
	public static final String communication_secondarygoal_dropdown = "Secondary Goal Dropdown,xpath,//span[@aria-owns='ddlSecondaryTargetCode_listbox']//span[@class='k-icon k-i-arrow-s']";
	public static final String communication_secondarygoal_dropdownselect = "Secondary Goal Dropdown select,xpath,//ul[@id='ddlSecondaryTargetCode_listbox']//li";
	public static final String communication_secodarygoal_percentage = "Secondary goal percentage,xpath,//input[@id='CampaignRoi_SecondaryTargetValue']";
	public static final String communication_secondarygoal_deleteicon = "Delete icon,xpath,//a[@class='no-hover removeConversion']//i";
	public static final String communication_docketicon = "Communication Docket icon,xpath,//div[@id='divcampaigndoc']//span[@class='margin-L5']";
	public static final String communication_docket_saveicon = "Communication Docket save icon,xpath,//input[@id='campaignDocketSaveBtn']";
	public static final String communication_docket_groupingid_txt = "Grouping id text value,xpath,//input[@id='newCampaignGroup']";
	public static final String communication_docket_groupingid_dropdown = "Grouping Id,xpath,//span[@class='k-widget k-dropdown k-header TestCampaignDocket']//span[@class='k-select']";
	public static final String communication_docket_groupingid_dropdownselect = "Grouping Id dropdown select,xpath,//ul[@id='campDocketGroup_listbox']//li";
	public static final String communication_docket_attachfile = "Communication docket attach file,xpath,//input[@id='fileuploadHTMLCampaign']";
	public static final String communication_docket_refid = "communication ref id,xpath,//input[@id='txtproductmanagername']";
	public static final String communication_docket_branchname = "Branch name,xpath,//input[@id='txtCampaignmanager']";
	public static final String communication_docket_managerid = "Manager id,xpath,//input[@id='txtproduct']";
	public static final String communication_docket_offertype = "Offer type,xpath,//input[@id='txtcostcode']";
	public static final String communication_docket_country = "country name,xpath,//input[@id='txtCAFno']";
	public static final String communication_docket_closeicon = "Communication docket close icon,xpath,//button[@id='btncampaignDocketCancelBtn']";
	public static final String communication_tags = "communication tags,xpath,//a[@id='CampaignTag']";
	public static final String communication_tags_okbutton = "Tags Ok Button,xpath,//*[.='Tags']//..//following-sibling::div[@class='modal-footer']//input";
	public static final String communication_tags_textbox = "Add tags textbox,xpath,//input[@class='addTag']";
	public static final String communication_tags_textboxgetvalue = "TextBox get value,xpath,//ul[@id='ulCampaignTags']//li";
	public static final String communication_tags_closetext = "Close Text,xpath,//ul[@id='ulCampaignTags']//li//a";

	// comm authoring page negative scenario
	public static final String communication_sendername = "Communication Sender name,xpath,//input[@id='FromName']";
	public static final String communication_replyemailcheckbox = "Reply Email checkbox,xpath,//input[@id='receiveReplies']";
	public static final String communication_schedulestateerrpopup = "Communication Scedule State Error popup,xpath,(//div[@class='modal-body text-center']//p[contains(.,'The Communication is not')])[1]";
	public static final String communication_schedulepopup_cancelbutton = "Communication schedule popup ok,xpath,(//div[@class='modal-body text-center']//p[contains(.,'The Communication is not')])[1]//..//..//input[@value='Cancel']";

	// Frequency Cap
	public static final String precommunicationpage_freqCap = "Frequency Cap,xpath,//li[contains(@id,'divFrequencyCap')]";
	public static final String precommunicationpage_freqCap_toggle = "Frequency Cap popup,xpath,//div[@class='audience-split-ab-mechanics splitABDwnCnt ']//div[contains(@class,'bootstrap-switch')]";
	public static final String precommunicationpage_freqCap_popup = "Frequency Cap popup,xpath,//div[@class='audience-split-ab-mechanics splitABDwnCnt ']";
	public static final String precommunicationpage_freqCap_Dropdown = "Frequency Cap rule drop-down ,xpath,//div[@id='multiselectRuleDiv']/div";

	// Mkstr - Fields retain in Edit Mode
	public static final String communicationpage_commcreation_edit_commName = "Communication Name,xpath,//div[contains(@class,'click-off row')]//input[@placeholder='Enter communication name']";
	public static final String communicationpage_commcreation_edit_commtype = "Communication Type,xpath,(//*[text()='Communication / Product type']//ancestor::div[contains(@class,'click-off row')]//span[@class='k-input'])[1]";
	public static final String communicationpage_commcreation_edit_prodtype = "Communication Product,xpath,(//*[text()='Communication / Product type']//ancestor::div[contains(@class,'click-off row')]//span[@class='k-input'])[2]";
	public static final String communicationpage_commcreation_edit_primarygoal = "Primary Goal,xpath,//*[text()='Primary goal']//ancestor::div[contains(@class,'click-off row')]//span[@class='k-input']";
	public static final String communicationpage_commcreation_edit_primargoalPercent = "Primary Goal Percentage,xpath,//*[text()='Primary goal']//ancestor::div[contains(@class,'click-off row')]//input";
	public static final String communicationpage_commcreation_edit_stDate = "Start Date,xpath,//div[contains(@class,'click-off')]//div[@class='rspdate-picker']//input";
	public static final String communicationpage_commcreation_edit_endDate = "End Date,xpath,(//div[@class='rspdate-picker'])[2]//input";
	public static final String communicationpage_commcreation_edit_calender = "Calender,xpath,//div[@class='rspdate-picker']//ancestor::div[contains(@class,'col-md-6')]";
	public static final String communicationpage_commcreation_edit_emailChannel = "Email Channel,xpath,//div[contains(@class,'click-off row')]//input[@id='Email']/..//span";
	public static final String communicationpage_commcreation_edit_smsChannel = "Sms Channel,xpath,//div[contains(@class,'click-off row')]//input[@id='SMS']/..//span";
	public static final String communicationpage_commcreation_NextButton = "Next Button,xpath,//button[text()='Next']";
	public static final String communicationpage_commcreation_edit_senderName = "Sender Name,xpath,//div[contains(@class,'click-off row')]//input[@placeholder='Enter sender name']";
	public static final String communicationpage_commcreation_edit_sendername = "Sender Email name,xpath,//div[contains(@class,'click-off row')]//input[@placeholder='Username']";
	public static final String communicationpage_commcreation_edit_senderdomain = "Domain,xpath,//div[contains(@class,'click-off row')]//*[@placeholder='Username']/../..//following-sibling::div//span[@class='k-input']";
	public static final String communicationpage_commcreation_edit_audience = "Audience list dropdown,xpath,//div[contains(@class,'click-off row')]//span[@class='k-widget k-multiselect']";
	public static final String communicationpage_commcreation_edit_subline = "Subject line,xpath,//div[contains(@class,'click-off row')]//input[@placeholder='Enter subject line']";
	public static final String communicationpage_commcreation_edit_edmfile = "EDM File,xpath,//div[@class='import-iframe-wrapper']";
	public static final String communicationpage_commcreation_edit_unsub = "Unsubscription dropdown,xpath,//*[text()='Un-subscription message']/ancestor::div[contains(@class,'click-off')]//span[@class='k-input']";
	public static final String communicationpage_commcreation_edit_schedule = "Schedule time datepicker,xpath,//div[contains(@class,'click-off row')]//div[@class='rsptimer-picker']";
	public static final String communicationpage_commcreation_edit_testMail = "Send Test Mail,xpath,//*[text()='Send test mail to']//ancestor::div[contains(@class,'click-off row')]";
	public static final String communicationpage_precommHeader = "Headers name,xpath,//div[contains(@class,'text-center')]//p";
	public static final String communicationpage_precommCount = "Headers count,xpath,//div[contains(@class,'text-center')]//h1";
	public static final String communicationpage_precomm_progressSteps = "Plan page details,xpath,//div[@class='steps-label']";
	// SMS
	public static final String communicationpage_commcreation_sms_edit_senderID = "Sender ID,xpath,//div[contains(@class,'click-off row')]//*[text()='Sender ID']/ancestor::div[contains(@class,'custom-column')]//span[@class='k-input']";
	public static final String communicationpage_commcreation_sms_edit_tempId = "Template ID,xpath,//div[contains(@class,'click-off row')]//input[@placeholder='Enter sender template ID']";
	public static final String communicationpage_commcreation_sms_edit_content = "Subject content,xpath,//div[contains(@class,'click-off row')]//div[@class='editor-view-container']//*[@placeholder='Enter message']";
	public static final String communicationpage_commcreation_sms_edit_testMail = "Send Test Message,xpath,//*[text()='Send test message to']//ancestor::div[contains(@class,'click-off row')]";

	// Mkstr - Payment
	public static final String communicationpage_paymentActivation = "payment & Activation,xpath,//h1[@class='header-title-margin']";
	public static final String communication_payment_container = "Payment section,xpath,//div[@class='payment-tab-container']";
	public static final String communicationpage_paymentsummarytext = "payment summary,xpath,//h1[contains(text(),'Payment summary')]";
	public static final String communicationpage_select_emailcommunicationconfirm = "email payment confirm,xpath,//button[contains(text(),'Confirm')]";
	public static final String communicationpage_payment_cardnumber = "payment card number,xpath,//input[@name='cardNumber'][@required]";
	public static final String communicationpage_payment_cardtype = "Credit card Type,xpath,//input[@name='cardNumber'][@required]//following-sibling::img";

	public static final String communication_payment_cardname = "payment card name,xpath,//input[@name='cardName'][@required]";
	public static final String communication_payment_month = "payment month,xpath,//input[@name='month'][@required]";
	public static final String communication_payment_year = "payment,xpath,//input[@name='year'][@required]";
	public static final String communication_payment_cvv = "payment cvv,xpath,//input[@name='cvv'][@required]";
	public static final String communication_payment_Text = "communiation payment,xpath,//h1[contains(text(),'Communication payment')]";
	public static final String communication_payment_submit = "payment submit,xpath,//button[contains(text(),'Submit')]";
	public static final String communicationpage_payment_gridheader = "Grider headers,xpath,//*[@class='table rs-table']//th";
	public static final String communicationpage_payment_gridrows = "Grider column,xpath,//*[@class='table rs-table']//tbody//tr";
	public static final String communicationpage_payment_Errmsg = "Validation Meessage,xpath,//div[@class='validation-message']";
	public static final String communicationpage_payment_creditcard = "Credit Card Payment,xpath,//*[contains(@class,'icon-creditcard-medium')]/..";
	public static final String communicationpage_payment_paypal = "Paypal Payment,xpath,//div[@class='payment-tab-container']//li[2]";

	// Manimaran
	public static final String communication_search_btn = "Search icon,xpath,//div[@class='search-icon']";
	public static final String communication_advsearch_button = "Menu icon,xpath,//i[@class='icon-dropmenu-small icons-sm white']";
	public static final String communication_searchfield = "Search field,xpath,//input[@placeholder='By communication name']";
	public static final String communication_clicksearch = "Click search,xpath,//div[@class='input-search-icon cp ']";
	public static final String communication_Modulecolor_orange = "Communication tab color,xpath,//a[@class='active'][@href='/communication']";
	public static final String communication_communication_details = "Communication grid,xpath,//div[@class='panelbar-wrapper campaign-analytics-list']";
	public static final String communication_create_communication_btn = "Create communication '+' icon,xpath,//i[@class='icon-plus-fill-medium icons-lg blue cursor-pointer icon-shadow-del']";
	public static final String communication_gallery_details = "Gallery grid,xpath,//div[contains(@class,'card-gallery-box status')]";
	public static final String communication_gallery_tab = "Gallery tab,xpath,//li[contains(@class,'tabDefault  ')][contains(.,'Gallery')]";
	public static final String communication_gallery_grid = "Gallery grid view,xpath,//div[contains(@class,'gallery-grid-view')]";
	public static final String communication_closesearch_btn = "Close search,xpath,//i[@class='icons-sm icon-sd-close-mini white']/..";
	public static final String CommunicationListing_emailpreview = "Email preview,xpath,//div[contains(@class,'rs-preview-content')]//img";
	public static final String CommunicationListing_smspreview = "SMS preview,xpath,//div[@class='campaign-sms-wrapper']";
	public static final String CommunicationListing_duplicate = "Duplicate button,xpath,//*[.='Sdc email test preview check_Copy1']/../..//div[@class='camp-icon']//i[@class='icon-duplicate-small icons-md blue']";

	// Jasmine - Mkstr

	public static final String communicationListing_pagination = "Listing pagination,xpath, //span[@class='k-pager-input k-label']";
	public static final String communicationListing_itemsperpage = "Listing iets per page,xpath, //span[@class='k-pager-sizes k-label']";

	// Listing SMS
	public static final String communicationListing_getpreviewcontent = "Listing SMS preview,xpath, //span[@class='campaign-message']";
	public static final String communicationListing_getemaichannel = "Listing emai channel,xpath, (//table[@class='accordian-body']//td/i)[1])";
	public static final String communicationListing_expandicon = "Listing page expan icon,xpath, //div[@class='expand-plus']";

	public static final String communication_TestCommQuestionMark = "Test comm question mark,xpath,//label[@for = 'testCommunication']/following-sibling::i";
	public static final String communication_AnalyticsMessage = ",xpath,//div[contains(text(),'Analytics')]";
	public static final String communication_CommNameMandate = "Communcation mandate,xpath,//label[contains(.,'Communication name')]/../../..//div[contains(@class,'border-bottom')]";
	public static final String communication_CommNameErrorMessage = "Comm name error message,xpath,//input[@name='communicationName']/parent::div";
	public static final String communication_ExistingCommError = "Err message,xpath,//label[text()='Communication name already exists']";
	public static final String communication_TestCommunication = "Test communication,xpath,//input[@name='testCommunication']";
	public static final String communication_Min3CharValidation = ",xpath,//label[text()='Min. 3 characters']";
	public static final String communication_TagsIcon = "Tags,xpath,//i[contains(@class,'tag')]";
	public static final String communication_TagsKeywords = "Tags keywords,xpath,//input[@placeholder='Enter keywords']";
	public static final String communication_TagLimitValidation = "Tag limit validation,xpath,//div[text()='Tag limit exceeded']";
	public static final String communication_CloseIcon = "Close icon,xpath,//i[contains(@class,'circle-close')]";
	public static final String communication_SuccessValidationIcon = "success icon,xpath,//div[contains(@class,'validate-success')]";

	public static final String communication_CommTypeMandate = "Communication type,xpath,//span[contains(@aria-label,'Communication type')]";
	public static final String communication_ProductTypeMandate = "Product type,xpath,//span[contains(@aria-label,'Product type')]";
	public static final String communication_PrimaryGoalMandate = "Primary goal,xpath,//span[contains(@aria-label,'Product type')]";

	public static final String communication_GoalPercentageMandate = "Communcation mandate,xpath,//label[contains(.,'Goal percentage')]/../../..//div[contains(@class,'border-bottom')]";
	public static final String communication_PrimaryGoalAdd = "Primary goal add,xpath,//i[contains(@id,'circle_plus')]";
	public static final String communication_CommunicationGoalInfoHeader = "Head,xpath,//h2[text()='Communication goal info']";
	public static final String communication_SecondaryGoalMessage = ",xpath,//p[@class]";
	public static final String communication_GoalPercentageError = "Goal per error,xpath,//label[text()='Accepting Only values 0.01 - 100.00']";
	public static final String communication_EngagementType = "Engagement type,xpath,//label[contains(.,'Engagement type')]/..//div[@role='listbox']/..";
	public static final String communication_ConversionType = "Engagement type,xpath,//label[contains(.,'Conversion type')]/..//div[@role='listbox']/..";
	public static final String communication_CreationText = "Communication creation text,xpath,//h1";
	public static final String communication_DeliveryMethodText = "Choose delivery method text,xpath,//h3";
	public static final String communication_SingleDimensionIcon = "Single dimension,xpath,//li[@class='tabDefault     '][.='Single dimension']";
	public static final String communication_MultiDimensionIcon = "Multi dimension,xpath,//li[@class='tabDefault     '][.='Multi dimension']";
	public static final String communication_EventTriggerIcon = "Event trigger,xpath,//li[@class='tabDefault     '][.='Event trigger']";
	public static final String communication_CompanyNameDropdown = "Company name dropdown,xpath,(//div[@class='mhwc-right']//div[contains(@class,'boots')])[1]";
	public static final String communication_BUDropdown = "BU dropdown,xpath,(//div[@class='mhwc-right']//div[contains(@class,'boots')])";

	public static final String communication_ROIToggle = "ROI toggle,xpath,//span[@dir]";
	public static final String communication_SingleDimensionDisable = ",xpath,(//li[@class='tabDefault   click-off  '])[1]";
	public static final String communication_EventTriggerDisable = ",xpath,(//li[@class='tabDefault   click-off  '])[2]";
	public static final String communication_RefreshIcon = "Refresh icon,xpath,//i[contains(@id,'refresh')]";
	public static final String communication_RefreshModal = ",xpath,//div[contains(@class,'modal-content')]";
	public static final String communication_RefreshOKButton = "Ok button,xpath,//button[.='OK']";
	public static final String communication_CancelButton = "Cancel button,xpath,//button[.='Cancel']";
	public static final String communication_CommunicationsList = "(//div[contains(@class,'inline-block')])";

	public static final String communication_social_CancelButton = "Cancel Button,xpath,//button[contains(text(),'Cancel')]";
	public static final String communication_CreateCommunication = "Create Communication,xpath,//button[contains(text(),'Create Communication')]";
	public static final String communication_SaveButton = "Save Button,xpath,//button[contains(text(),'Save')]";
	public static final String communication_FacebookChannel = "Facebook Channel,xpath,//span[.='Facebook']/ancestor::li[contains(@class,'tabDefault active')]";
	public static final String communication_ValidationMessage = "Validation Message,xpath,//*[contains(text(),'Enter post name') or contains(text(),'Select post on') or contains(text(),'Enter message') or contains(text(),'Enter URL')]";
	public static final String communication_IgnoreChannelText = "Ignore Channel Text,xpath,//p[.='Are you sure you want to ignore this channel']";
	public static final String communication_PostName = "Post Name Field,xpath,//input[@name='postName']";
	public static final String communication_PostOn = "Post On Field,xpath,//span[contains(@aria-label,'ost on')]";
	public static final String communication_BoostButton = "Boost Button,xpath,//button[contains(@class,'boost-toggle')]";
	public static final String communication_Target = "Target Field,xpath,//button[contains(@class,'target-button')]";
	public static final String communication_Country = "Country Dropdown,xpath,//select[@name='country']";
	public static final String communication_AgeFrom = "Age From Dropdown,xpath,//select[@name='ageFrom']";
	public static final String communication_AgeTo = "Age To Dropdown,xpath,//select[@name='ageTo']";
	public static final String communication_TextField = "Text Field,xpath,//textarea[contains(@class,'post-textfield')]";
	public static final String communication_EmojiButton = "Emoji Button,xpath,//button[contains(@class,'emoji-picker')]";
	public static final String communication_VideoUpload = "Video Upload,xpath,//button[contains(@class,'video-upload')]";
	public static final String communication_SmartLink = "Smart Link,xpath,//a[contains(@class,'dropdown-item')]";
	public static final String communication_PostLink = "Post Link Field,xpath,//input[@name='postLink']";
	public static final String communication_TrendingTopics = "Trending Topics,xpath,//label[text()='#Trending topics']";
	public static final String communication_TopicsQuestionMark = "Topics Question Mark,xpath,//button[contains(@class,'topics-questionmark')]";
	public static final String communication_TrendingTopicsField = "Trending Topics Field,xpath,//input[contains(@class,'trending-topics-input')]";
	public static final String communication_ValidationMessage_ = "Validation message,xpath,//div[@class='validation-message'][contains(.,'later than 15')]";
	public static final String pwcommunication_Testcommunication = "Test communication,pw,//input[@name='testCommunication']";

	public static final String pwcommunication_DeliveryMethod_Save = "Delivery Method Save,pw,#rs_DeliveryMethod_Save";
	public static final String pwcommunication_CommunicationType = "Communication Type,pw,//span[@aria-label='Select communication type']";
	public static final String pwcommunication_ProductType = "Product Type,pw,//span[contains(@aria-label,'Select product type')]";
	public static final String pwcommunication_PrimaryGoal = "Primary Goal,pw,//span[contains(@aria-label,'Select primary goal')]";
	public static final String pwcommunication_SelectChannel = "Select Channel,pw,//div[.='Select atleast one channel']";
	public static final String pw_homepage_communication_link = "Homepage Communication Link,pw,//a[@id='communicationLink']";
	public static final String pwcommunication_TestCommunication = "Test Communication,pw,//input[@name='testCommunication']";
	public static final String pwcommunicationpage_gobutton = "Go Button,pw,//button[.='GO']";
	public static final String pwSplitTotalCounts = "SplitTotalCounts,pw,//div[contains(@class,'rs-split-to')]//div//span/..";
	public static final String pwSplitGroupCount = "SplitGroupCount,pw,(//div[@class='rs-split-slider-bottom']//.//span[@class='rs-split-bottom-label-number'])";
	public static final String pwSplitGroupPercents = "SplitGroupPercents,pw,(//div[@class='rs-split-slider-bottom']//.//span[@class='rs-split-bottom-label-number']//span)";
	public static final String pwSplitSelection = "SplitSelection,pw,//span[.='Split ']";
	public static final String pwSplitSubjectLineInput = "SplitSubjectLineInput,pw,//input[@name='split";
	public static final String pwSplitPersonalizeIcon = "SplitPersonalizeIcon,pw,//i[@class='icon-rs-import-file-edge-large icon-lg ']";
	public static final String pwSplitPersonaList = "SplitPersonaList,pw,//div[@class='css-scrollbar']//div";
	public static final String pwemailImportZip = "EmailImportZip,pw,//i[@class='icon-rs-import-file-edge-large icon-lg ']";
	public static final String pwEmailScheduleTime = "EmailScheduleTime,pw,//td[contains(@title,'";
	public static final String pwEmailScheduleHours = "EmailScheduleHours,pw,//span[@class='rs-schedule-hours']";
	public static final String pwEmailScheduleMinutes = "EmailScheduleMinutes,pw,//span[text()='minute']/..//li[position()=";
	public static final String pwEmailScheduleSetTime = "EmailScheduleSetTime,pw,//button[@class='rs-set-time']";

	public static final String pwMessagingSenderId = "email error,pw,//div[@id='rs_Messaging_SenderId']//span[@aria-haspopup='listbox']";
	public static final String pwCommunicationTypeListbox = "pwcommunicationpage_communicationtype_listbox,pw,//ul[@role='listbox']";
	public static final String pwEmailReceiptClick = "pwcommunicationpage_email_receip_click,pw,//input[@id='emailRecipient']";
	public static final String pwAudienceList = "pwcommunicationpage_AudienceList,pw,//div[@id='rs_Audience_List']";
	public static final String pwAudienceCount = "pw,pw,//small[@class='position-absolute right15']";
	public static final String pwLanguageDropdown = "Language,pw,//span[contains(@aria-label,'Language')]//span[contains(@class,'k-input-value-text')]";
	public static final String pwErrorContainer = "errorContainer,pw,//div[contains(@class,'errorContainer')]//..//label";
	public static final String pwSmsTemplateId = "SMS template id,pw,#rs_SplitAB_templadeIdName";
	public static final String pwSmsSelectPersonalization = "pwcommunicationsms_selectpersonalization,pw,//button[@id='personalization']";
	public static final String pwEnterSmsContent = "pwcommunicationsms_Entersmscontent,pw,//textarea[@id='smsContent']";

	// Common Dropdowns & Listboxes
	public static final String pwCommunication_TypeListbox = "pwcommunicationpage_communicationtype_listbox,pw,//ul[@role='listbox']";

	// WhatsApp Elements
	public static final String pwCommunication_Whatsapp_Tab = "Whatsapp tab,pw,//i[contains(@class,'whatsapp')]";
	public static final String pwCommunication_Whatsapp_AlertMessage = "pw,pw,//div[contains(@class,'modal-content')]//div//p";
	public static final String pwCommunication_Whatsapp_OKButton = "Whatsapp tab click,pw,//button[.='OK']";
	public static final String pwCommunication_Whatsapp_SenderDomain = "pwcommunicationwhatsapp_senderdomainclick,pw,//div[@id='senderDomain']";
	public static final String pwCommunication_Whatsapp_AudienceList = "pwcommunicationpage_AudienceList,pw,//div[@id='rs_Audience_List']";
	public static final String pwCommunication_Whatsapp_AudienceCount = "pw,pw,//small[@class='position-absolute right15']";
	public static final String pwCommunication_Whatsapp_LanguageDropdown = "pwcommunicationwhatsapp_Templatelanguageclick,pw,//span[contains(@aria-label,'Template Language')]";
	public static final String pwCommunication_Whatsapp_TemplateName = "pwcommunicationwhatsapp_templatenameclick,pw,//div[@id='rs_Messaging_templateName']//span[@aria-haspopup='listbox']";
	public static final String pwCommunication_Whatsapp_ContentField = "pwcommunication_whatsapp_enterwhatsappcontent,pw,//textarea[@id='whatsappContent']";
	public static final String pwCommunication_Whatsapp_CharCounter = "pw,pw,//span[@class='emr-length']";
	public static final String pwCommunication_Save_Button = "pw,//div[@class='rsmdc-footer w-100 modal-footer']//button[.='Save']";
	public static final String pwCommunication_Schedule_Time = "pw,//td[contains(@title,'March 10, 2025')]//span";
	public static final String pwCommunication_Schedule_Hours = "pw,//select[@id='rs_email_schedule_hours']//option[@value='10']";
	public static final String pwCommunication_Schedule_Minutes = "pw,//span[text()='minute']/..//li[position()='2']";
	public static final String pwCommunication_SmartLink_Input = "enter value,pw,//input[@name='smartLink1[1].appScreenNew']";
	public static final String pwCommunication_Generate_SmartURL = "pw,//button[@id='generateSmartUrl']";
	public static final String pwCommunication_Save_SmartURL = "pw,//button[@id='saveSmartUrl']";
	public static final String pwCommunication_WebPush_SendTo = "pw,//button[@id='sendWebPushTo']";
	public static final String pwCommunication_WebPush_Provider_Error = "Webpush provider error,pw,//div[@id='rs_Notification_name']//span[@aria-haspopup='listbox']";
	public static final String pwCommunication_CommunicationType_Listbox = "pw,//ul[@role='listbox']";
	public static final String pwCommunication_WebPush_Audience_Error = "Web push audience error,pw,//div[contains(@class,'k-multisel')]//..//label";
	public static final String pwCommunication_Audience_Input = "pw,//input[@aria-haspopup]";
	public static final String pwCommunication_Audience_List = "pw,//div[@id='communicationAudienceList']";
	public static final String pwCommunication_Audience_Count = "pw,//small[@class='position-absolute right15']";
	public static final String pwCommunication_WebPush_DeliveryType = "pw,//button[@id='webPushDeliveryType']";
	public static final String pwCommunication_WebPush_DeliveryType_Error = "Webpush push type error,pw,//div[@id='rs_Notification_deliverType']//span[@aria-haspopup='listbox']";
	public static final String pwCommunication_Common_Select_Dropdown = "pw,//ul[@role='listbox']";
	public static final String pwCommunication_Data_Refresh = "pw,#rs_data_refresh";
	public static final String pwCommunication_Confirm_Yes = "pw,//button[.='Yes']";
	public static final String pwCommunication_WebPush_Error_Validation = "Webpush provider error,pw,//div[@class='validation-message top-5 color-primary-red']";
	public static final String pwCommunication_WebPush_Image_Icon = "pw,//button[@id='webPushImageIcon']";
	public static final String pwCommunication_WebPush_Select_Image_URL = "pw,//button[@id='webPushSelectImgURL']";
	public static final String pwCommunication_WebPush_Image_URL_Popup = "pw,//input[@id='webPushImageURL']";
	public static final String pwCommunication_Hashtag_Input = "pw,#rs_SplitAB_Hashtag";
	public static final String pwCommunication_webpushprovider = "Webpush provider error,pw,//div[@class='validation-message top-5 color-primary-red']";
	public static final String pwcommunicationpage_modal_validation_message = "Modal Validation Message,pw,//div[contains(@class,'modal-content')]//div//p";
	public static final String pwcommunicationpage_whatsapp_tab_ok_button = "WhatsApp Tab OK Button,pw,//button[.='OK']";
	public static final String pwmobilepush_audience_error = "Mobile Push Audience Error,pw,//div[contains(@class,'k-multisel')]//..//label";
	public static final String pwnotification_mobpush_pushtype_error = "Mobile Push Type Error,pw,//div[@id='rs_MobileNotification_Pushtype']//span[@aria-haspopup='listbox']";
	public static final String pwnotification_mobpush_layout_error = "Mobile Push Layout Error,pw,//div[@id='rs_MobileNotification_layout']//span[@aria-haspopup='listbox']";
	public static final String pwmobilepush_iframe = "Mobile Push iFrame,pw,//iframe[@class='k-iframe']";
	public static final String pwmobilepush_bodytext = "Mobile Push Body Text,pw,//div[@class='k-content ProseMirror']";
	public static final String pwnotification_next_button = "Next Button,pw,//button[.='Next']";

	public static final String pwCommunication_MobilePush_Tab = "pw,//button[@id='mobPushTab']";
	public static final String pwCommunication_Whatsapp_OK_Button = "pw,//button[.='OK']";
	public static final String pwCommunication_MobilePush_Push_Type = "pw,//button[@id='mobPushType']";
	public static final String pwCommunication_MobilePush_Inbox_Classification = "pw,//button[@id='mobPushInboxClassification']";
	public static final String pwCommunication_MobilePush_Layout_Position = "pw,//button[@id='mobPushLayoutPosition']";
	public static final String pwCommunication_MobilePush_Title_Text = "pw,//input[@id='mobPushTitleText']";
	public static final String pwCommunication_MobilePush_Content_Frame = "pw,//iframe[@class='k-iframe']";
	public static final String pwCommunication_Web_Analytics_Page = "pw,//button[@id='webPushAnalyticsPlatform']";
	public static final String pwCommunication_Next_Button = "pw,//button[.='Next']";
	public static final String pwCommunication_MobilePush_Body_Text = "pw,//div[@class='k-content ProseMirror']";
	public static final String pwCommunication_MobilePush_Body_Text_Input = "pw,//div[@class='k-content ProseMirror']//p";

	public static final String pwCommunication_WebPush_Content_Error = "pw,//textarea[@id='editorText']";
	public static final String pwCommunication_WebPush_Layout_Error = "pw,//div[@id='rs_MobileNotification_layout']//span[@aria-haspopup='listbox']";
	public static final String pwCommunication_WebPush_Position_Error = "pw,//div[contains(@class,'errorContainer')]//span[@aria-haspopup='listbox']";
	public static final String pwCommunication_WebPush_ImgURL_Error = "pw,//div[contains(@class,'errorContainer')]//label";
	public static final String pwCommunication_MobilePush_Audience_Error = "pw,//div[contains(@class,'k-multisel')]//..//label";
	public static final String pwCommunication_MobilePush_PushType_Error = "pw,//div[@id='rs_MobileNotification_Pushtype']//span[@aria-haspopup='listbox']";
	public static final String pwCommunication_MobilePush_Layout_Error = "pw,//div[@id='rs_MobileNotification_layout']//span[@aria-haspopup='listbox']";
	public static final String pwCommunication_MobilePush_BodyText = "pw,//div[@class='k-content ProseMirror']";
	public static final String pwCommunication_MobilePush_BodyText_Error = "pw,//div[@class='k-content ProseMirror']//p";
	public static final String pwCommunication_MobilePush_Layout = "pw,//button[@id='mobPushLayout']";
	public static final String pwCommunication_WebPush_Error_Container = "Webpush provider error,pw,//div[contains(@class,'errorContainer')]//span[@aria-haspopup='listbox']";
	public static final String pwCommunication_Position_Dropdown = "pw,//span[@aria-label='Position']";
	public static final String pwCommunication_WebPush_Select_Content = "pw,//button[@id='selectContent']";
	public static final String pwCommunication_WebPush_Title_Input = "pw,//input[@id='webPushTitle']";
	public static final String pwCommunication_WebPush_Title_Error = "Webpush provider error,pw,//div[@id='rs_Create_TitleText']//label";
	public static final String pwCommunication_WebPush_Content = "pw,//textarea[@id='editorText']";

	// Error Messages
	public static final String pwCommunication_Error_SenderName = "Whatsapp provider error,pw,//div[@id='rs_Messaging_SenderId']//span[@aria-haspopup='listbox']";
	public static final String pwCommunication_Error_Audience = "SMS error,pw,//div[contains(@class,'k-multisel')]//..//label";
	public static final String pwCommunication_Error_Language = "Language error,pw,//div[contains(@class,'k-multisel')]//..//label";
	public static final String pwCommunication_Error_TemplateName = "Language error,pw,//div[@id='rs_Messaging_templateName']//span[@aria-haspopup='listbox']";
	public static final String pwCommunication_Error_Message = "Language error,pw,//div[@class='validation-message color-primary-red']";
	// Common Listboxes & Dropdowns

	// Scheduling Elements
	public static final String pwCommunication_Schedule_ErrorMessage = "Language error,pw,//p[.='The communication is not scheduled. Do you want to continue?']";
	public static final String pwCommunication_Schedule_SaveButton = "pw,pw,//div[@class='rsmdc-footer w-100 modal-footer']//button[.='Save']";
	public static final String pwCommunication_Schedule_TimeCell = "pw,pw,//td[contains(@title,'{DATE}')]//span";
	public static final String pwCommunication_Schedule_HoursDropdown = "pwcommunicationpage_emailschedule_calendar_TimehoursSelect,pw,//select[@id='scheduleTimeHours']";
	public static final String pwCommunication_Schedule_MinutesDropdown = "pw,pw,//span[text()='minute']/..//li[position()='{MIN}']";

	public static final String pwcommunicationpage_email_settings = ",pw,#rs_Email_settings";
	public static final String pwcommunicationpage_auto_on = "Auto ON,pw,//div[@class='modal-content rsmd-content']//div//span[contains(@class,'switch-on')]";
	public static final String pwcommunicationpage_auto_off = "Auto off,pw,//div[@class='modal-content rsmd-content']//div//span[contains(@class,'switch-off')]";
	public static final String pwcommunicationpage_content_tab = ",pw,//span//span[.='Content']";
	public static final String pwSplitABScheduleModal_Duration = ",pw,#rs_SplitABScheduleModal_Duration";
	public static final String pwSplitABScheduleModal_Hour = ",pw,//button[.='Hour(s)']";
	public static final String pwSplitABScheduleModal_Day = ",pw,//a[.='Day(s)']";

	public static final String pwcommunication_StartDate = "Start Date Field,pw,//div[contains(@class,'rs-kendo-datepicker')]//div[.='Select start date']";
	public static final String pwcommunicationpage_ignorechannel = "Ignore channel,pw,//div[@class='modal-content rsmd-content']//p";
	public static final String pwcommunicationpage_cancelbutton = "Cancel Button,pw,//div[@class='modal-content rsmd-content']//button[.='Cancel']";
	public static final String pwcommunicationpage_sendername = "sender name,pw,#rs_Email_senderName";
	public static final String pwcommunicationpage_senderemail = "sender email,pw,#rs_Email_senderEmailAddress";
	public static final String pwcommunicationpage_emailerror = "email error,pw,//div[contains(@class,'rs-input-wrapper  errorContainer')]//label";
	public static final String pwcommunicationpage_select_audience = ",pw,//div[.='Select audience']";
	public static final String pwcommunicationpage_targetlist = ",pw,//input[@aria-haspopup]";
	public static final String pwcommunicationpage_targetlist_selection = ",pw,//div[contains(@class,'child-animation-container')]//li";
	public static final String pwcommunicationpage_audiencecount = ",pw,//div[@class='align-items-center d-flex justify-content-between']//small";
	public static final String pwcommunicationpage_wordcount = ",pw,//small[@class='bottom5 position-absolute right15']";
	public static final String pwcommunicationpage_tooltip = "tool tip,pw,(//i[@id='circle_question_mark'])[2]";
	public static final String pwcommunicationpage_helptext = ",pw,//ul[@class='rs-tooltip-text-multi']";
	public static final String pwcommunicationpage_textemail = "Text email,pw,//i[contains(@class,'text-document')]";
	public static final String pwcommunicationpage_inbox_firstline = "inbox first line,pw,#rs_TextEditor_inbox_firstline";
	public static final String pwcommunicationpage_emailtextbox = "Email textbox,pw,//div[@contenteditable]";
	public static final String pwcommunicationpage_textbox_persona = "Textbox persona,pw,(//i[contains(@class,'user-question-mark')])[3]";
	public static final String pwcommunicationpage_textbox_smartlink = "Textbox smartlink,pw,//i[@class='icon-rs-smart-link-medium icon-md ']";
	public static final String pwcommunicationpage_smartlink1 = "Smartlink 1,pw,//a[normalize-space()='Smart link 1']";
	public static final String pwcommunicationpage_refresh = "refresh,pw,#rs_data_refresh";
	public static final String pwcommunicationpage_okbutton = "Ok Button,pw,//button[.='OK']";
	public static final String pwcommunicationpage_error_validation = ",pw,//p[@class='color-primary-red position-relative left76']";
	public static final String pwcommunicationpage_import_url = "inbox first line,pw,#rs_Import_CommunicationURL";
	public static final String pwcommunicationpage_error_url = ",pw,//div[contains(@class,'rs-input-wrapper  error')]//label";

	public static final String communication_CreationHeader = "Communication creation Header,xpath,//h1";
	public static final String communication_DateFilter = "date Filter,xpath,//div[@class='rs-daterange-picker date-range-view-container undefined']";
	public static final String communication_FilterDropdown = "Filter dropdown value,xpath,//ul[@class='rs-daterangepicker-list-view']//li";
	public static final String communication_CommunicationFilter = "communication Filter,xpath,//ul[@class='rs-list-group-horizontal']//div[@class='rs-dropdown 2 dropdown']";
	public static final String communication_AllCommunications = "All Communication,xpath,//a[text()='All communications']";
	public static final String communication_ListExpansion = "List Expansion,xpath,//p[.='{COMMUNICATION_NAME}']//ancestor::td//preceding-sibling::td//a[@aria-label='Expand detail row']";
	public static final String communication_AnalyticsHeader = "Analytics Header,xpath,//h1//span";
	public static final String communication_Preview = "Communication Preview,xpath,//div[contains(@class,'commlistpreview')]";
	public static final String COMMUNICATION_CREATION_HEADER = "Communication creation Header,xpath,//h1";
	public static final String COMMUNICATION_DATE_FILTER = "date Filter,xpath,//div[@class='rs-daterange-picker date-range-view-container undefined']";
	public static final String COMMUNICATION_FILTER_DROPDOWN = "Filter dropdown value,xpath,//ul[@class='rs-daterangepicker-list-view']//li";
	public static final String COMMUNICATION_FILTER = "communication Filter,xpath,//ul[@class='rs-list-group-horizontal']//div[@class='rs-dropdown 2 dropdown']";
	public static final String ALL_COMMUNICATIONS = "All Communication,xpath,//a[text()='All communications']";
	public static final String LIST_EXPANSION = "List Expansion,xpath,//p[.='{COMMUNICATION_NAME}']//ancestor::td//preceding-sibling::td//a[@aria-label='Expand detail row']";
	public static final String ANALYTICS_HEADER = "Analytics Header,xpath,//h1//span";
	public static final String COMMUNICATION_PREVIEW = "Communication Preview,xpath,//div[contains(@class,'commlistpreview')]";

	public static final String communication_ActiveChannel = "Active channel,xpath,//ul[contains(@class,'sub-tabs')]//li[contains(@class,'tabDefault active')]";
	public static final String communication_CopyButton = "Copy button,xpath,//i[contains(@class,'icon-rs-copy')]";
	public static final String communication_SmartLink_2 = "Smartlink,xpath,//div[contains(@class,'smartlink-box')]//div[@class='col-sm-7']";
	public static final String communication_AllowButton = "Allow button,xpath,//button[.='Allow']";
	public static final String communication_RenewButton = "Renew button,xpath,//a[@class='flat-button']";
	public static final String communication_NextButton = "Next button,xpath,//button[text()='Next']";
	public static final String communication_WebAnalytics = "Web analytics,xpath,//i[contains(@class,'icon-rs-web-analytics-large icon-lg')]";

	public static final String communication_ListingPage_CreateCommunication = "Listing page create communication,xpath,//button[contains(text(),'Create Communication')]";
	public static final String communication_SocialPost_PostName = "Social post name,xpath,//input[@name='postName']";
	public static final String communication_SocialPost_Poston = "Social post post on,xpath,//span[contains(@aria-label,'ost on')]";
	public static final String communication_SocialPost_BoostButton = "Social post boost button,xpath,//button[contains(@class,'boost-toggle')]";
	public static final String communication_SocialPost_Target = "Social post target,xpath,//button[contains(@class,'target-audience')]";
	public static final String communication_FacebookActiveTab = "FB active,xpath,//span[.='Facebook']/ancestor::li[contains(@class,'tabDefault active')]";
	public static final String communication_IgnoreChannelWarning = "Ignore channel warning,xpath,//p[.='Are you sure you want to ignore this channel']";

	public static final String communication_SmartLink1 = "Smart link 1,xpath,//a[contains(@class,'dropdown-item')]";
	public static final String communication_PostLinkMandate = "Post link mandate field,xpath,//input[@name='postLink']/../label//span";
	public static final String communication_InvalidWebsiteError = "Invalid website error message,xpath,//label[text()='Invalid website']";
	public static final String communication_TrendingTopicsLabel = "Trending topics label,xpath,//label[text()='#Trending topics']";
	public static final String communication_PopoverBody = "Trending topics popover body,xpath,//div[@class='multi-column popover-body']";
	public static final String communication_TrendingTopicsInput = "Trending topics input,xpath,//input[contains(@class,'trending-topics-input')]";
	public static final String communication_TagOmnichannel = "Omnichannel tag,xpath,//li[@class='rs-tag'][.='#Omnichannel']";
	public static final String communication_TagResulticks = "Resulticks tag,xpath,//li[@class='rs-tag'][.='#Resulticks']";

	public static final String communication_TargetCountry = "Target Country,xpath,//span[@class='k-input-value-text'][.='India']";
	public static final String communication_GenderSelection = "Gender selection,xpath,//div[contains(@role,'group')]//button";

	// MkStr - WhatsApp

	public static final String communicationplan_notificationchannel = "Notification channel check,xpath,//input[@id='channelTypes[2].selected']";

	public static final String communicationauthoring_mobileiconclick = "Communication authoring mobile icon click,xpath, //i[@class='icon-mobile-medium icons-lg']";
	public static final String communicationauthoring_whatsappiconclick = "Communication authoring whatapp icon click,xpath, //i[@class='icon-whatsapp-xmedium icons-lg']";

	public static final String communicationwhatsapp_senderdomainclick = "Whatsapp sender domain,xpath,//span[@aria-label='Sender name']//span[@class='k-input-value-text']";
	public static final String communicationwhatsapp_senderdomainselect = "Whatsapp sender select,xpath, //ul[@role='listbox']/li";
	public static final String communicationwhatsapp_audienceclick = "Whatspp audience click,xpath,//input[@placeholder='-- Select the list --']";
	public static final String communicationwhatsapp_audienceselect = "Whatsapp audience,xpath, //ul[@role='listbox']/li";
	public static final String pwcommunicationwhatsapp_senderdomainclick = "Whatsapp sender domain,pw,//span[@aria-label='Sender name']//span[@class='k-input-value-text']";

	public static final String communicationwhatsapp_Templatelanguageclick = "Whatsapp template language click,xpath,//span[contains(@aria-label,'Template language')]//span[contains(@class,'k-input-value-text')]";
	public static final String communicationwhatsapp_TemplatelanguageSelect = "WhatsApp template language select,xpath, //ul[@class='k-list k-reset']/li";
	public static final String communicationwhatsapp_templatenameclick = "Whatsapp template name click,xpath,//span[@aria-label='Template name']//span[@class='k-input-value-text']";
	public static final String communicationwhatsapp_templatenameselect = "Whatsapp template name click,xpath, //ul[@role='listbox']/li";
	public static final String communicationwhatsapp_authoringpagepersonaclick = "Whatsapp persona click,xpath,//i[@class='icon-user-help-small blue icons-md']";
	public static final String communicationwhatsapp_authoringpagepersonaselect = "Whatsapp persona select,xpath, //ul[@role='menu']/li";
	public static final String communicationwhatsapp_authoringpage_videoicon = "Whatsapp video icon,xpath, //i[@class='icon-video-large blue icon-lg ']";
	public static final String communicationwhatsapp_authoringpage_videourl = "Whatsapp video url,xpath, //li[@role='menuItem']";
	public static final String communicationwhatsapp_authoringpage_videotype_click = "Whatsapp select video type click,xpath, //span[@class='k-dropdown-wrap k-state-focused']";
	public static final String communicationwhatsapp_authoringpage_videotype_select = "Whatsapp select video type select,xpath, //ul[@class='k-list k-reset']/li";
	public static final String communicationwhatsapp_authoringpage_imageiconclick = "Whatsapp image icon,xpath, //i[@class='icon-sd-image-medium blue icons-md ']";
	public static final String communicationwhatsapp_authoringpage_imagedropdown_select = "Whatsapp image dropdown select,xpath, //*[@role='menu']/li";
	public static final String communicationwhatsapp_authoringpage_image_enterurl = "Whatsapp image enter media url,xpath, //input[@placeholder='Enter a valid URL']";
	public static final String communicationwhatsapp_authoringpage_imagetypeclick = "whatsapp image type select,xpath, //div[@class='modal-body']//div[@class='position-relative']";
	public static final String communicationwhatsapp_authoringpage_imagetypeselect = "whatsapp image enter media url image type select,xpath, //*[@class='k-list k-reset']/li";
	public static final String communicationwhatsapp_authoringpage_mediasavebutton = "whatsapp media save button,xpath, (//button[contains(@class,'rsp-primary-button')])[3]";
	public static final String communicationwhatsapp_authoringpage_whatsappimagepreview = "whatsapp preview image,xpath, //img[@class='preview-img']";
	public static final String communicationwhatsapp_authoringpage_whatsapptestmessage = "whatsapp test number,xpath, //*[text()='Send test WhatsApp message to']/..//following::input[contains(@class,'slashText')]";
	public static final String communicationwhatsapp_authoringpage_pdficon = "whatsapp pdf icon,xpsth, //I[@class='icon-sd-pdf-medium blue icon-lg ']";
	public static final String communicationpage_email_fname = "Sender name,id,FromName";
	public static final String pwcommunicationwhatsapp_Templatelanguageclick = "Whatsapp template language click,pw,//span[contains(@aria-label,'Template language')]//span[contains(@class,'k-input-value-text')]";
	public static final String pwcommunicationwhatsapp_templatenameclick = "Whatsapp template name click,pw,//span[@aria-label='Template name']//span[@class='k-input-value-text']";

	// NEW - RESUL 5.0 CHANGES

	public static final String communicationpage_communicationcreate = "create communication,xpath,//a[normalize-space()='Create communication']";
	public static final String communicationpage_singledimen_link = "Single dimension,xpath,//i[contains(@class,'communication-sdc')]";
	public static final String communicationpage_communicationname_textbox = "Communication name,xpath,//input[@name='communicationName']";
	public static final String communicationpage_channel_type1 = "Channel Email,xpath,//input[@id='channelTypes[0].selected']";
	public static final String communicationpage_Gallery = "create communication,xpath,//a[normalize-space()='Gallery']";
	public static final String pw_communicationpage_communicationcreate = "create communication,pw,//a[normalize-space()='Create communication']";
	public static final String Pwcommunicationpage_singledimen_link = "Single dimension,pw,//i[contains(@class,'communication-sdc')]";
	public static final String pwcommunicationpage_communicationname_textbox = "Communication name,pw,//input[@name='communicationName']";
	public static final String pwcommunicationpage_communicationname_errormsg = "error message,pw,//div[contains(@class,'errorContainer')]//label";
	public static final String pwcommunicationpage_channel_type1 = "Channel Email,pw,//input[@id='channelTypes[0].selected']";

	// a[normalize-space()='Gallery']

	// whatsapp authouring page 28-06

	public static final String whatsapp_authoring_imageupload = "Image upload,xpath,//i[@title='Image upload']";
	public static final String whatsapp_authoring_imageuploadoptios = "Image options,xpath,//div[@class='dropdown-menu show']";
	public static final String whatsapp_authoring_imageurl = "Image url option,xpath,//a[.='Image URL']";
	public static final String whatsapp_authoring_urlinput = "Input image url,xpath,//input[@name='previewImage']";
	public static final String whatsapp_authoring_urlupload = "Upload button,xpath,//button[@type='button'][.='Upload']";
	public static final String whatsapp_authoring_previewimage = "Preview image,xpath,//div[@class='whatsapp-bubble-receive-wrapper']//img[@src]";
	public static final String whatsapp_authoring_removeimg = "Remove image,xpath,//a[@role='button'][contains(.,'Remove')]";
	public static final String whatsapp_authoring_preview = "Eye icon,xpath,//i[@title='Preview']";
	public static final String whatsapp_authoring_livepreviewtemp = "Eye icon,xpath,//i[@title='Preview']";
	public static final String whatsapp_authoring_livepreviewclose = "Close live preview,xpath,//i[@id='rs_circle_close_edge']";
	public static final String whatsapp_authoring_videoupload = "Video upload,xpath,//i[@title='Video upload']";
	public static final String whatsapp_authoring_videourl = "Video URL,xpath,//a[@role='button'][.='Video URL']";
	public static final String whatsapp_authoring_removevideourl = "Remove Video URL,xpath,//a[@role='button'][.='Remove URL']";
	public static final String whatsapp_authoring_videopreview = "Video preview,xpath,//div[@class='whatsapp-bubble-receive-wrapper']//video";
	public static final String whatsapp_authoring_pdfUpload = "PDF upload,xpath,//i[@title='PDF upload']";
	public static final String whatsapp_authoring_pdfoption = "PDF Optios,xpath,//a[@role='button'][.='Document URL']";
	public static final String whatsapp_authoring_pdfpreview = "PDF preview,xpath,//i[contains(@class,'pdf-download')]";
	public static final String whatsapp_authoring_pdfRemove = "Remove PDF,xpath,//a[@role='button'][.='Remove URL']";
	public static final String whatsapp_authoring_emoji = "Emoji,xpath,//li[not(@class='click-off')]//i[@title='Emoji']";

	// Listing page 01-07

	public static final String listingpage_communicationlistingbtn = "Communciation listing,xpath,//div[@class='dropdown-menu show']//a[.='Communication listing']";
	public static final String listingpage_gallery = "Gallery,xpath,//div[@class='dropdown-menu show']//a[.='Gallery']";
	public static final String listingpage_planer = "Planner,xpath,//div[@class='dropdown-menu show']//a[.='Planner']";
	public static final String listingpage_header = "Communication Header,xpath,//h1";
	public static final String listingpage_channelicon = "Channel icon,xpath,//div[contains(@class,'social-icon bg')]//i[contains(@class,'medium icon-md white')][not (contains(@class,'icon-rs-web-analytics-medium icon-md white'))]";
	public static final String listingpage_webanalyticsicon = "Web analytics icon,xpath,//div[contains(@class,'social-icon bg-web-analytics')]";
	public static final String listingpage_clickcommunicationbtn = "Create communication(+ icon),xpath,//i[contains(@id,'circle_plus')]";
	public static final String listingpage_duplicate = "Duplicate,xpath,//div[@class='css-scrollbar']//a[.='Duplicate']";
	public static final String listingpage_createcommunication = "Create communication (+) icon,xpath,//i[contains(@id,'data_circle')]";
	public static final String listingpage_createcommunicationhead = "Create communication head,xpath,//h1[.='Communication creation']";
	public static final String listingpage_detailspagenavigation = "Details page,xpath,//i[@id='rs_data_download']";
	public static final String communication_cssdropdown = "Css dropdown,xpath,//div[@class='css-scrollbar']//div[@class]";
	public static final String authoringpage_smartlink = "Smart link,xpath,//i[contains(@class,'icon-rs-editor-smart-link')]";
	public static final String authoringpage_smartlink1 = "Smart link 1,xpath,//a[.='Smart link 1']";
	public static final String authoringpage_smartlinksms = "Smart link,xpath,//i[contains(@class,'icon-rs-editor-smart-link')]";

	// Social post

	public static final String socialpost_facebookchannel = "Facebook channel,xpath,//i[contains(@class,'social-facebook')]/ancestor::li[contains(@class,'tabDefault')]";
	public static final String socialpost_twitterchannel = "twitter channel,xpath,//i[contains(@class,'social-twitter')]/ancestor::li[contains(@class,'tabDefault')]";
	public static final String socialpost_instagramchannel = "Instagram channel,xpath,//i[contains(@class,'social-instagram')]/ancestor::li[contains(@class,'tabDefault')]";
	public static final String socialpost_linkedinchannel = "Linkedin channel,xpath,//i[contains(@class,'social-linkedin')]/ancestor::li[contains(@class,'tabDefault')]";
	public static final String socialpost_postname = "Post name,xpath,//input[@name='postName']";
	public static final String socialpost_poston = "Post on,xpath,//span[@aria-label='Post on']";
	public static final String socialpost_textbox = "Text box,xpath,//*[@name='editorText']";
	public static final String socialpost_postlink = "Post link,xpath,//input[contains(@id,'SocialPost_postlink')]";
	public static final String socialpost_trendingtopis = "Trending topics,xpath,//input[contains(@id,'SocialPost_Trendingtopics')]";
	public static final String socialpost_previewText = "Preview,xpath,//div[contains(@class,'live-preview')]//div[contains(.,'view')]";
	public static final String communication_cancelbutton = "Cancel button,xpath,//button[text()='Cancel']";
	public static final String communication_savebutton = "Save button,xpath,//button[text()='Save']";
	public static final String socialpost_boostbutton = "boost,xpath,//span[contains(@id,'SocialPost_Boostpost')]";
	public static final String socialpost_target = "Target,xpath,//i[contains(@id,'SocialPost_communication_target')]";
	public static final String socialpost_country = "country,xpath,//span[@aria-label='Country']";
	public static final String socialpost_agefrom = "Age from,xpath,//span[@aria-label='Age from']";
	public static final String socialpost_ageto = "Age from,xpath,//span[@aria-label='Age to']";
	public static final String socialpost_textfield_emoji = "Emoji,xpath,//i[contains(@id,'RSEmojiPicker_Emoji')]";
	public static final String socialpost_textfield_videoupload = "Video upload,xpath,//i[contains(@title,'Video upload')]";
	public static final String socialpost_textfield_smartlink = "Smart link,xpath,//li[contains(@title,'Insert SmartLink')]";
	public static final String socialpost_textfield_preview = "Text field Preview,xpath,//li[contains(@id,'data_eye')]";
	public static final String socialpost_preview = "Preview,xpath,//div[@class='post-content']";
	public static final String socialpost_textfield_preview_close = "Preview close,xpath,//i[contains(@id,'circle_close_edge')]";
	public static final String socialpost_textfield_preview_text = "Preview text,xpath,//div[contains(@class,'modal-content')]//span";
	public static final String socialpost_textfield = "Text field,xpath,//*[contains(@name,'editorText')]";
	public static final String socialpost_topics_questionmark = "Question mark,xpath,//i[@id='circle_question_mark']";

	// Paid ads

	public static final String paidads_adtype = "Ad type,xpath,//span[@aria-label='Ad type']";
	public static final String paidads_adname1 = "Ad name 1,xpath,//input[@name='adsName[0].name']";

	// 16-09-2024

	public static final String gallerypage_datefilter = "Date filter,xpath,//span[@class='rs-dt-calendar-text']";
	public static final String gallerypage_datefiltertypes = "Date filter types,xpath,//ul[contains(@class,'rs-daterangepicker-list-view')]//li";
	public static final String gallerypage_channelfilter = "Email default,xpath,//ul[@class='rs-list-group-horizontal']//span[@class='k-input-value-text']";
	public static final String gallerypage_channelfiltertypes = "Channel types,xpath,//ul[contains(@role,'listbox')]//li";
	public static final String gallerypage_smspreview = "SMS message,xpath,//div[@class='message']";
	public static final String gallerypage_search = "Search page,xpath,//i[@id='rs_data_zoom']";
	public static final String gallerypage_searchBox = "Search box,xpath,//input[@name='search']";
	public static final String Precommuniationpage_Limit = "Limit,xpath,//i[contains(@class,'icon-rs-user-list')]";
	public static final String Precommuniationpage_Limit_One_time = "Limit One Time,xpath,//label//span//span[.='One time']";
	public static final String Precommuniationpage_Limit_One_time_Audience = "Limit Audience,xpath,//h4//span";
	public static final String Precommuniationpage_Limit_One_time_AudienceInput = "Limit Audience,xpath,//input[@name='Email.limitCount']";
	public static final String Precommuniationpage_SMSLimit_One_time_AudienceInput = "Limit Audience,xpath,//input[@name='SMS.limitCount']";
	public static final String Precommuniationpage_smsLimit_One_time_Agree = "Limit One Time,id,SMS.limitCountAgree";

	public static final String Precommuniationpage_Limit_One_time_Agree = "Limit One Time,id,Email.limitCountAgree";
	public static final String Precommuniationpage_Limit_One_time_Sumbit = "Limit One Time,xpath,//button[.='Submit']";
	public static final String Precommuniationpage_Limit_One_PotentialAudience = "Limit Audience,xpath,//h5[.='Potential target audience']//following-sibling::h1";
	public static final String Precommuniationpage_Limit_One_Scrubbed = "Limit Audience,xpath,//h5[.='Scrubbed by limit cap']//following-sibling::div//h1";
	public static final String Precommuniationpage_Limit_by_day = "Limit One Time,xpath,//label//span//span[.='By day']";
	public static final String Precommuniationpage_Limit_by_day_Type = "Limit One Time,xpath,//span[@aria-label='Select']";
	public static final String Precommuniationpage_Limit_by_day_AudienceInput = "Limit Audience,xpath,//input[@name='Email.volumePerDay']";
	public static final String Precommuniationpage_Limit_by_day_Arrow = "Limit One Time,xpath,//i[contains(@class,'icon-rs-circle-arrow')]";
	public static final String Precommuniationpage_Limit_by_day_volumeperday = "Limit Audience,xpath,(//div[contains(@class,'border')]//..//..//span[position()>=1])[2]";
	public static final String Precommuniationpage_Limit_by_day_Split_schedule = "Limit Audience,xpath,//h5[.='Split schedule']//following-sibling::div//h1";
	public static final String Precommuniationpage_Limit_One_Info = "Limit One Time,id,rs_data_circle_info";
	public static final String Precommuniationpage_Limit_One_Info_Table = "Limit one time Table,xpath,//div[@class='limitaudiencetime col']//div//table";
	public static final String Precommuniationpage_Limit_One_Info_row = "Limit One Time,tag,tr";
	public static final String Precommuniationpage_Limit_One_Info_header = "Limit One Time,xpath,//tr[@role='row']//th";
	public static final String Precommuniationpage_Limit_One_Info_data = "Limit One Time,xpath,//table//tr[@role='row']//td";

	public static final String authoringpage_provider = ",xpath,//label[normalize-space()='Provider']";
	public static final String authoringpage_whatsappconfirmpreview = "Confirm preview,xpath,(//button[.='Save'])[2]";
	public static final String webpush_interactivitydropdown = "Interactivity,xpath,//div[@class='row'][contains(.,'Interactivity')]//span[contains(@class,'thumb')][contains(@class,'round')]";
	public static final String webpush_interactivitybutton = "Interactivity button,xpath,//span[contains(@aria-label,'Button type')]//span[contains(@class,'k-input-value-text')]";
	public static final String communicationpage_emailschedule_emailtimezonelist = "Timezone,xpath,//label[.='Time zone']//..//..//span[@class='k-input-value-text']";
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static final String communicationpage_emailtimezoneicon = "Time zone icon,xpath,//i[contains(@class,'pencil-edit-mini')]";
	public static final String communicationpage_communicationtype_listbox = "Communication type listbox,xpath,//div[contains(@class,'child-animation-container')]//li";
	public static final String communicationpage_emailschedule_time = "Schedule time,xpath,//input[@role='combobox'][contains(@title,'schedule')]";
	public static final String communicationpage_emailschedule_datepopupactive = "Time calendar popoup active,xpath,//table[contains(@class,'calendar-table')]";
	public static final String communicationpage_emailschedule_calendar_TimehoursSelect = "schedule time select,xpath,//span[text()='hour']/..//li[position()=1]";
	public static final String communicationpage_emailschedule_calendar_TimehoursSelect2 = "schedule time select,xpath,//span[text()='hour']/..//li[position()=2]";

	public static final String communicationpage_emailschedule_calendar_TimeminsSelect = "schedule mins select,xpath,//span[text()='minute']/..//li[position()=1]";
	public static final String communicationpage_emailschedule_calendar_Timeset = "schedule time set,xpath, //button[@title='Set']";
	public static final String notification_mobpush_testmailto = "test cmmunication dropdown,xpath,//span[@aria-label='Select/Enter email address']";
	public static final String notification_mobpush_testmailenter = "communication email,xpath,//input[@name='approvalList.testEmail']";
	public static final String notification_mobpush_testcommSent = "communication email send,xpath,//button[.='Send']";
	public static final String communicationpage_smarturl_save = "Smarturl save button,xpath,//h2[.='Smart link']//..//..//button[.='Save']";
	public static final String notification_mobpush_expiryswitchONOFFbutton = "expiry button,xpath, (//span[@role='switch'])[3]";
	public static final String pwcommunicationpage_communicationtype_listbox = "Communication type listbox,pw,//div[contains(@class,'child-animation-container')]//li";
	public static final String pwcommunicationpage_smarturl_save = "Smarturl save button,pw,//h2[.='Smart link']//..//..//button[.='Save']";
	public static final String pwcommunicationpage_emailschedule_time = "Schedule time,pw,//input[@role='combobox'][contains(@title,'Schedule')]";
	public static final String pwcommunicationpage_emailschedule_calendar_TimehoursSelect = "schedule time select,pw,//span[text()='hour']/..//li[position()=1]";
	public static final String pwcommunicationpage_emailschedule_calendar_Timeset = "schedule time set,pw, //button[@title='Set']";
	public static final String pwcommunicationpage_emailtimezoneicon = "Time zone icon,pw,//i[contains(@class,'pencil-edit-mini')]";
	public static final String pwcommunicationpage_emailschedule_emailtimezonelist = "Timezone,pw,//span[@class='k-input-value-text'][contains(.,'GMT')]";
	public static final String communicationpage_select_qr_imagesize = "Image px size,xpath,//small[@class='position-relative top-10 text-center']";
	public static final String communicationpage_select_qr_shorturl = "short url,xpath,//span[.='Short URL']/..//div//span[@class='k-switch-thumb k-rounded-full']";
	public static final String communicationpage_select_qr_shorturl_captcha = ",xpath,//canvas/..//figcaption";
	public static final String communicationpage_select_qr_shorturl_ = ",xpath,//div[@class='col-sm-10']/..";
	public static final String communicationpage_select_qr_slide = ",xpath,//div[@class='position-relative col-sm-10']/input";
	public static final String communicationpage_select_qr_url_content = "url,id,rs_QRContent_CommunicationURL";
	public static final String communicationpage_webpush_confirmation = "Confirm preview,xpath,//div[contains(@class,'modal-content')]";
	public static final String communicationpage_validation_time = "Validation message,xpath,//div[@class='validation-message'][contains(.,'later than 15')]";
	public static final String communicationpage_webpush_savebutton = "(//button[.='Save'])[2]";
	public static final String popupclosebutton = "close,id,rs_circle_close_edge";
	public static final String notification_webpush_selectbrowseimage = "Browse Image tab,xpath,//a[.='Browse image']";
	public static final String notification_webpush_selectbrowseimage_upload = "Logo upload,xpath,//h2[text()='Upload image']//..//..//input";

	// COMMUNICATION QR
	public static final String communicationpage_select_qr_recipientreach = "Qr recipient,xpath, //input[@id='rs_QRContent_audiencereach']";
	public static final String communicationpage_qr_communicationurl = "Qr communicaion Url,xpath,//input[@id='rs_QRContent_CommunicationURL']";
	public static final String communicationpage_select_qr_url = "Qr url,xpath, //a[@target='_blank'][contains(.,'PNG')]";
	public static final String communicationpage_select_qr_redirecturl = "Redirect url,xpath, //input[@id='rs_QRContent_RedirectionalURL']";
	public static final String communicationpage_qruploadLogo = "Logo upload,xpath,//input[@id='rs_QRContent_logoUpload']";
	public static final String communicationpage_scrollto = ",xpath, //ul[@class='nav nav-tabs tabs-fixed tabs-qr qrnavtabs']";
	public static final String communicationpage_qrwebKYCCheck = "Web KYC on off check,xpath,(//span[contains(@class,'k-switch k-switch-md k')])[1]";
	public static final String communicationpage_qr_kyc_btn = "KYC button,xpath,//span[@id='31b697f3-4188-49bc-af12-1594ea5a5c55']";
	public static final String communicationpage_qr_kycFormDropDown = "KYC Form dropdown,xpath,//div[contains(@class,'rs-kendo-dropdownmenu-wrappe')]//span//span//span[contains(@class,'k-input-inner')]//span";
	public static final String communicationpage_qr_kycFormDropDownList = "KYC Form dropdown list,xpath,//ul[@id='QRFormId_listbox']/li";
	public static final String communicationpage_qr_kycFormPreview = "KYC Form preview,xpath,//i[@id='rs_data_eye']";
	public static final String communicationpage_qr_kycFormPreviewClose = "KYC Form preview close,xpath,//i[@id='rs_circle_close_edge']";
	public static final String communicationpage_select_qr_slider = "Qr slider,xpath,(//div[contains(@class,'qrslider')]/a)[1]";
	public static final String communicationpage_select_qr_genclick = "Qr generate button,xpath,//button[@id='rs_QRContent_Generate']";
	public static final String communicationpage_qr_scancodeUrl = ",xpath, //*[@id='txtUrlShortenURLforshortcode']";
	public static final String communicationpage_select_qr_dwnldtoogle = "Qr download button,xpath,//i[@id='rs_data_download']";
	public static final String communicationpage_startdate_dwnldpng = "Download format listbox,xpath, //*[@id='divurlQrCodeDownload_new']/li";
	public static final String communicationpage_qr_downloadchannelwise = "Download channel wise,xpath,//div[@class='tab-pane active']//div[contains(@class,'downloadQrCode')]";
	public static final String communicationpage_qr_downloadformatwise = "Download format listbox,xpath,//div[@class='tab-pane active']//*[contains(@id,'QrCodeDownload_new')]/li";
	public static final String communicationpage_select_qr_clicksave = "Qr save button,xpath,//button[@id='rs_QRContent_Save']";
	public static final String communicationpage_qr_communicationsList = "QR communication list,xpath,//*[contains(@class,'tabs-qr qrnavtabs')]//li";
	public static final String communicationpage_qr_SMScomm_PotentialAudience = "Potential audience,id,rs_QRContent_audiencereach";
	public static final String communicationpage_qr_SMScomm_MobileNo = "Mobile number,xpath,//input[@class='form-control ']";
	public static final String communicationpage_qr_SMScomm_msgContent = "Message Content,xpath,//textarea[@name='message']";
	public static final String communicationpage_qr_SMScomm_redirectionURL = "Redirction URL,id,rs_QRContent_RedirectionalURL";
	public static final String communicationpage_qr_SMScomm_Apply = "Apply button,xpath,//button[.='Generate']";
	public static final String communicationpage_qr_SMScomm_QRcode = "QR Code,xpath,//canvas";
	public static final String communicationpage_qr_SMS = "QR SMS,xpath,//i[contains(@class,'rs-mobile-sms')]//..//span";

	//////////////////
	public static final String notification_mobpush_alertdropdown = "alert sound options,xpath,//span[@aria-label='Alert sound']";

	public static final String notification_mobpush_alertswitchONOFF = "alert sound ,xpath,//div[@class='row'][contains(.,'Alert sound')]//span[contains(@class,'k-switch k-switch-md')]";
	public static final String notification_mobpush_MakealertswitchONOFF = " Make alert  ,xpath,//div[@class='row'][contains(.,'Make alert')]//span[contains(@class,'k-switch k-switch-md')]";
	public static final String notification_mobpush_Makealert_titletext = "Title ,xpath,//input[@name='title.text']";
	public static final String notification_mobpush_MakeAlert_personalization = "personalization,xpath,(//i[contains(@class,'user-question')])[1]";
	public static final String notification_mobpush_MakeAlert_short_description = " short secription,xpath,//input[@name='shortDesc.text']";
	public static final String notification_mobpush_MakeAlert_short_description_personalization = "personalization,xpath,(//i[contains(@class,'user-question')])[2]";
	public static final String Notification_MP_MakeAlert_title_emoji = "title emoji,xpath,(//i[@id='rs_RSEmojiPicker_Emoji'])[1]";
	public static final String Notification_MP_MakeAlert_sub_descrption_emoji = "title emoji,xpath,(//i[@id='rs_RSEmojiPicker_Emoji'])[2]";
	public static final String Communication_Frequency_cap = "Frequency cap,xpath,//i[contains(@class,' icon-rs-user-c')]";
	public static final String Communication_Frequency_cap_onoffbutton = "Frequency cap,xpath,//span[@class='k-switch-track k-rounded-full']";
	public static final String Communication_frequency_cap_okbutton = "ok ,id,rs_FrequencyCapModal_Ok";
	public static final String Communication_frequency_cap_errormsg = "error ,xpath,//label[@class='k-label']";
	public static final String Communication_Content_Header = "Headder ,xpath,//div[@class='portlet-header']//h4[.='Content']";
	public static final String Communication_Content_Headings = "Headder value ,xpath,//ul[@class='d-flex campaign-lists mt7']//h5";
	public static final String Communication_Content_Headings_value = "value ,xpath,//ul[@class='d-flex campaign-lists mt7']//h1";
	public static final String Communication_Content_SDK = "SDK Status ,xpath,//div[contains(@class,'portlet-body d-flex')]//div//h4";
	public static final String Communication_Content_SDK_link = "SDK Link,xpath,//div[contains(@class,'portlet-body d-flex')]//div//i//following-sibling::a";
	public static final String Communication_Content_Linkverification = "link verification ,xpath,//ul[@class='justify-content-between']//li//h4";
	public static final String Communication_Content_Linkverification_link = "Link ,xpath,//ul[@class='justify-content-between']//div//a";
	public static final String Communication_Tag = "tag,id,rs_DeliveryMethod_tagplus";
	public static final String Communication_Tag_value = "tagvalue,xpath,//input[@placeholder='Enter keywords']";
	public static final String Communication_Tagsavebutton = "tag save,xpath,//div[@class='modal-content rsmd-content']//button[.='Save']";
	public static final String Communication_serfviceand_commuincation = "service,id,isServiceMandatoryComm";
	public static final String Communication_roi = "ROI,id,rs_DeliveryMethod_ROI";
	public static final String Communication_personalization = "Personlization,id,rs_Email_personalization";
	public static final String Communication_replymail = "mail,id,isReplyMailEnabled";
	public static final String Communication_alyrtnatemail = "mail,id,rs_Email_alternateemailid";
	public static final String Communication_ROI = "Fixed Roi,id,rs_ROIContent_fixedCostAmount";
	public static final String Communication_ROI_reach = "ROI Reach,id,rs_ROIContent_Reach";
	public static final String Communication_ROI_expected = "ROI Reach,id,rs_ROIContent_expectedROI";
	public static final String Communication_Email_inboxPreview = "inbox preview,xpath,//input[@id='rs_TextEditor_inbox_firstline']";
	public static final String Communication_roi_edit = "Edit,id,rs_DeliveryMethod_edit";
	public static final String Communication_roi_refresh = "refresh,xpath,//div[@class='modal-content rsmd-content']//i[@id='rs_data_refresh']";
	public static final String Communication_roi_Grouping_id = "grouping Id,xpath,//span[@aria-label='Communication grouping ID']";
	public static final String Communication_roi_Grouping_id_manually = "grouping Id,id,rs_CommunicationReferenceModal_groupingidmanually";
	public static final String Communication_roi_Grouping_id_priority = "priority,xpath,//span[@aria-label='Priority']";
	public static final String Communication_roi_Grouping_id_Savebutton = "refernces save ,id,rs_CommuncationReferenceModal_Save";
	public static final String Communication_roi_Grouping_okbutton = "Ok,xpath,//button[.='OK']";

	// ul[@class='justify-content-between']//li//h4
	public static final String communicationListing_editcomm = "Communication edit icon,id,rs_data_pencil_edit";
	public static final String communicationListing_editcommRFA = "Communication edit icon,xpath,//p[.='PLACE_HOLDER']//..//..//i[@id='rs_data_pencil_edit']";

	public static final String CommunicationListing_AdvanceSearchExpandIconClick = "AdvanceSearch ExpandIcon,xpath,//div[contains(@class,'search-container')]//i[@class='icon-rs-caret-mini icon-xs white p5']";
	public static final String CommunicationListing_AdvanceSearchCommunicationnameTF = "AdvanceSearch CommunicationnameTF,name,communication_name";
	public static final String CommunicationListing_AdvanceSearchCommunicationnameValue = "AdvanceSearch Communicationnamevalue,xpath,//div[contains(@class,'box-design box-design')]//li";
	public static final String CommunicationListing_AdvanceSearchCommunicatiotype = "AdvanceSearch CommunicatiotypeTF,xpath,//span[@aria-label='Communication type']";
	public static final String CommunicationListing_AdvanceSearchCommunicatiotypeValue = "AdvanceSearch CommunicatiotypeValue,xpath,//div[@class='k-list-content']//li";
	public static final String CommunicationListing_AdvanceSearchProducttype = "AdvanceSearch Producttype ,xpath,//span[@aria-label='Product type']";
	public static final String CommunicationListing_AdvanceSearchProducttypeValue = "AdvanceSearch ProducttypeValue ,xpath,//div[@class='k-list-content']//li";
	public static final String CommunicationListing_AdvanceSearchChanneltype = "AdvanceSearch Channeltype ,xpath,//span[@aria-label='Channel type']";
	public static final String CommunicationListing_AdvanceSearchChanneltypeValue = "AdvanceSearch ChanneltypeValue ,xpath,//div[@class='k-list-content']//li";
	public static final String CommunicationListing_AdvanceSearchSubmit = "AdvanceSearch Submit ,xpath,//button[text()='Search']";
	public static final String CommunicationListing_arrowdown = "arrowdown,id,rs_CommunicationListRowCell_arrowdown";
	public static final String CommunicationListing_Duplicate = "Duplicate,xpath,//a[text()='Duplicate']";
	public static final String CommunicationListing_CSRanalyticsicon = "CSRanalyticsicon,id,rs_CommunicationListRowCell_Analytics";
	public static final String Communicationcreation_offer = "offer code,xpath,//i[@class='icon-rs-editor-coupon-medium icon-md ']";
	public static final String Communicationcreation_offerpage = "offer code,xpath,//label[.='Offer code type']";
	public static final String Communicationcreation_offertype = "offer code,xpath,//span//span[.='PLACE_HOLDER']";
	public static final String Communicationcreation_offer_select = "offer code select,xpath,//span//span[@aria-label='Select offer type']";
	public static final String Communicationcreation_offerpage_selectList = "offer code list,xpath,//span//span[@aria-label='Select offer list']";
	public static final String Communicationcreation_offer_save = "offer code Save,xpath,//div[@class='rsmdc-footer w-100 modal-footer']//button[.='Save']";
	public static final String notification_mobpush_Deliverytype = "Mobile push type,xpath,//span[@aria-label='Delivery type']";

	public static final String pwcommunicationpage_channel_type2 = "Channel SMS ,pw,//input[@id='channelTypes[1].selected']";
	public static final String pwcommunicationpage_channel_type3 = "Channel Social media ,pw,#IsSocialMediaPostSelected";
	public static final String pwcommunicationpage_channel_QR = "QR Channel,pw,//input[@id='QR']/..//span";
	public static final String pwcommunicationpage_channel_type5 = "Channel Notification ,pw,//input[@id='channelTypes[2].selected']";
	public static final String pwcommunicationpage_channel_type6 = "Channel Paidadds ,pw,//input[@id='channelTypes[5].selected']";
	public static final String pwcommunicationpage_channel_type7 = "Channel Voice ,pw,#IsVoiceSelected";
	public static final String pwcommunicationpage_analytics_option1 = "Social media,pw,#channelTypes[3].selected";
	public static final String pwcommunicationpage_analytics_option2 = "Analytic web,pw,//input[@id='analyticsTypes[0].selected']";
	public static final String pwcommunicationpage_analytics_option3 = "Analytic ORM,pw,#IsOrmSelected";
	public static final String pwcommunicationpage_analytics_option4 = "Analytic Video,pw,#IsVideosAnalyticsSelected";
	public static final String pwcommunicationpage_analytics_option5 = "Analytic App,pw,//input[@id='analyticsTypes[1].selected']";

	public static final String communicationpage_email_Sender_id = "Recepient,id,rs_Email_senderEmailAddress";

	public static final String Webpush_clickimport = "Import,xpath,//span[contains(text(),'Import')]";

}
