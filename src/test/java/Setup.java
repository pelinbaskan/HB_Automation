import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.net.MalformedURLException;

public class Setup {


    public static WebDriver driverchrome, driverff, driverie;
    String baseURL;


    @Parameters({"browser"})
    @BeforeTest
    public void browserType(String browser) throws MalformedURLException {
        System.out.println(browser);
        if (browser.equalsIgnoreCase("firefox")) {
            System.out.println(" Executing on FireFox");
            baseURL = "https://www.hepsiburada.com";
            File file = new File("D:\\Users\\porhan\\Documents\\IntellijProjects\\HB_Automation\\drivers\\geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
            DesiredCapabilities cap = DesiredCapabilities.firefox();
            cap.setCapability(FirefoxDriver.PROFILE, driverff);
            driverff = new FirefoxDriver(cap);
            driverff.get(baseURL);
            driverff.manage().window().maximize();


        } else if (browser.equalsIgnoreCase("chrome")) {

            System.out.println(" Executing on CHROME");
            baseURL = "https://www.hepsiburada.com";


            File file = new File("D:\\Users\\porhan\\Documents\\IntellijProjects\\HB_Automation\\drivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setCapability(ChromeOptions.CAPABILITY, options);

            driverchrome = new ChromeDriver(cap);
            driverchrome.get(baseURL);
            driverchrome.manage().window().maximize();



        } else {
            throw new IllegalArgumentException("The Browser Type is Undefined");
        }
    }
}



