package regression_Audience;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import pages.AudienceNegativeScenarios;
import pages.AudiencePage_Upload;
import pages.PreferencesPage;
import utility.BaseTest;
import utility.DataInputProvider;

/**
 * Regression test suite - Audience - All type of upload scenario's implemented in this class
 */
public class AudienceUploadScenarios extends BaseTest
{

	@Test(testName = "", description = "Audience Upload - Target list Single CSV File Upload")
	public void audienceUploadTargetListSingleCSV() throws IOException, InterruptedException, AWTException
	{
		Map<String, String> importtypes = new HashedMap<String, String>();
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();
//		AudienceDatabase db = getPageFactory().audienceDatabase();

		audi.login();

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu().clickAddaudience();
		String uploadformat = audi.selectImportsource();
		String importType = audi.selectListtype();
		audi.attributeMapping();
		audi.enterImportdesc();
		audi.audience_upload_File(BaseTest.getData().Chooseyourfile1);
		audi.clickUpload();
		audi.segmentationPageValidate();
		audi.selectDoubleOptchkbox();
		audi.clicksave().returntomasterlist();
		importtypes.put(importType, audi.ImportDescription);
//		db.validateAudienceUpload(importtypes, uploadformat);
		audi.importHistory(audi.ImportDescription);
		DataInputProvider.writeUpdatedValueInSheet(1, 1, "AudienceRegression", "BaseData", audi.ImportDescription);
	}

	@Test(testName = "", description = "Audience Upload - Adhoc list single CSV Files Upload")
	public void audienceUploadAdhocListSingleCSV()
	{
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();

		audi.login();

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu().clickAddaudience();
		audi.selectImportsource();
		audi.selectListtype();
		String ImportDescription = audi.enterImportdesc();
		audi.audience_upload_File(BaseTest.getData().Chooseyourfile1);
		audi.clickUpload();
		audi.importHistory(audi.ImportDescription);
		DataInputProvider.writeUpdatedValueInSheet(2, 1, "AudienceRegression", "BaseData", ImportDescription);
		audi.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList("AL_" + ImportDescription);
		getPageFactory().audiencepage_Targetlist().targetListSearchResult("AL_" + ImportDescription);
	}

	@Test(testName = "RESUL-ACTSTP-BRD-ENT-TS-001", description = "Audience Upload - Seed list single CSV File Upload")
	public void audienceUploadSeedListSingleCSV()
	{
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu().clickAddaudience();
		audi.selectImportsource();
		audi.selectListtype();
		String ImportDescription = audi.enterImportdesc();
		audi.audience_upload_File(BaseTest.getData().Chooseyourfile1);
		audi.clickUploadAndValidate();
		audi.segmentationPageValidate();
		audi.selectDoubleOptchkbox();
		audi.clicksave().returntomasterlist();
		audi.importHistory(audi.ImportDescription);
		DataInputProvider.writeUpdatedValueInSheet(5, 1, "AudienceRegression", "BaseData", ImportDescription);
		getPageFactory().audiencepage_Targetlist().targetListSearchResult("SL_" + ImportDescription);
	}

	@Test(testName = "RESUL-ACTSTP-BRD-ENT-TS-001", description = "Audience upload by selecting Match Input list with 6 CSV file")
	public void audienceUploadMatchInputListSixCSV()
	{
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu().clickAddaudience();
		audi.selectImportsource();
		audi.selectListtype();
		String ImportDescription = audi.enterImportdesc();
		audi.audience_upload_File(BaseTest.getData().Chooseyourfile1).audience_upload_File(BaseTest.getData().Chooseyourfile2).audience_upload_File(BaseTest.getData().Chooseyourfile3).audience_upload_File(BaseTest.getData().Chooseyourfile4)
				.audience_upload_File(BaseTest.getData().Chooseyourfile5).audience_upload_File(BaseTest.getData().Chooseyourfile6);
		audi.clickUploadAndValidate();
		audi.segmentationPageValidate();
		audi.selectDoubleOptchkbox();
		audi.clicksave().returntomasterlist();
		audi.importHistory(audi.ImportDescription);
		DataInputProvider.writeUpdatedValueInSheet(3, 1, "AudienceRegression", "BaseData", ImportDescription);
		getPageFactory().audiencepage_Targetlist().targetListSearchResult("ML_" + ImportDescription);
	}

