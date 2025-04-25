
package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import utility.PageBase;
import utility.PageFactory;

public class CommunicationNotificationPage extends CommunicationCreatePage
{
	String webPushtitleText;
	String webPushPersona;
	int splitSize, splitTotalCount, splitGroupACount, splitGroupBCount, splitGroupCCount, splitGroupDCount;
	int splitGroupAPercent, splitGroupBPercent, splitGroupCPercent, splitGroupDPercent;

	public CommunicationNotificationPage(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	// Select web push type
	public CommunicationNotificationPage selectUrltosendWebPush()
	{
		javaScriptScrolltoTop();
		BaseTest.getTest().info(MarkupHelper.createLabel("COMMUNICATION WEBPUSH CHANNEL PAGE", ExtentColor.BLUE));
		clickElement(CommunicationRepository.notification_webpush_sendwebpushto);
		threadSleep(ObjectRepository.wait3sec);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "https://visionmutual.qa.smartdx.co/");
		pageLoaderLogo();
//		clickElement(CommunicationRepository.notification_webpush_selectdomainurl);
//		threadSleep(ObjectRepository.wait1sec);
//		selectlistelements(CommunicationRepository.notification_webpush_tempclick, "Enter domain URL");
//		enterValue(CommunicationRepository.notificaiton_webpush_enterdomainurl, BaseTest.getData().DomainUrl);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
		// explicitwaitforvisibility(autolocator(CommunicationRepository.notification_webmobile_domainurlconfirmimg), 30);
		javaScriptScrollUpToSomeExtend();
		return this;
	}

//	// Select Target List
//	public CommunicationNotificationPage webpushAudienceSelect()
//	{
//		threadSleep(ObjectRepository.wait3sec);
//		if (BaseTest.getData().WebMobileAudience.equalsIgnoreCase("All"))
//		{
//			explicitwaitforpresence(autolocator(CommunicationRepository.notification_webpush_webpushAudiencelist), 30);
//			sendValue(CommunicationRepository.notification_webpush_webpushAudiencelist, "All audience");
//			selectlistelements(CommunicationRepository.notification_webpush_selectwebpushtargetlist, "All audience");
//		} else
//		{
//			explicitwaitforpresence(autolocator(CommunicationRepository.notification_webpush_webpushAudiencelist), 30);
//			sendValue(CommunicationRepository.notification_webpush_webpushAudiencelist, BaseTest.getData().WebMobileAudience);
//			selectlistelements(CommunicationRepository.notification_webpush_selectwebpushtargetlist, BaseTest.getData().WebMobileAudience);
//		}
//		return this;
//	}

