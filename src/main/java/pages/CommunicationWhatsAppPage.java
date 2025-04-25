package pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Page;

import repository.CommunicationRepository;
import repository.DashboardRepository;
import repository.ObjectRepository;
import utility.BaseTest;
import utility.PageFactory;

public class CommunicationWhatsAppPage extends CommunicationSMSChannelPage
{

	public CommunicationWhatsAppPage(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	public CommunicationWhatsAppPage whatsAppSenderName()
	{

		explicitwaitforclick(autolocator("Whatsapp tab,xpath,//i[contains(@class,'whatsapp')]"), 30);
		clickElement("Whatsapp tab,xpath,//i[contains(@class,'whatsapp')]");
		pageLoaderLogo();
		explicitwaitforclick(autolocator(CommunicationRepository.communicationwhatsapp_senderdomainclick), 30);
		clickElement(CommunicationRepository.communicationwhatsapp_senderdomainclick);
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_communicationtype_listbox), 20);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Gupshup");
		threadSleep(ObjectRepository.wait3sec);
		return this;
	}

	public CommunicationWhatsAppPage whatsAppTemplate(String WhatsAppTemplateName)
	{
		clickElement(CommunicationRepository.communicationwhatsapp_Templatelanguageclick);
		threadSleep(ObjectRepository.wait5sec);
		// explicitwaitforclick(autolocator(CommunicationRepository.communicationwhatsapp_TemplatelanguageSelect), 30);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "en");

		if (isDisplayed(CommunicationRepository.communicationwhatsapp_templatenameclick))
		{
			clickElement(CommunicationRepository.communicationwhatsapp_templatenameclick);
			threadSleep(ObjectRepository.wait5sec);
			selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, WhatsAppTemplateName);
			threadSleep(ObjectRepository.wait2sec);
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Template name field is not displayed");
			BaseTest.takeScreenshot();
		}
		return this;

	}

	public CommunicationWhatsAppPage whatsAppChannelClick()
	{
		clickElement(CommunicationRepository.communicationauthoring_mobileiconclick);
		clickElement(CommunicationRepository.communication_whatsapp_whatsappiconclick);
		return this;
	}

	public CommunicationWhatsAppPage whatsAppImage()
	{

		clickElement(CommunicationRepository.communicationwhatsapp_authoringpage_imageiconclick);
		threadSleep(ObjectRepository.wait3sec);
		selectlistelements(CommunicationRepository.communicationwhatsapp_authoringpage_imagetypeselect, "Image URL");
		threadSleep(ObjectRepository.wait3sec);
		enterValue(CommunicationRepository.communicationwhatsapp_authoringpage_image_enterurl, "https://3c5239fcccdc41677a03-1135555c8dfc8b32dc5b4bc9765d8ae5.ssl.cf1.rackcdn.com/Adver--Banners--150x750px-RIOT.jpg");
		threadSleep(ObjectRepository.wait2sec);
		tab();
		threadSleep(ObjectRepository.wait5sec);
		clickElement(CommunicationRepository.communicationwhatsapp_authoringpage_imagetypeclick);
		threadSleep(ObjectRepository.wait5sec);
		selectlistelements(CommunicationRepository.communicationwhatsapp_authoringpage_imagetypeselect, "JPG");
		clickElement(CommunicationRepository.communicationwhatsapp_authoringpage_mediasavebutton);
		if (isDisplayed(CommunicationRepository.communicationwhatsapp_authoringpage_whatsappimagepreview))
		{
			BaseTest.getTest().log(Status.INFO, "Given image is uploaded succesfully");
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Given image is not uploadedy");
		}
		return this;

	}

	public CommunicationWhatsAppPage whatsAppVideo()
	{

		clickElement(CommunicationRepository.communicationwhatsapp_authoringpage_videoicon);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(CommunicationRepository.communicationwhatsapp_authoringpage_videourl);
		enterValue(CommunicationRepository.communicationwhatsapp_authoringpage_image_enterurl, "https://www.");
		clickElement(CommunicationRepository.communicationwhatsapp_authoringpage_imagetypeclick);
		threadSleep(ObjectRepository.wait2sec);
		selectlistelements(CommunicationRepository.communicationauthoring_whatsappiconclick, "JPG");
		clickElement(CommunicationRepository.communicationwhatsapp_authoringpage_mediasavebutton);
		if (isDisplayed(CommunicationRepository.communicationwhatsapp_authoringpage_whatsappimagepreview))
		{
			BaseTest.getTest().log(Status.INFO, "Given image is uploaded succesfully");
		}
		return this;
	}

	public CommunicationWhatsAppPage whatsAppPreview()
	{
		String[] val = BaseTest.getData().MobileNo.split(",");
		for (String splitvalues : val)
		{
			String numbers = getTextBoxVal(CommunicationRepository.sms_testnumber, "value");
			for (int i = 4; i < numbers.length(); i++)
			{
				findElements(CommunicationRepository.sms_testnumber).get(0).sendKeys(Keys.BACK_SPACE);
			}
			enterValue(CommunicationRepository.sms_testnumber, splitvalues);
			tabAction();
			pageLoaderLogo();
			explicitwaitforclick(autolocator(CommunicationRepository.sms_testnumber), 30);
			clickElement(CommunicationRepository.communicationpage_email_sendTestEmailSendBtn);
			try
			{
				explicitwaitforvisibility(autolocator(CommunicationRepository.email_testmail_msg), 50);
				if (getStrText(CommunicationRepository.email_testmail_msg).equalsIgnoreCase("Test communication will be sent shortly"))
				{
					BaseTest.takeScreenshot();
					threadSleep(ObjectRepository.wait5sec);
				} else
				{
					if (getStrText(CommunicationRepository.email_testmail_msg).equalsIgnoreCase("Your previous request is in progress"))
					{
						BaseTest.takeScreenshot();
						clickElement(CommunicationRepository.popupclosebutton);
						String numbers1 = getTextBoxVal(CommunicationRepository.sms_testnumber, "value");
						for (int i = 4; i < numbers1.length(); i++)
						{
							findElements(CommunicationRepository.sms_testnumber).get(0).sendKeys(Keys.BACK_SPACE);
						}
						threadSleep(ObjectRepository.wait5sec);
						enterValue(CommunicationRepository.sms_testnumber, splitvalues);
						tabAction();
						pageLoaderLogo();
						explicitwaitforclick(autolocator(CommunicationRepository.sms_testnumber), 30);
						clickElement(CommunicationRepository.communicationpage_email_sendTestEmailSendBtn);
					} else
					{
						BaseTest.getTest().log(Status.FAIL, "Popup present but content is different");
						BaseTest.takeScreenshot();
					}
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

	public CommunicationWhatsAppPage whatsAppPDF()
	{

		clickElement(CommunicationRepository.communicationwhatsapp_authoringpage_videoicon);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(CommunicationRepository.communicationwhatsapp_authoringpage_videourl);
		enterValue(CommunicationRepository.communicationwhatsapp_authoringpage_image_enterurl, "https://www.");
		clickElement(CommunicationRepository.communicationwhatsapp_authoringpage_imagetypeclick);
		threadSleep(ObjectRepository.wait2sec);
		selectlistelements(CommunicationRepository.communicationauthoring_whatsappiconclick, "JPG");
		clickElement(CommunicationRepository.communicationwhatsapp_authoringpage_mediasavebutton);
		if (isDisplayed(CommunicationRepository.communicationwhatsapp_authoringpage_whatsappimagepreview))
		{
			BaseTest.getTest().log(Status.INFO, "Given image is uploaded succesfully");
		}
		return this;
	}

	public CommunicationWhatsAppPage enterWhatsAppContentwithPersonalization()
	{

		javaScriptScrollDownToSomeExtend();
		String template = getStrText(CommunicationRepository.communication_whatsapp_enterwhatsappcontent);
		clearField(CommunicationRepository.communication_whatsapp_enterwhatsappcontent);
		clickElement(CommunicationRepository.communication_whatsapp_selectpersonalization);
		selectlistelements(CommunicationRepository.communication_cssdropdown, System.getProperty("smsPersona_1"));
		threadSleep(ObjectRepository.wait3sec);

		String personaAdded = getStrText(CommunicationRepository.communication_whatsapp_enterwhatsappcontent);
		clearField(CommunicationRepository.communication_whatsapp_enterwhatsappcontent);
		clickElement(CommunicationRepository.authoringpage_smartlink);
		selectlistelements(CommunicationRepository.communication_cssdropdown, "Smart link 1");
		threadSleep(ObjectRepository.wait5sec);
		/////////////////////////////////////////
		// SELECT OFFER CODE
		// selectOffer("common");
		String smartLinkAdded = getStrText(CommunicationRepository.communication_whatsapp_enterwhatsappcontent);
		//// Emoji script
		clickElement(",id,rs_RSEmojiPicker_Emoji");
		WebElement ele = driver.findElement(By.xpath("//em-emoji-picker")).getShadowRoot().findElement(By.cssSelector("span.emoji-mart-emoji>span"));
		ele.click();

		clickElement(",id,rs_RSEmojiPicker_Emoji");

		String Errormsg = getStrText(",xpath,/.//div[@class='validation-message color-primary-red']");
		writeLog(Errormsg.equalsIgnoreCase("Edit the text present inside the curly braces {{ }} only"), "Error message is shown correctly .", "Error message is not shown expected");
		// Edit the text present inside the curly braces {{ }} only
		clearField(CommunicationRepository.communication_whatsapp_enterwhatsappcontent);
		threadSleep(ObjectRepository.wait3sec);
		threadSleep(ObjectRepository.wait3sec);

		String Errormsg2 = getStrText(",xpath,/.//div[@class='validation-message color-primary-red']");
		writeLog(Errormsg2.equalsIgnoreCase("Enter message"), "Error message is shown correctly .", "Error message is not shown expected");
		// Enter message

		String valuesAddedTemp = template.replace("{{1}}", "{{" + personaAdded + "}}").replace("{{2}}", "{{" + smartLinkAdded + "}}");
		enterValue(CommunicationRepository.communication_whatsapp_enterwhatsappcontent, valuesAddedTemp);
		String previewmessage = getStrText(",xpath,/.//p");
		writeLog(previewmessage.equalsIgnoreCase(valuesAddedTemp), "Valid message is shown in preview pannel correctly .", "invalid message is not shown in preview pannel expected");
		// valuesAddedTemp
		if (personaAdded.contains(System.getProperty("smsPersona_1")))
		{
			BaseTest.getTest().log(Status.INFO, "Persona is added successfully");
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Persona is not added (OR) Unable to edit WhatsApp Content ");
		}
		if (smartLinkAdded.contains("https://"))
		{
			BaseTest.getTest().log(Status.INFO, "Smart link is added successfully");
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Smart link is not added (OR) Unable to edit WhatsApp Content");
		}
		javaScriptScrollDownToSomeExtend();
		clickElement("Preview,id,rs_data_eye");
		isDisplayed("Preview block,xpath,//div[contains(@class,'block-whatsapp')]");
		clickElement("Close icon,xpath,//i[contains(@class,'close-edge-medium')]");
		threadSleep(ObjectRepository.wait2sec);
		BaseTest.takeScreenshot();
		return this;
	}

	public void whatsappRegressionTests() throws AWTException
	{
		explicitwaitforclick(autolocator("Whatsapp tab,xpath,//i[contains(@class,'whatsapp')]"), 30);
		clickElement("Whatsapp tab,xpath,//i[contains(@class,'whatsapp')]");
		pageLoaderLogo();
		String senderIdClassAttValue = getTextBoxVal("Sender name,xpath,//span[contains(@aria-label,'Sender name')]", "class");
		writeLog(senderIdClassAttValue.contains("required"), "Sender name dropdown is set as mandatory as expected", "Sender name dropdown is not set as mandatory");
		clickElement("Sender name,xpath,//span[@aria-label='Sender name']");
		tabAction();
		writeLog(isElementPresent(",xpath,//span[@aria-label='Select sender name']"), "Sender name validation message is diplayed as expected", "Sender name validation message is not diplayed");
		clickElement(",xpath,//span[@aria-label='Select sender name']");
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_communicationtype_listbox), 20);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Gupshup");
		String audienceClassAttValue = getTextBoxVal("Audience,xpath,//label[contains(.,'audience')]/..//div[contains(@class,'solid')]", "class");
		writeLog(audienceClassAttValue.contains("required"), "Audience dropdown is set as mandatory as expected", "Audience dropdown is not set as mandatory");
		clickElement("Audience,xpath,//label[contains(.,'audience')]/..//div[contains(@class,'solid')]");
		tabAction();
		boolean audienceErrmsg = isElementPresent(",xpath,//label[contains(.,'Select audience')]/..//div[contains(@class,'solid')]");
		writeLog(audienceErrmsg, "Audience dropdown validation message is diplayed as expected", "Audience dropdown validation message is not diplayed");
		clickElement(",xpath,//label[contains(.,'Select audience')]/..//div[contains(@class,'solid')]");
		selectlistelementsAndProceed(CommunicationRepository.communicationpage_communicationtype_listbox, BaseTest.getData().TargetListNew);
		String tempLanguageClassValue = getTextBoxVal("Temp language,xpath,//span[contains(@aria-label,'language')]", "class");
		writeLog(tempLanguageClassValue.contains("required"), "Template language is set as mandatory as expected", "Template language is not set as mandatory");
		boolean tempLangErrmsg = isElementPresent(",xpath,//span[contains(@aria-label,'Select template language')]");
		writeLog(tempLangErrmsg, "Template language validation message is diplayed as expected", "Template language dropdown validation message is not diplayed");
		javaScriptScrollDownToSomeExtend();
		clickElement(",id,rs_Messaging_templatelanguage");
		threadSleep(ObjectRepository.wait5sec);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "en");
		pageLoaderLogo();
		javaScriptScrollDownToSomeExtend();
		String tempNameClassValue = getTextBoxVal("Temp name,xpath,//span[@aria-label='Template name']", "class");
		writeLog(tempNameClassValue.contains("required"), "Template name is set as mandatory as expected", "Template name is not set as mandatory");
		clickElement("Temp name,xpath,//span[@aria-label='Template name']");
		threadSleep(ObjectRepository.wait3sec);
		tabAction();
		boolean tempNameErrmsg = isElementPresent(",xpath,//span[contains(@aria-label,'Select template name')]");
		writeLog(tempNameErrmsg, "Template name validation message is diplayed as expected", "Template name dropdown validation message is not diplayed");
		clickElement("Template name,xpath,//span[contains(@aria-label,'Select template name')]");
		threadSleep(ObjectRepository.wait5sec);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "after_24_hours_001");
		threadSleep(ObjectRepository.wait3sec);
		BaseTest.takeScreenshot();
		javaScriptScrollDownToSomeExtend();
//		String defaultTempUI = getStrText("Textbox,xpath,//*[@name='editorText']");
//		String defaultTemp = "Dear Investor,\r\n" + "\r\n" + "Welcome to UTI Mutual Fund.\r\n" + "\r\n"
//				+ "Now you can check Statements/ NAV, Purchase Products, Start SIP, Switch Transaction, Request Call back, Chat with Agent, Locate branch and much more.\r\n" + "Just type “Hi” to start the conversation";
//		boolean equals = defaultTempUI.equals(defaultTemp);
//		writeLog(defaultTempUI.equals(defaultTemp), "Default template text availbale as expected", "Default template text is mismatched or not available");
		enterValue("Textbox,xpath,//*[@name='editorText']", "Test");
		boolean errmessage2 = isElementPresent("Err message,xpath,//div[contains(@class,'validation')][.='Edit the text present inside the curly braces {{ }} only']");
		writeLog(errmessage2, "Validation message is thrown when enter the value outside the curly braces.", "Validation message is not thrown when enter the value outside the curly braces");
		clearField("Textbox,xpath,//*[@name='editorText']");
		boolean errmessage1 = isElementPresent("Err message,xpath,//div[contains(@class,'validation')][.='Enter message']");
		writeLog(errmessage1, "Validation message is thrown when without proceeding any value in message box.", "Validation message is not thrown when without proceeding any value in message box.");
		String character500 = "TestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestinTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTesgTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTestingTesting";
		enterValue("Textbox,xpath,//*[@name='editorText']", character500);
		findElement("Textbox,xpath,//*[@name='editorText']").sendKeys(character500 + "Test");
		String whatsapplength = getStrText("Whatsapp length,xpath,//span[@class='emr-length']").substring(0, 4);
		writeLog(whatsapplength.equals("1000"), "Whatsapp message box accepts only 1000 characters as expected", "Whatsapp message box accepts more than 1000 characters");
		clickElement(",id,rs_RSEmojiPicker_Emoji");
		WebElement ele = driver.findElement(By.xpath("//em-emoji-picker")).getShadowRoot().findElement(By.cssSelector("span.emoji-mart-emoji>span"));
		javaScriptScrollUpToSomeExtend();
		ele.click();
		clickElement(",id,rs_RSEmojiPicker_Emoji");

		// selectTemplateName("sales2106");
		threadSleep(ObjectRepository.wait3sec);
//		whatsappImageUrl("https://commondatastorage.googleapis.com/codeskulptor-assets/lathrop/nebula_brown.png", "PNG");
//		whatsappRemoveUploadedImg();
//		whatsappImageUrl("https://www.gstatic.com/webp/gallery/2.jpg", "JPG");
//		livePreviewCheck();
//		selectTemplateName("sales1801v02");
//		whatsappVideoUpload("https://dm0qx8t0i9gc9.cloudfront.net/watermarks/video/no0jF1g/videoblocks-aerial-lithuania-10100-vilnius-june-2018-sunny-day-90mm-zoom-4k-inspire-2-p_sjg7h_xrie__2ea5ea26ed696a3d01bcadc04a058bc0__P360.mp4", "MP4");
//		whatsappVideoRemove();
//		selectTemplateName("buddy1702v2 ");
//		whatsappPdfUpload("https://www.clickdimensions.com/links/TestPDFfile.pdf");
//		whatsappRemovePdf();
		isElementAvailable(CommunicationRepository.whatsapp_authoring_emoji);

	}

	public void whatsappImageUrl(String path, String type)
	{
		clickElement(CommunicationRepository.whatsapp_authoring_imageupload);
		explicitwaitforclick(autolocator(CommunicationRepository.whatsapp_authoring_imageuploadoptios), 20);
		clickElement(CommunicationRepository.whatsapp_authoring_imageurl);
		explicitwaitforclick(autolocator(CommunicationRepository.whatsapp_authoring_urlinput), 20);
		clickElement(CommunicationRepository.whatsapp_authoring_urlinput);
		enterValue(CommunicationRepository.whatsapp_authoring_urlinput, path);
		tabAction();
		pageLoaderLogo();
		explicitwaitforclick(autolocator(CommunicationRepository.whatsapp_authoring_urlupload), 20);
		clickElement(CommunicationRepository.whatsapp_authoring_urlupload);
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforvisibility(autolocator(CommunicationRepository.whatsapp_authoring_previewimage), 20);
		boolean previewImage = isElementPresent(CommunicationRepository.whatsapp_authoring_previewimage);
		writeLog(previewImage, type + " image is uploaded successfully.", type + " image is not uploaded.");
	}

	public void whatsappRemoveUploadedImg()
	{
		clickElement(CommunicationRepository.whatsapp_authoring_imageupload);
		explicitwaitforclick(autolocator(CommunicationRepository.whatsapp_authoring_imageuploadoptios), 20);
		clickElement(CommunicationRepository.whatsapp_authoring_removeimg);
		threadSleep(ObjectRepository.wait3sec);
		boolean previewImage = isElementPresent(CommunicationRepository.whatsapp_authoring_previewimage);
		writeLog(!previewImage, "Uploaded image removed successfully", "Uploaded image is not removed");
	}

	public void livePreviewCheck()
	{

		clickElement(CommunicationRepository.whatsapp_authoring_preview);
		explicitwaitforvisibility(autolocator(CommunicationRepository.whatsapp_authoring_livepreviewtemp), 20);
		clickElement(CommunicationRepository.whatsapp_authoring_livepreviewclose);
	}

	public void selectTemplateName(String templateName)
	{
		clickElement("Template name,xpath,//span[@aria-label='Template name']");
		threadSleep(ObjectRepository.wait3sec);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, templateName);
	}

	public void whatsappVideoUpload(String path, String type)
	{

		explicitwaitforclick(autolocator(CommunicationRepository.whatsapp_authoring_videoupload), 20);
		clickElement(CommunicationRepository.whatsapp_authoring_videoupload);
		explicitwaitforclick(autolocator(CommunicationRepository.whatsapp_authoring_imageuploadoptios), 20);
		clickElement(CommunicationRepository.whatsapp_authoring_videourl);
		explicitwaitforclick(autolocator(CommunicationRepository.whatsapp_authoring_urlinput), 20);
		clickElement(CommunicationRepository.whatsapp_authoring_urlinput);
		enterValue(CommunicationRepository.whatsapp_authoring_urlinput, path);
		tabAction();
		pageLoaderLogo();
		explicitwaitforclick(autolocator(CommunicationRepository.whatsapp_authoring_urlupload), 20);
		clickElement(CommunicationRepository.whatsapp_authoring_urlupload);
		threadSleep(ObjectRepository.wait3sec);
		boolean videoPreview = isElementPresent(CommunicationRepository.whatsapp_authoring_videopreview);
		writeLog(videoPreview, type + " video is uploaded successfully.", type + " video is not uploaded.");
	}

	public void whatsappVideoRemove()
	{
		explicitwaitforclick(autolocator(CommunicationRepository.whatsapp_authoring_videoupload), 20);
		clickElement(CommunicationRepository.whatsapp_authoring_videoupload);
		explicitwaitforclick(autolocator(CommunicationRepository.whatsapp_authoring_imageuploadoptios), 20);
		clickElement(CommunicationRepository.whatsapp_authoring_removevideourl);
		boolean videoPreview = isElementPresent(CommunicationRepository.whatsapp_authoring_videopreview);
		writeLog(!videoPreview, "Uploaded Video removed successfully", "Uploaded Video is not removed");
	}

	public void whatsappPdfUpload(String path)
	{
		explicitwaitforclick(autolocator(CommunicationRepository.whatsapp_authoring_pdfUpload), 20);
		clickElement(CommunicationRepository.whatsapp_authoring_pdfUpload);
		explicitwaitforclick(autolocator(CommunicationRepository.whatsapp_authoring_imageuploadoptios), 20);
		clickElement(CommunicationRepository.whatsapp_authoring_pdfoption);
		explicitwaitforclick(autolocator(CommunicationRepository.whatsapp_authoring_urlinput), 20);
		clickElement(CommunicationRepository.whatsapp_authoring_urlinput);
		enterValue(CommunicationRepository.whatsapp_authoring_urlinput, path);
		tabAction();
		pageLoaderLogo();
		explicitwaitforclick(autolocator(CommunicationRepository.whatsapp_authoring_urlupload), 20);
		clickElement(CommunicationRepository.whatsapp_authoring_urlupload);
		threadSleep(ObjectRepository.wait3sec);
		boolean pdfPreview = isElementPresent(CommunicationRepository.whatsapp_authoring_pdfpreview);
		writeLog(pdfPreview, "PDF file is uploaded successfully.", "PDF file is not uploaded.");
	}

	public void whatsappRemovePdf()
	{

		explicitwaitforclick(autolocator(CommunicationRepository.whatsapp_authoring_pdfUpload), 20);
		clickElement(CommunicationRepository.whatsapp_authoring_pdfUpload);
		explicitwaitforclick(autolocator(CommunicationRepository.whatsapp_authoring_imageuploadoptios), 20);
		clickElement(CommunicationRepository.whatsapp_authoring_pdfRemove);
		boolean pdfPreview = isElementPresent(CommunicationRepository.whatsapp_authoring_pdfpreview);
		writeLog(!pdfPreview, "PDF file is removed successfully.", "PDF file is not removed.");
	}

}
