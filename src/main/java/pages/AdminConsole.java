package pages;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.microsoft.playwright.Page;

import repository.AccountSetupRepository;
import repository.ObjectRepository;
import utility.BaseTest;
import utility.PageFactory;

public class AdminConsole extends HomePage
{

	public AdminConsole(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	// ADMIN CONSOLE - SIGNIN
	public void loginAdminConsole(String username, String password)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("ADMIN CONSOLE - LOGIN PAGE", ExtentColor.ORANGE));
		launchAdminConsole();
		enterAdminUsername(username);
		enterAdminPswd(password);
		clickSignIn();
		enterOTP();
	}

	// Get into Admin console
	public void launchAdminConsole()
	{
		getWebURL(getAdminConsoleURL());
		isDisplayed(AccountSetupRepository.adminConsole_resul_logo);
	}

	// Fetch Admin console URL
	public static String getAdminConsoleURL()
	{
		return System.getProperty("AdminConsole_URL");
	}

	public void enterAdminUsername(String username)
	{
		if (isElementPresent(AccountSetupRepository.adminConsole_email))
		{
			enterValue(AccountSetupRepository.adminConsole_email, username);
			tabAction();
		}
	}

	public void enterAdminPswd(String password)
	{
		if (isElementPresent(AccountSetupRepository.adminConsole_password))
		{
			sendValues(AccountSetupRepository.adminConsole_password, password);
			tabAction();
		}
	}

	public void clickSignIn()
	{
		if (isElementAvailable(AccountSetupRepository.adminConsole_signIn))
		{
			clickElement(AccountSetupRepository.adminConsole_signIn);
		}
	}

	// OTP Screen
	public void enterOTP()
	{
		if (isDisplayed(AccountSetupRepository.adminConsole_otp))
		{
			// String pwind = parentWinHandle();
			// javaScriptopenNewWindow();
			// switchWindow();
			// String otpCode =
			// webURLlaunch().accountSetupWebmailLogin(getAdminConsoleUserName()).getSignUpOTP();
			String otpCode = getAdminConsoleDefaultOTP();
			if (otpCode != null)
			{
				// BaseTest.getWebDriver().close();
				// switchParentWin(pwind);
				int index = 0;
				for (WebElement input : findElements(AccountSetupRepository.adminConsole_otp))
				{
					input.sendKeys(String.valueOf(otpCode.charAt(index)));
					index++;
				}
				if (!isConfirm())
				{
					BaseTest.getTest().log(Status.FAIL, "Confirm button has disbaled");
					javaScriptHighLightwithScrnShot(AccountSetupRepository.adminConsole_otp_confirm);

				}
			}
		}
	}

	// Get Default OTP
	private static String getAdminConsoleDefaultOTP()
	{
		return System.getProperty("AdminConsole_DefaultOTP");
	}

	public boolean isConfirm()
	{
		if (!getTextBoxVal(AccountSetupRepository.adminConsole_otp_confirm, "class").contains("click-off"))
		{
			clickElement(AccountSetupRepository.adminConsole_otp_confirm);
			threadSleep(ObjectRepository.wait10sec);

			pageLoaderLogo();

			return isDisplayed(AccountSetupRepository.adminConsole_listingPage);
		}
		return false;
	}

	// Agency Account - Activation
	public void agencyAccountActivation()
	{
		// if (searchClient(getCompany()))
		{
			String acountType = StringUtils.substringBetween(actStpDetails.get("Account Type"), ">", "<");
			String username = AccountSetupCreation.getAcctStpEmailID();
			uiPageEqualswithInputValue(username, getStrText(AccountSetupRepository.adminConsole_listingPage_username));
			uiPageEqualswithInputValue(acountType, getStrText(AccountSetupRepository.adminConsole_listingPage_actType));
			if (acountType.contains("Agency"))
			{
				clickToggleSwitch2(acountType, username);
			}
		}
	}

	public void agencyAccountActivation2(String username)
	{
		// if (searchClient(getCompany()))
		{
			String acountType = StringUtils.substringBetween(actStpDetails.get("Account Type"), ">", "<");
			// String username = AccountSetupCreation.getAcctStpEmailID();
			uiPageEqualswithInputValue(username, getStrText(AccountSetupRepository.adminConsole_listingPage_username));
			uiPageEqualswithInputValue(acountType, getStrText(AccountSetupRepository.adminConsole_listingPage_actType));
			if (acountType.contains("Agency"))
			{
				clickToggleSwitch2(acountType, username);
			}
		}
	}

	// SEARCH - Client Name
	public boolean searchClient(String clientName)
	{
		pageLoaderLogo();
		if (isElementExist(AccountSetupRepository.adminConsole_listingPage_search))
		{
			String isSearchBox = getTextBoxVal(AccountSetupRepository.adminConsole_listingPage_search, "class");
			if (isSearchBox.contains("open"))
			{
				clickElement(AccountSetupRepository.adminConsole_listingPage_searchClose);
			}
			clickElement(AccountSetupRepository.adminConsole_listingPage_search);
			enterValue(AccountSetupRepository.adminConsole_listingPage_searchInput, clientName);
			clickElement(AccountSetupRepository.adminConsole_listingPage_searchafter);
			explicitwaitforvisibility(autolocator(AccountSetupRepository.adminConsole_listingPage_firstindex), 20);
			return isDisplayed(replacePlaceHolder(AccountSetupRepository.adminConsole_listingPage_clientname, clientName));
		}
		return false;
	}

	public void clickExpandIcon()
	{
		String costIcon = replacePlaceHolder(AccountSetupRepository.adminConsole_detailedView_costIcon, AccountSetupCreation.getAcctStpEmailID());
		String expandIcon = replacePlaceHolder(AccountSetupRepository.adminConsole_listingPage_plusicon, AccountSetupCreation.getAcctStpEmailID());
		actionsClickElement(expandIcon);
		explicitwaitforvisibility(autolocator(costIcon), 20);
	}

	public void clickCost(String Commitment, String frequency, String paymentterms)
	{
		String costIcon = replacePlaceHolder(AccountSetupRepository.adminConsole_detailedView_costIcon, AccountSetupCreation.getAcctStpEmailID());
		if (isElementAvailable(costIcon))
		{
			clickElement(costIcon);
			explicitwaitforvisibility(autolocator(AccountSetupRepository.adminConsole_detailedView_subscriptionGrid), 30);
			uiPageEqualswithInputValue("Pricing", getStrText(AccountSetupRepository.adminConsole_Accountpage_pricingpage));
			clickElement(AccountSetupRepository.adminConsole_Accountpage_pricingpage_Commitment_dropdown);
			selectlistelements(AccountSetupRepository.adminConsole_Accountpage_pricingpage_commondropdownlist, Commitment); // 1 Month
			clickElement(AccountSetupRepository.adminConsole_Accountpage_pricingpage_frequency_dropdown);
			selectlistelements(AccountSetupRepository.adminConsole_Accountpage_pricingpage_commondropdownlist, frequency); // Monthly
			clickElement(AccountSetupRepository.adminConsole_Accountpage_pricingpage_paymentterms_dropdown);
			selectlistelements(AccountSetupRepository.adminConsole_Accountpage_pricingpage_commondropdownlist, paymentterms); // Immediate
			clickElement(",xpath,//input[@name='saleprice']");
			clearField(",xpath,//input[@name='saleprice']");
			enterValue(",xpath,//input[@name='saleprice']", "1800");

			javaScriptScrollDown();
			threadSleep(ObjectRepository.wait3sec);
			javaScriptScrollDown();
			clickElement(AccountSetupRepository.adminConsole_cost_save);
			threadSleep(ObjectRepository.wait1sec);

			javaScriptScrollDown();
			threadSleep(ObjectRepository.wait3sec);
			javaScriptScrollDown();
//			if (isElementPresent("validation message,xpath,//div[@class='validation-message']"))
//			{
			clickElement(AccountSetupRepository.adminConsole_cost_termsAndContdCheckBox);
			threadSleep(ObjectRepository.wait2sec);
			clickElement(AccountSetupRepository.adminConsole_cost_save);
			threadSleep(ObjectRepository.wait1sec);

			// }
		}
	}

	public void clickResendKey()
	{
		if (isElementAvailable(AccountSetupRepository.adminConsole_detailedView_keyIcon))
		{
			clickElement(AccountSetupRepository.adminConsole_detailedView_keyIcon);
		}
	}

	public void verifyAccountDetails()
	{
		// Search
		String acountType = StringUtils.substringBetween(actStpDetails.get("Account Type"), ">", "<");
		// if (searchClient(getCompany()))
		{
			String username = AccountSetupCreation.getAcctStpEmailID();
			boolean isClientNameExist = false;
			for (WebElement webElement : findElements(AccountSetupRepository.adminConsole_listingPage_username))
			{
				String clinetName = webElement.getText().trim();
				if (clinetName.equals(username))
				{
					isClientNameExist = true;
					break;
				}
			}
			writeLog(isClientNameExist, username + " ---> Client name found in the listing page", username + " -- > Client name not found in listing page");
			String licenseType = actStpDetails.get("License Type").toLowerCase();
			uiPageEqualswithInputValue(acountType, getStrText(AccountSetupRepository.adminConsole_listingPage_actType));
			if (acountType.equals("Agency") || licenseType.equalsIgnoreCase("Enterprise"))
			{
				clickExpandIcon();
				clickCost("1 Month", "Monthly", "Immediate");
			} else
			{

				accountpricing("1 Month", "Monthly", "Immediate");
			}
		}
	}

	public void accountActivation()
	{
		javaScriptopenNewWindow();
		switchWindow();
		loginAdminConsole(getAdminConsoleUserName(), getAdminConsolePswd());
		String acountType = StringUtils.substringBetween(actStpDetails.get("Account Type"), ">", "<");
		String licenseType = actStpDetails.get("License Type");
		refresh();
		threadSleep(ObjectRepository.wait5sec);
		// searchClient(getCompany());
		if (acountType.equals("Agency") || licenseType.equals("Enterprise"))
		{
			clickExpandIcon();
		}
		clickToggleSwitch(clientName);
	}

	public void accountActivation2()
	{
		javaScriptopenNewWindow();
		switchWindow();
		loginAdminConsole(getAdminConsoleUserName(), getAdminConsolePswd());
		String acountType = StringUtils.substringBetween(actStpDetails.get("Account Type"), ">", "<");
		String licenseType = actStpDetails.get("License Type");
		refresh();
		threadSleep(ObjectRepository.wait5sec);
		// searchClient(getCompany());
		if (acountType.equals("Agency") || licenseType.equals("Enterprise"))
		{
			clickExpandIcon();
		}
		clickToggleSwitch(clientName);
	}

	public void clickToggleSwitch(String placeHolder)
	{
		pageLoaderLogo();
		String toggleSwitch = replacePlaceHolder(AccountSetupRepository.adminConsole_detailedView_toggleBtn, placeHolder);

		if (isElementAvailable(toggleSwitch))
		{
			// String toggle = getTextBoxVal(toggleSwitch, "class");
			String toggle = getTextBoxVal(toggleSwitch, "aria-checked");
			// if (toggle.contains("switch-off")) {
			if (toggle.contains("false"))
			{
				clickElement(toggleSwitch);
				threadSleep(ObjectRepository.wait2sec);
				if (actStpDetails.get("Account Type").contains("Agency") && !actStpDetails.containsKey("License Type"))
				{
					refresh();
					threadSleep(ObjectRepository.wait2sec);
					pageLoaderLogo();
				}
				String toggleSwitchON = replacePlaceHolder(AccountSetupRepository.adminConsole_detailedView_toggleON, placeHolder);
				isDisplayed(toggleSwitchON);
			}
		}

	}

	public void clickToggleSwitch2(String placeHolder, String place2)
	{
		pageLoaderLogo();
		String toggleSwitch = replacePlaceHolder2(AccountSetupRepository.adminConsole_detailedView_toggleBtn2, placeHolder);
		toggleSwitch = toggleSwitch.replace("PLACE2", place2);
		if (isElementAvailable(toggleSwitch))
		{
			String toggle = getTextBoxVal(toggleSwitch, "class");
			if (toggle.contains("switch-off"))
			{
				clickElement(toggleSwitch);

				threadSleep(ObjectRepository.wait2sec);
				if (actStpDetails.get("Account Type").contains("Agency") && !actStpDetails.containsKey("License Type"))
				{
					refresh();
					threadSleep(ObjectRepository.wait10sec);
					pageLoaderLogo();
				}
				String toggleSwitchON = replacePlaceHolder(AccountSetupRepository.adminConsole_detailedView_toggleON, placeHolder);
				isDisplayed(toggleSwitchON);
			}
		}

	}

	public String getCompany()
	{
		String acountType = StringUtils.substringBetween(actStpDetails.get("Account Type"), ">", "<");
		if (acountType.contains("Agency"))
		{
			System.out.println("Account Type: " + acountType);

			return agencyCompany;

		} else if (acountType.contains("Brand"))
		{
			String licenseType = actStpDetails.get("License Type");
			System.out.println("License Type: " + actStpDetails.get("License Type"));

			if (licenseType.equals("Enterprise"))
			{
				return parentCompany;
			}
			return clientName;
		}
		return null;
	}

	public void accountpricing(String Commitment, String frequency, String paymentterms)
	{
		String dropdownarrow = replacePlaceHolder(AccountSetupRepository.adminConsole_detailedView_dropdownarrow, AccountSetupCreation.getAcctStpEmailID());
		String pricing = replacePlaceHolder(AccountSetupRepository.adminConsole_detailedView_dropdown_pricing_details, AccountSetupCreation.getAcctStpEmailID());

		if (isElementAvailable(dropdownarrow))
		{
			clickElement(dropdownarrow);
			clickElement(pricing);
			pageLoaderLogo();
			explicitwaitforvisibility(autolocator(AccountSetupRepository.adminConsole_detailedView_subscriptionGrid), 30);
			uiPageEqualswithInputValue("Pricing", getStrText(AccountSetupRepository.adminConsole_Accountpage_pricingpage));
			clickElement(AccountSetupRepository.adminConsole_Accountpage_pricingpage_Commitment_dropdown);
			selectlistelements(AccountSetupRepository.adminConsole_Accountpage_pricingpage_commondropdownlist, Commitment); // 1 Month
			clickElement(AccountSetupRepository.adminConsole_Accountpage_pricingpage_frequency_dropdown);
			selectlistelements(AccountSetupRepository.adminConsole_Accountpage_pricingpage_commondropdownlist, frequency); // Monthly
			clickElement(AccountSetupRepository.adminConsole_Accountpage_pricingpage_paymentterms_dropdown);
			selectlistelements(AccountSetupRepository.adminConsole_Accountpage_pricingpage_commondropdownlist, paymentterms); // Immediate
			clickElement(",xpath,//input[@name='saleprice']");
			clearField(",xpath,//input[@name='saleprice']");
			enterValue(",xpath,//input[@name='saleprice']", "1800");

			javaScriptScrollDown();
			threadSleep(ObjectRepository.wait3sec);
			javaScriptScrollDown();
			clickElement(AccountSetupRepository.adminConsole_cost_save);
			threadSleep(ObjectRepository.wait1sec);

			javaScriptScrollDown();
			threadSleep(ObjectRepository.wait3sec);
			javaScriptScrollDown();
			if (isElementPresent("validation message,xpath,//div[@class='validation-message']"))
			{
				clickElement(AccountSetupRepository.adminConsole_cost_termsAndContdCheckBox);
				threadSleep(ObjectRepository.wait2sec);
				clickElement(AccountSetupRepository.adminConsole_cost_save);
				threadSleep(ObjectRepository.wait1sec);

			}

		}
		return;
	}

	public void adminconsoluivalidation(String Commitment, String frequency, String paymentterms)
	{

		// Search
		String acountType = StringUtils.substringBetween(actStpDetails.get("Account Type"), ">", "<");
		// if (searchClient(getCompany()))

		String username = AccountSetupCreation.getAcctStpEmailID();
		boolean isClientNameExist = false;
		for (WebElement webElement : findElements(AccountSetupRepository.adminConsole_listingPage_username))
		{
			String clinetName = webElement.getText().trim();
			if (clinetName.equals(username))
			{
				isClientNameExist = true;
				break;
			}
		}
		writeLog(isClientNameExist, username + " ---> Client name found in the listing page", username + " -- > Client name not found in listing page");
		String licenseType = actStpDetails.get("License Type").toLowerCase();
		uiPageEqualswithInputValue(acountType, getStrText(AccountSetupRepository.adminConsole_listingPage_actType));

		if (acountType.equals("Agency") || licenseType.equalsIgnoreCase("Enterprise"))
		{

			/////////////// need to develop////////////////
			clickExpandIcon();
			String[] Agencyicons = { "", "Health check", "Settings", "Preview", "Pricing details", "License key" };

			for (int j = 1; j <= 5; j++)
			{
				toolTipValidationKnownText(",xpath,(//div[contains(@class,'communication-list')]/descendant::p[.='" + username + "']//ancestor::div[@class='rs-communication-list']//i)[" + j + "]", Agencyicons[j]);

			}
			String costIcon = replacePlaceHolder(AccountSetupRepository.adminConsole_detailedView_costIcon, AccountSetupCreation.getAcctStpEmailID());
			if (isElementAvailable(costIcon))
			{
				clickElement(costIcon);
				explicitwaitforvisibility(autolocator(AccountSetupRepository.adminConsole_detailedView_subscriptionGrid), 30);
				costingpagevalidation(Commitment, frequency, paymentterms);

			} else
			{
				// admin console
				String value = getTextBoxVal((replacePlaceHolder(AccountSetupRepository.adminConsole_Activationbutton, username)), "aria-checked");

				writeLog(value.equals("false"), "Admin console account activation button is disabled", "Admin console account activation button is enabled before account activation");

				String[] brandicons = { "", "Health check", "Settings", "Preview", "Actions" };

				for (int j = 1; j <= 4; j++)
				{
					toolTipValidationKnownText(",xpath,(//div[contains(@class,'communication-list')]/descendant::p[.='" + username + "']//ancestor::div[@class='rs-communication-list']//i)[" + j + "]", brandicons[j]);

				}

				String dropdownarrow = replacePlaceHolder(AccountSetupRepository.adminConsole_detailedView_dropdownarrow, AccountSetupCreation.getAcctStpEmailID());
				String pricing = replacePlaceHolder(AccountSetupRepository.adminConsole_detailedView_dropdown_pricing_details, AccountSetupCreation.getAcctStpEmailID());
				String licensekey = replacePlaceHolder(AccountSetupRepository.adminConsole_Accountgate_actions_licensekey, username);

				if (isElementAvailable(dropdownarrow))
				{
					clickElement(dropdownarrow);

					if (isElementAvailable(licensekey))
					{
						BaseTest.getTest().log(Status.INFO, "license key is disabled before account activation");
						clickElement(pricing);
						pageLoaderLogo();
						explicitwaitforvisibility(autolocator(AccountSetupRepository.adminConsole_detailedView_subscriptionGrid), 30);
						costingpagevalidation(Commitment, frequency, paymentterms);

					}
				}
			}

		}
	}

	public void costingpagevalidation(String Commitment, String frequency, String paymentterms)
	{
		uiPageEqualswithInputValue("Pricing", getStrText(AccountSetupRepository.adminConsole_Accountpage_pricingpage));
		clickElement(AccountSetupRepository.adminConsole_Accountpage_pricingpage_Commitment_dropdown);
		selectlistelements(AccountSetupRepository.adminConsole_Accountpage_pricingpage_commondropdownlist, Commitment); // 1
																														// Month
		clickElement(AccountSetupRepository.adminConsole_Accountpage_pricingpage_frequency_dropdown);
		selectlistelements(AccountSetupRepository.adminConsole_Accountpage_pricingpage_commondropdownlist, frequency); // Monthly
		clickElement(AccountSetupRepository.adminConsole_Accountpage_pricingpage_paymentterms_dropdown);
		selectlistelements(AccountSetupRepository.adminConsole_Accountpage_pricingpage_commondropdownlist, paymentterms); // Immediate
		clickElement(",xpath,//input[@name='saleprice']");
		clearField(",xpath,//input[@name='saleprice']");
		enterValue(",xpath,//input[@name='saleprice']", "1800");

		javaScriptScrollDown();
		threadSleep(ObjectRepository.wait3sec);
		javaScriptScrollDown();
		clickElement(AccountSetupRepository.adminConsole_cost_save);
		threadSleep(ObjectRepository.wait1sec);

		javaScriptScrollDown();
		threadSleep(ObjectRepository.wait3sec);
		javaScriptScrollDown();
		if (isElementPresent("validation message,xpath,//div[@class='validation-message']"))
		{
			clickElement(AccountSetupRepository.adminConsole_cost_termsAndContdCheckBox);
			threadSleep(ObjectRepository.wait2sec);
			clickElement(AccountSetupRepository.adminConsole_cost_save);
			threadSleep(ObjectRepository.wait1sec);

		}
		return;
	}

}

