package PageActions;

import Base.TestBase;
import PageLocators.Homepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageAction extends TestBase {

    WebDriver driver;
    Homepage homepage;

    public HomePageAction(WebDriver driver){
        this.driver= driver;
        homepage = new Homepage(driver);
    }

    public String getHomePageTitle(){
        Log.info("Getting the title of the WebPage");
        String title = driver.getTitle();
        return title;
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
