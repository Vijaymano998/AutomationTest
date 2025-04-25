package pages;

import org.openqa.selenium.WebDriver;

import com.microsoft.playwright.Page;

import utility.PageFactory;

public class AnalyticsListingPage extends HomePage
{
	public AnalyticsListingPage(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}
}
