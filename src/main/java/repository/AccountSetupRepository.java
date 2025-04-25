package repository;

public class AccountSetupRepository
{

	// ACOUNT SETUP - NEW USER PAGE

	public static final String product_logo = "Resul 5.0 Logo,xpath,//div[contains(@class,'login-resul-logo')]//img";
	public static final String accountsetup_newusertab = "New user tab,xpath,//div//span[.='New user']";
	public static final String accountsetup_enteremail = "Email address,id,emailId";
	public static final String accountsetup_emailValidation = "Email validation green tickmark,xpath,//div[contains(@class,'validate-success-icon')]";
	public static final String accountsetup_captchavalue = "Captcha value,xpath, //div[@class='input-group-prepend']";
	public static final String accountsetup_entercaptchavalue = "captcha value,xpath,//input[@name='answer']";
	public static final String accountsetup_mail_loader = "Email loader,xpath,//div[@class='segment_loader']";
	public static final String accountsetup_mailmsg = "Email id already exist err msg,xpath,//*[@id='emailId']//..//label";
	public static final String accountsetup_captchamsg = "Captha placeHolder,xpath,//input[@name='answer']//..//label";
	public static final String accountsetup_agreetermsselect = "I agree to check box ,xpath,//input[@id='agree']";
	public static final String accountsetup_termsAndcondValidation = "Terms & Condts validation,xpath,//input[@id='agree']/../preceding::div[contains(@class,'validation')]";
	public static final String accountsetup_termsandCondLink = "Terms and Conditions Link,xpath,//input[contains(@id,'agree')]/..//a";
	public static final String accountsetup_clicksignupbutton = "Sign Up,xpath,//button[.='Sign up']";
	public static final String accountsetup_signUpEnabled = "Sign Up,xpath,//button[.='Sign Up'][not(contains(@class,'click-off'))]";
	public static final String accountsetup_selectaccounttype = "Select account type,xpath,//div[@class='heading-title-text']//h1[text()='Select an account type']";
	public static final String accountsetup_agencyaccount = "Agency Logo,xpath,//div[@class='img-holder']//img[contains(@src,'agency')]";
	public static final String accountsetup_brandaccount = "Brand Logo,xpath,//div[@class='img-holder']//img[contains(@src,'brand')]";
	public static final String accountsetup_selectlicensetype = "Select license type,xpath,//div[@class='heading-title-text']//h1[text()='Select license type']";
	public static final String accountsetup_licenseType = "license,xpath,//div[contains(@class,'PLACE_HOLDER')]";
	public static final String accountsetup_license_specs = "license types specs,xpath,//div[contains(@class,'PLACE_HOLDER')]//li";
	public static final String accountsetup_licenseTypes = "License Types,xpath,//div[@class='plan-header']//h1[position()=1]";
	public static final String accountsetup_licensePriceTag = "License Price,xpath,//div[@class='plan-header']//h1[position()=2]";
	public static final String accountsetup_license_pricetag = "Account price,xpath,//div[contains(@class,'PLACE_HOLDER')]//h1[contains(@class,'price-tag')]";
	public static final String accountsetup_dropdown_searchInputBox = "Dropdown Search InputBox,xpath,//div[contains(@class,'k-animation-container-shown')]//input";
	public static final String accountsetup_tooltip = "tooltip,xpath,//div[contains(@class,'tooltip-inner')]";
	public static final String accountsetup_placeHolder = "//div[contains(@class,'errorContainer')]//label";
	public static final String accountsetup_inputBox_tickmark = "green tick-mark,xpath,//i[contains(@class,'icon-rs-tick-mini icon-xs color-primary-green')]";
	public static final String accountsetup_pageheader = "Page Header,tag,h1";

