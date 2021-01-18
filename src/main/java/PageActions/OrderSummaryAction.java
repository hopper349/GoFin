package PageActions;

import Base.TestBase;
import PageLocators.OrderSummaryPage;
import Utilities.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderSummaryAction extends TestBase {

    WebDriver driver;
    OrderSummaryPage orderSummaryPage;
    TestUtil testUtil;

    public OrderSummaryAction(WebDriver driver){
        this.driver= driver;
        orderSummaryPage = new OrderSummaryPage(driver);
        testUtil = new TestUtil(driver);
        testUtil.switchToFrame(orderSummaryPage.getFrame());
    }

    public WebElement getOrderSummaryHeader() {
        return orderSummaryPage.getOrderSummaryText();
    }

    public SelectPaymentPageAction clickOnContinue(){
        orderSummaryPage.getContinueBtn().click();
        return new SelectPaymentPageAction(driver);
    }

    public void clickOnShippingDetailsTab(){
        orderSummaryPage.getShippingDetailsTab().click();
    }
}
