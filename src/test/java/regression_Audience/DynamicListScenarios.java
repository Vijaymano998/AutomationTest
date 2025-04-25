
package regression_Audience;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;

import pages.AudiencePage_Dynamiclist;
import pages.AudiencePage_Targetlist;
import pages.CommunicationEmailChannelPage;
import pages.PreCommunicationAnalyticsPage;
import pages.SyncHistoryPage;
import repository.AudienceRepository;
import utility.BaseTest;
import utility.PageBase;

public class DynamicListScenarios extends BaseTest
{

	@Test(testName = "Dynamic list creation", description = "Create new dynamicList ")
	public void dynamiclistCreation() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.logout();
		dynamic.webURLlaunch();
		dynamic.target_Dynamic_approver1_Webmail_login();
		String rfalink = dynamic.getDynamicListRFAApprovalMailLink(EnterDynamiclistName);
		dynamic.webMailDelete();
		dynamic.openLoginPage().target_Dynamic_approver1_login();
		// dynamic.selectbusinessunit();
		BaseTest.getWebDriver().get(rfalink);
		dynamic.clickTargetDynamicRFAApproveBtn();
		// dynamic.targetlistUsingdynamicListRetainValidate(EnterDynamiclistName);
		dynamic.searchDynamicList(EnterDynamiclistName);

	}

	@Test(testName = "Dynamic list approval settings", description = "Dynamic list approval settings")
	public void dynamicListApprovalSettings() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		SyncHistoryPage sync = getPageFactory().syncHistoryPage();
		sync.login(sync.dPropertyLoginUserName(), sync.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.firstDynamicApprover(dynamic.audience_approver1);
		dynamic.rfaAddIcon();
		dynamic.secondDynamicapprover("Approver (smdxappuser6@info.smartdx.co)");
		dynamic.clickApprovalSettings();
		dynamic.verifyApprovalSettingsAnyvalue();
		dynamic.verifyApprovalSettingsOnOffValue();
	}

	@Test(testName = "Dynamic list Edit", description = "Dynamic list edit")
	public void dynamicListEdit() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistfromMenu();
		dynamic.EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		// dynamic.logout();
//		dynamic.webURLlaunch();
//		dynamic.target_Dynamic_approver1_Webmail_login();
//		String rfalink = dynamic.getDynamicListRFAApprovalMailLink(EnterDynamiclistName);
//		dynamic.webMailDelete();
//		dynamic.openLoginPage().target_Dynamic_approver1_login();
//		// dynamic.selectbusinessunit();
//		BaseTest.getWebDriver().get(rfalink);
//		Thread.sleep(5000);
//		dynamic.clickTargetDynamicRFAApproveBtn();
//		dynamic.logout();
//		dynamic.loginwithoutplugin(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
//		dynamic.selectbusinessunit();
		// dynamic.clickDynamiclistfromMenu();
		dynamic.searchDynamicList(dynamic.EnterDynamiclistName);
		dynamic.editDynamicist();
		dynamic.searchDynamicList(dynamic.EnterDynamiclistName);

	}

	@Test(testName = "Dynamic List duplicate", description = "Dynamic List duplicate")
	public void dynamicListDuplicate() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		String DuplicateDynamicName = BaseTest.getData().EnterDynamiclistName + "Duplicate" + dynamic.addTimeToName().replaceAll("_", "");
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1);
		dynamic.clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);
		dynamic.duplicateDynamic(DuplicateDynamicName);
		// dynamic.duplicateDynamicList(EnterDynamiclistName, DuplicateDynamicName);
		dynamic.searchDynamicList(DuplicateDynamicName);

	}

	@Test(testName = "Advance Search in Dynamic list", description = "Advance Search in Dynamic list")
	public void advanceSearch() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1);
		dynamic.clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);
		dynamic.getListDetailes();
		dynamic.advancedsearch();
	}

