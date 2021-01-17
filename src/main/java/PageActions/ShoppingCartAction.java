package PageActions;

import Base.Base;
import PageLocators.Homepage;
import PageLocators.ShoppingCart;
import Utilities.TestUtil;
import org.openqa.selenium.WebDriver;

public class ShoppingCartAction extends Base {

    WebDriver driver;
    ShoppingCart shoppingCart;
    TestUtil testUtil = new TestUtil();

    public ShoppingCartAction(WebDriver driver){
        this.driver = driver;
        shoppingCart = new ShoppingCart(driver);
    }


    public void EnterCustomerDetails(){
        testUtil.ClearFieldAndProvideText(shoppingCart.getNameField(),"Dipanshu");
        testUtil.ClearFieldAndProvideText(shoppingCart.getEmailField(),"Dipanshu@gmail.com");
        testUtil.ClearFieldAndProvideText(shoppingCart.getPhoneNoField(),"8877887722");
        testUtil.ClearFieldAndProvideText(shoppingCart.getCityField(),"Delhi");
        testUtil.ClearFieldAndProvideText(shoppingCart.getAddressField(),"Chandni Chowk");
        testUtil.ClearFieldAndProvideText(shoppingCart.getPostalCodeField(),"111001");
    }

    public void clickOnCheckout(){
        shoppingCart.getCheckoutBtn().click();
    }

}
