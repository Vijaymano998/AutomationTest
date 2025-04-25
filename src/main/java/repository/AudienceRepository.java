package repository;

public class AudienceRepository
{
	// Audience creation Page
	public static final String audience_addAudience = "Add audience (+) button,xpath,//i[contains(@class,'plus')]";
	public static final String audience_selectsource = "Add audience by,xpath,//label[.='Add audience by']//..//..//span[contains(@class,'dropdown-required')]";
	public static final String audience_selectsource_placeholder = "Add audience placeholder,xpath,//label[.='Add audience by']//..//..//span[contains(@class,'dropdown-required')]//..//span[contains(@class,'label')]";
	public static final String audience_clickListtype = "List Type,xpath,//label[.='List type']//..//..//span[contains(@class,'dropdown-required')]";
	public static final String audience_listtype_placeholder = "List type placeholder,xpath,//label[.='List type']//..//..//span[contains(@class,'dropdown-required')]//..//span[contains(@class,'label')]";
	public static final String audience_afterchooselisttype_placeholder = "List type placeholder,xpath,//span[@aria-label='List type']//span[contains(@class,'k-input-value')]";
	public static final String audience_agreeAndProceed = "Agree & Proceed,xpath,//button[.='I agree & proceed']|//button[@id='rs_RSAlert_primarybutton']";
	public static final String audience_selectListname = "List Type,xpath, //div[contains(@class,'ListType')]//li";
	public static final String audience_attributemapping = "Attribute mapping,xpath,//label[.='Attribute mapping']//..//..//span[contains(@class,'dropdown-required')]";
	public static final String audience_attributemappingDropdown = "List Item,xpath,//div[@class='k-list-content']//li//span[@class='k-list-item-text']";
	public static final String audience_attributemappingplaceholder = "Attribute mapping placeholder,xpath,//label[.='Attribute mapping']//..//..//span[contains(@class,'dropdown-required')]//..//span[contains(@class,'label')]";
	public static final String audience_categorytype = "Category Type,xpath,//span[@aria-label='Category type'][contains(@class,'required')]";
	public static final String audience_categorytypeplaceholder = "Category type placeholder,xpath,//span[@aria-label='Category type'][contains(@class,'required')]//..//span[contains(@class,'label')]";
	public static final String audience_newcategorytype = "New category type,xpath,//input[@name='categoryTypeText'][contains(@class,'required')]";
	public static final String audience_importdescname = "Import description,xpath,//input[contains(@class,'required')][@type='text']";
	public static final String audience_importdescsegloader = "Import desc seg loader,xpath,//label[text()='Import description']//parent::div//div[@class='segment_loader']";
	public static final String audience_importdescnameplaceholder = "Import description placeholder,xpath,//input[contains(@class,'required')][@type='text']//..//label";
	public static final String audience_importdesc_loader = "Segmentation loader,xpath,//div[@class='segment_loader']";
	public static final String audience_importdesc_greentick = "Green tick,css,i[id='rs_data_circle_tick_medium']";
	public static final String audience_descnamevalidationicon = "Validation Icon,xpath,//div[@class='rs-validate-success-icon']";
	public static final String audience_uploadfile = "Uploaded Sucess,xpath,//button[.='Upload']";
	public static final String audience_uploadfield = "Upload field,xpath,//div[contains(@class,'rs-file-upload')]";
	public static final String audience_uploadfileplaceholder = "choose file Placeholder,xpath,//label[.='Choose your file(s)']//..//..//label[@class='rsfuw-label']";
	public static final String audience_uploadfieldErrMsg = "chooseyourfile field err msg,xpath,//label[contains(@class,'rsfuw-label')]";
	public static final String audience_uploadfile_Msg = "File validation Msg,xpath,//div[contains(@class,'file-status')]//span";
	public static final String audience_uploadedfile_name = "Uploaded file delete,xpath,//div[@class='rsfb-file-info']//h4[contains(@class,'file-name')]|//div[@class='rsfb-file-info']//span";
	public static final String audience_uploadfileexclamatory = "Exclamatory,xpath,//span[text()='PLACE_HOLDER']//..//..//i[contains(@class,'exclamatory')]";
	public static final String audience_uploadedfiledeleteIcon = "Delete Icon,xpath,//i[contains(@class,'delete')]";
	public static final String audience_uploadedfileInfo = "File Info,xpath,//div[contains(@class,'file-info')]";
	public static final String audience_uploadmaxfile = "Max file msg,xpath,//div[contains(@class,'file-upload')]//following-sibling::ul//li//small";
	public static final String audience_columnheadertext = "column header help text,xpath,//label[@for='isColumnHeader']";
	public static final String audience_helptextcheckbox = "Help text checkbox,xpath,//label[@for='isColumnHeader']//input";
	public static final String audience_helptextQuestionmarkicon = "Help text Question-mark Icon,xpath,//i[contains(@class,'question-mark')]";
	public static final String audience_uploaddeleteicon = "delete icon,xpath,//span[.='PLACE_HOLDER']//..//..//i[contains(@class,'delete')]";
	public static final String audience_uploaddeletepopup_okicon = "Delete popup Ok,xpath,//div[contains(@class,'modal-content')]//button[text()='OK']";

	// BrandId
	public static final String audience_uploadBrandIdPopup = "BrandId,xpath,//div[contains(@class,'rs-overlay-content ')]//span[contains(text(),' Proceed to assign BrandID')]";
	public static final String audience_uploadBrandIdPopupProceed = "Popup proceed,css,#rs_RSAlert_primarybutton";
	public static final String audience_uploadBrandIdExistingpopupText = "Existing attribute Popup text,xpath,//div[contains(@class,'modal-content')]//p";
	public static final String audience_uploadBrandIdExistingpopupProceed = "Existing popup proceed,xpath,//div[contains(@class,'modal-content')]//button[text()='Proceed']";

	// Manual entry
	public static final String audience_addaudiencemanualinputfield = "Input fields,css,textarea[name='manualEntry.audienceData']";
	public static final String audience_addaudiencemanualhelptext = "HelpText,xpath,//label[@for='rs_AddAudience_importpreference']//span[text()]";
	public static final String audience_addaudiencemanualplaceholder = "Placeholder,xpath,//label[@for='manualEntry.audienceData']";

	// + "//h4[contains(@class,'mb0')]";
	public static final String audience_helptextcontent = "Help Text content,xpath,//div[contains(@class,'popover-body')]";
	public static final String audience_helptext2header = "HelpTextheader,xpath,//div[contains(@class,'box-design')]//following-sibling::div[@class='row']//h4";
	public static final String audience_helptext2content = "HelpTextcontent,xpath,//div[contains(@class,'box-design')]//following-sibling::div[@class='row']//span";
	public static final String audience_mappinghelptextheader = "Help text header,xpath,(//div[contains(@class,'justify-content')]//h4)[1]";
	public static final String audience_mappinghelptextcontent = "Help text content,xpath,//div[contains(@class,'justify-content')]//p";
	public static final String audience_target_SegmentationGrid = "Segmentation Grid,xpath,//h1[.='Map data attributes']";
	public static final String audience_cancelbutton = "Cancel button,xpath,//button[.='Cancel']";
	public static final String audience_browserbutton = "Browser button,xpath,//button[.='Browse']";
	public static final String audience_clickreturnmasterlist = "Return to master list,xpath, //button[.='Return to the master list']";
	public static final String audience_AudienceMasterPageHead = "Audience,xpath, //h1[contains(.,'Audience')]";
	public static final String audience_selectsourcereseticon = "Add audience by reset icon,xpath,//label[.='Add audience by']//..//..//i[contains(@class,'refresh')]";
	public static final String audience_listtypereseticon = "List type reset icon,xpath,//label[.='List type']//..//..//i[contains(@class,'refresh')]";
	public static final String audience_listpopupheader = "Popup header,xpath,//div[contains(@class,'overlay-content')]//h1";
	public static final String audience_listpopupcondition = "List popup condition,xpath,//div[contains(@class,'overlay-content')]//ul//li | //p";
	public static final String audience_listpopuphint = "List popup hint,xpath,//div[contains(@class,'overlay-content')]//p";
	public static final String audience_fileupload = "Upload file,xpath,//input[@type='file']";
	public static final String audience_clickuploadbutton = "Upload button,xpath,//button[text()='Upload']";
	public static final String audience_attributeheader = "Attribute header,xpath,//div[contains(@class,'addImportAudienceDropdown')]//span[@class='k-input-value-text'][not(contains(text(),'EmailID'))]";
	public static final String audience_newattributeIcon = "New attribute add icon,xpath,//span[.='New attribute']//..//i";

	// Column mapping page
	public static final String audience_seg_helptextcontent = "Help text content,xpath,//h4[.='New audience list']//..//..//p";
	public static final String audience_seg_audiencecount = "Audience count,xpath,//h4//span";
	public static final String audience_seg_doubleopttext = "Double-opt text,xpath,//div[@class='float-start']";
	public static final String audience_seg_doubleoptcheckbox = "Confirm DoubleOptIn,xpath,//input[@class='checkbox']";
	public static final String audience_seg_uniqueIdentiferText = "Unique Identifer text,xpath,//div[contains(@class,'float-end')]";
	public static final String audience_seg_attributeDropdown = "First column,xpath,(//tr)[2]//td";
	public static final String audience_seg_scrollToSpecificElement = "Scroll to element,xpath,(//div[contains(@class,'addImportAudienceDropdown')])[PLACE_HOLDER]//span[@class='k-input-value-text']";
	public static final String audience_seg_addImportdescriptionDropdown = "Add import description dropdown,xpath,(//div[contains(@class,'addImportAudienceDropdown')])[PLACE_HOLDER]//span[@class='k-input-value-text']";
	public static final String audience_seg_enterAttributeName = "Attribute name,xpath,//div[contains(@class,'addImportAudienceDropdownList')]//input";
	public static final String audience_seg_newattribute = "New attribute,xpath,//span[text()='New attribute']";
	public static final String audience_seg_attributeNameSearch = "Attribute Name search,xpath,//div[contains(@class,'addImportAudienceDropdownList')]//span//span[contains(@class,'search')]";
	public static final String audience_seg_attributenamenodatafound = "No data found dropdown,xpath,//div[contains(@class,'addImportAudienceDropdownList')]//div[contains(@class,'nodata')]//div[contains(.,'NO DATA FOUND')]";
	public static final String audience_seg_attributeHeader = "Attribute Header,xpath,//div[contains(@class,'addImportAudienceDropdown')]//span[.='PLACE_HOLDER'][@class='k-input-value-text']";
	public static final String audience_seg_attributeminusIcon = "Minus Icon,xpath,//span[.='PLACE_HOLDER']//ancestor::div[contains(@class,'aud_mappingScreen')]//i[contains(@class,'minus')]";

	// New attribute creation
	public static final String preferences_dataCatalogue_Click = "datacatalogue click,xpath,//i[@class='icon-rs-data-catalogue-xlarge font-xl']";
	public static final String preferences_dataCatalogue_Newattribute = "Datacatalogue new attribute,xpath,//h4[text()='Available attributes']//parent::div//i[@id='rs_data_circle_plus_fill_edge']";
	public static final String audience_seg_newattributeheader = "New attribute header,xpath,//h2[.='New attribute']";
	public static final String audience_seg_attributeNameField = "Attribute Name field,xpath,//div[@class='border-bottom-required']//..//input[@id='uIPrintableName']";
	public static final String audience_seg_attributeNamePlaceholder = ",xpath,//input[@id='uIPrintableName']//..//label";
	public static final String audience_seg_description = "Description Name,xpath,//*[@id='description']";
	public static final String audience_seg_descriptionhelptext = "Description helptext,xpath,//*[@name='description']//..//..//small";
	public static final String audience_seg_dropdownValue = "Dropdown values,xpath,//div[@class='k-list-content']//span//span";
	public static final String audience_seg_datatype = "Data Type,xpath,//span[contains(@aria-label,'ata type')][contains(@class,'required')]//span[@class='k-input-value-text']";
	public static final String audience_seg_catagoryType = "Catagory Type,xpath,//span[@aria-label='Category type']//span[@class='k-input-value-text']";
	public static final String audience_seg_newcatagoryType = "New catagory type add icon,css,#rs_icon";
	public static final String audience_seg_newcatagorytypeText = "Catagory Type Text,name,categoryTypeText";
	public static final String audience_seg_newcatagoryTypeSaveIcon = "Save icon,xpath,//i[contains(@class,'save-mini')]";
	public static final String audience_seg_datatypefield = "Data Type,xpath,//span[contains(@aria-label,'ata type')][contains(@class,'required')]//span[@class='k-input-value-text']//parent::span//parent::span[contains(@class,'dropdown')]";
	public static final String audience_seg_catagorytype = "Catagory type,xpath,//div[@class='border-bottom-required']//..//input[@name='categoryTypeText']";
	public static final String audience_seg_catagorytypeplaceholder = "placeholder name,xpath,//div[@class='border-bottom-required']//..//input[@name='categoryTypeText']//..//label";
	public static final String audience_seg_catagorytypeclose = "Catagory type close,xpath,//div[@class='border-bottom-required']//..//input[@name='categoryTypeText']//..//..//i";
	public static final String audience_seg_catagorydropdown = "Catagory dropdown,xpath,//span[@aria-label='Category type']//span[@class='k-input-value-text']";
	public static final String audience_seg_classificationValues = "Classification values,xpath,//span[@class='k-chip-content']//span";
	public static final String audience_seg_conditionAddicon = "Add icon,xpath,//div[.='Condition:']//..//i[contains(@class,'plus')]";
	public static final String audience_seg_conditionsourcedropdownfield = "condition source dropdown,xpath,//div[contains(@class,'multi-bottom')]//span[@class='k-input-value-text']";
	public static final String audience_seg_conditiontextfield = "Conditiontext,xpath,//div[contains(@class,'multi-bottom')]//input";
	public static final String audience_seg_condition_minus = "Condition minus,xpath,//div[contains(@class,'multi-bottom')]//i";
	public static final String audience_seg_kpitype = "KPI type,xpath,//ul[@class='rs-list-inline']//li//span";
	public static final String audience_seg_conditiondropdown = "Condition Dropdown,xpath,(//div[contains(@class,'multi-bottom')]//span[@class='k-label'])[PLACE_HOLDER]";
	public static final String audience_seg_conditionText = "conditionText,xpath,(//div[contains(@class,'multi-bottom')]//input)[PLACE_HOLDER]//..//label";
	public static final String audience_seg_dropdownLabelName = "Dropdown label Name,xpath,(//div[contains(@class,'multi-bottom')]//span[@class='k-label'])[PLACE_HOLDER]";
	public static final String audience_seg_textlabelname = "Text label Name,xpath,(//div[contains(@class,'multi-bottom')]//label)[PLACE_HOLDER]";

	public static final String audience_seg_inputtype = "Input Type,xpath,//span[contains(@aria-label,'nput type')][contains(@class,'required')]//span[@class='k-input-value-text']";
	public static final String audience_seg_inputtypedatafromatfield = "Date format,xpath,//span[@aria-label='Date format type']";
	public static final String audience_seg_filtergroup = "Filter group,xpath,//span[contains(@aria-label,'ilter group')][contains(@class,'required')]//span[@class='k-input-value-text']";
	public static final String audience_seg_classification = "Classification,xpath,//label[text()='Classification']//parent::span//input";
	public static final String audience_seg_newAttributeSave = "New Attribute Save,xpath,//h2[.='New attribute']//..//..//button[.='Save']";
	public static final String audience_seg_fallbackName = "Fallback Name,xpath,//div[@class='border-bottom-required']//..//input[@name='fallbackAttributeName']";

	// Data catalogue attribute check
	public static final String dataCatalogueSearchIcon = "Search Icon,xpath,//i[@id='rs_data_zoom']";
	public static final String dataCatalogueSearchTextbox = "Search Textbox,xpath,//div[contains(@class,'search-filter')]//input";
	public static final String dataCataloguelistAttribute = "list attribute,xpath,//div[contains(@class,'sticky')]//div[contains(@class,'tag-list')]//li";

