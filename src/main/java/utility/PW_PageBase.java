package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitUntilState;

import repository.DashboardRepository;
import repository.ObjectRepository;

/**
 * @author Vijay M
 */

public class PW_PageBase extends PageBase
{
	public PW_PageBase(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	/**
	 * This class is used to reference of all playwright reusable method
	 */

	// 'pw_launchUrl' used to launch the url
	public PW_PageBase pw_launchUrl(String url)
	{
		page.navigate(url);
		BaseTest.getTest().log(Status.INFO, "URL Launched -> " + url);
		BaseTest.getTest().log(Status.INFO, "Page Title -> " + page.title());
		return this;
	}

	// 'pw_autolocator' method used to split the key and return the locator
	public static String pw_autolocator(String key)
	{
		String[] a = key.split(",", 3); // 2 -> for splitting first comma only
		try
		{
			BaseTest.logName.set(a[0]);
			switch (a[1])
			{
			case "pw":
				return a[2];
			}
		} catch (NoSuchElementException prin)
		{
			prin.printStackTrace();
		}
		return key;
	}

	// 'pw_clickElement' method used to click the element
	public PW_PageBase pw_clickElement(String ele)
	{
		pw_pageLoaderLogo();
		page.click(pw_autolocator(ele));
		BaseTest.getTest().log(Status.INFO, "Clicked ---> " + BaseTest.logName.get());
		return this;
	}

	// 'pw_enterText' method used to enter the text
	public PW_PageBase pw_enterValue(String selector, String value)
	{
		page.fill(pw_autolocator(selector), "");
		page.fill(pw_autolocator(selector), value);
		BaseTest.getTest().log(Status.INFO, "Enter value  --->  " + BaseTest.logName.get() + " ---> <b>" + value + "</b>");
		return this;
	}

	public void pw_scrollIfNeeded(String locator)
	{
		page.locator(pw_autolocator(locator)).scrollIntoViewIfNeeded();
	}

	// 'pw_refresh' method used to refresh the page
	public void pw_refresh()
	{
		page.reload(new Page.ReloadOptions().setWaitUntil(WaitUntilState.NETWORKIDLE));
		BaseTest.getTest().log(Status.INFO, "Page refreshed");
	}

	// 'pw_sendText' method used to send the text
	public PW_PageBase pw_sendvalue(String selector, String value)
	{
		page.fill(pw_autolocator(selector), value);
		BaseTest.getTest().log(Status.INFO, "Enter value  --->  " + BaseTest.logName.get() + " ---> <b>" + value + "</b>");
		return this;
	}

	public Locator pw_findelements(String selector)
	{
		return page.locator(pw_autolocator(selector));

	}

	public void pw_customRangeCalender(int testData, String selectYear, String element)
	{
		String[] a = calendarDate(testData).replaceAll(" ", ",").split(",");
		String Day = a[0].toString().trim();
		String month = a[1].toString().trim();
		String year = a[2].toString().trim();
		pw_selectlistelements(selectYear, year);
		month = month.equals("Sept") ? "Sep" : month;
		pw_selectlistelements("Month,pw,//td[contains(@title, " + year + ")]", month);

		boolean val = false;
		Locator tableRow = page.locator(pw_autolocator(element));
		for (int i = 0; i < tableRow.count(); i++)
		{
			Locator tableColumn = tableRow.nth(i).locator("td");
			for (int j = 0; j < tableColumn.count(); j++)
			{
				String value = tableColumn.nth(j).getAttribute("class").trim();
				if (!value.contains("disabled"))
				{
					String Uidate = tableColumn.nth(j).textContent().trim();
					if (Uidate.equals(Day))
					{
						tableColumn.nth(j).click();
						val = true;
						break;
					}
				}
			}
			if (val)
			{
				BaseTest.getTest().log(Status.INFO, "clicked date is ---> " + calendarDate(testData));
				break;
			}
		}
	}

	public boolean pw_selectlistelements(String selector, String value)
	{
		Locator locator = page.locator(pw_autolocator(selector));
		boolean flag = false;
		if (locator.count() > 0)
		{
			value = value.toLowerCase().trim();
			for (int i = 0; i < locator.count(); i++)
			{
				String elementText = locator.nth(i).innerText().toLowerCase().trim();
				if (elementText.contains(value))
				{
					locator.nth(i).click();
					flag = true;
					break;
				}
			}
			if (flag)
			{
				BaseTest.getTest().log(Status.INFO, "Select list element ---> " + BaseTest.logName.get() + " ---> <b>" + value + "</b>");
				return true;
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Select list element failed ---> " + BaseTest.logName.get() + "--->" + value);
				BaseTest.takeScreenshot();
				return false;
			}
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Select list element size 0 ---> " + BaseTest.logName.get() + "--->" + value);
			return false;
		}
	}

	public boolean pw_selectAttributelements(String selector, String attributeName, String value)
	{
		Locator locator = page.locator(pw_autolocator(selector));
		boolean flag = false;
		if (locator.count() > 0)
		{
			value = value.toLowerCase().trim();
			for (int i = 0; i < locator.count(); i++)
			{
				String elementText = locator.nth(i).getAttribute(attributeName).toLowerCase().trim();
				if (elementText.contains(value))
				{
					locator.nth(i).click();
					flag = true;
					break;
				}
			}
			if (flag)
			{
				BaseTest.getTest().log(Status.INFO, "Select list element ---> " + BaseTest.logName.get() + " ---> <b>" + value + "</b>");
				return true;
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Select list element failed ---> " + BaseTest.logName.get() + "--->" + value);
				BaseTest.takeScreenshot();
				return false;
			}
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Select list element size 0 ---> " + BaseTest.logName.get() + "--->" + value);
			return false;
		}
	}

	public boolean pw_selectExactlistelements(String selector, String value)
	{
		Locator locator = page.locator(pw_autolocator(selector));
		boolean flag = false;
		if (locator.count() > 0)
		{
			for (int i = 0; i < locator.count(); i++)
			{
				String elementText = locator.nth(i).innerText();
				if (elementText.equals(value))
				{
					locator.nth(i).click();
					flag = true;
					break;
				}
			}
			if (flag)
			{
				BaseTest.getTest().log(Status.INFO, "Select list element ---> " + BaseTest.logName.get() + " ---> <b>" + value + "</b>");
				return true;
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Select list element failed ---> " + BaseTest.logName.get() + "--->" + value);
				BaseTest.takeScreenshot();
				return false;
			}
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Select list element size 0 ---> " + BaseTest.logName.get() + "--->" + value);
			return false;
		}
	}

	public boolean pw_SelectMultipleListElements(String selector, String Values)
	{
		String[] value = Values.split(",");
		int count = 0;
		pw_clickElement(selector);
		Locator locator = page.locator(pw_autolocator(DashboardRepository.pw_allpage_common_selectdropdownlist));
		if (value.length <= (locator.count() + 1))
		{
			for (int i = 0; i < value.length; i++)
			{
				String inputText = value[i].trim().replace("\u200B", "");
				for (int j = 0; j < locator.count(); j++)
				{
					String elementText = locator.nth(j).textContent().trim();
					if (elementText.equals(inputText))
					{
						locator.nth(j).click();
						count++;
						break;
					}
				}
				pw_clickElement(selector);
			}
			pw_clickTab();
			if (value.length == count)
			{
				BaseTest.getTest().log(Status.INFO, "Select all list elements ---> <b>" + Values + "</b>");
				return true;
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "Not select the all list elements ---> " + Values);
				return false;
			}
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Input value size is greater than the element size ---> " + Values);
			return false;
		}
	}

