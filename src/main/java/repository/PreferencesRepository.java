package repository;

public class PreferencesRepository

{
	public static String dynamicXpathprefernces = "<- dynamicXpath ->";

	// Audience score
	public static final String preferences_audiencescore_previewpopup = "Preview popup,xpath//h2[.='Your audience score looks like this']";
	public static final String preferences_audiencescore_previewokaypopup = "Preview popup okay button,xpath,//button[.='Okay, got it!']";
	public static final String preferences_audiencescore_addpersonaicon = "Add Persona icon,xpath,//i[@id='rs_data_circle_plus_fill_edge']";
	public static final String preferences_audiencescore_addpersonaheader = "Add Persona header,xpath,//h2[.='Define persona']";
	public static final String preferences_audiencescore_searchicon = "Search icon,xpath,//i[@id='rs_data_zoom']";
	public static final String preferences_audiencescore_searchinput = "Search input,xpath,//input[contains(@class,'searchInput active')]";
	public static final String preferences_audiencescore_enableaccordianattributes = "Enable accordian attributes,xpath,//div[@class='accordionBlock']//ul//li[not(contains(@class,'click-off'))]";
	public static final String preferences_audiencescore_addedattributeNames = "//ul[@class='attributeList']//li//h5";
	public static final String preferences_audiencescore_createbutton = "Create button,xpath,//button[.='Create']";
	public static final String preferences_audiencescore_savepersonaPopup = "Save persona popup,xpath,//h2[text()='Persona']";
	public static final String preferences_audiencescore_personaname = "Persona Name,id,personaName";
	public static final String preferences_audiencescore_personasave = "Persona Save,xpath,//h2[text()='Persona']//parent::div//parent::div//button[.='Save']";
	public static final String preferences_audiencescore_personadetails = "Persona Details,xpath,//h4[.='Persona']//ancestor::div[contains(@class,'box-design')]//div[contains(@class,'box-design')]";

	// naveen
	public static final String preferences_UserManagementlink = "User Management,xpath,//a[@href='/preferences/users']";
	public static final String preferences_UserRolelink = "User Role,xpath,//a[@href='/preferences/roles-and-permissions']";
	public static final String preferences_Companieslink = "Companies,xpath,//a[@href='/preferences/company-list']";
	public static final String preferences_alertAndNotificationlink = "User Management,xpath,//a[@href='/preferences/alerts-and-notifications']";
	public static final String preferences_CommunicationSettingslink = "Communication Settings,xpath,//a[@href='/preferences/communication-settings']";
	public static final String preferences_offerManagementlink = "Offer Management,xpath,//a[@href='/preferences/offer-management']";
	public static final String preferences_templateBuilderlink = "Template Builder,xpath,//a[@href='/preferences/template-gallery']";
	public static final String preferences_dataCataloguelink = "Data catalogue,xpath,//a[@href='/preferences/data-catalogue']";
	public static final String preferences_dataexchangelink = "Data Exchange,xpath,//a[@href='/preferences/data-exchange']";
	public static final String preferences_Consumptionlink = "Consumption,xpath,//a[@href='/preferences/consumptions']";
	public static final String preferences_Invoicelink = "Invoise,xpath,//a[@href='/preferences/invoice-list']";
	public static final String preferences_Licenseinfolink = "License info,xpath,//a[@href='/preferences/license-info']";

	// Fronick
	public static final String Preferences_Userroles1 = ",xpath,//tbody[@data-keyboardnavbody=\"true\"]//tr[1]//span";
	public static final String preferences_dataCatalogue_Click = "datacatalogue click,xpath,//i[@class='icon-rs-data-catalogue-xlarge font-xl']";
	// Template Builder - Vijay
	public static final String preferences_Email_templateBuilderLandingPage = "Landing page,pw,//h4[text()='Email']//ancestor::a";
	public static final String preferences_Email_templateBuilderAddicon = "Add icon,pw,#rs_data_circle_plus_fill_edge";
	public static final String preferences_Email_templateBuilderName = "Templete Name,pw,#templateName";
	public static final String preferences_Email_templateBuildercategory = "Category,pw,//span[@aria-label='Template category']//span[@class='k-input-value-text']";
	public static final String preferences_Email_templateBuildercategorylist = "Category list,pw,ul[class='k-list-ul']>li";
	public static final String preferences_Email_templateBuilderSaveButton = "Save button,pw,//input[@id='templateName']//ancestor::div[@class='page-content-holder']//button[text()='Save']";
	public static final String preferences_Email_templateBuilderDragElements = "DragElements,pw,//div[contains(@class,'flex-col items-center')]//span";
	public static final String preferences_Email_templateBuilderDropElements = "DropElements,pw,//div[contains(@class,'w-full relative transition-colors duration-200')]";
	// Template builder - Text Properties
	public static final String preferences_Email_templateBuildertextContent = "Builder Name,pw,//div[@contenteditable='true']";
	public static final String preferences_Email_templateBuildertextContentBold = "Bold font,pw,//button[contains(@title,'old')]";
	public static final String preferences_Email_templateBuildertextContentItalic = "Italic font,pw,//button[contains(@title,'talic')]";
	public static final String preferences_Email_templateBuildertextContentunderline = "Underline font,pw,//button[contains(@title,'nderline')]";
	public static final String preferences_Email_templateBuildertextContentAlignCenter = "Align center,pw,//button[@title='Align center']";
	public static final String preferences_Email_templateBuildertextContentsize = "//select[contains(@class,'bg-transparent appearance')]";
	public static final String preferences_Email_templateBuildertextContentStyle = "//select[contains(@class,'bg-white border')]";
	// Template builder - image properties
	public static final String preferences_Email_templateBuilderImagewidth = "//label[contains(text(),'Width')]//parent::div//input";
	public static final String preferences_Email_templateBuilderImageheight = "Image height,pw,//label[contains(text(),'Height')]//parent::div//input";
	public static final String preferences_Email_templateBuilderImageUrl = "Image url,pw,input[placeholder='Enter image URL']";
	public static final String preferences_Email_templateBuilderImageUrlAdd = "Add Icon,pw,//button[text()='Add']";
	public static final String preferences_Email_templateBuilderImageTextContent = "Text Content,pw,//label[text()='Text content']//parent::div//div[@contenteditable='true']";
	public static final String preferences_Email_templateBuilderImageBackgroundcolor = "Background clor,pw,input[value='#fff000']";
	// TemplateBuilder - Video properties
	public static final String preferences_Email_templateBuilderVideoUrl = "Video url,pw,input[type='url']";
	// TemplateBuilder - Button properties
	public static final String preferences_Email_templateBuilderButtonurltoggle = "Button url toggle,pw,//label[text()='Button icon']//parent::div//input";
	public static final String preferences_Email_templateBuilderButtonImageurl = "Image url,pw,//label[text()='Image URL']//parent::div//input";
	public static final String preferences_Email_templateBuilderButtonImageAddIcon = "Add,pw,//label[text()='Image URL']//parent::div//button[text()='Add']";
	public static final String preferences_Email_templateBuilderButtonWidth = "Widthsize,pw,//input[@placeholder='Enter image URL']/..//button";
	public static final String preferences_Email_templateBuilderButtonWidthPlusIcon = "Plus icon,pw,//label[text()='Width']//parent::div//button[text()='+']";
	public static final String preferences_Email_templateBuilderButtonActionTab = "Action tab,pw,//div[@id='rsp-property-edit-block']//button[text()='Action']";
	public static final String preferences_Email_templateBuilderButtonActionType = "ActionType,pw,//option[text()='Select action type']//parent::select";
	public static final String preferences_Email_templateBuilderButtonUrl = "Enter url,pw,//label[text()='URL']//parent::div//input";
	public static final String preferences_Email_templateBuilderSaveTemplete = "Save templete,pw,//button[@aria-label='Save']";
	public static final String preferences_Email_templateBuildersearchicon = "Search icon,pw,div[class*='rs-search-filter'] i";
	public static final String preferences_Email_templateBuilderentersearchvalue = "Search value,pw,div[class*='rs-search-filter'] input";
	public static final String preferences_Email_templateBuilderTempleteName = "Campaign Name,pw,div[class*='campaign-name'] p";
//	public static final String preferences_Email_templateBuilder = "";
//	public static final String preferences_Email_templateBuilder = "";
//	public static final String preferences_Email_templateBuilder = "";
//	public static final String preferences_Email_templateBuilder = "";
//	public static final String preferences_Email_templateBuilder = "";

	// *************************************************************************************************************************
	public static final String preferences_validation = "Preferences Header,xpath,//h3[.='General']";
	public static final String prefereneces_datacatalogue = "Data-Catalogue,xpath,//span[.='Data catalogue']//parent::a";
	public static final String preferences_datacatalogue_attributesearch = "Search Icon,xpath,//h4[.='Available attributes']//..//div[@class='rs-search-icon']";
	public static final String preferences_datacatalogue_searchinput = "Search input,xpath,//h4[.='Available attributes']//..//input";
	public static final String preferences_datacatalogue_addicon = "Add icon,xpath,//h4[.='Available attributes']//..//i[contains(@class,'icon-rs-circle-plus')]";
	public static final String preferences_datacatalogue_availableattributes = "Available attributes,xpath,//div[@class='tag-list-block box-design']//ul//li";
	public static final String preferences_datacatalogue_updateicon = "Update button,xpath,//button[.='Update']";
	public static final String preferences_datacatalogue_classificationTab = "Classification Tab,xpath,//span[.='Classification']//parent::li[contains(@class,'tabDefault')]";

	// personalization Edit catagory
	public static final String preferences_datcatalogue_personalisationedit = "Personalisation Edit,xpath,//h4[.='Personalisation']//..//i[contains(@class,'edit')]";
	public static final String preferences_datacatalogue_availablecolumn_search = "search icon,xpath,//h4[contains(.,'Available columns')]//..//i[contains(@class,'icon-md icon')]";
	public static final String preferences_datacatalogue_selectedcolumn_search = "Selected attributes,xpath,//h4[contains(.,'Selected columns')]//..//i[contains(@class,'icon-md icon')]";
	public static final String preferences_datacatalogue_availablesearchtext = "Available search text,xpath,//h4[.='Available columns/attributes']//..//input";
	public static final String preferences_datacatalogue_selectedsearchtext = "Selected search text,xpath,//h4[.='Selected columns/attributes']//..//input";
	public static final String preferences_datacatalogue_editcatagory_availableattributes = "Available attributes,xpath,//h4[.='Available columns/attributes']//..//ul//li[@role='option']";
	public static final String preferences_datacatalogue_editcatagory_selectedattributes = "Selected attributes,xpath,//h4[.='Selected columns/attributes']//..//ul//li";
	public static final String preferences_datacatalogue_editcatagory_attributeslefttoright = "Arrow right,xpath,//button[@title='Transfer To']";
	public static final String preferences_datacatalogue_editcatagory_attributesrighttoleft = "Arrow left,xpath,//button[@title='Transfer From']";
	public static final String preferences_datacatalogue_editcatagory_close = "close icon,xpath,//h2[.='Edit category']//..//i";
	public static final String preferences_datacatalogue_editcatagory_save = "Save,xpath,//button[.='Save']";
	public static final String preferences_datacatalogue_editcatagory_proceed = "Proceed,xpath,//button[.='Proceed']";

	// *******************************************************************************
	// Resul Add user
	public static final String preferences_Users_passwordfieldStrength = "Password strength bar,xpath,//div[contains(@class,'password-strength-meter bg')]";
	public static final String preferences_Users_ConfirmPswdStrength = "Confirm Password strength bar,xpath,(//div[contains(@class,'password-strength-meter bg')])[2]";
	// Preferences page
	public static final String preferences_preferencespageheader = "Preferences page header,xpath, //h1[@class='header-title-margin']";

	// My Profile
	// public static final String preferences_myprofile_iconclick = "My Profile
	// icon,xpath,//div[@class='perference-container']//i[contains(@class,'icon-sd-user-list')]/..";
	public static final String preferences_myprofile_pagelogo = "My profile page,xpath,//h1[@class='header-title-margin']";
	public static final String preferences_myprofile_email = "My profile Email,xpath,//input[@name='email']";
	public static final String preferences_myprofile_salutation = "Salutation,xpath,//span[@class='k-widget k-dropdown sc-hKMtZM kHIipA']/span";
	public static final String preferences_myprofile_enterfirstname = "First Name,xpath,//input[@name='first name']";
	public static final String preferences_myprofile_enterlastname = "Last Name,xpath,//input[@name='Last name']";
	public static final String preferences_myprofile_entermobilenumber = "Mobile Number,xpath,//input[@class='form-control '][@type='tel']";
	public static final String preferences_myprofile_enteraddress = "Address,xpath,//input[@name='address']";
	public static final String preferences_myprofile_clickjobfunction = "Job Function,xpath, //span[@class='k-input'][contains(.,'Select job function')]";
	public static final String preferences_myprofile_selectjobfunction = "Job Function list,xpath, ";
	public static final String preferences_Myprofile_Salutation = "Salutation ,xpath, //*[@id='salutationfield2']/option";
	public static final String preferences_Myprofile_Jobfunction_click = "Job function,xpath, //*[@aria-owns='JobFunction_listbox']";
	public static final String preferences_Myprofile_Jobfunction_select = "Job function, xpath, //*[@id='JobFunction_listbox']/li";

	public static final String preferences_Myprofile_zipcode = "zipcode,xpath,//input[@name = 'Zipcode']";
	public static final String preferences_Myprofile_dateformat_click = "Date format,xapth, //*[@id='MyProfile_DateFormatId_listbox']";
	public static final String preferences_Myprofile_dataformat_select = "Date format selection,xpath, //*[@id='MyProfile_DateFormatId_listbox']/li";
	public static final String preferences_Myprofile_save = "Save,xpath, //*[@onclick='SaveMyProfileDetails();']";
	public static final String preferences_Myprofile_cancel = "Cancel button,xpath,//button[contains(.,'ancel')]";

	public static final String preferences_Myprofile_Address = "Address,xpath, //*[@id='txtAddress']";
	public static final String preferences_Myprofile_City = "City,xpath,//*[@id='txtCity']";
	public static final String preferences_myprofile_enterstate = "State/Province,xpath, //input[@name='State']";
	public static final String preferences_myprofile_entercity = "City,xpath, //input[@name='city']";
	public static final String preferences_myprofile_enterzipcode = "Zipcode,xpath, //input[@name='Zipcode']";
	public static final String preferences_Myprofile_country_click = "Country,xpath, //*[@id='MyProfile_CountryId-list']";
	public static final String preferences_Myprofile_countryselect = "Select country,xpath,//div[@class='col-md-7']//span[contains(@class,'required')]";
	public static final String preferences_Myprofile_changemobilenumber = "change mobile number,xpath,//div[@class=' react-tel-input sc-bjUoiL fMQLyS required click-off maskedPhoneNo']";
	public static final String preferences_Myprofile_removepicture = "Remove picture,xpath,//div[contains(@class,'remove-profile')]";

	public static final String preferenes_myprofile_uploadimage = "My profile image,xpath,//input[@name='uploaded_file']";
	public static final String preferenes_myprofile_address = "Address,xpath,//input[@name = 'address']";
	public static final String preferenes_myprofile_city = "Address,xpath,//input[@name = 'city']";
	public static final String preferenes_myprofile_state = "Address,xpath,//input[@name = 'State']";
	public static final String preferenes_myprofile_pincode = "Address,xpath,//input[@name = 'Zipcode']";
	public static final String preferenes_myprofile_savebutton = "Save button,xpath,//button[contains(.,'Save')]";

	// PREFERENCES USERS
	public static final String preferences_ClickUsers = "Click users,xpath,//div[@class='perference-container']//i[contains(@class,'icon-sd-users-large icons-xl')]/..";
	public static final String preferences_Users_gridList = "Grid list,xpath,//div[@class='k-widget k-grid grid-pagenation']//tbody//tr";
	public static final String preferences_Users_gridheader = "Grid header,xpath,//div[@class='k-widget k-grid grid-pagenation']//th";
	public static final String preferences_Users_gridFirstName = "First user name,xpath,//div[@class='k-widget k-grid grid-pagenation']//tr[1]//td[position()=1]//span";
	public static final String preferences_Users_Addbtn = "Click add,xpath, //a[@class='no-hover btn-users switchTab']";

	public static final String preferences_addnewuser_genderPrefix = "Gendered honorific,xpath,//div[@class='col-md-2']//span[@class='k-input']/..";
	public static final String preferences_addnewuser_firstname = "First name,xpath, //input[@name='firstName']";
	public static final String preferences_addnewuser_lastname = "last name,xpath,//input[@name='lastName']";
	public static final String preferences_addnewuser_countryCode = "Country Code,xpath,//div[@class='selected-flag']";
	public static final String preferences_addnewuser_countrycodelist = "Country Code list,xpath,//ul[@class='country-list']//li";
	public static final String preferences_addnewuser_mobileno = "Mobile number,xpath,//input[contains(@class,'form-control')]";
	public static final String preferences_addnewuser_Email = "Email,xpath,//input[@name='email address']";
	public static final String preferences_addnewuser_pswd = "Password,xpath,//input[@placeholder='Password']";
	public static final String preferences_addnewuser_pswdViewIcon = "Password view icon,xpath,//*[contains(@class,'icons-md password-visible-icon cp icon-sd-eye')]";
	public static final String preferences_addnewuser_Jobfunction_click = "Job function header,xpath,//div[@class='col-md-6']//span[@class='k-input']/..";
	public static final String preferences_addnewuser_welcomeMsg = "Welcome Msg,xpath,//*[@placeholder='Enter a message welcoming the user']";
	public static final String preferences_addnewuser_save = "Add user Button,xpath,//button[contains(@class,'rsp-primary-button')]";
	public static final String preferences_addnewuser_dropdown = "Dropdown list,xpath,//div[@class='k-list-scroller']//li";
	public static final String preferences_addnewuser_enforceOTP = "enforce OTP,id,Enforce OTP to login";

	// PREFERENCES DATA EXCHANGE
	public static final String preferences_ClickdataExchange = "Click Exchange,xpath,//div[@class='perference-container']//i[contains(@class,'icon-data-exchange')]/..";
	public static final String preferences_dataExchange_RDS = "Remote data source,xpath,//*[contains(@class,'icon-odbc-medium')]";

	// PREFERENCES COMMUNICATION SETTINGS
	// Manimaran

	public static final String preferences_CommSettings_emailchannel = "Email channel,xpath,//ul[@class='rs-chart-tab vertical-tabs  ']//i[@class='icon-mail-medium icons-lg']";
	public static final String preferences_CommSettings_smtpicon = "SMTP icon,xpath,//ul[@class='rs-chart-tab rs-tab-icon rs-tab-horizontal  ']//i[@class='icon-smtp-xmedium icons-lg']";
	public static final String preferences_CommSettings_sub_unsub = "sub/unsub icon,xpath,//i[contains(@class,'icon-sub-unsub')]";
	public static final String preferences_CommSettings_unsub = "un-sub,xpath,(//ul[@class='rs-chart-tab mini marginB0 float-end  '])//li[2]";
	public static final String preferences_CommSettings_addunsub = "Add unsub,xpath,//i[@class='icon-plus-fill-medium icons-lg blue float-right cursor-pointer icon-shadow']";
	public static final String preferences_CommSettings_updatebtn = "Upadte sub,xpath,//button[contains(.,'Update')]";
	public static final String preferences_CommSettings_emailfooter = "Email footer icon,xpath,//i[contains(@class,'email-footer')]";
	public static final String preferences_CommSettings_smtpconfig = "SMTP configuration,xpath,//div[@class='p0 mt15 container']";
	public static final String preferences_CommSettings_smtpcolumntitle = "SMTP column title,xpath,//span[@class='k-column-title']";
	public static final String preferences_CommSettings_addsmtp = "Add SMTP,xpath,//i[contains(@class,'plus')]";
	public static final String preferences_CommSettings_editsmtp = "SMTP edit,xpath,//i[contains(@class,'pencil-edit-medium')]";
	public static final String preferences_CommSettings_editsmpp = "SMPP edit,xpath,//i[contains(@class,'icon-edit-pencil')]";
	public static final String preferences_CommSettings_validatedsettings = "Validated setings,xpath,//button[contains(.,'settings')]";
	public static final String preferences_CommSettings_validatingerrmessages = "Validation messages,xpath,//div[@class='validation-message ']";
	public static final String preferences_CommSettings_cancelbutton = "Cancel,xpath,//button[contains(.,'Cancel')]";
	public static final String preferences_CommSettings_emailfooterconfig = "Email footer configuration,xpath,//div[@class='p0 mt15 container']";
	public static final String preferences_CommSettings_messagingchannel = "Messaging,xpath,//ul[@class='rs-chart-tab vertical-tabs  ']//i[@class='icon-messaging-xmedium icons-lg']";
	public static final String preferences_CommSettings_smsicon = "SMS icon,xpath,//ul[@class='rs-chart-tab rs-tab-icon rs-tab-horizontal  ']//i[@class='icon-mobile-sms-xmedium icons-lg']";
	public static final String preferences_CommSettings_smppconfig = "SMPP configuration,xpath,//div[@class='p0 mt15 container']";
	public static final String preferences_CommSettings_smppcolumntitles = "SMPP column title,xpath,//span[@class='k-column-title']";
	public static final String preferences_CommSettings_smppiconinfo = "Icon info SMPP,xpath,//i[@class='icon-info-small icons-lg blue mr10 cursor-pointer icon-shadow']";
	public static final String preferences_CommSettings_smppaddicon = "SMPP add icon,xpath,//i[@class='icon-plus-fill-medium icons-lg blue float-right cursor-pointer icon-shadow']";
	public static final String preferences_CommSettings_smppserviceprovider = "service provider,xpath,//span[@class='k-dropdown-wrap']";
	public static final String preferences_CommSettings_smppsave = "Sms setting save,xpath,//div[@class='btn-container d-flex justify-content-end marginT25']//button[.='Save']";
	public static final String preferences_CommSettings_smpperrormessages = "validation messages,xpath,//div[contains(@class,'validation-message')]";
	public static final String preferences_CommSettings_smssenderid = "SMS sender id,xpath,//input[@name = 'senderId']";
	public static final String preferences_CommSettings_smsfriendlyname = "SMS friendly name,xpath,//input[@name = 'smsFriendlyName']";
	public static final String preferences_CommSettings_senderidadd = "Add sender id,xpath,//i[@class='icon-plus-fill-small icons-md blue float-right cursor-pointer ml10 ']";
	public static final String preferences_CommSettings_smppcancelbutton = "Cancel SMPP,xpath,//div[contains(@class,'btn-container d-flex justify-')]//button[.='Cancel']";
	public static final String preferences_CommSettings_smppeditbutton = "SMPP edit,xpath,//i[@class='icon-edit-pencil-small icons-md blue cursor-pointer']";
	public static final String preferences_CommSettings_itemsperpage = "Items per page,xpath,//span[@role='listbox']";
	public static final String preferences_CommSettings_itemsperpage20 = "20 items per page,xpath,//li[@role='option'][contains(.,20)]";
	public static final String preferences_CommSettings_emailfootercount = "Email footers,xpath,//tbody[@data-keyboardnavbody]//tr";
	public static final String preferences_CommSettings_addsub = "Add subscription,xpath,//i[@class='icon-plus-fill-medium icons-lg blue float-right cursor-pointer icon-shadow']";
	public static final String preferences_CommSettings_subheader = "Subscription header,xpath,//h1[.='Subscription']";
	public static final String preferences_CommSettings_subuploadfile = "Subscription upload file,xpath,//input[@name='uploaded_file']";
	public static final String preferences_CommSettings_subtitle = "Title,xpath,//input[@name='title']";
	public static final String preferences_CommSettings_sub_messagebox = "Message box,xpath,//div[@contenteditable]";
	public static final String preferences_CommSettings_sub_commtype = "communication type,xpath,//label[.='Communication type']/../following-sibling::div";
	public static final String preferences_CommSettings_sub_dropdown = "Dropdown values,xpath,//div[@class='k-list-scroller']//li";
	public static final String preferences_CommSettings_sub_producttype = "Product type,xpath,//label[.='Product type']/../following-sibling::div";
	public static final String preferences_CommSettings_sub_channeltype = "Channel type,xpath,//label[.='Channel type']/../following-sibling::div";
	public static final String preferences_CommSettings_sub_checkbox = "Checkbox,xpath,//span[contains(@class,'checkmark')]";
	public static final String preferences_CommSettings_sub_popuplistname = "popup listname,xpath,//h2[.='Subscription']/../..//div[@class='modal-body']//input[@name='listName']";
	public static final String preferences_CommSettings_UnSubscribe = "Un Sub,xpath,//li//span[.='Un-sub']";
	public static final String preferences_CommSettings_sub_popupsavebtn = "popup save,xpath,//h2[.='Subscription']/../following-sibling::div//button";
	public static final String preferences_CommSettings_unsub_configuration = "un-sub,xpath,//div[@class='p0 mt15 clearfix float-start container']//table";
	public static final String preferences_CommSettings_unsub_popuplistname = "popup listname,xpath,//h2[.='Un-subscription list']/../..//div[@class='modal-body']//input[@name='listName']";
	public static final String preferences_CommSettings_unsub_popupsavebtn = "unsub popup save,xpath,//h2[.='Un-subscription list']/../following-sibling::div//button";
//	public static final String preferences_clickCommunicationSettings = "communication settings icon,xpath,//i[@class='icon-sd-communication-settings-large icons-xl']/..";
	public static final String preferences_communicationsettings_clickEmailFooter = "email footer icon,xpath, //a[@onclick='emailfooter()']";
	public static final String preferences_communicationSettings_EmailfooterAddicon = "email footer add icon,xpath, //a[@onclick='AddNewEmailSmtpFooter()']";
	public static final String preferences_communicationSettings_EmailfooterSaveicon = "email footer save icon,xpath, //input[@onclick='savefooterformname()']";
	public static final String preferences_communicationSettings_Emailfootername = "emailFooter name,xpath, //input[@id='txtformnamesave']";
	public static final String preferences_communicationSettings_EmailfooternameSave = "emailFooterName Save,xpath, //input[@id='btnfootersave']";
	public static final String preferences_CommSettings_Emailfooter_Click = "emailFooter, xpath, //i[contains(@class,'icon-email-footer-xmedium icon-xmd hide')]";
	public static final String preferences_CommSettings_EmailfooterItemsperpage = "emailFooter itemsperpage,xpath, (//span[contains(.,'5select')])[3]";
	public static final String preferences_CommSettings_Emailfooter_Select20item = "emailFooter itemsperpage select,xpath, (//li[contains(@title,'20')])[2]";
	public static final String preferences_CommSettings_Emailfootertextediticon = "xpath, (//img[contains(@class,'edit-btn')])[5]";
	public static final String preferences_CommSettings_Emailfootertextediticon2 = "xpath,(//img[contains(@alt,'Edit')])[6]";
	public static final String preferences_CommSettings_EmailfooterEditdrag = "xpath, //*[@class='txtBox ui-draggable']";
	public static final String preferences_CommSettings_EmailfooterEditdrop = "xpath, //*[@id='defaultTemplate1']/tbody/tr[5]/td/div/div[1]";
	public static final String preferences_CommSettings_Emailfooter_Edit = "xpath, //table[@role='grid']//tbody/tr[1]/td[2]/..//*[@title='Edit']";
	public static final String preferences_CommSettings_Unsub_Edit = "xpath, //table[@role='grid']//tbody/tr[1]/td[2]/..//*[@title='Edit']";
	public static final String preferences_CommSettings_EmailfooterPeview = "xpath,//*[@value='Preview']";
	public static final String preferences_CommSettings_EmailfooterPeviewclose = "xpath, //*[@id='content-preview']/div/div/div[1]/button";
	public static final String preferences_CommSettings_Emailfooter_SAVE = "xpath,//*[@id='btnsave']";
	public static final String preferences_CommSettings_Emailfooter = "xpath, //*[@id='btnsave']";
	public static final String preferences_CommSettings_Emailfootername = "xpath,//*[@id='txtformnamesave']";
	public static final String preferences_CommSettings_Emailfooternamesave = "xapth, //*[@name='textfield']";
	public static final String preferences_CommSettings_EmailfooterUnsubdropSelect = "xpath, //*[@id='divFooterUnscubscribe']/div[1]/div/div/div/div[2]/div/span/span/span[1]";
	public static final String preferences_CommSettings_EmailfooterDropselect = "xpath, (//i[@class='icon-dropdown-small'])[3]";
	public static final String preferences_tablefirstcell = "table first cell,xpath, //*[@role='gridcell'][1]";
	public static final String allmenu_pref_communicationsettings = "allmenu_pref_communicationsettings,xpath, //i[@class='icon-communication-settings-xlarge icon-xlg position-relative']";
	public static final String Commsettings_Notifications = "notifications,xpath, //a[@href='/Client/MobileNotifications']";
	public static final String Preferences_CommunicationSettings_Webnot_ADDclick = "webnot add click,xpath, //small[@class='small-block'][contains(.,'Web Notifications')]";
//	public static final String Preferences_CommunicationSettings_Webnot_add = "Webnot add,xpath, //i[contains(@class,'icon-plus-fill-medium icon-md')]";
//	public static final String Preferences_CommunicationSettings_Webnot_domainname = "web not domain name,xpath, //input[@id='txtdomainnameweb1']";
//	public static final String Preferences_CommunicationSettings_Webnot_domainURL = "webnot domain url,xpath, //input[@id='txtdomainurlweb1']";
//	public static final String Preferences_CommunicationSettings_Webnot_SelectDomain = "xpath,(//span[contains(.,'-- Select domain --')])[3]";
//	public static final String Preferences_CommunicationSettings_Webnot_SelectDomainClick = "xpath, //*[@id='selectDomain_listbox']/li";
	public static final String Preferences_CommunicationSettings_Webnot_Logobutton = "webnot logo,xpath, //input[@onchange='readWebNotURLWeb(this)']";
	public static final String Preferences_CommunicationSettings_Webnot_Description = "xpath, //input[contains(@id,'webDescription')]";
	public static final String Preferences_CommunicationSettings_Webnot_Privacy = "xpath, //input[@onblur='onblurPrivacyUrl()']";
	public static final String Preferences_CommunicationSettings_Webnot_DownloadSDK = "xpath, //input[@value='Download SDK']";
	public static final String Preferences_CommunicationSettings_Webnot_DownloadSDKcopyicon = "xpath, //*[@id='DivWebnotificationTracking']/a/i";
	public static final String Preferences_CommunicationSettings_Webnot_DownloadSDKcopySuccessalert = "xpath, //*[@id='success-alert']";
	public static final String Preferences_CommunicationSettings_Webnot_SAVE = "xpath,//input[contains(@onclick,'SaveWebNotificationSettings()')]";
	public static final String Preferences_CommunicationSettings_Webnot_AlrdyexistOK = "xpath, //*[@id='divWebNotification']/div/div/div[2]/input[2]";
	public static final String Preferences_CommunicationSettings_Webnot_AlrdyexistCancel = "xpath,(//input[@value='Cancel'])[11]";
	public static final String Preferences_CommunicationSettings_Webnot_Updatebtn = "xpath,//input[contains(@value,'Update')]";
	public static final String Preferences_CommunicationSettings_Webnot_Edit = "xpath, (//i[contains(@title,'Edit')])[1]";
	public static final String Preferences_CommunicationSettings_Webnot_SelectPushtype = "xpath,//*[@id='selectSPT_listbox']/li[1]";
	public static final String Preferences_CommunicationSettings_Webnot_SelectDomain_Camp = "xpath, //*[@id='selectSPT_listbox']/li";
	public static final String Preferences_CommunicationSettings_Webnot_SelectDomain_CampClickdomain = "xpath, //*[@id='webPushInput_option_selected']";
	public static final String Preferences_CommunicationSettings_Webnot_SelectDomain_CampSelectdomainname = "xpath,//*[@id='webPushInput_listbox']/li";
//	public static final String Preferences_CommunicationSettings_Webnot_FCMSenderID = "webnot FCM senderID,xpath, //input[@id='txtfcmsenderidweb1']";
//	public static final String Preferences_CommunicationSettings_Webnot_FCMServerkey = "webnot FCM Serverkey,xpath, //input[@id='txtfcmsenderkeyweb1']";
//	public static final String Preferences_CommunicationSettings_Webnot_firebaseApikey = "webnot firebase Apikey,xpath, //input[@id='txtApikey']";
//	public static final String Preferences_CommunicationSettings_Webnot_firebase_authdomain = "webnot firebase authdomain,xpath, //input[@id='txtAuthdomain']";
//	public static final String Preferences_CommunicationSettings_Webnot_firebase_DatabaseURL = "webnot firebase DatabaseURL,xpath, //input[@id='txtDatabaseurl']";
//	public static final String Preferences_CommunicationSettings_Webnot_firebase_ProjectID = "web not firebase projectID,xpath, //input[@id='txtProjectId']";
//	public static final String Preferences_CommunicationSettings_Webnot_firebase_Storagebucket = "web not firebase storagebucket,xpath, //input[@id='txtStoragebucket']";
//	public static final String Preferences_CommunicationSettings_Webnot_firebase_MessaginfSenderID = "web not firebase messaging sender ID,xpath, //input[@id='txtMessagingSenderId']";
//	public static final String Preferences_CommunicationSettings_Webnot_firebase_AppID = "web not firebase AppID,xpath, //input[@id='txtAppId']";
//	public static final String Preferences_CommunicationSettings_Webnot_analyticsSavebtn = "webnot analyics save,xpath, //a[@id='btnWebAppSave']";
	public static final String preferences_communicationsettingvalidation = "communicationsetting validation,xpath,//div[@class='header-title d-flex justify-content-between']";
	public static final String preferences_SMTPsettingicon = "SMTP setting icon,xpath,//div[@id='divmaintemp']//li//a[@onclick='AddSmtpThrottle()']";
	public static final String preferences_SMTPsettingAddicon = "SMTP setting add icon,xpath,//a[@id='SMTPAdd']";
	public static final String preferences_Domainsettingvalidation = "SMTP setting validation,xpath,//div[@id='divmaintemp']//h3[.='Domain settings']";
	public static final String preferences_SMTPsettingvalidation = "SMTP setting validation,xpath,//div[@id='divmaintemp']//h3[.='SMTP Domain Setting']";
	public static final String preferences_Domainsettingaddvolume = "addvolume,xpath,//*[@id='btnAdd']";
	public static final String preferences_Domainsettingcancel = "Domainsetting cancel icon,xpath,//input[@name='cancel'][@onclick='CancelsmtpThrottle()']";

