package pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.microsoft.playwright.Page;

import repository.CommunicationRepository;
import repository.DashboardRepository;
import repository.ObjectRepository;
import utility.BaseTest;
import utility.PageFactory;

public class CommunicationQRChannelPage extends CommunicationCreatePage
{
	// MARKETING STAR - QR Communication POM

	private static final String DOM_Attribute_Class = "class";
	private static final String DOM_Attribute_Value = "value";

	public CommunicationQRChannelPage(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	public boolean selectQRCampaignType(String campaignType)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel(" QR CHANNEL ", ExtentColor.BROWN));
		pageLoaderLogo();
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_qrChannel), 30);
		isDisplayed(CommunicationRepository.communicationpage_qrChannel);
		return selectlistelements(CommunicationRepository.communicationpage_qrChannel_campaignType, campaignType);
	}

	public CommunicationQRChannelPage enterAudienceReach()
	{
		clickElement(CommunicationRepository.communicationpage_qrChannel_recipientreach);
		enterValue(CommunicationRepository.communicationpage_qrChannel_recipientreach, BaseTest.getData().QRReach).tabAction();
		if (isElementPresent(CommunicationRepository.communicationpage_qrChannel_recipientreach_help))
		{
			mouseHover(CommunicationRepository.communicationpage_qrChannel_recipientreach_help);
			isElementAvailable(CommunicationRepository.communicationpage_qrChannel_helptooltip);
			uiPageEqualswithInputValue("The number of audience in the area where QR code will be placed.", getStrText(CommunicationRepository.communicationpage_qrChannel_helptooltip));
		}
		return this;
	}

	public CommunicationQRChannelPage enterCommunicationURL()
	{
		javaScriptScrollDownToSomeExtend();
		enterValue(CommunicationRepository.communicationpage_qrChannel_commURL, BaseTest.getData().SmartLink).tabAction();
		if (getTextBoxVal(CommunicationRepository.communicationpage_qrChannel_commURL_validationIcon, DOM_Attribute_Class).contains("green"))
		{
			clickElement(CommunicationRepository.communicationpage_qrChannel_shortenURL);
			pageLoaderLogo();
			verifyShortenURL();
		}
		return this;
	}

	public CommunicationQRChannelPage verifyShortenURL()
	{
		String shortenURL = getTextBoxVal(CommunicationRepository.communicationpage_qrChannel_commURL, DOM_Attribute_Value);
		if (shortenURL.contains("marketingstar.io"))
		{
			isDisplayed(CommunicationRepository.communicationpage_qrChannel_QRCode);
			if (isSelected(CommunicationRepository.communicationpage_qrChannel_shorturlCheckbox))
			{
				uiPageEqualswithInputValue(shortenURL, getStrText(CommunicationRepository.communicationpage_qrChannel_QRCode));
			}
		}
		return this;
	}

	public boolean enterCommRedirectionURL()
	{
		enterValue(CommunicationRepository.communicationpage_qrChannel_redirectionURL, BaseTest.getData().QRRedirectUrl).tabAction();
		if (isElementPresent(CommunicationRepository.communicationpage_qrChannel_redirURL_validation))
		{
			String response = getTextBoxVal(CommunicationRepository.communicationpage_qrChannel_redirURL_validation, DOM_Attribute_Class);
			if (response.contains("green"))
			{
				mouseHover(CommunicationRepository.communicationpage_qrChannel_redirectionURL_help);
				return isElementAvailable(CommunicationRepository.communicationpage_qrChannel_helptooltip);
			}
		}
		return false;
	}

	public boolean qrKYCFormtoggleBtn(String Condition)
	{
		String kycStatus = getTextBoxVal(CommunicationRepository.communicationpage_qrChannel_kyc_toggleBtn, DOM_Attribute_Class);
		if (!kycStatus.contains("switch-" + Condition.toLowerCase()))
		{
			clickElement(CommunicationRepository.communicationpage_qrChannel_kyc_toggleBtn);
		}
		BaseTest.getTest().log(Status.INFO, "KYC Form toggle button Status as <b> " + Condition + "</b>");
		return Condition.equalsIgnoreCase("ON");
	}

	public CommunicationQRChannelPage selectKYCForm()
	{
		if (isElementPresent(CommunicationRepository.communicationpage_qrChannel_kyc_formsdropDown))
		{
			clickElement(CommunicationRepository.communicationpage_qrChannel_kyc_formsdropDown);
			if (!selectlistelements(CommunicationRepository.communicationpage_qrChannel_kyc_formsdropDownlist, BaseTest.getData().FormNameNew))
			{
				selectlistelements(CommunicationRepository.communicationpage_qr_kycFormDropDownList, BaseTest.getData().FormNameOld);
			}
			pageLoaderLogo();
			explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_qrChannel_kyc_previewicon), 30);
		}
		return this;
	}

	public CommunicationQRChannelPage clickFormPreview()
	{
		if (isElementAvailable(CommunicationRepository.communicationpage_qrChannel_kyc_previewicon))
		{
			clickElement(CommunicationRepository.communicationpage_qrChannel_kyc_previewicon);
			explicitwaitforvisibility(autolocator(CommunicationRepository.communicationpage_qrChannel_kyc_prepiewPopup), 20);
			uiPageEqualswithInputValue("KYC preview", getStrText(CommunicationRepository.communicationpage_qrChannel_kyc_prepiewPopup_header));
			BaseTest.takeScreenshot();
			clickElement(CommunicationRepository.communicationpage_qrChannel_kyc_prepiewPopup_close);
		}
		return this;
	}

	public CommunicationQRChannelPage generateQR()
	{
		javaScriptScrollDown();
		if (isEnabled(CommunicationRepository.communicationpage_qrChannel_generateQR))
		{
			clickElement(CommunicationRepository.communicationpage_qrChannel_generateQR);
			pageLoaderLogo();
		}
		return this;
	}

	public CommunicationQRChannelPage clickDownloadQR()
	{
		pageLoaderLogo();
		if (isEnabled(CommunicationRepository.communicationpage_qrChannel_downloadQR))
		{
			clickElement(CommunicationRepository.communicationpage_qrChannel_downloadQR);
			if (selectlistelements(CommunicationRepository.communicationpage_qrChannel_dwndFormat_dropDownlist, BaseTest.getData().DownloadQR))
			{
				String parentWd = parentWinHandle();
				switchWindow();
				javaScriptPageLoad();
				BaseTest.takeScreenshot();
				switchParentWin(parentWd);
			}
		}
		return this;
	}

	// Scan and Decode the QR Code
	public CommunicationQRChannelPage scanQRCode(int scanLimit)
	{
		javaScriptScrollDownToSomeExtend();
		threadSleep(ObjectRepository.wait5sec);
		javaScriptScrollDownToSomeExtend();

		clickElement(CommunicationRepository.communicationpage_select_qr_dwnldtoogle);
		selectlistelements(",xpath, //div[@class='dropdown-menu show dropdown-menu-end']//a", BaseTest.getData().DownloadQR);
		String parentHandle = parentWinHandle(); // get the current window handle
		switchWindow();
		threadSleep(ObjectRepository.wait3sec);
		BaseTest.takeScreenshot();

		PreferencesPage pref = getPageFactory().preferencesPage();
		String parentwd = parentWinHandle();
		String path = BaseTest.curr_Dir + "/src\\main\\resources\\data\\uploadfiles\\QR-Audience.csv";
		int count = 0;
		for (Map<String, String> testData : dataFileReader(path))
		{
			if (scanLimit > count)
			{
				// Delete all cookies and Scan QR
				deleteAllCookies();
				String url = getTextBoxVal(CommunicationRepository.communicationpage_qrChannel_dwndlink, "src");
				String decodedQRCode = scanQRCode(url);

				// Form Submission
				javaScriptopenNewWindow();
				switchWindow();
				getWebURL(decodedQRCode);
				pref.publishForm(testData.get("Name"), testData.get("MobileNo"), testData.get("EmailID"), testData.get("TLGender"), testData.get("City"));
				childWindowCloseIndex(2);
				switchWindowByIndex(1);
			} else
			{
				break;
			}
			count++;
		}
		switchParentWin(parentHandle);

		return this;
	}