	public boolean pw_CompareMultipleListElementsValues(String selector, String Values)
	{
		String[] value = Values.split(",");
		int count = 0;
		pw_clickElement(selector);
		Locator locator = page.locator(pw_autolocator(DashboardRepository.pw_allpage_common_selectdropdownlist));
		if (value.length <= (locator.count() + 1))
		{
			for (int i = 0; i < value.length; i++)
			{
				String inputText = value[i].trim().replace("\u200B", "");
				for (int j = 0; j < locator.count(); j++)
				{
					String elementText = locator.nth(j).textContent().trim();
					if (elementText.equals(inputText))
					{
						BaseTest.getTest().log(Status.INFO, "'" + elementText + "' text is present as expected input text '" + inputText + "'");
						count++;
						break;
					}
				}
			}
			pw_clickTab();
			if (value.length == count)
			{
				BaseTest.getTest().log(Status.INFO, "All list elements is present as expected ---> <b>" + Values + "</b>");
				return true;
			} else
			{
				BaseTest.getTest().log(Status.FAIL, "All list elements is not present as expected ---> <b>" + Values + "</b>");
				return false;
			}
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Input value size is greater than the element size ---> " + Values);
			return false;
		}
	}

	public void pw_uploadFile(String selector, String filePath)
	{
		page.setInputFiles(pw_autolocator(selector), Paths.get(filePath));
		BaseTest.getTest().log(Status.INFO, "File uploaded ----> " + BaseTest.logName.get() + " ---> <b>" + filePath + "</b>");
	}