	// CName & Domain Mapping
	public static final String preferences_CommSettings_menus = "menu list,xpath,//div[@class='horizontal-tab-wrapper']//li";
	public static final String preferences_CommSettings_SMTP_grid = "SMTP table grid,xpath,//div[contains(@class,'k-grid grid-pagenation')]";
	public static final String preferences_CommSettings_SMTP_edit = "Edit Icon,xpath,//*[@class='camp-icon']//i";
	public static final String preferences_CommSettings_SMTP_addNewDomain = "Add new domain (+),xpath,//div[@class='input-outer-set']";
	public static final String preferences_CommSettings_SMTP_domainName = "Domain Name,xpath,//input[@name='websiteName'][@required]";
	public static final String preferences_CommSettings_SMTP_add = "Domain Name,xpath,//input[@name='websiteName'][@required]";
	public static final String preferences_CommSettings_SMTP_addDoamin = "Add button,xpath,//*[contains(@class,'rsp-default-button rsp-primary-button')][.='Add']";
	public static final String preferences_CommSettings_SMTP_domainValiadtion = "Domain name validation Msg,xpath,//div[contains(@class,'validation-message')]";
	public static final String preferences_CommSettings_SMTP_verifydomainGrid = "Domain grid,xpath,//div[contains(@class,'k-widget k-grid')]";
	public static final String preferences_CommSettings_SMTP_grid_domain = "Domain name,xpath,//div[contains(@class,'k-widget k-grid ')]//td[text()='PLACE_HOLDER']";
	public static final String preferences_CommSettings_SMTP_grid_domainStatus = "Domain Status,xpath,//*[text()='PLACE_HOLDER']/../descendant::td[2]";
	public static final String preferences_CommSettings_SMTP_grid_viewIcon = "Verify domain Eye icon,xpath,//*[text()='PLACE_HOLDER']/../descendant::i[contains(@class,'icon-sd-eye')]";

	// PREFERENCES ACCOUNT SETUP
	public static final String click_AccountSettings = "Account settings,xpath,//div[@class='perference-container']//i[contains(@class,'icon-sd-settings')]/..";
	public static final String preferences_AccountsettingsAddress = "accountsetup address,xpath, //*[@id='Address1']";
	public static final String preferences_AccountsettingsCity = "accountsetup city,xpath, //*[@id='City']";
	public static final String preferences_AccountsettingsWebsite = "accountsetup website,xpath, //*[@id='Website']";
	public static final String preferences_AccountsettingsZIP = "accountsetup zip,xpath, //*[@id='ZipCode']";
	public static final String preferences_AccountsettingsDateFomatclk = "xpath, (//span[@unselectable='on'][contains(.,'DD-MM-YYYY')])[3]";
	public static final String preferences_AccountsettingsDateFomatSelect = "xpath, //*[@id='DateFormatId_listbox']/li";
	public static final String preferences_AccountsettingsTimeFomatclk = "xpath, (//span[contains(@unselectable,'on')])[32]";
	public static final String preferences_AccountsettingsTimeFomatSelect = "xpath, //*[@id='TimeFormatId_listbox']/li";
	public static final String preferences_AccountsettingsSavebtn = "accountsetup save,xpath, //input[@value='Save']";

	// PREFERENCES DATA ATTRIBUTES
	public static final String preferences_dataattribute_selectinput = "Input type,xpath, //span[contains(text(),'-- Select input --')]";
	public static final String preferences_dataattribute_inputtype = "Intput type list,xpath, //*[@id='NDA_InputTypeddlId_listbox']/li";
	public static final String preferences_dataattribute_selectfiltergroup = "Filteration group,xpath,//span[contains(text(),'Assign filteration group')]";
	public static final String preferences_dataattribute_filtergrouptype = "Filteration group list,xpath, //*[@id='NDA_filterGroupddlId_listbox']/li";
	public static final String preferences_dataattribute_classification1 = "Classification1,xpath, //i[@data-val='5']";
	public static final String preferences_dataattribute_classification2 = "Classification2,xpath, //i[@data-val='1']";
	public static final String preferences_dataattribute_classification3 = "Classification3,xpath, //i[@data-val='3']";
	public static final String preferences_dataattribute_fallbackname = "Fallback,xpath, //*[@id='fallbackid']";
	public static final String preferences_dataattribute_createattribute = "CreateAttribute,xpath, //input[@onclick='CreateAttribute();']";
	// public static final String preferences_dataattribute_attributename = "New attribute name,xpath, //input[@id='newAttributeNameId']";

	public static final String preferences_dataattribute_clicktodownloadattributes = "DataAttributes download,xpath,//button[.='Download']";

	public static final String preferences_dataattribute_headername = "Header Name,xpath,//h1[text()]";
	public static final String preferences_formName1 = "Form,xpath,//div[@id='divListGrid']//table/tbody/tr[1]/td[3]";
	public static final String allmenu_pref_dataattributes = "Data attribute,xpath, //a[contains(.,'Data catalogue')]";
//	public static final String preferences_dataattribute_addattribute = "New Attribute create,xpath, //i[@class='icon-plus-fill-medium icon-md']";
	public static final String preferences_dataattribute_selectdata = "Data type,xpath, //span[contains(text(),'-- Select type --')]";
	public static final String preferences_dataattribute_datatype = "Data type list,xpath, //*[@id='NDA_DataTypeddlid_listbox']/li";
	public static final String preferences_dataattribute_attributeview = "Grid icon,xpath, //i[@class='icon-circle-grid-medium icon-md']";
	public static final String preferences_dataattribute_csvdwnld = "CSV download,xpath, //i[@class='icon-csv-medium icon-md blue']";
	public static final String preferences_dataattribute_csvexport = "CSV export download,xpath, //a[contains(.,'Download')]";
	public static final String preferences_dataattribute_attributesearch = "Search icon,xpath, (//i[@class='icon-search-small icon-xs white'])[1]";
	public static final String preferences_dataattribute_entersearch = "Enter search,xpath, //input[@onkeyup='dafilter(this)']";
	public static final String preferences_dataattribute_selectnewattribute = "Attribute list,xpath, //*[@id='ulgrid']/li";
	public static final String preferences_dataattribute_cancelsearchedvalue = "Cancel button,xpath, //*[@id='EditAttribute']/../input[contains(@value,'Cancel')]";
	public static final String preferences_dataattribute_selectwebmaillink = "Webmail link,xpath,//a[contains(.,'Click here to access your download')]";
	public static final String preferences_dataattribute_selectclassification = "data classification,xpath,(//*[@id='newAttributeclassify']/ul)[1]/li/a";
	public static final String preferences_dataattribute_classificationeditsearch = "edit search,xpath, //div[@id='classificationEdit']//a[contains(@data-original-title,'Search')]/i";
	public static final String preferences_dataattribute_clicksearchbar = "searchbar,xpath, //div[@id='classificationEdit']//input[@id='searchName']";
	public static final String preferences_dataattribute_classificationeditavailabletoassignedvalue = "to assigned value,xpath, //div[@class='multiRghtClm DataClassificationEditmultiRghtClm']/..//a[@class='rightArrow']";
	public static final String preferences_dataattribute_classificationeditassignedtoavailablevalue = "to available value,xpath, //div[@class='multiRghtClm DataClassificationEditmultiRghtClm']/..//a[@class='leftArrow']";
	public static final String preferences_dataattribute_assignedlistvalue = "assigned value,xpath, //div[@class='multiRghtClmDataClassificationEditmultiRghtClm']//ul/li";

	/********************************************************************************************/
	// FORMS
	public static final String allmenu_pref_formgenerator = "Form,xpath, //a[contains(.,'Form generator')]";
	public static final String preferences_forms_formsubmission = "From publish,xpath, //i[@title='Publish']";
	public static final String preferences_forms_formsubmissionurl = "Publish URL,xpath,//div[@class='modal-body']//input";
	public static final String preferences_forms_formsubmission_copyButton = "Publish URL,xpath,//div[@class='modal-content']//*[contains(@class,'rsp-primary-button')][text()='Copy']";
	public static final String preferences_forms_enterformname = "Name Filed,xpath, //input[@name='Name']";
	public static final String preferences_forms_enterformmobilenumber = "Mobile number field,xpath, //input[@name='MobileNo']";
	public static final String preferences_forms_enterformemailid = "EmailId field,xpath,//input[@name='EmailID']";
	public static final String preferences_forms_selectformgender = "Gender male,xpath, //input[contains(@value,'Male')]";
	public static final String preferences_forms_selectformgender2 = "Gender female,xpath, //input[contains(@value,'Female')]";
	public static final String preferences_forms_selectformcity = "City,id,City";
	public static final String preferences_forms_cityOptions = "City,xpath, //*[@id='City']//option";
	public static final String preferences_forms_formtermsncondition = "Form terms,id,chkterms";
	public static final String preferences_forms_formsubmit = "Form submit,xpath,//a[@onclick='location.reload();']/../div";
	public static final String preferences_forms_formdownload = "Form download,xpath, //i[@title='Download CSV']";
	public static final String preferences_forms_confirmdownload = "Confirm download,xpath, //input[@onclick='SaveDownloadcsv()']";
	public static final String preferences_forms_formpopup = "confirm popup,xpath, //h2[contains(.,'Select form fields to download as CSV')]";
	public static final String preferences_forms_selectformpopup = "click ok form popup,xpath, //*[@id='confirm-download']/..//input[@onclick='SaveDownloadcsv()']";

	public static final String preferences_qr_formsubmit = "Form submit,xpath,//input[@value='Submit']";

	// Forms

	public static final String preferences_forms_CreateformADD = "Add Form,xpath, //*[@class='icon-plus-fill-medium icon-md blue']";
	public static final String preferences_forms_Resulticks_NativeForm = "Resulticks native form,xpath, //a[@href='/Recipients/AddFormGeneration']";
	public static final String preferences_forms_CreateformSelectlAYOUT = "Select Layout,xpath, //input[@id='chkhead1']/..";
	public static final String preferences_forms_Createformpagemaintable = "Form page maintable,xpath, //table[@id='maintableuse']/tbody/tr//div[contains(@id,'divtxt')]";
	public static final String preferences_forms_CreateformMapping = "Form Mapping,xpath, (//table[@id='maintableuse']/tbody/tr//div[contains(@id,'divtxt')]/../../../td[4])";
	public static final String preferences_forms_CreateformNameMapping = "form Name,xpath, //*[@aria-owns='comboMap0_listbox']";
	public static final String preferences_forms_CreateformNameSelect = "Select Name,xpath, //*[@id='comboMap0_listbox']/li";
	public static final String preferences_forms_CreateformMobileMapping = "Click mobile,xpath, //*[@aria-owns='comboMap1_listbox']";
	public static final String preferences_forms_CreateformMobile_mandatory = "Mobile as Mandatory field,xpath,//*[@id='Htxtmobile']//a[@data-original-title='Set mandatory']";
	public static final String preferences_forms_CreateformEmail_mandatory = "Email as Mandatory field,xpath,//*[@id='Htxtemail']//a[@data-original-title='Set mandatory']";
	public static final String preferences_forms_CreateformMobileSelect = "Select Mobile,xpath, //*[@id='comboMap1_listbox']/li";
	public static final String preferences_forms_CreateformEmailMapping = "Email,xpath, //*[@aria-owns='comboMap2_listbox']";
	public static final String preferences_forms_CreateformEmailSelect = "Email select,xpath, //*[@id='comboMap2_listbox']/li";
	public static final String preferences_forms_CreateformGenderMapping = "Gender,xpath, //*[@aria-owns='radioMap_listbox']";
	public static final String preferences_forms_CreateformGenderSelect = "Gender Select,xpath, //*[@id='radioMap_listbox']/li";
	public static final String preferences_forms_CreateformCityMapping = "City,xpath, //*[@aria-owns='comboMap007_listbox']";
	public static final String preferences_forms_CreateformCitySelect = "City,xpath, //*[@id='comboMap007_listbox']/li";
	public static final String preferences_forms_CreateformCitySettingsClick = "City settings,xpath, //*[@id='combosocialshare0_City']/td[3]/a[2]";
	public static final String preferences_forms_CreateformCitySettingscityenter = "Enter city,xpath, //*[@id='gender-settings']/div/div/div[2]/div/ul/input";
	public static final String preferences_forms_Createform_removeValue = "Close icon for Default dropdown value,xpath, //*[@id='gender-settings']/div/div/div[2]/div/ul/li/a";
	public static final String preferences_forms_CreateformCitySettingsOK = "Settings Ok btn,xpath,//*[@id='gender-settings']//input[@name='ok']";
	public static final String preferences_forms_Createform_Submitbtn = "Submit button,xpath, //*[@id='div_submitbutton']/a";
	public static final String preferences_forms_Createform_Submitbtnedithyperlinkicon = "Edit hyperlink,xpath,//div[@class='k-widget k-window k-window-titleless k-editor-widget'][contains(@style,'display: block')]//a[@title='Insert hyperlink']";
	public static final String preferences_forms_Createform_hyperlinkPopup = "Hyperlink popup,xpath,//div[@class='k-overlay']/..//span[@class='k-window-title']";
	public static final String preferences_forms_Createform_SubmitbtnedithyperlinkInserbtn = "Edit Hyperlink insert button,xpath, //*[@id='kvinoth']";
	public static final String preferences_forms_Createform_SubmitbtnedithyperlinkWeaddress = "Hyperlink web adress,xpath, //*[@id='k-editor-link-url']";
	public static final String preferences_forms_Createform_HyperlinkNewwindowcheck = "Hyperlink new window checkbox,xpath, //input[@type='checkbox'][@id='k-editor-link-target']";
	public static final String preferences_forms_CreateformEmbedandGenerate = "Embed and Generate,xpath, //input[contains(@value,'Embed & Generate form')]";
	public static final String preferences_forms_CreateformName = "Create form name,xpath, //*[@id='txtformnamesave']";
	public static final String preferences_forms_CreateformCancelButton = "Form cancel button, xpath, //*[@id='generateForm']/div/div/div[8]/div/div/input[1]";
	public static final String preferences_forms_CreateformOutSave = "Save form,xpath, //*[@id='formsavebtn']";
	public static final String preferences_forms_Clickformgenerator = "Form generator,xpath, //div[contains(text(),'Form builder')]/..";
	public static final String preferences_forms_CreateformCancelButton1 = "Form cancel button,xpath, //*[@id='generateForm']/div/div/div[8]/div/div/input[1]";
	public static final String preferences_forms_CreateformNamesave = "Save form name,xpath, //*[@id='btnpopupbutton']";
	public static final String preferences_forms_Publishform_publishIcon = "Publish form,xpath, //tr[1]//i[@title='Publish'][1]";
	public static final String preferences_forms_Publishform_header = "Form,xpath,//*[@id='search-form']//div[contains(@style,'center')]";
	public static final String preferences_forms_Publishform_Name = "Publish form name,xpath,//input[@placeholder=' Enter your name']";
	public static final String preferences_forms_Publishform_mobileErr = "Mobile field Error Msg,xpath,//div[@id='errmsmobilenumberTextbox_MobileNo']";
	public static final String preferences_forms_Publishform_emaiErr = "Email field Error Msg,xpath,//div[@id='errmsmobilenumberTextbox_EmailID']";
	public static final String preferences_forms_Publishform_email = "Publish form email,xpath, //input[@placeholder=' email@domain.com']";
	public static final String preferences_forms_Publishform_Mobile = "Publish form mobile,xpath, //input[@placeholder=' Mobile number']";
	public static final String preferences_forms_Publishform_Name2 = "Publish form name 2,xpath, //*[@id='Textbox1_FirstName']/div[1]";
	public static final String preferences_forms_Publishform_Mobile2 = "Publish mobile 2,xpathh,//*[@id='Textbox0_MobileNo']/div[1]";
	public static final String preferences_forms_Publishform_Email2 = "Publish form Email 2,xpath, //*[@id='Textbox2_EmailID']/div[1]";
	public static final String preferences_forms_Publishform_Gender2 = "Publish form Gender,xpath, //*[@id='rselected01_Gender']/div[1]";
	public static final String preferences_forms_Publishform_City2 = "Publish form City 2,xpath, //*[@id='combosocialshare0_City']/div[1]";
	public static final String preferences_forms_Publishform_URLclosebtn = "Publish form URL close button,xpath, (//button[contains(@data-dismiss,'modal')])[6]";
	public static final String preferences_forms_pageheader = "Form generator,xpath,//h1[contains(.,'Form generator   ')]";
	public static final String preferences_forms_progressivesettingbtn = "progressive setting button,xpath,//i[@class = 'icon-settings-small icon-sm blue ']";
	public static final String preferences_forms_progressivesettingpopup = "progressive setting popup,xpath,//h2[contains (text(),'Progressive Settings')]";
	public static final String preferences_forms_visiblefieldtextbox = "No of visible field,xpath,//input[@id = 'txtvisiblefield']";
	public static final String preferences_forms_progressivesettingsavebtn = "progressive setting savebtn,xpath,//input[@class='btn btn-green formgeneration_fields']";

	// Tell a friend form
	public static final String preferences_forms_tellafriend = "Tell A-Friend,xpath,//*[@class='campaign-type']//li//a[.='Tell a friend']";
	public static final String preferences_forms_tellafriendvalidationfield = "Tell-a-friend validation field,xpath,//div[@class='box-md previewhideselection']//h4[.='Email / Mobile']";
	public static final String preferences_forms_salutationsetting = "Salutation Setting,xpath,//ul[@class='list-block pull-right margin-T5']//i[@class='icon-settings-small icon-sm blue']";
	public static final String preferences_forms_salutationtextbox = "Salutation TextBox,xpath,//ul[@id='salutationFieldpop']//input[@type='text']";
	public static final String preferences_forms_salutationsavebutton = "Salutation Save button,xpath,//input[@class='btn btn-green salutation-ok']";
	public static final String preferences_forms_fullnamecheckbox = "Full-name checkbox,xpath,//input[@id='chkfullname']";
	public static final String preferences_forms_salutationuserdropdown = "Salutation dropdown1,xpath,//span[@aria-owns='salutationfield1_listbox']";
	public static final String preferences_forms_salutationuserfrienddropdown = "Salutation dropdown2,xpath,//span[@aria-owns='salutationfield2_listbox']";
	public static final String preferences_forms_salutationuserdropdownlist = "Salutation dropdown1,xpath,//ul[@id='salutationfield1_listbox']/li";
	public static final String preferences_forms_salutationuserfrienddropdownlist = "Salutation dropdown2,xpath,//div[@id='salutationfield2-list']//ul//li";
	public static final String preferences_forms_addfriendsetting = "Add friend setting,xpath,//div[@class='clearfix position-relative']//i[@class='icon-settings-small icon-sm blue']";
	public static final String preferences_forms_addfriendtextbox = "Addfriend textbox,xpath,//input[@id='txtgroupiconcount']";
	public static final String preferences_forms_addfriendsavebutton = "add-friend save button,xpath,//input[@onclick='Settinggroupsave()']";
	public static final String preferences_forms_userfullname = "Full name,xpath,//input[@id='newtxtfirstname0'][@placeholder='Full Name']/../..";
	public static final String preferences_forms_emailfield = "Email field,xpath,//div[@class='clearfix margin-B20 your-details']//input[@id='newtxtEmail0']";
	public static final String preferences_forms_mobilefield = "Mobile field,xpath,//div[@class='clearfix margin-B20 your-details']//input[@id='newtxtMobile0']";
	public static final String preferences_forms_emailcheckbox = "email checkbox,xpath,//input[@id='chkemail']";
	public static final String preferences_forms_mobilecheckbox = "mobile checkbox,xpath,//input[@id='chkmobilenumber']";
	public static final String preferences_forms_savebutton = "Save button,xpath,//input[@id='btnsaveform']";
	public static final String preferences_forms_hyperlink = "Hyperlink,xpath,(//span[contains(.,'Create Link')])[4]";
	public static final String preferences_forms_formname = "Form name,xpath,//*[@id='txtformnamesav']";
	public static final String preferences_forms_formsave = "Tell-a-friend save button,xpath,//div[@id='save-recipients_save']//input[@type='button'][@name='save']";
	public static final String preferences_forms_fullnamemandatory = "Full-name Mandatory,xpath,//div[@id='divfullname']//a";
	public static final String preferences_forms_useremailmandatory = "Email mandatory select,xpath,//input[@id='newtxtEmail0']//..//a";
	public static final String preferences_forms_usermobilemandatory = "Mobile mandatory select,xpath,//input[@id='newtxtMobile0']//..//a";
	public static final String preferences_forms_friendsdetailaddicon = "Frien details add icon,xpath,//img[@id='grpaddicon']";
	public static final String preferences_forms_friendsrowdetails = "Friends row details,xpath,//div[@class='row rp-form-row fiveFields abox']";
	public static final String preferences_forms_publishuserfullname = "user fullname,xpath,//input[@name='Grp_name_1']";
	public static final String preferences_forms_publishuseremail = "user emailid,xpath,//input[@name='Grp_email_1']";
	public static final String preferences_forms_publishusermobile = "user fullname,xpath,//input[@name='Grp_mobile_1']";
	public static final String preferences_forms_publishuserfriendfullname = "user friend fullname,xpath,//input[@name='Grp_name_2']";
	public static final String preferences_forms_publishuserfriendemail = "user friend fullname,xpath,//input[@name='Grp_email_2']";
	public static final String preferences_forms_publishuserfriendmobile = "user friend fullname,xpath,//input[@name='Grp_mobile_2']";
	public static final String preferences_forms_publishpublishformsubmit = "Publish form save,xpath,//input[@value='Submit']";

	public static final String preferences_forms_UpdateformEdit = "Edit form,xpath, //table[@role='grid']//tbody/tr[1]/td[2]/..//*[@title='Edit']";
	public static final String preferences_forms_UpdateformEditColour = "Edit colour,xpath, (//span[contains(@class,'k-selected-color')])[1]";
	public static final String preferences_forms_UpdateformEditColourSelect = "Edit colour select,xpath, //div[contains(@class,'k-hsv-gradient')]";
	public static final String preferences_forms_UpdateformEditColourApply = "Edit colour appy,xpath, //button[@class='k-button apply'][contains(.,'Apply')]";
	public static final String preferences_forms_UpdateformEditDelete = "Form delete,xpath, (//img[@src='/Images/icon-temp-delete.png'])[6]";
	public static final String preferences_forms_UpdateformEditDelete1 = "Form edited delete,xpath, (//img[@src='/Images/icon-temp-delete.png'])[1]";
	public static final String preferences_forms_UpdateformEdiGenderSettings = "Gender settings, xpath, //*[@class='icon-settings-small icon-sm blue previewdropdown']";
	public static final String preferences_forms_UpdateformEdiGenderSettingsOKbtn = "Gender settings ok, xpath, //*[@id='radio-settings']/div/div/div[3]/input";
	public static final String preferences_forms_UpdateformEdiGenderSettingsOption1closebtn = "Gender settings close,xpath, //*[@id='radio-settings']/div/div/div[2]/div/ul/li[1]/a";
	public static final String preferences_forms_UpdateformEdiGenderSettingsEntergender = "Enter gender,xpath, //*[@class='tagsField radioField']/input";
	public static final String preferences_forms_UpdateformEdiGenderSettingsOption2closebtn = "Enter gender option 2,xpath, //*[@id='radio-settings']/div/div/div[2]/div/ul/li/a";
	public static final String preferences_forms_CreateformGenderMapping2 = "Gender Mapping2,xpath, (//span[@unselectable='on'][contains(.,'-- Map to --')])[3]";
	public static final String preferences_forms_CreateformGenderMappingSelect2 = "Gender Mapping2 select, xpath, //*[@id='radioMap_listbox'][contains(.,'Gender')]";
	public static final String preferences_forms_CreateforTextedit = "Edit text,xpath, //*[@id='TextBlock1']/td/div/div[2]/img";
	public static final String preferences_forms_UpdateformEditDelete2 = "form Edi tDelete,xpath, (//img[@src='/Images/icon-temp-delete.png'])[7]";
	public static final String preferences_forms_UpdateformEditDeleteCnfm = "Edit Delete Cnfm, xpath, //input[contains(@name,'Ok')]";
	public static final String preferences_forms_UpdateformUpdatebtn = "form Update btn,xpath, //input[contains(@value,'Update')]";
	public static final String preferences_forms_UpdateformEditDelMousehover = "DelMousehover,xpath, //*[@id='aLiShare']";
	public static final String preferences_forms_UpdateformDuplicate = "form Duplicate, xpath, (//i[contains(@title,'Duplicate')])[1]";
	public static final String preferences_forms_UpdateformDuplicateName = "form DuplicateName,xpath, //*[@id='txtformnamesave']";
	public static final String preferences_forms_UpdateformDuplicateNameSave = "DuplicateName Save, xpath, //*[@id='btnfootersave']";
	public static final String preferences_forms_UpdateformPublishicon = "xpath,  ";
	public static final String preferences_forms_UpdateformPublishCOPY = "Publish copy,xpath,//input[@value='Copy']";
	public static final String preferences_forms_DeleteformDelbtn = "form Delbtn,xpath, (//i[contains(@title,'Delete')])[1]";
	public static final String preferences_forms_DeleteformDeleteOKbtn = "Delet eOKbtn,xpath, (//input[@value='OK'])[2]";
	// Form
	public static final String Preferences_forms_removefield = "Form remove field,xpath, //input[@onclick='deleteControl(this)']";
	public static final String Preferences_forms_update = "Form update,xpath, //input[@value='Update']";
	public static final String Preferences_forms_header = "Form page header,xpath, //*[@class='page-header']/h1";

