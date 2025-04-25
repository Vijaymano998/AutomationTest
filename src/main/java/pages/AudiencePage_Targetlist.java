package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Pattern;

import org.apache.commons.collections4.map.LinkedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;

import repository.AudienceRepository;
import repository.DashboardRepository;
import repository.ObjectRepository;
import utility.BaseTest;
import utility.ExtentManager;
import utility.PageFactory;

public class AudiencePage_Targetlist extends HomePage
{
	public AudiencePage_Targetlist(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	public AudiencePage_Targetlist filterTargetListTimePeriod()
	{
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforclick(autolocator(AudienceRepository.allmenu_targetlist), 30);
		clickElement(AudienceRepository.allmenu_targetlist);
		threadSleep(ObjectRepository.wait1sec);
		explicitwaitforclick(autolocator(AudienceRepository.audience_target_clicktimefreq), 30);
		clickElement(AudienceRepository.audience_target_clicktimefreq);
		threadSleep(ObjectRepository.wait3sec);
		selectlistelements(AudienceRepository.audience_target_selecttimefreq, BaseTest.getData().DateRangeFilter);
		if (BaseTest.getData().DateRangeFilter.contains("Custom range"))
		{
			clickElement(AudienceRepository.audience_target_timefreqmonthselect);
			selectlistelements(AudienceRepository.audience_target_timefreqmonthenter, "June");
			clickElement(AudienceRepository.audience_target_timefreqfirstdateselect);
			clickElement(AudienceRepository.audience_target_customfilterclickapply);
		}
		threadSleep(ObjectRepository.wait3sec);
		return this;
	}

	public String targetListSearchResult(String targetlistName)
	{
		String listName = null;
		threadSleep(300);
		String searchResultPosition = "1";
		for (int i = 0; i < 3; i++)
		{
			String segmentNamexpath = AudienceRepository.audience_compvalue + "[.='" + targetlistName + "']";
			try
			{
				List<WebElement> searchResul = findElements(segmentNamexpath);
				if (searchResul.size() == 1)
				{
					mouseHover(segmentNamexpath + "[1]");
					try
					{
						listName = getStrText(DashboardRepository.allpage_tooltip);
					} catch (Exception e)
					{
						listName = getStrText(segmentNamexpath);
					}
					if (listName.equalsIgnoreCase(targetlistName))
					{
						BaseTest.getTest().log(Status.INFO, "Recepient list has been searched");
						BaseTest.takeScreenshot();
						break;
					} else
					{
						BaseTest.getTest().log(Status.WARNING, "Search results showed different list");
						BaseTest.takeScreenshot();
						break;
					}
				} else if (searchResul.size() == 2)
				{
					threadSleep(300);
					mouseHover(segmentNamexpath + "[2]");
					try
					{
						listName = getStrText(DashboardRepository.allpage_tooltip);
					} catch (Exception e)
					{
						listName = getStrText(segmentNamexpath);
					}
					if (listName.equalsIgnoreCase(targetlistName))
					{
						BaseTest.getTest().log(Status.INFO, "Recepient list able to search");
						BaseTest.takeScreenshot();
						searchResultPosition = "2";

						break;
					} else
					{
						BaseTest.getTest().log(Status.WARNING, "Search results showed different list");
						BaseTest.takeScreenshot();
						break;
					}
				}
			} catch (Exception e)
			{
				if (i == 2)
				{
					BaseTest.getTest().log(Status.INFO, "Search results not present after some wait time");
					BaseTest.takeScreenshot();
				}
			}
		}
		return searchResultPosition;
	}

	public void clickNewListSegment()
	{
		pageLoaderLogo();
		toolTipValidationKnownText(AudienceRepository.audience_Target_newsegmentaddicon, "New target list");
		clickElement(AudienceRepository.audience_Target_newsegmentaddicon);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait1sec);
		breadcrumbTextCheck("Audience,Create target list");
	}