	// Sync History
	public static final String audience_synchist_table = "Table,xpath,//table[@class='k-grid-table']";
	public static final String audience_synchist_alertIcon = "Alert Icon,xpath,//div[contains(@class,'actionBlock')]";
	public static final String audience_synchist_nextButton = "Pagination Next Page,xpath,//a[@title='Go to the next page']";
	public static final String audience_synchist_lastButton = "Pagination Last Page,xpath,//a[@title='Go to the last page']";
	public static final String audience_synchist_firstButton = "Pagination First page,xpath,//a[@title='Go to the first page']";
	public static final String audience_synchist_prevButton = "Pagination prev page,xpath,//a[@title='Go to the previous page']";
	public static final String audience_synchist_itemPerPage = "Item per page,xpath,//span[contains(@class,'k-pager-sizes')]//span[@class='k-input-value-text']";
	public static final String audience_synchist_invalid_csv_downloadicon = "Invalid csv download icon,xpath,//div[contains(@class,'modal show')]//i[contains(@class,'download')]";
	public static final String audience_synchist_selectotpsource = "Select ,xpath,//label[.='Send OTP to']//ancestor::div//span[@class='k-input-value-text']";
	public static final String audience_synchist_popupMailValidation = "validation popup,xpath,//div[contains(@class,'modal show')]//p";
	public static final String AudienceDownloadButton = "Download button,xpath,//button[.='Download']";
	public static final String Audiencedownloadheader = "Invalid audience download header,xpath,//div[@class='heading-title-text']//h1";
	public static final String audienceImportdescAlertIcon = "Alert icon,xpath,//*[.='PLACE_HOLDER']//ancestor::tr//i";

	// Invalid audience table
	public static final String audience_invalidAudience_table = "Invalid audience table,xpath,//div[contains(@class,'modal-content rsmd-content')]//div[contains(@class,'k-widget k-grid')]";
	public static final String audience_invalidAudience_tablerow = "Invalid audience table row,xpath,//div[@class='fade rs-modal  modal show']//div[contains(@class,'k-virtual-content')]//table//tr";

	// Target Listing Page
	public static final String allmenu_targetlist = "Target list menu,xpath,//div[@class='container']//li//span[.='Target lists']";
	public static final String audience_target_clicktimefreq = "Time freq dropdown icon,xpath,//div[contains(@class,'daterange-picker')]//span[contains(@class,'arrow-icon')]";
	public static final String audience_target_selecttimefreq = "Time freq list,xpath,//div[@class='date-range-box']//li";
	public static final String audience_target_listingvalidation = "Target listing page validation,xpath,//span[.='All audience']//ancestor::div[@class='rc-info']";
	public static final String audience_target_backicon = "Back button,xpath,//div[contains(@class,'mhwcr-back')]//i";
	// Gridview
	public static final String audience_gridview_listName = "List Name,xpath,//div[contains(@class,'rs-card-bottom')]//div[@class='rci-list-name']//span";
	public static final String audience_gridview_createdby = "Created by Name,xpath,//div[contains(@class,'rs-card-bottom')]//span[@class='rctcb-by-name']";
	public static final String audience_gridview_createdon = "Created on,xpath,//div[contains(@class,'rs-card-bottom')]//span[@class='rctcb-by-date']";
	public static final String audience_gridview_allaudiencecreatedOn = "All audience created on,xpath,//span[text()='All audience']//ancestor::div[contains(@class,'rs-card-bottom')]//span[@class='rctcb-by-date']";
	public static final String audience_gridview_segmentationaudience = "Segmentation Audience,xpath,//div[contains(@class,'rs-card-bottom')]//div[@class='rci-content-block']//span[contains(.,'audience') or contains(.,'Calculating') or contains(.,'List extraction')]";
	public static final String audience_gridview_communicationexecuted = "Communication executed,xpath,//div[@class='rci-content-block']//div//span[contains(.,'Commu. executed')]";
	public static final String audience_gridview_AverageAndProjectedReachRate = "Projected reach rate,xpath,//div[contains(@class,'rs-card-bottom')]//span[@class='rcitn-number ']";
	// ListView
	public static final String audience_listview_listIcon = "Listview,id,rs_TargetHeaderView_edge";
	public static final String audience_target_FirstName_search = "First List Name,xpath,(//tr[@class='k-master-row']//td//p)[1]";
	public static final String audience_dynamiclistview_listIcon = "Listview,xpath,//i[@class=' icon-rs-circle-list-edge-large icon-lg color-primary-blue icon-hover-shadow-primary']";

	// Search and Filter
	public static final String audience_target_searchIcon = "Search icon,xpath,//div[@class='search-icon']";
	public static final String audience_FilterlistTypeBy = "List type icon,xpath,//div[@class='search-icon']/..//button[contains(@class,'dropdown-toggle btn btn-primary')]";
	public static final String audience_FilterlistTypeByList = "List type dropDown,xpath,//div[contains(@class,'dropdown-menu show')]//a";
	public static final String audience_target_entersearchvalue = "Search value,xpath,//input[@id='search']";
	public static final String audience_target_entersearchResult = "Search list result,xpath,//div[@class='box-design']//li";
	public static final String audience_compvalue = "Segment Name,xpath,((//div[@class='rci-list-name'])//span[not(contains(.,'All audience'))])";
	public static final String audience_target_searchIcon2 = "search icon,xpath,//div[@class='search-field-icon']//i";
	public static final String audience_target_SegmentationGridRows = "Segmentation Grid rows,xpath,(//div[contains(@class,'rs-card')])";
	public static final String audience_target_shortlistname = "Short list Name,xpath,//div[contains(@class,'tooltip-inner')]//ancestor::div[contains(@class,'tooltip-wrapper')]//span";
	public static final String audience_target_searchExpandIcon = "Search Expand icon,xpath,//div[contains(@class,'search-container')]//div[contains(@class,'h32 position-relative')]";
	public static final String audience_target_advancedSearchdropdown = "Advanced search dropdown,xpath,//div[@class='dropdown-search-menu']";
	public static final String audience_target_advancedSearchlistname = "Advanced search List Name,name,list_name";
	public static final String audience_target_advancedSearchcratedby = "Advanced search CreatdBy,name,created_by";
	public static final String audience_target_advancedSearchlisttype = "Advanced search ListType,xpath,//span[@aria-label='List type']";
	public static final String audience_target_advancedSearchapprovalstatue = "Advanced search ApprovalStatus,xpath,//span[@aria-label='Approval status']";
	public static final String audience_target_targetlistsegcount = "Seg count,xpath,//div[@class='tooltip-inner'][text()='PLACE_HOLDER']//parent::div//parent::div//parent::div//parent::div//div[@class='rci-text ']";

	// Master data management(overview)
	public static final String audience_Masterdata_portletheader = "Portlet header ,xpath, //div[@class='portlet-header']";
	public static final String audience_Masterdata_overView_ChartdropDown = " Overview Chart Drop down,xpath, //div[@class='portlet-header']//i";
	public static final String audience_Masterdata_overView_ChartdropDownList = " attribute,xpath,//div[@class='portlet-header']//a";
	public static final String audience_Masterdata_overView_ChartdropDownVisibleList = "Chart visible text,xpath,//div[@class='portlet-header']//div[@class='css-scrollbar']//div[not(contains(@class,'click-off'))]//a";
	public static final String audience_Masterdata_overView_titleLegend = " Overview Chart name ,css,div[class*='highcharts-legend-item highcharts-pie-series highcharts-color'] span[title]";
	public static final String audience_Masterdata_overView_ChartTooltip = " Overview Chart tooltip ,xpath, //div[contains(@class,'highcharts-label highcharts-tooltip highcharts-color')]";
	public static final String audience_Masterdata_overView_ChartList = " Overview Chart tooltip ,xpath, //*[contains(@class,'highcharts-label highcharts-data-label highcharts-data-label')][not(contains(@visibility,'hidden'))]";
	public static final String audience_Masterdata_NotificationiIcon = " Notification i Icon ,xpath, //small[.='Notifications']//..//..//..//..//i[contains(@class,'info')]";
	public static final String audience_Masterdata_Notification_textList = "Notification text List ,xpath, //h4[contains(.,'notification')][not(contains(.,'Web'))]//..//li";
	public static final String audience_Masterdata_overviewTotalheader = "Channel Title,xpath, //div[@class='card-body']//small[contains(@class,'font')]";
	public static final String audience_Masterdata_overviewportlet = "Portlet,xpath,//i[contains(@id,'info')][not(contains(@class,'click-off'))]//parent::div";
	public static final String audience_Masterdata_overviewportletheader = "Overview portlet header,css,small[class='font-semi-bold']";
	public static final String audience_Masterdata_overviewportletdatacapture = "Overview portlet data capture,css,small[class*='position-absolute']";
	public static final String audience_Masterdata_overviewportlet_I_icon = "I-icon,xpath,//small[text()='PLACE_HOLDER']//ancestor::div[contains(@class,'box-design')]//i[contains(@class,'info')][not(contains(@class,'click-off'))]";
	public static final String audience_Masterdata_overviewPortlet_Total_I_Icon = "I-Icon,xpath,//small[not(contains(.,'Total'))][@class='font-semi-bold']//ancestor::div[contains(@class,'box')]//i[contains(@class,'info')]";
	public static final String audience_Masterdata_piechartValues = "Pie chart values,css,g[class='highcharts-series highcharts-series-0 highcharts-pie-series highcharts-tracker']>path:not([visibility='hidden']):not([fill='none'])";
	public static final String audience_Masterdata_charttooltipvalue = "Tooltip,css,div[class*='highcharts-label highcharts-tooltip highcharts-color']:not([style*='hidden'])>span>span";
	public static final String audience_Masterdata_portletclose = "Portlet close,css,i[class*='close']";
	public static final String audience_masterdata_chartchannelvalues = "chartvalue,xpath,//div[@class='bubbleChartInsideContainer']";
	public static final String audience_masterdata_totalchannelvalue = "Overall Channels Total Count,xpath,//small[.='Total']//..//h1";
	public static final String audience_Masterdata_profileCompleteness = " profile Completeness ,xpath, //h4[.='Primary attributes']//..//ul//li";
	public static final String audience_Masterdata_profileCompletenesScrollBar = " profile Completeness ScrollBar ,xpath, (//div[contains(@class,'borderleft')]//ul[contains(@class,'scrollbar')])[1]";
	public static final String audience_Masterdata_profileCompletenessRecomm = " profile Completeness Recommendations ,xpath, //h4[.='Recommendations']//..//li";
	public static final String audience_masterdata_webnotification = "Web notification count,xpath,(//ul[contains(@class,'domain-list')])[1]//li[2]//span[2]";
	public static final String audience_masterdata_mobilenotification = "Mobile notification count,xpath,(//ul[contains(@class,'domain-list')])[2]//li[2]//span[2]";
	public static final String audience_masterdata_overviewtotal_Info_Icon = "Overview Total I icon,xpath,//small[.='Total']//ancestor::div[contains(@class,'box-design')]//i[@id='rs_data_circle_info']";
	public static final String audience_masterdata_overviewemail_Info_Icon = "Overview Total I icon,xpath,//small[.='Email']//ancestor::div[contains(@class,'box-design')]//i[@id='rs_data_circle_info']";
	public static final String audience_masterdata_overviewmobile_Info_Icon = "Overview Total I icon,xpath,//small[.='Mobile']//ancestor::div[contains(@class,'box-design')]//i[@id='rs_data_circle_info']";
	public static final String audience_masterdata_overviewnotification_Info_Icon = "Overview Total I icon,xpath,//small[.='Notifications']//ancestor::div[contains(@class,'box-design')]//i[@id='rs_data_circle_info']";
	public static final String audience_masterdata_overviewnotification_Infostatus = "Notification info status,xpath,//div[@class='card-body']//small[text()='Notifications']//parent::div//h1";
	public static final String audience_masterdata_MDMcreatePersona = "Mdm create persona,id,rs_ProfileCompleteness_CreatePersona";

	// channel data
	public static final String audience_masterdata_channelName = "channel text,xpath,(//div[@class='card-body']//div[@class='ml15']//small)[PLACE_HOLDER]";
	public static final String audience_masterdatachannelInfo = "i-Icon,xpath,(//i[contains(@class,'info')])[PLACE_HOLDER]";
	public static final String audience_masterdatachanneloverviewchartHeader = "Chart header,xpath,(//div[@class='master-recip-data-popup']//h4)[1]";
	public static final String audience_masterdatachanneloverviewpieChartId = "Pie chart id,xpath,//h4[.='PLACE_HOLDER']//parent::div[@class='col-md-6']//div[@class='highcharts-container piechart-default-render']";
	public static final String audience_masterdatachanneltableheader = "Table header,xpath,(//h4[contains(@class,'mb10')])[2]";
	public static final String audience_masterdatachanneltabletext = "Text,xpath,(//h4[.='PLACE_HOLDER']//..//ul[@class='domain-list css-scrollbar'])[1]//li";
	public static final String audience_masterdatachannelchartpercentage = "chart values,css,div[id='PLACE_HOLDER']>svg>g>g[class*='highcharts-label highcharts-data-label highcharts-data-label-color']";
	public static final String audience_masterdatachannelcharttooltip = "tooltip,xpath,//div[@id='PLACE_HOLDER']//div[contains(@class,'highcharts-label highcharts-tooltip')]";
	public static final String audience_masterdatachannelcharttooltiptext = "Chart,css,div[id='PLACE_HOLDER'] div[class*='highcharts-legend-item highcharts-pie-series highcharts-color'] span[title]";

	// Master data management(list acquisition)
	public static final String audience_Masterdata_lisqusitionTabs = "Tabs,xpath,//ul[contains(@class,'rs-tabs')][not(contains(@class,'left'))]//li";
	public static final String audience_Masterdata_listacquisitionchart = "list acquisition chart,css,div[class*='chart-line']>svg[class='highcharts-root']>g[class='highcharts-series-group']";
	public static final String audience_Masterdata_listacquisition_calender = "List acquisition,xpath,//span[.='List acquisition']//..//..//..//span[contains(@class,'rs-dt-calendar-text')]";
	public static final String audience_Masterdata_listacquisition_selectDate = "Select Date,xpath,//span[.='List acquisition']//..//..//..//ul[contains(@class,'daterangepicker-list-view')]";
	public static final String audience_Masterdata_listacquisition_notes = "Notes icon,xpath,//i[contains(@class,'bookmark')]";
	public static final String audience_Masterdata_listacquisition_source = "Sources,xpath,(//span[.='List acquisition']//..//..//..//button)[3]";
	public static final String audience_Masterdata_selectsource = "Select source,xpath,//div[contains(@class,'dropdown-menu show')]//a";
	public static final String audience_Masterdata_notesdropdown = "Notes dropdown,xpath,//div[@class='note-accordion box-design']";
	public static final String audience_Masterdata_emailgraph = "Email graph,css,div[class*='chart-line-animate']>svg>g[class*='highcharts-series-group']>g[class*='highcharts-markers highcharts-series-0']";
	public static final String audience_Masterdata_mobilegraph = "Mobile graph,css,div[class*='chart-line-animate']>svg>g[class*='highcharts-series-group']>g[class*='highcharts-markers highcharts-series-1']";
	public static final String audience_Masterdata_chartlegend = "Chart legend,css,g[class*='highcharts-legend-item']";
	public static final String audience_Masterdata_charttooltip = "Chart Tooltip,xpath,//div[contains(@class,'highcharts-tooltip')][contains(@style,'visibility')]";
	public static final String audience_Masterdata_overviewemailcount = "Overview Email Count,xpath,//small[.='Email']//..//h1";
	public static final String audience_Masterdata_overviewmobilecount = "Overview Mobile Count,xpath,//small[.='Mobile']//..//h1";
	public static final String audience_Masterdata_yaxis = "Y axis,css,g[class='highcharts-axis-labels highcharts-yaxis-labels']>text";

	// Audience Grid
	public static final String audience_Masterdata_audiencegridheader = "Audience grid header,xpath,//h4[contains(text(),'Audience list')]";
	public static final String audience_Masterdata_audiencegridCount = "Audience grid default count,xpath,//h4[text()='Audience list: ']//span";
	public static final String audience_Masterdata_fieldSelector = "Field selector,id,rs_data_field_selector";
	public static final String audience_Masterdata_audiencegridsearch = "Search icon,id,rs_data_zoom";
	public static final String audience_Masterdata_audiencegridsearchText = "Search Text,xpath,//input[contains(@class,'searchInput active')]";
	public static final String audience_Masterdata_availableattributes = "Available attributes,xpath,//div[@class='multiClm multiLftClm']//li[contains(@class,'k-list-item')]";
	public static final String audience_Masterdata_selectedattributes = "Selected attributes,xpath,//div[@class='multiClm multiRghtClm']//li";
	public static final String audience_Masterdata_fieldSelectorleftArrow = "Left arrow,xpath,//button[@title='Transfer From']//span";
	public static final String audience_Masterdata_fieldSelectorrightArrow = "Right arrow,xpath,//button[@title='Transfer To']//span";
	public static final String audience_Masterdata_fieldSelectorcloseicon = "Field Selector close icon,id,rs_circle_close_edge";
	public static final String audience_Masterdata_audiencegridcancel = "Cancel button,xpath,//button[.='Cancel']";
	public static final String audience_Masterdata_audiencegridsave = "Save button,xpath,//button[.='Save']";
	public static final String audience_Masterdata_audiencegridupdate = "Save button,xpath,//button[.='Update']";