	// CCONSUMPTION REPORT
	public static final String preferences_consumption_conReport = "Consumption,xpath,//h1[.='Consumptions']";
	public static final String preferences_consumption_conreportyear = "Month,xpath,(//button[@id='dropdown-basic-buttons'])[2]";
	public static final String preferences_consumption_nodataContainer = "No data container,xpath,//div[@class='no-data-container']";
	public static final String preferences_consumption_conreportselectyear = "Select Year,xpath,//div[@class='css-scrollbar overflow-dropdown']//a";
	public static final String preferences_consumption_month = "Month,xpath,//div[contains(@class,'mr20')]//button";
	public static final String preferences_consumption_monthOptions = "Select month,xpath,//div[@class='css-scrollbar overflow-dropdown']//a";
	public static final String consumption_channels = "Consumption channel,xpath,//*[@class='consume-portlet-body']//span";
	public static final String consumption_Emailchannel = "Email Channel Icon,xpath,//span[contains(text(),'Email')]/..//following-sibling::div//i";
	public static final String consumption_SMSchannel = "SMS Channel Icon,xpath,//span[contains(text(),'SMS')]/..//following-sibling::div//i";
	public static final String consumption_channelsCount = "Consumption channel Count,xpath,//*[@class='consume-portlet-body']/..//h2";
	public static final String preferences_consumption_consumptionpage = "Bandwidth,xpath, //h4[contains(.,'Bandwidth')]";
	public static final String preferences_consumption_constatus = "Status,xpath, //i[@class='icon-mail-large icon-lg orange-medium']";
	public static final String preferences_consumption_conreportdownloadcsv = "Download CSV,xpath,//*[contains(@class,'icon-sd-csv-medium')]";
	public static final String preferences_consumption_commNameheader = "Communication Name header,xpath, //th[@data-title='Communication name']";
	public static final String preferences_consumption_grid = "Communication Grid,xpath,//div[@class='k-grid-container']";
	public static final String preferences_consumption_gridHeader = "Headers,xpath,//*[@class='k-grid-header']//th";
	public static final String preferences_consumption_gridRows = "Rows,xpath,//div[@class='k-grid-container']//tr";
	public static final String preferences_consumption_backBtn = "Back button,xpath,//div[contains(@class,'back-text')]";

	// My Profile
	public static final String preferences_myprofile_selectmyprofile = "my profile icon,xpath,//i[@class='icon-sd-user-list-large icons-xl']";
	public static final String preferences_myprofile_selectfirstname = "first name,xpath,//input[@name = 'first name']";
	public static final String preferences_myprofile_changemobilenumber = "change number,xpath,//label[@class = 'rs-link orange-medium']";
	public static final String preferences_myprofile_changenumberheader = "header,xpath,//div[@class = 'modal-header']";
	public static final String preferences_myprofile_editcurrentnumber = "edit number field,xpath,//div[@class='position-relative col']";
	public static final String preferences_myprofile_editnewnumber = "edit new number,xpath, //input[@id='txtnewnumber']";
	public static final String preferences_myprofile_canceleditnumber = "cancel edit number,xpath,//button[contains(.,'Apply')]/preceding-sibling::button";
	public static final String preferences_myprofile_passwordchangeheader = "password header,xpath,//div[@class='modal-header']";
	public static final String preferences_myprofile_changepasswordlink = "change password link,xpath,//label[@class='rs-link orange-medium fs14 mt7']";
	public static final String preferences_myprofile_changecurrentpwd = "current password,xpath,//input[@name='currentpassword']";
	public static final String preferences_myprofile_changenewpwd = "new password,xpath,//input[@name='newpassord']";
	public static final String preferences_myprofile_reenterpassword = "reenter password,xpath,//input[@name='confirmpassword']";
	public static final String preferences_myprofile_otp = "OTP Field,name,otp";
	public static final String preferences_myprofile_otpSucessMsg = "OTP verified Success tick Mark,xpath,//input[@name='otp']/..//i[contains(@class,'green input')]";
	public static final String preferences_myprofile_cancelchangepwd = "Cancel Button,xpath,//div[@class='modal-footer']//button[text()='Cancel']";
	public static final String preferences_myprofile_applychangepwd = "Apply Button,xpath,//div[@class='modal-footer']//button[text()='Apply']";
	public static final String preferences_myprofile_otpSentMsg = "OTP sent successfully Msg,xpath,//div[@class='validation-message  success_msg']";
	public static final String preferences_myprofile_pswdChangeMsg = "Password updated successfully,xpath,//span[@class='green']";

	public static final String preferences_myprofile_zipcode = "zipcode,xpath, //*[@id='txtZipCode']";
	public static final String preferences_myprofile_localizationdetails = "localization details,xpath,//h4[.='Localization details']/..//div";
	public static final String preferences_myprofile_timeformat = "timeformat,xpath, (//span[@aria-activedescendant='MyProfile_TimeFormatId_option_selected']//span/span)[1]";
	public static final String preferences_myprofile_savemyprofile = "save my profile,xpath,//button[contains(.,'Save')]";
	// Alerts & Notifications
	public static final String preferences_clickalertsandnotification = "Alerts & Notification,xpath,//i[@class='icon-sd-alert-large icons-xl']";
	public static final String preferences_alerts_header = "Alerts & Notification header,xpath,//div[@class='header-title d-flex justify-content-between']";
	public static final String preferences_alerts_grid = "Alerts,xpath,//colgroup[@role='presentation']";
	public static final String preferences_alertsandnotification_breadcrumbs = "Alerts and notificaion breadcrumbs,xpath,//ul[@class='breadcrumb']//li[.='Alerts and notifications']";
	public static final String preferences_alertandnotification_paginationSize = "alerts and notification pagination Size,xpath,//span[contains(@class,'k-pager-sizes')]/span";
	public static final String preferences_alertsnotification_selectnotificationlistbar = "notification listbar,xpath,//i[contains(@class,'icon-md white cursor-pointer')]/..//span";
	public static final String preferences_alertsnotification_recentupdatetime = "recent update time,xpath, //div[@id='alertAndNotificationsAutoUpdate']//ul//span[@class='text-muted']";
	public static final String preferences_alertsnotification_statusrow = ",xpath, //*[@id='AlertAndNotificationGrid']//tbody/tr/td[6]";
	public static final String preferences_alertsnotification_moreinfopopupheader = "moreinfo header,xpath, //h2[contains(.,'Notification details')]";
	public static final String preferences_alertsnotification_moreinfopopupvalue = "moreinfo vlue,xpath, //*[@id='pnlAlertAndNotificationDetails']/div/p";
	public static final String preferences_alertsnotification_moreinfopopupclose = "moreinfo popup ok,xpath, //*[@id='modelWinAlertAndNotificationDetails']//input[@value='OK']";
	public static final String preferences_alertsnotification_clicknextpage = "next page,xpath, //*[@id='AlertAndNotificationGrid']/div/a[contains(@title,'Go to the next page')]/span";
	public static final String preferences_alertsnotification_descriptionrow = "Alert table all list element,xpath,//thead[@class='k-grid-header']/..//tbody//tr//td//div//..//span";
	public static final String preferences_alertandnotification_tooglebutton = "Toggle button,xpath,//td[contains(.,'Configuration settings')]/..//span[@dir]";
	public static final String preferences_alertandnotification_nextbutton = ",xpath,//a[@title='Go to the next page']";

	public static final String preferences_alertnotification_NotificationViewAll = "More Notification viewall,xpath,//a[contains(@class,'notification-footer')]//button[.='View all']";
	// public static String dynamicXpathprefernces = "<- dynamicXpath ->";
	public static String dynamicXpathprefernces1 = "<-- dynamicXpath -->";

	// companies
	public static final String preferences_General_companies = "Account settings,xpath,//div[@class='perference-container']//i[contains(@class,'icon-settings')]/..";
	public static final String preferences_General_companies_userdetails = "Users Menu,xpath,//span[text()='Users']/parent::*[contains(@class,'tabDefault')]";
	public static final String preferences_General_user_userslist = "User name list,xpath,//*[@class='grid-style']//li";
	public static final String preferences_General_assignrole_BU_filter = "User BU Filter Dropdown,xpath,//*[@id='ancUserFilter']//i[@class='icon-bar-filter-medium blue icon-sm']";
	public static final String preferences_General_assignrole_BU_dropdown = "User BU List Selection ,xpath,//*[@id='user-settings']//ul[@class='submenu']//li[@class='departmentUsers']";
	public static final String prefernces_General_assignrole_namelist = "User Name,xpath,//div[@id='left_namesplit']//ul/li/a";
	public static final String preferences_General_assignrole_rightarrow = "Right Arrow,xpath,//div[contains(@class,'grid-style-arrow')]";
	public static final String preferences_General_userroledropdown = "User Role dropdown,xpath,//div[@class='sec-list']//*[contains(text(),'Child')]/..//following-sibling::div[@class='input-field-list']";
	public static final String preferences_General_assign_userrole = "User Role drop-down ,xpath,//*[@class='k-list k-reset']//li";
	public static final String preferences_General_userrolesavebtn = "Save button,xpath,//button[text()='Save']";
	public static final String preferences_General_Scrollview = "Scroll Into view,xpath,//div[@id='left_namesplit']//ul/li//a[.='" + dynamicXpathprefernces + "']";
	public static final String preferences_General_assignrolebackbtn = "Back button,xpath,//div[@id='wrapper']//a[@class='space-top no-hover blue']//span[.='Back']";
	public static final String preferences_company_infoicon = "Info Icon,xpath, //*[@id='gridcontainer']//ul/li[contains(.,'Info')]";
	public static final String preferences_company_businessunitplusicon = "Business unit plus icon,xpath,//*[@id='addCustomDepartment']";
	// Add Users
	public static final String preferences_Users = " Users,xpath, //h4[text()='General']/..//li/a[contains(.,'Users')]";
	public static final String preferences_Users_addnewUser = " Add new user (+) button,xpath,//*[contains(@class,'icon-sd-circle-plus-fill-edge')]/..";
	public static final String preferences_Users_EmailIDerrorMsg = "Email ID already exist,xpath,//*[contains(text(),'Email ID already exists')]";
	public static final String preferences_Users_MaxuserPopup = "Max. user warring popup,xpath,//div[@class='modal-content']//h4";
	public static final String preferences_Users_MaxuserPopupOk = "Ok button,xpath,//div[@class='modal-content']//button[text()='OK']";
	public static final String preferences_Users_addnewUserspage = " Add new User header,xpath, //h1[text()='Add a new user']";
	public static final String preferences_Users_Firstnamefield = " User First Name,id,FirstName";
	public static final String preferences_Users_Lastnamefield = " User Last Name,id,LastName";
	public static final String preferences_Users_countryCode = "Country Code,id,CountryCode";
	public static final String preferences_Users_MobileNofield = " User mobile number,id,PhoneNo";
	public static final String preferences_Users_Jobfunction = "Job function ,xpath, //div[@id='pnlJobfunction']";
	public static final String preferences_Users_Jobfunctionlist = "Job function list ,xpath, //ul[@id='drpJob_listbox']/li";
	public static final String preferences_Users_Emailfield = "user Email Id,xpath,//input[@id='Email']";
	public static final String preferences_Users_passwordfield = "Password,xpath,//input[@id='Password']";

	public static final String preferences_Users_adduserButton = " Add user button,id,btnAddUser";
	public static final String preferences_Users_namefilter = "search user name,xpath,//th[@data-title='Name']/a[@class='k-grid-filter']";
	public static final String preferences_Users_namesearchInput = "input field,xpath,//input[@data-bind='value:filters[0].value']";
	public static final String preferences_Users_filterBtn = "Filter button,xpath,//button[@type='submit']";
	public static final String preferences_Users_DetailsRow = "user details row,xpath,//a[normalize-space()='" + dynamicXpathprefernces + "']/ancestor::tr//td";
	public static final String preferences_Users_Assignrole_Status = "Assignrole status check,xpath,//div[contains(@class,'bootstrap-switch-small bootstrap-switch-animate')]";

	// 12-10-22 - datacatalogue

//	public static final String preferences_datacatalogue_filtergroup = "Filter Group,xpath,//div[@id='daFullContainer']//li[@class='col-sm-6 col-xs-12 active']";
//	public static final String preferences_datacatalogue_filtergroupheader = "Filter Group header,xpath,//div[@class='cf-cat-box cf-default-box']//span[@class='cfc-text']";
//	public static final String preferences_datacatalogue_editicon = "Edit icon,xpath,//div[@class='cf-cat-box cf-default-box']//span[.='" + dynamicXpathprefernces + "']/..//a/i[@class='icon-edit-pencil-small icon-xs blue']";
//	public static final String preferences_datacatalogue_rgtselectattribute = "Right select attribute,xpath,(//*[@id='" + dynamicXpathprefernces + "']//div[@class='multiSelect la-multi']//ul//li)[2]";
//	public static final String preferences_datacatalogue_rightarrowicon = "Right Arrow,xpath,//div[@id='" + dynamicXpathprefernces + "']//div[@class='multiSelect la-multi']//ul//a[@class='rightArrow']";
//	public static final String preferences_datacatalogue_savebutton = "Save Button,xpath,//*[@id='" + dynamicXpathprefernces + "']//*[contains(@id,'SaveBtn')]";
//	public static final String preferences_datacatalogue_totalattribute = "Total Attribute,xpath,//div[@class='cf-cat-box cf-default-box']//span[.='" + dynamicXpathprefernces + "']/../..//div//ul//li//span";
//	public static final String preferences_datacatalogue_leftarrowicon = "Left Arrow,xpath,//div[@id='" + dynamicXpathprefernces + "']//div[@class='multiSelect la-multi']//ul//a[@class='leftArrow']";
//	public static final String preferences_datacatalogue_lftselectattribute = "Left selected attribute,xpath,//div[@id='" + dynamicXpathprefernces + "']//div//h4[.='Assigned attributes']/..//ul//li";
//	public static final String preferences_datacatalogue_scrolldown = "Scrolldown,xpath,//div[@class='cf-cat-box cf-default-box']//span[@class='cfc-text'][.='" + dynamicXpathprefernces + "']";
//	public static final String preferences_datacatalogue_scrolllistelement = "Scroll down,xpath,//div[@id='" + dynamicXpathprefernces + "']//div//h4[.='Assigned attributes']/..//ul//li//span[.='" + dynamicXpathprefernces1 + "']";
//	public static final String preferences_datacatalogue_maximizeicon = "Maximize icon,xpath,//span[normalize-space()='" + dynamicXpathprefernces + "']/../following-sibling::a[@id='expandCollapseDA']";
//	public static final String preferences_datacatalogue_overallattributescrolldown = "Overall attribute,xpath,//div[@class='cf-cat-box cf-default-box']//span[.='" + dynamicXpathprefernces + "']/../..//div//ul//li//span[.='" + dynamicXpathprefernces1
//			+ "']";
//	public static final String preferences_datacatalogue_minimizeicon = "Minimize icon,xpath,//div[contains(@class,'ccb-expanded catData_Expand')]//span[normalize-space()='" + dynamicXpathprefernces
//			+ "']/../following-sibling::a[@id='expandCollapseDA']";
	public static final String preferences_datacatalogue_gridview = "Datacatalogue Grid View,xpath,//div[@id='dabcLeftColumn']//a[@data-original-title='Grid view']";
	public static final String preferences_datacatalogue_dedupesetting = "Dedupe setting,xpath,//div[@class='nav-right col-sm-12 no-padding']//i[@data-original-title='Dedupe settings']";
	public static final String preferences_datacatalogue_dedupeprocess = "Dedupe Process,xpath,//a[@class='dedupeProcess']";

	// 14-10-22-frequency cap
	public static final String preferences_setup_communicationsetting = "Communication Setting,xpath,//div[@class='clearfix preferences']//span[.='Communication settings']";
	public static final String preferences_setup_emailicon = "Email icon,xpath,//div[@id='channel_settings']//small[.='Email']//ancestor::li";
	public static final String preferences_setup_frequencycap = "frequency cap,xpath,//div[@id='wrapper']//*[@id='frequencyon']";
	public static final String preferences_setup_communicationaddlist = "Communication add list,xpath,//div[@id='wrapper']//*[@class='communication-addlist']";
	public static final String preferences_setup_rulename = "RUle Name,xpath,//input[@id='txtrulename']";
	public static final String prefernences_setup_audiencegroup = "Audience Group,xpath,//div[@id='wp-spw-container']//span[.='-- Select audience group --']";
	public static final String preferences_setup_audiencegroup_dropdown = "Audience group dropdown,xpath,//ul[@id='communication-audience-type_listbox']//li";
	public static final String preferences_setup_communicationtype = "Communication Type,xpath,//div[@id='wp-spw-container_ptype']//span[.='-- Select type --']";
	public static final String preferences_setup_communicationtype_dropdown = "Communication Type dropdown,xpath,//ul[@id='communication-type_listbox']//li";
	public static final String preferences_setup_selectpriority = "Select Priority,xpath,//div[@id='wp-spw-container_type']//span[.='-- Select Priority --']";
	public static final String preferences_setup_selectpriority_dropdown = "Priority dropdown,xpath,//div[@id='wp-spw-container_type']//span[.='-- Select Priority --']";
	public static final String preferences_setup_frequencylimit = "Frequency limit,xpath,//div[contains(@class,'form-group clear')]//span[.='-- Limit --']";
	public static final String pferences_setup_frequencylimit_dropdown = "Frequency Limit dropdown,xpath,//ul[@id='communication-times_listbox']//li";
	public static final String preferences_setup_timeinterval = "Frequency Time interval,xpath,//div[contains(@class,'form-group clear')]//span[.='-- Time interval --']";
	public static final String preferences_setup_timeinterval_dropdown = "Time interval Dropdown,xpath,//ul[@id='communication-time-period_listbox']//li";
	public static final String preferences_setup_frequencysavebutton = "Frequency save button,xpath,//*[@id='btnsavefreque']";
	public static final String preferences_setup_segmentationlist = "Segmentation list,xpath,//div[@id='multiselectDiv']//div[@class='k-multiselect-wrap k-floatwrap']";
	public static final String preferences_setup_segmentationlist_dropdown = "Segmentation list dropdown,xpath,//ul[@id='SegmentationList_listbox']//li";

	// 17-10-2022-frequency cap negative
	public static final String preferences_frequencycap_rulenameerrmsg = "Rule Name Error Message,xpath,//span[@id='errmsgrulename']";
	public static final String preferences_frequencycap_audiencegrouperrmsg = "Audience Group Error Message,xpath,//span[@id='errmsgaudiencegroup']";
	public static final String Preferences_frequencycap_audiencetypeerrmsg = "Audience Type Error Message,xpath,//span[@id='errmsgtypegroup']";
	public static final String preferences_frequencycap_frequencylimiterrmsg = "Frequency Limit Error Message,xpath,//span[@id='errmsgFrequencylimits']";
	public static final String preferences_frequencycap_frequencytimeintervalerrmsg = "Frequency Time Interval Error Message,xpath,//span[@id='errmsgFrequencytimeinterval']";
	public static final String preferences_frequencycap_segmentationerrmsg = "Select Persona Type,xpath,//span[@id='errmsgsegmentation']";

	// 17-10-2022-roles and permission
	public static final String preferences_rolesandpermission = "Roles And Permission,xpath,//a[contains(@data-original-title,'user roles and permissions')]";
	public static final String preferences_rolesandpermission_adduserpermission = "Add User Permission,xpath,//div[@class='content preferences']//i[@class='icon-plus-fill-medium icon-md']";
	public static final String preferences_rolesandpermission_rolename = "Role Name,xpath,//input[@id='txtUserRole']";
	public static final String preferences_rolesandpermission_modulename = "Module Name,xpath,//div[@id='kGrid']//tr//td[1]";
	public static final String preferences_rolesandpermission_savebtn = "Save Button,xpath,//input[@id='btnSave']";
	public static final String preferences_rolesandpermission_editicon = "Edit Icon,xpath,//td[.='" + dynamicXpathprefernces + "']//..//i[@id='useredit']";
	public static final String preferences_rolesandpermission_deleteicon = "Delete,xpath,//td[.='" + dynamicXpathprefernces + "']//..//i[@id='userdelete']";
	public static final String preferences_rolesandpermission_confirmdelete = "Confirm Delete,xpath,//div[@id='confirm-delete']//input[@class='btn btn-green']";
	public static final String Preferenses_Roles_CreateNewUserAddbt = "CreateNewUserAddbtn,xpath, //i[@class='icon-plus-fill-medium icon-md']";
	public static final String Preferenses_Roles_CreateNewUser_EnterUserRole_Textbox = "EnterUserRole,xpath, //input[contains(@placeholder,'Enter user role')]";
	public static final String Preferenses_Roles_CreateNewUser_Savebtn = "NewUser_Savebtn,xpath, //input[@id='btnSave']";
	public static final String Preferenses_Roles_CreateNewRole_FirstCellCheck = "Table first cell,xpath, //table[@role='grid']//tbody/tr[1]/td[3]";
	public static final String preferences_companies_filtericon = "filter icon,xpath, //*[@class='icon-bar-filter-medium blue icon-sm']";
	public static final String preferences_click_companies = "Add icon,xpath, //*[@data-original-title='Add and view companies under your brand']";
	public static final String preferences_companies_filter_BU = "BU,xpath, //*[@class='submenu']/li";
	public static final String preferences_companies_chooserole = "role choose,xpath, //*[@id='left_namesplit']/div/ul/li";
	public static final String preferences_companies_rightarrow = "right arrow, xpath, //a[@class='rightArrow'] ";
	public static final String preferences_companies_userrole_click = "Userrole click,xpath, (//span[@unselectable='on'][contains(.,'--User Role--')])[1]";
	public static final String preferences_click_RolesandPermissions = "click roles and permissions, xpath, //*[@data-original-title='Assign and customize user roles and permissions']";
	public static final String Preferences_roles_assignrolesOptions = "Roles option,xpath, div[@class='k-animation-container']//ul//li";

	// 19-10-2022-form generator
	public static final String preferences_forms_formgenerator = "Form Generator,xpath,//div[@class='clearfix preferences']//span[.='Form generator']";
	public static final String preferences_forms_formcolouricon = "Form Colour icon,xpath,//div[@class='widget-template']//span[@class='k-selected-color']";
	public static final String preferences_forms_chooseformcolour = "Choose colour,xpath,//table[@class='k-palette k-reset']//td[@aria-label='#ff0000']";
	public static final String preferences_forms_containerformcolour = "Conatainer form colour,xpath,//div[@id='mainTemplateContainer']//div[contains(@class,'temp-holder-wrap clear')]";
	public static final String preferences_forms_containerformcolouredit = "ContainerForm colour after edit,xpath,//div[@id='mainTemplateContainerEdit']//div[contains(@class,'temp-holder-wrap clear')]";
	public static final String preferences_forms_publishformcolour = "Published form colour,xpath,//form[@id='search-form']";
	public static final String preferences_forms_namemandatory = "Name Mandatory,xpath,//*[@id='Htxtname']//a[@onclick='validationrequired(this)']";
	public static final String preferences_forms_mobilemandatory = "Mobile Mandatory,xpath,//div[@id='divmobilefield']//i";
	public static final String preferences_forms_emailmandatory = "Email Mandatory,xpath,//div[@id='divemailfield']//i";
	public static final String preferences_forms_publishsubmitbutton = "Form publish submit button,xpath,//input[@value='Submit']";
	public static final String preferences_forms_nameerrmsg = "Name error message,xpath,//div[@class='input-error']";
	public static final String preferences_forms_emailerrmsg = "Email error message,xpath,//div[@class='input-error']";
	public static final String preferences_forms_mobileerrmsg = "Mobile error message,xpath,//div[@id='errmsmobilenumberTextbox2_EmailID']";
	public static final String preferences_forms_refreshicon = "Subscription refresh button,xpath,//div[@id='divselectlayout']//a[@data-original-title='Refresh']";
	public static final String preferences_forms_embeded_generateform = "Embeded&Generated form button,xpath,//input[@value='Embed & Generate form']";
	public static final String preferences_forms_surveyicon = "Survey icon,xpath,//*[@class='campaign-type']//li//i[@class='icon-survey-large icon-lg blue d-block']";
	public static final String preferences_forms_subscriptionicon = "Subscription icon,xpath,//*[@class='campaign-type']//li//i[@class='icon-subscription-kyc-large icon-lg blue d-block']";
	public static final String preferences_forms_confirmrefresh = "Confirm refresh,xpath,//div[@id='confirm-refresh']//input[@class='btn btn-green confirmDelete']";
	public static final String Preferences_forms_EmbedandGenerate_header = " Form header,xpath,//h2[@id='h2headername']";
	public static final String Preferences_forms_EmbedandGenerate_naviTab = "Navigation tabs,xpath,//li[contains(@class,'col-sm-3 col-xs-3')]";
	public static final String Preferences_forms_EmbedandGenerate_rawHtml = "Html raw code,xpath,//*[@id='txtrawhtml']";
	public static final String Preferences_forms_EmbedandGenerate_copy = "Copy button,xpath,//ul[@class='right-nav']//a[@title='Copy']";
	public static final String Preferences_forms_EmbedandGenerate_copyMsg = "copy info message,xpath,//div[@id='divclip']";
	public static final String Preferences_forms_EmbedandGenerate_download = "Download button,xpath,//ul[@class='right-nav']//a[@title='Download']";
	public static final String Preferences_forms_EmbedandGenerate_downloadOption = "Download button,xpath,//*[@class='dropdown-menu pull-right']//li//a";
	public static final String Preferences_forms_EmbedandGenerate_previewButton = "Preview button,xpath,//input[@id='idpreview']";
	public static final String Preferences_forms_EmbedandGenerate_fieldList = "input field list,xpath,//div[@id='formgenerationdiv']//div[contains(@id,'divtxt')]";
	public static final String preferences_formType = "Type of Form,xpath,//li[contains(@class,'select-campaign active')]";

	// 20-10-2022-Goal and benchmark
	public static final String preferences_goalsandbenchmark = "Goals&Benchmark,xpath,//div[@class='clearfix preferences']//span[.='Goals & benchmark']";
	public static final String preferences_goals_addbenchmark = "Add benchmark,xpath,//div[@class='content preferences']//i[@class='icon-plus-fill-medium icon-md blue']";
	public static final String preferences_goals_communicationtypedropdown = "Communication type dropdown,xpath,//div[@id='CampaignAttribute-list']//ul//li";
	public static final String preferences_goals_benchmarkname = "BenchmarkName,xpath,//input[@id='BenchmarkName']";
	public static final String preferences_goals_description = "Description,xpath,//textarea[@id='BenchMarkDesc']";
	public static final String preferences_goals_savebtn = "Benchmark save button,xpath,//button[@id='rs_RenderBenchmark_save']";
	public static final String preferences_goals_nextbtn = "benchmark Next button,xpath,//button[@id='rs_RenderBenchmark_next']";
	public static final String preferences_goals_benchmarktablename = "Benchmark table name,xpath,//div//td[.='" + dynamicXpathprefernces + "']";
	public static final String preferences_goals_benchmarktableEdit = "Benchmark table edit,xpath,//td[.='" + dynamicXpathprefernces + "']//..//i[@id='rs_data_pencil_edit']";
	public static final String preferences_goals_Updatebtn = "Benchmark save button,id,rs_RenderBenchmark_save";

	public static final String preferences_goals_communicationnamesavebtn = "Communication name save button,xpath,//input[@id='btnSave']";

