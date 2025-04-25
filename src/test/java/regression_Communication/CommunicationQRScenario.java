package regression_Communication;

import java.awt.AWTException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.regex.Pattern;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import pages.CommunicationCreatePage;
import pages.CommunicationQRChannelPage;
import utility.BaseTest;

public class CommunicationQRScenario extends BaseTest
{

	@Test(description = "QR communication create without SmartUrl")
	public void QRCommwithoutSmartUrl() throws IOException, AWTException
	{
		CommunicationQRChannelPage qr = getPageFactory().communicationqrchannelpage();
		int startDate = 0;
		int endDate = 3;
		qr.login(qr.dPropertyLoginUserName(), qr.dPropertyLoginPswrd());
		qr.selectbusinessunit();
		qr.clickCreateCommunicationfromMenu();
		qr.singleDimensionComm(startDate, endDate);
		qr.selectQRChannel().analyticOption2().clickNext();
		// qr.createSmarturl();
		qr.smartUrlpopupCancel();
		qr.qrDetails();
		qr.clickSaveqrPage();
		qr.communicationlistingPageStatusCompare("In progress");
		qr.editcomm();
		qr.javaScriptScrollDown();
		qr.clickNext();
		qr.smartUrlpopupCancel();
		qr.scanQRCode(3);
		qr.clickSaveqrPage();
		qr.communicationlistingPageStatusCompare("In progress");
	}

	@Test(description = "QR communication create with SmartUrl")
	public void QRCommwithSmartUrl() throws IOException, AWTException
	{
		CommunicationQRChannelPage qr = getPageFactory().communicationqrchannelpage();
		int startDate = 0;
		int endDate = 3;
		qr.login(qr.dPropertyLoginUserName(), qr.dPropertyLoginPswrd());
		qr.selectbusinessunit();
		qr.clickCreateCommunicationfromMenu();
		qr.singleDimensionComm(startDate, endDate);
		qr.selectQRChannel().analyticOption2().clickNext();
		qr.createSmarturl();
		qr.smartUrlpopupCancel();
		qr.qrDetails();
		qr.clickSaveqrPage();
		qr.communicationlistingPageStatusCompare("In progress");
		qr.editcomm();
		qr.javaScriptScrollDown();
		qr.clickNext();
		qr.scanQRCode(3);
		qr.clickSaveqrPage();
		qr.communicationlistingPageStatusCompare("In progress");
	}

	@Test(description = "QR - SMS Communication create and download QR Code")
	public void qrSMSCommunicationCreate() throws IOException, AWTException
	{
		CommunicationQRChannelPage qr = getPageFactory().communicationqrchannelpage();
		int startDate = 0;
		int endDate = 3;
		qr.login(qr.dPropertyLoginUserName(), qr.dPropertyLoginPswrd());
		qr.selectbusinessunit();
		qr.clickCreateCommunicationfromMenu();
		qr.singleDimensionComm(startDate, endDate);
		qr.selectQRChannel().analyticOption2().clickNext();
		qr.createSmarturl();
		qr.qrCommunication("SMS");
		qr.qrSMSCommunication();
		qr.clickSaveqrPage();
		qr.searchCommunication("communicationlisting", qr.communicationName);
	}

