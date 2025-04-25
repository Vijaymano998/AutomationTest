package pages;

import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.microsoft.playwright.Page;

import repository.ObjectRepository;
import utility.BaseTest;
import utility.PageFactory;

public class AudienceDatabase extends HomePage
{

	static Connection conn = null;
	// String url, username, pass, custdbname, jobdb, SleepTime10, custDeptId, custJobType;
	String custDeptId, custJobType;
	public static String indexStatus, custJobStatus, segmentSchedulerStatus, segmentSchedulerId;
	public static int importJobStatus = 0, importScheduleId, importindexstatus;
	public static String schedulerStatus = "", schedulerIndexTrack = "";

	public AudienceDatabase(WebDriver driver, Page page, PageFactory pageFactory) {
		super(driver, page, pageFactory);
	}

	/*
	 * public void getDatabaseInfo() { url = System.getProperty("dburl"); username = System.getProperty("db_uname"); pass =
	 * System.getProperty("db_pass"); // custdbname = System.getProperty("db_custdb"); jobdb = System.getProperty("db_job"); SleepTime10 =
	 * System.getProperty("db_jobmasterstatuschange"); }
	 */

	// ****************Audience Upload*******************

	public String qCustRemoteJob(String source)
	{
		return "SELECT * FROM remotesetting WHERE DatabaseType='" + source + "' AND ModifiedDate> DATE_SUB(UTC_TIMESTAMP, INTERVAL 10 MINUTE) ORDER BY 1 DESC;";
	}

	public String qCustJob(String imptDesc)
	{
		return "SELECT * FROM job where ImportDescription='" + imptDesc + "'";
	}

	public String qCustJobIdStatus(String jobid)
	{
		return "SELECT * FROM job where JobID='" + jobid + "'";
	}

	public String qCustRemoteJobIdStatus(String jobid)
	{
		return "SELECT * FROM remotesetting WHERE RemoteSettingID='" + jobid + "' AND ModifiedDate> DATE_SUB(UTC_TIMESTAMP, INTERVAL 15 MINUTE) ORDER BY 1 DESC;";
	}

	public String qCustRecipientCount(String deptId)
	{
		return "SELECT COUNT(RecipientID) AS TotalRecipientCount FROM recipient WHERE DepartmentID=" + deptId;
	}

	public String qcustRecipientColumnMap(String jobId)
	{
		return "SELECT * FROM recipientcolumnmapping WHERE JobId =" + jobId;
	}

	public String qcustRemoteColumnMap(String remoteId)
	{
		return "SELECT * FROM remotecolumn WHERE RemoteSettingID =" + remoteId;
	}

	public String qJobimportScheduler(String jobId)
	{
		return "SELECT * FROM audienceimportscheduler WHERE DBName LIKE '%" + tenantId + "%' AND JobID=" + jobId + " AND DepartmentID=" + custDeptId + " ORDER BY 1 DESC LIMIT 1;";
	}

	public String qJobindexTrack(String impSchduleId)
	{
		return "SELECT * FROM audienceindexingtracker WHERE DBName LIKE '%" + tenantId + "%' AND AudienceImportSchedulerID=" + impSchduleId + " AND DepartmentID=" + custDeptId + "";
	}
	// *******Segmentation queries***************

	public String qCustSegmentList(String segmentName)
	{
		return "SELECT * FROM segmentationlist WHERE RecipientsBunchName='" + segmentName + "'";
	}

	public String qCustDynamicList(String dynamicListName)
	{
		return "SELECT * FROM dynamiclists WHERE DynamicListName='" + dynamicListName + "'";
	}

	public String qSegmentScheduler(String scheduleListId)
	{
		return "SELECT * FROM audiencesegmentationscheduler WHERE DBName LIKE '%" + tenantId + "%' AND SegmentationListID=" + scheduleListId + ";";
	}

	public String qDynamicScheduler(String dynamicListId)
	{
		return "SELECT * FROM audiencedynamiclistscheduler WHERE DBName LIKE '%" + tenantId + "%' AND DynamicListID=" + dynamicListId + ";";
	}