	// Target list
	public static final String audience_Target_newsegmentaddicon = "New segmentation add icon,xpath,//i[contains(@class,'plus')]";
	public static final String audience_Target_listName = "Target list name,xpath,//div[contains(@class,'required')]//..//input[@name='segmentation.listName']";
	public static final String audience_Target_listNameplaceholder = "ListName placeholder,xpath,//input[@name='segmentation.listName']//..//label";
	public static final String audience_Target_listtotalaudience = "Target list Total audience,xpath,//h4[contains(.,'Total audience:')]//span";
	public static final String audience_Target_listNametickmark = "ListName green tick,xpath,//div[@class='nameSucessIcon']//i[contains(@class,'green')]";
	public static final String audience_target_clickSearchattribute = "Search attribute icon,xpath,//div[contains(@class,'search-filter')]//i[contains(@class,'zoom')]";
	public static final String audience_target_enterSearchattribute = "Search input,xpath,//div[contains(@class,'search-filter')]//input";
	public static final String audience_target_clickSearchClose = "Close search icon,xpath, //div[contains(@class,'search-filter')]//i[contains(@class,'close')]";
	public static final String audiecne_target_attributesnodataavailable = "Attributes No data available,xpath,//div[contains(@class,'targetList-leftSide')]//p";
	public static final String audience_target_activeAttributeList = "Active attribute list,xpath,//div[contains(@class,'search-filter')]//..//..//ul[@class='searchList ']//li";
	public static final String audience_target_potentialaudienceInclusiongroup1 = "Potential target audience,xpath,(//p[contains(.,'Potential audience')]//span)[1]";
	public static final String audience_target_potentialaudienceInclusiongroup2 = "Potential target audience,xpath,(//p[contains(.,'Potential audience')]//span)[2]";
	public static final String audience_target_potentialaudienceExclusiongroup = "Potential target audience,xpath,(//p[contains(.,'Potential audience')]//span)[3]";
	public static final String audience_target_helpText = "Help Text,xpath,//h5[.='PLACE_HOLDER']//..//..//small";
	public static final String audience_target_createlist = "Create target list icon,xpath,//button[@type='submit']";
	public static final String audience_target_cancelbutton = "Cancel button,id,rs_TargetListCreation_Cancel";
	public static final String audience_target_helptext = "Help text,xpath,//div[contains(@class,'targetList')]//p[contains(@class,'small')]";
	public static final String audience_target_helpquestionmark = "Help Question mark,xpath,//i[contains(@class,'question-mark')]";
	public static final String audience_target_questionmarktooltiptext = "Question mark text,xpath,//div[contains(@class,'popover-body')]";
	public static final String audience_target_createpopupheader = "create popup header,xpath,//div[contains(@class,'modal show')]//h2";
	public static final String audience_target_createpopuptargetlistplaceholder = "Create target list placeholder,xpath,(//div[contains(@class,'modal show')]//p)[1]";
	public static final String audience_target_createpopuppotentialaudience = "Create popup potential audience,xpath,(//div[contains(@class,'modal show')]//p)[2]";
	public static final String audience_target_createpopupcancelbutton = "Cancel button,xpath,//div[contains(@class,'modal show')]//button[@type='button'][.='Cancel']";
	public static final String audience_target_createpopupsavebutton = "Save button,xpath,//div[contains(@class,'modal show')]//button[@type='button'][.='Save']";
	public static final String audience_target_segmentationattributecount = "Segmentation attribute count,xpath,//ul[@class='attributeList']//li//i[contains(@class,'arrow')][contains(@class,'mini')]//..";
	public static final String audience_target_FinalSegmentationCount = "Final segmentation count,xpath,((//div[contains(@class,'text-end')])[PLACE_HOLDER]//span)[3]";
	public static final String audience_target_inclusionexclusionaddbutton = "Add inclusion/exclusion button,xpath,//i[@id='rs_data_circle_plus_fill_edge']";
	public static final String audience_target_IncExctogglebutton = "Inclusion & Exclusion toogle button,xpath,//span[contains(@class,'k-switch k-switch-md')]";
	public static final String audience_target_recalculatepopupcontent = "Recalculate popup content,xpath,//div[contains(@class,'modal-content')]//p";
	public static final String audience_target_recalculatenowbutton = "Recalculate now,xpath,//div[contains(@class,'modal-content')]//button[.='Recalculate now']";
	public static final String audience_target_recalculatelaterbutton = "Recalculate later,xpath,//div[contains(@class,'modal-content')]//button[.='Recalculate later']";
	public static final String audience_target_recalculatecancelbutton = "Recalculate Cancel button,xpath,//div[contains(@class,'modal-content')]//button[.='Cancel']";
	public static final String audience_target_editTargetListName = "Edit target list name,xpath,//div[@class='nameEditIcon']//i";
	public static final String audience_target_nonloadingcontainer = "Non loading container,xpath,//div[contains(@class,'no-data-container')]";

	// Edit Target list
	public static final String audience_target_edittargetlist = "target list edit,xpath,//span[.='PLACE_HOLDER']//ancestor::div[contains(@class,'rs-card-bottom')]//i[contains(@id,'pencil')]";

	// More info
	public static final String audience_target_moreinfo = "target list more info,xpath,//span[.='PLACE_HOLDER']//ancestor::div[contains(@class,'rs-card-bottom')]//i[contains(@id,'info')]";
	public static final String audience_target_moreinfopopup = "Info Popup,xpath,//div[@class=' master-recip-data-popup']";
	public static final String audience_target_moreinfolinkedcommunication = "Communication Linked ,xpath,(//h5[@class='font-medium'])[1]";
	public static final String audience_target_closeMoreInfo = "Close,id,rs_circle_close_edge";

	// Reach Rate status
	public static final String audience_target_reachratestatus = "Reach Rate status,xpath,//span[.='PLACE_HOLDER']//ancestor::div[contains(@class,'rs-card-bottom')]//span[@class='rcit-avg']//span)[1]";
	public static final String audience_target_reachratepercentage = "Reach Rate Percentage,xpath,//span[.='PLACE_HOLDER']//ancestor::div[contains(@class,'rs-card-bottom')]//div[@class='rstr-cell rstrc-right']//div[@class='rcit-number']/span[1]";
	public static final String audience_target_listrfastatus = "RFA Status,xpath,(//span[text()='PLACE_HOLDER']//ancestor::div[contains(@class,'rs-card-bottom')]//ul//li)[2]";
	public static final String audience_target_advancesearchdropdown = "Advance search dropdown,xpath,//div[@class='box-design box-design css-scrollbar no-box-shadow p10']//ul//li";
	public static final String audience_target_listName = "List Name,xpath,(//div[@class='rci-list-name'])[2]";
	public static final String audience_target_submiticon = "search,xpath,//button[@type='submit']";

	// Target list duplicate
	public static final String audience_target_duplicateAttribute = "Duplicate attribute,xpath,(//h5[.='PLACE_HOLDER'])[TEMP]//..//..//i[contains(@class,'duplicate')]";
	public static final String audience_target_totalAttributeCount = "Duplicate attribute,xpath,(//h5[.='PLACE_HOLDER'])//..//..//i[contains(@class,'duplicate')]";
	public static final String audience_target_updatedDuplicateAttribute = "Duplicate Attribute,xpath,(//h5[.='PLACE_HOLDER'])[TEMP]//..//..//div[contains(@class,'dropdown-required')]";
	public static final String audience_target_removeIcon = "click remove icon,xpath,(//h5[.='PLACE_HOLDER'])[TEMP]//..//..//i[contains(@class,'red')]";
	public static final String audience_target_primaryfilter = "primary filter,xpath,//h5[.='PLACE_HOLDER']";
	public static final String audience_target_removeFilterIcon = "Remove-icon,xpath,//h5[.='PLACE_HOLDER']//..//..//span[.='TEMP']//..//span[contains(@class,'remove')]";

	public static final String audience_target_attributeArrowIcon = "Target attribute enter icon,xpath,//h5[.='PLACE_HOLDER']//..//..//i[contains(@class,'arrow')]";
	public static final String audience_target_attributedropdown = "Attribute dropdown,xpath,//h5[.='PLACE_HOLDER']//..//..//input";
	public static final String audience_target_Nodatafound = "No data found,xpath,//div[@class='k-nodata']//div[text()='NO DATA FOUND.']";
	public static final String audience_target_containfilter = "Contains filter,xpath,//li[contains(@data-complabel,'PLACE_HOLDER')]//span[@role='listbox']";
	public static final String audience_target_containfilterlist = "Contains filter list,xpath,//*[@id='ddlOprOthers_num_PLACE_HOLDER_listbox']/li";
	public static final String audience_target_attributeDropdownValue = "Attribute dropdown,xpath,//li[@data-complabel='PLACE_HOLDER']//input[@placeholder='Enter']";

	// Target list creation negative scenarios
	public static final String audience_target_inputvaluebox = "Filter attributes input value ,xpath, //div[contains(@class,'rs-kendo-multi-dropdown')]//input";
	public static final String audience_target_errormessageEmptyinput = " Empty input values error Message ,xpath,  //div[contains(@class,'rs-kendo-multi-dropdown')]//input//following::label[@class='k-label']";
	public static final String audience_target_filterRemove = " filter remove button,id,rs_SegmentationLists_circle_minus";

	// More Info
	public static final String audience_mdm_channelname = "Channel count,xpath,//div[@class='card-body']//div//small";
	public static final String audience_mdm_notificationwebIdentified = "Notification Web Count,xpath,(//div[contains(@class,'backdrop show')]//..//li//span[.='Identified'])[1]//..//span[2]";
	public static final String audience_mdm_notificationmobileIdentified = "Notification Mobile Count,xpath,(//div[contains(@class,'backdrop show')]//..//li//span[.='Identified'])[2]//..//span[2]";
	public static final String audience_target_allaudiencesegmentationcount = "All audience segmentation count,xpath,//span[.='All audience']//..//..//div[contains(@class,'rci-content')]//span";
	public static final String audience_target_info_audienceSegCount = "Audience total count,xpath,//div[@class='fade modal-backdrop show']//..//h5[contains(.,'Audience by channel')]";
	public static final String audience_target_info_audiencechannelName = "Channel Name,xpath,//h5[contains(.,'Audience by channel')]//..//..//div[@class='mb15 col-sm-6']//ul[@class='px15']//li";
	public static final String audience_target_info_audiencechannelcount = "Channel count,xpath,//h5[contains(.,'Audience by channel')]//..//..//div[@class='mb15 col-sm-6']//ul[@class='px15 text-right']//li";
	public static final String audience_target_info_linkedCommunication = "linked Communication,xpath,//div[@class='fade modal-backdrop show']//..//h5[contains(.,'Communication linked')]";
	public static final String audience_target_info_cgtgName = "CGTG Name,xpath,//h5[contains(.,'Target')]//..//..//div[@class='mb15 col-sm-6']//ul[@class='px15']//li";
	public static final String audience_target_info_cgtgpercentage = "CGTG percentage,xpath,//h5[contains(.,'Target')]//..//..//div[@class='mb15 col-sm-6']//ul[@class='px15 text-right']//li";
	public static final String audience_target_info_previewIcon = "Target list preview icon,xpath,//span[text()='PLACE_HOLDER']//ancestor::div[contains(@class,'rstrc-left')]//i";
	public static final String audience_target_no_data_available = "No data available,xpath,//div[contains(@class,'nodata')]//p";
	public static final String audience_target_encodeValue = "Encode value,xpath,//span[.='PLACE_HOLDER']//ancestor::div[contains(@class,'rstrc-left')]//div[@class='rci-list-id ']";

	// Target Listing Page
	public static final String audience_target_listkebabMenu = "List kebab menu,xpath,(//i[contains(@id,'menu_dot')])";
	public static final String audience_target_listduplicateicon = "List duplicate icon,xpath,//i[@id='rs_data_menu_dot']//..//..//..//div[contains(@class,'dropdown-menu')]//a[.='Duplicate']";
	public static final String audience_target_listcgtgicon = "List CgTg icon,xpath,//i[@id='rs_data_menu_dot']//..//..//..//div[contains(@class,'dropdown-menu')]//a[.='Control group/Target group']";
	public static final String audience_target_matchoutputlist = "match list icon,xpath,//i[@id='rs_data_menu_dot']//..//..//..//div[contains(@class,'dropdown-menu')]//a[.='Match input list']";
	public static final String audience_target_suppressionoutputlist = "Suppression list icon,xpath,//i[@id='rs_data_menu_dot']//..//..//..//div[contains(@class,'dropdown-menu')]//a[.='Suppression input list']";
	public static final String audience_target_popupheader = "Match list popup header,xpath,//div[contains(@class,'modal show')]//h2";
	public static final String audience_target_mat_sup_outputdropdown = "Suppression output dropdown,xpath,//span[contains(@class,'rs-kendo-dropdown-required')]//span[contains(@class,'k-input-value-text')]";
	public static final String audience_target_listattributesdropdown = "Attribute dropdown,xpath,//div[contains(@class,'k-input-values')]";
	public static final String audience_target_Applybutton = "Apply,xpath,//div[contains(@class,'modal-content')]//button[text()='Apply']";
	public static final String audience_target_download = "List Download icon,xpath,//i[@id='rs_data_menu_dot']//..//..//..//div[contains(@class,'dropdown-menu')]//a[.='Download']";
	public static final String audience_targetlist_doticon = "TargetList Dot icon,xpath,//span[.='PLACE_HOLDER']//ancestor::div[contains(@class,'card-bottom')]//i[@id='rs_data_menu_dot']";
	public static final String audience_target_cgtgPopupValidation = "CG/TG popup validation,xpath,//h2[text()='Control group/Target group']";
	public static final String audience_target_cgtgPopupToggle = "CGTG popup toggle,xpath,//h2[text()='Control group/Target group']//span[contains(@class,'k-switch k-switch-md')]";
	public static final String audience_target_enterdupname = "Duplicate name value,xpath,//input[@name='recipientsBunchName']";
	public static final String audience_target_savedupname = "Duplicate save icon,xpath,//div[@class='editNameField']//..//button[@type='submit']";
	public static final String audience_target_listextractionText = "List extraction text,xpath,//div[contains(@class,'rci-content-block')]//span[.='List extraction is in progress']";
	public static final String audience_target_moreinfoNameAndDate = "Created Name And Date,xpath,//div[@class='fade modal-backdrop show']//..//h6";
	public static final String audience_target_moreinfolinkedCommAndSegCount = "Created Linked communication and segmentation count,xpath,//div[@class='fade modal-backdrop show']//..//h5";
	public static final String audience_target_advanceanalyticsicon = "Advance analytics icon,xpath,//div[contains(@class,'data-popup')]//i[contains(@class,'analytics')]";
	public static final String audience_target_advanceanalyticsNoDataFound = "No data found,xpath,//div[@class=' master-recip-data-popup']//p";
	public static final String audience_target_advanceanalytics_questionmark = "Question Mark,xpath,//h4[.='Advanced details - Group by']//..//i[contains(@class,'question-mark')]";
	public static final String audience_target_advanceanalytics_questionmarktext = "Tooltip text,xpath,//ul[contains(@class,'tooltip')]";
	public static final String audience_target_advanceanalyticsdropdown = "advance analytics dropdown,xpath,(//h4[contains(.,'Advanced details')]//..//..//..//div[contains(@class,'k-input')][contains(@class,'kendo')])";
	public static final String audience_target_advanceanalytics_dropdownvalue = "DropdownValue,xpath,//div[@class='k-list-content']//li";
	public static final String audience_target_advanceanalytics_downloadicon = "Download Icon,id,rs_data_download";
	public static final String audience_target_advanceanalyticsarrow = "Arrow icon,xpath,//i[contains(@class,'arrow')]";
	public static final String audience_target_downloadsamplelist = "Download sample list,xpath,//input[@value='Sample list']";
	public static final String audience_target_downloadfullsamplelist = "Download full sample list,xpath,//input[@value='Full segment list']";
	public static final String audience_target_share = "Share,xpath,//input[@value='Share']";
	public static final String audience_target_downloadsearchicon = "Download search icon,xpath,//div[contains(@class,'modal-content')]//i[@id='rs_data_zoom']";
	public static final String audience_target_downloadSearchinput = "Download search input,xpath,//input[contains(@class,'searchInput active')]";
	public static final String audience_target_downloadcloseicon = "Close icon,xpath,//i[@id='rs_RSSearchField_close']";
	public static final String audience_target_clickrightarrowicon = "Right arrow icon,xpath,//button[@title='Transfer To']";
	public static final String audience_target_clickleftarrowicon = "Left arrow icon,xpath,//button[@title='Transfer From']";
	public static final String audience_target_downloadhelptext = "HelpText,xpath,//div[contains(@class,'modal-content')]//small";
	public static final String audience_target_downloadButton = "Download button,xpath,//button[@type='submit']//span[.='Download']";
	public static final String audience_target_csvdownloadheader = "CSV download header,xpath,//h2[text()='Download CSV']";
	public static final String audience_target_csvdownloadhelptext = "CSV download helptext,xpath,//h2[text()='Download CSV']//ancestor::div//div[contains(@class,'modal-body')]//p[text()]";
	public static final String audience_target_downloaddropdown = "Download dropdown,xpath,//div[contains(@class,'modal-body')]//span[@class='k-input-value-text']";
	public static final String audience_target_selectcsvdownloadOtp = "Select Otp,xpath,//div[contains(@class,'k-child-animation-container')]//li";
	public static final String audience_target_cgtgToggleButton = "CG/TG Toggle button,xpath,//h2[text()='Control group/Target group']//..//..//span[contains(@class,'k-switch k-switch-md')]";
	public static final String audience_target_cgTopValue = "CgTop value,xpath,//div[@class='rs-split-top']//input";
	public static final String audience_target_tgTopValue = "TgTop value,xpath,(//div[@class='rs-split-top']//span)[2]";
	public static final String audience_target_slidercgvalue = "Slider Cg value,xpath,//span[contains(@class,'primary-blue')]";
	public static final String audience_target_slidertgvalue = "Slider Tg value,xpath,//span[contains(@class,'primary-orange')]";
	public static final String audience_target_cgtgslider = "CGTG slider,xpath,//img[@id='rs_SplitSlider_Sliderimg']";
	public static final String audience_target_cgtgSaveButton = "CGTG Save Button,xpath,//h2[text()='Control group/Target group']//..//..//button[.='Save']";
	public static final String audience_target_cgtgCancelButton = "CGTG Cancel button,xpath,//h2[text()='Control group/Target group']//..//..//button[.='Cancel']";
	public static final String audience_target_advanceanalyticsnodatafound = "No record found,xpath,//p[text()='No record found']";

