package pages;

import java.awt.AWTException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Mouse;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.BoundingBox;
import com.microsoft.playwright.options.SelectOption;

import repository.AudienceRepository;
import repository.CommunicationRepository;
import repository.DashboardRepository;
import repository.ObjectRepository;
import repository.PreferencesRepository;
import utility.BaseTest;
import utility.ExtentManager;
import utility.PW_PageBase;
import utility.PageFactory;

//Yogeshwaran Code - 20.01.2025 ( 46 to 5000 )

public class PreferencesPage extends HomePage {

	String existfooter, StartDate, EndDate, city, zipcode, pwind, newFormsList, role, servicePro, newRolesList,
			emailFooter;
	String Name, prePopulatedfieldoff, autoSaveFieldoff;
	public String userName;
	String MobileNo;
	String EmailID;
	String City;
	String Gender;
	String inputFormfields;
	String Inputfields2;
	public String formName;
	List<WebElement> formListupd;
	int row_count;
	int rowCount_Unsub;
	public List<Map<String, String>> invoicesDetails = new ArrayList<>();
	Map<String, String> invoices = new LinkedHashMap<>();
	List<String> formInputFields = new ArrayList<String>();
	List<String> formOutputFields = new ArrayList<String>();
	List<String> removedFormfields = new ArrayList<String>();
	List<String> formOutputremovedFields = new ArrayList<String>();
	List inputtablefields1;
	List<String> selectedClassificationList = new ArrayList<String>();

	public PreferencesPage(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	public void clickUserroles() {
		threadSleep(ObjectRepository.wait2sec);
		clickElement(PreferencesRepository.Preferences_Userroles);
		BaseTest.getTest().info(MarkupHelper.createLabel("PREFERENCES USER ROLES ", ExtentColor.BLUE));

	}

	public void userrolesvaldiation() {
		String userroleTitle = getStrText(PreferencesRepository.Preferences_Userrolestitle);
		if (userroleTitle.equals(PreferencesRepository.Preferences_UserrolestitleNmae)) {
			BaseTest.getTest().log(Status.INFO, "Header title is Present");
			isDisplayed(PreferencesRepository.preferences_Userroles_grid);
			BaseTest.getTest().info(MarkupHelper.createLabel("USERS ", ExtentColor.BLUE));
		} else {
			BaseTest.getTest().log(Status.FAIL, "Header title is not Present");
		}

	}

	public String createNewRole(String domainName) {


		// toolTipValidationKnownText(PreferencesRepository.preferences_Userroles_addicon, "Add");
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_Userroles_addicon);
		if (isDisplayed(PreferencesRepository.preferences_addUser_namefield)) {
			sendValue(PreferencesRepository.preferences_addUser_nameentryfield, domainName);
			clickElement(PreferencesRepository.preferences_adduser_Accessprivileges);
			javaScriptScrollIntoView(PreferencesRepository.prefernces_adduser_updatebutton);
			clickElement(PreferencesRepository.prefernces_adduser_updatebutton);
			pageLoaderLogo();
			BaseTest.getTest().log(Status.INFO, " " + role + " User is created successfully");

		} else {
			BaseTest.getTest().log(Status.INFO, "Unable to create user - max limit exceeds");
		}

		return role;

	}

	public void deleteuserrole(String role) {
		String newusername = replacePlaceHolder(PreferencesRepository.prefernces_deleteuser_name, role);
		String newuserdeleteicon = replacePlaceHolder(PreferencesRepository.prefernces_deleteuser_deleteicon, role);

		isDisplayed(newusername);
		clickElement(newuserdeleteicon);
		threadSleep(ObjectRepository.wait2sec);
		isDisplayed(PreferencesRepository.prefernces_deleteuser_deletepopup);
		clickElement(PreferencesRepository.preferences_deleteuser_okbutton);
		try {
			pageLoaderLogo();

			BaseTest.takeScreenshot();

			BaseTest.getTest().log(Status.INFO, "User role is not present after role is deleted");

		} catch (Exception e) {

			pageLoaderLogo();
			BaseTest.takeScreenshot();
			BaseTest.getTest().log(Status.FAIL, "User role is present after role is deleted");

		}

	}

	public void exisitinguservalidation(String domainName) throws AWTException {
		clickElement(PreferencesRepository.Preferences_exisitinguser_Editicon
				.replace(PreferencesRepository.dynamicXpathprefernces, domainName));
		pageLoaderLogo();
		WebElement element = findElement(PreferencesRepository.preferences_exisitinguser_namefiled);
//		if (element != null)
//		{
//			String value = element.getAttribute("disabled");
//			if (value.contains("true") && value != null)
//			{
//				BaseTest.getTest().log(Status.INFO, "the filed is disabled");
//			} else
//			{
//				BaseTest.getTest().log(Status.FAIL, "the filed is enable");
//			}
//		}
		explicitwaitforclick(autolocator(PreferencesRepository.preferences_existinguser_cancelbutton), 30);
		String value = getTextBoxVal(PreferencesRepository.preferences_exisitinguser_Accessprivileges, "value");
		if (value.contains("false") && value != null) {
			BaseTest.getTest().log(Status.INFO, "the filed is disabled");
		} else {
			BaseTest.getTest().log(Status.WARNING, "the filed is enable");
		}

		javaScriptScrollDown();
		clickElement(PreferencesRepository.preferences_existinguser_cancelbutton);

	}

	public void Readprivilegevalidation(String user) {
		int val = user.contains("User") ? 0 : user.contains("Superuser") ? 1 : user.contains("Admin") ? 2 : 3;
		clickElement(PreferencesRepository.preferences_Userroles_paginationClick);
		selectlistelements(PreferencesRepository.preferences_Userroles_paginationSelect, "20");
		javaScriptScrollDown();
		clickElement(user + "Edit icon,xpath,//td//span[.='" + user + "']/../..//div[@class='rs-tooltip-wrapper ']");
		pageLoaderLogo();
		String[] roleHeaders = BaseTest.getData().rolesRead.split(";");
		String[] userHeaders = roleHeaders[val].split("\\!");
		BaseTest.getTest().info(MarkupHelper.createLabel("<b>" + user + " Read privilege</b>", ExtentColor.BLUE));

		List<WebElement> checkedStatus = findElements(PreferencesRepository.preferences_Userroles_Read_ListofRows);
		for (int i = 0; i < checkedStatus.size(); i++) {
			String headerName = checkedStatus.get(i).findElements(By.tagName("td")).get(0).getText();
			System.out.println(headerName);
			if (headerName.contains(userHeaders[i])) {
				BaseTest.getTest().log(Status.INFO, "<b>" + headerName + "</b> name field is checked.");
			} else {
				BaseTest.getTest().log(Status.WARNING, "<b>" + headerName + "</b> name field is unchecked.");

			}
		}
		javaScriptScrollIntoView(PreferencesRepository.preferences_existinguser_cancelbutton);
		clickElement(PreferencesRepository.preferences_existinguser_cancelbutton);
	}

	public void updateprivilegevalidation(String user) {
		int val = user.contains("User") ? 0 : user.contains("Superuser") ? 1 : user.contains("Admin") ? 2 : 3;
		threadSleep(ObjectRepository.wait2sec);
		clickElement(PreferencesRepository.preferences_Userroles_paginationClick);
		selectlistelements(PreferencesRepository.preferences_Userroles_paginationSelect, "20");
		javaScriptScrollDown();
		clickElement(user + " Edit icon,xpath,//td//span[.='" + user + "']/../..//div[@class='rs-tooltip-wrapper ']");
		pageLoaderLogo();
		String[] roleHeaders = BaseTest.getData().rolesUpdate.split(";");
		String[] userHeaders = roleHeaders[val].split("\\!");
		BaseTest.getTest().info(MarkupHelper.createLabel("<b>" + user + " Upate privilege</b>", ExtentColor.BLUE));

		List<WebElement> checkedStatus = findElements(PreferencesRepository.preferences_Userroles_Update_ListofRows);
		for (int i = 0; i < checkedStatus.size(); i++) {
			String headerName = checkedStatus.get(i).findElements(By.tagName("td")).get(0).getText();
			System.out.println(headerName);
			if (headerName.contains(userHeaders[i])) {
				BaseTest.getTest().log(Status.INFO, "<b>" + headerName + "</b> name field is checked.");

			} else {
				BaseTest.getTest().log(Status.WARNING, "<b>" + headerName + "</b> name field is unchecked.");

			}
		}
		javaScriptScrollIntoView(PreferencesRepository.preferences_existinguser_cancelbutton);
		clickElement(PreferencesRepository.preferences_existinguser_cancelbutton);

	}

	public void createprivilegevalidation(String user) {
		int val = user.contains("User") ? 0 : user.contains("Superuser") ? 1 : user.contains("Admin") ? 2 : 3;
		threadSleep(ObjectRepository.wait2sec);
		clickElement(PreferencesRepository.preferences_Userroles_paginationClick);
		selectlistelements(PreferencesRepository.preferences_Userroles_paginationSelect, "20");
		javaScriptScrollDown();
		clickElement(user + "Edit icon,xpath,//td//span[.='" + user + "']/../..//div[@class='rs-tooltip-wrapper ']");
		String[] roleHeaders = BaseTest.getData().rolesCreate.split(";");
		String[] userHeaders = roleHeaders[val].split("\\!");
		BaseTest.getTest().info(MarkupHelper.createLabel("<b>" + user + " Create privilege</b>", ExtentColor.BLUE));

		List<WebElement> checkedStatus = findElements(PreferencesRepository.preferences_Userroles_Create_ListofRows);
		for (int i = 0; i < checkedStatus.size(); i++) {
			String headerName = checkedStatus.get(i).findElements(By.tagName("td")).get(0).getText();

			if (headerName.contains(userHeaders[i])) {
				BaseTest.getTest().log(Status.INFO, "<b>" + headerName + "</b> name field is checked.");

			} else {
				BaseTest.getTest().log(Status.WARNING, "<b>" + headerName + "</b> name field is unchecked.");
			}
		}
		javaScriptScrollIntoView(PreferencesRepository.preferences_existinguser_cancelbutton);
		clickElement(PreferencesRepository.preferences_existinguser_cancelbutton);

	}

	public void clickalerts() {
		threadSleep(ObjectRepository.wait2sec);
		clickElement(PreferencesRepository.preferences_Alert);
		BaseTest.getTest().info(MarkupHelper.createLabel("PREFERENCES ALERTS & NOTIFICATION ", ExtentColor.BLUE));

	}

	public PreferencesPage alertsandnotification() {

		pageLoaderLogo();

		threadSleep(ObjectRepository.wait2sec);
		String userroleTitle = getStrText(PreferencesRepository.Preferences_alertstitle);
		if (userroleTitle.equals(PreferencesRepository.Preferences_alertstitle)) {
			BaseTest.getTest().log(Status.INFO, "Header title is Present");
			isDisplayed(PreferencesRepository.preferences_alertsGrid);
			BaseTest.getTest().info(MarkupHelper.createLabel("USERS ", ExtentColor.BLUE));
		} else {
			BaseTest.getTest().log(Status.FAIL, "Header title is not Present");
		}
		javaScriptScrollIntoView(PreferencesRepository.Preferences_alerts_secondpage);
		clickElement(PreferencesRepository.Preferences_alerts_secondpage);

		return this;

	}

	public void clickusermanagement() {
		threadSleep(ObjectRepository.wait2sec);
		clickElement(PreferencesRepository.preferences_usermanagement);
		BaseTest.getTest().info(MarkupHelper.createLabel("PREFERENCES USERS MANAGEMENT ", ExtentColor.BLUE));
	}

	public PreferencesPage usermanagementValidation(String mobileNumber, String eMail, String jobFunction) {
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait2sec);

		clickElement(PreferencesRepository.preferences_usermanagement_addbtn);
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_usermanagement_newuserpageTitle);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Mr.");// Mr.
		enterValue(PreferencesRepository.preferences_usermanagement_newuserfirstname, firstName);
		enterValue(PreferencesRepository.preferences_usermanagement_newuserlastname, lastName);
		enterValue(PreferencesRepository.preferences_usermanagement_newusermobileno, mobileNumber);
		enterValue(PreferencesRepository.preferences_usermanagement_newuseremail,
				eMail + addTimeToName() + "@resulticksmail.com");
		clickElement(PreferencesRepository.preferences_usermanagement_newuserjobfunction);
		threadSleep(ObjectRepository.wait3sec);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, jobFunction);
		enterValue(PreferencesRepository.preferences_usermanagement_newuserPassword, "Qateam@12345");
		tabAction();
		// clickElement(PreferencesRepository.preferences_usermanagement_newuserwelocomemsg);
		enterValue(PreferencesRepository.preferences_usermanagement_newuserwelocomemsg, "Welcome to the team");
		String passwordStrength = getTextBoxVal(PreferencesRepository.preferences_Users_passwordfieldStrength, "class");
		if (passwordStrength.contains("100")) {
//		String colorValue = getUiBackgroundColour("background-color", PreferencesRepository.preferences_usermanagement_newuserpassbgvalidation);
//		if (colorValue.equals("rgba(55, 153, 4, 1)")) // #5BA529
//		{
			BaseTest.getTest().log(Status.INFO, "Password Field color is equal to Green");
			BaseTest.takeScreenshot();
		} else {
			BaseTest.getTest().log(Status.FAIL, "Password Field color is not-equal to Green");
			BaseTest.takeScreenshot();
		}
		clickElement(PreferencesRepository.preferences_existinguser_Generatepasswordbutton);
		String Newpassword = getStrText(PreferencesRepository.preferences_usermanagement_newuserNewpassword);

		if (!Newpassword.isEmpty()) {
			clickElement(PreferencesRepository.preferences_existinguser_passwordpreview);
			String oldpassword = "Qateam@12345";
			if (Newpassword == oldpassword) {
				BaseTest.getTest().log(Status.FAIL, "Password should not be same as previous one");
			}
		}
		clickElement(PreferencesRepository.preferences_existinguser_enforceotp);
		threadSleep(ObjectRepository.wait2sec);

		clickElement(PreferencesRepository.preferences_existinguser_ADuser);
		clickElement(PreferencesRepository.preferences_existinguser_Generatepasswordbutton);
		clickElement(PreferencesRepository.preferences_existinguser_Generatepasswordbutton);
		enterValue(PreferencesRepository.preferences_usermanagement_newuserPassword, "Qateam@12345");

		tabAction();
		BaseTest.takeScreenshot();
		clickElement(PreferencesRepository.preferences_usermanagement_newuserpagesavebutton);
		adduserEdit(firstName, lastName);
		olduseredit();

		return this;
	}

	String firstName = "QATESTING" + addTimeToAlpha().replaceAll("_", "");
	String lastName = "Auto";

	public void adduserEdit(String firstName, String lastName) {
		pageLoaderLogo();
		clickElement("new user,xpath,//div[contains(@class,'roleusers-list css-scrollbar p0 position')]//li//span[.='"
				+ firstName + " " + lastName + "']");
		clickElement(PreferencesRepository.preferences_usermanagement_newuserarrow);
		clickElement(",xpath,//div[.='" + firstName + " " + lastName + "']/..//span[@class='k-input-inner']");
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "User");
		clickElement(PreferencesRepository.preferences_usermanagement_newuserpagesavebutton);
		pageLoaderLogo();
		if (isElementPresent(PreferencesRepository.preferences_usermanagement_newuserpagesavebutton)) {
			clickElement(PreferencesRepository.preferences_usermanagement_newuserSave);
			pageLoaderLogo();
		}
		return;
	}

	public void olduseredit() {
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_usermanagement_newuserClick);
		pageLoaderLogo();

		clickElement(PreferencesRepository.preferences_usermanagement_newuserjobfunction);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Business Analyst");
		clearField(PreferencesRepository.preferences_usermanagement_newuserlastname);
		enterValue(PreferencesRepository.preferences_usermanagement_newuserlastname, "Test");
		clickElement(PreferencesRepository.preferences_usermanagement_Update);
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_usermanagement_newuserProceed);
		pageLoaderLogo();
		String oldname = getStrText(PreferencesRepository.preferences_usermanagement_newuserlastname);
		String oldjob = getStrText(PreferencesRepository.preferences_usermanagement_newuserjoblist);

		if (oldname == "Test" || oldjob == "Business Analyst") {
			clickElement(PreferencesRepository.preferences_usermanagement_newuserCancel);
		}
		return;
	}

	public void clickCommunicationSettings() {
		threadSleep(ObjectRepository.wait2sec);
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_communicationsetting_icon);
		BaseTest.getTest().info(MarkupHelper.createLabel("PREFERENCES COMMUNCATION SETTINGS PAGE ", ExtentColor.BLUE));
		pageLoaderLogo();
	}

	public PreferencesPage communicationEmailvalidation() {
		String domainName = null;
		String DomainName1 = null;
		pageLoaderLogo();
		isDisplayed(PreferencesRepository.preferences_communicationsetting_page_mailicon);
		toolTipValidationprefernces(PreferencesRepository.preferences_communicationsetting_addicon, "Add SMTP");
		toolTipValidationprefernces(PreferencesRepository.preferences_communicationsetting_mailnewdomain_settings,
				"Domain settings");
		clickElement(PreferencesRepository.preferences_communicationsetting_mailnewdomain_settings);
		pageLoaderLogo();
		// toolTipValidationKnownText(PreferencesRepository.preferences_communicationsetting_addicon,
		// "Add domain name");
		clickElement(PreferencesRepository.preferences_communicationsetting_addicon);
		List<WebElement> placeholderValues = findElements(
				PreferencesRepository.preferences_commset_newdomain_placeholder);

		List<WebElement> inputFields = findElements(PreferencesRepository.preferences_commset_newdomain_inputfield);
		String[] placeholderInputs = BaseTest.getData().NewdomainPlaceholder.split("\\!");
		String[] newDomainInputs = BaseTest.getData().NewDomainvalues.split("\\!");
		for (int i = 0; i < placeholderValues.size(); i++) {
			String placeholderValue = placeholderValues.get(i).getText();
			System.out.println(placeholderValue);
			pageLoaderLogo();
			if (placeholderValue.equals(placeholderInputs[i])) {

				BaseTest.getTest().log(Status.INFO, placeholderValue + " placeholder value is present as expected.");
			} else {
				BaseTest.getTest().log(Status.WARNING,
						placeholderValue + " placeholder value is not present as expected.");
				BaseTest.takeScreenshot();
			}
			if (i == 0 || i == 9) {
				domainName = newDomainInputs[i] + prefaddTimeToName();
				if (i == 0) {
					DomainName1 = domainName;
				}
				System.out.println(domainName);

				inputFields.get(i).sendKeys(domainName);
			} else {
				System.out.println(newDomainInputs);

				inputFields.get(i).sendKeys(newDomainInputs[i]);
			}
		}
		tabAction();
		clickElement(PreferencesRepository.preferences_commset_newdomain_savebutton);
		pageLoaderLogo();
		javaScriptScrolltoTop();
		clickElement(PreferencesRepository.preferences_communicationsetting_page_messageicon);
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_communicationsetting_page_mailicon);
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_communicationsetting_addicon);
		pageLoaderLogo();
		List<WebElement> placeholderValues1 = findElements(
				PreferencesRepository.preferences_commset_newdomain_placeholder);
		List<WebElement> inputFields1 = findElements(PreferencesRepository.preferences_commset_newdomain_inputsettings);

		String[] placeholderInputs1 = BaseTest.getData().newdomainsetting.split("\\!");
		String[] newDomainInputs1 = BaseTest.getData().newdomainvalues.split("\\!");
		for (int i = 0; i < placeholderValues1.size(); i++) {
			if (i < 7) {
				String placeholderValue = placeholderValues1.get(i).getText();
				if (placeholderValue.equals(placeholderInputs1[i])) {
					System.out.println(placeholderValue);
					System.out.println(placeholderInputs1[i]);

					BaseTest.getTest().log(Status.INFO,
							placeholderValue + " placeholder value is present as expected.");
				} else {
					System.out.println(placeholderValue);
					System.out.println(placeholderInputs1[i]);

					BaseTest.getTest().log(Status.WARNING,
							placeholderValue + " placeholder value is not present as expected.");
					BaseTest.takeScreenshot();
				}

				inputFields1.get(i).clear();
				inputFields1.get(i).sendKeys(newDomainInputs1[i]);

			}
		}
		List<WebElement> dropdownDomain = findElements(PreferencesRepository.prefereneces_commset_domainset_dropdown);
		for (int j = 0; j < dropdownDomain.size(); j++)

		{
			dropdownDomain.get(j).click();
			if (j == 0) {
				threadSleep(ObjectRepository.wait2sec);
				System.out.println(DomainName1);

				selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, DomainName1);
				threadSleep(ObjectRepository.wait1sec);

			} else if (j == 1) {
				threadSleep(ObjectRepository.wait1sec);

				selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Warm up");
				threadSleep(ObjectRepository.wait1sec);

			} else {
				threadSleep(ObjectRepository.wait1sec);

				selectlistelements(DashboardRepository.allpage_common_selectdropdownlist,
						"SDC, MDC, Scheduled Trigger");
				threadSleep(ObjectRepository.wait1sec);

			}
		}
		clickElement(PreferencesRepository.prefereneces_commset_domainset_smpt_type);
		javaScriptScrollDown();
		clickElement(PreferencesRepository.preferences_commset_sms_SaveButton);
		pageLoaderLogo();
		clickElement(PreferencesRepository.prefereneces_commset_domainset_smpt_type_editicon);
		javaScriptScrollIntoView(PreferencesRepository.preferemces_commset_domainset_smpt_disableddomainname);
		threadSleep(ObjectRepository.wait5sec);
		WebElement Disabled = findElement(PreferencesRepository.preferemces_commset_domainset_smpt_disableddomainname);
		threadSleep(ObjectRepository.wait3sec);
		if (DomainName1.equals(Disabled.getText().trim())) {
			BaseTest.getTest().log(Status.INFO, "The Domain name is same as created domain settings as expected.");

		} else {
			BaseTest.getTest().log(Status.WARNING, "The Domain name is not same as created domain settings .");

		}
		javaScriptScrollDown();
		clickElement(PreferencesRepository.preferences_commset_cancelbutton_disableddomain);

		return this;

	}

	public PreferencesPage communicationSmppvalidation() {
		pageLoaderLogo();
		isDisplayed(PreferencesRepository.preferences_communicationsetting_page_messageicon);

		clickElement(PreferencesRepository.preferences_communicationsetting_page_messageicon);
		pageLoaderLogo();
		toolTipValidationKnownText(PreferencesRepository.preferences_communicationsetting_addicon, "Add");
		clickElement(PreferencesRepository.preferences_communicationsetting_addicon);
		pageLoaderLogo();

		List<WebElement> placeholderValues = findElements(
				PreferencesRepository.preferences_commset_newdomain_placeholder);
		for (int i = 0; i < placeholderValues.size(); i++) {
			tabAction();
		}

		List<WebElement> inputFields1 = findElements(PreferencesRepository.preferences_commset_newdomain_inputsettings);
		String[] placeholderInputs = BaseTest.getData().smppsettings.split("\\!");

		for (int i = 0; i < inputFields1.size(); i++) {

			WebElement placeholderValue = inputFields1.get(i);
			String value = placeholderValue.getText();
			if (!value.isEmpty()) {
				clearField(placeholderValue);
				WebElement placeholderValue1 = placeholderValues.get(i);

				String Clearfieldvalue = placeholderValue1.getText();

				System.out.println(Clearfieldvalue);
			} else if (value.isEmpty()) {
				tabAction();
				WebElement placeholderValue1 = placeholderValues.get(i);

				String Clearfieldvalue = placeholderValue1.getText();

				System.out.println(Clearfieldvalue);
				if (Clearfieldvalue.equals(placeholderInputs[i])) {

					BaseTest.getTest().log(Status.INFO, Clearfieldvalue + " placeholder value is present as expected.");
				} else {
					BaseTest.getTest().log(Status.WARNING,
							Clearfieldvalue + " placeholder value is not present as expected.");
					BaseTest.takeScreenshot();
				}
			}
		}
		javaScriptScrollDown();
		clickElement(PreferencesRepository.preferences_commset_cancelbutton_disableddomain);
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_communicationsetting_addicon);
		pageLoaderLogo();
		List<WebElement> inputFieldsentry = findElements(
				PreferencesRepository.preferences_commset_newdomain_inputsettings);
		String[] placeholderInputsentry = BaseTest.getData().smppsettingsvalues.split("\\!");

		for (int i = 0; i < inputFieldsentry.size(); i++) {
			inputFieldsentry.get(i).clear();
			inputFieldsentry.get(i).sendKeys(placeholderInputsentry[i]);
		}
		clickElement(PreferencesRepository.prefereneces_commset_domainset_dropdown);
		selectlistelements(PreferencesRepository.prefereneces_commset_domainset_dropdown_list, "Gupshup");
		clickElement(PreferencesRepository.preferences_commset_msgsmpp_smssettings_radiovalue);
		javaScriptScrollDown();
		clickElement(PreferencesRepository.preferences_commset_sms_SaveButton);
		pageLoaderLogo();
		toolTipValidationKnownText(PreferencesRepository.prefereneces_commset_domainset_smpt_type_editicon, "Edit");
		// toolTipValidationKnownText(PreferencesRepository.preferences_commset_smstooltipvalidation,
		// "SMS");

		clickElement(PreferencesRepository.prefereneces_commset_domainset_smpt_type_editicon);
		threadSleep(ObjectRepository.wait2sec);

		clearField(PreferencesRepository.preferences_commset_sms_editusernamae);
		enterValue(PreferencesRepository.preferences_commset_sms_editusernamae, prefaddTimeToName());
		threadSleep(ObjectRepository.wait2sec);
		String Username = getTextBoxVal(PreferencesRepository.preferences_commset_sms_editusernamae, "value");
		javaScriptScrollDown();

		clickElement(PreferencesRepository.preferences_commset_sms_SaveButton);
		clickElement(
				replacePlaceHolder(PreferencesRepository.preferences_commset_sms_editeduser_statusbutton, Username));
		threadSleep(ObjectRepository.wait5sec);

		String Statusvalue = getTextBoxVal(
				replacePlaceHolder(PreferencesRepository.preferences_commset_sms_user_statusvalidation, Username),
				"class");
		if (Statusvalue.contains("off")) {
			BaseTest.getTest().log(Status.INFO, " Status of " + Username + " is as expected OFF");
		} else {
			BaseTest.getTest().log(Status.WARNING, " Status of " + Username + " is as expected ON");

		}
		javaScriptScrolltoTop();

		return this;
	}

	public void commSettingswhatsappValidation(String providerSelect) {
		String[] placeholderInputs = BaseTest.getData().smppsettings.split("\\!");
		clickElement(PreferencesRepository.preferences_communicationsetting_page_messageicon);
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_commset_whatsapp_Icon);
		toolTipValidationKnownText(PreferencesRepository.preferences_communicationsetting_addicon, "Add");
		clickElement(PreferencesRepository.preferences_communicationsetting_addicon);
		pageLoaderLogo();
		List<WebElement> inputFieldwhatsapp = findElements(
				PreferencesRepository.preferences_commset_newdomain_inputsettings);
		List<WebElement> whatsappplaceholderValues = findElements(
				PreferencesRepository.preferences_commset_newdomain_placeholder);
		String[] placeholderInputs1 = BaseTest.getData().whatsappsettings.split("\\!");

		for (int i = 0; i < inputFieldwhatsapp.size(); i++) {
			WebElement whatsappsettingsfield = whatsappplaceholderValues.get(i);
			String values = whatsappsettingsfield.getText();
			if (values.equals(placeholderInputs1[i])) {
				BaseTest.getTest().log(Status.INFO, values + " placeholder value is present as expected.");
			} else {
				BaseTest.getTest().log(Status.FAIL, values + " placeholder value is not present as expected.");
				BaseTest.takeScreenshot();
			}
		}
		for (int i = 0; i < 10; i++) {
			tabAction();
		}

		List<WebElement> inputFields2 = findElements(PreferencesRepository.preferences_commset_newdomain_inputsettings);
		String[] placeholderInputs2 = BaseTest.getData().negativewhatsappsettings.split("\\!");

		for (int i = 0; i < inputFields2.size(); i++) {

			WebElement whatsappsettingsfield = whatsappplaceholderValues.get(i);
			String values = whatsappsettingsfield.getText();
			System.out.println(values);
			List<WebElement> placeholderValues = findElements(
					PreferencesRepository.preferences_commset_newdomain_placeholder);

			if (!values.isEmpty()) {
				WebElement placeholderValue1 = placeholderValues.get(i);
				String Clearfieldvalue = placeholderValue1.getText();

				System.out.println(Clearfieldvalue);
			} else if (values.isEmpty()) {
				tabAction();
				WebElement placeholderValue2 = placeholderValues.get(i);

				String Clearfieldvalue = placeholderValue2.getText();

				System.out.println(Clearfieldvalue);
				if (Clearfieldvalue.equals(placeholderInputs[i])) {

					BaseTest.getTest().log(Status.INFO, Clearfieldvalue + " placeholder value is present as expected.");
				} else {
					BaseTest.getTest().log(Status.FAIL,
							Clearfieldvalue + " placeholder value is not present as expected.");
					BaseTest.takeScreenshot();
				}
			}
		}
		List<WebElement> inputFields = findElements(PreferencesRepository.preferences_commset_newdomain_inputsettings);
		String[] smppFieldEnter = BaseTest.getData().whatsappField.split("!");

		for (int i = 0; i < inputFields.size(); i++) {
			inputFields.get(i).clear();
			inputFields.get(i).sendKeys(smppFieldEnter[i]);
		}
		javaScriptScrolltoTop();
		clickElement(PreferencesRepository.preferences_commset_newdomain_whatsappProvider);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, providerSelect);
		javaScriptScrollDown();
		clickElement(PreferencesRepository.preferences_commset_newdomain_whatsappSave);
		pageLoaderLogo();
		clickElement(",xpath,//span[contains(.,'" + providerSelect
				+ "')]//..//..//div[contains(@class,'rs-tooltip')]//i[@id='rs_data_pencil_edit']");
		clearField(PreferencesRepository.preferences_commset_newdomain_whatsappSenderID);
		String senderID = "Auto" + addTimeToName();
		sendValue(PreferencesRepository.preferences_commset_newdomain_whatsappSenderID, senderID);
		javaScriptScrolltoTop();
		clickElement(PreferencesRepository.preferences_commset_newdomain_whatsappProvider);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, providerSelect);
		sendValue(PreferencesRepository.preferences_commset_smpp_Whatsappcreate, "https//:conversion.com");
		javaScriptScrollDown();
		clickElement(PreferencesRepository.preferences_commset_newdomain_whatsappUpdate);
		pageLoaderLogo();
		String senderidtext = getStrText(
				",xpath,//div[contains(@class,'k-widget k-grid no-box')]//table//tbody//tr//span[.='" + providerSelect
						+ "']//../..//span[.='" + senderID + "']");
		if (senderID.equals(senderidtext)) {
			BaseTest.getTest().log(Status.INFO, senderidtext + " value is present as expected.");
		} else {
			BaseTest.getTest().log(Status.FAIL, senderidtext + " value is not present as expected.");
		}
	}

	public void clicMyProfile() {
		threadSleep(ObjectRepository.wait5sec);
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_preferencesModuleclick);
		threadSleep(ObjectRepository.wait3sec);

		mouseHover(PreferencesRepository.preferences_myprofile_iconclick);
		uiPageEqualswithInputValue(getStrText(PreferencesRepository.preferences_myprofile_tooltip),
				"Update and manage your profile");
		// toolTipValidationKnownText(PreferencesRepository.preferences_myprofile_tooltip,"Update
		// and manage your profile");
		clickElement(PreferencesRepository.preferences_myprofile_iconclick);
		threadSleep(ObjectRepository.wait5sec);
	}

	public void changepasswrd(String currentPswd, String newPswd) {
		String data = "";
		clickElement(PreferencesRepository.preferences_myprofile_changePassword);
		pageLoaderLogo();
		tabAction();
		explicitwaitforvisibility(autolocator(PreferencesRepository.preferences_myprofile_changepasswordHeader), 10);
		enterValue(PreferencesRepository.preferences_myprofile_currentpassword, currentPswd);
		tabAction();
		enterValue(PreferencesRepository.preferences_myprofile_newPassword, newPswd);
		tabAction();
		enterValue(PreferencesRepository.preferences_myprofile_confirmpassword, newPswd);
		tabAction();
		threadSleep(ObjectRepository.wait2sec);
		isDisplayedWar(PreferencesRepository.preferences_myprofile_OtpSentSuccessfully);

		pageLoaderLogo();
		BaseTest.takeScreenshot();
//	DataInputProvider.writeUpdatedValueInSheet(1, 1, "PreferencesRegression", "BaseData", data);

	}

	public PreferencesPage changePasswordOTP1(String OTP) {
		String[] otp = OTP.split("");
		List<WebElement> otpFields = findElements(PreferencesRepository.preferences_myprofile_OtpButton);
		if (otp.length == otpFields.size() && otpFields.size() == 6) {
			for (int field = 0; field < otpFields.size(); field++) {
				otpFields.get(field).sendKeys(otp[field]);
			}
		} else {
			BaseTest.getTest().log(Status.FAIL, "OTP field is in disable mode can't enter the otp");
		}
		tabAction();
		isDisplayedWar(PreferencesRepository.preferences_myprofile_ValidOtpField);
		explicitwaitforclick(autolocator(PreferencesRepository.preferences_myprofile_PassUpdateButton), 10);
		clickElement(PreferencesRepository.preferences_myprofile_PassUpdateButton);
		pageLoaderLogo();
		BaseTest.takeScreenshot();
		return this;
	}

	public PreferencesPage otpfieldEnter(String OTP) {
		String[] otp = OTP.split("");
		List<WebElement> otpFields = findElements(PreferencesRepository.preferences_myprofile_OtpButton);
		if (otp.length == otpFields.size() && otpFields.size() == 6) {
			for (int field = 0; field < otpFields.size(); field++) {
				otpFields.get(field).sendKeys(otp[field]);
			}
		} else {
			BaseTest.getTest().log(Status.FAIL, "OTP field is in disable mode can't enter the otp");
		}
		tabAction();
		isDisplayed(PreferencesRepository.preferences_myprofile_CsvDownload);
		explicitwaitforclick(autolocator(PreferencesRepository.preferences_myprofile_ProfileConfirmButton), 10);
		clickElement(PreferencesRepository.preferences_myprofile_ProfileConfirmButton);
		pageLoaderLogo();
		BaseTest.takeScreenshot();
		return this;
	}

	public void updateButton() {
		javaScriptScrollDown();
		clickElement(PreferencesRepository.preferences_myprofile_ProfileUpdateButton);
	}

	public void confirmButton() {
		javaScriptScrollDown();
		clickElement(PreferencesRepository.preferences_myprofile_ProfileConfirmButton);
	}

	public void profilePicUpload(String imagePath)
	{

		if (isElementAvailable(PreferencesRepository.preferences_myprofile_dppicturepencilIcon)) {
			String pathGrid = detectFilePath(imagePath);
			sendValue(PreferencesRepository.preferences_myprofile_dppicturepencilIcon, pathGrid);
			threadSleep(ObjectRepository.wait3sec);
			BaseTest.takeScreenshot();
		}
	}

	public void profilePictureUpload(String imagePath) {

		if (isElementAvailable(PreferencesRepository.preferences_myprofile_dppicturepencilIcon)) {
			String pathGrid = detectFilePath(imagePath);
			sendValue(PreferencesRepository.preferences_myprofile_dppicturepencilIcon, pathGrid);
			threadSleep(ObjectRepository.wait3sec);
			BaseTest.takeScreenshot();
		}
	}

	public void clickWebEditIcon(String domainname) {
		domainname = domainName.substring(0, 13) + "...";
		String xpath = ",xpath,//td//span[contains(.,'" + domainname
				+ "')]//../../..//li//i[@id='rs_data_pencil_edit']";
		explicitwaitforclick(autolocator(xpath), 90);
		clickElement(xpath);
	}

