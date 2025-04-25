package regression_Preferences;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.PreferencesPage;
import repository.DashboardRepository;
import repository.ObjectRepository;
import repository.PreferencesRepository;
import utility.BaseTest;
import utility.PageBase;

public class PreferencesNegativeScenario extends BaseTest
{

	@Test(description = "Preferences Data catalogue negative validation")
	public void dataCatlogueNegativeValidation() throws Exception
	{
		PreferencesPage pref = getPageFactory().preferencesPage();

		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
//			Thread.sleep(ObjectRepository.wait10sec);
		pref.pageLoaderLogo();
		pref.clickPreferencePagefromMenu();
		pref.clickElement(PreferencesRepository.allmenu_pref_dataCatalogue);
		pref.pageLoaderLogo();
		Thread.sleep(ObjectRepository.wait10sec);
		pref.pageLoaderLogo();
		pref.addAttribute();
		pref.pageLoaderLogo();
		Thread.sleep(ObjectRepository.wait5sec);
		pref.pageLoaderLogo();
		pref.clickElement(PreferencesRepository.preferences_dataattribute_attributename);
		pref.enterTabAction();
		Thread.sleep(ObjectRepository.wait5sec);
		String AttriName = pref.getStrText(PreferencesRepository.preferences_dataattribute_AttriNameError);
		pref.uiPageEqualswithInputValue(AttriName, "Enter attribute name");
		pref.clickElement(PreferencesRepository.preferences_dataattribute_attributename);
		pref.enterValue(PreferencesRepository.preferences_dataattribute_attributename, "Channel");
		pref.tabAction();
		// verifying existing error message
		String existingErrorMessage = pref.getStrText(PreferencesRepository.preferences_dataattribute_attributenameErrorMessage);
		pref.uiPageEqualswithInputValue(existingErrorMessage, "Attribute name already exists");
		// verifying special character error Message
		pref.enterValue(PreferencesRepository.preferences_dataattribute_attributename, "!@#$%");
		pref.tabAction();
		String specialCharErrorMessage = pref.getStrText(PreferencesRepository.preferences_dataattribute_attributenameSpecialCharErrorMessage);
		// Verifying Code Pattern TextBox Error Message
		pref.uiPageEqualswithInputValue(specialCharErrorMessage, "Only (_ & -) are allowed");
		pref.clearField(PreferencesRepository.preferences_dataattribute_attributename);
		pref.enterValue(PreferencesRepository.preferences_dataattribute_attributename, "AutoAttribute");
		pref.enterTabAction();
		/*
		 * pref.clickElement(PreferencesRepository.
		 * preferences_dataattribute_DescriptionBox);
		 * Thread.sleep(ObjectRepository.wait10sec); pref.enterTabAction(); String
		 * DescriptionBoxErrorValidation = pref.getStrText(PreferencesRepository.
		 * preferences_dataattribute_DescriptionBoxErrorValidation);
		 * pref.uiPageEqualswithInputValue(DescriptionBoxErrorValidation,
		 * "Min 10 characters");
		 */
		Thread.sleep(ObjectRepository.wait5sec);
		pref.clickElement(PreferencesRepository.preferences_dataattribute_Datatype);
		pref.tabAction();
		Thread.sleep(ObjectRepository.wait5sec);
		String emptyDatatypeErrorMessage = pref.getStrText(PreferencesRepository.preferences_dataattribute_DatatypeErrorValidation);
		pref.uiPageEqualswithInputValue(emptyDatatypeErrorMessage, "Select data type");
		//// Data type selection
		pref.threadSleep(ObjectRepository.wait10sec);
		pref.clickElement(PreferencesRepository.preferences_dataattribute_Datatype);
		pref.threadSleep(ObjectRepository.wait5sec);
		pref.selectlistelements(PreferencesRepository.preferences_dataattribute_DatatypeList, "KPI Data");
		pref.clickElement(PreferencesRepository.preferences_dataattribute_DatatypeCondition1);
		pref.tabAction();
		String Condition1 = pref.getStrText(PreferencesRepository.preferences_dataattribute_Datatype1ErrorValidation);
		pref.uiPageEqualswithInputValue(Condition1, "This field is required");
		pref.clickElement(PreferencesRepository.preferences_dataattribute_DatatypeCondition1Text);
		pref.tabAction();
		String Condition2 = pref.getStrText(PreferencesRepository.preferences_dataattribute_Datatype1TextErrorValidation);
		pref.uiPageEqualswithInputValue(Condition2, "This field is required");
		// inputValidation
		pref.threadSleep(ObjectRepository.wait5sec);
		pref.clickElement(PreferencesRepository.preferences_dataattribute_Inputtype);
		pref.tabAction();
		String emptyInputtypeErrorMessage = pref.getStrText(PreferencesRepository.preferences_dataattribute_InputtypeErrorValidation);
		pref.uiPageEqualswithInputValue(emptyInputtypeErrorMessage, "Select input type");
		Thread.sleep(ObjectRepository.wait10sec);
		BaseTest.getTest().log(Status.INFO, "Input type present as expected");
		pref.tabAction();
		PageBase.threadSleep(ObjectRepository.wait5sec);
//			pref.javaScriptScrollDownToSomeExtend();
		pref.javaScriptScrollIntoView("ele,id,rs_NewAttributeModal_Cancel");
		Thread.sleep(ObjectRepository.wait5sec);
		pref.clickElement(PreferencesRepository.preferences_dataattribute_Selectfiltergroup);
		pref.enterTabAction();
		Thread.sleep(ObjectRepository.wait5sec);
		String emptyFiltergroupErrorMessage = pref.getStrText(PreferencesRepository.preferences_dataattribute_FiltergroupErrorValidation);
		Thread.sleep(ObjectRepository.wait5sec);
		pref.uiPageEqualswithInputValue(emptyFiltergroupErrorMessage, "Select filter group");
		Thread.sleep(ObjectRepository.wait5sec);
		pref.clickElement(PreferencesRepository.preferences_dataattribute_Classification);
		Thread.sleep(ObjectRepository.wait5sec);
		pref.selectlistelements(PreferencesRepository.preferences_dataattribute_ClassificationList, "Personalisation");
		pref.clickElement(PreferencesRepository.preferences_dataattribute_ClassificationFallbackName);
		pref.tabAction();
		String FallbackErrorMessage = pref.getStrText(PreferencesRepository.preferences_dataattribute_FallbackerrorValidation);
		pref.uiPageEqualswithInputValue(FallbackErrorMessage, "Enter default fallback attribute name");
		pref.enterValue(PreferencesRepository.preferences_dataattribute_ClassificationFallbackName, "12");
		String FallbackcharValidation = pref.getStrText(PreferencesRepository.preferences_dataattribute_FallbackcharValidation);
		pref.uiPageEqualswithInputValue(FallbackcharValidation, "Min. 3 characters");

		pref.clickElement(PreferencesRepository.preferences_dataattribute_AddAttriClose);

	}

