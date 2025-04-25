package pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.microsoft.playwright.Page;

import repository.AccountSetupRepository;
import repository.DashboardRepository;
import repository.LoginRepository;
import repository.ObjectRepository;
import utility.BaseTest;
import utility.PW_PageBase;
import utility.PageBase;
import utility.PageFactory;

public class LoginPage extends PW_PageBase
{

	public LoginPage(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	public LoginPage openLoginPage()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("RESUL 5.0 - LOGIN PAGE", ExtentColor.INDIGO));
		getWebURL(getLoginURL());
		BaseTest.getTest().log(Status.INFO, "<b> Environment URL : </b>" + driver.getCurrentUrl());
		return this;
	}

	public LoginPage pw_openLoginPage()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("RESUL 5.0 - LOGIN PAGE", ExtentColor.INDIGO));
		pw_launchUrl(getLoginURL());
		return this;
	}

//	public void getToolResponse(String browser)
//	{
//		if (browser.contains("chrome"))
//		{
//			DevTools devTools = ((HasDevTools) driver).getDevTools();
//			devTools.createSession();
//			devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//			devTools.send(Network.setCacheDisabled(true));
//			devTools.addListener(Network.responseReceived(), response -> {
//				String url = response.getResponse().getUrl();
//				int status = response.getResponse().getStatus();
//				String type = response.getType().toString();
//				// Ignore preflight responses
//				if (type.equals("Preflight"))
//				{
//					Map<String, String> map = new LinkedHashMap<>();
//					try
//					{
//						map.put("URL", url);
//						map.put("Status", String.valueOf(status));
//						String responseBody = devTools.send(Network.getResponseBody(response.getRequestId())).getBody();
//						map.put("Response Body", responseBody);
//						BaseTest.devList.add(map);
//					} catch (Exception e)
//					{
//						map.put("Response Body", "");
//						BaseTest.devList.add(map);
	//// BaseTest.getTest().log(Status.WARNING, "Failed to retrieve body for " + url + ": " + e.getMessage());

//					}
//				} else
//				{
	//// BaseTest.getTest().log(Status.INFO, "Preflight request ignored: " + url);