	public String qSegmentIndex(String scheduleId)
	{
		return "SELECT * FROM segmentindexingtracker WHERE DBName LIKE '%" + tenantId + "%' AND SegmentationSchedulerID=" + scheduleId + ";";
	}

	public String qCustSegmentApproveTable(String segmentDynamicName, String approvalMail)
	{
		return "SELECT * FROM segmentationrequestapproval WHERE SegmentationListName='" + segmentDynamicName + "' AND  ApproverEmail LIKE '%" + approvalMail + "%'";
	}

	public String qCustDynamicApproveTable(String segmentDynamicName, String approvalMail)
	{
		return "SELECT * FROM dynamiclistrequestapproval WHERE DynamicListListName='" + segmentDynamicName + "' AND  ApproverEmail LIKE '%" + approvalMail + "%'";
	}

	// Segmentation Verify
	public int getSegmentationListId(String segmentName, String listType)
	{
		String segmentListId = null;
		ResultSet result;
		try
		{
			if (listType.equalsIgnoreCase("dynamic"))
			{
				result = exceuteQuery(dburl_audience + auddbname, audiencedb_userName, audiencedb_password, qCustDynamicList(segmentName));
				while (result.next())
				{
					segmentListId = result.getString("DynamicListID");
				}

			} else
			{
				result = exceuteQuery(dburl_audience + auddbname, audiencedb_userName, audiencedb_password, qCustSegmentList(segmentName));
				while (result.next())
				{
					segmentListId = result.getString("SegmentationListID");
				}
			}

		} catch (Exception e)
		{
			System.err.println("AudienceDatabase.getSegmentationListId() query result exception :" + e.getMessage());
		} finally
		{
			if (conn != null)
			{
				conn = null;
			}
		}

		if (segmentListId == null)
		{
			segmentListId = "0";
		}

		return Integer.parseInt(segmentListId);
	}

	public String getSegmentSchedulerStatus(String segmentationListId, String listType)
	{
		ResultSet result;
		try
		{
			if (listType.equalsIgnoreCase("dynamic"))
			{
				result = exceuteQuery(dburl_master + jobdb, masterdb_userName, masterdb_password, qDynamicScheduler(segmentationListId));
				while (result.next())
				{
					segmentSchedulerStatus = result.getString("StatusId");
				}
			} else
			{
				result = exceuteQuery(dburl_master + jobdb, masterdb_userName, masterdb_password, qSegmentScheduler(segmentationListId));
				while (result.next())
				{
					segmentSchedulerId = result.getString("SegmentationSchedulerID");
					segmentSchedulerStatus = result.getString("STATUS");
				}
			}
		} catch (Exception e)
		{
			// System.err.println("AudienceDatabase.getSegmentSchedulerStatus() result exception:" + e.getMessage());
			BaseTest.getTest().info("AudienceDatabase.getSegmentSchedulerStatus() result exception:" + e.getMessage());
		} finally
		{
			if (conn != null)
			{
				conn = null;
			}
		}
		return segmentSchedulerStatus;
	}

	public String getSegmentIndexingTraker()
	{
		String segmentIndexingStatus = null;
		try
		{
			ResultSet result = exceuteQuery(dburl_master + jobdb, masterdb_userName, masterdb_password, qSegmentIndex(segmentSchedulerId));
			while (result.next())
			{
				segmentIndexingStatus = result.getString("STATUS");
			}
		} catch (Exception e)
		{
			System.err.println("AudienceDatabase.getSegmentIndexingTraker() result exception:" + e.getMessage());
		} finally
		{
			if (conn != null)
			{
				conn = null;
			}
		}
		return segmentIndexingStatus;
	}

