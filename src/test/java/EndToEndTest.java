import Base.TestBase;
import PageActions.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EndToEndTest extends TestBase {

    WebDriver driver;
    HomePageAction homePageAction;
    ShoppingCartAction shoppingCartAction;
    OrderSummaryAction orderSummaryAction;
    SelectPaymentPageAction selectPaymentPageAction;
    CreditDebitCardPageAction creditDebitCardPageAction;
    TransactionPageAction transactionPageAction;

    public EndToEndTest(){
        super();
    }

    @BeforeTest
    public void setUp(){
        driver = initialization();
        homePageAction = new HomePageAction(driver);
    }

    @Test
    public void validateSuccessfulPurchase() throws InterruptedException {


        Assert.assertEquals(homePageAction.getHomePageTitle(),"Sample Store");
        shoppingCartAction = homePageAction.clickOnBuyNow();
        System.out.println(shoppingCartAction.getShoppingCartHeader().isDisplayed());
        Assert.assertTrue(shoppingCartAction.getShoppingCartHeader().isDisplayed());
        //shoppingCartAction.enterCustomerDetails();

        orderSummaryAction = shoppingCartAction.clickOnCheckout();
        System.out.println(orderSummaryAction.getOrderSummaryHeader().getText());
        orderSummaryAction.clickOnShippingDetailsTab();

        selectPaymentPageAction = orderSummaryAction.clickOnContinue();
        System.out.println(selectPaymentPageAction.getSelectPaymentHeader().getText());
        creditDebitCardPageAction = selectPaymentPageAction.selectCreditDebitPaymentMethod();

        System.out.println(creditDebitCardPageAction.getCreditDebitCardHeader().getText());
        creditDebitCardPageAction.enterCardDetails();

        transactionPageAction = creditDebitCardPageAction.clickOnPayNowBtn();

        System.out.println(transactionPageAction.getTransactionPageHeader().getText());
        transactionPageAction.enterPassword();
        transactionPageAction.clickOnOKButton();

        Thread.sleep(5000);
        Assert.assertTrue(homePageAction.validatePaymentSuccessMessage().isDisplayed());
    }

}