//	@Test(testName = "pw_Dynamic list search", description = "pw_Dynamic list search")
//	public void pw_DynamicAdvanceSearch()
//	{
//		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
//		dynamic.pw_login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
//		dynamic.pw_selectbusinessunit();
//		Page page = getPlayWright();
//		String list = BaseTest.getData().CommunicationName;
//		// page.pause();
//		dynamic.pw_clickElement(AudienceRepository.pw_audiencelinkclick);
//		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Dynamic lists")).click();
//		page.locator("#rs_RSAdvanceSearch_zoom").click();
//		page.locator(".icon-rs-caret-mini").click();
//		page.locator("input[name=\"list_name\"]").click();
//		page.locator("input[name=\"list_name\"]").fill("Dynamic");
//		page.getByText(list).click();
//		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search")).click();
//		dynamic.pw_mouseHover("//*[@class='rci-list-name']");
//		String listName = page.textContent("//div[contains(@class,'tooltip-inner')]");
//		dynamic.uiPageEqualswithInputValue(list, listName);
//	}

//	@Test(testName = "Dynamic list & grid view verification", description = "Dynamic list & grid view verification")
//
//	public void dynamicGridView()
//	{
//		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
//		dynamic.pw_login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
//		dynamic.pw_selectbusinessunit();
//		Page page = getPlayWright();
//		// page.pause();
//		dynamic.pw_clickElement(AudienceRepository.pw_audiencelinkclick);
//		page.waitForLoadState(LoadState.LOAD);
//		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Dynamic lists")).click();
//		page.waitForLoadState(LoadState.LOAD);
//		dynamic.pw_validateGridView();
//		dynamic.pw_validateListView();
//
//	}

	@Test(testName = "Dynamic list upto 8 Levels", description = "Dynamic list upto 8 levels")

	public void dynamicUpto8Levels() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		String DuplicateDynamicName = BaseTest.getData().DuplicatedDynamiclist + dynamic.addTimeToName().replaceAll("_", "");
		dynamic.selectTriggerValues();
		dynamic.ruleType().clickNewRule();
		dynamic.ruleType2().clickNewRule();
		dynamic.ruleType3().clickNewRule();
		dynamic.ruleType4().clickNewRule();
		dynamic.ruleType5().clickNewRule();
		dynamic.ruleType6().clickNewRule();
		dynamic.ruleType7().clickNewRule();
		dynamic.ruleType8();
		dynamic.javaScriptScrollDownToSomeExtend();
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
//		dynamic.logout();
//		dynamic.webURLlaunch();
//		dynamic.target_Dynamic_approver1_Webmail_login();
//		String rfalink = dynamic.getDynamicListRFAApprovalMailLink(EnterDynamiclistName);
//		dynamic.webMailDelete();
//		dynamic.openLoginPage().target_Dynamic_approver1_login();
//		// dynamic.selectbusinessunit();
//		BaseTest.getWebDriver().get(rfalink);
//		dynamic.clickTargetDynamicRFAApproveBtn();
		// dynamic.targetlistUsingdynamicListRetainValidate(EnterDynamiclistName);
		dynamic.searchDynamicList(EnterDynamiclistName);

	}