//
//uiPageEqualswithInputValue("Pricing", getStrText(AccountSetupRepository.adminConsole_Accountpage_pricingpage));
//clickElement(AccountSetupRepository.adminConsole_Accountpage_pricingpage_Commitment_dropdown);
//selectlistelements(AccountSetupRepository.adminConsole_Accountpage_pricingpage_commondropdownlist, Commitment); // 1 Month
//clickElement(AccountSetupRepository.adminConsole_Accountpage_pricingpage_frequency_dropdown);
//selectlistelements(AccountSetupRepository.adminConsole_Accountpage_pricingpage_commondropdownlist, frequency); // Monthly
//clickElement(AccountSetupRepository.adminConsole_Accountpage_pricingpage_paymentterms_dropdown);
//selectlistelements(AccountSetupRepository.adminConsole_Accountpage_pricingpage_commondropdownlist, paymentterms); // Immediate
//clickElement(",xpath,//input[@name='saleprice']");
//clearField(",xpath,//input[@name='saleprice']");
//enterValue(",xpath,//input[@name='saleprice']", "1800");
//
//javaScriptScrollDown();
//threadSleep(ObjectRepository.wait3sec);
//javaScriptScrollDown();
//clickElement(AccountSetupRepository.adminConsole_cost_save);
//threadSleep(ObjectRepository.wait1sec);
//
//javaScriptScrollDown();
//threadSleep(ObjectRepository.wait3sec);
//javaScriptScrollDown();
//if (isElementPresent("validation message,xpath,//div[@class='validation-message']"))
//{
//	clickElement(AccountSetupRepository.adminConsole_cost_termsAndContdCheckBox);
//	threadSleep(ObjectRepository.wait2sec);
//	clickElement(AccountSetupRepository.adminConsole_cost_save);
//	threadSleep(ObjectRepository.wait1sec);
//
//}