package regression_AccountSetup;

import org.testng.annotations.Test;

import pages.AccountSetupCreation;
import repository.AccountSetupRepository;
import repository.ObjectRepository;
import utility.BaseTest;
import utility.PageBase;

public class AccountSetup extends BaseTest
{

	// ************************ ACCOUNT CREATION - AGENCY **********************

	@Test(testName = "", description = "Agency - StartUp New Account Creation")
	public void agencyStartUp_AccountCreation()
	{
		AccountSetupCreation account = getPageFactory().acctSetupPage();

		account.clickNewUser();
		if (account.signUpPage())
		{
			account.selectAccountType("Agency");
			account.keyContactInfoPage();
			account.enterMobileOTP();
			account.clickNext();
			account.agencyDetailsPage();
			account.clickNext();
			account.localizationSettings();
			account.clickSubmit();
			account.thankyouPage();
			String username = AccountSetupCreation.getAcctStpEmailID();
			if (username != null)
			{
				// Admin Console
				String parentWind = account.parentWinHandle();
				account.javaScriptopenNewWindow();
				account.switchWindow();
				account.loginAdminConsole(account.getAdminConsoleUserName(), account.getAdminConsolePswd());
				account.agencyAccountActivation2(username);
				account.switchParentWin(parentWind);
				account.accountsetuplogin(username, account.dPropertyLoginPswrd());
				String licenseKey = account.getAccountLicenseKey();
				account.accountActivationPage(licenseKey);

				// STARTUP ACCOUNT
				account.selectLicenseType("StartUp");
				account.brandDetailsStartUp();
				account.clickNext();
				account.localizationSettings();
				account.clickSubmit();
				account.thankyouPage();

				// Account Activation
				account.switchToSpecificWindow(1);
				account.verifyAccountDetails();
				account.switchParentWin(parentWind);
				account.accountsetuplogin(username, account.dPropertyLoginPswrd());
				account.paymentPage("Invoice");
				account.thankyouPage();
				account.switchToSpecificWindow(1);
				account.accountActivation();
				account.switchParentWin(parentWind);
				licenseKey = account.getAccountLicenseKey();
				account.accountsetuplogin(username, account.dPropertyLoginPswrd());
				account.accountActivationPage(licenseKey);

				// Validate Launch Pad
				account.newAccountLaunchPad();
			}
		}
	}

	@Test(testName = "", description = "Agency - PRO New Account Creation")
	public void agencyPRO_AccountCreation()
	{
		AccountSetupCreation account = getPageFactory().acctSetupPage();

		account.clickNewUser();
		if (account.signUpPage())
		{
			account.selectAccountType("Agency");
			account.keyContactInfoPage();
			account.enterMobileOTP();
			account.clickNext();
			account.agencyDetailsPage();
			account.clickNext();
			account.localizationSettings();
			account.clickSubmit();
			account.thankyouPage();
			String username = AccountSetupCreation.getAcctStpEmailID();
			if (username != null)
			{
				// Admin Console
				String parentWind = account.parentWinHandle();
				account.javaScriptopenNewWindow();
				account.switchWindow();
				account.loginAdminConsole(account.getAdminConsoleUserName(), account.getAdminConsolePswd());
				account.agencyAccountActivation();
				account.switchParentWin(parentWind);
				account.accountsetuplogin(username, account.dPropertyLoginPswrd());
				String licenseKey = account.getAccountLicenseKey();
				account.accountActivationPage(licenseKey);

				// PROFESSIONAL ACCOUNT
				account.selectLicenseType("PRO");
				account.brandDetailsPRO();
				account.clickNext();
				account.localizationSettings();
				account.clickSubmit();
				account.thankyouPage();

				// Account Activation
				account.switchToSpecificWindow(1);
				account.verifyAccountDetails();
				account.switchParentWin(parentWind);
				account.accountsetuplogin(username, account.dPropertyLoginPswrd());
				account.paymentPage("Invoice");
				account.thankyouPage();
				account.switchToSpecificWindow(1);
				account.accountActivation();
				account.switchParentWin(parentWind);
				licenseKey = account.getAccountLicenseKey();
				account.accountsetuplogin(username, account.dPropertyLoginPswrd());
				account.accountActivationPage(licenseKey);

				// Validate Launch Pad
				account.newAccountLaunchPad();
			}
		}
	}