	// Abdul 08102021
	public CommunicationNotificationPage selectWebPushDeliveryType()
	{
		String WebPushType = BaseTest.getData().WebMobilePushType;
		javaScriptScrollIntoView(CommunicationRepository.notification_webpush_sendwebpushto);
		clickElement(CommunicationRepository.notification_webpush_deliverytype);
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().WebMobilePushType);
		threadSleep(ObjectRepository.wait2sec);
		BaseTest.takeScreenshot();
		clickElement(CommunicationRepository.notification_mobpush_inboxClassification);
		pageLoaderLogo();
		if (BaseTest.getData().WebMobileDeferredDeepLinking.equalsIgnoreCase("ON"))
		{
			selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().WebMobileInboxClassification);
		} else
		{
			// Changed from notification_mobpush_inboxClassificationlist 1 to notification_mobpush_inboxClassificationlist
			selectlistelementsAndProceed(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().WebMobileInboxClassification);
		}
		if (!BaseTest.getData().WebMobileLayoutPosition.isEmpty())
		{
			clickElement(CommunicationRepository.notification_mobpush_layout);
			selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().WebMobileLayoutPosition);
			if (BaseTest.getData().WebMobileLayoutPosition.equalsIgnoreCase("Carousel") || BaseTest.getData().WebMobileLayoutPosition.equalsIgnoreCase("Modal"))
			{
				pageLoaderLogo();
				threadSleep(ObjectRepository.wait2sec);

				clickElement(" ,xpath,//span[@aria-label='Position']");
				selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().WebMobilePosition);
			}
		}
		return this;
	}

	public void webpushImportUrlScrollToInteractivityButton()
	{
		PageBase.threadSleep(700);
		javaScriptScrollToSomeExtend("800");
		PageBase.threadSleep(500);
	}

	// Select Web Push Edm Make Alert // Abdul

	public CommunicationNotificationPage webpushMakeAlertSwitch()
	{
		threadSleep(ObjectRepository.wait3sec);
		javaScriptScrollIntoView(CommunicationRepository.notification_webpush_webclickimport);
		String alertText = getTextBoxVal(CommunicationRepository.notification_webpush_alertswitchONOFF, "class");
		if (BaseTest.getData().WebMobileAlertSwitch.toLowerCase().contains("on"))
		{
			if (!alertText.contains("switch-on"))
			{
				clickElement(CommunicationRepository.notification_webpush_alertswitch);
				BaseTest.getTest().log(Status.INFO, "Set Make Alert as ON");
				WebpushMakeAlertTextTitle();
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Make Alert is ON");
			}

		} else if (BaseTest.getData().WebMobileAlertSwitch.toLowerCase().contains("off"))
		{
			if (!alertText.contains("switch-off"))
			{
				clickElement(CommunicationRepository.notification_webpush_alertswitch);
				BaseTest.getTest().log(Status.INFO, "Set Make Alert as OFF");
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Make Alert is OFF");
			}
		}
		return this;
	}

	public CommunicationNotificationPage webpushSplitCarouselMakeAlertSwitch(String type)
	{
		threadSleep(ObjectRepository.wait3sec);
		javaScriptScrollIntoView(",xpath, //a[@id='WebacnImportUrl" + type + "']");
		String alertText = getTextBoxVal(",xpath,//label[@for='chkWebAlert" + type + "']/../..", "class");
		if (BaseTest.getData().WebMobileAlertSwitch.toLowerCase().contains("on"))
		{
			if (!alertText.contains("switch-on"))
			{
				clickElement(",xpath,//label[@for='chkWebAlert" + type + "']");
				BaseTest.getTest().log(Status.INFO, "Set Make Alert as ON");
				WebpushSplitCarouselMakeAlertTextTitle(type);
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Make Alert is ON");
			}

		} else if (BaseTest.getData().WebMobileAlertSwitch.toLowerCase().contains("off"))
		{
			if (!alertText.contains("switch-off"))
			{
				clickElement(",xpath, //label[@for='chkWebAlert" + type + "']");
				BaseTest.getTest().log(Status.INFO, "Set Make Alert as OFF");
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Make Alert is OFF");
			}
		}
		return this;
	}

	private CommunicationNotificationPage WebpushSplitCarouselMakeAlertTextTitle(String type)
	{
		threadSleep(ObjectRepository.wait3sec);
		String AlertTitleText = communicationName + " , ";
		List<String> objStringPersona = new ArrayList<String>();
		objStringPersona.add(System.getProperty("Persona_3"));
		javaScriptScrollDownToSomeExtend();
		threadSleep(ObjectRepository.wait1sec);
		String Personalization = "Web alert title persona,xpath,//div[@class='form-group wpAlertTitle" + type + "']//div[@id='DescriptionPersonalize']";
		explicitwaitforclick(autolocator(Personalization), 30);
		clickElement(Personalization);
		threadSleep(ObjectRepository.wait3sec);
		List<WebElement> personatxt = driver.findElements(autolocator(CommunicationRepository.notification_webpush_alerttitletextpersonalizationlist));
		for (WebElement allele : personatxt)
		{
			String inputtext = allele.getText();
			if (objStringPersona.contains(inputtext))
			{
				String fallBack = allele.findElement(By.tagName("a")).getAttribute("class").toString();
				if (fallBack.isEmpty() || fallBack.equals("") || fallBack == null || fallBack.equalsIgnoreCase("[[null]]"))
				{
					fallBack = "[[No Data]]";
				}
				webPushtitleText += inputtext + " | " + fallBack + ",";
				fallBack = null;
			}
		}
		clickElement(Personalization);
		try
		{
			sendValue(",xpath, //*[@id='WebTitleAlert" + type + "']/..//div[@placeholder='Enter title']/..//div[@placeholder='Enter title']", webPushtitleText);
			BaseTest.getTest().log(Status.INFO, "Webpush title: " + AlertTitleText);
			webPushtitleText = AlertTitleText;
		} catch (Exception e)
		{
			System.out.println("title exception");
		}

		// Enter description
		String description = "Web alert short description,xpath, // *[@id='divDescriptionPersonalizeWP" + type + "']/..//div[@placeholder='Enter description']";
		if (isDisplayed(description))
		{
			enterValue(description, communicationName);
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Short description not displaying / Unable to enter short description");
		}

		return this;
	}

	private CommunicationNotificationPage WebpushMakeAlertTextTitle()
	{
		threadSleep(ObjectRepository.wait3sec);
		String AlertTitleText = communicationName + " , ";
		List<String> objStringPersona = new ArrayList<String>();
		objStringPersona.add(System.getProperty("Persona_3"));
		javaScriptScrollDownToSomeExtend();
		threadSleep(ObjectRepository.wait1sec);
		explicitwaitforclick(autolocator(CommunicationRepository.notification_webpush_alerttitletextpersonalization), 30);
		clickElement(CommunicationRepository.notification_webpush_alerttitletextpersonalization);
		threadSleep(ObjectRepository.wait3sec);
		List<WebElement> personatxt = driver.findElements(autolocator(CommunicationRepository.notification_webpush_alerttitletextpersonalizationlist));
		for (WebElement allele : personatxt)
		{
			String inputtext = allele.getText();
			if (objStringPersona.contains(inputtext))
			{
				String fallBack = allele.findElement(By.tagName("a")).getAttribute("class").toString();
				if (fallBack.isEmpty() || fallBack.equals("") || fallBack == null || fallBack.equalsIgnoreCase("[[null]]"))
				{
					fallBack = "[[No Data]]";
				}
				webPushtitleText += inputtext + " | " + fallBack + ",";
				fallBack = null;
			}
		}
		clickElement(CommunicationRepository.notification_webpush_alerttitletextpersonalization);
		try
		{
			enterValue(CommunicationRepository.notification_webpush_enteralerttitle, webPushtitleText);
			BaseTest.getTest().log(Status.INFO, "Webpush title: " + AlertTitleText);
			webPushtitleText = AlertTitleText;
		} catch (Exception e)
		{
			System.out.println("title exception");
		}

		// Enter description
		if (isDisplayed(CommunicationRepository.notification_webpush_enteralertshortdescription))
		{
			enterValue(CommunicationRepository.notification_webpush_enteralertshortdescription, communicationName);
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Short description not displaying / Unable to enter short description");
		}

		return this;
	}

	// Select Web push Interactivity // Abdul
	public CommunicationNotificationPage webpushInteractivitySwitch()
	{
		javaScriptScrollIntoView(CommunicationRepository.notification_webpush_selectpersonalization);
		String interactivityText = getTextBoxVal(CommunicationRepository.notification_webpush_selectinteractivityONOFF, "class");
		if (BaseTest.getData().WebMobileInteractivity.toLowerCase().contains("on"))
		{
			if (!interactivityText.contains("switch-on"))
			{
				clickElement(CommunicationRepository.notification_webpush_selectinteractivityswitch);
				BaseTest.getTest().log(Status.INFO, "Set Interactivity as ON");
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Interactivity is ON");
			}
			threadSleep(ObjectRepository.wait1sec);
			clickElement(CommunicationRepository.notification_webpush_selectinteractivitybutton);
			explicitwaitforclick(autolocator(CommunicationRepository.notification_webpush_selectinteractivitybuttonlist), 30);
			selectlistelements(CommunicationRepository.notification_webpush_selectinteractivitybuttonlist, "Button");

			explicitwaitforclick(autolocator(CommunicationRepository.notification_webpush_selectinteractivityaction), 30);
			clickElement(CommunicationRepository.notification_webpush_selectinteractivityaction);
			String WebInteractivityAction = BaseTest.getData().WebMobileInteractivityAction;
			if (WebInteractivityAction.toLowerCase().contains("unsubscribe") || WebInteractivityAction.toLowerCase().contains("dismiss"))
			{
				selectlistelements(CommunicationRepository.notification_webpush_selectinteractivityactionlist, WebInteractivityAction);
			} else if (WebInteractivityAction.contains("Custom Action"))
			{
				selectlistelements(CommunicationRepository.notification_webpush_selectinteractivityactionlist, WebInteractivityAction);
				clickElement(CommunicationRepository.notificaiton_webpush_customactionIcon);
				explicitwaitforvisibility(autolocator(CommunicationRepository.notificaiton_webpush_customButtonText), 20);
				enterValue(CommunicationRepository.notificaiton_webpush_customButtonText, BaseTest.getData().WebMobileCustomButtonName);
				clickElement(CommunicationRepository.notificaiton_webpush_customBehaviour);
				selectlistelements(CommunicationRepository.notificaiton_webpush_customBehaviourList, BaseTest.getData().WebMobileClickBehaviour);
				if (BaseTest.getData().WebMobileClickBehaviour.toLowerCase().contains("enter new link"))
				{
					enterValue(CommunicationRepository.notificaiton_webpush_customactionBehaviourLink, BaseTest.getData().WebMobileClickBehaviourLink);
					clickElement(CommunicationRepository.notificaiton_webpush_customactionBehaviourType);
					selectlistelements(CommunicationRepository.notificaiton_webpush_customactionBehaviourTypeList, BaseTest.getData().WebMobileClickBehaviourType);
				}
				clickElement(CommunicationRepository.notification_webpush_custombuttonpopupsave);
			}
		}
		return this;
	}

	// Select Web Push Expiry // Abdul
	public CommunicationNotificationPage webpushExpirySwitch()
	{
		threadSleep(ObjectRepository.wait3sec);
		javaScriptScrollIntoView(CommunicationRepository.notification_webpush_expiryswitch);
		String expiryText = getTextBoxVal(CommunicationRepository.notification_webpush_expiryswitchONOFF, "class");
		if (BaseTest.getData().WebMobileExpiry.toLowerCase().contains("on"))
		{
			if (!expiryText.contains("switch-on"))
			{
				clickElement(CommunicationRepository.notification_webpush_expiryswitch);
				BaseTest.getTest().log(Status.INFO, "Set expiry as ON");
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Expiry is ON");
			}

			explicitwaitforclick(autolocator(CommunicationRepository.notificaiton_webpush_selectexpirybutton), 30);
			clickElement(CommunicationRepository.notificaiton_webpush_selectexpirybutton);
			selectlistelements(CommunicationRepository.notification_webpush_selectexpirybuttonlist, BaseTest.getData().WebMobileExpirySchdule);
			enterValue(CommunicationRepository.notification_webpush_enterexpiretime, BaseTest.getData().WebMobileExpiryDuration);
		} else if (BaseTest.getData().WebMobileExpiry.toLowerCase().contains("off"))
		{
			if (!expiryText.contains("switch-off"))
			{
				clickElement(CommunicationRepository.notification_webpush_expiryswitch);
				BaseTest.getTest().log(Status.INFO, "Set expiry as OFF");
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Expiry is OFF");
			}
		}
		return this;
	}

	// Select Content // Abdul 07102021
	public CommunicationNotificationPage webpushTextTitle()
	{
		threadSleep(ObjectRepository.wait3sec);
		javaScriptScrolltoTop();
		javaScriptScrollDownToSomeExtend();
		javaScriptScrollDownToSomeExtend();

		clickElement(CommunicationRepository.notification_webpush_selectcontent);
		threadSleep(ObjectRepository.wait3sec);
		String webTitleText = communicationName + ", ";
		enterValue(CommunicationRepository.notification_webpush_entertitle, webTitleText);
		explicitwaitforclick(autolocator(CommunicationRepository.notification_webpush_selecttitletextpersonalization), 30);
		clickElement(CommunicationRepository.notification_webpush_selecttitletextpersonalization);
		selectlistelements(CommunicationRepository.notification_webpush_selecttitletextpersonalizationlist, "[[EmailID]]");

		threadSleep(ObjectRepository.wait2sec);
		String modifiedContent = getTextBoxVal(CommunicationRepository.notification_webpush_entertitle, "value").trim();
		writeLog(modifiedContent.contains("[[EmailID]]"), "Personalization is added successfully in Title text", "Personalization is not added in Title text");
		return this;
	}

	// Personalization of text // Abdul
	public CommunicationNotificationPage commWebPushpersona()
	{
		javaScriptScrollDownToSomeExtend();
		clickElement(CommunicationRepository.notification_webpush_webcontent);
		sendValue(CommunicationRepository.notification_webpush_webcontent, BaseTest.getData().webpushContent);
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforclick(autolocator(CommunicationRepository.notification_webpush_selectpersonalization), 30);
		clickElement(CommunicationRepository.notification_webpush_selectpersonalization);
		selectlistelements(CommunicationRepository.notification_webpush_selecttitletextpersonalizationlist, "[[EmailID]]");
		clickElement(CommunicationRepository.notification_webpush_selectpersonalization);
		selectlistelements(CommunicationRepository.notification_webpush_selecttitletextpersonalizationlist, "[[MobileNo]] | [[null]]");
		boolean browserPreview = isDisplayed(CommunicationRepository.notification_webpush_Preview);
		writeLog(browserPreview, "Browser preview is displayed as expected", "Browser preview is not displayed");
		threadSleep(ObjectRepository.wait2sec);
		String wpModifiedContent = getStrText(CommunicationRepository.notification_webpush_webcontent).trim();
		writeLog(wpModifiedContent.contains("[[EmailID]]") && wpModifiedContent.contains("[[MobileNo]]"), "Personalization is added successfully in WP content", "Personalization is not added in WP content");
		threadSleep(ObjectRepository.wait2sec);

		javaScriptScrollDownToSomeExtend();
		threadSleep(ObjectRepository.wait2sec);
		return this;
	}
