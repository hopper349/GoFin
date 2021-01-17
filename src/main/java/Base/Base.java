package Base;

import Utilities.TestUtil;
import com.sun.xml.internal.ws.resources.UtilMessages;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    WebDriver driver;
    Properties properties;


    public Base(){
        try {
            String configFilePath = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\config.properties";
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

    public void initialization(){
        String browserName = properties.getProperty("browser").toLowerCase().trim();

        switch(browserName){
            case("chrome"):
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            case("firefox"):
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(properties.getProperty("url"));
    }

}