	@Test(testName = "", description = "Agency - Enterprise New Account Creation")
	public void agencyEnterprise_AccountCreation()
	{
		AccountSetupCreation account = getPageFactory().acctSetupPage();

		account.clickNewUser();
		if (account.signUpPage())
		{
			account.selectAccountType("Agency");
			account.keyContactInfoPage();
			account.enterMobileOTP();
			account.clickNext();
			account.agencyDetailsPage();
			account.clickNext();
			account.localizationSettings();
			account.clickSubmit();
			account.thankyouPage();
			String username = AccountSetupCreation.getAcctStpEmailID();
			if (username != null)
			{
				// Admin Console
				String parentWind = account.parentWinHandle();
				account.javaScriptopenNewWindow();
				account.switchWindow();
				account.loginAdminConsole(account.getAdminConsoleUserName(), account.getAdminConsolePswd());
				account.agencyAccountActivation();
				account.switchParentWin(parentWind);
				account.accountsetuplogin(username, account.dPropertyLoginPswrd());
				String licenseKey = account.getAccountLicenseKey();
				account.accountActivationPage(licenseKey);

				// ENTERPRISE ACCOUNT
				account.selectLicenseType("Enterprise");
				account.javaScriptScrollUpToSomeExtend();
				account.brandDetailsEnterprise();
				account.clickNext();
				account.localizationSettings();
				account.clickSubmit();
				account.thankyouPage();

				// Account Activation
				username = AccountSetupCreation.getAcctStpEmailID();
				if (username != null)
				{
					// Admin Console
					parentWind = account.parentWinHandle();
					account.javaScriptopenNewWindow();
					account.switchWindow();
					account.loginAdminConsole(account.getAdminConsoleUserName(), account.getAdminConsolePswd());
					account.verifyAccountDetails();
					account.switchParentWin(parentWind);
					account.accountsetuplogin(username, account.dPropertyLoginPswrd());
					account.paymentPage("Invoice");
					account.thankyouPage();

					account.accountActivation();
					account.switchParentWin(parentWind);
					licenseKey = account.getAccountLicenseKey();
					account.accountsetuplogin(username, account.dPropertyLoginPswrd());
					account.accountActivationPage(licenseKey);

//				account.switchToSpecificWindow(1);
//				account.accountActivation();
//				account.switchParentWin(parentWind);
//				licenseKey = account.getAccountLicenseKey();
//				account.accountsetuplogin(username, account.dPropertyLoginPswrd());
//				account.accountActivationPage(licenseKey);


				// Add Business Unit
				account.addBusinessUnit();
//				account.clickDashboardTab();
//				account.selectbusinessunit();

			}}
		}
	}
	@Test(testName = "", description = "Agency - Enterprise plus New Account Creation")
	public void agencyEnterpriseplus_AccountCreation()
	{
		AccountSetupCreation account = getPageFactory().acctSetupPage();

		account.clickNewUser();
		if (account.signUpPage())
		{
			account.selectAccountType("Agency");
			account.keyContactInfoPage();
			account.enterMobileOTP();
			account.clickNext();
			account.agencyDetailsPage();
			account.clickNext();
			account.localizationSettings();
			account.clickSubmit();
			account.thankyouPage();
			String username = AccountSetupCreation.getAcctStpEmailID();
			if (username != null)
			{
				// Admin Console
				String parentWind = account.parentWinHandle();
				account.javaScriptopenNewWindow();
				account.switchWindow();
				account.loginAdminConsole(account.getAdminConsoleUserName(), account.getAdminConsolePswd());
				account.agencyAccountActivation();
				account.switchParentWin(parentWind);
				account.accountsetuplogin(username, account.dPropertyLoginPswrd());
				String licenseKey = account.getAccountLicenseKey();
				account.accountActivationPage(licenseKey);

				// ENTERPRISE ACCOUNT
				account.selectLicenseType("Enterprise");
				account.javaScriptScrollUpToSomeExtend();
				account.brandDetailsEnterprise();
				account.clickNext();
				account.localizationSettings();
				account.clickSubmit();
				account.thankyouPage();

				// Account Activation
				 username = AccountSetupCreation.getAcctStpEmailID();
				if (username != null)
				{
					// Admin Console
					 parentWind = account.parentWinHandle();
					account.javaScriptopenNewWindow();
					account.switchWindow();
					account.loginAdminConsole(account.getAdminConsoleUserName(), account.getAdminConsolePswd());	
					account.verifyAccountDetails();
				account.switchParentWin(parentWind);
				account.accountsetuplogin(username, account.dPropertyLoginPswrd());
				account.paymentPage("Invoice");
				account.thankyouPage();
				
				account.accountActivation();
				account.switchParentWin(parentWind);
				 licenseKey = account.getAccountLicenseKey();
				account.accountsetuplogin(username, account.dPropertyLoginPswrd());
				account.accountActivationPage(licenseKey);

				
//				account.switchToSpecificWindow(1);
//				account.accountActivation();
//				account.switchParentWin(parentWind);
//				licenseKey = account.getAccountLicenseKey();
//				account.accountsetuplogin(username, account.dPropertyLoginPswrd());
//				account.accountActivationPage(licenseKey);

				// Add Business Unit
				account.addBusinessUnit();

					// Add Business Unit
//				account.clickDashboardTab();
//				account.selectbusinessunit();

				}
			}
		}
	}

	

	@Test(testName = "", description = "Agency - Keycontact Info Scenarios")
	public void agency_KeyContactInfoScenarios()
	{
		AccountSetupCreation account = getPageFactory().acctSetupPage();

		account.clickNewUser();
		if (account.signUpPage())
		{
			account.selectAccountType("Agency");
			account.keyContactDropdownScenarios();
			account.profilePictureUploadScenarios("Key Contact");
			account.keyContactTextFieldScenarios();
			account.mobileNoVerificationScearios();
		}
	}