	// Target list RFA
	public static final String audience_target_shortname = "Short list Name,xpath,//div[@class='rci-list-name']//span[.='PLACE_HOLDER']";
	public static final String audience_target_approverIcon = "Approver Icon,xpath,//div[.='PLACE_HOLDER']//ancestor::div[@class='rc-info']//following::div[@class='rc-bottom ']//i[@id='rs_data_user_tick']";
	public static final String audience_target_rfaaddicon = "RFA add icon,xpath,//label[.='Approval request']//..//..//i[contains(@class,'plus')]";
	public static final String audience_target_approverdropdown = "approverDropdown,xpath,(//label[.='Approval request']//..//..//div[contains(@class,'dropdown')])[PLACE_HOLDER]";
	public static final String audience_target_approverdropdownfield = "Approval request,xpath,(//label[.='Approval request']//..//..//div[contains(@class,'dropdown')])";
	public static final String audience_target_rfaCheckbox = "RFA approver checkbox,xpath,//input[@id='approvalList.requestApproval']//..";
	public static final String audience_target_rfaCheckboxquestionmarkicon = "RFA Checkbox Questionmark Icon,xpath,//span[.='Request for approval']//..//..//i[contains(@class,'question')]";
	public static final String audience_target_rfaCheckboxhelptext = "HelpText,xpath,//div[contains(@class,'popover-body')]";
	public static final String audience_target_rfaSettingIcon = "RFA setting icon,xpath,//label[.='Approval request']//..//..//i[contains(@class,'setting')]";
	public static final String audience_target_rfaSettingActiveRadioButton = "Active radio button,xpath,//input[@type='radio'][@checked]//..//span";
	public static final String audience_target_rfasettingallradiobutton = "All radio button,xpath,//div[.='Get approval from']//..//input[@value='All'][@type='radio']";
	public static final String audience_target_rfasettinganyradiobutton = "Any radio button,xpath,//div[.='Get approval from']//..//input[@value='Any'][@type='radio']";
	public static final String audience_target_rfasettinganydropdown = "Any radio button dropdown,xpath,//h2[.='Request approval settings']//..//..//span[contains(@class,'k-input-value')]";
	public static final String audience_target_rfasettinganydropdownvalue = "Any button dropdown value,xpath,//input[@type='radio'][@checked]//..//span[.='Any']//ancestor::div//span[contains(@class,'k-input-value')]";
	public static final String audience_target_rfasettingfollowhierarchy = "Follow hierarchy,xpath,//div[.='Follow hierarchy']//..//span[contains(@class,'k-switch k-switch-md')]";
	public static final String audience_target_rfasettingsavebutton = "Save button,xpath,//h2[.='Request approval settings']//..//..//button[.='Save']";
	public static final String audience_target_rfasettingcancelbutton = "Cancel button,xpath,//h2[.='Request approval settings']//..//..//button[.='Cancel']";
	public static final String audience_target_rfasettingcloseicon = "Close icon,xpath,//h2[.='Request approval settings']//..//..//i[contains(@class,'close')]";
	public static final String audience_Target_rfapopup = "RFA popup,xpath,//div[contains(@class,'modal show')]//p";
	public static final String audience_Target_rfapopupCancel = "RFA popup cancel,xpath,//div[contains(@class,'modal show')]//button[.='Cancel']";
	public static final String audience_Target_approverfaButton = "Approve button,xpath,//button[.='Approve']";
	public static final String audience_Target_rejectrfaButton = "Reject button,xpath,//button[.='Reject']";
	public static final String audience_Target_rejectcommentheader = "Reject comment header,xpath,//div[contains(@class,'modal show')]//h2";
	public static final String audience_Target_rejectcommentbox = "Reject comment box,xpath,//textarea[@id='comments']";
	public static final String audience_Target_rejectcommentMaxChar = "Reject comment box Max char,xpath,//textarea[@id='comments']//..//..//small[1]";
	public static final String audience_Target_rejectcommentOccupiedChar = "Reject comment box occupied char,xpath,//textarea[@id='comments']//..//..//small[2]";

	// Fronick
	public static final String dynamic_creation_ruletype2_click = "rule type click,xpath, (//span[@aria-label='Rule type'])[2]";
	public static final String dynamic_creation_rule2_type_click = "type click,xpath, (//span[@aria-label='Type'])[2]";
	public static final String dynamic_creation_ruletype2_values_click = "rule type values click,xpath, (//label[.='Values']//parent::span)[2]";
	public static final String audience_dynamic_updaterule = "Create rule,xpath,//button[normalize-space()='Update rule']";

	// ****************************************************************
	// AUDIENCE MASTERDATA

	public static final String audience_addAudience_Dropdown = " Drop-down list ,xpath,//label[.='Add audience by']//..//..//span[contains(@class,'k-input-value')]";
	public static final String audience_importhist = "Import history icon,xpath,//i[contains(@class,'history')]";
	public static final String audience_importhistalert = "Import history alert,xpath,//div[not(contains(@class,'click-off'))][contains(@class,'actionBlockCol')]//i[contains(@class,'alert')]";
	public static final String audience_importhistalertimportdesc = "Import desc,xpath,(//div[not(contains(@class,'click-off'))][contains(@class,'actionBlockCol')]//i[contains(@class,'alert')]//ancestor::tr//td)[6]";
	public static final String audience_importcompare = "CompareValue,xpath,(//tr)[2]//div[contains(@class,'action')]";
	public static final String audience_dashboardFieldSelector = "Field selector,xpath, //a[@data-original-title='Field selector']";
	public static final String audience_selectdashboardFieldSelector = "CustomColumnSelector,xpath, //*[@id='customColumnSelector']//ul/li";
	public static final String audience_loaddashboardFieldSelector = "Load,xpath, //input[@value='Load']";
	public static final String audience_downloadfile = "Download,xpath, //a[contains(.,'Download')]";

	public static final String audience_Masterdata_Notification_ChartList = "chart values,xpath,//h4[.='Notification']//..//*[contains(@class,'highcharts-data-label highcharts-data-label-color-')]";
	public static final String audience_Masterdata_Notification_tooltip = "chart tooltip values,xpath, //h4[.='Notification']//..//div[contains(@class,'highcharts-label highcharts-tooltip')]";
	public static final String audience_Masterdata_Notification_titleLegend = "notification chart status,css,div[class*='highcharts-legend-item highcharts-pie-series highcharts-color']>span>span";

	public static final String audience_Masterdata_ListAcquisition = " List Acquisition ,xpath, //div[@id='listAnalyticsSection']";
	public static final String audience_Masterdata_ListAcquisitionText = " List Acquisition ,xpath, //h4[normalize-space()='List acquisition']";
	public static final String audience_Masterdata_ListAcquisition_dateRageFilter = " List Acquisition Date range filter ,xpath, //div[@id='dateRange']";
	public static final String audience_Masterdata_ListAcquisition_dateRageFilterDropdown = " List Acquisition Date range filter dropdown ,xpath,//div[@class='daterangepicker dropdown-menu opensleft pdatpicker-show']";
	public static final String audience_Masterdata_ListAcquisition_SourceDropdown = " List Acquisition Channel Source dropdown ,xpath, //div[@id='divChannelSources']/ul";
	public static final String audience_Masterdata_ListAcquisition_Source = " List Acquisition Channel Source ,xpath, //div[@id='divChannelSources']";
	public static final String audience_Masterdata_ListAcquisition_Graph = " List Acquisition graph ,xpath, //div[@id='listAnalyticsSection']//*[@class='highcharts-plot-background']";

	public static final String audience_Masterdata_profileCompletenescloseBtn = " profile Completeness close ,xpath, //div[@class='col-sm-5']//i[@class='icon-close-small icon-sm']";
	/* Breadcrumbs */
	public static final String breadcrumbs = " Breadcrumb,xpath, //div[@class='breadcrumbs']//ul";
	public static final String breadcrumbs_list = " Breadcrumb,xpath, //div[@class='breadcrumbs']//ul//li";
	public static final String pageheader = " Page header text ,xpath,//div[contains(@class,'page-header')]//h1";
	public static final String navigationtab = "Navigation tabs ,xpath, //div[@id='wrapper']//ul[contains(@class,'nav nav-tabs tabs-top')]/li";
	// update master data management

	public static final String audience_masterdata_textchannelvalues = "text value,xpath,//li[@class='col-sm-6 col-xs-6 col-xxs-12 expandable']";
	public static final String audience_masterdata_notificationi_icon = "Notification i-icon,xpath,//a[@class='recipient-view no-hover total-recip-data-5']";

	public static final String audience_masterdata_audiencelisttext = "Table validation,xpath,//h4[contains(@class,'align-items-center')]";
	public static final String audience_masterdata_tableheader = "Table header,xpath,//tr[@role='row']//th[@role='columnheader']";
	public static final String audience_masterdata_fieldselector = "Field selector,xpath,//i[contains(@class,'field-selector')]";
	public static final String audience_masterdata_selectallcheckbox = "Selectall checkbox,xpath,//input[@id='chk_SelectAll']";
	public static final String audience_masterdata_searchicon = "SearchIcon,xpath,//i[@class='icon-search-small icon-xs white']";
	public static final String audience_masterdata_searchvalue = "Search Value,xpath,//*[@id='searchName']";
	public static final String audience_masterdata_loadbutton = "load Button,xpath,//input[@class='btn btn-green btn_audienceLoad']";
	public static final String audience_masterdata_clickaccount = "Click Account checkbox,xpath,//*[@id='chk_Account']";
	public static final String audience_masterdata_validateaccount = "Account Text,xpath,//div[@id='id_audienceGrid']//th[@data-field='Account']";

	// Audience Sync History
	public static final String audience_synchistory_ListTimeStamp = "List Date ,xpath,//div[@id='SyncHistoryImport']//tr//td[4]";
	public static final String audience_synchistory_ListName = "List name ,xpath,(//div[@id='SyncHistoryImport']//tr//td[6])";
	public static final String audience_synchistory_rows = "table row list,xpath,//div[@id='SyncHistoryImport']//tbody//tr";
	public static final String audience_synchistory_SorceRows = "table row list,xpath,(//div[@id='SyncHistoryImport']//tr//td[1])";
	public static final String audience_synchistory_source = "Source Filter,xpath,//div[@id='SyncHistoryImport']//th[@data-title='Source']//span";
	public static final String audience_synchistory_importDescription = "Import Description Filter,xpath,//div[@id='SyncHistoryImport']//th[@data-title='Import description']//span";
	public static final String audience_synchistory_filterDropdown = "Filter dropdown,xpath,//span[@class='k-dropdown-wrap k-state-default k-state-focused']";
	public static final String audience_synchistory_filterDropdown_list = "Filter dropdown list,xpath,//*[contains(@class,'k-reset k-state-border-up')]//li";
	public static final String audience_synchistory_filterInput = "Input,xpath,//*[contains(@class,'k-reset k-state-border-up')]//input[@class='k-textbox']";
	public static final String audience_synchistory_filterBtn = "Filter button,xpath,//*[contains(@class,'k-state-border-up')]//button[@type='submit']";
	public static final String audience_synchistory_cancelBtn = "Clear button,xpath,//*[contains(@class,'k-state-border-up')]//button[@type='reset']";
	public static final String audience_pagination_nextpage = "Go to the next page Btn,xpath,//div[contains(@class,'tab-pane active')]//a[@title='Go to the next page' and not (contains(@class,'state-disabled'))]";
	public static final String audience_pagination_totalpage = "Total page,xpath,//span[@class='k-pager-input k-label']";

	// AUDIENCE UPLOAD
	public static final String audience_uploadheader = "Audience upload header,xpath, //h1[contains(.,'Add audience')]";

	public static final String audience_sourcetype = "Add audience by source type,xpath,//*[@id='importModeSelector_listbox']/li";

	public static final String audience_selectagreement = "Agreement proceed,xpath,//button[text()='I agree & proceed']";

	public static final String audience_listingPage_listname = "Created list Name,xpath,//tr[contains(@class,'k-master-row')]//td[text()='PLACE_HOLDER']";