	// 02-11-2022 - offerManagement
	public static final String preferences_offermanagement = "Offer Management,xpath,//div[@id='wrapper']//span[.='Offer management']";
	public static final String preferences_offer_addicon = "Add icon,xpath,//div[@class='content']//ul//li//a[@data-original-title='Add']";
	public static final String preferences_offer_name = "Offer Name,xpath,//input[@id='offerName']";
	public static final String preferences_offer_type = "Offer Type,xpath,//div[@id='typeID']//span[@class='k-input'][.='-- Select offer type --']";
	public static final String preferences_offer_typedropdown = "Offer type dropdown,xpath,//div[@id='offerTypeId-list']//ul//li";
	public static final String preferences_offer_startdate = "Start Date,xpath//input[@id='startDate']";
	public static final String preferences_offer_enddate = "End Date,xpath//input[@id='expiryDate']";
	public static final String preferences_offer_communicationtype = "Communication type,xpath,//div[contains(@class,'k-multiselect-')]//input[contains(@aria-owns,'countAttributes')]";
	public static final String preferences_offer_communicationtypedropdown = "Communication type dropdown,xpath,//div[@id='countAttributes-list']//ul//li";
	public static final String preferences_offer_producttype = "Product type,xpath,//div[contains(@class,'k-multiselect-')]//input[contains(@aria-owns,'producttype')]";
	public static final String preferences_offer_producttypedropdown = "Product type dropdown,xpath,//div[@id='producttypeId-list']//ul//li";
	public static final String preferences_offer_codetypecommon = "Common offer code type,xpath,//input[@id='staticOffer']";
	public static final String preferences_offer_codetypeunique = "Unique offer code type,xpath,//input[@id='dynamicOffer']";
	public static final String preferences_offer_codevolume = "Offer code volume,xpath,//input[@id='volumeValue']";
	public static final String preferences_offer_code = "Offer Code,xpath,//input[@id='offercodeValue']";
	public static final String preferences_offer_importfiletype = "Import File Type,xpath,//div[@id='sourceContainer']//span[@class='k-input'][.='-- Source --']";
	public static final String preferences_offer_importfiletypedropdown = "Import filetype dropdown,xpath,//div[@id='importModeSelect1-list']//ul//li";
	public static final String preferences_offer_importdescription = "Import Description,xpath,//input[@id='txtImportDescription']";
	public static final String preferences_offer_files = "Files,xpath,//input[@id='files']";
	public static final String preferences_offer_savebutton = "Save Button,xpath,//input[@id='btn-SaveOffer']";
	public static final String preferences_offer_searchicon = "Search icon,xpath,//a[@data-original-title='Search']";
	public static final String preferences_offer_searchtext = "Search box,xpath,//input[@id='searchtext']";
	public static final String preferences_offer_tablename = "Table name,xpath,(//div[@id='updatepanelGrid']//tr//td)[2]";
	public static final String preferences_offer_nodatalog = "No data log,xpath,//h4[@id='noDataNoJobsInProgress']";
	public static final String preferences_offer_codelength = "Code Length,xpath,//input[@id='txtCodeLength']";
	public static final String preferences_offer_codeformat = "Code Format,xpath,//input[@id='chkABC']";
	public static final String preferences_offer_displayformat = "displayformat,xpath,//input[@id='displayTextType']";
	public static final String preferences_offer_previewcode = "preview code,xpath,//div[@id='previewCode']";
	public static final String preferences_offer_downloadcsv = "Download CSV,xpath,//a[@id='downloadCsv']";
	public static final String preferences_offer_generatebutton = "Generate button,xpath,//input[@id='btnCodeGenerate']";
	public static final String preferences_offer_editoffervalidation = "Edit offer validation,xpath,//div[@id='wrapper']//*[.='Edit offer']";
	public static final String preferences_offer_backbutton = "Back button,xpath,//div[@id='wrapper']//span[.='Back']";
	public static final String preferences_offer_duplicatename = "Duplicate name,xpath,(//div[@id='updatepanelGrid']//tr//td)[2]";
	public static final String preferences_offer_confirmdelete = "Confirm Delete,xpath,//input[@onclick='okconfirmOfferDelete();']";

	// Offercode Negative Scenario
	public static final String preferences_offer_nameerrmsg = "Offer Name Error Message,id,errmsgOfferdName";
	public static final String preferences_offer_typeerrmsg = "Offer Type Error Message,id,errmsgValidOfferType";
	public static final String preferences_offer_startdateerrmsg = "Offer Start Date Error Message,id,errmsgStartDate";
	public static final String preferences_offer_expirydateerrmsg = "Offer Expiry Date Error Message,id,errmsgExpiryDate";
	public static final String preferences_offer_commtypeerrmsg = "Offer Communicationtype Error Message,id,errmsgValidCampaignAttribute";
	public static final String preferences_offer_producttypeerrmsg = "Offer Producttype Error Message,id,errmsgValidProductAttribute";
	public static final String preferences_offer_codeerrmsg = "Offer Code Error Message,id,errmsgOfferCodeminlength";
	public static final String preferences_offer_volumeerrmsg = "Offer Volume Error Message,id,errmsgOfferCodeValue";
	public static final String preferences_offer_addoffererrmsg = "Offer Addoffer Error Message,id,errmsgValidOptionChose";
	public static final String preferences_offer_importdescerrmsg = "Offer ImportDesc Error Message,id,errMsgImportDesc";
	public static final String preferences_offer_fileformaterrmsg = "Offer Fileformat Error Message,id,errMsgFileFormat";
	public static final String preferences_offer_minlengtherrmsg = "Offer Min Length Error Message,id,errmsgMinimunLen";
	public static final String preferences_offer_maxlengtherrmsg = "Offer Max Length Error Message,id,errmsgMaximumLen";

	// dataexchange
	public static final String preferences_dataexchange = "Data Exchange,xpath,//div[@class='clearfix preferences']//a[contains(@data-original-title,'systems and data sources')]";
	public static final String preferences_dataexchange_crm = "CRM,xpath,//i[@class='icon-crm-medium icon-md']//..";
	public static final String preferences_dataexchange_crmconnect = "CRM Connect,xpath,//input[@id='btnRDS']";
	public static final String preferences_dataexchange_crmplusicon = "CRM plus icon,xpath,(//div[@id='crm']//i[@class='icon-plus-fill-medium icon-md'])[1]";
	public static final String preferences_dataexchange_crm_friendlynameerrmsg = "CRM Friendlyname error message,xpath,//span[@id='errMsgDynamicCrmFriendlyName']";
	public static final String preferences_dataexchange_crm_friendlynametextbox = "Friendlyname Textbox,xpath,//input[@id='id_txt_dynamicCrmFriendlyName']";
	public static final String preferences_dataexchange_crm_webaddresserrmsg = "CRM Webaddress error message,xpath,//span[@id='errMsgDynamicCrmUrl']";
	public static final String preferences_dataexchange_crm_usernameerrmsg = "CRM username error message,xpath,//span[@id='crmusername']";
	public static final String preferences_dataexchange_crm_userpassworderrmsg = "CRM user password,xpath,//span[@id='errMsgDynamicCrmPassword']";
	public static final String preferences_dataexchange_crm_friendlynamesplerrmsg = "CRM Friendlyname special error message,xpath,//span[@id='errMsgDynamicCrmSpecialCharacter']";

	// dedupe setting
	public static final String preferences_dedupesetting = "Dedupe Setting,xpath,//ul[@class='iconRound']//li//i[@data-original-title='Dedupe settings']";
	public static final String preferences_dedupedropdownsetting = "dedupe dropdown setting,xpath,//ul[@class='iconRound']//li//ul//a[@class='dedupeProcess']";
	public static final String preferences_dedupecancelbutton = "Dedupe cancel button,xpath,//div[@class='modal-dialog modal-lg']//input[@name='cancel']";

	// webhook
	public static final String preferences_extendedsystems = "Extended Systems,xpath,//small[.='Extended systems']/..";
	public static final String preferences_addextendedsystems = "Add Extended Systems,xpath,//div[@id='extended-systems']//a[@onclick='AddExtendedSystems();']";
	public static final String preferences_extendedsystemsvalidation = "Extended system validation,xpath,//h4[.='Extended channel - Webhook']";
	public static final String preferences_webhookname = "WebhookName,xpath,//input[@id='idwebhook']";
	public static final String preferences_webhookurl = "Webhook url,xpath,//input[@id='idUrl']";
	public static final String preferences_webhooksecretkey = "Secret Key,xpath,//input[@id='idSecretkey']";
	public static final String preferences_webhookdescription = "Webhook description,xpath,//textarea[@id='idDescription']";
	public static final String preferences_webhooksaveicon = "Webhook save,id,rs_ConnectFields_save";
	public static final String preferences_dataexchangepagevalidation = "Data exchange page validation,xpath,//h1[.='Data exchange']";
	public static final String preferences_extendedsystemstotalApi = "Total API,xpath,//i[@id='rs_data_pencil_edit']";

	// Double OptIn
	public static final String preferences_CommSettingsUnsuscribe_ListNameSave = "unsuscribelistNameSave,xpath, //input[contains(@id,'btnunsubscripe')]";
	public static final String preferences_CommSettingsUnsuscribe_EditIcon = "xpath, //table[@role='grid']/tbody/tr[1]/td[2]/..//*[@title='Edit']";
	public static final String preferences_CommSettings_Doubleoptin_click = "xpath, //small[contains(.,'Double opt in')]";
	public static final String preferences_CommSettings_Doubleoptin_ADD = "xpath, //i[contains(@class,'icon-plus-fill-medium icon-md')]";
	public static final String preferences_CommSettings_Doubleoptin_Message = "xpath, //textarea[@id='txtDoubleOpt']";
	public static final String preferences_CommSettings_Doubleoptin_EditiconVerificationMail = "xpath, (//i[contains(@class,'icon-edit-form-small icon-sm blue')])[1]";
	public static final String preferences_CommSettings_Doubleoptin_EditVerificationbox = "xpath, //*[@id='verificationMail']/div/div/div[2]/div/table/tbody/tr[2]/td";
	public static final String preferences_CommSettings_Doubleoptin_Edit_Center = "xpath,(//span[contains(.,'Justify Center')])[1]";
	public static final String preferences_CommSettings_Doubleoptin_EditVerificationMail_SAVE = "xpath,//input[@id='btnVerificationMailSave']";
	public static final String preferences_CommSettings_Doubleoptin_EditWelcomeNote = "xpath, (//i[contains(@class,'icon-edit-form-small icon-sm blue')])[2]";
	public static final String preferences_CommSettings_Doubleoptin_EditWelcomeNoteSAVE = "xpath, //input[@id='btnwelcomenoteSave']";
	public static final String preferences_CommSettings_Doubleoptin_Savebtn = "xpath, //input[@id='btngenerate']";
	public static final String CommSettings_Doubleoptin_Edit = "xpath, (//i[contains(@title,'Edit')])[1]";
	public static final String preferences_communicationsettings_doubleoptin = "click doubleoptin,xpath,//*[@id='liactivedoubleoptin']/a";

	// Communication - WhatsApp
	public static final String Preferences_CommSettings_Messaging = "Click Messaging,xpath, //small[@class='small-block'][contains(.,'Messaging')]";
	public static final String preferences_CommSettings_whatsapp = "Whatsapp tab,xpath,//ul[@class='rs-chart-tab rs-tab-icon rs-tab-horizontal  ']//span[contains(.,'WhatsApp')]";
	public static final String Preferences_CommSettings_WhatsappAdd = "WhatsappAdd,xpath, //*[@onclick='AddNewwhatsapp()']";
	public static final String Preferences_CommSettings_Whatsapp_Servicepro = "Servicepro,xpath, //*[@id='wa_block1']/div[1]/span[2]/span/span[1]";
	public static final String Preferences_CommSettings_Whatsapp_ServiceproSelect = "Servicepro Select,xpath, (//li[@title='Gupshup'])[2]";
	public static final String Preferences_CommSettings_Whatsapp_Accesspoint = "Accesspoint,xpath, //*[@id='txtaccesspoint']";
	public static final String Preferences_CommSettings_Whatsapp_AuthKey = "AuthKey,xpath, //*[@id='txtauthokey']";
	public static final String Preferences_CommSettings_Whatsapp_Senderid = "Senderid,xpath, //*[@id='txtsenderid1']";
	public static final String Preferences_CommSettings_Whatsapp_SenderName = "SenderName,xpath, //*[@id='txtsendername1']";
	public static final String Preferences_CommSettings_Whatsapp_OnemoreAdd = "OnemoreAdd,xpath,(//i[contains(@class,'icon-plus-fill-small icon-sm blue')])[1]";
	public static final String Preferences_CommSettings_Whatsapp_Senderid2 = "Senderid2,xpath, //*[@id='txtsenderid2']";
	public static final String Preferences_CommSettings_Whatsapp_Template = "Template,xpath, //*[@id='txttemplate1']";
	public static final String Preferences_CommSettings_Whatsapp_ResponseName = "ResponseName,xpath, //*[@id='txttemplatename1']";
	public static final String Preferences_CommSettings_Whatsapp_SAVE = "SAVE,xpath, //input[@onclick='savewhatsappsetting()']";
	public static final String Preferences_CommSettings_Whatsapp_SAVE1 = "SAVE1,xpath, //*[@id='WhatsappBtnSave']";
	public static final String Preferences_CommSettings_Whatsapp_Delete = "Delete,xpath,//*[@id='gridudoubleoptin']/table/tbody/tr[2]/td[5]/i[2]";
	public static final String Preferences_CommSettings_Whatsapp_DeleteOK = "DeleteOK,xpath, //*[@id='confirm-deletewasetting']/div/div/div[2]/input[2]";
	public static final String Preferences_CommSettings_WhatsappEdit = "WhatsappEdit,xpath,//*[@id='gridudoubleoptin']/table/tbody/tr[5]/td[5]/i[1]";

	// audience score
	public static final String preferences_audiencescore = "Audience score icon,xpath,//*[.='Audience score']";
	public static final String preferences_audiencescorenotipopup = "Notification pop-up,xpath,//input[@value='Okay, got it!']";
	public static final String preferences_audiencescorevalidation = "persona validation,xpath,//h4[@class='blue inline space-top']";
	public static final String preferences_definenewpersona = "Define new persona,xpath,//div[@class='clearfix space-top nav-right']//a[@id='defineTarget']";
	public static final String preferences_definenewpersonavalidation = "Define new persona validation,xpath,//h2[.='Define persona']";
	public static final String preferences_personasearchicon = "Persona search icon,xpath,//div[@class='searchSlide']";
	public static final String preferences_personasearchtextbox = "Search textbox,xpath,//input[@id='searchName']";
	public static final String preferences_personaattribute = "Persona attribute,xpath,//li[@class='pfiltergroup Customer ']//div[@class='filters-container']//a";
	public static final String preferences_personaenterage = "persona enter age,xpath,//input[contains(@id,'fromtxt_Age')]";
	public static final String preferences_personasaveicon = "persona save icon,xpath,//input[@id='DefinePersonaID']";
	public static final String preferences_personaname = "persona name,xpath,//div[@id='target-name']//input[@id='b2btargetname']";
	public static final String preferences_personasave = "persona save,xpath,//div[@id='target-name']//input[@id='PersonacreateID']";
	public static final String preferences_editpersonavalidation = "Edit Persona Validation,xpath,//*[.='Edit Persona']";

	// Communication Settings Mobile
//	public static final String Preferences_CommSettings_mobileApp = "Mobile App,xpath,//div[@id='channel_settings']//small[text()='Mobile']";
//	public static final String Preferences_CommSettings_addMobileApp = "Add (+) Button,xpath,//a[@id='MobileAppAddNew']";
//	public static final String Preferences_CommSettings_Appname_inputBox = "App Name,xpath,//input[@id='appname']";
//	public static final String Preferences_CommSettings_AppSaveBtn = "Save Button,xpath,//input[@id='btnappsave']";
//	public static final String Preferences_CommSettings_AppList = "App names,xpath,//div[@id='apponboardingGrid']//td[2]//h4";
//	public static final String Preferences_CommSettings_DeleteApp_OkBtn = "Ok Button,xpath,//div[@id='confirm-mobilenot-delete']//input[@value='OK']";
//	public static final String Preferences_CommSettings_DeviceSetup = "Device Setup,xpath,//div[@id='holdersetting']//h4";
//	public static final String Preferences_CommSettings_Mobileplatform = "Mobile Platform,xpath,//*[text()='Mobile platform']/..//span[contains(@class,'dropdown k-header')]";
//	public static final String Preferences_CommSettings_MobileplatformList = "Mobile platform,xpath,//div[@id='drpdevice1-list']//li";
//	public static final String Preferences_CommSettings_Mobile_PlayStoreURL = "PlayStore URL,id,txtplaystore1";
//	public static final String Preferences_CommSettings_MobileNotifyProvider = "Notification Provider,id,rdbgoogle1";
//	public static final String Preferences_CommSettings_FCM_senderID = "FCM sender ID,id,txtfcmsenderid1";
//	public static final String Preferences_CommSettings_FCM_serverKey = "FCM sever Key ,id,txtfcmsenderkey1";
//	public static final String Preferences_CommSettings_Mobile_NativeLanguage = "Native Language radio btn,id,rdbnative1";
//	public static final String Preferences_CommSettings_Mobile_HybridLanguage = "Native Language radio btn,id,rdbhybrid1";
//	public static final String Preferences_CommSettings_HybridApp_Dropdown = "Hybrid app language drop-down,id,div_drplanguagehybrid1";
//	public static final String Preferences_CommSettings_HybridApp_DropdownList = "Hybrid app language list,xpath,//ul[@id='drplanguagehybrid1_listbox']//li";

// Marketing Star - Invoices
	public static final String Preferences_billing_invoices = "Invoices,xpath,//div[contains(text(),'Invoices')]/..";
	public static final String Preferences_billing_invoices_options = "Invoices Options ,xpath,//div[@class='tabs-filled-component-del']//li";
	public static final String Preferences_billing_Subinvoices_grid = "Gird,xpath,//div[contains(@class,'k-widget k-grid grid-pagenation')]";
	public static final String Preferences_billing_Subinvoices_header = "Gird header,xpath,//*[@class='k-grid-header']//th";
	public static final String Preferences_billing_Subinvoices_rows = "Gird rows,xpath,//*[contains(@class,'k-master-row')]";
	public static final String Preferences_billing_Subinvoices_paid = "Subscription paid header,xpath,//div[@class='k-widget k-grid grid-pagenation']//tbody//td[5]";
	public static final String Preferences_billing_invoices_viewIcon = "View Icon,xpath,//div[@class='table-action-btn']//i[contains(@class,'icon-sd-eye-medium icons')]";
	public static final String Preferences_billing_invoices_fromAddress = "From Invoice Address,xpath,//div[@class='invoice-address']";
	public static final String Preferences_billing_invoices_ToAddress = "To Invoice Address,xpath,//*[@class='rs-table-sm']";
	public static final String Preferences_billing_invoices_content = "Invoice content,xpath,//*[@class='rs-table-sm']//td[1]";
	public static final String Preferences_billing_invoices_data = "Invoice content,xpath,//*[@class='rs-table-sm']//td[2]";
	public static final String Preferences_billing_invoices_account = "Account info,xpath,//div[@class='horizontal-list']//small";
	public static final String Preferences_billing_invoices_accountNo = "Account Number,xpath,//div[@class='horizontal-list']//h4";
	public static final String Preferences_billing_invoicebill_header = "Header,xpath,//*[contains(@class,'table rs-table')]//th";
	public static final String Preferences_billing_invoicesbill_rows = "Rows,xpath,//*[contains(@class,'table rs-table')]//tbody//tr";
	public static final String Preferences_billing_coninvoices_CommName = "Communication name,xpath,//*[contains(@class,'k-master-row')]//td[1]";
	public static final String Preferences_billing_coninvoices_eyeIcon = "View icon,xpath,//*[text()='PLACE_HOLDER']//following-sibling::td[last()]//*[contains(@class,'icon-sd-eye-medium icons-md')]";

	// Service Catalogue Feature
	public static final String Preferences_billing_serviceCatalogue = "Service Catalogue Feature,xpath,//div[contains(text(),'Service catalogue')]/..";
	public static final String Preferences_billing_servCatgue_paylaterIndicator = "Paylater Indicator ,xpath,//span[@class='indicator']";
	public static final String Preferences_billing_selectFeature = "Select Feature,xpath,//div[contains(@class,'features-content-wrapper')]//h1";
	public static final String Preferences_selectFeature_audiList = "Audience list,xpath,//h4[@class='mt40 posr']";
	public static final String Preferences_selectFeature_audiListVolumeDropdwn = "Volueme dropdown,xpath,(//span[@class='k-dropdown-wrap k-state-disabled'])[1]";
	public static final String Preferences_selectFeature_audiListfreqDropdwn = "Frequency dropdown,xpath,(//span[@class='k-dropdown-wrap k-state-disabled'])[2]";
	public static final String Preferences_selectFeature_audiListDropdwnsymbl = "Audience list symbol,xpath,//div[@class='mt15 mr20']";
	public static final String Preferences_selectFeature_listType = "List Type,xpath,//h4[@class='posr']";
	public static final String Preferences_selectFeature_listType_seglist = "Segment list Checkbox,name,segmentList";
	public static final String Preferences_selectFeature_comDelivType = "Communication Delivery type,xpath,//h4[text()='Communication delivery type']";
	public static final String Preferences_selectFeature_comDelivType_sdc = "Single dimension,id,cdt-checkbox-0";
	public static final String Preferences_selectFeature_comDelivType_mdc = "Multi dimension,id,cdt-checkbox-1";
	public static final String Preferences_selectFeature_channels = "Channels,xpath,//h4[text()='Channels']";
	public static final String Preferences_selectFeature_channels_email = "Email channel,id,channels-checkbox-0";
	public static final String Preferences_selectFeature_channels_sms = "SMS channel,id,channels-checkbox-1";
	public static final String Preferences_selectFeature_channels_whatsApp = "WhatsAPP channel,id,channels-checkbox-2";
	public static final String Preferences_selectFeature_channels_qr = "QR channel,id,channels-checkbox-3";
	public static final String Preferences_selectFeature_addOns = "Add ons,xpath,//h4[text()='Add ons']";
	public static final String Preferences_selectFeature_addOns_forms = "Forms,id,addOns-checkbox-0";
	public static final String Preferences_selectFeature_addOns_template = "Template Builder,id,addOns-checkbox-1";
	public static final String Preferences_selectFeature_costsummry = "Cost Summary for audience,xpath,//h3[contains(text(),'Cost summary for audience')]";
	public static final String Preferences_selectFeature_costsummry_components = "Cost summary Components,xpath,//div[@class='cost-row-component']/child::div[not (@class)]";
	public static final String Preferences_billing_selectFeaturePromocode = "Promo Code,xpath,//input[@placeholder='Enter promo code']";
	public static final String Preferences_billing_selectFeature_Totalamount = "Amount USD,xpath,//h4[text()='Amount (USD)']/..//following-sibling::div//div[contains(@class,'font-bold')]";
	public static final String Preferences_billing_selectFeature_disamount = "Discount Amount,xpath,//div[text()='Discount amount']/..//following-sibling::div";
	public static final String Preferences_billing_selectFeaturePromocodeErrmsg = "Promo Code error Message,xpath,//div[contains(@class,'validation-message')]";
	public static final String Preferences_billing_PromocodeapplyBtn = "Promo Code apply button,xpath,//*[text()='Apply']";
	public static final String Preferences_billing_selectFeature_proceedButton = "Proceed Button,xpath,//button[text()='Proceed']";
	public static final String Preferences_billing_selectFeature_cancelButton = "Cancel Button,xpath,//button[text()='Cancel']";

	// License Info Feature
	public static final String Preferences_billing_licenseInfo = "License Info,xpath,//div[contains(text(),'License info')]/..";
	public static final String Preferences_billing_licenseInfo_alertMsg = "Alert Message,xpath,//div[contains(@class,'status-warning')]";
	public static final String Preferences_billing_licenseInfo_accountInfo = "Account Information,xpath,//div[@class='k-widget k-grid']//th[position()=1]";
	public static final String Preferences_billing_licenseInfo_account = "Account Information,xpath,//*[contains(@class,'k-master-row')]";
	public static final String Preferences_billing_licenseInfo_accountgrid = "Account Information grid,xpath,//*[contains(@class,'k-master-row')]//table";

	// Mkstr- Manimaran
	public static final String allmainmenus_module_header = "Module header,xpath,//h1['class']";
	public static final String allmainmenus_table = "Segmentation table,xpath,//td/../../preceding-sibling::thead[@class='k-grid-header']/preceding-sibling::colgroup";
	public static final String allmainmenus_addaudience_btn = "Add audience,xpath,*//span[contains(@class,'k-icon k-i- icon-sd-circle-plus-fill-edge-medium icons-lg blue')]/..";
	public static final String allmainmenus_dashboard_header = "Dashboard header,xpath,//h1[contains(.,'Dashboard')]";
	public static final String allmainmenus_comm_analytics_header = "Communication analytics header,xpath,//h1[contains(.,'Communication analytics')]";
	public static final String allmainmenus_preference_header = "preferences header,xpath,//h1[contains(.,'Preferences')]";
	public static final String allmainmenus_preference_submodule_header = "preference sub-header,tag,h4";
	public static final String allmainmenus_account_setting_header = "Setting,xpath,//h1[contains(.,'Settings')]";
	public static final String allmainmenus_aboutyourcompany = "About your company,tag,h4";
	public static final String allmainmenus_account_setting_tabs = "Account settings tab,xpath,//li[contains(@class,'tabDefault')]";
	public static final String allmainmenus_cancel_save = "Cancel and save,xpath,//div[contains(@class,'btn-container')]//button";
	public static final String allmainmenus_users_head = "Users head,tag,h1";
	public static final String allmainmenus_userdetails_head = "user details,tag,h4";
	public static final String allmainmenus_user_table = "user table,xpath,//td/../../preceding-sibling::thead[@class='k-grid-header']/preceding-sibling::colgroup";
	public static final String allmainmenus_communicationsetting_header = "communication settings head,xpath,//div[contains(@class,'header-title')]//h1";
	public static final String allmainmenus_smtp_text = "SMTP,tag,h3";
	public static final String allmainmenus_integrated_and_availablesystem = ",xpath,//div[contains(@class,'d-flex justify-content-between')]//h3";
	public static final String allmainmenus_select_feature = "Select feature head,tag,h1";
	public static final String allmainmenus_select_feature_texts = ",xpath,//h4[not(contains(.,'Amount (USD)'))]";
	public static final String allmainmenus_consumptions_head = "Consumptions,tag,h1";
	public static final String allmainmenus_consumptions_status = "Consumptions status,tag,h3";
	public static final String allmainmenus_invoice_list = "Invoice list head,tag,h1";
	public static final String allmainmenus_invoice_sub_text = ",xpath,//li[contains(@class,'tabDefault')]";
	public static final String allmainmenus_licenseinfo = "License info head,tag,h1";

	public static final String preferences_myprofile = "My profile,xpath,//i[@class='icon-sd-user-list-large icons-xl']";
	public static final String preferences_accountsettings = "Account settings,xpath,//i[@class='icon-sd-settings-large icons-xl']";
	public static final String preferences_companyprofile = "Company profile,xpath,//img[@alt='profile']";
	public static final String preferences_copyrightpanel = "Copyright,xpath,//ul[@class='copyright']";
	public static final String preferences_userstab = "Users,xpath,//i[@class='icon-sd-users-large icons-xl']";
	public static final String preferences_alertsandnotification = "Alerts and notification,xpath,//i[@class='icon-sd-alert-large icons-xl']";
	public static final String preferences_alertsandnotificationtable = "Alerts configuration,xpath,//td/../../preceding-sibling::thead[@class='k-grid-header']/preceding-sibling::colgroup";
	public static final String preferences_communicationsetting = "Communication settings,xpath,//i[@class='icon-sd-communication-settings-large icons-xl']";
	public static final String preferences_smtptable = "SMTP configuration,xpath,//td/../../preceding-sibling::thead[@class='k-grid-header']/preceding-sibling::colgroup";
	public static final String preferences_mks_dataexchange = "Data exchange,xpath,//i[@class='icon-sd-data-exchange-large icons-xl']";
	public static final String preferences_servicecatalogue_cancelbtn = "Cancel button,xpath,//button[contains(@class,'-button rsp-secondary-button')]";
	public static final String preferences_consumption = "Consumptions,xpath,//div[@class='consume-portlet-body']";
	public static final String preferences_consumption_emailportlet = "Email portlet,xpath,//div[@class='well consume-portlet-box ']";
	public static final String preferences_consumption_smsportlet = "SMS portlet,xpath,(//div[@class='well consume-portlet-box '])[2]";
	public static final String preferences_consumption_invoicetab = "Invoice,xpath,//i[@class='icon-sd-invoices-large icons-xl']";
	public static final String preferences_consumption_invoicelisttable = "Invoice list table,xpath,//td/../../preceding-sibling::thead[@class='k-grid-header']/preceding-sibling::colgroup";
	public static final String preferences_consumption_licencseinfo = "License info,xpath,//i[@class='icon-sd-license-agreement-large icons-xl']";
	public static final String preferences_consumption_accountinfotable = "Account info,xpath,//td/../../preceding-sibling::thead[@class='k-grid-header']/preceding-sibling::colgroup";

	// Gokul Preferences
	public static final String preferences_CancelButton = "Cancel,xpath,//div[contains(@class,'btn-container')]//button[.='Cancel']";
	public static final String preferences_SaveButton = "Save,xpath,//div[contains(@class,'btn-container d-flex')]//button[.='Save']";
	public static final String preferences_BackButton = "Back Button,xpath,//div[contains(@class,'back-text')]";
	public static final String preferences_OKButton = "Ok Button,xpath,//button[contains(.,'OK')]";
	public static final String preferences_DatePicker = "DatePicker,xpath,//i[@class='icon-calendar-mini icons-md blue']";
	public static final String preferences_ErrorMessage = "Error Message,xpath,//div[contains(@class,'validation-message')]";
	public static final String preferences_GoButton = "Go Button,xpath,//button[contains(.,'Go')]";
	public static final String preferences_CloseButton = "Close Button,xpath,//button[.='Close'or @class='btn-close']";
	public static final String preferences_PreviewButton = "Preview Button,xpath,//button[.='Preview']";
	public static final String preferences_TermsandConditions = "Terms & Conditions,xpath,//li[.='Terms & Conditions']";
	public static final String preferences_TermsandConditionsHeader = "Terms & Conditions,xpath,//h1[.='Terms and Conditions']";
	public static final String preferences_ResetIcon = "Reset Icon,xpath,//i[contains(@class,'icon-restart-small icons')]";