//	public void clickWebGoalIcon(String domainName)
//	{
//		domainName = domainName.substring(0, 13) + "...";
//		String xpath = "Goal icon click,xpath,//td//span[contains(.,'" + domainName + "')]//../../..//li//i[@class='icon-rs-goal-achieved-medium  icon-md color-primary-blue']";
//		explicitwaitforclick(autolocator(xpath), 90);
//		clickElement(xpath);
//	}

	String domainName = "AutoQA" + addTimeToName().replaceAll("_", "");

	// WebNotification
	public PreferencesPage webNotificationAnalyticsAdd() throws InterruptedException {
		String fcmId = addTimeToValue();
		String fcmPath = detectFilePath(BaseTest.curr_Dir + "\\src\\main\\resources\\data\\uploadfiles\\ResulAPI.json");
		String pathGrid = detectFilePath(
				BaseTest.curr_Dir + "/src\\main\\resources\\data\\uploadfiles\\Testing image.jpg");
		clickElement(PreferencesRepository.Preferences_CommunicationSettings_NotificationClick);
		pageLoaderLogo();
		if (isDisplayed(PreferencesRepository.Preferences_CommunicationSettings_Webnot_add)) {
			BaseTest.getTest().log(Status.INFO, "Communication Webnotification is displayed as expected");
		} else {
			BaseTest.getTest().log(Status.FAIL, "Communication Webnotification is not displayed as expected");
		}
		clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_add);// pageloader
		String domainUrl = BaseTest.getData().webDomainURL + addTimeToName().replaceAll("_", "") + ".com/";
		enterValue(PreferencesRepository.Preferences_CommunicationSettings_Webnot_domainname, domainName);
		enterValue(PreferencesRepository.Preferences_CommunicationSettings_Webnot_domainURL, domainUrl);

		sendValueWithoutFluent(PreferencesRepository.Preferences_CommunicationSettings_Webnot_DomainLogo, pathGrid);
		sendValueWithoutFluent(PreferencesRepository.Preferences_CommunicationSettings_Webnot_FcmLogo, fcmPath);

		pageLoaderLogo();
		javaScriptScrollDownToSomeExtend();
		enterValue(PreferencesRepository.Preferences_CommunicationSettings_Webnot_firebaseApikey, fcmId);
		javaScriptScrollDown();
		enterValue(PreferencesRepository.Preferences_CommunicationSettings_Webnot_firebase_authdomain, fcmId);
		enterValue(PreferencesRepository.Preferences_CommunicationSettings_Webnot_firebase_DatabaseURL, fcmId);
		enterValue(PreferencesRepository.Preferences_CommunicationSettings_Webnot_firebase_ProjectID, fcmId);
		enterValue(PreferencesRepository.Preferences_CommunicationSettings_Webnot_firebase_Storagebucket, fcmId);
		enterValue(PreferencesRepository.Preferences_CommunicationSettings_Webnot_firebase_MeasurementID, fcmId);
		enterValue(PreferencesRepository.Preferences_CommunicationSettings_Webnot_firebase_AppID, fcmId);
		enterValue(PreferencesRepository.Preferences_CommunicationSettings_Webnot_firebase_VAPID, fcmId);
		javaScriptScrollDown();
		clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_analyticsSavebtn);
		pageLoaderLogo();
		// clickElement(",xpath,(//i[@id='rs_data_pencil_edit'])[1]");
		clickWebEditIcon(domainName);
		javaScriptScrolltoTop();
		enterValue(PreferencesRepository.Preferences_CommunicationSettings_Webnot_domainname, domainName + "1");
		enterValue(PreferencesRepository.Preferences_CommunicationSettings_Webnot_domainURL, "https://conversion.net");
		List<WebElement> editablefield = findElements(PreferencesRepository.preferences_myprofile_Alldisabledfield);
		for (int i = 0; i < editablefield.size(); i++) {
			try {
				editablefield.get(i).click();
				BaseTest.getTest().log(Status.INFO, "All input values are in Editable as expected");
				javaScriptScrollDownToSomeExtend100();
			} catch (Exception e) {
				pageLoaderLogo();
			}
		}
		javaScriptScrollDown();
		clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_analyticsCancelbtn);
		pageLoaderLogo();
		return this;
	}

	public void goalWebpushComm() {
		String domainUrl = "https://visionmutual.qa.smartdx.co/EquityFunds.html";
		if (isDisplayed(PreferencesRepository.Preferences_CommunicationSettings_Webnot_VisionMutual)) {
			clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_lastpage);
			clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_Goal_VisionMutual);
			pageLoaderLogo();
			clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_AddGoal);
		} else {
			clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_Goal_VisionMutual);
			pageLoaderLogo();
			clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_AddGoal);
		}
		clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_lastpage);
		clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_Goal_VisionMutual);
		pageLoaderLogo();
		clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_AddGoal);
		if (isDisplayed(PreferencesRepository.Preferences_CommunicationSettings_Webnot_GoalHeader)) {
			BaseTest.getTest().log(Status.INFO, "Goal Settings is present as expected");
			enterValue(PreferencesRepository.Preferences_CommunicationSettings_Webnot_GoalName, domainName);
			isDisplayed(PreferencesRepository.Preferences_CommunicationSettings_Webnot_GoalSecHeader);
			enterValue(PreferencesRepository.Preferences_CommunicationSettings_Webnot_GoalFriendlyName,
					"AutoTest56789");
			clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_GoalType);
			selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Page URL");
			enterValue(PreferencesRepository.Preferences_CommunicationSettings_Webnot_GoalPageUrl, domainUrl);
		} else {
			BaseTest.getTest().log(Status.FAIL, "Goal Settings header is not present as expected");
		}
		threadSleep(ObjectRepository.wait2sec);
		clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_GoalSaveButton);

		boolean attributeNameAndValue = getAttributeNameAndValue(
				replacePlaceHolder(PreferencesRepository.Preferences_CommunicationSettings_Webnot_GoalOnOffButton,
						domainName),
				"aria-checked");

		if (attributeNameAndValue) {
			BaseTest.getTest().log(Status.INFO, "Goal Settings header is not present as expected");

		} else {
			BaseTest.getTest().log(Status.FAIL, "Goal Settings header is not present as expected");
		}
	}

	public void clickWebActionDropdown(String domainName) {
		domainName = domainName.substring(0, 13) + "...";
		String xpath = "Web action dropdown,xpath,//td//span[contains(.,'" + domainName
				+ "')]//../../..//li//i[@id='rs_PushWebGrid_arrowdown']";
		explicitwaitforclick(autolocator(xpath), 90);
		clickElement(xpath);

	}

	public void dataAttributeValidation(String pr, String firstattributename) {
		threadSleep(ObjectRepository.wait1sec);
		List<WebElement> totalattribute = findElements(pr);
		for (WebElement attributename : totalattribute) {
			String acquiredname = attributename.getText();
			if (acquiredname.contains(firstattributename)) {
				BaseTest.getTest().log(Status.WARNING,
						acquiredname + "---->name is present in selected filtergroup table");
				break;
			}
		}
	}

	public void webNotidropdwnValues() throws InterruptedException {
		String content = "";
		clickWebActionDropdown(domainName);
		clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_infodropdwnClick);
		pageLoaderLogo();

		List<WebElement> elements = driver.findElements(By.tagName("section"));
		for (int i = 1; i < elements.size(); i++) {

			String fullContent = elements.get(i).getText();
			content = content + fullContent;

			String expectedContent = BaseTest.getData().contentSDK;

			writeLog(content.equals(expectedContent), content, expectedContent);
			if (content.equals(expectedContent)) {
				BaseTest.takeScreenshot();
				BaseTest.getTest().log(Status.INFO, "Communication Webnotification info full content is as expected");

			} else {
				BaseTest.getTest().log(Status.FAIL,
						"Communication Webnotification info full content is not as expected");
			}
		}
		clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_infoBack);
		// String AttributeHeaderName = "Attributes,Events";
		clickWebActionDropdown(domainName);
		clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_settingsdropdwnClick);
		pageLoaderLogo();
		javaScriptScrollDown();
		javaScriptScrollUpToSomeExtend();
		clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_settingsAllattributes);
		String columnName = getStrText(
				PreferencesRepository.Preferences_CommunicationSettings_Webnot_settingsattributesrlft);

		clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_settingsattributesrlft);
		clickElement(PreferencesRepository.preferences_datacatalogue_rightarrowicon);
		clickElement(PreferencesRepository.preferences_datacatalogue_Updatebutton);
		dataAttributeValidation(PreferencesRepository.Preferences_CommunicationSettings_Webnot_settingsattributesAll,
				columnName);

		clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_settingsAllattributes);
		clickElement(",xpath,(//div[@class='multiClm multiRghtClm']//li)[1]//span[.='" + columnName + "']");
		clickElement(PreferencesRepository.preferences_datacatalogue_Leftrowicon);
		clickElement(PreferencesRepository.preferences_datacatalogue_Updatebutton);

		if (isDisplayed(PreferencesRepository.Preferences_CommunicationSettings_Webnot_headers)) {
			dataAttributeValidation(
					PreferencesRepository.Preferences_CommunicationSettings_Webnot_settingsattributesAll, columnName);
			BaseTest.getTest().log(Status.INFO, "Communication Webnotification attribute is present as expected");
		} else {
			BaseTest.getTest().log(Status.FAIL, "Communication Webnotification attribute is not present as expected");
		}
		if (isDisplayed(PreferencesRepository.Preferences_CommunicationSettings_Webnot_Inbox_headers)) {
			clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_ToogleButton);
		} else {
			BaseTest.getTest().log(Status.FAIL, "Communication Webnotification attribute is not present as expected");
		}
		enterValue(PreferencesRepository.Preferences_CommunicationSettings_Webnot_KeywordEnter, "Age").enterAction();
		enterValue(PreferencesRepository.Preferences_CommunicationSettings_Webnot_KeywordEnter, "Number").enterAction();
		clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_Refresh);
		clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_Save);
		pageLoaderLogo();

		if (isDisplayed(PreferencesRepository.Preferences_CommunicationSettings_Webnot_WebHeader)) {
			clickWebActionDropdown(domainName);
			clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_Download);
			BaseTest.getTest().log(Status.INFO, "Successfully downloaded the action dropdown </b>");
		} else {
			BaseTest.getTest().log(Status.FAIL, "Successfully not downloaded the action dropdown </b>");

		}
		clickWebActionDropdown(domainName);
		clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_Delete);
		BaseTest.getTest().log(Status.INFO, "Successfully deleted the action dropdown </b>");

	}

	public void clickMobileEditIcon(String domainame) {
		domainName = input.substring(0, 15).trim();
		String xpath = "Edit icon click,xpath,//div[@class='rs-tooltip-wrapper ']//label[contains(.,'" + domainName + "')]/../../../..//i[@id='rs_data_pencil_edit']";
		clickElement(xpath);
	}

	public void clickMobileSettingsIcon(String domainame) {
		domainName = input.substring(0, 15).trim();
		String xpath = "Edit icon click,xpath,//label[contains(.,'" + domainName
				+ "')]/../../../..//i[@id='rs_AppListRowCell_Settings']";
		clickElement(xpath);
	}

	public void clickMobileGoalIcon(String domainName) {
		domainName = input.substring(0, 14).trim();
		String xpath = "Mobile Goal icon click,xpath,//div[@class='rs-tooltip-wrapper ']//label[contains(.,' "
				+ domainName + "')]/../../../..//i[@id='rs_AppListRowCell_Goal']";
		explicitwaitforclick(autolocator(xpath), 90);
		threadSleep(ObjectRepository.wait2sec);
		clickElement(xpath);
	}

	public void clickMobActionDropdown(String domainName) {
		domainName = input.substring(0, 14).trim();
		String xpath = "Web action dropdown,xpath,//label[contains(.,'" + domainName
				+ "')]//..//..//..//..//i[@id='rs_AppListRowCell_Arrowdown']";
		explicitwaitforclick(autolocator(xpath), 90);
		threadSleep(ObjectRepository.wait2sec);
		clickElement(xpath);
	}

	String input = "AutoTestApp" + addTimeToName().replace("_", "");

	public String CommsettNotificationMobile(String Language) {
		String uploadData = detectFilePath(
				BaseTest.curr_Dir + "\\src\\main\\resources\\data\\uploadfiles\\ResulAPI.json");

		String App = null;
		boolean flag = false;
		pageLoaderLogo();
		clickElement(PreferencesRepository.Preferences_CommunicationSettings_NotificationClick);
		explicitwaitforclick(autolocator(PreferencesRepository.Preferences_CommSettings_mobileApp), 30);
		pageLoaderLogo();
		clickElement(PreferencesRepository.Preferences_CommSettings_mobileApp);
		BaseTest.takeScreenshot();
		pageLoaderLogo();
		if (isDisplayed(PreferencesRepository.Preferences_CommSettings_addMobileApp)) {
		}
		clickElement(PreferencesRepository.Preferences_CommSettings_addMobileApp);
		explicitwaitforclick(autolocator(PreferencesRepository.Preferences_CommSettings_Appname_inputBox), 30);
		// String input = "AutoTestApp" + addTimeToName().replace("_", "");
		enterValue(PreferencesRepository.Preferences_CommSettings_Appname_inputBox, input);
		pageLoaderLogo();
		tabAction();

		// Device Configuration
		if (isDisplayed(PreferencesRepository.Preferences_CommSettings_DeviceSetup)) {
			javaScriptScrollDownToSomeExtend();
			clickElement(PreferencesRepository.Preferences_CommSettings_Mobileplatform);
			selectlistelements(PreferencesRepository.Preferences_CommSettings_MobileplatformList, "Android phone");
			enterValue(PreferencesRepository.Preferences_CommSettings_Mobile_AppStoreURL,
					"https://play.google.com/store/apps/details?id=com.interakt.visionbank");
			javaScriptScrollDownToSomeExtend();
			clickElement(PreferencesRepository.Preferences_CommSettings_MobileNotifyProvider);
			sendValues(PreferencesRepository.Preferences_CommSettings_MobileNotify, uploadData);
			if (Language.equalsIgnoreCase("Native"))
			{
				clickElement(PreferencesRepository.Preferences_CommSettings_Mobile_NativeLanguage);
				BaseTest.getTest().log(Status.INFO, "Successfully cliked the Mobile native language");

			} else if (Language.equalsIgnoreCase("Hybrid")) {
				clickElement(PreferencesRepository.Preferences_CommSettings_Mobile_HybridLanguage);
				clickElement(PreferencesRepository.Preferences_CommSettings_HybridApp_DropdownClick);
				selectlistelements(PreferencesRepository.Preferences_CommSettings_HybridApp_DropdownList,
						"React Native");
			}
		}
		clickElement(PreferencesRepository.Preferences_CommSettings_MobileNotifyAppAnalytics);
		javaScriptScrollDown();
		clickElement(PreferencesRepository.Preferences_CommSettings_MobileNotifyPlatform);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Resulticks Mobile App Analytics");
		enterValue(PreferencesRepository.Preferences_CommSettings_MobileNotifyAppServiceEmail, "1234567");
		enterValue(PreferencesRepository.Preferences_CommSettings_MobileNotifyAppKey, "1234567");
		enterValue(PreferencesRepository.Preferences_CommSettings_MobileNotifySecretKey, "1234567");
		clickElement(PreferencesRepository.Preferences_CommSettings_MobileNotifyAppAnalyticsAdd);
		javaScriptScrollDown();
		clickElement(PreferencesRepository.Preferences_CommSettings_MobileNotifyAppAnalyticsMinus);
		mouseHover(PreferencesRepository.Preferences_CommSettings_AppCancelBtn);
		BaseTest.takeScreenshot();
		clickElement(PreferencesRepository.Preferences_CommSettings_AppSaveBtn);
		pageLoaderLogo();

		// Onboarded App Validation
		List<WebElement> appName = findElements(PreferencesRepository.Preferences_CommSettings_AppList);
		for (WebElement str : appName) {
			App = str.getText().trim();
			if (App.equals(input)) {
				javaScriptHighLightwithScrnShot(str);
				BaseTest.getTest().log(Status.INFO,
						"After OnBoarding --> The " + App + " app founded in apps listing page");
				break;
			} else {
				flag = true;
			}
		}
		if (flag) {
			BaseTest.getTest().log(Status.FAIL,
					"After OnBoarding --> The " + App + " app not founded in apps listing page");
			BaseTest.takeScreenshot();
		}
		clickMobileEditIcon(input);
		List<WebElement> editableField = driver.findElements(By.xpath("//input[@type='text']"));
		for (int i = 0; i < editableField.size(); i++) {
			isElementAvailable(",xpath,(//input[@type='text'])[" + i + "]");
		}
		clickElement(PreferencesRepository.Preferences_CommSettings_AppCancelBtn);
		pageLoaderLogo();

		return input;
	}

	public void notificationGoalMobile() {
		if (isDisplayed(PreferencesRepository.Preferences_CommunicationSettings_Webnot_VisionMutual)) {
			clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_lastpage);
			clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_Goal_VisionMutual);
			pageLoaderLogo();
			clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_AddGoal);
		} else {
			clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_Goal_VisionMutual);
			pageLoaderLogo();
			clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_AddGoal);
		}
		if (isDisplayed(PreferencesRepository.Preferences_CommunicationSettings_Webnot_GoalHeader)) {
			enterValue(PreferencesRepository.Preferences_CommSettings_MobActionGoalname, domainName);
			clickElement(PreferencesRepository.Preferences_CommSettings_MobActionGoalPlatform);
			selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Android phone");
			isElementPresent(PreferencesRepository.Preferences_CommunicationSettings_Webnot_GoalSecHeader);

			enterValue(PreferencesRepository.Preferences_CommSettings_MobActionGoalfriendlyName, "AutoTest56789");
			clickElement(PreferencesRepository.Preferences_CommSettings_MobActionGoaltype);
			selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Screen");
			enterValue(PreferencesRepository.Preferences_CommSettings_MobActionGoalPageUrl, input);
			enterValue(PreferencesRepository.Preferences_CommSettings_MobActionGoalPageSubUrl, input);

		} else {
			BaseTest.getTest().log(Status.FAIL, "Goal Settings header is not present as expected");
		}
		clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_GoalSaveButton);

		boolean attributeNameAndValue = getAttributeNameAndValue(
				replacePlaceHolder(PreferencesRepository.Preferences_CommunicationSettings_Webnot_GoalOnOffButton,
						domainName),
				"aria-checked");
		if (attributeNameAndValue) {
			BaseTest.getTest().log(Status.INFO, "Goal Settings header is not present as expected");

		} else {
			BaseTest.getTest().log(Status.FAIL, "Goal Settings header is not present as expected");

		}
		clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_Goalback);
	}

	public void mobileActionsDropdwn() {
		String content = "";
		clickElement(PreferencesRepository.Preferences_CommSettings_MobDropdwnClick);
		// clickMobActionDropdown(domainName);
		clickElement(PreferencesRepository.Preferences_CommSettings_MobDropdwnView);
		List<WebElement> elements = driver.findElements(By.tagName("section"));
		for (int i = 1; i < elements.size(); i++) {

			String fullContent = elements.get(i).getText();
			content = content + fullContent;

			String expectedContent = BaseTest.getData().contentSDK;
		}
	}

	public void mobileSettings() {
		clickMobileSettingsIcon(domainName);
		pageLoaderLogo();
		javaScriptScrollDown();
		javascriptdoublescrollup();
		clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_settingsAllattributes);
		String columnName = getStrText(
				PreferencesRepository.Preferences_CommunicationSettings_Webnot_settingsattributesrlft);

		clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_settingsattributesrlft);
		clickElement(PreferencesRepository.preferences_datacatalogue_rightarrowicon);
		clickElement(PreferencesRepository.preferences_datacatalogue_Updatebutton);
		dataAttributeValidation(PreferencesRepository.Preferences_CommunicationSettings_Webnot_settingsattributesAll,
				columnName);

		clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_settingsAllattributes);
		clickElement(PreferencesRepository.preferences_datacatalogue_Leftrowicon);
		clickElement(PreferencesRepository.preferences_datacatalogue_Updatebutton);

		if (isDisplayed(PreferencesRepository.Preferences_CommunicationSettings_Webnot_headers)) {
			dataAttributeValidation(
					PreferencesRepository.Preferences_CommunicationSettings_Webnot_settingsattributesAll, columnName);
			BaseTest.getTest().log(Status.INFO, "Communication Webnotification attribute is present as expected");
		} else {
			BaseTest.getTest().log(Status.FAIL, "Communication Webnotification attribute is not present as expected");
		}
		if (isDisplayed(PreferencesRepository.Preferences_CommunicationSettings_Webnot_Inbox_headers)) {
			clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_ToogleButton);
		} else {
			BaseTest.getTest().log(Status.FAIL, "Communication Webnotification attribute is not present as expected");
		}
		javaScriptScrollDown();
		enterValue(PreferencesRepository.Preferences_CommunicationSettings_Webnot_KeywordEnter, "Age").enterAction();
		enterValue(PreferencesRepository.Preferences_CommunicationSettings_Webnot_KeywordEnter, "Number").enterAction();
		clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_Refresh);
		enterValue(PreferencesRepository.Preferences_CommunicationSettings_Webnot_KeywordEnter, "Age").enterAction();
		clickElement(PreferencesRepository.Preferences_CommunicationSettings_Webnot_Save);
		pageLoaderLogo();

	}

	public void preferenceModuleClick() {
		BaseTest.getTest().info(MarkupHelper.createLabel("PREFERENCES - DATA CATALOGUE ", ExtentColor.BROWN));
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait3sec);
		clickElement(PreferencesRepository.preferences_preferencesModuleclick);
		pageLoaderLogo();
	}

	////////// ALERTS AND NOTIFICATIONS///////////////
	public boolean dateCompareinUTC(String uiDate, String fomat) throws ParseException {
		boolean flag;
		DateFormat formatterCalendarUI = new SimpleDateFormat(fomat);
		Date date1 = formatterCalendarUI.parse(uiDate);
		formatterCalendarUI.setTimeZone(TimeZone.getTimeZone("UTC"));
		Instant uiDate1 = date1.toInstant();
		Instant currentTime = Instant.now().minus(Duration.ofMinutes(10));
		if (uiDate1.isAfter(currentTime)) {
			BaseTest.getTest().info("Compared date is recent date");
			flag = true;
		} else {
			BaseTest.getTest().info("Compared date is lesser than the current time");
			flag = false;
		}
		return flag;
	}


	public PreferencesPage notificationsPageChangesUpdateVerify(String notificationContent) throws ParseException
	{
		refresh();
		threadSleep(ObjectRepository.wait3sec);
		clickElement(PreferencesRepository.preferences_alertsnotification_selectnotificationlistbar);
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_alertnotification_NotificationViewAll);
		pageLoaderLogo();
		driver.navigate().refresh();
		int count = 1;
		while (true) {
			boolean notification = false;
			List<WebElement> descrow = driver
					.findElements(autolocator(PreferencesRepository.preferences_alertsnotification_descriptionrow));
			int rowCount = 1;	
			for (WebElement li : descrow) {
				String in = li.getText();
				if (li.getText().toLowerCase().contains(notificationContent.toLowerCase()))// "profile has been updated"
				{
					BaseTest.getTest().info("Alert and notification received");

					String timeUI = getStrText("Get date,xpath,(//thead[@class='k-grid-header']/..//tbody//tr/td[2])[" + rowCount + "]");
					// dateCompareinUTC(timeUI, dateFormat);
					if (timeUI.contains(notificationContent))
					{
						BaseTest.getTest().log(Status.INFO, "Alert & Notification is updated as expected");

					} else
					{
						BaseTest.getTest().log(Status.FAIL, "Alert & Notification is not updated as expected");

					}
					notification = true;
					break;
				}

					rowCount++;			
			}
			if (notification || count == 9) {
				if (!notification) {
					BaseTest.getTest().fail("Alert and notification not received");
				}
				threadSleep(ObjectRepository.wait2sec);
				BaseTest.takeScreenshot();
				break;
			}
			driver.navigate().refresh();
			threadSleep(ObjectRepository.wait10sec);
			count++;
		}
		return this;
	}


	public boolean toggleButtonState(String alertType) {
		boolean toggleButtonstate;
		boolean on = true;
		boolean off = false;
		toggleButtonstate = off;
		String toggleButton = getTextBoxVal("Toggle button,xpath,//td[contains(.,'" + alertType + "')]/..//span[@dir]",
				"class");
		if (toggleButton.contains("switch-on")) {
			toggleButtonstate = on;
		}

		return toggleButtonstate;
	}


	public String prefSelectImportsource()
	{
		String addAudienceby = "CSV";
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_uploadheader), 40);
		explicitwaitforclick(autolocator(AudienceRepository.audience_selectsource), 30);
		placeholderValueCheck(AudienceRepository.audience_selectsource_placeholder, "Source");
		pageLoaderLogo();
		clickElement(AudienceRepository.audience_selectsource);
		uiPageEqualswithMultipleInputValue(DashboardRepository.homepage_audience_uploadsourceselect,
				"Manual entry,CSV,Remote data source,FTP/SFTP");
		pageLoaderLogo();
		audienceSelectlistelements(DashboardRepository.allpage_common_selectdropdownlist, addAudienceby);
		pageLoaderLogo();
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_selectsourcereseticon), 30);
		// toolTipValidationKnownText(AudienceRepository.audience_selectsourcereseticon,
		// "Reset");
		return addAudienceby;
	}

	public void clickAlertsandNotificationToggleButtonOff(String alertType)
	{
		explicitwaitforclick(autolocator(alertType + " toggle button,xpath,//td//span[contains(.,'" + alertType + "')]//../..//span[contains(@class,'k-switch-track')]"), 20);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(alertType + " toggle button,xpath,//td//span[contains(.,'" + alertType + "')]//../..//span[contains(@class,'k-switch-track')]");
		pageLoaderLogo();
		BaseTest.takeScreenshot();
		String toggleButton = getTextBoxVal("Toggle button,xpath,//td[contains(.,'" + alertType + "')]/..//span[@dir]", "class");
		if (toggleButton.contains("switch-off"))
		{
			BaseTest.getTest().log(Status.INFO, alertType + " toggle button is clicked OFF");
		} else
		{
			BaseTest.getTest().log(Status.WARNING, alertType + " toggle button is clicked ON");
		}
	}
	public void clickAlertsandNotificationToggleButtonOn(String alertType)
	{
		explicitwaitforclick(autolocator(alertType + " toggle button,xpath,//td//span[contains(.,'" + alertType + "')]//../..//span[contains(@class,'k-switch-track')]"), 20);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(alertType + " toggle button,xpath,//td//span[contains(.,'" + alertType + "')]//../..//span[contains(@class,'k-switch-track')]");
		threadSleep(ObjectRepository.wait3sec);
		pageLoaderLogo();
		BaseTest.takeScreenshot();
		String toggleButton = getTextBoxVal("Toggle button,xpath,//td[contains(.,'" + alertType + "')]/..//span[@dir]", "class");
		if (toggleButton.contains("switch-on"))
		{
			BaseTest.getTest().log(Status.INFO, alertType + " toggle button is clicked ON");
		} else
		{
			BaseTest.getTest().log(Status.WARNING, alertType + " toggle button is turned OFF");
		}
	}
	public void clickAlertsandNotificationToggleButton(String alertType)
	{
		explicitwaitforclick(autolocator(alertType + " toggle button,xpath,//td//span[contains(.,'" + alertType + "')]//../..//span[contains(@class,'k-switch-track')]"), 20);
		threadSleep(ObjectRepository.wait3sec);
		pageLoaderLogo();
		BaseTest.takeScreenshot();
		String toggleButton = getTextBoxVal("Toggle button,xpath,//td[contains(.,'" + alertType + "')]/..//span[@dir]", "class");
		if (toggleButton.contains("switch-off"))
		{
			clickElement("Toggle button,xpath,//td[contains(.,'" + alertType + "')]/..//span[@dir]");
			threadSleep(ObjectRepository.wait3sec);
			toggleButton = getTextBoxVal("Toggle button,xpath,//td[contains(.,'" + alertType + "')]/..//span[@dir]", "class");
		}
		if (toggleButton.contains("switch-on"))
		{
			BaseTest.getTest().log(Status.INFO, alertType + " toggle button is clicked ON");
		} else
		{
			BaseTest.getTest().log(Status.WARNING, alertType + " toggle button is turned OFF");
		}
	}

	public void alertandnotificationClick() {
		pageLoaderLogo();
		explicitwaitforclick(autolocator(PreferencesRepository._preferences_alertandnotification_Click), 40);
		clickElement(PreferencesRepository._preferences_alertandnotification_Click);
		pageLoaderLogo();
		BaseTest.getTest().info(MarkupHelper.createLabel("Alerts and Notification", ExtentColor.BLUE));
	}

	public void alertandnotificationOnOfftogglebutton()
	{
		clickElement(PreferencesRepository._preferences_alertandnotification_ToggleButton);
		selectlistelements(PreferencesRepository._preferences_alertandnotification_pagination, "10");

		// javaScriptScrolltoTop();
		String[] alerts = { "Account setup notifications", "Audience import and segmentation", "Campaign status alerts", "Campaign analytics", "Profile and account settings notifications", "Benchmark settings", "Configuration settings", "Forms",
				"Offers", "Billing and usage" };
		// int count = 0;
		int page = 1;
		for (int i = 0; i < alerts.length; i++)
		{
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,50)");

			if (!toggleButtonState(alerts[i]))
			{
				clickAlertsandNotificationToggleButton(alerts[i]);
			}
		}
		javaScriptScrolltoTop();
		for (int i = 0; i < alerts.length; i++)
		{
			if (toggleButtonState(alerts[i]))
			{
				clickAlertsandNotificationToggleButtonOff(alerts[i]);
			}
			if (!toggleButtonState(alerts[i]))
			{
				BaseTest.getTest().log(Status.PASS, alerts[i] + " toggle button is turn OFF as expected");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, alerts[i] + " toggle button is not turn OFF");
				BaseTest.takeScreenshot();
			}
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,50)");
		}
		javaScriptScrolltoTop();
		for (int i = 0; i < alerts.length; i++)
		{
			if (!toggleButtonState(alerts[i]))
			{
				clickAlertsandNotificationToggleButtonOn(alerts[i]);
			}
			if (toggleButtonState(alerts[i]))
			{
				BaseTest.getTest().log(Status.PASS, alerts[i] + " toggle button is turn ON as expected");
			} else
			{
				BaseTest.getTest().log(Status.FAIL, alerts[i] + " toggle button is not turn ON");
				BaseTest.takeScreenshot();
			}
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,50)");
		}
		refresh();
		threadSleep(ObjectRepository.wait10sec);
		pageLoaderLogo();
		explicitwaitforvisibility(autolocator(PreferencesRepository._preferences_alertandnotification_notificationClick), 20);
		clickElement(PreferencesRepository._preferences_alertandnotification_notificationClick);
		pageLoaderLogo();
		clickElement(PreferencesRepository._preferences_alertandnotification_notificationSettingsClick);
		BaseTest.takeScreenshot();

	}

	public void myprofileValidate() {
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_myprofile_iconclick);
		pageLoaderLogo();
		explicitwaitforvisibility(autolocator(PreferencesRepository.preferences_myprofile_SelectFirstname), 20);
		pageLoaderLogo();
		if (isDisplayed(PreferencesRepository.preferences_myprofile_SelectFirstname)) {
			myProfileName = getTextBoxVal(PreferencesRepository.preferences_myprofile_SelectFirstname, "value");
		}

		if (isDisplayed(PreferencesRepository.preferences_myprofile_Updatemobilenumber)) {
			clickElement(PreferencesRepository.preferences_myprofile_Updatemobilenumber);
			explicitwaitforvisibility(autolocator(PreferencesRepository.preferences_myprofile_Updatemobilenumber), 10);
			String changenumberheader = getStrText(PreferencesRepository.preferences_myprofile_Updatemobilenumber)
					.trim();
			uiPageEqualswithInputValue(changenumberheader, "Update mobile number?");
			clickElement(PreferencesRepository.preferences_myprofile_UpdatemobilenumberCancel);
		}
		profilePictureUpload(BaseTest.curr_Dir + "\\src\\main\\resources\\data\\uploadfiles\\Testing image.jpg");
		pageLoaderLogo();
		if (isDisplayed(PreferencesRepository.preferences_myprofile_ChangepasswordClick)) {
			clickElement(PreferencesRepository.preferences_myprofile_ChangepasswordClick);
			explicitwaitforvisibility(autolocator(PreferencesRepository.preferences_myprofile_ChangepasswordHeader),
					10);
			String changepasswordheader = getStrText(PreferencesRepository.preferences_myprofile_ChangepasswordHeader)
					.trim();
			uiPageEqualswithInputValue(changepasswordheader, "Change password");
			isDisplayed(PreferencesRepository.preferences_myprofile_ChangeCurrentpassword);
			clickElement(PreferencesRepository.preferences_myprofile_changepsswrdCancel);
		}

		clickElement(PreferencesRepository.preferences_myprofile_Zipcode);
		enterValue(PreferencesRepository.preferences_myprofile_Zipcode, "600006");
		javaScriptScrollDown();
		explicitwaitforclick(autolocator(PreferencesRepository.preferences_myprofile_Savemyprofile), 10);
		clickElement(PreferencesRepository.preferences_myprofile_Savemyprofile);
		pageLoaderLogo();

	}

	public void validateAttribute(String attributeName) {
		role = "UserRoletest" + addTimeToName().replaceAll("_", "");
		toolTipValidationKnownText(PreferencesRepository.preferences_Userroles_addicon, "Add");
		clickElement(PreferencesRepository.preferences_Userroles_addicon);
		if (isDisplayed(PreferencesRepository.preferences_addUser_namefield)) {
			sendValue(PreferencesRepository.preferences_addUser_nameentryfield, role);
			clickElement(PreferencesRepository.preferences_adduser_Accessprivileges);
			javaScriptScrollIntoView(PreferencesRepository.prefernces_adduser_updatebutton);
			clickElement(PreferencesRepository.prefernces_adduser_updatebutton);
			pageLoaderLogo();
			if (isElementPresent("Edit attribute header,xpath,//h2[.='Edit attribute']")) {
				String dataCatalogueAttributeName = getTextBoxVal(AudienceRepository.audience_newattributename,
						"value");
				uiPageEqualswithInputValue(dataCatalogueAttributeName, attributeName);
				clearField(AudienceRepository.audience_newattributename);
				String editAttributeName = "Edit_" + attributeName;
				enterValue(AudienceRepository.audience_newattributename, editAttributeName);
				BaseTest.takeScreenshot();
				clickElement(PreferencesRepository.preferences_datacatalogue_updateicon);
				pageLoaderLogo();
				if (selectlistelements(PreferencesRepository.preferences_datacatalogue_availableattributes,
						editAttributeName)) {
					pageLoaderLogo();
					String descName = getTextBoxVal(AudienceRepository.audience_newattributename, "value");
					uiPageEqualswithInputValue(descName, editAttributeName);
					String iconStatus = getTextBoxVal(PreferencesRepository.preferences_datacatalogue_updateicon,
							"class");
					if (iconStatus.contains("off")) {
						BaseTest.getTest().log(Status.INFO,
								"When Edit the attribute update button is disable as expected.");
						BaseTest.takeScreenshot();
					} else {
						BaseTest.getTest().log(Status.FAIL, "When Edit the attribute update button is enable.");
						BaseTest.takeScreenshot();
					}
				} else {
					BaseTest.getTest().log(Status.FAIL, "After edit attribute name is not displayed.");
				}
			} else {
				BaseTest.getTest().log(Status.FAIL, "Attribute Edit popup is not displayed.");
			}

		} else {
			BaseTest.getTest().log(Status.INFO, "Unable to create user - max limit exceeds");
		}

	}

	public void dataCatalogueClick() {
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_dataCatalogue_Click);
		threadSleep(ObjectRepository.wait5sec);
		pageLoaderLogo();
	}

	public void pw_dataCatalogueClick() throws InterruptedException {
		clickElement(PreferencesRepository.pw_preferences_DataCatalogue_Click);
		pw_pageLoaderLogo();
	}

	public void addAttribute() {
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_DataCatalogue_AddClick);
	}

	public void attricolorvalidation() {

		// 1
		javaScriptScrollDown();
		String Palegray = getUiBackgroundColour("background-color",
				PreferencesRepository.preferences_datacatalogue_Dataingestedcolor);
		if (Palegray.equalsIgnoreCase("#f6f7f8")) {

			BaseTest.getTest().info("Error message colour is validated successfully");
			BaseTest.takeScreenshot();
		} else {
			BaseTest.getTest().fail("Error message colour is mismatched");
			BaseTest.takeScreenshot();
		}
		// 2
		String Green = getUiBackgroundColour("background-color",
				PreferencesRepository.preferences_datacatalogue_Transactiondatacolor);
		if (Green.equalsIgnoreCase("#f1f8d9")) {
			BaseTest.getTest().info("Error message colour is validated successfully");
			BaseTest.takeScreenshot();
		} else {
			BaseTest.getTest().fail("Error message colour is mismatched");
			BaseTest.takeScreenshot();
		}
		// 3
		String Blue = getUiBackgroundColour("background-color",
				PreferencesRepository.preferences_datacatalogue_KPIdatacolor);
		if (Blue.equalsIgnoreCase("#eff8ff")) {
			BaseTest.getTest().info("Error message colour is validated successfully");
			BaseTest.takeScreenshot();
		} else {
			BaseTest.getTest().fail("Error message colour is mismatched");
			BaseTest.takeScreenshot();

		}
		// 4
		String Orange = getUiBackgroundColour("background-color",
				PreferencesRepository.preferences_datacatalogue_Sensitivedatacolor);
		if (Orange.equalsIgnoreCase("#fee7d7")) {
			BaseTest.getTest().info("Error message colour is validated successfully");
			BaseTest.takeScreenshot();
		} else {
			BaseTest.getTest().fail("Error message colour is mismatched");
			BaseTest.takeScreenshot();
			javaScriptScrolltoTop();

		}
	}

	// h4[text()='Brand']/ancestor::div[contains(@class,'clearfix')]//i[contains(@id,'data_pencil_edit')]


	public void datacatalogueAttributeSelection1(String headername) throws InterruptedException
	{
		String dataCataloguetxt = getStrText(PreferencesRepository.preferences_DataCatalogue_Breadcrumb);
		if (dataCataloguetxt.contains("Data catalogue"))
		{
			BaseTest.getTest().log(Status.INFO, "Data catalogue page breadcrumb text is present as expected.");
			BaseTest.takeScreenshot();
		} else {

			BaseTest.getTest().log(Status.FAIL, "Data catalogue page breadcrumb text is not present.");
			BaseTest.takeScreenshot();
		}

		String id = null;
		if (headername.contains("Filtergroups")) {
			clickElement(PreferencesRepository.preferences_datacatalogue_filtergroup);
			id = "categoryEdit";
		} else if (headername.contains("Classification")) {	   
			actionScrollToElement(PreferencesRepository.preferences_datacatalogue_classification);
		    clickElement(PreferencesRepository.preferences_datacatalogue_classification);
		    
			id = "classificationEdit";
		}
		List<WebElement> filtergroupheader = findElements(
				PreferencesRepository.preferences_datacatalogue_filtergroupheader);
		for (int i = 0; i < filtergroupheader.size(); i++) {
			filtergroupheader = findElements(PreferencesRepository.preferences_datacatalogue_filtergroupheader);
			String acquiredheadername = filtergroupheader.get(i).getText();

			if (!acquiredheadername.isEmpty()) {
				BaseTest.getTest().log(Status.INFO,
						"Current Header name is -----> " + "<b>" + acquiredheadername + "</b>");
			}

			if (isDisplayed(PreferencesRepository.preferences_datacatalogue_editicon
					.replace(PreferencesRepository.dynamicXpathprefernces, acquiredheadername))) {
				if (!getTextBoxVal(PreferencesRepository.preferences_datacatalogue_editicon
								.replace(PreferencesRepository.dynamicXpathprefernces, acquiredheadername), "class").contains("click-off")){	
					try {
						clickElement(PreferencesRepository.preferences_datacatalogue_editicon
								.replace(PreferencesRepository.dynamicXpathprefernces, acquiredheadername));
					} catch (Exception e) {
						javaScriptScrollDownToSomeExtend();
						clickElement(PreferencesRepository.preferences_datacatalogue_editicon
								.replace(PreferencesRepository.dynamicXpathprefernces, acquiredheadername));
					}
                if (!isElementPresent(PreferencesRepository.preferences_datacatalogue_leftselectnodataavailable)) 
                {
				String firstattributename = getStrText(PreferencesRepository.preferences_datacatalogue_leftselectattribute);
				clickElement(PreferencesRepository.preferences_datacatalogue_leftselectattribute);

				clickElement(PreferencesRepository.preferences_datacatalogue_rightarrowicon);
				clickElement(PreferencesRepository.preferences_datacatalogue_RytSearchIcon);

				enterValue(PreferencesRepository.preferences_datacatalogue_SearchInputField, firstattributename);
				String attributeNameText = getStrText(
						",xpath,//div[@class='k-list-content']//ul//li[.='" + firstattributename + "']");
				isDisplayed(attributeNameText);
				clickElement(PreferencesRepository.preferences_datacatalogue_Updatebutton);
				clickElement(PreferencesRepository.preferences_datacatalogue_popupProceedbutton);
                
				if (headername.contains("Classification")) {

					clickElement(PreferencesRepository.preferences_datacatalogue_classification);
				}
				pageLoaderLogo();
				// javaScriptScrollIntoViewExact("Maximize,xpath,//div//*//h4[.='" +
				// acquiredheadername + "']/../..//i[@class='icon-rs-expand-mini
				// expandIcon icon-xs']");
				clickElement("Maximize,xpath,//div//*//h4[.='" + acquiredheadername
						+ "']/../..//i[@class='icon-rs-expand-mini expandIcon icon-xs']");

				dataAttributeValidation(PreferencesRepository.preferences_datacatalogue_totalattribute
						.replace(PreferencesRepository.dynamicXpathprefernces, acquiredheadername), firstattributename);
				clickElement(PreferencesRepository.preferences_datacatalogue_minimizeButton);
				// javaScriptScrollIntoViewExact(",xpath,//h4[.='" + acquiredheadername +
				// "']/..//i[@id='rs_data_pencil_edit']");
				clickElement(PreferencesRepository.preferences_datacatalogue_editicon
						.replace(PreferencesRepository.dynamicXpathprefernces, acquiredheadername));

				clickElement("rightbox,xpath,//h4[@class='m0 py10'][contains(.,'Selected columns')]/..//li//span[.='"
						+ firstattributename + "']");
				clickElement(PreferencesRepository.preferences_datacatalogue_Leftrowicon);
				clickElement(PreferencesRepository.preferences_datacatalogue_LftSearchIcon);
				enterValue(PreferencesRepository.preferences_datacatalogue_SearchInputField, firstattributename);
				String attributeTextName = getStrText(
						",xpath,//div[@class='k-list-content']//ul//li[.='" + firstattributename + "']");
				isDisplayed(attributeTextName);
				clickElement(PreferencesRepository.preferences_datacatalogue_Updatebutton);
				clickElement(PreferencesRepository.preferences_datacatalogue_popupProceedbutton);
				pageLoaderLogo();
				if (headername.contains("Classification")) {
					clickElement(PreferencesRepository.preferences_datacatalogue_classification);
				}
				// javaScriptScrollIntoViewExact
				clickElement("Maximize icon,xpath,//div//*//h4[.='" + acquiredheadername
						+ "']/../..//i[@class='icon-rs-expand-mini expandIcon icon-xs']");

				dataAttributeValidation(PreferencesRepository.preferences_datacatalogue_totalattribute
						.replace(PreferencesRepository.dynamicXpathprefernces, acquiredheadername), firstattributename);
				clickElement(PreferencesRepository.preferences_DataCatalogue_MinimizeClick);
			}else {
				BaseTest.getTest().log(Status.WARNING, "In Left Table No data avilable is displayed");
				BaseTest.takeScreenshot();
				clickElement(CommunicationRepository.whatsapp_authoring_livepreviewclose);
				threadSleep(ObjectRepository.wait2sec);
			}
               
			}  else {
            	BaseTest.getTest().log(Status.WARNING, "Edit icon is disabled");
				BaseTest.takeScreenshot();
			}  
			} else

			{
				BaseTest.getTest().log(Status.INFO, "Edit icon not visible -----> " + acquiredheadername);
			}

			int scrollPosition = 450;
			if (i % 2 != 0) {
							JavascriptExecutor execute = (JavascriptExecutor) driver;
				execute.executeScript("window.scrollTo(0, " + scrollPosition + ")");
				scrollPosition += 450;
			}
		}
	}


	public List<Map<String, String>> DatacatalogueCsvdownload() throws IOException, InterruptedException
	{
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_Gridview);
		pageLoaderLogo();
		BaseTest.takeScreenshot();
		clickElement(PreferencesRepository.preferences_CsvFileClick);
		String popupHeader = getStrText(PreferencesRepository.preferences_CsvPopupHeader);
		if (popupHeader.equals("Download CSV")) {
			BaseTest.getTest().log(Status.PASS, "CSV header present as expected");
		} else {
			BaseTest.getTest().log(Status.FAIL, "CSV header Popup is not present as expected");
		}
		clickElement(PreferencesRepository.preferences_CsvOtp);
		selectlistelements(PreferencesRepository.preferences_CsvOtpList, "Email Id");
		BaseTest.takeScreenshot();
		String pwind = parentWinHandle();
		javaScriptopenNewWindow();
		switchWindow();
		String OTP = webURLlaunch().teamAccountKeyUserWebmailLogin().getWebmailOTPDataCatalogueDownload();
		webMailDelete();
		switchParentWin(pwind);
		otpfieldEnter(OTP);
		clickElement(PreferencesRepository.preferences_DataCatalogue_FooterClick);
		webURLlaunch();
		teamAccountKeyUserWebmailLogin();
		String link = clickWebmailDataAttributesDownloadLink();
		BaseTest.takeScreenshot();

		if (link != null) {
			openLoginPage();
			login(getPageFactory().loginPage().dPropertyLoginUserName(),
					getPageFactory().loginPage().dPropertyLoginPswrd());
			selectbusinessunit();
			BaseTest.getWebDriver().get(link);
			String headerText = getStrText(PreferencesRepository.preferences_dataattribute_headername);
			writeLog(headerText.equals("Datacatalogue - CSV download list"), "Subject line is present as expected.",
					headerText + " Subject line is not present as expected.");
			clickElement(PreferencesRepository.preferences_dataattribute_clicktodownloadattributes);
		}
		threadSleep(ObjectRepository.wait5sec);
		ArrayList<Object> filehandle = filehandle();
		System.out.println(filehandle.get(0));
		System.out.println(filehandle.get(1));
		List<Map<String, String>> excelDataValidate = excelDataValidate(filehandle.get(1));
		return excelDataValidate;
	}

	public List<Map<String, String>> excelDataValidate1(Object datas) {
		List<Map<String, String>> list = new LinkedList<>();
		String[] rows = datas.toString().split("\n");
		String[] headers = rows[0].split(",");
		for (int i = 1; i < rows.length; i++) {
			Map<String, String> map = new LinkedHashMap<>();
			String regex = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
			String[] data = rows[i].split(regex);
//			String[] data = rows[i].split(",");
			for (int j = 0; j < data.length; j++) {
				map.put(headers[j], data[j].replaceAll("\"", "").replaceAll("\r", ""));
			}
			list.add(i, map);
		}
		return list;
	}

	public List<Map<String, String>> excelDataValidate(Object datas) {
		List<Map<String, String>> list = new LinkedList<>();
		String[] rows = datas.toString().split("\n");
		String[] headers = rows[0].split(",");
		for (int i = 1; i < rows.length; i++) {
			Map<String, String> map = new LinkedHashMap<>();
			String regex = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
			String[] data = rows[i].split(regex);
			for (int j = 0; j < headers.length; j++) {
				if (j < data.length) {
					String value = data[j].replaceAll("\"", "").replaceAll("\r", "").trim();
					map.put(headers[j], value);
				} else {
					map.put(headers[j], "");
				}
			}
			list.add(map);
		}
		return list;
	}

	public List<Map<String, String>> datacatalogueGridData() {
		clickElement(PreferencesRepository.preferences_Gridview);
		List<Map<String, String>> UiData = getWebTableData(PreferencesRepository.preferences_dataCataWebtableHeader,
				PreferencesRepository.preferences_dataCataWebtableRows,
				PreferencesRepository.preferences_dataCataWebtablePagination);
		System.out.println(UiData);
		return UiData;
	}