//				}
//			});
//		}
//
//	}

	public void clickAdBlocker()
	{
		try
		{
			explicitwaitforclick(autolocator(LoginRepository.login_proceed), 60);
			isElementAvailable(LoginRepository.login_pluginText);
			if (!getStrText(LoginRepository.login_pluginText).equals("Kindly disable all third party plugins installed in your browser and close additional browser tabs (if any) for a better browsing experience and to avoid network latency."))
			{
				BaseTest.getTest().log(Status.WARNING, "Plugin content validation failed");
			}
			clickElement(LoginRepository.login_proceed);
			explicitwaitforvisibility(autolocator(AccountSetupRepository.product_logo), 10);
			isElementAvailable(AccountSetupRepository.product_logo);
			BaseTest.takeScreenshot();
		} catch (Exception e)
		{
			BaseTest.getTest().log(Status.WARNING, "Plugin popup has not available in Resul 5.0 login page.");
			BaseTest.takeScreenshot();
		}
	}

	public LoginPage clickNewUser()
	{
		clickAdBlocker();
		BaseTest.getTest().info(MarkupHelper.createLabel(" RESUL 5.0 - NEW USER ", ExtentColor.INDIGO));
		if (isElementAvailable(AccountSetupRepository.accountsetup_newusertab))
		{
			clickElement(AccountSetupRepository.accountsetup_newusertab);
			isElementAvailable(AccountSetupRepository.accountsetup_enteremail);
			// isElementAvailable(AccountSetupRepository.accountsetup_captchavalue);
			isElementAvailable(AccountSetupRepository.accountsetup_agreetermsselect);
			if (!getTextBoxVal(AccountSetupRepository.accountsetup_clicksignupbutton, "class").contains("click-off"))
			{
				BaseTest.getTest().log(Status.FAIL, "<b>Sign-Up</b> button is active");
			} else
			{
				BaseTest.getTest().log(Status.PASS, "<b>Sign-Up</b> button is disabled, As expected");
			}
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public LoginPage clickExistingUser()
	{
		clickAdBlocker();
		BaseTest.getTest().info(MarkupHelper.createLabel(" RESUL 5.0 - EXISTING USER", ExtentColor.INDIGO));
		explicitwaitforvisibility(autolocator(AccountSetupRepository.product_logo), 20);
		isElementAvailable(AccountSetupRepository.product_logo);
		isElementAvailable(LoginRepository.loginpage_existinguser_link);
		isElementAvailable(AccountSetupRepository.accountsetup_newusertab);
		if (!getTextBoxVal(LoginRepository.loginpage_existinguser_link, "class").contains("active"))
		{
			BaseTest.getTest().log(Status.FAIL, "Existing user tab is not active");
		}
		clickElement(LoginRepository.loginpage_existinguser_link);
		return this;
	}

	public LoginPage enterUsername(String val)
	{
		// explicitwaitforvisibility(autolocator(AccountSetupRepository.product_logo), 10);
		if (isElementPresent(LoginRepository.loginpage_username_textbox))
		{
			enterValue(LoginRepository.loginpage_username_textbox, val);
			tabAction();
			javaScriptPageLoad();
		}

		return this;
	}

	public LoginPage enterPassword(String val)
	{
//		explicitwaitforvisibility(autolocator(AccountSetupRepository.product_logo), 10);
		if (isElementPresent(LoginRepository.loginpage_password_textbox))
		{
			findElement(LoginRepository.loginpage_password_textbox).sendKeys(val);
			BaseTest.getTest().log(Status.INFO, "Enter Password --->   *********");
		}
		return this;
	}

	public void clickPswdPreview()
	{
		javaScriptPageLoad();
		if (isElementAvailable(LoginRepository.loginpage_Login_passwordPreview))
		{
			clickElement(LoginRepository.loginpage_Login_passwordPreview);
			BaseTest.takeScreenshot();
		}
	}

	public HomePage clickLogin()
	{
		javaScriptPageLoad();
		explicitwaitforclick(autolocator(LoginRepository.loginpage_Login_btn), 20);
		pageLoaderLogo();
		clickElement(LoginRepository.loginpage_Login_btn);

		pageLoaderLogo();
		return getPageFactory().homePage();
	}

	public HomePage login(String username, String pwd)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel(" RESUL 5.0 - EXISTING USER ", ExtentColor.INDIGO));
		clickAdBlocker();
		enterUsername(username);
		enterPassword(pwd);
		clickLogin();
		BaseTest.takeScreenshot();
		pageLoaderLogo();
		return getPageFactory().homePage();
	}

	public HomePage login()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel(" RESUL 5.0 - EXISTING USER ", ExtentColor.INDIGO));
		clickAdBlocker();
		enterUsername(System.getProperty("UserName"));
		enterPassword(System.getProperty("Password"));
		clickLogin();
		BaseTest.takeScreenshot();
		pageLoaderLogo();
		return getPageFactory().homePage();
	}

	public HomePage loginWithoutPopup(String username, String pwd)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel(" RESUL 5.0 - EXISTING USER ", ExtentColor.INDIGO));
		explicitwaitforclick(autolocator(LoginRepository.loginpage_username_textbox), 120);
		pageLoaderLogo();
		enterUsername(username);
		enterPassword(pwd);
		clickLogin();
		BaseTest.takeScreenshot();
		pageLoaderLogo();
		return getPageFactory().homePage();
	}

	public HomePage accountsetuplogin(String username, String pwd)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel(" RESUL 5.0 - EXISTING USER ", ExtentColor.INDIGO));
		threadSleep(ObjectRepository.wait3sec);
		// clickAdBlocker();
		enterUsername(username);
		enterPassword(pwd);
		clickLogin();
		BaseTest.takeScreenshot();
		// pageLoaderLogo();
		return getPageFactory().homePage();
	}

	public HomePage loginwithoutplugin(String username, String pwd)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel(" RESUL 5.0 - EXISTING USER ", ExtentColor.INDIGO));
		threadSleep(ObjectRepository.wait2sec);