//	public CommunicationNotificationPage webpushSendTestPreview(String mailIds)
//	{
//		javaScriptScrollDown();
//		explicitwaitforclick(autolocator(CommunicationRepository.notification_webpush_testmailto), 20);
//		clickElement(CommunicationRepository.notification_webpush_testmailto);
//		threadSleep(ObjectRepository.wait1sec);
//		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Enter new email");
//		enterValue(CommunicationRepository.notification_webpush_testmailenter, mailIds);
//		threadSleep(ObjectRepository.wait3sec);
//		clickElement(CommunicationRepository.notification_webpush_testcommSent);
//		threadSleep(ObjectRepository.wait2sec);
//		pageLoaderLogo();
//		try
//		{
//			explicitwaitforvisibility(autolocator(CommunicationRepository.email_testmail_msg), 50);
//			if (getStrText(CommunicationRepository.email_testmail_msg).equalsIgnoreCase("Test communication will be sent shortly"))
//			{
//				BaseTest.takeScreenshot();
//			} else
//			{
//				BaseTest.getTest().log(Status.FAIL, "Popup present but content is different");
//				BaseTest.takeScreenshot();
//			}
//		} catch (Exception e)
//		{
//			BaseTest.getTest().log(Status.FAIL, "Failed to get test mail popup");
//			BaseTest.takeScreenshot();
//		}
//		threadSleep(ObjectRepository.wait5sec);
//		if (isDisplayed(CommunicationRepository.popupclosebutton))
//		{
//			clickElement(CommunicationRepository.popupclosebutton);
//		}
//		return this;
//	}

	public CommunicationNotificationPage wpBrowseImage()
	{
		javaScriptScrollUpToSomeExtend();
		clickElement(CommunicationRepository.notification_webpush_imgcontenticon);
		explicitwaitforvisibility(autolocator(CommunicationRepository.notification_webpush_selectbrowseimage), 20);
		clickElement(CommunicationRepository.notification_webpush_selectbrowseimage);
		threadSleep(ObjectRepository.wait2sec);
		String file = BaseTest.curr_Dir + "\\src\\main\\resources" + "\\data\\uploadfiles\\Testing image.jpg";
		sendValues(CommunicationRepository.notification_webpush_selectbrowseimage_upload, file);
		tabAction();
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait3sec);
		if (isDisplayed(CommunicationRepository.popupclosebutton))
		{
			clickElement(CommunicationRepository.popupclosebutton);
		}
		BaseTest.takeScreenshot();
		return this;
	}

	// Abdul
	public CommunicationNotificationPage webPushContentPreview()
	{
		threadSleep(ObjectRepository.wait3sec);
		if (isDisplayed(CommunicationRepository.notification_webmobile_contentpreview))
		{
			String titleTextContent = getStrText(CommunicationRepository.notification_webmobile_contenttitletextpreview);
			String bodyTextContnet = getStrText(CommunicationRepository.notification_webmobile_contentbodytextpreview);
			if (titleTextContent.contains(webPushtitleText))
			{
				BaseTest.getTest().info("Entered title text is displayed in Web content preview and it matches");
			} else
			{
				BaseTest.getTest().fail("Entered title text is different in Web content preview and it matches");
			}
			if (bodyTextContnet.contains(webPushPersona))
			{
				BaseTest.getTest().info("Entered Body text is displayed in Web content preview");
			} else
			{
				BaseTest.getTest().fail("Entered webPushPersona text is different in Web content preview");
			}

		}
		return this;
	}

	// Abdul 30-09-2021
	public CommunicationNotificationPage webPushChannelPageCompareAttributeValuesInEditMode()
	{
		explicitwaitforvisibility(autolocator(CommunicationRepository.notification_webpush_Enterwebpushcontent), 10);
		String enteredTitleText = getStrText(CommunicationRepository.notification_webpush_Enterwebpushcontent);
		if (!enteredTitleText.contains(webPushtitleText))
		{
			BaseTest.getTest().log(Status.FAIL, "The Duplicated WebPush Communication Title text  '" + enteredTitleText + "' Differes from its Actual Input");
			BaseTest.takeScreenshot();
		}
		explicitwaitforvisibility(autolocator(CommunicationRepository.notification_webpush_webcontent), 10);
		String enteredPersona = getStrText(CommunicationRepository.notification_webpush_webcontent);
		if (!enteredPersona.contains(webPushPersona))
		{
			BaseTest.getTest().log(Status.FAIL, "The Duplicated WebPush Communication Personalization  '" + enteredPersona + "' Differes from its Actual Input");
			BaseTest.takeScreenshot();
		}
		return this;
	}

	// Web push enter schedule date
	@Override
	public CommunicationNotificationPage enterScheduleDate(String val)
	{
		javaScriptScrollDown();
		threadSleep(ObjectRepository.wait3sec);
		if (BaseTest.getData().WebMobileLayoutPosition.toLowerCase().contains("carousel"))
		{
			selectDate(CommunicationRepository.notification_webpush_entercarouselscheduledate, val);
		} else
		{
			selectDate(CommunicationRepository.notification_webpush_enterscheduledate, val);
		}
		BaseTest.getTest().log(Status.INFO, "Web push notification schedule date selected");
		return this;
	}

	// Select Time zone
	public CommunicationListingPage webTimeZoneSelection()
	{
		if (BaseTest.getData().WebMobileLayoutPosition.toLowerCase().contains("carousel"))
		{
			clickElement(CommunicationRepository.notification_push_webcarouseltimezoneicon);
			explicitwaitforclick(autolocator(CommunicationRepository.notification_webpush_webcarouseltimezonelist), 30);
			clickElement(CommunicationRepository.notification_webpush_webcarouseltimezonelist);
			explicitwaitforclick(autolocator(CommunicationRepository.notification_webpush_selectwebcarouseltimezonelist), 30);
			selectlistelements(CommunicationRepository.notification_webpush_selectwebcarouseltimezonelist, BaseTest.getData().TimeZone);
		} else
		{
			clickElement(CommunicationRepository.notification_push_webtimezoneicon);
			explicitwaitforclick(autolocator(CommunicationRepository.notification_webpush_webtimezonelist), 30);
			clickElement(CommunicationRepository.notification_webpush_webtimezonelist);
			explicitwaitforclick(autolocator(CommunicationRepository.notification_webpush_selectwebtimezonelist), 30);
			selectlistelements(CommunicationRepository.notification_webpush_selectwebtimezonelist, BaseTest.getData().TimeZone);
		}
		return this;
	}