	@Test(testName = "", description = "Agency - Keycontact OTP Resent validation")
	public void agency_KeyContactOtpResend()
	{
		AccountSetupCreation account = getPageFactory().acctSetupPage();

		account.clickNewUser();
		account.signUpPage();
		account.selectAccountType("Agency");
		account.keyContactDetailsMandateFieldCheck();
		account.otpResnedCheck();
	}

	@Test(testName = "", description = "Agency Detatils Page Scenarios")
	public void agencyDetailsPageScenarios()
	{
		AccountSetupCreation account = getPageFactory().acctSetupPage();

		account.clickNewUser();
		if (account.signUpPage())
		{
			account.selectAccountType("Agency");
			account.keyContactInfoPage();
			account.enterMobileOTP();
			account.clickNext();

			// Validate Back button
			account.isDisplayed(AccountSetupRepository.accountsetup_agencyDetails);
			account.clickBack();
			account.isDisplayed(AccountSetupRepository.accountsetup_keyContact);
			account.clickNext();
			account.isDisplayed(AccountSetupRepository.accountsetup_agencyDetails);

			// Verify Mandatory fields
			account.validateMandatoryField(AccountSetupRepository.accountsetup_brandinfo_mandatory, getData().ValidationMsg);
			account.profilePictureUploadScenarios("agency");

			account.agencyGroup();
			account.agencyCompany();
			account.enterAddress();
			account.enterCity();
			account.enterZipCode();
			account.enterWebsite();
			account.selectCountry();
			account.clickNext();

			// Localization Settings
			account.isDisplayed(AccountSetupRepository.accountsetup_localSetting);
			account.isElementAvailable(AccountSetupRepository.accountsetup_localSetting_portletMap);
		}
	}

	@Test(testName = "", description = "Agency Startup - Brand Details Scenarios")
	public void agencyStartupAct_BrandDetailsScenarios()
	{
		AccountSetupCreation account = getPageFactory().acctSetupPage();

		account.clickNewUser();
		if (account.signUpPage())
		{
			account.selectAccountType("Agency");
			account.keyContactInfoPage();
			account.enterMobileOTP();
			account.clickNext();
			account.agencyDetailsPage();
			account.clickNext();
			account.localizationSettings();
			account.clickSubmit();
			account.thankyouPage();
			String username = AccountSetupCreation.getAcctStpEmailID();
			if (username != null)
			{
				// Admin Console
				String parentWind = account.parentWinHandle();
				account.javaScriptopenNewWindow();
				account.switchWindow();
				account.loginAdminConsole(account.getAdminConsoleUserName(), account.getAdminConsolePswd());
				account.agencyAccountActivation();
				account.switchParentWin(parentWind);
				account.login(username, account.dPropertyLoginPswrd());
				String licenseKey = account.getAccountLicenseKey();
				account.accountActivationPage(licenseKey);

				// STARTUP ACCOUNT
				account.selectLicenseType("StartUp");

				// Verify Mandatory fields
				account.validateMandatoryField(AccountSetupRepository.accountsetup_brandinfo_mandatory, getData().ValidationMsg);
				account.brandCompany();
				account.enterWebsite();
				account.enterAddress();
				account.enterCity();
				account.enterZipCode();
				account.selectCountry();
				account.selectIndustryType();
				account.businessType();
				account.brandPosition();

				// Upload Brand Images
				account.profilePictureUploadScenarios("Brand");
				account.clickNext();

				// Localization Settings
				account.isDisplayed(AccountSetupRepository.accountsetup_localSetting);
				account.isElementAvailable(AccountSetupRepository.accountsetup_localSetting_portletMap);
			}
		}
	}

	@Test(testName = "", description = "Agency Professional Act - Brand Details Scenarios")
	public void agencyPROAct_BrandDetailsScenarios()
	{
		AccountSetupCreation account = getPageFactory().acctSetupPage();

		account.clickNewUser();
		if (account.signUpPage())
		{
			account.selectAccountType("Agency");
			account.keyContactInfoPage();
			account.enterMobileOTP();
			account.clickNext();
			account.agencyDetailsPage();
			account.clickNext();
			account.localizationSettings();
			account.clickSubmit();
			account.thankyouPage();
			String username = AccountSetupCreation.getAcctStpEmailID();
			if (username != null)
			{
				// Admin Console
				String parentWind = account.parentWinHandle();
				account.javaScriptopenNewWindow();
				account.switchWindow();
				account.loginAdminConsole(account.getAdminConsoleUserName(), account.getAdminConsolePswd());
				account.agencyAccountActivation();
				account.switchParentWin(parentWind);
				account.login(username, account.dPropertyLoginPswrd());
				String licenseKey = account.getAccountLicenseKey();
				account.accountActivationPage(licenseKey);

				// PROFESSIONAL ACCOUNT
				account.selectLicenseType("PRO");

				// Verify Mandatory fields
				account.validateMandatoryField(AccountSetupRepository.accountsetup_brandinfo_mandatory, getData().ValidationMsg);
				account.brandCompany();
				account.enterWebsite();
				account.enterAddress();
				account.enterCity();
				account.enterZipCode();
				account.selectCountry();
				account.selectIndustryType();
				account.businessType();
				account.brandPosition();

				// Upload Brand Images
				account.profilePictureUploadScenarios("Brand");
				account.clickNext();

				// Localization Settings
				account.isDisplayed(AccountSetupRepository.accountsetup_localSetting);
				account.isElementAvailable(AccountSetupRepository.accountsetup_localSetting_portletMap);
			}
		}
	}

