package regression_Audience;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Page;

import pages.AudiencePage_Targetlist;
import pages.PreferencesPage;
import repository.AudienceRepository;
import repository.DashboardRepository;
import repository.ObjectRepository;
import utility.BaseTest;
import utility.DataInputProvider;
import utility.ExtentManager;
import utility.PageBase;

public class TargetListScenarios extends BaseTest
{
	@Test(description = "Target list creation")
	public void targetListCreateAndValidate()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
		String AttributeType = BaseTest.getData().AttributeType;
		String SelectAttribute = BaseTest.getData().SelectAttribute;
		String FilterListBox = BaseTest.getData().FilterListBox;
		String AttributeValueNew = BaseTest.getData().AttributeValueNew;
		String AttributeValueOld = BaseTest.getData().AttributeValueOld;

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());

		trgt.selectbusinessunit();
		trgt.getTotalAudienceCountFromMDM();
		trgt.clickTargetlistfromMenu().clickNewListSegment();
		trgt.enterTargetListName();
		trgt.searchAndSelectAttribute(SelectAttribute);
		if (!trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueNew))
		{
			trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueOld);
		}
		trgt.clickHereToGetCount(SelectAttribute);
		trgt.targetSegmentationCountCheck();
		trgt.createTargetList();
		trgt.saveTargetList();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList(trgt.targetListName);
		DataInputProvider.writeUpdatedValueInSheet(8, 1, "AudienceRegression", "BaseData", trgt.targetListName);
	}

	@Test(description = "Target list inclusion, exclusion and database validation")
	public void TL_ParentAttribute_InclusionTwoandExclusion() throws IOException
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
		String AttributeType = BaseTest.getData().AttributeType;
		String SelectAttribute = BaseTest.getData().SelectAttribute;
		String FilterListBox = BaseTest.getData().FilterListBox;
		String AttributeValueNew = BaseTest.getData().AttributeValueNew;
		String AttributeValueOld = BaseTest.getData().AttributeValueOld;
		int filterNumber = 0;

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());

		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu().clickNewListSegment();
		trgt.enterTargetListName();
		trgt.searchAndSelectAttribute(SelectAttribute);
		trgt.selectListAttributesValues(AttributeType, filterNumber, SelectAttribute, FilterListBox, AttributeValueNew, AttributeValueOld);
		trgt.clickHereToGetCount(SelectAttribute);
		trgt.addInclusion();
		String SelectAttributeInc = BaseTest.getData().SelectAttribute1;
		String AttributeValueNewInc = BaseTest.getData().TargetListNew;
		trgt.searchAndSelectAttribute(SelectAttributeInc);
		filterNumber = 1;
		trgt.selectListAttributesValues(AttributeType, filterNumber, SelectAttributeInc, FilterListBox, AttributeValueNewInc);
		trgt.clickHereToGetCount(SelectAttributeInc);
		trgt.addExclusion();
		String SelectAttributeExc = BaseTest.getData().SelectAttribute2;
		String AttributeValueNewExc = BaseTest.getData().TargetListOld;
		trgt.searchAndSelectAttribute(SelectAttributeExc);
		filterNumber = 2;
		trgt.selectListAttributesValues(AttributeType, filterNumber, SelectAttributeExc, FilterListBox, AttributeValueNewExc);
		trgt.clickHereToGetCount(SelectAttributeExc);
		trgt.createTargetList();
		trgt.saveTargetList();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList(trgt.targetListName);
	}

	@Test(description = "Target list and datacatalogue attribute validate")
	public void targetListAndDataCatalogueAttributeValidate()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
		PreferencesPage pref = getPageFactory().preferencesPage();

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu().clickNewListSegment();
		trgt.enterTargetListName();
		Map<String, List<String>> trgtAttributes = trgt.getTrgtAttributes();
		System.out.println(trgtAttributes);
		trgt.clickPreferencePagefromMenu();
		pref.dataCatalogueClick();
		pref.attributeCheck(trgtAttributes);
	}

	@Test(description = "Target list One Approve RFA All")
	public void targetListOneApproveRfaAll()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
		String AttributeType = BaseTest.getData().AttributeType;
		String SelectAttribute = BaseTest.getData().SelectAttribute;
		String FilterListBox = BaseTest.getData().FilterListBox;
		String AttributeValueNew = BaseTest.getData().AttributeValueNew;
		String AttributeValueOld = BaseTest.getData().AttributeValueOld;
		String approver = System.getProperty("teamKeyAcctWebmailUsername");

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());

		trgt.selectbusinessunit();
		trgt.getTotalAudienceCountFromMDM();
		trgt.clickTargetlistfromMenu().clickNewListSegment();
		trgt.enterTargetListName();
		trgt.searchAndSelectAttribute(SelectAttribute);
		if (!trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueNew))
		{
			trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueOld);
		}
		trgt.clickHereToGetCount(SelectAttribute);
		trgt.targetSegmentationCountCheck();
		trgt.clickRfaCheckbox();
		trgt.selectTargetListRfa(1, approver);
		trgt.createTargetList().saveTargetList();
		trgt.logout();
		trgt.openLoginPage().loginWithoutPopup(approver, trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		String link = trgt.getRfaTargetListLink(approver);
		trgt.approveRfa(link);
		trgt.logout();
		trgt.loginWithoutPopup(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList(trgt.targetListName);
	}

	@Test(description = "Target list One Reject RFA All")
	public void targetListOneRejectRfaAll()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
		String AttributeType = BaseTest.getData().AttributeType;
		String SelectAttribute = BaseTest.getData().SelectAttribute;
		String FilterListBox = BaseTest.getData().FilterListBox;
		String AttributeValueNew = BaseTest.getData().AttributeValueNew;
		String AttributeValueOld = BaseTest.getData().AttributeValueOld;
		String approver = System.getProperty("Target_Dynamic_approver1_webmail_Uname");
		int filterNumber = 0;
		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());

		trgt.selectbusinessunit();
		trgt.getTotalAudienceCountFromMDM();
		trgt.clickTargetlistfromMenu().clickNewListSegment();
		trgt.enterTargetListName();
		trgt.searchAndSelectAttribute(SelectAttribute);
		trgt.selectListAttributesValues(AttributeType, filterNumber, SelectAttribute, FilterListBox, AttributeValueNew, AttributeValueOld);
		trgt.clickHereToGetCount(SelectAttribute);
		trgt.targetSegmentationCountCheck();
		trgt.clickRfaCheckbox();
		trgt.selectTargetListRfa(1, approver);
		trgt.createTargetList().saveTargetList();
		trgt.logout();
		trgt.openLoginPage().loginWithoutPopup(approver, trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		String link = trgt.getRfaTargetListLink(approver);
		trgt.rejectRfa(link);
		trgt.logout();
		trgt.loginWithoutPopup(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList(trgt.targetListName);
	}

	@Test(description = "Target list two approver approve RFA All")
	public void targetListTwoApproverApproveRfaAll()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
		String AttributeType = BaseTest.getData().AttributeType;
		String SelectAttribute = BaseTest.getData().SelectAttribute;
		String FilterListBox = BaseTest.getData().FilterListBox;
		String AttributeValueNew = BaseTest.getData().AttributeValueNew;
		String AttributeValueOld = BaseTest.getData().AttributeValueOld;
		String approver1 = System.getProperty("Target_Dynamic_approver1_webmail_Uname");
		String approver2 = System.getProperty("Target_Dynamic_approver2_webmail_Uname");;
		int filterNumber = 0;
		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());

		trgt.selectbusinessunit();
		trgt.getTotalAudienceCountFromMDM();
		trgt.clickTargetlistfromMenu().clickNewListSegment();
		trgt.enterTargetListName();
		trgt.searchAndSelectAttribute(SelectAttribute);
		trgt.selectListAttributesValues(AttributeType, filterNumber, SelectAttribute, FilterListBox, AttributeValueNew, AttributeValueOld);
		trgt.clickHereToGetCount(SelectAttribute);
		trgt.targetSegmentationCountCheck();
		trgt.clickRfaCheckbox();
		trgt.selectTargetListRfa(1, approver1);
		trgt.selectTargetListRfa(2, approver2);
		trgt.createTargetList().saveTargetList();
		trgt.logout();
		trgt.openLoginPage().loginWithoutPopup(approver1, trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		String approverLink1 = trgt.getRfaTargetListLink(approver1);
		trgt.approveRfa(approverLink1);
		trgt.logout();
		trgt.openLoginPage().loginWithoutPopup(approver1, trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		String approverLink2 = trgt.getRfaTargetListLink(approver2);
		trgt.approveRfa(approverLink2);
		trgt.logout();
		trgt.loginWithoutPopup(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList(trgt.targetListName);
	}

	@Test(description = "Target list three approver approve RFA All")
	public void targetListThreeApproverApproveRfaAll()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
		String AttributeType = BaseTest.getData().AttributeType;
		String SelectAttribute = BaseTest.getData().SelectAttribute;
		String FilterListBox = BaseTest.getData().FilterListBox;
		String AttributeValueNew = BaseTest.getData().AttributeValueNew;
		String AttributeValueOld = BaseTest.getData().AttributeValueOld;
		String approver1 = "vbnk76@resulticksmail.com";
		String approver2 = "vbnk77@resulticksmail.com";
		String approver3 = "vbnk78@resulticksmail.com";

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());

		trgt.selectbusinessunit();
		trgt.getTotalAudienceCountFromMDM();
		trgt.clickTargetlistfromMenu().clickNewListSegment();
		trgt.enterTargetListName();
		trgt.searchAndSelectAttribute(SelectAttribute);
		if (!trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueNew))
		{
			trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueOld);
		}
		trgt.clickHereToGetCount(SelectAttribute);
		trgt.targetSegmentationCountCheck();
		trgt.clickRfaCheckbox();
		trgt.selectTargetListRfa(1, approver1);
		trgt.selectTargetListRfa(2, approver2);
		trgt.selectTargetListRfa(3, approver3);
		trgt.createTargetList().saveTargetList();
		trgt.logout();
		trgt.openLoginPage().login(approver1, "Itkt@1234");
