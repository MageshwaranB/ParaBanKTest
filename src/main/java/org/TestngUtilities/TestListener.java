package org.TestngUtilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.SeleniumUtitlies.PageLevelMethods;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;

public class TestListener extends TestListenerAdapter {
    ExtentReports extentReports;
    ExtentSparkReporter extentSparkReporter;
    ExtentTest extentTest;
    public void onStart(ITestContext testContext){
        extentSparkReporter=new ExtentSparkReporter(new File("Reports/htmlReport.html"));
        extentReports=new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("OS","Windows 11");
        extentReports.setSystemInfo("Environment","QA");
    }

    public void onTestSuccess(ITestResult tr){
        extentTest=extentReports.createTest(tr.getName());
        extentTest.log(Status.PASS,tr.getTestName()+" is passed");
        extentTest.log(Status.PASS, String.valueOf(tr.getStatus()));
        extentTest.log(Status.PASS, String.valueOf(tr.getStartMillis()));
        extentTest.log(Status.PASS,String.valueOf(tr.getEndMillis()));
    }
    public void onTestFailure(ITestResult tr){
        extentTest=extentReports.createTest(tr.getName());
        extentTest.log(Status.FAIL,tr.getTestName()+" is failed");
        extentTest.log(Status.FAIL,tr.getThrowable());
        extentTest.addScreenCaptureFromBase64String(PageLevelMethods.takeScreenshot(tr.getName()),"Taking screenshot of failed testcase: "+tr.getName());
        extentTest.log(Status.FAIL, String.valueOf(tr.getStartMillis()));
        extentTest.log(Status.FAIL,String.valueOf(tr.getEndMillis()));
    }
    public void onTestSkipped(ITestResult tr) {

    }
    public void onFinish(ITestContext testContext) {
        extentReports.flush();
    }
}
