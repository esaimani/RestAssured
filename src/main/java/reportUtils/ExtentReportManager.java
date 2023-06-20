package reportUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportManager {

    public static ExtentReports extentReports;

    public static ExtentReports createInstance(String fileName, String reportName, String docTitle) {
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(fileName);
        extentSparkReporter.config().setReportName(reportName);
        extentSparkReporter.config().setDocumentTitle(docTitle);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setEncoding("utf-8");

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        return extentReports;

    }

    public static String getReportNameWithTimestamp(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        String DateTime = dateTimeFormatter.format(LocalDateTime.now());
        return "Test Report : "+DateTime;
    }

    public static void logPassDetails(String log){
        ReportSetup.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
    }
    public static void logFailureDetails(String log){
        ReportSetup.extentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
    }
    public static void logWarningDetails(String log){
        ReportSetup.extentTest.get().warning(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
    }

    public static void logInfoDetails(String log){
        ReportSetup.extentTest.get().info(MarkupHelper.createLabel(log, ExtentColor.BLUE));
    }
}
