package PageActions;

import Base.Base;
import PageLocators.Homepage;
import PageLocators.ShoppingCart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageAction extends Base {

    WebDriver driver;
    Homepage homepage;

    public HomePageAction(WebDriver driver){
        this.driver= driver;
        homepage = new Homepage(driver);
    }

    public String getHomePageTitle(){
        String title = driver.getTitle();
        return title;
    }

    public ShoppingCart clickOnBuyNow(){
        homepage.getBuyNowBtn().click();
        return new ShoppingCart(driver);
    }






}
