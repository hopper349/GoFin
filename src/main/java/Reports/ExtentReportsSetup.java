package Reports;

import Base.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsSetup extends TestBase {

    public static ExtentReports extentReports;
    public static ExtentSparkReporter extentSparkReporter;
    public static ExtentTest extentTest;

    public static ExtentReports extentReportsSetUp(){
        extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"\\ExtentResults\\report.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setReportName("Test Automation Report");
        extentSparkReporter.config().setDocumentTitle("Test Automation Report");

        return extentReports;
    }

}