// PHASE - 03
	public CommunicationQRChannelPage qrSMSCommunication()
	{
		String content = "Hi this is QA-Automation_ " + communicationName + BaseTest.getData().SmartLink;
		pageLoaderLogo();
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_qr_SMScomm_PotentialAudience), 20);
		enterValue(CommunicationRepository.communicationpage_qr_SMScomm_PotentialAudience, BaseTest.getData().QRReach);
		enterValue(CommunicationRepository.communicationpage_qr_SMScomm_MobileNo, BaseTest.getData().MobileNo);
		enterValue(CommunicationRepository.communicationpage_qr_SMScomm_msgContent, content);
		enterValue(CommunicationRepository.communicationpage_qr_SMScomm_redirectionURL, BaseTest.getData().SmartLink);
		BaseTest.takeScreenshot();
		javaScriptScrollDownToSomeExtend();
		if (isEnabled(CommunicationRepository.communicationpage_qr_SMScomm_Apply))
		{
			// javaScriptScrollUpToSomeExtend();

			clickElement(CommunicationRepository.communicationpage_qr_SMScomm_Apply);
			pageLoaderLogo();
			javaScriptScrollUpToSomeExtend();
			explicitwaitforvisibility(autolocator(CommunicationRepository.communicationpage_qr_SMScomm_QRcode), 30);
			if (isDisplayed(CommunicationRepository.communicationpage_qr_SMScomm_QRcode))
			{
				downloadQRCode();
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "QR generate apply button has disabled");
			BaseTest.takeScreenshot();
		}
		javaScriptScrollDownToSomeExtend();
		return this;
	}

	public CommunicationQRChannelPage qrTextCommunication()
	{
		pageLoaderLogo();
		explicitwaitforclick(autolocator("Potential audience,id,txtRichTextRecipientReach"), 20);
		enterValue("Potential audience,id,txtRichTextRecipientReach", "30");
		enterValue("Redirction URL,id,txtRichRedirectURL", BaseTest.getData().SmartLink);
		switchToFrame(0);
		enterValue("Communication text,tag,body", "Hi this is QA-Automation " + communicationName);
		defaultContents();
		if (isEnabled("Apply button,xpath,//div[@class='tab-pane active']//div[@class='qr-preview-overlay click-off']/../a"))
		{
			// javaScriptScrollUpToSomeExtend();
			clickElement("Apply button,xpath,//div[@class='tab-pane active']//div[@class='qr-preview-overlay click-off']/../a");
			pageLoaderLogo();
			javaScriptScrollUpToSomeExtend();
			explicitwaitforvisibility(autolocator("QR Code,xpath,//div[@class='tab-pane active']//div[@class='qr-preview-overlay']"), 20);
			if (isDisplayed("QR Code,xpath,//div[@class='tab-pane active']//div[@class='qr-preview-overlay']"))
			{
				downloadQRCode();
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "QR generate apply button has disabled");
			BaseTest.takeScreenshot();
		}

		return this;
	}

	public CommunicationQRChannelPage qrDetails()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("QR CHANNEL", ExtentColor.BLUE));

		javaScriptScrollIntoView(CommunicationRepository.communicationpage_select_qr_recipientreach);
		threadSleep(ObjectRepository.wait2sec);
		javaScriptScrolltoTop();
		clickElement(CommunicationRepository.communicationpage_select_qr_recipientreach);
		enterValue(CommunicationRepository.communicationpage_select_qr_recipientreach, "30");
		String commUrlValue = getTextBoxVal(CommunicationRepository.communicationpage_qr_communicationurl, "value");
		if (commUrlValue.isEmpty())
		{
			String smartLink = BaseTest.getData().SmartLink;
			enterValue(CommunicationRepository.communicationpage_qr_communicationurl, smartLink);
		}
		enterValue(CommunicationRepository.communicationpage_select_qr_redirecturl, BaseTest.getData().QRRedirectUrl);
		tabAction();
		pageLoaderLogo();
		String file = BaseTest.curr_Dir + "\\src\\main\\resources" + "\\data\\uploadfiles\\QRImage.jpg";
		sendValues(CommunicationRepository.communicationpage_qruploadLogo, file);
		threadSleep(ObjectRepository.wait5sec);
		if (!getTextBoxVal(CommunicationRepository.communicationpage_qrwebKYCCheck, "class").contains("switch-on"))
		{
			clickElement(CommunicationRepository.communicationpage_qr_kyc_btn);
			BaseTest.getTest().log(Status.INFO, "Set Web KYC as ON");
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Web KYC is ON");
		}
		javaScriptScrollDown();

		javaScriptScrollUpToSomeExtend();
		threadSleep(ObjectRepository.wait1sec);
		clickElement(CommunicationRepository.communicationpage_qr_kycFormDropDown);
		// clickElement(CommunicationRepository.communicationpage_qr_kycFormDropDown);
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().FormNameNew);

		clickElement(CommunicationRepository.communicationpage_qr_kycFormPreview);
		BaseTest.takeScreenshot();
		clickElement(CommunicationRepository.communicationpage_qr_kycFormPreviewClose);
		javaScriptScrollDown();
		threadSleep(ObjectRepository.wait5sec);

		clickElement(CommunicationRepository.communicationpage_select_qr_genclick);

		threadSleep(ObjectRepository.wait20sec);
		pageLoaderLogo();
		dwnldToggle(BaseTest.getData().DownloadQR);

		javaScriptScrollDown();
		return this;
	}

	public CommunicationQRChannelPage clickSaveqrPage()
	{
		threadSleep(ObjectRepository.wait10sec);
		clickElement(CommunicationRepository.communicationpage_select_qr_clicksave);
		return this;
	}

	public CommunicationQRChannelPage dwnldToggle(String lval)
	{
		javaScriptScrollUpToSomeExtend();
		threadSleep(ObjectRepository.wait10sec);

		clickElement(CommunicationRepository.communicationpage_select_qr_dwnldtoogle);
		selectlistelements(",xpath, //div[@class='dropdown-menu show dropdown-menu-end']//a", lval);
		String parentHandle = parentWinHandle(); // get the current window handle
		switchWindow();
		threadSleep(ObjectRepository.wait3sec);
		BaseTest.takeScreenshot();
		driver.close(); // close newly opened window when done with it
		switchParentWin(parentHandle);
		return this;
	}

	public CommunicationQRChannelPage qrCommunication(String Communication)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("QR CHANNEL - " + Communication + " Communication", ExtentColor.BLUE));
		javaScriptScrolltoTop();
		clickElement(CommunicationRepository.communicationpage_qr_SMS);
		return this;
	}

	public void imageuploadvalidation()
	{
		// javaScriptScrollDownToSomeExtend();
		String file = BaseTest.curr_Dir + "\\src\\main\\resources" + "\\data\\uploadfiles\\QRImage.jpg";
		sendValues(CommunicationRepository.communicationpage_qruploadLogo, file);
		pageLoaderLogo();
		// javaScriptScrollIntoView("img,xpath,//canvas[@id='myQR']//..//img");
		String imagesrc = findElement("img,xpath,//canvas[@id='myQR']//..//img").getAttribute("src");
		if (imagesrc.contains("data:image/jpg;base64,/9j/4QAYRXhpZgAASUkqAAgAAAAAAAAAAAAAAP"))
		{
			BaseTest.getTest().info("Image is uploaded and it is displayed above the qr code");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().info("Image is not uploaded and it is not displayed above the qr code");
			BaseTest.takeScreenshot();
		}
	}

	public void imagesizeslide()
	{

		Actions action = new Actions(driver);
		String defaultsize = getStrText(CommunicationRepository.communicationpage_select_qr_imagesize);
		if (defaultsize.equals("200px"))
		{
			BaseTest.getTest().info("Default Image size is diplayed as expected");
		} else
		{
			BaseTest.getTest().fail("Default Image size is not diplayed as expected");
			BaseTest.takeScreenshot();
		}
		WebElement slide = findElement(CommunicationRepository.communicationpage_select_qr_slide);
		action.clickAndHold(slide).moveByOffset(20, 0).release().perform();
		threadSleep(ObjectRepository.wait2sec);
		String size = getStrText(CommunicationRepository.communicationpage_select_qr_imagesize);
		if (size.equals("661px"))
		{
			BaseTest.getTest().info("Image size Slider button is working as expected");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().fail("Image size Slider button is not working as expected");
			BaseTest.takeScreenshot();
		}
	}

	public void redirectionalqrscan()
	{
		javaScriptScrollDownToSomeExtend();
		String redirectionalurl = findElement(CommunicationRepository.communicationpage_select_qr_redirecturl).getAttribute("value");
		threadSleep(ObjectRepository.wait10sec);
		javaScriptScrollDownToSomeExtend();
		clickElement(CommunicationRepository.communicationpage_select_qr_dwnldtoogle);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().DownloadQR);
		String parentHandle = parentWinHandle(); // get the current window handle
		switchWindow();
		threadSleep(ObjectRepository.wait3sec);
		BaseTest.takeScreenshot();

		PreferencesPage pref = getPageFactory().preferencesPage();
		String parentwd = parentWinHandle();

		// Delete all cookies and Scan QR
		deleteAllCookies();
		String url = getTextBoxVal(CommunicationRepository.communicationpage_qrChannel_dwndlink, "src");
		String decodedQRCode = scanQRCode(url);
		javaScriptopenNewWindow();
		switchWindow();
		getWebURL(decodedQRCode);
		if (getCurrentUrl().equals(redirectionalurl))
		{
			BaseTest.getTest().info("Qr code is navigated to Redirectional url and its is verified");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().info("Qr code is not  navigated to Redirectional url and its is verified");
			BaseTest.takeScreenshot();
		}
		// pref.publishForm(testData.get("Name"), testData.get("MobileNo"), testData.get("EmailID"), testData.get("TLGender"), testData.get("City"));
		childWindowCloseIndex(2);
		switchWindowByIndex(1);

		switchParentWin(parentHandle);
	}

	public void shorturl()
	{
		String communicationurl = findElement(CommunicationRepository.communicationpage_select_qr_url_content).getAttribute("value");
		clickElement(CommunicationRepository.communicationpage_select_qr_shorturl);
		threadSleep(ObjectRepository.wait2sec);
		isDisplayed(CommunicationRepository.communicationpage_select_qr_shorturl_captcha);
		isDisplayed(CommunicationRepository.communicationpage_select_qr_shorturl_);
		String shorturl = findElement(CommunicationRepository.communicationpage_select_qr_shorturl_captcha).getText();
		String shorturl1 = findElement(CommunicationRepository.communicationpage_select_qr_shorturl_).getText();
		if (communicationurl.equals(shorturl) && shorturl1.contains(communicationurl))
		{
			BaseTest.getTest().info("Short url is present as expected");
		}

	}

	public void downloadQRCode()
	{
		javaScriptScrollDownToSomeExtend();
		threadSleep(ObjectRepository.wait5sec);
		javaScriptScrollDownToSomeExtend();
		clickElement(CommunicationRepository.communicationpage_select_qr_dwnldtoogle);
		selectlistelements(",xpath, //div[@class='dropdown-menu show dropdown-menu-end']//a", BaseTest.getData().DownloadQR);
		String parentHandle = parentWinHandle(); // get the current window handle
		switchWindow();
		threadSleep(ObjectRepository.wait3sec);
		BaseTest.takeScreenshot();
		childWindowClose(parentHandle);
	}

}