	@Test(testName = "", description = "Agency Enterprise Act - Brand Details Scenarios")
	public void agencyEnterpriseAct_BrandDetailsScenarios()
	{
		AccountSetupCreation account = getPageFactory().acctSetupPage();

		account.clickNewUser();
		if (account.signUpPage())
		{
			account.selectAccountType("Agency");
			account.keyContactInfoPage();
			account.enterMobileOTP();
			account.clickNext();
			account.agencyDetailsPage();
			account.clickNext();
			account.localizationSettings();
			account.clickSubmit();
			account.thankyouPage();
			String username = AccountSetupCreation.getAcctStpEmailID();
			if (username != null)
			{
				// Admin Console
				String parentWind = account.parentWinHandle();
				account.javaScriptopenNewWindow();
				account.switchWindow();
				account.loginAdminConsole(account.getAdminConsoleUserName(), account.getAdminConsolePswd());
				account.agencyAccountActivation();
				account.switchParentWin(parentWind);
				account.login(username, account.dPropertyLoginPswrd());
				String licenseKey = account.getAccountLicenseKey();
				account.accountActivationPage(licenseKey);

				// ENTERPRISE ACCOUNT
				account.selectLicenseType("Enterprise");

				// Verify Mandatory fields
				account.validateMandatoryField(AccountSetupRepository.accountsetup_brandinfo_mandatory, getData().ValidationMsg);
				account.parentCompany();
				account.brandCompany();
				account.preferedRegions();
				account.selectHeadQauter();
				account.enterWebsite();
				account.enterAddress();
				account.enterCity();
				account.enterZipCode();
				account.selectCountry();
				account.regionDropdown();
				account.selectIndustryType();
				account.businessType();
				account.brandPosition();
				account.isHybridSolution();

				// Upload Brand Images
				account.profilePictureUploadScenarios("Brand");
				account.clickNext();

				// Localization Settings
				account.isDisplayed(AccountSetupRepository.accountsetup_localSetting);
				account.isElementAvailable(AccountSetupRepository.accountsetup_localSetting_portletMap);
			}
		}
	}

	// ************************ ACCOUNT CREATION - BRAND **********************

	@Test(testName = "", description = "Brand - StartUp New Account Creation")
	public void brandStartUp_AccountCreation()
	{
		AccountSetupCreation account = getPageFactory().acctSetupPage();

		account.clickNewUser();
		if (account.signUpPage())
		{
			account.selectAccountType("Brand");
			account.selectLicenseType("StartUp");
			account.keyContactInfoPage();
			account.enterMobileOTP();
			account.clickNext();
			account.brandDetailsStartUp();
			account.clickNext();
			account.localizationSettings();
			account.clickSubmit();
			account.thankyouPage();
			String username = AccountSetupCreation.getAcctStpEmailID();
			if (username != null)
			{
				// Admin Console
				String parentWind = account.parentWinHandle();
				account.javaScriptopenNewWindow();
				account.switchWindow();
				account.loginAdminConsole(account.getAdminConsoleUserName(), account.getAdminConsolePswd());
				account.verifyAccountDetails();
				account.switchParentWin(parentWind);
				// Account Activation
				account.accountsetuplogin(username, account.dPropertyLoginPswrd());
				account.paymentPage("Invoice");
				account.thankyouPage();
				account.switchToSpecificWindow(1);
				account.accountActivation();
				account.switchParentWin(parentWind);
				String licenseKey = account.getAccountLicenseKey();
				account.accountsetuplogin(username, account.dPropertyLoginPswrd());
				account.accountActivationPage(licenseKey);

				// Validate Launch Pad
				account.newAccountLaunchPad();
			}
		}
	}

	@Test(testName = "RESUL-ACTSTP-BRD-ENT-TS-002", description = "Brand - PRO New Account Creation")
	public void brandPRO_AccountCreation()
	{
		AccountSetupCreation account = getPageFactory().acctSetupPage();

		account.clickNewUser();
		if (account.signUpPage())
		{
			account.selectAccountType("Brand");
			account.selectLicenseType("Pro");
			account.keyContactInfoPage();
			account.enterMobileOTP();
			account.clickNext();
			account.brandDetailsPRO();
			account.clickNext();
			account.localizationSettings();
			account.clickSubmit();
			account.thankyouPage();
			String username = AccountSetupCreation.getAcctStpEmailID();
			if (username != null)
			{
				// Admin Console
				String parentWind = account.parentWinHandle();
				account.javaScriptopenNewWindow();
				account.switchWindow();
				account.loginAdminConsole(account.getAdminConsoleUserName(), account.getAdminConsolePswd());
				account.verifyAccountDetails();
				account.switchParentWin(parentWind);
				// Account Activation
				account.accountsetuplogin(username, account.dPropertyLoginPswrd());
				account.paymentPage("Invoice");
				account.thankyouPage();
				account.switchToSpecificWindow(1);
				account.accountActivation();
				account.switchParentWin(parentWind);
				String licenseKey = account.getAccountLicenseKey();
				account.accountsetuplogin(username, account.dPropertyLoginPswrd());
				account.accountActivationPage(licenseKey);

				// Validate Launch Pad
				account.newAccountLaunchPad();
			}
		}
	}