	// ACOUNT SETUP - KEY CONTACT INFO
	public static final String accountsetup_keyContact = "Key Contact details,xpath,//h1[text()='Key contact details']";
	public static final String accountsetup_firstname = "First name,xpath,//input[@name='firstname']";
	public static final String accountsetup_lastname = "Last name,xpath,//input[@name='lastname']";
	public static final String accountsetup_selectTitle = "Select title,xpath,//span[contains(@class,'dropdown-required')][contains(@aria-label,'itle')]";
	public static final String accountsetup_dropdownOptions = "DropdownOption,xpath,//div[@class='k-list-content']//li";
	public static final String accountsetup_jobfunction_click = "Job function header,xpath,//span[contains(@class,'dropdown-required')][contains(@aria-label,'ob function')]";
	public static final String accountsetup_countryCode = "Country Code,xpath,//div[contains(@class,'flag-dropdown')]";
	public static final String accountsetup_countrycodelist = "Country Code list,xpath,//div[contains(@class,'flag-dropdown')]//li";
	public static final String accountsetup_brandinfo_profile = "Upload logo profile,xpath,//div[@class='picture-choose-file']";
	public static final String accountsetup_brandinfo_removeProfile = "Remove profile,xpath,//span[contains(@class,'remove-icon')]";
	public static final String accountsetup_brandinfo_uploadlogo = "Upload logo,xpath,//input[@type='file']";
	public static final String accountsetup_brandinfo_editProfile = "profile pencile,xpath,//input[@type='file']";
	public static final String accountsetup_pswd = "Password,xpath, //input[@name='password'][contains(@class,'required')]";
	public static final String accountsetup_confirmpwsd = "Confirm password,xpath,//input[@name='confirmPassword']";
	public static final String accountsetup_pswdViewIcon = "Password view icon,xpath,//i[contains(@class,'eye-hide')]";
	public static final String accountsetup_ConfirmpswdViewIcon = "Confirm Password view icon,xpath,//input[@name='confirmPassword'][contains(@class,'required')]/..//i";
	public static final String accountsetup_mobileno = "Mobile number,xpath,//input[@type='tel']";
	public static final String accountsetup_keycontactInfo_otpPopup = "OTP popup,xpath,//h2[text()='Confirm mobile number']";
	public static final String accountsetup_keycontactInfo_otp_OKbtn = "OK Button,xpath,//button[text()='Ok']";
	public static final String accountsetup_keycontactInfo_enterOneTimePassword = "Enter One Time Password,xpath,//h2[text()='One-Time Password verification']";

	public static final String accountsetup_brandinfo_otp_confirmBtn = "Confirm button,xpath,//button[@type='button'][text()='Confirm']";
	public static final String accountsetup_validationmessage_textfield = "Validation message,xpath,//div[contains(@class,'errorContainer')]//label";
	public static final String accset_keyCon_passquestionmark = "Password question mark,xpath,//i[contains(@class,' icon-rs-circle-question-mark')]";
	public static final String accset_keyCon_passerrmsg = "First name error message,xpath,//input[@name ='password']/..//label";
	public static final String accset_keyCon_passwordstrength = "Password strength,xpath,//input[@name='password']/..//div[contains(@class,'password-strength')]";
	public static final String accset_keyCon_cnfmpasswordstrength = "Password strength,xpath,//input[@name='confirmPassword']/..//div[contains(@class,'password-strength')]";
	public static final String accset_keyCon_confirmpasserr = "Password strength,xpath,//input[@name='confirmPassword']/..//label";
	public static final String accset_keyCon_defaultflag = "Default flag,xpath,//div[@class='flag in']";
	public static final String accset_keyCon_mobilenumber = "Mobile number,xpath,//div[contains(@class,'rs-phone-input')]//input";
	public static final String accset_keyCon_mobilequesmark = "Mobile no question mark,xpath,//i[@class='icon-rs-circle-question-mark-mini icon-xs']";
	public static final String accset_keyCon_mobilecountrylist = "Country list,xpath,//ul[@role='listbox']//li";
	public static final String accset_keyCon_editbutton = "Edit mobile number,xpath,//button[normalize-space()='Edit']";
	public static final String accset_keyCon_popupconfirm = "Ok button,xpath,//button[normalize-space()='Ok']";
	public static final String accset_keyCon_invalidotp = "Invalid OTP alert,xpath,//div[contains(@class,'alert-danger')][contains(.,'OTP expired')]";

