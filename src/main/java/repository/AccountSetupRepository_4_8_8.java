package repository;

public class AccountSetupRepository_4_8_8
{
	// Login Page

	public static final String ProceedButton = "Proceed Button,pw,input[value=Proceed]";
	public static final String NewUserTab = "New User Tab,pw,//a[text()='New user']";

	// New User Page Tab

	public static final String BusinessMailId = "Business Mail Id,pw,#SignupUserName";
	public static final String Captcha = "Captha,pw,#spVerificationCode";
	public static final String Entercaptcha = "Captcha Code,pw,#VerificationCode";
	public static final String TermAndConditionText = "Terms And COndition Text,pw,//span[contains(text(),'Please accept terms & conditions')]";
	public static final String TermsAndConditionCheckbox = "Terms&Condition checkbox,pw,#CheckTerms";
	public static final String Signupbutton = "Signup button,pw,input[value='Sign Up']";

	// Account type page

	public static final String AccounttypeAgency = "Select Agency,pw,a[onclick='SelectUserAccount(1)']";
	public static final String AccounttypeBrand = "Select Brand,pw,a[onclick='SelectUserAccount(0)']";

	// License type Page

	public static final String startupselectplan = "Startup Plan,pw,//h4[text()='Startup']//parent::div//parent::div//button[text()='Select plan'][@name='command']";
	public static final String proselectplan = "Pro plan,pw,//h4[text()='Pro']//parent::div//parent::div//button[text()='Select plan'][@name='command']";
	public static final String enterpriseselectplan = "Enterprise plan,pw,//h4[text()='Enterprise']//parent::div//parent::div//button[contains(text(),'talk')][@name='command']";

	// Key contact info page

	public static final String Profilepicture = "Profile picture,pw,#contactuserlogo";
	public static final String Salutation = "Salutation,pw,span[aria-owns='salutationfield2_listbox'] span[class='k-input']";
	public static final String FirstName = "First Name,pw,#FirstName";
	public static final String LastName = "LastName,pw,#LastName";
	public static final String SelectMobileNumberCountry = "Select Mobile number country,pw,div[class='selected-flag']";
	public static final String MobileNumbercountrydropdown = "Mobile number country dropdown,pw,ul[class='country-list']>li>span[class='country-name']";
	public static final String MobileNumber = "Mobile number,pw,input[placeholder='Mobile number']";
	public static final String MobileOtp = "Mobile OTP,pw,#OTPCheck";
	public static final String otpokpoppup = "Otp popup ok,pw,input[value='OK']";
	public static final String jobfunction = "Job function,pw,span[aria-owns='JobFunction_listbox'] span[class='k-input']";
	public static final String password = "Password,pw,#Password";
	public static final String confirmpassword = "Confirm password,pw,#ConfirmPassword";
	public static final String KeyContactNextButton = "Next button,pw,input[value='Next'][onclick='ValidateContactInfo(1)']";

	// Brand details page

	public static final String commondropdown = "Common dropdown,pw,div[class*='k-list-container k-popup k-group k-reset k-state-border-up'] li";

	public static final String Companylogo = "Company logo,pw,#companylogo";
	public static final String Parentcompanyname = "Parent company name,pw,#ParentCompanyName";
	public static final String Companyname = "Company name,pw,#CompanyName";
	public static final String BranchType = "Branch Type,pw,span[aria-activedescendant='clientbranchtypedrp_option_selected'] span[class='k-input']";
	public static final String BranchTypedropdown = "Branchtype dropdown,pw,ul[id='clientbranchtypedrp_listbox']>li";
	public static final String City = "City,pw,#City";
	public static final String Zipcode = "Zip code,pw,#Zipcode";
	public static final String Preferredregion = "Preferred region,pw,ul[class='tagsField1 pull-left']>input";
	public static final String Preferredregioncheckbox = "Preferred region checkbox,pw,//ul[@class='tagsField1 pull-left']//parent::div//div//input[@id='regions']";
	public static final String Website = "Website,pw,#Website";
	public static final String Address = "Address,pw,#Address";
	public static final String countryoption = "Country option,pw,span[aria-activedescendant='Country_option_selected'] span[class='k-input']";
	public static final String Regionoption = "Region option,pw,span[aria-activedescendant='Region_option_selected'] span[class='k-input']";
	public static final String BusinessType = "Business Type,pw,span[aria-activedescendant='BusinessType_option_selected'] span[class='k-input']";
	public static final String Brandposition = "Brand position,pw,span[aria-activedescendant='BrandPosition_option_selected'] span[class='k-input']";
	public static final String industry = "Industry,pw,span[aria-activedescendant='Industry_option_selected'] span[class='k-input']";
	public static final String hybridcheckbox = "Is hybrid checkbox,pw,#chkishybrid";
	public static final String branddetails = "Brand detail,pw,input[value='Next'][onclick='ValidateCompanyInfo()']";
	public static final String BrandDetailsNextButton = "Next button,pw,input[value='Next'][onclick='ValidateCompanyInfo()']";

	// Localization setting
	public static final String dateformat = "Date format,pw,span[aria-owns='DateFormat_listbox'] span[class='k-input']";
	public static final String timeformat = "Time format,pw,span[aria-owns='TimeFormat_listbox'] span[class='k-input']";
	public static final String timezone = "Timezone,pw,span[aria-owns='TimeZone_listbox'] span[class='k-input']";
	public static final String submit = "Submit,pw,input[value='Submit']";

	// Thank you Page
	public static final String thankYouPage = "Thank you message,pw,//h2[text()='Thank you for signing up!']";

}