	@Test(testName = "RESUL-ACTSTP-BRD-ENT-TS-001", description = "Brand - Enterprise New Account Creation")
	public void brandEnterprise_AccountCreation()
	{
		AccountSetupCreation account = getPageFactory().acctSetupPage();

		account.clickNewUser();
		if (account.signUpPage())
		{
			account.selectAccountType("Brand");
			account.selectLicenseType("Enterprise");
			account.keyContactInfoPage();
			account.enterMobileOTP();
			account.clickNext();
			account.brandDetailsEnterprise();
			account.clickNext();
			account.localizationSettings();
			account.clickSubmit();
			account.thankyouPage();
			String username = AccountSetupCreation.getAcctStpEmailID();
			if (username != null)
			{
				// Admin Console
				String parentWind = account.parentWinHandle();
				account.javaScriptopenNewWindow();
				account.switchWindow();
				account.loginAdminConsole(account.getAdminConsoleUserName(), account.getAdminConsolePswd());
				account.verifyAccountDetails();
				account.switchParentWin(parentWind);
				// Account Activation
				account.accountsetuplogin(username, account.dPropertyLoginPswrd());
				account.paymentPage("Invoice");
				account.thankyouPage();

				account.accountActivation();
				account.switchParentWin(parentWind);
				String licenseKey = account.getAccountLicenseKey();
				account.accountsetuplogin(username, account.dPropertyLoginPswrd());
				account.accountActivationPage(licenseKey);

				// Add Business Unit
				account.addBusinessUnit();
//				account.Accountbuselect();
//				account.clickDashboardTab();
//				account.selectbusinessunit();
			}
		}
	}

	@Test(testName = "RESUL-ACTSTP-BRD-ENT-TS-001", description = "Brand - Enterprise PLUS New Account Creation")
	public void brandEnterpriseplus_AccountCreation()
	{
		AccountSetupCreation account = getPageFactory().acctSetupPage();

		account.clickNewUser();
		if (account.signUpPage())
		{
			account.selectAccountType("Brand");
			account.selectLicenseType("Enterprise");
			account.keyContactInfoPage();
			account.enterMobileOTP();
			account.clickNext();
			account.brandDetailsEnterprise();
			account.clickNext();
			account.localizationSettings();
			account.clickSubmit();
			account.thankyouPage();
			String username = AccountSetupCreation.getAcctStpEmailID();
			if (username != null)
			{
				// Admin Console
				String parentWind = account.parentWinHandle();
				account.javaScriptopenNewWindow();
				account.switchWindow();
				account.loginAdminConsole(account.getAdminConsoleUserName(), account.getAdminConsolePswd());
				account.verifyAccountDetails();
				account.switchParentWin(parentWind);
				// Account Activation
				account.accountsetuplogin(username, account.dPropertyLoginPswrd());
				account.paymentPage("Invoice");
				account.thankyouPage();

				account.accountActivation();
				account.switchParentWin(parentWind);
				String licenseKey = account.getAccountLicenseKey();
				account.accountsetuplogin(username, account.dPropertyLoginPswrd());
				account.accountActivationPage(licenseKey);

				// Add Business Unit
				account.addBusinessUnit();
//				account.Accountbuselect();
//				account.clickDashboardTab();
//				account.selectbusinessunit();
			}
		}
	}

	// ************************ ACCOUNT SETUP - NEGATIVE SCENARIOS
	// **********************