	@Test(testName = "RESUL-ACTSTP-BRD-ENT-TS-001", description = "Audience upload by selecting Suppression Input list with 6 CSV file ")
	public void audienceUploadSuppressionInputListSixCSV()
	{
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu().clickAddaudience();
		audi.selectImportsource();
		audi.selectListtype();
		String ImportDescription = audi.enterImportdesc();
		audi.audience_upload_File(BaseTest.getData().Chooseyourfile1).audience_upload_File(BaseTest.getData().Chooseyourfile2).audience_upload_File(BaseTest.getData().Chooseyourfile3).audience_upload_File(BaseTest.getData().Chooseyourfile4)
				.audience_upload_File(BaseTest.getData().Chooseyourfile5).audience_upload_File(BaseTest.getData().Chooseyourfile6);
		audi.clickUploadAndValidate();
		audi.segmentationPageValidate();
		audi.selectDoubleOptchkbox();
		audi.clicksave().returntomasterlist();
		audi.importHistory(audi.ImportDescription);
		DataInputProvider.writeUpdatedValueInSheet(4, 1, "AudienceRegression", "BaseData", ImportDescription);
		getPageFactory().audiencepage_Targetlist().targetListSearchResult("SUP_" + ImportDescription);
	}

	@Test(testName = "RESUL-ACTSTP-BRD-ENT-TS-001", description = "Audience Upload - Adhoc list Five CSV Files Upload")
	public void audienceCSVFiveFilesUploadAdhcList() throws IOException
	{
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu().clickAddaudience();
		audi.selectImportsource();
		audi.selectListtype();
		String ImportDescription = audi.enterImportdesc();
		audi.audience_upload_File(BaseTest.getData().Chooseyourfile1).audience_upload_File(BaseTest.getData().Chooseyourfile2).audience_upload_File(BaseTest.getData().Chooseyourfile3);
		audi.audience_upload_File(BaseTest.getData().Chooseyourfile4).audience_upload_File(BaseTest.getData().Chooseyourfile5);
		audi.uploadedFileCount(5);
		audi.clickUpload();
		audi.importHistory(audi.ImportDescription);
		audi.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList("AL_" + ImportDescription);
		getPageFactory().audiencepage_Targetlist().targetListSearchResult("AL_" + ImportDescription);
	}

	@Test(testName = "", description = "Audience Upload - Target list Six CSV Files Upload")
	public void audienceCSVSixFilesUploadTrgtList() throws IOException
	{
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu().clickAddaudience();
		audi.selectImportsource();
		audi.selectListtype();
		audi.attributeMapping();
		String ImportDescription = audi.enterImportdesc();
		audi.audience_upload_File(BaseTest.getData().Chooseyourfile1).audience_upload_File(BaseTest.getData().Chooseyourfile2).audience_upload_File(BaseTest.getData().Chooseyourfile3);
		audi.audience_upload_File(BaseTest.getData().Chooseyourfile4).audience_upload_File(BaseTest.getData().Chooseyourfile5).audience_upload_File(BaseTest.getData().Chooseyourfile6);
		audi.uploadedFileCount(6);
		audi.clickUpload();
		audi.segmentationPageValidate();
		audi.selectDoubleOptchkbox();
		audi.clicksave().returntomasterlist();
		audi.importHistory(audi.ImportDescription);
	}

