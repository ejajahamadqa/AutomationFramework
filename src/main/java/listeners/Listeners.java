package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.AppiumBaseClass;
import utils.ExtentReporterNG;

import java.io.IOException;

public class Listeners extends AppiumBaseClass implements ITestListener {

    ExtentTest extentTest;
    ExtentReports extentReports = ExtentReporterNG.getReportObject();
    ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult iTestResult) {
        extentTest = extentReports.createTest(iTestResult.getMethod().getMethodName());
        threadLocal.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        threadLocal.get().log(Status.PASS,"PASS");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        String filePath = null;
        threadLocal.get().fail(iTestResult.getThrowable());
       /* try {
            androidDriver = (WebDriver) iTestResult.getTestClass().getRealClass().getField("androidDriver");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        try {
            filePath = getScreenShot(iTestResult.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        threadLocal.get().addScreenCaptureFromPath(filePath,iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        extentReports.flush();
    }
}
