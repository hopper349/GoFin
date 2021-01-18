package Utilities;

import Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtil extends TestBase {

    public static int PAGE_LOAD_TIMEOUT= 20;
    public static int IMPLICIT_WAIT= 20;
    public static WebDriver driver;
    WebDriverWait wait;

    public TestUtil(WebDriver driver){
        this.driver = driver;
        wait= new WebDriverWait(driver,30000);
    }

    public void ClearFieldAndProvideText(WebElement element, String textToBeEntered){
        element.clear();
        element.sendKeys(textToBeEntered);
    }

    public void sendKeysUsingJSExecutor(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].value='Dipanshu';",element);

    }

    public void switchToFrame(WebElement element){
        driver.switchTo().frame(element);
    }

    public void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }
    public void waitUntilElementIsVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static String getSystemDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getScreenshot(String screenshotName) throws IOException
    {
        String dateName = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

}