	@Test(testName = "", description = "Sign-Up Page Scenarios")
	public void signUpPageNegativeScenarios()
	{
		AccountSetupCreation account = getPageFactory().acctSetupPage();

		// Validate new user
		account.clickNewUser();

		// Validate the Business Email ID
		String testData = System.getProperty("Max_Character");
		account.checkInputBoxLength(AccountSetupRepository.accountsetup_enteremail, testData, 75);

		String[] dataSet = getData().EnterNewEmail.split(",");
		String[] validations = getData().ValidationMsg.split(",");
		for (int i = 0; i < dataSet.length; i++)
		{
			account.enterValue(AccountSetupRepository.accountsetup_enteremail, dataSet[i]).tabAction();
			PageBase.threadSleep(ObjectRepository.wait5sec);
			String error = account.getStrText(AccountSetupRepository.accountsetup_mailmsg);
			account.uiPageEqualswithInputValue(error, validations[i]);
			takeScreenshot();
			account.clearField(AccountSetupRepository.accountsetup_enteremail);
		}

		// Enter valid Email ID
		account.enterValue(AccountSetupRepository.accountsetup_enteremail, account.getRandomEmail()).enterTabAction();
		account.isDisplayed(AccountSetupRepository.accountsetup_emailValidation);
		account.isEnabled(AccountSetupRepository.accountsetup_clicksignupbutton);

		// Validate Captcha Field
		int result = account.captchaHandle();
		account.checkInputBoxLength(AccountSetupRepository.accountsetup_entercaptchavalue, "999", 2);
		if (account.checkInputBoxLength(AccountSetupRepository.accountsetup_entercaptchavalue, "!@#%-Test", 0))
		{
			BaseTest.getTest().info("Captch field doesn't accept alpha & special charaters, As Expected");
		} ;
		account.enterValue(AccountSetupRepository.accountsetup_entercaptchavalue, String.valueOf(result + 1)).tabAction();
		account.uiPageEqualswithInputValue("Enter the correct answer", account.getStrText(AccountSetupRepository.accountsetup_captchamsg));
		BaseTest.takeScreenshot();
		account.enterValue(AccountSetupRepository.accountsetup_entercaptchavalue, String.valueOf(result)).tabAction();
		account.isDisplayed(AccountSetupRepository.accountsetup_captchamsg);
		account.clickSignUp();
		account.uiPageEqualswithInputValue("Enter answer", account.getStrText(AccountSetupRepository.accountsetup_captchamsg));
		account.uiPageEqualswithInputValue("Please accept the terms & conditions to proceed", account.getStrText(AccountSetupRepository.accountsetup_termsAndcondValidation));

		// Enter valid captcha
		PageBase.threadSleep(ObjectRepository.wait5sec);
		result = account.captchaHandle();
		PageBase.threadSleep(ObjectRepository.wait3sec);
		account.enterValue(AccountSetupRepository.accountsetup_entercaptchavalue, String.valueOf(result)).tabAction();

		// Validate Terms & Conditions
		if (!account.isSelected(AccountSetupRepository.accountsetup_agreetermsselect))
		{
			account.clickSignUp();
			account.uiPageEqualswithInputValue("Please accept the terms & conditions to proceed", account.getStrText(AccountSetupRepository.accountsetup_termsAndcondValidation));
			BaseTest.takeScreenshot();
			account.clickElement(AccountSetupRepository.accountsetup_agreetermsselect);
		}
		account.clickElement(AccountSetupRepository.accountsetup_termsandCondLink);
		String pwind = account.parentWinHandle();
		account.switchWindow();
		account.isDisplayed(AccountSetupRepository.accountsetup_termsandCondts);
		account.childWindowClose(pwind);

		// Validate Copy right links
		account.copyRightLinks();
		account.clickSignUp();
		account.explicitwaitforclick(PageBase.autolocator(AccountSetupRepository.accountsetup_agencyaccount), 40);
		account.isDisplayed(AccountSetupRepository.accountsetup_selectaccounttype);
	}

	@Test(testName = "", description = "Select Account and License Type Page Scenarios")
	public void selectAccountAndLicenseTypePageScenarios()
	{
		AccountSetupCreation account = getPageFactory().acctSetupPage();

		account.clickNewUser();
		if (account.signUpPage())
		{
			// Agency Account
			account.selectAccountType("Agency");
			account.isDisplayed(AccountSetupRepository.accountsetup_keyContact);
			account.clickBack();
			account.isDisplayed(AccountSetupRepository.accountsetup_selectaccounttype);

			// Brand Account
			account.selectAccountType("Brand");
			account.validateLicenseTypePage();
			account.selectLicenseType("Enterprise");
			account.isDisplayed(AccountSetupRepository.accountsetup_keyContact);

			// Validate Back button
			account.clickBack();
			account.isDisplayed(AccountSetupRepository.accountsetup_selectlicensetype);
			account.clickBack();
			account.isDisplayed(AccountSetupRepository.accountsetup_selectaccounttype);
		}
	}

	@Test(testName = "", description = "Brand StartUp - Keycontact Info Scenarios")
	public void brandStartUpAct_KeyContactInfoScenarios()
	{
		AccountSetupCreation account = getPageFactory().acctSetupPage();

		account.clickNewUser();
		if (account.signUpPage())
		{
			account.selectAccountType("Brand");
			account.selectLicenseType("Startup");
			account.javaScriptScrollDown();
			account.clickBack();
			account.isElementAvailable("License type portlet,xpath,//div[@class='rs-license-selection-page'][contains(.,'Startup')]");
			account.selectLicenseType("Startup");
			account.keyContactDropdownScenarios();
			account.profilePictureUploadScenarios("Key Contact");
			account.keyContactTextFieldScenarios();
			account.mobileNoVerificationScearios();
		}
	}