//	@Test(testName = "Dynamic list upto 8 Levels", description = "Dynamic list upto 8 levels")
//
//	public void dynamicUpto8Levels() throws InterruptedException
//	{
//		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
//		dynamic.pw_login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
//		dynamic.pw_selectbusinessunit();
//		Page page = getPlayWright();
//		dynamic.pw_clickElement(AudienceRepository.pw_audiencelinkclick);
//		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Dynamic lists")).click();
//		page.locator("#rs_data_circle_plus_fill_edge").click();
//		page.getByPlaceholder(" ").click();
//		page.getByText("List nameEnter the list name *Rule GroupMatch typeAllAnyTrigger sourceTrigger").click();
//		page.getByText("List nameEnter the list name *Rule GroupMatch typeAllAnyTrigger sourceTrigger").click();
//		page.getByLabel("Trigger source").locator("span").nth(1).click();
//		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​Website")).click();
//		page.getByText("Rule GroupMatch").click();
//		page.getByLabel("URL").locator("span").nth(1).click();
//		page.getByText("https://www.abc.com").click();
//		page.locator("form i").nth(1).click();
//		page.getByLabel("Rule type").locator("button").click();
//		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​Device")).click();
//		page.getByLabel("Type", new Page.GetByLabelOptions().setExact(true)).locator("span").nth(1).click();
//		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​Contains")).click();
//		page.getByLabel("Values").click();
//		page.getByText("Desktop").click();
//		page.locator("form i").nth(1).click();
//		page.locator("div:nth-child(2) > .pr0 > .align-items-end > .col-sm-4 > .rs-kendo-dropdownmenu-wrapper > .k-floating-label-container > .k-dropdownlist > .k-input-inner > .k-input-value-text").click();
//		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​Language")).click();
//		page.locator("div:nth-child(2) > .pr0 > div > .col-sm-8 > .align-items-end > div > .rs-kendo-dropdownmenu-wrapper > .k-floating-label-container > .k-dropdownlist > .k-input-inner > .k-input-value-text").click();
//		page.getByText("Is equal to").click();
//		page.locator("span").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Values$"))).getByLabel("Values").click();
//		page.locator("form").getByText("English").click();
//		page.locator(".icon-rs-circle-plus-fill-medium").click();
//		page.locator("div:nth-child(3) > .pr0 > .align-items-end > .col-sm-4 > .rs-kendo-dropdownmenu-wrapper > .k-floating-label-container > .k-dropdownlist > .k-button").click();
//		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​Last visit").setExact(true)).click();
//		page.locator(".text-center > .rs-bootstrap-dropdown > .rs-dropdown").click();
//		page.locator("#rs_RenderField_rangeattribute").click();
//		page.locator("#rs_RenderField_rangeattribute").fill("123");
//		page.getByText("DeviceRule typeContainsTypeDesktopValuesLanguageRule typeIs equal").click();
//		page.locator(".icon-rs-circle-plus-fill-medium").click();
//		page.locator("div:nth-child(4) > .pr0 > .align-items-end > .col-sm-4 > .rs-kendo-dropdownmenu-wrapper > .k-floating-label-container > .k-dropdownlist > .k-button").click();
//		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​Location")).click();
//		page.locator("div:nth-child(4) > .pr0 > div > .col-sm-8 > .align-items-end > div > .rs-kendo-dropdownmenu-wrapper > .k-floating-label-container > .k-dropdownlist > .k-input-inner > .k-input-value-text").click();
//		page.getByText("Is not equal to").click();
//		page.locator("#rs_RenderField_vlueattribute").click();
//		page.locator("#rs_RenderField_vlueattribute").press("CapsLock");
//		page.locator("#rs_RenderField_vlueattribute").fill("C");
//		page.locator("#rs_RenderField_vlueattribute").press("CapsLock");
//		page.locator("#rs_RenderField_vlueattribute").fill("Chennai");
//		page.locator(".icon-rs-circle-plus-fill-medium").click();
//		page.locator("div:nth-child(5) > .pr0 > .align-items-end > .col-sm-4 > .rs-kendo-dropdownmenu-wrapper > .k-floating-label-container > .k-dropdownlist > .k-input-inner > .k-input-value-text").click();
//		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​Page in")).click();
//		page.locator("div:nth-child(5) > .pr0 > div > .col-sm-8 > .align-items-end > div > .rs-kendo-dropdownmenu-wrapper > .k-floating-label-container > .k-dropdownlist > .k-input-inner > .k-input-value-text").first().click();
//		page.getByText("Is equal to").nth(1).click();
//		page.getByLabel("Value", new Page.GetByLabelOptions().setExact(true)).locator("span").nth(1).click();
//		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​Yes")).click();
//		page.locator(".icon-rs-circle-plus-fill-medium").click();
//		page.locator("div:nth-child(6) > .pr0 > .align-items-end > .col-sm-4 > .rs-kendo-dropdownmenu-wrapper > .k-floating-label-container > .k-dropdownlist > .k-input-inner > .k-input-value-text").click();
//		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​Site Clicks")).click();
//		page.locator("div:nth-child(6) > .pr0 > div > .col-sm-8 > .align-items-end > div > .rs-kendo-dropdownmenu-wrapper > .k-floating-label-container > .k-dropdownlist > .k-input-inner > .k-input-value-text").click();
//		page.getByText("Is equal to").nth(2).click();
//		page.locator("input[name=\"rule\\.0\\.RuleAttributes\\[5\\]\\.attributeValue\"]").click();
//		page.locator("input[name=\"rule\\.0\\.RuleAttributes\\[5\\]\\.attributeValue\"]").fill("test");
//		page.locator(".icon-rs-circle-plus-fill-medium").click();
//		page.locator("div:nth-child(7) > .pr0 > .align-items-end > .col-sm-4 > .rs-kendo-dropdownmenu-wrapper > .k-floating-label-container > .k-dropdownlist > .k-input-inner > .k-input-value-text").click();
//		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​User type")).click();
//		page.locator("div:nth-child(7) > .pr0 > div > .col-sm-8 > .align-items-end > div > .rs-kendo-dropdownmenu-wrapper > .k-floating-label-container > .k-dropdownlist > .k-input-inner > .k-input-value-text").click();
//		page.getByText("Is equal to").nth(3).click();
//		page.locator("span").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Values$"))).getByRole(AriaRole.LISTBOX).click();
//		page.getByText("Identified user").click();
//		page.locator(".icon-rs-circle-plus-fill-medium").click();
//		page.locator("div:nth-child(8) > .pr0 > .align-items-end > .col-sm-4 > .rs-kendo-dropdownmenu-wrapper > .k-floating-label-container > .k-dropdownlist > .k-input-inner > .k-input-value-text").click();
//		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​Language")).click();
//		page.locator("div:nth-child(8) > .pr0 > div > .col-sm-8 > .align-items-end > div > .rs-kendo-dropdownmenu-wrapper > .k-floating-label-container > .k-dropdownlist > .k-input-inner > .k-input-value-text").click();
//		page.getByText("Contains").nth(1).click();
//		page.locator("span").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Values$"))).getByRole(AriaRole.LISTBOX).click();
//		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​Italian")).click();
//		page.getByLabel("Request for approval").check();
//		page.getByLabel("Approver").locator("span").nth(1).click();
//		page.getByText("testing new (resuluser5744@").click();
//		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create rule")).click();
//		page.locator("#rs_RSAdvanceSearch_zoom").click();
//		page.locator(".icon-rs-caret-mini").click();
//		page.locator("input[name=\"list_name\"]").click();
//		page.locator("input[name=\"list_name\"]").fill(dynamic.targetListName);
//		page.getByText("list").click();
//		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search")).click();
//		/*
//		 * page.navigate("https://reacuix.resul.io/audience"); page.getByText("Dynamic Upto 8").click();
//		 */
//	}

	@Test(testName = "Dynamic list using Subscription form", description = "Dynamic list using subscription form")

	public void dynamicSubscriptonForm() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.triggerFormRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);
		dynamic.logout();
		dynamic.webURLlaunch();
		dynamic.target_Dynamic_approver1_Webmail_login();
		String rfalink = dynamic.getDynamicListRFAApprovalMailLink(EnterDynamiclistName);
		dynamic.webMailDelete();
		dynamic.openLoginPage().target_Dynamic_approver1_login();
		// dynamic.selectbusinessunit();
		BaseTest.getWebDriver().get(rfalink);
		dynamic.clickTargetDynamicRFAApproveBtn();
		// dynamic.targetlistUsingdynamicListRetainValidate(EnterDynamiclistName);
		dynamic.searchDynamicList(EnterDynamiclistName);

	}
