package PageActions;

import Base.TestBase;
import PageLocators.CreditDebitCardPage;
import Utilities.FileReaderManager;
import Utilities.Json;
import Utilities.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreditDebitCardPageAction extends TestBase {
    WebDriver driver;
    CreditDebitCardPage creditDebitCardPage;
    TestUtil testUtil;


    public CreditDebitCardPageAction(WebDriver driver){
        this.driver= driver;
        creditDebitCardPage = new CreditDebitCardPage(driver);
        testUtil = new TestUtil(driver);
    }

    public WebElement getCreditDebitCardHeader(){
        return creditDebitCardPage.getCreditDebitCardText();
    }

    public void enterCardDetails(String testCaseName){
        Json json = FileReaderManager.getInstance().getJsonDataReader().getJsonByName(testCaseName);

        Log.info("Entering Card Number");
        creditDebitCardPage.getCardNumberField().sendKeys(json.testData.card);
        Log.info("Entering Expiry Month");
        creditDebitCardPage.getExpiryDateField().sendKeys(json.testData.expiry);
        Log.info("Entering CVV Code");
        creditDebitCardPage.getCVVField().sendKeys(json.testData.cvv);

    }

    public TransactionPageAction clickOnPayNowBtn() throws InterruptedException {
        Log.info("Clicking on PayNow button");
        creditDebitCardPage.getPayNowBtn().click();
        Thread.sleep(10000);
        return new TransactionPageAction(driver);
    }
}
