package PageLocators;

import Base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Base {

    WebDriver driver;


    public Homepage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[text()='Midtrans Pillow']/following-sibling::a[text()='BUY NOW']")
    private WebElement BuyNowBtn;

    @FindBy(xpath = "//div[@class='trans-status trans-success']")
    private WebElement TransactionSuccessMsg;


    //Below are the methods to return WebElements

    public WebElement getBuyNowBtn(){
        return BuyNowBtn;
    }
    public WebElement getTransactionSuccessMsg(){
        return TransactionSuccessMsg;
    }


}