	// ACCOUNT SETUP - AGENCY DETAILS PAGE
	public static final String accountsetup_agencyDetails = "Agency Details,xpath,//h1[text()='Agency details']";
	public static final String accountsetup_agencyDetails_group = "Agency Group,xpath,//input[@name='agencyGroup']";
	public static final String accountsetup_agencyDetails_helpdesk = "Agency Group help desk,xpath,//input[@name='agencyGroup']/../following-sibling::div[@class='form-field-icon']";
	public static final String accountsetup_agencyDetails_address = "Adress,xpath,//input[@name='agencyAddress']";
	public static final String accountsetup_agencyDetails_name = "Agency Name,xpath,//input[@name='agencyName']";
	public static final String accountsetup_agencyDetails_city = "City,xpath,//input[@name='agencyCity']";
	public static final String accountsetup_agencyDetails_zipCode = "Zip code,xpath,//input[@name='agencyZipcode']";
	public static final String accountsetup_agencyDetails_website = "Website URL,xpath,//input[@name='agencyWebsite']";
	public static final String accountsetup_agencyDetails_countryDropdown = "Country drop-down,xpath,//span[contains(@aria-label,'Country')]//button";

	// ACCOUNT SETUP - BRAND INFO
	public static final String accountsetup_Nextbutton = "Next button,xpath,//button[text()='Next'][not (contains(@class,'click-off'))]";
	public static final String accountsetup_brandinfo = "Brand Info details,xpath,//h1[text()='Brand details']";
	public static final String accountsetup_brandinfo_mandatory = "Mandatory fields,xpath,(//div[contains(@class,'border-bottom-required')] | //span[contains(@class,'dropdown-required')])/..";
	public static final String accountsetup_brandinfo_parentcompyname = "Parent Company Name,xpath,//input[@name='parentCompany']";
	public static final String accountsetup_brandinfo_company = "Company,xpath,//input[@name='brandCompany']";
	public static final String accountsetup_brandinfo_headquarters = "Head quarters,xpath,//select[@name='brandCompanyStatus']/..";
	public static final String accountsetup_brandinfo_dropdowns = "Dropdown,xpath,//ul[@class='k-list-ul']//li";
	public static final String accountsetup_brandinfo_preferredRegions = "Preferred Regions,xpath,//div[contains(@class,'k-chip-list k-selection-multiple')]//input";
	public static final String accountsetup_multiselect_dropdown = "Multi select dropdown,xpath,//div[contains(@class,'multi-dropdownmenu')]//div[@role='option']";
	public static final String accountsetup_brandinfo_regionRemoves = "Remove icon,xpath,//span[@aria-label='PLACE_HOLDER']/../following-sibling::span";
	public static final String accountsetup_brandinfo_addRegions = "+ Plus icon,xpath,//span[@class='k-icon k-i-plus']";
	public static final String accountsetup_brandinfo_regionRemove_icons = "Remove icons,xpath,//div[contains(@class,'multi-dropdownmenu')]//span[contains(@class,'remove-action')]";
	public static final String accountsetup_brandinfo_defaultRegion = "Default Regions,xpath,//input[@id='defaultRegions']";
	public static final String accountsetup_brandinfo_website = "Website URL,xpath,//input[contains(@name,'Website')]";
	public static final String accountsetup_brandinfo_address = "Address line,xpath,//input[contains(@name,'Address')]";
	public static final String accountsetup_brandinfo_city = "City,xpath,//input[contains(@name,'City')]";
	public static final String accountsetup_brandinfo_zipCode = "Zip Code,xpath,//input[contains(@name,'Zipcode')]";
	public static final String accountsetup_brandinfo_country = "Country name,xpath,//span[@aria-label='Country']//span[@class='k-input-value-text']";
	public static final String accountsetup_brandinfo_selectcountry = "Country dropdown,xpath,//select[@name='country']/..//span[@class='k-input-value-text']";
	public static final String accountsetup_brandinfo_region = "Region,xpath,//select[@name='brandRegion']/..//span[@class='k-input-value-text']";
	public static final String accountsetup_brandinfo_regionNodata = "No data found dropdown,xpath,//div[@class='k-nodata']";
	public static final String accountsetup_brandinfo_industrytype = "Industry Type,xpath,//select[@name='brandIndustry']/..//span[@class='k-input-value-text']";
	public static final String accountsetup_brandinfo_businesstype = "Business Type,xpath,//select[@name='businessType']/..//span[@class='k-input-value-text']";
	public static final String accountsetup_brandinfo_brandposition = "Business Position,xpath,//span[@aria-label='Brand position']//button";
	public static final String accountsetup_brandinfo_brandpositionDropdown = "Business Position,xpath,//span[@aria-label='Brand position']/..";
	public static final String accountsetup_brandinfo_hybridCheckbox = "Hybrid checkbox,id,isHybrid";

