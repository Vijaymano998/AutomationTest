package pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.microsoft.playwright.Page;

import repository.AccountSetupRepository;
import repository.AnalyticsRepository;
import repository.AudienceRepository;
import repository.CommunicationRepository;
import repository.LoginRepository;
import repository.ObjectRepository;
import repository.PreferencesRepository;
import repository.WebmailRepository;
import utility.BaseTest;
import utility.PageFactory;

public class OtpPage extends LoginPage
{
	public String comTotalAudienceCount = "";

	public OtpPage(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	// Web URL Launch
	public OtpPage webURLlaunch()
	{
		threadSleep(ObjectRepository.wait5sec);
		driver.get(System.getProperty("team_webmail_url"));
		if (isElementPresent(LoginRepository.login_itkt_webmaillogout_button))
		{
			clickElement(LoginRepository.login_itkt_webmaillogout_button);
		}
		return this;
	}

	// Team weburl launch
	public OtpPage teamWebUrlLaunch()
	{
		threadSleep(ObjectRepository.wait2sec);
		driver.get(System.getProperty("team_webmail_url"));
		if (isElementPresent("Bitdefender,xpath,//div[@id='takeMeThere']"))
		{
			clickElement("Bitdefender,xpath,//div[@id='takeMeThere']/a");
		}
		return this;
	}

	public OtpPage smartdxWebUrlLaunch()
	{
		threadSleep(ObjectRepository.wait5sec);
		driver.get(System.getProperty("smartdx_webmail_url"));
		if (isElementPresent("Bitdefender,xpath,//div[@id='takeMeThere']"))
		{
			clickElement("Bitdefender,xpath,//div[@id='takeMeThere']/a");
		}
		return this;
	}

	// Webmail login
	public OtpPage webmailLogin(String unameval, String val)
	{
//		BaseTest.getTest().info(MarkupHelper.createLabel("WEBMAIL LOGIN PAGE", ExtentColor.BLUE));
//		explicitwaitforvisibility(autolocator(LoginRepository.login_itkt_uname_textbox), 40);
//		enterValue(LoginRepository.login_itkt_uname_textbox, unameval);
//		explicitwaitforvisibility(autolocator(LoginRepository.loginWebmail_itkt_uname_textbox), 40);
//		enterValue(LoginRepository.loginWebmail_itkt_uname_textbox, unameval);
//		threadSleep(ObjectRepository.wait1sec);
//
//		driver.findElement(autolocator(LoginRepository.login_itkt_pass_textbox)).sendKeys(val);
//		driver.findElement(autolocator(LoginRepository.loginWebmail_itkt_pass_textbox)).sendKeys(val);
//		clickElement(LoginRepository.login_itkt_login_button);
//		clickOpenYourInboxpage();
//		clickElement(LoginRepository.login_itkt_inbox_link);
//		threadSleep(ObjectRepository.wait2sec);
//		BaseTest.takeScreenshot();
//		return this;

		BaseTest.getTest().info(MarkupHelper.createLabel("WEBMAIL LOGIN PAGE", ExtentColor.BLUE));
		explicitwaitforvisibility(autolocator(LoginRepository.login_itkt_uname_textbox), 40);
		enterValue(LoginRepository.login_itkt_uname_textbox, unameval);
		threadSleep(ObjectRepository.wait1sec);

		driver.findElement(autolocator(LoginRepository.login_itkt_pass_textbox)).sendKeys(val);

		clickElement(LoginRepository.login_itkt_login_button);
		clickOpenYourInboxpage();
		clickElement(LoginRepository.login_itkt_inbox_link);
		threadSleep(ObjectRepository.wait5sec);
		clickElement(LoginRepository.login_itkt_inbox_link);
//		clickElement(LoginRepository.login_itkt_webmaillogout_button);
		BaseTest.takeScreenshot();
		return this;
	}

	public OtpPage webmailLoginaccountsetup(String unameval, String val)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("WEBMAIL LOGIN PAGE", ExtentColor.BLUE));
		explicitwaitforvisibility(autolocator(LoginRepository.login_itkt_uname_textbox), 40);
		enterValue(LoginRepository.login_itkt_uname_textbox, unameval);
		threadSleep(ObjectRepository.wait1sec);
		val = val.trim();
		driver.findElement(autolocator(LoginRepository.login_itkt_pass_textbox)).sendKeys(val);
		clickElement(LoginRepository.login_itkt_login_button);
		BaseTest.takeScreenshot();
		return this;
	}

	public OtpPage teamWebmailLogin(String unameval, String val)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("WEBMAIL LOGIN PAGE", ExtentColor.BLUE));
		explicitwaitforvisibility(autolocator(LoginRepository.teamlogin_itkt_uname_textbox), 40);
		enterValue(LoginRepository.teamlogin_itkt_uname_textbox, unameval);
		threadSleep(ObjectRepository.wait1sec);
		driver.findElement(autolocator(LoginRepository.teamlogin_itkt_pass_textbox)).sendKeys(val);
		clickElement(LoginRepository.teamlogin_itkt_login_button);
		threadSleep(ObjectRepository.wait2sec);
		clickElement(LoginRepository.teamlogin_itkt_inbox_link);
		threadSleep(ObjectRepository.wait2sec);
		BaseTest.takeScreenshot();
		return this;
	}

	public boolean clickOpenYourInboxpage()
	{
		if (isElementExist("Open mail checkBox,xpath,//input[@id='setActiveAsDefault']"))
		{
			clickElement("Open mail checkBox,xpath,//input[@id='setActiveAsDefault']");
			clickElement("open mail ui,xpath,//button[@id='launchActiveButton']");
			threadSleep(ObjectRepository.wait1sec);
			return true;
		}
		return false;
	}

	// Target and dynamic list approver 1
	public OtpPage target_Dynamic_approver1_Webmail_login()
	{
		String uname = System.getProperty("Target_Dynamic_approver1_webmail_Uname");
		String upswrd = System.getProperty("Target_Dynamic_approver1_webmail_pswrd");
		webmailLogin(uname, upswrd);
		return this;
	}

	// Target and dynamic list approver 2

	public OtpPage target_Dynamic_approver2_Webmail_login()
	{
		String uname = System.getProperty("Target_Dynamic_approver2_webmail_Uname");
		String upswrd = System.getProperty("Target_Dynamic_approver2_webmail_pswrd");
		webmailLogin(uname, upswrd);
		return this;
	}

	// Target and dynamic list approver 3

	public OtpPage target_Dynamic_approver3_Webmail_login()
	{
		String uname = System.getProperty("Target_Dynamic_approver3_webmail_Uname");
		String upswrd = System.getProperty("Target_Dynamic_approver3_webmail_pswrd");
		webmailLogin(uname, upswrd);
		return this;
	}

	// Target and dynamic list approver 1
	public OtpPage Communication_approver1_Webmail_login()
	{
		String uname = System.getProperty("Communication_approver1_webmail_Uname");
		String upswrd = System.getProperty("Communication_approver1_webmail_pswrd");
		webmailLogin(uname, upswrd);
		return this;
	}

	// Target and dynamic list approver 2

	public OtpPage Communication_approver2_Webmail_login()
	{
		String uname = System.getProperty("Communication_approver2_webmail_Uname");
		String upswrd = System.getProperty("Communication_approver2_webmail_pswrd");
		webmailLogin(uname, upswrd);
		return this;
	}

	// Target and dynamic list approver 3

	public OtpPage Communication_approver3_Webmail_login()
	{
		String uname = System.getProperty("Communication_approver3_webmail_Uname");
		String upswrd = System.getProperty("Communication_approver3_webmail_pswrd");
		webmailLogin(uname, upswrd);
		return this;
	}

	public OtpPage target_Dynamic_approver4_Webmail_login()
	{
		String uname = System.getProperty("Target_Dynamic_approver4_webmail_Uname");
		String upswrd = System.getProperty("Target_Dynamic_approver4_webmail_pswrd");
		webmailLogin(uname, upswrd);
		return this;
	}

	public OtpPage accountUserWebmailLogin()
	{
		String uname = System.getProperty("teamKeyAcctWebmailUsername");
		String upswrd = System.getProperty("teamKeyAcctWebmailPassword");
		webmailLogin(uname, upswrd);
		return this;
	}

	public OtpPage accountMyProfileWebmailLogin()
	{
		String uname = System.getProperty("teamMyprofileAcctWebmailUsername");
		String upswrd = System.getProperty("teamMyprofileAcctWebmailPassword");
		webmailLogin(uname, upswrd);
		return this;
	}

	public OtpPage keyUserWebmailLogin()
	{
		String uname = System.getProperty("teamKeyAcctWebmailUsername");
		String upswrd = System.getProperty("teamKeyAcctWebmailPassword");
		webmailLogin(uname, upswrd);
		return this;
	}

	public OtpPage accountKeyUserWebmailLogin()
	{
		String uname = System.getProperty("KeyAcctWebmailUsername");
		String upswrd = System.getProperty("KeyAcctWebmailPassword");
		webmailLogin(uname, upswrd);
		return this;
	}

	public OtpPage teamAccountKeyUserWebmailLogin()
	{
		String uname = System.getProperty("teamKeyAcctWebmailUsername");
		String upswrd = System.getProperty("teamKeyAcctWebmailPassword");
		teamWebmailLogin(uname, upswrd);
		return this;
	}

	// Correct #########################################################################

	public OtpPage accountNewUserWebmailLogin()
	{
		String uname = BaseTest.getData().EnterNewEmail;
		String upswrd = System.getProperty("NewUserPassword");
		webmailLogin(uname, upswrd);
		return this;
	}

	public OtpPage accountCreationWebMailLogin()
	{
		String username = System.getProperty("ActStupCreation_User");
		String pswrd = System.getProperty("ActStupCreation_Pwd");
		webmailLogin(username, pswrd);
		return this;
	}

	public OtpPage emailBlastCheckWebmailLogin()
	{
		String uname = System.getProperty("EmailBlastWebmailUsername");
		String upswrd = System.getProperty("EmailBlastWebmailPassword");
		webmailLogin(uname, upswrd);
		return this;
	}

	public OtpPage addNewUserWebmailLogin(String email)
	{
		if (email.contains("vbnk94"))
		{
			addNewUserOneWebmailLogin();

		} else if (email.contains("vbnk95"))
		{
			addNewUserTwoWebmailLogin();

		} else if (email.contains("vbnk96"))
		{
			addNewUserThreeWebmailLogin();

		} else if (email.contains("vbnk97"))
		{
			addNewUserFourWebmailLogin();

		} else if (email.contains("vbnk98"))
		{
			addNewUserFiveWebmailLogin();

		} else
		{
			BaseTest.getTest().warning("Add user invalid Email-ID");
		}
		return this;
	}

	public OtpPage addNewUserOneWebmailLogin()
	{
		String uname = System.getProperty("Add_UserOne_Username");
		String upswrd = System.getProperty("Add_UserOne_Password");
		webmailLogin(uname, upswrd);
		return this;
	}

	public OtpPage addNewUserTwoWebmailLogin()
	{
		String uname = System.getProperty("Add_UserTwo_Username");
		String upswrd = System.getProperty("Add_UserTwo_Password");
		webmailLogin(uname, upswrd);
		return this;
	}

	public OtpPage addNewUserThreeWebmailLogin()
	{
		String uname = System.getProperty("Add_UserThree_Username");
		String upswrd = System.getProperty("Add_UserThree_Password");
		webmailLogin(uname, upswrd);
		return this;
	}

	public OtpPage addNewUserFourWebmailLogin()
	{
		String uname = System.getProperty("Add_UserFour_Username");
		String upswrd = System.getProperty("Add_UserFour_Password");
		webmailLogin(uname, upswrd);
		return this;
	}

	public OtpPage addNewUserFiveWebmailLogin()
	{
		String uname = System.getProperty("Add_UserFive_Username");
		String upswrd = System.getProperty("Add_UserFive_Password");
		webmailLogin(uname, upswrd);
		return this;
	}

	// Webmail logout
	public OtpPage webmailLogout()
	{
		clickElement(LoginRepository.login_itkt_logout_button);
		return this;
	}

	public OtpPage teamWebmailLogout()
	{
		clickElement(LoginRepository.teamlogin_itkt_webmaillogout);
		return this;
	}

	// Webmail home page inbox click
	public OtpPage webmailInboxClick()
	{
		threadSleep(ObjectRepository.wait3sec);
		clickElement(LoginRepository.login_itkt_inbox_link);
		threadSleep(ObjectRepository.wait5sec);
		return this;
	}

	// Webmail email blast check
	public boolean emailBlastCheck(String linktext) throws TimeoutException
	{
		boolean val = false;
		for (int i = -4; i < 5; i++)
		{
			try
			{
				explicitwaitforclick(autolocator(LoginRepository.login_itkt_inbox_link), 15);
				threadSleep(ObjectRepository.wait10sec);
				clickElement(LoginRepository.login_itkt_inbox_link);
				threadSleep(ObjectRepository.wait3sec);
				if ((WebmailRepository.webmail_inboxunread).toLowerCase().contains("unread"))
				{
					explicitwaitforvisibility(autolocator("Subjectline,xpath," + "//*[contains(@id,'msgicnrcmrow')][contains(@title,'Unread')]//..//a[contains(.,'" + linktext + "')]"), 30);
					emailSubjectLineBlastText = getStrText("Subjectline,xpath," + "//*[contains(@id,'msgicnrcmrow')][contains(@title,'Unread')]//..//a[contains(.,'" + linktext + "')]");
					doubleClickElement(driver, "Subjectline,xpath," + "//*[contains(@id,'msgicnrcmrow')][contains(@title,'Unread')]//..//a[contains(.,'" + linktext + "')]");
					if (isElementPresent("Allow button,xpath,//div[@id='remote-objects-message']//span[@class='boxbuttons']"))
					{
						clickElement("Allow button,xpath,//div[@id='remote-objects-message']//span[@class='boxbuttons']");
					}
					val = true;
					break;
				}
			} catch (Exception e)
			{
				try
				{
					if (i == 5)
					{
						BaseTest.getTest().log(Status.INFO, e.getMessage());
					}
					explicitwaitforclick(autolocator(LoginRepository.login_itkt_inbox_link), 30);
					clickElement(LoginRepository.login_itkt_inbox_link); // Inbox folder click
				} catch (Exception e1)
				{
					if (i == 5)
					{
						BaseTest.getTest().log(Status.INFO, e1.getMessage());
						BaseTest.takeScreenshot();
					}
					clickElement(WebmailRepository.itkt_inbox_linkafterinboxmailopen);
				}
				val = false;
			}
		}
		if (val)

		{
			BaseTest.getTest().log(Status.INFO, linktext + " : Mail received, Mail is present in inbox");
			BaseTest.takeScreenshot();
		} else
		{
			try
			{
				explicitwaitforvisibility(autolocator(",xpath," + "//a[contains(.,'" + linktext + "')]"), 30);
				doubleClickElement(driver, ",xpath," + "//a[contains(.,'" + linktext + "')]");
				BaseTest.getTest().log(Status.INFO, linktext + " :Mail received, Mail is present in inbox");
				val = true;
			} catch (Exception e)
			{
				BaseTest.getTest().log(Status.FAIL, linktext + " : Mail not received");
				BaseTest.takeScreenshot();
			}
		}
		return val;
	}

	public boolean teamEmailBlastCheck(String linktext) throws TimeoutException
	{
		boolean val = false;
		for (int i = -4; i < 5; i++)
		{
			try
			{
				explicitwaitforclick(autolocator(LoginRepository.teamlogin_itkt_inbox_link), 15);
				threadSleep(ObjectRepository.wait5sec);
				clickElement(LoginRepository.teamlogin_itkt_inbox_link);
				if ((WebmailRepository.webmail_inboxunread).toLowerCase().contains("unread"))
				{
					explicitwaitforvisibility(autolocator("Subjectline,xpath," + "//a[contains(.,'" + linktext + "')]"), 30);
					emailSubjectLineBlastText = getStrText("Subjectline,xpath," + "//a[contains(.,'" + linktext + "')]");
					doubleClickElement(driver, "Subjectline,xpath," + "//a[contains(.,'" + linktext + "')]");
					if (isElementPresent("Allow button,xpath,//div[@id='remote-objects-message']//span[@class='boxbuttons']"))
					{
						clickElement("Allow button,xpath,//div[@id='remote-objects-message']//span[@class='boxbuttons']");
					}
					val = true;
					break;
				}
			} catch (Exception e)
			{
				try
				{
					if (i == 5)
					{
						BaseTest.getTest().log(Status.INFO, e.getMessage());
					}
					explicitwaitforclick(autolocator(LoginRepository.teamlogin_itkt_inbox_link), 30);
					clickElement(LoginRepository.teamlogin_itkt_inbox_link); // Inbox folder click
				} catch (Exception e1)
				{
					if (i == 5)
					{
						BaseTest.getTest().log(Status.INFO, e1.getMessage());
						BaseTest.takeScreenshot();
					}
					clickElement(LoginRepository.teamlogin_itkt_inbox_link);
				}
				val = false;
			}
		}
		if (val)
		{
			BaseTest.getTest().log(Status.INFO, linktext + " : Mail received, Mail is present in inbox");
			BaseTest.takeScreenshot();
		} else
		{
			try
			{
				explicitwaitforvisibility(autolocator(",xpath," + "//a[contains(.,'" + linktext + "')]"), 30);
				doubleClickElement(driver, ",xpath," + "//a[contains(.,'" + linktext + "')]");
				BaseTest.getTest().log(Status.INFO, linktext + " :Mail received, Mail is present in inbox");
				val = true;
			} catch (Exception e)
			{
				BaseTest.getTest().log(Status.FAIL, linktext + " : Mail not received");
				BaseTest.takeScreenshot();
			}
		}
		return val;
	}

	// Webmail email blast check exact
	public boolean emailBlastCheckExactSubjectLine(String linktext)
	{
		boolean val = false;
		for (int i = 0; i < 3; i++)
		{
			try
			{
				driver.navigate().refresh();
				threadSleep(ObjectRepository.wait5sec);
				webmailInboxClick();
				threadSleep(ObjectRepository.wait5sec);
				explicitwaitforvisibility(autolocator(",xpath," + "//span[normalize-space(text())='" + linktext + "']"), 30);
				doubleClickElement(driver, ",xpath," + "//span[normalize-space(text())='" + linktext + "']");
				val = true;
				break;

			} catch (Exception e)
			{
				driver.navigate().refresh();
				val = false;
			}
		}
		if (val)
		{
			BaseTest.getTest().log(Status.INFO, linktext + " :Mail received, Mail is present in inbox");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, linktext + " : Mail not received");
			BaseTest.takeScreenshot();
		}
		return val;
	}

	public boolean rfaCheckExactMail(String linktext, String listName)
	{
//		threadSleep(ObjectRepository.wait20sec);
		boolean val = false;
		for (int i = 0; i < 3; i++)
		{
			try
			{
				if (!val)
				{
					driver.navigate().refresh();
					threadSleep(ObjectRepository.wait5sec);
					driver.navigate().refresh();
					webmailInboxClick();

					explicitwaitforvisibility(autolocator("Inbox Mails,xpath," + "//span[normalize-space(text())='" + linktext + "']"), 30);
					List<WebElement> noOfLinks = driver.findElements(autolocator("No of mails,xpath," + "//span[normalize-space(text())='" + linktext + "']"));
					for (int j = 1; j <= noOfLinks.size(); j++)
					{
						try
						{
							clickElement("Inbox Mail,xpath,(//span[normalize-space(text())='" + linktext + "'])[" + j + "]");
							threadSleep(ObjectRepository.wait3sec);
							// driver.switchTo().frame("messagecontframe");
							WebElement ele = driver.findElement(By.tagName("iframe"));
							driver.switchTo().frame(ele);

							WebElement mailLink = driver.findElement(By.xpath("//td[contains(text(), '" + listName + "')]"));
							if (mailLink.isDisplayed())
							{
								driver.switchTo().defaultContent();
								doubleClickElement(driver, " Double click Mail,xpath,(//span[normalize-space(text())='" + linktext + "'])[" + j + "]");
								val = true;
								break;
							} else
							{
								BaseTest.getTest().log(Status.INFO, "Rfa list name differs");
							}
							driver.switchTo().defaultContent();

						} catch (Exception e)
						{
							driver.switchTo().defaultContent();
						}
					}
				}
			} catch (Exception e)
			{
				driver.navigate().refresh();
				val = false;
			}
		}
		if (val)
		{
			BaseTest.getTest().log(Status.INFO, linktext + " :Mail received, Mail is present in inbox");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, linktext + " : Mail not received");
			BaseTest.takeScreenshot();
		}
		return val;
	}

	public void clickCommunicationRFAMailApproveBtn()
	{
		threadSleep(ObjectRepository.wait1sec);
		javaScriptScrollIntoView(WebmailRepository.webmail_page_communicationemailsms_requestApproveBtn);
		explicitwaitforclick(autolocator(WebmailRepository.webmail_page_communicationemailsms_requestApproveBtn), 30);
		clickElement(WebmailRepository.webmail_page_communicationemailsms_requestApproveBtn);
	}

	// Request for approve click on approve button
	public OtpPage clickTargetDynamicRFAApproveBtn()
	{

		explicitwaitforvisibility(autolocator(WebmailRepository.webmail_page_communication_requestApproveBtn), 90);

		threadSleep(ObjectRepository.wait3sec);
		pageLoaderLogo();

		if (isDisplayed(WebmailRepository.webmail_page_communication_requestApproveBtn))
		{
			explicitwaitforclick(autolocator(WebmailRepository.webmail_page_communication_requestApproveBtn), 90);
			pageLoaderLogo();

			clickElement(WebmailRepository.webmail_page_communication_requestApproveBtn);

			if (isDisplayed(AudienceRepository.audience_dynamic_rfaapproval_popup))
			{
				BaseTest.getTest().log(Status.PASS, "Dynamic list approved succesfuuly popup is displayed properly");
				BaseTest.takeScreenshot();
			} else
			{
				BaseTest.getTest().log(Status.WARNING, "Request for approval popup is displayed properly");
				BaseTest.takeScreenshot();
			}

			BaseTest.takeScreenshot();
			pageLoaderLogo();

		} else
		{
			BaseTest.getTest().log(Status.FAIL, "RFA approve button not appeared");
			BaseTest.takeScreenshot();
		}
		threadSleep(ObjectRepository.wait3sec);

		pageLoaderLogo();

		return this;
	}

	// Request for approve check approved message present or not
	public String checkCommApprovedMsg()
	{
		switchWindow();
		String approverMessage = null;
		explicitwaitforvisibility(autolocator(WebmailRepository.webmail_page_communication_approvedmsg), 20);
		if (isDisplayed(WebmailRepository.webmail_page_communication_approvedmsg))
		{
			approverMessage = getStrText(WebmailRepository.webmail_page_communication_approvedmsg);
			compareUiwithInputvalue(approverMessage, "has approved");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Page not loaded or approved message not present");
			BaseTest.takeScreenshot();
		}
		threadSleep(ObjectRepository.wait5sec);
		driver.close();
		return approverMessage;
	}

	public OtpPage checkCommApprovedMsgSMS()
	{
		if (isDisplayed(WebmailRepository.webmail_page_communication_approvedmsg_SMS))
		{
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Page not loaded or approved message not present");
			BaseTest.takeScreenshot();
		}
		threadSleep(ObjectRepository.wait5sec);
		return this;
	}

	// Request for approve - click on make changes button email
	public OtpPage clickMakeChangesBtn()
	{
		if (isDisplayed(WebmailRepository.webmail_page_communication_makeChangesBtn))
		{
			clickElement(WebmailRepository.webmail_page_communication_makeChangesBtn);
		} else
		{
			BaseTest.takeScreenshot();
			BaseTest.getTest().log(Status.FAIL, "Make Changes button not appered");
		}
		return this;
	}

	// Request for approve - make changes comments enter and click make changes
	public OtpPage approvalMakeChangespage(String comment)
	{
		switchWindow();
		if (isDisplayed(WebmailRepository.webmail_page_communication_makeChangesComment))
		{
			sendValue(WebmailRepository.webmail_page_communication_makeChangesComment, comment);
			clickElement(WebmailRepository.webmail_page_communication_makeChangecommentbtn);
			threadSleep(ObjectRepository.wait5sec);

		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Page not loaded or changes field not present");
		}
		if (isDisplayed(WebmailRepository.webmail_page_communication_makechangesstatusmsg))
		{
			BaseTest.getTest().log(Status.INFO, "Make Changes success message displayed");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Make Changes success message not displayed");
			BaseTest.takeScreenshot();
		}
		threadSleep(ObjectRepository.wait5sec);
		driver.close();
		return this;
	}
	// ******************************************************************************************************************************

	// Get webmail OTP from mail -- [Resulticks] - OTP)]
	public String getWebmailOTP()
	{
		String otp = null;
		if (emailBlastCheck("Marketing star - Login OTP"))
		{
			otp = getStrText(WebmailRepository.webmail_page_otp_read_otp);
		}
		return otp;
	}

	public String getWebmailOTPforInvalidAudienceDownload()
	{
		String otp = null;
		if (emailBlastCheck("[RESUL] - OTP for Invalid CSV download"))
		{
			otp = getStrText(WebmailRepository.webmail_page_otp_read_otp);
			webMailDelete();
		}
		return otp;
	}

	public String getWebmailInvalidAudienceDownloadLink(String listName)
	{
		String getLink = null;
		if (emailBlastCheck("[Resul] - " + listName + " - Synchistoryinvalid Download"))
		{
			getLink = getTextBoxVal(AudienceRepository.targetListDownloadLink, "href");
		}
		return getLink;
	}

	//
	public String getWebmailOTPforTargetListDownload()
	{
		String otp = null;
		if (emailBlastCheck("[RESUL] - OTP for Target list download"))
		{
			otp = getStrText(WebmailRepository.webmail_page_otp_read_otp);
			webMailDelete();
		}
		return otp;
	}

	public String getWebmailOTPforDetailedAnalytics()
	{
		String otp = null;
		// Issue in subject line re correct the code once issue got fixed
		if (emailBlastCheck("[RESUL] - Activate your Account"))
		{
			otp = getStrText(WebmailRepository.webmail_page_otp_read_otp);
			webMailDelete();
		}
		return otp;
	}

	public String getWebmailOTPforFormDownload(String formName)
	{
		String otp = null;
//		if (emailBlastCheck("[Resulticks] - OTP-" + formName))
		if (emailBlastCheck("[RESUL] - OTP for Form download"))
		{
			otp = getStrText(WebmailRepository.webmail_page_otp_read_otp);
		}
		return otp;
	}

	public String getWebmailOTPDataCatalogueDownload()
	{
		String otp = null;
//		if (emailBlastCheck("[Resulticks] - OTP-" + formName))
		if (emailBlastCheck("[RESUL] - OTP for data catalogue logs download"))
		{
			otp = getStrText(WebmailRepository.webmail_page_otp_read_otp);
		}
		return otp;
	}

	public String getWebmailFormsDownloadLink(String targetListName)
	{
		String getLink = null;
		if (emailBlastCheck("[Resulticks] -"))
		{
			getLink = getTextBoxVal(AudienceRepository.targetListDownloadLink, "href");
		}
		return getLink;
	}

	public OtpPage clickWebmailAudienceDownloadLink()
	{
		if (emailBlastCheck("[RESUL] - Audience Download"))
		{
			String link = "AudienceDownload mail,link,Click here to access your download";
			explicitwaitforclick(autolocator(link), 20);
			clickElement(link);
		}
		return this;
	}

	public String getWebmailTargetlistDownloadLink(String targetListName)
	{
		String getLink = null;
		if (emailBlastCheck("[Resul] - " + targetListName + " - Audience Download"))
		{
			getLink = getTextBoxVal(AudienceRepository.targetListDownloadLink, "href");
		}
		return getLink;
	}

	public String getWebmailTargetlistAdvanceDetailsDownloadLink()
	{
		String getLink = null;
		if (emailBlastCheck("[Resul] - " + BaseTest.getData().TargetListNew + " - Analytics Download"))
		{
			getLink = getTextBoxVal(AudienceRepository.targetListDownloadLink, "href");
		}
		return getLink;
	}

	public String clickWebmailCommunicationStatusDownloadLink()
	{
		String link = null;
		if (emailBlastCheck("Marketing star - Download CSV"))
		{
			link = AnalyticsRepository.analytics_mail_DownloadCSV;
			explicitwaitforclick(autolocator(link), 20);
			clickElement(link);
		}
		return getTextBoxVal(link, "href");
	}

	public String clickWebmailDataAttributesDownloadLink()
	{
		String link = null;
		if (emailBlastCheck("[Resulticks] - Data catalogue reports logs download"))
		{
			link = getTextBoxVal(PreferencesRepository.preferences_dataattribute_selectwebmaillink, "href");
			threadSleep(ObjectRepository.wait3sec);
		}
		return link;
	}

	public String getWebmailOTPforAdvanceDetail()
	{
		String otp = null;
		if (emailBlastCheck("[Resulticks] - OTP for Segmentation advanced details"))
		{
			otp = getStrText(WebmailRepository.webmail_page_otp_read_otp);
		}
		return otp;
	}

	public Map<String, String> getNewUserCredentials()
	{
		Map<String, String> credentials = new LinkedHashMap<>();
		if (emailBlastCheck("Marketing star - Sign-in to your account"))
		{
			List<WebElement> headers, value;
			headers = findElements("Credentials,xpath,(//div[@id='messagebody']//table)[6]//td[1]");
			value = findElements("Credentials,xpath,(//div[@id='messagebody']//table)[6]//td[1]");
			for (int i = 0; i < headers.size(); i++)
			{
				String name = headers.get(i).getText().replaceAll("[^a-zA-Z ]", "").trim();
				String data = value.get(i).getText().trim();
				credentials.put(name, data);
			}
		}
		return credentials;
	}

	public String getWebmailNotificationMessage(String commname)
	{
		String notificationmsg = null;
		if (emailBlastCheck(": Status notification (" + commname + ")"))
		{
			notificationmsg = getStrText(WebmailRepository.webmail_page_communication_notificationmessage);
		}
		return notificationmsg;
	}

	public String getAdvanceDetailsDownloadLink(String targetListName)
	{
		String getLink = null;
		if (emailBlastCheck("[Resulticks] - " + targetListName + " - Segmentation advanced details download"))
		{
			getLink = getTextBoxVal(AudienceRepository.targetListDownloadLink, "href");
		}
		return getLink;
	}

	public String getTargetListRFAApprovalMailLink(String targetListName)
	{
		String link = null;
		if (rfaCheckExactMail("Request for approval Target list", targetListName))
		{
			threadSleep(ObjectRepository.wait3sec);
			explicitwaitforclick(autolocator(WebmailRepository.audience_target_textview), 30);
			clickElement(WebmailRepository.audience_target_textview);
			threadSleep(ObjectRepository.wait3sec);
			explicitwaitforpresence(autolocator(WebmailRepository.audience_target_selectlink), 30);
			link = getStrText(WebmailRepository.audience_target_selectlink);
			BaseTest.getTest().log(Status.INFO, "Approver link : " + link);
		}
		return link;
	}

	public String getDynamicListRFAApprovalMailLink(String dynamicListName)
	{
		String link = null;

		if (rfaCheckExactMail("Request for approval Dynamic list", dynamicListName))
		{
			threadSleep(ObjectRepository.wait10sec);
			explicitwaitforclick(autolocator(WebmailRepository.audience_target_textview), 30);

			clickElement(WebmailRepository.audience_target_textview);
			explicitwaitforpresence(autolocator(WebmailRepository.audience_target_selectlink), 30);
			link = getStrText(WebmailRepository.audience_target_selectlink);
			BaseTest.getTest().log(Status.INFO, "Approver link : " + link);
		}
		threadSleep(ObjectRepository.wait3sec);
		return link;
	}

	public OtpPage webMailDelete()
	{
		BaseTest.takeScreenshot();
		explicitwaitforvisibility(autolocator(WebmailRepository.webmail_page_mail_delete), 10);
		clickElement(WebmailRepository.webmail_page_mail_delete);
		threadSleep(ObjectRepository.wait5sec);
		return this;
	}

	public OtpPage gMailDelete()
	{
		BaseTest.takeScreenshot();
		explicitwaitforvisibility(autolocator(WebmailRepository.webmail_page_mail_delete), 10);
		clickElement(WebmailRepository.webmail_page_mail_delete);
		threadSleep(ObjectRepository.wait5sec);
		return this;
	}

	public OtpPage clickWebmailFormDownloadLink(String formName)
	{
		// String formName1 = formName.trim().replaceAll(" ", "_").trim();
		String subjectLine = "[Resulticks]-" + formName + "-Form Audience Download";

		if (emailBlastCheck(subjectLine))
		{
			String link = "Form download link,link,Click here to access your download";
			explicitwaitforclick(autolocator(link), 20);
			clickElement(link);
		}
		return this;
	}

	public OtpPage clickCommunicationRFAMail(String commname)
	{
		String link = "Request For Approval (" + commname + ")";
		// System.out.println(link);
		if (emailBlastCheck(link))
		{
			BaseTest.getTest().log(Status.INFO, "Request for approval mail opened:" + link);
		}
		return this;
	}

	public OtpPage rfaWebMailSubject(String channelType)
	{
		String rfaCommName = getStrText(WebmailRepository.webmail_page_communication_rfamailsubjectcommname);
		if (rfaCommName.equalsIgnoreCase(communicationName))
		{
			BaseTest.getTest().log(Status.INFO, "Rfa Web mail and blast communication name equals " + rfaCommName);
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Blasted communication rfa mail name differs");
			BaseTest.takeScreenshot();
		}
		if (channelType.equalsIgnoreCase("email"))
		{
			String rfaSubjectline = getStrText(WebmailRepository.webmail_page_communication_rfamailsubjectline);
			if (rfaSubjectline.contains(communicationName))
			{
				BaseTest.getTest().log(Status.INFO, "Rfa Web mail subject line and blast communication subject line equals " + rfaSubjectline);
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Blasted communication rfa mail subjectline differs");
				BaseTest.takeScreenshot();
			}
			if (rfaSubjectline.contains(subjectlineemoji))
			{
				BaseTest.getTest().log(Status.INFO, "Rfa Web mail subject line contains only specified special characters.");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Blasted communication rfa mail subjectline has other special characters.");
				BaseTest.takeScreenshot();
			}

		}
		String rfatotalAudience = getStrText(WebmailRepository.webmail_page_communication_rfamailaudiencecount);
		if (rfatotalAudience.equals(audienceCount))
		{
			BaseTest.getTest().log(Status.INFO, "Blasted communication rfa mail audience count equals and the count is " + rfatotalAudience);
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Blasted communication rfa mail audience count differs");
			BaseTest.takeScreenshot();
		}
		/*
		 * String rfaScheduleDateFromMail = getStrText(ObjectRepository.webmail_page_campaign_rfamailscheduledate); SimpleDateFormat simpleDate = new
		 * SimpleDateFormat("E,dd MMM,yyyy HH:mm"); try { Date date = simpleDate.parse(rfaScheduleDateFromMail); String rfanewMailDateformat = new
		 * SimpleDateFormat("dd MMM, yyyy HH:mm").format(date); if (channelType.equalsIgnoreCase("email")) { if
		 * (rfanewMailDateformat.equals(captureEmailScheduleDate)) { BaseTest.getTest().log(Status.INFO,
		 * "Blasted campaign rfa Email Schedule date equals " + rfanewMailDateformat); } else { BaseTest.getTest().log(Status.FAIL,
		 * "Blasted campaign rfa Schedule date differs"); BaseTest.takeScreenshot(); } } if (channelType.equalsIgnoreCase("sms")) { if
		 * (rfanewMailDateformat.equals(captureSmsScheduleDate)) { BaseTest.getTest().log(Status.INFO,
		 * "Blasted campaign rfa Sms Schedule date equals " + rfanewMailDateformat); } else { BaseTest.getTest().log(Status.FAIL,
		 * "Blasted campaign rfa Schedule date differs"); BaseTest.takeScreenshot(); } } } catch (Exception e) { System.out.println(e); }
		 */
		return this;
	}

	public OtpPage emailTestPreview()
	{
		explicitwaitforvisibility(autolocator(WebmailRepository.webmail_Inbox_subjLine), 10);
		String subjectline = getStrText(WebmailRepository.webmail_Inbox_subjLine);
		if (subjectline.contains("=> Preview"))
		{
			BaseTest.getTest().log(Status.INFO, "Received mail subjectline has \" => Preview \" Icon present");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Received mail subjectline \" => Preview \" Icon not present");
		}
		javaScriptHighLightwithScrnShot(WebmailRepository.webmail_Inbox_subjLine);
		return this;
	}

	// template verify
	public OtpPage blastEmailVerifyTemplate()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("Webmail Template PAGE", ExtentColor.BLUE));
		String TemplateText = getStrText(WebmailRepository.communicationblast_Template);
		if (TemplateText.equalsIgnoreCase(BaseTest.getData().TemplateText))
		{
			BaseTest.getTest().log(Status.PASS, "Received mail template Custom text is same as uploaded");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Received mail template is not same as uploaded");
			BaseTest.takeScreenshot();
		}
		driver.close();
		switchWindow();
		return this;

	}

	// common method for email view in browser, ff and unsub
	public OtpPage blastEmaillinksVerify()
	{
		if (!BaseTest.method_name.get().toLowerCase().contains("trigger"))
		{
//			if (isElementPresent("Allow button,xpath,//span[@class='boxbuttons']"))
//			{
//				actionsClickElement("Allow button,xpath,//span[@class='boxbuttons']");
//				threadSleep(ObjectRepository.wait2sec);
//			}
			if (isDisplayed(WebmailRepository.communicationblast_viewinbrowser))
			{
				clickElement(WebmailRepository.communicationblast_viewinbrowser);
				threadSleep(ObjectRepository.wait1sec);
				switchWindow();
				BaseTest.takeScreenshot();
				javaScriptScrollDown();
				threadSleep(ObjectRepository.wait1sec);
				if (!communicationName.toLowerCase().contains("text"))
				{
					clickElement(CommunicationRepository.communicationpage_EDM_link);
					switchWindow();
					threadSleep(ObjectRepository.wait3sec);
					BaseTest.takeScreenshot();
					BaseTest.getTest().log(Status.INFO, "Email View in Browser is accessible");
					driver.close();
					switchWindow();
				}
				BaseTest.getTest().log(Status.INFO, "Email View in Browser is accessible");
			}

			if (isDisplayed(WebmailRepository.communicationblast_forward))
			{
				if (!findElements(CommunicationRepository.communicationpage_EDM_link).isEmpty())
				{
					clickElement(CommunicationRepository.communicationpage_EDM_link);
					switchWindow();
					threadSleep(ObjectRepository.wait2sec);
					pageLoaderLogo();
					BaseTest.takeScreenshot();
					driver.close();
					switchWindow();
				}

				clickElement(WebmailRepository.communicationblast_forward);
				threadSleep(ObjectRepository.wait3sec);
				if (isDisplayed(WebmailRepository.communicationblast_verifyforward))
				{
					BaseTest.getTest().log(Status.INFO, "Able to access Forward to friend link successfully");
					driver.navigate().back();
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "Forward to friend link or page is not accessible");
					BaseTest.takeScreenshot();
					driver.navigate().back();
				}
				threadSleep(ObjectRepository.wait1sec);
				javaScriptScrollDown();
				clickElement(WebmailRepository.communicationblast_selectunsub);
				threadSleep(ObjectRepository.wait1sec);
				if (isDisplayed(WebmailRepository.communicationblast_verifyunsub))
				{
					BaseTest.getTest().log(Status.INFO, "Able to access UnSubscription page link Successfully");
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "UnSubscription link or page is not accessible");
					BaseTest.takeScreenshot();
				}
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Email View in browser link or page access failed");
			}
			driver.close();
			switchWindow();
		}
		javaScriptScrollDown();
		clickElement(WebmailRepository.communicationblast_forward);
		threadSleep(ObjectRepository.wait3sec);
		switchWindow();
		if (isDisplayed(WebmailRepository.communicationblast_verifyforward))
		{
			BaseTest.getTest().log(Status.INFO, "Able to access Forward to Friend link Successfully");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "forward to friend link or page is not accessible");
			BaseTest.takeScreenshot();
		}
		threadSleep(ObjectRepository.wait3sec);
		driver.close();
		switchWindow();
		javaScriptScrollDown();
		clickElement(WebmailRepository.communicationblast_selectunsub);
		switchWindow();
		threadSleep(ObjectRepository.wait2sec);
		if (isDisplayed(WebmailRepository.communicationblast_verifyunsub))
		{
			BaseTest.getTest().log(Status.INFO, "Able to access unSubscription page link Successfully");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Unsubscription link or page is not accessible");
			BaseTest.takeScreenshot();
		}
		driver.close();
		switchWindow();
		return this;
	}

	public boolean afterForwardtofriend(String mymail, String frndmail, String frndmailpass)
	{
		webURLlaunch();
		String[] fmails = frndmail.split(",");
		String fmail1 = fmails[0];
		webmailLogin(fmail1, frndmailpass);
		String[] mail = mymail.split("@");
		String myname = mail[0];
		webmailInboxClick();
		BaseTest.getTest().log(Status.INFO, "checking forwarded mail recevied or not");
		emailBlastCheck("FW:" + myname);
		return false;

	}

	public OtpPage loginGmail(String username, String password)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("G-MAIL LOGIN PAGE", ExtentColor.BLUE));
		getWebURL(System.getProperty("GmailURL"));
		explicitwaitforclick(autolocator(WebmailRepository.gmail_AccountCreation_Signin), 30);
		clickElement(WebmailRepository.gmail_AccountCreation_Signin);
		explicitwaitforvisibility(autolocator(WebmailRepository.gmail_LoginPage_username), 20);
		BaseTest.takeScreenshot();
		enterValue(WebmailRepository.gmail_LoginPage_username, username);
		clickElement(WebmailRepository.gmail_LoginPage_NextButton);
		explicitwaitforvisibility(autolocator(WebmailRepository.gmail_LoginPage_password), 20);
		driver.findElement(autolocator(WebmailRepository.gmail_LoginPage_password)).sendKeys(password);
		clickElement(WebmailRepository.gmail_LoginPage_NextButton);
		javaScriptPageLoad();

		if (isElementPresent(WebmailRepository.gmail_LoginPage_NotNow))
		{
			clickElement(WebmailRepository.gmail_LoginPage_NotNow);
			javaScriptPageLoad();
		}
		return this;
	}

	public OtpPage enableGmailDevSetting()
	{
		explicitwaitforvisibility(autolocator(WebmailRepository.gmail_InboxMenue), 30);
		clickElement(WebmailRepository.gmail_Inbox_settings);
		threadSleep(ObjectRepository.wait5sec);
		clickElement(WebmailRepository.gmail_Inbox_allSettings);
		explicitwaitforclick(autolocator(WebmailRepository.gmail_setting_dynamicMail), 20);
		javaScriptScrollIntoView(WebmailRepository.gmail_setting_dynamicMail);
		if (!isSelected(WebmailRepository.gmail_setting_dynamicMail))
		{
			clickElement(WebmailRepository.gmail_setting_dynamicMail);
		}
		clickElement(WebmailRepository.gmail_Inbox_developerSettings);
		explicitwaitforclick(autolocator(WebmailRepository.gmail_setting_AMPcheckbox), 20);
		if (!isSelected(WebmailRepository.gmail_setting_AMPcheckbox))
		{
			clickElement(WebmailRepository.gmail_setting_AMPcheckbox);
		}
		String senderId = getTextBoxVal(WebmailRepository.gmail_setting_dynamic_SenderMailID, "value");
		if (senderId.isEmpty())
		{
			enterValue(WebmailRepository.gmail_setting_dynamic_SenderMailID, System.getProperty("senderMailId"));
		}
		clickElement(WebmailRepository.gmail_setting_saveButton);
		explicitwaitforclick(autolocator(WebmailRepository.gmail_InboxMenue), 10);
		clickElement(WebmailRepository.gmail_InboxMenue);
		return this;
	}

	public boolean gmailBlastCheck(String content)
	{
		javaScriptPageLoad();
		explicitwaitforclick(autolocator(WebmailRepository.gmail_InboxMenue), 30);
		clickElement(WebmailRepository.gmail_Inbox_MoreMenue);
		clickElement(WebmailRepository.gmail_Inbox_Allmails);
		String subjectline = "Subjectline,xpath," + "//span[contains(.,'" + content + "')]/child::span";

		boolean flag = false;
		for (int i = 1; i <= 6; i++)
		{
			try
			{
				explicitwaitforvisibility(autolocator(subjectline), 30);
				threadSleep(ObjectRepository.wait5sec);
				String inbox = getStrText(subjectline);

				if (inbox.contains(content))
				{
					clickElement(subjectline);
					explicitwaitforvisibility(autolocator(WebmailRepository.gmail_Inbox_subjLine), 30);
					emailSubjectLineBlastText = getStrText(WebmailRepository.gmail_Inbox_subjLine);

					// when a mail has received in Spam
					if (isElementPresent(WebmailRepository.gmail_Spam_NotaSpamButton))
					{
						BaseTest.getTest().log(Status.WARNING, inbox + " : Mail has received in spam");
						clickElement(WebmailRepository.gmail_Spam_NotaSpamButton);
						clickElement(WebmailRepository.gmail_Inbox_Allmails);
						continue;
					}

					flag = true;
					break;
				}
			} catch (Exception e)
			{
				driver.navigate().refresh();
				flag = false;
			}
			// Check whether mail was received in Spam
			if (i == 3)
			{
				clickElement(WebmailRepository.gmail_Inbox_MoreMenue);
				clickElement(WebmailRepository.gmail_Inbox_spam);
				threadSleep(ObjectRepository.wait3sec);
			}
		}
		if (flag)
		{
			BaseTest.getTest().log(Status.INFO, content + " :Mail received, Mail is present in inbox");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, content + " : Mail not received");
			BaseTest.takeScreenshot();
		}
		return flag;
	}

	public String getLoginWebmailOTP()
	{
		String otp = null;
		if (emailBlastCheck("Marketing star - Login OTP"))
		{
			otp = getStrText(WebmailRepository.webmail_page_otp_read_otp);
		}
		return otp;
	}

	public String getChangePswdOTP()
	{
		String otp = null;
		if (emailBlastCheck("[RESUL] - OTP"))
		{
			otp = getStrText(WebmailRepository.webmail_page_otp_read_otp);
		}
		return otp;
	}

	// Account Setup - SignUp - OTP
	public String getSignUpOTP()
	{
		String otp = null;
		if (emailBlastCheck("[RESUL] - OTP"))
		{
			otp = getStrText(WebmailRepository.webmail_page_otp_read_otp);
		}
		return otp;
	}

	// Account Setup - Authorization Code
	public String getAuthorizationCode()
	{
		String otp = null;
		if (emailBlastCheck("RESUL - Invoice Authentication code"))
		{
			otp = getStrText(WebmailRepository.webmail_page_authourization);
		}
		return otp;
	}

	// Account Setup - RESUL License key
	public String getLicenseKey(String client)
	{
		String licenseKey = null;
		if (emailBlastCheck("[RESUL] - License key for account activation - " + client))
		{
			licenseKey = getStrText(WebmailRepository.webmail_page_licenseKey);
		}
		return licenseKey;
	}

	// Account Setup - Account Activation Mail
	public boolean accountSetupActivation()
	{
		if (emailBlastCheck("Congrats on activating your account!"))
		{
			return isDisplayed(AccountSetupRepository.accountsetup_activation_msg);
		}
		return false;
	}

	// Get forget password OTP
	public String getNewPassword()
	{
		String newPassword = null;
		if (emailBlastCheck("[RESUL] - Password Reset Request - New Password Generated"))
		{
			newPassword = getStrText(WebmailRepository.webmail_forgetpassword);
		}
		return newPassword;
	}

	public void emailBlastSubjectLineValidate(String emailSubject)
	{
		if (emailBlastCheck(emailSubject))
		{
			String blastText = emailSubjectLineBlastText.toLowerCase().trim();
			if (!blastText.contains(System.getProperty("Persona_1_Value").toLowerCase().trim()))
			{
				BaseTest.getTest().log(Status.WARNING, System.getProperty("Persona_1") + " personalisation is different in blasted mail");
			}
			System.out.println(System.getProperty("Persona_1_Value").toLowerCase().trim());
			if (!blastText.contains(System.getProperty("Persona_5_Value").toLowerCase()))
			{
				BaseTest.getTest().log(Status.WARNING, System.getProperty("Persona_4") + " personalisation is different in blasted mail");
			}
			BaseTest.getTest().log(Status.INFO, "Subject line: " + blastText);
		}
	}

	// Account Setup web-mail login
	public OtpPage accountSetupWebmailLogin(String emaiId)
	{
		String password = System.getProperty(emaiId);
		webmailLoginaccountsetup(emaiId, password);
		return this;
	}

	public OtpPage fallBackAMPEdm()
	{
		String parent = parentWinHandle();
		if (!isElementPresent(WebmailRepository.gmail_AMPEdm_dynamicMail_icon))
		{
			BaseTest.getTest().log(Status.INFO, "Dynamic Icon hasn't present for FallBack mail");
			BaseTest.takeScreenshot();
			if (isElementPresent(WebmailRepository.gmail_AMPEdm_Carousel) || isElementPresent(WebmailRepository.gmail_AMPEdm_Accordion))
			{
				BaseTest.getTest().log(Status.INFO, "Received mail --> FallBack-EDM ");
				clickElement(WebmailRepository.gmail_AMPEdm_connectButton);
				switchWindow();
				javaScriptPageLoad();
				BaseTest.takeScreenshot();
				childWindowClose(parent);
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Received mail has contains : AMP-EDM");
				BaseTest.takeScreenshot();
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Fallback html mail Dynamic Icon has present");
			BaseTest.takeScreenshot();
		}
		return this;
	}
}
