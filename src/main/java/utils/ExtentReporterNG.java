package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

    public static ExtentReports getReportObject() {
    	System.out.println("System user Dir:- "+System.getProperty("user.dir"));
        String path = System.getProperty("user.dir")+"//reports//ExtentReport.html";
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(path);
        extentSparkReporter.config().setReportName("Appium Automation");
        extentSparkReporter.config().setDocumentTitle("Appium Automation Results");

        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Tester","Ejaj");

        return extentReports;
    }
}