//string - Data catalogue gridview validation only

	public PreferencesPage PageWebtableValidation(String channel) throws InterruptedException, IOException
	{
		clickElement(PreferencesRepository.preferences_Gridview);
		BaseTest.getTest().log(Status.INFO, "Channel  ---> " + channel + ", Count : ");

		// isDisplayedWar("Channel name,xpath,//h1[contains(.,'Data
		// catalogue')]",channel);
		List<Map<String, String>> UiData = getWebTableData(PreferencesRepository.preferences_dataCataWebtableHeader,
				PreferencesRepository.preferences_dataCataWebtableRows,
				PreferencesRepository.preferences_dataCataWebtablePagination);

		// System.out.println(UiData);
		clickElement(PreferencesRepository.preferences_dataCataWebtableBack);
		pageLoaderLogo();

		return this;

	}

	public void personaldetailsValidations() {
		String labelName = null;
		uiPageEqualswithInputValue(getStrText(PreferencesRepository.preferences_myprofile_PersonalDetailsheader),
				"Personal details");
		String[] profilePicHelpText = "Allowed formats: \n".concat(".jpg, .jpeg, .png, .svg \n")
				.concat("Max. file size: 500 KB" + " ").split("\\R");
		int index = 0;

		for (String helpText : getStrText(PreferencesRepository.preferences_myprofile_ProfilepictureHelptext)
				.split("\\R")) {
			String trim = profilePicHelpText[index].trim();
			uiPageEqualswithInputValue(profilePicHelpText[index].trim(), helpText);
			index++;
		}

		// profilePicUpload(BaseTest.curr_Dir +
		// "\\src\\main\\resources\\data\\uploadfiles\\XML_Upload.xml");
		// uiPageEqualswithMultipleInputValue(getStrText(PreferencesRepository.preferences_myprofile_ProfilepictureHelptext),
		// "Invalid file format");
		String helpText = getUiBackgroundColour("color",
				PreferencesRepository.preferences_myprofile_ProfilepictureHelptext);
		if (helpText.equalsIgnoreCase("#666666")) {
			BaseTest.getTest().info("Error message colour is validated successfully");
			BaseTest.takeScreenshot();
		} else {
			BaseTest.getTest().info("Error message colour is mismatched");
			BaseTest.takeScreenshot();
		}
		profilePictureUpload(BaseTest.curr_Dir + "\\src\\main\\resources\\data\\uploadfiles\\Testing image.jpg");
		isElementAvailable(PreferencesRepository.preferences_myprofile_dppicturepencilIcon);

		String Fileuploadname[] = "Testing image.jpg, PNG file upload.png, sample_640×426.jpeg, svg upload image.svg"
				.split(",");

		for (int i = 0; i < Fileuploadname.length; i++) {
			isElementAvailable(PreferencesRepository.preferences_myprofile_dppicturepencilIcon);
		}

		// toolTipValidationKnownText(PreferencesRepository.preferences_myprofile_pencilTooltip,
		// "Update profile picture");
		mouseHover(PreferencesRepository.preferences_myprofile_dppicturepencilIcon);
		uiPageEqualswithInputValue(getStrText(PreferencesRepository.preferences_myprofile_pencilTooltip),
				"Update profile picture");

		mouseHover(PreferencesRepository.preferences_myprofile_removeIcon);
		threadSleep(ObjectRepository.wait5sec);
		uiPageEqualswithInputValue(getStrText(PreferencesRepository.preferences_myprofile_removeTooltip),
				"Remove profile picture");
		// toolTipValidationKnownText(PreferencesRepository.preferences_myprofile_removeTooltip,
		// "Remove profile picture");

		clickElement(PreferencesRepository.preferences_myprofile_removeIcon);
		threadSleep(ObjectRepository.wait3sec);
		if (!isElementPresent(PreferencesRepository.preferences_myprofile_removeIcon)) {
			BaseTest.getTest().log(Status.PASS, "Profile picture is removed successfully");
			BaseTest.takeScreenshot();
		} else {
			BaseTest.getTest().log(Status.FAIL, "Profile picture is not removed");
			BaseTest.takeScreenshot();
		}
//		clickElement(PreferencesRepository.preferences_myprofile_dppicturepencilIcon);
		threadSleep(ObjectRepository.wait5sec);
		profilePictureUpload(BaseTest.curr_Dir + "\\src\\main\\resources\\data\\uploadfiles\\Testing image.jpg");
		isElementAvailable(PreferencesRepository.preferences_myprofile_dppicturepencilIcon);

		// title check

		List<WebElement> disabledfields = findElements(PreferencesRepository.preferences_myprofile_Alldisabledfield);
		for (int i = 0; i < disabledfields.size(); i++) {
			String status = disabledfields.get(i).getAttribute("class");
			if (status != null && status.contains("disabled")) {
				labelName = driver.findElement(
						By.xpath("(//input[@disabled] | //span[@class='k-floating-label-container k-text-disabled'])["
								+ (i + 1) + "]//span[@class='k-label k-text-disabled']"))
						.getText();
				BaseTest.getTest().log(Status.INFO, "<b>" + labelName + "</b> field is disabled as expected.");
				labelName = "";
			} else {
				try {
					labelName = disabledfields.get(i).getAttribute("name");
					if (labelName.isEmpty()) {
						labelName = getStrText(PreferencesRepository.preferences_myprofile_Mobilenofield);
					}
					BaseTest.getTest().log(Status.INFO, "<b>" + labelName + "</b> field disabled as expected.");
					labelName = "";
				} catch (Exception e) {
					BaseTest.getTest().log(Status.FAIL, labelName + " field is not disabled.");
				}
			}
		}
	}

	//// FrequencyCap

	public void clickfreqcapEdit(String domainName) {
		domainName = domainName.trim();
		String xpath = "Freqcap Edit icon click,xpath,//div[@class='rs-kendo-grid-table ']//tr//td[.='" + domainName
				+ "']/..//i[@id='rs_data_pencil_edit']";
		// explicitwaitforclick(autolocator(xpath), 90);
		clickElement(xpath);
	}

	public void clickfreqcapdelete(String domainName) {
		domainName = domainName.trim();
		String xpath = "Freqcap delete icon click,xpath,//div[@class='rs-kendo-grid-table ']//tr//td[.='" + domainName
				+ "']/..//i[@id='rs_data_delete']";

		// explicitwaitforclick(autolocator(xpath), 90);
		clickElement(xpath);
	}

	String Rulename = "Rule" + addTimeToName().replaceAll("_", "");


	public void frequencyValidation() throws InterruptedException
	{
		String Rulename = "Rule" + addTimeToName().replaceAll("_", "");
		String content = "The rule will be applicable only for bulk and promotional communication.";
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_commSettings_frequencycapsettings);
		pageLoaderLogo();
		explicitwaitforclick(autolocator(PreferencesRepository.preferences_commSettings_frequencycapaddicon), 10);
		clickElement(PreferencesRepository.preferences_commSettings_frequencycapaddicon);
		pageLoaderLogo();
		enterValue(PreferencesRepository.preferences_commSettings_frequencycaprulename, Rulename);
		clickElement(PreferencesRepository.preferences_commSettings_frequencycapaudiencegroup);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "All");
		threadSleep(ObjectRepository.wait3sec);
		pageLoaderLogo();
