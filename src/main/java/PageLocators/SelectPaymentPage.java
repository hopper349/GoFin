package PageLocators;

import Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectPaymentPage extends TestBase {
    WebDriver driver;


    public SelectPaymentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//p[text()='Select Payment']")
    private WebElement SelectPaymentText;

    @FindBy(xpath = "//div[text()='Credit/Debit Card']/../..")
    private WebElement CreditDebitCardLink;

    //Below are the methods to return WebElements

    public WebElement getSelectPaymentText(){
        return SelectPaymentText;
    }
    public WebElement getCreditDebitCardLink(){
        return CreditDebitCardLink;
    }


}
