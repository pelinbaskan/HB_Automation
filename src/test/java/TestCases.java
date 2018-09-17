import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases extends Setup {

    Elements elements = new Elements();
    TestMethods testMethods = new TestMethods();
    public static ExtentReports extent;
    public ExtentTest test;
    public static ExtentHtmlReporter htmlReporter;

    @BeforeTest
    public void _Before() {

        htmlReporter = new ExtentHtmlReporter("D:\\Users\\porhan\\Documents\\IntellijProjects\\HB_Automation\\target" + "/HB_reports.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS", "HB Cases");
        extent.setSystemInfo("Host Name:", "Browser");

        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("HB Test Report");
        htmlReporter.config().setReportName("HB Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);


    }


    @Test(description = "1 Login to Hepsiburada website",priority = 1)
    public void _TCLogin() throws Exception {
        test = extent.createTest("Login to Hepsiburada website");
        testMethods.TCLogin(test, elements);
    }

    @Test(description = "2 Search for a specific Product", priority = 2)
    public void _TCSearchProduct() throws Exception {
        test = extent.createTest("Search for a specific Product");
        testMethods.TCSearchProduct(test, elements);
    }

    @Test(description = "3 Add Product to Cart", priority = 3)
    public void _TCAddToCart() throws Exception {
        test = extent.createTest("Add Product to Cart");
        testMethods.TCAddToCart(test, elements);
    }


    @AfterTest
    public void _After() {
        extent.close();
        extent.flush();
        driverchrome.close();



    }
}