//		trgt.selectbusinessunit();
		String approverLink1 = trgt.getRfaTargetListLink(approver1);
		trgt.approveRfa(approverLink1);
		trgt.logout();
		trgt.openLoginPage().login(approver2, "Itkt@1234");
//		trgt.selectbusinessunit();
		String approverLink2 = trgt.getRfaTargetListLink(approver2);
		trgt.approveRfa(approverLink2);
		trgt.logout();
		trgt.openLoginPage().login(approver3, "Itkt@1234");
//		trgt.selectbusinessunit();
		String approverLink3 = trgt.getRfaTargetListLink(approver3);
		trgt.approveRfa(approverLink3);
		trgt.logout();
		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList(trgt.targetListName);
	}

	@Test(description = "Target list three approver RFA All Follow Hierarchy")
	public void targetListThreeApproverRfaAllFollowHierarchy()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
		String AttributeType = BaseTest.getData().AttributeType;
		String SelectAttribute = BaseTest.getData().SelectAttribute;
		String FilterListBox = BaseTest.getData().FilterListBox;
		String AttributeValueNew = BaseTest.getData().AttributeValueNew;
		String AttributeValueOld = BaseTest.getData().AttributeValueOld;
		String approver1 = "vbnk76@resulticksmail.com";
		String approver2 = "vbnk77@resulticksmail.com";
		String approver3 = "vbnk78@resulticksmail.com";

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());

		trgt.selectbusinessunit();
		trgt.getTotalAudienceCountFromMDM();
		trgt.clickTargetlistfromMenu().clickNewListSegment();
		trgt.enterTargetListName();
		trgt.searchAndSelectAttribute(SelectAttribute);
		if (!trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueNew))
		{
			trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueOld);
		}
		trgt.clickHereToGetCount(SelectAttribute);
		trgt.targetSegmentationCountCheck();
		trgt.clickRfaCheckbox();
		trgt.selectTargetListRfa(1, approver1);
		trgt.selectTargetListRfa(2, approver2);
		trgt.selectTargetListRfa(3, approver3);
		trgt.requestApprovalSettingAll("all", "on");
		trgt.createTargetList().saveTargetList();
		trgt.logout();
		trgt.openLoginPage().login(approver1, "Itkt@1234");
//		trgt.selectbusinessunit();
		String approverLink1 = trgt.getRfaTargetListLink(approver1);
		trgt.approveRfa(approverLink1);
		trgt.logout();
		trgt.openLoginPage().login(approver2, "Itkt@1234");
//		trgt.selectbusinessunit();
		String approverLink2 = trgt.getRfaTargetListLink(approver2);
		trgt.approveRfa(approverLink2);
		trgt.logout();
		trgt.openLoginPage().login(approver3, "Itkt@1234");
//		trgt.selectbusinessunit();
		String approverLink3 = trgt.getRfaTargetListLink(approver3);
		trgt.approveRfa(approverLink3);
		trgt.logout();
		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList(trgt.targetListName);
	}

	@Test(description = "Target list two approve RFA get approve Any One")
	public void targetListTwoApproveRfaGetApproveAnyOne()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
		String AttributeType = BaseTest.getData().AttributeType;
		String SelectAttribute = BaseTest.getData().SelectAttribute;
		String FilterListBox = BaseTest.getData().FilterListBox;
		String AttributeValueNew = BaseTest.getData().AttributeValueNew;
		String AttributeValueOld = BaseTest.getData().AttributeValueOld;
		String approver1 = "vbnk76@resulticksmail.com";
		String approver2 = "vbnk77@resulticksmail.com";

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());

		trgt.selectbusinessunit();
		trgt.getTotalAudienceCountFromMDM();
		trgt.clickTargetlistfromMenu().clickNewListSegment();
		trgt.enterTargetListName();
		trgt.searchAndSelectAttribute(SelectAttribute);
		if (!trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueNew))
		{
			trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueOld);
		}
		trgt.clickHereToGetCount(SelectAttribute);
		trgt.targetSegmentationCountCheck();
		trgt.clickRfaCheckbox();
		trgt.selectTargetListRfa(1, approver1);
		trgt.selectTargetListRfa(2, approver2);
		trgt.requestApprovalSettingAny("any", 1);
		trgt.createTargetList().saveTargetList();
		trgt.logout();
		trgt.openLoginPage().login(approver1, "Itkt@1234");
