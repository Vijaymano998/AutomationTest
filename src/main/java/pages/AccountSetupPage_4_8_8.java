package pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.Page;

import repository.AccountSetupRepository_4_8_8;
import repository.ObjectRepository;
import utility.BaseTest;
import utility.DataInputProvider;
import utility.PageFactory;

public class AccountSetupPage_4_8_8 extends HomePage
{

	public AccountSetupPage_4_8_8(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	public void ClickAndEnterTheBusinessMailId(String businessMail)
	{
		pw_clickElement(AccountSetupRepository_4_8_8.ProceedButton);
		pw_clickElement(AccountSetupRepository_4_8_8.NewUserTab);
		pw_enterValue(AccountSetupRepository_4_8_8.BusinessMailId, businessMail);
		pw_enterValue(AccountSetupRepository_4_8_8.Entercaptcha, validateCaptcha());
		validateTermAndConditionCheckbox();
		pw_clickElement(AccountSetupRepository_4_8_8.Signupbutton);
	}

	public String validateCaptcha()
	{
		String[] captcha = pw_getStrText(AccountSetupRepository_4_8_8.Captcha).split(" ");
		int captchaOut = Integer.parseInt(captcha[0]) + Integer.parseInt(captcha[2]);
		return String.valueOf(captchaOut);
	}

	public void validateTermAndConditionCheckbox()
	{
		String style = pw_getTextBoxVal(AccountSetupRepository_4_8_8.TermAndConditionText, "style");
		if (!style.contains("display: block;"))
		{
			pw_clickElement(AccountSetupRepository_4_8_8.TermsAndConditionCheckbox);
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Terms and condition checkbox enabled by default.");
		}
	}

	public void selectAccountType(String accountType)
	{
		switch (accountType)
		{
		case "Agency" -> {
			pw_clickElement(AccountSetupRepository_4_8_8.AccounttypeAgency);
		}
		case "Brand" -> {
			pw_clickElement(AccountSetupRepository_4_8_8.AccounttypeBrand);
		}
		default -> {
			throw new IllegalArgumentException("Unexpected value: " + accountType);
		}
		}
	}

	public void selectLicenseType(String licenseType)
	{
		switch (licenseType)
		{
		case "startup" -> {
			pw_clickElement(AccountSetupRepository_4_8_8.startupselectplan);
		}
		case "pro" -> {
			pw_clickElement(AccountSetupRepository_4_8_8.proselectplan);
		}
		case "ep" -> {
			pw_clickElement(AccountSetupRepository_4_8_8.enterpriseselectplan);
		}
		default -> {
			throw new IllegalArgumentException("Unexpected value: " + licenseType);
		}
		}
	}

	// Key contact info

	public void selectSalutationAndName(String firstName, String lastName)
	{
		pw_clickElement(AccountSetupRepository_4_8_8.Salutation);
		pw_selectExactlistelements(AccountSetupRepository_4_8_8.commondropdown, "Mr.");
		pw_enterValue(AccountSetupRepository_4_8_8.FirstName, firstName);
		pw_enterValue(AccountSetupRepository_4_8_8.LastName, lastName);
	}

	public void selectCountryAndEnterMobileNumber(String mobileNumber)
	{
		pw_clickElement(AccountSetupRepository_4_8_8.SelectMobileNumberCountry);
		pw_selectExactlistelements(AccountSetupRepository_4_8_8.MobileNumbercountrydropdown, "India");
		pw_enterValue(AccountSetupRepository_4_8_8.MobileNumber, mobileNumber);
		pw_clickTab();
		pw_clickElement(AccountSetupRepository_4_8_8.otpokpoppup);
		pw_enterValue(AccountSetupRepository_4_8_8.MobileOtp, getWebmailOtp());
		pw_clickTab();
		threadSleep(ObjectRepository.wait2sec);
		pw_pageLoaderLogo();
	}

	public void selectJobFunctionAndPassword(String excelName, int row, String jobFunction, String password)
	{
		pw_clickElement(AccountSetupRepository_4_8_8.jobfunction);
		pw_selectExactlistelements(AccountSetupRepository_4_8_8.commondropdown, jobFunction);
		pw_enterValue(AccountSetupRepository_4_8_8.password, password);
		pw_enterValue(AccountSetupRepository_4_8_8.confirmpassword, password);
		DataInputProvider.writeUpdatedValueInSheet(row, 16, excelName, "Acc 4.8.8", password);
	}

	public void clickKeyContactInfoNext()
	{
		pw_clickElement(AccountSetupRepository_4_8_8.KeyContactNextButton);
	}

	public String getWebmailOtp()
	{
		String otpCode = null;
		Page oldPage = page;
		Page newPage = pw_openWindow();
		pw_launchUrl("https://webmail.resulticksmail.com/webmaillogout.cgi");
		pw_enterValue("Username,pw,#user", "vbnk7@resulticksmail.com");
		pw_enterValue("Password,pw,#pass", "vHGmMkC7raeqFX");
		pw_clickElement("Login_submit,pw,#login_submit");
		threadSleep(ObjectRepository.wait2sec);
		pw_doubleClick("unread Inbox,pw,(//span[contains(@title,'Unread')])[1]//parent::span//a");
		otpCode = pw_getStrText("Otp code,pw,//td[text()='OTP code: ']//parent::td//span");
		pw_closeChildWindow_OpenOldWindow(newPage, oldPage);
		return otpCode;
	}

	// Brand details

	public void enterParent_ChildCompanyAndBrandType(String parentCompany, String company, String brandType)
	{
		pw_enterValue(AccountSetupRepository_4_8_8.Parentcompanyname, parentCompany);
		pw_enterValue(AccountSetupRepository_4_8_8.Companyname, company);
		pw_clickElement(AccountSetupRepository_4_8_8.BranchType);
		pw_selectlistelements(AccountSetupRepository_4_8_8.commondropdown, brandType);
	}

	public void uploadCompanyLogo(String filePath)
	{
//		String file = "C:\\Users\\Vijay M\\git\\Resul_5.0\\src\\main\\resources\\data\\companylogo\\" + filePath + ".png";
		String file = "C:\\Users\\Vijay M\\git\\Resul_5.0\\src\\main\\resources\\data\\BrandLogo\\" + filePath + ".png";
		pw_uploadFile(AccountSetupRepository_4_8_8.Companylogo, file);
	}

	public void enterUrl(String url)
	{
		pw_enterValue(AccountSetupRepository_4_8_8.Website, url);
	}

	public void enterAddress_CityAndZipcode(String address, String city, String zipcode)
	{
		pw_enterValue(AccountSetupRepository_4_8_8.Address, address);
		pw_enterValue(AccountSetupRepository_4_8_8.City, city);
		pw_enterValue(AccountSetupRepository_4_8_8.Zipcode, zipcode);
	}

	public void selectIndustry_BusinessTypeAndBrandpositioning(String industry, String businessType, String brandPositioning)
	{
		threadSleep(1000);
		pw_clickElement(AccountSetupRepository_4_8_8.industry);
		pw_selectlistelements(AccountSetupRepository_4_8_8.commondropdown, industry);
		threadSleep(1000);
		pw_clickElement(AccountSetupRepository_4_8_8.BusinessType);
		pw_selectExactlistelements(AccountSetupRepository_4_8_8.commondropdown, businessType);
		threadSleep(500);
		String disabledState = pw_getTextBoxVal("Brand position,pw,span[aria-activedescendant='BrandPosition_option_selected']>span", "class");
		if (!disabledState.contains("disable"))
		{
			pw_clickElement(AccountSetupRepository_4_8_8.Brandposition);
			pw_selectlistelements(AccountSetupRepository_4_8_8.commondropdown, brandPositioning);
		}
	}

	public void selectInsertDefaultregion(String region)
	{
		if (!region.isEmpty())
		{
			pw_enterValue(AccountSetupRepository_4_8_8.Preferredregion, region);
		} else
		{
			pw_clickElement(AccountSetupRepository_4_8_8.Preferredregioncheckbox);
		}
	}

	public void selectCountryAndRegion(String country, String region)
	{
		pw_clickElement(AccountSetupRepository_4_8_8.countryoption);
		pw_selectExactlistelements(AccountSetupRepository_4_8_8.commondropdown, country);
		threadSleep(500);
		pw_clickElement(AccountSetupRepository_4_8_8.Regionoption);
		threadSleep(500);
		pw_selectExactlistelements(AccountSetupRepository_4_8_8.commondropdown, region);
	}

	public void clickBrandDetailsNextButton()
	{
		pw_clickElement(AccountSetupRepository_4_8_8.BrandDetailsNextButton);
	}

	// Localization setting

	public void selectDateFormat()
	{
		threadSleep(700);
		pw_clickElement(AccountSetupRepository_4_8_8.dateformat);
		if (regionName.equalsIgnoreCase("USA"))
		{
			threadSleep(800);
			pw_selectExactlistelements(AccountSetupRepository_4_8_8.commondropdown, "MM-DD-YYYY");
		} else
		{
			threadSleep(800);
			pw_selectExactlistelements(AccountSetupRepository_4_8_8.commondropdown, "DD-MM-YYYY");
		}
		threadSleep(500);
		pw_clickElement(AccountSetupRepository_4_8_8.timeformat);
		pw_selectlistelements(AccountSetupRepository_4_8_8.commondropdown, "24 hours");
	}

	public void selectTimeZone(String timezone)
	{
		threadSleep(300);
		pw_clickElement(AccountSetupRepository_4_8_8.timezone);
		pw_selectlistelements(AccountSetupRepository_4_8_8.commondropdown, timezone);
	}

	public void clickLocalizationSubmit()
	{
		pw_clickElement(AccountSetupRepository_4_8_8.submit);
	}

	public String getTimezone(String zipCode, String country)
	{
		String timeZone = null;
		String username = "vijay000";
		String url = "http://api.geonames.org/postalCodeLookupJSON?postalcode=" + zipCode + "&country=" + country + "&username=" + username;
		HttpURLConnection conn;
		try
		{
			conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("GET");

			Scanner scanner = new Scanner(conn.getInputStream());
			String response = scanner.useDelimiter("\\A").next();
			scanner.close();
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode rootNode = objectMapper.readTree(response);
			double lon = rootNode.get("postalcodes").get(0).get("lng").asDouble();
			double lat = rootNode.get("postalcodes").get(0).get("lat").asDouble();
			String timezoneUrl = "http://api.geonames.org/timezoneJSON?lat=" + lat + "&lng=" + lon + "&username=" + username;
			conn = (HttpURLConnection) new URL(timezoneUrl).openConnection();
			conn.setRequestMethod("GET");
			scanner = new Scanner(conn.getInputStream());
			response = scanner.useDelimiter("\\A").next();
			rootNode = objectMapper.readTree(response);
			timeZone = rootNode.get("timezoneId").asText();
			scanner.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return timeZone;
	}

	public int getRowSize(String excelName)
	{
		int lastRowNum = 0;
		try
		{
			XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\Vijay M\\git\\Resul_5.0\\src\\main\\resources\\data\\Team\\" + excelName + ".xlsx");
			XSSFSheet sheet = workbook.getSheet("Acc 4.8.8");
			lastRowNum = sheet.getLastRowNum();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return lastRowNum;
	}

	public String getsheetValue(String excelName, int rowI, int cellI)
	{
		String cellValue = "";
		try
		{
			XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\Vijay M\\git\\Resul_5.0\\src\\main\\resources\\data\\Team\\" + excelName + ".xlsx");
			XSSFSheet sheet = workbook.getSheet("Acc 4.8.8");
			XSSFRow row = sheet.getRow(rowI);
			XSSFCell cell = row.getCell(cellI);
			cellValue = cell.getStringCellValue();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return cellValue;
	}

	public String getPassword()
	{
		return generateRandomString(2, 2, 4, 1);
	}

	public String generateRandomString(int upperCount, int lowerCount, int numericCount, int specialCount)
	{
		final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
		final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
		final String NUMBER = "0123456789";
		final String SPECIAL_CHARS = "!@#$%^&*()_+-=[]{}|;:,.<>?";
		final SecureRandom random = new SecureRandom();

		if (upperCount < 0 || lowerCount < 0 || numericCount < 0 || specialCount < 0)
		{
			throw new IllegalArgumentException("Counts cannot be negative");
		}

		// Generate uppercase letters
		StringBuilder upperPart = new StringBuilder();
		for (int i = 0; i < upperCount; i++)
		{
			int randomIndex = random.nextInt(CHAR_UPPER.length());
			upperPart.append(CHAR_UPPER.charAt(randomIndex));
		}

		// Generate lowercase letters
		StringBuilder lowerPart = new StringBuilder();
		for (int i = 0; i < lowerCount; i++)
		{
			int randomIndex = random.nextInt(CHAR_LOWER.length());
			lowerPart.append(CHAR_LOWER.charAt(randomIndex));
		}

		// Generate numeric characters
		StringBuilder numericPart = new StringBuilder();
		for (int i = 0; i < numericCount; i++)
		{
			int randomIndex = random.nextInt(NUMBER.length());
			numericPart.append(NUMBER.charAt(randomIndex));
		}

		// Generate special characters
		StringBuilder specialPart = new StringBuilder();
		for (int i = 0; i < specialCount; i++)
		{
			int randomIndex = random.nextInt(SPECIAL_CHARS.length());
			specialPart.append(SPECIAL_CHARS.charAt(randomIndex));
		}

		// Combine all parts
		String combined = upperPart.toString() + lowerPart.toString() + numericPart.toString() + specialPart.toString();

		// Shuffle the combined string to randomize the order
		List<Character> chars = new ArrayList<>();
		for (char c : combined.toCharArray())
		{
			chars.add(c);
		}
		Collections.shuffle(chars, random);

		// Build the final string
		StringBuilder finalString = new StringBuilder();
		for (char c : chars)
		{
			finalString.append(c);
		}

		return finalString.toString();
	}

	public void accountSetupCreation(String excelName, int i)
	{
		businessMail = getsheetValue(excelName, i, 0);
		accountType = getsheetValue(excelName, i, 1);
		licenseType = getsheetValue(excelName, i, 2).toLowerCase();
		firstName = getsheetValue(excelName, i, 3);
		lastName = getsheetValue(excelName, i, 4);
		jobFunction = getsheetValue(excelName, i, 5);
		mobileNumber = "1122334455";
		parentCompany = getsheetValue(excelName, i, 7);
		brandType = getsheetValue(excelName, i, 8);
		website = getsheetValue(excelName, i, 9);
		address = getsheetValue(excelName, i, 10);
		city = getsheetValue(excelName, i, 11);
		zipcode = getsheetValue(excelName, i, 12);
		countryName = getsheetValue(excelName, i, 6);
		regionName = getsheetValue(excelName, i, 13);
		industry = getsheetValue(excelName, i, 14);;
		businessType = "B2B & B2C";
		brandPositioning = "Fortune 1000";
		timeZone = getsheetValue(excelName, i, 15);

		pw_launchUrl("https://run19.resulticks.com/");
		ClickAndEnterTheBusinessMailId(businessMail);
		selectAccountType(accountType);
		selectLicenseType(licenseType);

		// Key contact page
		selectSalutationAndName(firstName, lastName);
		selectJobFunctionAndPassword(excelName, i, jobFunction, getPassword());
		selectCountryAndEnterMobileNumber(mobileNumber);
		clickKeyContactInfoNext();
		threadSleep(500);

		// Brand details
		if (licenseType.equals("ep"))
		{
			uploadCompanyLogo(parentCompany);
			enterParent_ChildCompanyAndBrandType(parentCompany, parentCompany + "s", brandType);
			enterUrl(website);
			enterAddress_CityAndZipcode(address, city, zipcode);
			selectInsertDefaultregion(regionName);
			selectIndustry_BusinessTypeAndBrandpositioning(industry, businessType, brandPositioning);
			selectCountryAndRegion(countryName, regionName);
			clickBrandDetailsNextButton();
		} else
		{
			uploadCompanyLogo(parentCompany);
			pw_enterValue(AccountSetupRepository_4_8_8.Companyname, parentCompany);
			enterUrl(website);
			enterAddress_CityAndZipcode(address, city, zipcode);
			selectIndustry_BusinessTypeAndBrandpositioning(industry, businessType, brandPositioning);
			pw_clickElement(AccountSetupRepository_4_8_8.countryoption);
			pw_selectExactlistelements(AccountSetupRepository_4_8_8.commondropdown, countryName);
			threadSleep(500);
			clickBrandDetailsNextButton();
		}

		// localization setting
		selectDateFormat();
		selectTimeZone(timeZone);
//		clickLocalizationSubmit();

		// Thank you Page
//		try
//		{
//			pw_getStrText(AccountSetupRepository_4_8_8.thankYouPage);
//			BaseTest.getTest().log(Status.INFO, "<b>'" + businessMail + "'</b> account created successfully.");
//		} catch (Exception e)
//		{
//			BaseTest.getTest().log(Status.INFO, "<b>'" + businessMail + "'</b> account not created.");
//		}
	}

}