//		clickElement(PreferencesRepository.preferences_commSettings_frequencycap_audiencegrouptype);
//		List<WebElement> audienceList = findElements(DashboardRepository.allpage_common_selectdropdownlist);
//		audienceList.get(0).click();
		clickElement(PreferencesRepository.preferences_commSettings_frequencycap_selectType);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Communication Type");
		clickElement(PreferencesRepository.preferences_commSettings_frequencycap_commType);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Promotion");
		clickElement(PreferencesRepository.preferences_commSettings_frequencycap_priorityclick);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Low");
		clickElement(PreferencesRepository.preferences_commSettings_frequencycap_selectlimitClick);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "1");
		clickElement(PreferencesRepository.preferences_commSettings_frequencycap_selecttimeinterval);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Week");
		String freqRule = getStrText(PreferencesRepository.preferences_commSettings_frequencycap_freqRule);
		if (content.equals(freqRule)) {
			BaseTest.getTest().log(Status.INFO, "Rule content is equal as expected.");
			javaScriptScrollIntoView(PreferencesRepository.preferences_commSettings_frequencycap_freqratioButton);
			clickElement(PreferencesRepository.preferences_commSettings_frequencycap_freqratioButton);
		} else {
			BaseTest.getTest().log(Status.WARNING, "Rule content is not equal as expected.");
		}
		javaScriptScrollDown();
		clickElement(PreferencesRepository.preferences_commSettings_frequencycap_Savebuttonclick);
		pageLoaderLogo();
		clickfreqcapEdit(Rulename);
		pageLoaderLogo();
		BaseTest.takeScreenshot();
		javaScriptScrollDown();
		clickElement(PreferencesRepository.preferences_commSettings_frequencycap_editCancelButton);
	}

	public void accountSettingsclick() {
		explicitwaitforclick(autolocator(PreferencesRepository.preferences_accountsettings_click), 30);
		clickElement(PreferencesRepository.preferences_accountsettings_click);
		BaseTest.getTest().info(MarkupHelper.createLabel("ACCOUNT SETTINGS ", ExtentColor.BLUE));

	}

	public void profilepictureValidation() {

		uiPageEqualswithInputValue(getStrText(PreferencesRepository.preferences_accountsettings_MainheaderCheck),
				"Edit company account");
		String[] profilePicHelpText = "Allowed formats: \n".concat(".jpg, .jpeg, .png, .svg \n").concat(" Max. file size: 500 KB").split("\\R");
		int index = 0;

		for (String helpText : getStrText(PreferencesRepository.preferences_myprofile_ProfilepictureHelptext)
				.split("\\R")) {
			uiPageEqualswithInputValue(profilePicHelpText[index].trim(), helpText);
			index++;
		}
		pageLoaderLogo();
		String helpText = getUiBackgroundColour("Background", PreferencesRepository.preferences_myprofile_ProfilepictureHelptext);
		if (helpText.equalsIgnoreCase("#FFF3CD"))
		{
			BaseTest.getTest().log(Status.INFO, "Helptext colour is validated as per expected");
			BaseTest.takeScreenshot();
		} else {
			BaseTest.getTest().log(Status.FAIL, "Helptext colour is not as per expected");
			BaseTest.takeScreenshot();
		}
		isElementAvailable(PreferencesRepository.preferences_myprofile_dppicturepencilIcon);
		profilePictureUpload(BaseTest.curr_Dir + "\\src\\main\\resources\\data\\uploadfiles\\Testing image.jpg");
		mouseHover(PreferencesRepository.preferences_myprofile_dppicturepencilIcon);
		uiPageEqualswithInputValue(getStrText(DashboardRepository.allpage_tooltip), "Update company logo");

		mouseHover(PreferencesRepository.preferences_myprofile_removeIcon);
		pageLoaderLogo();
		uiPageEqualswithInputValue(getStrText(DashboardRepository.allpage_tooltip), "Remove company logo");
		pageLoaderLogo();
		if (isDisplayed(PreferencesRepository.preferences_myprofile_removeIcon)) {
			clickElement(PreferencesRepository.preferences_myprofile_removeIcon);
			BaseTest.getTest().log(Status.INFO, "Profile picture is removed successfully");
			BaseTest.takeScreenshot();
		} else {
			BaseTest.getTest().log(Status.FAIL, "Profile picture is not removed");
			BaseTest.takeScreenshot();
		}
		threadSleep(ObjectRepository.wait5sec);
		profilePictureUpload(BaseTest.curr_Dir + "\\src\\main\\resources\\data\\uploadfiles\\Testing image.jpg");

	}

	public void accountSettingsfield() {
		String[] fields = { "parentCompany", "companyName", "companyWebsite", "companyAddress", "companyCity",
				"companyZipcode" };
		BaseTest.takeScreenshot();
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait5sec);

		for (int i = 0; i < fields.length; i++)
		{
			if (isElementPresent(fields[i] + ",xpath,//div[contains(@class,'rs-input-wrapper-required rs-input-placeholder-wrapper')]//input[@name='" + fields[i] + "']"))
			{
				BaseTest.getTest().info(fields[i] + "field is set to mandatory as expected");
			} else {
				BaseTest.getTest().fail(fields[i] + " field is not set to mandatory");
				BaseTest.takeScreenshot();
			}

			String fieldValue = getTextBoxVal(fields[i] + ",xpath,//div[contains(@class,'rs-input-wrapper-required rs-input-placeholder-wrapper')]//input[@name='" + fields[i] + "']", "value");
			if (!fieldValue.isEmpty())
			{
				BaseTest.getTest().info(fields[i] + " field validated successfully and field contains value ");
			} else {
				BaseTest.getTest().fail(fields[i] + " field is empty");
				BaseTest.takeScreenshot();
			}

		}
		enterValue(PreferencesRepository.preferences_accountsettings_addressInput, System.getProperty("300char"));
		int inputLength = getTextBoxVal(PreferencesRepository.preferences_accountsettings_addressInput, "value")
				.length();
		if (inputLength == 255) {
			BaseTest.getTest().log(Status.INFO, "The input field allows 255 charcters as expected");

		} else {
			BaseTest.getTest().log(Status.FAIL, "The  input field does not allows 255 charcters as expected");
			clearField(PreferencesRepository.preferences_accountsettings_ComapnyInfo);
			enterValue(PreferencesRepository.preferences_accountsettings_addressInput, "PM.Towers, Greams road");
		}
		clearField(PreferencesRepository.preferences_accountsettings_addressInput);
		enterValue(PreferencesRepository.preferences_accountsettings_addressInput, "Testing");
	}


	public void accountSettingsdropdwn()
	{
		String buName = "QA" + addTimeToNameShrt();
		List<WebElement> allValues = findElements(PreferencesRepository.preferences_accountsettings_Allvalues);
		for (int i = 0; i < 6; i++)
		{
			if (allValues.get(i).getAttribute("class").toLowerCase().contains("disabled"))
			{
				BaseTest.getTest().log(Status.INFO, "The fields are in uneditable state as expected");
				BaseTest.takeScreenshot();
			} else {
				allValues.get(i).click();
				tabAction();
				BaseTest.getTest().log(Status.INFO, "The fields are in editable state as expected");
				BaseTest.takeScreenshot();
			}
		}
		isDisplayed(PreferencesRepository.preferences_accountsettings_BUheaderCheck);
		javaScriptScrollDown();
		BaseTest.takeScreenshot();
		clickElement(PreferencesRepository.preferences_accountsettings_BUAddIcon);
		javaScriptScrollDown();
		int size = findElements(PreferencesRepository.preferences_accountsettings_BUDeptSelect).size();
		enterValue(replacePlaceHolder(PreferencesRepository.preferences_accountsettings_BUDeptEnter, String.valueOf(size)), buName);
		tabAction();
		threadSleep(ObjectRepository.wait5sec);
		clickElement(PreferencesRepository.preferences_accountsettings_UpdateButton);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait10sec);

	}


	public void accountLocalizationSettings()
	{
		clickElement(PreferencesRepository.preferences_accountsettings_Newuser);
		clickElement(PreferencesRepository.preferences_accountsettings_RightArrow);
		clickElement(PreferencesRepository.preferences_accountsettings_UserdropdwnClick);
		selectlistelements(PreferencesRepository.preferences_accountsettings_Userdropdwn, "User");
		threadSleep(ObjectRepository.wait5sec);
		clickElement(PreferencesRepository.preferences_accountsettings_ProceedClick);
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_accountsettings_ProceedClick);
		pageLoaderLogo();
		BaseTest.takeScreenshot();
		String[] disabledlabels = { "Preferred regions", "Currency", "Language", "Communication types", "Engagement", "Conversion", "Offer types", "Custom branded smart link", "Custom communication link", "Communication reference", "Hour(s)",
				"Hour(s)", "Hour(s)", };
		List<WebElement> disableFields = findElements(PreferencesRepository.preferences_accountsettings_DisableField);
		for (int i = 0; i < disableFields.size(); i++)
		{
			String accDisableFields = disableFields.get(i).getText();
			if (accDisableFields.equals(disabledlabels[i])) {
				BaseTest.getTest().log(Status.INFO,
						"The " + disabledlabels[i] + "field are in uneditable state as expected");

			} else {
				BaseTest.getTest().log(Status.FAIL,
						"The " + disabledlabels[i] + "field are in editable state as expected");

			}
		}
		clickElement(PreferencesRepository.preferences_accountsettings_Datedrop);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "DD-MM-YYYY");
		clickElement(PreferencesRepository.preferences_accountsettings_Hours);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "24 hours");
		javaScriptScrollDown();
		clickElement(PreferencesRepository.preferences_accountsettings_Reachcount);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "By Target");
		clickElement(PreferencesRepository.preferences_accountsettings_Engagementcount);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "By Target");
		clickElement(PreferencesRepository.preferences_accountsettings_Conversioncount);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "By Reach");
		clickElement(PreferencesRepository.preferences_accountsettings_Localizationcount);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "1");
		clickElement(PreferencesRepository.preferences_usermanagement_newuserpagesavebutton);
		pageLoaderLogo();
	}

	public void addUser(String eMail, String jobFunction, String Title) {
		String firstName = "QATEST" + addTimeToName().replaceAll("_", "");
		String lastName = "Team";
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_accountsettings_AddbuttonClick);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait2sec);

		clickElement(PreferencesRepository.preferences_usermanagement_newuserpageTitle);
		selectlistelements(PreferencesRepository.preferences_usermanagement_newuserjoblist, Title);// Mr.
		enterValue(PreferencesRepository.preferences_usermanagement_newuserfirstname, firstName);
		enterValue(PreferencesRepository.preferences_usermanagement_newuserlastname, lastName);
		enterValue(PreferencesRepository.preferences_usermanagement_newusermobileno, "9884096287");
		enterValue(PreferencesRepository.preferences_usermanagement_newuseremail,
				eMail + addTimeToName() + "@resulticksmail.com");
		clickElement(PreferencesRepository.preferences_usermanagement_newuserjobfunction);
		threadSleep(ObjectRepository.wait3sec);
		selectlistelements(PreferencesRepository.preferences_usermanagement_newuserjoblist, jobFunction);

		enterValue(PreferencesRepository.preferences_accountsettings_Password, "Qateam@12345");
		tabAction();
		threadSleep(ObjectRepository.wait2sec);
		enterValue(PreferencesRepository.preferences_usermanagement_newuserwelocomemsg, "Welcome to the team");
		String passwordStrength = getTextBoxVal(PreferencesRepository.preferences_Users_passwordfieldStrength, "class");
		if (passwordStrength.contains("100")) {
			BaseTest.getTest().log(Status.INFO, "Password Field color is equal to Green");
			BaseTest.takeScreenshot();
		} else {
			BaseTest.getTest().log(Status.FAIL, "Password Field color is not-equal to Green");
			BaseTest.takeScreenshot();
		}
		clickElement(PreferencesRepository.preferences_existinguser_Generatepasswordbutton);
		String Newpassword = getStrText(PreferencesRepository.preferences_accountsettings_Generate);

		if (!Newpassword.isEmpty()) {
			clickElement(PreferencesRepository.preferences_existinguser_passwordpreview);
			String oldpassword = "Qateam@12345";
			if (Newpassword == oldpassword) {
				BaseTest.getTest().log(Status.FAIL, "Password should not be same as previous one");
			}
		}
		clickElement(PreferencesRepository.preferences_existinguser_enforceotp);
		threadSleep(ObjectRepository.wait2sec);
		clickElement(PreferencesRepository.preferences_existinguser_Generatepasswordbutton);
		enterValue(PreferencesRepository.preferences_accountsettings_Password, "Qateam@12345");
		tabAction();
		BaseTest.takeScreenshot();
		clickElement(PreferencesRepository.preferences_usermanagement_newuserpagesavebutton);
		clickElement(DashboardRepository.homepage_businessUnit_click);
		selectByValue(DashboardRepository.homepage_businessUnit_select, "RESUL Core Platform");
		pageLoaderLogo();
		pageLoaderLogo();
		String username = getStrText(PreferencesRepository.preferences_accountsettings_UserNameText);
		clickElement(PreferencesRepository.preferences_accountsettings_UserNameText);
		clickElement(PreferencesRepository.preferences_accountsettings_RightArrow);
		clickElement(PreferencesRepository.preferences_accountsettings_UserdropdwnClick);

		selectlistelements(PreferencesRepository.preferences_accountsettings_Userdropdwn, "User");
		threadSleep(ObjectRepository.wait5sec);
		clickElement(PreferencesRepository.preferences_accountsettings_ProceedClick);
		BaseTest.takeScreenshot();
		clickElement(PreferencesRepository.preferences_accountsettings_ProceedClick);
		pageLoaderLogo();
		BaseTest.takeScreenshot();
		javaScriptScrollDown();
		clickElement(PreferencesRepository.preferences_usermanagement_newuserpagesavebutton);
		pageLoaderLogo();
	}

