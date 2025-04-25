package pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.microsoft.playwright.Page;

import repository.AudienceRepository;
import repository.CommunicationRepository;
import repository.DashboardRepository;
import repository.ObjectRepository;
import repository.WebmailRepository;
import utility.BaseTest;
import utility.PageBase;
import utility.PageFactory;

public class CommunicationEmailChannelPage extends CommunicationCreatePage
{
	public String aaaa, Content;
	int projectedCTR, subjectLineLength;
	int splitSize, splitTotalCount, splitGroupACount, splitGroupBCount, splitGroupCCount, splitGroupDCount;
	int splitGroupAPercent, splitGroupBPercent, splitGroupCPercent, splitGroupDPercent;

	public CommunicationEmailChannelPage(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	public CommunicationEmailChannelPage emailCommCreationPage()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel(" EMAIL COMMUNICATION CREATION ", ExtentColor.BROWN));
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_channel_options), 30);
		for (WebElement element : findElements(CommunicationRepository.communicationpage_channel_options))
		{
			String channel = element.getText();
			String status = element.getAttribute("class");
			if (!channel.equals("Email") || !status.contains("active"))
			{
				BaseTest.getTest().fail("Email Communication page isn't displayed");
				BaseTest.takeScreenshot();
			}
		}
		return this;
	}

	// Enter Email sender name
	public CommunicationEmailChannelPage enterSendersName()
	{
		pageLoaderLogo();
		enterValue(CommunicationRepository.communicationpage_email_sender_username, System.getProperty("sender_Name")).tabAction();
		return this;
	}

	// Enter Email sender address
	public CommunicationEmailChannelPage enterSendersEmailAddress()
	{
		pageLoaderLogo();
		clickElement(CommunicationRepository.communicationpage_email_sender_username);
		threadSleep(ObjectRepository.wait3sec);
		enterValue(CommunicationRepository.communicationpage_email_sender_username, System.getProperty("sender_Name")).tabAction();
		clickElement(CommunicationRepository.communicationpage_email_sender_domain);
		selectlistelements(CommunicationRepository.communicationpage_email_sender_domainlist, System.getProperty("senderMailId"));
		return this;
	}

	public CommunicationEmailChannelPage emailsendername()
	{

		pageLoaderLogo();
		clickElement(CommunicationRepository.Communication_personalization);
		clickElement(",xpath,//a[.='[[Name]]']");
		boolean attributeNameAndValue = getAttributeNameAndValue(",id,rs_Email_senderName", "valoe");
		BaseTest.takeScreenshot();
		clickElement(CommunicationRepository.Communication_replymail);
		javaScriptScrollDownToSomeExtend();
		clickElement(CommunicationRepository.Communication_alyrtnatemail);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, System.getProperty("alternatemail"));

		return this;
	}

	public CommunicationEmailChannelPage Goaltype()
	{
		pageLoaderLogo();
		javaScriptScrollDownToSomeExtend();
		clickElement(CommunicationRepository.communicationpage_primarygoal_select);
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Engagement");
		threadSleep(ObjectRepository.wait5sec);
		pageLoaderLogo();

		clickElement(CommunicationRepository.communicationpage_primarygoal_Conversion);
		threadSleep(ObjectRepository.wait5sec);
		List<WebElement> attributes = findElements(DashboardRepository.allpage_common_selectdropdownlist);
		List<String> analyticsAttributes = new LinkedList<>();
		for (int count = 0; count < attributes.size(); count++)
		{
			attributes = findElements(DashboardRepository.allpage_common_selectdropdownlist);
			threadSleep(ObjectRepository.wait1sec);
			analyticsAttributes.add(attributes.get(count).getText());
			attributes.get(count).click();
			clickElement(CommunicationRepository.communicationpage_primarygoal_Conversion);
		}
		threadSleep(ObjectRepository.wait5sec);

		clickElement(CommunicationRepository.communicationpage_primarygoal_select);
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Conversion");
		threadSleep(ObjectRepository.wait5sec);
		pageLoaderLogo();
		clickElement(CommunicationRepository.communicationpage_primarygoal_Conversion);
		threadSleep(ObjectRepository.wait5sec);
		List<WebElement> attributes1 = findElements(DashboardRepository.allpage_common_selectdropdownlist);
		List<String> analyticsAttributes1 = new LinkedList<>();
		for (int count = 0; count < attributes1.size(); count++)
		{
			attributes1 = findElements(DashboardRepository.allpage_common_selectdropdownlist);
			threadSleep(ObjectRepository.wait1sec);
			analyticsAttributes1.add(attributes1.get(count).getText());
			attributes1.get(count).click();
			clickElement(CommunicationRepository.communicationpage_primarygoal_Conversion);
		}

		tabAction();
		enterGoalPercentage();
		threadSleep(ObjectRepository.wait1sec);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait2sec);
		javaScriptScrollUpToSomeExtend();
		clickElement(CommunicationRepository.communicationpage_primarygoal_select);
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, BaseTest.getData().PrimaryGoal);
		threadSleep(ObjectRepository.wait5sec);
		pageLoaderLogo();
		if (BaseTest.getData().PrimaryGoal.toLowerCase().contains("conversion"))
		{
			clickElement(CommunicationRepository.communicationpage_primarygoal_Conversion);
			selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Thankyou page");
		}
		tabAction();

		return this;
	}

	public CommunicationEmailChannelPage enternewsenderid()
	{
		threadSleep(ObjectRepository.wait1sec);
		clearField(CommunicationRepository.communicationpage_email_Sender_id);
		sendValue(CommunicationRepository.communicationpage_email_Sender_id, BaseTest.getData().SenderID);

		return this;
	}

	public CommunicationEmailChannelPage enternewRecipient()
	{

		javaScriptScrollDownToSomeExtend();
		clickElement(CommunicationRepository.communicationpage_email_receip_click);
		sendValue(",xpath,//input[@aria-haspopup]", BaseTest.getData().TargetListNew);
		threadSleep(ObjectRepository.wait2sec);
		pageLoaderLogo();
		if (!selectlistelementsAndProceed(CommunicationRepository.communicationpage_communicationtype_listbox, BaseTest.getData().TargetListNew))
		{
			enterValue(",xpath,//input[@aria-haspopup]", BaseTest.getData().TargetListOld);
			threadSleep(ObjectRepository.wait2sec);
			pageLoaderLogo();
			selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, BaseTest.getData().TargetListOld);
			threadSleep(ObjectRepository.wait3sec);
			BaseTest.takeScreenshot();
		}
		audienceList = getStrText(CommunicationRepository.communicationpage_AudienceList);
		audienceCount = authoringPageAudienceCount();
		return this;
	}

	public String authoringPageAudienceCount()
	{
		audienceCount = null;
		threadSleep(ObjectRepository.wait2sec);
		if (isElementPresent(",xpath,//small[@class='position-absolute right15 top34']"))
		{
			String[] audience = getStrText(",xpath,//small[@class='position-absolute right15 top34']").split(":");
			uiPageEqualswithInputValue(audience[0].trim(), "Audience");
			audienceCount = audience[1].trim();
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Total Audience Count is not Displayed.");
			BaseTest.takeScreenshot();

		}
		return audienceCount;
	}

	public CommunicationEmailChannelPage SMSregressionscript()
	{
		clickElement("flash message,id,flashMessage");
		clickElement("language,id,rs_Messaging_language");
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "English (UK)");
		return this;
	}

	public CommunicationEmailChannelPage emailChannelPageCompareAttributeValuesInEditMode()
	{
		if (isDisplayed(CommunicationRepository.communicationpage_smarturl_nothanks))
		{
			clickElement(CommunicationRepository.communicationpage_smarturl_nothanks);
		}

		String SenderName = getTextBoxVal(CommunicationRepository.communicationpage_email_sender_username, "Value");
		if (!SenderName.equals(System.getProperty("sender_Name")))
		{
			BaseTest.getTest().log(Status.FAIL, "Communication sender name  : '" + SenderName + "' differs");
			BaseTest.takeScreenshot();
		}
		javaScriptScrollIntoView(CommunicationRepository.communicationemail_comm_subjectline);
		String subline = getStrText(CommunicationRepository.communicationemail_comm_subjectline).toLowerCase();
		if (!subline.contains(emailSubjectline.toLowerCase()))
		{
			BaseTest.getTest().log(Status.FAIL, "Communication subject line  : '" + subline + "' expected :" + emailSubjectline);
			BaseTest.takeScreenshot();
		}
		return this;

	}

	public CommunicationEmailChannelPage emailChannelRFAPageCompareAttributeValuesInEditMode(String status)
	{
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait3sec);
		clickElement(replacePlaceHolder(CommunicationRepository.CommunicationListing_detailslistingplusicon, CommunicationNamE));
		threadSleep(ObjectRepository.wait3sec);
		pageLoaderLogo();
		String detailrow = getStrText(CommunicationRepository.CommunicationListing_detailslistingstatus); // on hold
		if (detailrow.equalsIgnoreCase(status))
		{
			if (detailrow.equalsIgnoreCase("pending for approval") || detailrow.equalsIgnoreCase("in progress") || detailrow.equalsIgnoreCase("completed"))
			{
				clickElement(replacePlaceHolder(CommunicationRepository.CommunicationListing_detailslistingminusicon, CommunicationNamE));
				editcomm();
				communicationPlanPageCompareAttributeValues();
				javaScriptScrollDown();
				clickNext();
				pageLoaderLogo();
				///////////////////////////////////////////////

				String uistatus = getTextBoxVal(CommunicationRepository.communicationpage_communication_recipient, "class");
				if (uistatus.contains("off"))
				{
					BaseTest.getTest().log(Status.INFO, "The selected recipient is not editable in rfa communication edit mode");
					BaseTest.takeScreenshot();
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Able to be edit Rfa communication recipient list, after setting up in edit mode ");
					BaseTest.takeScreenshot();
				}

				javaScriptScrollDownToSomeExtend();
				threadSleep(ObjectRepository.wait1sec);

				String selectedsubjectline = getTextBoxVal(CommunicationRepository.communicationemail_comm_subject, "class");
				if (selectedsubjectline.contains("click-off"))
				{
					BaseTest.getTest().log(Status.INFO, "The subject line is not editable in rfa communication edit mode");
					BaseTest.takeScreenshot();
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Able to be edit rfa communication subject line, after setting up in edit mode ");
					BaseTest.takeScreenshot();
				}
				javaScriptScrollDown();
				threadSleep(ObjectRepository.wait2sec);
				/////////////////////////////////////////////////////////////////

				String selectedscheduledate = getTextBoxVal(CommunicationRepository.communication_email_scheduleddateedit, "class");
				if (selectedscheduledate.contains("click-off"))
				{
					BaseTest.getTest().log(Status.INFO, "The Schedule Date is not editable in rfa communication edit mode");
					BaseTest.takeScreenshot();
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Able to be edit Rfa communication scheduledate, after setting up in edit mode ");
					BaseTest.takeScreenshot();

				}

				String selectedrfa = getTextBoxVal(CommunicationRepository.communication_email_selectedrfa, "class");
				if (selectedrfa.contains("click-off"))
				{
					BaseTest.getTest().log(Status.INFO, "The Selected RFA email is not editable in rfa communication edit mode");
					BaseTest.takeScreenshot();
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Able to be edit Rfa email selection, after setting up in edit mode ");
					BaseTest.takeScreenshot();
				}

			} else
			{
				if (status.equalsIgnoreCase("on hold"))
				{
					clickElement(CommunicationRepository.CommunicationListing_detailslistingcommentbox);
					pageLoaderLogo();
					explicitwaitforvisibility(autolocator(CommunicationRepository.CommunicationListing_detailslistingmakechangestext), 20);
					String makechangeslist = getStrText(CommunicationRepository.CommunicationListing_detailslistingmakechangestext);
					if (makechangeslist.equalsIgnoreCase("RFA SMS make change communication:" + communicationName))
					{
						BaseTest.getTest().info("Make changes comments updated");
					} else
					{
						BaseTest.getTest().fail("Make changes comments not updated");
						BaseTest.takeScreenshot();
					}
					clickElement(CommunicationRepository.CommunicationListing_detailsmakechangesclose);
				}
				threadSleep(ObjectRepository.wait3sec);

				clickElement(replacePlaceHolder(CommunicationRepository.CommunicationListing_detailslistingminusicon, CommunicationNamE));
				editcomm();
				communicationPlanPageCompareAttributeValues();
				javaScriptScrollDown();
				clickNext();
				enterEmailsubwithPersonalization();
				javaScriptScrollDown();
				if (detailrow.equalsIgnoreCase(status))
				{
					requestforApprovalEmail1(audience_approver1);
				}
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Expected status: " + status + " and actual status " + detailrow + " is different");
		}
		return this;
	}

	public CommunicationEmailChannelPage ETemailChannelRFAPageCompareAttributeValuesInEditMode(String status)
	{
		clickElement(replacePlaceHolder(CommunicationRepository.CommunicationListing_detailslistingplusicon, communicationName));
		threadSleep(ObjectRepository.wait3sec);
		pageLoaderLogo();
		String detailrow = getStrText(CommunicationRepository.CommunicationListing_detailslistingstatus); // on hold
		if (detailrow.equalsIgnoreCase(status))
		{
			if (detailrow.equalsIgnoreCase("pending for approval") || detailrow.equalsIgnoreCase("in progress") || detailrow.equalsIgnoreCase("completed"))
			{
				clickElement(replacePlaceHolder(CommunicationRepository.CommunicationListing_detailslistingminusicon, communicationName));
				editcomm();
				communicationPlanPageCompareAttributeValues();
				javaScriptScrollDown();
				clickNext();
				pageLoaderLogo();
				///////////////////////////////////////////////

				javaScriptScrollDownToSomeExtend();
				threadSleep(ObjectRepository.wait1sec);

				String selectedsubjectline = getTextBoxVal(CommunicationRepository.communicationemail_comm_subject, "class");
				if (selectedsubjectline.contains("click-off"))
				{
					BaseTest.getTest().log(Status.INFO, "The subject line is not editable in rfa communication edit mode");
					BaseTest.takeScreenshot();
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Able to be edit rfa communication subject line, after setting up in edit mode ");
					BaseTest.takeScreenshot();
				}
				javaScriptScrollDown();
				threadSleep(ObjectRepository.wait2sec);
				/////////////////////////////////////////////////////////////////

				String selectedrfa = getTextBoxVal(CommunicationRepository.communication_email_selectedrfa, "class");
				if (selectedrfa.contains("click-off"))
				{
					BaseTest.getTest().log(Status.INFO, "The Selected RFA email is not editable in rfa communication edit mode");
					BaseTest.takeScreenshot();
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Able to be edit Rfa email selection, after setting up in edit mode ");
					BaseTest.takeScreenshot();
				}

			} else
			{
				if (status.equalsIgnoreCase("on hold"))
				{
					clickElement(CommunicationRepository.CommunicationListing_detailslistingcommentbox);
					explicitwaitforvisibility(autolocator(CommunicationRepository.CommunicationListing_detailslistingmakechangestext), 20);
					String makechangeslist = getStrText(CommunicationRepository.CommunicationListing_detailslistingmakechangestext);
					if (makechangeslist.equalsIgnoreCase("Communication sent for make changes"))
					{
						BaseTest.getTest().info("Make changes comments updated");
					} else
					{
						BaseTest.getTest().fail("Make changes comments not updated");
						BaseTest.takeScreenshot();
					}
					clickElement(CommunicationRepository.CommunicationListing_detailsmakechangesclose);
				}
				clickElement(CommunicationRepository.CommunicationListing_detailslistingminusicon);
				editcomm();
				communicationPlanPageCompareAttributeValues();
				javaScriptScrollDown();
				clickNext();
				enterEmailsubwithPersonalization();
				javaScriptScrollDown();
				if (detailrow.equalsIgnoreCase(status))
				{
					requestforApprovalEmail1(audience_approver2);
				}
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Expected status: " + status + " and actual status " + detailrow + " is different");
		}
		return this;
	}

	// Select Zip file
	public CommunicationEmailChannelPage selectTemplate(String Tempalte)
	{
		pageLoaderLogo();
		try
		{
			clickElement(CommunicationRepository.Communicationauthoringpage_SearchIconClick);
			threadSleep(ObjectRepository.wait1sec);

		} catch (Throwable e)
		{
			threadSleep(ObjectRepository.wait5sec);
		}

		enterValue(CommunicationRepository.Communicationauthoringpage_SearchCommunication, Tempalte);
		threadSleep(ObjectRepository.wait2sec);

		pageLoaderLogo();

		javaScriptScrollDownToSomeExtend();
		clickElement(CommunicationRepository.Communicationauthoringpage_SearchIconClick);
		pageLoaderLogo();

		threadSleep(ObjectRepository.wait5sec);
		mouseHover(CommunicationRepository.Communicationauthoringpage_TemplateMouseover);
		threadSleep(ObjectRepository.wait2sec);
		clickElement(CommunicationRepository.Communicationauthoringpage_template_Select);
		threadSleep(ObjectRepository.wait3sec);

		pageLoaderLogo();
		threadSleep(ObjectRepository.wait3sec);
		pageLoaderLogo();

		clickElement(CommunicationRepository.Communicationauthoringpage_Email_templateBuilderSaveTemplete);
		pageLoaderLogo();
		return this;

	}

	// Select Zip file
	public CommunicationEmailChannelPage selectZip(String vzip)
	{
		threadSleep(ObjectRepository.wait3sec);

		// String zip1 = detectFilePath(BaseTest.curr_Dir + "/src\\main\\resources" + "\\Zip\\" + vzip + ".zip");
		actionsClickElement(",xpath,//div[contains(@class,'import-zip-file-tab')]");
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait3sec);
		String filePath = new File("src/main/resources/Zip/Mobile.zip").getAbsolutePath();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('input[type=file]').style.display='block';");
		WebElement fileInput = (WebElement) js.executeScript("return document.querySelector('input[type=file]');");
		fileInput.sendKeys(filePath);
		pageLoaderLogo();
		BaseTest.takeScreenshot();
//		Actions action = new Actions(driver);
//		action.keyDown(Keys.ESCAPE).keyUp(Keys.ESCAPE).build().perform();

//		js.executeScript("window.focus();");

		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).perform();

		return this;
	}

	public void selectZipUsingKeysa()
	{
		actionsClickElement(",xpath,//div[contains(@class,'import-zip-file-tab')]");
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait3sec);
		File file = new File("src/main/resources/Zip/Mobile.zip");
		String absolutePath = file.getAbsolutePath();
		// sendValue("Zip file icon,xpath,//input[@type='file']", absolutePath);

		StringSelection selection = new StringSelection(absolutePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		Robot r = null;
		try
		{
			r = new Robot();
		} catch (Exception e)
		{

		}
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait5sec);
		pageLoaderLogo();
	}

	public void selectZipUsingKeys()
	{
		// Click on the ZIP upload tab
		actionsClickElement(",xpath,//div[contains(@class,'import-zip-file-tab')]");
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait3sec);

		// Get the absolute file path
		String filePath = new File("src/main/resources/Zip/Mobile.zip").getAbsolutePath();

		// Execute JavaScript to make the file input visible (if hidden)
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('input[type=file]').style.display='block';");

		// Find the input and upload the file
		WebElement fileInput = (WebElement) js.executeScript("return document.querySelector('input[type=file]');");
		fileInput.sendKeys(filePath);

		// Wait for upload to complete
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait5sec);
		pageLoaderLogo();
		try
		{
			// Close the file dialog using xdotool
			new ProcessBuilder("bash", "-c", "xdotool key Escape").start();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public CommunicationEmailChannelPage zipFileFrameContents()
	{
		switchToFrame("iframe");
		explicitwaitforvisibility(autolocator(CommunicationRepository.communicationpage_EDM_link), 40);
		commDetails.add(getTextBoxVal(CommunicationRepository.communicationpage_EDM_link, "href"));
		switchDefault();
		return this;
	}

	// Select email schedule date
	@Override
	public CommunicationEmailChannelPage enterScheduleDate(String val)
	{
		javaScriptScrollDown();
		threadSleep(ObjectRepository.wait1sec);
		selectDate(CommunicationRepository.communicationpage_emailschedule_date, val);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		WebElement sDate = driver.findElement(By.id("EmailScheduleDate"));
		captureEmailScheduleDate = (String) jse.executeScript("return arguments[0].value", sDate);
		return this;
	}

	// To enter email subject line
	public CommunicationEmailChannelPage enterEmailsubwithPersonalization()
	{
		List<String> objStringPersona = new ArrayList<String>();
		objStringPersona.add(System.getProperty("Persona_3"));
		objStringPersona.add(System.getProperty("Persona_2"));
		javaScriptScrollIntoView("Replay mail,xpath,//input[@id = 'isReplyMailEnabled']");
		threadSleep(ObjectRepository.wait1sec);
		enterValue(CommunicationRepository.communicationpage_select_emailsub, BaseTest.getData().EmailSubjectLine + CommunicationNamE);
		clickElement(CommunicationRepository.communicationpage_emailsubject_personalize_icon);
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(",xpath,//div[@class='css-scrollbar']//div", System.getProperty("Persona_3"));
		clickElement(CommunicationRepository.communicationpage_emailsubject_personalize_icon);
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(",xpath,//div[@class='css-scrollbar']//div", System.getProperty("Persona_2"));
		clickElement(",id,rs_RSEmojiPicker_Emoji");
		WebElement ele = driver.findElement(By.xpath("//em-emoji-picker")).getShadowRoot().findElement(By.cssSelector("span.emoji-mart-emoji>span"));
		ele.click();

		clickElement(",id,rs_RSEmojiPicker_Emoji");

		String subjectLine = getTextBoxVal("Subject line input,xpath,//input[@name='subjectLine']", "value");
		emailSubjectContains = subjectLine;
		emailSubjectline = subjectLine;
		subjectlineemoji = String.valueOf(emailSubjectline.charAt(emailSubjectline.length() - 1));
		BaseTest.takeScreenshot();
		return this;
	}

	// By Abdul for Text Email - 29-09-2021
	public CommunicationEmailChannelPage enterEmailTextContentwithPersonalization()
	{
		// String emailTextContent = System.getProperty("smsContent");
		String emailTextContent = BaseTest.getData().EmailSubjectLine + "," + communicationName + ",";
		List<String> objStringPersona = new ArrayList<String>();
		objStringPersona.add(System.getProperty("Persona_1"));
		objStringPersona.add(System.getProperty("Persona_2"));
		objStringPersona.add(System.getProperty("Persona_3"));

		javaScriptScrollDownToSomeExtend();
		clickElement(CommunicationRepository.communicationpage_emailtextcontent_personalize_icon);

		threadSleep(ObjectRepository.wait3sec);
		List<WebElement> personatxt = driver.findElements(autolocator(CommunicationRepository.communicationpage_emailtextcontent_personalizelist));
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
				// emailTextContent += emailTextContent.replaceFirst("personalisation", inputtext + " | " + fallBack + ",");
				emailTextContent += inputtext + " | " + fallBack + ",";
				fallBack = null;
			}
		}
		clickElement(CommunicationRepository.communicationpage_emailtextcontent_personalize_icon);
		clickElement(CommunicationRepository.communicationpage_emailtextcontent_enterpersonalizetext);
		BaseTest.getWebDriver().switchTo().frame(0);
		WebElement frame = driver.findElement(By.tagName("body"));
		frame.clear();
		frame.sendKeys(emailTextContent);
		BaseTest.getWebDriver().switchTo().defaultContent();
		clickElement(CommunicationRepository.communicationpage_emailtextcontent_clickshorturlicon);
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_emailtextcontent_selectshourturl), 20);
		selectlistelements(CommunicationRepository.communicationpage_emailtextcontent_selectshourturl, "Smart link 1");
		return this;
	}

	public CommunicationEmailChannelPage commTextEmailPersona()
	{
		// javaScriptScrollDownToSomeExtend();
		explicitwaitforclick(autolocator("Text email,xpath,//i[contains(@class,'text-document')]"), 20);
		clickElement("Text email,xpath,//i[contains(@class,'text-document')]");
		pageLoaderLogo();
		javaScriptScrollIntoView("First line,xpath,//input[@name='inboxLinePreview']");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='k-iframe']")));
		Content = "Email text communication blast" + addTimeToName();
		enterValue("Email textbox,xpath,//div[@contenteditable]", Content);
		driver.switchTo().defaultContent();
		clickElement("Textbox persona,xpath,(//i[contains(@class,'icon-rs-editor-personalize-medium icon-md')])");
		selectlistelements(CommunicationRepository.notification_webpush_selecttitletextpersonalizationlist, "[[EmailID]]");
		clickElement("Textbox persona,xpath,(//i[contains(@class,'icon-rs-editor-personalize-medium icon-md')])");
		selectlistelements(CommunicationRepository.notification_webpush_selecttitletextpersonalizationlist, "[[MobileNo]]");
		clickElement("Textbox smartlink,xpath,//i[contains(@class,'icon-rs-editor-smart-link')]");
		explicitwaitforclick(autolocator("Smartlink 1,xpath,//a[normalize-space()='Smart link 1']"), 20);
		clickElement("Smartlink 1,xpath,//a[normalize-space()='Smart link 1']");
		threadSleep(ObjectRepository.wait5sec);

		BaseTest.takeScreenshot();
		return this;
	}

	public CommunicationEmailChannelPage commTextEmailinboxpreview()
	{
		javaScriptScrollUpToSomeExtend();
		enterValue(CommunicationRepository.Communication_Email_inboxPreview, communicationName);
		javaScriptScrollDownToSomeExtend();
		BaseTest.takeScreenshot();

		return this;
	}

	public CommunicationEmailChannelPage commTextEmailPersonaforeventtrigger()
	{
		// javaScriptScrollDownToSomeExtend();
		explicitwaitforclick(autolocator("Text email,xpath,//i[contains(@class,'text-document')]"), 20);
		clickElement("Text email,xpath,//i[contains(@class,'text-document')]");
		pageLoaderLogo();
		javaScriptScrollIntoView("First line,xpath,//input[@name='inboxLinePreview']");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='k-iframe']")));
		enterValue("Email textbox,xpath,//div[@contenteditable]", "Email text communication blast" + addTimeToName());
		driver.switchTo().defaultContent();
		explicitwaitforclick(autolocator("Textbox persona,xpath,(//i[contains(@class,'user-question-mark')])[3]"), 30);
		clickElement("Textbox persona,xpath,(//i[contains(@class,'user-question-mark')])[3]");
		selectlistelements(CommunicationRepository.notification_webpush_selecttitletextpersonalizationlist, "[[EmailID]]");
		clickElement("Textbox persona,xpath,(//i[contains(@class,'user-question-mark')])[3]");
		selectlistelements(CommunicationRepository.notification_webpush_selecttitletextpersonalizationlist, "[[MobileNo]]");
		clickElement("Textbox smartlink,xpath,//i[@title='SmartLink']");
		explicitwaitforclick(autolocator("Smartlink 1,xpath,//a[normalize-space()='Smart link 1']"), 20);
		clickElement("Smartlink 1,xpath,//a[normalize-space()='Smart link 1']");
		threadSleep(ObjectRepository.wait5sec);
		clickElement(",xpath,//i[contains(@class,'icon-rs-image-m')]");
		clickElement(",xpath,//a[.='Image URL']");
		enterValue(",xpath,//div[@class='rsmdc-body false Xcss-scrollbar modal-min-height modal-body']//input)[1]", "test photo");
		enterValue(",xpath,//div[@class='rsmdc-body false Xcss-scrollbar modal-min-height modal-body']//input)[5]", "https://www.gartner.com/pi/vendorimages/postman_full-life-cycle-api-management_1633960356020.png");
		clickElement(",xpath,//div[@class='rsmdc-body false Xcss-scrollbar modal-min-height modal-body']//following::button[.='Save']");
		threadSleep(ObjectRepository.wait5sec);
		clickElement(",xpath,//i[@title='Coupon code']");
		pageLoaderLogo();
		clickElement(",xpath,//span//span[.='Common']");
		clickElement(",xpath,(//span[contains(@class,'k-dropdownlist k-picker rs-kendo-dropdown rs')])[1]");
		selectlistelements(",xpath,//div[contains(@class,'k-popup k-list-container')]//li", "EMI");
		pageLoaderLogo();
		clickElement(",xpath,(//span[contains(@class,'k-dropdownlist k-picker rs-kendo-dropdown rs')])[2]");

		selectlistelements(",xpath,//div[contains(@class,'k-popup k-list-container')]//li", "testautomation");
		pageLoaderLogo();
		clickElement(",xpath,(//button[.='Save'])[2]");
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait5sec);

		clickElement(",xpath,//i[@title='Coupon code']");
		pageLoaderLogo();
		clickElement(",xpath,//span//span[.='Unique']");
		clickElement(",xpath,(//span[contains(@class,'k-dropdownlist k-picker rs-kendo-dropdown rs')])[1]");
		selectlistelements(",xpath,//div[contains(@class,'k-popup k-list-container')]//li", "EMI");
		pageLoaderLogo();
		clickElement(",xpath,(//span[contains(@class,'k-dropdownlist k-picker rs-kendo-dropdown rs')])[2]");

		selectlistelements(",xpath,//div[contains(@class,'k-popup k-list-container')]//li", "testautomation");
		pageLoaderLogo();
		clickElement(",xpath,(//button[.='Save'])[2]");
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait5sec);

		BaseTest.takeScreenshot();
		return this;
	}

	public CommunicationEmailChannelPage commTextEmaillivePreview()
	{
		pageLoaderLogo();
		clickElement(",id,rs_SplitABTab_Emailpreview");

		String previewbox = getStrText("live preview,xpath,//div[@class='pe-none']//p");
		if (previewbox.contains(Content))
		{
			BaseTest.getTest().log(Status.PASS, "Live Preview Content is same as given Text content");

		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Live Preview Content is not same as given Text content");

		}
		BaseTest.takeScreenshot();

		clickElement(",id,rs_RSAdvanceSearch_zoom");
		enterValue(",xpath,//input[@id='search']", "qaautores07@resulticksmail.com");
		clickElement(",id,rs_data_zoom");
		threadSleep(ObjectRepository.wait5sec);

		pageLoaderLogo();
		threadSleep(ObjectRepository.wait5sec);

		clickElement(",xpath,//button[.='Send to me']");

		return this;
	}

	// Insert Hyperlink, Insert Image, formats
	public CommunicationEmailChannelPage textContentFormat(String val)
	{
		driver.findElement(autolocator(CommunicationRepository.communicationpage_emailtextcontent_enterpersonalizetext)).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.CONTROL));
		String formatValue = val.substring(0, 1).toUpperCase() + val.substring(1).toLowerCase();
		clickElement("formatValue,xpath, //span[contains(.,'" + formatValue + "')]");
		BaseTest.takeScreenshot();
		return this;
	}

	public CommunicationEmailChannelPage textEmailInsertHyperlink()
	{
		clickElement(CommunicationRepository.communicationpage_emailtextcontent_clickhyperlinkicon);
		enterValue(CommunicationRepository.communicationpage_emailtextcontent_enterhyperlinkwebaddress, BaseTest.getData().HyperlinkWebAddress);
		enterValue(CommunicationRepository.communicationpage_emailtextcontent_enterhyperlinktext, BaseTest.getData().HyperlinkText);
		enterValue(CommunicationRepository.communicationpage_emailtextcontent_enterhyperlinktooltip, BaseTest.getData().HyperlinkText);
		clickElement(CommunicationRepository.communicationpage_emailtextcontent_clickopenlinkcheckbox);
		clickElement(CommunicationRepository.communicationpage_emailtextcontent_clickinsertbutton);
		BaseTest.takeScreenshot();
		return this;
	}

	public CommunicationEmailChannelPage textEmailInsertImage()
	{
		clickElement(CommunicationRepository.communicationpage_emailtextcontent_clickinsertimageicon);
		enterValue(CommunicationRepository.communicationpage_emailtextcontent_clickinsertimagewebaddress, BaseTest.getData().HyperlinkWebAddress);
		enterValue(CommunicationRepository.communicationpage_emailtextcontent_clickinsertimagetext, BaseTest.getData().HyperlinkText);
		enterValue(CommunicationRepository.communicationpage_emailtextcontent_clickinsertimageheight, "50");
		enterValue(CommunicationRepository.communicationpage_emailtextcontent_clickinsertimagewidth, "50");
		clickElement(CommunicationRepository.communicationpage_emailtextcontent_clickinsertbutton);
		BaseTest.takeScreenshot();
		return this;
	}

	public CommunicationEmailChannelPage enterEmailsenderNamewithPersonalization()
	{

		String subjectLine = communicationName + ",";
		emailSubjectContains = subjectLine;
		List<String> objStringPersona = new ArrayList<String>();
		objStringPersona.add(System.getProperty("Persona_1"));
		// objStringPersona.add(System.getProperty("Persona_2"));
		// objStringPersona.add(System.getProperty("Persona_3"));
		// objStringPersona.add(System.getProperty("Persona_4"));
		javaScriptScrollIntoView(CommunicationRepository.communicationpage_email_senderName_personalizeicon);
		javaScriptScrollUpToSomeExtend();
		clickElement(CommunicationRepository.communicationpage_email_senderName_personalizeicon);
		threadSleep(ObjectRepository.wait3sec);
		List<WebElement> personatxt = driver.findElements(autolocator(CommunicationRepository.communicationpage_email_senderName_personalizelist));
		for (WebElement allele : personatxt)
		{
			String inputtext = allele.getText();
			if (objStringPersona.contains(inputtext))
			{
				String fallBack = allele.findElement(By.tagName("a")).getAttribute("class").toString();
				if (fallBack.isEmpty() || fallBack.equals("") || fallBack == null)
				{
					fallBack = "[[No Data]]";
				}
				subjectLine += inputtext + " | " + fallBack;
				fallBack = null;
			}
		}
		clickElement(CommunicationRepository.communicationpage_email_senderName_personalizeicon);
		// enterValue(CommunicationRepository.communicationpage_email_fname, subjectLine);
		emailSubjectline = subjectLine;
		return this;
	}

	// email click import
	public CommunicationEmailChannelPage clickImport()
	{
		threadSleep(ObjectRepository.wait2sec);
		if (isEnabled(CommunicationRepository.email_clickimport))
		{
			clickElement(CommunicationRepository.email_clickimport);
		} else
		{
			clickElement(CommunicationRepository.communicationemail_commrefresh);
			threadSleep(ObjectRepository.wait1sec);
			clickElement(CommunicationRepository.communicationemail_refresh_ok);
			explicitwaitforclick(autolocator(CommunicationRepository.email_clickimport), 30);
			clickElement(CommunicationRepository.email_clickimport);
		}
		// clickElement(ObjectRepository.email_clickimportzip);
		return this;
	}

	public void importEdm()
	{

	}

	// email click import
	public CommunicationEmailChannelPage clicktemplate()
	{
		threadSleep(ObjectRepository.wait3sec);
		if (isEnabled(CommunicationRepository.email_clicktemplate))
		{
			clickElement(CommunicationRepository.email_clicktemplate);
		} else
		{
			clickElement(CommunicationRepository.communicationemail_commrefresh);
			threadSleep(ObjectRepository.wait1sec);
			clickElement(CommunicationRepository.communicationemail_refresh_ok);
			explicitwaitforclick(autolocator(CommunicationRepository.email_clicktemplate), 30);
			clickElement(CommunicationRepository.email_clicktemplate);
		}
		// clickElement(ObjectRepository.email_clickimportzip);
		return this;
	}

	// Click email channel next
	public CommunicationEmailChannelPage clickNextemail()
	{
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_select_emailcommunicationnext), 10);
		clickElement(CommunicationRepository.communicationpage_select_emailcommunicationnext);
		pageLoaderLogo();
		return this;

	}

	// click save in authouring page
	public CommunicationEmailChannelPage clickSaveEmail()
	{
		threadSleep(ObjectRepository.wait20sec);
		explicitwaitforclick(autolocator("Save,xpath,//button[.='Save']"), 10);
		clickElement("Save,xpath,//button[.='Save']");
		pageLoaderLogo();
		return this;
	}

	public boolean checkEmailScheduleTimeError(String val)
	{
		boolean erroemsg = false;
		try
		{
			explicitwaitforvisibility(autolocator(CommunicationRepository.communicationpage_email_dateTimeErr), 10);
			enterScheduleDate(val);
			erroemsg = true;
		} catch (Exception e)
		{
			BaseTest.getTest().log(Status.INFO, "Schedule date and time error message not present, selected future time");
		}
		return erroemsg;
	}

	public void clickAgainDaterange(int startDate)
	{
		if (isElementPresent("Validation message,xpath,//div[@class='validation-message'][contains(.,'later than 15')]"))
		{
			enterEmailScheduleTime(startDate);
			clickNextemail();
			pageLoaderLogo();
		}
	}

	// New Added
	// Inbox first line message To enter Inbox first line
	public CommunicationEmailChannelPage enterInboxMessage()
	{
		javaScriptScrollDownToSomeExtend();
		explicitwaitforpresence(autolocator(CommunicationRepository.communication_email_inboxfirstlinemessage), 30);
		enterValue(CommunicationRepository.communication_email_inboxfirstlinemessage, communicationName);
		return this;
	}

	// Unsubscribe Message
	public CommunicationEmailChannelPage emailunsubscribeselect()
	{
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait3sec);
		javaScriptScrollDown();
		driver.switchTo().defaultContent();
		threadSleep(ObjectRepository.wait3sec);
		clickElement(CommunicationRepository.communication_email_unsubchkbox);
		threadSleep(ObjectRepository.wait1sec);
		clickElement(CommunicationRepository.communication_email_unsubselect);
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_communicationtype_listbox), 30);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, BaseTest.getData().Unsubcribe);
		return this;
	}

	// Footer Message
	public CommunicationEmailChannelPage emailFooter()
	{
		threadSleep(ObjectRepository.wait2sec);
		if (!isSelected(CommunicationRepository.communicationpage_email_footer))
		{
			clickElement(CommunicationRepository.communicationpage_email_footer);
		}
		javaScriptScrollDown();
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_email_eventfooteraddress), 20);
		threadSleep(ObjectRepository.wait1sec);
		javaScriptScrollUpToSomeExtend();

		clickElement(CommunicationRepository.communicationpage_email_eventfooteraddress);
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(CommunicationRepository.communication_EventTrigger_footermsg, BaseTest.getData().Footer);
		return this;
	}

	// Footer Message
	public CommunicationEmailChannelPage EamilROI()
	{
		pageLoaderLogo();
		javaScriptScrollDown();
		threadSleep(ObjectRepository.wait3sec);
		pageLoaderLogo();

		enterValue(CommunicationRepository.Communication_ROI, "50");
		clickElement(CommunicationRepository.Communication_ROI_reach);

		enterValue(CommunicationRepository.Communication_ROI_reach, "50");
		tabAction();
		String Expectedvalue = getTextBoxVal(CommunicationRepository.Communication_ROI_expected, "value");
		BaseTest.getTest().log(Status.INFO, "Expected ROI value   ---> <b>" + Expectedvalue + "</b>");
		clickElement(",id,rs_ROIContent_Next");

		return this;
	}

	// Select Time zone
	public CommunicationEmailChannelPage emailtimezone()
	{
		javaScriptScrollDownToSomeExtend();
		threadSleep(ObjectRepository.wait1sec);
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_emailtimezoneicon), 10);
		clickElement(CommunicationRepository.communicationpage_emailtimezoneicon);

		if (!isElementPresent(CommunicationRepository.communicationpage_emailschedule_emailtimezonelist))
		{
			clickElement(CommunicationRepository.communicationpage_emailtimezoneicon);
			threadSleep(ObjectRepository.wait3sec);
		}
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_emailschedule_emailtimezonelist), 10);
		clickElement(CommunicationRepository.communicationpage_emailschedule_emailtimezonelist);
		threadSleep(ObjectRepository.wait1sec);
		selectlistelementsAndProceed(CommunicationRepository.communicationpage_communicationtype_listbox, BaseTest.getData().TimeZone);
		return this;
	}

	// Test Email Communication

	public boolean testmail(String testMailId)
	{
		boolean successmessage = false;
		String sendButton = getTextBoxVal(CommunicationRepository.communicationpage_email_sendTestEmailSend, "class");

		clickElement(CommunicationRepository.communicationpage_email_sendTestEmailTo);
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Enter new email");
		enterValue(CommunicationRepository.communicationpage_email_sendnewmailid, testMailId);
		clickElement(CommunicationRepository.communicationpage_email_sendTestEmailSend);
		try
		{
			pageLoaderLogo();

			if (getStrText(",xpath,//div[@class='mt10']").equalsIgnoreCase("Test communication will be sent shortly."))
			{
				successmessage = true;
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
		try
		{
			clickElement("Popupclose,xpath,//i[contains(@id,'circle_close_edge')]");
		} catch (Exception e)
		{
			threadSleep(ObjectRepository.wait10sec);
		}
		clickElement("Save button,xpath,//button[contains(@id,'Email_Save')]");
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait2sec);
		if (isDisplayed("Save button,xpath,//button[.='Save']"))
		{
			clickElement("Save button,xpath,//button[.='Save']");

		} else
		{
			BaseTest.getTest().log(Status.PASS, "Communication Is Event trigger Type");

		}

		pageLoaderLogo();
		threadSleep(ObjectRepository.wait10sec);
		return successmessage;
	}
	// Test Email Communication

	public boolean testmailEventTrigger(String testMailId)
	{
		boolean successmessage = false;
		String sendButton = getTextBoxVal(CommunicationRepository.communicationpage_email_sendTestEmailSend, "class");

		clickElement(CommunicationRepository.communicationpage_email_sendTestEmailTo);
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Enter new email");
		enterValue(CommunicationRepository.communicationpage_email_sendnewmailid, testMailId);
		clickElement(CommunicationRepository.communicationpage_email_sendTestEmailSend);
		try
		{
			pageLoaderLogo();

			if (getStrText(",xpath,//div[@class='mt10']").equalsIgnoreCase("Test communication will be sent shortly"))
			{
				successmessage = true;
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
		try
		{
			clickElement("Popupclose,xpath,//i[contains(@id,'circle_close_edge')]");
		} catch (Exception e)
		{
			threadSleep(ObjectRepository.wait10sec);
		}
		clickElement("Save button,xpath,//button[contains(@id,'Email_Save')]");
		pageLoaderLogo();

		threadSleep(ObjectRepository.wait10sec);
		return successmessage;
	}

	public CommunicationEmailChannelPage enterEmailScheduleTime(int day)
	{
		threadSleep(ObjectRepository.wait3sec);
		// try
		// {
		// if (driver.findElement(By.xpath("//i[contains(@class,'close-mini')]")).isDisplayed())
		// {
		// clickElement("Close date,xpath,//i[contains(@class,'close-mini')]");
		// threadSleep(ObjectRepository.wait2sec);
		// }
		// } catch (Exception e)
		// {
		// System.out.println(e);
		// }
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_emailschedule_time), 30);
		clickElement(CommunicationRepository.communicationpage_emailschedule_time);
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_emailschedule_datepopupactive), 30);
		String scheduleformat = calendarSchedduleDate(day, "MMMM d, yyy");
		javaScriptScrollDown();
		threadSleep(ObjectRepository.wait2sec);
		clickElement("schedule time,xpath,//td[contains(@title,'" + scheduleformat + "')]//span");
		javaScriptScrollDown();
		clickElement(CommunicationRepository.communicationpage_emailschedule_calendar_TimehoursSelect);
		threadSleep(ObjectRepository.wait1sec);
		clickElement(CommunicationRepository.communicationpage_emailschedule_calendar_TimeminsSelect);
		threadSleep(ObjectRepository.wait1sec);
		clickElement(CommunicationRepository.communicationpage_emailschedule_calendar_Timeset);
		threadSleep(ObjectRepository.wait2sec);
		BaseTest.takeScreenshot();
		return this;
	}

	// To reschedule communication after getting later than 15 mins error
	public void reschedule(int day)
	{

		if (isElementPresent("Validation message,xpath,//div[@class='validation-message'][contains(.,'later than 15')]"))
		{
			enterEmailScheduleTime(day);
			clickNextemail();
			pageLoaderLogo();
		}

	}

	// Email channel save
	public CommunicationEmailChannelPage clickemailsave()
	{
		javaScriptScrollIntoView(CommunicationRepository.communicationpage_email_save);
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_email_save), 50);
		clickElement(CommunicationRepository.communicationpage_email_save);
		return this;
	}

	// Draft save
	public CommunicationEmailChannelPage emailDraftConfirm()
	{
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_email_draftsave_ok), 30);
		clickElement(CommunicationRepository.communicationpage_email_draftsave_ok);
		return this;
	}

	// Email RFA
	public CommunicationEmailChannelPage requestforApprovalEmail1(String approveMailId)
	{
		clickElement(CommunicationRepository.communicationpage_email_requestapprovecheckbox);
		clickElement(CommunicationRepository.communicationpage_email_sendTestEmailTo);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, "Enter new email");
		enterValue(CommunicationRepository.communicationpage_email_approver_sendnewmailid, approveMailId);
		threadSleep(ObjectRepository.wait3sec);