	public static final String preferences_myprofile_ApplyButton = "Apply Button,xpath,//button[.='Apply']";
	public static final String preferenes_myprofile_allTextbox = "My profile inputfields,xpath,(//div[@class='position-relative w-100 '])[position()>=5 and position()<=8]//input";
	public static final String preferences_myprofie_errorMessages = "My profile inputfields errormsgs,xpath,//*[contains(@class,'validation-message')]";
	public static final String preferences_myprofie_cityErrMsg = "My profile inputfields errormsgs,xpath,validation-message ";
	public static final String preferences_myprofile_clickjobfunctions = "Click job function,xpath,(//div[@class='position-relative'])[2]//span[@class='k-input']";
	public static final String preferences_myprofile_selectjobfunctions = "Select job function,xpath,//div//div[.='-- Select job function --']";
	public static final String preferences_myprofile_country_clic = "Country,xpath,(//div[@class='position-relative'])[4]//span[@class='k-input']";
	public static final String preferences_myprofile_countryselects = "Country options,xpath,//div//div[.='-- Select country --']";
	public static final String preferences_myprofile_savebtn = "Save button,xpath,//div[contains(@class,'btn-container d-flex')]//button[.='Save']";
	public static final String preferences_myProfile_UploadPhoto = "Upload Profile Photo,name,uploaded_file";
	public static final String preferences_myProfile_UploadPhotoErrMsg = "Photo Error Message,xpath,//div[.='Invalid image type']";
	public static final String preferences_myProfile_CancelButton = "Cancel Button,xpath,//div[contains(@class,'btn-container')]//button[.='Cancel']";
	public static final String preferences_myProfile_clickChangeMobNo = "Change Mobile Number,xpath,//small//label[.='Change mobile number?']";
	public static final String preferences_myProfile_ChangeMobNumberHeader = "Change Mobile Number Header,xpath,//div[@class='modal-header']//h2[.='Change mobile number']";
	public static final String preferences_myProfile_EnterMobileNumber = "Enter Mobile Number,xpath,//div[@class='modal-content']//div[@class='row']/child::div[not(contains(@class,'click-off'))]//input";
	public static final String preferences_myprofile_EnterMobileNumberErrorMessage = "Enter Mobile Number Error Message,xpath,//div[@class='position-relative col']//div[@class='validation-message mobilenoError']";
	public static final String preferences_myprofile_ChangeMobNoCancelbtn = "Cancel button in Change mobile number,xpath,//div[@class='modal-footer']//div[contains(@class,'btn-container d-flex ')]//button[.='Cancel']";
	public static final String preferences_myprofile_ChangeMobNoApplybtn = "Apply Button,xpath,//div[@class='btn-container d-flex justify-content-end']//button[.='Apply']";
	public static final String preferences_myprofile_EnterOTPField = "OTP Field,xpath,//input[@placeholder='Enter OTP']";
	public static final String preferences_myprofile_OTPSuccessMsg = "OTP Success Message,xpath,//div[@class='validation-message  success_msg']";
	public static final String preferences_myprofile_ChangePassword = "Change Password,xpath,//div//label[.='Change password?']";
	public static final String preferences_myprofile_ChangePasswordErrorMessage = "Change Password,xpath,//div[@class='validation-message  '][.='New and current password should not be same']";
	public static final String preferences_myprofile_ChangePasswordCancelbtn = "Cancel button in Change password,xpath,//div[@class='modal-footer']//div[contains(@class,'btn-container d-flex ')]//button[.='Cancel']";
	public static final String preferences_myprofile_ChangePasswordallfields = "All fields Change Password,xpath,//input[@type='password']";
	public static final String preferences_myprofile_OTP = "OTP Field,xpath,//input[@name='otp']";
	public static final String preferences_myprofile_OTPresend = "OTP Resend,xpath,//div//label[.='Resend?']";
	public static final String preferences_myProfileOTPExpired = "OTP Expired,xpath,//div[@class='validation-message  '][.='OTP expired.']";
	public static final String preferences_myProfileOTPTiming = "OTP Timing,xpath,//small[contains(.,'OTP is valid for 5 minutes ')]";
	public static final String preferences_myProfileChangeMobNoFlag = "Mobile Number Flag ,xpath,(//div[@class='flag in'])[3]";
	public static final String preferences_myProfileChangePassErrMsg = "Change Password Err,xpath,(//div[contains(@class,'validation-message')])[3]";
	public static final String preferences_myProfileInvalidOTPErrMsg = "Invalid OTP Err,xpath,//div[@class='validation-message  ']";
	public static final String preferences_myProfileLocalitzationAllfields = "All fields Localization,xpath,//div[@class='position-relative click-off-dropdown']";
	public static final String preferences_myProfilecityErrorMsg = "city Error Message,xpath,(//div[@class='validation-message '])[2]";
	public static final String preferences_myProfileStateErrorMsg = "state Error Message,xpath,(//div[contains(@class,'validation-message')])[4]";
	public static final String preferences_myProfileZipErrorMsg = "zip Error Message,xpath,(//div[contains(@class,'validation-message')])[3]";

	public static final String preferences_AccountSetting_AbtYourCompanyAlltextboxes = "About your company all Textboxes,xpath,//input[@class = 'sc-kDDrLX fepopK slashText '][not(contains(@name,'company name'))]";
	public static final String preferences_AccountSetting_Savebutton = "Save button,xpath,//div[contains(@class,'btn-container d-flex ')]//button[.='Save']";
	public static final String preferences_AccountSetting_errorMessages = "Account Setting Error Messages,xpath,//div[@class='validation-message ']";
	public static final String preferences_AccountSetting_UploadPhoto = "Upload Photo,xpath,//div//input[@type='file']";
	public static final String preferences_AccountSetting_UploadPhotoErrMsg = "Upload Photo Error Message,xpath,//div[@class='profile-image-wrapper']//div[@class='validation-message']";
	public static final String preferences_AccountSetting_RemoveProfilePhoto = "Remove Profile Photo,xpath,//div[@class='remove-profile cp']//span[.='Remove']";
	public static final String preferences_AccountSettings_EnterWebsite = "Enter Website,xpath,//div[@class='position-relative w-100 ']//input[@name='website']";
	public static final String preferences_AccountSettings_EnterWebsiteErrMsg = "EnterWebsite Error Message,xpath,//div[@class='position-relative w-100 ']//div[.='Enter a valid website']";
	public static final String preferences_AccountSettingsHeader = "Settings Header,xpath,//div[@class='sc-bczRLJ iHYiPx']//h1[.='Settings']";
	public static final String preferences_AccountSetting_CityState = "Enter City State,xpath,(//input[@class='sc-kDDrLX fepopK slashText '])[position()>=5 and position()<=6]";
	public static final String preferences_AccountSettings_EnterAddressline1 = "Enter Address 1,xpath,//input[@name='addressLine1']";
	public static final String preferences_AccountSettings_EnterAddressline2 = "Enter Address 2,xpath,//input[@name='addressLine2']";
	public static final String preferences_AccountSettings_EnterCity = "Enter city ,xpath,//input[@name='city']";
	public static final String preferences_AccountSettings_EnterState = "Enter state ,xpath,//input[@name='state']";
	public static final String preferences_AccountSettings_EnterCityErrMsg = "City Error Message,xpath,(//div[contains(@class,'validation-message ')])[4]";
	public static final String preferences_AccountSettings_EnterStateErrMsg = "State Error Message,xpath,(//div[contains(@class,'validation-message ')])[5]";
	public static final String preferences_AccountSettings_EnterZipErrMsg = "Zip Error Message,xpath,(//div[contains(@class,'validation-message ')])[6]";
	public static final String preferences_AccountSettings_EnterZipcode = "All Num fields,xpath,//input[@name='zipcode']";
	public static final String preferences_AccountSettings_Alltextfields = "All text fields,xpath,//input[contains(@class,'sc-kpDqfm jRbxen slashText ')][not(contains(@name,'company name'))]";
	public static final String preferences_AccountSettings_Settings = "Settings,xpath,//span[.='Settings']/..";
	public static final String preferences_AccountSettings_SelectCurrency = "Click Currency,xpath,(//*[@class='k-dropdown-wrap'])[1]";
	public static final String preferences_AccountSettings_Choosecurrency = "Choose Currency,xpath,//div//div[.='-- Select currency --']";
	public static final String preferences_AccountSettings_SelectDateFrmt = "Click Date Format,xpath,(//*[@class='k-dropdown-wrap'])[2]";
	public static final String preferences_AccountSettings_ChooseDateFrmt = "Choose Date Format,xpath,//div//div[.='-- Select date format --']";
	public static final String preferences_AccountSettings_SelectLanguage = "Language,xpath,(//*[@class='k-dropdown-wrap'])[3]";
	public static final String preferences_AccountSettings_ChooseLanguage = "Choose language,xpath,//div//div[.='-- Language --']";
	public static final String preferences_AccountSettings_SelectTimefrmt = "Time,xpath,(//*[@class='k-dropdown-wrap'])[4]";
	public static final String preferences_AccountSettings_ChooseTimefrmt = "Choose Time,xpath,//div//div[.='-- Select time format --']";
	public static final String preferences_AccountSettings_SettingsValidationMsgs = "All Validation,xpath,//div[@class='validation-message']";
	public static final String preferences_AccountSetting_SettingsAllfields = "All fields,xpath,//span[@class='k-dropdown-wrap']";
	public static final String preferences_AccountSettings_SettingsFieldDefaultOptn = "Default Option,xpath,//div[@class='k-list-optionlabel']";
	public static final String preferences_AccountSettings_UsersRoles = "All Roles,xpath,//span[@class='k-dropdown-wrap']";
	public static final String preferences_AccountSettings_UserAdmin = "User Admin,xpath,//span[@class='k-dropdown-wrap']//span[.='Admin']";
	public static final String preferences_AccountSettings_UserSuperuser = "User Admin,xpath,//span[@class='k-dropdown-wrap']//span[.='Superuser']";
	public static final String preferences_AccountSettings_UserCrownIcon = "Crown Icon,xpath,//i[contains(@class,'icon-crown-fill-small icons-sm ')]";
	public static final String preferences_AccountSetting_UserSelectRole = "Select Role,xpath,//div//div[.='-- Select role --']";
	public static final String preferences_AccountSetting_UserSelect = "Select User,xpath,//span[@class='k-dropdown-wrap']";
	public static final String preferences_AccountSettings_Savebutton = "save,xpath,//div[contains(@class,'btn-container d-flex justify-content-')]//button[.='Save']";
	public static final String preferences_AccountSettings_ClickUser = "Click User,xpath,//ul[contains(@class,'rs-chart-tab tabs-filled-component  ')]//li[.='Users']";

	public static final String preferences_Users_AddNewUsersHeader = "New Users Header,xpath,//h1[.='Add a new user']/.";
	public static final String preferences_Users_AddusersAllfields = "All fields,xpath,//div[contains(@class,'validation-message')][not(contains(@class,'validation-message-v2 '))]";
	public static final String preferences_UsersHeader = "Users Header,xpath,//h1[.='Users']/..";
	public static final String preferences_Users_MoreUsersWarningMessage = "More users warning ,xpath,//h4[contains(.,'You can add up to 5')]/..";
	public static final String preferences_Users_Addusers = "Add User,xpath,//button[.='Add user']";
	public static final String preferences_Users_AdduserWelcomeText = "Welcome User,xpath,//div[@class='position-relative']//textarea";
	public static final String preferences_Users_AdduserWelcomeTextWarningmsg = "Character limit Warning,xpath,//div[@class='validation-message top-30']";
	public static final String preferences_Users_EditUser = "Edit User,xpath,//span[@class='marginB0 cursor-pointer text-underline-h']";
	public static final String preferences_Users_EditUserHeader = "Edit User Header,xpath,//h1[.='Edit user']";
	public static final String preferences_Users_UpdateUser = "Update User,xpath,//div//button[.='Update user']";
	public static final String preferences_Users_ClickTitle = "Click Title,xpath,(//*[@class='k-dropdown-wrap'])[1]";
	public static final String preferences_Users_SelectTitle = "Select Title,xpath,//div//div[.='-- Title --']";
	public static final String preferences_Users_ClickJob = "Click Job,xpath,(//div[@class='position-relative'])[2]//span[@class='k-input']";
	public static final String preferences_Users_SelectJob = "Select Job,xpath,//div//div[.='-- Job function --']";
	public static final String preferences_Users_MobileNO = "Mobile Number,xpath,//input[@type='tel']";
	public static final String preferences_UsersFirstName = "Firstname,xpath,//input[@name='firstName']";
	public static final String preferences_UsersLastName = "LastName,xpath,//input[@name='lastName']";
	public static final String preferences_Users_FirstNameErrMsg = "Error Message,xpath,(//div[@class='validation-message '])[1]";
	public static final String preferences_Users_lastNameErrMsg = "Error Message,xpath,(//div[@class='validation-message '])[2]";
	public static final String preferences_Users_AllErrMsg = "Error Message,xpath,//div[contains(@class,'validation-message')][not(contains(@class,'validation-message-v2 '))]";
	public static final String preferences_UsersMobileNo = "Mobile Number,xpath,//input[@type='tel']";
	public static final String preferences_Users_Updateuser = "Update User,xpath,//div//button[.='Update user']";
	public static final String preferences_Users_UsersList = "list Users,xpath,//div//span[@class='marginB0 cursor-pointer text-underline-h']";
	public static final String preferences_Users_DynamicXpath = ",xpath,User,xpath,//ul//li[.='PLACE_HOLDER']";

	public static final String preferences_alertnotification_NotificationHamburger = "Notification Hamburger,xpath,//li/div[contains(@class,'head-ico-wrap h-notify')]";
	public static final String preferences_alertnotification_AllNotification = "All notifications,xpath,//div[@class='ml8 description']";
	public static final String preferences_alertsnotification_selectUserNotification = "User Detail,xpath,//div[contains(@class,'d-flex align-items-center float')]//div[.='User details has been updated.']";
	public static final String preferences_alertsnotification__firstNotification = " Notification Colour,xpath,(//span[@class='k-switch-container'])[1]";
	public static final String preferences_alertsnotification_Nextpage = "Next page,xpath,//a[@title='Go to the next page']";
	public static final String preferences_alertnotificationDisabledPage = "Disabled Last Page,xpath,//a[@title='Go to the next page'][@class='k-link k-pager-nav k-state-disabled']";
	public static final String preferences_alertnotificationsAlllist = "Table rows ,tag,tr";
	public static final String preferences_alertnotificationsAlllistdata = "Table data ,xpath,//tr//td[1]";

	public static final String preferences_CommSettings_Email = "Email,xpath,//i[@class='icon-mail-medium icons-lg']";
	public static final String preferences_CommSettings_AddButton = "Add button,xpath,//i[contains(@class,'icon-plus-fill-medium icons-lg blue float-right ')]";
	public static final String preferences_CommSettings_ErrMsgs = "SMTP Error Messages,xpath,//div[@class='validation-message ']";
	public static final String preferences_CommSettings_Allfields = "All input fields,xpath,//input[@class='sc-kpDqfm jRbxen slashText '][not(contains(@name,'userMailId'))][not(contains(@name,'password'))]";
	public static final String preferences_CommSettings__clickProvide = "Click Provider,xpath,//span[@class='k-dropdown-wrap']";
	public static final String preferences_CommSettings_selectProvide = "Select Provider,xpath,//div[@class='k-list-optionlabel k-state-selected']";
	public static final String preferences_CommSettings_SubscriptionAddbutton = "Add Button,xpath,*//i[contains(@class,'icon-sd-circle-plus-fill-edge-medium icons-lg')]/..";
	public static final String preferences_CommSettings_validatesettings = "Validate Settings,xpath,//button[.='Validate settings']";
	public static final String preferences_CommSettings_CickMessaging = "Click SMS,xpath,//li//span[.='Messaging']";
	public static final String preferences_CommSettings_SMSsavebutton = "Save button,xpath,//button[.='Save']";
	public static final String preferences_CommSettings_SubMessageBox = "Message box,xpath,//div[@class='k-content ProseMirror']";
	public static final String preferences_CommSettings_ErrorMsgs = "Error Messages,xpath,(//div[.='Enter title'])[3]";
	public static final String preferences_CommSettings_Subscbribe = "Subcribe Header,xpath,//div//h3[.='Subscribe']";
	public static final String preferences_CommSettings_RedirectionURL = "Redirection URL,xpath,//input[@name='redirectionUrl']";
	public static final String preferences_CommSettings_AdvSettings = "Advanced Settings,xpath,//span[@class='k-switch-container']//span[@class='k-switch-handle']";
	public static final String preferences_CommSettings_MessageBox = "Message Field,xpath,(//div[@class='k-content ProseMirror'])[1]";
	public static final String preferences_CommSettings_Whatsapp = "Whatsapp,xpath,//span[.='Whatsapp']";
	public static final String preferences_CommSettings_WelcomeMail = "Mail Icon,xpath,//i[contains(@class,'icon-edit-form-small blue ')]";
	public static final String preferences_CommSettings_WelcomeFarewellMailHeader = "Mail Header,xpath,//h2[.='Farewell mail'or'Welcome mail']";
	public static final String preferences_CommSettings_ImportZip = "File Import,xpath,//span[.='Import ZIP file']";
	public static final String preferences_CommSettings_WelcomeMailCancelBtn = "Cancel button,xpath,(//button[.='Cancel'])[2]";
	public static final String preferences_CommSettings_FileImport = "Import Zip,xpath,//div[@class='modal-body']//input[@type='file']";
	public static final String preferences_CommSettings_ImportURL = "Import URL,xpath,//input[@placeholder='Enter URL']";
	public static final String preferences_CommSettings_Import = "Import Button,xpath,//span[.='Import']";
	public static final String preferences_CommSettings_EnterURLErrMsg = "Enter valid website,xpath,(//div[.='Enter a valid website'])[2]";
	public static final String preferences_CommSettings_PreviewHeader = "Preview Header,xpath,//h2[.='Preview']";
	public static final String preferences_CommSettings_PreviewCancelButton = "Preview Cancel,xpath,//div[@class='modal-footer']//button[.='Cancel']";
	public static final String preferences_CommSettings_SmtpDomainName = "Domain Name,xpath,//input[@name='websiteName']";
	public static final String preferences_CommSettings_SmtpDomainNameErrMsg = "Error Message,xpath,(//div[@class='validation-message '])[1]";
	public static final String preferences_CommSettings_SmtpPortNumber = "Port Number,xpath,//input[@name='portNumber']";
	public static final String preferences_CommSettings_SmtpPortNumberErrMsg = "Error Message,xpath,(//div[@class='validation-message '])[3]";
	public static final String preferences_CommSettings_SmtpfromEmail = "Enter from Mail,xpath,//input[@name='serverFromEmail']";
	public static final String preferences_CommSettings_SmtpfromEmailErrMsg = "Error Message,xpath,(//div[@class='validation-message '])[6]";
	public static final String preferences_CommSettings_SmtpBounceEmail = "Enter Bounce Mail,xpath,//input[@name='serverBounceEmail']";
	public static final String preferences_CommSettings_SmtpBounceEmailErrMsg = "Error Message,xpath,(//div[@class='validation-message '])[7]";
	public static final String preferences_CommSettings_SMSsettings_AddsenderIDButton = "Plus icon,xpath,//i[contains(@class,'icon-plus-fill-small icons-md blue float-right cursor-pointer ')]";
	public static final String preferences_CommSettings_SMSHeader = "SMS Header,xpath,//span[.='SMS']";
	public static final String preferences_CommSettings_EnterTitle = "Enter Title,xpath,//input[@name='title']";
	public static final String preferences_CommSettings_EnterTitleErrMsg = "Error Message,xpath,//div[@class='validation-message ']";
	public static final String preferences_CommSettings_EnterSubjectline = "Subject Line,xpath,//input[@placeholder='Enter subject line']";
	public static final String preferences_CommSettings_DuplicateIcon = "Duplicate Icon,xpath,//i[contains(@class,'icon-duplicate-small icons-md blue')]";
	public static final String preferences_CommSettings_SubscribeList_Action = "Action Header,xpath,//span[@class='k-link']//span[.='Action']";

	public static final String preferences_DataExchange_RDSallfields = "All input fileds,xpath,//input[contains(@class,'sc-kpDqfm jRbxen slashText ')]";
	public static final String preferences_DataExchange_ = "Data Exchange,xpath,//i[@class='icon-sd-data-exchange-large icons-xl']";
	public static final String preferences_DataExchange_SFTP_PencilIcon = "Pencil Icon,xpath,//div[@class='data-card-view']//i[contains(@class,'icon-edit-pencil-small icons-')]";

	public static final String preferences_DataExchange_FriendlyName = "Friendly Name,xpath,//input[@placeholder='Friendly name']";
	public static final String preferences_DataExchange_FriendlyNameAlreadyExistPopup = "Friendly Name Popup,xpath,//div[@class='modal-content']//h4[contains(.,'Friendly name already')]";
	public static final String preferences_DataExchange_UserName = "User Name,xpath,//input[@placeholder='User name']";
	public static final String preferences_DataExchange_EnterPassword = "Password,xpath,//input[@placeholder='Password']";
	public static final String preferences_DataExchange_FolderPath = "Friendly Name,xpath,//input[@placeholder='Folder path']";
	public static final String preferences_DataExchange_RDS_plusIcon = "Plus Icon,xpath,//i[@class='icon-plus-fill-medium blue icons-lg cursor-pointer']";
	public static final String preferences_DataExchange_ConnectButton = "Connect Button,xpath,//button[.='Connect']";
	public static final String preferences_DataExchange_Ecommerce = "E-commerce,xpath,//li//span[.='E-commerce']";
	public static final String preferences_DataExchange_DataApi = "Data API,xpath,//h3[.='Data API']";
	public static final String preferences_DataExchange_AddAudienceHeader = "Add Audience Header,xpath,//h1[.='Add audience']";
	public static final String preferences_DataExchange_EnterIpAddress = "IP Address,xpath,//input[@placeholder='IP address']";
	public static final String preferences_DataExchange_IpAddressErrMsg = "Error message,xpath,//div[@class='position-relative w-100 ']//div[.= 'Enter a valid IP address']";
	public static final String preferences_DataExchange_EnterPortNumber = "Port Number,xpath,//input[@placeholder='Port number']";
	public static final String preferences_DataExchange_PortNumberErrMsg = "Error message,xpath,//div[@class='position-relative w-100 ']//div[.= 'Enter a valid port number']";

	public static final String preferences_Invoices_viewerIcon = "View Icon,xpath,//i[@class='icon-view-small icons-md blue cursor-pointer']";
	public static final String preferences_Invoices_SubscriptionInvoices = "Subscription Invoice,xpath,//span[.='Subscription invoice']";
	public static final String preferences_Invoices_ConsumablesInvoices = "Consumables Invoice,xpath,//span[.='Consumables invoice']";
	public static final String preferences_Invoices_PageHeader = "Page Header,xpath,//div//h1[.='Invoice list']";
	public static final String preferences_Invoices_BusinessTypeText = "Business Type Test,xpath,//h4[.='Enterprise (Monthly commitment)']";
	public static final String preferences_License_UpgradeButton = "Upgrade Button,xpath,//div[contains(@class,'btn-container d-flex')]//button[.='Upgrade']";
	public static final String preferences_License_InfoHeader = "License Info,xpath,//h1[.='License info']";
	public static final String preferences_Consumptions_EmailChannel = "Email Channel,xpath,//span[.='Email']";
	public static final String preferences_Consumptions_SmsChannel = "sms Channel,xpath,//span[.='SMS']";
	public static final String preferences_Consumptions_WhatsappChannel = "Whatsapp Channel,xpath,//span[.='WhatsApp']";
	public static final String preferences_Consumptions_QRChannel = "QR Channel,xpath,//span[contains(.,'QR ')]";
	public static final String preferences_Consumptions_Emailcount = "Email Count,xpath,(//div[@class='col-md-6']//h2)[1]";
	public static final String preferences_Consumptions_Header = "Consumptions status Header,xpath,//h3[contains(.,'Channel consumption ')]";
//------------------------------------------------------------------------------------------------------------------
	// YOGESHWARAN CODE

	// preferences user roles

	public static final String Preferences_Userroles = "User Roles,xpath,//i[contains(@class,'user-lock-xlarge font')]";
	public static final String Preferences_Userrolestitle = ",xpath,//div[@class='heading-title-text']//h1";
	public static final String Preferences_UserrolestitleNmae = "Roles and permissions";
	public static final String preferences_Userroles_grid = "User roles Grid,xpath,//table[@style='display: table;']";
	public static final String preferences_Userroles_addicon = "User Add icon,id,rs_RolesAndPermissions_circle_plus_fill";
	public static final String preferences_Userroles_Read_ListofRows = "User roles read list of rows ,xpath,//input[@checked]//..//span[.='Read']//ancestor::tr";
	public static final String preferences_Userroles_paginationClick = "User roles pagingation,xpath,//span[@class='k-input-value-text']";
	public static final String preferences_Userroles_paginationSelect = "User roles pagingation select,xpath,//div[@class='k-list k-list-md']//li";


	public static final String preferences_Userroles_Update_ListofRows = "User roles update list of rows ,xpath,//input[@checked]//..//span[.='Update']//ancestor::tr";
	public static final String preferences_Userroles_Create_ListofRows = "User roles create list of rows ,xpath,//input[@checked]//..//span[.='Create']//ancestor::tr";

	public static final String preferences_addUser_namefield = ",id,rs_AddPermission_Rolename";
	public static final String preferences_addUser_nameentryfield = "Role name,xpath,//input[@name='roleName']";
	public static final String preferences_adduser_Accessprivileges = "Access privileges,xpath,//input[@id='statusAll']";
	public static final String prefernces_adduser_updatebutton = "Update Button,id,rs_AddPermission_Save";
	public static final String prefernces_deleteuser_name = ",xpath,//tbody[@data-keyboardnavbody='true']//td[.='PLACE_HOLDER']";
	public static final String prefernces_deleteuser_deleteicon = "delete icon,xpath,//tbody[@data-keyboardnavbody='true']//td[.='PLACE_HOLDER']//following::i[contains(@class,'delete')]";
	public static final String prefernces_deleteuser_deletepopup = "Delete user role popup,xpath,//div[contains(@class,' rsmd-content')]";
	public static final String preferences_deleteuser_okbutton = "ok buttons,xpath,//button[.='OK']";
	public static final String Preferences_exisitinguser_eyeicon = "eye icon,xpath,(//i[contains(@class,'icon-rs-eye')])[1]";
	public static final String Preferences_exisitinguser_Editicon = "Edit icon,xpath,//span[.='" + dynamicXpathprefernces + "']/../..//i[contains(@class,'icon-rs-pencil')]";

	public static final String preferences_exisitinguser_namefiled = "disabled name field,xpath,//input[@name='roleName']";
	public static final String preferences_exisitinguser_Accessprivileges = "Access privileges,xpath,//input[@id='statusAll']";
	public static final String preferences_existinguser_cancelbutton = "cancel button,xpath,//button[.='Cancel']";
	public static final String preferences_existinguser_usereyeicon = "user eye icon,xpath,//td[.='User']//..//i";
	public static final String preferences_existinguser_superusereyeicon = "user eye icon,xpath,//td[.='Superuser']//..//i";
	public static final String preferences_existinguser_admineyeicon = "user eye icon,xpath,//td[.='Admin']//..//i";
	public static final String preferences_existinguser_Generatepasswordbutton = "Generate password,id,generatePassword";
	public static final String preferences_existinguser_passwordpreview = "Generate password,xpath,//i[@class='icon-md cursor-pointer color-primary-grey icon-rs-eye-hide-medium ']";
	public static final String preferences_existinguser_enforceotp = "Enforce otp,xpath,//span//span[.='Enforce OTP login']";
	public static final String preferences_existinguser_ADuser = "Ad user,xpath,//span//span[.='AD user']";

	// preferences Alert & Notification
	public static final String preferences_Alert = "Alerts & Notification ,xpath,//i[contains(@class,'icon-rs-alert')]";
	public static final String Preferences_alertstitle = ",xpath,//div//h1[contains(.,'Alerts')]";
	public static final String preferences_alertsGrid = "Alert & notification Grid,xpath,//table[@style='display: table;']";
	public static final String Preferences_alerts_firstpage = "first page,xpath,//li//a[@aria-label='undefined 1']";
	public static final String Preferences_alerts_secondpage = "first page,xpath,//li//a[@aria-label='undefined 2']";

	// Preferences User Management
	public static final String preferences_usermanagement = "User Management,xpath,//i[contains(@class,'icon-rs-users')]";
	public static final String preferences_usermanagement_addbtn = "Add Icon,xpath,//*//i[contains(@class,'icon-rs-circle-plus')]";
	public static final String preferences_usermanagement_newuserfirstname = "First Name,xpath,//input[@name='firstName']";
	public static final String preferences_usermanagement_newuserlastname = "Last Name,xpath,//input[@name='lastName']";
	public static final String preferences_usermanagement_newusermobileno = "Mobile No,xpath,//input[@class='form-control ']";
	public static final String preferences_usermanagement_newuseremail = "Email,xpath,//input[@name='emailId']";
	public static final String preferences_usermanagement_newuserjobfunction = "Job Function,xpath,(//span[@role='presentation'])[2]";
	public static final String preferences_usermanagement_newuserjoblist = "Job list,xpath,//div[@id='rs_AddUser_jobFunction']//span//span[@class='k-input-value-text']";
	public static final String preferences_usermanagement_newuserClick = ",xpath,(//div[@class='d-flex justify-content-between']//span//span)[1]";
	public static final String preferences_usermanagement_newuserProceed = ",xpath,(//div[@class='d-flex justify-content-between']//span//span)[1]";

	
	public static final String preferences_usermanagement_newuserwelocomemsg = "Mobile No,id,welcomeMessage";
	public static final String preferences_usermanagement_newuserpassbgvalidation = "colour bar,xpath,//div[contains(@class,'bg100')]";
	public static final String preferences_usermanagement_newuserarrow = "new user arrow button,xpath,//div[@class='rs-select-arrow-icon-right cp ']";
	public static final String preferences_usermanagement_newuserPassword = "new user password,xpath,//input[@name='password']";
	public static final String preferences_usermanagement_newuserNewpassword = "Generate password,id,rs_AddUser_password";
	public static final String preferences_usermanagement_newuserSave = "Newuser save,xpath,//i[@class='icon-rs-arrow-left-mini icon-xs color-primary-blue']";
	public static final String preferences_usermanagement_newuserCancel = ",xpath,//button[.='Cancel']";
	public static final String preferences_usermanagement_Update = "update button,xpath,//button[.='Update']";

