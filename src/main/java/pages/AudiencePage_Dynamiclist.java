package pages;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

import repository.AudienceRepository;
import repository.CommunicationRepository;
import repository.DashboardRepository;
import repository.ObjectRepository;
import repository.WebmailRepository;
import utility.BaseTest;
import utility.ExtentManager;
import utility.PageFactory;

public class AudiencePage_Dynamiclist extends HomePage
{

	String trgtlistname;
	String dynamicListId;
	String decodedId;

	public AudiencePage_Dynamiclist(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	// Add new dynamic list
	public String addNewDynamicListNameandTriggerType()

	{
		String EnterDynamiclistName = BaseTest.getData().EnterDynamiclistName + addTimeToName().replaceAll("_", "");
		if(EnterDynamiclistName.length()>50)
		{   
			String temp = EnterDynamiclistName;
			EnterDynamiclistName="";
			for (int i = 0; i <=50-1; i++)
			{
				EnterDynamiclistName=EnterDynamiclistName+temp.charAt(i);
			}
		}
		pageLoaderLogo();
		clickElement(AudienceRepository.audience_dynamic_newdynamiclist);
		pageLoaderLogo();
		explicitwaitforclick(autolocator(AudienceRepository.audience_dynamic_dynamiclistname), 20);
		pageLoaderLogo();

		clickElement(AudienceRepository.audience_dynamic_dynamiclistname);
		threadSleep(ObjectRepository.wait1sec);
		enterValue(AudienceRepository.audience_dynamic_dynamiclistname, EnterDynamiclistName);
		threadSleep(ObjectRepository.wait1sec);
		Actions key = new Actions(driver);
		key.sendKeys(Keys.TAB).build().perform();
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait5sec);
		clickElement(AudienceRepository.audience_dynamic_selecttrigger);
		selectlistelements(AudienceRepository.audience_dynamic_entertrigger, BaseTest.getData().SelectTrigger);
		return EnterDynamiclistName;
	}

	public AudiencePage_Dynamiclist selectTriggerValues()
	{
		pageLoaderLogo();
		explicitwaitforclick(autolocator(AudienceRepository.audience_dynamic_selecttriggertype), 40);
		clickElement(AudienceRepository.audience_dynamic_selecttriggertype);
		threadSleep(ObjectRepository.wait1sec);
		if (!selectlistelementsAndProceed(AudienceRepository.audience_dynamic_entertriggertype, BaseTest.getData().TriggerTypeNew))
		{
			selectlistelements(AudienceRepository.audience_dynamic_entertriggertype, BaseTest.getData().TriggerTypeOld);
		}
		return this;
	}

	// trigger Campaign Name
	public AudiencePage_Dynamiclist triggerCommunicationName()
	{
		selectTriggerValues();
		threadSleep(ObjectRepository.wait1sec);
		clickElement(AudienceRepository.audience_dynamic_commtriggerselect);
		selectlistelements(AudienceRepository.audience_dynamic_entercommtrigger, BaseTest.getData().TriggerTypeInputOne);
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforclick(autolocator(AudienceRepository.audience_dynamic_g2triggeraction), 40);
		clickElement(AudienceRepository.audience_dynamic_g2triggeraction);
		selectlistelements(AudienceRepository.audience_dynamic_getriggeractionenter, BaseTest.getData().TriggerTypeInputTwo);
		return this;
	}

	// Trigger Type Browser
	public AudiencePage_Dynamiclist triggerWebsite()
	{
		clickElement(AudienceRepository.audience_dynamic_clickdomainname);
		selectlistelements(AudienceRepository.audience_dynamic_selecttriggerdropdown, BaseTest.getData().DomainUrl);
		selectTriggerValues();
		explicitwaitforclick(autolocator(AudienceRepository.audience_dynamic_selecttriggervalue1), 30);
		clickElement(AudienceRepository.audience_dynamic_selecttriggervalue1);
		selectlistelements(AudienceRepository.audience_dynamic_entertriggervalue1, BaseTest.getData().TriggerTypeInputOne);
		selectTriggerFilter();
		return this;
	}

	// Trigger type Facebook
	public AudiencePage_Dynamiclist triggerFacebook()
	{
		clickElement(AudienceRepository.audience_dynamic_Facebooktriggertype);
		selectlistelements(AudienceRepository.audience_dynamic_Facebooktriggerdropdown, BaseTest.getData().TriggerTypeNew);
		explicitwaitforclick(autolocator(AudienceRepository.audience_dynamic_Facebooktriggertype2), 30);
		clickElement(AudienceRepository.audience_dynamic_Facebooktriggertype2);
		selectlistelements(AudienceRepository.audience_dynamic_Facebooktriggerdropdown2, BaseTest.getData().TriggerTypeOld);
		return this;
	}

