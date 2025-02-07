package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testbase.base_class;

public class Extentreports implements ITestListener
	{
		public ExtentSparkReporter sparkreporter;
		public ExtentReports  extent;
		public ExtentTest test;

		String repname;
		
		
	public void onTestStart(ITestResult testcontext)
	
		{
	
		
	String 	timestamp=new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());
	
	repname="Test-Report-"+timestamp+".html";
	 sparkreporter	=new ExtentSparkReporter("./"
	 		+ ""
	 		+ "Reports\\"+repname);//specify location of the report
	 
	 sparkreporter.config().setDocumentTitle("opencart Automtion report");//title of the report
	 sparkreporter.config().setReportName("opencart functional testing");//test case name
	 sparkreporter.config().setTheme(Theme.DARK);
	 
	 
	 extent=new ExtentReports();
	 extent.attachReporter(sparkreporter);
	 extent.setSystemInfo("Application", "opencart");
	 extent.setSystemInfo("Module","Admin");
	 extent.setSystemInfo("subModule", "customers");
	 extent.setSystemInfo("username",System.getProperty("user.name") );
	 extent.setSystemInfo("envirnoment ", "qa");
	 
	 

		
		}

		public void onTestSuccess(ITestResult result)
		{
			 test = extent.createTest(result.getTestClass().getName());
			 test.assignCategory(result.getMethod().getGroups());
			 test.log(Status.PASS,result.getName()+"gotsucesfullyexecuted");
				
		}

		public void onTestFailure(ITestResult result) 
		{
			test = extent.createTest(result.getTestClass().getName());
			test.assignCategory(result.getMethod().getGroups());
			
			test.log(Status.FAIL,result.getName()+"got failed");
			test.log(Status.INFO, result.getThrowable().getMessage());
			
			String imgpath=new base_class().capture(result.getName());
			test.addScreenCaptureFromPath(imgpath);
			
		}
		
		
}