//RESUL 5.0
	public PreferencesPage clickGoalsandBenchmark() {
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_commSettings_GoalsandBenchmark);
		return this;
	}

	public void createBenchmark() {
		String[] disableField = { "Country", "Industry", "Business type" };

		String[] Channelname = "Email,SMS,QR".split(",");
		String[] benchmarkvalues = "2,2.1,3.2".split(",");
		String benchmarkid = "Benchmark" + addTimeToName().replaceAll("_", "").trim();
		String communicationtype = "Promotion" + addTimeToNameShrt().replaceAll("_", "").trim();
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_Audiencescore_CommonAdd);

		clickElement(PreferencesRepository.preferences_commSettings_GoalsandBenchmark_commgoals);
		BaseTest.takeScreenshot();
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_goalbenchmark_backButton);

		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_goals_communicationtype);
		clickElement(PreferencesRepository.preferences_goals_communicationtypeAdd);
		enterValue(PreferencesRepository.preferences_goals_communicationtypeAddEnter, communicationtype);
		tabAction();
		clickElement(PreferencesRepository.preferences_goals_communicationtypeAddSave);
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_goals_communicationtype);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, communicationtype);

		enterValue(PreferencesRepository.preferences_goals_enterbenchmark, benchmarkid);

		List<WebElement> disbaleFieldslabelName = findElements(PreferencesRepository.preferences_goals_Disablefield);
		for (int i = 0; i < disbaleFieldslabelName.size(); i++) {
			String uiText = disbaleFieldslabelName.get(i).getText();
			writeLog(uiText.equals(disableField[i]), uiText + " field disabled as expected.",
					uiText + " field disabled as expected.");
		}
		enterValue(PreferencesRepository.preferences_goals_DescriptionEnter, "Automation test description");
		javaScriptScrollDown();
		for (int i = 0; i < Channelname.length; i++) {
			try {

				List<WebElement> benchmarktextboxfield = findElements(
						PreferencesRepository.preferences_goals_enterbenchmarkEstimatedALl);

				for (WebElement webElement : benchmarktextboxfield) {
					isElementPresent(",xpath,//span[.='" + Channelname[i] + "']//parent::li");
					threadSleep(ObjectRepository.wait2sec);
					webElement.clear();
					webElement.sendKeys(benchmarkvalues[i]);
				}
			} catch (Exception e) {
				List<WebElement> benchmarktextbox = findElements(
						PreferencesRepository.preferences_goals_enterbenchmarkEstimatedALl
								.replace(PreferencesRepository.dynamicXpathprefernces, Channelname[i]));
				for (WebElement webElement : benchmarktextbox) {
					webElement.clear();
					webElement.sendKeys(benchmarkvalues[i]);
				}
			}
			if (i == 2) {
				threadSleep(ObjectRepository.wait2sec);
				clickElement(PreferencesRepository.preferences_goals_savebtn);
			} else {
				clickElement(PreferencesRepository.preferences_goals_nextbtn);
			}
		}
		if (isDisplayed(PreferencesRepository.preferences_goals_benchmarktablename
				.replace(PreferencesRepository.dynamicXpathprefernces, benchmarkid))) {
			String benchmarktablename = getStrText(PreferencesRepository.preferences_goals_benchmarktablename
					.replace(PreferencesRepository.dynamicXpathprefernces, benchmarkid));
			compareUiwithInputvalue(benchmarkid, benchmarktablename);
		}
		clickElement(PreferencesRepository.preferences_goals_benchmarktableEdit
				.replace(PreferencesRepository.dynamicXpathprefernces, benchmarkid));
		pageLoaderLogo();
	}

	public void emailfooterwebtableEdit(String domainName) {
		domainName = passvalue.trim();
		String xpath = "emailfooter edit icon click,xpath,//div[@class='rs-kendo-grid-table ']//tr//td[.='" + domainName
				+ "']/..//i[@id='rs_data_pencil_edit']";
		// explicitwaitforclick(autolocator(xpath), 90);
		clickElement(xpath);
	}

	String passvalue = "Test" + addTimeToValue();

	public PreferencesPage emailFooter() {
		pageLoaderLogo();
		String content = "Resulticks offers real-time audience engagement solutions enabling brands to deliver connected experiences through digital transformation, with a focus on driving top-line growth. ";

		String imageUrl = "https://infotechlead.com/wp-content/uploads/2022/07/benefits-of-test-automation.png";
		String instagramUrl = "https://www.instagram.com/";
		String twitterUrl = "https://x.com/";
		String facebookUrl = "https://www.facebook.com/";
		String youTubeUrl = "https://resulticks.com";
		clickElement(PreferencesRepository.preferences_commSettings_emailFooterClick);
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_commSettings_emailFooterAddClick);
		threadSleep(ObjectRepository.wait5sec);
		clickElement(PreferencesRepository.preferences_commSettings_emailFootercolorBucket);
		javaScriptScrollDownToSomeExtend();
		clearField(PreferencesRepository.preferences_commSettings_emailFootercolorHexInput);
		enterValue(PreferencesRepository.preferences_commSettings_emailFootercolorHexInput, "D1BD22");
		clickElement(PreferencesRepository.preferences_commSettings_emailFootercolorHexApply);
		driver.findElement(By.id("contentRigntID")).click();
		driver.findElement(By.id("contentRigntID")).clear(); // reusable methods are not working in UI
		driver.findElement(By.id("contentRigntID")).click();
		driver.findElement(By.id("contentRigntID")).sendKeys(content);
		clickElement(PreferencesRepository.preferences_commSettings_emailFooterImageClick);
		clickElement(PreferencesRepository.preferences_commSettings_emailFooterImageUrl);
		BaseTest.takeScreenshot();
		enterValue(PreferencesRepository.preferences_commSettings_emailFooterImage, imageUrl);
		clickElement(PreferencesRepository.preferences_commSettings_emailFooterInsert);
		javaScriptScrollDown();
		clickElement(PreferencesRepository.preferences_commSettings_emailFooterInstagram);
		enterValue(PreferencesRepository.preferences_commSettings_emailFooterInstagramUrl, instagramUrl);
		enterValue(PreferencesRepository.preferences_commSettings_emailFooterTwitterUrl, twitterUrl);
		enterValue(PreferencesRepository.preferences_commSettings_emailFooteFacebookUrl, facebookUrl);
		enterValue(PreferencesRepository.preferences_commSettings_emailFooterYoutubeUrl, youTubeUrl);

		clickElement(PreferencesRepository.preferences_commSettings_emailFooterUrlSaveButton);
		// enterValue(PreferencesRepository.preferences_commSettings_emailFootercontent1,
		// content);
		// driver.findElement(By.id("contentCard3contentText")).click();
		// driver.findElement(By.id("contentCard3contentText")).clear();
		// driver.findElement(By.id("contentCard3contentText")).click();
		// driver.findElement(By.id("contentCard3contentText")).sendKeys(content);
		// enterValue(PreferencesRepository.preferences_commSettings_emailFootercontent2,
		// content);
		javaScriptScrollDown();
		clickElement(PreferencesRepository.preferences_commSettings_emailFooterPreviewButton);
		BaseTest.takeScreenshot();
		clickElement(PreferencesRepository.preferences_commSettings_emailFooterPreviewclose);

		clickElement(PreferencesRepository.preferences_commSettings_emailFooterSaveButton);
		if (isDisplayed(PreferencesRepository.preferences_commSettings_emailFooterPopupHeader)) {
			BaseTest.getTest().log(Status.INFO, "Header is present as expected");
			enterValue(PreferencesRepository.preferences_commSettings_emailFooterPopupValue, passvalue);
			tabAction();
			threadSleep(ObjectRepository.wait5sec);
			clickElement(PreferencesRepository.preferences_commSettings_emailFooterPopupSave);
		} else {
			BaseTest.getTest().log(Status.FAIL, "Header is not present as expected");
		}
		pageLoaderLogo();
		emailfooterwebtableEdit(passvalue);
		javaScriptScrollDown();
		clickElement(PreferencesRepository.preferences_commSettings_emailFooterUpdateButton);
		clickElement(PreferencesRepository.preferences_commSettings_emailFooterPopupSave);
		pageLoaderLogo();
		BaseTest.takeScreenshot();

		return this;
	}

	public void clickUnSubEdit(String domainName) {
		String xpath = "Unsub Edit icon click,xpath,//div[@class='rs-kendo-grid-table ']//tr//td[.='" + domainName
				+ "']/..//i[@id='rs_data_pencil_edit']";
		explicitwaitforclick(autolocator(xpath), 90);
		clickElement(xpath);
	}

	public void commSettingsUnsub(String entervalue) throws InterruptedException {
		String content = " Hi this is automation script testing content";
		String imageUrl = "https://infotechlead.com/wp-content/uploads/2022/07/benefits-of-test-automation.png";
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_commSettings_UnsubSubmoduleClick);
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_commSettings_UnsubSelect);
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_commSettings_UnsubAddIcon);
		pageLoaderLogo();
		sendValue(PreferencesRepository.preferences_commSettings_UnsubTitle, "Auto" + addTimeToName());
		profilePictureUpload(BaseTest.curr_Dir + "\\src\\main\\resources\\data\\uploadfiles\\Testing image.jpg");
		javaScriptScrollDown();
		Thread.sleep(ObjectRepository.wait2sec);
		clickElement(PreferencesRepository.preferences_commSettings_UnsubCommtype);

		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Promotion");

		clickElement(PreferencesRepository.preferences_commSettings_UnsubProducttype);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Loans");

		clickElement(PreferencesRepository.preferences_commSettings_UnsubChanneltype);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Email");
		clickElement(PreferencesRepository.preferences_commSettings_UnsubTermsCondition);
		clickElement(PreferencesRepository.preferences_commSettings_UnsubAdvancedsttngstoggle);
		if (isDisplayed(PreferencesRepository.preferences_commSettings_UnsubFarewellMail)) {
			BaseTest.getTest().log(Status.INFO, "Farewell mail is present as expected");
			clickElement(PreferencesRepository.preferences_commSettings_UnsubFarewellMailClick);
			sendValue(PreferencesRepository.preferences_commSettings_UnsubFarewellSubjectline, entervalue);
		}
		WebElement frameValue = findElement(PreferencesRepository.preferences_commSettings_UnsubIframe);
		driver.switchTo().frame(frameValue);
		WebElement element = findElement(PreferencesRepository.preferences_commSettings_UnsubIframeEnter);
		element.click();
		element.sendKeys(content);
		Actions action = new Actions(driver);
		action.click(element).doubleClick(element).build().perform();
		driver.switchTo().defaultContent();
		clickElement(PreferencesRepository.preferences_commSettings_UnsubFarewellBold);
		clickElement(PreferencesRepository.preferences_commSettings_UnsubFarewellItalic);
		clickElement(PreferencesRepository.preferences_commSettings_UnsubFarewellUnderline);
		clickElement(PreferencesRepository.preferences_commSettings_UnsubFarewellStrikethrough);
		clickElement(PreferencesRepository.preferences_commSettings_UnsubFarewellSave);
		javaScriptScrollDown();
		WebElement frameContent = findElement(PreferencesRepository.preferences_commSettings_UnsubIframeEntervalue);
		driver.switchTo().frame(frameContent);
		WebElement path = findElement(PreferencesRepository.preferences_commSettings_UnsubIframeEnter);
		path.click();
		path.clear();
		path.sendKeys(content);
		Actions actions = new Actions(driver);
		action.click(path).doubleClick(path).build().perform();
		driver.switchTo().defaultContent();
		clickElement(PreferencesRepository.preferences_commSettings_UnsubSuccesfulMessageBold);
		clickElement(PreferencesRepository.preferences_commSettings_UnsubSuccesfulMessageItalic);
		clickElement(PreferencesRepository.preferences_commSettings_UnsubSuccesfulMessageUnderline);
		clickElement(PreferencesRepository.preferences_commSettings_UnsubSuccesfulMessageStrikethrough);
		clickElement(PreferencesRepository.preferences_commSettings_UnsubImageURl);
		clickElement(PreferencesRepository.preferences_commSettings_UnsubImageURlSelect);
		if (isDisplayed(PreferencesRepository.preferences_commSettings_UnsubImageURlHeader)) {
			BaseTest.getTest().log(Status.INFO, "Image popup header is present as expected");
			enterValue(PreferencesRepository.preferences_commSettings_UnsubImageUrlText, "testQA");
			enterValue(PreferencesRepository.preferences_commSettings_UnsubImageURlEnter, imageUrl);
			clickElement(PreferencesRepository.preferences_commSettings_UnsubImageSave);
		} else {
			BaseTest.getTest().log(Status.WARNING, "Image popup header is not present as expected");
		}
		// clickElement(content);
		enterValue(PreferencesRepository.preferences_commSettings_UnsubRedirectionalUrl, "https://resulticks.com");
		clickElement(PreferencesRepository.preferences_commSettings_UnsubSave);
		BaseTest.takeScreenshot();
		if (isDisplayed(PreferencesRepository.preferences_commSettings_UnsubPopupHeader)) {
			BaseTest.getTest().log(Status.INFO, "Popup header is present as expected");
			enterValue(PreferencesRepository.preferences_commSettings_UnsubPopupinput, entervalue);
			tabAction();
			threadSleep(ObjectRepository.wait5sec);
			clickElement(PreferencesRepository.preferences_commSettings_UnsubPopupSave);
			pageLoaderLogo();

		} else {
			BaseTest.getTest().log(Status.FAIL, "Popup header is not present as expected");

		}
		clickUnSubEdit(entervalue);
		pageLoaderLogo();
		javaScriptScrollDown();
		clickElement(PreferencesRepository.preferences_commSettings_UnsubSave);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(PreferencesRepository.preferences_commSettings_UnsubPopupSave);
		pageLoaderLogo();
		BaseTest.takeScreenshot();
	}

	public void TemplateThreedotDropdwn(String domainName) {
		String xpath = "template three dot dropdown select,xpath,//div[@class='gallery-list']//a[.=" + domainName + "]";
		explicitwaitforclick(autolocator(xpath), 90);
		clickElement(xpath);
	}

	public void clickTemplateThreedot(String domainName) {
		String xpath = "template three dot click,xpath,//div[@class='rsg-campaign-name mt-4']//p[.=" + domainName
				+ "]//..//..//i[@class='icon-rs-menu-dot-medium color-primary-blue icon-md']";
		explicitwaitforclick(autolocator(xpath), 90);
		clickElement(xpath);
	}

	public void landingBuilder(String entervalue) {
		clickElement(PreferencesRepository.preferences_templateBuilderClick);
		BaseTest.takeScreenshot();
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_LandingPageClick);
		pageLoaderLogo();
		toolTipValidationKnownText(PreferencesRepository.preferences_LandingPageaddicon, "Create new template");
		clickElement(PreferencesRepository.preferences_LandingPageaddicon);
		if (isDisplayed(PreferencesRepository.preferences_LandingPageaddicon)) {
			BaseTest.getTest().log(Status.INFO, "Popup header is present as expected");
			enterValue(PreferencesRepository.preferences_LandingPagePopupName, entervalue);
			tabAction();
			threadSleep(ObjectRepository.wait5sec);
			explicitwaitforclick(autolocator(PreferencesRepository.preferences_LandingPagePopupSave), 20);
			clickElement(PreferencesRepository.preferences_LandingPagePopupSave);
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Popup header is not present as expected");
		}
		clickElement(PreferencesRepository.preferences_LandingPagePopupFullscreenCancel);

		draganddrop(driver, PreferencesRepository.preferences_LandingPagetext,
				PreferencesRepository.preferences_LandingPageMainFrame);
		WebElement element = null;
		driver.switchTo().frame(0);
		element = findElement(PreferencesRepository.preferences_commSettings_UnsubIframeBody);
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
		element.clear();

		enterValue(PreferencesRepository.preferences_LandingPageFrameText, "TestAuto" + addTimeToValue());
		driver.switchTo().defaultContent();
		WebElement imgClick = null;
		draganddrop(driver, PreferencesRepository.preferences_LandingPageImg,
				PreferencesRepository.preferences_LandingPageMainFrame);
		driver.switchTo().frame(0);
		imgClick = findElement(PreferencesRepository.preferences_commSettings_UnsubIframeImage);
		Actions actions = new Actions(driver);
		actions.doubleClick(imgClick).build().perform();
		driver.switchTo().defaultContent();
		BaseTest.takeScreenshot();
		threadSleep(ObjectRepository.wait5sec);
		String testimageurl = "https://cdn.pixabay.com/photo/2023/03/04/20/07/coffee-7830087_1280.jpg";
		enterValue(PreferencesRepository.preferences_LandingPageFrameImgValue, testimageurl);
		clickElement(PreferencesRepository.preferences_LandingPageAddimage);
		threadSleep(ObjectRepository.wait5sec);
		clickElement(PreferencesRepository.preferences_LandingPageAddimageClose);
		clickElement(PreferencesRepository.preferences_LandingPagePublishClick);
		mouseHover(PreferencesRepository.preferences_LandingPageSavebutton);
		clickElement(PreferencesRepository.preferences_LandingPageSavebuttonClick);
		pageLoaderLogo();
		clickTemplateThreedot(entervalue);
		TemplateThreedotDropdwn("Edit");
		clickElement(PreferencesRepository.preferences_LandingPagePopupFullscreenCancel);
		BaseTest.takeScreenshot();
		clickElement(PreferencesRepository.preferences_LandingPageCancelbutton);
		clickElement(PreferencesRepository.preferences_LandingPageCancelYesbutton);
		pageLoaderLogo();
		BaseTest.takeScreenshot();
	}

	public void templateBuilderClick() {
		pageLoaderLogo();
		explicitwaitforclick(autolocator(PreferencesRepository.preferences_templateBuilderClick), 30);
		clickElement(PreferencesRepository.preferences_templateBuilderClick);
		pageLoaderLogo();
		// toolTipValidationKnownText(PreferencesRepository.preferences_templateBuilderClick,
		// "Set and manage template");
		BaseTest.takeScreenshot();
		clickElement(",xpath,//i[@class='icon-rs-form-generator-xlarge icon-xl']");
	}

	// playwright methods
	public void pw_formsDragAndDrop(String carouselName) {
		Locator dragElement = page.locator(pw_autolocator(
				replacePlaceHolder(PreferencesRepository.pw_preferences_Forms_carouselBoxSelect, carouselName)));
		BoundingBox sourceBox = dragElement.boundingBox();
		page.mouse().move(sourceBox.x + sourceBox.width / 2, sourceBox.y + sourceBox.height / 2);
		page.mouse().down();
		page.waitForTimeout(2000); // Pause for 2 seconds
		page.mouse().move(88.5 + 1182.0 / 2, 482.390625 + 28.0 / 2, new Mouse.MoveOptions().setSteps(10));
		page.waitForTimeout(4000); // Pause for 4 seconds
		page.mouse().up();
	}

	public void pw_preferenceModuleClick() {
		BaseTest.getTest().info(MarkupHelper.createLabel("PREFERENCES - DATA CATALOGUE ", ExtentColor.BROWN));
		threadSleep(ObjectRepository.wait10sec);
		pw_clickElement(PreferencesRepository.pw_preferences_preferencesModuleclick);
		threadSleep(ObjectRepository.wait10sec);
	}

	public void pw_templateBuilderClickAction() {
		pw_clickElement(PreferencesRepository.pw_preferences_templateBuilderClick);
		pw_pageLoaderLogo();
	}

	public String pw_templateBuilderClick() {
		String templeteName = "Auto_TempleteBuilder" + addTimeToName();
		pw_clickElement(PreferencesRepository.pw_preferences_templateBuilderClick);

		// toolTipValidationKnownText(PreferencesRepository.preferences_templateBuilderClick,
		// "Set and manage template");
		// BaseTest.takeScreenshot();

		pw_pageLoaderLogo();
//		toolTipValidationKnownText(PreferencesRepository.preferences_templateBuilderClick, "Set and manage template");
		pw_clickElement(PreferencesRepository.preferences_Email_templateBuilderLandingPage);
		pw_pageLoaderLogo();
		pw_clickElement(PreferencesRepository.preferences_Email_templateBuilderAddicon);
		pw_pageLoaderLogo();
		pw_enterValue(PreferencesRepository.preferences_Email_templateBuilderName, templeteName);
		pw_clickTab();
		pw_pageLoaderLogo();
		pw_clickElement(PreferencesRepository.preferences_Email_templateBuildercategory);
		pw_pageLoaderLogo();
		pw_selectExactlistelements(PreferencesRepository.preferences_Email_templateBuildercategorylist,
				"Product / Services");
		pw_clickElement(PreferencesRepository.preferences_Email_templateBuilderSaveButton);
		pw_pageLoaderLogo();
		threadSleep(ObjectRepository.wait1sec);
		pw_pageLoaderLogo();
		BaseTest.pw_takesScreenshot();
		return templeteName;
	}

	public void pw_formsclick(String formSelect) {
		pw_clickElement(PreferencesRepository.pw_preferences_FormsClick);
		// BaseTest.takeScreenshot();
		pw_clickElement(PreferencesRepository.pw_preferences_AddFormAdd);
		pw_selectlistelements(PreferencesRepository.pw_preferences_AddFormelect, formSelect);
	}


	public void addFormBuilder()
	{
		pw_clickElement(PreferencesRepository.pw_preferences_TellaFriend);
		// pw_selectlistelements(PreferencesRepository.pw_preferences_AddFormelect, "Tell a friend");
		// pw_isDisplayed(PreferencesRepository.pw_preferences_EmailMobile, "Email/Mobile");
		BaseTest.getTest().log(Status.INFO, "Email/Mobile header is present as expected");
		pw_clickElement(PreferencesRepository.pw_preferences_Salutation);
		pw_clickElement(PreferencesRepository.pw_preferences_Fullname);
		pw_clickElement(PreferencesRepository.pw_preferences_Mobile);
		page.locator("input[name=\"participant\\.FullName\"]").click();
		page.locator("input[name=\"participant\\.FullName\"]").fill("Automation");
		// BaseTest.takeScreenshot();
	}

	public void surveyForm() {
		pw_clickElement(PreferencesRepository.pw_preferences_SelectFormsRefresh);
		pw_clickElement(PreferencesRepository.pw_preferences_SelectFormsRefreshOK);
		pw_clickElement(PreferencesRepository.pw_preferences_Survey);
		pw_pageLoaderLogo();
		pw_formsDragAndDrop("Text");
		pw_clickElement(PreferencesRepository.pw_preferences_CarosuelRightarrow);
		pw_clickElement(PreferencesRepository.pw_preferences_Carosuelleftarrow);
//	page.getByLabel("-- Select --").locator("span").nth(1).click();
//	pw_clickByIndex(PreferencesRepository.pw_preferences_CommonFieldSelect, 2);
		pw_clickElement(PreferencesRepository.pw_preferences_CommonAgreeCheckbox);
		page.evaluate("window.scrollBy(0,-1000)");
	}

	public void pw_createAttribute(String attributeName, String parentSelection) {
		// explicitwaitforvisibility(autolocator(AudienceRepository.audience_seg_newattributeheader),
		// 30);
		pw_enterValue(AudienceRepository.pw_audience_seg_attributeNameField, attributeName);
		pw_enterValue(AudienceRepository.pw_audience_seg_description, "The automation testing is the software testing");
		pw_clickTab();
		String dataType = pw_getStrText(AudienceRepository.pw_audience_seg_datatype);
		if (BaseTest.getData().AttributeMapping.toLowerCase().contains("parent")) {
			pw_writeLog(dataType.equals("Regular Data"),
					"Segmentation data type <b>'" + dataType + "'</b> is present as expected <b>'Regular Data'</b>.",
					"Segmentation data type <b>'" + dataType + "'</b> is present as expected <b>'Regular Data'</b>.");
		} else if (BaseTest.getData().AttributeMapping.toLowerCase().contains("child")) {
			pw_writeLog(dataType.equals("Transaction Data"),
					"Segmentation data type <b>'" + dataType
							+ "'</b> is present as expected <b>'Transaction Data'</b>.",
					"Segmentation data type <b>'" + dataType
							+ "'</b> is present as expected <b>'Transaction Data'</b>.");
		}
		pw_clickElement(AudienceRepository.pw_audience_seg_datatype);
		// uiPageEqualswithMultipleInputValue(AudienceRepository.audience_seg_dropdownValue,
		// "KPI Data,Regular Data,Transaction Data");
		pw_selectlistelements(DashboardRepository.pw_allpage_common_selectdropdownlist, parentSelection);
		pw_clickElement(AudienceRepository.pw_audience_seg_inputtype);
		// pw_CompareMultipleListElementsValues(AudienceRepository.pw_audience_seg_inputtype,
		// "Text,Integer,Decimal,Date");
		pw_selectlistelements(DashboardRepository.pw_allpage_common_selectdropdownlist, "Text");
		pw_clickElement(AudienceRepository.pw_audience_seg_filtergroup);
		;
		// pw_CompareMultipleListElementsValues(AudienceRepository.pw_audience_seg_filtergroup,
		// "Brand,Communication,Customer,Fingerprint,Others,propensity");
		pw_selectlistelements(DashboardRepository.pw_allpage_common_selectdropdownlist, "Brand");
		;
		pw_clickElement(AudienceRepository.pw_audience_seg_classification);
		// pw_CompareMultipleListElementsValues(AudienceRepository.pw_audience_seg_classification,
		// "Audience overview,Profile
		// completeness,Personalisation,Content target,Sensitive data,Advanced
		// analytics,Offline conversion,Audience base,Offers,GDPR");
		pw_selectlistelements(DashboardRepository.pw_allpage_common_selectdropdownlist,
				BaseTest.getData().Classification);
		if (BaseTest.getData().Classification.contains("Personalisation")) {
			pw_enterValue(AudienceRepository.pw_audience_seg_fallbackName, attributeName + "FL");
		}
		// BaseTest.takeScreenshot();
		pw_clickElement(AudienceRepository.pw_audience_seg_newAttributeSave);
		pw_pageLoaderLogo();
	}

	public void subscriptionForm() {
		String attributeName = "Autotest" + addTimeToName();
		pw_clickElement(PreferencesRepository.pw_preferences_SelectFormsRefresh);
		pw_clickElement(PreferencesRepository.pw_preferences_SelectFormsRefreshOK);
		pw_clickElement(PreferencesRepository.pw_preferences_Subscription);
		pw_pageLoaderLogo();
		pw_formsDragAndDrop("Text");
		pw_clickElement(PreferencesRepository.pw_preferences_progressiveProfile);
		pw_clickElement(PreferencesRepository.pw_preferences_progressiveProfileToggle);
		pw_enterValue(PreferencesRepository.pw_preferences_progressiveProfileValue, "5");

		pw_clickElement(PreferencesRepository.pw_preferences_Save);
		pw_clickElement(PreferencesRepository.pw_preferences_Formtext);
		pw_clickElement(PreferencesRepository.pw_preferences_FormClose);
		pw_pageLoaderLogo();
		pw_createAttribute(attributeName, "Regular Data");
		pw_clickElement(PreferencesRepository.pw_preferences_Formtext);
		pw_enterValue(PreferencesRepository.pw_preferences_FormTextEnter, attributeName);
		pw_selectlistelements(DashboardRepository.pw_allpage_common_selectdropdownlist, attributeName);
		page.getByText("Mobile", new Page.GetByTextOptions().setExact(true)).click();
		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^MobilePhone number$")))
				.getByRole(AriaRole.TEXTBOX).first().fill("Mobile");
		/*
		 * pw_clickElement(",pw,(//i[@class='icon-rs-settings-medium icon-md icon-md color-primary-blue'])[3]"
		 * ); // mobilesettingIcon
		 * page.locator("//input[@name='formGenerator[2].settings.placeholder']").click(
		 * );
		 * page.locator("//input[@name='formGenerator[2].settings.placeholder']").clear(
		 * );
		 * pw_enterValue(",pw,//input[@name='formGenerator[2].settings.placeholder']",
		 * "phone number"); pw_clickElement(",pw,//button[.='OK']");
		 */
		pw_clickElement(PreferencesRepository.pw_preferences_Formselect);
		pw_selectlistelements(DashboardRepository.pw_allpage_common_selectdropdownlist, "Gender");
		pw_clickElement(PreferencesRepository.pw_preferences_Formselect2);
		pw_selectlistelements(DashboardRepository.pw_allpage_common_selectdropdownlist, "City");
	}

	public void FieldValidation() {
		String[] values = { "India", "Russia", "Newzealand", "China" };

		page.getByTitle("Text color").click();
		page.getByLabel("hex").click();
		page.getByLabel("hex").fill("E7C1EA");
		pw_clickElement(PreferencesRepository.pw_preferences_HexColorApply);
		// page.evaluate("window.scrollBy(0,-1000)");
		pw_clickElement(PreferencesRepository.pw_preferences_SurveySubMobileno);
		pw_enterValue(PreferencesRepository.pw_preferences_SurveySubMobileno, "1234567890");
		page.getByLabel("Map to").nth(3).click();
		pw_clickByIndex(PreferencesRepository.pw_preferences_CommonFieldSelect, 2);
		page.getByLabel("-- Select --").locator("span").nth(1).click();
		pw_clickByIndex(PreferencesRepository.pw_preferences_CommonFieldSelect, 2);
		pw_clickElement(PreferencesRepository.pw_preferences_CommonAgreeCheckbox);
		pw_clickByIndex(PreferencesRepository.pw_preferences_CommonFieldSelect, 2);
		if (isDisplayed(PreferencesRepository.pw_preferences_Forms_SettingsIcon3)) {
			BaseTest.getTest().log(Status.INFO, "Settings is present as expected");
			pw_clickElement(PreferencesRepository.pw_preferences_Forms_SettingsIcon3);
			pw_clickElement(PreferencesRepository.pw_preferences_Forms_OK);
			pw_clickElement(PreferencesRepository.pw_preferences_Forms_MandatoryField);
			pw_clickElement(PreferencesRepository.pw_preferences_Forms_SettingsIcon5);
			BaseTest.takeScreenshot();
		}

		Locator removeIcon = page.locator("//i[@class='icon-rs-circle-minus-fill-mini color-primary-red']");
		for (int i = 0; i < removeIcon.count(); i++) {
//				ele = page.locator("//i[@class='icon-rs-circle-minus-fill-mini color-primary-red']");
			removeIcon.nth(i).click();
		}

		for (int i = 0; i < values.length; i++) {
			pw_enterValue(PreferencesRepository.pw_preferences_Forms_Valueenter, values[i]);
			pw_clickEnter();
		}
		pw_clickElement(PreferencesRepository.pw_preferences_Forms_OK);
		pw_clickElement(PreferencesRepository.pw_preferences_Forms_saveGenerate);
	}

	public void formsWebtableCheckDownload(String formName) {
		String pwPath = "Forms webtable download click,pw,//span[contains(.,'" + formName
				+ "')]//..//..//td//li//i[@id='rs_FormGenerator_CSV']";
		pw_clickElement(pwPath);
	}

	public void formsWebtableEdit(String formName) {
		String pwPath = "Forms webtable edit click,pw,//span[contains(.,'" + formName
				+ "')]//..//..//td//li//i[@id='rs_data_pencil_edit']";
		pw_clickElement(pwPath);
	}

	public void formsWebtableDuplicate(String formName) {
		String pwPath = "Forms webtable duplicate click,pw,//span[contains(.,'" + formName
				+ "')]//..//..//td//li//i[@id='rs_FormGenerator_Duplicate']";
		pw_clickElement(pwPath);
	}

	public void FieldValidation(String Formname) 
	{
    String[] values = { "India", "Russia", "Newzealand", "China" };
	pw_clickElement(PreferencesRepository.pw_preferences_FormTextcountry);
	page.getByLabel("hex").click();
	page.getByLabel("hex").fill("E7C1EA");
	pw_clickElement(PreferencesRepository.pw_preferences_HexColorApply);
	pw_clickElement(PreferencesRepository.pw_preferences_GenderField);
	pw_selectlistelements(DashboardRepository.pw_allpage_common_selectdropdownlist, "Age");
	page.getByLabel("-- Select --").locator("span").nth(1).click();
	pw_selectlistelements(DashboardRepository.pw_allpage_common_selectdropdownlist, "India");
	pw_clickElement(PreferencesRepository.pw_preferences_CityField);
	pw_selectlistelements(DashboardRepository.pw_allpage_common_selectdropdownlist, "City");
	pw_clickElement(PreferencesRepository.pw_preferences_CommonAgreeCheckbox);
	/*
	 * if (pw_isDisplayed(PreferencesRepository.pw_preferences_Forms_SettingsMobile, "Mobile")) BaseTest.getTest().log(Status.INFO,
	 * "Settings is present as expected");
	 */
	pw_clickElement(PreferencesRepository.pw_preferences_Forms_SettingsIcon3);
	pw_clickElement(PreferencesRepository.pw_preferences_Forms_OK);
	pw_clickElement(PreferencesRepository.pw_preferences_Forms_MandatoryField);
	pw_clickElement(PreferencesRepository.pw_preferences_Forms_SettingsIcon5);
	// BaseTest.takeScreenshot();
	Locator removeIcon = pw_findelements(PreferencesRepository.pw_preferences_Forms_RemoveIcon);
	for (int i = 0; i < removeIcon.count(); i++)
	{
		removeIcon.nth(i).click();
	}

	for (int i = 0; i < values.length; i++)
	{
		pw_enterValue(PreferencesRepository.pw_preferences_Forms_Valueenter, values[i]);
		pw_clickEnter();
	}
	pw_clickElement(PreferencesRepository.pw_preferences_Forms_OK);
	pw_clickElement(PreferencesRepository.pw_preferences_Forms_saveGenerate);
	pw_enterValue(PreferencesRepository.pw_preferences_Forms_formName, Formname);
	pw_clickTab();
	// threadSleep(ObjectRepository.wait5sec);
	pw_pageLoaderLogo();
	pw_clickElement(PreferencesRepository.pw_preferences_progressiveProfileSave); // Form name Save
	// BaseTest.pw_takesScreenshot();
	pw_clickElement(PreferencesRepository.pw_preferences_saveCloseButton);
	pw_pageLoaderLogo();}

	public void formCSVdownload(String Formname) {
		pageLoaderLogo();
		// formsWebtableCheckDownload(Formname);
		clickElement(PreferencesRepository.preferences_FormCsvClick);
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_FormCsvOk);
		isDisplayed(PreferencesRepository.preferences_FormCsvDownload);
		clickElement(PreferencesRepository.preferences_FormCsvMailDrpdwn);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "Email Id");
		String pwind = parentWinHandle();
		javaScriptopenNewWindow();
		switchWindow();
		String OTP = webURLlaunch().accountUserWebmailLogin().getWebmailOTPforFormDownload(Formname);
		webMailDelete();
		switchParentWin(pwind);
		childWindowClose(pwind);
		otpfieldEnter(OTP);
		threadSleep(ObjectRepository.wait5sec);
		// clickElement(",xpath,//button[.='Ok']");
		String secTab = parentWinHandle();
		javaScriptopenNewWindow();
		switchWindow();
		String OTP1 = webURLlaunch().keyUserWebmailLogin().getWebmailFormsDownloadLink(Formname);
	}

	public void formEditiconCheck(String Formname) {
		formsWebtableEdit(Formname);
		pw_pageLoaderLogo();
		pw_clickElement(PreferencesRepository.pw_preferences_Forms_saveGenerate);
		pw_clickElement(PreferencesRepository.pw_preferences_progressiveProfileSave); // Form name Save
		// BaseTest.pw_takesScreenshot();
		pw_clickElement(PreferencesRepository.pw_preferences_saveCloseButton);
		pw_pageLoaderLogo();
	}

	public void formDuplicate(String Formname) {
		String duplicateValue = "Duplicate" + addTimeToName();

		formsWebtableDuplicate(Formname);

//		if (pw_isDisplayed(",pw,//h2[.='Duplicate form']", "Duplicate form"))
//		{
//			BaseTest.getTest().log(Status.INFO, "Duplicate form header is present as expected");
//		}
		PW_PageBase duplicateName = pw_enterValue(PreferencesRepository.pw_preferences_Forms_DuplicateName,
				duplicateValue);
		pw_clickTab();
		pw_clickElement(PreferencesRepository.pw_preferences_progressiveProfileSave);
		pw_pageLoaderLogo();
		String table1Text = pw_getStrText(PreferencesRepository.pw_preferences_Forms_formDuplicate);

		if (duplicateValue.equals(table1Text))
		{
			BaseTest.getTest().log(Status.INFO, "Duplicate form name and table name present as expected");
		} else {
			BaseTest.getTest().log(Status.FAIL, "Duplicate form name and table name is not present as expected");
		}
	}

	public void pw_offerManagement() {
		// explicitwaitforclick(autolocator(PreferencesRepository.pw_preferences_Offer_Click),
		// 30);
		// toolTipValidationKnownText(PreferencesRepository.pw_preferences_Offer_Tooltip,
		// "Create static and dynamic offers");
		pw_clickElement(PreferencesRepository.pw_preferences_Offer_Click);
		// BaseTest.takeScreenshot();
	}

	public void consumptionsClick() {
		pageLoaderLogo();
		explicitwaitforclick(autolocator(PreferencesRepository.preferences_Consumptions_click), 30);
		// toolTipValidationKnownText(DashboardRepository.allpage_tooltip, "View
		// bandwidth and consumption at channel level");
		clickElement(PreferencesRepository.preferences_Consumptions_click);
		pageLoaderLogo();
		BaseTest.takeScreenshot();
	}

	public void pw_enterDate(int val, String date) {
		if (date.equals("startdate")) {
			pw_clickElement(PreferencesRepository.pw_preferences_Offer_StartDate);
		} else {
			pw_clickElement(PreferencesRepository.pw_preferences_Offer_EndDate);
		}
//			explicitwaitforclick(autolocator(PreferencesRepository.pw_Preferences_calendaryear_click), 30);
//			threadSleep(ObjectRepository.wait1sec);
//			javaScriptScrollUpToSomeExtend();
		pw_clickElement(PreferencesRepository.pw_Preferences_calendaryear_click);
		pw_customRangeCalender(val, PreferencesRepository.pw_preferences_calenderyearslist,
				PreferencesRepository.pw_preferences_calenderstartdatetable);
	}

	public void offerCodetype(String offerCode) {
		pw_clickElement(replacePlaceHolder(PreferencesRepository.pw_preferences_OffercodeType, offerCode));

	}

	public void addIcon() {
		pw_clickElement(PreferencesRepository.pw_preferences_Offer_Add);
	}

	public void offerClickWebtableEdit(String domainName) {
		String pwPath = "Goal icon click,pw,//span[contains(.,'" + domainName
				+ "')]//..//..//td//li//i[@id='rs_data_pencil_edit']";
		pw_clickElement(pwPath);
	}

	public void offerClickWebtableDuplicate(String domainName) {
		String pwPath = "Goal icon click,pw,//span[contains(.,'" + domainName
				+ "')]//..//..//td//li//i[@id='rs_OfferManagement_duplicate']";
		pw_clickElement(pwPath);
	}

	public void addOfferValidationCommon(int sdate, int edate, String offerName) {
//		if (pw_isDisplayed(PreferencesRepository.pw_preferences_Offer_Header, "Add offer"))
//		{
//			BaseTest.getTest().log(Status.INFO, "Add offer header is present as expected");
//		}
		pw_enterValue(PreferencesRepository.pw_preferences_Offer_Name, offerName);
		pw_clickElement(PreferencesRepository.pw_preferences_Offer_Type);
		pw_selectlistelements(DashboardRepository.pw_allpage_common_selectdropdownlist, "EMI");
		pw_enterDate(sdate, "startdate");
		pw_enterDate(edate, "enddate");
		pw_clickElement(PreferencesRepository.pw_preferences_CommType);
		pw_selectlistelements(DashboardRepository.pw_allpage_common_selectdropdownlist, "Awareness");
		pw_clickElement(PreferencesRepository.pw_preferences_ProductType);
		pw_selectlistelements(DashboardRepository.pw_allpage_common_selectdropdownlist, "Loans");
		// pw_clickElement(PreferencesRepository.pw_preferences_RefreshClick);
		page.evaluate("window.scrollBy(0,400)");
		pw_enterValue(PreferencesRepository.pw_preferences_Comm_Offercode, "3");
		pw_clickElement(PreferencesRepository.pw_preferences_OffercodeSave);
		offerClickWebtableEdit(offerName);
		pw_clickElement(PreferencesRepository.pw_preferences_Offer_Type);
		pw_selectlistelements(DashboardRepository.pw_allpage_common_selectdropdownlist, "Cashback");
		pw_clickElement(PreferencesRepository.pw_preferences_OffercodeSave);
	}

	public void scrollToPosition(WebDriver driver, int position) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, " + position + ")");
	}

	public void addOfferUniqueGneratenewOffer(int sdate, int edate, String offerName) {
		String composeContent = "Resulticks offers real-time audience engagement solutions enabling brands to deliver connected experiences through digital transformation, with a focus on driving top-line growth";
		pw_enterValue(PreferencesRepository.pw_preferences_Offer_Name, offerName);
		pw_clickElement(PreferencesRepository.pw_preferences_Offer_Type);
		pw_selectlistelements(DashboardRepository.pw_allpage_common_selectdropdownlist, "EMI");
		pw_enterDate(sdate, "startdate");
		pw_enterDate(edate, "enddate");
		pw_clickElement(PreferencesRepository.pw_preferences_CommType);
		pw_selectlistelements(DashboardRepository.pw_allpage_common_selectdropdownlist, "Awareness");
		pw_clickElement(PreferencesRepository.pw_preferences_ProductType);
		pw_selectlistelements(DashboardRepository.pw_allpage_common_selectdropdownlist, "Loans");
		pw_clickElement(PreferencesRepository.pw_preferences_RefreshClick);
		pw_clickElement(PreferencesRepository.pw_preferences_InputClick);
		String offerCountNo = "50";
		pw_enterValue(PreferencesRepository.pw_preferences_Volumevalue, offerCountNo);
		pw_clickElement(PreferencesRepository.pw_preferences_Unique_Offercode);
		pw_selectlistelements(DashboardRepository.pw_allpage_common_selectdropdownlist, "Generate new offer");
		pw_enterValue(PreferencesRepository.pw_preferences_OffercodeLength, "5");

		Locator checkBox = pw_findelements(PreferencesRepository.pw_preferences_OfferCheckBox);
		for (int i = 0; i < checkBox.count(); i++) {
			checkBox.nth(i).click();
		}
		pw_clickElement(PreferencesRepository.pw_preferences_OffercodeRadioTextbtn);
		String element = pw_getStrText(PreferencesRepository.pw_preferences_OfferBox);
		// pw_isElementPresent(textContent);
		pw_clickElement(PreferencesRepository.pw_preferences_OffercodeGenerateCSV);
		pw_clickElement(PreferencesRepository.pw_preferences_OffercodeDownloadCSV);
		String excelOfferCount = filehandle().get(0).toString();
		threadSleep(ObjectRepository.wait2sec);
		if (excelOfferCount.equals(offerCountNo)) {
			BaseTest.getTest().log(Status.INFO, "The given volume count and generated csv volume are same as expected");
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "The given volume count and generated csv volume are not same as expected");
		}
		pw_clickElement(PreferencesRepository.pw_preferences_OffercodeSave);

	}

	public void addOfferUniqueCsv(int sdate, int edate, String offerCode) {
//		if (pw_isDisplayed(PreferencesRepository.pw_preferences_Offer_Header, "Add offer"))
//		{
//			BaseTest.getTest().log(Status.INFO, "Add offer header is present as expected");
//		}
		pw_enterValue(PreferencesRepository.pw_preferences_Offer_Name, offerCode);
		pw_clickElement(PreferencesRepository.pw_preferences_Offer_Type);
		pw_selectlistelements(DashboardRepository.pw_allpage_common_selectdropdownlist, "EMI");
		pw_enterDate(sdate, "startdate");
		pw_enterDate(edate, "enddate");
		pw_clickElement(PreferencesRepository.pw_preferences_CommType);
		pw_selectlistelements(DashboardRepository.pw_allpage_common_selectdropdownlist, "Awareness");
		pw_clickElement(PreferencesRepository.pw_preferences_ProductType);
		pw_selectlistelements(DashboardRepository.pw_allpage_common_selectdropdownlist, "Loans");
		pw_clickElement(PreferencesRepository.pw_preferences_RefreshClick);
		page.locator("//input[@value='Unique']").click();
		String offerCountNo = "50";
		pw_enterValue(PreferencesRepository.pw_preferences_Volumevalue, offerCountNo);
		pw_clickElement(PreferencesRepository.pw_preferences_Unique_Offercode);
		pw_selectlistelements(DashboardRepository.pw_allpage_common_selectdropdownlist, "CSV");
		pw_enterValue(PreferencesRepository.pw_preferences_Offercodeimprtdesc, "AutomationTest1318");
		pw_uploadFile(PreferencesRepository.pw_preferences_OffercodeChooseFile,
				BaseTest.curr_Dir + "\\src\\main\\resources\\data\\uploadfiles\\OfferCode_TestData_50coupon.csv");
		pw_clickElement(PreferencesRepository.pw_preferences_OffercodeSave);
		offerClickWebtableDuplicate(offerCode);
	}

	public String getCurrentYear(String formatType) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(formatType);
		String format = formatter.format(date);
		return format;
	}

	public String getCurrentMonth(String formatType) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(formatType);
		String format = formatter.format(date);
		return format;
	}

	public PreferencesPage consumptionSmsreportdownload() {
		if (isDisplayed(PreferencesRepository.preferences_Consumptions_Sms_CommCsvDownload)) {
			explicitwaitforvisibility(autolocator(PreferencesRepository.preferences_Consumptions_Sms_CommCsvDownload),
					20);
			clickElement(PreferencesRepository.preferences_Consumptions_Sms_CommCsvDownload);
		} else {
			BaseTest.getTest().log(Status.FAIL, "Download option not available or page not loaded");
		}
		threadSleep(ObjectRepository.wait3sec);
		return this;
	}

	public PreferencesPage PreferencePageClickfromMenu() {
		BaseTest.getTest().info(MarkupHelper.createLabel("PREFERENCES MODULE ", ExtentColor.INDIGO));
		clickElement(PreferencesRepository.preferences_preferencesModuleclick);
		return getPageFactory().preferencesPage();
	}

	public int consumptionSmsCheck(String channelname) {
		int count = 0;
		String[] split = channelname.split(",");
		for (String testData : split) {
			isDisplayed(PreferencesRepository.preferences_consumption_conReport);
			explicitwaitforclick(autolocator(PreferencesRepository.preferences_ConsumptionsYear), 60);
			String currentYear = getCurrentYear("YYYY");
			String currentMonth = getCurrentMonth("MMMMMMMMM");
			clickElement(PreferencesRepository.preferences_ConsumptionsYear);
			threadSleep(ObjectRepository.wait1sec);
			BaseTest.takeScreenshot();
			selectlistelements(
					"Select Year " + currentYear + ",xpath,//div[@class='dropdown-menu show dropdown-menu-end']//a",
					currentYear);
			// explicitwaitforclick(autolocator(PreferencesRepository.preferences_ConsumptionsMonthSelectlist),
			// 20);
			clickElement(PreferencesRepository.preferences_ConsumptionsMonth);
			threadSleep(ObjectRepository.wait1sec);
			BaseTest.takeScreenshot();
			selectlistelements(PreferencesRepository.preferences_ConsumptionsMonthSelectlist, currentMonth);
			WebElement channelHeader = driver
					.findElement(By.xpath("//div[contains(@class,'position-relative')]//h4[.='" + testData + "']"));
			javaScriptScrollDown();
//			int elementVerticalScrollPosition = channelHeader.getLocation().getY() - 100;
//			System.out.println(elementVerticalScrollPosition);
//			scrollToPosition(driver, elementVerticalScrollPosition);
			threadSleep(ObjectRepository.wait10sec);
			String channelcount = driver.findElement(autolocator(
					"Count,xpath,//div[contains(@class,'position-relative')]//h4[.='" + testData + "']//../..//h2"))
					.getText().trim().replaceAll("[^0-9]", "");
			count = Integer.parseInt(channelcount);
			if (count > 0) {
				BaseTest.takeScreenshot();
				driver.findElement(autolocator("i icon button,xpath,//div[contains(@class,'position-relative')]//h4[.='"
						+ testData + "']//..//..//i[@id='rs_data_circle_info']")).click();
				pageLoaderLogo();
				threadSleep(ObjectRepository.wait3sec);
				String channelName = BaseTest.getData().TargetListOld;
				List<WebElement> commNameList = findElements(
						"communication all name,xpath,//div[@class='k-grid-content k-virtual-content']//td//span//span");
				if (!commNameList.isEmpty()
						&& isDisplayed(PreferencesRepository.preferences_Consumptions_Sms_CommHeadername)) {

					consumptionSmsreportdownload();
				}
			} else {
				BaseTest.getTest().log(Status.WARNING,
						"Consumption channel " + testData + " count is zero for selected month");
			}
			if (split.length > 1) {
				PreferencePageClickfromMenu();
			}
		}
		return count;
	}

	public void consumptionAnalyticsSmsVerify(String channel) {
		pageLoaderLogo();
		javaScriptScrollDown();
		driver.findElement(autolocator("i icon button,xpath,//div[contains(@class,'position-relative')]//h4[.='"
				+ channel + "']//..//..//i[@id='rs_data_circle_info']")).click();
		pageLoaderLogo();
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("document.querySelector('.k-grid-content.k-virtual-content').scrollLeft=1800");
		if (isDisplayed(PreferencesRepository.preferences_Consumptions_Sms_CommDeliveryCount)) {
			
			BaseTest.getTest().log(Status.INFO, "Delivered count is present as expected");
		} else {
			BaseTest.getTest().log(Status.FAIL, "Delivered count is not present as expected");
		}
		String deliveryCount = getStrText(PreferencesRepository.preferences_Consumptions_Sms_CommDeliveryCounts);
		String deliveryCountTxt = getStrText(PreferencesRepository.preferences_Consumptions_Sms_CommDeliveryCountText);
		JavascriptExecutor execute1 = (JavascriptExecutor) driver;
		execute.executeScript("document.querySelector('.k-grid-content.k-virtual-content').scrollLeft=0");
		isDisplayed(PreferencesRepository.preferences_Consumptions_Sms_CommHeadername);
		clickElement(PreferencesRepository.preferences_Consumptions_Sms_CommCountText);
		pageLoaderLogo();
		javaScriptScrollDownToSomeExtend();
        if (deliveryCount.equals("0")) {
        	deliveryCount="N/A";
		}

		String analyticsDeliveryCount = getStrText(PreferencesRepository.preferences_Analytics_Sms_Deliverycount);
		if (deliveryCount.equals(analyticsDeliveryCount)) {
			BaseTest.getTest().log(Status.INFO, "Table count " + deliveryCountTxt + " and the detailed analytics count "
					+ analyticsDeliveryCount + " both are same as expected.");
		} else {
			BaseTest.getTest().log(Status.WARNING, "Table count and analytics count both are not same as expected");
		}

	}

	public void dataExchangeClick() {
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_Dataexchange);
	}

	public void dataExchangewebhookValidation() {
		if (isDisplayed(PreferencesRepository.preferences_Dataexchange_Header)) {
			String webhookName = "TestWebhook -" + addTimeToName().replaceAll("_", "");
			pageLoaderLogo();
			javaScriptScrollDownToSomeExtend600();
			threadSleep(ObjectRepository.wait5sec);
			clickElement(PreferencesRepository.preferences_Dataexchange_ExtendedSystem);
			threadSleep(ObjectRepository.wait5sec);
			clickElement(PreferencesRepository.preferences_Dataexchange_ExtendedSystem_WebhookAdd);
			clearField(PreferencesRepository.preferences_Dataexchange_Webhook_Url);
			String visibleicon = getTextBoxVal(PreferencesRepository.preferences_Dataexchange_Webhook_SecretKey,
					"type");

			if (visibleicon.contains("password")) {
				BaseTest.getTest().log(Status.INFO, "Secretkey is Invisible in the UI as expected");
			} else {
				BaseTest.getTest().log(Status.WARNING, "Secretkey is visible in the UI as unexpected");
			}
			clickElement(PreferencesRepository.preferences_Dataexchange_Webhook_SecretKey_Eye);
			String visibleicon1 = getTextBoxVal(PreferencesRepository.preferences_Dataexchange_Webhook_SecretKey,
					"type");
			if (visibleicon1.contains("text")) {
				BaseTest.getTest().log(Status.INFO, "Secretkey is visible in the UI as expected");
			} else {
				BaseTest.getTest().log(Status.WARNING, "Secretkey is Invisible in the UI as unexpected");
			}
			clickElement(PreferencesRepository.preferences_Dataexchange_Webhook_SaveButton);
			// VALIDATION
			String nameErrMsg = getStrText(PreferencesRepository.preferences_Dataexchange_Webhook_NameValidation);
			if (nameErrMsg.equals("Enter instance/friendly name")) {
				BaseTest.getTest().log(Status.INFO, "URL error field  message is present as expected");
				BaseTest.takeScreenshot();
			} else {
				BaseTest.getTest().log(Status.WARNING, "URL field error message is not displayed");
				BaseTest.takeScreenshot();
			}
			String urlErrMsg = getStrText(PreferencesRepository.preferences_Dataexchange_Webhook_UrlValidation);
			if (urlErrMsg.equals("Enter URL")) {
				BaseTest.getTest().log(Status.INFO, "SECRET KEY error field  message is present as expected");
			} else {
				BaseTest.getTest().log(Status.WARNING, "SECRET KEY error field error message is not displayed");
			}
			enterValue(PreferencesRepository.preferences_Dataexchange_Webhook_NameValue, webhookName);
			if (isDisplayedWar(PreferencesRepository.preferences_Dataexchange_Webhook_NameValue)) {

				BaseTest.getTest().log(Status.INFO, "Webhook Name Error Message is not-present as per requirement");
			} else {
				BaseTest.getTest().log(Status.WARNING,
						"Webhook Name Error Message is present incorrect as per requirement");
			}
			enterValue(PreferencesRepository.preferences_Dataexchange_Webhook_UrlEnter,
					"https://conversion.resulticks.net/");
			tabAction();
			if (isDisplayedWar(PreferencesRepository.preferences_Dataexchange_Webhook_UrlEnter)) {

				BaseTest.getTest().log(Status.INFO, "Webhook Url Error Message is not present as per requirement");
			} else {
				BaseTest.getTest().log(Status.WARNING, "Webhook Url Error Message is present as unexpected");
			}
			enterValue(PreferencesRepository.preferences_Dataexchange_Webhook_SecretKey, "123456");
			if (isDisplayedWar(PreferencesRepository.preferences_Dataexchange_Webhook_SecretKey)) {

				BaseTest.getTest().log(Status.INFO, "Webhook Url Error Message is not present as per requirement");
			} else {
				BaseTest.getTest().log(Status.WARNING, "Webhook Url Error Message is present as unexpected");
			}
			enterValue(PreferencesRepository.preferences_Dataexchange_Webhook_Description, "Welcome to resulticks");
			clickElement(PreferencesRepository.preferences_Dataexchange_Webhook_SaveButton);
			pageLoaderLogo();
			if (isDisplayed(PreferencesRepository.preferences_dataexchangepagevalidation)) {
				// int size =
				// findElements(PreferencesRepository.preferences_extendedsystemstotalApi).size();
				// javaScriptScrollDown();
				clickElement(PreferencesRepository.preferences_Dataexchange_Webhook_Edit);
				if (isDisplayedWar(PreferencesRepository.preferences_extendedsystemsvalidation)) {

					String webhookHeader = getStrText(PreferencesRepository.preferences_extendedsystemsvalidation);
					if (webhookHeader.equals("Extended channel - Webhook")) {
						BaseTest.getTest().log(Status.INFO, "Webhook header name is present as per requirement");
					} else {

						BaseTest.getTest().log(Status.WARNING, "Webhook header name is different.");
					}
					clickElement(PreferencesRepository.preferences_webhooksaveicon);
					isDisplayed(PreferencesRepository.preferences_dataexchangepagevalidation);
				}
			}
		}
	}

	public void DragAndDropPushBuilder(String input) {
		Locator dragElements = page
				.locator(pw_autolocator(PreferencesRepository.preferences_Email_templateBuilderDragElements));
		Locator dropElements = page
				.locator(pw_autolocator(PreferencesRepository.preferences_Email_templateBuilderDropElements));
		for (int i = 0; i < dragElements.count(); i++) {
			String dragText = dragElements.nth(i).textContent();
			if (dragText.equals(input)) {
				dragElements.nth(i).dragTo(dropElements);
				break;
			}
		}
	}

	public void contentTarget(String locator, String[] attribute, String[] value) {
		Locator ele = page.locator(locator);
		ele.waitFor();
		ele.hover();
		pw_clickElement("Content target,pw,button[title='Content Target']");
		if (attribute.length == value.length) {
			for (int i = 0; i < value.length; i++) {
				pw_selectlistelements("Attributes,pw,//h4[text()='Attributes']//parent::div//button", attribute[i]);
				pw_enterValue("Attribute Text,pw,//h4[text()='" + attribute[i] + "']//parent::div//parent::div//input",
						value[i]);
			}
		} else {
			BaseTest.getTest().log(Status.WARNING, "Content target attributes " + attribute.toString()
					+ "and values count is mismatch" + value.toString());
		}
	}

	public void builderTextProperties() {
//		builderContentTargeting("text");
		pw_enterValue(PreferencesRepository.preferences_Email_templateBuildertextContent, "Automation Builder");
		pw_clickElement(PreferencesRepository.preferences_Email_templateBuildertextContentBold);
		pw_clickElement(PreferencesRepository.preferences_Email_templateBuildertextContentItalic);
		pw_clickElement(PreferencesRepository.preferences_Email_templateBuildertextContentunderline);
		pw_clickElement(PreferencesRepository.preferences_Email_templateBuildertextContentAlignCenter);
		page.locator(PreferencesRepository.preferences_Email_templateBuildertextContentsize).nth(0).selectOption("36");
		page.locator(PreferencesRepository.preferences_Email_templateBuildertextContentStyle).nth(0)
				.selectOption("Times new roman");
	}

	public void builderImageProperties() {
		pw_enterValue(PreferencesRepository.preferences_Email_templateBuilderImagewidth, "214");
		pw_scrollIfNeeded(PreferencesRepository.preferences_Email_templateBuilderImageUrl);
		pw_clickElement(PreferencesRepository.preferences_Email_templateBuilderImageUrl);
		pw_enterValue(PreferencesRepository.preferences_Email_templateBuilderImageUrl,
				System.getProperty("webMobilePushImageUrl"));
		pw_clickElement(PreferencesRepository.preferences_Email_templateBuilderImageUrlAdd);
		threadSleep(500);
		pw_enterValue(PreferencesRepository.preferences_Email_templateBuilderImageTextContent,
				"A good tester is not the one who finds the most bugs, but the one who prevents them.");
//		pw_scrollIfNeeded(PreferencesRepository.preferences_Email_templateBuilderImageBackgroundcolor);
//		pw_clickElement(PreferencesRepository.preferences_Email_templateBuilderImageBackgroundcolor);
//		pw_enterValue(PreferencesRepository.preferences_Email_templateBuilderImageBackgroundcolor, "#345357");
	}

	public void builderVideoProperties() {
		pw_clickElement(PreferencesRepository.preferences_Email_templateBuilderVideoUrl);
		pw_enterValue(PreferencesRepository.preferences_Email_templateBuilderVideoUrl,
				"https://www.youtube.com/watch?v=Hin8-nEFIuI");
	}

	public void builderButtonProperties() {
		pw_clickElement(PreferencesRepository.preferences_Email_templateBuilderButtonurltoggle);
		pw_enterValue(PreferencesRepository.preferences_Email_templateBuilderButtonImageurl,
				System.getProperty("webMobilePushImageUrl"));
		pw_clickElement(PreferencesRepository.preferences_Email_templateBuilderButtonImageAddIcon);
		/*
		 * while (true) { String widthSize = pw_getTextBoxVal(PreferencesRepository.
		 * preferences_Email_templateBuilderButtonWidth, "class"); if
		 * (widthSize.equals("600")) { break; } pw_scrollIfNeeded(PreferencesRepository.
		 * preferences_Email_templateBuilderButtonWidthPlusIcon);
		 * pw_clickElement(PreferencesRepository.
		 * preferences_Email_templateBuilderButtonWidthPlusIcon); }
		 */
		pw_clickElement(PreferencesRepository.preferences_Email_templateBuilderButtonActionTab);
		Locator selectElement = pw_findelements(PreferencesRepository.preferences_Email_templateBuilderButtonActionType)
				.nth(0);
		selectElement.selectOption(new SelectOption().setLabel("Site"));
		pw_enterValue(PreferencesRepository.preferences_Email_templateBuilderButtonUrl, "https://www.resulticks.com/");
	}

	public void builderContentTargeting(String fields) {
		switch (fields.toLowerCase()) {
		case "text" -> {
			pw_clickElement("Text content,pw,//div[contains(@class,'text-content')]");
			pw_mouseHover("Text content,pw,//div[contains(@class,'text-content')]");
			pw_clickElement("Content target,pw,button[title='Content target']");
		}
		case "image" -> {
			pw_clickElement("Image,pw,//div[contains(@class,'sivasiva')]");
		}
		case "button" -> {
			pw_clickElement("Button,pw,//button[@contenteditable='true']//parent::div");
		}
		case "offer" -> {
			pw_clickElement("Offercode,pw,//span[text()='OFFERCODE']//ancestor::div[@class='w-full']");
		}
		case "table" -> {
			pw_clickElement("Table,pw,//table//parent::div[@class='w-full']");
		}
		case "attach" -> {
			pw_clickElement("Attach,pw,//div[text()='No file attached']//ancestor::div[@class='w-full']");
		}
		case "rss feed" -> {
			pw_clickElement("RSS feed,pw,//p[text()='No RSS feed content']//ancestor::div[@class='w-full']");
		}
		case "video" -> {
			pw_clickElement("Video,pw,//p[text()='No video selected']//parent::div//parent::div[@class='w-full']");
		}
		case "social" -> {
			pw_clickElement("Social,pw,//a//parent::div//parent::div[@class='w-full']");
		}
		default -> {
			BaseTest.getTest().log(Status.WARNING, "Provide the valid input.");
		}
		}
	}

	public void SaveTemplete() {
		pw_clickElement(PreferencesRepository.preferences_Email_templateBuilderSaveTemplete);
		pw_pageLoaderLogo();
	}

	public void searchTemplete(String templeteName) {
		String newTempleteName = "";
		pw_pageLoaderLogo();
		threadSleep(ObjectRepository.wait1sec);
		pw_pageLoaderLogo();
		pw_clickElement(PreferencesRepository.preferences_Email_templateBuildersearchicon);
		pw_enterValue(PreferencesRepository.preferences_Email_templateBuilderentersearchvalue, templeteName);
		pw_clickElement(PreferencesRepository.preferences_Email_templateBuildersearchicon);
		if (templeteName.length() > 26) {
			newTempleteName = templeteName.substring(0, 25) + "...";
		}
		String uiTempleteName = pw_getStrText(PreferencesRepository.preferences_Email_templateBuilderTempleteName);
		if (uiTempleteName.equals(newTempleteName)) {
			BaseTest.getTest().log(Status.INFO, templeteName + " is present as expected.");
		} else {
			BaseTest.getTest().log(Status.FAIL, templeteName + " is not present as expected.");
		}
		BaseTest.pw_takesScreenshot();
	}

	public List<Map<String, String>> consumptionReportEmailDownload(String channel) {
		List<Map<String, String>> csvFileOutPut = new ArrayList<>();
		pageLoaderLogo();
		if (isEnabled(PreferencesRepository.preferences_Consumptions_Email_csvDownload)) {
			explicitwaitforvisibility(autolocator(PreferencesRepository.preferences_Consumptions_Email_csvDownload),
					20);
			javaScriptScrollUpToSomeExtend();
			clickElement(PreferencesRepository.preferences_Consumptions_Email_csvDownload);
			String[] filehandle = consumptionFilehandle().get(1).toString().split("\n");
			for (int i = 1; i < filehandle.length; i++) {
				Map<String, String> map = new TreeMap<>();
				String[] headers = filehandle[0].split("\\:");
				String[] values = filehandle[i].split("\\:");
				for (int j = 0; j < headers.length; j++) {
					if (!headers[j].contains("S.No") && !headers[j].contains("CommunicationID")) {

						try {
							map.put(headers[j].replaceAll("\r", ""),
									values[j].replaceAll("\"", "").replaceAll("\r", ""));
						} catch (Exception e) {
							map.put(headers[j], "");
						}
					}
				}
				csvFileOutPut.add(map);
			}
		} else {
			BaseTest.getTest().log(Status.FAIL, "Download option not available or page not loaded");
		}
		threadSleep(ObjectRepository.wait3sec);
		return csvFileOutPut;
	}

	public PreferencesPage validateConsumptionListAndCsvData(String channel) {
		Map<String, String> consumption = new LinkedHashMap<>();
		int sent = consumptionReport.get(channel);
		if (sent > 0) {
			BaseTest.getTest().log(Status.INFO, "Channel  ---> " + channel + ", Count : " + sent);
			clickElement(channel + " Channel Icon,xpath,//div[contains(@class,'position-relative')]//h4[.='" + channel
					+ "']//..//..//i[@id='rs_data_circle_info']");
			pageLoaderLogo();
			// uiPageEqualswithInputValue(channel, getStrText("Channel
			// name,xpath,//h3[text()='Email']")); // emailHeader
			//selectCustomRange(-1, 0);
			List<Map<String, String>> UiData = conGetWebTableData(
					PreferencesRepository.preferences_consumption_Email_gridHeader,
					PreferencesRepository.preferences_consumption_Email_gridRows,
					PreferencesRepository.preferences_listing_pagination);
			List<Map<String, String>> CSV_Output = consumptionReportEmailDownload(channel);
			UiData.sort(Comparator.comparing(m -> m.get("Communication name"), Comparator.reverseOrder()));
			CSV_Output.sort(Comparator.comparing(m -> m.get("Communication name"), Comparator.reverseOrder()));
			Workbook wb = new XSSFWorkbook();
			if (!UiData.isEmpty() && !CSV_Output.isEmpty()) {
				int CSV_sentCount = 0;
				int count = 0;
				for (int index = 0; index < CSV_Output.size(); index++) {
					Map<String, String> CSV_header = CSV_Output.get(index);

					Map<String, String> UI_header = UiData.get(index);

					for (Map.Entry<String, String> entry : UI_header.entrySet()) {
						String Header = entry.getKey().trim();
						String value = entry.getValue().trim();

						if (CSV_header.containsKey(Header)) {
							String CSV_value = CSV_header.get(Header).replaceAll("\"", "");
							if (Header.equals("Sent on")) {
								if (channel.equalsIgnoreCase("sms") || channel.equalsIgnoreCase("whatsapp")) {
									Date csvDate = convertCalendarToDate(CSV_value.replaceAll("[^a-zA-Z0-9 ]", ""),
											"EEE yyyy MMM dd");
									Date platFormDate = convertCalendarToDate(value, "EEE, MMM dd, yyyy");
									if (!csvDate.equals(platFormDate)) {
										BaseTest.getTest().log(Status.FAIL,
												"S.No " + CSV_header.get("S.No") + " ---> <b>" + Header
														+ "</b> values for  CSV : " + CSV_value + " and UI grid: "
														+ value + " mismatched");
									}
								} else {
									Date csvDate = convertCalendarToDate(CSV_value.replaceAll("[^a-zA-Z0-9 ]", ""),
											"EEE  MMM dd  yyyy");
									Date platFormDate = convertCalendarToDate(value, "EEE, MMM dd, yyyy");
									if (!csvDate.equals(platFormDate)) {
										BaseTest.getTest().log(Status.FAIL,
												"S.No " + CSV_header.get("S.No") + " ---> <b>" + Header
														+ "</b> values for  CSV : " + CSV_value + " and UI grid: "
														+ value + " mismatched");
									}
								}
							} else if (Header.equals("Start date")) {

								Date csvDate = convertCalendarToDate(CSV_value.replaceAll("[^a-zA-Z0-9 ]", ""),
										"EEE  MMM dd  yyyy");
								Date platFormDate = convertCalendarToDate(value.replaceAll("[^a-zA-Z0-9 ]", ""),
										"EEE MMM dd yyyy");
								if (!csvDate.equals(platFormDate)) {
									BaseTest.getTest().log(Status.FAIL,
											"S.No " + CSV_header.get("S.No") + " ---> <b>" + Header
													+ "</b> values for  CSV : " + CSV_value + " and UI grid: " + value
													+ " mismatched");
								}
							} else if (Header.equals("End date")) {
								Date csvDate = convertCalendarToDate(CSV_value.replaceAll("[^a-zA-Z0-9 ]", ""),
										"EEE  MMM dd  yyyy");
								Date platFormDate = convertCalendarToDate(value.replaceAll("[^a-zA-Z0-9 ]", ","),
										"EEE, MMM dd, yyyy");
								if (!csvDate.equals(platFormDate)) {
									BaseTest.getTest().log(Status.FAIL,
											"S.No " + CSV_header.get("S.No") + " ---> <b>" + Header
													+ "</b> values for  CSV : " + CSV_value + " and UI grid: " + value
													+ " mismatched");
								}
							} 
							else if (!CSV_value.equals(value)) {
								System.out.println(CSV_value);
								System.out.println(value);
								BaseTest.getTest().log(Status.FAIL,
										"S.No " + CSV_header.get("S.No") + " ---> <b>" + Header
												+ "</b> values for  CSV : " + CSV_value + " and UI grid: " + value
												+ " mismatched");
							}
							
						} else {
							BaseTest.getTest().log(Status.FAIL,
									"<b>" + Header + "</b>  ---> CSV and UI grid header's name mismatched");
						}
					}

					// ------------- Validate Sent count ---------------

					String param = channel.equalsIgnoreCase("QR code") ? "Audience count" : "Sent";
					if (CSV_header.containsKey(param)) {
						try {
							System.out.println(CSV_header.get(param));
							CSV_sentCount = CSV_sentCount + Integer.parseInt(CSV_header.get(param));
						} catch (Exception e) {
							CSV_sentCount = CSV_sentCount + 0;
						}
					}
					count++;
					if (index != 0 && count % 5 == 0) {
						BaseTest.getTest().log(Status.INFO, "Total validated Communications : " + count);
					}
				}
				consumption.put(channel + "Consumption Dasboard Count", String.valueOf(sent));
				consumption.put("Downloaded CSV <b>'Sent'</b> Count", String.valueOf(CSV_sentCount));
				ExtentManager.customReport(consumption);

				if (CSV_sentCount == sent) {
					BaseTest.getTest().log(Status.PASS, "Send Count ---> Consumption dasboard Count : " + sent
							+ ", Downloaded CSV 'Send' Count : " + CSV_sentCount + " is same, As expected");
				} else {
					BaseTest.getTest().log(Status.FAIL, "Send Count ---> Consumption dasboard Count : " + sent
							+ ", Downloaded CSV 'Send' Count : " + CSV_sentCount + " is not same, As expected");
				}
			} else {
				BaseTest.getTest().log(Status.WARNING, "No data Found");
			}
		} else {
			BaseTest.getTest().log(Status.WARNING,
					"Consumption channel " + channel + " count is zero for selected month");
		}
		return this;
	}

	public void consumptionAllDashboard(String Channel) {
		int consumptionCount = 0;
		pageLoaderLogo();
		isDisplayed(PreferencesRepository.preferences_consumption_conReport);
		explicitwaitforclick(autolocator(PreferencesRepository.preferences_ConsumptionsYear), 60);
		String currentYear = getCurrentYear("YYYY");
		String currentMonth = getCurrentMonth("MMMMMMMMM");
//		clickElement(PreferencesRepository.preferences_ConsumptionsYear);
//		threadSleep(ObjectRepository.wait2sec);
//		BaseTest.takeScreenshot();
//		selectlistelements("Select Year " + currentYear + ",xpath,//div[@class='dropdown-menu show dropdown-menu-end']//a", currentYear);
//		clickElement(PreferencesRepository.preferences_ConsumptionsMonth);
//		threadSleep(ObjectRepository.wait3sec);
//		BaseTest.takeScreenshot();
//		selectlistelements(PreferencesRepository.preferences_ConsumptionsMonthSelectlist, currentMonth);
		javaScriptScrollDown();
		List<WebElement> channels = findElements(PreferencesRepository.preferences_Consumptions_Allchannels);
		List<WebElement> ConsumptionCountSize = findElements(
				PreferencesRepository.preferences_Consumptions_AllchannelsCount);
		for (int i = 0; i < channels.size(); i++) {
			String actual = channels.get(i).getText().trim();
			if (actual.equalsIgnoreCase(Channel)) {
				String countText = ConsumptionCountSize.get(i).getText();
				consumptionCount = Integer.parseInt(countText.replaceAll("\\D", ""));
				if (countText.contains("M") || countText.contains("K")) {
					mouseHover(ConsumptionCountSize.get(i));
					consumptionCount = Integer
							.parseInt(getStrText(DashboardRepository.allpage_tooltip).replaceAll("\\D", ""));
				}
				BaseTest.getTest().log(Status.INFO, Channel + " Channel Consumption Count is : " + consumptionCount);
				javaScriptHighLightwithScrnShot(channels.get(i));

				if (!checkmonthStatus(consumptionCount)) {
					BaseTest.getTest().log(Status.WARNING,
							"<b>" + Channel + "</b> Consumption Count is <b> Zero </b> ");
					String portlet = ConsumptionCountSize.get(i).getAttribute("class");
					if (!portlet.contains("click-off")) {

						BaseTest.getTest().log(Status.WARNING, "Porlet is enabled eventhough Count has zero");
					}
					BaseTest.takeScreenshot();
				} else {
					javaScriptScrollDown();
					channels = findElements(PreferencesRepository.preferences_Consumptions_Allchannels);
					ConsumptionCountSize = findElements(
							PreferencesRepository.preferences_Consumptions_AllchannelsCount);
					for (int j = 0; j < channels.size(); j++) {
						actual = channels.get(j).getText().trim();
						if (actual.equalsIgnoreCase(Channel)) {
							countText = ConsumptionCountSize.get(j).getText();
							consumptionCount = Integer.parseInt(countText.replaceAll("\\D", ""));
							if (countText.contains("M") || countText.contains("K")) {
								mouseHover(ConsumptionCountSize.get(i));
								consumptionCount = Integer.parseInt(
										getStrText(DashboardRepository.allpage_tooltip).replaceAll("\\D", ""));
							}
							BaseTest.getTest().log(Status.INFO,
									Channel + " Channel Consumption Count is : " + consumptionCount);
							javaScriptHighLightwithScrnShot(channels.get(i));
						}
					}
				}
				consumptionReport.put(Channel, consumptionCount);
			}
		}
	}

	public boolean checkmonthStatus(int consumptionCount) {
		Date d = new Date();
		int date = d.getDate();
		boolean flag = false;
		if (consumptionCount == 0 && date == 1) {
			javascriptdoublescrollup();
			javaScriptScrollUpToSomeExtend();
			;
			clickElement(PreferencesRepository.preferences_ConsumptionsMonth);
			List<WebElement> months = findElements(PreferencesRepository.preferences_ConsumptionMonthDropdownValue);
			if (months.size() == 1) {
				clickElement(PreferencesRepository.preferences_ConsumptionsYear);
				List<WebElement> years = findElements(PreferencesRepository.preferences_ConsumptionMonthDropdownValue);
				if (years.size() > 1) {
					if (!years.get(1).getAttribute("class").contains("active")) {
						years.get(1).click();
					}
					clickElement(PreferencesRepository.preferences_ConsumptionsMonth);
					months = findElements(PreferencesRepository.preferences_ConsumptionMonthDropdownValue);
					months.get(11).click();
				} else {
					throw new IllegalArgumentException("Expected Year is not present.");
				}
			} else {
				months.get(months.size() - 2).click();
			}
			pageLoaderLogo();
			flag = true;
		}
		
		  else if (consumptionCount != 0 && date != 1)
		  { flag = true; }
		 
		return flag;
	}

	public void personaValidation() {

		String[] array = { "propensity", "Communicat...", "Others", "Fingerprin...", "Brand", "Customer" };
		for (int i = 0; i < array.length; i++) {
			List<WebElement> personaldetails = findElements(
					"Header check,xpath,//div[@class='rs-expand-collapse']//span[.='" + array[i] + "']");
			if (!personaldetails.isEmpty()) {
				BaseTest.getTest().log(Status.INFO, "" + array[i] + "Header is available in the data attribute box");

			} else {
				BaseTest.getTest().log(Status.FAIL, "All headers are not available in the data attribute box");
			}
		}
	}

	public void selectAttributeValues(String attributeName, String condition, String attributeValue) {
		clickElement(PreferencesRepository.preferences_audiencescore_searchicon);
		enterValue(PreferencesRepository.preferences_audiencescore_searchinput, attributeName);
		clickElement(
				"Attribute Add Icon,xpath,//div[@class='accordionBlock']//ul//li[not(contains(@class,'click-off'))][contains(.,'"
						+ attributeName + "')]//span");
		clickElement(PreferencesRepository.preferences_audiencescore_searchicon);
		clickElement("Condition Dropdown,xpath,//ul[@class='attributeList']//li//h5[.='" + attributeName
				+ "']//ancestor::li//span[@class='k-input-value-text']");
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, condition);
		clickElement("Attribute text field,xpath,//ul[@class='attributeList']//li//h5[.='" + attributeName
				+ "']//ancestor::li//input");
		enterValue("Attribute text field,xpath,//ul[@class='attributeList']//li//h5[.='" + attributeName
				+ "']//ancestor::li//input", attributeValue);
		threadSleep(400);
		if (isElementPresent(DashboardRepository.allpage_common_selectdropdownlist)) {
			selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, attributeValue);
		}
	}

	public void attributeCheck(Map<String, List<String>> attributes) {
		List<WebElement> filterGroupAttributes;
		for (Entry<String, List<String>> entry : attributes.entrySet()) {
			String trgtHeaderName = entry.getKey();
			List<String> trgtAttributes = entry.getValue();
			List<String> filterAttributes = new ArrayList<String>();
			javaScriptScrollIntoView("Header Name,xpath,//h4[.='" + trgtHeaderName + "']");
			clickElement("Expand icon,xpath,//h4[.='" + trgtHeaderName
					+ "']//..//..//div[contains(@class,'tag-list-block box')]//..//i[contains(@class,'mini')]");
			filterGroupAttributes = findElements("Attributes,xpath,//h4[.='" + trgtHeaderName + "']//..//..//li");
			for (WebElement attributesName : filterGroupAttributes) {
				filterGroupAttributes = findElements("Attributes,xpath,//h4[.='" + trgtHeaderName + "']//..//..//li");
				String attribute = attributesName.getText();
				filterAttributes.add(attribute);
			}
			Collections.sort(trgtAttributes);
			Collections.sort(filterAttributes);
			boolean val = trgtAttributes.equals(filterAttributes);
			System.out.println(val);
			System.out.println(trgtAttributes);
			System.out.println(filterAttributes);
			writeLog(trgtAttributes.equals(filterAttributes),
					trgtAttributes + " target <b>" + trgtHeaderName
							+ "</b> attributes present as expected filter group attributes" + filterAttributes,
					trgtAttributes + " target " + trgtHeaderName
							+ " attributes not present as expected filter group attributes" + filterAttributes);
			clickElement(
					"Collapse icon,xpath,//h4[.='" + trgtHeaderName + "']//..//..//i[contains(@class,'collapseIcon')]");
			threadSleep(ObjectRepository.wait1sec);
		}
	}

	public String select_AnonymousAttributeName_In_Persona() {
		List<WebElement> attributes = findElements(
				PreferencesRepository.preferences_audiencescore_enableaccordianattributes);
		List<String> attribute = attributes.stream().map(WebElement::getText).map(s -> s.replaceAll("\n", ""))
				.map(s -> s.replaceAll("\\+", "")).map(s -> s.replaceAll("Dated", "")).filter(text -> !text.isEmpty())
				.collect(Collectors.toList());
		return attribute.get(0) + "," + attribute.get(1);
	}

	public String[] select_AnonymousAttributevalues_In_Persona(String[] attributeNames) {
		String[] attValue = new String[attributeNames.length];
		for (int i = 0; i < attributeNames.length; i++) {
			if (attributeNames[i].toLowerCase().contains("age")) {
				attValue[i] = "18";
			} else if (attributeNames[i].toLowerCase().contains("language")) {
				attValue[i] = "Tamil";
			} else if (attributeNames[i].toLowerCase().contains("mobileno")) {
				attValue[i] = "9191239473";
			} else {
				attValue[i] = attValue[i] + " " + i;
			}
		}
		return attValue;
	}

	public void createPersona_From_AudienceScore() {
		Map<String, String> attributes = new LinkedHashMap<>();
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_audiencescore_previewokaypopup);
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_audiencescore_addpersonaicon);
		pageLoaderLogo();
		try {
			explicitwaitforvisibility(autolocator(PreferencesRepository.preferences_audiencescore_addpersonaheader),
					240);
			String[] attributeNames = BaseTest.getData().AttributeMapping.isEmpty()
					? select_AnonymousAttributeName_In_Persona().split(",")
					: BaseTest.getData().AttributeMapping.split(",");
			String[] attributeValues = BaseTest.getData().AttributeValue.isEmpty()
					? select_AnonymousAttributevalues_In_Persona(attributeNames)
					: BaseTest.getData().AttributeValue.split(",");
			int count = 0;
			for (String attributeName : attributeNames) {
				selectAttributeValues(attributeName, BaseTest.getData().Condition, attributeValues[count]);
				attributes.put(attributeName, attributeValues[count]);
				count++;
			}
			clickElement(PreferencesRepository.preferences_audiencescore_createbutton);
			explicitwaitforvisibility(autolocator(PreferencesRepository.preferences_audiencescore_savepersonaPopup),
					120);
			writeLog(isElementPresent(PreferencesRepository.preferences_audiencescore_savepersonaPopup),
					"Save Persona popup is displayed as expected.", "Save Persona popup is not displayed as expected.");
			enterValue(PreferencesRepository.preferences_audiencescore_personaname,
					"persona" + addTimeToName().replaceAll("_", ""));
			tabAction();
			explicitwaitforInvisibility(AudienceRepository.audience_importdesc_loader, 90);
			clickElement(PreferencesRepository.preferences_audiencescore_personasave);
		} catch (Exception e) {
			BaseTest.getTest().log(Status.FAIL, "Unable to Save persona");
			BaseTest.takeScreenshot();
		}
	}

	public void audienceScoreAddpersona() {
		String personaattribute = "Age";
		String personaname = "persona" + addTimeToName().replaceAll("_ ", "");
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_Audiencescore_click);
		BaseTest.takeScreenshot();
		pageLoaderLogo();