//		trgt.selectbusinessunit();
		String approverLink1 = trgt.getRfaTargetListLink(approver1);
		trgt.approveRfa(approverLink1);
		trgt.logout();
		trgt.openLoginPage().login(approver2, "Itkt@1234");
//		trgt.selectbusinessunit();
		String approverLink2 = trgt.getRfaTargetListLink(approver2);
		trgt.rejectRfa(approverLink2);
		trgt.logout();
		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList(trgt.targetListName);
	}

	@Test(description = "Target list three approve RFA get approve Any One")
	public void targetListThreeApproveRfagetApproveAnyOne()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
		String AttributeType = BaseTest.getData().AttributeType;
		String SelectAttribute = BaseTest.getData().SelectAttribute;
		String FilterListBox = BaseTest.getData().FilterListBox;
		String AttributeValueNew = BaseTest.getData().AttributeValueNew;
		String AttributeValueOld = BaseTest.getData().AttributeValueOld;
		String approver1 = "vbnk76@resulticksmail.com";
		String approver2 = "vbnk77@resulticksmail.com";
		String approver3 = "vbnk78@resulticksmail.com";

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());

		trgt.selectbusinessunit();
		trgt.getTotalAudienceCountFromMDM();
		trgt.clickTargetlistfromMenu().clickNewListSegment();
		trgt.enterTargetListName();
		trgt.searchAndSelectAttribute(SelectAttribute);
		if (!trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueNew))
		{
			trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueOld);
		}
		trgt.clickHereToGetCount(SelectAttribute);
		trgt.targetSegmentationCountCheck();
		trgt.clickRfaCheckbox();
		trgt.selectTargetListRfa(1, approver1);
		trgt.selectTargetListRfa(2, approver2);
		trgt.selectTargetListRfa(3, approver3);
		trgt.requestApprovalSettingAny("any", 1);
		trgt.createTargetList().saveTargetList();
		trgt.logout();
		trgt.openLoginPage().login(approver1, "Itkt@1234");
//		trgt.selectbusinessunit();
		String approverLink1 = trgt.getRfaTargetListLink(approver1);
		trgt.approveRfa(approverLink1);
		trgt.logout();
		trgt.openLoginPage().login(approver2, "Itkt@1234");
//		trgt.selectbusinessunit();
		String approverLink2 = trgt.getRfaTargetListLink(approver2);
		trgt.rejectRfa(approverLink2);
		trgt.logout();
		trgt.openLoginPage().login(approver3, "Itkt@1234");
//		trgt.selectbusinessunit();
		String approverLink3 = trgt.getRfaTargetListLink(approver3);
		trgt.rejectRfa(approverLink3);
		trgt.logout();
		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList(trgt.targetListName);
	}

	@Test(description = "Target list three approve RFA get approve Any Two")
	public void targetListThreeApproveRfagetApproveAnyTwo()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
		String AttributeType = BaseTest.getData().AttributeType;
		String SelectAttribute = BaseTest.getData().SelectAttribute;
		String FilterListBox = BaseTest.getData().FilterListBox;
		String AttributeValueNew = BaseTest.getData().AttributeValueNew;
		String AttributeValueOld = BaseTest.getData().AttributeValueOld;
		String approver1 = "vbnk76@resulticksmail.com";
		String approver2 = "vbnk77@resulticksmail.com";
		String approver3 = "vbnk78@resulticksmail.com";

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());

		trgt.selectbusinessunit();
		trgt.getTotalAudienceCountFromMDM();
		trgt.clickTargetlistfromMenu().clickNewListSegment();
		trgt.enterTargetListName();
		trgt.searchAndSelectAttribute(SelectAttribute);
		if (!trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueNew))
		{
			trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueOld);
		}
		trgt.clickHereToGetCount(SelectAttribute);
		trgt.targetSegmentationCountCheck();
		trgt.clickRfaCheckbox();
		trgt.selectTargetListRfa(1, approver1);
		trgt.selectTargetListRfa(2, approver2);
		trgt.selectTargetListRfa(3, approver3);
		trgt.requestApprovalSettingAny("any", 2);
		trgt.createTargetList().saveTargetList();
		trgt.logout();
		trgt.openLoginPage().login(approver1, "Itkt@1234");
//		trgt.selectbusinessunit();
		String approverLink1 = trgt.getRfaTargetListLink(approver1);
		trgt.approveRfa(approverLink1);
		trgt.logout();
		trgt.openLoginPage().login(approver2, "Itkt@1234");
//		trgt.selectbusinessunit();
		String approverLink2 = trgt.getRfaTargetListLink(approver2);
		trgt.approveRfa(approverLink2);
		trgt.logout();
		trgt.openLoginPage().login(approver3, "Itkt@1234");
//		trgt.selectbusinessunit();
		String approverLink3 = trgt.getRfaTargetListLink(approver3);
		trgt.rejectRfa(approverLink3);
		trgt.logout();
		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList(trgt.targetListName);
	}

	@Test(description = "Target list three approve RFA get reject Any Two")
	public void targetListThreeApproveRfagetRejectAnyTwo()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
		String AttributeType = BaseTest.getData().AttributeType;
		String SelectAttribute = BaseTest.getData().SelectAttribute;
		String FilterListBox = BaseTest.getData().FilterListBox;
		String AttributeValueNew = BaseTest.getData().AttributeValueNew;
		String AttributeValueOld = BaseTest.getData().AttributeValueOld;
		String approver1 = "vbnk76@resulticksmail.com";
		String approver2 = "vbnk77@resulticksmail.com";
		String approver3 = "vbnk78@resulticksmail.com";

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());

		trgt.selectbusinessunit();
		trgt.getTotalAudienceCountFromMDM();
		trgt.clickTargetlistfromMenu().clickNewListSegment();
		trgt.enterTargetListName();
		trgt.searchAndSelectAttribute(SelectAttribute);
		if (!trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueNew))
		{
			trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueOld);
		}
		trgt.clickHereToGetCount(SelectAttribute);
		trgt.targetSegmentationCountCheck();
		trgt.clickRfaCheckbox();
		trgt.selectTargetListRfa(1, approver1);
		trgt.selectTargetListRfa(2, approver2);
		trgt.selectTargetListRfa(3, approver3);
		trgt.requestApprovalSettingAny("any", 2);
		trgt.createTargetList().saveTargetList();
		trgt.logout();
		trgt.openLoginPage().login(approver1, "Itkt@1234");
//		trgt.selectbusinessunit();
		String approverLink1 = trgt.getRfaTargetListLink(approver1);
		trgt.rejectRfa(approverLink1);
		trgt.logout();
		trgt.openLoginPage().login(approver2, "Itkt@1234");
//		trgt.selectbusinessunit();
		String approverLink2 = trgt.getRfaTargetListLink(approver2);
		trgt.approveRfa(approverLink2);
		trgt.logout();
		trgt.openLoginPage().login(approver3, "Itkt@1234");