//	@Test(testName = "Dynamic list using Subscription form", description = "Dynamic list using subscription form")
//
//	public void dynamicSubscriptonForm() throws InterruptedException
//	{
//		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
//		dynamic.pw_login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
//		dynamic.pw_selectbusinessunit();
//		Page page = getPlayWright();
//		// page.pause();
//
//		dynamic.pw_clickElement(AudienceRepository.pw_audiencelinkclick);
//		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Dynamic lists")).click();
//		page.locator("#rs_data_circle_plus_fill_edge").click();
//		page.getByPlaceholder(" ").click();
//		dynamic.pw_enterListName();
//		page.getByText("List nameEnter the list name *Rule GroupMatch typeAllAnyTrigger sourceTrigger").click();
//		page.getByText("List nameEnter the list name *Rule GroupMatch typeAllAnyTrigger sourceTrigger").click();
//		page.getByLabel("Trigger source").locator("span").nth(1).click();
//		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​Subscription Form")).click();
//		page.getByLabel("Rule type").locator("span").nth(1).click();
//		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​Forms")).click();
//		page.getByLabel("Form name").locator("span").nth(1).click();
//		page.getByText("AutoTest123455").click();
//		page.getByLabel("Form status").locator("span").nth(1).click();
//		page.getByText("Submitted", new Page.GetByTextOptions().setExact(true)).click();
//		page.getByLabel("Request for approval").check();
//		page.getByLabel("Approver").locator("span").nth(1).click();
//		page.getByText("testing new (resuluser5744@").click();
//		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create rule")).click();
//		dynamic.pw_clickElement(AudienceRepository.pw_audiencelinkclick);
//		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Dynamic lists")).click();
//		page.locator(".icon-rs-circle-list-edge-large").click();
//		page.waitForLoadState(LoadState.LOAD);
//		dynamic.pw_CreatedList(BaseTest.getData().EnterDynamiclistName);
//
//	}
   
	@Test(testName = "Dynamic list Group 1 And Group", description = "Dynamic list Group 1 And Group 2")

	public void group1AndGroup2() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.inclusion();
		dynamic.group2All();
		dynamic.group2TriggerType();
		dynamic.group2TriggerSource();
		dynamic.group2ruletype();
		dynamic.javaScriptScrollIntoView(AudienceRepository.audience_dynamic_rfachkbox);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);
	
	}
	
	@Test(testName = "Dynamic list Exclusion", description = "Dynamic list Exclusion")

	public void dynamiclistexclusion() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.exclusion();
		dynamic.group2All();
		dynamic.group2TriggerType();
		dynamic.group2TriggerSource();
		dynamic.group2ruletype();
		dynamic.javaScriptScrollIntoView(AudienceRepository.audience_dynamic_rfachkbox);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);
	}
