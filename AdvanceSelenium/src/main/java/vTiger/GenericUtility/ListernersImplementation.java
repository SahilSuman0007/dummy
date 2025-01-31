package vTiger.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListernersImplementation implements ITestListener {

	ExtentReports report;// additional reports in this program
	ExtentTest test ;
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "---Test started---");
	 test = report.createTest(methodname);// additional reports in
	}

	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "Test got passed---");
		test.log(Status.PASS,methodname+"----passed---");
	}
	

	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "---Test script failed---");
		WebDriverUtility wutil = new WebDriverUtility();
		JavaFileUtility jutil = new JavaFileUtility();
		String screenshotname = methodname + " " + jutil.togetSystemDateandTime();
		try {
			  String path = wutil.ToTakeScreenShot(BaseClass.sdriver, screenshotname);
			  test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL, methodname+"---failed---");
	}

	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname + "Test script got skipp---");
		test.log(Status.SKIP, methodname+"---test skipp---");
	}

	public void onStart(ITestContext context) {
		System.out.println("---Suite Execution Started---");
		// Extent Reports
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExtentReport\\Report- " + new JavaFileUtility().togetSystemDateandTime() + ".html");
		htmlreport.config().setDocumentTitle("Vtiger Execution Reports");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("VTIGER EXECUTION REPORT");

		// additional reports in this program
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("BaseUrl", "http://localhost:8888");
		report.setSystemInfo("Username", "admin");
		report.setSystemInfo("password", "password");
		report.setSystemInfo("Reportername", "Kartik");
	}

	public void onFinish (ITestContext context) {
		System.out.println("---Suite Execution Finished---");
	    report.flush();//additional reports in this program
}
}