//		trgt.selectbusinessunit();
		String approverLink3 = trgt.getRfaTargetListLink(approver3);
		trgt.rejectRfa(approverLink3);
		trgt.logout();
		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList(trgt.targetListName);
	}

	@Test(description = "Target list recalculate now/later validate")
	public void targetListRecalculateLater_Now_later()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
		String AttributeType = BaseTest.getData().AttributeType;
		String SelectAttribute = BaseTest.getData().SelectAttribute;
		String FilterListBox = BaseTest.getData().FilterListBox;
		String AttributeValueNew = BaseTest.getData().AttributeValueNew;
		String AttributeValueOld = BaseTest.getData().AttributeValueOld;

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());

		trgt.selectbusinessunit();
		trgt.getTotalAudienceCountFromMDM();
		trgt.clickTargetlistfromMenu().clickNewListSegment();
		trgt.enterTargetListName();
		trgt.searchAndSelectAttribute(SelectAttribute);
		if (!trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueNew))
		{
			trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueOld);
		}
		int totalCount = trgt.clickHereToGetCount(SelectAttribute);
		trgt.removeFilterAttributes(SelectAttribute, AttributeValueNew);
		if (!trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueNew))
		{
			trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueOld);
		}
		trgt.createTargetList();
		trgt.recalculateNow();
		int recalculateNowCount = Integer.parseInt(trgt.getStrText(AudienceRepository.audience_target_potentialaudienceInclusiongroup1).replace(",", ""));
		trgt.writeLog(totalCount == recalculateNowCount, "Recalculate count is present as expected -> '<b>" + recalculateNowCount + "</b>'", "Recalculate count is not-present as expected '<b>" + recalculateNowCount + "</b>'");
		trgt.removeFilterAttributes(SelectAttribute, AttributeValueNew);
		if (!trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueNew))
		{
			trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueOld);
		}
		trgt.createTargetList();
		trgt.recalculateLater();
		trgt.saveTargetList();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod();
		trgt.searchTargetList(trgt.targetListName);
		if (trgt.waitForListExtraction())
		{
			String SegmentationCount = trgt.trgtListDetails.get("SegmentationCount").replaceAll("Seg. audience: ", "").trim();
			trgt.writeLog(SegmentationCount.equals(String.valueOf(totalCount)), "Segmentation Count is present as expected count <b>" + totalCount + "</b>", "Segmentation Count is not present as expected count <b>" + totalCount + "</b>");
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "List extraction is in progress.");
			BaseTest.takeScreenshot();
		}
	}

	@Test(description = "Target List Creation Negative Scenario")
	public void TargetListCreationNegativeScenario()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
		String AttributeType = BaseTest.getData().AttributeType, SelectAttribute = BaseTest.getData().SelectAttribute;
		String FilterListBox = BaseTest.getData().FilterListBox, AttributeValueNew = BaseTest.getData().AttributeValueNew;
		String AttributeValueOld = BaseTest.getData().AttributeValueOld;

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());

		trgt.selectbusinessunit();
		trgt.getTotalAudienceCountFromMDM();
		trgt.clickTargetlistfromMenu().clickNewListSegment();

		// Empty ListName
		trgt.enterValue(AudienceRepository.audience_Target_listName, "");
		trgt.clickTab();
		trgt.pageLoaderLogo();
		String emptyNameErrMsg = trgt.getStrText(AudienceRepository.audience_Target_listNameplaceholder);
		trgt.writeLog(emptyNameErrMsg.equals("Enter list name"), "After entering an empty listname validation message '" + emptyNameErrMsg + "' shown as expected.",
				"After entering an empty listname validation message '" + emptyNameErrMsg + "' not - shown as expected.");

		// Maximum limit ListName
		trgt.enterValue(AudienceRepository.audience_Target_listName, System.getProperty("Max_Character"));
		trgt.clickTab();
		int listNameLength = trgt.getTextBoxVal(AudienceRepository.audience_Target_listName, "value").length();
		trgt.writeLog(listNameLength == 75, "After entering an Max.char listname count '" + listNameLength + "' shown as expected.", "After entering an Max.char listname count '" + listNameLength + "' not - shown as expected.");

		// ListName already exist
