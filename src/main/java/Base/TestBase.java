package Base;

import Utilities.TestUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.sun.xml.internal.ws.resources.UtilMessages;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import javax.xml.bind.SchemaOutputResolver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver driver;
    Properties properties;
    static WebDriverWait explicitWait;
    public static Logger Log;
    public static ExtentReports extentReports;
    public static ExtentSparkReporter extentSparkReporter;
    public static ExtentTest extentTest;

    public TestBase(){

        Log = Logger.getLogger(this.getClass());
        try {
            String configFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties";
            FileInputStream fis = new FileInputStream(configFilePath);
            properties = new Properties();
            properties.load(fis);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }

    public WebDriver initialization(){
        String browserName = properties.getProperty("browser").toLowerCase().trim();
        System.out.println("browser"+ browserName);
        switch(browserName){
            case("chrome"):
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                System.out.println("launching Chrome");
                break;
            case("firefox"):
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                System.out.println("launching FF");
                break;
            default:
                throw new RuntimeException("Browser Not Supported. Please update the browser in the Config.Properties file");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(properties.getProperty("url"));
        return driver;
    }

}
