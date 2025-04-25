package pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.microsoft.playwright.Page;

import repository.AudienceRepository;
import repository.CommunicationRepository;
import repository.DashboardRepository;
import repository.ObjectRepository;
import utility.BaseTest;
import utility.PageFactory;

public class CommunicationPlannerPage extends HomePage
{
	List<String> communicationsList = new ArrayList<>();
	List<String> communicationsList2 = new ArrayList<>();

	public CommunicationPlannerPage(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	public void Plannerpagescenario()
	{
		pageLoaderLogo();
		clickCommunicationTab();

		clickElement(",xpath,//a[normalize-space()='Planner']");
		pageLoaderLogo();
		BaseTest.getTest().info(MarkupHelper.createLabel("COMMUNICATION PLAN PAGE", ExtentColor.BLUE));
		// Step 1: Get current date
		Date date = new Date();

		// Step 2: Format date to extract the day of the month (dd)
		SimpleDateFormat df = new SimpleDateFormat("dd");
		String dayString = df.format(date);

		// Step 3: Convert the day string to integer and subtract 1
		int dayInt = Integer.parseInt(dayString);
		int previousDay = dayInt - 1;

		// Step 4: Convert the result back to a string
		String previousDayString = Integer.toString(previousDay);

		javaScriptScrollIntoView(replacePlaceHolder(",xpath,//div[@class='rbc-date-cell']//button[.='PLACE_HOLDER']/..", previousDayString));
		threadSleep(ObjectRepository.wait2sec);
//		

		// javaScriptScrollIntoView("//div[@class=\"rbc-date-cell\"]//button[.='" +
		// previousDayString + "']/..");

		clickElement(replacePlaceHolder(",xpath,//div[@class='rbc-date-cell']//button[.='PLACE_HOLDER']/..", previousDayString));
		pageLoaderLogo();
		clickElement(",xpath,//i[@class='icon-rs-square-plus-fill-mini  color-secondary-grey  mt2 mr5 icon-md']");

		List<WebElement> FilterlistValues = findElements(",xpath,//div[contains(@class,'accordion-collapse css-scrollbar')]//div");
		for (int i = 1; i <= FilterlistValues.size(); i++)
		{
			String Communication = getStrText(",xpath,(//div[contains(@class,'accordion-collapse css-scrollbar')]//div)[" + i + "]");
			System.out.println(Communication);
			communicationsList.add(Communication);
		}
		clickElement(",xpath,//i[@id='rs_circle_close_edge']");
		pageLoaderLogo();
		clickCommunicationListpagefromMenu();
		String timeStamp = ",xpath,//div[@class='communication-content']//small[contains(.,'Cre')]";
		pageLoaderLogo();
		String[] input = BaseTest.getData().DateRangeFilter.split(",");
		for (String testdata : input)
		{
			javaScriptScrolltoTop();
			explicitwaitforclick(autolocator(AudienceRepository.audience_Filter_Menu), 30);
			clickElement(AudienceRepository.audience_Filter_Menu);
			explicitwaitforclick(autolocator(AudienceRepository.audience_FilterMenu_List), 30);
			if (selectlistelementsAndProceed(AudienceRepository.audience_FilterMenu_List, testdata))
			{
				if (testdata.contains("Custom range"))
				{
//					customRangeCalender(BaseTest.getData().EndDate);
//					customRangeCalender(BaseTest.getData().StartDate);

					customRangeCalender(BaseTest.getData().EndDate);
					customRangeCalender(BaseTest.getData().StartDate);

					threadSleep(ObjectRepository.wait1sec);
					clickElement(AudienceRepository.audience_target_customfilterclickapply);

				}
				pageLoaderLogo();
				String filterdate = getStrText(AudienceRepository.audience_Filter_Menu);
				String[] splitfilterdate = filterdate.split(" - ");
				BaseTest.getTest().log(Status.INFO, "Filtered Date Between  ---> " + filterdate);
				threadSleep(ObjectRepository.wait1sec);
				javaScriptScrollIntoView(",xpath,//span[@class='k-input-value-text']");
				threadSleep(ObjectRepository.wait1sec);
				clickElement(",xpath,//span[@class='k-input-value-text']");
				selectlistelements(",xpath,//ul[@role='listbox']//li", "20");
				pageLoaderLogo();
				threadSleep(ObjectRepository.wait10sec);

				;
				javaScriptScrollIntoView(AudienceRepository.audience_Filter_Menu);

//				List<WebElement> listNames = findElements(
//						",xpath,//tbody/tr//div//div[@class='rs-tooltip-wrapper d-inline-block']");

				List<WebElement> listNames = findElements(",xpath,//tbody//tr//p[@class='pt5']");
				while (true)
				{
					for (int i = 0; i < listNames.size(); i++)
					{
						listNames = findElements(",xpath,//tbody//tr//p[@class='pt5']");
						String Communicationname = listNames.get(i).getText();
						if (Communicationname.contains("..."))
						{
							mouseHover(listNames.get(i));
							Communicationname = getStrText(DashboardRepository.allpage_tooltip);
							System.out.println(Communicationname);
							communicationsList2.add(Communicationname);
						} else
						{
							System.out.println(Communicationname);
							communicationsList2.add(Communicationname);
						}
					}
					WebElement nextButton = driver.findElement(By.cssSelector("a[title='Go to the next page']"));
					if (nextButton.getAttribute("class").contains("disabled"))
					{
						break;
					} else
					{
						threadSleep(ObjectRepository.wait1sec);
						javaScriptScrollDown();
						nextButton.click();
					}
				}
				for (WebElement listName : listNames)
				{
					String Communicationname = listName.getText();
					if (Communicationname.contains("..."))
					{
						mouseHover(listName);
						Communicationname = getStrText(DashboardRepository.allpage_tooltip);
						System.out.println(Communicationname);
						communicationsList2.add(Communicationname);
					} else
					{
						System.out.println(Communicationname);
						communicationsList2.add(Communicationname);

					}

				}

				if (findElement(AudienceRepository.audience_synchist_lastButton).getAttribute("class").contains("disabled"))
				{
					Set<String> set = new HashSet<>();
					for (String value : communicationsList2)
					{
						set.add(value);
					}
					for (String value : communicationsList)
					{
						if (set.contains(value))
						{
							BaseTest.getTest().log(Status.INFO, value + " is present in both Communication listing page and Planner page.");
						} else
						{
							BaseTest.getTest().log(Status.FAIL, value + " Present Name are other types.");
						}
					}
				} else
				{
					javaScriptScrollDown();
					clickElement(AudienceRepository.audience_synchist_nextButton);
					pageLoaderLogo();
					Set<String> set = new HashSet<>();
					for (String value : communicationsList2)
					{
						set.add(value);
					}
					for (String value : communicationsList)
					{
						if (set.contains(value))
						{
							BaseTest.getTest().log(Status.INFO, value + " is present in both Communication listing page and Planner page.");
						} else
						{
							BaseTest.getTest().log(Status.FAIL, value + " Present Name are other types.");
						}
					}
				}
			}
		}
		pageLoaderLogo();
		clickCommunicationTab();

		clickElement(",xpath,//a[normalize-space()='Planner']");
		pageLoaderLogo();
		javaScriptScrollIntoView(replacePlaceHolder(",xpath,//div[@class='rbc-date-cell']//button[.='PLACE_HOLDER']/..", previousDayString));
		threadSleep(ObjectRepository.wait2sec);

		clickElement(replacePlaceHolder(",xpath,//div[@class=\"rbc-date-cell\"]//button[.='PLACE_HOLDER']/..", previousDayString));
		pageLoaderLogo();
		clickElement(",xpath,//i[@class='icon-rs-square-plus-fill-mini  color-secondary-grey  mt2 mr5 icon-md']");
		threadSleep(ObjectRepository.wait1sec);

		clickElement(",xpath,(//div[contains(@class,'accordion-collapse css-scrollbar')]//div)[1]");
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait2sec);

		String Plannerpageinnername = getStrText(",xpath,//div[contains(@class,'rs-planner-events-wrapper')]//h3");

//		if (communicationsList.get(0).equals(Plannerpageinnername)) {
//			BaseTest.getTest().log(Status.INFO, "Communication name is present");
//			BaseTest.takeScreenshot();

		if (communicationsList.contains(Plannerpageinnername))
		{
			BaseTest.getTest().log(Status.INFO, "Communication name is present");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Communication name is Not  present");
			BaseTest.takeScreenshot();

		}

	}