//		trgt.clearField(AudienceRepository.audience_Target_listName);
//		trgt.enterValue(AudienceRepository.audience_Target_listName, "Test list check");
//		trgt.clickTab();
//		trgt.pageLoaderLogo();
//		String alreadyExistErrMsg = trgt.getStrText(AudienceRepository.audience_Target_listNameplaceholder);
//		trgt.writeLog(alreadyExistErrMsg.equals("List name already exists"), "After entering an already existing listname validation message '" + alreadyExistErrMsg + "' shown as expected.",
//				"After entering an already existing listname validation message '" + alreadyExistErrMsg + "' not - shown as expected.");

		// Special character ListName
		trgt.clearField(AudienceRepository.audience_Target_listName);
		trgt.enterValue(AudienceRepository.audience_Target_listName, System.getProperty("SpecialCharacter"));
		trgt.clickTab();
		trgt.pageLoaderLogo();
		String listNameChar = trgt.getTextBoxVal(AudienceRepository.audience_Target_listName, "value");
		trgt.writeLog(listNameChar.equals("_--_-"), "After entering an specialCharacter listname text '" + listNameChar + "' shown as expected.", "After entering an specialCharacter listname text '" + listNameChar + "' not - shown as expected.");

		// Min character ListName
		trgt.clearField(AudienceRepository.audience_Target_listName);
		trgt.enterValue(AudienceRepository.audience_Target_listName, "v");
		trgt.clickTab();
		trgt.pageLoaderLogo();
		String minCharErrMsg = trgt.getStrText(AudienceRepository.audience_Target_listNameplaceholder);
		trgt.writeLog(minCharErrMsg.equals("Min. 3 characters"), "After entering an min listname validation message '" + minCharErrMsg + "' shown as expected.",
				"After entering an min listname validation message '" + minCharErrMsg + "' not - shown as expected.");

		// enter listname
		trgt.clearField(AudienceRepository.audience_Target_listName);
		trgt.enterTargetListName();

		// Validate no data available search attribute field
		PageBase.threadSleep(ObjectRepository.wait5sec);
		trgt.explicitwaitforclick(PageBase.autolocator(AudienceRepository.audience_target_clickSearchattribute), 50);
		trgt.clickElement(AudienceRepository.audience_target_clickSearchattribute);
		PageBase.threadSleep(ObjectRepository.wait1sec);
		trgt.enterValue(AudienceRepository.audience_target_enterSearchattribute, "GHJJFKL");
		String attributesNoDataAvailable = trgt.getStrText(AudienceRepository.audiecne_target_attributesnodataavailable);
		trgt.writeLog(attributesNoDataAvailable.equals("No data available"), "After search the not avaialble attribute text shown as '" + attributesNoDataAvailable + "' expected",
				"After search the not avaialble attribute text not shown as '" + attributesNoDataAvailable + "' expected");

		// validate search attribute field Case Sensitivity
		trgt.clickElement(AudienceRepository.audience_target_clickSearchClose);
		trgt.enterValue(AudienceRepository.audience_target_enterSearchattribute, "IMPORT DESCRIPTION");
		String activeAttribute = trgt.getStrText(AudienceRepository.audience_target_activeAttributeList).replaceAll("\n+", "").replaceAll("\\+", "");
		trgt.writeLog(activeAttribute.equalsIgnoreCase("import description"), "Search attribute field is accept case sensitive as expected.", "Search attribute field is not accept a case sensitive.");
		trgt.clickElement(AudienceRepository.audience_target_clickSearchClose);
		trgt.clickElement(AudienceRepository.audience_target_clickSearchattribute);

		// Duplicate the attribute
		trgt.searchAndSelectAttribute(SelectAttribute);
		if (!trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueNew))
		{
			trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueOld);
		}
		int duplicatedAttributeCount = 1;
		trgt.selectDuplicateAttribute(SelectAttribute, duplicatedAttributeCount, AttributeValueNew);

		// Remove duplicate attribute
		trgt.removeDuplicateAttribute(SelectAttribute, duplicatedAttributeCount + 1);

		// Rfa Negative scenarios
		trgt.clickRfaCheckbox();
	}

	@Test(description = "Target List - Duplicate")
	public void duplicateTargetList()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();

		String targetListNew = BaseTest.getData().TargetListNew, dupTargetListName = "Duptrgt_" + trgt.addTimeToName().replaceAll("_", "");

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());

		trgt.selectbusinessunit();
		trgt.getTotalAudienceCountFromMDM();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList(targetListNew);

		trgt.duplicateTargetlist(targetListNew, dupTargetListName);
		trgt.searchTargetList(dupTargetListName);
		DataInputProvider.writeUpdatedValueInSheet(7, 1, "AudienceRegression", "BaseData", dupTargetListName);
	}

	@Test(description = "Target list edit and verify targetList")
	public void editAndVerifyTargetList()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();

		String AttributeType = BaseTest.getData().AttributeType;
		String SelectAttribute = BaseTest.getData().SelectAttribute;
		String FilterListBox = BaseTest.getData().FilterListBox;
		String AttributeValueNew = BaseTest.getData().AttributeValueNew;
		String AttributeValueOld = BaseTest.getData().AttributeValueOld;

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.getTotalAudienceCountFromMDM();
		trgt.clickTargetlistfromMenu().clickNewListSegment();
		trgt.enterTargetListName();
		trgt.searchAndSelectAttribute(SelectAttribute);
		if (!trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueNew))
		{
			trgt.selectTargetlistAttributeValues(AttributeType, 0, SelectAttribute, FilterListBox, AttributeValueOld);
		}
		trgt.clickHereToGetCount(SelectAttribute);
		trgt.targetSegmentationCountCheck();
		trgt.createTargetList();
		trgt.saveTargetList();
		trgt.clickTargetlistfromMenu();
		PageBase.threadSleep(ObjectRepository.wait60sec);
		PageBase.threadSleep(ObjectRepository.wait60sec);
		trgt.filterTargetListTimePeriod().searchTargetList(trgt.targetListName);
		String duplicateName = "edit_" + trgt.targetListName;
		trgt.editTargetList(trgt.targetListName);
		trgt.editTargetListName(trgt.targetListName);
		trgt.createTargetList().saveTargetList();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList(duplicateName);
		DataInputProvider.writeUpdatedValueInSheet(11, 1, "AudienceRegression", "BaseData", duplicateName);
	}

	@Test(testName = "", description = "Targetlist More Info Icon Validation")
	public void moreInfoIconValidate()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();

		String targetListNew = BaseTest.getData().TargetListNew;
		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod();
		Map<String, String> trgtListDetails = trgt.searchTargetList(targetListNew);
		String listName = (targetListNew.length() > 15) ? targetListNew.substring(0, 15) + "..." : targetListNew;
		trgt.checkTLEncodeValue(listName);
		trgt.clickAndValidateTLPreview(listName);
		trgt.clickMoreInfoIcon(listName);
		trgt.targetListMoreInfoValidation(trgtListDetails);
	}

	@Test(testName = "", description = "Advance Details Search")
	public void advanceDetailsSearch()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();

		String targetListNew = BaseTest.getData().TargetListNew;

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList(targetListNew);
		String listName = (targetListNew.length() > 15) ? targetListNew.substring(0, 15) + "..." : targetListNew;
		trgt.clickMoreInfoIcon(listName);
		trgt.clickAdvanceAnalytics();
		trgt.searchAdvanceAnalytics("City");
		if (!trgt.isElementPresent(AudienceRepository.audience_target_advanceanalyticsnodatafound))
		{
			List<Map<String, String>> tableValue = trgt.getAllTableValue();
			System.out.println(tableValue);
			trgt.writeLog(tableValue.toString().equals("[{City=Chennai, Count=11}, {City=Chennail, Count=1}, {City=Kolkata, Count=3}, {City=Madurai, Count=1}, {City=Mumbai, Count=5}]"), tableValue + " is present as expected.",
					tableValue + " is not-present as expected.");
			ExtentManager.customReport(tableValue);
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Table data shows 'No record found'.");
		}
	}

	// Due to issue Onhold this script
	@Test(testName = "", description = "Advance Details Download")
	public void advanceDetailsDownload()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();

		String targetListNew = BaseTest.getData().TargetListNew;

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList(targetListNew);
		String listName = (targetListNew.length() > 15) ? targetListNew.substring(0, 15) + "..." : targetListNew;
		trgt.clickMoreInfoIcon(listName);
		trgt.clickAdvanceAnalytics();
		trgt.searchAdvanceAnalytics("City");
		if (!trgt.isElementPresent(AudienceRepository.audience_target_advanceanalyticsnodatafound))
		{
			List<Map<String, String>> advanceDetailsTableCount = trgt.getAdvanceDetailsTableCount();
			trgt.clickAdvanceDetailsDownload();
			trgt.targetListDownloadCsvPopup("Email Id");
			trgt.downloadAndValidateAdvanceAnalyticsFromWebmail(advanceDetailsTableCount);
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Table data shows 'No record found'.");
		}
	}

	@Test(testName = "", description = "Sample Target List - Download")
	public void sampleTargetListDownload()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();

		String targetListNew = BaseTest.getData().TargetListNew;
		String[] attributes = "Name,Email,MobileNo,City".split(",");

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod();
		Map<String, String> trgtListDetails = trgt.searchTargetList(targetListNew);
		String listName = (targetListNew.length() > 15) ? targetListNew.substring(0, 15) + "..." : targetListNew;
		trgt.clickTargetListDownload(listName, "sample list");
		trgt.selectDownloadAttributes(attributes);
		trgt.targetListDownloadCsvPopup("Email Id");
		int audienceCount = Integer.parseInt(trgtListDetails.get("SegmentationCount").replaceAll("[^0-9]", ""));
		trgt.downloadAndValidateTargetListFromWebmail(audienceCount, targetListNew);
	}

	@Test(testName = "", description = "Target List Download Full Segment")
	public void downloadFullSegmentList()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();

		String targetListNew = BaseTest.getData().TargetListNew;
		String[] attributes = "Name,Email,MobileNo,City".split(",");

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod();
		Map<String, String> trgtListDetails = trgt.searchTargetList(targetListNew);
		String listName = (targetListNew.length() > 15) ? targetListNew.substring(0, 15) + "..." : targetListNew;
		trgt.clickTargetListDownload(listName, "full segment list");
		trgt.selectDownloadAttributes(attributes);
		trgt.targetListDownloadCsvPopup("Email Id");
		int audienceCount = Integer.parseInt(trgtListDetails.get("SegmentationCount").replaceAll("[^0-9]", ""));
		trgt.downloadAndValidateTargetListFromWebmail(audienceCount, targetListNew);
	}

	@Test(testName = "", description = "Target List Download Share")
	public void downloadTargetlistshare()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();

		String targetListNew = BaseTest.getData().TargetListNew;
		targetListNew = "TrgtRfaApprove9110142729";
		String[] attributes = "Name,Email,MobileNo,City".split(",");

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod();
		Map<String, String> trgtListDetails = trgt.searchTargetList(targetListNew);
		String listName = (targetListNew.length() > 15) ? targetListNew.substring(0, 15) + "..." : targetListNew;
		trgt.clickTargetListDownload(listName, "Share");
		trgt.selectDownloadAttributes(attributes);
		trgt.targetListDownloadCsvPopup("Email Id");
		int audienceCount = Integer.parseInt(trgtListDetails.get("SegmentationCount").replaceAll("[^0-9]", ""));
		trgt.downloadAndValidateTargetListFromWebmail(audienceCount, targetListNew);
	}

	@Test(testName = "", description = "Target list - control and target group")
	public void targetListControlAndTargetGroup()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();

		String targetListNew = BaseTest.getData().TargetListNew;

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList(targetListNew);
		String listName = (targetListNew.length() > 15) ? targetListNew.substring(0, 15) + "..." : targetListNew;
		Map<String, String> moreInfoDetails = trgt.getMoreInfoDetails(listName);
		trgt.clickCgTgIcon(listName);
		trgt.validateCGTGSlider("off");
		trgt.verifyCGTGValue(moreInfoDetails);
		trgt.slideCGTGValue();
		Map<String, String> moreInfoDetailsAfterSlide = trgt.getMoreInfoDetails(listName);
		trgt.clickCgTgIcon(listName);
		trgt.validateCGTGSlider("on");
		trgt.verifyCGTGValue(moreInfoDetailsAfterSlide);
		trgt.clickCgTgToogleButton();
	}

	@Test(testName = "", description = "Match output list")
	public void createMatchOutputList()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();

		String targetListNew = BaseTest.getData().TargetListNew;
		String matchInputList = BaseTest.getData().AttributeValueNew;

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList(targetListNew);
		trgt.clickMatchList(targetListNew);
		if (!trgt.selectMat_Sup_OutputList(matchInputList))
		{

		}
	}

	@Test(testName = "", description = "Suppression Output List")
	public void createSuppressionOutputList()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();

		String targetListNew = BaseTest.getData().TargetListNew;
		String supInputList = BaseTest.getData().AttributeValueNew;

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod().searchTargetList(targetListNew);
		trgt.clickSuppressionList(targetListNew);
		if (trgt.selectMat_Sup_OutputList(supInputList))
		{
			// Due to listNaming convention issue
		}
	}

	@Test(testName = "", description = "All Audience - More Info And Preview Validate")
	public void All_Audience_MoreInfo_Validate()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu();
		trgt.validateMoreInfoCount(trgt.get_MDM_OverviewportletCount(), trgt.getMoreInfoDetails("All audience"));
	}

	@Test(testName = "", description = "Target list - List And Grid View Validation")
	public void List_And_Grid_View_Validation()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu();
		List<Map<String, String>> validateGridView = trgt.validateTrgtGridView();
		List<Map<String, String>> validateListView = trgt.validateListView();
		trgt.writeLog(validateGridView.equals(validateListView), "Grid view and List view data is same as expected.", "Grid view and List view data is not same as expected.");
	}

	@Test(testName = "", description = "Target List Max Data Values Filtered Attributes")
	public void TargetList_Max_25_DataValues_In_FilteredAttributes()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
		String SelectAttribute = BaseTest.getData().SelectAttribute;

		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.selectbusinessunit();
		trgt.getTotalAudienceCountFromMDM();
		trgt.clickTargetlistfromMenu().clickNewListSegment();
		trgt.enterTargetListName();
		trgt.searchAndSelectAttribute(SelectAttribute);
		trgt.clickElement(AudienceRepository.audience_target_inputvaluebox);
		List<WebElement> inputlist = trgt.findElements(DashboardRepository.allpage_common_selectdropdownlist);
		for (int count = 0; count < inputlist.size(); count++)
		{
			inputlist = trgt.findElements(DashboardRepository.allpage_common_selectdropdownlist);
			((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", inputlist.get(count));
			PageBase.threadSleep(ObjectRepository.wait1sec);
			inputlist.get(count).click();
			getWebDriver().findElement(PageBase.autolocator(AudienceRepository.audience_target_inputvaluebox)).click();
			if (count == 25)
			{
				trgt.tabAction();
				String errMsg = trgt.getStrText(AudienceRepository.audience_target_errormessageEmptyinput);
				trgt.compareUiwithInputvalue(errMsg, "Recommended max. 25 Data values");
				trgt.javaScriptScrollIntoView(AudienceRepository.audience_Target_listName);
				PageBase.threadSleep(ObjectRepository.wait1sec);
				BaseTest.takeScreenshot();
				trgt.clickElement(AudienceRepository.audience_target_filterRemove);
				break;
			}
		}
	}

	@Test(testName = "", description = "Child Attribute Group Two Inclusion And Exclusion")
	public void pw_TL_childAttribute_InclusionTwoAndExclusion()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();

		trgt.pw_login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.pw_selectbusinessunit();
		Page page = getPlayWright();
		trgt.pw_clickElement(AudienceRepository.pw_audiencelinkclick);
		trgt.pw_clickElement(AudienceRepository.pw_audience_Masterdatamanagement);
		trgt.pw_clickElement(AudienceRepository.pw_audience_Targetlist_Tab);
		String trgtlistname = trgt.pw_enterTargetListName();
		trgt.pw_targetListAttributeSearch(BaseTest.getData().ChildAttribute1);
		trgt.pw_selectAttributeConditionAndValue(BaseTest.getData().ChildAttribute1, BaseTest.getData().ChildAttribute1Condition, BaseTest.getData().ChildAttribute1Value);
		trgt.pw_addInclusionGroupTwo();
		trgt.pw_targetListAttributeSearch(BaseTest.getData().ChildAttribute2);
		trgt.pw_selectAttributeConditionAndValue(BaseTest.getData().ChildAttribute2, BaseTest.getData().ChildAttribute2Condition, BaseTest.getData().ChildAttribute2Value);
		trgt.pw_addExclusionGroup();
		trgt.pw_targetListAttributeSearch(BaseTest.getData().ChildAttribute3);
		trgt.pw_selectAttributeConditionAndValue(BaseTest.getData().ChildAttribute3, BaseTest.getData().ChildAttribute3Condition, BaseTest.getData().ChildAttribute3Value);
		trgt.pw_SaveTargetList();
		trgt.pw_SearchAndValidateTargetList(trgtlistname);
	}

	@Test(testName = "", description = "Parent And Child Attribute Group Two Inclusion And Exclusion")
	public void pw_TL_parentAndchildAttribute_InclusionTwoAndExclusion()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();

		trgt.pw_login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.pw_selectbusinessunit();
		Page page = getPlayWright();
		trgt.pw_clickElement(AudienceRepository.pw_audiencelinkclick);
		trgt.pw_clickElement(AudienceRepository.pw_audience_Masterdatamanagement);
		trgt.pw_clickElement(AudienceRepository.pw_audience_Targetlist_Tab);
		String trgtlistname = trgt.pw_enterTargetListName();
		trgt.pw_targetListAttributeSearch(BaseTest.getData().ParentAttribute1);
		trgt.pw_selectAttributeConditionAndValue(BaseTest.getData().ParentAttribute1, BaseTest.getData().ParentAttribute1Condition, BaseTest.getData().ParentAttribute1Value);
		trgt.pw_addInclusionGroupTwo();
		trgt.pw_targetListAttributeSearch(BaseTest.getData().ChildAttribute1);
		trgt.pw_selectAttributeConditionAndValue(BaseTest.getData().ChildAttribute1, BaseTest.getData().ChildAttribute1Condition, BaseTest.getData().ChildAttribute1Value);
		trgt.pw_addExclusionGroup();
		trgt.pw_targetListAttributeSearch(BaseTest.getData().ChildAttribute2);
		trgt.pw_selectAttributeConditionAndValue(BaseTest.getData().ChildAttribute2, BaseTest.getData().ChildAttribute2Condition, BaseTest.getData().ChildAttribute2Value);
		trgt.pw_SaveTargetList();
		trgt.pw_SearchAndValidateTargetList(trgtlistname);
	}

	@Test(testName = "", description = "TL child attribute Inclusion one and exclusion")
	public void pw_TL_childAttribute_InclusionOneAndExclusion()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();

		trgt.pw_login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.pw_selectbusinessunit();
		Page page = getPlayWright();
		trgt.pw_clickElement(AudienceRepository.pw_audiencelinkclick);
		trgt.pw_clickElement(AudienceRepository.pw_audience_Masterdatamanagement);
		trgt.pw_clickElement(AudienceRepository.pw_audience_Targetlist_Tab);
		String trgtlistname = trgt.pw_enterTargetListName();
		trgt.pw_targetListAttributeSearch(BaseTest.getData().ChildAttribute1);
		trgt.pw_selectAttributeConditionAndValue(BaseTest.getData().ChildAttribute1, BaseTest.getData().ChildAttribute1Condition, BaseTest.getData().ChildAttribute1Value);
		trgt.pw_addExclusionGroup();
		trgt.pw_targetListAttributeSearch(BaseTest.getData().ChildAttribute2);
		trgt.pw_selectAttributeConditionAndValue(BaseTest.getData().ChildAttribute2, BaseTest.getData().ChildAttribute2Condition, BaseTest.getData().ChildAttribute2Value);
		trgt.pw_SaveTargetList();
		trgt.pw_SearchAndValidateTargetList(trgtlistname);
	}

	@Test(testName = "", description = "TL parent attribute Inclusion one and exclusion")
	public void pw_TL_parentAttribute_InclusionOneAndExclusion()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();

		trgt.pw_login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.pw_selectbusinessunit();
		Page page = getPlayWright();
		trgt.pw_clickElement(AudienceRepository.pw_audiencelinkclick);
		trgt.pw_clickElement(AudienceRepository.pw_audience_Masterdatamanagement);
		trgt.pw_clickElement(AudienceRepository.pw_audience_Targetlist_Tab);
		String trgtlistname = trgt.pw_enterTargetListName();
		trgt.pw_targetListAttributeSearch(BaseTest.getData().ParentAttribute1);
		trgt.pw_selectAttributeConditionAndValue(BaseTest.getData().ParentAttribute1, BaseTest.getData().ParentAttribute1Condition, BaseTest.getData().ParentAttribute1Value);
		trgt.pw_addExclusionGroup();
		trgt.pw_targetListAttributeSearch(BaseTest.getData().ParentAttribute2);
		trgt.pw_selectAttributeConditionAndValue(BaseTest.getData().ParentAttribute2, BaseTest.getData().ParentAttribute2Condition, BaseTest.getData().ParentAttribute2Value);
		trgt.pw_SaveTargetList();
		trgt.pw_SearchAndValidateTargetList(trgtlistname);

	}

	@Test(testName = "", description = "TL parent And child attribute Inclusion one and exclusion")
	public void pw_TL_parentAndchildAttribute_InclusionOneAndExclusion()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();

		trgt.pw_login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.pw_selectbusinessunit();
		Page page = getPlayWright();
		trgt.pw_clickElement(AudienceRepository.pw_audiencelinkclick);
		trgt.pw_clickElement(AudienceRepository.pw_audience_Masterdatamanagement);
		trgt.pw_clickElement(AudienceRepository.pw_audience_Targetlist_Tab);
		String trgtlistname = trgt.pw_enterTargetListName();
		trgt.pw_targetListAttributeSearch(BaseTest.getData().ParentAttribute1);
		trgt.pw_selectAttributeConditionAndValue(BaseTest.getData().ParentAttribute1, BaseTest.getData().ParentAttribute1Condition, BaseTest.getData().ParentAttribute1Value);
		trgt.pw_addExclusionGroup();
		trgt.pw_targetListAttributeSearch(BaseTest.getData().ChildAttribute1);
		trgt.pw_selectAttributeConditionAndValue(BaseTest.getData().ChildAttribute1, BaseTest.getData().ChildAttribute1Condition, BaseTest.getData().ChildAttribute1Value);
		trgt.pw_SaveTargetList();
		trgt.pw_SearchAndValidateTargetList(trgtlistname);
	}

	@Test(testName = "", description = "Target list inclusion and exclusion group remove")
	public void pw_TL_removeInc_ExcGroup()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();

		trgt.pw_login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.pw_selectbusinessunit();
		Page page = getPlayWright();
		trgt.pw_clickElement(AudienceRepository.pw_audiencelinkclick);
		trgt.pw_clickElement(AudienceRepository.pw_audience_Masterdatamanagement);
		trgt.pw_clickElement(AudienceRepository.pw_audience_Targetlist_Tab);
		String trgtlistname = trgt.pw_enterTargetListName();
		trgt.pw_targetListAttributeSearch(BaseTest.getData().ChildAttribute1);
		trgt.pw_selectAttributeConditionAndValue(BaseTest.getData().ChildAttribute1, BaseTest.getData().ChildAttribute1Condition, BaseTest.getData().ChildAttribute1Value);
		trgt.pw_addInclusionGroupTwo();
		trgt.pw_targetListAttributeSearch(BaseTest.getData().ChildAttribute2);
		trgt.pw_selectAttributeConditionAndValue(BaseTest.getData().ChildAttribute2, BaseTest.getData().ChildAttribute2Condition, BaseTest.getData().ChildAttribute2Value);
		trgt.pw_inclusionGroupDelete();
		trgt.pw_addInclusionGroupTwo();
		trgt.pw_targetListAttributeSearch(BaseTest.getData().ChildAttribute2);
		trgt.pw_selectAttributeConditionAndValue(BaseTest.getData().ChildAttribute2, BaseTest.getData().ChildAttribute2Condition, BaseTest.getData().ChildAttribute2Value);
		trgt.pw_addExclusionGroup();
		trgt.pw_targetListAttributeSearch(BaseTest.getData().ChildAttribute3);
		trgt.pw_selectAttributeConditionAndValue(BaseTest.getData().ChildAttribute3, BaseTest.getData().ChildAttribute3Condition, BaseTest.getData().ChildAttribute3Value);
		trgt.pw_exclusionGroupDelete();
		trgt.pw_addExclusionGroup();
		trgt.pw_targetListAttributeSearch(BaseTest.getData().ChildAttribute3);
		trgt.pw_selectAttributeConditionAndValue(BaseTest.getData().ChildAttribute3, BaseTest.getData().ChildAttribute3Condition, BaseTest.getData().ChildAttribute3Value);
		trgt.pw_SaveTargetList();
		trgt.pw_SearchAndValidateTargetList(trgtlistname);
		trgt.filehandle();
	}

	@Test(testName = "", description = "Validate parent attribute condition and values")
	public void pw_ValidateParentAttributeConditionAndValues()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();

		trgt.pw_login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.pw_selectbusinessunit();
		Page page = getPlayWright();
		String attributeName = "";
		String condition = "";
		String attributeValue = "";
		String listName = BaseTest.getData().AttributeValueNew;

		trgt.pw_clickElement(AudienceRepository.pw_audiencelinkclick);
		trgt.pw_clickElement(AudienceRepository.pw_audience_Masterdatamanagement);
		trgt.pw_clickElement(AudienceRepository.pw_audience_Targetlist_Tab);
		trgt.pw_enterTargetListName();

		attributeName = "Import Description";
		condition = "Is equal to,Is not equal to,Contains,Not contains,Like,Does not like,Starts with,Ends with,Has no value,Has value";
		attributeValue = "" + listName + "," + listName + "," + listName + "," + listName + ",Trgt,Trgt," + listName.substring(0, 4) + "," + listName.substring(4, listName.length()) + ", , ,";
		trgt.pw_targetListAttributeSearch(attributeName);
		trgt.pw_checkEachConditionValue(attributeName, condition, attributeValue);
		trgt.pw_clickElement(PageBase.replacePlaceHolder(AudienceRepository.pw_attributeminusicon, attributeName));

		attributeName = "Age";
		condition = "Is not equal to,Is greater than or equal to,Is greater than,Is less than or equal to,Is less than,Has no value,Has value";
		attributeValue = "21,21,12,12,21, , ,";
		trgt.pw_targetListAttributeSearch(attributeName);
		trgt.pw_checkEachConditionValue(attributeName, condition, attributeValue);
		trgt.pw_clickElement(PageBase.replacePlaceHolder(AudienceRepository.pw_attributeminusicon, attributeName));