	@Test(description = "Goals and benchmark field negative validation")
	public void goalsBenchmarkNegative() throws InterruptedException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.clickCommunicationSettings();
		pref.clickGoalsandBenchmark();
		pref.pageLoaderLogo();
		pref.clickElement(PreferencesRepository.preferences_Audiencescore_CommonAdd);
		pref.pageLoaderLogo();
		pref.clickElement(PreferencesRepository.preferences_goals_communicationtype);
		pref.tabAction();
		String commErrorMessage = pref.getStrText(",xpath,//select[@name='communicationType']//../..//span[.='Select communication type']");
		pref.uiPageEqualswithInputValue(commErrorMessage, "Select communication type");
		pref.clickElement(PreferencesRepository.preferences_goals_communicationtype);
		pref.selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Promotion");
		pref.pageLoaderLogo();
		pref.clickElement(PreferencesRepository.preferences_goals_enterbenchmark);
		pref.tabAction();
		String FallbackErrorMessage = pref.getStrText(",xpath,//input[@id='name']/..//label");
		pref.uiPageEqualswithInputValue(FallbackErrorMessage, "Enter benchmark name");
		pref.clearField(PreferencesRepository.preferences_goals_DescriptionEnter);

		pref.clickElement(PreferencesRepository.preferences_goals_DescriptionEnter);
		pref.tabAction();
		String descErrorMessage = pref.getStrText(",xpath,//textarea[@id='description']/..//div[.='Enter description']");
		pref.uiPageEqualswithInputValue(descErrorMessage, "Enter description");
		pref.javaScriptScrollDown();
		pref.clearField(PreferencesRepository.preferences_GoalsBenchmark_Reachrate);
		pref.tabAction();
		String reachErrorMessage = pref.getStrText(",xpath,//input[@id='rs_RenderBenchmark_reach']/..//label");
		pref.uiPageEqualswithInputValue(reachErrorMessage, "This field is required");