	// Trigger type Twitter
	public AudiencePage_Dynamiclist triggerTwitter()
	{
		clickElement(AudienceRepository.audience_dynamic_Facebooktriggertype);
		selectlistelements(AudienceRepository.audience_dynamic_Facebooktriggerdropdown, BaseTest.getData().TriggerTypeNew); // BaseTest.getData().DomainUrl
		explicitwaitforclick(autolocator(AudienceRepository.audience_dynamic_Facebooktriggertype2), 30);
		clickElement(AudienceRepository.audience_dynamic_Facebooktriggertype2);
		selectlistelements(AudienceRepository.audience_dynamic_Facebooktriggerdropdown2, BaseTest.getData().TriggerTypeOld); // BaseTest.getData().TriggerTypeInputOne
		clickElement(AudienceRepository.audience_dynamic_addnewlist);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.audience_dynamic_edittriggertype1);
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(AudienceRepository.audience_dynamic_twittertriggerdropdown1, BaseTest.getData().TriggerTypeInputOne);
		clickElement(AudienceRepository.audience_dynamic_twittertriggertype1);
		selectlistelements(AudienceRepository.audience_dynamic_Facebooktriggerdropdown2, BaseTest.getData().TriggerTypeInputTwo);
		return this;

	}

	// Trigger type Location
	public AudiencePage_Dynamiclist triggerLocation()
	{
		clickElement(AudienceRepository.audience_dynamic_Facebooktriggertype);
		selectlistelements(AudienceRepository.audience_dynamic_Facebooktriggerdropdown2, BaseTest.getData().TriggerTypeNew); // BaseTest.getData().DomainUrl
		explicitwaitforclick(autolocator(AudienceRepository.audience_dynamic_Facebooktriggertype2), 30);
		clickElement(AudienceRepository.audience_dynamic_Facebooktriggertype2);
		selectlistelements(AudienceRepository.audience_dynamic_Facebooktriggerdropdown2, BaseTest.getData().TriggerTypeInputOne); // BaseTest.getData().TriggerTypeInputOne
		clickElement(AudienceRepository.audience_dynamic_Facebooktriggertype2);
		selectlistelements(AudienceRepository.audience_dynamic_Facebooktriggerdropdown2, BaseTest.getData().TriggerTypeInputTwo);
		return this;
	}

	// Trigger type Weather
	public AudiencePage_Dynamiclist triggerWeather()
	{
		clickElement(AudienceRepository.audience_dynamic_Facebooktriggertype);
		selectlistelements(AudienceRepository.audience_dynamic_Facebooktriggerdropdown2, BaseTest.getData().TriggerTypeNew);
		explicitwaitforclick(autolocator(AudienceRepository.audience_dynamic_Weathercheckbox), 30);
		enterValue(AudienceRepository.audience_dynamic_Weathercheckbox, BaseTest.getData().TriggerTypeOld);
		return this;
	}

	// Trigger type Persona
	public AudiencePage_Dynamiclist triggerPersona()
	{
		clickElement(AudienceRepository.audience_dynamic_Facebooktriggertype);
		selectlistelements(AudienceRepository.audience_dynamic_Facebooktriggerdropdown2, BaseTest.getData().TriggerTypeNew);
		return this;
	}

	// Trigger type Two way SMS
	public AudiencePage_Dynamiclist triggerTwowaySms()
	{
		clickElement(AudienceRepository.audience_dynamic_Facebooktriggertype);
		selectlistelements(AudienceRepository.audience_dynamic_Facebooktriggerdropdown2, BaseTest.getData().TriggerTypeNew); // BaseTest.getData().DomainUrl
		explicitwaitforclick(autolocator(AudienceRepository.audience_dynamic_Facebooktriggertype2), 30);
		clickElement(AudienceRepository.audience_dynamic_Facebooktriggertype2);
		selectlistelements(AudienceRepository.audience_dynamic_Facebooktriggerdropdown2, BaseTest.getData().TriggerTypeOld); // BaseTest.getData().TriggerTypeInputOne
		return this;
	}

	// Trigger type Adobe trigger
	public AudiencePage_Dynamiclist triggerAdobeTrigger()
	{
		clickElement(AudienceRepository.audience_dynamic_Facebooktriggertype);
		selectlistelements(AudienceRepository.audience_dynamic_Facebooktriggerdropdown2, BaseTest.getData().TriggerTypeNew);
		explicitwaitforclick(autolocator(AudienceRepository.audience_dynamic_abodecheckbox), 20);
		clickElement(AudienceRepository.audience_dynamic_abodecheckbox);
		selectlistelements(",xpath,//div[@class='selectize-dropdown-content']//div", BaseTest.getData().TriggerTypeOld);
		return this;
	}

	// Select Match Type
	public AudiencePage_Dynamiclist matchType(String type)
	{
		threadSleep(ObjectRepository.wait1sec);
		if (type.equalsIgnoreCase("all") && !isSelected(AudienceRepository.audience_dynamic_matchtypeallcondition))
		{
			clickElement(AudienceRepository.audience_dynamic_matchtypeallcondition);
		}
		if (type.equalsIgnoreCase("any") && !isSelected(AudienceRepository.audience_dynamic_matchtypeanycondition))
		{
			clickElement(AudienceRepository.audience_dynamic_matchtypeanycondition);
		}
		return this;
	}

	// Select Mandate
	public AudiencePage_Dynamiclist addMandate()
	{
		explicitwaitforpresence(autolocator(AudienceRepository.audience_dynamic_addmandate), 30);
		// String name = Audience.audience_dynamic_addmandate;
		clickElement(AudienceRepository.audience_dynamic_addmandate);
		return this;
	}

	// Select Mandate other options2
	public AudiencePage_Dynamiclist addMandate2()
	{
		explicitwaitforpresence(autolocator(AudienceRepository.audience_dynamic_addmandate2), 30);
		clickElement(AudienceRepository.audience_dynamic_addmandate2);
		return this;
	}

	// Select Mandate other options3
	public AudiencePage_Dynamiclist addMandate3()
	{
		explicitwaitforpresence(autolocator(AudienceRepository.audience_dynamic_addmandate3), 30);
		clickElement(AudienceRepository.audience_dynamic_addmandate3);
		return this;
	}

	// Select Mandate other options4
	public AudiencePage_Dynamiclist addMandate4()
	{
		explicitwaitforpresence(autolocator(AudienceRepository.audience_dynamic_addmandate4), 30);
		clickElement(AudienceRepository.audience_dynamic_addmandate4);
		return this;
	}

	// Match Type Any Trigger Condition
	public AudiencePage_Dynamiclist triggerCondition(String val)
	{
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforclick(autolocator(AudienceRepository.audience_dynamic_entertriggercondition), 30);
		clickElement(AudienceRepository.audience_dynamic_entertriggercondition);
		enterValue(AudienceRepository.audience_dynamic_entertriggercondition, val);
		return this;
	}

	// Select Trigger Mobile
	public AudiencePage_Dynamiclist triggerMobApp(String app)
	{
		threadSleep(ObjectRepository.wait5sec);
		clickElement(AudienceRepository.audience_dynamic_clickappname);
		// explicitwaitforclick(autolocator(AudienceRepository.audience_dynamic_selectappnamedropdown), 30);
		threadSleep(ObjectRepository.wait10sec);
		selectlistelements(AudienceRepository.audience_dynamic_selectappnamedropdown, app);
		return this;

	}

	// Trigger Mobile App
	public AudiencePage_Dynamiclist triggerSourceRuleType(String rule, String type, String value) throws InterruptedException
	{
		/*
		 * clickElement(AudienceRepository.audience_dynamic_clickappname);
		 * selectlistelements(AudienceRepository.audience_dynamic_selectappnamedropdown, BaseTest.getData().TriggerTypeNew);
		 */
		// selectTriggerValues();
		threadSleep(ObjectRepository.wait5sec);
		clickElement(AudienceRepository.audience_dynamic_ruletype_dropdownclick);
		threadSleep(ObjectRepository.wait5sec);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, rule);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.audience_dynamic_ruletype_typeclick);
		threadSleep(ObjectRepository.wait5sec);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, type);
		// selectlistelements(AudienceRepository.audience_dynamic_ruletype_typeselect, type);
		clickElement(AudienceRepository.audience_dynamic_ruletype_valueclick);
		threadSleep(ObjectRepository.wait5sec);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, value);
		/*
		 * clickElement(AudienceRepository.audience_dynamic_selectmobileact); threadSleep(ObjectRepository.wait1sec);
		 * enterValue(AudienceRepository.audience_dynamic_selectmobileact, BaseTest.getData().TriggerTypeNew);
		 * selectlistelements("Mobile act,xpath,//div[@class='selectize-dropdown-content']/div", BaseTest.getData().TriggerTypeNew);
		 * selectTriggerFilter();
		 */
		return this;

	}
	
	public AudiencePage_Dynamiclist triggerSourceRuleTypeValue(String rule, String type, String value) throws InterruptedException
	{
		
		threadSleep(ObjectRepository.wait5sec);
		clickElement(AudienceRepository.audience_dynamic_ruletype_dropdownclick);
		threadSleep(ObjectRepository.wait5sec);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, rule);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.audience_dynamic_ruletype_type);
		threadSleep(ObjectRepository.wait5sec);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, type);
		threadSleep(ObjectRepository.wait5sec);
		clickElement(AudienceRepository.audience_dynamic_ruletype_value);
		threadSleep(ObjectRepository.wait5sec);
		driver.switchTo().activeElement().sendKeys(value);
        //sendValue(AudienceRepository.audience_dynamic_ruletype_value, value);		
		return this;
	}


	public AudiencePage_Dynamiclist triggerFormRuleType(String rule, String type, String value) throws InterruptedException
	{
		/*
		 * clickElement(AudienceRepository.audience_dynamic_clickappname);
		 * selectlistelements(AudienceRepository.audience_dynamic_selectappnamedropdown, BaseTest.getData().TriggerTypeNew);
		 */
		// selectTriggerValues();
		threadSleep(ObjectRepository.wait5sec);
		clickElement(AudienceRepository.audience_dynamic_ruletype_dropdownclick);
		threadSleep(ObjectRepository.wait5sec);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, rule);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait5sec);
		clickElement(AudienceRepository.audience_dynamic_ruletype_formclick);
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, type);
		// selectlistelements(AudienceRepository.audience_dynamic_ruletype_typeselect, type);
		clickElement(AudienceRepository.audience_dynamic_ruletype_formvalueclick);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait5sec);

		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, value);
		/*
		 * clickElement(AudienceRepository.audience_dynamic_selectmobileact); threadSleep(ObjectRepository.wait1sec);
		 * enterValue(AudienceRepository.audience_dynamic_selectmobileact, BaseTest.getData().TriggerTypeNew);
		 * selectlistelements("Mobile act,xpath,//div[@class='selectize-dropdown-content']/div", BaseTest.getData().TriggerTypeNew);
		 * selectTriggerFilter();
		 */
		return this;

	}

	
	// Trigger Form
	public AudiencePage_Dynamiclist triggerSubForm()
	{
		selectTriggerValues();
		explicitwaitforclick(autolocator(AudienceRepository.audience_dynamic_dlsubform), 60);
		clickElement(AudienceRepository.audience_dynamic_dlsubform);
		selectlistelements("Form type,xpath,//*[@id='SFddl1_listbox']/li", BaseTest.getData().TriggerTypeInputOne);
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforclick(autolocator(AudienceRepository.audience_dynamic_selectsubformaction), 60);
		clickElement(AudienceRepository.audience_dynamic_selectsubformaction);
		selectlistelements(AudienceRepository.audience_dynamic_subformaction, BaseTest.getData().TriggerTypeInputTwo);
		return this;
	}

	public AudiencePage_Dynamiclist triggerAudBaseString()
	{
		threadSleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.audience_dynamic_selectaudbase);
		sendValue(AudienceRepository.audience_dynamic_selectaudbase, BaseTest.getData().TriggerTypeInputOne);
		selectlistelements(AudienceRepository.audience_dynamic_enteraudbase, BaseTest.getData().TriggerTypeInputOne);
		selectTriggerFilter();
		return this;
	}

	// Edit Trigger type
	// Trigger type 2
	/*
	 * public AudiencePage_Dynamiclist edittriggertype(String val) { threadSleep(ObjectRepository.wait1sec);
	 * explicitwaitforclick(autolocator(Audience.audience_dynamic_edittriggertype), 40); clickElement(Audience.audience_dynamic_edittriggertype);
	 * threadSleep(ObjectRepository.wait1sec); selectlistelements(Audience.audience_dynamic_entertriggertype, val); return this; }
	 */
	// Save Trigger
	public AudiencePage_Dynamiclist clickCreateAndSaveTrigger()
	{
		// String listName = EnterDynamiclistName;
		threadSleep(ObjectRepository.wait3sec);
		javaScriptScrollDown();
		clickElement(AudienceRepository.audience_dynamic_createrule);
		pageLoaderLogo();
		explicitwaitforclick(autolocator(AudienceRepository.audience_dynamic_newdynamiclist), 50);
		threadSleep(ObjectRepository.wait5sec);
		/*
		 * String firstListName =
		 * getStrText("First list name,xpath,(//div[contains(@class,'targetListPageCSS')]//div[@class='rci-list-name']//span)[1]"); if
		 * (firstListName.equals(EnterDynamiclistName)) { BaseTest.getTest().log(Status.INFO, "Dynamic List Created Successfully");
		 * BaseTest.takeScreenshot(); } else { BaseTest.getTest().log(Status.FAIL, "Dynamic List Creation Failed"); }
		 * threadSleep(ObjectRepository.wait10sec);
		 */
		return this;
	}

	// Select time frequency
	public AudiencePage_Dynamiclist selecttimefreq()
	{

		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforclick(autolocator(AudienceRepository.audience_dynamic_clicktimefreq), 50);
		clickElement(AudienceRepository.audience_dynamic_clicktimefreq);
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(AudienceRepository.audience_dynamic_selecttimefreq, BaseTest.getData().DateRangeFilter);

		return this;
	}

	public void rfaSettingsAllFunction(boolean isheirarchyOn)
	{
		clickElement(AudienceRepository.audience_target_approvalsettings);
		threadSleep(ObjectRepository.wait1sec);
		clickElement(AudienceRepository.audience_target_approvefromall);
		if (isheirarchyOn)
		{
			clickElement(AudienceRepository.audience_target_heirarchySelect);
			threadSleep(ObjectRepository.wait3sec);
			BaseTest.getTest().log(Status.INFO, "Click on rfa app settings icon, click on Get Approval from 'All' in app settings with heirarchy OFF and save");
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Click on  rfa app settings icon, click on Get Approval from 'All' in app settings with heirarchy OFF and save");
		}
		clickElement(AudienceRepository.audience_target_selectsave);

	}

	// Edit dynamic list
	public AudiencePage_Dynamiclist editDynamicist()
	{
		threadSleep(ObjectRepository.wait3sec);
		pageLoaderLogo();
		clickElement(
				"edit icon,xpath, (//div[contains(@class,'targetListPageCSS')]//div[@class='rci-list-name']//span)[1]/ancestor::div[@class='rs-card-bottom-sep rc-tl scheduled ']//descendant-or-self::div[@class='rs-tooltip-wrapper ']/i[@id='rs_data_circle_pencil']");
		pageLoaderLogo();

		String editedDynamicListName = getStrText(AudienceRepository.audience_dynamic_dynamiclistname);
		if (!editedDynamicListName.contains(EnterDynamiclistName))
		{
			BaseTest.getTest().log(Status.INFO, "Edited Dynamic list name differs from actual input");
			BaseTest.takeScreenshot();
		}
		clickElement(AudienceRepository.audience_dynamic_editlistoption);

		String triggerType = getStrText(AudienceRepository.audience_dynamic_editedtriggerType);
		if (!triggerType.contains(BaseTest.getData().SelectTrigger))
		{
			BaseTest.getTest().log(Status.INFO, "Edited Dynamic list trigger type differs from actual input");
		}
		String listSrc = getStrText(AudienceRepository.audience_dynamic_editedtriggervalue);
		if (!listSrc.contains(BaseTest.getData().TriggerTypeNew))
		{
			BaseTest.getTest().log(Status.INFO, "Edited Dynamic list trigger value differs from actual input");
			BaseTest.takeScreenshot();
		} else if (!listSrc.contains(BaseTest.getData().TriggerTypeOld))
		{
			BaseTest.getTest().log(Status.INFO, "Edited Dynamic list trigger value differs from actual input");
		}
		BaseTest.takeScreenshot();
		// clickElement(AudienceRepository.audience_dynamic_editlistoption);
		// String name = getStrText(AudienceRepository.audience_dynamic_dynamiclistname);
		String name = getTextBoxVal(AudienceRepository.audience_dynamic_dynamiclistname, "value");
		for (int i = 0; i < name.length(); i++)
		{
			findElements(AudienceRepository.audience_dynamic_dynamiclistname).get(0).sendKeys(Keys.BACK_SPACE);
		}
		EnterDynamiclistName = BaseTest.getData().EnterDynamiclistName + "Edit" + addTimeToName().replaceAll("_", "");
		sendValue(AudienceRepository.audience_dynamic_dynamiclistname, EnterDynamiclistName);
		javaScriptScrollDownToSomeExtend();
		clickElement(AudienceRepository.audience_dynamic_editedupdate);
		pageLoaderLogo();
		return this;
	}

	private boolean getAttribute(String audienceDynamicDynamiclistname, String string)
	{
		// TODO Auto-generated method stub
		return false;
	}

	// Click to duplciate list
	public AudiencePage_Dynamiclist duplicateDynamicList(String dynamicListName, String duplicatename)
	{
		threadSleep(ObjectRepository.wait3sec);
		// h5/span[contains(text(),'Dymctrgt23115179')]/../../..//li[@data-original-title='Duplicate']
		clickElement("Duplicate icon,xpath,//h5/span[contains(text(),'" + dynamicListName + "')]/../../..//li[@data-original-title='Duplicate']");
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_target_enterdupname), 30);
		enterValue(AudienceRepository.audience_target_enterdupname, duplicatename);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.audience_target_savedupname);
		threadSleep(ObjectRepository.wait3sec);
		driver.navigate().refresh();
		return this;
	}

	public AudiencePage_Dynamiclist duplicateDynamic(String DynamicDuplicate) throws InterruptedException
	{
		explicitwaitforvisibility(autolocator(AudienceRepository.dynamic_threedoticon), 30);
		clickElement(AudienceRepository.dynamic_threedoticon);
		Thread.sleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.dynamic_duplicateicon);
		String name = getTextBoxVal(AudienceRepository.dynamic_enterduplicatedynamicename, "value");
		for (int i = 0; i < name.length(); i++)
		{
			findElements(AudienceRepository.dynamic_enterduplicatedynamicename).get(0).sendKeys(Keys.BACK_SPACE);
		}
		enterValue(AudienceRepository.dynamic_enterduplicatedynamicename, DynamicDuplicate);
		tabAction();
		Thread.sleep(ObjectRepository.wait5sec);
		clickElement(AudienceRepository.dynamic_duplicate_save);

		return this;

	}

	// Compare value
	public AudiencePage_Dynamiclist comparevalue(String act, String exp)
	{

		threadSleep(ObjectRepository.wait3sec);
		String value = "//span[contains(.,'" + act + "')]";
		WebElement obj = driver.findElement(By.xpath(value));
		// assertEqual(act, exp);
		if (act == exp)
		{
			BaseTest.takeScreenshot();
			BaseTest.getTest().log(Status.INFO, "Value Equals");
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Value is not Equal");
		}
		return this;
	}

	// Add Icon
	public AudiencePage_Dynamiclist selectAddIcon()
	{
		threadSleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.audience_dynamic_addnewlist);
		return this;
	}

	// Add Edit Icon
	public AudiencePage_Dynamiclist selectAddEditIcon()
	{
		threadSleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.audience_dynamic_addneweditlist);
		return this;
	}

	public AudiencePage_Dynamiclist rfaAddIcon()
	{
		javaScriptScrollDown();
		threadSleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.dynamic_creation_Rfa_Addicon);
		return this;
	}

	// Regression Edit
	public AudiencePage_Dynamiclist commAddTrigger(String val)
	{
		threadSleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.audience_dynamic_edittriggertype1);
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(AudienceRepository.audience_dynamic_entertriggertype2, val);
		return this;
	}

	// Regression Edit Trigger 3
	public AudiencePage_Dynamiclist commAddTrigger3(String val)
	{
		threadSleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.audience_dynamic_edittriggertype1);
		BaseTest.getTest().log(Status.INFO, "Clicked to Select trigger Type");
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(AudienceRepository.audience_dynamic_entertriggertype3, val);
		return this;
	}

	// Regression Edit Trigger 4
	public AudiencePage_Dynamiclist commAddTrigger4(String val)
	{
		threadSleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.audience_dynamic_edittriggertype1);
		BaseTest.getTest().log(Status.INFO, "Clicked to Select trigger Type");
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(AudienceRepository.audience_dynamic_entertriggertype4, val);

		return this;
	}

	// Duplicate edit
	public AudiencePage_Dynamiclist dupEdit(String editname)
	{
		threadSleep(ObjectRepository.wait3sec);
		explicitwaitforclick(autolocator(AudienceRepository.audience_dynamic_editnameicon), 30);
		clickElement(AudienceRepository.audience_dynamic_editnameicon);
		threadSleep(ObjectRepository.wait1sec);
		explicitwaitforclick(autolocator(AudienceRepository.audience_dynamic_editname), 30);
		enterValue(AudienceRepository.audience_dynamic_editname, editname);
		tab();
		javaScriptScrollDown();
		threadSleep(ObjectRepository.wait1sec);
		return this;
	}

	// Approver settings
	// Two Approver

	public AudiencePage_Dynamiclist appsettingsany(String val)
	{

		threadSleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.audience_dynamic_approvalsettings);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.audience_target_selectAny);
		BaseTest.getTest().log(Status.INFO, "click on Any Approver option");
		threadSleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.audience_target_selectanydrpdown);
		BaseTest.getTest().log(Status.INFO, "click on Any approver dropdown option");
		selectlistelements(AudienceRepository.audience_target_enteranydrpdown, val);
		threadSleep(ObjectRepository.wait1sec);
		clickElement(AudienceRepository.audience_target_selectsave);
		BaseTest.getTest().log(Status.INFO, "Click on app settings save button");
		return this;
	}

	// Select 3rd approver
	public AudiencePage_Dynamiclist thirdDynamicapprover(String val)
	{

		threadSleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.audience_dynamic_addapprover2);
		threadSleep(ObjectRepository.wait1sec);
		clickElement(AudienceRepository.audience_dynamic_selectapprover2);
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(AudienceRepository.audience_dynamic_enterapprover3, val);

		return this;
	}

	// Select 2nd approver
	public AudiencePage_Dynamiclist secondDynamicapprover(String val)
	{
		clickElement(AudienceRepository.dynamic_creation_dynamic_approval2click);
		threadSleep(ObjectRepository.wait5sec);
		/*
		 * clickElement(AudienceRepository.audience_dynamic_selectapprover2); threadSleep(ObjectRepository.wait1sec);
		 */
		selectlistelements(AudienceRepository.dynamic_creation_dynamic_approval2select, val);
		return this;
	}

	// Select Approver mail
	public AudiencePage_Dynamiclist firstDynamicApprover(String val)
	{
		threadSleep(ObjectRepository.wait5sec);
		clickElement(AudienceRepository.audience_dynamic_rfachkbox);
		threadSleep(ObjectRepository.wait5sec);
		javaScriptScrollDown();
		clickElement(AudienceRepository.audience_dynamic_approvalto);
		threadSleep(ObjectRepository.wait1sec);
		selectlistelements(AudienceRepository.audience_dynamic_approver, val);
		return this;
	}

	public void selectTriggerFilter()
	{
		explicitwaitforclick(autolocator(AudienceRepository.audience_dynamic_triggercondition), 10);
		clickElement(AudienceRepository.audience_dynamic_triggercondition);
		selectlistelements(AudienceRepository.audience_dynamic_selectcondition, "Contains");
	}

	public void valueRemove(String pr)
	{
		WebElement obj = driver.findElement(autolocator(pr));
		obj.clear();
		BaseTest.getTest().log(Status.INFO, BaseTest.logName.get());
	}

	public void searchDynamicListUsingListName(String listname)
	{
		threadSleep(ObjectRepository.wait1sec);
		clickElement(AudienceRepository.audience_dynamic_searchicon);
		threadSleep(ObjectRepository.wait1sec);
		explicitwaitforclick(autolocator(AudienceRepository.audience_dynamic_enterlistname), 20);
		enterValue(AudienceRepository.audience_dynamic_enterlistname, listname);
		threadSleep(ObjectRepository.wait5sec);
		pageLoaderLogo();
		selectlistelements(AudienceRepository.audience_dynamic_listnamedropdown, listname);
		threadSleep(ObjectRepository.wait1sec);
		clickElement(AudienceRepository.audience_dynamic_afterentervaluesearch);
		threadSleep(ObjectRepository.wait10sec);
		String firstListName = getStrText("First list name,xpath,(//div[contains(@class,'targetListPageCSS')]//div[@class='rci-list-name']//span)[1]");
		if (listname.equals(firstListName))
		{
			BaseTest.getTest().log(Status.INFO, "Able to search the dynamic list");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "Unable to search the dynamic list due to the page is loading for a long time");
			BaseTest.takeScreenshot();
		}

	}

	public void getListDetailes()
	{
		mouseHover("List Name,xpath,(//div[@class='col-sm-4'])//div[@class='rci-list-name']");
		ListName = getStrText(DashboardRepository.allpage_tooltip);
		explicitwaitforvisibility(autolocator("Created By,xpath,(//div[@class='col-sm-4'])//span[@class='rct-cb']//span[2]"), 30);
		createdby = getStrText("Created By,xpath,(//div[@class='col-sm-4'])//span[@class='rct-cb']//span[2]");
		// explicitwaitforvisibility(autolocator("(//div[@class='col-sm-4'])//i[contains(@class,'icon-rs-user-pending-medium')]"), 30);
		mouseHover("Status,xpath,(//div[@class='col-sm-4'])//i[contains(@class,'icon-rs-user-pending-medium')]");
		status = getStrText(DashboardRepository.allpage_tooltip);

	}

	public void advancedsearch()
	{
		explicitwaitforclick(autolocator(AudienceRepository.audience_target_searchIcon), 30);
		threadSleep(ObjectRepository.wait2sec);
		clickElement(AudienceRepository.audience_target_searchIcon);
		explicitwaitforclick(autolocator(AudienceRepository.audience_target_searchExpandIcon), 30);
		clickElement(AudienceRepository.audience_target_searchExpandIcon);
		explicitwaitforclick(autolocator(AudienceRepository.audience_target_advancedSearchdropdown), 30);
		clickElement(AudienceRepository.audience_target_advancedSearchlistname);
		enterValue(AudienceRepository.audience_target_advancedSearchlistname, ListName);
		pageLoaderLogo();
		selectlistelementsAndProceed("dropdown,xpath,//div[@class='box-design box-design css-scrollbar no-box-shadow p10']//ul//li", ListName);
		enterValue(AudienceRepository.audience_target_advancedSearchcratedby, createdby);
		pageLoaderLogo();
		selectlistelementsAndProceed("dropdown,xpath,//div[@class='box-design box-design css-scrollbar no-box-shadow p10']//ul//li", createdby);
		clickElement(AudienceRepository.audience_target_advancedSearchlisttype);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, "All list");
		String statusvalue = null;
		if (status.contains("Approved"))
		{
			statusvalue = "Approved";
		} else if (status.contains("Pending for approval"))
		{
			statusvalue = "Not Approved";
		}
		clickElement(AudienceRepository.audience_target_advancedSearchapprovalstatue);
		selectlistelements(DashboardRepository.allpage_common_selectdropdownlist, statusvalue);
		BaseTest.takeScreenshot();
		clickElement("search,xpath,//button[@type='submit']");
		pageLoaderLogo();
		mouseHover("List Name,xpath,(//div[@class='col-sm-4'])//div[@class='rci-list-name']");
		if (ListName.equals(getStrText(DashboardRepository.allpage_tooltip)))
		{
			BaseTest.getTest().info("Advanced Search Functionality is working as expected");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().fail("Advanced Search Functionality not is working as expected");
			BaseTest.takeScreenshot();
		}

	}

	public void moreInfoValidation()
	{
		threadSleep(ObjectRepository.wait2sec);
		clickElement("List view,xpath,//i[@class='icon-circle-list-medium icon-md']");
		if (isDisplayed("Dynamic List gridname,xpath,//div[@id='dlistpartial']//a[.='List name']"))
		{
			BaseTest.getTest().log(Status.INFO, "Dynamic list view page navigate as expected");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Dynamic list view page is unable to navigate");
			BaseTest.takeScreenshot();
		}
		clickElement("Grid view,xpath,//i[@class='icon-circle-grid-medium icon-md hide']");
		// selectAlltimeDateRange();
		String listname = "Dymctrgt1111211078";
		searchDynamicListUsingListName(listname);
		threadSleep(ObjectRepository.wait2sec);
		String[] linkedcomm = getStrText(AudienceRepository.audience_dynamic_linkedcomm).split(" ");
		String linkedcommcount = linkedcomm[2];
		threadSleep(ObjectRepository.wait2sec);
		clickElement(AudienceRepository.audience_dynamic_moreinfo);
		threadSleep(ObjectRepository.wait2sec);
		String styleCheck = getTextBoxVal("Dynamiclist check,xpath,//div[@id='dimOutPageLS'][contains(@style,'display')]", "style");
		compareUiwithInputvalue(styleCheck, "block");
		String[] moreinfolinkedcomm = getStrText(AudienceRepository.audience_dynamic_moreinfolinkedcomm).split("\\(");
		String[] splitmoreinfolinkedcomm = moreinfolinkedcomm[1].split("\\)");
		String moreinfolinkedcommcount = splitmoreinfolinkedcomm[0];
		if (linkedcommcount.equals(moreinfolinkedcommcount))
		{
			List<WebElement> linkedcommname = findElements(AudienceRepository.audience_dynamic_linkedcommname);
			int size = linkedcommname.size();
			for (WebElement commname : linkedcommname)
			{
				String linkedcommunicationname = commname.getText();
				BaseTest.getTest().log(Status.INFO, "Linked communication Name ---->" + linkedcommunicationname);
			}
			BaseTest.getTest().log(Status.INFO, "Total linked communication count : " + size);
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Dynamic list Segment box linked communication count " + linkedcommcount + " was mismatched the more-info linked communication count " + moreinfolinkedcommcount);
			BaseTest.takeScreenshot();
		}
	}

	public AudiencePage_Dynamiclist clickApprovalSettings() throws InterruptedException
	{
		Thread.sleep(ObjectRepository.wait10sec);
		clickElement(AudienceRepository.audience_dynamic_approvalsettings);
		explicitwaitforvisibility(autolocator(AudienceRepository.dynamic_creation_approvalsettingsdialoguebox), 30);
		if (isDisplayed(AudienceRepository.dynamic_creation_approvalsettingsdialoguebox))
		{
			BaseTest.getTest().log(Status.INFO, "Request approval setting dialogue box is displayed");

		} else
		{
			BaseTest.getTest().log(Status.INFO, "Request approval settings dialogue box is not accesible");
		}
		return this;

	}

	public AudiencePage_Dynamiclist verifyApprovalSettingsAnyvalue() throws InterruptedException
	{
		if (isSelected(AudienceRepository.dynamic_creation_approvalsettings_radio_all))
		{
			BaseTest.getTest().log(Status.INFO, "Request approval settings All option is enabled");
		}
		{
			clickElement(AudienceRepository.dynamic_creation_approvalsettings_radio_any);
			clickElement(AudienceRepository.dynamic_creation_approvalsettings_radio_any_dropdownclick);
			explicitwaitforclick(autolocator(AudienceRepository.dynamic_creation_approvalsettings_radio_any_dropdownselect), 30);
			clickElement(AudienceRepository.dynamic_creation_approvalsettings_radio_any_dropdownselect);
			clickElement(AudienceRepository.dynamic_creation_Rfa_settings_save);
			javaScriptScrollDown();
			clickElement(AudienceRepository.audience_dynamic_approvalsettings);
			if (isEnabled(AudienceRepository.dynamic_creation_approvalsettings_radio_any))
			{
				BaseTest.getTest().log(Status.INFO, "Request approval settings any option is retained");
			} else
			{
				BaseTest.getTest().log(Status.INFO, "Request approval settings any option is retained");
			}

			clickElement(AudienceRepository.dynamic_creation_Rfa_settings_save);
			Thread.sleep(ObjectRepository.wait10sec);
			javaScriptScrollDown();
			clickElement(AudienceRepository.audience_dynamic_approvalsettings);
			Thread.sleep(ObjectRepository.wait5sec);
			if (isEnabled(AudienceRepository.dynamic_creation_approvalsettings_radio_any))
			{
				BaseTest.getTest().log(Status.INFO, "Request approval settings any option is enabled");
			}
		}
		return this;
	}

	public AudiencePage_Dynamiclist verifyApprovalSettingsOnOffValue() throws InterruptedException
	{

		if (!isSelected(AudienceRepository.dynamic_creation_approvalsettings_radio_all))
		{
			BaseTest.getTest().log(Status.INFO, "Request approval settings All option is disabled");
			clickElement(AudienceRepository.dynamic_creation_approvalsettings_radio_all);
			BaseTest.getTest().log(Status.INFO, "Request approval settings All option turning on");

			if (isElementAvailable(AudienceRepository.dynamic_creation_approvalsettings_followhierarchy_inoff)) // -check hierarchy is off
			{
				BaseTest.getTest().log(Status.INFO, "Request approval settings Follow hierarchy is tunrned off");
				Thread.sleep(ObjectRepository.wait5sec);
				clickElement(AudienceRepository.dynamic_creation_approvalsettings_followhierarchy_All_turnoff); // turning on
				BaseTest.getTest().log(Status.INFO, "Request approval settings Follow hierarchy is tunring on");
				clickElement(AudienceRepository.dynamic_creation_Rfa_settings_save);
				Thread.sleep(ObjectRepository.wait5sec);
				javaScriptScrollDown();
				clickElement(AudienceRepository.audience_dynamic_approvalsettings);
				if (isEnabled(AudienceRepository.dynamic_creation_approvalsettings_followhierarchy_All_turnoff))
				{
					BaseTest.getTest().log(Status.INFO, "Follow hierarchy ON option is retained");
				} else
				{
					BaseTest.getTest().log(Status.INFO, "Follow hierarchy ON option is not retained properly");
				}
			}
		}

		return this;
	}

	// Select Dynamiclist link from menu
	public AudiencePage_Dynamiclist clickDynamiclistlinkfromMenu()
	{
		threadSleep(ObjectRepository.wait5sec);
		clickAudiencelink();
		clickElement(DashboardRepository.homepage_audience_DynamicList);
		BaseTest.getTest().info(MarkupHelper.createLabel("AUDIENCE DYNAMIC LIST PAGE ", ExtentColor.BLUE));
		pageLoaderLogo();
		return getPageFactory().Audiencepagedynamiclist();
	}

	public void clickNewRule()
	{
		explicitwaitforclick(autolocator(AudienceRepository.dynamic_creation_newrule_typeclick), 10);
		actionScrollToElement(AudienceRepository.dynamic_creation_newrule_typeclick);
		clickElement(AudienceRepository.dynamic_creation_newrule_typeclick);
	}

	public AudiencePage_Dynamiclist ruleType()
	{
		threadSleep(ObjectRepository.wait5sec);
		clickElement(AudienceRepository.dynamic_creation_ruletype_click);
		threadSleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_ruletype_select, "Browser");
		clickElement(AudienceRepository.dynamic_creation_rule_type_click);
		threadSleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_rule_type_select, "Contains");
		threadSleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.dynamic_creation_ruletype_values_click);
		threadSleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_ruletype_values_select, "Chrome");

		return this;

	}

	public AudiencePage_Dynamiclist pw_dynamicName() throws InterruptedException
	{
		String EnterDynamiclistName = BaseTest.getData().EnterDynamiclistName + addTimeToName().replaceAll("_", "");
		return pw_dynamicName();

	}

	public String pw_enterListName()
	{
		trgtlistname = BaseTest.getData().EnterDynamiclistName + addTimeToName().replaceAll("_", "");
		pw_clickElement(AudienceRepository.pw_audienceDynamicListName);
		// page.getByPlaceholder(" ", new Page.GetByPlaceholderOptions().setExact(true)).click();
		page.getByPlaceholder(" ", new Page.GetByPlaceholderOptions().setExact(true)).fill(trgtlistname);
		page.getByPlaceholder(" ", new Page.GetByPlaceholderOptions().setExact(true)).press("Tab");
		page.waitForSelector("#ju1xiqt-aria+rect", new Page.WaitForSelectorOptions().setState(WaitForSelectorState.HIDDEN));
		return trgtlistname;
	}

	public AudiencePage_Dynamiclist pw_CreatedList(String dynamicList)
	{

		// driver.findElement(By.xpath("//table[@style='display: table;']"));
		List<WebElement> list = driver.findElements(By.xpath("//table[@style='display: table;']//tr/td[1]"));
		for (WebElement dynamic : list)
		{
			String listName = dynamic.getText();
			System.out.println(listName);
			if (listName.equals(dynamicList))
			{
				System.out.println("Created dynamic list is updated -->" + dynamicList);
				BaseTest.getTest().log(Status.INFO, "Created dynamic list is updated -->" + dynamicList);
			} else
			{
				System.out.println("Created dynamic list is not updated -->");
			}
		}
		return this;
	}

	public List<Map<String, String>> pw_validateGridView()
	{
		pw_selectCustomRange(-5, 0);
		int page = 1;
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		while (true)
		{
			List<WebElement> listNames = findElements(AudienceRepository.audience_gridview_listName);

			for (int count = 0; count < listNames.size(); count++)
			{
				Map<String, String> map = new LinkedHashMap<>();
				listNames = findElements(AudienceRepository.audience_gridview_listName);
				String listName = listNames.get(count).getText();
				if (listName.contains("..."))
				{
					mouseHover(listNames.get(count));
					listName = getStrText(DashboardRepository.allpage_tooltip);
				}
				map.put("List name", listName);
				map.put("Created on", findElements(AudienceRepository.audience_gridview_createdon).get(count).getText().replaceAll("On:", "").trim());

				map.put("Created by", findElements(AudienceRepository.audience_gridview_createdby).get(count).getText().replaceAll(",", "").trim());
				String segName = findElements(AudienceRepository.audience_gridview_segmentationaudience).get(count).getText().trim();
				map.put("Seg. audience", !segName.contains("Calculating") && !segName.contains("List extraction is in progress") ? segName.split(":")[1].trim() : "0");
				map.put("Commu. sent", listName.equals("All audience") ? "0" : findElements(AudienceRepository.audience_gridview_communicationexecuted).get(page == 1 ? count - 1 : count).getText());
				map.put("Average/Projected reach rate", findElements(AudienceRepository.audience_gridview_AverageAndProjectedReachRate).get(count).getText());
				list.add(map);
			}
			threadSleep(ObjectRepository.wait1sec);
			javaScriptScrollDown();
			if (!isElementPresent(AudienceRepository.audience_synchist_lastButton) && page == 1)
			{
				BaseTest.getTest().log(Status.INFO, "This is first page, Pagination is not present as expected.");
				BaseTest.takeScreenshot();
				break;
			} else if (!isElementPresent(AudienceRepository.audience_synchist_lastButton) && page != 1)
			{
				BaseTest.getTest().log(Status.INFO, "This is not a first page,but pagination is not present");
				BaseTest.takeScreenshot();
				break;
			} else
			{
				if (findElement(AudienceRepository.audience_synchist_lastButton).getAttribute("class").contains("disabled"))
				{
					break;
				} else
				{
					javaScriptScrollDown();
					BaseTest.getTest().log(Status.INFO, "Page No : " + page);
					driver.findElement(autolocator(AudienceRepository.audience_synchist_nextButton)).click();
					pageLoaderLogo();
					page++;
				}
			}
		}
		ExtentManager.customReport(list);
		System.out.println(list);
		return list;

	}

	public void pw_clickTargetListingListView()
	{
		toolTipValidationKnownText(AudienceRepository.audience_listview_listIcon, "List view");
		clickElement(AudienceRepository.audience_listview_listIcon);
		pageLoaderLogo();
	}

	public List<Map<String, String>> pw_validateListView()
	{
		pw_clickTargetListingListView();
		pw_selectCustomRange(-5, 0);
		int page = 1;
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		while (true)
		{
			List<Map<String, String>> tableData = targetListingTable();
			list.addAll(tableData);
			threadSleep(ObjectRepository.wait1sec);
			javaScriptScrollDown();
			if (!isElementPresent(AudienceRepository.audience_synchist_lastButton) && page == 1)
			{
				BaseTest.getTest().log(Status.INFO, "This is first page, Pagination is not present as expected.");
				BaseTest.takeScreenshot();
				break;
			} else if (!isElementPresent(AudienceRepository.audience_synchist_lastButton) && page != 1)
			{
				BaseTest.getTest().log(Status.INFO, "This is not a first page,but pagination is not present");
				BaseTest.takeScreenshot();
				break;
			} else
			{
				if (findElement(AudienceRepository.audience_synchist_lastButton).getAttribute("class").contains("disabled"))
				{
					break;
				} else
				{
					javaScriptScrollDown();
					BaseTest.getTest().log(Status.INFO, "Page No : " + page);
					driver.findElement(autolocator(AudienceRepository.audience_synchist_nextButton)).click();
					pageLoaderLogo();
					page++;
				}
			}
		}
		ExtentManager.customReport(list);
		System.out.println(list);
		return list;
	}

	public void pw_selectCustomRange(int startDate, int endDate)
	{
		page.waitForLoadState(LoadState.LOAD);
		clickElement(DashboardRepository.datefilter);
		clickElement(DashboardRepository.datefilter_customrange);
		customRangeCalender(startDate, "lefttable");
		customRangeCalender(endDate, "righttable");
		clickElement(DashboardRepository.apply_button);
	}

	public boolean pw_customRangeCalender(String pickDate)
	{
		String[] a = calendarDate(0).replaceAll(" ", ",").split(",");
		String Day = a[0].toString().trim();
		String month = a[1].toString().substring(0, 3).trim();
		String year = a[2].toString().trim();
		String yearLocator = "Year,xpath,//td[@title='" + year + "']";
		String monthLocator = "Month,xpath,//td[@title='" + year + " " + month + "']";
		clickElement("Calendar title,xpath,//span[@class='k-button-text']");
		clickElement("Calendar Year title,xpath,//span[@class='k-button-text']");
		boolean val = false;
		if (!getTextBoxVal(yearLocator, "class").contains("disable") && selectlistelementsAndProceed(yearLocator, year) && !getTextBoxVal(monthLocator, "class").contains("disable") && selectlistelementsAndProceed(monthLocator, month))
		{
			WebElement table = driver.findElement(autolocator("calendar table,xpath,(//*[@class='k-calendar-tbody'])[1]"));
			List<WebElement> tableRow = table.findElements(By.tagName("tr"));
			for (WebElement ele : tableRow)
			{
				List<WebElement> tableColumn = ele.findElements(By.tagName("td"));
				for (WebElement cell : tableColumn)
				{
					String Uidate = cell.getText().trim();
					if (Uidate.equals(Day))
					{
						String value = cell.getAttribute("class").trim();
						if (!value.contains("disabled"))
						{
							cell.click();
							val = true;
							break;
						} else
						{
							BaseTest.getTest().log(Status.INFO, "Selected day has disabled mode");
							BaseTest.takeScreenshot();
							return false;
						}
					}
				}
				if (val)
				{
					BaseTest.getTest().log(Status.INFO, "clicked date is ---> " + calendarDate(Integer.parseInt(pickDate)));
					break;
				}
			}
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Selected date has disabled mode");
			BaseTest.takeScreenshot();
		}
		return val;
	}

	@Override
	public void pw_toolTipValidationKnownText(String element, String text)
	{
		mouseHover(element);
		String toolTipText = getStrText(DashboardRepository.allpage_tooltip);
		if (toolTipText.equals(text))
		{
			BaseTest.getTest().log(Status.INFO, text + " tool tip is validated successfully");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, text + " tool tip is not shown as expected.");
			BaseTest.takeScreenshot();
		}
	}

	public void pw_toolTipValidationRandomText(String element, String functionName)
	{
		mouseHover(element);
		if (isDisplayed(DashboardRepository.allpage_tooltip))
		{
			BaseTest.getTest().log(Status.INFO, functionName + " tool tip is validated successfully");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, functionName + " tool tip is not shown as expected.");
			BaseTest.takeScreenshot();
		}
	}

	public void dynamicListApproveRFAUser(String enterDynamiclistName, String WebmailUserName, String WebmailPassword, String ApproverPassword, String action)
	{
		logout();
		webURLlaunch();
		accountKeyUserWebmailLoginUser(WebmailUserName, WebmailPassword);
		String rfalink = getRFAApprovalMailLink(enterDynamiclistName);
		webMailDelete();
		loginPage();
		login(WebmailUserName, ApproverPassword, WebmailPassword);
		driver.get(rfalink);
		// Verifying approve, reject and cancel button
		threadSleep(ObjectRepository.wait3sec);
		pageLoaderLogo();
		javaScriptScrollDown();
		String Approve = getStrText("Approve Button,xpath,//*[@id='dl_approve_button']");
		String Reject = getStrText("Reject Button,xpath,//*[@id='dl_reject_button']");
		String Cancel = getStrText("Cancel Button,xpath,//*[@id='dl_cancel_button']");
		uiPageEqualswithInputValue("Cancel", Cancel);
		uiPageEqualswithInputValue("Reject", Reject);
		uiPageEqualswithInputValue("Approve", Approve);
		if (action.equalsIgnoreCase("approve"))
		{
			clickDynamicRFAApproveBtn();
		} else if (action.equalsIgnoreCase("reject"))
		{
			clickDynamicRFARejectBtn();
		}
		threadSleep(ObjectRepository.wait5sec);
	}

	public OtpPage accountKeyUserWebmailLoginUser(String username, String password)
	{
		webmailLogin(username, password);
		return this;
	}

	public String getRFAApprovalMailLink(String targetListName)
	{
		String link = null;
		if (rfaCheckExactMail("vbnk71 : Request for Dynamic list approval", targetListName))
		{
			threadSleep(ObjectRepository.wait3sec);
			explicitwaitforclick(autolocator(WebmailRepository.audience_target_textview), 30);
			clickElement(WebmailRepository.audience_target_textview);
			threadSleep(ObjectRepository.wait5sec);
			javaScriptScrollDownToSomeExtend();
			explicitwaitforpresence(autolocator(WebmailRepository.audience_target_selectlink), 30);
			link = getStrText(WebmailRepository.audience_target_selectlink);
			BaseTest.getTest().log(Status.INFO, "Approver link : " + link);
		}
		return link;
	}

	public LoginPage loginPage()
	{
		threadSleep(ObjectRepository.wait2sec);
		driver.get(System.getProperty("web_url"));
		BaseTest.getTest().log(Status.INFO, "Web Url is : " + driver.getCurrentUrl());
		if (isElementPresent("Close Icon,xpath,//i[contains(@class,'circle-close')]"))
		{
			clickElement("Close Icon,xpath,//i[contains(@class,'circle-close')]");

		} else
		{
			BaseTest.getTest().log(Status.INFO, "Close Icon is disable.");
		}
		return this;
	}

	public HomePage login(String username, String pwd, String webmailPswd)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("SMARTDX LOGIN PAGE", ExtentColor.GREEN));
		try
		{
			explicitwaitforclick(autolocator(AudienceRepository.loginpage_proceed), 120);
			clickElement(AudienceRepository.loginpage_proceed);
		} catch (Exception e)
		{
			BaseTest.getTest().log(Status.WARNING, "Proceed popup is not displayed.");
		}
		clickExistingUser();
		BaseTest.takeScreenshot();
		enterUsername(username);
		enterPassword(pwd);
		tabAction();
		threadSleep(ObjectRepository.wait10sec);
		BaseTest.takeScreenshot();
		clickLogin();
		pageLoaderLogo();
		loginWithOTP(username, webmailPswd);
		threadSleep(ObjectRepository.wait1sec);
		return getPageFactory().homePage();
	}

	public OtpPage clickDynamicRFAApproveBtn()
	{
		threadSleep(ObjectRepository.wait3sec);
		pageLoaderLogo();
		if (isDisplayed(AudienceRepository.approveBtn))
		{
			javaScriptScrollDown();
			threadSleep(ObjectRepository.wait2sec);
//			javaScriptScrollDownToSomeExtend();
//			threadSleep(ObjectRepository.wait2sec);
//			explicitwaitforclick(autolocator(DashboardRepository.approveBtn), 60);
			clickElement(AudienceRepository.approveBtn);
			pageLoaderLogo();
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "RFA approve button not appeared");
			BaseTest.takeScreenshot();
		}
		threadSleep(ObjectRepository.wait3sec);
		pageLoaderLogo();
		return this;
	}

	public OtpPage clickDynamicRFARejectBtn()
	{
		threadSleep(ObjectRepository.wait3sec);
		pageLoaderLogo();
		if (isDisplayed(AudienceRepository.rejectBtn))
		{
			javaScriptScrollIntoView(AudienceRepository.rejectBtn);
			threadSleep(ObjectRepository.wait3sec);
			clickElement(AudienceRepository.rejectBtn);
			threadSleep(ObjectRepository.wait3sec);
			pageLoaderLogo();
			BaseTest.takeScreenshot();
			sendValue(AudienceRepository.rejectCommentBox, "RFA Approver Reject");
			clickElement(AudienceRepository.rejectCommentBoxRejectButton);
			pageLoaderLogo();
			threadSleep(ObjectRepository.wait3sec);

		} else
		{
			BaseTest.getTest().log(Status.FAIL, "RFA reject button not appeared");
			BaseTest.takeScreenshot();
		}
		threadSleep(ObjectRepository.wait3sec);
		pageLoaderLogo();
		return this;
	}

	public HomePage loginWithOTP(String uname, String upswrd)
	{
		String loginOtp = null;
		if (isElementPresent(AudienceRepository.loginpage_Otp_textbox))
		{
			BaseTest.takeScreenshot();
			explicitwaitforpresence(autolocator(AudienceRepository.loginpage_Otp_textbox), 90);
			loginOtp = getOtpFromWebmail(uname, upswrd);
			explicitwaitforpresence(autolocator(AudienceRepository.loginpage_Otp_textbox), 10);
			enterValue(AudienceRepository.loginpage_Otp_textbox, loginOtp);
			BaseTest.takeScreenshot();
			tabAction();
			pageLoaderLogo();
			BaseTest.takeScreenshot();
//			String confirmButton = getTextBoxVal(LoginRepository.loginpage_otp_confirm, "class");
//			if (!confirmButton.contains("off")) {
//				BaseTest.getTest().log(Status.INFO, "Enter login by using Webmail OTP.");
//				pageLoaderLogo();
//				BaseTest.takeScreenshot();
//				clickElement(LoginRepository.loginpage_otp_confirm);
//			} else {
//				enterloginDefaultOtp();
//			}
		} else
		{
			BaseTest.getTest().log(Status.INFO, "OTP not required.");
			BaseTest.takeScreenshot();
		}
		return getPageFactory().homePage();
	}

	public String getOtpFromWebmail(String uname, String upswrd)
	{
		OtpPage otpPage = new OtpPage(driver, page, pageFactory);
		String parentWinHandle = parentWinHandle();
		javaScriptopenNewWindow();
		switchWindow();
		otpPage.webURLlaunch();
		otpPage.webmailLogin(uname, upswrd);
		String loginOtp = otpPage.getLoginWebmailOTP();
		childWindowClose(parentWinHandle);
		switchParentWin(parentWinHandle);
		pageLoaderLogo();
		return loginOtp;
	}

	public void clickMoreInfoIcon(String targetList)
	{
		try
		{
			toolTipValidationKnownText("target list more info,xpath,//span[.='" + targetList + "']//ancestor::div[contains(@class,'rs-card-bottom')]//i[contains(@id,'info')]", "Info");
			driver.findElement(By.xpath("//span[.='" + targetList + "']//ancestor::div[contains(@class,'rs-card-bottom')]//i[contains(@id,'info')]")).click();
			BaseTest.getTest().log(Status.INFO, "More info icon is clicked");
			pageLoaderLogo();
		} catch (Exception e)
		{
			BaseTest.getTest().log(Status.FAIL, "Not able to click info icon");
		}
		BaseTest.takeScreenshot();
	}

	public void dynamicListMoreInfoValidation(Map<String, String> listDetails)
	{
		// Listing page list details
		String createdByName = listDetails.get("Created by");
		String createdDateAndTime = listDetails.get("Created Date&Time").toLowerCase();
		String linkedCommunication = listDetails.get("LinkedCommunication").split(":")[1].trim();
		String segCount = listDetails.get("SegmentationCount").split(":")[1].trim();

		// More info list details
		String moreInfoCreatedByName = driver.findElement(autolocator(AudienceRepository.audience_target_moreinfoNameAndDate)).getText().split(",")[0].split(":")[1].trim();
		String moreInfoCreatedDateAndTime = driver.findElement(autolocator(AudienceRepository.audience_target_moreinfoNameAndDate)).getText().split(moreInfoCreatedByName + ",")[1].toLowerCase().trim();
		String moreInfoLinkedCommunication = driver.findElements(autolocator(AudienceRepository.audience_target_moreinfolinkedCommAndSegCount)).get(0).getText().split("\\(")[1].split("\\)")[0];
		// String moreInfoSegCount =
		// driver.findElements(autolocator(AudienceRepository.audience_target_moreinfolinkedCommAndSegCount)).get(1).getText().split("\\(")[1].split("\\)")[0];

		writeLog(moreInfoCreatedByName.equals(createdByName), "List created name and more info created name '" + createdByName + "' is present as expected.",
				"List created name and more info created name '" + createdByName + "' is not-present as expected.");
		writeLog(moreInfoCreatedDateAndTime.equals(createdDateAndTime), "List created date&time and more info created date & time '" + createdDateAndTime + "' is present as expected.",
				"List created date & time and more info created date & time '" + createdDateAndTime + "' is not-present as expected.");
		writeLog(moreInfoLinkedCommunication.equals(linkedCommunication), "List linked communication count and more info linked communication count '" + linkedCommunication + "' is present as expected.",
				"List linked communication count and more info linked communication count '" + linkedCommunication + "' is not-present as expected.");
		// writeLog(moreInfoSegCount.equals(segCount), "List segmentation count and more info segmentation count '" + segCount + "' is present as
		// expected.",
		// "List segmentation count and more info segmentation count '" + segCount + "' is not-present as expected.");
	}

	public void filterDynamicListTimePeriod()
	{
		/*
		 * threadSleep(ObjectRepository.wait3sec); explicitwaitforclick(autolocator(AudienceRepository.allmenu_targetlist), 30);
		 * clickElement(AudienceRepository.allmenu_targetlist);
		 */
		threadSleep(ObjectRepository.wait1sec);
		explicitwaitforclick(autolocator(AudienceRepository.audience_target_clicktimefreq), 30);
		clickElement(AudienceRepository.audience_target_clicktimefreq);
		threadSleep(ObjectRepository.wait3sec);
		selectlistelements(AudienceRepository.audience_target_selecttimefreq, BaseTest.getData().DateRangeFilter);
		if (BaseTest.getData().DateRangeFilter.contains("Custom range"))
		{
			clickElement(AudienceRepository.audience_target_timefreqmonthselect);
			selectlistelements(AudienceRepository.audience_target_timefreqmonthenter, "June");
			clickElement(AudienceRepository.audience_target_timefreqfirstdateselect);
			clickElement(AudienceRepository.audience_target_customfilterclickapply);
		}
		threadSleep(ObjectRepository.wait3sec);
	}

	public AudiencePage_Dynamiclist getDynamicListId()
	{
		dynamicListId = getStrText(AudienceRepository.audience_dynamic_listid);
		return this;
	}

	public AudiencePage_Dynamiclist dynamicIddecode()
	{

		javaScriptopenNewWindow();
		driver.get("https://www.base64decode.org/");
		enterValue("encode,xpath,//textarea[@id='input']", dynamicListId);
		javaScriptScrollDownToSomeExtend();
		clickElement("encode submit,xpath, //button[@id='submit_text']");
		decodedId = getStrText("get decoded id,xpath,//textarea[@id='output']");
		System.out.println(decodedId + "decoded id");
		return this;
	}

	public AudiencePage_Dynamiclist dynamicIdValidation() throws InterruptedException
	{

		javaScriptScrollDown();
		clickDynamiclistlinkfromMenu();
		searchDynamicList(BaseTest.getData().EnterDynamiclistName);
		threadSleep(ObjectRepository.wait3sec);
		pageLoaderLogo();
		clickElement("edit icon,xpath,//i[@id='rs_data_circle_pencil']");
		pageLoaderLogo();
		String listIdUrl = driver.getCurrentUrl();
		System.out.println(listIdUrl);
		BaseTest.getTest().log(Status.INFO, listIdUrl + "List id URL");
		if (listIdUrl.contains(decodedId))
		{
			System.out.println(decodedId + "List id matches");
			BaseTest.getTest().log(Status.INFO, decodedId + "dynamicIdValidation");
		}
		return this;
	}

	public AudiencePage_Dynamiclist listingPageElements()
	{
		List<WebElement> dynamicElements = findElements("dynamic list,xpath, //ul[@class=' rs-list-group-horizontal']/li/div");
		for (int i = 0; i < dynamicElements.size(); i++)
		{
			String dynamicEle = dynamicElements.get(i).getAttribute("class");
			System.out.println("Availble elements in dynamic listing page" + dynamicEle);
		}
		return this;
	}

	public AudiencePage_Dynamiclist cancelFunctionality()
	{

		threadSleep(ObjectRepository.wait5sec);
		clickElement(AudienceRepository.audience_dynamic_newdynamiclist);
		pageLoaderLogo();
		if (isDisplayed(AudienceRepository.audience_dynamic_header))
		{
			BaseTest.getTest().log(Status.INFO, "Navigated to dynamic create page");
		} else
		{
			BaseTest.getTest().log(Status.WARNING, "It's not navigated to dynamic create page when clicking on create page");
		}
		clickElement("cancel,xpath,//button[(text()='Cancel')]");
		pageLoaderLogo();
		if (isDisplayed(AudienceRepository.audience_header))
		{
			System.out.println("cancel functionality is working fine");
			BaseTest.getTest().log(Status.INFO, "Cancel functionality is working fine");
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Cancel functionality is not working");
		}

		return this;

	}

	public List<Map<String, String>> targetListingTable()
	{
		List<Map<String, String>> list = new LinkedList<>();
		WebElement table = findElement("Table Loc,tag,table");
		List<WebElement> headers = table.findElements(By.tagName("th"));
		List<WebElement> rows = table.findElements(By.xpath("//tbody//tr"));

		for (int j = 0; j < rows.size(); j++)
		{
			headers = table.findElements(By.tagName("th"));
			rows = table.findElements(By.xpath("//tbody//tr"));
			Map<String, String> map = new LinkedHashMap<>();
			List<WebElement> datas = rows.get(j).findElements(By.tagName("td"));

			int headerSize = headers.size();
			int dataSize = datas.size();
			int missingDataCount = headerSize - dataSize;

			for (int i = 0; i < headerSize; i++)
			{
				datas = rows.get(j).findElements(By.tagName("td"));
				String head = headers.get(i).getText();
				if (i < missingDataCount)
				{
					map.put(head, "");
				} else
				{
					String dataValue = datas.get(i - missingDataCount).getText();
					if (dataValue.contains("...") && head.equals("List name"))
					{
						mouseHover(datas.get(i - missingDataCount));
						dataValue = getStrText(DashboardRepository.allpage_tooltip);
					}
					map.put(head, dataValue);
				}
			}
			list.add(map);
		}
//		BaseTest.getTest().log(Status.INFO, list.toString());
		ExtentManager.customReport(list);
		return list;
	}

	// Fronick
	public AudiencePage_Dynamiclist clickCreateAndSaveTrigger(String EnterDynamiclistName)
	{
		// String listName = EnterDynamiclistName;
		threadSleep(ObjectRepository.wait3sec);
		javaScriptScrollDown();
		clickElement(AudienceRepository.audience_dynamic_createrule);
		pageLoaderLogo();
//		explicitwaitforclick(autolocator(AudienceRepository.audience_dynamic_newdynamiclist), 50);
//		threadSleep(ObjectRepository.wait1sec);
//		String DynamiclistingPageName = EnterDynamiclistName.substring(0, 14).trim();
//		String firstListName = getStrText("First list name,xpath,(//div[contains(@class,'targetListPageCSS')]//div[@class='rci-list-name']//span)[1]");
//		if (firstListName.contains(DynamiclistingPageName))
//		{
//			BaseTest.getTest().log(Status.INFO, "Dynamic List Created Successfully");
//			BaseTest.takeScreenshot();
//		} else
//		{
//			BaseTest.getTest().log(Status.FAIL, "Dynamic List Creation Failed");
//		}
		threadSleep(ObjectRepository.wait10sec);
		return this;
	}

	// Fronick
	public AudiencePage_Dynamiclist ruleTypeMobile() throws InterruptedException
	{
		Thread.sleep(ObjectRepository.wait5sec);
		clickElement(AudienceRepository.dynamic_creation_ruletype_click);
		Thread.sleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_ruletype_select, "App install");
		clickElement(AudienceRepository.dynamic_creation_rule_type_click);
		Thread.sleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_rule_type_select, "Contains");
		Thread.sleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.dynamic_creation_ruletype_values_click);
		Thread.sleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_ruletype_values_select, "Yes");
		return this;
	}

	public AudiencePage_Dynamiclist editDynamicList(String DynamiclistName) throws InterruptedException
	{
		threadSleep(ObjectRepository.wait3sec);
		pageLoaderLogo();

//		clickElement(
//				"edit icon,xpath, (//div[contains(@class,'targetListPageCSS')]//div[@class='rci-list-name']//span)[1]/ancestor::div[@class='rs-card-bottom-sep rc-tl scheduled ']//descendant-or-self::div[@class='rs-tooltip-wrapper ']/i[@id='rs_data_circle_pencil']");

		ListEditIcon(DynamiclistName);
		pageLoaderLogo();
		clickElement(AudienceRepository.audience_dynamic_newdynamiclist);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait5sec);
		ruleType2();
		javaScriptScrollIntoView(AudienceRepository.audience_dynamic_updaterule);
		clickElement(AudienceRepository.audience_dynamic_updaterule);

		String DynamiclistingPageName = DynamiclistName.substring(0, 14).trim();

		pageLoaderLogo();
		explicitwaitforclick(autolocator(AudienceRepository.audience_dynamic_newdynamiclist), 50);
		threadSleep(ObjectRepository.wait1sec);
		String firstListName = getStrText("First list name,xpath,(//div[contains(@class,'targetListPageCSS')]//div[@class='rci-list-name']//span[contains(.,'" + DynamiclistingPageName + "')])");
		if (firstListName.contains(DynamiclistingPageName))
		{
			BaseTest.getTest().log(Status.INFO, "Dynamic List Edited Successfully");
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Dynamic List Edition Failed");
		}
		threadSleep(ObjectRepository.wait10sec);

		return this;
	}

	public void ListEditIcon(String domainame)
	{
		domainame = domainame.substring(0, 14).trim();
		String xpath = "ListEditIcon,xpath,//div[@class='rci-list-name']//span[contains(.,'" + domainame + "')]//..//..//..//..//..//..//i[@id='rs_data_circle_pencil']";
		explicitwaitforclick(autolocator(xpath), 90);
		clickElement(xpath);
	}

	public AudiencePage_Dynamiclist ruleType2() throws InterruptedException
	{
		Thread.sleep(ObjectRepository.wait5sec);
		clickElement(AudienceRepository.dynamic_creation_ruletype2_click);
		Thread.sleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_ruletype_select, "Browser");
		clickElement(AudienceRepository.dynamic_creation_rule2_type_click);
		Thread.sleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_rule_type_select, "Is equal to");
		Thread.sleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.dynamic_creation_ruletype2_values_click);
		Thread.sleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_ruletype_values_select, "Safari");
		return this;
	}

	public AudiencePage_Dynamiclist ruleType3() throws InterruptedException
	{
		Thread.sleep(ObjectRepository.wait5sec);
		clickElement(AudienceRepository.dynamic_creation_ruletype3_click);
		Thread.sleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_ruletype_select, "Browser");
		clickElement(AudienceRepository.dynamic_creation_rule3_type_click);
		Thread.sleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_rule_type_select, "Does not contain");
		Thread.sleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.dynamic_creation_ruletype3_values_click);
		Thread.sleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_ruletype_values_select, "Mozilla");
		return this;
	}

	public AudiencePage_Dynamiclist ruleType4() throws InterruptedException
	{
		actionScrollToElement(AudienceRepository.dynamic_creation_ruletype4_click);
		Thread.sleep(ObjectRepository.wait5sec);
		clickElement(AudienceRepository.dynamic_creation_ruletype4_click);
		Thread.sleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_ruletype_select, "Browser");
		clickElement(AudienceRepository.dynamic_creation_rule4_type_click);
		Thread.sleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_rule_type_select, "Is not equal to");
		Thread.sleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.dynamic_creation_ruletype4_values_click);
		Thread.sleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_ruletype_values_select, "IE");
		return this;
	}

	public AudiencePage_Dynamiclist ruleType5() throws InterruptedException
	{
		actionScrollToElement(AudienceRepository.dynamic_creation_ruletype5_click);
		Thread.sleep(ObjectRepository.wait5sec);
		clickElement(AudienceRepository.dynamic_creation_ruletype5_click);
		Thread.sleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_ruletype_select, "Device");
		clickElement(AudienceRepository.dynamic_creation_rule5_type_click);
		Thread.sleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_rule_type_select, "Is not equal to");
		Thread.sleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.dynamic_creation_ruletype5_values_click);
		Thread.sleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_ruletype_values_select, "Mobile");
		return this;
	}

	public AudiencePage_Dynamiclist ruleType6() throws InterruptedException
	{
		actionScrollToElement(AudienceRepository.dynamic_creation_ruletype6_click);
		Thread.sleep(ObjectRepository.wait5sec);
		clickElement(AudienceRepository.dynamic_creation_ruletype6_click);
		Thread.sleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_ruletype_select, "Device");
		clickElement(AudienceRepository.dynamic_creation_rule6_type_click);
		Thread.sleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_rule_type_select, "Contains");
		Thread.sleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.dynamic_creation_ruletype6_values_click);
		Thread.sleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_ruletype_values_select, "Desktop");
		return this;
	}

	public AudiencePage_Dynamiclist ruleType7() throws InterruptedException
	{
		actionScrollToElement(AudienceRepository.dynamic_creation_ruletype7_click);
		Thread.sleep(ObjectRepository.wait5sec);
		clickElement(AudienceRepository.dynamic_creation_ruletype7_click);
		Thread.sleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_ruletype_select, "Device");
		clickElement(AudienceRepository.dynamic_creation_rule7_type_click);
		Thread.sleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_rule_type_select, "Is equal to");
		Thread.sleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.dynamic_creation_ruletype7_values_click);
		Thread.sleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_ruletype_values_select, "Tablet");
		return this;
	}

	public AudiencePage_Dynamiclist ruleType8() throws InterruptedException
	{
		actionScrollToElement(AudienceRepository.dynamic_creation_ruletype8_click);
		Thread.sleep(ObjectRepository.wait5sec);
		clickElement(AudienceRepository.dynamic_creation_ruletype8_click);
		Thread.sleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_ruletype_select, "Language");
		clickElement(AudienceRepository.dynamic_creation_rule8_type_click);
		Thread.sleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_rule_type_select, "Is equal to");
		Thread.sleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.dynamic_creation_ruletype8_values_click);
		Thread.sleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_ruletype_values_select, "English");
		return this;
	}

	public AudiencePage_Dynamiclist listingPageVerify()
	{
		if (!isDisplayed("dynamic list page,xpath, //*[text()='No data available']"))
		{
			BaseTest.getTest().log(Status.INFO, "Dynamic list Page shows No data available");
		} else
		{
			BaseTest.getTest().log(Status.INFO, "Dynamic list page working properly");
		}

		return this;

	}

	// *[text()='No data available']

