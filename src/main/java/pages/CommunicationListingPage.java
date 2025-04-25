package pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.microsoft.playwright.Page;

import repository.AnalyticsRepository;
import repository.AudienceRepository;
import repository.CommunicationRepository;
import repository.DashboardRepository;
import repository.ObjectRepository;
import utility.BaseTest;
import utility.PageFactory;

public class CommunicationListingPage extends HomePage
{
	public String communicationListingPageStatus, communicationListingPage;
	HashMap<String, String> analyticsListingChannelResults = null;
	HashMap<String, String> commListingPageContentItems = new HashMap<String, String>();
	HashMap<String, String> galleryListingPageChannelItems = new HashMap<String, String>();

	// Listing Page
	List<Map<String, String>> communicationAnalyticsListingCount = new ArrayList<Map<String, String>>();
	public Map<String, String> emailChannelCommunicationAnalyticsListingPageCount = new HashMap<String, String>();
	public Map<String, String> smsChannelCommunicationAnalyticsListingPageCount = new HashMap<String, String>();
	public Map<String, String> qrChannelCommunicationAnalyticsListingPageCount = new HashMap<String, String>();
	public Map<String, String> webChannelCommunicationAnalyticsListingPageCount = new HashMap<String, String>();
	public Map<String, String> mobileChannelCommunicationAnalyticsListingPageCount = new HashMap<String, String>();
	public Map<String, String> whatsappChannelCommunicationAnalyticsListingPageCount = new HashMap<String, String>();
	public Map<String, String> vmsChannelCommunicationAnalyticsListingPageCount = new HashMap<String, String>();
	public Map<String, String> communicationtype = new HashMap<String, String>();
	public Map<String, String> deliverymethods = new HashMap<String, String>();
	public Map<String, String> totalAudience = new HashMap<String, String>();

	// OverView page
	List<Map<String, String>> analyticsOverviewChannelsCount = new ArrayList<Map<String, String>>();
	Map<String, String> emailAnalyticsOverviewPageCountMap = new HashMap<String, String>();
	Map<String, String> smsChannelCommunicationAnalyticsOverviewPageCount = new HashMap<String, String>();
	Map<String, String> qrChannelCommunicationAnalyticsOverviewPageCount = new HashMap<String, String>();
	Map<String, String> webChannelCommunicationAnalyticsOverviewPageCount = new HashMap<String, String>();
	Map<String, String> mobileChannelCommunicationAnalyticsOverviewPageCount = new HashMap<String, String>();

	public List<String> emailChannelCommunicationListingPageCount = new ArrayList<>();
	public List<String> smsChannelCommunicationListingPageCount = new ArrayList<>();
	public List<String> qrChannelCommunicationListingPageCount = new ArrayList<>();
	public List<String> webChannelCommunicationListingPageCount = new ArrayList<>();
	public List<String> mobileChannelCommunicationListingPageCount = new ArrayList<>();
	public List<String> whatsappChannelCommunicationListingPageCount = new ArrayList<>();
	public List<String> vmsChannelCommunicationListingPageCount = new ArrayList<>();

