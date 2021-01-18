package PageActions;

import Base.TestBase;
import PageLocators.ShoppingCart;
import Utilities.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartAction extends TestBase {

    WebDriver driver;
    ShoppingCart shoppingCart;
    TestUtil testUtil;

    public ShoppingCartAction(WebDriver driver) {
        this.driver = driver;
        shoppingCart = new ShoppingCart(driver);
        testUtil = new TestUtil(driver);
    }

    public WebElement getShoppingCartHeader() {
        return shoppingCart.getShoppingCartHeader();
    }

    public void enterCustomerDetails() throws InterruptedException {


        /*testUtil.sendKeysUsingJSExecutor(shoppingCart.getNameField());
        shoppingCart.getNameField().sendKeys("Dipanshu");
        testUtil.ClearFieldAndProvideText(shoppingCart.getNameField(), "Dipanshu");
        testUtil.ClearFieldAndProvideText(shoppingCart.getEmailField(), "Dipanshu@gmail.com");
        testUtil.ClearFieldAndProvideText(shoppingCart.getPhoneNoField(), "8877887722");
        testUtil.ClearFieldAndProvideText(shoppingCart.getCityField(), "Delhi");
        testUtil.ClearFieldAndProvideText(shoppingCart.getAddressField(), "Chandni Chowk");
        testUtil.ClearFieldAndProvideText(shoppingCart.getPostalCodeField(), "111001");*/
    }

    public OrderSummaryAction clickOnCheckout() {
        shoppingCart.getCheckoutBtn().click();
        return new OrderSummaryAction(driver);
    }

}