	public void pw_deselectFile(String selector)
	{
		page.setInputFiles(pw_autolocator(selector), new Path[0]);
		BaseTest.getTest().log(Status.INFO, "File deselected ----> " + BaseTest.logName.get());
	}

	public Frame pw_switchToFrameByName(String name)
	{
		return page.frame(name);
	}

	public FrameLocator pw_switchToFrameByLocator(String selector)
	{
		return page.frameLocator(pw_autolocator(selector));
	}

	public List<Frame> pw_getAllFrames()
	{
		return page.frames();
	}

	public void pw_handleAlert(String popupMessage)
	{
		page.onDialog(dialog -> {
			dialog.accept(popupMessage);
		});
		BaseTest.getTest().log(Status.INFO, "Alert handled ---> " + popupMessage);
	}

	public Page pw_openWindow()
	{
		Page window = BaseTest.browserContext.get().newPage();
		page = window;
		return page;
	}

	public Page pw_closeChildWindow_OpenOldWindow(Page newpage, Page oldpage)
	{
		newpage.close();
		page = oldpage;
		return page;
	}

	public Page clickAndSwitchWindow(String selector)
	{
		Page window = page.waitForPopup(() -> {
			page.click(pw_autolocator(selector));
		});
		return window;
	}

	public void pw_clickTab()
	{
		page.keyboard().press("Tab");
	}

	public void pw_clickEnter()
	{
		page.keyboard().press("Enter");
	}

	public void pw_dragAndDrop(String dragselector, String dropselector)
	{
		page.dragAndDrop(pw_autolocator(dragselector), pw_autolocator(dropselector));
	}

	public void pw_mouseHover(String selector)
	{
		page.hover(pw_autolocator(selector));
	}

	public void pw_doubleClick(String selector)
	{
		page.dblclick(pw_autolocator(selector));
	}

	public boolean pw_isChecked(String selector)
	{
		return page.isChecked(pw_autolocator(selector));
	}

	public boolean pw_IsDisable(String selector)
	{
		return page.isDisabled(pw_autolocator(selector));
	}

	public boolean pw_IsEnable(String selector)
	{
		return page.isEnabled(pw_autolocator(selector));
	}

	public String pw_getStrText(String selector)
	{
		String text = page.textContent(pw_autolocator(selector));
		BaseTest.getTest().log(Status.INFO, "Get Text ---> " + BaseTest.logName.get() + " ---> " + text);
		return text;
	}

	public String pw_getTextBoxVal(String selector, String attribute)
	{
		String text = page.locator(pw_autolocator(selector)).getAttribute(attribute);
		BaseTest.getTest().log(Status.INFO, "Get attribute '" + attribute + "' ---> " + BaseTest.logName.get() + " ---> '" + text + "'");
		return text;
	}

	public boolean pw_isElementPresent(String loc)
	{
		return page.locator(pw_autolocator(loc)).count() > 0;
	}

