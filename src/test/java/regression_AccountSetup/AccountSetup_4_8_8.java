package regression_AccountSetup;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.AccountSetupPage_4_8_8;
import utility.BaseTest;

public class AccountSetup_4_8_8 extends BaseTest
{

//	@Test(testName = "Account setup 4.8.8", description = "Brand Account Create")
//	public void brandAccountCreate1()
//	{
//		AccountSetupPage_4_8_8 acc = getPageFactory().AccountSetupPage_4_8_8();
//		brandAccountCreate_iterate();
//		acc.pw_launchUrl("https://run.resulticks.com/");
//		acc.ClickAndEnterTheBusinessMailId(BaseTest.getData().businessMail);
//		acc.selectAccountType(BaseTest.getData().accountType);
//		acc.selectLicenseType(BaseTest.getData().licenseType);
//
//		// Key contact page
//		acc.selectSalutationAndName(BaseTest.getData().salutation, BaseTest.getData().firstName, BaseTest.getData().lastName);
//		acc.selectJobFunctionAndPassword(BaseTest.getData().jobFunction, BaseTest.getData().password);
//		acc.selectCountryAndEnterMobileNumber(BaseTest.getData().mobileNumbercountry, BaseTest.getData().mobileNumber);
//		acc.clickKeyContactInfoNext();
//
//		// Brand details
//		acc.uploadCompanyLogo(BaseTest.getData().companylogopath);
//		acc.enterParent_ChildCompanyAndBrandType(BaseTest.getData().parentCompany, BaseTest.getData().company, BaseTest.getData().brandType);
//		acc.enterUrl(BaseTest.getData().website);
//		acc.enterAddress_CityAndZipcode(BaseTest.getData().address, BaseTest.getData().city, BaseTest.getData().zipcode);
//		acc.selectInsertDefaultregion(BaseTest.getData().preferredRegion);
//		acc.selectIndustry_BusinessTypeAndBrandpositioning(BaseTest.getData().industry, BaseTest.getData().businessType, BaseTest.getData().brandPositioning);
//		acc.selectCountryAndRegion(BaseTest.getData().countryName, BaseTest.getData().regionName);
//		acc.clickBrandDetailsNextButton();
//
//		// localization setting
//		acc.selectDateFormat(BaseTest.getData().dateFormat, BaseTest.getData().timeformat);
//		acc.selectTimeZone(BaseTest.getData().timeZone);
//		acc.clickLocalizationSubmit();

	// Thank you Page
//		try
//		{
//			acc.pw_getStrText(AccountSetupRepository_4_8_8.thankYouPage);
//			BaseTest.getTest().log(Status.INFO, "<b>'" + businessMail + "'</b> account created successfully.");
//		} catch (Exception e)
//		{
//			BaseTest.getTest().log(Status.INFO, "<b>'" + businessMail + "'</b> account not created.");
//		}
//	}

	@Test(testName = "Account setup 4.8.8", description = "Brand Account Create")
	public void brandAccountCreate1()
	{
		AccountSetupPage_4_8_8 acc = getPageFactory().AccountSetupPage_4_8_8();

		String excelName = "AccountSetupRegression4.8.8";
		int rowCount = acc.getRowSize(excelName);

		for (int i = 1; i <= rowCount; i++)
		{
			acc.businessMail = acc.getsheetValue(excelName, i, 0);
			acc.accountType = acc.getsheetValue(excelName, i, 1);
			acc.licenseType = acc.getsheetValue(excelName, i, 2);
			acc.firstName = acc.getsheetValue(excelName, i, 3);
			acc.lastName = acc.getsheetValue(excelName, i, 4);
			acc.jobFunction = acc.getsheetValue(excelName, i, 5);
			acc.mobileNumber = "1122334455";
			acc.parentCompany = acc.getsheetValue(excelName, i, 7);
			acc.brandType = acc.getsheetValue(excelName, i, 8);
			acc.website = acc.getsheetValue(excelName, i, 9);
			acc.address = acc.getsheetValue(excelName, i, 10);
			acc.city = acc.getsheetValue(excelName, i, 11);
			acc.zipcode = acc.getsheetValue(excelName, i, 12);
			acc.countryName = acc.getsheetValue(excelName, i, 6);
			acc.regionName = acc.getsheetValue(excelName, i, 13);
			acc.industry = acc.getsheetValue(excelName, i, 14);;
			acc.businessType = "B2B & B2C";
			acc.brandPositioning = "Fortune 1000";
			acc.timeZone = acc.getsheetValue(excelName, i, 15);

			acc.pw_launchUrl("https://run19.resulticks.com/");
			acc.ClickAndEnterTheBusinessMailId(acc.businessMail);
			acc.selectAccountType(acc.accountType);
			acc.selectLicenseType(acc.licenseType.toLowerCase());

			// Key contact page
			acc.selectSalutationAndName(acc.firstName, acc.lastName);
			acc.selectJobFunctionAndPassword(excelName, i, acc.jobFunction, acc.getPassword());
			acc.selectCountryAndEnterMobileNumber(acc.mobileNumber);
			acc.clickKeyContactInfoNext();

			// Brand details
			acc.uploadCompanyLogo(acc.parentCompany);
			acc.enterParent_ChildCompanyAndBrandType(acc.parentCompany, acc.parentCompany + "s", acc.brandType);
			acc.enterUrl(acc.website);
			acc.enterAddress_CityAndZipcode(acc.address, acc.city, acc.zipcode);
			acc.selectInsertDefaultregion(acc.regionName);
			acc.selectIndustry_BusinessTypeAndBrandpositioning(acc.industry, acc.businessType, acc.brandPositioning);
			acc.selectCountryAndRegion(acc.countryName, acc.regionName);
			acc.clickBrandDetailsNextButton();

			// localization setting
			acc.selectDateFormat();
			acc.selectTimeZone(acc.timeZone);
//			acc.clickLocalizationSubmit();

			// Thank you Page
//			try
//			{
//				acc.pw_getStrText(AccountSetupRepository_4_8_8.thankYouPage);
//				BaseTest.getTest().log(Status.INFO, "<b>'" + businessMail + "'</b> account created successfully.");
//			} catch (Exception e)
//			{
//				BaseTest.getTest().log(Status.INFO, "<b>'" + businessMail + "'</b> account not created.");
//			}
		}

	}

	@Test(testName = "Account setup 4.8.8", description = "Brand Account Create")
	public void brandAccountCreate()
	{
		AccountSetupPage_4_8_8 acc = getPageFactory().AccountSetupPage_4_8_8();

		String excelName = "AccountSetupRegression4.8.8";
		int rowCount = acc.getRowSize(excelName);

		for (int row = 1; row <= rowCount; row++)
		{
			try
			{
				acc.accountSetupCreation(excelName, row);
			} catch (Exception e)
			{
				BaseTest.getTest().log(Status.WARNING, "Unable to create account : " + acc.businessMail);
			}
		}

	}

}
