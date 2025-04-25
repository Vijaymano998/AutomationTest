package pages;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.microsoft.playwright.Page;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import repository.AccountSetupRepository;
import repository.CommunicationRepository;
import repository.DashboardRepository;
import repository.LoginRepository;
import repository.ObjectRepository;
import repository.OtpRepository;
import repository.PreferencesRepository;
import utility.BaseTest;
import utility.DataInputProvider;
import utility.ExtentManager;
import utility.PageBase;
import utility.PageFactory;

public class AccountSetupCreation extends AdminConsole
{
	private static List<Object> encryptedExistingUsers = new ArrayList<>();
	private static Map<String, String> encrypted = new LinkedHashMap<>();
	private String brandCompany;
	private List<String> licenseTypeSpecs = new ArrayList<>();
	private static Set<String> nonExistingUsers = new LinkedHashSet<>();
	private static Set<String> existingUsers = new LinkedHashSet<>();
	private String placeHolder = "/..//label";
	private String testData = System.getProperty("Max_Character");
	private String dropdownplaceHolder = "//ancestor::span[contains(@class,'label-container')]//span[@class='k-label']";

	public AccountSetupCreation(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	// ACCOUNT SETUP - CREATE A NEW USER
	public static void setAcctStpEmailID(String emailID)
	{
		if (emailID != null)
		{
			acctStpEmailID.put(Thread.currentThread().getId(), emailID);
		}
	}

	public static String getAcctStpEmailID()
	{
		return newUsers.get(Thread.currentThread().getId());
	}

	public static void setNewUserID(String emailID)
	{
		if (emailID != null)
		{
			newUsers.put(Thread.currentThread().getId(), emailID);
			System.out.println(getAcctStpEmailID());
		}
	}

	public static boolean isEmailThreadExist(String testData)
	{
		if (acctStpEmailID != null)
		{
			return acctStpEmailID.containsValue(testData);
		}
		return false;
	}

	public boolean isSegmentLoaded()
	{
		boolean isLoading = false;
		javaScriptPageLoad();
		fluentWait(30, AccountSetupRepository.accountsetup_mail_loader);
		while (!isLoading)
		{
			if (!isElementPresent(AccountSetupRepository.accountsetup_mail_loader))
			{
				isLoading = true;
				break;
			}
		}
		return isLoading;
	}

	public void classifyUsers(List<Object> encryptedUsersFromDB, Map<String, String> dataSet)
	{
		if (!encryptedUsersFromDB.isEmpty())
		{
			for (Map.Entry<String, String> entry : dataSet.entrySet())
			{
				if (encryptedUsersFromDB.contains(entry.getValue()))
				{
					existingUsers.add(entry.getKey());
				} else
				{
					nonExistingUsers.add(entry.getKey());
				}
			}
		}
	}

	// Get All Unquie Existing users
	public Set<String> getExistingUsers()
	{
		return existingUsers;
	}

	// Get All Unquie Non-Existing users
	public Set<String> getNonExistingUsers()
	{
		return nonExistingUsers;
	}

	public boolean signUpPage()
	{
		boolean flag = false;
		fetchExistingUsersFromDB();
		for (String emailID : getNonExistingUsers())
		{
//			emailID = "resuluser199@resul.team";
			if (!isEmailThreadExist(emailID))
			{

				setAcctStpEmailID(emailID);
				sendvalueAndTabAction(BaseTest.getWebDriver(), AccountSetupRepository.accountsetup_enteremail, emailID);
				isSegmentLoaded();
				String validationMsg = getStrText(AccountSetupRepository.accountsetup_mailmsg);
				if (!validationMsg.contains("Email already exist") && !getTextBoxVal(AccountSetupRepository.accountsetup_mailmsg, "class").contains("errorContainer"))
				{
					setNewUserID(emailID);
					BaseTest.getTest().info("Entered Email ID is  ---> <b>" + emailID + "</b>");
					accSetupOtpValidate(emailID);
//					int result = captchaHandle();
					// enterValue(AccountSetupRepository.accountsetup_entercaptchavalue,
					// Integer.toString(result)).tabAction();
					if (!isSelected(AccountSetupRepository.accountsetup_agreetermsselect))
					{
						actionsClickElement(AccountSetupRepository.accountsetup_agreetermsselect);
						BaseTest.takeScreenshot();
					}
					clickSignUp();
					flag = true;
					break;
				} else
				{
					clearField(AccountSetupRepository.accountsetup_enteremail);
				}
//				clickSignUp();
				flag = true;
				// break;
			} else
			{
				clearField(AccountSetupRepository.accountsetup_enteremail);
			}
		}
		// }
		if (!flag)
		{
			BaseTest.getTest().log(Status.WARNING, "Entered Email ID already exist");
			BaseTest.takeScreenshot();
		}
		return flag;
	}

	public void accSetupOtpValidate(String emailID)
	{
		javaScriptopenNewWindow();
		String pwind = parentWinHandle();
		switchWindow();
		String otp = webURLlaunch().accountSetupWebmailLogin(emailID).getSignUpOTP();
		if (otp != null)
		{
			clickElement(LoginRepository.login_itkt_webmaillogout_button);
			childWindowClose(pwind);
			entersOTPAndSubmit(otp, "accsetup");
		}
	}

	public String getRandomEmail()
	{
		return "resul" + addTimeToName().replace("_", "") + "@resulticksmail.com";
	}

	// ACCOUNT SETUP - MATH CAPTCHA HANDLE
	public int captchaHandle()
	{
		if (isElementAvailable(AccountSetupRepository.accountsetup_captchamsg))
		{
			explicitwaitforpresence(autolocator(AccountSetupRepository.accountsetup_captchamsg), 20);
		}
		// explicitwaitforpresence(autolocator(AccountSetupRepository.accountsetup_captchamsg),
		// 20);
		int result = 0;
		if (isElementAvailable(AccountSetupRepository.accountsetup_captchamsg))
		{
			String[] numCaptchaValue = getStrText(AccountSetupRepository.accountsetup_captchavalue).split(" ");

			int splitval1 = Integer.parseInt(numCaptchaValue[0]);
			String operator = numCaptchaValue[1];
			int splitval2 = Integer.parseInt(numCaptchaValue[2]);
			switch (operator)
			{
			case "+":
				result = splitval1 + splitval2;
				break;

			case "-":
				result = splitval1 - splitval2;
				break;

			case "x":
				result = splitval1 * splitval2;
				break;

			case "*":
				result = splitval1 * splitval2;
				break;

			case "/":
				result = splitval1 / splitval2;
				break;

			default:
				BaseTest.getTest().warning("Unexpected Invalid Math Operator : " + operator);
				break;
			}
		}
		return result;
	}

	// Sign-up button
	public AccountSetupCreation clickSignUp()
	{
		if (isDisplayed(AccountSetupRepository.accountsetup_clicksignupbutton))
		{
			clickElement(AccountSetupRepository.accountsetup_clicksignupbutton);
			javaScriptPageLoad();
		}
		return this;
	}

	public void profilePicUpload(String imagePath)
	{

		if (isElementAvailable(AccountSetupRepository.accountsetup_brandinfo_profile))
		{
			String pathGrid = detectFilePath(imagePath);
			sendValue(AccountSetupRepository.accountsetup_brandinfo_uploadlogo, pathGrid);
			threadSleep(ObjectRepository.wait3sec);
			BaseTest.takeScreenshot();
			// isElementAvailable(AccountSetupRepository.accountsetup_brandinfo_removeProfile);
		}
	}

	// ACCOUNT SETUP - SELECT ACCOUNT TYPE PAGE
	public void selectAccountType(String accType)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel(" ACCOUNT SETUP - SELECT ACCOUNT TYPE ", ExtentColor.INDIGO));
		explicitwaitforclick(autolocator(AccountSetupRepository.accountsetup_agencyaccount), 50);
		uiPageEqualswithInputValue("Select an account type", getStrText(AccountSetupRepository.accountsetup_selectaccounttype));
		if (accType.equalsIgnoreCase("Agency"))
		{
			isDisplayed(AccountSetupRepository.accountsetup_agencyaccount);
			clickElement(AccountSetupRepository.accountsetup_agencyaccount);
		} else if (accType.equalsIgnoreCase("Brand"))
		{
			isDisplayed(AccountSetupRepository.accountsetup_brandaccount);
			clickElement(AccountSetupRepository.accountsetup_brandaccount);
		}
		actStpDetails.put("Account Type", "<b>" + accType + "</b>");
	}

	// ACCOUNT SETUP - SELECT LICENSE TYPE
	public void selectLicenseType(String licType)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel(" ACCOUNT SETUP - SELECT LICENSE TYPE ", ExtentColor.INDIGO));
		explicitwaitforvisibility(autolocator(AccountSetupRepository.accountsetup_selectlicensetype), 20);
		String locator = replacePlaceHolder(AccountSetupRepository.accountsetup_licenseType, licType.toLowerCase());
		if (isDisplayed(locator))
		{
			javaScriptScrollDown();
			String accountPrice = getStrText(replacePlaceHolder(AccountSetupRepository.accountsetup_license_pricetag, licType.toLowerCase()));
			clickElement(findElement(locator + "//button"), "<b>" + licType.toUpperCase() + "</b> Plan Button");

			actStpDetails.put("License Type", licType);
			actStpDetails.put("Price", "USD " + accountPrice);
		}
		BaseTest.getTest().info(licType + " Account - Specifications are listed below,");
		ExtentManager.customReport(actStpDetails);
	}

	public int getLicenseTypeAmount(String licenseType)
	{
		String licenseAmount;
		switch (licenseType)
		{
		case "Startup":
		{
			licenseAmount = System.getProperty("Startup_Amount");
			licenseTypeSpecs = Arrays.asList("Dashboard", "Communication summary report", "Adv. behavioural segmentation", "Upto 50K audience");
			break;
		}
		case "Professional":
		{
			licenseAmount = System.getProperty("PRO_Amount");
			licenseTypeSpecs = Arrays.asList("Multi-dimensional communication", "Benchmark, trend comparison reports", "Vanity / Custom URLs", "Hackproof security + free features", "Upto 500K audience");
			break;
		}
		case "Enterprise":
		{
			licenseAmount = System.getProperty("Enterprise_Amount");
			licenseTypeSpecs = Arrays.asList("Reporting across all geographies", "Audience analytics 360", "Military grade security + Pro features", "Upto 5 Mn audience");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + licenseType);
		}
		return Integer.parseInt(licenseAmount);
	}

	public void validateLicenseTypePage()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel(" ACCOUNT SETUP - SELECT LICENSE TYPE ", ExtentColor.INDIGO));
		Map<String, String> license = new HashMap<>();
		explicitwaitforvisibility(autolocator(AccountSetupRepository.accountsetup_selectlicensetype), 20);
		int index = 0;
		for (WebElement element : findElements(AccountSetupRepository.accountsetup_licenseTypes))
		{
			if (element.isDisplayed())
			{
				javaScriptHighLightwithScrnShot(element);
				String licenseType = element.getText().trim();
				BaseTest.getTest().info("The <b>" + licenseType + " license </b>  type has displayed, As Expected");
				String price = findElements(AccountSetupRepository.accountsetup_licensePriceTag).get(index).getText().trim();
				int amount = getLicenseTypeAmount(licenseType);
				if (amount != Integer.parseInt(price.replaceAll("\\D", "")))
				{
					BaseTest.getTest().fail("<b>" + licenseType + " price Actual : " + price + ", Expected : " + amount);
				}
				List<WebElement> specs = findElements(replacePlaceHolder(AccountSetupRepository.accountsetup_license_specs, licenseType.toLowerCase()));
				for (int i = 0; i < specs.size(); i++)
				{
					uiPageEqualswithInputValue(licenseTypeSpecs.get(i), specs.get(i).getText());
				}
				license.put(licenseType, "USD " + price);
				index++;
			}
		}
		BaseTest.getTest().info("The License Type - Specifications are listed below,");
		ExtentManager.customReport(license);

	}

	// ACCOUNT SETUP - KEY CONTACT INFO
	public AccountSetupCreation keyContactInfoPage()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel(" ACCOUNT SETUP - KEY CONTACT DETAILS", ExtentColor.INDIGO));
		explicitwaitforvisibility(autolocator(AccountSetupRepository.accountsetup_keyContact), 30);
		if (isDisplayed(AccountSetupRepository.accountsetup_keyContact))
		{
			String firstName = "QA Automation ";
			String lastName = "Team";
			clickElement(AccountSetupRepository.accountsetup_selectTitle);
			selectexactlistelements(AccountSetupRepository.accountsetup_dropdownOptions, "Mr.");
			enterValue(AccountSetupRepository.accountsetup_firstname, firstName);
			enterValue(AccountSetupRepository.accountsetup_lastname, lastName);
			clickElement(AccountSetupRepository.accountsetup_jobfunction_click);
			selectlistelements(AccountSetupRepository.accountsetup_dropdownOptions, BaseTest.getData().userJobFunction);

			// Entered valid Password
			enterPassword();
			enterConfirmPassword();

			// Upload Brand info Image
			uploadProfile(BaseTest.curr_Dir + "/src/main/resources/data/uploadfiles/PNG file upload.png");
		}
		return this;
	}

	public void uploadProfile(String path)
	{
		if (isElementAvailable(AccountSetupRepository.accountsetup_brandinfo_profile))
		{
			// tooltip
			mouseHover(AccountSetupRepository.accountsetup_brandinfo_uploadlogo);
			// uiPageEqualswithInputValue("Upload company logo",
			// getStrText(AccountSetupRepository.accountsetup_tooltip));
			sendValue(AccountSetupRepository.accountsetup_brandinfo_uploadlogo, detectFilePath(path));
			isDisplayed(AccountSetupRepository.accountsetup_brandinfo_removeProfile);
		}
	}

	public boolean enterMobileOTP()
	{
		clickElement(AccountSetupRepository.accountsetup_countryCode);
		selectlistelements(AccountSetupRepository.accountsetup_countrycodelist, "India+91");
		sendValues(AccountSetupRepository.accountsetup_mobileno, BaseTest.getData().MobileNo);
		tabAction();
		explicitwaitforvisibility(autolocator(AccountSetupRepository.accountsetup_keycontactInfo_otpPopup), 30);
		if (isElementAvailable(AccountSetupRepository.accountsetup_keycontactInfo_otpPopup))
		{
			clickElement(OtpRepository.otppage_confirmbtn);
			explicitwaitforclick(autolocator(AccountSetupRepository.accountsetup_keycontactInfo_enterOneTimePassword), 20);
			pageLoaderLogo();
			if (isDisplayed(AccountSetupRepository.accountsetup_keycontactInfo_enterOneTimePassword))
			{
				String pwind = parentWinHandle();
				javaScriptopenNewWindow();
				switchWindow();
				String otpCode = webURLlaunch().accountSetupWebmailLogin(getAcctStpEmailID()).getSignUpOTP();
				if (otpCode != null)
				{
					clickElement(LoginRepository.login_itkt_webmaillogout_button);
					childWindowClose(pwind);
					int index = 0;
					for (WebElement input : findElements(AccountSetupRepository.accountsetup_keycontactInfo_OTP))
					{
						input.sendKeys(String.valueOf(otpCode.charAt(index)));
						index++;
					}
					BaseTest.getTest().info("Entered OTP is ---> " + otpCode);
					explicitwaitforvisibility(autolocator(AccountSetupRepository.accountsetup_keyContact), 30);
					return true;
				}
			}
		}
		return false;
	}

	public AccountSetupCreation enterPassword()
	{
		if (isElementAvailable(AccountSetupRepository.accountsetup_pswd))
		{
			clickElement(AccountSetupRepository.accountsetup_pswd);
			enterValue(AccountSetupRepository.accountsetup_pswd, dPropertyLoginPswrd()).tabAction();;
			String passwordStrength = getTextBoxVal(PreferencesRepository.preferences_Users_passwordfieldStrength, "class");
			if (!passwordStrength.contains("100"))
			{
				BaseTest.getTest().log(Status.FAIL, "Entered invalid password");
			}
			clickElement(AccountSetupRepository.accountsetup_pswdViewIcon);
			isElementAvailable(AccountSetupRepository.accountsetup_pswd);
		}
		return this;
	}

	public AccountSetupCreation enterConfirmPassword()
	{
		if (isElementAvailable(AccountSetupRepository.accountsetup_confirmpwsd))
		{
			enterValue(AccountSetupRepository.accountsetup_confirmpwsd, dPropertyLoginPswrd()).tabAction();;
			String passwordStrength = getTextBoxVal(PreferencesRepository.preferences_Users_ConfirmPswdStrength, "class");
			if (!passwordStrength.contains("100"))
			{
				BaseTest.getTest().log(Status.FAIL, "Entered invalid password");
			}
			clickElement(AccountSetupRepository.accountsetup_ConfirmpswdViewIcon);
		}
		return this;
	}

	public boolean clickNext()
	{
		boolean flag = false;
		if (isElementExist(AccountSetupRepository.accountsetup_Nextbutton))
		{
			javaScriptScrollDown();
			clickElement(AccountSetupRepository.accountsetup_Nextbutton);
			flag = true;
		}
		return flag;
	}

	public AccountSetupCreation clickBack()
	{
		if (isElementAvailable(AccountSetupRepository.accountsetup_Backbutton))
		{
			clickElement(AccountSetupRepository.accountsetup_Backbutton);
		}
		return this;
	}

	public boolean clickSave()
	{
		boolean flag = false;
		if (isElementExist(AccountSetupRepository.accountsetup_savebrandinfo))
		{
			javaScriptScrollDown();
			clickElement(AccountSetupRepository.accountsetup_savebrandinfo);
			flag = true;
		}
		return flag;
	}

	public boolean clickProceed()
	{
		boolean flag = false;
		if (isElementExist(AccountSetupRepository.accountsetup_assignRole_proceed))
		{
			javaScriptScrollDown();
			clickElement(AccountSetupRepository.accountsetup_assignRole_proceed);
			flag = true;
		}
		return flag;
	}

	// ACCOUNT SETUP - AGENCY DETAILS
	public AccountSetupCreation agencyDetailsPage()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel(" ACCOUNT SETUP - AGENCY DETAILS ", ExtentColor.INDIGO));
		explicitwaitforvisibility(autolocator(AccountSetupRepository.accountsetup_agencyDetails), 30);
		if (isDisplayed(AccountSetupRepository.accountsetup_agencyDetails))
		{
			enterValue(AccountSetupRepository.accountsetup_agencyDetails_group, "QA_Test_AgencyGroups" + addTimeToName().replace("_", "")).tabAction();
			isElementAvailable(AccountSetupRepository.accountsetup_agencyDetails_helpdesk);
			enterValue(AccountSetupRepository.accountsetup_agencyDetails_address, BaseTest.getData().Address).tabAction();
			agencyCompany = "QA_Test_Agency" + addTimeToName().replace("_", "");
			enterValue(AccountSetupRepository.accountsetup_agencyDetails_name, agencyCompany).tabAction();
			enterValue(AccountSetupRepository.accountsetup_agencyDetails_city, BaseTest.getData().City).tabAction();
			enterValue(AccountSetupRepository.accountsetup_agencyDetails_zipCode, BaseTest.getData().ZipCode).tabAction();
			enterValue(AccountSetupRepository.accountsetup_agencyDetails_website, BaseTest.getData().SmartLink).tabAction();
			explicitwaitforclick(autolocator(AccountSetupRepository.accountsetup_agencyDetails_countryDropdown), 30);
			actionsClickElement(AccountSetupRepository.accountsetup_agencyDetails_countryDropdown);
			selectlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, BaseTest.getData().Country);

			// Upload - AGENCY Logo
			uploadProfile(BaseTest.curr_Dir + "/src/main/resources/data/uploadfiles/PNG file upload.png");
		}
		return this;
	}

	// BRAND DETAILS - STARTUP
	public AccountSetupCreation brandDetailsStartUp()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("BRAND DETAILS - STARTUP ACCOUNT", ExtentColor.INDIGO));
		if (isDisplayed(AccountSetupRepository.accountsetup_brandinfo))
		{
			clientName = "QA_Test_" + addTimeToName().replace("_", "");
			enterValue(AccountSetupRepository.accountsetup_brandinfo_company, clientName).tabAction();
			enterValue(AccountSetupRepository.accountsetup_brandinfo_website, BaseTest.getData().SmartLink).tabAction();
			enterValue(AccountSetupRepository.accountsetup_brandinfo_address, BaseTest.getData().Address).tabAction();
			enterValue(AccountSetupRepository.accountsetup_brandinfo_city, BaseTest.getData().City).tabAction();
			enterValue(AccountSetupRepository.accountsetup_brandinfo_zipCode, BaseTest.getData().ZipCode).tabAction();
			clickElement(AccountSetupRepository.accountsetup_brandinfo_country);
			selectlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, BaseTest.getData().Country);
			clickElement(AccountSetupRepository.accountsetup_brandinfo_industrytype);
			selectlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, BaseTest.getData().Industry);
			clickElement(AccountSetupRepository.accountsetup_brandinfo_businesstype);
			selectexactlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, BaseTest.getData().BusinessType);
			clickElement(AccountSetupRepository.accountsetup_brandinfo_brandposition);
			selectlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, BaseTest.getData().BrandPosition);

			// Upload Brand info Image
			uploadProfile(BaseTest.curr_Dir + "/src/main/resources/data/uploadfiles/PNG file upload.png");
		}
		return this;
	}

	// BRAND DETAILS - PRO
	public AccountSetupCreation brandDetailsPRO()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("BRAND DETAILS - PRO ACCOUNT", ExtentColor.INDIGO));
		if (isDisplayed(AccountSetupRepository.accountsetup_brandinfo))
		{
			clientName = "QA_Test_" + addTimeToName().replace("_", "");
			enterValue(AccountSetupRepository.accountsetup_brandinfo_company, clientName).tabAction();
			enterValue(AccountSetupRepository.accountsetup_brandinfo_website, BaseTest.getData().SmartLink).tabAction();
			enterValue(AccountSetupRepository.accountsetup_brandinfo_address, BaseTest.getData().Address).tabAction();;
			enterValue(AccountSetupRepository.accountsetup_brandinfo_city, BaseTest.getData().City).tabAction();;
			enterValue(AccountSetupRepository.accountsetup_brandinfo_zipCode, BaseTest.getData().ZipCode).tabAction();
			clickElement(AccountSetupRepository.accountsetup_brandinfo_country);
			selectlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, BaseTest.getData().Country);
			clickElement(AccountSetupRepository.accountsetup_brandinfo_industrytype);
			selectlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, BaseTest.getData().Industry);
			clickElement(AccountSetupRepository.accountsetup_brandinfo_businesstype);
			selectexactlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, BaseTest.getData().BusinessType);
			clickElement(AccountSetupRepository.accountsetup_brandinfo_brandposition);
			selectlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, BaseTest.getData().BrandPosition);

			// Upload Brand info Image
			uploadProfile(BaseTest.curr_Dir + "/src/main/resources/data/uploadfiles/PNG file upload.png");

		}
		return this;
	}

	// BRAND DETAILS - ENTERPRISE
	public AccountSetupCreation brandDetailsEnterprise()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("BRAND DETAILS - ENTERPRISE ACCOUNT", ExtentColor.INDIGO));
		if (isDisplayed(AccountSetupRepository.accountsetup_brandinfo))
		{
			parentCompany = "QA_Test_GROUPS_" + addTimeToName().replace("_", "");
			enterValue(AccountSetupRepository.accountsetup_brandinfo_parentcompyname, parentCompany).tabAction();
			clickElement(AccountSetupRepository.accountsetup_brandinfo_preferredRegions);
			selectlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, BaseTest.getData().PreferredRegions);
			clientName = "QA_Test_" + addTimeToName().replace("_", "");
			enterValue(AccountSetupRepository.accountsetup_brandinfo_company, clientName).tabAction();
			clickElement(AccountSetupRepository.accountsetup_brandinfo_headquarters);
			selectlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, BaseTest.getData().Headquarters);
			enterValue(AccountSetupRepository.accountsetup_brandinfo_website, BaseTest.getData().SmartLink).tabAction();
			enterValue(AccountSetupRepository.accountsetup_brandinfo_address, BaseTest.getData().Address).tabAction();
			enterValue(AccountSetupRepository.accountsetup_brandinfo_city, BaseTest.getData().City).tabAction();
			enterValue(AccountSetupRepository.accountsetup_brandinfo_zipCode, BaseTest.getData().ZipCode).tabAction();
			explicitwaitforclick(autolocator(AccountSetupRepository.accountsetup_brandinfo_country), 30);
			actionsClickElement(AccountSetupRepository.accountsetup_brandinfo_country);
			selectlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, BaseTest.getData().Country);
			clickElement(AccountSetupRepository.accountsetup_brandinfo_region);
			selectlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, BaseTest.getData().Region);
			clickElement(AccountSetupRepository.accountsetup_brandinfo_industrytype);
			selectlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, BaseTest.getData().Industry);
			clickElement(AccountSetupRepository.accountsetup_brandinfo_businesstype);
			selectexactlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, BaseTest.getData().BusinessType);
			clickElement(AccountSetupRepository.accountsetup_brandinfo_brandposition);
			selectlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, BaseTest.getData().BrandPosition);

			// Upload Brand info Image
			uploadProfile(BaseTest.curr_Dir + "/src/main/resources/data/uploadfiles/PNG file upload.png");

		}
		return this;
	}

	public String getClientName()
	{

		String acountType = actStpDetails.get("Account Type").split(">")[1].split("<")[0].trim();
		if (acountType.contains("Agency") && clientName == null)
		{
			return agencyCompany;
		}
		return clientName;
	}

	public String getParentCompany()
	{
		return parentCompany;
	}

	// LOCALIZATION SETTINGS PAGE
	public AccountSetupCreation localizationSettings()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel(" ACCOUNT SETUP - LOCALIZATION SETTING ", ExtentColor.INDIGO));
		explicitwaitforvisibility(autolocator(AccountSetupRepository.accountsetup_localSetting), 30);
		if (isDisplayed(AccountSetupRepository.accountsetup_localSetting))
		{
			// Currency
			boolean isCurrencySelected = getStrText(AccountSetupRepository.accountsetup_localSetting_currency).equals("Indian rupee");
			writeLog(isCurrencySelected, "Currency dropdown auto prefilled, As expected", "Currenct dropdown not auto prefilled");
			clickElement(AccountSetupRepository.accountsetup_localSetting_currency);
			selectlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, "Indian rupee");

			// Language
			boolean isLangSelected = getStrText(AccountSetupRepository.accountsetup_localSetting_language).equals("English (US)");
			writeLog(isLangSelected, "Language dropdown auto prefilled, As expected", "Language dropdown not auto prefilled");
			clickElement(AccountSetupRepository.accountsetup_localSetting_language);
			selectlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, "English (US)");

			// Date format
			boolean isDateSelected = getStrText(AccountSetupRepository.accountsetup_localSetting_dateFormat).equals("DD-MM-YYYY");
			writeLog(isDateSelected, "Date Format dropdown auto prefilled, As expected", "Date Format dropdown not auto prefilled");
			clickElement(AccountSetupRepository.accountsetup_localSetting_dateFormat);
			selectlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, "DD-MM-YYYY");

			// Time Format
			clickElement(AccountSetupRepository.accountsetup_localSetting_timeFormat);
			selectlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, "24 hours");

			// Time Zone
			boolean isTimeZoneSelected = getStrText(AccountSetupRepository.accountsetup_localSetting_timeZone).equals("(GMT+05:30) Chennai, Kolkata, Mumbai, New Delhi");
			writeLog(isTimeZoneSelected, "Time Zone dropdown auto prefilled, As expected", "Time Zone dropdown not auto prefilled");
			clickElement(AccountSetupRepository.accountsetup_localSetting_timeZone);
			selectlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, "(GMT+05:30) Chennai, Kolkata, Mumbai, New Delhi");

			// PORTLET MAP
			if (isElementAvailable(AccountSetupRepository.accountsetup_localSetting_portletMap))
			{
				String country = getStrText(AccountSetupRepository.accountsetup_localSetting_Maplocation);
				uiPageEqualswithInputValue("India", country);
				isDisplayed(AccountSetupRepository.accountsetup_localSetting_Maplocation);
			}
		}
		return this;
	}

	// ACCOUNT SETUP - PAYMENT & ACTIVATION PAGE
	public AccountSetupCreation paymentPage(String option)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel(" PAYMENT & ACTIVATION PAGE ", ExtentColor.INDIGO));

		explicitwaitforvisibility(autolocator(AccountSetupRepository.accountsetup_paymentActivation), 30);
		if (isDisplayed(AccountSetupRepository.accountsetup_paymentActivation))
		{
			uiPageEqualswithInputValue("Payment & activation", getStrText(AccountSetupRepository.accountsetup_paymentActivation));
			paymentOption(option);
			clickConfirmBtn();
			// clickElement(AccountSetupRepository.accountsetup_payment_pay);
		}
		return this;
	}

	public AccountSetupCreation paymentOption(String option)
	{
		isElementAvailable(AccountSetupRepository.accountsetup_paymentMethod);
		if (selectlistelements(AccountSetupRepository.accountsetup_paymentOptions, option))
		{
			if (option.equalsIgnoreCase("Credit card"))
			{
				isElementAvailable(AccountSetupRepository.accountsetup_payment_descreption);
				enterValue(CommunicationRepository.communicationpage_payment_cardnumber, "4111111111111111").tabAction();
				enterValue(CommunicationRepository.communication_payment_cardname, "QA Automation").tabAction();
				enterValue(CommunicationRepository.communication_payment_month, "06").tabAction();
				enterValue(CommunicationRepository.communication_payment_year, "2025").tabAction();
				enterValue(CommunicationRepository.communication_payment_cvv, "123").tabAction();

			} else if (option.equalsIgnoreCase("Paypal"))
			{
				isElementAvailable(AccountSetupRepository.accountsetup_payment_descreption);

			} else if (option.equalsIgnoreCase("Invoice"))
			{
				isElementAvailable(AccountSetupRepository.accountsetup_payment_descreption);
				clickElement(AccountSetupRepository.accountsetup_payment_Ok);
				// getTextBoxVal(AccountSetupRepository.accountsetup_payment_pay,
				// "class").contains("click-off")

				// Enter Authentication token
				if (isElementExist(AccountSetupRepository.accountsetup_payment_authenticationCode))
				{
					Set<String> oldWindows = driver.getWindowHandles();
					String pwind = parentWinHandle();
					javaScriptopenNewWindow();
					switchToNewWindow(oldWindows);
					String authorizationCode = webURLlaunch().accountSetupWebmailLogin(getAcctStpEmailID()).getAuthorizationCode();
					if (authorizationCode != null)
					{
						BaseTest.getWebDriver().close();
						switchParentWin(pwind);
						enterValue(AccountSetupRepository.accountsetup_payment_authenticationCode, authorizationCode).tabAction();
						explicitwaitforclick(autolocator(AccountSetupRepository.accountsetup_payment_validKey), 30);
						isDisplayed(AccountSetupRepository.accountsetup_payment_validKey);
					}
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Payment button activated without requiring the Authentication Code");
				}
			}
			BaseTest.getTest().log(Status.INFO, "Payment Transaction has been completed sucessfully...!");
		}
		return this;

	}

	// ACCOUNT SETUP - PAYMENT THANK YOU PAGE
	public AccountSetupCreation thankyouPage()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel(" ACCOUNT SETUP - THANK YOU PAGE ", ExtentColor.INDIGO));
		explicitwaitforvisibility(autolocator(AccountSetupRepository.accountsetup_thankyouPage_thumbsup), 120);
		if (isDisplayed(AccountSetupRepository.accountsetup_thankyouPage_thumbsup))
		{

			if (getStrText(AccountSetupRepository.accountsetup_thankyouPage_text).equalsIgnoreCase("Thank you for signing up!"))

			{
				uiPageEqualswithInputValue("Thank you for signing up!", getStrText(AccountSetupRepository.accountsetup_thankyouPage_text));
				String thumbsup = getTextBoxVal(AccountSetupRepository.accountsetup_thankyouPage_thumbsup, "class");

				// Thumbsup color validation element not present

//				if (thumbsup.contains("green")) {
//					BaseTest.getTest().log(Status.INFO,
//							"<b>'Thumbs-up'</b> log is displayed in green color, As expected");
//				} else {
//					BaseTest.getTest().log(Status.FAIL,
//							"<b>'Thumbs-up'</b> log isn't displayed in green color, As expected");
//				}
				pageLoaderLogo();
				explicitwaitforclick(autolocator(LoginRepository.loginpage_newusertab), 120);
			} else if (getStrText(AccountSetupRepository.accountsetup_thankyouPage_text).equalsIgnoreCase("Thank you for setting up your account."))
			{
				uiPageEqualswithInputValue("Thank you for setting up your account.", getStrText(AccountSetupRepository.accountsetup_thankyouPage_text));
				String thumbsup = getTextBoxVal(AccountSetupRepository.accountsetup_thankyouPage_thumbsup, "class");

				// Thumbsup color validation element not present

//				if (thumbsup.contains("green")) {   
//					BaseTest.getTest().log(Status.INFO,
//							"<b>'Thumbs-up'</b> log is displayed in green color, As expected");
//				} else {
//					BaseTest.getTest().log(Status.FAIL,
//							"<b>'Thumbs-up'</b> log isn't displayed in green color, As expected");
//				}

				isElementAvailable(AccountSetupRepository.accountsetup_thankyouPage_supportmail);
				pageLoaderLogo();
				explicitwaitforclick(autolocator(LoginRepository.loginpage_Login_btn), 120);
			}
		}
		return this;
	}

	public String getAccountLicenseKey()
	{
		Set<String> windowHandles = driver.getWindowHandles();
		String parentWindow = parentWinHandle();
		threadSleep(ObjectRepository.wait2sec);
		javaScriptopenNewWindow();
		switchToNewWindow(windowHandles);
		webURLlaunch().accountSetupWebmailLogin(getAcctStpEmailID());
		String name = getClientName();

		String licenseKey = getLicenseKey(name);
//		clickElement(LoginRepository.login_itkt_webmaillogout_button);
//		BaseTest.getWebDriver().close();
		switchParentWin(parentWindow);
//		driver.get(System.getProperty("web_url"));
		threadSleep(ObjectRepository.wait2sec);
		return licenseKey;
	}

	public AccountSetupCreation accountActivationPage(String licenseKey)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel(" ACCOUNT ACTIVATION PAGE ", ExtentColor.INDIGO));
		explicitwaitforpresence(autolocator(AccountSetupRepository.accountsetup_activationPage_header), 90);
		if (isDisplayed(AccountSetupRepository.accountsetup_activationPage_licenseKey))
		{
			uiPageEqualswithInputValue("Activate your account", getStrText(AccountSetupRepository.accountsetup_activationPage_header));
			if (licenseKey != null)
			{
				int index = 0;
				for (WebElement input : findElements(AccountSetupRepository.accountsetup_activationPage_licenseKeyInput))
				{
					input.sendKeys(licenseKey.split("-")[index]);
					index++;
				}
				BaseTest.getTest().info("Entered License Key : <b>" + licenseKey + "</b>");
				explicitwaitforvisibility(autolocator(AccountSetupRepository.accountsetup_otpSucessMsg), 20);
				if (getTextBoxVal(AccountSetupRepository.accountsetup_otpSucessMsg, "class").contains("success"))
				{
					uiPageEqualswithInputValue("Key validated successfully", getStrText(AccountSetupRepository.accountsetup_otpSucessMsg));
					javaScriptScrollDown();
					if (isElementAvailable(AccountSetupRepository.accountsetup_Submitbutton))
					{
						clickElement(AccountSetupRepository.accountsetup_Submitbutton);
					}
				}
			}
		}
		return this;
	}

	public AccountSetupCreation clickSubmit()
	{
		javaScriptScrollDown();
		if (isElementAvailable(AccountSetupRepository.accountsetup_Submitbutton))
		{
			try
			{
				jscriptclick(AccountSetupRepository.accountsetup_Submitbutton);
				explicitwaitforvisibility(autolocator(AccountSetupRepository.accountsetup_thankyouPage_thumbsup), 120);
			} catch (Exception e)
			{
				jscriptclick(AccountSetupRepository.accountsetup_Submitbutton);
			}
		}
		return this;
	}

	// NEW ACCOUNT - LAUNCH PAD SCREEN
	public AccountSetupCreation newAccountLaunchPad()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel(" NEW ACCOUNT - LANCH PAD ", ExtentColor.INDIGO));
		try
		{
			explicitwaitforvisibility(autolocator(AccountSetupRepository.accountsetup_launchPad_menus), 30);
		} catch (Exception e)
		{
			refresh();
			explicitwaitforvisibility(autolocator(AccountSetupRepository.accountsetup_launchPad_menus), 30);
		}
		uiPageEqualswithInputValue("Manage all your communication with a click", getStrText(AccountSetupRepository.accountsetup_launchPad_header));
		if (isDisplayed(AccountSetupRepository.accountsetup_launchPad_menus))
		{
			uiPageEqualswithMultipleInputValue(AccountSetupRepository.accountsetup_launchPad_menus, "Import audience,Create a communication,View analytics,Data exchange,Form builder,Data catalogue,Audience score");
			BaseTest.takeScreenshot();
			BaseTest.getTest().info("New Account - Specifications are listed out below,");
			ExtentManager.customReport(actStpDetails);
		}
		return this;
	}

	public boolean isdropdownAlphabeticOrder(String locator)
	{
		List<String> str = new ArrayList<>();
		explicitwaitforclick(autolocator(locator), 30);
		for (WebElement options : findElements(locator))
		{
			String option = options.getText();
			str.add(option);
			if (!Character.isUpperCase(option.charAt(0)))
			{
				BaseTest.getTest().log(Status.INFO, "Frist letter isn't upperCase");
			}
		}
		List<String> sort = new ArrayList<>(str);
		Collections.sort(sort);
		if (!sort.equals(str))
		{
			BaseTest.getTest().log(Status.INFO, BaseTest.logName + " drop-down list is <b> Alphabetic Ordered </b>");
			return true;
		} else
		{
			BaseTest.getTest().log(Status.FAIL, BaseTest.logName + " drop-down list is not <b> Alphabetic Ordered </b>");
			BaseTest.takeScreenshot();
			return false;
		}
	}

	public AccountSetupCreation paymentActivationNegativeScenarios()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("PAYMENT & ACTIVATION PAGE", ExtentColor.BROWN));
		explicitwaitforvisibility(autolocator(AccountSetupRepository.accountsetup_paymentActivation), 30);
		isElementAvailable(AccountSetupRepository.accountsetup_marketingstar_logo);
		uiPageEqualswithInputValue("Payment & activation", getStrText(AccountSetupRepository.accountsetup_paymentActivation));
		if (isDisplayed(CommunicationRepository.communication_payment_container))
		{
			String creditCard = getTextBoxVal(CommunicationRepository.communicationpage_payment_creditcard, "class");
			String paypal = getTextBoxVal(CommunicationRepository.communicationpage_payment_paypal, "class");

			if (creditCard.contains("active") && paypal.contains("click-off"))
			{
				String errorMsg = "//../..//preceding-sibling::div[@class='validation-message']";
				clickElement(AccountSetupRepository.accountsetup_payment_paynow);
				BaseTest.takeScreenshot();
				uiPageEqualswithInputValue(CommunicationRepository.communicationpage_payment_Errmsg, "Enter number on card,Enter name on card,Enter month,Enter year,Enter cvv");

				// Card Number
				enterValue(CommunicationRepository.communicationpage_payment_cardnumber, "12345").tabAction();
				uiPageEqualswithInputValue(CommunicationRepository.communicationpage_payment_cardnumber + errorMsg, "Invalid credit card number");

				List<String> testDatas = Arrays.asList("QA Automation", "*&^%$#!2A", "QA8203", "1235QA", "#$!234RESUL");
				for (String data : testDatas)
				{
					enterValue(CommunicationRepository.communicationpage_payment_cardnumber, data);
					tabAction();
					String value = getTextBoxVal(CommunicationRepository.communicationpage_payment_cardnumber, "value").replaceAll("-", "");

					// Check input field accepting alpha or any Special character
					if (value.matches(".*[a-zA-Z\\p{P}].*"))
					{
						BaseTest.getTest().log(Status.FAIL, "Card number field accepting given input '" + data + "' not as Expected");
						javaScriptHighLightwithScrnShot(CommunicationRepository.communicationpage_payment_cardnumber);
					}
					uiPageEqualswithInputValue(CommunicationRepository.communicationpage_payment_cardnumber + errorMsg, "Invalid credit card number");
					clearField(CommunicationRepository.communicationpage_payment_cardnumber);
				}

				// Validate Card Type
				Map<String, String> cardDetails = new LinkedHashMap<>();
				cardDetails.put("2223000048400011", "icon_master");
				cardDetails.put("4111111111111111", "icon_visa");
				for (Map.Entry<String, String> entry : cardDetails.entrySet())
				{
					String cardNumber = entry.getKey();
					String type = entry.getValue();

					clearField(CommunicationRepository.communicationpage_payment_cardnumber);
					enterValue(CommunicationRepository.communicationpage_payment_cardnumber, cardNumber);
					tabAction();
					String cardType = getTextBoxVal(CommunicationRepository.communicationpage_payment_cardtype, "src");
					String maskedCard = getTextBoxVal(CommunicationRepository.communicationpage_payment_cardnumber, "value");
					uiPageEqualswithInputValue(maskedCard, "XXXX-XXXX-XXXX-" + cardNumber.substring(cardNumber.length() - 4, cardNumber.length()));
					if (!cardType.contains(type))
					{
						BaseTest.getTest().log(Status.FAIL, "Actual: " + cardType + "Expected: " + type);
					}
				}

				// Card Name
				clickElement(AccountSetupRepository.accountsetup_payment_paynow);
				uiPageEqualswithInputValue(CommunicationRepository.communication_payment_cardname + errorMsg, "Enter name on card");

				enterValue(CommunicationRepository.communication_payment_cardname, "8203*&%$#!");
				if (!getTextBoxVal(CommunicationRepository.communication_payment_cardname, "value").isEmpty())
				{
					BaseTest.getTest().log(Status.FAIL, "Name field accepting given input 'Special Characters' not as Expected");
					javaScriptHighLightwithScrnShot(CommunicationRepository.communication_payment_cardname);
				}
				checkInputBoxLength(CommunicationRepository.communication_payment_cardname, System.getProperty("Char_field"), 100);
				enterValue(CommunicationRepository.communication_payment_cardname, "QA Automation");
				tabAction();

				// Month Field
				clickElement(AccountSetupRepository.accountsetup_payment_paynow);
				uiPageEqualswithInputValue(CommunicationRepository.communication_payment_month + errorMsg, "Enter month");
				enterValue(CommunicationRepository.communication_payment_month, "8203*&%$@");
				if (!getTextBoxVal(CommunicationRepository.communication_payment_month, "value").matches(".*\\d.*"))
				{
					BaseTest.getTest().log(Status.FAIL, "Month field accepting 'Special Characters' not as Expected");
					javaScriptHighLightwithScrnShot(CommunicationRepository.communication_payment_month);
				}
				clearField(CommunicationRepository.communication_payment_month);
				enterValue(CommunicationRepository.communication_payment_month, "15");
				uiPageEqualswithInputValue(CommunicationRepository.communication_payment_month + errorMsg, "Enter valid month");
				enterValue(CommunicationRepository.communication_payment_month, "06").tabAction();

				// Year Field
				clickElement(AccountSetupRepository.accountsetup_payment_paynow);
				uiPageEqualswithInputValue(CommunicationRepository.communication_payment_year + errorMsg, "Enter year");
				enterValue(CommunicationRepository.communication_payment_year, "8203*&%$#");
				if (!getTextBoxVal(CommunicationRepository.communication_payment_year, "value").matches(".*\\d.*"))
				{
					BaseTest.getTest().log(Status.FAIL, "Year field accepting 'Special Characters' not as Expected");
					javaScriptHighLightwithScrnShot(CommunicationRepository.communication_payment_year);
				}
				clearField(CommunicationRepository.communication_payment_year);
				enterValue(CommunicationRepository.communication_payment_year, "1997").tabAction();
				uiPageEqualswithInputValue(CommunicationRepository.communication_payment_year + errorMsg, "Your card expired");
				clearField(CommunicationRepository.communication_payment_year);
				enterValue(CommunicationRepository.communication_payment_year, "2075").tabAction();
				uiPageEqualswithInputValue(CommunicationRepository.communication_payment_year + errorMsg, "Enter year below 2074");
				clearField(CommunicationRepository.communication_payment_year);
				enterValue(CommunicationRepository.communication_payment_year, "2025").tabAction();

				// CVV Number
				enterValue(CommunicationRepository.communication_payment_cvv, "8203*!%$#");
				if (!getTextBoxVal(CommunicationRepository.communication_payment_cvv, "value").matches(".*\\d.*"))
				{
					BaseTest.getTest().log(Status.FAIL, "CVV field accepting 'Special Characters' not as Expected");
					javaScriptHighLightwithScrnShot(CommunicationRepository.communication_payment_cvv);
				}
				enterValue(CommunicationRepository.communication_payment_cvv, "12").tabAction();
				uiPageEqualswithInputValue(CommunicationRepository.communicationpage_payment_Errmsg, "Need 3 digits");
				clearField(CommunicationRepository.communication_payment_cvv);
				enterValue(CommunicationRepository.communication_payment_cvv, "8203").tabAction();
				String masked = getStrText(CommunicationRepository.communication_payment_cvv);
				System.out.println(masked);
				BaseTest.takeScreenshot();

			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Credit Card payment mode hasn't enabled as Expected");
				BaseTest.takeScreenshot();
			}
		}
		return this;
	}

	// Verify Mandatory field
	public AccountSetupCreation validateMandatoryField(String mandatoryFields, String placeholders)
	{
		List<String> orderList = new ArrayList<>();
		String header = getStrText(AccountSetupRepository.accountsetup_pageheader);
		BaseTest.getTest().info(MarkupHelper.createLabel("ACCOUNT SETUP - " + header.toUpperCase() + " PAGE", ExtentColor.INDIGO));
		boolean flag = true;
		String[] mandatory = placeholders.split(",");
		for (int count = 0; count < mandatory.length; count++)
		{
			String inputData = mandatory[count];
			String field = findElements(mandatoryFields).get(count).getText().trim();

			if (!inputData.equals(field))
			{
				BaseTest.getTest().log(Status.FAIL, "There is no required Mandatory red mark on <b>" + inputData + "</b> field");
				javaScriptHighLightwithScrnShot(findElements(mandatoryFields).get(count));
				flag = false;
			}
			orderList.add(field);
		}
		if (flag)
		{
			BaseTest.getTest().log(Status.INFO, "Below listed outs are <b> Mandatory Fields </b> on " + header + " page, As Expected");
			BaseTest.getTest().log(Status.PASS, MarkupHelper.createOrderedList(orderList));
			BaseTest.takeScreenshot();
		}
		// validate Next Button
		if (isElementPresent(AccountSetupRepository.accountsetup_Nextbutton))
		{
			javaScriptScrollDown();
			clickElement(AccountSetupRepository.accountsetup_Nextbutton);
			BaseTest.getTest().log(Status.FAIL, "Next button is enabled, Even if the Mandatory fields are not filled out");
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public void searchCharAndValiadteDropdown(String dropdown, String character)
	{
		clickElement(dropdown);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.SHIFT, character).build().perform();
		threadSleep(ObjectRepository.wait2sec);
		if (getStrText(dropdown).startsWith(character))
		{
			BaseTest.getTest().log(Status.INFO, "Searching keyward " + character + " has auto-selected, As Expected");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Searching keyward " + character + " doesn't auto-selected");
			javaScriptHighLightwithScrnShot(dropdown);
		}
	}

	// BRAND DETALIS SCENARIOS
	public String parentCompany()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("PARENT COMPANY", ExtentColor.INDIGO));
		enterValue(AccountSetupRepository.accountsetup_brandinfo_parentcompyname, "").tabAction();
		uiPageEqualswithInputValue("Enter parent company", getStrText(AccountSetupRepository.accountsetup_brandinfo_parentcompyname + placeHolder));

		enterValue(AccountSetupRepository.accountsetup_brandinfo_parentcompyname, "QA").tabAction();
		uiPageEqualswithInputValue("Min. 3 characters", getStrText(AccountSetupRepository.accountsetup_brandinfo_parentcompyname + placeHolder));

		hasContainsSpecialChar(AccountSetupRepository.accountsetup_brandinfo_parentcompyname, "test comp356AB#&#");
		checkInputBoxLength(AccountSetupRepository.accountsetup_brandinfo_parentcompyname, testData, 255);
		parentCompany = "RESUL GROUP" + addTimeToName().replace("_", "");
		enterValue(AccountSetupRepository.accountsetup_brandinfo_parentcompyname, "Resulticks").enterTabAction();
		isSegmentLoaded();
		uiPageEqualswithInputValue("Client Name already exists", getStrText(AccountSetupRepository.accountsetup_brandinfo_parentcompyname + placeHolder));
		removeText(AccountSetupRepository.accountsetup_brandinfo_parentcompyname);

		enterValue(AccountSetupRepository.accountsetup_brandinfo_company, testData).enterTabAction();
		enterValue(AccountSetupRepository.accountsetup_brandinfo_parentcompyname, testData).enterTabAction();
		uiPageEqualswithInputValue("Child company should not be same as parent", getStrText(AccountSetupRepository.accountsetup_brandinfo_parentcompyname + placeHolder));
		removeText(AccountSetupRepository.accountsetup_brandinfo_company);
		removeText(AccountSetupRepository.accountsetup_brandinfo_parentcompyname);
		enterValue(AccountSetupRepository.accountsetup_brandinfo_parentcompyname, parentCompany).enterTabAction();
		explicitwaitforpresence(PageBase.autolocator(AccountSetupRepository.accountsetup_inputBox_tickmark), 20);
		return parentCompany;
	}

	// Agency Group
	public String agencyGroup()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("AGENCY GROUP", ExtentColor.INDIGO));

		agencyGroup = "RESUL GROUP" + addTimeToName().replace("_", "");
		enterValue(AccountSetupRepository.accountsetup_agencyDetails_group, "").enterTabAction();
		uiPageEqualswithInputValue("Enter agency group", getStrText(AccountSetupRepository.accountsetup_agencyDetails_group + placeHolder));

		enterValue(AccountSetupRepository.accountsetup_agencyDetails_group, "QA").enterTabAction();
		uiPageEqualswithInputValue("Min. 3 characters", getStrText(AccountSetupRepository.accountsetup_agencyDetails_group + placeHolder));

		boolean hasContainsSpecialChar = hasContainsSpecialChar(AccountSetupRepository.accountsetup_agencyDetails_group, "test comp356AB#&#");
		writeLog(hasContainsSpecialChar, "<b Agency Group /> Field accepting special characters", "Agency Group fields not accepting special characters");

		checkInputBoxLength(AccountSetupRepository.accountsetup_agencyDetails_group, System.getProperty("Max_Character"), 255);
		removeText(AccountSetupRepository.accountsetup_agencyDetails_group);
		enterValue(AccountSetupRepository.accountsetup_agencyDetails_group, "Resulticks").enterTabAction();
		isSegmentLoaded();
		uiPageEqualswithInputValue("Client Name already exists", getStrText(AccountSetupRepository.accountsetup_agencyDetails_group + placeHolder));
		javaScriptHighLightwithScrnShot(AccountSetupRepository.accountsetup_agencyDetails_group + placeHolder);
		removeText(AccountSetupRepository.accountsetup_agencyDetails_group);

		agencyCompany = "Agency Test" + addTimeToName().replace("_", "");
		enterValue(AccountSetupRepository.accountsetup_agencyDetails_name, agencyCompany).enterTabAction();
		isSegmentLoaded();
		enterValue(AccountSetupRepository.accountsetup_agencyDetails_group, agencyCompany).enterTabAction();
		uiPageEqualswithInputValue("Parent & child companies must differ", getStrText(AccountSetupRepository.accountsetup_agencyDetails_group + placeHolder));
		removeText(AccountSetupRepository.accountsetup_agencyDetails_name);
		removeText(AccountSetupRepository.accountsetup_agencyDetails_group);

		// Valid Agency Group name
		enterValue(AccountSetupRepository.accountsetup_agencyDetails_group, agencyGroup).enterTabAction();
		explicitwaitforpresence(PageBase.autolocator(AccountSetupRepository.accountsetup_inputBox_tickmark), 20);
		return agencyGroup;
	}

	public String agencyCompany()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("AGENCY COMPANY FIELD", ExtentColor.INDIGO));
		agencyCompany = "RESUL " + addTimeToName().replace("_", "");
		enterValue(AccountSetupRepository.accountsetup_agencyDetails_name, "").enterTabAction();
		uiPageEqualswithInputValue("Enter agency name", getStrText(AccountSetupRepository.accountsetup_agencyDetails_name + placeHolder));

		enterValue(AccountSetupRepository.accountsetup_agencyDetails_name, "QA").enterTabAction();
		uiPageEqualswithInputValue("Min. 3 characters", getStrText(AccountSetupRepository.accountsetup_agencyDetails_name + placeHolder));

		boolean hasContainsSpecialChar = hasContainsSpecialChar(AccountSetupRepository.accountsetup_agencyDetails_name, "test comp356AB#&#");
		writeLog(hasContainsSpecialChar, "<b Agency Company /> Field accepting special characters", "Agency Company fields not accepting special characters");

		checkInputBoxLength(AccountSetupRepository.accountsetup_agencyDetails_name, System.getProperty("Max_Character"), 255);
		removeText(AccountSetupRepository.accountsetup_agencyDetails_name);
		enterValue(AccountSetupRepository.accountsetup_agencyDetails_name, "Resulticks").enterTabAction();
		isSegmentLoaded();
		uiPageEqualswithInputValue("Client Name already exists", getStrText(AccountSetupRepository.accountsetup_agencyDetails_name + placeHolder));
		javaScriptHighLightwithScrnShot(AccountSetupRepository.accountsetup_agencyDetails_name + placeHolder);
		removeText(AccountSetupRepository.accountsetup_agencyDetails_name);

		// Enter Agency Company as Group name
		enterValue(AccountSetupRepository.accountsetup_agencyDetails_name, agencyGroup).enterTabAction();
		isSegmentLoaded();
		uiPageEqualswithInputValue("Parent & child companies must differ", getStrText(AccountSetupRepository.accountsetup_agencyDetails_name + placeHolder));
		// Valid Agency Company
		enterValue(AccountSetupRepository.accountsetup_agencyDetails_name, agencyCompany).enterTabAction();
		return agencyCompany;
	}

	public String brandCompany()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("COMPANY FIELD", ExtentColor.INDIGO));

		brandCompany = "RESUL " + addTimeToName().replace("_", "");
		enterValue(AccountSetupRepository.accountsetup_brandinfo_company, "").enterTabAction();
		uiPageEqualswithInputValue("Enter company", getStrText(AccountSetupRepository.accountsetup_brandinfo_company + placeHolder));

		enterValue(AccountSetupRepository.accountsetup_brandinfo_company, "QA").enterTabAction();
		uiPageEqualswithInputValue("Min. 3 characters", getStrText(AccountSetupRepository.accountsetup_brandinfo_company + placeHolder));

		hasContainsSpecialChar(AccountSetupRepository.accountsetup_brandinfo_company, "test comp356AB#&#");
		checkInputBoxLength(AccountSetupRepository.accountsetup_brandinfo_company, System.getProperty("Max_Character"), 255);
		removeText(AccountSetupRepository.accountsetup_brandinfo_company);
		enterValue(AccountSetupRepository.accountsetup_brandinfo_company, "Resulticks").enterTabAction();
		isSegmentLoaded();
		uiPageEqualswithInputValue("Client Name already exists", getStrText(AccountSetupRepository.accountsetup_brandinfo_company + placeHolder));
		javaScriptHighLightwithScrnShot(AccountSetupRepository.accountsetup_brandinfo_company + placeHolder);
		// For Enterprise account only
		if (actStpDetails.get("License Type").equals("Enterprise"))
		{
			enterValue(AccountSetupRepository.accountsetup_brandinfo_company, testData).enterTabAction();
			uiPageEqualswithInputValue("Child company should not be same as parent", getStrText(AccountSetupRepository.accountsetup_brandinfo_company + placeHolder));
		}
		enterValue(AccountSetupRepository.accountsetup_brandinfo_company, brandCompany).enterTabAction();
		return brandCompany;
	}

	// Prefered Regions dropdown
	public void preferedRegions()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("PREFERED REGIONS DROPDOWN", ExtentColor.INDIGO));
		isElementAvailable(AccountSetupRepository.accountsetup_brandinfo_preferredRegions);
		enterValue(AccountSetupRepository.accountsetup_brandinfo_preferredRegions, "Automation");
		clickElement(AccountSetupRepository.accountsetup_brandinfo_addRegions);
		enterValue(AccountSetupRepository.accountsetup_brandinfo_preferredRegions, "Automation");
		clickElement(AccountSetupRepository.accountsetup_brandinfo_addRegions);
		uiPageEqualswithInputValue("Region already exist", getStrText(AccountSetupRepository.accountsetup_brandinfo_preferredRegions));
		clickElement(AccountSetupRepository.accountsetup_brandinfo_defaultRegion);
		isDisplayed(AccountSetupRepository.accountsetup_brandinfo_regionRemove_icons);
		List<WebElement> removeIcons = findElements(AccountSetupRepository.accountsetup_brandinfo_regionRemove_icons);
		for (int index = 0; index < removeIcons.size(); index++)
		{
			clickElement(AccountSetupRepository.accountsetup_brandinfo_regionRemove_icons);
		}
		isElementAvailable(AccountSetupRepository.accountsetup_brandinfo_preferredRegions);
		for (String region : BaseTest.getData().PreferredRegions.split(","))
		{
			clickElement(AccountSetupRepository.accountsetup_brandinfo_preferredRegions);
			explicitwaitforvisibility(PageBase.autolocator(AccountSetupRepository.accountsetup_brandinfo_dropdowns), 30);
			selectlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, region);
		}
		uiPageEqualswithMultipleInputValue(AccountSetupRepository.accountsetup_multiselect_dropdown, BaseTest.getData().PreferredRegions);
	}

	// Head Quater
	public void selectHeadQauter()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("HEAD QUATER", ExtentColor.INDIGO));
		isElementAvailable(AccountSetupRepository.accountsetup_brandinfo_headquarters);
		clickElement(AccountSetupRepository.accountsetup_brandinfo_headquarters);
		selectlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, BaseTest.getData().Headquarters);
	}

	public void enterWebsite()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("WEBSITE FIELD", ExtentColor.INDIGO));
		enterValue(AccountSetupRepository.accountsetup_brandinfo_website, "").tabAction();
		uiPageEqualswithInputValue("Enter website", getStrText(AccountSetupRepository.accountsetup_brandinfo_website + placeHolder));

		for (String website : BaseTest.getData().FilterGroup.split(","))
		{
			enterValue(AccountSetupRepository.accountsetup_brandinfo_website, website).tabAction();
			explicitwaitforvisibility(PageBase.autolocator(AccountSetupRepository.accountsetup_brandinfo_website + placeHolder), 30);
			uiPageEqualswithInputValue("Enter valid website", getStrText(AccountSetupRepository.accountsetup_brandinfo_website + placeHolder));
			removeText(AccountSetupRepository.accountsetup_brandinfo_website);
		}
		enterValue(AccountSetupRepository.accountsetup_brandinfo_website, "https://run19.resulticks.com/").tabAction();
		isDisplayed(AccountSetupRepository.accountsetup_inputBox_tickmark);
		removeText(AccountSetupRepository.accountsetup_brandinfo_website);
		enterValue(AccountSetupRepository.accountsetup_brandinfo_website, "https://etst.yu").tabAction();
		explicitwaitforvisibility(PageBase.autolocator(AccountSetupRepository.accountsetup_brandinfo_website + placeHolder), 30);
		uiPageEqualswithInputValue("Invalid website", getStrText(AccountSetupRepository.accountsetup_brandinfo_website + placeHolder));

		checkInputBoxLength(AccountSetupRepository.accountsetup_brandinfo_website, testData, 150);
		removeText(AccountSetupRepository.accountsetup_brandinfo_website);
		enterValue(AccountSetupRepository.accountsetup_brandinfo_website, BaseTest.getData().SmartLink).tabAction();
	}

	// Address
	public void enterAddress()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("COMPANY ADDRESS", ExtentColor.INDIGO));
		enterValue(AccountSetupRepository.accountsetup_brandinfo_address, "").tabAction();
		uiPageEqualswithInputValue("Enter address", getStrText(AccountSetupRepository.accountsetup_brandinfo_address + placeHolder));
		enterValue(AccountSetupRepository.accountsetup_brandinfo_address, "QA").tabAction();
		uiPageEqualswithInputValue("Min. 3 characters", getStrText(AccountSetupRepository.accountsetup_brandinfo_address + placeHolder));

		// validate Special character
		boolean hasContainsSpecialChar = hasContainsSpecialChar(AccountSetupRepository.accountsetup_brandinfo_address, "test comp356AB#&#");
		writeLog(hasContainsSpecialChar, "<b Adress /> Field accepting special characters", "Adress fields not accepting special characters");
		checkInputBoxLength(AccountSetupRepository.accountsetup_brandinfo_address, testData, 255);

		// Valid Adresss
		removeText(AccountSetupRepository.accountsetup_brandinfo_address);
		enterValue(AccountSetupRepository.accountsetup_brandinfo_address, BaseTest.getData().Address).tabAction();
	}

	// City
	public void enterCity()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("CITY", ExtentColor.INDIGO));
		enterValue(AccountSetupRepository.accountsetup_brandinfo_city, "").tabAction();
		uiPageEqualswithInputValue("Enter city", getStrText(AccountSetupRepository.accountsetup_brandinfo_city + placeHolder));
		enterValue(AccountSetupRepository.accountsetup_brandinfo_city, "QA").tabAction();
		uiPageEqualswithInputValue("Min. 3 characters", getStrText(AccountSetupRepository.accountsetup_brandinfo_city + placeHolder));
		boolean hasContainsSpecialChar = hasContainsSpecialChar(AccountSetupRepository.accountsetup_brandinfo_city, "test comp356AB#&#");
		writeLog(hasContainsSpecialChar, "<b City /> Field accepting special characters", "City fields not accepting special characters");
		checkInputBoxLength(AccountSetupRepository.accountsetup_brandinfo_city, testData, 50);
		enterValue(AccountSetupRepository.accountsetup_brandinfo_city, BaseTest.getData().City).tabAction();
	}

	// Zip code
	public void enterZipCode()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("ZIP CODE", ExtentColor.INDIGO));
		enterValue(AccountSetupRepository.accountsetup_brandinfo_zipCode, "").tabAction();
		uiPageEqualswithInputValue("Enter zip code", getStrText(AccountSetupRepository.accountsetup_brandinfo_zipCode + placeHolder));
		enterValue(AccountSetupRepository.accountsetup_brandinfo_zipCode, "82").tabAction();
		if (getTextBoxVal(AccountSetupRepository.accountsetup_brandinfo_zipCode + placeHolder, "class").contains("error"))
		{
			BaseTest.getTest().fail("Zip Code doesn't accepting less than 2 character");
			javaScriptHighLightwithScrnShot(AccountSetupRepository.accountsetup_brandinfo_zipCode);
		}
		enterValue(AccountSetupRepository.accountsetup_brandinfo_zipCode, "TN894").tabAction();
		boolean hasContainsSpecialChar = hasContainsSpecialChar(AccountSetupRepository.accountsetup_brandinfo_zipCode, "Ci%@#");
		writeLog(!hasContainsSpecialChar, "<b Zip Code /> Field not accepting special characters", "Zip Code field accepting special characters");
		checkInputBoxLength(AccountSetupRepository.accountsetup_brandinfo_zipCode, "ABCDEFGHIJKLMNOPQRSTUVWXYZ", 10);
		enterValue(AccountSetupRepository.accountsetup_brandinfo_zipCode, BaseTest.getData().ZipCode).tabAction();
	}

	// Select Country
	public void selectCountry()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("COUNTRY", ExtentColor.INDIGO));
		clickElement(AccountSetupRepository.accountsetup_brandinfo_selectcountry);
		uiPageEqualswithInputValue("Select country", getStrText(AccountSetupRepository.accountsetup_brandinfo_selectcountry + dropdownplaceHolder));
		searchCharAndValiadteDropdown(AccountSetupRepository.accountsetup_brandinfo_selectcountry, "A");
		clickElement(AccountSetupRepository.accountsetup_brandinfo_selectcountry);
		selectlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, BaseTest.getData().Country);
	}

	// Select Region
	public void regionDropdown()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("REGIONS", ExtentColor.INDIGO));
		isElementAvailable(AccountSetupRepository.accountsetup_brandinfo_region);
		clickElement(AccountSetupRepository.accountsetup_brandinfo_region);
		uiPageEqualswithMultipleInputValue(AccountSetupRepository.accountsetup_brandinfo_dropdowns, BaseTest.getData().PreferredRegions);
		enterTabAction();
		uiPageEqualswithInputValue("Select region", getStrText(AccountSetupRepository.accountsetup_brandinfo_region + dropdownplaceHolder));

		// Remove prefered Region & verify region dropdown
		String prefRegion = BaseTest.getData().PreferredRegions.split(",")[0];
		clickElement(PageBase.replacePlaceHolder(prefRegion + AccountSetupRepository.accountsetup_brandinfo_regionRemoves, BaseTest.getData().PreferredRegions.split(",")[0]));
		clickElement(AccountSetupRepository.accountsetup_brandinfo_region);
		if (selectexactlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, BaseTest.getData().PreferredRegions.split(",")[0]))
		{
			BaseTest.getTest().fail("Removed region has shown in Region dropdown values");
		}
		BaseTest.takeScreenshot();
		List<WebElement> removeIcons = findElements(AccountSetupRepository.accountsetup_brandinfo_regionRemove_icons);
		for (int index = 0; index < removeIcons.size(); index++)
		{
			clickElement(AccountSetupRepository.accountsetup_brandinfo_regionRemove_icons);
		}
		clickElement(AccountSetupRepository.accountsetup_brandinfo_region);
		isDisplayed(AccountSetupRepository.accountsetup_brandinfo_regionNodata);
		uiPageEqualswithInputValue("NO DATA FOUND.", getStrText(AccountSetupRepository.accountsetup_brandinfo_regionNodata));
		// Default Region
		clickElement(AccountSetupRepository.accountsetup_brandinfo_defaultRegion);
		searchCharAndValiadteDropdown(AccountSetupRepository.accountsetup_brandinfo_region, "L");
		selectlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, BaseTest.getData().Region);
	}

	// Select Industry
	public void selectIndustryType()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("INDUSTRY TYPE", ExtentColor.INDIGO));
		clickElement(AccountSetupRepository.accountsetup_brandinfo_industrytype);
		enterTabAction();
		uiPageEqualswithInputValue("Select industry", getStrText(AccountSetupRepository.accountsetup_brandinfo_industrytype + dropdownplaceHolder));
		searchCharAndValiadteDropdown(AccountSetupRepository.accountsetup_brandinfo_industrytype, "F");
		selectlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, BaseTest.getData().Industry);
	}

	// Business type
	public void businessType()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("BUSINESS TYPE", ExtentColor.INDIGO));
		clickElement(AccountSetupRepository.accountsetup_brandinfo_businesstype);
		enterTabAction();
		uiPageEqualswithInputValue("Select", getStrText(AccountSetupRepository.accountsetup_brandinfo_businesstype + dropdownplaceHolder));
		clickElement(AccountSetupRepository.accountsetup_brandinfo_businesstype);
		selectexactlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, BaseTest.getData().BusinessType);
	}

	// Brand Position
	public void brandPosition()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("BRAND POSITION", ExtentColor.INDIGO));
		clickElement(AccountSetupRepository.accountsetup_brandinfo_brandposition);
		enterTabAction();
		uiPageEqualswithInputValue("Select", getStrText(AccountSetupRepository.accountsetup_brandinfo_brandposition + dropdownplaceHolder));
		searchCharAndValiadteDropdown(AccountSetupRepository.accountsetup_brandinfo_brandpositionDropdown, "M");
		selectlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, BaseTest.getData().BrandPosition);

		clickElement(AccountSetupRepository.accountsetup_brandinfo_businesstype);
		selectexactlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, "B2C");
		if (!getStrText(AccountSetupRepository.accountsetup_brandinfo_brandpositionDropdown).equals("Brand position"))
		{
			BaseTest.getTest().fail("Brand position values not reset, While changing the Brand type");
			javaScriptHighLightElement(AccountSetupRepository.accountsetup_brandinfo_brandpositionDropdown);
		}
		clickElement(AccountSetupRepository.accountsetup_brandinfo_brandposition);
		selectlistelements(AccountSetupRepository.accountsetup_brandinfo_dropdowns, "Low cost");
	}

	// Hybrid Solution
	public boolean isHybridSolution()
	{
		if (isElementAvailable(AccountSetupRepository.accountsetup_brandinfo_hybridCheckbox))
		{
			clickElement(AccountSetupRepository.accountsetup_brandinfo_hybridCheckbox);
			if (isSelected(AccountSetupRepository.accountsetup_brandinfo_hybridCheckbox))
			{
				BaseTest.getTest().info("Hybrid solution checkbox is selected");
				javaScriptHighLightwithScrnShot(AccountSetupRepository.accountsetup_brandinfo_hybridCheckbox);
				return true;
			}
		}
		return false;
	}

	public void profilePictureUploadScenarios(String page)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("UPLOAD IMAGES SCENARIOS", ExtentColor.INDIGO));
		javaScriptScrolltoTop();
		String tooltip = null;
		if (page.equalsIgnoreCase("Key Contact"))
		{
			tooltip = "Upload profile picture";
		} else if (page.equalsIgnoreCase("agency"))
		{
			tooltip = "Upload agency logo";
		} else if (page.equalsIgnoreCase("Brand"))
		{
			tooltip = "Upload company logo";
		}
		toolTipValidationKnownText(AccountSetupRepository.accountsetup_brandinfo_uploadlogo, tooltip);
		String[] profilePicHelpText = "Allowed extensions: \n".concat("jpg, jpeg, png, svg \n").concat(" Max. file size: 500 Kb").split("\\R");
		int index = 0;
		for (String helpText : getStrText("Profile pic help text,xpath,//div[@class='alert alert-warning d-block mt30 py5']").split("\\R"))
		{
			uiPageEqualswithInputValue(profilePicHelpText[index].trim(), helpText);
			index++;
		}
		// Max file size upload
		profilePicUpload(BaseTest.curr_Dir + "/src/main/resources/data/uploadfiles/file_example_JPG_500kB.jpg");
		uiPageEqualswithInputValue("Image size should be less than 500kb.", getStrText("Validation message,xpath,//div[@class='validation-message']"));
		String errMsgForMoreThan500Kb = getUiBackgroundColour("color", "Validation message,xpath,//div[@class='validation-message']");
		if (errMsgForMoreThan500Kb.equalsIgnoreCase("#ff3939"))
		{
			BaseTest.getTest().info("Error message colour is validated successfully");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().info("Error message colour is mismatched");
			BaseTest.takeScreenshot();
		}
		// Invalid upload file formats
		for (String uploadFormat : BaseTest.getData().AttributeType.split(","))
		{
			profilePicUpload(BaseTest.curr_Dir + "/src/main/resources/data/InvalidFormats/" + uploadFormat);
			uiPageEqualswithInputValue("Invalid file format", getStrText("Validation message,xpath,//div[contains(@class,'validation-message')]"));
		}

		// Valid files
		if (isElementAvailable(AccountSetupRepository.accountsetup_brandinfo_uploadlogo))
		{
			for (String uploadFormat : BaseTest.getData().CreateAttribute.split(","))
			{
				profilePicUpload(BaseTest.curr_Dir + "/src/main/resources/data/uploadfiles/" + uploadFormat);
				String format = StringUtils.substringAfter(".", uploadFormat);
				isElementAvailable("<b>" + format + "</b> upload image,xpath,//img[contains(@src,'base64')]");
			}
		}
		toolTipValidationKnownText("Pencil icon,xpath,//i[@class='icon-rs-circle-pencil-medium color-primary-blue icon-md']", tooltip.replace("Upload", "Update"));
		toolTipValidationKnownText(AccountSetupRepository.accountsetup_brandinfo_removeProfile, tooltip.replace("Upload", "Remove"));
		clickElement(AccountSetupRepository.accountsetup_brandinfo_removeProfile);
		threadSleep(ObjectRepository.wait3sec);
		if (!isElementPresent(AccountSetupRepository.accountsetup_brandinfo_removeProfile))
		{
			BaseTest.getTest().log(Status.INFO, "Profile picture is removed successfully");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Profile picture is not removed");
			BaseTest.takeScreenshot();
		}
		// Upload Brand info Image
		uploadProfile(BaseTest.curr_Dir + "/src/main/resources/data/uploadfiles/PNG file upload.png");
	}

	public void keyContactTextFieldScenarios()
	{
		enterValue(AccountSetupRepository.accountsetup_firstname, "AA");
		tabAction();
		uiPageEqualswithMultipleInputValue("First name error message,xpath,//input[@name ='firstname']/..//label", "Min. 3 characters");
		enterValue(AccountSetupRepository.accountsetup_firstname, "A A");
		String space = getTextBoxVal(AccountSetupRepository.accountsetup_firstname, "value");
		writeLog(space.length() == 3, "Space is considered character in the first name field.", "Space is not considered character in the first name field.");
		enterValue(AccountSetupRepository.accountsetup_lastname, "A A");
		String spacelast = getTextBoxVal(AccountSetupRepository.accountsetup_firstname, "value");
		writeLog(spacelast.length() == 3, "Space is considered character in the last name field.", "Space is not considered character in the last name field.");
		enterValue(AccountSetupRepository.accountsetup_firstname, "!@#$%^&*()?><");
		String splChar = getTextBoxVal(AccountSetupRepository.accountsetup_firstname, "value");
		writeLog(splChar.isEmpty(), "The first name field does not accept special characters asexpected", "The first name field does accept special characters.");
		enterValue(AccountSetupRepository.accountsetup_lastname, "!@#$%^&*()?><");
		String splCharLastName = getTextBoxVal(AccountSetupRepository.accountsetup_firstname, "value");
		writeLog(splCharLastName.isEmpty(), "The Last name field does not accept special characters as expected.", "The Last name field does accept special characters.");
		enterValue(AccountSetupRepository.accountsetup_firstname, "!@#$%^&*()?><");
		String moreThan50Char = "1234Testingtestingtestingtestingtestingtestingtestingtesting";
		enterValue(AccountSetupRepository.accountsetup_firstname, moreThan50Char);
		String charCount = getTextBoxVal(AccountSetupRepository.accountsetup_firstname, "value");
		writeLog(charCount.length() == 50, "The first name field accepts only 50 characters, as expected.", "The first name field accepts only 50 characters.");
		enterValue(AccountSetupRepository.accountsetup_lastname, moreThan50Char);
		String charCountLast = getTextBoxVal(AccountSetupRepository.accountsetup_lastname, "value");
		writeLog(charCountLast.length() == 50, "The last name field accepts only 50 characters, as expected.", "The last name field accepts only 50 characters.");

		// password field

		toolTipValidationKnownText(AccountSetupRepository.accset_keyCon_passquestionmark, "Include numbers, special characters and a mix of upper and lowercase. Max.15 characters.");
		enterValue(AccountSetupRepository.accountsetup_pswd, "1234");
		tabAction();
		uiPageEqualswithMultipleInputValue(AccountSetupRepository.accset_keyCon_passerrmsg, "Enter a valid password");
		enterValue(AccountSetupRepository.accountsetup_pswd, "123456789101234567");
		String passChar = getTextBoxVal(AccountSetupRepository.accountsetup_pswd, "value");
		writeLog(passChar.length() == 15, "The password field accepts a maximum of 15 characters, as expected.", "The password field accepts more than 15 characters.");
		enterValue(AccountSetupRepository.accountsetup_pswd, "itkt@1234");
		boolean withoutUpperCase = isElementPresent(AccountSetupRepository.accset_keyCon_passerrmsg);
		writeLog(withoutUpperCase, "The password must contain at least one uppercase letter.", "The password can be entered without an uppercase letter.");

		enterValue(AccountSetupRepository.accountsetup_pswd, "ITKT@1234");
		boolean withoutlowercase = isElementPresent(AccountSetupRepository.accset_keyCon_passerrmsg);
		writeLog(withoutlowercase, "The password must contain at least one lowercase letter.", "The password can be entered without a lowercase letter.");

		enterValue(AccountSetupRepository.accountsetup_pswd, "ITktAT1234");
		boolean withoutsplchar = isElementPresent(AccountSetupRepository.accset_keyCon_passerrmsg);
		writeLog(withoutsplchar, "The password must contain at least one special character.", "The password can be entered without a special character.");

		enterValue(AccountSetupRepository.accountsetup_pswd, "ITktATabc@");
		boolean withoutNumber = isElementPresent(AccountSetupRepository.accset_keyCon_passerrmsg);
		writeLog(withoutNumber, "The password must contain at least one Number.", "The password can be entered without number.");

		enterValue(AccountSetupRepository.accountsetup_pswd, "Itkt");
		String passwordStrength1 = getTextBoxVal(AccountSetupRepository.accset_keyCon_passwordstrength, "class");
		if (passwordStrength1.contains("40"))
		{
			WebElement switchLabel = driver.findElement(By.xpath("//input[@name='password']/..//div[contains(@class,'password-strength-meter')]"));
			String colorRGB = ((JavascriptExecutor) driver).executeScript("return window.getComputedStyle(arguments[0], ':before').getPropertyValue('background-color');", switchLabel).toString();
			String strength1 = rgbToHexColor(colorRGB);
			writeLog(strength1.equalsIgnoreCase("#e5c553"), "The password strength color changes to yellow as expected, based on its input value.", "The password strength color not changes to yellow as expected, based on its input value.");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Password strength range is mismatch");
			BaseTest.takeScreenshot();
		}

		enterValue(AccountSetupRepository.accountsetup_pswd, "Itkt@");
		String passwordStrength2 = getTextBoxVal(AccountSetupRepository.accset_keyCon_passwordstrength, "class");
		if (passwordStrength2.contains("60"))
		{

			WebElement switchLabel = driver.findElement(By.xpath("//input[@name='password']/..//div[contains(@class,'password-strength-meter')]"));
			String colorRGB = ((JavascriptExecutor) driver).executeScript("return window.getComputedStyle(arguments[0], ':before').getPropertyValue('background-color');", switchLabel).toString();
			String strength1 = rgbToHexColor(colorRGB);
			writeLog(strength1.equalsIgnoreCase("#f58332"), "The password strength color changes to Orange as expected, based on its input value.", "The password strength color not changes to Orange as expected, based on its input value.");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Password strength range is mismatch");
			BaseTest.takeScreenshot();
		}

		enterValue(AccountSetupRepository.accountsetup_pswd, "Itkt@1");
		String passwordStrength3 = getTextBoxVal(AccountSetupRepository.accset_keyCon_passwordstrength, "class");
		if (passwordStrength3.contains("80"))
		{

			WebElement switchLabel = driver.findElement(By.xpath("//input[@name='password']/..//div[contains(@class,'password-strength-meter')]"));
			String colorRGB = ((JavascriptExecutor) driver).executeScript("return window.getComputedStyle(arguments[0], ':before').getPropertyValue('background-color');", switchLabel).toString();
			String strength1 = rgbToHexColor(colorRGB);
			writeLog(strength1.equalsIgnoreCase("#26ade0"), "The password strength color changes to Blue as expected, based on its input value.", "The password strength color not changes to Blue as expected, based on its input value.");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Password strength range is mismatch");
			BaseTest.takeScreenshot();
		}

		enterValue(AccountSetupRepository.accountsetup_pswd, "Itkt@1234");
		String passwordStrength4 = getTextBoxVal(AccountSetupRepository.accset_keyCon_passwordstrength, "class");
		if (passwordStrength4.contains("100"))
		{

			WebElement switchLabel = driver.findElement(By.xpath("//input[@name='password']/..//div[contains(@class,'password-strength-meter')]"));
			String colorRGB = ((JavascriptExecutor) driver).executeScript("return window.getComputedStyle(arguments[0], ':before').getPropertyValue('background-color');", switchLabel).toString();
			String strength1 = rgbToHexColor(colorRGB);
			writeLog(strength1.equalsIgnoreCase("#379904"), "The password strength color changes to Green as expected, based on its input value.", "The password strength color not changes to Green as expected, based on its input value.");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Password strength range is mismatch");
			BaseTest.takeScreenshot();
		}

		enterValue(AccountSetupRepository.accountsetup_confirmpwsd, "Itkt@4321");
		threadSleep(ObjectRepository.wait3sec);
		uiPageEqualswithMultipleInputValue(AccountSetupRepository.accset_keyCon_confirmpasserr, "Password and confirm password does not match");

		enterValue(AccountSetupRepository.accountsetup_confirmpwsd, "Itkt");
		String passwordStrength5 = getTextBoxVal(AccountSetupRepository.accset_keyCon_cnfmpasswordstrength, "class");
		if (passwordStrength5.contains("40"))
		{
			WebElement switchLabel = driver.findElement(By.xpath("//input[@name='confirmPassword']/..//div[contains(@class,'password-strength-meter')]"));
			String colorRGB = ((JavascriptExecutor) driver).executeScript("return window.getComputedStyle(arguments[0], ':before').getPropertyValue('background-color');", switchLabel).toString();
			String strength1 = rgbToHexColor(colorRGB);
			writeLog(strength1.equalsIgnoreCase("#e5c553"), "The confirm password strength color changes to yellow as expected, based on its input value.",
					"The confirm password strength color not changes to yellow as expected, based on its input value.");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "confirm Password strength range is mismatch");
			BaseTest.takeScreenshot();
		}

		enterValue(AccountSetupRepository.accountsetup_confirmpwsd, "Itkt@");
		String passwordStrength6 = getTextBoxVal(AccountSetupRepository.accset_keyCon_cnfmpasswordstrength, "class");
		if (passwordStrength6.contains("60"))
		{
			WebElement switchLabel = driver.findElement(By.xpath("//input[@name='confirmPassword']/..//div[contains(@class,'password-strength-meter')]"));
			String colorRGB = ((JavascriptExecutor) driver).executeScript("return window.getComputedStyle(arguments[0], ':before').getPropertyValue('background-color');", switchLabel).toString();
			String strength1 = rgbToHexColor(colorRGB);
			writeLog(strength1.equalsIgnoreCase("#f58332"), "The confirm password strength color changes to Orange as expected, based on its input value.",
					"The confirm password strength color not changes to Orange as expected, based on its input value.");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "confirm Password strength range is mismatch");
			BaseTest.takeScreenshot();
		}

		enterValue(AccountSetupRepository.accountsetup_confirmpwsd, "Itkt@1");
		String passwordStrength7 = getTextBoxVal(AccountSetupRepository.accset_keyCon_cnfmpasswordstrength, "class");
		if (passwordStrength7.contains("80"))
		{
			WebElement switchLabel = driver.findElement(By.xpath("//input[@name='confirmPassword']/..//div[contains(@class,'password-strength-meter')]"));
			String colorRGB = ((JavascriptExecutor) driver).executeScript("return window.getComputedStyle(arguments[0], ':before').getPropertyValue('background-color');", switchLabel).toString();
			String strength1 = rgbToHexColor(colorRGB);
			writeLog(strength1.equalsIgnoreCase("#26ADE0"), "The confirm password strength color changes to Blue as expected, based on its input value.",
					"The confirm password strength color not changes to Blue as expected, based on its input value.");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "confirm Password strength range is mismatch");
			BaseTest.takeScreenshot();
		}

		enterValue(AccountSetupRepository.accountsetup_confirmpwsd, "Itkt@1234");
		String passwordStrength8 = getTextBoxVal(AccountSetupRepository.accset_keyCon_cnfmpasswordstrength, "class");
		if (passwordStrength8.contains("100"))
		{
			WebElement switchLabel = driver.findElement(By.xpath("//input[@name='confirmPassword']/..//div[contains(@class,'password-strength-meter')]"));
			String colorRGB = ((JavascriptExecutor) driver).executeScript("return window.getComputedStyle(arguments[0], ':before').getPropertyValue('background-color');", switchLabel).toString();
			String strength1 = rgbToHexColor(colorRGB);
			writeLog(strength1.equalsIgnoreCase("#379904"), "The confirm password strength color changes to Green as expected, based on its input value.", "The password strength color not changes to Green as expected, based on its input value.");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, " confirm Password strength range is mismatch");
			BaseTest.takeScreenshot();
		}
	}

	public void keyContactDropdownScenarios()
	{
		explicitwaitforclick(autolocator(AccountSetupRepository.accountsetup_selectTitle), 20);
		clickElement(AccountSetupRepository.accountsetup_selectTitle);
		uiPageEqualswithMultipleInputValue("Title dropdown,xpath,//div[@class='k-list-content']//li", "Mr.,Ms.,Mrs.");
		selectlistelements("Title dropdown,xpath,//div[@class='k-list-content']//li", "Mr.");
		clickElement(AccountSetupRepository.accountsetup_jobfunction_click);
		selectlistelements("Job function dropdown,xpath,//div[@class='k-list-content']//li", "Account manager");
	}

	public void mobileNoVerificationScearios()
	{
		boolean defaultFlagIndia = isElementPresent(AccountSetupRepository.accset_keyCon_defaultflag);
		writeLog(defaultFlagIndia, "The Indian flag is available by default in the mobile number field.", "The Indian flag is not available by default in the mobile number field.");
		String defaultCountryCode = getTextBoxVal(AccountSetupRepository.accset_keyCon_mobilenumber, "value");
		writeLog(defaultCountryCode.equals("+91"), "The India country code is available by default in the mobile number field", "The India country code is not available by default in the mobile number field.");
		toolTipValidationKnownText(AccountSetupRepository.accset_keyCon_mobilequesmark, "The license key will be sent to this mobile number.");
		clickElement("Flag dropdown,xpath,//div[@class='arrow']");
		threadSleep(ObjectRepository.wait3sec);
		List<WebElement> countryList = findElements(AccountSetupRepository.accset_keyCon_mobilecountrylist);
		writeLog(countryList.size() == 211, "Country list available in the mobile number field", "Country list is not available in the mobile number field");
		selectlistelements(AccountSetupRepository.accset_keyCon_mobilecountrylist, "Singapore");
		threadSleep(ObjectRepository.wait2sec);
		enterValue(AccountSetupRepository.accset_keyCon_mobilenumber, "+6512345678456787");
		tabAction();
		clickElement("Popup close,xpath,//i[@class='icon-md color-primary-blue icon-rs-circle-close-edge-medium ']");
		String singaporeNumberCount = getTextBoxVal(AccountSetupRepository.accset_keyCon_mobilenumber, "value").replaceAll("[^\\d]", "");
		writeLog(singaporeNumberCount.length() == 10, "The mobile number count adjusts according to the selected country.", "The mobile number count not adjusts according to the selected country.");
		clearField(AccountSetupRepository.accset_keyCon_mobilenumber);
		clickElement("Flag dropdown,xpath,//div[@class='arrow']");
		selectlistelements(AccountSetupRepository.accset_keyCon_mobilecountrylist, "+91");
		enterValue(AccountSetupRepository.accset_keyCon_mobilenumber, "+9191");
		tabAction();
		clearField(AccountSetupRepository.accset_keyCon_mobilenumber);
		enterValue(AccountSetupRepository.accset_keyCon_mobilenumber, "+919344627856");
		tabAction();
		clickElement("Popup close,xpath,//i[@class='icon-md color-primary-blue icon-rs-circle-close-edge-medium ']");
		explicitwaitforclick(autolocator(AccountSetupRepository.accset_keyCon_mobilenumber), 20);
		clickElement(AccountSetupRepository.accset_keyCon_mobilenumber);
		tabAction();
		threadSleep(ObjectRepository.wait3sec);
		clickElement(AccountSetupRepository.accset_keyCon_editbutton);
		clickElement(AccountSetupRepository.accset_keyCon_mobilenumber);
		tabAction();
		clickElement(AccountSetupRepository.accset_keyCon_popupconfirm);
		pageLoaderLogo();
		boolean successAlertMsg = isElementPresent("Alert message success,xpath,//div[contains(@class,'alert-success')][contains(.,'sent')]");
		writeLog(successAlertMsg, "The success alert message appears after the OTP is sent to the email.", "The success alert message not appears after the OTP is sent to the email.");
		boolean otpTimer = isElementPresent("Otp timer,xpath,//small[@class='position-absolute mt5']");
		writeLog(otpTimer, "OTP timer is present", "OTP timer is not available");
		String pwind = parentWinHandle();
		javaScriptopenNewWindow();
		switchWindow();
		String otpCode = webURLlaunch().accountSetupWebmailLogin(getAcctStpEmailID()).getSignUpOTP();
		// threadSleep(ObjectRepository.wait5min);
		switchParentWin(pwind);
		int countDown = (int) ObjectRepository.wait5min;
		explicitwaitforclick(autolocator(AccountSetupRepository.accountsetup_otpResend), countDown);
		String invalidOTP = "123456";
		if (!invalidOTP.isEmpty())
		{
			int index = 0;
			for (WebElement input : findElements(AccountSetupRepository.accountsetup_keycontactInfo_OTP))
			{
				input.sendKeys(String.valueOf(invalidOTP.charAt(index)));
				index++;
			}
		}
		pageLoaderLogo();
		boolean invalidOtpAlert = isElementPresent(AccountSetupRepository.accset_keyCon_invalidotp);
		writeLog(invalidOtpAlert, "After entering an invalid OTP, the alert message is available as expected.", "After entering an invalid OTP, the alert message is not available.");
		clearOtpField();
		if (otpCode != null)
		{
			int index = 0;
			for (WebElement input : findElements(AccountSetupRepository.accountsetup_keycontactInfo_OTP))
			{
				input.sendKeys(String.valueOf(otpCode.charAt(index)));
				index++;
			}
		}
		pageLoaderLogo();
		boolean expiredOtp = isElementPresent(AccountSetupRepository.accset_keyCon_invalidotp);
		writeLog(expiredOtp, "After entering an expired OTP, the alert message is available as expected.", "After entering an expired OTP, the alert message is not available.");
	}

	public void clearOtpField()
	{
		List<WebElement> input = findElements(AccountSetupRepository.accountsetup_keycontactInfo_OTP);
		for (int i = input.size(); i > 0; i--)
		{
			Actions act = new Actions(driver);
			act.sendKeys(Keys.BACK_SPACE).build().perform();
		}
	}

	public void otpResnedCheck()
	{
		explicitwaitforclick(autolocator(AccountSetupRepository.accset_keyCon_mobilenumber), 20);
		enterValue(AccountSetupRepository.accset_keyCon_mobilenumber, "+919344627856");
		tabAction();
		clickElement(AccountSetupRepository.accset_keyCon_popupconfirm);
		pageLoaderLogo();
		explicitwaitforclick(autolocator(AccountSetupRepository.accountsetup_otpResend), 320);
		clickElement(AccountSetupRepository.accountsetup_otpResend);
		String pwind = parentWinHandle();
		javaScriptopenNewWindow();
		switchWindow();
		String otpCode = webURLlaunch().accountSetupWebmailLogin(getAcctStpEmailID()).getSignUpOTP();
		if (otpCode != null)
		{
			switchParentWin(pwind);
			int index = 0;
			for (WebElement input : findElements(AccountSetupRepository.accountsetup_keycontactInfo_OTP))
			{
				input.sendKeys(String.valueOf(otpCode.charAt(index)));
				index++;
				pageLoaderLogo();
			}
			BaseTest.takeScreenshot();
		}
		threadSleep(ObjectRepository.wait5sec);
		boolean mobileFieldDisable = isElementPresent("Mobile number disable,xpath,//div[contains(@class,'phone-input')]//input[@disabled]");
		writeLog(mobileFieldDisable, "The mobile number field becomes disabled after entering the correct OTP, as expected.", "The mobile number field is not disabled after entering the correct OTP.");
	}

	public void keyContactDetailsMandateFieldCheck()
	{
		List<WebElement> dropdownEle = driver.findElements(By.xpath("//span[contains(@class,'-required')]"));
		List<WebElement> textfieldEle = driver.findElements(By.xpath("//input[contains(@class,'required')]"));
		WebElement mobileNumberField = driver.findElement(By.xpath("//div[@class=' react-tel-input ']/.."));

		String[] dropdowns = { "Title", "Job function" };
		String[] textFields = { "First name", "Last name", "Email address", "Password", "Confirm password" };
		BaseTest.takeScreenshot();
		int i = 0;
		for (WebElement dropdown : dropdownEle)
		{
			try
			{
				dropdown.isDisplayed();
				BaseTest.getTest().log(Status.INFO, "The " + dropdowns[i] + " is set to mandatory, as expected");
			} catch (Exception e)
			{
				BaseTest.getTest().log(Status.FAIL, "The " + dropdowns[i] + " is not set to mandatory.");
			}
			++i;
		}
		i = 0;
		for (WebElement textField : textfieldEle)
		{
			try
			{
				textField.isDisplayed();
				BaseTest.getTest().log(Status.INFO, "The " + textFields[i] + " is set to mandatory, as expected");
			} catch (Exception e)
			{
				BaseTest.getTest().log(Status.FAIL, "The " + textFields[i] + " is not set to mandatory.");
			}
			++i;
		}
		writeLog(mobileNumberField.isDisplayed(), "The mobile number is set to mandatory, as expected", "The mobile number is not set to mandatory.");

		clickNext();
		BaseTest.takeScreenshot();
		List<WebElement> fieldsEle = driver.findElements(By.xpath("//div[contains(@class,'errorContainer')]"));
		String[] fieldsName = { "Title", "First name", "Last name", "Mobile number", "Job function", "Password", "Confirm password", "Upload profile picture" };
		i = 0;
		for (WebElement elements : fieldsEle)
		{
			try
			{
				elements.isDisplayed();
				BaseTest.getTest().log(Status.INFO, "A validation message is displayed in the " + fieldsName[i] + " field when proceeding without entering any value.");
			} catch (Exception e)
			{
				BaseTest.getTest().log(Status.FAIL, "Validation message is not displayed in the " + fieldsName[i] + " field when proceeding without entering any value.");
			}
			++i;
		}
	}

	// Business Unit
	public void addBusinessUnit()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("ADD BUSINESS UNIT", ExtentColor.INDIGO));
		pageLoaderLogo();
		if (isDisplayed(AccountSetupRepository.accountsetup_businessUnit))
		{
			javaScriptScrollDown();
			clickElement(AccountSetupRepository.accountsetup_addBusinessUnit);
			enterValue(AccountSetupRepository.accountsetup_bu_deptName, BaseTest.getData().BU).tabAction();
			clickNext();
			threadSleep(200);
			pageLoaderLogo();
			explicitwaitforclick(autolocator(AccountSetupRepository.accountsetup_savebrandinfo), 90);
			pageLoaderLogo();
			BaseTest.takeScreenshot();
		}
	}

	// ****************************************** DATABASE TESTING
	// ******************************************

	public String getEmailExistQuery()
	{
		return "SELECT email FROM muser";
	}

	/**
	 * Fetching the Encrypted Email's from DB
	 **/
	public void fetchExistingUsersFromDB()
	{
		List<Map<String, String>> result = getdbQueryResults(dburl_master + masterDBname, masterdb_userName, masterdb_password, getEmailExistQuery());
		for (Map<String, String> entry : result)
		{
			String username = entry.get("email");
			encryptedExistingUsers.add(username);
		}
		classifyUsers(encryptedExistingUsers, getEncryptedEmails());
	}

	public static List<String> getEmailDataSet()
	{
		List<String> username = new ArrayList<>();
		for (Object[] dataProvider : DataInputProvider.getTestData(BaseTest.data_file, "DataProvider"))
		{
			if (dataProvider[1] != null)
			{
				username.add(dataProvider[1].toString());
			}
		}
		return username;
	}

	// AES Encryption
	public static String encrypt(String input, byte[] key)
	{
		byte[] encryptedBytes = null;
		try
		{
			byte[] bytes = input.getBytes(StandardCharsets.UTF_8);
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"));
			encryptedBytes = cipher.doFinal(bytes);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}

	// AES decryption
	public static String decrypt(String encryptedString, byte[] key)
	{
		byte[] decryptedBytes = null;
		try
		{
			byte[] decodedBytes = Base64.getDecoder().decode(encryptedString);
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"));
			decryptedBytes = cipher.doFinal(decodedBytes);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return new String(decryptedBytes, StandardCharsets.UTF_8);
	}

	// Get Secret Key
	public static byte[] getKey(String secrtCode)
	{
		byte[] secrtkey = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		byte byteSize = 16;
		try
		{
			byte[] key = secrtCode.getBytes(StandardCharsets.UTF_8);
			for (int i = 0; i < key.length; i++)
			{
				secrtkey[i % byteSize] = (byte) (secrtkey[i % byteSize] ^ key[i]);
			}
			return secrtkey;

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return secrtkey;
	}

	public List<Object> getDecryptedEmails(List<String> encrypted)
	{
		StringBuilder payload = new StringBuilder();
		for (String temp : encrypted)
		{
			payload.append(temp + ",");
		}
		reqspec = RestAssured.given().relaxedHTTPSValidation().log().all();
		addBody("{emailId:" + payload.substring(0, payload.length() - 1) + "}");
		String response = reqspec.contentType(ContentType.JSON).post(System.getProperty("GET_Decrypt")).getBody().asPrettyString();

		return getJsonArrayList(response, "data");
	}

	public static synchronized Map<String, String> getEncryptedEmails()
	{
		List<String> emailDataSet = getEmailDataSet();
		StringBuilder payload = new StringBuilder();
		for (String temp : emailDataSet)
		{
			payload.append(temp + ",");
		}
		reqspec = RestAssured.given();
		addBody("{\"emailId\": \"" + payload.substring(0, payload.length() - 1) + "\"}");
		String endpoint = System.getProperty("GetEncrypt_Endpoint");
		String response = reqspec.contentType(ContentType.JSON).post(endpoint).getBody().asPrettyString();

		int index = 0;
		for (Object encrypt : getJsonArrayList(response, "data"))
		{
			String name = emailDataSet.get(index);
			encrypted.put(name, encrypt.toString());
			index++;
		}
		return encrypted;
	}

	public void loginOtpScenarios()
	{
		boolean otpTimer = isElementPresent("OTP timer,xpath,//small[contains(.,' will expire in ')]");
		writeLog(otpTimer, "OTP timer is present as expected", "OTP timer is not appeared");
		String invalidOTP = "123456";
		if (!invalidOTP.isEmpty())
		{
			int index = 0;
			for (WebElement input : findElements(AccountSetupRepository.accountsetup_keycontactInfo_OTP))
			{
				input.sendKeys(String.valueOf(invalidOTP.charAt(index)));
				index++;
			}
		}
		pageLoaderLogo();
		boolean invalidOtpAlert = isElementPresent(AccountSetupRepository.accset_keyCon_invalidotp);
		writeLog(invalidOtpAlert, "After entering an invalid OTP, the alert message is available as expected.", "After entering an invalid OTP, the alert message is not available.");

		uiPageEqualswithInputValue("Invalid OTP", getStrText(AccountSetupRepository.accountsetup_payment_validation_msg));
		clearLoginOtp();
		threadSleep(ObjectRepository.wait5min);
		boolean otpExpired = isElementPresent("OTP expired,xpath,//div[contains(@class,'alert-danger')][.='OTP expired']");
		writeLog(otpExpired, "OTP expired alert message is displayed as expected after 5 minutes", "OTP expired alert message is not displayed after 5 minutes");
		String pwind = parentWinHandle();
		javaScriptopenNewWindow();
		switchWindow();
		String expiredOtp = webURLlaunch().accountSetupWebmailLogin("vbnk96@resulticksmail.com").getSignUpOTP();
		switchParentWin(pwind);
		if (expiredOtp != null)
		{
			int index = 0;
			for (WebElement input : findElements(AccountSetupRepository.accountsetup_keycontactInfo_OTP))
			{
				input.sendKeys(String.valueOf(expiredOtp.charAt(index)));
				index++;
			}
		}
		boolean enterExpiredOTP = isElementPresent(AccountSetupRepository.accset_keyCon_invalidotp);
		writeLog(enterExpiredOTP, "After entering an expired OTP, the alert message is displayed as expected.", "After entering an expired OTP, the alert message is not displayed.");
		clearLoginOtp();
		clickElement(AccountSetupRepository.accountsetup_otpResend);
		switchWindow();
		String signUpOTP = getSignUpOTP();
		if (signUpOTP != null)
		{
			int index = 0;
			for (WebElement input : findElements(AccountSetupRepository.accountsetup_keycontactInfo_OTP))
			{
				input.sendKeys(String.valueOf(signUpOTP.charAt(index)));
				index++;
			}
		}
		boolean validOTP = isElementPresent("Valid OTP message,xpath,//div[contains(@class,'alert-success')][.='Valid OTP']");
		writeLog(validOTP, "After entering an Valid resend OTP, the success alert message is displayed as expected.", "After entering an Valid resend OTP, the success alert message is not displayed.");
		boolean otpDisabled = isElementPresent(",xpath,//div[@id='otp']/ancestor::div[@class='col']//div[@class='form-group mt-7 text-white mb0 ']/following-sibling::div[@class='click-off']");
		writeLog(otpDisabled, "After entered valid OTP, Field get non editable as expected", "After entered valid OTP, Field is not get non editable as expected");
		clickElement("Confirm,xpath,//button[@type='submit'][.='Confirm']");
		pageLoaderLogo();
		explicitwaitforvisibility(autolocator("Page layout,xpath,//div[contains(@class,'box-design')]"), 30);
	}

	public void Accountbuselect()
	{
		String selectBUPopupText = getStrText(DashboardRepository.businessunit_popup);
		writeLog(selectBUPopupText.equals("Please select the appropriate business unit and proceed."), "Select BU popup text '" + selectBUPopupText + "' present as expected.",
				"Select BU popup text '" + selectBUPopupText + "' not-present as expected.");
		clickElement(DashboardRepository.businessunit_popup_okbutton);

		BaseTest.takeScreenshot();

		threadSleep(ObjectRepository.wait2sec);
		pageLoaderLogo();
	}

}
