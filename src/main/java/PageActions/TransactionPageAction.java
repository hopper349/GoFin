package PageActions;

import Base.TestBase;
import PageLocators.TransactionPage;
import Utilities.FileReaderManager;
import Utilities.Json;
import Utilities.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransactionPageAction extends TestBase {
    WebDriver driver;
    TransactionPage transactionPage;
    TestUtil testUtil;


    public TransactionPageAction(WebDriver driver) {
        this.driver = driver;
        transactionPage = new TransactionPage(driver);
        testUtil = new TestUtil(driver);
        testUtil.switchToFrame(transactionPage.getFrame());
    }

    public WebElement getTransactionPageHeader() throws InterruptedException {
        return transactionPage.getIssuingBankHeader();
    }

    public void enterPassword(String testCaseName) {
        Json json = FileReaderManager.getInstance().getJsonDataReader().getJsonByName(testCaseName);
        Log.info("Entering the password as: "+json.testData.password);
        transactionPage.getPasswordField().sendKeys(json.testData.password);
    }

    public TransactionStatusPageAction clickOnOKButton() throws InterruptedException {
        transactionPage.getOkBtn().click();
        //Thread.sleep(5000);
        return new TransactionStatusPageAction(driver);
    }
}