//		if (!isSelected(CommunicationRepository.communicationpage_email_requestapprovecheckbox))
//		{
//			clickElement(CommunicationRepository.communicationpage_email_requestapprovecheckbox);
//		}
		threadSleep(ObjectRepository.wait3sec);
		clickElement(CommunicationRepository.communicationpage_email_sendTestEmailSendBtn);
		threadSleep(ObjectRepository.wait30sec);
		return this;
	}

	// Reply Mail
	public CommunicationEmailChannelPage replyMail()
	{
		threadSleep(ObjectRepository.wait1sec);
		if (isSelected(CommunicationRepository.communicationpage_email_replycheckbox))
		{
			clickElement(CommunicationRepository.communicationpage_email_replycheckbox);
			clickElement(CommunicationRepository.communicationpage_email_replyemail);
			threadSleep(ObjectRepository.wait1sec);
			selectlistelements(CommunicationRepository.communicationpage_email_selectreplymail, "Enter new email here");
			enterValue(CommunicationRepository.communicationpage_email_enterreplymail, System.getProperty("ReplyMailId"));
		} else
		{
			clickElement(CommunicationRepository.communicationpage_email_replyemail);
			threadSleep(ObjectRepository.wait1sec);
			selectlistelements(CommunicationRepository.communicationpage_email_selectreplymail, "Enter new email here");
			enterValue(CommunicationRepository.communicationpage_email_enterreplymail, System.getProperty("ReplyMailId"));
		}

		return this;
	}

	// Split AB functions Abdul
	public CommunicationEmailChannelPage splitEmailON(String splitType)
	{
		tabAction();
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_EmailSplitON), 30);
		javaScriptScrollDownToSomeExtend();
		threadSleep(ObjectRepository.wait3sec);
		WebElement element = driver.findElement(By.cssSelector("span[class*='k-switch k-swit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait3sec);
		javaScriptScrollDownToSomeExtend();

		for (int count = 2; count < splitType.length(); count++)
		{
			explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_Email_split_addBtn), 30);
			clickElement(CommunicationRepository.communicationpage_Email_split_addBtn);
			threadSleep(ObjectRepository.wait3sec);
		}
		clickElement(CommunicationRepository.communicationpage_EmailsplitABDownarrow);
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

	public CommunicationEmailChannelPage splitAutoScheduleOffValidate()
	{
		threadSleep(ObjectRepository.wait3sec);

		javaScriptScrolltoTop();
		javascriptdoublescrolldown();
		explicitwaitforclick(autolocator(CommunicationRepository.email_split_autoschedulesettingsIcon), 60);
		clickElement(CommunicationRepository.email_split_autoschedulesettingsIcon);
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

	private CommunicationEmailChannelPage selectSplitZip(String splitType, String vzip)
	{
		String zip1 = System.getProperty("user.dir") + "/src\\main\\resources" + "\\Zip\\" + vzip + ".zip";
		sendValue("Zip,id,fileuploadHTML" + splitType, zip1);
		threadSleep(ObjectRepository.wait3sec);
		return this;
	}

	private CommunicationEmailChannelPage enterEmailSplitsubWithPersonalization(String whichSplitCaps, String sub)

	{
		String subjectLine = sub + ",";
		List<String> objStringPersona = new ArrayList<String>();
		objStringPersona.add(System.getProperty("Persona_1"));
		objStringPersona.add(System.getProperty("Persona_2"));
		objStringPersona.add(System.getProperty("Persona_3"));
		objStringPersona.add(System.getProperty("Persona_4"));
		// objStringPersona.add(camp.Persona_5);
		// objStringPersona.add(camp.Persona_6);
		// javaScriptScrollIntoView(",xpath,//*[@id='EmailSchedulePanel']/h5");
		String personaliseIcon = "Split personalization,xpath,//*[@id='lisplit" + whichSplitCaps + "']//div[@id='SubjectPersonalize']/a/i[1]";
		String persinaliselist = "Split personalization list,xpath,//div[contains(@class,'subjectContainer" + whichSplitCaps + "')]//div[@id='SubjectPersonalize']/ul/li";
		clickElement(personaliseIcon);
		threadSleep(ObjectRepository.wait3sec);
		List<WebElement> personatxt = driver.findElements(autolocator(persinaliselist));
		for (WebElement allele : personatxt)
		{
			String inputtext = allele.getText();
			if (objStringPersona.contains(inputtext))
			{

				String fallBack = allele.findElement(By.tagName("a")).getAttribute("class").toString();
				if (fallBack.isEmpty() || fallBack.equals("") || fallBack == null)
				{
					fallBack = "[[No Data]]";
				}
				subjectLine += inputtext + " | " + fallBack + ",";
				// driver.findElement(By.xpath("//*[@placeholder='Mail subject
				// line']")).clear();
				fallBack = null;
			}
		}
		clickElement(personaliseIcon);
		enterValue("Split-" + whichSplitCaps + " subject Line :" + ",xpath,//input[@id='EmailSubject" + whichSplitCaps + "']/../div", subjectLine);
		emailSubjectline = null;
		emailSubjectline = subjectLine;
		return this;
	}

	public CommunicationEmailChannelPage splitDetails(String selectedSplitCaps, String subject, String zip)
	{
		javaScriptScrollIntoView(CommunicationRepository.communicationpage_email_receip_click);
		clickElement("Split-" + selectedSplitCaps + "," + "xpath,//span[.='Split " + selectedSplitCaps + "']");
		List<String> objStringPersona = new ArrayList<String>();
		objStringPersona.add(System.getProperty("Persona_3"));
		objStringPersona.add(System.getProperty("Persona_2"));
		javaScriptScrollIntoView("Replay mail,xpath,//input[@id = 'isReplyMailEnabled']");
		threadSleep(ObjectRepository.wait2sec);
		enterValue(",xpath,//input[@name='split" + selectedSplitCaps + ".subjectLine']", communicationName + addTimeToName());
		clickElement(CommunicationRepository.communicationpage_emailsubject_personalize_icon);
		threadSleep(ObjectRepository.wait3sec);
		selectlistelements(",xpath,//div[@class='css-scrollbar']//div", System.getProperty("Persona_3"));
		clickElement(CommunicationRepository.communicationpage_emailsubject_personalize_icon);
		threadSleep(ObjectRepository.wait3sec);
		selectlistelements(",xpath,//div[@class='css-scrollbar']//div", System.getProperty("Persona_2"));
		clickElement(",id,rs_RSEmojiPicker_Emoji");
		WebElement ele = driver.findElement(By.xpath("//em-emoji-picker")).getShadowRoot().findElement(By.cssSelector("span.emoji-mart-emoji>span"));
		ele.click();

		clickElement(",id,rs_RSEmojiPicker_Emoji");

		BaseTest.takeScreenshot();
		// clickImport().selectZip(BaseTest.getData().ZipName);
		clickImport();
		// comm.selectZip(BaseTest.getData().ZipName);
		selectZipUsingKeys();
		BaseTest.takeScreenshot();
		javaScriptScrollDown();
		splitAddFooterUnsub(selectedSplitCaps);
		return this;
	}

	private CommunicationEmailChannelPage splitAddFooterUnsub(String selectedSplitCaps)
	{
		threadSleep(ObjectRepository.wait3sec);
		javaScriptScrollDown();
		threadSleep(ObjectRepository.wait3sec);

		if (!isSelected(",xpath,(//input[@id='split" + selectedSplitCaps + ".emailFooter'])[1]"))
		{
			clickElement(",xpath,(//input[@id='split" + selectedSplitCaps + ".emailFooter'])[1]");
		}
		javaScriptScrollDown();
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_email_eventfooteraddress), 20);
		clickElement(CommunicationRepository.communicationpage_email_eventfooteraddress);
		threadSleep(ObjectRepository.wait3sec);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().Footer);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait10sec);
		javaScriptScrollDown();
		driver.switchTo().defaultContent();
		clickElement(CommunicationRepository.communication_email_unsubchkbox);
		threadSleep(ObjectRepository.wait1sec);
		clickElement(CommunicationRepository.communication_email_unsubselect);
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_communicationtype_listbox), 30);
		selectlistelements(CommunicationRepository.communicationpage_communicationtype_listbox, BaseTest.getData().Unsubcribe);
		BaseTest.takeScreenshot();
		return this;
	}

	public CommunicationEmailChannelPage enterSplitScheduleDate(String splitType)
	{
		int startDate = 0;
		int endDate = 3;
		String min = splitType.equals("A") ? "1" : splitType.equals("B") ? "2" : splitType.equals("C") ? "3" : splitType.equals("D") ? "4" : "";
		emailtimezone();
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_emailschedule_time), 30);
		clickElement(CommunicationRepository.communicationpage_emailschedule_time);
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_emailschedule_datepopupactive), 30);
		String scheduleformat = calendarSchedduleDate(startDate, "MMMM d, yyy");
		javaScriptScrollDown();
		threadSleep(ObjectRepository.wait10sec);
		clickElement("schedule time,xpath,//td[contains(@title,'" + scheduleformat + "')]//span");
		javaScriptScrollDown();
		try
		{
			clickElement(CommunicationRepository.communicationpage_emailschedule_calendar_TimehoursSelect);
			threadSleep(ObjectRepository.wait5sec);
			clickElement("schedule mins select,xpath,//span[text()='minute']/..//li[position()=" + min + "]");
		} catch (Exception e)
		{
			threadSleep(ObjectRepository.wait3sec);
			clickElement(CommunicationRepository.communicationpage_emailschedule_calendar_TimehoursSelect2);
			threadSleep(ObjectRepository.wait3sec);
			clickElement("schedule mins select,xpath,//span[text()='minute']/..//li[position()=1]");

		}

		threadSleep(ObjectRepository.wait3sec);
		clickElement(CommunicationRepository.communicationpage_emailschedule_calendar_Timeset);
		threadSleep(ObjectRepository.wait2sec);
		BaseTest.takeScreenshot();
		javaScriptScrollDown();