	public static final String audience_headerchkbox = "Manual upload header,xpath, //*[@id='firstRowHeader']";
	public static final String audience_manualentry = "ManualRecipientsTextArea,xpath, //textarea[contains(@name,'ManualRecipientsTextArea')]";
	public static final String AudienceMatchlist_AgreeProceed = "Match agree and proceed,xpath, //*[@id='myCarouselMatchlist']/div/div/div/input[2]";
	public static final String suppressiolistAgreeandProceed = "Suppression agree and proceed,xpath,//*[@id='myCarouselSuppressionlist']/div/div/div/input[2]";
	public static final String AudienceMatchSplitdropdown = "Split dropdown,xpath,//li[contains(@data-original-title,'Split')]/div/ul/li";
	public static final String AudienceMatchListnamedropdownSelect = "Input list,xpath, //*[@id='MatchSuppressionListName_listbox']/li";
	public static final String AudienceMatchListAttributenameSelect = "MatchSuppressionAttributeList,xpath, //*[@id='res-MatchSuppressionAttributeList_listbox']/li";
	public static final String AudienceMatchSupressionSubmit = "Submit,xpath, //a[contains(.,'Submit')]";
	public static final String audience_clickftpListtype = "ftpListSelection,xpath, //span[@aria-owns='ftpListSelection_listbox']";
	public static final String audience_selectsftpListname = "List type,xpath, //*[@id='ftpListSelection_listbox']/li";
	public static final String audience_ftpsftp_rds_connect = "RDS button,xpath, //input[@id='btnRDS']";
	public static final String audience_ftpsftp_updatecycle = "updateCycleSelector,xpath, //span[@aria-owns='updateCycleSelector_listbox']";
	public static final String audience_ftpsftp_selectcyclefrequency = "Frequency,xpath, //*[@id='updateCycleSelector_listbox']";
	public static final String audience_rds_clickconntypelistbox = "Connection type,xpath, //span[@aria-owns='id_select_connectiontype_listbox']";
	public static final String audience_rds_selectconntypelistitem = "Connection type list,xpath, //ul[@id='id_select_connectiontype_listbox']/li";
	public static final String audience_rds_clickconntypetable = "Connection type table,xpath, //span[@aria-owns='tableSelector_listbox']";
	public static final String audience_rds_selectconntypetableitems = "Table list,xpath, //*[@id='tableSelector_listbox']/li";
	public static final String audience_ftp_radiobtn = "Radio button FTP,xpath, //input[@id='ftp']";
	public static final String audience_sftp_radiobtn = "Radio button SFTP,xpath, //input[@id='sftp']";
	public static final String audience_ftpsftp_container = "FTPContainerSelection,id,FTPContainerSelection";
	public static final String audience_ftpsftp_friendlyname = "ftpfriendlyname,id,ftpfriendlyname";
	public static final String audience_ftpsftp_ipaddress = "ftpIpAddress,id,ftpIpAddress";
	public static final String audience_ftpsftp_portnumber = "ftpPortNumber,id,ftpPortNumber";
	public static final String audience_ftpsftp_username = "ftpUserName,id,ftpUserName";
	public static final String audience_ftpsftp_password = "ftpPassword,id,ftpPassword";
	public static final String audience_ftpsftp_filepath = "ftpFilePath,id,ftpFilePath";
	public static final String audience_Rds_scrolltoviewWebinar = "Webinar,xpath, //a[contains(.,'Webinar')]";
	public static final String audience_rdsmysql_enteripaddress = "sqlIpAddress,xpath, //input[@id='sqlIpAddress']";
	public static final String audience_rdsmysql_enterportno = "RdsPortNumber,xpath, //input[@id='RdsPortNumber']";
	public static final String audience_rdsmysql_enterdbname = "sqlDatabaseName,xpath, //input[@id='sqlDatabaseName']";
	public static final String audience_rds_odbc_databaseiconclick = "Database icon,xpath, //a[contains(.,'Database')]";
	public static final String audience_rds_mysql_iconclick = "Mysql connect icon,xpath, //*[@id='odbc']//a[@class='add-ap no-hover mysql-connect']";
	public static final String audience_rds_mssql_iconclick = "Sql server icon,xpath, //*[@id='odbc']//a[@class='add-ap no-hover sql-server']";
	public static final String audience_negative_upload_errormsg = "Upload error msg,xpath, //label[@id='incorrect']";
	public static final String audience_rdsmysql_enterusername = "sqlUserName,xpath, //input[@id='sqlUserName']";
	public static final String audience_rdsmysql_enterpassword = "sqlPassword,xpath, //input[@id='sqlPassword']";
	public static final String audience_rds_selecttablecolumnvalues = "Table column val,xpath, //ul[@id='ulLeft']/li";
	public static final String audience_rds_enterselectedtablevalues = "Selected table column val,xpath, //a[@class='rightArrow']";
	public static final String audience_ftpsftp_upload = "ftpsftp upload,xpath, //input[@onclick='fnUploadData();']";
	public static final String audience_rdsmssql_clicktocheckforupdates = "MSSql fieldToCheckSelector,xpath, //span[@aria-owns='fieldToCheckSelector_listbox']";
	public static final String audience_rdsmssql_slectvalueforupdates = "MSSql fieldToCheckSelector list,xpath, //*[@id='fieldToCheckSelector_listbox']/li";

	// UPLOAD CSV NEGATIVE
	public static final String seedListErrorMaxFiles = "Max 100 seeds message shows,xpath,//span[@id='errMsgSeedListMax']";
	public static final String importDescerrMsgImportDesc = "errMsgImportDesc,xpath,//span[@id='errMsgImportDesc']";
	public static final String importDescerrMsgspecialCharacter = "errMsgspecialCharacter,xpath,//span[@id='errMsgspecialCharacter']";
	public static final String importFileerrMsgColumnHeaders = "errMsgColumnHeaders,xpath,//span[@id='errMsgColumnHeaders']";
	public static final String importFileerrMsgChoosefile = "errMsgChoosefile,xpath,//span[@id='errMsgChoosefile']";
	public static final String importFileerrMaxSize = "errMsgCSVMaxSize,xpath,//span[@id='errMsgCSVMaxSize']";
	public static final String importFileerrMaxNumberofFiles = "errMsgBrowseMax,xpath, //span[@id='errMsgBrowseMax']";
	public static final String importFileerrDuplicateCsvfile = "errMsgDuplicateFileUpload,xpath, //span[@id='errMsgDuplicateFileUpload']";
	public static final String importFileerrDuplicateimportdesc = "errMsgImportDescAlreadyExist,xpath, //span[@id='errMsgImportDescAlreadyExist']";
	public static final String audienceimportclickfirstrowheader = "firstRowHeader,xpath, //input[@id='firstRowHeader']";
	public static final String audienceimportemptyfile = "Empty file,xpath, //*[@id='progressInfo']//div[2]";
	public static final String audienceimportmatchsuppressionwrongcolumnheaders = "Wrong column header,xpath, (//*[@id='progressInfo']//div[2])[3]";

	// XML Negative Scenario
	public static final String errmsgxmlmaxallowedfilesize = "errMsgXMLMaxSize,xpath, //span[@id='errMsgXMLMaxSize']";
	public static final String errmsgxmlotherthanxmlfile = "errMsgBrowseXML,xpath, //span[@id='errMsgBrowseXML']";
	public static final String errmsgsameimportclick = "txtBrowseXML,xpath, //*[@id='txtBrowseXML']";
	public static final String audience_newattributename = "New attribute name,xpath,//div[@class='border-bottom-required']//..//input[@id='uIPrintableName']";
	public static final String audience_unmapmsg = "Unmap Message,xpath, //*[@id='errmsgSelect1']/div";
	public static final String audience_titleheader = "Title header,xpath, //span[@class='k-input'][contains(text(),'Email')]";
	public static final String audience_uniquekeyselected = "Unique key selected,xpath,//i[@class='icon-user-tick-medium icon-xs']";
	public static final String audience_selectuniquekey = "Select unique,xpath,(//i[@class='icon-settings-small icon-xs'])[3]";
	public static final String audience_uniquekey = "Unique identifier,xpath, (//a[@title='Unique identifier'])[3]";
	public static final String audience_selectheader = "Column header,xpath, //*[@class='k-input'][contains(text(),'Select')][1]";

	public static final String audience_mapvalue = "FieldType list,xpath, //*[@id='fieldType_listbox']/li";
	public static final String audience_selecttitle = "Column map,xpath, (//span[@class='k-input'])[1]";
	public static final String audience_titlevalue = "Column map list,xpath, //*[@id='fieldType_listbox']/li";

	// Audience Page Target List
	public static String dynamicXpathTarget = "<- dynamicXpath ->";
	public static final String audience_target_newlistsegment = "New list segment button,xpath,//*[@data-original-title='New list segment']";
	public static final String audience_target_enterlistname = "Target list name,xpath,//input[@placeholder='Enter the list name']";

	public static final String audience_target_totalrecipients = "Total target audience,xpath,//*[@id='totalRecipients']";

	public static final String audience_target_updatelist = "Update target list icon,xpath,//*[@id='updateSegList']";
	public static final String audience_target_functionWidget = "Function widget,xpath,//ul[@class='widget-listsettings clearfix click-off']";
	public static final String audience_target_clickduplicate = "Duplicate icon,xpath,(//*[@class='duplicate-recipitList'])";

	public static final String audience_target_Targetlistdownload = "Target list download icon,xpath,(//i[contains(@class,'icon-csv-medium icon-sm')])[1]";
	public static final String audience_target_downloadSelectedAttributes = "Request to download,xpath,//div[@class='multiRghtClm']/ul/li";
	public static final String audience_target_Selectattributedownloadtype = "Atrribute select to download,xpath,//*[@class='grid-style scroll_list_attribues css-scrollbar']/li";
	public static final String audience_target_selectattributetype = "Right arrow button,xpath,//a[@class='rightArrow']";
	public static final String audience_target_downloadlist = "Request to download button,xpath,//*[@id='editCategorySaveBtn']";
	public static final String audience_target_selectcheckbox = "Rfa check box,xpath,//*[@id='IsRequestApprovalSection']/..//input[@class='checkbox approval']";
	public static final String audience_target_selectapprovalto = "Rfa mail dropdown,xpath,//span[@aria-owns='id_SRA_MailRequest1_listbox']";
	public static final String audience_target_selectapprover = "Rfa mail list,xpath,//*[@id='id_SRA_MailRequest1_listbox']/li";
	public static final String audience_target_addapprover = "Rfa approver add icon,xpath,//i[@title='Add']";
	public static final String audience_target_selectapprover2 = "Rfa second approver,xpath,//*[@id='id_SRA_MailRequest2']/..//span/span[contains(.,'--Select--')]";
	public static final String audience_target_selectapprover3 = "Rfa second approver,xpath,//*[@id='id_SRA_MailRequest3']/..//span/span[contains(.,'--Select--')]";
	public static final String audience_target_enterapprover2 = "Rfa second approver,xpath,//*[@id='id_SRA_MailRequest2_listbox']/li";
	public static final String audience_target_enterapprover3 = "Rfa third approver,xpath,//*[@id='id_SRA_MailRequest3_listbox']/li";
	public static final String audience_target_approvalsettings = "Rfa approval settings,xpath,//*[@id='id_RequestApprovalSetting']/i";
	public static final String audience_target_approvefromall = "Rfa setting all,xpath,//*[@id='id_All']";
	public static final String audience_target_heirarchySelect = "Rfa hierarchy,xpath,//label[contains(text(),'Follow hierarchy')]/..//div/label";
	public static final String audience_target_selectsave = "Rfa settings save button,xpath,//*[@id='btn_Save_requestApprovalSettings']";
	public static final String audience_target_selectAny = "Rfa setting any,xpath,//input[@id='id_Any']";
	public static final String audience_target_selectanydrpdown = "Rfa setting any dropdown,xpath,//select[@class='required input-xlarge selectTriggCondition']";
	public static final String audience_target_enteranydrpdown = "Any dropdown value,xpath,//select[@class = 'required input-xlarge selectTriggCondition']/option ";

	public static final String audience_target_timefreqmonthselect = "Year select,xpath,(//select[@class='monthselect'])[1]";
	public static final String audience_target_timefreqmonthenter = "Year dropdown,xpath,(//select[@class='monthselect'])[1]//option";
	public static final String audience_target_timefreqfirstdateselect = "date select,xpath,(//td[@class='available'][contains(.,'1')])[1]";
	public static final String audience_target_customfilterclickapply = "apply button,xpath,//button[contains(.,'Apply')]";

	public static final String audience_target_mandatoryreject = "Rfa Mandate Reject button,xpath,//a[@id='id_aCommnetRequestApproval']";
	public static final String audience_target_mandatorysetting = "Rfa mandate setting,xpath, //i[@class='icon-asterisk-mini icon-xs  grey']";
	public static final String audience_target_rejectmsg = "Rfa reject message,xpath,//textarea[@class='form-control']";
	public static final String audience_target_rejectsave = "Rfa reject save button,xpath,//input[@onclick='RequestApprovalReject()']";
	public static final String audience_rfaRejectmessagepopup = "Rfa reject pop up,xpath,//p[contains(text(),'This Target List has been already rejected by an approver')]/../../button";

	public static final String audience_target_AddInclusion = "Inclusion dropdown,xpath,//a[contains(.,'Inclusion')]";
	public static final String audience_target_bootstrapswitch1 = "Bootstrap switch,xpath, //span[@class='bootstrap-switch-handle-on bootstrap-switch-primary'][contains(.,'AND')]";
	public static final String AudienceMatchOPsplitclick = "Matchop split icon,xpath,(//li[contains(@class,'col-sm-2 audienceControlList')])";
	public static final String AudienceTargetMoreInfo = "More info,xpath,(//a[contains(@class,'getCampaignBlastDetails')])";
	public static final String AudienceTargetMoreInfocommuncationsBlasted = "Target list more info communcation,id,campDetailsId";
	public static final String AudienceTargetMoreInfoCommuncation = "Target list more info total audience,xpath,(//li[contains(@class,'col-sm-2 audienceControlList')])";

	public static final String audience_target_tooglebutton = "Toogle button PLACE_HOLDER,xpath,(//span[contains(@class,'k-switch k-switch-md')])[PLACE_HOLDER]";
	public static final String audience_target_tooglebuttonStatusOn = "Toggle button text,xpath,//span[contains(@class,'k-switch-label-on')]";
	public static final String audience_target_tooglebuttonStatusOff = "Toggle button text,xpath,//span[contains(@class,'k-switch-label-off')]";
	public static final String audience_target_tooglebuttonStatusNot = "Toggle button text,xpath,(//span[contains(@class,'PLACE_HOLDER')])//span[contains(@class,'k-switch-label-off')]";

	public static final String AudienceMatchListnamedropdownClick = "Matchlist dropdown,xpath,(//span[@unselectable='on'][contains(.,'List name')])[3]";
	public static final String AudienceMatchListAttributenamedropdownClick = "Matchop dropdown list,xpath,//input[contains(@aria-owns,'res-MatchSuppressionAttributeList_taglist')]";
	public static final String targetlistTotalAudienceCount = ",xpath,(//span[contains(text(),'Total audience:')]/..)[2]";
	public static final String targetlistMoreInfoicon = "More info icon,xpath,//li[@data-original-title='More info']";
	public static final String targetlistMoreInfoCount = ",xpath,//h5[@class='white'][contains(.,'Audience by channel')]";
	public static final String targetlistMoreInfoByChannel = ",xpath,//ul[@id='lidid_ListtypeAttribute']/li";
	public static final String targetlistMoreInfoClose = "More info close icon,xpath,//a[contains(@class,'pull-right no-hover close-widget')]";
	public static final String targetlistsubscribercountIcon = "Subscriber count icon,xpath,//span[contains(text(),'Total audience:')]/../a";
	public static final String targetlistsubscribercountPerPage = "Subscriber count per page,xpath,//*[@id='subscriberGrid']/div[3]/span[2]/span/span/span[2]/span";
	public static final String targetlistsubscribercountPerPage20 = "Subscriber count per page,xpath,//div[@class='k-animation-container']//li[contains(@title,'20')]";
	public static final String targetlistsubscribercountTotalList = ",xpath,//div[@class='listView userGridView']//tbody[@role='rowgroup']/tr";
	public static final String AudienceSeedlist_AgreeProceed = "Seedlist agree proceed,xpath, (//div[@id='myCarouselseed']//input)[2] ";
	public static final String AdhoclistAgreeandProceed = "Adhoclist agree proceed,xpath, (//div[@id='myCarousel']//input)[2]";
	public static final String MatchlistAgreeandProceed = "Matchlist agree proceed,xpath, (//*[@id='myCarouselMatchlist']//input)[2]";
	public static final String SuppressionlistAgreeandProceed = "Sup list agree proceed,xpath, (//*[@id='myCarouselSuppressionlist']//input)[2]";
	public static final String Targetlistingpagelistview = "List view,xpath, //*[@id='aToggleView']/i[@class='icon-circle-list-medium icon-md']";
	public static final String targetlistingpageseek = "seeklastpage icon,xpath, //span[@class='k-icon k-i-seek-e']";
	public static final String targetListDownloadLink = "TargetList download link get,xpath,//b[contains(.,'Click here to access your download')]/..";
	public static final String targetListDownloadButton = "Download button,xpath,//a[contains(text(),'Download')]";

	public static final String audience_target_AddExclusion = "Exclusion button,xpath,//a[.='Exclusion']";
	public static final String audience_target_bootstrapswitch2 = "BootStrap Switch,xpath,//div[contains(@id,'crbGroupContainerExclusion')]";

	public static final String audience_target_selectexclusionvalue = "xpath, //*[@id='multiauto_2-selectized']";
	public static final String audience_target_closesearch = "xpath, //i[@class='icon-close-small icon-xs red']";

	// Target list attributes
	public static final String audience_target_attributesHeaderName = "HeaderName,xpath,//div[@class='card-header']//span[not(contains(@class,'dropdown'))]";
	public static final String audience_target_headerName = "HeaderName,xpath,//span[.='PLACE_HOLDER']";
	public static final String audience_target_visibleattributes = "VisibleAttributes,xpath,//span[.='PLACE_HOLDER']//ancestor::div[@class='card']//li";
	public static final String audience_target_headersDropdown = "PLACE_HOLDER dropdown,xpath,//span[.='PLACE_HOLDER']//..//..//span[contains(@class,'dropdown-mini')]";
	public static final String audience_target_dropdownattributes = "Dropdown Attributes,css,div[class*='filterAttributeDropdownContainer']>ul>li>span[class='k-link k-menu-link']>div[class*='position-relative']>div>label>span";