	// **************************************************************************************
	// Accounts New User
	public static final String accountsetup_smartdxlogo = "SmartDX logo,xpath, //*[@class='sc-fnykZs bYYmdJ']";
	public static final String accountsetup_entercompanyname = "Enter Company name,xpath,//*[@name='companyname']";
	public static final String accountsetup_termsandCondts = "Terms and Conditions Page,xpath,//h1[text()='Terms and Conditions']";
	public static final String accountsetup_newaccsetupconfirmationmsg = "Account setup confirmation message,xpath,//i[@class='icon-thanks-large space-top green-medium icons-lg']";

	// ACCOUNT SETUP - KEY CONTACT INFO
	public static final String accountsetup_keycontactInfo = "Key Contact Info,xpath,//h1[text()='Key contact info']";
	public static final String accountsetup_keycontactInfo_otp_editbtn = "Edit Button,xpath,//div[@class='modal-content']//button[contains(@class,'rsp-secondary')]";
	public static final String accountsetup_keycontactInfo_otpSentMsg = "OTP sent successfully Msg,xpath,//div[@class='validation-message  success_msg']";
	public static final String accountsetup_keycontactInfo_OTP = "OTP filed,xpath,//div[@id='otp']//input";
	public static final String accountsetup_otpSucessMsg = "Valid OTP,xpath,//div[contains(@class,'alert-success')]";
	public static final String accountsetup_otpResend = "Resend OTP,xpath,//small[contains(@class,'link-orange')]";
	public static final String accountsetup_keycontact_email = "Email ID,xpath,//input[@name='email'][@disabled]";
	public static final String accountsetup_Email = "Email,xpath,//input[@name='email address'][@required]";
	public static final String accountsetup_dropdown_default = "Drop-down list,xpath,//div[contains(@class,'k-list-optionlabel')]";
	public static final String accountsetup_helptext = "Otp help text,xpath,//*[contains(@class,'input-desc margin')]";
	public static final String accountsetup_OTP_validMsg = "OTP validation,xpath,//div[contains(@class,'validation-message')][text()='Enter OTP']";
	public static final String accountsetup_OTP_FaildvalidMsg = "OTP Faild validation,xpath,//div[contains(@class,'validation-message')][text()='OTP failed']";
	public static final String accountsetup_OTP_jobRoledvalidMsg = "Job Role validation,xpath,//div[contains(@class,'validation-message')][text()='Select job function']";

	// Account setup BrandInfo
	public static final String accountsetup_enterbrandInfo = "Brand Info,xpath,//input[@placeholder='Brand name']";
	public static final String accountsetup_devietypevalidationWeb = "Device type Web Validation,xpath,//h3[contains(.,'Platform type')]";
	public static final String accountsetup_devietypevalidationMobile = "Device type mobile validation,xpath,//i[contains(@class,'icon-minus-fill')]";
	public static final String accountsetup_clickdeviceplatform = "Device Platform,xpath, //span[@class='k-input'][contains(.,'Select platform')]";
	public static final String accountsetup_selectdeviceplatform = "Device Platform,xpath, //div[@class='k-list-scroller']//li";
	public static final String accountsetup_enterweburl = "Web URL,xpath, //input[@placeholder='Web URL']";
	public static final String accountsetup_clickplusicon = "Plus icon,xpath, //div[@class='pos-icon-2']/i";
	public static final String accountsetup_playstoreurl = "Play store url,xpath, //input[@placeholder='Playstore Url']";
	public static final String accountsetup_clicklanguage = "Select Language dropdown,xpath, //span[@class='k-input'][contains(.,'-- Select language --')]";
	public static final String accountsetup_savebrandinfo = "Save Brand Info,xpath, //button[contains(.,'Save')]";