//		attributeName = "PurchaseDate";
//		condition = "Is equal to,Is not equal to,Is after or equal to,Is after,Is before or equal to,Is before,Has no value,Has value";
//		attributeValue = "January 20 2022,February 20 2022,March 20 2022,April 20 2022,May 20 2022,June 20 2022, , ,";
//		trgt.pw_targetListAttributeSearch(attributeName);
//		trgt.pw_checkEachConditionValue(attributeName, condition, attributeValue);
//		trgt.pw_clickElement(PageBase.replacePlaceHolder(AudienceRepository.pw_attributeminusicon, attributeName));

		attributeName = "TextRatioVJ";
		condition = "Is equal to,Is not equal to,Is greater than or equal to,Is greater than,Is less than or equal to,Is less than,Has no value,Has value";
		attributeValue = "21.2,21.2,12.2,12.2,12.2,12.2, , ,";
		trgt.pw_targetListAttributeSearch(attributeName);
		trgt.pw_checkEachConditionValue(attributeName, condition, attributeValue);
		trgt.pw_clickElement(PageBase.replacePlaceHolder(AudienceRepository.pw_attributeminusicon, attributeName));
	}

	@Test(testName = "", description = "Validate child attribute condition and values")
	public void pw_ValidateChildAttributeConditionAndValues()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();

		trgt.pw_login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		trgt.pw_selectbusinessunit();
		String attributeName = "";
		String condition = "";
		String attributeValue = "";

		trgt.pw_clickElement(AudienceRepository.pw_audiencelinkclick);
		trgt.pw_clickElement(AudienceRepository.pw_audience_Masterdatamanagement);
		trgt.pw_clickElement(AudienceRepository.pw_audience_Targetlist_Tab);
		trgt.pw_enterTargetListName();

		attributeName = "CreditType";
		condition = "Is equal to,Is not equal to,Contains,Not contains,Like,Does not like,Starts with,Ends with,Has no value,Has value";
		attributeValue = "Master,Rupay,Visa,Master,Rupay,Visa,Master,Rupay, , ,";
		trgt.pw_targetListAttributeSearch(attributeName);
		trgt.pw_checkEachConditionValue(attributeName, condition, attributeValue);
		trgt.pw_clickElement(PageBase.replacePlaceHolder(AudienceRepository.pw_attributeminusicon, attributeName));

		attributeName = "CreditLimitVJ";
		condition = "Is not equal to,Is greater than or equal to,Is greater than,Is less than or equal to,Is less than,Has no value,Has value";
		attributeValue = "21,21,12,12,21, , ,";
		trgt.pw_targetListAttributeSearch(attributeName);
		trgt.pw_checkEachConditionValue(attributeName, condition, attributeValue);
		trgt.pw_clickElement(PageBase.replacePlaceHolder(AudienceRepository.pw_attributeminusicon, attributeName));