//		 clickAdBlocker();
		enterUsername(username);
		enterPassword(pwd);
		clickLogin();
		BaseTest.takeScreenshot();
		pageLoaderLogo();
		return getPageFactory().homePage();
	}

	public HomePage pw_login(String username, String pwd)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel(" RESUL 5.0 - EXISTING USER ", ExtentColor.INDIGO));
		pw_clickElement(LoginRepository.pw_login_proceed);
		pw_clickElement(LoginRepository.pw_loginpage_username_textbox);
		pw_enterValue(LoginRepository.pw_loginpage_username_textbox, username);
		page.keyboard().press("Tab");
		pw_clickElement(LoginRepository.pw_loginpage_password_textbox);
		page.fill(LoginRepository.pw_loginpage_password_textbox, pwd);
		BaseTest.getTest().log(Status.INFO, "Enter Password -> *********");
		pw_clickElement(LoginRepository.pw_loginpage_Login_btn);
		pw_pageLoaderLogo();
		return getPageFactory().homePage();
	}

	public void target_Dynamic_approver1_login()
	{
		String uname = System.getProperty("Target_Dynamic_approver1_Uname");
		String upswrd = System.getProperty("Target_Dynamic_approver1_pswrd");
		loginwithoutplugin(uname, upswrd);
	}

	public void target_Dynamic_approver2_login()
	{

		String uname = System.getProperty("Target_Dynamic_approver2_Uname");
		String upswrd = System.getProperty("Target_Dynamic_approver2_pswrd");
		login(uname, upswrd);
	}

	public void target_Dynamic_approver3_login()
	{
		String uname = System.getProperty("Target_Dynamic_approver3_Uname");
		String upswrd = System.getProperty("Target_Dynamic_approver3_pswrd");
		login(uname, upswrd);
	}

	public void loginPageContentValidation()
	{
		// explicitwaitforvisibility(autolocator(AccountSetupRepository.product_logo), 10);

		// Logo verification
		String productLogoUrl = getTextBoxVal(AccountSetupRepository.product_logo, "src");
		if (productLogoUrl.equals(System.getProperty("logoURL")))
		{
			BaseTest.getTest().log(Status.INFO, "Logo of <b RESUL /> appears on login page.");
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "The RESUL 5.0 logo has not been displayed on the login page.");
			BaseTest.takeScreenshot();
		}
		isElementAvailable(LoginRepository.loginpage_newusertab);

		// Remember me checkbox status verification
		if (isElementAvailable(LoginRepository.loginpage_rememberme_checkbox))
		{
			if (!isSelected(LoginRepository.loginpage_rememberme_checkbox))
			{
				BaseTest.getTest().log(Status.INFO, "Remember me checkbox appears on the login page as expected.");
			} else
			{
				BaseTest.getTest().log(Status.WARNING, "Remember me checkbox does not displayed as expected on the login page.");
				BaseTest.takeScreenshot();
			}
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Remember me checkbox does not displayed as expected on the login page.");
			BaseTest.takeScreenshot();
		}
		// forgot password status verification
		String forgetPasswordclassAttribute = getTextBoxVal(LoginRepository.loginpage_forgotpassword, "class");
		if (isDisplayed(LoginRepository.loginpage_forgotpassword))
		{
			if (!forgetPasswordclassAttribute.contains("off"))
			{
				BaseTest.getTest().log(Status.INFO, "Forgot password button displayed on the login page as expected.");
			} else
			{
				BaseTest.getTest().log(Status.WARNING, "Forgot password button does not displayed on the login page as expected.");
				BaseTest.takeScreenshot();
			}
		}

		// Sign in button status verification
		String signInButtonStatus = getTextBoxVal(LoginRepository.loginpage_Login_btn, "class");
		if (signInButtonStatus.contains("off"))
		{
			BaseTest.getTest().log(Status.INFO, "Sign in button is disabled as expected.");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Sign in button is enabled.");
		}
		clickElement(LoginRepository.loginpage_username_textbox);
		tabAction();
		clickElement(LoginRepository.loginpage_password_textbox);
		tabAction();
		uiPageEqualswithInputValue("Enter a valid business email address", getStrText(LoginRepository.loginpage_username_errormsg));
		uiPageEqualswithInputValue("Enter a valid password", getStrText(LoginRepository.loginpage_password_errormsg));
		BaseTest.takeScreenshot();
		getWebURL(getLoginURL());
	}

	public void enterWebmailOtpForLogin(String webmailOtp)
	{
		explicitwaitforclick(autolocator(LoginRepository.loginpage_otppage_cancelbtn), 20);
		enterValue(LoginRepository.loginpage_Webmailotp_textfield, webmailOtp).tabAction();
		explicitwaitforclick(autolocator(LoginRepository.loginpage_otppage_confirmbtn), 20);
		clickElement(LoginRepository.loginpage_otppage_confirmbtn);
		threadSleep(ObjectRepository.wait2sec);
		if (isElementPresent(DashboardRepository.homepage_recentcommunication_hearder))
		{
			BaseTest.getTest().log(Status.INFO, "Page logged in successfully");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Page has not logged in properly");
			BaseTest.takeScreenshot();
		}
	}

	public LoginPage enterLoginWebmailOtp()
	{

		if (isElementPresent(LoginRepository.loginpage_otppage))
		{
			explicitwaitforvisibility(autolocator(LoginRepository.loginpage_otppage), 20);
			OtpPage otpPage = new OtpPage(driver, page, pageFactory);
			String parentWinHandle = parentWinHandle();
			javaScriptopenNewWindow();
			switchWindow();
			otpPage.webURLlaunch();
			otpPage.accountUserWebmailLogin();
			loginOtp = otpPage.getLoginWebmailOTP();
			childWindowClose(parentWinHandle);
			switchParentWin(parentWinHandle);
			pageLoaderLogo();
			explicitwaitforvisibility(autolocator(LoginRepository.loginpage_otppage_textfield), 10);
			enterValue("Webmail " + LoginRepository.loginpage_otppage_textfield, loginOtp);
			tabAction();
			pageLoaderLogo();
			explicitwaitforclick(autolocator(LoginRepository.loginpage_otppage_confirmbtn), 20);
			String confirmButton = getTextBoxVal(LoginRepository.loginpage_otppage_confirmbtn, "class");
			threadSleep(ObjectRepository.wait3sec);
			if (!confirmButton.contains("off"))
			{
				BaseTest.getTest().log(Status.INFO, "Enter login by using Webmail OTP.");
				BaseTest.takeScreenshot();
				threadSleep(ObjectRepository.wait3sec);
				clickElement(LoginRepository.loginpage_otppage_confirmbtn);
				pageLoaderLogo();
				explicitwaitforvisibility(autolocator(DashboardRepository.homepage_dashboard_Dashboardlink), 20);
				isDisplayed(DashboardRepository.homepage_dashboard_Dashboardlink);
			} else
			{
				enterloginDefaultOtp();
			}
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Login OTP popup not came");
		}
		return getPageFactory().loginPage();
	}

	public void enterloginDefaultOtp()
	{
		if (isElementPresent(LoginRepository.loginpage_otppage_textfield))
		{
			explicitwaitforpresence(autolocator(LoginRepository.loginpage_otppage_textfield), 10);
			clickElement(LoginRepository.loginpage_otppage_textfield);
			clearField(LoginRepository.loginpage_otppage_textfield);
			enterValue("Default " + LoginRepository.loginpage_otppage_textfield, System.getProperty("Default_otp"));
			tabAction();
			pageLoaderLogo();
			explicitwaitforclick(autolocator(LoginRepository.loginpage_otppage_confirmbtn), 20);
			BaseTest.getTest().log(Status.INFO, "Enter login by using Default OTP.");
			BaseTest.takeScreenshot();
			clickElement(LoginRepository.loginpage_otppage_confirmbtn);
			threadSleep(ObjectRepository.wait3sec);
			pageLoaderLogo();
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Login OTP popup not came");
		}
	}

	public void invalidCredentialsScenarios()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("INVALID USERNAME AND VALID PASSWORD", ExtentColor.INDIGO));
		enterUsername(System.getProperty("invalidusername"));
		enterPassword(System.getProperty("TPassword"));
		boolean loginButtonEnalbed1 = isElementPresent("Sign in button state,xpath,//button[contains(.,'Sign In')][contains(@class,'click-off')]");
		writeLog(loginButtonEnalbed1, "System does not accept the Invalid mail and valid password as expected", "System accept the Invalid mail and valid password");
		removeText(LoginRepository.loginpage_username_textbox);
		removeText(LoginRepository.loginpage_password_textbox);

		BaseTest.getTest().info(MarkupHelper.createLabel("VALID USERNAME AND INVALID PASSWORD", ExtentColor.INDIGO));
		enterUsername(System.getProperty("TUsername"));
		enterPassword(System.getProperty("invalidpassword"));
		clickElement(LoginRepository.loginpage_Login_btn);
		uiPageEqualswithMultipleInputValue("Validation message,xpath,//div[contains(@class,'errorContainer')]//label[contains(.,'Password')]", "Login failed. Username or Password is incorrect");
		clearField(LoginRepository.loginpage_username_textbox);
		clearField(LoginRepository.loginpage_password_textbox);

		BaseTest.getTest().info(MarkupHelper.createLabel("INVALID USERNAME AND INVALID PASSWORD", ExtentColor.INDIGO));
		enterUsername(System.getProperty("invalidusername"));
		enterPassword(System.getProperty("invalidpassword"));
		boolean loginButtonEnalbed3 = isElementPresent("Sign in button state,xpath,//button[contains(.,'Sign In')][contains(@class,'click-off')]");
		writeLog(loginButtonEnalbed3, "System does not accept the Invalid mail and Invalid password as expected", "System accept the Invalid mail and Invalid password");
	}

	public void forgetPasswordScenarios()
	{
//		String[] emailDataSet = BaseTest.getData().enterEmail.split(",");
//		for (String username : emailDataSet)
		String username = "resuluser146@resul.team";
		{
			if (!AccountSetupCreation.isEmailThreadExist(username))
			{
				AccountSetupCreation.setAcctStpEmailID(username);
				clickForgetPassword(username);
				pageLoaderLogo();
				if (getTextBoxVal(LoginRepository.loginpage_enterRegisteredmail, "class").contains("required"))
				{
					BaseTest.getTest().log(Status.INFO, "The registered email address field for forget password is set to Mandatory as expected.");
				} else
				{
					BaseTest.getTest().log(Status.WARNING, "The registered email address field for forget password does not set to Mandatory");
					BaseTest.takeScreenshot();
				}
				boolean sendBtn = getTextBoxVal(LoginRepository.loginpage_requestnewpassword_sendbtn, "class").contains("click-off");
				writeLog(sendBtn, "Send button is disabled, As expected", "Send button is enabled without entering email id");
				pageLoaderLogo();
				BaseTest.takeScreenshot();
				enterValue(LoginRepository.loginpage_enterRegisteredmail, "").enterTabAction();
				uiPageEqualswithInputValue("Enter a valid business email address", getStrText(LoginRepository.loginpage_enterRegisteredmail + "/..//label"));

				// Verify with non-existing user
				enterValue(LoginRepository.loginpage_enterRegisteredmail, "autoresul" + addTimeToName().replace("_", "") + "@resul.team").tabAction();
				BaseTest.takeScreenshot();
				uiPageEqualswithInputValue("Email doesn't exist", getStrText(LoginRepository.loginpage_enterRegisteredmail + "/..//label"));
				clearField(LoginRepository.loginpage_enterRegisteredmail);

				// Valid Email ID
				enterValue(LoginRepository.loginpage_enterRegisteredmail, username).tabAction();
				clickElement(LoginRepository.loginpage_requestnewpassword_sendbtn);
				pageLoaderLogo();
				if (isDisplayed(LoginRepository.loginpage_requestnewpassword_popup))
				{
					char[] otpCode = getForgetPasswordOTP(username).toCharArray();
					if (otpCode != null)
					{
						int index = 0;
						for (WebElement input : findElements(LoginRepository.loginpage_forgetpswd_otpInput))
						{
							input.sendKeys(String.valueOf(otpCode[index]));
							index++;
						}
					}
				}
				isDisplayed(AccountSetupRepository.accountsetup_otpSucessMsg);
				clickConfirmBtn();
				// isDisplayed(LoginRepository.loginpage_forgetpswd_successMsg);
				// break;
			} else
			{
				clearField(AccountSetupRepository.accountsetup_enteremail);
			}
		}
	}

	public String getForgetPasswordOTP(String emailId)
	{
		String parentWindow = parentWinHandle();
		javaScriptopenNewWindow();
		switchWindow();
		OtpPage otpObj = getPageFactory().otpPage();
		String forgetPassWordOTP = otpObj.webURLlaunch().accountSetupWebmailLogin(emailId).getSignUpOTP();
		switchParentWin(parentWindow);
		return forgetPassWordOTP;
	}

	public String getNewPasswordFromMail()
	{
		String parentWindow = parentWinHandle();
		switchWindow();
		clickElement(LoginRepository.login_itkt_inbox_icon);
		String newPassword = getPageFactory().otpPage().getNewPassword();
		BaseTest.getWebDriver().close();
		switchParentWin(parentWindow);
		return newPassword;
	}

	public LoginPage copyRightLinks()
	{
		BaseTest.getTest().info(MarkupHelper.createLabel(" FOOTER HYPER LINKS ", ExtentColor.INDIGO));
		String[] values = { "Copyright ©", "Privacy policy", "Terms & Conditions", "Help" };
		javaScriptScrollDown();
		if (isDisplayed(LoginRepository.loginpage_copyrigtLinks))
		{
			List<WebElement> links = findElements(LoginRepository.loginpage_copyrigtLinks);
			for (int i = 0; i < links.size(); i++)
			{
				String link = links.get(i).getText().trim().split("\\R")[0];
				javaScriptHighLightElement(links.get(i));
				if (link.contains("Copyright"))
				{
					String year = calendarSchedduleDate(0, "yyyy");
					if (link.contains(year) && links.get(i).isDisplayed())
					{
						BaseTest.getTest().log(Status.INFO, link + " is displayed, As expected.");
					} else
					{
						BaseTest.getTest().log(Status.FAIL, "Copyrights link not displayed.");
						BaseTest.takeScreenshot();
					}
				} else
				{
					BaseTest.getTest().info(MarkupHelper.createLabel("FOOTER HYPER LINKS - " + link.toUpperCase(), ExtentColor.INDIGO));
					uiPageEqualswithInputValue(values[i], link);
					String pwind = parentWinHandle();
					links.get(i).click();
					switchWindow();
					explicitwaitforvisibility(PageBase.autolocator(LoginRepository.loginpage_copyrigt_headername), 30);
					pageLoaderLogo();
					threadSleep(ObjectRepository.wait3sec);
					if (isDisplayed(link + LoginRepository.loginpage_copyrigt_headername))
					{
						childWindowClose(pwind);
					}
				}
			}
		}
		return this;

	}

	public LoginPage clickConfirmBtn()
	{
		if (isEnabled(LoginRepository.loginpage_otppage_confirmbtn))
		{
			clickElement(LoginRepository.loginpage_otppage_confirmbtn);
		}
		return this;
	}

	public LoginPage clickCancelBtn()
	{
		if (isEnabled(LoginRepository.loginpage_otppage_cancelbtn))
		{
			clickElement(LoginRepository.loginpage_otppage_cancelbtn);
		}
		return this;
	}

	public LoginPage clickForgetPassword(String username)
	{
		explicitwaitforclick(autolocator(LoginRepository.loginpage_username_textbox), 30);
		if (isElementPresent(LoginRepository.loginpage_username_textbox))
		{
			enterUsername(username).tabAction();
			clickElement(LoginRepository.loginpage_forgotpassword);
			AccountSetupCreation.setNewUserID(username);
		}
		return this;
	}

	public void clearLoginOtp()
	{
		String invalidOTP1 = "111111";
		List<WebElement> elements = findElements(",xpath,//div[@id='otp']//input");
		for (int i = 0; i < elements.size(); i++)
		{
			elements.get(i).sendKeys(String.valueOf(invalidOTP1.charAt(i)));
			elements.get(i).sendKeys(Keys.BACK_SPACE);
		}
		elements.get(0).sendKeys(Keys.BACK_SPACE);
	}

}
