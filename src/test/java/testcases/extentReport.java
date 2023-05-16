package testcases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReport {
	
	
	ExtentSparkReporter reporter;
	ExtentReports extent = new ExtentReports();
    ExtentTest test;

	@BeforeTest
	public void setup()
	{
		reporter =new ExtentSparkReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
		extent.setSystemInfo("OS", "windows");
        extent.setSystemInfo("Browser", "Chrome");

        reporter.config().setReportName("Web Automation Report ");
        reporter.config().setDocumentTitle("Test Result");    
        reporter.config().setEncoding("utf-8");
        reporter.config().setTheme(Theme.STANDARD);
        reporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
       
        extent.attachReporter(reporter);
        extent.setSystemInfo("Test", "Ganesh");
        extent.createTest("Before test");
	}
	@Test
    public void testCase1() {
        test = extent.createTest("Test Case 1", "PASSED test case");
        Assert.assertTrue(true);
    }
    
    @Test
    public void testCase2() {
        test = extent.createTest("Test Case 2", "PASSED test case");
        Assert.assertTrue(true);
    }
    
    @Test
    public void testCase3() {
        test = extent.createTest("Test Case 3", "PASSED test case");
        Assert.assertTrue(true);
    }
     
    @Test
    public void testCase4() {
        test = extent.createTest("Test Case 4", "PASSED test case");
        Assert.assertTrue(false);
    }
     
    @Test
    public void testCase5() {
        test = extent.createTest("Test Case 5", "SKIPPED test case");
        throw new SkipException("Skipping this test with exception");
    }
    
    @Test(enabled=false)
	public void testCase6(){
			test = extent.createTest("Test Case 6", "I'm Not Ready, please don't execute me");
		}
   
    @AfterMethod
    public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }
     
    @AfterTest
    public void tearDown() {
    	//to write or update test information to reporter
        extent.flush();
        
    }

}