	@Test(testName = "RESUL-ACTSTP-BRD-ENT-TS-001", description = "Target list Audience Upload Page Negative Scenarios")
	public void targetListAudienceUploadPageNegativeScenario()
	{
		AudienceNegativeScenarios audi = getPageFactory().AudienceNegativeScenarios();

		String placeHolder = null;
		String alphaNumericChar = "Abc123";
		String MaxChar = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
		String EmptySpace = "           ";
		String numericalVal = System.getProperty("NumericalValue");
		String specialChar = System.getProperty("SpecialCharacter");
		String beforeSpaceChar = " Upload";
		String afterSpaceChar = "Upload    ";
		String existingListName = BaseTest.getData().DuplicateImportDesc;
		String importDescription = BaseTest.getData().ImportDescription + audi.addTimeToName().replaceAll("_", "");

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu().clickAddaudience();

		// Add Audience Reset Icon
		audi.addAudienceResetIcon();

		// ListType Reset Icon
		audi.listTypeResetIcon();

		BaseTest.getTest().info(MarkupHelper.createLabel("IMPORT DESCRIPTION FIELD VALIDATE", ExtentColor.GREY));
		// Import Description - Alphanumeric value
		audi.checkImportDescriptionAlphaNumeric(alphaNumericChar);

		// Import Description - Maximum character`
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate import description(Maximum character)", ExtentColor.GREY));
		audi.checkImportDescriptionMaximumCharacter(MaxChar);

		// Import Description - Numerical character
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate import description(Numerical character)", ExtentColor.GREY));
		audi.checkImportDescriptionOnlyNumeric(numericalVal);

		// Import Description - Special character
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate import description(Special character)", ExtentColor.GREY));
		audi.checkImportDescriptionSpecialCharacter(specialChar);

		// Import Description - Existing listname
//		audi.checkImportDescriptionWithExistingName(existingListName);

		// Import Description - empty space & Listname error message
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate import description(Empty space)", ExtentColor.GREY));
		audi.checkImportDescriptionWithEmptySpace(EmptySpace);

		// Import Description - Single space before& after check
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate import description(Space before and after Import desc)", ExtentColor.GREY));
		audi.checkImportDescriptionWithSpace(beforeSpaceChar, afterSpaceChar);

		// Import Description - Enter ImportDescription
		audi.enterImportDescription(importDescription);

		// Empty csv upload
		BaseTest.getTest().info(MarkupHelper.createLabel("UPLOAD FIELD VALIDATE", ExtentColor.GREY));
		audi.emptyCSVUpload();

		// other file upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Invalid file format", ExtentColor.GREY));
		audi.invalidFileFormatUpdate();

		// Without brand id upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Without brandId", ExtentColor.GREY));
		audi.WithoutBrandIdUploadCsv();

		// Only column header upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Only header without data", ExtentColor.GREY));
		audi.onlyFileHeaderUploadCsv();

		// Max 60 mb upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Upload maximum file size(Maximum 60mb)", ExtentColor.GREY));
		audi.maximumFileSizeUploadCsv();

		// More than 10MB csv upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Upload maximum file size(More than 10mb)", ExtentColor.GREY));
		audi.moreThan10MBCsvFileUpload();

		// More than 6 csv upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Upload more than six csv file upload", ExtentColor.GREY));
		audi.moreThanSixCsvFileUpload();

		// First row first column err msg
		BaseTest.getTest().info(MarkupHelper.createLabel("First row first column checkbox", ExtentColor.GREY));
		audi.firstRowFirstColumnCheckbox();

		// Cancel Button check
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate cancel button", ExtentColor.GREY));
		audi.fileUploadCancelButton();

	}

	@Test(testName = "RESUL-AUD-ADDAUD-SRC-CSV-TL-TS-002", description = "TargetList Column Mapping Page Negative Scenario")
	public void targetListColumnMappingPageNegativeScenario()
	{
		AudienceNegativeScenarios audi = getPageFactory().AudienceNegativeScenarios();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());
		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu().clickAddaudience();
		audi.selectImportsource();
		audi.selectListtype();
		audi.attributeMapping();
		audi.enterImportdesc();
		audi.audience_upload_File(BaseTest.getData().Chooseyourfile1);
		audi.clickUpload();
		audi.segmentationPageValidate();
		audi.selectDoubleOptchkbox();

		// double-opt checkbox
		audi.validateDoubleOptCheckBox();