	public ArrayList<String> eCustJobIdGet(String imptDesc)
	{
		ArrayList<String> custJobIds = new ArrayList<String>();
		ResultSet result = exceuteQuery(dburl_audience + auddbname, audiencedb_userName, audiencedb_password, qCustJob(imptDesc));
		try
		{
			while (result.next())
			{
				custJobIds.add(result.getString("JobID"));
				custDeptId = result.getString("DepartmentID");
				custJobType = result.getString("JobType");
			}
		} catch (SQLException e)
		{
			System.err.println("AudienceDatabase.eCustJobIdGet() result exception:" + e.getMessage());
		}
		return custJobIds;
	}

	public ArrayList<String> eCustRemoteJobIdGet(String source)
	{
		ArrayList<String> custJobIds = new ArrayList<String>();
		try
		{
			ResultSet result = exceuteQuery(dburl_audience + auddbname, audiencedb_userName, audiencedb_password, qCustRemoteJob(source));
			while (result.next())
			{
				custJobIds.add(result.getString("RemoteSettingID"));
				custDeptId = result.getString("DepartmentID");
				custJobType = result.getString("RemoteDataSourceID");
			}
		} catch (Exception e)
		{
			System.err.println("AudienceDatabase.eCustRemoteJobIdGet()  result exception:" + e.getMessage());
		} finally
		{
			if (conn != null)
			{
				conn = null;
			}
		}
		return custJobIds;
	}

	public int eCustJobIdStatus(String jobid)
	{
		custJobStatus = null;
		try
		{
			System.out.println();
			ResultSet result = exceuteQuery(dburl_audience + auddbname, audiencedb_userName, audiencedb_password, qCustJobIdStatus(jobid));
			while (result.next())
			{
				custJobStatus = result.getString("JobStatus");
			}
		} catch (Exception e)
		{
			System.err.println("AudienceDatabase.eCustJobIdStatus()  result exception: " + e.getMessage());
		} finally
		{
			if (conn != null)
			{
				conn = null;
			}
		}
		return Integer.parseInt(custJobStatus);
	}

	public int eCustRemoteJobIdStatus(String jobid)
	{
		custJobStatus = null;
		try
		{
			ResultSet result = exceuteQuery(dburl_audience + auddbname, audiencedb_userName, audiencedb_password, qCustRemoteJobIdStatus(jobid));
			while (result.next())
			{
				custJobStatus = result.getString("JobStatus");
			}
		} catch (Exception e)
		{
			System.err.println("AudienceDatabase.eCustRemoteJobIdStatus()  result exception:" + e.getMessage());
		} finally
		{
			if (conn != null)
			{
				conn = null;
			}
		}
		return Integer.parseInt(custJobStatus);
	}

	public int eCustRecipCount()
	{
		int totalRecipientCount = 0;
		try
		{
			ResultSet result = exceuteQuery(dburl_audience + auddbname, audiencedb_userName, audiencedb_password, qCustRecipientCount(custDeptId));
			while (result.next())
			{
				totalRecipientCount = Integer.parseInt(result.getString("TotalRecipientCount"));
			}
		} catch (Exception e)
		{
			System.err.println("AudienceDatabase.eCustRecipCount() result exception:" + e.getMessage());
		} finally
		{
			if (conn != null)
			{
				conn = null;
			}
		}
		return totalRecipientCount;
	}

	public void eCustRecipColumnMap(String jobId)
	{
		try
		{
			ResultSet result = exceuteQuery(dburl_audience + auddbname, audiencedb_userName, audiencedb_password, qcustRecipientColumnMap(jobId));
			while (result.next())
			{
				BaseTest.getTest().log(Status.INFO, "SourceColumn :" + result.getString("SourceColumn") + " | DestColumn :" + result.getString("DestColumn") + " | FieldTypeID :" + result.getString("FieldTypeID"));

			}
		} catch (Exception e)
		{
			System.err.println("AudienceDatabase.eCustRecipColumnMap() result exception:" + e.getMessage());
		} finally
		{
			if (conn != null)
			{
				conn = null;
			}
		}
	}