//	public boolean checknotificationScheduleTimeError(String val)
//	{
//		boolean erroemsg = false;
//		try
//		{
//			explicitwaitforvisibility(autolocator(CommunicationRepository.communicationpage_email_dateTimeErr), 10);
//			enterScheduleDate(val);
//			erroemsg = true;
//		} catch (Exception e)
//		{
//			BaseTest.getTest().log(Status.INFO, "Schedule date and time error message not present, selected future time");
//		}
//		return erroemsg;
//	}

	public CommunicationNotificationPage enterSplitScheduleDate(String splitType, String val)
	{
		javaScriptScrollDown();
		threadSleep(ObjectRepository.wait1sec);
		selectDate("SplitWebScheduleDate,xpath,//span[@aria-controls='WebScheduleDate" + splitType + "_dateview']/i", val);
		return this;
	}

	// Save Communication
	public CommunicationNotificationPage savePushComm()
	{
		javaScriptScrollDown();
		clickElement(CommunicationRepository.notification_push_clickNotificationCommSave);
		return this;
	}

//	public CommunicationNotificationPage nextPushComm()
//	{
//		javaScriptScrollDown();
//		clickElement(CommunicationRepository.notification_push_clickNotificationCommNext);
//		return this;
//	}

	// Draft Confirm
	public CommunicationNotificationPage WebMobileDraftConfirm()
	{
		threadSleep(ObjectRepository.wait1sec);
		explicitwaitforclick(autolocator(CommunicationRepository.notification_WebMobile_clickDraftConfirm), 30);
		clickElement(CommunicationRepository.notification_WebMobile_clickDraftConfirm);
		threadSleep(ObjectRepository.wait10sec);
		return this;
	}

	// Click sms channel next
	public CommunicationNotificationPage clickNextNotification()
	{
		explicitwaitforclick(autolocator(CommunicationRepository.notification_webmobile_notificationcommunicationnext), 10);
		clickElement(CommunicationRepository.notification_webmobile_notificationcommunicationnext);
		threadSleep(ObjectRepository.wait10sec);
		return this;
	}

	// Split AB functions Abdul
	public CommunicationNotificationPage splitWebPushON(String splitType)
	{
		clickElement(CommunicationRepository.communicationpage_WebSplitON);
		threadSleep(ObjectRepository.wait3sec);
		for (int count = 2; count < splitType.length(); count++)
		{
			explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_Websplit_addBtn), 30);
			clickElement(CommunicationRepository.communicationpage_Websplit_addBtn);
			threadSleep(ObjectRepository.wait3sec);
		}
		clickElement(CommunicationRepository.communicationpage_WebsplitABDownarrow);
		threadSleep(ObjectRepository.wait1sec);
		String splitTotalCounts = getStrText("SplitTotalCounts,xpath,(//ul[@class='list-inline small inline']/li)[3]").replaceAll("[^A-Za-z0-9]", "");
		if (!splitTotalCounts.isEmpty())
		{
			splitTotalCount = Integer.parseInt(splitTotalCounts);
		}
		for (int count = 0; count < splitType.length(); count++)
		{
			int li = count + 1;
			String splitGroupCount1 = getStrText("SplitGroupCount1,xpath,(//div[@class='split-group-text-container']/h5)[" + li + "]/span[2]").replaceAll("\\(.*?\\)", "");
			int splitGroupCount = Integer.parseInt(splitGroupCount1);
			String splitGroupPercents = getStrText("SplitGroupPercents,xpath,(//div[@class='split-group-text-container']/h5)[" + li + "]/span[2]/span");
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
		explicitwaitforvisibility(autolocator(CommunicationRepository.communicationpage_WebsplitABDrag_save), 20);
		clickElement(CommunicationRepository.communicationpage_WebsplitABDrag_save);
		return this;
	}

	public CommunicationNotificationPage splitAutoScheduleOffValidate()
	{
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforclick(autolocator(CommunicationRepository.communication_split_autoschedulewebsettingsIcon), 30);
		clickElement(CommunicationRepository.communication_split_autoschedulewebsettingsIcon);
		try
		{
			String autoon = "Auto ON,xpath,(//*[contains(text(),'Auto schedule')]/../div//div[contains(@class,'switch-on')])[1]";
			explicitwaitforvisibility(autolocator(autoon), 20);
			clickElement(autoon);
			BaseTest.getTest().log(Status.INFO, "Auto schedule default ON, user selected Option OFF");
			threadSleep(ObjectRepository.wait1sec);

		} catch (Exception e)
		{
			String autooff = "Auto off,xpath,(//*[contains(text(),'Auto schedule')]/../div//div[contains(@class,'switch-off')])[3]";
			explicitwaitforvisibility(autolocator(autooff), 20);
			BaseTest.getTest().log(Status.INFO, "Auto schedule default OFF, user selected Option OFF");
		}
		clickElement(CommunicationRepository.SplitABAutoshduleWebSavebutton);
		return this;
	}

	private CommunicationNotificationPage enterWebSplitTitleWithPersonalization(String whichSplitCaps, String title)
	{
		threadSleep(ObjectRepository.wait3sec);
		String webTitleText = title + communicationName + " , ";
		List<String> objStringPersona = new ArrayList<String>();
		objStringPersona.add(System.getProperty("Persona_1"));
		javaScriptScrollDownToSomeExtend();
		threadSleep(ObjectRepository.wait1sec);
		explicitwaitforclick(autolocator("Split/Carousel persona icon,xpath, //*[@id='WebSubjectPersonalize" + whichSplitCaps + "']"), 30);
		clickElement("Split/Carousel persona icon,xpath, //*[@id='WebSubjectPersonalize" + whichSplitCaps + "']");
		threadSleep(ObjectRepository.wait3sec);
		List<WebElement> personatxt = driver.findElements(autolocator(",xpath, //*[@id='WebSubjectPersonalize" + whichSplitCaps + "']/ul/li"));
		for (WebElement allele : personatxt)
		{
			String inputtext = allele.getText();
			if (objStringPersona.contains(inputtext))
			{
				String fallBack = allele.findElement(By.tagName("a")).getAttribute("class").toString();
				if (fallBack.isEmpty() || fallBack.equals("") || fallBack == null || fallBack.equalsIgnoreCase("[[null]]"))
				{
					fallBack = "[[No Data]]";
				}
				webTitleText += inputtext + " | " + fallBack + ",";
				fallBack = null;
			}
		}
		clickElement("Split/Carousel persona icon,xpath, //*[@id='WebSubjectPersonalize" + whichSplitCaps + "']");
		try
		{
			enterValue("Split/Carousel title,xpath,//*[@id='divTitletext" + whichSplitCaps + "']//div[@placeholder='Enter title']", webTitleText);
			BaseTest.getTest().log(Status.INFO, "Webpush Title: " + webTitleText);
			webPushtitleText = webTitleText;
		} catch (Exception e)
		{
			System.out.println("title exception");
		}
		return this;
	}

	public CommunicationNotificationPage enterWebSplitBodytextWithPersonalization(String whichSplitCaps, String title)
	{
		String webContentText = title + communicationName + " , " + System.getProperty("webpushContent");
		List<String> objStringPersona = new ArrayList<String>();
		objStringPersona.add(System.getProperty("Persona_1"));
		objStringPersona.add(System.getProperty("Persona_2"));
		objStringPersona.add(System.getProperty("Persona_3"));
		javaScriptScrollDownToSomeExtend();
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforclick(autolocator("Split / Carousel persona,xpath,(//small[@id='Web_Notification" + whichSplitCaps + "']/..//i)[1]"), 30);
		clickElement("Split / Carousel persona,xpath,(//small[@id='Web_Notification" + whichSplitCaps + "']/..//i)[1]");
		threadSleep(ObjectRepository.wait3sec);
		List<WebElement> personatxt = driver.findElements(autolocator(",xpath,//ul[contains(@class,'personalFieldsWeb" + whichSplitCaps + "')]/li"));
		for (WebElement allele : personatxt)
		{
			String inputtext = allele.getText();
			if (objStringPersona.contains(inputtext))
			{

				String fallBack = allele.findElement(By.tagName("a")).getAttribute("class").toString();
				if (fallBack.isEmpty() || fallBack.equals("") || fallBack == null || fallBack.equalsIgnoreCase("[[null]]"))
				{
					fallBack = "[[No Data]]";
				}
				webContentText = webContentText.replaceFirst("personalisation", inputtext + " | " + fallBack);
				fallBack = null;
			}
		}
		clickElement("Split / Carousel persona,xpath,(//small[@id='Web_Notification" + whichSplitCaps + "']/..//i)[1]");
		clickElement("Web content,xpath,//*[@id='WebhContent" + whichSplitCaps + "']");
		enterValue("Web content,xpath,//*[@id='WebhContent" + whichSplitCaps + "']", webContentText);
		BaseTest.getTest().log(Status.INFO, "Webpush content: " + webContentText);
		webPushPersona = webContentText;
		return this;
	}

	// Select Web push Interactivity
	public CommunicationNotificationPage webpushSplitCarouselInteractivitySwitch(String webSplitCaps)
	{
		javaScriptScrollIntoView("Web interactivity switch,xpath, //label[@for='chkWebHourspush" + webSplitCaps + "']");
		String interactivityText = getTextBoxVal("Web interactivity switch,xpath, //label[@for='chkWebHourspush" + webSplitCaps + "']/../..", "class");
		if (BaseTest.getData().WebMobileInteractivity.toLowerCase().contains("on"))
		{
			if (!interactivityText.contains("switch-on"))
			{
				clickElement("Web interactivity switch,xpath, //label[@for='chkWebHourspush" + webSplitCaps + "']");
				BaseTest.getTest().log(Status.INFO, "Set Interactivity as ON");
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Interactivity is ON");
			}
			threadSleep(ObjectRepository.wait1sec);
			clickElement("Web interactivity,xpath, //span[@aria-activedescendant='webinteractiveBtnOn" + webSplitCaps + "_option_selected']");
			explicitwaitforclick(autolocator("Web interactivity listbox,xpath, //*[@id='webinteractiveBtnOn" + webSplitCaps + "_listbox']/li"), 30);
			selectlistelements("Web interactivity listbox,xpath, //*[@id='webinteractiveBtnOn" + webSplitCaps + "_listbox']/li", "Button");

			explicitwaitforclick(autolocator("Web interactivity action,xpath, //span[@aria-activedescendant='webinteractiveBtnSelect" + webSplitCaps + "_option_selected']"), 30);
			clickElement("Web interactivity action,xpath, //span[@aria-activedescendant='webinteractiveBtnSelect" + webSplitCaps + "_option_selected']");
			String WebInteractivityAction = BaseTest.getData().WebMobileInteractivityAction;
			if (WebInteractivityAction.toLowerCase().contains("Unsubscribe") || !WebInteractivityAction.toLowerCase().contains("Dismiss"))
			{
				selectlistelements("Web interactivity action listbox,xpath, //*[@id='webinteractiveBtnSelect" + webSplitCaps + "_listbox']/li", WebInteractivityAction);
			} else if (WebInteractivityAction.contains("Custom Action"))
			{
				//
				clickElement("Custom action setting icon,xpath,//div[@id='DivWebPushInteractivehours" + webSplitCaps + "']/..//a[@title='Interactive Custom parameters']");
				explicitwaitforvisibility(autolocator(CommunicationRepository.notificaiton_webpush_customButtonText), 20);
				enterValue(CommunicationRepository.notificaiton_webpush_customButtonText, BaseTest.getData().WebMobileCustomButtonName);
				clickElement(CommunicationRepository.notificaiton_webpush_customBehaviour);
				selectlistelements(CommunicationRepository.notificaiton_webpush_customBehaviourList, BaseTest.getData().WebMobileClickBehaviour);
				if (BaseTest.getData().WebMobileClickBehaviour.toLowerCase().contains("enter new link"))
				{
					enterValue(CommunicationRepository.notificaiton_webpush_customactionBehaviourLink, BaseTest.getData().WebMobileClickBehaviourLink);
					clickElement(CommunicationRepository.notificaiton_webpush_customactionBehaviourType);
					selectlistelements(CommunicationRepository.notificaiton_webpush_customactionBehaviourTypeList, BaseTest.getData().WebMobileClickBehaviourType);
				}
				clickElement(CommunicationRepository.notification_webpush_custombuttonpopupsave);
			}
		}
		return this;
	}

	// Select Web Push Expiry
	public CommunicationNotificationPage webpushSplitExpirySwitch(String webSplitCaps)
	{
		threadSleep(ObjectRepository.wait3sec);
		javaScriptScrollIntoView("Web expiry switch,xpath, //label[@for='chkExpiryWebpush" + webSplitCaps + "']");
		String expiryText = getTextBoxVal("Web expiry switch,xpath,//label[@for='chkExpiryWebpush" + webSplitCaps + "']/../..", "class");
		if (BaseTest.getData().WebMobileExpiry.toLowerCase().contains("on"))
		{
			if (!expiryText.contains("switch-on"))
			{
				clickElement("Web expiry switch,xpath, //label[@for='chkExpiryWebpush" + webSplitCaps + "']");
				BaseTest.getTest().log(Status.INFO, "Set expiry as ON");
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Expiry is ON");
			}

			explicitwaitforclick(autolocator("Web expiry,xpath, //span[@aria-activedescendant='expiryWebSchedule" + webSplitCaps + "_option_selected']"), 30);
			clickElement("Web expiry,xpath, //span[@aria-activedescendant='expiryWebSchedule" + webSplitCaps + "_option_selected']");
			selectlistelements("Web expiry listbox,xpath, //*[@id='expiryWebSchedule" + webSplitCaps + "_listbox']/li", BaseTest.getData().WebMobileExpirySchdule);
			enterValue("Web expiry time,xpath, //input[@id='txtWebExpiryhours" + webSplitCaps + "']", BaseTest.getData().WebMobileExpiryDuration);
		} else if (BaseTest.getData().WebMobileExpiry.toLowerCase().contains("off"))
		{
			if (!expiryText.contains("switch-off"))
			{
				clickElement("Web expiry switch,xpath, //label[@for='chkExpiryWebpush" + webSplitCaps + "']");
				BaseTest.getTest().log(Status.INFO, "Set expiry as OFF");
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Expiry is OFF");
			}
		}
		return this;
	}

	public CommunicationNotificationPage webpushCarouselExpirySwitch()
	{
		threadSleep(ObjectRepository.wait3sec);
		javaScriptScrollIntoView(CommunicationRepository.notification_webpush_carouselexpiryswitch);
		String expiryText = getTextBoxVal(CommunicationRepository.notification_webpush_carouselexpiryswitchOnOff, "class");
		if (BaseTest.getData().WebMobileExpiry.toLowerCase().contains("on"))
		{
			if (!expiryText.contains("switch-on"))
			{
				clickElement(CommunicationRepository.notification_webpush_carouselexpiryswitch);
				BaseTest.getTest().log(Status.INFO, "Set expiry as ON");
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Expiry is ON");
			}

			explicitwaitforclick(autolocator(CommunicationRepository.notification_webpush_carouselexpiry), 30);
			clickElement(CommunicationRepository.notification_webpush_carouselexpiry);
			selectlistelements(CommunicationRepository.notification_webpush_carouselexpirylist, BaseTest.getData().WebMobileExpirySchdule);
			enterValue(CommunicationRepository.notification_webpush_carouselexpirytime, BaseTest.getData().WebMobileExpiryDuration);
		} else if (BaseTest.getData().WebMobileExpiry.toLowerCase().contains("off"))
		{
			if (!expiryText.contains("switch-off"))
			{
				clickElement(CommunicationRepository.notification_webpush_carouselexpiryswitch);
				BaseTest.getTest().log(Status.INFO, "Set expiry as OFF");
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Expiry is OFF");
			}
		}
		return this;
	}

	public CommunicationNotificationPage webSplitCarouselDetails(String selectedSplitCaps, String splittype)
	{
		// javaScriptScrollIntoView(",xpath, //a[@href='#liWebsplit" + selectedSplitCaps + "']");
		javaScriptScrollIntoView(CommunicationRepository.notification_webpush_deliverytype);
		threadSleep(ObjectRepository.wait1sec);
		clickElement("SplitABCD/Carousel Tab,xpath, //a[@href='#liWebsplit" + selectedSplitCaps + "']");
		clickElement("Split / Carousel " + selectedSplitCaps + " text icon,xpath, //a[@id='WebacnRichText" + selectedSplitCaps + "']");
		enterWebSplitTitleWithPersonalization(selectedSplitCaps, splittype);
		enterWebSplitBodytextWithPersonalization(selectedSplitCaps, splittype);
		BaseTest.takeScreenshot();
		return this;
	}

	public CommunicationNotificationPage webSplitCarouselEdmDetails(String selectedSplitCaps, String vzip)
	{
		javaScriptScrollIntoView(CommunicationRepository.notification_webpush_deliverytype);
		threadSleep(ObjectRepository.wait1sec);
		clickElement("SplitABCD/Carousel Tab,xpath, //a[@href='#liWebsplit" + selectedSplitCaps + "']");
		clickElement("Split / Carousel " + selectedSplitCaps + " Edm icon,xpath, //a[@id='WebacnImportUrl" + selectedSplitCaps + "']");
		threadSleep(ObjectRepository.wait3sec);
		String zip1 = BaseTest.curr_Dir + "/src\\main\\resources" + "\\Zip\\" + vzip + ".zip";
		sendValue(",xpath, //*[@id='webfileuploadHTML" + selectedSplitCaps + "']", zip1);
		BaseTest.takeScreenshot();
		return this;
	}

	public CommunicationNotificationPage carouselAdd(String carouselcount)
	{
		threadSleep(ObjectRepository.wait1sec);
		for (int count = 2; count < carouselcount.length(); count++)
		{
			explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_Websplit_addBtn), 30);
			clickElement(CommunicationRepository.communicationpage_Websplit_addBtn);
			threadSleep(ObjectRepository.wait1sec);
		}
		return this;
	}

	// Temporary till getting solution

	public CommunicationNotificationPage splitDetailsInEdit(String selectedSplitCaps, String splittype)
	{
		javaScriptScrollIntoView(CommunicationRepository.notification_webpush_deliverytype);
		threadSleep(ObjectRepository.wait1sec);
		clickElement("SplitABCD Tab,xpath, //a[@href='#liWebsplit" + selectedSplitCaps + "']");
		enterWebSplitTitleWithPersonalization(selectedSplitCaps, splittype);
		enterWebSplitBodytextWithPersonalization(selectedSplitCaps, splittype);
		BaseTest.takeScreenshot();
		return this;
	}

	public CommunicationNotificationPage verifySplitDuplicate(String splittype)
	{
		javaScriptScrollIntoView(CommunicationRepository.notification_webpush_deliverytype);
		threadSleep(ObjectRepository.wait1sec);
		String[] splittypeABCD = splittype.split("");
		for (String selectedsplit : splittypeABCD)
		{
			clickElement("SplitABCD Tab,xpath, //a[@href='#liWebsplit" + selectedsplit + "']");
			String enteredTitleText = getStrText("Split title,xpath,//*[@id='divTitletext" + selectedsplit + "']//div[@placeholder='Enter title']");
			String commName = communicationName.replace("Update_", "");
			System.out.println("Split type: " + selectedsplit + ", " + commName);
			System.out.println(enteredTitleText);
			if (!enteredTitleText.contains("Split type: " + selectedsplit + ", " + commName))
			{
				BaseTest.getTest().log(Status.FAIL, "The Duplicated WebPush Communication Title text  '" + enteredTitleText + "' Differes from its Actual Input");
				BaseTest.takeScreenshot();
			}
			String bodytext = driver.findElement(autolocator(",xpath,//textarea[@name='WebPushContent_" + selectedsplit + "']")).getText();
			System.out.println("//*[@id='WebhContent" + selectedsplit + "']");
			String enteredbodyTextPersona = getStrText(",xpath,//textarea[@name='WebPushContent_" + selectedsplit + "']");
			if (!bodytext.contains(webPushPersona))
			{
				System.out.println("Content Title : " + webPushPersona);
				BaseTest.getTest().log(Status.FAIL, "The Duplicated WebPush Communication Personalization  '" + bodytext + "' Differes from its Actual Input");
				BaseTest.takeScreenshot();
			}
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public CommunicationNotificationPage webAddlinkClickandVerify()
	{
		clickElement(CommunicationRepository.notification_webpush_recipientaddicon);
		if (!isDisplayed(CommunicationRepository.communicationpage_recipientpage))
		{
			BaseTest.getTest().fail("On clicking recipient add icon in Communication page, it failed to navigate to Recipient page");
		}
		driver.navigate().back();
		return this;
	}

	// web click import
	public CommunicationNotificationPage clickImport()
	{
		threadSleep(ObjectRepository.wait3sec);
		if (isEnabled(CommunicationRepository.notification_webpush_webclickimport))
		{
			clickElement(CommunicationRepository.notification_webpush_webclickimport);
		} else
		{
			clickElement(CommunicationRepository.notification_webpush_webcontentrefresh);
			threadSleep(ObjectRepository.wait1sec);
			clickElement(CommunicationRepository.notification_webpush_webcontentrefreshok);
			explicitwaitforclick(autolocator(CommunicationRepository.notification_webpush_webclickimport), 30);
			clickElement(CommunicationRepository.notification_webpush_webclickimport);
		}
		return this;
	}

	// web click import
	public CommunicationNotificationPage webSplitCarouselImport(String type)
	{
		threadSleep(ObjectRepository.wait3sec);
		if (isEnabled(",xpath, //a[@id='WebacnImportUrl" + type + "']"))
		{
			clickElement(",xpath, //a[@id='WebacnImportUrl" + type + "']");
		} else
		{
			clickElement(",xpath, //*[@id='WebaContentTypeRefresh" + type + "']");
			threadSleep(ObjectRepository.wait1sec);
			clickElement(CommunicationRepository.notification_webpush_webcontentrefreshok);
			explicitwaitforclick(autolocator(CommunicationRepository.notification_webpush_webclickimport), 30);
			clickElement(CommunicationRepository.notification_webpush_webclickimport);
		}
		return this;
	}

	// Select Zip file
	public CommunicationNotificationPage selectZip(String vzip)
	{
		threadSleep(ObjectRepository.wait3sec);
		String zip1 = BaseTest.curr_Dir + "/src\\main\\resources" + "\\Zip\\" + vzip + ".zip";
		sendValue(CommunicationRepository.notification_webpush_webimportzip, zip1);
		return this;
	}

	public CommunicationNotificationPage webNotificationCommDBValidation()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("COMMUNICATION DB - WEB NOTIFICATION CHANNEL DETAILS", ExtentColor.BLUE));
		threadSleep(ObjectRepository.wait20sec);
		campDetails = getdbQueryResults(dburl_campaign + campdbname, campaigndb_userName, campaigndb_password, qWebNotificationCampDetails(communicationName));
		if (!campDetails.isEmpty())
		{
			for (Map<String, String> camprow : campDetails)
			{
				campaignId = camprow.get("CampaignID");
				campGUID1 = camprow.get("CampaignGUID");
				campBlastScheduleGUID = camprow.get("BlastScheduleGuid");
				BaseTest.getTest().log(Status.INFO, mapToString(camprow));
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Communication details not updated in commdb");
		}
		return this;
	}

	// Send Test Communication
	public CommunicationNotificationPage webpushSendTestPreview(String mailIds)
	{
		javaScriptScrollDown();
		explicitwaitforclick(autolocator(CommunicationRepository.notification_webpush_testmailto), 20);
		clickElement(CommunicationRepository.notification_webpush_testmailto);
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Enter new email");
		enterValue(CommunicationRepository.notification_webpush_testmailenter, mailIds);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(CommunicationRepository.notification_webpush_testcommSent);
		threadSleep(ObjectRepository.wait2sec);
		pageLoaderLogo();
		try
		{
			explicitwaitforvisibility(autolocator(CommunicationRepository.email_testmail_msg), 50);
			if (getStrText(CommunicationRepository.email_testmail_msg).equalsIgnoreCase("Test communication will be sent shortly"))
			{
				BaseTest.takeScreenshot();
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
		return this;
	}

	public CommunicationNotificationPage wpImageURL()
	{
		String url = System.getProperty("webMobilePushImageUrl");
		javaScriptScrollUpToSomeExtend();
		clickElement(CommunicationRepository.notification_webpush_imgcontenticon);
		explicitwaitforvisibility(autolocator(CommunicationRepository.notification_webpush_selectimgurl), 20);
		clickElement(CommunicationRepository.notification_webpush_selectimgurl);
		threadSleep(ObjectRepository.wait2sec);
		enterValue(CommunicationRepository.notification_webpush_imgurlpopup, url);
		tabAction();
		threadSleep(ObjectRepository.wait3sec);

		pageLoaderLogo();
		clickElement(CommunicationRepository.notification_webpush_imgurlsave);
		threadSleep(ObjectRepository.wait2sec);
		BaseTest.takeScreenshot();
		clickElement(",id,rs_circle_close_edge");
		return this;
	}

	public CommunicationListingPage validateItemPerPage()
	{
		threadSleep(ObjectRepository.wait1sec);
		javaScriptScrollIntoView(",xpath,//*[@id='campaignGrid']//span[@class='k-widget k-dropdown k-header']");
		clickElement("Items per page,xpath,//*[@id='campaignGrid']//span[@class='k-widget k-dropdown k-header']");
		List<WebElement> ele = driver.findElements(By.xpath("//div[@id='SmsSplitAutoScheduleDate_dateview']/..//div[@class='k-animation-container']//li"));
		for (WebElement ele1 : ele)
		{
			String text = ele1.getAttribute("title");
			int eletxt = Integer.parseInt(text);
			threadSleep(ObjectRepository.wait1sec);
			ele1.click();
			pageLoaderLogo();
			threadSleep(ObjectRepository.wait1sec);
			int size = driver.findElements(By.xpath("//*[@id='campaignGrid']//tbody//tr")).size();
			if (eletxt == size)
			{
				threadSleep(ObjectRepository.wait2sec);
				BaseTest.getTest().log(Status.INFO, "Item per pages count of --->" + eletxt + " validation completed");
				BaseTest.takeScreenshot();
				javaScriptScrollDown();
				threadSleep(ObjectRepository.wait3sec);
				clickElement("Items per page,xpath,//*[@id='campaignGrid']//span[@class='k-widget k-dropdown k-header']");
				threadSleep(ObjectRepository.wait1sec);
			}
		}
		return this;
	}

	public CommunicationNotificationPage enterWebScheduleDate(String val)
	{
		javaScriptScrollDown();
		threadSleep(ObjectRepository.wait3sec);
		if (BaseTest.getData().WebMobileLayoutPosition.toLowerCase().contains("carousel"))
		{
			selectDate(CommunicationRepository.notification_webpush_entercarouselscheduledate, val);
		} else
		{
			selectDate(CommunicationRepository.notification_webpush_enterscheduledate, val);
		}
		BaseTest.getTest().log(Status.INFO, "Web push notification schedule date selected");
		return this;
	}

	public boolean checkWebPushScheduleTimeError(String val)
	{
		boolean errormsg = false;
		try
		{
			explicitwaitforvisibility(autolocator(CommunicationRepository.notification_webpush_dateTimeErr), 10);
			enterWebScheduleDate(val);
			errormsg = true;
		} catch (Exception e)
		{
			BaseTest.getTest().log(Status.INFO, "Schedule date and time error message not present, selected future time");
		}
		return errormsg;
	}

	public void webPushAuthoringPageAudienceCountValidation(String listName, String audienceCount)
	{
		threadSleep(ObjectRepository.wait2sec);
		enterValue(",xpath,//div[@id='web-notifications']//div[@class='k-multiselect-wrap k-floatwrap']//input", listName);
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(",xpath,//ul[@id='WebNotificationRecipientsList_listbox']//li", listName);
		threadSleep(ObjectRepository.wait3sec);
		String[] mbPushCount = getStrText(",xpath,//span[@id='spanWebTotalCount']").split(":");
		String mbPushAuthoringPageAudienceCount = mbPushCount[1].trim();
		if (audienceCount.equals(mbPushAuthoringPageAudienceCount))
		{
			BaseTest.getTest().log(Status.INFO, "List Audience Count is equal to Mobile Push Authoring Page Audience Count");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "List Audience Count is not-equal to Mobile Push Authoring Page Audience Count");
			BaseTest.takeScreenshot();
		}

	}

	public CommunicationNotificationPage clickImportWebpush()
	{
		threadSleep(ObjectRepository.wait3sec);
		if (isEnabled(CommunicationRepository.Webpush_clickimport))
		{
			clickElement(CommunicationRepository.Webpush_clickimport);
		} else
		{
			clickElement(CommunicationRepository.communicationemail_commrefresh);
			threadSleep(ObjectRepository.wait1sec);
			clickElement(CommunicationRepository.communicationemail_refresh_ok);
			explicitwaitforclick(autolocator(CommunicationRepository.Webpush_clickimport), 30);
			clickElement(CommunicationRepository.Webpush_clickimport);
		}
		// clickElement(ObjectRepository.email_clickimportzip);
		return this;
	}

}
