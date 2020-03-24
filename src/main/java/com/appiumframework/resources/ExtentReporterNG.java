package com.appiumframework.resources;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
 
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.appiumframework.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


 
public class ExtentReporterNG implements IReporter {
    private ExtentReports extent;
    ExtentHtmlReporter htmlReporter;
 
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
    	
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\" +Base.getCurrentDateTime() + ".html");
       extent = new ExtentReports();
        
        extent.attachReporter(htmlReporter);
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
 
            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
 
                try {
					buildTestNodes(context.getPassedTests(), Status.PASS);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                try {
					buildTestNodes(context.getFailedTests(), Status.FAIL);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                try {
					buildTestNodes(context.getSkippedTests(), Status.SKIP);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            
           
        }
 
        extent.flush();
        
    }
 
    private void buildTestNodes(IResultMap tests, Status status) throws IOException {
        ExtentTest test;
        
 
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.createTest(result.getMethod().getMethodName());
 
                /*test.getTest(). = getTime(result.getStartMillis());
                test.getTest().endedTime = getTime(result.getEndMillis());*/
 
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);
               
                String message = "Test " + status.toString().toLowerCase() + "ed";
 
                if (result.getThrowable() != null)
                    message = result.getThrowable().getLocalizedMessage();
 
                test.log(status, message);
               if (result.getStatus() == ITestResult.FAILURE) {                	
                	
        			test.fail("Test Failed",  MediaEntityBuilder.createScreenCaptureFromPath(Base.captureScreenshot()).build());

        		}
 
               
 
         
            }
        }
    }
 
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();        
    }
}