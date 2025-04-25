
package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.microsoft.playwright.Page;

import repository.CommunicationRepository;
import repository.DashboardRepository;
import repository.ObjectRepository;
import utility.BaseTest;
import utility.PageFactory;

public class CommunicationSMSChannelPage extends CommunicationCreatePage
{
	String SMSContentPersonalization;
	int splitSize, splitTotalCount, splitGroupACount, splitGroupBCount, splitGroupCCount, splitGroupDCount;
	int splitGroupAPercent, splitGroupBPercent, splitGroupCPercent, splitGroupDPercent;

	public CommunicationSMSChannelPage(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	// Select Provider Id
	public CommunicationSMSChannelPage enterSmsProviderid()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("SMS CHANNEL", ExtentColor.BLUE));
		pageLoaderLogo();
		explicitwaitforclick(autolocator(CommunicationRepository.communicationsms_selectproviderid), 30);
		clickElement(CommunicationRepository.communicationsms_selectproviderid);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, System.getProperty("smsSenderId"));
		return this;
	}

	public CommunicationSMSChannelPage enterSmsTemplateID()
	{
		explicitwaitforclick(autolocator(CommunicationRepository.communicationsms_tempID), 30);
		enterValue(CommunicationRepository.communicationsms_tempID, System.getProperty("smsTempId"));
		tabAction();
		threadSleep(ObjectRepository.wait2sec);
		BaseTest.takeScreenshot();
		return this;
	}

	public CommunicationSMSChannelPage enterSmsLanguage()
	{

		explicitwaitforclick(autolocator("Language,xpath,//span[contains(@aria-label,'Language')]//span[contains(@class,'k-input-value-text')]"), 30);
		clickElement("Language,xpath,//span[contains(@aria-label,'Language')]//span[contains(@class,'k-input-value-text')]");
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "English");
		return this;
	}

	// Select SMS recipients
	public CommunicationSMSChannelPage smsRecipient()
	{
		javaScriptScrollDownToSomeExtend();
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_select_smsreceip_click), 30);
		clickElement(CommunicationRepository.communicationpage_select_smsreceip_click);
		threadSleep(ObjectRepository.wait3sec);
		sendValue(CommunicationRepository.communicationpage_select_smsreceip_click, BaseTest.getData().TargetListNew);
		threadSleep(ObjectRepository.wait5sec);
		if (!selectlistelementsAndProceed(CommunicationRepository.communicationpage_select_smsreceip_list, BaseTest.getData().TargetListNew))
		{

			enterValue(CommunicationRepository.communicationpage_select_smsreceip_click, BaseTest.getData().TargetListOld);
			selectlistelements(CommunicationRepository.communicationpage_select_smsreceip_list, BaseTest.getData().TargetListOld);
		}
		tabAction();
		audienceList = getStrText(CommunicationRepository.communicationpage_AudienceList);
		javaScriptScrollDownToSomeExtend();
		return this;
	}

	public CommunicationSMSChannelPage splitSMSON(String splitType)
	{
		pageLoaderLogo();

		clickElement(CommunicationRepository.communicationpage_SMSSplitON);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait3sec);
		javaScriptScrollDownToSomeExtend();

		for (int count = 2; count < splitType.length(); count++)
		{
			explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_Email_split_addBtn), 30);
			clickElement(CommunicationRepository.communicationpage_Email_split_addBtn);
			threadSleep(ObjectRepository.wait3sec);
		}
		clickElement(CommunicationRepository.communicationpage_SMSsplitABDownarrow);
		threadSleep(ObjectRepository.wait1sec);
		String splitTotalCounts = getStrText("SplitTotalCounts,xpath,//div[contains(@class,'rs-split-to')]//div//span/..").replaceAll("[^A-Za-z0-9]", "");
		System.out.println(splitTotalCounts);
		if (!splitTotalCounts.isEmpty())

		{
			splitTotalCount = Integer.parseInt(splitTotalCounts);
		}
		for (int count = 0; count < splitType.length(); count++)
		{
			int li = count + 1;
			// div[@class='rs-split-slider-bottom']//ul//li//span[.='B']//following-sibling::span[@class='rs-split-bottom-label-number']
			String splitGroupCount1 = getStrText("SplitGroupCount1,xpath,(//div[@class='rs-split-slider-bottom']//.//span[@class='rs-split-bottom-label-number'])[" + li + "]").replaceAll("\\(.*?\\)", "");
			System.out.println(splitGroupCount1);

			int splitGroupCount = Integer.parseInt(splitGroupCount1);
			String splitGroupPercents = getStrText("SplitGroupPercents,xpath,(//div[@class='rs-split-slider-bottom']//.//span[@class='rs-split-bottom-label-number']//span)[" + li + "]");
			String splitGroupPercent2 = splitGroupPercents.substring(splitGroupPercents.indexOf("(") + 1, splitGroupPercents.indexOf(")")).replaceAll("[^A-Za-z0-9]", "");
			int splitGroupPercent = Integer.parseInt(splitGroupPercent2);

			switch (count)
			{
			case 0:
				splitGroupACount = splitGroupCount;
				splitGroupAPercent = splitGroupPercent;
				break;
			case 1:
				splitGroupBCount = splitGroupCount;
				splitGroupBPercent = splitGroupPercent;
				break;
			case 2:
				splitGroupCCount = splitGroupCount;
				splitGroupCPercent = splitGroupPercent;
				break;
			case 3:
				splitGroupDCount = splitGroupCount;
				splitGroupDPercent = splitGroupPercent;
				break;

			default:
				break;
			}
		}
		javaScriptScrollDownToSomeExtend();
		clickElement(CommunicationRepository.communicationpage_EmailsplitABDrag_save);
		return this;

	}

	public CommunicationSMSChannelPage splitSMSAutoScheduleOffValidate()
	{
		threadSleep(ObjectRepository.wait3sec);
		javaScriptScrollIntoView(CommunicationRepository.SMS_split_autoschedulesettingsIcon);
		explicitwaitforclick(autolocator(CommunicationRepository.SMS_split_autoschedulesettingsIcon), 30);
		clickElement(CommunicationRepository.SMS_split_autoschedulesettingsIcon);
		try
		{
			String autoon = "Auto ON,xpath,//div[@class='modal-content rsmd-content']//div//span[contains(@class,'switch-on')]";
			explicitwaitforvisibility(autolocator(autoon), 20);
			clickElement(autoon);
			BaseTest.getTest().log(Status.INFO, "Auto schedule default ON, user selected Option OFF");
			threadSleep(ObjectRepository.wait1sec);

		} catch (Exception e)
		{
			String autooff = "Auto off,xpath,//div[@class='modal-content rsmd-content']//div//span[contains(@class,'switch-off')]";
			explicitwaitforvisibility(autolocator(autooff), 20);
			BaseTest.getTest().log(Status.INFO, "Auto schedule default OFF, user selected Option OFF");
		}
		clickElement(CommunicationRepository.SplitABAutoshduleSavebutton);
		return this;
	}

	public CommunicationSMSChannelPage splitSMSDetails(String selectedSplitCaps, String subject, String zip)
	{
		javaScriptScrollIntoView(CommunicationRepository.communicationpage_email_receip_click);
		clickElement("Split-" + selectedSplitCaps + "," + "xpath,//span[.='Split " + selectedSplitCaps + "']");

		explicitwaitforclick(autolocator(",id,rs_SplitAB_templadeIdName"), 30);
		enterValue(",id,rs_SplitAB_templadeIdName", System.getProperty("smsTempId"));
		tabAction();
		threadSleep(ObjectRepository.wait2sec);
		BaseTest.takeScreenshot();
		threadSleep(ObjectRepository.wait2sec);

		String smsContent = System.getProperty("smsContent");
		List<String> objStringPersona = new ArrayList<>();
		objStringPersona.add(System.getProperty("smsPersona_1"));
		objStringPersona.add(System.getProperty("smsPersona_2"));
		objStringPersona.add(System.getProperty("smsPersona_3"));
		javaScriptScrollIntoView(",id,rs_SplitAB_templadeIdName");
		threadSleep(ObjectRepository.wait3sec);
		clickElement(CommunicationRepository.communicationsms_selectpersonalization);
		threadSleep(ObjectRepository.wait3sec);
		List<WebElement> personatxt = driver.findElements(autolocator(CommunicationRepository.communicationsms_personalizationlist));
		List<String> persona = new ArrayList<>();
		for (WebElement allele : personatxt)
		{
			String inputtext = allele.getText();
			if (objStringPersona.contains(inputtext))
			{
				persona.add(inputtext);
			}
		}
		smsContent = String.format(smsContent, persona.get(0), persona.get(1), persona.get(2));
		clickElement(CommunicationRepository.communicationsms_selectpersonalization);
		threadSleep(ObjectRepository.wait3sec);
		clickElement("Sms content,xpath,//textarea[@id='split" + selectedSplitCaps + ".editorText']");
		threadSleep(ObjectRepository.wait3sec);
		enterValue("Sms content,xpath,//textarea[@id='split" + selectedSplitCaps + ".editorText']", smsContent);
		clickElement(CommunicationRepository.authoringpage_smartlinksms);
		explicitwaitforclick(autolocator(CommunicationRepository.authoringpage_smartlink1), 20);
		clickElement(CommunicationRepository.authoringpage_smartlink1);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait2sec);
		BaseTest.takeScreenshot();

		return this;
	}

	// Select SMS schedule date
	public CommunicationSMSChannelPage smsScheduleDate(String val)
	{
		javaScriptScrollDown();

		try
		{
			threadSleep(ObjectRepository.wait3sec);
			selectDate(CommunicationRepository.communicationpage_select_smsscheduledate, val);
			JavascriptExecutor jse = ((JavascriptExecutor) driver);
			WebElement sDate = driver.findElement(By.id("MoblieScheduleDate"));
			captureSmsScheduleDate = (String) jse.executeScript("return arguments[0].value", sDate);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return this;
	}

	public CommunicationSMSChannelPage enterSMSScheduleTime(int day)
	{
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_emailschedule_time), 30);
		clickElement(CommunicationRepository.communicationpage_emailschedule_time);
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_emailschedule_datepopupactive), 30);
		String scheduleformat = calendarSchedduleDate(day, "MMMM d, yyy");
		javaScriptScrollDown();
		threadSleep(ObjectRepository.wait3sec);
		clickElement("schedule time,xpath,//td[contains(@title,'" + scheduleformat + "')]//span");
		clickElement(CommunicationRepository.communicationpage_emailschedule_calendar_TimehoursSelect);
		threadSleep(ObjectRepository.wait1sec);
		clickElement(CommunicationRepository.communicationpage_emailschedule_calendar_TimeminsSelect);
		clickElement(CommunicationRepository.communicationpage_emailschedule_calendar_Timeset);
		tabAction();
		threadSleep(ObjectRepository.wait2sec);
		return this;
	}

	public boolean checkSMSScheduleTimeError(String val)
	{
		boolean erroemsg = false;
		try
		{
			explicitwaitforvisibility(autolocator(CommunicationRepository.communicationpage_sms_dateTimeErr), 10);
			smsScheduleDate(val);
			erroemsg = true;
		} catch (Exception e)
		{
			// BaseTest.getTest().log(Status.INFO, "Schedule date and time error message not present, selected future time");
		}
		return erroemsg;
	}

	// SMS channel save
	public CommunicationSMSChannelPage clickSmssave()
	{
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_select_smscommunicationsave), 30);
		clickElement(CommunicationRepository.communicationpage_select_smscommunicationsave);
		return this;
	}

	// Sms Draft Save
	public CommunicationSMSChannelPage smsDraftConfirm()
	{
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_select_smsdraftsave), 30);
		clickElement(CommunicationRepository.communicationpage_select_smsdraftsave);
		return this;
	}

	// SMS Channel Save after error
	// SMS channel save
	public CommunicationSMSChannelPage clickSaveMsg(String val)
	{
		threadSleep(ObjectRepository.wait1sec);
		if (isDisplayed("//span[@id='errmsgMobileValidPastDateTime']"))
		{
			BaseTest.getTest().log(Status.INFO, "The Scheduled time has passed current time");
			threadSleep(ObjectRepository.wait1sec);
			smsScheduleDate(val);
		} else
		{
			clickElement(CommunicationRepository.communicationpage_select_smscommunicationsave);
		}
		threadSleep(ObjectRepository.wait10sec);
		explicitwaitforpresence(autolocator(CommunicationRepository.allmenu_ifcommunicationlistingappears), 70);
		if (isDisplayed(CommunicationRepository.allmenu_ifcommunicationlistingappears))
		{
			BaseTest.getTest().log(Status.PASS, "SMS Communication Saved Successfully");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "SMS Communication Failed to Save");
		}
		return this;

	}

	// SMS channel - Request for approval
	public CommunicationSMSChannelPage smsSendForApproval(String approveMailId)
	{
		javaScriptScrollDown();
		if (!isSelected(CommunicationRepository.communicationpage_sms_approvalchk))
		{
			clickElement(CommunicationRepository.communicationpage_sms_approvalchk);

		}
		clickElement(CommunicationRepository.communicationpage_sms_aprovemailto);
		selectlistelements(CommunicationRepository.communicationpage_sms_aprovemailtolist, "Enter new email here");
		enterValue(CommunicationRepository.communicationpage_sms_mail_enter, approveMailId);
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_sms_aproveSend), 30);
		return this;
	}

	// Select Time zone
	public CommunicationSMSChannelPage smstimezone()
	{
		threadSleep(ObjectRepository.wait1sec);
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_emailtimezoneicon), 10);
		clickElement(CommunicationRepository.communicationpage_emailtimezoneicon);
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_emailschedule_emailtimezonelist), 10);
		clickElement(CommunicationRepository.communicationpage_emailschedule_emailtimezonelist);
		threadSleep(ObjectRepository.wait1sec);
		selectlistelementsAndProceed(CommunicationRepository.communicationpage_emailschedule_timezoneselect, BaseTest.getData().TimeZone);
		return this;
	}

	// Test SMS method
	public CommunicationSMSChannelPage sendTestSms()
	{
		String[] val = BaseTest.getData().MobileNo.split("&");
		for (String splitvalues : val)
		{
			String numbers = getTextBoxVal(CommunicationRepository.sms_testnumber, "value");
			for (int i = 4; i < numbers.length(); i++)
			{
				findElements(CommunicationRepository.sms_testnumber).get(0).sendKeys(Keys.BACK_SPACE);
			}
			enterValue(CommunicationRepository.sms_testnumber, splitvalues);
			tabAction();
			explicitwaitforclick(autolocator(CommunicationRepository.sms_testnumber), 30);
			clickElement(CommunicationRepository.communicationpage_email_sendTestEmailSendBtn);
			threadSleep(ObjectRepository.wait2sec);
			pageLoaderLogo();
			BaseTest.takeScreenshot();
			try
			{
				pageLoaderLogo();
				if (getStrText(CommunicationRepository.email_testmail_msg).equalsIgnoreCase("Test communication will be sent shortly"))
				{
					BaseTest.takeScreenshot();
					threadSleep(ObjectRepository.wait5sec);
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Popup present but content is different");
					BaseTest.takeScreenshot();
				}
			} catch (Exception e)
			{
				BaseTest.getTest().log(Status.FAIL, "Failed to get test mail popup");
				BaseTest.takeScreenshot();
			}
			threadSleep(ObjectRepository.wait5sec);
		}
		return this;
	}

	public CommunicationSMSChannelPage enterSMSContentwithPersonalization()
	{
		String smsContent = System.getProperty("smsContent");
		List<String> objStringPersona = new ArrayList<>();
		objStringPersona.add(System.getProperty("smsPersona_1"));
		objStringPersona.add(System.getProperty("smsPersona_2"));
		objStringPersona.add(System.getProperty("smsPersona_3"));
		javaScriptScrollIntoView(CommunicationRepository.communicationsms_tempID);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(CommunicationRepository.communicationsms_selectpersonalization);
		threadSleep(ObjectRepository.wait3sec);
		List<WebElement> personatxt = driver.findElements(autolocator(CommunicationRepository.communicationsms_personalizationlist));
		List<String> persona = new ArrayList<>();
		for (WebElement allele : personatxt)
		{
			String inputtext = allele.getText();
			if (objStringPersona.contains(inputtext))
			{
				persona.add(inputtext);
			}
		}
		smsContent = String.format(smsContent, persona.get(0), persona.get(1), persona.get(2));
		clickElement(CommunicationRepository.communicationsms_selectpersonalization);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(CommunicationRepository.communicationsms_Entersmscontent);
		threadSleep(ObjectRepository.wait3sec);
		enterValue(CommunicationRepository.communicationsms_Entersmscontent, smsContent);
		clickElement(CommunicationRepository.authoringpage_smartlinksms);
		explicitwaitforclick(autolocator(CommunicationRepository.authoringpage_smartlink1), 20);
		clickElement(CommunicationRepository.authoringpage_smartlink1);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait2sec);
		BaseTest.takeScreenshot();
		return this;
	}

	public CommunicationSMSChannelPage SMSContentwithPersonalization()
	{
		clickElement("copoun code, xpath,//i[@class='icon-rs-coupon-medium icon-md ']");
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait1sec);
		clickElement("common code,xpath,//input[@value='Common']");
		clickElement(",xpath,//span[@aria-label='Select offer type']");

		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "EMI");
		pageLoaderLogo();

		clickElement(",xpath,//span[@aria-label='Select offer list']");
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "testautomation");
		pageLoaderLogo();
		clickElement(",xpath,//div[@class='rsmdc-footer w-100 modal-footer']//button[.='Save']");
		pageLoaderLogo();

		String smsContent = System.getProperty("smsContent");

		String previewbox = getStrText("live preview,xpath,//div[contains(@class,'rs-mobile-content')]/.//p");
		if (previewbox.contentEquals(smsContent))
		{
			BaseTest.getTest().log(Status.PASS, "Live Preview Content is same as given Text content");

		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Live Preview Content is not same as given Text content");

		}
		return this;
	}

	public CommunicationSMSChannelPage smsChannelPageCompareAttributeValuesInEditMode()
	{
		explicitwaitforvisibility(autolocator(CommunicationRepository.communicationsms_selectedproviderid), 30);
		String ProviderId = getStrText(CommunicationRepository.communicationsms_selectedproviderid);
		if (!ProviderId.contains(System.getProperty("smsSenderId")))
		{
			BaseTest.getTest().log(Status.FAIL, "The Duplicated communication Provider Id  : '" + ProviderId + "' Differs from its Input");
			BaseTest.takeScreenshot();
		}
		explicitwaitforvisibility(autolocator(CommunicationRepository.communicationsms_Entersmscontent), 30);
		String smsPersonalization = getStrText(CommunicationRepository.communicationsms_Entersmscontent);
		if (!smsPersonalization.contains(SMSContentPersonalization))
		{
			BaseTest.getTest().log(Status.FAIL, "The Duplicated communication personalization is  : '" + smsPersonalization + "' Differs from its Input");
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public CommunicationSMSChannelPage smsAddlinkClickandVerify()
	{
		javaScriptScrollIntoView(CommunicationRepository.communicationsms_selectproviderid);
		clickElement(CommunicationRepository.communicationsms_senderidicon);
		if (!isDisplayed(CommunicationRepository.communicationpage_settingslinkpage))
		{
			BaseTest.getTest().fail("On clicking sender id add icon in communication page, it failed to navigate to communication settings page");
		}
		driver.navigate().back();
		clickElement(CommunicationRepository.communicationsms_recipientaddicon);
		if (!isDisplayed(CommunicationRepository.communicationpage_recipientpage))
		{
			BaseTest.getTest().fail("On clicking recipient add icon in communication page, it failed to navigate to Recipient page");
		}
		driver.navigate().back();
		return this;
	}

	// Click sms channel next
	public CommunicationSMSChannelPage clickNextSms()
	{
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_select_smscommunicationnext), 10);
		clickElement(CommunicationRepository.communicationpage_select_smscommunicationnext);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(CommunicationRepository.communicationpage_sms_selectanalytics);
		threadSleep(ObjectRepository.wait5sec);
		return this;
	}

	// Communication SMS Database ####################################################################

	public void testSMSCommDBValidation(String commName)
	{
		BaseTest.getTest().log(Status.INFO, "######Communication DB SMS#######");
		campDetails = getdbQueryResults(dburl_campaign + campdbname, campaigndb_userName, campaigndb_password, qSMSCampDetails(commName));
		if (!campDetails.isEmpty())
		{
			for (Map<String, String> camprow : campDetails)
			{
				campaignId = camprow.get("CampaignID");
				campGUID1 = camprow.get("CampaignGUID");
				campBlastScheduleGUID = camprow.get("SMSScheduleGUID");
				BaseTest.getTest().log(Status.INFO, mapToString(camprow));
				String isTestCamp = camprow.get("IsTestCampaign");
				if (isTestCamp.contains("true"))
				{
					BaseTest.getTest().info("This communication marked as Test communication");
				} else
				{
					BaseTest.getTest().fail("This communication not marked as Test communication");
				}
			}
		}
	}

	public void smsCommDBValidation()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("SMS COMMUNICATION DB", ExtentColor.BLUE));
		threadSleep(ObjectRepository.wait20sec);
		campDetails = getdbQueryResults(dburl_campaign + campdbname, campaigndb_userName, campaigndb_password, qSMSCampDetails(communicationName));
		if (!campDetails.isEmpty())
		{
			for (Map<String, String> camprow : campDetails)
			{
				campaignId = camprow.get("CampaignID");
				campGUID1 = camprow.get("CampaignGUID");
				campBlastScheduleGUID = camprow.get("SMSScheduleGUID");
				BaseTest.getTest().log(Status.INFO, mapToString(camprow));
			}
		}
	}

	public void rfaSMSCheck(String approvalmail, boolean approve)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("CAMAPAIGN DB SMS CHANNEL", ExtentColor.INDIGO));
		campDetails = getdbQueryResults(dburl_campaign + campdbname, campaigndb_userName, campaigndb_password, qSMSCampRFADetails(communicationName, approvalmail));
		if (!campDetails.isEmpty())
		{
			for (Map<String, String> camprow : campDetails)
			{
				campaignId = camprow.get("CampaignID");
				campGUID1 = camprow.get("CampaignGUID");
				campBlastScheduleGUID = camprow.get("BlastScheduleGuid");
				BaseTest.getTest().log(Status.INFO, mapToString(camprow));
				String isApprove = camprow.get("IsApproved");
				String makeChangeComments = camprow.get("MakeChangesComments");
				if (approve)
				{
					if (isApprove.contains("true"))
					{
						BaseTest.getTest().info("This RFA communication approved ");
					} else
					{
						BaseTest.getTest().fail("This RFA communication not approved");
					}
				} else
				{
					if (!makeChangeComments.contains("true"))
					{
					} else
					{
						BaseTest.getTest().info("This RFA communication make changes updated :" + makeChangeComments);
					}
				}
			}
		}
	}

	public void commonOfferCodeAdd(String offer)
	{

		threadSleep(ObjectRepository.wait2sec);
		clickElement(CommunicationRepository.communicationsms_couponcode);
		clickElement(CommunicationRepository.communication_selectoffertype);
		selectlistelements(CommunicationRepository.communication_offertypedropdown, "EMI");
		clickElement(CommunicationRepository.communication_selectofferlist);
		selectlistelements(CommunicationRepository.communication_offerlistdropdown, offer);
		clickElement(CommunicationRepository.communication_offer_savebutton);
	}

	public void uniqueOfferCodeAdd(String offer)
	{
		threadSleep(ObjectRepository.wait2sec);
		clickElement(CommunicationRepository.communicationsms_couponcode);
		clickElement(CommunicationRepository.communication_uniquecoupencode);
		clickElement(CommunicationRepository.communication_selectoffertype);
		selectlistelements(CommunicationRepository.communication_offertypedropdown, "EMI");
		clickElement(CommunicationRepository.communication_selectofferlist);
		selectlistelements(CommunicationRepository.communication_offerlistdropdown, offer);
		clickElement(CommunicationRepository.communication_offer_savebutton);
	}

	public CommunicationCreatePage verifySMSCreatePageFields(String commStatus)
	{
		try
		{
			explicitwaitforvisibility(autolocator(CommunicationRepository.communicationpage_commcreation_sms_edit_senderID + "[text()='" + System.getProperty("smsSenderId") + "']"), 30);
			pageLoaderLogo();
		} catch (Exception e)
		{
			e.printStackTrace();
			refresh();
			pageLoaderLogo();
		}
		explicitwaitforvisibility(autolocator(CommunicationRepository.communicationpage_commcreation_sms_edit_senderID + "[text()='" + System.getProperty("smsSenderId") + "']"), 30);
		if (commStatus.equalsIgnoreCase("In progress") || commStatus.equalsIgnoreCase("Completed"))
		{
			threadSleep(ObjectRepository.wait10sec);
			String list = getStrText(CommunicationRepository.communicationpage_commcreation_edit_audience);
			uiPageEqualswithInputValue(System.getProperty("smsSenderId"), getStrText(CommunicationRepository.communicationpage_commcreation_sms_edit_senderID));
			uiPageEqualswithInputValue(System.getProperty("smsTempId"), getTextBoxVal(CommunicationRepository.communicationpage_commcreation_sms_edit_tempId, "value"));
			uiPageEqualswithInputValue(BaseTest.getData().TargetListNew, list.substring(0, list.indexOf("(")).trim());
			javaScriptScrollIntoView(CommunicationRepository.communicationpage_commcreation_edit_audience);
			isDisplayed(CommunicationRepository.communicationpage_commcreation_sms_edit_content);
			uiPageEqualswithInputValue(SMSContentPersonalization, getStrText(CommunicationRepository.communicationpage_commcreation_sms_edit_content));
			if (isElementPresent(CommunicationRepository.communicationpage_commcreation_sms_edit_testMail))
			{
				BaseTest.getTest().log(Status.INFO, "Test SMS dropdown has disable mode as Expected");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Test SMS dropdown has Enable mode not as Expected");
				BaseTest.takeScreenshot();
			}
			javaScriptScrollDown();
		}
		return this;
	}

	// Jasmine Mkstr

	public CommunicationSMSChannelPage previewValidate()
	{

		clickElement(CommunicationRepository.CommunicationListing_detailslistingplusicon);
		explicitwaitforInvisibility(CommunicationRepository.CommunicationListing_PreviewIcon, 30);
		clickElement(CommunicationRepository.CommunicationListing_PreviewIcon);
		String previewText = getStrText(CommunicationRepository.communicationListing_getpreviewcontent);
		if (previewText.equals(SMSContentPersonalization))
		{
			System.out.println("Content preview --> " + SMSContentPersonalization);

		}
		return this;
	}

}
