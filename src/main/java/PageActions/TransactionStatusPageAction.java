package PageActions;

import Base.TestBase;
import PageLocators.TransactionPage;
import PageLocators.TransactionStatusPage;
import Utilities.Json;
import Utilities.TestUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TransactionStatusPageAction extends TestBase {

    WebDriver driver;
    TransactionStatusPage transactionStatusPage;
    TestUtil testUtil;
    //Json json;

    public TransactionStatusPageAction(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        transactionStatusPage = new TransactionStatusPage(driver);
        testUtil = new TestUtil(driver);
        Thread.sleep(2000);
        testUtil.waitForFrameToLoadAndSwitchToIt(transactionStatusPage.getFrame(),10);
    }

    public void validateUnsuccessfulTransaction(){
        Log.info("Validating if Transaction Failed Message is Displayed.");
        Assert.assertTrue(transactionStatusPage.getTransactionFailedMessage().isDisplayed());
        Log.info("Transaction Failed Message is Displayed.");
    }


}
