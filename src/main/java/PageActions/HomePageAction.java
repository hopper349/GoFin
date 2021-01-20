package PageActions;

import Base.TestBase;
import PageLocators.Homepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePageAction extends TestBase {

    WebDriver driver;
    Homepage homepage;

    public HomePageAction(WebDriver driver){
        this.driver= driver;
        homepage = new Homepage(driver);
    }

    public void validateHomePageTitle(){
        Log.info("Getting the title of the HomePage");
        String title = driver.getTitle();
        Log.info("Validating the title of the HomePage");
        Assert.assertEquals(title,"Sample Store");
    }

    public ShoppingCartAction clickOnBuyNow(){
        Log.info("Clicking on Buy Now Button");
        homepage.getBuyNowBtn().click();
        return new ShoppingCartAction(driver);
    }

    public WebElement validatePaymentSuccessMessage(){
        return homepage.getTransactionSuccessMsg();
    }



}