		// Delete brand attribute
		audi.deleteListColumn("EmailID");
		audi.deleteListColumn("MobileNo");
		audi.clicksave();
		audi.returntomasterlist();
	}

	@Test(testName = "02", description = "Adhoc List Audience Upload Page Negative Scenario")
	public void adhocListAudienceUploadPageNegativeScenario()
	{
		AudienceNegativeScenarios audi = getPageFactory().AudienceNegativeScenarios();

		String alphaNumericChar = "Abc123";
		String MaxChar = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
		String EmptySpace = "           ";
		String numericalVal = System.getProperty("NumericalValue");
		String specialChar = System.getProperty("SpecialCharacter");
		String beforeSpaceChar = " Upload";
		String afterSpaceChar = "Upload    ";
		String existingListName = BaseTest.getData().DuplicateImportDesc;
		String importDescription = BaseTest.getData().ImportDescription + audi.addTimeToName().replaceAll("_", "");

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu().clickAddaudience();

		// Add Audience Reset Icon
		audi.addAudienceResetIcon();

		// ListType Reset Icon
		audi.listTypeResetIcon();

		BaseTest.getTest().info(MarkupHelper.createLabel("IMPORT DESCRIPTION FIELD VALIDATE", ExtentColor.GREY));
		// Import Description - Alphanumeric value
		audi.checkImportDescriptionAlphaNumeric(alphaNumericChar);

		// Import Description - Maximum character`
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate import description(Maximum character)", ExtentColor.GREY));
		audi.checkImportDescriptionMaximumCharacter(MaxChar);

		// Import Description - Numerical character
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate import description(Numerical character)", ExtentColor.GREY));
		audi.checkImportDescriptionOnlyNumeric(numericalVal);

		// Import Description - Special character
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate import description(Special character)", ExtentColor.GREY));
		audi.checkImportDescriptionSpecialCharacter(specialChar);

		// Import Description - Existing listname
//				audi.checkImportDescriptionWithExistingName(existingListName);

		// Import Description - empty space & Listname error message
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate import description(Empty space)", ExtentColor.GREY));
		audi.checkImportDescriptionWithEmptySpace(EmptySpace);

		// Import Description - Single space before& after check
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate import description(Space before and after Import desc)", ExtentColor.GREY));
		audi.checkImportDescriptionWithSpace(beforeSpaceChar, afterSpaceChar);

		// Import Description - Enter ImportDescription
		audi.enterImportDescription(importDescription);

		// Empty csv upload
		BaseTest.getTest().info(MarkupHelper.createLabel("UPLOAD FIELD VALIDATE", ExtentColor.GREY));
		audi.emptyCSVUpload();

		// other file upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Invalid file format", ExtentColor.GREY));
		audi.invalidFileFormatUpdate();

		// Without brand id upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Without brandId", ExtentColor.GREY));
		audi.WithoutBrandIdUploadCsv();

		// Only column header upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Only header without data", ExtentColor.GREY));
		audi.onlyFileHeaderUploadCsv();

		// Max 60 mb upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Upload maximum file size(Maximum 60mb)", ExtentColor.GREY));
		audi.maximumFileSizeUploadCsv();

		// More than 10MB csv upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Upload maximum file size(More than 10mb)", ExtentColor.GREY));
		audi.moreThan10MBCsvFileUpload();

		// More than 6 csv upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Upload more than five csv file upload", ExtentColor.GREY));
		audi.moreThanFiveCsvFileUpload();

		// First row first column err msg
		BaseTest.getTest().info(MarkupHelper.createLabel("First row first column checkbox", ExtentColor.GREY));
		audi.firstRowFirstColumnCheckbox();

		// Cancel Button check
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate cancel button", ExtentColor.GREY));
		audi.fileUploadCancelButton();
	}

	@Test(testName = "03", description = "Seed List Audience Upload Page Negative Scenario")
	public void seedListAudienceUploadPageNegativeScenario()
	{
		AudienceNegativeScenarios audi = getPageFactory().AudienceNegativeScenarios();

		String alphaNumericChar = "Abc123";
		String MaxChar = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
		String EmptySpace = "           ";
		String numericalVal = System.getProperty("NumericalValue");
		String specialChar = System.getProperty("SpecialCharacter");
		String beforeSpaceChar = " Upload";
		String afterSpaceChar = "Upload    ";
		String existingListName = BaseTest.getData().DuplicateImportDesc;
		String importDescription = BaseTest.getData().ImportDescription + audi.addTimeToName().replaceAll("_", "");

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu().clickAddaudience();

		// Add Audience Reset Icon
		audi.addAudienceResetIcon();

		// ListType Reset Icon
		audi.listTypeResetIcon();

		BaseTest.getTest().info(MarkupHelper.createLabel("IMPORT DESCRIPTION FIELD VALIDATE", ExtentColor.GREY));
		// Import Description - Alphanumeric value
		audi.checkImportDescriptionAlphaNumeric(alphaNumericChar);

		// Import Description - Maximum character`
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate import description(Maximum character)", ExtentColor.GREY));
		audi.checkImportDescriptionMaximumCharacter(MaxChar);

		// Import Description - Numerical character
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate import description(Numerical character)", ExtentColor.GREY));
		audi.checkImportDescriptionOnlyNumeric(numericalVal);

		// Import Description - Special character
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate import description(Special character)", ExtentColor.GREY));
		audi.checkImportDescriptionSpecialCharacter(specialChar);

		// Import Description - Existing listname
//						audi.checkImportDescriptionWithExistingName(existingListName);

		// Import Description - empty space & Listname error message
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate import description(Empty space)", ExtentColor.GREY));
		audi.checkImportDescriptionWithEmptySpace(EmptySpace);

		// Import Description - Single space before& after check
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate import description(Space before and after Import desc)", ExtentColor.GREY));
		audi.checkImportDescriptionWithSpace(beforeSpaceChar, afterSpaceChar);

		// Import Description - Enter ImportDescription
		audi.enterImportDescription(importDescription);

		// Empty csv upload
		BaseTest.getTest().info(MarkupHelper.createLabel("UPLOAD FIELD VALIDATE", ExtentColor.GREY));
		audi.emptyCSVUpload();

		// other file upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Invalid file format", ExtentColor.GREY));
		audi.invalidFileFormatUpdate();

		// Without brand id upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Without brandId", ExtentColor.GREY));
		audi.WithoutBrandIdUploadCsv();

		// Only column header upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Only header without data", ExtentColor.GREY));
		audi.onlyFileHeaderUploadCsv();

		// Max 60 mb upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Upload maximum file size(Maximum 60mb)", ExtentColor.GREY));
		audi.maximumFileSizeUploadCsv();

		// More than 10MB csv upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Upload maximum file size(More than 10mb)", ExtentColor.GREY));
		audi.moreThan10MBCsvFileUpload();

		// More than 6 csv upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Upload more than five csv file upload", ExtentColor.GREY));
		audi.moreThanFiveCsvFileUpload();

		// First row first column err msg
		BaseTest.getTest().info(MarkupHelper.createLabel("First row first column checkbox", ExtentColor.GREY));
		audi.firstRowFirstColumnCheckbox();

		// Cancel Button check
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate cancel button", ExtentColor.GREY));
		audi.fileUploadCancelButton();
	}

	@Test(testName = "03", description = "MatchInput List Audience Upload Page Negative Scenario")
	public void matchListAudienceUploadPageNegativeScenario()
	{
		AudienceNegativeScenarios audi = getPageFactory().AudienceNegativeScenarios();

		String alphaNumericChar = "Abc123";
		String MaxChar = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
		String EmptySpace = "           ";
		String numericalVal = System.getProperty("NumericalValue");
		String specialChar = System.getProperty("SpecialCharacter");
		String beforeSpaceChar = " Upload";
		String afterSpaceChar = "Upload    ";
		String existingListName = BaseTest.getData().DuplicateImportDesc;
		String importDescription = BaseTest.getData().ImportDescription + audi.addTimeToName().replaceAll("_", "");

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu().clickAddaudience();

		// Add Audience Reset Icon
		audi.addAudienceResetIcon();

		// ListType Reset Icon
		audi.listTypeResetIcon();

		BaseTest.getTest().info(MarkupHelper.createLabel("IMPORT DESCRIPTION FIELD VALIDATE", ExtentColor.GREY));
		// Import Description - Alphanumeric value
		audi.checkImportDescriptionAlphaNumeric(alphaNumericChar);

		// Import Description - Maximum character`
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate import description(Maximum character)", ExtentColor.GREY));
		audi.checkImportDescriptionMaximumCharacter(MaxChar);

		// Import Description - Numerical character
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate import description(Numerical character)", ExtentColor.GREY));
		audi.checkImportDescriptionOnlyNumeric(numericalVal);

		// Import Description - Special character
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate import description(Special character)", ExtentColor.GREY));
		audi.checkImportDescriptionSpecialCharacter(specialChar);

		// Import Description - Existing listname
//				audi.checkImportDescriptionWithExistingName(existingListName);

		// Import Description - empty space & Listname error message
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate import description(Empty space)", ExtentColor.GREY));
		audi.checkImportDescriptionWithEmptySpace(EmptySpace);

		// Import Description - Single space before& after check
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate import description(Space before and after Import desc)", ExtentColor.GREY));
		audi.checkImportDescriptionWithSpace(beforeSpaceChar, afterSpaceChar);

		// Import Description - Enter ImportDescription
		audi.enterImportDescription(importDescription);

		// Empty csv upload
		BaseTest.getTest().info(MarkupHelper.createLabel("UPLOAD FIELD VALIDATE", ExtentColor.GREY));
		audi.emptyCSVUpload();

		// other file upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Invalid file format", ExtentColor.GREY));
		audi.invalidFileFormatUpdate();

		// Without brand id upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Without brandId", ExtentColor.GREY));
		audi.WithoutBrandIdUploadCsv();

		// Only column header upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Only header without data", ExtentColor.GREY));
		audi.onlyFileHeaderUploadCsv();

		// Max 60 mb upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Upload maximum file size(Maximum 60mb)", ExtentColor.GREY));
		audi.maximumFileSizeUploadCsv();

		// More than 10MB csv upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Upload maximum file size(More than 10mb)", ExtentColor.GREY));
		audi.moreThan10MBCsvFileUpload();

		// More than 6 csv upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Upload more than six csv file upload", ExtentColor.GREY));
		audi.moreThanSixCsvFileUpload();

		// First row first column err msg
		BaseTest.getTest().info(MarkupHelper.createLabel("First row first column checkbox", ExtentColor.GREY));
		audi.firstRowFirstColumnCheckbox();

		// Cancel Button check
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate cancel button", ExtentColor.GREY));
		audi.fileUploadCancelButton();
	}

	@Test(testName = "03", description = "Suppression Input List Audience Upload Page Negative Scenario")
	public void suppressionListAudienceUploadPageNegativeScenario()
	{
		AudienceNegativeScenarios audi = getPageFactory().AudienceNegativeScenarios();

		String alphaNumericChar = "Abc123";
		String MaxChar = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
		String EmptySpace = "           ";
		String numericalVal = System.getProperty("NumericalValue");
		String specialChar = System.getProperty("SpecialCharacter");
		String beforeSpaceChar = " Upload";
		String afterSpaceChar = "Upload    ";
		String existingListName = BaseTest.getData().DuplicateImportDesc;
		String importDescription = BaseTest.getData().ImportDescription + audi.addTimeToName().replaceAll("_", "");

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu().clickAddaudience();

		// Add Audience Reset Icon
		audi.addAudienceResetIcon();

		// ListType Reset Icon
		audi.listTypeResetIcon();

		BaseTest.getTest().info(MarkupHelper.createLabel("IMPORT DESCRIPTION FIELD VALIDATE", ExtentColor.GREY));
		// Import Description - Alphanumeric value
		audi.checkImportDescriptionAlphaNumeric(alphaNumericChar);

		// Import Description - Maximum character`
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate import description(Maximum character)", ExtentColor.GREY));
		audi.checkImportDescriptionMaximumCharacter(MaxChar);

		// Import Description - Numerical character
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate import description(Numerical character)", ExtentColor.GREY));
		audi.checkImportDescriptionOnlyNumeric(numericalVal);

		// Import Description - Special character
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate import description(Special character)", ExtentColor.GREY));
		audi.checkImportDescriptionSpecialCharacter(specialChar);

		// Import Description - Existing listname
//				audi.checkImportDescriptionWithExistingName(existingListName);

		// Import Description - empty space & Listname error message
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate import description(Empty space)", ExtentColor.GREY));
		audi.checkImportDescriptionWithEmptySpace(EmptySpace);

		// Import Description - Single space before& after check
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate import description(Space before and after Import desc)", ExtentColor.GREY));
		audi.checkImportDescriptionWithSpace(beforeSpaceChar, afterSpaceChar);

		// Import Description - Enter ImportDescription
		audi.enterImportDescription(importDescription);

		// Empty csv upload
		BaseTest.getTest().info(MarkupHelper.createLabel("UPLOAD FIELD VALIDATE", ExtentColor.GREY));
		audi.emptyCSVUpload();

		// other file upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Invalid file format", ExtentColor.GREY));
		audi.invalidFileFormatUpdate();

		// Without brand id upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Without brandId", ExtentColor.GREY));
		audi.WithoutBrandIdUploadCsv();

		// Only column header upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Only header without data", ExtentColor.GREY));
		audi.onlyFileHeaderUploadCsv();

		// Max 60 mb upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Upload maximum file size(Maximum 60mb)", ExtentColor.GREY));
		audi.maximumFileSizeUploadCsv();

		// More than 10MB csv upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Upload maximum file size(More than 10mb)", ExtentColor.GREY));
		audi.moreThan10MBCsvFileUpload();

		// More than 6 csv upload
		BaseTest.getTest().info(MarkupHelper.createLabel("Upload more than six csv file upload", ExtentColor.GREY));
		audi.moreThanSixCsvFileUpload();

		// First row first column err msg
		BaseTest.getTest().info(MarkupHelper.createLabel("First row first column checkbox", ExtentColor.GREY));
		audi.firstRowFirstColumnCheckbox();

		// Cancel Button check
		BaseTest.getTest().info(MarkupHelper.createLabel("Validate cancel button", ExtentColor.GREY));
		audi.fileUploadCancelButton();
	}

	@Test(testName = "04", description = "New Attribute Creation In Column Mapping Page")
	public void newAttributeCreationInColumnMappingPage()
	{
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();
		PreferencesPage pref = getPageFactory().preferencesPage();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		String attributeName = "Newattribute" + audi.addTimeToName().replaceAll("_", "");
		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu().clickAddaudience();
		audi.selectImportsource();
		audi.selectListtype();
		audi.attributeMapping();
		audi.enterImportdesc();
		audi.audience_upload_File(BaseTest.getData().Chooseyourfile1);
		audi.clickUploadAndValidate();
		audi.pageLoaderLogo();
		audi.selectNewAttributeInColumnMappingPage();
		audi.createAttribute(attributeName);
		audi.selectDoubleOptchkbox();
		audi.clicksave().returntomasterlist();
		audi.clickPreferencePagefromMenu();
		audi.clickDataCatalogue();
		audi.searchAndValidateNewAttribute(attributeName);
	}

	@Test(description = "New attribute creation negative scenario")
	public void newAttributeCreationNegativeScenarios()
	{
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();
//		PreferencesPage pref = getPageFactory().preferencesPage();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		String attributeName = "Newattribute" + audi.addTimeToName().replaceAll("_", "");
		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu().clickAddaudience();
		audi.selectImportsource();
		audi.selectListtype();
		audi.attributeMapping();
		audi.enterImportdesc();
		audi.audience_upload_File(BaseTest.getData().Chooseyourfile1);
		audi.clickUploadAndValidate();
		audi.selectNewAttributeIcon();
		audi.createAttributeNegativeScenarios(attributeName);
	}

	@Test(testName = "", description = "Master data management - Overview Portlet")
	public void MDMOverviewScenarios()
	{
		// Overview Highchart validation
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu();
		audi.audienceMasterDataOverviewHighCharts();

		// Overview chart validation
		audi.refresh();
		audi.audienceOverviewcChannelPercentageAndTextValidation();
		audi.audienceOverviewChannelsTotalCountValidation();

		// Profile completeness
//		audi.audienceMasterDataProfileCompleteness();
	}

	@Test(description = "Master data management - Total, Email, Mobile and Notification - Info")
	public void MDMOverviewEmailSmsAndNotification()
	{
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu();
		audi.audienceMasterDataEmailSmsDataValidation();
		audi.overviewPieChartLegendValidate1();
		audi.audienceMasterDataNotificationDataValidation();
	}

	@Test(description = "Master data management - List acquisition portlet")
	public void audienceMasterDataListAcquisitionTableValidation()
	{
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu();
		audi.listAcquisitionChart();
		audi.listAcquisitionLegendValidate();
		audi.listAcquistionNotes();
		audi.listAcquisitionChartDateValidate();
//		audi.selectListAcquisitionCalender("All time");
//		audi.selectListAcquisitionSource("All sources");
//		audi.listAcquisitionChartValidate("email");
//		audi.listAcquisitionChartValidate("mobile");
	}

	@Test(testName = "", description = "Master data management - Create persona")
	public void createPersona_From_MDM()
	{
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();
		PreferencesPage pref = getPageFactory().preferencesPage();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu();
		audi.clickOverviewPortlet_Info_Icon("Total");
		audi.click_CreatePersona_From_MDM();
		pref.createPersona_From_AudienceScore();
	}

	@Test(description = "audience grid validation")
	public void audience_grid_validation()
	{
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu();
		audi.check_audience_Grid_table_Attributes();
		audi.select_unselect_audienceGridAttribute();
		audi.validateItemPerPages();
		audi.validateDisableAndEnableArrow();
	}

	@Test(testName = "", description = "Invalid Audience Download")
	public void invalidAudienceDownload()
	{
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu();
		audi.clickImportHistory();
		List<String> invalidImportDesc = audi.getAlertImportDescName();
		audi.downloadInvalidAudience(invalidImportDesc);
	}

	@Test(testName = "", description = "Upload Manual Entry")
	public void uploadManualEntry()
	{
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu().clickAddaudience();
		audi.selectImportsource();
		audi.ImportDescription = audi.enterImportdesc();
		audi.enterManualData();
		audi.clickUpload();
		audi.segmentationPageValidate();
		audi.selectDoubleOptchkbox();
		audi.clicksave().returntomasterlist();
		audi.importHistory(audi.ImportDescription);
	}

	@Test(testName = "", description = "CSV upload for child attribute")
	public void csvUploadForChildAttributes()
	{
		Map<String, String> importtypes = new HashedMap<String, String>();
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();
//		AudienceDatabase db = getPageFactory().audienceDatabase();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu().clickAddaudience();
		String uploadformat = audi.selectImportsource();
		String importType = audi.selectListtype();
		audi.attributeMapping();
		audi.ImportDescription = audi.enterImportdesc();
		audi.audience_upload_File(BaseTest.getData().Chooseyourfile1);
		audi.clickUpload();
		audi.segmentationPageValidate();
		audi.selectDoubleOptchkbox();
		audi.clicksave().returntomasterlist();
		importtypes.put(importType, audi.ImportDescription);
//		db.validateAudienceUpload(importtypes, uploadformat);
		audi.importHistory(audi.ImportDescription);
//		DataInputProvider.writeUpdatedValueInSheet(1, 1, "AudienceRegression", "BaseData", audi.ImportDescription);
	}

	@Test(testName = "04", description = "Child New Attribute Creation In Column Mapping Page")
	public void newAttributeCreationForChildAttributeInColumnMappingPage()
	{
		AudiencePage_Upload audi = getPageFactory().audiencepage_Upload();
		PreferencesPage pref = getPageFactory().preferencesPage();

		audi.login(audi.dPropertyLoginUserName(), audi.dPropertyLoginPswrd());

		String attributeName = "Newattribute" + audi.addTimeToName().replaceAll("_", "");
		audi.selectbusinessunit();
		audi.clickAudienceMasterdatafromMenu().clickAddaudience();
		audi.selectImportsource();
		audi.selectListtype();
		audi.attributeMapping();
		audi.enterImportdesc();
		audi.audience_upload_File(BaseTest.getData().Chooseyourfile1);
		audi.clickUploadAndValidate();
		audi.pageLoaderLogo();
		audi.selectNewAttributeInColumnMappingPage();
		audi.createAttribute(attributeName);
		audi.selectDoubleOptchkbox();
		audi.clicksave().returntomasterlist();
		audi.clickPreferencePagefromMenu();
		audi.clickDataCatalogue();
		audi.searchAndValidateNewAttribute(attributeName);
	}
}