	@Test(testName = "", description = "Brand PRO - Keycontact Info Scenarios")
	public void brandPROAct_KeyContactInfoScenarios()
	{
		AccountSetupCreation account = getPageFactory().acctSetupPage();

		account.clickNewUser();
		if (account.signUpPage())
		{
			account.selectAccountType("Brand");
			account.selectLicenseType("PRO");
			account.javaScriptScrollDown();
			account.clickBack();
			account.isElementAvailable("License type portlet,xpath,//div[@class='rs-license-selection-page'][contains(.,'Professional')]");
			account.selectLicenseType("PRO");
			account.keyContactDropdownScenarios();
			account.profilePictureUploadScenarios("Key Contact");
			account.keyContactTextFieldScenarios();
			account.mobileNoVerificationScearios();
		}
	}

	@Test(testName = "", description = "Brand Enterprise - Keycontact Info Scenarios")
	public void brandEnterpriseAct_KeyContactInfoScenarios()
	{
		AccountSetupCreation account = getPageFactory().acctSetupPage();

		account.clickNewUser();
		if (account.signUpPage())
		{
			account.selectAccountType("Brand");
			account.selectLicenseType("Enterprise");
			account.javaScriptScrollDown();
			account.clickBack();
			account.isElementAvailable("License type portlet,xpath,//div[@class='rs-license-selection-page'][contains(.,'Enterprise')]");
			account.selectLicenseType("Enterprise");
			account.keyContactDropdownScenarios();
			account.profilePictureUploadScenarios("Key Contact");
			account.keyContactTextFieldScenarios();
			account.mobileNoVerificationScearios();
		}
	}

	@Test(testName = "", description = "Resend OTP verification")
	public void brandAct_OtpResend()
	{
		AccountSetupCreation account = getPageFactory().acctSetupPage();

		account.clickNewUser();
		account.signUpPage();
		account.selectAccountType("Brand");
		account.selectLicenseType("Startup");
		account.keyContactDetailsMandateFieldCheck();
		account.javaScriptScrollDown();
		account.clickBack();
		account.isElementAvailable("License type portlet,xpath,//div[@class='rs-license-selection-page'][contains(.,'Startup')]");
		account.selectLicenseType("Startup");
		account.otpResnedCheck();
	}

	@Test(testName = "", description = "Brand StartUp - Brand Details Scenarios")
	public void brandStartUpAct_BrandDetailsScenarios()
	{
		AccountSetupCreation account = getPageFactory().acctSetupPage();

		account.clickNewUser();
		if (account.signUpPage())
		{
			account.selectAccountType("Brand");
			account.selectLicenseType("StartUp");
			account.keyContactInfoPage();
			account.enterMobileOTP();
			account.clickNext();

			// Validate Back button
			account.isDisplayed(AccountSetupRepository.accountsetup_brandinfo);
			account.clickBack();
			account.isDisplayed(AccountSetupRepository.accountsetup_keyContact);
			account.clickNext();
			account.isDisplayed(AccountSetupRepository.accountsetup_brandinfo);

			// Verify Mandatory fields
			account.validateMandatoryField(AccountSetupRepository.accountsetup_brandinfo_mandatory, getData().ValidationMsg);
			account.brandCompany();
			account.enterWebsite();
			account.enterAddress();
			account.enterCity();
			account.enterZipCode();
			account.selectCountry();
			account.selectIndustryType();
			account.businessType();
			account.brandPosition();

			// Upload Brand Images
			account.profilePictureUploadScenarios("Brand");
			account.clickNext();

			// Localization Settings
			account.isDisplayed(AccountSetupRepository.accountsetup_localSetting);
			account.isElementAvailable(AccountSetupRepository.accountsetup_localSetting_portletMap);
		}
	}

	@Test(testName = "", description = "Brand PRO - Brand Details Scenarios")
	public void brandProAct_BrandDetailsScenarios()
	{
		AccountSetupCreation account = getPageFactory().acctSetupPage();

		account.clickNewUser();
		if (account.signUpPage())
		{
			account.selectAccountType("Brand");
			account.selectLicenseType("PRO");
			account.keyContactInfoPage();
			account.enterMobileOTP();
			account.clickNext();

			// Validate Back button
			account.isDisplayed(AccountSetupRepository.accountsetup_brandinfo);
			account.clickBack();
			account.isDisplayed(AccountSetupRepository.accountsetup_keyContact);
			account.clickNext();
			account.isDisplayed(AccountSetupRepository.accountsetup_brandinfo);

			// Verify Mandatory fields
			account.validateMandatoryField(AccountSetupRepository.accountsetup_brandinfo_mandatory, getData().ValidationMsg);
			account.brandCompany();
			account.enterWebsite();
			account.enterAddress();
			account.enterCity();
			account.enterZipCode();
			account.selectCountry();
			account.selectIndustryType();
			account.businessType();
			account.brandPosition();

			// Upload Brand Images
			account.profilePictureUploadScenarios("Brand");
			account.clickNext();

			// Localization Settings
			account.isDisplayed(AccountSetupRepository.accountsetup_localSetting);
			account.isElementAvailable(AccountSetupRepository.accountsetup_localSetting_portletMap);
		}
	}

