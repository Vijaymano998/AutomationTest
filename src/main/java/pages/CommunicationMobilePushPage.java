package pages;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class CommunicationMobilePushPage extends CommunicationCreatePage
{
	int splitSize, splitTotalCount, splitGroupACount, splitGroupBCount, splitGroupCCount, splitGroupDCount;
	int splitGroupAPercent, splitGroupBPercent, splitGroupCPercent, splitGroupDPercent;

	public CommunicationMobilePushPage(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
		// TODO Auto-generated constructor stub
	}

	// Mobile Push Smart link with app details
	public CommunicationMobilePushPage mobilepushSmartLinkCreate()
	{
		pageLoaderLogo();
		javaScriptScrollIntoView(CommunicationRepository.communicationpage_smarturl_yes);
		try
		{
			explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_smarturl_yes), 100);
		} catch (Exception e)
		{

		}

		javaScriptScrolltoTop();

		javascriptdoublescrolldown();
		threadSleep(ObjectRepository.wait5sec);

		clickElement(CommunicationRepository.communicationpage_smarturl_yes);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_smarturl_web), 20);
		sendValue(CommunicationRepository.communicationpage_smarturl_web, BaseTest.getData().SmartLink);
		tabAction();
		threadSleep(ObjectRepository.wait2sec);
		explicitwaitforclick(autolocator(CommunicationRepository.notification_mobpush_addmobileapp), 30);
		clickElement(CommunicationRepository.notification_mobpush_addmobileapp);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(CommunicationRepository.notificaiton_mobpush_selectmobileplatform);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().MobilePlatform);
		threadSleep(ObjectRepository.wait1sec);
		clickElement(CommunicationRepository.notification_mobpush_selectmobileapptype);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().MobileApp);

		pageLoaderLogo();
		String deepLinkText = getTextBoxVal(CommunicationRepository.notification_mobpush_deferdeeplinkswitchONOFF, "class");
		if (BaseTest.getData().WebMobileDeferredDeepLinking.toLowerCase().contains("on"))
		{
			if (!deepLinkText.contains("switch-on"))
			{
				clickElement(CommunicationRepository.notification_mobpush_deferdeeplinkswitch);
				BaseTest.getTest().log(Status.INFO, "Set DeferredDeepLinking as ON");
			} else
			{
				BaseTest.getTest().log(Status.INFO, "DeferredDeepLinking is ON");
			}
			pageLoaderLogo();
			clickElement(CommunicationRepository.notification_mobpush_selectdeferdeeplink);
			threadSleep(ObjectRepository.wait2sec);
			// explicitwaitforvisibility(autolocator(CommunicationRepository.notification_mobpush_enterdeferdeeplink), 30);
			selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Enter new app screen");
			enterValue("enter value,xpath,//input[@name='smartLink1[1].appScreenNew']", "LauncherActivity");
			//
			// Script conflict -- need to config app screen in backend //
			////////////////////////////////////////////////////////////////////////////////////////////////////////
			// selectexactlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().WebMobileActivity1);
//			if (!BaseTest.getData().WebMobileActivity2.equals(""))
//			{
//				clickElement(CommunicationRepository.notification_mobpush_selectdeeplinkoption);
//				selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().WebMobileActivity2);
//			}
		} else if (BaseTest.getData().WebMobileDeferredDeepLinking.toLowerCase().contains("off"))
		{
			if (!deepLinkText.contains("switch-off"))
			{
				clickElement(CommunicationRepository.notification_mobpush_deferdeeplinkswitch);
				BaseTest.getTest().log(Status.INFO, "Set DeferredDeepLinking as OFF");
			} else
			{
				BaseTest.getTest().log(Status.INFO, "DeferredDeepLinking is ON");
			}
			clickElement(CommunicationRepository.notification_mobpush_selectdeferdeeplink);
			explicitwaitforvisibility(autolocator(CommunicationRepository.notification_mobpush_enterdeferdeeplink1), 30);
			selectexactlistelements(CommunicationRepository.notification_mobpush_enterdeferdeeplink1, BaseTest.getData().WebMobileActivity1);

			if (!BaseTest.getData().WebMobileActivity2.equals(""))
			{
				clickElement(CommunicationRepository.notification_mobpush_selectdeeplinkoption);
				selectlistelements(CommunicationRepository.notification_mobpush_enterdeeplinkoption, BaseTest.getData().WebMobileActivity2);
			}

		}

		javaScriptScrollIntoView(CommunicationRepository.communicationpage_smarturl_generatesmarturl);
		threadSleep(ObjectRepository.wait1sec);
		clickElement(CommunicationRepository.communicationpage_smarturl_generatesmarturl);
		threadSleep(ObjectRepository.wait3sec);
		javaScriptScrollIntoView(CommunicationRepository.communicationpage_smarturl_save);
		threadSleep(ObjectRepository.wait3sec);
		pageLoaderLogo();

		clickElement(CommunicationRepository.communicationpage_smarturl_save);
		return this;
	}

	// Select Target List
	public CommunicationMobilePushPage mobilepushAudienceSelect()
	{
		pageLoaderLogo();
		javaScriptScrolltoTop();
		threadSleep(ObjectRepository.wait5sec);
		clickElement(CommunicationRepository.notification_mobpush_TabSelect);

		pageLoaderLogo();

		if (BaseTest.getData().WebMobileAudience.equalsIgnoreCase("all"))
		{
			pageLoaderLogo();
			clickElement(CommunicationRepository.communicationpage_email_receip_click);
			selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "All audience (Known & Identified)");

		} else
		{
			explicitwaitforpresence(autolocator(CommunicationRepository.notification_mobpush_selectmobilepushtargetlist), 30);
			sendValue(CommunicationRepository.notification_mobpush_selectmobilepushtargetlist, BaseTest.getData().WebMobileAudience);
			selectlistelements(CommunicationRepository.notification_mobpush_enterrecipientlist, BaseTest.getData().WebMobileAudience);
		}