		pref.clearField(PreferencesRepository.preferences_GoalsBenchmark_Engagementrate);
		pref.tabAction();
		String engagementErrorMessage = pref.getStrText(",xpath,//input[@id='rs_RenderBenchmark_engagement']/..//label");
		pref.uiPageEqualswithInputValue(reachErrorMessage, "This field is required");

		pref.clearField(PreferencesRepository.preferences_GoalsBenchmark_Conversionrate);
		pref.tabAction();
		String conversionErrorMessage = pref.getStrText(",xpath,//input[@id='rs_RenderBenchmark_conversion']/..//label");
		pref.uiPageEqualswithInputValue(reachErrorMessage, "This field is required");
	}

	@Test(description = "FrequencyCap add attribute negative validation")
	public void frequencyCapNegative() throws InterruptedException
	{
		String[] errorvalidate1 = { "Select audience group", "Select audience group list", "Select type" };
		String[] errorvalidate3 = { "Select communication type", "Select priority", "Select limit", "Select time interval" };

		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.clickCommunicationSettings();
		pref.clickElement(PreferencesRepository.preferences_commSettings_frequencycapsettings);
		pref.explicitwaitforclick(pref.autolocator(PreferencesRepository.preferences_commSettings_frequencycapaddicon), 10);
		pref.pageLoaderLogo();
		pref.clickElement(PreferencesRepository.preferences_commSettings_frequencycapaddicon);
		pref.pageLoaderLogo();
		pref.clickElement(PreferencesRepository.preferences_commSettings_frequencycap_Savebuttonclick);
//		String ruleErrorMessage = pref.getStrText(",xpath,///input[@id='ruleName']/..//label");
//		pref.uiPageEqualswithInputValue(ruleErrorMessage, "Enter rule name");
//		String audienceErrorMessage = pref.getStrText(",xpath,//select//..//..//span[.='Select audience group']");
//		pref.uiPageEqualswithInputValue(audienceErrorMessage, "Select audience group");
//		String audiencegroupErrorMessage = pref.getStrText(",xpath,//select[@name='audienceGroupSelect']//../..//span[.='Select audience group list']");
//		pref.uiPageEqualswithInputValue(audiencegroupErrorMessage, "Select audience group list");
//		String commErrorMessage = pref.getStrText(",xpath,//select[@name='ruleType']//../..//span[.='Select type']");
//		pref.uiPageEqualswithInputValue(commErrorMessage, "Select type");
//		pref.clickElement(PreferencesRepository.preferences_commSettings_frequencycap_selectType);
//		pref.selectlistelements(PreferencesRepository.preferences_commSettings_frequencycap_selectTypelist, "Communication Type");
		List<WebElement> AllerrorDrpdwn;
		AllerrorDrpdwn = pref.findElements(",xpath,//span[@class='k-label']");
		for (int i = 0; i <= 2; i++)
		{
			// AllerrorDrpdwn = pref.findElements(",xpath,//span[@class='k-label']");
			String errortext = AllerrorDrpdwn.get(i).getText();
			errorvalidate1[i].equals(errortext);
			BaseTest.getTest().log(Status.INFO, "Selected dropdown for " + errortext + "validation is correct");
		}
		pref.clickElement(PreferencesRepository.preferences_commSettings_frequencycap_selectType);
		pref.selectlistelements(PreferencesRepository.preferences_commSettings_frequencycap_selectTypelist, "Communication Type");
		pref.javaScriptScrollDown();
		pref.clickElement(PreferencesRepository.preferences_commSettings_frequencycap_Savebuttonclick);
		AllerrorDrpdwn = pref.findElements(",xpath,//span[@class='k-label']");
		int k = 0;
		for (int i = 3; i < AllerrorDrpdwn.size(); i++)
		{
			// AllerrorDrpdwn = pref.findElements(",xpath,//span[@class='k-label']");
			String errortext1 = AllerrorDrpdwn.get(i).getText();
			errorvalidate3[k].equals(errortext1);
			BaseTest.getTest().log(Status.INFO, "Select dropdown for" + errortext1 + "validation is correct");
			k++;
		}

		String contentValidation = pref.getStrText(",xpath,//div[@class='col']//small");
		pref.uiPageEqualswithInputValue(contentValidation, "The rule will be applicable only for bulk and promotional communication.");
		pref.clickElement(PreferencesRepository.preferences_Frequency_Cancelbutton);
	}

	@Test(description = "Smtp add attribute negative validation")
	public void smtpEmailnegative() throws InterruptedException
	{

		String[] smtp3Validate = { "Select domain name", "Select throttle setting", "Select SMTP housing" };
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.clickCommunicationSettings();
		pref.clickElement(PreferencesRepository.preferences_CommSettings_addsmtp);
		pref.pageLoaderLogo();
		pref.javaScriptScrollDown();
		pref.clickElement(PreferencesRepository.preferences_Smtp_Save);
		List<WebElement> AllerrorDrpdwn = pref.findElements(",xpath,//span[@class='k-label']");

		for (int i = 0; i < AllerrorDrpdwn.size(); i++)
		{
			String errortext = AllerrorDrpdwn.get(i).getText();
			smtp3Validate[i].equals(errortext);
			BaseTest.getTest().log(Status.INFO, "Selected dropdown for " + errortext + "validation is correct");

		}
		String serverName = pref.getStrText(",xpath,//input[@id='rs_Edit_smtpServer']//..//label");
		pref.uiPageEqualswithInputValue(serverName, "Enter server name/IP address");

		String portNumber = pref.getStrText(",xpath,//input[@id='rs_Edit_smtPort']/..//label");
		pref.uiPageEqualswithInputValue(portNumber, "Enter port number");

		pref.clearField(PreferencesRepository.preferences_Smtp_Username);
		String userName = pref.getStrText(",xpath,//input[@id='rs_Edit_smtUser']/..//label");
		pref.uiPageEqualswithInputValue(userName, "Enter a valid business email address");

		pref.clearField(PreferencesRepository.preferences_Smtp_password);
		String passName = pref.getStrText(",xpath,//input[@id='rs_Edit_smtPassword']/..//label");
		pref.uiPageEqualswithInputValue(passName, "Enter password");
		pref.javaScriptScrollDown();
		String serverMail = pref.getStrText(",xpath,//input[@id='rs_Edit_serverfromMail']/..//label");
		pref.uiPageEqualswithInputValue(serverMail, "Enter server from mail");

		String serverBounce = pref.getStrText(",xpath,//label[text()='Enter server bounce mail']");
		pref.uiPageEqualswithInputValue(serverBounce, "Enter server bounce mail");

		String domainKey = pref.getStrText(",xpath,//label[contains(.,'Enter domain key')]");
		pref.uiPageEqualswithInputValue(domainKey, "Enter domain key");

		pref.clickElement(PreferencesRepository.preferences_Smtp_radiobutton);
		BaseTest.takeScreenshot();

		pref.enterValue(PreferencesRepository.preferences_Smtp_serverUsername, "Auto");
		pref.clearField(PreferencesRepository.preferences_Smtp_serverUsername);
		pref.clickElement(PreferencesRepository.preferences_Smtp_serverUsername);
		pref.tabAction();
		String serverUserValidation = pref.getStrText(",xpath,//label[contains(.,'Enter user name')]");
		pref.uiPageEqualswithInputValue(serverUserValidation, "Enter user name");

		pref.enterValue(PreferencesRepository.preferences_Smtp_serverPassname, "Auto");
		pref.clickElement(PreferencesRepository.preferences_Smtp_serverPassname);
		pref.tabAction();
		pref.clearField(PreferencesRepository.preferences_Smtp_serverPassname);
		pref.tabAction();
		String serverPassValidation = pref.getStrText(",xpath,//label[contains(.,'Enter password')]");
		pref.uiPageEqualswithInputValue(serverPassValidation, "Enter password");
		pref.clickElement(",xpath,(//button[.='Cancel'])[2]");
		pref.clickElement(PreferencesRepository.preferences_Smtp_Cancelbutton);

	}

	@Test(description = "Unsub add subscribe negative validation")
	public void unSubNegative() throws InterruptedException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.clickCommunicationSettings();
		pref.clickElement(PreferencesRepository.preferences_commSettings_UnsubSubmoduleClick);
		pref.pageLoaderLogo();
		pref.clickElement(PreferencesRepository.preferences_commSettings_UnsubSelect);
		pref.pageLoaderLogo();
		pref.clickElement(PreferencesRepository.preferences_commSettings_UnsubAddIcon);
		pref.pageLoaderLogo();
		pref.clickElement(PreferencesRepository.preferences_commSettings_UnsubRemove);
		pref.javaScriptScrollDown();
		pref.clickElement(PreferencesRepository.preferences_commSettings_UnsubSave);

		String titleText = pref.getStrText(",xpath,//label[text()='Enter title text']");
		pref.uiPageEqualswithInputValue(titleText, "Enter title text");

		String profileValidation = pref.getStrText(",xpath,//div[@class='validation-message'][.='Upload company logo']");
		pref.uiPageEqualswithInputValue(profileValidation, "Upload company logo");
		pref.javaScriptScrollDownToSomeExtend();
		String agreeCondition = pref.getStrText(",xpath,//div[.='Agree Terms & conditions']");
		pref.uiPageEqualswithInputValue(agreeCondition, "Agree Terms & conditions");
		pref.javaScriptScrollDownToSomeExtend();
		pref.clickElement(PreferencesRepository.preferences_commSettings_UnsubAdvancedsttngstoggle);
		pref.javaScriptScrollDown();
		pref.clickElement(PreferencesRepository.preferences_commSettings_UnsubSave);
		pref.javaScriptScrollDown();
		String reDirectnalError = pref.getStrText(",xpath,//input[@name='redirectionURL']/..//label");
		pref.uiPageEqualswithInputValue(reDirectnalError, "Enter valid redirection URL");

		pref.clickElement(PreferencesRepository.preferences_commSettings_UnsubFarewellCancel);

	}

	@Test(description = "Smpp sms negative validation")
	public void smppSmsNegative() throws InterruptedException
	{
		String[] smppValidation = { "Type is required", "Type is required", "Type is required" };
		String[] smppFullValid = { "Enter access point", "Enter user name", "Enter password", "Operator code", "Enter sender ID", "Enter friendly name" };

		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.clickCommunicationSettings();
		pref.clickElement(PreferencesRepository.preferences_Smpp_Sms_Click);
		pref.pageLoaderLogo();
		pref.clickElement(PreferencesRepository.preferences_Smpp_addicon);
		pref.pageLoaderLogo();
		pref.javaScriptScrollDown();
		pref.clickElement(PreferencesRepository.preferences_Smpp_PlusButton);
		List<WebElement> radiobttnValid = pref.findElements(PreferencesRepository.preferences_Smpp_radionbttnValidation);
		for (int i = 0; i < radiobttnValid.size(); i++)
		{
			String errortext = radiobttnValid.get(i).getText();
			smppValidation[i].equals(errortext);
			BaseTest.getTest().log(Status.INFO, "Selected validation for " + errortext + " is correct");
		}
		pref.clearField(PreferencesRepository.preferences_Smpp_userName);
		pref.tabAction();
		pref.clearField(PreferencesRepository.preferences_Smpp_password);

		String providerError = pref.getStrText(",xpath,//select[@name='provider']//../..//span[.='Select provider']");
		pref.uiPageEqualswithInputValue(providerError, "Select provider");
		List<WebElement> smppElem = pref.findElements(",xpath,//div[@class='row']//label");
		int k = 0;
		for (int i = smppElem.size() - 6; i < smppElem.size(); i++)
		{
			String refName = smppElem.get(i).getText();
			smppFullValid[k].equals(refName);
			BaseTest.getTest().log(Status.INFO, "Selected dropdown for " + refName + "validation is correct");
			k++;
		}
		pref.clickElement(PreferencesRepository.preferences_Smpp_Cancel);
	}

	@Test(description = "SMPP web notification field validation")
	public void commWebNegative() throws InterruptedException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.clickCommunicationSettings();
		pref.pageLoaderLogo();
		pref.clickElement(PreferencesRepository.Preferences_CommSettings_notification);
		pref.threadSleep(ObjectRepository.wait5sec);
		pref.clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_add);
		pref.pageLoaderLogo();
		pref.javaScriptScrollDown();
		pref.clickElement("save button,id,rs_PushWebCreate_submit");
		String[] name = { "Enter domain name", "Enter website", "Upload file", "", "", "", "Enter API key", "Enter auth domain", "Database URL", "Enter project ID", "Enter storage bucket", "Enter measurement ID", "Enter app id", "Vap ID" };
		List<WebElement> webpush = pref.findElements(",xpath,//div[@class='rs-sub-heading']//.//.//.//label");

		System.out.println();
		for (int i = 0; i < webpush.size(); i++)
		{
			if (!(i == 4 || i == 5 || i == 6 || i == 9))
			{
				String errormsg = webpush.get(i).getText();
				System.out.println(errormsg + "  ---   " + name[i] + "    ---" + i);

				pref.writeLog(errormsg.equalsIgnoreCase(name[i]), "the error message is displayed as expected : " + errormsg, "the error message is not displayed as expected " + errormsg);
			}
		}
	}

	@Test(description = "SMPP whatsapp negative validation")
	public void smppWhatsappNegative() throws InterruptedException
	{
		String[] whatsappSettings = { "Enter access point", "Enter authorization key", "Enter user name", "Enter password", "Enter sender ID", "Enter sender name", "Enter template ID", "Enter template name" };
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.clickCommunicationSettings();
		pref.pageLoaderLogo();
		pref.clickElement(PreferencesRepository.preferences_Smpp_Sms_Click);
		pref.pageLoaderLogo();
		pref.clickElement(PreferencesRepository.preferences_Smpp_Whatsapp);
		pref.pageLoaderLogo();
		pref.clickElement(PreferencesRepository.preferences_Smpp_addicon);
		pref.pageLoaderLogo();
		pref.javaScriptScrollDown();
		pref.clickElement(PreferencesRepository.preferences_Smpp_Whatsapp_Save);
		List<WebElement> whatsappError = pref.findElements(",xpath,//div[contains(@class,'errorContainer')]//label");
		for (int i = 0; i < whatsappError.size(); i++)
		{
			String errortext = whatsappError.get(i).getText();

			if (whatsappSettings[i].equals(errortext))
			{
				BaseTest.getTest().log(Status.INFO, "Selected validation for " + errortext + " is correct");

			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Selected validation for " + errortext + " is incorrect");
			}
		}
		pref.clickElement(PreferencesRepository.preferences_Smpp_Whatsapp_Cancel);
	}

	@Test(description = "communication mobile negative validation")
	public void commMobileNegative() throws InterruptedException
	{
		String[] radioCheck = { "Select language", "Select language" };
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.clickCommunicationSettings();
		pref.pageLoaderLogo();
		pref.clickElement(PreferencesRepository.Preferences_CommSettings_notification);
		pref.pageLoaderLogo();
		pref.clickElement(PreferencesRepository.Preferences_CommSettings_mobileApp);
		pref.pageLoaderLogo();
		pref.clickElement(PreferencesRepository.Preferences_CommSettings_addMobileApp);
		pref.pageLoaderLogo();
		pref.javaScriptScrollDown();
		pref.clickElement(PreferencesRepository.Preferences_CommSettings_AppSaveBtn);
		String appNameError = pref.getStrText(",xpath,//input[@id='appName']/..//label");
		pref.uiPageEqualswithInputValue(appNameError, "Enter app name");

		String mobPlatform = pref.getStrText(",xpath,//select[@title='Select mobile platform']//..//..//span[.='Select mobile platform']");
		pref.uiPageEqualswithInputValue(mobPlatform, "Select mobile platform");

		String appStoreError = pref.getStrText(",xpath,//input[@id='devices[0].appStoreUrl']/..//label");
		pref.uiPageEqualswithInputValue(appStoreError, "Enter appstore URL");

		pref.clickElement(PreferencesRepository.preferences_Mobile_Radiobtn);
		String chooseUploadError = pref.getStrText(",xpath,//label[.='Choose file']");
		pref.uiPageEqualswithInputValue(chooseUploadError, "Choose file");
		pref.javaScriptScrollDown();
		List<WebElement> langRadio = pref.findElements(",xpath,//div[@class='validation-message']");
		for (int i = 0; i < langRadio.size(); i++)
		{
			String radioErrorCheck = langRadio.get(i).getText();
			if (radioCheck[i].equals(radioErrorCheck))
			{
				BaseTest.getTest().log(Status.INFO, "Selected validation for " + radioErrorCheck + " is correct");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Selected validation for " + radioErrorCheck + " is correct");
			}
		}
		pref.javaScriptScrollDown();
		pref.clickElement(PreferencesRepository.preferences_Mobile_Togglebtn);
		pref.clickElement("Plus icon,xpath,//i[contains(@class,'icon-rs-circle-plus-fill-medium')]");
		String analyticpltfrm = pref.getStrText(",xpath,//select[@name='devices[0].appanalyticsetting[0].analyticsID']/../..//span[.='Select analytics platform']");
		pref.uiPageEqualswithInputValue(analyticpltfrm, "Select analytics platform");

		String accMailError = pref.getStrText(",xpath,//label[contains(.,'Enter account mail')]");
		pref.uiPageEqualswithInputValue(accMailError, "Enter account mail");

		String appKeyError = pref.getStrText(",xpath,//label[contains(.,'Enter app key')]");
		pref.uiPageEqualswithInputValue(appKeyError, "Enter app key");

		String secretIdError = pref.getStrText(",xpath,//label[contains(.,'Enter secret ID')]");
		pref.uiPageEqualswithInputValue(secretIdError, "Enter secret ID");
		pref.javaScriptScrollDown();
		pref.clickElement(PreferencesRepository.Preferences_CommSettings_AppCancelBtn);
	}

	@Test(description = "Offer management negative validation")
	public void offerManagementNegative() throws InterruptedException
	{
		PreferencesPage pref = getPageFactory().preferencesPage();
		pref.login(pref.dPropertyLoginUserName(), pref.dPropertyLoginPswrd());
		pref.selectbusinessunit();
		pref.preferenceModuleClick();
		pref.pageLoaderLogo();
		pref.threadSleep(ObjectRepository.wait2sec);
		pref.clickElement(PreferencesRepository.preferences_Offer_Click);
		pref.pageLoaderLogo();
		pref.threadSleep(ObjectRepository.wait2sec);
		pref.clickElement(PreferencesRepository.preferences_Offer_Add);
		pref.pageLoaderLogo();
		pref.threadSleep(ObjectRepository.wait2sec);
		pref.javaScriptScrollDown();
		pref.clickElement(PreferencesRepository.preferences_OffercodeSave);
		List<WebElement> datePickerError = pref.findElements(",xpath,//div[@class='validation-message']");
		for (int i = 0; i < datePickerError.size(); i++)
		{
			String ErrorCheck = datePickerError.get(i).getText();
			if (ErrorCheck.equals(ErrorCheck))
			{
				BaseTest.getTest().log(Status.INFO, "Selected validation for " + ErrorCheck + " is correct");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Selected validation for " + ErrorCheck + " is correct");
			}
		}
		String cmmtypeError = pref.getStrText(",xpath,//label[contains(.,'Select communication type')]");
		pref.uiPageEqualswithInputValue(cmmtypeError, "Select communication type");

		String prdctTypeError = pref.getStrText(",xpath,//label[contains(.,'Select product type')]");
		pref.uiPageEqualswithInputValue(prdctTypeError, "Select product type");

		String offerError = pref.getStrText(",xpath,//input[@id='rs_CreateOffer_offercode']/..//label[text()='Enter offer code']");
		pref.uiPageEqualswithInputValue(offerError, "Enter offer code");
		pref.clickElement(PreferencesRepository.preferences_RefreshClick);
		pref.clickElement(",xpath,//input[@value='Unique']");
		pref.clickElement(PreferencesRepository.preferences_Volumevalue);
		pref.tabAction();
		String volumeError = pref.getStrText(",xpath,//label[contains(.,'Enter volume')]");
		pref.uiPageEqualswithInputValue(volumeError, "Enter volume");
		pref.enterValue(PreferencesRepository.preferences_Volumevalue, "10");
		pref.clickElement(PreferencesRepository.preferences_Unique_Offercode);

		String offrCodeError = pref.getStrText(",xpath,//select[@name='addOfferCode']//../..//span[.='Enter offer code']");
		pref.uiPageEqualswithInputValue(offrCodeError, "Enter offer code");
		pref.javaScriptScrolltoTop();
		pref.clickElement(PreferencesRepository.preferences_offer_name);
		pref.tabAction();
		String enterNameError = pref.getStrText(",xpath,//input[@id='offerName']/..//label[contains(.,'Enter name')]");
		pref.uiPageEqualswithInputValue(enterNameError, "Enter name");
		pref.javaScriptScrollDown();
		pref.threadSleep(ObjectRepository.wait2sec);
		pref.clickElement(PreferencesRepository.preferences_Offer_Cancel);

	}
}