//	@Test(testName = "Dynamic list Group 1 And Group", description = "Dynamic list Group 1 And Group 2")
//
//	public void group1AndGroup2() throws InterruptedException
//	{
//		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
//		dynamic.pw_login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
//		dynamic.pw_selectbusinessunit();
//		Page page = getPlayWright();
//		// page.pause();
//
//		dynamic.pw_clickElement(AudienceRepository.pw_audiencelinkclick);
//		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Dynamic lists")).click();
//		page.locator("#rs_data_circle_plus_fill_edge").click();
//		page.getByPlaceholder(" ").click();
//		dynamic.pw_enterListName();
//		page.getByText("List nameEnter the list name *Rule GroupMatch typeAllAnyTrigger sourceTrigger").click();
//		page.getByLabel("Trigger source").locator("span").nth(1).click();
//		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​Website")).click();
//		page.getByLabel("URL").locator("span").nth(1).click();
//		page.getByText("https://www.abc.com").click();
//		page.getByLabel("Rule type").locator("span").nth(1).click();
//		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​Browser")).click();
//		page.getByLabel("Type", new Page.GetByLabelOptions().setExact(true)).locator("span").nth(1).click();
//		page.getByText("Contains").click();
//		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^WebsiteTrigger sourcehttps:\\/\\/www\\.abc\\.comURL$"))).first().click();
//		page.getByRole(AriaRole.LISTBOX).click();
//		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​Chrome")).click();
//		// page.locator("#loading div").first().click();
//		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("")).click();
//		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Inclusion")).click();
//		page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^ANDORInclusion Group 2Match typeAllAnyTrigger sourceTrigger source$"))).getByLabel("All").check();
//		page.locator("div:nth-child(4) > .col-sm-9 > div > .col-sm-10 > .row > .col-sm-4 > .rs-kendo-dropdownmenu-wrapper > .k-floating-label-container > .k-dropdownlist > .k-input-inner > .k-input-value-text").click();
//		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​Mobile App")).click();
//		page.getByLabel("App name").locator("span").nth(1).click();
//		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​12321")).click();
//		page.locator("div:nth-child(5) > .col-sm-10 > div > .col-sm-9 > .align-items-end > .col-sm-4 > .rs-kendo-dropdownmenu-wrapper > .k-floating-label-container > .k-dropdownlist > .k-button").click();
//		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​App closed").setExact(true)).click();
//		page.getByLabel("Request for approval").check();
//		page.getByLabel("Approver").locator("span").nth(1).click();
//		page.getByText("RESUL Approver Three (smdxappuser7@info.smartdx.co)").click();
//		// page.waitForLoadState(LoadState.LOAD);
//		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Create rule")).click();
//		// page.navigate("https://reacuix.resul.io/audience");
//
//	}

	@Test(testName = "Dynamic list Request for approval", description = "Dynamic list Request for approval")
	public void dynamicRFA() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		// page.pause();
		/*
		 * String approver1WebmailUserName = "resuluser56@resul.team"; String approver1WebmailPassword = "7RUs6u8x"; String approver1Password =
		 * "Resul@123";
		 */
		// dynamic.searchDynamicValue(EnterDynamiclistName);
		dynamic.logout();
		dynamic.webURLlaunch();
		dynamic.target_Dynamic_approver1_Webmail_login();
		String rfalink = dynamic.getDynamicListRFAApprovalMailLink(EnterDynamiclistName);
		dynamic.webMailDelete();
		dynamic.openLoginPage().target_Dynamic_approver1_login();
		dynamic.selectbusinessunit();
		BaseTest.getWebDriver().get(rfalink);
		dynamic.clickTargetDynamicRFAApproveBtn();
		// String approver1Password = page.keyAcc1Pswrd();Ganesan Industrie (resuluser56@resul.team)
		// dynamic.dynamicListApproveRFAUser(dynamic.EnterDynamiclistName, approver1WebmailUserName, approver1WebmailPassword, approver1Password,
		// "approve");
	}

	@Test(testName = "Dynamic list more info details verification", description = "Dynamic List more info details verification")
	public void dynamicListMoreInfo() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
		String DynamicListNew = BaseTest.getData().EnterDynamiclistName;
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		dynamic.filterDynamicListTimePeriod();
		Map<String, String> dynamicListDetails = dynamic.searchDynamicList(DynamicListNew);
		String listName = (PageBase.shortListName != null) ? PageBase.shortListName : DynamicListNew;
		dynamic.clickMoreInfoIcon(listName);
		dynamic.dynamicListMoreInfoValidation(dynamicListDetails);
		// dynamic.moreInfoValidation();
	}

	@Test(testName = "Dynamic list encode value verification", description = "Dynamic list encode value verification")
	public void dynamicListEncodeValue() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
		String DynamicListNew = BaseTest.getData().EnterDynamiclistName;

		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		dynamic.searchDynamicList(DynamicListNew);

		dynamic.getDynamicListId();
		dynamic.dynamicIddecode();
		// dynamic.switchParentWin(DynamicListNew);
		dynamic.openLoginPage();
		dynamic.loginwithoutplugin(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.dynamicIdValidation();
	}

	@Test(testName = "Dynamic list Negative Scenarios", description = "Dynamic List Negative Scenarios")
	public void dynamicListNegativeScenarios() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
		// String DynamicListNew = BaseTest.getData().EnterDynamiclistName;

		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		dynamic.listingPageElements();
		dynamic.cancelFunctionality();
	}

	@Test(testName = "Dynamic List Using Website CustomEvents", description = "Dynamic List Using Website CustomEvents")
	public void dynamicListUsingWebsiteCustomEvents() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);

	}

	@Test(testName = "Dynamic List Using Website Device", description = "Dynamic List Using Website Device")
	public void dynamicListUsingWebsiteDevice() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);

	}

	@Test(testName = "Dynamic List Using Website Language", description = "Dynamic List Using Website Language")
	public void dynamicListUsingWebsiteLanguage() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);

	}
              
	@Test(testName = "Dynamic List Using Last session last visited page", description = "Dynamic List Using Website last visited page")
	public void dynamicListUsingWebsiteLastVisitedPage() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleTypeValue(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);

	}

	@Test(testName = "DynamicList Using Website Last Visit", description = "DynamicList Using Website Last Visit")
	public void dynamicListUsingWebsiteLastVisit() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);

	}

	@Test(testName = "Dynamic List Using Website Login", description = "Dynamic List Using Website Login")
	public void dynamicListUsingWebsiteLogin() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);

	}

	@Test(testName = "Dynamic List Using Website New Visitors", description = "Dynamic List Using Website New Visitors")
	public void dynamicListUsingWebsiteNewVisitors() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
	}

	@Test(testName = "DynamicList Website Operating system", description = "DynamicList Website Operating system")
	public void dynamicListUsingWebsiteOperatingSystem() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);

	}

	@Test(testName = "Dynamic List Website Notification Disabled", description = "Dynamic List Website Notification Disabled")

	public void dynamicListUsingWebsiteNotificationDisabled() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);

	}

	@Test(testName = "DynamicList Website Page depth", description = "DynamicList Website Page depth")
	public void dynamicListUsingWebsitePagedepth() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
	}

	@Test(testName = "Dynamic List Website Page in", description = "Dynamic List Website Page in")
	public void dynamicListUsingWebsitePagein() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);

	}

	@Test(testName = "Dynamic List Website Page out", description = "Dynamic List Website Page out")
	public void dynamicListUsingWebsitePageout() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);

	}

	@Test(testName = "Dynamic List Website Page views", description = "Dynamic List Website Page views")
	public void dynamicListUsingWebsitePageviews() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);

	}

	@Test(testName = "Dynamic List Website Referral Source", description = "Dynamic List Website Referral Source")
	public void dynamicListUsingWebsiteReferralSource() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);

	}

	@Test(testName = "Dynamic List Website Returning Visitors", description = "Dynamic List Website Returning Visitors")
	public void dynamicListUsingWebsiteReturningVisitors() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);

	}

	@Test(testName = "Dynamic List Website Session Duration", description = "Dynamic List Website Session Duration")
	public void dynamicListUsingWebsiteSessionDuration() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);

	}

	@Test(testName = "Dynamic List Website SignUp", description = "Dynamic List Website SignUp")
	public void dynamicListUsingWebsiteSignUp() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);

	}

	@Test(testName = "Dynamic List Website Site Clicks", description = "Dynamic List Website Site Clicks")
	public void dynamicListUsingWebsiteSiteClicks() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);

	}

	@Test(testName = "Dynamic List Website Time spent on page", description = "Dynamic List Website Time spent on page")
	public void dynamicListUsingWebsiteTimeSpentOnPage() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);

	}

	@Test(testName = "Dynamic List Website Traffic Source", description = "Dynamic List Website Traffic Source")
	public void dynamicListUsingWebsiteTrafficSource() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);

	}

	@Test(testName = "Dynamic List website User type", description = "Dynamic List website User type")
	public void dynamicListUsingWebsiteUserType() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);

	}

	@Test(testName = "DynamicList Website User Visits Specific Page", description = "DynamicList Website User Visits Specific Page")
	public void dynamicListUsingWebsiteWhenUserVisitsSpecificPage() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleTypeValue(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);

	}

	@Test(testName = "Dynamic list page verification", description = "Dynamic list page verification")
	public void dynamicListPageVerification() throws InterruptedException
	{

		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		dynamic.listingPageVerify();
	}

	@Test(testName = "Dynamic list RFA three approver", description = "Dynamic list RFA three approver")
	public void dynamicListRFAthreeapprover() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1);
		dynamic.rfaAddIcon();
		dynamic.secondDynamicapprover(dynamic.audience_approver2);
		dynamic.rfaAddIcon();
		dynamic.thirdDynamicapprover(dynamic.audience_approver3);
		dynamic.clickCreateAndSaveTrigger();
		dynamic.logout();
		dynamic.webURLlaunch();
		dynamic.target_Dynamic_approver1_Webmail_login();
		String rfalink = dynamic.getDynamicListRFAApprovalMailLink(EnterDynamiclistName);
		dynamic.webMailDelete();
		dynamic.openLoginPage().target_Dynamic_approver1_login();
		dynamic.selectbusinessunit();
		BaseTest.getWebDriver().get(EnterDynamiclistName);
		dynamic.clickTargetDynamicRFAApproveBtn();
	}

	@Test(testName = "Dynamic lsit executed comunication", description = "Dynamic lsit executed comunication")
	public void communicationExecuted() throws InterruptedException
	{

		int startDate = 0;
		int endDate = 3;
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		PreCommunicationAnalyticsPage precomm = getPageFactory().preCommunicationAnalyticsPage();
		CommunicationEmailChannelPage comm = getPageFactory().communicationEmailChannelPage();
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		comm.ETdynamicList = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);		
		dynamic.firstDynamicApprover(PageBase.audience_approver1).clickCreateAndSaveTrigger(comm.ETdynamicList);
		dynamic.logout();
		String pwind1 = comm.parentWinHandle();
		comm.javaScriptopenNewWindow();
		comm.switchWindow();
		dynamic.webURLlaunch();
		dynamic.teamWebmailLogin(System.getProperty("Target_Dynamic_approver1_webmail_Uname"), System.getProperty("Target_Dynamic_approver1_webmail_pswrd"));
		String rfalink = dynamic.getDynamicListRFAApprovalMailLink(comm.ETdynamicList);
		dynamic.teamWebmailLogout();
		dynamic.openLoginPage().target_Dynamic_approver1_login();
		dynamic.selectbusinessunit();
		BaseTest.getWebDriver().get(rfalink);
		dynamic.clickTargetDynamicRFAApproveBtn();
		dynamic.logout();
		comm.login(comm.dPropertyLoginUserName(), comm.dPropertyLoginPswrd());
		comm.selectbusinessunit();
		comm.clickCreateCommunicationfromMenu();
		comm.eventTriggComm(startDate, endDate);
		comm.channelType1().analyticOption2();
		comm.clickFrequency("Daily");
		comm.getTimeForDaily("1");
		comm.clickNext();
		BaseTest.takeScreenshot();
		comm.createSmarturl();
		comm.javaScriptScrolltoTop();
		dynamic.enternewsenderid();
		comm.enterEmailsubwithPersonalization();
		comm.clickImport().selectZipUsingKeys();
		comm.emailunsubscribeselect();
		comm.emailFooter();
		comm.javaScriptScrollDown();
		comm.saveAuthoringPage();
		comm.pageLoaderLogo();
		dynamic.clickDynamiclistlinkfromMenu();
		dynamic.searchDynamicList(comm.ETdynamicList);
		dynamic.executedCommunication(comm.ETdynamicList);
	}

	@Test(testName = "Dynamic list using Mobile app", description = "Dynamic list using mobile app")
	public void dynamicMobileApp() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.triggerMobApp(BaseTest.getData().TriggerTypeNew);
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);

	}

	@Test(testName = "Dynamic list using target list", description = "Dynamic list using target list")
	public void dynamicUsingTargetList() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);

	}

	@Test(testName = "Dynamic list using Audience base", description = "Dynamic list using Audience base")
	public void dynamicUsingAudienceBase() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);

	}

	@Test(testName = "Dynamic list Date filter", description = "Dynamic list Date filter")
	public void dynamicDateFilter() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		dynamic.filterDynamicListTimePeriod();

	}

	@Test(testName = "Dynamic list Grid and List view validation", description = "Dynamic list Grid and List view validation")

	public void dynamicGridViewValidation() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		List<Map<String, String>> validateGridView = dynamic.validateGridView();
		List<Map<String, String>> validateListView = dynamic.validateListView();
		dynamic.writeLog(validateGridView.equals(validateListView), "Grid view and List view data is same as expected.", "Grid view and List view data is not same as expected.");
	}
    
	@Test(testName = "Dynamic list  any type", description = "Dynamic list Any type")
	public void dynamicAnyType() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();

		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		dynamic.filterDynamicListTimePeriod();

	}

	@Test(testName = "Dynamic List Website Browser", description = "Dynamic List Website Browser")
	public void dynamicListUsingWebsiteBrowser() throws InterruptedException
	{
		AudiencePage_Dynamiclist dynamic = getPageFactory().Audiencepagedynamiclist();
		dynamic.login(dynamic.dPropertyLoginUserName(), dynamic.dPropertyLoginPswrd());
		dynamic.selectbusinessunit();
		dynamic.clickDynamiclistlinkfromMenu();
		String EnterDynamiclistName = dynamic.addNewDynamicListNameandTriggerType();
		dynamic.selectTriggerValues();
		dynamic.triggerSourceRuleType(BaseTest.getData().RuleType, BaseTest.getData().Type, BaseTest.getData().Value);
		dynamic.firstDynamicApprover(dynamic.audience_approver1).clickCreateAndSaveTrigger();
		dynamic.searchDynamicList(EnterDynamiclistName);

	}
}
