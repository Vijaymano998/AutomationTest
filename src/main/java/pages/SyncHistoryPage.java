package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Page;

import repository.AudienceRepository;
import utility.BaseTest;
import utility.PageFactory;

public class SyncHistoryPage extends AudiencePage_Upload
{

	String alertIcon;

	public SyncHistoryPage(WebDriver driver, Page page, PageFactory pageFactory) {

		super(driver, page, pageFactory);

	}

	public SyncHistoryPage syncHistorymousehovervalidation()
	{
		/*
		 * threadSleep(ObjectRepository.wait5sec); mouseHover(AudienceRepository.audience_mdm_synchistory); threadSleep(ObjectRepository.wait10sec);
		 * BaseTest.takeScreenshot();
		 */
		toolTipValidationKnownText(AudienceRepository.audience_mdm_synchistory, "Sync history");
		return this;
	}

	public SyncHistoryPage synchistorynavigation()

	{
		clickElement(AudienceRepository.audience_mdm_synchistory);
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_synchistory_import), 30);
		if (isElementAvailable(AudienceRepository.audience_synchistory_importheader) || isElementAvailable(AudienceRepository.audience_synchistory_import))
		{
			BaseTest.takeScreenshot();
			BaseTest.getTest().log(Status.INFO, "Navigated to import tab succesfully");
		} else
		{
			BaseTest.takeScreenshot();
			BaseTest.getTest().log(Status.INFO, "Unable to navigate import tab");
		}
		return this;
	}

	public SyncHistoryPage synchistoryColumnsValidation()
	{
		// thead[@role='presentation']/tr/th

		List<WebElement> columnHeader = findElements("column header,xpath, //thead[@role='presentation']/tr/th");
		System.out.println(columnHeader);
		BaseTest.getTest().log(Status.INFO, "headers" + columnHeader);
		for (WebElement headers : columnHeader)
		{
			String importHeaders = headers.getText();
			System.out.println(importHeaders);
			BaseTest.getTest().log(Status.INFO, "headers final" + importHeaders);
		}
		return this;
	}

	public SyncHistoryPage paginationandDateRange()
	{
		if ((isDisplayed(AudienceRepository.audience_synchistory_daterange)) && (isDisplayed(AudienceRepository.audience_synchistory_pagination)))
		{
			BaseTest.getTest().log(Status.INFO, "Date range filter and paginations fields are available");
		}
		return this;
	}

////tbody[@role='presentation']//td[6]
	//// tbody[@role='presentation']//td[6]//following-sibling::td//i[@class='icon-rs-alert-medium icon-md color-primary-blue ']
	public SyncHistoryPage invalidAuidence(String invalidAudience)
	{
		List<WebElement> importDes = findElements("import description,xpath, //tbody[@role='presentation']//td[6]");
		boolean alertIcon = findElement("alert icon,xpath, //tbody[@role='presentation']//td/div[contains(text()," + invalidAudience + ")]/..//following-sibling::td//i[@class='icon-rs-alert-medium icon-md color-primary-blue ']").isDisplayed();
		// boolean alertIcon = findElement("alert icon,xpath, //span[contains(text()," + invalidAudience +
		// ")]/parent::td//following-sibling::td//i[contains(@class,'icon-rs-alert-medium icon-md color-primary-blue ')]").isDisplayed();
		// List<WebElement> alert = findElements("alert icon,xpath, //tbody[@role='presentation']//td[6]");
		for (WebElement ImpDescription : importDes)
		{
			String ImportDescription = ImpDescription.getText();
			if (ImportDescription.equals(invalidAudience))
			{
				BaseTest.getTest().log(Status.INFO, ImportDescription + "has been uploaded");
				if (alertIcon)
				{
					BaseTest.getTest().log(Status.INFO, "Alert icon is shown for invalid audience");
				} else
				{
					BaseTest.getTest().log(Status.INFO, "Alert icon is not shown for invalid audience");
				}
			}
		}
		return this;
	}

	// div[@class='k-grid-content k-virtual-content']//tr/td[6]

	public SyncHistoryPage downloadCSV()
	{
		clickElement(alertIcon);
		pageLoaderLogo();

		return this;

	}

}