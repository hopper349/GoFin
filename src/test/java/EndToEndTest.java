import Base.TestBase;
import PageActions.*;
import PageLocators.TransactionStatusPage;
import Reports.ExtentReportsSetup;
import Utilities.FileReaderManager;
import Utilities.Json;
import Utilities.TestUtil;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class EndToEndTest extends TestBase {

    WebDriver driver;
    HomePageAction homePageAction;
    ShoppingCartAction shoppingCartAction;
    OrderSummaryAction orderSummaryAction;
    SelectPaymentPageAction selectPaymentPageAction;
    CreditDebitCardPageAction creditDebitCardPageAction;
    TransactionPageAction transactionPageAction;
    TransactionStatusPageAction transactionStatusPageAction;
    TestUtil testUtil;


    public EndToEndTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        driver = initialization();
        homePageAction = new HomePageAction(driver);
        testUtil = new TestUtil(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void validateSuccessfulPurchase() throws InterruptedException, IOException {

        Json jsons= FileReaderManager.getInstance().getJsonDataReader().getJsonByName("validateSuccessfulPurchase");
        System.out.println(jsons.testData.city);

        Json js= FileReaderManager.getInstance().getJsonDataReader().getJsonByName("validateSuccessfulPurchase");
        System.out.println(jsons.testData.phone);

        extentTest.log(Status.INFO, "Validating the Home Page Title");
        homePageAction.validateHomePageTitle();
        extentTest.log(Status.PASS, "Homepage Title Successfully Validated");

        extentTest.log(Status.INFO, "Clicking on BuyNow Btn");
        shoppingCartAction = homePageAction.clickOnBuyNow();

        extentTest.log(Status.INFO, "Validating if Shopping Cart Header is Displayed");
        Assert.assertTrue(shoppingCartAction.getShoppingCartHeader().isDisplayed());
        extentTest.log(Status.PASS, "Shopping Cart Header is Displayed");

        extentTest.log(Status.INFO, "Clicking on Checkout Button");
        orderSummaryAction = shoppingCartAction.clickOnCheckout();


        //orderSummaryAction.clickOnShippingDetailsTab();
        extentTest.log(Status.INFO, "Clicking on Continue Button");
        selectPaymentPageAction = orderSummaryAction.clickOnContinue();

        extentTest.log(Status.INFO, "Clicking on Credit/Debit Payment Method");
        creditDebitCardPageAction = selectPaymentPageAction.selectCreditDebitPaymentMethod();

        extentTest.log(Status.INFO, "Entering Card Details");
        creditDebitCardPageAction.enterCardDetails("validateSuccessfulPurchase");

        extentTest.log(Status.INFO, "Clicking on Pay Now Button");
        transactionPageAction = creditDebitCardPageAction.clickOnPayNowBtn();

        extentTest.log(Status.INFO, "Entering the password");
        transactionPageAction.enterPassword("validateSuccessfulPurchase");
        extentTest.log(Status.INFO, "Clicking on OK Button");
        transactionStatusPageAction = transactionPageAction.clickOnOKButton();

        Thread.sleep(2000);
        testUtil.switchToDefaultContent();

        extentTest.log(Status.INFO, "Clicking on Transaction Success Message");
        Assert.assertTrue(homePageAction.validatePaymentSuccessMessage().isDisplayed());
        extentTest.pass("Transaction Message is Displayed Successfully.");
    }

    @Test(priority = 2, enabled = true)
    public void validateUnSuccessfulPurchase() throws InterruptedException {

        extentTest.log(Status.INFO, "Validating the Home Page Title");
        homePageAction.validateHomePageTitle();
        extentTest.log(Status.PASS, "Homepage Title Successfully Validated");

        extentTest.log(Status.INFO, "Clicking on BuyNow Btn");
        shoppingCartAction = homePageAction.clickOnBuyNow();

        extentTest.log(Status.INFO, "Validating if Shopping Cart Header is Displayed");
        Assert.assertTrue(shoppingCartAction.getShoppingCartHeader().isDisplayed());
        extentTest.log(Status.PASS, "Shopping Cart Header is Displayed");

        extentTest.log(Status.INFO, "Clicking on Checkout Button");
        orderSummaryAction = shoppingCartAction.clickOnCheckout();

        extentTest.log(Status.INFO, "Clicking on Shipping Details Button");
        orderSummaryAction.clickOnShippingDetailsTab();

        extentTest.log(Status.INFO, "Clicking on Continue Button");
        selectPaymentPageAction = orderSummaryAction.clickOnContinue();

        extentTest.log(Status.INFO, "Selecting Credit/Debit Card Payment Method");
        creditDebitCardPageAction = selectPaymentPageAction.selectCreditDebitPaymentMethod();

        extentTest.log(Status.INFO, "Entering the Card Details");
        creditDebitCardPageAction.enterCardDetails("validateUnSuccessfulPurchase");

        extentTest.log(Status.INFO, "Clicking on Pay Now Button");
        transactionPageAction = creditDebitCardPageAction.clickOnPayNowBtn();

        extentTest.log(Status.INFO, "Entering Password and clicking on OK Button");
        transactionPageAction.enterPassword("validateUnSuccessfulPurchase");
        transactionStatusPageAction = transactionPageAction.clickOnOKButton();

        extentTest.log(Status.INFO, "Validating Unsuccessful Transaction");
        transactionStatusPageAction.validateUnsuccessfulTransaction();
        extentTest.pass("Successfully Validated");
    }

}