	// ACCOUNT SETUP BRAND-INFO

	public static final String accountsetup_brandinfo_brand = "Brand Position,xpath,//*[contains(text(),'-- Brand positioning --')]";

	public static final String accountsetup_Submitbutton = "Submit button,xpath,//button[text()='Submit']";
	public static final String accountsetup_Backbutton = "Back button,xpath,//*[contains(@class,'rs-button-link')][text()='Back']";
	public static final String accountsetup_dropdown_validations = "//ancestor::div[@class='position-relative']//div[contains(@class,'validation-message')]";

	// LOCALIZATION SETTINGS
	public static final String accountsetup_localSetting_mandatory = "Mandatory fields,xpath,//span[contains(@class,'dropdown-required')]/..//span[@class='k-label']";
	public static final String accountsetup_localSetting = "Localization Settings,xpath,//h1[.='Localization settings']";
	public static final String accountsetup_localSetting_currency = "Currency name,xpath,//span[contains(@class,'dropdown rs-kendo-dropdown-required')][@aria-label='Currency']";
	public static final String accountsetup_localSetting_language = "Language,xpath,//span[contains(@class,'dropdown rs-kendo-dropdown-required')][@aria-label='Language']";
	public static final String accountsetup_localSetting_dateFormat = "Date format,xpath,//span[contains(@class,'dropdown rs-kendo-dropdown-required')][@aria-label='Date format']";
	public static final String accountsetup_localSetting_timeFormat = "Time Format,xpath,//span[contains(@class,'dropdown rs-kendo-dropdown-required')][@aria-label='Time format']";
	public static final String accountsetup_localSetting_timeZone = "Time Zone,xpath,//span[contains(@class,'dropdown rs-kendo-dropdown-required')][@aria-label='Time zone']";
	public static final String accountsetup_localSetting_timeZoneOption = "timezone dropdown,xpath,//ul[@class='k-list-ul']//li[position()=1]";
	public static final String accountsetup_localSetting_portletMap = "Portlet Map,css,div[id*='highchart']>svg";
	public static final String accountsetup_localSetting_Maplocation = "Portlet Map,css,div[id*='highchart']>svg>g>g>text>tspan";

	// PAYMENT & ACCTIVATION PAGE
	public static final String accountsetup_payment_paynow = "Pay now btn,xpath,//*[contains(@class,'button rsp-primary-button')][text()='Pay']";
	public static final String accountsetup_payment_paylater = "Pay later btn,xpath,//*[contains(@class,'button rsp-primary-button')][text()='Pay later']";
	public static final String accountsetup_payment_validation_msg = "Error Validation Message,xpath,//div[contains(@class,'alert-danger')]//span";
	public static final String accountsetup_activation_msg = "Account activation Message,xpath,//div[@id='messagebody']//td[contains(text(),'account has been activated')]";
	public static final String accountsetup_paymentActivation = "payment & Activation,xpath,//div[@class='heading-title-text']//h1";
	public static final String accountsetup_paymentMethod = "Choose payment methods,xpath,//h4[contains(text(),'Choose a payment method')]";
	public static final String accountsetup_paymentOptions = "Payment Options,xpath,//h4[contains(text(),'Choose a payment method')]/..//li";
	public static final String accountsetup_payment_descreption = "Payment description,xpath,//div[@class='px10']";
	public static final String accountsetup_payment_Ok = "OK button,xpath,//*[contains(@class,'rs-button-primary')][text()='OK']";
	public static final String accountsetup_payment_authenticationCode = "Athentication Code,xpath,//input[@name='authenticationcode']";
	public static final String accountsetup_payment_pay = "Pay button,xpath,//*[contains(@class,'rs-button-primary')][text()='Pay']";
	public static final String accountsetup_payment_validKey = "Valid Key tickmark,xpath,//div[contains(@class,'alert-success')]";

