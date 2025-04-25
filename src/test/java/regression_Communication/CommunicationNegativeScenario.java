package regression_Communication;

import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import pages.CommunicationNegativeScenarioPage;
import utility.BaseTest;

public class CommunicationNegativeScenario extends BaseTest
{

	@Test(testName = "Communication Negative Scenario", description = "Communication Negative planning page scenario")

	public void CommunicationPlannigPageNegativeScenario() throws InterruptedException
	{
		CommunicationNegativeScenarioPage Comm = getPageFactory().CommunicationNegativeScenarioPage();
		Comm.pw_login(Comm.dPropertyLoginUserName(), Comm.dPropertyLoginPswrd());
		Comm.pw_selectbusinessunit();
		Page page = getPlayWright();
		Comm.plannepage();

		page.pause();

	}

	@Test(testName = "Communication EMAIL Negative Scenario", description = "Communication Negative plan page scenario")

	public void CommunicationAuthoringPageEmailNegativeScenario() throws InterruptedException
	{
		CommunicationNegativeScenarioPage Comm = getPageFactory().CommunicationNegativeScenarioPage();
		Comm.pw_login(Comm.dPropertyLoginUserName(), Comm.dPropertyLoginPswrd());
		Comm.pw_selectbusinessunit();
		Page page = getPlayWright();
		Comm.AuthoringpageEmail();
	}

	@Test(testName = "Communication Message Negative Scenario", description = "Communication Negative message authoring page scenario")

	public void CommunicationAuthoringPageMessageNegativeScenario() throws InterruptedException
	{
		CommunicationNegativeScenarioPage Comm = getPageFactory().CommunicationNegativeScenarioPage();
		Comm.pw_login(Comm.dPropertyLoginUserName(), Comm.dPropertyLoginPswrd());
		Comm.pw_selectbusinessunit();
		Page page = getPlayWright();
		Comm.Authoringpagemessage();
	}

	@Test(testName = "Communication Notification Negative Scenario", description = "Communication Negative Notification authoring page scenario")

	public void CommunicationNotificationNegativeScenario() throws InterruptedException
	{
		CommunicationNegativeScenarioPage Comm = getPageFactory().CommunicationNegativeScenarioPage();
		Comm.pw_login(Comm.dPropertyLoginUserName(), Comm.dPropertyLoginPswrd());
		Comm.pw_selectbusinessunit();
		Page page = getPlayWright();
		Comm.AuthoringpageNotification();
	}
}