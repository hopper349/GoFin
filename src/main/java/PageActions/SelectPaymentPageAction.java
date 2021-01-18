package PageActions;

import Base.TestBase;
import PageLocators.SelectPaymentPage;
import Utilities.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectPaymentPageAction extends TestBase {
    WebDriver driver;
    SelectPaymentPage selectPaymentPage;
    TestUtil testUtil;

    public SelectPaymentPageAction(WebDriver driver){
        this.driver= driver;
        selectPaymentPage = new SelectPaymentPage(driver);
        testUtil = new TestUtil(driver);
    }

    public WebElement getSelectPaymentHeader(){
        return selectPaymentPage.getSelectPaymentText();
    }

    public CreditDebitCardPageAction selectCreditDebitPaymentMethod(){
        selectPaymentPage.getCreditDebitCardLink().click();
        return new CreditDebitCardPageAction(driver);
    }
}