	// Payment thank-you Page
	public static final String accountsetup_thankyoupage_header = "Account setting completed header,xpath,//div[@class='heading-title-text']//h1";
	// public static final String accountsetup_thankyouPage_thumbsup = "Thumbs-up
	// logo,xpath,//*[contains(@class,'icon-rs-circle-thumbs-up-fill-large
	// color')]";
	public static final String accountsetup_thankyouPage_thumbsup = "Thumbs-up logo,xpath,//*[@alt='Success']";
	// public static final String accountsetup_thankyouPage_text = "Thank you for
	// setting up your
	// account,xpath,//*[contains(@class,'icon-rs-circle-thumbs-up-fill-large
	// color')]/..//h2";
	public static final String accountsetup_thankyouPage_text = "Thank you for setting up your account,xpath,//*[@alt='Success']//..//h2";
	public static final String accountsetup_thankyouPage_supportmail = "Support mail,xpath,//button[text()='support@resul.us']";
	public static final String accountsetup_Signin_activationErrMsg = "Signin Error Mssg,xpath,//div[@class='modal-body']//h4";

	// ACCOUNT ACTIVATION PAGE
	public static final String accountsetup_activationPage_header = "Activate your account header,xpath,//h1[.='Activate your account']";
	public static final String accountsetup_activationPage_licenseKey = "RESUL License key,xpath,//div[contains(@class,'license-key-activation-page')]//h2";
	public static final String accountsetup_activationPage_licenseKeyInput = "License key input filed,xpath,//div[@id='otp']//input";

	// Account setup Creation Page
	public static final String accountsetup_creationpageconfirmation = "Creation page,xpath, //img[@class='sc-fEOsli eBKKh']";
	public static final String accountsetup_validation = "Error Validation Message,xpath,//div[@class='validation-message']";
	public static final String accountsetup_marketingstar_logo = "Marketing star logo,xpath,//div[@class='portlet-box-head']//img";
	public static final String accountsetup_dropDown_attribute = "Drop-down,xpath,//*[@class='k-dropdown-wrap']";

	// NeW Account Launch Pad
	public static final String accountsetup_launchPad_menus = "List of menus,xpath,//div[contains(@class,'rs-launchpad-block')]//a";
	public static final String accountsetup_launchPad_header = "Header title,xpath,//div[contains(@class,'heading-title')]//h1";
	// public static final String accountsetup_launchPad_menus = "List of menus,xpath,//div[contains(@class,'rs-launchpad-block')]//a";
	public static final String accountsetup_businessUnit = "Business unit,xpath,//h3[text()='Business unit(s)']";
	public static final String accountsetup_addBusinessUnit = "Add (+) button,xpath,//*[contains(@class,'icon-rs-circle-plus-fill')]";
	public static final String accountsetup_bu_deptName = "Dept name,id,bus[0].buName";
	public static final String accountsetup_assignRole_save = "Save button,xpath,//button[@type='submit'][.='Save']";
	public static final String accountsetup_assignRole_proceed = "Proceed button,xpath,//button[@type='submit'][.='Proceed']";

	// ADMIN CONSOLE
	public static final String adminConsole_email = "Email ID,name,admemailId";
	public static final String adminConsole_password = "Password,name,password";
	public static final String adminConsole_signIn = "Sign In,xpath,//*[text()='Sign In']";
	public static final String adminConsole_resul_logo = "RESUL Logo,xpath,//div[contains(@class,'login-resul-logo')]";
	public static final String adminConsole_otp = "OTP,xpath,//div[@id='otp']//input";
	public static final String adminConsole_otp_confirm = "Confirm CTA,xpath,//*[text()='Confirm'][@type='submit']";
	public static final String adminConsole_listingPage = "Listing Page,xpath,//div[contains(@class,'rs-communication-list')]";
	public static final String adminConsole_listingPage_search = "Search Icon,xpath,//div[contains(@class,'search-container')]";
	public static final String adminConsole_listingPage_searchClose = "Close Search Icon,xpath,//i[contains(@class,'icon-close-small icon')]";
	public static final String adminConsole_listingPage_searchInput = "Search placeHolder,xpath,//input[@placeholder='Search']";
	public static final String adminConsole_listingPage_searchafter = "Search Icon,xpath,//div[contains(@class,'input-search-icon')]";
	public static final String adminConsole_listingPage_firstindex = "First index row,xpath,//*[contains(@class,'admin-listing-table')][@aria-rowcount='1']";
	public static final String adminConsole_listingPage_clientname = "Client name,xpath,//div[contains(@class,'cellPannelInner')][position()=2]//p[text()='PLACE_HOLDER']";
	public static final String adminConsole_listingPage_actType = "Account Type,xpath,//div[contains(@class,'communication-list')]/descendant::p[3]";
	public static final String adminConsole_listingPage_username = "Username,xpath,//div[contains(@class,'communication-list')]/descendant::p[2]";
	public static final String adminConsole_listingPage_licensetype = "Account license type,xpath,//div[contains(@class,'cellPannelInner')][position()=4]//p";
	public static final String adminConsole_listingPage_plusicon = "Plus icon (+),xpath,//*[.='PLACE_HOLDER']/ancestor::tr//i[contains(@class,'k-i-plus')]";
	public static final String adminConsole_detailedView_costIcon = "Cost icon,xpath,//*[text()='PLACE_HOLDER']//ancestor::td//i[contains(@class,'icon-rs-dollar')]";
	public static final String adminConsole_detailedView_subscriptionGrid = "Subscription details grid,xpath,//h4[text()='Subscription details']/following::div[contains(@class,'box-design')]";
	public static final String adminConsole_detailedView_keyIcon = "Key icon,xpath,//div[@class='panel-detail-view']//i[contains(@class,'icon-key-mini icon')]";
	public static final String adminConsole_detailedView_toggleBtn = "Activation toggle button,xpath,//*[text()='PLACE_HOLDER']//ancestor::td//span[@role='switch']";

