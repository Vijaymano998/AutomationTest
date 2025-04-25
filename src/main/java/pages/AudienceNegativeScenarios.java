package pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.microsoft.playwright.Page;

import repository.AudienceRepository;
import repository.DashboardRepository;
import utility.BaseTest;
import utility.PageBase;
import utility.PageFactory;

public class AudienceNegativeScenarios extends AudiencePage_Upload
{
	public AudienceNegativeScenarios(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	// Validate add audience reset icon
	public void addAudienceResetIcon()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("SELECT SOURCE RESET ICON VALIDATE", ExtentColor.GREY));
		selectImportsource();
		clickElement(AudienceRepository.audience_selectsourcereseticon);
		selectImportsource();
	}

	// Validate list type reset icon
	public void listTypeResetIcon()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("LIST TYPE RESET ICON VALIDATE", ExtentColor.GREY));
		selectListtype();
		clickElement(AudienceRepository.audience_listtypereseticon);
		selectListtype();
		attributeMapping();
	}

	public String ImportDescriptionValue(String value)
	{
		enterValue(AudienceRepository.audience_importdescname, value);
		tabAction();
		explicitwaitforInvisibility(AudienceRepository.audience_importdesc_loader, 50);
		String uialphaNumericChar = getTextBoxVal(AudienceRepository.audience_importdescname, "value");
		return uialphaNumericChar;
	}

	public String checkImportDescriptionPlaceholder()
	{
		return getStrText(AudienceRepository.audience_importdescnameplaceholder);
	}

	public void clearImportDescriptionValue()
	{
		clearField(AudienceRepository.audience_importdescname);
	}

	public void checkImportDescriptionAlphaNumeric(String alphaNumericChar)
	{
		String labelName = BaseTest.getData().ListType.equals("Target list") ? "Import description" : "List name";
		String uialphaNumericChar = ImportDescriptionValue(alphaNumericChar);
		uiPageEqualswithInputValue(uialphaNumericChar, alphaNumericChar);
		String placeHolder = checkImportDescriptionPlaceholder();
		uiPageEqualswithInputValue(placeHolder, labelName);
		clearImportDescriptionValue();
		placeHolder = checkImportDescriptionPlaceholder();
		uiPageEqualswithInputValue(placeHolder, "Enter " + labelName.toLowerCase());
	}

	public void checkImportDescriptionMaximumCharacter(String maxChar)
	{
		String labelName = BaseTest.getData().ListType.equals("Target list") ? "Import description" : "List name";
		String uiMaxChar = ImportDescriptionValue(maxChar);
		uiPageEqualswithInputValueNumber(uiMaxChar.length(), 50);
		String placeHolder = checkImportDescriptionPlaceholder();
		uiPageEqualswithInputValue(placeHolder, labelName);
		clearImportDescriptionValue();
		placeHolder = checkImportDescriptionPlaceholder();
		uiPageEqualswithInputValue(placeHolder, "Enter " + labelName.toLowerCase());
	}

	public void checkImportDescriptionOnlyNumeric(String numericalVal)
	{
		String labelName = BaseTest.getData().ListType.equals("Target list") ? "Import description" : "List name";
		enterValue(AudienceRepository.audience_importdescname, numericalVal);
		tabAction();
		String uialphaNumericChar = getTextBoxVal(AudienceRepository.audience_importdescname, "value");
		uiPageEqualswithInputValue(uialphaNumericChar, numericalVal);
		String placeHolder = checkImportDescriptionPlaceholder();
		uiPageEqualswithInputValue(placeHolder, "Atleast one alphabet is required");
		clearImportDescriptionValue();
		placeHolder = checkImportDescriptionPlaceholder();
		uiPageEqualswithInputValue(placeHolder, "Enter " + labelName.toLowerCase());
	}

	public void checkImportDescriptionSpecialCharacter(String specialChar)
	{
		hasContainsSpecialChar(AudienceRepository.audience_importdescname, specialChar);
		String placeHolder = getStrText(AudienceRepository.audience_importdescnameplaceholder);
		uiPageEqualswithInputValue(placeHolder, "Only (_ & -) are allowed");
		clearImportDescriptionValue();
	}

	public void checkImportDescriptionWithExistingName(String existingListName)
	{
		String labelName = BaseTest.getData().ListType.equals("Target list") ? "Import description" : "List name";
		enterValue(AudienceRepository.audience_importdescname, existingListName);
		tabAction();
		explicitwaitforInvisibility(AudienceRepository.audience_importdesc_loader, 50);
		String existingErrmsg = getStrText(AudienceRepository.audience_importdescnameplaceholder);
		uiPageEqualswithInputValue(existingErrmsg, labelName + " '" + existingListName + "' is already exists");
		clearImportDescriptionValue();
	}

	public void checkImportDescriptionWithEmptySpace(String EmptySpace)
	{
		String labelName = BaseTest.getData().ListType.equals("Target list") ? "Import description" : "List name";
		enterValue(AudienceRepository.audience_importdescname, EmptySpace);
		tabAction();
		String emptyspace = getStrText(AudienceRepository.audience_importdescnameplaceholder);
		uiPageEqualswithInputValue(emptyspace, "Enter " + labelName.toLowerCase());
		uploadFieldIconValidate("off");
	}

	public void uploadFieldIconValidate(String buttonStatus)
	{
		String uploadButtonStatus = getTextBoxVal(AudienceRepository.audience_uploadfield, "class");
		if (uploadButtonStatus.toLowerCase().contains(buttonStatus))
		{
			BaseTest.getTest().log(Status.INFO, "Browser button in disable status as expected.");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Browser button is enable.");
		}
	}

	public void checkImportDescriptionWithSpace(String beforeSpaceChar, String afterSpaceChar)
	{
		String beforeSpaceTxt = ImportDescriptionValue(beforeSpaceChar);
		uiPageEqualswithInputValue(beforeSpaceTxt, beforeSpaceChar.trim());
		clearImportDescriptionValue();
		String afterSpaceTxt = ImportDescriptionValue(afterSpaceChar);
		uiPageEqualswithInputValue(afterSpaceTxt, afterSpaceChar.trim());
		clearImportDescriptionValue();
	}

	public void enterImportDescription(String importDescription)
	{
		enterValue(AudienceRepository.audience_importdescname, importDescription);
		tabAction();
		explicitwaitforInvisibility(AudienceRepository.audience_importdesc_loader, 50);
	}

	public void emptyCSVUpload()
	{
		audience_upload_File(BaseTest.getData().ChooseyourfileEmptyContentCsv);
		String emptyfileUploadErrMsg = getStrText(AudienceRepository.audience_uploadfieldErrMsg);
		uiPageEqualswithInputValue(emptyfileUploadErrMsg, "Upload a valid audience file");
	}

	public void invalidFileFormatUpdate()
	{
		String[] otherFiles = BaseTest.getData().ChooseyourfileOtherfiles.split(",");
		for (int file = 0; file < otherFiles.length; file++)
		{
			audience_upload_File(otherFiles[file]);
			String otherFileUploadErrMsg = getStrText(AudienceRepository.audience_uploadfieldErrMsg);
			uiPageEqualswithInputValue(otherFileUploadErrMsg, "Invalid file format");
		}
	}

	public void WithoutBrandIdUploadCsv()
	{
		audience_upload_File(BaseTest.getData().ChooseyourfileWrongHeader);
		String otherFileUploadErrMsg = getStrText(AudienceRepository.audience_uploadfieldErrMsg);
		uiPageEqualswithInputValue(otherFileUploadErrMsg, "Brand Id does not exist in the selected file");
	}

	public void onlyFileHeaderUploadCsv()
	{
		audience_upload_File(BaseTest.getData().ChooseyourfileOnlyheader);
		javaScriptScrollIntoView(AudienceRepository.audience_clickuploadbutton);
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_uploadedfile_name), 30);
		String csvName = getStrText(AudienceRepository.audience_uploadedfile_name);
		mousehoverJavaScript(replacePlaceHolder(AudienceRepository.audience_uploadfileexclamatory, csvName));
		String onlyHeaderUploadErrMsg = getStrText(DashboardRepository.allpage_tooltip);
		uiPageEqualswithInputValue(onlyHeaderUploadErrMsg, "Rows are not valid");
		audienceUploadedFileDelete(1);
	}

	public void maximumFileSizeUploadCsv()
	{
		String[] maxFileCsv = BaseTest.getData().ChooseyourfileExceedMaxSize.split(",");
		for (int csv = 0; csv < maxFileCsv.length; csv++)
		{
			audience_upload_File(maxFileCsv[csv]);
			pageLoaderLogo();
			String maxFileCSVUploadErrMsg = getStrText(AudienceRepository.audience_uploadfieldErrMsg);
			uiPageEqualswithInputValue(maxFileCSVUploadErrMsg, "");
		}
		String maxFileCSVUploadErrMsg = getStrText(AudienceRepository.audience_uploadfieldErrMsg);
		uiPageEqualswithInputValue(maxFileCSVUploadErrMsg, "Select file less than 10 MB");
	}

	public void moreThan10MBCsvFileUpload()
	{
		String[] maxFileUpload = BaseTest.getData().ChooseyourfileExceedMaxSize.split(",");
		try
		{
			audience_upload_File(maxFileUpload[5]);
		} catch (Exception e)
		{
			audience_upload_File(maxFileUpload[4]);
		}

		String maxFileUploadErrMsg = getStrText(AudienceRepository.audience_uploadfieldErrMsg);
		uiPageEqualswithInputValue(maxFileUploadErrMsg, "Select file less than 10 MB");
	}

	public void moreThanSixCsvFileUpload()
	{
		audience_upload_File(BaseTest.getData().Chooseyourfile1).audience_upload_File(BaseTest.getData().Chooseyourfile2).audience_upload_File(BaseTest.getData().Chooseyourfile3).audience_upload_File(BaseTest.getData().Chooseyourfile4)
				.audience_upload_File(BaseTest.getData().Chooseyourfile5).audience_upload_File(BaseTest.getData().Chooseyourfile6).audience_upload_File(BaseTest.getData().Chooseyourfile7);
		pageLoaderLogo();
		String morethanSixCSVUploadErrMsg = getStrText(AudienceRepository.audience_uploadfieldErrMsg);
		int fileCount = findElements(AudienceRepository.audience_uploadfile_Msg).size();
		if (morethanSixCSVUploadErrMsg.isEmpty() && fileCount > 6)
		{
			BaseTest.getTest().log(Status.FAIL, "Validation message is not displayed after uploaded more than 6 csv's.");
			BaseTest.takeScreenshot();
		} else
		{
			uiPageEqualswithInputValue(morethanSixCSVUploadErrMsg, "Max. of 6 file(s) can only be chosen");
		}
	}

	public void moreThanFiveCsvFileUpload()
	{
		audience_upload_File(BaseTest.getData().Chooseyourfile1).audience_upload_File(BaseTest.getData().Chooseyourfile2).audience_upload_File(BaseTest.getData().Chooseyourfile3).audience_upload_File(BaseTest.getData().Chooseyourfile4)
				.audience_upload_File(BaseTest.getData().Chooseyourfile5).audience_upload_File(BaseTest.getData().Chooseyourfile6);
		pageLoaderLogo();
		String morethanSixCSVUploadErrMsg = getStrText(AudienceRepository.audience_uploadfieldErrMsg);
		int fileCount = findElements(AudienceRepository.audience_uploadfile_Msg).size();
		if (morethanSixCSVUploadErrMsg.isEmpty() && fileCount > 5)
		{
			BaseTest.getTest().log(Status.FAIL, "Validation message is not displayed after uploaded more than 6 csv's.");
			BaseTest.takeScreenshot();
		} else
		{
			uiPageEqualswithInputValue(morethanSixCSVUploadErrMsg, "Max. of 5 file(s) can only be chosen");
		}
	}

	public void firstRowFirstColumnCheckbox()
	{
		clickElement(AudienceRepository.audience_columnheadertext);
		explicitwaitforvisibility(PageBase.autolocator(DashboardRepository.validation_message), 30);
		String validationMessage = getStrText(DashboardRepository.validation_message);
		uiPageEqualswithInputValue(validationMessage, "First row should be used as column header");
	}

	public void fileUploadCancelButton()
	{
		javaScriptScrollIntoView(AudienceRepository.audience_cancelbutton);
		clickElement(AudienceRepository.audience_cancelbutton);
		if (!isElementPresent(AudienceRepository.audience_clickListtype) && isElementPresent(AudienceRepository.audience_selectsource))
		{
			BaseTest.getTest().log(Status.INFO, "<b>'Add audience by'</b> field is only displayed, When clicked cancel button .");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "When clicked the cancel button, Page is not navigate to expected page");
		}
		BaseTest.takeScreenshot();
	}

	public void validateDoubleOptCheckBox()
	{
		clickElement(AudienceRepository.audience_seg_doubleoptcheckbox);
		String doubleOptValidationMessage = getStrText(DashboardRepository.validation_message);
		uiPageEqualswithInputValue(doubleOptValidationMessage, "Confirm double opt-in subscription");
		clickElement(AudienceRepository.audience_seg_doubleoptcheckbox);
	}

}