	public CommunicationListingPage(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	public boolean searchCommunication(String listingpage, String commName)
	{
		threadSleep(ObjectRepository.wait5sec);
		boolean searchresult = false;
		for (int i = 0; i <= 2; i++)
		{
			javaScriptScrolltoTop();
			try
			{
//				explicitwaitforclick(autolocator(CommunicationRepository.CommunicationListing_SearchIconClick), 30);
				clickElement(CommunicationRepository.CommunicationListing_SearchIconClick);
				threadSleep(ObjectRepository.wait2sec);
				break;
			} catch (Throwable e)
			{
				threadSleep(ObjectRepository.wait5sec);
			}
		}
		enterValue(CommunicationRepository.CommunicationListing_SearchCommunication, commName);
		threadSleep(ObjectRepository.wait5sec);
		pageLoaderLogo();
		selectlistelements(AudienceRepository.audience_dynamic_listnamedropdown, commName);
		threadSleep(ObjectRepository.wait1sec);
		clickElement(AudienceRepository.audience_dynamic_afterentervaluesearch);
		threadSleep(ObjectRepository.wait5sec);
		try
		{
			int commCountIdentify = commCountIdentify(commName);
//			mouseHover(",xpath,(//p[@class='pt5'])[" + commCountIdentify + "]//div");
//			String toolTipText = getStrText(DashboardRepository.allpage_tooltip);
			 CommunicationNamE = commName.trim();
			communicationListingPage = getStrText("Status,xpath,//p[.='" + CommunicationNamE + "']");
			if (communicationListingPage.equalsIgnoreCase(CommunicationNamE))
			{
				BaseTest.getTest().log(Status.INFO, "Created communication is available in listing page.");
				BaseTest.takeScreenshot();
				searchresult = true;

				communicationListingPageStatus = getStrText("Status,xpath,//p[.='" + CommunicationNamE +"']//ancestor::td//preceding-sibling::div[contains(@class,'communication-content')]//div[contains(@class,'status')]//small");
			} else
			{
				BaseTest.getTest().log(Status.WARNING, "Created communication is not available in listing page");
				BaseTest.takeScreenshot();
			}
		} catch (Exception e)
		{
			BaseTest.getTest().log(Status.WARNING, "Created communication is not available in listing page");
			BaseTest.takeScreenshot();
		}

		return searchresult;
	}

	public String shortCommSearch(String locator)
	{
		int count = getStrText(locator).length();
		if (count <= 41)
		{
			mouseHover(locator);
			return getStrText(DashboardRepository.allpage_tooltip);
		}
		return "";
	}

	public void searchCommunicationWithOutMouseHover(String commName)
	{
		clickElement(CommunicationRepository.CommunicationListing_SearchIconClick);
		threadSleep(ObjectRepository.wait1sec);
		enterValue(CommunicationRepository.CommunicationListing_SearchCommunication, commName);
		threadSleep(ObjectRepository.wait5sec);
		pageLoaderLogo();
		selectlistelements(AudienceRepository.audience_dynamic_listnamedropdown, commName);
		threadSleep(ObjectRepository.wait1sec);
		clickElement(AudienceRepository.audience_dynamic_afterentervaluesearch);
		threadSleep(ObjectRepository.wait5sec);
	}

	public boolean communicationlistingPageStatusCompare(String expected)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("COMMUNICATION LISTING PAGE ", ExtentColor.BLUE));
		boolean val = false;
		for (int i = 0; i < 5; i++)
		{
			if (searchCommunication("communicationlisting", communicationName))
			{
				if (communicationListingPageStatus.toLowerCase().contains(expected.toLowerCase()))
				{
					BaseTest.getTest().log(Status.INFO, "communication listing page status as expected : " + communicationListingPageStatus);
					val = true;
					break;
				} else if (i == 4)
				{
					BaseTest.getTest().log(Status.WARNING, "communication listing page status is not as expected : " + communicationListingPageStatus);
					val = true;
				} else
				{
					driver.navigate().refresh();
					pageLoaderLogo();
					threadSleep(ObjectRepository.wait5sec);
				}
			} else
			{
				BaseTest.getTest().log(Status.WARNING, "Created communication is not present");
				BaseTest.takeScreenshot();
			}
		}
		return val;
	}

	public CommunicationListingPage CommunicationAdvanceSearch(String Channel)
	{

		clickElement(CommunicationRepository.CommunicationListing_SearchIconClick);
		threadSleep(ObjectRepository.wait1sec);
		clickElement(CommunicationRepository.CommunicationListing_AdvanceSearchExpandIconClick);
		enterValue(CommunicationRepository.CommunicationListing_AdvanceSearchCommunicationnameTF, communicationName);
		threadSleep(ObjectRepository.wait1sec);
		pageLoaderLogo();
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, communicationName);
		clickElement(CommunicationRepository.CommunicationListing_AdvanceSearchCommunicatiotype);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().CommunicationType);
		clickElement(CommunicationRepository.CommunicationListing_AdvanceSearchProducttype);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().ProductType);
		clickElement(CommunicationRepository.CommunicationListing_AdvanceSearchChanneltype);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, Channel);
		clickElement(CommunicationRepository.CommunicationListing_AdvanceSearchSubmit);
		pageLoaderLogo();
		BaseTest.takeScreenshot();

		try
		{
			String replacePlaceHolder = replacePlaceHolder(",xpath,(//p[@class='pt5'])['PLACE_HOLDER']", communicationName);
			int count = getStrText(replacePlaceHolder).length();
			String communame = getStrText(replacePlaceHolder);
			String toolTipText = null;
			if (count >= 41)
			{
				mouseHover(replacePlaceHolder);
				toolTipText = getStrText(DashboardRepository.allpage_tooltip);

				if (toolTipText.equalsIgnoreCase(communicationName))
				{
					BaseTest.getTest().log(Status.INFO, "Created communication is available in listing page.");
					BaseTest.takeScreenshot();

					communicationListingPageStatus = getStrText("Status,xpath,//div[contains(@class,'communication-content')]//div[contains(@class,'status')]//small");
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Created communication is not available in listing page");
					BaseTest.takeScreenshot();
				}
			} else if (communame.equalsIgnoreCase(communicationName))
			{
				BaseTest.getTest().log(Status.INFO, "Created communication is available in listing page.");
				BaseTest.takeScreenshot();
				communicationListingPageStatus = getStrText("Status,xpath,//div[contains(@class,'communication-content')]//div[contains(@class,'status')]//small");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Created communication is not available in listing page");
				BaseTest.takeScreenshot();
			}
		} catch (Exception e)
		{
			BaseTest.getTest().log(Status.FAIL, "Created communication is not available in listing page");
			BaseTest.takeScreenshot();
		}
		editcomm();
		editsave();
		searchCommunication(communicationListingPageStatus, communicationName);
		// CSRanalyticsPage();
		duplicatecomm();
		deleteCommunicationAndValidate(communicationName + "_copy1");
		return this;
	}

	public CommunicationListingPage editsave()
	{
		explicitwaitforclick(autolocator("edit save,id,rs_DeliveryMethod_Save"), 30);
		javaScriptScrollDown();
		clickElement("edit save,id,rs_DeliveryMethod_Save");
		pageLoaderLogo();
		return this;
	}

	public CommunicationListingPage duplicatecomm()
	{
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforclick(autolocator(CommunicationRepository.CommunicationListing_arrowdown), 50);
		clickElement(CommunicationRepository.CommunicationListing_arrowdown);
		clickElement(CommunicationRepository.CommunicationListing_Duplicate);
		pageLoaderLogo();
		BaseTest.takeScreenshot();
		return this;
	}

	public CommunicationListingPage CSRanalyticsPage()
	{
		explicitwaitforclick(autolocator(replacePlaceHolder(CommunicationRepository.CommunicationListing_CSRanalyticsicon, "MpImportReg_11_22_1721_656")), 30);
		clickElement(replacePlaceHolder(CommunicationRepository.CommunicationListing_CSRanalyticsicon, "MpImportReg_11_22_1721_656"));
		pageLoaderLogo();
		return this;
	}

	// Edit Communication icon GENERIC (for all Communications)
	public CommunicationListingPage editcomm()
	{
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforclick(autolocator(replacePlaceHolder(CommunicationRepository.communicationListing_editcommRFA, CommunicationNamE)), 30);
		clickElement(replacePlaceHolder(CommunicationRepository.communicationListing_editcommRFA, CommunicationNamE));
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_commcreation_title), 30);
		pageLoaderLogo();
		if (!isDisplayed(CommunicationRepository.communicationpage_commcreation_title))
		{
			BaseTest.getTest().log(Status.FAIL, "Communication plan page failed in edit mode");
			BaseTest.takeScreenshot();
		}
		return this;
	}

	// Delete Communication
	public CommunicationListingPage deleteCommunicationAndValidate(String communicationName)
	{
		if (isElementPresent(CommunicationRepository.CommunicationListing_deletecomm))
		{
			explicitwaitforclick(autolocator(CommunicationRepository.CommunicationListing_deletecomm), 30);
			clickElement(CommunicationRepository.CommunicationListing_deletecomm);
			threadSleep(ObjectRepository.wait3sec);
			explicitwaitforclick(autolocator(CommunicationRepository.CommunicationListing_confirmcommdelete), 30);
			clickElement(CommunicationRepository.CommunicationListing_confirmcommdelete);
			threadSleep(ObjectRepository.wait20sec);
			if (!searchCommunication("communicationlisting", communicationName))
			{
				BaseTest.getTest().log(Status.INFO, "Deleted successfully");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, communicationName + "delete failed");
				BaseTest.takeScreenshot();
			}
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Archive icon is not present");
		}
		return this;
	}

	// split progress popup
	public CommunicationListingPage splitProgressPopupValidate()
	{
		pageLoaderLogo();
		clickElement(CommunicationRepository.CommunicationListing_detailslistingplusicon);
		String detailrow = getTextBoxVal(CommunicationRepository.CommunicationListing_detailslistingstatus, "title");
		if (detailrow.equalsIgnoreCase("Scheduled") || detailrow.equalsIgnoreCase("in progress") || detailrow.equalsIgnoreCase("completed"))
		{
			String communicationName = getTextBoxVal(CommunicationRepository.CommunicationListing_splitcommunicationname, "title");
			BaseTest.getTest().info("The selected split communication name is : " + communicationName);
			String communicationStatus = getStrText(CommunicationRepository.CommunicationListing_splitcommunicationstatus);
			BaseTest.getTest().info("The selected listing page split communication status is : " + communicationStatus);
			//
			String channelType = getTextBoxVal(CommunicationRepository.CommunicationListing_splitchanneltype, "title");
			BaseTest.getTest().info("The listing page split communication channel type is : " + channelType);
			String channelStatus = getTextBoxVal(CommunicationRepository.CommunicationListing_splitchannelstatus, "title");
			BaseTest.getTest().info("The selected listing page split communication status is : " + channelStatus);
			clickElement(CommunicationRepository.CommunicationListing_splitlistingprogressicon);
			threadSleep(ObjectRepository.wait10sec);
			BaseTest.takeScreenshot();
		}
		return this;
	}

	private HashMap<String, Integer> getSplitValues(String objRepo)
	{
		HashMap<String, Integer> splitProgressValues = new HashMap<String, Integer>();
		List<WebElement> splitValues = findElements(objRepo);
		for (WebElement splitvalues : splitValues)
		{
			String key = splitvalues.findElement(By.tagName("h3")).getText();
			String splitNumbervalue = splitvalues.findElement(By.xpath("//div[@class='pie_progress__number']")).getText().trim().replace("%", "");
			int value = Integer.parseInt(splitNumbervalue);
			splitProgressValues.put(key, value);
		}
		return splitProgressValues;
	}

	// Vijay
	public CommunicationListingPage allPageFooterValidation()
	{
		javaScriptScrollDown();
		isDisplayed(DashboardRepository.allpage_copyright);
		isDisplayed(DashboardRepository.allpage_privacy_policy);
		isDisplayed(DashboardRepository.allpage_TermsConditions);
		isDisplayed(DashboardRepository.allpage_help);
		isDisplayed(DashboardRepository.allpage_brandpoweredbylogo);
		isDisplayed(DashboardRepository.allpage_brandcloudlogo);

		String prntwin = parentWinHandle();
		String footer1 = getStrText(DashboardRepository.allpage_privacy_policy).toLowerCase();
		clickElement(DashboardRepository.allpage_privacypolicylinktext);
		switchWindow();
		String privacypolicyurl = getCurrentUrl();
		String privacypolicytext = getStrText(DashboardRepository.allpage_footervalidationtext).toLowerCase();
		if (footer1.contains(privacypolicytext))
		{
			if (privacypolicyurl.contains("https://www.resulticks.com/Privacy-policy"))
			{
				BaseTest.getTest().log(Status.INFO, "Privacy policy validation completed");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Privacy policy Text is not present validation Fail");
			}
		}
		switchParentWin(prntwin);
		String footer2 = getStrText(DashboardRepository.allpage_TermsConditions).toLowerCase();
		clickElement(DashboardRepository.allpage_termsandconditionslinktext);
		switchWindow();
		String termsandconditionurl = getCurrentUrl();
		String termsandconditiontext = getStrText(DashboardRepository.allpage_footervalidationtext).toLowerCase();
		if (footer2.contains(termsandconditiontext))
		{
			if (termsandconditionurl.contains("https://www.resulticks.com/terms-and-conditions"))
			{
				BaseTest.getTest().log(Status.INFO, "Terms and condition validation completed");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Terms and condition Text is not present validation Fail");
			}
		}
		switchParentWin(prntwin);
		clickElement(DashboardRepository.allpage_helplinktext);
		switchWindow();
		String helpurl = getCurrentUrl();
		if (isDisplayed(DashboardRepository.allpage_footervalidationhelptext))
		{
			if (helpurl.contains("https://gud.resulticks.com/"))
			{
				BaseTest.getTest().log(Status.INFO, "Help validation completed");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Help Text is not present validation completed");
			}
		}
		switchParentWin(prntwin);
		return this;
	}

	public CommunicationListingPage listingPageFilter(String searchBy, String testData, String noOfPage, String locator)
	{
		explicitwaitforclick(autolocator(CommunicationRepository.CommunicationListing_SearchIconClick), 30);
		clickElement(CommunicationRepository.CommunicationListing_SearchIconClick);
		explicitwaitforclick(autolocator(AnalyticsRepository.analytics_listing_advanceSearch), 10);
		clickElement(AnalyticsRepository.analytics_listing_advanceSearch);
		selectlistelements(AnalyticsRepository.analytics_listing_advanceSearchList, searchBy);
		boolean var = true;
		int pageCount = Integer.parseInt(noOfPage);
		explicitwaitforclick(autolocator(CommunicationRepository.CommunicationListing_SearchCommunication), 50);
		String[] arr = { "All communication", "My communication", "Created", "Modified" };
		List<String> search = Arrays.asList(arr);
		if (!search.contains(searchBy))
		{
			sendValue(CommunicationRepository.CommunicationListing_SearchCommunication, testData);
			threadSleep(ObjectRepository.wait2sec);
			if (isElementPresent(AudienceRepository.audience_target_entersearchResult))
			{
				clickElement(AudienceRepository.audience_target_entersearchResult);
			}
			explicitwaitforclick(autolocator(CommunicationRepository.CommunicationListing_SearchIconClickAfterenterValue), 50);
			clickElement(CommunicationRepository.CommunicationListing_SearchIconClickAfterenterValue);
			BaseTest.takeScreenshot();
		}
		boolean flag = true;
		int count = 1;
		while (flag)
		{
			try
			{
				explicitwaitforvisibility(autolocator(AnalyticsRepository.analytics_listing_gridlist), 30);
				List<WebElement> results = findElements(AnalyticsRepository.analytics_listing_gridlist);
				if (testData.equals("S"))
				{
					testData = "Single dimension";
				} else if (testData.equals("M"))
				{
					testData = "Multi dimension";
				}
				for (int i = 0; i < results.size(); i++)
				{
					WebElement grid = results.get(i).findElement(autolocator(locator + "[" + (i + 1) + "]"));
					String result = grid.getText().trim();
					actionScrollToElement(results.get(i));
					javaScriptHighLightElement(grid);
					List<String> output = Arrays.asList(testData.split(","));
					if (!output.contains(result))
					{
						BaseTest.getTest().log(Status.FAIL, output + " doesn't filtered as Expected");
						javaScriptHighLightwithScrnShot(grid);
						var = false;
					}
				}
				if (var)
				{
					BaseTest.getTest().log(Status.INFO, "Test Data <b>" + testData + "</b> ---> Sucessfully verified in Page no: " + count);
				}
				if (count <= pageCount)
				{
					javaScriptScrollDown();
					flag = pageNavigation(AnalyticsRepository.analytics_listing_pagination);
					count++;
				} else
				{
					clickElement(AnalyticsRepository.analytics_listing_lastPage);
					count = Integer.parseInt(getTextBoxVal(AnalyticsRepository.analytics_listing_lastPageCount, "value"));
					flag = false;
				}
			} catch (Exception e)
			{
				e.printStackTrace();
				if (isElementPresent(AnalyticsRepository.analytics_listing_nodata))
				{
					BaseTest.getTest().log(Status.WARNING, "No Data Found");
					BaseTest.takeScreenshot();
				}
				break;
			}
			javaScriptScrolltoTop();
		}
		javaScriptHighLightwithScrnShot(locator);
		clickElement(AnalyticsRepository.analytics_listing_advanceSearchCancel);
		return this;
	}

	public CommunicationListingPage galleryCommunicationChannelValidation(String commname)
	{
		String gallerycommtitle = "";
		String listingsubstatuschannelname = communicationSubStatuscheck(commname);
		String[] channelnames = "Email,SMS,Web push,Mobile push,QR,WhatsApp,VMS".split(",");
		clickElement(CommunicationRepository.communciation_galleryicon);
		pageLoaderLogo();
		clickElement(CommunicationRepository.communication_gallery_searchicon);
		enterValue(CommunicationRepository.communication_gallery_textboxvalue, commname);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait2sec);
		clickElement(CommunicationRepository.communication_gallery_enteredvalueaftersearch);
		for (int i = 0; i < channelnames.length; i++)
		{
			pageLoaderLogo();
			threadSleep(ObjectRepository.wait2sec);
			clickElement("Channelname,xpath,//*[@id='cgListItems']//li//a[.='" + channelnames[i] + "']");
			threadSleep(ObjectRepository.wait2sec);
			String channel = getStrText("Channelname,xpath,//*[@id='cgListItems']//li//a[.='" + channelnames[i] + "']");
			if (listingsubstatuschannelname.equals("Web Notification"))
			{
				listingsubstatuschannelname = "Web push";
			}
			if (listingsubstatuschannelname.equals("Mobile Notification"))
			{
				listingsubstatuschannelname = "Mobile push";
			}

			if (listingsubstatuschannelname.contains(channel) && isDisplayed(",xpath,//div[@class='box-md']"))
			{
				gallerycommtitle = getTextBoxVal(CommunicationRepository.communication_gallery_communicationtitle, "title");
				if (gallerycommtitle.equals(commname))
				{
					BaseTest.getTest().log(Status.INFO, "Searched Communication name " + gallerycommtitle + " present in " + "<b>" + channel + "</b>" + " channel");
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Searched Communication name " + gallerycommtitle + " is not present in " + "<b>" + channel + "</b>" + " channel");
				}
			} else if (isDisplayed(CommunicationRepository.communication_gallery_communicationstatus))
			{
				String channels = getStrText("Channelname,xpath,//*[@id='cgListItems']//li//a[.='" + channelnames[i] + "']");
				String communicationstatus = getStrText(CommunicationRepository.communication_gallery_communicationstatus);
				BaseTest.getTest().log(Status.INFO, "<b>" + channels + "</b>" + " channel communication status is ----->" + communicationstatus);
			} else if (!(listingsubstatuschannelname.contains(channel)) && isDisplayed(",xpath,//div[@class='box-md']"))
			{
				String channels = getStrText("Channelname,xpath,//*[@id='cgListItems']//li//a[.='" + channelnames[i] + "']");
				gallerycommtitle = getTextBoxVal(CommunicationRepository.communication_gallery_communicationtitle, "title");
				if (gallerycommtitle.equals(commname))
				{
					BaseTest.getTest().log(Status.INFO, "Searched Communication name " + gallerycommtitle + " present in " + "<b>" + channels + "</b>" + " channel");
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Searched Communication name " + gallerycommtitle + " is not present in " + "<b>" + channel + "</b>" + " channel");
				}
			}
		}
		return this;
	}

	public String communicationSubStatuscheck(String commName)
	{
		threadSleep(ObjectRepository.wait2sec);
		explicitwaitforclick(autolocator(CommunicationRepository.CommunicationListing_SearchIconClick), 30);
		clickElement(CommunicationRepository.CommunicationListing_SearchIconClick);
		threadSleep(ObjectRepository.wait1sec);
		sendValue(CommunicationRepository.CommunicationListing_SearchCommunication, commName);
		explicitwaitforclick(autolocator(CommunicationRepository.CommunicationListing_SearchIconClickAfterenterValue), 50);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(CommunicationRepository.CommunicationListing_SearchIconClickAfterenterValue);
		threadSleep(ObjectRepository.wait5sec);
		explicitwaitforvisibility(autolocator("Communication Name,xpath,//h4[contains(.,'" + commName + "')]"), 30);
		clickElement(CommunicationRepository.communicationListing_plusicon);
		String channelname = getTextBoxVal(CommunicationRepository.communicationListing_channelicon, "title");
		return channelname;
	}

	public void eventTriggerPlayAndPause(String commname, String status)
	{
		clickElement(CommunicationRepository.communicationListing_plusicon);
		String notificationValue = null;
		String mainstatus = getStrText(CommunicationRepository.communicationListing_commmainstatus);
		if (!(mainstatus.equals("Completed") || mainstatus.equals("Draft")))
		{
			String substatus = getStrText(CommunicationRepository.communicationListing_dropdownvalue);
			if (status.equalsIgnoreCase("paused") && substatus.equalsIgnoreCase("Play") && !substatus.contains("Stopped"))
			{
				clickElement(CommunicationRepository.communicationListing_playicon);
				clickElement(CommunicationRepository.communicationListing_pauseicon);
				clickElement(CommunicationRepository.communicationListing_pause_confirm);
				notificationValue = "paused";
			} else if (status.equalsIgnoreCase("play") && substatus.equalsIgnoreCase("paused") && !substatus.equalsIgnoreCase("stopped"))
			{
				clickElement(CommunicationRepository.communicationListing_pauseicon);
				clickElement(CommunicationRepository.communicationListing_playicon);
				clickElement(CommunicationRepository.communicationListing_play_confirm);
				notificationValue = "resumed";
			} else if (status.equalsIgnoreCase("stopped") && substatus.equalsIgnoreCase("paused") || status.equalsIgnoreCase("stopped") && substatus.equalsIgnoreCase("play"))
			{
				{
					clickElement(",xpath, (//*[contains(@class,'icon-" + substatus + "-small')])[1]");
					notificationValue = "stopped";
				}
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Either Given condition is wrong or status already in " + substatus + " : state");
				BaseTest.takeScreenshot();
			}
			if (isDisplayed(CommunicationRepository.communicationListing_notification_msg))
			{
				String notificationMessageinUI = getStrText(CommunicationRepository.communicationListing_notification_msg);
				String notificationMessageActual = "Campaign \"" + commname + "\" has been " + notificationValue + ".";
				System.out.println(notificationMessageinUI);
				System.out.println(notificationMessageActual);
				if (notificationMessageinUI.contains(notificationMessageActual))
				{
					BaseTest.getTest().log(Status.INFO, "The Communication has been successfully " + notificationValue);
					BaseTest.takeScreenshot();
				} else
				{
					BaseTest.getTest().log(Status.INFO, "The Communication has not been successfully " + notificationValue);
					BaseTest.takeScreenshot();
				}
			}
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Main Status is equal to completed");
		}
	}

	public void getWebmailsNotificationMessage(String commname)
	{
		javaScriptopenNewWindow();
		switchWindow();
		webURLlaunch();
		accountUserWebmailLogin();
		String webmailNotificationMessage = getWebmailNotificationMessage(commname);
		if (webmailNotificationMessage.contains("The campaign is being paused"))
		{
			BaseTest.getTest().log(Status.INFO, "Event trigger communication status is :  " + webmailNotificationMessage);
		} else if (webmailNotificationMessage.contains("The campaign is being started"))
		{
			BaseTest.getTest().log(Status.INFO, "Event trigger communication status is :  " + webmailNotificationMessage);
		} else if (webmailNotificationMessage.contains("The campaign is being stopped"))
		{
			BaseTest.getTest().log(Status.INFO, "Event trigger communication status is :  " + webmailNotificationMessage);
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Event trigger communication status is not equal to status.current status is :  " + webmailNotificationMessage);
		}
	}

	public ArrayList<String> getCommunicationPageDetails(String commname)
	{
		ArrayList<String> commstatus = new ArrayList<>();

		clickElement(CommunicationRepository.communicationListing_plusicon);
		pageLoaderLogo();
		List<WebElement> titles = findElements(",xpath,//h4[@title='" + commname + "']//ancestor::tr[@class='k-master-row green belowData']//..//tr[@class='k-detail-row']//tbody//tr//td[@align='left']//i");
		for (int i = 0; i < titles.size(); i = i + 2)
		{
			String title = titles.get(i).getAttribute("title");
			if ((!title.contains("Web analytics")) && (!title.contains("App Analytics")))
			{
				String[] channelname = title.split(" ");
				String channel = channelname[0];
				commstatus.add(channel);
			}
		}
		String communicationType = getStrText(CommunicationRepository.communicationListing_communicationtype);
		String deliveryMethod = getStrText(CommunicationRepository.communicationListing_deliverymethod);
		String audience = getStrText(CommunicationRepository.comuunicationListing_totalAudience);
		String totalAudience = audience.replace("\n", ":");
		commstatus.add(communicationType);
		commstatus.add(totalAudience);
		commstatus.add(deliveryMethod);

		return commstatus;
	}

	public List<Map<String, String>> getGalleryPageDetails(String commname, ArrayList<String> commstatus)
	{
		String key = null;
		String value = null;
		clickElement(CommunicationRepository.communciation_galleryicon);
		pageLoaderLogo();
		clickElement(CommunicationRepository.communication_gallery_searchicon);
		enterValue(CommunicationRepository.communication_gallery_textboxvalue, commname);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait2sec);
		clickElement(CommunicationRepository.communication_gallery_enteredvalueaftersearch);
		for (int i = 0; i < commstatus.size(); i++)
		{
			String channelname = commstatus.get(i);
			if (channelname.contains("Single dimension") || (channelname.contains("Multi dimension")) || (channelname.contains("Event trigger") || (channelname.contains("Awareness") || (channelname.contains("Greetings"))
					|| (channelname.contains("Lead generation")) || (channelname.contains("New product launch")) || (channelname.contains("Promotion")) || (channelname.contains("Webinar")))) || (channelname.contains("Total audience")))
			{
			} else
			{
				if (channelname.equals("Web"))
				{
					channelname = "Web push";
				}
				if (channelname.equals("Mobile"))
				{
					channelname = "Mobile push";
				}
				pageLoaderLogo();
				threadSleep(ObjectRepository.wait2sec);
				clickElement("Channelname,xpath,//*[@id='cgListItems']//li//a[.='" + channelname + "']");
				pageLoaderLogo();
				threadSleep(ObjectRepository.wait5sec);
				clickElement(CommunicationRepository.communication_gallery_i_icon);
				pageLoaderLogo();
				threadSleep(ObjectRepository.wait2sec);
				List<WebElement> keyval = findElements("gallerystatus key,xpath,//div[contains(@class,'inline-block')]");
				for (int j = 0; j < keyval.size(); j++)
				{
					key = keyval.get(j).getText();
					List<WebElement> valuess = findElements("gallerystatus value,xpath,//div[contains(@class,'pfCampLabel')]");
					for (int k = 0; k < valuess.size(); k++)
					{
						value = valuess.get(j).getText();
						if (channelname.contains("Email"))
						{
							emailChannelCommunicationAnalyticsListingPageCount.put(key, value);
							emailChannelCommunicationAnalyticsListingPageCount.put("Channel", channelname);
						} else if (channelname.contains("SMS"))
						{
							smsChannelCommunicationAnalyticsListingPageCount.put(key, value);
							smsChannelCommunicationAnalyticsListingPageCount.put("Channel", channelname);
						} else if (channelname.contains("Web push"))
						{
							webChannelCommunicationAnalyticsListingPageCount.put(key, value);
							webChannelCommunicationAnalyticsListingPageCount.put("Channel", channelname);
						} else if (channelname.contains("Mobile push"))
						{
							mobileChannelCommunicationAnalyticsListingPageCount.put(key, value);
							mobileChannelCommunicationAnalyticsListingPageCount.put("Channel", channelname);
						} else if (channelname.contains("QR"))
						{
							qrChannelCommunicationAnalyticsListingPageCount.put(key, value);
							qrChannelCommunicationAnalyticsListingPageCount.put("Channel", channelname);
						} else if (channelname.contains("WhatsApp"))
						{
							whatsappChannelCommunicationAnalyticsListingPageCount.put(key, value);
							whatsappChannelCommunicationAnalyticsListingPageCount.put("Channel", channelname);
						} else if (channelname.contains("VMS"))
						{
							vmsChannelCommunicationAnalyticsListingPageCount.put(key, value);
							vmsChannelCommunicationAnalyticsListingPageCount.put("Channel", channelname);
						}
					}
				}
			}
		}
		communicationAnalyticsListingCount.add(emailChannelCommunicationAnalyticsListingPageCount);
		communicationAnalyticsListingCount.add(smsChannelCommunicationAnalyticsListingPageCount);
		communicationAnalyticsListingCount.add(webChannelCommunicationAnalyticsListingPageCount);
		communicationAnalyticsListingCount.add(mobileChannelCommunicationAnalyticsListingPageCount);
		communicationAnalyticsListingCount.add(qrChannelCommunicationAnalyticsListingPageCount);
		communicationAnalyticsListingCount.add(whatsappChannelCommunicationAnalyticsListingPageCount);
		communicationAnalyticsListingCount.add(vmsChannelCommunicationAnalyticsListingPageCount);
		return communicationAnalyticsListingCount;
	}

	public void galleryAndAnalyticsStatusValidation(List<Map<String, String>> gallerypagestatus, List<Map<String, String>> analyticspagestatus)
	{
		String list[] = { "email", "sms", "web", "mobile", "whatsapp", "qr", "vms" };
		for (int z = 0; z < list.length; z++)
		{
			for (int i = 0; i < gallerypagestatus.size(); i++)
			{
				Map<String, String> gallerystatus = gallerypagestatus.get(i);
				for (int j = 0; j < analyticspagestatus.size(); j++)
				{
					Map<String, String> analyticstatus = analyticspagestatus.get(j);
					String channel = analyticstatus.get("Channel");
					if (!(channel.contains("Web analytics") || (channel.contains("Mobile analytics"))))
					{
						if ((!gallerystatus.isEmpty() && (!analyticstatus.isEmpty())) && (gallerystatus.get("Channel").toLowerCase().contains(list[z]) && (analyticstatus.get("Channel").toLowerCase().contains(list[z]))))
						{
							for (Map.Entry<String, String> entry : gallerystatus.entrySet())
							{
								String gallerykey = entry.getKey();
								for (Map.Entry<String, String> entry1 : analyticstatus.entrySet())
								{
									String analyticskey = entry1.getKey();
									if (gallerykey.contains("Engagement") && (analyticskey.contains("Engagement")) || (gallerykey.contains("Reach") && (analyticskey.contains("Reach")))
											|| (gallerykey.contains("Conversion")) && (analyticskey.contains("Conversion")) || (gallerykey.contains("Total")) && (analyticskey.contains("Total")))
									{
										String galleryreachvalue = entry.getValue();
										String analyticsreachvalue = entry1.getValue();
										if (analyticsreachvalue.isEmpty())
										{
											analyticsreachvalue = "NA";
										}
										if (galleryreachvalue.equals(analyticsreachvalue))
										{
											BaseTest.getTest().log(Status.INFO,
													list[z] + " channel -----> gallery page (" + gallerykey + " = " + galleryreachvalue + ") status is equal to analytics page status (" + analyticskey + " = " + analyticsreachvalue + ")");
										}
									}
								}
							}
						}
					}
				}

			}
		}
	}

	public void commAndGalleryPageStatusValidation(ArrayList<String> communicationpagestatus, List<Map<String, String>> gallerypagestatus)
	{
		String gallerykey = null;
		String galleryvalue = null;
		String commkey = null;
		String commvalue = null;
		String channel = null;
		Map<String, String> commpagestatus = new HashMap<String, String>();
		for (int i = 0; i < communicationpagestatus.size(); i++)
		{
			String commstatus = communicationpagestatus.get(i);
			if (commstatus.equals("Single dimension") || (commstatus.equals("Multi dimension")) || (commstatus.equals("Event trigger")))
			{
				commpagestatus.put("Delivery method", commstatus);
			} else if (commstatus.equals("Awareness") || (commstatus.equals("Greetings")) || (commstatus.equals("Lead generation")) || (commstatus.equals("New product launch")) || (commstatus.equals("Promotion")) || (commstatus.equals("Webinar")))
			{
				commpagestatus.put("Communication type", commstatus);
			}
		}
		for (int i = 0; i < gallerypagestatus.size(); i++)
		{
			Map<String, String> map = gallerypagestatus.get(i);
			for (Map.Entry<String, String> gallerystatus : map.entrySet())
			{
				gallerykey = gallerystatus.getKey();
				galleryvalue = gallerystatus.getValue();
				if (gallerykey.contains("Channel"))
				{
					channel = galleryvalue;
					System.out.println(channel);
				}
				for (Map.Entry<String, String> commstatus : commpagestatus.entrySet())
				{
					commkey = commstatus.getKey();
					commvalue = commstatus.getValue();
					if (gallerykey.contains(commkey))
					{
						BaseTest.getTest().log(Status.INFO, channel + " channel ----> communicationpage (" + gallerykey + " = " + galleryvalue + ") status is equal to gallery page status (" + commkey + "=" + commvalue + ")");
					}
				}
			}
		}
	}

	// Communication listing page-Gallerylisting-Plannerlisting page scenarios
	public CommunicationListingPage selectPlannerpageCurrentDate(String currentDate)
	{
		explicitwaitforvisibility(autolocator("Channel Name,xpath,//*[@class='fc-daygrid-day-top']//a[contains(text(),'" + currentDate + "')]"), 30);
		clickElement("Slecting the Current Date in Planner Page,xpath,//*[@class='fc-daygrid-day-top']//a[contains(text(),'" + currentDate + "')]");
		return this;
	}

	public CommunicationListingPage plannerPageCommunicationListVerify(String communicationName)
	{
		List<WebElement> allCommunication = findElements(CommunicationRepository.communication_planner_communicationlist);
		BaseTest.getTest().log(Status.INFO, "Communication Listing page status is : " + communicationListingPageStatus + "Communication Name is : " + communicationName);

		for (WebElement Commtextlist : allCommunication)
		{
			String acquiredCommName = Commtextlist.getText();

			if (communicationListingPageStatus.contains("Draft"))
			{
				if (acquiredCommName.equals(communicationName))
				{
					BaseTest.getTest().log(Status.FAIL, "Draft Communication is present in Planner page");
					BaseTest.takeScreenshot();
				}
			} else if (communicationListingPageStatus.contains("Scheduled") || communicationListingPageStatus.contains("In progress") || communicationListingPageStatus.contains("Completed") || communicationListingPageStatus.contains("Alert"))
			{
				if (acquiredCommName.equals(communicationName))
				{
					BaseTest.getTest().log(Status.INFO, "Communication is present in Planner page");
					BaseTest.takeScreenshot();
				}
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Listing page status is wrong");
				BaseTest.takeScreenshot();
			}
		}
		return this;
	}

	public void dashboardPageValidation()
	{
		if (isDisplayed(DashboardRepository.dashboard_earning_comm_dropdown))
		{
			clickElement(DashboardRepository.dashboard_earning_comm_dropdown);
			List<WebElement> earningCommStatus = findElements(DashboardRepository.dashboard_earning_comm_dropdown_select);
			for (WebElement earningstatus : earningCommStatus)
			{
				earningstatus.click();
				String totalEarning = getStrText(DashboardRepository.dashboard_earning_comm_details);
				if (totalEarning.toLowerCase().contains("undefined"))
				{
					BaseTest.getTest().log(Status.FAIL, "Earning status is undefined");
				} else
				{
					BaseTest.getTest().log(Status.INFO, "Earning status is present");
				}
			}
		}
		clickElement(DashboardRepository.dashboard);
		threadSleep(ObjectRepository.wait5sec);
		List<WebElement> chartvalue = findElements(AnalyticsRepository.analytics_audiencebehaviorchart);
		if (chartvalue.isEmpty())
		{
			BaseTest.getTest().log(Status.INFO, "Behavior status is empty");
		}
		for (WebElement element : chartvalue)
		{
			String audienceBehavior = element.getText();
			if (!audienceBehavior.isEmpty())
			{
				BaseTest.getTest().log(Status.INFO, "Audience behavior data is " + audienceBehavior);
				System.out.println(audienceBehavior);
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Audience behavior data is empty");
				System.out.println(audienceBehavior);
			}
		}

		List<WebElement> dashboardElements = findElements(DashboardRepository.dashboard_total_sortitems);
		for (int i = 0; i < dashboardElements.size(); i++)
		{
			String text = dashboardElements.get(i).getText();
			if (text.contains("No data available"))
			{
				BaseTest.getTest().log(Status.FAIL, "Dashboard page is present No data available text");
				BaseTest.takeScreenshot();
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Dashboard page is not present No data available text");
			}
		}
	}

	public void allCommGalleryEDMValidation()
	{
		List<String> l = new ArrayList<>();
		List<WebElement> elements;
		clickElement(CommunicationRepository.communciation_galleryicon);
		threadSleep(ObjectRepository.wait2sec);
		clickElement("Gallery Dropdown,xpath,//div[@class='tab-content']//span[@class='k-dropdown-wrap k-state-default']");
		threadSleep(ObjectRepository.wait2sec);
		selectlistelements("Gallery dropdown value,xpath,//div[@class='k-animation-container']//li", "20");
		while (true)
		{
			threadSleep(ObjectRepository.wait3sec);
			try
			{
				elements = findElements(",xpath,//div[@class='box-md']//div[@class='campaigngallery_flex']//ul//li//img//ancestor::div//h5//span");
			} catch (Exception e)
			{
				elements = findElements(",xpath,//div[@class='box-md']//div[@class='campaigngallery_flex']//ul//li//img//ancestor::div//h5//span");
			}

			for (int i = 0; i < elements.size(); i++)
			{
				String commtitle = elements.get(i).getAttribute("title");
				javaScriptHighLightElement(elements);

				String imgval = getTextBoxVal(",xpath,//div[@class='box-md']//h5[@class='margin-B15']//span[@title='" + commtitle + "']//ancestor::div[@class='box-md']//div[@class='campaigngallery_flex']//li//img", "src");
				if (imgval.equals(
						"data:image/jpeg;base64,/9j/4QAYRXhpZgAASUkqAAgAAAAAAAAAAAAAAP/sABFEdWNreQABAAQAAABkAAD/4QMxaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLwA8P3hwYWNrZXQgYmVnaW49Iu+7vyIgaWQ9Ilc1TTBNcENlaGlIenJlU3pOVGN6a2M5ZCI/PiA8eDp4bXBtZXRhIHhtbG5zOng9ImFkb2JlOm5zOm1ldGEvIiB4OnhtcHRrPSJBZG9iZSBYTVAgQ29yZSA1LjYtYzE0NSA3OS4xNjM0OTksIDIwMTgvMDgvMTMtMTY6NDA6MjIgICAgICAgICI+IDxyZGY6UkRGIHhtbG5zOnJkZj0iaHR0cDovL3d3dy53My5vcmcvMTk5OS8wMi8yMi1yZGYtc3ludGF4LW5zIyI+IDxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSIiIHhtbG5zOnhtcD0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLyIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bXA6Q3JlYXRvclRvb2w9IkFkb2JlIFBob3Rvc2hvcCBDQyAyMDE5IChNYWNpbnRvc2gpIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOjc3MkNEMTgzNEQyNzExRTk4NzAyRjg1NEY2MEY3MEQ0IiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOjc3MkNEMTg0NEQyNzExRTk4NzAyRjg1NEY2MEY3MEQ0Ij4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6NzcyQ0QxODE0RDI3MTFFOTg3MDJGODU0RjYwRjcwRDQiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6NzcyQ0QxODI0RDI3MTFFOTg3MDJGODU0RjYwRjcwRDQiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz7/7gAOQWRvYmUAZMAAAAAB/9sAhAABAQEBAQEBAQEBAQEB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"))
				{
					l.add(commtitle);
					BaseTest.getTest().log(Status.INFO, "EDM not shown properly");
					BaseTest.takeScreenshot();
				} else
				{
					BaseTest.getTest().log(Status.INFO, "EDM shown properly");
				}
			}
			String paginationarrow = getTextBoxVal(CommunicationRepository.CommunicationListing_paginationgotonextpage, "class");
			if (paginationarrow.contains("disabled"))
			{
				BaseTest.getTest().log(Status.INFO, "Pagination arrow is not clickable or disabled");
				BaseTest.takeScreenshot();
				threadSleep(ObjectRepository.wait5sec);
				break;
			} else
			{
				WebElement nextpagearrow = driver.findElement(autolocator(",xpath,//a[@title='Go to the next page']//span"));
				nextpagearrow.click();
				pageLoaderLogo();
				threadSleep(ObjectRepository.wait3sec);
			}
		}
		clickCommunicationListpagefromMenu();
		for (int i = 0; i < l.size(); i++)
		{
			threadSleep(ObjectRepository.wait2sec);
			String commName = l.get(i);
			threadSleep(ObjectRepository.wait2sec);
			clickElement(CommunicationRepository.CommunicationListing_SearchIconClick);
			enterValue(CommunicationRepository.CommunicationListing_SearchCommunication, commName);
			threadSleep(ObjectRepository.wait2sec);
			clickElement(CommunicationRepository.CommunicationListing_SearchIconClickAfterenterValue);
			threadSleep(ObjectRepository.wait5sec);
			String mainStatus = getStrText(",xpath,//div[@class='campaign-status text-center']//small");
			if (!mainStatus.contains("Draft"))
			{
				BaseTest.getTest().log(Status.FAIL, "Communication main status is not-equal to draft");
				BaseTest.takeScreenshot();
			}
		}
	}

	public CommunicationListingPage editWebAnalytics(String status)
	{
		if (communicationListingPageStatus.toLowerCase().contains(status.toLowerCase()))
		{
			explicitwaitforvisibility(autolocator(CommunicationRepository.CommunicationListing_plusIconForDetails), 30);
			clickElement(CommunicationRepository.CommunicationListing_plusIconForDetails);
			pageLoaderLogo();
			explicitwaitforvisibility(autolocator(CommunicationRepository.CommunicationListing_webAnalytics_Edit), 10);
			clickElement(CommunicationRepository.CommunicationListing_webAnalytics_Edit);
			pageLoaderLogo();
			explicitwaitforclick(autolocator(CommunicationRepository.notification_webpush_wpnexttoprecommunication), 30);

			// GDP Ticket ID : #23197
			String attribute = getTextBoxVal("Web Analytics page,xpath,//div[@id='analytics-web']", "class");
			if (status.equalsIgnoreCase("In progress") || status.equalsIgnoreCase("completed"))
			{
				if (attribute.contains("click-off"))
				{
					BaseTest.getTest().log(Status.INFO, "The Web Analytics Page is Disabled Mode");
				} else
				{
					BaseTest.getTest().log(Status.INFO, "The Web Analytics Page is Editable Mode");
					BaseTest.takeScreenshot();
				}
			} else if (status.equalsIgnoreCase("Scheduled"))
			{
				if (!attribute.contains("click-off"))
				{
					BaseTest.getTest().log(Status.INFO, "The Web Analytics Page is Editable Mode");
				} else
				{
					BaseTest.getTest().log(Status.INFO, "The Web Analytics Page is disable Mode");
					BaseTest.takeScreenshot();
				}
			}
			clickElement(CommunicationRepository.notification_webpush_wpnexttoprecommunication);
			pageLoaderLogo();
		}
		return this;
	}

	public void clickAnalytics(String commName)
	{
		try
		{
			explicitwaitforclick(autolocator("Analytics,xpath,//p[.='" + commName + "']/ancestor::div[@class='panelbar-wrapper campaign-analytics-list']//*[contains(@class,'icon-sd-analytics')]"), 30);
			clickElement("Analytics,xpath,//p[.='" + commName + "']/ancestor::div[@class='panelbar-wrapper campaign-analytics-list']//*[contains(@class,'icon-sd-analytics')]");
			pageLoaderLogo();
		} catch (Exception e)
		{
			BaseTest.getTest().log(Status.FAIL, "Analytics button is not avilable in communication listing page");
		}
	}

	public CommunicationListingPage editcommWithName(String commName)
	{
		threadSleep(ObjectRepository.wait3sec);
		javaScriptScrolltoTop();
		int commCountIdentify = commCountIdentify(commName);
		explicitwaitforclick(autolocator("Edit icon,xpath,//p[.='" + commName + "']//..//..//.//i[contains(@id,'pencil_edit')]"), 30);
		clickElement("Edit icon,xpath,//p[.='" + commName + "']//..//..//.//i[contains(@id,'pencil_edit')]");
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait20sec);
		if (!isElementPresent(CommunicationRepository.communicationpage_commcreation_title))
		{
			BaseTest.getTest().log(Status.FAIL, "Page is not navigaets to Plan page");
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public int commCountIdentify(String communicationN)
	{
		int value = 0;
		List<WebElement> commNames = findElements("Communication names,xpath,//p[@class='pt5']//div[contains(@class,'tooltip-wrapper')]");
		int commNamesSize = findElements("Communication names,xpath,//p[@class='pt5']//div[contains(@class,'tooltip-wrapper')]").size();
		for (int i = commNamesSize; i > 0; i--)
		{
			Actions actions = new Actions(driver);
			actions.moveToElement(commNames.get(i - 1)).build().perform();
			threadSleep(ObjectRepository.wait3sec);
			String tooltipValue = getStrText("Tooltip,xpath,//div[@class='tooltip-inner']");
			if (tooltipValue.equals(communicationN))
			{
				value = i;
				break;
			}
		}
		return value;
	}

	public String duplicatecomm(String commName)
	{
		try
		{
			int commCountIdentify = commCountIdentify(commName);
			clickElement("Actions,xpath,//p[.='" + commName + "']//..//..//i[contains(@class,'arrow-down')]");
			threadSleep(ObjectRepository.wait3sec);
			explicitwaitforclick(autolocator(CommunicationRepository.listingpage_duplicate), 20);
			clickElement(CommunicationRepository.listingpage_duplicate);
			pageLoaderLogo();
			javaScriptScrolltoTop();
		} catch (Exception e)
		{
			BaseTest.getTest().log(Status.FAIL, "Duplicate button is not avilable in communication listing page");
		}
		return commName + "_copy1";
	}

	public CommunicationListingPage deleteCommunication(String commName)
	{
		communicationName = commName;
		searchCommunication("communication", communicationName);
		clickExpand(commName);
		BaseTest.takeScreenshot();
		List<WebElement> channelNames = driver.findElements(By.xpath("//table[@class='accordian-body']//tr//td[2]"));
		for (int i = 0; i < channelNames.size(); i++)
		{
			channelNames = driver.findElements(By.xpath("//table[@class='accordian-body']//tr//td[2]"));
			String channelName = channelNames.get(0).getText();
			explicitwaitforvisibility(autolocator(channelName + " delete button,xpath,//*[text()='" + channelName + "']/ancestor::tr[not(@class='k-detail-row')]//*[contains(@class,'icon-archive-small icons-md blue')]"), 30);
			clickElement(channelName + " delete button,xpath,//*[text()='" + channelName + "']/ancestor::tr[not(@class='k-detail-row')]//*[contains(@class,'icon-archive-small icons-md blue')]");
			int a;
			if (channelNames.size() > 1)
			{
				a = channelNames.size() - i;
			} else
			{
				a = 1;
			}
			explicitwaitforvisibility(autolocator(CommunicationRepository.communicationpageListing_confirmdelete_Popup.concat("[" + a + "]")), 30);
			threadSleep(ObjectRepository.wait5sec);
			clickElement(CommunicationRepository.communicationpageListing_confirmdelete_Popup.concat("[" + a + "]"));
			threadSleep(ObjectRepository.wait5sec);
			pageLoaderLogo();
			searchCommunication("communication", commName);
			clickExpand(commName);
			if (!isElementPresent(channelName + " delete button,xpath,//*[text()='" + channelName + "']/ancestor::tr[not(@class='k-detail-row')]//*[contains(@class,'icon-archive-small icons-md blue')]"))
			{
				BaseTest.getTest().log(Status.INFO, channelName + " communication is successfully deleted");
				BaseTest.takeScreenshot();
			} else
			{
				BaseTest.getTest().log(Status.FAIL, channelName + " communication has not deleted");
				BaseTest.takeScreenshot();
			}
			closeSearchField();
			searchCommunication("communication", commName);
			clickExpand(commName);
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public void clickExpand(String commName)
	{
		try
		{
			clickElement("Expand plus icon,xpath,//p[.='" + commName + "']/ancestor::tr[contains(@class,'k-master-row')]//a");
			pageLoaderLogo();
		} catch (Exception e)
		{
			BaseTest.getTest().log(Status.INFO, "Communication Plus icon not working properly");
		}
		threadSleep(ObjectRepository.wait2sec);
	}

	public void closeSearchField()
	{
		try
		{
			pageLoaderLogo();
			explicitwaitforclick(autolocator(CommunicationRepository.communication_closesearch_btn), 20);
			clickElement(CommunicationRepository.communication_closesearch_btn);
			explicitwaitforvisibility(autolocator(CommunicationRepository.communication_communication_details), 20);
		} catch (Exception e)
		{
			BaseTest.getTest().log(Status.FAIL, "Search field close button has not appeared on display");
		}
	}

	public void clickarchive(String commName)
	{
		try
		{
			explicitwaitforclick(autolocator("Archive,xpath,//p[.='" + commName + "']/ancestor::div[@class='panelbar-wrapper campaign-analytics-list']//i[@class='icon-archive-small icons-md blue']"), 20);
			clickElement("Archive,xpath,//p[.='" + commName + "']/ancestor::div[@class='panelbar-wrapper campaign-analytics-list']//i[@class='icon-archive-small icons-md blue']");
			clickElement(CommunicationRepository.communicationpageListing_confirmdelete_Popup);
			pageLoaderLogo();
		} catch (Exception e)
		{
			BaseTest.getTest().log(Status.FAIL, "Archive button is not avilable in communication listing page");
		}
	}

	public void editCommName(String commName)
	{
		String addTimeToName = addTimeToName();
		clickElement(CommunicationRepository.communicationListing_editcomm);
		pageLoaderLogo();
		clearField(CommunicationRepository.Communicationcreate_entercommunicationname);
		enterValue(CommunicationRepository.Communicationcreate_entercommunicationname, commName + addTimeToName);
		javaScriptScrollDown();
		threadSleep(ObjectRepository.wait2sec);
		clickElement(CommunicationRepository.communicationpage_email_save);
		threadSleep(ObjectRepository.wait3sec);
	}

	public void expandcommunication(String commName)
	{
		searchCommunication("communication", commName);
		clickElement("Expand plus icon,xpath,//p[.='" + commName + "']/ancestor::tr[contains(@class,'k-master-row')]//a");
		explicitwaitforvisibility(autolocator("channel header,xpath,//th[contains(.,'Channel')]"), 20);
		pageLoaderLogo(); // preview check
		List<WebElement> channelNames = driver.findElements(By.xpath("//tbody//tr//div[contains(@class,'social')]"));
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		String names[] = { "email" };
		// Preview check
		for (int i = 0; i < 1; i++)
		{
			mouseHover(channelNames.get(i));
			String channelName = getStrText("Tooltip,xpath,//div[@class='tooltip-inner']");
			if (channelName.equalsIgnoreCase(names[i]))
			{
				if (isDisplayed("preview icon,xpath,(//div[@class='social-icon bg-email']/ancestor::tr//i[@id='rs_data_eye'])[1]"))
				{
					clickElement("preview icon,xpath,(//div[@class='social-icon bg-email']/ancestor::tr//i[@id='rs_data_eye'])[1]");
					threadSleep(ObjectRepository.wait2sec);
					if (isElementPresent(CommunicationRepository.CommunicationListing_emailpreview))
					{
						BaseTest.getTest().log(Status.INFO, "Email preview is displayed");
						BaseTest.takeScreenshot();
					} else if (isElementPresent(CommunicationRepository.CommunicationListing_smspreview))
					{
						BaseTest.getTest().log(Status.INFO, "SMS preview is displayed");
						BaseTest.takeScreenshot();
					} else
					{
						BaseTest.getTest().log(Status.FAIL, names[i] + " preview has not displyed");
					}
					threadSleep(ObjectRepository.wait2sec);
//					isElementPresent("preview icon,xpath,(//div[@class='social-icon bg-email']/ancestor::tr//i[@id='rs_data_eye'])[1]");
//					clickElement("preview icon,xpath,(//div[@class='social-icon bg-email']/ancestor::tr//i[@id='rs_data_eye'])[1]");
				}
			}
		}
		// edit button check
		for (int i = 0; i < 1; i++)
		{
			mouseHover(channelNames.get(i));
			String channelName = getStrText("Tooltip,xpath,//div[@class='tooltip-inner']");
			if (channelName.equalsIgnoreCase(names[i]))
			{
				if (isDisplayed("edit icon,xpath,(//div[@class='social-icon bg-email']/ancestor::tr//i[@id='rs_data_pencil_edit'])[1]"))
				{
					clickElement("edit icon,xpath,(//div[@class='social-icon bg-email']/ancestor::tr//i[@id='rs_data_pencil_edit'])[1]");
					pageLoaderLogo();
					String activeChannel = getStrText("Active channel,xpath,//ul[contains(@class,'rs-sub-tabs')]//li[contains(@class,'tabDefault active')]//span");
					if (activeChannel.equals("Email"))
					{
						BaseTest.getTest().log(Status.INFO, "Page navigates successfully to Email channel Authouring page after clicked edit button");
						BaseTest.takeScreenshot();
					} else if (activeChannel.equals("Mobile"))
					{
						BaseTest.getTest().log(Status.INFO, "Page navigates successfully to SMS channel Authouring page after clicked edit button");
						BaseTest.takeScreenshot();
					} else
					{
						BaseTest.getTest().log(Status.FAIL, "Page has not navigates to " + names[i] + " channel Authouring page after clicked edit button");
					}
					comm.clickCommunicationListpagefromMenu();
					pageLoaderLogo();
					searchCommunication("communication", commName);
					clickElement("Expand plus icon,xpath,//p[.='" + commName + "']/ancestor::tr[contains(@class,'k-master-row')]//a");
					pageLoaderLogo();
				}
			}
		}
		// Analytics check
		for (int i = 0; i < 1; i++)
		{
			List<WebElement> channelNames1 = driver.findElements(By.xpath("//tbody//tr//div[contains(@class,'social')]"));
			mouseHover(channelNames1.get(i));
			String channelName = getStrText("Tooltip,xpath,//div[@class='tooltip-inner']");
			if (channelName.equalsIgnoreCase(names[i]))
			{
				if (isDisplayed("Anlytics icon,xpath,(//div[@class='social-icon bg-email']/ancestor::tr//i[contains(@class,'icon-rs-analytics-medium')])[1]"))
				{
					clickElement("Anlytics icon,xpath,(//div[@class='social-icon bg-email']/ancestor::tr//i[contains(@class,'icon-rs-analytics-medium')])[1]");
					pageLoaderLogo();
					threadSleep(ObjectRepository.wait10sec);
					String analyticsActiveTab = getStrText("Active channel,xpath,//li[contains(@class,'tabDefault active')]//span");
					if (analyticsActiveTab.equals("Email") && isDisplayed("Portlets,xpath,//div[@class='csr-reach-portlet']"))
					{
						BaseTest.getTest().log(Status.INFO, "Page successfully navigates to Email Analytics page after clicked analytics button");
						BaseTest.takeScreenshot();
					} else if (analyticsActiveTab.equals("Mobile") && isDisplayed("key metrics,xpath,//h4[contains(.,'Key metrics')]"))
					{
						BaseTest.getTest().log(Status.INFO, "Page successfully navigates to SMS Analytics page after clicked analytics button");
						BaseTest.takeScreenshot();
					} else
					{
						BaseTest.getTest().log(Status.FAIL, "Page has not navigates to " + names[i] + " Analytics page after clicked analyics button");
					}
				}
			}
		}

	}


	public void searchCommunicationTillInprogress(String commName)
	{
//		explicitwaitforvisibility(autolocator(",xpath,//h1[contains(.,'Communication')]"), 20);
//		String communicationStatus = "";
//		for (int i = 0; i <= 15; i++)
//		{
//			searchCommunication("communicationlisting", commName);
//			clickElement("Expand,xpath,//div[.='" + commName + "']/ancestor::tr[contains(@class,'k-master-row')]//a[@aria-label='Expand detail row']");
//			pageLoaderLogo();
//			communicationStatus = getStrText(",xpath,//p[.='" + commName + "']/ancestor::td[@class='status-progress']//div[@class='status-box']//small");
//			if (communicationStatus.contains("In progress"))
//			{
//				break;
//			}
//		}
		threadSleep(ObjectRepository.wait5min);
		threadSleep(ObjectRepository.wait5min);
		threadSleep(ObjectRepository.wait5min);
		threadSleep(ObjectRepository.wait5min);
	}

	public void searchCommunicationTillBlast(String commName)
	{
		explicitwaitforvisibility(autolocator(",xpath,//h1[contains(.,'Communication')]"), 20);
		String communicationSubStatus = "";
		for (int i = 0; i <= 15; i++)
		{

			threadSleep(ObjectRepository.wait5sec);
			clickElement(CommunicationRepository.CommunicationListing_SearchIconClick);
			threadSleep(ObjectRepository.wait2sec);
			enterValue(CommunicationRepository.CommunicationListing_SearchCommunication, commName);
			threadSleep(ObjectRepository.wait3sec);
			clickElement(CommunicationRepository.CommunicationListing_SearchIconClickAfterenterValue);
			threadSleep(ObjectRepository.wait5sec);
			clickElement("Expand plus icon,xpath,//p[.='" + commName + "']/ancestor::tr[contains(@class,'k-master-row')]//a");
			pageLoaderLogo();
			communicationSubStatus = getTextBoxVal(",xpath,//ul[@class='d-flex align-items-center']/child::li/child::i[not(contains(@class,'paid'))]", "class");
			if (communicationSubStatus.contains("completed"))
			{
				BaseTest.getTest().log(Status.INFO, "Communication is blasted succesfully.");
				BaseTest.takeScreenshot();
				break;
			}
			clickElement(CommunicationRepository.CommunicationListing_minusicon);
			BaseTest.getTest().log(Status.INFO, "Communication is in inprogress state");
		}
	}

	// Jasmine - MkStr

	public void listingPageElements()
	{
		List<WebElement> icons = driver.findElements(By.xpath("//div[@class='d-flex align-items-center']/child::*"));
		for (int i = 0; i < icons.size(); i++)
		{
			String primaryicons = icons.get(i).getAttribute("class").split("-")[0];
			System.out.println("Icon displayed --> " + primaryicons);
			BaseTest.getTest().log(Status.INFO, "Icons present in the listing page are: " + primaryicons);
		}
		List<WebElement> listingElements = driver.findElements(By.xpath("//div[@class='container']//small"));
		List<WebElement> listingIcons = driver.findElements(By.xpath("//*[@class='status-progress']//i[not (@class='k-icon k-i-plus')]"));
		for (int j = 0; j < listingElements.size(); j++)
		{
			String listele = listingElements.get(j).getText();
			BaseTest.getTest().log(Status.INFO, "Following elements are displayed in the listing page -->" + listele);
			String listIcons = listingIcons.get(j).getAttribute("class").split("-")[1];
			BaseTest.getTest().log(Status.INFO, "Following elements are displayed in the listing page -->" + listIcons);
		}
		if (isDisplayed(CommunicationRepository.communicationListing_pagination) && isDisplayed(CommunicationRepository.communicationListing_itemsperpage))
		{
			BaseTest.getTest().log(Status.INFO, "Pagination and Items per page fields are displayed");
		}

	}

// Mkstr - Jasmine

	public CommunicationListingPage multiStatusVerify(String comName)
	{

		clickElement("Expand plus icon,xpath,//p[.='" + comName + "']/ancestor::tr[contains(@class,'k-master-row')]//a");
		threadSleep(ObjectRepository.wait10sec);
		if (isDisplayed(",xpath,(//div[@class='panel-detail-view'])[1]"))
		{
			System.out.println("Expand scenario is working as working as expected");
		}
		threadSleep(ObjectRepository.wait5sec);
		BaseTest.takeScreenshot();
		List<WebElement> channels = driver.findElements(By.xpath("//*[@class='accordian-body']//tr//td[2]"));
		List<WebElement> status = driver.findElements(By.xpath("//*[@class='accordian-body']//tr//td[3]//i"));

		for (int i = 0; i <= status.size(); i++)
		{
			String channelsDatils = channels.get(i).getText();
			WebElement statusDetails = status.get(i);
			mouseHover(statusDetails);
			threadSleep(ObjectRepository.wait3sec);
			String statusMousehover = getStrText("Listingpage status tooltip,xpath,//div[@class='tooltip-inner']");
			// String statusHover = statusMousehover.getText();

			if (channels.contains("Email") && statusMousehover.toLowerCase().equals("Scheduled"))
			{
				if (channels.contains("SMS") && statusMousehover.toLowerCase().equals("Draft"))
				{
					System.out.println("staus verified email --" + channelsDatils + statusMousehover);
				} else
				{
					System.out.println("status verified fail");
				}
			}

		}
		return this;
	}

	public void authoringPageRetainCheck()
	{
		String smsAuthouringPage = getTextBoxVal("Authouring page disabled,xpath,//div[contains(@class,'box-design')]", "class");
		writeLog(smsAuthouringPage.contains("click-off"), "Aauthouring page is disabled as expected after communication went in progress state", "SMS authouring page is not disabled after communication went in progress state");
		javaScriptScrollIntoView("QR tab,xpath,//li[contains(@class,'tabDefault')][.='QR']");
		threadSleep(ObjectRepository.wait2sec);
		clickElement("Analytics,xpath,//li[contains(@class,'tabDefault')][contains(.,'Analytics')]");
		threadSleep(ObjectRepository.wait20sec);
		pageLoaderLogo();
	}

	public void commListingPageScenarios()
	{
		clickCommunicationTab();
		BaseTest.takeScreenshot();
		isElementAvailable(CommunicationRepository.communicationpage_communicationcreate);
		isElementAvailable(CommunicationRepository.listingpage_gallery);
		isElementAvailable(CommunicationRepository.listingpage_planer);
		clickElement(CommunicationRepository.listingpage_communicationlistingbtn);
		pageLoaderLogo();
		BaseTest.takeScreenshot();
		uiPageEqualswithMultipleInputValue(CommunicationRepository.listingpage_header, "Communication");
		String communicationName = BaseTest.getData().CommunicationName;
		searchCommunicationWithOutMouseHover(communicationName);
		threadSleep(ObjectRepository.wait2sec);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait2sec);
		clickElement("Expand,xpath,//div//..//p[.='" + communicationName + "']//ancestor::tr[contains(@class,'k-master-row')]//a[contains(@aria-label,'Expand')]");
		tabAction();
		pageLoaderLogo();
		BaseTest.takeScreenshot();
		uiPageEqualswithMultipleInputValue("Channel head,xpath,//th[.='Channel']", "Channel");
		uiPageEqualswithMultipleInputValue("Status head,xpath,//th[.='Status']", "Status");
		uiPageEqualswithMultipleInputValue("Action head,xpath,//th[.='Action']", "Action");
		isElementAvailable(CommunicationRepository.listingpage_channelicon);
		isElementAvailable(CommunicationRepository.listingpage_webanalyticsicon);
		clickElement("Collapse,xpath,//div//..//p[.='" + communicationName + "']/ancestor::tr[contains(@class,'k-master-row')]//a[@aria-label='Collapse detail row']");
		pageLoaderLogo();
		isElementAvailable(CommunicationRepository.listingpage_clickcommunicationbtn);
		isElementAvailable("Edit icon,xpath,//p[.='" + communicationName + "']/ancestor::div[contains(@class,'communication-list')]//i[contains(@id,'pencil_edit')]");
		isElementAvailable("Analytics,xpath,//p[.='" + communicationName + "']/ancestor::div[contains(@class,'communication-list')]//i[contains(@id,'Analytics')]");
		isElementAvailable("Archieve,xpath,//p[.='" + communicationName + "']/ancestor::div[contains(@class,'communication-list')]//i[contains(@id,'Archieve')]");
		isElementAvailable("Actions,xpath,//p[.='" + communicationName + "']/ancestor::div[contains(@class,'communication-list')]//i[contains(@id,'arrowdown')]");
		clickElement("Actions,xpath,//p[.='" + communicationName + "']/ancestor::div[contains(@class,'communication-list')]//i[contains(@id,'arrowdown')]");
		isElementAvailable(CommunicationRepository.listingpage_duplicate);
		clickElement("Actions,xpath,//p[.='" + communicationName + "']/ancestor::div[contains(@class,'communication-list')]//i[contains(@id,'arrowdown')]");
		pageLoaderLogo();
		clickElement(CommunicationRepository.listingpage_createcommunication);
		explicitwaitforvisibility(autolocator(CommunicationRepository.listingpage_createcommunicationhead), 20);
		boolean singleDimensionIcon = isElementPresent(CommunicationRepository.communicationpage_singledimen_link);
		writeLog(singleDimensionIcon, "System is navigates to plan page after clicked + icon in listing page.", "System is not navigates to plan page after clicked + icon in listing page.");
		clickCommunicationListpagefromMenu();
		searchCommunicationWithOutMouseHover(communicationName);
		clickElement("Analytics,xpath,//div//..//p[.='" + communicationName + "']/ancestor::tr[contains(@class,'k-master-row')]//i[contains(@id,'Analytics')]");
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait10sec);
		boolean detailsPage = isDisplayed(CommunicationRepository.listingpage_detailspagenavigation);
		writeLog(detailsPage, "System is navigates to Details report page after clicked Analytics button in listing page.", "System is not navigates to Details report page after clicked Analytics button in listing page.");

	}

	public void clickAllCommunication(String communicationType)
	{
		pageLoaderLogo();
		clickElement("My communication,xpath,//button[contains(@class,'dropdown-toggle')][contains(.,'communication')]");
		threadSleep(ObjectRepository.wait3sec);
		selectlistelements("Communications dropdown,xpath,//div[@class='css-scrollbar']//div", communicationType);
		pageLoaderLogo();
		explicitwaitforInvisibility("Communication List,xpath,//thead[@role='presentation']", 30);
	}

	// ----------------------------------------------------------------------------------------------------------------------------------//

	public void pauseEventTriggCommunicationinlistingpage()
	{
		threadSleep(ObjectRepository.wait2sec);
		threadSleep(ObjectRepository.wait2sec);
		clickElement(",xpath,//p[.='" + communicationName + "']//ancestor::td//preceding-sibling::td//a[@aria-label='Expand detail row']");
		pageLoaderLogo();
		if (isElementPresent("play button,xpath,//p[.='" + communicationName + "']//..//..//../../..//i[contains(@class,'play')]"))
		{
			clickElement("play button,xpath,//p[.='" + communicationName + "']//..//..//../../..//i[contains(@class,'play')]");

			clickElement("pause,xpath,//p[.='" + communicationName + "']//..//..//../../..//i[contains(@class,'pause')]");
			String confirmPopUp = getStrText("confirmation header,xpath,//div[@class='modal-content rsmd-content']//p");
			uiPageEqualswithInputValue("Are you sure, you want to pause the communication?", confirmPopUp);
			clickOk();
			pageLoaderLogo();
			threadSleep(ObjectRepository.wait3sec);
			communicationListingPageStatus = getStrText("Status,xpath,//p[.='" + communicationName + "']//ancestor::td//preceding-sibling::div[contains(@class,'communication-content')]//div[contains(@class,'status')]//small");

			if (communicationListingPageStatus.equalsIgnoreCase("paused"))
			{
				uiPageEqualswithInputValue("Paused", communicationListingPageStatus);
				BaseTest.getTest().log(Status.INFO, "Communication status is :<b>" + communicationListingPageStatus + "</b> displayed as Expected");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Communication status is :<b>" + communicationListingPageStatus + "</b> not displayed as Expected");
			}
		}

	}

	public void playEventTriggCommunicationinlistingpage()
	{
		threadSleep(ObjectRepository.wait2sec);
		communicationListingPageStatus = getStrText("Status,xpath,//p[.='" + communicationName + "']//ancestor::td//preceding-sibling::div[contains(@class,'communication-content')]//div[contains(@class,'status')]//small");
		threadSleep(ObjectRepository.wait2sec);
		if (communicationListingPageStatus.equalsIgnoreCase("paused"))
		{
			BaseTest.getTest().log(Status.INFO, "Communication status :" + communicationListingPageStatus);
//		clickElement(",xpath,//p[.='" + communicationName + "']//ancestor::td//preceding-sibling::td//a[@aria-label='Expand detail row']");
			pageLoaderLogo();
			if (isElementPresent("pause button,xpath,//p[.='" + communicationName + "']//..//..//../../..//i[contains(@class,'pause')]"))
			{
				clickElement("pause button,xpath,//p[.='" + communicationName + "']//..//..//../../..//i[contains(@class,'pause')]");

				clickElement("play,xpath,//p[.='" + communicationName + "']//..//..//../../..//i[contains(@class,'play')]");

				String confirmContent = getStrText("Confirm message,xpath,//div[@class='modal-content rsmd-content']//p");
				uiPageEqualswithInputValue("Are you sure, you want to resume the communication?", confirmContent);
				clickOk();
				pageLoaderLogo();
				threadSleep(ObjectRepository.wait3sec);
				communicationListingPageStatus = getStrText("Status,xpath,//p[.='" + communicationName + "']//ancestor::td//preceding-sibling::div[contains(@class,'communication-content')]//div[contains(@class,'status')]//small");
				if (communicationListingPageStatus.equalsIgnoreCase("inprogress"))
				{
					uiPageEqualswithInputValue("In progress", communicationListingPageStatus);
					BaseTest.getTest().log(Status.INFO, "Communication status is :<b>" + communicationListingPageStatus + "</b> displayed as Expected");
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Communication status is :<b>" + communicationListingPageStatus + " </b> not displayed as Expected");
				}
			}
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Communication status:" + communicationListingPageStatus);
		}
	}

	public void stopEventTriggCommunicationinlistingpage()
	{
		threadSleep(ObjectRepository.wait2sec);
		communicationListingPageStatus = getStrText("Status,xpath,//p[.='" + communicationName + "']//ancestor::td//preceding-sibling::div[contains(@class,'communication-content')]//div[contains(@class,'status')]//small");
		threadSleep(ObjectRepository.wait2sec);
		if (communicationListingPageStatus.equalsIgnoreCase("in progress"))
		{
			BaseTest.getTest().log(Status.INFO, "Communication status :" + communicationListingPageStatus);
			clickElement(",xpath,//p[.='" + communicationName + "']//ancestor::td//preceding-sibling::td//a[@aria-label='Expand detail row']");
			pageLoaderLogo();
			if (isElementPresent("play button,xpath,//p[.='" + communicationName + "']//..//..//../../..//i[contains(@class,'play')]"))
			{
				clickElement("play button,xpath,//p[.='" + communicationName + "']//..//..//../../..//i[contains(@class,'play')]");

				clickElement("stop,xpath,//p[.='" + communicationName + "']//..//..//../../..//i[contains(@class,'stop')]");

				String confirmContent = getStrText("Confirm message,xpath,//div[@class='modal-content rsmd-content']//p");
				uiPageEqualswithInputValue("Are you sure, you want to stop the communication?", confirmContent);
				clickOk();
				pageLoaderLogo();
				threadSleep(ObjectRepository.wait3sec);
				communicationListingPageStatus = getStrText("Status,xpath,//p[.='" + communicationName + "']//ancestor::td//preceding-sibling::div[contains(@class,'communication-content')]//div[contains(@class,'status')]//small");
				if (communicationListingPageStatus.equalsIgnoreCase("stopped"))
				{
					uiPageEqualswithInputValue("Stopped", communicationListingPageStatus);
					BaseTest.getTest().log(Status.INFO, "Communication status is :<b>" + communicationListingPageStatus + " </b> displayed as Expected");
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Communication status is :<b>" + communicationListingPageStatus + "</b> not displayed as Expected");
				}
			}
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Communication status:" + communicationListingPageStatus);
		}
	}

	public void commEditAndVerify(String channelName, String communicatioName)
	{
		clickCommunicationListpagefromMenu();
		threadSleep(ObjectRepository.wait10sec);
		explicitwaitforclick(autolocator(AudienceRepository.audience_Filter_Menu), 30);
		clickElement(AudienceRepository.audience_Filter_Menu);
		explicitwaitforclick(autolocator(AudienceRepository.audience_FilterMenu_List), 30);
		selectlistelementsAndProceed(AudienceRepository.audience_FilterMenu_List, "All time");
		communicationName = communicatioName;
		searchCommunication("communicationlisting", communicationName);
		editcommWithName(communicatioName);
		commPlanPageRetainCheck();

		javaScriptScrolltoTop();
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait5sec);
		if (channelName.equalsIgnoreCase("Email"))
		{
			clickElement("Email tab,xpath,//i[@class]/following-sibling::span[contains(.,'Email')]");
		}
		if (channelName.equalsIgnoreCase("sms"))
		{
			clickElement("Email tab,xpath,//i[@class]/following-sibling::span[contains(.,'SMS')]");
		}
		if (channelName.equalsIgnoreCase("WhatsApp"))
		{
			clickElement("Email tab,xpath,//i[@class]/following-sibling::span[contains(.,'WhatsApp')]");
		}
		if (channelName.equalsIgnoreCase("WebPush"))
		{
			clickElement("Email tab,xpath,//i[@class]/following-sibling::span[contains(.,'Web')]");
		}
		if (channelName.equalsIgnoreCase("MobilePush"))
		{
			clickElement("Email tab,xpath,//i[@class]/following-sibling::span[contains(.,'Mobile')]");
		}
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait10sec);
		authoringPageRetainCheck(channelName);
		webAnalyticsPageRetainCheck();
	}

	public void commScheduledEditAndVerify(String channelName, String communicatioName)
	{
		clickCommunicationListpagefromMenu();
		threadSleep(ObjectRepository.wait10sec);
		explicitwaitforclick(autolocator(AudienceRepository.audience_Filter_Menu), 30);
		clickElement(AudienceRepository.audience_Filter_Menu);
		explicitwaitforclick(autolocator(AudienceRepository.audience_FilterMenu_List), 30);
		selectlistelementsAndProceed(AudienceRepository.audience_FilterMenu_List, "All time");
		communicationName = communicatioName;
		searchCommunication("communicationlisting", communicationName);
		editcommWithName(communicatioName);
		ScheduledCommPlanPageRetainCheck();

		javaScriptScrolltoTop();
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait5sec);
		if (channelName.equalsIgnoreCase("Email"))
		{
			clickElement("Email tab,xpath,//i[@class]/following-sibling::span[contains(.,'Email')]");
		}
		if (channelName.equalsIgnoreCase("sms"))
		{
			clickElement("Email tab,xpath,//i[@class]/following-sibling::span[contains(.,'SMS')]");
		}
		if (channelName.equalsIgnoreCase("WhatsApp"))
		{
			clickElement("Email tab,xpath,//i[@class]/following-sibling::span[contains(.,'WhatsApp')]");
		}
		if (channelName.equalsIgnoreCase("WebPush"))
		{
			clickElement("Email tab,xpath,//i[@class]/following-sibling::span[contains(.,'Web')]");
		}
		if (channelName.equalsIgnoreCase("MobilePush"))
		{
			clickElement("Email tab,xpath,//i[@class]/following-sibling::span[contains(.,'Mobile')]");
		}

		pageLoaderLogo();
		threadSleep(ObjectRepository.wait10sec);
		ScheduledCommauthoringPageRetainCheck(channelName);
		ScheduledCommauthoringwebAnalyticsPageRetainCheck();
	}

	public void commPlanPageRetainCheck()
	{
		String CommunicationName = getTextBoxVal("Communication name,xpath,//div[contains(@class,'form-group')][contains(.,'Communication name')]", "class");

		String CommunicationType = getTextBoxVal("Communication type,xpath,//div[contains(@class,'form-group')][contains(.,'Communication type')]", "class");
		// javaScriptScrollDownToSomeExtend();

		String ProductType = getTextBoxVal("Product type,xpath,//div[contains(@class,'form-group')][contains(.,'Product type')]", "class");

		String PrimaryGoal = getTextBoxVal("Primary Goal,xpath,//div[contains(@class,'form-group')][contains(.,'Primary goal')]", "class");

		String ROIButton = getTextBoxVal("ROI Button,xpath,//div[contains(@class,'form-group')][contains(.,'ROI')]", "class");

		writeLog(CommunicationName.contains("click-off"), "Communication Name dropdown field is disabled as expected", "Communication Name dropdown field is not disabled");

		writeLog(CommunicationType.contains("click-off"), "Communication type dropdown field is disabled as expected", "Communication type dropdown field is not disabled");

		writeLog(ProductType.contains("click-off"), "Product type dropdown field is disabled as expected", "Product type dropdown field is not disabled");

		writeLog(PrimaryGoal.contains("click-off"), "Primary Goal dropdown field is disabled as expected", "Primary Goal dropdown field is not disabled");

		writeLog(ROIButton.contains("click-off"), "ROI Button field is disabled as expected", "ROI Button field is not disabled");

		javaScriptScrollDownToSomeExtend();
		String startDate = getTextBoxVal("Start date,xpath,//div[contains(@class,'form-group')][contains(.,'Communication period')]//span[contains(@class,'startdate')]/../..", "class");
		writeLog(startDate.contains("click-off"), "Start date is disabled as expected", "Statr date is not disabled");
		String endDate = getTextBoxVal("End date,xpath,//div[contains(@class,'form-group')][contains(.,'Communication period')]//span[contains(@class,'enddate')]/../../..", "class");
		writeLog(!endDate.contains("click-off"), "End date is not disabled as expected", "End date is disabled");
		javaScriptScrollDown();
		writeLog(isElementPresent("Channel type disbale,xpath,//div[contains(@class,'form-group')][contains(.,'Channel type')]"), "Channel types is disabled as expected", "Channel types is not disabled");
		writeLog(isElementPresent("Analytics type,xpath,//div[contains(@class,'form-group')][contains(.,'Analytics type')]"), "Analytics types is disabled as expected", "Analytics types is not disabled");

		clickElement("Next button,xpath,//button[contains(.,'Next')]");
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait20sec);
		explicitwaitforvisibility(autolocator("Authouring page,xpath,//div[contains(@class,'list-group-steps')]"), 30);
	}

	public void ScheduledCommPlanPageRetainCheck()
	{

		String CommunicationName = getTextBoxVal("Communication name,xpath,//div[contains(@class,'form-group')][contains(.,'Communication name')]", "class");

		String CommunicationType = getTextBoxVal("Communication type,xpath,//div[contains(@class,'form-group')][contains(.,'Communication type')]", "class");
		// javaScriptScrollDownToSomeExtend();

		String ProductType = getTextBoxVal("Product type,xpath,//div[contains(@class,'form-group')][contains(.,'Product type')]", "class");

		String PrimaryGoal = getTextBoxVal("Primary goal,xpath,//div[contains(@class,'form-group')][contains(.,'Primary goal')]", "class");

		String ROIButton = getTextBoxVal("ROI Button,xpath,//div[contains(@class,'form-group')][contains(.,'ROI')]", "class");

		writeLog(!CommunicationName.contains("click-off"), "Communication Name dropdown field is Enabled as expected", "Communication Name dropdown field is not Enabled");

		writeLog(!CommunicationType.contains("click-off"), "Communication type dropdown field is Enabled as expected", "Communication type dropdown field is not Enabled");

		writeLog(!ProductType.contains("click-off"), "Product type dropdown field is Enabled as expected", "Product type dropdown field is not Enabled");

		writeLog(!PrimaryGoal.contains("click-off"), "Primary Goal dropdown field is Enabled as expected", "Primary Goal dropdown field is not Enabled");

		writeLog(!ROIButton.contains("click-off"), "ROI Button field is Enabled as expected", "ROI Button field is not Enabled");

		javaScriptScrollDownToSomeExtend();

//		writeLog(isElementPresent(
//				"communication name enable,xpath,//div[contains(@class,'form-group')][contains(.,'Communication name')]"),
//				"Communication name field is enabled as expected", "Communication name field is not enabled");
//		writeLog(isElementPresent(
//				"Communicatiob type enable,xpath,//div[contains(@class,'form-group')][contains(.,'Communication type')]"),
//				"Communication type dropdown field is enabled as expected",
//				"Communication type dropdown field is not enabled");
//		writeLog(
//				isElementPresent(
//						"Product type enable,xpath,//div[contains(@class,'form-group')][contains(.,'Product type')]"),
//				"Product type/sub product type dropdown field is enabled as expected",
//				"Product type/sub product type dropdown field is not enabled.");
//		javaScriptScrollDownToSomeExtend();
//		writeLog(
//				isElementPresent(
//						"Primary goal enable,xpath,//div[contains(@class,'form-group')][contains(.,'Primary goal')]"),
//				"Primary goal dropdown field is enabled as expected", "Primary goal dropdown field is not enabled.");
//		writeLog(isElementPresent("ROI button,xpath,//div[contains(@class,'form-group')][contains(.,'ROI')]"),
//				"ROI toggle button is enabled as expected", "ROI toggle button is not enabled as expected");
		String startDate = getTextBoxVal("Start date,xpath,//div[contains(@class,'form-group')][contains(.,'Communication period')]//span[contains(@class,'startdate')]/../..", "class");
		writeLog(!startDate.contains("click-off"), "Start date is enabled as expected", "Statr date is not enabled");
		String endDate = getTextBoxVal("End date,xpath,//div[contains(@class,'form-group')][contains(.,'Communication period')]//span[contains(@class,'enddate')]/../../..", "class");
		writeLog(!endDate.contains("click-off"), "End date is not disabled as expected", "End date is disabled");
		javaScriptScrollDown();
		writeLog(isElementPresent("Channel type enable,xpath,//div[contains(@class,'form-group')][contains(.,'Channel type')]"), "Channel types is enable as expected", "Channel types is not enable");
		writeLog(isElementPresent("Analytics type,xpath,//div[contains(@class,'form-group')][contains(.,'Analytics type')]"), "Analytics types is enable as expected", "Analytics types is not enable");

		if (getStrText(CommunicationRepository.communicationemail_comm_commtype).equalsIgnoreCase(BaseTest.getData().CommunicationType))
		{
			BaseTest.getTest().log(Status.FAIL, "The Duplicated Communication Type '" + BaseTest.getData().CommunicationType + "' Differs from its input");
			BaseTest.takeScreenshot();
		}
		if (getStrText(CommunicationRepository.communicationemail_comm_prodtype).equalsIgnoreCase(BaseTest.getData().ProductType))
		{
			BaseTest.getTest().log(Status.FAIL, "The Duplicated Product Type  '" + BaseTest.getData().ProductType + "' Differs from its input");
			BaseTest.takeScreenshot();
		}
		if (getStrText(CommunicationRepository.communicationemail_comm_primarygoal).equalsIgnoreCase(BaseTest.getData().PrimaryGoal))
		{
			BaseTest.getTest().log(Status.FAIL, "The Duplicated Primary Goal  '" + BaseTest.getData().PrimaryGoal + "' Differs from its input");
			BaseTest.takeScreenshot();
		}

		if (isSelected(CommunicationRepository.communicationpage_channel_type1))
		{
			BaseTest.getTest().log(Status.INFO, "The selected channel type is Email");
		}
		if (isSelected(CommunicationRepository.communicationpage_channel_type2))
		{
			BaseTest.getTest().log(Status.INFO, "The selected channel type is Messaging");
		}
		if (isSelected(CommunicationRepository.communicationpage_channel_type3))
		{
			BaseTest.getTest().log(Status.INFO, "The selected channel type is Social Post");
		}
		if (isSelected(CommunicationRepository.communicationpage_channel_QR))
		{
			BaseTest.getTest().log(Status.INFO, "The selected channel type is QR");
		}
		if (isSelected(CommunicationRepository.communicationpage_channel_type5))
		{
			BaseTest.getTest().log(Status.INFO, "The selected channel type is Notification");
		}
		if (isSelected(CommunicationRepository.communicationpage_channel_type6))
		{
			BaseTest.getTest().log(Status.INFO, "The selected channel type is Paid Ads");
		}
		if (isSelected(CommunicationRepository.communicationpage_channel_type7))
		{
			BaseTest.getTest().log(Status.INFO, "The selected channel type is Voice");

		}

		if (isSelected(CommunicationRepository.communicationpage_analytics_option1))
		{
			BaseTest.getTest().log(Status.INFO, "The selected Analytic type is Web");
		}

		if (isSelected(CommunicationRepository.communicationpage_analytics_option3))
		{
			BaseTest.getTest().log(Status.INFO, "The selected Analytic type is APP");
		}
		if (isSelected(CommunicationRepository.communicationpage_analytics_option4))
		{
			BaseTest.getTest().log(Status.INFO, "The selected Analytic type is Sentiment");
		}

		clickElement("Next button,xpath,//button[contains(.,'Next')]");
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait20sec);
		explicitwaitforvisibility(autolocator("Authouring page,xpath,//div[contains(@class,'list-group-steps')]"), 30);
	}

	public void authoringPageRetainCheck(String channelName)
	{

		String AuthouringPageAudienceBox = "";
		String AuthouringPageCommSubLine = "";
		String AuthouringPageScheduleDate = "";
		String AuthouringPageTestComm = "";

		if (channelName == "Email")
		{
			AuthouringPageAudienceBox = getTextBoxVal("Authouring page Audience disable,xpath,//div[contains(@class,'box-design')]//div[.='Audience']//..//div[contains(@class,' click-off')][1]", "class");

			writeLog(AuthouringPageAudienceBox.contains("click-off"), "Authouring page Audience is disabled as expected after communication went in progress state",
					"Authouring page Audience is not disabled after communication went in progress state");

			AuthouringPageCommSubLine = getTextBoxVal("Authouring page Subject line disabled,xpath,//div[contains(@class,'box-design')]//div[.='Subject line']//..//div[contains(@class,' click-off')][1]", "class");

			writeLog(AuthouringPageCommSubLine.contains("click-off"), "Authouring page Subject line is disabled as expected after communication went in progress state",
					"Authouring page Subject line is not disabled after communication went in progress state");

			AuthouringPageScheduleDate = getTextBoxVal("Authouring page schedule date disabled,xpath,(//div[contains(@class,'box-design')]//label[.='Schedule']//..//..//..//..//..//..//div[contains(@class,'click-off')])[11]", "class");

			writeLog(AuthouringPageScheduleDate.contains("click-off"), "Authouring page schedule date is disabled as expected after communication went in progress state",
					"Authouring page schedule date is not disabled after communication went in progress state");

			AuthouringPageTestComm = getTextBoxVal("Authouring page Test communication disabled,xpath,//div[contains(@class,'box-design')]//div[.='Test email']//..//div[contains(@class,' click-off')][1]", "class");

			writeLog(AuthouringPageTestComm.contains("click-off"), "Authouring page Test communication is disabled as expected after communication went in progress state",
					"Authouring page Test communication is not disabled after communication went in progress state");

		}
		if (channelName == "SMS")
		{
			String smsAuthouringPage = getTextBoxVal("Authouring page disabled,xpath,//div[contains(@class,'box-design')]", "class");
			writeLog(smsAuthouringPage.contains("click-off"), "Authouring page is disabled as expected after communication went in progress state", "SMS authouring page is not disabled after communication went in progress state");
		}
		if (channelName == "Whatsapp")
		{
			String WhatsAppAuthouringPage = getTextBoxVal("Authouring page disabled,xpath,//div[contains(@class,'box-design')]", "class");
			writeLog(WhatsAppAuthouringPage.contains("click-off"), "Authouring page is disabled as expected after communication went in progress state", "Whatsapp authouring page is not disabled after communication went in progress state");
		}
		if (channelName == "Webpush")
		{

			String WebpushAuthouringPage = getTextBoxVal("Authouring page disabled,xpath,//div[contains(@class,'box-design')]", "class");
			writeLog(WebpushAuthouringPage.contains("click-off"), "Authouring page is disabled as expected after communication went in progress state", "Webpush authouring page is not disabled after communication went in progress state");

		}
		if (channelName == "Mobilepush")
		{

			String WebpushAuthouringPage = getTextBoxVal("Authouring page disabled,xpath,//div[contains(@class,'box-design')]", "class");
			writeLog(WebpushAuthouringPage.contains("click-off"), "Authouring page is disabled as expected after communication went in progress state", "Mobilepush authouring page is not disabled after communication went in progress state");
		}

		javaScriptScrollIntoView("Test Comm,xpath,//li[contains(@class,'tabDefault')][contains(.,'QR')]");
		threadSleep(ObjectRepository.wait2sec);
		clickElement("Analytics,xpath,//li[contains(@class,'tabDefault')][contains(.,'Analytics')]");
		threadSleep(ObjectRepository.wait20sec);
		pageLoaderLogo();
	}

	public void ScheduledCommauthoringPageRetainCheck(String channelName)
	{

		String AuthouringPageAudienceBox = "";
		String AuthouringPageCommSubLine = "";
		String AuthouringPageScheduleDate = "";
		String AuthouringPageTestComm = "";

		if (channelName == "Email")
		{
			AuthouringPageAudienceBox = getTextBoxVal("Authouring page Audience disable,xpath,//div[contains(@class,'box-design')]//div[.='Audience']//..//div[contains(@class,'position-relative')][1]", "class");

			writeLog(!AuthouringPageAudienceBox.contains("click-off"), "Authouring page Audience is Enabled as expected after communication went Scheduled state",
					"SMS authouring page Audience is not Enabled after communication went Scheduled state");

			AuthouringPageCommSubLine = getTextBoxVal("Authouring page Subject line disabled,xpath,//div[contains(@class,'box-design')]//div[.='Subject line']//..//div[contains(@class,'position-relative')][1]", "class");

			writeLog(!AuthouringPageCommSubLine.contains("click-off"), "Authouring page Subject line is Enabled as expected after communication went Scheduled state",
					"Authouring page Subject line is not Enabled after communication went Scheduled state");

			AuthouringPageScheduleDate = getTextBoxVal("Authouring page schedule date disabled,xpath,(//div[contains(@class,'box-design')]//label[.='Schedule']//..//..//input)[1]", "aria-disabled");

			writeLog(AuthouringPageScheduleDate.contains("false"), "Authouring page schedule date is Enabled as expected after communication went Scheduled state",
					"SMS authouring page schedule date is not Enabled after communication went Scheduled state");

			AuthouringPageTestComm = getTextBoxVal("Authouring page Test communication disabled,xpath,//div[contains(@class,'box-design')]//div[.='Test email']//..//div[contains(@class,'position-relative')][1]", "class");

			writeLog(!AuthouringPageTestComm.contains("click-off"), "Authouring page Test communication is Enabled as expected after communication went Scheduled state",
					"SMS authouring page Test communication is not Enabled after communication went Scheduled state");
		}
		if (channelName == "SMS")
		{
			String smsAuthouringPage = getTextBoxVal("Authouring page disabled,xpath,//div[contains(@class,'box-design')]", "class");
			writeLog(smsAuthouringPage.contains("click-off"), "Aauthouring page is Enabled as expected after communication went Scheduled state", "SMS authouring page is not Enabled after communication went Scheduled state");
		}
		if (channelName == "Whatsapp")
		{
			String smsAuthouringPage = getTextBoxVal("Authouring page disabled,xpath,//div[contains(@class,'box-design')]", "class");
			writeLog(smsAuthouringPage.contains("click-off"), "Aauthouring page is Enabled as expected after communication went Scheduled state", "SMS authouring page is not Enabled after communication went Scheduled state");
		}
		if (channelName == "Webpush")
		{
			String smsAuthouringPage = getTextBoxVal("Authouring page disabled,xpath,//div[contains(@class,'box-design')]", "class");
			writeLog(smsAuthouringPage.contains("click-off"), "Aauthouring page is Enabled as expected after communication went Scheduled state", "SMS authouring page is not Enabled after communication went Scheduled state");
		}
		if (channelName == "Mobilepush")
		{
			String smsAuthouringPage = getTextBoxVal("Authouring page disabled,xpath,//div[contains(@class,'box-design')]", "class");
			writeLog(smsAuthouringPage.contains("click-off"), "Aauthouring page is Enabled as expected after communication went Scheduled state", "SMS authouring page is not Enabled after communication went Scheduled state");
		}

		javaScriptScrollIntoView("Test Comm,xpath,//div[contains(@class,'box-design')]//div[.='Subject line']//..//div[contains(@class,'position-relative')][1]");
		threadSleep(ObjectRepository.wait2sec);
		clickElement("Analytics,xpath,//li[contains(@class,'tabDefault')][contains(.,'Analytics')]");
		threadSleep(ObjectRepository.wait20sec);
		pageLoaderLogo();
	}

	public void webAnalyticsPageRetainCheck()
	{
		String analyticsPage = getTextBoxVal("Sms authoring  page disabled,xpath,//div[contains(@class,'box-design')]", "class");
		writeLog(analyticsPage.contains("click-off"), "Web analytics page is Disabled as expected after communication went In progress state", "Web analytics page is not Disabled after communication went In progress state");
		javaScriptScrollDown();
	}

	public void ScheduledCommauthoringwebAnalyticsPageRetainCheck()
	{
		String analyticsPage = getTextBoxVal("Sms authoring  page disabled,xpath,//div[contains(@class,'box-design')]", "class");
		writeLog(!analyticsPage.contains("click-off"), "Web analytics page is Enabled as expected after communication went Scheduled state", "Web analytics page is not Enabled after communication went Scheduled state");
		javaScriptScrollDown();
	}
}