	@Override
	public void pw_writeLog(boolean expression, String passLog, String failLog)
	{
		if (expression)
		{
			BaseTest.getTest().log(Status.INFO, passLog);
			BaseTest.pw_takesScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.WARNING, failLog);
			BaseTest.pw_takesScreenshot();
		}
	}

	public void pw_clearText(Object pr)
	{
		List<Locator> locators = new ArrayList<>();

		if (pr instanceof String)
		{
			String element = String.valueOf(pr);
			locators = page.locator(element).all();
		} else if (pr instanceof Locator)
		{
			locators.add((Locator) pr);
		} else if (pr instanceof List<?>)
		{
			List<?> elements = (List<?>) pr;
			for (Object obj : elements)
			{
				if (obj instanceof Locator)
				{
					locators.add((Locator) obj);
				}
			}
		}

		for (Locator locator : locators)
		{
			if (locator != null)
			{
				while (true)
				{
					String field = locator.inputValue();
					if (field != null && !field.isEmpty())
					{
						try
						{
							locator.click();
							locator.press("Backspace", new Locator.PressOptions().setDelay(100)); // Adding slight delay for stability
						} catch (Exception e)
						{
							System.out.println("Unable to clear text");
							break;
						}
					} else
					{
						break;
					}
				}
				String placeholder = locator.getAttribute("placeholder");
				System.out.println(placeholder + " Field text has been cleared");

			} else
			{
				System.out.println("Unable to locate WebElement");
			}
		}
	}

	public boolean pw_isDisplayed(String locatorSelector, String elementName)
	{
		boolean displayed = false;
		try
		{
			Locator obj = page.locator(locatorSelector);

			displayed = obj.isVisible();

			if (displayed)
			{
				BaseTest.getTest().info("Element displayed: <b>" + elementName + "</b>, As Expected.");
			} else
			{
				BaseTest.getTest().fail("Element isn't displayed: <b>" + elementName + "</b>");
			}
		} catch (Exception e)
		{
			BaseTest.getTest().fail("Exception occurred while checking visibility of: <b>" + elementName + "</b>.");
			BaseTest.getTest().fail(e.getMessage());
		} finally
		{
			BaseTest.takeScreenshot();
		}
		return displayed;
	}

	public void pw_clickByIndex(String locatorSelector, int index)
	{
		try
		{
			Locator dropdown = page.locator(locatorSelector).nth(index);

//			dropdown.selectOption(new SelectOption().setIndex(index));
			dropdown.click();

			BaseTest.getTest().info("Selected option at index: " + index + " from dropdown: <b>" + locatorSelector + "</b>");
		} catch (Exception e)
		{
			BaseTest.getTest().warning("Failed to select option at index: " + index + " from dropdown: <b>" + locatorSelector + "</b>");
			BaseTest.getTest().warning(e.getMessage());
		}
	}

	public boolean pw_ElementPresent(String selector)
	{
		try
		{
			Locator element = page.locator(selector);

			if (element.count() > 0)
			{
				return true;
			}
			return false;
		} catch (PlaywrightException e)
		{
			page.waitForLoadState(LoadState.LOAD);
		}
		return false;
	}

	public ArrayList<Object> pw_filehandle()
	{
		ArrayList<Object> obj = new ArrayList<>();
		StringBuilder output = new StringBuilder();
		threadSleep(ObjectRepository.wait5sec);
		threadSleep(ObjectRepository.wait3sec);
		long lineCount = 0;
		File path = new File(System.getProperty("user.dir") + "/src\\main\\resources\\data\\downloadedFile\\");
		File[] files = path.listFiles();
		for (File file : files)
		{
			String str = file.getName();
			if (file.exists())
			{
				try
				{
					if (str.endsWith(".txt") || str.endsWith(".csv"))
					{
						FileReader fr = new FileReader(file);
						BufferedReader reader = new BufferedReader(fr);
						String line;

						while ((line = reader.readLine()) != null)
						{
							output.append(line);
							output.append(System.getProperty("line.separator"));
							lineCount++;
						}
						reader.close();
					}
				} catch (IOException e)
				{
					e.printStackTrace();
				} finally
				{
					threadSleep(ObjectRepository.wait5sec);
					file.delete();
					BaseTest.getTest().log(Status.INFO, "The downloaded file has been deleted :" + str);
				}
			} else
			{
				BaseTest.getTest().log(Status.INFO, "File not found");
			}
		}
		obj.add(lineCount);
		obj.add(output.toString());
		return obj;
	}

	public void pw_toolTipValidationKnownText(String element, String text)
	{
		page.locator(pw_autolocator(element)).hover();
		String toolTipText = pw_getStrText(DashboardRepository.pw_allpage_tooltip);
		if (toolTipText.equals(text))
		{
			BaseTest.getTest().log(Status.INFO, text + " tool tip is validated successfully");
			BaseTest.pw_takesScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, text + " tool tip is not shown as expected.");
			BaseTest.pw_takesScreenshot();
		}

	}
}