//		javaScriptScrollIntoView(CommunicationRepository.notification_mobpush_TabSelect);
		return this;
	}

	// Select Push Type
	public CommunicationMobilePushPage mobilePushTypeAndLayout(String pushtype)
	{
		threadSleep(ObjectRepository.wait3sec);
		javaScriptScrollDownToSomeExtend();
		clickElement(CommunicationRepository.notification_mobpush_pushtype);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, pushtype);

		threadSleep(ObjectRepository.wait3sec);
		javaScriptScrollDownToSomeExtend();
		threadSleep(ObjectRepository.wait1sec);

		clickElement(CommunicationRepository.notification_mobpush_inboxClassification);
		pageLoaderLogo();
		// explicitwaitforvisibility(autolocator(CommunicationRepository.notification_mobpush_inboxClassification), 30);
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
				clickElement(CommunicationRepository.notification_mobpush_layoutposition);
				selectlistelements(CommunicationRepository.notification_mobpush_layoutpositionlist, BaseTest.getData().WebMobilePosition);
			}
		}
		return this;
	}

	// Select delivery Type
	public CommunicationMobilePushPage mobilePushDeliveryTypeAndLayout(String pushtype)
	{
		pageLoaderLogo();
		javaScriptScrolltoTop();

		threadSleep(ObjectRepository.wait2sec);

		clickElement(CommunicationRepository.notification_mobpush_TabSelect);

		pageLoaderLogo();
		javaScriptScrollDownToSomeExtend();
		threadSleep(ObjectRepository.wait2sec);
		clickElement(CommunicationRepository.notification_mobpush_pushtype);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, pushtype);

		threadSleep(ObjectRepository.wait3sec);
		javaScriptScrollDownToSomeExtend();
		threadSleep(ObjectRepository.wait1sec);

		clickElement(CommunicationRepository.notification_mobpush_inboxClassification);
		threadSleep(ObjectRepository.wait1sec);
		pageLoaderLogo();
		// explicitwaitforvisibility(autolocator(CommunicationRepository.notification_mobpush_inboxClassification), 30);
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
				clickElement(CommunicationRepository.notification_mobpush_layoutposition);
				selectlistelements(CommunicationRepository.notification_mobpush_layoutpositionlist, BaseTest.getData().WebMobilePosition);
			}
		}
		return this;
	}

	public CommunicationMobilePushPage splitMobileDetails(String selectedSplitCaps, String subject, String zip)
	{
		javaScriptScrollIntoView(CommunicationRepository.communicationpage_email_receip_click);
		clickElement("Split-" + selectedSplitCaps + "," + "xpath,//span[.='Split " + selectedSplitCaps + "']");

		int startDate = 0;

		String titleconetent = communicationName;
		enterValue("title,xpath,//input[@name='split" + selectedSplitCaps + ".title.text']", titleconetent);
		//// Emoji script
//		clickElement(",id,rs_RSEmojiPicker_Emoji");
//		WebElement ele = driver.findElement(By.xpath("//em-emoji-picker")).getShadowRoot().findElement(By.cssSelector("span.emoji-mart-emoji>span"));
//		ele.click();
//
//		clickElement(",id,rs_RSEmojiPicker_Emoji");

		threadSleep(ObjectRepository.wait3sec);

		clickElement(",xpath,(//i[contains(@class,'user-question')])[1]");
		threadSleep(ObjectRepository.wait3sec);
		selectlistelements(",xpath,//div[@class='css-scrollbar']//div", System.getProperty("Persona_3"));

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='k-iframe']")));

		String content = "Hey" + " " + communicationName;
		enterValue(CommunicationRepository.notification_mobpush_bodyMessage, content);

		defaultContents();
		clickElement("Ios preview icon,xpath,//div[@class=' rs-mobile-preview-enable']//li//span[.='iOS']");
		String previewbox = getStrText("live preview,xpath,//div[contains(@class,'rs-browser-content')]/.//span//p");
		if (previewbox.contains(titleconetent))
		{
			BaseTest.getTest().log(Status.PASS, "Live Preview Content is same as given Text content");

		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Live Preview Content is not same as given Text content");

		}
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait2sec);
		BaseTest.takeScreenshot();
		String url = System.getProperty("webMobilePushImageUrl");
		threadSleep(ObjectRepository.wait2sec);
		clickElement("image icon,xpath,//i[@class='icon-rs-image-medium icon-md']");
		explicitwaitforvisibility(autolocator("image,xpath,//a[contains(text(),'Image URL')]"), 20);
		clickElement("image,xpath,//a[contains(text(),'Image URL')]");
		threadSleep(ObjectRepository.wait2sec);
		sendValue("url,xpath,//input[@name='split" + selectedSplitCaps + ".previewImage']", url);
		String enteredurl = getTextBoxVal("url,xpath,//input[@name='split" + selectedSplitCaps + ".previewImage']", "value");
		if (url.equals(enteredurl))
		{
			tabAction();
			threadSleep(ObjectRepository.wait2sec);

			clickElement(",xpath,//button[.='Upload']");

			BaseTest.takeScreenshot();
		}

		return this;
	}

	public CommunicationMobilePushPage mobilepushcontent(String Pushcontent)
	{
		threadSleep(ObjectRepository.wait1sec);
		javaScriptScrollDownToSomeExtend();
		threadSleep(ObjectRepository.wait1sec);

		clickElement(replacePlaceHolder(CommunicationRepository.notification_mobpush_AlertpushTypeText, Pushcontent));

		javaScriptScrollIntoView(replacePlaceHolder(CommunicationRepository.notification_mobpush_AlertpushTypeText, Pushcontent));
		threadSleep(ObjectRepository.wait1sec);
		return this;

	}

	// Enter Title
	public CommunicationMobilePushPage mobilepushTitleAndContentEnter()
	{
		int startDate = 0;

		String titleconetent = communicationName;
		enterValue(CommunicationRepository.notification_mobpush_entertitletext, titleconetent);
		//// Emoji script
//		clickElement(",id,rs_RSEmojiPicker_Emoji");
//		WebElement ele = driver.findElement(By.xpath("//em-emoji-picker")).getShadowRoot().findElement(By.cssSelector("span.emoji-mart-emoji>span"));
//		ele.click();
//
//		clickElement(",id,rs_RSEmojiPicker_Emoji");

		threadSleep(ObjectRepository.wait3sec);

		clickElement(",xpath,(//i[contains(@class,'user-question')])[1]");
		threadSleep(ObjectRepository.wait3sec);
		selectlistelements(",xpath,//div[@class='css-scrollbar']//div", System.getProperty("Persona_3"));

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='k-iframe']")));

		String content = "Hey" + " " + communicationName;
		enterValue(CommunicationRepository.notification_mobpush_bodyMessage, content);

		defaultContents();
		clickElement("Ios preview icon,xpath,//div[@class=' rs-mobile-preview-enable']//li//span[.='iOS']");
		String previewbox = getStrText("live preview,xpath,//div[contains(@class,'rs-browser-content')]/.//span//p");
		if (previewbox.contains(titleconetent))
		{
			BaseTest.getTest().log(Status.PASS, "Live Preview Content is same as given Text content");

		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Live Preview Content is not same as given Text content");

		}
		addtimer(startDate);
		return this;
	}

	public CommunicationMobilePushPage ETmobilepushTitleAndContentEnter()
	{
		int startDate = 0;

		String titleconetent = communicationName;
		enterValue(CommunicationRepository.notification_mobpush_entertitletext, titleconetent);
		//// Emoji script
		clickElement(",id,rs_RSEmojiPicker_Emoji");
		WebElement ele = driver.findElement(By.xpath("//em-emoji-picker")).getShadowRoot().findElement(By.cssSelector("span.emoji-mart-emoji>span"));
		ele.click();

		clickElement(",id,rs_RSEmojiPicker_Emoji");

		threadSleep(ObjectRepository.wait3sec);

		clickElement(",xpath,(//i[contains(@class,'user-question')])[1]");
		threadSleep(ObjectRepository.wait3sec);
		selectlistelements(",xpath,//div[@class='css-scrollbar']//div", System.getProperty("Persona_3"));
		String content = "Hey" + " " + communicationName;
		enterValue("content box,id,editorText", content);

		return this;
	}

	public CommunicationMobilePushPage addtimer(int day)
	{
		clickElement("add timer,xpath,//i[@title='Add timer']");
		isElementPresent("timer heading,xpath,//div[@class='modal-content rsmd-content']//h2");
		clickElement("schedule timer,xpath,//input[@name='timer']");
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_emailschedule_datepopupactive), 30);
		String scheduleformat = calendarSchedduleDate(day, "MMMM d, yyy");
		javaScriptScrollDown();
		threadSleep(ObjectRepository.wait10sec);
		clickElement("schedule time,xpath,//td[contains(@title,'" + scheduleformat + "')]//span");
		javaScriptScrollDown();
		clickElement(CommunicationRepository.communicationpage_emailschedule_calendar_TimehoursSelect);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(CommunicationRepository.communicationpage_emailschedule_calendar_TimeminsSelect);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(CommunicationRepository.communicationpage_emailschedule_calendar_Timeset);
		threadSleep(ObjectRepository.wait2sec);
		BaseTest.takeScreenshot();
		clickElement("insert button,xpath,//button[.='Insert']");
		javascriptdoublescrollup();
		javascriptdoublescrollup();
		clickElement("add timer,xpath,//i[@title='Add timer']");

		isElementPresent("timer heading,xpath,//div[@class='modal-content rsmd-content']//h2");

		clickElement("refresh button,xpath,//div[@class='mb30 row']//i[@id='rs_data_refresh']");
		clickElement("insert button,xpath,//button[.='Insert']");

		return this;
	}

	public CommunicationMobilePushPage mpImageURL()
	{
		String url = System.getProperty("webMobilePushImageUrl");
		threadSleep(ObjectRepository.wait2sec);
		clickElement(CommunicationRepository.notification_mobpush_imgContent);
		explicitwaitforvisibility(autolocator(CommunicationRepository.notification_mobpush_imgURL), 20);
		clickElement(CommunicationRepository.notification_mobpush_imgURL);
		threadSleep(ObjectRepository.wait2sec);

		sendValue(CommunicationRepository.notification_mobpush_imgURLEnter, url);
		String enteredurl = getTextBoxVal(CommunicationRepository.notification_mobpush_imgURLEnter, "value");
		if (url.equals(enteredurl))
		{
			tabAction();
			threadSleep(ObjectRepository.wait2sec);

			clickElement(CommunicationRepository.notification_mobpush_imgURLSave);

			BaseTest.takeScreenshot();
		}

		return this;
	}

	public CommunicationMobilePushPage MpBrowseImage()
	{
		// javaScriptScrollUpToSomeExtend();
		clickElement(CommunicationRepository.notification_webpush_imgcontenticon);
		explicitwaitforvisibility(autolocator(CommunicationRepository.notification_webpush_selectbrowseimage), 20);
		clickElement(CommunicationRepository.notification_webpush_selectbrowseimage);
		threadSleep(ObjectRepository.wait2sec);
		String file = BaseTest.curr_Dir + "\\src\\main\\resources" + "\\data\\uploadfiles\\Testing image.jpg";
		sendValues(CommunicationRepository.notification_webpush_selectbrowseimage_upload, file);
		tabAction();
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait3sec);

		BaseTest.takeScreenshot();
		return this;
	}

	// Select Mobile push Interactivity
	public CommunicationMobilePushPage mobilepushSetInteractivity()
	{
		javaScriptScrollIntoView(CommunicationRepository.notification_mobpush_selectinteractivityONOFF);
		String deepLinkText = getTextBoxVal(CommunicationRepository.notification_mobpush_selectinteractivityONOFF, "class");
		if (BaseTest.getData().WebMobileInteractivity.toLowerCase().contains("on"))
		{
			if (!deepLinkText.contains("switch-on"))
			{
				clickElement(CommunicationRepository.notification_mobpush_selectinteractivityONOFF);
				BaseTest.getTest().log(Status.INFO, "Set Interactivity as ON");
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Interactivity is ON");
			}

			clickElement(CommunicationRepository.notificaiton_mobpush_selectinteractivitybutton);
			selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Unsubscribe");

			explicitwaitforclick(autolocator(CommunicationRepository.notification_mobpush_selectinteractivityONOFF), 30);
			clickElement(CommunicationRepository.notificaiton_mobpush_selectinteractivitybutton);
			String WebInteractivityAction = BaseTest.getData().WebMobileInteractivityAction;

			selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().WebMobileInteractivityAction);

			if (!WebInteractivityAction.contains("Unsubscribe") || !WebInteractivityAction.toLowerCase().contains("Dismiss"))
			{
				if (WebInteractivityAction.contains("Maybe later"))
				{

					explicitwaitforclick(autolocator(CommunicationRepository.notificaiton_mobpush_setFrequency), 20);
					clickElement(CommunicationRepository.notificaiton_mobpush_setFrequency);
					selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().MobileSetFrequency);

					clickElement(CommunicationRepository.notificaiton_mobpush_setFrequencyHours);
					enterValue(CommunicationRepository.notificaiton_mobpush_setFrequencyHours, BaseTest.getData().MobileSetFrequencyTime);
				} else if (WebInteractivityAction.contains("Share"))
				{
					clickElement(CommunicationRepository.notificaiton_mobpush_customactionIcon);
					enterValue(CommunicationRepository.notificaiton_mobpush_customButtonText, BaseTest.getData().WebMobileCustomButtonName);
					clickElement(CommunicationRepository.notificaiton_mobpush_customBehaviour);
					enterValue(CommunicationRepository.notificaiton_mobpush_customBehaviour, "welcome this test");

//					selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().WebMobileClickBehaviour);
//					if (BaseTest.getData().WebMobileClickBehaviour.toLowerCase().contains("enter new link"))
//					{
//						enterValue(CommunicationRepository.notificaiton_mobpush_customactionBehaviourLink, BaseTest.getData().WebMobileClickBehaviourLink);
//						clickElement(CommunicationRepository.notificaiton_mobpush_customactionBehaviourType);
//						selectlistelements(CommunicationRepository.notificaiton_mobpush_customactionBehaviourTypeList, BaseTest.getData().WebMobileClickBehaviourType);
//					}
//					clickElement(CommunicationRepository.notification_mobpush_custombuttonpopupsave);
				}
			}

		} else if (BaseTest.getData().WebMobileInteractivity.toLowerCase().contains("off"))
		{
			if (deepLinkText.contains("switch-off"))
			{
				BaseTest.getTest().log(Status.INFO, "Interactivity is OFF");
			} else
			{
				clickElement(CommunicationRepository.notification_mobpush_selectinteractivity);
				BaseTest.getTest().log(Status.WARNING, "Set Interactivity not available");
				BaseTest.takeScreenshot();
			}
		}

		return this;
	}

	// Select Web Push Expiry
	public CommunicationMobilePushPage mobilepushSetExpiry()
	{
		// javaScriptScrollDown();
		threadSleep(ObjectRepository.wait1sec);
		String expiryText = getTextBoxVal(CommunicationRepository.notification_mobpush_expiryswitchONOFF, "class");
		if (BaseTest.getData().WebMobileExpiry.toLowerCase().contains("on"))
		{
			if (!expiryText.contains("switch-on"))
			{
				clickElement(CommunicationRepository.notification_mobpush_expiryswitchONOFF);
				BaseTest.getTest().log(Status.INFO, "Set expiry as ON");
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Expiry is ON");
			}
			javaScriptScrollUpToSomeExtend();
			threadSleep(ObjectRepository.wait1sec);

			clickElement(CommunicationRepository.notification_mobpush_selectexpirybutton);
			selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().WebMobileExpirySchdule);
			enterValue(CommunicationRepository.notification_mobpush_enterexpiretime, BaseTest.getData().WebMobileExpiryDuration);
			threadSleep(ObjectRepository.wait1sec);
			tabAction();

		} else if (BaseTest.getData().WebMobileExpiry.toLowerCase().contains("off"))
		{

			BaseTest.getTest().log(Status.INFO, "Expiry is OFF");
			threadSleep(ObjectRepository.wait1sec);
			tab();

		}
		return this;
	}

	public CommunicationMobilePushPage mobilepushHashtag()
	{
		String[] values = System.getProperty("hastag").split("/");
		threadSleep(ObjectRepository.wait1sec);
		for (int i = 0; i < 5; i++)
		{
			enterValue(CommunicationRepository.notification_mobpush_hashtag, values[i]);
			enterAction();
		}

		return this;
	}

	public CommunicationMobilePushPage mobilepushAlert()
	{
		threadSleep(ObjectRepository.wait1sec);
		try
		{

			clickElement(CommunicationRepository.notification_mobpush_alertswitchONOFF);
			pageLoaderLogo();
			clickElement(CommunicationRepository.notification_mobpush_alertdropdown);
			selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, System.getProperty("alertsound"));
			threadSleep(ObjectRepository.wait1sec);

		} catch (Exception e)
		{

			BaseTest.getTest().log(Status.INFO, "Alert is OFF");
			threadSleep(ObjectRepository.wait1sec);

		}

		return this;
	}

	// Select Time zone carousel
	public CommunicationListingPage mobilepushSetTimeZoneScheduleDateCarouselSplit(String scheduleDate)
	{
		String timezone = BaseTest.getData().TimeZone;
		clickElement(CommunicationRepository.notification_push_mobiletimezoneiconCarousel);
		explicitwaitforclick(autolocator(CommunicationRepository.notification_push_mobiletimezoneCarousel), 30);
		clickElement(CommunicationRepository.notification_push_mobiletimezoneCarousel);
		threadSleep(ObjectRepository.wait1sec);
		WebElement element = driver.findElement(autolocator("TimeZone list,xpath,//ul[@id='PushTimeZoneCRSL_listbox']/li[@title='" + timezone + "']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		// selectlistelements(CommunicationRepository.notification_push_selectmobiletimezonelist, BaseTest.getData().TimeZone);
		selectDate(CommunicationRepository.notification_mobpush_selectscheduledateCarousel, scheduleDate);
		threadSleep(ObjectRepository.wait1sec);
		return this;
	}

	// Select Time zone
	public CommunicationListingPage mobilepushSetTimeZoneScheduleDate()
	{
		javaScriptScrollDownToSomeExtend();
		threadSleep(ObjectRepository.wait1sec);
		String timezone = BaseTest.getData().TimeZone;
		clickElement(CommunicationRepository.notification_push_mobiletimezoneicon);
		explicitwaitforclick(autolocator(CommunicationRepository.notification_push_mobiletimezonelist), 30);
		clickElement(CommunicationRepository.notification_push_mobiletimezonelist);
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, timezone);
		threadSleep(ObjectRepository.wait1sec);
		return this;
	}
//	// Select email schedule date
//		@Override
//		public CommunicationEmailChannelPage enterScheduleDate(String val)
//		{
//			javaScriptScrollDown();
//			threadSleep(ObjectRepository.wait1sec);
//			selectDate(CommunicationRepository.communicationpage_emailschedule_date, val);
//			JavascriptExecutor jse = ((JavascriptExecutor) driver);
//			WebElement sDate = driver.findElement(By.id("EmailScheduleDate"));
//			captureEmailScheduleDate = (String) jse.executeScript("return arguments[0].value", sDate);
//			return this;
//		}

	public CommunicationMobilePushPage enterMobilepushScheduleTime(int day)
	{
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_emailschedule_time), 30);
		clickElement(CommunicationRepository.communicationpage_emailschedule_time);
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_emailschedule_datepopupactive), 30);
		String scheduleformat = calendarSchedduleDate(day, "MMMM d, yyy");
		javaScriptScrollDown();
		threadSleep(ObjectRepository.wait10sec);
		clickElement("schedule time,xpath,//td[contains(@title,'" + scheduleformat + "')]//span");
		javaScriptScrollDown();
		clickElement(CommunicationRepository.communicationpage_emailschedule_calendar_TimehoursSelect);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(CommunicationRepository.communicationpage_emailschedule_calendar_TimeminsSelect);
		threadSleep(ObjectRepository.wait3sec);

		clickElement(CommunicationRepository.communicationpage_emailschedule_calendar_Timeset);
		return this;
	}

	public CommunicationMobilePushPage mobilepushCommunicationSave()
	{
		javaScriptScrollIntoView(CommunicationRepository.notification_push_clickNotificationCommSave);
		clickElement(CommunicationRepository.notification_push_clickNotificationCommSave);

		return this;
	}

	public CommunicationMobilePushPage mobilepushCommDBValidation()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("COMMUNICATION DB - MOBILE PUSH CHANNEL DETAILS", ExtentColor.BLUE));
		threadSleep(ObjectRepository.wait20sec);
		campDetails = getdbQueryResults(dburl_campaign + campdbname, campaigndb_userName, campaigndb_password, qMobilePushCampDetails(communicationName));
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
			BaseTest.getTest().log(Status.FAIL, "communication details not updated in commdb");
		}
		return this;
	}

	private String subwithPersonalization(String xpathPersonalization, String xpathPersonalizationlist, String inputField)
	{
		String subjectLine = "";
		String fallBack;
		List<String> objStringPersona = new ArrayList<String>();
		objStringPersona.add(System.getProperty("Persona_3"));
		clickElement(xpathPersonalization);
		threadSleep(ObjectRepository.wait3sec);
		List<WebElement> personatxt = driver.findElements(autolocator(xpathPersonalizationlist));
		for (WebElement allele : personatxt)
		{
			String inputtext = allele.getText();
			if (objStringPersona.contains(inputtext))
			{
				allele.click();
				WebElement textField = driver.findElement(autolocator(inputField));
				String[] personalization = textField.getAttribute("value").split("|");
				try
				{
					fallBack = personalization[1].trim();
				} catch (Exception e)
				{
					fallBack = "";
				}
				textField.clear();
				if (fallBack.isEmpty() || fallBack.equals("") || fallBack == null)
				{
					fallBack = "[[No Data]]";
				}
				subjectLine += inputtext + " | " + fallBack + ",";
				fallBack = null;
			}
		}
		clickElement(xpathPersonalization);
		return subjectLine;
	}

	public CommunicationMobilePushPage mobilepushSendTestPreview(String mailIds) throws AWTException
	{
		javaScriptScrollDown();

		clickElement(CommunicationRepository.notification_mobpush_testmailto);
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Enter new email");
		enterValue(CommunicationRepository.notification_mobpush_testmailenter, mailIds);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(CommunicationRepository.notification_mobpush_testcommSent);
		threadSleep(ObjectRepository.wait2sec);
		pageLoaderLogo();
		try
		{
			explicitwaitforvisibility(autolocator(CommunicationRepository.email_testmail_msg), 50);
			if (getStrText(CommunicationRepository.email_testmail_msg).equalsIgnoreCase("Test Communication will be sent shortly."))
			{
				BaseTest.takeScreenshot();
			} else
			{
				BaseTest.getTest().log(Status.WARNING, "Popup present but content is different");
				BaseTest.takeScreenshot();
			}
		} catch (Exception e)
		{
			BaseTest.getTest().log(Status.FAIL, "Failed to get test mail popup");
			BaseTest.takeScreenshot();
		}
		return this;

	}

	public CommunicationMobilePushPage splitMobilePushON(String splitType)
	{
		clickElement(CommunicationRepository.communicationpage_MobileSplitON);
		threadSleep(ObjectRepository.wait3sec);
		for (int count = 2; count < splitType.length(); count++)
		{
			explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_Mobilesplit_addBtn), 30);
			clickElement(CommunicationRepository.communicationpage_Mobilesplit_addBtn);
			threadSleep(ObjectRepository.wait3sec);
		}
		clickElement(CommunicationRepository.communicationpage_MobilesplitABDownarrow);
		threadSleep(ObjectRepository.wait1sec);
		String splitTotalCounts = getStrText("SplitTotalCounts,xpath,(//ul[@class='list-inline small inline']/li)[6]").replaceAll("[^A-Za-z0-9]", "");
		if (!splitTotalCounts.isEmpty())
		{
			splitTotalCount = Integer.parseInt(splitTotalCounts);
		}
		for (int count = 0; count < splitType.length(); count++)
		{
			int li = count + 5;
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
		explicitwaitforvisibility(autolocator(CommunicationRepository.communicationpage_MobilesplitABDrag_save), 20);
		clickElement(CommunicationRepository.communicationpage_MobilesplitABDrag_save);
		return this;
	}

	public CommunicationMobilePushPage splitAutoScheduleOffValidate()
	{
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforclick(autolocator(CommunicationRepository.communication_split_autoschedulemobilesettingsIcon), 30);
		clickElement(CommunicationRepository.communication_split_autoschedulemobilesettingsIcon);
		try
		{
			String autoon = "Auto ON,xpath,(//*[contains(text(),'Auto schedule')]/../div//div[contains(@class,'switch-on')])[1]";
			explicitwaitforvisibility(autolocator(autoon), 20);
			clickElement(autoon);
			BaseTest.getTest().log(Status.INFO, "Auto schedule default ON, user selected Option OFF");
			threadSleep(ObjectRepository.wait1sec);

		} catch (Exception e)
		{
			String autooff = "Auto off,xpath,(//*[contains(text(),'Auto schedule')]/../div//div[contains(@class,'switch-off')])[2]";
			explicitwaitforvisibility(autolocator(autooff), 20);
			BaseTest.getTest().log(Status.INFO, "Auto schedule default OFF, user selected Option OFF");
		}
		clickElement(CommunicationRepository.SplitABAutoshdulemobileSavebutton);
		return this;
	}

	public CommunicationMobilePushPage mobilepushTitleAndContentEnterSplit(String splitType)
	{
		threadSleep(ObjectRepository.wait1sec);
		if (splitType.equalsIgnoreCase("C") || splitType.equalsIgnoreCase("D"))
		{
			clickElement("Split add button,xpath,//a[@class='add-Mobilesplit']");
		}
		clickElement("Carousel -" + splitType + " selected," + "xpath,//a[contains(@href,'liMobilesplit" + splitType + "')]");
		clickElement("Mobile push text type icon,xpath, //a[@id='PushacnRichText" + splitType + "']/i");
		javaScriptScrollIntoView("Mobile push text type icon,xpath, //a[@id='PushacnRichText" + splitType + "']/i");
		threadSleep(ObjectRepository.wait1sec);
		String title = "Hi split-" + splitType + " "
				+ subwithPersonalization("Mobile title personalize icon,xpath,//div[@id='SubjectPersonalize" + splitType + "']",
						"Mobile title personalize list,xpath, //*[@id='divSubjectPersonalizeMP" + splitType + "']//ul[contains(@class,'subjectpersonalFieldsMP" + splitType + "')]/li", CommunicationRepository.notification_mobpush_entertitletext)
				+ " " + communicationName;
		enterValue("Mobile title text,xpath,//input[@id='MobPushTitle_" + splitType + "']/../div[1]", title);
		// enterValue(CommunicationRepository.notification_mobpush_entersubtitle, subtitle);
		String xpathp = "Mobile content personalize icon,xpath,(//div[contains(@class,'mpdivEditorText" + splitType + "')])[1]//ul[contains(@id,'ulPushElements')]//a[@data-original-title='Personalize']/i";
		String xpathplist = "Mobile content personalize list,xpath,(//div[contains(@class,'mpdivEditorText" + splitType + "')])[1]//ul[contains(@class,'personalFieldsPush')]/li";
		String content = "Hey split-" + splitType + " " + subwithPersonalization(xpathp, xpathplist, CommunicationRepository.notification_mobpush_entertitletext);
		sendValue("Mobile bodytext,xpath, //textarea[@id='PushContent" + splitType + "']", content);
		// clickElement("Mobile smartlink icon,xpath,//div[contains(@class,'mpdivEditorText" + splitType +
		// "')]//*[@id='ulPushElements']//a[@data-original-title='Smart link']");
		// selectlistelements("Mobile smartlink list,xpath,//div[contains(@class,'mpdivEditorText" + splitType +
		// "')]//*[@id='ulPushElements']//a[@data-original-title='Smart link']/../ul/li", "Smart link 1");
		return this;
	}

	// Select Mobile push Interactivity
	public CommunicationMobilePushPage mobilepushSetInteractivitySplit(String splitType)
	{
		javaScriptScrollIntoView("Mobile bodytext,xpath, //textarea[@id='PushContent" + splitType + "']");
		String deepLinkText = getTextBoxVal("Mobile interactivity switch,xpath, //label[@for='chkHourspush" + splitType + "']/../..", "class");
		if (BaseTest.getData().WebMobileInteractivity.toLowerCase().contains("on"))
		{
			if (!deepLinkText.contains("switch-on"))
			{
				clickElement("Mobile interactivity switch,xpath, //label[@for='chkHourspush" + splitType + "']");
				BaseTest.getTest().log(Status.INFO, "Set Interactivity as ON");
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Interactivity is ON");
			}

			clickElement("Mobile interactivity,xpath, //span[@aria-owns='interactiveBtnOn" + splitType + "_listbox']");
			selectlistelements("Mobile interactivity listbox,xpath,//*[@id='interactiveBtnOn" + splitType + "_listbox']/li", "Button");
			explicitwaitforclick(autolocator("Mobile interactivity action,xpath, //span[@aria-owns='interactiveBtnSelect" + splitType + "_listbox']"), 30);
			clickElement("Mobile interactivity action,xpath, //span[@aria-owns='interactiveBtnSelect" + splitType + "_listbox']");
			String WebInteractivityAction = BaseTest.getData().WebMobileInteractivityAction;
			if (BaseTest.getData().WebMobileDeferredDeepLinking.equalsIgnoreCase("ON"))
			{
				selectlistelements("Mobile interactivity action listbox,xpath, //*[@id='interactiveBtnSelect" + splitType + "_listbox']/li", WebInteractivityAction);
			} else
			{
				selectlistelements("Mobile interactivity action listbox,xpath, (//*[@id='interactiveBtnSelect" + splitType + "_listbox'])[2]/li", WebInteractivityAction);
			}

			if (!WebInteractivityAction.contains("Unsubscribe") || !WebInteractivityAction.toLowerCase().contains("Dismiss"))
			{
				if (WebInteractivityAction.contains("Maybe later"))
				{

					explicitwaitforclick(autolocator("Mobile may be later set frequency,xpath,//span[@aria-owns='PushReschedule" + splitType + "_listbox']"), 20);
					clickElement("Mobile may be later set frequency,xpath,//span[@aria-owns='PushReschedule" + splitType + "_listbox']");
					selectlistelements("Set frequency list,xpath,//ul[@id='PushReschedule" + splitType + "_listbox']/li", BaseTest.getData().MobileSetFrequency);

					clickElement("Set frequency hours,id,txtInteractivehours" + splitType);
					enterValue("Set frequency hours,id,txtInteractivehours" + splitType, BaseTest.getData().MobileSetFrequencyTime);
				} else if (WebInteractivityAction.contains("Custom Action"))
				{
					clickElement("Custom action setting icon,xpath,//div[@id='interactiveBtn" + splitType + "']/..//a[@title='Interactive Custom parameters']");
					explicitwaitforvisibility(autolocator(CommunicationRepository.notificaiton_mobpush_customButtonText), 20);
					enterValue(CommunicationRepository.notificaiton_mobpush_customButtonText, BaseTest.getData().WebMobileCustomButtonName);
					clickElement(CommunicationRepository.notificaiton_mobpush_customBehaviour);
					selectlistelements(CommunicationRepository.notificaiton_mobpush_customBehaviourList, BaseTest.getData().WebMobileClickBehaviour);
					if (BaseTest.getData().WebMobileClickBehaviour.toLowerCase().contains("enter new link"))
					{
						enterValue(CommunicationRepository.notificaiton_mobpush_customactionBehaviourLink, BaseTest.getData().WebMobileClickBehaviourLink);
						clickElement(CommunicationRepository.notificaiton_mobpush_customactionBehaviourType);
						selectlistelements(CommunicationRepository.notificaiton_mobpush_customactionBehaviourTypeList, BaseTest.getData().WebMobileClickBehaviourType);
					}
					clickElement(CommunicationRepository.notification_mobpush_custombuttonpopupsave);
				}
			}

		} else if (BaseTest.getData().WebMobileInteractivity.toLowerCase().contains("off"))
		{
			if (deepLinkText.contains("switch-off"))
			{
				BaseTest.getTest().log(Status.INFO, "Interactivity is OFF");
			} else
			{
				clickElement("Mobile interactivity switch,xpath, //label[@for='chkHourspush" + splitType + "']");
				BaseTest.getTest().log(Status.INFO, "Set Interactivity as OFF");
			}
		}
		javaScriptScrollIntoView(CommunicationRepository.notification_mobpush_secureMSGONOFF);
		return this;
	}

	// Select mobile Push Expiry
	public CommunicationMobilePushPage mobilepushSetExpirySplit(String splitType)
	{
		javaScriptScrollIntoView("Mobile interactivity switch,xpath, //label[@for='chkHourspush" + splitType + "']");
		threadSleep(ObjectRepository.wait1sec);
		String expiryText = getTextBoxVal(CommunicationRepository.notification_mobpush_expiryswitchONOFF, "class");
		if (BaseTest.getData().WebMobileExpiry.toLowerCase().contains("on"))
		{
			if (!expiryText.contains("switch-on"))
			{
				clickElement(CommunicationRepository.notification_mobpush_expiryswitch);
				BaseTest.getTest().log(Status.INFO, "Set expiry as ON");
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Expiry is ON");
			}
			explicitwaitforclick(autolocator(CommunicationRepository.notification_mobpush_selectexpirybutton), 30);
			clickElement(CommunicationRepository.notification_mobpush_selectexpirybutton);
			selectlistelements(CommunicationRepository.notification_mobpush_selectexpirybuttonlist, BaseTest.getData().WebMobileExpirySchdule);
			enterValue(CommunicationRepository.notification_mobpush_enterexpiretime, BaseTest.getData().WebMobileExpiryDuration);

		} else if (BaseTest.getData().WebMobileExpiry.toLowerCase().contains("off"))
		{
			if (!expiryText.contains("switch-off"))
			{
				clickElement(CommunicationRepository.notification_mobpush_expiryswitch);
				BaseTest.getTest().log(Status.INFO, "Set expiry as OFF");
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Expiry is OFF");
			}
		}
		return this;
	}

	public CommunicationMobilePushPage mobilepushmakealert()
	{
		pageLoaderLogo();
		javaScriptScrollDown();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-400)");
		threadSleep(ObjectRepository.wait3sec);
		String expiryText = getTextBoxVal(CommunicationRepository.notification_mobpush_MakealertswitchONOFF, "class");

		if (!expiryText.contains("switch-on"))
		{
			clickElement(CommunicationRepository.notification_mobpush_MakealertswitchONOFF);
			BaseTest.getTest().log(Status.INFO, "Set expiry as ON");
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Expiry is ON");
		}

		threadSleep(ObjectRepository.wait3sec);
		enterValue(CommunicationRepository.notification_mobpush_Makealert_titletext, "Test");
		clickElement(CommunicationRepository.notification_mobpush_MakeAlert_personalization);

		toolTipValidationKnownText(CommunicationRepository.notification_mobpush_MakeAlert_personalization, "Personalization");

		threadSleep(ObjectRepository.wait3sec);
		selectlistelements(",xpath,//div[@class='css-scrollbar']//div", System.getProperty("Persona_3"));
		clickElement(CommunicationRepository.Notification_MP_MakeAlert_title_emoji);
		WebElement ele = driver.findElement(By.xpath("//em-emoji-picker")).getShadowRoot().findElement(By.cssSelector("span.emoji-mart-emoji>span"));
		ele.click();

		clickElement(CommunicationRepository.Notification_MP_MakeAlert_title_emoji);
		enterValue(CommunicationRepository.notification_mobpush_MakeAlert_short_description, "test");
		clickElement(CommunicationRepository.notification_mobpush_MakeAlert_short_description_personalization);
		toolTipValidationKnownText(CommunicationRepository.notification_mobpush_MakeAlert_short_description_personalization, "Personalization");

		threadSleep(ObjectRepository.wait3sec);
		javaScriptScrollDownToSomeExtend();
		selectlistelements(",xpath,//div[@class='css-scrollbar']//div", System.getProperty("Persona_3"));
		clickElement(CommunicationRepository.Notification_MP_MakeAlert_sub_descrption_emoji);
		WebElement ele1 = driver.findElement(By.xpath("//em-emoji-picker")).getShadowRoot().findElement(By.cssSelector("span.emoji-mart-emoji>span"));
		ele1.click();
		clickElement(CommunicationRepository.Notification_MP_MakeAlert_sub_descrption_emoji);

		return this;

	}

	public CommunicationMobilePushPage clickImportMobilepush()
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