	public void eCustRemoteColumnMap(String remoteId)
	{
		try
		{
			ResultSet result = exceuteQuery(dburl_audience + auddbname, audiencedb_userName, audiencedb_password, qcustRemoteColumnMap(remoteId));
			while (result.next())
			{
				BaseTest.getTest().log(Status.INFO, "SourceColumn :" + result.getString("SourceColumnName") + " | DestColumn :" + result.getString("DestinationColumnName") + " | FieldTypeID :" + result.getString("FieldTypeID"));

			}
		} catch (Exception e)
		{
			System.err.println("AudienceDatabase.eCustRemoteColumnMap() result exception:" + e.getMessage());
		} finally
		{
			if (conn != null)
			{
				conn = null;
			}
		}
	}

	public void eImportScheduler(String jobId)
	{
		ResultSet result = exceuteQuery(dburl_master + jobdb, masterdb_userName, masterdb_password, qJobimportScheduler(jobId));
		try
		{
			while (result.next())
			{
				importJobStatus = Integer.parseInt(result.getString("Status"));
				importScheduleId = Integer.parseInt(result.getString("AudienceImportSchedulerID"));
				importindexstatus = Integer.parseInt(result.getString("AudineceIndexingSchedulerStatus"));
			}
		} catch (SQLException e)
		{
			System.err.println("AudienceDatabase.eImportScheduler() result exception:" + e.getMessage());

		} finally
		{
			if (conn != null)
			{
				conn = null;
			}
		}
	}

	public boolean importSchduleStatusCheck(String jobid)
	{
		String logText = "JobId :" + jobid + " audienceimportscheduler status  :" + importJobStatus + " and AudineceIndexingSchedulerStatus: " + importindexstatus;
		if (importJobStatus == 9 && importindexstatus == 1)
		{
			BaseTest.getTest().log(Status.INFO, logText);
		} else if (importJobStatus == 9 && importindexstatus == 16)
		{
			BaseTest.getTest().log(Status.INFO, logText);
		} else if (importJobStatus == 9 && importindexstatus == 56)
		{
			BaseTest.getTest().log(Status.INFO, logText);
		} else if (importJobStatus == 9 && importindexstatus == 55)
		{
			BaseTest.getTest().log(Status.INFO, logText);
		} else if (importJobStatus == 9 && importindexstatus == 9)
		{
			BaseTest.getTest().log(Status.INFO, logText);
			return true;
		} else if (importJobStatus == 1 && importindexstatus == 1)
		{
			BaseTest.getTest().log(Status.INFO, logText);
		} else if (importJobStatus == 9 && importindexstatus == 4)
		{
			BaseTest.getTest().log(Status.PASS, logText);

			return true;
		} else
		{
			BaseTest.getTest().log(Status.INFO, logText);
		}
		return false;
	}

	public void eIndextrackStatus()
	{
		ResultSet result = exceuteQuery(dburl_master + jobdb, masterdb_userName, masterdb_password, qJobindexTrack(String.valueOf(importScheduleId)));
		try
		{
			while (result.next())
			{
				indexStatus = result.getString("Status");
			}
		} catch (SQLException e)
		{
			System.err.println("AudienceDatabase.eIndextrackStatus() result exception:" + e.getMessage());

		} finally
		{
			if (conn != null)
			{
				conn = null;
			}
		}
	}

	public String cJobTypeCompare()
	{
		int jobType = Integer.parseInt(custJobType);
		switch (jobType)
		{
		case 7:
			return "CSV";
		case 6:
			return "XML";
		case 32:
			return "Manual entry";
		default:
			return "";
		}
	}

