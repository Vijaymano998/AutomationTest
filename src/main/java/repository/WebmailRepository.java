package repository;

public class WebmailRepository
{

	// WEBMAIL INBOX PAGE

	public static final String webmail_inboxunread = "Inbox Unread,xpath, //*[contains(@id,'msgicnrcmrow')][contains(@title,'Unread')]";
	public static final String itkt_inbox_linkafterinboxmailopen = "Inbox after mail open,xpath, //*[@id='rcmbtn108']";
	public static final String webmail_page_communicationemailsms_requestApproveBtn = "Communication rfa approve,link,Approve";

	public static final String webmail_page_communication_requestApproveBtn = "Audience RFA approve,xpath, //*[.='Approve']";
	public static final String webmail_page_communication_approvedmsg = "Approved message,xpath,//span[contains(.,'approved')]";
	public static final String webmail_page_communication_approvedmsg_SMS = ",xpath,//h4[contains(.,'Communication approved!')]";
	public static final String webmail_page_communication_makeChangesBtn = "Make changes,link,Make changes";
	public static final String webmail_page_communication_makeChangesComment = "Comments,id,Comments";
	public static final String webmail_page_communication_makeChangecommentbtn = "Comments button,xpath,//*[@id='pnlCampaignMakeChanges']/input";
	public static final String webmail_page_communication_makechangesstatusmsg = "Makechange status message,xpath,//*[@id='pnlCampaignStatus']/div/span";
	public static final String webmail_page_otp_read_otp = "Get OTP,xpath,//td[contains(text(),'OTP code')]//span";
	public static final String webmail_page_authourization = "Authorization Code Key,xpath,//td[contains(text(),'Authorization code:')]//span";
	public static final String webmail_page_licenseKey = "Get License Key,xpath,//td[contains(text(),'License key:')]//span";
	public static final String audience_target_textview = "Text view,xpath,//a[@title='Display in plain text format']";
	public static final String audience_target_selectlink = "Approver link,xpath,//a[contains(@rel,'noreferrer')]";
	public static final String webmail_page_mail_delete = "Webmail delete button,xpath,//a[contains(@class,'delete')]";
	public static final String communicationblast_viewinbrowser = "View in browser,xpath,//a[contains(@href,'/EmailHeader/WebView')]";
	public static final String communicationblast_forward = "Forward link,xpath,//a[contains(@href,'/EmailFooter/ForwardFriends')]";
	public static final String communicationblast_verifyforward = "Forwardtofriend page,xpath, //h1[@id='TextForwardtoFriend']";
	public static final String forwardPage_Email = "FF email,xpath, //*[@id='EmailId']";
	public static final String communicationblast_Template = "Template Text,xpath,//td[@style='padding-left: 16px']//div";

	public static final String forwardPage_Name = "FF Name,xpath, //input[@id='FFName']";
	public static final String forwardPage_FriendEmailenter = "Friend emailid,id,FriendsEmailIds";
	public static final String communicationblast_selectunsub = "Unsubscribe link,xpath, //a[contains(@href,'/EmailFooter/UnSubcription')]";
	public static final String communicationblast_verifyunsub = "Unsubscribe page,xpath, //h1[text()='Unsubscription']";
	public static final String webmail_page_communication_mailreplybutton = "Webmail reply button,xpath, //a[@id='rcmbtn102']/span";
	public static final String webmail_page_communication_mailreplyemail = "Reply mail,xpath,//td[@class='header replyto']/span/a[@class='rcmContactAddress']";
	public static final String webmail_page_communication_replytosenderclose = "Webmail sender close button,xpath,//a[@id='rcmbtn106']";
	public static final String webmail_page_communication_rfamailsubjectcommname = "Webmail rfa comm name,xpath,//div[@class='rcmBody']//td[contains(text(),'Communication  name:')]/../following-sibling::tr/td";
	public static final String webmail_page_communication_rfamailsubjectline = "Webmail rfa subjectline,xpath, //div[@class='rcmBody']//td[contains(text(),'Subject:')]/../following-sibling::tr/td";
	public static final String webmail_page_communication_rfamailsubjectheader = "Webmail subject header,xpath, //div[@class='rcmBody']//td[contains(text(),'Subject:')]";
	public static final String webmail_page_communication_rfamailaudiencecount = "Webmail rfa Audience count,xpath, //div[@class='rcmBody']//td[contains(text(),'Total audience:')]/../following-sibling::tr/td";
	public static final String webmail_page_communication_rfamailcreatedby = "Webmail rfa Createdby,xpath, //div[@class='rcmBody']//td[contains(text(),'Created by:')]/../following-sibling::tr/td";
	public static final String webmail_page_communication_rfamailscheduledate = "Webmail rfa Scheduledate,xpath, //div[@class='rcmBody']//td[contains(text(),'Scheduled date and time:')]/../following-sibling::tr/td";
	public static final String webmail_page_communication_inboxlaunchconfirmationcheckbox = "Webmail inbox launch check box,xpath, //*[@id='setActiveAsDefault']";
	public static final String webmail_page_communication_inboxlaunchconfirm = "Webmail inbox launch confirm ok,xpath, //*[@id='launchActiveButton']";
	public static final String webmail_page_communication_notificationmessage = "Webmail Notification Message,xpath,(//div[@class='rcmBody']//tbody//tbody//tr//tbody//tr//td)[3]";
	public static final String webmail_Inbox_subjLine = "Subject line,xpath,//div[@id='message-header']//h2";
	public static final String webmail_forgetpassword = "New password,xpath,//td[@valign='middle'][contains(.,'Password')]/..//td[not(contains(.,'Password'))]";