	public static final String preferences_usermanagement_newuserpagesavebutton = "Save button,xpath,//button[.='Save']";
	public static final String preferences_usermanagement_newuserpageTitle = "Save button,id,rs_AddUser_Title";

	// Preferences Communication Setting
	public static final String preferences_communicationsetting_icon = "Communication Setting,xpath,//i[contains(@class,'communication')]";
	public static final String preferences_communicationsetting_page_mailicon = "comm page,xpath,//span[.='Mail']";
	public static final String preferences_communicationsetting_addicon = "Comm Add icon,xpath,//i[@id='rs_data_circle_plus_fill_edge']";
	public static final String preferences_communicationsetting_mailnewdomain_settings = "Setting for new domain,xpath,//i[contains(@class,'icon-rs-settings')]";
	public static final String preferences_commset_newdomain_placeholder = "SMTP domain settings,xpath,//input[@placeholder]//..//label";
	public static final String preferences_commset_newdomain_inputfield = "SMTP domain input,xpath,//div[@class='border-bottom-required']//..//input";
	public static final String preferences_commset_newdomain_savebutton = "save button,xpath,//button[.='Save']";
	public static final String preferences_communicationsetting_page_messageicon = "comm page,xpath,//span[.='Messaging']";
	public static final String preferences_commset_newdomain_inputsettings = "Input field,xpath,//input[@placeholder]";
	public static final String preferences_commset_newdomain_whatsappSave = "SMPP whatsapp save button,xpath,//button[@id='rs_WhatsAppCreate_Update']";
	public static final String preferences_commset_newdomain_whatsappProvider = "SMPP whatsapp provider,id,rs_WhatsAppCreate_provider";
	public static final String preferences_commset_newdomain_whatsappSenderID = "SMPP whatsapp Sender id,id,rs_WhatsAppCreate_senderId";
	public static final String preferences_commset_newdomain_whatsappUpdate = "SMPP whatsapp updateb button,id,rs_WhatsAppCreate_Update";

	public static final String prefereneces_commset_domainset_dropdown = "domain setting dropdown,xpath,//span[@class='k-input-value-text']";
	public static final String prefereneces_commset_domainset_dropdown_list = "domain dropdown list,xpath,//div[@class='k-list k-list-md']//li//span//span";
	public static final String prefereneces_commset_domainset_smpt_type = "domain SMPT Type,xpath,//label//span[.='Dedicated']";
	public static final String prefereneces_commset_domainset_smpt_type_editicon = "domain Edit Iocn,xpath,(//i[contains(@class,'icon-rs-pencil-edit')])[1]";
	public static final String preferences_commset_smstooltipvalidation = "SMS icon,xpath,(//i[contains(@class,'icon-rs-mobile-sms-medium click-off')])[1]";
	public static final String preferemces_commset_domainset_smpt_disableddomainname = "disabled Domain Name,xpath,//span[@aria-label='Domain name']//span[@class='k-input-value-text']";
	public static final String preferences_commset_cancelbutton_disableddomain = "cancel button,xpath,//button[.='Cancel']";
	public static final String preferences_commset_msgsmpp_smssettings_radiovalue = "radio button value,xpath,//input[@value='Promotional']";
	public static final String preferences_commset_smssettings_statusswitchbutton = "Switch button,xpath,//span[@aria-checked='false']";
	public static final String preferences_commset_sms_editusernamae = "Username,xpath,//input[@name='userName']";
	public static final String preferences_commset_sms_SaveButton = "Save button,xpath,//button[@type='submit']";

	// "Username,name,userName";
	public static final String preferences_commset_sms_editeduser_statusbutton = "Status Button,xpath,//td[.='PLACE_HOLDER']/following-sibling::td//span[.='ON']";
	public static final String preferences_commset_sms_user_statusvalidation = "Status,xpath,//td[.='PLACE_HOLDER']/following-sibling::td//span[contains(@class,'k-switch k-switch-md k-rounded-full')]";
	public static final String preferences_commset_whatsapp_Icon = "Whatsapp Icon,xpath,//span[.='WhatsApp']";
	public static final String preferences_commset_smpp_Whatsappcreate = "Whatsapp create,xpath,//input[@id='rs_WhatsAppCreate_accesspoint']";

	////////////////////////////////////// yogesh preferences code/////////////////////////////////////////////////
	public static final String preferences_preferencesModuleclick = "Preferences page header,xpath,//a[@href='/preferences']";

	public static final String preferences_myprofile_iconclick = "My Profile icon,xpath,//i[@class='icon-rs-user-list-xlarge font-xl']";
	public static final String preferences_myprofile_tooltip = "My Profile tooltip,xpath,//div//ul//li[@class='sd']//..//span[.='My profile']//following::div//div[@class='tooltip-inner']";
	public static final String preferences_myprofile_PersonalDetailsheader = "My Profile personal details header,xpath,//h4[.='Personal details']";
	public static final String preferences_myprofile_ProfilepictureHelptext = "My Profile dppicture help text ,xpath,//div[@class='alert alert-warning d-block mt30 py5']";
	public static final String preferences_myprofile_pencilTooltip = "My Profile pencilTooltip,xpath,//div[@class='fade show tooltip bs-tooltip-top']";
	public static final String preferences_myprofile_removeTooltip = "My Profile removeTooltip ,xpath,//div[@class='fade show tooltip bs-tooltip-top']";
	public static final String preferences_myprofile_dppicturepencilIcon = "My Profile picture Icon,id,rs_Imageupload_plus";
	public static final String preferences_myprofile_removeIcon = "My Profile remove Minus icon ,id,rs_RSImageUpload_circle_minus_fill";
	public static final String preferences_myprofile_Mobilenofield = "My Profile Moblieno field ,xpath,//div[@class='special-label']//span";
	public static final String preferences_myprofile_Alldisabledfield = "My Profile All disabled field,xpath,//input[@type='text']";
	public static final String preferences_myprofile_changePassword = "My Profile change password ,xpath,//label[.='Change password?']";
	public static final String preferences_myprofile_changepasswordHeader = "My Profile change password Header ,xpath,//h2[@class='modal-title']";
	public static final String preferences_myprofile_currentpassword = "My Profile current password,xpath,//input[@name='changePassword.currentpassword']";
	public static final String preferences_myprofile_currentInvalidation = "My Profile current invalidation,xpath,//label[text()='Enter a valid password']";
	public static final String preferences_myprofile_newPassword = "My Profile new password,xpath,//input[@name='changePassword.newpassword']";
	public static final String preferences_myprofile_confirmpassword = "My Profile confirm password,xpath,//input[@name='changePassword.confirmpassword']";
	public static final String preferences_myprofile_OtpSentSuccessfully = "My Profile Otp sent successfully ,xpath,//div[@class='alert alert-success']";
	public static final String preferences_myprofile_OtpenterField = "OTP Enter Field,xpath,//div[@id='otp']";
	public static final String preferences_myprofile_ValidOtpField = "Valid Otp field,xpath,//div[@class='alert alert-success mb10']";
	public static final String preferences_myprofile_PassUpdateButton = "My Profile password Update Button,xpath,//div[contains(@class,'modal-content')]//button[.='Update']";
	public static final String preferences_myprofile_ProfileUpdateButton = "My Profile Update Button,xpath,//button[.='Update']";
	public static final String preferences_myprofile_ProfileConfirmButton = "My Profile confirm Button,xpath,//div[contains(@class,'rsmdc-footer')]//button[.='Confirm']";
	public static final String preferences_myprofile_OtpButton = "My Profile Otp Button,xpath,//div[@id='otp']//..//input";
	public static final String preferences_myprofile_CsvDownload = "My Profile Csv button,xpath,,xpath,//h2[.='Download CSV']";

	public static final String preferences_myprofile_address = "My Profile Address,xpath,//input[@name='addressLine']";
	public static final String preferences_myprofile_addressvalidation = "My Profile addressvalidation,xpath,//label[text()='Min. 3 characters']";
	public static final String preferences_myprofile_jobFunction = "My Profile Job function,xpath,//span[text()='Account manager']";
	public static final String preferences_myprofile_jobFunctionList = "My Profile Job function List,xpath,//div[@class='k-list k-list-md']//li";
	public static final String preferences_myprofile_City = "My Profile City,xpath,//input[@name='city']";
	public static final String preferences_myprofile_pinCode = "My Profile pinCode,xpath,//input[@name='zipCode']";
	public static final String preferences_myprofile_dataFormat = "My Profile dataFormat,xpath,//span//span[text()='Date format']";
	public static final String preferences_myprofile_dataFormatList = "My Profile Data Format List,xpath,//div[@class='k-list-content']//li";
	public static final String preferences_myprofile_timeFormat = "My Profile Timeformat,xpath,//span//span[text()='Time format']";
	public static final String preferences_myprofile_timeFormatList = "My Profile TimeformatList,xpath,//div[@class='k-list-content']//li";
	public static final String preferences_myprofile_updateButton = "My Profile Update button,xpath,//button[@class='rs-button  rs-button-primary']";
	public static final String preferences_myprofile_SelectFirstname = "My Profile select firstname,id,rs_MyProfile_firstName";
//	public static final String preferences_myprofile_Updatemobilenumber = "My Profile Change mobile number,xpath,//label[@class='rs-button-link-small float-right d-block cp'][text()='Update mobile number?']";
	public static final String preferences_myprofile_Updatemobilenumber = "My Profile Change mobile number,xpath,//label[@class='rs-button-link-small float-right d-block cp'][contains(text(),'Update mobile number')]";
//	public static final String preferences_myprofile_UpdatemobilenumberCancel = "My Profile update mobile number cancel,xpath,//div[@class='rsmdc-footer w-100 modal-footer']//button[.='Cancel']";
	public static final String preferences_myprofile_UpdatemobilenumberCancel = "My Profile update mobile number cancel,xpath,//i[@id='rs_circle_close_edge']";
	public static final String preferences_myprofile_ChangepasswordClick = "My Profile change password click,xpath,//label[@class='rs-button-link-small float-right d-block cp'][.='Change password?']";
	public static final String preferences_myprofile_ChangepasswordHeader = "My Profile change password Header check,xpath,//h2[@class='modal-title']";
	public static final String preferences_myprofile_ChangeCurrentpassword = "My Profile change current password click,xpath,//input[@name='changePassword.currentpassword']";
//	public static final String preferences_myprofile_changepsswrdCancel = "My Profile change psasword cancel click,xpath,//div[@class='rsmdc-footer w-100 modal-footer']//button[text()='Cancel']";
	public static final String preferences_myprofile_changepsswrdCancel = "My Profile change psasword cancel click,xpath,//i[@id='rs_circle_close_edge']";
	public static final String preferences_myprofile_Zipcode = "My Profile zipcode click,id,rs_MyProfile_zipCode";
	public static final String preferences_myprofile_Savemyprofile = "My Profile save myprofile click,id,rs_MyProfile_Update";

	// CommunicationSettings

	public static final String preferences_clickCommunicationSettings = "communication settings icon,id,rs_PREFRENCE_LISTS_commu.settings";
	public static final String preferences_mousehoverCommunicationSettings = "communication settings icon,xpath,//div[@class='tooltip-inner']";
	public static final String preferences_communicationsettingheadervalidation = "communicationsetting validation,xpath,//div[@class='heading-title-text']";
	public static final String Preferences_CommSettings_notification = "click notification,xpath,//i[@class='icon-rs-notification-large icon-lg']";
	public static final String Preferences_CommSettings_mobileApp = "Mobile App click,xpath,//i[@class='icon-rs-mobile-notification-large icon-lg color-primary-blue']";
	public static final String Preferences_CommSettings_addMobileApp = "Add (+) Button,id,rs_data_circle_plus_fill_edge";
	public static final String Preferences_CommSettings_Appname_inputBox = "App Name,id,appName";
	public static final String Preferences_CommSettings_DeviceSetup = "Mobile icon header,xpath,//button[@class='accordion-button']";
	public static final String Preferences_CommSettings_Mobileplatform = "Mobile Platform,xpath,//span[@class='k-input-value-text']";
	public static final String Preferences_CommSettings_MobileplatformList = "Mobile platform,xpath,//div[contains(@class,'k-animation-container-shown')]//li";
	public static final String Preferences_CommSettings_Mobile_AppStoreURL = "AppStore URL,id,devices[0].appStoreUrl";
	public static final String Preferences_CommSettings_MobileNotifyProvider = "Notification Provider,xpath,//input[@name='devices[0].notificationProvider']";
	public static final String Preferences_CommSettings_MobileNotify = "Notification Provider native,,name,devices[0].HTTPFilePath";

	public static final String Preferences_CommSettings_MobileNotifyAppAnalytics = "Notification app analytics toggle button,id,rs_DeviceIntegration_isAppAnalyticsswitch";
	public static final String Preferences_CommSettings_MobileNotifyPlatform = "Notification app analytics platform,id,rs_AppAnalyticsSetting_analyticsDomainName";
	public static final String Preferences_CommSettings_MobileNotifyAppServiceEmail = "Notification app analytics toggle button,id,rs_AppAnalyticsSetting_accountMail";
	public static final String Preferences_CommSettings_MobileNotifyAppKey = "Notification app analytics app key,id,rs_AppAnalyticsSetting_appKey";
	public static final String Preferences_CommSettings_MobileNotifySecretKey = "Notification app analytics app key,id,rs_AppAnalyticsSetting_SecretID";
	public static final String Preferences_CommSettings_MobileNotifyAppAnalyticsAdd = "Notification app analytics add icon,xpath,//i[contains(@class,'icon-rs-circle-plus-fill-medium')] ";
	public static final String Preferences_CommSettings_MobileNotifyAppAnalyticsMinus = "Notification app analytics add icon,xpath,//i[contains(@class,'icon-rs-circle-minus-fill-medium color')]";

	public static final String Preferences_CommSettings_MobileNotifyProviderUpload = "Notification Provider Upload,id,rs_RSFileUpload_primary";

	public static final String Preferences_CommSettings_FCM_senderID = "FCM sender ID,xpath,//input[@name='devices[0].fcmSenderId']";
	public static final String Preferences_CommSettings_FCM_serverKey = "FCM sever Key ,xpath,//input[@name='devices[0].fcmServerkey']";
	public static final String Preferences_CommSettings_Mobile_NativeLanguage = "Native Language radio btn,xpath,//input[@value='Native']";
	public static final String Preferences_CommSettings_Mobile_HybridLanguage = "Native Language radio btn,xpath,//input[@value='Hybrid']";
	public static final String Preferences_CommSettings_HybridApp_DropdownClick = "Hybrid app language drop-down,xpath,//div[@class='col-sm-4']";
	public static final String Preferences_CommSettings_HybridApp_DropdownList = "Hybrid app language list,xpath,//div[@class='k-list k-list-md']//li";
	public static final String Preferences_CommSettings_AppSaveBtn = "Save Button,id,rs_AppNotificationOnBoarding_Save";
	public static final String Preferences_CommSettings_AppCancelBtn = "Cancel Button,id,rs_AppNotificationOnBoarding_Cancel";
	public static final String Preferences_CommSettings_AppList = "App names,xpath,//*[contains(@class,'k-master-row')]//label";
	public static final String Preferences_CommSettings_MobDropdwnView = "mobile dropdown view click,xpath,//div[@class='css-scrollbar']//div[.='View']";
	public static final String Preferences_CommSettings_MobDropdwnClick = "mobile dropdown view click,xpath,(//i[@id='rs_AppListRowCell_Arrowdown'])[1]";

	public static final String Preferences_CommSettings_Mobsettingsattri = "mobile settings attribute,xpath,//h4[@class='m0 float-start']";
	public static final String preferences_CommSettings_MobsettingsEditIcon = "MobsettingsEditIcon,xpath,//h4[.='" + dynamicXpathprefernces + "']/..//i[@id='rs_data_pencil_edit']";
	public static final String Preferences_CommSettings_MobsettingspopupSave = "MobsettingspopupSave,xpath,//button[@class='rs-button ml15 rs-button-primary']";
	public static final String Preferences_CommSettings_Mobsettingstotalattri = "Mobsettingstotalattroi,xpath,(//h5[@class='mb10'])[2]/..//ul//li";
	public static final String Preferences_CommSettings_MobsettingsSave = "Mobsettings Save button,xpath,//div//button[.='Save']";

//goalMobile
	public static final String Preferences_CommSettings_MobActionGoalname = "Mobile Goal name value,id,goalName";
	public static final String Preferences_CommSettings_MobActionGoalPlatform = "Mobile Goal platform click value,id,rs_MobilePushGoalSettingCreate_platformName";
	public static final String Preferences_CommSettings_MobActionGoalPlatformList = "Mobile Goal platform List ,id,//div[@class='k-list k-list-md']//div//li";
	public static final String Preferences_CommSettings_MobActionGoalfriendlyName = "Mobile Goal friendly name value,id,rs_MobilePushGoalSettingCreate_Friendlyname";
	public static final String Preferences_CommSettings_MobActionGoaltype = "Mobile Goal Type,id,rs_WebPushGoalSettingsCreate_goaltype";
	public static final String Preferences_CommSettings_MobActionGoalTypeList = "Mobile Goal Type list,xpath,//div[@class='k-list k-list-md']//div//ul//li";
	public static final String Preferences_CommSettings_MobActionGoalPageUrl = "Mobile Goal page url,id,rs_MobilePushGoalSettingCreate_pageUrlScreen";
	public static final String Preferences_CommSettings_MobActionGoalPageSubUrl = "Mobile Goal page sub url,id,rs_MobilePushGoalSettingCreate_pageUrlsubScreen";
	public static final String Preferences_CommSettings_MobActionGoalSave = "Mobile Goal save button,id,rs_MobilePushGoalSettingCreate_Save";
	public static final String Preferences_CommSettings_MobActionGoalOnOffbutton = "Mobile Goal on off button,xpath,//div[@class='d-flex justify-content-between']//span[.='PLACE_HOLDER']/../../..//span[@aria-checked='false']";

	// Communication settings Webpush notification
	public static final String Preferences_CommunicationSettings_NotificationClick = "Notification click,xpath,//i[contains(@class,'icon-rs-notification')]/..//span[.='Notifications']";
	public static final String Preferences_CommunicationSettings_Webnot_WebHeader = "Web notification Header,xpath,(//span[.='Web'])[1]";
	public static final String Preferences_CommunicationSettings_Webnot_add = "Webnot add,xpath,//i[@class='icon-lg color-primary-blue icon-hover-shadow-primary icon-rs-circle-plus-fill-edge-medium  ']";
	public static final String Preferences_CommunicationSettings_Webnot_domainname = "web not domain name,xpath,//input[@id='domainName']";
	public static final String Preferences_CommunicationSettings_Webnot_domainURL = "webnot domain url,id,rs_PushWebCreate_domainUrl";
	public static final String Preferences_CommunicationSettings_Webnot_uploadbutton = "webnot logo,name,domainLogo";
	public static final String Preferences_CommunicationSettings_Webnot_FCMuploadbutton = "webnot logo FCM upload button,name,fcmJSONFile";

	public static final String Preferences_CommunicationSettings_Webnot_notiproviderbuttn = "V1 HTTP radio button click,xpath,(//input[@name='notificationProvider'])[2]";
	public static final String Preferences_CommunicationSettings_Webnot_FCMSenderID = "webnot FCM senderID,xpath,//input[@name='fcmSenderId']";
	public static final String Preferences_CommunicationSettings_Webnot_FCMServerkey = "webnot FCM Serverkey,xpath,//input[@name='fcmServerKey']";

	public static final String Preferences_CommunicationSettings_Webnot_firebaseApikey = "webnot firebase Apikey,id,rs_PushWebCreate_apikey";
	public static final String Preferences_CommunicationSettings_Webnot_DomainLogo = "webnot firebase Apikey,xpath,//input[@name='domainLogo'][@type='file']";
	public static final String Preferences_CommunicationSettings_Webnot_FcmLogo = "webnot firebase Apikey,id,rs_PushWebCreate_fcmJSONFile";


	public static final String Preferences_CommunicationSettings_Webnot_firebase_authdomain = "webnot firebase authdomain,id,rs_PushWebCreate_authDomain";
	public static final String Preferences_CommunicationSettings_Webnot_firebase_DatabaseURL = "webnot firebase DatabaseURL,id,rs_PushWebCreate_databaseUrl";
	public static final String Preferences_CommunicationSettings_Webnot_firebase_ProjectID = "web not firebase projectID,id,rs_PushWebCreate_projectId";
	public static final String Preferences_CommunicationSettings_Webnot_firebase_Storagebucket = "web not firebase storagebucket,id,rs_PushWebCreate_storageBucket";
	public static final String Preferences_CommunicationSettings_Webnot_firebase_MeasurementID = "web not firebase messaging sender ID,id,rs_PushWebCreate_measurementId";
	public static final String Preferences_CommunicationSettings_Webnot_firebase_AppID = "web not firebase AppID,id,rs_PushWebCreate_appId";
	public static final String Preferences_CommunicationSettings_Webnot_firebase_VAPID = "web not firebase AppID,id,rs_PushWebCreate_vapId";
	public static final String Preferences_CommunicationSettings_Webnot_analyticsSavebtn = "webnot analyics save button,id,rs_PushWebCreate_submit";
	public static final String Preferences_CommunicationSettings_Webnot_analyticsCancelbtn = "webnot analyics cancel button,id,rs_PushWebCreate_Cancel";
	public static final String Preferences_CommunicationSettings_Webnot_analyticsUpdatebtn = "webnot analyics Update button,id,rs_PushWebCreate_submit";
	public static final String Preferences_CommunicationSettings_Webnot_allfield = "webnot All field editable,xpath,//input[@type='text']";

	public static final String Preferences_CommunicationSettings_Webnot_infodropdwnClick = "webnot info dropdwn click,xpath,//a[@class='dropdown-item'][text()='Info']";
	public static final String Preferences_CommunicationSettings_Webnot_settingsdropdwnClick = "webnot settings dropdwn click,xpath,//a[@class='dropdown-item'][text()='Settings']";
	public static final String Preferences_CommunicationSettings_Mobnot_settingsView = "mobnot settings view button,xpath,//a[.='View']";

	public static final String Preferences_CommunicationSettings_Webnot_infoHeader = "webnot infoHeader,xpath,//section[@id='1']//h1[text()='1. Introduction']";
	public static final String Preferences_CommunicationSettings_Webnot_infoBack = "webnot info back button,xpath,//div[text()='Back']";
	public static final String Preferences_CommunicationSettings_Webnot_commsettButtn = "commsett Button click ,xpath,//div[text()='Back']";
	public static final String Preferences_CommunicationSettings_Webnot_settingsAllattributes = "webnot settings All attributes,xpath,//h4[@class='m0 float-start'][.='Attributes']/..//i[@id='rs_data_pencil_edit']";
	public static final String Preferences_CommunicationSettings_Webnot_settingsattributesrlft = "webnot settings All attributes,xpath,(//div[@class='k-list-scroller k-selectable']//li)[1]";
	public static final String Preferences_CommunicationSettings_Webnot_settingsattributesAll = "webnot settings All attributes,xpath,//h4[.='Attributes']/../..//ul[@class='rs-attr-sep css-scrollbar mb8']//li";

	public static final String Preferences_CommunicationSettings_Webnot_settingsattributesryt = "webnot settings All attributes,xpath,(//div[@class='multiClm multiRghtClm']//li)[1]//span[.='" + dynamicXpathprefernces + "']";
	public static final String Preferences_CommunicationSettings_Webnot_headers = "webnot settings header check,xpath,//h4[.='Attributes']";
	public static final String Preferences_CommunicationSettings_Webnot_Inbox_headers = "webnot settings header check,xpath,//h4[.='Inbox classification']";
	public static final String Preferences_CommunicationSettings_Webnot_KeywordEnter = "webnot settings keyboard enter,xpath,//input[@placeholder='Enter keywords']";
	public static final String Preferences_CommunicationSettings_Webnot_Refresh = "webnot settings refresh,xpath,//i[@id='rs_data_refresh']";
	public static final String Preferences_CommunicationSettings_Webnot_Save = "webnot settings save button,xpath,//button[.='Save']";

	public static final String Preferences_CommunicationSettings_Webnot_ToogleButton = "webnot settings toogle button,xpath,//h4[.='Inbox classification']/..//span[@class='k-switch-track k-rounded-full']";

	public static final String Preferences_CommunicationSettings_Webnot_settingsAllattributesEdit = "webnot settings all attribute edit icon,xpath,//h4[@class='m0 float-start'][text()='" + dynamicXpathprefernces
			+ "']/..//i[@id='rs_data_pencil_edit']";
	public static final String Preferences_CommunicationSettings_Mobilenot_settingsAlldataattri = "Mobilenot settings All data attributes,xpath,//div[@class='tag-list-block box-design no-box-shadow']//h5//span/../..//ul//li";

	public static final String Preferences_CommunicationSettings_Webnot_SelectDomain = "xpath,(//span[contains(.,'-- Select domain --')])[3]";
	public static final String Preferences_CommunicationSettings_Webnot_SelectDomainClick = "xpath, //*[@id='selectDomain_listbox']/li";
	public static final String Preferences_CommunicationSettings_Webnot_Download = "Web notifiacation download dropdown clicked,xpath,//a[.='Download']";
	public static final String Preferences_CommunicationSettings_Webnot_Delete = "Web notifiacation delete dropdown clicked,xpath,//a[.='Delete']";
	public static final String Preferences_CommunicationSettings_Webnot_AddGoal = "Web notification Goal add icon clicked,id,rs_data_circle_plus_fill_edge";
	public static final String Preferences_CommunicationSettings_Webnot_GoalHeader = "Web notification Goal settings header,xpath,//h4[.='Goal settings']";
	public static final String Preferences_CommunicationSettings_Webnot_GoalName = "Web notification Goal Name value,id,goalName";
	public static final String Preferences_CommunicationSettings_Webnot_GoalSecHeader = "Web notification Goal Goal tracking type,xpath,//h4[.='Goal tracking type']";
	public static final String Preferences_CommunicationSettings_Webnot_GoalFriendlyName = "Web notification Goal friendly Name value,id,rs_WebPushGoalSettingsCreate_friendlyname";
	public static final String Preferences_CommunicationSettings_Webnot_GoalType = "Web notification Goal Type select,id,rs_WebPushGoalSettingsCreate_goaltype";
	public static final String Preferences_CommunicationSettings_Webnot_GoalTypeList = "Web notification Goal Type List select,xpath,//div[@class='k-list-content']//li";
	public static final String Preferences_CommunicationSettings_Webnot_GoalPageUrl = "Web notification Goal Type select,id,rs_WebPushGoalSettingsCreate_pageurl";
	public static final String Preferences_CommunicationSettings_Webnot_GoalSaveButton = "Web notification Goal button click,id,rs_WebPushGoalSettingsCreate_Save";
	public static final String Preferences_CommunicationSettings_Webnot_GoalOnOffButton = "Web notification Goal on off button,xpath,//div[@class='d-flex justify-content-between']//span//div//span[.='PLACE_HOLDER']/../../../../..//span//span[@role='switch']";
	public static final String Preferences_CommunicationSettings_Webnot_Goalback = "Web notification Goal back button,xpath,//div//span[@class='color-secondary-blue']";
	public static final String Preferences_CommunicationSettings_Webnot_lastpage = "Web notification last page button,xpath,//a[contains(@class,'k-pager-last')]";
	public static final String Preferences_CommunicationSettings_Webnot_Goal_VisionMutual = "Web notification goal vision mutual,xpath,//td//span[contains(.,'Vision mutual')]/../..//i[contains(@class,'icon-rs-goal')]";
	public static final String Preferences_CommunicationSettings_Webnot_VisionMutual = "Web notification vision mutual button,xpath,//span[.='Vision mutual']";

	// alerts and notifications
	public static final String _preferences_alertandnotification_Click = "alerts and notification click,xpath,//i[@class='icon-rs-alert-xlarge font-xl']/..//span[.='Alerts']";

	public static final String _preferences_alertandnotification_pagination = "alerts and notification pagination,xpath,//div[@class='k-list k-list-md']//li//span";
	public static final String _preferences_alertandnotification_ToggleButton = "alerts and notification pagination,xpath,//span[@class='k-dropdownlist k-picker k-picker-md k-rounded-md k-picker-solid']";

	public static final String _preferences_alertandnotification_notificationClick = "Main page notification Click,xpath,//i[@class='icon-rs-list-bar-medium icon-md white cursor-pointer']";
	public static final String _preferences_alertandnotification_notificationSettingsClick = "Main page notification settings click ,xpath,//i[@class='icon-rs-settings-edge-mini']";
	public static final String _preferences_alertandnotification_notificationViewallClick = "Main page notification View all Click,xpath,//a[@class='notification-footer dropdown-item']//button[.='View all']";
	public static final String _preferences_alertandnotification_notificationdescriptionrow = "Main page notification description row,xpath,//thead[@class='k-grid-header']//tr//../..//tr";