	public void uploadStatus(ArrayList<String> jobIds, int audienceCountBefore, String listType, String uploadFormat)
	{
		boolean uploadListTypeTarget = false;
		for (String jobid : jobIds)
		{
			int jobTableStatus;
			if (uploadFormat.equalsIgnoreCase("mysql"))
			{
				jobTableStatus = eCustRemoteJobIdStatus(jobid);
			} else
			{
				jobTableStatus = eCustJobIdStatus(jobid);
			}

//			if (((jobTableStatus != 2) || !listType.toLowerCase().contains("target")) && jobTableStatus != 100)
//			{
//				int c2 = jobIds.size() + 9;
//				for (int c1 = 0; c1 <= c2; c1++)
//				{
//					eImportScheduler(jobid);
//					if (importJobStatus != 100)
//					{
//						if (importSchduleStatusCheck(jobid) == true)
//						{
//							for (int a = 0; a <= 9; a++)
//							{
//								threadSleep(ObjectRepository.wait20sec);
//								if (!listType.toLowerCase().contains("target"))
//								{
//									uploadListTypeTarget = true;
//									break;
//								} else
//								{
//									eIndextrackStatus();
//									if (indexStatus.contains("C"))
//									{
//										// "+audiDB.eCustRecipCount());
//										BaseTest.getTest().log(Status.INFO, "Before upload count: " + audienceCountBefore);
//										BaseTest.getTest().log(Status.INFO, "after upload count: " + eCustRecipCount());
//										uploadListTypeTarget = true;
//										break;
//									} else
//									{
//										threadSleep(ObjectRepository.wait40sec);
//										BaseTest.getTest().log(Status.INFO, "Indexing traker Status not completed Waiting for 40 seconds");
//									}
//								}
//							}
//						} else
//						{
//							threadSleep(ObjectRepository.wait40sec);
//							BaseTest.getTest().log(Status.INFO, "importSchdule Status not completed Waiting some time");
//							if (c2 == c1)
//							{
//								BaseTest.getTest().log(Status.WARNING, "importSchdule Status not completed after waiting few minutes");
//							}
//						}
//					} else
//					{
//						BaseTest.getTest().log(Status.FAIL, "Import scheduler failed");
//						break;
//					}
//					if (uploadListTypeTarget)
//					{
//						break;
//					}
//				}
//
//			} else
//			{
//				BaseTest.getTest().log(Status.FAIL, "Upload status has been failed either file not properly uploaded or deleted for JobID :" + jobid);
//			}
		}
	}