	@Test(description = "QR - Text Communication create and download QR Code")
	public void qrTextCommunicationCreate() throws IOException, AWTException
	{
		CommunicationQRChannelPage qr = getPageFactory().communicationqrchannelpage();
		int startDate = 0;
		int endDate = 3;
		qr.login(qr.dPropertyLoginUserName(), qr.dPropertyLoginPswrd());
		qr.selectbusinessunit();
		qr.clickCreateCommunicationfromMenu();
		qr.singleDimensionComm(startDate, endDate);
		qr.selectQRChannel().analyticOption2().clickNext();
		qr.createSmarturl();
		qr.qrCommunication("Text");
		qr.qrTextCommunication();
		qr.clickSaveqrPage();
		qr.searchCommunication("communicationlisting", qr.communicationName);
	}

//	@Test(description = "QR create and validate")
//	public void qrCreateAndValidate()
//	{
//		CommunicationQRChannelPage qr = getPageFactory().communicationqrchannelpage();
//
//		qr.pw_login(qr.dPropertyLoginUserName(), qr.dPropertyLoginPswrd());
//		qr.pw_selectbusinessunit();
//		Page page = getPlayWright();
//
//		qr.communicationName = BaseTest.getData().CommunicationName + qr.addTimeToName();
//
//		page.locator("li:nth-child(2) > .dropdown > a").click();
//		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Create communication")).click();
//		page.locator("li").filter(new Locator.FilterOptions().setHasText("Single dimension")).click();
//		page.locator("#loading div").first().click();
//		page.locator("#rs_DeliveryMethod_communicationName").fill(qr.communicationName);
//		page.getByText("Communication nameCommunication name *Test communicationCommunication").click();
//		page.getByLabel("Communication type").locator("span").nth(1).click();
//		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​Promotion")).click();
//		page.getByLabel("Product type", new Page.GetByLabelOptions().setExact(true)).locator("span").nth(1).click();
//		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​Loans")).click();
//		page.getByLabel("Primary goal").locator("span").nth(1).click();
//		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​Reach")).click();
//		page.getByPlaceholder("Start date").click();
//		page.getByTitle("Thursday, November 21,").locator("span").click();
//		page.getByPlaceholder("End date").click();
//		page.getByTitle("Sunday, November 24,").locator("span").click();
//		page.getByLabel("QR").check();
//		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
//
//		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Yes")).click();
//		page.locator("#rs_GenerateSmartLink_DomainURL").click();
//		page.locator("#rs_GenerateSmartLink_DomainURL").fill("https://conversion.resulticks.net/");
//		page.getByRole(AriaRole.DIALOG).getByRole(AriaRole.BUTTON, new Locator.GetByRoleOptions().setName("Generate")).click();
//		page.locator("#rs_SmartLink_save").click();
//		page.locator("#rs_QRContent_audiencereach").click();
//		page.locator("#rs_QRContent_audiencereach").fill("30");
//		page.locator("#rs_QRContent_RedirectionalURL").click();
//		page.locator("#rs_QRContent_RedirectionalURL").fill("https://www.resulticks.com/");
//		String path = curr_Dir + "\\src\\main\\resources\\data\\uploadfiles\\QRImage.jpg";
//		page.setInputFiles("#rs_QRContent_logoUpload", Paths.get(path));
//		page.getByText("Default kyc").click();
//		page.getByText("Default kyc").click();
//		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​new duplicate test")).click();
//		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Generate")).click();
//		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
//		page.locator("#loading div").first().click();
//		page.getByLabel("Analytics platform").locator("span").nth(1).click();
//		page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("​Resulticks Analytics")).click();
//		page.getByLabel("Domain").locator("span").nth(1).click();
//		page.getByText("https://conversion25.").click();
//		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Next")).click();
//		page.locator("#rs_RSAdvanceSearch_zoom").click();
//		page.getByPlaceholder("By communication name").click();
//		page.getByPlaceholder("By communication name").fill(qr.communicationName);
//		page.locator("li").filter(new Locator.FilterOptions().setHasText(Pattern.compile(qr.communicationName))).click();
//		page.locator(".search-field").click();
//		page.getByPlaceholder("By communication name").click();
//		page.locator("#rs_data_zoom").click();
//		page.getByText("qr.communicationName").click();
//		page.getByText("Promotion").click();
//		page.getByText("3030").click();
//		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("")).click();
//		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("")).click();
//		page.getByLabel("Expand detail row").click();
//		page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("")).locator("i").click();
//		page.getByRole(AriaRole.ROW, new Page.GetByRoleOptions().setName("    ").setExact(true)).locator("#rs_data_eye").click();
//		page.getByRole(AriaRole.TOOLTIP).getByRole(AriaRole.IMG).click();
//		page.pause();
//	}
//
//	public class CommunicationNegativeScenario extends BaseTest
//	{
//
//		@Test(testName = "Communication Negative Scenario", description = "Communication Negative")
//
//		public void CommunicationNegativeScenario() throws InterruptedException
//		{
//			CommunicationCreatePage Comm = getPageFactory().communicationcreatepage();
//			Comm.pw_login(Comm.dPropertyLoginUserName(), Comm.dPropertyLoginPswrd());
//			Comm.pw_selectbusinessunit();
//			Page page = getPlayWright();
//			page.pause();
//
//		}
//	}

}