//		attributeName = "PurchaseVJ";
//		condition = "Is equal to,Is not equal to,Is after or equal to,Is after,Is before or equal to,Is before,Has no value,Has value";
//		attributeValue = "January 20 2022,February 20 2022,March 20 2022,April 20 2022,May 20 2022,June 20 2022, , ,";
//		trgt.pw_targetListAttributeSearch(attributeName);
//		trgt.pw_checkEachConditionValue(attributeName, condition, attributeValue);
//		trgt.pw_clickElement(PageBase.replacePlaceHolder(AudienceRepository.pw_attributeminusicon, attributeName));

		attributeName = "TextRatioVJ";
		condition = "Is equal to,Is not equal to,Is greater than or equal to,Is greater than,Is less than or equal to,Is less than,Has no value,Has value";
		attributeValue = "21.2,21.2,12.2,12.2,12.2,12.2, , ,";
		trgt.pw_targetListAttributeSearch(attributeName);
		trgt.pw_checkEachConditionValue(attributeName, condition, attributeValue);
		trgt.pw_clickElement(PageBase.replacePlaceHolder(AudienceRepository.pw_attributeminusicon, attributeName));
	}

	@Test(description = "Target Listing Page Advanced search")
	public void targetListingPageAdvancedsearch()
	{
		AudiencePage_Targetlist trgt = getPageFactory().audiencepage_Targetlist();
		trgt.login(trgt.dPropertyLoginUserName(), trgt.dPropertyLoginPswrd());
		String targetListNew = BaseTest.getData().TargetListNew;

		trgt.selectbusinessunit();
		trgt.clickTargetlistfromMenu().filterTargetListTimePeriod();
		Map<String, String> searchTargetList = trgt.searchTargetList(targetListNew);
		trgt.getListDetailes(searchTargetList);
		trgt.negativeadvancedsearch();
		trgt.advancedsearch();
	}

}
