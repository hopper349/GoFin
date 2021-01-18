package TestListeners;

import Reports.ExtentReportsSetup;
import Utilities.TestUtil;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ExtentReportListener extends ExtentReportsSetup implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS, "Test Case Passed is ::: " +result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL, "Test Case Failed is ::: " +result.getMethod().getMethodName());
        extentTest.log(Status.FAIL, result.getThrowable());
        try
        {
            extentTest.addScreenCaptureFromPath(TestUtil.getScreenshot(result.getMethod().getMethodName()));
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void onStart(ITestContext context) {
        extentReports = ExtentReportsSetup.extentReportsSetUp();
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}
