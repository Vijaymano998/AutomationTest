package regression_AccountSetup;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.AccountSetupCreation;
import pages.HomePage;
import repository.AccountSetupRepository;
import repository.LoginRepository;
import utility.BaseTest;

public class LoginScenarios extends BaseTest
{

	@Test(testName = "RESUL-5.0-001", description = "Login with valid username and password")
	public void loginWithValidCredentials()
	{
		HomePage login = getPageFactory().homePage();

		login.clickAdBlocker();
		login.loginPageContentValidation();
		login.login(login.dPropertyLoginUserName(), login.dPropertyLoginPswrd());
		login.selectbusinessunit();
	}

	@Test(testName = "RESUL-5.0-003", description = "Existing user forgot password")
	public void forgetPasswordByExistingUser()
	{
		AccountSetupCreation login = getPageFactory().acctSetupPage();

		login.clickAdBlocker();
		login.forgetPasswordScenarios();
		String newPassword = login.getNewPasswordFromMail();
		login.enterUsername(AccountSetupCreation.getAcctStpEmailID());
		login.enterPassword(newPassword);
		login.clickPswdPreview();
		login.clickLogin();
		login.newAccountLaunchPad();

	}

	@Test(testName = "RESUL-5.0-002", description = "Login Page - Negative Scenarios")
	public void loginPage_NegativeScenario()
	{
		HomePage login = getPageFactory().homePage();
		String testData = System.getProperty("Max_Character");
		login.clickAdBlocker();
		login.enterValue(LoginRepository.loginpage_username_textbox, "").tabAction();
		login.uiPageEqualswithInputValue("Enter a valid business email address", login.getStrText(AccountSetupRepository.accountsetup_mailmsg));
		login.enterValue(LoginRepository.loginpage_password_textbox, "").tabAction();
		login.uiPageEqualswithInputValue("Enter a valid password", login.getStrText(LoginRepository.loginpage_password_textbox + "/..//label"));
		takeScreenshot();
		login.enterUsername(testData);
		login.uiPageEqualswithInputValue("Please enter characters below 100 characters", login.getStrText(AccountSetupRepository.accountsetup_mailmsg));
		login.removeText(LoginRepository.loginpage_username_textbox);
		login.enterUsername(System.getProperty("TUsername").replace(".team", ""));
		login.uiPageEqualswithInputValue("Enter a valid business email address", login.getStrText(AccountSetupRepository.accountsetup_mailmsg));
		login.removeText(LoginRepository.loginpage_username_textbox);
		login.enterUsername(getData().enterEmail);
		login.uiPageEqualswithInputValue("Invalid domain name", login.getStrText(AccountSetupRepository.accountsetup_mailmsg));
		login.clearField(LoginRepository.loginpage_username_textbox);
		login.checkInputBoxLength(LoginRepository.loginpage_password_textbox, testData, 15);
		login.invalidCredentialsScenarios();
	}

	@Test(testName = "MKS-TS-EXTUSR-002", description = "Forget Password Negative Scenario")
	public void forgetPassword_NegativeScenario()
	{
		HomePage login = getPageFactory().homePage();

		login.clickAdBlocker();

		// Verify Forget Password link w/o Email
		login.clickForgetPassword("");
		if (login.isElementPresent(LoginRepository.loginpage_forgetPswd_Poppup))
		{
			BaseTest.getTest().log(Status.FAIL, "Forget password link navigating W/O Email-ID");
			takeScreenshot();
		}

		// Verify Forget Password link invalid Email
		login.clickForgetPassword(System.getProperty("invalidusername"));
		if (login.isElementPresent(LoginRepository.loginpage_forgetPswd_Poppup))
		{
			BaseTest.getTest().log(Status.FAIL, "Forget password link navigating W/O Email-ID");
		}
		login.uiPageEqualswithInputValue("Email id does not exist.", login.getStrText(LoginRepository.loginpage_validationerr_msg1));
		takeScreenshot();
		login.clearField(LoginRepository.loginpage_username_textbox);

		// Verify Forget Password link with Email
		String email = login.dPropertyForgetPswdUser();
		login.clickForgetPassword(email);
		if (login.isDisplayed(LoginRepository.loginpage_forgetPswd_Poppup))
		{
			// verify without Email ID
			login.clickElement(LoginRepository.loginpage_requestnewpassword_sendbtn);
			login.pageLoaderLogo();
			BaseTest.takeScreenshot();
			login.uiPageEqualswithInputValue(LoginRepository.loginpage_FrgtPswd_validation, "Enter a valid email ID");

			// Verify with Non-Existing email
			login.enterValue(LoginRepository.loginpage_enterRegisteredmail, BaseTest.getData().enterEmail);
			login.tabAction();
			login.clickElement(LoginRepository.loginpage_requestnewpassword_sendbtn);
			login.pageLoaderLogo();
			login.uiPageEqualswithInputValue(LoginRepository.loginpage_FrgtPswd_validation, "Email ID doesn't exist");
			BaseTest.takeScreenshot();

			// Verify with Invalid Email
			login.clearField(LoginRepository.loginpage_enterRegisteredmail);
			String[] DataSet = getData().EnterNewEmail.split(",");
			for (int i = 0; i < DataSet.length; i++)
			{
				login.enterValue(LoginRepository.loginpage_enterRegisteredmail, DataSet[i]).tabAction();
				login.clickElement(LoginRepository.loginpage_requestnewpassword_sendbtn);
				if (login.isElementPresent(LoginRepository.loginpage_requestnewpassword_popup))
				{
					BaseTest.getTest().log(Status.FAIL, DataSet[i] + " -->  Invalid mail id accepting..");
					takeScreenshot();
				}
				login.clearField(LoginRepository.loginpage_enterRegisteredmail);
			}

			// verify with valid email
			login.enterValue(LoginRepository.loginpage_enterRegisteredmail, System.getProperty("Target_Dynamic_approver1_Uname"));
			login.tabAction();
			login.clickElement(LoginRepository.loginpage_requestnewpassword_sendbtn);
			login.pageLoaderLogo();
			if (login.isDisplayed(LoginRepository.loginpage_requestnewpassword_popup))
			{
				login.clickElement(LoginRepository.loginpage_requestnewpassword_closebtn);

				// Login with Invalid Password
				login.refresh();
				login.login(System.getProperty("Target_Dynamic_approver1_Uname"), login.dPropertyLoginPswrd());
				login.uiPageEqualswithInputValue(AccountSetupRepository.accountsetup_payment_validation_msg, "Login failed. User name or Password is incorrect.");
				takeScreenshot();
			}
		}
	}

	@Test(testName = "RESUL-5.0-002", description = "Validate Login Page - CopyRights links")
	public void validateLoginPage_CopyRightlinks()
	{
		HomePage login = getPageFactory().homePage();

		login.clickAdBlocker();
		login.copyRightLinks();
		login.refresh();
		login.login(login.dPropertyLoginUserName(), login.dPropertyLoginPswrd());
		login.selectbusinessunit();
		login.copyRightLinks();
	}
}