	// data catalogue
	public static final String pw_preferences_DataCatalogue_Click = "datacatalogue click,pw,//i[@class='icon-rs-data-catalogue-xlarge font-xl']";

	public static final String pw_preferences_DataCatalogue_AddClick = "datacatalogue click,pw,//i[@class='icon-rs-data-catalogue-xlarge font-xl']";
	public static final String preferences_datacatalogue_closeicon = "Edit icon,id,rs_circle_close_edge";

	public static final String preferences_DataCatalogue_AddClick = "datacatalogue click,xpath,(//i[@id='rs_data_circle_plus_fill_edge'])[2]";
	public static final String preferences_DataCatalogue_MinimizeClick= "Minimizeicon,xpath,//div[contains(@class,'block expandView')]//i[contains(@class,'collapse-mini')]";

	public static final String preferences_DataCatalogue_FooterClick= "Footer,xpath,//div[contains(@class,'rsmdc-footer')]//button";


	public static final String preferences_DataCatalogue_Breadcrumb = "dataCatalogue breadcrumb,xpath,//ul[@class='breadcrumb']//li[@class='active']";
	public static final String preferences_datacatalogue_filtergroup = "Filter Group,xpath,//ul[@class='rs-tabs row   mb0 mini rst-left-space  ']//span[contains(.,'Filter groups')]";
	public static final String preferences_datacatalogue_classification = "Classification,xpath,//div[@class='row']/div//li/..//span[contains(.,'Classification')]";
	public static final String preferences_datacatalogue_filtergroupheader = "Filter Group header,xpath,//div[@class='clearfix mt30 mb5']//h4[@class='m0 float-start']";
	public static final String preferences_datacatalogue_editicon = "Edit icon,xpath,//h4[.='" + dynamicXpathprefernces + "']/..//i[@id='rs_data_pencil_edit']";
	public static final String preferences_datacatalogue_scrolldown = "Scrolldown,xpath,//div[@class='col-sm-6 data-attribute-block ']//h4[.='" + dynamicXpathprefernces + "']";
	public static final String preferences_datacatalogue_leftselectattribute = "Right select attribute,xpath,(//div[@class='multiClm multiLftClm']//ul//li)[3]";
	public static final String preferences_datacatalogue_leftselectnodataavailable = "No data available,xpath,//div[@class='multiClm multiLftClm']//p[.='No data available']";
	public static final String preferences_datacatalogue_rightarrowicon = "right Arrow,xpath,//button[@title='Transfer To']";
	public static final String preferences_datacatalogue_Leftrowicon = "right Arrow,xpath,//button[@title='Transfer From']";
	public static final String preferences_datacatalogue_AllAttributes = "All attributes,xpath,//h4[.='Attributes']/../..//ul[@class='rs-attr-sep css-scrollbar mb8']//li";

	public static final String preferences_datacatalogue_Updatebutton = "update Button,xpath,//button[contains(.,'Update')]";
	public static final String preferences_datacatalogue_popupProceedbutton = "popup Proceedbutton,xpath,//button[contains(.,'Proceed')]";
	public static final String preferences_datacatalogue_overallattributescrolldown = "Scrolldown,xpath,//div[@class='row']//h4[.='" + dynamicXpathprefernces + "']";
	public static final String preferences_datacatalogue_maximizeicon = "Maximize icon,xpath,//div//*//h4[.='" + dynamicXpathprefernces + "']/../..//i[@class='icon-rs-expand-mini expandIcon icon-xs']";
	public static final String preferences_datacatalogue_totalattribute = "Total Attribute,xpath,//h4[@class='m0 float-start'][.='" + dynamicXpathprefernces + "']/../..//div[contains(@class,'tag-list-block box-design primary-box-shadow')]//ul//li";
	public static final String preferences_datacatalogue_minimizeicon = "Minimize icon,xpath,//h4[@class='m0 float-start'][.='" + dynamicXpathprefernces + "']/../..//i[@class='icon-rs-collapse-mini collapseIcon icon-xs']";
	public static final String preferences_datacatalogue_minimizeButton = "Minimize click,xpath,//div[contains(@class,'block expandView')]//i[contains(@class,'collapse-mini')]";

	public static final String preferences_datacatalogue_maximizeButton = "Maximize button,xpath,//div[@class='tag-list-block box-design']/..//div[contains(@class,'expColIcon')]";
	public static final String preferences_datacatalogue_CancelIcon = "cancel icon,id,rs_NewAttributeModal_Cancel";
	public static final String preferences_datacatalogue_RytSearchIcon = "Right Search icon,xpath,(//i[@id='rs_data_zoom'])[2]";
	public static final String preferences_datacatalogue_LftSearchIcon = "Left Search icon,xpath,(//i[@id='rs_data_zoom'])[2]";

	public static final String preferences_datacatalogue_SearchInputField = "search input field,xpath,//input[@class='searchInput active ']";

	// public static final String preferences_datacatalogue_scrolllistelement =
	// "Scroll down,xpath,";
	public static final String preferences_datacatalogue_rightselectattribute = "Left selected attribute,xpath,//h4[@class='m0 py10'][contains(.,'Selected columns')]/..//li//span[.='" + dynamicXpathprefernces + "']";
	public static final String preferences_datacatalogue_Dataingestedcolor = "Dataingested color Pale gray,xpath,//span[@class='dataInjested-CSS']";
	public static final String preferences_datacatalogue_Transactiondatacolor = "Transactiondata color Green ,xpath,//span[@class='transactionData-CSS']";
	public static final String preferences_datacatalogue_KPIdatacolor = "KPI data color Blue ,xpath,//span[@class='kpiData-CSS']";
	public static final String preferences_datacatalogue_Sensitivedatacolor = "Sensitive data color Orange ,xpath,//span[@class='sensitiveData-CSS']";

	// ------------------------------------------------------------------------------------------------------------------------

	// Negative dataCatalogue scenarios

	public static final String preferences_dataattribute_addattribute = "New Attribute create,xpath, //div//i[@id='rs_data_circle_plus_fill_edge']";
	public static final String preferences_dataattribute_attributename = "New attribute name,xpath, //input[@id='uIPrintableName']";
	public static final String preferences_dataattribute_attributenameErrorMessage = "New attribute name Error Message,xpath, //input[@id='uIPrintableName']/..//label[contains(.,'Attribute name already exists')]";
	public static final String preferences_dataattribute_AttriNameError = "Enter attribute name ,xpath, //label[text()='Enter attribute name']";
	public static final String preferences_dataattribute_attributenameSpecialCharErrorMessage = "New attribute Special Character Error Message,xpath, //input[@id='uIPrintableName']/..//label[contains(.,'Only (_ & -) are allowed')]";
	public static final String preferences_dataattribute_DescriptionBox = "DescriptionBox name ,xpath, //textarea[@id='description']";
	public static final String preferences_dataattribute_DescriptionBoxErrorValidation = "DescriptionBox Error Validation ,xpath, //textarea[@name='description']/..//div[contains(.,'Min 10 characters')]";

	public static final String preferences_dataattribute_Saveeattribute = "SaveAttribute,xpath, //div//button[@id='rs_NewAttributeModal_Save']";
	public static final String preferences_dataattribute_Datatype = "Datatype name,xpath, //div[@id='rs_NewAttributeModal_dataType']//span[@class='k-input-value-text']";
	public static final String preferences_dataattribute_DatatypeErrorValidation = "Select data type,xpath, //span[contains(text(),'Select data type')]";
	public static final String preferences_dataattribute_Inputtype = "Inputtype name,xpath, //div[@id='rs_NewAttributeModal_inputType']";
	public static final String preferences_dataattribute_InputtypeErrorValidation = "Select data type,xpath, //span[contains(text(),'Select input type')]";
	public static final String preferences_dataattribute_Selectfiltergroup = "Selectfiltergroup name,xpath, (//span[contains(@class,'k-dropdownlist k-picker rs-kendo-dropdown')]//span//span)[4]";
	public static final String preferences_dataattribute_FiltergroupErrorValidation = "Select data type,xpath, //select[@name='filterGroup']/../..//span[contains(.,'Select filter group')]";
	public static final String preferences_dataattribute_DatatypeList = "Datatype List ,xpath, //div[@class='k-list k-list-md']//ul//li";
	public static final String preferences_dataattribute_Classification = "classification Click ,xpath,//input[@placeholder='Classification']";
	public static final String preferences_dataattribute_ClassificationList = "classification List ,xpath, //label[contains(.,'Classification')]/../..//ul//li";
	public static final String preferences_dataattribute_ClassificationFallbackName = "Classification Fallbackname click ,xpath, //input[@name='fallbackAttributeName']";
	public static final String preferences_dataattribute_FallbackerrorValidation = "Fallbackerror Validation ,xpath, //input[@name='fallbackAttributeName']/..//label[contains(text(),'Enter default fallback attribute name')]";
	public static final String preferences_dataattribute_FallbackcharValidation = "Fallback character Validation ,xpath, //input[@name='fallbackAttributeName']/..//label[contains(.,'Min. 3 characters')]";

	// DatatypeCondition
	public static final String preferences_dataattribute_DatatypeCondition1 = "Datatype condition1 Click ,xpath, //div[text()='Condition:']/../../..//span[@class='k-floating-label-container k-empty']";
	public static final String preferences_dataattribute_Datatype1ErrorValidation = "Datatype condition1 Error valid ,xpath, //span[@class='k-floating-label-container k-empty'][contains(.,'This field is required')]";
	public static final String preferences_dataattribute_DatatypeCondition1Text = "Datatype condition2 Click ,xpath, //input[@name='kpiConditions.0.value']";
	public static final String preferences_dataattribute_Datatype1TextErrorValidation = "Datatype condition2 Error valid ,xpath, //input[@name='kpiConditions.0.value']/..//label[contains(.,'This field is required')]";
	public static final String preferences_dataattribute_AddAttriClose = "add attribute close button ,xpath, //i[@id='rs_circle_close_edge']";

	// ----------------------------------------------------------------------

	public static final String preferences_Gridview = "Gridview Click ,xpath,//i[contains(@class,'icon-rs-circle-grid')]";
	public static final String preferences_CsvFileClick = "CsvFile Click ,xpath,//i[contains(@class,'icon-rs-csv')]";//
	public static final String preferences_CsvPopupHeader = "CsvPopupHeader present ,xpath, //h2[contains(.,'Download CSV')]";
	public static final String preferences_CsvOtp = "Csv OTP Click ,xpath, //div[@class='col-sm-3']//span[@class='k-input-inner']";
	public static final String preferences_CsvOtpList = "Csv OTP List,xpath, //div[contains(@class,'k-list-content')]//ul//li";
	public static final String preferences_CsvOtpMessage = "Csv OTP Message present,xpath, //div[@class='alert alert-success']//span[contains(.,'OTP sent successfully')]";

//	Webtable Data catalogue
	public static final String preferences_dataCataWebtableHeader = "WebtableHeader ,xpath, //thead//tr[@role='row']//th";
	public static final String preferences_dataCataWebtableRows = "Webtable Rows ,xpath, //tr[contains(@class,'k-master-row')]";
	public static final String preferences_dataCataWebtablePagination = "Webtable next button click ,xpath,  //a[@title='Go to the next page'][not(contains(@class,'disabled'))]";
	public static final String preferences_dataCataWebtableBack = "Webtable back button click ,xpath,//div[text()='Back']";

	// frequencyCap

	public static final String preferences_commSettings_frequencycapsettings = "frequencycap settings click,xpath,//div[@class='fullWhiteBackground']//span[contains(.,'Frequency cap')]";
	public static final String preferences_commSettings_frequencycapaddicon = "frequencycap Add icon click ,xpath,//i[@id='rs_data_circle_plus_fill_edge']";
	public static final String preferences_commSettings_frequencycaprulename = "frequencycap rule name value,id,ruleName";
	public static final String preferences_commSettings_frequencycapaudiencegroup = "frequencycap audiencegroup value,xpath,//div[@id='rs_FrequencyCreate_audiencegroup']//span[@class='k-input-inner']";
	public static final String preferences_commSettings_frequencycapaudiencegrupList = "frequencycap audiencegroup list,xpath,//div[@class='k-popup k-list-container k-child-animation-container']//ul//li";
	public static final String preferences_commSettings_frequencycap_audiencegrouptype = "frequencycap audiencgroup type click,id,rs_FrequencyCreate_personaName";
	public static final String preferences_commSettings_frequencycap_audiencegroupList = "frequencycap audiencgroup List click ,xpath,//div[@class='k-list-content']//li";
	public static final String preferences_commSettings_frequencycap_selectType = "frequencycap select type click ,id,rs_FrequencyCreate_ruletype";
	public static final String preferences_commSettings_frequencycap_selectTypelist = "frequencycap select type List ,xpath,//div[@class='k-list-content']//li";
	public static final String preferences_commSettings_frequencycap_commType = "frequencycap comm type  click ,id,rs_FrequencyCreate_communicationtype";
	public static final String preferences_commSettings_frequencycap_commTypeList = "frequencycap comm type List  ,xpath,//div[@class='k-list-content']//li";
	public static final String preferences_commSettings_frequencycap_priorityclick = "frequencycap priority click,id,rs_FrequencyCreate_priority";
	public static final String preferences_commSettings_frequencycap_prioritylist = "frequencycap priority list,xpath,//div[@class='k-list k-list-md']//li";
	public static final String preferences_commSettings_frequencycap_selectlimitClick = "frequencycap select Limit click,id,rs_FrequencyCreate_limit";
	public static final String preferences_commSettings_frequencycap_selectlimitList = "frequencycap select Limit click,xpath,//div[@class='k-list-content']//li";
	public static final String preferences_commSettings_frequencycap_selecttimeinterval = "frequencycap select time interval click,id,rs_FrequencyCreate_timeintreval";
	public static final String preferences_commSettings_frequencycap_selecttimeintervalList = "frequencycap select time interval list,xpath,//div[@class='k-list k-list-md']//li";
	public static final String preferences_commSettings_frequencycap_freqRule = "frequencycap content check,xpath,//div[@class='col']//small[.='The rule will be applicable only for bulk and promotional communication.']";
	public static final String preferences_commSettings_frequencycap_freqratioButton = "frequencycap ration button,xpath,//input[@id='isTransaction']";
	public static final String preferences_commSettings_frequencycap_Savebuttonclick = "frequencycap Save button click,id,rs_FrequencyCreate_Submit";
	public static final String preferences_commSettings_frequencycap_editCancelButton = "frequencycap cancel button click,id,rs_FrequencyCreate_Cancel";
	public static final String preferences_commSettings_frequencycap_deletepopupOK = "frequencycap delete popup OK click,xpath,//div[@class='rsmdc-footer w-100 modal-footer']//button[.='OK']";
//accountsetings
	public static final String preferences_accountsettings_click = "Account settings click,xpath,//i[@class='icon-rs-settings-xlarge font-xl']/..//span[contains(.,'Account settings')]";
	public static final String preferences_accountsettings_BUheaderCheck = "Account settings business unit header check,xpath,//h3[@class='mt20 mb20'][.='Business unit(s)']";
	public static final String preferences_accountsettings_BUAddIcon = "Account settings business unit add icon,xpath,//i[contains(@class,'icon-rs-circle-plus')]";
	public static final String preferences_accountsettings_BUDeptSelect = "Account settings business unit department select,xpath,//div[@class='valid_error_depart col-md-3']";
	public static final String preferences_accountsettings_BUDeptEnter = "Account settings business unit department Enter,xpath,(//div[@class='bu_Container form-group mt40 mb0']//div[@class='valid_error_depart col-md-3'])[PLACE_HOLDER]//input";

	public static final String preferences_accountsettings_UpdateButton = "Account settings business unit update button,id,rs_CompanyInfo_update";


	public static final String preferences_accountsettings_MainheaderCheck = "Account settings Main header check,xpath,//div//h1[.='Edit company account']";
	public static final String preferences_accountsettings_nextButton = "Account settings Main header check,id,rs_CompanyInfo_Next";
	public static final String preferences_accountsettings_addressInput = "Account settings address input check,id,rs_CompanyInfo_companyAddress";
	public static final String preferences_accountsettings_ComapnyInfo = "Account settings address input check,xpath,//input[@id='rs_CompanyInfo_companyAddress']";
	public static final String preferences_accountsettings_Allvalues = "Account settings address all value,xpath,//span[@role='combobox']";
	public static final String preferences_accountsettings_Newuser = "Account settings address new user,xpath,(//div[contains(@class,'box-design assign-role')]//ul//li)[1]";


	public static final String preferences_accountsettings_PopupClick = "Account settings Popup click,xpath,//button[@class='rs-button  rs-button-primary'][.='OK']";
	public static final String preferences_accountsettings_AddbuttonClick = "Account settings add button click,id,rs_data_circle_plus_fill_edge";
	public static final String preferences_accountsettings_ProceedClick = "Account settings proceed click,xpath,//button[@type='submit'][.='Proceed']";
	public static final String preferences_accountsettings_RightArrow = "Account settings right arrow,xpath,//div[@class='rs-select-arrow-icon-right cp ']";
	public static final String preferences_accountsettings_UserdropdwnClick = "Account settings user dropdwn click,xpath,//span[@class='k-floating-label-container k-empty']";

	public static final String preferences_accountsettings_Userdropdwn = "User dropdown,xpath,//ul[@role='listbox']//li";
	public static final String preferences_accountsettings_DisableField= "Account settings user disable field,xpath,((//div[contains(@class,'rs-tags-wrapper')]//ul[@class='click-off'])//..//..//..//h4)|((//div[contains(@class,'rs-tags-wrapper')]//ul[@class='click-off'])//..//..//..//h6)|(((//span[@class='k-floating-label-container k-text-disabled'])//..//label))|((//span[@class='k-floating-label-container k-text-disabled'])//..//span[contains(@class,'k-label')])|((//div[contains(@class,'rs-input-placeholder-wrapper')]//input[@disabled])//..//label))";
	public static final String preferences_accountsettings_Datedrop= "Account settings user date drop click,xpath,(//span[@class='k-input-value-text'])[2]";
	public static final String preferences_accountsettings_Hours= "Account settings user hours click,xpath,(//span[@class='k-input-value-text'])[4]";
	public static final String preferences_accountsettings_Reachcount= "Account settings user reach count,xpath,//div[@id='rs_LocalizationSettings_Reach']//span[.='Reach %']//..//div";
	public static final String preferences_accountsettings_Engagementcount= "Account settings user engagement count,xpath,//div[@id='rs_LocalizationSettings_Engagement']//span[.='Engagement %']/..//div";
	public static final String preferences_accountsettings_Conversioncount= "Account settings user reach count,xpath,//div[@id='rs_LocalizationSettings_Reach']//span[.='Reach %']//..//div";
	public static final String preferences_accountsettings_Localizationcount= "Account settings user localization count,xpath,//div[@id='rs_LocalizationSettings_waves']";
	public static final String preferences_accountsettings_Password= "Account settings user password,xpath,//input[@name='password']";
	public static final String preferences_accountsettings_Generate= "generate password,id,rs_AddUser_password";

	public static final String preferences_accountsettings_UserNameText= "new user,xpath,(//div[contains(@class,'box-design assign-role')]//ul//li)[1]";










//Email Footer
	public static final String preferences_commSettings_emailFooterClick = "Email footer click,xpath,//div[@class='tabs-content ']//ul//li//span[.='Email footer']";
	public static final String preferences_commSettings_emailFooterAddClick = "Email footer add button click,id,rs_data_circle_plus_fill_edge";
	public static final String preferences_commSettings_emailFootercolorBucket = "Email footer colour bucket click,xpath,//i[@icon-title='Background color']";
	public static final String preferences_commSettings_emailFootercolorHexInput = "Email footer Hex colour input,xpath,//div[@class='sketch-picker d-inline-block']//label[.='hex']//..//input";
	public static final String preferences_commSettings_emailFootercolorHexApply = "Email footer Hex colour apply,xpath,//div[@class='rscw-bottom buttons-holder']//button[.='Apply']";
	public static final String preferences_commSettings_emailFooterContent = "Email footer content,id,contentRigntID";

	public static final String preferences_commSettings_emailFootercontent1 = "Email footer content1,xpath,//td[@id='contentRigntID']//p";
	public static final String preferences_commSettings_emailFootercontent2 = "Email footer content2,xpath,//div[@id='contentCard3contentText']//p";
	public static final String preferences_commSettings_emailFooterUrlSaveButton = "Email footer save button,xpath,//button[@type='button'][.='Save']";
	public static final String preferences_commSettings_emailFooterSaveButton = "Email footer save button,xpath,//button[.='Save']";

	public static final String preferences_commSettings_emailFooterUpdateButton = "Email footer update button,xpath,//button[.='Update']";
	public static final String preferences_commSettings_emailFooterPreviewButton = "Email footer preview button,xpath,//button[.='Preview']";
	public static final String preferences_commSettings_emailFooterPreviewclose = "Email footer preview close button,id,rs_circle_close_edge";
	public static final String preferences_commSettings_emailFooterPopupHeader = "Email footer popup Header,xpath,//div[contains(@class,'modal-header')]//h2[.='Save footer']";
	public static final String preferences_commSettings_emailFooterPopupValue = "Email footer popup value enter,id,footerName";
	public static final String preferences_commSettings_emailFooterPopupSave = "Email footer popup Save,xpath,//button[@type='button'][.='Save']";
	public static final String preferences_commSettings_emailFooterImageClick = "Email footer image click,xpath,(//td[@class='contentRightImg']//p//img)[1]";
	public static final String preferences_commSettings_emailFooterImageUrl = "Email footer image url,xpath,//button[@title='Insert image']";
	public static final String preferences_commSettings_emailFooterImage = "Email footer Image url enter,xpath,//input[@id='k-editor-image-url']";
	public static final String preferences_commSettings_emailFooterInsert = "Email footer Image insert,xpath,//span[@class='k-button-text'][.='Insert']";
	public static final String preferences_commSettings_emailFooterInstagram = "Email footer Image instagram,xpath,//img[@id='Instagram']//parent::a//parent::div";
	public static final String preferences_commSettings_emailFooterInstagramUrl = "Email footer Image instagram url,xpath,//input[@name='socialIcons.0.link']";
	public static final String preferences_commSettings_emailFooterTwitterUrl = "Email footer Image twitter url,xpath,//input[@name='socialIcons.1.link']";
	public static final String preferences_commSettings_emailFooteFacebookUrl = "Email footer Image facebook url,xpath,//input[@name='socialIcons.2.link']";
	public static final String preferences_commSettings_emailFooterYoutubeUrl = "Email footer Image youtube url,xpath,//input[@name='socialIcons.3.link']";

//unsub
	public static final String preferences_commSettings_UnsubTitle = "Unsub title input,id,rs_SubscriptionCreate_title";
	public static final String preferences_commSettings_UnsubSubmoduleClick = "Unsub submodule click,xpath,//div//ul[@class=' rs-sub-tabs rs-cc-sub-tabs  ']//span[.='Sub / Unsub']";
	public static final String preferences_commSettings_UnsubSelect = "Unsub select,xpath,//div//ul[@class='rs-tabs row mb0 mini  ']//span[.='Unsub']";
	public static final String preferences_commSettings_UnsubAddIcon = "Unsub add icon click,id,rs_data_circle_plus_fill_edge";
	public static final String preferences_commSettings_UnsubAdvancedsttngstoggle = "Unsub advanced setings toggle button,xpath,//span[@class='k-switch-track k-rounded-full']";
	public static final String preferences_commSettings_UnsubCommtype = "Unsub communication type click,xpath,//label[.='Communication type']/..//div[contains(@class,'k-input-values k-chip-list')]";
	public static final String preferences_commSettings_UnsubProducttype = "Unsub product type click,xpath,//label[.='Product type']/..//div[contains(@class,'k-input-values k-chip-list')]";
	public static final String preferences_commSettings_UnsubChanneltype = "Unsub channel type click,xpath,//label[.='Channel type']/..//div[contains(@class,'k-input-values k-chip-list')]";

	public static final String preferences_commSettings_UnsubFarewellMail = "Unsub farewell mail check,xpath,//div[@class='col-sm-2 offset-sm-0']//label[.='Farewell mail']";
	public static final String preferences_commSettings_UnsubFarewellMailClick = "Unsub farewell mail click,xpath,//div//i[@class='icon-md color-primary-blue  icon-rs-email-preview-medium']";
	public static final String preferences_commSettings_UnsubFarewellSubjectline = "Unsub farewell subjectline click,id,rs_MailContent_subjectline";
	public static final String preferences_commSettings_UnsubIframe = "Unsub farewell iframe,xpath,//div[@class='modal-content rsmd-content']//iframe";
	public static final String preferences_commSettings_UnsubIframeEnter = "Unsub farewell iframe enter,xpath,//div[@class='k-content ProseMirror']//p";
	public static final String preferences_commSettings_UnsubIframeEntervalue = "Unsub farewell iframe enter value,xpath,//div[@id='rs_SubscriptionCreate_Entermessage']//iframe";
	public static final String preferences_commSettings_UnsubIframeBody = "Unsub farewell iframe body,xpath,//div[@id='gjs-wrapper-body']//p";
	public static final String preferences_commSettings_UnsubIframeImage = "Unsub farewell iframe image,xpath,//img[@data-gjs-type='image']";





	
	public static final String preferences_commSettings_UnsubTermsCondition = "Unsub terms and condition click,xpath,//input[@id='termsCondition']";
	public static final String preferences_commSettings_UnsubframeList = "Unsub frame list ,xpath,//div[@class='k-content ProseMirror']";
	public static final String preferences_commSettings_UnsubRedirectionalUrl = "Unsub Redirectional url ,id,rs_SubscriptionCreate_redirectionURL";
	public static final String preferences_commSettings_UnsubFarewellBold = "Unsub farewell bold click ,xpath,//div[@id='rs_MailContent_Emailcontent']//button[@title='Bold']";
	public static final String preferences_commSettings_UnsubFarewellItalic = "Unsub farewell Italic click ,xpath,//div[@id='rs_MailContent_Emailcontent']//button[@title='Italic']";
	public static final String preferences_commSettings_UnsubFarewellUnderline = "Unsub farewell underline click ,xpath,//div[@id='rs_MailContent_Emailcontent']//button[@title='Underline']";
	public static final String preferences_commSettings_UnsubFarewellStrikethrough = "Unsub farewell underline click ,xpath,//div[@id='rs_MailContent_Emailcontent']//button[@title='Strikethrough']";
	public static final String preferences_commSettings_UnsubFarewellSave = "Unsub farewell save click ,id,rs_MailContent_save";
	public static final String preferences_commSettings_UnsubFarewellCancel = "Unsub farewell cancel click,id,rs_SubscriptionCreate_Cancel";
	public static final String preferences_commSettings_UnsubImageURl = "Unsub Image url,xpath,(//i[@class='icon-rs-editor-image-medium icon-md'])[2]";
	public static final String preferences_commSettings_UnsubImageURlSelect = "Unsub Image url select,xpath,//a[.='Image URL']";
	public static final String preferences_commSettings_UnsubImageURlHeader = "Unsub Image url enter,xpath,//h2[.='Image URL']";
	public static final String preferences_commSettings_UnsubImageURlEnter = "Unsub Image url enter,xpath,//input[@name='src']";
	public static final String preferences_commSettings_UnsubImageUrlText = "Unsub popup image url,xpath,//input[@name='altText']";
	public static final String preferences_commSettings_Datacatalogue_datatype = "datacatlogue data type,xpath,//div[@id='rs_NewAttributeModal_dataType']//span//span[contains(@class,'k-input-value-text')]";

	public static final String preferences_commSettings_UnsubSuccesfulMessageBold = "Unsub successfull message bold click ,xpath,//div[@id='rs_SubscriptionCreate_Entermessage']//button[@title='Bold']";
	public static final String preferences_commSettings_UnsubSuccesfulMessageItalic = "Unsub successfull message Italic click ,xpath,//div[@id='rs_SubscriptionCreate_Entermessage']//button[@title='Italic']";
	public static final String preferences_commSettings_UnsubSuccesfulMessageUnderline = "Unsub successfull message underline click ,xpath,//div[@id='rs_SubscriptionCreate_Entermessage']//button[@title='Underline']";
	public static final String preferences_commSettings_UnsubSuccesfulMessageStrikethrough = "Unsub successfull message strikethrough click ,xpath,//div[@id='rs_SubscriptionCreate_Entermessage']//button[@title='Strikethrough']";
	public static final String preferences_commSettings_UnsubSave = "Unsub save click ,id,rs_SubscriptionCreate_Submit";
	public static final String preferences_commSettings_UnsubRemove = "Unsub save click,id,rs_RSImageUpload_circle_minus_fill";

	public static final String preferences_commSettings_UnsubPopupinput = "Unsub popup input field ,id,subscribeName";
	public static final String preferences_commSettings_UnsubPopupHeader = "Unsub popup Header check ,xpath,//h2[.='Unsubscription']";
	public static final String preferences_commSettings_UnsubPopupSave = "Unsub popup save button ,xpath,//button[@type='button'][.='Save']";
	public static final String preferences_commSettings_UnsubImageSave = "Unsub popup image save button,xpath,//button[@type='button'][.='Save']";