	public String enterTargetListName()
	{
		targetListName = BaseTest.getData().EnterTargetlistName + addTimeToName().replace("_", "");
		if (MDMTotalAudience != null)
		{
			if (!MDMTotalAudience.isEmpty())
			{
				int targetListAudienceCount = Integer.parseInt(getStrText(AudienceRepository.audience_Target_listtotalaudience).trim().replaceAll(",", ""));
				writeLog(targetListAudienceCount == Integer.parseInt(MDMTotalAudience), "MDM total audience : " + MDMTotalAudience + " is equal to target list total audience : " + targetListAudienceCount,
						"MDM total audience : " + MDMTotalAudience + " is not-equal to target list total audience : " + targetListAudienceCount);
			}
		}
		String targetListNamePlaceholder = getStrText(AudienceRepository.audience_Target_listNameplaceholder);
		writeLog(targetListNamePlaceholder.equals("Enter list name"), targetListNamePlaceholder + " placeholder is present as expected.", targetListNamePlaceholder + " placeholder is not present as expected.");
		enterValue(AudienceRepository.audience_Target_listName, targetListName);
		clickTab();
		try
		{
			explicitwaitforInvisibility((AudienceRepository.audience_importdesc_loader), 50);
		} catch (Exception e)
		{
			if (isElementPresent(AudienceRepository.audience_importdesc_greentick))
			{
				BaseTest.getTest().log(Status.INFO, "After entering list name green tick is present as expected.");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "After entering list name green tick is not present as expected.");
			}
		}
		writeLog(isElementPresent(AudienceRepository.audience_Target_listNametickmark), "List Name field green tick is present as expected.", "List Name field green tick is not-present as expected.");
		return targetListName;
	}

	public AudiencePage_Targetlist searchAndSelectAttribute(String SelectAttribute)
	{
		threadSleep(ObjectRepository.wait5sec);
		explicitwaitforclick(autolocator(AudienceRepository.audience_target_clickSearchattribute), 50);
		clickElement(AudienceRepository.audience_target_clickSearchattribute);
		threadSleep(ObjectRepository.wait1sec);
		enterValue(AudienceRepository.audience_target_enterSearchattribute, SelectAttribute);
		String searchAttributeTextboxVal = getTextBoxVal(AudienceRepository.audience_target_enterSearchattribute, "value");
		writeLog(searchAttributeTextboxVal.equals(SelectAttribute), "UI attribute name " + searchAttributeTextboxVal + " present as expected attribute name " + searchAttributeTextboxVal,
				"UI attribute name " + searchAttributeTextboxVal + "is not-present as expected attribute name " + searchAttributeTextboxVal);
		threadSleep(ObjectRepository.wait3sec);
		if (!SelectAttribute.equals(searchAttributeTextboxVal))
		{
			clickElement(AudienceRepository.audience_target_clickSearchClose);
		}
		String attributeName = "Clear search,xpath,//li[.='" + SelectAttribute + "" + "+" + "']";
		javaScriptScrollIntoView(attributeName);
		threadSleep(ObjectRepository.wait1sec);
		clickElement(attributeName);
		if (SelectAttribute.equals(searchAttributeTextboxVal))
		{
			clickElement(AudienceRepository.audience_target_clickSearchClose);
		}
		clickElement(AudienceRepository.audience_target_clickSearchattribute);
		return this;
	}

	public boolean selectTargetlistAttributeValues(String attributeType, int filterNum, String attributeName, String contains, String value)
	{
		if (attributeType.equalsIgnoreCase("Int"))
		{
			return selectFilterIntAttributeValue(filterNum, attributeName, contains, value);

		} else if (attributeType.equalsIgnoreCase("String"))
		{
			return selectFilterStringAttributeValue(filterNum, attributeName, contains, value);
		} /*
			 * else if (attributeType.equalsIgnoreCase("Date")) { return selectFilterDateAttributeValue(filterNum, attributeName, contains, value); }
			 */
		return false;
	}

	public void selectListAttributesValues(String attributeType, int filterNum, String attributeName, String contains, String newValue, String oldValue)
	{
		if (!selectTargetlistAttributeValues(attributeType, filterNum, attributeName, contains, newValue))
		{
			selectTargetlistAttributeValues(attributeType, filterNum, attributeName, contains, oldValue);
		}
	}

	public void selectListAttributesValues(String attributeType, int filterNum, String attributeName, String contains, String newValue)
	{
		if (!selectTargetlistAttributeValues(attributeType, filterNum, attributeName, contains, newValue))
		{
			BaseTest.getTest().log(Status.FAIL, "Attribute value differs");
		}
	}

	public boolean selectDuplicateAttribute(String attribute, int filterCount, String attributeNew)
	{
		boolean val = false;
		String xpathElement = replacePlaceHolder(AudienceRepository.audience_target_duplicateAttribute, attribute, String.valueOf(filterCount));
		String totalAttributesCountXpath = replacePlaceHolder(AudienceRepository.audience_target_totalAttributeCount, attribute);
		int initialAttributeSize = driver.findElements(autolocator(totalAttributesCountXpath)).size();
		toolTipValidationKnownText(xpathElement, "Duplicate");
		clickElement(xpathElement);
		int finalAttributeSize = driver.findElements(autolocator(totalAttributesCountXpath)).size();
		if ((initialAttributeSize + 1) == finalAttributeSize)
		{
			BaseTest.getTest().log(Status.INFO, attribute + " attribute is duplicated.");
			val = true;
		} else
		{
			BaseTest.getTest().log(Status.FAIL, attribute + " attribute is not duplicated.");
			val = false;
			BaseTest.takeScreenshot();
		}
		String duplicateAttributeXpath = replacePlaceHolder(AudienceRepository.audience_target_updatedDuplicateAttribute, attribute, String.valueOf(finalAttributeSize));
		clickElement(duplicateAttributeXpath);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, attributeNew);
		pageLoaderLogo();
		clickHereToGetCount(attribute);
		pageLoaderLogo();
		return val;
	}

	public void removeDuplicateAttribute(String attribute, int filterCount)
	{
		String loc = replacePlaceHolder(AudienceRepository.audience_target_removeIcon, attribute, String.valueOf(filterCount));
		toolTipValidationKnownText(loc, "Remove");
		clickElement(loc);
	}

	public void removeFilterAttributes(String attributeName, String value)
	{
		javaScriptScrollIntoView(replacePlaceHolder(AudienceRepository.audience_target_primaryfilter, attributeName));
		threadSleep(ObjectRepository.wait1sec);
		clickElement(replacePlaceHolder(AudienceRepository.audience_target_removeFilterIcon, attributeName, value));
	}

	private boolean selectFilterStringAttributeValue(int filterNum, String attributeName, String contains, String value)
	{
		boolean flag = false;
		BaseTest.getTest().log(Status.INFO, "Create new target list page select string attribute value");
		threadSleep(ObjectRepository.wait1sec);
		String status = getTextBoxVal(replacePlaceHolder(AudienceRepository.audience_target_attributeArrowIcon, attributeName), "class");
		writeLog(status.contains("off"), "Arrow is disable status as expected.", "Arrow is enable status.");
		if (!contains.contains("Has"))
		{
			enterValue(replacePlaceHolder(AudienceRepository.audience_target_attributedropdown, attributeName), value);
			if (isElementPresent(AudienceRepository.audience_target_Nodatafound))
			{
				return flag;
			} else if (selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, value))
			{
				flag = true;
				return flag;
			}
		} else
		{
			flag = true;
			return flag;
		}
		return flag;
	}

	private boolean selectFilterIntAttributeValue(int filterNum, String attributeName, String contains, String value)
	{
		BaseTest.getTest().log(Status.INFO, "Create new target list page select number attribute value");
		clickElement(replacePlaceHolder(AudienceRepository.audience_target_containfilter, attributeName));
		selectexactlistelements(replacePlaceHolder(AudienceRepository.audience_target_containfilterlist, String.valueOf(filterNum)), contains);
		threadSleep(ObjectRepository.wait1sec);
		if (!contains.contains("Has"))
		{
			clickElement(replacePlaceHolder(AudienceRepository.audience_target_attributeDropdownValue, attributeName));
			sendValue(replacePlaceHolder(AudienceRepository.audience_target_attributeDropdownValue, attributeName), value);
		}
		clickTab();
		return true;
	}

	public int clickHereToGetCount(String attributeName)
	{
		String xpath = replacePlaceHolder(AudienceRepository.audience_target_attributeArrowIcon, attributeName);
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforvisibility(autolocator(xpath), 30);
		try
		{
			toolTipValidationKnownText(xpath, "Click here to view the count");
			clickElement(xpath);
		} catch (Throwable e)
		{
			BaseTest.getTest().log(Status.WARNING, "Not able to click arrow icon is in disable state.");
		}
		int potentialCount = 0;
		try
		{
			threadSleep(ObjectRepository.wait3sec);
			pageLoaderLogo();
			explicitwaitforvisibility(autolocator(AudienceRepository.audience_target_potentialaudienceInclusiongroup1), 30);
			potentialCount = Integer.parseInt(getStrText(AudienceRepository.audience_target_potentialaudienceInclusiongroup1).replace(",", ""));
			String helpText = getStrText(replacePlaceHolder(AudienceRepository.audience_target_helpText, attributeName));
			writeLog(helpText.equals("Rec. 10 / Max. 25 Data values"), helpText + " help text present as expected.", helpText + " help text not present as expected.");
			pageLoaderLogo();
			if (potentialCount <= 0)
			{
				BaseTest.getTest().fail("potential audience count: " + potentialCount);
			} else
			{
				BaseTest.getTest().info("potential audience count: " + potentialCount);
			}
		} catch (Exception e)
		{
			BaseTest.getTest().fail("potential audience count not shown or loading ");
		}
		BaseTest.takeScreenshot();
		return potentialCount;
	}

	// Click on Create New list button after filter
	public AudiencePage_Targetlist createTargetList()
	{
		threadSleep(ObjectRepository.wait2sec);
		javaScriptScrollDown();
		clickElement(AudienceRepository.audience_target_helpquestionmark);
		threadSleep(300);
		String questionMarkText = getStrText(AudienceRepository.audience_target_questionmarktooltiptext);
		writeLog(questionMarkText.equals("Get the list approved by the concerned person."), questionMarkText + " tooltip text is shown as expected.", questionMarkText + " tooltip text is not shown as expected.");
		explicitwaitforclick(autolocator(AudienceRepository.audience_target_createlist), 70);
		clickElement(AudienceRepository.audience_target_createlist);
		threadSleep(ObjectRepository.wait1sec);
		pageLoaderLogo();
		return this;
	}

	public void recalculateLater()
	{
		threadSleep(ObjectRepository.wait3sec);
		pageLoaderLogo();
		if (isElementPresent(AudienceRepository.audience_target_recalculatepopupcontent))
		{
			String recalculatePopupContent = getStrText(AudienceRepository.audience_target_recalculatepopupcontent).replaceAll("\n", "");
			writeLog(recalculatePopupContent.equals("This may take a few minutes.would you like too.."), "Recalculate popup content shown as expected '<b>" + recalculatePopupContent + "</b>'",
					"Recalculate popup content not shown as expected '<b>" + recalculatePopupContent + "</b>'");
			clickElement(AudienceRepository.audience_target_recalculatelaterbutton);
			pageLoaderLogo();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Recalculate popup not shown.");
			BaseTest.takeScreenshot();
		}
	}

	public void recalculateNow()
	{
		if (isElementPresent(AudienceRepository.audience_target_recalculatepopupcontent))
		{
			String recalculatePopupContent = getStrText(AudienceRepository.audience_target_recalculatepopupcontent).replaceAll("\n", "");
			writeLog(recalculatePopupContent.equals("This may take a few minutes.would you like too.."), "Recalculate popup content shown as expected '<b>" + recalculatePopupContent + "</b>'",
					"Recalculate popup content not shown as expected '<b>" + recalculatePopupContent + "</b>'");
			clickElement(AudienceRepository.audience_target_recalculatenowbutton);
			pageLoaderLogo();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Recalculate popup not shown.");
			BaseTest.takeScreenshot();
		}
	}

	// Save the Target List
	public AudiencePage_Targetlist saveTargetList()
	{
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforpresence(autolocator(AudienceRepository.audience_target_createpopupsavebutton), 50);
		clickElement(AudienceRepository.audience_target_createpopupsavebutton);
		threadSleep(ObjectRepository.wait2sec);
		pageLoaderLogo();
		return this;
	}

	public void targetSegmentationCountCheck()
	{
		String totalAudienceCount;
		int initialSegCount = 0;
		totalAudienceCount = getStrText(AudienceRepository.audience_Target_listtotalaudience).trim().replaceAll(",", "");
		List<WebElement> segAttributeCount = findElements(AudienceRepository.audience_target_segmentationattributecount);
		for (int count = 0; count < segAttributeCount.size(); count++)
		{
			String[] firstSegSplit = segAttributeCount.get(count).getText().split("\\(");
			String[] secondSegSplit = firstSegSplit[1].split("\\)");
			if (secondSegSplit[0].contains("-"))
			{
				int segCount = Integer.parseInt(secondSegSplit[0].replace("-", "").replace(",", "").trim());
				switch (count)
				{
				case 0 -> initialSegCount = Integer.parseInt(totalAudienceCount) - segCount;
				case 1 -> initialSegCount = initialSegCount - segCount;
				}
			} else if (secondSegSplit[0].contains("+"))
			{
				int segCount = Integer.parseInt(secondSegSplit[0].replace("+", "").replace(",", "").trim());
				switch (count)
				{
				case 0 -> initialSegCount = Integer.parseInt(totalAudienceCount) - segCount;
				case 1 -> initialSegCount = initialSegCount + segCount;
				}
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Segmentation arithemetic is not present as expected.");
			}
		}
		String finalSegmentationCount = getStrText(replacePlaceHolder(AudienceRepository.audience_target_FinalSegmentationCount, String.valueOf(segAttributeCount.size()))).trim();
		writeLog(Integer.parseInt(finalSegmentationCount) == initialSegCount, "After segmented segmentation count : " + initialSegCount + " present as expected.",
				"After segmented segmentation count : " + initialSegCount + " not present as expected.");
	}

	public AudiencePage_Targetlist addInclusion()
	{
		threadSleep(ObjectRepository.wait3sec);
		if (isDisplayed(AudienceRepository.audience_target_inclusionexclusionaddbutton))
		{
			clickElement(AudienceRepository.audience_target_inclusionexclusionaddbutton);
			threadSleep(ObjectRepository.wait3sec);
			clickElement(AudienceRepository.audience_target_AddInclusion);
			toogleButtonCondition("AND", 1);
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Plus ( + ) button to add inclusion is not displayed");
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public void toogleButtonCondition(String buttonText, int button)
	{
		WebElement buttonElement = driver.findElement(autolocator(replacePlaceHolder(AudienceRepository.audience_target_tooglebutton, String.valueOf(button))));
		String buttonStatus = buttonElement.getAttribute("class");
		if (buttonStatus.toLowerCase().contains("switch-on"))
		{
			String uiButtonText = buttonElement.findElement(autolocator(AudienceRepository.audience_target_tooglebuttonStatusOn)).getText();
			writeLog(uiButtonText.contains(buttonText), uiButtonText + " button text is present as expected " + buttonText, uiButtonText + " button text is not-present as expected " + buttonText);
		} else if (buttonStatus.toLowerCase().contains("switch-off"))
		{
			if (button != 2)
			{
				String uiButtonText = buttonElement.findElement(autolocator(AudienceRepository.audience_target_tooglebuttonStatusOff)).getText();
				writeLog(uiButtonText.contains(buttonText), uiButtonText + " button text is present as expected " + buttonText, uiButtonText + " button text is not-present as expected " + buttonText);
			} else if (buttonStatus.toLowerCase().contains("not"))
			{
				String uiButtonText = buttonElement.findElement(autolocator(replacePlaceHolder(AudienceRepository.audience_target_tooglebuttonStatusNot, buttonStatus))).getText();
				writeLog(uiButtonText.contains(buttonText), uiButtonText + " button text is present as expected " + buttonText, uiButtonText + " button text is not-present as expected " + buttonText);
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "toggle text not present as expected.");
				BaseTest.takeScreenshot();
			}
		}
	}

	// Exclusion Targetlist
	public AudiencePage_Targetlist addExclusion()
	{
		threadSleep(ObjectRepository.wait3sec);
		javaScriptScrollDown();
		if (isDisplayed(AudienceRepository.audience_target_inclusionexclusionaddbutton))
		{
			clickElement(AudienceRepository.audience_target_inclusionexclusionaddbutton);
			threadSleep(ObjectRepository.wait1sec);
			clickElement(AudienceRepository.audience_target_AddExclusion);
			toogleButtonCondition("NOT", 2);
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Plus ( + ) button to add exclusion is not displayed");
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public Map<String, List<String>> getTrgtAttributes()
	{
		String attribute;
		String headerName = null;
		List<WebElement> filterAttribute;
		Map<String, List<String>> mapAttribute = new HashMap<String, List<String>>();
		List<WebElement> attributeHeader = findElements(AudienceRepository.audience_target_attributesHeaderName);
		for (WebElement header : attributeHeader)
		{
			headerName = header.getText();
			javaScriptScrollIntoView(replacePlaceHolder(AudienceRepository.audience_target_headerName, headerName));
			threadSleep(ObjectRepository.wait1sec);
			List<WebElement> attributesCount = findElements(replacePlaceHolder(AudienceRepository.audience_target_visibleattributes, headerName));
			List<String> listAttributes = new ArrayList<String>();
			for (WebElement attributesName : attributesCount)
			{
				attribute = attributesName.getText().replaceAll("\n", "").replace("+", "").trim();
				if (!attribute.isEmpty())
				{
					listAttributes.add(attribute);
				}
			}
			try
			{
				javaScriptScrollUpToSomeExtend();
				threadSleep(ObjectRepository.wait1sec);
				driver.findElement(autolocator(replacePlaceHolder(AudienceRepository.audience_target_headersDropdown, headerName))).click();
				BaseTest.getTest().log(Status.INFO, "clicked--> " + headerName + " dropdown");
			} catch (Exception e)
			{
				BaseTest.getTest().log(Status.FAIL, "clicked action failed--> " + headerName + " dropdown");
			}
			filterAttribute = findElements(AudienceRepository.audience_target_dropdownattributes);
			for (int i = 0; i < filterAttribute.size(); i++)
			{
				filterAttribute = findElements(AudienceRepository.audience_target_dropdownattributes);
				attribute = filterAttribute.get(i).getText().trim();
				if (!attribute.isEmpty())
				{
					listAttributes.add(attribute);
				}
			}
			Collections.sort(listAttributes);
			mapAttribute.put(headerName, listAttributes);
//			listAttributes.clear();
			try
			{
				driver.findElement(autolocator(replacePlaceHolder(AudienceRepository.audience_target_headersDropdown, headerName)));
				BaseTest.getTest().log(Status.INFO, "clicked--> " + headerName + " dropdown");
			} catch (Exception e)
			{
			}
		}
		return mapAttribute;
	}

	public void clickRfaCheckbox()
	{
		explicitwaitforclick(autolocator(AudienceRepository.audience_target_rfaCheckbox), 90);
		clickElement(AudienceRepository.audience_target_rfaCheckbox);
	}

	public void selectTargetListRfa(int approver, String approverMailId)
	{
		javaScriptScrollDown();
		threadSleep(ObjectRepository.wait1sec);
		if (approver != 1 && approver != 3)
		{
			clickElement(AudienceRepository.audience_target_rfaaddicon);
		}
		clickElement(replacePlaceHolder(AudienceRepository.audience_target_approverdropdown, String.valueOf(approver)));
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, approverMailId);
	}

	public String getRfaTargetListLink(String userName)
	{
		String prntWin = parentWinHandle();
		javaScriptopenNewWindow();
		switchWindow();
		if (userName.contains("smartdx.co"))
		{
			smartdxWebUrlLaunch();
		} else
		{
			teamWebUrlLaunch();
		}
		teamWebmailLogin(userName, System.getProperty(userName));
		String link = getTargetListRFAApprovalMailLink(targetListName);
		teamWebmailLogout();
		childWindowClose(prntWin);
		return link;
	}

	public void approveRfa(String link)
	{
		getWebURL(link);
		threadSleep(ObjectRepository.wait1sec);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait1sec);
		pageLoaderLogo();
		try
		{
			explicitwaitforInvisibility(AudienceRepository.audience_target_nonloadingcontainer, 90);
		} catch (Exception e)
		{
			BaseTest.getTest().log(Status.INFO, "list attributes loading properly in target listing page.");
		}
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait5sec);
		String listName = getTextBoxVal(AudienceRepository.audience_Target_listName, "value");
		writeLog(listName.equals(targetListName), "Target list Name is present as expected.", "Target list Name is not present as expected.");
		clickElement(AudienceRepository.audience_Target_approverfaButton);
		threadSleep(ObjectRepository.wait1sec);
		pageLoaderLogo();
		threadSleep(200);
		String popup = getStrText(AudienceRepository.audience_Target_rfapopup);
		writeLog(popup.equals("Target list approved successfully"), "Target list approve popup is present as expected.", "Target list approve popup is present as expected.");
		clickElement(AudienceRepository.audience_Target_rfapopupCancel);
		threadSleep(ObjectRepository.wait5sec);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait5sec);
		pageLoaderLogo();
		if (isElementPresent(AudienceRepository.audience_target_searchIcon))
		{
			BaseTest.getTest().log(Status.INFO, "After approve page navigated to the target listing page as expected.");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Page not navigated to the target listing page.");
			BaseTest.takeScreenshot();
		}
		clickTargetListRFAIcon(listName, "Target list has been already approved.");
	}

	public void rejectRfa(String link)
	{
		getWebURL(link);
		threadSleep(ObjectRepository.wait1sec);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait1sec);
		pageLoaderLogo();
		try
		{
			explicitwaitforInvisibility(AudienceRepository.audience_target_nonloadingcontainer, 90);
		} catch (Exception e)
		{
			BaseTest.getTest().log(Status.INFO, "list attributes loading properly in target listing page.");
		}
		String listName = getTextBoxVal(AudienceRepository.audience_Target_listName, "value");
		writeLog(listName.equals(targetListName), "Target list Name is present as expected.", "Target list Name is not present as expected.");
		clickElement(AudienceRepository.audience_Target_rejectrfaButton);
		threadSleep(ObjectRepository.wait1sec);
		pageLoaderLogo();
		writeLog(getStrText(AudienceRepository.audience_Target_rejectcommentheader).equals("Comments"), "Comment popup header name is present as expected.", "Comment popup header name is not present as expected.");
		String comment = "List is rejected";
		enterValue(AudienceRepository.audience_Target_rejectcommentbox, comment);
		tabAction();
		int uiCommentLength = getTextBoxVal(AudienceRepository.audience_Target_rejectcommentbox, "value").length();
		writeLog(getStrText(AudienceRepository.audience_Target_rejectcommentMaxChar).equals("Max. 500 characters."), "Max char text is present as expected.", "Max char text is not present as expected.");
		int occupiedCharLength = Integer.parseInt(getStrText(AudienceRepository.audience_Target_rejectcommentOccupiedChar).split("/")[0].trim());
		writeLog(uiCommentLength == occupiedCharLength, "Comment box length is present as expected", "Comment box length is not present as expected.");
		clickElement(AudienceRepository.audience_target_createpopupsavebutton);
		threadSleep(ObjectRepository.wait5sec);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait5sec);
		pageLoaderLogo();
		if (isElementPresent(AudienceRepository.audience_target_searchIcon))
		{
			BaseTest.getTest().log(Status.INFO, "After reject page navigated to the target listing page as expected.");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Page not navigated to the target listing page.");
			BaseTest.takeScreenshot();
		}
		clickTargetListRFAIcon(listName, "Target List has been already rejected");
	}

	public void requestApprovalSettingAll(String radioButton, String hierarchy)
	{
		String followHierarchyStatus;
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_target_rfaSettingIcon), 90);
		clickElement(AudienceRepository.audience_target_rfaSettingIcon);
		clickElement(AudienceRepository.audience_target_rfasettingallradiobutton);
		followHierarchyStatus = getTextBoxVal(AudienceRepository.audience_target_rfasettingfollowhierarchy, "class");
		if ((followHierarchyStatus.toLowerCase().contains("on") && hierarchy.toLowerCase().contains("off")) || followHierarchyStatus.toLowerCase().contains("off") && hierarchy.toLowerCase().contains("on"))
		{
			clickElement(AudienceRepository.audience_target_rfasettingfollowhierarchy);
		}
		followHierarchyStatus = getTextBoxVal(AudienceRepository.audience_target_rfasettingfollowhierarchy, "class");
		if (followHierarchyStatus.toLowerCase().contains(hierarchy))
		{
			BaseTest.getTest().log(Status.INFO, "Follow hierarchy button is present as expected.");
			BaseTest.takeScreenshot();
		}
		clickElement(AudienceRepository.audience_target_rfasettingsavebutton);
	}

	public void requestApprovalSettingAny(String radioButton, int approver)
	{
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_target_rfaSettingIcon), 90);
		clickElement(AudienceRepository.audience_target_rfaSettingIcon);
		clickElement(AudienceRepository.audience_target_rfasettinganyradiobutton);
		clickElement(AudienceRepository.audience_target_rfasettinganydropdown);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, String.valueOf(approver));
		clickElement(AudienceRepository.audience_target_rfasettingsavebutton);
	}

	public void rfaMandateCheck()
	{
		String anyApproverValue = null;
		if (isElementPresent(AudienceRepository.audience_target_rfaSettingIcon))
		{
			if (findElements(AudienceRepository.audience_target_approverdropdownfield).size() == 1)
			{
				BaseTest.getTest().log(Status.FAIL, "RFA setting not shown approver has been only one.");
				BaseTest.takeScreenshot();
			} else
			{
				clickElement(AudienceRepository.audience_target_rfaSettingIcon);
				String radioButtonName = getStrText(AudienceRepository.audience_target_rfaSettingActiveRadioButton);
				if (radioButtonName.equals("Any"))
				{
					anyApproverValue = getStrText(AudienceRepository.audience_target_rfasettinganydropdownvalue);
					clickElement(AudienceRepository.audience_target_rfasettingsavebutton);

				} else if (radioButtonName.equals("All"))
				{
					BaseTest.getTest().log(Status.INFO, "All radio button is enabled not able to verify mandate icon");
				}

				if (Integer.parseInt(anyApproverValue) == 2 && findElements("//a[@id='id_mandatory']").size() == 3)
				{
					clickElement("1 mandatoryicon");
					try
					{
						clickElement("2 mandatoryicon");
					} catch (Exception e)
					{
						try
						{
							clickElement("3 mandatoryicon");
						} catch (Exception e2)
						{
							BaseTest.getTest().log(Status.INFO, "Not able to click mandatory icon.");
						}
					}
					if (findElements("//a[@id='id_mandatory'][contains(@class,'off')]").size() == 2)
					{
						BaseTest.getTest().log(Status.INFO, "Present as expected.");
					} else
					{
						BaseTest.getTest().log(Status.FAIL, "not-present as expected.");
					}
				} else
				{

				}
				switch (Integer.parseInt(anyApproverValue))
				{
				case 2 -> {
					clickElement("mandateIcon");
				}
				case 3 -> {
				}
				}
			}
		}
	}

	public boolean duplicateTargetlist(String targetListName, String dupTargetName)
	{
		BaseTest.getTest().log(Status.INFO, "Duplicate target list");
		String position = targetListSearchResult(targetListName);
		{
			if (isElementPresent(AudienceRepository.audience_target_listextractionText))
			{
				BaseTest.getTest().log(Status.INFO, "Target list extraction may be in progress, Target list widget is diabled");
				BaseTest.takeScreenshot();
				return false;
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Target list extraction completed,Target list widget is eabled");
				clickElement(AudienceRepository.audience_target_listkebabMenu + "[" + position + "]");
				enterDuplicateListName(clickDuplicateIcon(AudienceRepository.audience_target_listkebabMenu + "[" + position + "]"), dupTargetName);
				return true;
			}
		}
	}

	public boolean clickDuplicateIcon(String duplicateIconLocator)
	{
		boolean val = false;
		try
		{
			driver.findElement(autolocator(AudienceRepository.audience_target_listduplicateicon)).click();
			BaseTest.getTest().log(Status.INFO, "Clicked -> Duplicate icon");
			val = true;
			return val;
		} catch (Exception e)
		{
			BaseTest.takeScreenshot();
			clickElement(duplicateIconLocator);
			try
			{
				clickElement(AudienceRepository.audience_target_listduplicateicon);
				val = true;
				return val;
			} catch (Exception e2)
			{
				BaseTest.getTest().log(Status.WARNING, "Not able to click duplicate icon");
				BaseTest.takeScreenshot();
			}
		}
		return val;
	}

	public void enterDuplicateListName(boolean val, String dupTargetName)
	{
		if (val)
		{
			threadSleep(ObjectRepository.wait5sec);
			clickElement(AudienceRepository.audience_target_enterdupname);
			threadSleep(ObjectRepository.wait5sec);
			clearField(AudienceRepository.audience_target_enterdupname);
			enterValue(AudienceRepository.audience_target_enterdupname, dupTargetName);
			BaseTest.getTest().log(Status.INFO, "duplicate icon clicked from Target list,entered new target list name : " + dupTargetName);
			tabAction();
			pageLoaderLogo();
			threadSleep(ObjectRepository.wait5sec);
			explicitwaitforclick(autolocator(AudienceRepository.audience_target_savedupname), 50);
			clickElement(AudienceRepository.audience_target_savedupname);
			BaseTest.getTest().log(Status.INFO, "duplicated target list saved");
			threadSleep(ObjectRepository.wait10sec);
		}
	}

	public void editTargetListName(String targetList)
	{
		pageLoaderLogo();
		threadSleep(400);
		clickElement(AudienceRepository.audience_target_editTargetListName);
		String listName = getTextBoxVal(AudienceRepository.audience_Target_listName, "value");
		if (listName.equals(targetList))
		{
			BaseTest.getTest().log(Status.INFO, "<b>" + targetList + "</b> is present as expected <b>" + listName + "</b>");
			clearField(AudienceRepository.audience_Target_listName);
			enterValue(AudienceRepository.audience_Target_listName, "edit_" + targetList);
			tabAction();
			pageLoaderLogo();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Target list name is not shown as expected.");
		}
		BaseTest.takeScreenshot();
	}

	public void editTargetList(String targetList)
	{
		try
		{
			toolTipValidationKnownText(replacePlaceHolder(AudienceRepository.audience_target_edittargetlist, targetList), "Edit");
			clickElement(replacePlaceHolder(AudienceRepository.audience_target_edittargetlist, targetList));
			BaseTest.getTest().log(Status.INFO, "Edit icon is clicked");
		} catch (Exception e)
		{
			BaseTest.getTest().log(Status.FAIL, "Not able to click edit icon");
		}
		BaseTest.takeScreenshot();
	}

	public void clickMoreInfoIcon(String targetList)
	{
		try
		{
			toolTipValidationKnownText(replacePlaceHolder(AudienceRepository.audience_target_moreinfo, targetList), "Info");
			clickElement(replacePlaceHolder(AudienceRepository.audience_target_moreinfo, targetList));
			BaseTest.getTest().log(Status.INFO, "clicked  -- > More info icon");
			pageLoaderLogo();
		} catch (Exception e)
		{
			BaseTest.getTest().log(Status.FAIL, "Not able to click info icon");
		}
		BaseTest.takeScreenshot();
	}

	public void clickAndValidateTLPreview(String listName)
	{
		clickElement(replacePlaceHolder(AudienceRepository.audience_target_info_previewIcon, listName));
		pageLoaderLogo();
		if (isElementPresent(AudienceRepository.audience_target_no_data_available))
		{
			writeLog(getStrText(AudienceRepository.audience_target_no_data_available).equals("No data available"), "target list preview data shows 'No data available'.", "target list preview data not shown 'No data available'");
		} else
		{

		}
		clickElement(AudienceRepository.audience_target_backicon);
	}

	public void checkTLEncodeValue(String listName)
	{
		String uiencodeValue = getStrText(replacePlaceHolder(AudienceRepository.audience_target_encodeValue, listName));
		writeLog(!uiencodeValue.isEmpty(), "Encode value is present.", "Encode value is not present.");
	}

	public void clickAdvanceAnalytics()
	{
		toolTipValidationKnownText(AudienceRepository.audience_target_advanceanalyticsicon, "Advanced details");
		clickElement(AudienceRepository.audience_target_advanceanalyticsicon);
		pageLoaderLogo();
		String noDataFoundText = getStrText(AudienceRepository.audience_target_advanceanalyticsNoDataFound);
		writeLog(noDataFoundText.equals("No record found"), "'No record found' is present.", "'No record found' is not present.");
		clickElement(AudienceRepository.audience_target_advanceanalytics_questionmark);
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_target_advanceanalytics_questionmark), 40);
		threadSleep(500);
		String tooltipText = getStrText(AudienceRepository.audience_target_advanceanalytics_questionmarktext);
		writeLog(tooltipText.equals("You cannot select more than 5 attributes.\nDownload option will be enabled once the Advanced details grid is displayed with data."), "Question mark tooltip value is present as expected.",
				"Question mark tooltip value is not present as expected.");
		clickElement(AudienceRepository.audience_target_advanceanalytics_questionmark);
	}

	public void targetListMoreInfoValidation(Map<String, String> listDetails)
	{
		// Listing page list details
		String createdByName = listDetails.get("Created by");
		String createdDateAndTime = listDetails.get("Created Date&Time").toLowerCase();
		String linkedCommunication = listDetails.get("LinkedCommunication").split(":")[1].trim();
		String segCount = listDetails.get("SegmentationCount").split(":")[1].trim();

		// More info list details
		String moreInfoCreatedByName = driver.findElement(autolocator(AudienceRepository.audience_target_moreinfoNameAndDate)).getText().split(",")[0].split(":")[1].trim();
		String moreInfoCreatedDateAndTime = driver.findElement(autolocator(AudienceRepository.audience_target_moreinfoNameAndDate)).getText().split(moreInfoCreatedByName + ",")[1].toLowerCase().trim();
		String moreInfoLinkedCommunication = driver.findElements(autolocator(AudienceRepository.audience_target_moreinfolinkedCommAndSegCount)).get(0).getText().split("\\(")[1].split("\\)")[0];
		String moreInfoSegCount = driver.findElements(autolocator(AudienceRepository.audience_target_moreinfolinkedCommAndSegCount)).get(1).getText().split("\\(")[1].split("\\)")[0];

		writeLog(moreInfoCreatedByName.equals(createdByName), "List created name and more info created name '" + createdByName + "' is present as expected.",
				"List created name and more info created name '" + createdByName + "' is not-present as expected.");
		writeLog(moreInfoCreatedDateAndTime.equals(createdDateAndTime), "List created date&time and more info created date & time '" + createdDateAndTime + "' is present as expected.",
				"List created date & time and more info created date & time '" + createdDateAndTime + "' is not-present as expected.");
		writeLog(moreInfoLinkedCommunication.equals(linkedCommunication), "List linked communication count and more info linked communication count '" + linkedCommunication + "' is present as expected.",
				"List linked communication count and more info linked communication count '" + linkedCommunication + "' is not-present as expected.");
		writeLog(moreInfoSegCount.equals(segCount), "List segmentation count and more info segmentation count '" + segCount + "' is present as expected.",
				"List segmentation count and more info segmentation count '" + segCount + "' is not-present as expected.");
	}

	public void searchAdvanceAnalytics(String value)
	{
		clickElement(AudienceRepository.audience_target_advanceanalyticsdropdown);
		selectlistelements(AudienceRepository.audience_target_advanceanalytics_dropdownvalue, value);
		toolTipValidationKnownText(AudienceRepository.audience_target_advanceanalyticsarrow, "Click here to view the grid");
		clickElement(AudienceRepository.audience_target_advanceanalyticsarrow);
		pageLoaderLogo();
	}

	public void downloadAndValidateAdvanceAnalyticsFromWebmail(List<Map<String, String>> advanceDetailsTableCount)
	{
		List<Map<String, String>> excelDataList = new LinkedList<Map<String, String>>();
		String userName = System.getProperty("teamKeyAcctWebmailUsername");
		javaScriptopenNewWindow();
		String pwind = parentWinHandle();
		switchWindow();
		teamWebUrlLaunch();
		teamWebmailLogin(userName, System.getProperty(userName));
		String otp = getWebmailOTPforDetailedAnalytics();
		teamWebmailLogout();
		if (otp != null)
		{
			switchParentWin(pwind);
			entersOTPAndSubmit(otp, "target");
			switchWindow();
			teamWebUrlLaunch();
			teamWebmailLogin(userName, System.getProperty(userName));
			String link = getWebmailTargetlistAdvanceDetailsDownloadLink();
			teamWebmailLogout();
			if (link != null)
			{
				BaseTest.getWebDriver().get(link);
				String invalidAudienceDownload = getStrText(AudienceRepository.Audiencedownloadheader);
				writeLog(invalidAudienceDownload.equals("Audience - CSV download list"), "Target list audience download header is present as expected.", "Target list audience download header is not-present as expected.");
				threadSleep(200);
				pageLoaderLogo();
				threadSleep(200);
				clickElement(AudienceRepository.AudienceDownloadButton);
				pageLoaderLogo();
				ArrayList<Object> excelData = filehandle();
				String[] datas = excelData.get(1).toString().split("\\R");
				String[] headers = datas[0].split(",");
				for (int i = 1; i < datas.length; i++)
				{
					String[] data = datas[i].split(",");
					Map<String, String> map = new LinkedHashMap<>();
					for (int j = 0; j < data.length; j++)
					{
						map.put(headers[j].replaceAll("_s", ""), data[j]);
					}
					excelDataList.add(map);
				}
				BaseTest.getTest().log(Status.INFO, "<b>TARGET LIST EXCEL DATA : </b>");
				ExtentManager.customReport(excelDataList);
				writeLog(advanceDetailsTableCount.equals(excelDataList), "Table and excel data is same as expected.", "Table and excel data is not same.");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Target list download mail not received");
			}
		}
	}

	public List<Map<String, String>> getAllTableValue()
	{
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		List<WebElement> rows, headers, datas;
		List<WebElement> table = driver.findElements(By.tagName("table"));
		headers = table.get(0).findElements(By.tagName("th"));
		rows = table.get(0).findElements(By.xpath("//tbody//tr"));
		for (int rowsize = 0; rowsize < rows.size(); rowsize++)
		{
			Map<String, String> map = new HashMap<>();
			datas = rows.get(rowsize).findElements(By.tagName("td"));
			for (int data = 0; data < datas.size(); data++)
			{
				String head = headers.get(data).getText();
				String dataValue = datas.get(data).getText();
				map.put(head, dataValue);
			}
			list.add(rowsize, map);
		}
		return list;
	}

	public void clickTargetListDownload(String listName, String segType)
	{
		clickElement(replacePlaceHolder(AudienceRepository.audience_targetlist_doticon, listName));
		clickElement(AudienceRepository.audience_target_download);
		pageLoaderLogo();
		if (segType.equals("sample list"))
		{
			clickElement(AudienceRepository.audience_target_downloadsamplelist);
		} else if (segType.equals("full segment list"))
		{
			clickElement(AudienceRepository.audience_target_downloadfullsamplelist);
		} else
		{
			clickElement(AudienceRepository.audience_target_share);
		}
	}

	public void clickCgTgIcon(String listName)
	{
		clickElement(replacePlaceHolder(AudienceRepository.audience_targetlist_doticon, listName));
		clickElement(AudienceRepository.audience_target_listcgtgicon);
		pageLoaderLogo();
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_target_cgtgPopupValidation), 90);
	}

	public void clickMatchList(String listName)
	{
		clickElement(replacePlaceHolder(AudienceRepository.audience_targetlist_doticon, listName));
		clickElement(AudienceRepository.audience_target_matchoutputlist);
		pageLoaderLogo();
		String header = getStrText(AudienceRepository.audience_target_popupheader);
		writeLog(header.equals("Match input list"), "Match input list header is present as expected.", "Match input list header is not present as expected.");
	}

	public void clickSuppressionList(String listName)
	{
		clickElement(replacePlaceHolder(AudienceRepository.audience_targetlist_doticon, listName));
		clickElement(AudienceRepository.audience_target_suppressionoutputlist);
		pageLoaderLogo();
		String header = getStrText(AudienceRepository.audience_target_popupheader);
		writeLog(header.equals("Suppression input list"), "Suppression input list header is present as expected.", "Suppression input list header is not present as expected.");
	}

	public void clickTargetListRFAIcon(String listName, String approverMessage)
	{
		try
		{
			filterTargetListTimePeriod().searchTargetList(listName);
			mouseHover(replacePlaceHolder(AudienceRepository.audience_target_shortname, shortListName));
			listName = getStrText(DashboardRepository.allpage_tooltip);
			clickElement(replacePlaceHolder(AudienceRepository.audience_target_approverIcon, listName));
			try
			{
				String commonPopupMessage = getStrText(DashboardRepository.commonPopupMessage);
				writeLog(commonPopupMessage.equals(approverMessage), commonPopupMessage + " is equal to expected text " + approverMessage, commonPopupMessage + " is not-equal to expected text " + approverMessage);
				clickElement(AudienceRepository.audience_Target_rfapopupCancel);
				clickElement(AudienceRepository.audience_target_cancelbutton);
				threadSleep(ObjectRepository.wait5sec);
				pageLoaderLogo();
				threadSleep(ObjectRepository.wait5sec);
				writeLog(isElementPresent(AudienceRepository.audience_target_searchIcon), "Navigated to the target listing page as expected.", "Page not navigated to the target listing page.");
			} catch (Exception e)
			{
				if (isElementPresent(AudienceRepository.audience_Target_listName))
				{
					BaseTest.getTest().log(Status.FAIL, "Page navigate to target list segmentation page, '" + approverMessage + "' popup is not displayed.");
				} else
				{
					writeLog(isElementPresent(AudienceRepository.audience_target_searchIcon), "'" + approverMessage + "' popup is not displayed.", "'" + approverMessage + "' popup is displayed.");
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			BaseTest.getTest().log(Status.FAIL, "Page is not navigate to the expected page.");
			BaseTest.takeScreenshot();
		}

	}

	public AudiencePage_Targetlist clientSearchAndSelectAttribute(String attribute)
	{
		threadSleep(ObjectRepository.wait5sec);
		explicitwaitforclick(autolocator(AudienceRepository.audience_target_clickSearchattribute), 50);
		clickElement(AudienceRepository.audience_target_clickSearchattribute);
		threadSleep(ObjectRepository.wait1sec);
		enterValue(AudienceRepository.audience_target_enterSearchattribute, attribute);
		threadSleep(ObjectRepository.wait3sec);
		String value = "Clear search,xpath,//a[contains(.,'" + attribute + "" + "')]";
		clickElement(value);
		clickElement(AudienceRepository.audience_target_clickSearchClose);
		clickElement(AudienceRepository.audience_target_clickSearchattribute);
		return this;
	}

	public AudiencePage_Targetlist createNewsegment()
	{
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforclick(autolocator(AudienceRepository.audience_target_newlistsegment), 30);
		clickElement(AudienceRepository.audience_target_newlistsegment);
		BaseTest.getTest().info(MarkupHelper.createLabel("NEW TARGET LIST PAGE", ExtentColor.BLUE));
		return this;
	}

	public String enterTargetListname()
	{
		String TargetListName = BaseTest.getData().EnterTargetlistName + addTimeToName().replaceAll("_", "");
		explicitwaitforpresence(autolocator(AudienceRepository.audience_target_enterlistname), 60);
		enterValue(AudienceRepository.audience_target_enterlistname, TargetListName);
		return TargetListName;
	}

	public boolean selectMat_Sup_OutputList(String matchInputList)
	{
		boolean flag = false;
		clickElement(AudienceRepository.audience_target_mat_sup_outputdropdown);
		threadSleep(ObjectRepository.wait1sec);
		if (selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, matchInputList))
		{
			pageLoaderLogo();
			List<String> attributes = mat_Sup_AttributeSelect();
			for (String attribute : attributes)
			{
				if (!selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, attribute))
				{
					BaseTest.getTest().log(Status.WARNING, "Attribute is not present as expected.");
				}
				pageLoaderLogo();
				clickElement(AudienceRepository.audience_target_listattributesdropdown);
			}
			tabAction();
			clickElement(AudienceRepository.audience_target_Applybutton);
			pageLoaderLogo();
			flag = true;
		}
		if (flag)
		{
			BaseTest.getTest().log(Status.INFO, "Match-output list selected and mapped succesfully.");
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Match-output list is not selected.");
		}
		return flag;
	}

	public void getListName(String trgtName, String matchListName)
	{

	}

	public List<String> mat_Sup_AttributeSelect()
	{
		threadSleep(ObjectRepository.wait1sec);
		pageLoaderLogo();
		List<String> attributes = new LinkedList<String>();
		if (!BaseTest.getData().OutputListAttributeValue.isEmpty())
		{
			for (String attribute : BaseTest.getData().OutputListAttributeValue.split(","))
			{
				attributes.add(attribute);
			}
		} else
		{
			clickElement(AudienceRepository.audience_target_listattributesdropdown);
			threadSleep(ObjectRepository.wait1sec);
			for (WebElement attr : findElements(DashboardRepository.allpage_common_selectdropdownlist))
			{
				attributes.add(attr.getText().trim());
			}
		}
		return attributes;
	}

	public void validateCGTGSlider(String condition)
	{
		String toggleStatus = getTextBoxVal(AudienceRepository.audience_target_cgtgToggleButton, "class");
		if (toggleStatus.toLowerCase().contains("on") && condition.toLowerCase().contains("on"))
		{
			BaseTest.getTest().log(Status.INFO, "Toggle button status is present as expected.");
		} else if (toggleStatus.toLowerCase().contains("off") && condition.toLowerCase().contains("off"))
		{
			BaseTest.getTest().log(Status.INFO, "Toggle button status is present as expected.");
			clickCgTgToogleButton();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Toggle button status is not present as expected.");
		}
	}

	public void clickCgTgToogleButton()
	{
		clickElement(AudienceRepository.audience_target_cgtgToggleButton);
		pageLoaderLogo();
	}

	public void verifyCGTGValue(Map<String, String> moreInfoDetails)
	{
		String cgSplitSize = getTextBoxVal(AudienceRepository.audience_target_cgTopValue, "value").replaceAll("[^0-9]", "").trim() + "%";
		String tgSplitSize = getStrText(AudienceRepository.audience_target_tgTopValue).replaceAll("[^0-9]", "").trim() + "%";
		String sliderCg = getStrText(AudienceRepository.audience_target_slidercgvalue).replaceAll("[^0-9]", "").trim() + "%";
		String sliderTg = getStrText(AudienceRepository.audience_target_slidertgvalue).replaceAll("[^0-9]", "").trim() + "%";
		writeLog(sliderCg.equals(cgSplitSize) && sliderTg.equals(tgSplitSize), "Control and target group value is present as expected.", "Control and target group value is not present as expected.");
		String controlGroup = moreInfoDetails.get("Control group").trim();
		String targetGroup = moreInfoDetails.get("Target group").trim();
		writeLog(sliderCg.equals(controlGroup) && sliderTg.equals(targetGroup), "Control and target group more info and slider value is present as expected.", "Control and target group more info and slider value is not present as expected.");
	}

	public void slideCGTGValue()
	{
		WebElement slider = driver.findElement(autolocator(AudienceRepository.audience_target_cgtgslider));
		Actions action = new Actions(driver);
		action.clickAndHold(slider).moveByOffset(-60, 0).release().build().perform();
		clickElement(AudienceRepository.audience_target_cgtgSaveButton);
		threadSleep(ObjectRepository.wait1sec);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait1sec);
		pageLoaderLogo();
	}

	public void selectDownloadAttributes(String[] attributes)
	{
		clickElement(AudienceRepository.audience_target_downloadsearchicon);
		for (int count = 0; count < attributes.length; count++)
		{
			if (selectexactlistelements(DashboardRepository.allpage_common_selectdropdownlist, attributes[count]))
			{
				enterValue(AudienceRepository.audience_target_downloadSearchinput, attributes[count]);
				clickElement(AudienceRepository.audience_target_clickrightarrowicon);
				clickElement(AudienceRepository.audience_target_downloadcloseicon);
			}
		}
		String availableHelpText = findElements(AudienceRepository.audience_target_downloadhelptext).get(0).getText();
		uiPageEqualswithInputValue(availableHelpText, "Only parent attributes are available to download");
		String maxAttributeHelpText = findElements(AudienceRepository.audience_target_downloadhelptext).get(1).getText();
		uiPageEqualswithInputValue(maxAttributeHelpText, "Max. 20 data attributes");
		clickElement(AudienceRepository.audience_target_downloadButton);
	}

	public void clickAdvanceDetailsDownload()
	{
		clickElement("Download icon,css,#rs_data_download");
	}

	public List<Map<String, String>> getAdvanceDetailsTableCount()
	{
		List<Map<String, String>> webTable = getWebTable();
		return webTable;
	}

	public void targetListDownloadCsvPopup(String otpType)
	{
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_target_csvdownloadheader), 90);
		String helpText = getStrText(AudienceRepository.audience_target_csvdownloadhelptext);
		uiPageEqualswithInputValue(helpText, "One-Time Password (OTP) will be sent to the key contact's email address or mobile number. Enter OTP to process your request.");
		clickElement(AudienceRepository.audience_target_downloaddropdown);
		selectlistelements(AudienceRepository.audience_target_selectcsvdownloadOtp, otpType);
	}

	public AudiencePage_Targetlist downloadAndValidateTargetListFromWebmail(int listCount, String targetList)
	{
		List<Map<String, String>> list = new LinkedList<>();
		String userName = System.getProperty("teamKeyAcctWebmailUsername");
		javaScriptopenNewWindow();
		String pwind = parentWinHandle();
		switchWindow();
		teamWebUrlLaunch();
		teamWebmailLogin(userName, System.getProperty(userName));
		String otp = getWebmailOTPforTargetListDownload();
		teamWebmailLogout();
		if (otp != null)
		{
			switchParentWin(pwind);
			entersOTPAndSubmit(otp, "target");
			switchWindow();
			teamWebUrlLaunch();
			teamWebmailLogin(userName, System.getProperty(userName));
			String link = getWebmailTargetlistDownloadLink(targetList);
			teamWebmailLogout();
			if (link != null)
			{
				BaseTest.getWebDriver().get(link);
				String invalidAudienceDownload = getStrText(AudienceRepository.Audiencedownloadheader);
				writeLog(invalidAudienceDownload.equals("Audience - CSV download list"), "Target list audience download header is present as expected.", "Target list audience download header is not-present as expected.");
				threadSleep(200);
				pageLoaderLogo();
				threadSleep(200);
				clickElement(AudienceRepository.AudienceDownloadButton);
				pageLoaderLogo();
				ArrayList<Object> excelData = filehandle();
				String[] datas = excelData.get(1).toString().split("\\R");
				String[] headers = datas[0].split(",");
				for (int i = 1; i < datas.length; i++)
				{
					String[] data = datas[i].split(",");
					Map<String, String> map = new LinkedHashMap<>();
					for (int j = 0; j < data.length; j++)
					{
						map.put(headers[j], data[j]);
					}
					list.add(map);
				}
				String string = BaseTest.method_name.get();
				if (!string.toLowerCase().contains("sample"))
				{
					int excelCount = Integer.parseInt(excelData.get(0).toString()) - 1;
					writeLog(listCount == excelCount, "Excel audience count is present as expected", "Excel audience count is not present as expected");
				}
				BaseTest.getTest().log(Status.INFO, "<b>TARGET LIST EXCEL DATA : </b>");
				ExtentManager.customReport(list);
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Target list download mail not received");
			}
		}
		return this;
	}

	public Map<String, String> getMoreInfoDetails(String listName)
	{
		clickTargetlistfromMenu();
		clickMoreInfoIcon(listName);
		Map<String, String> map = new LinkedMap<String, String>();
		// More info list details
		String moreInfoCreatedByName = driver.findElement(autolocator(AudienceRepository.audience_target_moreinfoNameAndDate)).getText().split(",")[0].split(":")[1].trim();
		String moreInfoCreatedDateAndTime = driver.findElement(autolocator(AudienceRepository.audience_target_moreinfoNameAndDate)).getText().split(moreInfoCreatedByName + ",")[1].toLowerCase().trim();
		String moreInfoLinkedCommunication = driver.findElements(autolocator(AudienceRepository.audience_target_moreinfolinkedCommAndSegCount)).get(0).getText().split("\\(")[1].split("\\)")[0];
		String moreInfoSegCount = driver.findElements(autolocator(AudienceRepository.audience_target_moreinfolinkedCommAndSegCount)).get(1).getText().split("\\(")[1].split("\\)")[0];
		map.put("Total", moreInfoSegCount);
		map.put("Linked Communication", moreInfoLinkedCommunication);
		map.put("Created By Name", moreInfoCreatedByName);
		map.put("Created Date And Time", moreInfoCreatedDateAndTime);
		List<WebElement> channelName = findElements(AudienceRepository.audience_target_info_audiencechannelName);
		List<WebElement> channelCount = findElements(AudienceRepository.audience_target_info_audiencechannelcount);
		for (int i = 0; i < channelName.size(); i++)
		{
			map.put(channelName.get(i).getText(), channelCount.get(i).getText());
		}
		List<WebElement> cgtgNames = findElements(AudienceRepository.audience_target_info_cgtgName);
		List<WebElement> cgtgPercentage = findElements(AudienceRepository.audience_target_info_cgtgpercentage);
		for (int i = 0; i < cgtgNames.size(); i++)
		{
			map.put(cgtgNames.get(i).getText(), cgtgPercentage.get(i).getText());
		}
		clickElement(AudienceRepository.audience_Masterdata_fieldSelectorcloseicon);
		return map;
	}

	public Map<String, String> get_MDM_OverviewportletCount()
	{
		clickAudienceMasterdatafromMenu();
		Map<String, String> map = new LinkedHashMap<String, String>();
		List<WebElement> channels = findElements(AudienceRepository.audience_mdm_channelname);
		for (int i = 0; i < channels.size() - 1; i++)
		{
			String channelName = channels.get(i).getText();
			String channelCount = getStrText("Channel count,xpath,//div[@class='card-body']//div//small[.='" + channelName + "']//..//h1");
			map.put(channelName, channelCount);
		}
		if (!getStrText(AudienceRepository.audience_masterdata_overviewnotification_Infostatus).contains("0"))
		{
			clickElement(AudienceRepository.audience_masterdata_overviewnotification_Info_Icon);
			map.put("Web push", getStrText(AudienceRepository.audience_mdm_notificationwebIdentified));
			map.put("Mobile push", getStrText(AudienceRepository.audience_mdm_notificationmobileIdentified));
			clickElement(AudienceRepository.audience_Masterdata_fieldSelectorcloseicon);
		} else
		{
			map.put("Web push", "0");
			map.put("Mobile push", "0");
		}
		return map;
	}

	public void validateMoreInfoCount(Map<String, String> mdmDetails, Map<String, String> moreInfoDetails)
	{
		for (Entry<String, String> mdmDetail : mdmDetails.entrySet())
		{
			for (Entry<String, String> moreInfoDetail : moreInfoDetails.entrySet())
			{
				if (mdmDetail.getKey().equals(moreInfoDetail.getKey()))
				{
					String mdmValue = mdmDetail.getValue();
					String moreInfoValue = moreInfoDetail.getValue();
					if (mdmValue.equals(moreInfoValue))
					{
						BaseTest.getTest().log(Status.INFO, "MDM Details value <b>" + mdmDetail.getKey() + "=" + mdmValue + "</b> is present as expected More Info Details value <b>" + moreInfoDetail.getKey() + "=" + moreInfoValue + "</b>");
					} else
					{
						BaseTest.getTest().log(Status.FAIL, "MDM Details value <b>" + mdmDetail.getKey() + "=" + mdmValue + "</b> is not-present as expected More Info Details value  <b>" + moreInfoDetail.getKey() + "=" + moreInfoValue + "</b>");
					}
				}
			}
		}
	}

	public List<Map<String, String>> validateGridView()
	{
		selectCustomRange(-5, 0);
		int page = 1;
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		while (true)
		{
			List<WebElement> listNames = findElements(AudienceRepository.audience_gridview_listName);
			for (int count = 0; count < listNames.size(); count++)
			{
				Map<String, String> map = new LinkedHashMap<>();
				listNames = findElements(AudienceRepository.audience_gridview_listName);
				String listName = listNames.get(count).getText();
				if (listName.contains("..."))
				{
					mouseHover(listNames.get(count));
					listName = getStrText(DashboardRepository.allpage_tooltip);
				}
				map.put("List name", listName);
				map.put("Created on", findElements(AudienceRepository.audience_gridview_createdon).get(count).getText().replaceAll("On:", "").trim());
				map.put("Created by", findElements(AudienceRepository.audience_gridview_createdby).get(count).getText().replaceAll(",", "").trim());
				String segName = findElements(AudienceRepository.audience_gridview_segmentationaudience).get(count).getText().trim();
				map.put("Seg. audience", !segName.contains("Calculating") && !segName.contains("List extraction is in progress") ? segName.split(":")[1].trim() : "0");
				map.put("Commu. sent", listName.equals("All audience") ? "0" : findElements(AudienceRepository.audience_gridview_communicationexecuted).get(page == 1 ? count - 1 : count).getText());
				map.put("Average/Projected reach rate", findElements(AudienceRepository.audience_gridview_AverageAndProjectedReachRate).get(count).getText());
				list.add(map);
			}
			threadSleep(ObjectRepository.wait1sec);
			javaScriptScrollDown();
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
					javaScriptScrollDown();
					BaseTest.getTest().log(Status.INFO, "Page No : " + page);
					driver.findElement(autolocator(AudienceRepository.audience_synchist_nextButton)).click();
					pageLoaderLogo();
					page++;
				}
			}
		}
		ExtentManager.customReport(list);
		System.out.println(list);
		return list;
	}

	public List<Map<String, String>> validateTrgtGridView()
	{
		selectCustomRange(-1, 0);
		int page = 1;
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		while (true)
		{
			List<WebElement> listNames = findElements(AudienceRepository.audience_gridview_listName);
			for (int count = 0; count < listNames.size(); count++)
			{
				Map<String, String> map = new TreeMap<>();
				listNames = findElements(AudienceRepository.audience_gridview_listName);
				String listName = listNames.get(count).getText();
				if (listName.contains("..."))
				{
					mouseHover(listNames.get(count));
					listName = getStrText(DashboardRepository.allpage_tooltip);
				}
				map.put("List name", listName);
				javaScriptScrollToSomeExtend("60");
				map.put("Created on", !isElementPresent(AudienceRepository.audience_gridview_allaudiencecreatedOn) ? "" : findElements(AudienceRepository.audience_gridview_createdon).get(count - 1).getText().replaceAll("On:", "").trim());
				map.put("Created by", findElements(AudienceRepository.audience_gridview_createdby).get(count).getText().replaceAll(",", "").trim());
				String segName = findElements(AudienceRepository.audience_gridview_segmentationaudience).get(count).getText().trim();
				map.put("Seg. audience", !segName.contains("Calculating") && !segName.contains("List extraction is in progress") ? segName.split(":")[1].trim() : "0");
				map.put("Commu. sent", listName.equals("All audience") ? "0" : findElements(AudienceRepository.audience_gridview_communicationexecuted).get(page == 1 ? count - 1 : count).getText().replaceAll("[^0-9]", ""));
				map.put("Average/Projected reach rate", findElements(AudienceRepository.audience_gridview_AverageAndProjectedReachRate).get(count).getText());
				list.add(map);
			}
			threadSleep(300);
			javaScriptScrollDown();
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
					javaScriptScrollDown();
					BaseTest.getTest().log(Status.INFO, "Page No : " + page);
					driver.findElement(autolocator(AudienceRepository.audience_synchist_nextButton)).click();
					pageLoaderLogo();
					page++;
				}
			}
		}
		ExtentManager.customReport(list);
		System.out.println(list);
		return list;
	}

	public void clickTargetListingListView()
	{
		toolTipValidationKnownText(AudienceRepository.audience_listview_listIcon, "List view");
		clickElement(AudienceRepository.audience_listview_listIcon);
		pageLoaderLogo();
	}

	public List<Map<String, String>> validateListView()
	{
		clickTargetListingListView();
		selectCustomRange(-1, 0);
		int page = 1;
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		while (true)
		{
			List<Map<String, String>> tableData = targetListingTable();
			list.addAll(tableData);
			threadSleep(ObjectRepository.wait1sec);
			javaScriptScrollDown();
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
					javaScriptScrollDown();
					BaseTest.getTest().log(Status.INFO, "Page No : " + page);
					driver.findElement(autolocator(AudienceRepository.audience_synchist_nextButton)).click();
					pageLoaderLogo();
					page++;
				}
			}
		}
		ExtentManager.customReport(list);
		System.out.println(list);
		return list;
	}

	public List<Map<String, String>> targetListingTable()
	{
		List<Map<String, String>> list = new LinkedList<>();
		WebElement table = findElement("Table Loc,tag,table");
		List<WebElement> headers = table.findElements(By.tagName("th"));
		List<WebElement> rows = table.findElements(By.xpath("//tbody//tr"));

		for (int j = 0; j < rows.size(); j++)
		{
			headers = table.findElements(By.tagName("th"));
			rows = table.findElements(By.xpath("//tbody//tr"));
			Map<String, String> map = new TreeMap<>();
			List<WebElement> datas = rows.get(j).findElements(By.tagName("td"));

			int headerSize = headers.size();
			int dataSize = datas.size();
			int missingDataCount = headerSize - dataSize;

			for (int i = 0; i < headerSize; i++)
			{
				datas = rows.get(j).findElements(By.tagName("td"));
				String head = headers.get(i).getText();
				if (i < missingDataCount)
				{
					map.put(head, "");
				} else
				{
					String dataValue = datas.get(i - missingDataCount).getText();
					if (dataValue.contains("...") && head.equals("List name"))
					{
						mouseHover(datas.get(i - missingDataCount));
						dataValue = getStrText(DashboardRepository.allpage_tooltip);
					}
					map.put(head, dataValue);
				}
			}
			list.add(map);
		}
//		BaseTest.getTest().log(Status.INFO, list.toString());
		ExtentManager.customReport(list);
		return list;

	}

	public String pw_enterTargetListName()
	{
		String trgtlistname = "trgt" + addTimeToName().replaceAll("_", "");
		pw_clickElement(AudienceRepository.pw_createtargetlistIcon);
		page.getByPlaceholder(" ", new Page.GetByPlaceholderOptions().setExact(true)).click();
		page.getByPlaceholder(" ", new Page.GetByPlaceholderOptions().setExact(true)).fill(trgtlistname);
		page.getByPlaceholder(" ", new Page.GetByPlaceholderOptions().setExact(true)).press("Tab");
		page.waitForSelector("#ju1xiqt-aria+rect", new Page.WaitForSelectorOptions().setState(WaitForSelectorState.HIDDEN));
		return trgtlistname;
	}

	public boolean pw_targetListAttributeSearch(String attribute)
	{
		pw_clickElement(AudienceRepository.pw_targetlistcreationSearch);
		pw_enterValue(AudienceRepository.pw_targetlistsearchattributetextbox, attribute);
		pw_clickElement(AudienceRepository.pw_targetlistcreationSearch);
		try
		{
			page.click("xpath=//ul[@class='searchList ']//li[text()='" + attribute + "']//span");
			BaseTest.getTest().log(Status.INFO, "Cliked ---> " + attribute);
			return true;
		} catch (Exception e)
		{
			return false;
		}
	}

	public void pw_selectAttributeConditionAndValue(String attribute, String condition, String attributeValue)
	{
		condition = condition.replace("\u200B", "").replaceAll("\\s+", " ").trim();
		pw_SelectMultipleListElements(replacePlaceHolder(AudienceRepository.pw_targetListAttributeCondition, attribute), condition);
		// ---> Target list dropdown date related items
		if (pw_isElementPresent(replacePlaceHolder(AudienceRepository.pw_targetListAttributeValueDateIcon, attribute)))
		{
			if (!condition.equals("Has no value") && !condition.equals("Has value"))
			{
				pw_clickElement(replacePlaceHolder(AudienceRepository.pw_entertargetlistattributevalue, attribute));
				pw_SelectAttributeDate(attributeValue);
			}
			pw_clickElement(replacePlaceHolder(AudienceRepository.pw_clickSegmentationArrowIcon, attribute));
		} // ---> Target list dropdown related items
		else if (pw_findelements(replacePlaceHolder(AudienceRepository.pw_selecttargetlistattributevalue, attribute)).count() > 0)
		{
//			pw_clickElement(replacePlaceHolder(AudienceRepository.pw_entertargetlistattributevalue, attribute));
//			pw_enterValue(replacePlaceHolder(AudienceRepository.pw_entertargetlistattributevalue, attribute), attributeValue);
			pw_SelectMultipleListElements(replacePlaceHolder(AudienceRepository.pw_selecttargetlistattributevalue, attribute), attributeValue);
			pw_clickElement(replacePlaceHolder(AudienceRepository.pw_clickSegmentationArrowIcon, attribute));
			pw_pageLoaderLogo();
			threadSleep(500);
			String uiCondition = pw_getStrText(replacePlaceHolder(AudienceRepository.pw_targetListAttributeCondition, attribute)).replace("\u200B", "").replaceAll("\\s+", " ").trim();;
			pw_writeLog(uiCondition.equals(condition), "Condition is present as expected", "Condition is not present as expected");
			String uiAttributeValue = pw_getStrText(replacePlaceHolder(AudienceRepository.pw_targetListdropdownattributeValue, attribute));
			pw_writeLog(uiAttributeValue.equals(attributeValue), "Attribute value is present as expected", "Attribute value is not present as expected");
		} // ---> Target list Input text related items
		else if (pw_findelements(replacePlaceHolder(AudienceRepository.pw_entertargetlistattributevalue, attribute)).count() > 0)
		{
			pw_clickElement(replacePlaceHolder(AudienceRepository.pw_entertargetlistattributevalue, attribute));
			pw_enterValue(replacePlaceHolder(AudienceRepository.pw_entertargetlistattributevalue, attribute), attributeValue);
			pw_clickElement(replacePlaceHolder(AudienceRepository.pw_clickSegmentationArrowIcon, attribute));
			pw_pageLoaderLogo();
			String uiCondition = pw_getStrText(replacePlaceHolder(AudienceRepository.pw_targetListAttributeCondition, attribute));
			pw_writeLog(uiCondition.equals(condition), "Condition is present as expected", "Condition is not present as expected");
			String uiAttributeValue = pw_getTextBoxVal(replacePlaceHolder(AudienceRepository.pw_entertargetlistattributevalue, attribute), "value");
			pw_writeLog(uiAttributeValue.equals(attributeValue), "Attribute value is present as expected", "Attribute value is not present as expected");
		} // ---> Target list has value & not has value related items
		else if (pw_findelements(replacePlaceHolder(AudienceRepository.pw_entertargetlistattributevalue, attribute)).count() > 0)
		{
			pw_clickElement(replacePlaceHolder(AudienceRepository.pw_entertargetlistattributevalue, attribute));
			pw_clickElement(replacePlaceHolder(AudienceRepository.pw_clickSegmentationArrowIcon, attribute));
			pw_pageLoaderLogo();
			String uiCondition = pw_getStrText(replacePlaceHolder(AudienceRepository.pw_targetListAttributeCondition, attribute));
			pw_writeLog(uiCondition.equals(condition), "Condition is present as expected", "Condition is not present as expected");
		}
		pw_pageLoaderLogo();
	}

	public void pw_SaveTargetList()
	{
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create")).click();
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
	}

	public void pw_SearchAndValidateTargetList(String trgtlistname)
	{
		page.locator("#rs_RSAdvanceSearch_zoom").click();
		page.getByPlaceholder("By list name").click();
		page.getByPlaceholder("By list name").fill(trgtlistname);
		page.locator("li").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^" + trgtlistname + "$"))).click();
		page.locator("#rs_data_zoom").click();
		String listname = page.textContent("(//div[@class='rci-list-name']//span)[2]");
		uiPageEqualswithInputValue(trgtlistname, listname);
	}

	public void pw_SelectAttributeDate(String date)
	{
		String[] format = date.split(" ");
		String fullMonthText = format[0];
		String shortMonth = fullMonthText.substring(0, 3);
		String day = format[1];
		String year = format[2];
		String yearMonth = year + " " + shortMonth;
		String MonthDayYear = fullMonthText + " " + day + ", " + year;
		pw_clickElement(AudienceRepository.pw_targetlistattributedropdowncalenderView);
		pw_clickElement(replacePlaceHolder(AudienceRepository.pw_targetlistattributedropdownyearselect, year));
		Locator element = page.locator("//div[contains(@class,'calendar-yearview')]//div[@class='k-content k-scrollable']");
		threadSleep(ObjectRepository.wait2sec);
		element.evaluate("el => el.scrollBy(0, -33)");
//		document.querySelector('.k-content.k-scrollable').scrollBy(0,-10)
		pw_clickElement(replacePlaceHolder(AudienceRepository.pw_targetlistattributedropdownmonthselect, yearMonth));
		pw_clickElement(replacePlaceHolder(AudienceRepository.pw_targetlistattributedroddowndayselect, MonthDayYear));
	}

	public void pw_inclusionGroupDelete()
	{
		pw_clickElement(AudienceRepository.pw_targetlistinclusiongroupdelete);
		pw_clickElement(AudienceRepository.pw_inclusionpopup_okbutton);
	}

	public void pw_exclusionGroupDelete()
	{
		pw_clickElement(AudienceRepository.pw_targetlistexclusiongroupdelete);
		pw_clickElement(AudienceRepository.pw_exclusionpopup_okbutton);
	}

	public void pw_addInclusionGroupTwo()
	{
		pw_clickElement(AudienceRepository.pw_clickInclusionAndExclusionAddIcon);
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Inclusion")).click();
	}

	public void pw_addExclusionGroup()
	{
		pw_clickElement(AudienceRepository.pw_clickInclusionAndExclusionAddIcon);
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Exclusion")).click();
	}

	public void pw_checkEachConditionValue(String attribute, String conditions, String values)
	{
		String[] condition = conditions.split(",");
		String[] value = values.split(",");
		if (condition.length == value.length)
		{
			for (int i = 0; i < condition.length; i++)
			{
				pw_selectAttributeConditionAndValue(attribute, condition[i], value[i]);
				if (pw_findelements(AudienceRepository.pw_filterattributeremove).count() > 0)
				{
					pw_clickElement(AudienceRepository.pw_filterattributeremove);
				} else if (pw_isElementPresent(replacePlaceHolder(AudienceRepository.pw_entertargetlistattributevalue, attribute)))
				{
					pw_enterValue(replacePlaceHolder(AudienceRepository.pw_entertargetlistattributevalue, attribute), "");
				}
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Condition length and attribute value length is mismatch. Please provide the condition and attribute length equally");
			BaseTest.pw_takesScreenshot();
		}
	}

	public int getcommunicationcount(String targetList)
	{

		String communication_Execution_Count = getStrText("Communication Execution Count,xpath,(//span[.='" + targetList + "']//ancestor::div[contains(@class,'rs-card-bottom')]//div[@class='rci-text']//span)[1]");
		communication_Execution_Count = communication_Execution_Count.replaceAll("[^0-9]", "");
		int count = Integer.parseInt(communication_Execution_Count);
		return count;
	}

	public void inforeach(int i, String targetList)
	{
		clickElement(replacePlaceHolder(AudienceRepository.audience_target_moreinfo, targetList));
		threadSleep(ObjectRepository.wait1sec);
		isDisplayed(AudienceRepository.audience_target_moreinfopopup);
		String communicationLinked = getStrText(AudienceRepository.audience_target_moreinfolinkedcommunication);
		int communicationLinkedCount = Integer.parseInt(communicationLinked.replaceAll("[^0-9]", ""));
		if (communicationLinkedCount == i)
		{
			BaseTest.getTest().info("Communication Linked Count is displayed as expected" + communicationLinked);
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().info("Communication Linked Count is not displayed as expected" + communicationLinked);
			BaseTest.takeScreenshot();
		}
		clickElement(AudienceRepository.audience_target_closeMoreInfo);
	}

	public void getcommunicationreahrate(int communicationexecuted, int i, String targetList)
	{
		inforeach(i, targetList);
		if (communicationexecuted == i)
		{
			if (communicationexecuted != 0 && communicationexecuted <= 5)
			{

				String reacgrateststus = getStrText(replacePlaceHolder(AudienceRepository.audience_target_reachratestatus, targetList));
				if (reacgrateststus.contains("Projected"))
				{
					BaseTest.getTest().info("Reach Rate status is displayed as expexted " + reacgrateststus);
					String reachratepercentage = getStrText(replacePlaceHolder(AudienceRepository.audience_target_reachratepercentage, targetList));
					if (Integer.parseInt(reachratepercentage) >= 0 && Integer.parseInt(reachratepercentage) <= 100)
					{
						BaseTest.getTest().info("Reach Rate is displayed as expexted " + reachratepercentage);
						BaseTest.takeScreenshot();
					} else
					{
						BaseTest.getTest().fail("Reach Rate is not displayed as expexted " + reachratepercentage);
						BaseTest.takeScreenshot();
					}
				}
			} else if (communicationexecuted > 5)
			{
				String reacgrateststus = getStrText(replacePlaceHolder(AudienceRepository.audience_target_reachratestatus, targetList));
				if (reacgrateststus.contains("Average"))
				{
					BaseTest.getTest().info("Reach Rate status is displayed as expexted " + reacgrateststus);
					String reachratepercentage = getStrText(replacePlaceHolder(AudienceRepository.audience_target_reachratepercentage, targetList));
					if (Integer.parseInt(reachratepercentage) >= 0 && Integer.parseInt(reachratepercentage) <= 100)
					{
						BaseTest.getTest().info("Reach Rate is displayed as expexted " + reachratepercentage);
						BaseTest.takeScreenshot();
					} else
					{
						BaseTest.getTest().fail("Reach Rate is not displayed as expexted " + reachratepercentage);
						BaseTest.takeScreenshot();
					}
				}

			}
		} else
		{
			BaseTest.getTest().fail("Communication Executed is not displayed as expected-" + "expected " + i + "Actual " + communicationexecuted);
			BaseTest.takeScreenshot();
		}
	}

	public void getListDetailes(Map<String, String> searchTargetList)
	{
		createdby = searchTargetList.get("Created by");
		String listName = shortListName == null ? BaseTest.getData().TargetListNew : shortListName;
		String rfaLoc = replacePlaceHolder(AudienceRepository.audience_target_listrfastatus, listName);
		mouseHover(rfaLoc);
		status = getStrText(DashboardRepository.allpage_tooltip);

	}

	public void negativeadvancedsearch()
	{
		explicitwaitforclick(autolocator(AudienceRepository.audience_target_searchIcon), 30);
		threadSleep(ObjectRepository.wait2sec);
		clickElement(AudienceRepository.audience_target_searchIcon);
		explicitwaitforclick(autolocator(AudienceRepository.audience_target_searchExpandIcon), 30);
		clickElement(AudienceRepository.audience_target_searchExpandIcon);
		explicitwaitforclick(autolocator(AudienceRepository.audience_target_advancedSearchdropdown), 30);
		clickElement(AudienceRepository.audience_target_advancedSearchlistname);
		enterValue(AudienceRepository.audience_target_advancedSearchlistname, BaseTest.getData().TargetListNew);
		pageLoaderLogo();
		selectlistelementsAndProceed(AudienceRepository.audience_target_advancesearchdropdown, BaseTest.getData().TargetListNew);
		enterValue(AudienceRepository.audience_target_advancedSearchcratedby, createdby);
		pageLoaderLogo();
		selectlistelementsAndProceed(AudienceRepository.audience_target_advancesearchdropdown, createdby);
		clickElement(AudienceRepository.audience_target_advancedSearchlisttype);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "All list");
		String statusvalue = null;
		if (status.contains("approved"))
		{
			statusvalue = "Pending";
		} else if (status.contains("pending"))
		{
			statusvalue = "approved";
		} else if (status.contains("rejected"))
		{
			statusvalue = "approved";
		}
		clickElement(AudienceRepository.audience_target_advancedSearchapprovalstatue);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, statusvalue);
		clickElement("search,xpath,//button[@type='submit']");
		pageLoaderLogo();
		if (isDisplayed("No Data,xpath,//p[text()='No records to display']"))
		{
			BaseTest.getTest().info("Advanced Search Functionality is working as expected");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().fail("Advanced Search Functionality not is working as expected");
			BaseTest.takeScreenshot();
		}

	}

	public void advancedsearch()
	{
		String rfaLoc = replacePlaceHolder(AudienceRepository.audience_target_listrfastatus, BaseTest.getData().TargetListNew);
		explicitwaitforclick(autolocator(AudienceRepository.audience_target_searchIcon), 30);
		threadSleep(ObjectRepository.wait2sec);
		clickElement(AudienceRepository.audience_target_searchIcon);
		explicitwaitforclick(autolocator(AudienceRepository.audience_target_searchExpandIcon), 30);
		clickElement(AudienceRepository.audience_target_searchExpandIcon);
		explicitwaitforclick(autolocator(AudienceRepository.audience_target_advancedSearchdropdown), 30);
		clickElement(AudienceRepository.audience_target_advancedSearchlistname);
		enterValue(AudienceRepository.audience_target_advancedSearchlistname, BaseTest.getData().TargetListNew);
		pageLoaderLogo();
		selectlistelementsAndProceed(AudienceRepository.audience_target_advancesearchdropdown, BaseTest.getData().TargetListNew);
		enterValue(AudienceRepository.audience_target_advancedSearchcratedby, createdby);
		pageLoaderLogo();
		selectlistelementsAndProceed(AudienceRepository.audience_target_advancesearchdropdown, createdby);
		clickElement(AudienceRepository.audience_target_advancedSearchlisttype);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "All list");
		String statusvalue = null;
		if (status.contains("approved"))
		{
			statusvalue = "Approved";
		} else if (status.contains("pending"))
		{
			statusvalue = "Pending";
		} else if (status.contains("rejected"))
		{
			statusvalue = "Rejected";
		}
		clickElement(AudienceRepository.audience_target_advancedSearchapprovalstatue);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, statusvalue);
		clickElement(AudienceRepository.audience_target_submiticon);
		pageLoaderLogo();
		String listName = "";
		if (shortListName == null)
		{
			listName = getStrText(AudienceRepository.audience_target_listName);
		} else
		{
			mouseHover(AudienceRepository.audience_target_listName);
			listName = getStrText(DashboardRepository.allpage_tooltip);
		}
		if (BaseTest.getData().TargetListNew.equals(listName))
		{
			BaseTest.getTest().info("Advanced Search Functionality is working as expected");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().fail("Advanced Search Functionality not is working as expected");
			BaseTest.takeScreenshot();
		}

	}

}