	public void PlannerpagescenarioNewcommunication()
	{
		pageLoaderLogo();
		clickCommunicationTab();

		clickElement(",xpath,//a[normalize-space()='Planner']");
		pageLoaderLogo();
		BaseTest.getTest().info(MarkupHelper.createLabel("COMMUNICATION PLAN PAGE", ExtentColor.BLUE));
		// Step 1: Get current date
		Date date = new Date();

		// Step 2: Format date to extract the day of the month (dd)
		SimpleDateFormat df = new SimpleDateFormat("dd");
		String dayString = df.format(date);

		// Step 3: Convert the day string to integer and subtract 1
		int dayInt = Integer.parseInt(dayString);
		int previousDay = dayInt;

		// Step 4: Convert the result back to a string
		String previousDayString = Integer.toString(previousDay);

		javaScriptScrollIntoView(replacePlaceHolder(",xpath,//button[.='PLACE_HOLDER']", previousDayString));
		threadSleep(ObjectRepository.wait2sec);

		clickElement(replacePlaceHolder(",xpath,//div[@class=\"rbc-date-cell\"]//button[.='PLACE_HOLDER']/..", previousDayString));
		pageLoaderLogo();
		clickElement(",xpath,//i[@class='icon-rs-square-plus-fill-mini  color-secondary-grey  mt2 mr5 icon-md']");

	}