	/*** target list Filter menu ***/
	// Ajith
	public static final String audience_Filter_Menu = " Filter Menu,xpath,//span[@class='rs-dt-calendar-text']";
	public static final String audience_FilterMenu_List = "Filter List,xpath,//ul[contains(@class,'daterangepicker')]//li";
	public static final String audience_ListTimeStamp = "List Date ,xpath, //*[@class='well creationstamp']//span[@class='mDateSubt_02']";
	public static final String audience_ListName = "List name ,xpath, //h5[@class='no-margin seg-title']";
	public static final String customRange_Startmonth = " Start Month ,xpath, //div[@class='calendar left']//select[@class='monthselect']";
	public static final String customRange_StartmonthList = "Start Month,xpath, //div[@class='calendar left']//select[@class='monthselect']/option";
	public static final String customRange_Startyear = " Start year ,xpath, //div[@class='calendar left']//select[@class='yearselect']";
	public static final String customRange_StartyearList = "Start year year ,xpath, //div[@class='calendar left']//select[@class='yearselect']/option";
	public static final String customRange_EndMonth = " End Month ,xpath, //div[@class='calendar right']//select[@class='monthselect']";
	public static final String customRange_EndMonthList = "End Month ,xpath, //div[@class='calendar right']//select[@class='monthselect']/option";
	public static final String customRange_Endyear = "End year ,xpath, //div[@class='calendar right']//select[@class='yearselect']";
	public static final String customRange_EndyearList = "End Year ,xpath, //div[@class='calendar right']//select[@class='yearselect']/option";
	public static final String customRange_Applybtn = "Apply Button ,xpath, //button[@class='btn-small btn-green applyBtn btn']";
	public static final String customRange_LeftTable = "Custom Range calender Left table ,xpath, //div[@class='calendar left']//tbody";
	public static final String customRange_RightTable = "Custom Range calender Right table ,xpath, //div[@class='calendar right']//tbody";
	public static final String audience_clickpagination_NextPage = " Next Pagination button ,xpath, //div[@id='dlistpartial']//a[@title='Next']";
	public static final String audience_displayingList = "Total list displaying the page ,xpath, //span[@class='display']";
	public static final String audience_target_errormessageEmpty = " Enter empty list name error Message ,xpath, //span[@id='errMsgRecipientsBunchName']";
	public static final String audience_target_errormessageSpecialChar = " Enter special charcter error Message ,xpath, //span[@id='errMsgRecipientsSpecialcharacter']";
	public static final String audience_target_errormessageExistname = " Enter already exist name error Message ,xpath, //span[@id='errMsgRecipientsBunchNameExists']";

	public static final String audience_target_errormessagefiltergroup = " Primary Filter group error Message ,xpath, //div[@class='padding-T10 position-relative red groupfilterValidate']";

	public static final String audience_target_inputvalues_List = " Filter attributes input value list ,xpath,//li[contains(@id,'filterBuildComp')]//div[@class='selectize-dropdown-content']/div";

	public static final String audience_target_errormessageRFA = " Error Message for without selecting RFA email ,xpath, //span[@id='SRA_errUnselect']";
	public static final String audience_target_RFAalertmessage = " RFA validation Alert popup message ,xpath, //div[@id='commonValidationAlertMessage']//div[@class='modal-footer']//p";
	public static final String audience_target_RFAalertclose = " popup close button  ,xpath, //div[@id='commonValidationAlertMessage']//*[@class='close blue icon-close-small modalCloseIcon']";
	public static final String audience_target_attributeDropdown = "Attribute dropdown,xpath,//li[@data-complabel='" + dynamicXpathTarget + "']//ul[@id='textValue']//input";

	// Vijay
	public static final String audience_target_selectanalyticattribute = "select analytics attribute,xpath,//div[@class='sankey-table-view']//div[@class='k-multiselect-wrap k-floatwrap']";
	public static final String audience_target_enteranalyticattribute = "enter analytics attribute,xpath,//div[@class='k-animation-container']/div/ul//li[@class='k-item']";
	public static final String audience_target_analyticssearch = "search analytics,xpath,//div[@class='widget-box info-popup serOn']//child::div[@class='col-sm-12']//a/i";
	public static final String audience_target_analyticstableheader = "table header,xpath,//div[@id='id_grid']/table/thead/tr/th";
	public static final String audience_target_analyticstabledata = "table data,xpath,//div[@id='id_grid']//descendant::tbody/tr";
	public static final String audience_target_nodatafoundtext = "No data found text,xpath,//div[@id='id_grid']/h3[@class='text-center white']";
	public static final String audience_target_attributeerrormessage = "Validation message,xpath,//div[@class='widget-box info-popup serOn']//div[@class='col-sm-12']//*[@id='errMorethan5AttributeSelect']";
	public static final String audience_target_moreinfoicon = "more info,xpath,//li[contains(@data-segmentationlistname,'" + dynamicXpathTarget + "')]/following-sibling::li//i[contains(@class,'info')]";
	public static final String audience_target_advancedetails = "Advanced details,xpath,//h3[@title='" + dynamicXpathTarget + "']/../..//a[@id='sankeyIcon']/i";
	public static final String audience_target_downloadicon = "Advance details download icon,xpath,//div[@class='widget-box info-popup serOn']//a[@id='id_OtpModal']";
	public static final String audience_target_returnToMasterData = "Return To Master Data,xpath,//input[@value='Return to the master list']";
	public static final String audience_target_detailstabledata = "Total table value,xpath,//div[@id='id_grid']/table";
	public static final String audience_target_closeicon = "Advance details close icon,xpath,//div[@class='widget-box info-popup serOn']//a[@id='closewidgetlist']";
	public static final String audience_target_allaudience_moreinfoicon = "allaudience,xpath,(//div[@id='dlistpartial']//div[@class='widget-listbody'])[1]//li[@data-original-title='More info']";

	// Advance OTP
	public static final String audience_target_otpPage_sentto = "Otpsendto,xpath,//span[@aria-owns='select_otpAAD_listbox']//span[@class='k-input'][.='-- Select --']";
	public static final String audience_target_otpPage_sendtoList = "otpPagesendtoList,xpath,//*[@id='select_otpAAD_listbox']//li";
	public static final String audience_target_enterOTP = "Otpvalue,xpath,//*[@id='otptxtAAD']";
	public static final String audience_target_confirmbutton = "Confirm button,xpath,//div[@id='confirmScheduleAAD']//input[@id='btnschedule']";
	public static final String audience_target_advance_tableheader = "TableHeader,xpath,//div[@id='id_grid']//thead[@class='k-grid-header']";
	public static final String audience_target_advance_tabledata = "Tabledata,xpath,//div[@id='id_grid']//th//..//..//..//tbody//tr";

	public static final String audience_target_SegmentationType = "Segmentation list,id,dropdown-basic-buttons";
	public static final String audience_target_SegmentationType_Options = "Segmentation list option,xpath,//div[@class='css-scrollbar overflow-dropdown']//a";

	// target group/control group
	public static final String audience_target_targetgroupicon = "Target/Controlgroup,xpath,//div[@class='dropdown pull-right default-dropdown open']//a[.='Control group/Target group']";
	public static final String audience_target_spliticon = "Targetlist split icon,xpath,//h5[@title='" + dynamicXpathTarget + "']//..//..//ul//li[@class='col-sm-2 audienceControlList ']";
	public static final String audience_target_bootstrapicon = "Targetbootstrap icon,xpath,//li[@data-segmentationlistname='" + dynamicXpathTarget + "']//..//div[contains(@class,'bootstrap')]";
	public static final String audience_target_groupslider = "Target/control group slider icon,xpath,//li[@data-segmentationlistname='" + dynamicXpathTarget + "']//..//div[@class='splitEnableSwtich']//div[contains(@class,'my-handle')]";

	// DYNAMIC LIST PAGE
	public static final String audience_dynamic_newdynamiclist = "New dynamic list(+),xpath,//i[contains(@class,'circle-plus-fill')]";
	public static final String audience_dynamic_dynamiclistname = "Dynamic list name,xpath,//input[@id='dynamicListName']";
	public static final String audience_dynamic_selecttrigger = "Trigger source,xpath,//span[@class='k-input-value-text']";
	public static final String audience_dynamic_entertrigger = "Trigger source list,xpath,//div[@class='k-list-content']//li";
	public static final String audience_dynamic_click = ",xpath, //*[@id='crbGroup_1']/div/div[2]/div/div[2]";
	public static final String audience_dynamic_selecttriggertype = "Trigger type,xpath,(//span[@class='k-input-inner'])[2]";
	// + "//span[@aria-label='Rule type']//span[@class='k-input-value-text']";
	public static final String audience_dynamic_addmandate = "Add amndate,xpath, (//i[@data-val='0'])[1]";
	public static final String audience_dynamic_addmandate2 = "Add amndate 2,xpath, (//i[@id='addmandatory'])[2]";
	public static final String audience_dynamic_addmandate3 = "Add amndate 3,xpath, (//i[@id='addmandatory'])[3]";
	public static final String audience_dynamic_addmandate4 = "Add amndate 4,xpath, (//i[@id='addmandatory'])[4]";
	public static final String audience_dynamic_entertriggercondition = "Trigger condition,xpath, //input[@id='matchCount1']";
	public static final String audience_dynamic_mobappselect = "App name,xpath, //*[@id='crbGroup_1']//span[contains(text(),'-- App Name --')]";
	public static final String audience_dynamic_entermobapp = "Mobile app,xpath, //*[@id='facebookAccount_listbox']/li";
	public static final String audience_dynamic_entertriggertype = "TriggerType listbox,xpath,//div[@class='k-list-content']//li";
	public static final String audience_dynamic_selecttriggervalue1 = "Trigger value,xpath, //div[@id='isMandatory1']//div[@class='col-sm-6 col-xs-12 trigger-source-change hide']";
	public static final String audience_dynamic_entertriggervalue1 = "Trigger value,xpath, //*[@id='triggerTypedropchange_listbox']/li";
	public static final String audience_dynamic_clickdomainname = "Trigger dropdown,xpath, //span[@class='k-input'][contains(.,'-- Domain Name --')]";
	public static final String audience_dynamic_selecttriggerdropdown = "Trigger dropdownlist,xpath, //*[@id='facebookAccount_listbox']/li";

	public static final String audience_dynamic_selecttriggertypenew = "Treigger type new,xpath, //span[@unselectable='on'][@class='k-input'][contains(.,'--Type--')]";
	public static final String audience_dynamic_entertriggertype2 = "Treigger type web,xpath, //*[@id='triggerType_web2_listbox']/li";
	public static final String audience_dynamic_commtriggerselect = "Type webSubscriptionForm,xpath,//*[@id='input-blank-webSubscriptionForm']//span[contains(text(),'--Select--')]";
	public static final String audience_dynamic_g2triggeraction = "Trigger action,xpath, //div[@class='col-md-6 SFddl2class']";
	public static final String audience_dynamic_entercommtrigger = "trigger commName,xpath, //*[@id='SFddl1_listbox']/li";
	public static final String audience_dynamic_getriggeractionenter = "Trigger action,xpath, //*[@id='SFddl2_listbox']/li";
	public static final String audience_dynamic_selectmobileact = "Mobile action,id,triggerTypedropchange-selectized";
	public static final String audience_dynamic_approver = "Approver1,xpath,//ul[@role='listbox']//li";
	public static final String audience_dynamic_approvalto = "Approval 1,xpath, //span[@aria-label='Approver 1']";
	// "Approval to,xpath,//span[@aria-label='Select approver Email ID']";
	public static final String audience_dynamic_rfachkbox = "RFA checkbox,xpath,//input[@id='approvalList.requestApproval']";
	public static final String audience_dynamic_addapprover2 = "Approver 2 add,xpath, //*[@id='id_addDynamicddl']/i";
	public static final String audience_dynamic_selectapprover2 = "Approver 2,xpath, //span[contains(text(),'--Select--')]";
	public static final String audience_dynamic_enterapprover2 = "Approver 2 list,xpath, //*[@id='id_SRA_MailRequest2_listbox']/li";
	public static final String audience_dynamic_enterapprover3 = "Approver 3 list,xpath, //*[@id='id_SRA_MailRequest3_listbox']/li";
	public static final String audience_dynamic_approvalsettings = "RFA settings,xpath, //*[@class='icon-rs-settings-medium color-primary-blue icon-md ']";
	// "//*[@id='id_RequestApprovalSetting']/i";
	public static final String audience_dynamic_approvefromall = "RFA All,xpath, //*[@id='id_All']";
	public static final String audience_dynamic_editnameicon = "Edit name icon,xpath, //i[@class='icon-edit-pencil-mini icon-sm blue']";
	public static final String audience_dynamic_editname = "Edit name,xpath, //input[@class='form-control required  verify-field row']";
	public static final String audience_dynamic_dlsubform = "Form,xpath, //span[@title='--Select--']";
	public static final String audience_dynamic_selectsubformaction = "Form action,xpath, //div[@class='col-md-6 SFddl2class']//span[contains(text(),'--Select')]";
	public static final String audience_dynamic_subformaction = "Form action list,xpath, //*[@id='SFddl2_listbox']/li";
	public static final String audience_dynamic_selectaudbase = "Audience base,id,triggerTypedropchange-selectized";
	public static final String audience_dynamic_enteraudbase = "Audience base value,xpath, //div[@class='selectize-dropdown-content']/div[position()>1]";
	public static final String audience_dynamic_edittriggertype = "Trigger type edit,xpath, //*[@id='trigger-source']/span/span";
	public static final String audience_dynamic_createrule = "Create rule,xpath,//button[normalize-space()='Create rule']";
	public static final String audience_dynamic_clicksave = "Save,xpath, //*[@id='lsStepsBtn']";
	public static final String audience_dynamic_clicktimefreq = "Time frequency,xpath, //i[@class='icon-calendar-mini icon-xs blue']";
	public static final String audience_dynamic_selecttimefreq = "Time frequency,xpath, //*[@class='ranges']/ul/li";
	public static final String audience_dynamic_searchlist = "Advaced search,xpath, //a[@class='no-hover advanedSearchSlideClk']";
	public static final String audience_dynamic_searchlistvalue = "Search value,xpath, //*[@id='autoFilterSearch']";
	public static final String audience_dynamic_searchlistSelect = "AutoFilterSearch listbox,xpath, //ul[@id='autoFilterSearch_listbox']/li";
	public static final String audience_dynamic_editlist = "Edit list,xpath, //*[@class='icon-edit-pencil-small icon-sm']";
	public static final String audience_dynamic_addnewlist = "Add new list,xpath, //a[@id='addtriggerPush_web']";
	public static final String audience_dynamic_addneweditlist = "Add new edit,xpath, //*[@id='addtriggerPush_webEdit']";
	public static final String audience_dynamic_edittriggertype1 = "Trigger type,xpath, //span[contains(text(),'--Type--')]";
	public static final String audience_dynamic_entertriggertype3 = "Trigger type,xpath, //*[@id='triggerType_web3_listbox']/li";
	public static final String audience_dynamic_entertriggertype4 = "Trigger type,xpath, //*[@id='triggerType_web4_listbox']/li";
	public static final String audience_dynamic_matchtypeanycondition = "Match type any,xpath, //input[@name='radio1'][@class='radio campaignTriggAny']";
	public static final String audience_dynamic_matchtypeallcondition = "Match type all,xpath, //*[@class='radio campaignTriggAll'][@name='radio1']";
	public static final String audience_dynamic_editeddynamiclistname = "Edited DL Name,xpath, ";
	// + ""
	// *[@id='dynamicListNameIdBlurEdit']";
	public static final String audience_dynamic_editedtriggerType = "Trigger Type,xpath, //*[@aria-label='Trigger source']//span/span";
	public static final String audience_dynamic_editedtriggervalue = "Trigger Value,xpath, (//div[.='Trigger source']/..//div[@class='col-sm-8']//span)[4]";
	public static final String audience_dynamic_editedcancel = "DL Edit Cancel,xpath, //*[@class='btn-holder actionBlockCreate']/input[@value='Cancel']";

