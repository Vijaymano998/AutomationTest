package pages;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.microsoft.playwright.Page;

import repository.AudienceRepository;
import repository.DashboardRepository;
import repository.ObjectRepository;
import repository.PreferencesRepository;
import utility.BaseTest;
import utility.ExtentManager;
import utility.PageBase;
import utility.PageFactory;

public class AudiencePage_Upload extends HomePage
{

	public AudiencePage_Upload(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	// Click to add Audience
	public AudiencePage_Upload clickAddaudience()
	{
		explicitwaitforclick(autolocator(AudienceRepository.audience_addAudience), 90);
		toolTipValidationKnownText(AudienceRepository.audience_addAudience, "Add audience");
		explicitwaitforclick(autolocator(AudienceRepository.audience_addAudience), 60);
		clickElement(AudienceRepository.audience_addAudience);
		pageLoaderLogo();
		explicitwaitforclick(autolocator(AudienceRepository.audience_selectsource), 60);
		breadcrumbTextCheck("Audience,Add audience");
		BaseTest.getTest().info(MarkupHelper.createLabel("ADD AUDIENCE PAGE", ExtentColor.INDIGO));
		return this;
	}

	// Select Import Source Type CSV,Manual..etc
	public String selectImportsource()
	{
		String addAudienceby = BaseTest.getData().AddAudienceby;
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_uploadheader), 40);
		explicitwaitforclick(autolocator(AudienceRepository.audience_selectsource), 30);
		placeholderValueCheck(AudienceRepository.audience_selectsource_placeholder, "Source");
		pageLoaderLogo();
		clickElement(AudienceRepository.audience_selectsource);
		uiPageEqualswithMultipleInputValue(DashboardRepository.homepage_audience_uploadsourceselect, "Manual entry,CSV,Remote data source,FTP/SFTP");
		pageLoaderLogo();
		audienceSelectlistelements(DashboardRepository.allpage_common_selectdropdownlist, addAudienceby);
		pageLoaderLogo();
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_selectsourcereseticon), 30);
		// toolTipValidationKnownText(AudienceRepository.audience_selectsourcereseticon, "Reset");
		return addAudienceby;
	}

	public void enterManualData()
	{
		String inputPlaceholder = "Name,EmailID,MobileNo,Age,City";
		String inputHelpText = "Update new data - if a match is found, overwrite the older record";
		String input = BaseTest.getData().Chooseyourfile1;
		enterValue(AudienceRepository.audience_addaudiencemanualinputfield, input);
		String uiPlaceholder = getStrText(AudienceRepository.audience_addaudiencemanualplaceholder);
		writeLog(uiPlaceholder.equals(inputPlaceholder), uiPlaceholder + " placeholder is present as expected.", uiPlaceholder + " placeholder is not present as expected.");
		String uiHelpText = getStrText(AudienceRepository.audience_addaudiencemanualhelptext);
		writeLog(uiHelpText.equals(inputHelpText), uiHelpText + " helptext is present as expected.", uiHelpText + " helptext is present as expected.");
	}

	// Select New List Type Target,seed, in audience upload page....etc
	public String selectListtype()
	{
		String listType = BaseTest.getData().ListType;
		explicitwaitforclick(autolocator(AudienceRepository.audience_clickListtype), 30);
		placeholderValueCheck(AudienceRepository.audience_listtype_placeholder, "List type");
		clickElement(AudienceRepository.audience_clickListtype);
		if (BaseTest.getData().AddAudienceby.equalsIgnoreCase("csv"))
		{
			uiPageEqualswithMultipleInputValue(DashboardRepository.allpage_common_selectdropdownlist, "Ad-hoc list,Seed list,Target list,Match input list,Suppression input list");
		}
		selectlistelements(DashboardRepository.homepage_audience_uploadsourceselect, BaseTest.getData().ListType);
//		if (condition)
//		{
//
//		}

		String listTypePlaceholder = getStrText(AudienceRepository.audience_afterchooselisttype_placeholder);
		uiPageEqualswithInputValue(listTypePlaceholder, listType);
		if (!listType.equals("Target list"))
		{
			listContentCheck(listType);
			clickElement(AudienceRepository.audience_agreeAndProceed);
		}
		toolTipValidationKnownText(AudienceRepository.audience_listtypereseticon, "Reset");
		if (!listType.equals("Seed list"))
		{
			if (listType.equals("Ad-hoc list"))
			{
				String maxFileMsg = getStrText(AudienceRepository.audience_uploadmaxfile);
				uiPageEqualswithInputValue(maxFileMsg, "Accepts only .csv file and a Max. of 5 files");
				explicitwaitforclick(autolocator(AudienceRepository.audience_helptextQuestionmarkicon), 30);
				clickElement(AudienceRepository.audience_helptextQuestionmarkicon);
				explicitwaitforvisibility(autolocator(AudienceRepository.audience_helptextcontent), 30);
				String helpText = getStrText(AudienceRepository.audience_helptextcontent);
				uiPageEqualswithInputValue(helpText,
						"Note: A max. of 5 files can be selected per import. Each file size should not be more than 10MB, and overall file size should not exceed 50MB. The column headers should match across all the CSV files in case of multiple file uploads.");
			} else
			{
				String maxFileMsg = getStrText(AudienceRepository.audience_uploadmaxfile);
				uiPageEqualswithInputValue(maxFileMsg, "Accepts only .csv file and a Max. of 6 files");
				explicitwaitforclick(autolocator(AudienceRepository.audience_helptextQuestionmarkicon), 30);
				clickElement(AudienceRepository.audience_helptextQuestionmarkicon);
				explicitwaitforvisibility(autolocator(AudienceRepository.audience_helptextcontent), 30);
				String helpText = getStrText(AudienceRepository.audience_helptextcontent);
				uiPageEqualswithInputValue(helpText,
						"Note: A max. of 6 files can be selected per import. Each file size should not be more than 10MB, and overall file size should not exceed 60MB. The column headers should match across all the CSV files in case of multiple file uploads.");
			}
		}
		if (!listType.equals("Seed list"))
		{
			try
			{
				explicitwaitforclick(autolocator(AudienceRepository.audience_helptextQuestionmarkicon), 50);
				clickElement(AudienceRepository.audience_helptextQuestionmarkicon);
			} catch (Exception e)
			{
				BaseTest.getTest().log(Status.WARNING, "Question mark icon is not available.");
			}
		}

		threadSleep(400);
		if (isElementPresent(AudienceRepository.audience_helptextcontent))
		{
			BaseTest.getTest().log(Status.FAIL, "Help text is not visible as expected.");
		} else
		{
			BaseTest.getTest().log(Status.INFO, "After clicking the help text close icon help text is visible");
		}
//		threadSleep(ObjectRepository.wait1sec);
		explicitwaitforclick(autolocator(AudienceRepository.audience_listtypereseticon), 30);
		return listType;
	}

	public void listContentCheck(String listType)
	{
		try
		{
			String popuphint = null;
			List<String> condition = new ArrayList<>();
			String popupHeader = getStrText(AudienceRepository.audience_listpopupheader);
			List<WebElement> findElements = findElements(AudienceRepository.audience_listpopupcondition);
			for (WebElement uiCondition : findElements)
			{
				String text = uiCondition.getText();
				condition.add(text);
			}
			if (listType.equalsIgnoreCase("Adhoc-list"))
			{
				uiPageEqualswithInputValue(popupHeader, "Ad-hoc list consideration:");
				List<String> input = new ArrayList<String>(Arrays.asList("Each file can contain up to 5 million records with 12 attributes.", "You can upload up to 5 CSV files. Each file should not exceed 10MB in size.",
						"Ensure consistent column headers across all CSV files (in multiple files upload).", "This list will expire in 120 days and cannot be used thereafter.",
						"Spaces in column headers will be automatically replaced with underscores (e.g., \"First Name\" becomes \"First_Name\").", "Processing 1 million records may take up to 3 hours.",
						"Duplicate values in the CSV file will not be removed.", "Presence of bad or spam trap email IDs can negatively impact your sender domain reputation."));
				for (int i = 0; i < input.size(); i++)
				{
					uiPageEqualswithInputValue(condition.get(i), input.get(i));
				}
			} else if (listType.equalsIgnoreCase("Seed list"))
			{
				uiPageEqualswithInputValue(popupHeader, "Seed list consideration:");
				List<String> input = new ArrayList<>(
						Arrays.asList("Only 1 CSV file can be uploaded at a time.", "The file size must not exceed 10 MB.", "Each file can contain up to 500 audience records with 20 attributes.", "A maximum of 100 seed lists can be created per BU.",
								"The CSV file must contain a valid email id or mobile number for each audience record.", "This list may hinder your email sender domain score reputation, if it may contain any bad email id's / spam trap email id's."));
				for (int i = 0; i < input.size(); i++)
				{
					uiPageEqualswithInputValue(condition.get(i), input.get(i));
				}
			} else if (listType.equalsIgnoreCase("Match input list"))
			{
				uiPageEqualswithInputValue(popupHeader, "Match input list consideration:");
				List<String> input = new ArrayList<>(Arrays.asList("Each file can contain up to 5 million records with 5 attributes.", "Each file should not exceed 10MB in size.",
						"Ensure consistent column headers across all CSV files (in multiple files upload)", "All the column headers should match with existing attributes.",
						"Spaces in column headers will be automatically replaced with underscores (e.g., \"First Name\" becomes \"First_Name\").", "You can upload up to 6 CSV files.", "Processing 1 million records may take up to 3 hours."));
				for (int i = 0; i < input.size(); i++)
				{
					uiPageEqualswithInputValue(condition.get(i), input.get(i));
				}
			} else if (listType.equalsIgnoreCase("Suppression input list"))
			{
				uiPageEqualswithInputValue(popupHeader, "Suppression input list consideration:");
				List<String> input = new ArrayList<>(Arrays.asList("Each file can contain up to 5 million records with 5 attributes.", "Each file should not exceed 10MB in size.",
						"Ensure consistent column headers across all CSV files (in multiple files upload)", "All the column headers should match with existing attributes.",
						"Spaces in column headers will be automatically replaced with underscores (e.g., \"First Name\" becomes \"First_Name\").", "You can upload up to 6 CSV files.", "Processing 1 million records may take up to 3 hours."));
				for (int i = 0; i < input.size(); i++)
				{
					uiPageEqualswithInputValue(condition.get(i), input.get(i));
				}
			}
		} catch (Exception e)
		{
			BaseTest.getTest().log(Status.FAIL, "Not able to verify listtype popup content.");
			BaseTest.takeScreenshot();
		}
	}

	// Select adhoc agreement
	public AudiencePage_Upload selectAdhocAgreementProceed()
	{
		threadSleep(ObjectRepository.wait1sec);
		clickElement(AudienceRepository.audience_selectagreement);
		return this;
	}

	public String attributeMapping()
	{
		String attributeMapping = null;
		if (BaseTest.getData().ListType.equals("Target list"))
		{
			attributeMapping = BaseTest.getData().AttributeMapping;
			explicitwaitforclick(autolocator(AudienceRepository.audience_attributemapping), 30);
			placeholderValueCheck(AudienceRepository.audience_attributemappingplaceholder, "Select");
			clickElement(AudienceRepository.audience_attributemapping);
			uiPageEqualswithMultipleInputValue(DashboardRepository.homepage_audience_uploadsourceselect, "Parent,Child");
			audienceSelectlistelements(DashboardRepository.homepage_audience_uploadsourceselect, BaseTest.getData().AttributeMapping);
			if (attributeMapping.equalsIgnoreCase("child"))
			{
				if (BaseTest.getData().ListType.equals("Target list"))
				{
					attributeMapping = BaseTest.getData().AttributeMapping;
					explicitwaitforclick(autolocator(AudienceRepository.audience_attributemapping), 30);
					placeholderValueCheck(AudienceRepository.audience_attributemappingplaceholder, "Select");
					clickElement(AudienceRepository.audience_attributemapping);
					uiPageEqualswithMultipleInputValue(AudienceRepository.audience_attributemappingDropdown, "Parent,Child");
					audienceSelectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().AttributeMapping);
					if (attributeMapping.equalsIgnoreCase("child"))
					{
						String categoryType = BaseTest.getData().Categorytype;
						explicitwaitforclick(autolocator(AudienceRepository.audience_categorytype), 30);
						placeholderValueCheck(AudienceRepository.audience_categorytypeplaceholder, "Category type");
						clickElement(AudienceRepository.audience_categorytype);
						threadSleep(300);
						boolean childAttributeStatus = audienceSelectlistelements(DashboardRepository.allpage_common_selectdropdownlist, categoryType);
						if (!childAttributeStatus)
						{
							String attributeName = "childAttribute" + addTimeToName().replaceAll("_", "");
							clickPreferencePagefromMenu();
							clickDataCatalogue();
							clickAddAttribute();
							createAttribute(attributeName, attributeMapping);
							clickAudienceMasterdatafromMenu().clickAddaudience();
							selectImportsource();
							selectListtype();
							clickElement(AudienceRepository.audience_attributemapping);
							audienceSelectlistelements(DashboardRepository.homepage_audience_uploadsourceselect, BaseTest.getData().AttributeMapping);
							clickElement(AudienceRepository.audience_categorytype);
							audienceSelectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "new" + attributeName);
						}
					}
				}
			}
			return attributeMapping;
		} else
		{
			return attributeMapping;
		}
	}

	// Enter Import Description Name
	public String enterImportdesc()
	{
		ImportDescription = BaseTest.getData().ImportDescription + addTimeToName().replaceAll("_", "");
		explicitwaitforclick(autolocator(AudienceRepository.audience_importdescname), 30);
		if (BaseTest.getData().ListType.equals("Target list") || BaseTest.getData().ListType.equals("Manual entry"))
		{
			placeholderValueCheck(AudienceRepository.audience_importdescnameplaceholder, "Import description");
		} else
		{
			placeholderValueCheck(AudienceRepository.audience_importdescnameplaceholder, "List name");
		}
		clickElement(AudienceRepository.audience_importdescname);
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_importdescname), 30);
		enterValue(AudienceRepository.audience_importdescname, ImportDescription);
		tabAction();
		isDisplayed(AudienceRepository.audience_descnamevalidationicon);
		return ImportDescription;
	}

	public AudiencePage_Upload enterImportdescNegative(String importDescription)
	{
		threadSleep(ObjectRepository.wait5sec);
		explicitwaitforclick(autolocator(AudienceRepository.audience_importdescname), 30);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.audience_importdescname);
		enterValue(AudienceRepository.audience_importdescname, importDescription);
		return this;
	}

	// Audience Upload file select csv ,xml
	public AudiencePage_Upload audience_upload_File(String fileName)
	{
		String path = BaseTest.extractResourceToTempFile("data\\uploadfiles\\" + fileName, ".xlsx");
//		String file = detectFilePath(BaseTest.curr_Dir + "\\src\\main\\resources" + "\\data\\uploadfiles\\" + fileName);
		sendValues(AudienceRepository.audience_fileupload, path);
		String columnHeaderText = getStrText(AudienceRepository.audience_columnheadertext);
		uiPageEqualswithInputValue(columnHeaderText, "Use the first row as the column header");
		String checkboxStatus = getTextBoxVal(AudienceRepository.audience_helptextcheckbox, "value");
		if (checkboxStatus.equals("true"))
		{
			BaseTest.getTest().log(Status.INFO, "Use the first row as the column header checkbox is <b>'checked'</b> as expected.");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Use the first row as the column header checkbox is not 'checked'.");
		}
		pageLoaderLogo();
		return this;
	}

	public void audienceUploadedFileDelete(int delete)
	{
		List<String> fileNames = new ArrayList<>();
		javaScriptScrollIntoView(AudienceRepository.audience_clickuploadbutton);
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_uploadedfile_name), 30);
		List<WebElement> csvNames = findElements(AudienceRepository.audience_uploadedfile_name);
		for (WebElement names : csvNames)
		{
			csvNames = findElements(AudienceRepository.audience_uploadedfile_name);
			String fileName = names.getText();
			fileNames.add(fileName);
		}
		for (int i = 0; i < delete; i++)
		{
			String fileName = fileNames.get(i);
			javaScriptScrollIntoView(replacePlaceHolder(AudienceRepository.audience_uploaddeleteicon, fileName));
			clickElement(replacePlaceHolder(AudienceRepository.audience_uploaddeleteicon, fileName));
			clickElement(AudienceRepository.audience_uploaddeletepopup_okicon);
		}
	}

	public void audienceUploadedFileDelete()
	{
		List<WebElement> deleteIcon;
		javaScriptScrollIntoView(AudienceRepository.audience_clickuploadbutton);
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_uploadedfile_name), 30);
		deleteIcon = findElements(AudienceRepository.audience_uploadedfiledeleteIcon);
		for (WebElement ele : deleteIcon)
		{
			deleteIcon = findElements(AudienceRepository.audience_uploadedfiledeleteIcon);
			ele.click();
		}
	}

	public AudiencePage_Upload uploadedFileCount(int filecount)
	{
		List<WebElement> uploadedcsvfiles = findElements(AudienceRepository.audience_uploadedfileInfo);
		int totalcsvfiles = uploadedcsvfiles.size();
		if (totalcsvfiles != filecount)
		{
			BaseTest.takeScreenshot();
			BaseTest.getTest().log(Status.FAIL, "Uploaded csv files not uploaded successfully");
		}
		return this;
	}

	// Method to click on upload button
	public AudiencePage_Upload clickUploadAndValidate()
	{
		pageLoaderLogo();
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_uploadfile), 60);
		javaScriptScrollDown();
		String message = getStrText(AudienceRepository.audience_uploadfile_Msg);
		if (message.equalsIgnoreCase("Verified - Valid"))
		{
			javaScriptHighLightElement(AudienceRepository.audience_uploadfile_Msg);
			javaScriptScrollDown();
			if (BaseTest.getData().ListType.equals("Target list"))
			{
				String helpTextHeader = getStrText(AudienceRepository.audience_helptext2header);
				uiPageEqualswithInputValue(helpTextHeader, "Import preferences");
				String helptextContent = getStrText(AudienceRepository.audience_helptext2content);
				uiPageEqualswithInputValue(helptextContent, "Update new data - if a match is found, overwrite the older record");
			}
			explicitwaitforclick(autolocator(AudienceRepository.audience_clickuploadbutton), 30);
			clickElement(AudienceRepository.audience_clickuploadbutton);
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Uploaded CSV is Invalid");
			BaseTest.takeScreenshot();
		}
		pageLoaderLogo();
		threadSleep(400);
		pageLoaderLogo();
		return this;
	}

	public void selectNewAttributeIcon()
	{
		explicitwaitforclick(autolocator(AudienceRepository.audience_attributeheader), 50);
		clickElement(AudienceRepository.audience_attributeheader);
		explicitwaitforclick(autolocator(AudienceRepository.audience_newattributeIcon), 60);
		clickElement(AudienceRepository.audience_newattributeIcon);
	}

	public void clickUpload()
	{
		pageLoaderLogo();
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_uploadfile), 60);
		javaScriptScrollDown();
		explicitwaitforclick(autolocator(AudienceRepository.audience_clickuploadbutton), 30);
		clickElement(AudienceRepository.audience_clickuploadbutton);
		pageLoaderLogo();
	}

	public boolean selectAttribute()
	{
		String listType = BaseTest.getData().ListType;
		boolean val = false;
		List<String> attributes = new ArrayList<>();
		List<WebElement> columnNames = findElements(AudienceRepository.audience_seg_attributeDropdown);
		for (int columnCount = 0; columnCount < columnNames.size(); columnCount++)
		{
			columnNames = findElements(AudienceRepository.audience_seg_attributeDropdown);
			String attributeSelection = columnNames.get(columnCount).getAttribute("style");
			String attributeName = columnNames.get(columnCount).getText();
			if (attributeSelection.isEmpty())
			{
				String count = String.valueOf(columnCount + 1);
				javaScriptScrollIntoView(replacePlaceHolder(AudienceRepository.audience_seg_scrollToSpecificElement, count));
				clickElement(replacePlaceHolder(AudienceRepository.audience_seg_addImportdescriptionDropdown, count));
				enterValue(AudienceRepository.audience_seg_enterAttributeName, attributeName);
				if (!isElementPresent(AudienceRepository.audience_seg_attributenamenodatafound))
				{
					if (!selectexactlistelements(DashboardRepository.allpage_common_selectdropdownlist, attributeName))
					{
						clearField(AudienceRepository.audience_seg_enterAttributeName);
						if (!isElementPresent(AudienceRepository.audience_seg_newattribute))
						{
							if (listType.equals("Seed list"))
							{
								BaseTest.getTest().log(Status.INFO, "New attribute is not present in the attribute selection dropdown");
								attributes.add(attributeName);
								val = true;
							} else
							{
								BaseTest.getTest().log(Status.FAIL, "'New attribute' dropdown value is not present.");
								BaseTest.takeScreenshot();
							}
						} else
						{
							if (!listType.equals("Seed list"))
							{
								clickElement(AudienceRepository.audience_seg_newattribute);
								createAttribute(attributeName);
							}
						}
					} else
					{
						BaseTest.getTest().log(Status.INFO, "Attribute Name is presented and selected in the dropdown.");
						BaseTest.takeScreenshot();
					}
				} else
				{
					clearField(AudienceRepository.audience_seg_enterAttributeName);
					if (!isElementPresent(AudienceRepository.audience_seg_newattribute))
					{
						if (listType.equals("Seed list"))
						{
							BaseTest.getTest().log(Status.INFO, "New attribute is not present in the attribute selection dropdown");
							attributes.add(attributeName);
							val = true;
						} else
						{
							BaseTest.getTest().log(Status.FAIL, "'New attribute' dropdown value is not present.");
							BaseTest.takeScreenshot();
						}
					} else
					{
						if (!listType.equals("Seed list"))
						{
							clickElement(AudienceRepository.audience_seg_newattribute);
							createAttribute(attributeName);
						}
					}
				}
			}
		}
		if (val)
		{
			seedListAttributeSelection(attributes);
			clickAudienceMasterdatafromMenu().clickAddaudience();
			selectImportsource();
			selectListtype();
			ImportDescription = enterImportdesc();
			audience_upload_File(BaseTest.getData().Chooseyourfile1);
			clickUploadAndValidate();
			segmentationPageValidate();
		}
		return val;
	}

	public void selectNewAttributeInColumnMappingPage()
	{
		findElements(AudienceRepository.audience_attributeheader).get(1).click();
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_newattributeIcon), 60);
		clickElement(AudienceRepository.audience_newattributeIcon);
		pageLoaderLogo();
	}

	public void createAttribute(String attributeName)
	{
		pageLoaderLogo();
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_seg_newattributeheader), 30);
		enterValue(AudienceRepository.audience_seg_attributeNameField, attributeName);
		enterValue(AudienceRepository.audience_seg_description, BaseTest.getData().Description);
		tabAction();
		String dataType = getStrText(AudienceRepository.audience_seg_datatype);
		if (BaseTest.getData().AttributeMapping.toLowerCase().contains("parent"))
		{
			writeLog(dataType.equals("Regular Data"), "Segmentation data type <b>'" + dataType + "'</b> is present as expected <b>'Regular Data'</b>.", "Segmentation data type <b>'" + dataType + "'</b> is present as expected <b>'Regular Data'</b>.");
		} else if (BaseTest.getData().AttributeMapping.toLowerCase().contains("child"))
		{
			writeLog(dataType.equals("Transaction Data"), "Segmentation data type <b>'" + dataType + "'</b> is present as expected <b>'Transaction Data'</b>.",
					"Segmentation data type <b>'" + dataType + "'</b> is present as expected <b>'Transaction Data'</b>.");
		}
		clickElement(AudienceRepository.audience_seg_inputtype);
		uiPageEqualswithMultipleInputValue(AudienceRepository.audience_seg_dropdownValue, "Text,Integer,Decimal,Date");
		audienceSelectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().InputType);
		clickElement(AudienceRepository.audience_seg_filtergroup);
		uiPageEqualswithMultipleInputValue(AudienceRepository.audience_seg_dropdownValue, "Brand,Communication,Customer,Fingerprint,Others,Versium");
		audienceSelectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().FilterGroup);
		clickElement(AudienceRepository.audience_seg_classification);
		uiPageEqualswithMultipleInputValue(AudienceRepository.audience_seg_dropdownValue, "Audience overview,Profile completeness,Personalisation,Content target,Sensitive data,Advanced analytics,Offline conversion,Audience base,Offers,GDPR");
		audienceSelectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().Classification);
		if (BaseTest.getData().Classification.contains("Personalisation"))
		{
			enterValue(AudienceRepository.audience_seg_fallbackName, attributeName + "FL");
		}
		BaseTest.takeScreenshot();
		clickElement(AudienceRepository.audience_seg_newAttributeSave);
		pageLoaderLogo();
	}

	public void createAttribute(String attributeName, String dataType)
	{
		pageLoaderLogo();
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_seg_newattributeheader), 30);
		enterValue(AudienceRepository.audience_seg_attributeNameField, attributeName);
		enterValue(AudienceRepository.audience_seg_description, BaseTest.getData().Description);
		tabAction();
		clickElement(AudienceRepository.audience_seg_datatype);
		if (dataType.toLowerCase().contains("parent"))
		{
			audienceSelectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Regular Data");
			writeLog(dataType.equals("Regular Data"), "Segmentation data type <b>'" + dataType + "'</b> is present as expected <b>'Regular Data'</b>.", "Segmentation data type <b>'" + dataType + "'</b> is present as expected <b>'Regular Data'</b>.");
		} else if (dataType.toLowerCase().contains("child"))
		{
			String newCatagoryType = "new" + attributeName;
			audienceSelectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Transaction Data");
			clickElement(AudienceRepository.audience_seg_catagoryType);
			clickElement(AudienceRepository.audience_seg_newcatagoryType);
			enterValue(AudienceRepository.audience_seg_newcatagorytypeText, newCatagoryType);
			tabAction();
			pageLoaderLogo();
			clickElement(AudienceRepository.audience_seg_newcatagoryTypeSaveIcon);
			threadSleep(500);
			pageLoaderLogo();
			threadSleep(500);
			clickElement(AudienceRepository.audience_seg_catagoryType);
			audienceSelectlistelements(DashboardRepository.allpage_common_selectdropdownlist, newCatagoryType);
			pageLoaderLogo();
			writeLog(dataType.equals("Transaction Data"), "Segmentation data type <b>'" + dataType + "'</b> is present as expected <b>'Transaction Data'</b>.",
					"Segmentation data type <b>'" + dataType + "'</b> is present as expected <b>'Transaction Data'</b>.");
		}
		pageLoaderLogo();
		clickElement(AudienceRepository.audience_seg_inputtype);
		audienceSelectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().InputType);
		clickElement(AudienceRepository.audience_seg_filtergroup);
		audienceSelectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().FilterGroup);
		clickElement(AudienceRepository.audience_seg_classification);
		audienceSelectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().Classification);
		if (BaseTest.getData().Classification.contains("Personalisation"))
		{
			enterValue(AudienceRepository.audience_seg_fallbackName, attributeName + "FL");
		}
		BaseTest.takeScreenshot();
		clickElement(AudienceRepository.audience_seg_newAttributeSave);
		pageLoaderLogo();
	}

	public void createAttributeNegativeScenarios(String attributeName)
	{
		String alphaNumericChar = "Abc123";
		String MaxChar = System.getProperty("300char");
		String EmptySpace = "           ";
		String numericalVal = System.getProperty("NumericalValue");
		String specialChar = System.getProperty("SpecialCharacter");
		String beforeSpaceChar = " Upload";
		String afterSpaceChar = "Upload    ";
		String existingAttributeName = BaseTest.getData().DuplicateImportDesc;

		// new attribute - Alphanumeric value
		pageLoaderLogo();
		BaseTest.getTest().info(MarkupHelper.createLabel("IMPORT DESCRIPTION FIELD VALIDATE", ExtentColor.GREY));
		enterValue(AudienceRepository.audience_seg_attributeNameField, alphaNumericChar);
		tabAction();
		explicitwaitforInvisibility(AudienceRepository.audience_importdesc_loader, 50);
		String uialphaNumericChar = getTextBoxVal(AudienceRepository.audience_seg_attributeNameField, "value");
		uiPageEqualswithInputValue(uialphaNumericChar, alphaNumericChar);
		String placeHolder = getStrText(AudienceRepository.audience_seg_attributeNamePlaceholder);
		uiPageEqualswithInputValue(placeHolder, "Attribute name");
		clearField(AudienceRepository.audience_seg_attributeNameField);

		// new attribute - Maximum character
		enterValue(AudienceRepository.audience_seg_attributeNameField, MaxChar);
		tabAction();
		explicitwaitforInvisibility(AudienceRepository.audience_importdesc_loader, 50);
		String uiMaxChar = getTextBoxVal(AudienceRepository.audience_seg_attributeNameField, "value");
		uiPageEqualswithInputValueNumber(uiMaxChar.length(), 50);
		placeHolder = getStrText(AudienceRepository.audience_seg_attributeNamePlaceholder);
		uiPageEqualswithInputValue(placeHolder, "Attribute name");
		clearField(AudienceRepository.audience_seg_attributeNameField);

		// new attribute - Numerical character
		enterValue(AudienceRepository.audience_seg_attributeNameField, numericalVal);
		tabAction();
		String numVal = getTextBoxVal(AudienceRepository.audience_seg_attributeNameField, "value");
		uiPageEqualswithInputValue(numVal, numericalVal);
		placeHolder = getStrText(AudienceRepository.audience_seg_attributeNamePlaceholder);
		uiPageEqualswithInputValue(placeHolder, "Atleast one alphabet is required");
		clearField(AudienceRepository.audience_seg_attributeNameField);

		// new attribute - Special character
		hasContainsSpecialChar(AudienceRepository.audience_seg_attributeNameField, specialChar);
		placeHolder = getStrText(AudienceRepository.audience_seg_attributeNamePlaceholder);
		uiPageEqualswithInputValue(placeHolder, "Only (_ & -) are allowed");
		clearField(AudienceRepository.audience_seg_attributeNameField);

		// new attribute - Existing attribute name
		enterValue(AudienceRepository.audience_seg_attributeNameField, existingAttributeName);
		tabAction();
		explicitwaitforInvisibility(AudienceRepository.audience_importdesc_loader, 50);
		String existingErrmsg = getStrText(AudienceRepository.audience_seg_attributeNamePlaceholder);
		uiPageEqualswithInputValue(existingErrmsg, "Attribute name already exists");
		clearField(AudienceRepository.audience_seg_attributeNameField);

		// new attribute - empty space & attribute name error message
		enterValue(AudienceRepository.audience_seg_attributeNameField, EmptySpace);
		tabAction();
		String emptyspace = getStrText(AudienceRepository.audience_importdescnameplaceholder);
		uiPageEqualswithInputValue(emptyspace, "Enter attribute name");

		// new attribute - Single space before&after check
		enterValue(AudienceRepository.audience_seg_attributeNameField, beforeSpaceChar);
		tabAction();
		explicitwaitforInvisibility(AudienceRepository.audience_importdesc_loader, 50);
		String beforeSpaceTxt = getTextBoxVal(AudienceRepository.audience_seg_attributeNameField, "value");
		uiPageEqualswithInputValue(beforeSpaceTxt, beforeSpaceChar.trim());
		clearField(AudienceRepository.audience_seg_attributeNameField);
		enterValue(AudienceRepository.audience_seg_attributeNameField, afterSpaceChar);
		tabAction();
		explicitwaitforInvisibility(AudienceRepository.audience_importdesc_loader, 50);
		clearField(AudienceRepository.audience_seg_attributeNameField);
		enterValue(AudienceRepository.audience_seg_attributeNameField, attributeName);
		tabAction();
		explicitwaitforInvisibility(AudienceRepository.audience_importdesc_loader, 50);

		enterValue(AudienceRepository.audience_seg_description, MaxChar);
		String maxText = getTextBoxVal(AudienceRepository.audience_seg_description, "value");
		uiPageEqualswithInputValueNumber(maxText.length(), 150);
		clearField(AudienceRepository.audience_seg_description);

		String descriptionHelpText = getStrText(AudienceRepository.audience_seg_descriptionhelptext);
		uiPageEqualswithInputValue(descriptionHelpText, "Max. 150 characters");
		clearField(AudienceRepository.audience_seg_description);

		// Validate Datatype dropdown ------> Commented due to recent update
//		clickElement(AudienceRepository.audience_seg_datatype);
//		uiPageEqualswithMultipleInputValue(AudienceRepository.audience_seg_dropdownValue, "Regular Data,Transaction Data,KPI Data");
//		clickElement(AudienceRepository.audience_seg_datatype);
//		attributeDataTypeCheck("KPI Data");
//		attributeDataTypeCheck("Regular Data");

		// check disabled status
		String status = getTextBoxVal(AudienceRepository.audience_seg_datatypefield, "class");
		writeLog(status.contains("disabled"), "Data type field is in disable state.", "Data type field is not in disable state.");
		String dataType = getStrText(AudienceRepository.audience_seg_datatype);
		uiPageEqualswithInputValue(dataType, "Regular Data");

		// Validate input type
		clickElement(AudienceRepository.audience_seg_inputtype);
		uiPageEqualswithMultipleInputValue(AudienceRepository.audience_seg_dropdownValue, "Text,Integer,Decimal,Date");
		clickElement(AudienceRepository.audience_seg_inputtype);
		attributeInputTypeCheck("Text");
		attributeInputTypeCheck("Integer");
		attributeInputTypeCheck("Decimal");
		attributeInputTypeCheck("Date");
		attributeInputTypeCheck("Text");

		// validate filter group
		pageLoaderLogo();
		tabAction();
		clickElement(AudienceRepository.audience_seg_filtergroup);
		uiPageEqualswithMultipleInputValue(AudienceRepository.audience_seg_dropdownValue, "Brand,Communication,Customer,Fingerprint,Others,Versium");
		clickElement(AudienceRepository.audience_seg_filtergroup);
		attributeDropdownCheck(AudienceRepository.audience_seg_filtergroup);
		selectlistelements(AudienceRepository.audience_seg_dropdownValue, "Others");

		// validate classification
		clickElement(AudienceRepository.audience_seg_classification);
		uiPageEqualswithMultipleInputValue(AudienceRepository.audience_seg_classification, "Audience overview,Profile completeness,Personalisation,Content target,Sensitive data,Advanced analytics,Offline conversion,Audience base,Offers,GDPR");
		clickElement(AudienceRepository.audience_seg_classification);
		attributeClassificationCheck(AudienceRepository.audience_seg_classification);

	}

	public void attributeInputTypeCheck(String inputType)
	{
		clickElement(AudienceRepository.audience_seg_inputtype);
		audienceSelectlistelements(DashboardRepository.allpage_common_selectdropdownlist, inputType);
		if (inputType.equals("Date"))
		{
			if (isElementPresent(AudienceRepository.audience_seg_inputtypedatafromatfield))
			{
				String dataeFormats = "dd/mm/yy;dd/mm/yyyy;dd-mmm-yy;dd-mmm-yyyy;yy/mm/dd;yyyy/mm/dd;mm/dd/yy;mm/dd/yyyy;mmm-dd-yy;mmm-dd-yyyy;yyyy-mm-dd;mm/dd/yyyy, hh:mm ss;mm/dd/yyyy, HH:MM;dd/mm/yyyy, hh:mm ss;dd/mm/yyyy, HH:MM;dd-mm-yyyy";
				BaseTest.getTest().log(Status.INFO, "Date format type dropdown is present as expected.");
				clickElement(AudienceRepository.audience_seg_inputtypedatafromatfield);
				uiPageEqualsWithMultipleInputValue(DashboardRepository.allpage_common_selectdropdownlist, dataeFormats);
				tabAction();
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Date format type dropdown is not displayed.");
				BaseTest.takeScreenshot();
			}
		}
		threadSleep(200);
		String uiInputType = getStrText(AudienceRepository.audience_seg_inputtype);
		uiPageEqualswithInputValue(uiInputType, inputType);
	}

	public void attributeDropdownCheck(String pr)
	{
		clickElement(pr);
		List<WebElement> values = findElements(DashboardRepository.allpage_common_selectdropdownlist);
		for (int i = 0; i < values.size(); i++)
		{
			threadSleep(300);
			values = findElements(DashboardRepository.allpage_common_selectdropdownlist);
			String dropdownValue = values.get(i).getText();
			values.get(i).click();
			String uiInputType = getStrText(pr);
			uiPageEqualswithInputValue(uiInputType, dropdownValue);
			clickElement(pr);
		}
	}

	public void attributeClassificationCheck(String pr)
	{
		List<String> list = new LinkedList<String>();
		clickElement(pr);
		List<WebElement> values = findElements(DashboardRepository.allpage_common_selectdropdownlist);
		for (int i = 0; i < values.size(); i++)
		{
			threadSleep(300);
			values = findElements(DashboardRepository.allpage_common_selectdropdownlist);
			String dropdownValue = values.get(i).getText();
			if (!dropdownValue.equals("Content target"))
			{
				list.add(dropdownValue);
				values.get(i).click();
				clickElement(pr);
			}
		}
		tabAction();
		List<WebElement> attributes = findElements(AudienceRepository.audience_seg_classificationValues);
		for (int i = 0; i < list.size(); i++)
		{
			String uiAttribute = attributes.get(i).getText();
			String expectedAttribute = list.get(i);
			uiPageEqualswithInputValue(uiAttribute, expectedAttribute);
		}
	}

	public void attributeDataTypeCheck(String dataType)
	{
		clickElement(AudienceRepository.audience_seg_datatype);
		audienceSelectlistelements(DashboardRepository.allpage_common_selectdropdownlist, dataType);
		if (dataType.equals("Transaction Data"))
		{
			// Need to update after fixing the failures
		} else if (dataType.equals("KPI Data"))
		{
			String iconStatus = driver.findElement(autolocator(AudienceRepository.audience_seg_conditionAddicon)).getAttribute("class");
			int count = 0;
			while (!iconStatus.contains("off"))
			{
				clickElement(AudienceRepository.audience_seg_conditionAddicon);
				iconStatus = driver.findElement(autolocator(AudienceRepository.audience_seg_conditionAddicon)).getAttribute("class");
				count++;
			}
			if (count == 3)
			{
				List<WebElement> conditionDropdown = findElements(AudienceRepository.audience_seg_conditionsourcedropdownfield);
				List<WebElement> conditionTextField = findElements(AudienceRepository.audience_seg_conditiontextfield);
				for (int i = 0; i < conditionDropdown.size(); i++)
				{
					String val = String.valueOf(i + 1);
					conditionDropdown.get(i).click();
					tabAction();
					conditionTextField.get(i).click();
					tabAction();
					String conditionDropdownErrMsg = getStrText(replacePlaceHolder(AudienceRepository.audience_seg_conditiondropdown, val));
					String conditionTextErrMsg = getStrText(replacePlaceHolder(AudienceRepository.audience_seg_conditionText, val));
					uiPageEqualswithInputValue(conditionDropdownErrMsg, "This field is required");
					uiPageEqualswithInputValue(conditionTextErrMsg, "This field is required");
					conditionDropdown.get(i).click();
					audienceSelectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "CSV");
					conditionTextField.get(i).sendKeys("BaseAudience");
					String dropdownLabelName = getStrText(replacePlaceHolder(AudienceRepository.audience_seg_dropdownLabelName, val));
					uiPageEqualswithInputValue(dropdownLabelName, "Select attribute");
					String textLabelName = getStrText(replacePlaceHolder(AudienceRepository.audience_seg_textlabelname, val));
					uiPageEqualswithInputValue(textLabelName, "Text");
				}
				String minusStatus = getTextBoxVal(AudienceRepository.audience_seg_condition_minus, "class");
				while (!minusStatus.contains("off"))
				{
					clickElement(AudienceRepository.audience_seg_condition_minus);
					minusStatus = getTextBoxVal(AudienceRepository.audience_seg_condition_minus, "class");
				}
			}
			List<WebElement> kpiTypes = findElements(AudienceRepository.audience_seg_kpitype);
			String[] kpiTypeInput = { "Count", "Min", "Max", "Sum", "Average", "Duration" };
			for (int kpiType = 0; kpiType < kpiTypes.size(); kpiType++)
			{
				String uiKpiType = kpiTypes.get(kpiType).getText();
				uiPageEqualswithInputValue(uiKpiType, kpiTypeInput[kpiType]);
			}
		}

	}

	public void deleteListColumn(String name)
	{
		WebElement columnDeleteIcon;
		mouseHover(replacePlaceHolder(AudienceRepository.audience_seg_attributeHeader, name));
		if (name.contains("Email"))
		{
			try
			{
				columnDeleteIcon = driver.findElement(autolocator(replacePlaceHolder(AudienceRepository.audience_seg_attributeminusIcon, name)));
				BaseTest.getTest().log(Status.FAIL, "When mousehover the EmailId field delete Icon is visible.");
			} catch (Exception e)
			{
				BaseTest.getTest().log(Status.INFO, "When mousehover the EmailId field delete Icon is not visible.");
				BaseTest.takeScreenshot();
			}
		} else
		{
			columnDeleteIcon = driver.findElement(autolocator(replacePlaceHolder(AudienceRepository.audience_seg_attributeminusIcon, name)));
			columnDeleteIcon.click();
			clickOk();
		}
	}

	public String segmentationPageValidate()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("AUDIENCE UPLOAD COLUMN MAPPING PAGE", ExtentColor.INDIGO));
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_target_SegmentationGrid), 60);
		String segPageHelpText = getStrText(AudienceRepository.audience_mappinghelptextheader);
		uiPageEqualswithInputValue(segPageHelpText, "New audience list");
		String helpTextContent = getStrText(AudienceRepository.audience_mappinghelptextcontent);
		uiPageEqualswithInputValue(helpTextContent, "To map the data header with the available attributes, refer the first row.");
		pageLoaderLogo();
		String audienceCount = getStrText(AudienceRepository.audience_seg_audiencecount);
		selectAttribute();
		return audienceCount;
	}

	public String seedListsegmentationPageValidate()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("AUDIENCE UPLOAD COLUMN MAPPING PAGE", ExtentColor.INDIGO));
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_target_SegmentationGrid), 60);
		String segPageHelpText = getStrText(AudienceRepository.audience_helptext2header);
		uiPageEqualswithInputValue(segPageHelpText, "New audience list");
		String helpTextContent = getStrText(AudienceRepository.audience_seg_helptextcontent);
		uiPageEqualswithInputValue(helpTextContent, "To map the data header with the available attributes, refer the first row.");
		pageLoaderLogo();
		String audienceCount = getStrText(AudienceRepository.audience_seg_audiencecount);
		selectDoubleOptchkbox();
		return audienceCount;

	}

	public void seedListAttributeSelection(List<String> attributes)
	{
		List<String> notAvailAttributes = new ArrayList<>();
		clickPreferencePagefromMenu();
		clickElement(PreferencesRepository.prefereneces_datacatalogue);
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_datacatalogue_classificationTab);
		explicitwaitforclick(autolocator(PreferencesRepository.preferences_datcatalogue_personalisationedit), 60);
		javaScriptScrollIntoView(PreferencesRepository.preferences_datcatalogue_personalisationedit);
		javaScriptScrollUpToSomeExtend();
		clickElement(PreferencesRepository.preferences_datcatalogue_personalisationedit);
		for (int attribute = 0; attribute < attributes.size(); attribute++)
		{
			String attributesName = attributes.get(attribute);
			clickElement(PreferencesRepository.preferences_datacatalogue_availablecolumn_search);
			enterValue(PreferencesRepository.preferences_datacatalogue_availablesearchtext, attributesName);
			clickElement(PreferencesRepository.preferences_datacatalogue_availablecolumn_search);
			if (!selectexactlistelements(PreferencesRepository.preferences_datacatalogue_editcatagory_availableattributes, attributesName))
			{
				BaseTest.getTest().log(Status.WARNING, "'" + attributesName + "' attribute is not present in personalization catagory");
				notAvailAttributes.add(attributesName);
			} else
			{
				clickElement(PreferencesRepository.preferences_datacatalogue_editcatagory_attributeslefttoright);
				clickElement(PreferencesRepository.preferences_datacatalogue_selectedcolumn_search);
				enterValue(PreferencesRepository.preferences_datacatalogue_selectedsearchtext, attributesName);
				clickElement(PreferencesRepository.preferences_datacatalogue_selectedcolumn_search);
				if (selectexactlistelements(PreferencesRepository.preferences_datacatalogue_editcatagory_selectedattributes, attributesName))
				{
					List<WebElement> selectedAttributes = findElements(PreferencesRepository.preferences_datacatalogue_editcatagory_selectedattributes);
					for (int i = 0; i < selectedAttributes.size(); i++)
					{
						String uiAttributeName = selectedAttributes.get(i).getText();
						if (uiAttributeName.equals(attributesName))
						{
							selectedAttributes.get(i).findElement(By.tagName("input")).sendKeys(attributesName + "FL");
							selectedAttributes.get(i).findElement(By.xpath("//i[contains(@class,'save')]")).click();
							pageLoaderLogo();

						}
					}
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Selected attribute is not present in right side table.");
				}
			}
		}
		clickElement(PreferencesRepository.preferences_datacatalogue_editcatagory_save);
		clickElement(PreferencesRepository.preferences_datacatalogue_editcatagory_proceed);
		if (!notAvailAttributes.isEmpty())
		{
			for (int i = 0; i < notAvailAttributes.size(); i++)
			{
				String attributeName = notAvailAttributes.get(i);
				clickElement(PreferencesRepository.preferences_datacatalogue_addicon);
				createAttribute(attributeName);
			}
		}
	}

	public AudiencePage_Upload selectDoubleOptchkbox()
	{
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_target_SegmentationGrid), 60);
		javaScriptScrollDown();
		pageLoaderLogo();
		String doubleOptText = getStrText(AudienceRepository.audience_seg_doubleopttext);
		uiPageEqualswithInputValue(doubleOptText, "Select all as double opt-in audience");
		clickElement(AudienceRepository.audience_seg_doubleoptcheckbox);
		if (BaseTest.getData().ListType.equals("Target list"))
		{
			String uniqueIdentifierText = getStrText(AudienceRepository.audience_seg_uniqueIdentiferText);
			uiPageEqualswithInputValue(uniqueIdentifierText, "EmailID has been selected as an unique identifier");
		}
		return this;
	}

	// Save the uploaded file
	public AudiencePage_Upload clicksave()
	{
		pageLoaderLogo();
		explicitwaitforclick(autolocator(DashboardRepository.save_button), 60);
		clickElement(DashboardRepository.save_button);
		pageLoaderLogo();
		return this;
	}

	// Select pop up to return to master list
	public AudiencePage_Upload returntomasterlist()
	{
		explicitwaitforclick(autolocator(AudienceRepository.audience_clickreturnmasterlist), 30);
		clickElement(AudienceRepository.audience_clickreturnmasterlist);
		pageLoaderLogo();
		if (!isElementPresent(AudienceRepository.audience_AudienceMasterPageHead))
		{
			BaseTest.getTest().log(Status.FAIL, "Audience Upload Failed/Master list page loading failed");
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public void clickImportHistory()
	{
		threadSleep(300);
		pageLoaderLogo();
		javaScriptScrollUpToSomeExtend();
		explicitwaitforclick(autolocator(AudienceRepository.audience_importhist), 30);
		toolTipValidationKnownText(AudienceRepository.audience_importhist, "Sync history");
		pageLoaderLogo();
		clickElement(AudienceRepository.audience_importhist);
		pageLoaderLogo();
	}

	public List<String> getAlertImportDescName()
	{
		List<String> importDescName = new LinkedList<String>();
		boolean flag = true;
		String importDesc = "", shortImportDesc = "";
		do
		{
			if (isElementPresent(AudienceRepository.audience_importhistalert) || getTextBoxVal(AudienceRepository.audience_synchist_lastButton, "class").contains("disabled"))
			{
				shortImportDesc = driver.findElement(autolocator(AudienceRepository.audience_importhistalertimportdesc)).getText();
				if (shortImportDesc.contains("..."))
				{
					mouseHoverWT(AudienceRepository.audience_importhistalertimportdesc);
					importDesc = getStrText(DashboardRepository.allpage_tooltip);
					importDescName.add(shortImportDesc);
					importDescName.add(importDesc);
				} else
				{
					importDescName.add(shortImportDesc);
				}
				flag = false;
			} else
			{
				clickElement(AudienceRepository.audience_synchist_nextButton);
				pageLoaderLogo();
			}
		} while (flag);
		return importDescName;
	}

	public void clickAlert(String alertImportDescName)
	{
		toolTipValidationKnownText(replacePlaceHolder(AudienceRepository.audienceImportdescAlertIcon, alertImportDescName), "Alert");
		clickElement(replacePlaceHolder(AudienceRepository.audienceImportdescAlertIcon, alertImportDescName));
	}

	public void downloadInvalidAudience(List<String> invalidImportDesc)
	{
		clickAlert(invalidImportDesc.get(0));
		if (invalidImportDesc.size() == 1)
		{
			selectAudienceDownloadMail(invalidImportDesc.get(0));
		} else
		{
			selectAudienceDownloadMail(invalidImportDesc.get(1));
		}
	}

	public void selectAudienceDownloadMail(String importDesc)
	{
		String prntwin;
		Map<String, String> map = null;
		List<Map<String, String>> fileList = new LinkedList<>();
		pageLoaderLogo();
		List<Map<String, String>> webTable = invalidAudienceTable();
		clickElement(AudienceRepository.audience_synchist_invalid_csv_downloadicon);
		clickElement(AudienceRepository.audience_synchist_selectotpsource);
		audienceSelectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Email Id");
		pageLoaderLogo();
		prntwin = parentWinHandle();
		driver.switchTo().newWindow(WindowType.WINDOW);
		switchWindow();
		teamWebUrlLaunch();
		teamWebmailLogin(System.getProperty("teamKeyAcctWebmailUsername"), System.getProperty(System.getProperty("teamKeyAcctWebmailUsername")));
		String otp = getWebmailOTPforInvalidAudienceDownload();
		teamWebmailLogout();
		childWindowClose(prntwin);
		entersOTPAndSubmit(otp, "target");
		pageLoaderLogo();
		String popupText = getStrText(AudienceRepository.audience_synchist_popupMailValidation).replaceAll("\n", "").trim();
		if (!popupText.isEmpty())
		{
			writeLog(popupText.equals("Thank you. Your request has been received.We will be sending you the download link for the data shortly"), "Validation popup is displayed as expected.", "Validation popup is not displayed.");
			prntwin = parentWinHandle();
			driver.switchTo().newWindow(WindowType.WINDOW);
			switchWindow();
			teamWebUrlLaunch();
			teamWebmailLogin(System.getProperty("teamKeyAcctWebmailUsername"), System.getProperty(System.getProperty("teamKeyAcctWebmailUsername")));
			String invalidAudienceLink = getWebmailInvalidAudienceDownloadLink(importDesc);
			teamWebmailLogout();
			childWindowClose(prntwin);
			driver.get(invalidAudienceLink);
			pageLoaderLogo();
			explicitwaitforvisibility(autolocator(AudienceRepository.AudienceDownloadButton), 90);
			String invalidAudienceDownload = getStrText(AudienceRepository.Audiencedownloadheader);
			writeLog(invalidAudienceDownload.equals("Audience - CSV download list"), "Header is present as expected.", "Header is not-present as expected.");
			clickElement(AudienceRepository.AudienceDownloadButton);
			ArrayList<Object> file = filehandle();
			String[] filedata = file.get(1).toString().split("\\R");
			String[] headers = filedata[0].trim().split(",");
			for (int i = 1; i < filedata.length; i++)
			{
				String[] datas = filedata[i].trim().split(",");
				map = new LinkedHashMap<String, String>();
				for (int j = 0; j < datas.length; j++)
				{
					map.put(headers[j], datas[j]);
				}
				fileList.add(map);
			}
			BaseTest.getTest().log(Status.INFO, "<b>INVALID AUDIENCE UI WEB TABLE DATA : </b>");
			ExtentManager.customReport(webTable);
			BaseTest.getTest().log(Status.INFO, "<b>INVALID AUDIENCE EXCEL DATA : </b>");
			ExtentManager.customReport(fileList);
			writeLog(webTable.equals(fileList), "Ui table value " + webTable + " is equal to file data value " + fileList, "Ui table value " + webTable + " is not equal to file data value " + fileList);
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Thank you. Warning popup is not displayed.");
			BaseTest.takeScreenshot();
		}
	}

	public void searchAndValidateNewAttribute(String attributeName)
	{
		boolean flag = false;
//		clickElement(AudienceRepository.dataCatalogueSearchIcon);
		enterValue(AudienceRepository.dataCatalogueSearchTextbox, attributeName);
//		clickElement(AudienceRepository.dataCatalogueSearchIcon);
		List<WebElement> attributes = findElements(AudienceRepository.dataCataloguelistAttribute);
		for (WebElement attribute : attributes)
		{
			String uiattributeName = attribute.getText();
			flag = attributeName.equals(uiattributeName) ? true : false;
		}
		if (flag)
		{
			BaseTest.getTest().log(Status.INFO, "Created " + attributeName + " is present in data catalogue page.");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Created " + attributeName + " is not present in data catalogue page.");
			BaseTest.takeScreenshot();
		}
	}

	public void clickDataCatalogue()
	{
		pageLoaderLogo();
		clickElement(AudienceRepository.preferences_dataCatalogue_Click);
		pageLoaderLogo();
	}

	public void clickAddAttribute()
	{
		clickElement(AudienceRepository.preferences_dataCatalogue_Newattribute);
	}

	public void importHistory(String importDescription)
	{
		threadSleep(ObjectRepository.wait120sec);
		pageLoaderLogo();
		clickImportHistory();
		pageLoaderLogo();
		checkImportDescription(importDescription);
	}

	// Vijay
	public void audienceOverviewcChannelPercentageAndTextValidation()
	{
		Map<String, String> overviewchartvalidation = new LinkedHashMap<>();
		Map<String, String> overviewtextvalidation = new LinkedHashMap<>();
		List<WebElement> chartchannelvalues = findElements(AudienceRepository.audience_masterdata_chartchannelvalues);
		for (WebElement acquiredchartchannelvalue : chartchannelvalues)
		{
			String[] chartvalues = acquiredchartchannelvalue.getText().split("\\R");
			String chartchannelpercentage = chartvalues[0];
			String chartchannelname = chartvalues[1];
			if (chartchannelname.contains("SMS"))
			{
				chartchannelname = chartchannelname.replaceAll(chartchannelname, "Mobile");
			}
			overviewchartvalidation.put(chartchannelname, chartchannelpercentage);
		}
		List<WebElement> textvalue = findElements(AudienceRepository.audience_Masterdata_overviewportlet);
		for (WebElement textvalues : textvalue)
		{
			String[] text = textvalues.getText().split("\\R");
			String textchannelname = text[0];
			String[] textpercentage = text[2].split(" ");
			String textPercent = textpercentage[0].replaceAll("%", "").trim();
			double decimalNumber = Double.parseDouble(textPercent);
			int intTextPercent = (int) decimalNumber;
			String textchannelpercentage = String.valueOf(intTextPercent) + "%";
			if (!textchannelname.equals("Total") && intTextPercent != 0)
			{
				overviewtextvalidation.put(textchannelname, textchannelpercentage);
			}
		}
		if (overviewchartvalidation.equals(overviewtextvalidation))
		{
			BaseTest.getTest().log(Status.INFO, "Total Channels Overview Chart Validation is -----> " + overviewchartvalidation);
			BaseTest.getTest().log(Status.INFO, "Total Channels Overview Text Validation is -----> " + overviewtextvalidation);
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Total Channels Overview Text & chart Validation is not same.");
			BaseTest.getTest().log(Status.INFO, "Total Channels Overview Chart Validation is -----> " + overviewchartvalidation);
			BaseTest.getTest().log(Status.INFO, "Total Channels Overview Text Validation is -----> " + overviewtextvalidation);
			BaseTest.takeScreenshot();
		}
	}

	public void audienceOverviewChannelsTotalCountValidation()
	{
		Map<String, Integer> Initalchannelcount = new LinkedHashMap<>();
		Map<String, Integer> Internalchannelcount = new LinkedHashMap<>();
		CommunicationListingPage master = getPageFactory().communicationListingPage();
		String totalchannelcount = master.getStrText(AudienceRepository.audience_masterdata_totalchannelvalue).replaceAll(",", "");
		List<WebElement> textvalues = master.findElements(AudienceRepository.audience_Masterdata_overviewportlet);
		for (int i = 1; i < textvalues.size(); i++)
		{
			int Internalchannelstotalvalue = 0;
			String[] textvalue = textvalues.get(i).getText().split("\\R");
			String textchannelname = textvalue[0].toLowerCase();
			String textchannelvalues = textvalue[1];
			String acquiredtextchannelvalue = textchannelvalues.replaceAll(",", "");
			int Intialchanneltotalvalue = Integer.parseInt(acquiredtextchannelvalue);
			if (!textchannelname.contains("total"))
			{
				textvalues.get(i).findElement(By.cssSelector("i[class*='info']")).click();
				BaseTest.getTest().log(Status.INFO, "clicked --> " + textchannelname);
				if (textchannelname.equals("notifications"))
				{
					String webnotificationcount = master.getStrText(AudienceRepository.audience_masterdata_webnotification).replaceAll(",", "");
					int webnotificationvalue = Integer.parseInt(webnotificationcount);
					String mobilenotificationcount = master.getStrText(AudienceRepository.audience_masterdata_mobilenotification).replaceAll(",", "");
					int mobilenotificationvalue = Integer.parseInt(mobilenotificationcount);
					Internalchannelstotalvalue = webnotificationvalue + mobilenotificationvalue;
					BaseTest.takeScreenshot();
				} else
				{
					List<WebElement> internalcount = master.findElements(textchannelname + " --> close-icon,xpath,(//ul[contains(@class,'domain-list')])[1]//li//span[2]");
					for (WebElement internalcounts : internalcount)
					{
						String internaliteratevalue = internalcounts.getText().replaceAll(",", "");
						int internaliteratevalues = Integer.parseInt(internaliteratevalue);
						Internalchannelstotalvalue = internaliteratevalues + Internalchannelstotalvalue;
					}
				}
				Initalchannelcount.put(textchannelname, Intialchanneltotalvalue);
				Internalchannelcount.put(textchannelname, Internalchannelstotalvalue);
				BaseTest.takeScreenshot();
				clickElement(AudienceRepository.audience_Masterdata_portletclose);
			}
		}
		if (Initalchannelcount.equals(Internalchannelcount))
		{
			BaseTest.getTest().log(Status.INFO, "Overall Channels Total Count is---->" + totalchannelcount);
			BaseTest.getTest().log(Status.INFO, "Total Channels Initial Count Validation is ---->" + Initalchannelcount);
			BaseTest.getTest().log(Status.INFO, "Total Channels Internal Count Validation is ----->" + Internalchannelcount);
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Total Channels count is -> " + Initalchannelcount + " is not-equal to Internal Count is -> " + Internalchannelcount);
			BaseTest.takeScreenshot();
		}
	}

	// Ajith
	public void audienceMasterDataOverviewHighCharts()
	{
		pageLoaderLogo();
		if (isDisplayed(AudienceRepository.audience_Masterdata_portletheader))
		{
			String[] list = OverviewChartVisibleAttribute();
			for (String testdata : list)
			{
				if (!testdata.toLowerCase().equals("channel"))
				{
					clickElement(AudienceRepository.audience_Masterdata_overView_ChartdropDown);
					selectlistelementsAndProceed(AudienceRepository.audience_Masterdata_overView_ChartdropDownList, testdata);
					threadSleep(900);
					List<WebElement> chartValue = findElements(AudienceRepository.audience_Masterdata_overView_ChartList);
					for (int i = 0; i < chartValue.size(); i++)
					{
						Actions action = new Actions(BaseTest.getWebDriver());
						action.moveToElement(chartValue.get(i)).perform();
						String[] data = getStrText(AudienceRepository.audience_Masterdata_overView_ChartTooltip).split("\\R");
						String tooltip = data[0].trim();
						String titlelegend = findElements(AudienceRepository.audience_Masterdata_overView_titleLegend).get(i).getText().trim();
						tooltip = titlelegend.length() > 10 ? tooltip.substring(0, 10) + "..." : tooltip;
						if (!tooltip.equals(titlelegend) || tooltip.isEmpty() || tooltip.contains("NA"))
						{
							BaseTest.getTest().log(Status.FAIL, " Chart tooltip name is not equal to titlelegend");
							BaseTest.takeScreenshot();
						}
					}
					BaseTest.getTest().log(Status.INFO, testdata + " - Chart tooltip names are equal to titlelegend");
					BaseTest.takeScreenshot();
					pieChartLegendValidate(AudienceRepository.audience_Masterdata_overView_ChartList, AudienceRepository.audience_Masterdata_overView_titleLegend, AudienceRepository.audience_Masterdata_charttooltipvalue);
				}
			}
		}
	}

	public String[] OverviewChartVisibleAttribute()
	{
		clickElement(AudienceRepository.audience_Masterdata_overView_ChartdropDown);
		List<WebElement> visibleElement = findElements(AudienceRepository.audience_Masterdata_overView_ChartdropDownVisibleList);
		String[] ele = new String[visibleElement.size()];
		for (int i = 0; i < ele.length; i++)
		{
			String text = visibleElement.get(i).getText();
			ele[i] = text;
		}
		clickElement(AudienceRepository.audience_Masterdata_overView_ChartdropDown);
		return ele;
	}

	public void audienceMasterDataProfileCompleteness()
	{
		pageLoaderLogo();
		Actions action = new Actions(BaseTest.getWebDriver());
		String channel = findElements(AudienceRepository.audience_Masterdata_overviewTotalheader).get(0).getText();
		clickElement(channel + " i Icon,xpath,//small[.='" + channel + "']//ancestor::div[contains(@class,'box')]//i[contains(@class,'info')]");
		pageLoaderLogo();
		List<WebElement> primaryAttributes = findElements(AudienceRepository.audience_Masterdata_profileCompleteness);
		double[] arr = new double[primaryAttributes.size()];
		Map<String, Double> profileCompleteness = new LinkedHashMap<>();
		WebElement scrollbar = BaseTest.getWebDriver().findElement(PageBase.autolocator(AudienceRepository.audience_Masterdata_profileCompletenesScrollBar));
		for (int i = 0; i < primaryAttributes.size(); i++)
		{
			double attributePercen = Double.parseDouble(primaryAttributes.get(i).getText().trim().replaceAll("[^0.0-9]", ""));
			String attributechannel = primaryAttributes.get(i).findElement(By.tagName("small")).getText();
			arr[i] = attributePercen;
			profileCompleteness.put(attributechannel, attributePercen);
			if (i >= 4)
			{
				action.clickAndHold(scrollbar).moveByOffset(0, 10).build().perform();
				action.release(scrollbar).build().perform();
				System.out.println(profileCompleteness);
			}
		}
		double max = arr[0];
		for (int i = 1; i < primaryAttributes.size(); i++)
		{
			max = Math.max(max, arr[i]);
		}
		if (profileCompleteness.containsValue(max))
		{
			String recommendations = getStrText(AudienceRepository.audience_Masterdata_profileCompletenessRecomm);
			if (recommendations.contains(String.valueOf(max)))
			{

				BaseTest.getTest().log(Status.INFO, "Total primary attributes percentage " + max + " is equal to recommendation percentage " + recommendations);
				BaseTest.takeScreenshot();
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Total primary attributes percentage " + max + " is not-equal to recommendation percentage " + recommendations);
				BaseTest.takeScreenshot();
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Max precentage value is not present in profile completeness.");
			BaseTest.takeScreenshot();
		}
		clickElement(AudienceRepository.audience_Masterdata_portletclose);
	}

	public void audienceMasterDataEmailSmsDataValidation()
	{
		Map<String, String> bytable = new LinkedHashMap<>();
		Map<String, String> byChart = new LinkedHashMap<>();
		Actions action = new Actions(BaseTest.getWebDriver());
		for (int a = 2; a < 4; a++)
		{
			String channel = getStrText(replacePlaceHolder(AudienceRepository.audience_masterdata_channelName, String.valueOf(a))).toLowerCase();
			pageLoaderLogo();
			clickElement(channel + replacePlaceHolder(AudienceRepository.audience_masterdatachannelInfo, String.valueOf(a)));
			pageLoaderLogo();
			threadSleep(ObjectRepository.wait2sec);
			String chartHeader = getStrText(AudienceRepository.audience_masterdatachanneloverviewchartHeader);
			String pieChartId = getTextBoxVal(replacePlaceHolder(AudienceRepository.audience_masterdatachanneloverviewpieChartId, chartHeader), "id");
			String tableHeader = getStrText(AudienceRepository.audience_masterdatachanneltableheader);

			List<WebElement> tabletxt = findElements(replacePlaceHolder(AudienceRepository.audience_masterdatachanneltabletext, tableHeader));
			List<WebElement> chartPercentages = findElements(replacePlaceHolder(AudienceRepository.audience_masterdatachannelchartpercentage, pieChartId));
			for (int i = 0; i < tabletxt.size(); i++)
			{
				DecimalFormat dc = new DecimalFormat("#.#");
				javaScriptHighLightElement(tabletxt.get(i));

				String byDomainName = tabletxt.get(i).getText().split("\\R")[0].trim();
				String byDomainValue = tabletxt.get(i).getText().split("\\R")[1].trim();
				String byDomainPercentage = tabletxt.get(i).getText().split("\\R")[2].trim().replaceAll("[^0.0-9]", "");
				byDomainPercentage = byDomainPercentage.isEmpty() ? "0" : byDomainPercentage;
				bytable.put(byDomainName, byDomainValue + " & " + dc.format(Double.parseDouble(byDomainPercentage)));
				action.moveToElement(chartPercentages.get(i)).perform();

				String tooltipXpath = replacePlaceHolder(AudienceRepository.audience_masterdatachannelcharttooltip, pieChartId);
				String tooltipDomainName = getStrText(tooltipXpath).split("\\R")[0].trim();
				String tooltipDomainValue = getStrText(tooltipXpath).split("\\R")[1].split(":")[1].trim();
				String tooltipDomainPercen = chartPercentages.get(i).getText().trim().replaceAll("[^0.0-9]", "");
				tooltipDomainPercen = tooltipDomainPercen.isEmpty() ? "0" : tooltipDomainPercen;
				byChart.put(tooltipDomainName, tooltipDomainValue + " & " + dc.format(Double.parseDouble(tooltipDomainPercen)));

				String key = findElements(replacePlaceHolder(AudienceRepository.audience_masterdatachannelcharttooltiptext, pieChartId)).get(i).getText().trim();
				String textValue = bytable.get(key);
				String ChartValue = byChart.get(key);
				if (!textValue.equals(ChartValue))
				{
					BaseTest.getTest().log(Status.FAIL, byDomainName + " domain chart value => " + ChartValue + " is not-equal " + tooltipDomainName + " domain tooltip text value => " + textValue);
					BaseTest.takeScreenshot();
				} else
				{
					BaseTest.getTest().log(Status.INFO, byDomainName + " domain chart value => " + ChartValue + " is not-equal " + tooltipDomainName + " domain tooltip text value => " + textValue);
				}
			}
			System.out.println(bytable);
			System.out.println(byChart);
			BaseTest.getTest().log(Status.INFO, " Data captured value of : " + channel + " matches the domain value ");
			BaseTest.getTest().log(Status.INFO, " Data captured values of --> " + channel + " is : " + byChart);
			BaseTest.takeScreenshot();
			clickElement("close icon,xpath, //div[@class='close']");
			bytable.clear();
			byChart.clear();
		}
	}

	public void overviewPieChartLegendValidate1()
	{
		List<WebElement> pieChartValues;
		List<WebElement> legendValues;
		List<WebElement> portlets = findElements(AudienceRepository.audience_Masterdata_overviewportlet);
		for (WebElement portlet : portlets)
		{
			String portletHeader = portlet.findElement(autolocator(AudienceRepository.audience_Masterdata_overviewportletheader)).getText();
			String dataCaptured = portlet.findElement(autolocator(AudienceRepository.audience_Masterdata_overviewportletdatacapture)).getText().trim();
			writeLog(!dataCaptured.isEmpty(), portletHeader + " channel data capture is present <b>" + dataCaptured + "</b>", portletHeader + " channel data capture is empty <b>" + dataCaptured + "</b>");
			if (!portletHeader.toLowerCase().contains("total"))
			{
				portlet.findElement(autolocator(replacePlaceHolder(AudienceRepository.audience_Masterdata_overviewportlet_I_icon, portletHeader))).click();
				BaseTest.getTest().log(Status.INFO, "clicked --> " + portletHeader + " I-icon ");
				pieChartValues = findElements(AudienceRepository.audience_Masterdata_piechartValues);
				legendValues = findElements(AudienceRepository.audience_Masterdata_overView_titleLegend);
				if (pieChartValues.size() == legendValues.size())
				{
					for (WebElement legend : legendValues)
					{
						legendValues = findElements(AudienceRepository.audience_Masterdata_overView_titleLegend);
						String legendText = legend.getText();
						legend.click();
						threadSleep(700);
						BaseTest.getTest().log(Status.INFO, "clicked --> " + legendText);
						pieChartValues = findElements(AudienceRepository.audience_Masterdata_piechartValues);
						for (WebElement pieChartValue : pieChartValues)
						{
							mousehoverJavaScript(pieChartValue);
							String tooltipValue = getStrText(AudienceRepository.audience_Masterdata_charttooltipvalue);
							String[] tooltip = tooltipValue.split("\\R");
							String toolTipChannelName = tooltip[0].trim();
							if (legendText.equals(toolTipChannelName))
							{
								BaseTest.getTest().log(Status.FAIL, "<b>" + toolTipChannelName + "</b> is present after clicked <b>" + legendText + "</b> legend.");
								BaseTest.takeScreenshot();
							} else
							{
								BaseTest.getTest().log(Status.INFO, "<b>" + toolTipChannelName + "</b> is not-present after clicked " + legendText + " legend.");
							}
						}
						legend.click();
					}
//				pieChartLegendValidate(AudienceRepository.audience_Masterdata_overView_titleLegend, AudienceRepository.audience_Masterdata_piechartValues, AudienceRepository.audience_Masterdata_charttooltipvalue);
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Pie chart counts is not equals to legend counts.");
					BaseTest.takeScreenshot();
				}
				clickElement(AudienceRepository.audience_Masterdata_portletclose);
			}
		}
	}

	public void pieChartLegendValidate(Object pieChartLoc, Object legendLoc, String toolTip)
	{
		List<WebElement> pieChartValues;
		List<WebElement> legendValues;

		pieChartValues = pieChartLoc instanceof String ? findElements((String) pieChartLoc) : (List<WebElement>) pieChartLoc;
		legendValues = legendLoc instanceof String ? findElements((String) legendLoc) : (List<WebElement>) legendLoc;

		if (pieChartValues.size() == legendValues.size())
		{
			for (WebElement legend : legendValues)
			{
				legendValues = legendLoc instanceof String ? findElements((String) legendLoc) : (List<WebElement>) legendLoc;
				String legendText = legend.getText();
				legend.click();
				BaseTest.getTest().log(Status.INFO, "clicked --> " + legendText);
				pieChartValues = pieChartLoc instanceof String ? findElements((String) pieChartLoc) : (List<WebElement>) pieChartLoc;
				for (WebElement pieChartValue : pieChartValues)
				{
					mousehoverJavaScript(pieChartValue);
					String tooltipValue = getStrText(toolTip);
					String[] tooltip = tooltipValue.split("\\R");
					String toolTipChannelName = tooltip[0].trim();
					if (legendText.equals(toolTipChannelName))
					{
						BaseTest.getTest().log(Status.FAIL, "<b>" + toolTipChannelName + "</b> is present after clicked <b>" + legendText + "</b> legend.");
						BaseTest.takeScreenshot();
					} else
					{
						BaseTest.getTest().log(Status.INFO, "<b>" + toolTipChannelName + "</b> is not-present after clicked " + legendText + " legend.");
					}
				}
				legend.click();
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Pie chart counts is not equals to legend counts.");
			BaseTest.takeScreenshot();
		}
	}

	public void audienceMasterDataNotificationDataValidation()
	{
		Map<String, String> byText = new LinkedHashMap<>();
		Map<String, String> byChart = new LinkedHashMap<>();
		Actions action = new Actions(BaseTest.getWebDriver());
		pageLoaderLogo();
		clickElement(AudienceRepository.audience_Masterdata_NotificationiIcon);
		threadSleep(ObjectRepository.wait2sec);
		List<WebElement> notify = findElements(AudienceRepository.audience_Masterdata_Notification_textList);
		List<WebElement> chartValues = findElements(AudienceRepository.audience_Masterdata_Notification_ChartList);
		for (int i = 1; i < notify.size(); i++)
		{
			String[] text = notify.get(i).getText().split("\\R");
			String notificationStatus = text[0].trim();
			String notificationCount = text[1].trim();
			String percen = text[2].trim().replaceAll("[^0.0-9]", "");

			if (byText.containsKey(notificationStatus))
			{
				String[] webnotification = byText.get(notificationStatus).split("&");

				int webCount = Integer.parseInt(webnotification[0].trim());
				int MobileCount = Integer.parseInt(notificationCount);
				notificationCount = String.valueOf((webCount + MobileCount));

				double webPercen = Double.parseDouble(webnotification[1].trim());
				double mobilePercern = Double.parseDouble(percen);
				String avgPercentage = String.valueOf(Math.round((webPercen + mobilePercern) / 2));
				percen = avgPercentage;
			}
			String values = notificationCount + " & " + percen;
			byText.put(notificationStatus, values);
		}
		/* Chart validation */
		for (int i = 0; i < chartValues.size(); i++)
		{
			action.moveToElement(chartValues.get(i)).perform();
			String[] tooltip = getStrText(AudienceRepository.audience_Masterdata_Notification_tooltip).split("\\R");
			String notificationChartStatus = tooltip[0].trim();
			String[] split = tooltip[1].split(":");
			String chartPercen = chartValues.get(i).getText().trim().replaceAll("[^0.0-9]", "");
			String val = split[1].trim() + " & " + chartPercen;

			byChart.put(notificationChartStatus, val);

			String titleLegend = findElements(AudienceRepository.audience_Masterdata_Notification_titleLegend).get(i).getText();
			String[] Textdata = byText.get(titleLegend).split(" & ");
			int textCount = Integer.parseInt(Textdata[0]);
			Double textPercentage = Double.parseDouble(Textdata[1]);
			int Chartcount = Integer.parseInt(split[1].trim());
			double convert = Double.parseDouble(chartPercen);
			int ChartPercentage = (int) Math.round(convert);

			if (textCount == Chartcount && (textPercentage == ChartPercentage || textPercentage + 3 >= ChartPercentage || textPercentage - 3 <= ChartPercentage))
			{
				BaseTest.getTest().log(Status.INFO, "<b>\"" + titleLegend + "\"</b> Chart values equals to notification data : " + val);
				BaseTest.takeScreenshot();
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "<b>\"" + titleLegend + "\"</b> Chart values equals to " + titleLegend + " notification data :" + val);
				BaseTest.takeScreenshot();
			}
		}
		BaseTest.getTest().log(Status.INFO, " Total Chart values are  --> " + byChart);
	}

	public AudiencePage_Upload synchHistoryFilter(String headerFilter, String testdata, String filtertype)
	{
		clickElement(headerFilter);
		explicitwaitforclick(autolocator(AudienceRepository.audience_synchistory_filterDropdown), 20);
		clickElement(AudienceRepository.audience_synchistory_filterDropdown);
		audienceSelectlistelements(AudienceRepository.audience_synchistory_filterDropdown_list, filtertype);
		enterValue(AudienceRepository.audience_synchistory_filterInput, testdata);
		BaseTest.takeScreenshot();
		clickElement(AudienceRepository.audience_synchistory_filterBtn);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait3sec);
		boolean flag = true;
		int pageCount = 0;
		String Header = getStrText(headerFilter + "/..//following-sibling::a");
		while (flag)
		{
			List<WebElement> rows = findElements(AudienceRepository.audience_synchistory_rows);
			if (!rows.isEmpty())
			{
				for (int i = 1; i <= rows.size(); i++)
				{
					String data = null;
					if (headerFilter.contains("Source"))
					{
						String obj = AudienceRepository.audience_synchistory_SorceRows + "[" + i + "]";
						data = getStrText(obj).toLowerCase();
						// javaScriptHighlight(obj);

					} else if (headerFilter.contains("Import description"))
					{
						String obj = AudienceRepository.audience_synchistory_ListName + "[" + i + "]";
						data = getStrText(obj).toLowerCase();
						// javaScriptHighlight(obj);

						if (filtertype.equals("Is equal to"))
						{
							if (rows.size() == 1)
							{
								BaseTest.getTest().log(Status.INFO, "After filter Sync history contains Keyword : " + testdata);
								BaseTest.takeScreenshot();
							} else
							{
								BaseTest.getTest().log(Status.FAIL, Header + " doesn't have any unique name of " + testdata);
								BaseTest.takeScreenshot();
							}
						}
					}
					if (!data.contains(testdata.toLowerCase()))
					{
						BaseTest.getTest().log(Status.FAIL, "After filter Sync history doesn't contains Keyword : " + testdata);
						javaScriptHighLightElement(driver.findElement(autolocator(data)));
						BaseTest.takeScreenshot();
					}
				}
				flag = pageNavigation(AudienceRepository.audience_pagination_nextpage);
				pageLoaderLogo();
				pageCount++;
			} else
			{
				BaseTest.getTest().log(Status.WARNING, "No data found after filter : " + testdata);
				BaseTest.takeScreenshot();
				flag = false;
			}
		}
		String str = getStrText(AudienceRepository.audience_pagination_totalpage).split("of")[1].trim();
		BaseTest.getTest().log(Status.INFO, "Total no of page : " + pageCount);
		int totalPage = Integer.parseInt(str);
		if (totalPage == pageCount)
		{
			BaseTest.getTest().log(Status.INFO, testdata + " has been validated in each Page");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Actual : " + pageCount + " Expected : " + totalPage + " page counts aren't equal");
		}
		return this;
	}

	public AudiencePage_Upload synchHistoryFilterRemover(String header)
	{
		clickElement(header);
		explicitwaitforclick(autolocator(AudienceRepository.audience_synchistory_filterDropdown), 20);
		clickElement(AudienceRepository.audience_synchistory_cancelBtn);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait2sec);
		return this;
	}

	public AudiencePage_Upload selectSegmentationList(String testData)
	{
		explicitwaitforclick(autolocator(AudienceRepository.audience_target_SegmentationType), 20);
		clickElement(AudienceRepository.audience_target_SegmentationType);
		audienceSelectlistelements(AudienceRepository.audience_target_SegmentationType_Options, testData);
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_target_SegmentationGrid), 20);
		return this;
	}

	public AudiencePage_Upload clickMoreInfo()
	{
		explicitwaitforclick(autolocator(AudienceRepository.audience_Segmentation_Info), 20);
		clickElement(AudienceRepository.audience_Segmentation_Info);
		BaseTest.getTest().info(MarkupHelper.createLabel("SEGMENTATION MORE INFO PAGE", ExtentColor.BLUE));
		return this;
	}

	public void moreInfoScenarios()
	{
		String emailAudience = getStrText(AudienceRepository.audience_Segmentation_info_emailaudience);
		String smsAudience = getStrText(AudienceRepository.audience_Segmentation_info_smsaudience);
		Map<String, String> iIconDetails = new LinkedHashMap<>();
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_Segmentation_info_emailaudience), 20);
		threadSleep(ObjectRepository.wait2sec);
		BaseTest.takeScreenshot();
		iIconDetails.put("Communication name", getStrText(AudienceRepository.audience_Segmentation_info_commnametext));
		iIconDetails.put("Created on", getStrText(AudienceRepository.audience_Segmentation_info_createdontext));
		iIconDetails.put("Created by", getStrText(AudienceRepository.audience_Segmentation_info_createdbytext));
		iIconDetails.put("Total audience", getStrText(AudienceRepository.audience_Segmentation_info_totalaudience));
		String linkedCommunicationText = getStrText(AudienceRepository.audience_Segmentation_info_linkedcommunication);
		String linkedCommunication = linkedCommunicationText.replaceAll("[^0-9]", "");
		iIconDetails.put("Linked communication", linkedCommunication);
		clickElement(AudienceRepository.audience_Segmentation_Info_close);
		BaseTest.takeScreenshot();
		if (emailAudience.equals("19") && smsAudience.equals("10"))
		{
			BaseTest.getTest().info("Email and Mobile audience count is matched with the uploaded CSV file in the UI.");
		} else
		{
			BaseTest.getTest().fail("Email and Mobile audience count is not matched with the uploaded CSV file in the UI.");
			BaseTest.takeScreenshot();
		}
		for (int i = 0; i < iIconDetails.size(); i++)
		{
			Set<String> keys = iIconDetails.keySet();
			Object[] headerValues = keys.toArray();
			Collection<String> values = iIconDetails.values();
			Object[] headerName = values.toArray();
			int count = i + 1;
			String segmentationListCount = getStrText(replacePlaceHolder(AudienceRepository.audience_Segmentation_list_count, String.valueOf(count)));
			if (headerName[i].toString().equals(segmentationListCount))
			{
				BaseTest.getTest().log(Status.INFO, "segmentation list " + headerValues[i].toString() + " : " + segmentationListCount + " is same as " + headerValues[i].toString() + " : " + headerName[i].toString() + " from I icon details");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, headerValues[i].toString() + " segmentation list " + segmentationListCount + " is not same as " + headerValues[i].toString() + " : " + headerName[i].toString() + " from I icon details");
				BaseTest.takeScreenshot();
			}
		}

	}

	public AudiencePage_Upload segmentationClickEditIcon()
	{

		explicitwaitforclick(autolocator(AudienceRepository.audience_Segmentation_Edit), 20);
		clickElement(AudienceRepository.audience_Segmentation_Edit);
		BaseTest.getTest().info(MarkupHelper.createLabel("EDIT LIST NAME", ExtentColor.BLUE));
		return this;
	}

	@Override
	public void waitForElementVisible(String locator)
	{
		boolean flag = false;
		for (int j = 0; j <= 12; j++)
		{
			try
			{
				driver.navigate().refresh();
				explicitwaitforvisibility(autolocator(locator), 1);
				flag = true;
				break;
			} catch (Exception e)
			{
				System.out.println("Page is waiting for element to be reflect.");
			}
		}
		if (!flag)
		{
			BaseTest.getTest().log(Status.FAIL, "element is not available.");
			BaseTest.takeScreenshot();
		}
	}

	public void checkImportDescription(String importDescription)
	{
		int page = 1;
		boolean flag = false;
		boolean dateFlag = true;
		String expectedImportDescription = importDescription;
		importDescription = importDescription.length() > 25 ? importDescription.substring(0, 24) + "..." : importDescription;
		while (!flag)
		{
			WebElement table = driver.findElement(autolocator(AudienceRepository.audience_synchist_table));
			List<WebElement> rows = table.findElements(By.tagName("tr"));
			for (int i = 0; i < rows.size(); i++)
			{
				List<WebElement> datas = rows.get(i).findElements(By.tagName("td"));
				String uiDate = datas.get(3).getText();
				if (syncHistoryDateCheck(uiDate))
				{
					String uiImportDescription = datas.get(5).getText();
					if (uiImportDescription.contains("..."))
					{
						mouseHover(datas.get(5));
						uiImportDescription = getStrText(DashboardRepository.allpage_tooltip);
					}
					if (uiImportDescription.equals(expectedImportDescription))
					{
						BaseTest.takeScreenshot();
						String alertStatus = datas.get(6).findElement(autolocator(AudienceRepository.audience_synchist_alertIcon)).getAttribute("class");
						if (!alertStatus.contains("click-off"))
						{
							BaseTest.getTest().log(Status.FAIL, "<b>'" + expectedImportDescription + "'</b> is in <b>'Alert'</b> state.");
						} else
						{
							BaseTest.getTest().log(Status.INFO, "<b>'" + expectedImportDescription + "'</b> is not in <b>'Alert'</b> state.");
						}
						flag = true;
						break;
					}
				} else
				{
					dateFlag = false;
					break;
				}
			}
			threadSleep(ObjectRepository.wait1sec);
			javaScriptScrollDown();
			if (!flag && dateFlag)
			{
				if (!isElementPresent(AudienceRepository.audience_synchist_lastButton) && page == 1)
				{
					BaseTest.getTest().log(Status.INFO, "This is first page, Pagination is not present as expected.");
					BaseTest.takeScreenshot();
					break;
				} else if (!isElementPresent(AudienceRepository.audience_synchist_lastButton) && page != 1)
				{
					BaseTest.getTest().log(Status.INFO, "This is not a first page,but pagination is not present");
					BaseTest.takeScreenshot();
					break;
				} else
				{
					if (findElement(AudienceRepository.audience_synchist_lastButton).getAttribute("class").contains("disabled"))
					{
						break;
					} else
					{
						BaseTest.takeScreenshot();
						javaScriptScrollDown();
						driver.findElement(autolocator(AudienceRepository.audience_synchist_nextButton)).click();
						pageLoaderLogo();
						page++;
					}
				}
			} else
			{
				break;
			}
		}
		if (flag)
		{
			BaseTest.getTest().log(Status.INFO, "Created import description is present in sync history page.");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Created import description is not present in sync history page.");
			BaseTest.takeScreenshot();
		}
	}

	public boolean syncHistoryDateCheck(String data)
	{
		boolean flag = false;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, d MMM, yyyy HH:mm");
		try
		{
			LocalDateTime parsedDateTime = LocalDateTime.parse(data.trim(), formatter);
			LocalDate today = LocalDate.now();
			if (parsedDateTime.toLocalDate().equals(today))
			{
				flag = true;
				return flag;
			}
		} catch (DateTimeParseException e)
		{
			System.err.println("Error parsing the date. Ensure the format is correct: " + e.getMessage());
		}
		return flag;
	}

