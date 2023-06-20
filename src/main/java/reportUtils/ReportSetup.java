package reportUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReportSetup implements ITestListener {

    private static ExtentReports extentReports;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public void onStart(ITestContext context) {

        String reportName = ExtentReportManager.getReportNameWithTimestamp();
        String fullReportPath = System.getProperty("user.dir")+"/extentReports/"+reportName;
        extentReports = ExtentReportManager.createInstance(fullReportPath, "API Automation", "Test Execution Report");
    }

    public void onFinish(ITestContext context) {
        if (extentReports!=null)
            extentReports.flush();
    }

    public void onTestStart(ITestResult result) {

       ExtentTest test = extentReports.createTest("Test Name "+result.getClass().getName() + " " + result.getMethod().getMethodName());
       extentTest.set(test);
    }
}