	// G-MAIL LOGIN PAGE
	public static final String gmail_AccountCreation_Signin = "Sign in button,xpath,//div[@class='header__aside']//a[text()='Sign in']";
	public static final String gmail_LoginPage_username = "User name,xpath,//input[@id='identifierId']";
	public static final String gmail_LoginPage_password = "Password,xpath,//div[@id='password']//input";
	public static final String gmail_LoginPage_NextButton = "Next button,xpath,//*[text()='Next']";
	public static final String gmail_LoginPage_NotNow = "Not now Button,xpath,//span[text()='Not now']/..";
	public static final String gmail_InboxMenue = "Inbox,xpath,//a[text()='Inbox']//ancestor::div[@data-tooltip='Inbox']";
	public static final String gmail_Inbox_settings = "Settings btn,xpath,//div[@data-tooltip='Settings']";
	public static final String gmail_Inbox_allSettings = "All Setting btn,xpath,//button[text()='See all settings']";
	public static final String gmail_setting_dynamicMail = "Dynamic Email,xpath,//span[text()='Enable dynamic email']/../preceding-sibling::input";
	public static final String gmail_setting_AMPcheckbox = "AMP checkbox,xpath,//span[text()='amp@gmail.dev']/ancestor::label";
	public static final String gmail_Inbox_developerSettings = "Developer settings,xpath,//span[text()='Enable dynamic email']/..//a";
	public static final String gmail_setting_dynamic_SenderMailID = "Dynamic sender e-mail,xpath,//span[text()='amp@gmail.dev']//following::input[@type='email']";
	public static final String gmail_setting_saveButton = "Save button,xpath,//button[@name='developer_settings_dialog_save']";
	public static final String gmail_Inbox_MoreMenue = "More menu,xpath,//span[text()='More']/..";
	public static final String gmail_Inbox_Allmails = "All Mails,xpath,//a[text()='All Mail']//ancestor::div[@data-tooltip='All Mail']";
	public static final String gmail_Inbox_spam = "Spam menu,xpath,//a[text()='Spam']//ancestor::div[@data-tooltip='Spam']";
	public static final String gmail_Inbox_subjLine = "Subject line,xpath,//div[@role='main']//h2";
	public static final String gmail_Spam_NotaSpamButton = "Report as not Spam button,xpath,//div[@role='main']//button";
	public static final String webmail_page_communicationemailsms_requestApproveCommentBox = "Communication rfa approve comment box,css,textarea[id='Comments']";
	public static final String webmail_page_communicationemailsms_requestApproveCommentApprove = "Communication rfa approve comment Approve,xpath,//input[@value='Approve']";
	public static final String webmail_page_communicationApproveAndMakeChangesStatus = "alert status,xpath,//div[@id='pnlCampaignStatus']//span";

	public static final String gmail_AMPEdm_dynamicMail_icon = "Dynamic Email icon,xpath,//*[@title='Dynamic email']";
	public static final String gmail_AMPEdm_Carousel = "Carousel,tag,amp-carousel";
	public static final String gmail_AMPEdm_Accordion = "Accordin,tag,amp-accordion";
	public static final String gmail_AMPEdm_connectButton = "Connect Button,xpath,//a[@class='es-button']";
}
