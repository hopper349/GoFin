package PageActions;

import Base.TestBase;
import PageLocators.CreditDebitCardPage;
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

    public void enterCardDetails(){
        creditDebitCardPage.getCardNumberField().sendKeys("4811 1111 1111 1114");
        creditDebitCardPage.getExpiryDateField().sendKeys("12/24");
        creditDebitCardPage.getCVVField().sendKeys("123");

    }

    public TransactionPageAction clickOnPayNowBtn() throws InterruptedException {
        creditDebitCardPage.getPayNowBtn().click();
        Thread.sleep(10000);
        return new TransactionPageAction(driver);
    }
}
