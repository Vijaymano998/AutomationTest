package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import repository.AudienceRepository;
import repository.CommunicationRepository;
import repository.DashboardRepository;
import repository.ObjectRepository;
import repository.OtpRepository;
import repository.PreferencesRepository;
import utility.BaseTest;
import utility.PageFactory;

public class HomePage extends OtpPage
{

	public HomePage(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	private LoginPage clickLogoutaccept()
	{
		threadSleep(ObjectRepository.wait3sec);
		clickElement(DashboardRepository.homepage_logout_accept);
		return getPageFactory().loginPage();
	}

	public LoginPage logout()
	{
		threadSleep(ObjectRepository.wait5sec);
		explicitwaitforclick(autolocator(DashboardRepository.homepage_logout_link), 30);
		clickElement(DashboardRepository.homepage_logout_link);
		return clickLogoutaccept();
	}

	public void selectbusinessunit()
	{
		boolean flag = false;
		pageLoaderLogo();
		try
		{
			pageLoaderLogo();
			explicitwaitforclick(autolocator(DashboardRepository.homepage_businessUnit_click), 60);
			pageLoaderLogo();
			clickElement(DashboardRepository.homepage_businessUnit_click);

			List<WebElement> sources = findElements(DashboardRepository.homepage_businessUnit_select);
			for (WebElement uiSource : sources)
			{
				String lowerCase = uiSource.getText();
				if (lowerCase.contains(BaseTest.getData().BU))
				{
					if (uiSource.getAttribute("class").contains("active"))
					{
						clickElement(DashboardRepository.homepage_businessUnit_click);
						BaseTest.getTest().log(Status.INFO, BaseTest.getData().BU + " bu is already active.");
					} else
					{
						uiSource.click();
						BaseTest.getTest().log(Status.INFO, BaseTest.getData().BU + " bu selected successfully.");
					}
					flag = true;
					break;
				}
			}
			if (!flag)
			{
				BaseTest.getTest().log(Status.FAIL, BaseTest.getData().BU + " bu not able to selected. Please provide valid source");
				BaseTest.takeScreenshot();
			}
		} catch (Exception e)
		{
			BaseTest.getTest().log(Status.FAIL, "Bussiness unit option not available");
		}
	}

	public void pw_selectbusinessunit()
	{
		boolean flag = false;
		pw_pageLoaderLogo();
		try
		{
			pw_pageLoaderLogo();
			pw_clickElement(DashboardRepository.pw_homepage_businessUnit_click);
			Locator sources = pw_findelements(DashboardRepository.pw_homepage_businessUnit_select);
			for (int i = 0; i < sources.count(); i++)
			{
				String lowerCase = sources.nth(i).textContent();
				if (lowerCase.contains(BaseTest.getData().BU))
				{
					if (sources.nth(i).getAttribute("class").contains("active"))
					{
						pw_clickElement(DashboardRepository.pw_homepage_businessUnit_click);
						BaseTest.getTest().log(Status.INFO, BaseTest.getData().BU + " bu is already active.");
					} else
					{
						sources.nth(i).click();
						BaseTest.getTest().log(Status.INFO, BaseTest.getData().BU + " bu selected successfully.");
					}
					flag = true;
					break;
				}
			}
			if (!flag)
			{
				BaseTest.getTest().log(Status.FAIL, BaseTest.getData().BU + " bu not able to selected. Please provide valid source");
				BaseTest.takeScreenshot();
			}
		} catch (Exception e)
		{
			BaseTest.getTest().log(Status.FAIL, "Bussiness unit option not available");
		}
		pw_pageLoaderLogo();
	}

	public void companyName()
	{
		pageLoaderLogo();
		explicitwaitforvisibility(autolocator(DashboardRepository.homepage_dashboard_Dashboardlink), 90);
		BaseTest.getTest().info(MarkupHelper.createLabel("RESULTICKS DASHBOARD", ExtentColor.INDIGO));
		try
		{
			clickElement(DashboardRepository.hompage_companyname_click);
			if (!selectlistelements(DashboardRepository.homepage_companyname_select, BaseTest.getData().CompanyName))
			{
				BaseTest.takeScreenshot();
			}
			threadSleep(ObjectRepository.wait2sec);
			pageLoaderLogo();
		} catch (Exception e)
		{
			BaseTest.getTest().log(Status.FAIL, "Company name option not available");
		}
		threadSleep(ObjectRepository.wait2sec);
	}

	public void selectAllTimeDateRangeFilter()
	{
		threadSleep(ObjectRepository.wait2sec);
		clickElement(DashboardRepository.datefilter);
		selectlistelements(DashboardRepository.dateFilterlist, "All time");
		threadSleep(ObjectRepository.wait2sec);
	}

	// Select Audience Link from main menu
	public HomePage clickAudiencelink()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("AUDIENCE MODULE", ExtentColor.INDIGO));
		toolTipValidationKnownText(DashboardRepository.homepage_audiencelinkclick, "Audience");
		explicitwaitforclick(autolocator(DashboardRepository.homepage_audiencelinkclick), 150);
		clickElement(DashboardRepository.homepage_audiencelinkclick);
		threadSleep(ObjectRepository.wait2sec);
		pageLoaderLogo();
		return this;
	}

	// Select Audience Upload from the menu
	public AudiencePage_Upload clickAudienceMasterdatafromMenu()
	{
		pageLoaderLogo();
		clickAudiencelink();
		pageLoaderLogo();
		explicitwaitforclick(autolocator(DashboardRepository.homepage_audience_Masterdatamanagement), 150);
		clickElement(DashboardRepository.homepage_audience_Masterdatamanagement);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait2sec);
		pageLoaderLogo();
		BaseTest.getTest().info(MarkupHelper.createLabel("AUDIENCE MASTERDATA MANAGEMENT ", ExtentColor.INDIGO));
		List<WebElement> breadcrumbList = findElements(DashboardRepository.breadcrumblistitem);
		writeLog(breadcrumbList.get(1).getText().trim().equals("Audience"), "BreadCrumb 'Audience' name is present as expected.", "BreadCrumb 'Audience' name is not-present as expected.");
		WebElement activeBreadCrumb = breadcrumbList.get(2);
		writeLog(activeBreadCrumb.getText().equals("Master data") && activeBreadCrumb.getAttribute("class").equals("active"), "Breadcrumb status is active.", "Breadcrumb status is not active.");
		pageLoaderLogo();
		return getPageFactory().audiencepage_Upload();
	}

	public void validateBreadcrumb(String... breadcrumbs)
	{
		List<WebElement> breadcrumbList = findElements(DashboardRepository.breadcrumblistitem);
		writeLog(breadcrumbList.get(1).getText().trim().equals("Audience"), "BreadCrumb 'Audience' name is present as expected.", "BreadCrumb 'Audience' name is not-present as expected.");
		WebElement activeBreadCrumb = breadcrumbList.get(2);
		writeLog(activeBreadCrumb.getText().equals("Master data") && activeBreadCrumb.getAttribute("class").equals("active"), "Breadcrumb status is active.", "Breadcrumb status is not active.");
	}

	public void getTotalAudienceCountFromMDM()
	{
		clickAudienceMasterdatafromMenu();
		threadSleep(ObjectRepository.wait5sec);
		pageLoaderLogo();
		BaseTest.takeScreenshot();
		MDMTotalAudience = getStrText(AudienceRepository.audience_masterdata_totalchannelvalue).replaceAll(",", "");
		System.out.println(MDMTotalAudience);
	}

	// Click preferences from home or dashboard page
	public PreferencesPage clickPreferencePagefromMenu()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("PREFERENCES MODULE ", ExtentColor.INDIGO));
		explicitwaitforclick(autolocator(DashboardRepository.homepage_preferencespage_home), 60);
		pageLoaderLogo();
		clickElement(DashboardRepository.homepage_preferencespage_home);
		isDisplayed(PreferencesRepository.preferences_validation);
		pageLoaderLogo();
		return getPageFactory().preferencesPage();
	}

	// ***************************************************************************************

	// Communication link click from dashboard menu - MKSTRT
	public HomePage clickCommunicationTab()
	{
		explicitwaitforclick(autolocator(DashboardRepository.homepage_communication_link), 40);
		clickElement(DashboardRepository.homepage_communication_link);
		threadSleep(ObjectRepository.wait3sec);
		return this;
	}

	// Click on Communication list page
	public CommunicationListingPage clickCommunicationListpagefromMenu()
	{
		clickCommunicationTab();
		clickElement(DashboardRepository.homepage_dashboard_Communicationlist);
		BaseTest.getTest().info(MarkupHelper.createLabel("COMMUNICATION LISTING PAGE ", ExtentColor.BLUE));
		pageLoaderLogo();
		explicitwaitforInvisibility("Communication List,xpath,//thead[@role='presentation']", 30);
		return getPageFactory().communicationListingPage();
	}

	public CommunicationListingPage clickCommunicationGallerypagefromMenu()
	{
		clickCommunicationTab();
		clickElement(DashboardRepository.homepage_dashboard_CommunicationGallery);
		pageLoaderLogo();
		BaseTest.getTest().info(MarkupHelper.createLabel("COMMUNICATION GALLERY PAGE ", ExtentColor.BLUE));
		return getPageFactory().communicationListingPage();

	}

	public CommunicationListingPage clickCommunicationPlannerpagefromMenu()
	{
		clickCommunicationTab();
		clickElement(DashboardRepository.homepage_dashboard_CommunicationPlanner);
		BaseTest.getTest().info(MarkupHelper.createLabel("COMMUNICATION GALLERY PAGE ", ExtentColor.BLUE));
		return getPageFactory().communicationListingPage();

	}

	public CommunicationListingPage clickCommAnalyticsTab()
	{
		explicitwaitforclick(autolocator(DashboardRepository.homepage_allmenu_analyticslink), 40);
		clickElement(DashboardRepository.homepage_allmenu_analyticslink);
		return getPageFactory().communicationListingPage();
	}

	public void pw_clickCommAnalyticsTab()
	{
		pw_clickElement(DashboardRepository.pw_homepage_allmenu_analyticslink);
	}

	// Analytics Page
	public void clickCommAnalyticsListingPagefromMenu()
	{
		threadSleep(ObjectRepository.wait5sec);
		clickCommAnalyticsTab();
		selectlistelements(DashboardRepository.homepage_analytics_options, "Communication analytics");
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait5sec);
		BaseTest.getTest().info(MarkupHelper.createLabel("COMMUNICATION ANALYTICS LISTING PAGE ", ExtentColor.INDIGO));
		BaseTest.takeScreenshot();
	}

	public void pw_clickCommAnalyticsListingPagefromMenu()
	{
		threadSleep(ObjectRepository.wait5sec);
		pw_clickCommAnalyticsTab();
		pw_selectlistelements(DashboardRepository.pw_analyticsListingoptions, "Communication analytics");
		pw_pageLoaderLogo();
		threadSleep(ObjectRepository.wait5sec);
		BaseTest.getTest().info(MarkupHelper.createLabel("COMMUNICATION ANALYTICS LISTING PAGE ", ExtentColor.INDIGO));
		BaseTest.pw_takesScreenshot();
	}

	public AudiencePage_Targetlist clickTargetlistfromMenu()
	{
		clickAudiencelink();
		threadSleep(ObjectRepository.wait1sec);
		clickElement(DashboardRepository.homepage_audience_Targetlist);
		BaseTest.getTest().info(MarkupHelper.createLabel("AUDIENCE TARGET LIST PAGE ", ExtentColor.INDIGO));
		threadSleep(ObjectRepository.wait2sec);
		pageLoaderLogo();
		return getPageFactory().audiencepage_Targetlist();
	}

	public AudiencePage_Targetlist clickDynamiclistfromMenu()
	{
		clickAudiencelink();
		threadSleep(ObjectRepository.wait1sec);
		clickElement(DashboardRepository.homepage_audience_Dynamiclist);
		BaseTest.getTest().info(MarkupHelper.createLabel("AUDIENCE DYNAMIC LISTING PAGE ", ExtentColor.INDIGO));
		threadSleep(ObjectRepository.wait1sec);
		pageLoaderLogo();
		return getPageFactory().audiencepage_Targetlist();
	}

	public CommunicationListingPage clickCommAnalytics360fromMenu()
	{
		threadSleep(ObjectRepository.wait5sec);
		clickCommAnalyticsTab();
		explicitwaitforpresence(autolocator(DashboardRepository.homepage_allmenu_communicationanalytics360), 50);
		clickElement(DashboardRepository.homepage_allmenu_communicationanalytics360);
		threadSleep(ObjectRepository.wait5sec);
		BaseTest.getTest().info(MarkupHelper.createLabel("AUDIENCE ANALYTICS 360 ", ExtentColor.INDIGO));
		return getPageFactory().communicationListingPage();
	}

	public CommunicationListingPage clickLogReportfromMenu()
	{
		threadSleep(ObjectRepository.wait5sec);
		clickCommAnalyticsTab();
		explicitwaitforpresence(autolocator(DashboardRepository.homepage_allmenu_auditLog), 50);
		clickElement(DashboardRepository.homepage_allmenu_auditLog);
		threadSleep(ObjectRepository.wait5sec);
		BaseTest.getTest().info(MarkupHelper.createLabel("AUDIT LOG REPORT PAGE ", ExtentColor.INDIGO));
		return getPageFactory().communicationListingPage();
	}

	public HomePage clickDashboardTab()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("DASHBOARD", ExtentColor.INDIGO));
		pageLoaderLogo();
		explicitwaitforclick(autolocator(DashboardRepository.homepage_dashboard_link), 40);
		selectbusinessunit();
		clickElement(DashboardRepository.homepage_dashboard_link);
		pageLoaderLogo();
		isDisplayed(DashboardRepository.homepage_dashboard_carousel);
		return this;
	}

	// OTP can enter all pages otp popup
	public HomePage enterOTPAndSubmit(String otp, String val)
	{
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforclick(autolocator(OtpRepository.otpPage_enterOTP), 30);
		clickElement(OtpRepository.otpPage_enterOTP);
		sendvalueAndTabAction(driver, OtpRepository.otpPage_enterOTP, otp);
		threadSleep(ObjectRepository.wait3sec);
		if (val.toLowerCase().contains("target") || val.toLowerCase().contains("catalogue") || val.toLowerCase().contains("communication"))
		{
			if (!getTextBoxVal(OtpRepository.otppage_confirmbtn, "class").contains("click-off"))
			{
				clickElement(OtpRepository.otppage_confirmbtn);
			} else
			{
				BaseTest.getTest().log(Status.WARNING, "Entered Invalid OTP");
			}

		} else if (val.toLowerCase().contains("form"))
		{
			clickElement(DashboardRepository.preferences_formsubmit_click);
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Unable to click on OTP Submit button");
		}
		BaseTest.takeScreenshot();
		threadSleep(ObjectRepository.wait1sec);
		return this;
	}

	public HomePage entersOTPAndSubmit(String otp, String val)
	{
		String[] otpsplit = otp.split("");
		threadSleep(ObjectRepository.wait3sec);

		List<WebElement> otpSession = findElements(",xpath,//input[@id='first']|//input[@id='second']|//input[@id='third']|//input[@id='fourth']|//input[@id='fifth']|//input[@id='sixth']");
		for (int i = 0; i < otpSession.size(); i++)
		{
			otpSession.get(i).sendKeys(otpsplit[i]);
		}
		if (val.toLowerCase().contains("target") || val.toLowerCase().contains("catalogue") || val.toLowerCase().contains("communication") || val.toLowerCase().contains("accsetup"))
		{
			threadSleep(ObjectRepository.wait1sec);
			pageLoaderLogo();
			if (!getTextBoxVal(OtpRepository.otppage_confirmbtn, "class").contains("click-off"))
			{
				clickElement(OtpRepository.otppage_confirmbtn);
			} else
			{
				BaseTest.getTest().log(Status.WARNING, "Entered Invalid OTP");
			}
		} else if (val.toLowerCase().contains("form"))
		{
			clickElement(DashboardRepository.preferences_formsubmit_click);
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Unable to click on OTP Submit button");
		}
		BaseTest.takeScreenshot();
		threadSleep(ObjectRepository.wait1sec);
		return this;
	}

	public HomePage sendOTPtoEmailId()
	{
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforclick(autolocator(OtpRepository.otpPage_sentto), 30);
		clickElement(OtpRepository.otpPage_sentto);
		selectlistelements(OtpRepository.otpPage_sendtoList, "Email Id");
		threadSleep(ObjectRepository.wait3sec);
		try
		{
			explicitwaitforvisibility(autolocator(DashboardRepository.analytics_comm_otpmsg), 15);
			isDisplayed(DashboardRepository.analytics_comm_otpmsg);
		} catch (Throwable e)
		{
			BaseTest.getTest().log(Status.WARNING, "OTP sent successfully message not showing");
			BaseTest.takeScreenshot();
		}
		return this;
	}

	// Ok Popuop
	public HomePage clickOKPopupAfterOTPSubmit()
	{
		explicitwaitforvisibility(autolocator(DashboardRepository.preferences_dataattribute_selectok), 10);
		clickElement(DashboardRepository.preferences_dataattribute_selectok);
		return this;
	}

	public void accessMyProfile()
	{
		clickElement(DashboardRepository.homepage_myprofile);
		pageLoaderLogo();
		String myProfileUrl = "https://run.marketingstar.us/preferences/my-profile";
		BaseTest.getTest().info(MarkupHelper.createLabel("MY PROFILE PAGE", ExtentColor.INDIGO));
		if (urlCheck(myProfileUrl))
		{
			uiPageEqualswithInputValue("My profile header,xpath,//h1[@class='header-title-margin']", "My profile");
			uiPageEqualswithInputValue("My profile sub headers,xpath,//h4", "Personal details,Localization details");
			isElementAvailable("My profile image,xpath,//input[@name='uploaded_file']");
		}
	}

	public void accessAudiencePage()
	{
		clickAudiencelink();
		String audiencePageUrl = "https://run.marketingstar.us/audience";
		if (urlCheck(audiencePageUrl))
		{
			if (isElementAvailable(PreferencesRepository.allmainmenus_module_header))
			{
				uiPageEqualswithInputValue(PreferencesRepository.allmainmenus_module_header, "Audience");
				isElementAvailable(PreferencesRepository.allmainmenus_table);
				isElementAvailable(PreferencesRepository.allmainmenus_addaudience_btn);
			} else
			{
				BaseTest.getTest().log(Status.WARNING, "Unable to proceed, Since title is not displaying");
				BaseTest.takeScreenshot();
			}
		}
	}

	public void accessCommunicationPage()
	{
		clickCommunicationTab();
		String hexaValueOrangeColour = "#fc6a00";
		if (getUiBackgroundColour("background-color", CommunicationRepository.communication_Modulecolor_orange).equalsIgnoreCase(hexaValueOrangeColour))
		{
			BaseTest.getTest().log(Status.INFO, "While Communication Tab is clicked, Tab colour is displayed in orange colour as expected.");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "While Communication Tab is clicked, Tab colour does not displayed in orange colour as expected.");
			BaseTest.takeScreenshot();
		}
		String communicationPageUrl = "https://run.marketingstar.us/communication";
		if (urlCheck(communicationPageUrl))
		{
			if (isElementAvailable(PreferencesRepository.allmainmenus_module_header))
			{
				uiPageEqualswithInputValue(PreferencesRepository.allmainmenus_module_header, "Communication");
				if (isElementAvailable(CommunicationRepository.communication_communication_details))
				{
					isElementAvailable(CommunicationRepository.communicationpage_communicationcreate);
					clickElement(CommunicationRepository.communication_gallery_tab);
					explicitwaitforvisibility(autolocator(CommunicationRepository.communication_gallery_grid), 60);
					isElementAvailable(CommunicationRepository.communication_gallery_details);
					BaseTest.takeScreenshot();
				} else
				{
					BaseTest.getTest().log(Status.WARNING, "Unable to proceed, Since title is not displaying");
					BaseTest.takeScreenshot();
				}
			}
		}
	}

	public void accessDasboardPage()
	{
		clickDashboardTab();
		String dashboardPageUrl = "https://run.marketingstar.us/";
		if (urlCheck(dashboardPageUrl))
		{
			if (isElementAvailable(PreferencesRepository.allmainmenus_dashboard_header))
			{
				uiPageEqualswithInputValue(PreferencesRepository.allmainmenus_dashboard_header, "Dashboard");
				isElementAvailable(DashboardRepository.homepage_recentcommunication_portlet);
			}
		}
	}

	public void accessPreferencesPage()
	{
		clickPreferencePagefromMenu();
		pageLoaderLogo();
		String preferencesPageUrl = "https://run.marketingstar.us/preferences";
		if (urlCheck(preferencesPageUrl))
		{
			if (isElementAvailable(PreferencesRepository.allmainmenus_module_header))
			{
				uiPageEqualswithInputValue(PreferencesRepository.allmainmenus_module_header, "Preferences");
				uiPageEqualswithInputValue(PreferencesRepository.allmainmenus_preference_submodule_header, "General,Setup,Billing");
				uiPageEqualswithInputValue(",xpath,//div[@class='per-list ']",
						"My profile,Account settings,Users,Alerts & notifications,Communication settings,Template builder,Form builder,Data exchange,Service catalogue,Consumptions,Invoices,License info");
			}
		}
	}

	public HomePage communicationDashboardPortletsVerification()
	{
		List<WebElement> totalPortlets = findElements(",xpath,//*[contains(@class,'portlet-header')]//h4");
		for (WebElement eachPortlet : totalPortlets)
		{
			String portlet = eachPortlet.getText();
			if (portlet.equals("Recent communications"))
			{
				communicationDashboardPortletsVerify(portlet, ",xpath,//p[@class='text-wrap-1 marginB0']");
			} else if (portlet.equals("Top performing communications"))
			{
				javaScriptScrollIntoView(",xpath,//p[@class='text-wrap-1 marginB0']");
				communicationDashboardPortletsVerify(portlet, ",xpath,//ul[@class='portlet-list']//li");
			} else if (portlet.equals("Leads generated"))
			{
				javaScriptScrollDown();
				communicationDashboardPortletsVerify(portlet, "");
			} else if (portlet.equals("Channel performance"))
			{
				javaScriptScrollDown();
				communicationDashboardPortletsVerify(portlet, ",xpath,//*[@class='highcharts-axis-labels highcharts-xaxis-labels']/child::*[@transform]");
			} else if (portlet.equals("Audience behavior"))
			{
				javaScriptScrollIntoView(",xpath,//p[@class='text-wrap-1 marginB0']");
				communicationDashboardPortletsVerify(portlet, ",xpath,//span[@class='bubbleChartName']");
			}
		}
		return this;
	}

	public HomePage communicationDashboardPortletsVerify(String Title, String xpath)
	{
		String recentCommunication = null;
		if (isElementPresent(xpath))
		{
			recentCommunication = getStrText(xpath);
		}
		if (isElementPresent(",xpath,//h4[contains(.,'" + Title + "')]/../following-sibling::div//*[@class='nodata-bar']"))
		{
			BaseTest.getTest().log(Status.INFO, Title + " Portlet is Availble in Communication Dashboard Page");
			BaseTest.takeScreenshot();
		} else if (!recentCommunication.isBlank() && !recentCommunication.isEmpty())
		{
			BaseTest.getTest().log(Status.INFO, Title + " Portlet is Available in Communication Dashboard Page");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, Title + " Portlet is not Available in Communication Dashboard Page");
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public void audienceModuleTextValidation()
	{
		clickAudiencelink();
		uiPageEqualswithInputValue(",xpath,//li[contains(@class,'tabDefault')]", "Segmentation lists,Dynamic lists");
		uiPageEqualswithInputValue(",xpath,//span[@class='k-link']", "Name,Created on,Created by,Total audience,No. of times published,Action");
		clickElement("List dropdown,xpath,//button[@id='dropdown-basic-buttons']");
		threadSleep(ObjectRepository.wait2sec);
		uiPageEqualswithInputValue(",xpath,//div[@class='css-scrollbar overflow-dropdown']//div", "My segment list,All segment list");
		clickElement(PreferencesRepository.allmainmenus_addaudience_btn);
		uiPageEqualswithInputValue("upload list,xpath,//li[@class='k-item k-state-focused']", "Upload list");
		clickElement("upload list,xpath,//li[@class='k-item k-state-focused']");
		uiPageEqualswithInputValue(PreferencesRepository.allmainmenus_module_header, "Add audience");
		uiPageEqualswithInputValue(",xpath,//div[@class='text-end col-md-2 offset-md-3']//label", "Add audience by");
		clickElement("add audience by,xpath,//span[@class='k-input']");
		threadSleep(ObjectRepository.wait2sec);
		uiPageEqualswithInputValue(",xpath,//ul[@class='k-list k-reset']//li", "CSV,Remote data source");
	}

}