	public static final String adminConsole_detailedView_toggleBtn2 = "Activation toggle button,xpath,//*[text()='PLACE_HOLDER']//ancestor::td//p[text()='PLACE2']//..//..//span[contains(@class,'switch-off')]";
	public static final String adminConsole_detailedView_toggleON = "Toggle switch ON,xpath,//*[text()='PLACE_HOLDER']//ancestor::td//span[contains(@class,'k-switch-on')]";
	public static final String adminConsole_cost_save = "Save Button,xpath,//button[contains(.,'Save')]";
	public static final String adminConsole_cost_termsAndContdCheckBox = "Terms & Cond check box,xpath,//input[@id='rememberme']";

	public static final String accountsetup_loginotp_cancel = "Cancel button,xpath,//button[@type='button'][contains(.,'ancel')]";

	//////////////////////////////////////////////////////////////////

	public static final String adminConsole_detailedView_dropdownarrow = "arrow icon,xpath,//*[text()='PLACE_HOLDER']//ancestor::td//i[contains(@class,'icon-rs-circle-arrow')]";
	public static final String adminConsole_detailedView_dropdown_pricing_details = "arrow icon,xpath,//*[text()='PLACE_HOLDER']//ancestor::td//a[text()='Pricing details']";

	////////////////////////////////////////////
	// ADMIN CONSOLE /////////

	public static final String adminConsole_Activationbutton = "activation button,xpath,//div[contains(@class,'communication-list')]/descendant::p[.='PLACE_HOLDER']//ancestor::div[@class='rs-communication-list']//span[@aria-checked]";

	public static final String adminConsole_Accountgate_statusicon = "activation button,xpath,//div[contains(@class,'communication-list')]/descendant::p[.='PLACE_HOLDER']//ancestor::div[@class='rs-communication-list']//i";
	public static final String adminConsole_Accountgate_actions_licensekey = ",xpath,//*[text()='PLACE_HOLDER']//ancestor::td//div[@class='click-off']";
	public static final String adminConsole_Accountpage_pricingpage = "pricing page,xpath,//h1[text()='Pricing']";
	public static final String adminConsole_Accountpage_pricingpage_Commitment_dropdown = "Commitment,xpath,(//div[contains(@class,'dropdownmenu')])[2]";
	public static final String adminConsole_Accountpage_pricingpage_frequency_dropdown = "frequency,xpath,(//div[contains(@class,'dropdownmenu')])[3]";
	public static final String adminConsole_Accountpage_pricingpage_paymentterms_dropdown = "paymentterms,xpath,(//div[contains(@class,'dropdownmenu')])[4]";
	public static final String adminConsole_Accountpage_pricingpage_commondropdownlist = "common drop down,xpath,//div[@class='k-list-content']//li";
}