	// templateBuilder
	public static final String preferences_templateBuilderClick = "Preferences page header,xpath,//a[@href='/preferences/template-gallery']";
	public static final String preferences_LandingPageClick = "Template builder landing page click ,xpath,//i[@class='icon-rs-landing-page-builder-xlarge icon-xl']";
	public static final String preferences_LandingPageaddicon = "Template builder landing page add icon click ,id,rs_data_circle_plus_fill_edge";
	public static final String preferences_LandingPagePopupHeader = "Template builder landing page popup header check ,xpath,//h2[.='Template name']";
	public static final String preferences_LandingPagePopupName = "Template builder landing page popup name,id,templateName";
	public static final String preferences_LandingPagePopupSave = "Template builder landing page popup save,xpath,//button[.='Save']";
	public static final String preferences_LandingPagePopupFullscreenCancel = "Template builder landing page popup cancel,xpath,//div[@id='LPageSettingModal']/..//button[.='Cancel']";
	public static final String preferences_LandingPagetext = "Template builder landing page text,xpath,//div[@id='rpEbHeader']//div[@title='Text']";
	public static final String preferences_LandingPageBlocks = "Template builder landing page block,id,rpBlocksTop";
	public static final String preferences_LandingPageMainBox = "Template builder landing page main box,xpath,//div[@id='gjs-wrapper-body']";
	public static final String preferences_LandingPageMainFrame = "Template builder landing page main frame,xpath,//iframe[@allowfullscreen='allowfullscreen']";
	public static final String preferences_LandingPageFrameText = "Template builder landing page frame text,xpath,//div[@id='gjs-wrapper-body']//p";
	public static final String preferences_LandingPageImg = "Template builder landing page img click,xpath,//img[@alt='Image']";
	public static final String preferences_LandingPageFrameImg = "Template builder landing page frame img,xpath,//img[@data-gjs-type='image']";
	public static final String preferences_LandingPageFrameImgValue = "Template builder landing page frame value,xpath,//div[contains(@class,'assets-header')]//input";
	public static final String preferences_LandingPageAddimage = "Template builder landing page add image,xpath,//button[@class='gjs-btn-prim'][.='Add image']";
	public static final String preferences_LandingPageAddimageClose = "Template builder landing page add image close,xpath,//div[@class='blue close icon-rs-close-mini']";
	public static final String preferences_LandingPagePublishClick = "Template builder landing page publish click,xpath,//a[@onclick='SaveLandingPageTemplate(2)']";
	public static final String preferences_LandingPageColumn = "Template builder landing page column,xpath,//div[@class='rsg-campaign-name mt-4']//p[.=" + dynamicXpathprefernces + "]";
	public static final String preferences_LandingPagedropdwnSelect = "Template builder landing page dropdown select,xpath,//div[@class='gallery-list']//a";
	public static final String preferences_LandingPageSavebutton = "Template builder landing page save button,xpath,//div[@id='rpEbHeader']//a[@id='btnSaveCanvas']";
	public static final String preferences_LandingPageSavebuttonClick = "Template builder landing page save button click,xpath,//a[@onclick='SaveLandingPageTemplate(1);']";
	public static final String preferences_LandingPageEditicon = "Template builder landing page edit icon,xpath,//a[.='Edit']";
	public static final String preferences_LandingPageCancelbutton = "Template builder landing page cancel button,xpath,//a[@onclick='cancelButton()']";
	public static final String preferences_LandingPageCancelYesbutton = "Template builder landing page cancel yes button,xpath,//button[.='Yes']";

	// PW
	public static final String pw_preferences_FormsClick = "Forms click ,pw,//i[@class='icon-rs-form-generator-xlarge icon-xl']";
	public static final String pw_preferences_AddFormelect = "Add form select ,pw,//i[@id='rs_data_circle_plus_fill_edge']//..//..//a";
	public static final String pw_preferences_AddFormAdd = "Add icon click,pw,//i[@id='rs_data_circle_plus_fill_edge']";
	public static final String pw_preferences_Forms_Selecttype = "Forms select type,pw,//ul[contains(@class,'rs-content-tabs')]//li";
	public static final String pw_preferences_Forms_carouselBoxSelect = "Carousel Box,pw,xpath=//h6[text()='PLACE_HOLDER']//parent::div//i";
	public static final String pw_preferences_templateBuilderClick = "Template builder click ,pw,//li[@id='rs_PREFRENCE_LISTS_TemplateBuilder']";
	public static final String pw_preferences_EmailMobile = "Email/Mobile header,pw,//h4[.='Email/Mobile']";
	public static final String pw_preferences_Salutation = "salutation checkbox click,pw,//input[@id='Salutation']";
	public static final String pw_preferences_TellaFriend= "tell a friend,pw,//li[contains(@class,'tabDefault')]//span[.='Tell a friend']";
	public static final String pw_preferences_Survey= "survey click,pw,//li[contains(@class,'tabDefault')]//span[.='Survey']";
	public static final String pw_preferences_Subscription= "subscription,pw,//li[contains(@class,'tabDefault')]//span[.='Subscription/KYC']";
	public static final String pw_preferences_Save= "save button,pw,//button[.='Save']";
	public static final String pw_preferences_Formtext= "form text enter,pw,//p[.='Mobile']//ancestor::div[@class='rsbecw-row s']//span[@class='k-input-value-text']";
	public static final String pw_preferences_FormClose= "close form,pw,//i[@id='rs_icon']";
	public static final String pw_preferences_FormTextEnter= "form text enter,pw,//span[contains(@class,'k-searchbox k-input k-input-md k-rounded-md k-input-solid')]//input";
	public static final String pw_preferences_Formselect= "form select,pw,//p[.='Gender']//ancestor::div[@class='rsbecw-row s']//span[@class='k-input-value-text']";
	public static final String pw_preferences_Formselect2= "form select,pw,(//p[.='City']//ancestor::div[@class='rsbecw-row s']//span[@class='k-input-value-text'])[2]";
	public static final String pw_preferences_FormTextcountry= "form text country,pw,//i[@icon-title='Form background color']";











	public static final String pw_preferences_Fullname = "Fullname checkbox click,pw,//input[@id='Fullname']";
	public static final String pw_preferences_Mobile = "Mobile checkbox click,pw,//input[@id='Mobile']";
	public static final String pw_preferences_SelectFormsRefresh = "Select forms refresh click,pw,//i[@id='rs_data_refresh']";
	public static final String pw_preferences_SelectFormsRefreshOK = "Select forms refresh OK click,pw,//button[.='OK']";
	public static final String pw_preferences_CarosuelRightarrow = "Carosuel right arrow click,pw,//span[@class='carousel-control-next-icon']";
	public static final String pw_preferences_Carosuelleftarrow = "Carosuel left arrow click,pw,//span[@class='carousel-control-prev-icon']";
	public static final String pw_preferences_SurveySubMobileno = "Survey subscription mobileno click,pw,//div[@class=' react-tel-input ']//input";
	public static final String pw_preferences_GenderField = "gender field select,pw,(//div[@class='rsfph-map'])[2]";
	public static final String pw_preferences_CityField = "City field select,pw,(//div[@class='rsfph-map'])[3]";

	public static final String pw_preferences_CommonFieldSelect = "Common field select,pw,//div[@class='k-list k-list-md']//li";
	public static final String pw_preferences_CommonAgreeCheckbox = "Survey agree check box,pw,//input[@id='AgreeCheckbox']";
	public static final String pw_preferences_progressiveProfile = "Progressive profile settings click,pw,//div[@class='text-right col-sm-6']//i[contains(@class,'icon-rs-s')]";
	public static final String pw_preferences_progressiveProfileToggle = "Progressive profile settings toggle button,pw,//span[@class='k-switch-track k-rounded-full']";
	public static final String pw_preferences_progressiveProfileHeader = "Progressive profile settings header,pw,//div[@class='rsmdc-header false false  modal-header']//h2";
	public static final String pw_preferences_progressiveProfileValue = "Progressive profile settings value,pw,//input[@name='settingsInputField']";
	public static final String pw_preferences_progressiveProfileSave = "Progressive profile settings save,pw,//button[.='Save']";
	public static final String pw_preferences_saveGenerate = "Save and generate button,pw,//button[.='Save & Generate form']";
	public static final String pw_preferences_saveCloseButton = "Save and close button,pw,//i[@id='rs_circle_close_edge']";
	public static final String preferences_FormCsvClick = "form csv click button,xpath,(//i[@id='rs_FormGenerator_CSV'])[2]";
	public static final String preferences_FormCsvOk = "form csv Ok button,xpath,//button[.='Ok']";
	public static final String preferences_FormCsvDownload = "form csv download,xpath,//h2[.='Download CSV']";
	public static final String preferences_FormCsvMailDrpdwn = "form csv mail dropdwn,xpath,//span[contains(@class,'k-picker rs-kendo-dropdown rs-kendo')]";




	public static final String pw_preferences_Forms_formDuplicate = ",pw,(//span[@class='m0'])[1]";
	public static final String pw_preferences_HexColorApply = "Hex color validation apply,pw,//button[.='Apply']";
	public static final String pw_preferences_Forms_OK = "Validation OK button,pw,//button[.='OK']";
	public static final String pw_preferences_Forms_Cancel = "Validation Cancel button,pw,//button[.='Cancel']";
	public static final String pw_preferences_Forms_SettingsIcon3 = "settigs icon click,pw,(//i[@class='icon-rs-settings-medium icon-md icon-md color-primary-blue'])[3]";
	public static final String pw_preferences_Forms_SettingsMobile = "settings icon click,pw,//p[.='Mobile']";
	public static final String pw_preferences_Forms_DuplicateName = "duplicate name,pw,//input[@id='formName']";

	public static final String pw_preferences_Forms_MandatoryField = "Mandotary field click,pw,//i[@name='formGenerator[3].mandatory']";
	public static final String pw_preferences_Forms_SettingsIcon5 = "settigs icon click,pw,(//i[@class='icon-rs-settings-medium icon-md icon-md color-primary-blue'])[5]";
	public static final String pw_preferences_Forms_OptionMinus = "Minus button click,pw,//i[@class='icon-rs-circle-minus-fill-mini color-primary-red']";
	public static final String pw_preferences_Forms_Valueenter = "value enter placeholder,pw,//input[@placeholder='Enter keywords']";
	public static final String pw_preferences_Forms_saveGenerate = "save & generate click,pw,//button[.='Save & Generate form']";

//PLAYWRIGHT REPOSITORY

	// PREFERENECE MODULE

	public static final String pw_preferences_preferencesModuleclick = "Preferences page header,pw,//a[@href='/preferences']";

	//

	public static final String pw_preferences_Offer_Click = "Offer management click,pw,//li[@id='rs_PREFRENCE_LISTS_Offermanagement']";
	public static final String pw_preferences_Offer_Tooltip = "Offer management tooltip,pw,//span//..//../div[.='Create static and dynamic offers']";
	public static final String pw_preferences_Offer_Add = "Offer management name,pw,//i[@id='rs_data_circle_plus_fill_edge']";
	public static final String pw_preferences_Offer_Header = "Offer management header,pw,//h1[.='Add offer']";
	public static final String pw_preferences_Offer_Name = "Offer management name,pw,//input[@id='offerName']";
	public static final String pw_preferences_Offer_Type = "Offer management name,pw,//div[@id='rs_CreateOffer_offerType']";
	public static final String pw_preferences_Offer_StartDate = "Offer management start date,pw,//div[@id='rs_CreateOffer_newdate']";
	public static final String pw_preferences_Offer_EndDate = "Offer management end date,pw,//div[@id='rs_CreateOffer_Enddate']";
	public static final String pw_Preferences_calendaryear_click = "preferences offer management calendar year,pw,//div[contains(@class,'k-calendar-header')]//span[@class='k-button-text']";
	public static final String pw_preferences_calenderstartdatetable = "preferences startdate table,pw,//table[@class='k-calendar-table']//tbody[1]//tr[position()>1]";
	public static final String pw_preferences_calenderyearslist = "Preferences year list,pw,//ul[@class='k-reset']//li";
	public static final String pw_preferences_RefreshClick = "Offer management refresh click,pw,//i[@class='icon-rs-refresh-medium icon-xs color-primary-blue']";
	public static final String pw_preferences_CommonRadioButton = "Offer management common radio button,pw,//input[@id='rs_CreateOffer_common']";
	public static final String pw_preferences_CommonUniqueButton = "Offer management unique radio button,pw,//input[@id='rs_CreateOffer_unique']";
	public static final String pw_preferences_CommType = "Offer management communication type click,pw,//div[@id='rs_CreateOffer_communicationType']";
	public static final String pw_preferences_ProductType = "Offer management product type click,pw,//div[@id='rs_CreateOffer_productType']";
	public static final String pw_preferences_Volumevalue = "Offer management volume value enter,pw,//input[@id='rs_CreateOffer_volume']";
	public static final String pw_preferences_OffercodeVolume = "Offer management volume value enter,pw,//input[@id='rs_CreateOffer_volume']";
	public static final String pw_preferences_OffercodeLength = "Offer management offercode length,pw,//input[@id='rs_CreateOffer_length']";
	public static final String pw_preferences_OffercodeType = "Offer management offercode length,pw,//input[@name='offerCodeType'][@value='PLACE_HOLDER']";
	public static final String pw_preferences_Comm_Offercode = "Offer management offercode,pw,//input[@id='rs_CreateOffer_offercode']";
	public static final String pw_preferences_Unique_Offercode = "Offer management offercode,pw,//div[@id='rs_CreateOffer_addOffercode']";
	public static final String pw_preferences_OffercodeSave = "Offer management offercode save,pw,//button[@id='rs_CreateOffer_Save']";
	public static final String pw_preferences_OffercodeSettings = "Offer management offercode settings,pw,//i[@class='icon-rs-settings-medium icon-md color-primary-blue']";
	public static final String pw_preferences_OffercodeCompose = "Offer management offercode compose area,pw,//textarea[@id='composeUsing']";
	public static final String pw_preferences_OffercodePattern = "Offer management offercode pattern value,pw,//input[@id='rs_CreateOffer_codePattern']";
	public static final String pw_preferences_OffercodeDisplayAs = "Offer management offercode display as,pw,//label[.='Display as']";
	public static final String pw_preferences_OffercodeRadioTextbtn = "Offer management radio text button,pw,//input[@id='rs_CreateOffer_text']";
	public static final String pw_preferences_Offercodeimprtdesc = "Offer management import description,pw,//input[@id='rs_CreateOffer_importDescription']";
	public static final String pw_preferences_OffercodeChooseFile = "Offer management choose file,pw,//input[@id='rs_CreateOffer_importFile']";
	public static final String pw_preferences_OffercodeBrowseFile = "Offer management browse file,pw,//button[@id='rs_RSFileUpload_primary']";
	public static final String pw_preferences_OffercodeGenerateCSV = "Offer management generate csv,pw,//button[.='Generate CSV']";
	public static final String pw_preferences_OffercodeDownloadCSV = "Offer management download CSV,pw,//i[@id='rs_data_download']";
	public static final String pw_preferences_Offercode_UniqueRadio = "Offer management unique radio button,pw,//input[@value='Unique']";

//SELENIUM

	// DataexchangeWebhook
	public static final String preferences_Dataexchange = "Preferences dataexchange submodule click,id,rs_PREFRENCE_LISTS_DataExchange";
	public static final String preferences_Dataexchange_Header = "Preferences dataexchange header check,xpath,//h1[.='Data exchange']";
	public static final String preferences_Dataexchange_ExtendedSystem = "Preferences dataexchange extended system click,xpath,//div[contains(@class,'dataExchangePage')]//span[.='Extended system']";
	public static final String preferences_Dataexchange_ExtendedSystem_WebhookAdd = "Preferences dataexchange extended webhook add,xpath,//i[contains(@class,'webhook')]//..//i[@id='rs_data_circle_plus_fill_edge']";
	public static final String preferences_Dataexchange_Webhook_Name = "Preferences dataexchange webhook name,xpath,//input[@name='webHookName']";
	public static final String preferences_Dataexchange_Webhook_Url = "Preferences dataexchange webhook url,xpath,//input[@name='webHookURL']";
	public static final String preferences_Dataexchange_Webhook_SecretKey = "Preferences dataexchange webhook secret key,xpath,//input[@name='secretKey']";
	public static final String preferences_Dataexchange_Webhook_Error = "Webhook name err msg,xpath,//span[@id='errmsgUrl']";
	public static final String preferences_Dataexchange_Webhook_Edit = "Edit icon,xpath,(//li[not(contains(@class,'d-none'))]//i[@id='rs_data_pencil_edit'])[2]";
	

	public static final String preferences_Dataexchange_Webhook_SecretKey_Eye = "Preferences dataexchange webhook secret key eye icon,xpath,//i[@class='icon-md cursor-pointer color-primary-grey icon-rs-eye-hide-medium ']";
	public static final String preferences_Dataexchange_Webhook_NameValidation = "Preferences dataexchange webhook name validation,xpath,//input/..//label[contains(.,'Enter instance/friendly name')]";
	public static final String preferences_Dataexchange_Webhook_NameValue = "Preferences dataexchange webhook name value enter,xpath,//input[@name='webHookName']";

	public static final String preferences_Dataexchange_Webhook_UrlEnter = "Preferences dataexchange webhook url enter,xpath,//input[@name='webHookURL']";
	public static final String preferences_Dataexchange_Webhook_UrlValidation = "Preferences dataexchange webhook url validation,xpath,//input/..//label[contains(.,'Enter URL')]";
	public static final String preferences_Dataexchange_Webhook_Description = "Preferences dataexchange webhook description value,xpath,//textarea[@name='description']";
	public static final String preferences_Dataexchange_Webhook_SaveButton = "Preferences dataexchange webhook save button,id,rs_ConnectFields_save";

	// Consumptions EMAIL
	public static final String preferences_Consumptions_Allchannels = "Consumption all channel,xpath,//span[contains(@class,'d-flex align-items')]//h4";
	public static final String preferences_Consumptions_AllchannelsCount = "Consumption all channel count,xpath,//div[@class='rs-tooltip-wrapper lh0']//h2";

	public static final String preferences_Consumptions_Email_csvDownload = "Consumptions csv download,xpath,//i[@class='icon-rs-csv-download-large icon-lg color-primary-blue']";
	public static final String preferences_consumption_Email_gridHeader = "Headers,xpath,//*[@class='k-grid-header']//th";
	public static final String preferences_consumption_Email_gridRows = "Rows,xpath,//div[@class='k-grid-container']//tr";
	public static final String preferences_listing_pagination = "Next page button,xpath,//a[@title='Go to the next page' and not (contains(@class,'disabled'))]";

	// Consumptions SMS
	public static final String preferences_Consumptions_click = "Consumptions click,id,rs_PREFRENCE_LISTS_Consumptions";
	public static final String preferences_ConsumptionsHeader = "Consumptions header check,xpath,//div[@class='heading-title-text']";
	public static final String preferences_ConsumptionsYear = "Consumptions year click,xpath,(//div[@class='rs-bootstrap-dropdown  '])[5]";
	public static final String preferences_ConsumptionsMonth = "Consumptions month click,xpath,(//div[@class='rs-bootstrap-dropdown  '])[4]";
	public static final String preferences_ConsumptionMonthDropdownValue = "Month Dropdown,xpath,//div[contains(@class,'dropdown-menu show')]//a";
	public static final String preferences_ConsumptionsMonthSelectlist = "Consumptions month select list,xpath,//div[@class='dropdown-menu show dropdown-menu-end']//a";

	// pw
	public static final String pw_preferences_templeteBuilder = "templete generator,pw,i[class*='template-generator']";
	public static final String preferences_Consumptions_Sms_CommHeadername = "Consumptions sms comm header name,xpath,//span[@class='k-column-title'][.='Communication name']";
	public static final String preferences_Consumptions_Sms_CommCsvDownload = "Consumptions comm csv download,xpath,//i[@class='icon-rs-csv-download-large icon-lg color-primary-blue']";
	public static final String preferences_Consumptions_Sms_CommDeliveryCount = "Consumptions comm delivery count,xpath,//span[@class='k-column-title'][.='Delivered']";
	public static final String preferences_Consumptions_Sms_CommDeliveryCounts = "Consumptions comm delivery count text,xpath,(//div[@class='k-grid-content k-virtual-content']//td)[18]";
	public static final String preferences_Consumptions_Sms_CommDeliveryCountText = "Consumptions comm delivery count text,xpath,(//div[@class='k-grid-content k-virtual-content']//td)[14]";
	public static final String preferences_Consumptions_Sms_CommCountText = "Consumptions comm count text,xpath,(//div[@class='k-grid-content k-virtual-content']//td)[2]";
	public static final String preferences_Analytics_Sms_Deliverycount = "Consumptions analytics delivery count text,xpath,(//div[@class='col-md-4']//ul//li//h3)[2]";

	// AUDIENCESCORE
	public static final String preferences_Audiencescore_click = "Audiencescore click,id,rs_PREFRENCE_LISTS_AudienceScore";
	public static final String preferences_Audiencescore_Close_icon = "Audiencescore close icon,id,rs_circle_close_edge";
	public static final String preferences_Audiencescore_CommonAdd = "Audiencescore add persona,id,rs_data_circle_plus_fill_edge";
	public static final String preferences_Audiencescore_Header = "Audiencescore add persona,xpath,//h2[.='Define persona']";
	public static final String preferences_Addpersonasearchicon = "Persona search icon,id,rs_data_zoom";
	public static final String preferences_AddpersonasearchInput = "Persona search input,xpath,//input[@name='search']";
	public static final String preferences_AddpersonaAttribute = "Persona search attributes,xpath,//div[@class='accordionBlock']//ul//li";
	public static final String preferences_AddpersonaValueInput = "Persona value enter,id,rs_RenderInputs_onlynumber";
	public static final String preferences_AddpersonaCreate = "Persona create button ,xpath,//button[.='Create']";
	public static final String preferences_AddpersonaSave = "Persona save button,xpath,//button[@type='submit'][.='Save']";

	public static final String preferences_AddpersonaPopupHeader = "Persona popup header ,xpath,//h2[.='Persona']";
	public static final String preferences_AddpersonaPopupInput = "Persona popup input,id,personaName";
	public static final String preferences_AddpersonaPopupInputSave = "Persona popup input save,xpath,//div[contains(@class,'rsmdc-footer')]//button[.='Save']";
	public static final String preferences_PersonaHeader = "Persona header,xpath,//h4[.='Persona']";

	// goals and benchmark
	public static final String preferences_commSettings_GoalsandBenchmark = "Goals and benchmark click,xpath,//div[@class='row']//span[.='Goals & benchmark']";
	public static final String preferences_commSettings_GoalsandBenchmark_Adds = "Goals and benchmark add,xpath,//div[@class='row']//span[.='Goals & benchmark']";
	public static final String preferences_commSettings_GoalsandBenchmark_commgoals = "Goals and benchmark comm goals,id,rs_ChannelBenchmark_communicationtarget";
	public static final String preferences_goals_communicationtype = "Communication type click,id,rs_ChannelBenchmark_communicationType";
	public static final String preferences_goals_communicationtypeAdd = "Communication type add icon,xpath,//i[@id='rs_icon']";
	public static final String preferences_goals_communicationtypeAddSave = "Communication type add save icon,xpath,//i[contains(@class,'icon-rs-save-mini')]";
	public static final String preferences_goals_communicationtypeAddEnter = "Communication type add enter value,xpath,//input[@name='campaignName']";

	public static final String preferences_goals_enterbenchmark = " name input,xpath,//input[@id='name']";
	public static final String preferences_goals_DescriptionEnter = "Description value input,xpath,//textarea[@id='description']";
	public static final String preferences_goals_enterbenchmarkpercentage = "Benchmark percentage,xpath,//span[.='" + dynamicXpathprefernces + "']//parent::li";
	public static final String preferences_goals_enterbenchmarkEstimatedALl = "Benchmark percentage estimated all,xpath,//div[contains(@class,'placeholder-wrapper')]//input[not(contains(@class,'  emojifont required'))]";

	public static final String preferences_goalbenchmark_nextButton = "Goalsbenchmark next button,id,rs_RenderBenchmark_next";
	public static final String preferences_goalbenchmark_backButton = "Goalsbenchmark back button,xpath,//div[@class='header-back']";
	public static final String preferences_goals_Disablefield = "disable field,xpath,//span[contains(@class,'k-text-disabled')]//span[contains(@class,'k-disabled')]//..//span[contains(@class,'k-text-disabled')]";

	// NEGATIVE SCENARIOS
	public static final String allmenu_pref_dataCatalogue = "DataCatalogue click button ,xpath, //a[contains(.,'Data catalogue')]";
	public static final String preferences_GoalsBenchmark_Reachrate = "Benchmark reach rate value,id,rs_RenderBenchmark_reach";
	public static final String preferences_GoalsBenchmark_Engagementrate = "Benchmark engagement rate value,id,rs_RenderBenchmark_engagement";
	public static final String preferences_GoalsBenchmark_Conversionrate = "Benchmark conversion rate value,id,rs_RenderBenchmark_conversion";

	//
	public static final String preferences_Frequency_Cancelbutton = "Benchmark cancel button,id,rs_FrequencyCreate_Cancel";
	public static final String preferences_Frequency_Content = "Benchmark content,xpath,//div[@class='col']//small";
//
	public static final String preferences_Smtp_Save = "smtp save button,id,rs_Edit_Submit";
	public static final String preferences_Smtp_Username = "smtp user name,id,rs_Edit_smtUser";
	public static final String preferences_Smtp_password = "smtp password name,id,rs_Edit_smtPassword";
	public static final String preferences_Smtp_portNumber = "smtp port number,id,rs_Edit_smtPort";
	public static final String preferences_Smtp_radiobutton = "smtp radio button,xpath,//input[@id='transactionCommunication']";
	public static final String preferences_Smtp_serverUsername = "smtp server user name,xpath,//input[@name='smtpServerSettings.credentials[0].userName']";
	public static final String preferences_Smtp_serverPassname = "smtp server password,xpath,//input[@name='smtpServerSettings.credentials[0].password']";
	public static final String preferences_Smtp_Cancelbutton = "smtp cancel button,id,rs_Edit_Cancel";

	public static final String preferences_Smpp_addicon = "smtp add icon,id,rs_data_circle_plus_fill_edge";
	public static final String preferences_Smpp_Sms_Click = "smtp sms click,xpath,//i[contains(@class,'icon-rs-messaging')]/..";
	public static final String preferences_Smpp_PlusButton = "smtp plus button,xpath,//i[contains(@class,'icon-rs-circle-plus-fill-medium')]";
	public static final String preferences_Smpp_radionbttnValidation = "smtp radio button validation,xpath,//div[@class='validation-message']";
	public static final String preferences_Smpp_userName = "smtp username,id,rs_SMPPCreate_userName";
	public static final String preferences_Smpp_password = "smtp password,id,rs_SMPPCreate_password";
	public static final String preferences_Smpp_Cancel = "smtp cancel button,id,rs_SMPPCreate_Cancel";

	public static final String preferences_Smpp_Whatsapp = "smtp whatsapp click,xpath,//i[contains(@class,'icon-rs-social-whatsapp')]/..";
	public static final String preferences_Smpp_Whatsapp_Save = "smtp whatsapp save button,id,rs_WhatsAppCreate_Update";
	public static final String preferences_Smpp_Whatsapp_Cancel = "smtp whatsapp cancel button,id,rs_WhatsAppCreate_Cancel";

	//
	public static final String preferences_Mobile_Togglebtn = "Mobile toggle button,id,rs_DeviceIntegration_isAppAnalyticsswitch";
	public static final String preferences_Mobile_Radiobtn = "Mobile radio button,xpath,//input[@name='devices[0].notificationProvider']";
//
	public static final String preferences_Offer_Name = "Offer management name,xpath,//input[@id='offerName']";
	public static final String preferences_Offer_Click = "Offer management click,xpath,//li[@id='rs_PREFRENCE_LISTS_Offermanagement']";
	public static final String preferences_OffercodeSave = "Offer management offercode save,xpath,//button[@id='rs_CreateOffer_Save']";
	public static final String preferences_Offer_Add = "Offer management name,xpath,//i[@id='rs_data_circle_plus_fill_edge']";
	public static final String preferences_RefreshClick = "Offer management refresh click,xpath,//i[@class='icon-rs-refresh-medium icon-xs color-primary-blue']";
	public static final String preferences_Volumevalue = "Offer management volume value enter,xpath,//input[@id='rs_CreateOffer_volume']";
	public static final String preferences_Unique_Offercode = "Offer management offercode,xpath,//div[@id='rs_CreateOffer_addOffercode']";
	public static final String preferences_Offer_Cancel = "Offer management save button,id,rs_CreateOffer_Cancel";

	// INVOICES
	public static final String preferences_Invoices = "Preferences Invoices,id,rs_PREFRENCE_LISTS_Invoices";
	public static final String preferences_Invoices_Previewicon = "Preferences Invoices,xpath,(//i[@id='rs_data_eye'])[1]";
	public static final String preferences_Invoices_SubTabheader = "Preferences Invoices subscription tab header,xpath,(//li[@class='tabDefault active    col-sm-6'])";
	public static final String preferences_Invoices_ConsTabheader = "Preferences Invoices consumbales tab header,xpath,//li[@class='tabDefault   click-off  col-sm-6']";
	public static final String preferences_Invoices_Download = "Preferences Invoices download,id,rs_InvoiceView_download";

	// LICENSE INFO
	public static final String preferences_LicenseInfo = "Preferences license info,id,preferences_LicenseInfo";
	public static final String pw_preferences_Forms_RemoveIcon = "remove icon,pw,//i[@class='icon-rs-circle-minus-fill-mini icon-xs color-primary-red']";
	public static final String pw_preferences_OfferCheckBox= "Offer management chcekbox,pw,//input[@type='checkbox']";
	public static final String pw_preferences_InputClick = "Offer management input click,pw,//input[@value='Unique']";
	public static final String pw_preferences_OfferBox= "Offer management checkbox,pw,//div[@class='rs-offer-box width100p rob-text card']";
	public static final String pw_preferences_Forms_formName= "form name,pw,//input[@id='formName']";

}