	// Naveen
	public static final String audience_dynamic_editedupdate = "DL Edit update,xpath,//button[.='Update rule']";
	public static final String dynamic_creation_newrule_typeclick = "new rule type click,xpath,(//i[contains(@class,'icon-rs-circle-plus')])[1]";
	public static final String dynamic_creation_ruletype3_click = "rule type click,xpath, (//span[@aria-label='Rule type'])[3]";
	public static final String dynamic_creation_rule3_type_click = "type click,xpath, (//span[@aria-label='Type'])[3]";
	public static final String dynamic_creation_ruletype3_values_click = "rule type values click,xpath, (//label[.='Values']//parent::span)[3]";
	public static final String dynamic_creation_ruletype4_click = "rule type click,xpath, (//span[@aria-label='Rule type'])[4]";
	public static final String dynamic_creation_rule4_type_click = "type click,xpath, (//span[@aria-label='Type'])[4]";
	public static final String dynamic_creation_ruletype4_values_click = "rule type values click,xpath, (//label[.='Values']//parent::span)[4]";
	public static final String dynamic_creation_ruletype5_click = "rule type click,xpath, (//span[@aria-label='Rule type'])[5]";
	public static final String dynamic_creation_rule5_type_click = "type click,xpath, (//span[@aria-label='Type'])[5]";
	public static final String dynamic_creation_ruletype5_values_click = "rule type values click,xpath, (//label[.='Values']//parent::span)[5]";
	public static final String dynamic_creation_ruletype6_click = "rule type click,xpath, (//span[@aria-label='Rule type'])[6]";
	public static final String dynamic_creation_rule6_type_click = "type click,xpath, (//span[@aria-label='Type'])[6]";
	public static final String dynamic_creation_ruletype6_values_click = "rule type values click,xpath, (//label[.='Values']//parent::span)[6]";
	public static final String dynamic_creation_ruletype7_click = "rule type click,xpath, (//span[@aria-label='Rule type'])[7]";
	public static final String dynamic_creation_rule7_type_click = "type click,xpath, (//span[@aria-label='Type'])[7]";
	public static final String dynamic_creation_ruletype7_values_click = "rule type values click,xpath, (//label[.='Values']//parent::span)[7]";
	public static final String dynamic_creation_ruletype8_click = "rule type click,xpath, (//span[@aria-label='Rule type'])[8]";
	public static final String dynamic_creation_rule8_type_click = "type click,xpath, (//span[@aria-label='Type'])[8]";
	public static final String dynamic_creation_ruletype8_values_click = "rule type values click,xpath, (//label[.='Values']//parent::span)[8]";
	// Naveen
	public static final String audience_dynamic_group2selecttrigger = "Group2 Trigger source,xpath,(//span[@aria-label='Trigger source'])[2]";
	public static final String audience_dynamic_group2selecttriggertype = "Group2 Trigger Type,xpath,(//span[@class='k-input-inner'])[6]";
	public static final String dynamic_creation_group2ruletype_click = "Group2 Rule Type,xpath,(//span[@aria-label='Rule type'])[2]";
	public static final String dynamic_creation_group2rule_type_click = "Group2 Rule Type,xpath,( //span[@aria-label='Type'])[2]";
	public static final String dynamic_creation_group2ruletype_values_click = "Group2 Rule value,xpath,(//label[.='Values']//parent::span)[2]";
	public static final String dynamic_creation_in_exclusion_pluse = "Inclusion Exclusion pluse,xpath,//i[@id='rs_data_circle_plus_fill_edge']";
	public static final String dynamic_creation_inclusion_ = "Inclusion,xpath,//a[.='Inclusion']";
	public static final String dynamic_creation_exclusion_ = " Exclusion,xpath,//a[.='Exclusion']";
	public static final String dynamic_creation_matchtypeAny = "Any,xpath,(//input[@id='0ID2']/..//span[.='Any'])[2]";
	public static final String dynamic_creation_group2matchtypeAny = "Any,xpath,(//input[@id='1ID2']/..//span[.='Any'])[2]";
	public static final String dynamic_creation_group2matchtypeAll = "All,xpath,(//input[@id='1ID1']/..//span[.='All'])[2]";
	public static final String dynamic_creation_matchtypeAnyvalue = "Any value,name,rule.0.MatchCount";
	public static final String dynamic_creation_group2matchtypeAnyvalue = "group2 Any value,name,rule.1.MatchCount";
	public static final String pw_clickSagmentationArrowIcon = "Segmentation Arrow,pw,//h5[text()='PLACE_HOLDER']//ancestor::ul//i[contains(@class,'arrow-right')]";
	public static final String audience_target_moreinfolinkedCommCount = "Created Linked communication and segmentation count,xpath, (//div[@class='fade modal-backdrop show']//..//h5)[1]";

	public static final String audience_dynamic_searchicon = "Search icon,xpath,//i[@class='icon-rs-zoom-medium icon-md white']";
	public static final String audience_dynamic_dropmenu = "Drop menu,xpath,//i[@class='icon-dropmenu-small white icon-xs']";
	public static final String audience_dynamic_listname = "dropdown List name,xpath,//*[@id='searchField_0']";
	public static final String audience_dynamic_enterlistname = "Expand search,xpath,//input[@id='search']";
	public static final String audience_dynamic_afterentervaluesearch = "Textbox value enter after search,xpath,//i[@class='icon-rs-zoom-medium icon-md']";
	public static final String audience_dynamic_listnamedropdown = "List name Dropdown,xpath,//div[@class='box-design']//li";
	public static final String audience_dynamic_linkedcomm = "Linked communication,xpath,//div[@class='toggle-view']//small[@class='margin-R10 pull-right']";
	public static final String audience_dynamic_moreinfo = "Dynamic More-info icon,xpath,//div[@class='toggle-view']//li[@data-original-title='More info']//i";
	public static final String audience_dynamic_moreinfolinkedcomm = "More-info linked communication,xpath,//div[@class='widget-box info-popup serOn']//*[@id='campDetailsId']";
	public static final String audience_dynamic_linkedcommname = "Linked comm name,xpath,//div[@class='col-sm-6 col-xs-12']//ul//li";

	public static final String audience_dynamic_Facebooktriggertype = "Trigger type facebook,xpath,//span[@class='k-input'][contains(.,'-- Type --')]";
	public static final String audience_dynamic_Facebooktriggerdropdown = "facebook trigger dropdown,xpath,//li[@id='triggerType_option_selected'][contains(.,'--')]/../li";
	public static final String audience_dynamic_Facebooktriggertype2 = "Facebook trigger dropdown2,xpath,//div[@id='isMandatory1']//div//span[@class='k-dropdown-wrap k-state-default']//span[contains(.,'--')]/..";
	public static final String audience_dynamic_Facebooktriggerdropdown2 = "Facebook trigger dropdown2,xpath,//ul[@aria-hidden='false']//li";
	public static final String audience_dynamic_twittertriggerdropdown1 = "Twitter triggerdropdown1,xpath,//ul[@aria-hidden='false']//li";
	public static final String audience_dynamic_twittertriggertype1 = "Twitter trigger type1,xpath,//div[@id='isMandatory1']/following-sibling::div//div[@id='trigger-source-change_web2']";
	public static final String audience_dynamic_Weathercheckbox = "Weather checkbox,xpath,//input[@placeholder='Enter Value']";
	public static final String audience_dynamic_abodecheckbox = "Abode trigger checkbox,xpath,//div[@class='selectize-input items not-full has-options']";

	public static final String audience_dynamic_triggercondition = "Trigger condition,xpath,//div[@id='id_div_filter']//span[@class='k-input']";
	public static final String audience_dynamic_selectcondition = "Select Trigger Condition,xpath,//ul[@id='id_ddl_filter_1_listbox']//li";

	// update dynamic list negative scenario
	public static final String audience_dynamic_emptyname_errmsg = "List Name Error Message,xpath,//span[@id='DL_errEmptyName']";
	public static final String audience_dynamic_alreadyexistingname_errmsg = "Existing name error message,xpath,//span[@id='DL_errAlreadyExistName']";
	public static final String audience_dynamic_specialcharacter_errmsg = "Special character error message,xpath,//span[@id='DL_errSpecialCharExistName']";
	public static final String audience_dynamic_allerr = ",xpath,//div[@class='col-sm-5 col-xs-12']//*[@class='input-error']";
	public static final String audience_dynamic_dropdown_alertmsg = "Dropdown Alert Message,xpath,//div[@id='commonValidationAlertMessage']//div[@class='modal-footer']";
	public static final String audience_dynamic_selectelement_errmsg = "Select Element Error Message,xpath,//*[@id='DL_errddlSelect']";
	public static final String audience_dynamic_popup_closeicon = "Popup Close Icon,xpath,//div[@id='commonValidationAlertMessage']//*[@class='close blue icon-close-small modalCloseIcon']";
	public static final String audience_dynamic_triggertype1 = "triggertype1,xpath,//div[@class='col-sm-6 col-xs-12 trigger-source-change hide']//span[@class='k-dropdown-wrap k-state-default']//span[contains(.,'-- Select --')]";
	public static final String audience_dynamic_rfamandatory_errmsg = "RFA Mandatory error message,xpath,//span[@id='DL_errRFAMandatory']";
	public static final String audience_dynamic_domain_resetIcon = "Domain Refresh/reset Icon,xpath,//span[@class='inline-top dynTriggerRefreshIcon']/a/i";
	public static final String audience_dynamic_rfaemail_errmsg = "RFA Email Error Message,xpath,//*[@id='SRA_errUnselect']";
	public static final String audience_dynamic_anycondition_errmsg = "Any Condition Error Message,xpath,//div[@id='commonValidationAlertMessage']//div[@class='modal-footer']";
	public static final String audience_dynamic_lessthanvaluetrigger_errmsg = "Less Than Value Error Message,xpath,//div[@id='MatchCountls6AlertMessage']//*[@class='text-center']";
	public static final String audience_dynamic_lessthanvaluetrigger_closeicon = "Less Than value Popup Close Icon,xpath,//div[@id='MatchCountls6AlertMessage']//*[@class='close blue icon-close-small modalCloseIcon']";
	public static final String audience_dynamic_greaterthanzero_errmsg = "Greater Than Zero Error Message,xpath,//*[@id='MatchCountlsgtZeroAlertMessage']//*[@class='text-center']";
	public static final String audience_dynamic_greaterthanzero_closeicon = "Greater Than Zero Popup Close Icon,xpath,//*[@id='MatchCountlsgtZeroAlertMessage']//*[@class='close blue icon-close-small modalCloseIcon']";
	public static final String audience_dynamic_alertmsg = " Alert Message Popup,xpath,//div[@id='commonValidationAlertMessage']//div[@class='modal-footer']//p";
	public static final String audience_dynamic_alert_closeicon = "Alert Popup Close Icon,xpath,//div[@id='commonValidationAlertMessage']//button[@class='close blue icon-close-small modalCloseIcon']";
	public static final String audience_dynamic_remove_triggerpush = "Remove Trigger Push,xpath,//*[@id='removetriggerPush_web']";

// Mkstr - Segmentation page
	public static final String audience_Segmentation_Edit = "Edit Icon,xpath,//div[@class='table-action-btn']//*[contains(@class,'icon-sd-pencil-edit')]";
	public static final String audience_Segmentation_Info = "Info Icon,xpath,//div[@class='table-action-btn']//*[contains(@class,'icon-sd-circle-info')]";
	public static final String audience_Segmentation_delete = "Delete Button,xpath,//div[@class='table-action-btn']//*[contains(@class,'icon-sd-delete')]";
	public static final String audience_Segmentation_deletePopup = "Delete popup,xpath,//div[@class='modal-content']";
	public static final String audience_Segmentation_delete_Ok = "Ok Button,xpath,//div[@class='modal-footer']//button[text()='OK']";
	public static final String audience_segmentation_delete_cancel = "Cancel,xpath,//div[contains(@class,'d-flex justify-content-end margin')]//button[text()='Cancel']";

	public static final String audience_Segmentation_EditPopup = "Edit list name popup,xpath,//div[@class='modal-header']//h2";
	public static final String audience_Segmentation_Edit_listName = "List name,name,listName";
	public static final String audience_Segmentation_Edit_updateButton = "Update button,xpath,//div[@class='modal-footer']//button";
	public static final String audience_Segmentation_Info_popup = "Info Popup,xpath,//div[@class='modal-header']//h3";
	public static final String audience_Segmentation_Info_comm = "Communications Publisted,xpath,//*[@class='campaign-pop-list']/..//h6";
	public static final String audience_Segmentation_Info_addience = "Audience by channel,xpath,//h6[contains(text(),'Audience by channel')]";
	public static final String audience_Segmentation_Info_dliverability = "Deliverability,xpath,//h6[text()='Deliverability']";
	public static final String audience_Segmentation_Info_Slide = "Slide Button,xpath,//div[@class='carousel-indicators']//button[@aria-label='Slide 2']";
	public static final String audience_Segmentation_Info_attributes = "Attribute list,xpath,//div[@class='active carousel-item']";
	public static final String audience_Segmentation_Info_close = "Close Button,xpath,//div[@class='modal-header']//button";
	public static final String audience_Segmentation_list_count = "Segment list count,xpath,(//tr[@class='k-master-row']//td)[PLACE_HOLDER]";
	public static final String audience_segmentation_info_editlistnametext = "Edit list name text,xpath,//div[@class='modal-header']";
	public static final String audience_Segt_createBy = "Created By Grid,xpath,(//tr[contains(@class,'k-master-row')]//td[3])";
	public static final String audience_Segt_audienceCount = "Audience Count list,xpath,//tr[contains(@class,'k-master-row')]//td[4]";
	public static final String audience_Segtmentation_iicon = "I icon,xpath,//i[@class='icon-info-small icons-md blue cp']";

	public static final String audience_Segmentation_deletebtndisable = ",xpath,//i[@class='icon-delete-small icons-md blue cp disabled']";
	public static final String audience_Segmentation_errormessage = "Error message,xpath,//div[@class='validation-message ']";
	public static final String audience_Segmentation_closeeditlistname = "Cancel edit listname,xpath,//div[@class='modal-header']//button";
	public static final String audience_Segmentation_info_commnametext = "Communication name,xpath,//h3[@class='truncate400']";
	public static final String audience_Segmentation_info_createdontext = "Created on,xpath,(//div[@class='float-end']//span[contains(.,', 202')])[last()]";
	public static final String audience_Segmentation_info_createdbytext = "Created by,xpath,(//div[@class='float-end']//span[contains(.,'QA AUTOMATION')])[last()]";
	public static final String audience_Segmentation_info_totalaudience = "Total audience,xpath,//h6//span";
	public static final String audience_Segmentation_info_linkedcommunication = ",xpath,//h6[contains(.,'Communication')]";
	public static final String audience_Segmentation_info_emailaudience = "Email Audience,xpath,//span[@class='float-start blue'][contains(.,'Email')]/following-sibling::span";
	public static final String audience_Segmentation_info_smsaudience = "Mobile audience,xpath,//span[@class='float-start blue'][contains(.,'Mobile')]/following-sibling::span";

	public static final String audience_uploadpage_removeicon = "Uploaded list remove button,xpath,//i[@class='icon-close-small icon-mini blue cp']";

	// Manimaran

	public static final String audience_segmentation_audiencehead = "Audience head,xpath,//h1[.='Audience']";
	public static final String audience_segmentation_audiencemoduleclractive = "Audience module color,xpath,//a[@class='active']";
	public static final String audience_segmentation_segmenationlistheaders = "List headers,xpath,//span[@class='k-cell-inner']//span[@class='k-column-title']";
	public static final String audience_segmentation_firstadhoclist = "List headers,xpath,//tbody[@data-keyboardnavbody = 'true']//td[contains(.,'AL_')]";
	public static final String audience_serachbox_searchbutton = "Search button state,xpath,//div[@class='search-field-icon']//div[contains(@class,'tooltip-wrapper')]";
	public static final String audience_segmentation_listname = ",xpath,//div[@class='css-scrollbar filterSection']//li[contains(.,'AL_AdhcUp6271752224')]";
	public static final String audience_segmentation_closesearchicon = "Close search,xpath,//div[@class='search-icon']";

	// breadcrumbs

	public static final String audience_breadcrumbs_addaudience = "add audience breadcrumb,xpath,//ul[@class='breadcrumb']//li[.='Audience']";
	public static final String audience_breadcrumbs_dashboard = "Dashboard breadcrumb,xpath,//ul[@class='breadcrumb']//li[.='Dashboard']";
	public static final String audience_breadcrumbs_dashboardhead = "Dashboard header,xpath,//h1[@class='marginB0'][.='Dashboard']";
	public static final String audience_breadcrumbs_waringmsg1 = "Delete warning text1,xpath,//h4[@class='text-center']";
	public static final String audience_breadcrumbs_waringmsg2 = "Delete warning text2,xpath,//p[@class='text-center mt30']";
	public static final String audience_breadcrumbs_segmenationlists = ",xpath,//tr[contains(@class,'k-master-row')]//td[1]";

