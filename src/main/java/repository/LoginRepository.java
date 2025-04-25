package repository;

public class LoginRepository
{

	// Samuel
	public static final String login_proceed = "Plugin popup proceed,xpath,//button[.='Proceed']";
	public static final String login_pluginText = "Plugin popup content ,xpath,//div[contains(@class,'rs-overlay-content')]//h3";
	public static final String loginpage_newusertab = "New user tab,xpath,//span[.='New user']";
	public static final String loginpage_rememberme_checkbox = "Remember me checkbox,xpath,//input[@id='rememberme']/..";
	public static final String loginpage_forgotpassword = "Forgot password,xpath,//button[text()='Forgot password']";
	public static final String loginpage_username_textbox = "Login UserName,xpath,//input[contains(@class,'required')][@name='emailId']";
	public static final String loginpage_password_textbox = "Login Password,xpath,//input[contains(@class,'required')][@name='password']";
	public static final String loginpage_Login_passwordPreview = "Password preview,xpath,//*[contains(@class,'color-primary-grey icon-rs-eye')]";
	public static final String loginpage_Login_btn = "Sign In CTA,xpath,//button[.='Sign in']";
	public static final String loginpage_logout = "logout,xpath,//i[contains(@class,'logout')]";
	public static final String loginpage_username_errormsg = "Username error message,xpath,//input[@name='emailId']//..//label";
	public static final String loginpage_password_errormsg = "Password error message,xpath,//input[@name='password']//..//label";

	// ***********************************************************************
	// LOGIN PAGE
	public static final String loginpage_lostpassord_link = "Forgot password,link,Forgot password?";
	public static final String loginpage_incorrectcredential = "invalid credentials,xpath, //*[@id='errmsgLoginFailed']";
	public static final String Loginpage_meetpopup = "Meet Resul Popup,xpath, //*[@class='resul-close']";

	// WEBMAIL LOGIN PAGE
	public static final String login_itkt_uname_textbox = "User name,xpath,//*[@id='rcmloginuser']";
	public static final String loginWebmail_itkt_uname_textbox = "User name,xpath,//*[@id='user']";
	public static final String login_itkt_pass_textbox = "Password,xpath, //*[@id='rcmloginpwd']";
	public static final String loginWebmail_itkt_pass_textbox = "User name,xpath,//*[@id='pass']";
	public static final String login_itkt_login_button = "Login button,xpath, //*[@id='rcmloginsubmit']";
	public static final String loginWebmail_itkt_login_button = "Login button,xpath, //*[@id='login_submit']";

//	public static final String login_itkt_pass_textbox = "Password,xpath, //*[@id='rcmloginpwd']";
//	public static final String login_itkt_login_button = "Login button,xpath, //*[@id='rcmloginsubmit']";

	public static final String login_itkt_logout_button = "logout,xpath, //*[@id='rcmbtn112']";
	public static final String login_itkt_inbox_link = "Inbox,xpath,//*[@id='rcmliSU5CT1g']";
	public static final String login_itkt_webmaillogout_button = "Logout button,xpath,//a[@id='rcmbtn101'][text()='Logout'] | //a[@id='rcmbtn104'][text()='Logout']";
	public static final String login_itkt_inbox_icon = "Inbox icon,xpath,//*[@id='rcmbtn106']";
	public static final String login_itkt_Mail = "Mail button,xpath,//a[@class='mail selected']";

	public static final String loginpage_otppage = "OTP Popup,xpath,//div[@class='forgot-password-modal']";
	public static final String login_adblocker = "Plugin popup proceed,xpath,//button[contains(@class,'rsp-primary-button')][text()='Proceed']";
	public static final String login_adblockernew = "Latency popup proceed,xpath,//button[contains(@class,'rsp-primary-button')][text()='Proceed']";
	public static final String loginpage_existinguser_link = "Existing user,xpath,//span[text()='Existing user']/..";
	public static final String loginpage_password_preview = "Password Preview,xpath,//input[@name='password']//following-sibling::i";
	public static final String loginpage_otppage_textfield = "OTP,xpath,//div[@id='otp']//div[contains(@class,'rs-input-wrapper')]//input";
	public static final String loginpage_otppage_validationMark = "OTP Validation Mark Icon,xpath,//input[@name='otp']/..//i";
	public static final String loginpage_Webmailotp_textfield = "Webmail OTP,xpath,//input[@name='otp']";// *[@id='rcmbtn104']
	public static final String loginpage_otppage_confirmbtn = "Confirm CTA,xpath,//button[text()='Confirm']";
	public static final String loginpage_otppage_cancelbtn = "Cancel button,xpath,//button[text()='Cancel']";
	public static final String loginpage_chekbox = "Stay signed in checkbox,xpath,//span[@class='sc-gKXOVf dJWFGW checkmark']";

	public static final String loginpage_forgetPswd_Poppup = "Forget password,xpath,//div[@class='forgot-password-modal']";
	public static final String loginpage_enterRegisteredmail = "Forget password email,xpath,//div[contains(@class,'forgot-password-modal')]//input[@name='emailId']";
	public static final String loginpage_forgetpswd_otpInput = " OTP input filed,xpath,//div[@id='otp']//input";
	public static final String loginpage_forgetpswd_successMsg = "Forget password success message,xpath,//span[contains(.,'New password sent successfully to the registered email id')]";
	public static final String loginpage_validationerr_msg1 = "Error message,xpath,//div[@class='validation-message  ']";
	public static final String loginpage_requestnewpassword_sendbtn = "OTP send button,xpath,//button[contains(@class,'rs-button-primary')][text()='Send']";
	public static final String loginpage_FrgtPswd_validation = "Error Validation Message,xpath,//div[@class='forgot-password-modal']//div[contains(@class,'validation-message')][not (contains(@class,'v2'))]";
	public static final String loginpage_requestnewpassword_popup = "Enter one time password popup,xpath,//div[contains(@class,'forgot-password-modal')]//h1[text()='One-Time Password verification']";
	public static final String loginpage_requestnewpassword_closebtn = "Close request password,xpath,//div[@class='close-ico-btn cp']";
	public static final String loginpage_username_errmsg = "Username error message,xpath,//div[@class='validation-message  '][contains(.,'Email')]";
	public static final String loginpage_copyrigtLinks = "Copy right links,xpath,//*[contains(@class,'copyright')]//li";
	public static final String loginpage_copyrigt_year = "Copy right year,xpath,//span[@class='init-copyright']";
	public static final String loginpage_copyrigt_headername = "Header title,xpath,//div[contains(@class,'text-center')]//h1";

	// Team webmail login
	public static final String teamlogin_itkt_uname_textbox = "UserName,xpath,//*[@id='rcmloginuser']";
	public static final String teamlogin_itkt_pass_textbox = "Password,xpath,//*[@id='rcmloginpwd']";
	public static final String teamlogin_itkt_login_button = "Submit,xpath,//*[@id='rcmloginsubmit']";
	public static final String teamlogin_itkt_inbox_link = "Inbox,xpath,//a[@rel='INBOX']";
	public static final String teamlogin_itkt_webmaillogout = "Webmail logout,xpath,//a[.='Logout']";

	/**
	 * Please write the Playwright locators below
	 */

	public static final String pw_login_proceed = "Plugin popup proceed,pw,#rs_DisablePluginModal_proceed";
	public static final String pw_loginpage_username_textbox = "Login UserName,pw,#emailId";
	public static final String pw_loginpage_password_textbox = "Login Password,pw,#rs_ExistingUser_password";
	public static final String pw_loginpage_Login_btn = "Sign In CTA,pw,#rs_ExistingUser_signin";

}