	public void SMSscrubbedScenario() throws InterruptedException

	{
		BaseTest.getTest().info(MarkupHelper.createLabel("PRE COMMUNICATION ANALYTICS PAGE", ExtentColor.BLUE));
		pageLoaderLogo();
		if (isDisplayed(CommunicationRepository.precomm_content))
		{
			javaScriptScrollIntoView("List quality head,xpath,//h4[.='List quality']");
			boolean scrubbed = isElementPresent("Scrubbed status,xpath,//h5[text()='Scrubbed']");
			if (scrubbed)
			{
				BaseTest.getTest().log(Status.INFO, "Communication get scrubbed successfully");
				BaseTest.takeScreenshot();
				try
				{
					mouseHover("edit icon,id,//i[@id='rs_data_pencil_edit']");

					String Editname = getStrText(DashboardRepository.allpage_tooltip);
				} catch (Exception e)
				{
					System.out.println("mouser not working");
				}

				clickElement("edit icon,id,rs_data_pencil_edit");
				isElementPresent(",xpath,//h2[.='Pre-communication SMS scrubbed data']");
				for (int i = 1; i <= 2; i++)
				{
					String[] strText = getStrText(" Pre-communication SMS scrubbed data,xpath,(//tbody//tr//td//div)[" + i + "]").split("[()]");

					String number = strText[1];
					System.out.println(number);
					if (i == 1)
					{
						if (number.equals("0"))
						{
							BaseTest.getTest().log(Status.INFO, "Scrubbed status of Unsubscribe" + number + "");

						} else
						{
							BaseTest.getTest().log(Status.INFO, "Scrubbed status of Unsubscribe is mismatch");

						}
					} else
					{
						if (number == "0")
						{
							BaseTest.getTest().log(Status.INFO, "Scrubbed status of DND" + number + "");

						} else
						{
							BaseTest.getTest().log(Status.INFO, "Scrubbed status of Unsubscribe is mismatch");

						}
					}
				}
				clickElement("close Icon,id,rs_circle_close_edge");
				Thread.sleep(ObjectRepository.wait2sec);

			} else
			{
				Thread.sleep(ObjectRepository.wait2sec);
			}
		}
	}

	public void SMSvalidateCGTGSlider(String condition)
	{
		pageLoaderLogo();
		try
		{
			mouseHover("CGTG icon,xpath,//i[contains(@class,'icon-rs-user-cgtg-large icon')]");

			String Editname = getStrText(DashboardRepository.allpage_tooltip);
		} catch (Exception e)
		{
			System.out.println("mouser not working");
		}
		clickElement("CGTG icon,xpath,//i[contains(@class,'icon-rs-user-cgtg-large icon')]");

		String toggleStatus = getTextBoxVal(",xpath,//span[.='Control group/Target group']//..//..//span[contains(@class,'k-switch-track k-rounded')]", "aria-checked");
		if (toggleStatus.toLowerCase().contains("true") && condition.toLowerCase().contains("true"))
		{
			BaseTest.getTest().log(Status.INFO, "Toggle button status is present as expected.");
		} else if (toggleStatus.toLowerCase().contains("false") && condition.toLowerCase().contains("false"))
		{
			BaseTest.getTest().log(Status.INFO, "Toggle button status is present as expected.");
			clickElement("Toogle button,xpath,//span[.='Control group/Target group']//..//..//span[contains(@class,'k-switch-track k-rounded')]");
			pageLoaderLogo();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Toggle button status is not present as expected.");
		}
		String cgSplitSize = getTextBoxVal(AudienceRepository.audience_target_cgTopValue, "value").replaceAll("[^0-9]", "");
		String tgSplitSize = getStrText(AudienceRepository.audience_target_tgTopValue).replaceAll("[^0-9]", "");
		String sliderCg = getStrText(AudienceRepository.audience_target_slidercgvalue).replaceAll("[^0-9]", "");
		String sliderTg = getStrText(AudienceRepository.audience_target_slidertgvalue).replaceAll("[^0-9]", "");
		writeLog(sliderCg.equals(cgSplitSize) && sliderTg.equals(tgSplitSize), "Control and target group value is present as expected. CG value : <b>" + cgSplitSize + "</b> TG value : <b>" + tgSplitSize + "</b>",
				"Control and target group value is not present as expected.");
		WebElement slider = driver.findElement(autolocator(AudienceRepository.audience_target_cgtgslider));
		Actions action = new Actions(driver);
		action.clickAndHold(slider).moveByOffset(-60, 0).release().build().perform();
		clickElement("Save Button ,xpath,//button[.='Save']");
		threadSleep(ObjectRepository.wait1sec);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait1sec);
		pageLoaderLogo();
		// button[.='Save']
		// span[.='Control group/Target
		// group']//..//..//span[contains(@class,'k-switch-track k-rounded')]
	}

}