	@Test(testName = "", description = "Brand Enterprise - Brand Details Scenarios")
	public void brandEnterpriseAct_BrandDetailsScenarios()
	{
		AccountSetupCreation account = getPageFactory().acctSetupPage();

		account.clickNewUser();
		if (account.signUpPage())
		{
			account.selectAccountType("Brand");
			account.selectLicenseType("Enterprise");
			account.keyContactInfoPage();
			account.enterMobileOTP();
			account.clickNext();

			// Validate Back button
			account.isDisplayed(AccountSetupRepository.accountsetup_brandinfo);
			account.clickBack();
			account.isDisplayed(AccountSetupRepository.accountsetup_keyContact);
			account.clickNext();
			account.isDisplayed(AccountSetupRepository.accountsetup_brandinfo);

			// Verify Mandatory fields
			account.validateMandatoryField(AccountSetupRepository.accountsetup_brandinfo_mandatory, getData().ValidationMsg);
			account.parentCompany();
			account.brandCompany();
			account.preferedRegions();
			account.selectHeadQauter();
			account.enterWebsite();
			account.enterAddress();
			account.enterCity();
			account.enterZipCode();
			account.selectCountry();
			account.regionDropdown();
			account.selectIndustryType();
			account.businessType();
			account.brandPosition();
			account.isHybridSolution();

			// Upload Brand Images
			account.profilePictureUploadScenarios("Brand");
			account.clickNext();

			// Localization Settings
			account.isDisplayed(AccountSetupRepository.accountsetup_localSetting);
			account.isElementAvailable(AccountSetupRepository.accountsetup_localSetting_portletMap);
		}
	}

	// Localization Settings Scenarios
	@Test(testName = "", description = "Agency account - Localization Settings Scenarios")
	public void agencyAct_LocalizationScenarios()
	{
		AccountSetupCreation account = getPageFactory().acctSetupPage();

		account.clickNewUser();
		if (account.signUpPage())
		{
			account.selectAccountType("Agency");
			account.keyContactInfoPage();
			account.enterMobileOTP();
			account.clickNext();
			account.agencyDetailsPage();
			account.clickNext();

			// Validate Back button
			account.isDisplayed(AccountSetupRepository.accountsetup_localSetting);
			account.clickBack();
			account.isDisplayed(AccountSetupRepository.accountsetup_agencyDetails);
			account.clickNext();
			account.isDisplayed(AccountSetupRepository.accountsetup_localSetting);

			// Verify Mandatory fields
			account.validateMandatoryField(AccountSetupRepository.accountsetup_localSetting_mandatory, getData().ValidationMsg);
			account.localizationSettings();
			account.searchCharAndValiadteDropdown(AccountSetupRepository.accountsetup_localSetting_currency, "E");
			account.searchCharAndValiadteDropdown(AccountSetupRepository.accountsetup_localSetting_language, "T");
			account.searchCharAndValiadteDropdown(AccountSetupRepository.accountsetup_localSetting_dateFormat, "Y");
			account.searchCharAndValiadteDropdown(AccountSetupRepository.accountsetup_localSetting_timeFormat, "1");

		}
	}

	@Test(testName = "", description = "Resend OTP verification")
	public void otpResendCheck() throws InterruptedException
	{
		AccountSetupCreation ac = getPageFactory().acctSetupPage();

		ac.clickNewUser();
		ac.signUpPage();
		ac.selectAccountType("Brand");
		ac.selectLicenseType("Startup");
		ac.keyContactDetailsMandateFieldCheck();
		ac.javaScriptScrollDown();
		ac.clickBack();
		ac.isElementAvailable("License type portlet,xpath,//div[@class='rs-license-selection-page'][contains(.,'Startup')]");
		ac.selectLicenseType("Startup");
		ac.otpResnedCheck();
	}

	@Test(testName = "", description = "Admin console  Brand account validation")
	public void adminconsolevalidation() throws InterruptedException
	{
		AccountSetupCreation account = getPageFactory().acctSetupPage();

		account.clickNewUser();
		if (account.signUpPage())
		{
			account.selectAccountType("Brand");
			account.selectLicenseType("StartUp");
			account.keyContactInfoPage();
			account.enterMobileOTP();
			account.clickNext();
			account.brandDetailsStartUp();
			account.clickNext();
			account.localizationSettings();
			account.clickSubmit();
			account.thankyouPage();
			String username = AccountSetupCreation.getAcctStpEmailID();
			if (username != null)
			{
				// Admin Console
				String parentWind = account.parentWinHandle();
				account.javaScriptopenNewWindow();
				account.switchWindow();
				account.loginAdminConsole(account.getAdminConsoleUserName(), account.getAdminConsolePswd());
				account.adminconsoluivalidation("1 Month", "Monthly", "Immediate");
				account.switchParentWin(parentWind);
				// Account Activation
				account.login(username, account.dPropertyLoginPswrd());
				account.paymentPage("Invoice");
				account.thankyouPage();
				account.switchToSpecificWindow(1);
				account.accountActivation();
				account.switchParentWin(parentWind);
				String licenseKey = account.getAccountLicenseKey();
				account.login(username, account.dPropertyLoginPswrd());
				account.accountActivationPage(licenseKey);

				// Validate Launch Pad
				account.newAccountLaunchPad();
			}
		}
	}
}