//		threadSleep(ObjectRepository.wait1sec);
//		selectDate("SplitEmailScheduleDate,xpath,//span[@aria-controls='EmailScheduleDate" + splitType + "_dateview']/i", val);
		return this;
	}

	public void RfaEmailApproversSelect(int countOfApprover)
	{
		clickElement(CommunicationRepository.communicationpage_email_rfamaillistbox1);
		selectlistelements(CommunicationRepository.communicationpage_email_selectrfamaillist1, "Enter new email here");
		sendValue(",id,newEmailAddressApproval", audience_approver1);
		clickElement(CommunicationRepository.communicationpage_email_requestapprovecheckbox);
		if (countOfApprover >= 2)
		{
			clickElement(CommunicationRepository.communicationpage_rfa_addrfamailsicon);
			clickElement(CommunicationRepository.communicationpage_email_rfamaillistbox2);
			selectlistelements(CommunicationRepository.communicationpage_email_selectrfamaillist2, "Enter new email here");
			sendValue(",id,newEmailAddressApproval2", audience_approver2);
		}
		if (countOfApprover >= 3)
		{
			clickElement(CommunicationRepository.communicationpage_rfa_addrfamailsicon);
			clickElement(CommunicationRepository.communicationpage_email_rfamaillistbox3);
			selectlistelements(CommunicationRepository.communicationpage_email_selectrfamaillist3, "Enter new email here");
			sendValue(",id,newEmailAddressApproval3", audience_approver3);
		}
	}

	public CommunicationListingPage emailRfaAllCondition(Boolean ishierarchyon)
	{
		clickElement(CommunicationRepository.communicationpage_rfa_settingsicon);
		if (!isSelected(CommunicationRepository.communicationpage_rfa_allconditionbutton))
		{
			clickElement(CommunicationRepository.communicationpage_rfa_allconditionbutton);
		}
		if (ishierarchyon)
		{
			clickElement(CommunicationRepository.communicationpage_rfa_clickhierarchyswitch);
			BaseTest.getTest().log(Status.INFO, "Click on rfa app settings icon, selected All condition with heirarchy ON and save");
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Click on rfa app settings icon, selected All condition with heirarchy OFF and save");
		}
		clickElement(CommunicationRepository.communicationpage_rfa_settingssave);
		return this;
	}

	public CommunicationListingPage emailRfaAnyCondition(int anyConditionCount)
	{
		String count = Integer.toString(anyConditionCount);
		clickElement(CommunicationRepository.communicationpage_rfa_settingsicon);
		if (!isSelected(CommunicationRepository.communicationpage_rfa_anyconditionbutton))
		{
			clickElement(CommunicationRepository.communicationpage_rfa_anyconditionbutton);
			clickElement(CommunicationRepository.communicationpage_rfa_clickanyconddropdown);
			selectlistelements(CommunicationRepository.communicationpage_rfa_selectanycondvalue, count);
		}
		clickElement(CommunicationRepository.communicationpage_rfa_settingssave);
		return this;
	}

	public CommunicationListingPage emailRfaMandateSelect(String Mandateselect)
	{
		String[] mandate = Mandateselect.split(",");
		for (String mcount : mandate)
		{
			threadSleep(ObjectRepository.wait1sec);
			clickElement("Mandate select,xpath,//i[@id='iredstar" + mcount + "']");
			BaseTest.takeScreenshot();
		}

		return this;
	}

	public CommunicationEmailChannelPage emailAddlinkClickandVerify()
	{
		javaScriptScrollIntoView(CommunicationRepository.communicationpage_email_replycheckbox);
		clickElement(CommunicationRepository.communicationpage_recipientaddicon);
		if (!isDisplayed(CommunicationRepository.communicationpage_recipientpage))
		{
			BaseTest.getTest().fail("On clicking recipient add icon in communication page, it failed to navigate to Recipient page");
		}
		driver.navigate().back();
		javaScriptScrollIntoView(audience_approver1);
		clickElement(CommunicationRepository.communicationpage_footerlinkicon);
		if (!isDisplayed(CommunicationRepository.communicationpage_settingslinkpage))
		{
			BaseTest.getTest().fail("On clicking emailfooter add icon in communication page, it failed to navigate to communication settings page");
		}
		driver.navigate().back();
		return this;
	}

	//////////////////////// ***** Communication Voice *****////////////////////////

	// Voice Target List
	public CommunicationEmailChannelPage callCenterRecipient()
	{

		clickElement(CommunicationRepository.communication_voice_clickcallcentertargetlist);
		sendValue(CommunicationRepository.communication_voice_clickcallcentertargetlist, BaseTest.getData().TargetListNew);
		if (!selectlistelementsAndProceed(CommunicationRepository.communication_voice_selectcallcentertargetlist, BaseTest.getData().TargetListNew))
		{
			enterValue(CommunicationRepository.communication_voice_clickcallcentertargetlist, BaseTest.getData().TargetListOld);
			selectlistelements(CommunicationRepository.communication_voice_selectcallcentertargetlist, BaseTest.getData().TargetListOld);
		}
		return this;
	}

	// Voice Content
	public CommunicationEmailChannelPage enterCallCenterContent()
	{
		String callCenterSubject = BaseTest.getData().EmailSubjectLine + "," + communicationName;
		enterValue(CommunicationRepository.communication_voice_entercontent, callCenterSubject);
		return this;
	}

	// Voice Scheduled Date
	public CommunicationEmailChannelPage enterCallCenterScheduleDate(String val)
	{
		javaScriptScrollDown();
		threadSleep(ObjectRepository.wait1sec);
		selectDate(CommunicationRepository.communication_voice_enterscheduledate, val);
		return this;
	}

	public CommunicationEmailChannelPage enterCallCenterScheduleTime()
	{
		explicitwaitforclick(autolocator(CommunicationRepository.communication_voice_clickscheduletime), 30);
		clickElement(CommunicationRepository.communication_voice_clickscheduletime);
		explicitwaitforclick(autolocator(CommunicationRepository.communication_voice_enterscheduletime), 30);
		clickElement(CommunicationRepository.communication_voice_enterscheduletime);
		return this;
	}

	public CommunicationEmailChannelPage enterCallCenterTimeZone()
	{
		String timezone = BaseTest.getData().TimeZone;
		threadSleep(ObjectRepository.wait1sec);
		explicitwaitforclick(autolocator(CommunicationRepository.communication_voice_clicktimezoneicon), 10);
		clickElement(CommunicationRepository.communication_voice_clicktimezoneicon);
		explicitwaitforclick(autolocator(CommunicationRepository.communication_voice_clicktimezonedropdown), 10);
		clickElement(CommunicationRepository.communication_voice_clicktimezonedropdown);
		threadSleep(ObjectRepository.wait1sec);
		WebElement element = driver.findElement(autolocator("TimeZone list,xpath,//*[@id='CallCenterTimeZone_listbox']/li[@title='" + timezone + "']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		return this;
	}

	// Save Voice Communication
	public CommunicationEmailChannelPage callCenterSaveCommunication()
	{
		clickElement(CommunicationRepository.communication_voice_savevoicecommunication);
		return this;
	}

	// Communication Email Database
	// ##############################################Mastan################

	public void testEmailCommDB(String commName1)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("TEST EMAIL DB VALIDATION", ExtentColor.BLUE));
		campDetails = getdbQueryResults(dburl_campaign + campdbname, campaigndb_userName, campaigndb_password, qEmailCampDetails(communicationName));
		if (!campDetails.isEmpty())
		{
			for (Map<String, String> camprow : campDetails)
			{
				campaignId = camprow.get("CampaignID");
				campGUID1 = camprow.get("CampaignGUID");
				campBlastScheduleGUID = camprow.get("BlastScheduleGuid");
				BaseTest.getTest().log(Status.INFO, mapToString(camprow));
				String isTestCamp = camprow.get("IsTestCampaign");
				if (isTestCamp.contains("true"))
				{
					BaseTest.getTest().info("This communication marked as Test communication");
				} else
				{
					BaseTest.getTest().fail("This communication is not marked as Test communication");
				}
			}
		}
	}

	public void emailCommDBValidation()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("COMMUNICATION DB EMAIL CHANNEL DETAILS", ExtentColor.BLUE));
		threadSleep(ObjectRepository.wait20sec);
		campDetails = getdbQueryResults(dburl_campaign + campdbname, campaigndb_userName, campaigndb_password, qEmailCampDetails(communicationName));
		if (!campDetails.isEmpty())
		{
			for (Map<String, String> camprow : campDetails)
			{
				campaignId = camprow.get("CampaignID");
				campGUID1 = camprow.get("CampaignGUID");
				campBlastScheduleGUID = camprow.get("BlastScheduleGuid");
				BaseTest.getTest().log(Status.INFO, mapToString(camprow));
			}
		}
	}

	public void splitEmailCommDB(String splitType, Map<String, String> splitValues)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("Communication DB  EMAIL CHANNEL SPLIT :" + splitType + ", DETAILS", ExtentColor.BLUE));
		campDetails = getdbQueryResults(dburl_campaign + campdbname, campaigndb_userName, campaigndb_password, qSplitEmailCampDetails(communicationName, splitType));
		if (!campDetails.isEmpty())
		{
			for (Map<String, String> camprow : campDetails)
			{
				campaignId = camprow.get("CampaignID");
				campGUID1 = camprow.get("CampaignGUID");
				campBlastScheduleGUID = camprow.get("BlastScheduleGuid");
				BaseTest.getTest().log(Status.INFO, mapToString(camprow));
				String isSplit = camprow.get("IsEmailSplitAB");
				if (isSplit.contains("true"))
				{
					BaseTest.getTest().info("This communication marked as Split communication");
				} else
				{
					BaseTest.getTest().fail("This communication not marked as Split communication");
				}

			}
			if (campDetails.get(0).entrySet().containsAll(splitValues.entrySet()))
			{
				BaseTest.getTest().info("Fields validated successfully");
			} else
			{
				BaseTest.getTest().fail("Fields validated but UI and DB values mismatched");
			}
		}

	}

	public void rfaEmailDBValidation(String approvalmail, boolean approve)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("COMMUNICATION DB RFA EMAIL CHANNEL DETAILS", ExtentColor.BLUE));
		campDetails = getdbQueryResults(dburl_campaign + campdbname, campaigndb_userName, campaigndb_password, qEmailCampRFADetails(communicationName, approvalmail));
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
						BaseTest.getTest().info("This RFA communication Approved ");
					} else
					{
						BaseTest.getTest().fail("This RFA communication not Approved");
					}
				} else
				{
					if (makeChangeComments.isEmpty())
					{
						BaseTest.getTest().fail("This RFA communication make changes not updated");
					} else
					{
						BaseTest.getTest().info("This RFA communication make changes updated :" + makeChangeComments);
					}
				}

			}
		}

	}

	public CommunicationEmailChannelPage templateBuilder(int buildertemplateselect, String templatename)
	{

		clickElement(CommunicationRepository.communicationpage_email_templatebuildericon);
		explicitwaitforvisibility(autolocator(CommunicationRepository.communicationpage_email_createnewtemplate), 20);
		clickElement("Blank Canvas,xpath, //*[@id='listView']//div/p[@class='title'][contains(.,'Blank Canvas " + buildertemplateselect + "')]");
		pageLoaderLogo();
		enterValue(CommunicationRepository.communicationpage_email_templatename, templatename);

		return this;
	}

	public void commonOfferCodeAdd(String offer)
	{
		threadSleep(ObjectRepository.wait2sec);
		clickElement(CommunicationRepository.communication_commoncoupencode);
		clickElement(CommunicationRepository.communication_selectoffertype);
		selectlistelements(CommunicationRepository.communication_offertypedropdown, "EMI");
		clickElement(CommunicationRepository.communication_selectofferlist);
		selectlistelements(CommunicationRepository.communication_offerlistdropdown, offer);
		clickElement(CommunicationRepository.communication_offer_savebutton);
	}

	public void uniqueOfferCodeAdd(String offer)
	{
		threadSleep(ObjectRepository.wait2sec);
		clickElement(CommunicationRepository.communication_commoncoupencode);
		clickElement(CommunicationRepository.communication_uniquecoupencode);
		clickElement(CommunicationRepository.communication_selectoffertype);
		selectlistelements(CommunicationRepository.communication_offertypedropdown, "EMI");
		clickElement(CommunicationRepository.communication_selectofferlist);
		selectlistelements(CommunicationRepository.communication_offerlistdropdown, offer);
		clickElement(CommunicationRepository.communication_offer_savebutton);
	}

	public void offerCodeEmailContentValidate(String offercode)
	{
		if (isDisplayed(CommunicationRepository.communication_offer_emailcontent))
		{
			String emailcontent = getStrText(CommunicationRepository.communication_offer_emailcontent);
			if (emailcontent.contains(offercode))
			{
				BaseTest.getTest().log(Status.INFO, "Offer Code Found in Email Content");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Offer Code Not-Found in Email Content");
			}
		}
	}

	// After email subject spam validation thumbs up
	public Map<String, Integer> emailSubjectlineAnalysis()
	{
		Map<String, Integer> subjectline = new HashMap<>();
		threadSleep(ObjectRepository.wait3sec);
		javaScriptScrollIntoView(CommunicationRepository.communicationpage_select_emailsub);
		clickElement(CommunicationRepository.communicationemail_subjectline_thumbsupicon);

		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforvisibility(autolocator(CommunicationRepository.communicationemail_subjectline_headertext), 30);

		if (!isDisplayed(CommunicationRepository.communicationemail_subjectline_headertext))
		{
			BaseTest.getTest().log(Status.FAIL, "subjectline not present");
			BaseTest.takeScreenshot();
		}
		if (isDisplayed(CommunicationRepository.communicationemail_subjectline_projectedreachrate) && isDisplayed(CommunicationRepository.communicationpage_subline_top3))
		{
			String projectedRateHeader = getStrText(CommunicationRepository.communicationemail_subjectline_projectedreachrate);
			String projectedRateValue = getStrText(CommunicationRepository.communicationemail_subjectline_projectedreachratevalue);
			int projectedRate = Integer.parseInt(projectedRateValue.replaceAll("[^0-9]", ""));
			javaScriptHighLightElement(CommunicationRepository.communicationemail_subjectline_projectedreachratevalue);

			subjectline.put(projectedRateHeader, projectedRate);
			BaseTest.getTest().log(Status.INFO, "The subject line analysis : " + projectedRateHeader + " is " + projectedRateValue);

			String subjectValueText = getStrText(CommunicationRepository.communicationemail_subjectline_subjectlinelength);
			String subjectValue = getStrText(CommunicationRepository.communicationemail_subjectline_subjectlinelengthvalue);
			int subjectLength = Integer.parseInt(subjectValue.replaceAll("[^0-9]", ""));
			javaScriptHighLightElement(CommunicationRepository.communicationemail_subjectline_subjectlinelengthvalue);

			subjectline.put(subjectValueText, subjectLength);
			BaseTest.takeScreenshot();

			BaseTest.getTest().log(Status.INFO, "The subject line analysis : " + subjectValueText + " is " + subjectValue);
			clickElement(CommunicationRepository.communicationpage_subjectline_thumbpopupclose);
		} else
		{
			BaseTest.getTest().fail("Spam Score not present");
			BaseTest.takeScreenshot();
			clickElement(CommunicationRepository.communicationpage_subjectline_thumbpopupclose);
		}
		return subjectline;
	}

	public CommunicationEmailChannelPage subjectLineScoreRevalidation(Map<String, Integer> oldSubjectLine)
	{
		explicitwaitforclick(autolocator(CommunicationRepository.communicationpage_select_emailsub), 30);
		enterValue(CommunicationRepository.communicationpage_select_emailsub, "[[Name]], 100+ offers on your HDFC Bank A/C");

		Map<String, Integer> newSubjectLine = emailSubjectlineAnalysis();
		int newPRR = newSubjectLine.get("Projected reach rate");
		int oldPRR = oldSubjectLine.get("Projected reach rate");
		int newSubLength = newSubjectLine.get("Subject line length");
		int oldSubLength = oldSubjectLine.get("Subject line length");

		String eeee = getStrText("(//div[contains(@class,'mobile-select')]//input[contains(@id,'number')])");
		WebElement eel = driver.findElement(By.xpath("(//div[contains(@class,'mobile-select')]//input[contains(@id,'number')])"));
		if (newSubLength < oldSubLength && newPRR >= oldPRR)
		{
			BaseTest.getTest().log(Status.INFO, "The Subject Line length and Projected Reach Rate has been verified");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "The SubLine length and Projected Reach Rate verification has failed as Expected");
			BaseTest.takeScreenshot();
		}
		return this;
	}

	// Mkstr
	public CommunicationEmailChannelPage enterEmailsubline()
	{
		String subjectLine = BaseTest.getData().EmailSubjectLine + "," + communicationName + ",";
		enterValue(CommunicationRepository.communicationpage_select_emailsub, subjectLine + ".  ");
		emailSubjectline = subjectLine;
		javaScriptScrollDown();
		return this;
	}

	public CommunicationCreatePage verifyEmailCreatePageFields(String commStatus)
	{
		explicitwaitforvisibility(autolocator(CommunicationRepository.communicationpage_commcreation_edit_senderName), 30);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait5sec);
		if (commStatus.equalsIgnoreCase("In progress") || commStatus.equalsIgnoreCase("Completed"))
		{
			String list = getStrText(CommunicationRepository.communicationpage_commcreation_edit_audience);
			uiPageEqualswithInputValue("MARKETING STAR AUTOMATION", getTextBoxVal(CommunicationRepository.communicationpage_commcreation_edit_senderName, "value"));
			uiPageEqualswithInputValue(System.getProperty("sender_Name"), getTextBoxVal(CommunicationRepository.communicationpage_commcreation_edit_sendername, "value"));
			uiPageEqualswithInputValue(System.getProperty("senderMailId"), getStrText(CommunicationRepository.communicationpage_commcreation_edit_senderdomain));
			uiPageEqualswithInputValue(BaseTest.getData().TargetListNew, list.substring(0, list.indexOf("(")).trim());
			uiPageEqualswithInputValue(emailSubjectline, getTextBoxVal(CommunicationRepository.communicationpage_commcreation_edit_subline, "value"));
			javaScriptScrollIntoView(CommunicationRepository.communicationpage_commcreation_edit_edmfile);
			isDisplayed(CommunicationRepository.communicationpage_commcreation_edit_edmfile);
			uiPageEqualswithInputValue(getStrText(CommunicationRepository.communicationpage_commcreation_edit_unsub), "Unsub list1");
			if (isElementPresent(CommunicationRepository.communicationpage_commcreation_edit_testMail))
			{
				BaseTest.getTest().log(Status.INFO, "Test Mail dropdown has disable mode as Expected");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Test Mail dropdown has Enable mode not as Expected");
				BaseTest.takeScreenshot();
			}
			javaScriptScrollDown();
		}
		return this;
	}

	// Enter from name
	public CommunicationEmailChannelPage enterFname()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("COMMUNICATION EMAIL CHANNEL PAGE", ExtentColor.BLUE));
		enterValue(CommunicationRepository.communicationpage_email_fname, System.getProperty("sender_Name"));
		enterValue(CommunicationRepository.communicationpage_email_femail, System.getProperty("senderMailId"));
		return this;
	}

	public void galleryPagePositiveScenarios()
	{
		clickCommunicationListpagefromMenu();
		// Email channel
		String commName = BaseTest.getData().CommunicationName;
		searchCommunication("communicationlisting", commName);
		String listingPageDate = getStrText(",xpath,//p[.='" + commName + "']/ancestor::div[@class='communication-content']//small");
		String listingPageAudienceCount = getStrText(",xpath,//p[.='" + commName + "']/ancestor::div[contains(@class,'rs-communication-list')]//small[.='Total audience']//..//p");
		String listingPageCommType = getStrText(",xpath,//p[.='" + commName + "']/ancestor::div[contains(@class,'rs-communication-list')]//small[.='Single dimension']/..//p");
		clickCommunicationGallerypagefromMenu();
		boolean emailChannelDefault = isElementPresent(CommunicationRepository.gallerypage_channelfilter);
		writeLog(emailChannelDefault, "While navigating to Gallery page Email channel is selected as default channel", "While navigating to Gallery page Email channel is not selected as default channel");
		clickElement(CommunicationRepository.gallerypage_channelfilter);
		uiPageEqualswithMultipleInputValue(CommunicationRepository.gallerypage_channelfiltertypes, "Email,SMS,WhatsApp,VMS,Web notification,Mobile notification,Facebook,Twitter,Instagram,LinkedIn,Pinterest,Voice,QR");
		selectlistelements(CommunicationRepository.gallerypage_channelfiltertypes, "SMS");
		pageLoaderLogo();
		boolean smsCommunications = isElementPresent(CommunicationRepository.gallerypage_smspreview);
		writeLog(smsCommunications, "Able to filter the gallery page by using channel wise", "Unable to filter the gallery page by using channel wise");
		clickElement(CommunicationRepository.gallerypage_channelfilter);
		selectlistelements(CommunicationRepository.gallerypage_channelfiltertypes, "Email");
		clickElement(CommunicationRepository.gallerypage_datefilter);
		uiPageEqualswithMultipleInputValue(CommunicationRepository.gallerypage_datefiltertypes, "All time,Today,Last 7 days,Last 30 days,Custom range");
		clickElement(CommunicationRepository.gallerypage_datefilter);
		clickElement(CommunicationRepository.gallerypage_search);
		threadSleep(ObjectRepository.wait2sec);
		enterValue(CommunicationRepository.gallerypage_searchBox, commName);
		clickElement(CommunicationRepository.gallerypage_search);
		threadSleep(ObjectRepository.wait10sec);
		tooltipTextWithInput(CommunicationRepository.gallerypage_search, "Search");
		mouseHover(CommunicationRepository.gallerypage_search);
		String tooltipText = getStrText(DashboardRepository.allpage_tooltip);
		// boolean smsComm = isElementPresent(",xpath,(//p[.='" + commName + "'])[1]");
		writeLog(tooltipText.equalsIgnoreCase("Search"), "Able to search communication using search icon", "Unable to search communication using search icon");
		String galleryDate = getStrText("Date,xpath,//span[@class='rct-date']");
		clickElement("Info,xpath,//i[contains(@id,'circle_info')]");
		threadSleep(ObjectRepository.wait5sec);
		pageLoaderLogo();
		String galleryTotalAudience = getStrText("Total audience,xpath,//small[.='Total audience:']/following-sibling::span");
		String galleryCommType = getStrText("Communication type,xpath,//small[.='Communication type']/following-sibling::div");
		writeLog(listingPageDate.contains(galleryDate), "More info Creation date is validated successfully", "More info Creation date is mismatch with communication listing page date");
		writeLog(listingPageAudienceCount.equals(galleryTotalAudience), "More info total audience validated successfully", "More info audience count is mismatch with communication listing Audience count");
		writeLog(listingPageCommType.equals(galleryCommType), "More info communication type validated successfully", "More info communication type is mismatch with communication listing communication type");
		clickElement("Search close,xpath,//i[contains(@id,'RSSearchField_close')]");
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait5sec);
		javaScriptScrollDown();
		validateDisableAndEnableArrow();
		javaScriptScrollDown();
		validateItemPerPagesGalleryPage();
	}

	// Gallery page positive flow
	public void plannerPagePositiveScenarios()
	{
		clickCommunicationListpagefromMenu();
		javaScriptScrolltoTop();
		explicitwaitforclick(autolocator(AudienceRepository.audience_Filter_Menu), 30);
		clickElement(AudienceRepository.audience_Filter_Menu);
		explicitwaitforclick(autolocator(AudienceRepository.audience_FilterMenu_List), 30);
		selectlistelementsAndProceed(AudienceRepository.audience_FilterMenu_List, "Custom range");
		customRangeCalender(BaseTest.getData().StartDate);
		customRangeCalender(BaseTest.getData().EndDate);
		threadSleep(ObjectRepository.wait1sec);
		clickElement(AudienceRepository.audience_target_customfilterclickapply);
	}

	public void subjectLineValidation()
	{
		String commNameAuthoringPage = getTextBoxVal(",xpath,//input[@name='subjectLine']", "value");
		clickElement("Subject line analysis,xpath,//i[contains(@id,'rs_SplitABTab_spamassassign')]");
		pageLoaderLogo();
		explicitwaitforvisibility(autolocator("SLA header,xpath,//h2[.='Subject line analysis']"), 20);
		String popupHeader = getStrText("Subject line head,xpath,//p[@class='fs19']");
		uiPageEqualswithInputValue(commNameAuthoringPage, popupHeader);
		pageLoaderLogo();

		threadSleep(ObjectRepository.wait3sec);

		if (isDisplayed("Projected reach rate,xpath,//span[text()='Projected CTR']/..//*[@class='skeleton-span center mt20']") && isDisplayed("Subject line analysis pie,xpath,//span[text()='Subject line length']/..//div[@data-highcharts-chart]"))
		{
			BaseTest.getTest().info("Project reach rate and Subject line analysis pie chart is displayed as expected");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().fail("Project reach rate and Subject line analysis pie chart is not displayed after click subject line analysis thum button");
			BaseTest.takeScreenshot();
		}
		threadSleep(ObjectRepository.wait3sec);

		boolean slaSuggestion = isElementPresent("Top 3 subject line,xpath,//div[@class='sla-modal-content-items position-relative']");
		writeLog(slaSuggestion, "Top 3 suject line Suggestion is present as expected", "Top 3 suject line Suggestion is not present as expected");
		clickElement("SLA close button,xpath,//i[contains(@id,'rs_circle_close_edge')]");
		threadSleep(ObjectRepository.wait3sec);
		BaseTest.takeScreenshot();
	}

	public String spamScoreCheck()
	{
		pageLoaderLogo();
		javaScriptScrollDownToSomeExtend();
		clickElement("Spam score,xpath,//i[contains(@class,'spam-assassin')][not(@id)]");
		pageLoaderLogo();
		String spamScoreAuthoring = getStrText("Spam score authoring page,xpath,//div[@class='spam-scale-handle']").replaceAll("[^\\d]", "");
		BaseTest.takeScreenshot();
		clickElement("Close spam score,xpath,//i[@id='rs_circle_close_edge']");
		threadSleep(ObjectRepository.wait3sec);
		return spamScoreAuthoring;
	}

	public void CommunicationType(String CommunicationType)
	{
		if (CommunicationType == "Text")
		{
			commTextEmailPersonaforeventtrigger();

		} else
		{
			clickImport().selectZip(BaseTest.getData().ZipName);
			clickElement(",xpath,(//i[@id='rs_data_refresh'])[1]");
			PageBase.threadSleep(3000);
			clickElement(",xpath,//button[.='OK']");
			javaScriptScrollIntoView(",xpath,(//i[@class='icon-rs-user-question-mark-medium icon-md'])[2]");
			PageBase.threadSleep(3000);
			clickElement(CommunicationRepository.email_clickimport);
			selectZip(BaseTest.getData().ZipName);

		}

	}

	public void gallerycommunicationtype(String CommunicationType)
	{
		pageLoaderLogo();

		clickCommunicationTab();
		clickElement(CommunicationRepository.communicationpage_Gallery);
		pageLoaderLogo();
		BaseTest.getTest().info(MarkupHelper.createLabel("Gallery PAGE", ExtentColor.BLUE));
		clickElement("Communication type,xpath,//div[contains(@class,'rs-kendo-dropdownmen')]");
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, CommunicationType); // Web notification
		pageLoaderLogo();

	}

	public void gallerycommunicationSearch(String Communicationname, String type)
	{
		try
		{
			clickElement("search icon,xpath,//div[@class='rs-search-icon']");
			threadSleep(ObjectRepository.wait1sec);
		} catch (Throwable e)
		{
			threadSleep(ObjectRepository.wait5sec);
		}
		enterValue("Search field,xpath,//input[contains(@class,'searchInput active ')]", Communicationname);
		threadSleep(ObjectRepository.wait5sec);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait1sec);
		clickElement("search icon,xpath,//i[@class='icon-md icon-rs-zoom-medium']");
		threadSleep(ObjectRepository.wait5sec);
		String shortCommName = Communicationname.substring(0, 20) + "...";
		clickElement(replacePlaceHolder("three icon,xpath,//p[.='PLACE_HOLDER']//ancestor::div[contains(@class,'gallery-list')]//i", shortCommName));
		if (type == "edit")
		{

			clickElement("edit icon,xpath,//a[.='Edit']");
			pageLoaderLogo();
			threadSleep(ObjectRepository.wait1sec);
			boolean pagevalue = getAttributeNameAndValue(",xpath,//div[contains(@class,'box-design bd-top-border')]", "class");
			if (pagevalue)
			{
				BaseTest.getTest().info("Communication planning page is as expected");
				BaseTest.takeScreenshot();

			} else
			{
				BaseTest.getTest().info("Communication planning page is not asexpected");
				BaseTest.takeScreenshot();
			}
		} else if (type == "duplicate")
		{
			clickElement("edit icon,xpath,//a[.='Duplicate']");
			pageLoaderLogo();
			threadSleep(ObjectRepository.wait1sec);
			threadSleep(ObjectRepository.wait5sec);
			boolean searchresult = false;
			for (int i = 0; i <= 2; i++)
			{
				try
				{
					clickElement(CommunicationRepository.CommunicationListing_SearchIconClick);
					threadSleep(ObjectRepository.wait1sec);
					break;
				} catch (Throwable e)
				{
					threadSleep(ObjectRepository.wait5sec);
				}
			}
			enterValue(CommunicationRepository.CommunicationListing_SearchCommunication, Communicationname);
			threadSleep(ObjectRepository.wait5sec);
			pageLoaderLogo();
			threadSleep(ObjectRepository.wait1sec);
			clickElement(AudienceRepository.audience_dynamic_afterentervaluesearch);
			threadSleep(ObjectRepository.wait5sec);
			threadSleep(ObjectRepository.wait5sec);
			try
			{
				int commCountIdentify = commCountIdentify(Communicationname);
				mouseHover(",xpath,(//p[@class='pt5'])[" + commCountIdentify + "]//div");
				String toolTipText = getStrText(DashboardRepository.allpage_tooltip);
				if (toolTipText.contains("copy"))
				{
					BaseTest.getTest().log(Status.INFO, "duplicate communication is available in listing page.");
					BaseTest.takeScreenshot();
					searchresult = true;

				} else
				{
					BaseTest.getTest().log(Status.FAIL, " Duplicate communication is not available in listing page");
					BaseTest.takeScreenshot();
				}
			} catch (Exception e)
			{
				BaseTest.getTest().log(Status.FAIL, "Duplicate communication is not available in listing page");
				BaseTest.takeScreenshot();
			}
		}
	}

	public void saveAuthoringPage()
	{
		explicitwaitforclick(autolocator("Save,xpath,// button[text()='Save']"), 30);
		clickElement("click button,xpath, // button[text()='Save']");
		BaseTest.getTest().log(Status.INFO, "Clicked save buttton");
	}

	public void RFAApprovalComments()
	{
		threadSleep(ObjectRepository.wait10sec);
		switchWindow();
		enterValue(WebmailRepository.webmail_page_communicationemailsms_requestApproveCommentBox, "Approved");
		threadSleep(ObjectRepository.wait1sec);
		clickElement(WebmailRepository.webmail_page_communicationemailsms_requestApproveCommentApprove);
		String alertStatus = getStrText(WebmailRepository.webmail_page_communicationApproveAndMakeChangesStatus);
		BaseTest.getTest().log(Status.INFO, "ALert status -> " + alertStatus);
	}

	public void selectAMPEDMZipUsingKeys()
	{
		actionsClickElement(",xpath,//div[contains(@class,'import-zip-file-tab')]");
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait3sec);
		File file = new File("src/main/resources/Zip/AMP_Final_Latest.zip");
		String absolutePath = file.getAbsolutePath();
		// sendValue("Zip file icon,xpath,//input[@type='file']", absolutePath);

		StringSelection selection = new StringSelection(absolutePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		Robot r = null;
		try
		{
			r = new Robot();
		} catch (Exception e)
		{

		}
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait5sec);
	}

	// Gallery page positive flow
	public void galleryPagePositiveScenarios(String CommunicationChannel)
	{
		clickCommunicationListpagefromMenu();
		// Email channel
		String commName = BaseTest.getData().CommunicationName;
		searchCommunication("communicationlisting", commName);
		String listingPageDate = getStrText(",xpath,//p[.='" + commName + "']/ancestor::div[@class='communication-content']//small");
		String listingPageAudienceCount = getStrText(",xpath,//p[.='" + commName + "']/ancestor::div[contains(@class,'rs-communication-list')]//small[.='Total audience']//..//p");
		String listingPageCommType = getStrText(",xpath,//p[.='" + commName + "']/ancestor::div[contains(@class,'rs-communication-list')]//small[.='Single dimension']//..//p");
		clickCommunicationGallerypagefromMenu();
		boolean emailChannelDefault = isElementPresent(CommunicationRepository.gallerypage_channelfilter);
		writeLog(emailChannelDefault, "While navigating to Gallery page Email channel is selected as default channel", "While navigating to Gallery page Email channel is not selected as default channel");
		clickElement(CommunicationRepository.gallerypage_channelfilter);
//			uiPageEqualswithMultipleInputValue(CommunicationRepository.gallerypage_channelfiltertypes,
//					"Email,SMS,QR,Facebook,Twitter,Instagram,LinkedIn,Web notification,Mobile notification,WhatsApp,VMS,Voice,Webhook");
		selectlistelements(CommunicationRepository.gallerypage_channelfiltertypes, "SMS");
		pageLoaderLogo();
		boolean smsCommunications = isElementPresent(CommunicationRepository.gallerypage_smspreview);
		writeLog(smsCommunications, "Able to filter the gallery page by using channel wise", "Unable to filter the gallery page by using channel wise");
		clickElement(CommunicationRepository.gallerypage_channelfilter);
		selectlistelements(CommunicationRepository.gallerypage_channelfiltertypes, CommunicationChannel);
		clickElement(CommunicationRepository.gallerypage_datefilter);
		uiPageEqualswithMultipleInputValue(CommunicationRepository.gallerypage_datefiltertypes, "All time,Today,Last 7 days,Last 30 days,Custom range");
		clickElement(CommunicationRepository.gallerypage_datefilter);
		clickElement(CommunicationRepository.gallerypage_search);
		threadSleep(ObjectRepository.wait2sec);
		enterValue(CommunicationRepository.gallerypage_searchBox, commName);
		clickElement(CommunicationRepository.gallerypage_search);
		threadSleep(ObjectRepository.wait10sec);
		boolean smsComm = isElementPresent(",xpath,(//p[.='" + commName + "'])[1]");
		writeLog(smsComm, "Able to search communication using search icon", "Unable to search communication using search icon");
		String galleryDate = getStrText("Date,xpath,//span[@class='rct-date']");
		clickElement("Info,xpath,//i[contains(@id,'circle_info')]");
		threadSleep(ObjectRepository.wait5sec);
		pageLoaderLogo();
		String galleryTotalAudience = getStrText("Total audience,xpath,//small[.='Total audience:']/following-sibling::span");
		String galleryCommType = getStrText("Communication type,xpath,//small[.='Communication type']/following-sibling::div");
		writeLog(listingPageDate.contains(galleryDate), "More info Creation date is validated successfully", "More info Creation date is mismatch with communication listing page date");
		writeLog(listingPageAudienceCount.equals(galleryTotalAudience), "More info total audience validated successfully", "More info audience count is mismatch with communication listing Audience count");
		writeLog(listingPageCommType.equals(galleryCommType), "More info communication type validated successfully", "More info communication type is mismatch with communication listing communication type");
		clickElement("Search close,xpath,//i[contains(@id,'RSSearchField_close')]");
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait5sec);
		javaScriptScrollDown();
		validateDisableAndEnableArrow();
		javaScriptScrollDown();
		validateItemPerPagesGalleryPage();
	}

	public CommunicationEmailChannelPage selectZip1(String vzip)
	{
		// javaScriptScrollDownToSomeExtend();
		threadSleep(ObjectRepository.wait3sec);
		String zip = BaseTest.curr_Dir + "/src/main\\resources" + "\\Zip\\" + vzip + ".zip";
		sendValue("Import zip icon,xpath,//label[.='Import ZIP file']//following-sibling::input", zip);
		pageLoaderLogo();
		return this;
	}
}
