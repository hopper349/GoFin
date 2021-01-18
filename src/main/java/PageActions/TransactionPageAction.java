package PageActions;

import Base.TestBase;
import PageLocators.TransactionPage;
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
        //testUtil.waitUntilElementIsVisible(transactionPage.getFrame());
        testUtil.switchToFrame(transactionPage.getFrame());
    }

    public WebElement getTransactionPageHeader() throws InterruptedException {
        return transactionPage.getIssuingBankHeader();
    }

    public void enterPassword() {
        transactionPage.getPasswordField().sendKeys("112233");
    }

    public void clickOnOKButton() {
        transactionPage.getOkBtn().click();
        testUtil.switchToDefaultContent();
    }
}