	@SuppressWarnings("rawtypes")
	public void validateAudienceUpload(Map<String, String> importtypes, String uploadFormat)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("AUDIENCE UPLOAD DATABASE", ExtentColor.INDIGO));
		threadSleep(ObjectRepository.wait20sec);
		int audienceCountBefore = 0;
		boolean jobidCount = false;
		Set test1 = importtypes.entrySet();
		Iterator uploadTypes = test1.iterator();
		while (uploadTypes.hasNext())
		{
			Map.Entry e = (Map.Entry) uploadTypes.next();
			String listType = e.getKey().toString();
			String importDesc = e.getValue().toString();

			ArrayList<String> jobIds = null;
			String uploadFormats = uploadFormat.toLowerCase().trim();
			if (uploadFormats.equalsIgnoreCase("csv") || uploadFormats.equalsIgnoreCase("manual entry") || uploadFormats.equalsIgnoreCase("xml") || uploadFormats.contains("csv"))
			{
				BaseTest.getTest().log(Status.INFO, "Selected list type :" + listType + " and import description : " + importDesc);
				jobIds = eCustJobIdGet(importDesc);
				if (!jobIds.isEmpty() && cJobTypeCompare().equalsIgnoreCase(uploadFormat))
				{
					audienceCountBefore = eCustRecipCount();
					BaseTest.getTest().log(Status.INFO, "Recepient initial count :" + audienceCountBefore);
					eCustRecipColumnMap(jobIds.get(0));
					jobidCount = true;
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "No Job table entry or jobtype not available");
				}
			} else if (uploadFormat.equalsIgnoreCase("mssql") || uploadFormat.equalsIgnoreCase("mysql") || uploadFormat.equalsIgnoreCase("ftp") || uploadFormat.equalsIgnoreCase("sftp"))
			{
				BaseTest.getTest().log(Status.INFO, "Selected list type :" + listType);
				jobIds = eCustRemoteJobIdGet(uploadFormat);
				if (!jobIds.isEmpty())
				{
					audienceCountBefore = eCustRecipCount();
					BaseTest.getTest().log(Status.INFO, "Recepient initial count :" + audienceCountBefore);
					eCustRemoteColumnMap(jobIds.get(0));
					jobidCount = true;
				} else
				{
					BaseTest.getTest().log(Status.FAIL, "No Remotesetting table entry available");
				}
			}

			if (jobidCount)
			{
				uploadStatus(jobIds, audienceCountBefore, listType, uploadFormat);
			}
		}
	}

	// **************************Segmentation*****************************************************

	public ResultSet exceuteQuery(String dburl, String userName, String userPswrd, String query)
	{
		ResultSet result = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl + sqlconnectionTimeZone, userName, userPswrd);
		} catch (ClassNotFoundException e)
		{
			System.out.println("JDBC driver having issue");
		} catch (SQLException e)
		{
			System.out.println("SQL connection not established");
			System.out.println(e.getMessage());
		}
		try
		{
			Statement statement = conn.createStatement();
			result = statement.executeQuery(query);
		} catch (SQLException e)
		{
			System.out.println("Qurey having issue or query result having issue");
		} catch (NullPointerException e)
		{
			System.out.println("SQL Connection issue");
		}

		return result;
	}

	// Segmentation

	public void targetListDBVerification(String segementationName, String listType)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("TARGET LIST DATABASE VALIDATION", ExtentColor.INDIGO));
		threadSleep(ObjectRepository.wait20sec);
		int segmentListID = 0;
		// getDatabaseInfo();
		if (segementationName != null)
		{
			segmentListID = getSegmentationListId(segementationName, "target");
			BaseTest.getTest().log(Status.INFO, " Segmentation database verification for :" + segementationName);
		}
		if (segmentListID != 0)
		{
			for (int i = 0; i <= 9; i++)
			{
				schedulerStatus = getSegmentSchedulerStatus(Integer.toString(segmentListID), "target");
				if (schedulerStatus.equalsIgnoreCase("C"))
				{
					BaseTest.getTest().log(Status.INFO, "Segmentation schedulerStatus status after few seconds :" + schedulerStatus);
					break;
				} else if (schedulerStatus.equalsIgnoreCase("F"))
				{
					BaseTest.getTest().log(Status.FAIL, "Segmentation scheduler status failed :" + schedulerStatus);
					break;
				} else if (schedulerStatus.equalsIgnoreCase("I") || schedulerStatus.equalsIgnoreCase("J") || schedulerStatus.equalsIgnoreCase("S") || schedulerStatus.equalsIgnoreCase("P") || schedulerStatus.equalsIgnoreCase("M"))
				{
					if (i == 9)
					{
						BaseTest.getTest().log(Status.INFO, "Segmentation scheduler Status after few seconds :" + schedulerStatus);
					}
					threadSleep(30000);
				} else if (schedulerStatus.equalsIgnoreCase("Z"))
				{
					BaseTest.getTest().log(Status.WARNING, "Segmentation scheduler status shows audience count 0");
					break;
				} else if (schedulerStatus.equalsIgnoreCase("Q"))
				{
					break;
				} else
				{
					BaseTest.getTest().log(Status.WARNING, "Segmentation scheduler status not implemented" + schedulerStatus);
					break;
				}
			}
			if (schedulerStatus.equalsIgnoreCase("C") && listType.equalsIgnoreCase("Target"))
			{
				for (int j = 0; j < 5; j++)
				{
					if (getSegmentIndexingTraker().equalsIgnoreCase("C"))
					{
						BaseTest.getTest().log(Status.INFO, "Segmentation indexing tracker status completed");
						schedulerIndexTrack = "C";
						break;
					} else
					{
						threadSleep(30000);
					}
				}
			} else if (!listType.equalsIgnoreCase("Target") && schedulerStatus.equalsIgnoreCase("C"))
			{
				BaseTest.getTest().log(Status.PASS, "Segmentation scheduler status after waiting time : " + schedulerStatus);
			} else
			{
				BaseTest.getTest().log(Status.WARNING, "Segmentation scheduler status after waiting time : " + schedulerStatus);
			}

		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Segmentation failed due to segment not created :" + segementationName);
		}
	}

	// dynamic list
	public void dynamicListDBVerification(String dynamicListName)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("DYNAMIC LIST DATABASE VALIDATION", ExtentColor.INDIGO));
		threadSleep(ObjectRepository.wait3sec);
		schedulerStatus = null;
		int dynamicListID = 0;
		// getDatabaseInfo();
		if (dynamicListName != null)
		{
			dynamicListID = getSegmentationListId(dynamicListName, "dynamic");
			BaseTest.getTest().log(Status.INFO, " Dynamic list database verification for :" + dynamicListName);
		}
		if (dynamicListID != 0)
		{
			for (int i = 0; i < 8; i++)
			{
				threadSleep(ObjectRepository.wait30sec);
				schedulerStatus = getSegmentSchedulerStatus(Integer.toString(dynamicListID), "dynamic");
				if (schedulerStatus.equals("100"))
				{
					BaseTest.getTest().log(Status.INFO, "Dynamiclist scheduler Status :" + schedulerStatus);
					break;
				} else if (schedulerStatus.equalsIgnoreCase("10"))
				{
					BaseTest.getTest().log(Status.FAIL, "Dynamiclist scheduler Status error:" + schedulerStatus);
					break;
				} else if (schedulerStatus.equals("9"))
				{
					BaseTest.getTest().log(Status.INFO, "Dynamiclist scheduler Status complete:" + schedulerStatus);
					break;

				} else if (schedulerStatus.equals("5"))
				{
					BaseTest.getTest().log(Status.INFO, "Dynamiclist scheduler Status in progress:" + schedulerStatus);

				} else if (schedulerStatus.equals("1"))
				{
					BaseTest.getTest().log(Status.INFO, "Dynamiclist scheduler Status in queue:" + schedulerStatus);
				} else
				{
					BaseTest.getTest().log(Status.INFO, "Dynamiclist scheduler Status not implemented:" + schedulerStatus);
					break;
				}
			}
		}
	}

	// *************************Request for approval************************************

	public void targetDynamicRFAStatus(String targetOrDynamic, String segmentName, Boolean isAllApproved)
	{

		String segApprStatus = null, segIsRequestApproval = null;
		ResultSet result;
		if (targetOrDynamic.equalsIgnoreCase("target"))
		{
			result = exceuteQuery(dburl_audience + auddbname, audiencedb_userName, audiencedb_password, qCustSegmentList(segmentName));
		} else
		{
			result = exceuteQuery(dburl_audience + auddbname, audiencedb_userName, audiencedb_password, qCustDynamicList(segmentName));
		}

		try
		{
			while (result.next())
			{
				segApprStatus = result.getString("ApproverStatus");
				segIsRequestApproval = result.getString("IsRequestApproval");
			}
		} catch (SQLException e)
		{
			BaseTest.getTest().log(Status.WARNING, "ResultSet exeption query not executed" + e);
		} finally
		{
			if (conn != null)
			{
				conn = null;
			}
		}
		if (segApprStatus != null && segIsRequestApproval != null)
		{
			if (!isAllApproved)
			{
				try
				{
					assertEquals(segApprStatus, "2");
					assertEquals(segIsRequestApproval, "1");
					BaseTest.getTest().log(Status.INFO, "One more approver has to approve, this target list still waiting for approve");
				} catch (AssertionError e)
				{
					BaseTest.getTest().log(Status.FAIL, " table ApproverStatus :" + segApprStatus + " & IsRequestApproval status :" + segIsRequestApproval + " wrongly updated without approve:");
				}
			} else
			{
				try
				{
					assertEquals(segApprStatus, "1");
					assertEquals(segIsRequestApproval, "1");
					BaseTest.getTest().log(Status.INFO, "After all approve table status - ApproverStatus :" + segApprStatus + " & IsRequestApproval status :" + segIsRequestApproval);
				} catch (AssertionError e)
				{
					BaseTest.getTest().log(Status.FAIL, "After all approve  table status - ApproverStatus :" + segApprStatus + " & IsRequestApproval status :" + segIsRequestApproval);
				}
			}
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "Segmentation/Dynamic list not updated in segmentationlist/dynamiclist table. Query returns zero rows");
		}
	}

	public void rfaApproverStatus(String listType, String segmentDynamicName, String approvalMailui, int priorityui, boolean isHierarchyui, boolean isMandatoryui, boolean isHeApproved)
	{
		BaseTest.getTest().info(MarkupHelper.createLabel("RFA DATABASE ", ExtentColor.INDIGO));
		threadSleep(ObjectRepository.wait5sec);
		String ApprovalStatus = null, Priority = null, IsHierarchy = null, IsMandatory = null;
		boolean IsMandatory1 = true;
		boolean IsHierarchy1 = true;
		int priority1;
		ResultSet result = null;
		// getDatabaseInfo();
		if (listType.equalsIgnoreCase("dynamic"))
		{
			result = exceuteQuery(dburl_audience + auddbname, audiencedb_userName, audiencedb_password, qCustDynamicApproveTable(segmentDynamicName, approvalMailui));
		} else
		{
			result = exceuteQuery(dburl_audience + auddbname, audiencedb_userName, audiencedb_password, qCustSegmentApproveTable(segmentDynamicName, approvalMailui));
		}
		try
		{
			if (result != null)
			{
				while (result.next())
				{
					IsMandatory = result.getString("IsMandatory");
					IsHierarchy = result.getString("IsHierarchy");
					Priority = result.getString("Priority");
					ApprovalStatus = result.getString("ApprovalStatus");
				}
			} else
			{
				BaseTest.getTest().log(Status.INFO, "query returns null :" + qCustSegmentApproveTable(segmentDynamicName, approvalMailui));
			}

		} catch (SQLException e)
		{
			BaseTest.getTest().log(Status.WARNING, "ResultSet exeption query not executed" + e);
		} finally
		{
			if (conn != null)
			{
				conn = null;
			}
		}
		if (IsMandatory.contains("0"))
		{
			IsMandatory1 = false;
		}
		if (IsHierarchy.contains("0"))
		{
			IsHierarchy1 = false;
		}
		priority1 = Integer.parseInt(Priority);
		if (IsMandatory1 == isMandatoryui && IsHierarchy1 == isHierarchyui && priority1 == priorityui)
		{
			BaseTest.getTest().log(Status.INFO, "UI and DB entries are same for isMandatory:" + IsMandatory1 + ",IsHierarchy:" + IsHierarchy1 + ",priority:" + priority1);
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "UI and DB entries are not same for isMandatory,IsHierarchy,priority" + isMandatoryui + "-" + IsMandatory1 + "&" + isHierarchyui + "-" + IsHierarchy1 + "&" + priorityui + "-" + priority1);
		}
		if (isHeApproved == true && Integer.parseInt(ApprovalStatus) == 1)
		{
			BaseTest.getTest().log(Status.INFO, "Approver approved the list:" + segmentDynamicName + ", approved by :" + approvalMailui);
		} else if (isHeApproved == false && Integer.parseInt(ApprovalStatus) == 0)
		{
			BaseTest.getTest().log(Status.INFO, "approval status - pending in DB");
		} else if (isHeApproved == false && Integer.parseInt(ApprovalStatus) == 2)
		{
			BaseTest.getTest().log(Status.INFO, "Approver rejected the list:" + segmentDynamicName + ", Rejected by :" + approvalMailui);
		} else
		{
			BaseTest.getTest().log(Status.FAIL, "RFA status is different");
		}
	}

}