	public static final String audience_helptextheader = "Help text header,xpath,//div[contains(@class,'modal-header')]//h2";
	public static final String audience_helptextcontet = "Help text content,xpath,//ul[contains(@class,'adhoc-listpermit')]//li//span[not(contains(.,'import failure'))]";
	public static final String audience_browsebutton = "Browse button state,xpath,//button[contains(text(),'Browse')]";
	// + "//div[@class='col-md-6']//div";
	public static final String audience_firstlistname = "First list name,xpath,//tr[contains(@class,'k-master-row')]//td[contains(.,'AL')]//span";
	public static final String audience_firstpagelists = "Uploaded list,xpath,//tbody//tr";
	public static final String audience_calenderdate = ",xpath,//i[contains(@class,'calendar-medium')]/following-sibling::span";
	public static final String audience_invoicedate = "Invoice date,xpath,(//tr[contains(@class,'k-master-row')]//td)[2]";
	public static final String audience_fulldate = ",xpath,//button[contains(@class,'k-button k-flat k-calendar-title')]";
	public static final String audience_customrangestartdate = "custom range start day,xpath,(//td[contains(@class,'start')])[1]";
	public static final String audience_customrangepreviousicon = "previous icon,xpath,//span[contains(@class,'k-calendar-nav k-hstack')]//button[contains(@class,'prev')]";
	public static final String audience_customrangenextarrow = "Next arrow,xpath,//button[@class='k-button k-flat k-button-icon k-nav-next']";
	public static final String audience_segmentationheader = "Segmentation header,xpath,//span[@class='k-cell-inner']";

	// Sync history

	public static final String audience_mdm_synchistory = "audience_mdm_synchistory,xpath, //i[contains(@class,'primary icon-rs-circle-history')]";
	public static final String homepage_audiencelinkclick = "Audience link,xpath,//span[@class='hicon']";
	public static final String audience_synchistory_import = "synchistory_import,xpath, //span[(text()='Import')]";
	public static final String audience_synchistory_importheader = "sync history importheader,xpath, //h3[contains(text(),'Import')]";
	public static final String audience_synchistory_daterange = "daterange,xpath, //div[contains(@class,'daterange-picker date-range-view-containe')]";
	public static final String audience_synchistory_pagination = "pagination,xpath, //div[@class='k-pager k-widget k-grid-pager']";
	public static final String audience_synchistory_importtable = "sync history import,xpath, //div[@class='k-grid-content k-virtual-content']";
	// 03-05-2024

	public static final String dynamic_creation_cancelbtn = "Cancel button,xpath,//button[normalize-space()='Cancel']";
	public static final String dynamic_creation_rulegroup = "1st rule group,xpath,//div[contains(@class,'createDynamicListBox')]";
	public static final String dynamic_creation_listnameMandate = "List name mandate,xpath,//div[@class='border-bottom-required']";
	public static final String dynamic_creation_listnamePlaceholder = "List name placeholder,xpath,//input[@id='dynamicListName']/../..//label[contains(.,'Enter the dynamic list name')]";
	public static final String dynamic_creation_allradiobuttonstate = "All radio button state,xpath,//span[.='All']/ancestor::div[@class='radio-wrapper']//input[@checked]";
	public static final String dynamic_creation_anyradioButton = "Any radio button,xpath,//span[.='Any']/ancestor::div[@class='radio-wrapper']//input";
	public static final String dynamic_creation_entertriggercondition = "Enter trigger condition,xpath,//input[@name='rule.0.MatchCount']";

	public static final String dynamic_creation_Rfa_Addicon = "rfa add icon,xpath,//label[.='Approval request']//..//..//i[contains(@class,'plus')]";
	public static final String dynamic_creation_Rfa_settings = "approval settings,xpath,//i[@class='icon-rs-settings-medium color-primary-blue icon-md ']";
	public static final String dynamic_creation_Rfa_settings_any = "rfa approval setings any,xpath, //input[@name='approvalList.approvalFrom'][@value='Any']";
	public static final String dynamic_creation_Rfa_settings_save = "rfa approval save,xpath, //button[(text()='Save')] ";
	public static final String dynamic_creation_Rfa_settings_cancel = "rfa approval cancel,xpath,(//button[(text()='Cancel')][@type='button'])[2]";
	public static final String dynamic_creation_dynamic_approval2click = "rfa dynamic approver2 click,xpath,// span[@aria-label='Approver 2']";
	// (//span[@aria-label='Select/Enter email address'])[2]";
	public static final String dynamic_creation_dynamic_approval2select = "rf dynamic approver2 select,xpath,//*[@class='k-list-item-text']";
	public static final String dynamic_creation_approvalsettingsdialoguebox = "approval settings dialogue box,xpath, //h2[(text()='Request approval settings')]";
	public static final String dynamic_creation_approvalsettings_radio_any = "approval settings any,xpath, //input[@value='Any'][@name='approvalList.approvalFrom']";
	public static final String dynamic_creation_approvalsettings_radio_all = "approval settings any,xpath, //input[@value='All'][@name='approvalList.approvalFrom']";
	public static final String dynamic_creation_approvalsettings_radio_any_dropdownclick = "approval any dropdown click,xpath,//div[(text()='Get approval from')]/..//div[@class='rs-kendo-dropdownmenu-wrapper     position-relative']";
	public static final String dynamic_creation_approvalsettings_radio_any_dropdownselect = "approval any dropdown selct,xpath, //ul[@class='k-list-ul']/li";
	public static final String dynamic_creation_approvalsettings_followhierarchy_All_turnoff = "approval settings All turn off,xpath, //span[(text()='ON')]";
	public static final String dynamic_creation_approvalsettings_followhierarchy_All_turnon = "approval settings All turn on,xpath, //span[(text()='OFF')]";
	public static final String dynamic_creation_approvalsettings_followhierarchy_inoff = "follow hierarchy in off,xpath,//span[@aria-checked='false']";
	public static final String dynamic_creation_ruletype_click = "rule type click,xpath, //span[@aria-label='Rule type']";
	public static final String dynamic_creation_ruletype_select = "rule type select,xpath, //ul[@role='listbox']/li";
	public static final String dynamic_creation_rule_type_click = "type click,xpath, //span[@aria-label='Type']";
	public static final String dynamic_creation_rule_type_select = "type select,xpath, //ul[@role='listbox']/li";
	public static final String dynamic_creation_ruletype_values_click = "rule type values click,xpath, //label[.='Values']//parent::span";
	public static final String dynamic_creation_ruletype_values_select = "rule type values select,xpath, //ul[@role='listbox']/li";
	public static final String audience_dynamic_editlistoption = "dynamic list edit,xpath,//*[@id='rs_data_pencil_edit']";
	public static final String audience_dynamic_listid = "dynamic list id,xpath, //*[@class='rs-card-bottom-sep rc-tl completed ']//*[@class='rci-list-id']";
	public static final String audience_header = "audience header,xpath,//h1[(text()='Audience')]";
	public static final String audience_dynamic_header = "new dynamic header,xpath, //h1[(text()='New dynamic list')]";

	// dynamic RFA - Jasmine

	public static final String audience_dynamic_rfaapproval_popup = "dynamic rfa appoval popup,xpath,//*[text()='Dynamic list approved successfully']/parent::div/parent::div";

//pw - repo
	// public static final String pw_audiencelinkclick = "Audience link,pw,(//div[contains(@class,'navbar-header')]//span)[1]";
	public static final String pw_audienceDynamicListName = "Audience dynamic list name, pw, #dynamicListName";

	public static final String rejectCommentBox = "Comment Text Box,xpath,//*[@class='bgWhite']";
	public static final String rejectCommentBoxRejectButton = "Comment Text Box,xpath,(//*[text()='Reject'])[2]";

	public static final String rejectBtn = "Reject Button,xpath,//*[text()='Reject']";
	public static final String approveBtn = "Approve Button,xpath,//button[contains(.,'Approve')]";
	public static final String loginpage_proceed = "Proceed Button,xpath,//button[.='Proceed']";
	public static final String loginpage_Otp_Resend = "Resend otp text,xpath,//label[.='Resend?']";
	public static final String loginpage_Otp_textbox = "Otp Textbox,xpath,//input[@name='otp']";

//duplicate

	public static final String dynamic_duplicateicon = "dynamic duplicate,xpath, //a[text()='Duplicate']";
	public static final String dynamic_threedoticon = "dynamic three dot icon,xpath, //i[@id='rs_data_menu_dot']";
	public static final String dynamic_enterduplicatedynamicename = "dynamic enter dplicate name,xpath, //input[@id='dynamicListName']";
	public static final String dynamic_duplicate_save = "dynamic duplicate save,xpath, //i[@id='rs_SingleList_save']";
	public static final String dynamic_communiction_executed = "dynamic communication executed,xpath,(//div[@class='rci-text']/span)[1]";
	public static final String dynamic_listingpage_moreifo = "dynamic listing page more info,xpath, //i[@id='rs_data_circle_info']";
	public static final String dynamic_listingpage_more = "dynamic list communication linked,xpath, //h5[@class='font-medium']";

	public static final String audience_dynamic_clickappname = "app name dropdown,xpath, //span[@aria-label='App name']";
	public static final String audience_dynamic_selectappnamedropdown = "app dropdown select,xpath, //ul[@role='listbox']/li";

	public static final String audience_dynamic_ruletype_dropdownclick = "dynamic rule type dropdown click,xpath, //span[text()='Rule type']/parent::span";
	public static final String audience_dynamic_ruletype_dropdownselect = "dynamic rule type dropdown select,xpath, //ul[@role='listbox']/li";
	public static final String audience_dynamic_ruletype_typeclick = "dynamic rule type dropdown click,xpath, //div[contains(@class,'Dynamiclist-ruletype    position-relative')]";
	public static final String audience_dynamic_ruletype_type = "dynamic rule type dropdown click,xpath,//span[@aria-label='Type']";
	public static final String audience_dynamic_ruletype_typeselect = "dynamic rule type dropdown select,xpath, //ul[@role='listbox']/li";
	public static final String audience_dynamic_ruletype_valueclick = "dynamic rule type dropdown value click,xpath, //label[text()='Values']/parent::span";
	public static final String audience_dynamic_ruletype_value = "dynamic rule type dropdown value click,xpath,//input[@id='rs_RenderField_vlueattribute']";
	public static final String audience_dynamic_ruletype_valueselect = "dynamic rule type value select,xpath, //label[text()='Values']";
	public static final String audience_dynamic_ruletype_formclick = "dynamic rule type dropdown click,xpath,//span[@aria-label='Forms name']";
	public static final String audience_dynamic_ruletype_formvalueclick = "dynamic rule type dropdown value click,xpath,//span[@aria-label='Forms status']";

	// (//span[@class='k-input-inner'])[2]

	/**
	 * Please write the Playwright locators below
	 */
	public static final String pw_audience_seg_attributeNameField = "Attribute Name field,pw,//div[@class='border-bottom-required']//..//input[@id='uIPrintableName']";
	public static final String pw_audience_seg_description = "Description Name,pw,//*[@id='description']";
	public static final String pw_audience_seg_datatype = "Data Type,pw,//span[contains(@aria-label,'ata type')][contains(@class,'required')]//span[@class='k-input-value-text']";
	public static final String pw_audience_seg_inputtype = "Input Type,pw,//span[contains(@aria-label,'nput type')][contains(@class,'required')]//span[@class='k-input-value-text']";
	public static final String pw_audience_seg_dropdownValue = "Dropdown values,pw,//div[@class='k-list-content']//span//span";
	public static final String pw_audience_seg_filtergroup = "Filter group,pw,//span[contains(@aria-label,'ilter group')][contains(@class,'required')]//span[@class='k-input-value-text']";
	public static final String pw_audience_seg_classification = "Classification,pw,//div[@role='listbox']//input";
	public static final String pw_audience_seg_fallbackName = "Fallback Name,pw,//div[@class='border-bottom-required']//..//input[@name='fallbackAttributeName']";
	public static final String pw_audience_seg_newAttributeSave = "New Attribute Save,pw,//h2[.='New attribute']//..//..//button[.='Save']";

	public static final String pw_audiencelinkclick = "Audience link,pw,(//div[contains(@class,'navbar-header')]//span)[1]";
	public static final String pw_audience_Masterdatamanagement = "Audience Dashboard ,pw,//a[text()='Master data management']";
	public static final String pw_audience_Targetlist_Tab = "TargetList link ,pw,//ul//span[text()='Target lists']";
	public static final String pw_createtargetlistIcon = "New Target List,pw,#rs_data_circle_plus_fill_edge";
	public static final String pw_targetlistname = "Target List Name,pw,#rs_TargetListCreation_listname";
	public static final String pw_targetlistcreationSearch = "Search,pw,#rs_data_zoom";
	public static final String pw_targetlistsearchIconClose = "Search close,pw,#rs_RSSearchField_close";
	public static final String pw_targetlistsearchattributetextbox = "Attribute search textbox,pw,input[placeholder='Search attributes']";
	public static final String pw_targetListAttributeCondition = "Attribute condition,pw,//h5[text()='PLACE_HOLDER']//ancestor::ul//span[@class='k-input-value-text']";
	public static final String pw_targetListAttributeValueDateIcon = "Date icon,pw,//h5[text()='PLACE_HOLDER']//ancestor::ul//span[@id='rs_data_calendar']";
	public static final String pw_entertargetlistattributevalue = "Attribute value,pw,//h5[text()='PLACE_HOLDER']//ancestor::ul[@class='attributeList']//input[not(@disabled)]";
	public static final String pw_entertargetlistattributehasvalue = "Attribute value,pw,//h5[text()='PLACE_HOLDER']//ancestor::ul[@class='attributeList']//input[@disabled]";
	public static final String pw_selecttargetlistattributevalue = "Attribute values,pw,//h5[text()='PLACE_HOLDER']//ancestor::ul//div[contains(@class,'rs-kendo-multi-dropdown-required')]";
	public static final String pw_selecttargetlistattributevalueaddicon = "attribute dropdown add icon,pw,//div[contains(@class,'k-list-container')]//div[contains(@class,'k-custom-item')]";
	public static final String pw_clickSegmentationArrowIcon = "Segmentation Arrow,pw,//h5[text()='PLACE_HOLDER']//ancestor::ul//i[contains(@class,'arrow-right')]";
	public static final String pw_clickInclusionAndExclusionAddIcon = "Inc Exc Add Icon,pw,i[id='rs_data_circle_plus_fill_edge']";
	public static final String pw_targetlistinclusiongroupdelete = "Inclusion group deleteIcon,pw,//h4[.='Inclusion Group 2']//ancestor::div[contains(@class,'inclusion')]//i[contains(@class,'rs-circle-close-edge')]";
	public static final String pw_targetlistexclusiongroupdelete = "Inclusion group deleteIcon,pw,//h4[.='Exclusion']//ancestor::div[contains(@class,'exclusionLists')]//i[contains(@class,'rs-circle-close-edge')]";
	public static final String pw_inclusionpopup_okbutton = "Inclusion popup Ok button,pw,(//button[text()='OK'])[2]";
	public static final String pw_exclusionpopup_okbutton = "Exclusion popup Ok button,pw,(//button[text()='OK'])[3]";
	public static final String pw_filterattributeremove = "Filter attribute remove,pw,//span[contains(@class,'remove')]";
	public static final String pw_targetListdropdownattributeValue = "attribute value,pw,//h5[text()='PLACE_HOLDER']//ancestor::ul//div[contains(@class,'rs-kendo-multi-dropdown-required')]//span[@class='k-chip-label']";
	public static final String pw_attributeminusicon = "Attribute minus icon,pw,//h5[text()='PLACE_HOLDER']//ancestor::ul//i[@id='rs_SegmentationLists_circle_minus']";
	public static final String pw_targetlistattributedropdowncalenderView = "Calender view,pw,//div[contains(@class,'k-calendar-monthview')]//button[not(contains(@class,'today'))]//span";
	public static final String pw_targetlistattributedropdownyearselect = "Year select,pw,//div[@class='k-calendar-navigation']//li//span[text()='PLACE_HOLDER']";
	public static final String pw_targetlistattributedropdownmonthselect = "Month select,pw,//td[@title='PLACE_HOLDER']";
	public static final String pw_targetlistattributedroddowndayselect = "Day select,pw,xpath=//td[contains(@title,'PLACE_HOLDER')]//span";

}