//Dynamic - Event trigger

	public AudiencePage_Dynamiclist enternewsenderid()
	{
		threadSleep(ObjectRepository.wait3sec);
		sendValue(CommunicationRepository.communicationpage_email_Sender_id, BaseTest.getData().SenderID);
		return this;
	}

	public AudiencePage_Dynamiclist executedCommunication(String executedComm)
	{   
		String[] communicationExecuted = findElement(AudienceRepository.dynamic_communiction_executed).getText().split(": ");
		String executedCommunication = communicationExecuted[1];
		if (executedCommunication.equals("1"))
		{
			BaseTest.getTest().log(Status.PASS, "Executed communication count is displayed as expected " + "Executed communication  " + executedCommunication);
			BaseTest.takeScreenshot();
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Executed communication count is not displayed as expected " + "Executed communication  " + executedCommunication);
			BaseTest.takeScreenshot();
		}
		return this;
	}

	public AudiencePage_Dynamiclist linkedCommunication()
	{
		clickElement(AudienceRepository.dynamic_listingpage_moreifo);
		explicitwaitforclick(autolocator(AudienceRepository.dynamic_listingpage_moreifo), 30);
		Pattern pattern = Pattern.compile("\\((\\d+)\\)");
		Matcher matcher = pattern.matcher(AudienceRepository.dynamic_listingpage_moreifo);
		BaseTest.getTest().log(Status.INFO, "Communication linked in more info page" + matcher);
		return this;
	}

	public List<Map<String, String>> validateGridView()
	{
		selectCustomRange(-1, 0);
		int page = 1;
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		while (true)
		{
			List<WebElement> listNames = findElements(AudienceRepository.audience_gridview_listName);
			for (int count = 0; count < listNames.size(); count++)
			{
				Map<String, String> map = new LinkedHashMap<>();
				listNames = findElements(AudienceRepository.audience_gridview_listName);
				String listName = listNames.get(count).getText();
				if (listName.contains("..."))
				{
					mouseHover(listNames.get(count));
					listName = getStrText(DashboardRepository.allpage_tooltip);
				}
				map.put("List name", listName);
				javaScriptScrollToSomeExtend("60");
				// map.put("Created on", findElements(AudienceRepository.audience_gridview_createdon).get(count).getText().replaceAll("On:",
				// "").trim());
				map.put("Created by", findElements(AudienceRepository.audience_gridview_createdby).get(count).getText().replaceAll(",", "").trim());
				String segName = findElements(AudienceRepository.audience_gridview_segmentationaudience).get(count).getText().trim();
				map.put("Seg. audience", !segName.contains("Calculating") && !segName.contains("List extraction is in progress") ? segName.split(":")[1].trim() : "0");
				map.put("Commu. sent", findElements(AudienceRepository.audience_gridview_communicationexecuted).get(count).getText());
				// map.put("Average/Projected reach rate",
				// findElements(AudienceRepository.audience_gridview_AverageAndProjectedReachRate).get(count).getText());
				list.add(map);
			}
			threadSleep(ObjectRepository.wait1sec);
			javaScriptScrollDown();
			if (!isElementPresent(AudienceRepository.audience_synchist_lastButton) && page == 1)
			{
				BaseTest.getTest().log(Status.INFO, "This is first page, Pagination is not present as expected.");
				BaseTest.takeScreenshot();
				break;
			} else if (!isElementPresent(AudienceRepository.audience_synchist_lastButton) && page != 1)
			{
				BaseTest.getTest().log(Status.INFO, "This is not a first page,but pagination is not present");
				BaseTest.takeScreenshot();
				break;
			} else
			{
				if (findElement(AudienceRepository.audience_synchist_lastButton).getAttribute("class").contains("disabled"))
				{
					break;
				} else
				{
					javaScriptScrollDown();
					BaseTest.getTest().log(Status.INFO, "Page No : " + page);
					driver.findElement(autolocator(AudienceRepository.audience_synchist_nextButton)).click();
					pageLoaderLogo();
					page++;
				}
			}
		}
		ExtentManager.customReport(list);
		System.out.println(list);
		return list;

	}

	public Map<String, String> searchDynamicList(String val)
	{
		String listName = null;
		Map<String, String> listDetails = null;
		explicitwaitforclick(autolocator(AudienceRepository.audience_target_searchIcon), 30);
		threadSleep(200);
		pageLoaderLogo();
		clickElement(AudienceRepository.audience_target_searchIcon);
		threadSleep(200);
		pageLoaderLogo();
		explicitwaitforvisibility(autolocator(AudienceRepository.audience_FilterlistTypeBy), 10);
		clickElement(AudienceRepository.audience_FilterlistTypeBy);
		selectlistelementsAndProceed(AudienceRepository.audience_FilterlistTypeByList, "List name");
		clickElement(AudienceRepository.audience_target_entersearchvalue);
		threadSleep(200);
		pageLoaderLogo();
		enterValue(AudienceRepository.audience_target_entersearchvalue, val);
		threadSleep(ObjectRepository.wait3sec);
		pageLoaderLogo();
		threadSleep(ObjectRepository.wait3sec);
		BaseTest.takeScreenshot();
		List<WebElement> createddynamiclist = findElements(AudienceRepository.audience_target_entersearchResult);
		boolean searchResult = false;
		int count = 0;
		if (!createddynamiclist.isEmpty())
		{
			for (int j = 0; j < createddynamiclist.size(); j++)
			{
				createddynamiclist = findElements(AudienceRepository.audience_target_entersearchResult);
				WebElement dlsearchlist = createddynamiclist.get(j);
				String searchedResult = dlsearchlist.getText().toLowerCase();
				String inputVal = val.toLowerCase();
				if (searchedResult.equals(inputVal))
				{
					threadSleep(200);
					pageLoaderLogo();
					dlsearchlist.click();
					threadSleep(200);
					pageLoaderLogo();
					BaseTest.getTest().log(Status.INFO, "Search suggesion list shows expected result");
					count = j;
					searchResult = true;
					break;
				} else
				{
					if (createddynamiclist.size() - 1 == j)
					{
						BaseTest.getTest().log(Status.WARNING, inputVal + " : List not shown");
					}
				}
			}
		}
		if (searchResult)
		{
			explicitwaitforclick(autolocator(AudienceRepository.audience_target_searchIcon2), 30);
			clickElement(AudienceRepository.audience_target_searchIcon2);
			threadSleep(200);
			pageLoaderLogo();
			String segmentNamexpath = AudienceRepository.audience_compvalue;
			try
			{
				pageLoaderLogo();
				try
				{
					mouseHover(segmentNamexpath + "[" + (count + 1) + "]");
//					listName = getStrText(DashboardRepository.allpage_tooltip);
					listName = driver.findElement(autolocator(DashboardRepository.allpage_tooltip)).getText();
					shortListName = getStrText(AudienceRepository.audience_target_shortlistname);
				} catch (Exception e)
				{
					listName = getStrText(segmentNamexpath + "[" + (count + 1) + "]");
				}

				if (listName.equals(val))
				{
					BaseTest.getTest().log(Status.INFO, "Search results shown expected result");
					javaScriptHighLightwithScrnShot(segmentNamexpath + "[" + (count + 1) + "]");
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "List not shown.");
					BaseTest.takeScreenshot();
				}
				int size = findElements(AudienceRepository.audience_target_SegmentationGridRows).size();
				if (findElements(AudienceRepository.audience_target_SegmentationGridRows).size() > 2)
				{
					BaseTest.takeScreenshot();
					BaseTest.getTest().log(Status.FAIL, "page shown more results/ search not working");
				}
			} catch (Exception e)
			{
				BaseTest.getTest().log(Status.FAIL, "page shown empty list or page not loaded or search not worked");
				BaseTest.takeScreenshot();
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Expected search value not shown in dropdown");
			BaseTest.takeScreenshot();
		}
		if (shortListName != null)
		{
			listDetails = getSegmentationCountInDynamicListingPage(shortListName);
		} else
		{
			listDetails = getSegmentationCountInDynamicListingPage(listName);
		}
		return listDetails;
	}

	public void inclusion()
	{
		javaScriptScrollIntoView(AudienceRepository.dynamic_creation_in_exclusion_pluse);
		clickElement(AudienceRepository.dynamic_creation_in_exclusion_pluse);
		clickElement(AudienceRepository.dynamic_creation_inclusion_);
	}

	public void exclusion()
	{
		javaScriptScrollIntoView(AudienceRepository.dynamic_creation_in_exclusion_pluse);
		clickElement(AudienceRepository.dynamic_creation_in_exclusion_pluse);
		clickElement(AudienceRepository.dynamic_creation_exclusion_);
	}

	public void group1Any()
	{
		clickElement(AudienceRepository.dynamic_creation_matchtypeAny);
		sendValue(AudienceRepository.dynamic_creation_matchtypeAnyvalue, "1");
	}

	public void group2All()
	{
		clickElement(AudienceRepository.dynamic_creation_group2matchtypeAll);
	}

	public void group2Any()
	{
		clickElement(AudienceRepository.dynamic_creation_group2matchtypeAny);
		sendValue(AudienceRepository.dynamic_creation_group2matchtypeAnyvalue, "1");
	}

	public AudiencePage_Dynamiclist group2TriggerType()
	{

		clickElement(AudienceRepository.audience_dynamic_group2selecttrigger);
		selectlistelements(AudienceRepository.audience_dynamic_entertrigger, BaseTest.getData().group2SelectTrigger);
		return this;
	}

	public AudiencePage_Dynamiclist group2TriggerSource()
	{
		pageLoaderLogo();
		explicitwaitforclick(autolocator(AudienceRepository.audience_dynamic_group2selecttriggertype), 40);
		clickElement(AudienceRepository.audience_dynamic_group2selecttriggertype);
		threadSleep(ObjectRepository.wait1sec);
		if (!selectlistelementsAndProceed(AudienceRepository.audience_dynamic_entertriggertype, BaseTest.getData().Group2TriggerTypeNew))
		{
			selectlistelements(AudienceRepository.audience_dynamic_entertriggertype, BaseTest.getData().TriggerTypeOld);
		}
		return this;
	}

	public AudiencePage_Dynamiclist group2ruletype()
	{
		javaScriptScrollDownToSomeExtend();
		threadSleep(ObjectRepository.wait5sec);
		clickElement(AudienceRepository.dynamic_creation_group2ruletype_click);
		threadSleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_ruletype_select, BaseTest.getData().Group2RuleType);
		clickElement(AudienceRepository.dynamic_creation_group2rule_type_click);
		threadSleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_rule_type_select, BaseTest.getData().Group2Type);
		threadSleep(ObjectRepository.wait3sec);
		clickElement(AudienceRepository.dynamic_creation_group2ruletype_values_click);
		threadSleep(ObjectRepository.wait5sec);
		selectlistelements(AudienceRepository.dynamic_creation_ruletype_values_select, BaseTest.getData().Group2Value);
		return this;
	}
	 
	public void clickDynamicListingListView()
	{
		toolTipValidationKnownText(AudienceRepository.audience_dynamiclistview_listIcon, "List view");
		clickElement(AudienceRepository.audience_dynamiclistview_listIcon);
		pageLoaderLogo();
	}
	public List<Map<String, String>> validateListView()
	{
		clickDynamicListingListView();
		selectCustomRange(-1, 0);
		int page = 1;
		List<Map<String, String>> list = new LinkedList<Map<String, String>>();
		while (true)
		{
			List<Map<String, String>> tableData = targetListingTable();
			list.addAll(tableData);
			threadSleep(ObjectRepository.wait1sec);
			javaScriptScrollDown();
			if (!isElementPresent(AudienceRepository.audience_synchist_lastButton) && page == 1)
			{
				BaseTest.getTest().log(Status.INFO, "This is first page, Pagination is not present as expected.");
				BaseTest.takeScreenshot();
				break;
			} else if (!isElementPresent(AudienceRepository.audience_synchist_lastButton) && page != 1)
			{
				BaseTest.getTest().log(Status.INFO, "This is not a first page,but pagination is not present");
				BaseTest.takeScreenshot();
				break;
			} else
			{
				if (findElement(AudienceRepository.audience_synchist_lastButton).getAttribute("class").contains("disabled"))
				{
					break;
				} else
				{
					javaScriptScrollDown();
					BaseTest.getTest().log(Status.INFO, "Page No : " + page);
					driver.findElement(autolocator(AudienceRepository.audience_synchist_nextButton)).click();
					pageLoaderLogo();
					page++;
				}
			}
		}
		ExtentManager.customReport(list);
		System.out.println(list);
		return list;
	}

}