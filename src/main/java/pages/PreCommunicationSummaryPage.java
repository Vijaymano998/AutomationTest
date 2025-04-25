package pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.microsoft.playwright.Page;

import repository.CommunicationRepository;
import repository.ObjectRepository;
import utility.BaseTest;
import utility.ExtentManager;
import utility.PageBase;
import utility.PageFactory;

public class PreCommunicationSummaryPage extends PageBase
{

	protected HashMap<String, Map<String, String>> preCommChannelWise = new LinkedHashMap<>();
	protected Map<String, String> preCommunicationChannelResults = new LinkedHashMap<>();

	public PreCommunicationSummaryPage(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	public void preCommunicationCountValidation(String attributeName, String attributeValue, boolean expectedNumber)
	{
		if (NumberUtils.isNumber(attributeValue) && expectedNumber)
		{
			BaseTest.getTest().info(attributeName + " is number and count -->" + attributeValue);
		} else if (!expectedNumber && !attributeValue.isEmpty())
		{
			BaseTest.getTest().info(attributeName + " is not number and value -->" + attributeValue);
		} else
		{
			BaseTest.getTest().warning(attributeName + " is not number ot null -->" + attributeValue);
		}
	}

	public void preCommunicationgetContent(String attributeName, String attributeValue)
	{
		getStrText(attributeValue);
		BaseTest.getTest().info(attributeName + " --> " + attributeValue);
	}

	public PreCommunicationSummaryPage getSMSpreCommunicationDetails()
	{
		preCommunicationCountValidation("SMS Precommunication Audience", getStrText(CommunicationRepository.precommunicationpage_allaudiencevalue), true);
		preCommunicationCountValidation("SMS Precommunication Unique Audience", getStrText(CommunicationRepository.precommunicationpage_uniquesmsaudience), true);
		preCommunicationCountValidation("SMS Scrubbing inprogress", CommunicationRepository.precommunicationpage_smsscrubinprogress, true);
		preCommunicationCountValidation("SMS Precommunication FrequencyCap", CommunicationRepository.precommunicationpage_smsfrequencycap, true);
		preCommunicationCountValidation("SMS Precommunication Scrubbed by limitcap", CommunicationRepository.precommunicationpage_smsscrubbylimitcap, false);
		preCommunicationCountValidation("SMS Precommunication Potential target audience", CommunicationRepository.precommunicationpage_smspotentialtargetaudience, true);
		return this;
	}

	public PreCommunicationSummaryPage getEmailPreCommunicationDetails()
	{
		preCommunicationCountValidation("Email Precommunication Audience", getStrText(CommunicationRepository.precommunicationpage_allaudiencevalue), true);
		preCommunicationCountValidation("Email Precommunication Unique Audience", getStrText(CommunicationRepository.precommunicationpage_uniqueemailaudience), true);
		preCommunicationCountValidation("Email Scrubbing inprogress", CommunicationRepository.precommunicationpage_emailscrubinprogress, true);
		preCommunicationCountValidation("Email Precommunication FrequencyCap", CommunicationRepository.precommunicationpage_emailfrequencycap, true);
		preCommunicationCountValidation("Email Precommunication Scrubbed by limitcap", CommunicationRepository.precommunicationpage_emailscrubbylimitcap, false);
		preCommunicationCountValidation("Email Precommunication Potential target audience", CommunicationRepository.precommunicationpage_emailscrubbylimitcap, true);
		return this;
	}

	public PreCommunicationSummaryPage getWebpushPreCommunnicationDetails()
	{
		preCommunicationCountValidation("Webpush Precommunication Audience", getStrText(CommunicationRepository.precommunicationpage_allaudiencevalue), true);
		preCommunicationCountValidation("Webpush Precommunication Unique Audience", getStrText(CommunicationRepository.precommunicationpage_uniquewebaudience), true);
		preCommunicationCountValidation("Webpush Scrubbing inprogress", CommunicationRepository.precommunicationpage_webscrubinprogress, true);
		preCommunicationCountValidation("Webpush Precommunication FrequencyCap", CommunicationRepository.precommunicationpage_webfrequencycap, true);
		preCommunicationCountValidation("Webpush Precommunication Scrubbed by limitcap", CommunicationRepository.precommunicationpage_webscrubbylimitcap, false);
		preCommunicationCountValidation("Webpush Precommunication Potential target audience", CommunicationRepository.precommunicationpage_webpotentialtargetaudience, true);
		return this;
	}

	public PreCommunicationSummaryPage getMobilepPushPreCommunicationDetails()
	{
		preCommunicationCountValidation("Mobilepush Precommunication Audience", getStrText(CommunicationRepository.precommunicationpage_allaudiencevalue), true);
		preCommunicationCountValidation("Mobilepush Precommunication Unique Audience", getStrText(CommunicationRepository.precommunicationpage_uniquemobileaudience), true);
		preCommunicationCountValidation("Mobilepush Scrubbing inprogress", CommunicationRepository.precommunicationpage_mobilescrubinprogress, true);
		preCommunicationCountValidation("Mobilepush Precommunication FrequencyCap", CommunicationRepository.precommunicationpage_mobilefrequencycap, true);
		preCommunicationCountValidation("Mobilepush Precommunication Scrubbed by limitcap", CommunicationRepository.precommunicationpage_mobilescrubbylimitcap, false);
		preCommunicationCountValidation("Mobilepush Precommunication Potential target audience", CommunicationRepository.precommunicationpage_mobilepotentialtargetaudience, true);
		return this;
	}

	public PreCommunicationSummaryPage getVMSTexttoSpeechPreCommunicationDetails()
	{
		preCommunicationCountValidation("VMS TextSpeech Precommunication Audience", getStrText(CommunicationRepository.precommunicationpage_allaudiencevalue), true);
		preCommunicationCountValidation("VMS TextSpeech Precommunication Unique Audience", getStrText(CommunicationRepository.precommunicationpage_uniquevmsaudience), true);
		preCommunicationCountValidation("VMS TextSpeech Scrubbing inprogress", CommunicationRepository.precommunicationpage_vmsscrubinprogress, true);
		preCommunicationCountValidation("VMS TextSpeech Precommunication FrequencyCap", CommunicationRepository.precommunicationpage_vmsfrequencycap, true);
		preCommunicationCountValidation("VMS TextSpeech Precommunication Scrubbed by limitcap", CommunicationRepository.precommunicationpage_vmsscrubbylimitcap, false);
		preCommunicationCountValidation("VMS TextSpeech Precommunication Potential target audience", CommunicationRepository.precommunicationpage_vmspotentialtargetaudience, true);
		return this;
	}

	// Need to update on functionality change
	public PreCommunicationSummaryPage getVMSAudioPreCommunicationDetails()
	{
		preCommunicationCountValidation("VMS TextSpeech Precommunication Audience", getStrText(CommunicationRepository.precommunicationpage_allaudiencevalue), true);
		preCommunicationCountValidation("VMS TextSpeech Precommunication Unique Audience", getStrText(CommunicationRepository.precommunicationpage_uniquevmsaudience), true);
		preCommunicationCountValidation("VMS TextSpeech Scrubbing inprogress", CommunicationRepository.precommunicationpage_vmsscrubinprogress, true);
		preCommunicationCountValidation("VMS TextSpeech Precommunication FrequencyCap", CommunicationRepository.precommunicationpage_vmsfrequencycap, true);
		preCommunicationCountValidation("VMS TextSpeech Precommunication Scrubbed by limitcap", CommunicationRepository.precommunicationpage_vmsscrubbylimitcap, false);
		preCommunicationCountValidation("VMS TextSpeech Precommunication Potential target audience", CommunicationRepository.precommunicationpage_vmspotentialtargetaudience, true);
		return this;
	}

	public PreCommunicationSummaryPage getWhatsAppPreCommunicationDetails()
	{
		preCommunicationCountValidation("WhatsApp Precommunication Audience", getStrText(CommunicationRepository.precommunicationpage_allaudiencevalue), true);
		preCommunicationCountValidation("WhatsApp Precommunication Unique Audience", getStrText(CommunicationRepository.precommunicationpage_uniquewhatsappaudience), true);
		preCommunicationCountValidation("WhatsApp Scrubbing inprogress", CommunicationRepository.precommunicationpage_whatsappscrubinprogress, true);
		preCommunicationCountValidation("WhatsApp Precommunication FrequencyCap", CommunicationRepository.precommunicationpage_whatsappfrequencycap, true);
		preCommunicationCountValidation("WhatsApp Precommunication Scrubbed by limitcap", CommunicationRepository.precommunicationpage_whatsappscrubbylimitcap, false);
		preCommunicationCountValidation("WhatsApp Precommunication Potential target audience", CommunicationRepository.precommunicationpage_whatsapppotentialtargetaudience, true);
		return this;
	}

	public PreCommunicationSummaryPage getVMSPreCommunicationDetails()
	{
		preCommunicationgetContent("Precommunication VMS File weight", CommunicationRepository.precommunicationpage_vmsfilesize);
		preCommunicationgetContent("Precommunication VMS File Type", CommunicationRepository.precommunicationpage_vmsfiletype);
		preCommunicationCountValidation("Precommunication VMS Retry Count", CommunicationRepository.precommunicationpage_vmsretrycount, true);
		return this;
	}

	public PreCommunicationSummaryPage getSMSPreCommunicationContent()
	{
		preCommunicationCountValidation("No. of SMS", CommunicationRepository.precommunicationpage_numberofsms, true);
		preCommunicationgetContent("Precommunication SMS Personasation Enabled", CommunicationRepository.precommunicationpage_smsispersonaenabled);
		preCommunicationgetContent("Precommunication SMS uniCode", CommunicationRepository.precommunicationpage_smsunicode);
		return this;
	}

	public PreCommunicationSummaryPage getEmailPreCommunicationContent()
	{
		preCommunicationgetContent("Precommunication Email subLine", CommunicationRepository.precommunicationpage_emailsublinespamscore);
		preCommunicationgetContent("Precommunication Email imagetTextRatio", CommunicationRepository.precommunicationpage_emailimagetotetratio);
		preCommunicationgetContent("Precommunication Email file Weight", CommunicationRepository.precommunicationpage_emailfilesize);
		return this;
	}

	public PreCommunicationSummaryPage getWhatsAppPreCommunicationContent()
	{
		preCommunicationCountValidation("Precommunication WhatsApp Content length", CommunicationRepository.precommunicationpage_whatsappcontentlength, true);
		preCommunicationgetContent("Precommunication WhatsApp Presonalization Enabled ", CommunicationRepository.precommunicationpage_whatsapppersonalization);
		preCommunicationgetContent("Precommunication WhatsApp Language", CommunicationRepository.precommunicationpage_whatsapplanguage);
		return this;
	}

	public PreCommunicationSummaryPage getWebpushPreCommunicationContent()
	{
		preCommunicationCountValidation("Precommunication Webpush Content length", CommunicationRepository.precommunicationpage_webpushcontentlength, true);
		preCommunicationgetContent("Precommunication Webpush Presonalization Enabled ", CommunicationRepository.precommunicationpage_webpushpersona);
		preCommunicationgetContent("Precommunication Webpush Trigger type", CommunicationRepository.precommunicationpage_webpushtriggertype);
		return this;
	}

	public PreCommunicationSummaryPage getMobilepushPreCommunicationContent()
	{
		preCommunicationCountValidation("Precommunication Mobilepush Content length", CommunicationRepository.precommunicationpage_mobilepushcontentlength, true);
		preCommunicationgetContent("Precommunication Mobilepush Presonalization Enabled ", CommunicationRepository.precommunicationpage_mobilepushpersona);
		preCommunicationgetContent("Precommunication Mobilepush Image attached", CommunicationRepository.precommunicationpage_mobilepushimageattached);
		return this;
	}

	public void rfaAprver(int approverNumber, Boolean isApprovered)
	{
		String approverStatus = getStrText("Approve status,xpath, (//*[@id='eob1_1']//h5/../..//div[contains(.,'Approv')])[" + approverNumber + "]");
		if (isApprovered)
		{
			if (approverStatus.contains("Approved"))
			{
				BaseTest.getTest().info("Value matches-->" + approverStatus);
			} else
			{
				BaseTest.getTest().fail("Value differs" + approverStatus);
			}
		} else
		{
			if (approverStatus.contains("Approval Pending"))
			{
				BaseTest.getTest().info("Value matches-->" + approverStatus);
			} else
			{
				BaseTest.getTest().fail("Value differs" + approverStatus);
			}
		}
	}

	// Pre-Communication Page
	public PreCommunicationSummaryPage preCommunicationPageDataCapture(String channel)
	{
		List<WebElement> header, data;
		BaseTest.getTest().info(MarkupHelper.createLabel("PRE COMMUNICATION SUMMARY PAGE", ExtentColor.BROWN));
		pageLoaderLogo();
		explicitwaitforvisibility(autolocator(CommunicationRepository.precommunicationpage), 60);
		if (selectlistelements(CommunicationRepository.precommunicationpage_channels, channel))
		{
			javaScriptScrollDownToSomeExtend();
			header = findElements(CommunicationRepository.communicationpage_precommHeader);
			data = findElements(CommunicationRepository.communicationpage_precommCount);
			for (int index = 0; index < header.size(); index++)
			{
				javaScriptHighLightElement(data.get(index));
				String campHeader = header.get(index).getText();
				String campValue = data.get(index).getText();
				preCommunicationChannelResults.put(campHeader, campValue);
				if (preCommunicationChannelResults.containsKey("Scrubbing in progress"))
				{
					javaScriptScrollDownToSomeExtend();
					for (int j = 0; j < 5; j++)
					{
						driver.navigate().refresh();
						explicitwaitforvisibility(autolocator(CommunicationRepository.precommunicationpage), 20);
						String Scrub = getStrText(CommunicationRepository.precommunicationpage_scrub);
						String Data = getStrText(CommunicationRepository.precommunicationpage_scrubbedCount);
						if (Scrub.contains("Scrubbed"))
						{
							preCommunicationChannelResults.remove("Scrubbing in progress");
							preCommunicationChannelResults.put(Scrub, Data);
							break;
						} else if (j == 4)
						{
							BaseTest.getTest().log(Status.WARNING, "Scrubbing is still in progress");
						}
					}
				}
			}
			preCommChannelWise.put(channel, preCommunicationChannelResults);
			System.out.println(preCommChannelWise);
			BaseTest.getTest().log(Status.INFO, "Pre-Communicaation Summary Page Info");
			ExtentManager.customReport(preCommunicationChannelResults);
		}
		return this;
	}

	public PreCommunicationSummaryPage listQualityDasboard(String audienceList)
	{

		int Audience = Integer.parseInt(preCommunicationChannelResults.get("Total audience"));
		int Potential = Integer.parseInt(preCommunicationChannelResults.get("Potential target audience"));

		String value = StringUtils.substringBetween(audienceList, "(", ")");
		String volume = value != null ? value : BaseTest.getData().QRReach;

		int count = Integer.parseInt(volume);
		if (Audience == count)
		{
			BaseTest.getTest().log(Status.INFO, "Total Audience : " + Potential + " , Verified as Expected");

			if (!preCommChannelWise.containsKey("QR Code"))
			{
				String Scrubbing = preCommunicationChannelResults.get("Scrubbed");
				if (Scrubbing == null)
				{
					Scrubbing = preCommunicationChannelResults.get("Scrubbing in progress");
				}
				int scrubbed = Integer.parseInt(Scrubbing);
				Audience = Audience - scrubbed;
				if (Audience == Potential)
				{
					BaseTest.getTest().log(Status.INFO, "After Scrubbing potential Audience is ---> " + Potential);
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Potential count not as Expected :" + Audience + " and Actual :" + Potential);
				}
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Audience counts are mismatched, Auctual :" + Audience + " Expected : " + count);
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public PreCommunicationSummaryPage contentDashboard(String Channel, List<String> content)
	{
		isDisplayed(CommunicationRepository.precomm_content);
		String smartLink = "";
		if (Channel.equals("Email"))
		{
			String spamscore = preCommunicationChannelResults.get("Subject line spam score");
			String fileWeight = preCommunicationChannelResults.get("File weight").replaceAll("[^0-9]", "");
			if (fileWeight.equals(content.get(0)))
			{
				BaseTest.getTest().log(Status.INFO, "File weight is equals to uploaded EDM File weight : " + fileWeight);

			} else
			{
				BaseTest.getTest().log(Status.FAIL, "File weight is not equals to uploaded EDM File weight : " + fileWeight);
			}
			smartLink = content.get(1);

		} else if (Channel.equals("SMS"))
		{
			assertEqual("No. of SMS", "2", preCommunicationChannelResults.get("No. of SMS"));
			assertEqual("Personalization enabled", "Yes", preCommunicationChannelResults.get("Personalization enabled"));
			assertEqual("Unicode", "No", preCommunicationChannelResults.get("Unicode"));
			smartLink = BaseTest.getData().SmartLink;

		} else if (Channel.equals("QR Code"))
		{
			assertEqual("QR type", "W", preCommunicationChannelResults.get("QR type"));
			assertEqual("Shorten URL", "Yes", preCommunicationChannelResults.get("Shorten URL enabled"));
			assertEqual("KYC ", "Yes", preCommunicationChannelResults.get("KYC"));
			smartLink = BaseTest.getData().SmartLink;
		}
		if (isElementAvailable(CommunicationRepository.precommunicationpage_linkVerification))
		{
			String linkStatus = getStrText(CommunicationRepository.precommunicationpage_linkVerification);
			BaseTest.getTest().log(Status.INFO, "Link verification ---> " + linkStatus);
			javaScriptScrollDownToSomeExtend();
			threadSleep(ObjectRepository.wait2sec);
			clickElement(CommunicationRepository.precommunicationpage_linkVerification);
			explicitwaitforvisibility(autolocator(CommunicationRepository.precommunicationpage_linkInfopupop), 30);
			linkStatusVerification(smartLink);
			clickElement(CommunicationRepository.precommunicationpage_infopopup_close);
		}
		return this;
	}

	// SDK & Link Status verification
	public PreCommunicationSummaryPage linkStatusVerification(String EDMlink)
	{
		String link = getTextBoxVal(CommunicationRepository.precommunicationpage_Smartlink, "href");
		if (link.contains(EDMlink))
		{
			clickElement(CommunicationRepository.precommunicationpage_Smartlink);
			String parentWind = parentWinHandle();
			switchWindow();
			javaScriptPageLoad();
			BaseTest.getTest().info("The link navigated to given link");
			BaseTest.takeScreenshot();
			driver.close();
			switchParentWin(parentWind);

		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Link verification failed as Expected : " + EDMlink + " and Actual :" + link);
			BaseTest.takeScreenshot();
		}
		return this;
	}

	// Approval Status Dashboard
	public PreCommunicationSummaryPage approvalStatusDashboard(String Audiencelist, int RfaLevel, String RFA, String exptStatus)
	{
		List<Map<String, String>> commApprovalStatus = new ArrayList<Map<String, String>>();
		Map<String, String> CommStatus = new LinkedHashMap<>();
		Map<String, String> listStatus = new LinkedHashMap<>();
		List<WebElement> data, header, Approver;

		explicitwaitforvisibility(autolocator(CommunicationRepository.precommunicationpage_approverStatus), 30);
		header = findElements(CommunicationRepository.precommunicationpage_approverStatus_header);
		Approver = findElements(CommunicationRepository.precommunicationpage_approverStatus_name);

		// GDP Ticket ID : # 23755
		String value = getTextBoxVal(CommunicationRepository.precommunicationpage_approverStatus_header + "[" + 1 + "]", "class");

		if (!Approver.isEmpty() && value.contains("active"))
		{
			for (int i = 1; i <= header.size(); i++)
			{
				String title = getStrText(CommunicationRepository.precommunicationpage_approverStatus_header + "[" + i + "]");
				clickElement(title + CommunicationRepository.precommunicationpage_approverStatus_header + "[" + i + "]");
				data = findElements(CommunicationRepository.precommunicationpage_approverStatus_status);
				javaScriptScrollIntoView(CommunicationRepository.precommunicationpage_approverStatus);

				if (!title.equalsIgnoreCase("List"))
				{
					for (int j = 0; j < Approver.size(); j++)
					{
						String commApprover = Approver.get(j).getText().split("\\R")[1];
						String commStatus = data.get(j).getText();
						javaScriptHighLightElement(Approver.get(j));
						javaScriptHighLightElement(data.get(j));
						CommStatus.put(commApprover, commStatus);
						commApprovalStatus.add(j, CommStatus);

						// GDP Ticket ID : # 23805
						String Domain = Approver.get(j).getText().split("\\R")[2];
						String beforeDomain = StringUtils.substringBefore(Domain, "@");
						String afterDomain = StringUtils.substringAfter(Domain, "@");
						if ((beforeDomain.contains("***") && afterDomain.contains("***")))
						{
							BaseTest.getTest().log(Status.INFO, "Domain name is Masked");
						} else
						{
							BaseTest.getTest().log(Status.FAIL, "Domain name is not Masked");
							BaseTest.takeScreenshot();
						}
					}
				} else
				{
					data = findElements(CommunicationRepository.precommunicationpage_approverStatus_listname);
					Approver = findElements(CommunicationRepository.precommunicationpage_approverStatus_name);

					for (int j = 0; j < Approver.size(); j++)
					{
						String approver = Approver.get(j).getText().split("\\R")[0];
						String listname = data.get(j).getText();
						javaScriptHighLightElement(Approver.get(j));
						javaScriptHighLightElement(data.get(j));
						listStatus.put(listname, approver);

						// GDP Ticket ID : # 23805
						String Domain = Approver.get(j).getText().split("\\R")[1];
						String beforeDomain = StringUtils.substringBefore(Domain, "@");
						String afterDomain = StringUtils.substringAfter(Domain, "@");
						if ((beforeDomain.contains("***") && afterDomain.contains("***")))
						{
							BaseTest.getTest().log(Status.INFO, "Domain name is Masked");
							BaseTest.takeScreenshot();
						} else
						{
							BaseTest.getTest().log(Status.FAIL, "Domain name is not Masked");
							BaseTest.takeScreenshot();
						}
					}
				}
				BaseTest.takeScreenshot();
			}
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "No data available");
			BaseTest.takeScreenshot();
		}
		// GDP Ticket ID : # 23513
		if (listStatus.containsKey(Audiencelist))
		{
			BaseTest.getTest().log(Status.INFO, "The Uploded audience list is found in pre-commounication page : " + listStatus);
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "The Uploded audience list not found in pre-commounication page : " + listStatus);
			BaseTest.takeScreenshot();
		}

		Map<String, String> map = commApprovalStatus.get(RfaLevel - 1);
		String approver = RFA.split("@")[0];

		if (map.containsKey(approver))
		{
			String RFAstatus = map.get(approver);
			if (RFAstatus.equalsIgnoreCase(exptStatus))
			{
				BaseTest.getTest().log(Status.INFO, "The Approval status dashbord : " + map);
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "The Approval status is not as Expected : " + exptStatus);
				BaseTest.takeScreenshot();
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Approval user not able to found as Expected  : " + approver);
		}
		return this;
	}

	public String getDateAndTime(String format)
	{
		SimpleDateFormat sd = new SimpleDateFormat(format);
		Date date = new Date();
		return sd.format(date);
	}

	public PreCommunicationSummaryPage frequencyCap()
	{
		explicitwaitforclick(autolocator(CommunicationRepository.precommunicationpage_freqCap), 10);
		if (isEnabled(CommunicationRepository.precommunicationpage_freqCap))
		{
			clickElement(CommunicationRepository.precommunicationpage_freqCap);
			explicitwaitforvisibility(autolocator(CommunicationRepository.precommunicationpage_freqCap_popup), 10);
			String toggle = getTextBoxVal(CommunicationRepository.precommunicationpage_freqCap_toggle, "class");
			if (toggle.contains("switch-off"))
			{
				clickElement(CommunicationRepository.precommunicationpage_freqCap_toggle);
				explicitwaitforclick(autolocator(CommunicationRepository.precommunicationpage_freqCap_Dropdown), 10);
				selectlistelements(CommunicationRepository.precommunicationpage_freqCap_Dropdown, "");
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Frequency Cap option isn't enabled");
		}
		return this;
	}
}
