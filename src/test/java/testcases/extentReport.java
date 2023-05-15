package testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReport {
	
	@BeforeTest
	public void setup()
	{
		String path =System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter =new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Report ");
        reporter.config().setDocumentTitle("Test Result");        
        ExtentReports extent =new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Test", "Ganesh");
        extent.createTest(path);
	}
	@Test
	public void test()
	{
		
	}

	@AfterTest
	public void teardown()
	{
		
	}

}