//		explicitwaitforclick(autolocator(PreferencesRepository.preferences_Audiencescore_Close_icon), 60);
		threadSleep(ObjectRepository.wait3sec);
		click(PreferencesRepository.preferences_Audiencescore_Close_icon);
		click(PreferencesRepository.preferences_Audiencescore_CommonAdd);
		personaValidation();
		if (isDisplayed(PreferencesRepository.preferences_Audiencescore_Header)) {
			clickElement(PreferencesRepository.preferences_Addpersonasearchicon);
			enterValue(PreferencesRepository.preferences_AddpersonasearchInput, personaattribute);
			List<WebElement> allAttributes = driver.findElements(By.xpath("//div[@class='accordionBlock']//ul//li"));
			for (int i = 0; i < allAttributes.size(); i++) {
				String elementName = allAttributes.get(i).getText().replace("+", "").trim();
				if (elementName.equals(personaattribute)) {
					allAttributes.get(i).click();
					break;
				}
			}
			enterValue(PreferencesRepository.preferences_AddpersonaValueInput, "26");
			clickElement(PreferencesRepository.preferences_AddpersonaCreate);
			if (isDisplayed(PreferencesRepository.preferences_AddpersonaPopupHeader)) {
				BaseTest.getTest().log(Status.INFO, "Add persona header is available");
			}
			enterValue(PreferencesRepository.preferences_AddpersonaPopupInput, personaname);
			tabAction();
			threadSleep(ObjectRepository.wait5sec);
			clickElement(PreferencesRepository.preferences_AddpersonaPopupInputSave);
			pageLoaderLogo();
			if (isDisplayed(PreferencesRepository.preferences_PersonaHeader))
			{
				javaScriptScrollDown();
				clickElement("Edit icon,xpath,//div[contains(@class,'pacr-row')]//div[.='" + personaname + "']//..//i[@id='rs_data_pencil_edit']");
			}
			clearField(PreferencesRepository.preferences_AddpersonaValueInput);
			enterValue(PreferencesRepository.preferences_AddpersonaValueInput, "27");
			clickElement(PreferencesRepository.preferences_AddpersonaSave);
			threadSleep(ObjectRepository.wait2sec);
			clearField(PreferencesRepository.preferences_AddpersonaPopupInput);
			enterValue(PreferencesRepository.preferences_AddpersonaPopupInput, personaname);
			tabAction();
			clickElement(PreferencesRepository.preferences_AddpersonaPopupInputSave);
			javaScriptScrollDown();
			clickElement("Edit icon,xpath,//div[contains(@class,'pacr-row')]//div[.='" + personaname
					+ "']//..//i[@id='rs_data_pencil_edit']");
			String ageboxvalue = getTextBoxVal(PreferencesRepository.preferences_AddpersonaValueInput, "value");
			compareUiwithInputvalue(ageboxvalue, "27");

		}

	}


	public void preferencesInvoices()
	{
		explicitwaitforclick(autolocator(PreferencesRepository.preferences_Invoices), 20);
		toolTipValidationKnownText(PreferencesRepository.preferences_Invoices, "View and download platform invoices");
		clickElement(PreferencesRepository.preferences_Invoices);
	}

	public PreferencesPage inVoiceList() {
		String subscriptionInvoice = getStrText(
				",xpath,//div[contains(@class,'fullWhiteBackground')]//span[.='Subscription invoice']");
		String consumableInvoice = getStrText(
				",xpath,//div[contains(@class,'fullWhiteBackground')]//span[.='Consumables invoice']");
		if (subscriptionInvoice.equalsIgnoreCase("Subscription invoice")
				&& consumableInvoice.equalsIgnoreCase("Consumables invoice")) {
			String subscriptionInvoicetab = getTextBoxVal(PreferencesRepository.preferences_Invoices_SubTabheader,
					"class");
			String consumableInvoicetab = getTextBoxVal(PreferencesRepository.preferences_Invoices_ConsTabheader,
					"class");
			// SDX-TC-PRE-PH2-006
			if (subscriptionInvoicetab.contains("active") && consumableInvoicetab.contains("click-off")) {
				BaseTest.getTest().log(Status.INFO,
						"Subscription invoice is active and Consumable invoice Tab is disabled in Invoice listing page");
			} else {
				BaseTest.getTest().log(Status.WARNING,
						"Subscription invoice is not active and Consumable invoice Tab is Enabled in Invoice listing page");
			}
		} else {
			BaseTest.getTest().log(Status.WARNING,
					"Subscription invoice and Consumable invoice Tab is not available in Invoice listing page");
		}
		// SDX-TC-PRE-266
		List<WebElement> gridList = findElements(",xpath,//tr//th");
		for (WebElement webElement : gridList) {
			String value = webElement.getText();

			if (value.contains("Invoice number") || value.contains("Invoice date") || value.contains("Amount (USD)")
					|| value.contains("Payment mode") || value.contains("Status") || value.contains("Due date")
					|| value.contains("Action")) {
				BaseTest.getTest().log(Status.INFO,
						"The Column " + value + " is available in provided grid column on Invoice Listing page");
			} else {
				BaseTest.getTest().log(Status.WARNING,
						"The Column " + value + " is not available in provided grid column on Invoice Listing page");
			}
		}

		toolTipValidationprefernces(PreferencesRepository.preferences_Invoices_Previewicon, "View");
		clickElement(PreferencesRepository.preferences_Invoices_Previewicon);
		explicitwaitforvisibility(autolocator(",xpath,//div[@class='heading-title-text']//h1[.='Invoice']"), 10);
		String invoiceText = getStrText(",xpath,//div[@class='heading-title-text']//h1[.='Invoice']");
		uiPageEqualswithInputValue(invoiceText, "Invoice");
		// RESUL
		// To field verification
		String toField = getStrText(",xpath,//div[@class='invoice-address ']//h4");
		uiPageEqualswithInputValue(toField, "To,");

		String toFieldText = getStrText(",xpath,(//div[@class='invoice-address ']//li)[1]");
		if (toFieldText != null || toField.isBlank() || toField.isEmpty()) {
			BaseTest.getTest().log(Status.INFO, "To Field value is available in invoice page");
		} else {
			BaseTest.getTest().log(Status.FAIL, "To Field value is not available in invoice page");
		}
		// Date Time verification
		String dateVerification = getStrText(",xpath,(//div[@class='d-flex mt25']//ul//li)[1]");
		uiPageEqualswithInputValue(dateVerification, "Date/Time:");
		// Date Time value verification
		String dateValueVerification = getStrText(",xpath,(//ul[@class='pl10']//li)[1]");
		if (dateValueVerification != null || dateValueVerification.isBlank() || dateValueVerification.isEmpty()) {
			BaseTest.getTest().log(Status.INFO, "Date and Time Field value is available in invoice page");
		} else {
			BaseTest.getTest().log(Status.FAIL, "Date and Time Field value is not available in invoice page");
		}
		// Invoice verification
		String invoiceVerification = getStrText(",xpath,(//div[@class='d-flex mt25']//li)[2]");
		uiPageEqualswithInputValue(invoiceVerification, "Invoice number:");
		// Invoice value verification
		String invoiceValueVerification = getStrText(",xpath,(//div[@class='d-flex mt25']//ul//li)[6]");
		if (invoiceValueVerification != null || invoiceValueVerification.isBlank()
				|| invoiceValueVerification.isEmpty()) {
			BaseTest.getTest().log(Status.INFO, "Invoice Field value is available in invoice page");
		} else {
			BaseTest.getTest().log(Status.FAIL, "Invoice Field value is not available in invoice page");
		}
		// Amount verification
		String amountVerification = getStrText(",xpath,(//div[@class='d-flex mt25']//li)[3]");
		uiPageEqualswithInputValue(amountVerification, "Payable amount:");
		// Amount value verification
		String amountValueVerification = getStrText(",xpath,(//div[@class='d-flex mt25']//ul//li)[7]");
		if (amountValueVerification != null || amountValueVerification.isBlank() || amountValueVerification.isEmpty()) {
			BaseTest.getTest().log(Status.INFO, "Amount Field value is available in invoice page");
		} else {
			BaseTest.getTest().log(Status.FAIL, "Amount Field value is not available in invoice page");
		}
		// Due date verification
		String duedateVerification = getStrText(",xpath,(//div[@class='d-flex mt25']//li)[4]");
		uiPageEqualswithInputValue(duedateVerification, "Due date:");
		// Due date value verification
		String duedateValueVerification = getStrText(",xpath,(//div[@class='d-flex mt25']//ul//li)[8]");
		if (duedateValueVerification != null || duedateValueVerification.isBlank()
				|| duedateValueVerification.isEmpty()) {
			BaseTest.getTest().log(Status.INFO, "Due Date Field value is available in invoice page");
		} else {
			BaseTest.getTest().log(Status.FAIL, "Due Date Field value is not available in invoice page");
		}
		// Account/Client verification
		String accountVerification = getStrText(
				",xpath,(//div[@class='bg-tertiary-grey my15 p15 theme-radius']//small)[1]");
		uiPageEqualswithInputValue(accountVerification, "Account/Client:");
		// Account value verification
		String accountValueVerification = getStrText(
				",xpath,(//div[@class='bg-tertiary-grey my15 p15 theme-radius']//h4)[1]");
		if (accountValueVerification != null || accountValueVerification.isBlank()
				|| accountValueVerification.isEmpty()) {
			BaseTest.getTest().log(Status.INFO, "Account/Client Field value is available in invoice page");
		} else {
			BaseTest.getTest().log(Status.FAIL, "Account/Client Field value is not available in invoice page");
		}
		// Account no. verification
		String accountnoVerification = getStrText(
				",xpath,(//div[@class='bg-tertiary-grey my15 p15 theme-radius']//small)[2]");
		uiPageEqualswithInputValue(accountnoVerification, "Account.No:");
		// Account value verification
		String accountnoValueVerification = getStrText(
				",xpath,(//div[@class='bg-tertiary-grey my15 p15 theme-radius']//h4)[2]");
		if (accountnoValueVerification != null || accountnoValueVerification.isBlank()
				|| accountnoValueVerification.isEmpty()) {
			BaseTest.getTest().log(Status.INFO, "Account no. Field value is available in invoice page");
		} else {
			BaseTest.getTest().log(Status.FAIL, "Account no. Field value is not available in invoice page");
		}
		// Table Content
		List<WebElement> tableHeader = findElements(",xpath,//table[@class='rs-table table ']//th");
		for (WebElement webElement : tableHeader) {
			String value = webElement.getText();

			if (value.contains("Subscription type") || value.contains("Price/mo. (USD)")
					|| value.contains("Payment frequency") || value.contains("Amount (USD)")) {
				BaseTest.getTest().log(Status.INFO,
						"The Column " + value + " is available in provided Table header on Invoice Listing page");
			} else {
				BaseTest.getTest().log(Status.FAIL,
						"The Column " + value + " is not available in provided Table header on Invoice Listing page");
			}
		}
		javaScriptScrolltoTop();
		clickElement(PreferencesRepository.preferences_Invoices_Download);
		filehandle();
		return this;
	}

	public void licenseinfo() {
		explicitwaitforclick(autolocator(PreferencesRepository.preferences_LicenseInfo), 20);
		toolTipValidationKnownText(PreferencesRepository.preferences_LicenseInfo,
				"View and upgrade your current subscription plan");
		clickElement(PreferencesRepository.preferences_LicenseInfo);
	}

	public void licenseInfoCheck() {
	}

	public PreferencesPage clickPreferencesMyProfile() {
		threadSleep(ObjectRepository.wait2sec);
		clickElement(PreferencesRepository.preferences_myprofile_iconclick);
		if (isDisplayed(PreferencesRepository.preferences_myprofile_pagelogo)) {
			BaseTest.getTest().info(MarkupHelper.createLabel("PREFERENCES - MY PROFILE MENU", ExtentColor.BROWN));
			BaseTest.takeScreenshot();
			pageLoaderLogo();
			threadSleep(ObjectRepository.wait5sec);
		}
		return this;
	}

	public PreferencesPage clickPreferencesAccountSettingslink() {
		explicitwaitforclick(autolocator(PreferencesRepository.click_AccountSettings), 30);
		clickElement(PreferencesRepository.click_AccountSettings);
		pageLoaderLogo();
		if (uiPageEqualswithInputValue(getStrText(",xpath,//h1"), "Edit company account")) {
			BaseTest.getTest().info(MarkupHelper.createLabel("ACCOUNT SETTINGS ", ExtentColor.BLUE));
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public PreferencesPage clickPreferencesUserManagementlink() {
		explicitwaitforclick(autolocator(PreferencesRepository.preferences_UserManagementlink), 30);
		clickElement(PreferencesRepository.preferences_UserManagementlink);
		pageLoaderLogo();
		if (uiPageEqualswithInputValue(getStrText(",xpath,//h1"), "Users")) {
			BaseTest.getTest().info(MarkupHelper.createLabel("User Management", ExtentColor.BLUE));
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public PreferencesPage clickPreferencesUserRolelink() {
		explicitwaitforclick(autolocator(PreferencesRepository.preferences_UserRolelink), 30);
		clickElement(PreferencesRepository.preferences_UserRolelink);
		pageLoaderLogo();
		if (uiPageEqualswithInputValue(getStrText(",xpath,//h1"), "Roles and permissions")) {
			BaseTest.getTest().info(MarkupHelper.createLabel("Roles and permissions", ExtentColor.BLUE));
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public PreferencesPage clickPreferencesCompanieslink() {
		explicitwaitforclick(autolocator(PreferencesRepository.preferences_Companieslink), 30);
		clickElement(PreferencesRepository.preferences_Companieslink);
		pageLoaderLogo();
		if (uiPageEqualswithInputValue(getStrText(",xpath,//h1"), "Companies list")) {
			BaseTest.getTest().info(MarkupHelper.createLabel("Companies list", ExtentColor.BLUE));
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public PreferencesPage alertAndNotification() {

		explicitwaitforclick(autolocator(PreferencesRepository.preferences_alertAndNotificationlink), 30);
		clickElement(PreferencesRepository.preferences_alertAndNotificationlink);
		pageLoaderLogo();
		if (uiPageEqualswithInputValue(getStrText(",xpath,//h1"), "Alerts and notifications")) {
			BaseTest.getTest().info(MarkupHelper.createLabel("Alert And Notification", ExtentColor.BLUE));
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public PreferencesPage CommSettinglink() {
		explicitwaitforclick(autolocator(PreferencesRepository.preferences_CommunicationSettingslink), 30);
		clickElement(PreferencesRepository.preferences_CommunicationSettingslink);
		pageLoaderLogo();
		if (uiPageEqualswithInputValue(getStrText(",xpath,//h1"), "Communication settings")) {
			BaseTest.getTest().info(MarkupHelper.createLabel("Communication Settings", ExtentColor.BLUE));
		}
		return this;
	}

	public PreferencesPage offerManagementlink() {
		explicitwaitforclick(autolocator(PreferencesRepository.preferences_offerManagementlink), 30);
		clickElement(PreferencesRepository.preferences_offerManagementlink);
		pageLoaderLogo();
		if (uiPageEqualswithInputValue(getStrText(",xpath,//h1"), "Offer management")) {
			BaseTest.getTest().info(MarkupHelper.createLabel("Offer management", ExtentColor.BLUE));
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public PreferencesPage clickAudienceScore() {
		explicitwaitforclick(autolocator(PreferencesRepository.preferences_audiencescore), 30);
		clickElement(PreferencesRepository.preferences_audiencescore);
		pageLoaderLogo();
		clickElement(PreferencesRepository.preferences_audiencescorenotipopup);
		if (uiPageEqualswithInputValue(getStrText(",xpath,//h1"), "Audience score")) {
			BaseTest.getTest().info(MarkupHelper.createLabel("Audience Score", ExtentColor.BLUE));
		}
		// isDisplayed(PreferencesRepository.preferences_audiencescorevalidation);
		return this;
	}

	public PreferencesPage templateBuilder() {
		explicitwaitforclick(autolocator(PreferencesRepository.preferences_templateBuilderlink), 30);
		clickElement(PreferencesRepository.preferences_templateBuilderlink);
		pageLoaderLogo();
		if (uiPageEqualswithInputValue(getStrText(",xpath,//h1"), "Choose template builder")) {
			BaseTest.getTest().info(MarkupHelper.createLabel("Template Builder", ExtentColor.BLUE));
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public PreferencesPage accessdataCatalogue() {
		explicitwaitforclick(autolocator(PreferencesRepository.preferences_dataCataloguelink), 30);
		clickElement(PreferencesRepository.preferences_dataCataloguelink);
		pageLoaderLogo();
		if (uiPageEqualswithInputValue(getStrText(",xpath,//h1"), "Data catalogue")) {
			BaseTest.getTest().info(MarkupHelper.createLabel("Data catalogue", ExtentColor.BLUE));
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public PreferencesPage accessdataExchange() {
		explicitwaitforclick(autolocator(PreferencesRepository.preferences_dataexchangelink), 30);
		clickElement(PreferencesRepository.preferences_dataexchangelink);
		pageLoaderLogo();
		if (uiPageEqualswithInputValue(getStrText(",xpath,//h1"), "Data exchange")) {
			BaseTest.getTest().info(MarkupHelper.createLabel("Data Exchange", ExtentColor.BLUE));
		}
		return this;
	}

	public PreferencesPage accessConsumption() {
		explicitwaitforclick(autolocator(PreferencesRepository.preferences_Consumptionlink), 30);
		clickElement(PreferencesRepository.preferences_Consumptionlink);
		pageLoaderLogo();
		if (uiPageEqualswithInputValue(getStrText(",xpath,//h1"), "Consumptions")) {
			BaseTest.getTest().info(MarkupHelper.createLabel("Consumptions", ExtentColor.BLUE));
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public PreferencesPage accessInvoices() {
		explicitwaitforclick(autolocator(PreferencesRepository.preferences_Invoicelink), 30);
		clickElement(PreferencesRepository.preferences_Invoicelink);
		pageLoaderLogo();
		if (uiPageEqualswithInputValue(getStrText(",xpath,//h1"), "Invoice list")) {
			BaseTest.getTest().info(MarkupHelper.createLabel("Invoice list", ExtentColor.BLUE));
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public PreferencesPage accessLicenseinfo() {
		explicitwaitforclick(autolocator(PreferencesRepository.preferences_Licenseinfolink), 30);
		clickElement(PreferencesRepository.preferences_Licenseinfolink);
		pageLoaderLogo();
		if (uiPageEqualswithInputValue(getStrText(",xpath,//h1"), "License info")) {
			BaseTest.getTest().info(MarkupHelper.createLabel("License info", ExtentColor.BLUE));
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public void backbutton() {
		threadSleep(ObjectRepository.wait2sec);
		clickElement("Back,xpath,//div[@class='header-back']/i");
		pageLoaderLogo();
	}

	public void allAttributeCheck(String attributeName) {
		clickElement(PreferencesRepository.preferences_datacatalogue_maximizeButton);
		clickElement(",xpath,//div[@class='col-sm-3 sticky']//div//li[.='" + attributeName + "']");
		pageLoaderLogo();
		BaseTest.takeScreenshot();
		clickElement(PreferencesRepository.preferences_datacatalogue_CancelIcon);
	}

	public PreferencesPage publishForm(String name, String Mobile, String Email, String genderName, String City) {
		BaseTest.getTest().info(MarkupHelper.createLabel(" SUBSCRIPTION FORM SUBMISSION ", ExtentColor.BROWN));

		// explicitwaitforvisibility(autolocator(PreferencesRepository.preferences_forms_Publishform_header),
		// 30);
		clickElement(PreferencesRepository.preferences_qr_formsubmit);
//		if (isDisplayed(PreferencesRepository.preferences_forms_Publishform_header))
//		{
//			uiPageEqualswithInputValue("Automation_Test_FORM", getStrText(PreferencesRepository.preferences_forms_Publishform_header + "//strong"));
		isElementAvailable(PreferencesRepository.preferences_forms_Publishform_mobileErr);
		isElementAvailable(PreferencesRepository.preferences_forms_Publishform_emaiErr);
		enterValue(PreferencesRepository.preferences_forms_Publishform_Name, name).keytabclick();
		enterValue(PreferencesRepository.preferences_forms_enterformemailid, Email).keytabclick();

		enterValue(PreferencesRepository.preferences_forms_enterformmobilenumber, Mobile).keytabclick();
		// input[@name='Gender'][@value= 'Option 1']
		// javaScriptClick(genderName + " Radio
		// button,xpath,//input[@name='Gender'][@value= '" + genderName + "']");
		clickElement(PreferencesRepository.preferences_forms_selectformcity);
		selectlistelements(PreferencesRepository.preferences_forms_cityOptions, City);
		actionsClickElement(PreferencesRepository.preferences_forms_formtermsncondition);
		clickElement(PreferencesRepository.preferences_qr_formsubmit);
		switchWindow();
		threadSleep(ObjectRepository.wait1sec);
		javaScriptPageLoad();
		BaseTest.takeScreenshot();
		// }
		return this;
	}

	public void createNewAttribute(String attributeName, String dataTypes) {
		pageLoaderLogo();
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_seg_newattributeheader), 30);
		enterValue(AudienceRepository.audience_seg_attributeNameField, attributeName);
		enterValue(AudienceRepository.audience_seg_description, BaseTest.getData().Description);
		tabAction();
		clickElement(PreferencesRepository.preferences_commSettings_Datacatalogue_datatype);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, dataTypes);
		clickElement(AudienceRepository.audience_seg_inputtype);
		uiPageEqualswithMultipleInputValue(AudienceRepository.audience_seg_dropdownValue, "Text,Integer,Decimal,Date");
		audienceSelectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().InputType);
		clickElement(AudienceRepository.audience_seg_filtergroup);
		uiPageEqualswithMultipleInputValue(AudienceRepository.audience_seg_dropdownValue, "Brand,Communication,Customer,Fingerprint,Others,Versium");
		audienceSelectlistelements(DashboardRepository.allpage_common_selectdropdownlist, BaseTest.getData().FilterGroup);
		clickElement(AudienceRepository.audience_seg_classification);
		uiPageEqualswithMultipleInputValue(AudienceRepository.audience_seg_dropdownValue,
				"Audience overview,Profile completeness,Personalisation,Content target,Sensitive data,Advanced analytics,Offline conversion,Audience base,Offers,GDPR");
		audienceSelectlistelements(DashboardRepository.allpage_common_selectdropdownlist,
				BaseTest.getData().Classification);
		if (BaseTest.getData().Classification.contains("Personalisation")) {
			enterValue(AudienceRepository.audience_seg_fallbackName, attributeName + "FL");
		}
		BaseTest.takeScreenshot();
		clickElement(AudienceRepository.audience_seg_newAttributeSave);
		pageLoaderLogo();
	}
	
	public String selectImportsourceTrgt()
	{
		String addAudienceby = "CSV";
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_uploadheader), 40);
		explicitwaitforclick(autolocator(AudienceRepository.audience_selectsource), 30);
		placeholderValueCheck(AudienceRepository.audience_selectsource_placeholder, "Source");
		pageLoaderLogo();
		clickElement(AudienceRepository.audience_selectsource);
		uiPageEqualswithMultipleInputValue(DashboardRepository.homepage_audience_uploadsourceselect, "Manual entry,CSV,Remote data source,FTP/SFTP");
		pageLoaderLogo();
		audienceSelectlistelements(DashboardRepository.allpage_common_selectdropdownlist, addAudienceby);
		pageLoaderLogo();
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_selectsourcereseticon), 30);
		// toolTipValidationKnownText(AudienceRepository.audience_selectsourcereseticon, "Reset");
		return addAudienceby;
	}
}