//SYnc history

	public void listAcquisitionChart()
	{
		String tabText = null;
		String tabStatus = null;
		PageBase.threadSleep(200);
		javaScriptScrollToSomeExtend("460");
		PageBase.threadSleep(300);
		uiPageEqualswithMultipleInputValue(AudienceRepository.audience_Masterdata_lisqusitionTabs, "List activity,List acquisition,List attrition");
		pageLoaderLogo();
		List<WebElement> tabs = findElements(AudienceRepository.audience_Masterdata_lisqusitionTabs);
		for (int i = 0; i < tabs.size(); i++)
		{
			tabStatus = tabs.get(i).getAttribute("class");
			tabText = tabs.get(i).getText();
			if (tabStatus.contains("click-off"))
			{
				BaseTest.getTest().log(Status.WARNING, tabText + " tab status is disable state.");
				BaseTest.takeScreenshot();
			}
			if (tabText.equals("List acquisition"))
			{
				if (tabStatus.contains("active"))
				{
					BaseTest.getTest().log(Status.INFO, tabText + " tab is active state.");
				} else
				{
					BaseTest.getTest().log(Status.INFO, tabText + " tab is not active state.");
				}
			}
		}
	}

	public void listAcquisitionChartDateValidate()
	{
		List<WebElement> legends;
		clickElement(AudienceRepository.audience_Masterdata_listacquisition_calender);
		List<WebElement> dates = findElement(AudienceRepository.audience_Masterdata_listacquisition_selectDate).findElements(By.tagName("li"));
		for (int k = 0; k < dates.size(); k++)
		{
			if (!dates.get(k).getText().equalsIgnoreCase("custom range"))
			{
				dates.get(k).click();
			} else
			{
				dates.get(k).click();
				clickElement(DashboardRepository.datefilter);
				selectCustomRange(-5, 0);
			}
			String[] dateText = getStrText(AudienceRepository.audience_Masterdata_listacquisition_calender).split("-");
			String expectedStartDate = dateText[0].trim();
			String expectedEndDate = dateText[1].trim();
			Date startDate = new Date(expectedStartDate);
			Date endDate = new Date(expectedEndDate);
			legends = findElements(AudienceRepository.audience_Masterdata_chartlegend);
			for (int i = 0; i < legends.size(); i++)
			{
				String legend = legends.get(i).getText();
				legends.get(i).click();
				String loc = !legend.toLowerCase().contains("email") ? AudienceRepository.audience_Masterdata_emailgraph : !legend.toLowerCase().contains("mobile") ? AudienceRepository.audience_Masterdata_mobilegraph : "chart not present";
				List<WebElement> chartValues = null;
				try
				{
					chartValues = findElements(loc + " path[class='highcharts-point']");
				} catch (Exception e2)
				{
					BaseTest.takeScreenshot();
				}
				mouseHover(AudienceRepository.audience_Masterdata_listacquisitionchart);
				for (WebElement chartValue : chartValues)
				{
					mouseHoverWT(chartValue);
					String tooltip = getStrText(AudienceRepository.audience_Masterdata_charttooltip);
					System.out.println(tooltip);
					String tolltipDateValue = tooltip.split("\n")[0];
					System.out.println(tolltipDateValue);
					String legendText = legend.equalsIgnoreCase("email") ? "mobile" : "email";
					Date actualDate = new Date(tolltipDateValue);
					if (!actualDate.before(startDate) && !actualDate.after(endDate))
					{
						BaseTest.getTest().log(Status.INFO, legendText + " legend -> " + tolltipDateValue + " Actual date is within the expected range." + expectedStartDate + " and " + expectedEndDate);
					} else
					{
						BaseTest.getTest().log(Status.INFO, legendText + " legend -> " + tolltipDateValue + " Actual date is Out of the expected range." + expectedStartDate + " and " + expectedEndDate);
					}
				}
				threadSleep(ObjectRepository.wait1sec);
				javaScriptScrollToSomeExtend("130");
				threadSleep(ObjectRepository.wait1sec);
				legends.get(i).click();
			}
			clickElement(AudienceRepository.audience_Masterdata_listacquisition_calender);
		}

	}

	// List acquisition
	public void listAcquistionNotes()
	{
		clickElement(AudienceRepository.audience_Masterdata_listacquisition_notes);
		if (isElementPresent(AudienceRepository.audience_Masterdata_notesdropdown))
		{
			BaseTest.getTest().log(Status.INFO, "Notes dropdown is present as expected.");
			clickElement(AudienceRepository.audience_Masterdata_listacquisition_notes);
			if (!isElementPresent(AudienceRepository.audience_Masterdata_notesdropdown))
			{
				BaseTest.getTest().log(Status.INFO, "Notes dropdown is not displayed after clicked notes icon.");
			} else
			{
				BaseTest.getTest().log(Status.WARNING, "Notes dropdown is displayed after clicked notes icon.");
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Notes dropdown is not present as expected.");
		}
	}

	public void selectListAcquisitionCalender(String element)
	{
		String[] dropdownInputs = { "All time", "Today", "Last 7 days", "Last 30 days", "Custom range" };
		clickElement(AudienceRepository.audience_Masterdata_listacquisition_calender);
		List<WebElement> dateField = driver.findElement(autolocator(AudienceRepository.audience_Masterdata_listacquisition_selectDate)).findElements(By.tagName("li"));
		for (int field = 0; field < dateField.size(); field++)
		{
			String dropdownValue = dateField.get(field).getText();
			writeLog(dropdownInputs[field].equals(dropdownValue), dropdownValue + "Dropdown Value is present as expected.", dropdownValue + "Dropdown Value is not present as expected.");
			if (dropdownValue.contains(element))
			{
				dateField.get(field).click();
				BaseTest.getTest().log(Status.INFO, "clicked --> " + dropdownValue);
				break;
			}
		}
	}

	public void selectListAcquisitionSource(String source)
	{
		boolean flag = false;
		clickElement(AudienceRepository.audience_Masterdata_listacquisition_source);
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_Masterdata_selectsource), 60);
		uiPageEqualswithMultipleInputValue(AudienceRepository.audience_Masterdata_selectsource, "All sources,MSSQL,MySQL,CSV,DynamicCrm,Manual Entry");
		List<WebElement> sources = findElements(AudienceRepository.audience_Masterdata_selectsource);
		for (WebElement uiSource : sources)
		{
			String lowerCase = uiSource.getText();
			if (lowerCase.contains(source))
			{
				if (uiSource.getAttribute("class").contains("active"))
				{
					clickElement(AudienceRepository.audience_Masterdata_listacquisition_source);
					BaseTest.getTest().log(Status.INFO, source + " source is already active.");
				} else
				{
					uiSource.click();
					BaseTest.getTest().log(Status.INFO, source + " source selected successfully.");
				}
				flag = true;
				break;
			}
		}
		if (!flag)
		{
			BaseTest.getTest().log(Status.FAIL, source + " source not able to selected. Please provide valid source");
			BaseTest.takeScreenshot();
		}
	}

	public void listAcquisitionChartValidate(String chart)
	{
		int chartCount = 0;
		int overviewCount = 0;
		List<WebElement> legends;
		Map<Double, Double> graph = new LinkedHashMap<>();
		legends = findElements(AudienceRepository.audience_Masterdata_chartlegend);
		for (int i = 0; i < legends.size(); i++)
		{
			String legend = legends.get(i).getText();
			if (!legend.toLowerCase().contains(chart))
			{
				legends.get(i).click();
			}
		}
		threadSleep(500);
		String loc = chart.toLowerCase().contains("email") ? AudienceRepository.audience_Masterdata_emailgraph : chart.toLowerCase().contains("mobile") ? AudienceRepository.audience_Masterdata_mobilegraph : "chart not present";
		List<WebElement> chartValues = null;
		{
			try
			{
				chartValues = findElements(loc + " path[class='highcharts-point']");
			} catch (Exception e2)
			{
				BaseTest.getTest().log(Status.FAIL, chart + " Chart is not displayed.");
				BaseTest.takeScreenshot();
			}
			List<WebElement> yaxis = findElements(AudienceRepository.audience_Masterdata_yaxis);
			for (WebElement yVal : yaxis)
			{
				double cooridinate = Double.parseDouble(yVal.getText().trim());
				double y = yVal.getLocation().getY();
				graph.put(cooridinate, y);
			}
			List<Double> list = new ArrayList<>(graph.keySet());
			mouseHover(AudienceRepository.audience_Masterdata_listacquisitionchart);
			for (WebElement chartValue : chartValues)
			{
				mouseHoverWT(chartValue);
				int graphLocation = chartValue.getLocation().getY();
				String tooltip = getStrText(AudienceRepository.audience_Masterdata_charttooltip);
				System.out.println(tooltip);
				String[] tolltipValues = tooltip.split(":");
				int graphPoint = Integer.parseInt(tolltipValues[1].trim());
				chartCount += graphPoint;
				int index = 1;
				for (int j = 0; j < list.size(); j++)
				{
					double yCount = list.get(j);
					double yLocation = graph.get(yCount);
					if (graphPoint == yCount)
					{
						if (graphLocation == yLocation || graphLocation < yLocation + 15)
						{
							BaseTest.getTest().log(Status.INFO, "The Graph trace point --> " + graphPoint + ", Exactly plotted on Y-Axis line --> " + yCount);
							break;
						} else
						{
							javaScriptHighLightwithScrnShot(chartValue);
							BaseTest.getTest().log(Status.FAIL, "The Graph trace point plotted not as Expected");
						}
					} else if (graphPoint < yCount && j != 0)
					{
						double prevCount = list.get(j - 1);
						if (graphLocation > yLocation && graphLocation < graph.get(prevCount))
						{
							BaseTest.getTest().log(Status.INFO, "The Graph trace point --> " + graphPoint + ", Falls between -->  " + yCount + " & " + prevCount + " on Y-Axis line");
							break;
						}

					} else if (index == list.size())
					{
						BaseTest.getTest().log(Status.FAIL, "The Graph trace point plotted not as Expected");
						BaseTest.takeScreenshot();
					}
					index++;
				}
			}
			threadSleep(100);
			javaScriptScrollToSomeExtend("100");
			threadSleep(100);
			legends = findElements(AudienceRepository.audience_Masterdata_chartlegend);
			for (int i = 0; i < legends.size(); i++)
			{
				String legend = legends.get(i).getText();
				if (!legend.toLowerCase().contains(chart))
				{
					legends.get(i).click();
				}
			}
			System.out.println(chartCount);
			overviewCount = chart.toLowerCase().contains("email") ? Integer.parseInt(getStrText(AudienceRepository.audience_Masterdata_overviewemailcount))
					: chart.toLowerCase().contains("mobile") ? Integer.parseInt(getStrText(AudienceRepository.audience_Masterdata_overviewmobilecount)) : 0;
			writeLog(overviewCount == chartCount, "<b>" + chart + " </b>overview count " + overviewCount + " is present as expected chart count " + chartCount,
					"<b>" + chart + " </b>overview count " + overviewCount + " is not present as expected chart count " + chartCount);
		}
	}

	public void listAcquisitionLegendValidate()
	{
		List<WebElement> legends = findElements(AudienceRepository.audience_Masterdata_chartlegend);
		for (int i = 0; i < legends.size(); i++)
		{
			String legendName = legends.get(i).getText();
			String loc = legendName.toLowerCase().contains("email") ? AudienceRepository.audience_Masterdata_emailgraph : legendName.toLowerCase().contains("mobile") ? AudienceRepository.audience_Masterdata_mobilegraph : "chart not present";
			legends.get(i).click();
			String chartStatus = getTextBoxVal(loc, "visibility");
			writeLog(chartStatus.contains("hidden"), "After clicked " + legendName + " legend " + legendName + " chart is not present as expected.", "After clicked " + legendName + " legend " + legendName + " chart is present.");
			legends.get(i).click();
		}
	}

	public void clickOverviewPortlet_Info_Icon(String infoIconName)
	{
		pageLoaderLogo();
		String infoIconNameLc = infoIconName.toLowerCase();
		String xpath = infoIconNameLc.contains("total") ? AudienceRepository.audience_masterdata_overviewtotal_Info_Icon
				: infoIconNameLc.contains("email") ? AudienceRepository.audience_masterdata_overviewemail_Info_Icon
						: infoIconNameLc.contains("mobile") ? AudienceRepository.audience_masterdata_overviewmobile_Info_Icon : infoIconNameLc.contains("notification") ? AudienceRepository.audience_masterdata_overviewmobile_Info_Icon : null;
		if (xpath != null)
		{
			clickElement(xpath);
		}
	}

	public void click_CreatePersona_From_MDM()
	{
		if (isElementPresent(AudienceRepository.audience_masterdata_MDMcreatePersona))
		{
			clickElement(AudienceRepository.audience_masterdata_MDMcreatePersona);
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Master data management create persona icon is not present");
		}
		pageLoaderLogo();
	}

	public void check_audience_Grid_table_Attributes()
	{
		List<String> audienceGridHeaders = new LinkedList<String>();
		javaScriptScrollDown();
		String defaultGridCount = getStrText(AudienceRepository.audience_Masterdata_audiencegridheader).replaceAll("[^0.0-9]", "");
		writeLog(Integer.parseInt(defaultGridCount) <= 200, defaultGridCount + " default grid count is present as expected.", defaultGridCount + " default grid count is not present as expected.");
		List<Map<String, String>> audienceGridTable = getAudienceTable();
		Map<String, String> list = audienceGridTable.get(0);
		for (Entry<String, String> map : list.entrySet())
		{
			audienceGridHeaders.add(map.getKey());
		}
		List<String> selectedAttributes = getFieldSelectorAttributes("selectedcolumns");
		Collections.sort(audienceGridHeaders);
		Collections.sort(selectedAttributes);;
		writeLog(audienceGridHeaders.equals(selectedAttributes), "Audience Grid Header is present as expected field selector selected column attributes", "Audience Grid Header is not present as expected field selector selected column attributes.");
	}

	public List<String> select_unselect_audienceGridAttribute()
	{
		List<Map<String, String>> audienceGridTable;
		Map<String, String> audienceList;
		List<String> list = new ArrayList<String>();
		List<String> audienceGridHeaders = new LinkedList<String>();
		javaScriptScrollDown();
		clickElement(AudienceRepository.audience_Masterdata_fieldSelector);
		clickElement(AudienceRepository.audience_Masterdata_audiencegridsearch);
		String[] attributes = BaseTest.getData().AttributeValue.split(",");
		for (String attribute : attributes)
		{
			enterValue(AudienceRepository.audience_Masterdata_audiencegridsearchText, attribute);
			clickElement(AudienceRepository.audience_Masterdata_audiencegridsearch);
			if (audienceSelectlistelements(DashboardRepository.allpage_common_selectdropdownlist, attribute))
			{
				list.add(attribute);
				clickElement(AudienceRepository.audience_Masterdata_fieldSelectorleftArrow);
			}
		}
		clickElement(AudienceRepository.audience_Masterdata_audiencegridupdate);
		audienceGridTable = getAudienceTable();
		audienceList = audienceGridTable.get(0);
		for (Entry<String, String> map : audienceList.entrySet())
		{
			audienceGridHeaders.add(map.getKey());
		}
		Collections.sort(audienceGridHeaders);
		Collections.sort(list);
		writeLog(!audienceGridHeaders.contains(list), "After unselecting the field selector attributes, attribute not displayed in audience grid.", "After unselecting the field selector attributes, attribute displayed in audience grid.");

		// When refresh the page, selected attributes not displayed in audience grid(Issue).
		refresh();
		pageLoaderLogo();
		javaScriptScrollDown();
		audienceGridTable = getAudienceTable();
		audienceList = audienceGridTable.get(0);
		for (Entry<String, String> map : audienceList.entrySet())
		{
			audienceGridHeaders.add(map.getKey());
		}
		Collections.sort(audienceGridHeaders);
		writeLog(!audienceGridHeaders.contains(list), "After unselecting the field selector attributes, attribute not displayed in audience grid.", "After unselecting the field selector attributes, attribute displayed in audience grid.");
		return list;
	}

	public List<String> getFieldSelectorAttributes(String columnName)
	{
		List<String> list = new LinkedList<String>();
		javaScriptScrollDown();
		clickElement(AudienceRepository.audience_Masterdata_fieldSelector);
		pageLoaderLogo();
		String loc = columnName.toLowerCase().contains("selectedcolumns") ? AudienceRepository.audience_Masterdata_selectedattributes : AudienceRepository.audience_Masterdata_availableattributes;
		List<WebElement> attributes = findElements(loc);
		for (WebElement attribute : attributes)
		{
			list.add(attribute.getText().trim());
		}
		clickElement(AudienceRepository.audience_Masterdata_fieldSelectorcloseicon);
		threadSleep(200);
		pageLoaderLogo();
		return list;
	}

	public List<Map<String, String>> getAudienceTable()
	{
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		List<Map<String, String>> list = new LinkedList<>();
		WebElement table = findElement(",tag,table");
		List<WebElement> headers = table.findElements(By.tagName("th"));
		List<WebElement> rows = table.findElements(By.xpath("//tbody//tr"));

		for (WebElement row : rows)
		{
			execute.executeScript("document.querySelector('.k-grid-content.k-virtual-content').scrollLeft=" + 0);
			headers = table.findElements(By.tagName("th"));
			rows = table.findElements(By.xpath("//tbody//tr"));
			Map<String, String> map = new LinkedHashMap<>();
			List<WebElement> datas = row.findElements(By.tagName("td"));

			int headerSize = headers.size();
			int dataSize = datas.size();
			int missingDataCount = headerSize - dataSize;
			int scrollPosition = 300;
			for (int i = 0; i < headerSize; i++)
			{
				String head = headers.get(i).getText();
				if (head.isEmpty())
				{
					threadSleep(100);
					execute = (JavascriptExecutor) driver;
					execute.executeScript("document.querySelector('.k-grid-content.k-virtual-content').scrollLeft=" + scrollPosition);
					scrollPosition += 300;
					head = headers.get(i).getText();
				}
				if (i < missingDataCount)
				{
					map.put(head, "");
				} else
				{
					String dataValue = datas.get(i - missingDataCount).getText();
					map.put(head, dataValue);
				}
			}
			list.add(map);
		}
		BaseTest.getTest().log(Status.INFO, list.toString());
//		ExtentManager.customReport(list);
		return list;
	}
}
